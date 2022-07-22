package org.com.controller;

import org.com.entity.User;
import org.com.service.Service;
import org.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController extends AbstractController<User> {
    @Autowired
    private UserService service;

    @Override
    public Service<User> getService() {
        return service;
    }
}
