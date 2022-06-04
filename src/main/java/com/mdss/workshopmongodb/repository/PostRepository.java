package com.mdss.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mdss.workshopmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
}
