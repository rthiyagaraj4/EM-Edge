<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<!-- <script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/SRRMasterCodeList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id = "reportsMasterCodeBean";
		String bean_name = "eST.ReportsMasterCodeBean";
	//	String p_report_id = null;
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
		ReportsMasterCodeBean bean = (ReportsMasterCodeBean) getBeanObject( bean_id,  bean_name ,request );  
		bean.clear();
		bean.setLanguageId(locale);
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formDirectSalesPatient" id="formDirectSalesPatient" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="70%" align="center" border="0">
				<th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
					<td align="right">&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td  class="fields">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=15 name="patient_idfr" id="patient_idfr" value=""><input class="button" onClick="return callPatientSearchFrom();" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=15 name="patient_idto" id="patient_idto" value=""  ><input class="button" onClick="return callPatientSearch();" type="button" value="?"></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
					<td class="label" ><fmt:message key="Common.Nature.label" bundle="${mm_labels}"/></td>
					<td class="fields" >&nbsp;&nbsp;<select name="p_nature" id="p_nature" >
					<option value ='B'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
					<option  value='D'><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></option>
					<option  value='E'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></option>
					</select></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
											
				<tr>
					<td class="label" ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<td class=fields colspan='3'>&nbsp;&nbsp;<select name="p_order_by" id="p_order_by" >
					<option value='1'><fmt:message key="Common.StoreCode.label" bundle="${mm_labels}"/></option>
					<option  value='2'><fmt:message key="Common.StoreDescription.label" bundle="${common_labels}"/></option>
					<option  value='3'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></option>
					<option  value='4'><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></option>
					</select></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				</table>
				</td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id" 		value="STBITSTR">
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
			
		</form>
		<input type="hidden" name="SQL_ST_STORE_LOOKUP_FOR_REPORT" id="SQL_ST_STORE_LOOKUP_FOR_REPORT" value="
		<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>"> 
		<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" 
		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

