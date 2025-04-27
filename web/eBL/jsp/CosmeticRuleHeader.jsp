<!DOCTYPE html>
<%-- Added by Rajesh V for KAUH-CRF-0318
	This page contains the Header criteria--%>
<%@page import="eBL.CosmeticRuleDetailBean"%>
<%@page import="eBL.CosmeticRuleHeaderBean"%>
<%@page import="eBL.CosmeticRuleDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cosmetic Rule Header</title>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");
	String facilityId = (String)session.getAttribute("facility_id");
	String insertUpdate = request.getParameter("mode");
	CosmeticRuleHeaderBean cosmeticBean = null;
	CosmeticRuleDAO cosmeticDAO = new CosmeticRuleDAO();
	HashMap<String,String> patientClass = cosmeticDAO.getPatientClass(locale);
	List<CosmeticRuleDetailBean> criteriaList = null;
	List<CosmeticRuleDetailBean> exclusionList = null;
	int seqNo = 0;
	if((insertUpdate == null || "".equals(insertUpdate)) || "insert".equals(insertUpdate)){
		insertUpdate = "I";
		cosmeticBean = new CosmeticRuleHeaderBean();
		cosmeticBean.setBlngGroupCode("**");
		cosmeticBean.setBlngGroupDesc("All Billing Group");
		cosmeticBean.setCustGroupCode("**");
		cosmeticBean.setCustGroupDesc("All Payer Group");
		cosmeticBean.setCustCode("**");
		cosmeticBean.setCustDesc("All Payer");
		cosmeticBean.setPolicyTypeCode("**");
		cosmeticBean.setPolicyTypeDesc("All Policies");
		
		criteriaList = new ArrayList<CosmeticRuleDetailBean>();
		criteriaList.add(new CosmeticRuleDetailBean());
		exclusionList = new ArrayList<CosmeticRuleDetailBean>();
		exclusionList.add(new CosmeticRuleDetailBean());
		
	}
	else if("modify".equals(insertUpdate)){
		insertUpdate = "U";
		try{
			seqNo = Integer.parseInt(request.getParameter("seqNo"));
			cosmeticBean = cosmeticDAO.getCosmeticBean(seqNo, facilityId, locale);
			criteriaList = cosmeticBean.getCriteriaList();
			exclusionList = cosmeticBean.getExclList();
			
			if(criteriaList == null){
				criteriaList = new ArrayList<CosmeticRuleDetailBean>();
			}
			
			if(exclusionList == null){
				exclusionList = new ArrayList<CosmeticRuleDetailBean>();
			}
			
			if(criteriaList.isEmpty()){
				criteriaList.add(new CosmeticRuleDetailBean());
			}
			
			if(exclusionList.isEmpty()){
				exclusionList.add(new CosmeticRuleDetailBean());
			}
		}
		catch(Exception e){
			
		}
		
	}
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language='javascript' src='../../eBL/js/CosmeticRule.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	$(document).ready(function(){
	
		$("input[type='text']").keydown(function(e){
			if (e.which === 8 && !$(e.target).is("input[type='text']:not([readonly])")) {
				e.preventDefault();
		    }
		});
		
		$('td').each(function(){
			$(this).css('padding-bottom','5px');
		});
		
		if($('#insertUpdate').val() == 'U'){
			disableHeaderFields();
			var effTo = $.trim($('#effTo').val());
			if(effTo != '' && !isAfterNow(effTo,'DMY','en')){
				disableCriteria();
				disableInclExcl();
			}
		}
		
		parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;
	});
</script>
</head>


<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 	onSelect="codeArrestThruSelect();">

	<table  width="100%" align="center" cellpadding=3 cellspacing=0>
			<tr  >
				<td  class='COLUMNHEADER' nowrap ><fmt:message key="eBL.CosmeticRuleHeader.label" bundle="${bl_labels }"></fmt:message></td>
			</tr>
	</table>
	<form name='frmHeader' id='frmHeader' id='frmHeader' method="post" action="../../servlet/eBL.CosmeticRuleSetupServlet" target="messageFrame">	
		<table id='searchTbl' name='searchTbl' id='searchTbl' width="95%" align="center" cellpadding=3 cellspacing=0>
			<tr style="width: 100%">
				<td style="width: 15%" nowrap class='label'>
					<fmt:message key="eBL.PatientClass.label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td style="width: 35%">
					<Select name='patientClass' id='patientClass' id='patientClass'>						
						<option value='**'><fmt:message key="eBL.AllPatClass.label" bundle="${bl_labels }"></fmt:message></option>
						<%
						for (Iterator iterator = patientClass.keySet().iterator(); iterator.hasNext();) {
							String type = (String) iterator.next();
							if(type.equals(cosmeticBean.getPatientClass())){ %>
								<option value='<%=type %>' selected><%=patientClass.get(type) %></option>	
							<%}
							else{%>
								<option value='<%=type %>'><%=patientClass.get(type) %></option>	
							<%} 
							
						}
						
					%>	
					</Select>
				</td>
				<td style="width: 5%">
					
				</td>
				<td style="width: 20%" nowrap class='label'>
					<fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td style="width: 25%">
					<input type='text' name='blngGroupCode' id='blngGroupCode' id='blngGroupCode' size="10" value="<%=cosmeticBean.getBlngGroupCode() %>" onblur="if(this.value!=''){ callCommonLookupCode(blngGroupDesc,blngGroupCode,6,1); } else{ fnClearCode(blngGroupDesc); }">&nbsp;
					<input type='text' name='blngGroupDesc' id='blngGroupDesc' id='blngGroupDesc' size="30" value="<%=cosmeticBean.getBlngGroupDesc() %>" onblur="if(this.value!=''){ callCommonLookupCode(blngGroupDesc,blngGroupCode,6,2); } else{ fnClearCode(blngGroupCode); }">&nbsp;
					<input type='button' class='button' name="blngGroupBtn" id="blngGroupBtn" value='?' onClick="callCommonLookupCode(blngGroupDesc,blngGroupCode,6,2)" tabindex='2'>				
				</td>
			</tr>
			<tr style="width: 100%">
				<td style="width: 15%" nowrap class='label'>
					<fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td style="width: 35%">
					<input type='text' name='custGrpCode' id='custGrpCode' id='custGrpCode' size="10" value="<%=cosmeticBean.getCustGroupCode() %>" onblur="if(this.value!=''){ callCommonLookupCode(custGrpDesc,custGrpCode,2,1); } else{ fnClearCode(custGrpDesc); }">&nbsp;
					<input type='text' name='custGrpDesc' id='custGrpDesc' id='custGrpDesc' size="30" value="<%=cosmeticBean.getCustGroupDesc() %>" onblur="if(this.value!=''){ callCommonLookupCode(custGrpDesc,custGrpCode,2,2); } else{ fnClearCode(custGrpCode); }">&nbsp;
					<input type='button' class='button' name="custGrpBtn" id="custGrpBtn" id='custGrpBtn' value='?' onClick="callCommonLookupCode(custGrpDesc,custGrpCode,2,2);" tabindex='2'>
				</td>
				<td style="width: 5%">
					
				</td>
				<td style="width: 20%" nowrap class='label'>
					<fmt:message key="eBL.Customer.label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td style="width: 25%">
					<input type='text' name='custCode' id='custCode' id='custCode' size="10" value="<%=cosmeticBean.getCustCode() %>" onblur="if(this.value!=''){ callCommonLookupCode(custDesc,custCode,3,1,custGrpCode); } else{ fnClearCode(custDesc); }">&nbsp;
					<input type='text' name='custDesc' id='custDesc' id='custDesc' size="30" value="<%=cosmeticBean.getCustDesc() %>" onblur="if(this.value!=''){ callCommonLookupCode(custDesc,custCode,3,2,custGrpCode); } else{ fnClearCode(custCode); }">&nbsp;
					<input type='button' class='button' name="custBtn" id="custBtn" id='custBtn' value='?' onClick="callCommonLookupCode(custDesc,custCode,3,2,custGrpCode)" tabindex='2'>				
				</td>
			</tr>
			<tr style="width: 100%">
				<td style="width: 15%" nowrap class='label'>
					<fmt:message key="eBL.RuleCode.label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td style="width: 35%">
					<input type='text' name='ruleCode' id='ruleCode' id='ruleCode' size="10" value="<%=cosmeticBean.getRuleCode() %>" onblur="if(this.value!=''){ callCommonLookupCode(ruleDesc,ruleCode,1,1); } else{ fnClearCode(ruleDesc); }">&nbsp;
					<input type='text' name='ruleDesc' id='ruleDesc' id='ruleDesc' size="30" value="<%=cosmeticBean.getRuleDesc() %>" onblur="if(this.value!=''){ callCommonLookupCode(ruleDesc,ruleCode,1,2); } else{ fnClearCode(ruleCode); }">&nbsp;
					<input type='button' class='button' name="ruleBtn" id="ruleBtn" id='ruleBtn' value='?' onClick="callCommonLookupCode(ruleDesc,ruleCode,1,2)" tabindex='2'>
					<img src='../../eCommon/images/mandatory.gif'>				
				</td>
				<td style="width: 5%">
					
				</td>
					<td style="width: 20%" nowrap class='label' ><fmt:message key="eBL.POLICY_TYPE.label" bundle="${bl_labels}"/></td>
				</td>
				<td style="width: 25%">
					<input type='text' name='policyCode' id='policyCode' id='policyCode' size='10' maxlength='10' value='<%=cosmeticBean.getPolicyTypeCode() %>' onblur="if(this.value!=''){ callCommonLookupCode(policyDesc,policyCode,5,1); } else{ fnClearCode(policyDesc); }"/>
					<input type='text' name='policyDesc' id='policyDesc' id='policyDesc' value='<%=cosmeticBean.getPolicyTypeDesc() %>' onblur="if(this.value!=''){ callCommonLookupCode(policyDesc,policyCode,5,2); } else{ fnClearCode(policyCode); }">
					<input type='button' class='button' name="policyType_btn" id="policyType_btn" value='?' onClick="callCommonLookupCode(policyDesc,policyCode,5,2)" tabindex='2'>
				</td>
			</tr>
			<tr style="width: 100%">
				<td style="width: 15%" nowrap class='label'>
					<fmt:message key="eBL.EffectiveFrom.Label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td style="width: 35%">
					<input type='text' name='effFrom' id='effFrom'  id='effFrom' size='10' maxlength='10' readonly value='<%=cosmeticBean.getStartDate() %>' />
					<img src='../../eCommon/images/CommonCalendar.gif'  id='effFrom_ctrl' disabled />
				</td>
				<td style="width: 5%">
					
				</td>
				<td style="width: 20%" nowrap class='label'>
					<fmt:message key="eBL.EffectiveTo.Label" bundle="${bl_labels }"></fmt:message>
				</td>
				<td style="width: 25%">
					<input type='text' name='effTo' id='effTo'  id='effTo' size='10' maxlength='10' readonly value='<%=cosmeticBean.getEndDate() %>' />
					<img src='../../eCommon/images/CommonCalendar.gif'  id='effTo_ctrl' disabled />
				</td>
			</tr>
			<tr style="width: 100%">
				<td style="width: 20%" nowrap class='label'>
					<%if("D".equals(cosmeticBean.getStatus())){ %>
						<input type='checkbox' name='ruleStatus' id='ruleStatus' id='ruleStatus' >
					<%} else{ %>
						<input type='checkbox' name='ruleStatus' id='ruleStatus' id='ruleStatus' checked >
					<%} %>
					 &nbsp; <fmt:message key="Common.enabled.label" bundle="${common_labels }"></fmt:message>
				</td>
			</tr>
		</table>
		<input type='hidden' name='insertUpdate' id='insertUpdate' id='insertUpdate' value='<%=insertUpdate %>' />
		<input type='hidden' name='seqNo' id='seqNo' id='seqNo' value='<%=seqNo %>' />
		</form>
		<br/>
		<br/>
		<table style="width: 100%" align="center">
			<tr style="width: 100%">
				<td style="width: 40%"  class='COLUMNHEADER'  >
					<fmt:message key="eBL.CriteriaForTax.label" bundle="${bl_labels }"></fmt:message>
				</td>
				</td>
				<td style="width: 5%">
				</td>
				<td style="width: 55%"  class='COLUMNHEADER'  >
					<fmt:message key="eBL.InclusionExclusion.label" bundle="${bl_labels }"></fmt:message>
				</td>
			</tr>
		</table>
		<br/>
		<table style="width: 100%" align="center" >
			<tr style="width: 100%" valign="top">
				<td style="width: 40%" >
					<form name='frmCriteria' id='frmCriteria' id='frmCriteria'>
						<table style="width:100%" id='tblCriteria' name='tblCriteria' id='tblCriteria' class='grid' border='1'  cellpadding='3'  cellspacing=0>
							<tr style="width: 100%">
								<td style="width: 30%; padding-bottom: 10px;"  nowrap class='COLUMNHEADER'>
									<fmt:message key="eBL.Type.label" bundle="${bl_labels }" ></fmt:message>
								</td>
								<td style="width: 45%; padding-bottom: 10px;"  nowrap class='COLUMNHEADER'>
									<fmt:message key="eBL.ServiceCode.label" bundle="${bl_labels }" ></fmt:message>
									&nbsp;<img src='../../eCommon/images/mandatory.gif'>
								</td>
								<td style="width: 15%;"  nowrap class='COLUMNHEADER'>
									<fmt:message key="Common.Add.label" bundle="${common_labels }"></fmt:message>
								</td>
								<td style="width: 10%"  nowrap class='COLUMNHEADER'>
									<fmt:message key="Common.Remove.label" bundle="${common_labels }"></fmt:message>
								</td>
							</tr> 
							<%
							int cCntr = 0;
							String disabled = "";
							String cStatus = "";
							for(CosmeticRuleDetailBean criteriaBean:criteriaList){ 
								cCntr++;
								if(!"".equals(criteriaBean.getServCode())){
									disabled = "disabled";
									cStatus = "U";
								}
								else{
									disabled = "";
									cStatus = "I";
								}
							%>
							<tr style="width: 100%" rowValue='<%=cCntr %>' id='tr<%=cCntr %>' >
								<td style="width: 30%">
									<select name='servType<%=cCntr %>' id='servType<%=cCntr %>' id='servType<%=cCntr %>' onchange="fnServTypeChange(this,servCode<%=cCntr %>,servDesc<%=cCntr %>)" <%=disabled %>>
									<option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels }"></fmt:message></option>
									<%if("BSG".equals(criteriaBean.getServType())){ %>	
										<option value='BSG' selected><fmt:message key="eBL.SERVICE_GROUP.label" bundle="${bl_labels }" ></fmt:message></option>
									<%} else{ %>
										<option value='BSG'><fmt:message key="eBL.SERVICE_GROUP.label" bundle="${bl_labels }" ></fmt:message></option>
									<%} %>
									<%if("BSGC".equals(criteriaBean.getServType())){ %>	
										<option value='BSGC' selected><fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels }" ></fmt:message></option>
									<%} else{ %>
										<option value='BSGC'><fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels }" ></fmt:message></option>
									<%} %>	
									<%if("S".equals(criteriaBean.getServType())){ %>	
										<option value='S' selected><fmt:message key="eBL.BillingService.label" bundle="${bl_labels }" ></fmt:message></option>
									<%} else{ %>
										<option value='S'><fmt:message key="eBL.BillingService.label" bundle="${bl_labels }" ></fmt:message></option>
									<%} %>				
									
															
									</select>
								</td>
								<td style="width: 45%">
									<%if(!"".equals(criteriaBean.getServCode())){%>	
										<input type='text' readonly name='servCode<%=cCntr %>' id='servCode<%=cCntr %>' id='servCode<%=cCntr %>' size="10" value="<%=criteriaBean.getServCode() %>" >&nbsp;
										<input type='text' readonly name='servDesc<%=cCntr %>' id='servDesc<%=cCntr %>' id='servDesc<%=cCntr %>' size="20" value="<%=criteriaBean.getServDesc() %>" >&nbsp;
										<input type='button' disabled class='button' name="servBtn<%=cCntr %>" id="servBtn<%=cCntr %>" value='?' onClick="callCommonLookupCode(servDesc<%=cCntr %>,servCode<%=cCntr %>,4,2,servType<%=cCntr %>)" tabindex='2'>										
									<%} else{ %>
										<input type='text' name='servCode<%=cCntr %>' id='servCode<%=cCntr %>' id='servCode<%=cCntr %>' size="10" value="<%=criteriaBean.getServCode() %>" onblur="if(this.value!=''){ callCommonLookupCode(servDesc<%=cCntr %>,servCode<%=cCntr %>,4,1,servType<%=cCntr %>); validateDuplicate(1,<%=cCntr %>); } else{ fnClearCode(servDesc<%=cCntr %>); }">&nbsp;
										<input type='text' name='servDesc<%=cCntr %>' id='servDesc<%=cCntr %>' id='servDesc<%=cCntr %>' size="20" value="<%=criteriaBean.getServDesc() %>" onblur="if(this.value!=''){ callCommonLookupCode(servDesc<%=cCntr %>,servCode<%=cCntr %>,4,2,servType<%=cCntr %>); validateDuplicate(1,<%=cCntr %>); } else{ fnClearCode(servCode<%=cCntr %>); }">&nbsp;
										<input type='button' class='button' name="servBtn<%=cCntr %>" id="servBtn<%=cCntr %>" value='?' onClick="callCommonLookupCode(servDesc<%=cCntr %>,servCode<%=cCntr %>,4,2,servType<%=cCntr %>); validateDuplicate(1,<%=cCntr %>);" tabindex='2'>
									<%} %>	
																		
								</td>
								<td style="width: 15%">
									<span style="color: blue; font-size: 15px; padding-left: 10px;"   onclick="fnAddCriteria();">+</span>
								</td>
								<td style="width: 10%">
									<input type='checkbox' id='criteriaRem<%=cCntr %>' name='criteriaRem<%=cCntr %>'>
									<input type='hidden' name='criteriaStatus<%=cCntr %>' id='criteriaStatus<%=cCntr %>' id='criteriaStatus<%=cCntr %>' value='<%=cStatus %>'>
								</td>
							</tr>
						<%} %>
						</table>
						<input type='hidden' name='criteriaLastRow' id='criteriaLastRow' id='criteriaLastRow' value=''>
					</form>
				</td>
				<td style="width: 5%">
				</td>
				<td style="width: 55%">
					<form name='frmInclExcl' id='frmInclExcl' id='frmInclExcl'> 
						<table style="width:100% " id='tblInclExcl' name='tblInclExcl' id='tblInclExcl'align="center" class='grid' border='1'  cellpadding='3'  cellspacing=0>
							<tr style="width: 100%">
								<td style="width: 25%; padding-bottom: 10px;"  nowrap class='COLUMNHEADER'>
									<fmt:message key="eBL.Type.label" bundle="${bl_labels }" ></fmt:message>
								</td>
								<td style="width: 35%; padding-bottom: 10px;" nowrap class='COLUMNHEADER'>
									<fmt:message key="eBL.ServiceCode.label" bundle="${bl_labels }" ></fmt:message>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
								</td>								
								<td style="width: 20%; padding-bottom: 10px;" nowrap class='COLUMNHEADER'>
									<fmt:message key="eBL.InclusionExclusion.label" bundle="${bl_labels }"></fmt:message>
								</td>
								<td style="width: 10%"  nowrap class='COLUMNHEADER'>
									<fmt:message key="Common.Add.label" bundle="${common_labels }"></fmt:message>
								</td>
								<td style="width: 10%"  nowrap class='COLUMNHEADER'>
									<fmt:message key="Common.Remove.label" bundle="${common_labels }"></fmt:message>
								</td>
							</tr> 
							<%
							int eCntr = 0;
							String eDisabled = "";
							String eStatus = "";
							for(CosmeticRuleDetailBean exclusionBean:exclusionList){ 
								eCntr++;
								if(!"".equals(exclusionBean.getServCode())){
									eDisabled = "disabled";
									eStatus = "U";
								}
								else{
									eDisabled = "";
									eStatus = "I";
								}
							%>
							<tr  rowValue='<%=eCntr %>' id='tr<%=eCntr %>' style="width: 100%">
								<td style="width: 25%">
								<select name='inclServType<%=eCntr %>' id='inclServType<%=eCntr %>' id='inclServType<%=eCntr %>' onchange="fnServTypeChange(this,blngServCode<%=eCntr %>,blngServDesc<%=eCntr %>)" <%=eDisabled %>>
									<option value=''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels }"></fmt:message></option>	
									<%if("BSG".equals(exclusionBean.getServType())){ %>	
										<option value='BSG' selected><fmt:message key="eBL.SERVICE_GROUP.label" bundle="${bl_labels }" ></fmt:message></option>
									<%} else{ %>
										<option value='BSG'><fmt:message key="eBL.SERVICE_GROUP.label" bundle="${bl_labels }" ></fmt:message></option>
									<%} %>
									<%if("BSGC".equals(exclusionBean.getServType())){ %>	
										<option value='BSGC' selected><fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels }" ></fmt:message></option>
									<%} else{ %>
										<option value='BSGC'><fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels }" ></fmt:message></option>
									<%} %>	
									<%if("S".equals(exclusionBean.getServType())){ %>	
										<option value='S' selected><fmt:message key="eBL.BillingService.label" bundle="${bl_labels }" ></fmt:message></option>
									<%} else{ %>
										<option value='S'><fmt:message key="eBL.BillingService.label" bundle="${bl_labels }" ></fmt:message></option>
									<%} %>											</select>
								</td>
								<td style="width: 35%">
									<% if(!"".equals(exclusionBean.getServCode())){%>
										<input type='text' readonly name='blngServCode<%=eCntr %>' id='blngServCode<%=eCntr %>' id='blngServCode<%=eCntr %>' size="10" value="<%=exclusionBean.getServCode() %>" >&nbsp;
										<input type='text' readonly name='blngServDesc<%=eCntr %>' id='blngServDesc<%=eCntr %>' id='blngServDesc<%=eCntr %>' size="20" value="<%=exclusionBean.getServDesc() %>" >&nbsp;
										<input type='button' class='button' disabled name="blngServBtn<%=eCntr %>" id="blngServBtn<%=eCntr %>" value='?'  tabindex='2'>
									<%} else{ %>
										<input type='text' name='blngServCode<%=eCntr %>' id='blngServCode<%=eCntr %>' id='blngServCode<%=eCntr %>' size="10" value="<%=exclusionBean.getServCode() %>" onblur="if(this.value!=''){ callCommonLookupCode(blngServDesc<%=eCntr %>,blngServCode<%=eCntr %>,4,1,inclServType<%=eCntr %>); validateDuplicate(2,<%=cCntr %>); } else{ fnClearCode(blngServDesc<%=eCntr %>); }">&nbsp;
										<input type='text' name='blngServDesc<%=eCntr %>' id='blngServDesc<%=eCntr %>' id='blngServDesc<%=eCntr %>' size="20" value="<%=exclusionBean.getServDesc() %>" onblur="if(this.value!=''){ callCommonLookupCode(blngServDesc<%=eCntr %>,blngServCode<%=eCntr %>,4,2,inclServType<%=eCntr %>); validateDuplicate(2,<%=cCntr %>); } else{ fnClearCode(blngServCode<%=eCntr %>); }">&nbsp;
										<input type='button' class='button' name="blngServBtn<%=eCntr %>" id="blngServBtn<%=eCntr %>" value='?' onClick="callCommonLookupCode(blngServDesc<%=eCntr %>,blngServCode<%=eCntr %>,4,2,inclServType<%=eCntr %>); validateDuplicate(2,<%=cCntr %>); " tabindex='2'>
									<%} %>
									
																		

								</td>
								<td style="width: 20%">
									<select name='inclExcl<%=eCntr %>' id='inclExcl<%=eCntr %>' id='inclExcl<%=eCntr %>'>									
									<%if("I".equals(exclusionBean.getInclExclYN())){ %>	
										<option value='I' selected><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
									<%} else{ %>
										<option value='I'><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
									<%} %>
									<%if("E".equals(exclusionBean.getInclExclYN())){ %>	
										<option value='E' selected><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
									<%} else{ %>
										<option value='E' ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
									<%} %>
									
									</select>
								</td>
								<td style="width: 10%">
									<span style="color: blue; font-size: 15px; padding-left: 10px;" onclick="fnAddInclExcl();">+</span>
								</td>
								<td style="width: 10%; " >
									<input type='hidden' name='inclExclStatus<%=eCntr %>' id='inclExclStatus<%=eCntr %>' id='inclExclStatus<%=eCntr %>' value='<%=eStatus %>'>
									<input type='checkbox' id='inclExclRem<%=eCntr %>' name='inclExclRem<%=eCntr %>'>
								</td>
							</tr>
							<%} %>
						</table>
						<input type='hidden' name='exclLastRow' id='exclLastRow' id='exclLastRow' value=''>
					</form>
				</td>
			</tr>
		</table>
		<input type='hidden' name='locale' id='locale' id='locale' value='<%=locale %>' />
		<input type='hidden' name='facilityId' id='facilityId' id='facilityId' value='<%=facilityId %>' />		
</body>
</html>

