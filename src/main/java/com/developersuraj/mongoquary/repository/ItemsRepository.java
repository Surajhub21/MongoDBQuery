package com.developersuraj.mongoquary.repository;

import com.developersuraj.mongoquary.model.ItemsData;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemsRepository extends MongoRepository<ItemsData , ObjectId> {

}
