package com.js.auth.api;


import com.js.auth.entity.AuthUserDTO;
import com.js.auth.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户服务feign
 *
 * @author: ChickenWing
 * @date: 2023/12/3
 */
@FeignClient("js-club-auth-dev")
public interface UserFeignService {

    @RequestMapping("/user/getUserInfo")
    Result<AuthUserDTO> getUserInfo(@RequestBody AuthUserDTO authUserDTO);

}
