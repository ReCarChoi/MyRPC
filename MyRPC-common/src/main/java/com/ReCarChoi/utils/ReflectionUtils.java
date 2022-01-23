package com.ReCarChoi.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ReCarChoi
 * @version 1.0
 * @date 2022/1/21 13:48
 * @description 反射工具类
 */
public class ReflectionUtils {

    /**
     * create by: ReCarChoi
     * description: 根据class创建对象
     * create time: 13:51
     * @Param: clazz 待创建对象的类
     * @Param: <T> 对象类型
     * @return 创建好的对象
     */
    public static <T> T newInstance(Class<T> clazz){
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * create by: ReCarChoi
     * description: 获取某个class的共有方法
     * create time: 14:14
     * @Param: clazz
     * @return 当前类声明的共有方法
     */
    public static Method[] getPublicMethods(Class clazz){
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> pmethods = new ArrayList<>();
        for (Method method : methods) {
          if (Modifier.isPublic(method.getModifiers())){
              pmethods.add(method);
          }
        }
        return pmethods.toArray(new Method[0]);
    }

    /**
     * create by: ReCarChoi
     * description: 调用指定对象的指定方法
     * create time: 14:22
     * @Param: object 被调用方法的对象
     * @Param: method 被调用的方法
     * @Param: args 方法的参数
     * @return 返回结果
     */
    public static Object invoke(Object object,Method method,Object... args){
        try {
            return method.invoke(object, args);
        } catch (Exception e) {
            throw  new IllegalStateException(e);
        }
    }

}
