package com.hui.hadoop.compartor;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * @Classname FlowableCompare
 * @Description TODO
 * @Date 2022/1/17 15:28
 * @Created by HUI
 */
public class FlowableCompare extends WritableComparator {

    public FlowableCompare() {
        super(Flowable.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        Flowable flowabela = (Flowable) a;
        Flowable flowabelb = (Flowable) b;
        return flowabela.getSumFlow().compareTo(flowabelb.getSumFlow());
    }
}
