<!DOCTYPE html>
<%@ page import="java.sql.*,java.text.*, eCommon.XSSRequestWrapper, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html> 
 
<head>
    <!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script language='javascript' src='../../eOP/js/ClinicForResource.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	 </head>
	<%
	String clinic_code=request.getParameter("clinic_code");
	String function=request.getParameter("call_func");

		//String url="../../eCommon/jsp/commonToolbar.jsp?";
		//String params = request.getQueryString() ;
		//String source = url + params ;
		String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";
	Connection conn = null;
	Boolean isAlertApplicableforBookAppt=false; //Added by Mujafar  for GHL-CRF-0527
	String fr_size = "130";
	try{
		conn=ConnectionManager.getConnection(request);
		isAlertApplicableforBookAppt = eCommon.Common.CommonBean.isSiteSpecific(conn, "OP", "ALRT_DISP_APPL_BOOK_APPT");//Added by Mujafar  for GHL-CRF-0527
		if(isAlertApplicableforBookAppt)
			fr_size="165";
	}
	
	 catch(Exception e)
        {
			e.printStackTrace();
        }
		finally
        {
			if(conn!=null)
			ConnectionManager.returnConnection(conn,request);
        }
	

	/*Below frame modified for this incident  [IN:038056]*/
	%>
<iframe name='clinic_main' id='clinic_main'    src='../../eOP/jsp/ClinicMainResource.jsp?function_id=<%=function_id%>&clinic_code=<%=clinic_code%>&call_func=<%=function%>' frameborder=0 scrolling='no' noresize style='height:25vh;width:100vw'></iframe>
    <iframe name='clinic_sub' id='clinic_sub'   src='../../eOP/jsp/AddModifyClinicResource.jsp?function_id=<%=function_id%>&clinic_code=<%=clinic_code%>&call_func=<%=function%>' frameborder=0 scrolling='yes'  style='height:70vh;width:100vw'></iframe>
    <iframe name='dummyframe' id='dummyframe' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>
</html>

