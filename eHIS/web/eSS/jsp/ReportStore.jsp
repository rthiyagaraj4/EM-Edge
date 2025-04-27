<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>
<%@page contentType="text/html;charset=UTF-8"  import="java.util.*, eSS.*, eSS.Common.* , eCommon.Common.*,eSS.ReportsMasterCodeBean" %>
<!--<%@ page import="eSS.ReportsMasterCodeBean" %> -->
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
String locale= (String)session.getAttribute("LOCALE");

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>-->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<!-- 	<script language="javascript" src="../../eSS/js/SsMessages.js"></script> -->
		<script language="javascript" src="../../eSS/js/MasterCodeList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id = "reportsMasterCodeBean";
		String bean_name = "eSS.ReportsMasterCodeBean";
//		String p_report_id = null;
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
	//	ReportsMasterCodeBean bean = (ReportsMasterCodeBean) mh.getBeanObject( bean_id, request,  bean_name);
		ReportsMasterCodeBean bean = (ReportsMasterCodeBean) getBeanObject( bean_id, bean_name, request );	
		bean.clear();
		
		
	%>
	<body onLoad="FocusFirstElement();" onMouseDown='CodeArrest();'>
		<form name="formReportStore" id="formReportStore" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="70%" align="center" border="0">
				<th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
					<td align="right">&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_store_code" id="p_fm_store_code" value=""  ><input class="button" onClick="return searchCodeStore(p_fm_store_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_store_code" id="p_to_store_code" value=""  ><input class="button" onClick="return searchCodeStore(p_to_store_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.department.label" bundle="${common_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_dept_code" id="p_fm_dept_code" value=""  ><input class="button" onClick="return searchCodeDeptForFacility(p_fm_dept_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_dept_code" id="p_to_dept_code" value=""  ><input class="button" onClick="return searchCodeDeptForFacility(p_to_dept_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label" ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
					<td class=label >&nbsp;&nbsp;<select name="p_nature" id="p_nature" >
					<%=bean.getNature()%>
					</select></td>
					<td align="right" class="label" ><fmt:message key="eSS.StoreType.label" bundle="${ss_labels}"/></td>
					<td class=label >&nbsp;&nbsp;<select name="p_store_type" id="p_store_type" >
					<%=bean.getStoreType()%>
					</select></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label" ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<td class=label colspan='3'>&nbsp;&nbsp;<select name="p_order_by" id="p_order_by" >
					<%=bean.getOrderByStore()%>
					</select></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label" ><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td class=label colspan='3'>&nbsp;&nbsp;<select name="p_report_type" id="p_report_type" >
					<%=bean.getReportType()%>
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
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="SS">
			<input type="hidden" name="p_report_id" id="p_report_id" 		value="SSBSTORE">
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">


			
			<input type="hidden" name="SQL_SS_STORE_LOOKUP" id="SQL_SS_STORE_LOOKUP" value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_LOOKUP")%>">
			<input type="hidden" name="SQL_SS_DEPT_LOOKUP" id="SQL_SS_DEPT_LOOKUP" value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_DEPT_FACILITY_LOOKUP")%>">
		</form>
	</body>
</html>

