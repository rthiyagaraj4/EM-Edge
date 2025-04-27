<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<%@ page  contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<%      // Modified for CRF - SRR -0425 -- Order Catalog.
   
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String mode_find="";
			String read_only_date="";
			String valid_date_display="";
			String locale=(String)session.getAttribute("LOCALE");

			String ca_mode=(String)request.getParameter("ca_mode");
			if(ca_mode==null || ca_mode.equals("") || ca_mode.equals("null"))
			   ca_mode="";
			mode_find=(String)request.getParameter("mode_find");
			if(mode_find==null || mode_find.equals("null")) mode_find="";
			String pre_pat_alcn_catg_code = request.getParameter("pre_pat_alcn_catg_code");
			if( pre_pat_alcn_catg_code == null) pre_pat_alcn_catg_code="";
			String clinic_code=(String)request.getParameter("clinic_code");
			String practitioner_id=(String)request.getParameter("practitioner_id");
			String value12=(String)request.getParameter("value12");
			if(value12 == null)value12="";
			String value13=(String)request.getParameter("value13");
			if(value13 == null) value13="";
			String date=(String)request.getParameter("Date");
			String old_date=(String)request.getParameter("old_date");
			if(old_date  == null || old_date.equals("null")) old_date="";
			String decide=(String)request.getParameter("decide");
			if(decide == null || decide.equals("null")) decide="";
			String valid_date = request.getParameter("valid_date");
			if( valid_date == null) valid_date="";
			String or_catalogue_code=request.getParameter("or_catalogue_code")==null?"":request.getParameter("or_catalogue_code");
			String order_catalog_code=request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");//for pending orders
			String order_id=request.getParameter("order_id")==null?"":request.getParameter("order_id");
			String order_line_num=request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
			String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");

			String old_from_time = request.getParameter("old_from_time");
			if( old_from_time == null) old_from_time="";

			String old_to_time = request.getParameter("old_to_time");
			if( old_to_time == null) old_to_time="";

			String sysdate="";
			String callingMode= request.getParameter("callingMode");

			String clinic_type=request.getParameter("clinic_type");
			String res_type=request.getParameter("res_type");

			if (clinic_type==null) clinic_type = "C";
			if (res_type==null) res_type = "P";

			String visit_limit_rule=request.getParameter("visit_limit_rule");
			if(visit_limit_rule == null) visit_limit_rule="";
			String create_wait_list_yn=request.getParameter("create_wait_list_yn");
			if(create_wait_list_yn ==null) create_wait_list_yn="";
			String alcn_criteria=request.getParameter("alcn_criteria");
			if(alcn_criteria == null) alcn_criteria="";

			String slot_appt_ctrl=request.getParameter("slot_appt_ctrl");
			if(slot_appt_ctrl == null) slot_appt_ctrl="";

			String oper_stn_id=request.getParameter("oper_stn_id");
			if(oper_stn_id == null) oper_stn_id="";

			String override_no_of_slots_yn=request.getParameter("override_no_of_slots_yn");
			if(override_no_of_slots_yn ==null) override_no_of_slots_yn="";
			//MR by suman 
		String req_id=request.getParameter("req_id");
		if(req_id ==null) req_id="";
		String install_yn_val=request.getParameter("install_yn_val");
		if(install_yn_val ==null) install_yn_val="";

		String capture_fin_dtls_yn=request.getParameter("capture_fin_dtls_yn");
 String noshow_ctrl_by_splty_or_clinic=request.getParameter("noshow_ctrl_by_splty_or_clinic");
 if(noshow_ctrl_by_splty_or_clinic ==null) noshow_ctrl_by_splty_or_clinic="";
 String min_ela_per_resc_noshow_in_day=request.getParameter("min_ela_per_resc_noshow_in_day");
 if(min_ela_per_resc_noshow_in_day ==null) min_ela_per_resc_noshow_in_day="";

  	String position=request.getParameter("position")==null?"":request.getParameter("position");
	String addtl_splty=request.getParameter("addtl_splty")==null?"":request.getParameter("addtl_splty");
	String wtListControl			= request.getParameter("wtListControl")==null?"":request.getParameter("wtListControl");
	String disabled="";
	if(wtListControl.equals("B")){
		disabled="disabled";
	}

%>

<html>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<Script src="../../eOA/js/ChangeDate.js" language="JavaScript"></Script>
		<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<head>

	</head>
<script>
function disable_go()
{
	if(document.forms[0].hddTracker.value=="MR" || document.forms[0].hddTracker.value=="OP_RV")
	{
		
		document.forms[0].go.disabled=true;
		document.forms[0].valid_date.disabled=true;
		document.getElementById("cal1").disabled=true;
	}else
	{
		document.forms[0].go.disabled=false;
		document.forms[0].valid_date.disabled=false;
		document.getElementById("cal1").disabled=false;
	}
	if('<%=wtListControl%>'=='B'){
		document.forms[0].date_of_expiry.disabled=true;
		document.forms[0].cal1.disabled=true;
		document.forms[0].go.disabled=true;
	}
}
</script>



	<body onload='disable_go();'onmousedown ='CodeArrest();' onKeyDown = 'lockKey()'>
	<form name=image>
<%
	if(ca_mode.equals("ca_mode")){%>
		<br>	
	<%}%>

			<%
			Connection con = null;
			Statement stmt = null;
			ResultSet rs=null;
			PreparedStatement pstmt=null;
		try
		{
			 con = ConnectionManager.getConnection(request);
			 stmt = con.createStatement();
			 String display="";
			 String day1="";

				//rs=stmt.executeQuery("select replace(to_char(to_date('"+date+"','dd/mm/yyyy'), 'Day, Month,dd,yyyy'),'','')dat_val,to_char(sysdate,'dd/mm/yyyy')dat_val1,to_char(to_date('"+valid_date+"','dd/mm/yyyy'),'Day') day1 from dual");
				String sql1 = "select replace(to_char(to_date(?,'dd/mm/yyyy'), 'Day, Month,dd,yyyy'),'','')dat_val,to_char(sysdate,'dd/mm/yyyy')dat_val1,to_char(to_date(?,'dd/mm/yyyy'),'Day') day1 from dual";
				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1,date);
				pstmt.setString(2,valid_date);
				rs = pstmt.executeQuery();
				if(rs !=null ){
				while(rs.next()){
			
				 display=rs.getString("dat_val");
				  if(display ==null) display="";
				 sysdate=rs.getString("dat_val1");
				  if(sysdate==null) sysdate="";
				 day1=rs.getString("day1");
				  if(day1 ==null) day1="";

			}
				}
				if(rs !=null) rs.close();


day1=day1.trim();
String day_show="";
		if(day1.equals("Sunday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
		}else if(day1.equals("Monday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
		}else if(day1.equals("Tuesday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
		}else if(day1.equals("Wednesday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
		}else if(day1.equals("Thursday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
		}else if(day1.equals("Friday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
		}else if(day1.equals("Saturday"))
		{
			day_show=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
		}
			 valid_date_display=DateUtils.convertDate(valid_date,"DMY","en",locale);	%>

<table border=0 width='100%' cellspacing='0' cellpadding='0'>

 <tr>
		<td class=label   nowrap width='11%'><fmt:message key="Common.ScheduleDate.label" bundle="${common_labels}"/></td>
		
		<td  class=fields nowrap width='15%'><input type=hidden name="cur_dt" id="cur_dt" value="<%=sysdate%>">
		<input id="date_of_expiry" type=text size=10 maxlength = 10 name='valid_date' id='valid_date' value='<%=valid_date_display%>' onfocus="enabgo(this);" onblur="DateCheck_new('<%=sysdate%>',this)" tabindex=1 <%=read_only_date%> onkeypress="return check_val(event)"><img src="../../eCommon/images/CommonCalendar.gif" id='cal1' onClick="document.forms[0].valid_date.select();return showCalendar('date_of_expiry',null); " <%=read_only_date%>>
		<img src="../../eCommon/images/mandatory.gif" align='center'></img>
		</td>
		<td class='label' id = day1 width='10%' nowrap><b><%=day_show%></b></td>

		<td align='left'  nowrap width='5%'><input type='button' name='go' id='go' value='<fmt:message key="Common.Go.label" bundle="${common_labels}"/> ' class='button' onfocus="alt_fn();" onClick='blankdatechk();'  > </td>
		<!--below line is commented and next one is added for Bru-HIMS-CRF-173-->
		<!--<td colspan='2' width='35%'>&nbsp</td>-->
		<td colspan='1' width='35%' ><input type='button' class='button'  name='ViewWaitList' id='ViewWaitList' value='<fmt:message key="eOA.ViewWaitList.label" bundle="${oa_labels}"/>' onClick='viewWaitList("view")' ></td>
		<%if(wtListControl.equals("B")){%>
		<td align='left'  nowrap width='35%'><input type='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/> ' class='button' onClick='window.close();'> </td>
		<%}%>

	</tr>
</table>

	<input type='hidden' size='' name='gggg' id='gggg' value="" >
    <input type='hidden' name='clinic' id='clinic' value=<%=clinic_code%> >
	<input type='hidden' name='practitioner' id='practitioner' value=<%=practitioner_id%> >
	<input type='hidden' name='changed_date' id='changed_date' value=<%=date%> >
	<input type='hidden' name='ref_no' id='ref_no' value=<%=value13%> >
	<input type='hidden' name='reason_for_revise' id='reason_for_revise' value=<%=value12%> >
	<input type='hidden' name='old_date' id='old_date' value=<%=old_date%> >
	<input type='hidden' name='decide' id='decide' value=<%=decide%> >
	<input type='hidden' name='old_from_time' id='old_from_time' value='<%=old_from_time%>' >
	<input type='hidden' name='old_to_time' id='old_to_time' value='<%=old_to_time%>' >
	<input type='hidden' name='mode_find' id='mode_find' value='<%=mode_find%>' >
	<input type='hidden' name='pre_pat_alcn_catg_code' id='pre_pat_alcn_catg_code' value='<%=pre_pat_alcn_catg_code%>' >
	<input type='hidden' name='ca_mode' id='ca_mode' value='<%=ca_mode%>' >
	<input type='hidden' name='move' id='move' value=<%=display%> >
	<input type='hidden' name='hddTracker' id='hddTracker' value='<%=callingMode%>' >
	<input type="hidden" name="clinic_type" id="clinic_type" value="<%=clinic_type%>">
	<input type="hidden" name="res_type" id="res_type" value="<%=res_type%>">
	<input type="hidden" name="alcn_criteria" id="alcn_criteria" value="<%=alcn_criteria%>">
	<input type="hidden" name="slot_appt_ctrl" id="slot_appt_ctrl" value="<%=slot_appt_ctrl%>">
	<input type="hidden" name="visit_limit_rule" id="visit_limit_rule" value="<%=visit_limit_rule%>" >
	<input type="hidden" name="oper_stn_id" id="oper_stn_id" value="<%=oper_stn_id%>">
	<input type="hidden" name="override_no_of_slots_yn" id="override_no_of_slots_yn" value="<%=override_no_of_slots_yn%>">
	<input type="hidden" name="install_yn_val" id="install_yn_val" value="<%=install_yn_val%>">
	<input type="hidden" name="display_validate_date" id="display_validate_date" value="<%=valid_date%>">
	<input type="hidden" name='or_catalogue_code' id='or_catalogue_code' value='<%=or_catalogue_code%>'>
	<input type='hidden' name='order_id' id='order_id' value='<%=order_id%>'>
	<input type='hidden' name='order_line_num' id='order_line_num' value='<%=order_line_num%>'>
	<input type='hidden' name='rd_appt_yn' id='rd_appt_yn' value='<%=rd_appt_yn%>'>
	<input type='hidden' name='order_catalog_code' id='order_catalog_code' value='<%=order_catalog_code%>'>
	<input type="hidden" name='capture_fin_dtls_yn' id='capture_fin_dtls_yn' value='<%=capture_fin_dtls_yn%>'>
	<input type="hidden" name='min_ela_per_resc_noshow_in_day' id='min_ela_per_resc_noshow_in_day' value='<%=min_ela_per_resc_noshow_in_day%>'>
	<input type="hidden" name='noshow_ctrl_by_splty_or_clinic' id='noshow_ctrl_by_splty_or_clinic' value='<%=noshow_ctrl_by_splty_or_clinic%>'>
	<input type="hidden" name='position' id='position' value='<%=position%>'>
	<input type="hidden" name='addtl_splty' id='addtl_splty' value='<%=addtl_splty%>'>


<%
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
	if (pstmt != null) pstmt.close();
}catch(Exception e) 
{ 
    //out.println("exception  here :" +e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
</form>
</body>
	<%
	if(!ca_mode.equals("ca_mode")){%>
		<script>
		document.forms[0].valid_date.focus();</script>
	<%}%>
</html>

