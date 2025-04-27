<!DOCTYPE html>
<!-- 
Sr No              Version                Incident              SCF/CRF                        Developer Name
1                  V201013                IN73702            NMC-JD-CRF-0042.1         			Shikha Seth
2                  V201024                IN73702            NMC-JD-CRF-0042.1         			Shikha Seth
3	      	       V220324	       	      27973	             MMS-ME-SCF-0046-TF			        Mohana Priya K
4           	   V220627                31872      	     NMC-JD-CRF-0170 US001              Mohanapriya K
5				   V220905				  33891		         TH-KW-CRF-0093                     Mohanapriya K
6					V221025				 					TH-KW-CRF-0020.7					Mohanapriya
7				  V221216				37915				TH-KW-CRF-0084.1					Mohanapriya
8				  V230102								TH-KW-CRF-0084					Mohanapriya
9				V230608							MMS-KH-SCF-0199 			Mohanapriya
10				 V230830							NMC-JD-CRF-0102.2			Mohanapriya
-->
<%@page import="eBL.BLReportIdMapper"%>
<%@ page import="java.sql.*,java.util.*,java.io.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,eCommon.XSSRequestWrapper,  eCommon.Common.*, eBL.PreApprovalRequestDetailsBean " contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//V220324 Starts
	 request.setCharacterEncoding("UTF-8"); 
	 request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
	 //V220324 ends
%> 

<html>
<head>
<style>
	.billApproved{
		width: 12.5px;
		height: 12.5px;
		background: red;
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
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>	
<script language="JavaScript" src="../../eBL/js/BillingRecordApprovalScript.js"></script>
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
	
function callFunction(index)
{
		   
/*    alert('index '+index);
   alert($('#approval_status'+index).val());
 */   
   var approval_status=$('#approval_status'+index).val();
		   
   $('#approvalstatus_hdn').val(approval_status);  
}	   
	   
function isNegativeCheck(event)
{
   if ( event.which == 45 || event.which == 189 ) {
	   return false;  
	   // event.preventDefault();
	   }
		   
}
	   
	 
function isNumberEvent(evt,index,calledFrom)
{
		  
		   
   var qty = $('#approvedQty'+index).val();
   var amount =$('#approvedAmount'+index).val();
		   
   if(calledFrom=='approvedQty')
   {
   		if (  qty <= 0 || qty >= 0) {
		       
    								}
    	else {
        	if ( qty.length > 0 ) {

            alert(getMessage("NUM_ALLOWED", "SM"));
            $('#approvedQty'+index).val('');
            return false;
        							}
    		 }
		 
   }
   else if(calledFrom=='approvedAmount')
	{
				
	   if (  amount <= 0 || amount >= 0) {
			       
		}
	else {
			
		if ( amount.length > 0 ) 
		{
		alert(getMessage("NUM_ALLOWED", "SM"));
		$('#approvedAmount'+index).val('');
		return false;
		}
		}
	}
}   
	   
 async function authorize_check(index)
 {
	var order_status= $('#order_status'+index).val();
	order_status=$.trim(order_status);		
	var approval_stats= $('#approval_status'+index).val();
	var checkfor_authorise=$('#authorise_check').val();
	var authorisecheckforbilled=$('#authorise_check_billed').val();
	//alert("authorisecheckforbilled "+authorisecheckforbilled);
	var approvalstatus_hdn=$('#approvalstatus_hdn'+index).val();
		
	var called_from='';
	var user_id=$('#user_id').val();
	var approvalstatus_hdn=$('#approvalstatus_hdn').val();
	var site_spec_approval_sts_hdr =$('#site_spec_approval_sts').val();  // Added V190326-Dhananjay/MMS-DM-SCF-0612
	if((approvalstatus_hdn=='A' && site_spec_approval_sts_hdr == 'N') || (site_spec_approval_sts_hdr == 'Y')) // Added V190326-Dhananjay/MMS-DM-SCF-0612
	{
	if(order_status=="Billed" && approval_stats!=approvalstatus_hdn)
	{
		
		if(authorisecheckforbilled=='N')
		{
		
			called_from='Billed'
			var authcheck= await doUserAuthenticationValidation(user_id,called_from)
			//alert('authcheck '+authcheck);
			if(authcheck==false)
			{
			var dialogHeight= "14" ;
			var dialogWidth	= "22" ;
			var dialogTop = "225" ;
			var center = "1" ;														   
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;		
			var url="../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp?called_frm=EBL_TRANS_INS_RECORD_APPROVAL&loggeduser="+user_id;
				
			var retVal =await window.showModalDialog(url,arguments,features);
			if(retVal!=undefined)
			{
			
			var successUser=$.trim(retVal[0]);
			var success=$.trim(retVal[1]);
		/* 	
			alert("successUser "+successUser);
			alert("success "+success);
		 */	 if(successUser=='SuccessfulUser' && success=='Y')
				{
			$('#authorise_check_billed').val('Y');
				}
				
			else
				{
				$('#authorise_check_billed').val('N');	
				$('#approval_status'+index).val(approvalstatus_hdn);					
				}
			
			}
				
			else
				{
						
				$('#authorise_check_billed').val('N');	
					$('#approval_status'+index).val(approvalstatus_hdn);
						
					}
				}			
			}			
		}
		}		
 }	 
	 
function doUserAuthenticationValidation(successfulUser,calledFrom) {
	var retVal="";	
	$.ajax({
		type:"POST",
		url:"../jsp/UserAuthenticationPayerPolicyValidation.jsp",
		data:"successfulUser="+successfulUser+"&calledFromPage="+calledFrom,
		dataType:"text",
		async:false,
		success: function(data){
			//alert(data)
			retVal = $.trim(data);
			//alert(retval);
		},
		 error: function(data){
			 //alert(data)
	     }
	});
	
	//alert("retVal$$$$ "+retVal);
	if(retVal.indexOf('@@@SUCCESS@@@')==-1){ //If success string is not found return false
		return false;
	}else{		
		return true;	
	}
}
</script>
</head>
<style>
	div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 160px; 	/* must be greater than tbody*/
		overflow: auto;
		margin: 0 auto;
	}

table {
	width: 100%;		/*100% of container produces horiz. scroll in Mozilla*/
	border: none;
	background-color: #f7f7f7;
	}
	
table>tbody	{  /* child selector syntax which IE6 and older do not support*/
	overflow: auto; 
	height: 120x;
	overflow-x: hidden;
	}
	
thead tr	{
	position:relative; 
	top: expression(offsetParent.scrollTop); /*IE5+ only*/
	}		
</style>
<%
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
	//String applyMode																		=	new String();
	String locale																				=	"";
	String facilityId																			=	"";
	//String loggedInUser																			=	"";
	String mode																				=	"";
	mode																						=	"";
	String isUserCanAcess																		=	"";
	String bean_id																				=	"";
	String bean_name																			=	"";
	//String modifyStatus     																	=	"";
	String patinetId																			=	"";
	String episodeType																			=	"";
	String episodeId																			=	"";
	String visitId																				=	"";
	String priority																				=	"";
	String acctSeqNo																			=	"";
	//String authorized																			=	"";
	String encounterId																			=	"";
	//String billingGrpId																			=	"";
	String policyTypeCode																		=	"";
	String custGroupCode   																		=	"";
	String custCode   																			=	"";
	String policyNumber																			=	"";
	String copyIndex																			=	"";
	String requestStatus																		=	"";
	String approvedAmount																		=	"";
	String disable																				=	"DISABLED";
	String disableYN																			=	"DISABLED";//V230608
	String readOnlyYN																			="";


	String criteriaFilter = "";
	String bg_code_filter = "";
	String bg_desc_filter = "";
	String serviceDate_filter = "";
	String serviceAmount_filter = "";
	String serviceQuantity_filter = "";
	String apprReqDate_filter = "";
	String apprGvnDate_filter = "";
	String apprNo_filter = "";
	String approval_status_filter = "";
	String apprQty_filter = "";
	String apprAmt_filter = "";
	String reason_filter = "";
	String reason_hdn_filter = "";
	String remarks_filter = "";
	String userAuthorization = "";
	String encounterIdFilter=""; // Added by Vijay for mms crf 0077
	String orderStatusFilter=""; // Added by Vijay for mms crf 0077
	String siteId = "";
	String enabValue=""; 		//pradeepa - CRF 0165 Record approval
	String siteSpec="";	
	Boolean site_Specapproval_sts =false;	
	String siteSpecapprovalsts="";		// Added V190326-Dhananjay/MMS-DM-SCF-0612

			
	LinkedHashMap preApprovalRequestDetailsDataMap												=	null;
	//ArrayList<String[]>		preApprovalRequestDetailsList										=	null;
		
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	LinkedHashMap<String,String> criteriaMap = new LinkedHashMap<String,String>();
	String sysDateTime = "";

	String	strLoggedUser	=  "";
	//Added V200413 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	boolean site3TierAlmoFeature = false;
	String site3TierAlmoFeatureYN = "N";
	//Added V200413 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	//Added V200807 SHIKHA against NMC-JD-CRF-0042
	String Acolor = "";
	String Pcolor = "";
	String Hcolor = "";
	String Scolor = "";
	String Rcolor = "";
	String Ccolor = "";
	String AtimeLimit = "0";//V201014
	String PtimeLimit = "0";//V201014
	String HtimeLimit = "0";//V201014
	String StimeLimit = "0";//V201014
	String RtimeLimit = "0";//V201014
	String CtimeLimit = "0";//V201014
	boolean siteApprovalStatusColorCode = false;
	String siteApprovalStatusColorCodeYN = "N";
	//Ended V200807 SHIKHA against NMC-JD-CRF-0042
	//V220627 starts
	boolean siteRecAppRecalCharge = false;
	String siteRecAppRecalChargeYN = "";
	//V220627 ends
	String enableMCNNumberYN = ""; //V220905
	String MCN_no="";//V220905
	String calledForm="";//V230102
String enableYN="";//V230608 .testing
	//NMC-JD-CRF-0102.2
	String filePath = "";
	String pathExist="";
	String writeAccess="";
	PreparedStatement pstmt2 = null;
	ResultSet res2 = null;
	String membershipNo="";
	//NMC-JD-CRF-0102.2
	try  
	{	 
		sStyle 																					=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		locale 																					= 	(String)session.getAttribute("LOCALE");
		strLoggedUser																			=	(String) session.getValue("login_user");	
		if (strLoggedUser==null) strLoggedUser = "";

		facilityId																				=   (String) session.getValue( "facility_id" ) ;
		patinetId																				=	checkForNull(request.getParameter("patinetId"));
		enableMCNNumberYN																				=	checkForNull(request.getParameter("enableMCNNumberYN"));//V220905
		episodeType																				=	checkForNull(request.getParameter("episodeType"));
		episodeId																				=	checkForNull(request.getParameter("episodeId"));
		visitId																					=	checkForNull(request.getParameter("visitId"));
		priority																				=	checkForNull(request.getParameter("priority"));
		acctSeqNo																				=	checkForNull(request.getParameter("acctSeqNo"));
		encounterId																				=	java.net.URLDecoder.decode(checkForNull(request.getParameter("encounterId")));
		//billingGrpId																			=	checkForNull(request.getParameter("billingGrpId"));
		policyTypeCode																			=	checkForNull(request.getParameter("policyTypeCode"));
		custGroupCode																			=	checkForNull(request.getParameter("custGroupCode"));
		custCode																				=	checkForNull(request.getParameter("custCode"));
		policyNumber																			=	checkForNull(request.getParameter("policyNumber"));
		requestStatus																			=	checkForNull(request.getParameter("requestStatus"));
		approvedAmount																			=	checkForNull(request.getParameter("approvedAmount"));
		calledForm=	checkForNull(request.getParameter("calledForm"));//V230102
		membershipNo																			=	checkForNull(request.getParameter("membershipNo"));//102.2
		System.out.println("membershipNo "+membershipNo);
//V230608 testing starts
	enableYN																			=	checkForNull(request.getParameter("enableYN"));

//testing ends	

	
		String isDisabled="disabled"; //NMC-JD-CRF-0102.2

	
		criteriaFilter = checkForNull(request.getParameter("criteriaFilter"));
		bg_code_filter = checkForNull(request.getParameter("bg_code_filter"));
		bg_desc_filter = checkForNull(request.getParameter("bg_desc_filter"));
		serviceDate_filter = checkForNull(request.getParameter("serviceDate_filter"));
		serviceAmount_filter = checkForNull(request.getParameter("serviceAmount_filter"));
		serviceQuantity_filter = checkForNull(request.getParameter("serviceQuantity_filter"));
		apprReqDate_filter = checkForNull(request.getParameter("apprReqDate_filter"));
		apprGvnDate_filter = checkForNull(request.getParameter("apprGvnDate_filter"));
		apprNo_filter = checkForNull(request.getParameter("apprNo_filter"));
		approval_status_filter = checkForNull(request.getParameter("approval_status_filter"));
		apprQty_filter = checkForNull(request.getParameter("apprQty_filter"));
		MCN_no=checkForNull(request.getParameter("MCNnumber"));//V220909
		apprAmt_filter = checkForNull(request.getParameter("apprAmt_filter"));
		reason_filter = checkForNull(request.getParameter("reason_filter"));
		reason_hdn_filter = checkForNull(request.getParameter("reason_hdn_filter"));
		remarks_filter = checkForNull(request.getParameter("remarks_filter"));
		userAuthorization = checkForNull(request.getParameter("userAuthorization"));
		encounterIdFilter= checkForNull(request.getParameter("encounterIdFilter"));
		orderStatusFilter= checkForNull(request.getParameter("orderStatusFilter"));
		siteSpec=checkForNull(request.getParameter("site_spec"));
		System.out.println("site spec "+siteSpec);
		System.out.println("encounterId 432  "+encounterId);
		
		siteId = BLReportIdMapper.getCustomerId();
		preApprovalRequestDetailsDataMap														=	new LinkedHashMap();
		//System.err.println("BillingPreApprovalRequestDetails.jsp Request Param ::::::"+request.getQueryString());
	
		bean_id																					= 	"PreApprovalRequestDetailsBean" ;
		bean_name																				= 	"eBL.PreApprovalRequestDetailsBean";
		PreApprovalRequestDetailsBean preApprovalRequestDetailsBean								= 	(PreApprovalRequestDetailsBean)getBeanObject( bean_id, bean_name, request ) ;
		isUserCanAcess																			= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
		/* Added 3 more empty parameters/Added by Aravindh/11-04-2018/MMS-DM-CRF-0125 */
		preApprovalRequestDetailsDataMap														=	preApprovalRequestDetailsBean.getPreApprovalRequestDetailsData(patinetId, episodeType, episodeId, visitId, priority,requestStatus,acctSeqNo, facilityId, locale,custGroupCode,custCode,policyTypeCode,
				criteriaFilter,bg_code_filter,serviceDate_filter,serviceAmount_filter,serviceQuantity_filter,apprReqDate_filter,
				apprGvnDate_filter,apprNo_filter,approval_status_filter,apprQty_filter,apprAmt_filter,reason_hdn_filter,remarks_filter,encounterId,encounterIdFilter,orderStatusFilter,"","","");		
		System.out.println("hashmap, size=>"+preApprovalRequestDetailsDataMap.size());
		
		con = ConnectionManager.getConnection(request); 
		String sqlBillingService = "SELECT NVL(B.LIST_ELMT_LABEL,A.LIST_ELMT_LABEL) description FROM SM_LIST_ITEM A, SM_LIST_ITEM_DESC B WHERE A.MODULE_ID = 'BL' AND A.MODULE_ID = B.MODULE_ID (+) AND A.LIST_REF = B.LIST_REF (+) AND A.LIST_SRL_NO = B.LIST_SRL_NO (+) AND A.LIST_REF = 'L_SERV_INC_EXC_CR' AND B.LANGUAGE_ID (+) = ? and A.LIST_ELMT_VALUE = ? ";
		String blngServDesc = "";
	
		//String rowChange = "";	
	//Added V200807 SHIKHA against NMC-JD-CRF-0042
	try {		
		siteApprovalStatusColorCode = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","APPROVAL_STATUS_COLORCODE");
		if(siteApprovalStatusColorCode){
			siteApprovalStatusColorCodeYN ="Y";
		} else{
			siteApprovalStatusColorCodeYN ="N";
		}		
	} catch(Exception ex) {
		ex.printStackTrace();
	}
		
	try
	{
		String sqlRecordColor = "SELECT REQUEST_STATUS,SUBSTR(TIME_LIMIT,0,INSTR(TIME_LIMIT,':')-1)*60 + SUBSTR(TIME_LIMIT,INSTR(TIME_LIMIT,':')+1),COLOR_CODE FROM BL_COLOR_INDICATOR_RULE_STATUS WHERE facility_id = '"+facilityId+"'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(sqlRecordColor) ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  				
				if (rs.getString(1).equals("A")){
					Acolor = rs.getString(3); 
					AtimeLimit = rs.getString(2);
				} else if (rs.getString(1).equals("P")){
					Pcolor = rs.getString(3); 
					PtimeLimit = rs.getString(2);
				} else if (rs.getString(1).equals("S")){
					Scolor = rs.getString(3); 
					StimeLimit = rs.getString(2);
				} else if (rs.getString(1).equals("R")){
					Rcolor = rs.getString(3); 
					RtimeLimit = rs.getString(2);
				}else if (rs.getString(1).equals("H")){
					Hcolor = rs.getString(3); 
					HtimeLimit = rs.getString(2);
				} else if (rs.getString(1).equals("C")){
					Ccolor = rs.getString(3); 
					CtimeLimit = rs.getString(2);
				}
			}
		}		
		if(rs !=null) rs.close();
		stmt.close();						
	}
	catch(Exception e)
	{
		out.println("Exception @ BL_COLOR_INDICATOR_RULE_STATUS"+e);
		e.printStackTrace();
	}
	//Ended V200807 SHIKHA against NMC-JD-CRF-0042
	String sys_date = "";
	
	try
	{
		//Query Modified for MMS-CRF-0198.1
		String query_date="select to_char(sysdate,'dd/mm/yyyy'), to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') curr_time from dual";
		stmt = con.createStatement();
		rs = stmt.executeQuery(query_date) ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  				
				sys_date = rs.getString(1); 
				sysDateTime = rs.getString("curr_time");
			}
		}
		if(rs !=null) rs.close();
		stmt.close();
		
		String inclExclSql  =  	BlRepository.getBlKeyValue("POLICY_DEF_INCL_EXCL_CRITERIA");
		pstmt = con.prepareStatement(inclExclSql);
		pstmt.setString(1,locale);
		rst = pstmt.executeQuery();
		
		if(rst!=null){
			while(rst.next()){
				criteriaMap.put(rst.getString("code"),rst.getString("description"));
			}	
		}
		
		pstmt = null;
		rst = null;
	}
	catch(Exception e)
	{
		out.println("Exception @ sys_date_wht_sec"+e);
		e.printStackTrace();
	}
	
	//Added V200413 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	try {
		//con	=	ConnectionManager.getConnection(request); commented against checkstyle
		site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","3TIERALMOFEATURE");
		if (site3TierAlmoFeature) {
			site3TierAlmoFeatureYN = "Y";
		}else {
			site3TierAlmoFeatureYN = "N";
		}
	} catch(Exception ex) {
		System.err.println("Error in BillingPreApprovalRequestDetails.jsp for getting site3TierAlmoFeature Connection: "+ex);
		ex.printStackTrace();
	}
	//Added V200413 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1

	
	try {
		// Added V190326-Dhananjay/MMS-DM-SCF-0612/Starts
		site_Specapproval_sts = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_REC_APPR_USR_AUTH_VAL_APPR");
		System.out.println("site_Specapproval_sts"+site_Specapproval_sts);
		if(site_Specapproval_sts){
			siteSpecapprovalsts ="Y";
		} else{
			siteSpecapprovalsts ="N";
		}
		// Added V190326-Dhananjay/MMS-DM-SCF-0612/Ends	
	} catch(Exception ex) {
		ex.printStackTrace();
	}
		//Added V220627
		try {
			siteRecAppRecalCharge = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "RECAL_CHARGES");
			System.err.println("siteRecAppRecalCharge--" + siteRecAppRecalCharge);
			if (siteRecAppRecalCharge) {
				siteRecAppRecalChargeYN = "Y";
			} else {
				siteRecAppRecalChargeYN = "N";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		//V220627 ends
		//V221025
		String enableQueuePKID="N";
		boolean isEnablePkid=false; 
		try{
			isEnablePkid = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ENB_QMS_IN_BILL_GEN");
			if (isEnablePkid) {
				enableQueuePKID = "Y";
			}else {
				enableQueuePKID = "N";
			}
			System.err.println("enableQueuePKID "+enableQueuePKID);
		} catch(Exception ex) {
			System.err.println("Error in BillingPreApprovalRequestDetails.jsp for getting isEnablePkid Connection: "+ex);
			ex.printStackTrace();
		}//V221025
		
		//NMC-JD-CRF-0102.2
		boolean siteSpecUploadDoc=false; 
		String siteSpecUploadDocYN="N";
		try{
		
			siteSpecUploadDoc = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","REC_APPR_EXT_INT_ENABLED");
			System.out.println("siteSpecUploadDoc "+siteSpecUploadDoc);
			if(siteSpecUploadDoc){
				siteSpecUploadDocYN="Y";
			}
		} catch(Exception ex) {
			System.err.println("Error in BillingPreApprovalRequestDetails.jsp for getting siteSpecUploadDoc Connection: "+ex);
			ex.printStackTrace();
		}
		//NMC-JD-CRF-0102.2
	pstmt = con.prepareStatement(sqlBillingService);
%>
<body onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"    ; onSelect="codeArrestThruSelect();">
<%
if(siteSpecUploadDocYN.equals("Y")){
	%><form id="BillingPreApprovalRequestDetailsForm" name="BillingPreApprovalRequestDetailsForm" id="BillingPreApprovalRequestDetailsForm" enctype="multipart/form-data" >	
<%}else{%>
<form id="BillingPreApprovalRequestDetailsForm" name="BillingPreApprovalRequestDetailsForm" id="BillingPreApprovalRequestDetailsForm" >
<% }%>

	<table align='center'  cellpadding=2 cellspacing=0  width='100%' id="record_approval_details_table" name="record_approval_details_table" id="record_approval_details_table" border="1">		 
	<div id="tableContainer">
	<thead style="position: sticky;z-index: 1;top: 0;">
	<tr>
			<th class='CAFLOWSHEETLEVEL1'	nowrap	width="3%"	align="left">Status</th>
<!-- 						<th class='CAFLOWSHEETLEVEL1'	nowrap	width="3%"	align="left">test</th>
 -->	 	
				<% if(siteSpec.equals("true")){  %>
	 
 	<th class='CAFLOWSHEETLEVEL1' 	nowrap  width="3%"  align="left"><fmt:message key="Common.encounterid.label" 			bundle="${common_labels}"	/></th>
	<%} %> 		
	 		<th class='CAFLOWSHEETLEVEL1'	nowrap	width="9%"	align="left"><fmt:message key="eBL.INCLUDED_EXCLUDED.label" 		bundle="${bl_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="7%" 	align="left"><fmt:message key="eBL.BLNG_SERV_CODE.label" 			bundle="${bl_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="7%" 	align="left"><fmt:message key="eBL.BillingServiceDesc.label" 		bundle="${bl_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="7%" 	align="left"><fmt:message key="eBL.SERVICE_DATE.label" 				bundle="${bl_labels}"	/></th>
			<% if(siteSpec.equals("true")){ %>
			<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="7%" 	align="left"><fmt:message key="Common.OrderStatus.label" 			bundle="${common_labels}"	/></th>	
			<%} %>
			<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="7%" 	align="left"><fmt:message key="eBL.ServiceAmount.label" 			bundle="${bl_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="7%" 	align="left"><fmt:message key="eBL.ServiceQuantity.label" 			bundle="${bl_labels}"	/></th>  
			<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="8%" 	align="left"><fmt:message key="eBL.ApprovalRequiredDate.label" 		bundle="${bl_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="7%" 	align="left"><fmt:message key="eBL.ApprovalGivenDate.label" 		bundle="${bl_labels}"	/></th>
			<% if(enableMCNNumberYN.equals("Y")){%>
			<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="6%" 	align="left"><fmt:message key="eBL.MCNno.label" 			bundle="${bl_labels}"	/></th>
			<%}%><!--V220905-->
			<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="6%" 	align="left"><fmt:message key="eBL.ApprovalNumber.label" 			bundle="${bl_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="5%" 	align="left"><fmt:message key="Common.status.label" 				bundle="${common_labels}"/></th>
			<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="6%" 	align="left"><fmt:message key="eBL.APPROVED_QTY.label" 				bundle="${bl_labels}"/></th>  
			<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="7%" 	align="left"><fmt:message key="eBL.APPROVED_AMT.label" 				bundle="${bl_labels}"/></th>
			<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="7%" 	align="left"><fmt:message key="Common.reason.label" 				bundle="${common_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="4%" 	align="left"><fmt:message key="Common.remarks.label" 				bundle="${common_labels}"		/></th>
			<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="3%" 	align="left"><fmt:message key="Common.selectall.label" 				bundle="${common_labels}"		/></th>
			<!-- NMC-JD-CRF-0102.2-->
			<%
				if(siteSpecUploadDoc && episodeType.equals("O")){%>
				<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="3%" 	align="left"><fmt:message key="eBL.UploadDocuments.label" 				bundle="${bl_labels}"		/></th>
				<%
				}
			%>
			
	</tr>
	<tr>
		<td nowrap="nowrap">
		&nbsp;
		</td>
			<% if(siteSpec.equals("true")){ %>
		<td>
		
		<input type='text' name='encounterIdFilter' id='encounterIdFilter' id='encounterIdFilter' value='<%=encounterIdFilter%>'>
		
		</td>
		<%} %>
		<td  nowrap>
					<select name='criteriaFilter' id='criteriaFilter' style="width: 120px;">		
					<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>			
					<%
					for (Iterator iterator = criteriaMap.keySet().iterator(); iterator.hasNext();) {
						String type = (String) iterator.next();
						if(type.equals(criteriaFilter)){
					%>	
						<option value='<%=type%>' selected><%=criteriaMap.get(type) %></option>
						<%}
						else{%>
							<option value='<%=type%>'><%=criteriaMap.get(type) %></option>

					<%}
					}
					%>
					</select>
		</td>
		<td  nowrap align="left">
			<input type='text' id='bg_code_filter' name='bg_code_filter' id='bg_code_filter' size='10'   value='<%=bg_code_filter %>' onblur="if(this.value!=''){ callBGDescCode(2,criteriaFilter,bg_desc_filter,bg_code_filter); } else{ fnClearCode(bg_desc_filter); } " >
		</td>
		<td nowrap align="left">
			<input type='text' id='bg_desc_filter' name='bg_desc_filter' id='bg_desc_filter'  size='10'  value='<%=bg_desc_filter %>' onblur="if(this.value!=''){ callBGDesc(2,criteriaFilter,bg_desc_filter,bg_code_filter); } else{ fnClearCode(bg_code_filter); }">
			<input type='button' id='bg_but_filter' value='?'  onclick='callBGDesc(2,criteriaFilter,bg_desc_filter,bg_code_filter)' >					
			
		</td>
		<td nowrap align="left">
			<input type='text' id='serviceDate_filter' name='serviceDate_filter' id='serviceDate_filter' value='<%=serviceDate_filter %>' size='8' onblur='isValidDate(this);'>
			<img src='../../eCommon/images/CommonCalendar.gif' id='serviceDate_ctrl_filter' onClick='return showCalendar("serviceDate_filter")' />
			
		</td>
			<% if(siteSpec.equals("true")){ %>
		<td nowrap align="left">
		 	<input type='text' id='orderStatusFilter' name='orderStatusFilter' id='orderStatusFilter' value='<%=orderStatusFilter %>' size='8' onblur=''>
		
		</td>
		<%} %>
		
		<td nowrap align="left">
			<input type='text' id='serviceAmount_filter' name='serviceAmount_filter' id='serviceAmount_filter' value='<%=serviceAmount_filter %>' size='10' >
		</td>
		<td nowrap align="left">
			<input type='text' id='serviceQuantity_filter' name='serviceQuantity_filter' id='serviceQuantity_filter' value='<%=serviceQuantity_filter %>' size='10' >
		</td>
		<td nowrap align="left">
			<input type='text' id='apprReqDate_filter' name='apprReqDate_filter' id='apprReqDate_filter' value='<%=apprReqDate_filter %>' size='8' onblur='isValidDate(this);'>
			<img src='../../eCommon/images/CommonCalendar.gif' id='apprReqDate_ctrl_filter' onClick='return showCalendar("apprReqDate_filter")' />			
		</td>
		<td nowrap align="left">
			<input type='text' id='apprGvnDate_filter' name='apprGvnDate_filter' id='apprGvnDate_filter' value='<%=apprGvnDate_filter %>' size='8' onblur='isValidDate(this);'>
			<img src='../../eCommon/images/CommonCalendar.gif' id='apprGvnDate_ctrl_filter' onClick='return showCalendar("apprGvnDate_filter")' />						
		</td>
		<% if(enableMCNNumberYN.equals("Y")){%>
		<td nowrap align="left">
			<input type='text' id='MCN_no' name='MCN_no' id='MCN_no' value='<%=MCN_no %>' onkeypress='return CheckForSpecChars_loc(event,this)'  onBlur='CheckForSpecChar(event,this)' size='10' maxlength='50' >
		</td>
		<%}%><!--V220905-->
		<td nowrap align="left">
			<input type='text' id='apprNo_filter' name='apprNo_filter' id='apprNo_filter' value='<%=apprNo_filter %>' size='10' >
		</td>
		<td nowrap>
			<select id="approval_status_filter"	name="approval_status_filter" id="approval_status_filter" style="width: 60px;">
			<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
				<option value="A"  <%=("A".equals(approval_status_filter))?"selected":"" %> >Approved</option>
				<option value="R" <%=("R".equals(approval_status_filter))?"selected":"" %> >Rejected</option>
				<option value="P" <%=("P".equals(approval_status_filter))?"selected":"" %> >Pending</option>
				<option value="S" <%=("S".equals(approval_status_filter))?"selected":"" %> >Send to Insurance</option>
				<option value="H" <%=("H".equals(approval_status_filter))?"selected":"" %> >Hold</option>
				<option value="C" <%=("C".equals(approval_status_filter))?"selected":"" %> >Clarification</option>				
			</select>
		</td>
		<td nowrap align="left">
			<input type='text' id='apprQty_filter' name='apprQty_filter' id='apprQty_filter' value='<%=apprQty_filter %>' size='10' >
		</td>
		<td nowrap align="left">
			<input type='text' id='apprAmt_filter' name='apprAmt_filter' id='apprAmt_filter' value='<%=apprAmt_filter %>' size='10' >
		</td>
		<td nowrap>
			<input type='text' id='reason_filter' name='reason_filter' id='reason_filter' value='<%=reason_filter %>' size='10' >
			<input type='hidden' id='reason_hdn_filter' name='reason_hdn_filter' id='reason_hdn_filter' value='<%=reason_hdn_filter %>' >
			&nbsp;
			<input type='button' class='button' name="reason_lookup_filter" id="reason_lookup_filter" id="reason_lookup_filter" value='?' onClick="reasonCodeLookupFilter(reason_filter,reason_hdn_filter)" 	/>
			
		</td>
		<td nowrap>
			<input type='text' id='remarks_filter' name='remarks_filter' id='remarks_filter' value='<%=remarks_filter %>' size='10' >
		</td>
	</tr>
	</thead>
	
	<TBODY style="height: 20px;">
	<% 
	Iterator iterator= preApprovalRequestDetailsDataMap.keySet().iterator();
	int rows=0;
	while(iterator.hasNext())
	{
		
		int index =    (Integer)iterator.next();
		rows=rows+1;
		System.out.println("IN getPreApprovalRequestDetailsData index:::::::"+index);
		preApprovalRequestDetailsBean = (PreApprovalRequestDetailsBean) preApprovalRequestDetailsDataMap.get(index);  
		/*	System.out.println("INDEX::: "+index+" ::::p_patient_class::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getPatientClass());
			System.out.println("INDEX::: "+index+" ::::p_episode_or_encounter_flag::::::::::: "+preApprovalRequestDetailsBean.getEpisodeEncounterFlag());
			System.out.println("INDEX::: "+index+" ::::p_clinic_nursing_ind:::::::::::::::::: "+preApprovalRequestDetailsBean.getClinicNursingIndicator());
			System.out.println("INDEX::: "+index+" ::::p_clinic_nursing_code::::::::::::::::: "+preApprovalRequestDetailsBean.getClinicNursingCode());
			System.out.println("INDEX::: "+index+" ::::p_splty_code:::::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getSpecialiltyCode());
			System.out.println("INDEX::: "+index+" ::::p_sex::::::::::::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getSex());
			System.out.println("INDEX::: "+index+" ::::p_age_group_code:::::::::::::::::::::: "+preApprovalRequestDetailsBean.getAgeGroupCode());
			System.out.println("INDEX::: "+index+" ::::p_blng_serv_code:::::::::::::::::::::: "+preApprovalRequestDetailsBean.getBillingServiceCode());
			System.out.println("INDEX::: "+index+" ::::p_serv_excl_incl_crit::::::::::::::::: "+preApprovalRequestDetailsBean.getIncludedExcluded());
			System.out.println("INDEX::: "+index+" ::::p_effective_from:::::::::::::::::::::: "+preApprovalRequestDetailsBean.getEffectiveFrom());
			System.out.println("INDEX::: "+index+" ::::p_effective_to:::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getEffectiveTo());
			System.out.println("INDEX::: "+index+" ::::p_preapproval_amt_capping::::::::::::: "+preApprovalRequestDetailsBean.getApprovalAmountCapping());
			System.out.println("INDEX::: "+index+" ::::p_preapproval_qty_capping::::::::::::: "+preApprovalRequestDetailsBean.getApprovalQuantityCapping());
			System.out.println("INDEX::: "+index+" ::::p_preapproval_amt_gross_net::::::::::: "+preApprovalRequestDetailsBean.getApprovalGrossNetAmount());
			System.out.println("INDEX::: "+index+" ::::p_service_level_approval_yn::::::::::: "+preApprovalRequestDetailsBean.getServiceLevelApprovalFlag());
			System.out.println("INDEX::: "+index+" ::::p_pre_app_num::::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getApprovalNumber());
			System.out.println("INDEX::: "+index+" ::::p_app_req_date:::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getApprovalRequiredDate());
			System.out.println("INDEX::: "+index+" ::::p_app_given_date:::::::::::::::::::::: "+preApprovalRequestDetailsBean.getApprovalGivenDate());
			System.out.println("INDEX::: "+index+" ::::p_pre_app_status:::::::::::::::::::::: "+preApprovalRequestDetailsBean.getStatus());
			System.out.println("INDEX::: "+index+" ::::p_pre_app_remark:::::::::::::::::::::: "+preApprovalRequestDetailsBean.getRemarks());
			System.out.println("INDEX::: "+index+" ::::p_reason_code::::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getReason());
			System.out.println("INDEX::: "+index+" ::::p_utilized_amount::::::::::::::::::::: "+preApprovalRequestDetailsBean.getUtilizedAmount());
			System.out.println("INDEX::: "+index+" ::::p_utilized_qty:::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getUtilizedQuantity());
			System.out.println("INDEX::: "+index+" ::::p_primary_key_facility_id::::::::::::: "+preApprovalRequestDetailsBean.getPrimaryKeyFacilityId());
			System.out.println("INDEX::: "+index+" ::::p_primary_key_module_id::::::::::::::: "+preApprovalRequestDetailsBean.getPrimaryKeyModuleId());
			System.out.println("INDEX::: "+index+" ::::p_primary_key_main:::::::::::::::::::: "+preApprovalRequestDetailsBean.getPrimaryKeyMain());
			System.out.println("INDEX::: "+index+" ::::p_primary_key_line_no::::::::::::::::: "+preApprovalRequestDetailsBean.getPrimaryKeyLineNo());
			System.out.println("INDEX::: "+index+" ::::p_primary_key_blng_serv_code:::::::::: "+preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceCode());
			System.out.println("INDEX::: "+index+" ::::p_primary_key_serv_item_code:::::::::: "+preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceItemCode());
			System.out.println("INDEX::: "+index+" ::::p_serv_desc::::::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceItemCode());
			System.out.println("INDEX::: "+index+" ::::p_service_date:::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceItemCode());
			System.out.println("INDEX::: "+index+" ::::p_serv_desc::::::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getBillingServiceDesc());
			System.out.println("INDEX::: "+index+" ::::p_service_date:::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getServiceDate());
			*/
			
			System.err.println("INSIDE enableYN "+enableYN);
	if(enableYN.equals("Y")){
		if((!siteId.equals("ALMO") || (preApprovalRequestDetailsBean.getBillApprovedYN().equals("N"))) || (!site3TierAlmoFeatureYN.equals("Y") || preApprovalRequestDetailsBean.getBillApprovedYN().equals("N"))){ 
					disable="";	
					disableYN="disabled";
					readOnlyYN="readOnly";
					enabValue="Y";
		}
		//NMC-JD-CRF-0102.2
		if(siteSpecUploadDoc && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("C") && episodeType.equals("O")){
			isDisabled="";
		}
		System.err.println("INSIDE ENABLE ");
		//To check config done for upload document
		if(siteSpecUploadDoc && episodeType.equals("O")){
		  try{
			// Query to get file path for copying uploaded doc STARTS here
			String sqlFilePath = "select record_appr_doc_path from bl_parameters where OPERATING_FACILITY_ID = ? ";
			pstmt2 = con.prepareStatement(sqlFilePath);
			pstmt2.setString(1,facilityId);
			
			res2 = pstmt2.executeQuery();
			while(res2.next())
			{
				filePath = res2.getString(1) == null ? "" : res2.getString(1);
			}
			System.out.println("filePath in jsp "+filePath);
			if(res2 != null) res2.close();
			if(pstmt2 != null) pstmt2.close(); 
			
			//filePath = filePath.replace("\\", "/");
			System.out.println("filePath  1 "+filePath);
			String separator = System.getProperty( "file.separator" );
			File f = new File(filePath);
			if(f.exists())
			{
				pathExist="true";
				File file1 = new File(filePath+separator+System.currentTimeMillis()+".txt"); 
				try
				{
					if (file1.createNewFile())
					{
						writeAccess="true";
						file1.delete();
					}
					else
					{
						writeAccess="false";
					}
				}
				catch (IOException e)
		        {
					writeAccess="false";
		        }
			}
			else
			{
				pathExist="false";
			}
			System.out.println("billingpreapproval filePath after:" + filePath);
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in try of billingpreapproval jsp --"+e.toString());
			e.printStackTrace();
		}
		}
		System.out.println("929");
	}//V230608-NMC-JD-CRF-0102.2
			
	
	//Added V200807 SHIKHA against NMC-JD-CRF-0042
	//  int preAppStatusMaxDateTime =0; //V201013//checklist
	  String bgcolor = "";
	if ( siteApprovalStatusColorCode) {
	//V201024 commented try & catch	
		/*
	  try {
		  String preApprStatusStr = "select NVL(cast ((sysdate - max(PRE_APP_STATUS_DATE)) * 24 * 60 as int),0) from bl_ins_preappr_ser_lvl_dtlslog where OPERATING_FACILITY_ID= '"+facilityId+"' and patient_id ='"+patinetId +"' and episode_type ='"+episodeType+"' and  episode_id ='"+episodeId+"' and visit_id = '"+visitId
				  +"' and acct_seq_no='"+acctSeqNo+"'  and priority='"+priority+"' and PRIMARY_KEY_BLNG_SERV_CODE = '"+preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceCode()+"' and PRIMARY_KEY_MAIN='"+preApprovalRequestDetailsBean.getPrimaryKeyMain()+"' and PRIMARY_KEY_LINE_NO='"+preApprovalRequestDetailsBean.getPrimaryKeyLineNo()+"'";
		  stmt = con.createStatement();		
		  rs = stmt.executeQuery(preApprStatusStr) ;
					
		  if( rs != null ) 
			{
				while( rs.next() )
				{  				
					preAppStatusMaxDateTime = rs.getInt(1);
				}
			}		
			if(rs !=null) rs.close();
			stmt.close();		  
	  } catch(Exception e) {
		e.printStackTrace();  
	  }	  */
	  if (preApprovalRequestDetailsBean.getColorStatus().equals("Y")) { //V201024 added
		  if (preApprovalRequestDetailsBean.getStatus().equals("P")) {
			  //if (preAppStatusMaxDateTime > Integer.parseInt(PtimeLimit)) { //V201024 commented			
				  bgcolor = "style=background-color:"+Pcolor;
				  //}  //V201024 commented
		  } else if (preApprovalRequestDetailsBean.getStatus().equals("A")) {
			  if ( !preApprovalRequestDetailsBean.getApprovalNumber().equals("Default Approved")) {					  
				 // if (preAppStatusMaxDateTime > Integer.parseInt(AtimeLimit)) { //V201024 commented
						bgcolor = "style=background-color:"+Acolor;						
					//  }  //V201024 commented
			  }
		  }else if (preApprovalRequestDetailsBean.getStatus().equals("H")) {		  
			  //if (preAppStatusMaxDateTime > Integer.parseInt(HtimeLimit)) { //V201024 commented
					bgcolor = "style=background-color:"+Hcolor;
				//  }  //V201024 commented
		  }else if (preApprovalRequestDetailsBean.getStatus().equals("C")) {			
			  //if (preAppStatusMaxDateTime > Integer.parseInt(CtimeLimit)) { //V201024 commented
					bgcolor = "style=background-color:"+Ccolor;
				//  }  //V201024 commented
		  }else if (preApprovalRequestDetailsBean.getStatus().equals("S")) {
			  //if (preAppStatusMaxDateTime > Integer.parseInt(StimeLimit)) {//V201024 commented
					bgcolor = "style=background-color:"+Scolor;
				//  }  //V201024 commented
		  }else if (preApprovalRequestDetailsBean.getStatus().equals("R")) {
			//  if (preAppStatusMaxDateTime > Integer.parseInt(RtimeLimit)) {//V201024 commented
				bgcolor = "style=background-color:"+Rcolor;
			 // }  //V201024 commented
		  } 
	  }
	}
	//Ended V200807 SHIKHA against NMC-JD-CRF-0042	  
	%>
			<tr> 
				<td nowrap="nowrap">
					<%if("Y".equals(preApprovalRequestDetailsBean.getBillApprovedYN())){ %>
						<span class='billApproved'></span>
					<%} else{ %>
						&nbsp;
					<%} %>
				</td>
				<%

					pstmt.setString(1,locale);
					pstmt.setString(2,preApprovalRequestDetailsBean.getIncludedExcluded());
					rst = pstmt.executeQuery();
					if(rst != null){
						while(rst.next()){
							blngServDesc = rst.getString("description");
						}
					}
					
				%>
				<% if(siteSpec.equals("true")){ %>
			 	<td nowrap class="fields" 	width="10%"	><input type="text" name="encounter_id<%=index%>" id="encounter_id<%=index%>"  title="<%=preApprovalRequestDetailsBean.getEncounterId()			!=	null	?	preApprovalRequestDetailsBean.getEncounterId()		:	""	 %>" 		value="<%=preApprovalRequestDetailsBean.getEncounterId()			!=	null	?	preApprovalRequestDetailsBean.getEncounterId()		:	""	 %>" size="15"  readonly /></td>
				  <%} %>
				<td  nowrap class="fields" 	width="10%"		><select id="included_excluded<%=index%>"							name="included_excluded<%=index%>"			style="width: 120px;"	<%=disable%>  <%=readOnlyYN%> > <option value=<%=preApprovalRequestDetailsBean.getIncludedExcluded()	!=	null	?	preApprovalRequestDetailsBean.getIncludedExcluded()	:	""	 %> ><%= blngServDesc	!=	null	?	blngServDesc	:	""	 %></option></select></td>		
				
				
				<td nowrap class="fields"	width="7%" 		>				
				<input type="hidden"	id="billing_service_code<%=index%>"				name="billing_service_code<%=index%>"		title="<%=preApprovalRequestDetailsBean.getBillingServiceCode()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceCode()		:	""	 %>" 		value="<%=preApprovalRequestDetailsBean.getBillingServiceCode()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceCode()		:	""	 %>"  />
				<input type="text"	id="billing_service_display<%=index%>"				name="billing_service_display<%=index%>"		title="<%=preApprovalRequestDetailsBean.getBillingServiceDisplay()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceDisplay()		:	""	 %>" 		value="<%=preApprovalRequestDetailsBean.getBillingServiceDisplay()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceDisplay()		:	""	 %>" size="10"	<%=disable%> <%=disableYN%> <%=readOnlyYN %> />
				</td>				
				 
				<td nowrap class="fields"	width="7%" 		><input type="text" id="billing_service_desc<%=index%>"	name="billing_service_desc<%=index%>" 		title="<%=preApprovalRequestDetailsBean.getBillingServiceDesc()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceDesc()		:	""	 %>" 		value="<%=preApprovalRequestDetailsBean.getBillingServiceDesc()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceDesc()		:	""	 %>" size="11"	<%=disable%> <%=readOnlyYN %> /></td>
				<td nowrap class="fields" 	width="8%"		><input type="text" id="service_date<%=index%>"						name="service_date<%=index%>"		  		title="<%=preApprovalRequestDetailsBean.getServiceDate()				!=	null	?	preApprovalRequestDetailsBean.getServiceDate()				:	""	 %>" 		value="<%=preApprovalRequestDetailsBean.getServiceDate()				!=	null	?	preApprovalRequestDetailsBean.getServiceDate()				:	""	 %>" size="7"	<%=disable%> <%=readOnlyYN%> /><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('service_date<%=index%>');"  onKeyPress="return lockbackSpace();"	<%=disable%>  name="service_date_cal<%=index%>" id="service_date_cal<%=index%>"></td> 
				<% if(siteSpec.equals("true")){ %>
				<td nowrap class="fields" 	width="8%"		><input type="text" id="order_status<%=index%>"						name="order_status<%=index%>"		  		title="<%=preApprovalRequestDetailsBean.getOrderStatus()				!=	null	?	preApprovalRequestDetailsBean.getOrderStatus()				:	""	 %>" 		value="<%=preApprovalRequestDetailsBean.getOrderStatus()				!=	null	?	preApprovalRequestDetailsBean.getOrderStatus()				:	""	 %>" size="7"	<%=disable%> <%=disableYN%> /></td> 			
				<%} %>
				<td nowrap class="fields" 	width="7%"		><input type="text" id="available_service_amount<%=index%>"			name="available_service_amount<%=index%>"	title="<%=preApprovalRequestDetailsBean.getUtilizedAmount()				!=	null	?	preApprovalRequestDetailsBean.getUtilizedAmount()			:	""	 %>" 		value="<%=preApprovalRequestDetailsBean.getUtilizedAmount()				!=	null	?	preApprovalRequestDetailsBean.getUtilizedAmount()			:	""	 %>" size="10"	<%=disable%> <%=readOnlyYN%>	 /></td>
				 <td nowrap class="fields" 	width="7%"		><input type="text" id="available_service_qty<%=index%>"			name="available_service_qty<%=index%>"	title="<%=preApprovalRequestDetailsBean.getServiceQty()				!=	null	?	preApprovalRequestDetailsBean.getServiceQty()			:	""	 %>" 		value="<%=preApprovalRequestDetailsBean.getServiceQty()				!=	null	?	preApprovalRequestDetailsBean.getServiceQty()			:	""	 %>" size="10"	<%=disable%> <%=readOnlyYN%>	 /></td>
				<td nowrap class="fields" 	width="8%"		><input type="hidden" name="p_app_req_date<%=index%>" id="p_app_req_date<%=index%>"  value ="<%=preApprovalRequestDetailsBean.getApprovalRequiredDate()	%>" ><input type="text" id="app_req_date<%=index%>"	 name="app_req_date<%=index%>"				title="<%=preApprovalRequestDetailsBean.getApprovalRequiredDate()			!=	null	?	preApprovalRequestDetailsBean.getApprovalRequiredDate()		:	""	 %>" 		value="<%=preApprovalRequestDetailsBean.getApprovalRequiredDate()		!=	null	?	preApprovalRequestDetailsBean.getApprovalRequiredDate()		:	""	 %>" size="7"	<%=disable%> onblur="CopyValue('<%=index%>');"		onchange="CopyValue('<%=index%>')"   /><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('app_req_date<%=index%>');" name="approved_req_cal<%=index%>" id="approved_req_cal<%=index%>" onKeyPress="return lockbackSpace();"  <%=disable%>	onClick="CopyValue('<%=index%>');" ></td>
				<td nowrap class="fields" 	width="8%"		><input type="hidden" name="p_approved_date<%=index%>" id="p_approved_date<%=index%>"  value ="<%= preApprovalRequestDetailsBean.getApprovalGivenDate().length() > 0 	?	preApprovalRequestDetailsBean.getApprovalGivenDate()		:	sys_date	 %>"><input type="text" id="approved_date<%=index%>"					name="approved_date<%=index%>"				title="<%=preApprovalRequestDetailsBean.getApprovalGivenDate().length() > 0 ?	preApprovalRequestDetailsBean.getApprovalGivenDate()		:	sys_date	 %>" 		value="<%= preApprovalRequestDetailsBean.getApprovalGivenDate().length() > 0 	?	preApprovalRequestDetailsBean.getApprovalGivenDate()		:	sys_date	 %>" size="7"	<%=disable%>		onblur="CopyValue('<%=index%>');"       onchange="CopyValue('<%=index%>')"   /><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('approved_date<%=index%>');" name="approved_given_cal<%=index%>" id="approved_given_cal<%=index%>" onKeyPress="return lockbackSpace();"  <%=disable%>	onClick="CopyValue('<%=index%>');" ></td>
				<% if(enableMCNNumberYN.equals("Y")){%>
					<td nowrap class="fields" 	width="6%"		><input type="hidden" name="p_MCN_number<%=index%>" id="p_MCN_number<%=index%>"  value ="<%=preApprovalRequestDetailsBean.getMcnNumber()				!=	null	?	preApprovalRequestDetailsBean.getMcnNumber()			:	""	 %>"> 
					<input type="text" id="MCN_number<%=index%>"					name="MCN_number<%=index%>"			title="<%=preApprovalRequestDetailsBean.getMcnNumber()				!=	null	?	preApprovalRequestDetailsBean.getMcnNumber()			:	""	 %>" 		value="<%=preApprovalRequestDetailsBean.getMcnNumber()				!=	null	?	preApprovalRequestDetailsBean.getMcnNumber()			:	""	 %>" size="10"  <%=disable%>	 	onkeypress='return CheckForSpecChars_loc(event,this)' onchange="checkMCNsts('<%=index%>');CopyData('<%=index%>')"  onBlur='CheckForSpecChar(event,this)' maxlength="50" /></td><!--V220905-->
				<%}%>
				
				<td nowrap class="fields" 	width="6%"		><input type="hidden" name="p_approval_number<%=index%>" id="p_approval_number<%=index%>"  value ="<%=preApprovalRequestDetailsBean.getApprovalNumber()				!=	null	?	preApprovalRequestDetailsBean.getApprovalNumber()			:	""	 %>">
				<input type="text" id="approval_number<%=index%>"					name="approval_number<%=index%>"			title="<%=preApprovalRequestDetailsBean.getApprovalNumber()				!=	null	?	preApprovalRequestDetailsBean.getApprovalNumber()			:	""	 %>" 		value="<%=preApprovalRequestDetailsBean.getApprovalNumber()				!=	null	?	preApprovalRequestDetailsBean.getApprovalNumber()			:	""	 %>" size="10"  <%=disable%>	 	onchange="CopyValue('<%=index%>')"  maxlength="20" /></td>
				
				<td nowrap class="fields" 	width="5%"		>
				<input type="hidden" name="p_approval_status<%=index%>" id="p_approval_status<%=index%>" id="p_approval_status<%=index%>"  value ="<%=preApprovalRequestDetailsBean.getStatus() !=null ? preApprovalRequestDetailsBean.getStatus() : "P" %>">
				<select id="approval_status<%=index%>"							name="approval_status<%=index%>"			style="width: 60px;"	<%=disable%>    onFocus="callFunction('<%=index%>')";      onchange="defaultGivenDate('<%=index%>');CopyValue('<%=index%>');  authorize_check('<%=index%>'); isChanged(this,'apprSts','<%=index%>'); ckckStatus('<%=index%>');"> <!--V220627-->
				<option <%=bgcolor %> value="A" <%=preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("A") ? "SELECTED" : "" %> >Approved</option>
				<option <%=bgcolor %> value="R" <%=preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("R") ? "SELECTED" : "" %> >Rejected</option>
				<option <%=bgcolor %> value="P"  <%=preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("P") ? "SELECTED" : "" %> >Pending</option>
				<option <%=bgcolor %> value="S" <%=preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("S") ? "SELECTED" : "" %> >Send to Insurance</option>
				<option <%=bgcolor %> value="H" <%=preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("H") ? "SELECTED" : "" %> >Hold</option>
				<option <%=bgcolor %> value="C" <%=preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("C") ? "SELECTED" : "" %> >Clarification</option>				
				</select>
			 	<input type="hidden" name="approvalstatus_hdn<%=index%>" id="approvalstatus_hdn<%=index%>" id="approvalstatus_hdn<%=index%>" value="<%=preApprovalRequestDetailsBean.getStatus() != null ? preApprovalRequestDetailsBean.getStatus():""  %>">
				<input type='hidden' name='prevSts<%=index%>' id='prevSts<%=index%>'	id='prevSts<%=index%>'	 value="<%=preApprovalRequestDetailsBean.getStatus() !=null ? preApprovalRequestDetailsBean.getStatus() : "P" %>" ><!-- V221129 -->
				</td>
				
				<td nowrap class="fields" 	width="6%"		><input type="hidden" name="p_approvedQty<%=index%>" id="p_approvedQty<%=index%>"  value ="<%=preApprovalRequestDetailsBean.getApprovedQty()				!=	null	?	preApprovalRequestDetailsBean.getApprovedQty()			:	""	 %>"><input type="text" id="approvedQty<%=index%>"					name="approvedQty<%=index%>"			title="<%=preApprovalRequestDetailsBean.getApprovedQty()				!=	null	?	preApprovalRequestDetailsBean.getApprovedQty()			:	""	 %>" 		value="<%=preApprovalRequestDetailsBean.getApprovedQty()				!=	null	?	preApprovalRequestDetailsBean.getApprovedQty()			:	""	 %>" size="10"  <%=disable%>		onchange="CopyValue('<%=index%>')"  onBlur="isNumberEvent(event,'<%=index %>','approvedQty');isChanged(this,'apprQty','<%=index%>');"   onkeypress="return isNegativeCheck(event);" /></td><!--V220627-->
				<td nowrap class="fields" 	width="7%"		><input type="hidden" name="p_approvedAmount<%=index%>" id="p_approvedAmount<%=index%>"  value ="<%=preApprovalRequestDetailsBean.getApprovedAmount()				!=	null	?	preApprovalRequestDetailsBean.getApprovedAmount()			:	""	 %>"><input type="text" id="approvedAmount<%=index%>"					name="approvedAmount<%=index%>"			title="<%=preApprovalRequestDetailsBean.getApprovedAmount()				!=	null	?	preApprovalRequestDetailsBean.getApprovedAmount()			:	""	 %>" 		value="<%=preApprovalRequestDetailsBean.getApprovedAmount()				!=	null	?	preApprovalRequestDetailsBean.getApprovedAmount()			:	""	 %>" size="10"  <%=disable%>		onchange="CopyValue('<%=index%>')"  onBlur="isNumberEvent(event,'<%=index %>','approvedAmount');isChanged(this,'apprAmt','<%=index%>');"  onkeypress=""  /></td>			<!--V220627-->	 
				<td nowrap class="fields" 	width="7%"		><input type="hidden" name="p_reason<%=index%>" id="p_reason<%=index%>"  value ="<%=preApprovalRequestDetailsBean.getReason()						!=	null	?	preApprovalRequestDetailsBean.getReason()					:	""	 %>"><input type="text" id="reason<%=index%>"							name="reason<%=index%>"						title="<%=preApprovalRequestDetailsBean.getReason()						!=	null	?	preApprovalRequestDetailsBean.getReason()					:	""	 %>" 		value="<%=preApprovalRequestDetailsBean.getReason()						!=	null	?	preApprovalRequestDetailsBean.getReason()					:	""	 %>" size="5"	<%=disable%>		onchange="CopyValue('<%=index%>')"   /><input type='button' class='button' name="reason_lookup<%=index%>" id="reason_lookup<%=index%>" id="reason_lookup<%=index%>" value='?' onClick="return reasonCodeLookup('<%=index%>')"  tabindex='2' <%=disable%>	/></td>
				<td nowrap class="fields" 	width="4%"		><input type="hidden" name="p_approval_remarks<%=index%>" id="p_approval_remarks<%=index%>"  value ="<%=preApprovalRequestDetailsBean.getRemarks()					!=	null	?	preApprovalRequestDetailsBean.getRemarks()					:	""	 %>"><input type="text" id="approval_remarks<%=index%>"					name="approval_remarks<%=index%>"			title="<%=preApprovalRequestDetailsBean.getRemarks()					!=	null	?	preApprovalRequestDetailsBean.getRemarks()					:	""	 %>" 		value="<%=preApprovalRequestDetailsBean.getRemarks()					!=	null	?	preApprovalRequestDetailsBean.getRemarks()					:	""	 %>" size="4"	<%=disable%>		onchange="CopyValue('<%=index%>')"   /></td> 
				<td nowrap class="fields" 	width="3%"		><input type='Checkbox'	<%=disable%> id="select_all<%=index%>" name="select_all<%=index%>" 	align="left" 	onclick="copySelected('<%=index%>')" /></td> 
				<!-- NMC-JD-CRF-0102.2-->
				<input type="hidden"   id="primary_key_main<%=index%>" 			name="primary_key_main<%=index%>"  			value="<%=preApprovalRequestDetailsBean.getPrimaryKeyMain()				!=null 		? 	preApprovalRequestDetailsBean.getPrimaryKeyMain()			: 	"" 	 %>" />
				<input type="hidden"   id="primary_key_line_no<%=index%>" 			name="primary_key_line_no<%=index%>"  		value="<%=preApprovalRequestDetailsBean.getPrimaryKeyLineNo()			!=null 		? 	preApprovalRequestDetailsBean.getPrimaryKeyLineNo()			: 	"" 	 %>" />
				<%-- <input type='hidden' name='docSrlNo<%=index%>' id='docSrlNo<%=index%>' id='docSrlNo<%=index%>' value='0'>
				 --%><!-- NMC-JD-CRF-0102.2-->
				 <input type="hidden"   id="effective_from<%=index%>" 				name="effective_from<%=index%>"  			value="<%=preApprovalRequestDetailsBean.getEffectiveFrom()  			!=null 		? 	preApprovalRequestDetailsBean.getEffectiveFrom()			: 	"" 	 %>" />
				<input type="hidden"   id="effective_to<%=index%>" 				name="effective_to<%=index%>"  				value="<%=preApprovalRequestDetailsBean.getEffectiveTo()	  			!=null 		? 	preApprovalRequestDetailsBean.getEffectiveTo()				: 	"" 	 %>" />
				<input type="hidden"   id="patient_class<%=index%>" 				name="patient_class<%=index%>"  			value="<%=preApprovalRequestDetailsBean.getPatientClass()				!=null 		? 	preApprovalRequestDetailsBean.getPatientClass()				: 	"" 	 %>" />
				<input type="hidden"   id="episode_encounter_flag<%=index%>"		name="episode_encounter_flag<%=index%>"  	value="<%=preApprovalRequestDetailsBean.getEpisodeEncounterFlag()		!=null 		? 	preApprovalRequestDetailsBean.getEpisodeEncounterFlag()		: 	"" 	 %>" />
				<input type="hidden"   id="clinic_nursing_ind<%=index%>" 			name="clinic_nursing_ind<%=index%>"  		value="<%=preApprovalRequestDetailsBean.getClinicNursingIndicator()		!=null 		? 	preApprovalRequestDetailsBean.getClinicNursingIndicator()	: 	"" 	 %>" />
				<input type="hidden"   id="clinic_nursing_code<%=index%>" 			name="clinic_nursing_code<%=index%>"  		value="<%=preApprovalRequestDetailsBean.getClinicNursingCode()			!=null 		? 	preApprovalRequestDetailsBean.getClinicNursingCode()		: 	"" 	 %>" />
				<input type="hidden"   id="specilaity_code<%=index%>" 				name="specilaity_code<%=index%>"  			value="<%=preApprovalRequestDetailsBean.getSpecialiltyCode()			!=null 		? 	preApprovalRequestDetailsBean.getSpecialiltyCode()			: 	"" 	 %>" />
				<input type="hidden"   id="preapproval_amt_capping<%=index%>" 		name="preapproval_amt_capping<%=index%>"  	value="<%=preApprovalRequestDetailsBean.getApprovalAmountCapping()		!=null 		? 	preApprovalRequestDetailsBean.getApprovalAmountCapping()	: 	"" 	 %>" />
				<input type="hidden"   id="preapproval_qty_capping<%=index%>" 		name="preapproval_qty_capping<%=index%>"  	value="<%=preApprovalRequestDetailsBean.getApprovalQuantityCapping()	!=null 		? 	preApprovalRequestDetailsBean.getApprovalQuantityCapping()	: 	"" 	 %>" />
				<input type="hidden"   id="service_level_approval<%=index%>" 		name="service_level_approval<%=index%>"  	value="<%=preApprovalRequestDetailsBean.getServiceLevelApprovalFlag()	!=null 		? 	preApprovalRequestDetailsBean.getServiceLevelApprovalFlag()	: 	"" 	 %>" />
				<input type="hidden"   id="preapproval_amt_gross_net<%=index%>"	name="preapproval_amt_gross_net<%=index%>"  value="<%=preApprovalRequestDetailsBean.getApprovalGrossNetAmount()		!=null 		? 	preApprovalRequestDetailsBean.getApprovalGrossNetAmount()	: 	"" 	 %>" />
				<input type="hidden"   id="utilized_qty<%=index%>" 				name="utilized_qty<%=index%>"  				value="<%=preApprovalRequestDetailsBean.getUtilizedQuantity()			!=null 		? 	preApprovalRequestDetailsBean.getUtilizedQuantity()			: 	"" 	 %>" />
				<input type="hidden"   id="sex<%=index%>" 							name="sex<%=index%>"  						value="<%=preApprovalRequestDetailsBean.getSex()						!=null 		? 	preApprovalRequestDetailsBean.getSex()						: 	"" 	 %>" />
				<input type="hidden"   id="age_group_code<%=index%>" 				name="age_group_code<%=index%>"  			value="<%=preApprovalRequestDetailsBean.getAgeGroupCode()				!=null 		? 	preApprovalRequestDetailsBean.getAgeGroupCode()				: 	"" 	 %>" />
				<input type="hidden"   id="primary_key_facility_id<%=index%>" 		name="primary_key_facility_id<%=index%>"  	value="<%=preApprovalRequestDetailsBean.getPrimaryKeyFacilityId()		!=null 		? 	preApprovalRequestDetailsBean.getPrimaryKeyFacilityId()		: 	"" 	 %>" />
				<input type="hidden"   id="primary_key_module_id<%=index%>" 		name="primary_key_module_id<%=index%>"  	value="<%=preApprovalRequestDetailsBean.getPrimaryKeyModuleId()			!=null 		? 	preApprovalRequestDetailsBean.getPrimaryKeyModuleId()		: 	"" 	 %>" />
				<input type="hidden"   id="primary_key_bling_service_code<%=index%>" name="primary_key_bling_service_code<%=index%>" value="<%=preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceCode()!=null 	? 	preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceCode():"" 	 %>" />
				<input type="hidden"   id="primary_key_service_item_code<%=index%>" name="primary_key_service_item_code<%=index%>"   value="<%=preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceItemCode()!=null	? 	preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceItemCode():"" %>" />
				<input type="hidden"   id="billApprovedYn<%=index%>" name="billApprovedYn<%=index%>"   value="<%=preApprovalRequestDetailsBean.getBillApprovedYN()!=null	? 	preApprovalRequestDetailsBean.getBillApprovedYN():"" %>" />
				<input type="hidden"   id="preapproval_dur_capping<%=index%>" 		name="preapproval_dur_capping<%=index%>"  	value="<%=preApprovalRequestDetailsBean.getApprovalDurationCapping()		!=null 		? 	preApprovalRequestDetailsBean.getApprovalDurationCapping()	: 	"" 	 %>" />
				<!-- 102.2 -->
				<input type="hidden"   id="seqNo<%=index%>" name="seqNo<%=index%>"   value="<%=preApprovalRequestDetailsBean.getSeqno()!=null	? 	preApprovalRequestDetailsBean.getSeqno():"" %>" />
				<input type="hidden"   id="requestID<%=index%>" name="requestID<%=index%>"   value="<%=preApprovalRequestDetailsBean.getRequestID()!=null	? 	preApprovalRequestDetailsBean.getRequestID():"" %>" />
				<input type="hidden"   id="curSrlno<%=index%>" 		name="curSrlno<%=index%>"  	value="<%=preApprovalRequestDetailsBean.getCurrSrlno()		!=null 		? 	preApprovalRequestDetailsBean.getCurrSrlno()	: 	"" 	 %>" />
				<input type="hidden"   id="approved_dur_qty<%=index%>" 		name="approved_dur_qty<%=index%>"  	value="<%=preApprovalRequestDetailsBean.getApprovedDurationQty()		!=null 		? 	preApprovalRequestDetailsBean.getApprovedDurationQty()	: 	"" 	 %>" />
			
				<%
				System.out.println("INDEX::: "+index+" ::::requestID::::::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getRequestID());
				System.out.println("INDEX::: "+index+" ::::getCurrSrlno:::::::::::::::::::::::: "+preApprovalRequestDetailsBean.getCurrSrlno());
				
				if(siteSpecUploadDoc && episodeType.equals("O")){ 
					if(preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("C")){
					%><td class="label" 	align="right" >
							<input type="file" name="UpdDoc<%=index%>" id="UpdDoc<%=index%>"  id="UpdDoc<%=index%>" <%=isDisabled%>  onchange="getFileType('<%=index%>')" > 
					  </td>	
				<%	}else{ %>	
					 <td class="label" 	align="right" >
							<input type="file"  name="UpdDoc<%=index%>" id="UpdDoc<%=index%>"  id="UpdDoc<%=index%>" disabled  onchange="getFileType('<%=index%>')"  > 
					 </td>	
					<%}%>
				<%}%>
				<input type="hidden"   id="DocUplYN<%=index%>" 				name="DocUplYN<%=index%>"  			value="N" />
				<!-- NMC-JD-CRF-0102.2-->
				<%-- <input type="hidden"   id="effective_from<%=index%>" 				name="effective_from<%=index%>"  			value="<%=preApprovalRequestDetailsBean.getEffectiveFrom()  			!=null 		? 	preApprovalRequestDetailsBean.getEffectiveFrom()			: 	"" 	 %>" />
				<input type="hidden"   id="effective_to<%=index%>" 				name="effective_to<%=index%>"  				value="<%=preApprovalRequestDetailsBean.getEffectiveTo()	  			!=null 		? 	preApprovalRequestDetailsBean.getEffectiveTo()				: 	"" 	 %>" />
				<input type="hidden"   id="patient_class<%=index%>" 				name="patient_class<%=index%>"  			value="<%=preApprovalRequestDetailsBean.getPatientClass()				!=null 		? 	preApprovalRequestDetailsBean.getPatientClass()				: 	"" 	 %>" />
				<input type="hidden"   id="episode_encounter_flag<%=index%>"		name="episode_encounter_flag<%=index%>"  	value="<%=preApprovalRequestDetailsBean.getEpisodeEncounterFlag()		!=null 		? 	preApprovalRequestDetailsBean.getEpisodeEncounterFlag()		: 	"" 	 %>" />
				<input type="hidden"   id="clinic_nursing_ind<%=index%>" 			name="clinic_nursing_ind<%=index%>"  		value="<%=preApprovalRequestDetailsBean.getClinicNursingIndicator()		!=null 		? 	preApprovalRequestDetailsBean.getClinicNursingIndicator()	: 	"" 	 %>" />
				<input type="hidden"   id="clinic_nursing_code<%=index%>" 			name="clinic_nursing_code<%=index%>"  		value="<%=preApprovalRequestDetailsBean.getClinicNursingCode()			!=null 		? 	preApprovalRequestDetailsBean.getClinicNursingCode()		: 	"" 	 %>" />
				<input type="hidden"   id="specilaity_code<%=index%>" 				name="specilaity_code<%=index%>"  			value="<%=preApprovalRequestDetailsBean.getSpecialiltyCode()			!=null 		? 	preApprovalRequestDetailsBean.getSpecialiltyCode()			: 	"" 	 %>" />
				<input type="hidden"   id="preapproval_amt_capping<%=index%>" 		name="preapproval_amt_capping<%=index%>"  	value="<%=preApprovalRequestDetailsBean.getApprovalAmountCapping()		!=null 		? 	preApprovalRequestDetailsBean.getApprovalAmountCapping()	: 	"" 	 %>" />
				<input type="hidden"   id="preapproval_qty_capping<%=index%>" 		name="preapproval_qty_capping<%=index%>"  	value="<%=preApprovalRequestDetailsBean.getApprovalQuantityCapping()	!=null 		? 	preApprovalRequestDetailsBean.getApprovalQuantityCapping()	: 	"" 	 %>" />
				<input type="hidden"   id="service_level_approval<%=index%>" 		name="service_level_approval<%=index%>"  	value="<%=preApprovalRequestDetailsBean.getServiceLevelApprovalFlag()	!=null 		? 	preApprovalRequestDetailsBean.getServiceLevelApprovalFlag()	: 	"" 	 %>" />
				<input type="hidden"   id="preapproval_amt_gross_net<%=index%>"	name="preapproval_amt_gross_net<%=index%>"  value="<%=preApprovalRequestDetailsBean.getApprovalGrossNetAmount()		!=null 		? 	preApprovalRequestDetailsBean.getApprovalGrossNetAmount()	: 	"" 	 %>" />
				<input type="hidden"   id="utilized_qty<%=index%>" 				name="utilized_qty<%=index%>"  				value="<%=preApprovalRequestDetailsBean.getUtilizedQuantity()			!=null 		? 	preApprovalRequestDetailsBean.getUtilizedQuantity()			: 	"" 	 %>" />
				<input type="hidden"   id="sex<%=index%>" 							name="sex<%=index%>"  						value="<%=preApprovalRequestDetailsBean.getSex()						!=null 		? 	preApprovalRequestDetailsBean.getSex()						: 	"" 	 %>" />
				<input type="hidden"   id="age_group_code<%=index%>" 				name="age_group_code<%=index%>"  			value="<%=preApprovalRequestDetailsBean.getAgeGroupCode()				!=null 		? 	preApprovalRequestDetailsBean.getAgeGroupCode()				: 	"" 	 %>" />
				<input type="hidden"   id="primary_key_facility_id<%=index%>" 		name="primary_key_facility_id<%=index%>"  	value="<%=preApprovalRequestDetailsBean.getPrimaryKeyFacilityId()		!=null 		? 	preApprovalRequestDetailsBean.getPrimaryKeyFacilityId()		: 	"" 	 %>" />
				<input type="hidden"   id="primary_key_module_id<%=index%>" 		name="primary_key_module_id<%=index%>"  	value="<%=preApprovalRequestDetailsBean.getPrimaryKeyModuleId()			!=null 		? 	preApprovalRequestDetailsBean.getPrimaryKeyModuleId()		: 	"" 	 %>" />
				<input type="hidden"   id="primary_key_bling_service_code<%=index%>" name="primary_key_bling_service_code<%=index%>" value="<%=preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceCode()!=null 	? 	preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceCode():"" 	 %>" />
				<input type="hidden"   id="primary_key_service_item_code<%=index%>" name="primary_key_service_item_code<%=index%>"   value="<%=preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceItemCode()!=null	? 	preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceItemCode():"" %>" />
				<input type="hidden"   id="billApprovedYn<%=index%>" name="billApprovedYn<%=index%>"   value="<%=preApprovalRequestDetailsBean.getBillApprovedYN()!=null	? 	preApprovalRequestDetailsBean.getBillApprovedYN():"" %>" />
				<input type="hidden"   id="preapproval_dur_capping<%=index%>" 		name="preapproval_dur_capping<%=index%>"  	value="<%=preApprovalRequestDetailsBean.getApprovalDurationCapping()		!=null 		? 	preApprovalRequestDetailsBean.getApprovalDurationCapping()	: 	"" 	 %>" />
				<input type="hidden"   id="approved_dur_qty<%=index%>" 		name="approved_dur_qty<%=index%>"  	value="<%=preApprovalRequestDetailsBean.getApprovedDurationQty()		!=null 		? 	preApprovalRequestDetailsBean.getApprovedDurationQty()	: 	"" 	 %>" />
			 --%>	<input type="hidden" name="p_Loc_code<%=index%>" id="p_Loc_code<%=index%>" id="p_Loc_code<%=index%>"  value ="<%=preApprovalRequestDetailsBean.getLocationCode()				!=	null	?	preApprovalRequestDetailsBean.getLocationCode()			:	""	 %>"> <!--V221025-->
			<%-- 	<input type='hidden' name='docSrlNo<%=index%>' id='docSrlNo<%=index%>' id='docSrlNo<%=index%>' value='<%=docSrlNo%>'>	
			 --%>		
			</tr> 
	<%
		}	
	if(rows==0){
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
	}
	%>	
	</table>
	<input type='hidden' name='authorisecheck' id='authorisecheck'	id='authorisecheck'  value="" >
	<input type='hidden' name='locale' id='locale'		id='locale' 	 	value="<%=locale%>" >
	<input type='hidden' name='facilityId' id='facilityId'	id='facilityId' 	value="<%=facilityId%>" >
	<input type='hidden' name='mode' id='mode' id='mode'	value="<%=mode%>" >
	<input type='hidden' name='isUserCanAcess' id='isUserCanAcess' id='isUserCanAcess'	value="<%=isUserCanAcess%>" />
	<input type='hidden' name='authorized' id='authorized' 	id='authorized'		value="<%=enabValue%>" />
	<input type='hidden' name='patinetId' id='patinetId' 	id='patinetId'		value="<%=patinetId%>" >
	<input type='hidden' name='episodeType' id='episodeType' id='episodeType'	value="<%=episodeType%>" >
	<input type='hidden' name='visitId' id='visitId' 	id='visitId'		value="<%=visitId%>" >
	<input type='hidden' name='priority' id='priority' 	id='priority'		value="<%=priority%>" />
	<input type='hidden' name='acctSeqNo' id='acctSeqNo' 	id='acctSeqNo'		value="<%=acctSeqNo%>" />
	<input type='hidden' name='encounterId' id='encounterId'  id='encounterId'	value="<%=encounterId%>" >
	<input type='hidden' name='policyTypeCode' id='policyTypeCode' id='policyTypeCode'	value="<%=policyTypeCode%>" >
	<input type='hidden' name='custGroupCode' id='custGroupCode' id='custGroupCode'	value="<%=custGroupCode%>" >
	<input type='hidden' name='custCode' id='custCode' 	id='custCode'		value="<%=custCode%>" />
	<input type='hidden' name='policyNumber' id='policyNumber' id='policyNumber'	value="<%=policyNumber%>" />
	<input type='hidden' name='episodeId' id='episodeId' 		id='episodeId'	value="<%=episodeId%>" />
	<input type='hidden' name='copyIndex' id='copyIndex'		id='copyIndex' 	value="<%=copyIndex%>"	/ >
	<input type='hidden' name='approvedAmount' id='approvedAmount'	id='approvedAmount' value="<%=approvedAmount%>"	/ >
	<input type='hidden' name='requestStatus' id='requestStatus'	id='requestStatus' 	value="<%=requestStatus%>"	/ >
	<input type='hidden' name='rowCount' id='rowCount'	id='rowCount' 	/ >
	<input type='hidden' name='prevRow' id='prevRow'		id='prevRow' 	 / >
	<input type='hidden' name='recalc_charges' id='recalc_charges'	id='recalc_charges' / >
	<input type='hidden'  name ='sys_date'	value = "<%=sys_date %>" />
	<input type='hidden' name='siteId' id='siteId' id ='siteId' value='<%=siteId %>' />
	<input type='hidden' name='expiryDate' id='expiryDate' id ='expiryDate' value='<%=request.getParameter("expiryDate")%>' />	 <!--Karthik Record approval   -  MMS-QH-CRF-0165 - Starts  -->
	<input type='hidden' name='effectiveTo' id='effectiveTo' id ='effectiveTo' value='<%=request.getParameter("effectiveTo")%>' />	 <!-- Record approval   -  MMS-QH-CRF-0165 - Starts -->
	<input type='hidden' name='disableVal' id='disableVal'		id='disableVal' 	value="<%=disable%>"	/ >
	<input type='hidden' name='effectiveToModified' id='effectiveToModified' id='effectiveToModified' 	 value=''	/ >
	<input type='hidden' name='sysDateTime' id='sysDateTime' id='sysDateTime' value='<%=sysDateTime %>' />
	<input type='hidden' name='authorise_check_billed' id='authorise_check_billed' id='authorise_check_billed' value='N' />
	<input type='hidden' name='user_id' id='user_id' id='user_id' value='<%= strLoggedUser%>' />
	<input type='hidden' name='approvalstatus_hdn' id='approvalstatus_hdn' id='approvalstatus_hdn' value='' />
	<input type='hidden' name='site_spec' id='site_spec' id='site_spec' value='<%=siteSpec %>'/>
	<input type='hidden' name='enableMCNNumberYN' id='enableMCNNumberYN' id='enableMCNNumberYN' value='<%=enableMCNNumberYN%>'/><!--V220905-->
	<input type='hidden' name='currMCNNum' id='currMCNNum' id='currMCNNum' value=''/><!--V220905-->
	<input type='hidden' name='currMCNNumidx' id='currMCNNumidx' id='currMCNNumidx' value=''/><!--V220905-->
	<input type='hidden' name='site_spec_approval_sts' id='site_spec_approval_sts' id='site_spec_approval_sts' value='<%=siteSpecapprovalsts %>'/> <!-- Added V190513-Dhananjay/MMS-DM-SCF-0612-->
	<input type='hidden' name='authorizedUserId' id='authorizedUserId' id='authorizedUserId' value=''>		
	<input type='hidden' name='site3TierAlmoFeatureYN' id='site3TierAlmoFeatureYN' id='site3TierAlmoFeatureYN' value='<%=site3TierAlmoFeatureYN %>'/>
	<!--  AAKH-SCF-0404.1 -->
	<input type='hidden' name='siteRecAppRecalChargeYN' id='siteRecAppRecalChargeYN'		id='siteRecAppRecalChargeYN' 	value="<%=siteRecAppRecalChargeYN%>" /><!--V220627-->
	<input type='hidden' name='siteApprovalStatusColorCodeYN' id='siteApprovalStatusColorCodeYN' id='siteApprovalStatusColorCodeYN' value='<%=siteApprovalStatusColorCodeYN %>'/>
	<input type='hidden' name='enableQueuePKID' id='enableQueuePKID' id='enableQueuePKID' value='<%=enableQueuePKID %>'/><!--V221025-->
	<input type='hidden' name='insurance_clr' id='insurance_clr'	id='insurance_clr' / ><!--V221216-->
	<input type='hidden' name='calledForm' id='calledForm'	id='calledForm' value='<%=calledForm%>' / ><!--V230102--> 
	<!-- NMC-JD-CRF-0102.2-->
	<input type='hidden' name='docCnt' id='docCnt' id='docCnt' value="0">
	<input type='hidden' name='membershipNo' id='membershipNo' id='membershipNo' value="<%=membershipNo%>" />
	<input type='hidden' name='siteSpecUploadDoc' id='siteSpecUploadDoc'	id='siteSpecUploadDoc' value='<%=siteSpecUploadDocYN%>' / >
	<input type='hidden' name='filePath' id='filePath' id='filePath' value='<%=filePath%>'>	 
	<input type='hidden' name='pathExist' id='pathExist' value='<%=pathExist%>'>	
	<input type='hidden' name='writeAccess' id='writeAccess' value="<%=writeAccess%>">
	<!-- NMC-JD-CRF-0102.2-->

	<%if("Y".equals(userAuthorization)){ %>
		<script>initiateAuthorization();</script>
	<%} %>
	</form>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'></div>	
	</body>
	</TBODY>
</div>
</body>
<%
	}
	catch(Exception e)
	{
		System.err.println("Exception in BillingPreApprovalRequestDetails.jsp::"+e);
		e.printStackTrace();
	}
	finally{
		ConnectionManager.returnConnection(con);
		pstmt = null;
		rst = null;
	}
%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
		
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
</html>

