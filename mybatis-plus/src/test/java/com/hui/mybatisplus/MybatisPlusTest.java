package com.hui.mybatisplus;

import com.hui.mybatisplus.mapper.UserMapper;
import com.hui.mybatisplus.user.User;
import com.hui.mybatisplus.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    /**
     * mapper 测试
     */
    @Test
    public void mapperTest() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    /**
     * service 测试
     */
    @Test
    public void serviceList() {
        List<User> users = userService.list();
        users.forEach(System.out::println);
    }



    @Test
    public void mytest(){
        System.out.println("9533301552(12321)".replaceAll("\\(.*\\)", ""));
        User user = new User();
        user.setAge(20);
        user.setEmail("461321");
        user.setId(123123213123L);
        user.setName("231231231");
        List<User> list = new ArrayList<>();
        list.add(user);
        System.err.println(user);
        list.stream().forEach(x -> x.setName("圣辉"));
        System.err.println(user);
    }




}
