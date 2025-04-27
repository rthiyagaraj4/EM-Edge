<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<LINK REL="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></LINK>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhRepPatFill.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" src="../../eCommon/js/CommonCalendar.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script src='../../eCA/js/CAMessages.js' language='javascript'></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<body  onLoad='PHrep();'>
<%
		String bean_id			= "PHRepDispStatisByDispBean" ;
		String bean_name		= "ePH.PHRepDispStatisByDispBean";
		String disabled="";
		String medicationlist_flag="";
		String sysdate="";
		String day_start_time = "00:00";
		String day_end_time = "23:59";
		HashMap p_dispensed_by=new HashMap();
		ArrayList practitioner_id=new ArrayList();
		ArrayList practitioner_name=new ArrayList();

		HashMap p_dispense_locn=new HashMap();
		ArrayList displocn_code=new ArrayList();
		ArrayList displocn_desc=new ArrayList();
		HashMap p_login_facility=new HashMap();
		ArrayList login_facility_code=new ArrayList();
		ArrayList login_facility_desc=new ArrayList();

		PHRepDispStatisByDispBean bean = (PHRepDispStatisByDispBean)getBeanObject( bean_id,bean_name, request) ;
		String facility_id=(String)session.getValue( "facility_id" );
		String order_facility_id="";
		String order_facility_name="";
		bean.setLanguageId(locale);
		bean.setLoginFacilityId(facility_id);
		sysdate=(String)bean.getSysdate();

		StringTokenizer str_tok_start_time = new StringTokenizer(day_start_time," ");
		StringTokenizer str2_start = null;
		String str2 = "";
		String hr = "";
		String min = "";
		while(str_tok_start_time.hasMoreTokens()){
			str2 = str_tok_start_time.nextToken();
			str2_start = new StringTokenizer(str2,":");
			hr = str2_start.nextToken();
			min = str2_start.nextToken();
		}
		day_start_time = hr+":"+min;

		StringTokenizer str_tok_end_time = new StringTokenizer(day_end_time," ");
		StringTokenizer str2_end = null;
		String str4 = "";
		String hr1 = "";
		String min1 = "";
		while(str_tok_end_time.hasMoreTokens()){
			str4 = str_tok_end_time.nextToken();
			str2_end = new StringTokenizer(str4,":");
			hr1 = str2_end.nextToken();
			min1 = str2_end.nextToken();
		}
		day_end_time = hr1+":"+min1;	

		p_dispensed_by=bean.populateDispensedBy();//facility_id
		practitioner_id=(ArrayList)p_dispensed_by.get("id");
		practitioner_name=(ArrayList)p_dispensed_by.get("name");

		//Dispense Location
		p_dispense_locn=bean.populateDispenselocn(facility_id);
		displocn_code=(ArrayList)p_dispense_locn.get("code");
		displocn_desc=(ArrayList)p_dispense_locn.get("desc");
		//Login Facility Add on date 16-03-2009  

		p_login_facility=bean.getOrderingFacilityId((String)session.getValue( "login_user" ),locale);
		login_facility_code=(ArrayList)p_login_facility.get("FACILITY_ID");
		login_facility_desc=(ArrayList)p_login_facility.get("FACILITY_NAME");
		medicationlist_flag= request.getParameter("medicationlist_flag");
		if(medicationlist_flag.equals("Y")){
		   disabled="disabled";
		 //  selected="selected";
		}
		else if(medicationlist_flag.equals("N")){
		   disabled="";
		  // selected="";
		}
		//added for HSA-CRF-0221 [IN:050539] - start
		String iv_with_additives	= "";
		String iv_without_additives = "";
		String iv_intermittent		= "";
		ArrayList ivLegends = bean.getIvLegends();
		if(ivLegends != null && ivLegends.size()>1){
			iv_with_additives		= (String)ivLegends.get(0);
			iv_without_additives	= (String)ivLegends.get(1);
			iv_intermittent			= (String)ivLegends.get(2);
		}
		//added for HSA-CRF-0221 [IN:050539] - end
%> 
		<FORM name="formPHRepPatFillCriteria" id="formPHRepPatFillCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
			<TABLE WIDTH="99%" ALIGN="center" CELLPADDING="2" CELLSPACING="0" BORDER="0">
				<TR>
<%
					if(medicationlist_flag.equals("Y")){
%>    
						<INPUT TYPE="hidden" name="report_by" id="report_by" VALUE="PHRPATMEDLIST">
<%
					}
					else if(medicationlist_flag.equals("N")){
%>
						<TD CLASS="label" ALIGN="right" width='15%'><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/></TD>
						<TD  align="left">&nbsp;&nbsp;<select name="report_by" id="report_by" <%=disabled%> onChange="loadPage(this.value,'<%=com.ehis.util.DateUtils.convertDate(sysdate,"DMY","en",locale)%>')">
						<option value="PATLAB"><fmt:message key="Common.PatientLabel.label" bundle="${common_labels}"/></option>
						<option value="SPLIST-A" selected><fmt:message key="ePH.SupplyList-Allocated.label" bundle="${ph_labels}"/></option>
						<option value="SPLIST-D"><fmt:message key="ePH.SupplyList-Dispensed.label" bundle="${ph_labels}"/></option>
						</select>
						</TD>
						<!-- //added for HSA-CRF-0221 [IN:050539] start -->
						<TD align="right"  class="label" id="iv_prep_type" style="visibility:visible" nowrap><fmt:message key="ePH.IvPrescriptionType.label" bundle="${ph_labels}"/></TD>
						<TD align="left" >&nbsp;&nbsp;
							<select name="p_order_type" id="p_order_type" <%=disabled%> >
							<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
							<option value="IVD"> <%=iv_with_additives%></option>
							<option value="IVWA"><%=iv_without_additives%></option>
							<option value="IVPB"><%=iv_intermittent%></option> 	
							</select>
						</TD>
						<!-- //added for HSA-CRF-0221 [IN:050539] end -->
<%
					}
%> 
				</TR>
				<tr id="patient_id_row" style='display:none'>
					<td  CLASS="label" align="right" nowrap width='15%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> &nbsp;</td>
					<td align="left" colspan="3">&nbsp;&nbsp;<input type="text" name="p_pat_id" id="p_pat_id" size="20" 
					maxlength="<%=bean.getPatientIDLength()%>" value="" onKeyPress="changeToUpper()" onblur="Duplicatecheck(this)"><!-- code 'chkPatientID();'  is replaced by 'Duplicatecheck()'  for ML-BRU-SCF-0621[IN036565]--> <INPUT TYPE="button" name="Patient_Button" id="Patient_Button" VALUE="?" CLASS="button"  onClick="callPatientLookup()" >
					</td>
				</tr>
		 		<TR id="disp_orderingFacility_row" style='display:none'>
					<TD align="right" class="label" nowrap width='15%'><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></TD>
					<TD  align="left"  colspan="3">&nbsp;
						<select id="ordering_facility" style="visibility:hidden"  name="p_ordering_facility_code" id="p_ordering_facility_code">
<%
						for(int i=0;i<login_facility_code.size();i++){
							order_facility_id=(String)login_facility_code.get(i);
							order_facility_name=(String)login_facility_desc.get(i);
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
%>
						</select> 
					</TD>
				</TR><!-- End Removed Readonly for the nursing unit from and to lookups====25492 incident-->
				<TR>
					<td align="right" class="label" width='15%'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>  <!--Added for ML-BRU-SCF-0498 [IN035593] begin-->
					<td class="label" colspan='3'>&nbsp;<select name="locn_type" id="locn_type" onChange="resetLocation()">
						<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
						<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
					</select>&nbsp;&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
				</tr>
				<tr>
					<TD align="right" class="label"  width='15%'><label id='lbl_locn_from'><fmt:message key="ePH.LocationForm.label" bundle="${ph_labels}"/></label></TD>
					<TD width='25%'><INPUT TYPE="text" STYLE='overflow:visible;' name="location_from" id="location_from"  value="" readonly><!-- maxlength='20' removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
					<INPUT TYPE="button" CLASS="button" VALUE="?"
					onClick="locationLookup(location_from)">
					<!-- onfocus="locationLookup(location_from)"  --> <!-- Commenting onfocus for ML-BRU-SCF-2218 -->
					
					<input type="hidden" name="p_fm_locn_code" id="p_fm_locn_code" value=""> <!--ML-BRU-SCF-0498 [IN035593]  end-->
					</TD>
					<TD CLASS="label" align="right"  width='5%'><label id='lbl_locn_to'><fmt:message key="Common.to.label" bundle="${common_labels}"/></label></TD>   <!--Label added for ML-BRU-SCF-0498 [IN035593]-->
					<TD align="left" width='*'>&nbsp;&nbsp;<INPUT TYPE="text" STYLE='overflow:visible;' name="location_to" id="location_to" value="" readonly><!-- maxlength='20' removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
					<INPUT TYPE="button" CLASS="button" VALUE="?" onClick="locationLookup(location_to)">
					<!-- onfocus="locationLookup(location_to)"  --><!-- Commenting onfocus for ML-BRU-SCF-2218 -->
					<input type="hidden" name="p_to_locn_code" id="p_to_locn_code" value="">
				</TR>
				<tr id="p_patient_id_row" style='display:none'>
					<td  class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td >
						<input type=text size="18" name="p_patient_id" id="p_patient_id"  maxlength="<%=bean.getPatientIDLength()%>"  onKeyPress="changeToUpper()" onblur="Duplicatecheck(this)"><!-- code 'chkPatientID();'  is replaced by 'Duplicatecheck()'  for ML-BRU-SCF-0621[IN036565]-->	<INPUT TYPE="button" name="Patient_Id_Button" id="Patient_Id_Button" VALUE="?" CLASS="button" onClick="callPatientSearch(document.formPHRepPatFillCriteria.p_patient_id)" >
					</td>
					<td  class="label"  nowrap><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/> <fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
					<td class="field"  colspan="3">&nbsp;
					<select name="P_FREQ_NATURE" id="P_FREQ_NATURE">
							<option value="A" ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
							<option value="P" ><fmt:message key="Common.PRN.label" bundle="${common_labels}"/></option>
							<option value="O" ><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
						</select>
					</td>
				</tr>
				<TR id="disp_date" style="visibility:hidden">
					<TD align="right" Class ="label"><fmt:message key="ePH.DispenseDate.label" bundle="${ph_labels}"/></TD>
					<TD  align="left"  >&nbsp;
					<input type="text" name="p_dispensed_date1" id="p_dispensed_date1"  size="13"  maxlength="10" value="<%=com.ehis.util.DateUtils.convertDate(sysdate,"DMY","en",locale)%>" OnBlur='CheckDate(this);getFillid(this);'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_dispensed_date1');getFillid(p_dispensed_date1);">
					<img src="../../eCommon/images/mandatory.gif" align="center"></img>
					</TD>
					<TD align="right" class="label" nowrap><fmt:message key="ePH.FillProcessID.label" bundle="${ph_labels}"/></TD>
					<TD  align="left"  colspan="3">&nbsp;
						<select  style="visibility:hidden"  name="p_fill_proc_id" id="p_fill_proc_id" onchange="clearTime();">
							<option value="">&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;</option>
						</select>
					</TD>
				</TR>
				<!--<TR id="disp_time" style="visibility:hidden">			
					<TD CLASS="label" ALIGN="right">Dispense Time From</TD>
					<TD align="left" >&nbsp;&nbsp;<input type="text" name="p_from_time" id="p_from_time"  size="13"  value="" maxlength="16" ><INPUT TYPE="image"  SRC="../../eCommon/images/CommonCalendar.gif"  id="From_Calendar" onclick="return showCalendar('p_from_time',null,'hh:mm');">
					</TD>
					<TD align="right" class="label">To</TD>
					<TD align="left" >&nbsp;&nbsp;<input type="text" name="p_to_time" id="p_to_time"  size="13"  value="" maxlength="16"><INPUT TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif" id="To_Calendar" onclick="return showCalendar('p_to_time',null,'hh:mm');">
							
					</TD>
				</TR> -->

				<tr id="disp_time" style="visibility:hidden">
					<td  class='label' align='right' nowrap><fmt:message key="ePH.DispenseTimeFrom.label" bundle="${ph_labels}"/></td>
					<td  CLASS='label' align='left'>&nbsp;<INPUT TYPE="text" name="p_from_time" id="p_from_time" size='6' value='<%=day_start_time%>' onblur='chkValidityOfTime(this)' maxlength='5' onkeypress='return CheckForNumsAndColon(event)'  ></td>
					<td class='label' align='right' nowrap><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td  CLASS='label' align='left'  colspan="3">&nbsp;<INPUT TYPE="text" name="p_to_time" id="p_to_time" size='6'  value='<%=day_end_time%>'  onblur='chkValidityOfTime(this)' onkeypress='return CheckForNumsAndColon(event)'  maxlength='5'></td>
				</tr>
				<!-- <tr  id="disp_time" style="visibility:hidden">
					<td width='40%' class='label' align='right'>Dispense Time From&nbsp;</td>
					<td width='60%' CLASS='label' align='left'>&nbsp;<INPUT TYPE="text" name="p_from_time" id="p_from_time" size='6' value='<%=day_start_time%>'  onblur='chkValidityOfTime(this)' maxlength='5' onkeypress='return CheckForNumsAndColon(event)'  >&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;To &nbsp;<INPUT TYPE="text" name="p_to_time" id="p_to_time" size='6'  value='<%=day_end_time%>' >
				</tr> -->
				<!--Add on date 16-03-2009  Dispensing Facility-->
				<TR id="disp_dispensingFacility_row" style="visibility:hidden">
					<TD align="right" class="label" id="disp_dispensingFacility_col"  nowrap>
					 <fmt:message key="ePH.DispensingFacility.label" bundle="${ph_labels}"/></TD>
					<TD  align="left"  colspan="5">&nbsp;
						<select id="disp_dispensingFacility" style="visibility:hidden"  name="p_disp_facility_code" id="p_disp_facility_code" onchange="fillDispLocation(document.formPHRepPatFillCriteria.p_disp_facility_code);">
<%
						for(int i=0;i<login_facility_code.size();i++){
							order_facility_id=(String)login_facility_code.get(i);
							order_facility_name=(String)login_facility_desc.get(i);
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
%>
						</select> 
					</TD>
				</TR>
				<TR id="disp_locn_row" style="visibility:hidden">
					<TD  class="label" id="disp_locn_lbl" style="visibility:hidden" nowrap><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></TD>
					<TD  align="left">&nbsp;
						<select  style="visibility:hidden"  name="p_disp_locn_code" id="p_disp_locn_code">
						<option value="">&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>  ---&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%
							for(int i=0;i<displocn_code.size();i++){
%>
							<option  VALUE="<%=displocn_code.get(i)%>"><%=displocn_desc.get(i) %></option>
<%
						}
%>
						</select>
					</TD>
					<TD " class="label" id="disp_by_lbl" style="visibility:hidden" nowrap><fmt:message key="ePH.DispensedBy.label" bundle="${ph_labels}"/></TD>
					<TD align="left"  colspan="3">&nbsp;
						<select name="p_dispensed_by" id="p_dispensed_by" style="visibility:hidden" >
						<option value="">&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%
						for(int i=0;i<practitioner_id.size();i++){
%>
						<option  VALUE="<%=practitioner_id.get(i)%>"><%=practitioner_name.get(i) %></option>
<%
						}
%>
						</select>
					</TD>
				</TR>
				<TR id="T1" style="visibility:hidden">
						<TD COLSPAN="4">&nbsp;</TD>
				</TR>
			</TABLE>
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%=bean_name%>">
			<INPUT TYPE="hidden" name="nunit_from" id="nunit_from" >
			<INPUT TYPE="hidden" name="nunit_to" id="nunit_to">
			<INPUT TYPE="hidden" name="p_fill_proc_id1" id="p_fill_proc_id1" value="">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="p_dispensed_date" id="p_dispensed_date" value="">
			<INPUT TYPE="hidden" name="medicationlist_flag" id="medicationlist_flag" value="<%=medicationlist_flag%>">
			<INPUT TYPE="hidden" name="medicationlist_flag1" id="medicationlist_flag1" value="<%=medicationlist_flag%>">
			<INPUT TYPE="hidden" name="SQL_PH_DISP_MEDICATION_SELECT32" id="SQL_PH_DISP_MEDICATION_SELECT32" value="<%=PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT32")%>">
			<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">   <!-- Added for ML-BRU-SCF-0498 [IN035593] -->
			<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">
			<% putObjectInBean(bean_id,bean,request); %>
		</FORM>
	</BODY>
</HTML>

