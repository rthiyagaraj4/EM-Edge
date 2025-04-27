<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
----------------------------------------------------------------------------------------------------------------------------------
Date      	 Edit History      Name        Description
----------------------------------------------------------------------------------------------------------------------------------           
03/10/2016    IN06040      	  Mukesh M    For MMS-DM-CRF-0517,New report â??List of Items Not Created in Drug Masterâ?? is required to 
										  identify items which have been created in ST but not created in PH Drug Setup.
										  
----------------------------------------------------------------------------------------------------------------------------------
-->



<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.text.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/PhRepListOfItemsNotCreatedInDrugMaster.js"></script>
		<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"> </script> 
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	
	</head>
<%
	String bean_id				= "PHReportsBean" ;
	String bean_name			= "ePH.PHReportsBean";
	PHReportsBean bean			= (PHReportsBean)getBeanObject( bean_id,bean_name,request) ;
	String locale				= (String)session.getAttribute("LOCALE");
	bean.setLanguageId(locale);
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name			= (String) session.getValue( "login_user" ) ;
	String curr_sys_date = "";
	String curr_week_date  = "";	
		 	
	curr_sys_date = com.ehis.util.DateUtils.getCurrentDate("DMY",localeName);
	curr_week_date	= com.ehis.util.DateUtils.minusDate(curr_sys_date,"DMY",localeName,7,"d");
		
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
		
		<form name="formListOfItemsNotCreatedInDrugMaster" id="formListOfItemsNotCreatedInDrugMaster" action="" TARGET="messageFrame" >
			<br><br><br><br><br>
			<table cellpadding="0" cellspacing="0" width="70%" align="center" border="0">
			<TH COLSPAN="5"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
			
			 <tr>
				<td class="label" colspan="4">&nbsp;</td>
			 </tr>
			 
			<tr> 
				<td class="label" ><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td> 
				<td class="label"><input type="text" size="12" maxlength=10 name="dt_from" id="dt_from" value="<%=curr_week_date%>" OnBlur='CheckDateLeap1(this);'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td>
				<td class="label">&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class="label"><input type="text" size="10" name="dt_to" id="dt_to" maxlength=10 value="<%=curr_sys_date%>" OnBlur='CheckDateLeap1(this);'><IMG  SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
			</tr>
			
			<tr>
			<tr>
				<td colspan='2'>&nbsp;</td>
			</tr>
			
				<td class="label"><fmt:message key="Common.Itemtype.label" bundle="${common_labels}"/></td>
				<td class="label">
				  <select name="p_item_type" id="p_item_type">
				  	<option value="Y"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
				  	<option value="N"><fmt:message key="ePH.Non-Drug.label" bundle="${ph_labels}"/></option>
				  </select>
				</td>
			</tr>
			
			<tr> <td class="label" colspan="4">&nbsp;</td></tr>
		
		<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
		<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= p_facility_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name" value="<%= p_user_name %>">
		<input type="hidden" name="p_module_id" id="p_module_id" value="PH">
		<input type="hidden" name="P_FRDATE" id="P_FRDATE" value="">
		<input type="hidden" name="P_TODATE" id="P_TODATE" value="">
		<input type="hidden" name="p_report_id" id="p_report_id" value="PHLINCDM">
		<input type="hidden" name="sys_date" id="sys_date" value="<%=curr_sys_date%>">
		
		</table>
		
		
		
		</form>	
		
	</body>
</html>

