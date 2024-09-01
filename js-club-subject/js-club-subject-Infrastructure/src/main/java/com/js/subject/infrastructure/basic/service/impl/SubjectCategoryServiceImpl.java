package com.js.subject.infrastructure.basic.service.impl;

import com.js.subject.infrastructure.basic.entity.SubjectCategory;
import com.js.subject.infrastructure.basic.mapper.SubjectCategoryDao;
import com.js.subject.infrastructure.basic.service.SubjectCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 题目分类(SubjectCategory)表服务实现类
 *
 * @author makejava
 * @since 2024-06-23 23:22:36
 */
@Service("subjectCategoryService")
public class SubjectCategoryServiceImpl implements SubjectCategoryService {
    @Resource
    private SubjectCategoryDao subjectCategoryDao;


    @Override
    public SubjectCategory queryById(Long id) {
        return subjectCategoryDao.queryById(id);
    }

    /**
     * 查询题目数量
     *
     * @param id
     * @return
     */
    @Override
    public Integer querySubjectCount(Long id) {
        return this.subjectCategoryDao.querySubjectCount(id);
    }

    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectCategory insert(SubjectCategory subjectCategory) {
        this.subjectCategoryDao.insert(subjectCategory);
        return subjectCategory;
    }

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    @Override
    public int update(SubjectCategory subjectCategory) {
        return this.subjectCategoryDao.update(subjectCategory);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectCategoryDao.deleteById(id) > 0;
    }

    @Override
    public List<SubjectCategory> queryCategory(SubjectCategory subjectCategory) {
        List<SubjectCategory> subjectCategories = this.subjectCategoryDao.queryCategory(subjectCategory);
        return subjectCategories;
    }
}
