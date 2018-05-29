package com.imooc.service.impl;

import com.imooc.service.TestService;
import com.imooc.service.TestServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chenhaitao on 2018/5/8.
 */
@Service
public class TestServiceImpl implements TestService{


    @Autowired
    private TestServiceB testServiceB;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void a() {
        System.out.println("a正常");
        testServiceB.b();
        System.out.println("b正常");
    }


}
