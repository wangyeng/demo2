/*
 * All rights Reserved, Designed By DataDriver
 * Copyright:    DataDriver.Inc
 * Company:      Zhuo Wo Infomation Technology (ShangHai) CO.LTD
 */
package com.datadriver.student.service;

import com.datadriver.common.entity.UnitedException;
import com.datadriver.common.generic.GenericService;
import com.datadriver.student.dto.StudentDTO;
import com.datadriver.student.model.Student;
import com.github.pagehelper.PageInfo;

public interface StudentService extends GenericService<Student, String> {

    /**
     * 根据用户名查询
     * 
     * @param studentDTO
     * @return
     * @throws UnitedException
     */
    PageInfo<Student> selectPageByUserName(StudentDTO studentDTO) throws UnitedException;

}
