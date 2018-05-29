package com.imooc.test.testException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chenhaitao on 2018/4/17.
 */
public class ThrowException {

    public String test(String s){
        if(s==null){
            throw new NullPointerException();
        } else{
            return s;
        }
    }


    public static void main(String[] args) {
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");


        features.forEach(n -> System.out.println(n));
        features.forEach(System.out::println);
    }
}
