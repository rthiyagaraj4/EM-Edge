<!DOCTYPE html>
<html>
<head>
<title>Policy Definition</title>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String locale = (String)session.getAttribute("LOCALE");
String facility_id = (String)session.getAttribute("facility_id");

Connection con = null;
con = ConnectionManager.getConnection(request);
Boolean siteSpecPolDefRemarks = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_POLICY_DEF_REMARKS_ALLOWED");//Added against NMC-JD-CRF-0045 BL-Regression-NMC-Policy Definition
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager"  %>
<link rel='stylesheet' type='text/css'
	href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/CommonCalendar.js' language='JavaScript'></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></script>
<Script src='../../eCommon/js/common.js' language='JavaScript'></Script>
<Script src='../../eBL/js/PolicyDefinition.js' language='JavaScript'></Script>
<script language='javascript'>
function focusObject() {
	document.forms[0].elements[0].focus();
}
function addOrderByCol() {
	var i = 0;
	var from = document.getElementById('orderbycols');
	if (from.options.length > 0) {
		var to = document.getElementById('orderbycolumns');
		var element = document.createElement('OPTION');
		element.text = from.options[from.selectedIndex].text;
		element.value = from.options[from.selectedIndex].value;
		to.add(element);
		from.remove(from.selectedIndex);
		if (from.options[i])
			from.options[i].selected = true;
		i++;
	}
}
function removeOrderByCol() {
	var j = 0;
	var from = document.getElementById('orderbycolumns');
	if (from.options.length > 0) {
		var to = document.getElementById('orderbycols');
		var element = document.createElement('OPTION');
		element.text = from.options[from.selectedIndex].text;
		element.value = from.options[from.selectedIndex].value;
		to.add(element);
		from.remove(from.selectedIndex);
		if (from.options[j])
			from.options[j].selected = true;
		j++;
	}
}
function SelectAll() {
	var i = 0;
	document.getElementById("orderbycolumns").selectedIndex = 0;
	while (i < document.getElementById("orderbycolumns").length) {
		document.getElementById("orderbycolumns").options[i].selected = true;
		i++;
	}
}
function execQuery() {
	if (document.getElementById("orderbycolumns").options.length > 0) {
		SelectAll();
		document.query_form.submit();
	} else {
		alert(getMessage('ORDERBY_NOT_BLANK', 'Common'))
	}
}

function clearPolicyFields(obj){
	obj.value = '';
}
</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'
	onLoad='focusObject()'>
<form name='query_form' id='query_form' method='post'
	action='../../eBL/jsp/PolicyDefinitionQueryResult.jsp'
	onsubmit='SelectAll()'><Script src='../../eCommon/js/common.js'
	language='JavaScript'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<table width='100%' align='center' cellspacing='0' cellpadding='0'>
	<tr>
		<th align='left' width='20%'><fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th>
		<tr>
			<td width='60%'>
			<p title='Query Criteria'>
			<table width='100%'>
				<tr>
					<td width='40%' class='label'><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
					<!--<td class='fields' width='60%'><input type=text
						name='payerGroup2' id='payerGroup2' size='30' maxlength='30'
						onBlur='makeValidQueryCriteria(this);'></td>-->
					<td class='fields' width='60%'>
						<input type='text' name='payerGroup2' id='payerGroup2' size='40' maxlength='40' value='' onblur='if(this.value!=""){ callCommonValidation(3,payerGroup2,payerCode2); } else{clearPolicyFields(payerCode2);}'/>
						<input type='hidden' name='payerCode2' id='payerCode2' value=''>
						<input type='button' class='button' name="payerGroup2_btn" id="payerGroup2_btn" value='?'  onClick="callCommonValidation(3,payerGroup2,payerCode2);" tabindex='2'>
					</td>
				</tr>
				<tr>
					<td width='40%' class='label'><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/></td>
					<td class='fields' width='60%'>
						<!--<input type=text
						name='payerGroup1' id='payerGroup1' size='30' maxlength='30'
						onBlur='makeValidQueryCriteria(this);'>-->
						<input type='text' name='payerGroup1' id='payerGroup1' size='40' maxlength='40'  value='' onblur='if(this.value!=""){ callCommonValidationQryCriteria(1,payerGroup1,payerCode);} else{clearPolicyFields(payerCode);}'/>
						<input type='hidden' name='payerCode' id='payerCode' value=''>
						<input type='button' class='button' name="payerGroup1_btn" id="payerGroup1_btn" value='?'  onClick="callCommonValidationQryCriteria(1,payerGroup1,payerCode);" tabindex='2'>
					</td>
				</tr>
				<tr>
					<td width='40%' class='label'><fmt:message key="eBL.POLICY_TYPE.label" bundle="${bl_labels}"/></td>
					<td class='fields' width='60%'>
						<!--<input type=text
						name='policyType' id='policyType' size='30' maxlength='30'
						onBlur='makeValidQueryCriteria(this);'>-->
						<!--Added against NMC-JD-CRF-0045 BL-Regression-NMC-Policy Definition  -->
						<%if(siteSpecPolDefRemarks){%>
							<input type='text' name='policyType' id='policyType' size='40' maxlength='40' value='' onblur='if(this.value!=""){ callCommonValidationQryCriteria(2,policyType,policyTypeCode);} else{clearPolicyFields(policyTypeCode);}'/>
							<input type='hidden' name='policyTypeCode' id='policyTypeCode' value=''>
							<input type='button' class='button' name="policyType_btn" id="policyType_btn" value='?'  onClick="callCommonValidationQryCriteria(2,policyType,policyTypeCode);" tabindex='2'>
						<%}else{%>
							<input type='text' name='policyType' id='policyType' size='40' maxlength='40' value='' onblur='if(this.value!=""){ callCommonValidation(4,policyType,policyTypeCode);} else{clearPolicyFields(policyTypeCode);}'/>
							<input type='hidden' name='policyTypeCode' id='policyTypeCode' value=''>
							<input type='button' class='button' name="policyType_btn" id="policyType_btn" value='?'  onClick="callCommonValidation(4,policyType,policyTypeCode);" tabindex='2'>
						<%}%>
					</td>
				</tr>
			</table>
			</td>
		</tr>
</table>
</p>
<table width='100%' align='center'>
	<th width='20%' align='left'><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/>
	</td>
	<tr>
		<td width='60%'>
		<p title='Sort Order'>
		<table width='100%'>
			<td align='center'><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
			<td>&nbsp;</td>
			<td align='center'><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
			<tr>
				<td width='45%' align='center'><select name='orderbycols' id='orderbycols'
					size='5'>
					<option value='hdr.CUST_CODE'><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/></option>
					<option value='hdr.POLICY_TYPE_CODE'><fmt:message key="eBL.POLICY_TYPE.label" bundle="${bl_labels}"/></option>
				</select></td>
				<td align='center' width='3%'><input type='button' name='add' id='add'
					class='button' onclick='addOrderByCol()' value='---->'> <input type='button' name='add' id='add' class='button' value='<----'
					onclick='removeOrderByCol()'></img></td>
				<td width='45%' align='center'><select name='orderbycolumns' id='orderbycolumns'
					size='5' multiple='true'>
					<option value='hdr.CUST_GROUP_CODE'><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></option>
				</select></td>
			</tr>
		</table>
		</p>
		</td>
	</tr>
</table>
<br>
<table border='0' width='100%' align='center'>
	<tr>
		<td width='100%' align='center' class='white'><input type='button' name='ExecuteQuery' id='ExecuteQuery' class='Button'
			onclick='execQuery()'></td>
	</tr>
</table>
<script>var exe=getLabel('Common.Execute.label','common'); document.forms[0].ExecuteQuery.value=exe;</script>
<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
<input type='hidden' name='pageInfo' id='pageInfo' id='pageInfo' value='QryCriteria'><!--//Modified against NMC-JD-CRF-0045--14-08-2020-->
</form>
</body>
</html>

