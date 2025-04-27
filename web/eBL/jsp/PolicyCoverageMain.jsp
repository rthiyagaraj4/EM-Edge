<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<script language="javascript" src="../../eCommon/js/common.js"></script>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String params = request.getQueryString();
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<!--<script language="javascript" src='../../eBL/js/.js'></script>-->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		
		<iframe name='SercviceCoverage' id='SercviceCoverage'	src='../../eBL/jsp/ServiceCoverage.jsp?<%=params%>'  frameborder=0 scrolling='auto' noresize style='height:36vh;width:100vw'></iframe>
		<iframe name='ServicePolicyCoverageTab' id='ServicePolicyCoverageTab'	src='../../eBL/jsp/ServicePolicyCoverageTab.jsp?<%=params%>' frameborder=0  noresize style='height:18vh;width:100vw'></iframe>
		<iframe name='ServiceCoverageTabDetails' id='ServiceCoverageTabDetails'	src='../../eBL/jsp/ServiceCoverageTabDetails.jsp?<%=params%>&prevTab=Outpatient' frameborder=0 noresize scrolling='auto' noresize style='height:54vh;width:100vw'></iframe>
		

</HTML>

