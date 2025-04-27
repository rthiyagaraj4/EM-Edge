<!DOCTYPE html>
<!--Created by Thamizh selvi on 27th Oct 2017 against ML-MMOH-CRF-0623-->
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>

<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	Connection con	= null;
	try
	{
		String patIdLength			= "";
		//String facilityId			= (String)session.getValue("facility_id");//commented for checkstyle

		con = ConnectionManager.getConnection(request);
		
		patIdLength = eCommon.Common.CommonBean.getPatIdLength(con);
		patIdLength = checkForNull(patIdLength,"0");

%>	

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
		<Script src="../../eCommon/js/DateUtils.js" language="JavaScript"></Script>
		<script src='../../eAE/js/AEQueryBackdatedCons.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
 <body onLoad= 'FocusFirstElement()' onSelect="codeArrestThruSelect()" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
 <form name='BackdatedConsForm' id='BackdatedConsForm' action='' target='result' >
	<table cellspacing=0 cellpadding=0 width='80%' border='0' align='center'>
 		<tr>
		 <td COLSPAN="4"> &nbsp;</td>
		</tr>
		<tr>
		 <td COLSPAN="4"> &nbsp;</td>
		</tr>
		<tr>
			<td width="10%">&nbsp;</td>
			<td width="20%">&nbsp;</td>
			<td class="querydata" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="querydata" width="20%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			<td width="20%">&nbsp;</td>
		</tr>
		<tr>
			<td width="10%">&nbsp;</td>
			<td class='label' width="20%"><fmt:message key="Common.TransactionDate.label" bundle="${common_labels}"/></td>
			<td class="fields" width="20%"><input type='text' name='trn_from_date' id='trn_from_date' maxlength='10' size='12' onblur="doDateValidations(this);"><img src="../../eCommon/images/CommonCalendar.gif"  id='trnFrmDateCalImg' onClick="document.forms[0].trn_from_date.select();return showCalendar('trn_from_date', 'dd/mm/y',null);" style="cursor='hand'">&nbsp;<img src='../../eCommon/images/mandatory.gif' ></img></td>
			<td class="fields" width="20%"><input type='text' name='trn_to_date' id='trn_to_date' maxlength='10' size='12' onblur="doDateValidations(this);"><img src="../../eCommon/images/CommonCalendar.gif"  id='trnToDateCalImg' onClick="document.forms[0].trn_to_date.select();return showCalendar('trn_to_date', 'dd/mm/y',null);" style="cursor='hand'">&nbsp;<img src='../../eCommon/images/mandatory.gif' ></img></td>
		</tr>
		<tr>
		  <td COLSPAN="4"> &nbsp;</td>
		</tr>
		<tr>
			<td width="10%">&nbsp;</td>
			<td class='label' width='20%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td width='20%' class='fields'><input type='text' maxlength='<%=patIdLength%>' size='12' name='patient_id' onKeyPress='return(CheckForSpecChars(event))' onBlur='ChangeUpperCase(this);if(validSplchars(this)) validatePatientId(this);'><input type="button" class=BUTTON name="patient_search" id="patient_search" value="?" onClick="javascript:showLookUp('P')"></td>
		</tr>
		<tr>
		  <td COLSPAN="4"> &nbsp;</td>
		</tr>
		<tr>
			<td width="10%">&nbsp;</td>
			<td width="20%">&nbsp;</td>
			<td width="20%">&nbsp;</td>
			<td width="20%">&nbsp;</td>
			<td class='fields'><input type='button' class='button' name='search' id='search' style="height:20px; width:60px" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick='dispResult()'>&nbsp;<input type='button' class='button' name='clear' id='clear' style="height:20px; width:60px" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onclick='clearResult()'>
			</td>
		</tr>
		<tr>
		  <td COLSPAN="4"> &nbsp;</td>
		</tr>
 </form>
 </body>
<% 
}
catch(Exception e)	
{
	//out.println(e);
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
</html>
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

