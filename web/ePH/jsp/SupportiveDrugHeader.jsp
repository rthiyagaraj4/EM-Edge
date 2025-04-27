<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		     Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
05/10/2011        		          Chandra Shekar a  26/07/2019                              TH-KW-CRF-0008
--------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.DrugMasterBean, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<%	
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	


	String locale			= (String)session.getAttribute("LOCALE");
	String bean_id		= "DrugMasterBean" ;
	String bean_name	= "ePH.DrugMasterBean";
	String mode			= request.getParameter("mode");
	String main_drug_code = request.getParameter("parent_drug_code");//Added for ICN-37519
	DrugMasterBean bean = (DrugMasterBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
%>
<html>
<head>
<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>


<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
<script language="javascript" src="../../ePH/js/DrugMaster.js"></script>
<script language="javascript" src="../../ePH/js/DrugMasterDetail.js"></script>
<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
<script language="JavaScript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>


<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='supportdrugsheader' id='supportdrugsheader'>
			<table border="0" align="left" width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr >
				      <td width="20%">&nbsp;</td>
					<td class="label"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
					<td colspan="5">&nbsp;&nbsp;<input type="text" name="drug_name" id="drug_name" maxlength="60" size="60"><input type="button" class="button" value="?" name="drug_name_search" id="drug_name_search"  onclick="searchDrugName()">
					<input type="hidden" name="drug_code" id="drug_code" value="">
					</td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
			</table>
			<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>"> 
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="main_drug_code" id="main_drug_code" value="<%=main_drug_code%>"><!-- Added for ICN-37519 -->
		<script>
				parent.parent.updateCurrentForm("support_drugs_tab","f_tab_detail.f_query_add_mod.document.supportdrugsheader","drugMasterMain.document.drugMasterMainForm");
        </script>
		</form>
	</body>
</html>

