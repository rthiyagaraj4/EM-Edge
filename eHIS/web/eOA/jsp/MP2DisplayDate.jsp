<!DOCTYPE html>
   <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,java.util.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>

<%       // Modified for CRF - SRR -0425 -- Order Catalog.


        request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
    	String locale=(String)session.getAttribute("LOCALE");
		String mode_find="";
		String valid_date_display1="";
		String valid_date_display2="";
		mode_find=(String)request.getParameter("mode_find");
		if(mode_find==null || mode_find.equals("null")) mode_find="";
		String pre_pat_alcn_catg_code = request.getParameter("pre_pat_alcn_catg_code");
		if( pre_pat_alcn_catg_code == null) pre_pat_alcn_catg_code="";
		String clinic_code1=(String)request.getParameter("clinic_code1");
		String practitioner_id1=(String)request.getParameter("practitioner_id1");
		String clinic_code2=(String)request.getParameter("clinic_code2");
		String practitioner_id2=(String)request.getParameter("practitioner_id2");
		String create_wait_list_yn=request.getParameter("create_wait_list_yn");
			if(create_wait_list_yn ==null) create_wait_list_yn="";
		String date=(String)request.getParameter("Date");
		String date1=(String)request.getParameter("Date1");
		if(date1 == null)date1=date;
		String or_catalogue_code=request.getParameter("or_catalogue_code")==null?"":request.getParameter("or_catalogue_code");
		String value12=(String)request.getParameter("value12");
		if(value12 == null)value12="";
		String value13=(String)request.getParameter("value13");
		if(value13 == null) value13="";

		String old_clinic=(String)request.getParameter("old_clinic");
		if(old_clinic  == null || old_clinic.equals("null"))old_clinic="";

		String old_practitioner=(String)request.getParameter("old_practitioner");
		if(old_practitioner== null || old_practitioner.equals("null"))old_practitioner="";

		String Param=(String)request.getParameter("Param");
		if(Param == null || Param.equals("null")) Param="";

		String old_from_time = request.getParameter("old_from_time");
		if( old_from_time == null) old_from_time="";

		String old_to_time = request.getParameter("old_to_time");
		if( old_to_time == null) old_to_time="";

		String old_date=(String)request.getParameter("old_date");
		if(old_date  == null || old_date.equals("null")) old_date="";

		String valid_date = request.getParameter("valid_date");
		if( valid_date == null) valid_date="";


		String sysdate="";
		String ca_mode = request.getParameter("ca_mode");
		if(( ca_mode == null) || ca_mode.equals(""))  ca_mode="";
		String read_only_date="";

		String callingMode= request.getParameter("callingMode");
		String ca_patient_id=request.getParameter("ca_patient_id");

		String clinic_type2=request.getParameter("clinic_type2");
		String res_type2=request.getParameter("res_type2");

		String clinic_type1=request.getParameter("clinic_type1");
		String res_type1=request.getParameter("res_type1");


		if (clinic_type1==null) clinic_type1 = "C";
		if (res_type1==null) res_type1 = "P";

		if (clinic_type2==null) clinic_type2 = "C";
		if (res_type2==null) res_type2 = "P";

		String oper_stn_id=request.getParameter("oper_stn_id");
		if(oper_stn_id == null) oper_stn_id="";



		//MR by suman 
		String req_id=request.getParameter("req_id");
		if(req_id ==null) req_id="";
			String install_yn_val=request.getParameter("install_yn_val");
		if(install_yn_val ==null) install_yn_val="";


			 String from_facility_id= request.getParameter("from_facility_id");
		     if(from_facility_id ==null) from_facility_id="";
			String from_encounter_id= request.getParameter("from_encounter_id");
			if(from_encounter_id ==null) from_encounter_id="";


			 /*
			   Capture Fin Dtls YN Added On 4/24/2008  
			   Providing Common Capture Fin Dtls YN to Both Display Date && Resultpage
			   To Avoid Script Errors in ChangeDateFor2Vw.js
			*/

			String speciality=request.getParameter("speciality");
	        if(speciality ==null) speciality="";
            String clinic_old=request.getParameter("clinic_old");
			if(clinic_old ==null) clinic_old="";
			String practitioner_old=request.getParameter("practitioner_old");
		   if(practitioner_old ==null) practitioner_old="";
		   String practitioner_type=request.getParameter("practitioner_type");
		   if(practitioner_type ==null) practitioner_type="";
		   String pref_start_date=request.getParameter("pref_start_date");
			if(pref_start_date ==null) pref_start_date="";
			String pref_end_date=request.getParameter("pref_end_date");
			if(pref_end_date ==null) pref_end_date="";
			String care_locn_ind=request.getParameter("care_locn_ind");
			if(care_locn_ind ==null) care_locn_ind="";
			String visittype=(String)request.getParameter("visittype");
	        if(visittype == null || visittype.equals("null")) visittype ="";
			String no_dwm=request.getParameter("no_dwm");
			if(no_dwm ==null) no_dwm="";
			String dwm_desc=request.getParameter("dwm_desc");
	        if(dwm_desc ==null) dwm_desc="";
			String slot_appt_ctrl=request.getParameter("slot_appt_ctrl")==null?"":request.getParameter("slot_appt_ctrl");
			String visit_limit_rule=request.getParameter("visit_limit_rule")==null?"":request.getParameter("visit_limit_rule");
			String alcn_criteria=request.getParameter("alcn_criteria")==null?"":request.getParameter("alcn_criteria");
			String override_no_of_slots_yn=request.getParameter("override_no_of_slots_yn")==null?"":request.getParameter("override_no_of_slots_yn");
			String capture_fin_dtls_yn=request.getParameter("capture_fin_dtls_yn")==null?"N":request.getParameter("capture_fin_dtls_yn");
			String min_ela_per_resc_noshow_in_day=request.getParameter("min_ela_per_resc_noshow_in_day")==null?"":request.getParameter("min_ela_per_resc_noshow_in_day");
			String noshow_ctrl_by_splty_or_clinic=request.getParameter("noshow_ctrl_by_splty_or_clinic")==null?"":request.getParameter("noshow_ctrl_by_splty_or_clinic");
			String contact_num_reqd_yn=request.getParameter("contact_num_reqd_yn")==null?"N":request.getParameter("contact_num_reqd_yn");
			String no_of_noshow_appts_for_alert=request.getParameter("no_of_noshow_appts_for_alert")==null?"":request.getParameter("no_of_noshow_appts_for_alert");
			String per_chk_for_no_show_alert=request.getParameter("per_chk_for_no_show_alert")==null?"":request.getParameter("per_chk_for_no_show_alert");
			String position=request.getParameter("position")==null?"":request.getParameter("position");
			String addtl_splty=request.getParameter("addtl_splty")==null?"":request.getParameter("addtl_splty");
			String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");
%>

<html>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eOA/js/ChangeDateFor2Vw.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<head>
</head>

<script>
function disable_go1()
{
	
	if(document.forms[0].hddTracker.value=="MR" || document.forms[0].hddTracker.value=="OP_RV")
	{
		
		document.forms[0].go.disabled=true;
		document.forms[0].go1.disabled=true;
		document.forms[0].valid_date.disabled=true;
		document.forms[0].valid_date1.disabled=true;
		document.getElementById("cal1").disabled=true;
		document.getElementById("cal2").disabled=true;
	}else
	{
		document.forms[0].go.disabled=false;
		document.forms[0].go1.disabled=false;
		document.forms[0].valid_date.disabled=false;
		document.forms[0].valid_date1.disabled=false;
		document.getElementById("cal1").disabled=false;
		document.getElementById("cal2").disabled=false;
	}
	
}
</script>
		<body onload='disable_go1()' OnMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
		<form name=image>
		
<table border=0 width="100%" cellspacing='2' cellpadding='0'>
	<tr>
		<td align="left" width="50%" valign="top">
		<table border=0 width=100% cellspacing='0' cellpadding='0'>
		<tr valign="top">
		<%
				Connection con = null;
				Statement stmt = null;
				ResultSet rs=null;
		
		
try
{
		con = ConnectionManager.getConnection(request);
				 stmt = con.createStatement();

		String sql_date="select to_char(sysdate,'dd/mm/yyyy') sys_date,to_char(to_date('"+valid_date+"','dd/mm/yyyy'),'Day') day1,to_char(to_date('"+date1+"','dd/mm/yyyy'),'Day') day2,replace(to_char(to_date('"+date+"','dd/mm/yyyy'), 'Day, Month,dd,yyyy'),' ','') from dual";
		rs=stmt.executeQuery(sql_date);

		rs.next();
		sysdate=rs.getString("sys_date");
		String day1=rs.getString("day1");
		String day2=rs.getString("day2");
		String display=rs.getString("sys_date");
		if(rs !=null) rs.close();

		day1=day1.trim();
String day_show1="";
		if(day1.equals("Sunday"))
		{
			day_show1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
		}else if(day1.equals("Monday"))
		{
			day_show1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
		}else if(day1.equals("Tuesday"))
		{
			day_show1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
		}else if(day1.equals("Wednesday"))
		{
			day_show1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
		}else if(day1.equals("Thursday"))
		{
			day_show1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
		}else if(day1.equals("Friday"))
		{
			day_show1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
		}else if(day1.equals("Saturday"))
		{
			day_show1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
		}

		valid_date_display1=DateUtils.convertDate(valid_date,"DMY","en",locale);


	day2=day2.trim();
String day_show2="";
		if(day2.equals("Sunday"))
		{
			day_show2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
		}else if(day2.equals("Monday"))
		{
			day_show2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
		}else if(day2.equals("Tuesday"))
		{
			day_show2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
		}else if(day2.equals("Wednesday"))
		{
			day_show2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
		}else if(day2.equals("Thursday"))
		{
			day_show2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
		}else if(day2.equals("Friday"))
		{
			day_show2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
		}else if(day2.equals("Saturday"))
		{
			day_show2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
		}

		valid_date_display2=DateUtils.convertDate(date1,"DMY","en",locale);
		%>
		<input type=hidden name="cur_dt" id="cur_dt" value="<%=sysdate%>">	
 
		<td width="100" class=label nowrap><fmt:message key="Common.ScheduleDate.label" bundle="${common_labels}"/></td>
		
		<td width="150" class='fields'><input type=text id = 'date_of_expiry' size=10 maxlength = 10 name='valid_date' id='valid_date' value='<%=valid_date_display1%>' onblur="DateCheck_new1('<%=sysdate%>',this,'0')"  <%=read_only_date%> onkeypress="return check_val(event)" ><img src="../../eCommon/images/CommonCalendar.gif" id='cal1' onClick="document.forms[0].date_of_expiry.select();return showCalendar('date_of_expiry');"  ><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
			
		<td width="100" class='label' id = day1 ><b><%=day_show1%></b></td>
		
		<td class='button' width="100" valign="top">
		
		
		<input type='button' name='go' id='go' value='<fmt:message key="Common.Go.label" bundle="${common_labels}"/>' onClick="blankdatechk(this);alt_fn('0');" class='button' > 
		
		

		<input type=hidden size='' name='gggg' id='gggg' value=<%=display%> disabled style='visibility:hidden'><input type='button' value='' class='button' onClick='moveforward()' style='visibility:hidden'></td>		
	 </tr>
</table>
		</td>
	
		<td width="50%" valign="top">

<table border=0 width=100% cellspacing='0' cellpadding='0'>
	<tr valign="top">

		<td  width="100" class=label nowrap><fmt:message key="Common.ScheduleDate.label" bundle="${common_labels}"/></td>
			
		<td  width="150" class=fields align='left'><input id = 'date_of_expiry1' type=text size=10 maxlength = 10 name='valid_date1' id='valid_date1' value='<%=valid_date_display2%>'  onblur="DateCheck_new2('<%=sysdate%>',this,'1')" <%=read_only_date%> onkeypress="return check_val(event)" ><img src="../../eCommon/images/CommonCalendar.gif" id='cal2' onClick="document.forms[0].date_of_expiry1.select();return showCalendar('date_of_expiry1');" style='visibility' ><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
			
		<td width="100" class='label' id = day2 ><b><%=day_show2%></b></td>
			
		<td  class='button' width="100">
			
			
			<input type='button' name='go1' id='go1' value='<fmt:message key="Common.Go.label" bundle="${common_labels}"/>'  onClick="blankdatechk(this);alt_fn('1');" class='button' > 
			
			<input type='button' value='' class='button' onClick='moveforward()'  style='visibility:hidden'> </td>			
			
	</tr>
</table>
		</td>
	</tr>
		</table>
		<input type='hidden' name='move' id='move' value=<%=display%> >
		<input type='hidden' name='clinic1' id='clinic1' value=<%=clinic_code1%> >
		<input type='hidden' name='practitioner1' id='practitioner1' value=<%=practitioner_id1%> >
		<input type='hidden' name='clinic2' id='clinic2' value=<%=clinic_code2%> >
		<input type='hidden' name='practitioner2' id='practitioner2' value=<%=practitioner_id2%> >
		<input type='hidden' name='date1' id='date1' value=<%=date1%> >
		<input type='hidden' name='changed_date' id='changed_date' value=<%=date%> >
		<input type='hidden' name='ref_no' id='ref_no' value=<%=value13%> >
		<input type='hidden' name='reason_for_revise' id='reason_for_revise' value=<%=value12%> >
		<input type='hidden' name='old_clinic' id='old_clinic' value=<%=old_clinic%> >
		<input type='hidden' name='old_practitioner' id='old_practitioner' value=<%=old_practitioner %> >
		<input type='hidden' name='Param' id='Param' value=<%=Param%> >
		<input type='hidden' name='hddTracker' id='hddTracker' value='<%=callingMode%>' >
		<input type='hidden' name='ca_patient_id' id='ca_patient_id' value='<%=ca_patient_id%>' >
		<input type='hidden' name='ca_mode' id='ca_mode' value='<%=ca_mode%>' >
		<input type='hidden' name='old_date' id='old_date' value=<%=old_date%> >
		<input type='hidden' name='old_from_time' id='old_from_time' value='<%=old_from_time%>' >
		<input type='hidden' name='old_to_time' id='old_to_time' value='<%=old_to_time%>' >
		<input type='hidden' name='mode_find' id='mode_find' value='<%=mode_find%>' >
		<input type='hidden' name='pre_pat_alcn_catg_code' id='pre_pat_alcn_catg_code' value='<%=pre_pat_alcn_catg_code%>' >
		<input type="hidden" name="clinic_type1" id="clinic_type1" value="<%=clinic_type1%>">
		<input type="hidden" name="res_type1" id="res_type1" value="<%=res_type1%>">
		<input type="hidden" name="clinic_type2" id="clinic_type2" value="<%=clinic_type2%>">
		<input type="hidden" name="res_type2" id="res_type2" value="<%=res_type2%>">
		<input type="hidden" name="alcn_criteria" id="alcn_criteria" value="<%=alcn_criteria%>">
		<input type="hidden" name="slot_appt_ctrl" id="slot_appt_ctrl" value="<%=slot_appt_ctrl%>">
		<input type="hidden" name="visit_limit_rule" id="visit_limit_rule" value="<%=visit_limit_rule%>">
		<input type="hidden" name="override_no_of_slots_yn" id="override_no_of_slots_yn" value="<%=override_no_of_slots_yn%>">
		<input type="hidden" name="oper_stn_id" id="oper_stn_id" value="<%=oper_stn_id%>">
		<input type='hidden' name="req_id" id="req_id" value="<%=req_id%>">
		<input type="hidden" name="install_yn_val" id="install_yn_val" value="<%=install_yn_val%>">
		<input type="hidden" name="from_facility_id" id="from_facility_id" value="<%=from_facility_id%>">
		<input type="hidden" name="from_encounter_id" id="from_encounter_id" value="<%=from_encounter_id%>">
		<input type="hidden" name="contact_num_reqd_yn" id="contact_num_reqd_yn" value="<%=contact_num_reqd_yn%>">
		<input type="hidden" name='min_ela_per_resc_noshow_in_day' id='min_ela_per_resc_noshow_in_day' value='<%=min_ela_per_resc_noshow_in_day%>'>
		<input type="hidden" name='noshow_ctrl_by_splty_or_clinic' id='noshow_ctrl_by_splty_or_clinic' value='<%=noshow_ctrl_by_splty_or_clinic%>'>
		<input type="hidden" name='capture_fin_dtls_yn' id='capture_fin_dtls_yn' value='<%=capture_fin_dtls_yn%>'>
		<input type="hidden" name='no_of_noshow_appts_for_alert' id='no_of_noshow_appts_for_alert' value='<%=no_of_noshow_appts_for_alert%>'>
		<input type="hidden" name='per_chk_for_no_show_alert' id='per_chk_for_no_show_alert' value='<%=per_chk_for_no_show_alert%>'>
		<input type="hidden" name='speciality' id='speciality' value='<%=speciality%>'>
		<input type="hidden" name='clinic_old' id='clinic_old' value='<%=clinic_old%>'>
		<input type="hidden" name='practitioner_old' id='practitioner_old' value='<%=practitioner_old%>'>
		<input type="hidden" name='practitioner_type' id='practitioner_type' value='<%=practitioner_type%>'>
		<input type="hidden" name='pref_start_date' id='pref_start_date' value='<%=pref_start_date%>'>
		<input type="hidden" name='pref_end_date' id='pref_end_date' value='<%=pref_end_date%>'>
		<input type="hidden" name='care_locn_ind' id='care_locn_ind' value='<%=care_locn_ind%>'>
		<input type="hidden" name='visittype' id='visittype' value='<%=visittype%>'>
		<input type="hidden" name='no_dwm' id='no_dwm' value='<%=no_dwm%>'>
		<input type="hidden" name='dwm_desc' id='dwm_desc' value='<%=dwm_desc%>'>
		<input type="hidden" name='or_catalogue_code' id='or_catalogue_code' value='<%=or_catalogue_code%>'>
		<input type="hidden" name='position' id='position' value='<%=position%>'>
		<input type="hidden" name='addtl_splty' id='addtl_splty' value='<%=addtl_splty%>'>
		<input type="hidden" name='rd_appt_yn' id='rd_appt_yn' value='<%=rd_appt_yn%>'>
<%
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
}catch(Exception e) { 
//out.println("date :" +e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	
	ConnectionManager.returnConnection(con,request);
}
%>
</form>
</body>
</html>

