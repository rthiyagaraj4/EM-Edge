<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String defaultTab = checkForNull(request.getParameter("defaultTab"));
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eOH/js/OHCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<!-- <frameset rows='17%,*'> -->
	<frameset rows='17%,*'>
		<frame name="f_query_add_mod_middle" id="f_query_add_mod_middle" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/OHDentalChartSubTabSearch.jsp?<%=request.getQueryString()%>">
	<%
		if(defaultTab.equals("GingivalStatus")){
	%>
			<frame name='qa_query_result' id='qa_query_result' src="../../eOH/jsp/GingivalStatus.jsp?<%=request.getQueryString()%>" frameborder=0>
	<%
		}
		else if(defaultTab.equals("ExtTreatment")){
	%>
			<frame name='qa_query_result' id='qa_query_result' src="../../eOH/jsp/DentalExtTreatment.jsp?<%=request.getQueryString()%>" frameborder=0>
	<%
		}
		else{
	%>
			<frame name='qa_query_result' id='qa_query_result' src="../../eOH/jsp/DentalCondition.jsp?<%=request.getQueryString()%>" frameborder=0>
	<%
		}
	%>
	</frameset>
</html>


