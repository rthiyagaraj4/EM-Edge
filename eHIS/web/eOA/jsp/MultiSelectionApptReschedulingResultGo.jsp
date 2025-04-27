<!--Created by Ashwini on 05-Apr-2024 for ML-MMOH-CRF-2060-->
<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<html>
<head>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eOA/js/MultiSelectionApptRescheduling.js'></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='JavaScript' src='../../eCommon/js/showModalDialog.js' ></script>

<%
	request.setCharacterEncoding("UTF-8");
	request = new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	String locn_type = request.getParameter("locn_type");
	if(locn_type ==null) locn_type="";

	String from_speciality = request.getParameter("from_speciality") ;
	if(from_speciality ==null) from_speciality="";

	String from_locn = request.getParameter("from_locn");
	if(from_locn ==null) from_locn="";

	String from_resc = request.getParameter("from_resc");
	if(from_resc ==null)from_resc="";

	String from_date = request.getParameter("from_date");
	if(from_date ==null) from_date="";

	String from_res_class = request.getParameter("from_res_class");
	if(from_res_class ==null) from_res_class="";

	String to_speciality = request.getParameter("to_speciality") ;
	if(to_speciality ==null) to_speciality="";

	String to_locn = request.getParameter("to_locn");
	if(to_locn ==null) to_locn="";

	String to_resc = request.getParameter("to_resc");
	if(to_resc ==null) to_resc="";

	String to_date = request.getParameter("to_date");
	if(to_date ==null) to_date="";

	String to_res_class = request.getParameter("to_res_class");
	if(to_res_class ==null) to_res_class="";
		
%>	
</head>
	
<body OnMouseDown='CodeArrest();'onKeyDown = 'lockKey()' >
<form name="MultiSelectionApptReschGoForm" id="MultiSelectionApptReschGoForm">

<table border="0" width="5%" bgColor=white cellspacing='0' height='100%' cellpadding='0'>

<tr>
	<td valign=center class=white><input type='button' name='forward' id='forward' value='-->' onClick="moveforward()" class='BUTTON'></td>
</tr>

</table>