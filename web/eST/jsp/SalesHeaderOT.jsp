<!DOCTYPE html>
<%try{%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale	=	 (String)session.getAttribute("LOCALE");

		String sStyle	=	 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StHeader.js"></script>
		<script language="JavaScript" src="../../eST/js/Sales.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body  onLoad="FocusFirstElement()">
<form name="formSalesHeader" id="formSalesHeader">
<%
	String bean_id						=		"salesBean" ;
	String bean_name					=		"eST.SalesBean";

	eST.SalesBean bean					=		(eST.SalesBean)getBeanObject( bean_id, bean_name,request  );  
	bean.setLanguageId(locale);

	String mode							=		request.getParameter("mode");
    String trn_type						=		"SAL";
	String item_class_based				=		bean.getSALItemClassBased(trn_type);
	String sql_id						=		"SQL_ST_SAL_STORE_SELECT";
	String codeDisabled					=			"";
	String encounter_id_visibility		=		"hidden";
	String patient_name_visibility		=		"hidden";
	String chargeable_yn				=		"";
	String	chk_chargeable_yn			=		"";
	String chargeable_yn_value			=		"N";
	String discharge_yn					=		"";
	String chk_discharge_yn				=		"";
	String patient_id					=		(String)request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter					=		(String)request.getParameter("encounter")==null?"":request.getParameter("encounter");
	String store_code					=		(String)request.getParameter("store_code")==null?"":request.getParameter("store_code");

	String preview_disabled				=		"disabled";
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) 
	{
		codeDisabled					=		"disabled";
		preview_disabled				=		"";
	}

	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
	if(bean.getBLModuleInstalled().equals("Y")){
		 chargeable_yn					=		"disabled";
		 chk_chargeable_yn				=		"checked";
		 chargeable_yn_value			=		"Y";
	}else{
		chargeable_yn					=		"disabled";
		chargeable_yn_value				=		"N";
	}
	}

	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
		chargeable_yn					=		 "disabled";
		if(bean.getBLModuleInstalled().equals("Y")){
			chk_chargeable_yn			=		"checked";
			chargeable_yn_value			=		 "Y";
		}

		discharge_yn					=		"disabled";
		if(bean.getTake_home_yn().equals("Y")){
			chk_discharge_yn			=		"checked";
			
		}
}
	int pat_length				=		Integer.parseInt((String)((HashMap)bean.fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_PATIENT_ID_LENGTH"))).get("PATIENT_ID_LENGTH"));
if(patient_id.equals(""))	
	patient_id					=		bean.getPatient_id();
if(store_code.equals(""))
	store_code					=		bean.getStore_code();
%>
<%
//putObjectInBean(bean_id,bean,request);
%>
<jsp:include page="../../eST/jsp/StHeader.jsp" > 
	<jsp:param name="mode"				value="<%=mode%>" />
	<jsp:param name="trn_type"			value="<%=trn_type%>" />
	<jsp:param name="storeSQLID"		value="<%=sql_id%>" />
	<jsp:param name="doc_type_code"		value="<%=bean.getDoc_type_code()%>" />
	<jsp:param name="doc_no"			value="<%=bean.getDoc_no()%>" />
	<jsp:param name="doc_date"			value="<%=bean.getDoc_date()%>" />
	<jsp:param name="doc_ref"			value="<%=bean.getDoc_ref()%>" />
	<jsp:param name="store_code"		value="<%=store_code%>" />
	<jsp:param name="item_class_code"	value="<%=bean.getItem_class_code()%>" /> 
	<jsp:param name="bean_id"			value="<%=bean_id%>" />
	<jsp:param name="bean_name"			value="<%=bean_name%>" />
</jsp:include>
<%	//if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
%>
<%	
	if (!bean.getSal_trn_type().equals("R")) {
		encounter_id_visibility	=	"visible";
	}
	if (!bean.getSal_trn_type().equals("X")) {
		patient_name_visibility	=	"visible";
	}
	//}
%>
<table cellpadding=0 cellspacing=0 border=0 width='100%' align="center" >
<tr>
	<td class='label' ><fmt:message key="eST.SalesType.label" bundle="${st_labels}"/></td>
	<td class='fields'>&nbsp;<select name="sal_trn_type" id="sal_trn_type" <%=codeDisabled%> onChange="checkTRNType(this);"> 
	<option value="I"  <%=bean.getSal_trn_type().equals("I")?"Selected":""%>><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
					<option value="O"<%=bean.getSal_trn_type().equals("O")?"Selected":""%>><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
					<option value="R"<%=bean.getSal_trn_type().equals("R")?"Selected":""%>><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option>
					<option value="X"<%=bean.getSal_trn_type().equals("X")?"Selected":""%>>Direct Sales</option>
		</select>
	</td>
	<td class='label' ><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/></td>
	<td class='fields' >&nbsp;<input type="checkbox" name="discharge_yn" id="discharge_yn" value="<%=chk_discharge_yn%>" <%=chk_discharge_yn%> <%=discharge_yn%> onClick="setDischarge()"></td>
	<td class='label' ><fmt:message key="Common.Chargeable.label" bundle="${common_labels}"/></td>
	<td class='fields' >&nbsp;<input type="checkbox" name="chargeable_yn" id="chargeable_yn" value="<%=chargeable_yn_value%>" <%=chargeable_yn%> <%=chk_chargeable_yn%> onClick="setChargeable()"></td>


</tr>
<tr>
	<td class='label' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td>&nbsp;<input type='text' name='patient_id' id='patient_id' class = "UPPER" size=20 maxLength='<%=pat_length%>' value="<%=bean.getPatient_id()%>" onBlur="ChangeUpperCase(this);getPatientName(this.value);" <%=codeDisabled%>><input type='button' class='button' value="?" onclick="searchPatient();" <%=codeDisabled%>><%=bean.getImage("M")%></td>
	<td class='label' ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
	<td class='fields'>&nbsp;<input type='text' name="patient_name" id="patient_name" value="<%=bean.getPatient_name()%>" size=30 maxLength=40 disabled><span id='id_patient_name_gif' style="visibility:<%=patient_name_visibility%>"><%=bean.getImage("M")%></span></td>
	<td class='label' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
	<td class='fields'>&nbsp;<select name='encounter_id' id='encounter_id' <!-->onChange="callBillingHdrProcedure()" <--> <%=codeDisabled%> >
	<%
	
	String select_legend="<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") +"---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) 
		out.println(select_legend);
	else
		out.println(bean.getEncounter_id_List());
	%>
	</select><span id='id_encounter_id_gif' style="visibility:<%=encounter_id_visibility%>"><%=bean.getImage("M")%></span>
	</td>
</tr>
<tr>
<td class='label' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td colspan='3' class='fields'>&nbsp;<input type='text' name='remarks' id='remarks' size=70 maxLength=200 value="<%=bean.getRemarks()%>">
	</td>
	<td class='label'>&nbsp;</td>
	<td class='fields'>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=button name="preview" id="preview" value='<fmt:message key="Common.Preview.label" bundle="${common_labels}"/>' class=button style='width:53' style='height:14pt' <%=preview_disabled%>  onclick="previewDetails();" >
		</td> 
	
	</tr>
<!-- <tr>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
</tr>
 --></table>
	<input type="hidden" name="patient_id_ot" id="patient_id_ot"			value="<%=patient_id%>">
	<input type="hidden" name="encounter_ot" id="encounter_ot"			value="<%=encounter%>">
	<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
	<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden" name="finalized_yn" id="finalized_yn"			value="N">
	<input type="hidden" name="authorized_by_id" id="authorized_by_id"		value="<%=bean.getLoginById()%>">
	<input type="hidden" name="authorize_allowed_yn" id="authorize_allowed_yn"	value="N">
	<input type="hidden" name="item_class_check" id="item_class_check"		value="<%=item_class_based%>">
	<input type="hidden" name="function_id" id="function_id"				value="<%= request.getParameter("function_id") %>">
</form>
</body>
</html>
<%}catch(Exception e){
	 e.printStackTrace();
 }
 %>

