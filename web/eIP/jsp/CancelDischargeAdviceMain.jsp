<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'</link>	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	String encounterid=request.getParameter("encounterId");     
	String fromfunction = request.getParameter("from_function")==null?"":request.getParameter("from_function");
	String facility = (String) session.getValue( "facility_id" ) ;
	String frfunction = request.getParameter("p_fr_function")==null?"":request.getParameter("p_fr_function");
	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelDischargeAdvice.label","common_labels"); 
	String enable_height_bmi_pat_cls		= checkForNull(request.getParameter("enable_height_bmi_pat_cls"));//Added by kamatchi S for ML-MMOH-SCF-1643
	if(frfunction.equals("IP"))
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DischargeAdvice.label","common_labels");
%>
<title><%=title%></title>
<iframe name='PLINE' id='PLINE' SRC='../../eCommon/jsp/pline.jsp?EncounterId=<%=java.net.URLEncoder.encode(encounterid)%>&Facility_Id=<%=java.net.URLEncoder.encode(facility)%>' noresize  frameborder=no scrolling='no' style='height:12vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../../eIP/jsp/addmodifyCancelDischargeAdvice.jsp?jsp_name=&win_height=1&win_width=40&EncounterId=<%=java.net.URLEncoder.encode(encounterid)%>&from_function=<%=java.net.URLEncoder.encode(fromfunction)%>&function_id=<%=function_id%>&enable_height_bmi_pat_cls=<%=enable_height_bmi_pat_cls%>' frameborder=0 scrolling='auto' style='height:76vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>

</html>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

