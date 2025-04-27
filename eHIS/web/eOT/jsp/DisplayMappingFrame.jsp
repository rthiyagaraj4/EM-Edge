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
<%
		String params = request.getQueryString();
		
%>

<script>
	
</script>
<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
		<iframe name='displayMappingDtl' id='displayMappingDtl'	src='DisplayMappingAdd.jsp?<%=params%>'  scrolling='auto' noresize style="height:100vh;width:100vw"  frameborder='0'></iframe>
		
</HTML>

