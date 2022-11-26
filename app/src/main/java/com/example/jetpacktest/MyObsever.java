package com.example.jetpacktest;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

//实现Lifecycles的接口
public class MyObsever implements LifecycleObserver {
    private static final String TAG = "TestLifecycleObserver";

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        // 2、在其内部创建方法（方法名随意），参数可填LifecycleOwner，也可不填。
    void onCreate(LifecycleOwner owner) {
        Log.e(TAG, "========onCreate====" + owner);
    }

    // 3、给方法加注解 @OnLifecycleEvent(Lifecycle.Event.XXX)
    // 可以让该方法监听到注解生命周期的变化。
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart() {
        Log.e(TAG, "========onStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume(LifecycleOwner owner) {
        Log.e(TAG, "========onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause(LifecycleOwner owner) {
        Log.e(TAG, "========onPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop(LifecycleOwner owner) {
        Log.e(TAG, "========onStop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy(LifecycleOwner owner) {
        Log.e(TAG, "========onDestroy");
    }

    // Lifecycle.Event.ON_ANY 可以监听所有生命周期变化
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void onAny(LifecycleOwner owner) {
        Log.e(TAG, "========onAny");
    }

}
