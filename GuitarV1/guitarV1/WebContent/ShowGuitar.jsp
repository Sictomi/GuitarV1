<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table style="border:1px solid #CFCFCF;">
	 		<tr>
	 			<th>规格:21寸</th>
	 			</tr>
	 			<tr>
	 			<th>背侧板材料：花梨木</th>
	 			</tr>
	 			<tr>
	 			<th>面板材料:雪松木</th>
	 			</tr>
	 			<tr>
	 			<th>分类：民谣吉他</th>
	 		</tr>
	 		<tr>
	 			<th>价格：799</th>
	 				 		</tr>
	 		
	 	<c:forEach var="guitar" items="${requestScope.guitars}"> 
	 		<tr>
	 			
	 			<td>${guitar.builder}</td>
	 			<td>${guitar.backWood}</td>
	 			<td>${guitar.topWood}</td>
	 			<td>${guitar.type}</td>
	 			<td>${guitar.model}</td>
	 			<td>${guitar.price}</td>
	 				 		</tr>	
	 		
	 	</c:forEach>

	</table>
</body>
</html>