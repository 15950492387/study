package com.hui.mybatisplus;

import com.hui.mybatisplus.mapper.UserMapper;
import com.hui.mybatisplus.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void test() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

}
