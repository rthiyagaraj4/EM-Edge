<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.* ,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu 
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String mode= request.getParameter("mode");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../js/DrugSynonym.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<Script language='JavaScript' src='../../eCommon/js/CommonLookup.js'></Script>
		<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<BODY onKeyDown = 'lockKey()' > 
		<form name='frmDrugSynonymQueryCriteria' id='frmDrugSynonymQueryCriteria'>
			<BR><BR><BR>
			<table cellpadding=0 cellspacing=0 width="70%" align="center" border="0" align='center'>
				<tr>
					<td class='label' width='70%' style="text-align:right;" nowrap><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type='Text' name='DrugName' id='DrugName' value='' size='60'>&nbsp;<input type="button" name="btnDrugSearch" id="btnDrugSearch" value="?" class="button"  onClick="searchDrugName();" onFocus="searchDrugName();">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
					<input type='hidden' value='' name='DrugCode' id='DrugCode'>
					<td class='label' ><input type='button' name='btnSearch' id='btnSearch' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="searchDrugSynonyms();" ></td>
				</tr>
			</table>
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
			<input type='hidden' name='DrugSynonymType' id='DrugSynonymType' value='OT'>
			<BR><BR><BR>
		</form>
	</body>
</html>

