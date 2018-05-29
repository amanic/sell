package com.imooc.aspect;


import com.imooc.annotation.SysOutAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chenhaitao on 2018/4/3.
 */
@Component
@Aspect
public class MyOwnTestAspect {


//    @Around(value = "within(@org.springframework.web.bind.annotation.RestController *)")
    public Object test01(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] objs = proceedingJoinPoint.getArgs();
        for (int i = 0; i < objs.length; i++) {
            objs[i] += "大美女";
        }

        System.out.println(proceedingJoinPoint.getKind());
//        proceedingJoinPoint.proceed();
//        proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        return proceedingJoinPoint.proceed(objs);
    }


    @Around(value = "within(@com.imooc.annotation.SysOutTypeAnnotation *) && @annotation(sysOutAnnotation)")
//    @Around(value = "execution(String com.imooc.controller.*.*(..)) && @annotation(sysOutAnnotation)")
    public Object test02(ProceedingJoinPoint pjp, SysOutAnnotation sysOutAnnotation) throws Throwable {
        for (int i = 0; i < pjp.getArgs().length; i++) {
            if(sysOutAnnotation.required()){
                pjp.getArgs()[i] += sysOutAnnotation.value();
            }
        }
        return pjp.proceed(pjp.getArgs());
    }



    @Pointcut(value = "execution(void com.imooc.controller.TestController.* (..))")
    public void myPoint(){}
//    @Before()


    public static void main(String[] args) {
        Integer[] integers = {1,2,3,4};
        for (Integer i : integers) {
            i++;
        }

        for (Integer i : integers) {
            System.out.println(i);
        }
    }




}
