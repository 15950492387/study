package com.hui.mybatisplus.deport;

import com.hui.mybatisplus.base.inter.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartService implements BaseService<Depart> {
    @Override
    public void sayHello() {
        System.out.println("部门服务");
    }
}
