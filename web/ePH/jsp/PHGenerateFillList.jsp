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
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, java.text.*, java.lang.*, java.sql.*, ePH.*, ePH.Common.*, eCommon.Common.* ,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %> <!-- Modified for MOHE-CRF-0074 -->
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

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>
 -->	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PHReports.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT>
 -->	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/IPFill.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	String p_user_name= (String) session.getValue( "login_user" ) ;	
	String mode	= CommonRepository.getCommonKeyValue("MODE_INSERT");
Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	  con				= ConnectionManager.getConnection(request);
	  boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
	// Added for MOHE-CRF-0074 - END
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
	/* To get the dispense location based on the work station no */
	ArrayList dispLocn=bean.getDispenseLocation();
	ArrayList OrderingFacility=bean.getOrderingFacilityId(p_user_name);
	String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
	ArrayList region_code_check = bean.getRegionCheck(p_user_name,region_code); //Added for MOHE-CRF-0074
	//out.println("OrderingFacility----->"+OrderingFacility);
	if (dispLocn.size()==0){
%>
		<script>alert(getMessage("PH_FAC_CANNOT_ACCES","PH"));window.location.href =
'../../eCommon/jsp/dmenu.jsp'</script>
<%
	}
%>
<body> <!-- Added for MOHE-CRF-0074 -->
<FORM name="formPHGenerateFillList" id="formPHGenerateFillList"  TARGET="messageFrame" >
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
<INPUT TYPE="hidden" name="Exclude_Hrs" id="Exclude_Hrs" >
<INPUT TYPE="hidden" name="Disp_Locn" id="Disp_Locn" >
<!-- Values are set in hidden for hours and minutes of schedule start time .to make it easier to calculate in javascript -->
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
<TABLE name="FillTable" id="FillTable" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0" >
	<TR>
		<TD class="label"  ><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/>&nbsp;</TD>
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
			</select>
		</TD>
	</TR>
	<TR>
		<TH  ALIGN="left" COLSPAN=4 ><B><fmt:message key="ePH.MedicationDetails.label" bundle="${ph_labels}"/></B></TH>
	</TR>
	<TR>
		<TD  class="label" ><br><fmt:message key="Common.Orders.label" bundle="${common_labels}"/>&nbsp;</TD>
		<TD ALIGN="left"   >
			<br>
			<select name="iv_drug_ind" id="iv_drug_ind"   >
			<option value="N" selected ><fmt:message key="ePH.Medication.label" bundle="${ph_labels}"/>
				<!-- <option value="Y">IV Preparations -->
				<!-- <option value="B" selected>Both -->
			</SELECT>
		</TD>
		<TD class="label"  >
			<br><fmt:message key="ePH.Compound.label" bundle="${ph_labels}"/>&nbsp;
		</TD>
		<TD >
			<br>
			<select name="compound_drug_ind" id="compound_drug_ind" tabIndex="3">
				<option value="N"><fmt:message key="Common.single.label" bundle="${common_labels}"/>
				<option value="Y"><fmt:message key="ePH.Compound.label" bundle="${ph_labels}"/>
				<option value="B" selected><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
			</SELECT>
		</TD>
	</TR>
	<TR>
		<TD  class="label" colspan=3 style="display:none"><fmt:message key="ePH.ExcludeDrugswhereFillQtyisnotbyFrequency&Duration.label" bundle="${ph_labels}"/>&nbsp;</TD>
		<TD class="label" style="display:none"><input type=checkbox checked name="fillqtynotbyfreq" id="fillqtynotbyfreq" tabIndex="4"></TD>
	</TR>
	<TR>
		<TH ALIGN="left"   COLSPAN=4><B><fmt:message key="Common.NursingUnitDetails.label" bundle="${common_labels}"/></B></TH>
	</TR>
	<TR>
		<td class="label"><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/>&nbsp;</td>
		<td><select name="OrderingFacility" id="OrderingFacility" onChange="ClearNursingUnit()">
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
			}else{  //MOHE-CRF-0074-End
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
			}  //Added for MOHE-CRF-0074
		%></SELECT></td>
		<TD class="label"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></TD>
		<TD><select name="nursing_unit_or_locn" id="nursing_unit_or_locn" tabIndex="5" onChange="nursingUnitLocationChange(this,document)"><option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/><option value="L"><fmt:message key="Common.PhysicalLocation.label" bundle="${common_labels}"/>
		</SELECT></TD>
	</TR>
	<TR>
		<TD  class="label" id="NursingUnitLocnFromTD" name="NursingUnitLocnFromTD"   >
			<label ><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;</label></td>
		<td>
			<input type=text STYLE='overflow:visible;' name="Nursing_Unit_From" id="Nursing_Unit_From" tabIndex="6" onblur="NursingUnitSearch(document.formPHGenerateFillList.Nursing_Unit_From)"><!--size="40" maxlength="30" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
			<INPUT TYPE="button" name="Nursing_Unit_From_Button" id="Nursing_Unit_From_Button" VALUE="?" CLASS="button"  onClick="NursingUnitSearch(document.formPHGenerateFillList.Nursing_Unit_From)" tabIndex="7"><img name="PhysicalLocMandatory3" src="../../eCommon/images/mandatory.gif">
			<select name="Building_Code" id="Building_Code" tabIndex="10" onChange="populateData(this)" style="display:none;"  >
			<option value="" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
			</select>&nbsp;<img name="PhysicalLocMandatory1" src="../../eCommon/images/mandatory.gif" style="display:none;">
		</td>
		<td  class="label" id="NursingUnitLocnToTD"  name="NursingUnitLocnToTD"><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;</td>
		<td>
			<input type=text STYLE='overflow:visible;' name="Nursing_Unit_To" id="Nursing_Unit_To" tabIndex="8" onblur="NursingUnitSearch(document.formPHGenerateFillList.Nursing_Unit_To)"><!--size="40" maxlength="30" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
			<INPUT TYPE="button" name="Nursing_Unit_To_Button" id="Nursing_Unit_To_Button" VALUE="?" CLASS="button" onClick="NursingUnitSearch(document.formPHGenerateFillList.Nursing_Unit_To)" tabIndex="9">
			<select name="Floor_Code" id="Floor_Code" tabIndex="11" style="display:none;" ><option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option></select>&nbsp;
			<img name="PhysicalLocMandatory2" src="../../eCommon/images/mandatory.gif" style="display:none;">
		</td>
		</TD>
	</TR>
	<TR>
		<TD colspan=5>&nbsp;</TD>
	</TR>
	<TR>
		<TH ALIGN="left"  colspan=4><B><fmt:message key="ePH.FillIntervalDetails.label" bundle="${ph_labels}"/></B>
		</TH>
	</TR>
	<TR>
		<TD  class="label" ><br><fmt:message key="Common.ProcessType.label" bundle="${common_labels}"/>&nbsp;</TD>
		<TD ALIGN="left" colspan=3 align="right">
			<br>
			<select name="Proc_Type" id="Proc_Type" tabIndex="12" onChange="disableFillPeriod(this,document)">
			<option value="R"><fmt:message key="Common.routine.label" bundle="${common_labels}"/>
			<option value="I"><fmt:message key="ePH.Incremental.label" bundle="${ph_labels}"/>
			</SELECT>
		</td>
	</TR>
	<TR>
		<TD  class="label" >
			<label id="lbl_schedule_start"><fmt:message key="ePH.ScheduleStart.label" bundle="${ph_labels}"/></label>&nbsp;
		</TD>
		<td>
			<input type="text" name="schedule_start" id="schedule_start" readonly onblur="CalculateEndTime(document,document.formPHGenerateFillList.Proc_Type.value);">
			&nbsp;<IMG SRC="../../eCommon/images/CommonCalendar.gif"  id="schedule_start_cal" onclick="return showCalendar('schedule_start',null,'hh:mm');" >
		</td>
		<td  class="label" ><fmt:message key="ePH.FillPeriod.label" bundle="${ph_labels}"/>&nbsp;
		</td>
		<td>
			<select name="Ip_Fill_Prd_Ahead" id="Ip_Fill_Prd_Ahead" onChange="CalculateEndTime(document,'R');">
			<%
				for (int i=1;i<=no_of_days;i++){
			%>
				<option value="<%=24*i%>"><%=i%></option>
			<%
				}
			%>
			</select>
			<label id="FillPeriodUnit" class="label"  name="FillPeriodUnit"><b><fmt:message key="Common.days.label" bundle="${common_labels}"/><img name="FillPeriodMand" src="../../eCommon/images/mandatory.gif" ></b></label>
		</td>
		</TD>
	</TR>
	<TR>
		<TD  class="label" colspan=3 ><fmt:message key="ePH.ExcludeNewOrdersPlacedWithin.label" bundle="${ph_labels}"/>&nbsp; </td>
		<td >
			<input type="text" size=5 maxlength=2 name="ip_fill_excl_prd_behind" id="ip_fill_excl_prd_behind" disabled > <label class="label"><fmt:message key="ePH.HRS_SCH_START.label" bundle="${ph_labels}"/>&nbsp;</label>
		</TD>
	</TR>
	<TR>
		<TD  class="label" ><fmt:message key="ePH.EffectiveStartTime.label" bundle="${ph_labels}"/>&nbsp;
		</TD>
		<td>
			<input type="text"   name="fill_int_start_date_time" id="fill_int_start_date_time" disabled >
		</td>
		<td class="label" ><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/>&nbsp;
		</td>
		<td>
			<input type="text"  name="fill_int_end_date_time" id="fill_int_end_date_time" disabled  >
		</td>
		<!--	<script>CalculateEndTime(this.document,"R");</script>-->
	</TR>
	<TR>
		<TH ALIGN="left" colspan=4><B><fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></B></TH>
	</TR>
	<TR>
		<TD  class="label"   >
			<br>
			<fmt:message key="ePH.AllocateBatchesDuringFill.label" bundle="${ph_labels}"/>&nbsp;
		</td>
		<TD colspan=2  align="left">
		<br>
		<input type=checkbox name=allocate_during_fill_yn tabIndex="13" disabled >
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<label class="label" ><fmt:message key="ePH.OrderByForReferencing.label" bundle="${ph_labels}"/></label>&nbsp;
		</TD>
		<TD >
		<br>
		<select name="order_by_for_list" id="order_by_for_list" tabIndex="14" >
		<option value='B'><fmt:message key="ePH.NursingUnitBedNo.label" bundle="${ph_labels}"/></option>
		<option value='P'><fmt:message key="ePH.NursingUnitPatientId.label" bundle="${ph_labels}"/></option></td>
		</TD>
	</TR>
	<tr>
	<tD colspan=4 align="right">
		<br>
		<input type=button class="button" value='<fmt:message key="ePH.ViewFillList.label" bundle="${ph_labels}"/>' onClick="viewFillList()">&nbsp;
		<input type=hidden  name="temp_fill_prd_ahead" id="temp_fill_prd_ahead" value="">&nbsp;
	</td>
	</tr>
	</TABLE>
</FORM>
</BODY>
<script>disableAll(true)</script>
<% putObjectInBean(bean_id,bean,request); 

} // Added for MOHE-CRF-0074 - start
	catch(Exception e){
		e.printStackTrace();
	}
	finally{ 
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	}
%>  <!--  Added for MOHE-CRF-0074 - End -->
</HTML>

