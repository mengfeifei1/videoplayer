<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左侧导航menu</title>
<c:set value="${pageContext.request.contextPath }" var="ctx"></c:set>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/sdmenu.js"></script>
<script type="text/javascript">
	// <![CDATA[
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();
	};
	// ]]>
</script>
<style type=text/css>
html {
	SCROLLBAR-FACE-COLOR: #538ec6;
	SCROLLBAR-HIGHLIGHT-COLOR: #dce5f0;
	SCROLLBAR-SHADOW-COLOR: #2c6daa;
	SCROLLBAR-3DLIGHT-COLOR: #dce5f0;
	SCROLLBAR-ARROW-COLOR: #2c6daa;
	SCROLLBAR-TRACK-COLOR: #dce5f0;
	SCROLLBAR-DARKSHADOW-COLOR: #dce5f0;
	overflow-x: hidden;
}

body {
	overflow-x: hidden;
	background: url(images/main/leftbg.jpg) left top repeat-y #f2f0f5;
	width: 194px;
}
</style>
</head>
<body onselectstart="return false;" ondragstart="return false;"
	oncontextmenu="return false;">
	<div id="left-top">
		<div>
			<img src="images/userPhotos/defa.jpg" width="44" height="44" />
		</div>
		<span>用户：admin<br>角色：超级管理员</span>
	</div>
	<div style="float: left" id="my_menu" class="sdmenu">
		<div class="collapsed">
			<span>视频模块</span> <a href="${ctx}/background/getVideo" target="mainFrame"
				onFocus="this.blur()">视频列表</a>
		</div>
		<div>
			<span>评论模块</span> <a href="${ctx}/background/getAllComment" target="mainFrame"
				onFocus="this.blur()">评论列表</a>
		</div>
		<div>
			<span>弹幕模块</span> <a href="${ctx}/background/getAllBarrage" target="mainFrame"
				onFocus="this.blur()">弹幕列表</a>
		</div>
		<div>
			<span>统计模块</span> <a href="${ctx}/background/getOrderVideo" target="mainFrame"
				onFocus="this.blur()">视频获赞排行</a>
		</div>
		<div>
			<span>推荐模块</span> <a href="${ctx}/background/getHotVideo" target="mainFrame"
				onFocus="this.blur()">推荐视频列表</a>
		</div>
	</div>
</body>
</html>