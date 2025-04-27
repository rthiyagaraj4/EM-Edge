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
	String[] insStatus = null;
	BigDecimal[] insCount = null;
	Array tempArray = null;
	try{
	con	=	ConnectionManager.getConnection(request);
	String user = checkForNull(request.getParameter("user"));
	String strclientip = checkForNull(request.getParameter("strclientip"));
	String cusName = checkForNull(request.getParameter("cusName"));
	String customerCode = checkForNull(request.getParameter("cusCode"));
	String encounterFromDate = checkForNull(request.getParameter("encounterFromDate"));
	String encounterToDate = checkForNull(request.getParameter("encounterToDate"));
	String episodeType = checkForNull(request.getParameter("episodeType"));
	String apprvSts_AAKHYN = checkForNull(request.getParameter("apprvSts_AAKHYN"));//V230425
	String PreAuthEclaimYN = checkForNull(request.getParameter("PreAuthEclaimYN"));//V230822
	
	String insuranceQuery="{ call BL_INSU_DASHBOARD.bl_proc_ins_serv_data_tmp (?,?,?,?,?)}";
	System.err.println("user "+user);
	System.err.println("strclientip "+strclientip);
	System.err.println("cusName "+cusName);
	System.err.println("PreAuthEclaimYN "+PreAuthEclaimYN);
	System.err.println("customerCode "+customerCode);
	
			CallableStatement callPayerStatus= con.prepareCall(insuranceQuery);
			callPayerStatus.setString(1,user);
			callPayerStatus.setString(2,strclientip);
			callPayerStatus.setString(3,customerCode);
			callPayerStatus.registerOutParameter(4,Types.ARRAY,"BL_CMN_TYPE_VARCHAR1");
			callPayerStatus.registerOutParameter(5,Types.ARRAY,"BL_CMN_TYPE_NUMBER");
			callPayerStatus.execute();
			tempArray = callPayerStatus.getArray(4);
			if(tempArray != null){
			try{
					insStatus = (String[]) tempArray.getArray();
			}
			catch(Exception e){
			insStatus = new String[1];
			e.printStackTrace();
			}
			}
			else{
			insStatus = new String[1];
			}
	
			tempArray = callPayerStatus.getArray(5);
			if(tempArray != null){
			try{
					insCount = (BigDecimal[]) tempArray.getArray();
			}
			catch(Exception e){
			insCount = new BigDecimal[1];
			e.printStackTrace();
			}
			}
			else{
			insCount = new BigDecimal[1];
			}
			con.commit();
%>
<BODY onKeyDown="lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" >
<form name='searchresult' id='searchresult' id='searchresult' method='post'>
<table width="100%">
<tr>
<td class="COLUMNHEADER">
<%if(PreAuthEclaimYN.equals("Y")){ %>
Approval Status by <%=cusName%> at Service Level
<%}else{ %>
Approval Status by <%=cusName%>
<%} %>
</td>
</tr>
</table>  
<div>
		<%
		String val = "";
		for(int k = 0; k < insCount.length; k++) {
		if(insStatus[k].equals("A"))
			val = "Approved";
		else if(insStatus[k].equals("P"))
			val = "Pending";
		else if(insStatus[k].equals("H"))
			val = "Hold";
		else if(insStatus[k].equals("R"))
			val = "Rejected";
		else if(insStatus[k].equals("S"))
			val = "Send to Insurance";
		else if(insStatus[k].equals("C"))
			val = "Clarification";
			
%>
			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<span class="a" id ="payer" onclick="onClickStatus('<%=val%>');return false">
					<div class="box_title2" ><%=val%></div>
					<div class="box_text txt"><%=insCount[k]%></div>
					<div class="text"><fmt:message key="eBL.ClickDetails.label" bundle="${bl_labels}"/></div>
				</span>
			</label>  
		<%}
		out.println("<script>parent.frames[1].searchresult.document.getElementById('click_count').value='0';</script>");
		%>             
	</div>
		<input type='hidden' name='user' id='user' id='user' value='<%=user%>'>
		<input type='hidden' name='strclientip' id='strclientip' id='strclientip' value='<%=strclientip%>'>
		<input type='hidden' name='customerCode' id='customerCode' id='customerCode' value='<%=customerCode%>'> 
		<input type='hidden' name='cusName' id='cusName' id='cusName' value='<%=cusName%>'>
		<!-- <input type='hidden' name='selStsCode' id='selStsCode' id='selStsCode' value=''> 
		<input type='hidden' name='stsCusName' id='stsCusName' id='stsCusName' value=''> 
		 -->
		<input type='hidden' name='clickCnt' id='clickCnt' id='clickCnt' value='0'> 
		<input type='hidden' name='encounterFromDate' id='encounterFromDate' id='encounterFromDate' value='<%=encounterFromDate%>'>
		<input type='hidden' name='encounterToDate' id='encounterToDate' id='encounterToDate' value='<%=encounterToDate%>'>
		<input type='hidden' name='episodeType' id='episodeType' id='episodeType' value='<%=episodeType%>'>
		<input type='hidden' name='apprvSts_AAKHYN' id='apprvSts_AAKHYN' id='apprvSts_AAKHYN' value='<%=apprvSts_AAKHYN%>'><!--V230425-->
		<input type='hidden' name='PreAuthEclaimYN' id='PreAuthEclaimYN' id='PreAuthEclaimYN' value='<%=PreAuthEclaimYN%>'><!--V230822-->

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

