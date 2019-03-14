package com.auth.service;

import java.util.Map;

/**
 * Created by zww on 2019-03-11.
 */
public interface TokenService {

    //生成TOKEN，根据用户信息生成token
    Map<String, String> getToken(String userInfo);
}
