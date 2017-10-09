package com.xxxx.jpa.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.xxxx.jpa.domain.Enterprise;

@Repository
public interface EnterpriseRepo extends MongoRepository<Enterprise,Integer> {

}
