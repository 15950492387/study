package com.hui.hadoop.group;

import com.hui.hadoop.compartor.Flowable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class OrderDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        job.setMapperClass(OrderMapper.class);
        job.setReducerClass(OrderReducer.class);
        job.setMapOutputKeyClass(OrderBean.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(OrderBean.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.setInputPaths(job, new Path("G:\\hadooptest\\order.txt"));
        FileOutputFormat.setOutputPath(job, new Path("G:\\hadooptest\\sumoutput5"));
//        job.setSortComparatorClass(FlowableCompare.class);
        job.setGroupingComparatorClass(OrderGroup.class);
        job.waitForCompletion(true);
    }

}
