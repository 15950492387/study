package com.hui.hadoop.partitioner;

import com.hui.hadoop.writeable.Flowable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @Classname PhonePartitioner
 * @Description TODO
 * @Date 2022/1/17 11:18
 * @Created by HUI
 */
public class PhonePartitioner extends Partitioner<Text, Flowable> {
    public int getPartition(Text text, Flowable flowable, int i) {
        String key = text.toString();
        int partition = 0;
        if (key.startsWith("137")) {
            return 0;
        } else if (key.startsWith("138")) {
            return 1;
        } else if (key.startsWith("139")) {
            return 2;
        } else if (key.startsWith("140")) {
            return 3;
        }
        return partition;
    }
}
