<!DOCTYPE html>
<%@page import="eBL.BLReportIdMapper"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
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
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String rowNumber = request.getParameter("rowNumber");
	String criteria = request.getParameter("criteria");
	String inclExclDesc = "";
	String inclExclCode = "";
	LinkedHashMap<String,String> criteriaMap = new LinkedHashMap<String,String>();
	String siteId = "";
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
<script language="javascript" src="../../eBL/js/PolicyAddTable.js"></script>
<script language="javascript" src="../../eBL/js/PolicyDefinition.js"></script>
<script language='javascript'>
function checkDateFrom(obj){
	var stdt = document.forms[0].startDate.value;
	var endt = document.forms[0].endDate.value;
	var startdtarr =stdt.split("/");
	var enddtarr = endt.split("/");
	var objarr = obj.value.split("/");
	var startdt = new Date();
	var enddt = new Date();
	var objdt = new Date();
	startdt.setFullYear(startdtarr[2], startdtarr[1]-1, startdtarr[0]);
	enddt.setFullYear(enddtarr[2], enddtarr[1]-1, enddtarr[0]);
	objdt.setFullYear(objarr[2], objarr[1]-1, objarr[0]);
	if((objdt < startdt) || (objdt > enddt) ){
		alert("Please enter date in range "+stdt+" and "+endt);
		obj.value = '';
	}
}
function close(){
	var frmObj = document.forms[0];
	xmlString=formXMLStringMain(frmObj);
	//alert(xmlString);
	updation=formValidation(xmlString,"popup");
	window.close();	
}
	
function showCalendarLocal(fromTo,obj){
	if(fromTo == 1){
		return showCalendar('pop_effFrom_'+obj)
	}
	else if(fromTo == 2){
		return showCalendar('pop_effTo_'+obj)
	}
	
}
function showCalendarLocal(fromTo,obj){
	if(fromTo == 1){
		return showCalendar('pop_effFrom_'+obj)
	}
	else if(fromTo == 2){
		return showCalendar('pop_effTo_'+obj)
	}
	
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<br/>
<br/>
<%
String beanId = "bl_PolicyInsuranceMasterBean";
String beanName = "eBL.PolicyInsuranceMasterBean";
String readonly = "";
PolicyInsuranceMasterBean policyBean = null;
String prevTab = rowNumber;
String mode = checkForNull(request.getParameter("mode"));
HashMap<String,List<PolicyInsuranceMasterBean>> policyMap = null;
List<PolicyInsuranceMasterBean> policyList = null; 
String checked = "";
String disabled = "";
String exclDisabled = "";
//String facility_id = (String)session.getAttribute("facility_id");
String payerGroup = checkForNull(request.getParameter("payerGroup"));
String payer = checkForNull(request.getParameter("payer"));
String policy = checkForNull(request.getParameter("policy"));
String patClass = checkForNull(request.getParameter("patClass"));
String blngCode = checkForNull(request.getParameter("blngCode"));
String startDate = checkForNull(request.getParameter("startDate"));
String endDate = checkForNull(request.getParameter("endDate"));

String encEpsd = checkForNull(request.getParameter("encEpsd"));
String gender = checkForNull(request.getParameter("gender"));
String ageGroup = checkForNull(request.getParameter("ageGroup"));
String clinicNursInd = checkForNull(request.getParameter("clinicNursInd"));
String clinicNursCode = checkForNull(request.getParameter("clinicNursCode"));
String spltyCode = checkForNull(request.getParameter("spltyCode"));
Connection con = null;
ResultSet rst = null;
PreparedStatement pstmt = null;
//Delete Definitions
PolicyInsuranceMasterBean deletedPolicyBean = null;
HashMap<String,List<PolicyInsuranceMasterBean>> deletedPolicyMap = null;
List<PolicyInsuranceMasterBean> deletedPolicyList = null; 
//Delete Definitions
try{
	con = ConnectionManager.getConnection(request);
	siteId = BLReportIdMapper.getCustomerId();
	policyBean = (PolicyInsuranceMasterBean) getBeanObject(beanId, beanName, request);
	policyMap = policyBean.getPopupMap();
	if(!(policyMap == null || policyMap.isEmpty())){
		policyList = policyMap.get(rowNumber);
	}
	//Delete Definitions
		deletedPolicyBean = (PolicyInsuranceMasterBean) getBeanObject("DeletedPolicyBean", beanName, request);
		deletedPolicyMap = deletedPolicyBean.getPopupMap();
		if(!(deletedPolicyMap == null || deletedPolicyMap.isEmpty())){
			deletedPolicyList = deletedPolicyMap.get(rowNumber);
		}
	//Delete Definitions
	if ("modify".equals(mode) ) {
		HashMap<String,List<PolicyInsuranceMasterBean>> fmtDetailsMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
		PolicyInsuranceMasterBean fmtDtlsBean = null;
		if(policyList == null || policyList.isEmpty())
		{
			if(deletedPolicyList == null || deletedPolicyList.isEmpty()){
				/*String sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_EXCLUSION_POPUP");


				pstmt = con.prepareStatement(sqlCoverage);
				System.err.println("sqlCoverage->"+sqlCoverage);
				pstmt.setString(1,locale);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,payerGroup);
				pstmt.setString(4,payer);
				pstmt.setString(5,policy);
				pstmt.setString(6,criteria);
				pstmt.setString(7,blngCode);
				pstmt.setString(8,patClass);
				
				pstmt.setString(9,encEpsd);
				pstmt.setString(10,gender);
				pstmt.setString(11,ageGroup);
				pstmt.setString(12,clinicNursInd);
				pstmt.setString(13,clinicNursCode);
				pstmt.setString(14,spltyCode);
				pstmt.setString(15,startDate);
				rst = pstmt.executeQuery();
				
				if(rst!=null){
					policyList = new ArrayList<PolicyInsuranceMasterBean>();
					int rsCnt = 0;
					while (rst.next()) {
						fmtDtlsBean = new PolicyInsuranceMasterBean();

						fmtDtlsBean.setInclExclCriteria(rst.getString("excl_serv_excl_incl_crit"));
						fmtDtlsBean.setBillServCode(rst.getString("excl_blng_serv_code"));
						fmtDtlsBean.setBillServDesc(rst.getString("blng_serv_desc"));
						fmtDtlsBean.setInclExclInd(rst.getString("excl_incl_ind"));
						fmtDtlsBean.setInclusionBasis(rst.getString("copay_ind"));
						fmtDtlsBean.setValue(rst.getString("copay_val"));
						fmtDtlsBean.setServItemQty(rst.getString("qty_capping"));
						fmtDtlsBean.setAmtPerVisit(rst.getString("amount_capping"));
						fmtDtlsBean.setAmtPerIPDay(rst.getString("per_day_amount_limit"));
						fmtDtlsBean.setNoOfDays(rst.getString("no_of_days_limit"));
						fmtDtlsBean.setStartDate(rst.getString("effective_from"));
						fmtDtlsBean.setEndDate(rst.getString("effective_to"));
						fmtDtlsBean.setAmtGrossNet(rst.getString("per_day_amt_limit_gross_net"));
						fmtDtlsBean.setPatCopay(rst.getString("patient_copay"));
						fmtDtlsBean.setPatLimitAmt(rst.getString("patient_amount_limit"));
						fmtDtlsBean.setStatus("U");
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
				PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
				titleBean.setStartDate(startDate);
				titleBean.setEndDate(endDate);
				policyList = new ArrayList<PolicyInsuranceMasterBean>();
				policyList.add(titleBean);
			}
			//Delete Definition
			else{
				policyList.add(new PolicyInsuranceMasterBean());
			}
			//Delete Definition		
			
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
	String inclExclSql  =  	BlRepository.getBlKeyValue("POLICY_DEF_INCL_EXCL_POP_CRITERIA");
	System.err.println(inclExclSql);
	pstmt = con.prepareStatement(inclExclSql);
	pstmt.setString(1,"L_SERV_INC_EXC_CR_"+criteria);
	pstmt.setString(2,locale);
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
      	<table width='180%' class='grid' border='1' cellpadding='3'  cellspacing=0 align="center" id="PolicyPreApprovalPopup">  
      		<tr>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.IncExcCriteria.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.BGServiceDetails.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<!-- New Fields Added -->
				<td class='COLUMNHEADER' nowrap><img src='../../eCommon/images/abt_product_btn.gif' title="Across Encounters" class = 'img' ></td>
				<td class='COLUMNHEADER' nowrap><img src='../../eCommon/images/abt_product_btn.gif' title="Same Group ID for Followup" class = 'img' ></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.TimeLimitGrpOP.label" bundle="${bl_labels}"></fmt:message> </td>				
				<!-- New Fields Added -->
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.IncExcInd.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.InclusionBasis.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.ServItemQty.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.AmtVisit.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.AmtIPDay.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PatCopay.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PatAmtLimit.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.noofdays.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffFromDate.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffToDate.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap>Delete Record</td>			 
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
						
						if("E".equals(policyBean1.getInclExclInd())){
							exclDisabled = "disabled";
						}
						else{
							exclDisabled = "";
						}
			%>
			 <tr>
				<td class='fields' nowrap>
					<Select id='pop_incExCriteria_<%= tableIndex%>' name='pop_incExCriteria_<%= tableIndex%>' <%=disabled %> onchange="clearBillPop(<%= tableIndex%>);">
						<%
						for (Iterator iterator = criteriaMap.keySet().iterator(); iterator.hasNext();) {
							String type = (String) iterator.next();
							if(type.equals(policyBean1.getInclExclCriteria())){ %>
								<option value='<%=type %>' selected><%=criteriaMap.get(type) %></option>	
							<%}
							else{%>
								<option value='<%=type %>'><%=criteriaMap.get(type) %></option>	
							<%} 
							
						}
						
					%>	
						
					</Select>
				</td>
				<td class='fields' nowrap>
					<input type='text' id='pop_bg_code_<%= tableIndex%>' name='pop_bg_code_<%= tableIndex%>' size='12' <%=readonly %> value='<%=checkForNull(policyBean1.getBillServCode())%>' <% if(!("readonly".equals(readonly))){ %> onblur="if(this.value!=''){ callBlngServPopup(1,pop_incExCriteria_<%= tableIndex%>,pop_bg_desc_<%= tableIndex%>,pop_bg_code_<%= tableIndex%>); } else{ fnClearCode(pop_bg_desc_<%= tableIndex%>); }" <% }%>>
					<input type='text' id='pop_bg_desc_<%= tableIndex%>' name='pop_bg_desc_<%= tableIndex%>' size='20' <%=disabled %> value='<%=checkForNull(policyBean1.getBillServDesc())%>' onblur="if(this.value!=''){ callBlngServPopup(2,pop_incExCriteria_<%= tableIndex%>,pop_bg_desc_<%= tableIndex%>,pop_bg_code_<%= tableIndex%>); } else{ fnClearCode(pop_bg_code_<%= tableIndex%>); }">
					<input type='button' id='pop_bg_but_<%= tableIndex%>' value='?' <%=disabled %> onclick='callBlngServPopup(2,pop_incExCriteria_<%= tableIndex%>,pop_bg_desc_<%= tableIndex%>,pop_bg_code_<%= tableIndex%>)'>
				</td>
				<!-- New Fields Added -->
				<td class='fields' nowrap>	
					<select name='pop_acrossEncounter_<%= tableIndex%>' id='pop_acrossEncounter_<%= tableIndex%>' id='pop_acrossEncounter_<%= tableIndex%>' >
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value='Y' <%="Y".equals(policyBean1.getPolicyApplicability())?"selected":"" %>><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
						<option value='N' <%="N".equals(policyBean1.getPolicyApplicability())?"selected":"" %>><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
					</select>
				</td>
				<td class='fields' nowrap>	
					<select name='pop_encGrpIdSameEpsd_<%= tableIndex%>' id='pop_encGrpIdSameEpsd_<%= tableIndex%>' id='pop_encGrpIdSameEpsd_<%= tableIndex%>' >
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<option value='Y' <%="Y".equals(policyBean1.getEncGrpIdSameEpsd())?"selected":"" %>><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
						<option value='N' <%="N".equals(policyBean1.getEncGrpIdSameEpsd())?"selected":"" %>><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
					</select>
				</td>
				<td class='fields' nowrap>	
					<input type='text' size="4"  name='pop_timeLimitValOP_<%= tableIndex%>' id='pop_timeLimitValOP_<%= tableIndex%>' id='pop_timeLimitValOP_<%= tableIndex%>'  maxlength="4" value="<%=checkForNull(policyBean1.getTimeLimitValue())%>" onkeypress="return checkAlpha(event)" onblur="checkForNumber(this)"> &nbsp;&nbsp;
					<select name='pop_timeLimitTypeOP_<%= tableIndex%>' id='pop_timeLimitTypeOP_<%= tableIndex%>' id='pop_timeLimitTypeOP_<%= tableIndex%>' >						
						<!-- <option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>  -->
						<option value='D' <%="D".equals(policyBean1.getTimeLimitType())?"selected":"" %>><fmt:message key="Common.day.label" bundle="${common_labels}"/></option>
						<option value='M' <%="M".equals(policyBean1.getTimeLimitType())?"selected":"" %>><fmt:message key="Common.month.label" bundle="${common_labels}"/></option>
						<option value='Y' <%="Y".equals(policyBean1.getTimeLimitType())?"selected":"" %>><fmt:message key="Common.year.label" bundle="${common_labels}"/></option>
					</select>
				</td>				
				<!-- New Fields Added -->
				<td class='fields' nowrap>
					<Select name='pop_incExInd_<%= tableIndex%>' id='pop_incExInd_<%= tableIndex%>' onchange='changeInclExclIndPop(<%= tableIndex%>);'>
						<%if("I".equals(policyBean1.getInclExclInd())){ %>
							<option value='I' selected><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
						<%} else{ %>
							<option value='I'><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
						<%} %>
						
						<%if("E".equals(policyBean1.getInclExclInd())){ %>
							<option value='E' selected><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
						<%} else{ %>
							<option value='E'><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
						<%} %>
						
					</Select>
				</td>
				
				<td class='fields' nowrap>
					<Select name='pop_incBasis_<%= tableIndex%>' id='pop_incBasis_<%= tableIndex%>' <%=exclDisabled %>>
						<option value=''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
						<%if("P".equals(policyBean1.getInclusionBasis())){ %>
							<option value='P' selected><fmt:message key="eBL.Percentage.label" bundle="${bl_labels}"/></option>
						<%} else{ %>
							<option value='P'><fmt:message key="eBL.Percentage.label" bundle="${bl_labels}"/></option>
						<%} %>

						<%if("R".equals(policyBean1.getInclusionBasis())){ %>
							<option value='R' selected><fmt:message key="eBL.RATE.label" bundle="${bl_labels}"/></option>
						<%} else{ %>
							<option value='R'><fmt:message key="eBL.RATE.label" bundle="${bl_labels}"/></option>
						<%} %>
						
						<%if(!("ALKA".equals(siteId))){
							if("F".equals(policyBean1.getInclusionBasis())){ %>
							<option value='F' selected><fmt:message key="Common.Fixed.label" bundle="${common_labels}"/></option>
						<%} else{ %>
							<option value='F'><fmt:message key="Common.Fixed.label" bundle="${common_labels}"/></option>
						<%	}
						}%>
						
					</Select>
				</td>
				<td class='fields' nowrap>
					<input type='text' <%=exclDisabled %> id='pop_value_<%= tableIndex%>' name='pop_value_<%= tableIndex%>' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean1.getValue()) %>' size='10' maxlength='10'>
				</td>
				<td class='fields' nowrap>
					<input type='text' <%=exclDisabled %> id='pop_servItemQty_<%= tableIndex%>' name='pop_servItemQty_<%= tableIndex%>' onkeypress="return checkAlpha(event)" onblur="checkForNumber(this)" value='<%=checkForNull(policyBean1.getServItemQty())%>' size='10' maxlength='10'>
				</td>
				<td class='fields' nowrap>
					<input type='text' <%=exclDisabled %> id='pop_amtPerVisit_<%= tableIndex%>' name='pop_amtPerVisit_<%= tableIndex%>' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean1.getAmtPerVisit())%>' size='10' maxlength='10'>
				</td>
				<td class='fields' nowrap>
					<input type='text' <%=exclDisabled %> id='pop_amtPerIPDay_<%= tableIndex%>' name='pop_amtPerIPDay_<%= tableIndex%>' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean1.getAmtPerIPDay())%>' size='10' maxlength='10'>&nbsp;&nbsp;
					<select name='AmtMode_<%= tableIndex%>' id='AmtMode_<%= tableIndex%>' <%=exclDisabled %>>
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
				<td class='fields' nowrap>
					<input type='text' <%=exclDisabled %>  id='pop_patCopay_<%= tableIndex%>' name='pop_patCopay_<%= tableIndex%>' size='10' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean1.getPatCopay())%>' maxlength='5'>
				</td>
				<td class='fields' nowrap>
					<input type='text' <%=exclDisabled %>  id='pop_patLimitAmt_<%= tableIndex%>' name='pop_patLimitAmt_<%= tableIndex%>' size='10' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean1.getPatLimitAmt())%>' maxlength='10'>
				</td>
				<td class='fields' nowrap>
					<input type='text' <%=exclDisabled %> id='pop_noOfDays_<%= tableIndex%>' name='pop_noOfDays_<%= tableIndex%>' size='10' onkeypress="return checkAlpha(event)" onblur="checkForNumber(this)" value='<%=checkForNull(policyBean1.getNoOfDays())%>' maxlength='5'>
				</td>
				<td class='fields' nowrap>
					<input type='text' id='pop_effFrom_<%= tableIndex%>' name='pop_effFrom_<%= tableIndex%>' <%=readonly %> size='10' value='<%=checkForNull(policyBean1.getStartDate())%>' onblur='isValidDate(this);checkDateFrom(pop_effFrom_<%= tableIndex%>);compareDates(pop_effFrom_<%= tableIndex%>,pop_effTo_<%= tableIndex%>);'>
					<img src='../../eCommon/images/CommonCalendar.gif' id='effFrom_ctrl_<%= tableIndex%>' <%=disabled %> onClick="return showCalendar('pop_effFrom_<%= tableIndex%>');" />
				</td>
				<td class='fields' nowrap>
					<input type='text' id='pop_effTo_<%= tableIndex%>' name='pop_effTo_<%= tableIndex%>' size='10' value='<%=checkForNull(policyBean1.getEndDate())%>' onblur='isValidDate(this);checkDateFrom(pop_effTo_<%= tableIndex%>);compareDates(pop_effFrom_<%= tableIndex%>,pop_effTo_<%= tableIndex%>);'>
					<img src='../../eCommon/images/CommonCalendar.gif' id='effTo_ctrl_<%= tableIndex%>' onClick="return showCalendar('pop_effTo_<%= tableIndex%>');" />
					<input type='hidden' name='pop_rowStatus<%= tableIndex%>' id='pop_rowStatus<%= tableIndex%>' value='<%= checkForStatus(policyBean1.getStatus())%>'>
				</td>
				<td class='fields' nowrap>
				<%if("Y".equals(policyBean1.getDelFlag())){ %>
					<input type='checkbox' checked name='pop_delFlag<%= tableIndex%>' id='pop_delFlag<%= tableIndex%>'>
				<%} else{ %>
					<input type='checkbox' name='pop_delFlag<%= tableIndex%>' id='pop_delFlag<%= tableIndex%>'>
				<%} %>
				</td>
			</tr>
			<%
			tableIndex++;	
			}	
			%>
      	</table>
      	<input type='hidden' name='pageInfo' id='pageInfo' value='PreApprovalPopup'>
      	<input type='hidden' name='inclRowCount' id='inclRowCount' value='<%=tableIndex -1 %>'>
      	<input type='hidden' name='rowNumber' id='rowNumber' value='<%=rowNumber%>'>
      	<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
      	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
      	<input type='hidden' name='criteria' id='criteria' value='<%=criteria %>'>
      	<input type='hidden' name='startDate' id='startDate' value='<%=startDate %>'>
      	<input type='hidden' name='endDate' id='endDate' value='<%=endDate %>'>
      	<input type='hidden' name='inclExclDesc' id='inclExclDesc' value='<%=inclExclDesc%>'>
      	<input type='hidden' name='inclExclCode' id='inclExclCode' value='<%=inclExclCode%>'>
		<input type='hidden' name='blngCode' id='blngCode' value='<%=blngCode%>'>
		
		<input type='hidden' name='encEpsd' id='encEpsd' value='<%=encEpsd %>'>
      	<input type='hidden' name='gender' id='gender' value='<%=gender %>'>
      	<input type='hidden' name='ageGroup' id='ageGroup' value='<%=ageGroup %>'>
      	<input type='hidden' name='clinicNursInd' id='clinicNursInd' value='<%=clinicNursInd%>'>
      	<input type='hidden' name='clinicNursCode' id='clinicNursCode' value='<%=clinicNursCode%>'>
		<input type='hidden' name='spltyCode' id='spltyCode' value='<%=spltyCode%>'>
		<input type='hidden' name='mode' id='mode' value='<%=mode %>' >
		<input type='hidden' name='payerGroup' id='payerGroup' value='<%=payerGroup%>'>
      	<input type='hidden' name='payer' id='payer' value='<%=payer%>'>
      	<input type='hidden' name='policy' id='policy' value='<%=policy%>'>
      	<input type='hidden' name='patClass' id='patClass' value='<%=patClass%>'>
		<input type='hidden' name='siteId' id='siteId' value='<%=siteId %>'>
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

