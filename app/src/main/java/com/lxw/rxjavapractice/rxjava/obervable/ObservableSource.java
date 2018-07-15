package com.lxw.rxjavapractice.rxjava.obervable;

import com.lxw.rxjavapractice.rxjava.Observer;

/**
 * <pre>
 *     author : lxw
 *     e-mail : lsw@tairunmh.com
 *     time   : 2018/07/14
 *     desc   :
 * </pre>
 */
public interface ObservableSource<T> {
    void subsribe(Observer<? super T> observer);
}
