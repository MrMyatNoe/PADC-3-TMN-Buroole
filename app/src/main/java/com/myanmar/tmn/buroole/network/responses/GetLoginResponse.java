package com.myanmar.tmn.buroole.network.responses;

import com.google.gson.annotations.SerializedName;
import com.myanmar.tmn.buroole.data.vo.LoginUserVO;

/**
 * Created by msi on 1/26/2018.
 */

public class GetLoginResponse {

    private int code;

    private String message;

    @SerializedName("login_user")
    private LoginUserVO loginUserVO;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public LoginUserVO getLoginUserVO() {
        return loginUserVO;
    }
}
