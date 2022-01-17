package com.hui.hadoop.compartor;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class ComparableDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        job.setMapperClass(CompareMapper.class);
        job.setReducerClass(CompareReducer.class);
        job.setMapOutputKeyClass(Flowable.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Flowable.class);
        FileInputFormat.setInputPaths(job, new Path("G:\\hadooptest\\test.txt"));
        FileOutputFormat.setOutputPath(job, new Path("G:\\hadooptest\\sumoutput2"));
//        job.setSortComparatorClass(FlowableCompare.class);
        job.waitForCompletion(true);
    }

}
