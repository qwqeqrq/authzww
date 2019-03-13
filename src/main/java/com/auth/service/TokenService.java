package com.auth.service;

import java.util.Map;

/**
 * Created by zww on 2019-03-11.
 */
public interface TokenService {

    //生成TOKEN
    Map<String, String> getToken();
}
