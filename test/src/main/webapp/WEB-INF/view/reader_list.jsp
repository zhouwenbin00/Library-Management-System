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
<script>
    //文档加载调用
    $(function(){
        //编辑行属性
        editRow = undefined;
        //图书表格数据
        $('#reader_dg').datagrid({
            //数请求路径
            url: 'reader/list',method: 'POST',
            //斑马线-取消边框-充满父容器
            striped: true,border: false,fit: true,
            //初始化页面条数
            pageSize: 20,pageList: [20, 50, 100],
            //分页条-工具栏
            pagination: true,toolbar: '#reader_tb',
            //开启编辑时调用
            onBeginEdit: function (rowIndex, rowData) {
                //对可编辑行的日期控件限制
                var ed = $('#reader_dg').datagrid('getEditor', {index: rowIndex, field: 'validityDate'});
                $(ed.target).datebox().datebox('calendar').calendar({
                    validator: function (date) {
                        var now = new Date();
                        // var d2 = new Date(now.getFullYear(), now.getMonth(), now.getDate()+5);
                        var d1 = new Date(now.getFullYear(), now.getMonth(), now.getDate());
                        return d1 <= date;
                    }
                })
            },
            //结束编辑调用此方法
            onAfterEdit: function (rowIndex, rowData, changes) {
                //endEdit该方法触发此事件
                console.info(rowData);
                var updated = $('#reader_dg').datagrid('getChanges', 'updated');
                //如果选择了修改，但实际未做任何改变，则直接返回false
                if (updated.length == 0) {
                    editRow = undefined;
                    return false
                }
                if (updated.length > 0) {
                    url = 'reader/save';
                    // ajax提交，rowData是行数据
                    $.ajax({
                        type: 'post',
                        url: 'reader/save',
                        data: {json: JSON.stringify(rowData)},
                        success: function (data) {
                            if (data.code == 200) {
                                //提示
                                $.messager.alert('提示', '修改成功!');
                                //刷新数据
                                $('#reader_dg').datagrid('reload', {
                                    url: 'reader/list', method: 'post'
                                });
                            }
                        }
                    });
                }
                editRow = undefined;
            }
        });


    })
    //覆盖原方法，防止报错
    $.fn.datebox.defaults.parser = function (s) {
        if (!s) return new Date();
        var ss = s.toString().split('-');
        var y = parseInt(ss[0], 10);
        var m = parseInt(ss[1], 10);
        var d = parseInt(ss[2], 10);
        if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
            return new Date(y, m - 1, d);
        } else {
            return new Date();
        }
    };
    $.fn.datebox.defaults.formatter = function(date){
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        var d = date.getDate();
        return y+'-'+m+'-'+d;
        //如果值为空，返回空
        /*if (value == undefined) {
            return '';
        }
        var dateMat = new Date(value);
        var year = dateMat.getFullYear();
        var month = dateMat.getMonth() + 1;
        var day = dateMat.getDate();
        return  year + '-' + month + '-' + day;*/
    }
</script>
<!-- 最外部容器-->
<div class="easyui-panel" data-options="border:false,fit:true">
    <!--数据表格-->
    <table id="reader_dg" class="easyui-datagrid" style="width:100%;height:500px">
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
    <!-- 上方工具栏-->
    <div id="reader_tb" style="height:auto">
        <!-- 增删改按钮 -->
        <div style="border-bottom: 1px #DDD solid">
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,onClick:function(){
                if (editRow != undefined) {
                    $.messager.alert('提示','请先结束编辑!');
                }
                if(editRow == undefined){
                    $('#tabs').tabs('add', {title: '新增读者',href: 'add_reader',closable: true});
                }
            }">添加</a>

            <span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>

            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,onClick:function(){
                //修改时要获取选择到的行
                var rows = $('#reader_dg').datagrid('getSelections');
                //如果只选择了一行则可以进行修改，否则不操作
                if (rows.length == 1) {
                     //修改之前先关闭已经开启的编辑行，当调用endEdit该方法时会触发onAfterEdit事件
                       if (editRow != undefined) {
                           $.messager.alert('提示','有正在编辑的数据，请完成后再点击!');
                       }
                    //当无编辑行时
                    if (editRow == undefined) {
                       //获取到当前选择行的下标
                       var index = $('#reader_dg').datagrid('getRowIndex', rows[0]);
                       //开启编辑
                       $('#reader_dg').datagrid('beginEdit', index);
                       //把当前开启编辑的行赋值给全局变量editRow
                       editRow = index;
                    }

                }else {
                   $.messager.alert('提示','请您选择一行数据开启编辑!');
                }
            }">编辑</a>

            <span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>

            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true,onClick:function(){
                  //保存时结束当前编辑的行，自动触发onAfterEdit事件如果要与后台交互可将数据通过Ajax提交后台
                    $('#reader_dg').datagrid('endEdit', editRow);
                    $('#reader_dg').datagrid('unselectAll');
            }">保存编辑</a>

            <span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>

            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true,onClick:function(){
                 //取消当前编辑行把当前编辑行罢undefined回滚改变的数据,取消选择的行
                    editRow = undefined;
                    $('#reader_dg').datagrid('rejectChanges');
                    $('#reader_dg').datagrid('unselectAll');
             }">取消编辑</a>

            <span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>

            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true,onClick:function(){
                if (editRow != undefined) {
                   $.messager.alert('提示','请先结束编辑!');
                }
                if (editRow==undefined){
                     var rows = $('#reader_dg').datagrid('getSelections');
                    var ids = [];
                    for (var i in rows) {
                        ids.push(rows[i].id);
                    }
                    ids = ids.join(',');
                    if(ids.length == 0){
                        $.messager.alert('提示','未选中分类!');
                        return ;
                    }
                    $.messager.confirm('确认','确定删除ID为 '+ids+' 的读者吗？',function(r){
                        if (r){
                            var params = {'ids':ids};
                            $.post('reader/del',params, function(data){
                                if(data.code == 200){
                                    /*提示*/
                                    $.messager.alert('提示','删除成功!');
                                    /*刷新数据*/
                                    $('#reader_dg').datagrid('reload',{
                                        url: 'reader/list', method: 'post'
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
            <span>学院：
                 <input id="reader_college" class="easyui-textbox" data-options="" style="width:100px">
                </span>
            <span>
                学号:
                <input id="reader_grade" class="easyui-textbox" data-options="" style="width:100px">
            </span>
            <span>
                状态:
                <input id="reader_status" class="easyui-textbox" data-options="" style="width:100px">
            </span>
            <span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" data-options="onClick:function(){
                var reader_college = $('#reader_college').val();
                var reader_grade = $('#reader_grade').val();
                var reader_status = $('#reader_status').val()
                $.post('reader/search', {
                    reader_college: reader_college,
                    reader_grade: reader_grade,
                    reader_status: reader_status
                    }, function (data) {
                    //重新加载数据
                    $('#reader_dg').datagrid('loadData', data);
                    })
                }
            ">查询</a>

            <span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>
            <a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-options="onClick:function(){
                $('#reader_college').textbox().textbox('setValue', '');
                $('#reader_grade').textbox().textbox('setValue', '');
                $('#reader_status').textbox().textbox('setValue', '');
            }">清空</a>
        </div>
    </div>
</div>
</body>
</html>


