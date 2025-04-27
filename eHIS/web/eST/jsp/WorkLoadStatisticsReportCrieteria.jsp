<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eST.*, java.lang.*,eST.Common.* , eCommon.Common.*"%>
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
	<!--<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!--<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<!--<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/WorkLoadStatisticsReport.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

	</head>
	<%
		
		String bean_id					=		"ReportsStockStatusBean";
		String bean_name				=		"eST.ReportsStockStatusBean";
	//	String p_report_id				=		null;
		
		
		ReportsStockStatusBean bean		=		(ReportsStockStatusBean) getBeanObject( bean_id, bean_name, request );
		String facility_id				=		bean.getLoginFacilityId();
		String user_name				=		bean.getLoginById();
		//bean.clear();
		bean.setLanguageId(locale);

	%>
	<body onLoad="FocusFirstElement();">
		<form name="formWorkLoadStatisticsReportCriteria" id="formWorkLoadStatisticsReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame"  onReset="FocusFirstElement();">
		
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="80%" align="center" border="0">
				<th colspan=3 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>

				
				<tr>
					<td>&nbsp;</td>
					<td class="fields" >&nbsp;&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="fields">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.user.label" bundle="${common_labels}"/></td>
					<td align='left' class=fields id=td5>&nbsp;&nbsp;<input type="text" name="P_FM_USER_ID" id="P_FM_USER_ID" value="" size=20 maxLength=60    align="centre"><input type="button" class="button" name="fm_userIdSearch" id="fm_userIdSearch" value="?" onClick="searchUserCode(P_FM_USER_ID)" align="left">
					<!--	<input type="hidden" name="H_FM_USER_ID" id="H_FM_USER_ID" value="" size="15">-->
					</td><td  class=fields id=td5>&nbsp;&nbsp;<input type="text" name="P_TO_USER_ID" id="P_TO_USER_ID" value="" size=20 maxLength=60    align="centre"><input type="button" class="button" name="to_userIdSearch" id="to_userIdSearch" value="?" onClick="searchUserCode(P_TO_USER_ID)" align="left">
					<!--<input type="hidden" name="H_TO_USER_ID" id="H_TO_USER_ID" value="" size="15">--></td>
				</tr>
				<tr>
					<td align="left" class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="P_FM_STORE_CODE" id="P_FM_STORE_CODE" value="" ><input class="button" onClick="return searchCodeStore(P_FM_STORE_CODE);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td>
					
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="P_TO_STORE_CODE" id="P_TO_STORE_CODE" value="" ><input class="button" onClick="return searchCodeStore(P_TO_STORE_CODE);" type="button" name="p_to_sr" id="p_to_sr" value="?"></td>
				</tr>
				<tr>
					<td class="label" align="left"><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name="P_FM_DATE_1" id="P_FM_DATE_1" size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this,'<%=locale%>');"  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('P_FM_DATE_1');" ></img>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td class=fields >&nbsp;&nbsp;<input type=text name="P_TO_DATE_1" id="P_TO_DATE_1" size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this,'<%=locale%>');"  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('P_TO_DATE_1');" ></img>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>

			<!--	<tr>
					<td class="label" align="right">Transaction</td>	<td align='left' class=label id=td5>&nbsp;&nbsp;<select name="P_FINALIZED_YN" id="P_FINALIZED_YN" >
						<option value= "" >All</option>
						<option value="Y">Finalized</option>
						<option value="N">Unfinalized</option>
					</select></td>
					<td class="label">&nbsp;</td>
				</tr>
				-->	
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					
				</tr>
				</table>
				</td>  
				</tr>
			</table>

			
			<input type="hidden" name="bean_id" id="bean_id"							value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"						value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 					value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id"						value="STBWLSTA">
			<input type="hidden" name="P_FM_DATE" id="P_FM_DATE"						value="">
			<input type="hidden" name="P_TO_DATE" id="P_TO_DATE"						value="">
			<input type="hidden" name="p_user_name" id="p_user_name"						value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"					value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"					value="<%=locale%>">


			

		</form>
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_SM_APPL_USER_USER_LOOK_UP" id="SQL_SM_APPL_USER_USER_LOOK_UP"	value="<%=eST.Common.StRepository.getStKeyValue("SQL_SM_APPL_USER_USER_LOOK_UP")%>">
			<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

