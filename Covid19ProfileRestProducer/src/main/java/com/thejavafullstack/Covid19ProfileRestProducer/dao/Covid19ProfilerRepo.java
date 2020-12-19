package com.thejavafullstack.Covid19ProfileRestProducer.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Covid19ProfilerRepo extends CrudRepository<Covid19ProfileDto,String> {
}