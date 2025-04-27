<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name			INC Number       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------------------------

10/08/2020				NMC-JD-CRF-0047			Haribabu		IN072774		13/08/2020			Manickam						NMC-JD-CRF-0047	
--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"  import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
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
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/WacStockOnHandReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		
		String facility_id			=		(String) session.getValue( "facility_id" ) ;
		String user_name			=		(String) session.getValue( "login_user" ) ;
		
			
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formWacStockOnHandReportCriteria" id="formWacStockOnHandReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="70%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
					<td align="right">&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td  class="fields" colspan=5>&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fr_st_code" id="p_fr_st_code" value="" ><input class="button"  onClick="return searchCodeStore(p_fr_st_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=6 size=6  name="p_to_st_code" id="p_to_st_code" value="" ><input class="button" onClick="return searchCodeStore(p_to_st_code);" type="button"  name="p_to_sr" id="p_to_sr" value="?"></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"> </td>
				</tr>
				<tr>
				 <td  class="label" ><fmt:message key="eST.BatchSelection.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name="p_batch_sel" id="p_batch_sel" >
						<option value='A'><fmt:message key="eST.AllBatches.label" bundle="${st_labels}"/></option>
						<option  value='Y'><fmt:message key="eST.SuspendedBatches.label" bundle="${st_labels}"/></option>
						<option  value='N'><fmt:message key="eST.ActiveBatches.label" bundle="${st_labels}"/></option>
					</select></td>
				</tr>
				<tr>
					<td  class="label" ><fmt:message key="Common.ReportOrder.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name="p_report_order" id="p_report_order" >
						<option value='I'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></option>
						<option  value='S'><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/> </option>
					</select></td>
				</tr>

					<tr><td align="right" class="label" >&nbsp;&nbsp;</td>
					<td align="right" class="label" >&nbsp;&nbsp;</td>
					<td align="right" class="label" >&nbsp;&nbsp;</td>
					<td align="right" class="label" >&nbsp;&nbsp;</td>
				</tr>
			                
				</table>
				</td>  

				</tr>
			</table>

			
			
			<input type="hidden" name="p_module_id" id="p_module_id" 					value="ST">
			<input type="hidden" name="p_user_name" id="p_user_name"						value="<%=user_name%>">
			<input type="hidden" name="p_user_id" id="p_user_id"						value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"					value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"					value="<%=locale%>">
			<input type="hidden" name="p_report_id" id="p_report_id"						value="STSOHWACR">
		</form>
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
<%
	//putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

