var flag = false;
var fileNum;
function openUpload() {
    $('input[id=lefile]').click();
}
function openClientUpload() {
    $('input[id=leClientfile]').click();
}

/*
 * 上传驱动功能
 * */
$("#upload").click(
    function () {
        cleanUpdateShowImg();
        var formString = "<form class=\"form-horizontal\" id=\"formForDriver\">" +
            "<p>&nbsp;</p>" +
            "<div class=\"control-group\">" +
            "型号　　<select name=\"driverType\" id='driverTypeForCopy' class=\"select\" style=\"width: 220px;height: 30px;\">" +
            "<option value=\"1\">门锁</option>" +
            "<option value=\"2\">身份证</option>" +
            "<option value=\"3\">税控机</option>" +
            "</select>" +
            "</div>" +
            "<div class=\"control-group\">" +
            "名称　　<input type=\"text\" id=\"inputCodeForCopy\" name='typeCode' placeholder=\"code...\">" +
            "<input type=\"text\"  id=\"driverCurrentUUID\" style='display: none' name='currentUUID'>" +
            "</div>" +
            "<div class=\"control-group\">版本　　<input type=\"text\" name='version' id=\"inputVersionForCopy\" placeholder=\"version\">" +
            "</div>" +
            "<div class=\"control-group\">" +
            "描述　　<textarea id=\"inputDescriptionForCopy\"  name='description' style='height: 80px;' placeholder=\"驱动介绍\"></textarea>" +
            "</div>" +
            "<div class=\"control-group\">" +
            "<input id=\"lefile\" onchange='lefileChange()' name='zipFile' style='display: none;' type=\"file\">" +
            "<label style=\"margin-right: 3px;\" onclick='openUpload()' class=\" btn btn-default\">上传驱动</label>" +
            "<input type=\"text\" id='showFile' style=\"width: 163px;background-color: #fff;\" placeholder=\"driver_name\" disabled>" +
            "</div>" +
            "<div class=\"controls-group\">" +
            "<button type=\"button\" onclick='doUpdate()' class=\"btn btn-success\">&nbsp;上&nbsp;传&nbsp;</button>" +
            "</div>" +
            "</form>";
        showTable(formString, "nosearch", 1);
    }
)
/*
 * 上传客户端功能
 * */
$("#uploadClient").click(
    function () {
        cleanUpdateShowImg();
        var result = doAjax("/searchDrevers/allDrivers.htm", "");
        var checkboxString = "<div style='padding-top: 20px;padding-bottom: 10px;'><form id=\"formClient\"><h5>门锁驱动</h5>";
        checkboxString += "<table width=\"95%;\" >";
        var dlFlag = 0;
        $.each(result.data.DL, function (i, eve) {
            if (dlFlag % 5 == 0) {
                checkboxString += "<tr>";
            }
            dlFlag++;
            checkboxString += "<td><label><input style=\"width: 16px;height: 16px;margin-top: 0px;\" type=\"checkbox\" name='drivers' onclick='driverCheckboxChange()' value='" + eve.id + "'>&nbsp;&nbsp;" + eve.typeCode + "_" + eve.version + "</label></td>";
            if (dlFlag % 5 == 0) {
                checkboxString += "</tr>";
            }
        });
        if (dlFlag % 5 >= 0) {
            for (var i = dlFlag % 5; i < 5; i++) {
                checkboxString += "<td width='20%'></td>";
                if (i == 4) {
                    checkboxString += "</tr>";
                }
            }
        }
        checkboxString += "</table>";
        checkboxString += "<h5>身份证驱动</h5>"
        checkboxString += "<table width=\"95%;\">";
        var idFlag = 0;
        $.each(result.data.ID, function (i, eve) {
            if (idFlag % 5 == 0) {
                checkboxString += "<tr>";
            }
            idFlag++;
            checkboxString += "<td><label><input style=\"width: 16px;height: 16px;margin-top: 0px;\" type=\"checkbox\" name='drivers' onclick='driverCheckboxChange()' value='" + eve.id + "'>&nbsp;&nbsp;" + eve.typeCode + "_" + eve.version + "</label></td>";
            if (idFlag % 5 == 0) {
                checkboxString += "</tr>";
            }
        });
        if (idFlag % 5 >= 0) {
            for (var i = idFlag % 5; i < 5; i++) {
                checkboxString += "<td width='20%'></td>";
                if (i == 4) {
                    checkboxString += "</tr>";
                }
            }
        }
        checkboxString += "</table>";
        checkboxString += "<h5>控税机驱动</h5>"
        checkboxString += "<table width=\"95%;\">";
        var tcmFlag = 0;
        $.each(result.data.TCM, function (i, eve) {
            if (tcmFlag % 5 == 0) {
                checkboxString += "<tr>";
            }
            tcmFlag++;
            checkboxString += "<td><label><input style=\"width: 16px;height: 16px;margin-top: 0px;\" type=\"checkbox\" name='drivers' onclick='driverCheckboxChange()'  value='" + eve.id + "'>&nbsp;&nbsp;" + eve.typeCode + "_" + eve.version + "</label></td>";
            if (tcmFlag % 5 == 0) {
                checkboxString += "</tr>";
            }
        });
        if (tcmFlag % 5 >= 0) {
            for (var i = tcmFlag % 5; i < 5; i++) {
                checkboxString += "<td width='20%'></td>";
                if (i == 4) {
                    checkboxString += "</tr>";
                }
            }
        }

        checkboxString += "</table>";
        checkboxString += "<input type='button' onclick='updateClient()' id='clientUpdateButton' class='btn  btn-success' value='查询'></from></div>";
        showTable(checkboxString, "nosearch", 3);
    }
)

function driverCheckboxChange() {
    if ($("#clientUpdateButton").val() == "复制链接") {
        $("#copyContent").remove();
        $("#clientUpdateButton").attr("onclick", "updateClient()").attr("name", "").val("查询").attr("class", "btn  btn-success");

    }
}

function downloadClient() {
    // var text = $("#clientUpdateButton").attr("name");
    $("#copyContent").val($("#clientUpdateButton").attr("name"));
    $("#copyContent").select(); // 选中文本
    document.execCommand("copy"); // 执行浏览器复制命令
    alert("复制成功");
    // location.href = $("#clientUpdateButton").attr("name");
}
function updateClient() {
    var form = new FormData(document.getElementById("formClient"));
    $.ajax({
        url: "/upload/searchClient.htm",
        type: "post",
        data: form,
        dataType: "json",
        async: false,
        processData: false,
        contentType: false,
        success: function (result) {
            if (result.success) {
                if (result.data.clientUrl != undefined && result.data.clientUrl != "" && result.data.clientUrl != null) {
                    $("#clientUpdateButton").attr("onclick", "downloadClient()").attr("name", "" + result.data.clientUrl + "").val("复制链接").attr("class", "btn btn-warning btn-lg");
                    $("#clientUpdateButton").after("<textarea   id='copyContent' style='position: fixed;top: -1000px;'></textarea>");
                } else {
                    alertWarn("驱动打包上传中，请稍等...", 2);
                }
                /* zzhi*/
                // if (result.data.clientUrl != undefined && result.data.clientUrl != "" && result.data.clientUrl != null) {
                //     alertWarn("该客户端已经存在 !", 2, 1500);
                //     $("#clientUpdateButton").attr("onclick", "downloadClient()").attr("name", "" + result.data.clientUrl + "").val("点击复制").attr("class", "btn btn-warning btn-lg");
                //     $("#clientUpdateButton").after("<textarea   id='copyContent' style='position: fixed;top: -1000px;'></textarea>");
                // } else {
                //     if (result.errorCode == "525") {
                //         alertWarn("已经存在，需要上传客户端文件!", 1, 2500);
                //     } else {
                //         alertWarn("新增成功!", 1, 2500);
                //     }
                //     var item = "<form class=\"form-horizontal\" id=\"clientFormResult\">" +
                //         "<p>&nbsp;</p>" +
                //         "<div class=\"control-group\">" +
                //         "客户端id:<input type=\"text\"  id=\"inputCodeForCopy\" style='background-color: white;' name='clientId' value='" + result.data.clientId + "' readonly>" +
                //         "<input type=\"text\"  id=\"currentUUID\" style='display: none' name='currentUUID'>" +
                //         "</div>" +
                //         "<input id=\"leClientfile\" name='clientFile' onchange='lefileClientChange()'  style='display: none;' type=\"file\">" +
                //         "<div class=\"control-group\">" +
                //         "<label style=\"margin-right: 3px;\" onclick='openClientUpload()' class=\" btn btn-default\">客户端文件</label>" +
                //         "<input type=\"text\" id='showClientFile' style=\"width: 163px;background-color: #fff;\"  disabled>" +
                //         "</div>" +
                //         "<div class=\"controls-group\">" +
                //         "<button type=\"button\" onclick='doUpdateClient_()' class=\"btn btn-success\">&nbsp;上&nbsp;传&nbsp;</button>" +
                //         "</div>" +
                //         "</form>";
                //     showTable(item, "nosearch", 4);
                // }
            } else {
                alertWarn(result.errorMsg, 0);
            }

        },
        error: function (e) {
            flag = false;
        }
    });
}

/*
 * 下载功能
 * */
$("#download").click(
    function () {
        cleanUpdateShowImg();
        $("#show").css("display", "none");
        $("#searchDoor").css("display", "none");
        $.ajax({
            url: "/download/standardPackage.htm",
            type: "get",
            data: "",
            dataType: 'json',
            async: false,
            success: function (result) {
                if (result.success == true) {
                    location.href = result.data;
                    alertWarn("请求成功 !", 1);
                } else {
                    alertWarn("请求失败,请刷新页面重试 !", 0);
                }

            },
            error: function (e) {
                alertWarn("请求异常...", 0);
            }
        });
    }
)
/*
 * 关闭提示功能
 * */
$(".close").click(
    function () {
        $($(this).parent()).slideUp(300);
    }
)
/*
 * 上传文件触发
 * */
function lefileChange() {
    $('#showFile').val($('#lefile').val());
}
function lefileClientChange() {
    $('#showClientFile').val($('#leClientfile').val());
}
/**
 * 点击上传触发上传提示信息
 */
function doUpdate() {
    $('#wxts').click();
}
/**
 * 摧毁当前元素
 */
function destroyThis() {
    $(this).hide();
    $(this).remove();
}

function cleanUpdateShowImg() {
    if ($("#uploadShow").css("display") != "none") {
        $("#uploadShow").empty();
        $("#uploadShow").append("<IMG id=\"uploadShowImg\" src=\"/static/crawler/img/upOSS.gif\"  width=\"200px\" >");
        $("#uploadShow").css("display", "none").css("width", "250px").css("height", "250px").css("margin-top", "100px");
        $("#futurehotel").show(1000);
    }
    if ($("#driverUploadShow").css("display") != "none") {
        $("#driverUploadShow").empty();
        var con = "<IMG id=\"driverUploadShowImg\" src=\"/static/crawler/img/upOSS.gif\" width=\"100px\"><div id=\"driverUploadShowMsg\"><div id=\"check0\" data-resultFlag=\"0\" name=\"check0\" style=\"font-family: 微软雅黑;font-size: 10px;position: relative;left:-30%;top:60px;width: 80px;\">文件唯一检测<imgid=\"check0Img\" src=\"/static/crawler/img/check.png\" width=\"20px\" height=\"20px\"></div><div id=\"check1\" data-resultFlag=\"0\" name=\"check1\" style=\"font-family: 微软雅黑;font-size: 10px;position: relative;left:-10%;top:40px;width: 80px;\">文件结构检测<imgid=\"check1Img\" src=\"/static/crawler/img/check.png\" width=\"20px\" height=\"20px\"></div><div id=\"check2\" data-resultFlag=\"0\" name=\"check2\" style=\"font-family: 微软雅黑;font-size: 10px;position: relative;left:10%;top:20px;width: 80px;\">代码实现检测<imgid=\"check2Img\" src=\"/static/crawler/img/check.png\" width=\"20px\" height=\"20px\"></div><div id=\"check3\" data-resultFlag=\"0\" name=\"check3\" style=\"font-family: 微软雅黑;font-size: 10px;position: relative;left:30%;width: 80px;\">文件压缩上传<imgid=\"check3Img\" src=\"/static/crawler/img/check.png\" width=\"20px\" height=\"20px\"></div><div id='progressBarDriver' style=\"height: 130px; background-color: #EEEEEE;\"><div id='rateOfProgressDriverDiv' class=\"progress progress-success progress-striped active\"style=\"height: 12px;width: 100%;\"><div id=\"rateOfProgressDriver\" class=\"bar\"style=\"width: 10%;font-size: 10px;line-height: 12px;font-weight: 900;color:black;\"></div></div></div></div>";
        $("#driverUploadShow").append(con).css("display", "none");
        $("#futurehotel").show(1000);
    }
}
function doUpdateClient_() {
    $("#currentUUID").val(getUUID());
    $("#show").slideUp(400);
    $("#futurehotel").slideUp(0);
    $("#uploadShow").slideDown(400);
    var item = "<div id='md5LoadDiv' style='margin-bottom: 10px;'><span id='md5LoadSpan' style='font-family: 微软雅黑;margin-top: 10px;font-size: 13px;'>正在MD5校验</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img id='md5LoadImg' src='/static/crawler/img/load.gif' width='17px;'  /></div><div id='progressBar' style=\"width: 70%;height: 130px; background-color: #EEEEEE;\"><div id='rateOfProgressDiv' class=\"progress progress-success progress-striped active\"  style=\"height: 12px;width: 90%;\"><div id=\"rateOfProgress\"  class=\"bar\" style=\"width: 0%;font-size: 10px;line-height: 12px;font-weight: 900;color:black;\"></div></div>";
    $("#uploadShow").append(item);
    setTimeout("doUpdateClient()", 100);
    clock = setInterval("getProgress()", 500);
}
function getUUID() {
    function S4() {
        return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
    }

    return (S4() + S4() + "-" + S4() + "-" + S4() + "-" + S4() + "-" + S4() + S4() + S4());
}
function doUpdateClient() {
    var form = new FormData(document.getElementById("clientFormResult"));
    $.ajax({
        url: "/upload/uploadClient.htm",
        type: "post",
        data: form,
        dataType: "json",
        async: true,
        processData: false,
        contentType: false,
        success: function (result) {
            console.log(result);
            console.log(result.success);
            if (result.success) {
                if (result.errorMsg == null || result.errorMsg == "" || result.errorMsg == undefined) {
                    alertWarn("上传成功！", 1, 2000);
                    $("#uploadShowImg").attr("src", "/static/crawler/img/successGIF.gif");
                    if ($("#md5LoadSpan").text() == "正在MD5校验") {
                        $("#md5LoadSpan").text("MD5校验通过");
                        $("#md5LoadImg").attr("src", "/static/crawler/img/success.ico");
                    }
                    $("#rateOfProgress").css("width", "100%")
                    $("#rateOfProgress").text("100%");
                    setTimeout("location.reload()", 1500);
                } else {
                    alertWarn(result.data, 1, 2000);
                    $("#currentUUID").val(result.errorMsg + "-#_3");
                }
            } else {
                alertWarn("上传失败！", 1, 4000);
                clearInterval(clock);
                $("#uploadShowImg").attr("src", "/static/crawler/img/cloud_fail.png").attr("width", "100px");
                $("#progressBar").remove();
                $("#md5LoadDiv").remove();
                var divString = "<div style='width: 300px;color: red;padding-top:40px;' align='left'><p>上传失败：" + result.errorMsg + "</p><p style='color: #499249;line-height: 35px;'>建议：刷新页面重试 / 联系管理员</p></div>";
                $("#uploadShowImg").after(divString);
            }
        },
        error: function (e) {
            alertWarn("请求异常！", 1, 4000);
            clearInterval(clock);
            $("#uploadShowImg").attr("src", "/static/crawler/img/uploadError.png");
            $("#progressBar").remove();
            var divString = "<div style='width: 300px;color: red;padding-top:40px;' align='left'><p>请求异常：链接服务器失败！</p><p style='color: #499249;line-height: 35px;'>建议：刷新页面重试 / 联系管理员</p></div>";
            $("#uploadShowImg").after(divString);
        }
    });
}
String.prototype.endWith = function (str) {
    if (str == null || str == "" || this.length == 0 || str.length > this.length)
        return false;
    if (this.substring(this.length - str.length) == str)
        return true;
    else
        return false;
    return true;
}
/**
 * 获取进度方法
 */
function getProgress() {
    var uuid = $("#currentUUID").val();
    var flag = false;

    if (uuid.endWith("-#_3")) {
        flag = true;
        uuid = uuid.substring(0, uuid.length - 4);
    }
    $.ajax({
        url: "/upload/getProgress.htm",
        type: "post",
        data: {"currentUUID": uuid},
        dataType: "json",
        async: false,
        success: function (result) {
            var currentWidth = $("#rateOfProgress").width();
            var currentParentWidth = $("#rateOfProgress").parent().width();
            var res = parseInt(currentWidth) / parseInt(currentParentWidth)
            if (result + 3 > res * 100) {
                if (result >= 98) {
                    $("#rateOfProgress").css("width", "100%")
                    $("#rateOfProgress").text("100%");
                } else {
                    if (result == 0) {
                        $("#rateOfProgress").text(result + "%");
                    } else {
                        if ($("#md5LoadSpan").text() == "正在MD5校验") {
                            $("#md5LoadSpan").text("MD5校验通过");
                            $("#md5LoadImg").attr("src", "/static/crawler/img/success.ico");
                        }
                        $("#rateOfProgress").css("width", result + 2 + "%")
                        $("#rateOfProgress").text(result + 2 + "%");
                    }

                }
            } else {
                if (flag) {
                    $("#rateOfProgress").css("width", "100%")
                    $("#rateOfProgress").text("100%");
                    alertWarn("上传成功！", 1, 2000);
                    $("#uploadShowImg").attr("src", "/static/crawler/img/successGIF.gif");
                    setTimeout("location.reload()", 1500);
                    clearinterval(clock);
                }
            }
        }
    })
}

function showSchedule() {
    var typeCode = $("#inputCodeForCopy").val();
    if ($("#driverTypeForCopy").val() == "1") {
        if (typeCode == "" || typeCode == undefined) {
            alertWarn("门锁code不能为空 !", 0, 2000);
            return;
        }
    }
    var version = $("#inputVersionForCopy").val();
    if (version == "" || version == undefined) {
        alertWarn("驱动版本号不能为空 !", 0, 2000);
        return;
    }
    var zipfile = $('input[id=lefile]').val();
    if (zipfile == "" || zipfile == undefined) {
        alertWarn("提交前必须上传文件 !", 0, 2000);
        return;
    }
    if (zipfile.indexOf(".zip") < 0) {
        alertWarn("文件格式需要ZIP格式 ! ", 0, 2000);
        return;
    }
    // 进度条
    // var item = "<div style=\"width: 70%;height: 130px; background-color: #EEEEEE;margin-top: 100px;\"><div><img id=\"updateImg1\" src=\"/static/crawler/img/pendingVerificationTask.png\" style=\"position: relative;width: 27px;top: 72px;right:23%;border-radius: 6px;background-color: white;\"></div><div><img id=\"updateImg2\" src=\"/static/crawler/img/pendingVerificationTask.png\" style=\"position: relative;width: 27px;top: 45px;border-radius: 6px;background-color: white;\"></div><div><img id=\"updateImg3\" src=\"/static/crawler/img/pendingVerificationTask.png\" style=\"position: relative;width: 27px;top: 18px;left:23%;border-radius: 6px;background-color: white;\"></div><div id='rateOfProgressDiv' class=\"progress progress-success progress-striped active\"  style=\"height: 12px;width: 90%;\"><div id=\"rateOfProgress\"  class=\"bar\" style=\"width: 0%;\"></div></div><div style=\"position: relative;width: 88px;top: 0px;right:23%;border-radius: 6px;background-color: #EEEEEE;\">完整度检测</div><div style=\"position: relative;width: 77px;top: -21px;border-radius: 6px;background-color: #EEEEEE;\">代码检测</div><div style=\"position: relative;width: 65px;top: -41px;left:23%;border-radius: 6px;background-color: #EEEEEE;\">持久化</div></div>";
    // showTable(item, "nosearch", 2);
    var uuid = getUUID();
    $("#driverCurrentUUID").val(uuid);
    $("#show").slideUp(400);
    $("#futurehotel").slideUp(0);
    //改变检查P标签Name
    $("#check0").attr("name", uuid + "-check0");
    $("#check1").attr("name", uuid + "-check1");
    $("#check2").attr("name", uuid + "-check2");
    $("#check3").attr("name", uuid + "-check3");
    $("#driverUploadShow").slideDown(400);
    setTimeout("safetyChecking()", 500);
    driverCheck = setInterval("updateCheckingProgress()", 1000);

}
/*
 * 信息提示总方法
 * type 0:错误 1:成功 2:警告
 * */
function alertWarn(content, type, upTime) {
    $("#warningContent").text(content);
    if (type == 0) {
        $("#worningImage").attr('src', "/static/crawler/img/error.ico");
        $("#warningType").text("错误 : ");
        $("#warning").attr('class', "alert alert-error")
    } else if (type == 1) {
        $("#worningImage").attr('src', "/static/crawler/img/success.ico");
        $("#warningType").text("成功 : ");
        $("#warning").attr('class', "alert alert-success")
    } else if (type == 2) {
        $("#worningImage").attr('src', "/static/crawler/img/warning.ico");
        $("#warningType").text("警告 : ");
        $("#warning").attr('class', "alert alert-warning")
    }

    $("#warning").slideDown(500);

    if (upTime != null && upTime != undefined && upTime != "") {
        setTimeout(function () {
            $(".close").click();
        }, upTime);
    } else {
        setTimeout(function () {
            $(".close").click();
        }, 5000);
    }

}
/*
 * ajax 访问方法
 * */
function doAjax(urlString, params) {
    var resultObject;
    $.ajax({
        url: urlString,
        type: "get",
        data: params,
        dataType: 'json',
        async: false,
        success: function (result) {
            resultObject = result;
        },
        error: function (e) {
            flag = false;
        }
    });
    return resultObject;
}
/*
 * 搜索展示
 * */

/*
 * 初始化上传文件, 完整度检测
 * */
function safetyChecking() {
    var form = new FormData(document.getElementById("formForDriver"));
    $.ajax({
        url: "/upload/safetyChecking.htm",
        type: "post",
        data: form,
        dataType: "json",
        async: false,
        processData: false,
        contentType: false,
        success: function (result) {
            console.log(result);
            if (result.success) {
                console.log(result)
                //方案改变 暂时注掉
                // alertWarn("上传成功!", true, 1500);
                // $("#uploadShowImg").attr("src", "/static/crawler/img/successGIF.gif")
                // setTimeout("location.reload()", 1500);
            } else {
                //方案改变 暂时注掉
                // $("#uploadShowImg").attr("src", "/static/crawler/img/cloud_fail.png").css("width", "95px").css("height", "80px");
                // var divString = "<div style='width: 300px;color: red;padding-top:40px;' align='left'>" + result.errorMsg + "<p style='color: #499249;line-height: 35px;'>建议：刷新页面重试 / 联系管理员</p></div>";
                // $("#uploadShowImg").after(divString);
            }
        },
        error: function (e) {
            $("#driverUploadShow").attr("src", "/static/crawler/img/cloud_fail.png").css("width", "95px").css("height", "80px");
            $("#driverUploadShowMsg").remove();
            var divString = "<div style='width: 300px;color: red;padding-top:40px;' align='left'><p>请求异常!</p><p style='color: #499249;line-height: 35px;'>建议：刷新页面重试 / 联系管理员</p></div>";
            $("#driverUploadShow").after(divString);
            clearInterval(driverCheck);
        }
    });
}
/**
 * 循环检测执行进度
 */
function updateCheckingProgress() {
    if ($("#check0").attr("data-resultFlag") == "0") {
        //查询第一步检查结果
        getCheckProgress("check0");
    } else {
        if ($("#check1").attr("data-resultFlag") == "0") {
            //查询第一步检查结果
            getCheckProgress("check1");
        } else {
            if ($("#check2").attr("data-resultFlag") == "0") {
                //查询第二步检查结果
                getCheckProgress("check2");
            } else {
                if ($("#check3").attr("data-resultFlag") == "0") {
                    //查询第三步检查结果
                    getCheckProgress("check3");
                } else {
                    //全部检查都已经通过
                    $("#driverUploadShowImg").attr("src", "/static/crawler/img/successGIF.gif");
                    var divString = "<div style='width: 250px;color: green;padding-bottom:20px;' align='center' ><p>上传成功！</p></div>";
                    $("#driverUploadShowImg").after(divString);
                    clearInterval(driverCheck);
                }
            }
        }
    }

}
function getCheckProgress(checkId) {
    var driverCurrentUUID = $("#" + checkId).attr("name");
    $.ajax({
        url: "/upload/getCheckProgress.htm",
        type: "post",
        data: {"driverCurrentUUID": driverCurrentUUID},
        dataType: "json",
        async: false,
        success: function (result) {
            if (result.success) {
                var resultData = result.data;
                if (resultData.indexOf("SUCCESS") >= 0) {
                    $("#" + checkId).attr("data-resultFlag", 1);
                    $("#" + checkId + "Img").attr("src", "/static/crawler/img/pass.png");
                    var id = parseInt(checkId.substring(checkId.length - 1));
                    var number = (id + 1) * 20 + 10;
                    if (number == 90) {
                        number = 100;
                    }
                    $("#rateOfProgressDriver").css("width", number + "%");

                } else {
                    $("#" + checkId).attr("data-resultFlag", 1);
                    $("#" + checkId + "Img").attr("src", "/static/crawler/img/notPass.png");
                    $("#driverUploadShowImg").attr("src", "/static/crawler/img/cloud_fail.png");
                    var divString = "<div style='width: 300px;color: red;padding-top:40px;' align='left'><p>" + result.data + "</p><p style='color: #499249;line-height: 35px;'>建议：刷新页面重试 / 联系管理员</p></div>";
                    $("#driverUploadShowImg").after(divString);
                    clearInterval(driverCheck);
                }
            }
        }
    })
}


/*
 * 搜索展示
 * */
$(".customSearch").click(
    function () {
        cleanUpdateShowImg();
        $("#show").fadeOut(0);
        $("#searchDoor").fadeIn(500);
    }
);
/*
 * 驱动查询 , 门锁,身份证,控税机 按钮
 * */
$(".drivertype").click(
    function () {
        cleanUpdateShowImg();
        var url = "";
        if ($(this).val() == 1) {
            url = "/searchDrevers/doorlock.htm";
        }
        if ($(this).val() == 2) {
            url = "/searchDrevers/identity.htm";
        }
        if ($(this).val() == 3) {
            url = "/searchDrevers/taxprinter.htm";
        }
        if ($(this).val() == 4) {
            url = "/searchDrevers/readCard.htm";
        }
        if ($(this).val() == 5) {
            url = "/searchDrevers/makeCard.htm";
        }
        $.ajax({
            url: url,
            type: "post",
            dataType: 'json',
            async: false,
            success: function (result) {
                var item = "";
                $.each(result.data, function (i, eve) {
                    item += "<tr class='success'><td>" + getDriverType(eve.driverType) + "</td><td>" + eve.typeCode + "</td><td>" + eve.version + "</td><td>" + eve.equipmenter + "</td><td>" + eve.uploader + "</td></tr>";
                });
                showTable(item, "nosearch", 0);
            },
            error: function (e) {
                alertWarn("请求失败..", 0);
            }

        });
    }
)
function getDriverType(driverType) {
    if (driverType == 1) {
        return "门锁";
    } else if (driverType == 2) {
        return "身份证";
    } else if (driverType == 3) {
        return "控税机";
    } else {
        return driverType;
    }
}

/*
 * 自定义查询 查询操作
 * */
function customSearch() {
    var form = new FormData(document.getElementById("searchForm"));
    $.ajax({
        url: "/searchDrevers/custom.htm",
        type: "post",
        data: form,
        dataType: 'json',
        processData: false,
        contentType: false,
        success: function (result) {
            var item = "";
            $.each(result.data, function (i, eve) {
                item += "<tr class='success'><td>" + getDriverType(eve.driverType) + "</td><td>" + eve.typeCode + "</td><td>" + eve.version + "</td><td>" + eve.equipmenter + "</td><td>" + eve.uploader + "</td></tr>";
            });
            showTable(item, "search", 0);
        },
        error: function (e) {
            console.log("error..");
        }
    });
}
