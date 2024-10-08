package com.js.subject.infrastructure.basic.service.impl;

import com.js.subject.infrastructure.basic.entity.SubjectInfo;
import com.js.subject.infrastructure.basic.mapper.SubjectInfoDao;
import com.js.subject.infrastructure.basic.service.SubjectInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 题目信息表(SubjectInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-06-28 10:05:30
 */
@Service("subjectInfoService")
public class SubjectInfoServiceImpl implements SubjectInfoService {
    @Resource
    private SubjectInfoDao subjectInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectInfo queryById(Long id) {
        return this.subjectInfoDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(SubjectInfo subjectInfo) {
        return this.subjectInfoDao.insert(subjectInfo);

    }

    /**
     * 修改数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectInfo update(SubjectInfo subjectInfo) {
        this.subjectInfoDao.update(subjectInfo);
        return this.queryById(subjectInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectInfoDao.deleteById(id) > 0;
    }

    /**
     * 获取分类下对应标签下的所有题目数量
     *
     * @param subjectInfo
     * @param categoryId
     * @param labelId
     * @return
     */
    @Override
    public int getCount(SubjectInfo subjectInfo, Long categoryId, Long labelId) {
        return this.subjectInfoDao.getCount(subjectInfo, categoryId, labelId);
    }

    /**
     * 分页查询题目列表
     *
     * @param subjectInfo
     * @param categoryId
     * @param labelId
     * @param start
     * @param pageSize
     * @return
     */
    @Override
    public List<SubjectInfo> queryPage(SubjectInfo subjectInfo, Long categoryId, Long labelId, int start, Integer pageSize) {
        return this.subjectInfoDao.queryPage(subjectInfo, categoryId, labelId, start, pageSize);

    }
}
