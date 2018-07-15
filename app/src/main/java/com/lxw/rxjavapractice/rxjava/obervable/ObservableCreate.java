package com.lxw.rxjavapractice.rxjava.obervable;

import com.lxw.rxjavapractice.rxjava.ObservableOnSubscribe;
import com.lxw.rxjavapractice.rxjava.Observer;
import com.lxw.rxjavapractice.rxjava.emitter.Emitter;

/**
 * <pre>
 *     author : lxw
 *     e-mail : lsw@tairunmh.com
 *     time   : 2018/07/14
 *     desc   :
 * </pre>
 */
public class ObservableCreate<T> extends Observable<T> {
    private final ObservableOnSubscribe source;

    public ObservableCreate(ObservableOnSubscribe observableOnSubscribe) {
        source = observableOnSubscribe;
    }


    @Override
    public void subscribeActual(Observer<? super T> observer) {
        Emitter<T> emitter = new CreateEmitter<T>(observer);
        source.onSubscribe(emitter);
    }

    static final class CreateEmitter<T>
            implements Emitter<T> {


        private static final long serialVersionUID = -3434801548987643227L;

        final Observer<? super T> observer;

        CreateEmitter(Observer<? super T> observer) {
            this.observer = observer;
        }

        @Override
        public void onNext(T t) {
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            observer.onNext(t);
        }

        @Override
        public void onError(Throwable t) {
            if (t == null) {
                t = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            observer.onError(t);
        }

        @Override
        public void onComplete() {
            observer.onComplete();

        }
    }
}
