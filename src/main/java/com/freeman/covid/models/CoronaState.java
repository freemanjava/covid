package com.freeman.covid.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class CoronaState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lastUpdate;
    private Integer confirmedQuantity;
    private Integer deathsQuantity;
    private Integer recoveredQuantity;
    @OneToOne(cascade = {CascadeType.ALL})
    private DetectionPlace detectionPlace;

    public CoronaState() {
    }

    public CoronaState(String lastUpdate, Integer confirmedQuantity,
                       Integer deathsQuantity, Integer recoveredQuantity,
                       DetectionPlace detectionPlace) {
        this.lastUpdate = lastUpdate;
        this.confirmedQuantity = confirmedQuantity;
        this.deathsQuantity = deathsQuantity;
        this.recoveredQuantity = recoveredQuantity;
        this.detectionPlace = detectionPlace;
    }

    public CoronaState(Integer id, String lastUpdate,
                       Integer confirmedQuantity, Integer deathsQuantity,
                       Integer recoveredQuantity, DetectionPlace detectionPlace) {
        this.id = id;
        this.lastUpdate = lastUpdate;
        this.confirmedQuantity = confirmedQuantity;
        this.deathsQuantity = deathsQuantity;
        this.recoveredQuantity = recoveredQuantity;
        this.detectionPlace = detectionPlace;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getConfirmedQuantity() {
        return confirmedQuantity;
    }

    public void setConfirmedQuantity(Integer confirmedQuantity) {
        this.confirmedQuantity = confirmedQuantity;
    }

    public Integer getDeathsQuantity() {
        return deathsQuantity;
    }

    public void setDeathsQuantity(Integer deathsQuantity) {
        this.deathsQuantity = deathsQuantity;
    }

    public Integer getRecoveredQuantity() {
        return recoveredQuantity;
    }

    public void setRecoveredQuantity(Integer recoveredQuantity) {
        this.recoveredQuantity = recoveredQuantity;
    }

    public DetectionPlace getDetectionPlace() {
        return detectionPlace;
    }

    public void setDetectionPlace(DetectionPlace detectionPlace) {
        this.detectionPlace = detectionPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoronaState)) return false;
        CoronaState that = (CoronaState) o;
        return id.equals(that.id) &&
                Objects.equals(lastUpdate, that.lastUpdate) &&
                Objects.equals(confirmedQuantity, that.confirmedQuantity) &&
                Objects.equals(deathsQuantity, that.deathsQuantity) &&
                Objects.equals(recoveredQuantity, that.recoveredQuantity) &&
                Objects.equals(detectionPlace, that.detectionPlace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastUpdate, confirmedQuantity, deathsQuantity, recoveredQuantity, detectionPlace);
    }

    @Override
    public String toString() {
        return "CoronaState{" +
                "id=" + id +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", confirmedQuantity=" + confirmedQuantity +
                ", deathsQuantity=" + deathsQuantity +
                ", recoveredQuantity=" + recoveredQuantity +
                ", detectionPlace=" + detectionPlace +
                '}';
    }
}
