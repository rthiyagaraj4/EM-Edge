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
	String[] cusCode = null;
	String[] cusName = null;
	BigDecimal[] cusCount = null;
	Array tempArray = null;
	int rowCount = 0;
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
	String apprvSts_AAKHYN = checkForNull(request.getParameter("apprvSts_AAKHYN"));//V230425 
	String loadSts = checkForNull(request.getParameter("loadSts"));//44856
	String rightsType = checkForNull(request.getParameter("rightsType"));
	String encounterFromDate = checkForNull(request.getParameter("encounterFromDate"));
	String encounterToDate = checkForNull(request.getParameter("encounterToDate"));
	String encId = checkForNull(request.getParameter("encounterId"));
	String PreAuthEclaimYN = checkForNull(request.getParameter("PreAuthEclaimYN"));//V230822
	
	String visit_Id = "";
	int visitId;
	System.err.println("encId=> "+encId);
	if(!encId.equals("")){
	visit_Id=encId.substring(8,12);
	encId = encId.substring(0,8);
	
	}
	double encounterId;	
	if(encId.equals("")){ encounterId = 0; }
	else{
		encounterId=Double.parseDouble(encId);  
	}
	if(visit_Id.equals(""))
	{	visitId=0;
	}else{
		visitId=Integer.parseInt(visit_Id); 
	}	
	
	String patientId = checkForNull(request.getParameter("patientId"));
	String episodeType = checkForNull(request.getParameter("episodeType"));
	String payerGroup = checkForNull(request.getParameter("payerGroup"));
	String payer = checkForNull(request.getParameter("payer"));
	String policy = checkForNull(request.getParameter("policy"));
	if(episodeType.equals("A"))
	{
		episodeType = "**";
	}


			String insuranceQuery="{ call BL_INSU_DASHBOARD.bl_proc_ins_dash_data_tmp(?,?,?,?,?,?,ltrim(?,'0'),?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?)}";
	
			CallableStatement callInsurance= con.prepareCall(insuranceQuery);
			callInsurance.setString(1,usr);
			callInsurance.setString(2,strclientip);
			callInsurance.setString(3,facility_id);
			if(patientId != "" )
			{
			callInsurance.setString(4,patientId);
			}
			else
			{
			callInsurance.setString(4,null);
			}
			callInsurance.setString(5,episodeType);
			if(encounterId != 0 )
			{
			callInsurance.setDouble(6,encounterId);
			}
			else
			{
			callInsurance.setString(6,null);
			}
			if(visitId != 0 )
			{
				callInsurance.setInt(7,visitId);
			}
			else
			{
			callInsurance.setString(7,null);
			}
			if(payerGroup != "" )
			{
			callInsurance.setString(8,payerGroup);
			}
			else
			{
			callInsurance.setString(8,null);
			}
			if(payer != "" )
			{
			callInsurance.setString(9,payer);
			}
			else
			{
			callInsurance.setString(9,null);
			}
			if(policy != "" )
			{
			callInsurance.setString(10,policy);
			}
			else
			{
			callInsurance.setString(10,null);
			}
			callInsurance.setString(11,encounterFromDate);
			callInsurance.setString(12,encounterToDate);
			callInsurance.registerOutParameter(13,Types.ARRAY,"BL_CMN_TYPE_VARCHAR100");
			callInsurance.registerOutParameter(14,Types.ARRAY,"BL_CMN_TYPE_VARCHAR100");
			callInsurance.registerOutParameter(15,Types.ARRAY,"BL_CMN_TYPE_NUMBER");
			callInsurance.execute();
			tempArray = callInsurance.getArray(13);
			if(tempArray != null){
			try{
					cusCode = (String[]) tempArray.getArray();
			}
			catch(Exception e){
			cusCode = new String[1];
			e.printStackTrace();
			}
			}
			else{
			cusCode = new String[1];
			}
	
			tempArray = callInsurance.getArray(14);
			if(tempArray != null){
		
			try{
					cusName = (String[]) tempArray.getArray();
			}
			catch(Exception e){
			cusName = new String[1];
			e.printStackTrace();
			}
			}
			else{
			cusName = new String[1];
			}
	
			tempArray = callInsurance.getArray(15);
			if(tempArray != null){
			try{
					cusCount = (BigDecimal[]) tempArray.getArray();
			}
			catch(Exception e){
			cusCount = new BigDecimal[1];
			e.printStackTrace();
			}
			}
			else{
			cusCount = new BigDecimal[1];
			}
			con.commit();
if(loadSts.equals("Y") && (apprvSts_AAKHYN.equals("Y") || PreAuthEclaimYN.equals("Y"))){ //44856
	String customerCode = checkForNull(request.getParameter("customerCode"));
	String custName = checkForNull(request.getParameter("cusName"));
	
%>
<BODY onKeyDown="lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" onload="onClickPayer('<%=custName%>','<%=customerCode%>')">
<%}else{
%>
<BODY onKeyDown="lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" >
<%} %>
<form name='searchresult' id='searchresult' id='searchresult' method='post'>
<table width="100%">
<tr>
<td class="COLUMNHEADER"><%if(PreAuthEclaimYN.equals("Y")){ %>
<fmt:message key="eBL.ApprStatusPayerEncLvl.label" bundle="${bl_labels}"/>
<%}else{ %>
<fmt:message key="eBL.ApprStatusPayer.label" bundle="${bl_labels}"/>
<%} %></td>
</tr>
</table>  
<div>
		<%
		for(int k = 0; k < cusCount.length; k++) {
			rowCount++;
%>
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span class="a" id ="payer" onclick="onClickPayer('<%=cusName[k]%>','<%=cusCode[k]%>');return false">
					<div class="box_title2" ><%=cusName[k]%></div>
					<div class="box_text txt"><%=cusCount[k]%></div>
					<div class="text"><fmt:message key="eBL.ClickDetails.label" bundle="${bl_labels}"/></div>
				</span>
			</label>  
		<%}%>             
</div>

<%					
		
		if(rowCount == 0){
%>	
<Script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));</script>
<%
		}
%>
<script type="text/javascript">
	parent.frames[0].search.document.getElementById('search_button').disabled=false; //49172
	parent.frames[0].search.document.getElementById('processMsg').style.visibility="hidden";
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		<input type='hidden' name='facility_id' id='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name='user' id='user' id='user' value='<%=usr%>'>
		<input type='hidden' name='strclientip' id='strclientip' id='strclientip' value='<%=strclientip%>'>
		<input type='hidden' name='cusCount' id='cusCount' id='cusCount' value='<%=cusCount%>'>
		<input type='hidden' name='cusName' id='cusName' id='cusName' value='<%=cusName%>'>
		<!-- 
		<input type='hidden' name='selCust' id='selCust' id='selCust' value=''>
		<input type='hidden' name='selCusCode' id='selCusCode' id='selCusCode' value=''>
		 -->
		<input type='hidden' name='click_count' id='click_count' id='click_count' value='0'><!-- new -->
		
		<input type='hidden' name='encounterFromDate' id='encounterFromDate' id='encounterFromDate' value='<%=encounterFromDate%>'>
		<input type='hidden' name='encounterToDate' id='encounterToDate' id='encounterToDate' value='<%=encounterToDate%>'>
		<input type='hidden' name='episodeType' id='episodeType' id='episodeType' value='<%=episodeType%>'>
		<input type='hidden' name = "popup_opened_yn"  id = "popup_opened_yn" value="N">
		<input type='hidden' name = "apprvSts_AAKHYN"  id = "apprvSts_AAKHYN" value="<%=apprvSts_AAKHYN%>"><!--V230425-->
		<input type='hidden' name = "PreAuthEclaimYN"  id = "PreAuthEclaimYN" value="<%=PreAuthEclaimYN%>"><!-- V230822 -->
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

