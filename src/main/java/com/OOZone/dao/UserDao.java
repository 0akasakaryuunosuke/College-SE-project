package com.OOZone.dao;

import java.util.List;
import java.util.Map;
import com.OOZone.entity.User;

/*
* 数据库用户方法---增删改查之类的*/
public interface UserDao {
    public User login(User user);
    public User register(User user);
}
