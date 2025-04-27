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
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/CancelCountSheetReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	 <%
		
		String bean_id = "CancelCountSheetReportBean";
		String bean_name = "eST.CancelCountSheetReportBean";
	//	String p_report_id = null;
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		CancelCountSheetReportBean bean=(CancelCountSheetReportBean)getBeanObject( bean_id,bean_name,request);  
	%> 
	
	<body onLoad="FocusFirstElement();">
		<form name="formCancelCountSheetReportCriteria" id="formCancelCountSheetReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame"  onReset="FocusFirstElement();">
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="80%" align="center" border="0">
				<th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
					<td>&nbsp;</td>
					<td class="fields" colspan=2>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="fields">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<td colspan=2>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_store_code" id="p_fm_store_code" value="" class="UPPER"><input class="button" onClick="return searchCodeStore(p_fm_store_code);" type="button" value="?">
					</td>
					<td >&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_store_code" id="p_to_store_code" class="UPPER"><input class="button" onClick="return searchCodeStore(p_to_store_code);" type="button" value="?"></td>

					
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td colspan=2>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" class="UPPER"><input class="button" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" class="UPPER"><input class="button" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
					<td colspan=2>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fm_item_class_code" id="p_fm_item_class_code" value="" class="UPPER"><input class="button" onClick="return searchCodeItemClass(p_fm_item_class_code);" type="button" value="?" ></td>
					<td>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class_code" id="p_to_item_class_code" value=""  class="UPPER"><input class="button" onClick="return searchCodeItemClass(p_to_item_class_code);" type="button" value="?"></td>
				</tr>


				<tr>
					<td class=label><fmt:message key="eST.PhyInventoryID.label" bundle="${st_labels}"/></td>
					<td colspan=2>&nbsp;&nbsp;<input type=text class='number' maxlength=6
					  name=p_fm_phyinv_id value="" onkeypress="return isValidNumber(this,event,9,0);"></td>
					<td>&nbsp;&nbsp;<input type=text class='number' maxlength=6
					  name=p_to_phyinv_id value="" onkeypress="return isValidNumber(this,event,6,0);"></td>
			</tr>

				<tr>
					<td class=label align=left><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<input type='text' name='p_fm_cancelled_date' id='p_fm_cancelled_date' size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);" >
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_cancelled_date');" ></img>
					&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td class="fields">&nbsp;</td><td class=fields >&nbsp;&nbsp;<input type='text' name='p_to_cancelled_date' id='p_to_cancelled_date' size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);" >
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_cancelled_date');" ></img>
					&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.user.label" bundle="${common_labels}"/></td>
					<td  class=fields >&nbsp;&nbsp;<input type="text" name="p_fm_user_id" id="p_fm_user_id" value="" size=13  maxLength=30   ><input type="button" class="button" name="fm_userIdSearch" id="fm_userIdSearch" value="?" onClick="searchUserCode(p_fm_user_id)" >&nbsp;&nbsp;&nbsp;&nbsp;
					</td><td  class=label >&nbsp;</td><td class=fields>&nbsp;&nbsp;<input type="text" name="p_to_user_id" id="p_to_user_id" size=13  value="" maxLength=30   ><input type="button" class="button" name="to_userIdSearch" id="to_userIdSearch" value="?" onClick="searchUserCode(p_to_user_id)" >	&nbsp;&nbsp;&nbsp;&nbsp;</td>
					
				</tr>
				<tr>
					<td >&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				
				</table>
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type="hidden" name="p_module_id" id="p_module_id" value="ST">
				<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_name%>">
				<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>">
				<input type="hidden" name="p_report_id" id="p_report_id"         value="STBPHCHS">
				<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">		

		</form>
		<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
				<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
				<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
				<input type="hidden" name="SQL_SM_APPL_USER_USER_LOOK_UP" id="SQL_SM_APPL_USER_USER_LOOK_UP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_SM_APPL_USER_USER_LOOK_UP")%>">
				<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

