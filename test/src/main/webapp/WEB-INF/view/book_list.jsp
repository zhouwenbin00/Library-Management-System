<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-02-25
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书列表</title>
</head>
<body>
<!-- 最外部容器-->
<div class="easyui-panel" data-options="border:false,fit:true">
    <!--数据表格-->
    <table id="book_dg" class="easyui-datagrid" style="width:100%;height:500px">
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
                                url:'category/combobox'
                         }
             }">分类
            </th>
            <th data-options="width:80, field:'isbn',align:'center',editor:'textbox'">ISBN</th>
            <th data-options="width:80, field:'press',align:'center',editor:'textbox'">出版社</th>
            <th data-options="width:80, field:'page',align:'center',editor:'numberbox'">总页数</th>
            <th data-options="width:80, field:'price',align:'center',editor:'numberbox'">价格</th>
            <th data-options="width:80, field:'totalNum',align:'center',editor:'numberbox'">馆藏数量</th>
            <th data-options="width:80, field:'leftNum',align:'center',editor:'numberbox'">在馆数量</th>
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
    <!-- 上方工具栏-->
    <div id="book_tb" style="height:auto">
        <!-- 增删改按钮 -->
        <div style="border-bottom: 1px #DDD solid">
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,onClick:function(){
                if (editRow != undefined) {
                    $.messager.alert('提示','请先结束编辑!');
                }
                if(editRow == undefined){
                    $('#tabs').tabs('add', {title: '新增图书',href: 'add_Book',closable: true});
                }
            }">添加</a>

            <span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>

            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,onClick:function(){
                //修改时要获取选择到的行
                var rows = $('#book_dg').datagrid('getSelections');
                //如果只选择了一行则可以进行修改，否则不操作
                if (rows.length == 1) {
                   //修改之前先关闭已经开启的编辑行，当调用endEdit该方法时会触发onAfterEdit事件
                   if (editRow != undefined) {
                       $('#book_dg').datagrid('endEdit', editRow);
                   }
                }else {
                   $.messager.alert('提示','请您选择一行数据开启编辑!');
                }
                //当无编辑行时
                if (editRow == undefined) {
                   //获取到当前选择行的下标
                   var index = $('#book_dg').datagrid('getRowIndex', rows[0]);
                   //开启编辑
                   $('#book_dg').datagrid('beginEdit', index);
                   //把当前开启编辑的行赋值给全局变量editRow
                   editRow = index;
                }
            }">编辑</a>

            <span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>

            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true,onClick:function(){
                  //保存时结束当前编辑的行，自动触发onAfterEdit事件如果要与后台交互可将数据通过Ajax提交后台
                    $('#book_dg').datagrid('endEdit', editRow);
                    $('#book_dg').datagrid('unselectAll');
            }">保存编辑</a>

            <span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>

            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true,onClick:function(){
                 //取消当前编辑行把当前编辑行罢undefined回滚改变的数据,取消选择的行
                    editRow = undefined;
                    $('#book_dg').datagrid('rejectChanges');
                    $('#book_dg').datagrid('unselectAll');
             }">取消编辑</a>

            <span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>

            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true,onClick:function(){
                if (editRow != undefined) {
                   $.messager.alert('提示','请先结束编辑!');
                }
                if (editRow==undefined){
                    var ids = getSelectionsIds();
                    if(ids.length == 0){
                        $.messager.alert('提示','未选中分类!');
                        return ;
                    }
                    $.messager.confirm('确认','确定删除ID为 '+ids+' 的图书吗？',function(r){
                        if (r){
                            var params = {'ids':ids};
                            $.post('book/del',params, function(data){
                                if(data.code == 200){
                                    /*提示*/
                                    $.messager.alert('提示','删除成功!');
                                    /*刷新数据*/
                                    $('#book_dg').datagrid('reload',{
                                        url: 'book/list', method: 'post'
                                     });
                                }
                            });
                        }
                    });
                 }
            }">删除</a>
        </div>
        <!-- 条件查询栏 -->
        <div style="padding-top: 5px; ">
            <span>
                输入内容查询关键字:
                <input id="keyWord" class="easyui-textbox" data-options="" style="width:200px">
            </span>
            <span>图书分类：
                <input class="easyui-combobox" name="category" id="book_category"
                       data-options="url:'category/combobox',method:'POST',valueField:'category',textField:'category',prompt:'请选择分类'">
	        </span>
            <span>
                出版社:
                <input id="book_press" class="easyui-textbox" data-options="" style="width:100px">
            </span>
            <span>
                存放位置:
                <input id="book_position" class="easyui-textbox" data-options="" style="width:100px">
            </span>
            <span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="doSearch()">查询</a>
            <span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>
            <a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="doClear()">清空</a>
        </div>
    </div>
</div>
<script>
    $(function () {
        //编辑行属性
        editRow = undefined;
        //图书数据表格
        $('#book_dg').datagrid({
            url: 'book/list',
            method: 'POST',
            //斑马线
            striped: true,
            //取消边框
            border: false,
            fit: true,
            pageSize: 20,
            pageList: [20, 50, 100],
            //分页条
            pagination: true,
            toolbar: '#book_tb',
            //结束编辑调用此方法
            onAfterEdit: function (rowIndex, rowData, changes) {
                //endEdit该方法触发此事件
                console.info(rowData);
                var updated = $('#book_dg').datagrid('getChanges', 'updated');
                console.log(updated[0]);
                console.log(rowData);
                var url = '';
                //如果选择了修改，但实际未做任何改变，则直接返回false
                if (updated.length == 0) {
                    editRow = undefined;
                    return false
                }
                if (updated.length > 0) {
                    url = 'book/save';
                    // ajax提交，rowData是行数据
                    $.ajax({
                        type: 'post',
                        url: url,
                        data: {json: JSON.stringify(rowData)},
                        success: function (data) {
                            if (data.code == 200) {
                                //提示
                                $.messager.alert('提示', '修改成功!');
                                //刷新数据
                                $('#book_dg').datagrid('reload', {
                                    url: 'book/list', method: 'post'
                                });
                            }
                        }
                    });
                }
                editRow = undefined;
            }
        })
    });

    //条件查询
    function doSearch() {
        var keyWord = $("#keyWord").val();
        var book_category = $("#book_category").val();
        var book_press = $("#book_press").val();
        var book_position = $("#book_position").val()
        $.post('book/search', {
            keyWord: keyWord,
            book_category: book_category,
            book_press: book_press,
            book_position: book_position
        }, function (data) {
            //重新加载数据
            $("#book_dg").datagrid("loadData", data);
        })
    }

    //清空
    function doClear() {
        $("#keyWord").textbox().textbox("setValue", "");
        $("#book_position").textbox().textbox("setValue", "");
        $("#book_press").textbox().textbox("setValue", "");
        $("#book_category").combobox().combobox("setValue", "");
    }

    /*获取多行id*/
    function getSelectionsIds() {
        var dg = $("#book_dg");
        var rows = dg.datagrid("getSelections");
        var ids = [];
        for (var i in rows) {
            ids.push(rows[i].id);
        }
        ids = ids.join(',');
        return ids;
    }
</script>
</body>
</html>
