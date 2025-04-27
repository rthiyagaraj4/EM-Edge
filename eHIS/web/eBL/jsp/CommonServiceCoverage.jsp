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
<%!
     private String checkForNull(String inputString) {
	 if(inputString==null || inputString.equals("null"))
		  return "";    	 
		return  inputString;
 	}
%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/CommonPolicyDefinition.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<%
String beanId = "PayerPolicyInsuranceMasterBean";
String beanName = "eBL.PolicyInsuranceMasterBean";
PolicyInsuranceMasterBean policyBean = null;
PolicyInsuranceMasterBean policyBeanMain = null;
String prevTab = request.getParameter("prevTab");
String mode = checkForNull(request.getParameter("mode"));
HashMap<String,List<PolicyInsuranceMasterBean>> policyMap = null;
HashMap<String,PolicyInsuranceMasterBean> masterMap = null;
List<PolicyInsuranceMasterBean> policyList = null; 
String checked = "";
String disabled = "";
String facility_id = (String)session.getAttribute("facility_id");
String payerGroup = checkForNull(request.getParameter("payergroupCode"));
String payer = checkForNull(request.getParameter("payerCode"));
String policy = checkForNull(request.getParameter("policyCode"));

String patientId = checkForNull(request.getParameter("patientId"));
String visitId = checkForNull(request.getParameter("visitId"));
String acctSeq = checkForNull(request.getParameter("acctSeq"));
String priority = checkForNull(request.getParameter("priority"));
String episodeType = checkForNull(request.getParameter("episodeType"));
String episodeId = checkForNull(request.getParameter("episodeId"));
String policyNo = checkForNull(request.getParameter("policyNo"));
String policyEncounter = checkForNull(request.getParameter("policyEncounter"));
String priorityKey = checkForNull(request.getParameter("priorityKey"));

String startDate = checkForNull(request.getParameter("startDate"));
String endDate = checkForNull(request.getParameter("endDate"));
String locale = (String)session.getAttribute("LOCALE");
String prevEncValues = "";

if("encounter".equals(policyEncounter)){
	prevEncValues = facility_id+":::"+patientId+":::"+episodeType+"::: "+episodeId+"::: "+visitId+":::"+locale+":::"+"";
}

Connection con = null;
ResultSet rst = null;
PreparedStatement pstmt = null;
String sqlCoverage = "";
String partSql = "";
Boolean siteSpecRefPrice = false;//Added V181012-Aravindh/AAKH-CRF-0107
try{
	con = ConnectionManager.getConnection(request);
	siteSpecRefPrice = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_HAAD_REFERENCE_ITEM_CHARGES");//Added V181012-Aravindh/AAKH-CRF-0107
	policyBeanMain = (PolicyInsuranceMasterBean) getBeanObject(beanId, beanName, request);
	masterMap = policyBeanMain.getMasterMap();
	if(!(masterMap == null || masterMap.isEmpty())){
		policyBean = masterMap.get(priorityKey);
	}
	
	
	if ("modify".equals(mode) ) {
		HashMap<String,List<PolicyInsuranceMasterBean>> fmtDetailsMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
		PolicyInsuranceMasterBean fmtDtlsBean = null;
		if(policyBean == null)
		{
			if("policy".equals(policyEncounter)){
				sqlCoverage = BlRepository.getBlKeyValue("COMMON_POLICY_SERVICE_COVERAGE");
				pstmt = con.prepareStatement(sqlCoverage);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,payerGroup);
				pstmt.setString(3,payer);
				pstmt.setString(4,policy);
				rst = pstmt.executeQuery();

			}
			else if("encounter".equals(policyEncounter)){
				if(("I".equals(episodeType)) || ("D".equals(episodeType))){
					partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_ID");
				}
				else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
					partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_OE");
				}
				else if("R".equals(episodeType)){
					partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_R");
				}
				sqlCoverage = BlRepository.getBlKeyValue("COMMON_ENCOUNTER_SERVICE_COVERAGE")+
										partSql;
								
				pstmt = con.prepareStatement(sqlCoverage);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,payerGroup);
				pstmt.setString(3,payer);
				pstmt.setString(4,policy);
				pstmt.setString(5,patientId);
				if(("I".equals(episodeType)) || ("D".equals(episodeType))){
					pstmt.setString(6,episodeType);
					pstmt.setString(7,episodeId);
					//pstmt.setString(8,acctSeq);
					if(acctSeq.length()==0) pstmt.setString(8,null);
					else	
					pstmt.setString(8,acctSeq);
					pstmt.setString(9,priority);
					pstmt.setString(10,policyNo);
				}
				else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
					pstmt.setString(6,episodeType);
					pstmt.setString(7,episodeId);
					pstmt.setString(8,visitId);
					if(acctSeq.length()==0) pstmt.setString(9,null);
					else	pstmt.setString(9,acctSeq);
					pstmt.setString(10,priority);
					pstmt.setString(11,policyNo);
				}
				else if("R".equals(episodeType)){
					pstmt.setString(6,episodeType);
					if(acctSeq.length()==0) pstmt.setString(7,null);
					else	
					pstmt.setString(7,acctSeq);
					
					pstmt.setString(8,priority);
					pstmt.setString(9,policyNo);
				}

				rst = pstmt.executeQuery();
			}
			
			
			if(rst!=null){
				policyList = new ArrayList<PolicyInsuranceMasterBean>();
				int rsCnt = 0;
				while (rst.next()) {
					fmtDtlsBean = new PolicyInsuranceMasterBean();
					fmtDtlsBean.setDefInclExclCriteria(rst.getString("excl_incl_ind"));
					fmtDtlsBean.setOverRideInclExcl(rst.getString("ovride_incl_excl_unsp_serv_yn"));
					fmtDtlsBean.setCovInclOthPayers(rst.getString("cumm_cvrg_with_oth_payers_yn"));
					fmtDtlsBean.setLastPayer(rst.getString("last_payer_coverage_yn"));
					//startDate = checkForNull(rst.getString("POLICY_EFF_FROM"));
					//endDate = checkForNull(rst.getString("POLICY_EFF_TO"));
					fmtDtlsBean.setCoveragePer(rst.getString("COPAY_PERC"));
					fmtDtlsBean.setCoverageBasis(rst.getString("POLICY_COVERAGE_BASIS"));
					fmtDtlsBean.setCoverageRules(rst.getString("PAYER_COV_RULE"));
					fmtDtlsBean.setCoverRefPrice(rst.getString("cover_ref_price"));//Added V181012-Aravindh/AAKH-CRF-0107

					policyList.add(fmtDtlsBean);
					rsCnt++;
				}

				if(rsCnt<1){
					policyMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
					PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
					policyList = new ArrayList<PolicyInsuranceMasterBean>();
					policyList.add(titleBean);
					policyMap.put(prevTab, policyList);	
				}
			}
			else{
				policyMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
				PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
				policyList = new ArrayList<PolicyInsuranceMasterBean>();
				policyList.add(titleBean);
				policyMap.put(prevTab, policyList);
			}		
			
		}
		else{
			policyList = new ArrayList<PolicyInsuranceMasterBean>();
			policyList.add(policyBean);
		}

		
	}
	else{
		if(policyList == null || policyList.isEmpty()){
			PolicyInsuranceMasterBean covBean = new PolicyInsuranceMasterBean();
			policyList = new ArrayList<PolicyInsuranceMasterBean>();
			policyList.add(covBean);
		}
	}
}
catch(Exception e){
	System.err.println("Exception "+e);
}
finally{
	ConnectionManager.returnConnection(con);
}
%>
<% //policyList = policyMap.get(prevTab);
policyBean = policyList.get(0);
%>
	<form  id="frmPolicyInfo">	
      	      	<table width='100%' cellpadding='3'  cellspacing=0 align="center">  
	
      		<tr >
				<td align="left" class="COLUMNHEADER" colspan='3'>
					<fmt:message key="eBL.ServicePolicyCoverage.label" bundle="${bl_labels}"/>
				</td>
			</tr>
			<tr>
			</tr>
			<tr>
			</tr>
		</table>
		<table width='100%' cellpadding='3'  cellspacing=0 align="center">
      		<tr>
				<td class='label' width='30%'><fmt:message key="eBL.DefaultInclExclCriteria.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<Select name='defaultCriteria' id='defaultCriteria'>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<%if("I".equals(policyBean.getDefInclExclCriteria())){ %>
							<option value='I' selected><fmt:message key="eBL.AllIncluded.label" bundle="${bl_labels}"/></option>
						<%} else{ %>
							<option value='I'><fmt:message key="eBL.AllIncluded.label" bundle="${bl_labels}"/></option>
						<%} %>
						
						<%if("E".equals(policyBean.getDefInclExclCriteria())){ %>
							<option value='E' selected><fmt:message key="eBL.AllExcluded.label" bundle="${bl_labels}"/></option>
						<%} else{ %>
							<option value='E'><fmt:message key="eBL.AllExcluded.label" bundle="${bl_labels}"/></option>
						<%} %>
						
					</Select>
				</td>
				
				<td  class='label' width='25%'><fmt:message key="eBL.PolicycoverageBasis.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<Select name='coverageBasis' id='coverageBasis'>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<%if("I".equals(policyBean.getCoverageBasis())){ %>
							<option value='I' selected><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></option>
						<%} else{%>
							<option value='I'><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></option>
						<%} %>
						
						<%if("P".equals(policyBean.getCoverageBasis())){ %>
							<option value='P' selected><fmt:message key="Common.patient.label" bundle="${common_labels}"/></option>
						<%} else{%>
							<option value='P'><fmt:message key="Common.patient.label" bundle="${common_labels}"/></option>
						<%} %>
						
						
					</Select>
				</td>      
				                            
				<td  class='label' width='30%'><fmt:message key="eBL.PolicycoverageRules.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<Select name='coverageRules' id='coverageRules'>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<%if("S".equals(policyBean.getCoverageRules())){ %>
							<option value='S' selected><fmt:message key="eBL.SoleCoverage.label" bundle="${bl_labels}"/></option>
						<%} else{%>
							<option value='S'><fmt:message key="eBL.SoleCoverage.label" bundle="${bl_labels}"/></option>
						<%} %>
						
						<%if("O".equals(policyBean.getCoverageRules())){ %>
							<option value='O' selected><fmt:message key="eBL.SharedCoverage.label" bundle="${bl_labels}"/></option>
						<%} else{%>
							<option value='O'><fmt:message key="eBL.SharedCoverage.label" bundle="${bl_labels}"/></option>
						<%} %>
						
					</Select>
				</td>
				
				<td class='label' width='15%'><fmt:message key="eBL.CoveragePercent.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type='text' name='percent' id='percent' size='5' maxlength='3' onblur="checkForPer(this)" onkeypress="return checkAlpha(event)" value='<%=checkForNull(policyBean.getCoveragePer())%>'/>
				</td>
			</tr>
		</table>
		<table width='100%' cellpadding='3'  cellspacing=0 align="center">
			<tr>
   
				<td width='30%' class='label' align="right">
				<%if("Y".equals(policyBean.getOverRideInclExcl())){ %>
					<input type="checkbox" name='overrideInclExcl' id='overrideInclExcl' checked align="right" />&nbsp;&nbsp;&nbsp;<fmt:message key="eBL.OverrideInclExcl.label" bundle="${bl_labels}"/>
				<%} else{ %>
					<input type="checkbox" name='overrideInclExcl' id='overrideInclExcl' align="right" />&nbsp;&nbsp;&nbsp;<fmt:message key="eBL.OverrideInclExcl.label" bundle="${bl_labels}"/>
				<%} %>
					
				</td>                              
				
				<td width='25%' class='label' align="right">
				<%if("Y".equals(policyBean.getCovInclOthPayers())){ %>
					<input type="checkbox" name='coverageIclu' id='coverageIclu' checked />&nbsp;&nbsp;&nbsp;<fmt:message key="eBL.CoverageOtherPayer.label" bundle="${bl_labels}"/>
				<%} else{ %>
					<input type="checkbox" name='coverageIclu' id='coverageIclu'  />&nbsp;&nbsp;&nbsp;<fmt:message key="eBL.CoverageOtherPayer.label" bundle="${bl_labels}"/>
				<%} %>
				</td>	
				
				                               
				<td width='30%' class='label' align="right">
				<%if("Y".equals(policyBean.getLastPayer())){ %>
					<input type="checkbox" name='lastPayer' id='lastPayer' checked />&nbsp;&nbsp;&nbsp;<fmt:message key="eBL.LastPayer.label" bundle="${bl_labels}"/>
				<%} else{ %>
					<input type="checkbox" name='lastPayer' id='lastPayer'  />&nbsp;&nbsp;&nbsp;<fmt:message key="eBL.LastPayer.label" bundle="${bl_labels}"/>
				<%} %>
				</td>                              
				<td width='15%' class='label' nowrap>
				<!-- Added V181003-Aravindh/AAKH-CRF-0107/Starts -->
				<%if(siteSpecRefPrice) { %>
					<% if("Y".equals(policyBean.getCoverRefPrice())) { %>
						<input type="checkbox" name='coverRefPriceHdr' id='coverRefPriceHdr' id='coverRefPriceHdr' onclick='unCheckAllLineLvlRefChkBox("hdr")' checked />
					<% }
					else { %>
						<input type="checkbox" name='coverRefPriceHdr' id='coverRefPriceHdr' id='coverRefPriceHdr' onclick='unCheckAllLineLvlRefChkBox("hdr")' />
					<% } %>
					<fmt:message key="eBL.CoverReferencePrice.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;
				<% } %>
				<!-- Added V181003-Aravindh/AAKH-CRF-0107/Ends -->
				</td>		
			</tr>

      	</table>
      	<input type='hidden' name='startDate' id='startDate' value='<%=startDate%>'>
      	<input type='hidden' name='endDate' id='endDate' value='<%=endDate%>'>
      	<input type='hidden' name='priorityKey' id='priorityKey' value='<%=priorityKey%>'>
      	
      	<input type='hidden' name='payerGroup' id='payerGroup' value='<%=payerGroup%>'>
      	<input type='hidden' name='payer' id='payer' value='<%=payer%>'>
      	<input type='hidden' name='policy' id='policy' value='<%=policy%>'>
		<input type='hidden' name='servFacilityId' id='servFacilityId' value='<%=facility_id%>'>
		<input type='hidden' name='prevEncValues' id='prevEncValues' value='<%=prevEncValues%>'>
		
		<input type='hidden' name='hdnpatientId' id='hdnpatientId' value='<%=patientId%>'>
		<input type='hidden' name='hdnvisitId' id='hdnvisitId' value='<%=visitId%>'>
		<input type='hidden' name='hdnacctSeq' id='hdnacctSeq' value='<%=acctSeq%>'>
		<input type='hidden' name='hdnpriority' id='hdnpriority' value='<%=priority%>'>
		<input type='hidden' name='hdnepisodeType' id='hdnepisodeType' value='<%=episodeType%>'>
		<input type='hidden' name='hdnepisodeId' id='hdnepisodeId' value='<%=episodeId%>'>
		<input type='hidden' name='hdnpolicyNo' id='hdnpolicyNo' value='<%=policyNo%>'>
		
      	
     </form>
</body>
</html>

