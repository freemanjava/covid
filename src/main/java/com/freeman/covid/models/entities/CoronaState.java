package com.freeman.covid.models.entities;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvRecurse;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Objects;

@Document
public class CoronaState {

    @Id
    private String id;
    @CsvBindByName(column = "Last Update")
    private String lastUpdate;
    @CsvBindByName(column = "Combined_Key")
    private String combinedKey;
    @CsvRecurse
    private CountryRegion countryRegion;

    public CoronaState() {
    }

    public CoronaState(String lastUpdate, String combinedKey, CountryRegion countryRegion) {
        this.lastUpdate = lastUpdate;
        this.combinedKey = combinedKey;
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

    public String getCombinedKey() {
        return combinedKey;
    }

    public void setCombinedKey(String combinedKey) {
        this.combinedKey = combinedKey;
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
                Objects.equals(combinedKey, that.combinedKey) &&
                Objects.equals(countryRegion, that.countryRegion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastUpdate, combinedKey, countryRegion);
    }

    @Override
    public String toString() {
        return "CoronaState{" +
                "id='" + id + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", combinedKey='" + combinedKey + '\'' +
                ", countryRegion=" + countryRegion +
                '}';
    }
}
