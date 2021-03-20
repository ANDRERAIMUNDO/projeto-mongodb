package me.andreraimundo.projetomongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import me.andreraimundo.projetomongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
}
