package com.example.netease.model;

import com.example.netease.contract.MainContract;
import com.example.netease.utils.net.INetCallBack;
import com.example.netease.utils.net.RetrofitUtils;

public class MainModelImpl implements MainContract.IMainModel {

    private MainContract.IMainPresenter presenter;

    public MainModelImpl(MainContract.IMainPresenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public <T> void getLoginData(String url, INetCallBack<T> callBack) {
        presenter.loginResult("咳咳");
        RetrofitUtils.getInstance().get(url,callBack);
    }
}
