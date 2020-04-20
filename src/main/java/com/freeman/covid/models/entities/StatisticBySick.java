package com.freeman.covid.models.entities;

import com.opencsv.bean.CsvBindByName;

import java.util.Objects;

public class StatisticBySick {

    @CsvBindByName(column = "Confirmed")
    private Integer confirmedQuantity;
    @CsvBindByName(column = "Deaths")
    private Integer deathsQuantity;
    @CsvBindByName(column = "Recovered")
    private Integer recoveredQuantity;
    @CsvBindByName(column = "Active")
    private Integer active;

    public StatisticBySick() {
    }

    public StatisticBySick(Integer confirmedQuantity, Integer deathsQuantity, Integer recoveredQuantity, Integer active) {
        this.confirmedQuantity = confirmedQuantity;
        this.deathsQuantity = deathsQuantity;
        this.recoveredQuantity = recoveredQuantity;
        this.active = active;
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

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatisticBySick)) return false;
        StatisticBySick statistic = (StatisticBySick) o;
        return Objects.equals(confirmedQuantity, statistic.confirmedQuantity) &&
                Objects.equals(deathsQuantity, statistic.deathsQuantity) &&
                Objects.equals(recoveredQuantity, statistic.recoveredQuantity) &&
                Objects.equals(active, statistic.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(confirmedQuantity, deathsQuantity, recoveredQuantity, active);
    }

    @Override
    public String toString() {
        return "StatisticBySick{" +
                "confirmedQuantity=" + confirmedQuantity +
                ", deathsQuantity=" + deathsQuantity +
                ", recoveredQuantity=" + recoveredQuantity +
                ", active=" + active +
                '}';
    }
}

