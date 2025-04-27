<!DOCTYPE html>
<%@page import="eBL.CosmeticRuleDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String locale = (String)session.getAttribute("LOCALE");
String facility_id = (String)session.getAttribute("facility_id");

CosmeticRuleDAO cosmeticDAO = new CosmeticRuleDAO();
HashMap<String,String> patientClass = cosmeticDAO.getPatientClass(locale);
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language='javascript' src='../../eBL/js/CosmeticRule.js'></script>
<script>
function focusObject() {
	document.forms[0].elements[0].focus();
}
function addOrderByCol() {
	var i = 0;
	var from = document.getElementById("item")('orderbycols');
	if (from.options.length > 0) {
		var to = document.getElementById("item")('orderbycolumns');
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
	var from = document.getElementById("item")('orderbycolumns');
	if (from.options.length > 0) {
		var to = document.getElementById("item")('orderbycols');
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
</script>
</head>

<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'
	onLoad='focusObject()'>
<form name='query_form' id='query_form' method='post'
	action='../../eBL/jsp/CosmeticRuleQueryResult.jsp'
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
					<td width='40%' class='label'><fmt:message key="eBL.PatientClass.label" bundle="${bl_labels}"/></td>
					<td class='fields' width='60%'>
						<Select name='patientClass' id='patientClass' id='patientClass'>						
						<option value='**'><fmt:message key="eBL.AllPatClass.label" bundle="${bl_labels }"></fmt:message></option>
						<%
						for (Iterator iterator = patientClass.keySet().iterator(); iterator.hasNext();) {
							String type = (String) iterator.next(); %>				
								<option value='<%=type %>'><%=patientClass.get(type) %></option>	
							<% 							
						}
						
						%>	
						</Select>
					</td>
				</tr>
				<tr>
					<td width='40%' class='label'><fmt:message key="eBL.RuleCode.label" bundle="${bl_labels}"/></td>
					<td class='fields' width='60%'>
						<input type='text' name='ruleCode' id='ruleCode' id='ruleCode' size="10" value="" onblur="if(this.value!=''){ callCommonLookupCode(ruleDesc,ruleCode,7,1); } else{ fnClearCode(ruleDesc); }">&nbsp;
						<input type='text' name='ruleDesc' id='ruleDesc' id='ruleDesc' size="30" value="" onblur="if(this.value!=''){ callCommonLookupCode(ruleDesc,ruleCode,7,2); } else{ fnClearCode(ruleCode); }">&nbsp;
						<input type='button' class='button' name="ruleBtn" id="ruleBtn" id='ruleBtn' value='?' onClick="callCommonLookupCode(ruleDesc,ruleCode,7,2)" tabindex='2'>				
					</td>
				</tr>
				<tr>
					<td width='40%' class='label'><fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}"/></td>
					<td class='fields' width='60%'>
						<input type='text' name='blngGroupCode' id='blngGroupCode' id='blngGroupCode' size="10" value="" onblur="if(this.value!=''){ callCommonLookupCode(blngGroupDesc,blngGroupCode,6,1); } else{ fnClearCode(blngGroupDesc); }">&nbsp;
						<input type='text' name='blngGroupDesc' id='blngGroupDesc' id='blngGroupDesc' size="30" value="" onblur="if(this.value!=''){ callCommonLookupCode(blngGroupDesc,blngGroupCode,6,2); } else{ fnClearCode(blngGroupCode); }">&nbsp;
						<input type='button' class='button' name="blngGroupBtn" id="blngGroupBtn" value='?' onClick="callCommonLookupCode(blngGroupDesc,blngGroupCode,6,2)" tabindex='2'>				
					</td>
				</tr>
				<tr>
					<td width='40%' class='label'><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels }"></fmt:message></td>
					<td class='fields' width='60%'>
						<input type='text' name='custGrpCode' id='custGrpCode' id='custGrpCode' size="10" value="" onblur="if(this.value!=''){ callCommonLookupCode(custGrpDesc,custGrpCode,2,1); } else{ fnClearCode(custGrpDesc); }">&nbsp;
						<input type='text' name='custGrpDesc' id='custGrpDesc' id='custGrpDesc' size="30" value="" onblur="if(this.value!=''){ callCommonLookupCode(custGrpDesc,custGrpCode,2,2); } else{ fnClearCode(custGrpCode); }">&nbsp;
						<input type='button' class='button' name="custGrpBtn" id="custGrpBtn" id='custGrpBtn' value='?' onClick="callCommonLookupCode(custGrpDesc,custGrpCode,2,2);" tabindex='2'>
					</td>
				</tr>
				<tr>
					<td width='40%' class='label'><fmt:message key="eBL.Customer.label" bundle="${bl_labels }"></fmt:message></td>
					<td class='fields' width='60%'>
						<input type='text' name='custCode' id='custCode' id='custCode' size="10" value="" onblur="if(this.value!=''){ callCommonLookupCode(custDesc,custCode,3,1,custGrpCode); } else{ fnClearCode(custDesc); }">&nbsp;
						<input type='text' name='custDesc' id='custDesc' id='custDesc' size="30" value="" onblur="if(this.value!=''){ callCommonLookupCode(custDesc,custCode,3,2,custGrpCode); } else{ fnClearCode(custCode); }">&nbsp;
						<input type='button' class='button' name="custBtn" id="custBtn" id='custBtn' value='?' onClick="callCommonLookupCode(custDesc,custCode,3,2,custGrpCode)" tabindex='2'>				
					</td>
				</tr>
				<tr>
					<td width='40%' class='label'><fmt:message key="eBL.POLICY_TYPE.label" bundle="${bl_labels}"/></td>
					<td class='fields' width='60%'>						
						<input type='text' name='policyCode' id='policyCode' id='policyCode' size='10' maxlength='10' value='' onblur="if(this.value!=''){ callCommonLookupCode(policyDesc,policyCode,5,1); } else{ fnClearCode(policyDesc); }"/>
						<input type='text' name='policyDesc' id='policyDesc' id='policyDesc' value='' onblur="if(this.value!=''){ callCommonLookupCode(policyDesc,policyCode,5,2); } else{ fnClearCode(policyCode); }">
						<input type='button' class='button' name="policyType_btn" id="policyType_btn" value='?' onClick="callCommonLookupCode(policyDesc,policyCode,5,2)" tabindex='2'>
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
					size='6'>
					<option value='PATIENT_CLASS'><fmt:message key="eBL.PatientClass.label" bundle="${bl_labels}"/></option>
					<option value='BILLING_GROUP_CODE'><fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}"/></option>
					<option value='CUSTOMER_GROUP_CODE'><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></option>
					<option value='CUSTOMER_CODE'><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/></option>
					<option value='POLICY_TYPE_CODE'><fmt:message key="eBL.POLICY_TYPE.label" bundle="${bl_labels}"/></option>
				</select></td>
				<td align='center' width='3%'><input type='button' name='add' id='add'
					class='button' onclick='addOrderByCol()' value='---->'> <input type='button' name='add' id='add' class='button' value='<----'
					onclick='removeOrderByCol()'></img></td>
				<td width='45%' align='center'><select name='orderbycolumns' id='orderbycolumns'
					size='5' multiple='true'>
					<option value='RULE_CODE'><fmt:message key="eBL.RuleCode.label" bundle="${bl_labels}"/></option>
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
<input type='hidden' id='locale' name='locale' id='locale' value='<%=locale %>'>
<input type='hidden' id='facilityId' name='facilityId' id='facilityId' value='<%=facility_id %>'>
</form>
</body>
</html>

