<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
		<%
		request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
	("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

		<script language="JavaScript" src="../js/DrugDrugType.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='drugbydrugtypeheaderform' id='drugbydrugtypeheaderform'>
			<table border="0" align="left" width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr >
					<td  width="20%" align="right" class='label'><fmt:message key="Common.Drug.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td  width="80%"><input type='text' name='drug_desc' id='drug_desc' value='' size='60' maxlength='60'><input type="button" name="drug_search" id="drug_search" value="?" class="button" onClick="drugSearch(drug_desc,drug_code, this);">&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
					<input type='hidden' value='' name='drug_code' id='drug_code'>
					</td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
			</table>
		</form>
	</body>
</html>

