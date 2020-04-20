package com.freeman.covid.models.entities;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvRecurse;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Objects;

@Document
public class ProvinceState {

    @Id
    private String id;
    @CsvBindByName(column = "Province/State")
    private String provinceState;
    @CsvBindByName(column = "Admin2")
    private String city; //Admins2
    @CsvBindByName(column = "FIPS")
    private String FIPS;
    @CsvBindByName(column = "Last Update")
    private String lastUpdate;
    @CsvRecurse
    private GeoPoint geoPoint;
    @CsvRecurse
    private StatisticBySick statisticBySick;

    public ProvinceState() {
    }

    public ProvinceState(String provinceState, String city, String FIPS, String lastUpdate, GeoPoint geoPoint, StatisticBySick statisticBySick) {
        this.provinceState = provinceState;
        this.city = city;
        this.FIPS = FIPS;
        this.lastUpdate = lastUpdate;
        this.geoPoint = geoPoint;
        this.statisticBySick = statisticBySick;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvinceState() {
        return provinceState;
    }

    public void setProvinceState(String provinceState) {
        this.provinceState = provinceState;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFIPS() {
        return FIPS;
    }

    public void setFIPS(String FIPS) {
        this.FIPS = FIPS;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public GeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.geoPoint = geoPoint;
    }

    public StatisticBySick getStatisticBySick() {
        return statisticBySick;
    }

    public void setStatisticBySick(StatisticBySick statisticBySick) {
        this.statisticBySick = statisticBySick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProvinceState)) return false;
        ProvinceState that = (ProvinceState) o;
        return id.equals(that.id) &&
                Objects.equals(provinceState, that.provinceState) &&
                Objects.equals(city, that.city) &&
                Objects.equals(FIPS, that.FIPS) &&
                Objects.equals(lastUpdate, that.lastUpdate) &&
                Objects.equals(geoPoint, that.geoPoint) &&
                Objects.equals(statisticBySick, that.statisticBySick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, provinceState, city, FIPS, lastUpdate, geoPoint, statisticBySick);
    }

    @Override
    public String toString() {
        return "ProvinceState{" +
                "id='" + id + '\'' +
                ", provinceState='" + provinceState + '\'' +
                ", city='" + city + '\'' +
                ", FIPS='" + FIPS + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", geoPoint=" + geoPoint +
                ", statisticBySick=" + statisticBySick +
                '}';
    }
}
