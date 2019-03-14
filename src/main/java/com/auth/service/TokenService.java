package com.auth.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by zww on 2019-03-11.
 */
public interface TokenService {

    //生成TOKEN，根据用户信息生成token
    Map<String, String> getToken(String userInfo);

    //校验用户身份

    //删除TOKEN，根据用户信息删除缓存token 完成注销
    String removeToken(String userInfo);

    //退出登录
    String loginOff(HttpServletRequest request);
}
