<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*, eSS.Common.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>  
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
		String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale		=	(String)session.getAttribute("LOCALE");
		request.setCharacterEncoding("UTF-8");

%>


	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eSS/js/AutoclaveLoadSummaryReport.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="FocusFirstElement();"onMouseDown='CodeArrest();'> 
<%
		ReportAutoclaveLoadSummaryBean bean		=		(ReportAutoclaveLoadSummaryBean) getBeanObject( "reportAutoclaveLoadSummaryBean","eSS.ReportAutoclaveLoadSummaryBean" , request );
		bean.clear() ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
%>
		
<form name="formAutoclaveLoadSummaryReport" id="formAutoclaveLoadSummaryReport" onReset="FocusFirstElement();" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame">
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'  height='100%'>
	<tr>
	<td width='100%' align='center'  class="WHITE">
	<table border="0" cellpadding="1" cellspacing="0" width='75%' align='center'>
	<tr><th colspan='3' align='left'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th></tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td>&nbsp;</td>
		<td class='LABEL'>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class='LABEL'>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td class='LABEL' align='right'><fmt:message key="eSS.AutoclaveUnit.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<input maxLength='8' size='8' name="p_fr_autoclave_unit" id="p_fr_autoclave_unit"><input type='button' class='BUTTON' value="?" onClick="searchAutoclaveUnit(p_fr_autoclave_unit)"></td>
		<td>&nbsp;<input type='text' maxLength='8' size='8' name="p_to_autoclave_unit" id="p_to_autoclave_unit"><input type='button' class='BUTTON' value="?" onClick="searchAutoclaveUnit(p_to_autoclave_unit)"></td>
	</tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td class='LABEL' align='right'><fmt:message key="eSS.SterilizationType.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<input maxLength='4' size='4' name="p_fr_sterile_type" id="p_fr_sterile_type"><input type='button' class='BUTTON' value="?" onClick="searchSterileType(p_fr_sterile_type)"></td>
		<td>&nbsp;<input maxLength='4' size='4' name="p_to_sterile_type" id="p_to_sterile_type"><input type='button' class='BUTTON' value="?" onClick="searchSterileType(p_to_sterile_type)"></td>
	</tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td class='LABEL' align='right'><fmt:message key="eSS.LoadNo.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<input class="NUMBER" onKeyPress="return isValidInteger(event);" onBlur="checkIntegerFormat(this);" type='text' maxLength='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' size='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' name="p_fr_load_no"></td>
		<td>&nbsp;<input class="NUMBER" onKeyPress="return isValidInteger(event);" onBlur="checkIntegerFormat(this);" type='text' maxLength='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' size='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' name="p_to_load_no"></td>
	</tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td class='LABEL' align='right'><fmt:message key="eSS.AutoclavedDate.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<input onBlur="CheckDate(this,'<%=locale%>');"  type='text' maxLength='10' size='10' name="p_fr_autoclave_date1" id="p_fr_autoclave_date1">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fr_autoclave_date1');"></img></td>
		<td>&nbsp;<input onBlur="CheckDate(this,'<%=locale%>');"  type='text' maxLength='10' size='10' name="p_to_autoclave_date1" id="p_to_autoclave_date1">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_autoclave_date1');"></img></td>
	</tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td align="right" class="label"><fmt:message key="eSS.Finalized.label" bundle="${ss_labels}"/></td>
		<td class="label">&nbsp;<select name="p_finalized_yn" id="p_finalized_yn"  ><%=bean.getVals()%></select></td><td colspan=2>&nbsp;</td>
	</tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td class="label">&nbsp;<select name="p_load_status" id="p_load_status"  ><%=bean.getStatus()%></select></td><td colspan=2>&nbsp;</td>
	</tr>	
	<tr><td colspan='3'>&nbsp;</td></tr>

	</table>
	</td>
	</tr>
	</table>
	<input type="hidden" name="function_id" id="function_id"							value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="p_module_id" id="p_module_id" 						value="SS">
	<input type="hidden" name="p_report_id" id="p_report_id" 						value="SSBACLSM">
	<input type="hidden" name="p_fr_autoclave_date" id="p_fr_autoclave_date" 				value="">
	<input type="hidden" name="p_to_autoclave_date" id="p_to_autoclave_date" 				value="">
	<input type="hidden" name="p_user_name" id="p_user_name"							value="<%=bean.getLoginById()%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"						value="<%=bean.getLoginFacilityId()%>">
	<input type="hidden" name="locale" id="locale"								value="<%=locale%>">
	<input type="hidden" name="SQL_SS_STERILIZATION_TYPE_LOOKUP" id="SQL_SS_STERILIZATION_TYPE_LOOKUP"	value="<%=bean.getSsRepositoryValue("SQL_SS_STERILIZATION_TYPE_LOOKUP")%>">
	<input type="hidden" name="SQL_SS_AUTOCLAVE_WASH_UNIT_LOOKUP" id="SQL_SS_AUTOCLAVE_WASH_UNIT_LOOKUP"	value="<%=bean.getSsRepositoryValue("SQL_SS_AUTOCLAVE_WASH_UNIT_LOOKUP")%>">
</form>
<%
	putObjectInBean("reportAutoclaveLoadSummaryBean",bean,request);
%>
</body>
</html>

