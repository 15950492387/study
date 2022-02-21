package com.hui.hadoop.compartor;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @Classname CompareMapper
 * @Description TODO
 * @Date 2022/1/17 15:36
 * @Created by HUI
 */
public class CompareMapper extends Mapper<LongWritable, Text, Flowable, Text> {

    private Text oText = new Text();
    private Flowable oValue = new Flowable();

    @Override
    protected void setup(Mapper<LongWritable, Text, Flowable, Text>.Context context) throws IOException, InterruptedException {
        context.getCounter("Map Join", "setup").increment(1);
    }

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Flowable, Text>.Context context) throws IOException, InterruptedException {
        String lineStr = value.toString();
        String[] splits = lineStr.split(" ");
        oValue.setUpFlow(Long.valueOf(splits[1]));
        oValue.setDownFlow(Long.valueOf(splits[2]));
        oValue.setSumFlow();
        oText.set(splits[0]);
        context.write(oValue, oText);
    }
}
