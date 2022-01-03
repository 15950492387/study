package com.hui.hadoop.writeable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FlowReducer extends Reducer<Text, Flowable, Text, Flowable> {
    Flowable flowable = new Flowable();
    @Override
    protected void reduce(Text key, Iterable<Flowable> values, Context context) throws IOException, InterruptedException {
        long downSum = 0;
        long upSum = 0;
        long sumSum = 0;
        for (Flowable value : values) {
            downSum += value.getDownFlow();
            upSum += value.getUpFlow();
            sumSum += value.getSumFlow();
        }
        flowable.setSumFlow(sumSum);
        flowable.setUpFlow(upSum);
        flowable.setDownFlow(downSum);
        context.write(key, flowable);
    }
}
