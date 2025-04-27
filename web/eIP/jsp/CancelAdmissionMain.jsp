<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>   
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'</link>
	<script src='../../eIP/js/CancelAdmission.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	String encounterid	= checkForNull(request.getParameter("encounterId"));   
	String patientId	= checkForNull(request.getParameter("patientId"));        
	String pat_check_in_allowed_yn	= checkForNull(request.getParameter("pat_check_in_allowed_yn"));     
	String facility		= checkForNull((String) session.getValue( "facility_id" ));

	String allowCancelAdmsn = checkForNull(request.getParameter("allowCancelAdmsn")); //Added by Thamizh selvi on 22nd Feb 2017 against MMS-QH-CRF-0182

%>        
<title><fmt:message key="Common.CancelAdmission.label" bundle="${common_labels}"/> </title>
	<iframe name='PLINE' id='PLINE' SRC='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounterid%>&Facility_Id=<%=facility%>' noresize  frameborder=no scrolling='no' style='height:15vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='addmodifyCancelAdmission.jsp?jsp_name=&win_height=1&win_width=40&encounter_id=<%=encounterid%>&allowCancelAdmsn=<%=allowCancelAdmsn%>&pat_check_in_allowed_yn=<%=pat_check_in_allowed_yn%>&patientId=<%=patientId%>' frameborder=0 scrolling='no' style='height:73vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
	<iframe name='submitFrame' id='submitFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
	
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

