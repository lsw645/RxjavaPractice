package com.lxw.rxjavapractice.rxjava;

/**
 * <pre>
 *     author : lxw
 *     e-mail : lsw@tairunmh.com
 *     time   : 2018/07/13
 *     desc   :
 * </pre>
 */
public interface Observer<T> {

    void onSubscribe();

    void onNext(T t);


    void onError(Throwable e);

    void onComplete();
}
