package com.hui.hadoop.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * 编写一个MR程序， 通常都要分散步
 * 1.编写Mapper
 * 2.编写Reducer
 * 3.编写Driver
 *
 * 插件类型开发套路
 * 1.继承类或者实现接口
 * 2.实现或者重写相关的方法
 * 3.提交执行
 *
 *
 * 自定义mapper的开发
 * 1.继承Hadoop提供的Mapper类，提供输入输出kv的类型，并重写map的方法
 *
 * Mapper 类的四个泛型 (以wordcount为例)
 * KEYIN 输入数据的key类型 LongWriterable，用来表示偏移量（从文件哪个位置读取数据）
 * VALUEIN 输入数据的value类型 从文件中读取的一行数据
 *
 * KEYOUT 输出数据的key类型 单子  key
 * VALUEOUT 输出数据的value类型 单词出现的次数
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private Text oText = new Text();
    private IntWritable oValue = new IntWritable(1);

    /**
     * 单词处理
     * @param key 输入主键  偏移量
     * @param value 输入的值
     * @param context 获取的值
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 一行的输入值
        String iValue = value.toString();
        String[] strings = iValue.split("\\s");
        for (String string : strings) {
            oText.set(string);
            oValue.set(1);
            context.write(oText, oValue);
        }
    }
}
