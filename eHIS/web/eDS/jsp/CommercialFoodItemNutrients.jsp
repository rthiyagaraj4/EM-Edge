<!DOCTYPE html>
<%@  page contentType="text/html;charset=UTF-8"  import ="eCommon.Common.CommonBean"  %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
 	<script language='javascript' src='../../eDS/js/CommercialFoodItem.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>

<%
// Checkstyle Violation commented by Munisekhar
//String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String params = request.getQueryString();
String mode = request.getParameter("mode");
%>
<div style="display: flex; width: 100vw; height: 100vh;" scrolling="no">
			<iframe name="CommercialNutrientsAdd" id="CommercialNutrientsAdd"  scrolling="no" noresize src="../../eDS/jsp/CommercialNutrientsAdd.jsp?<%=params%>" style='height:40vh;width:40%;border:0'></iframe>
			<iframe name='CommercialNutrientsPopulate' id='CommercialNutrientsPopulate' SRC='../../eDS/jsp/CommercialNutrientsPopulate.jsp?<%=params%>'   scrolling='no' noresize='no' style='height:60vh;width:60%;border:0'></iframe>
		</div>
 			<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name="CommercialNutrients" id="CommercialNutrients">
			<input type="hidden" name="params" id="params" value="<%=params%>">
			<input type="hidden" name="mode" id="mode" value="<%=mode %>">
		</form>
	</body>
</html>

