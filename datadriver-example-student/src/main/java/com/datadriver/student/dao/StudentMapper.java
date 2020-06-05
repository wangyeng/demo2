/*
 * All rights Reserved, Designed By DataDriver
 * Copyright:    DataDriver.Inc
 * Company:      Zhuo Wo Infomation Technology (ShangHai) CO.LTD
 */
package com.datadriver.student.dao;

import java.util.List;

import com.datadriver.common.generic.GenericMapper;
import com.datadriver.student.dto.StudentDTO;
import com.datadriver.student.model.Student;

public interface StudentMapper extends GenericMapper<Student, String> {

    List<Student> selectPageByUserName(StudentDTO studentDTO);
}