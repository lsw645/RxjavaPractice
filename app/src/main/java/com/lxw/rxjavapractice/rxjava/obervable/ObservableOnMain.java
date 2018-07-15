package com.lxw.rxjavapractice.rxjava.obervable;

import android.os.Handler;
import android.os.Looper;

import com.lxw.rxjavapractice.rxjava.Observer;


/**
 * <pre>
 *     author : lxw
 *     e-mail : lsw@tairunmh.com
 *     time   : 2018/07/15
 *     desc   :
 * </pre>
 */
public class ObservableOnMain<T> extends Observable<T> {
    private Observable mObservable;

    public ObservableOnMain(Observable observable) {
        mObservable = observable;
    }

    @Override
    public void subscribeActual(Observer<? super T> observer) {
        mObservable.subsribe(new MainObersver(observer));
    }


    final static class MainObersver<T> implements Observer<T> {
        private Handler mHandler = new Handler(Looper.getMainLooper());
        private Observer<T> mTObserver;

        public MainObersver(Observer<T> TObserver) {
            mTObserver = TObserver;
        }

        @Override
        public void onSubscribe() {

        }

        @Override
        public void onNext(final T t) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mTObserver.onNext(t);
                }
            });
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }
}
