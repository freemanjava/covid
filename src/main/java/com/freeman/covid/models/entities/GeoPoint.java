package com.freeman.covid.models.entities;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.Id;
import java.util.Objects;

//@Entity
//@Document
public class GeoPoint {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @CsvBindByName(column = "Latitude")
    private String latitude;
    @CsvBindByName(column = "Longitude")
    private String longitude;

    public GeoPoint() {
    }

    public GeoPoint(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeoPoint)) return false;
        GeoPoint geoPoint = (GeoPoint) o;
        return id.equals(geoPoint.id) &&
                Objects.equals(latitude, geoPoint.latitude) &&
                Objects.equals(longitude, geoPoint.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, latitude, longitude);
    }

    @Override
    public String toString() {
        return "GeoPoint{" +
                "id=" + id +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
