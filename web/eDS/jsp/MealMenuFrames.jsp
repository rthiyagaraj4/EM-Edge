<!DOCTYPE html>
<%@ page import="webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<html>
<head>
<%      //Added Against MMS Vulnerability Issue - Starts
	    request= new XSSRequestWrapper(request);
	    response.addHeader("X-XSS-Protection", "1; mode=block");
	    response.addHeader("X-Content-Type-Options", "nosniff");
		//Added Against MMS Vulnerability Issue - Ends
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ?
		(String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
				if(sStyle==null)sStyle="IeStyle.css";
		//Checkstyle Violation commented by Munisekhar		
		//String facility_id	= (String)session.getAttribute("facility_id");
		String params = request.getQueryString();
		//String str = request.getParameter("MealItemsArray");
 %>
 <script type="text/javascript">
var params1="<%=params%>";
function onSuccess(){
	//parent.f_query_add_mod.location.reload();
// 		var formObj =mealMenu.document.forms[0];
// 		var params = formObj.paramValues.value;
		
		mealMenu.location.href="../../eDS/jsp/mealMenuItems.jsp?"+params1;
}
 </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

    <title>Edit Menu</title>
</head>
	  <iframe name='mealMenu' id='mealMenu' src="../../eDS/jsp/mealMenuItems.jsp?<%=params%>" style='height:90vh;width:99vw'></iframe>
	  <iframe name='qa_query_result' id='qa_query_result' src="../../eCommon/html/blank.html" frameborder=0 style='height:0vh;width:99vw'></iframe>
	  <iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:3vh;width:99vw'></iframe>

</html>

