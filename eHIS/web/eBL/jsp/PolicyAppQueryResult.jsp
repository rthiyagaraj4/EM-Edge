<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
29-MAY-2019      100           Gayathri R         Created
---------------------------------------------------------------------------------------------------------------
-->
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
			
	String locale = (String)session.getAttribute("LOCALE");
	String facilityId = (String)session.getAttribute("facility_id");
			
	String strLoggedUser = nulltoStr(request.getParameter("strLoggedUser"));
	String clientIpAddress = nulltoStr(request.getParameter("clientIpAddress"));
	String payerGrpCode = nulltoStr(request.getParameter("payerGrpCode"));
	String policyTypeCode = nulltoStr(request.getParameter("policyTypeCode"));
	String payerCode = nulltoStr(request.getParameter("payerCode"));
	String applicalbleTo = nulltoStr(request.getParameter("applicalbleTo"));
	
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
	Boolean siteSpecPolApprv = false;
	try {
		
	
		System.out.println("facilityId:" + facilityId + " strLoggedUser:" + strLoggedUser);
		
		String bean_id			= "bl_PolicyApprovalBean" ;
		String bean_name		= "eBL.PolicyApprovalBean";
		String modifyStatus     = "";
		PolicyApprovalBean bean			= (PolicyApprovalBean)getBeanObject( bean_id, bean_name, request ) ;
		
		if("search".equals(mode)) {
			bean.setDBValues(mode, facilityId, payerGrpCode, policyTypeCode, payerCode, applicalbleTo);
		}
		con = ConnectionManager.getConnection(request);
		String polApprvSql = "select NVL(enable_policy_approval_yn,'N') enable_policy_approval_yn from bl_parameters where operating_facility_id = '"+facilityId+"'";
		pstmt = con.prepareStatement(polApprvSql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			String enablePolicyApprvl = rs.getString("enable_policy_approval_yn");
			if("Y".equals(enablePolicyApprvl)) {
				siteSpecPolApprv = true;
			}
		}
		rs.close();
		pstmt.close();
		System.out.println("PolicyAppqueryResult->siteSpecPolApprv: "+siteSpecPolApprv);
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
	<script language='javascript' src='../../eBL/js/PolicyApproval.js'></script>
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
				var rsltFormObj = document.policyQryResultfrm;
				var xmlString = formXMLStringMain(rsltFormObj);
				var updation = formValidation(xmlString, "MODIFY");
				
				//alert($('#applicalbleTo').val());
				document.location.href = "../../eBL/jsp/PolicyAppQueryResult.jsp?"
					+ "facilityId="+$('#facilityId').val()+"&payerGrpCode="+$('#payerGrpCode').val()+"&policyTypeCode="+$('#policyTypeCode').val()+"&payerCode="+$('#payerCode').val()
					+ "&applicalbleTo="+$('#applicalbleTo').val()
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
				
				var rsltFormObj = document.policyQryResultfrm;
				var xmlString = formXMLStringMain(rsltFormObj);
				var updation = formValidation(xmlString, "MODIFY");
				
				document.location.href = "../../eBL/jsp/PolicyAppQueryResult.jsp?"
					+ "facilityId="+$('#facilityId').val()+"&payerGrpCode="+$('#payerGrpCode').val()+"&policyTypeCode="+$('#policyTypeCode').val()+"&payerCode="+$('#payerCode').val()
					+ "&applicalbleTo="+$('#applicalbleTo').val()
					+ "&fromRcrd="+startFrom+"&toRcrd="+endWith;
			});
			//doUserAuthenticationValidationPayerApprove();
			chkIndividualItem();
		});
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onKeyDown="lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
	<form name="policyQryResultfrm" id="policyQryResultfrm" id="policyQryResultfrm">
		<table width="100%" align="center" cellpadding=0 cellspacing=0  width="100%" border="0" >
			<thead>
				<tr height=25px; style="background-color: white; border: none;" id='trProgress'>
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
					<th nowrap><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></th>
					<th nowrap><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/></th>
					<th nowrap><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></th>
					<th>
						<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
						<input type='checkbox' name='chkAll' id='chkAll' id='chkAll' onclick="checkAll(this);" /><br/>
						<fmt:message key="Common.Approved.label" bundle="${common_labels}"/>
					</th>
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
						PolicyApprovalBean appBean = bean.getList().get(i);
					%>
						<tr>
							<td class='label' style="cursor: pointer;" onclick="showPolicyDef('<%=appBean.getCustomerGroup()%>', '<%=appBean.getCustomer()%>', '<%=appBean.getPolicy()%>', '<%=appBean.getPolStratDate()%>', '<%=appBean.getPolEndDate()%>')">
								<span style="text-decoration: underline;font-weight: bold;">
									<font color="blue"><%=appBean.getCustomerGroupDesc() %></font>
								</span>
								<input type='hidden' name='custGrpDesc_<%=i%>'  id='custGrpDesc_<%=i%>' value='<%=appBean.getCustomerGroupDesc() %>' />
								<input type='hidden' name='custGrp_<%=i%>'  id='custGrp_<%=i%>' value='<%=appBean.getCustomerGroup() %>' />
							</td>
							<td class='label'><%=appBean.getCustomerDesc() %>
								<input type='hidden' name='custDesc_<%=i%>'  id='custDesc_<%=i%>' value='<%=appBean.getCustomerDesc() %>' />
								<input type='hidden' name='cust_<%=i%>'  id='cust_<%=i%>' value='<%=appBean.getCustomer() %>' />
							</td>
							<td class='label'><%=appBean.getPolicyDesc() %>
								<input type='hidden' name='policyDesc_<%=i%>'  id='policyDesc_<%=i%>' value='<%=appBean.getPolicyDesc() %>' />
								<input type='hidden' name='policy_<%=i%>'  id='policy_<%=i%>' value='<%=appBean.getPolicy() %>' />
							</td>
							<td align=center>
								<% if("Y".equals(appBean.getChkBox())) { %>
									<input type="checkbox" name='chk_<%=i%>'  id='chk_<%=i%>' onclick="doUserAuthenticationValidationPayerApprove(this,<%=i%>,'ind');chkIndividualItem();" checked />
								<% } else { %>
									<input type="checkbox" name='chk_<%=i%>'  id='chk_<%=i%>' onclick="doUserAuthenticationValidationPayerApprove(this,<%=i%>,'ind');chkIndividualItem();"  />
								<% } %>
								<input type='hidden' name='chkBxDbVal_<%=i%>'  id='chkBxDbVal_<%=i%>' value='<%=appBean.getChkBoxDBVal() %>' />
							</td>
						</tr>
					<% } %>
			</tbody>
		</table>
		<input type='hidden' name='payerGrpCode' id='payerGrpCode'						value="<%=payerGrpCode %>" />
		<input type='hidden' name='policyTypeCode' id='policyTypeCode'						value="<%=policyTypeCode %>" />
		<input type='hidden' name='payerCode' id='payerCode'								value="<%=payerCode %>" />
		<input type='hidden' name='applicalbleTo' id='applicalbleTo'						value="<%=applicalbleTo %>" />
		<input type='hidden' name='validUserApprvUnApprv' id='validUserApprvUnApprv'		value="false" />
		<input type='hidden' name='totalRecord' id='totalRecord'							value="<%=totalRecord %>" />
		<input type='hidden' name='fromRcrd' id='fromRcrd' 								value='<%=startRcrd %>' />
		<input type='hidden' name='toRcrd' id='toRcrd' 					 				value='<%=endRcrd %>' />
		<input type='hidden' name='constCount' id='constCount' 			 			value='<%=constCount %>' />
		<input type='hidden' name='hdnNextSpan' id='hdnNextSpan' 					value='<%=nextYn %>' />
		<input type='hidden' name='prevSpan' id='prevSpan' 								value='<%=prevYn %>' />
		<input type='hidden' name='traverse' id='traverse' 								value='<%=traversal%>' />
		<input type='hidden' name='loginUser' id='loginUser' 						value='<%=strLoggedUser%>' />
		
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

