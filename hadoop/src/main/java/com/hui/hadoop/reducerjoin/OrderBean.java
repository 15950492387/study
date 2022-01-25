package com.hui.hadoop.reducerjoin;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @Classname OrderBena
 * @Description TODO
 * @Date 2022/1/25 9:10
 * @Created by HUI
 */
public class OrderBean implements Writable {

    private String orderId;
    private String pid;
    private Integer amount;
    private String pname;
    private String pai;
    private String title;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(orderId);
        out.writeUTF(pid);
        out.writeInt(amount);
        out.writeUTF(pname);
        out.writeUTF(pai);
        out.writeUTF(title);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        orderId = in.readUTF();
        pid = in.readUTF();
        amount = in.readInt();
        pname = in.readUTF();
        pai = in.readUTF();
        title = in.readUTF();
    }

    @Override
    public String toString() {
        return orderId + ' ' + pid + ' ' + amount + ' ' + pname + ' ' + pai + ' ' + title + ' ';
    }
}
