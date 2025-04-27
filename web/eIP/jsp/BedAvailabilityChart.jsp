<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,java.net.*,eCommon.XSSRequestWrapper" %>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue

	String call_func		= checkForNull(request.getParameter("P_call_func")); //added by chitra to invoke Admit Patient from Bed Chart
	String ipparam_bed_yn	= checkForNull(request.getParameter("ipparam_bed_yn"));
	String nursingunitcode	= checkForNull(request.getParameter("nursing_unit_code"));
	String patient_id		= checkForNull(request.getParameter("patient_id"));
	String practitionerid	= checkForNull(request.getParameter("practitioner_id"));
	String practitioner_desc= checkForNull(request.getParameter("practitioner_desc"));
	String specialitycode	= checkForNull(request.getParameter("speciality_code"));
	String bedclasscode		= checkForNull(request.getParameter("bed_class_code"));
	String bed_type			= checkForNull(request.getParameter("bed_type"));
	String age				= checkForNull(request.getParameter("age"));
	String gender			= checkForNull(request.getParameter("gender"));
	String wherecondn 		= checkForNull(request.getParameter("wherecondn"));
	String disable_field 	= checkForNull(request.getParameter("disable_field"));
	String patient_class 	= checkForNull(request.getParameter("patient_class"));
	String bedClass_dis_yn 	= checkForNull(request.getParameter("bedClass_dis_yn"));
	String room_no_code 	= checkForNull(request.getParameter("room_no_code"));
// Added by Sridhar R 
	String main_bed_no 		= checkForNull(request.getParameter("main_bed_no"));
	String med_service_grp	= checkForNull(request.getParameter("med_service_grp"));
	String call_function 	= checkForNull(request.getParameter("call_function"));
	String facility_id		= (String)session.getValue("facility_id");
	String loginUser		= (String)session.getValue("login_user");
	String oper_stn_id		= checkForNull(request.getParameter("oper_stn_id"));
	String enable_bed_date	= checkForNull(request.getParameter("enable_bed_date"),"N");
	String reserve_bed_selectable	= checkForNull(request.getParameter("reserve_bed_selectable"),"N");
	String create_booking_admission_date_time	= checkForNull(request.getParameter("create_booking_admission_date_time"));
	String exp_discharge_date	= checkForNull(request.getParameter("exp_discharge_date"));
	String bed_booking_ref_no	= checkForNull(request.getParameter("bed_booking_ref_no"));
	//out.println("<script>alert(\""+request.getQueryString()+"\");</script>");
	if(oper_stn_id.equals(""))
	{
		Connection con			= null;
		Statement stmt_oper		= null;
		ResultSet rs_oper		= null;

		try
		{
			con	= ConnectionManager.getConnection();
			String operSql = " select a.oper_stn_id oper_stn_id from AM_OPER_STN a, AM_USER_FOR_OPER_STN b where a.facility_id='"+facility_id+"' and a.facility_id=b.facility_id	and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"+loginUser+"' and trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate)) ";
			stmt_oper = con.createStatement();
			rs_oper = stmt_oper.executeQuery(operSql);
			if (rs_oper.next())
			{
				oper_stn_id	 = checkForNull(rs_oper.getString("oper_stn_id"));
			}
		}catch (Exception exp)
		{
			exp.printStackTrace();
		}
		finally 
		{
			ConnectionManager.returnConnection(con);
		}
	}
%>
<head>
	<title><fmt:message key="eIP.BedAvailabilityChart.label" bundle="${ip_labels}"/></title>
</head>

<%	if (!call_func.equals("ADMIT") && !call_func.equals("QUERY_BED_AVAIL")) 
	{	%>
		<iframe name='processBar' frameborder=0  noresize  scrolling='no' style='height:0.1vh;width:99vw'></iframe>
		<iframe name='criteria0' src='../jsp/BedAvailabilityChartCriteria0.jsp?P_call_func=<%=java.net.URLEncoder.encode(call_func)%>&nursing_unit_code=<%=java.net.URLEncoder.encode(nursingunitcode)%>&reserve_bed_selectable=<%=reserve_bed_selectable%>&patient_id=<%=patient_id%>&enable_bed_date=<%=enable_bed_date%>&med_service_grp=<%=java.net.URLEncoder.encode(med_service_grp)%>&practitioner_id=<%=java.net.URLEncoder.encode(practitionerid)%>&ipparam_bed_yn=<%=ipparam_bed_yn%>&speciality_code=<%=java.net.URLEncoder.encode(specialitycode)%>&bed_class_code=<%=java.net.URLEncoder.encode(bedclasscode)%>&bed_type=<%=java.net.URLEncoder.encode(bed_type)%>&age=<%=java.net.URLEncoder.encode(age)%>&gender=<%=java.net.URLEncoder.encode(gender)%>&practitioner_desc=<%=java.net.URLEncoder.encode(practitioner_desc)%>&wherecondn=<%=java.net.URLEncoder.encode(wherecondn)%>&disable_field=<%=java.net.URLEncoder.encode(disable_field)%>&bedClass_dis_yn=<%=java.net.URLEncoder.encode(bedClass_dis_yn)%>&main_bed_no=<%=java.net.URLEncoder.encode(main_bed_no)%>&call_function=<%=java.net.URLEncoder.encode(call_function)%>&oper_stn_id=<%=java.net.URLEncoder.encode(oper_stn_id)%>&patient_class=<%=java.net.URLEncoder.encode(patient_class)%>&room_no_code=<%=java.net.URLEncoder.encode(room_no_code)%>&exp_discharge_date=<%=exp_discharge_date%>&create_booking_admission_date_time=<%=java.net.URLEncoder.encode(create_booking_admission_date_time)%>&bed_booking_ref_no=<%=java.net.URLEncoder.encode(bed_booking_ref_no)%>'  frameborder=0 scrolling='no' style='height:32vh;width:99vw'></iframe>
		<iframe name='result' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling=auto style='height:34vh;width:99vw'></iframe>
		<iframe name='dummy' src='../../eCommon/html/blank.html' frameborder=0  scrolling='no' style='height:2vh;width:99vw'></iframe>
		<iframe name='status' src='../jsp/CheckBoxStatus.jsp' frameborder=0 noresize scrolling='no' style='height:22vh;width:99vw'></iframe>
<%	}
	else
	{	%>
		<iframe name='processBar' frameborder=0  noresize  scrolling='no' style='height:0vh;width:99vw'></iframe>
		<iframe name='criteria0' src='../jsp/BedAvailabilityChartCriteria0.jsp?P_call_func=<%=java.net.URLEncoder.encode(call_func)%>&nursing_unit_code=<%=java.net.URLEncoder.encode(nursingunitcode)%>&reserve_bed_selectable=<%=reserve_bed_selectable%>&patient_id=<%=patient_id%>&enable_bed_date=<%=enable_bed_date%>&med_service_grp=<%=java.net.URLEncoder.encode(med_service_grp)%>&practitioner_id=<%=java.net.URLEncoder.encode(practitionerid)%>&ipparam_bed_yn=<%=ipparam_bed_yn%>&speciality_code=<%=java.net.URLEncoder.encode(specialitycode)%>&bed_class_code=<%=java.net.URLEncoder.encode(bedclasscode)%>&bed_type=<%=java.net.URLEncoder.encode(bed_type)%>&age=<%=java.net.URLEncoder.encode(age)%>&gender=<%=java.net.URLEncoder.encode(gender)%>&practitioner_desc=<%=java.net.URLEncoder.encode(practitioner_desc)%>&wherecondn=<%=java.net.URLEncoder.encode(wherecondn)%>&disable_field=<%=java.net.URLEncoder.encode(disable_field)%>&bedClass_dis_yn=<%=java.net.URLEncoder.encode(bedClass_dis_yn)%>&main_bed_no=<%=java.net.URLEncoder.encode(main_bed_no)%>&call_function=<%=java.net.URLEncoder.encode(call_function)%>&oper_stn_id=<%=java.net.URLEncoder.encode(oper_stn_id)%>&patient_class=<%=java.net.URLEncoder.encode(patient_class)%>&room_no_code=<%=java.net.URLEncoder.encode(room_no_code)%>&exp_discharge_date=<%=exp_discharge_date%>&create_booking_admission_date_time=<%=java.net.URLEncoder.encode(create_booking_admission_date_time)%>&bed_booking_ref_no=<%=java.net.URLEncoder.encode(bed_booking_ref_no)%>'  frameborder=0 scrolling='no' style='height:32vh;width:99vw'></iframe>
		<iframe name='result' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling=auto style='height:34vh;width:99vw'></iframe>
		<iframe name='dummy' src='../../eCommon/html/blank.html' frameborder=0  scrolling='no' style='height:2vh;width:99vw'></iframe>
		<iframe name='status' src='../jsp/CheckBoxStatus.jsp' frameborder=0 noresize scrolling='no' style='height:22vh;width:99vw'></iframe>
<%	}	%>
	
		
</html>

<%!
// Added by Sridhar R on 2/23/2005... 
// This func will check for null values & return empty string if Null...
	private String checkForNull(String inputString)
	{
		return (inputString==null)? "" : inputString;
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}

%>
