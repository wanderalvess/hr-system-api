package br.com.wanderalvess.userapi.resources.impl;

import br.com.wanderalvess.userapi.domain.User;
import br.com.wanderalvess.userapi.resources.UserResource;
import br.com.wanderalvess.userapi.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserResourceImpl implements UserResource {

    private final UserService service;

    public UserResourceImpl(UserService service) {
        this.service = service;
    }


    @Override
    public ResponseEntity<User> findById(Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @Override
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
}
