<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String params = request.getQueryString();
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		
		
		<iframe name='SercviceCoverage' id='SercviceCoverage'	src='CommonServiceCoverage.jsp?<%=params%>'  frameborder=0 scrolling='auto' noresize style='height:36vh;width:100vw'></iframe>
		<iframe name='ServicePolicyCoverageTab' id='ServicePolicyCoverageTab'	src='CommonServicePolicyCoverageTab.jsp?<%=params%>' frameborder=0  noresize style='height:10vh;width:100vw'></iframe>
		<iframe name='ServiceCoverageTabDetails' id='ServiceCoverageTabDetails'	src='CommonServiceCoverageTabDetails.jsp?<%=params%>&prevTab=Outpatient' frameborder=0 noresize scrolling='auto' noresize style='height:54vh;width:100vw'></iframe>
		

</HTML>

