package com.souzawesley.workshopspringmongo.resources;

import com.souzawesley.workshopspringmongo.domain.Post;
import com.souzawesley.workshopspringmongo.domain.User;
import com.souzawesley.workshopspringmongo.dto.UserDTO;
import com.souzawesley.workshopspringmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<UserDTO> findOne(@PathVariable String id) {
        User obj = service.findById(id);

        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @RequestMapping(method = POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
        User obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}/posts", method = GET)
    public ResponseEntity<List<Post>> findPost(@PathVariable String id) {
        User obj = service.findById(id);

        return ResponseEntity.ok().body(obj.getPosts());
    }

}
