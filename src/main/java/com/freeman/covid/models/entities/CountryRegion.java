package com.freeman.covid.models.entities;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

@Document
public class CountryRegion {

    @Id
    private String id;
    @CsvBindByName(column = "Country/Region")
    private String countryRegion;
//    @CsvRecurse
    @CsvBindAndSplitByName(elementType = ProvinceState.class)
    private List<ProvinceState> provinceState;

    public CountryRegion() {
    }

    public CountryRegion(String countryRegion, List<ProvinceState> provinceState) {
        this.countryRegion = countryRegion;
        this.provinceState = provinceState;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
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
                Objects.equals(countryRegion, that.countryRegion) &&
                Objects.equals(provinceState, that.provinceState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countryRegion, provinceState);
    }

    @Override
    public String toString() {
        return "CountryRegion{" +
                "id='" + id + '\'' +
                ", name='" + countryRegion + '\'' +
                ", provinceState=" + provinceState +
                '}';
    }
}
