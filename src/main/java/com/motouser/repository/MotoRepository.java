package com.motouser.repository;

import com.motouser.model.Moto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends ReactiveMongoRepository <Moto, String> {

}
