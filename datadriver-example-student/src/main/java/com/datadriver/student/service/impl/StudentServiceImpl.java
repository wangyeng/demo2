/*
 * All rights Reserved, Designed By DataDriver
 * Copyright:    DataDriver.Inc
 * Company:      Zhuo Wo Infomation Technology (ShangHai) CO.LTD
 */
package com.datadriver.student.service.impl;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.stereotype.Service;

import com.datadriver.common.entity.UnitedException;
import com.datadriver.student.dao.StudentMapper;
import com.datadriver.student.dto.StudentDTO;
import com.datadriver.student.model.Student;
import com.datadriver.student.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public int insert(Student student) throws UnitedException {
        if (student == null) {
            throw new UnitedException("MSG.00002");
        }
        // 姓名必填、长度小于100
        checkName(student.getStudentName());
        // 年龄 不必填 、有效数字 1-120】
        checkAge(student.getStudentAge());
        // 入学时间 时间格式 YYYY-MM-DD
        if (!isValidEntollTime(student.getEnrollmentTime())) {
            throw new UnitedException("MSG.STUDENT.50040");
        }
        return studentMapper.insertSelective(student);
    }

    @Override
    public int delete(String id) throws UnitedException {
        if (StringUtils.isBlank(id)) {
            throw new UnitedException("MSG.00002");
        }
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Student student) throws UnitedException {
        if (student == null || StringUtils.isBlank(student.getStudentId())) {
            throw new UnitedException("MSG.00002");
        }
        // 姓名必填、长度小于100
        checkName(student.getStudentName());
        // 年龄 不必填 、有效数字 1-120
        checkAge(student.getStudentAge());
        // 入学时间 时间格式 YYYY-MM-DD
        if (!isValidEntollTime(student.getEnrollmentTime())) {
            throw new UnitedException("MSG.STUDENT.50040");
        }
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public Student selectById(String id) throws UnitedException {
        if (StringUtils.isBlank(id)) {
            throw new UnitedException("MSG.00002");
        }
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Student> selectPageByUserName(StudentDTO studentDTO) throws UnitedException {
        if (studentDTO == null) {
            throw new UnitedException("MSG.00002");
        }
        PageHelper.startPage(studentDTO.getPageNum(), studentDTO.getPageSize(), true);
        List<Student> list = studentMapper.selectPageByUserName(studentDTO);
        return new PageInfo<Student>(list);
    }

    /**
     * [验证]:姓名必填、长度小于100
     *
     * @param name
     * @throws UnitedException
     */
    private void checkName(String name) throws UnitedException {
        if (StringUtils.isBlank(name)) {
            throw new UnitedException("MSG.STUDENT.50010");
        }
        if (name.length() > 100) {
            throw new UnitedException("MSG.STUDENT.50020");
        }
    }

    /**
     * [验证]:年龄 不必填 、有效数字 1-120
     *
     * @param ageString
     * @throws UnitedException
     */
    private void checkAge(String ageString) throws UnitedException {
        if (StringUtils.isNotBlank(ageString)) {
            String regex = "^[1-9]\\d?$|^1[01]\\d$|^120$";
            Pattern p = Pattern.compile(regex);
            if (!p.matcher(ageString).matches()) {
                throw new UnitedException("MSG.STUDENT.50030");
            }
        }
    }

    /**
     * [验证]:入学时间 时间格式 YYYY-MM-DD
     *
     * @param str
     * @return
     */
    private boolean isValidEntollTime(String str) {
        if (StringUtils.isNotBlank(str)) {
            FastDateFormat formatter = FastDateFormat.getInstance("yyyy-MM-dd");
            try {
                Date date = (Date) formatter.parse(str);
                return str.equals(formatter.format(date));
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

}
