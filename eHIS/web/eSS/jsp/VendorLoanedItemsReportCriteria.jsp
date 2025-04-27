<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eSS.*, eSS.Common.* , eCommon.Common.*" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
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
		<script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/VendorLoanedItemsReport.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id					=	"reportsMasterCodeBean";
		String bean_name				=	"eSS.ReportsMasterCodeBean";
		String facility_id				=  (String) session.getValue( "facility_id" ) ;
		String user_name				=  (String) session.getValue( "login_user" ) ;
		ReportsMasterCodeBean bean		= (ReportsMasterCodeBean) getBeanObject( bean_id, bean_name, request);
		HashMap alstartdate 	= 		 null;
		alstartdate             =        bean.getDurationforStartDate();
		String currentdate	    =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
		String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
		bean.clear();
		bean.setLanguageId(locale);
		
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formVendorLoanedItemsReport" id="formVendorLoanedItemsReport" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="80%" align="center" border="0">	
				<th align="left" colspan="4"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				
				<tr>
					<td class="label" ><fmt:message key="eSS.RequestType.label" bundle="${ss_labels}"/></td>
					<td class=fields  >&nbsp;&nbsp;&nbsp;<select name="p_request_type" id="p_request_type" > 
						<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option  value='N'><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
						<option  value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
						<option  value='E'><fmt:message key="Common.elective.label" bundle="${common_labels}"/></option>
					</select>
					</td>
				
					<td align="right" class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					
					<td class="label">&nbsp;&nbsp; 
					<select name="p_report_option" id="p_report_option">
						<OPTION VALUE="SM"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></OPTION>
						<OPTION VALUE="DT"><fmt:message key="eSS.Detailed.label" bundle="${ss_labels}"/></OPTION>
					</select>
				  </td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
					
					<td class="label">&nbsp; 
					<select name="p_group_by" id="p_group_by">
						<OPTION VALUE="V"><fmt:message key="eSS.Vendor.label" bundle="${ss_labels}"/></OPTION>
						<OPTION VALUE="RS"><fmt:message key="eSS.RequestingStore.label" bundle="${ss_labels}"/></OPTION>
					</select>
				  </td>
				  
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				
				
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
					<td align="right" class="label" nowrap><fmt:message key="eSS.RequestOnVendor.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=12 name="p_request_from_vendor" id="p_request_from_vendor" value="" ><input   class="button" onClick="return searchCodeVendorMaster(p_request_from_vendor);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=12 name="p_request_to_vendor" id="p_request_to_vendor" value="" ><input   class="button" onClick="return searchCodeVendorMaster(p_request_to_vendor);" type="button" value="?"></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label" nowrap><fmt:message key="eSS.RequestingStore.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=12 name="p_req_by_from_store_code" id="p_req_by_from_store_code" value="" ><input   class="button" onClick="return searchCodeStoreMaster(p_req_by_from_store_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=12 name="p_req_by_to_store_code" id="p_req_by_to_store_code" value="" ><input   class="button" onClick="return searchCodeStoreMaster(p_req_by_to_store_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label" nowrap><fmt:message key="eSS.RequestedSterileGroup.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=12 name="p_req_from_group_code" id="p_req_from_group_code" value="" ><input   class="button" onClick="return searchCodeSterileGroupMaster(p_req_from_group_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=12 name="p_req_to_group_code" id="p_req_to_group_code" value="" ><input   class="button" onClick="return searchCodeSterileGroupMaster(p_req_to_group_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label" nowrap><fmt:message key="eSS.VendorLoanRequestDocDate.label" bundle="${ss_labels}"/></td>
						<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_req_from_date1" id="p_req_from_date1" value="<%=currentdateminus%>" type=text class="DATE" onBlur="checkSysdate(p_req_from_date1,sysdate);">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_req_from_date1');"></img></td>
					<td class="label">&nbsp;</td>
						<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_req_to_date1" id="p_req_to_date1" value="<%=currentdate%>" type=text class="DATE" onBlur="checkSysdate(p_req_to_date1,sysdate);">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_req_to_date1');"></img></td>
			
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
			<input type="hidden" name="p_module_id" id="p_module_id" 							value="SS">
			<input type="hidden" name="p_req_from_date" id="p_req_from_date" 						value="">
			<input type="hidden" name="p_req_to_date" id="p_req_to_date" 							value="">
			
			<input type="hidden" name="p_report_id" id="p_report_id">
			<input type="hidden" name="p_user_name" id="p_user_name"								value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"							value="<%=facility_id%>">
			<input type='hidden' name="sysdate" id="sysdate"									value="<%=bean.getSSParameter().get("SYS_DATE").toString()%>">
			<input type="hidden" name="locale" id="locale"									value="<%=locale%>">
			<input type="hidden" name="SQL_AP_SUPPLIER_SELECT_LIST1" id="SQL_AP_SUPPLIER_SELECT_LIST1"			value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_AP_SUPPLIER_SELECT_LIST1")%>">
		 	<input type="hidden" name="SQL_SS_STORE_LOOKUP" id="SQL_SS_STORE_LOOKUP"						value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_LOOKUP")%>"> 
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP" id="SQL_SS_GROUP_LOOKUP"						value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_LOOKUP_FOR_REPORT")%>">
			
			<input type="hidden" name="p_language_id" id="p_language_id"							value="<%=locale%>">
			</form>
	</body>
</html>	

