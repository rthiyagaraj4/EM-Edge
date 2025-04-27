<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>

<head>
	 <link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eMR/js/LabTestCodesForNotifDis.js'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	</head>
<script>
 function enable_txt(obj)
	{
		if(obj.value!='00')
		        
		  document.forms[0].lab_type.disabled=false;
		 		
		else
		{
          document.forms[0].lab_type.disabled=true;
		   document.forms[0].lab_type.value="";
		}
	}
</script>
	
	<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<% String facility_id=(String)session.getValue("facility_id");

%>
	
	 <form name='form_add_mod' id='form_add_mod'>
	<table width='100%' cellpadding='3' cellspacing='0' border='0' align='center'>
	
	<tr></br>
	<td width='20%' class='label'><fmt:message key="eMR.NotifyDiseases.label" bundle="${mr_labels}"/></td>
<td width='80%' class='fields' ><input type='text' name='notify_dis_code_2' id='notify_dis_code_2' onBlur="searchNotifyDis(this);PopulateValues(this);"><input type='button' name='notify_dis_id' id='notify_dis_id' value='?' class='button' onclick='getNotifyDis(document.forms[0].notify_dis_code_2);PopulateValues(document.forms[0].notify_dis_code_2);'>
		<img src='../../eCommon/images/mandatory.gif' align='center' id='notify_dis_img' style="visibility:visible"></img><input type="hidden" name="notify_dis_code_1" id="notify_dis_code_1">
		<td></tr>
		<tr>
		 <td class='label'  id = lab1 ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
		<td  colspan= class='fields' >
		<SELECT name="search_criteria" id="search_criteria" onchange="enable_txt(this)">
		<option value="00">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
		<option value="test_code"><fmt:message key="eMR.TEST_CODE.label" bundle="${mr_labels}"/></option>
		<option value="test_desc"><fmt:message key="eMR.TEST_DES.label" bundle="${mr_labels}"/></option>
		</SELECT>&nbsp;&nbsp;<INPUT TYPE="text" name="lab_type" id="lab_type"  disabled size=15 maxlength=15></td>
	  <td  colspan='' class='fields' align='center' ><input type='button' name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick="searchTestCode();"></td>
   				</tr>
		<!--<tr><td width='20%' class='label'><fmt:message key="Common.search.label" bundle="${common_labels}"/> </td>
	<td width='80%' class='fields'><input type='text' name='lab_type' id='lab_type' value='' size='15' maxlength='15' ></input><select name='search_criteria' id='search_criteria'><option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option><option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option><option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option></select></td>
	<td class='button'><input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick="searchTestCode();"></td></tr> -->
			
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

