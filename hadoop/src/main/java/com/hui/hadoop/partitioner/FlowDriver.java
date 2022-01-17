package com.hui.hadoop.partitioner;

import com.hui.hadoop.writeable.FlowMapper;
import com.hui.hadoop.writeable.FlowReducer;
import com.hui.hadoop.writeable.Flowable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class FlowDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        job.setMapperClass(FlowMapper.class);
        job.setReducerClass(FlowReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Flowable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Flowable.class);
        FileInputFormat.setInputPaths(job, new Path("G:\\hadooptest\\test.txt"));
        FileOutputFormat.setOutputPath(job, new Path("G:\\hadooptest\\sumoutput2"));
        job.setPartitionerClass(PhonePartitioner.class);
        job.setNumReduceTasks(4);
        job.waitForCompletion(true);
    }

}
