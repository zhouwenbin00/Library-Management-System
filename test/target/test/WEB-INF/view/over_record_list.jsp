<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-02-26
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="easyui-datagrid"  id="record_over_dg">
    <thead>
    <tr>
        <th data-options="width:100,field:'id'">ID</th>
        <th data-options="width:100,field:'status'">状态</th>
        <th data-options="width:100,field:'bookNum'">图书编号</th>
        <th data-options="width:100,field:'bookName'">图书名称</th>
        <th data-options="width:100,field:'readerName'">读者名称</th>
        <th data-options="width:100,field:'borrowDate',formatter:function (value) {
                    if (value == undefined) {
                        return '';
                    }
                    var dateMat = new Date(value);
                    var year = dateMat.getFullYear();
                    var month = dateMat.getMonth() + 1;
                    var day = dateMat.getDate();
                    return  year + '-' + month + '-' + day;
                }">借出时间</th>
        <th data-options="width:100,field:'returnDate',formatter:function (value) {
                    if (value == undefined) {
                        return '';
                    }
                    var dateMat = new Date(value);
                    var year = dateMat.getFullYear();
                    var month = dateMat.getMonth() + 1;
                    var day = dateMat.getDate();
                    return  year + '-' + month + '-' + day;
                }">归还时间</th>
        <th data-options="width:100,field:'borrowsDays'">应借天数
        </th>
        <th data-options="width:100,field:'rent'">租金</th>
        <th data-options="width:100,field:'overDays'">超出天数</th>
        <th data-options="width:100,field:'overRent'">逾期罚金</th>
    </tr>
    </thead>
</table>
<!-- 条件查询栏 -->
<div style="padding-top: 5px; " id="over_record_tb">
    <span>图书名称：
         <input class="easyui-textbox" name="book_name">
	 </span>
    <span>读者姓名：
         <input class="easyui-textbox" name="reader_name">
	 </span>
    <span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>
    <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" data-options="onClick: function () {
       var book_name=$('input[name=\'book_name\']').val()
        var reader_name=$('input[name=\'reader_name\']').val()
        $.post('over_record/search',{bookName:book_name,readerName:reader_name},function(data) {
          if (data==null&&data==''){
               $.messager.alert('提示', '请输入正确信息！');
               return;
          }
          $('#record_dg').datagrid('loadData',data);
        })
    }">查询</a>
</div>
<script>
    $('#record_over_dg').datagrid({
        url:'over_record/list',
        method:'POST',
        //斑马线
        striped: true,
        //取消边框
        border: false,
        fit: true,
        pageSize: 20,
        pageList: [20, 50, 100],
        //分页条
        pagination: true,
        toolbar:'#over_record_tb'
    })
</script>
</body>
</html>
