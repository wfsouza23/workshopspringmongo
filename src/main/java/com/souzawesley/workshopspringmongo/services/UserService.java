package com.souzawesley.workshopspringmongo.services;

import com.souzawesley.workshopspringmongo.domain.User;
import com.souzawesley.workshopspringmongo.repository.UserRepository;
import com.souzawesley.workshopspringmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> findAll(){
        return repo.findAll();
    }
/*
    public User findById(String id){
        User user = repo.findOne(id);
        if (user == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }

 */
}
