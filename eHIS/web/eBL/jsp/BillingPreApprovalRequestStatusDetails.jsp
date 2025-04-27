<!DOCTYPE html>
<!-- 
-----------------------------------------------------------------------------------------------
Date       	Edit History   		Name        Description
-----------------------------------------------------------------------------------------------
16/04/2018      100         Subha Sundari M  created

Sr No       Version             Incident              SCF/CRF                        Developer Name
1 			V201013             IN73702            NMC-JD-CRF-0042.1         			Shikha Seth
2 			V201024             IN73702            NMC-JD-CRF-0042.1         			Shikha Seth
-----------------------------------------------------------------------------------------------
-->
<%@page import="eBL.BLReportIdMapper"%>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*, eBL.PreApprovalRequestDetailsBean " contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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
	//String applyMode=	new String();
	String locale		=	"";
	String facilityId	=	"";
	String mode		=	"";
	mode			=	"";
	String isUserCanAcess	=	"";
	String bean_id	=	"";
	String bean_name=	"";
	//String modifyStatus   =	"";
	String patinetId=	"";
	String episodeType=	"";
	String episodeId=	"";
	String visitId	=	"";
	String priority	=	"";
	String acctSeqNo=	"";
	//String authorized=	"";
	String encounterId=	"";
	//String billingGrpId=	"";
	String policyTypeCode	=	"";
	String custGroupCode   	=	"";
	String custCode   =	"";
	String policyNumber=	"";
	String copyIndex=	"";
	String requestStatus	=	"";
	String approvedAmount	=	"";
	String disable	=	"DISABLED";

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

	LinkedHashMap preApprovalRequestDetailsDataMap				=	null;
	//ArrayList<String[]>		preApprovalRequestDetailsList		=	null;

	/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Starts */
	String calledForm = "";
	String servGrpCode = "";
	String servClsfctnCode = "";
	String orderStatus = "";
	/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Ends */

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
try  
{ 
	sStyle 		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 		= 	(String)session.getAttribute("LOCALE");
	strLoggedUser=	(String) session.getValue("login_user");	
	if (strLoggedUser==null) strLoggedUser = "";

	facilityId	=   (String) session.getValue( "facility_id" ) ;
	patinetId	=	checkForNull(request.getParameter("patinetId"));
	episodeType	=	checkForNull(request.getParameter("episodeType"));
	episodeId	=	checkForNull(request.getParameter("episodeId"));
	visitId		=	checkForNull(request.getParameter("visitId"));
	priority	=	checkForNull(request.getParameter("priority"));
	acctSeqNo	=	checkForNull(request.getParameter("acctSeqNo"));
	encounterId	=	java.net.URLDecoder.decode(checkForNull(request.getParameter("encounterId")));
	//billingGrpId=	checkForNull(request.getParameter("billingGrpId"));
	policyTypeCode=	checkForNull(request.getParameter("policyTypeCode"));
	custGroupCode=	checkForNull(request.getParameter("custGroupCode"));
	custCode	=	checkForNull(request.getParameter("custCode"));
	policyNumber=	checkForNull(request.getParameter("policyNumber"));
	requestStatus=	checkForNull(request.getParameter("requestStatus"));
	
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
	apprAmt_filter = checkForNull(request.getParameter("apprAmt_filter"));
	reason_filter = checkForNull(request.getParameter("reason_filter"));
	reason_hdn_filter = checkForNull(request.getParameter("reason_hdn_filter"));
	remarks_filter = checkForNull(request.getParameter("remarks_filter"));
	userAuthorization = checkForNull(request.getParameter("userAuthorization"));
	encounterIdFilter= checkForNull(request.getParameter("encounterIdFilter"));
	orderStatusFilter= checkForNull(request.getParameter("orderStatusFilter"));
	siteSpec=checkForNull(request.getParameter("site_spec"));
	siteId = BLReportIdMapper.getCustomerId();
	
	/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Starts */
	calledForm =	checkForNull(request.getParameter("calledForm"));
	servGrpCode =	checkForNull(request.getParameter("servGrpCode"));
	servClsfctnCode =	checkForNull(request.getParameter("servClsfctnCode"));
	orderStatus =	checkForNull(request.getParameter("orderStatus"));
	/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Ends */
	
	preApprovalRequestDetailsDataMap =	new LinkedHashMap();
	
	bean_id	= 	"PreApprovalRequestDetailsBean" ;
	bean_name = 	"eBL.PreApprovalRequestDetailsBean";
	PreApprovalRequestDetailsBean preApprovalRequestDetailsBean= 	(PreApprovalRequestDetailsBean)getBeanObject( bean_id, bean_name, request ) ;
	isUserCanAcess	= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
	preApprovalRequestDetailsDataMap =	preApprovalRequestDetailsBean.getPreApprovalRequestDetailsData(patinetId, episodeType, episodeId, visitId, priority,requestStatus,acctSeqNo, facilityId, locale,custGroupCode,custCode,policyTypeCode,
			criteriaFilter,bg_code_filter,serviceDate_filter,serviceAmount_filter,serviceQuantity_filter,apprReqDate_filter,
			apprGvnDate_filter,apprNo_filter,approval_status_filter,apprQty_filter,apprAmt_filter,reason_hdn_filter,remarks_filter,encounterId,encounterIdFilter,orderStatusFilter, servGrpCode, servClsfctnCode, orderStatus);		
	con = ConnectionManager.getConnection(request); 
	String sqlBillingService = "SELECT NVL(B.LIST_ELMT_LABEL,A.LIST_ELMT_LABEL) description FROM SM_LIST_ITEM A, SM_LIST_ITEM_DESC B WHERE A.MODULE_ID = 'BL' AND A.MODULE_ID = B.MODULE_ID (+) AND A.LIST_REF = B.LIST_REF (+) AND A.LIST_SRL_NO = B.LIST_SRL_NO (+) AND A.LIST_REF = 'L_SERV_INC_EXC_CR' AND B.LANGUAGE_ID (+) = ? and A.LIST_ELMT_VALUE = ? ";
	String blngServDesc = "";	
	String sys_date = "";
	
	//Added V200413 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	try {
			//con	=	ConnectionManager.getConnection(request); checklist
			site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","3TIERALMOFEATURE");
			if (site3TierAlmoFeature) {
				site3TierAlmoFeatureYN = "Y";
			}else {
				site3TierAlmoFeatureYN = "N";
			}
			} catch(Exception ex) {
				System.err.println("Error in BillingPreApprovalRequestStatusDetails.jsp for getting site3TierAlmoFeature Connection: "+ex);
				ex.printStackTrace();
		}
	//Added V200413 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	
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
	//Added V200807 SHIKHA against NMC-JD-CRF-0042
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
	//Ended V200807 SHIKHA against NMC-JD-CRF-0042
	
	pstmt = con.prepareStatement(sqlBillingService);
%>

<body onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
	<form id="BillingPreApprovalRequestDetailsForm" name="BillingPreApprovalRequestDetailsForm" id="BillingPreApprovalRequestDetailsForm">	
	<table align='center'  cellpadding=3 cellspacing=0  width='100%' id="record_approval_details_table" name="record_approval_details_table" id="record_approval_details_table" border="1">		 
	<div id="tableContainer">
	<thead>
	<tr>
	<% if(siteSpec.equals("true")){  %>	 
 	<th class='CAFLOWSHEETLEVEL1' 	nowrap  width="3%"  align="left"><fmt:message key="Common.encounterid.label" 	bundle="${common_labels}"	/></th>
	<%} %> 	
	<th class='CAFLOWSHEETLEVEL1'	nowrap	width="9%"	align="left"><fmt:message key="Common.type.label" 		bundle="${common_labels}"	/></th>
	<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="7%" 	align="left"><fmt:message key="eBL.BLNG_SERV_CODE.label" 	bundle="${bl_labels}"	/></th>
	<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="7%" 	align="left"><fmt:message key="eBL.BillingServiceDesc.label" 		bundle="${bl_labels}"	/></th>
	<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="7%" 	align="left"><fmt:message key="eBL.SERVICE_DATE.label" 	bundle="${bl_labels}"	/></th>
	<% if(siteSpec.equals("true")){ %>
	<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="7%" 	align="left"><fmt:message key="Common.OrderStatus.label" 	bundle="${common_labels}"	/></th>	
	<%} %>
	<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="7%" 	align="left"><fmt:message key="eBL.ServiceAmount.label" 	bundle="${bl_labels}"	/></th>
	<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="7%" 	align="left"><fmt:message key="eBL.ServiceQuantity.label" bundle="${bl_labels}"	/></th>  
	<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="8%" 	align="left"><fmt:message key="eBL.ApprovalRequiredDate.label" 		bundle="${bl_labels}"	/></th>
	<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="7%" 	align="left"><fmt:message key="eBL.ApprovalGivenDate.label" 		bundle="${bl_labels}"	/></th>
	<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="6%" 	align="left"><fmt:message key="eBL.ApprovalNumber.label" 	bundle="${bl_labels}"	/></th>
	<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="5%" 	align="left"><fmt:message key="Common.status.label" 		bundle="${common_labels}"/></th>
	<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="6%" 	align="left"><fmt:message key="eBL.APPROVED_QTY.label" 	bundle="${bl_labels}"/></th>  
	<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="7%" 	align="left"><fmt:message key="eBL.APPROVED_AMT.label" 	bundle="${bl_labels}"/></th>
	<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="7%" 	align="left"><fmt:message key="Common.reason.label" 		bundle="${common_labels}"	/></th>
	<th class='CAFLOWSHEETLEVEL1' 	nowrap	width="4%" 	align="left"><fmt:message key="Common.remarks.label" 		bundle="${common_labels}"		/></th>
	</tr>
	<!-- Added by Aravindh/11-05-2018/MMS-DM-CRF-0125 -->
	<tr>
		<% if(siteSpec.equals("true")){ %>
			<td><input type='text' name='encounterIdFilter' id='encounterIdFilter' id='encounterIdFilter' value='<%=encounterIdFilter%>'></td>
		<%} %>
		<%-- <% if(siteSpec.equals("true")){ %>
			<td nowrap="nowrap">&nbsp;</td>
		<%} %> --%>
		<td  nowrap>
			<select name='criteriaFilter' id='criteriaFilter' style="width: 120px;">		
			<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>			
			<%
			for (Iterator iterator = criteriaMap.keySet().iterator(); iterator.hasNext();) {
				String type = (String) iterator.next();
				if(type.equals(criteriaFilter)) {
				%>	
					<option value='<%=type%>' selected><%=criteriaMap.get(type) %></option>
				<%} else { %>
					<option value='<%=type%>'><%=criteriaMap.get(type) %></option>
			<% }
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
		while(iterator.hasNext())
		{		
			int index =    (Integer)iterator.next();
			preApprovalRequestDetailsBean = (PreApprovalRequestDetailsBean) preApprovalRequestDetailsDataMap.get(index);	
	%>
	<tr> 
	<%
		pstmt.setString(1,locale);
		pstmt.setString(2,preApprovalRequestDetailsBean.getIncludedExcluded());
		rst = pstmt.executeQuery();
		if(rst != null){
			while(rst.next()){
				blngServDesc = rst.getString("description");
			}
		}
		//pstmt = null;
		rst = null;
		
		//Added V200807 SHIKHA against NMC-JD-CRF-0042					
		//  int preAppStatusMaxDateTime =0;//V201013//checklist
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
		  }		  	*/
		  if(preApprovalRequestDetailsBean.getColorStatus().equals("Y")) { //V201024 added
			  if (preApprovalRequestDetailsBean.getStatus().equals("P")) {
				  //if (preAppStatusMaxDateTime > Integer.parseInt(PtimeLimit)) { //V201024 commented
					  bgcolor = "style=background-color:"+Pcolor;
					//  }  //V201024 commented
			  } else if (preApprovalRequestDetailsBean.getStatus().equals("A")) {
				  if ( !preApprovalRequestDetailsBean.getApprovalNumber().equals("Default Approved")) {			  
					  //if (preAppStatusMaxDateTime > Integer.parseInt(AtimeLimit)) { //V201024 commented
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
				  //if (preAppStatusMaxDateTime > Integer.parseInt(StimeLimit)) { //V201024 commented				
						bgcolor = "style=background-color:"+Scolor;
					//  }  //V201024 commented
			  }else if (preApprovalRequestDetailsBean.getStatus().equals("R")) {
				  //if (preAppStatusMaxDateTime > Integer.parseInt(RtimeLimit)) { //V201024 commented			
					bgcolor = "style=background-color:"+Rcolor;
				  //}  //V201024 commented
			  }					  
		  }					  
		  }					  
		//Ended V200807 SHIKHA against NMC-JD-CRF-0042
	%>
	<% if(siteSpec.equals("true")){ %>
	<td nowrap class="fields" 	width="10%"	><label name="encounter_id<%=index%>" id="encounter_id<%=index%>" title="<%=preApprovalRequestDetailsBean.getEncounterId()			!=	null	?	preApprovalRequestDetailsBean.getEncounterId()		:	""	 %>"  ><%=preApprovalRequestDetailsBean.getEncounterId()			!=	null	?	preApprovalRequestDetailsBean.getEncounterId()		:	""	 %></label></td>
	<%} %>
		
		<td  nowrap class="fields" 	width="10%"		>
			<label id="included_excluded<%=index%>"	name="included_excluded<%=index%>" style="width: 120px;" title="<%=blngServDesc%>"><%=blngServDesc %></label>
		</td>
		<td nowrap class="fields"	width="7%" 		>				
		<input type="hidden"	id="billing_service_code<%=index%>"				name="billing_service_code<%=index%>"		title="<%=preApprovalRequestDetailsBean.getBillingServiceCode()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceCode()		:	""	 %>" 		value="<%=preApprovalRequestDetailsBean.getBillingServiceCode()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceCode()		:	""	 %>"  />
		<label	id="billing_service_display<%=index%>"				name="billing_service_display<%=index%>"		title="<%=preApprovalRequestDetailsBean.getBillingServiceDisplay()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceDisplay()		:	""	 %>"  ><%=preApprovalRequestDetailsBean.getBillingServiceDisplay()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceDisplay()		:	""	 %>&nbsp;</label>
		</td>
		<td nowrap class="fields"	width="7%" 		><label id="billing_service_desc<%=index%>"				name="billing_service_desc<%=index%>" 		title="<%=preApprovalRequestDetailsBean.getBillingServiceDesc()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceDesc()		:	""	 %>"  ><%=preApprovalRequestDetailsBean.getBillingServiceDesc()			!=	null	?	preApprovalRequestDetailsBean.getBillingServiceDesc()		:	""	 %>&nbsp;</label></td>
		<td nowrap class="fields" 	width="8%"		>
		<input type="hidden" name="p_service_date<%=index%>" id="p_service_date<%=index%>"  value ="<%=preApprovalRequestDetailsBean.getServiceDate()	%>" >
		<label id="service_date<%=index%>"						name="service_date<%=index%>"		  		title="<%=preApprovalRequestDetailsBean.getServiceDate()				!=	null	?	preApprovalRequestDetailsBean.getServiceDate()				:	""	 %>" 		><%=preApprovalRequestDetailsBean.getServiceDate()				!=	null	?	preApprovalRequestDetailsBean.getServiceDate()				:	""	 %></label></td> 
		<% if(siteSpec.equals("true")){ %>
		<td nowrap class="fields" 	width="8%"><label id="order_status<%=index%>"						name="order_status<%=index%>"		  		title="<%=preApprovalRequestDetailsBean.getOrderStatus()				!=	null	?	preApprovalRequestDetailsBean.getOrderStatus()				:	""	 %>"  ><%=preApprovalRequestDetailsBean.getOrderStatus()				!=	null	?	preApprovalRequestDetailsBean.getOrderStatus()				:	""	 %></label></td> 			
		<%} %>
		<td nowrap class="fields" 	width="7%"	style="text-align: right"><label id="available_service_amount<%=index%>"			name="available_service_amount<%=index%>"	title="<%=preApprovalRequestDetailsBean.getUtilizedAmount()				!=	null	?	preApprovalRequestDetailsBean.getUtilizedAmount()			:	""	 %>" 	 ><%=preApprovalRequestDetailsBean.getUtilizedAmount()				!=	null	?	preApprovalRequestDetailsBean.getUtilizedAmount()			:	""	 %></label></td>
		 <td nowrap class="fields" 	width="7%"	style="text-align: right"><label id="available_service_qty<%=index%>"			name="available_service_qty<%=index%>"	title="<%=preApprovalRequestDetailsBean.getServiceQty()				!=	null	?	preApprovalRequestDetailsBean.getServiceQty()			:	""	 %>" 		><%=preApprovalRequestDetailsBean.getServiceQty()				!=	null	?	preApprovalRequestDetailsBean.getServiceQty()			:	""	 %></label></td>
		<td nowrap class="fields" 	width="8%"		>
		<input type="hidden" name="p_app_req_date<%=index%>" id="p_app_req_date<%=index%>"  value ="<%=preApprovalRequestDetailsBean.getApprovalRequiredDate()	%>" >
		<label id="app_req_date<%=index%>"	 name="app_req_date<%=index%>"				title="<%=preApprovalRequestDetailsBean.getApprovalRequiredDate()			!=	null	?	preApprovalRequestDetailsBean.getApprovalRequiredDate()		:	""	 %>" 		 ><%=preApprovalRequestDetailsBean.getApprovalRequiredDate()		!=	null	?	preApprovalRequestDetailsBean.getApprovalRequiredDate()		:	""	 %></label>
		</td>
		<td nowrap class="fields" 	width="8%"		>
		<input type="hidden" name="p_approved_date<%=index%>" id="p_approved_date<%=index%>"  value ="<%= preApprovalRequestDetailsBean.getApprovalGivenDate().length() > 0 	?	preApprovalRequestDetailsBean.getApprovalGivenDate()		:	sys_date	 %>">
		<label id="approved_date<%=index%>"					name="approved_date<%=index%>"				title='<%=preApprovalRequestDetailsBean.getApprovalGivenDate().length() > 0 ?	preApprovalRequestDetailsBean.getApprovalGivenDate()		:	""	 %>' 		><%= preApprovalRequestDetailsBean.getApprovalGivenDate().length() > 0 	?	preApprovalRequestDetailsBean.getApprovalGivenDate()		:	""	 %></label>
		</td>
		<td nowrap class="fields" 	width="6%"		>
		<input type="hidden" name="p_approval_number<%=index%>" id="p_approval_number<%=index%>"  value ="<%=preApprovalRequestDetailsBean.getApprovalNumber()				!=	null	?	preApprovalRequestDetailsBean.getApprovalNumber()			:	""	 %>">
		<label id="approval_number<%=index%>"					name="approval_number<%=index%>"			title="<%=preApprovalRequestDetailsBean.getApprovalNumber()				!=	null	?	preApprovalRequestDetailsBean.getApprovalNumber()			:	""	 %>" 		><%=preApprovalRequestDetailsBean.getApprovalNumber()				!=	null	?	preApprovalRequestDetailsBean.getApprovalNumber()			:	""	 %></label></td>
		
		<td nowrap class="fields" 	width="5%"		>
		<input type="hidden" name="p_approval_status<%=index%>" id="p_approval_status<%=index%>"  value ="<%=preApprovalRequestDetailsBean.getStatus() !=null ? preApprovalRequestDetailsBean.getStatus() : "P" %>">
		<%
		if(preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("P")) {
		%>
		<label <%=bgcolor %> id="pp_approval_status<%=index%>" name="pp_approval_status<%=index%>" title="<%=preApprovalRequestDetailsBean.getStatus()				!=	null	?	preApprovalRequestDetailsBean.getStatus()			:	""	 %>" >Pending</label>
		<%
		}else if(preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("A")) {
		%>
		<label <%=bgcolor %> id="pp_approval_status<%=index%>" name="pp_approval_status<%=index%>" title="<%=preApprovalRequestDetailsBean.getStatus()				!=	null	?	preApprovalRequestDetailsBean.getStatus()			:	""	 %>" >Approved</label>
		<%
		}else if(preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("R")) {
		%>
		<label <%=bgcolor %> id="pp_approval_status<%=index%>" name="pp_approval_status<%=index%>" title="<%=preApprovalRequestDetailsBean.getStatus()				!=	null	?	preApprovalRequestDetailsBean.getStatus()			:	""	 %>" >Rejected</label>
		<%
		}else if(preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("S")) {
		%>
		<label <%=bgcolor %> id="pp_approval_status<%=index%>" name="pp_approval_status<%=index%>" title="<%=preApprovalRequestDetailsBean.getStatus()				!=	null	?	preApprovalRequestDetailsBean.getStatus()			:	""	 %>" >Send to Insurance</label>
		<%
		}else if(preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("H")) {
		%>
		<label <%=bgcolor %> id="pp_approval_status<%=index%>" name="pp_approval_status<%=index%>" title="<%=preApprovalRequestDetailsBean.getStatus()				!=	null	?	preApprovalRequestDetailsBean.getStatus()			:	""	 %>" >Hold</label>
		<%
		}else if(preApprovalRequestDetailsBean.getStatus()	!=	null && preApprovalRequestDetailsBean.getStatus().equalsIgnoreCase("C")) {
		%>
		<label <%=bgcolor %> id="pp_approval_status<%=index%>" name="pp_approval_status<%=index%>" title="<%=preApprovalRequestDetailsBean.getStatus()				!=	null	?	preApprovalRequestDetailsBean.getStatus()			:	""	 %>" >Clarification</label>
		<%
		}else {
		%>
		<label <%=bgcolor %> id="pp_approval_status<%=index%>" name="pp_approval_status<%=index%>" title="<%=preApprovalRequestDetailsBean.getStatus()				!=	null	?	preApprovalRequestDetailsBean.getStatus()			:	""	 %>" >&nbsp;</label>
		<%
		}
		%>
		
		<input type="hidden" name="approvalstatus_hdn<%=index%>" id="approvalstatus_hdn<%=index%>" id="approvalstatus_hdn<%=index%>" value="<%=preApprovalRequestDetailsBean.getStatus() != null ? preApprovalRequestDetailsBean.getStatus():""  %>">
		</td>
		
		<td nowrap class="fields" 	width="6%"		><input type="hidden" name="p_approvedQty<%=index%>" id="p_approvedQty<%=index%>"  value ="<%=preApprovalRequestDetailsBean.getApprovedQty()				!=	null	?	preApprovalRequestDetailsBean.getApprovedQty()			:	""	 %>">
		<label id="approvedQty<%=index%>"					name="approvedQty<%=index%>"			title="<%=preApprovalRequestDetailsBean.getApprovedQty()				!=	null	?	preApprovalRequestDetailsBean.getApprovedQty()			:	""	 %>" 		><%=preApprovalRequestDetailsBean.getApprovedQty()				!=	null	?	preApprovalRequestDetailsBean.getApprovedQty()			:	""	 %></label></td>
		<td nowrap class="fields" 	width="7%"		><input type="hidden" name="p_approvedAmount<%=index%>" id="p_approvedAmount<%=index%>"  value ="<%=preApprovalRequestDetailsBean.getApprovedAmount()				!=	null	?	preApprovalRequestDetailsBean.getApprovedAmount()			:	""	 %>">
		<label id="approvedAmount<%=index%>"					name="approvedAmount<%=index%>"			title="<%=preApprovalRequestDetailsBean.getApprovedAmount()				!=	null	?	preApprovalRequestDetailsBean.getApprovedAmount()			:	""	 %>" 		><%=preApprovalRequestDetailsBean.getApprovedAmount()				!=	null	?	preApprovalRequestDetailsBean.getApprovedAmount()			:	""	 %></label></td>				 
		<td nowrap class="fields" 	width="7%"		><input type="hidden" name="p_reason<%=index%>" id="p_reason<%=index%>"  value ="<%=preApprovalRequestDetailsBean.getReason()						!=	null	?	preApprovalRequestDetailsBean.getReason()					:	""	 %>">
		<label id="reason<%=index%>"							name="reason<%=index%>"						title="<%=preApprovalRequestDetailsBean.getReason()						!=	null	?	preApprovalRequestDetailsBean.getReason()					:	""	 %>" 		><%=preApprovalRequestDetailsBean.getReason()						!=	null	?	preApprovalRequestDetailsBean.getReason()					:	""	 %></label></td>
		<td nowrap class="fields" 	width="4%"		><input type="hidden" name="p_approval_remarks<%=index%>" id="p_approval_remarks<%=index%>"  value ="<%=preApprovalRequestDetailsBean.getRemarks()					!=	null	?	preApprovalRequestDetailsBean.getRemarks()					:	""	 %>">
		<label id="approval_remarks<%=index%>"					name="approval_remarks<%=index%>"			title="<%=preApprovalRequestDetailsBean.getRemarks()					!=	null	?	preApprovalRequestDetailsBean.getRemarks()					:	""	 %>" 		><%=preApprovalRequestDetailsBean.getRemarks()					!=	null	?	preApprovalRequestDetailsBean.getRemarks()					:	""	 %></label></td> 
				 
		 <input type="hidden"   id="effective_from<%=index%>" 				name="effective_from<%=index%>"  			value="<%=preApprovalRequestDetailsBean.getEffectiveFrom()  			!=null 		? 	preApprovalRequestDetailsBean.getEffectiveFrom()			: 	"" 	 %>" />
		 <input type="hidden"   id="effective_to<%=index%>" 				name="effective_to<%=index%>"  				value="<%=preApprovalRequestDetailsBean.getEffectiveTo()	  			!=null 		? 	preApprovalRequestDetailsBean.getEffectiveTo()				: 	"" 	 %>" />
		<%--  <input type="hidden"   id="app_req_date<%=index%>" 				name="app_req_date<%=index%>"  				value="<%=preApprovalRequestDetailsBean.getApprovalRequiredDate()  		!=null 		? 	preApprovalRequestDetailsBean.getApprovalRequiredDate()		: 	"" 	 %>" /> --%>
		 <%-- <input type="hidden"   id="status" 							name="status" id="status"  value="<%=preApprovalRequestDetailsBean.getStatus()  					!=null 		? 	preApprovalRequestDetailsBean.getStatus()					: 	"" 	 %>" /> --%>
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
		 <input type="hidden"   id="primary_key_main<%=index%>" 			name="primary_key_main<%=index%>"  			value="<%=preApprovalRequestDetailsBean.getPrimaryKeyMain()				!=null 		? 	preApprovalRequestDetailsBean.getPrimaryKeyMain()			: 	"" 	 %>" />
		 <input type="hidden"   id="primary_key_line_no<%=index%>" 			name="primary_key_line_no<%=index%>"  		value="<%=preApprovalRequestDetailsBean.getPrimaryKeyLineNo()			!=null 		? 	preApprovalRequestDetailsBean.getPrimaryKeyLineNo()			: 	"" 	 %>" />
		 <input type="hidden"   id="primary_key_bling_service_code<%=index%>" name="primary_key_bling_service_code<%=index%>" value="<%=preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceCode()!=null 	? 	preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceCode():"" 	 %>" />
		 <input type="hidden"   id="primary_key_service_item_code<%=index%>" name="primary_key_service_item_code<%=index%>"   value="<%=preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceItemCode()!=null	? 	preApprovalRequestDetailsBean.getPrimaryKeyBillingServiceItemCode():"" %>" />
		 <input type="hidden"   id="billApprovedYn<%=index%>" name="billApprovedYn<%=index%>"   value="<%=preApprovalRequestDetailsBean.getBillApprovedYN()!=null	? 	preApprovalRequestDetailsBean.getBillApprovedYN():"" %>" />	
 

		 <%-- <input type="hidden"   id="billing_grp_id" name="billing_grp_id" id="billing_grp_id"  						value="<%=preApprovalRequestDetailsList.get(index)[12]  !=null 		? 	preApprovalRequestDetailsList.get(index)[12]: 	"" 	 %>" /> --%>
		 <%--  <input type="hidden"   id="type<%=index%>" name="type<%=index%>"  						value="<%=preApprovalRequestDetailsList.get(index)[14]  !=null 		? 	preApprovalRequestDetailsList.get(index)[14]: 	"" 	 %>" /> --%>		
			</tr> 
	<%
		}	
	%>	
	<!-- </div>  -->	
</table>
<input type='hidden' name='authorisecheck' id='authorisecheck'	id='authorisecheck' value="" >
<input type='hidden' name='locale' id='locale'	id='locale' value="<%=locale%>" >
<input type='hidden' name='facilityId' id='facilityId'	id='facilityId' value="<%=facilityId%>" >
<input type='hidden' name='mode' id='mode' id='mode' value="<%=mode%>" >
<input type='hidden' name='isUserCanAcess' id='isUserCanAcess' 	id='isUserCanAcess'	value="<%=isUserCanAcess%>" />
<input type='hidden' name='authorized' id='authorized' 	id='authorized'	 value="<%=enabValue%>" />
<input type='hidden' name='patinetId' id='patinetId' 	id='patinetId'	value="<%=patinetId%>" >
<input type='hidden' name='episodeType' id='episodeType' id='episodeType'	value="<%=episodeType%>" >
<input type='hidden' name='visitId' id='visitId'  id='visitId'		value="<%=visitId%>" >
<input type='hidden' name='priority' id='priority' 	id='priority'	value="<%=priority%>" />
<input type='hidden' name='acctSeqNo' id='acctSeqNo' 	id='acctSeqNo'	value="<%=acctSeqNo%>" />
<input type='hidden' name='encounterId' id='encounterId' id='encounterId' value="<%=encounterId%>" >
<input type='hidden' name='policyTypeCode' id='policyTypeCode' id='policyTypeCode' value="<%=policyTypeCode%>" >
<input type='hidden' name='custGroupCode' id='custGroupCode' id='custGroupCode' value="<%=custGroupCode%>" >
<input type='hidden' name='custCode' id='custCode' id='custCode'	value="<%=custCode%>" />
<input type='hidden' name='policyNumber' id='policyNumber' id='policyNumber' value="<%=policyNumber%>" />
<input type='hidden' name='episodeId' id='episodeId' 	id='episodeId'	value="<%=episodeId%>" />
<input type='hidden' name='copyIndex' id='copyIndex' id='copyIndex' value="<%=copyIndex%>"	/ >
<input type='hidden' name='approvedAmount' id='approvedAmount' id='approvedAmount' value="<%=approvedAmount%>"	/ >
<input type='hidden' name='requestStatus' id='requestStatus' id='requestStatus' value="<%=requestStatus%>"	/ >
<input type='hidden' name='rowCount' id='rowCount' id='rowCount' / >
<input type='hidden' name='prevRow' id='prevRow'	id='prevRow' / >
<input type='hidden' name='recalc_charges' id='recalc_charges'	id='prevRow' / >
<input type='hidden'  name ='sys_date'	value = "<%=sys_date %>" />
<input type='hidden' name='siteId' id='siteId' id ='siteId' value='<%=siteId %>' />
<input type='hidden' name='expiryDate' id='expiryDate' id ='expiryDate' value='<%=request.getParameter("expiryDate")%>' />	 <!--Karthik Record approval   -  MMS-QH-CRF-0165 - Starts  -->
<input type='hidden' name='effectiveTo' id='effectiveTo' id ='effectiveTo' value='<%=request.getParameter("effectiveTo")%>' />	 
<!-- Record approval   -  MMS-QH-CRF-0165 - Starts -->
<input type='hidden' name='disableVal' id='disableVal' id='disableVal' value="<%=disable%>"	/ >
<input type='hidden' name='effectiveToModified' id='effectiveToModified' id='effectiveToModified' value=''	/ >
<input type='hidden' name='sysDateTime' id='sysDateTime' id='sysDateTime' value='<%=sysDateTime %>' />
<input type='hidden' name='authorise_check_billed' id='authorise_check_billed' id='authorise_check_billed' value='N' />
<input type='hidden' name='user_id' id='user_id' id='user_id' value='<%= strLoggedUser%>' />
<input type='hidden' name='approvalstatus_hdn' id='approvalstatus_hdn' id='approvalstatus_hdn' value='' />
<input type='hidden' name='site_spec' id='site_spec' id='site_spec' value='<%=siteSpec %>'/>
<input type='hidden' name='authorizedUserId' id='authorizedUserId' id='authorizedUserId' value=''>
<input type='hidden' name='site3TierAlmoFeatureYN' id='site3TierAlmoFeatureYN' id='site3TierAlmoFeatureYN' value='<%=site3TierAlmoFeatureYN %>'/>
<input type='hidden' name='siteApprovalStatusColorCodeYN' id='siteApprovalStatusColorCodeYN' id='siteApprovalStatusColorCodeYN' value='<%=siteApprovalStatusColorCodeYN %>'/>
		 
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
		System.err.println("Exception in BillingRecordApprovalPatientDataDeatils.jsp::"+e);
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

