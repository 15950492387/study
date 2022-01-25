package com.hui.hadoop.reducerjoin;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

/**
 * @Classname ReducerJoinMapper
 * @Description TODO
 * @Date 2022/1/25 9:06
 * @Created by HUI
 */
public class ReducerJoinMapper extends Mapper<LongWritable, Text, Text, OrderBean> {

    private String currentFileName;

    private Text text = new Text();

    private OrderBean orderBean = new OrderBean();

    /**
     * 在maptask 执行开始前调用一次
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void setup(Mapper<LongWritable, Text, Text, OrderBean>.Context context) throws IOException, InterruptedException {
        InputSplit inputSplit = context.getInputSplit();
        FileSplit fileSplit = (FileSplit) inputSplit;
        currentFileName = fileSplit.toString();
    }

    /**
     * 2个文件   需要读取2个文件\
     * ordre.txt
     * pid.txt
     * @param key
     * @param value
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, OrderBean>.Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] split = line.split(" ");
        if (currentFileName.contains("order")) {
            orderBean.setOrderId(split[0]);
            orderBean.setPid(split[1]);
            orderBean.setAmount(new Integer(split[2]));
            orderBean.setPname(split[3]);
            orderBean.setPai("");
            orderBean.setTitle("order");
            text.set(split[1]);
        } else {
            orderBean.setOrderId("");
            orderBean.setPid(split[0]);
            orderBean.setAmount(0);
            orderBean.setPname("");
            orderBean.setPai(split[1]);
            orderBean.setTitle("pid");
            text.set(split[0]);
        }
        context.write(text, orderBean);
    }
}
