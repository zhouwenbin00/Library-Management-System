<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<script src="../../js/jquery-easyui-1.7.0/jquery.min.js"></script>
<script src="../../js/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="../../js/jquery-easyui-1.7.0/themes/default/easyui.css">
<link rel="stylesheet" href="../../js/jquery-easyui-1.7.0/themes/icon.css">
<script src="../../js/jquery-easyui-1.7.0/locale/easyui-lang-zh_CN.js"></script>
<%--BUG：暂无文本框长度验证,无电话格式验证--%>
<body>
<div>
    <div style="padding:20px 60px 20px 60px;width: 800px">
        <!-- form表单-->
        <form id="addReaderForm" method="post">
            <!-- 左边表格-->
            <table style="float: left;margin-right: 50px;" cellpadding="5">
                <tr>
                    <td>读者姓名:</td>
                    <td>
                        <input class="easyui-textbox" type="text" value="" name="readerName" data-options="missingMessage:'',required:true"/>
                    </td>
                </tr>
                <tr>
                    <td>年龄:</td>
                    <td><input class="easyui-numberbox" type="text" name="readerNum" data-options="missingMessage:'',required:true"/></td>
                </tr>
                <tr>
                    <td>性别:</td>
                    <td>
                        <input class="easyui-combobox" value="" name="sex" data-options="valueField: 'value',textField: 'text',
                            missingMessage:'',required:true,data:[{text:'男',value:'男'},{text:'女',value:'女'}],panelHeight:'auto'" />
                    </td>
                </tr>
                <tr>
                    <td>电话:</td>
                    <td>
                        <input type="text" class="easyui-numberbox" name="tel" data-options="missingMessage:'',required:true"/>
                    </td>
                </tr>
            </table>
            <!-- 右边表格-->
            <table cellpadding="5">
                <tr>
                    <td>学院:</td>
                    <td><input class="easyui-textbox" type="text" name="college" data-options="missingMessage:'',required:true"/></td>
                </tr>
                <tr>
                    <td>学号:</td>
                    <td>
                        <input class="easyui-numberbox" name="grade" data-options="missingMessage:'',required:true" />
                    </td>
                </tr>
                <tr>
                    <td>余额:</td>
                    <td><input class="easyui-numberbox" name="balance" value="0" data-options="missingMessage:'',required:true,suffix:'元',min:0,precision:2"/></td>
                </tr>
                <tr>
                    <td>有效期:</td>
                    <td>
                        <input id="reader_validityDate" class="easyui-datebox" name="validityDate" data-options="missingMessage:'',required:true" />
                    </td>
                </tr>
            </table>
        </form>
        <!-- 按钮-->
        <div style="text-align:center;padding:10px">
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="onClick:function(){
                //有效性验证
                if(!$('#addReaderForm').form('validate')){
                    $.messager.alert('提示','表单还未填写完成!');
                    return ;
                    }
                    $.post('reader/add',$('#addReaderForm').serialize(), function(data){
                        if(data.code == 200){
                        $.messager.alert('提示','新增读者成功!');
                        //清空表单
                        $('#addReaderForm').form('reset');
                    }
                 });
             }">添加</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" style="margin-left: 50px;" data-options="onClick:function(){
                //清空表单
                $('#addReaderForm').form('reset');
             }">重填</a>
        </div>
    </div>
</div>

<script>
    $(function () {
        $('#reader_validityDate').datebox().datebox('calendar').calendar({
            validator: function(date){
                var now = new Date();
                var d1 = new Date(now.getFullYear(), now.getMonth(), now.getDate());
                // var d2 = new Date(now.getFullYear(), now.getMonth(), now.getDate()+5);
                return d1<=date;
            }
        });
    })
</script>
</body>
</html>