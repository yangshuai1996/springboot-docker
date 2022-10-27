package com.estone.it.service.impl;

import com.alibaba.fastjson.JSON;
import com.estone.it.entity.User;
import com.estone.it.mapper.UserMapper;
import com.estone.it.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public List<User> findList() {
        String value = stringRedisTemplate.opsForValue().get("user.list");
        List<User> result = null;
        if(Objects.isNull(value)){
            result = userMapper.selectList(null);
            stringRedisTemplate.opsForValue().set("user.list", JSON.toJSONString(result),5, TimeUnit.SECONDS);
            log.info("查询数据并将结果保存到redis中。。。。。。");
        }else {
            result = JSON.parseArray(value,User.class);
        }
        return result;
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        if(Objects.isNull(user.getId())){
            throw new RuntimeException("主键ID不能为空");
        }
        User oldUser = userMapper.selectById(user.getId());
        if(oldUser != null){
            userMapper.updateById(user);
        }else{
            throw new RuntimeException("不存在当前用户");
        }
    }
}
