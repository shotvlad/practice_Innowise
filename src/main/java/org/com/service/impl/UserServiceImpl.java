package org.com.service.impl;

import org.com.entity.User;
import org.com.repository.UserRepository;
import org.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<User> read() {
        return repository.findAll();
    }

    @Override
    public void save(User entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(User entity) {
        User user = repository.findById(entity.getId()).orElseThrow(IllegalArgumentException::new);
        user.setMail(entity.getMail());
        user.setAuthority(entity.getAuthority());
        user.setUsername(entity.getUsername());
        user.setPassword(entity.getPassword());
        repository.save(user);
    }
}
