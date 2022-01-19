package com.hui.hadoop.group;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @Classname OrderBean
 * @Description TODO
 * @Date 2022/1/19 14:48
 * @Created by HUI
 */
public class OrderBean implements WritableComparable<OrderBean> {

    private String orderId;
    private Double price;

    public OrderBean() {
    }

    @Override
    public int compareTo(OrderBean o) {
        int i = o.getOrderId().compareTo(orderId);
        if (i == 0) {
            return o.getPrice().compareTo(price);
        } else {
            return i;
        }
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(orderId);
        out.writeDouble(price);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.orderId = in.readUTF();
        this.price = in.readDouble();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "orderId='" + orderId + '\'' +
                ", price=" + price +
                '}';
    }
}
