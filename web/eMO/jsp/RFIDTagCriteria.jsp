<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*,javax.servlet.jsp.*,java.util.*"   contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
<% 	
	try
	{
     	request.setCharacterEncoding("UTF-8");
//		String locale=(String)session.getAttribute("LOCALE"); 
		String where_condition= checkForNull(request.getParameter("where_condition"));
		String RFID_Tag_No= checkForNull(request.getParameter("RFID_Tag_No"));
		String patient_id= checkForNull(request.getParameter("patient_id"));
 
		String sStyle	=
        (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
        <script language='javascript' src='../../eMO/js/MOBayAvailability.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
		function loadRFIDTag(){
			document.RFIDTagForm.search.click();				
		}
		function clearResultContent(){			 
			parent.frames[1].document.RFIDTagForm.reset();	
			parent.frames[2].document.location.href = '../../eCommon/html/blank.html' ;
		}

		function getRFIDDetails(){		
			document.RFIDTagForm.submit();		
		}
		</script>
		
	</head>

	<body onMouseDown="CodeArrest();" onLoad='loadRFIDTag();' onKeyDown = 'lockKey();'>
	<form name='RFIDTagForm' id='RFIDTagForm' action = "../../eMO/jsp/RFIDTagResult.jsp" target='result' >
	<table cellpadding="0" cellspacing="0" border="0" width="97%" align = "center">
	<tr width="100%">
	<td width="20%" class="LABEL"><fmt:message key="eMO.RFIDTag.label" bundle="${mo_labels}"/>	</td>
	<td><input width="30%"  type='text' name='rfid_tag_no' id='rfid_tag_no' value='<%=RFID_Tag_No%>' size='15' maxlength='15'>
	</td>
	<td  width="20%"  class="LABEL" ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
        <td  width="30%"  class='fields'><select name="search_criteria" id="search_criteria">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
        <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
        <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
     </select>
    </td>
	</tr>	
	</table>
	<br>
	<table cellpadding="0" cellspacing="0" border="0" width="14.0%" align="right">
	<tr>
	<td class='white'><input type="Button" name="search" id="search" value = '<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="BUTTON" onClick="getRFIDDetails();"><input type="Button" name="clear" id="clear" value = '<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class="BUTTON" onclick="clearResultContent();"></td>

	</tr>
	</table>	
	<input type="Hidden" name="RFID_Tag_No" id="RFID_Tag_No" value="<%=RFID_Tag_No%>">
	<input type="Hidden" name="where_condition" id="where_condition" value="<%=where_condition%>">
	<input type="Hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	</form>
	</body>
<%
	 
	}
	catch(Exception e)
	{
		e.printStackTrace();
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

