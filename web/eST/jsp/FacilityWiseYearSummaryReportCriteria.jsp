<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->	
 <%

		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/TransAnalysisReport.js"></script>
		<script language="javascript" src="../../eST/js/FacilityWiseYearSummaryReport.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

	</head>

		<%
		
		String bean_id					=		"facilityWiseYearSumBean";
		String bean_name				=		"eST.FacilityWiseYearSumBean";
		//String p_report_id			=		null;
		String facility_id				=		(String) session.getValue( "facility_id" ) ;
		String user_name				=		(String) session.getValue( "login_user" ) ;
		
		
		FacilityWiseYearSumBean bean	=		(FacilityWiseYearSumBean) getBeanObject( bean_id,bean_name,request);  
		bean.clear();
		bean.setLanguageId(locale);	
	%>

	<body onLoad="FocusFirstElement();">
		<form name="formFacilityWiseYearSummaryReport" id="formFacilityWiseYearSummaryReport" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame"  onReset="FocusFirstElement();">
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='75%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
			
               <tr>
					<td class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
					<td class="fields">&nbsp;&nbsp;<SELECT name="p_facility_id_temp" id="p_facility_id_temp">
					<OPTION VALUE="A">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------&nbsp;&nbsp;</OPTION>
				
				 <%
					ArrayList	arraylist			=	null;
					HashMap		hmFacility			=	null;
					String facility					=	"";
					String	desc					=	"";
					arraylist						=	bean.getFacility();
					int arrLength					=	arraylist.size();
					for(int i=0;i<arrLength; i++)
					{
						hmFacility   				=	(HashMap) arraylist.get(i);
						facility					=	(String)hmFacility.get("facility");
						desc						=	(String)hmFacility.get("desc");
					
					%> 	<option value="<%=facility%>"><%=desc%></option> 	
				<% 	} %>
						</select></td>
						<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;</td>
                </tr>

				<tr>
					<td align="right">&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td class="fields" colspan=5>&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="eST.AccountingPeriod.label" bundle="${st_labels}"/>(<fmt:message key="Common.year.label" bundle="${common_labels}"/>)</td>
					<td class=fields >&nbsp;&nbsp;<input maxLength=4 class=number size=4 name="p_fm_year" id="p_fm_year" value="" onKeyPress="numbervalidation();"></td><td class="label">&nbsp;</td>
					<td  class="fields" colspan=5>&nbsp;&nbsp;<input maxLength=4 size=4 class=number name="p_to_year" id="p_to_year" value="" onKeyPress="numbervalidation();"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>
				
				<tr>
				<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
				<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=10 name="p_fm_item_class" id="p_fm_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_fm_item_class);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=10 name="p_to_item_class" id="p_to_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?"></td>
				</tr>

				<tr>
					<td class=label align=right><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_fr_alp_code size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td class="label">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_to_alp_code size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>

				<tr>
					<td align="right" class="label" colspan = 8>&nbsp;</td>

		        
				</table>
				</td>  

				</tr>
				</table>
                    <input type="hidden" name="bean_id" id="bean_id"							value="<%=bean_id%>">
			        <input type="hidden" name="bean_name" id="bean_name"						value="<%=bean_name%>">
			        <input type="hidden" name="p_module_id" id="p_module_id" 					value="ST">
			        <input type="hidden" name="p_user_name" id="p_user_name"						value="<%=user_name%>">
			        <input type="hidden" name="p_facility_id" id="p_facility_id"					value="<%=facility_id %>">
					<input type="hidden" name="p_report_id" id="p_report_id"					    value="STBFAYSM">
					<input type="hidden" name="p_language_id" id="p_language_id"					value="<%=locale%>">					
			      
				   </form>
					<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
					<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG"	value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
					<input type="hidden" name="SQL_ST_ALPHA_LOOKUP" id="SQL_ST_ALPHA_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ALPHA_LOOKUP")%>">
<%
	putObjectInBean(bean_id,bean,request);
%>
				      </body>
				</html>

