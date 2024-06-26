package com.js.subject.application.controller;

import com.js.subject.infrastructure.basic.entity.SubjectCategory;
import com.js.subject.infrastructure.basic.service.SubjectCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jiaoshuai
 * @date 2024/6/23 22:50
 */
@RestController
public class SubjectController {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @GetMapping("/test")
    public String test() {
        SubjectCategory subjectCategory = subjectCategoryService.queryById(1L);
        return "hello world"+subjectCategory.getCategoryName();
    }


}
