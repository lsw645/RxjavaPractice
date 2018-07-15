package com.lxw.rxjavapractice.rxjava.obervable;

import com.lxw.rxjavapractice.rxjava.Observer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 *     author : lxw
 *     e-mail : lsw@tairunmh.com
 *     time   : 2018/07/15
 *     desc   :
 * </pre>
 */
public class ObservableSubsribeOn<T> extends Observable<T> {
    private ExecutorService mExecutor = Executors.newCachedThreadPool();
    private Observable<T> mObservable ;

    public ObservableSubsribeOn(Observable<T> observable) {
        mObservable = observable;
    }

    @Override
    public void subscribeActual(final Observer<? super T> observer) {
            mExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    mObservable.subsribe(observer);
                }
            });
    }
}
