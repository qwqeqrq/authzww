package com.auth.service;

import com.auth.util.RsaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by zww on 2019-03-11.
 */
@Service
public class TokenServiceImpl implements TokenService {


    @Autowired
    RedisTemplate redisTemplate;

    @Value("${privateKey}")
    private String privateKey;//私钥
    @Value("${publicKey}")
    private String publicKey;//私钥

    /**
     * @描述： 根据用户信息RSA 生成token
     * @参数： [userInfo]
     * @返回值： java.util.Map<java.lang.String                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               java.lang.String>
     * @创建人： zhangww
     * @创建时间： 2019-03-13
     * @修改人和其它信息：
     */
    @Override
    public Map<String, String> getToken(String userInfo) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            String userStr = String.valueOf(System.currentTimeMillis()).concat(userInfo);
            System.out.println("用户："+userStr);
            System.out.println("私钥："+privateKey);
            String token = RsaUtil.autograph(userStr, privateKey, cipher);//进行签名认证拿到token
            Map<String, String> tokenMap = new HashMap<>();
            redisTemplate.opsForValue().set(userInfo,token,60*2, TimeUnit.SECONDS);
            tokenMap.put("token", token);
            return tokenMap;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
