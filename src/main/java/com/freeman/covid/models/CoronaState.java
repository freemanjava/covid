package com.freeman.covid.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Objects;

@Document
public class CoronaState {

    @Id
    private String id;
    private String lastUpdate;
    private CountryRegion countryRegion;

    public CoronaState() {
    }

    public CoronaState(String lastUpdate, CountryRegion countryRegion) {
        this.lastUpdate = lastUpdate;
        this.countryRegion = countryRegion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public CountryRegion getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(CountryRegion countryRegion) {
        this.countryRegion = countryRegion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoronaState)) return false;
        CoronaState that = (CoronaState) o;
        return id.equals(that.id) &&
                Objects.equals(lastUpdate, that.lastUpdate) &&
                Objects.equals(countryRegion, that.countryRegion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastUpdate, countryRegion);
    }

    @Override
    public String toString() {
        return "CoronaState{" +
                "id='" + id + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", countryRegion=" + countryRegion +
                '}';
    }
}
