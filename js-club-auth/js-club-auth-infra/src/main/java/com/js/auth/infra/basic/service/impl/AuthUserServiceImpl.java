package com.js.auth.infra.basic.service.impl;

import com.js.auth.infra.basic.entity.AuthUser;
import com.js.auth.infra.basic.mapper.AuthUserDao;
import com.js.auth.infra.basic.service.AuthUserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * 用户信息表(AuthUser)表服务实现类
 *
 * @author makejava
 * @since 2024-08-03 19:50:09
 */
@Service("authUserService")
public class AuthUserServiceImpl implements AuthUserService {
    @Resource
    private AuthUserDao authUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AuthUser queryById(Long id) {
        return this.authUserDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param authUser 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(AuthUser authUser) {
        int insert = this.authUserDao.insert(authUser);
        return insert;
    }

    /**
     * 修改数据
     *
     * @param authUser 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(AuthUser authUser) {
        return this.authUserDao.update(authUser);
    }

    /**
     * 查询用户是否存在
     *
     * @param existAuthUser
     * @return
     */
    @Override
    public List<AuthUser> queryByCondition(AuthUser existAuthUser) {
        return this.authUserDao.queryAllByLimit(existAuthUser);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authUserDao.deleteById(id) > 0;
    }
}
