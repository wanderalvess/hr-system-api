package br.com.wanderalvess.userapi.services.impl;

import br.com.wanderalvess.userapi.domain.User;
import br.com.wanderalvess.userapi.repositories.UserRepository;
import br.com.wanderalvess.userapi.services.UserService;
import br.com.wanderalvess.userapi.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    //Constructor
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
