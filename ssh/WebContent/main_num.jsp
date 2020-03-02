<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主要内容区main</title>
<c:set value="${pageContext.request.contextPath }" var="ctx"></c:set>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<style>
body {
	overflow-x: hidden;
	background: #f2f0f5;
	padding: 15px 0px 10px 5px;
}

#searchmain {
	font-size: 12px;
}

#search {
	font-size: 12px;
	background: #548fc9;
	margin: 10px 10px 0 0;
	display: inline;
	width: 100%;
	color: #FFF;
	float: left
}

#search form span {
	height: 40px;
	line-height: 40px;
	padding: 0 0px 0 10px;
	float: left;
}

#search form input.text-word {
	height: 24px;
	line-height: 24px;
	width: 180px;
	margin: 8px 0 6px 0;
	padding: 0 0px 0 10px;
	float: left;
	border: 1px solid #FFF;
}

#search form input.text-but {
	height: 24px;
	line-height: 24px;
	width: 55px;
	background: url(images/main/list_input.jpg) no-repeat left top;
	border: none;
	cursor: pointer;
	font-family: "Microsoft YaHei", "Tahoma", "Arial", '宋体';
	color: #666;
	float: left;
	margin: 8px 0 0 6px;
	display: inline;
}

#search a.add {
	background: url(images/main/add.jpg) no-repeat -3px 7px #548fc9;
	padding: 0 10px 0 26px;
	height: 40px;
	line-height: 40px;
	font-size: 14px;
	font-weight: bold;
	color: #FFF;
	float: right
}

#search a:hover.add {
	text-decoration: underline;
	color: #d2e9ff;
}

#main-tab {
	border: 1px solid #eaeaea;
	background: #FFF;
	font-size: 12px;
}

#main-tab th {
	font-size: 12px;
	background: url(images/main/list_bg.jpg) repeat-x;
	height: 25px;
	line-height: 25px;
}

#main-tab td {
	font-size: 12px;
	line-height: 25px;
}

#main-tab td a {
	font-size: 12px;
	color: #548fc9;
}

#main-tab td a:hover {
	color: #565656;
	text-decoration: underline;
}

.bordertop {
	border-top: 1px solid #ebebeb
}

.borderright {
	border-right: 1px solid #ebebeb
}

.borderbottom {
	border-bottom: 1px solid #ebebeb
}

.borderleft {
	border-left: 1px solid #ebebeb
}

.gray {
	color: #dbdbdb;
}

#selete{
	font-size: 15px;
	margin-left:10px;
	text-decoration:none;
	color: #ffffff;
}

td.fenye {
	text-align: right;
}

.bggray {
	background: #f9f9f9
}

#addinfo {
	padding: 0 0 10px 0;
}
</style>
</head>
<body>
	<!--main_top-->
	<table width="99%" border="0" cellspacing="0" cellpadding="0"
		id="searchmain">
		<tr>
			<td width="99%" align="left" valign="top" id="addinfo">您的位置：视频排行</td>
		</tr>
		<tr>
			<td align="left" valign="top">

				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					id="main-tab">
					<tr style="background-color: #ddd">
						<th align="center" valign="middle" class="borderright">视频获赞数</th>
						<th align="center" valign="middle" class="borderright">视频标题</th>
						<th align="center" valign="middle" class="borderright">视频封面</th>
						<th align="center" valign="middle" class="borderright">视频分类</th>
					</tr>
					<c:forEach items="${videoList}" var="videos">
					<tr onMouseOut="this.style.backgroundColor='#ffffff'"
						onMouseOver="this.style.backgroundColor='#edf5ff'">
						<td align="center" valign="middle"
							class="borderright borderbottom">${videos.videoZanNum}</td>
						<td align="center" valign="middle"
							class="borderright borderbottom">${videos.videoTitle}</td>
						<td align="center" valign="middle"
							class="borderright borderbottom"><img src="${ctx }/${videos.videoPic}" width="74" height="60" style="margin-top:5px"></td>
						<td align="center" valign="middle"
							class="borderright borderbottom">${videos.videoType}</td>
					</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>