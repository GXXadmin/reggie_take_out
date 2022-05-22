package com.gxx.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gxx.reggie.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
