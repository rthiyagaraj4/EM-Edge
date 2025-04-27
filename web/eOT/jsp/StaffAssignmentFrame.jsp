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
		
		String mode = request.getParameter("mode");
		
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
	
		<%
			System.err.println(" mode : " + mode);
			if(mode == null || !mode.equals("modify") )
			{
		%>		
			<iframe name='staffAssignmentDtl' id='staffAssignmentDtl'	src='StaffAssignmentAdd.jsp?<%=params%>'   scrolling='auto' noresize style="height:98vh;width:98vw"></iframe>
		<%
			}
			else
			{
				
		%>
			
				<iframe name='staffAssignmentDtl' id='staffAssignmentDtl'	src='StaffAssignmentModify.jsp?<%=params%>'  scrolling='yes' style="height:15vh;width:98vw"></iframe>
				<iframe name='staffAssignmentRoleDtl' id='staffAssignmentRoleDtl'	src='StaffAssignmentRoleModify.jsp?<%=params%>'   scrolling='yes' style="height:75vh;width:98vw"></iframe>
		<%
			}
		%>
</HTML>

