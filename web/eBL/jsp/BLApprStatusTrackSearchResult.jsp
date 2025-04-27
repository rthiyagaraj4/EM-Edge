<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eBL.Common.*,eBL.*,eCommon.Common.*,java.net.*,webbeans.op.CurrencyFormat,java.io.*,com.ehis.util.*,java.util.*, java.sql.Date" contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.math.*,java.text.*,org.apache.commons.codec.binary.Base64"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<link rel="stylesheet" type="text/css"	href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script language='javascript' src='../../eBL/js/BLApprStatusTrackSearch.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<style type="text/css">
span.a
{
	background: #ffffff;
	border: solid 1px #CCCCCC;
	height: 150px;
	display:inline-block;
    margin:10px 0;
    border-radius:5px;
	cursor: pointer;
}
.box_title2
{
	width: 220px;
	height: 35px;
    font-size: 12px;
    font-weight: normal;
    padding-left: 10px;
    padding-top: 10px;
    padding-bottom: 10px;
    padding-right: 10px;
    color: #ffffff;
    <%if(sStyle.equals("IeStyle.css")){%>
    background-color: #83AAB4;
    <%}
    else if(sStyle.equals("IeStyleLime.css")){%>
    background-color: #A3BF8A;
    <%}
    else if(sStyle.equals("IeStyleOrange.css")){%>
    background-color: #DDC68E;
    <%}
    else if(sStyle.equals("IeStyleBlue.css")){%>
    background-color: #B2B6D7;
    <%}
    else if(sStyle.equals("IeStyleVoilet.css")){%>
    background-color: #D696D0;
    <%}%>
    line-height: 10px;
    font-family: verdana;
	text-align: center;
	white-space: nowrap;
	
}
.box_text
{
	padding-left: 10px;
    padding-top: 10px;
    padding-bottom: 10px;
    padding-right: 10px;
	font-family: verdana;
	text-align: center;
	vertical-align: middle;

}
.txt
{
	font-family: verdana;
	font-size: 30pt;
	font-weight: bold;
}
.text
{
	padding-left: 10px;
    padding-top: 10px;
    padding-bottom: 10px;
    padding-right: 10px;
	font-family: verdana;
	text-align: center;
	vertical-align: middle;

}
</style>
</head>

<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null; 
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	PreparedStatement pstmt		= null ;
	ResultSet rs				= null;	
	int penCoder = 0;
	int penIns = 0;
	int penDisc = 0;
	int penDiscBill = 0;
	try{
	con	=	ConnectionManager.getConnection(request);
	String facility_id = (String) session.getValue("facility_id");
	String userId = (String) session.getAttribute("login_user");
	DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
	DateFormat dateFormat1 = new SimpleDateFormat("hhmmss");
	Calendar cal = Calendar.getInstance();
	String tDate=dateFormat.format(cal.getTime());
	String tTime=dateFormat1.format(cal.getTime());
	String usr = userId+tDate+tTime;
	String strclientip ="";
    strclientip=p.getProperty("client_ip_address");
	String rightsType = checkForNull(request.getParameter("rightsType"));
	String encounterFromDate = checkForNull(request.getParameter("encounterFromDate"));
	String encounterToDate = checkForNull(request.getParameter("encounterToDate"));
	String encId = checkForNull(request.getParameter("encounterId"));
	double encounterId;
	if(encId.equals("")){ encounterId = 0; }
	else{encounterId=Double.parseDouble(encId);  }
	int visitId = 0;
	String patientId = checkForNull(request.getParameter("patientId"));
	String episodeType = checkForNull(request.getParameter("episodeType"));
	String payerGroup = checkForNull(request.getParameter("payerGroup"));
	String payer = checkForNull(request.getParameter("payer"));
	String policy = checkForNull(request.getParameter("policy"));
	
	String frontOfficeQuery="{ call BL_INSU_DASHBOARD.bl_proc_fdesk_data_tmp(?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?)}";
	
			CallableStatement callFrontOffice= con.prepareCall(frontOfficeQuery);
			callFrontOffice.setString(1,usr);
			callFrontOffice.setString(2,strclientip);
			callFrontOffice.setString(3,facility_id);
			callFrontOffice.setString(4,patientId);
			callFrontOffice.setString(5,episodeType);
			if(encounterId != 0 )
			{
			callFrontOffice.setDouble(6,encounterId);
			}
			else
			{
			callFrontOffice.setString(6,null);
			}
			if(visitId != 0 )
			{
			callFrontOffice.setInt(7,visitId);
			}
			else
			{
			callFrontOffice.setString(7,null);
			}
			callFrontOffice.setString(8,payerGroup);
			callFrontOffice.setString(9,payer);
			callFrontOffice.setString(10,policy);
			callFrontOffice.setString(11,encounterFromDate);
			callFrontOffice.setString(12,encounterToDate);
			callFrontOffice.registerOutParameter(13,java.sql.Types.INTEGER);
			callFrontOffice.registerOutParameter(14,java.sql.Types.INTEGER);
			callFrontOffice.registerOutParameter(15,java.sql.Types.INTEGER);
			callFrontOffice.registerOutParameter(16,java.sql.Types.INTEGER);
			callFrontOffice.execute();
			penCoder=callFrontOffice.getInt(13);
			penIns=callFrontOffice.getInt(14);
			penDiscBill=callFrontOffice.getInt(15);
			penDisc=callFrontOffice.getInt(16);
			con.commit();
%>
<BODY onKeyDown="lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" >
<form name='searchresult' id='searchresult' id='searchresult' method='post'>
<table width="100%">
<tr>
<td class="COLUMNHEADER"><fmt:message key="eBL.PatDiscAdv.label" bundle="${bl_labels}"/></td>
</tr>
</table>  
<div>
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span class="a" id ="pendCoder" value = "CC" onclick="onClickTile(this);return false">
					<div class="box_title2" ><fmt:message key="eBL.PendCoder.label" bundle="${bl_labels}"/></div>
					<div class="box_text txt"><%=penCoder%></div>
					<div class="text"><fmt:message key="eBL.ClickDetails.label" bundle="${bl_labels}"/></div>
				</span>
			</label>
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span class="a" id ="pendIns" value = "IC" onclick="onClickTile(this);return false">
					<div class="box_title2" ><fmt:message key="eBL.PendIns.label" bundle="${bl_labels}"/></div>
					<div class="box_text txt"><%=penIns%></div>
					<div class="text"><fmt:message key="eBL.ClickDetails.label" bundle="${bl_labels}"/></div>
				</span>
			</label>
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span class="a" id ="pendDiscBill" value = "DB" onclick="onClickTile(this);return false">
					<div class="box_title2" ><fmt:message key="eBL.PendDiscBill.label" bundle="${bl_labels}"/></div>
					<div class="box_text txt"><%=penDiscBill%></div>
					<div class="text"><fmt:message key="eBL.ClickDetails.label" bundle="${bl_labels}"/></div>
				</span>
			</label>
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span class="a" id ="pendClear" value = "DC" onclick="onClickTile(this);return false">
					<div class="box_title2" ><fmt:message key="eBL.PendDiscClear.label" bundle="${bl_labels}"/></div>
					<div class="box_text txt"><%=penDisc%></div>
					<div class="text"><fmt:message key="eBL.ClickDetails.label" bundle="${bl_labels}"/></div>
				</span>   
			</label>
</div>

		<input type='hidden' name='facility_id' id='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name='user' id='user' id='user' value='<%=usr%>'>
		<input type='hidden' name='strclientip' id='strclientip' id='strclientip' value='<%=strclientip%>'>
		<input type='hidden' name='penCoder' id='penCoder' id='penCoder' value='<%=penCoder%>'>
		<input type='hidden' name='penIns' id='penIns' id='penIns' value='<%=penIns%>'>
		<input type='hidden' name='penDiscBill' id='penDiscBill' id='penDiscBill' value='<%=penDiscBill%>'>
		<input type='hidden' name='penDisc' id='penDisc' id='penDisc' value='<%=penDisc%>'>
		<input type='hidden' name = "popup_opened_yn"  id = "popup_opened_yn" value="N">
<%} catch(Exception e) {
		out.println(e.toString());
		e.printStackTrace();
		con.rollback();
	}
	finally 
	{
	}%>
</form>
</body>
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

