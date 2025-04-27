<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%	request.setCharacterEncoding("UTF-8");	%>

<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String loaded_from_main_tab = checkForNull(request.getParameter("loaded_from_main_tab")); 
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- <frameset rows='4%,0,*'>  on 221007-->
<frameset rows='0,*,0'>  
		<!-- <frame name="trmtDentalChartToolHeader" id="trmtDentalChartToolHeader" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/OHDentalChartToolHeader.jsp?<%=request.getQueryString()%>"> --> <!-- // THis frame is included in OH.jsp -->
		<!-- <frame name="dummyFrame" id="dummyFrame" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/OHMixedDentAlertFrame.jsp?<%=request.getQueryString()%>"> -->
		<frame name="dummyFrame" id="dummyFrame" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/OHMixedDentAlertFrame.jsp?<%=request.getQueryString()%>&<%=loaded_from_main_tab%>">
		<frame name="trmtDentalChart" id="trmtDentalChart" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html">
	</frameset>
</html>

