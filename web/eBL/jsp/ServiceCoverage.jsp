<!DOCTYPE html>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="eBL.PolicyInsuranceMasterBean"%>
<%@page import="eBL.Common.BlRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String mode = checkForNull(request.getParameter("mode"));
	String facility_id = (String)session.getAttribute("facility_id");
	String payerGroup = checkForNull(request.getParameter("payergroupCode"));
	String payer = checkForNull(request.getParameter("payerCode"));
	String policy = checkForNull(request.getParameter("policyCode"));
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	String totalDisabled = "";
	String auth = "";
	//Added against NMC-JD-CRF-0045 by Priya Starts
	String disabled="";
	boolean siteSpecPolDefservcov=false;
	//Added against NMC-JD-CRF-0045 by Priya Ends
	auth = checkForNull(request.getParameter("auth"));
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<%
PolicyInsuranceMasterBean policyBean = new PolicyInsuranceMasterBean();
try{
	con = ConnectionManager.getConnection(request);
	siteSpecPolDefservcov = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_POLICY_DEF_REMARKS_ALLOWED");//      Added against NMC-JD-CRF-0045 by Priya
		
	if ("modify".equals(mode) ) {
		totalDisabled = "disabled";
		if("Y".equals(auth)){
			totalDisabled = "";
		}
		
		try{
			String sqlInfoPage="";
			//Added against NMC-JD-CRF-0045 by Priya
			if(siteSpecPolDefservcov){
				sqlInfoPage = BlRepository.getBlKeyValue("POLICY_DEF_SERVICE_INFO_GP_POLICY");
			}else{
				sqlInfoPage = BlRepository.getBlKeyValue("POLICY_DEF_SERVICE_INFO");
			}
			pstmt = con.prepareStatement(sqlInfoPage);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,payerGroup);
			pstmt.setString(3,payer);
			pstmt.setString(4,policy);
			rst = pstmt.executeQuery();
			
			if(rst != null){
				while(rst.next()){
					//Added against NMC-JD-CRF-0045 by Priya Starts
					if(siteSpecPolDefservcov){ 
						policyBean.setGroupPolicy(rst.getString("gppolicy"));
					} //Added against NMC-JD-CRF-0045 by Priya Ends
					policyBean.setDefInclExclCriteria(rst.getString("excl_incl_ind"));
					policyBean.setOverRideInclExcl(rst.getString("ovride_incl_excl_unsp_serv_yn"));
					policyBean.setCovInclOthPayers(rst.getString("cumm_cvrg_with_oth_payers_yn"));
					policyBean.setLastPayer(rst.getString("last_payer_coverage_yn"));
					
				}
				rst.close();
			}
			//Added against NMC-JD-CRF-0045 by Priya Starts
			if(siteSpecPolDefservcov){
				if("Y".equals(checkForNull(policyBean.getGroupPolicy()))){
					disabled="disabled";
				}else{
					disabled="";
					}
				}
			//Added against NMC-JD-CRF-0045 by Priya Ends
			pstmt.close();
		}
		catch(Exception e){
			System.err.println("Exception in Service Coverage Load - "+e);
		}
		finally{
			ConnectionManager.returnConnection(con);
		}
	}
}
catch(Exception e){
	
}
finally{
	
}
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
				<td class='label' ><fmt:message key="eBL.DefaultInclExclCriteria.label" bundle="${bl_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<Select name='defaultCriteria' id='defaultCriteria' <%=totalDisabled %> <%=disabled %>>
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
   
				<td width='38%' nowrap class='label' align="right">
				<%if("Y".equals(policyBean.getOverRideInclExcl())){ %>
					<input type="checkbox" <%=totalDisabled %> <%=disabled %> name='overrideInclExcl' checked align="right" />&nbsp;&nbsp;&nbsp;<fmt:message key="eBL.OverrideInclExcl.label" bundle="${bl_labels}"/>
				<%} else{ %>
					<input type="checkbox" <%=totalDisabled %> <%=disabled %> name='overrideInclExcl' align="right" />&nbsp;&nbsp;&nbsp;<fmt:message key="eBL.OverrideInclExcl.label" bundle="${bl_labels}"/>
				<%} %>
					
				</td>                              
				
				<td width='31%' nowrap class='label' align="right">
				<%if("Y".equals(policyBean.getCovInclOthPayers())){ %>
					<input type="checkbox" <%=totalDisabled %> <%=disabled %> name='coverageIclu' checked />&nbsp;&nbsp;&nbsp;<fmt:message key="eBL.CoverageOtherPayer.label" bundle="${bl_labels}"/>
				<%} else{ %>
					<input type="checkbox" <%=totalDisabled %> <%=disabled %> name='coverageIclu'  />&nbsp;&nbsp;&nbsp;<fmt:message key="eBL.CoverageOtherPayer.label" bundle="${bl_labels}"/>
				<%} %>
				</td>	
				
				                               
				<td width='31%' nowrap class='label' align="right">
				<%if("Y".equals(policyBean.getLastPayer())){ %>
					<input type="checkbox" <%=totalDisabled %> <%=disabled %> name='lastPayer' checked />&nbsp;&nbsp;&nbsp;<fmt:message key="eBL.LastPayer.label" bundle="${bl_labels}"/>
				<%} else{ %>
					<input type="checkbox" <%=totalDisabled %> <%=disabled %> name='lastPayer'  />&nbsp;&nbsp;&nbsp;<fmt:message key="eBL.LastPayer.label" bundle="${bl_labels}"/>
				<%} %>
				</td>                              
							
			</tr>

      	</table>
	<!--Added against NMC-JD-CRF-0045 by Priya Starts 28-08-2020-->
	<input type='hidden' name='pageInfo' id='pageInfo' id='pageInfo' value='servcov'>
	<input type='hidden' name='siteSpecPolDefservcov' id='siteSpecPolDefservcov' id='siteSpecPolDefservcov' value="<%=siteSpecPolDefservcov %>">
	<!--Added against NMC-JD-CRF-0045 by Priya Ends-->
    
     </form>
</body>
</html>

