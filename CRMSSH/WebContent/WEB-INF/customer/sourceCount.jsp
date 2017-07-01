<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>客户来源统计</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/begtable.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
	</head>
	<body>
			<div style="width:50%; height: 80%; border: 1px solid #009688;">
				<div class="beg-table-box">
					<div class="beg-table-body">
						<table class="beg-table beg-table-bordered beg-table-striped beg-table-hovered">
								<tr>
									<th>客户来源</th>
									<th>数量</th>
								</tr>
							<c:forEach items="${allCustomerSource}" var="array">	
								<tr>
									<td>${array[0]}</td>
									<td>${array[1]}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="beg-table-paged">
					</div>
				</div>
			</div>
	</body>
</html>