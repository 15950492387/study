package com.hui.hadoop.wordcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * 驱动类，主要将我们写好的mr封装成一个job对象，进行提交，然后执行
 */
public class WordCountDriever {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        // 创建配置对象
        Configuration conf = new Configuration();
        // 创建job对象
        Job job = Job.getInstance(conf);
        // 关联驱动类
        job.setJarByClass(WordCountDriever.class);
        // 关联Mapper 和Reducer类
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);
        // 设置Mapper输出的key 和 value的类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        // 设置最终输出的key 和 value 的类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        // 设置输入和输出路径
        job.setCombinerClass(WordCountCombain.class);
        //设置combain
        FileInputFormat.setInputPaths(job, new Path("G:\\hadooptest\\test.txt"));
        FileOutputFormat.setOutputPath(job, new Path("G:\\hadooptest\\sumoutput2"));
        // 提交job
        job.waitForCompletion(true);
    }
}
