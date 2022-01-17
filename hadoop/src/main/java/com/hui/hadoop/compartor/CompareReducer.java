package com.hui.hadoop.compartor;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @Classname CompareReducer
 * @Description TODO
 * @Date 2022/1/17 15:44
 * @Created by HUI
 */
public class CompareReducer extends Reducer<Flowable, Text, Text, Flowable> {

    @Override
    protected void reduce(Flowable key, Iterable<Text> values, Reducer<Flowable, Text, Text, Flowable>.Context context) throws IOException, InterruptedException {
        for (Text value : values) {
            context.write(value, key);
        }
    }
}
