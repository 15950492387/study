package com.hui.mybatisplus.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.mybatisplus.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
}
