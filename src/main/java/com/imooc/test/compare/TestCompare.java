package com.imooc.test.compare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * Created by chenhaitao on 2018/4/18.
 */
public class TestCompare implements Comparable<TestCompare>{

    private Integer i;

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    @Override
    public int compareTo(TestCompare o) {
//        if(o instanceof TestCompare){
        if(true){
            return - (this.i -  ((TestCompare) o).i);
        }else {
            throw new RuntimeException("比较出错，不同对象之间不能比较。");
        }
    }

    @Override
    public String toString(){
        return i.toString();
    }

    public static void main(String[] args) {
        TestCompare[] testCompares = new TestCompare[10];
        for (int i = 9; i >= 0; i--) {
            testCompares[i] = new TestCompare();
            testCompares[i].setI(10-i);
        }
        Arrays.sort(testCompares);
        List<TestCompare> list = Arrays.asList(testCompares);
        System.out.println(list);
    }



    class TestCompareo implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }

        @Override
        public Comparator reversed() {
            return null;
        }

        @Override
        public Comparator thenComparing(Comparator other) {
            return null;
        }

        @Override
        public Comparator thenComparingInt(ToIntFunction keyExtractor) {
            return null;
        }

        @Override
        public Comparator thenComparingLong(ToLongFunction keyExtractor) {
            return null;
        }

        @Override
        public Comparator thenComparingDouble(ToDoubleFunction keyExtractor) {
            return null;
        }

        @Override
        public Comparator thenComparing(Function keyExtractor) {
            return null;
        }

        @Override
        public Comparator thenComparing(Function keyExtractor, Comparator keyComparator) {
            return null;
        }
    }
}
