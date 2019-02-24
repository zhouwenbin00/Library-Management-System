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
<!-- 分类列表-->
<div style="margin: 10px 10px">
    <!-- 工具栏-->
    <div id="tb">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,onClick:function(){
                $('#win1').window('open');
            }">添加</a>
        <span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="delCategory()">删除</a>
    </div>
    <!-- 列表头-->
    <table id="dg" style="width: 400px">
        <thead>
        <tr>
            <th data-options="field:'id',width:198">分类ID</th>
            <th data-options="field:'category',width:198">分类名称</th>
        </tr>
        </thead>
    </table>
</div>

<!--添加窗口-->
<div id="win1" class="easyui-window" data-options="title:'添加分类',closed:true">
    <div style="margin: 20px 20px">
        分类名称：<input class="easyui-textbox" type="text" id="input1"/>
        <a class="easyui-linkbutton" onclick="addCategory()">添加</a>
    </div>
</div>

<script>
    /*数据表格*/
    $('#dg').datagrid({
        url: 'category/list',
        method: 'POST',
        striped: true,
        pageList: [10],
        pagination: true,
        toolbar: '#tb'
    });
</script>
<script>
    /*获取多行id*/
    function getSelectionsIds(){
        var dg = $("#dg");
        var rows = dg.datagrid("getSelections");
        var ids = [];
        for(var i in rows){
            ids.push(rows[i].id);
        }
        ids = ids.join(",");
        return ids;
    }

    /*添加内容*/
    function addCategory() {
        var input = $("#input1").val();
        if (input == '') {
            $.messager.alert('提示', '您还没有输入任何信息！', 'info');
        } else {
            $.ajax({
                url: "category/add",	//请求url
                type: "POST",	//请求类型  post|get
                data: {category: input},
                dataType: "json",  //返回数据的 类型 text|json|html--
                success: function (data) {	//回调函数 和 后台返回的 数据
                    if (data.code == 200) {
                        /*弹框提示*/
                        $.messager.alert('提示', '添加成功！', 'info');
                       /*刷新数据*/
                        $('#dg').datagrid('reload',{
                            url: "category/list", method: "post"
                        });
                        $('#win1').window('close');
                    } else {
                        $.messager.alert('提示', data.msg, 'info');
                    }
                }
            });
        }
    }
    /*删除内容*/
    function delCategory() {
        var ids = getSelectionsIds();
        if(ids.length == 0){
            $.messager.alert('提示','未选中分类!');
            return ;
        }
        $.messager.confirm('确认','确定删除ID为 '+ids+' 的分类吗？',function(r){
            if (r){
                var params = {"ids":ids};
                $.post("category/del",params, function(data){
                    if(data.code == 200){
                        /*提示*/
                        $.messager.alert('提示','删除成功!');
                        /*刷新数据*/
                        $('#dg').datagrid('reload',{
                            url: "category/list", method: "post"
                        });
                    }
                });
            }
        });
    }
</script>
</body>
</html>