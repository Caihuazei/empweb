package com.liu.mapper;

import com.liu.entity.User;

public interface UserMapper {
    User listUserByName(String name);
}
