<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/DrugRegisterReport.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<%
		
		String bean_id					=		"ReportsStockStatusBean";
		String bean_name				=		"eST.ReportsStockStatusBean";
		eST.ReportsStockStatusBean bean	=		(eST.ReportsStockStatusBean) getBeanObject( bean_id, bean_name, request );
		String facility_id				=		bean.getLoginFacilityId();
		String user_name				=		(String)session.getAttribute("login_user");
		//bean.clear();
		bean.setLanguageId(locale);

	%>
	<body onLoad="FocusFirstElement();">
		<form name="formDrugRegisterReportCriteria" id="formDrugRegisterReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame"  onReset="FocusFirstElement();">
		
		<table border="0" cellpadding="0" cellspacing="0" width='80%' align='center' >
			<tr>
				<th align="left" colspan = 10><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
			</tr>
			<tr>
				<td colspan=2>&nbsp;</td>
				<td  class='label'><fmt:message key="Common.Store.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td class=fields>
					<input type=text name="p_store_desc" id="p_store_desc" maxlength=15 size =15 value="" onKeyPress="return CheckForSpecChars(event);"><input type=button value='?' class=button onClick="return searchCodeStore(p_store_desc);" ><%=bean.getImage("M")%>&nbsp;&nbsp;
				<input type="hidden" name="p_str_code" id="p_str_code"	value="">
				</td>
					<td align="right" class="label"><fmt:message key="Common.item.label" bundle="${common_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20  size=20   name="p_item_code" id="p_item_code"  value=""><input class="button" onClick="return searchCodeItem(p_item_code);" type="button" value="?"><%=bean.getImage("M")%></td>
				<!-- <input type="hidden" name="p_item_code" id="p_item_code"	value=""> -->
			</tr>
			<tr>
				<td colspan=2>&nbsp;</td>
				<td>&nbsp;</td>
				<td class="fields" >&nbsp;&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
				<td>&nbsp;</td>
				<td class="fields">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>	
				<td colspan=2>&nbsp;</td>
				<td class="label"><fmt:message key="eST.AccountingPeriod.label" bundle="${st_labels}"/></td>
				<td class=fields>&nbsp;&nbsp;<input maxLength=2 size=2 name="p_fm_month" id="p_fm_month" value="" onKeyPress="return isValidInteger();" onblur="checkDoubleFormat(this);" class="NUMBER"> 
				<class=text> / 	<class=text> <input maxLength=4 size=4 name="p_fm_year" id="p_fm_year" value="" onKeyPress="return isValidInteger();"  class="NUMBER"> <%=bean.getImage("M")%>  </td> 
				<td align="right" class="label"></td>
				<td class=fields>&nbsp;&nbsp;<input maxLength=2 size=2 name="p_to_month" id="p_to_month" value="" onKeyPress="return isValidInteger();" onblur="checkDoubleFormat(this);" class="NUMBER"> 
				<class=text> / 	<class=text> <input maxLength=4 size=4 name="p_to_year" id="p_to_year" value="" onKeyPress="return isValidInteger();"  class="NUMBER"> <%=bean.getImage("M")%>  </td> 
			</tr>
		</table>

			
		<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"		value="<%=bean_name%>">
		<input type="hidden" name="p_module_id" id="p_module_id" 	value="ST">
		<input type="hidden" name="p_report_id" id="p_report_id"		value="STBDRGREG">
		<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_name%>">
		<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
		<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>">
		<input type="hidden" name="p_from_monthyear" id="p_from_monthyear"value="">
		<input type="hidden" name="p_to_monthyear" id="p_to_monthyear"	value="">
		<input type='hidden' name="sysdate" id="sysdate"			value="<%=(String)bean.getSystemDate()%>">
		</form>
		<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"	value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
		<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%=eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

