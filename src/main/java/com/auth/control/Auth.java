package com.auth.control;

import com.auth.util.AreaCalculation;
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
    /**
     * @描述： 用户登录
     * @参数： []
     * @返回值： java.lang.String
     * @创建人： zhangww
     * @创建时间： 2019-03-11
     * @修改人和其它信息：
     */
    @RequestMapping(value = "login")
    public Map<String, String> signIn() {

        return null;
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


    @RequestMapping(value = "jisuanmianji")
    public static  Double jisuan(@RequestBody double[][] side3) {
        side3 = AreaCalculation.antiClockWiseSort(side3);
        //计算下这四个点围成的正方形的面积
       return AreaCalculation.getmianji(side3);
    }
}
