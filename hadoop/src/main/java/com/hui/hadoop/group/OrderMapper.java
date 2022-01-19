package com.hui.hadoop.group;

import com.hui.hadoop.compartor.Flowable;
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
public class OrderMapper extends Mapper<LongWritable, Text, OrderBean, Text> {

    private Text oText = new Text();
    private OrderBean oValue = new OrderBean();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, OrderBean, Text>.Context context) throws IOException, InterruptedException {
        String lineStr = value.toString();
        String[] splits = lineStr.split(" ");
        oValue.setOrderId(splits[0]);
        oValue.setPrice(Double.valueOf(splits[1]));
        oText.set(splits[0]);
        context.write(oValue, oText);
    }
}
