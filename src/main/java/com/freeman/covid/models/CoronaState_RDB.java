//package com.freeman.covid.models;
//
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import javax.persistence.*;
//import java.util.Objects;
//
////@Entity
//@Document
//public class CoronaState_RDB {
//
//    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String id;
//    private String lastUpdate;
//    private Integer confirmedQuantity;
//    private Integer deathsQuantity;
//    private Integer recoveredQuantity;
////    @OneToOne(cascade = {CascadeType.ALL})
////    @Field
//    private DetectionPlace detectionPlace;
//
//    public CoronaState_RDB() {
//    }
//
//    public CoronaState_RDB(String lastUpdate, Integer confirmedQuantity,
//                           Integer deathsQuantity, Integer recoveredQuantity,
//                           DetectionPlace detectionPlace) {
//        this.lastUpdate = lastUpdate;
//        this.confirmedQuantity = confirmedQuantity;
//        this.deathsQuantity = deathsQuantity;
//        this.recoveredQuantity = recoveredQuantity;
//        this.detectionPlace = detectionPlace;
//    }
//
//    public CoronaState_RDB(String id, String lastUpdate,
//                           Integer confirmedQuantity, Integer deathsQuantity,
//                           Integer recoveredQuantity, DetectionPlace detectionPlace) {
//        this.id = id;
//        this.lastUpdate = lastUpdate;
//        this.confirmedQuantity = confirmedQuantity;
//        this.deathsQuantity = deathsQuantity;
//        this.recoveredQuantity = recoveredQuantity;
//        this.detectionPlace = detectionPlace;
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
//    public String getLastUpdate() {
//        return lastUpdate;
//    }
//
//    public void setLastUpdate(String lastUpdate) {
//        this.lastUpdate = lastUpdate;
//    }
//
//    public Integer getConfirmedQuantity() {
//        return confirmedQuantity;
//    }
//
//    public void setConfirmedQuantity(Integer confirmedQuantity) {
//        this.confirmedQuantity = confirmedQuantity;
//    }
//
//    public Integer getDeathsQuantity() {
//        return deathsQuantity;
//    }
//
//    public void setDeathsQuantity(Integer deathsQuantity) {
//        this.deathsQuantity = deathsQuantity;
//    }
//
//    public Integer getRecoveredQuantity() {
//        return recoveredQuantity;
//    }
//
//    public void setRecoveredQuantity(Integer recoveredQuantity) {
//        this.recoveredQuantity = recoveredQuantity;
//    }
//
//    public DetectionPlace getDetectionPlace() {
//        return detectionPlace;
//    }
//
//    public void setDetectionPlace(DetectionPlace detectionPlace) {
//        this.detectionPlace = detectionPlace;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof CoronaState_RDB)) return false;
//        CoronaState_RDB that = (CoronaState_RDB) o;
//        return id.equals(that.id) &&
//                Objects.equals(lastUpdate, that.lastUpdate) &&
//                Objects.equals(confirmedQuantity, that.confirmedQuantity) &&
//                Objects.equals(deathsQuantity, that.deathsQuantity) &&
//                Objects.equals(recoveredQuantity, that.recoveredQuantity) &&
//                Objects.equals(detectionPlace, that.detectionPlace);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, lastUpdate, confirmedQuantity, deathsQuantity, recoveredQuantity, detectionPlace);
//    }
//
//    @Override
//    public String toString() {
//        return "CoronaState{" +
//                "id=" + id +
//                ", lastUpdate='" + lastUpdate + '\'' +
//                ", confirmedQuantity=" + confirmedQuantity +
//                ", deathsQuantity=" + deathsQuantity +
//                ", recoveredQuantity=" + recoveredQuantity +
//                ", detectionPlace=" + detectionPlace +
//                '}';
//    }
//}
