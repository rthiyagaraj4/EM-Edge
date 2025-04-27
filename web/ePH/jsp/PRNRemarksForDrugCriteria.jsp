<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>

<%@page contentType="text/html;charset=UTF-8"
	import="java.util.*,ePH.*,ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
<%
	String locale = "";
request.setCharacterEncoding("UTF-8");
//Added for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	locale = (String) session.getAttribute("LOCALE");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";

	

	String bean_id							= "PRNRemarksForDrug" ;
	String bean_name						= "ePH.PRNRemarksForDrugBean";

	String mode								= "";
	String sql_drug_lookup					= "SELECT DRUG_CODE CODE, DRUG_DESC DESCRIPTION FROM PH_DRUG_LANG_VW PH_DRUG WHERE UPPER(DISCONTINUED_YN)='N' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?)  AND LANGUAGE_ID = #";
	
	PRNRemarksForDrugBean bean				= (PRNRemarksForDrugBean)getBeanObject( bean_id, bean_name, request ) ;
	mode									= request.getParameter("mode");	
	
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
<script language="javascript" src="../js/PhCommon.js"></script>
<script language="JavaScript" src="../js/PRNRemarksForDrug.js"></script>
<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%%>
<body onKeyDown="lockKey()" topmargin="0">
<form name="PRNRemarksForDrugCriteria" id="PRNRemarksForDrugCriteria">
<table cellpadding="0" cellspacing="0" width="100%" align="center" 	border="0">
	<tr>
		<td  class="label"><fmt:message key="Common.Drug.label" bundle="${common_labels}" /></td>
		<td align="left" class="label">
			<input type="text" name="drugSearch" id="drugSearch" maxlength="60" size="40" onKeyPress="return CheckForSpecChars(event)" value="">
			<input type="button" class="button"	value="?" name="DrugSearch_lookup" id="DrugSearch_lookup" 	onClick="searchDrug(document.PRNRemarksForDrugCriteria.drugSearch)">
			<img src="../../eCommon/images/mandatory.gif" align="center"> <input type="hidden" name="drug_code" id="drug_code" value="">
		</td>
  </tr>	
   <tr>
		<td  class="label"><fmt:message key="Common.searchtext.label" bundle="${common_labels}" /></td> 
		<td align="left" class="label">
			<input type="text" name="PRNSearchText" id="PRNSearchText" maxlength="60" size="40" onKeyPress="" value="" /> &nbsp;&nbsp;&nbsp;&nbsp;
		    <fmt:message key="Common.searchby.label" bundle="${common_labels}" />&nbsp;&nbsp;&nbsp;&nbsp;
			<select name="PRNSearchBy" id="PRNSearchBy" >
				<option value ="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>	
				<option value ="C" ><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>	
				<option value ="E" ><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>		
			</select>
		</td>
		<td>
		<input type="button" class="button"	value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' name="Search" id="Search" onClick="searchPRNRemarksForDrug()">
		</td>
  </tr>	
  <tr>
		
  </tr>	

</table>
	   <input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
	     <input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>"> 
	   <input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	   <input type="hidden" name="sql_drug_lookup" id="sql_drug_lookup" value="<%=sql_drug_lookup%>">
	   <input type="hidden" name="mode" id="mode" value="<%=mode%>">
</form>
<script>
document.forms[0].drugSearch.focus();</script><!-- /**
 * @Name - Sandhya A 
 * @Date - 18/12/2009
 * @Inc# - IN016185 (online help)
 * @Desc - set focus to the drug search text.
 */ -->
</body>
</html>
<%

	putObjectInBean(bean_id, bean, request);
%>



