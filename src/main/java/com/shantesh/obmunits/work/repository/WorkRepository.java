package com.shantesh.obmunits.work.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shantesh.obmunits.work.entity.Work;

public interface WorkRepository extends MongoRepository<Work, String> {
	public List<Work> findByPersonId(String personId);
}
