package br.com.wanderalvess.userapi.services.impl;

import br.com.wanderalvess.userapi.domain.User;
import br.com.wanderalvess.userapi.repositories.UserRepository;
import br.com.wanderalvess.userapi.services.UserService;
import br.com.wanderalvess.userapi.services.exceptions.ObjectNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final Environment env;
    private final UserRepository repository;

    //Constructor
    public UserServiceImpl(Environment env, UserRepository repository) {
        this.env = env;
        this.repository = repository;
    }

    @Override
    public User findById(Long id) {
        log.info("USER_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port" );
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
