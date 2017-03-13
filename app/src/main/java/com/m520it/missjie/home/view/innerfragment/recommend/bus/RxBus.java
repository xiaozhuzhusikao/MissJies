package com.m520it.missjie.home.view.innerfragment.recommend.bus;

import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

/**
 * Created by kang on 2017/3/8.
 */

public class RxBus {
    private static volatile RxBus mInstance;

    private final SerializedSubject bus;


    public RxBus()
    {
        bus = new SerializedSubject<>(PublishSubject.create());
    }

    /**
     * 单例模式RxBus
     *
     * @return
     */
    public static RxBus getInstance()
    {

        RxBus rxBus2 = mInstance;
        if (mInstance == null)
        {
            synchronized (RxBus.class)
            {
                rxBus2 = mInstance;
                if (mInstance == null)
                {
                    rxBus2 = new RxBus();
                    mInstance = rxBus2;
                }
            }
        }

        return rxBus2;
    }


    /**
     * 发送消息
     *
     * @param object
     */
    public void post(Object object)
    {

        bus.onNext(object);

    }

    /**
     * 接收消息
     *
     * @param <T>
     * @param eventType
     * @return
     */
    public <T> rx.Observable toObserverable(Class<T> eventType)
    {
        return bus.ofType(eventType);
    }
}
