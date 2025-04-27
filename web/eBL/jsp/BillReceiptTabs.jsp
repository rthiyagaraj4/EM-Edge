<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.*, java.util.*, java.text.*,org.apache.commons.codec.binary.Base64" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<html>
<head>
<title>Charge Patient</title>
<%!
private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}
%>
<%  
request.setCharacterEncoding("UTF-8");
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String episodeType = replaceNull(request.getParameter("episode_type"));
String episodeId = replaceNull(request.getParameter("episode_id"));
String visitId = replaceNull(request.getParameter("visit_id"));
//V220512
/*
String patientId = replaceNull(request.getParameter("patient_id"));
String encounterId = replaceNull(request.getParameter("encounter_id"));
*/
String patientId	="";
String encounterId	="";

if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
	patientId	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
	encounterId	= new String(Base64.decodeBase64(((String)request.getParameter("encounter_id")).getBytes()));
}else{
	patientId	= replaceNull(request.getParameter("patient_id"));
	encounterId	= replaceNull(request.getParameter("encounter_id"));
}
//V220512
String locale = (String) (session.getValue("LOCALE"));
String facilityId = (String) (session.getValue("facility_id"));
String blngGrpId = replaceNull(request.getParameter("blng_grp_id"));
String loginUser = (String) session.getValue("login_user");
String pkgClosedYn=(String) session.getAttribute("pkgClosedYN");
String pkgSeqNum=(String) session.getAttribute("pkgSeqNum");

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<script>
 function callOnMouseOver(obj){
		currClass = obj.className ;
			obj.className = 'CASECONDSELECTHORZ';
	}

	function callOnMouseOut(obj){
		obj.className = currClass;
	}

	function changeColor(obj,from_name)
	{
		if(from_name=="OR_BUTTONS")
			cellref = criteriaCategoryButtonFrame.document.getElementById("tab").rows[0].cells
		else if(from_name=="COMMON")
			cellref = document.getElementById("tab").rows[0].cells
		for(i=0; i<cellref.length; i++)
		{
			//if(i!=2 && i!=3)
			 cellref[i].className = 'CAFIRSTSELECTHORZ'
		}
		obj.className = "CASECONDSELECTHORZ"
		currClass ="CASECONDSELECTHORZ";
	}
	
	function billCumReceipt(){
		//alert("2");
		changeColor(this,'COMMON');		
		var queryString = $('#queryString').val();
		//parent.document.getElementById('BL_mainFrame').rows = parent.document.getElementById('allFramesExisting').value;
		parent.document.getElementById('pline').style.height='8vh';
		parent.document.getElementById('BillReceiptTab').style.height='4vh';
		parent.document.getElementById('BillReceiptInfo').style.height='25vh';
		parent.document.getElementById('BillReceiptExisOrderSearch').style.height='18vh';
		parent.document.getElementById('BillReceiptExisOrderDetails').style.height='20vh';
		parent.document.getElementById('BillReceiptExisOrderSummary').style.height='16vh';
		parent.document.getElementById('messageFrame1').style.height='6vh';
		
		parent.BillReceiptExisOrderSearch.location.href='../../eCommon/html/blank.html';
		parent.BillReceiptExisOrderDetails.location.href='../../eCommon/html/blank.html';
		parent.BillReceiptExisOrderSummary.location.href='../../eCommon/html/blank.html';
		
		parent.messageFrame1.location.href = '../../eCommon/jsp/error.jsp';
		parent.BillReceiptInfo.location.href='BillReceiptInfo.jsp?'+queryString;		
		//parent.BillReceiptWindow.location.href = 'BillReceiptEncBillDetails.jsp?'+queryString;
	}
	
	function otherOutStanding(){
		//alert("1");
		changeColor(this,'COMMON');	
		var queryString = $('#queryString').val();
		var unBilled = $.trim($(parent.BillReceiptInfo.document).find('#unBillAmt').text());
		var outStCash = $.trim($(parent.BillReceiptInfo.document).find('#outstCash').text());
		var outStCredit = $.trim($(parent.BillReceiptInfo.document).find('#outstCredit').text());
		var totOutSt = parseInt(outStCash)+parseInt(outStCredit);
			//parent.document.getElementById('BL_mainFrame').rows = parent.document.getElementById('allFramesOtherOut').value;
		
		parent.document.getElementById('pline').style.height='8vh';
		parent.document.getElementById('BillReceiptTab').style.height='6vh';		
		parent.document.getElementById('BillReceiptInfo').style.height='0vh';
		parent.document.getElementById('BillReceiptExisOrderSearch').style.height='7vh';
		parent.document.getElementById('BillReceiptExisOrderDetails').style.height='60vh';
		parent.document.getElementById('BillReceiptExisOrderSummary').style.height='7vh';
		parent.document.getElementById('messageFrame1').style.height='6vh';
		
		parent.BillReceiptExisOrderSearch.location.href='BillReceiptOtherOutStandingTab.jsp?'+queryString;
		parent.BillReceiptExisOrderDetails.location.href='BillReceiptTotOutstUnBilled.jsp?'+queryString;
		parent.BillReceiptExisOrderSummary.location.href='../../eCommon/html/blank.html';
		//parent.BillReceiptWindow.location.href = "../../eCommon/html/blank.html";
		parent.messageFrame1.location.href='../../eCommon/jsp/error.jsp';	
	}
	
	function unConfirmedServices(){
		changeColor(this,'COMMON');
		//parent.document.getElementById('BL_mainFrame').rows = parent.document.getElementById('allFramesUnConfirmed').value;
		parent.document.getElementById('pline').style.height='8vh';
		parent.document.getElementById('BillReceiptTab').style.height='6vh';
		parent.document.getElementById('BillReceiptInfo').style.height='0vh';
		parent.document.getElementById('BillReceiptExisOrderSearch').style.height='72vh';
		parent.document.getElementById('BillReceiptExisOrderDetails').style.height='0vh';
		parent.document.getElementById('BillReceiptExisOrderSummary').style.height='0vh';
		parent.document.getElementById('messageFrame1').style.height='6vh';
		
		parent.BillReceiptExisOrderSearch.location.href='BLChargePatientExisOrderServDetails.jsp?'+
		'&patientId='+$('#patient_id').val()+
		'&episodeType='+$('#episode_type').val()+
		'&episodeId='+$('#episode_id').val()+
		'&visitId='+$('#visit_id').val()+
		'&locale='+$('#locale').val()+
		'&processed=UC&groupLineService=D&reSize=UC';
		parent.BillReceiptExisOrderDetails.location.href='../../eCommon/html/blank.html';
		parent.BillReceiptExisOrderSummary.location.href='../../eCommon/html/blank.html';
		//parent.BillReceiptWindow.location.href = "../../eCommon/html/blank.html";
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';	
	}
	
	function fnInterface(){
		changeColor(this,'COMMON');	
		//parent.document.getElementById('BL_mainFrame').rows = parent.document.getElementById('allFramesUnConfirmed').value;
		
		parent.document.getElementById('pline').style.height='8vh';
		parent.document.getElementById('BillReceiptTab').style.height='6vh';
		parent.document.getElementById('BillReceiptInfo').style.height='0vh';
		parent.document.getElementById('BillReceiptExisOrderSearch').style.height='68vh';
		parent.document.getElementById('BillReceiptExisOrderDetails').style.height='0vh';
		parent.document.getElementById('BillReceiptExisOrderSummary').style.height='0vh';
		parent.document.getElementById('messageFrame1').style.height='6vh';
		
		parent.BillReceiptExisOrderSearch.location.href="BLBillGenInterfaceMainFrame.jsp?"+
		'&patient_id='+$('#patient_id').val()+
		'&episode_type='+$('#episode_type').val()+
		'&episode_id='+$('#episode_id').val()+
		'&visit_id='+$('#visit_id').val()+
		'&patient_name='+$('#patient_name').val()+
		'&futureYN=N';
		parent.BillReceiptExisOrderDetails.location.href='../../eCommon/html/blank.html';
		parent.BillReceiptExisOrderSummary.location.href='../../eCommon/html/blank.html';
		//parent.BillReceiptWindow.location.href = "../../eCommon/html/blank.html";
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';	
	}
	
	function futureOrders(){
		changeColor(this,'COMMON');	
	//	parent.document.getElementById('BL_mainFrame').rows = parent.document.getElementById('allFramesUnConfirmed').value;
		parent.document.getElementById('pline').style.height='8vh';
		parent.document.getElementById('BillReceiptTab').style.height='6vh';
		parent.document.getElementById('BillReceiptInfo').style.height='0vh';
		parent.document.getElementById('BillReceiptExisOrderSearch').style.height='68vh';
		parent.document.getElementById('BillReceiptExisOrderDetails').style.height='0vh';
		parent.document.getElementById('BillReceiptExisOrderSummary').style.height='0vh';
		parent.document.getElementById('messageFrame1').style.height='6vh';
		
		parent.BillReceiptExisOrderSearch.location.href="BLBillGenInterfaceMainFrame.jsp?"+
		'&patient_id='+$('#patient_id').val()+
		'&episode_type='+$('#episode_type').val()+
		'&episode_id='+$('#episode_id').val()+
		'&visit_id='+$('#visit_id').val()+
		'&patient_name='+$('#patient_name').val()+
		'&futureYN=Y';
		parent.BillReceiptExisOrderDetails.location.href='../../eCommon/html/blank.html';
		parent.BillReceiptExisOrderSummary.location.href='../../eCommon/html/blank.html';
		//parent.BillReceiptWindow.location.href = "../../eCommon/html/blank.html";
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';	
	}
	
	function fnEncBillDtls(){
		changeColor(this,'COMMON');	
	//	parent.document.getElementById('BL_mainFrame').rows = parent.document.getElementById('allFramesUnConfirmed').value;
		
		parent.document.getElementById('pline').style.height='8vh';
		parent.document.getElementById('BillReceiptTab').style.height='6vh';
		parent.document.getElementById('BillReceiptInfo').style.height='0vh';
		parent.document.getElementById('BillReceiptExisOrderSearch').style.height='68vh';
		parent.document.getElementById('BillReceiptExisOrderDetails').style.height='0vh';
		parent.document.getElementById('BillReceiptExisOrderSummary').style.height='0vh';
		parent.document.getElementById('messageFrame1').style.height='6vh';
		
		parent.BillReceiptExisOrderSearch.location.href='BillReceiptEncBillDetails.jsp?'+$('#queryString').val();
		parent.BillReceiptExisOrderDetails.location.href='../../eCommon/html/blank.html';
		parent.BillReceiptExisOrderSummary.location.href='../../eCommon/html/blank.html';
		//parent.BillReceiptWindow.location.href = "../../eCommon/html/blank.html";
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	}

 </script>
<%
String existing_order_class="";
String new_order_class="";
String queryString = (String) request.getQueryString();
String selectedTab=(String)request.getParameter("selectedTab");
if(selectedTab == null) selectedTab="billCumReceipt";

if(selectedTab.equalsIgnoreCase("billCumReceipt")){
	existing_order_class="CASECONDSELECTHORZ";
	new_order_class="CAFIRSTSELECTHORZ";
}else if(selectedTab.equalsIgnoreCase("unBilledOutStanding")){
	existing_order_class="CAFIRSTSELECTHORZ";
	new_order_class="CASECONDSELECTHORZ";
}
else if(selectedTab.equalsIgnoreCase("unBilledOutStanding")){
	existing_order_class="CAFIRSTSELECTHORZ";
	new_order_class="CASECONDSELECTHORZ";
}
else if(selectedTab.equalsIgnoreCase("unBilledOutStanding")){
	existing_order_class="CAFIRSTSELECTHORZ";
	new_order_class="CASECONDSELECTHORZ";
}

String chargeLogicYN = "";
String ipChkOutBasisInd = "";
String prePayChk = "";
String depChk = "";
String billCashBlngServSeparately = "";
String default_disc_bill_ind="";
String noOfDecimal = "";
String allow_locn_based_bill_yn="";
String allow_service_selection_yn="";
String dflt_adj_dep_dur_bill_yn="";
String dflt_adj_prepay_dur_bill_yn="";
String all_payers_bill_together_yn="";
String adhoc_discount_allowed_yn="";
String drug_penalty_yn ="";
String adj_pat_prepay_in_enc_pre_yn="";
String capt_addl_id_proof_for_bill_yn ="";
String addl_id_mand_for_payer_bill_yn="";
String dflt_addl_id_type ="";
String l_accept_national_id_no_yn ="";
int count=0;


Connection con = null;
PreparedStatement pstmt = null;
ResultSet rst = null;

try{
	con = ConnectionManager.getConnection();
	pstmt = con.prepareStatement("Select charge_logic_yn,ip_check_out_basis_ind,NVL (adjust_full_pr_amt_yn, 'N') adjust_full_pr_amt_yn,NVL (adjust_full_ad_amt_yn, 'N') adjust_full_ad_amt_yn, NVL(bill_cash_blng_serv_separately,'N') bill_cash_blng_serv_separately,NVL(default_disc_bill_ind,'N') default_disc_bill_ind,NVL (allow_locn_based_bill_yn, 'N') allow_locn_based_bill_yn,NVL (allow_service_selection_yn, 'N') allow_service_selection_yn,NVL (dflt_adj_dep_dur_bill_yn, 'N') dflt_adj_dep_dur_bill_yn,NVL (dflt_adj_prepay_dur_bill_yn, 'N') dflt_adj_prepay_dur_bill_yn,NVL (all_payers_bill_together_yn, 'N') all_payers_bill_together_yn,NVL (adhoc_discount_allowed_yn, 'N') adhoc_discount_allowed_yn,NVL (drug_penalty_yn, 'N') drug_penalty_yn,NVL(adj_pat_prepay_in_enc_pre_yn,'N') adj_pat_prepay_in_enc_pre_yn,capt_addl_id_proof_for_bill_yn,addl_id_mand_for_payer_bill_yn,dflt_addl_id_type from bl_parameters where operating_facility_id = ?");
	pstmt.setString(1, facilityId);
	rst = pstmt.executeQuery();
	
	if(rst != null && rst.next()){
		chargeLogicYN = rst.getString("charge_logic_yn");
		ipChkOutBasisInd = rst.getString("ip_check_out_basis_ind");
		depChk = rst.getString("adjust_full_ad_amt_yn");
		prePayChk = rst.getString("adjust_full_pr_amt_yn");
		billCashBlngServSeparately = rst.getString("bill_cash_blng_serv_separately");
		default_disc_bill_ind= rst.getString("default_disc_bill_ind"); 
		allow_locn_based_bill_yn= rst.getString("allow_locn_based_bill_yn");
		allow_service_selection_yn= rst.getString("allow_service_selection_yn");
		dflt_adj_dep_dur_bill_yn= rst.getString("dflt_adj_dep_dur_bill_yn");
		dflt_adj_prepay_dur_bill_yn= rst.getString("dflt_adj_prepay_dur_bill_yn");
		all_payers_bill_together_yn= rst.getString("all_payers_bill_together_yn");
		adhoc_discount_allowed_yn= rst.getString("adhoc_discount_allowed_yn");
		drug_penalty_yn= rst.getString("drug_penalty_yn");
		adj_pat_prepay_in_enc_pre_yn =rst.getString("adj_pat_prepay_in_enc_pre_yn");
		capt_addl_id_proof_for_bill_yn =rst.getString("capt_addl_id_proof_for_bill_yn");
		addl_id_mand_for_payer_bill_yn =rst.getString("addl_id_mand_for_payer_bill_yn");
		dflt_addl_id_type =rst.getString("dflt_addl_id_type");
	}
	
	pstmt = null;
	rst = null;

	pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) no_of_decimal from  sm_acc_entity_param");
	rst = pstmt.executeQuery();
	if(rst != null && rst.next()){
		noOfDecimal = rst.getString("no_of_decimal");
	}
	pstmt = null;
	rst = null;
	pstmt = con.prepareStatement( "SELECT COUNT (*)  FROM bl_users_for_credit_auth WHERE operating_facility_id = '"+facilityId+"' AND credit_auth_user_id = '"+loginUser+"' AND bill_exempt_auth_yn = 'Y' AND NVL (status, 'X') <> 'S'");	
	rst = pstmt.executeQuery();
	if(rst != null && rst.next()){
		count = rst.getInt(1);
	}
	
  }catch(Exception eX){	
	noOfDecimal = "2";
	System.err.println("Exception in getting Charge Logic YN ->"+eX);
}
finally{
	pstmt = null;
	rst = null;
	ConnectionManager.returnConnection(con);
}

%>
<!-- Selected stuff should be highlighted in black use:CASECONDSELECTHORZ-->
<form name="ChargePatientEncounterTabsForm" id="ChargePatientEncounterTabsForm">
	<table id="tab" cellspacing=0 cellpadding="3" border="0" width="40%">
		<tr>
			<td id="billCumReceipt"  width="5%"	class="<%=existing_order_class%>"  onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="billCumReceipt();" nowrap>
			<a style='color:white;cursor:pointer' href="#"><fmt:message key="eBL.GenerateBillCumReceipt.label" bundle="${bl_labels}"/></a>
			</td>
			<td id="unBilledOutStanding" width="5%"	class="<%=new_order_class%>" style="display:''"  onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="otherOutStanding();" nowrap>
			<a  style='color:white;cursor:pointer' href="#"><fmt:message key="eBL.OtherUnbilledOutstanding.label" bundle="${bl_labels}"/></a>
			</td>
			<td id="unConfirmedServices" width="5%"	class="<%=new_order_class%>" style="display:''"  onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="unConfirmedServices();" nowrap>
			<a  style='color:white;cursor:pointer' href="#"><fmt:message key="eBL.UnConfirmedServices.label" bundle="${bl_labels}"/></a>
			</td>
			<td id="interface" width="5%"	class="<%=new_order_class%>" style="display:''"  onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="fnInterface();" nowrap>
			<a  style='color:white;cursor:pointer' href="#"><fmt:message key="Common.Interface.label" bundle="${common_labels}"/></a>
			</td>
			<td id="futureOrder" width="5%"	class="<%=new_order_class%>" style="display:''"  onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="futureOrders();" nowrap>
			<a  style='color:white;cursor:pointer' href="#"><fmt:message key="eBL.FutureOrder.label" bundle="${bl_labels}"/></a>
			</td>
			<td id="encBillDetails" width="5%"	class="<%=new_order_class%>" style="display:''"  onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="fnEncBillDtls();" nowrap>
			<a  style='color:white;cursor:pointer' href="#"><fmt:message key="eBL.EncounterBillingDetails.label" bundle="${bl_labels}"/></a>
			</td>
	</tr>
	</table>
	<input type='hidden' name='queryString' id='queryString'  value='<%=queryString %>' >
	<input type='hidden' name='episode_type' id='episode_type'  value='<%=episodeType %>' >
	<input type='hidden' name='episode_id' id='episode_id'  value='<%=episodeId %>' >
	<input type='hidden' name='visit_id' id='visit_id'  value='<%=visitId %>' >
	<input type='hidden' name='patient_id' id='patient_id'  value='<%=patientId %>' >
	<input type='hidden' name='encounter_id' id='encounter_id'  value='<%=encounterId %>' >
	
	<input type='hidden' name='locale' id='locale'  value='<%=locale %>' >
	<input type='hidden' name='privForIndirect'  id='privForIndirect' value=''>
	<input type='hidden' name='chargeLogicYN'  id='chargeLogicYN' value='<%=chargeLogicYN %>'>
	<input type='hidden' name='ipChkOutBasisInd'  id='ipChkOutBasisInd' value='<%=ipChkOutBasisInd %>'>
	<input type='hidden' name='noOfDecimal'  id='noOfDecimal' value='<%=noOfDecimal %>'>
	<input type='hidden' name='unBilled'  id='unBilled' value=''>
	<input type='hidden' name='totOutSt'  id='totOutSt' value=''>
	<input type='hidden' name='pkgSeqNo'  id='pkgSeqNo' value='<%=pkgSeqNum%>'>
	<input type='hidden' name='pkgClosedYn'  id='pkgClosedYn' value='<%=pkgClosedYn%>'>
	<input type='hidden' name='depChk'  id='depChk' value='<%=depChk %>'>
	<input type='hidden' name='prePayChk'  id='prePayChk' value='<%=prePayChk %>'>
	<input type='hidden' name='blngGrpId'  id='blngGrpId' value='<%=blngGrpId %>'>
	<input type='hidden' name='pkgAlrdPop'  id='pkgAlrdPop' value='N'>
	<input type='hidden' name='warnAlrdPop'  id='warnAlrdPop' value='N'>
	<input type='hidden' name='billCashBlngServSeparately'  id='billCashBlngServSeparately' value='<%=billCashBlngServSeparately %>'>
	<input type='hidden' name='default_disc_bill_ind'  id='default_disc_bill_ind' value='<%=default_disc_bill_ind %>'>
	
	<input type='hidden' name='allow_locn_based_bill_yn'  id='allow_locn_based_bill_yn' value='<%=allow_locn_based_bill_yn %>'>
	<input type='hidden' name='allow_service_selection_yn'  id='allow_service_selection_yn' value='<%=allow_service_selection_yn %>'>
	<input type='hidden' name='dflt_adj_dep_dur_bill_yn'  id='dflt_adj_dep_dur_bill_yn' value='<%=dflt_adj_dep_dur_bill_yn %>'>
	<input type='hidden' name='dflt_adj_prepay_dur_bill_yn'  id='dflt_adj_prepay_dur_bill_yn' value='<%=dflt_adj_prepay_dur_bill_yn %>'>
	<input type='hidden' name='all_payers_bill_together_yn'  id='all_payers_bill_together_yn' value='<%=all_payers_bill_together_yn %>'>
	<input type='hidden' name='adhoc_discount_allowed_yn'  id='adhoc_discount_allowed_yn' value='<%=adhoc_discount_allowed_yn %>'>
	<input type='hidden' name='capt_addl_id_proof_for_bill_yn'  id='capt_addl_id_proof_for_bill_yn' value='<%=capt_addl_id_proof_for_bill_yn %>'>
	<input type='hidden' name='addl_id_mand_for_payer_bill_yn'  id='addl_id_mand_for_payer_bill_yn' value='<%=addl_id_mand_for_payer_bill_yn %>'>
	<input type='hidden' name='dflt_addl_id_type' id='dflt_addl_id_type'  value='<%=dflt_addl_id_type %>'>
	<input type='hidden' name='drug_penalty_yn' id='drug_penalty_yn'  value='<%=drug_penalty_yn %>'>
	
	<input type='hidden' name='adj_pat_prepay_in_enc_pre_yn'  id='adj_pat_prepay_in_enc_pre_yn' value='<%=adj_pat_prepay_in_enc_pre_yn %>'>
	<input type='hidden' name='count' id='count'  value='<%=count%>'>
	
	<input type='hidden' name='interfaceYn'  id='interfaceYn' value=''>
	<input type='hidden' name='futureOrderYn'  id='futureOrderYn' value=''>
	<input type='hidden' name='totalCount'  id='totalCount' value='' >
	<input type='hidden' name='packageCode'  id='packageCode' value='' >
	
</form>
</body>
</html> 

 

