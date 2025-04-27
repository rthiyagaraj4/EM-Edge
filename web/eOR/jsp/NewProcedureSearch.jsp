<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*,java.text.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../js/NewProcedure.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<SCRIPT LANGUAGE="JavaScript">
<!--
/*	function callsubmit(){
		var qryStr = document.newproc_search.qryStr.value;
		var	viewScope = document.newproc_search.viewScope.value;
		var	restrict = document.newproc_search.restrict.value;
		var	status = document.newproc_search.status.value;
		var	date_from = document.newproc_search.date_from.value;
		var	date_to = document.newproc_search.date_to.value;
		qryStr += "&view="+viewScope+"&view="+viewScope+"&restrict="+restrict+"&status="+status+"&date_from="+date_from+"&date_to="+date_to ;
		document.newproc_search.action = "../../eOR/jsp/NewProcedureQueryResult.jsp?"+qryStr;
		document.newproc_search.submit();
	}*/
//-->
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style>
	/*	BODY.CONTENT{BGCOLOR:#E2E3F0}*/
	</style>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='newproc_search' id='newproc_search' method='post' action='../../eOR/jsp/NewProcedureQueryResult.jsp?<%=request.getQueryString()%>' target='proc_main_result'>
<table border="0" cellpadding="3" cellspacing="0" id='tableId' width="100%" align=center>
<%
	
	Properties property = null;
	String patient_id = request.getParameter("patient_id")==null ? "" : request.getParameter("patient_id");
	String encounter_id = request.getParameter("episode_id")==null ? "" : request.getParameter("episode_id");
	String sysdate = "";
	String fromDate = "";
	String homePageCategory=request.getParameter("category")==null ? "" : request.getParameter("category");
	String homePageLocationType=request.getParameter("locationType")==null ? "" : request.getParameter("locationType");
	String homePageLocationCode=request.getParameter("locationCode")==null ? "" : request.getParameter("locationCode");
	SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy H:mm" ) ;
	String	currentdate			= dateFormat.format(new java.util.Date()) ;
	sysdate						= currentdate ;
	try
	{
		//property = (java.util.Properties) session.getValue( "jdbc" );
	//	sysdate = patTask.getSysdateTime();
	//	fromDate = patTask.getSysdateFromTime();
%>
	<tr>
	<td class='label' align='right'> View
	</td>
	<td class='label' align='left'>
		<select name="viewScope" id="viewScope">
			<option value="A">All</option>
			<option value="S">Self Related</option>
		</select>
	</td>
	<td class=label align='right'>
	Restrict To
	</td>
	<td class=label align='left'>
		<select name='restrict' id='restrict'>
		<option value=''>----Select----</option>	
				<option value='C' >Current Encounter</option>
				<option value='A' >All Encounters</option>
				
		</select>		
	</td>	
	<td class=label align='right'>
	Status	
	</td>
	<td class=label align='left'>
		<select name='status' id='status'>
		<option value='*ALL'>----All----</option>	
				<option value='R' >Requested</option>
				<option value='A' >Appointment Booked</option>
				<option value='P' >Partially Completed</option>
				<option value='C' >Completed</option>
		</select>		
	</td>	
	</tr>
	<tr>
	
	<td class="label" align='right' colspan=''>	
		Date From
		
	</td>
	<td class=label align='left'><input type="text" name="date_from" id="date_from" size='16' maxlength='16' OnBlur='checkValidDateTime(this)' value='<%=fromDate%>'>
		<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_from',null,'hh:mm');">
		<img align=center src='../../eCommon/images/mandatory.gif' ></img>
	</td>	
	<td class='label' align='right' nowrap colspan=""> 
			To
	</td>
	<td class=label align='left'>
		<input type="text" name="date_to" id="date_to" size='16' maxlength='16' OnBlur='checkValidDateTime(this)'  value='<%=sysdate%>'>
		<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_to',null,'hh:mm');">
		<img align=center src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td class='label' colspan="2">
	</td>
	</tr>
	
	<tr>
		<td class='label' align='right' nowrap colspan="6">	
		<input class='button' type="submit" name="search" id="search" onclick=''  value='Search'>
		<input class='button' type="button" name="clear" id="clear" onclick='document.newproc_search.reset()'  value='Clear'>
	
	</td>
	<input type='hidden' name='qryStr' id='qryStr' value="<%=request.getQueryString()==null?"":request.getQueryString()%>" >	
	</tr>

<%
}
catch(Exception ee)
{
	//out.println("Exception from search page.jsp :"+ee.toString());//COMMON-ICN-0181
         ee.printStackTrace();//COMMON-ICN-0181
}

%>
</table>
</form>
</body>
</html>	

