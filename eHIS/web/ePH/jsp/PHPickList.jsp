<!DOCTYPE html>
<!--File is Created by Himanshu saxena against GHL-CRF-0672.1 on 13-30-2024
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
 13-30-2024		GHL-CRF-0672.1       Himanshu saxena          GHL-CRF-0672.1
---------------------------------------------------------------------------------------------------------------
*/
-->

<%@page contentType="text/html;charset=UTF-8" import="java.util.*, java.text.*, java.lang.*, java.sql.*, ePH.*, ePH.Common.*, eCommon.Common.* ,webbeans.eCommon.*" %> <!-- Modified for MOHE-CRF-0074 -->
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>
 -->	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PHReports.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhMessages.js"></SCRIPT>
 -->	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PHPickList.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>

</HEAD>
<%
	request.setCharacterEncoding("UTF-8");

	String locale			= (String)session.getAttribute("LOCALE");
	String p_user_name= (String) session.getValue( "login_user" ) ;	
	String mode	= CommonRepository.getCommonKeyValue("MODE_INSERT");
Connection con			= null;  
try{
	  con				= ConnectionManager.getConnection(request);
	  boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
	String bean_id = "IpFillBean" ;
	String bean_name = "ePH.IpFillBean";
	/* Initialize Function specific start */
	IpFillBean bean = (IpFillBean)getBeanObject(bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	int no_of_days    = bean.getMaxDurnForIPPres();
	String logged_fcy = bean.getLoggedInFacility();
	String dispLocnCode=null;
	String dispLocnDesc=null;
	String facility_id=bean.getLoggedInFacility();
	String order_facility_id=null;
	String order_facility_name=null;

	/* Checking if user is a Pharmacist */
	int continueop=bean.validatePharmacist();
	if (continueop==0){
%>
	<script>alert(getMessage("PH_USER_NOT_A_PHARMACIST","PH"));window.location.href =
'../../eCommon/jsp/dmenu.jsp'</script>
<%
	}
	ArrayList dispLocn=bean.getDispenseLocation();
	ArrayList OrderingFacility=bean.getOrderingFacilityId(p_user_name);
	String region_code = bean.getRegionCode(); // 
	ArrayList region_code_check = bean.getRegionCheck(p_user_name,region_code); // 
	//out.println("OrderingFacility----->"+OrderingFacility);
	if (dispLocn.size()==0){
%>
		<script>alert(getMessage("PH_FAC_CANNOT_ACCES","PH"));window.location.href =
'../../eCommon/jsp/dmenu.jsp'</script>
<%
	}
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" > <!--   -->
<FORM name="formPHPickList" id="formPHPickList"  TARGET="messageFrame" >
<br>
<INPUT TYPE="hidden" name="mode" id="mode"		VALUE="<%= mode %>">
<INPUT TYPE="hidden" name="bean_id" id="bean_id"		VALUE="<%= bean_id %>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name"	VALUE="<%= bean_name %>">
<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%= bean.getFunctionId() %>">
<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= logged_fcy %>">
<INPUT TYPE="hidden" name="nursing_unit_query" id="nursing_unit_query" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_NURSINGUNIT_LOOKUP" ) %>">
<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
<INPUT TYPE="hidden" name="Nursing_Unit_From_Code" id="Nursing_Unit_From_Code">
<INPUT TYPE="hidden" name="Nursing_Unit_To_Code" id="Nursing_Unit_To_Code" >
<INPUT TYPE="hidden" name="Default_Fill_Period" id="Default_Fill_Period" >
<INPUT TYPE="hidden" name="Schedule_Start_Time_Routine" id="Schedule_Start_Time_Routine" >
<INPUT TYPE="hidden" name="schedule_start" id="schedule_start" >
<INPUT TYPE="hidden" name="Ip_Fill_Prd_Ahead" id="Ip_Fill_Prd_Ahead" >
<INPUT TYPE="hidden" name="Exclude_Hrs" id="Exclude_Hrs" >
<INPUT TYPE="hidden" name="Disp_Locn" id="Disp_Locn" >
<INPUT TYPE="hidden" name="cDate" id="cDate" >
<INPUT TYPE="hidden" name="cMonth" id="cMonth">
<INPUT TYPE="hidden" name="cYear" id="cYear" >
<INPUT TYPE="hidden" name="cHours" id="cHours">
<INPUT TYPE="hidden" name="cMinutes" id="cMinutes">
<INPUT TYPE="hidden" name="currHours" id="currHours">
<INPUT TYPE="hidden" name="currMinutes" id="currMinutes">
<INPUT TYPE="hidden" name="Fill_Period_Unit" id="Fill_Period_Unit">
<INPUT TYPE="hidden" name="cut_off_limit_for_new_ord" id="cut_off_limit_for_new_ord">
<INPUT TYPE="hidden" name="routinefillalreadyinvoked" id="routinefillalreadyinvoked">
<INPUT TYPE="hidden" name="incstarttime" id="incstarttime">
<INPUT TYPE="hidden" name="incendtime" id="incendtime">
<INPUT TYPE="hidden" name="nursing_unit_or_locn" id="nursing_unit_or_locn" value="N">
<INPUT TYPE="hidden" name="compound_drug_ind" id="compound_drug_ind" value="B">
<TABLE name="FillTable" id="FillTable" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0" >
	<TR>
		<TD class="label" ALIGN="right"  ><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/>&nbsp;</TD>
		<TD ALIGN="left" COLSPAN=3>
			<select name="disp_locn_code" id="disp_locn_code" width=15 onChange="submitDispense(this.value)">
			<option value="">&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
		<%
			for (int i=0;i<dispLocn.size();i+=2){
				dispLocnCode=(String)dispLocn.get(i);
				dispLocnDesc=(String)dispLocn.get(i+1);
		%>
			<option value='<%=dispLocnCode%>'><%=dispLocnDesc%>
		<%
			}
		%>
			</select><img name="PhysicalLocMandatory3" src="../../eCommon/images/mandatory.gif">
		</TD>
	</TR>
	
	<TR>
		<TH ALIGN="left"   COLSPAN=4><B><fmt:message key="Common.NursingUnitDetails.label" bundle="${common_labels}"/></B></TH>
	</TR>
	<TR>
		<td class="label"><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/>&nbsp;</td>
		<td><select name="OrderingFacility" id="OrderingFacility" >
		   <%
		//MOHE-CRF-0074-Start 
			if(region_check){
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
			}else{  
			for (int i=0;i<OrderingFacility.size();i+=2){
				order_facility_id=(String)OrderingFacility.get(i);
				order_facility_name=(String)OrderingFacility.get(i+1);
				 if(facility_id.equals(order_facility_id))	{
		%>
			<option value='<%=order_facility_id%>'selected><%=order_facility_name%></option>
			
		<%}else{%>
		   	  <option value='<%=order_facility_id%>'><%=order_facility_name%></option>
		   <%}
		}
			} 
		%></SELECT></td>
		
	</TR>
	<TR>
		<td class="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;</td>
			<td><input type=text  name="Nursing_Unit" id="Nursing_Unit" onblur="NursingUnitSearch(document.formPHPickList.Nursing_Unit)" ><INPUT TYPE="button" name="Nursing_Unit_Button" id="Nursing_Unit_Button" VALUE="?" CLASS="button"  onClick="NursingUnitSearch(document.formPHPickList.Nursing_Unit)" ><img name="PhysicalLocMandatory3" src="../../eCommon/images/mandatory.gif"></td>
	</TR>
	<TR>
		<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</td>
			<td><input type=text  name="patient_id" id="patient_id" ><INPUT TYPE="button" name="patient_id_Button" id="patient_id_Button" VALUE="?" CLASS="button"  onClick="callPatientSearch(document.formPHPickList.patient_id)"></td>
	</TR>
	<TR>
		<TD colspan=5>&nbsp;</TD>
	</TR>
	<TR>
		<TH ALIGN="left"  colspan=4><B><fmt:message key="ePH.FillIntervalDetails.label" bundle="${ph_labels}"/></B>
		</TH>
	</TR>
	<TR>
		<TD ALIGN="right" class="label" ><fmt:message key="ePH.EffectiveStartTime.label" bundle="${ph_labels}"/>&nbsp;
		</TD>
		<td>
			<input type="text"   name="fill_int_start_date_time" id="fill_int_start_date_time" disabled >
		</td>
		<td ALIGN="right" class="label" ><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/>&nbsp;
		</td>
		<td>
			<input type="text"  name="fill_int_end_date_time" id="fill_int_end_date_time" disabled  >
		</td>
	</TR>
	
	
	<tr>
	<tD colspan=4 align="right">
		<br>
		<input type=button class="button" value='<fmt:message key="ePH.ViewPickList.label" bundle="${ph_labels}"/>' onClick="viewpickList()">&nbsp;
		<input type=hidden  name="temp_fill_prd_ahead" id="temp_fill_prd_ahead" value="">&nbsp;
	</td>
	</tr>
	</TABLE>
</FORM>
</BODY>
<script>
//disableAll(true)
</script>
<% putObjectInBean(bean_id,bean,request); 

} 
	catch(Exception e){
		e.printStackTrace();
	}
	finally{ 
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	}
%>  
</HTML>
 

