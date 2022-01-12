package com.souzawesley.workshopspringmongo.repository;

import com.souzawesley.workshopspringmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
