package com.hui.hadoop.group;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @Classname CompareReducer
 * @Description TODO
 * @Date 2022/1/17 15:44
 * @Created by HUI
 */
public class OrderReducer extends Reducer<OrderBean, Text, Text, OrderBean> {

    @Override
    protected void reduce(OrderBean key, Iterable<Text> values, Reducer<OrderBean, Text, Text, OrderBean>.Context context) throws IOException, InterruptedException {
        for (Text value : values) {
            context.write(value, key);
        }
    }
}
