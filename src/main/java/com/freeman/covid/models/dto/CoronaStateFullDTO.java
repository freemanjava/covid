package com.freeman.covid.models.dto;

import com.opencsv.bean.CsvBindByName;

public class CoronaStateFullDTO {

    @CsvBindByName(column = "Combined_Key")
    private String combinedKey;
    @CsvBindByName(column = "Country/Region")
//    @CsvBindByName(column = "Country/Region|Country_Region")
    private String countryRegion;
    @CsvBindByName(column = "Province/State")
//    @CsvBindByName(column = "Province/State|Province_State")
    private String provinceState;
    @CsvBindByName(column = "Admin2")
    private String city;
    @CsvBindByName(column = "FIPS")
    private String FIPS;
    @CsvBindByName(column = "Last Update")
//    @CsvBindByName(column = "Last Update|Last_Update")
    private String lastUpdate;
    @CsvBindByName(column = "Latitude")
//    @CsvBindByName(column = "Latitude|Lat")
    private String latitude;
    @CsvBindByName(column = "Longitude")
//    @CsvBindByName(column = "Longitude|Long_")
    private String longitude;
    @CsvBindByName(column = "Confirmed")
    private Integer confirmedQuantity;
    @CsvBindByName(column = "Deaths")
    private Integer deathsQuantity;
    @CsvBindByName(column = "Recovered")
    private Integer recoveredQuantity;
    @CsvBindByName(column = "Active")
    private Integer active;

    public CoronaStateFullDTO() {
    }

    public String getCombinedKey() {
        return combinedKey;
    }

    public void setCombinedKey(String combinedKey) {
        this.combinedKey = combinedKey;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
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
}
