<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ page import="eSS.ReportsMasterCodeBean" %>

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
		<script language="javascript" src="../../eSS/js/RequestSummaryReport.js"></script>
		<script language="javascript" src="../../eSS/js/WasherTosiAndSoniCheckLog.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<!-- <script language="javascript" src="../../eSS/js/LogSheetForAutoclavePlasma.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	</head>
	<%
		
		String bean_id					=	"reportsMasterCodeBean";
		String bean_name				=	"eSS.ReportsMasterCodeBean";
//		String p_report_id				=	 null;
		String facility_id				=  (String) session.getValue( "facility_id" ) ;
		String user_name				=  (String) session.getValue( "login_user" ) ;
		
//		ReportsMasterCodeBean bean		= (ReportsMasterCodeBean) mh.getBeanObject( bean_id, request,  bean_name);
		ReportsMasterCodeBean bean		= (ReportsMasterCodeBean) getBeanObject( bean_id, bean_name, request);
		HashMap alstartdate 	= 		 null;
		alstartdate             =        bean.getDurationforStartDate();
		String currentdate	    =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
		String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
		
		bean.clear();
		bean.setLanguageId(locale);
		
		
	%>
	<body onLoad="FocusFirstElement();"onMouseDown='CodeArrest();'>
	  <form name="WasherTosiAndSoniCheckLog" id="WasherTosiAndSoniCheckLog" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
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
					<td align="right">&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					
				</tr>
				
				<tr>
					<td align="right" class="label" nowrap><fmt:message key="Common.DocumentDate.label" bundle="${common_labels}"/></td>
						<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_fm_date1" id="p_fm_date1" value="<%=currentdateminus%>" type=text class="DATE" onBlur="CheckDate(this,'<%=locale%>');">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_date1');"><%=bean.getMandatoryImageTag()%></img></td>
					<td class="label">&nbsp;</td>
						<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_to_date1" id="p_to_date1" value="<%=currentdate%>" type=text class="DATE" onBlur="CheckDate(this,'<%=locale%>');">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_date1');"><%=bean.getMandatoryImageTag()%></img></td>
			
				</tr>
				
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
			
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
					
					<tr>
					<td align="right" class="label"><fmt:message key="eSS.AutoclaveWashUnit.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=8 size=10 name="p_auto_clave_wash_unit_fm" id="p_auto_clave_wash_unit_fm" value="" ><input class="button" onClick="return searchCodeAutoclaveWashingUnitCode(p_auto_clave_wash_unit_fm);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=8 size=10 name="p_auto_clave_wash_unit_to" id="p_auto_clave_wash_unit_to" value="" ><input class="button" onClick="return searchCodeAutoclaveWashingUnitCode(p_auto_clave_wash_unit_to);" type="button" value="?"></td>
				</tr>


				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				
						    <tr>
					<td align="right" class="label"><fmt:message key="eSS.AutoclaveWashTest.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=8 size=10 name="p_test_code_fm" id="p_test_code_fm" value="" ><input class="button" onClick="return searchCodeAutoclaveWashingTest(p_test_code_fm);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=8 size=10 name="p_test_code_to" id="p_test_code_to" value="" ><input class="button" onClick="return searchCodeAutoclaveWashingTest(p_test_code_to);" type="button" value="?"></td>
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
			<input type="hidden" name="p_fm_date" id="p_fm_date" 								value="">
			<input type="hidden" name="p_to_date" id="p_to_date" 								value="">
			
			<input type="hidden" name="p_report_id" id="p_report_id" 							value="SSWSHTSICHK">
			<input type="hidden" name="p_user_name" id="p_user_name"								value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"							value="<%=facility_id%>">
			<input type="hidden" name="locale" id="locale"									value="<%=locale%>"> 

            
           <input type="hidden" name="p_language_id" id="p_language_id"							value="<%=locale%>">
            
            
			<input type="hidden" name="SQL_SS_AUTO_WASH_UNIT_LOOK_WASHTYPE" id="SQL_SS_AUTO_WASH_UNIT_LOOK_WASHTYPE" value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_AUTO_WASH_UNIT_LOOK_WASHTYPE")%>"> 
			<input type="hidden" name="SQL_SS_AUTO_WASH_UNIT_LOOK_TESTTYPE" id="SQL_SS_AUTO_WASH_UNIT_LOOK_TESTTYPE" value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_AUTO_WASH_UNIT_LOOK_TESTTYPE")%>">
			</form>
	</body>
</html>	

