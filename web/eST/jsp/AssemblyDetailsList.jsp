<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eST.*, eST.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->		
 <%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		 <script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/MasterCodeList.js"></script>
		<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id = "reportsMasterCodeBean";
		String bean_name = "eST.ReportsMasterCodeBean";
		//String p_report_id = null;
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
		ReportsMasterCodeBean bean = (ReportsMasterCodeBean) getBeanObject( bean_id,bean_name,request);  
		bean.clear();
		bean.setLanguageId(locale);
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formAssemblyDetails" id="formAssemblyDetails" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%'  align=center>
			<tr>
			<td width='100%'  class="WHITE">
				<table cellpadding="0" cellspacing="0" width="70%"  border="0" align=center>
				<th colspan=4 align=left ><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
					<td >&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td  >&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="eST.AssemblyItemCode.label" bundle="${st_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value=""  ><input class="button" onClick="return searchAssemblyCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class="label"></td>
					<td class=fields>&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value=""  ><input class="button" onClick="return searchAssemblyCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
				</tr>
				<tr>
					<td  class="label" ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td><!-- Modified for IN:074037  -->
					<td class=fields colspan='3'>&nbsp;&nbsp;<select name="p_nature" id="p_nature" >
					<option value='B'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
					<option value='E'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></option>
					<option value='D'><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></option>
					</select></td>
				</tr>
				<tr>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
				</tr>
				<tr>
					<td  class="label" ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<td class=fields colspan='3'>&nbsp;&nbsp;<select name="p_order_by" id="p_order_by" >
					<option  value='1'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></option>
					<option  value='2'><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></option>
					</select></td>
				</tr>
				<tr>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
				</tr>
				</table>
				</td>
				</tr>
				</table>
				</td>
				</tr>
				
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id" 		value="STBASMDT">
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
			
		</form>
		<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
		<input type="hidden" name="SQL_ST_ASSEMBLY_ITEM_LOOKUP" id="SQL_ST_ASSEMBLY_ITEM_LOOKUP" value=
		"<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ASSEMBLY_ITEM_LOOKUP")%>"> 
		<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

