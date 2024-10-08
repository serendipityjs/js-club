package com.js.auth.infra.basic.service.impl;

import com.js.auth.infra.basic.entity.AuthPermission;
import com.js.auth.infra.basic.mapper.AuthPermissionDao;
import com.js.auth.infra.basic.service.AuthPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * (AuthPermission)表服务实现类
 *
 * @author makejava
 * @since 2024-08-03 19:51:32
 */
@Service("authPermissionService")
public class AuthPermissionServiceImpl implements AuthPermissionService {
    @Resource
    private AuthPermissionDao authPermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AuthPermission queryById(Long id) {
        return this.authPermissionDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param authPermission 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    @Override
    public Page<AuthPermission> queryByPage(AuthPermission authPermission, PageRequest pageRequest) {
        long total = this.authPermissionDao.count(authPermission);
        return new PageImpl<>(this.authPermissionDao.queryAllByLimit(authPermission, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param authPermission 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(AuthPermission authPermission) {
        return this.authPermissionDao.insert(authPermission);
    }

    /**
     * 修改数据
     *
     * @param authPermission 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(AuthPermission authPermission) {
        return this.authPermissionDao.update(authPermission);
    }

    /**
     * 根据权限id列表查询权限信息
     *
     * @param permissionIdList
     * @return
     */
    @Override
    public List<AuthPermission> queryByRoleList(List<Long> permissionIdList) {
        return this.authPermissionDao.queryByIdList(permissionIdList);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authPermissionDao.deleteById(id) > 0;
    }
}
