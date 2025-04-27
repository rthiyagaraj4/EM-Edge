<!DOCTYPE html>
<!--
-----------------------------------------------------------------------------------------------
Date        Edit History     Name              Description
-----------------------------------------------------------------------------------------------
20/11/12    100              PParthasarathy    created 

Has two Frames, one for page details and the other for buttons 

1. StaffAssigmentAddModify.jsp
2. StaffAssigmentBtn.jsp
----------------------------------------------------------------------------------------------- 
-->

<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*, eOT.* ,eOT.Common.*,eCommon.Common.*,eOT.Common.OTRepository" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%
		String params = request.getQueryString();
		String statusBeanId = "PatientStatusBean";
		String statusBeanName = "eOT.PatientStatusBean";
		PatientStatusBean statusBean = (PatientStatusBean)mh.getBeanObject( statusBeanId, request, statusBeanName );
		statusBean.clear();
		
%>

<script>
function closeHelp()
{ 
	
	var key = event.keyCode; 
	if (key == 27)
	{
		if(parent.opener != null)
		{
			parent.opener.closeDashboard();
		}
		else
		{
			window.close();	
		}
	}
} 
</script>
<HTML>
<HEAD>
</HEAD>

<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
		<iframe name='patientStatusHdr' id='patientStatusHdr'	src='PatientHeader.jsp?<%=params%>'  frameborder=0 scrolling='auto' noresize onkeypress="closeHelp() " style="width:99vw; height:7vh;"></iframe>
			<iframe name='patientStatusContent' id='patientStatusContent'	src='PatientCurrentStatusMenu.jsp?<%=params%>'  frameborder=0 scrolling='auto' noresize style="width:99vw; height:90vh;"></iframe>
			
		
		
		
</HTML>

