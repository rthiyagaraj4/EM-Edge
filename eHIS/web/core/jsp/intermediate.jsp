<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ include file="/framework/html/Tag.text"%>
<ibaHTML:html>
<head>
</head>
<body  class="CONTENT" bgcolor="#ccccff">
<%
String id=request.getParameter("functionId");
if(id.equals("mealtype"))
{
session.setAttribute("functionId","mealtype");
session.setAttribute("moduleId","ds");

%>
<script>
	location.href="/eHIS-DS/eDS/MealType/jsp/MealTypeMain.jsp"
</script>

<%
}
if(id.equals("feedtype"))
{
session.setAttribute("functionId","feedtype");
session.setAttribute("moduleId","ds");

%>
<script>
	location.href="/eHIS-DS/eDS/FeedType/jsp/FeedTypeMain.jsp"
</script>

<%
}
if(id.equals("nutrients"))
{
session.setAttribute("functionId","nutrients");
session.setAttribute("moduleId","ds");

%>
<script>
	location.href="/eHIS-DS/eDS/Nutrients/jsp/NutrientsMain.jsp"
</script>

<%
}
else if(id.equals("mealclass"))
{
session.setAttribute("functionId","mealclass");
session.setAttribute("moduleId","ds");
%>
<script>
	location.href="/eHIS-DS/eDS/MealClass/jsp/MealClassMain.jsp"
</script>
<%
}else if(id.equals("complaints"))
{	
session.setAttribute("functionId","complaints");
session.setAttribute("moduleId","ds");
%>
<script>
	location.href="/eHIS-DS/eDS/Complaints/jsp/ComplaintsMain.jsp"
</script>
<%
}else if(id.equals("dsparameteracrossthefacility"))
{	
	session.setAttribute("functionId","dsparameteracrossthefacility");
	session.setAttribute("moduleId","ds");
	%>
	<script>
		location.href="/eHIS-DS/eDS/DSparameterAcrossTheFacility/jsp/DSparameterAcrossTheFacilityMain.jsp"
	</script>
	<%
}else if(id.equals("deliveryinstruction"))
{	
	session.setAttribute("functionId","deliveryInstruction");
	session.setAttribute("moduleId","ds");
	%>
	<script>
		location.href="/eHIS-DS/eDS/DeliveryInstruction/jsp/DeliveryInstructionMain.jsp"
	</script>
	<%
}else if(id.equals("wardsforkitchen"))
{	
	session.setAttribute("functionId","wardsforkitchen");
	session.setAttribute("moduleId","ds");
	%>
	<script>
		location.href="/eHIS-DS/eDS/wardsforkitchen/jsp/WardsForKitchenMain.jsp"
	</script>
	<%
}else if(id.equals("dsparameterforthefacility"))
{	
	session.setAttribute("functionId","dsparameterforthefacility");
	session.setAttribute("moduleId","ds");
	%>
	<script>
		location.href="/eHIS-DS/eDS/dsparameterforthefacility/jsp/DSparameterForTheFacilityMain.jsp"
	</script>
	<%
	}
%>


</body>
</ibaHTML:html>
