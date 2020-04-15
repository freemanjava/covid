//package com.freeman.covid.models;
//
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Field;
//
//import javax.persistence.*;
//import java.util.Objects;
//
////@Entity
//@Document
//public class DetectionPlace {
//
//    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String id;
////    @OneToOne(cascade = {CascadeType.ALL})
////    @Field
//    private CountryRegion countryRegion;
////    @OneToOne(cascade = {CascadeType.ALL})
////    @Field
//    private ProvinceState provinceState;
////    @OneToOne(cascade = {CascadeType.ALL})
////    @Field
//    private GeoPoint geoPoint;
//
//    public DetectionPlace() {
//    }
//
//    public DetectionPlace(CountryRegion countryRegion, ProvinceState provinceState, GeoPoint geoPoint) {
//        this.countryRegion = countryRegion;
//        this.provinceState = provinceState;
//        this.geoPoint = geoPoint;
//    }
//
//    public DetectionPlace(String id, CountryRegion countryRegion,
//                          ProvinceState provinceState, GeoPoint geoPoint) {
//        this.id = id;
//        this.countryRegion = countryRegion;
//        this.provinceState = provinceState;
//        this.geoPoint = geoPoint;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public CountryRegion getCountryRegion() {
//        return countryRegion;
//    }
//
//    public void setCountryRegion(CountryRegion countryRegion) {
//        this.countryRegion = countryRegion;
//    }
//
//    public ProvinceState getProvinceState() {
//        return provinceState;
//    }
//
//    public void setProvinceState(ProvinceState provinceState) {
//        this.provinceState = provinceState;
//    }
//
//    public GeoPoint getGeoPoint() {
//        return geoPoint;
//    }
//
//    public void setGeoPoint(GeoPoint geoPoint) {
//        this.geoPoint = geoPoint;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof DetectionPlace)) return false;
//        DetectionPlace that = (DetectionPlace) o;
//        return id.equals(that.id) &&
//                Objects.equals(countryRegion, that.countryRegion) &&
//                Objects.equals(provinceState, that.provinceState) &&
//                Objects.equals(geoPoint, that.geoPoint);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, countryRegion, provinceState, geoPoint);
//    }
//
//    @Override
//    public String toString() {
//        return "DetectionPlace{" +
//                "id=" + id +
//                ", countryRegion=" + countryRegion +
//                ", provinceState=" + provinceState +
//                ", geoPoint=" + geoPoint +
//                '}';
//    }
//}
