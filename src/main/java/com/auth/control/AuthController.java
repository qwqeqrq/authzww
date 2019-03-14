package com.auth.control;


import com.auth.service.TokenService;
import com.auth.util.RsaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Map;
import java.util.Optional;

/**
 * Created by zww on 2019-03-11.
 */
@RestController
@RequestMapping(value = "Auth")
public class AuthController {

    @Autowired
    TokenService tokenService;
    @Value("${publicKey}")
    private String publicKey;
    @Autowired
    private RedisTemplate redisTemplate;


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
        //TODO 拿到用户名和密码，解析并校验正确性，如果通过，将用户信息数据进行签名得到token 否则直接返回登录失败
        //注释
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
    public String signOff(@RequestBody Map<String, String> user, HttpServletRequest request) {
        return tokenService.loginOff(request);
    }

}
