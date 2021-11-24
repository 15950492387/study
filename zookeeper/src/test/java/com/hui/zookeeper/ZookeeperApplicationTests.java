package com.hui.zookeeper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class ZookeeperApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("zookeeper测试服务");
        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
    }

}
