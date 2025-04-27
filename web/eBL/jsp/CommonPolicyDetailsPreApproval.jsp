<!DOCTYPE html>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="eBL.PolicyInsuranceMasterBean"%>
<%@page import="eBL.Common.BlRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
			
	String title = request.getParameter("title");
	String readonly = "";
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String inclExclDesc = "";
	String inclExclCode = "";
	LinkedHashMap<String,String> criteriaMap = new LinkedHashMap<String,String>();
%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=title %></title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/CommonPolicyAddTable.js"></script>
<script language="javascript" src="../../eBL/js/CommonPolicyDefinition.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

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
</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<%
String beanId = "PayerPolicyInsuranceMasterBean";
String beanName = "eBL.PolicyInsuranceMasterBean";
PolicyInsuranceMasterBean policyBean = null;
PolicyInsuranceMasterBean policyBeanMain = null;
String prevTab = "preApproval";
String mode = checkForNull(request.getParameter("mode"));
HashMap<String,List<PolicyInsuranceMasterBean>> policyMap = null;
HashMap<String,PolicyInsuranceMasterBean> masterMap = null;
List<PolicyInsuranceMasterBean> policyList = null; 
String checked = "";
String disabled = "";

String payerGroup = checkForNull(request.getParameter("payergroupCode"));
String payer = checkForNull(request.getParameter("payerCode"));
String policy = checkForNull(request.getParameter("policyCode"));
String startDate = checkForNull(request.getParameter("startDate"));
String endDate = checkForNull(request.getParameter("endDate"));
String policyNo = checkForNull(request.getParameter("policyNo"));
String patientId = checkForNull(request.getParameter("patientId"));
String visitId = checkForNull(request.getParameter("visitId"));
String acctSeq = checkForNull(request.getParameter("acctSeq"));
String priority = checkForNull(request.getParameter("priority"));
String episodeType = checkForNull(request.getParameter("episodeType"));
String episodeId = checkForNull(request.getParameter("episodeId"));
String policyEncounter = checkForNull(request.getParameter("policyEncounter"));
String priorityKey = checkForNull(request.getParameter("priorityKey"));
Connection con = null;
ResultSet rst = null;
PreparedStatement pstmt = null;
String sqlCoverage = "";
String partSql = "";
//Delete Definitions
/*PolicyInsuranceMasterBean deletedPolicyBean = null;
PolicyInsuranceMasterBean deletedPolicyBeanMain = null;
HashMap<String,List<PolicyInsuranceMasterBean>> deletedPolicyMap = null;
HashMap<String,PolicyInsuranceMasterBean> deletedMasterMap = null;
List<PolicyInsuranceMasterBean> deletedPolicyList = null; */
//Delete Definitions
try{
	con = ConnectionManager.getConnection(request);
	policyBeanMain = (PolicyInsuranceMasterBean) getBeanObject(beanId, beanName, request);
	masterMap = policyBeanMain.getMasterMap();
	if(!(masterMap == null || masterMap.isEmpty())){
		policyBean = masterMap.get(priorityKey);
	}
	else{
		policyBean = new PolicyInsuranceMasterBean();
	}

	if(policyBean == null){
		policyBean = new PolicyInsuranceMasterBean();
	}
	
	policyMap = policyBean.getPolicyMap();
	if(!(policyMap == null || policyMap.isEmpty())){
		policyList = policyMap.get(prevTab);
	}
	
	//Delete Definitions
	/*deletedPolicyBeanMain = (PolicyInsuranceMasterBean) getBeanObject("DeletedPayerPolicyBean", beanName, request);
	deletedMasterMap = deletedPolicyBeanMain.getMasterMap();
	if(!(deletedMasterMap == null || deletedMasterMap.isEmpty())){
		deletedPolicyBean = deletedMasterMap.get(priorityKey);
	}
	else{
		deletedPolicyBean = new PolicyInsuranceMasterBean();
	}

	if(deletedPolicyBean == null){
		deletedPolicyBean = new PolicyInsuranceMasterBean();
	}
	
	deletedPolicyMap = deletedPolicyBean.getPolicyMap();
	if(!(deletedPolicyMap == null || deletedPolicyMap.isEmpty())){
		deletedPolicyList = deletedPolicyMap.get(prevTab);
	}*/
	//Delete Definitions
	if ("modify".equals(mode) ) {
		HashMap<String,List<PolicyInsuranceMasterBean>> fmtDetailsMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
		PolicyInsuranceMasterBean fmtDtlsBean = null;
		if(policyList == null || policyList.isEmpty())
		{
			//Delete Definitions
			/*if(deletedPolicyList == null || deletedPolicyList.isEmpty()){*/
			//Delete Definitions
			/*if("policy".equals(policyEncounter)){
				sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_PREAPPROVAL_DTL");

				pstmt = con.prepareStatement(sqlCoverage);
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,locale);
				pstmt.setString(4,locale);
				pstmt.setString(5,facility_id);
				pstmt.setString(6,payerGroup);
				pstmt.setString(7,payer);
				pstmt.setString(8,policy);
				rst = pstmt.executeQuery();
				
			}
			else if("encounter".equals(policyEncounter)){
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
				
			}

			
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
					fmtDtlsBean.setServLimit(rst.getString("service_level_approval_yn"));
					fmtDtlsBean.setStartDate(rst.getString("effective_from"));
					fmtDtlsBean.setEndDate(rst.getString("effective_to"));
					fmtDtlsBean.setAmtGrossNet(rst.getString("preapproval_amt_gross_net"));
					fmtDtlsBean.setStatus("I");
					policyList.add(fmtDtlsBean);
					rsCnt++;					
				}
				if(rsCnt<1){
					policyMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
					PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
					titleBean.setStartDate(startDate);
					titleBean.setEndDate(endDate);
					policyList = new ArrayList<PolicyInsuranceMasterBean>();
					policyList.add(titleBean);
					policyMap.put(prevTab, policyList);
				}
			}
			else{
				policyMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
				PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
				titleBean.setStartDate(startDate);
				titleBean.setEndDate(endDate);
				policyList = new ArrayList<PolicyInsuranceMasterBean>();
				policyList.add(titleBean);
				policyMap.put(prevTab, policyList);
			}*/		
			
		/*}
			//Delete Definition
			else{
				policyList.add(new PolicyInsuranceMasterBean());
			}*/
			//Delete Definition
			
			PolicyInsuranceMasterBean covBean = new PolicyInsuranceMasterBean();
			covBean.setStartDate(startDate);
			covBean.setEndDate(endDate);
			policyList = new ArrayList<PolicyInsuranceMasterBean>();
			policyList.add(covBean);
		}

	}
	else{
		if(policyList == null || policyList.isEmpty()){
			PolicyInsuranceMasterBean covBean = new PolicyInsuranceMasterBean();
			covBean.setStartDate(startDate);
			covBean.setEndDate(endDate);
			policyList = new ArrayList<PolicyInsuranceMasterBean>();
			policyList.add(covBean);
		}
	}
	
	pstmt = null;
	rst = null;
	String inclExclSql  =  	BlRepository.getBlKeyValue("POLICY_DEF_INCL_EXCL_CRITERIA");
	pstmt = con.prepareStatement(inclExclSql);
	pstmt.setString(1,locale);
	rst = pstmt.executeQuery();
	inclExclDesc = "";
	inclExclCode = "";
	if(rst!=null){
		while(rst.next()){
			criteriaMap.put(rst.getString("code"),rst.getString("description"));
			inclExclDesc = inclExclDesc+":::"+rst.getString("description");
			inclExclCode = inclExclCode+":::"+rst.getString("code");
		}	
	}
	
	inclExclDesc = inclExclDesc.substring(3);
	inclExclCode = inclExclCode.substring(3);
}
catch(Exception e){
	System.err.println("Exception "+e);
}
finally{
	ConnectionManager.returnConnection(con);
	pstmt = null;
	rst = null;
}
%>
	<form  id="frmPolicyInclExclCoverage">	
      	<table width='220%' cellpadding='3' class='grid' border='1' cellspacing=0 align="center" id="PolicyPreApproval">  
      		<tr>
      			<td class='COLUMNHEADER'><fmt:message key="eBL.EpisodeEncounter.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER'><fmt:message key="eBL.HCMasterAgeGroup.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER'><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				
				<td class='COLUMNHEADER'><fmt:message key="eBL.ClinicNu.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER'><fmt:message key="eBL.ClinicNuDetails.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER'><fmt:message key="eBL.SpecDetails.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER'><fmt:message key="Common.type.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER'><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER'><fmt:message key="eBL.PreAppAmtCap.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER'><fmt:message key="eBL.PreAppQtyCap.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER'><fmt:message key="eBL.servicedtls.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER'><fmt:message key="eBL.EffFromDate.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER'><fmt:message key="eBL.EffToDate.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER'>Delete Record</td>
			 </tr>
			 <%
				int tableIndex = 1;
					for (PolicyInsuranceMasterBean policyBean1 : policyList) {
						if("I".equals(policyBean1.getStatus())){
							readonly = "";
							disabled = "";
						}
						else if("U".equals(policyBean1.getStatus())){
							readonly = "readonly";
							disabled = "disabled";
						}
			%>	
			 <tr>
			 	<td nowrap class='fields'>
					<select  id='episode_<%= tableIndex%>' name='episode_<%= tableIndex%>' <%=disabled %> onchange='changeEpsdEnc(<%= tableIndex%>);'>
						<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
						<%if("E".equals(policyBean1.getEpisodeEncounter())){ %>
							<option value='E' selected><fmt:message key="eBL.Episode.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='E'><fmt:message key="eBL.Episode.label" bundle="${bl_labels}"/></option>
						<%} %>
						
						<%if("N".equals(policyBean1.getEpisodeEncounter())){ %>
							<option value='N' selected><fmt:message key="eBL.Encounter.label" bundle="${bl_labels}"/></option>	
						<%}
						else{%>
							<option value='N'><fmt:message key="eBL.Encounter.label" bundle="${bl_labels}"/></option>	
						<%} %>	
						
						<%if("A".equals(policyBean1.getEpisodeEncounter())){ %>
							<option value='A' selected><fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/></option>	
						<%}
						else{%>
							<option value='A'><fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/></option>	
						<%} %>
					</select>
				</td>
				<td nowrap class='fields'>
					<select id='ptClass_<%= tableIndex%>' name='ptClass_<%= tableIndex%>' <%=disabled %>>
						<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
						<%if("OP".equals(policyBean1.getPatClass())){ %>
							<option value='OP' selected><fmt:message key="Common.OP.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='OP'><fmt:message key="Common.OP.label" bundle="${common_labels}"/></option>
						<%} %>
						
						<%if("IP".equals(policyBean1.getPatClass())){ %>
							<option value='IP' selected><fmt:message key="Common.IP.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='IP'><fmt:message key="Common.IP.label" bundle="${common_labels}"/></option>
						<%} %>

						<%if("DC".equals(policyBean1.getPatClass())){ %>
							<option value='DC' selected><fmt:message key="Common.DC.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='DC'><fmt:message key="Common.DC.label" bundle="${common_labels}"/></option>
						<%} %>
						
						<%if("XT".equals(policyBean1.getPatClass())){ %>
							<option value='XT' selected><fmt:message key="eBL.EX.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='XT'><fmt:message key="eBL.EX.label" bundle="${bl_labels}"/></option>
						<%} %>
						
						<%if("EM".equals(policyBean1.getPatClass())){ %>
							<option value='EM' selected><fmt:message key="eBL.EM.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='EM'><fmt:message key="eBL.EM.label" bundle="${bl_labels}"/></option>
						<%} %>
						
						<%if("**".equals(policyBean1.getPatClass())){ %>
							<option value='**' selected><fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/></option>
						<%}
						else{%>
							<option value='**'><fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/></option>
						<%} %>
					</select>
				</td>
				<td nowrap class='fields'>
					<input type='text' name='age_group_<%= tableIndex%>' id='age_group_<%= tableIndex%>' id='age_group_<%= tableIndex%>' length='15' <%=disabled %> value='<%=checkForNull(policyBean1.getAgeGroupDesc()) %>' onblur="if(this.value!=''){ callCommonValidation(5,this,hdn_age_group_<%= tableIndex%>);}">
					<input type='hidden' name='hdn_age_group_<%= tableIndex%>' id='hdn_age_group_<%= tableIndex%>' id='hdn_age_group_<%= tableIndex%>' value='<%=checkForNull(policyBean1.getAgeGroup()) %>' >
					&nbsp;<input type='button' id='age_but_<%= tableIndex%>' value='?' onclick='callCommonValidation(5,age_group_<%= tableIndex%>,hdn_age_group_<%= tableIndex%>)'>
				</td>
				<td nowrap class='fields'>
					<select id='gender_<%= tableIndex%>' name='gender_<%= tableIndex%>' <%=disabled %>>
						<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
						<%if("M".equals(policyBean1.getGender())){ %>
							<option value='M' selected>Male</option>
						<%}
						else{%>
							<option value='M'>Male</option>
						<%} %>
						
						<%if("F".equals(policyBean1.getGender())){ %>
							<option value='F' selected>Female</option>
						<%}
						else{%>
							<option value='F'>Female</option>
						<%} %>
						
						<%if("A".equals(policyBean1.getGender())){ %>
							<option value='A' selected>Both</option>
						<%}
						else{%>
							<option value='A'>Both</option>
						<%} %>
					</select>
				</td>

				<td nowrap class='fields'>
					<select  id='clinic_<%= tableIndex%>' name='clinic_<%= tableIndex%>' <%=disabled %> onchange="clearClinic(<%= tableIndex%>);">
						<%if("C".equals(policyBean1.getClinicNurs())){ %>
							<option value='C' selected><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
						<%} %>
						
						<%if("N".equals(policyBean1.getClinicNurs())){ %>
							<option value='N' selected><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
						<%} %>
						
						<%if("A".equals(policyBean1.getClinicNurs())){ %>
							<option value='A' selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<%} %>
					</select>
				</td>
					<td nowrap class='fields'>
					<input type='text' readonly id='clinic_code_<%= tableIndex%>' name='clinic_code_<%= tableIndex%>' <%=readonly %> size='4' value='<%=checkForNull(policyBean1.getClinicNursCode())%>'>
					<input type='text' id='clinic_desc_<%= tableIndex%>' name='clinic_desc_<%= tableIndex%>' size='20' <%=disabled %> value='<%=checkForNull(policyBean1.getClinicNursDesc())%>' onblur="if(this.value!=''){ callBGDesc(1,clinic_<%= tableIndex%>,this,clinic_code_<%= tableIndex%>);}">
					&nbsp;<input type='button' id='clinic_but_<%= tableIndex%>' value='?' <%=disabled %> onclick='callBGDesc(1,clinic_<%= tableIndex%>,clinic_desc_<%= tableIndex%>,clinic_code_<%= tableIndex%>)'>
				</td>
				<td nowrap class='fields'>
					<input type='text' readonly id='spec_code_<%= tableIndex%>' name='spec_code_<%= tableIndex%>' <%=readonly %> size='5' value='<%=checkForNull(policyBean1.getSpecCode())%>'>
					<input type='text' id='spec_desc_<%= tableIndex%>' name='spec_desc_<%= tableIndex%>' size='20' <%=disabled %> value='<%=checkForNull(policyBean1.getSpecDesc())%>' onblur="if(this.value!=''){ callCommonValidationSpec(spec_desc_<%= tableIndex%>,spec_code_<%= tableIndex%>,clinic_<%= tableIndex%>,clinic_code_<%= tableIndex%>);}">
					&nbsp;<input type='button' id='spec_but_<%= tableIndex%>' value='?' <%=disabled %> onclick='callCommonValidationSpec(spec_desc_<%= tableIndex%>,spec_code_<%= tableIndex%>,clinic_<%= tableIndex%>,clinic_code_<%= tableIndex%>)'>
				</td>
				<td nowrap class='fields'>
					<Select id='type_<%= tableIndex%>' name='type_<%= tableIndex%>' <%=disabled %> onchange="clearBill(<%= tableIndex%>);">
					<%
						for (Iterator iterator = criteriaMap.keySet().iterator(); iterator.hasNext();) {
							String type = (String) iterator.next();
							if(type.equals(policyBean1.getType())){ %>
								<option value='<%=type %>' selected><%=criteriaMap.get(type) %></option>	
							<%}
							else{%>
								<option value='<%=type %>'><%=criteriaMap.get(type) %></option>	
							<%} 
							
						}
						
					%>		
					</Select>
				</td>
				<td nowrap class='fields'>
					<input type='text' readonly id='bg_code_<%= tableIndex%>' name='bg_code_<%= tableIndex%>' size='12' value='<%=checkForNull(policyBean1.getBillServCode())%>'>
					<input type='text' id='bg_desc_<%= tableIndex%>' name='bg_desc_<%= tableIndex%>' size='20' <%=disabled %> value='<%=checkForNull(policyBean1.getBillServDesc())%>' onblur="if(this.value!=''){ callBGDesc(2,type_<%= tableIndex%>,bg_desc_<%= tableIndex%>,bg_code_<%= tableIndex%>);}">
					&nbsp;<input type='button' id='bg_but_<%= tableIndex%>' value='?' <%=disabled %> onclick='callBGDesc(2,type_<%= tableIndex%>,bg_desc_<%= tableIndex%>,bg_code_<%= tableIndex%>)'>
				</td>
				
				<td nowrap class='fields'>
					<input type='text' id='preAppAmt_<%= tableIndex%>' name='preAppAmt_<%= tableIndex%>' onkeypress="return checkForSpecChars(event)" size='10' maxlength='10' onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean1.getPreApprAmtCapping()) %>'>&nbsp;&nbsp;
					&nbsp;<select name='AmtMode_<%= tableIndex%>' id='AmtMode_<%= tableIndex%>'>
						<% if(("G").equals(policyBean1.getAmtGrossNet())){ %>
							<option value='G' selected><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
						<%} else{ %>
							<option value='G'><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
						<%} %>
						
						<% if(("N").equals(policyBean1.getAmtGrossNet())){ %>
							<option value='N' selected><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
						<%} else{ %>
							<option value='N'><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
						<%} %>						
					</select>
				</td>
				<td nowrap class='fields'>
					<input type='text' id='preAppQty_<%= tableIndex%>' name='preAppQty_<%= tableIndex%>' size='10' maxlength='10' onblur="checkForNumber(this)" onkeypress="return checkAlpha(event)" value='<%=checkForNull(policyBean1.getPreApprQtyCapping()) %>'>
				</td>
				<td nowrap class='fields'>	
				<%if("Y".equals(policyBean1.getServLimit())){ %>					
					<input type="checkbox" id='serviceLmt_<%= tableIndex%>' checked name='serviceLmt_<%= tableIndex%>' >
				<%}
				else{%>
					<input type="checkbox" id='serviceLmt_<%= tableIndex%>'  name='serviceLmt_<%= tableIndex%>' >
				<%} %>
				</td>
				<td nowrap class='fields'>
					<input type='text' id='effFrom_<%= tableIndex%>' name='effFrom_<%= tableIndex%>' size='10' <%=readonly %> value='<%=checkForNull(policyBean1.getStartDate())%>' onblur='isValidDate(this);checkDateFrom(effFrom_<%= tableIndex%>);compareDates(effFrom_<%= tableIndex%>,effTo_<%= tableIndex%>);'>
					&nbsp;<img src='../../eCommon/images/CommonCalendar.gif' id='effFrom_ctrl_<%= tableIndex%>' <%=disabled %> onClick="return showCalendar('effFrom_<%= tableIndex%>');" />
				</td>
				<td nowrap class='fields'>
					<input type='text' id='effTo_<%= tableIndex%>' name='effTo_<%= tableIndex%>' size='10' value='<%=checkForNull(policyBean1.getEndDate())%>' onblur='isValidDate(this);checkDateFrom(effTo_<%= tableIndex%>);compareDates(effFrom_<%= tableIndex%>,effTo_<%= tableIndex%>);'>
					&nbsp;<img src='../../eCommon/images/CommonCalendar.gif' id='effTo_ctrl_<%= tableIndex%>' onClick="return showCalendar('effTo_<%= tableIndex%>');" />
					<input type='hidden' name='rowStatus<%= tableIndex%>' id='rowStatus<%= tableIndex%>' value='<%= checkForStatus(policyBean1.getStatus())%>'>
				</td>
				<td nowrap class='fields'>
				<%if("Y".equals(policyBean1.getDelFlag())){ %>
					<input type='checkbox' id='delFlag<%= tableIndex%>' checked name='delFlag<%= tableIndex%>'>
				<%} else{ %>
					<input type='checkbox' id='delFlag<%= tableIndex%>' name='delFlag<%= tableIndex%>'>
				<%} %>
				</td>
			</tr>
			<%
			tableIndex++;
			} %>
      	</table>
      	<br/>
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
      	<input type='hidden' name='priorityKey' id='priorityKey' value='<%=priorityKey%>'>
		<input type='hidden' name='patientId' id='patientId' value='<%=patientId%>'>
		<input type='hidden' name='visitId' id='visitId' value='<%=visitId%>'>
		<input type='hidden' name='acctSeq' id='acctSeq' value='<%=acctSeq%>'>
		<input type='hidden' name='priority' id='priority' value='<%=priority%>'>
		<input type='hidden' name='episodeType' id='episodeType' value='<%=episodeType%>'>
		<input type='hidden' name='episodeId' id='episodeId' value='<%=episodeId%>'>
		<input type='hidden' name='policyNo' id='policyNo' value='<%=policyNo%>'>
		<input type='hidden' name='policyEncounter' id='policyEncounter' value='<%=policyEncounter%>'>
     </form>
     <%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
     private String checkForStatus(String inputString) {
  		return (inputString == null) ? "I" : inputString;
  	}
     %>
</body>
</html>

