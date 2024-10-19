package com.js.subject.application.controller;

import com.js.subject.comm.entity.PageResult;
import com.js.subject.infrastructure.basic.entity.SubjectInfoEs;
import com.js.subject.infrastructure.basic.service.SubjectEsService;
import com.js.subject.infrastructure.entity.UserInfo;
import com.js.subject.infrastructure.rpc.UserRpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jiaoshuai
 * @date 2024/6/24 21:22
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class TestFeignController {

    @Resource
    private UserRpc userRpc;

    @Resource
    private SubjectEsService subjectEsService;

    @GetMapping("testFeign")
    public void testFeign() {
        UserInfo userInfo = userRpc.getUserInfo("jiaoshuai");
        log.info("TestFeignController.testFeign.userInfo={}", userInfo);
    }

    @PostMapping("/testEsQuery")
    public void testEsQuery() {
        SubjectInfoEs subjectInfoEs=new SubjectInfoEs();
        subjectInfoEs.setKeyWord("mysql");
        PageResult<SubjectInfoEs> pageResult = subjectEsService.querySubjectList(subjectInfoEs);
        log.info("TestFeignController.testEsQuery.pageResult={}", pageResult);
    }





}