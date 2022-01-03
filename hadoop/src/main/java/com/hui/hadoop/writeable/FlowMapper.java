package com.hui.hadoop.writeable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowMapper extends Mapper<LongWritable, Text, Text, Flowable> {

    private Text newKey = new Text();

    private Flowable myValue = new Flowable();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] values = value.toString().split(" ");
        String myKey = values[0];
        String up = values[1];
        String down = values[2];
        newKey.set(myKey);
        myValue.setDownFlow(Long.valueOf(down));
        myValue.setUpFlow(Long.valueOf(up));
        myValue.setSumFlow();
        context.write(newKey, myValue);
    }
}
