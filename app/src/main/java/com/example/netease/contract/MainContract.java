package com.example.netease.contract;

import com.example.netease.bean.UserBean;
import com.example.netease.utils.net.INetCallBack;

public class MainContract {
    public interface IMainModel{
        <T> void getLoginData(String url, INetCallBack<T> callBack);
    }

    public interface IMainPresenter{
        void login();
        void loginResult(String result);
    }

    public interface IMainView{
        void getData(UserBean userBean);
    }
}
