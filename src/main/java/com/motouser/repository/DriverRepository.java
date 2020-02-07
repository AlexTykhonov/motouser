package com.motouser.repository;

import com.motouser.model.Driver;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository  extends ReactiveMongoRepository<Driver, String> {

    }
