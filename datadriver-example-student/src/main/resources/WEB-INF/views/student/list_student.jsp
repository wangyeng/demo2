<%@ page pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<!--[if IE 8]>
<html lang="en" class="ie8 no-js">
<![endif]-->
<!--[if IE 9]>
<html lang="en" class="ie9 no-js">
<![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <jsp:include page="../decorate/contentHead.jsp"></jsp:include>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body>
<div class="row">
    <div class="col-md-12 dd-style-search">
        <div class="portlet light">
            <div class="portlet-body">
                <div class="form">
                    <form class="form-horizontal" role="form" id="studentListForm">
                        <div class="form-body">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label class="control-label col-md-3">
                                            <fmt:message key="PAGE.STUDENT.LIST.STUDENT_NAME"/>
                                        </label>
                                        <div class="col-md-6">
                                            <input type="text" class="form-control input-sm"
                                                   name="studentName" placeholder=""/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-actions right">
                            <div class="row">
                                <div class="col-md-12">
                                    <button type="button" class="btn dd-bg-blue dd-color-white"
                                            id="studentSearchBt">
                                        <fmt:message key="PAGE.GEN.SEARCH"/>
                                    </button>
                                    <button type="button" class="btn dd-bg-orange dd-color-white"
                                            id="studentAddBt">
                                        <fmt:message key="PAGE.GEN.ADD"/>
                                        <i class="fa fa-plus"> </i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-12 dd-style-table">
        <div class="portlet light ">
            <div class="portlet-body">
                <span class="dd-table-title">
                    <fmt:message key="PAGE.STUDENT.LIST"/>
                </span>
                <table class="table table-striped table-bordered table-hover table-checkable order-column"
                       id="studentListTable">
                </table>
            </div>
        </div>
    </div>
    <jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
    <script src="static/module/student/scripts/student.js" type="text/javascript"></script>
</body>
</html>