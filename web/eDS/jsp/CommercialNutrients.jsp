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
%>

			<iframe name="CommercialNutrientsAdd" id="CommercialNutrientsAdd" scrolling="no" noresize src="../../eDS/jsp/CommercialNutrientsAdd.jsp?<%=params%>" style="height:40vh;width:100vw;border:0"></iframe>
			<iframe name='CommercialNutrientsPopulate' id='CommercialNutrientsPopulate' SRC='../../eDS/jsp/CommercialNutrientsPopulate.jsp?<%=params%>'   scrolling='yes' noresize='no' style='height:60vh;width:100vw;border:0'></iframe>
 			
 			<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name="CommercialNutrients" id="CommercialNutrients">
			<input type="hidden" name="params" id="params" value="<%=params%>">
		</form>
	</body>
</html>

