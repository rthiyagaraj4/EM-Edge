<!DOCTYPE html>
<!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>                                
	<head>                                
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../js/QueryMednAdminChart.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <script src='../../eXH/js/showModalDialog.js' language='JavaScript'></script>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String called_from	=	request.getParameter("called_from");
		if(called_from!=null) { 
			String title = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.MedicationAdministrationDetail.label", "ph_labels");
%>
			<title><%=title%></title>
<%
		}
%>
	</head>                               

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	if (called_from==null)
		called_from	=	"";
	if(!called_from.equals("")) { 
%>
		<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="" style="display:none"></iframe>
		<iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/QueryMednAdminChartFrames.jsp?<%=params%>" style="height:100vh;width:100vw"></iframe>
		<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="display:none"></iframe>
<%
	}
	else {
%>
		<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe>
		<iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/QueryMednAdminChartFrames.jsp" style="height:83vh;width:100vw"></iframe>
		<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:9h;width:100vw"></iframe>
<%
	}
%>
</html>

