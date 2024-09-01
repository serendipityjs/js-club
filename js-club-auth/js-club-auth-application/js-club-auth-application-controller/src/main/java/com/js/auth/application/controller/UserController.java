package com.js.auth.application.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.js.auth.application.convert.AuthUserDTOConverter;
import com.js.auth.application.dto.AuthUserDto;
import com.js.auth.common.entity.Result;
import com.js.auth.domain.entity.AuthUserBO;
import com.js.auth.domain.service.AuthUserDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/")
@Slf4j
public class UserController {
    @Resource
    AuthUserDomainService authUserDomainService;

    /**
     * 用户注册
     */
    @RequestMapping("register")
    public Result<Boolean> register(@RequestBody AuthUserDto authUserDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.register.dto:{}", JSON.toJSONString(authUserDTO));
            }
            checkUserInfo(authUserDTO);
            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDTOToBO(authUserDTO);
            return Result.ok(authUserDomainService.register(authUserBO));
        } catch (Exception e) {
            log.error("UserController.register.error:{}", e.getMessage(), e);
            return Result.fail("注册用户失败:" + e.getMessage());
        }
    }


    /**
     * 修改用户信息
     */
    @RequestMapping("update")
    public Result<Boolean> update(@RequestBody AuthUserDto authUserDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.update.dto:{}", JSON.toJSONString(authUserDTO));
            }
            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDTOToBO(authUserDTO);
            return Result.ok(authUserDomainService.update(authUserBO));
        } catch (Exception e) {
            log.error("UserController.update.error:{}", e.getMessage(), e);
            return Result.fail("更新用户信息失败:" + e.getMessage());
        }
    }

    @RequestMapping("doLogin")
    public Result<SaTokenInfo> doLogin(@RequestParam("validCode") String validCode) {
        try {
            Preconditions.checkArgument(!StringUtils.isBlank(validCode), "验证码不能为空!");
            return Result.ok(authUserDomainService.doLogin(validCode));
        } catch (Exception e) {
            log.error("UserController.doLogin.error:{}", e.getMessage(), e);
            return Result.fail("用户登录失败");
        }
    }

    /**
     * 用户退出
     */
    @RequestMapping("logOut")
    public Result logOut(@RequestParam String userName) {
        try {
            log.info("UserController.logOut.userName:{}", userName);
            Preconditions.checkArgument(!StringUtils.isBlank(userName), "用户名不能为空");
            StpUtil.logout(userName);
            return Result.ok();
        } catch (Exception e) {
            log.error("UserController.logOut.error:{}", e.getMessage(), e);
            return Result.fail("用户登出失败");
        }
    }


    // 查询登录状态，浏览器访问：
    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    /**
     * 获取用户信息
     */
    @RequestMapping("getUserInfo")
    public Result<AuthUserDto> getUserInfo(@RequestBody AuthUserDto authUserDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.getUserInfo.dto:{}", JSON.toJSONString(authUserDTO));
            }
            Preconditions.checkArgument(!StringUtils.isBlank(authUserDTO.getUserName()), "用户名不能为空");
            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDTOToBO(authUserDTO);
            AuthUserBO userInfo = authUserDomainService.getUserInfo(authUserBO);
            return Result.ok(AuthUserDTOConverter.INSTANCE.convertBOToDTO(userInfo));
        } catch (Exception e) {
            log.error("UserController.update.error:{}", e.getMessage(), e);
            return Result.fail("更新用户信息失败");
        }
    }


    /**
     * 用户注册信息校验
     *
     * @param authUserDTO
     */
    private void checkUserInfo(AuthUserDto authUserDTO) {
        Preconditions.checkArgument(StringUtils.isNotBlank(authUserDTO.getUserName()), "用户名不能为空");
        Preconditions.checkArgument(StringUtils.isNotBlank(authUserDTO.getPassword()), "密码不能为空");
        Preconditions.checkArgument(StringUtils.isNotBlank(authUserDTO.getEmail()), "邮箱地址不能为空");
    }

}
