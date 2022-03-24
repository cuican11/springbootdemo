package com.hwgif.designpattern.strategypattern;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BeanUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanUtil.applicationContext = applicationContext;
    }


    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String name ,Class<T> clazz){
        return getApplicationContext().getBean(name,clazz);
    }

    public static Object getBeanByStrategyName(String name){

        Map<String, Object> map = getApplicationContext().getBeansWithAnnotation(StrategyName.class);

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            StrategyName strategyName = entry.getValue().getClass().getAnnotation(StrategyName.class);
            String val = strategyName.value();
            if (val.equals(name)){
                return entry.getValue();
            }
        }
        return null;

    }
}
