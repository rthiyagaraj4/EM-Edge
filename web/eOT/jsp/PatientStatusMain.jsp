<!DOCTYPE html>
<!--
-----------------------------------------------------------------------------------------------
Date        Edit History     Name              Description
-----------------------------------------------------------------------------------------------
20/11/12    100              PParthasarathy    created 

Contains the following frames

1. CommonToolBarFrame
2. Display Mapping Frame
3. Error Message Display frame 
----------------------------------------------------------------------------------------------- 
-->

<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*, eOT.* ,eOT.Common.*,eCommon.XSSRequestWrapper,eCommon.Common.*" %>

<HTML>
<HEAD>

		<script> 
			function closeHelp()
			{ 
				var key = event.keyCode; 
				if (key == 27)
				{
					//window.close();
					if(opener != null)
					{
						opener.closeDashboard();
					}
					else
					{
						window.close();	
					}
				}
			} 
			
		</script>
		<title> Display Mapping </title>
			
</HEAD>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
-->
<%
		request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>		
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			String function_id=request.getParameter("function_id");
			if(function_id==null || function_id.equals("")) function_id="";
			String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
			String source = url + params ;

%>

		<iframe name='patientStatusFrame' id='patientStatusFrame' 	src='../../eOT/jsp/PatientStatusFrame.jsp?<%=params%>' frameborder=1 scrolling='' noresize style="width:99vw; height:99vh;"></iframe>
		


</HTML> 

