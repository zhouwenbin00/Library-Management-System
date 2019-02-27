<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-02-27
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="admin_dg" class="easyui-datagrid">
</table>
<script>
    var datagrid;
    var editRow = undefined;
    datagrid=$('#admin_dg').datagrid({
        url: 'user/list',
        width: 'auto',
        height: 'auto',
        fitColumns: true,
        fit:true,
        pagination: true,//分页显示
        columns: [[
            {field: 'id', title: 'ID', width: 80, align: 'center'},
            {field: 'username', title: '账号',editor:{type:'textbox',options:{required:true}}, width: 80, align: 'center'},
            {field: 'password', title: '密码',editor:{type:'textbox',options:{required:true}},width: 80, align: 'center',formatter:function (value, row, index) {
                if (value!=""){ return "****"}
                }},
            {field: 'bookSet', title: '图书管理',editor:{type:'checkbox',options:{on: '1', off: '0'}}, width: 80, align: 'center',formatter:setformatter},
            {field: 'readerSet', title: '读者管理',editor:{type:'checkbox',options:{on: '1', off: '0'}},width: 80, align: 'center',formatter:setformatter},
            {field: 'borrowSet', title: '图书借还', editor:{type:'checkbox',options:{on: '1', off: '0'}},width: 80, align: 'center',formatter:setformatter},
            {field: 'searchSet', title: '系统查询', editor:{type:'checkbox',options:{on: '1', off: '0'}},width: 80, align: 'center',formatter:setformatter},
            {field: 'systemSet', title: '系统设置',editor:{type:'checkbox',options:{on: '1', off: '0'}}, width: 80, align: 'center',formatter:setformatter}
        ]],
        data: [
            {id:'1', username:'admin',password:"123",book_set:'1',search_set:'1',reader_set:"1"},
            {id:'1', username:'admin',password:"123",book_set:'0',search_set:'1',reader_set:"0"}
        ],
        toolbar: [
            {
                iconCls:"icon-add",
                text:"新增",
                handler:function () {
                    if (editRow != undefined) {
                        $.messager.alert('提示','请先结束编辑!');
                        return;
                    }
                    //没有正在编辑和行则插入第一行
                    datagrid.datagrid("insertRow", {
                        index: 0,
                        row: {}
                    });
                    //将新插入的那一行开户编辑状态
                    datagrid.datagrid("beginEdit", 0);
                    //给当前编辑的行赋值
                    editRow = 0;
                }
            },"-",
            {
                iconCls: 'icon-edit',
                text:'编辑',
                handler: function(){
                    if (editRow != undefined) {
                        $.messager.alert('提示','请先结束编辑!');
                        return;
                    }
                    //修改时要获取选择到的行
                    var rows = datagrid.datagrid("getSelections");
                    //如果只选择了一行则可以进行修改，否则不操作
                    if (rows.length == 1) {
                        if (rows[0].id==1){
                            return;
                        }
                        //获取到当前选择行的下标
                        var index = datagrid.datagrid("getRowIndex", rows[0]);
                        //开启编辑
                        datagrid.datagrid("beginEdit", index);
                        //把当前开启编辑的行赋值给全局变量editRow
                        editRow = index;
                        //当开启了当前选择行的编辑状态之后，
                        datagrid.datagrid("unselectAll");
                    }else {
                        $.messager.alert('提示','请选择一行开始编辑!');
                    }
                }
            },'-',{
                iconCls: 'icon-redo',
                text:'取消编辑',
                handler: function(){
                    //取消当前编辑行把当前编辑行罢undefined回滚改变的数据,取消选择的行
                    editRow = undefined;
                    datagrid.datagrid("rejectChanges");
                    datagrid.datagrid("unselectAll");
                }
            },'-',{
                iconCls: 'icon-save',
                text:'保存编辑',
                handler: function(){
                    //保存时结束当前编辑的行，自动触发onAfterEdit事件如果要与后台交互可将数据通过Ajax提交后台
                    datagrid.datagrid('endEdit', editRow);
                    datagrid.datagrid('unselectAll');
                }
            },'-',{
                iconCls: 'icon-remove',
                text:'删除',
                handler: function(){
                    if (editRow != undefined) {
                        $.messager.alert('提示','请先结束编辑!');
                        return;
                    }
                    //删除时先获取选择行
                    var rows = datagrid.datagrid("getSelections");
                    //选择要删除的行
                    if (rows.length > 0) {
                        $.messager.confirm("提示", "你确定要删除吗?", function (r) {
                            if (r) {
                                var ids = [];
                                for (var i = 0; i < rows.length; i++) {
                                    ids.push(rows[i].ID);
                                }
                                //将选择到的行存入数组并用,分隔转换成字符串，
                                ids.join(',')

                            }
                        });
                    }else {
                        $.messager.alert("提示", "请选择要删除的行", "error");
                    }
                }
            }],
        onAfterEdit: function (rowIndex, rowData, changes) {
            //endEdit该方法触发此事件
            console.info(rowData);
            var updated = datagrid.datagrid('getChanges');
            console.info(updated);
            var url = '';
            //如果选择了修改，但实际未做任何改变，则直接返回false
            if (updated.length == 0) {
                editRow = undefined;
                return false
            }
            if (updated.length > 0) {
                url = 'user/save';
                // ajax提交，rowData是行数据
                $.ajax({
                    type: 'post',
                    url: url,
                    data: {json: JSON.stringify(rowData)},
                    success: function (data) {
                        if (data.code == 200) {
                            //提示
                            $.messager.alert('提示', '保存成功!');
                            //刷新数据
                            datagrid.datagrid('reload', {
                                url: 'user/list', method: 'post'
                            });
                        }else {
                            datagrid.datagrid("rejectChanges");
                            datagrid.datagrid("unselectAll");
                        }
                    }
                });
            }
            editRow = undefined;
        }

    })
    
    function setformatter(value, row, index) {
        if (value == 1) {
            var s = '<input type="checkbox" checked="checked" disabled value="1"/> ';
        } else {
            var s = '<input type="checkbox" disabled value="0"/> ';
        }
        return s;
    }
</script>
</body>
</html>
