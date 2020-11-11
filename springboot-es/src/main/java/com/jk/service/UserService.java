package com.jk.service;

import com.jk.entity.Users;

import java.util.List;

public interface UserService {

    void addUser();

    List<Users> findAll();

}
