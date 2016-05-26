<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.box{display:inline;}
</style>
</head>
<body>
	 <div>
	 	<form action="GuitarPost" method="post">
	 		<label>规格:</label>
	 		<select name="size">
	 			<option value=""></option>
	 			<option value="21寸">21寸</option>
	 			<option value="23寸">23寸</option>
	 			<option value="26寸">26寸</option>
	 			<option value="28寸">28寸</option>
	 			<option value="30寸">30寸</option>
	 			<option value="36">36寸</option>
	 			<option value="38">38寸</option>
	 			<option value="39">39寸</option>
	 		</select>
	 		
	 		<label>分类:</label>
	 		<select name="type">
	 			<option value=""></option>
	 			<option value="民谣吉他">民谣吉他</option>
	 			<option value="电吉他">电吉他</option>
	 			<option value="尤克里里">尤克里里</option>
	 		</select>
	 		
	 		<label>背侧板材料:</label>
	 		<select name="backwood">
	 			<option value=""></option>
	 			<option value="花梨木">花梨木</option>
				<option value="梧桐木">梧桐木</option>
				<option value="桦木">桦木</option>
				<option value="椴木">椴木</option>
				<option value="柏木">柏木</option>
				<option value="柚木">柚木</option>

	 		</select>
	 		
	 		<label>面板材料:</label>
	 		<select name="topwood">
	 			<option value=""></option>
	 			<option value="白松木">白松木</option>
				<option value="南阳木">南阳木</option>
				<option value="雪松木">雪松木</option>
				<option value="椴木">椴木</option>
				<option value="杨木">杨木</option>
				
	 		</select>
	 		<input type="submit" name="search" value="Search"/>	 		
	 	</form>
	 </div>
	 <!--
	 <div>
	 	<iframe name="show" src="guitarShow.jsp" style="width:90%;height:250px;"></iframe>
	 </div>
	 -->
</body>
</html>