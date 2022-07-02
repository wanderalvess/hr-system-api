package br.com.wanderalvess.userapi.services;

import br.com.wanderalvess.userapi.domain.User;

import java.util.List;

public interface UserService {

    User findById(Long id);
    List<User> findAll();
}
