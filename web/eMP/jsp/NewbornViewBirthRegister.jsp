<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<title><fmt:message key="eMP.viewbirthregdtls.label" bundle="${mp_labels}"/></title>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<Script src="../../eCommon/js/messages.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src='../../eMP/js/NewbornRegistration.js' language='javascript'></script>
	<script src='../../eMP/js/NewbornRegistration1.js' language='javascript'></script>
	<script src='../../eMP/js/NewbornRegistration2.js' language='javascript'></script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	String Patient_ID = request.getParameter("Patient_ID")==null?"":request.getParameter("Patient_ID");
	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");

%>
	<iframe name='pat_line' id='pat_line' 	 src="../../eCommon/jsp/pline.jsp?Patient_ID=<%=Patient_ID%>" frameborder=0 noresize=noresize scrolling="no" style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../jsp/ViewBirthRegMain.jsp?Patient_ID=<%=Patient_ID%>&function_id=<%=function_id%>' frameborder=0 noresize=noresize scrolling='yes' style='height:81vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' noresize=noresize style='height:9vh;width:100vw'></iframe>

</html>


<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

