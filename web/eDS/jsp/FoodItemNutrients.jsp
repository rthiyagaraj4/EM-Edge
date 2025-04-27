<!DOCTYPE html>
<%@  page contentType="text/html;charset=UTF-8"  import ="eCommon.Common.CommonBean"  %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
 	<script language='javascript' src='../../eDS/js/Nutrients.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>

<%
//Checkstyle Violation commented by Munisekhar
//String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String params = request.getQueryString();
String mode = request.getParameter("mode");
%>

			<iframe name="NutrientsAdd" id="NutrientsAdd" frameborder="0" scrolling="no" noresize src="../../eDS/jsp/NutrientsAdd.jsp?<%=params%>" style='height:60vh;width:22vw;border:0'></iframe>
				<iframe name='NutrientsPopulate' id='NutrientsPopulate' SRC='../../eDS/jsp/NutrientsPopulate.jsp?<%=params%>' scrolling='yes' noResize="no" style='height:60vh;width:70vw;border:0' frameborder='0' align="right"></iframe>
 			
 			<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name="FoodItemNutrients" id="FoodItemNutrients">
			<input type="hidden" name="params" id="params" value="<%=params%>">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		</form>
	</body>
</html>

