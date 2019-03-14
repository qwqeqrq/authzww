package com.auth.control;


import com.auth.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by zww on 2019-03-11.
 */
@RestController
@RequestMapping(value = "Auth")
public class Auth {

    @Autowired
    TokenService tokenService;

    /**
     * @描述： 用户登录 返回token
     * @参数： []
     * @返回值： java.lang.String
     * @创建人： zhangww
     * @创建时间： 2019-03-11
     * @修改人和其它信息：
     */
    @RequestMapping(value = "login")
    public Map<String, String> signIn(@RequestBody Map<String, String> user) {
        return tokenService.getToken(user.get("userName"));
    }

    /**
     * @描述： 用户注销
     * @参数： []
     * @返回值： java.lang.String
     * @创建人： zhangww
     * @创建时间： 2019-03-11
     * @修改人和其它信息：
     */
    @RequestMapping(value = "signOff")
    public Map<String, String> signOff() {

        return null;
    }

}
