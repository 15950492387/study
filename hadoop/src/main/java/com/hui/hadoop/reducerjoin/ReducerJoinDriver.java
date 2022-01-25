package com.hui.hadoop.reducerjoin;

import com.hui.hadoop.wordcount.WordCountCombain;
import com.hui.hadoop.wordcount.WordCountDriever;
import com.hui.hadoop.wordcount.WordCountMapper;
import com.hui.hadoop.wordcount.WordCountReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @Classname ReducerJoinMapper
 * @Description TODO
 * @Date 2022/1/25 9:06
 * @Created by HUI
 */
public class ReducerJoinDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        // 创建配置对象
        Configuration conf = new Configuration();
        // 创建job对象
        Job job = Job.getInstance(conf);
        // 关联驱动类
        job.setJarByClass(ReducerJoinDriver.class);
        // 关联Mapper 和Reducer类
        job.setMapperClass(ReducerJoinMapper.class);
        job.setReducerClass(ReducerJoinReducer.class);
        // 设置Mapper输出的key 和 value的类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(OrderBean.class);
        // 设置最终输出的key 和 value 的类型
        job.setOutputKeyClass(OrderBean.class);
        job.setOutputValueClass(NullWritable.class);
        FileInputFormat.setInputPaths(job, new Path("G:\\hadooptest\\twofile"));
        FileOutputFormat.setOutputPath(job, new Path("G:\\hadooptest\\sumoutput8"));
        // 提交job
        job.waitForCompletion(true);
    }

}
