<!DOCTYPE html>
<!-- 
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
23/10/12      100         Bmohankumar  created
Acts as create and Modify screen for Receipt Nature
called on click of create button from common tool bar
on submission (apply) request will be submitte dto ReceiptNatureServlet
-----------------------------------------------------------------------------------------------
Sr No              Version                Incident              SCF/CRF                        Developer Name
1                  V201013                IN73702            NMC-JD-CRF-0042.1         			Shikha Seth
2                  V201024                IN73702            NMC-JD-CRF-0042.1         			Shikha Seth
3				   V220909				  33891		         TH-KW-CRF-0093                     Mohanapriya K
4				   V230209				  40607				BL-SERDANG-Record Approval   	    Mohanapriya K
-->

<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*, eBL.RecordApprovalPatientDataBean " contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/BillingRecordApprovalScript.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

var ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL	=	"<%=BlRepository.getBlKeyValue("ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL")%>";
var PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL	=	"<%=BlRepository.getBlKeyValue("PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL")%>";	
var PAYER_LOOKUP_RECORD_PREAPPROVAL			=	"<%=BlRepository.getBlKeyValue("PAYER_LOOKUP_RECORD_PREAPPROVAL")%>";	
var POLICY_LOOKUP_RECORD_PREAPPROVAL		=	"<%=BlRepository.getBlKeyValue("POLICY_LOOKUP_RECORD_PREAPPROVAL")%>";	
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


TD.YELLOW 
{
	BACKGROUND-COLOR: yellow ;
	FONT-SIZE: 8pt ;
	border-style: dashed;
	border-left-color: #D5E2E5;
	border-right-color: #D5E2E5;
	border-top-color: #D5E2E5;
	border-bottom-color: #D5E2E5;	
}

/*V201013 start*/
TD.RED 
{
  background-color:#FFFFFF;
  COLOR:red;
  FONT-SIZE: 8pt;
  TEXT-ALIGN: LEFT
}
/*V201013 end*/
</style>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0   
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
//String applyMode																			=	new String();
String locale																				=	"";
String facilityId																			=	"";
//String loggedInUser																			=	"";
String mode																					=	"";
mode																						=	"";
String isUserCanAcess																		=	"";
String bean_id																				=	"";
String bean_name																			=	"";
//String modifyStatus     																	=	"";
String patinetId																			=	"";
String episodeType																			=	"";
String patientName																			=	"";
String encounterId																			=	"";
String customerGroupCode																	=	"";
String encounterFromDate																	=	"";
String encounterToDate																		=	"";
String customerCode																			=	"";
String policyCode																			=	"";
String requestStatus																		=	"";
String speciality																			=	"";
StringBuffer sql																			=	null;
//ArrayList<String[]>		patientDataList														=	null;
LinkedHashMap							recordPreApprovalDataMap							=	null;
//String disable																				=	"READONLY";
Boolean siteSpec=false;
String enableMCNNumberYN = ""; //V220909
/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Starts */
String calledForm = "";
String servGrpCode = "";
String servClsfctnCode = "";
String orderStatus = "";
/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Ends */
//V201024 start
boolean siteApprovalStatusColorCode = false;
String siteApprovalStatusColorCodeYN = "N";
//V201024 end
try  
{
 	Connection con	=	ConnectionManager.getConnection(request); 
	sStyle 																					=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	locale 																					= 	(String)session.getAttribute("LOCALE");
	facilityId																				=   (String) session.getValue( "facility_id" ) ;
	patinetId																				=	checkForNull(request.getParameter("patinetId"));
	episodeType																				=	checkForNull(request.getParameter("episodeType"));
	patientName																				=	checkForNull(request.getParameter("patientName"));
	encounterId																				=	checkForNull(request.getParameter("encounterId"));
	customerGroupCode																		=	checkForNull(request.getParameter("customerGroupCode"));
	encounterFromDate																		=	checkForNull(request.getParameter("encounterFromDate"));
	encounterToDate																			=	checkForNull(request.getParameter("encounterToDate"));
	customerCode																			=	checkForNull(request.getParameter("customerCode"));
	policyCode																				=	checkForNull(request.getParameter("policyCode"));
	requestStatus																			=	checkForNull(request.getParameter("requestStatus"));
	speciality																				=	checkForNull(request.getParameter("speciality"));
	/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Starts */
	calledForm =	checkForNull(request.getParameter("calledForm"));
	servGrpCode =	checkForNull(request.getParameter("servGrpCode"));
	servClsfctnCode =	checkForNull(request.getParameter("servClsfctnCode"));
	orderStatus =	checkForNull(request.getParameter("orderStatus"));
	/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Ends */
	enableMCNNumberYN =	checkForNull(request.getParameter("enableMCNNumber"));//V220909
	System.err.println("enableMCNNumberYN in BillingRecordApprovalPatientDataDetails.jsp "+enableMCNNumberYN);
	System.err.println("querystring in BillingRecordApprovalPatientDataDetails.jsp "+request.getQueryString());
	
	
	sql																						=	new StringBuffer();
	recordPreApprovalDataMap																=   new LinkedHashMap();
	System.out.println("patinetId IN BillingRecordApprovalPatientDataDeatils:::: "+patinetId);
	System.out.println("episodeType IN BillingRecordApprovalPatientDataDeatils:::: "+episodeType);
	
	
	//Added By Vijay For AAKH SCF 318
	try
	{
	//con = ConnectionManager.getConnection();checklist	
	siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","RECAPPR_SHW_ALL_WEN_LMT_CROSD");
	System.out.println("SiteSpec "+siteSpec);
	}catch(Exception e)
	{
	e.printStackTrace();
	System.out.println("Exception in site specific "+e);
	}
	//V201024 start
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
	//V201024 end
	
	
	//sql.append(BlRepository.getBlKeyValue("RECORD_PREAPPROVAL_PATIENT_DATA_PART1_QUERY"));
	/* if ( !(patinetId == null || patinetId.equals("")) )
	{
		sql.append(" AND PATIENT_ID = '"+patinetId+"'"); 
	} 
	if ( !(encounterId == null || encounterId.equals("")) )
	{
		sql.append(" AND ENCOUNTER_ID = "+encounterId); 
	}
	if ( !(customerGroupCode == null || customerGroupCode.equals("")) )
	{
		sql.append(" AND CUST_GROUP_CODE = '"+customerGroupCode+"'"); 
	}
	if ( !(customerCode == null || customerCode.equals("")) )
	{
		sql.append(" AND CUST_CODE = '"+customerCode+"'"); 
	}
	if ( !(encounterFromDate == null || encounterFromDate.equals("")) )
	{
		sql.append(" AND EFFECTIVE_FROM = to_date('"+encounterFromDate+"' ,'dd/mm/yyyy')  "); 
	}
	if ( !(encounterToDate == null || encounterToDate.equals("")) )
	{
		sql.append(" AND EFFECTIVE_TO = to_date('"+encounterToDate+"' ,'dd/mm/yyyy')  "); 
	}
	if ( !(policyCode == null || policyCode.equals("")) )
	{
		sql.append(" AND POLICY_TYPE_CODE = '"+policyCode+"' "); 
	} */
	/* if ( !(speciality == null || speciality.equals("")) )
	{
		sql.append(" AND POLICY_TYPE_CODE = '"+speciality+"' "); 
	} */
	//sql.append(BlRepository.getBlKeyValue("RECORD_PREAPPROVAL_PATIENT_DATA_PART2_QUERY"));
	bean_id																					= 	"RecordApprovalPatientDataBean" ;
	bean_name																				= 	"eBL.RecordApprovalPatientDataBean";
	RecordApprovalPatientDataBean recordApprovalPatientDataBean								= 	(RecordApprovalPatientDataBean)getBeanObject( bean_id, bean_name, request ) ;
	isUserCanAcess																			= 	(String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));
	System.out.println("facilityId IN BillingRecordApprovalPatientDataDeatils:::: "+facilityId);
	recordPreApprovalDataMap																=	recordApprovalPatientDataBean.getRecordPreApprovalData(patinetId,patientName,speciality,policyCode,encounterToDate,encounterFromDate,customerCode,customerGroupCode,encounterId, episodeType,requestStatus,facilityId, locale, servGrpCode, servClsfctnCode, orderStatus, "", "", "", 0, 0);		
	/* Modified V190103-Aravindh/MMS-DM-CRF-0125/Added 5 more empty parameters */ 
	
%>
<body onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"    ; onSelect="codeArrestThruSelect();">
	<form id="recordApprovalPatientData" name="recordApprovalPatientData" id="recordApprovalPatientData">	


<%-- <div id="card_type_div" name="card_type_div" style="width:1500px;  overflow: auto; " >		
 <table align='center' cellpadding=3 cellspacing=0 border=1  id="panel_categories_table_header"  name="panel_categories_table_header" id="panel_categories_table_header" >			
		<tr>
			
			
			<th class='CAFLOWSHEETLEVEL1'	align="left"	width="4%"><fmt:message key="Common.SrlNo.label" 					bundle="${common_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="7%"><fmt:message key="Common.patientId.label" 				bundle="${common_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="12%"><fmt:message key="Common.PatientName.label" 			bundle="${common_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="6%"><fmt:message key="Common.episodeid.label" 				bundle="${common_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="8%"><fmt:message key="Common.encounterid.label" 			bundle="${common_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="7%"><fmt:message key="Common.age.label" 					bundle="${common_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="8%"><fmt:message key="Common.MobileNo.label" 				bundle="${common_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="7%" ><fmt:message key="eBL.PayerGroup.label" 				bundle="${bl_labels}"		/></th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="7%" ><fmt:message key="Common.Payer.label" 					bundle="${common_labels}"	/></th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="10%" ><fmt:message key="eBL.POLICY.label" 					bundle="${bl_labels}"		/></th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="10%" ><fmt:message key="eBL.POLICY_EFFECTIVE_TO.label" 		bundle="${bl_labels}"		/></th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="6%" ><fmt:message key="eBL.EffectiveTo.Label" 				bundle="${bl_labels}"		/></th>
			<th class='CAFLOWSHEETLEVEL1' 	align="left"	width="10%" ><fmt:message key="eBL.APPROVED_AMT.label" 				bundle="${bl_labels}"		/></th>
		</tr>

</table>
</div> --%>
	 
	<table cellpadding=2 cellspacing=0  width="100%" id="panel_categories_header_table" name="panel_categories_header_table" id="panel_categories_header_table" border="1"  >	 
		<div id="tableContainer">
		<THEAD style="position: sticky;z-index: 1;top: 0;" >
		<tr >
			<td  colspan='16' class="COLUMNHEADER" align="left">Patient Data</td></tr>	
		<TR>	
			<td class='COLUMNHEADER'	nowrap width='5%'	align="left"	nowrap><fmt:message key="Common.SrlNo.label" 					bundle="${common_labels}"	/></td>
			<td class='COLUMNHEADER' 	width='10%'	align="left"	nowrap><fmt:message key="Common.patientId.label" 				bundle="${common_labels}"	/></td>
			<td class='COLUMNHEADER' 	width='15%'	align="left"	nowrap><fmt:message key="Common.PatientName.label" 			bundle="${common_labels}"	/></td>
			<td class='COLUMNHEADER' 	width='8%'	align="left"	nowrap><fmt:message key="Common.episodeid.label" 				bundle="${common_labels}"	/></td>
			<% 
			if(!siteSpec){
			%>
			<td class='COLUMNHEADER' 	width='8%'	align="left"	nowrap><fmt:message key="Common.VisitID.label" 			bundle="${common_labels}"	/></td> 
			<%} %>
			<td class='COLUMNHEADER' 	width='10%'	align="left"	nowrap><fmt:message key="Common.age.label" 					bundle="${common_labels}"	/></td>
			<td class='COLUMNHEADER' 	width='8%'	align="left"	nowrap><fmt:message key="Common.MobileNo.label" 				bundle="${common_labels}"	/></td>
			<td class='COLUMNHEADER' 	width='5%'	align="left"	nowrap><fmt:message key="eBL.PayerGroup.label" 				bundle="${bl_labels}"		/></td>
			<td class='COLUMNHEADER' 	width='5%'	align="left"	nowrap><fmt:message key="Common.Payer.label" 					bundle="${common_labels}"	/></td>
			<td class='COLUMNHEADER' 	width='5%'	align="left"	nowrap><fmt:message key="eBL.POLICY.label" 					bundle="${bl_labels}"		/></td>
			<td class='COLUMNHEADER' 	width='6%'	align="left"	nowrap><fmt:message key="eBL.EffectiveFrom.Label"				bundle="${bl_labels}"		/></td>
			<td class='COLUMNHEADER' 	width='6%'	align="left"	nowrap><fmt:message key="eBL.EffectiveTo.Label" 				bundle="${bl_labels}"		/></td>
			<td class='COLUMNHEADER' 	width='6%'	align="left"	nowrap><fmt:message key="eBL.APPROVED_AMT.label" 				bundle="${bl_labels}"		/></td>
<!-- 			<td class='COLUMNHEADER' 	width='6%'	align="left"	nowrap>Expiry Date</td>  -->
		</TR>
	</THEAD>
	<TBODY style="height: 20px;">
 		<%
	
		//System.out.println("IN BillingRecordApprovalPatientDataDetails.jsp recordPreApprovalDataMap::::::::"+recordPreApprovalDataMap);
		//System.out.println("IN BillingRecordApprovalPatientDataDetails.jsp recordPreApprovalDataMap:size:::::::"+recordPreApprovalDataMap.size()); 
		//int i=0;
		Iterator iterator= recordPreApprovalDataMap.keySet().iterator();
		
 		
		String isDisabled="disabled";
		String isReadOnly="readonly onfocus='this.blur()'";
	//	System.out.println("episodeType"+episodeType);
		/*if((episodeType.equals("O") || episodeType.equals("E"))&& enabVal.equals("Y")==false){
			isDisabled="disabled";
			isReadOnly="readonly onfocus='this.blur()'";					
		}*/
		
	//	System.out.println("isReadOnly>>"+isReadOnly);
		
		//Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/if condition
		if(recordPreApprovalDataMap.size() <= 0) {
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
		}
		
		
		while(iterator.hasNext())
		{
			
			int index =    (Integer)iterator.next();
			int sNo	  =		index+1;
			//i++;
		//	System.out.println("IN getScreenServiceCriteria index:::::::"+index);
			recordApprovalPatientDataBean = (RecordApprovalPatientDataBean) recordPreApprovalDataMap.get(index);  
			
			
			/* Karthik Record approval   -  MMS-QH-CRF-0165 - Starts */
			
			
			String policyExpiryDate="";
			PreparedStatement pstmtChrg = con.prepareStatement(
			"  select to_char(POLICY_EXPIRY_DATE,'dd/mm/yyyy') from BL_ENCOUNTER_PAYER_PRIORITY "+
										 " WHERE patient_id = ? "+
										 " AND operating_facility_id = ? "+
										 " AND acct_seq_no = ? "+
										 " AND policy_type_code = ? "+
										 " AND policy_number = ? "+
										 " AND cust_code = ? "+
										 " AND cust_group_code = ?  "
										);

			pstmtChrg.setString(1,recordApprovalPatientDataBean.getPatientId()!=null?recordApprovalPatientDataBean.getPatientId():"");
			pstmtChrg.setString(2,(String) session.getValue("facility_id"));
			pstmtChrg.setString(3,recordApprovalPatientDataBean.getAccountSequenceNO()!=null?recordApprovalPatientDataBean.getAccountSequenceNO():"");
			pstmtChrg.setString(4,recordApprovalPatientDataBean.getPolicy()!=null?recordApprovalPatientDataBean.getPolicy():"");
			pstmtChrg.setString(5,recordApprovalPatientDataBean.getPolicyNumber()!=null?recordApprovalPatientDataBean.getPolicyNumber():"");
			pstmtChrg.setString(6,recordApprovalPatientDataBean.getPayer()!=null?recordApprovalPatientDataBean.getPayer():"");
			pstmtChrg.setString(7,recordApprovalPatientDataBean.getPayerGroup()!=null?recordApprovalPatientDataBean.getPayerGroup():"");
			ResultSet rsChrg = pstmtChrg.executeQuery() ;
			if( rsChrg != null ) 
			{	
				if( rsChrg.next() )
				{  
					policyExpiryDate = rsChrg.getString(1);
					if(policyExpiryDate==null) policyExpiryDate="";
				}
			}
			if (rsChrg != null) rsChrg.close();
			if (pstmtChrg != null)  pstmtChrg.close();
			
			//System.out.println("MMS-QH-CRF-0165"+policyExpiryDate + policyCode);
			
			/* Karthik Record approval   -  MMS-QH-CRF-0165 - Ends*/
			/*V201013 start*/
	String 	rowbgColorYN = recordApprovalPatientDataBean.getColorStatus();	
			if (!siteApprovalStatusColorCode)  rowbgColorYN = "N"; //V201024 added
	%>
		<%if(rowbgColorYN.equals("Y")) { %>
			<tr  onclick="changeFieldColor('<%=sNo%>'); showRecordApprovalRequestDetails('<%=index%>');"  >
				<td class="RED"	 width='5%' nowrap id="srl_no<%=index%>"					name="srl_no<%=index%>"	> 					<%=sNo%></td> 
				<td class="RED"   width='10%' nowrap id="patient_id<%=index%>"				name="patient_id<%=index%>">				<%=recordApprovalPatientDataBean.getPatientId()					!=null ? recordApprovalPatientDataBean.getPatientId()				: 	"" %> 	 </td> 
				<td class="RED"	 width='15%'  nowrap id="patient_name<%=index%>"			name="patient_name<%=index%>">				<%=recordApprovalPatientDataBean.getPatientName()	 			!=null 	? 	recordApprovalPatientDataBean.getPatientName()			: 	"" %> </td>
				<td class="RED"	 width='8%'  nowrap id="episode_id<%=index%>"				name="episode_id<%=index%>">				<%=recordApprovalPatientDataBean.getEpisodeId() 					!=null 	? 	recordApprovalPatientDataBean.getEpisodeId()			: 	"" %> </td>  			
 				<%if(!siteSpec){ %>				
				<td class="RED"	 width='8%'  nowrap id="visitId<%=index%>"			name="visitId<%=index%>">	 			<%=recordApprovalPatientDataBean.getVisitId()				!="null" 	? 	recordApprovalPatientDataBean.getVisitId()			: 	"" %> </td> <!--V230209-->
				<%} %>
		 		<td class="RED"	 width='10%'  nowrap id="age<%=index%>"		 				name="age<%=index%>">	 					<%=recordApprovalPatientDataBean.getAge()						!=null 	? 	recordApprovalPatientDataBean.getAge		()			: 	"" %> </td>
				<td class="RED"	 width='8%'  nowrap id="mobile_number<%=index%>"			name="mobile_number<%=index%>">&nbsp;		<%=recordApprovalPatientDataBean.getMobileNumber()				!=null 	? 	recordApprovalPatientDataBean.getMobileNumber()			: 	"" %> </td> 
				<td class="RED"	 width='5%'  nowrap id="payer_group<%=index%>"		 		name="payer_group<%=index%>">				<%=recordApprovalPatientDataBean.getPayerGroupShortName()  			!=null 	? 	recordApprovalPatientDataBean.getPayerGroupShortName()			: 	"" %></td> 
				<td class="RED"	 width='5%'  nowrap id="payer<%=index%>"		 			name="payer<%=index%>"	>	    			<%=recordApprovalPatientDataBean.getPayerShortName()						!=null 	? 	recordApprovalPatientDataBean.getPayerShortName()				: 	"" %></td>
				<td class="RED"	 width='5%'  nowrap id="policy<%=index%>"		 			name="policy<%=index%>">	    			<%=recordApprovalPatientDataBean.getPolicyShortName()						!=null 	? 	recordApprovalPatientDataBean.getPolicyShortName()				: 	"" %></td>
				<td class="RED"	 width='6%'  nowrap id="policy_effective_from<%=index%>"	name="policy_effective_from<%=index%>">	    <%=recordApprovalPatientDataBean.getPolicyEffectiveFrom()		!=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveFrom()	: 	"" %></td> 

				<%if(calledForm.equals("serviceApprStatus")) { %>
					<td class="RED"	 width='6%'  nowrap id="effective_to_fld<%=index%>" <%=isReadOnly%> >
					<label><%=recordApprovalPatientDataBean.getPolicyEffectiveTo() !=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo(): "" %></label>
					<input type='hidden' name="effective_to<%=index%>" size="7" id="effective_to<%=index%>" value="<%=recordApprovalPatientDataBean.getPolicyEffectiveTo() !=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo(): "" %>" >
					<input type='hidden'	name="effective_to_org<%=index%>" size="7" id="effective_to_org<%=index%>"    value="<%=recordApprovalPatientDataBean.getPolicyEffectiveTo() !=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo(): "" %>" >					
					<input type='hidden'  name="encounterId<%=index%>" id="encounterId<%=index%>" value="<%=recordApprovalPatientDataBean.getEncounterId() !=null 	? 	recordApprovalPatientDataBean.getEncounterId(): "" %>"> 								
					</td>
				<%
				} else {
				%>
					<td class="RED"	 width='6%'  nowrap id="effective_to_fld<%=index%>" <%=isReadOnly%> >					
					<input type='text' name="effective_to<%=index%>" size="7" id="effective_to<%=index%>"    onBlur="assignEffectDate(<%=index%>); validDateChk(this); "  value="<%=recordApprovalPatientDataBean.getPolicyEffectiveTo() !=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo(): "" %>"  <%=isDisabled%>>					
					<input type='hidden'	name="effective_to_org<%=index%>" size="7" id="effective_to_org<%=index%>"    value="<%=recordApprovalPatientDataBean.getPolicyEffectiveTo() !=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo(): "" %>" >					
					<input type='hidden'  name="encounterId<%=index%>" id="encounterId<%=index%>" value="<%=recordApprovalPatientDataBean.getEncounterId() !=null 	? 	recordApprovalPatientDataBean.getEncounterId(): "" %>"> 								
					<img src="../../eCommon/images/CommonCalendar.gif" id="eff__to_img<%=index%>" onClick="return setModifiedEffectiveToDate(<%=index%>);"     onKeyPress="return lockbackSpace();" <%=isDisabled%>>					
					</td>
				<%} %>				
				<td class="RED"	 width='6%'  nowrap id="approved_amount<%=index%>"			name="approved_amount<%=index%>">&nbsp;    	<%=recordApprovalPatientDataBean.getApprovedAmount()				!=null 	? 	recordApprovalPatientDataBean.getApprovedAmount()		: 	"" %></td>
				<input type="hidden" name="expiry_date<%=index%>" id="expiry_date<%=index%>" size="7"  value=	<%=recordApprovalPatientDataBean.getPolicyExpDate() !=null 	? 	recordApprovalPatientDataBean.getPolicyExpDate(): "" %>   > 
				<input type="hidden" 	id="visit_id<%=index%>" 			name="visit_id<%=index%>" 	 	 value="<%=recordApprovalPatientDataBean.getVisitId()					!=null 	? 	recordApprovalPatientDataBean.getVisitId()				: 	"" %>" />
				<input type="hidden" 	id="episode_type<%=index%>" 		name="episode_type<%=index%>" 	 value="<%=episodeType					 								!=null 	? 	episodeType												: 	"" %>" />
				<input type="hidden" 	id="priority<%=index%>" 			name="priority<%=index%>" 	 	 value="<%=recordApprovalPatientDataBean.getPriority()					!=null 	? 	recordApprovalPatientDataBean.getPriority()				: 	"" %>" />
				<input type="hidden" 	id="acct_seq_no<%=index%>" 			name="acct_seq_no<%=index%>" 	 value="<%=recordApprovalPatientDataBean.getAccountSequenceNO() 		!=null 	? 	recordApprovalPatientDataBean.getAccountSequenceNO()	: 	"" %>" />
				<input type="hidden" 	id="policy_number<%=index%>" 		name="policy_number<%=index%> "  value="<%=recordApprovalPatientDataBean.getPolicyNumber()				!=null 	? 	recordApprovalPatientDataBean.getPolicyNumber()			: 	"" %>" />				
				<input type="hidden" 	id="p_payer_group<%=index%>" 		name="p_payer_group<%=index%> "  value="<%=recordApprovalPatientDataBean.getPayerGroup()				!=null 	? 	recordApprovalPatientDataBean.getPayerGroup()			: 	"" %>" />
				<input type="hidden" 	id="p_payer<%=index%>" 				name="p_payer<%=index%> "  value="<%=recordApprovalPatientDataBean.getPayer()				!=null 	? 	recordApprovalPatientDataBean.getPayer()			: 	"" %>" />
				<input type="hidden" 	id="p_policy<%=index%>" 			name="p_policy<%=index%> "  value="<%=recordApprovalPatientDataBean.getPolicy()				!=null 	? 	recordApprovalPatientDataBean.getPolicy()			: 	"" %>" />
				<input type="hidden" 	id="rowbgColorYN<%=index%>" 		name="rowbgColorYN<%=index%> "  value="<%=rowbgColorYN%>" />
				<input type="hidden" 	id="membershipno<%=index%>" 		name="membershipno<%=index%>"  value="<%=recordApprovalPatientDataBean.getMembershipNo()  	!=null 	? 	recordApprovalPatientDataBean.getMembershipNo()  	: 	"" %>" /> 
			</tr>			
			<%
		} else {
		/*V201013 end*/
		%>
		
		<tr  onclick="changeFieldColor('<%=sNo%>'); showRecordApprovalRequestDetails('<%=index%>');"  >
				<td class="fields"	 width='5%' nowrap id="srl_no<%=index%>"					name="srl_no<%=index%>"	> 					<%=sNo%></td> 
				<td class="fields"   width='10%' nowrap id="patient_id<%=index%>"				name="patient_id<%=index%>">				<%=recordApprovalPatientDataBean.getPatientId()					!=null ? recordApprovalPatientDataBean.getPatientId()				: 	"" %> 	 </td> 
				<td class="fields"	 width='15%'  nowrap id="patient_name<%=index%>"			name="patient_name<%=index%>">				<%=recordApprovalPatientDataBean.getPatientName()	 			!=null 	? 	recordApprovalPatientDataBean.getPatientName()			: 	"" %> </td>
				<td class="fields"	 width='8%'  nowrap id="episode_id<%=index%>"				name="episode_id<%=index%>">				<%=recordApprovalPatientDataBean.getEpisodeId() 					!=null 	? 	recordApprovalPatientDataBean.getEpisodeId()			: 	"" %> </td> 
 			
 				
 				<%if(!siteSpec){ %>
				
				<td class="fields"	 width='8%'  nowrap id="visitId<%=index%>"			name="visitId<%=index%>">	 			<%=recordApprovalPatientDataBean.getVisitId()				!="null" 	? 	recordApprovalPatientDataBean.getVisitId()			: 	"" %> </td><!--V230209-->
				<%} %>
		 <td class="fields"	 width='10%'  nowrap id="age<%=index%>"		 				name="age<%=index%>">	 					<%=recordApprovalPatientDataBean.getAge()						!=null 	? 	recordApprovalPatientDataBean.getAge		()			: 	"" %> </td>
				<td class="fields"	 width='8%'  nowrap id="mobile_number<%=index%>"			name="mobile_number<%=index%>">&nbsp;		<%=recordApprovalPatientDataBean.getMobileNumber()				!=null 	? 	recordApprovalPatientDataBean.getMobileNumber()			: 	"" %> </td> 
				<td class="fields"	 width='5%'  nowrap id="payer_group<%=index%>"		 		name="payer_group<%=index%>">				<%=recordApprovalPatientDataBean.getPayerGroupShortName()  			!=null 	? 	recordApprovalPatientDataBean.getPayerGroupShortName()			: 	"" %></td> 
				<td class="fields"	 width='5%'  nowrap id="payer<%=index%>"		 			name="payer<%=index%>"	>	    			<%=recordApprovalPatientDataBean.getPayerShortName()						!=null 	? 	recordApprovalPatientDataBean.getPayerShortName()				: 	"" %></td>
				<td class="fields"	 width='5%'  nowrap id="policy<%=index%>"		 			name="policy<%=index%>">	    			<%=recordApprovalPatientDataBean.getPolicyShortName()						!=null 	? 	recordApprovalPatientDataBean.getPolicyShortName()				: 	"" %></td>
				<td class="fields"	 width='6%'  nowrap id="policy_effective_from<%=index%>"	name="policy_effective_from<%=index%>">	    <%=recordApprovalPatientDataBean.getPolicyEffectiveFrom()		!=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveFrom()	: 	"" %></td> 
<%-- 				<td class="fields"	width='7%'  nowrap id="effective_to<%=index%>"	 	name="effective_to<%=index%>">	    		<%=recordApprovalPatientDataBean.getPolicyEffectiveTo() 			!=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo()	: 	"" %></td> --%>
				
								<!-- Karthik Record approval   -  MMS-QH-CRF-0165 - Starts-->
				
				
				<!-- Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/if-else Starts -->
				<%if(calledForm.equals("serviceApprStatus")) { %>
					<td class="fields"	width='6%'  nowrap id="effective_to_fld<%=index%>" <%=isReadOnly%> >
					<label><%=recordApprovalPatientDataBean.getPolicyEffectiveTo() !=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo(): "" %></label>
					<input type='hidden' name="effective_to<%=index%>" id="effective_to<%=index%>" size="7"  value="<%=recordApprovalPatientDataBean.getPolicyEffectiveTo() !=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo(): "" %>" >
					<input type='hidden'	name="effective_to_org<%=index%>" id="effective_to_org<%=index%>" size="7" value="<%=recordApprovalPatientDataBean.getPolicyEffectiveTo() !=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo(): "" %>" >
					
					<input type='hidden'  name="encounterId<%=index%>" id="encounterId<%=index%>" value="<%=recordApprovalPatientDataBean.getEncounterId() !=null 	? 	recordApprovalPatientDataBean.getEncounterId(): "" %>"> 			
					
					</td>
				<%
				} else {
				%>
					<td class="fields"	width='6%'  nowrap id="effective_to_fld<%=index%>" <%=isReadOnly%> >
					
					<input type='text' name="effective_to<%=index%>" id="effective_to<%=index%>" size="7" onBlur="assignEffectDate(<%=index%>); validDateChk(this); "  value="<%=recordApprovalPatientDataBean.getPolicyEffectiveTo() !=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo(): "" %>"  <%=isDisabled%>>
					
					<input type='hidden'	name="effective_to_org<%=index%>" id="effective_to_org<%=index%>" size="7" value="<%=recordApprovalPatientDataBean.getPolicyEffectiveTo() !=null 	? 	recordApprovalPatientDataBean.getPolicyEffectiveTo(): "" %>" >
					
					<input type='hidden'  name="encounterId<%=index%>" id="encounterId<%=index%>" value="<%=recordApprovalPatientDataBean.getEncounterId() !=null 	? 	recordApprovalPatientDataBean.getEncounterId(): "" %>"> 			
					
					<img src="../../eCommon/images/CommonCalendar.gif" id="eff__to_img<%=index%>" onClick="return setModifiedEffectiveToDate(<%=index%>);"     onKeyPress="return lockbackSpace();" <%=isDisabled%>>
					
					
					</td>
				<%} %>
				<!-- Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/if-else ends -->
				 
				<td class="fields"	width='6%'  nowrap id="approved_amount<%=index%>"			name="approved_amount<%=index%>">&nbsp;    	<%=recordApprovalPatientDataBean.getApprovedAmount()				!=null 	? 	recordApprovalPatientDataBean.getApprovedAmount()		: 	"" %></td>

<%-- 				<td class="fields"	width='6%' nowrap id="expiry_date_fld<%=index%>">				 --%>
				<input type="hidden" name="expiry_date<%=index%>" id="expiry_date<%=index%>" size="7"  value=	<%=recordApprovalPatientDataBean.getPolicyExpDate() !=null 	? 	recordApprovalPatientDataBean.getPolicyExpDate(): "" %>   > 
<%-- 				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('expiry_date<%=index%>');"  onKeyPress="return lockbackSpace();" <%=isDisabled%>> --%>
<!-- 				</td> -->
				<!-- Karthik Record approval   -  MMS-QH-CRF-0165	-->
				<input type="hidden" 	id="visit_id<%=index%>" 			name="visit_id<%=index%>" 	 	 value="<%=recordApprovalPatientDataBean.getVisitId()					!=null 	? 	recordApprovalPatientDataBean.getVisitId()				: 	"" %>" />
				<input type="hidden" 	id="episode_type<%=index%>" 		name="episode_type<%=index%>" 	 value="<%=episodeType					 								!=null 	? 	episodeType												: 	"" %>" />
				<input type="hidden" 	id="priority<%=index%>" 			name="priority<%=index%>" 	 	 value="<%=recordApprovalPatientDataBean.getPriority()					!=null 	? 	recordApprovalPatientDataBean.getPriority()				: 	"" %>" />
				<input type="hidden" 	id="acct_seq_no<%=index%>" 			name="acct_seq_no<%=index%>" 	 value="<%=recordApprovalPatientDataBean.getAccountSequenceNO() 		!=null 	? 	recordApprovalPatientDataBean.getAccountSequenceNO()	: 	"" %>" />
				<input type="hidden" 	id="policy_number<%=index%>" 		name="policy_number<%=index%> "  value="<%=recordApprovalPatientDataBean.getPolicyNumber()				!=null 	? 	recordApprovalPatientDataBean.getPolicyNumber()			: 	"" %>" />
				
				<input type="hidden" 	id="p_payer_group<%=index%>" 		name="p_payer_group<%=index%> "  value="<%=recordApprovalPatientDataBean.getPayerGroup()				!=null 	? 	recordApprovalPatientDataBean.getPayerGroup()			: 	"" %>" />
				<input type="hidden" 	id="p_payer<%=index%>" 				name="p_payer<%=index%> "  value="<%=recordApprovalPatientDataBean.getPayer()				!=null 	? 	recordApprovalPatientDataBean.getPayer()			: 	"" %>" />
				<input type="hidden" 	id="p_policy<%=index%>" 			name="p_policy<%=index%> "  value="<%=recordApprovalPatientDataBean.getPolicy()				!=null 	? 	recordApprovalPatientDataBean.getPolicy()			: 	"" %>" />
				<input type="hidden" 	id="rowbgColorYN<%=index%>" 		name="rowbgColorYN<%=index%> "  value="<%=rowbgColorYN %>" /> <%--V201013 added  --%>
				<input type="hidden" 	id="membershipno<%=index%>" 		name="membershipno<%=index%>"  value="<%=recordApprovalPatientDataBean.getMembershipNo()  	!=null 	? 	recordApprovalPatientDataBean.getMembershipNo()  	: 	"" %>" /> 
			</tr>
			
			<%
		} //V201013 added 
	}		
			%>
	
	</table>
		<input type='hidden' name='prevClicked' id='prevClicked' value="" />
		<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
		<input type='hidden' name='facilityId' id='facilityId' value="<%=facilityId%>" >
		<input type='hidden' name='mode' id='mode' value="<%=mode%>" >
		<input type='hidden' name='requestStatus' id='requestStatus'	id='requestStatus'	 value="<%=requestStatus%>" >
		<input type='hidden' name='printUCAFIndex' id='printUCAFIndex'	id='printUCAFIndex'	 value="-1" >
		<input type='hidden' name='prevIndex' id='prevIndex'	id='prevIndex'	 value="-1" >		
		<input type='hidden' name='siteSpec' id='siteSpec' id='siteSpec' value='<%=siteSpec %>'/>
		
		<!-- Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Starts -->
		<input type='hidden' name='calledForm' id='calledForm'	id='calledForm'	 value="<%=calledForm %>" >
		<input type='hidden' name='service_group' id='service_group'	id='service_group'	 value="<%=servGrpCode %>" >
		<input type='hidden' name='service_classification' id='service_classification'	id='service_classification'	 value="<%=servClsfctnCode %>" >
		<input type='hidden' name='order_status' id='order_status'	id='order_status'	 value="<%=orderStatus %>" >
		<input type='hidden' name='siteApprovalStatusColorCodeYN' id='siteApprovalStatusColorCodeYN' id='siteApprovalStatusColorCodeYN' value='<%=siteApprovalStatusColorCodeYN %>'/> <!-- V201024 added -->
		<!-- Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Ends -->
		<input type="hidden" name="enableMCNNumber" id="enableMCNNumber" id="enableMCNNumber" 	value="<%=enableMCNNumberYN %>"><!-- V220909 -->
		
<%--		<input type='hidden' name='authorized' id='authorized' value="<%=authorized%>" /> 
		<input type='hidden' name='isUserCanAcess' id='isUserCanAcess' value="<%=isUserCanAcess%>" /> --%>

</form>	
<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'></div>	
<% if(calledForm.equals("ApprStsTrack") || calledForm.equals("preAuthStsTrack")){%>
<script>
	parent.recordApprovalSearch.recordApproval.add_mod.disabled = true;
</script>
<% } else{%>
<script>
	parent.recordApprovalSearch.recordApproval.add_mod.disabled = false;
</script>
<% } //44856 %>
</body>
	</TBODY>
</div>
<%
}
catch(Exception e)
{
	System.out.println("Exception in BillingRecordApprovalPatientDataDeatils.jsp::"+e);
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

