package com.freeman.covid.repositories;

import com.freeman.covid.models.CoronaState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoronaStateRepo extends JpaRepository<CoronaState, Integer> {
}
