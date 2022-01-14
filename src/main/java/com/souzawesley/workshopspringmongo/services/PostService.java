package com.souzawesley.workshopspringmongo.services;

import com.souzawesley.workshopspringmongo.domain.Post;
import com.souzawesley.workshopspringmongo.domain.User;
import com.souzawesley.workshopspringmongo.dto.UserDTO;
import com.souzawesley.workshopspringmongo.repository.PostRepository;
import com.souzawesley.workshopspringmongo.repository.UserRepository;
import com.souzawesley.workshopspringmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public PostService(PostRepository repo) {
        this.repo = repo;
    }

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
