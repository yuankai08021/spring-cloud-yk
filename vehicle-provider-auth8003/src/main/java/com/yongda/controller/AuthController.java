package com.yongda.controller;

import com.yongda.entities.CommonResult;
import com.yongda.entities.User;
import com.yongda.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @Auther yuank
 * @CreateTime 2020/11/19 15:59
 **/
@RestController
@Slf4j
public class AuthController {
    @Resource
    private AuthService authService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * @Description: 创建用户
     * @Param [user]
     * @return com.yongda.entities.CommonResult
     * @Auther yuank
     * @CreateTime 2020/11/12 10:43
     */
    @PostMapping(value="/auth/createuser")
    public CommonResult createUser(@RequestBody User user) {
        int result = authService.create(user);
        log.info("****插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据成功, port:" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败, port:" + serverPort, null);
        }
    }

    /**
     * @Description: 根据用户id查询用户
     * @Param [id]
     * @return com.yongda.entities.CommonResult
     * @Auther yuank
     * @CreateTime 2020/11/12 10:43
     */
    @GetMapping(value="/auth/getuser/{id}")
    public CommonResult getUserById(@PathVariable("id") Long id) {
        User user = authService.getUserById(id);
        log.info("****查询结果：" + user);

        if(user != null){
            return new CommonResult(200,"查询成功, port:" + serverPort, user);
        }else{
            return new CommonResult(444,"没有查询到记录，查询ID:"+id+"; port:"+serverPort,null);
        }
    }

    /**
     * @Description: 根据用户id更新用户信息
     * @Param [id]
     * @return com.yongda.entities.CommonResult
     * @Auther yuank
     * @CreateTime 2020/11/12 10:46
     */
    @PatchMapping(value="/auth/updateuser/{id}")
    public CommonResult updateUserById(@PathVariable("id") Long id) {
        return null;
    }

}
