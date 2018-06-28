package com.jeremydwayne.myretail;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "price", path = "price")
public interface PriceRepository extends MongoRepository<Price, String> {
}
