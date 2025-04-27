<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
28-JAN-2019      100           	Aravindh.H          Created
---------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.Common.*,eBL.*,com.ehis.util.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
			? (String) session.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
	String locale = (String) session.getAttribute("LOCALE");
	String facilityId = (String) session.getAttribute("facility_id");
	if (facilityId == null)
		facilityId = "";
	String strLoggedUser = (String) session.getValue("login_user");
	Properties p = (Properties) session.getValue( "jdbc" ) ;
	String clientIpAddress	= p.getProperty("client_ip_address");
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String sql = "", currDate = "", prevDate = "";
	int pat_id_len = 0;
	
	try {
		if (strLoggedUser == null) strLoggedUser = "";
	
		con = ConnectionManager.getConnection(request);
		try {
			sql = "select patient_id_length from mp_param";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
	
			if (rs != null && rs.next()) {
				pat_id_len = rs.getInt("patient_id_length");
			}
		} catch (Exception e) {
			pat_id_len = 15;//Setting Default Value if exception occured
			out.println(e.toString());
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		HashMap data = eCommon.Common.CommonBean.getSiteSpecificDetails(con, "BL","BL_GEN_RCPT_DATE_CTL");
		
		String dateDiff = nulltoStr((String) data.get("value1"));
		if("".equals(dateDiff)) {
			dateDiff = "30";
		}
		
		sql = "select to_char(sysdate,'dd/MM/yyyy') curr_date, to_char(sysdate-"+dateDiff+",'dd/MM/yyyy') prev_date from dual";
		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		if (rs != null && rs.next()) {
			currDate = rs.getString("curr_date");
			prevDate = rs.getString("prev_date");
		}
		
		rs.close();
		pstmt.close();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eBL/js/BLGenRcptForVendorsScript.js'></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#receiptStatus').val('N');
		});
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onKeyDown="lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
	<form name="genRcptForVendorsSrchFrm" id="genRcptForVendorsSrchFrm" id="genRcptForVendorsSrchFrm">
		<table width="100%" align="center" cellpadding=6 cellspacing=0>
			<tr>
				<td width="25%" nowrap class='label' style="text-align: left;">
					<fmt:message key="eBL.VendorType.label" bundle="${bl_labels}" />
				</td>
				<td width="25%" nowrap class='fields' style="text-align: left;">
					<select name='vendorType' id='vendorType' id='eBL.VendorType.label'  style="width:150px;">
						<option value='PRACTO'><fmt:message key="eBL.PRACTO.label" bundle="${bl_labels}" /></option>
					</select>
				</td>
				
				<td width="25%" colspan="2" nowrap class='label' style="text-align: left;">&nbsp;</td>
			</tr>
			<tr>
				<td width="25%" nowrap class='label' style="text-align: left;">
					<fmt:message key="Common.patientId.label" bundle="${bl_labels}" />
				</td>
				<td width="25%" nowrap class='fields' style="text-align: left;">
					<input type='text' name='patID' id='patID' id='patID' value=''
					maxlength='<%=pat_id_len%>' size='25'
					onBlur="if(this.value != '') {ChangeUpperCase(this);callPatValidation(this, 'search');} else {patientIdLookup(this, 'search');}">&nbsp;
					<input type='button' class='button' value='?' name='patIDSrch' id='patIDSrch'
					id='patIDSrch' onClick="patientIdLookup(patID, 'search')" tabIndex='2' />
				</td>
				<td width="25%" nowrap class='label' style="text-align: left;">
					<fmt:message key="Common.PatientName.label" bundle="${bl_labels}" />
				</td>
				<td width="25%" nowrap class='label' style="text-align: left;">
					<input type='text' name='patName' id='patName' id='patName' value='' size='25' />
				</td>
			</tr>
			
			<tr>
				<td width="25%" nowrap class='label' style="text-align: left;">
					<fmt:message key="eBL.PractoRcptDateFrom.label" bundle="${bl_labels}" />
				</td>
				<td width="25%" nowrap class='fields' style="text-align: left;">
					<input type='text' name='practoDateFrom' id='practoDateFrom' id='practoDateFrom' value='<%=prevDate %>'
					maxlength='10' size='10' onblur='validateFromDate();'>
					<img src="../../eCommon/images/CommonCalendar.gif" 
					onClick="return showCalendar('practoDateFrom');" onKeyPress="return lockbackSpace();" tabIndex='2' />
					<img src='../../eCommon/images/mandatory.gif' />
				</td>
				<td width="25%" nowrap class='label' style="text-align: left;">
					<fmt:message key="eBL.PractoRcptDateTo.label" bundle="${bl_labels}" />
				</td>
				<td width="25%" nowrap class='label' style="text-align: left;">
					<input type='text' name='practoDateTo' id='practoDateTo' id='practoDateTo' value='<%=currDate %>'
					maxlength='10' size='10' onblur='validateToDate();'>
					<img src="../../eCommon/images/CommonCalendar.gif" 
					onClick="return showCalendar('practoDateTo');" onKeyPress="return lockbackSpace();" tabIndex='2' />
					<img src='../../eCommon/images/mandatory.gif' />
				</td>
			</tr>
			<tr>
				<td width="25%" nowrap class='label' style="text-align: left;">
					<fmt:message key="eBL.ReceiptsStatus.label" bundle="${bl_labels}" />
				</td>
				<td width="25%" nowrap class='fields' style="text-align: left;">
					<select name='receiptStatus' id='receiptStatus' id='receiptStatus' style="width:150px;">
						<option value='A'><fmt:message key="eBL.ALL.label" bundle="${bl_labels}" /></option>
						<option value='N'><fmt:message key="Common.New.label" bundle="${bl_labels}" /></option>
						<option value='G'><fmt:message key="eBL.Generated.label" bundle="${bl_labels}" /></option>
						<option value='E'><fmt:message key="eBL.InError.label" bundle="${bl_labels}" /></option>
					</select>
				</td>
				
				<td width="25%" colspan="2" nowrap class='label' style="text-align: left;">&nbsp;</td>
			</tr>
			<tr>
				<td width="25%" colspan="3" nowrap class='label' style="text-align: left;">&nbsp;</td>
				<td width="25%" nowrap>
					<input type='button' name='rcptSearch' id='rcptSearch' id='rcptSearch' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.search.label", "common_labels")%>' 
					onclick="return searchReceipts();" />
				</td>
			</tr>
		</table>
		<input type="hidden" name="facilityId" id="facilityId" 			id="facilityId"			value="<%=facilityId%>" />
		<input type="hidden" name="locale" id="locale" 				id="locale" 			value="<%=locale%>" />
		<input type="hidden" name="todaysDate" id="todaysDate"			id="todaysDate"			value="<%=currDate%>" />
		<input type="hidden" name="strLoggedUser" id="strLoggedUser"		id="strLoggedUser"		value="<%=strLoggedUser%>" />
		<input type="hidden" name="pat_id_len" id="pat_id_len"			id="pat_id_len"			value="<%=pat_id_len%>" />
		<input type="hidden" name="clientIpAddress" id="clientIpAddress"		id="clientIpAddress"	value="<%=clientIpAddress%>" />
	</form>
</body>
<%
	} catch(Exception e) {
		System.err.println("Error in BLGenRcptForVendorsSearch.jsp: "+e);
		e.printStackTrace();
	} finally {
		if(con != null) {
			ConnectionManager.returnConnection(con, request);
		} if(pstmt != null) {
			pstmt.close();
		} if(rs != null) {
			rs.close();
		}
	}
%>

<%!
private String nulltoStr(String inputString) {
	if (inputString == null) {
		return "";
	} else {
		return inputString;
	}
}
%>
</html>

