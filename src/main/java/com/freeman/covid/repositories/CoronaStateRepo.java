package com.freeman.covid.repositories;

import com.freeman.covid.models.CoronaState;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoronaStateRepo extends MongoRepository <CoronaState, Integer> {
}
