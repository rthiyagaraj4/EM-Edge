<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
12/10/2020		IN073850	  	   Shazana											   MOHE-SCF-0034
28/7/2021		TFS21715			Shazana											   MOHE-SCF-0034.1
--------------------------------------------------------------------------------------------------------------
*/
%>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.ArrayList,java.util.HashMap, eST.CondemnedBatchesReportBean"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/CondemnedBatchesReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id = "condemnedBatchesReportBean";
		String bean_name = "eST.CondemnedBatchesReportBean";
		//String p_report_id = null;
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
		
		CondemnedBatchesReportBean bean = (CondemnedBatchesReportBean) getBeanObject( bean_id,bean_name,request);  
		//bean.setLanguageId(locale);
		bean.clear();
		bean.setLanguageId(locale);
		
	%>
	<body onLoad="FocusFirstElement();setReport();">
			<form name="formCondemnedBatchesReport" id="formCondemnedBatchesReport" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
				<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				
			<tr>
					<td   class="label" width="20%"><fmt:message key="eST.CondemnID.label" bundle="${st_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input class="NUMBER" maxLength=10 size=10 name="p_condemn_id" id="p_condemn_id" onKeyPress="return CheckforNumber();"></td> 
					<!-- <td>&nbsp;</td>
					<td>&nbsp;</td> -->
					<td   class="label" width="20%"><fmt:message key="Common.ReportOrder.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<select name="p_report_order" id="p_report_order" onChange="setReport();">	
<option  value='STBCNEXI'><fmt:message key="eST.ByItemClass.label" bundle="${st_labels}"/></option>
<option  value='STBCNEXS'><fmt:message key="eST.ByStore.label" bundle="${st_labels}"/></option>
<option  value='STBCNEXC'><fmt:message key="eST.ByCondemnedId.label" bundle="${st_labels}"/></option>
</select></td> 
			</tr>

			<tr>
					<td align="right">&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/> </td>
					<td align="right" >&nbsp; </td>
					<td class="fields" colspan=5>&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
			</tr>
			<tr>
					<td  class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=10 name="p_fm_item_class" id="p_fm_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_fm_item_class);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=4 size=10 name="p_to_item_class" id="p_to_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?"></td>
				</tr>
				<tr>
					<td class="label" align="left"><fmt:message key="eST.CondemnDate.label" bundle="${st_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<input type=text name="dt_from" id="dt_from" size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);" >
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dt_from');" ></img>
					&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td class="label">&nbsp;</td><td class=fields colspan=5>&nbsp;&nbsp;<input type=text name="dt_to" id="dt_to" size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);" >
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dt_to');" ></img>
					&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=10 name="p_fm_store_code" id="p_fm_store_code" value="" ><input class="button"  onClick="return searchCodeStore(p_fm_store_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=6 size=10  name="p_to_store_code" id="p_to_store_code" value="" ><input class="button" onClick="return searchCodeStore(p_to_store_code);" type="button"  name="p_to_sr" id="p_to_sr" value="?"></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_fm_batch_id" id="p_fm_batch_id" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=10 size=10  name="p_to_batch_id" id="p_to_batch_id" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>
				<tr><td class="label" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type="text" maxLength=20 size=20 name="p_remarks" id="p_remarks" value="" readonly>
					<input type='button' class='BUTTON' value='?' onClick="searchRemarks(p_remarks_code,p_remarks);"><input type="hidden" name="p_remarks_code" id="p_remarks_code" value=""></td>
					<td align="right" class="label" >&nbsp;&nbsp;</td>
					<td align="right" class="label" >&nbsp;&nbsp;</td>
				</tr>
					</table>
				</td>  

				</tr>
			</table>
		
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id">
		
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">

			<!-- <input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">      --><!-- commented for IN073850 -->
           <!--  <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">--> <!-- commented for TFS21715 start -->
			<!--  <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">-->  <!-- TFS21715 end -->
			 <input type="hidden"	name="p_rem_trans_type" id="p_rem_trans_type"			value="CEB"> 
		</form>
		<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

