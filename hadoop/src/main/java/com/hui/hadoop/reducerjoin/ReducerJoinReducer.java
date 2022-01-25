package com.hui.hadoop.reducerjoin;

import com.sun.istack.internal.Nullable;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname ReducerJoinMapper
 * @Description TODO
 * @Date 2022/1/25 9:06
 * @Created by HUI
 */
public class ReducerJoinReducer extends Reducer<Text, OrderBean, OrderBean, NullWritable> {

    private List<OrderBean> list = new ArrayList<>();
    private OrderBean orderBean  = new OrderBean();


    @Override
    protected void reduce(Text key, Iterable<OrderBean> values, Reducer<Text, OrderBean, OrderBean, NullWritable>.Context context) throws IOException, InterruptedException {
        // 迭代该组得数据 将来自不同文件得key value分布存储
        for (OrderBean value : values) {
            if ("order".equals(value.getTitle())) {
                try {
                    OrderBean orderBean2 = new OrderBean();
                    BeanUtils.copyProperties(orderBean2, value);
                    list.add(orderBean2);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    BeanUtils.copyProperties(orderBean, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        for (OrderBean bean : list) {
            bean.setPai(orderBean.getPai());
            context.write(bean, NullWritable.get());
        }
        list.clear();
    }
}
