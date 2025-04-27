<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import=" webbeans.eCommon.* , java.text.*" %>  

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
request.setCharacterEncoding("UTF-8");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eMP/js/VwEncounterDetails.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 <head>
 <BODY onKeyDown ='lockKey()'>
 <form name="EncounterResultMain" id="EncounterResultMain">
<%
	String	patientid=
	(request.getParameter("patientid")==null)?"":request.getParameter("patientid") ;
%>
	<table border="0" cellpadding="0" cellspacing="0" align='center' width="100%">
	<tr>
	<td >
	<jsp:include page="../../eCommon/jsp/pline.jsp" flush="true">
    <jsp:param name="Patient_ID" value="<%=patientid%>"/>
	</jsp:include>
	</td>
	</tr>
 </form>
 </body>
 </html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : 

inputString);
	}
%>

