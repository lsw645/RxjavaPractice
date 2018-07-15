package com.lxw.rxjavapractice.rxjava.obervable;

import com.lxw.rxjavapractice.rxjava.Fun;
import com.lxw.rxjavapractice.rxjava.Observer;

/**
 * <pre>
 *     author : lxw
 *     e-mail : lsw@tairunmh.com
 *     time   : 2018/07/14
 *     desc   :
 * </pre>
 */
public class ObservableMap<T, R> extends Observable<R> {
    private Fun<? super T, ? extends R> mapper;
    private Observable source;
    private MapObserver mMapObserver;

    public ObservableMap(Observable observable, Fun<? super T, ? extends R> mapper) {
        this.source = observable;
        this.mapper = mapper;
    }

    @Override
    public void subscribeActual(Observer observer) {
        source.subsribe(new MapObserver(mapper, observer));
    }


    final class MapObserver<S, U> implements Observer<S> {
        private Fun<? super S, ? extends R> mapper;
        private Observer<R> mObserver;

        public MapObserver(Fun<? super S, ? extends R> mapper, Observer<R> observer) {
            this.mapper = mapper;
            mObserver = observer;
        }

        @Override
        public void onSubscribe() {
                mObserver.onSubscribe();
        }

        @Override
        public void onNext(S t) {
            R r = mapper.apply(t);
            mObserver.onNext(r);
        }

        @Override
        public void onError(Throwable e) {
            mObserver.onError(e);
        }

        @Override
        public void onComplete() {
            mObserver.onComplete();
        }
    }
}
