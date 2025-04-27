<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
29-JAN-2019      100           	Aravindh.H          Created
---------------------------------------------------------------------------------------------------------------
-->
<%/*
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------
1			 V211020												Mohanapriya K
 */ %>
 
<%-- JSP Page specific attributes start --%>
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.Common.*,eBL.*,com.ehis.util.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%!
private String nulltoStr(String inputString) {
	if (inputString == null) {
		return "";
	} else {
		return inputString;
	}
}
%>


<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
			? (String) session.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			
	String facilityId = nulltoStr(request.getParameter("facilityId"));
	String locale = nulltoStr(request.getParameter("locale"));
	String strLoggedUser = nulltoStr(request.getParameter("strLoggedUser"));
	String clientIpAddress = nulltoStr(request.getParameter("clientIpAddress"));
	String vendorType = nulltoStr(request.getParameter("vendorType"));
	String patientId = nulltoStr(request.getParameter("patientId"));
	String patientName = nulltoStr(request.getParameter("patientName"));
	String practoDateFrom = nulltoStr(request.getParameter("practoDateFrom"));
	String practoDateTo = nulltoStr(request.getParameter("practoDateTo"));
	String receiptStatus = nulltoStr(request.getParameter("receiptStatus"));
	String patIdLength = nulltoStr(request.getParameter("patIdLength"));
	String mode	= nulltoStr(request.getParameter("mode"));
	
	String practoCashCounterCode = "", practoUser = "", practoSlmtType = "";
	
	//For Traversal Starts
	String nextYn = "N", prevYn = "N", traversal = "N", fromRcrd = "", toRcrd = "";
	int startIndex = 0, startRcrd = 0, endRcrd = 0, totalRecord=0, constCount = 20;
	
	fromRcrd = nulltoStr(request.getParameter("fromRcrd"));
	toRcrd = nulltoStr(request.getParameter("toRcrd"));
	
	if(fromRcrd == null || "".equals(fromRcrd)){
		startRcrd = 1;
	} else{
		startRcrd = Integer.parseInt(fromRcrd);
	}
		
	if(toRcrd == null || "".equals(toRcrd)){
		endRcrd = constCount;
	} else{
		endRcrd = Integer.parseInt(toRcrd);
	}
	startIndex = startRcrd;
	//For Traversal Ends
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String sql = "", currDate = "", prevDate = "";
	int pat_id_len = 0;
	
	try {
		if (strLoggedUser == null) strLoggedUser = "";
		if("".equals(patIdLength)) {
			patIdLength = "15";
		}
		pat_id_len = Integer.parseInt(patIdLength);
		
		con = ConnectionManager.getConnection(request);
		sql = "SELECT def_practo_cash_ctr_code, def_practo_user, def_practo_slmt_type FROM bl_parameters WHERE operating_facility_id = '"+facilityId+"'";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			practoCashCounterCode = rs.getString("def_practo_cash_ctr_code");
			practoUser = rs.getString("def_practo_user");
			practoSlmtType = rs.getString("def_practo_slmt_type");
		}
	
		System.out.println("facilityId:" + facilityId + " strLoggedUser:" + strLoggedUser);
		
		String bean_id			= "bl_BLGenRcptForVendorsBean" ;
		String bean_name		= "eBL.BLGenRcptForVendorsBean";
		String modifyStatus     = "";
		BLGenRcptForVendorsBean bean			= (BLGenRcptForVendorsBean)getBeanObject( bean_id, bean_name, request ) ;
		
		if("search".equals(mode)) {
			bean.setDBValues(mode, facilityId, vendorType, patientId, patientName, practoDateFrom, practoDateTo, receiptStatus);
		}
		//con = ConnectionManager.getConnection(request); //V211020
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
			if($('#traverse').val() == 'Y'){
				$('#trProgress').show();
			}else{
				$('#trProgress').hide();
			}
			
			if($('#hdnNextSpan').val() == 'Y'){
				$('#nextSpan').show();
			}else{
				$('#nextSpan').hide();
			}
				
			if($('#prevSpan').val() == 'Y'){
				$('#previousSpan').show();	
			}else{
				$('#previousSpan').hide();
			}
				
			$('#nextSpan').click(function(){
				var startFrom = parseInt($('#fromRcrd').val())+parseInt($('#constCount').val());
				var endWith = parseInt($('#toRcrd').val())+parseInt($('#constCount').val());
				var rsltFormObj = document.genRcptForVendorsRsltFrm;
				var xmlString = formXMLStringMain(rsltFormObj);
				var updation = formValidation(xmlString, "MODIFY");
				
				document.location.href = "../../eBL/jsp/BLGenRcptForVendorsResult.jsp?"
					+ "facilityId="+$('#facilityId').val()+"&locale="+$('#locale').val()+"&strLoggedUser="+$('#locale').val()+"&vendorType="+$('#vendorType').val()
					+ "&patientId="+$('#patientId').val()+"&patientName="+$('#patientName').val()+"&practoDateFrom="+$('#practoDateFrom').val()+"&practoDateTo="+$('#practoDateTo').val()
					+ "&receiptStatus="+$('#receiptStatus').val()+"&mode=MODIFY&pat_id_len="+$('#pat_id_len').val()+"&clientIpAddress="+$('#clientIpAddress').val()
					+ "&fromRcrd="+startFrom+"&toRcrd="+endWith;
			});
			
			$('#previousSpan').click(function(){
				var startFrom = parseInt($('#fromRcrd').val())-parseInt($('#constCount').val());
				var endWith = "";
				if($('#toRcrd').val() == $('#totalRecord').val()) {
					endWith = parseInt($('#toRcrd').val())-parseInt($('#totalRecord').val()%$('#constCount').val());
				} else {
					endWith = parseInt($('#toRcrd').val())-parseInt($('#constCount').val());
				}
				
				var rsltFormObj = document.genRcptForVendorsRsltFrm;
				var xmlString = formXMLStringMain(rsltFormObj);
				var updation = formValidation(xmlString, "MODIFY");
				
				document.location.href = "../../eBL/jsp/BLGenRcptForVendorsResult.jsp?"
					+ "facilityId="+$('#facilityId').val()+"&locale="+$('#locale').val()+"&strLoggedUser="+$('#locale').val()+"&vendorType="+$('#vendorType').val()
					+ "&patientId="+$('#patientId').val()+"&patientName="+$('#patientName').val()+"&practoDateFrom="+$('#practoDateFrom').val()+"&practoDateTo="+$('#practoDateTo').val()
					+ "&receiptStatus="+$('#receiptStatus').val()+"&mode=MODIFY&pat_id_len="+$('#pat_id_len').val()+"&clientIpAddress="+$('#clientIpAddress').val()
					+ "&fromRcrd="+startFrom+"&toRcrd="+endWith;
			});
		});
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onKeyDown="lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
	<form name="genRcptForVendorsRsltFrm" id="genRcptForVendorsRsltFrm" id="genRcptForVendorsRsltFrm">
		<table width="100%" align="center" cellpadding=0 cellspacing=0  width="100%" border="0" >
			<thead>
				<tr height=25px; style="background-color: white; border: none;" id='trProgress'>
					<th width=10% nowrap>Patient Data</th>
					<th width=90% nowrap align=right>
						<span class="LABEL" style="color: blue; cursor: pointer;cursor:pointer; ">
							<span id='previousSpan'>&lt;&lt;<fmt:message key="Common.previous.label" bundle="${common_labels}"/></span>
						</span>&nbsp;&nbsp;&nbsp;
						<span class="LABEL" style="color: blue; cursor: pointer;cursor:pointer; ">
							<span id='nextSpan'><fmt:message key="Common.next.label" bundle="${common_labels}"/>&gt;&gt;</span>
						</span>
					</th>
				</tr>
			</thead>
		</table>
		<table width="100%" align="center" cellpadding=3 cellspacing=0  width="100%" border="1" >
			<thead>
				<tr>
					<th>
					<% if("G".equals(receiptStatus) || "A".equals(receiptStatus)) { %>
						&nbsp;
						<input type="hidden" name='chkAll' id='chkAll' id='chkAll' value='N' />
					<% } else { %>
						<input type="checkbox" name='chkAll' id='chkAll' id='chkAll' onclick='return checkAll()' />
					<% } %>
					</th>
					<th nowrap>Patient ID</th>
					<th nowrap>Patient Name</th>
					<th nowrap>Date of Birth</th>
					<th nowrap>Gender</th>
					<th nowrap>Practo<br>Transaction Id.</th>
					<th nowrap>Practo Rec.No.</th>
					<th nowrap>Practo Rec.<br>Amt in Rs.</th>
					<th nowrap>Practo Rec.<br>Date</th>
					<th nowrap>EM Receipt No.</th>
					<th nowrap>EM Receipt<br>Date</th>
					<th nowrap>Comments</th>
				</tr>
			</thead>
			<tbody>
					<% 
						//For Traversal Start
						totalRecord = bean.getList().size();
						
						if(startRcrd>1){
							prevYn = "Y";
							traversal = "Y";
						}
						
						if((startRcrd+constCount) <= totalRecord){
							nextYn = "Y";
							traversal = "Y";
						}
						
						if(endRcrd > totalRecord) {
							endRcrd = totalRecord;
						}
						//For Traversal Ends
						
						
						for(int i = startRcrd-1; i < endRcrd; i++) {
						BLGenRcptForVendorsBean rcptBean = bean.getList().get(i);
					%>
						<tr>
							<td align=center>
								<% if("G".equals(rcptBean.getStatus()) || "A".equals(receiptStatus)) { %>
									<input type="checkbox" name='chk_<%=i%>' id='chk_<%=i%>' id='chk_<%=i%>' disabled />
								<% 
								} else {
									if("Y".equals(rcptBean.getChkBoxStatus())) {
								%>
									<input type="checkbox" name='chk_<%=i%>' id='chk_<%=i%>' id='chk_<%=i%>' onclick="chkEmptyPatientId(this, <%=i%>)" checked />
									<% } else { %>
									<input type="checkbox" name='chk_<%=i%>' id='chk_<%=i%>' id='chk_<%=i%>' onclick="chkEmptyPatientId(this, <%=i%>)" />
								<% 
									}
								}
								%>
							</td>
							<td>
							<% if((null != rcptBean.getPatientId() && !"null".equals(rcptBean.getPatientId()) && !"".equals(rcptBean.getPatientId())) || "G".equals(rcptBean.getStatus()) || "A".equals(receiptStatus)) { %>
								<%= null != rcptBean.getPatientId()?!"null".equals(rcptBean.getPatientId())?"".equals(rcptBean.getPatientId())?"&nbsp;":rcptBean.getPatientId():"&nbsp;":"&nbsp;" %>
								<input type='hidden' name='patId_<%=i%>' id='patId_<%=i%>' id='patId_<%=i%>' value='<%= rcptBean.getPatientId() %>' />
							<% } else { %>
								<input type='text' name='patId_<%=i%>' id='patId_<%=i%>' id='patId_<%=i%>' maxlength='<%=pat_id_len%>' size='<%=pat_id_len%>'
								onBlur="if(this.value != '') {ChangeUpperCase(this);callPatValidation(this, 'result', <%=i%>);} else {patientIdLookup(this, 'result', <%=i%>);}">&nbsp;
								<input type='button' class='button' value='?' name='patIDSrch_<%=i%>' id='patIDSrch_<%=i%>'
								id='patIDSrch_<%=i%>' onClick="patientIdLookup(patId_<%=i%>, 'result', <%=i%>)" tabIndex='2' />
							<% }  %>
							</td>
							<td><%=rcptBean.getPatientName() %>
								<input type='hidden' name='patName_<%=i%>' id='patName_<%=i%>' id='patName_<%=i%>' value='<%=rcptBean.getPatientName() %>' />
							</td>
							<td><%=rcptBean.getDob() %>
								<input type='hidden' name='patDob_<%=i%>' id='patDob_<%=i%>' id='patDob_<%=i%>' value='<%=rcptBean.getDob() %>' />
							</td>
							<td><%="M".equals(rcptBean.getGender())?"Male":"F".equals(rcptBean.getGender())?"Female":"Unknown" %>
								<input type='hidden' name='patGender_<%=i%>' id='patGender_<%=i%>' id='patGender_<%=i%>' value='<%=rcptBean.getGender() %>' />
							</td>
							<td><%=rcptBean.getPractoTransactionId() %>
								<input type='hidden' name='practoTransId_<%=i%>' id='practoTransId_<%=i%>' id='practoTransId_<%=i%>' value='<%=rcptBean.getPractoTransactionId() %>' />
							</td>
							<td><%=rcptBean.getPractoReceiptNo() %>
								<input type='hidden' name='practoRcptNo_<%=i%>' id='practoRcptNo_<%=i%>' id='practoRcptNo_<%=i%>' value='<%=rcptBean.getPractoReceiptNo() %>' />
							</td>
							<td align=right><%=rcptBean.getPractoReceiptAmount() %>
								<input type='hidden' name='practoRcptAmt_<%=i%>' id='practoRcptAmt_<%=i%>' id='practoRcptAmt_<%=i%>' value='<%=rcptBean.getPractoReceiptAmount() %>' />
							</td>
							<td><%=rcptBean.getPractoReceiptDate() %>
								<input type='hidden' name='practoRcptDate_<%=i%>' id='practoRcptDate_<%=i%>' id='practoRcptDate_<%=i%>' value='<%=rcptBean.getPractoReceiptDate() %>' />
							</td>
							<td><%="".equals(rcptBean.getEmReceiptNo())?"&nbsp;":rcptBean.getEmReceiptNo() %>
								<input type='hidden' name='emRcptNo_<%=i%>' id='emRcptNo_<%=i%>' id='emRcptNo_<%=i%>' value='<%=rcptBean.getEmReceiptNo() %>' />
							</td>
							<td><%="".equals(rcptBean.getEmReceiptDate())?"&nbsp;":rcptBean.getEmReceiptDate() %>
								<input type='hidden' name='emRcptDate_<%=i%>' id='emRcptDate_<%=i%>' id='emRcptDate_<%=i%>' value='<%=rcptBean.getEmReceiptDate() %>' />
							</td>
							<td nowrap><%="".equals(rcptBean.getCommnets())?"&nbsp;":rcptBean.getCommnets() %>
								<input type='hidden' name='emComments_<%=i%>' id='emComments_<%=i%>' id='emComments_<%=i%>' value='<%=rcptBean.getCommnets() %>' />
								<input type='hidden' name='practoDocTypeCode_<%=i%>' id='practoDocTypeCode_<%=i%>' id='practoDocTypeCode_<%=i%>' value='<%=rcptBean.getPractoDocTypeCode() %>' />
								<input type='hidden' name='practoDocNo_<%=i%>' id='practoDocNo_<%=i%>' id='practoDocNo_<%=i%>' value='<%=rcptBean.getPractoDocNo() %>' />
								<input type='hidden' name='slmtDocRefDesc_<%=i%>' id='slmtDocRefDesc_<%=i%>' id='slmtDocRefDesc_<%=i%>' value='<%=rcptBean.getSlmtDocRefDesc() %>' />
								<input type='hidden' name='slmtDocRefDate_<%=i%>' id='slmtDocRefDate_<%=i%>' id='slmtDocRefDate_<%=i%>' value='<%=rcptBean.getSlmtDocRefDate() %>' />
							</td>
						</tr>
					<% } %>
			</tbody>
		</table>
		<input type="hidden" name="locale" id="locale" 					id="locale" 				value="<%=locale%>" />
		<input type="hidden" name="facilityId" id="facilityId" 				id="facilityId"				value="<%=facilityId%>" />
		<input type="hidden" name="todaysDate" id="todaysDate"				id="todaysDate"				value="<%=currDate%>" />
		<input type="hidden" name="strLoggedUser" id="strLoggedUser" 			id="strLoggedUser" 			value="<%=strLoggedUser%>" />
		<input type="hidden" name="clientIpAddress" id="clientIpAddress" 		id="clientIpAddress" 		value="<%=clientIpAddress%>" />
		<input type="hidden" name="vendorType" id="vendorType" 				id="vendorType"				value="<%=vendorType%>" />
		<input type="hidden" name="patientId" id="patientId"				id="patientId"				value="<%=patientId%>" />
		<input type="hidden" name="patientName" id="patientName" 			id="patientName" 			value="<%=patientName%>" />
		<input type="hidden" name="practoDateFrom" id="practoDateFrom" 			id="practoDateFrom"			value="<%=practoDateFrom%>" />
		<input type="hidden" name="practoDateTo" id="practoDateTo"			id="practoDateTo"			value="<%=practoDateTo%>" />
		<input type="hidden" name="receiptStatus" id="receiptStatus"			id="receiptStatus"			value="<%=receiptStatus%>" />
		<input type="hidden" name="pat_id_len" id="pat_id_len"				id="pat_id_len"				value="<%=pat_id_len%>" />
		<input type="hidden" name="practoCashCounterCode" id="practoCashCounterCode"	id="practoCashCounterCode"	value="<%=practoCashCounterCode%>" />
		<input type="hidden" name="practoUser" id="practoUser"				id="practoUser"				value="<%=practoUser%>" />
		<input type="hidden" name="practoSlmtType" id="practoSlmtType"			id="practoSlmtType"			value="<%=practoSlmtType%>" />
		
		<input type='hidden' name='totalRecord' id='totalRecord'		id='totalRecord'	value="<%=totalRecord %>" >
		<input type='hidden' name='fromRcrd' id='fromRcrd' 		id='fromRcrd' 		value='<%=startRcrd %>'>
		<input type='hidden' name='toRcrd' id='toRcrd' 			id='toRcrd' 		value='<%=endRcrd %>'>
		<input type='hidden' name='constCount' id='constCount' 		id='constCount' 	value='<%=constCount %>'>
		<input type='hidden' name='hdnNextSpan' id='hdnNextSpan' 	id='hdnNextSpan' 	value='<%=nextYn %>'>
		<input type='hidden' name='prevSpan' id='prevSpan' 		id='prevSpan' 		value='<%=prevYn %>'>
		<input type='hidden' name='traverse' id='traverse' 		id='traverse' 		value='<%=traversal%>'>
	</form>
</body>
<%
	} catch(Exception e) {
		System.err.println("Error in BLGenRcptForVendorsResult.jsp: "+e);
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
</html>

