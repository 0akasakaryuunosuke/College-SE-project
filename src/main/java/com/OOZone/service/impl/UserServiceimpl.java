package com.OOZone.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.OOZone.dao.UserDao;
import com.OOZone.entity.User;
import com.OOZone.service.UserService;

import javax.annotation.Resource;

/*
 * 根据具体dao层和entity层实现接口*/
@Service
public class UserServiceimpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.login(user);
    }
    @Override
    public User register(User user){
        return userDao.register(user);
    }
}
