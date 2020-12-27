package com.example.netease.presenter;

import com.example.netease.base.BasePresenter;
import com.example.netease.bean.HomeData;
import com.example.netease.contract.MainContract;
import com.example.netease.model.MainModelImpl;
import com.example.netease.utils.net.INetCallBack;

public class MainPresenterImpl extends BasePresenter implements MainContract.IMainPresenter {

    private MainContract.IMainView mainView;
    private final MainModelImpl mainModel;

    public MainPresenterImpl(MainContract.IMainView mainView) {
        this.mainView = mainView;
        mainModel = new MainModelImpl(this);
    }

    @Override
    public void login() {
        mainModel.getLoginData("index", new INetCallBack<HomeData>() {
            @Override
            public void onSuccess(HomeData userBean) {
                mainView.getData(userBean);
            }

            @Override
            public void onFail(String err) {

            }
        });
    }

    @Override
    public void loginResult(String result) {

    }
}
