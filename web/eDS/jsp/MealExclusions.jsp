<!DOCTYPE html>
<%@ page import="webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<%  
    //Added Against MMS Vulnerability Issue - Starts
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
    //Added Against MMS Vulnerability Issue - Ends
	String locale 			= (String)session.getAttribute("LOCALE");
	String sStyle 			= ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;

	HttpSession httpSession = request.getSession(false);
	Properties p 			= (Properties)httpSession.getValue("jdbc");

	String strloggeduser	= (String) httpSession.getValue("login_user");
	String strclientip		= "";
	strclientip				= p.getProperty("client_ip_address");

	String fetchedMealTypesWithTime = request.getParameter("fetchedMealTypesWithTime");
	String profileSL 		= request.getParameter("profileSL");
	String encounterId 		= request.getParameter("encounterId");
	String restrict_date_inpatients_yn 		= request.getParameter("restrict_date_inpatients_yn");
	String maximum_days_allowed 			= request.getParameter("maximum_days_allowed");

	String facility_id		= (String)session.getAttribute("facility_id");
	String order_from_date					= request.getParameter("order_from_date");
	String order_to_date					= request.getParameter("order_to_date");

	PreparedStatement pstmt = null;
	ResultSet rs 			= null;
	Connection conn 		= null;
	conn 					= ConnectionManager.getConnection(request);

	if(sStyle==null) sStyle	= "IeStyle.css";
%>

<html locale="true">
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<title>Meal Exclusions</title>
		
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script> <%-- AAKH-CRF-0065 --%>
	<script language="JavaScript" src="../../eDS/js/PopupWindow.js" type="text/javascript"></script>
	<script type="text/javascript" src="../../eDS/js/navbar.js"></script>
	<script type="text/javascript" src="../../eDS/js/simpletreemenu.js"></script>
	<script type="text/javascript" src="../../framework/js/hashtable.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../framework/js/PopupWindow.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eDS/js/DSCommon.js"></script>
	<script type="text/javascript" src="../../eDS/js/PlaceDietOrder.js"></script>
	<script language="Javascript" src="../../eDS/js/json.js"></script>
		
		
		
		<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script type="text/javascript" src="../../eDS/js/PlaceDietOrder.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		
		<script language="Javascript" src="../../eDS/js/json.js"></script>
		<script type="text/javascript" src="../../eDS/js/MealExclusions.js"></script>
		<script language="Javascript" src="../../eDS/js/Moment.js"></script>
		<script language="Javascript" src="../../eDS/js/MomentRange.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eDS/css/jquery-ui.css"/>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" type="text/css" href="../../eDS/js/common/semiDisableDate/jquery.datetimepicker.css"/>
	<link rel="stylesheet" type="text/css" href="../../eDS/js/common/semiDisableDate/jquery-ui-timepicker-addon.css"/>
	<link rel="stylesheet" type="text/css" href="../../eDS/js/common/semiDisableDate/timepicker.css"/>
		
		
		
		
	</head>
	<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form action="">
				<table width="100%" align="center" CELLSPACING="0" cellpadding="0" >
					<tr>
						<td>
							<table width="100%" id="Able" CELLSPACING="0" cellpadding="2" style="visibility:visible;height:300;width:100%;border: 0px outset #9999FF">
								<tr>
									<td noWrap class="label">
										<fmt:message key="Common.fromdate.label" bundle="${common_labels}" />
									</td>
									<td  class='label'>
										<input type="text" name="fromdate" id="fromdate" id="fromdate" maxlength="10" size="10" value="" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);checkValidDates();' onchange="enableSelectBtn();checkValidDates();">
										<%
											if(restrict_date_inpatients_yn.equals("Y")){
										%>
											<img src="../../eCommon/images/CommonCalendar.gif"  name='datepickerimg' id='datepickerimg' onclick="grayOutCalendar('fromdate','<%=maximum_days_allowed%>','<%=locale%>')">
											<img id="fromDateImage" src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>
										<%
											}else{
										%>
											<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('fromdate');">
											<img id="fromDateImage" src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>
										<%
											}
										%>
										<!--img src="../../eCommon/images/CommonCalendar.gif"  name='imagemonth' onClick="return showCalendar('fromdate');">
										<img src='../../eCommon/images/mandatory.gif' /-->
									</td>
									<td noWrap class="label">
										<fmt:message key="Common.todate.label" bundle="${common_labels}" />
									</td>
									<td  class='label'>
										<input type="text" name="todate" id="todate" id="todate" maxlength="10" size="10" value="" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);checkValidDates();' onchange="enableSelectBtn();checkValidDates();">
										<%
											if(restrict_date_inpatients_yn.equals("Y")){
										%>
											<img src="../../eCommon/images/CommonCalendar.gif"  name='datepickerimg' id='datepickerimg'  onclick="grayOutCalendar('todate','<%=maximum_days_allowed%>','<%=locale%>')">
											<img id="todateImage" src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>
										<%
											}else{
										%>
											<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('todate');">
											<img id="todateImage" src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>
										<%
											}
										%>
										<!--img src="../../eCommon/images/CommonCalendar.gif"  name='imagemonth' onClick="return showCalendar('todate');">
										<img src='../../eCommon/images/mandatory.gif' /-->
									</td>
								</tr>
							</table>

							<table width="95%" align="left" CELLSPACING="0" cellpadding="0" >
								<tr>
									<td>
										<fieldset style="margin-left:5;margin-right:5;margin-top:5;margin-bottom:5;">
							    			<legend>Meal Types</legend>
										    <table id="checkboxcontainer" border="0" width="98%" cellspacing="0" cellpadding="0" style="margin-left:5;margin-right:5;margin-top:5;margin-bottom:5;">
										    	<tbody>
												</tbody>
									        </table>
							    		</fieldset>
					    			</td>
					    		</tr>

								<tr>
									<td colspan="4" align="right">
										<input type="button" name="" id="" id="btnSelect" value="<fmt:message key="Common.Select.label" bundle="${common_labels}" />" onClick="addExclusions();enableOkBtn();" class="Button">
									</td>
								</tr>
					    	</table>
						</td>
					</tr>
				</table>

				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr style="background-color:white;">
					<br />
						<td colspan="4">
							<br />
							<div id="listContentLayer" style="visibility:visible;overflow-y: scroll;height:65vh;width:98vw;border: 1px outset #9999FF;" align="center">

								<table border='1' cellpadding='2' cellspacing='0' width='100%' align='center' id="excludedMealTypesTable">
									<tbody></tbody>
								</table>
							</div>
						</td>
					</tr>
					</table>
					<div style="position: absolute;bottom: 40;">
					<table width="75%">
						<tr>
							<td align='left' width='1%'><img src="../../eDS/css/stop.png"></img></td>
							<td align='left' width='13%' colspan='3' class='label'>Meal Excluded Cannot be Revoked</td>
							<td align='left' width='1%'><img src="../../eDS/css/exclusions.png"></img></td>
							<td align='left' width='13%' colspan='3' class='label'>Meal Excluded Can be Revoked</td>
						</tr>
					</table>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td colspan="4" align="right">
							<input type="button" name="" id="" id="ok" value="<fmt:message key="Common.ok.label" bundle="${common_labels}" />" onClick="moveExclusions()" class="Button" disabled>
							<input type="button" name="" id="" id="close" value="<fmt:message key="Common.close.label" bundle="${common_labels}" />" onClick="cancelExclusions()" class="Button">
						</td>
					</tr>
				</table>
				</div>
				

				<input type="hidden" name="patientId" id="patientId" />
				<input type="hidden" name="encounterId" id="encounterId" value="<%=encounterId%>"/>
				<input type="hidden" name="profileSL" id="profileSL" value="<%=profileSL%>" />
				<input type="hidden" name="addedFacilityId" id="addedFacilityId" value="<%=facility_id%>"/>
				<input type="hidden" name="addedById" id="addedById" value="<%=strloggeduser%>" />
				<input type="hidden" name="workStationNo" id="workStationNo" value="<%=strclientip%>" />
				<input type="hidden" name="mealTypes" id="mealTypes"  id="mealTypes" value="<%=fetchedMealTypesWithTime%>"/>
				<input type="hidden" name="order_from_date" id="order_from_date"  id="order_from_date" value="<%=order_from_date%>"/>
				<input type="hidden" name="order_to_date" id="order_to_date"  id="order_to_date" value="<%=order_to_date%>"/>

				<input type="hidden" name="locale" id="locale" id="locale" value="<%=locale%>" />
		</form>
		
	</body>
</html>

