<!DOCTYPE html>
<!--
-----------------------------------------------------------------------------------------------
Date        Edit History     Name              Description
-----------------------------------------------------------------------------------------------
20/11/12    100              PParthasarathy    created 

Contains the following frames

1. CommonToolBarFrame
2. Staff Assignment Frame
3. Error Message Display frame 
----------------------------------------------------------------------------------------------- 
-->

<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*, eOT.* ,eOT.Common.*,eCommon.Common.*" %>

<HTML>

<HEAD>
</HEAD>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>		
		<script language='javascript' src='../../eOT/js/StaffAssignment.js'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script type='text/javascript' src='../../eCommon/js/dchk.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
<%
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			String function_id=request.getParameter("function_id");
			if(function_id==null || function_id.equals("")) function_id="";
			String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
			String source = url + params ;

%>

		<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>'  scrolling='no' noresize style="height:6vh;width:100vw"></iframe>
			<iframe name='staffAssigmentFrame' id='staffAssigmentFrame' 	src='../../eCommon/html/blank.html'  scrolling='' noresize style="height:84vh;width:100vw" frameborder='0'></iframe>
			<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' noresize scrolling='auto' noresize style="height:10vh;width:100vw" frameborder='0'></iframe>
		
	<script>   </script>

</HTML> 

