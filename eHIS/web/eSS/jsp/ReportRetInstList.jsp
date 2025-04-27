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
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="eSS.ReportsMasterCodeBean" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	String locale= (String)session.getAttribute("LOCALE");

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/ReturnInstrumentsList.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		
		String bean_id			= "reportsMasterCodeBean" ;
		String bean_name		= "eSS.ReportsMasterCodeBean";
//		String p_report_id		= null;
		String facility_id		=  (String) session.getValue( "facility_id" ) ;
		String user_name		=  (String) session.getValue( "login_user" ) ;
		
//		ReportsMasterCodeBean bean = (ReportsMasterCodeBean) mh.getBeanObject( bean_id, request,  bean_name);
		ReportsMasterCodeBean bean = (ReportsMasterCodeBean) getBeanObject( bean_id, bean_name, request );	
		bean.clear();
		bean.setFunctionId(request.getParameter("function_id"));
	
	%>
	<body onLoad="FocusFirstElement();"onMouseDown='CodeArrest();'>
		<form name="formReportRetInstList" id="formReportRetInstList" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br><br><br><br><br><br>
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
				</tr>
					<tr>
					<td align="right">&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td align="left" class="label" nowrap><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_from_doc_type" id="p_from_doc_type" value="" class="UPPER" ><input class="button" onClick="return searchCodeDocumentType(p_from_doc_type);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_doc_type" id="p_to_doc_type" value="" class="UPPER"><input class="button" onClick="return searchCodeDocumentType(p_to_doc_type);" type="button" value="?"></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
					<td align="left" class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input class="NUMBER"  maxLength=8 size=8 name="P_from_doc_no" id="P_from_doc_no" value="" onkeypress="return isValidNumber(this,event,<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>,0);" onblur="checkIntegerFormat(this)" ></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input class="NUMBER"   maxLength=8 size=8 name="P_to_doc_no" id="P_to_doc_no" value=""  onkeypress="return isValidNumber(this,event,<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>,0);" onblur="checkIntegerFormat(this)" ></td>
				</tr>

				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
					<td align="left" class="label" nowrap><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_from_doc_date1" id="p_from_doc_date1" value="" onBlur="CheckDate(this,'<%=locale%>');">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_from_doc_date1');"></img>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_to_doc_date1" id="p_to_doc_date1" value="" onBlur="CheckDate(this,'<%=locale%>');">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_doc_date1');"></img></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
					<td align="left" class="label" nowrap><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_from_req_store" id="p_from_req_store" value="" ><input class="button" onClick="return searchCodeRequestBy(p_from_req_store);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_req_store" id="p_to_req_store" value="" ><input class="button" onClick="return searchCodeRequestBy(p_to_req_store);" type="button" value="?"></td>
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
			<input type="hidden" name="bean_id" id="bean_id"									value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"								value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id"								value="SS">
			<input type="hidden" name="p_report_id" id="p_report_id"								value="SSBRTIPT">
			<input type="hidden" name="p_from_doc_date" id="p_from_doc_date"							value="">
			<input type="hidden" name="p_to_doc_date" id="p_to_doc_date"							value="">
			<input type="hidden" name="p_user_name" id="p_user_name"								value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"							value="<%=facility_id%>">
			<input type="hidden" name="locale" id="locale"									value="<%=locale%>">
			<input type="hidden" name="SQL_SS_STORE_REQ_SELECT_LIST_LOOKUP" id="SQL_SS_STORE_REQ_SELECT_LIST_LOOKUP"		value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_REQ_SELECT_LIST_LOOKUP")%>">
			<input type="hidden" name="SQL_SS_DOC_TYPE_RTI_LIST_LOOKUP" id="SQL_SS_DOC_TYPE_RTI_LIST_LOOKUP"			value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_DOC_TYPE_RTI_LIST_LOOKUP")%>">
<%
putObjectInBean(bean_id,bean,request); 
%>
			</form>
	</body>
</html>	

