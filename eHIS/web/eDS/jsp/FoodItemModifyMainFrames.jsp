<!DOCTYPE html>
<!-- Newly Created for KDAH-CRF-0359.1-->
<%@  page contentType="text/html;charset=UTF-8" import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.CallableStatement,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,java.sql.Types" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
 	<script language='javascript' src='../../eDS/js/FooditemModify.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language="Javascript" src="../../eDS/js/json.js"></script>
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
	
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw;border:0'></iframe>
		<iframe name="FoodItemModifyCriteria" id="FoodItemModifyCriteria" src="../../eDS/jsp/FoodItemModifyMain.jsp?mode=initialLoad" scrolling="no" frameborder="0" noresize="noresize"/ style="height:17vh;width:100vw;border:0"></iframe>
		<iframe name="FoodItemModifyResult" id="FoodItemModifyResult"  src="../../eCommon/html/blank.html"  scrolling="no" frameborder="0" noresize="noresize"/ style="height:65vh;width:100vw;border:0"></iframe>
		<iframe name="messageFrame" id="messageFrame"	src="../../eCommon/jsp/MstCodeError.jsp" frameborder=0 noresize scrolling='auto' style='height:5vh;width:100vw;border:0'></iframe>
</html>

