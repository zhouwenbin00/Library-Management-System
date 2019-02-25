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
<table class="easyui-datagrid" id="book_ranking_dg">
    <thead>
    <tr>
        <th data-options="width:80, field:'id',align:'center'">图书ID</th>
        <th data-options="width:80, field:'bookCode',align:'center',editor:'textbox'">图书编号</th>
        <th data-options="width:80, field:'bookName',align:'center',editor:'textbox'">图书名称</th>
        <th data-options="width:80, field:'author',align:'center',editor:'textbox'">作者</th>
        <th data-options="width:80, field:'category',align:'center',editor:{
                                type:'combobox',options:{
                                valueField:'category',
                                textField:'category',
                                method:'post',
                                panelHeight:'auto',
                                url:'category/combobox'
                         }
             }">分类
        </th>
        <th data-options="width:80, field:'isbn',align:'center',editor:'textbox'">ISBN</th>
        <th data-options="width:80, field:'press',align:'center',editor:'textbox'">出版社</th>
        <th data-options="width:80, field:'page',align:'center',editor:'numberbox'">总页数</th>
        <th data-options="width:80, field:'price',align:'center',editor:'numberbox'">价格</th>
        <th data-options="width:80, field:'totalNum',align:'center',editor:'numberbox'">馆藏数量</th>
        <th data-options="width:80, field:'borrowTime',align:'center'">借出次数</th>
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
                } ">入库时间
        </th>
        <th data-options="width:80, field:'position',align:'center',editor:'textbox'">存放位置</th>
    </tr>
    </thead>
</table>
<script>
    $('#book_ranking_dg').datagrid({
        url: 'book/ranking',
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
