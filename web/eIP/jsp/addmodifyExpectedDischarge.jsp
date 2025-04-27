<!DOCTYPE html>
<!--***** Expected Discharge  -- 20 July 2001 *******---> 
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,com.ehis.util.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML>
<HEAD>
<TITLE> <fmt:message key="Common.CancelAdmission.label" bundle="${common_labels}"/> </TITLE>	

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
	<script src="../../eIP/js/ExpectedDischarge.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	 
</HEAD>
<%	

Connection con	= null;
try
{
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale			= (String)session.getAttribute("LOCALE");
	
	
	Statement stmt	= null;
	ResultSet rs	= null;
 	
	String facilityID	= (String)session.getValue("facility_id");
	String encounterID	= request.getParameter("encounter_id");
	String patientID	= request.getParameter("patient_id");
	String blinstall	= request.getParameter("bl_instal");
	String call_function= request.getParameter("call_function");
	
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
	java.util.Date dt = new java.util.Date();
	String dateVal = dateFormat.format( dt ) ;
	dateVal=dateVal + " "+String.valueOf(dt.getHours())+":"+String.valueOf(dt.getMinutes());

	con = ConnectionManager.getConnection(request);
	String admissiondatetime = "";
	String adm_date_display = "";
	String admissiontypedesc = "";
	String specialtyshortdesc = "";
	String practitionername = "";
	String nursingunitshortdesc = "";
	String serviceshortdesc = "";
	String bedno = "";
	String roomno = "";
	String bedclassshortdesc = "";
	String bedtypeshortdesc  = "";
	String dlycharge = "";
	String nursing_unit_code = "";
	String expdischargedatetime = "";
	String exp_surgery_date_time = "";
	String tot_outst_ip_amt ="0";
	String black_listed_yn = "";
	String chk="";
	String systdate ="";
	String patient_class ="";
	String disc_date ="";
	String valid_date ="";
	String valid ="";
//	String max_disch_period_for_dc ="";
	StringBuffer sqlQuery = new StringBuffer();
	String expdischargedatetime_converted = "";
	String exp_surgery_date_time_converted = "";
	String serv_code	= "";
	String subserv_code = "";
	String from_time = "";
	String from_time_converted = "";

	/*try
	{
		stmt=con.createStatement();
		if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
		sqlQuery.append("select max_disch_period_for_dc from ip_param where FACILITY_ID='"+facilityID+"'");
		rs=stmt.executeQuery(sqlQuery.toString());

		if(rs.next())
		{
			max_disch_period_for_dc = rs.getString("max_disch_period_for_dc");
		}
	}catch(Exception e) {
		//out.println(e.toString());
		e.printStackTrace();
		}

	if(rs !=null)		rs.close(); 
	if(stmt != null)	stmt.close();
*/
	try
	{
		stmt=con.createStatement();
		if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());

		sqlQuery.append("Select to_char(a.admission_date_time,'dd/mm/rrrr HH24:mi') ");
		sqlQuery.append(" admission_date_time, to_char((a.admission_date_time+(b.max_disch_period_for_dc/24)),'dd/mm/rrrr HH24:mi') disc_date, a.encounter_id, ip_get_desc.ip_admission_type(a.ADMISSION_TYPE, '"+locale+"',2) admission_short_desc,");
		sqlQuery.append(" (CASE WHEN TRUNC(a.admission_date_time+(1/24)*b.max_disch_period_for_dc) != TRUNC(a.admission_date_time) THEN 'N' ELSE 'Y' END ) VALID, ");
		sqlQuery.append(" TO_CHAR((CASE WHEN TRUNC(a.admission_date_time + (1/24)*b.max_disch_period_for_dc) != TRUNC(a.admission_date_time) THEN trunc(a.admission_date_time) ELSE TO_DATE(a.admission_date_time, 'dd/mm/rrrr hh24:mi')+ (1 / 24) * b.max_disch_period_for_dc END), 'dd/mm/rrrr') VALID_DATE, ");
		sqlQuery.append(" am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc, ");
		sqlQuery.append(" am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_name, null patient_type_short_desc,");
		sqlQuery.append(" ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc, am_get_desc.am_service(a.service_code,'"+locale+"',2) service_short_desc, a.service_code, a.SUBSERVICE_CODE, a.patient_class, a.nursing_unit_code,");
		sqlQuery.append(" a.bed_num bed_no, a.room_num room_no, ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2) bed_type_short_desc, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc, null dly_charge, ");
		sqlQuery.append("to_char(a.exp_discharge_date_time,'dd/mm/rrrr hh24:mi') exp_discharge_date_time, ");
		sqlQuery.append(" to_char(sysdate,'dd/mm/rrrr hh24:mi') systdate, TO_CHAR((SELECT MAX (trn_date_time) FROM IP_ADT_TRN WHERE facility_id = a.facility_id AND encounter_id = a.encounter_id), 'dd/mm/rrrr hh24:mi') FROM_TIME");
		sqlQuery.append(" from IP_OPEN_ENCOUNTER a, ip_param b where a.facility_id = '"+facilityID+"' and ");
		sqlQuery.append(" a.encounter_id= "+encounterID+" and a.facility_id = b.facility_id");	

		rs=stmt.executeQuery(sqlQuery.toString()); 

		if(rs.next())
		{
			admissiondatetime 	= checkForNull(rs.getString("admission_date_time"));
			if(!(admissiondatetime.equals("") || admissiondatetime == null))
				adm_date_display	= DateUtils.convertDate(admissiondatetime,"DMYHM","en",locale);
			admissiontypedesc 	= checkForNull(rs.getString("admission_short_desc"));
			specialtyshortdesc 	= checkForNull(rs.getString("specialty_short_desc"));	
			practitionername 	= checkForNull(rs.getString("practitioner_name"));	
			nursingunitshortdesc= checkForNull(rs.getString("Nursing_unit_short_desc"));	
			serviceshortdesc 	= checkForNull(rs.getString("service_short_desc"));
			bedno 				= checkForNull(rs.getString("bed_no"));
			roomno 				= checkForNull(rs.getString("room_no"));
			bedclassshortdesc 	= checkForNull(rs.getString("bed_class_short_desc"));
			bedtypeshortdesc 	= checkForNull(rs.getString("BED_TYPE_SHORT_DESC"));
			dlycharge 			= checkForNull(rs.getString("dly_charge"));		
			encounterID	 		= checkForNull(rs.getString("encounter_id"));	
			nursing_unit_code 	= checkForNull(rs.getString("nursing_unit_code"));
			patient_class 		= checkForNull(rs.getString("patient_class"));
			disc_date 			= checkForNull(rs.getString("disc_date"));
			valid 				= checkForNull(rs.getString("VALID"));
			valid_date			= checkForNull(rs.getString("VALID_DATE"));
			serv_code			= checkForNull(rs.getString("service_code"));
			subserv_code		= checkForNull(rs.getString("SUBSERVICE_CODE"));
			expdischargedatetime = checkForNull(rs.getString("exp_discharge_date_time"));
			if(!(expdischargedatetime.equals("") || expdischargedatetime == null))
				expdischargedatetime_converted = DateUtils.convertDate(expdischargedatetime,"DMYHM","en",locale); 
			from_time = checkForNull(rs.getString("from_time"));
			if(!(from_time.equals("") || from_time == null))
				from_time_converted = DateUtils.convertDate(from_time,"DMYHM","en",locale); 
			systdate			 = checkForNull(rs.getString("systdate"));
 		}

		//valid_date = valid_date+ " 23:59";
		valid_date = disc_date; //Modified for AAKH-SCF-0093
		

		if(rs !=null)		rs.close(); 
		if(stmt != null)	stmt.close();

		if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());

		if(call_function.equals("REC_EXP_PROC_DATE"))
		{
			sqlQuery.append(" Select to_char(b.OT_DATE_TIME,'dd/mm/rrrr hh24:mi')exp_surgery_date_time from ip_adt_trn b where  b.facility_id = '"+facilityID+"' and  b.encounter_id= '"+encounterID+"' ");

			stmt=con.createStatement();
			rs=stmt.executeQuery(sqlQuery.toString());
			
			if(rs.next())
			{	
				exp_surgery_date_time = checkForNull(rs.getString("exp_surgery_date_time"));
				if(!(exp_surgery_date_time.equals("") || exp_surgery_date_time == null))
						exp_surgery_date_time_converted = DateUtils.convertDate(exp_surgery_date_time,"DMYHM","en",locale); 
			}

			if(rs !=null) rs.close(); 
			if(stmt != null) stmt.close();
		}

		if(blinstall.equals("Y"))
		{
			try
			{
	
			if(sqlQuery.length()>0) sqlQuery.delete(0,sqlQuery.length());
			sqlQuery.append("SELECT TO_CHAR(NVL(TOT_OUTST_IP_AMT,0)) TOT_OUTST_IP_AMT, ");
			sqlQuery.append(" BLACK_LISTED_YN, FINANCIAL_REMARKS FROM BL_PATIENT_FIN_DTLS WHERE PATIENT_ID = '"+patientID+"'");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlQuery.toString());
			if(rs.next())
			{
				tot_outst_ip_amt	= checkForNull(rs.getString("TOT_OUTST_IP_AMT"),"0");
				black_listed_yn		= checkForNull(rs.getString("BLACK_LISTED_YN"));
			}
			if(rs !=null) rs.close(); if(stmt != null) stmt.close();
			if(black_listed_yn.equals("Y"))
			{
				chk="checked";
			}
			else if(black_listed_yn.equals("N"))
			{
				chk="";
			}
			}catch(Exception e)
			{
//out.println("Exception :"+e);
e.printStackTrace();
			}
		} 
	}catch(Exception e) {
		//out.println(e.toString());
		e.printStackTrace();}
%>

<BODY <% if(call_function!=null && !call_function.equals("MODIFY_SERVICE_FOR_INPATIENT")){%> <%}%> onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='expecteddischarge_form' id='expecteddischarge_form'  method='post' target="messageFrame"> 
<table border='0' cellpadding='5' cellspacing='0' width='100%' align='center'>
 <TR><td class="columnheader" colspan='4' ><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></td> </TR>
 <TR> 
	  <TD class='label' nowrap width='25%'><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></TD>
	  <TD class='QUERYDATA'  nowrap width='25%'><%=adm_date_display%><input type='hidden' name='admissiondatetime' id='admissiondatetime' value="<%=admissiondatetime%>"></TD> 
	  <TD class='label' nowrap width='25%'><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></TD>
	  <TD class='QUERYDATA' nowrap width='25%'><%=admissiontypedesc%><input type='hidden' name='admissiontypedesc' id='admissiontypedesc' value="<%=admissiontypedesc%>"></TD> 	
 </TR>
 <tr>
	  <TD class='label' nowrap ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></TD>
	  <TD class='QUERYDATA'   nowrap colspan=3><%=encounterID%><input type='hidden' name='encounterID' id='encounterID' value="<%=encounterID%>"></TD> 
 </tr>
  <TR>
	  <TD class='label' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></TD>
	  <TD class='QUERYDATA' nowrap ><%=specialtyshortdesc%></TD>
	  <TD class='label' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></TD>
	  <TD class='QUERYDATA' ><%=practitionername%></TD> 	
	  
 </TR>

 <td class="columnheader" colspan='4' ><fmt:message key="Common.NursingUnitDetails.label" bundle="${common_labels}"/></td>
	<TR>
	  <TD class='label' width='10%'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></TD>
	  <TD class='QUERYDATA' nowrap ><%=nursingunitshortdesc%>
	  	<input type='hidden' name='nursingunitshortdesc' id='nursingunitshortdesc' value="<%=nursing_unit_code%>">
	  </TD> 
  	  <% if(call_function.equals("MODIFY_SERVICE_FOR_INPATIENT")){%>	  
	  <TD colspan='2'  class='label'></TD>	 
	   <%}else {%>
	  <TD class='label' width='10%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></TD>
	  <TD colspan='1' class='QUERYDATA' nowrap ><%=serviceshortdesc%></TD> 
	  <%}%>
	  </TR>
	  <TR>
	   <TD class='label' ><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></TD>
	  <TD colspan='1' class='QUERYDATA' nowrap ><%=bedno%>
	  	<input type='hidden' name='bedno' id='bedno' value="<%=bedno%>"> </TD>
	  <TD class='label' ><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></TD>
	  <TD class='QUERYDATA' nowrap ><%=roomno%>
	  	<input type='hidden' name='roomno' id='roomno' value="<%=roomno%>"> </TD> 
 </TR>
 <TR>
 
	  <TD class='label' ><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></TD>
	  <TD class='QUERYDATA' nowrap ><%=bedclassshortdesc%>
	  	<input type='hidden' name='bedclassshortdesc' id='bedclassshortdesc'>
	  </TD> 

	  <TD class='label' ><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></TD>
	  <TD class='QUERYDATA' nowrap ><%=bedtypeshortdesc%>
	  	<input type='hidden' name='bedtypeshortdesc' id='bedtypeshortdesc'>
	  </TD> 

	</TR>   
	

<%	
	if(call_function.equals("MODIFY_SERVICE_FOR_INPATIENT"))
	{
	%>
	<TR>
	  <td class="label" width='10%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
	  <td class='fields'><select name="service" id="service"  onChange='PopulateSubService()'>
	  <option value="">-----&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;-----</option>

	  <%
				String sel="";
				String service_code=""; String service_desc ="";
				if(sqlQuery.length() > 0 ) sqlQuery.delete(0,sqlQuery.length());
								
				sqlQuery.append("SELECT" );
				sqlQuery.append("  service_code" );
				sqlQuery.append("  , AM_GET_DESC.AM_SERVICE(service_code,'"+locale+"','2') service_short_desc " );
				sqlQuery.append("FROM" );
				sqlQuery.append("  IP_NURS_UNIT_FOR_SERVICE " );
				sqlQuery.append("WHERE facility_id = '"+facilityID+"' " );
				sqlQuery.append("  AND nursing_unit_code = '"+nursing_unit_code+"' " );
				sqlQuery.append("UNION" );
				sqlQuery.append("  " );
				sqlQuery.append("SELECT" );
				sqlQuery.append("  service_code" );
				sqlQuery.append("  , AM_GET_DESC.AM_SERVICE(service_code,'"+locale+"','2') service_short_desc " );
				sqlQuery.append("FROM" );
				sqlQuery.append("  IP_NURSING_UNIT " );
				sqlQuery.append("WHERE facility_id = '"+facilityID+"' " );
				sqlQuery.append("  AND nursing_unit_code = '"+nursing_unit_code+"' " );
				sqlQuery.append("ORDER BY" );
				sqlQuery.append("  2" );
				
			try
			 {
					   stmt = con.createStatement();
					   rs = stmt.executeQuery(sqlQuery.toString());
						if(rs!=null )
						{
							while(rs.next())
							{
								service_code  = rs.getString("service_code");
								service_desc = rs.getString("service_short_desc");
								
								if (service_code.equals(serv_code))
									sel = "selected";
								else
									sel = "";

								out.print("<option value=\""+service_code+"\" "+sel+">"+service_desc+"");
							}
						}
						if (rs != null) rs.close();
						if (stmt != null) stmt.close();
			 }
			 catch(Exception e) {out.println(e.toString());}
	  %>
			</select><img src="../../eCommon/images/mandatory.gif">
			</td>
			<td class="label" ><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name="sub_service" id="sub_service" ><option value="">-----&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;-----</option>
			<%	
			try
			{
				String subservice_code = "", subservice_desc = "",subsel = "";
				 
				if(sqlQuery.length() > 0 ) sqlQuery.delete(0,sqlQuery.length());

			   
				sqlQuery.append("SELECT" );
				sqlQuery.append("  service_code" );
				sqlQuery.append("  ,am_get_desc.am_service(service_code,'"+locale+"',2) service_short_desc" );
				sqlQuery.append("  , subservice_code" );
				sqlQuery.append("  ,am_get_desc.am_subservice(service_code,subservice_code,'"+locale+"',2) subservice_short_desc " );
				sqlQuery.append("FROM" );
				sqlQuery.append("  AM_FACILITY_SUBSRVC " );
				sqlQuery.append("WHERE operating_facility_id = '"+facilityID+"' " );
				sqlQuery.append("  AND service_code = '"+serv_code+"' " );
				sqlQuery.append("  AND eff_status = 'E' " );
				sqlQuery.append("ORDER BY" );
				sqlQuery.append("  2 " );


				stmt = con.createStatement();
				rs = stmt.executeQuery(sqlQuery.toString());
				if(rs!=null)
				{
					while(rs.next())
					{
					subservice_code  = rs.getString("subservice_code");
					subservice_desc = rs.getString("subservice_short_desc");

					if (subservice_code.equals(subserv_code))
						subsel = "selected";
					else
						subsel = "";
					out.print("<option value=\""+subservice_code+"\" "+subsel+">"+subservice_desc+"");
					}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				}
			}catch(Exception e)
			{
				//out.println("<script>alert('Exception : "+e.toString()+"');</script>");
				e.printStackTrace();
			}
			
			%>
			</select>
			<input type= 'hidden' name='patient_id' id='patient_id' value="<%=patientID%>">
			<input type= 'hidden' name='encounter_id' id='encounter_id' value="<%=encounterID%>">
			</td>
			</TR>
<%
	}
	else if(call_function.equals("REC_EXP_PROC_DATE"))
	{	%>
	<TR>     
		<TD class='label' nowrap ><fmt:message key="eIP.ProcedureSurgeryDateTime.label" bundle="${ip_labels}"/></TD>
		<TD class="fields"><input type='text'  onKeyPress='return(ChkNumberInput1(this,event,2))' name='proc_surgery_date' id='proc_surgery_date' value = "<%=exp_surgery_date_time_converted%>" size = "16" maxlength="16"  <%if(patient_class.equals("DC")){%>onBlur="valSurgeryDate(this,'DC');" <%}else{%>onBlur="valSurgeryDate(this,'A');"<%}%>><img name='prefdt' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('proc_surgery_date',null,'hh:mm');" />&nbsp<img src='../../eCommon/images/mandatory.gif'align='center'></img><input type="hidden" name="sdate" id="sdate" value="<%=systdate%>"></TD>
		<TD colspan='2'></TD>
	</TR>
<%	}
	else if(!call_function.equals("MODIFY_SERVICE_FOR_INPATIENT"))
	{	%>
	<TR>     
		<TD class='label' nowrap  ><fmt:message key="eIP.ExpectedDischargeDateTime.label" bundle="${ip_labels}"/></TD>
		<TD class="fields"><input type='text'  onKeyPress='return(ChkNumberInput1(this,event,2))' name='expected_discharge_date' id='expected_discharge_date' value = "<%=expdischargedatetime_converted%>" size = "16" maxlength="16"  <%if(patient_class.equals("DC")){%>onBlur="validateTimeDate(this,'DC');" <%}else{%>onBlur="validateTimeDate(this,'A');"<%}%>><img  name='prefdt' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('expected_discharge_date',null,'hh:mm');"/>&nbsp<img src='../../eCommon/images/mandatory.gif'align='center'></img><input type="hidden" name="sdate" id="sdate" value="<%=systdate%>"></TD>
		<TD colspan='2'></TD>
	</TR>
<%	}	%>

<%	if(blinstall.equals("Y") && !call_function.equals("MODIFY_SERVICE_FOR_INPATIENT"))
	{
	%>
	 <td class="columnheader" colspan='4' ><fmt:message key="Common.BillingDetails.label" bundle="${common_labels}"/></td>
		<tr>
			<td  class="label" nowrap><fmt:message key="Common.outstandingamount.label" bundle="${common_labels}"/></td>
			<TD class='QUERYDATA'  ><%=tot_outst_ip_amt%></td>
			<td  class="label"  nowrap><fmt:message key="eIP.BlackListed.label" bundle="${ip_labels}"/></td>
			<td class="fields"><input type='checkbox' name='black_listed_yn' id='black_listed_yn' disabled value="<%=black_listed_yn%>"<%=chk%>></td>
		</tr>
		<TR>
      	  <td  class="label"></td>
		  <td  class="label"></td>
		  <td  class="label"></td>
      	  <TD class="fields"><input type=button class='button' name = 'apply' id='apply' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' onClick='CancelAdm(this)' ><input type=button class='button' name = 'cancel'  id = 'cancel' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>"  onClick='CloseWin(this)'></TD>
	 </TR> 
<%	}
	else
	{	%>	
		<TR>
			<td class="label"></td>
			<td class="label"></td>
			<td class="label"></td>
			<TD class="fields" ><input type=button class='button' name = 'apply' id ='apply' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>"  onClick='CancelAdm(this)' ><input type=button class='button' name = 'cancel' id = 'cancel' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='CloseWin(this)'></TD>
		</TR> 
<%	}	%>
		
</table>
	<input type= 'hidden' name='currdate' id='currdate' value="<%=dateVal%>">
	<input type= 'hidden' name='val_disc_date' id='val_disc_date' value="<%=disc_date%>">
	<input type= 'hidden' name='tempexpdischargedatetime' id='tempexpdischargedatetime' value = "<%=expdischargedatetime%>">

	<input type='hidden' name="valid" id="valid" value="<%=valid%>">
	<input type='hidden' name="max_param_date" id="max_param_date" value="<%=disc_date%>">
	<input type='hidden' name="valid_date" id="valid_date" value="<%=valid_date%>">
	<input type='hidden' name="patient_class" id="patient_class" value="<%=patient_class%>">
	<input type='hidden' name="call_function" id="call_function" value="<%=call_function%>">
	<input type='hidden' name="from_time" id="from_time" value="<%=from_time%>">
	<input type='hidden' name="systdate" id="systdate" value="<%=systdate%>">
	
</form>

</BODY>
</HTML>
<%
}
catch(Exception e) {//out.println(e.toString());
e.printStackTrace();}
finally
	{
		try{
			if(con!=null)
				ConnectionManager.returnConnection(con,request);
		}catch(Exception ee){
			//out.println("Error while closing the connections :"+ee.toString());
			ee.printStackTrace();
			}
	}

%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

