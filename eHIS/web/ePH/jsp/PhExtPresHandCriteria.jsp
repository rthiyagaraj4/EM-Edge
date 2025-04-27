<!DOCTYPE html>
 <!--
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
06/05/2021		TFS-15598       Prabha          MOHE-CRF-0074
---------------------------------------------------------------------------------------------------------------
*/ -->
 <%-- saved on 04/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
<% 
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String p_user_name= (String) session.getValue( "login_user" ) ;	 //Added for MOHE-CRF-0074
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
			
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
		<script LANGUAGE="javascript" src="../../ePH/js/PhExtPresHand.js"></script>
		<script LANGUAGE="javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<!-- <script LANGUAGE="javascript" src="../js/PhMessages.js"></script>
		<script language="javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	</head>
<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	 con				= ConnectionManager.getConnection(request);
	boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
	
	// Added for MOHE-CRF-0074 - END
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String sql_ph_medn_stat_pract_select1=PhRepository.getPhKeyValue("SQL_PH_MEDN_STAT_PRACT_SELECT1");
	String bean_id				= "PHRepMednOrdStatByPractBean" ;
	String bean_name			= "ePH.PHRepMednOrdStatByPractBean";
	PHRepMednOrdStatByPractBean bean	= (PHRepMednOrdStatByPractBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	String  med_or_yn			= bean.getMednOrList();
    ArrayList facilityList       = bean.getMednFacilityList();
	//ArrayList dateList          = bean.getMednDateList();
	if(med_or_yn.equals("N"))
		out.println("<script>GoBack()</script>");
	SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
	java.util.Date date_time	 	= new java.util.Date();
	String Sysdate 				= dtSystemFormat.format(date_time);
	Sysdate 						=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale);//Added for DateConversion identification 
	
	String order_facility_id="" , order_facility_name=""; //Added for MOHE-CRF-0074
	String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
	ArrayList region_code_check = bean.getRegionCheck(p_user_name,region_code); //Added for MOHE-CRF-0074
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
		<form name="formPhExtPresHandCriteria" id="formPhExtPresHandCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<TH COLSPAN="4" ALIGN="left"><fmt:message key="ePH.ExternalPrescriptionsReportCriteria.label" bundle="${ph_labels}"/></TH>
				<tr><td class='label' colspan='4' height='4'></td></tr>
				<tr>
					<td  class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
					<td COLSPAN="3" align="left"><SELECT name="facility_code" id="facility_code" >
						<OPTION VALUE=""> <fmt:message key="ePH.AllAccessFacility.label" bundle="${ph_labels}"/></OPTION>
<%
			if(region_check){ // MOHE-CRF-0074-Start
				   for (int i=0;i<region_code_check.size();i+=2){
						order_facility_id=(String)region_code_check.get(i);
						order_facility_name=(String)region_code_check.get(i+1);
%>
			<option value='<%=order_facility_id%>'><%=order_facility_name%></option>
<%	
			}
		}else{ //Added for MOHE-CRF-0074 - End
					if (facilityList.size() > 0 )
						for (int i=0; i<facilityList.size(); i+=2) {
%>
						 <OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>
<% 
					}
		}//Added for MOHE-CRF-0074
%>
					</td>
				</tr>
				<tr><td class='label' colspan='4' height='4'></td></tr>
				<tr>
					<td  class="label" ><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
					<%-- <td COLSPAN="3" align="left" >&nbsp;<input type="text" size="10" maxlength=10 name="enq_date_from" id="enq_date_from" Onblur="CheckDateT(this);DateCheck('<%=Sysdate%>',enq_date_from);validate_date(this,'TO_DATE_LESS_FROM')"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('enq_date_from');"  onblur="document.forms[0].enq_date_from.focus();">&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center" > &nbsp;&nbsp;&nbsp;&nbsp;<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;<input type="text" size="10" maxlength=10 name="enq_date_to" id="enq_date_to" onblur="CheckDateT(this);DateCheck('<%=Sysdate%>',enq_date_to);validate_date(this,'TO_DT_GR_EQ_FM_DT');"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('enq_date_to');"  onblur="document.forms[0].enq_date_to.focus();">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td> --%><!--Sysdate passed for DateConversion identification --><!--p_enq_date_from to enq_date_from AND p_enq_date_to to enq_date_to Added for DateConversion identification -->
					<!-- START ML-MMOH-SCF-2364, ML-BRU-SCF-2212 -->
					<td COLSPAN="3" align="left" >
						<input type="text" size="10" maxlength=10 name="enq_date_from" id="enq_date_from" Onblur='checkDate(this,"DMY","<%=locale%>")'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('enq_date_from');"  onblur="document.forms[0].enq_date_from.focus();">&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center" > &nbsp;&nbsp;&nbsp;&nbsp;
					<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;
						<input type="text" size="10" maxlength=10 name="enq_date_to" id="enq_date_to" onblur='checkDate(this,"DMY","<%=locale%>")'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('enq_date_to');"  onblur="document.forms[0].enq_date_to.focus();">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
					<!-- END ML-MMOH-SCF-2364 ,ML-BRU-SCF-2212-->
				</tr>																				
				<tr><td class='label' colspan='4' height='4'></td></tr>
				<tr>
					<td  class="label" width="35%" colspan='1'><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td align='left' colspan='1' width='65%' > <SELECT name="p_report_type" id="p_report_type" onChange="" >
						<OPTION VALUE="1"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></OPTION>
						<OPTION VALUE="2"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></OPTION> 
						</select>
					</td>
				</tr>
				<tr><td class='label' colspan='4' height='4'></td></tr>
			</table>
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_facility_code" id="p_facility_code" VALUE="">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
			<INPUT TYPE="hidden" name="p_frdate" id="p_frdate" VALUE="">
			<INPUT TYPE="hidden" name="p_todate" id="p_todate" VALUE="">
			<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
			<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="p_enq_date_from" id="p_enq_date_from" VALUE=""><!--Added for DateConversion identification -->
			<INPUT TYPE="hidden" name="p_enq_date_to" id="p_enq_date_to" VALUE=""><!--Added for DateConversion identification -->
		</form>
		<INPUT TYPE="hidden" name="sql_ph_medn_stat_pract_select1" id="sql_ph_medn_stat_pract_select1" VALUE="<%= sql_ph_medn_stat_pract_select1%>">
	</body>
<% 
putObjectInBean(bean_id,bean,request); %>
<%  // Added for MOHE-CRF-0074 - start
} 
catch(Exception e){
	e.printStackTrace();
}
finally{ 
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
}
%> <!-- Added for MOHE-CRF-0074 - End -->
</html>

