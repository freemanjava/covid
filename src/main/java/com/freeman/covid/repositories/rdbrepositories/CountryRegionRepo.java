//package com.freeman.covid.repositories.rdbrepositories;
//
//import com.freeman.covid.models.CountryRegion;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface CountryRegionRepo extends JpaRepository<CountryRegion, Integer> {
//    CountryRegion findCountryRegionByName(String name);
//
//    @Override
//    <S extends CountryRegion> S save(S s);
//
//    @Override
//    List<CountryRegion> findAll(Sort sort);
//
//    @Override
//    long count();
//
//}
