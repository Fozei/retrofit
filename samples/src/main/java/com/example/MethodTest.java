package com.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;

public class MethodTest {
    public static void main(String[] args) {
        Class clazz = IRequestApi.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            Annotation[] annotations = method.getAnnotations();
            System.out.println(Arrays.asList(annotations));
            System.out.println("----------");
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            System.out.println(Arrays.asList(genericParameterTypes));
            System.out.println(genericParameterTypes.length);
            System.out.println("----------");
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            for (Annotation[] parameterAnnotation : parameterAnnotations) {
                System.out.println(Arrays.asList(parameterAnnotation));
            }
            System.out.println("=======================");
        }
    }
}
