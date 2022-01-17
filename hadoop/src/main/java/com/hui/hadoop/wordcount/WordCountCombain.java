package com.hui.hadoop.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @Classname WordCountCombain
 * @Description TODO
 * @Date 2022/1/17 21:17
 * @Created by HUI
 */
public class WordCountCombain extends Reducer<Text, IntWritable, Text, IntWritable>  {

    private IntWritable oValue = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        for (IntWritable value : values) {
            sum += value.get();
        }
        oValue.set(sum);
        context.write(key, oValue);
    }

}
