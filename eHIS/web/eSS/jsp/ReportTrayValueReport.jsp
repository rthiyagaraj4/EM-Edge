<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%><%@ page contentType="text/html;charset=UTF-8"  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*, eSS.Common.*,java.sql.*,java.text.*,webbeans.eCommon.*" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<jsp:useBean id="bean" scope="page" class="eSS.ReportsMasterCodeBean"/>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
String locale= (String)session.getAttribute("LOCALE");

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script>
 -->		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<!-- 	<script language="javascript" src="../../eSS/js/SsMessages.js"></script>
 -->		<script language="javascript" src="../../eSS/js/TrayValueReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String bean_id = "reportsMasterCodeBean" ;
		String bean_name = "eSS.ReportsMasterCodeBean";
//		String p_report_id = null;
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
	//	ReportsMasterCodeBean bean = (ReportsMasterCodeBean) mh.getBeanObject( bean_id, request,  bean_name);
		//ReportsMasterCodeBean bean = (ReportsMasterCodeBean) getBeanObject( bean_id, bean_name,  request);	
		bean.clear();
		bean.setFunctionId(request.getParameter("function_id"));
	
	%>
	<body onLoad="FocusFirstElement();"onMouseDown='CodeArrest();'>
		<form name="formReportTrayValue" id="formReportTrayValue" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="80%" align="center" border="0">
				<th align="left" colspan="4" ><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right" >&nbsp;</td>
					<td align="right" >&nbsp;</td>
				</tr>
				<tr>
					<td class='LABEL' align='right'><fmt:message key="eSS.TrayStatus.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;&nbsp;<select name="p_tray_status" id="p_tray_status">
						<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value="U">Unsterilized</option>
						<option value="S">Sterilized</option>
						<option value="R">At Service Location</option>
					</select></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right" >&nbsp;</td>
					<td align="right" >&nbsp;</td>
				</tr>
				</tr>
					<tr>
					<td align="right">&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td align="right" class="label" nowrap><fmt:message key="Common.Group.label" bundle="${common_labels}"/> </td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="P_fm_group_code" id="P_fm_group_code" value="" ><input class="button" onClick="return searchGroup(P_fm_group_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="P_to_group_code" id="P_to_group_code" value="" ><input class="button" onClick="return searchGroup(P_to_group_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label" nowrap><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="P_fm_owner_store_code" id="P_fm_owner_store_code" value="" ><input   class="button" onClick="return searchCodeStoreMaster(P_fm_owner_store_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="P_to_owner_store_code" id="P_to_owner_store_code" value="" ><input   class="button" onClick="return searchCodeStoreMaster(P_to_owner_store_code);" type="button" value="?"></td>
				</tr>

				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label" nowrap><fmt:message key="eSS.CurrentStore.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="P_fm_curr_store_code" id="P_fm_curr_store_code" value="" ><input class="button" onClick="return searchCodeStoreMaster(P_fm_curr_store_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="P_to_curr_store_code" id="P_to_curr_store_code" value="" ><input class="button" onClick="return searchCodeStoreMaster(P_to_curr_store_code);" type="button" value="?"></td>
				</tr>

				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label" nowrap><fmt:message key="eSS.SurgeryType.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=8 size=8 name="P_fm_surgery_type" id="P_fm_surgery_type" value="" ><input class="button" onClick="return searchCodeSurgery(P_fm_surgery_type);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=8 size=8 name="P_to_surgery_type" id="P_to_surgery_type" value="" ><input class="button" onClick="return searchCodeSurgery(P_to_surgery_type);" type="button" value="?"></td>
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
			<input type="hidden" name="p_module_id" id="p_module_id" value="SS">
			<input type="hidden" name="p_report_id" id="p_report_id" value="SSBTRYVL">
			<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP" id="SQL_SS_GROUP_LOOKUP" value="<%=bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_FOR_REPORT")%>">
			<input type="hidden" name="SQL_SS_STORE_LOOKUP" id="SQL_SS_STORE_LOOKUP" value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_LOOKUP")%>">
			<input type="hidden" name="SQL_SS_SURGERY_TYPE_LOOKUP" id="SQL_SS_SURGERY_TYPE_LOOKUP" value="<%=bean.getSsRepositoryValue("SQL_SS_SURGERY_TYPE_LOOKUP")%>">

			</form>
	</body>
</html>	

