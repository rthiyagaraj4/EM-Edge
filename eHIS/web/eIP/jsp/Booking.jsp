<!DOCTYPE html>
 <!--
	This is the main booking page.
	From this page create booking,revise booing and confirm bookings are called
-->
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
%>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>		
	<script src='../../eIP/js/Booking1.js' language='javascript'></script>
	<script src='../../eIP/js/Booking.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String  facilityId			= (String)session.getAttribute("facility_id");
	String  loginUser			= (String)session.getAttribute("login_user");
	String  bkg_lst_ref_no		= checkForNull(request.getParameter("bkg_lst_ref_no"));
	String  is_ca_yn			= checkForNull(request.getParameter("is_ca_yn"));
	String  ca_patient_id		= checkForNull(request.getParameter("ca_patient_id"));
	String  oa_patient_id		= checkForNull(request.getParameter("oa_patient_id"));
	String	callFrom			= checkForNull(request.getParameter("callFrom"));
	String  wating_ref_no		= checkForNull(request.getParameter("wait_lst_ref_no"));
	String  pref_date_time		= checkForNull(request.getParameter("oa_pref_date_time"));
	String  is_oa_yn			= checkForNull(request.getParameter("is_oa_yn"));
	String	oper_stn_id			= checkForNull(request.getParameter("oper_stn_id"));
	String  revise_booking_yn	= checkForNull(request.getParameter("revise_booking_yn"));
	String  Confirm_booking_yn	= checkForNull(request.getParameter("confirm_booking_yn"));
	String  cr_boook_conf_yn	= checkForNull(request.getParameter("create_booking_with_conf_yn"),"N");
	String  create_booking_yn	= checkForNull(request.getParameter("create_booking_yn"));
    String  call_func			= checkForNull(request.getParameter("call_func"));
	String  referral_ID			= checkForNull(request.getParameter("referral_id"));
	String  menu_id  			= checkForNull(request.getParameter("menu_id"));
	String	is_op_pending_referral_booking = "N";
	String	params						= "";
	String	source						= "";
	String	url							= " ";
	String  Patient_Id					= "";
	String  booking_date_time			= "";
	String  call_function				= "";
	String  chk_booking_limit_by		= "";
	String  medical_service				= "";
	String  medical_speciality_code		= "";
	String  medical_speciality_desc		= "";
	String  physician_code				= "";
	String  physician_desc				= "";
	String  unregistered_patients_bkg_yn= "";
	String bl_interfaced_yn				= "";
	String capture_fin_dtls_yn			= "";
	boolean result 						= true;
	boolean flag						= false;	
    String  allowed_booking_type		= "";
    String  multi_book_pat_yn			= "N";
    String  block_bed_based_on			= "P";
	String oper_room_code				= "";
	String patient_class				= "";
	String oper_room_desc				= "";
	String nursing_unit_code			= "";
	String nursing_unit_desc			= "";
	String deactivate_pseudo_bed_yn		= "N";
	String sysdate						= "";
	String bkg_grace_period				= "";
	String PreOpPreparationDays			= "";

	if(call_func.equals("OT"))
	{
		Patient_Id				= checkForNull(request.getParameter("Patient_Id"));
		medical_service			= checkForNull(request.getParameter("medical_service"));
		booking_date_time		= checkForNull(request.getParameter("booking_date_time"));
		if(booking_date_time!=null && !booking_date_time.equals(""))
			booking_date_time = DateUtils.convertDate(booking_date_time,"DMYHM",localeName,"en");
		medical_speciality_desc	= checkForNull(request.getParameter("medical_speciality_desc"));
		medical_speciality_code	= checkForNull(request.getParameter("medical_speciality_code"));
		physician_desc			= checkForNull(request.getParameter("physician_desc"));
		
		physician_code			= checkForNull(request.getParameter("physician_code"));
		oper_room_code			= checkForNull(request.getParameter("oper_room_code"));
		patient_class			= checkForNull(request.getParameter("patient_class"));
		oper_room_desc			= checkForNull(request.getParameter("oper_room_desc"));

		nursing_unit_code		= checkForNull(request.getParameter("nursing_unit_code"));
		nursing_unit_desc		= checkForNull(request.getParameter("nursing_unit_desc"));
		PreOpPreparationDays	= checkForNull(request.getParameter("PreOpPreparationDays"));
	}
// example data
/*
call_func = "OT";
Patient_Id = "0000010013";
medical_speciality_desc= "Gen Med's";
medical_speciality_code = "01";
physician_desc ="Nanda Kumar";
physician_code ="NANDA";
booking_date_time = "25/10/2007 10:36";
*/

	if(call_func.equals("OP_Pending_Referral_Booking"))
		is_op_pending_referral_booking = "Y";

	if((!ca_patient_id.equals("")) && is_ca_yn.equals("Y"))
		call_function = "CA_Task_IP_Booking";
	else if((ca_patient_id.equals("")) && is_ca_yn.equals("Y"))
	      call_function = "CA_Clinician_IP_Booking";
	else if(is_oa_yn.equals("Y"))
		  call_function = "OA_IP_Booking";
	else 
		call_function = "IP_Booking";
	
	if(is_ca_yn.equals("") && is_oa_yn.equals(""))	
	{
		url	= "../../eCommon/jsp/commonToolbar.jsp?" ;
		params = request.getQueryString() ;
		source = url + params ;
	}
	else
	{
		 url	= "../../eCommon/jsp/commonToolbar.jsp?home_required_yn=N&module_id=IP&function_id=BOOKING&function_name=Create%20Booking&function_type=F&access=NYNNN";
		 params = request.getQueryString() ;
		 source = url + params ;
	}

	Connection	con		= null;
	ResultSet	rs		= null; 
	Statement	stmt	= null;
	ResultSet	rs1		= null; 
	ResultSet	rset	= null; 
	Statement	stmt1	= null;
	
	try
	{
		con		= ConnectionManager.getConnection(request);		
		stmt	= con.createStatement();		
		rs		= stmt.executeQuery(" select 1, allowed_booking_type, unregistered_patients_bkg_yn, chk_booking_limit_by, multi_book_pat_yn, bl_interfaced_yn, capture_fin_dtls_yn, block_bed_based_on,deactivate_pseudo_bed_yn,to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate,bkg_grace_period from IP_PARAM where facility_id='"+facilityId+"' ");

		if(rs.next())
		{       
			multi_book_pat_yn			= checkForNull(rs.getString("multi_book_pat_yn"),"N");
			allowed_booking_type		= rs.getString("allowed_booking_type");
			chk_booking_limit_by		= rs.getString("chk_booking_limit_by");
			bl_interfaced_yn			= checkForNull(rs.getString("BL_INTERFACED_YN"));
			capture_fin_dtls_yn			= checkForNull(rs.getString("CAPTURE_FIN_DTLS_YN"));
			block_bed_based_on			= checkForNull(rs.getString("block_bed_based_on"),"P");
			unregistered_patients_bkg_yn= checkForNull(rs.getString("unregistered_patients_bkg_yn"));  
			deactivate_pseudo_bed_yn    = checkForNull(rs.getString("deactivate_pseudo_bed_yn"),"N");  
			sysdate						= checkForNull(rs.getString("sdate"));
			bkg_grace_period			= checkForNull(rs.getString("bkg_grace_period"));

			if( !(callFrom.equals("Revise") || callFrom.equals("Confirm")) )
			{
				StringBuffer operSql = new StringBuffer();
				operSql.append("SELECT a.oper_stn_id OPER_STN_ID, a.create_booking_yn, a.create_booking_with_conf_yn, a.revise_booking_yn, a.confirm_booking_yn FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='");
				operSql.append(facilityId);	
				operSql.append("' AND a.facility_id = b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='");
				operSql.append(loginUser);
				operSql.append("' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))");
				stmt1 = con.createStatement();
				rs1   = stmt1.executeQuery(operSql.toString());

				if(rs1!=null)
				{
					if(rs1.next())
					{
						oper_stn_id		   = checkForNull(rs1.getString("OPER_STN_ID"));
						create_booking_yn  = checkForNull(rs1.getString("create_booking_yn"));	
						cr_boook_conf_yn   = checkForNull(rs1.getString("create_booking_with_conf_yn"));	
						revise_booking_yn  = checkForNull(rs1.getString("revise_booking_yn"));
						Confirm_booking_yn = checkForNull(rs1.getString("confirm_booking_yn"));	
					}	
					else
					{	%>
						<script>
						alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));
						if('<%=menu_id%>' != 'IP'){
						//location.href='../../eCommon/jsp/home.jsp?called_from=CA';
						window.close();
						}
						else
						document.location.href='../../eCommon/jsp/dmenu.jsp';
						</script>
			<%			result = false;
					}
				}
			}

			if (!oper_stn_id.equals("") && result && call_func.equals("OT"))
			{
				url	= "../../eCommon/jsp/commonToolbar.jsp?home_required_yn=N&module_id=IP&function_id=BOOKING&function_name=Create%20Booking&function_type=F&access=NYNNN";
				params = request.getQueryString() ;
				source = url + params ;				
				%>
				<title><fmt:message key="Common.booking.label" bundle="${common_labels}"/></title>
				<script language='javascript' src='../../eIP/js/Booking.js'></script>
				<script language='javascript' src='../../eIP/js/Booking1.js'></script>
				<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
				<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src="../../eIP/jsp/AddModifyBooking.jsp?chk_booking_limit_by=<%=chk_booking_limit_by%>&multi_book_pat_yn=<%=multi_book_pat_yn%>&block_bed_based_on=<%=block_bed_based_on%>&is_oa_yn=<%=is_oa_yn%>&call_function=<%=call_func%>&oa_wait_ref_no=<%=wating_ref_no%>&oa_pref_date_time=<%=pref_date_time%>&oa_patient_id=<%=oa_patient_id%>&oper_stn_id=<%=oper_stn_id%>&Patient_Id=<%=Patient_Id%>&medical_service=<%=medical_service%>&booking_date_time=<%=booking_date_time%>&allowed_booking_type=<%=allowed_booking_type%>&unregistered_patients_bkg_yn=<%=unregistered_patients_bkg_yn%>&medical_speciality_desc=<%=java.net.URLEncoder.encode(medical_speciality_desc,"UTF-8")%>&medical_speciality_code=<%=medical_speciality_code%>&physician_desc=<%=java.net.URLEncoder.encode(physician_desc,"UTF-8")%>&physician_code=<%=physician_code%>&oper_room_code=<%=oper_room_code%>&oper_room_desc=<%=java.net.URLEncoder.encode(oper_room_desc,"UTF-8")%>&patient_class=<%=patient_class%>&bl_interfaced_yn=<%=bl_interfaced_yn%>&capture_fin_dtls_yn=<%=capture_fin_dtls_yn%>&nursing_unit_code=<%=nursing_unit_code%>&nursing_unit_desc=<%=nursing_unit_desc%>&deactivate_pseudo_bed_yn=<%=deactivate_pseudo_bed_yn%>&create_booking_with_conf_yn=<%=cr_boook_conf_yn%>&sqlsd2=<%=java.net.URLEncoder.encode(sysdate)%>&bkg_grace_period=<%=bkg_grace_period%>&PreOpPreparationDays=<%=PreOpPreparationDays%>" frameborder=0 style='vertical-scroll-bar:yes;height:80vh;width:100vw'></iframe>
				<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:11vh;width:100vw'></iframe>
				<iframe name='dummyFrame' id='dummyFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:1vh;width:100vw'></iframe>	
				<%
			}
			else if (!oper_stn_id.equals("") && result)
			{
				try
				{
					if(!(callFrom.equals("Revise") || callFrom.equals("Confirm")))
					{
						//Checking for the oprator station acces for nursing units
						StringBuffer sql = new StringBuffer();
						sql.append("SELECT distinct(locn_code) FROM am_locn_for_oper_stn WHERE facility_id = '"+facilityId+"' ");
						sql.append(" AND locn_type = 'N' AND eff_status = 'E' AND oper_stn_id = '"+oper_stn_id+"' ");
						rset = stmt.executeQuery(sql.toString());

	

						if (!rset.next())
						{ %>
							<script>
							alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));
							document.location.href='../../eCommon/jsp/dmenu.jsp';
							</script>
				<%		result = false;
						}
						if (rset != null)   rset.close();
					}
				}
				catch(Exception e) 
				{ 
					result = false; 
					//out.println(e.toString());
					e.printStackTrace();
				}

				
				/*if(!(callFrom.equals("Revise") || callFrom.equals("Confirm")))
				{
					StringBuffer  sqltfr = new StringBuffer();
					sqltfr.append("select create_booking_yn,CREATE_BOOKING_WITH_CONF_YN,REVISE_BOOKING_YN,CONFIRM_BOOKING_YN from am_oper_stn where facility_id = '");
					sqltfr.append(facilityId);
					sqltfr.append("' and oper_stn_id = (select oper_stn_id from am_user_for_oper_stn  ");
					sqltfr.append(" where facility_id='");
					sqltfr.append(facilityId);
					sqltfr.append("' and appl_user_id ='");
					sqltfr.append(loginUser);
					sqltfr.append("' and trunc(sysdate) between eff_date_from and nvl(eff_date_to,trunc(sysdate)))");

					rs = stmt.executeQuery(sqltfr.toString());		
					if(rs!= null)
					{		
						if(rs.next())			
						{			
							create_booking_yn  = checkForNull(rs.getString(1));	
							cr_boook_conf_yn   = checkForNull(rs.getString(2));	
							revise_booking_yn  = checkForNull(rs.getString(3));
							Confirm_booking_yn = checkForNull(rs.getString(4));	
						}
					}
				}*/
//out.println("<script>alert(\"revise_booking_yn:"+revise_booking_yn+"\");</script>");
//out.println("<script>alert(\"Confirm_booking_yn:"+Confirm_booking_yn+"\");</script>");
				if(create_booking_yn.equals("Y") || cr_boook_conf_yn.equals("Y") || revise_booking_yn.equals("Y") || Confirm_booking_yn.equals("Y"))
				{
					flag = true;
				}

				if(flag)
				{		
					if(is_ca_yn.equals("") && is_oa_yn.equals(""))
					{	
						if(bkg_lst_ref_no == "")
						{
							if(create_booking_yn.equals("Y") || cr_boook_conf_yn.equals("Y"))
							{	
								
								%>
								<title><fmt:message key="Common.booking.label" bundle="${common_labels}"/></title>
								<script language='javascript' src='../js/Booking.js'></script>
								<script language='javascript' src='../js/Booking1.js'></script>
								<script language='javascript' src='../../eCommon/js/dchk.js'></script>
								<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
								<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../../eIP/jsp/AddModifyBooking.jsp?chk_booking_limit_by=<%=chk_booking_limit_by%>&allowed_booking_type=<%=allowed_booking_type%>&oper_stn_id=<%=oper_stn_id%>&multi_book_pat_yn=<%=multi_book_pat_yn%>&block_bed_based_on=<%=block_bed_based_on%>&unregistered_patients_bkg_yn=<%=unregistered_patients_bkg_yn%>&bl_interfaced_yn=<%=bl_interfaced_yn%>&capture_fin_dtls_yn=<%=capture_fin_dtls_yn%>&is_op_pending_referral_booking=<%=is_op_pending_referral_booking%>&referral_id=<%=referral_ID%>&deactivate_pseudo_bed_yn=<%=deactivate_pseudo_bed_yn%>&create_booking_with_conf_yn=<%=cr_boook_conf_yn%>&sqlsd2=<%=java.net.URLEncoder.encode(sysdate)%>&bkg_grace_period=<%=bkg_grace_period%>' frameborder=0 style='vertical-scroll-bar:yes;height:80vh;width:100vw'></iframe>
								<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
								<iframe name='dummyFrame' id='dummyFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:1vh;width:100vw'></iframe>
								<%
							}
							else
							{	%>
								<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'))</script>
								<script>document.location.href ='../../eCommon/jsp/dmenu.jsp'</script>
						<%	}
						}
						else
						{	
							if(callFrom.equals("Revise"))
							{	
							%>	
								<title><fmt:message key="Common.revisebooking.label" bundle="${common_labels}"/></title>
								<script language='javascript' src='../js/ReviseBooking.js'></script> 
								<script language='javascript' src='../../eCommon/js/dchk.js'></script> 
								<script src='../../eCommon/js/common.js' language='javascript'></script>		
								<iframe name='commontoolbarFrame' id='commontoolbarFrame'  frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
								<iframe name='f_query_add_mod' id='f_query_add_mod' src='../jsp/AddModifyReviseBooking.jsp?function_id=AMEND_BOOKING&bkg_lst_ref_no=<%=java.net.URLEncoder.encode(bkg_lst_ref_no)%>&oper_stn_id=<%=oper_stn_id%>&multi_book_pat_yn=<%=multi_book_pat_yn%>&block_bed_based_on=<%=block_bed_based_on%>&bl_interfaced_yn=<%=bl_interfaced_yn%>&capture_fin_dtls_yn=<%=capture_fin_dtls_yn%>&deactivate_pseudo_bed_yn=<%=deactivate_pseudo_bed_yn%>&chk_booking_limit_by=<%=chk_booking_limit_by%>' frameborder=0 style='vertical-scroll-bar:yes;height:80vh;width:100vw'></iframe>
								<iframe name='messageFrame' id='messageFrame' 	  src='../jsp/ReviseBookingerror.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
								<iframe name='dummyFrame' id='dummyFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>
						<%	}

							if(callFrom.equals("Confirm"))
							{	%>
								<title><fmt:message key="Common.ConfirmBooking.label" bundle="${common_labels}"/></title>
								<script language='javascript' src='../js/ConfirmBooking.js'></script>        
								<iframe name='commontoolbarFrame' id='commontoolbarFrame' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
								<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../jsp/AddModifyConfirmBooking.jsp?chk_booking_limit_by=<%=chk_booking_limit_by%>&bkg_lst_ref_no=<%=java.net.URLEncoder.encode(bkg_lst_ref_no)%>&oper_stn_id=<%=oper_stn_id%>&multi_book_pat_yn=<%=multi_book_pat_yn%>&block_bed_based_on=<%=block_bed_based_on%>&bl_interfaced_yn=<%=bl_interfaced_yn%>&capture_fin_dtls_yn=<%=capture_fin_dtls_yn%>&deactivate_pseudo_bed_yn=<%=deactivate_pseudo_bed_yn%>' frameborder=0 scrolling='yes' scrolling='auto' style='height:80vh;width:100vw'></iframe>
								<iframe name='messageFrame' id='messageFrame' 	 src='../jsp/ReviseBookingerror.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
								<iframe name='dummyFrame' id='dummyFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>
						<%	}
						}
					}
					else if(is_ca_yn.equals("Y"))
					{
						
						%>
						<title><fmt:message key="Common.booking.label" bundle="${common_labels}"/></title>
						<script language='javascript' src='../../eIP/js/Booking.js'></script>
						<script language='javascript' src='../../eIP/js/Booking1.js'></script>
						<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
						<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../../eIP/jsp/AddModifyBooking.jsp?chk_booking_limit_by=<%=chk_booking_limit_by%>&is_ca_yn=<%=is_ca_yn%>&call_function=<%=java.net.URLEncoder.encode(call_function)%>&ca_patient_id=<%=java.net.URLEncoder.encode(ca_patient_id)%>&oper_stn_id=<%=oper_stn_id%>&allowed_booking_type=<%=allowed_booking_type%>&multi_book_pat_yn=<%=multi_book_pat_yn%>&block_bed_based_on<%=block_bed_based_on%>&unregistered_patients_bkg_yn=<%=unregistered_patients_bkg_yn%>&bl_interfaced_yn=<%=bl_interfaced_yn%>&capture_fin_dtls_yn=<%=capture_fin_dtls_yn%>&deactivate_pseudo_bed_yn=<%=deactivate_pseudo_bed_yn%>&create_booking_with_conf_yn=<%=cr_boook_conf_yn%>&sqlsd2=<%=java.net.URLEncoder.encode(sysdate)%>&bkg_grace_period=<%=bkg_grace_period%>' frameborder=0  style='vertical-scroll-bar:yes;height:80vh;width:100vw'></iframe>
						<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
						<iframe name='dummyFrame' id='dummyFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:1vh;width:100vw'></iframe>	
						<%
					}
					else
					{
						
						%>
						<title><fmt:message key="Common.booking.label" bundle="${common_labels}"/></title>
						<script language='javascript' src='../../eIP/js/Booking.js'></script>
						<script language='javascript' src='../../eIP/js/Booking1.js'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



						<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:12vh;width:100vw'></iframe>
						<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../../eIP/jsp/AddModifyBooking.jsp?chk_booking_limit_by=<%=chk_booking_limit_by%>&is_oa_yn=<%=is_oa_yn%>&call_function=<%=java.net.URLEncoder.encode(call_function)%>&oa_wait_ref_no=<%=java.net.URLEncoder.encode(wating_ref_no)%>&oa_pref_date_time=<%=java.net.URLEncoder.encode(pref_date_time)%>&oa_patient_id=<%=java.net.URLEncoder.encode(oa_patient_id)%>&oper_stn_id=<%=oper_stn_id%>&allowed_booking_type=<%=allowed_booking_type%>&multi_book_pat_yn=<%=multi_book_pat_yn%>&block_bed_based_on<%=block_bed_based_on%>&unregistered_patients_bkg_yn=<%=unregistered_patients_bkg_yn%>&bl_interfaced_yn=<%=bl_interfaced_yn%>&capture_fin_dtls_yn=<%=capture_fin_dtls_yn%>&deactivate_pseudo_bed_yn=<%=deactivate_pseudo_bed_yn%>&create_booking_with_conf_yn=<%=cr_boook_conf_yn%>&sqlsd2=<%=java.net.URLEncoder.encode(sysdate)%>&bkg_grace_period=<%=bkg_grace_period%>' frameborder=0  style='vertical-scroll-bar:yes;height:80vh;width:100vw'></iframe>
						<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
						<iframe name='dummyFrame' id='dummyFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:1vh;width:100vw'></iframe>	
				<%	}
				}
				else
				{
					if(is_ca_yn.equals(""))
					{	%>
						<script>
						alert(getMessage('OPER_STN_FUNC_RESTRN','IP'));
						document.location.href='../../eCommon/jsp/dmenu.jsp';
						//window.parent.close();
						</script>
				<%	}
					else
					{	%>
						<script>
						alert(getMessage('OPER_STN_FUNC_RESTRN','IP'));
						document.location.href='../../eCommon/jsp/dmenu.jsp';
						//window.parent.close();
						</script>
				<%	}
				}
			}
		}
		else
		{
			if(is_ca_yn.equals(""))
			{	%>
				<script>
				alert(getMessage('IP_PARAM_NOT_FOUND','IP'));
				document.location.href ='../../eCommon/jsp/dmenu.jsp';
				</script>
		<%	}
			else
			{ %>
				<script>
				alert(getMessage('IP_PARAM_NOT_FOUND','IP'));
				document.location.href='../../eCommon/jsp/dmenu.jsp';
				//window.parent.close();
				</script>
		<%	}
		}
		if(rs!=null) rs.close();
		if(rs1!=null) rs.close();
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
		if(stmt1!=null) stmt1.close();

	}catch(Exception e)
	{	
		//out.println("Exception in Booking.jsp : "+ e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

