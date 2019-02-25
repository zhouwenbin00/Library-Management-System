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
<%--BUG：暂无文本框长度验证--%>
<body>
<div>
    <div style="padding:20px 60px 20px 60px;width: 800px">
        <!-- form表单-->
        <form id="ff" method="post">
            <!-- 左边表格-->
            <table style="float: left;margin-right: 50px;" cellpadding="5">
                <tr>
                    <td>图书编号:</td>
                    <td>
                        <input id="bookCode" class="easyui-textbox" type="text" value="" name="bookCode" />
                    </td>
                </tr>
                <tr>
                    <td>作者:</td>
                    <td><input class="easyui-textbox" type="text" name="author"/></td>
                </tr>
                <tr>
                    <td>ISBN:</td>
                    <td><input id="isbn" class="easyui-textbox" type="text" value="" name="isbn"/></td>
                </tr>
                <tr>
                    <td>页数:</td>
                    <td>
                        <input type="text" class="easyui-numberbox" name="page" value="0" data-options="min:0"/>
                    </td>
                </tr>
                <tr>
                    <td>馆藏数量:</td>
                    <td>
                        <input type="text" class="easyui-numberbox" name="totalNum" value="1" data-options="min:0"/>
                    </td>
                </tr>
            </table>
            <!-- 右边表格-->
            <table cellpadding="5">
                <tr>
                    <td>书名:</td>
                    <td><input class="easyui-textbox" type="text" name="bookName" data-options="required:true"/></td>
                </tr>
                <tr>
                    <td>分类:</td>
                    <td>
                        <input class="easyui-combobox" name="category" data-options="url:'category/combobox',method:'POST',valueField:'category',textField:'category',prompt:'请选择分类'">
                    </td>
                </tr>
                <tr>
                    <td>出版社:</td>
                    <td><input class="easyui-textbox" type="text" name="press"/></td>
                </tr>
                <tr>
                    <td>价格:</td>
                    <td>
                        <input type="text" class="easyui-numberbox" name="price" value="0"
                               data-options="min:0,precision:2,suffix:'元'"/>
                    </td>
                </tr>
                <tr>
                <tr>
                    <td>存放位置:</td>
                    <td><input class="easyui-textbox" type="text" name="position"/></td>
                </tr>
            </table>
        </form>
        <!-- 按钮-->
        <div style="text-align:center;padding:10px">
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="onClick:function(){
                //有效性验证
                if(!$('#ff').form('validate')){
                    $.messager.alert('提示','表单还未填写完成!');
                    return ;
                    }
                    $.post('book/add',$('#ff').serialize(), function(data){
                        if(data.code == 200){
                        $.messager.alert('提示','新增图书成功!');
                        //清空表单
                        $('#ff').form('reset');
                        //重新获取图书编号和ISBN
                        getRandomCode();
                    }
                 });
             }">添加</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" style="margin-left: 50px;" data-options="onClick:function(){
                //清空表单
                $('#ff').form('reset');
                //重新获取图书编号和ISBN
                getRandomCode();
             }">重填</a>
        </div>
    </div>
</div>
<script>
    getRandomCode()
    //生成图书编号和ISBN
    function getRandomCode() {
        var data = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"];
        var bookCode = "";
        for (var i = 0; i < 2; i++) {
            var r = parseInt(Math.random() * 26);
            bookCode += data[r];
        }
        var n = Math.round(Math.random()*10e4);
        bookCode+=n;
        //图书编号赋值
        $('#bookCode').textbox().textbox('setValue',bookCode);
        console.log(bookCode);
        //ISBN赋值
        var isbn= Math.random().toString(10).substr(9);
        $('#isbn').textbox().textbox('setValue',isbn);
        console.log(isbn);
    }
</script>
</body>
</html>