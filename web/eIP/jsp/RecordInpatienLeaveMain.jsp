<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'</link>
	<script language='javascript' src='../js/RecordInpatientLeave.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    
</head>
<%
	request.setCharacterEncoding("UTF-8"); 
	String encounterid		= request.getParameter("encounterId");        
	String facility			= (String) session.getValue( "facility_id" ) ;
	String patientid		= request.getParameter("patientId");
//	String function_name	= request.getParameter("function_name");
%>

<title><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.RecordInpatientLeaveAbscond.label","ip_labels")%></title>
	<iframe name='PLINE' id='PLINE' SRC='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounterid%>&Facility_Id=<%=facility%>' noresize  frameborder=no scrolling='no' style='height:10vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../jsp/addmodifyRecordInpatientLeave.jsp?jsp_name=&win_height=1&win_width=30&EncounterId=<%=encounterid%>&PatientId=<%=patientid%>' frameborder=0 scrolling='no' style='height:75vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

