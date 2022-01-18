package com.imooc.service.impl;

import com.imooc.service.StuService;
import com.imooc.service.TestTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestTransServiceImpl implements TestTransService {

    @Autowired
    private StuServiceImpl stuService;

    /**
     * 事务传播
     * REQUIRED：使用当前事务，如果当前没有事务，则自己新建一个事务。
     * SUPPORTS：如果当前有事务，则使用事务，如果当前没有事务，则不使用事务
     * MANDATORY：该传播属性必须存在一个事务，如果不存在，则抛出异常
     * REQUIRES_NEW：如果当前有事务，则挂起该事务，并且自己创建一个新的事务
     * 如果当前没有事务，则新建一个事务
     * NOT_SUPPORTED：如果当前有事务，则把事务挂起，自己不使用事务
     * NEVER：如果当前有事务，则抛出异常
     * NESTED：如果当前有事务，则开启子事务（嵌套事务），嵌套事务是独立提交或回滚，但是如果主事务提交或回滚，子事务会一起提交或回滚
     */

    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testPropagationTrans() {
//        stuService.saveParent();

        stuService.saveChildren();

//        int a = 1/0;

    }
}
