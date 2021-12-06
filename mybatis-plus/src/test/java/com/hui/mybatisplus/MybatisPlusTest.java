package com.hui.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hui.mybatisplus.base.inter.BaseService;
import com.hui.mybatisplus.deport.Depart;
import com.hui.mybatisplus.mapper.UserMapper;
import com.hui.mybatisplus.user.User;
import com.hui.mybatisplus.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private BaseService<Depart> departService;

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

    /**
     * 更新测试
     */
    @Test
    public void update() {
        User user = new User();
        user.setId(1l);
        user.setName("圣辉");
        userMapper.updateById(user);
    }


    /**
     * 测试wrapper
     */
    @Test
    public void pageWrapper() {
//        userMapper.selectPage(new Page<User>(), );
//        Page<User> userPage = userMapper.selectPage(new Page<User>(0, 2), new QueryWrapper<User>().eq("name", "圣辉"));
//        userPage.getRecords().forEach(System.out::println);
        QueryWrapper<User> or1 = new QueryWrapper<User>().like("name", "圣辉").or((x) -> {
            QueryWrapper<User> or = x.eq("id", 2);
        });
        userMapper.selectList(or1);
    }



    @Test
    public void mytest(){
//        System.out.println("9533301552(12321)".replaceAll("\\(.*\\)", ""));
//        User user = new User();
//        user.setAge(20);
//        user.setEmail("461321");
//        user.setId(123123213123L);
//        user.setName("231231231");
//        List<User> list = new ArrayList<>();
//        list.add(user);
//        System.err.println(user);
//        list.stream().forEach(x -> x.setName("圣辉"));
//        System.err.println(user);
//        System.err.println(getUpdateDef6("KCPMPE211105", 1));
//        userService.sayHello();
        departService.sayHello();
    }


    private String getUpdateDef6(String def6, Integer i) {
        String substring = def6.substring(def6.length() - 6);
        return def6.substring(0, def6.length() - 6) + (new Integer(substring) + 1);
    }




}
