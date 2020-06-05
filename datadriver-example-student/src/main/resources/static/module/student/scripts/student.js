var Student = function () {

    var _DataAPI = new Object();
    // 查询列表
    _DataAPI.list = "s/student/findListStudent.json";
    // 初始化编辑页面
    _DataAPI.initEdit = "s/student/initEditStudent.do";
    // 保存修改
    _DataAPI.saveForm = "s/student/saveStudent.json";
    // 删除
    _DataAPI.deleteIt = "s/student/delStudentById.json";

    /**
     * 查询列表
     */
    var draw = 0;
    var listTable = null;
    var _initListTable = function () {
        if (listTable != null) {
            listTable.bootstrapTable("refresh", {
                silent: true
            });
            return;
        }
        jQuery("#studentListTable").empty().attr("class", "").attr("data-resizable", "true");
        listTable = jQuery("#studentListTable").bootstrapTable({
            url: _DataAPI.list,
            toolbar: jQuery("#studentListTable").siblings(".dd-table-title"),
            queryParams: function (params) {
                draw++;
                var formData = jQuery("#studentListForm").serializeJSON(); // 查询表单的参数

                var json = {
                    "draw": draw,
                    "start": params.offset,
                    "length": params.limit
                };
                if (params.sort) {
                    json["order"] = "[{\"column\":\"" + params.sort + "\",\"dir\":\"" + params.order + "\"}]";
                }
                var c = jQuery.extend({}, formData, json);
                return c;
            },
            columns: [{
                field: 'studentName',
                title: i18n.t('STUDENT.STUDENTNAME'),
                sortable: true,
                align: "left",
                halign: "center"
            }, {
                field: 'studentAge',
                title: i18n.t('STUDENT.STUDENTAGE'),
                sortable: true,
                align: "center"
            }, {
                width: "200px",
                field: 'enrollmentTime',
                title: i18n.t('STUDENT.ENROLLMENTTIME'),
                align: "center"
            }, {
                field: 'remark',
                title: i18n.t('STUDENT.REMARK'),
                align: "left",
                halign: "center"
            }, {
                width: "140px",
                field: 'common_operation',// 操作列,key可随意更换
                title: i18n.t('GENERAL.COMMON_OPERATION'),
                align: "center",
                formatter: function (value, c, index) { // value,row,index
                    return "<a href=\"javascript:;\" onclick=\"Student.editStudentBtId(\'" + c.studentId + "\')\">"
                        + i18n.t('GENERAL.EDIT') + "</a>&nbsp;&nbsp;"
                        + "<a href=\"javascript:;\" onclick=\"Student.delStudentBtId(\'" + c.studentId + "\')\">"
                        + i18n.t('GENERAL.DELETE') + "</a>";
                }
            }]
        });
    };

    /**
     * 编辑
     */
    var _editStudentBtId = function (id) {
        jQuery.ajax({
            type: 'GET',
            url: _DataAPI.initEdit + "?id=" + id,
            success: function (data) {
                bootbox.dialog({
                    size: "large",
                    message: data,
                    title: i18n.t('GENERAL.EDIT')
                });
            }
        });
    };

    /**
     * 删除
     */
    var _delStudentBtId = function (id) {
        bootbox.confirm({
            size: 'small',
            message: i18n.t('GENERAL.CONFIRM.GEN'),
            buttons: {
                confirm: {
                    label: i18n.t('GENERAL.OK')
                },
                cancel: {
                    label: i18n.t('GENERAL.CANCEL')
                }
            },
            callback: function (result) {
                if (result) {
                    jQuery.ajax({
                        type: 'POST',
                        url: _DataAPI.deleteIt,
                        data: {
                            "id": id
                        },
                        success: function (data) {
                            var result = data;
                            var dataHtml = "";
                            if (result.resultCode == 1) {
                                dataHtml = i18n.t('GENERAL.SUCCESS');
                            } else {
                                var message = result.message;
                                dataHtml = message;
                            }
                            _initListTable();
                            bootbox.alert({
                                size: 'small',
                                message: dataHtml
                            });
                        }
                    });
                }
            }
        })
    };

    var _saveStudentDataBefore = function () {
        // Form 验证字段内容
        jQuery("#STUDENT_EDIT_FORM").validate({
            focusInvalid: false,
            errorClass: 'dd-validate-error', // 使用自定义样式
            validClass: 'dd-validate-valid',// 使用自定义样式
            errorElement: "span",
            rules: {
                "studentName": {
                    required: true,
                    maxlength: 100
                },
                "studentAge": {
                    number: true,
                    range: [1, 120]
                }
            },
            onkeyup: false,
            messages: {
//                "studentName" : {
//                    required : i18n.t('STUDENT.VALID.STUDENTNAME_NULL')
//                }
            }
        });

        var addForm = jQuery("#STUDENT_EDIT_FORM");
        if (!addForm.valid())
            return false;

        bootbox.confirm({
            size: 'small',
            message: i18n.t('GENERAL.CONFIRM.GEN'),
            buttons: {
                confirm: {
                    label: i18n.t('GENERAL.OK')
                },
                cancel: {
                    label: i18n.t('GENERAL.CANCEL')
                }
            },
            callback: function (result) {
                if (result) {
                    _saveStudentData();
                }
            }
        })
    };

    /**
     * 保存
     */
    var _saveStudentData = function () {
        jQuery('#STUDENT_EDIT_FORM').showLoading();
        jQuery.ajax({
            type: 'POST',
            url: _DataAPI.saveForm,
            data: jQuery("#STUDENT_EDIT_FORM").serialize(),
            success: function (data) {
                var result = data;
                var dataHtml = "";
                if (result.resultCode == 1) {
                    dataHtml = i18n.t('GENERAL.SUCCESS');
                } else {
                    dataHtml = result.message;
                }
                jQuery('#STUDENT_EDIT_FORM').hideLoading();
                bootbox.alert({
                    size: 'small',
                    message: dataHtml,
                    callback: function (result) {
                        _initListTable();
                        bootbox.hideAll(); // 隐藏所有的bootbox
                    }
                });
            }
        });
    };

    /**
     * 新增
     */
    jQuery("#studentAddBt").click(function () {
        _editStudentBtId('');
    });

    return {
        init: function () {
            GlobalCommon.i18nAddResource("student");
            _initListTable();
            jQuery("#studentSearchBt").click(function () {
                _initListTable();
            });
        },
        editStudentBtId: function (id) {
            _editStudentBtId(id);
        },
        delStudentBtId: function (id) {
            _delStudentBtId(id);
        },
        saveStudentData: function () {
            _saveStudentDataBefore();
        }
    };

}();

jQuery(function () {
    // 执行
    Student.init();
});