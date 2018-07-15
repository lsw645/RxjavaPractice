package com.lxw.rxjavapractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lxw.rxjavapractice.rxjava.Fun;
import com.lxw.rxjavapractice.rxjava.ObservableOnSubscribe;
import com.lxw.rxjavapractice.rxjava.Observer;
import com.lxw.rxjavapractice.rxjava.emitter.Emitter;
import com.lxw.rxjavapractice.rxjava.obervable.Observable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void onSubscribe(Emitter<String> e) {
                e.onNext("ssada");
                e.onNext("sdasdada");
                e.onError(new Throwable("SADSADSADA"));
                System.out.println("THread : " + Thread.currentThread().getName());
                e.onComplete();
            }
        }).subsribeOnIO()
                .observableOnMain()
                .map(new Fun<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        System.out.println(s);
                        return 1;
                    }
                }).subsribe(new Observer<Integer>() {
            @Override
            public void onSubscribe() {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
                System.out.println("Integer : " + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }
}
