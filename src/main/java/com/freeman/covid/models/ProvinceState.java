package com.freeman.covid.models;

import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;
import java.util.Objects;

//@Document
public class ProvinceState {

    @Id
    private String id;
    private String name;
    private String lastUpdate;
    private GeoPoint geoPoint;
    private StatisticBySick statisticBySick;

    public ProvinceState() {
    }

    public ProvinceState(String name, String lastUpdate, GeoPoint geoPoint, StatisticBySick statisticBySick) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                Objects.equals(name, that.name) &&
                Objects.equals(lastUpdate, that.lastUpdate) &&
                Objects.equals(geoPoint, that.geoPoint) &&
                Objects.equals(statisticBySick, that.statisticBySick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastUpdate, geoPoint, statisticBySick);
    }

    @Override
    public String toString() {
        return "ProvinceState{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", geoPoint=" + geoPoint +
                ", statisticBySick=" + statisticBySick +
                '}';
    }
}
