package com.mdss.workshopmongodb.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mdss.workshopmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	@Query("{'title': {$regex: ?0, $optiions: 'i' }}")
	public List<Post> searchTitle(String text);
		
	public List<Post>findByTitleContainingIgnoreCase(String text);
	
	@Query("{$and:[{date: {$gte: ?1} },{date: {$lte: ?2} }, {$or: [ {'title': {$regex: ?0, $optiions: 'i' }}, {'body': {$regex: ?0, $optiions: 'i' }}, {'comments.text': {$regex: ?0, $optiions: 'i' }} ]}]}")
	public List<Post> fullSearch(String text, Date minDate, Date maxDate);
	
}
