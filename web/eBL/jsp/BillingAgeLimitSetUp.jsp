<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="BillingReportCriteriaForm" id="BillingReportCriteriaForm"  target="messageFrame">
<TABLE width="100%" CELLSPACING=0 cellpadding=3 align='center'>
			<tr >
				<td  class="columnheader" >Age Limit </td>
			</tr>	
</TABLE>	
<table cellpadding=3 cellspacing=0 width="100%" align="center" border=0>
										
			 <tr>
			 	<td class="label" ><fmt:message key="eBL.ItemCode.label" bundle="${bl_labels}"/></td>
				<td class='fields'>
					<input type="text" name="patient_id" id="patient_id" id="patient_id" 		 maxlength="30"  onBlur="ChangeUpperCase( this );"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
					
				</td>
				
				<td class="label" colspan='3'></td>
				
			 </tr>
			  <tr>
			 <tr>
				<td class='label' >Age Limit (From)</td>	
				<td class='fields'>
				<input type='text' name='minAgeInYrs' id='minAgeInYrs' size='3' maxlength="3"    onKeyPress='return(ChkNumberInput(this,event,"0"))' onBlur='numberCheck(this,"Y")'>Year
				<input type='text' name='minAgeInMths' id='minAgeInMths' size='2' maxlength="2"   onBlur='numberCheck(this,"M")' 
				onKeyPress='return(	ChkNumberInput(this,event,"0"))'>Month
				<input type='text' name='minAgeInDays' id='minAgeInDays' size='2' maxlength="2"   onBlur='numberCheck(this,"D")' 
				onKeyPress='return(ChkNumberInput(this,event,"0"))'>Days
				</td>
			</tr>
			 <tr>
				<td class='label' >Age Limit (To)</td>	
				<td class='fields'>
				<input type='text' name='minAgeInYrs' id='minAgeInYrs' size='3' maxlength="3"    onKeyPress='return(ChkNumberInput(this,event,"0"))' onBlur='numberCheck(this,"Y")'>Year
				<input type='text' name='minAgeInMths' id='minAgeInMths' size='2' maxlength="2"   onBlur='numberCheck(this,"M")' 
				onKeyPress='return(	ChkNumberInput(this,event,"0"))'>Month
				<input type='text' name='minAgeInDays' id='minAgeInDays' size='2' maxlength="2"   onBlur='numberCheck(this,"D")' 
				onKeyPress='return(ChkNumberInput(this,event,"0"))'>Days
				</td>
			</tr>
			 


			
			
		</table>

</form>
</BODY>
</HTML>

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

