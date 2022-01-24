package com.hui.hadoop.outputFormat;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @Classname LogRedurcer
 * @Description TODO
 * @Date 2022/1/19 16:45
 * @Created by HUI
 */
public class LogReducer extends Reducer<Text, NullWritable, Text, NullWritable> {
    @Override
    protected void reduce(Text key, Iterable<NullWritable> values, Reducer<Text, NullWritable, Text, NullWritable>.Context context) throws IOException, InterruptedException {
        context.write(key, NullWritable.get());
    }
}
