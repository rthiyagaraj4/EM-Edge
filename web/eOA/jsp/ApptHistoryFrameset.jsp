<!DOCTYPE html>
<!--Created by Thamizh selvi on 22nd May 2017 for ML-MMOH-CRF-0610-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>


<script>
function reset()
{   searchFrame.document.Appt_history_form.reset() ;
	searchFrame.document.forms[0].b_loc_val.disabled=true;
	searchFrame.document.forms[0].b_loc_search.disabled=true;
	searchFrame.document.forms[0].resourceType_1.disabled=true;
	searchFrame.document.forms[0].practitioner_name.disabled=true;
	searchFrame.document.forms[0].search_pract.disabled=true;
	searchResultFrame.document.location.href = '../../eCommon/html/blank.html' ;
}
</script>
<html>
	<head>
		<%
			String sStyle	=
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>		
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		  <link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
       <script src='../../eOA/js/OAAppointmentHistory.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
   
		
	</head>
	<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='searchFrame' id='searchFrame' 	src='../../eOA/jsp/ApptHistorySearchCriteria.jsp?function_id=<%=function_id%>' scrolling='no' noresize style='height:30vh;width:100vw'></iframe>
	<iframe name='searchResultFrame' id='searchResultFrame' 	src='../../eCommon/html/blank.html' scrolling='auto' noresize style='height:55vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
	
</html>

