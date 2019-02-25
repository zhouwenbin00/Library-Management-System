<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-02-26
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<link rel="stylesheet" href="../../css/lms.css">
<body>
<!-- 最外层div -->
<div style="background:#E6EEF8;padding: 10px;">
    <!-- 左边读者div -->
    <div style="width: 49.5%;float: left">
        <div id="p_left" class="easyui-panel" title="读者信息"
             style="padding:10px;background:#fafafa;"
             data-options="closable:false,
                collapsible:false,minimizable:false,maximizable:false">
            <div>
                学号：<input id="grade" class="easyui-textbox" >
                <button class="easyui-linkbutton" iconCls="icon-search" data-options="onClick:function () {
                   var grade= $('#grade').textbox('getValue');
                   if(grade==''){
                        $.messager.alert('提示','请输入学号');
                   }else{
                        $.post('reader/searchByGrade',{grade:grade},function(data){
                            if(data==null&&data==''){
                                $.messager.alert('提示','请输入正确的学号!');
                                return;
                            }
                            if(data.status=='冻结'){
                                 $.messager.alert('提示','该读者处于冻结状态，请先激活!');
                                 return;
                            }
                            $('#readerName').textbox('setValue',data.readerName);
                            $('#readerNum').textbox('setValue',data.readerNum);
                            $('#sex').textbox('setValue',data.sex);
                            $('#college').textbox('setValue',data.college);
                            $('#tel').textbox('setValue',data.tel);
                            $('#borrow_date').textbox('setValue','30');
                            $('#balance').textbox('setValue',data.balance);
                            $('#validityDate').textbox('setValue',data.validityDate);
                            $('#btn_bookFind').linkbutton('enable');
                        })
                    }

                }" >查询</button>
            </div>
            <div style="margin-top: 20px">
                <table style="float: left">
                    <tr>
                        <td>
                            姓名：
                        </td>
                        <td><input id="readerName" class="easyui-textbox" data-options="readonly:true"></td>
                    </tr>
                    <tr>
                        <td>
                            年龄：
                        </td>
                        <td><input class="easyui-textbox" id="readerNum" data-options="readonly:true"></td>
                    </tr>
                    <tr>
                        <td>
                            性别：
                        </td>
                        <td><input class="easyui-textbox" id="sex" data-options="readonly:true"></td>
                    </tr>
                    <tr>
                        <td>
                            学院：
                        </td>
                        <td><input class="easyui-textbox" id="college" data-options="readonly:true"></td>
                    </tr>
                </table>
                <table style="float: right">
                    <tr>
                        <td>
                            电话：
                        </td>
                        <td>
                            <input class="easyui-textbox" id="tel" data-options="readonly:true">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            借阅天数：
                        </td>
                        <td>
                            <input class="easyui-textbox" id="borrow_date" data-options="readonly:true">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            余额：
                        </td>
                        <td>
                            <input class="easyui-textbox" id="balance" data-options="readonly:true">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            有效期至：
                        </td>
                        <td>
                            <input class="easyui-textbox" id="validityDate" data-options="readonly:true">
                        </td>
                    </tr>
                </table>
            </div>
        </div>

    </div>
    <!-- 右边读者div -->
    <div style="width: 49.5%;height: 300px;float: right">
        <div id="p_right" class="easyui-panel" title="图书信息"
             style="padding:10px;background:#fafafa;"
             data-options="closable:false,
                collapsible:false,minimizable:false,maximizable:false">
            <div>
                图书编号：<input class="easyui-textbox" id="book_code">
                <button id="btn_bookFind" class="easyui-linkbutton" iconCls="icon-search" data-options="disabled:true,onClick:function () {
                    var book_code= $('#book_code').textbox('getValue');
                    if(book_code==''){
                        $.messager.alert('提示','请输入图书编号');
                    }else{
                         $.post('book/searchByBookCode',{book_code:book_code},function(data){
                          if(data!=null&&data!=''){
                             $('#bookName').textbox('setValue',data.bookName);
                             $('#category').textbox('setValue',data.category);
                             $('#page').textbox('setValue',data.page);
                             $('#isbn').textbox('setValue',data.isbn);
                             $('#author').textbox('setValue',data.author);
                             $('#press').textbox('setValue',data.press);
                             $('#price').textbox('setValue',data.price);
                             $('#position').textbox('setValue',data.position);
                          }else{
                               $.messager.alert('提示','请输入正确的图书编号!');
                          }
                        })
                    }
                }">查询</button>
            </div>
            <div style="margin-top: 20px">
                <table style="float: left">
                    <tr>
                        <td>
                            图书名称：
                        </td>
                        <td><input class="easyui-textbox" id="bookName" data-options="readonly:true"></td>
                    </tr>
                    <tr>
                        <td>
                            分类：
                        </td>
                        <td><input class="easyui-textbox" id="category" data-options="readonly:true"></td>
                    </tr>
                    <tr>
                        <td>
                            页数：
                        </td>
                        <td><input class="easyui-textbox" id="page" data-options="readonly:true"></td>
                    </tr>
                    <tr>
                        <td>
                            ISBN：
                        </td>
                        <td><input class="easyui-textbox" id="isbn" data-options="readonly:true"></td>
                    </tr>
                </table>
                <table style="float: right">
                    <tr>
                        <td>
                            作者：
                        </td>
                        <td>
                            <input class="easyui-textbox" id="author" data-options="readonly:true">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            出版社：
                        </td>
                        <td>
                            <input class="easyui-textbox" id="press" data-options="readonly:true">
                        </td>
                    </tr>

                    <tr>
                        <td>
                            价格：
                        </td>
                        <td>
                            <input class="easyui-textbox" id="price" data-options="readonly:true">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            存放位置：
                        </td>
                        <td>
                            <input class="easyui-textbox" id="position" data-options="readonly:true">
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <div style="text-align: center;width: 100%">
        <button class="easyui-linkbutton" style="clear: both; margin :5px auto;" data-options="onClick:function(){
             var book_code= $('#book_code').textbox('getValue');
             var grade= $('#grade').textbox('getValue');
             var bookName= $('#bookName').textbox('getValue');
             var readerName= $('#readerName').textbox('getValue');
             if(book_code==''||grade==''||bookName==''||readerName==''){
                 $.messager.alert('提示','请先选择读者和书籍!');
             }else{
                $.post('record/add',{book_code:book_code,grade:grade,bookName:bookName,readerName:readerName},function(data){
                    if(data.code=='200'){
                         $.messager.alert('提示','借书成功!');
                         $('#r_dg').datagrid('loadData',data.data.result);
                    }
                 });
             }

        }">借阅</button>
    </div>

    <!-- 下部数据表格div -->
    <div style="float: none;clear:both;">
        <table class="easyui-datagrid"  id="r_dg">
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
                <th data-options="width:100,field:'borrowsDays'">借出天数</th>
                <th data-options="width:100,field:'rent'">租金</th>
                <th data-options="width:100,field:'overDays'">超出天数</th>
                <th data-options="width:100,field:'overRent'">逾期罚金</th>
            </tr>
            </thead>
            <tbody><tr></tr></tbody>
        </table>
    </div>
</div>
</body>
</html>
