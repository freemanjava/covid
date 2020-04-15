package com.freeman.covid.repositories;

import com.freeman.covid.models.CoronaState;
import com.freeman.covid.models.ProvinceState;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoronaStateRepo extends MongoRepository <CoronaState, Integer> {

    CoronaState findCoronaStateByCountryRegion_Name(String name);
    CoronaState findCoronaStateByCountryRegion_ProvinceState(List<ProvinceState> countryRegion_provinceState);
    Boolean existsCoronaStateByCountryRegion_Name(String name);
    Boolean existsCoronaStateByCountryRegion_ProvinceState(List<ProvinceState> countryRegion_provinceState);

}
