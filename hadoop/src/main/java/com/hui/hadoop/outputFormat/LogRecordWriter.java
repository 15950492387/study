package com.hui.hadoop.outputFormat;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Classname RecordWriter
 * @Description TODO
 * @Date 2022/1/22 10:08
 * @Created by HUI
 */
public class LogRecordWriter  extends RecordWriter<Text, NullWritable> {

    private FSDataOutputStream fsDataOutputStream1;

    private FSDataOutputStream fsDataOutputStream2;

    private String outPath1 = "G:\\hadooptest\\shenghui1.log";

    private String outPath2 = "G:\\hadooptest\\shenghui2.log";

    private FileSystem fs;

    public LogRecordWriter(TaskAttemptContext context) throws IOException {
        fs = FileSystem.get(context.getConfiguration());
        fsDataOutputStream1 = fs.create(new Path(outPath1));
        fsDataOutputStream2 = fs.create(new Path(outPath2));
    }

    @Override
    public void write(Text key, NullWritable value) throws IOException, InterruptedException {
        // 判断key是否包含圣辉
        String log = key.toString();
        if (log.contains("shenghui")) {
            fsDataOutputStream1.write((log + "\r").getBytes(StandardCharsets.UTF_8));
        } else {
            fsDataOutputStream2.write((log + "\r").getBytes(StandardCharsets.UTF_8));
        }
    }

    @Override
    public void close(TaskAttemptContext context) throws IOException, InterruptedException {
        fsDataOutputStream1.close();
        fsDataOutputStream2.close();
    }
}
