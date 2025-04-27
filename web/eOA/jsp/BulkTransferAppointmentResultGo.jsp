<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.text.*,webbeans.eCommon.*" %>


<html>
<head>

	 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eOA/js/BulkTransferAppointment.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
</head>
<%
	request.setCharacterEncoding("UTF-8");

	String from_speciality = request.getParameter("from_speciality") ;
	if(from_speciality ==null) from_speciality="";
	String to_speciality = request.getParameter("to_speciality") ;
	if(to_speciality ==null) to_speciality="";
	String locn_type=request.getParameter("locn_type");
	if(locn_type ==null) locn_type="";
	String from_locn=request.getParameter("from_locn");
	if(from_locn ==null) from_locn="";
	String to_locn=request.getParameter("to_locn");
	if(to_locn ==null) to_locn="";
	String from_resc=request.getParameter("from_resc");
	if(from_resc ==null)from_resc="";
	String to_resc=request.getParameter("to_resc");
	if(to_resc ==null) to_resc="";
	String from_date=request.getParameter("from_date");
	if(from_date ==null) from_date="";
	String to_date=request.getParameter("to_date");
	if(to_date ==null) to_date="";
	String from_res_class=request.getParameter("from_res_class");
	if(from_res_class ==null) from_res_class="";
	String to_res_class=request.getParameter("to_res_class");
	if(to_res_class ==null) to_res_class="";
	String oper_stn=request.getParameter("oper_stn");
	if(oper_stn ==null) oper_stn="";

	

	
			
	%>	
	</head>
	
<body OnMouseDown='CodeArrest();'onKeyDown = 'lockKey()' >
<form name="bulktransferapptresultGo" id="bulktransferapptresultGo">
<table border="0" width="5%" bgColor=white cellspacing='0' height='100%' cellpadding='0'>


<tr>
			<td valign=center class=white><input type='button' name='forward' id='forward' value='-->'   onClick="moveforward()" class='BUTTON'></td>
</tr>

</table>

