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
                        <input class="easyui-textbox" type="text" name="bookCode"/>
                    </td>
                </tr>
                <tr>
                    <td>作者:</td>
                    <td><input class="easyui-textbox" type="text" name="author"/></td>
                </tr>
                <tr>
                    <td>ISBN:</td>
                    <td><input class="easyui-textbox" type="text" name="isbn"/></td>
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
                    <td><input class="easyui-textbox" type="text" name="bookName"/></td>
                </tr>
                <tr>
                    <td>分类:</td>
                    <td>
                        <input id="book_category" name="category">
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
                               data-options="min:0,precision:2,prefix:'$'"/>
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
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">添加</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="margin-left: 50px;">重填</a>
        </div>
    </div>
</div>

    <script>
        function submitForm() {
            //有效性验证
            if(!$('#ff').form('validate')){
                $.messager.alert('提示','表单还未填写完成!');
                return ;
            }
            $.post("book/add",$("#ff").serialize(), function(data){
                if(data.code == 200){
                    $.messager.alert('提示','新增商品成功!');
                }
            });

        }
        
        /*清空表单*/
        function clearForm(){
            $('#ff').form('reset');
        }

        /*内容下拉框*/
        $('#book_category').combobox({
            url: 'category/list',
            valueField: 'data.rows.id',
            textField: 'data.rows.category'
        });
    </script>
</body>
</html>