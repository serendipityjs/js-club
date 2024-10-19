package com.js.subject.infrastructure.basic.service;

import com.js.subject.comm.entity.PageResult;
import com.js.subject.infrastructure.basic.entity.SubjectInfoEs;

public interface SubjectEsService {

    boolean insert(SubjectInfoEs subjectInfoEs);

    PageResult<SubjectInfoEs> querySubjectList(SubjectInfoEs subjectInfoEs);

}
