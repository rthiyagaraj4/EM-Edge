<!DOCTYPE html>
<%/*
Sr No        Version           Incident        SCF/CRF                     		Developer Name
-----------------------------------------------------------------------------------------------
 1			V230210								MMS-DM-CRF-0209.5			Namrata Charate
 2			V230801		   48394	   			MMS-DM-SCF-0898-TF			Namrata Charate
*/ %>
<%@page import="eBL.MFDRServicesAndItemsBean"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page import="eBL.Common.BlRepository"%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
			
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/BLMultiFactorDeductRule.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
</script>

</head>


<body onload="parent.parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
	
	private String checkForStatus(String inputString) {
 		return (inputString == null) ? "I" : inputString;
 	}
%>
<%
	String beanId = "";
	String beanName = "";
	
	beanId = "bl_MFDRServicesAndItemsBean";
	beanName = "eBL.MFDRServicesAndItemsBean";
	
	MFDRServicesAndItemsBean policyBean = null;
	HashMap<String,List<MFDRServicesAndItemsBean>> policyMap = null;
	List<MFDRServicesAndItemsBean> policyList = null; 
	String checked = "";
	String disabled = "";
	String exclDisabled = "";
	String siteId = ""; 
	System.err.println("Mode in ServicesAndItems page is "+request.getParameter("mode"));
	String mode = checkForNull(request.getParameter("mode"));
	String payerGroup = checkForNull(request.getParameter("payergroupCode"));
	String payer = checkForNull(request.getParameter("payerCode"));
	String policy = checkForNull(request.getParameter("policyCode"));
	String clinicCategory = checkForNull(request.getParameter("cat_code"));
	String calledForm = request.getParameter("calledForm") == null ? "" : request.getParameter("calledForm");
	String startDate = checkForNull(request.getParameter("startDate"));
	String endDate = checkForNull(request.getParameter("endDate"));
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	String totalDisabled = "";
	String auth = "";
	auth = request.getParameter("auth");
	String cust_group_code="";
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String readonly = "";
	String clinicCat_code_desp = "";
	String across_enc_YN = "N";  //V230801
	
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");
	String strLoggedUser = p.getProperty("login_user");
	if(strLoggedUser == null) strLoggedUser="";
	
	
	int tableIndex = 1;
	
	try{
	con = ConnectionManager.getConnection(request);
	policyBean = (MFDRServicesAndItemsBean) getBeanObject(beanId, beanName, request);
	policyMap = policyBean.getPolicyMap();
	
	
	MFDRServicesAndItemsBean policyBean_1 = null;
	
	if ("modify".equals(mode)){
	try{
			readonly = "readonly";
			disabled = "disabled";
			totalDisabled = "disabled";
			auth = "N";
			policyList = new ArrayList<MFDRServicesAndItemsBean>();
			System.err.println("Inside modify mode");
		//	String sqlInfoPage_1 =  BlRepository.getBlKeyValue("Multi_Factor_Deduct_Rule_Hdr_Info");
			String sqlInfoPage_1 = "select decode(hdr.CUST_GROUP_CODE,'**','All Payer Group',(select grp.long_desc from ar_cust_group grp where grp.cust_group_code =  hdr.cust_group_code  )) payer_group, hdr.CUST_GROUP_CODE, decode(hdr.CUST_CODE,'**','All Payer',(select cust.long_name from ar_customer cust where  cust.cust_code  = hdr.cust_code )) payer, hdr.CUST_CODE, decode(hdr.POLICY_TYPE_CODE,'**','All Policy',(select pol.long_desc policy_type from bl_ins_policy_types pol where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id )) policy_type, hdr.POLICY_TYPE_CODE, hdr.operating_facility_id,to_char(hdr.effective_from,'dd/mm/yyyy') effective_from,to_char(hdr.effective_to,'dd/mm/yyyy') effective_to,  episode_type, episode_encounter, SERVICE_ITEM_CATEGORY item_category, ASSIGN_CARE_LOCN_TYPE,  SERV_EXCL_INCL_CRIT, grp.PACKAGE_SERV_GROUP_CODE PACKAGE_SERV_GROUP_CODE , decode(hdr.BLNG_SERV_CODE,'**','All Billing Services', short_desc) short_desc, hdr.CUST_GROUP_CODE, REFERRAL, patient_copay, patient_amount_limit, copay_applied_on, decode(hdr.ASSIGN_CARE_LOCN_CODE,'**',decode(hdr.ASSIGN_CARE_LOCN_TYPE,'C','All Clinic','P','All Procedure Unit','*','All'),(select cgrp.short_desc from op_clinic_lang_vw cgrp where cgrp.clinic_code =  hdr.ASSIGN_CARE_LOCN_CODE and cgrp.language_id = ? and cgrp.facility_id =  hdr.operating_facility_id )) ASSIGN_CARE_LOCN_DESC, hdr.ASSIGN_CARE_LOCN_CODE, across_encounters_yn from bl_insu_serv_item_deduct_dtl hdr, bl_package_serv_group_hdr grp where hdr.operating_facility_id = ?  and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? and hdr.SERVICE_ITEM_CATEGORY = ? and hdr.BLNG_SERV_CODE = grp.PACKAGE_SERV_GROUP_CODE(+) and hdr.operating_facility_id = grp.operating_facility_id(+)";
			
			pstmt = con.prepareStatement(sqlInfoPage_1);
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,payerGroup);
			pstmt.setString(4,payer);
			pstmt.setString(5,policy);
			pstmt.setString(6,clinicCategory);
			System.err.println("Sql Services and Items category query is: "+sqlInfoPage_1);
			rst = pstmt.executeQuery();
			System.err.println("Value for facility, PayerGroup, Payer, Policy, clinicCategory are: "+facility_id+"::"+payerGroup+"::"+"::"+payer+"::"+policy+"::"+clinicCategory);  
			
			if(rst != null){
				while(rst.next()){
				policyBean_1 = new MFDRServicesAndItemsBean();
				policyBean_1.setFacilityId(rst.getString("operating_facility_id"));
				policyBean_1.setEpisodeEncounter(rst.getString("episode_encounter")); 
				policyBean_1.setPatClass(rst.getString("EPISODE_TYPE"));  
				policyBean_1.setPayerGroup(rst.getString("payer_group"));
				policyBean_1.setPayerGroupCode(rst.getString("CUST_GROUP_CODE"));
				policyBean_1.setPayer(rst.getString("payer"));
				policyBean_1.setPayerCode(rst.getString("CUST_CODE"));
				policyBean_1.setPolicyType(rst.getString("policy_type"));
				policyBean_1.setPolicyTypeCode(rst.getString("POLICY_TYPE_CODE"));
				policyBean_1.setClinicProc(rst.getString("ASSIGN_CARE_LOCN_TYPE"));
				policyBean_1.setClinicProcCode(rst.getString("ASSIGN_CARE_LOCN_CODE"));
				policyBean_1.setClinicProcDesc(rst.getString("ASSIGN_CARE_LOCN_DESC"));
				policyBean_1.setInclExclCriteria(rst.getString("SERV_EXCL_INCL_CRIT"));
				policyBean_1.setServiceDetailsDesc(rst.getString("short_desc"));
				policyBean_1.setServiceDetailsCode(rst.getString("PACKAGE_SERV_GROUP_CODE"));
				policyBean_1.setReferral(rst.getString("REFERRAL"));
				policyBean_1.setClinicCat(rst.getString("item_category"));
				policyBean_1.setPatCopay(rst.getString("patient_copay"));
				policyBean_1.setPatLimitAmt(rst.getString("patient_amount_limit"));
				policyBean_1.setAmtGrossNet(rst.getString("copay_applied_on"));
				policyBean_1.setAcrossEncYN(rst.getString("across_encounters_yn"));  //V230801
				policyBean_1.setStartDate(rst.getString("effective_from"));
				policyBean_1.setEndDate(rst.getString("effective_to")); 
				policyBean_1.setStatus("U");	
				policyList.add(policyBean_1);
				}
				rst.close();
			}
			pstmt.close();  
						
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in Info Frame Load - "+e);	
		}
		finally{
			//ConnectionManager.returnConnection(con);
		} 
	}else{
		
		if(!(policyMap == null || policyMap.isEmpty())){
			System.err.println("In PolicyMap if not empty");
			policyList = policyMap.get("ServicesAndItemsCatDtlsPageInfo");		
		}
		else if(policyList == null || policyList.isEmpty()){
			System.err.println("In PolicyMap");
			
			policyBean_1 = new MFDRServicesAndItemsBean();
			policyList = new ArrayList<MFDRServicesAndItemsBean>();
			policyList.add(policyBean_1);
		}
	}  
		
%>

<form name="frmMultiFactDedRuleServicesAndItemsCategory" id="frmMultiFactDedRuleServicesAndItemsCategory">	
      	<table class='grid' border='1' width='100%' cellpadding='3'  cellspacing=0 align="center" id='MultiFactDedRuleServicesAndItems'>  
      		<tr>
			<td class='COLUMNHEADER' nowrap colspan="16" align="center">Services and Items Category Details</td>
			<tr>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EpisodeEncounter.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.type.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.category1.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.Clinic_Proc_unit.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.IncExcCriteria.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.Servicedtls.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.referral.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>				
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PatCopay.label" bundle="${bl_labels}"/>(%)&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PatAmtLimit.label" bundle="${bl_labels}"/>(<fmt:message key="Common.Applicable.label" bundle="${common_labels}"/>)&nbsp;&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/>/<fmt:message key="eBL.Net.label" bundle="${bl_labels}"/>&nbsp;</td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.AcrossEncounter.Label" bundle="${bl_labels}"/>&nbsp;</td> <!-- V230801 -->
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffFromDate.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffToDate.label" bundle="${bl_labels}"/>&nbsp;</td>
			</tr>
			</tr>
			<%
			
			for (MFDRServicesAndItemsBean policyBean1 : policyList) {	
				
					if("U".equals(policyBean1.getStatus())){
										
						readonly = "readonly";
						disabled = "disabled";	
					}
					else if("I".equals(policyBean1.getStatus())){
						readonly = "";
						disabled = "";		
					}
				
			%>
			<tr>
				<td class='fields' nowrap>
					<select  id='episode_<%= tableIndex%>' name='episode_<%= tableIndex%>' <%=disabled %> <%=totalDisabled %> onchange='changeEpsdEnc(<%= tableIndex%>);'>
						<option value='E'><fmt:message key="eBL.Episode.label" bundle="${bl_labels}"/></option>			
					</select>
				</td>
				
				<td class='fields' nowrap>
					<select id='ptClass_<%= tableIndex%>' name='ptClass_<%= tableIndex%>' <%=disabled %> <%=totalDisabled %>>
						<option value='O'><fmt:message key="Common.OP.label" bundle="${common_labels}"/></option>
					</select>
				</td>
				
				<td class='fields' nowrap>
					<input type='text' name='payer_group_desc_<%= tableIndex%>' id='payer_group_desc_<%= tableIndex%>' id='payer_group_desc_<%= tableIndex%>' size='10' maxlength='5'  <%=disabled %> value='<%=checkForNull(policyBean1.getPayerGroup()) %>'  
					onblur="if(this.value!=''){ callCommonValidation(3,payer_group_desc_<%= tableIndex%>,payer_group_code_<%= tableIndex%>,<%= tableIndex%>);}else{fnClearCode(payer_group_code_<%= tableIndex%>,<%= tableIndex%>,1);}" onchange="fnEnableDisablePayer_PayerPolicy('sel','payer_group_desc_<%= tableIndex%>','payer_desc_<%= tableIndex%>','policy_type_desc_<%= tableIndex%>',<%= tableIndex%>);">
					<input type='hidden' name='payer_group_code_<%= tableIndex%>' id='payer_group_code_<%= tableIndex%>' id='payer_group_code_<%= tableIndex%>' value='<%=checkForNull(policyBean1.getPayerGroupCode()) %>'>
					<input type='button' class='button' value='?' <%=disabled %> 
					onClick="callCommonValidation(3,payer_group_desc_<%= tableIndex%>,payer_group_code_<%= tableIndex%>,<%= tableIndex%>);" tabindex='2'>
				</td> 
				
				
				<td class='fields' nowrap>
					<input type='text' name='payer_desc_<%= tableIndex%>' id='payer_desc_<%= tableIndex%>' id='payer_desc_<%= tableIndex%>' size='10' maxlength='5' <%=disabled %> value='<%=checkForNull(policyBean1.getPayer()) %>'  
					onblur="if(this.value!=''){ callCommonValidation(2,payer_desc_<%= tableIndex%>,payer_code_<%= tableIndex%>,<%= tableIndex%>);}else{fnClearCode(payer_code_<%= tableIndex%>,<%= tableIndex%>,2);}">
					<input type='hidden' name='payer_code_<%= tableIndex%>' id='payer_code_<%= tableIndex%>' id='payer_code_<%= tableIndex%>' value='<%=checkForNull(policyBean1.getPayerCode()) %>'>
					<input type='button' class='button' value='?' <%=disabled %> 
					onClick='if(chkForMandFields("P",<%= tableIndex%>)){ callCommonValidation(2,payer_desc_<%= tableIndex%>,payer_code_<%= tableIndex%>,<%= tableIndex%>); }' tabindex='2'>
				</td> 
				
				<td class='fields' nowrap>
					<input type='text' name='policy_type_desc_<%= tableIndex%>' id='policy_type_desc_<%= tableIndex%>' id='policy_type_desc_<%= tableIndex%>' size='10' maxlength='5' <%=disabled %> value="<%=checkForNull(policyBean1.getPolicyType()) %>"  
					onblur="if(this.value!=''){ callCommonValidation(4,policy_type_desc_<%= tableIndex%>,policy_type_code_<%= tableIndex%>,<%= tableIndex%>);}else{fnClearCode(policy_type_code_<%= tableIndex%>,<%= tableIndex%>,2);}">
					<input type='hidden' name='policy_type_code_<%= tableIndex%>' id='policy_type_code_<%= tableIndex%>' id='policy_type_code_<%= tableIndex%>' value='<%=checkForNull(policyBean1.getPolicyTypeCode()) %>'>
					<input type='button' class='button' value='?' <%=disabled %> 
					onClick='if(chkForMandFields("P",<%= tableIndex%>)){ callCommonValidation(4,policy_type_desc_<%= tableIndex%>,policy_type_code_<%= tableIndex%>,<%= tableIndex%>); }' tabindex='2'>
				</td> 
				
				<td class='fields' nowrap>
					<select  id='clinic_category_<%= tableIndex%>' name='clinic_category_<%= tableIndex%>' <%=disabled %> <%=totalDisabled %> onchange="clearClinic(<%= tableIndex%>);" > 
						<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>	
<%
			
			pstmt = con.prepareStatement("select CLINIC_PROC_CATG_CODE, LONG_DESC from op_clinic_proc_category where eff_status='E' order by srl_no" ) ;
			rst = pstmt.executeQuery() ;
			clinicCat_code_desp = "";
			System.err.println("Here 1");
						
			if( rst != null ) 
			{
				while( rst.next() ) 
				{
					String clininc_cat_code = rst.getString( "CLINIC_PROC_CATG_CODE" ) ;
					String long_desc = rst.getString( "LONG_DESC" ) ;
					
					if(clininc_cat_code.equals(policyBean1.getClinicCat()))
					{
						out.println("<option selected value=\""+clininc_cat_code+"\">"+long_desc+"</option>");
						clinicCat_code_desp +=  clininc_cat_code + "~" + long_desc+"||" ;
					}
					else{
						out.println("<option value=\""+clininc_cat_code+"\">"+long_desc+"</option>");
						clinicCat_code_desp +=  clininc_cat_code + "~" + long_desc+"||" ;
						System.err.println("Dropdown fields for diag Cat are: "+clinicCat_code_desp);
					}
				}
			
			}  
			if(rst !=null) rst.close();
			pstmt.close() ;	
			
%>   	
					</select>
				</td>
				
				<td class='fields' nowrap>
					<select  id='clinic_<%= tableIndex%>' name='clinic_<%= tableIndex%>' <%=disabled %> <%=totalDisabled %> onchange="clearClinic(<%= tableIndex%>);">
						<%if("C".equals(policyBean1.getClinicProc())){ %>
							<option value='C' selected><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
						<%} %>
						
						<%if("P".equals(policyBean1.getClinicProc())){ %>
							<option value='P' selected><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='P'><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option>
						<%} %>

						<%if("A".equals(policyBean1.getClinicProc())){ %>
							<option value='A' selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<%}
						else{%>
							<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<%} %>
	
					</select> /
						<input type='text' id='clinic_code_<%= tableIndex%>' name='clinic_code_<%= tableIndex%>' size='4' <%=totalDisabled %> <%=readonly %>  value='<%=checkForNull(policyBean1.getClinicProcCode())%>' <% if(!("readonly".equals(readonly))){ %> onblur="if(this.value!=''){ callBGDesc(1,clinic_<%= tableIndex%>,clinic_desc_<%= tableIndex%>,clinic_code_<%= tableIndex%>); } else{ fnClearCode(clinic_desc_<%= tableIndex%>); }" <% }%>>
						<input type='text' id='clinic_desc_<%= tableIndex%>' <%=totalDisabled %> name='clinic_desc_<%= tableIndex%>' size='20' maxlength='60' <%=disabled %> value='<%=checkForNull(policyBean1.getClinicProcDesc())%>' onblur="if(this.value!=''){ callBGDesc(1,clinic_<%= tableIndex%>,this,clinic_code_<%= tableIndex%>); } else{ fnClearCode(clinic_code_<%= tableIndex%>); }">
						<input type='button' id='clinic_but_<%= tableIndex%>' value='?' <%=totalDisabled %> <%=disabled %> onclick='callBGDesc(1,clinic_<%= tableIndex%>,clinic_desc_<%= tableIndex%>,clinic_code_<%= tableIndex%>)'>
				</td>

				
				<td class='fields' nowrap>
					<select id='incl_excl_criteria_<%= tableIndex%>' name='incl_excl_criteria_<%= tableIndex%>' <%=disabled %> <%=totalDisabled %>>
						<option value='PG'><fmt:message key="eBL.PackageGrouping.label" bundle="${bl_labels}"/></option>
					</select>
				</td>
				
				
				<td class='fields' nowrap>
					<input type='text' name='service_dtls_desc_<%= tableIndex%>' id='service_dtls_desc_<%= tableIndex%>' id='service_dtls_desc_<%= tableIndex%>' size='10' <%=disabled %> value='<%=checkForNull(policyBean1.getServiceDetailsDesc()) %>'  
					onblur="if(this.value!=''){ callCommonValidation(5,service_dtls_desc_<%= tableIndex%>,service_dtls_code_<%= tableIndex%>,<%= tableIndex%>);}else{fnClearCode(service_dtls_code_<%= tableIndex%>,<%= tableIndex%>,3);}" >
					<input type='hidden' name='service_dtls_code_<%= tableIndex%>' id='service_dtls_code_<%= tableIndex%>' id='service_dtls_code_<%= tableIndex%>' value='<%=checkForNull(policyBean1.getServiceDetailsCode()) %>'>
					<input type='button' class='button' value='?' <%=disabled %> 
					onClick="callCommonValidation(5,service_dtls_desc_<%= tableIndex%>,service_dtls_code_<%= tableIndex%>,<%= tableIndex%>);" tabindex='2'>
				</td>
				
				<td class="fields" nowrap>
					<select id="referral_<%= tableIndex%>" name="referral_<%= tableIndex%>" <%=disabled %> <%=totalDisabled %>>
						<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
						<option value="Y" <%="Y".equals(policyBean1.getReferral()) ? "selected" : "" %>><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option>
						<option value="N" <%="N".equals(policyBean1.getReferral()) ? "selected" : "" %>><fmt:message key="eBL.NonReferral.label" bundle="${bl_labels}"/></option>
						<option value="B" <%="B".equals(policyBean1.getReferral()) ? "selected" : "" %>><fmt:message key="Common.Both.label" bundle="${common_labels}" /></option>
					</select>
				</td>
				
				<td class='fields' nowrap>
					<input type='text' id='patCopay_<%= tableIndex%>' name='patCopay_<%= tableIndex%>' size='10' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean1.getPatCopay())%>' maxlength='5'>
				</td>
				
				<td class='fields' nowrap>
					<input type='text' id='patLimitAmt_<%= tableIndex%>' name='patLimitAmt_<%= tableIndex%>' size='10' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this)" value='<%=checkForNull(policyBean1.getPatLimitAmt())%>' maxlength='10'>
				</td>
				
				<td class='fields' nowrap>
					<select name='AmtMode_<%= tableIndex%>' id='AmtMode_<%= tableIndex%>'>						
						<% if(("N").equals(policyBean1.getAmtGrossNet())){ %>
							<option value='N' selected><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
						<%} else{ %>
							<option value='N'><fmt:message key="eBL.Net.label" bundle="${bl_labels}"/></option>
						<%} %>		

						<% if(("G").equals(policyBean1.getAmtGrossNet())){ %>
							<option value='G' selected><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
						<%} else{ %>
							<option value='G'><fmt:message key="eBL.Gross.label" bundle="${bl_labels}"/></option>
						<%} %>
					</select>
				</td>
				
				<!-- V230801 -->
				<td class='fields' nowrap>
					<input type="checkbox" name="across_enc_YN_<%= tableIndex%>" id="across_enc_YN_<%= tableIndex%>" id="across_enc_YN_<%= tableIndex%>" <%=checkForNull(policyBean1.getAcrossEncYN()).equals("Y")?"checked ":""%>  value="<%=checkForNull(policyBean1.getAcrossEncYN())%>">
				</td>
				
				<td class='fields' nowrap>
					<input type='text' id='effFrom_<%= tableIndex%>' <%=totalDisabled %> name='effFrom_<%= tableIndex%>' maxlength='10' size='10' <%=readonly %> value='<%=checkForNull(policyBean1.getStartDate())%>' onblur='effFromDateValidation(this, effFrom_<%= tableIndex%>,effTo_<%= tableIndex%>);'>   
					<img src='../../eCommon/images/CommonCalendar.gif' <%=totalDisabled %> id='effFrom_ctrl_<%= tableIndex%>' <%=disabled %> onClick="return showCalendar('effFrom_<%= tableIndex%>');" />
				</td>
				
				<td class='fields' nowrap>
					<input type='text' id='effTo_<%= tableIndex%>' name='effTo_<%= tableIndex%>' maxlength='10' size='10' value='<%=checkForNull(policyBean1.getEndDate())%>' onblur='effToDateValidation(this, effFrom_<%= tableIndex%>,effTo_<%= tableIndex%>); '> 
					<img src='../../eCommon/images/CommonCalendar.gif' id='effTo_ctrl_<%= tableIndex%>' onClick="return showCalendar('effTo_<%= tableIndex%>');" />
					<input type='hidden' id='oldEndDate_<%= tableIndex%>' name='oldEndDate_<%= tableIndex%>' value='<%=checkForNull(policyBean1.getEndDate())%>'>
					<input type='hidden' name='rowStatus_<%= tableIndex%>' id='rowStatus_<%= tableIndex%>' value='<%= checkForStatus(policyBean1.getStatus())%>'>
					<input type='hidden' name='rowNumber_<%= tableIndex%>' id='rowNumber_<%= tableIndex%>' value='<%= tableIndex%>'>
				</td>

			</tr>
			
<%
		tableIndex++;
			} 
		
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
		</table>
	
<input type='hidden' name='pageInfo' id='pageInfo' value='ServicesAndItemsCategoryDetails'>
<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
<input type='hidden' name='mode' id='mode' value = '<%=mode%>'>
<input type='hidden' name='rowCount' id='rowCount' value='<%=tableIndex -1 %>'>
<input type='hidden' name='last_link' id='last_link' value="">
<input type='hidden' name='clinicCat_code_desp' id='clinicCat_code_desp' value="<%=clinicCat_code_desp%>">

</form>
</body>
</html>

