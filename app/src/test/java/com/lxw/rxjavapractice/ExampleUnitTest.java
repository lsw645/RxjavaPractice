package com.lxw.rxjavapractice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test() {
        String name_1 = Fruit.getFruit(new Banana());
        String name_2 = Fruit.getFruit(new Apple());
        System.out.println(name_1);
        System.out.println(name_2);
    }

    @Test
    public void test2() {
//        String name_1 = Fruit.getFruit(new Banana());
//        String name_2 = Fruit.getFruit(new Apple());
//        System.out.println(name_1);
//        System.out.println(name_2);

        Point<?> point;
        point = new Point<Integer>(3, 4);
        point = new Point<Float>(3.4f, 4.5f);
        System.out.println(point.getX());
    }

    class Employee {

    }

    class CEO extends Manager {

    }

    class Manager extends Employee {

    }

    @Test
    public void testSuper() {
        List<? super Manager> list = new ArrayList<Employee>();
        list.get(0);
//        list.add(new Employee());
        list.add(new Manager());
        list.add(new CEO());
    }

}