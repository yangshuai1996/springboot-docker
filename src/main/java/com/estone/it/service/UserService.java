package com.estone.it.service;

import com.estone.it.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 查询列表
     * @return
     */
    List<User> findList();

    /**
     * 保存用户
     * @param user
     */
    void addUser(User user);

    void updateUser(User user);
}
