package com.lxw.rxjavapractice.rxjava;

/**
 * <pre>
 *     author : lxw
 *     e-mail : lsw@tairunmh.com
 *     time   : 2018/07/13
 *     desc   :
 * </pre>
 */
public interface Fun<T,U>{

    U  apply(T t);
}
