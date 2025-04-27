<!DOCTYPE html>
<%@  page contentType="text/html;charset=UTF-8"  import ="eCommon.Common.CommonBean"  %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
 	<script language='javascript' src='../../eDS/js/Kitchen.js'></script>
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

			<iframe name="KitchenAreaAdd" id="KitchenAreaAdd" frameborder="0" scrolling="no" noresize src="../../eDS/jsp/KitchenAreaAdd.jsp?<%=params%>" style="height:100vh;width:40vw;border:0"></iframe>
				<iframe name='KitchenAreaPopulate' id='KitchenAreaPopulate' SRC='../../eDS/jsp/KitchenAreaPopulate.jsp?<%=params%>'   scrolling='auto' noresize='no' style="height:100vh;width:49vw;border:0"></iframe>
 			
				<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name="KitchenAreaForm" id="KitchenAreaForm">
			<input type="hidden" name="params" id="params" value="<%=params%>">
			<input type="hidden" name="mode" id="mode" value="<%=mode %>">
		</form>
	</body>
</html>

