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
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	 <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/PhPresPattern.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT> -->
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!--	<script LANGUAGE="javascript" src="../js/PhMessages.js"></script>
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
-->
</head>

<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	 con				= ConnectionManager.getConnection(request);
	boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK"); 
	
	// Added for MOHE-CRF-0074 - END
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String sql_ph_medn_stat_pract_select1=PhRepository.getPhKeyValue("SQL_PH_MEDN_STAT_PRESC_PATT_PRACT_SELECT1");

	String bean_id				= "PhUncollDrugBean" ;
	String bean_name			= "ePH.PhUncollDrugBean";
	PhUncollDrugBean bean	= (PhUncollDrugBean)getBeanObject( bean_id, bean_name,request ) ;
	bean.setLanguageId(locale);
	String  med_or_yn			= bean.getMednOrList();
    ArrayList facilityList       = bean.getMednFacilityList();
//	ArrayList displocationlist  = bean.getDispLocationList();

	if(med_or_yn.equals("N"))
	out.println("<script>GoBack()</script>");
	SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
	java.util.Date date_time	 	= new java.util.Date();
	String Sysdate ="";
	Sysdate 				= dtSystemFormat.format(date_time); 
	Sysdate=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale);

	String order_facility_id="" , order_facility_name=""; //Added for MOHE-CRF-0074
	String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
	ArrayList region_code_check = bean.getRegionCheck(p_user_name,region_code); //Added for MOHE-CRF-0074

%>


<!-- <BODY onload="document.formPhPresPatternCriteria.p_facility_code.focus();"> -->
<BODY onload="document.formPhPresPatternCriteria.p_facility_code.focus();" onMouseDown="" onKeyDown="lockKey()">
<!--<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhPresPatternCriteria.p_facility_code.focus();"> -->

<form name="formPhPresPatternCriteria" id="formPhPresPatternCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
<TH COLSPAN="6"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
        <td class="label" width='25%'><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td COLSPAN="1" width='25%'><SELECT name="p_facility_code" id="p_facility_code" onchange='enableLocation(this)'>
		   	<OPTION VALUE=""> <fmt:message key="ePH.AllAccessFacility.label" bundle="${ph_labels}"/></OPTION>
<%	  if(region_check){ // MOHE-CRF-0074-Start
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

<% 	   } 
	} //Added for MOHE-CRF-0074
%>

	</td>
	<TD width="15%" class='label' ><font id='pn'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</font></td>
	<TD width="35%" colspan="1"><select name="locn_type" id="locn_type" onchange='callLocation(this)' disabled>
			<option value="ALL"  >------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option> 
			<option value="N" ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
			<option value="C" ><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
		</select>
     </td>
	 </td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
		
	<tr>
		<td class="label" width="25%"><fmt:message key="ePH.OrderDateTimeFrom.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
		<td COLSPAN="1" width="25%"><input type="text" maxlength="10" size="10" name="dt_from1" id="dt_from1" Onblur="CheckDateT(this);if(DateCheck(sysdate,dt_from1))validate_date(this,'TO_DATE_LESS_FROM')"><!--changed CheckDate to CheckDateT for Leap year calculation on 24/02/2012 -->
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"> 
		<td COLSPAN="1" width="15%" class='label'><fmt:message key="ePH.OrderDateTo.label" bundle="${ph_labels}"/>&nbsp;&nbsp;
		<td COLSPAN="1" width="35%"><input type="text" maxlength="10" size="10" name="dt_to1" id="dt_to1" Onblur="CheckDateT(this);DateCheck(sysdate,dt_to1);validate_date(this,'TO_DATE_LESS_FROM')"><!--changed CheckDate to CheckDateT for Leap year calculation on 24/02/2012 -->
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
		
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
		<tr>
		<td class="label" width="25%"><fmt:message key="ePH.SelectBy.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
		<td  colspan='1' width='25%'><select name="p_select_by" id="p_select_by" onChange="changeLegend(this)">
					<option value="">&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;</option>
					<option value="PT"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
					<option value="DR"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
		<td  class='label' width="15%" COLSPAN="1"><label id='PR'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;
		<td  width="35%" COLSPAN="1"><input type="text" readonly name="dyn_name" id="dyn_name" maxlength="30" size="30" value="" ><input type="button" class="button" value="?" name="drug_search" id="drug_search" disabled onClick="callFunc(this);"></td>

		<!-- onClick="callDrugSearch(document.formPhPresPatternCriteria.drug_name, 1)"></td> -->
		<input type="hidden" name="dyn_code" id="dyn_code" value="">
		
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td class="label" width='25%'><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td  width='25%' colspan='1'><select name="p_order_by" id="p_order_by">
					<option value="">&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;</option>
					<option value="PR"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></label></option>
					<option value="UP"><fmt:message key="ePH.UsagePercent.label" bundle="${ph_labels}"/></option> 
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
		<td class="label" width="15%" ><fmt:message key="Common.ascending.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td class="label" width='35%' nowrap><input type="radio" name="choose_service" id="choose_service"  value="A"  checked>
		&nbsp;&nbsp;&nbsp;<fmt:message key="Common.descending.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type="radio" name="choose_service" id="choose_service"   value="D" > </input></td>
		<!--		<label class="label" >Base Unit</label> -->
			</td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	</table>
	
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHPRESPAT">
	<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
	<INPUT TYPE="hidden" name="p_locn_type" id="p_locn_type" VALUE="">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE=" "> <!-- Added for TTM-SCF-0149 [IN:060026] -->
	<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE=" "> <!-- Added for TTM-SCF-0149 [IN:060026] -->
<% putObjectInBean(bean_id,bean,request); %>
</form>
<INPUT TYPE="hidden" name="sql_ph_medn_stat_pract_select1" id="sql_ph_medn_stat_pract_select1" VALUE="<%=sql_ph_medn_stat_pract_select1%>">
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

