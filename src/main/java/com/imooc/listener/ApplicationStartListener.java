package com.imooc.listener;

import com.imooc.annotation.SysOutAnnotation;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Spring通过ApplicationListener接口来触发contextrefreshedevent事件
 * Created by chenhaitao on 2018/4/7.
 */
public class ApplicationStartListener implements ApplicationListener<ContextRefreshedEvent>{
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //获取所有加了RequestMapping的bean
        Map<String, RequestMappingHandlerMapping> sysOutMap = event.getApplicationContext().getBeansOfType(RequestMappingHandlerMapping.class);

        List<String> stringList = new ArrayList<>();

        //循环遍历所有上面获取到的bean
        for (RequestMappingHandlerMapping handlerMapping : sysOutMap.values()) {
            for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : handlerMapping.getHandlerMethods().entrySet()) {
                RequestMappingInfo mappingInfo = entry.getKey();
                HandlerMethod handlerMethod = entry.getValue();

                //如果bean方法加上了SysoutAnnotation注解，则执行该方法
                SysOutAnnotation annotation = handlerMethod.getMethodAnnotation(SysOutAnnotation.class);
                if(annotation!=null){
                    stringList.add(annotation.value());
                }
            }
        }

        System.out.println(stringList);
    }

}
