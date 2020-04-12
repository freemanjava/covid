package com.freeman.covid.repositories;

import com.freeman.covid.models.DetectionPlace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetectionPlaceRepo extends CrudRepository<DetectionPlace, Integer> {
}
