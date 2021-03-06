package com.freeman.covid.models.dto;

import com.freeman.covid.annotations.fieldmapper.FieldMappingByName;

public class CoronaStateDTO {

    @FieldMappingByName(header = "Combined_Key")
    private String combinedKey;
    @FieldMappingByName(header = "Country/Region|Country_Region")
    private String countryRegion;
    @FieldMappingByName(header = "Province/State|Province_State")
    private String provinceState;
    @FieldMappingByName(header = "Admin2")
    private String city; //Admins2
    @FieldMappingByName(header = "FIPS")
    private String FIPS;
    @FieldMappingByName(header = "Last Update|Last_Update")
    private String lastUpdate;
    @FieldMappingByName(header = "Latitude|Lat")
    private String latitude;
    @FieldMappingByName(header = "Longitude|Long_")
    private String longitude;
    @FieldMappingByName(header = "Confirmed")
    private Integer confirmedQuantity;
    @FieldMappingByName(header = "Deaths")
    private Integer deathsQuantity;
    @FieldMappingByName(header = "Recovered")
    private Integer recoveredQuantity;
    @FieldMappingByName(header = "Active")
    private Integer active;

    public CoronaStateDTO() {
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
