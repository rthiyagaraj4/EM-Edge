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
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale		=	(String)session.getAttribute("LOCALE");

%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/AutoclavingLoadDtlReport.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id				=		"reportsMasterCodeBean";
		String bean_name			=		"eSS.ReportsMasterCodeBean";
		String facility_id			=		(String) session.getValue( "facility_id" ) ;
		String user_name			=		(String) session.getValue( "login_user" ) ;
		
//		ReportsMasterCodeBean bean	=		(ReportsMasterCodeBean) getBeanObject( bean_id,  bean_name, request);  
		bean.clear();
		
		
	%>

	<body onLoad="FocusFirstElement();"onMouseDown="CodeArrest()">
		<form name="formAutoclavingLoadDtlReportList" id="formAutoclavingLoadDtlReportList" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame">
		<br><br>
		 <table border="0" cellpadding="0" cellspacing="0" width='80%' align='center' title="Report Criteria">
		    
			<tr>
			<td width='80%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="80%" align="center" border="0">
				<tr>
				   <th colspan='6' align='left'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
		        </tr>
				<tr>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
					<tr>
					<td >&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td >&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				
				<tr>
					<td  class="label" nowrap><fmt:message key="eSS.AutoclavingUnit.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=8 size=8          name="p_fm_wash_unit_code" id="p_fm_wash_unit_code" value="" ><input class="button" onClick="return searchAutoclavingUnit(p_fm_wash_unit_code);" type="button" value="?">
					</td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=8 size=8 name="p_to_wash_unit_code" id="p_to_wash_unit_code" value="" ><input class="button" onClick="return searchAutoclavingUnit(p_to_wash_unit_code);" type="button" value="?"></td>
				</tr>


				<tr>
					<td >&nbsp;</td>
					<td>&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
				</tr>
				

				<tr>
					<td class="label" nowrap><fmt:message key="eSS.SterilizationType.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=4 size=4          name="p_fm_steril_type" id="p_fm_steril_type" value="" ><input class="button" onClick="return searchSterilizationType(p_fm_steril_type);" type="button" value="?">
					</td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_steril_type" id="p_to_steril_type" value="" ><input class="button" onClick="return searchSterilizationType(p_to_steril_type);" type="button" value="?"></td>
				</tr>

				<tr>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td>&nbsp;</td>
				</tr>

				<tr>
					<td  class="label"><fmt:message key="eSS.LoadNumber.label" bundle="${ss_labels}"/></td>
					
					<td class=label>&nbsp;&nbsp;<input class="NUMBER"  maxLength=10 size=10 name="p_fm_load_no" id="p_fm_load_no" value="" onkeypress="return isValidNumber(this,event,<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>,0);" onblur="checkIntegerFormat(this)" ></td>
					<td class="label">&nbsp;</td>
					
					<td class=label>&nbsp;&nbsp;<input class="NUMBER"  maxLength=10 size=10 name="p_to_load_no" id="p_to_load_no" value="" onkeypress="return isValidNumber(this,event,<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>,0);" onblur="checkIntegerFormat(this)" ></td>
				
				</tr>

				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>

				<tr>
					<td  class="label"><fmt:message key="eSS.AutoclaveDate.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_fm_auto_date1" id="p_fm_auto_date1" value="" onBlur="CheckDate(this,'<%=locale%>');">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_auto_date1');"></img></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_to_auto_date1" id="p_to_auto_date1" value="" onBlur="CheckDate(this,'<%=locale%>');">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_auto_date1');"></img></td>
				</tr>

				<tr>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
				</tr>
               <tr>
					<td  class="label" nowrap><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6          name="p_fm_store" id="p_fm_store" value="" ><input class="button" onClick="return searchStore(p_fm_store);" type="button" value="?">
					</td>
					<td class="label">&nbsp;</td>

					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_store" id="p_to_store" value=""    ><input class="button" onClick="return searchStore(p_to_store);" type="button" value="?"></td>
                    


				</tr>
				<tr>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
				</tr>

				<tr>
					<td  class="label" ><fmt:message key="eSS.LoadStatus.label" bundle="${ss_labels}"/></td>
					<td class=label colspan='3'>&nbsp;&nbsp;<select name="p_load_status" id="p_load_status" >
					<%=bean.getLoadStatusList()%>
					</select></td>
				</tr>

				<tr>
					<td >&nbsp;</td>
					<td>&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
				</tr>

				</table>
				</td>
			</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id"								value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"							value="<%=bean_name%>">
			<input type="hidden" name="p_fm_auto_date" id="p_fm_auto_date"						value="">
			<input type="hidden" name="p_to_auto_date" id="p_to_auto_date"						value="">
			<input type="hidden" name="p_module_id" id="p_module_id" 						value="SS">
			<input type="hidden" name="p_report_id" id="p_report_id" 						value="SSBAUTLD">
			<input type="hidden" name="p_user_name" id="p_user_name"							value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"						value="<%=facility_id%>">
			<input type="hidden" name="locale" id="locale"								value="<%=locale%>">
            <input type="hidden" name="SQL_SS_AUTOCLAVE_WASH_UNIT_LOOKUP" id="SQL_SS_AUTOCLAVE_WASH_UNIT_LOOKUP"	value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_AUTOCLAVE_WASH_UNIT_LOOKUP")%>">
            <input type="hidden" name="SQL_SS_STERILIZATION_TYPE_LOOKUP" id="SQL_SS_STERILIZATION_TYPE_LOOKUP"	value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STERILIZATION_TYPE_LOOKUP")%>">
			<input type="hidden" name="SQL_SS_STORE_LOOKUP" id="SQL_SS_STORE_LOOKUP"					value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_LOOKUP")%>">
 
          
		</form>
	</body>
	<%
	putObjectInBean(bean_id,bean,request);
%>

</html>	

