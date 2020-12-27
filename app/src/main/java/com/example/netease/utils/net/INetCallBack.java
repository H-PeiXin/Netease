package com.example.netease.utils.net;

public interface INetCallBack<T> {
    void onSuccess(T t);
    void onFail(String err);
}
