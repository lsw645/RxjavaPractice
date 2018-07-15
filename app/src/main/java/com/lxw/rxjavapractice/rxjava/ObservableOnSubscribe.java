package com.lxw.rxjavapractice.rxjava;

import com.lxw.rxjavapractice.rxjava.emitter.Emitter;

/**
 * <pre>
 *     author : lxw
 *     e-mail : lsw@tairunmh.com
 *     time   : 2018/07/13
 *     desc   :
 * </pre>
 */
public interface  ObservableOnSubscribe<T> {

   void  onSubscribe(Emitter<T > e);
}
