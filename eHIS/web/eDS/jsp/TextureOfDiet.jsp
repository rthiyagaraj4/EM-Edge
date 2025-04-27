<!DOCTYPE html>
<%@  page contentType="text/html;charset=UTF-8" import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.CallableStatement,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,java.sql.Types" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
 	<script language='javascript' src='../../eDS/js/TextureOfDiet.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	
	String facility_id = (String)session.getValue("facility_id");
	params=params+"&facility_id="+facility_id;
	source=source+"&facility_id="+facility_id;

	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eDS/jsp/TextureOfDietAddModify.jsp' frameborder=0 noresize style='height:83vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name="TextureOfDietForm" id="TextureOfDietForm">
			<input type="hidden" name="params" id="params" value="<%=params%>">
		</form>
	</body>
</html>

