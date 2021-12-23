package com.hui.hadoop;

import com.sun.jndi.toolkit.url.Uri;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
    void testUpload() throws Exception {
        // 复制到hadoop
        // fs.copyFromLocalFile(false, true, new Path("C:\\Users\\HUI\\Desktop\\文案\\地址修改.txt"), new Path("/test"));
        // 下载hadoop得文件
        fs.copyToLocalFile(false,new Path("/sh666/shenhui.txt"), new Path("C:\\Users\\HUI\\Desktop\\文案\\1111.txt"), true);
    }

    /**
     * 修改名字   文件移动
     */
    @Test
    void rename() throws IOException {
        fs.rename(new Path("/sh666/shenhui.txt"), new Path("/sh666/shenghui.txt"));
    }

    /**
     * 查询文件
     */
    @Test
    void listFiles() throws Exception {
        RemoteIterator<LocatedFileStatus> locatedFileStatusRemoteIterator = fs.listFiles(new Path("/"), true);
        while (locatedFileStatusRemoteIterator.hasNext()) {
            LocatedFileStatus next = locatedFileStatusRemoteIterator.next();
            System.out.println("文件地址:" + next.getPath());
            System.out.println("文件权限:" + next.getPermission());
            System.out.println(next.getOwner());
            System.out.println(next.getGroup());
            System.out.println(next.getLen());
            System.out.println(next.getModificationTime());
            System.out.println(next.getReplication());
            System.out.println(next.getBlockSize());
            System.out.println(next.getBlockLocations());
        }
    }

    /**
     *  查看文件状态
     * @throws IOException
     */
    @Test
    void listStatus() throws IOException {
        FileStatus[] fileStatuses = fs.listStatus(new Path("/"));
        for (FileStatus status : fileStatuses) {
            if (status.isFile()) {
                System.out.println("file " + status.getPath());
            } else {
                System.out.println("dir " + status.getPath());
            }
        }
    }


    /**
     * 删除文件或者目录
     */
    @Test
    void delete() throws IOException {
        fs.delete(new Path("/tmp"), true);
    }


    /**
     * 测试io流上传
     */
    @Test
    void ioUplod() throws Exception {
        String lpath = "C:\\Users\\HUI\\Desktop\\文案\\遗留问题修改.txt";
        String hpath = "/遗留问题修改.txt";
        FileInputStream fileInputStream = new FileInputStream(lpath);
        FSDataOutputStream fsDataOutputStream = fs.create(new Path(hpath));
        IOUtils.copyBytes(fileInputStream,fsDataOutputStream,new Configuration());
        IOUtils.closeStreams(fileInputStream, fsDataOutputStream);
    }


    /**
     * 测试io流下载
     */
    @Test
    void ioDown() throws Exception {
        String lpath = "C:\\Users\\HUI\\Desktop\\文案\\遗留问题修改.txt";
        String hpath = "/遗留问题修改.txt";
        FSDataInputStream hpath1 = fs.open(new Path(hpath));
        FileOutputStream fileOutputStream = new FileOutputStream(lpath);
        IOUtils.copyBytes(hpath1, fileOutputStream, new Configuration());
        IOUtils.closeStreams(hpath1, fileOutputStream);
    }

}