
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
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale		=		(String)session.getAttribute("LOCALE");
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eSS/js/TrayDiscrepancyReport.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="FocusFirstElement();" onMouseDown="CodeArrest()">
<%
	
		String mode;
		String bean_id;
		String bean_name;
		
		mode				=	request.getParameter( "mode" ) ;
		bean_id				=	"TrayLabelBean" ;
		bean_name			=	"eSS.TrayLabelBean";

		if ((mode == null) || (mode.equals(""))) 
			return ;
		if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
			return ;
		TrayLabelBean bean	=	(TrayLabelBean) getBeanObject( bean_id,bean_name,request);
		bean.clear() ;
		bean.setMode( mode ) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
%>
		
<form name="formTrayDiscrepancyReport" id="formTrayDiscrepancyReport" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'  height='100%'>
	<tr>
	<td width='100%' align='center'  class="WHITE">
	<table border="0" cellpadding="1" cellspacing="0" width='75%' align='center'>
	<th align="left" colspan="4" ><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td class='LABEL' ><fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<select name="p_report_option" id="p_report_option">
			<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value="Y"><fmt:message key="eSS.Returnable.label" bundle="${ss_labels}"/></option>
			<option value="N"><fmt:message key="eSS.Nonreturnable.label" bundle="${ss_labels}"/></option>
		</select></td>
		<td>&nbsp;</td>
	</tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td>&nbsp;</td>
		<td class='LABEL'>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class='LABEL'>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	</tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td class='LABEL' align='right'><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='10' size='10' name="from_group_code" id="from_group_code"><input type='button' class='BUTTON' value="?" onClick="searchGroup(from_group_code)"></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='10' size='10' name="to_group_code" id="to_group_code"><input type='button' class='BUTTON' value="?" onClick="searchGroup(to_group_code)"></td>
	</tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td class='LABEL' align='right'><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='6' size='6' name="from_store_code" id="from_store_code"><input type='button' class='BUTTON' value="?" onClick="searchStore(from_store_code)"></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='6' size='6' name="to_store_code" id="to_store_code"><input type='button' class='BUTTON' value="?" onClick="searchStore(to_store_code)"></td>
	</tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td class='LABEL' align='right'>Tray No</td>
		<td>&nbsp;<input class="NUMBER" onKeyPress="return isValidInteger(event);" onBlur="checkIntegerFormat(this);" type='text' maxLength='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' size='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' onblur="checkIntegerFormat(this)" name="from_tray_no" ></td>
		<td>&nbsp;<input class="NUMBER" onKeyPress="return isValidInteger(event);" onBlur="checkIntegerFormat(this);" type='text' maxLength='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' size='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' onblur="checkIntegerFormat(this)"  name="to_tray_no"></td>
	</tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td class='LABEL' align='right'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<select name="report_criteria" id="report_criteria">
			<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value="U"><fmt:message key="eSS.AtUnits.label" bundle="${ss_labels}"/></option>
			<option value="O"><fmt:message key="eSS.AtOwner.label" bundle="${ss_labels}"/></option>
			<option value="R"><fmt:message key="eSS.AtServiceLocation.label" bundle="${ss_labels}"/></option>
		</select></td>
		<td>&nbsp;</td>
	</tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	</table>
	</td>
	</tr>
	</table>
	
	<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id"				value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="p_module_id" id="p_module_id" 			value="SS">
	<input type="hidden" name="p_report_id" id="p_report_id" 			value="SSBTRDIS">
	<input type="hidden" name="p_user_name" id="p_user_name"				value="<%=bean.getLoginById()%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"			value="<%=bean.getLoginFacilityId()%>">
	<input type="hidden" name="locale" id="locale"					value="<%=locale%>">
	<input type="hidden" name="SQL_SS_GROUP_LOOKUP" id="SQL_SS_GROUP_LOOKUP"		value="<%=bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_FOR_REPORT")%>">
	<input type="hidden" name="SQL_SS_STORE_LOOKUP" id="SQL_SS_STORE_LOOKUP"		value="<%=bean.getSsRepositoryValue("SQL_SS_STORE_LOOKUP")%>">
</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

