package com.myanmar.tmn.buroole.data.model;

import com.myanmar.tmn.buroole.data.vo.LoginUserVO;
import com.myanmar.tmn.buroole.event.SuccessUserEvent;
import com.myanmar.tmn.buroole.event.UserLogoutEvent;
import com.myanmar.tmn.buroole.network.LoginDataAgent;
import com.myanmar.tmn.buroole.network.RetrofitDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by msi on 1/26/2018.
 */

public class LoginUserModel {

    private static LoginUserModel ourInstance;

    private LoginDataAgent loginDataAgent;

    private LoginUserVO loginUserVO;

    private LoginUserModel() {
        loginDataAgent = RetrofitDataAgent.getsObjectInstance();
        EventBus.getDefault().register(this);
    }

    public static LoginUserModel getOurInstance() {
        if (ourInstance == null){
            ourInstance = new LoginUserModel();
        }
        return ourInstance;
    }

    public void login(String phone, String password){
        loginDataAgent.loginUser(phone,password);
    }

    public boolean isLogin(){
        return loginUserVO != null;
    }

    public void logOut(){
        loginUserVO = null;
        EventBus.getDefault().post(new UserLogoutEvent());
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onLoginSuccess(SuccessUserEvent event){
        loginUserVO = event.getLoginUserVO();
    }
}
