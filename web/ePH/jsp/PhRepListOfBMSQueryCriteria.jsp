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

<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script LANGUAGE="javascript" src="../../ePH/js/PhRepListOfBMS.js"></script>
		<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	 con				= ConnectionManager.getConnection(request);
	boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
	// Added for MOHE-CRF-0074 - END
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String bean_id				= "PHReportsBean" ;
	String bean_name			= "ePH.PHReportsBean";
	PHReportsBean bean	= (PHReportsBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
    ArrayList facilityList       = bean.getFacilitys();
	String facility_id  =  (String) session.getValue( "facility_id" ) ;
	String user_name  =  (String) session.getValue( "login_user" ) ;
	String sysdate =com.ehis.util.DateUtils.convertDate(bean.getSysDate(), "DMY","en",locale);
	String order_facility_id="" , order_facility_name ="";  //Added for MOHE-CRF-0074
	String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
	ArrayList region_code_check = bean.getRegionCheckNew(region_code); //Added for MOHE-CRF-0074 //Modified for MOHE-CRF-0074
%>
	<BODY onMouseDown="" onKeyDown="">
		<form name="formListOfBalanceMedCriteria" id="formListOfBalanceMedCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<table cellpadding="2" cellspacing="0" width="50%" align="left" border="0">
				<tr>
					<td class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
					<td COLSPAN="3"><SELECT name="p_facility" id="p_facility" onChange="populateDispLocn(this.value)">
					<OPTION VALUE="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</OPTION>
<%				if(region_check){ // MOHE-CRF-0074-Start
				   for (int i=0;i<region_code_check.size();i+=2){
						order_facility_id=(String)region_code_check.get(i);
					order_facility_name=(String)region_code_check.get(i+1);
							if(facility_id.equals(order_facility_id))	{
%>
						<option value='<%=order_facility_id%>' selected><%=order_facility_name%></option>
<%
				}
				else{
%>
						<option value='<%=order_facility_id%>'><%=order_facility_name%></option>
<%	
					}
				}
		 }else{ // MOHE-CRF-0074-End
					if (facilityList.size() > 0 ){
						for (int i=0; i<facilityList.size(); i+=2) {
							if(facilityList.get(i).equals(facility_id)){
%>
								<OPTION VALUE="<%= facilityList.get(i) %>" selected="selected"><%= facilityList.get(i+1) %></OPTION>
<%							
							}
							else{
%>
								<OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>
<% 	
							}
						}
					}
		 } //Added for MOHE-CRF-0074
%>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
					<td COLSPAN="3">
						<select name="p_disp_locn_code" id="p_disp_locn_code" >
						<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
<%
						ArrayList arraylist		=	bean.getDispLocation(facility_id);
						int arrLength		=	arraylist.size();
						for(int i=0;i<arrLength; i+=2){
%>
							<option value="<%=(String)arraylist.get(i)%>"  ><%=(String)arraylist.get(i+1)%></option> 	
<% 
						}
%>
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="ePH.CollectionDate.label" bundle="${ph_labels}"/></td>
					<td class='label'><input type="text" name="p_nxt_date_disp" id="p_nxt_date_disp" size=10 maxlength=10 class="DATE" value="<%=sysdate%>" onBlur="CheckDateT(this);" ><input class="STSMALL" type='image' src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_nxt_date_disp');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
				</tr>
			</table>
			
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%=bean_name%>">
			<INPUT TYPE="hidden" name="p_nxt_date" id="p_nxt_date" VALUE="">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHLISBALMED">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
		</form>
	</body>
<%} // Added for MOHE-CRF-0074 - start
catch(Exception e){
	e.printStackTrace();
}
finally{ 
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
}
%> <!-- Added for MOHE-CRF-0074 - End -->
</html>

