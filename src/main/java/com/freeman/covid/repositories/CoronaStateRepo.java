package com.freeman.covid.repositories;

import com.freeman.covid.models.entities.CoronaState;
import com.freeman.covid.models.entities.ProvinceState;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoronaStateRepo extends MongoRepository <CoronaState, String> {

    CoronaState findCoronaStateByCountryRegion_CountryRegion(String name);
    CoronaState findCoronaStateByCountryRegion_ProvinceState(List<ProvinceState> countryRegion_provinceState);
    Boolean existsCoronaStateByCountryRegion_CountryRegion(String name);
    Boolean existsCoronaStateByCountryRegion_ProvinceState(List<ProvinceState> countryRegion_provinceState);

}
