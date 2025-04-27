<!DOCTYPE html>
<%/*
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------
 1           V210211            12033       AMS-CRF-00249            Ram kumar S
*/
%>


<%@page import="eBL.Common.BlRepository"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%!
private String decodeParam(String input){
	String output = "";
	if(input!=null){
		output = URLDecoder.decode(input);
	}
	return output;
}
%>
<%request.setCharacterEncoding("UTF-8");
String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String billingGroup = request.getParameter("billingGroup");
String locale = (String)session.getAttribute("LOCALE");
String facility_id = (String)session.getAttribute("facility_id");

String patient_id = request.getParameter("patient_id");
String episode_type = request.getParameter("episode_type");
String function_id = request.getParameter("function_id");
String blnggrp = request.getParameter("blnggrp");
String encounter_date = request.getParameter("encounter_date");
String citizen_yn = request.getParameter("citizen_yn");
String ext_blng_grp = request.getParameter("ext_blng_grp");
String clng_evnt = request.getParameter("clng_evnt");
String ageVale= request.getParameter("ageVal"); //Added against V210211
if(ageVale == null) ageVale="";//Added Against V210211
if(billingGroup == null) billingGroup="";

HashMap values = new HashMap();
values.put("locale",locale);
values.put("facility_id",facility_id);
values.put("patient_id",decodeParam(patient_id));
values.put("episode_type",decodeParam(episode_type));
values.put("function_id",decodeParam(function_id));
values.put("blnggrp",decodeParam(blnggrp));
values.put("encounter_date",decodeParam(encounter_date));
values.put("citizen_yn",decodeParam(citizen_yn));
values.put("ext_blng_grp",decodeParam(ext_blng_grp));
values.put("AgeValidation",ageVale);// Added Against V210211
String queryForJs = BlRepository.getBlKeyValue("SQL_BL_BLNG_GRP_LKUP",values,"BGLKUP_BG_PAYER_FOR_JS");
%>
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<style>
TD.LABEL_LOCAL
{
  COLOR:#444444;
  /*background-color:#FFFFFF;*/
  background-color:#FFFFFF;
  FONT-SIZE: 8pt;
  TEXT-ALIGN: RIGHT;
  /*TEXT-ALIGN: RIGHT;*/
  PADDING-LEFT:7px;
  PADDING-RIGHT:7px
}
</style>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eBL/js/BLFinDtlsBGPayerLookup.js'></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();"> 
	<form name='frmBGPayerSearch' id='frmBGPayerSearch'>
	<table width='95%' align="center" cellspacing="0">
		<tr>
			<td width='10%' class="label">
				<fmt:message bundle="${bl_labels }" key="eBL.BillingGroup.label"></fmt:message>
			</td>
			<td width='30%' class="fields">
				<input type="text" id='blngGroup' name='blngGroup' maxlength='40' size='25' value='<%=billingGroup %>' onBlur='if(this.value!=""){ callCommonValidation(1,blngGroup,blngGroupCode);}else{fnClearCode(blngGroupCode);}'> &nbsp;
				<input type='hidden' name='blngGroupCode' id='blngGroupCode' value=''>
				<input type='button' class='button' name="blngGrpBtn" id="blngGrpBtn" value='?' onClick="callCommonValidation(1,blngGroup,blngGroupCode)" tabindex='0'>
			</td>
			<td width='10%' class="label">
				<fmt:message bundle="${bl_labels }" key="eBL.PAYER_GROUP.label"></fmt:message>
			</td>
			<td width='30%' class="fields">
				<input type="text" name='payerGroup' id='payerGroup' maxlength='40' size='25' value='' onBlur='if(this.value!=""){ callCommonValidation(3,payerGroup,payerGroupCode);changeRadioSelection();}else{fnClearCode(payerGroupCode);changeRadioSelection();}' > &nbsp;
				<input type='hidden' name='payerGroupCode' id='payerGroupCode' value=''>
				<input type='button' class='button' name="payerGroupBtn" id="payerGroupBtn" value='?' onClick="callCommonValidation(3,payerGroup,payerGroupCode);changeRadioSelection();" tabindex='0' >
			</td>
			<td width='20%' class="label">				
				<fmt:message bundle="${bl_labels }" key="eBL.BillingGroup.label"></fmt:message>&nbsp;
				<input type="radio" id='bgSelection' name='bgSelection'  value='B' checked="checked" onclick="fnChageSelection();">
			</td>
		</tr>

		<tr>
			<td width='10%' class="label">
				<fmt:message bundle="${bl_labels }" key="eBL.PAYER.label"></fmt:message>
			</td>
			<td width='30%' class="fields">
				<input type="text" name='payer' id='payer' maxlength='40' size='25' value='' onBlur='if(this.value!=""){ callCommonValidation(2,payer,payerCode);changeRadioSelection();}else{fnClearCode(payerCode);changeRadioSelection();}' > &nbsp;
				<input type='hidden' name='payerCode' id='payerCode' value=''>
				<input type='button' class='button' name="payerBtn" id="payerBtn" value='?' onClick="callCommonValidation(2,payer,payerCode);changeRadioSelection();" tabindex='0' >
			</td>
			<td width='10%' class="label">
				<fmt:message bundle="${bl_labels }" key="eBL.POLICY.label"></fmt:message>
			</td>
			<td width='30%' class="fields">
				<input type="text" name='policy' id='policy' maxlength='40' size='25' value='' onBlur='if(this.value!=""){ callCommonValidation(4,policy,policyCode);changeRadioSelection();}else{fnClearCode(policyCode);changeRadioSelection();}' > &nbsp;
				<input type='hidden' name='policyCode' id='policyCode' value=''>
				<input type='button' class='button' name="policyBtn" id="policyBtn" value='?' onClick="callCommonValidation(4,policy,policyCode);changeRadioSelection();" tabindex='0' >
			</td>
			<td width='20%' class="label">
				<fmt:message bundle="${bl_labels }" key="eBL.PAYER_GROUP.label"></fmt:message>&nbsp;
				<input type="radio" id='bgSelection' name='bgSelection'  value='P' onclick="fnChageSelection();" >
				
			</td>
		</tr>
		<tr>
			
			<td colspan='5' class="fields">
				<input type="button" class='button' name='btnSearch' id='btnSearch' value='Search' onclick="fnSearch();">
			</td>
		</tr>
	</table>
	<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
    <input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
    
    <input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id %>'>
    <input type='hidden' name='episode_type' id='episode_type' value='<%=episode_type %>'>
    <input type='hidden' name='function_id' id='function_id' value='<%=function_id %>'>
    <input type='hidden' name='blnggrp' id='blnggrp' value='<%=blnggrp %>'>
    <input type='hidden' name='encounter_date' id='encounter_date' value='<%=encounter_date %>'>
    <input type='hidden' name='citizen_yn' id='citizen_yn' value='<%=citizen_yn %>'>
    <input type='hidden' name='ext_blng_grp' id='ext_blng_grp' value='<%=ext_blng_grp %>'>
    <input type='hidden' name='clng_evnt' id='clng_evnt' value='<%=clng_evnt %>'>
    <input type='hidden' name='queryForJs' id='queryForJs' value="<%=queryForJs %>">
    <input type='hidden' name='previousBG' id='previousBG' value=''>        
    <input type='hidden' name='ageVale' id='ageVale' value='<%=ageVale%>'>    
	</form>
</body>
</html>

