<!DOCTYPE html>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="blPolicy.EncounterSpecificDefinitionBean"%>
<%@page import="eBL.Common.BlRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
%>
<%
/*
Sr No        Version           TFS/Incident        SCF/CRF            		 			  Developer Name
--------------------------------------------------------------------------------------------------------
1		    V211026	    		25297		PMG2021-MMS-CRF-0004-TF-US001/01-Hyper link   Mohana Priya K
--------------------------------------------------------------------------------------------------------
*/
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String mode = checkForNull(request.getParameter("mode"));
	String facility_id = (String)session.getAttribute("facility_id");
	String payerGroup = checkForNull(request.getParameter("payergroupCode"));
	String payer = checkForNull(request.getParameter("payerCode"));
	String policy = checkForNull(request.getParameter("policyCode"));
	String patientId = checkForNull(request.getParameter("patinetId"));
	
	String visitId = checkForNull(request.getParameter("visitId"));
	String acctSeq = checkForNull(request.getParameter("acctSeq"));
	String priority = checkForNull(request.getParameter("priority"));
	String policyNo = checkForNull(request.getParameter("policyNo"));
	String episodeType = checkForNull(request.getParameter("episodeType"));
	String episodeId = checkForNull(request.getParameter("episodeId"));
	String auth = checkForNull(request.getParameter("auth"));
	String totalDisabled = "";	

	if("N".equals(auth)){
		totalDisabled = "disabled";
	}
	else if("Y".equals(auth)){
		totalDisabled = "";
	}
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	int acrossEncCount = 0;
	String encGrpId = "";
	Boolean siteSpecRefPrice = false;//Added V181008-Aravindh/AAKH-CRF-0107
	Boolean siteSpecPolApprv = false; //Added V190517-Aravindh/NMC-JD-CRF-0010
	Boolean siteSpecPolDefRemarks=false; // Added V200517-palani/NMC-JD-CRF-0010.1
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/EncounterSpecPolicyDefnSrch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<%
	EncounterSpecificDefinitionBean policyBean = new EncounterSpecificDefinitionBean();
	try{
	if ("modify".equals(mode) ) {
		con = ConnectionManager.getConnection(request);
		siteSpecRefPrice = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_HAAD_REFERENCE_ITEM_CHARGES");//Added V181003-Aravindh/AAKH-CRF-0107
		siteSpecPolDefRemarks = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_POLICY_DEF_REMARKS_ALLOWED");//Added V200517-PalaniNarayanan/NMC-JD-CRF-0010.1
		
		//Added V190517-Aravindh/NMC-JD-CRF-0010/Starts
		String polApprvSql = "select NVL(enable_policy_approval_yn,'N') enable_policy_approval_yn from bl_parameters where operating_facility_id = '"+facility_id+"'";
		pstmt = con.prepareStatement(polApprvSql);
		rst = pstmt.executeQuery();
		while(rst.next()) {
			String enablePolicyApprvl = rst.getString("enable_policy_approval_yn");
			if("Y".equals(enablePolicyApprvl)) {
				siteSpecPolApprv = true;
			}
		}
		rst.close();
		pstmt.close();
		//Added V190517-Aravindh/NMC-JD-CRF-0010/Ends
	try{
		//String sqlInfoPage = BlRepository.getBlKeyValue("POLICY_DEF_SERVICE_INFO");
		//Newly Added for Policy Or Encounter report
		if(patientId == null || "".equals(patientId)){
			//String sqlInfoPage = BlRepository.getBlKeyValue("COMMON_POLICY_SERVICE_COVERAGE"); 
			String sqlInfoPage = BlRepository.getBlKeyValue("COMMON_POLICY_SERVICE_COVERAGE_DTLS"); //V211026
			pstmt = con.prepareStatement(sqlInfoPage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			rst = pstmt.executeQuery();
				
			if(rst != null){
				while(rst.next()){
					policyBean.setDefInclExclCriteria(rst.getString("excl_incl_ind"));
					policyBean.setOverRideInclExcl(rst.getString("ovride_incl_excl_unsp_serv_yn"));
					policyBean.setCovInclOthPayers(rst.getString("cumm_cvrg_with_oth_payers_yn"));
					policyBean.setLastPayer(rst.getString("last_payer_coverage_yn"));
					policyBean.setCoveragePer(rst.getString("COPAY_PERC"));
					policyBean.setCoverageBasis(rst.getString("POLICY_COVERAGE_BASIS"));
					policyBean.setCoverageRules(rst.getString("PAYER_COV_RULE"));
					policyBean.setCoverRefPrice(rst.getString("cover_ref_price"));//Added V181008-Aravindh/AAKH-CRF-0107
					policyBean.setPolicyApproved(rst.getString("policy_approved_yn"));//Added V190517-Aravindh/NMC-JD-CRF-0010
				}
				rst.close();
			}
			pstmt.close();
		}
		else{
			String partSql = "";
			String acrossEncounter = "";
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_ID");
				acrossEncounter = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_ACROSS_ENCOUNTER_ID");
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_OE");
				acrossEncounter = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_ACROSS_ENCOUNTER_OE");
			}
			else if("R".equals(episodeType)){
				partSql = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE_PART_R");
				acrossEncounter = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_ACROSS_ENCOUNTER_R");
			}
			String sqlInfoPage = BlRepository.getBlKeyValue("ENCOUNTER_SPECIFIC_SERVICE_COVERAGE")+
									partSql;
								
			pstmt = con.prepareStatement(sqlInfoPage);

			System.err.println("##########  EncounterServiceCoverage jsp "+ facility_id+"  "+payerGroup+"  "+payer+"  "+policy+" "+patientId+"  "+episodeType+"  "+episodeId+"  "+acctSeq+"  "+priority+"  "+policyNo);

			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			pstmt.setString(5,patientId);
			if(("I".equals(episodeType)) || ("D".equals(episodeType))){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,episodeId);
				pstmt.setString(8,acctSeq);
				pstmt.setString(9,priority);
				pstmt.setString(10,policyNo);
			}
			else if(("O".equals(episodeType)) || ("E".equals(episodeType))){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,episodeId);
				pstmt.setString(8,visitId);
				pstmt.setString(9,acctSeq);
				pstmt.setString(10,priority);
				pstmt.setString(11,policyNo);
			}
			else if("R".equals(episodeType)){
				pstmt.setString(6,episodeType);
				pstmt.setString(7,acctSeq);
				pstmt.setString(8,priority);
				pstmt.setString(9,policyNo);
			}

			rst = pstmt.executeQuery();
				
			if(rst != null){
				while(rst.next()){
					policyBean.setDefInclExclCriteria(rst.getString("excl_incl_ind"));
					policyBean.setOverRideInclExcl(rst.getString("ovride_incl_excl_unsp_serv_yn"));
					policyBean.setCovInclOthPayers(rst.getString("cumm_cvrg_with_oth_payers_yn"));
					policyBean.setLastPayer(rst.getString("last_payer_coverage_yn"));
					policyBean.setCoveragePer(rst.getString("COPAY_PERC"));
					policyBean.setCoverageBasis(rst.getString("POLICY_COVERAGE_BASIS"));
					policyBean.setCoverageRules(rst.getString("PAYER_COV_RULE"));
					encGrpId = rst.getString("ACROSS_ENC_GROUP_ID");
				}
				rst.close();
			}
			pstmt.close();
				
			//Across Encounter
			pstmt = con.prepareStatement(acrossEncounter);			
			pstmt.setString(1,payerGroup);
			pstmt.setString(2,payer);
			pstmt.setString(3,policy);
			pstmt.setString(4,facility_id);
			pstmt.setString(5,patientId);
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					acrossEncCount = rst.getInt("enc_count");					
				}
				rst.close();
			}
			pstmt.close();
			//Across Encounter
		}			
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in Service Coverage Load - "+e);
		}
		finally{
			ConnectionManager.returnConnection(con);
		}
	}
	}
	catch(Exception e){
		e.printStackTrace();	
	}
	finally{
		
	}
%>
	<form  id="frmPolicyInfo">	
      	<table width='100%' cellpadding='3'  cellspacing=0 align="center">	
      		<tr>
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
					<Select name='defaultCriteria' id='defaultCriteria' <%=totalDisabled %>>
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
					<Select name='coverageBasis' id='coverageBasis' <%=totalDisabled %>>
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
					<Select name='coverageRules' id='coverageRules' <%=totalDisabled %>>
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
					<input type='text' <%=totalDisabled %> name='percent' size='5' maxlength='3' onkeypress="return checkAlpha(event)" onblur="checkForPer(this)" value='<%=checkForNull(policyBean.getCoveragePer())%>'/>
				</td>
				<!-- <td class='label' >
				</td>                                  
				<td class='label' ><fmt:message key="eBL.ServiceInclExclCriteria.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<Select name='serviceCriteria' id='serviceCriteria'>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value=''><fmt:message key="eBL.ServGrpClass.label" bundle="${bl_labels}"/></option>
						<option value=''><fmt:message key="eBL.EntGrpLine.label" bundle="${bl_labels}"/></option>
						<option value=''><fmt:message key="eBL.PayerServiceGrp.label" bundle="${bl_labels}"/></option>
					</Select></td>
				<td class='fields' >
					
				</td> 
				<td class='label' ><fmt:message key="eBL.ServiceCoverageLimit.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<Select name='defaultCriteria' id='defaultCriteria'>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value=''><fmt:message key="eBL.ByPayerServiceGrp.label" bundle="${bl_labels}"/></option>
						<option value=''><fmt:message key="eBL.ByEntGrpLine.label" bundle="${bl_labels}"/></option>
					</Select></td>
				<td class='fields' >
					
				</td> 
				 -->
			</tr>
		</table>
		<table width='100%' cellpadding='3'  cellspacing=0 align="center">
			<tr>   
				<td width='30%' class='label' align="left">
				<%if("Y".equals(policyBean.getOverRideInclExcl())){ %>
					<input type="checkbox" name='overrideInclExcl' id='overrideInclExcl' <%=totalDisabled %> checked align="right" />&nbsp;&nbsp;&nbsp;<fmt:message key="eBL.OverrideInclExcl.label" bundle="${bl_labels}"/>
				<%} else{ %>
					<input type="checkbox" name='overrideInclExcl' id='overrideInclExcl' <%=totalDisabled %> align="right" />&nbsp;&nbsp;&nbsp;<fmt:message key="eBL.OverrideInclExcl.label" bundle="${bl_labels}"/>
				<%} %>					
				</td>                              
				
				<td width='25%' class='label' align="left">
				<%if("Y".equals(policyBean.getCovInclOthPayers())){ %>
					<input type="checkbox" name='coverageIclu' id='coverageIclu' <%=totalDisabled %> checked />&nbsp;&nbsp;&nbsp;<fmt:message key="eBL.CoverageOtherPayer.label" bundle="${bl_labels}"/>
				<%} else{ %>
					<input type="checkbox" <%=totalDisabled %> name='coverageIclu'  />&nbsp;&nbsp;&nbsp;<fmt:message key="eBL.CoverageOtherPayer.label" bundle="${bl_labels}"/>
				<%} %>
				</td>				
				                               
				<td width='12%' class='label' align="left">
				<%if("Y".equals(policyBean.getLastPayer())){ %>
					<input type="checkbox" <%=totalDisabled %> name='lastPayer' checked />&nbsp;&nbsp;&nbsp;<fmt:message key="eBL.LastPayer.label" bundle="${bl_labels}"/>
				<%} else{ %>
					<input type="checkbox" <%=totalDisabled %> name='lastPayer'  />&nbsp;&nbsp;&nbsp;<fmt:message key="eBL.LastPayer.label" bundle="${bl_labels}"/>
				<%} %>
				</td>   
				<!-- Added for NMC-JD-CRF-0010.1-15/5/2020-palaniNarayanan Starts -->      
				<%if(siteSpecPolDefRemarks){%>
					<td>
						<div id="remarks" style='visibility:visible'>&nbsp;<a href="#" onclick="return Remarkshow();"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a><img id="remarksImg" src='../../eCommon/images/mandatory.gif' style='visibility:visible'></img>	
						</div>
					</td>                     
				<% } %>
				<!-- Added for NMC-JD-CRF-0010.1-15/5/2020-palaniNarayanan Ends -->
				<td width='18%' class='label'>
				<!-- Added V181003-Aravindh/AAKH-CRF-0107/Starts -->
				<%if(siteSpecRefPrice) { %>
					<% if("Y".equals(policyBean.getCoverRefPrice())) { %>
						<input type="checkbox" name='coverRefPriceHdr' id='coverRefPriceHdr' id='coverRefPriceHdr' onclick='unCheckAllLineLvlRefChkBox()' checked <%=totalDisabled %> />
					<% }
					else { %>
						<input type="checkbox" name='coverRefPriceHdr' id='coverRefPriceHdr' id='coverRefPriceHdr' onclick='unCheckAllLineLvlRefChkBox()' <%=totalDisabled %> />
					<% } %>
					<fmt:message key="eBL.CoverReferencePrice.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;
				<% } %>
				<!-- Added V181003-Aravindh/AAKH-CRF-0107/Ends -->
				<!-- Added V190517-Aravindh/NMC-JD-CRF-0010/Starts -->
				<%-- <%if(siteSpecPolApprv) { %>
					<input type='checkbox' name='policyApprvdYN' id='policyApprvdYN' id='policyApprvdYN' <%="Y".equals(policyBean.getPolicyApproved())?"checked":"" %> <%=totalDisabled %> />
					&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Approved.label" bundle="${common_labels}"/>
				<% } %> --%>
				<!-- Added V190517-Aravindh/NMC-JD-CRF-0010/Ends -->
				</td>
				
				<td class='label' width='15%'>
				<%if(acrossEncCount > 0){ %>
					<%if("disabled".equals(totalDisabled)){ %>
						<a disabled >Across Encounter</a>
					<%}
					else{%>
						<a href='javascript:fnAcrossEncounter();' >Across Encounter</a>
					<%} %>
				<%} %>
				</td>	
				<!-- Commented V181015-Aravindh/AAKH-CRF-0107/Added above -->
				<!-- <td width='18%'>
				</td> -->	
			</tr>
      	</table>
      	<input type="hidden" name='payerGroup' id='payerGroup' value='<%=payerGroup%>'>
      	<input type="hidden" name='payer' id='payer' value='<%=payer%>'>
      	<input type="hidden" name='policy' id='policy' value='<%=policy%>'>
      	<input type="hidden" name='episodeType' id='episodeType' value='<%=episodeType%>'>
      	<input type="hidden" name='encGrpId' id='encGrpId' value='<%=encGrpId%>'>
      	<input type="hidden" name='episodeId' id='episodeId' value='<%=episodeId%>'>
      	<input type="hidden" name='patientId' id='patientId' value='<%=patientId%>'>
     </form>
</body>
</html>

