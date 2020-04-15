package com.freeman.covid.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

//@Document
public class CountryRegion {

    @Id
    private String id;
    private String name;
    private List<ProvinceState> provinceState;

    public CountryRegion() {
    }

    public CountryRegion(String name, List<ProvinceState> provinceState) {
        this.name = name;
        this.provinceState = provinceState;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProvinceState> getProvinceState() {
        return provinceState;
    }

    public void setProvinceState(List<ProvinceState> provinceState) {
        this.provinceState = provinceState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryRegion)) return false;
        CountryRegion that = (CountryRegion) o;
        return id.equals(that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(provinceState, that.provinceState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, provinceState);
    }

    @Override
    public String toString() {
        return "CountryRegion{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", provinceState=" + provinceState +
                '}';
    }
}
