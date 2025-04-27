<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
		<Script language='javascript' src='../../eCommon/js/common.js'></Script>
			<Script src="../../eAE/js/AEDownTimePatientsList.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			
			String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
			String params = request.getQueryString() ;
			String source = url + params ;
			String fac_id    	= (String) session.getValue( "facility_id" ) ;
			Connection con                  =   null;
		%>
	</head>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='AEDownTimePatientsList.jsp?params=<%=params%>' frameborder=0  scrolling='auto' style='height:83vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

