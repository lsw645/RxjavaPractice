package com.lxw.rxjavapractice.rxjava.obervable;

import com.lxw.rxjavapractice.rxjava.Fun;
import com.lxw.rxjavapractice.rxjava.ObservableOnSubscribe;
import com.lxw.rxjavapractice.rxjava.Observer;

/**
 * <pre>
 *     author : lxw
 *     e-mail : lsw@tairunmh.com
 *     time   : 2018/07/13
 *     desc   :
 * </pre>
 */
public abstract class Observable<T> {


//    public Observable(ObservableOnSubscribe observableOnSubscribe) {
//        this.source = observableOnSubscribe;
//    }

    public static <T> Observable<T> create(ObservableOnSubscribe<T> t) {
        return new ObservableCreate<>(t);
    }

    public Observable<T> subsribeOnIO() {
        return new ObservableSubsribeOn<T>(this);
    }

    public Observable<T> observableOnMain() {
        return new ObservableOnMain<>(this);
    }

    public <R> Observable<R> map(Fun<? super T, ? extends R> fun) {
        return new ObservableMap<T, R>(this, fun);
    }

    public void subsribe(Observer<? super T> observer) {
//        this.source.onSubscribe(observer);
        subscribeActual(observer);
    }

    public abstract void subscribeActual(Observer<? super T> observer);

}
