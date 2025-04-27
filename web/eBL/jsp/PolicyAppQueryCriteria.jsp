<!DOCTYPE html>
<html>
<head>
<title>Policy Definition</title>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<% request.setCharacterEncoding("UTF-8");%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>




<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String locale = (String)session.getAttribute("LOCALE");
String facility_id = (String)session.getAttribute("facility_id");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager"  %>
<link rel='stylesheet' type='text/css'
	href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/CommonCalendar.js' language='JavaScript'></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='JavaScript'></script>
<Script src='../../eCommon/js/common.js' language='JavaScript'></Script>
<Script src='../../eBL/js/PolicyApproval.js' language='JavaScript'></Script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'
	onLoad='focusObject()'>
<form name='multiPkgCreate' id='multiPkgCreate' method='post' action='../../eBL/jsp/MultiPkgDiscQueryResult.jsp' onsubmit='SelectAll()'><Script src='../../eCommon/js/common.js' language='JavaScript'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<table width='100%' align='center' cellspacing='0' cellpadding='3'>
	<thead>
		<tr>
			<th align='left' width='20%' colspan='4'><fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th>
		</tr>
	</thead>
	<tbody>
		<tr>
		    <td width='20%' nowrap class='label' ><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
			<td width='25%' nowrap class='fields' >
				<input type='text' name='payerGroup' id='payerGroup' size='30' maxlength='40'  value='' onblur="payerGrpLkup(this,document.forms[0].payerGrpCode,'Y')"/>
				<input type='hidden' name='payerGrpCode' id='payerGrpCode' value=''>
				<input type='button' class='button' name="payerGroupBtn" id="payerGroupBtn" value='?' onClick="payerGrpLkup(document.forms[0].payerGroup,document.forms[0].payerGrpCode)" tabindex='2'>
				<img src='../../eCommon/images/mandatory.gif'>
			</td>
			<td  width="20%" class="label" ><fmt:message key="Common.Payer.label"  bundle="${common_labels}"/></td>	
			<td  width="25%" class="fields" >
				<input type="text"  name="payer" id="payer" size="30"  maxlength='40' value='' onBlur="payerlkup(this,document.forms[0].payerCode,'Y')"/>
				<input type= 'hidden' name="payerCode" id="payerCode"  value=''>
				<input type='button' class='button' name="payerBtn" id="payerBtn" value='?' onClick="payerlkup(document.forms[0].payer,document.forms[0].payerCode)" tabindex='2' >	
			</td>
		</tr>
		<tr>
			<td width='20%' nowrap class='label' ><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
			<td width='25%' nowrap class='fields' >
				<input type='text' name='policyType' id='policyType' size='30' maxlength='40'  value='' onblur="policyLkup(this,document.forms[0].policyTypeCode,'Y')"/>
				<input type='hidden' name='policyTypeCode' id='policyTypeCode' value=''>
				<input type='button' class='button' name="policyType_btn" id="policyType_btn" value='?'onClick="policyLkup(document.forms[0].policyType,document.forms[0].policyTypeCode)" tabindex='2'>
			</td>
			<td class="label" ><fmt:message key="eBL.ApprovalStatus.label" bundle="${bl_labels}"/>
			<td  width="25%" class="fields" >
			<select name='applicalbleTo' id='applicalbleTo'	 onChange=""  value="">
				<option value='*' ><fmt:message key="eBL.ALL.label" bundle="${bl_labels}"/></option>
				<option value='A'   ><fmt:message key="Common.Approved.label" bundle="${common_labels}"/></option>
				<option value='U'   ><fmt:message key="eBL.UNAPPROVED.label" bundle="${bl_labels}"/>
			</select>
			</td>
		</tr>
		<tr>
			<td class="label" colspan='3'>&nbsp;</td>
			<td class="label" align='right'>
				<input type='button' class='button'  onclick='search()' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>"  name='search_but' >
			</td>
		</tr>
	</tbody>
</table>


<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
</form>
</body>
</html>

