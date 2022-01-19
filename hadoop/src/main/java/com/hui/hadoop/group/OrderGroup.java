package com.hui.hadoop.group;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * @Classname OrderGroup
 * @Description TODO
 * @Date 2022/1/19 15:16
 * @Created by HUI
 */
public class OrderGroup extends WritableComparator {

    public OrderGroup() {
        super(OrderBean.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        OrderBean abean = (OrderBean) a;
        OrderBean bbean = (OrderBean) b;
        return abean.getOrderId().compareTo(bbean.getOrderId());
    }
}
