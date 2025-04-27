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
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String p_user_name= (String) session.getValue( "login_user" ) ;	 //Added for MOHE-CRF-0074
	//
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	 <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/PhUncollDrug.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT> -->
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- 	<script LANGUAGE="javascript" src="../js/PhMessages.js"></script>-->

</head>

<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	 con				= ConnectionManager.getConnection(request);
	boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK"); 
	// Added for MOHE-CRF-0074 - END
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String bean_id				= "PhUncollDrugBean" ;
	String bean_name			= "ePH.PhUncollDrugBean";
	PhUncollDrugBean bean	= (PhUncollDrugBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	String  med_or_yn			= bean.getMednOrList();
    ArrayList facilityList       = bean.getMednFacilityList();
	String  all_access           = "";
	ArrayList displocationlist  = bean.getDispLocationList(all_access);

	if(med_or_yn.equals("N"))
	out.println("<script>GoBack()</script>");

	String order_facility_id="" , order_facility_name=""; //Added for MOHE-CRF-0074
	String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
	ArrayList region_code_check = bean.getRegionCheck(p_user_name,region_code); //Added for MOHE-CRF-0074

//	out.println(dateList);

%>


<!-- <BODY onload="document.formPhUncollDrugCriteria.p_facility_code.focus();"> -->
<BODY onload="document.formPhUncollDrugCriteria.p_facility_code.focus();" onMouseDown="" onKeyDown="lockKey()">
<!--<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhUncollDrugCriteria.p_facility_code.focus();"> -->

<form name="formPhUncollDrugCriteria" id="formPhUncollDrugCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<TH COLSPAN="4"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr>
        <td class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3">&nbsp;<SELECT name="p_facility_code" id="p_facility_code" onChange="populateDispLocn(this.value)">
		   	<OPTION VALUE=""> <fmt:message key="ePH.AllAccessFacility.label" bundle="${ph_labels}"/></OPTION>
	<%	 
	if(region_check){ // MOHE-CRF-0074-Start
		   for (int i=0;i<region_code_check.size();i+=2){
				order_facility_id=(String)region_code_check.get(i);
				order_facility_name=(String)region_code_check.get(i+1);
%>
		<option value='<%=order_facility_id%>' ><%=order_facility_name%></option>
<%	
			}
		}else{ // MOHE-CRF-0074-End
			if (facilityList.size() > 0 )
				for (int i=0; i<facilityList.size(); i+=2) {
	%>
			 <OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>

	<% 	} 
	} //Added for MOHE-CRF-0074
	%>
	<!--	  </SELECT><img src="../../eCommon/images/mandatory.gif" align="center"></td> -->
	</tr>
	
	
	<tr>
		<td width="15%" class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		<td COLSPAN="3" width="30%">&nbsp;<SELECT name="p_disp_loc_code" id="p_disp_loc_code">
		<OPTION VAlUE="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </OPTION>
		<% if (displocationlist.size() > 0) 
		         for (int i=0;i<displocationlist.size();i+=2) {
		%>
			<OPTION VALUE="<%= displocationlist.get(i) %>"><%=displocationlist.get(i+1) %> </OPTION>
		<% } %>
    	</SELECT><img src="../../eCommon/images/mandatory.gif" align="center"></td>

			
	</tr>
	<tr>
		<td class="label" ><fmt:message key="ePH.AllocatedDateFrom.label" bundle="${ph_labels}"/></td>
		<td COLSPAN="3">&nbsp;<input type="text" maxlength="10" size="10" name="dt_from1" id="dt_from1" OnBlur='CheckDateT(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"> &nbsp;&nbsp;<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;<input type="text" maxlength="10" size="10" name="dt_to1" id="dt_to1" OnBlur='CheckDateT(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
	</tr>
	<tr>
		<td width="15%" class="label"><fmt:message key="ePH.DrugNameFrom.label" bundle="${ph_labels}"/></td>
		<td width="30%">&nbsp;<input type="text" name="drug_name" id="drug_name" maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="drug_search" id="drug_search"  onClick="callDrugSearch(document.formPhUncollDrugCriteria.drug_name, 1)"></td>
		<input type="hidden" name="drug_code" id="drug_code" value="">
		<td width="5%" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td width="50%">&nbsp;<input type="text" name="tdrug_name" id="tdrug_name" maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="tdrug_search" id="tdrug_search" onClick="callDrugSearch(document.formPhUncollDrugCriteria.tdrug_name, 2)"></td>
		<input type="hidden" name="tdrug_code" id="tdrug_code" value="">
	</tr>
	</table>
	
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%=bean_name%>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHUNDRUGS">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE=" "> <!-- Added for TTM-SCF-0150 [IN:060027] -->
	<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE=" "> <!-- Added for TTM-SCF-0150 [IN:060027] -->
<% putObjectInBean(bean_id,bean,request); 
} // Added for MOHE-CRF-0074 - start
catch(Exception e){
	e.printStackTrace();
}
finally{ 
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
}
%> <!-- Added for MOHE-CRF-0074 - End -->	
</form>
</body>
</html>

