<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-02-26
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="easyui-datagrid" id="reader_ranking_dg">
    <thead>
    <tr>
        <th data-options="width:80, field:'id',align:'center'">读者ID</th>
        <th data-options="width:80, field:'readerName',align:'center',editor:'textbox'">姓名</th>
        <th data-options="width:80, field:'readerNum',align:'center',editor:'numberbox'">年龄</th>
        <th data-options="width:80, field:'sex',align:'center',editor:'textbox',editor:{type:'combobox',options:{ valueField:'value',
            textField:'text',data:[{text:'男',value:'男'},{text:'女',value:'女'}],panelHeight:'auto' } }">性别
        </th>
        <th data-options="width:80, field:'tel',align:'center',editor:'numberbox'">电话</th>
        <th data-options="width:80, field:'college',align:'center',editor:'textbox'">学院</th>
        <th data-options="width:80, field:'grade',align:'center',editor:'numberbox'">学号</th>
        <th data-options="width:80, field:'balance',align:'center'">余额</th>
        <th data-options="width:80, field:'borrowTime',align:'center'">借阅次数</th>
        <th data-options="width:80, field:'status',align:'center',editor:'textbox',editor:{type:'combobox',options:{valueField:'value',
            textField:'text',data:[{text:'激活',value:'激活'},{text:'冻结',value:'冻结'}],panelHeight:'auto'}}">状态
        </th>
        <th data-options="width:80, field:'validityDate',align:'center',editor:'datebox',formatter:function (value) {
                    if (value == undefined) {
                        return '';
                    }
                    var dateMat = new Date(value);
                    var year = dateMat.getFullYear();
                    var month = dateMat.getMonth() + 1;
                    var day = dateMat.getDate();
                    return  year + '-' + month + '-' + day;
                } ">有效期</th>
        <!-- 时间日期格式化 -->
        <th data-options="width:80, field:'registerDate',align:'center',formatter:function (value) {
                    if (value == undefined) {
                        return '';
                    }
                    var dateMat = new Date(value);
                    var year = dateMat.getFullYear();
                    var month = dateMat.getMonth() + 1;
                    var day = dateMat.getDate();
                    return  year + '-' + month + '-' + day;
                } ">注册时间
        </th>
    </tr>
    </thead>
</table>
<script>
    $('#reader_ranking_dg').datagrid({
        url: 'reader/ranking',
        method: 'POST',
        //斑马线
        striped: true,
        //取消边框
        border: false,
        fit: true,
        pageSize: 20,
        pageList: [20, 50, 100],
        //分页条
        pagination: true
    })
</script>
</body>
</html>
