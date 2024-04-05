package com.OOZone.service;

import com.OOZone.entity.User;

/**
 * 业务接口：站在"使用者"角度设计接口 三个方面：方法定义粒度，参数，返回类型（return 类型/异常）
 * 在这里写方法接口
 */
public interface UserService {
    public User login(User user);
}
