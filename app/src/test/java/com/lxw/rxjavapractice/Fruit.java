package com.lxw.rxjavapractice;

/**
 * <pre>
 *     author : lxw
 *     e-mail : lsw@tairunmh.com
 *     time   : 2018/07/13
 *     desc   :
 * </pre>
 */
public class Fruit {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static <T extends Fruit> String getFruit(T t) {
        return t.getName();
    }
}
