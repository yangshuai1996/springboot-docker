package com.estone.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.estone.it.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
