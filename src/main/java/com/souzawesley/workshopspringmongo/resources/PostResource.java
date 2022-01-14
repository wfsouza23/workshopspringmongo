package com.souzawesley.workshopspringmongo.resources;

import com.souzawesley.workshopspringmongo.domain.Post;
import com.souzawesley.workshopspringmongo.domain.User;
import com.souzawesley.workshopspringmongo.dto.UserDTO;
import com.souzawesley.workshopspringmongo.services.PostService;
import com.souzawesley.workshopspringmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<Post> findOne(@PathVariable String id) {
        Post obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

}
