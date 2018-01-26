package com.myanmar.tmn.buroole.viewPods;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.myanmar.tmn.buroole.R;
import com.myanmar.tmn.buroole.data.model.LoginUserModel;
import com.myanmar.tmn.buroole.delegates.BeforeLoginDelegate;
import com.myanmar.tmn.buroole.delegates.LoginUserDelegate;
import com.myanmar.tmn.buroole.event.SuccessUserEvent;
import com.myanmar.tmn.buroole.event.UserLogoutEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by msi on 1/24/2018.
 */

public class AccountControlViewPod extends FrameLayout {

    @BindView(R.id.vp_before_login)
    BeforeLoginViewPod vpBeforeLogin;

    @BindView(R.id.vp_login_user)
    LoginUserViewPod vpLoginUser;

    public AccountControlViewPod(@NonNull Context context) {
        super(context);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
        refreshUserSession();
        EventBus.getDefault().register(this);
    }

    public void setDelagate(BeforeLoginDelegate beforeLoginDelegate){
        vpBeforeLogin.setBeforeLoginDelegate(beforeLoginDelegate);
    }

    public void setDelagate(LoginUserDelegate loginUserDelegate){
        vpLoginUser.setLoginUserDelegate(loginUserDelegate);
    }

    public void refreshUserSession() {
        if (LoginUserModel.getOurInstance().isLogin()) {
            vpBeforeLogin.setVisibility(View.GONE);
            vpLoginUser.setVisibility(View.VISIBLE);
        } else {
            vpBeforeLogin.setVisibility(View.VISIBLE);
            vpLoginUser.setVisibility(View.GONE);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginUserSuccess(SuccessUserEvent event) {
        vpBeforeLogin.setVisibility(View.GONE);
        vpLoginUser.setVisibility(View.VISIBLE);

        //bind data from login user
        vpLoginUser.bindData(event.getLoginUserVO());
    }

    @Subscribe( threadMode = ThreadMode.MAIN)
    public void onLogoutUser(UserLogoutEvent event){
        vpBeforeLogin.setVisibility(View.VISIBLE);
        vpLoginUser.setVisibility(View.GONE);
    }
}
