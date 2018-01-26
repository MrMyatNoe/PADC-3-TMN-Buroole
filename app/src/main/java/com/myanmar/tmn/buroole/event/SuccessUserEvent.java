package com.myanmar.tmn.buroole.event;

import com.myanmar.tmn.buroole.data.vo.LoginUserVO;

/**
 * Created by msi on 1/27/2018.
 */

public class SuccessUserEvent {

    private LoginUserVO loginUserVO;

    public SuccessUserEvent(LoginUserVO loginUserVO) {
        this.loginUserVO = loginUserVO;
    }

    public LoginUserVO getLoginUserVO() {
        return loginUserVO;
    }
}
