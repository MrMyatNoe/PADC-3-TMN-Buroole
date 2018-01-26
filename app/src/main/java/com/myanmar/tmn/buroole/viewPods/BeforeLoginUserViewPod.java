package com.myanmar.tmn.buroole.viewPods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.myanmar.tmn.buroole.R;
import com.myanmar.tmn.buroole.delegates.BeforeLoginDelegate;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by msi on 1/20/2018.
 */

public class BeforeLoginUserViewPod extends RelativeLayout {

    private BeforeLoginDelegate beforeLoginDelegate;

    public BeforeLoginUserViewPod(Context context) {
        super(context);
    }

    public BeforeLoginUserViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BeforeLoginUserViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }

    public void setBeforeLoginDelegate(BeforeLoginDelegate beforeLoginDelegate){
        this.beforeLoginDelegate = beforeLoginDelegate;
    }

    @OnClick(R.id.btn_user_login)
    public void onLogin(View view){
        beforeLoginDelegate.onTapToLogin();
    }

    @OnClick(R.id.btn_register)
    public void onRegister(View view){
        beforeLoginDelegate.onTapToRegister();
    }
}
