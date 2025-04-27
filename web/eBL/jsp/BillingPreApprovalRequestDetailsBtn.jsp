<!DOCTYPE html>
<!-- 
Sr No        Version           TFS/Incident        SCF/CRF            		 Developer Name
--------------------------------------------------------------------------------------------------------
1				V221129				37915			TH-KW-CRF-0084.1			Mohanapriya
--------------------------------------------------------------------------------------------------------
-->


<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*, eBL.PreApprovalRequestDetailsBean " contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	/* Added by Aravindh/11-05-2018/MMS-DM-CRF-0125 */
	String episodeType =	request.getParameter("episodeType");
	if(episodeType==null){
		episodeType="";
	}
	String patientId =	request.getParameter("patinetId");
	if(patientId==null){
		patientId="";
	}
	String episodeId =	request.getParameter("episodeId");
	if(episodeId==null){
		episodeId="";
	}
	String visitId =	request.getParameter("visitId");
	if(visitId==null){
		visitId="";
	}
	String encounterId =	request.getParameter("encounterId");
	if(encounterId==null){
		encounterId="";
	}
	
	String calledForm =	request.getParameter("calledForm");
	if(calledForm == null) {
		calledForm = "";
	}
	//V221130
	
	
	Connection con = null;
	
	boolean enableInsClear=false;//V221129
	String enableInsClearance="";
	try {
		con = ConnectionManager.getConnection();
		enableInsClear = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_INS_CLEARANCE_APPL");
		System.err.println("enableInsClear--" + enableInsClear);
		if (enableInsClear) {
			enableInsClearance = "Y";
		} else {
			enableInsClearance = "N";
		}
	} catch (Exception ex) {
		ex.printStackTrace();
	}
		//V221129
		
		//NMC-JD-CRF-0102.2
		boolean siteSpecUploadDoc=false; 
		String siteSpecUploadDocYN="N";
		try{
			siteSpecUploadDoc = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","REC_APPR_EXT_INT_ENABLED");
			//siteSpecUploadDoc = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","UPLOAD_CLARIFICATION_DOC");
			System.out.println("siteSpecUploadDoc "+siteSpecUploadDoc);
			if(siteSpecUploadDoc){
				siteSpecUploadDocYN="Y";
			}
		} catch(Exception ex) {
			System.err.println("Error in BillingPreApprovalRequestDetailsBtn.jsp for getting siteSpecUploadDoc Connection: "+ex);
			ex.printStackTrace();
		}
%>
 
<html>
<head>
<style>
	.billApproved{
		width: 12.5px;
		height: 12.5px;
		background: red;
	}
	.ind{
		color:red;
		font:bold;
	}
</style>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/BillingRecordApprovalScript.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




<script>

var ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL					=	"<%=BlRepository.getBlKeyValue("ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL")%>";
var PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL					=	"<%=BlRepository.getBlKeyValue("PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL")%>";	
var PAYER_LOOKUP_RECORD_PREAPPROVAL							=	"<%=BlRepository.getBlKeyValue("PAYER_LOOKUP_RECORD_PREAPPROVAL")%>";	
var POLICY_LOOKUP_RECORD_PREAPPROVAL						=	"<%=BlRepository.getBlKeyValue("POLICY_LOOKUP_RECORD_PREAPPROVAL")%>";	
var PRE_APPROVAL_REQUEST_REASONCODE_LOOKUP					=	"<%=BlRepository.getBlKeyValue("PRE_APPROVAL_REQUEST_REASONCODE_LOOKUP")%>";
var PRE_APPROVAL_REQUEST_BILLINGSERVICECODE_LOOKUP			=	"<%=BlRepository.getBlKeyValue("PRE_APPROVAL_REQUEST_BILLINGSERVICECODE_LOOKUP")%>";
var headTop = -1;
var FloatHead1;
function processScroll()
	{
		if (headTop < 0)
		{
			saveHeadPos();
			
		}
		if (headTop>0)
		{
			if (document.documentElement && document.documentElement.scrollTop)
				theTop = document.documentElement.scrollTop;
			else if (document.body)
				theTop = document.body.scrollTop;

			if (theTop>headTop)
				FloatHead1.style.top = (theTop-headTop) + 'px';
			else
				FloatHead1.style.top = '0px';
		}
	}

	function saveHeadPos()
	{
		parTable = document.getElementById("divHeadSep");
		if (parTable != null)
		{
			headTop = parTable.offsetTop + 3;
			FloatHead1 = document.getElementById("heading");
			FloatHead1.style.position = "relative";
		}
	}
	
	function lockKey()
	  {
		 	 
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	  }

	  function lockbackSpace()
	  {
		// alert(document.order_type_form.mode.value);
		   var mode = document.mode.value;
      // alert(window.event.keyCode);
		 if(mode=='modify' && window.event.keyCode==8)
		  {
           //return false;
		  }
	  }
	 
//Added by Rajesh V for MMS-ICN-0039	  
$(document).ready(function(){
	$('#recalc_charges').on('change',function(e){
		e.preventDefault();
	})
});	
//Added by Rajesh V for MMS-ICN-0039

</script>
</head>

<body onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"    ; onSelect="codeArrestThruSelect();" onload='checkinsclr()'>
<form name='billpreApprovalRequestDetailBtn' id='billpreApprovalRequestDetailBtn'>
		
<TABLE border='0' cellpadding='1' cellspacing='0' width='100%'>
			<%
			/* Added by Aravindh/11-05-2018/MMS-DM-CRF-0125/if-condition */
			if(calledForm.equals("serviceApprStatus")) {
			%>
				<tr>
					<td nowrap class='fields' width="38%">
					&nbsp;
					</td>
					<td nowrap class='label' width="20%">&nbsp;</td>
					<td nowrap class='fields' width="6%">
						<input type='button' id='apply_filter' value='Search' onclick='applyFilter()'>
					</td>
					<td nowrap class='fields' width="6%">
						<input type='button' id='reset_filter' value='Reset' onclick='resetFilter()'>
					</td>
					<td  nowrap class='fields' width="13%">&nbsp;</td>
					<td nowrap width="2%">&nbsp;</td>
					<td nowrap class='fields' width="6%">&nbsp;</td>
					<td nowrap width="3%">&nbsp;</td>
					<td nowrap class='fields' width="6%" align='right'>&nbsp;</td> 
					
				</tr>
			<%
			} else {
			%>
				<tr>
				<% if(siteSpecUploadDoc && episodeType.equals("O")){//NMC-JD-CRF-0102.2
				%>
				<td nowrap class='ind' width="2%" >&nbsp;&nbsp; *Only PDF format will be accepted by NPHIES</td>
				<% } %>
					<%if(enableInsClearance.equals("Y") && ( episodeType.equals("I") || episodeType.equals("D"))){ %>
						<td nowrap class='fields' width="16%">
						&nbsp;<input type='button' id='cancelInsClr' name='cancelInsClr' id='cancelInsClr' disabled value='<fmt:message key="eBL.cancelInsClear.label" bundle="${bl_labels}"/>' onclick='cancelInsurclear()'>
						</td><td nowrap class='fields' width="20%"> 
						&nbsp;<input type='checkbox' id='genInsClr' id='genInsClr' disabled onClick='validateSts()'>&nbsp;
							<fmt:message key="eBL.genInsClear.label" bundle="${bl_labels}"/>
					</td>
					<%}else{ %>
						<td nowrap class='fields' width="36%">&nbsp;
						</td>
					<%} %><!-- V221129 -->
					<td nowrap class='label' width="20%">
						<span class='billApproved'></span>&nbsp;<fmt:message key="eBL.BillApprovedInv.label" 		bundle="${bl_labels}"	/>
					</td>
					<td nowrap class='fields' width="6%">
						<input type='button' id='apply_filter' value='Search' onclick='applyFilter()'>
					</td>
					<td nowrap class='fields' width="6%">
						<input type='button' id='reset_filter' value='Reset' onclick='resetFilter()'>
					</td>
					<td  nowrap class='fields' width="13%">
					<input type='checkbox' name='recalc_charges' id='recalc_charges' id='recalc_charges' disabled>&nbsp;
					<fmt:message key="eBL.RecalculationCharges.label" bundle="${bl_labels}"/>
					</td>
					<td nowrap width="2%"></td>
					<td nowrap class='fields' width="6%">
						<input type="button" class='button' name="auth" id="auth"		id="auth"  	 value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorized.label","common_labels")%>" onClick='authUser("");'  >
					</td>
					<% if(siteSpecUploadDoc && calledForm.equals("preAuthStsTrack")){ %>
					<td nowrap width="2%"></td>
					<td nowrap class='fields' width="2%">
						<input type="button" class='button' name="close" id="close"		id="close"  	 value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='closeRecApr();'  >
					</td>
					<%} %>
					<td nowrap width="3%"></td>
					<td nowrap class='fields' width="6%" align='right'>
						&nbsp;
					</td> 
					
				</tr>
			<%} %>
			</TABLE> 
	<!-- Added by Aravindh/11-05-2018/MMS-DM-CRF-0125 -->
	<input type='hidden' name='calledForm' id='calledForm'	id='calledForm'	 value="<%=calledForm %>" >
	<input type='hidden' name='enableInsClearance' id='enableInsClearance'	id='enableInsClearance'	 value="<%=enableInsClearance%>" ><!-- V221129 -->
	<input type='hidden' name='episodeType' id='episodeType'	id='episodeType'	 value="<%=episodeType%>" ><!-- V221129 -->
	<input type='hidden' name='patientId' id='patientId'	id='patientId'	 value="<%=patientId%>" ><!-- V221129 -->
	<input type='hidden' name='episodeId' id='episodeId'	id='episodeId'	 value="<%=episodeId%>" ><!-- V221129 -->
	<input type='hidden' name='visitId' id='visitId'	id='visitId'	 value="<%=visitId%>" ><!-- V221129 -->
	<input type='hidden' name='encounterId' id='encounterId'	id='encounterId'	 value="<%=encounterId%>" ><!-- V221129 -->
	
</form>	
</body>

</html>

