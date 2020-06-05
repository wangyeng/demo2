<!DOCTYPE html>
<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div id="STUDENT_EDIT_DIV" class="form">
    <form id="STUDENT_EDIT_FORM" class="form-horizontal" role="form">
        <input type="hidden" name="studentId" value="${student.studentId}"/>
        <div class="form-body">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="control-label col-md-3">
                            <fmt:message key="PAGE.STUDENT.LIST.STUDENT_NAME"/>
                            <span class="required" aria-required="true"> * </span>
                        </label>
                        <div class="col-md-9">
                            <input type="text" name="studentName" class="form-control input-sm" placeholder=""
                                   value="${student.studentName}">
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="control-label col-md-3">
                            <fmt:message key="PAGE.STUDENT.LIST.STUDENT_AGE"/>
                        </label>
                        <div class="col-md-9">
                            <input type="text" class="form-control input-sm" name="studentAge" placeholder=""
                                   value="${student.studentAge}">
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="control-label col-md-3">
                            <fmt:message key="PAGE.STUDENT.LIST.STUDENT_ENROLLMENTTIME"/>
                        </label>
                        <div class="col-md-9">
                            <div class="input-group input-medium date" id="timePicker">
                                <input type="text" class="form-control" readonly="readonly" name="enrollmentTime"
                                       value="${student.enrollmentTime}">
                                <span class="input-group-btn">
									<button class="btn default" type="button">
										<i class="fa fa-calendar"></i>
									</button>
								</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="control-label col-md-3">
                            <fmt:message key="PAGE.STUDENT.LIST.STUDENT_REMARK"/>
                        </label>
                        <div class="col-md-9">
                            <input type="text" class="form-control input-sm" name="remark" placeholder=""
                                   value="${student.remark}">
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-actions right">
                <div class="row">
                    <div class="col-md-12">
                        <button type="button" class="btn btn-primary" id="saveStudentBt"
                                onclick="Student.saveStudentData();">
                            <fmt:message key="PAGE.GEN.SAVE"/>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript">
    jQuery(function () {
        // 时间初始化
        jQuery("#timePicker").datepicker({
            language: jQuery("#global_langType").val(),
            todayHighlight: true,
            format: 'yyyy-mm-dd',
            autoclose: true,
            maxViewMode: 2
        });
    });
</script>