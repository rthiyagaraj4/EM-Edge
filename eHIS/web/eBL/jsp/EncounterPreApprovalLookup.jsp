<!DOCTYPE html>
<!--
---------------------------------------------------------------------------------------------------------------
Sr No        Version           TFS/Incident        SCF/CRF            		 Developer Name
--------------------------------------------------------------------------------------------------------
1            V220413            30399          MMS-ME-SCF-0064-TF               Mohanapriya K
--------------------------------------------------------------------------------------------------------
-->
<%@page import="eBL.PolicyInsuranceMasterBean"%>
<%@page import="webbeans.eCommon.ConnectionManager,org.apache.commons.codec.binary.Base64"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="eBL.Common.BlRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
			
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String readonly = "";
	String inclExclDesc = "";
	String inclExclCode = "";
	LinkedHashMap<String,String> criteriaMap = new LinkedHashMap<String,String>();
	PolicyInsuranceMasterBean fmtDtlsBean = null;
	request.setCharacterEncoding("UTF-8");
%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/EncounterSpecPolicyDefnSrch.js"></script>
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
		
		div.tableContainer {
		width: 100%;		/* table width will be 99% of this*/
		height: 140px; 	/* must be greater than tbody*/
		overflow: scroll;
		margin: 0 auto;
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
		</style>
		
		
		<%

String strQueryString= checkForNull(request.getParameter("queryString"));
if(strQueryString.length()==0)	strQueryString= request.getQueryString();

%>

<script language = 'javascript'>
function movePrevthis(start,end)
{
	var params =  document.forms[0].queryString.value;
	

//	var params =  document.forms[0].queryString.value;
 	
  
 var strt = start-20;
 var endd= end-20;
	
 
	parent.frames[0].location.href="../../eBL/jsp/EncounterPreApprovalLookup.jsp?from="+strt+"&to="+endd+"&"+params;
	
	}
	
function moveNextthis(start,end)
{
	var params =  document.forms[0].queryString.value;

	
	var strt = start +20;
	var endd= end+20 ;


 parent.frames[0].location.href="../../eBL/jsp/EncounterPreApprovalLookup.jsp?from="+strt+"&to="+endd+"&"+params;

	
}

function applyFilter(criteria,bgCode,bgDesc){
	var params =  document.forms[0].queryString.value;
	var frm = document.forms[0];
	var start = document.forms[0].from.value;
	var end = document.forms[0].to.value;
	//parent.frames[0].location.href="../../eBL/jsp/EncounterPreApprovalLookup.jsp?from="+start+"&to="+end+"&criteria_Filter="+criteria.value+
	parent.frames[0].location.href="../../eBL/jsp/EncounterPreApprovalLookup.jsp?criteria_Filter="+criteria.value+	
	"&episodeFilter="+frm.episodeFilter.value+"&ptClassFilter="+frm.ptClassFilter.value+
	"&ageGroupFilter="+frm.hdn_age_groupFilter.value+"&genderFilter="+frm.genderFilter.value+
	"&clinicIndFilter="+frm.clinicFilter.value+"&clinicFilter="+frm.clinic_codeFilter.value+
	"&specFilter="+frm.spec_codeFilter.value+"&effFromFilter="+frm.effFrom_filter.value+
	"&specDescFilter="+escape(frm.spec_descFilter.value)+"&clinicDescFilter="+escape(frm.clinic_descFilter.value)+
	"&ageGroupDescFilter="+escape(frm.age_groupFilter.value)+
	"&bgCodeFilter="+bgCode.value+"&bgDescFilter="+escape(bgDesc.value)+
	"&title=Include Exclude Details"+
	"&source=PolicyDetailsData"+
	"&startDate="+frm.startDate.value+
	"&endDate="+frm.endDate.value+
	"&mode=modify"+
	"&payergroupCode="+frm.payerGroup.value+
	"&payerCode="+frm.payer.value+
	"&policyCode="+frm.policy.value+
	"&patientId="+frm.patientId.value+
	"&visitId="+frm.visitId.value+
	"&acctSeq="+frm.acctSeq.value+
	"&priority="+frm.priority.value+
	"&episodeType="+frm.episodeType.value+
	"&episodeId="+frm.episodeId.value;
}

function resetFilter(){
	var params =  document.forms[0].queryString.value;
	var frm = document.forms[0];
	parent.frames[0].location.href="../../eBL/jsp/EncounterPreApprovalLookup.jsp?"+
	"title=Include Exclude Details"+
	"&source=PolicyDetailsData"+
	"&startDate="+frm.startDate.value+
	"&endDate="+frm.endDate.value+
	"&mode=modify"+
	"&payergroupCode="+frm.payerGroup.value+
	"&payerCode="+frm.payer.value+
	"&policyCode="+frm.policy.value+
	"&patientId="+frm.patientId.value+
	"&visitId="+frm.visitId.value+
	"&acctSeq="+frm.acctSeq.value+
	"&priority="+frm.priority.value+
	"&episodeType="+frm.episodeType.value+
	"&episodeId="+frm.episodeId.value;
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<%
	String mode = checkForNull(request.getParameter("mode"));
	List<PolicyInsuranceMasterBean> policyList = new ArrayList<PolicyInsuranceMasterBean>(); 
	String checked = "";
	String disabled = "";
	String exclDisabled = "";
	//String facility_id = (String)session.getAttribute("facility_id");
	String payerGroup = checkForNull(request.getParameter("payergroupCode"));
	String payer = checkForNull(request.getParameter("payerCode"));
	String policy = checkForNull(request.getParameter("policyCode"));
	String startDate = checkForNull(request.getParameter("startDate"));
	String endDate = checkForNull(request.getParameter("endDate"));
	String patientId ="";
	//V220413
	if("Y".equals(request.getParameter("compressed")==null?"":request.getParameter("compressed"))) {
			patientId = new String(Base64.decodeBase64(((String)request.getParameter("patientId")).getBytes())); 
	}else{
		patientId = checkForNull(request.getParameter("patientId"));
	}
	System.out.println("preapp lookup 883 patientId=>"+patientId);
	System.out.println("preapp lookup 883 payerGroup=>"+payerGroup);
	System.out.println("preapp lookup 883 payer=>"+payer);
	System.out.println("preapp lookup 883 policy=>"+policy);
	System.out.println("preapp lookup 883 startDate=>"+startDate);
	System.out.println("preapp lookup 883 endDate=>"+endDate);
	//V220413
	String visitId = checkForNull(request.getParameter("visitId"));
	String acctSeq = checkForNull(request.getParameter("acctSeq"));
	String priority = checkForNull(request.getParameter("priority"));
	String episodeType = checkForNull(request.getParameter("episodeType"));
	String episodeId = checkForNull(request.getParameter("episodeId"));

	String criteria_Filter = checkForNull(request.getParameter("criteria_Filter"));
	String bgCodeFilter = checkForNull(request.getParameter("bgCodeFilter"));
	String bgDescFilter = checkForNull(request.getParameter("bgDescFilter"));
	bgDescFilter = java.net.URLDecoder.decode(bgDescFilter,"UTF-8");
	String episodeFilter = checkForNull(request.getParameter("episodeFilter"));
	String ptClassFilter = checkForNull(request.getParameter("ptClassFilter"));
	String ageGroupFilter = checkForNull(request.getParameter("ageGroupFilter"));
	String genderFilter = checkForNull(request.getParameter("genderFilter"));
	String clinicIndFilter = checkForNull(request.getParameter("clinicIndFilter"));
	String clinicFilter = checkForNull(request.getParameter("clinicFilter"));
	String specFilter = checkForNull(request.getParameter("specFilter"));
	String effFromFilter = checkForNull(request.getParameter("effFromFilter"));
	String clinicDescFilter = checkForNull(request.getParameter("clinicDescFilter"));
	clinicDescFilter = java.net.URLDecoder.decode(clinicDescFilter,"UTF-8");
	String specDescFilter = checkForNull(request.getParameter("specDescFilter"));
	specDescFilter = java.net.URLDecoder.decode(specDescFilter,"UTF-8");
	String ageGroupDescFilter = checkForNull(request.getParameter("ageGroupDescFilter"));
	ageGroupDescFilter = java.net.URLDecoder.decode(ageGroupDescFilter,"UTF-8");
	//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
	Boolean SiteSpec_PreappDur=false;
	String Site_PreappDur ="N";
	//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends
	//Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts
	Boolean SiteSpec_preapp_across_enc=false;
	String Site_preapp_across_enc="N";
	//Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	String sqlCoverage = "";
	String partSql = "";
	String partExclSql = "";
	//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 STARTS-->
	Boolean SiteSpecGroupService = false;
	String SiteSpecGroupServiceInd = "";
	//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 ENDS-->
try{
	con = ConnectionManager.getConnection(request);
	//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 STARTS-->
	SiteSpecGroupService = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_GROUP_SRVICE_IND");
	if (SiteSpecGroupService) {
		SiteSpecGroupServiceInd = "Y";
	} else {
		SiteSpecGroupServiceInd = "N";
	}
	//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 ENDS-->
	if(("I".equals(episodeType)) || ("D".equals(episodeType))){
		partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_ID");
	}
	else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
		partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_OE");
	}
	else if("R".equals(episodeType)){
		partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_INCL_EXCL_PART_R");
	}
		
	sqlCoverage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_PRE_APPROVAL")+partSql;

	if(!("".equals(criteria_Filter))){
		sqlCoverage += "and hdr.serv_excl_incl_crit = '"+criteria_Filter+"' ";
	}
	if(!("".equals(bgCodeFilter))){
		sqlCoverage += "and hdr.blng_serv_code = '"+bgCodeFilter+"' ";
	}
	if(!("".equals(episodeFilter))){
		sqlCoverage += "and hdr.episode_or_encounter_flag = '"+episodeFilter+"' ";
	}
	if(!("".equals(ptClassFilter))){
		sqlCoverage += "and hdr.patient_class = '"+ptClassFilter+"' ";
	}
	if(!("".equals(ageGroupFilter))){
		sqlCoverage += "and hdr.AGE_GROUP_CODE = '"+ageGroupFilter+"' ";
	}
	if(!("".equals(genderFilter))){
		sqlCoverage += "and hdr.SEX = '"+genderFilter+"' ";
	}
	if(!("".equals(clinicIndFilter))){
		sqlCoverage += "and hdr.clinic_nursing_ind = '"+clinicIndFilter+"' ";
	}
	if(!("".equals(clinicFilter))){
		sqlCoverage += "and hdr.clinic_nursing_code = '"+clinicFilter+"' ";
	}
	if(!("".equals(specFilter))){
		sqlCoverage += "and hdr.splty_code = '"+specFilter+"' ";
	}
	if(!("".equals(effFromFilter))){
		sqlCoverage += "and to_char(hdr.effective_from,'dd/mm/yyyy') = '"+effFromFilter+"' ";
	}
		
	pstmt = con.prepareStatement(sqlCoverage);
	pstmt.setString(1,locale);
	pstmt.setString(2,locale);
	pstmt.setString(3,locale);
	pstmt.setString(4,locale);
	pstmt.setString(5,facility_id);
	pstmt.setString(6,payerGroup);
	pstmt.setString(7,payer);
	pstmt.setString(8,policy);
	pstmt.setString(9,patientId);
		
	if(("I".equals(episodeType)) || ("D".equals(episodeType))){
		pstmt.setString(10,episodeType);
		pstmt.setString(11,episodeId);
		pstmt.setString(12,acctSeq);
		pstmt.setString(13,priority);

	}
	else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
		pstmt.setString(10,episodeType);
		pstmt.setString(11,episodeId);
		pstmt.setString(12,visitId);
		pstmt.setString(13,acctSeq);
		pstmt.setString(14,priority);
			
	}
	else if("R".equals(episodeType)){
			
		pstmt.setString(10,episodeType);
		pstmt.setString(11,acctSeq);
		pstmt.setString(12,priority);
			
	}
	rst = pstmt.executeQuery();
	
	if(rst!=null){
		policyList = new ArrayList<PolicyInsuranceMasterBean>();
		int rsCnt = 0;
		while (rst.next()) {
			fmtDtlsBean = new PolicyInsuranceMasterBean();
			fmtDtlsBean.setPatClass(rst.getString("patient_class"));
			fmtDtlsBean.setAgeGroup(rst.getString("AGE_GROUP_CODE"));
			fmtDtlsBean.setAgeGroupDesc(rst.getString("age_group_desc"));
			fmtDtlsBean.setGender(rst.getString("SEX"));
			fmtDtlsBean.setEpisodeEncounter(rst.getString("episode_or_encounter_flag"));
			fmtDtlsBean.setClinicNurs(rst.getString("clinic_nursing_ind"));
			fmtDtlsBean.setClinicNursCode(rst.getString("clinic_nursing_code"));
			fmtDtlsBean.setClinicNursDesc(rst.getString("clinic_nursing_desc"));
			fmtDtlsBean.setSpecCode(rst.getString("splty_code"));
			fmtDtlsBean.setSpecDesc(rst.getString("spec_desc"));
			fmtDtlsBean.setType(rst.getString("serv_excl_incl_crit"));
			fmtDtlsBean.setBillServCode(rst.getString("blng_serv_code"));
			fmtDtlsBean.setBillServDesc(rst.getString("blng_serv_desc"));
			fmtDtlsBean.setPreApprAmtCapping(rst.getString("preapproval_amt_capping"));
			fmtDtlsBean.setPreApprQtyCapping(rst.getString("preapproval_qty_capping"));
			fmtDtlsBean.setPreApprDurCapping(rst.getString("preapproval_dur_capping"));
			fmtDtlsBean.setPreacrossenc(rst.getString("ACROSS_ENC_PREAPP_YN"));  //Added V190326-Dhananjay/MMS-DM-CRF-0158
			//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 Starts
			if("Y".equals(SiteSpecGroupServiceInd)){
				fmtDtlsBean.setpreAppGroupRservice(rst.getString("GROUP_SERVICE_IND"));
			}
			//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 Ends
			fmtDtlsBean.setServLimit(rst.getString("service_level_approval_yn"));
			fmtDtlsBean.setStartDate(rst.getString("effective_from"));
			fmtDtlsBean.setEndDate(rst.getString("effective_to"));
			fmtDtlsBean.setAmtGrossNet(rst.getString("preapproval_amt_gross_net"));
			fmtDtlsBean.setStatus("I");
			policyList.add(fmtDtlsBean);
			rsCnt++;					
		}
		/*if(rsCnt<1){
			PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
			titleBean.setStartDate(startDate);
			titleBean.setEndDate(endDate);
			policyList = new ArrayList<PolicyInsuranceMasterBean>();
			policyList.add(titleBean);
		}*/
	}
	else{
		/*PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
		titleBean.setStartDate(startDate);
		titleBean.setEndDate(endDate);
		policyList = new ArrayList<PolicyInsuranceMasterBean>();
		policyList.add(titleBean);*/
	}	
		
			pstmt = null;
			rst = null;
			String inclExclSql  =  	BlRepository.getBlKeyValue("POLICY_DEF_INCL_EXCL_CRITERIA");
			pstmt = con.prepareStatement(inclExclSql);
			pstmt.setString(1,locale);
			rst = pstmt.executeQuery();
			
			if(rst!=null){
				while(rst.next()){
					criteriaMap.put(rst.getString("code"),rst.getString("description"));
				}	
			}
			//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
			SiteSpec_PreappDur = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_PRE_APP_DUR_CAPPING");	
			if(SiteSpec_PreappDur){
				Site_PreappDur ="Y";
			}
			else{
				Site_PreappDur ="N";
			}
			//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends
			//Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts
			SiteSpec_preapp_across_enc = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ENABLE_PREAPP_ACR_ENT_YN");
			if(SiteSpec_preapp_across_enc){
				Site_preapp_across_enc ="Y";
			} else{
				Site_preapp_across_enc ="N";
			}
			//Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends
	}
	catch(Exception e){
		System.err.println("Exception In Encounter Pre Approval LookUp "+e);
		e.printStackTrace();
	}
	finally{
		ConnectionManager.returnConnection(con);
		pstmt = null;
		rst = null;
	}
%>
	<form  id="frmPolicyInclExclCoverage">	
	
	
	<%
	
	int start = 0 ;
	int end = 0 ;
	int i=1;
	
	String from = checkForNull(request.getParameter("from"));
	String to = checkForNull(request.getParameter("to"));
	
	
	
	
	if ( from.length()== 0 )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;
	if ( to.length()==0)
	  	end = 20 ;
	else
		end = Integer.parseInt( to ) ;

		System.out.println("from  "+start);
		System.out.println("to  "+end);
		System.out.println("size 883 "+policyList.size());
		
		
	
	%>
	
	<%
if ( !(start <= 1) )
	out.println("<A HREF='javascript:movePrevthis("+start+","+end+")'   text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if(policyList.size() > end)
	out.println("<A id='nextvalue' HREF='javascript:moveNextthis("+start+","+end+")'  text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

	%>
	
	
      	<table class='grid' border='1' width='250%' cellpadding='3'  cellspacing=0 align="center" id='PolicyInclExcl'>
      	<div id="tableContainer">
      	<thead>  
      		<tr>
      			<td class='COLUMNHEADER' nowrap>S No</td>
      			<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EpisodeEncounter.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.HCMasterAgeGroup.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.ClinicNu.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.ClinicNuDetails.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.SpecDetails.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.type.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PreAppAmtCap.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap>Gross / Net</td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PreAppQtyCap.label" bundle="${bl_labels}"/></td>
					<% //Added V180725-Gayathri/MMS-DM-CRF-0126
					if("Y".equals(Site_PreappDur)){ %>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PreAppDurCap.label" bundle="${bl_labels}"/></td>
				<%} %>
				<!-- MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 STARTS -->
				<%if("Y".equals(SiteSpecGroupServiceInd)){ %>
					<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.GroupService.label" bundle="${bl_labels}"/></td>
				<%} %>	
				<!-- MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 Ends -->
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.servicedtls.label" bundle="${bl_labels}"/></td>
				<!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts -->
				<%if("Y".equals(Site_preapp_across_enc)) {%>
					<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.Preacrossenc.label" bundle="${bl_labels}"/></td>
				<%} %>
				<!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends -->
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffFromDate.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffToDate.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap>Delete Record</td>
			 </tr>
			 <tr>
			 	<td nowrap><input type='button' id='apply_filter' value='Search' onclick='applyFilter(criteriaFilter,bg_code_filter,bg_desc_filter)'>&nbsp;
			 	<input type='button' id='apply_filter' value='Reset' onclick='resetFilter()'></td>
			 	<td nowrap><select id='episodeFilter' name='episodeFilter' id='episodeFilter'>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value='E' <%=("E".equals(episodeFilter))?"selected":"" %>>Episode</option>
						<option value='N' <%=("N".equals(episodeFilter))?"selected":"" %>>Encounter</option>
						<option value='A' <%=("A".equals(episodeFilter))?"selected":"" %>>All</option>					</select>
				</td>
				<td nowrap>
					<select id='ptClassFilter' name='ptClassFilter' id='ptClassFilter'>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value='OP' <%=("OP".equals(ptClassFilter))?"selected":"" %>>OP</option>
						<option value='IP' <%=("IP".equals(ptClassFilter))?"selected":"" %>>IP</option>
						<option value='DC' <%=("DC".equals(ptClassFilter))?"selected":"" %>>DC</option>
						<option value='XT' <%=("XT".equals(ptClassFilter))?"selected":"" %>>EX</option>
						<option value='EM' <%=("EM".equals(ptClassFilter))?"selected":"" %>>EM</option>
						<option value='**' <%=("**".equals(ptClassFilter))?"selected":"" %>>All</option>
					</select>
				</td>
				<td nowrap>
					<input type='text' name='age_groupFilter' id='age_groupFilter' id='age_groupFilter' value='<%=ageGroupDescFilter %>' length='15' onblur='if(this.value.length>0){ callCommonValidation(5,this,hdn_age_groupFilter); } else{ fnClearCode(hdn_age_groupFilter); }'>
					<input type='hidden' name='hdn_age_groupFilter' id='hdn_age_groupFilter' id='hdn_age_groupFilter' value='<%=ageGroupFilter %>' >
					<input type='button' id='age_but_Filter' value='?' onclick='callCommonValidation(5,age_groupFilter,hdn_age_groupFilter)'>					
				</td>
				<td nowrap>
					<select id='genderFilter' name='genderFilter' id='genderFilter'>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value='M' <%=("M".equals(genderFilter))?"selected":"" %>>Male</option>
						<option value='F' <%=("F".equals(genderFilter))?"selected":"" %>>Female</option>
						<option value='A' <%=("A".equals(genderFilter))?"selected":"" %>>Both</option>				</td>
				<td nowrap>
					<select id='clinicFilter' name='clinicFilter' id='clinicFilter' >
					<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value='C' <%=("C".equals(clinicIndFilter))?"selected":"" %>>Clinic</option>
						<option value='N' <%=("N".equals(clinicIndFilter))?"selected":"" %>>Nursing Unit</option>
						<option value='A' <%=("A".equals(clinicIndFilter))?"selected":"" %>>All</option>					</select>
				</td>
				<td nowrap>
					<input type='text' id='clinic_codeFilter' name='clinic_codeFilter' id='clinic_codeFilter' value='<%=clinicFilter %>' size='4' onblur='if(this.value.length>0){ callBGDescCode(1,clinicFilter,clinic_descFilter,clinic_codeFilter); } else{ fnClearCode(clinic_descFilter); }'> 
					<input type='text' id='clinic_descFilter' name='clinic_descFilter' id='clinic_descFilter' value='<%=clinicDescFilter %>' size='20' maxlength='60' onblur='if(this.value.length>0){ callBGDesc(1,clinicFilter,clinic_descFilter,clinic_codeFilter); } else{ fnClearCode(clinic_codeFilter); }'>
					<input type='button' id='clinic_butFilter' value='?' onclick='callBGDesc(1,clinicFilter,clinic_descFilter,clinic_codeFilter)'>
				</td> 
				<td nowrap>
					<input type='text' id='spec_codeFilter' name='spec_codeFilter' id='spec_codeFilter' size='5' value='<%=specFilter %>' onblur='if(this.value.length>0){ callCommonValidationSpecCode(spec_descFilter,spec_codeFilter,clinicFilter,clinic_codeFilter); } else{ fnClearCode(spec_descFilter); }'>
					<input type='text' id='spec_descFilter' name='spec_descFilter' id='spec_descFilter' size='20' value='<%=specDescFilter %>' onblur='if(this.value.length>0){ callCommonValidationSpec(spec_descFilter,spec_codeFilter,clinicFilter,clinic_codeFilter); } else{ fnClearCode(spec_codeFilter); }'>
					<input type='button' id='spec_butFilter' value='?' onclick='callCommonValidationSpec(spec_descFilter,spec_codeFilter,clinicFilter,clinic_codeFilter)'>					
				</td>
				<td nowrap>
					<select name='criteriaFilter' id='criteriaFilter'>		
					<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>			
					<%
					for (Iterator iterator = criteriaMap.keySet().iterator(); iterator.hasNext();) {
						String type = (String) iterator.next();
						if(type.equals(criteria_Filter)){
					%>	
						<option value='<%=type%>' selected="selected"><%=criteriaMap.get(type) %></option>
					<%}
						else{%>
							<option value='<%=type%>'><%=criteriaMap.get(type) %></option>
						<%}
					}
					%>
					</select>
				</td>
				<td nowrap>
					<input type='text' id='bg_code_filter' name='bg_code_filter' id='bg_code_filter' size='12'   value='<%=bgCodeFilter %>' onblur="if(this.value!=''){ callBGDescCode(2,criteriaFilter,bg_desc_filter,bg_code_filter); } else{ fnClearCode(bg_desc_filter); } " >
					<input type='text' id='bg_desc_filter' name='bg_desc_filter' id='bg_desc_filter'  size='20'  value='<%=bgDescFilter %>' onblur="if(this.value!=''){ callBGDesc(2,criteriaFilter,bg_desc_filter,bg_code_filter); } else{ fnClearCode(bg_code_filter); }">
					<input type='button' id='bg_but_filter' value='?'  onclick='callBGDesc(2,criteriaFilter,bg_desc_filter,bg_code_filter)' >					
				</td>
				<td  nowrap colspan='4'>&nbsp;</td>
				<%if("Y".equals(Site_PreappDur)) {%>
					<td  nowrap colspan='2'>&nbsp;</td>
					<%} %>
				<td nowrap>
					<input type='text' id='effFrom_filter' name='effFrom_filter' id='effFrom_filter' value='<%=effFromFilter %>' size='10' onblur='isValidDate(this);'>
					<img src='../../eCommon/images/CommonCalendar.gif' id='effFrom_ctrl_filter' onClick='return showCalendar("effFrom_filter")' />
				</td>
			</tr>
			 </thead>
			 <TBODY>
			<%
				int tableIndex = 1;
			 
			 int tindex =0;
			 
			 
					for (PolicyInsuranceMasterBean policyBean1 : policyList) {
						
						tindex++;	
						if(tindex < start)
						{					
							continue;
						}
					if(tindex > end)
							break;
			%>	
			 <tr onclick='fnLoadSelectedCoverage("<%=policyBean1.getEpisodeEncounter()%>","<%=policyBean1.getPatClass()%>","<%=policyBean1.getAgeGroup()%>","<%=policyBean1.getGender()%>","<%=policyBean1.getClinicNurs()%>",
			 "<%=policyBean1.getClinicNursCode()%>","<%=policyBean1.getSpecCode()%>","<%=policyBean1.getType()%>","<%=policyBean1.getBillServCode()%>","<%=policyBean1.getStartDate()%>","preApprovalLookup")'>
			 	<td nowrap class='fields'>
			 		<%=tindex %>
			 	</td>
			 	<td nowrap class='fields'>
						<%if("E".equals(policyBean1.getEpisodeEncounter())){ %>
							<fmt:message key="eBL.Episode.label" bundle="${bl_labels}"/>
						<%}

						else if("N".equals(policyBean1.getEpisodeEncounter())){ %>
							<fmt:message key="eBL.Encounter.label" bundle="${bl_labels}"/>
						<%}
						
						else if("A".equals(policyBean1.getEpisodeEncounter())){ %>
							<fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/>
						<%}%>
				</td>
				<td nowrap class='fields'>
						<%if("OP".equals(policyBean1.getPatClass())){ %>
							<fmt:message key="Common.OP.label" bundle="${common_labels}"/>
						<%}
						else if("IP".equals(policyBean1.getPatClass())){ %>
							<fmt:message key="Common.IP.label" bundle="${common_labels}"/>
						<%}
						else if("DC".equals(policyBean1.getPatClass())){ %>
							<fmt:message key="Common.DC.label" bundle="${common_labels}"/>
						<%}
						else if("XT".equals(policyBean1.getPatClass())){ %>
							<fmt:message key="eBL.EX.label" bundle="${bl_labels}"/>
						<%}
						else if("EM".equals(policyBean1.getPatClass())){ %>
							<fmt:message key="eBL.EM.label" bundle="${bl_labels}"/>
						<%}
						else if("**".equals(policyBean1.getPatClass())){ %>
							<fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/>
						<%} %>
					</select>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getAgeGroupDesc()) %>
				</td>
				<td nowrap class='fields'>
						<%if("M".equals(policyBean1.getGender())){ %>
							Male
						<%}
						else if("F".equals(policyBean1.getGender())){ %>
							Female
						<%}
						else if("A".equals(policyBean1.getGender())){ %>
							Both
						<%} %>
				</td>

				<td nowrap class='fields'>
						<%if("C".equals(policyBean1.getClinicNurs())){ %>
							<fmt:message key="Common.clinic.label" bundle="${common_labels}"/>
						<%}
						else if("N".equals(policyBean1.getClinicNurs())){ %>
							<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
						<%}
						else if("A".equals(policyBean1.getClinicNurs())){ %>
							<fmt:message key="Common.all.label" bundle="${common_labels}"/>
						<%} %>
					</select>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getClinicNursDesc())%>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getSpecDesc())%>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(criteriaMap.get(policyBean1.getType())) %>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getBillServDesc())%>			
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getPreApprAmtCapping()) %>
				</td>
				<td nowrap class='fields'>
						<% if(("G").equals(policyBean1.getAmtGrossNet())){ %>
							<fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/>
						<%} else if(("N").equals(policyBean1.getAmtGrossNet())){ %>
							<fmt:message key="eBL.Net.label" bundle="${bl_labels}"/>
						<%} %>						
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getPreApprQtyCapping()) %>
				</td>
				<%//Added V180725-Gayathri/MMS-DM-CRF-0126
				if("Y".equals(Site_PreappDur)){ %>
				<td class='fields' nowrap>
					<%=checkForNull(policyBean1.getPreApprDurCapping()) %>
				</td>
				<%} %>
				<!-- MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 STARTS   26-8-2020 -->
					<%if("Y".equals(SiteSpecGroupServiceInd)){ %>
				<td class='fields' nowrap>
					<%if("G".equals(policyBean1.getpreAppGroupRservice())){ 
					%>
					<fmt:message key="Common.Group.label" bundle="${common_labels}"/>
					<%} 
					else if("S".equals(policyBean1.getpreAppGroupRservice())){  
					%><fmt:message key="Common.service.label" bundle="${common_labels}"/>
					<%} %>		
				</td>				
				<%} %>
				<!-- MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 ENDS -->
				<td nowrap class='fields'>	
				<%if("Y".equals(policyBean1.getServLimit())){ 				
					out.print("Y");
				}
				else{
					out.print("N");
				} %>
				</td>
				<!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts -->
				<% if ("Y".equals(Site_preapp_across_enc)){%>
				<td nowrap class='fields'>	
				<%if("Y".equals(policyBean1.getPreacrossenc())){ out.print("Y"); } else{ out.print("N"); } %> </td><% } %>	
				<!-- Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts -->
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getStartDate())%>
				</td>
				<td nowrap class='fields'>
					<%=checkForNull(policyBean1.getEndDate())%>
				</td>
				<td nowrap class='fields'>
				<%if("Y".equals(policyBean1.getDelFlag())){ 
					out.print("Y");
				} else{ 
					out.print("&nbsp;");
				} %>
				</td>
			</tr>
			<%
			tableIndex++;
			} %>
      	</table>
      <input type='hidden' name='locale' id='locale' value='<%=locale %>'>
      	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
      	<input type='hidden' name='inclRowCount' id='inclRowCount' value='<%=tableIndex -1 %>'>
      	<input type='hidden' name='mode' id='mode' value='<%= mode%>'>
      	<input type='hidden' name='payerGroup' id='payerGroup' value='<%=payerGroup%>'>
      	<input type='hidden' name='payer' id='payer' value='<%=payer%>'>
      	<input type='hidden' name='policy' id='policy' value='<%=policy%>'>
		<input type='hidden' name='pageInfo' id='pageInfo' value='preApproval'>
		<input type='hidden' name='startDate' id='startDate' value='<%=startDate%>'>
      	<input type='hidden' name='endDate' id='endDate' value='<%=endDate%>'>
      	<input type='hidden' name='inclExclDesc' id='inclExclDesc' value='<%=inclExclDesc%>'>
      	<input type='hidden' name='inclExclCode' id='inclExclCode' value='<%=inclExclCode%>'>
		<input type='hidden' name='patientId' id='patientId' value='<%=patientId%>'>
		<input type='hidden' name='visitId' id='visitId' value='<%=visitId%>'>
		<input type='hidden' name='acctSeq' id='acctSeq' value='<%=acctSeq%>'>
		<input type='hidden' name='priority' id='priority' value='<%=priority%>'>
		<input type='hidden' name='episodeType' id='episodeType' value='<%=episodeType%>'>
		<input type='hidden' name='episodeId' id='episodeId' value='<%=episodeId%>'>
		<input type='hidden' name='queryString' id='queryString' value="<%=strQueryString%>">
		<input type='hidden' name='from' id='from' value="<%=from%>">
		<input type='hidden' name='to' id='to' value="<%=to%>">
		<input type='hidden' name='Site_PreappDur' id='Site_PreappDur' value='<%=Site_PreappDur%>'> <!-- Added V180725-Gayathri/MMS-DM-CRF-0126 -->
		<input type='hidden' name='Site_preapp_across_enc' id='Site_preapp_across_enc' value='<%=Site_preapp_across_enc%>'> <!-- Added V190326-Dhananjay/MMS-DM-CRF-0158 -->
     </form>
     <div name='tooltiplayer1' id='tooltiplayer1' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'></div>
</body>
</TBODY>	
	
	</div>
    <%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
    private String checkForStatus(String inputString) {
 		return (inputString == null) ? "I" : inputString;
 	}
     %>
	 <div class='COLUMNHEADER' name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:10%; visibility:hidden; background-color:blue;'>
	 	<table id='tooltiptable' cellpadding="0" cellspacing=0 border-collapse=collapse  style='position:absolute;' width='100%' height='100%' align='center'>
			<tr>
				<td width='100%' id='menu_table'></td>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>

