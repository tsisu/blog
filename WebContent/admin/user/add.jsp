<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增用户</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/theme.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-awesome/css/font-awesome.css">
<script src="${pageContext.request.contextPath}/css/jquery-1.8.1.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
</head>
<body>
	<!-- 页标题栏 -->
	<ul class="breadcrumb">
		<li><a href="#">文章管理</a> <span class="divider">/</span></li>
		<li class="active">增加文章</li>
	</ul>
	<!-- 提示信息窗口 -->
	<div class="alert">
		<button type="button" class="close" data-dismiss="alert">×</button>
		<h4>提示!</h4>
		<strong id="msg">${msg}</strong>
	</div>
	<!-- 主窗口（表单） -->
	<div class="row-fluid">
		<div class="span12">
			<form class="form-horizontal"
				action="${pageContext.request.contextPath}/admin/user?cmd=add"
				method="post" >
				<!-- 控件样式 -->
				<div class="control-group">
					<label class="control-label">用户等级</label>
					<div class="controls">
						<select name="roleid">
						<c:forEach items="${sysrolelist}" var="role">
						<option value="${role.roleid}">${role.rolename}</option>
						</c:forEach>
						</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="username">用户姓名</label>
					<div class="controls">
						<input type="text" name="username" id="username">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">用户密码</label>
					<div class="controls">
						<input type="text" name="userpwd" id="userpwd">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">真实姓名</label>
					<div class="controls">
						<input type="text" name="usertruename" id="usertruename">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">用户性别</label>
					<div class="controls">
					<tr>
                       <td>
                        <input type="radio" class="sex" value="男" checked="checked">男
                        <input type="radio" class="sex" value="女">女
                        </td>
               	   </tr>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">用户状态</label>
					<div class="controls">
				<select name="userstate">
					<c:choose>
						<c:when test="${param.userstate==1}">
							<option value="1" selected="selected">正常</option>
							<option value="0">不正常</option>
						</c:when>
						<c:otherwise>
							<option value="1">正常</option>
							<option value="0">不正常</option>
						</c:otherwise>
					</c:choose>
				</select>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<input type="submit" class="btn" value="提交" />
						<button class="btn btn-primary" type="button" 
						onclick="window.location.href='${pageContext.request.contextPath}/admin/user/list.jsp';">返回</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>