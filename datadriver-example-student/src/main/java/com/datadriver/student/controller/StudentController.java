/*
 * All rights Reserved, Designed By DataDriver
 * Copyright:    DataDriver.Inc
 * Company:      Zhuo Wo Infomation Technology (ShangHai) CO.LTD
 */
package com.datadriver.student.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.datadriver.config.DictionaryType;
import com.datadriver.config.RedisUtils;
import com.datadriver.dictionary.model.DataDictionary;
import com.datadriver.dictionary.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.datadriver.common.entity.Result;
import com.datadriver.common.entity.UnitedException;
import com.datadriver.common.entity.UnitedLogger;
import com.datadriver.common.page.DataTablePage;
import com.datadriver.config.FinalParamer;
import com.datadriver.config.ResultEnum;
import com.datadriver.student.dto.StudentDTO;
import com.datadriver.student.model.Student;
import com.datadriver.student.service.StudentService;
import com.github.pagehelper.PageInfo;

import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Resource
    private StudentService studentService;
    @Resource
    private DictionaryService dictionaryService;
    @Resource
    RedisUtils redisUtils;


    /**
     * 初始化列表页面
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/initListStudentPage.do", method = RequestMethod.GET)
    public String initListStudentPage() {
        return "student/list_student";
    }

    /**
     * 初始化编辑页面
     *
     * @param model
     * @param request
     * @param id
     * @return
     */
    @RequestMapping(value = "/initEditStudent.do", method = RequestMethod.GET)
    public String initEditStudent(Model model, HttpServletRequest request, @RequestParam(value = "id", defaultValue = "") String id) {
        try {
            Student student = new Student();
            // 获取用户信息
            if (StringUtils.isNotBlank(id)) {
                student = studentService.selectById(id);
            }
            model.addAttribute("student", student);
            List<DataDictionary> dataList = dictionaryService.selectByType(DictionaryType.STATUS_TYPE);
            model.addAttribute("statuList", dataList);
        } catch (UnitedException e) {
            UnitedLogger.error(e);
            model.addAttribute(FinalParamer.MESSAGE, e.loadErrorMessageByCode(request));
            model.addAttribute(FinalParamer.RESULT, ResultEnum.FAIL.getValue());
        }
        return "student/edit_student";
    }

    /**
     * 删除学生
     *
     * @param model
     * @param request
     * @param id
     * @return
     */
    @RequestMapping(value = "/delStudentById.json", method = RequestMethod.POST)
    @ResponseBody
    public Result delStudentById(Model model, HttpServletRequest request, @RequestParam(value = "id") String id) {
        Result result = new Result();
        try {
            studentService.delete(id);
            result.setResultCode(ResultEnum.SUCCESS.getValue());
        } catch (UnitedException e) {
            UnitedLogger.error(e);
            result.setResultCode(ResultEnum.FAIL.getValue());
            result.setMessageCode(e.getErrorCode());
            result.setMessage(e.loadErrorMessageByCode(request));
        }
        return result;
    }

    /**
     * 查询列表
     *
     * @param model
     * @param request
     * @param studentDTO
     * @return
     */
    @RequestMapping(value = "/findListStudent.json", method = RequestMethod.POST)
    @ResponseBody
    public DataTablePage<Student> findListStudent(Model model, HttpServletRequest request, @ModelAttribute("studentDTO") StudentDTO studentDTO) {
        DataTablePage<Student> pageList = new DataTablePage<Student>(request);
        try {
            // 转换DataTable的参数传递到service
            studentDTO.setPageNum(pageList.getPageNum());
            studentDTO.setPageSize(pageList.getLength());
            studentDTO.setOrderString(pageList.getOrderStr());
            // 获取分页数据
            PageInfo<Student> pageInfoList = studentService.selectPageByUserName(studentDTO);
            // 转换提取成DataTable的分页参数
            pageList = pageList.transfer(pageList, pageInfoList);
        } catch (UnitedException e) {
            UnitedLogger.error(e);
            model.addAttribute(FinalParamer.MESSAGE, e.loadErrorMessageByCode(request));
            model.addAttribute(FinalParamer.RESULT, ResultEnum.FAIL.getValue());
        }
        //redis操作
//        redisUtils.set("name", pageList);
//        System.out.println(redisUtils.get("name"));
        return pageList;
    }

    /**
     * 保存或修改
     *
     * @param model
     * @param request
     * @param student
     * @return
     */
    @RequestMapping(value = "/saveStudent.json", method = RequestMethod.POST)
    @ResponseBody
    public Result saveStudent(Model model, HttpServletRequest request, @ModelAttribute("student") Student student) {
        Result result = new Result();
        try {
            String idString = student.getStudentId();
            if (StringUtils.isNotBlank(idString)) {
                studentService.update(student);
            } else {
                studentService.insert(student);
            }
            result.setResultCode(ResultEnum.SUCCESS.getValue());
        } catch (UnitedException e) {
            UnitedLogger.error(e);
            result.setResultCode(ResultEnum.FAIL.getValue());
            result.setMessageCode(e.getErrorCode());
            result.setMessage(e.loadErrorMessageByCode(request));
        }
        return result;
    }
}
