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
	<script LANGUAGE="javascript" src="../../ePH/js/PhMednOrderList.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
    <script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<!-- 	<script LANGUAGE="javascript" src="../js/PhMessages.js"></script>
	<script LANGUAGE="javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 --></head>

<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	 con				= ConnectionManager.getConnection(request);
	boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK"); 
	// Added for MOHE-CRF-0074 - END
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String bean_id				= "PhUncollDrugBean" ;
	String bean_name			= "ePH.PhUncollDrugBean";
	PhUncollDrugBean bean	= (PhUncollDrugBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	String  med_or_yn			= bean.getMednOrList();
    ArrayList facilityList       = bean.getMednFacilityList();

	String bean_id1 = "DispMedicationBean" ;
	String bean_name1 = "ePH.DispMedicationBean";
	DispMedicationBean bean1 = (DispMedicationBean)getBeanObject( bean_id1, bean_name1, request ) ;

//	String  all_access           = "";
//	ArrayList displocationlist  = bean.getDispLocationList(all_access);

	if(med_or_yn.equals("N"))
	out.println("<script>GoBack()</script>");

	String order_facility_id="" , order_facility_name=""; //Added for MOHE-CRF-0074
	String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
	ArrayList region_code_check = bean.getRegionCheck(p_user_name,region_code); //Added for MOHE-CRF-0074

//	out.println(dateList);

%>


<!-- <BODY onload="document.formPhMednOrderListCriteria.p_facility_code.focus();"> -->

<BODY onload="document.formPhMednOrderListCriteria.p_facility_code.focus();" onMouseDown="" onKeyDown="lockKey()">
<!--<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhMednOrderListCriteria.p_facility_code.focus();"> -->

<form name="formPhMednOrderListCriteria" id="formPhMednOrderListCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<TH COLSPAN="4"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr>
        <td class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3">&nbsp;<SELECT name="p_facility_code" id="p_facility_code" onChange="populateDispLocn(this.value)">
		   	<OPTION VALUE=" ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</OPTION>
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
	  </SELECT><img src="../../eCommon/images/mandatory.gif" align="center"></td> 
	</tr>
	
	
	<tr>
		<td width="25%" class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		<td COLSPAN="3" width="30%">&nbsp;<SELECT name="p_disp_loc_code" id="p_disp_loc_code">
		<OPTION VAlUE="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>
		
	   	</SELECT><img src="../../eCommon/images/mandatory.gif" align="center"></td>

	</tr>
	<tr>
		<td class="label" width="25%" nowrap><fmt:message key="ePH.OrderDateTimeFrom.label" bundle="${ph_labels}"/></td>
		<td width="30%" >&nbsp;<input type="text" maxlength="16" size="16" name="dt_from1" id="dt_from1" OnBlur='CheckDateT(this)'>&nbsp;<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('dt_from1',null,'hh:mm');document.formPhMednOrderListCriteria.dt_from1.focus();return false;" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!--Added for dt_from to dt_from1 for TTM-SCF-0089 [IN:047613]--></td> 
		<td class=" label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;<input type="text" maxlength="16" size="16" name="dt_to1" id="dt_to1" OnBlur='CheckDateT(this)'>&nbsp;<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('dt_to1',null,'hh:mm');document.formPhMednOrderListCriteria.dt_to1.focus();return false;"  >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td><!--Added for dt_from to dt_from1 for TTM-SCF-0089 [IN:047613]--></td> 
	</tr>
	<tr>
			<td  class="label" ><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></td>
			<td width="30%" >&nbsp;<select name="p_drug_class" id="p_drug_class">
					<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
					<option value="G"><fmt:message key="Common.general.label" bundle="${common_labels}"/></option>
					<option value="N"><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></option>
					<option value="C"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></option>
				</select>
			</td>
			<td class="label">&nbsp;</td>
	</tr>
	<tr>
		<td width="25%" class="label"><fmt:message key="ePH.DrugNameFrom.label" bundle="${ph_labels}"/></td>
		<td width="30%">&nbsp;<input type="text" name="drug_name_desc" id="drug_name_desc" maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="drug_search" id="drug_search"  onClick="callDrugSearch(document.formPhMednOrderListCriteria.drug_name_desc, 1)"></td>
		<input type="hidden" name="drug_code" id="drug_code" value="">
		<input type="hidden" name="drug_name" id="drug_name" value="">
		<td class="label" nowrap><fmt:message key="Common.to.label" bundle="${common_labels}"/>
		&nbsp;<input type="text" name="tdrug_name_desc" id="tdrug_name_desc" maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="tdrug_search" id="tdrug_search"  onClick="callDrugSearch(document.formPhMednOrderListCriteria.tdrug_name_desc, 2)"></td>
		<input type="hidden" name="tdrug_code" id="tdrug_code" value="">
		<input type="hidden" name="tdrug_name" id="tdrug_name" value="">
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.OrderStatus.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3">&nbsp;<select name="p_order_status" id="p_order_status" onchange='qryCreate(this);'>
					<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
					<option value="OS"><fmt:message key="Common.Outstanding.label" bundle="${common_labels}"/></option>
					<option value="IR"><fmt:message key="ePH.PartialSupply.label" bundle="${ph_labels}"/></option>
					<option value="CD"><fmt:message key="Common.Dispensed.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
   </tr>
   <tr>
		<td class="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<select name="p_order_by" id="p_order_by" onchange='showtypeoforder();'>
					<option value="">&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--&nbsp;</option>
					<option value="O"><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></option>
					<option value="P"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></option>
					<option value="T"><fmt:message key="ePH.TypeofOrder.label" bundle="${ph_labels}"/></option>
					<option value="D"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></option>
					</select>
		</td>
		<td align="left" class="label"  id='tp1' nowrap ><fmt:message key="ePH.TypeofOrder.label" bundle="${ph_labels}"/>&nbsp;
		<select name="p_type_of_order" id="p_type_of_order" disabled >
					
					<option value=" " selected><fmt:message key="Common.all.label" bundle="${common_labels}"/><fmt:message key="Common.Orders.label" bundle="${common_labels}"/></option>
					<option value="NOR"><fmt:message key="ePH.RxOrder.label" bundle="${ph_labels}"/></option>
					<option value="CO"><fmt:message key="ePH.CompoundingOrder.label" bundle="${ph_labels}"/> </option>
					<% ArrayList IVlegends = (ArrayList)bean1.getIVLegends();
	                	 if (IVlegends.size() > 0 )
				            for (int i=0; i<IVlegends.size(); i+=2) {
	                %>
			        <OPTION VALUE="<%= IVlegends.get(i) %>"><%= IVlegends.get(i+1) %></OPTION>

	                <% 	} %>  

					<option value="TD"><fmt:message key="ePH.TPNStandard.label" bundle="${ph_labels}"/></option>
					<option value="CD"><fmt:message key="ePH.OncologyOrder.label" bundle="${ph_labels}"/></option>
					<option value="TA"><fmt:message key="ePH.TPNAdmixture.label" bundle="${ph_labels}"/></option>
					<option value="CA"><fmt:message key="ePH.OncologyAdmixture.label" bundle="${ph_labels}"/></option>
					</select>
		
					
		</td>
 </tr>
	</table>
	
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%=bean_name%>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHMEDORLT">
	<INPUT TYPE="hidden" name="p_orderstatus_qry" id="p_orderstatus_qry" VALUE="">
	<INPUT TYPE="hidden" name="p_type_of_order_val" id="p_type_of_order_val" VALUE="">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="dt_from" id="dt_from"		VALUE=""><!--Added hidden var for TTM-SCF-0089 [IN:047613] -->
	<INPUT TYPE="hidden" name="dt_to" id="dt_to"		VALUE=""><!-- Added hidden var for TTM-SCF-0089 [IN:047613]-->
	
</form>
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
</body>
</html>

