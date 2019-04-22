package com.forget.simple.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.forget.simple.models.bookInfo;

public interface bookInfoRepository extends MongoRepository<bookInfo, String> {
	bookInfo findBy_id(ObjectId _id);
}