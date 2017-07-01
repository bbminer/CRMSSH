<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>分页客户列表</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/begtable.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
	</head>
	<body>
			<div style="width:100%; height: 80%; border: 1px solid #009688;">
				<div class="beg-table-box">
					<div class="beg-table-body">
						<table class="beg-table beg-table-bordered beg-table-striped beg-table-hovered">
								<tr>
									<th>客户名称</th>
									<th>客户级别</th>
									<th>客户来源</th>
									<th>固定电话</th>
									<th>移动电话</th>
									<th>操作</th>
								</tr>
							<c:forEach items="${pageBean.list}" var="customer">	
								<tr>
									<td>${customer.custName}</td>
									<td>${customer.dict.dname}</td>
									<td>${customer.custSource}</td>
									<td>${customer.custPhone}</td>
									<td>${customer.custMobile}</td>
									<td><a href="${pageContext.request.contextPath}/toEditPage?cid=${customer.id}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/delete?cid=${customer.id}">删除</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="beg-table-paged">
					共[<B>${pageBean.rowsCount}</B>]条记录，[<B>${pageBean.totalPage}</B>]页，当前第[<B>${pageBean.currentPage}</B>]页
					<c:if test="${pageBean.currentPage!=1 }">
					[<B><a href="${pageContext.request.contextPath}/limitPage?pageBean.currentPage=${pageBean.currentPage-1}">前一页</a></B>]
					</c:if>
					
					<c:if test="${pageBean.currentPage!=pageBean.totalPage}">
					[<B><a href="${pageContext.request.contextPath}/limitPage?pageBean.currentPage=${pageBean.currentPage+1}">后一页</a></B>]
					</c:if>
					</div>
				</div>
			</div>
	</body>
</html>