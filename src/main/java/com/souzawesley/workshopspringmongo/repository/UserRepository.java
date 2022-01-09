package com.souzawesley.workshopspringmongo.repository;

import com.souzawesley.workshopspringmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {



}
