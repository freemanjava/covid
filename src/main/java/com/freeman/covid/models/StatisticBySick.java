package com.freeman.covid.models;

import java.util.Objects;

public class StatisticBySick {

    private Integer confirmedQuantity;
    private Integer deathsQuantity;
    private Integer recoveredQuantity;

    public StatisticBySick() {
    }

    public StatisticBySick(Integer confirmedQuantity, Integer deathsQuantity, Integer recoveredQuantity) {
        this.confirmedQuantity = confirmedQuantity;
        this.deathsQuantity = deathsQuantity;
        this.recoveredQuantity = recoveredQuantity;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatisticBySick)) return false;
        StatisticBySick that = (StatisticBySick) o;
        return Objects.equals(confirmedQuantity, that.confirmedQuantity) &&
                Objects.equals(deathsQuantity, that.deathsQuantity) &&
                Objects.equals(recoveredQuantity, that.recoveredQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(confirmedQuantity, deathsQuantity, recoveredQuantity);
    }

    @Override
    public String toString() {
        return "StatisticBySick{" +
                "confirmedQuantity=" + confirmedQuantity +
                ", deathsQuantity=" + deathsQuantity +
                ", recoveredQuantity=" + recoveredQuantity +
                '}';
    }
}

