<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>

<%
	request.setCharacterEncoding("UTF-8");
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 	

	String locale = (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    String sql_ph_drug_query_select1 = PhRepository.getPhKeyValue("SQL_PH_REPORTS_DRUG_LOOKUP");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	    <script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language="javascript"  src="../../eCommon/js/ValidateControl.js"></script>
	    <script language="javascript"  src="../js/DrugDetailsDisplay.js"></script>
	    <script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../js/PhCommon.js"></script>
    	<script language="javascript" src="../js/DrugQuotaLimit.js"></script>	
		<script language="javascript"  src="../js/DrugNameCommonLookup.js"></script> 
    	<script language="JavaScript" src="../../eOR/js/OrCommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    	<SCRIPT>
		function_id = "<%= request.getParameter( "function_id" ) %>"  
	</SCRIPT>
	
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	System.out.println("Inside Add Modify jsp ");
    String mode = request.getParameter("mode");
    String bean_id = "DrugQuotaLimit";
    String bean_name = "ePH.DrugQuotaLimitBean";
    String drugCode = request.getParameter("drug_code");
    String drugDesc = request.getParameter("drug_desc");
    if (mode == null || mode.equals("")) {
    	
        return;
    }

    if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))) {
        return;
    }

    /* Initialize Function specific start */
    DrugQuotaLimitBean bean = (DrugQuotaLimitBean) getBeanObject(bean_id, bean_name, request);
    bean.setLanguageId(locale);
    bean.clear();
    bean.setMode(mode);
    bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));  
	String disabledDrugDesc;
    if (drugCode == null) {
	
		drugCode = "";
		drugDesc = "";
		disabledDrugDesc="";
	}
	else{
    bean.setDrugCode(drugCode);
	bean.setDrug_name(drugDesc);
	disabledDrugDesc ="disabled";
	}
	String strEnabledDisabled = "";

	String Speciality = "";

	String checked = "";
	String status_checked = "";
	String status_value = "";
	String load_status = "";
	//String drugDetail_status = "disabled";
	//String mmEnabled = "";
	String dis = "";
	String spl_code = "", spl_desc = "";
	String sqlSpec = "Select speciality_code,short_desc from am_speciality where eff_status ='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?)order by 2";
	String facility_id = "";

	/* Initialize Function specific end */

%>
<FORM name="formDrugQuotaLimit" id="formDrugQuotaLimit" >
	<table cellpadding="0" cellspacing="0" width="100%" border="0">
		<tr>
			<th align="left" colspan="4"><fmt:message key="ePH.DrugDetail.label" bundle="${ph_labels}"/></th>
		</tr>
		<tr>
			<td  class="label" align="left" ><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
			<td	 align="left" colspan="3">&nbsp;
			<input type="text" maxlength="50" size="50" name="drug_desc" id="drug_desc"  onBlur="clearDrugRelatedFields('onBlur');" value="<%=drugDesc%>" <%=disabledDrugDesc%>>
			<input type="hidden" maxlength="10" size="10" name="drug_code" id="drug_code" value="<%=drugCode%>">
			<input type="button" class="button" value="?" onClick="DrugSearchForQuotaLimit(drug_desc)" ><img src="../../eCommon/images/mandatory.gif" align="center"></img>	
			</td>  
		</tr>
		<tr> <td>&nbsp;</td></tr>
		<tr> <td>&nbsp;</td></tr>
	<tr>
    <th align="left" colspan="4"><fmt:message key="ePH.Speciality.label" bundle="${ph_labels}"/></th>
</tr>
<tr>
    <td class='label'><fmt:message key="ePH.Speciality.label" bundle="${common_labels}"/></td>
    <td class='fields'>
        <input type="hidden" name="spl_Code" id="spl_Code" size="20" maxlength="20" value="">
        <input type="text" name="splName" id="splName" size='25' maxlength='20' onBlur='getSplCode(this);' OnChange='resetValues()'>
        <input type="button" value="?" class="button" name='splSearch' id='splSearch' onClick='populateSpl()'>
    </td>
</tr>
<tr> <td>&nbsp;</td></tr>
<tr> <td>&nbsp;</td></tr>
</table>
	<input type="hidden" name="mode" id="mode" value="<%= mode %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
	<input type='hidden' name='flag' id='flag' value='true'>
    <input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type="hidden" name="sql_ph_drug_query_select1" id="sql_ph_drug_query_select1" value="<%=sql_ph_drug_query_select1%>">
    <INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
</FORM>
</BODY>
</HTML>

