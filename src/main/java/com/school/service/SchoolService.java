package com.school.service;

import com.school.dto.SchoolDto;
import com.school.entity.SchoolEntity;

import java.util.List;

public interface SchoolService {
    public SchoolDto addStudent(SchoolDto dto);


 public    List<SchoolEntity> getStudents();

    SchoolEntity getStudentById(Long id);

    SchoolDto updataStudent(SchoolDto dto,long id);

    public void deleteStudent(Long id);
}
