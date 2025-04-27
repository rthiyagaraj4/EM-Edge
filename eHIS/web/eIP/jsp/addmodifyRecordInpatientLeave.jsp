<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "webbeans.eCommon.*,java.util.*,com.ehis.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale			= (String)session.getAttribute("LOCALE");
	
	String facilityID		= (String)session.getValue("facility_id");
	String spl_code			= "";
	String strPatientId		= checkForNull(request.getParameter("PatientId"));
%>
<HTML>
<HEAD>
    
    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>	
	<script src="../js/RecordInpatientLeave.js" language="JavaScript"></Script>
	<script src="../js/IPPractitionerComponent.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%	
	Connection con 		= null;
	Statement  stmt		= null;
	ResultSet  rs 		= null;
	Statement AbsStmt	= null;
	ResultSet rset 		= null;
	String warn_or_error_max_leave 	= "";
	String ip_Trn_Date="";
	String system_date_time_trn="";

	try
	{
		con = ConnectionManager.getConnection(request);
		stmt=con.createStatement();
		
		String encounterID		= checkForNull(request.getParameter("EncounterId"));
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy HH:mm" ) ;
		java.sql.Timestamp dt	= new Timestamp(System.currentTimeMillis()) ;

		String Sdate = dateFormat.format(dt) ;
		String Sdate_converted	= "";
        // commented by  munisekhar for  [IN:048759]
		//if(!(Sdate==null || Sdate.equals("")))
			//Sdate_converted = DateUtils.convertDate(Sdate,"DMYHM","en",locale);
		String adDateval		= "";
		String adm_date_display = "";
		String leave_to_date 	= "";
		String max_leave_period = "";
		String allow_release 	= "";
		String to_date 			= "";
		String nursing_unit		= "";
		String patient_id = "" ;
		String bed_class_code = "" ;
		String bed_type_code = "" ;
		String service_code = "" ;
		String room_num = "" ;
		String practid			= "";
		String NU_relVal		= "";
		String PARAM_relVal		= "";
		String setup_bl_dtls_in_ip_yn   = "";
		String deactivate_pseudoBed		= "";
		String patient_class			= ""; 
		String leave_to_date_converted = "";
		String contact1_name	= "";
		String contact2_name	= "";
		int p_pract_cnt = 0;
		int no_of_record = 0;

/* Commented and merged with below query for PE - 10/05/2010

		StringBuffer RelSql = new StringBuffer();
		RelSql.append(" select deactivate_pseudo_bed_yn, max_allowed_lv_period, allow_release_bed_on_lv, warn_or_error_max_leave, to_char((sysdate+max_allowed_lv_period/24),'dd/mm/rrrr hh24:mi') def_leave_to_preriod, setup_bl_dtls_in_ip_yn, to_char(sysdate,'dd/mm/rrrr hh24:mi') system_date_time from IP_PARAM where facility_id ='"+facilityID+"' ");
		rs= stmt.executeQuery( RelSql.toString() );
		if(rs.next())
		{
			max_leave_period = rs.getString(1);
			if(max_leave_period == null) max_leave_period = "0";

			allow_release	 = rs.getString(2);	
			if(allow_release == null ) allow_release = "N";		

			warn_or_error_max_leave = rs.getString("warn_or_error_max_leave");
				if(warn_or_error_max_leave ==null) warn_or_error_max_leave ="";			

			leave_to_date = checkForNull(rs.getString("def_leave_to_preriod"));
			
			if(!(leave_to_date==null || leave_to_date.equals("")))
				leave_to_date_converted = DateUtils.convertDate(leave_to_date,"DMYHM","en",locale);

			system_date_time_trn= rs.getString("system_date_time");
			deactivate_pseudoBed= checkForNull(rs.getString("deactivate_pseudo_bed_yn"));
		}
		if(rs !=null) rs.close(); if(stmt != null) stmt.close();

		if (RelSql.length() > 0)	RelSql.delete(0, RelSql.length());
				RelSql.append(" SELECT to_char(sysdate,'dd/mm/rrrr hh24:mi') system_date_time, to_char(MAX(trn_date_time),'dd/mm/rrrr hh24:mi') ip_trn_date FROM IP_ADT_TRN WHERE facility_id = '"+facilityID+"' AND encounter_id = '"+encounterID+"' ");
				stmt = con.createStatement();
				rs		= stmt.executeQuery(RelSql.toString());

				if ( (rs !=null)&&(rs.next()))
				{
					ip_Trn_Date		= rs.getString("ip_Trn_Date");
					system_date_time_trn= rs.getString("system_date_time");
				}
				if(rs !=null) rs.close(); if(stmt != null) stmt.close();
		if (RelSql.length() > 0) RelSql.delete(0, RelSql.length());
*/

		String practitioner_name = "", practitioner_id = "";
		String strBedNo = "";
		String srl_no = "";
		String allow_pseudo_bed_yn ="";
		StringBuffer admDate = new StringBuffer();

		admDate.append("select (select to_char(MAX(trn_date_time),'dd/mm/rrrr hh24:mi') ip_trn_date FROM IP_ADT_TRN WHERE facility_id = '"+facilityID+"' AND encounter_id = '"+encounterID+"') ip_Trn_Date, to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, a.nursing_unit_code, a.specialty_code, am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1 ) practitioner_name, a.ATTEND_PRACTITIONER_ID, a.bed_num bed_no, a.patient_class, b.release_bed_on_leave_yn, b.ALLOW_PSEUDO_BED_YN, (SELECT COUNT(1) FROM ip_bed_booking WHERE facility_id = a.facility_id AND encounter_id = a.encounter_id AND booking_type = 'N' AND (blocked_until_date_time IS NULL OR blocked_until_date_time > SYSDATE)) no_of_record, c.contact1_name, c.contact2_name, d.deactivate_pseudo_bed_yn, d.allow_release_bed_on_lv, d.warn_or_error_max_leave, to_char((sysdate+d.max_allowed_lv_period/24),'dd/mm/rrrr hh24:mi') def_leave_to_preriod, d.setup_bl_dtls_in_ip_yn, to_char(sysdate,'dd/mm/rrrr hh24:mi') system_date_time,(SELECT MAX (srl_no + 1) FROM ip_adt_trn WHERE facility_id ='"+facilityID+"' AND encounter_id = '"+encounterID+"') srl_no ,a.patient_id, a.bed_class_code, a.bed_type_code,a.service_code,a.room_num,d.max_allowed_lv_period max_leave_period from ip_open_encounter a, ip_nursing_unit b, mp_pat_rel_contacts c, ip_param d where a.encounter_id='"+encounterID+"' and a.facility_id = '"+facilityID+"' and a.facility_id = b.facility_id and a.nursing_unit_code = b.nursing_unit_code and a.patient_id = c.patient_id and a.facility_id = d.facility_id ");
		stmt = con.createStatement();
	
		rs = stmt.executeQuery(admDate.toString());

		if(rs != null)
		{
			if(rs.next())
			{
				
				room_num			= checkForNull(rs.getString("room_num"));
				ip_Trn_Date			= checkForNull(rs.getString("ip_trn_date"));
				service_code			= checkForNull(rs.getString("service_code"));
				bed_type_code			= checkForNull(rs.getString("bed_type_code"));
				bed_class_code			= checkForNull(rs.getString("bed_class_code"));
				patient_id			= checkForNull(rs.getString("patient_id"));
		        adDateval			= checkForNull(rs.getString("ADMISSION_DATE_TIME"));
				nursing_unit		= checkForNull(rs.getString("NURSING_UNIT_CODE"));
				practitioner_id		= checkForNull(rs.getString("ATTEND_PRACTITIONER_ID"));
				practitioner_name	= checkForNull(rs.getString("PRACTITIONER_NAME"));
				spl_code			= checkForNull(rs.getString("SPECIALTY_CODE"));
				strBedNo			= checkForNull(rs.getString("BED_NO"));
				patient_class       = checkForNull(rs.getString("patient_class"));
		        NU_relVal			= checkForNull(rs.getString("release_bed_on_leave_yn"));
		        PARAM_relVal			= checkForNull(rs.getString("allow_release_bed_on_lv"));
				allow_pseudo_bed_yn = rs.getString("allow_pseudo_bed_yn");
			    if(allow_pseudo_bed_yn == null || allow_pseudo_bed_yn.equals("N"))
				  allow_pseudo_bed_yn="N";
				no_of_record		= rs.getInt("no_of_record");
				contact1_name		= checkForNull(rs.getString("contact1_name"));
				contact2_name		= checkForNull(rs.getString("contact2_name"));
				max_leave_period	= rs.getString("max_leave_period");
				if(max_leave_period == null) max_leave_period = "0";

				allow_release	 = rs.getString(2);	
				if(allow_release == null ) allow_release = "N";		

				warn_or_error_max_leave = rs.getString("warn_or_error_max_leave");
					if(warn_or_error_max_leave ==null) warn_or_error_max_leave ="";			

				leave_to_date = checkForNull(rs.getString("def_leave_to_preriod"));
				
				if(!(leave_to_date==null || leave_to_date.equals("")))
					leave_to_date_converted = DateUtils.convertDate(leave_to_date,"DMYHM","en",locale);

				system_date_time_trn= rs.getString("system_date_time");
				// code added by  munisekhar for  [IN:048759]
			    if(!(system_date_time_trn==null || system_date_time_trn.equals("")))
			    Sdate_converted=DateUtils.convertDate(system_date_time_trn,"DMYHM","en",locale);
				deactivate_pseudoBed= checkForNull(rs.getString("deactivate_pseudo_bed_yn"));
				srl_no= checkForNull(rs.getString("srl_no"));
			}		
		}
		
		if(!(adDateval==null || adDateval.equals("")))
			adm_date_display = DateUtils.convertDate(adDateval,"DMYHM","en",locale);
		if(rs !=null) rs.close(); if(stmt != null) stmt.close();

		if (admDate.length() > 0) admDate.delete(0, admDate.length());
		

		/*
		Commented the below queries and merged with above query for PE - 10/05/2010

		String allow_pseudo_bed_yn ="";
		StringBuffer RelBedSql = new StringBuffer();
		RelBedSql.append(" select a.deactivate_pseudo_bed_yn, b.release_bed_on_leave_yn, a.allow_release_bed_on_lv,b.ALLOW_PSEUDO_BED_YN from IP_PARAM a, IP_NURSING_UNIT b where a.facility_id = '"+facilityID+"' and a.facility_id = b.facility_id and b.nursing_unit_code='"+nursing_unit+"' ");
		stmt = con.createStatement();    
		rs = stmt.executeQuery(RelBedSql.toString());
		if(rs != null)
		{
			while(rs.next())
			{
		        deactivate_pseudoBed= checkForNull(rs.getString("deactivate_pseudo_bed_yn"));
		        NU_relVal			= checkForNull(rs.getString("release_bed_on_leave_yn"));
		        PARAM_relVal		= checkForNull(rs.getString("allow_release_bed_on_lv"));
				allow_pseudo_bed_yn = rs.getString("allow_pseudo_bed_yn");
			     if(allow_pseudo_bed_yn == null || allow_pseudo_bed_yn.equals("N")) 
				  allow_pseudo_bed_yn="N";

			}		
		}
		if(rs !=null) rs.close(); if(stmt != null) stmt.close();
		if (RelBedSql.length() > 0)
				RelBedSql.delete(0, RelBedSql.length());
		
		
		StringBuffer reserve_Bed_Sql = new StringBuffer();
		try
		{
			reserve_Bed_Sql.append(" SELECT Count(*)  no_of_record FROM  IP_RESERVED_BED_DTL WHERE facility_id='"+facilityID+"' AND encounter_id='"+encounterID+"'    AND  RESERVED_TO_TIME IS NULL ");

			stmt = con.createStatement();    
			rs = stmt.executeQuery(reserve_Bed_Sql.toString());

				if(rs != null && rs.next())
				{
					no_of_record= rs.getInt("no_of_record");
				}
		}
		catch(Exception e)
		{
			//out.println("Exception in getting reserve bed sql:"+e.toString());
			e.printStackTrace();
		}	
		if(rs !=null) rs.close(); if(stmt != null) stmt.close();
		if (reserve_Bed_Sql.length() > 0)
				reserve_Bed_Sql.delete(0, reserve_Bed_Sql.length());
		

		StringBuffer mp_pat_rel_contacts = new StringBuffer();
		try
		{
			mp_pat_rel_contacts.append(" select contact1_name,contact2_name from mp_pat_rel_contacts where patient_id ='"+strPatientId+"' ");

			stmt = con.createStatement();    
			rs = stmt.executeQuery(mp_pat_rel_contacts.toString());

				if(rs != null && rs.next())
				{
					contact1_name	=	checkForNull(rs.getString("contact1_name"));
					contact2_name	=	checkForNull(rs.getString("contact2_name"));
				}
		}
		catch(Exception e)
		{
			//out.println("Exception in getting mp_pat_rel_contacts:"+e.toString());
			e.printStackTrace();
		}	
		if(rs !=null) rs.close(); if(stmt != null) stmt.close();
		if (mp_pat_rel_contacts.length() > 0)
				mp_pat_rel_contacts.delete(0, mp_pat_rel_contacts.length());
	*/

%>

<BODY onMouseDown="CodeArrest()" onKeyDown = "lockKey()" onLoad="imageInvisible();">
<form name='recordinpatientleave_form' id='recordinpatientleave_form' action='../../servlet/eIP.RecordInpatientLeaveServlet' method='post' target='messageFrame' > 
<TABLE border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
	<TR>
		<TD width="25%">&nbsp;</TD>
		<TD width="25%">&nbsp;</TD>
		<TD width="25%">&nbsp;</TD>
		<TD width="25%">&nbsp;</TD>
	</TR>	 
	<TR>
		<TD  class='label' id= "loadChk" ><fmt:message key="Common.record.label" bundle="${common_labels}"/></TD><td colspan="3" class='fileds'>
			<select name="record_status" id="record_status" onChange="disableAllFields();">
			<option value="01" selected><fmt:message key="Common.Leave.label" bundle="${common_labels}"/></option>
			<option value="02" ><fmt:message key="Common.Abscond.label" bundle="${common_labels}"/></option>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
		</td>

		<TR><TD colspan="4"></TD></TR>  	    
	<tr>
		  <TD   class="label" ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></TD>
		  <TD class='fileds'><input type='hidden' value='<%=practitioner_id%>' name='practid' ><input type='text' name='pract_desc' id='pract_desc' readOnly=true size='30' maxlength='30' value="<%=practitioner_name%>" onChange="getPractitionerLocal(document.forms[0].practid,pract_desc, '<%=facilityID%>');" ><input type='button' name='pract_id_search' id='pract_id_search' disabled=true value='?' class='button' onClick="getPractitionerLocal(document.forms[0].practid,pract_desc, '<%=facilityID%>');" ><img id = "img1" src='../../eCommon/images/mandatory.gif'align='center'></img>
		  </TD>
		  <TD  class='label' nowrap class='querydata'><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></TD>         
		  <TD  class='querydata' nowrap><%=adm_date_display%></TD>
	</TR>

	<%
	
		if((NU_relVal.equals("Y")) && (PARAM_relVal.equals("Y"))){%>

<TR><TD colspan="4"></TD></TR>
	<TR>
		<TD   class='label' id= "loadChk1"><fmt:message key="Common.ReleaseBed.label" bundle="${common_labels}"/></TD>     	  
		<td class='fileds'><input type="checkbox" name="release_bed" id="release_bed" value="Y" onClick="getPseudoBed(this);" id="check1" ></td>
		<td class='label'  id= "loadChk2"><fmt:message key="eIP.PseudoBed.label" bundle="${ip_labels}"/></td>
		<td class='fileds'><input type="text" name="pseudo_bed" id="pseudo_bed" size=8 maxlength=8 readonly onBlur="ChangeUpperCase(this);" id="txt1" onKeyPress='return CheckForSpecChars(event)' ><input id="button1" name="pseudo_button" id="pseudo_button" type="button" class="button" value="?" onclick="callBedAvailChart();"><img id="img5" src='../../eCommon/images/mandatory.gif' align='center'></img></td>
		</td>
	</TR>
<TR><TD colspan="4"></TD></TR>
	
	<%}else{%>
	<TR><TD colspan="4">&nbsp;</TD></TR>
	
		<%}%>
 
		<tr>
				<td class="COLUMNHEADER" colspan='4' id='amend_dtl'></td>
	    </tr>

<TR><TD colspan="4" class='label'></TD></TR>
 	<TR>
		<TD  class='label' colspan='' nowrap id='date_dtl'><fmt:message key="Common.fromdatetime.label" bundle="${common_labels}"/></TD>
		<TD  class='fileds' nowrap > 
		<!-- Below Two Line is commented by Akhilesh for unexpected code of JS Function 'TestDateDiff'-->
		<!--<input type ='text' name = 'fromdate' size = '15' id="fromdate"  maxlength ='16'  onBlur='chkFromToTime1(this);TestDateDiff(document.getElementById("todate").value,fromdate.value)' value ='<%=Sdate_converted%>' onKeyPress='return(ChkNumberInput1(this,event,2))'>-->
		<input type ='text' name = 'fromdate' size = '15' id="fromdate"  maxlength ='16'  onBlur='chkFromToTime1(this);' value ='<%=Sdate_converted%>' onKeyPress='return(ChkNumberInput1(this,event,2))'><img name='frmdt' src='../../eCommon/images/CommonCalendar.gif' onClick="document.getElementById('fromdate').select();return showCalendar('fromdate',null,'hh:mm');"/><img id="img2" src='../../eCommon/images/mandatory.gif' align='center'></img>
		</TD> 	  
		<TD id='lbl1'  class='label'><fmt:message key="eIP.ToDateTime.label" bundle="${ip_labels}"/></td>
		<td class='fileds'>
		

			<!--<input type ='text'  name = 'todate' id="todate" size = '15' maxlength ='16' onBlur="chkFromToTime2(this);TestDateDiff(document.getElementById("fromdate").value,todate.value)" value ='<%=leave_to_date_converted%>'  onKeyPress='return(ChkNumberInput1(this,event,2))'>-->
		<input type ='text'  name = 'todate' id="todate" size = '15' maxlength ='16' onBlur="chkFromToTime2(this); ValidateFromToDateTime(fromdate,this)" value ='<%=leave_to_date_converted%>'  onKeyPress='return(ChkNumberInput1(this,event,2))'><img name='prefdt' src='../../eCommon/images/CommonCalendar.gif' onClick="document.getElementById('todate').select();return showCalendar('todate',null,'hh:mm');" id="imgr"/>	
		<img id="img3" src='../../eCommon/images/mandatory.gif'align='center'></img>
		</TD>
	</TR>  
	<TR><TD colspan="4"></TD></TR>
	<TR>
		<TD  class='label' colspan = '' valign = 'center'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></TD>
		<TD colspan = '3' class='fileds'> <textarea style="resize:none" name='Remarks' id='Remarks' rows='4' cols='60' onBlur='checkMaxLimit1(this,500)' onKeyPress = "" ></textarea><img id="img4" src='../../eCommon/images/mandatory.gif' align='center'></img></TD>	
	 </TR>
	 <!--Reported To <TR> Added by kishore on 4/16/2004-->
	 <tr>
		<td id='lbl2' class='label'  nowrap><fmt:message key="eIP.ReportedTo.label" bundle="${ip_labels}"/></td>
		<td colspan='3' class='fileds'><textarea style="resize:none" id='txtarea2' rows='4' cols='60' name='reported_to' disabled onBlur='makeValidString(this);checkMaxLimit1(this,200);'>
		</textarea></td>
	</tr> 
			<tr>
				<td class="COLUMNHEADER" colspan='4' id='infmd_detl'></td>
	       </tr>

<TR><TD colspan="4"></TD></TR>
<TR><TD colspan="4" style="height:18;" class="LABEL">
	<jsp:include page="../../eIP/jsp/InformedDetails.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name="patient_id" value="<%=strPatientId%>" />
		<jsp:param name="called_from" value="record_leave" />
		<jsp:param name="system_date_time" value="<%=Sdate%>" />
		<jsp:param name="admissiondatetime" value="<%=adDateval%>" />	
		<jsp:param name="encounterID" value="<%=encounterID%>" />	
		
		
	</jsp:include>
</td></tr>
<!--above line added for leave17633 Thursday, December 24, 2009  -->
<TR>
	<td id='lastrow' width='100%' class='label' colspan="6"  nowrap>
 	</td>
</TR>
<TR><TD colspan="4"></TD></TR>
<TR>
	<TD class='label'>&nbsp;</TD>
	<TD class='label'>&nbsp;</TD>
	<TD class='label'>&nbsp;</TD>
	<TD class='fileds'><input type="button" class = 'button' name ="confirm" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' onClick='ButVal(this)'><input type="button" class = 'button' name ="clear"   value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'   onClick='ButVal(this)'><input type="button" class = 'button' name ="cancel"  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'  onClick='ButVal(this)'></TD> 	  				  	
</TR>
<TR><TD colspan="4"></TD></TR>
<script>
	if (parseInt("<%=p_pract_cnt%>")== 1)
	{
		document.getElementById("practid").value="<%=practid%>";
	}

</script>
</table>
   		<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>" >
		<input type='hidden' name='admdate' id='admdate' value="<%=adDateval%>" >
		<input type='hidden' name ='sStyle' id='sStyle' value="<%=sStyle%>">
		<input type='hidden' name ='currdate' id='currdate' value="<%=Sdate%>">
		<input type='hidden' name='encounterid' id='encounterid' value="<%=encounterID%>" > 	
		<input type='hidden' name='to_date' id='to_date' value="<%=to_date%>" > 
		<input type='hidden' name='admndate' id='admndate' value="<%=adDateval%>" > 
		<input type='hidden' name='overrideyn' id='overrideyn'value='N' name='overrideyn' > 
		<input type='hidden' name = 'warn_or_error_max_leave' id= 'warn_or_error_max_leave' value="<%=warn_or_error_max_leave%>" >
		<input type='hidden' name = 'max_allowed_lv_period' id= 'max_allowed_lv_period' value="<%=max_leave_period%>" >
		<input type="hidden" name="nursing_unit" id="nursing_unit" value="<%=nursing_unit%>"> 	
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>"> 	
		<input type="hidden" name="bed_class_code" id="bed_class_code" value="<%=bed_class_code%>"> 	
		<input type="hidden" name="bed_type_code" id="bed_type_code" value="<%=bed_type_code%>"> 	
		<input type="hidden" name="service_code" id="service_code" value="<%=service_code%>"> 	
		<input type="hidden" name="room_no" id="room_no" value="<%=room_num%>"> 	
		<input type='hidden' name='generate_pseudo_bed' id='generate_pseudo_bed' value='N' >
		<input type='hidden' name='spl_code' id='spl_code' value="<%=spl_code%>" >
		<input type='hidden' name='hdnBedNo' id='hdnBedNo' value='<%=strBedNo%>'>
		<input type='hidden' name='hdnPatientId' id='hdnPatientId' value='<%=strPatientId%>'>
		<input type='hidden' name='hdnleave_to_date' id='hdnleave_to_date' value='<%=leave_to_date%>'>
		<input type='hidden' name='hdd_peudobed_val' id='hdd_peudobed_val' value=''>
		<input type='hidden' name='hdd_temp_for_dhck' id='hdd_temp_for_dhck' value=''>
		<input type='hidden' name='deactivate_pseudoBed' id='deactivate_pseudoBed' value='<%=deactivate_pseudoBed%>'>
		<input type='hidden' name='setup_bl_dtls_in_ip_yn' id='setup_bl_dtls_in_ip_yn' value='<%=setup_bl_dtls_in_ip_yn%>'>
		<input type='hidden' name='locale1' id='locale1' value='<%=locale%>'>
		<input type='hidden' name='release_reserve_bed_yn' id='release_reserve_bed_yn' value='N'>
		<input type='hidden' name='no_of_record' id='no_of_record' value='<%=no_of_record%>'>
		<!-- 17633 below line added for 17633  on dateThursday, December 24, 2009-->
		<input type='hidden' name='ip_Trn_Date' id='ip_Trn_Date' value='<%=ip_Trn_Date%>'>
		<input type='hidden' name='Sdate_converted' id='Sdate_converted' value='<%=Sdate_converted%>'>
		<input type='hidden' name='leave_to_date_converted' id='leave_to_date_converted' value='<%=leave_to_date_converted%>'>
		<input type='hidden' name='contact1_name' id='contact1_name' value='<%=contact1_name%>'>
		<input type='hidden' name='contact2_name' id='contact2_name' value='<%=contact2_name%>'>
		<input type='hidden' name='srl_no' id='srl_no' value='<%=srl_no%>'>
		<input type='hidden' name='specialtycode' id='specialtycode' value='<%=spl_code%>'>
		<input type='hidden' name='bedno' id='bedno' value='<%=strBedNo%>'>
		
</form>

<script>
// Added by Sridhar R on 16 JUNE 2004
// IF release Bed Chk box is Painted on screen then the Psedo Button will be Disabled initially...

	if(document.getElementById("release_bed"))
	{
		document.getElementById("pseudo_button").disabled	= true;
		document.getElementById("img5").style.visibility="hidden";	
	}
</script>
</BODY>
	<%
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (rset   != null) rset.close();
		if (AbsStmt  != null) AbsStmt.close();

	}catch(Exception e){
		//out.println(e);
		e.printStackTrace();}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</HTML>
<%!
	// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

