<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@page  import="java.sql.*,java.util.*,webbeans.eCommon.*, eSS.Common.* "contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="bean" scope="page" class="eSS.ReportsMasterCodeBean"/>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->

<%
	String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	String locale		=	(String)session.getAttribute("LOCALE");

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eSS/js/PackingCheckList.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown='CodeArrest();'> 
<%
	
			
		String bean_id				=		"";
		String bean_name			=		"";
		bean_id						=		"reportsMasterCodeBean" ;
		bean_name					=		"eSS.ReportsMasterCodeBean";
		
//		ReportsMasterCodeBean bean  =		(ReportsMasterCodeBean) getBeanObject( bean_id, bean_name, request  );
		bean.clear() ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
%>
		
<form name="formPackingCheckReport" id="formPackingCheckReport" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'  height='100%'>
	<tr>
	<td width='100%' align='center'  class="WHITE">
	<table border="0" cellpadding="1" cellspacing="0" width='75%' align='center'>
	<th align="left" colspan="4" ><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td>&nbsp;</td>
		<td class='LABEL'>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class='LABEL'>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	</tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td align="right" class="label" nowrap><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_from_doc_type" id="p_from_doc_type" value="" ><input class="button" onClick="return searchCodeDocumentType(p_from_doc_type);" type="button" value="?"></td>
		<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_doc_type" id="p_to_doc_type" value="" ><input class="button" onClick="return searchCodeDocumentType(p_to_doc_type);" type="button" value="?"></td>
	</tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td align="right" class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
		<td class=label>&nbsp;&nbsp;<input class="NUMBER"  maxLength=8 size=8 name="P_from_doc_no" id="P_from_doc_no" value="" onkeypress="return isValidNumber(this,event,<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>,0);" onblur="checkIntegerFormat(this)" ></td>
		<td class=label>&nbsp;&nbsp;<input class="NUMBER"   maxLength=8 size=8 name="P_to_doc_no" id="P_to_doc_no" value=""  onkeypress="return isValidNumber(this,event,<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>,0);"  onblur="checkIntegerFormat(this)"></td>
	</tr>
	<tr><td colspan='3'>&nbsp;</td></tr>



	<tr>
		<td class='label' align='right'><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
		<td class=label>&nbsp;&nbsp;<input onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='10' size='10' name="p_from_group_code" id="p_from_group_code"><input type='button' class='BUTTON' value="?" onClick="searchGroup(p_from_group_code)"></td>
		<td class=label>&nbsp;&nbsp;<input onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='10' size='10' name="p_to_group_code" id="p_to_group_code"><input type='button' class='BUTTON' value="?" onClick="searchGroup(p_to_group_code)"></td>
	</tr>


	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td align="right" class="label"><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></td>
		<td class=label>&nbsp;&nbsp;<input class="NUMBER" maxLength=12 size=12 name="P_from_tray_no" id="P_from_tray_no" value="" onkeypress="return isValidNumber(this,event,<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>,0);" onblur="checkIntegerFormat(this)"></td>
		<td class=label>&nbsp;&nbsp;<input class="NUMBER" maxLength=12 size=12 name="P_to_tray_no" id="P_to_tray_no" value=""  onkeypress="return isValidNumber(this,event,<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>,0);" onblur="checkIntegerFormat(this)" ></td>
	</tr>
	
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td align="right" class="label"><fmt:message key="eSS.PackingDate.label" bundle="${ss_labels}"/></td>
		<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_from_packing_date1" id="p_from_packing_date1" value="" onBlur="CheckDate(this,'<%=locale%>');" >
		&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_from_packing_date1');"></img></td>
		<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_to_packing_date1" id="p_to_packing_date1" value="" onBlur="CheckDate(this,'<%=locale%>');">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_packing_date1');"></img></td>
	</tr>
	
	<tr><td colspan='3'>&nbsp;</td></tr>
	</table>
	</td>
	</tr>
	</table>
	
	<input type="hidden" name="bean_id" id="bean_id"								value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"							value="<%= bean_name %>">
	<input type="hidden" name="lang_id" id="lang_id"								value="<%= locale %>">
	<input type="hidden" name="p_from_packing_date" id="p_from_packing_date"					value="">
	<input type="hidden" name="p_to_packing_date" id="p_to_packing_date"					value="">
	<input type="hidden" name="function_id" id="function_id"							value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="p_module_id" id="p_module_id" 						value="SS">
	<input type="hidden" name="p_report_id" id="p_report_id" 						value="SSBPKCHK">
	<input type="hidden" name="p_user_name" id="p_user_name"							value="<%=bean.getLoginById()%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"						value="<%=bean.getLoginFacilityId()%>">
	<input type="hidden" name="locale" id="locale"								value="<%=locale%>">
	<input type="hidden" name="SQL_SS_GROUP_LOOKUP" id="SQL_SS_GROUP_LOOKUP"					value="<%=bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_FOR_REPORT")%>">
	<input type="hidden" name="SQL_SS_DOC_TYPE_ROF_LIST_LOOKUP" id="SQL_SS_DOC_TYPE_ROF_LIST_LOOKUP"		value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_DOC_TYPE_ROF_LIST_LOOKUP")%>">
<%
putObjectInBean(bean_id,bean,request); 
%>
</form>
</body>
</html>

