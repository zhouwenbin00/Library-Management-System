<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2019-02-23
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图书管理系统</title>
    <script src="js/jquery-easyui-1.7.0/jquery.min.js"></script>
    <script src="js/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
    <link rel="stylesheet" href="js/jquery-easyui-1.7.0/themes/default/easyui.css">
    <link rel="stylesheet" href="js/jquery-easyui-1.7.0/themes/icon.css">
    <script src="js/jquery-easyui-1.7.0/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<div id="layoutID" class="easyui-layout" data-options="fit:true" style="background: #E6EEF8;">
    <!--北-->
    <div data-options="region:'north',border:true"
         style="height:80px;background: #8ABDF2;color: #005EAD;position: relative;margin-bottom: 7px">
        <!--大标题-->
        <div style="position: absolute;left: 10px;padding: auto 0px"><h1>图书管理系统</h1></div>
        <!--登陆用户-->
        <div style="position:absolute;bottom: 0;right: 10px; ">
            <span>admin</span>：您好！<a href="#">安全退出</a>
        </div>
    </div>
    <!--西-->
    <div id="westID" data-options="region:'west',title:'导航栏',border:true,collapsible:false,tools:'#tool'" style="width:200px;" >
        <!--工具栏-->
        <div id="tool">
            <!--带提示的展开折叠按钮-->
            <a id="state" href="#" title="全部展开" class="icon-add easyui-tooltip" onclick="state_change()"></a>
        </div>
        <!--菜单栏-->
        <ul id="menu" class="easyui-tree" style="margin: 10px">
        </ul>
    </div>
    <!--中-->
    <div data-options="region:'center'" style="background:#eee;margin-left: 7px;">
        <!--tab容器-->
        <div id="tabs" class="easyui-tabs" data-options="fit:true,border:false,plain:false">
            <div title="欢迎使用" data-options="href:'welcome'"></div>
        </div>

    </div>
</div>
<script>
    /*菜单树*/
    $('#menu').tree({
        url: 'json/tree_data.json',
        lines: true,
        /*点击新增选项卡*/
        onClick: function (node) {
            if($('#menu').tree("isLeaf",node.target)) {
                var tabs = $('#tabs');
                var tab = tabs.tabs("getTab", node.text);
                if (tab) {
                    /*有则选中该选项卡*/
                    tabs.tabs("select", node.text)
                } else
                /*没有则创建该选项卡*/
                    tabs.tabs('add', {
                        title: node.text,
                        href: node.attributes.url,
                        closable: true
                    });
            }
        },
        /*点击节点展开、收缩节点*/
        onSelect:function (node) {
            $(this).tree(node.state === 'closed' ? 'expand' : 'collapse', node.target);
        }
    });
</script>
<script>
    function state_change() {
        var state=$('#state');
        var str =  state.attr('class');
        // alert(str);
        if(str.match('icon-add')){
            $('#menu').tree('expandAll');
            state.removeClass('icon-add');
            state.addClass('icon-remove');
            state.tooltip('update','全部折叠');
        }else{
            $('#menu').tree('collapseAll');
            state.addClass('icon-add');
            state.removeClass('icon-remove');
            state.tooltip('update','全部展开');
        }
    }
</script>
</body>
</html>