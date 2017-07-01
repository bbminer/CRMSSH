<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>联系人列表</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/begtable.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/layui/css/layui.css"
	media="all" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
</head>
<body>
	<form class="layui-form"
		action="${pageContext.request.contextPath}/linkManQueryByName"
		method="post">
		<div class="layui-form-item">
			<label class="layui-form-label">按名称查询</label>
			<div class="layui-input-inline">
				<input type="text" name="linkMan.name" class="layui-input">
			</div>
			<div class="layui-input-inline">
				<input type="submit" value="查询" class="layui-input">
			</div>
		</div>
	</form>
	<div style="width: 100%; height: 80%; border: 1px solid #009688;">
		<div class="beg-table-box">
			<div class="beg-table-body">
				<table
					class="beg-table beg-table-bordered beg-table-striped beg-table-hovered">
					<tr>
						<th>联系人名称</th>
						<th>性别</th>
						<th>办公电话</th>
						<th>手机</th>
						<th>所属客户</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${listLinkMan}" var="linkMan">
						<tr>
							<td>${linkMan.name}</td>
							<td>${linkMan.gender}</td>
							<td>${linkMan.phone}</td>
							<td>${linkMan.mobile}</td>
							<td>${linkMan.customer.custName}</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
								href="${pageContext.request.contextPath}/toLinkManEditPage?lid=${linkMan.id}">修改</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="beg-table-paged"></div>
		</div>
	</div>
</body>
</html>