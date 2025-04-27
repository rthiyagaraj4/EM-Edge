<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
 10/16/2023   32902      Twinkle Shah    	    Ramesh Goli      MMS-DM-CRF-0210
--------------------------------------------------------------------------------------------------------
*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*" %>

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src='../../eCA/js/CAAccessRightsForViewRestrictPatient.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
	
	 function enable_txt(obj){
		if(obj.value!='00')		        
		  document.forms[0].search_txt.disabled=false;		 		
		else
		{
			document.forms[0].search_txt.disabled=true;
			document.forms[0].search_txt.value="";
		}
	}
	
 	function call(){
		var error=getMessage("WELCOME","common");
		alert(error);
	}	
</script>
<%
	request.setCharacterEncoding("UTF-8");
%>
</head>
	<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
		<form name='CAAccessRightsForViewRestrictPatForm' id='CAAccessRightsForViewRestrictPatForm' method='post' target='messageFrame'>
			<br>
			<table border='0' cellpadding='0' cellspacing='0' align='center' width='85%' >
				<tr>
					<td colspan='1' width="20%"></td>
					<td colspan='1' width="30%"></td>
					<td colspan='1' width="15%"></td>
					<td colspan='1' width="20%"></td>
				</tr>
				<tr>
					<td colspan='4' >&nbsp;</td>
				</tr>
    			<tr>
    				<td   class='label'><fmt:message key="eCA.PatientStatus.label" bundle="${ca_labels}"/></td>
    				<td  align='left' >&nbsp;
    				<input type="text" name="patientStatus" size=12 id="patientStatus" value="Restricted" disabled>
				</tr>
				<tr>
					<td colspan='8'>&nbsp;</td>
				</tr>
				<tr>
					<td class='label'  id = lab1  ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
					<td  colspan=2 class='fields' >&nbsp;
						<SELECT name="search_by"  id="search_by" onchange="enable_txt(this)">
							<option value="00">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
							<option value="01"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></option>
							<option value="02"><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></option>
						</SELECT>&nbsp;&nbsp;
						<INPUT TYPE="text" name="search_txt" id="search_txt"  disabled size=15 maxlength=15 value="">
					</td>	
    				<td nowrap align='center'>&nbsp;<input type='button' name='Search' id='Search'  value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='searchClick()'></td>
   				</tr>
			</table>	
</form>
</body>
</html>

