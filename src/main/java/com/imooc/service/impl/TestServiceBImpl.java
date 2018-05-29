package com.imooc.service.impl;

import com.imooc.service.TestServiceB;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chenhaitao on 2018/5/8.
 */
@Service
public class TestServiceBImpl implements TestServiceB {

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public void b() {
        System.out.println("应该抛出异常啊");
    }
}
