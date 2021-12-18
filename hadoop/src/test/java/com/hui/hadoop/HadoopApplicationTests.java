package com.hui.hadoop;

import com.sun.jndi.toolkit.url.Uri;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;

/**
 * hadoop 客户端性质开发
 * 1.获得客户端对象
 * 2.获取相关法方实现功能
 * 3.关闭
 */
@SpringBootTest
class HadoopApplicationTests {

    @Test
    void contextLoads() {

    }

    private FileSystem fs;

    @BeforeEach
    void init() throws IOException, InterruptedException {
        // 1.创建文件系统
        URI uri = URI.create("hdfs://node1:8020");
        Configuration conf = new Configuration();
        String user = "root";
        fs = FileSystem.get(uri, conf, user);
        System.out.println(fs);
    }

    @AfterEach
    void initAfter() throws IOException {
        // 关闭文件系统
        fs.close();
    }

    @Test
    void testUpload() throws IOException {
        fs.copyFromLocalFile(false, true, new Path("C:\\Users\\HUI\\Desktop\\文案\\地址修改.txt"), new Path("/test"));
    }


}