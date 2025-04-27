<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ include file="/framework/html/Tag.text"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%
			
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
			:"IeStyle.css" ;
			if(sStyle==null)sStyle="IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='/eHIS-DS/core/css/<%=sStyle%>'></link>
</head>
<body class="CONTENT" bgcolor="#ccccff">
		<ol type="I">
			<br><br>
			<li><a href="http://localhost:8888/eHIS-DS/core/jsp/intermediate.jsp?functionId=mealtype">Mealtype </a><br><br>
			<li><a href="http://localhost:8888/eHIS-DS/core/jsp/intermediate.jsp?functionId=itemtype">Itemtype </a><br><br>
			<li><a href="http://localhost:8888/eHIS-DS/core/jsp/intermediate.jsp?functionId=ingredients">Ingredients </a><br><br>
			<li><a href="http://localhost:8888/eHIS-DS/core/jsp/intermediate.jsp?functionId=diettype">DietType </a><br><br>
			<li><a href="http://localhost:8888/eHIS-DS/core/jsp/intermediate.jsp?functionId=fooditem">FoodItem </a><br><br>
			<li><a href="http://localhost:8888/eHIS-DS/core/jsp/intermediate.jsp?functionId=kitchen">Kitchen </a><br><br>
			<li><a href="http://localhost:8888/eHIS-DS/core/jsp/intermediate.jsp?functionId=mealclass">Mealclass </a><br><br>
			<li><a href="http://localhost:8888/eHIS-DS/core/jsp/intermediate.jsp?functionId=complaints">Complaints </a><br><br>
			<li><a href="http://localhost:8888/eHIS-DS/core/jsp/intermediate.jsp?functionId=deliveryinstruction">Delivery Instruction </a><br><br>
			<li><a href="http://localhost:8888/eHIS-DS/core/jsp/intermediate.jsp?functionId=wardsforkitchen">Wards For Kitchen </a><br><br>
		</li>	

</body>
</html>
