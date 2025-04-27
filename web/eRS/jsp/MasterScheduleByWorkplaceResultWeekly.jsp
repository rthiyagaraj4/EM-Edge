<!DOCTYPE html>
<%/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	MasterSheduleByWorkplaceResultWeekly.jsp
*	Purpose 			:
*	Created By		:	Subbulakshmy. K
*	Created On		:	04-12-2004
*/
%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp"%> 
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- <link rel='stylesheet' type='text/css' href='../../eRS/html/RSStylesheet.css'></link> -->
<script language="JavaScript" src="../../eRS/js/MasterSchedule.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<% 
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String mode			= request.getParameter("mode")==null?"":request.getParameter("mode");
	String facility_id		= request.getParameter("facility_id")==null?"":request.getParameter("facility_id") ;
	String user_id			=request.getParameter("user_id")==null?"":request.getParameter("user_id");
	String function_id= request.getParameter( "function_id")==null?"":request.getParameter( "function_id");
	String workplace_code= request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
	String requirement_id	= request.getParameter("requirement_id")==null?"":request.getParameter("requirement_id");
	String locn_type				= request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
	String role_type		=request.getParameter("role_type")==null?"":request.getParameter("role_type") ;
	String staff_type	=request.getParameter("staff_type")==null?"":request.getParameter("staff_type");
	String position_code= request.getParameter("position_code")==null?"":request.getParameter("position_code");
	String staff_id			=request.getParameter("staff_id")==null?"":request.getParameter("staff_id") ;
	String view				=request.getParameter("view")==null?"":request.getParameter("view");
	int week_no =Integer.parseInt(request.getParameter("week_no")==null?"0":request.getParameter("week_no"));
	int total_records=0;
	String classval="";
	Connection conn 		= null;

	PreparedStatement pstmt_Req_Total	= null;
	PreparedStatement pstmt_Alloc_Total	= null;
	PreparedStatement pstmt_Shiftwise_Req 		= null;
	PreparedStatement pstmt_Positionwise_Req 	= null;
	PreparedStatement pstmt_Shiftwise_Alloc 		= null;
	PreparedStatement pstmt_Positionwise_Alloc= null;
	PreparedStatement pstmt_Day_Indicator 		= null;
	PreparedStatement pstmt_Staff_List 		= null;
	PreparedStatement pstmt_Position_Desc 	= null;
	PreparedStatement pstmt_Unproductive	 =	 null;
	PreparedStatement pstmt_Oncall_Req	 =	 null;
	PreparedStatement pstmt_Unprod_Alloc	 =	 null;

	ResultSet rs_Req_Total		 		= null;
	ResultSet rs_Alloc_Total	 		= null;
	ResultSet rs_Shiftwise_Req 		= null;
	ResultSet rs_Positionwise_Req	= null;
	ResultSet rs_Shiftwise_Alloc 		= null;
	ResultSet rs_Positionwise_Alloc	= null;
	ResultSet rs_Day_Indicator 		= null;
	ResultSet rs_Staff_List 				= null;
	ResultSet rs_Position_Desc		= null;
	ResultSet rs_Unproductive			=	null;
	ResultSet rs_Oncall_Req			=	null;
	ResultSet rs_Unprod_Alloc			=	null;

	ArrayList Staff_Data		= new ArrayList() ;
	ArrayList Shift_Data		= new ArrayList() ;
	ArrayList PositionShift_Data		= new ArrayList() ;
	ArrayList req_Optimal_Values		= new ArrayList() ;
	ArrayList Oncall_Req			= new ArrayList() ;
	ArrayList Day_Indicator		= new ArrayList() ;
	ArrayList Positionwise_Req		= new ArrayList() ;
	ArrayList	Unproductive_Shift		=	new ArrayList();
	ArrayList	Oncall_Shift		=	new ArrayList();

	HashMap Positionwise_Alloc		= new HashMap() ;
	HashMap Shiftwise_Req		= new HashMap() ;
	HashMap Shiftwise_Alloc		= new HashMap() ;
	HashMap Shift_Dtl					= new HashMap() ;
	HashMap PositionShift_Dtl	= new HashMap() ;

	int Allocated_Values[] = new int[7];
	int Oncall_Allocated[] = new int[7];
	//int Oncall_Required[] = new int[7];
	int Unprod_Allocated[] = new int[7];
	int Shift_Allocated_Values[] = new int[7];
	int Posit_Allocated_Values[] = new int[7];
	int totalShifts=0;
	int day_no=0;
	int day_count=0;
	int day=0;
	int req_val=0;
	int alloc_val=0;
	int shift_count=0;

	String[] record		     = null;
	String[] position_record = null;
	String[] shift_record	 = null;
	String[] shift_req       = null;
	//String[] shift_alloc     = null;
	//String[] position_req    = null;
	String[] staff_data      = null;

	String posit_code="";
	String shift_code="";
	String prev_staff="";
	String role_typ="";
	String prev_role="";
	String staff_typ="";
	String staff_id1="";
	String staff_name="";
	String shift_cod="";
	String shift_mnemonic="";
	String prod_flag="";
	String shift_indicator="";
	String sql_staff_list="";
	String sql_unproductive_shift="";
	String p_shift_code="";
	String p_shift_mnemonic="";
	String u_shift_code="";
	String u_shift_mnemonic="";
	String o_shift_code="";
	String o_shift_mnemonic="";
	conn = ConnectionManager.getConnection(request);
	try {
		if(view.equals("aloc"))

			sql_staff_list="select a.role_type, a.staff_type, a.staff_id, b.shift_code, c.productive_flag, c.shift_indicator,b.shift_mnemonic, b.day_no, d.staff_name from rs_staff_for_workplace a, rs_master_schedule b, am_shift c, am_staff_vw d where a.facility_id=? and a.workplace_code=? and (? is null or a.role_type = ?) and (? is null or a.staff_type = ?) AND (? IS NULL OR a.staff_id = ?) and (a.role_type, a.staff_id) in ( select x.role_type, x.staff_id from am_staff_vw x where x.position_code in (select distinct position_code from rs_workplace_requirement_dtl where facility_id=? and workplace_code=? and requirement_id=? and position_code=?)) and b.facility_id = ? and b.workplace_code = ? and b.requirement_id = ? and b.position_code = ? and b.week_no=? and b.role_type = a.role_type and b.staff_id = a.staff_id and c.shift_code = b.shift_code and a.staff_id=d.staff_id and a.role_type=d.role_type  and d.language_id = ? order by d.staff_name, b.day_no";

		else 
			sql_staff_list="select a.role_type, a.staff_type, a.staff_id, b.shift_code,c.productive_flag, c.shift_indicator, b.shift_mnemonic, b.day_no, d.staff_name from rs_staff_for_workplace a, rs_master_schedule b, am_shift c, am_staff_vw d where a.facility_id=? and a.workplace_code=? and (? is null or a.role_type = ?) and (? is null or a.staff_type = ?) AND (? IS NULL OR a.staff_id = ?) and (a.role_type, a.staff_id) in ( select x.role_type, x.staff_id from am_staff_vw x where x.position_code in (select distinct position_code from rs_workplace_requirement_dtl where facility_id=? and workplace_code=? and requirement_id=? and position_code=?)) and b.facility_id(+) = ? and b.workplace_code(+) = ? and b.requirement_id(+) = ? and b.position_code(+) = ? and b.week_no(+)=? and b.role_type(+) = a.role_type and b.staff_id(+) = a.staff_id and c.shift_code(+) = b.shift_code and a.role_type = d.role_type and a.staff_id = d.staff_id and d.language_id = ? order by d.staff_name, b.day_no";

		//to get the Day Indicator
		String sql_day_indicator="select week_"+week_no+"_day_1 day1, week_"+week_no+"_day_2 day2, week_"+week_no+"_day_3 day3, week_"+week_no+"_day_4 day4, week_"+week_no+"_day_5 day5, week_"+week_no+"_day_6 day6,week_"+week_no+"_day_7 day7 from rs_workplace where facility_id=?and workplace_code=?";

		pstmt_Day_Indicator = conn.prepareStatement( sql_day_indicator);
		pstmt_Day_Indicator.setString(1,facility_id);
		pstmt_Day_Indicator.setString(2,workplace_code);
		rs_Day_Indicator = pstmt_Day_Indicator.executeQuery() ;
		while (rs_Day_Indicator != null && rs_Day_Indicator.next()) {
			record = new String[7];				
			record[0] = rs_Day_Indicator.getString("day1");
			record[1] = rs_Day_Indicator.getString("day2");
			record[2] = rs_Day_Indicator.getString("day3");
			record[3] = rs_Day_Indicator.getString("day4");
			record[4] = rs_Day_Indicator.getString("day5");
			record[5] = rs_Day_Indicator.getString("day6");
			record[6] = rs_Day_Indicator.getString("day7");
			Day_Indicator.add(record) ;
		}
		if(pstmt_Day_Indicator !=null)
			pstmt_Day_Indicator.close();
		if(rs_Day_Indicator !=null)
			rs_Day_Indicator.close();

		//to get the Day Totals Requirements
		String sql_req_total="select sum(a.fr_wday_opt) fr_wday_opt, sum(a.fr_nwday_opt) fr_nwday_opt, sum(a.fr_hday_opt)fr_hday_opt from rs_workplace_requirement_dtl a, am_shift b  where a.facility_id =? and a.workplace_code = ? and a.requirement_id = ? and b.shift_code = a.shift_code and b.productive_flag is not null and b.productive_flag ='W' ";
		pstmt_Req_Total = conn.prepareStatement( sql_req_total);
		pstmt_Req_Total.setString(1,facility_id);
		pstmt_Req_Total.setString(2,workplace_code);
		pstmt_Req_Total.setString(3,requirement_id);
		rs_Req_Total = pstmt_Req_Total.executeQuery() ;
		while (rs_Req_Total != null && rs_Req_Total.next()) {
			req_Optimal_Values.add(rs_Req_Total.getString("fr_wday_opt")) ;
			req_Optimal_Values.add(rs_Req_Total.getString("fr_nwday_opt")) ;
			req_Optimal_Values.add(rs_Req_Total.getString("fr_hday_opt")) ;
		}
		if(pstmt_Req_Total !=null)
			pstmt_Req_Total.close();
		if(rs_Req_Total !=null)
			rs_Req_Total.close();

		String sql_oncall_req="select sum(a.fr_wday_opt) fr_wday_opt, sum(a.fr_nwday_opt) fr_nwday_opt, sum(a.fr_hday_opt)fr_hday_opt from rs_workplace_requirement_dtl a, am_shift b  where a.facility_id =? and a.workplace_code = ? and a.requirement_id = ? and b.shift_code = a.shift_code and b.productive_flag is not null and b.productive_flag ='O' ";
		pstmt_Oncall_Req = conn.prepareStatement( sql_oncall_req);
		pstmt_Oncall_Req.setString(1,facility_id);
		pstmt_Oncall_Req.setString(2,workplace_code);
		pstmt_Oncall_Req.setString(3,requirement_id);
		rs_Oncall_Req = pstmt_Oncall_Req.executeQuery() ;
		while ((rs_Oncall_Req != null) && rs_Oncall_Req.next()) {
			Oncall_Req.add(rs_Oncall_Req.getString("fr_wday_opt")) ;
			Oncall_Req.add(rs_Oncall_Req.getString("fr_nwday_opt")) ;
			Oncall_Req.add(rs_Oncall_Req.getString("fr_hday_opt")) ;
		}
		if(pstmt_Oncall_Req !=null)
			pstmt_Oncall_Req.close();
		if(rs_Oncall_Req !=null)
			rs_Oncall_Req.close();

		//to get the Day allocated total
		String sql_allocated_total="select week_no,day_no,nvl(count(staff_id),0) no_of_staff, b.productive_flag from rs_master_schedule a, am_shift b where facility_id = ? and workplace_code = ? and requirement_id = ? and week_no=?  and b.shift_code = a.shift_code and b.productive_flag is not null and b.productive_flag in ('W','O')  group by week_no,day_no, b.productive_flag order by week_no,day_no";
		pstmt_Alloc_Total = conn.prepareStatement( sql_allocated_total);
		pstmt_Alloc_Total.setString(1,facility_id);
		pstmt_Alloc_Total.setString(2,workplace_code);
		pstmt_Alloc_Total.setString(3,requirement_id);
		pstmt_Alloc_Total.setString(4,String.valueOf(week_no));
		rs_Alloc_Total = pstmt_Alloc_Total.executeQuery() ;
		while (rs_Alloc_Total != null && rs_Alloc_Total.next()) {
			String p_flag =rs_Alloc_Total.getString("productive_flag");
			if((p_flag!=null)&&(p_flag.equals("W"))){
				day_no=Integer.parseInt(rs_Alloc_Total.getString("day_no")==null?"0":rs_Alloc_Total.getString("day_no"));
				Allocated_Values[day_no-1]=Integer.parseInt(rs_Alloc_Total.getString("no_of_staff")==null?"0":rs_Alloc_Total.getString("no_of_staff"));
			}else{
				day_no=Integer.parseInt(rs_Alloc_Total.getString("day_no")==null?"0":rs_Alloc_Total.getString("day_no"));
				Oncall_Allocated[day_no-1]=Integer.parseInt(rs_Alloc_Total.getString("no_of_staff")==null?"0":rs_Alloc_Total.getString("no_of_staff"));
			}
		}
		if(pstmt_Alloc_Total !=null)
			pstmt_Alloc_Total.close();
		if(rs_Alloc_Total !=null)
			rs_Alloc_Total.close();

		String sql_unproductive_allocated="SELECT   week_no, day_no, NVL (COUNT (staff_id), 0) no_of_staff    FROM rs_master_schedule a, am_shift b  WHERE facility_id = ?  AND workplace_code = ? AND week_no = ? AND b.shift_code = a.shift_code AND b.shift_indicator = 'U' and a.requirement_id=? GROUP BY week_no, day_no, b.shift_indicator ORDER BY week_no, day_no";
		pstmt_Unprod_Alloc = conn.prepareStatement( sql_unproductive_allocated);
		pstmt_Unprod_Alloc.setString(1,facility_id);
		pstmt_Unprod_Alloc.setString(2,workplace_code);
		pstmt_Unprod_Alloc.setString(3,String.valueOf(week_no));
		pstmt_Unprod_Alloc.setString(4,requirement_id);
		rs_Unprod_Alloc = pstmt_Unprod_Alloc.executeQuery() ;
		while (rs_Unprod_Alloc != null && rs_Unprod_Alloc.next()) {
			week_no	=	Integer.parseInt(rs_Unprod_Alloc.getString("week_no")==null?"0":rs_Unprod_Alloc.getString("week_no"));
			day=Integer.parseInt(rs_Unprod_Alloc.getString("day_no")==null?"0":rs_Unprod_Alloc.getString("day_no"));
			day_no=((week_no-1)*7)+day;
			Unprod_Allocated[day_no-1]=Integer.parseInt(rs_Unprod_Alloc.getString("no_of_staff")==null?"0":rs_Unprod_Alloc.getString("no_of_staff"));
		}
		if(pstmt_Unprod_Alloc !=null)
			pstmt_Unprod_Alloc.close();
		if(rs_Unprod_Alloc !=null)
			rs_Unprod_Alloc.close();

		//to get the Shiftwise Requirements Total
		String sql_shiftwise_total="SELECT   a.shift_code, b.mnemonic_key shift_mnemonic, SUM (a.fr_wday_opt) fr_wday_opt, SUM (a.fr_nwday_opt) fr_nwday_opt, SUM (a.fr_hday_opt) fr_hday_opt, b.short_desc FROM rs_workplace_requirement_dtl a, am_shift_lang_vw b WHERE a.facility_id = ? AND  b.language_id = ? and a.workplace_code = ? AND a.requirement_id = ? and a.shift_code=b.SHIFT_CODE and b.productive_flag is not null and b.productive_flag in ('W') GROUP BY a.shift_code, b.mnemonic_key, b.short_desc ORDER BY shift_code";
		
		//String sql_shiftwise_total="SELECT   a.shift_code, b.mnemonic_key shift_mnemonic, SUM (a.fr_wday_opt) fr_wday_opt, SUM (a.fr_nwday_opt) fr_nwday_opt, SUM (a.fr_hday_opt) fr_hday_opt, b.short_desc FROM rs_workplace_requirement_dtl a, am_shift_lang_vw b WHERE a.facility_id = ? AND a.workplace_code = ? AND a.requirement_id = ? and a.shift_code=b.SHIFT_CODE and b.productive_flag is not null and b.productive_flag in ('W') GROUP BY a.shift_code, b.mnemonic_key, b.short_desc and b.language_id = ? ORDER BY shift_code ";

		pstmt_Shiftwise_Req = conn.prepareStatement( sql_shiftwise_total);
		pstmt_Shiftwise_Req.setString(1,facility_id);
		pstmt_Shiftwise_Req.setString(2,locale);
		pstmt_Shiftwise_Req.setString(3,workplace_code);
		pstmt_Shiftwise_Req.setString(4,requirement_id);
		
		rs_Shiftwise_Req = pstmt_Shiftwise_Req.executeQuery() ;
		while (rs_Shiftwise_Req != null && rs_Shiftwise_Req.next()) {
			record = new String[3];				
			record[0] = rs_Shiftwise_Req.getString("fr_wday_opt") ;
			record[1] = rs_Shiftwise_Req.getString("fr_nwday_opt");
			record[2] = rs_Shiftwise_Req.getString("fr_hday_opt");
			Shiftwise_Req.put(rs_Shiftwise_Req.getString("shift_code"),record);
			if(!Shift_Dtl.containsKey(rs_Shiftwise_Req.getString("shift_code"))){
				String shift[] = new String[3];				
				shift[0] = rs_Shiftwise_Req.getString("shift_code");
				shift[1] = rs_Shiftwise_Req.getString("shift_mnemonic");
				shift[2] = rs_Shiftwise_Req.getString("short_desc");
				Shift_Data.add(shift) ;
				Shift_Dtl.put(shift[0],shift[1]);
			}
		}
		if(pstmt_Shiftwise_Req !=null)
			pstmt_Shiftwise_Req.close();
		if(rs_Shiftwise_Req !=null)
			rs_Shiftwise_Req.close();

		//to get the Positionwise Shiftwise Day Totals Requirements
		String sql_positionwise_total="select a.position_code, b.position_desc,a.shift_code, c.mnemonic_key, c.short_desc shift_desc, sum(a.fr_wday_opt) fr_wday_opt, sum(a.fr_nwday_opt) fr_nwday_opt, sum(a.fr_hday_opt) fr_hday_opt from rs_workplace_requirement_dtl a, am_position_lang_vw b, am_shift_lang_vw c where a.facility_id = ? and a.workplace_code = ? and a.requirement_id = ? and (? is null or a.position_code = ?) and b.language_id = ? and c.language_id = b.language_id  and a.position_code=b.position_code and a.shift_code=c.shift_code and c.productive_flag is not null and c.productive_flag in ('W') group by a.position_code,a.shift_code, b.position_desc, c.mnemonic_key, c.short_desc order by position_desc, shift_code";
		
		//String sql_positionwise_total="select a.position_code, b.position_desc,a.shift_code, c.mnemonic_key, c.short_desc shift_desc, sum(a.fr_wday_opt) fr_wday_opt, sum(a.fr_nwday_opt) fr_nwday_opt, sum(a.fr_hday_opt) fr_hday_opt from rs_workplace_requirement_dtl a, am_position_lang_vw b, am_shift_lang_vw c where a.facility_id = ? and a.workplace_code = ? and a.requirement_id = ? and (? is null or a.position_code = ?) and  a.position_code=b.position_code and a.shift_code=c.shift_code and c.productive_flag is not null and c.productive_flag in ('W') group by a.position_code,a.shift_code, b.position_desc, c.mnemonic_key, c.short_desc and b.language_id = ? and c.language_id = b.language_id order by position_desc, shift_code";

		pstmt_Positionwise_Req = conn.prepareStatement( sql_positionwise_total);
		pstmt_Positionwise_Req.setString(1,facility_id);
		pstmt_Positionwise_Req.setString(2,workplace_code);
		pstmt_Positionwise_Req.setString(3,requirement_id);
		pstmt_Positionwise_Req.setString(4,position_code);
		pstmt_Positionwise_Req.setString(5,position_code);
		pstmt_Positionwise_Req.setString(6,locale);
		rs_Positionwise_Req = pstmt_Positionwise_Req.executeQuery() ;
		while (rs_Positionwise_Req != null && rs_Positionwise_Req.next()) {
			record = new String[8];				
			record[0] = rs_Positionwise_Req.getString("position_code");
			record[1] = rs_Positionwise_Req.getString("position_desc");
			record[2] = rs_Positionwise_Req.getString("shift_code");
			record[3] = rs_Positionwise_Req.getString("mnemonic_key");
			record[4] = rs_Positionwise_Req.getString("shift_desc");
			record[5] = rs_Positionwise_Req.getString("fr_wday_opt");
			record[6] = rs_Positionwise_Req.getString("fr_nwday_opt");
			record[7] = rs_Positionwise_Req.getString("fr_hday_opt");
			Positionwise_Req.add(record) ;
		}
		if(pstmt_Positionwise_Req !=null)
			pstmt_Positionwise_Req.close();
		if(rs_Positionwise_Req !=null)
			rs_Positionwise_Req.close();

		posit_code="";
		PositionShift_Data.clear();
		PositionShift_Dtl.clear();
		for(int i=0;i<Positionwise_Req.size();i++){
			record=(String[])Positionwise_Req.get(i);
			if((!posit_code.equals(record[0]))&&(!PositionShift_Data.isEmpty())){
				PositionShift_Dtl.put(posit_code,PositionShift_Data);
				PositionShift_Data=new ArrayList();
			}
				posit_code=record[0];
				String shift[] = new String[3];				
				shift[0] = record[2];
				shift[1] = record[3];
				shift[2] = record[4];
				PositionShift_Data.add(shift) ;
		}
		PositionShift_Dtl.put(posit_code,PositionShift_Data);
		totalShifts=Shift_Data.size(); 
%>

<body  onMouseDown="CodeArrest1()" onKeyDown="lockKey()" >
		<form name=formByWorkplaceResultWeekly action='../../servlet/eRS.MasterScheduleServlet' method='POST' target='messageFrame'>
		<table border='1' align='left' width="100%" BGCOLOR='WHITE' bordercolor='white' >
<%	
		for(int i=0;i<Shift_Data.size();i++){
			record=(String[])Shift_Data.get(i);
%>
			<input type='hidden' name='shift_code_list<%=i%>' id='shift_code_list<%=i%>' value='<%=record[0]%>'>
			<input type='hidden' name='shift_mnemonic_list<%=i%>' id='shift_mnemonic_list<%=i%>' value='<%=record[1]%>'>
<%	
		}
%>
		<input type='hidden' name='totalShifts' id='totalShifts' value='<%=Shift_Data.size()%>'>

<!-- Requirement Data row -->
		<tr>
			<td colspan='2' width='10%' class='REQUIREMENT'>&nbsp;</td>
			<td width='35%' class='REQUIREMENT' align='left'>&nbsp;<b><fmt:message key="eRS.WorkingShift.label" bundle="${rs_labels}"/></b></td>
<%	
		int optimal=0;
		int alloc_total=0;
		String Day_Indic[]=(String[])Day_Indicator.get(0);
		//to display the total WORKING requirement & total allocated shifts for the given workplace and requirement
		for(day=0;day<Day_Indic.length;day++){
			if(Day_Indic[day].equalsIgnoreCase("W")&&(req_Optimal_Values.size()>0))
				optimal=Integer.parseInt((String)req_Optimal_Values.get(0)==null?"0":(String)req_Optimal_Values.get(0));
			if(Day_Indic[day].equalsIgnoreCase("N")&&(req_Optimal_Values.size()>1))
				optimal=Integer.parseInt((String)req_Optimal_Values.get(1)==null?"0":(String)req_Optimal_Values.get(1));
			if(Allocated_Values.length>0)
				alloc_total=Allocated_Values[day];
			if(alloc_total < optimal)
				classval="BELOWOPTIMAL";
			if(alloc_total > optimal)
				classval="ABOVEOPTIMAL";
			if(alloc_total == optimal)
				classval="OPTIMAL";
			if((optimal == 0)&&(alloc_total == 0))
				classval="REQUIREMENT";
%>
					<td width='8%' class='<%=classval%>' align='center' id='req_alloc_total<%=day%>'><%=alloc_total%>/<%=optimal%></td>
					<input type='hidden' name='req_total<%=day%>' id='req_total<%=day%>' value='<%=optimal%>'>
					<input type='hidden' name='alloc_total<%=day%>' id='alloc_total<%=day%>' value='<%=alloc_total%>'>
<%
		}/*end of requirement display (for)..*/
%>			
			</tr>
			<tr>
				<td colspan='2' width='10%' class='REQUIREMENT'>&nbsp;</td>
				<td width='35%' class='REQUIREMENT' align='left'>&nbsp;<b><fmt:message key="eRS.OncallShift.label" bundle="${rs_labels}"/></b></td>
<%
		optimal=0;
		alloc_total=0;
		Day_Indic=(String[])Day_Indicator.get(0);
		//to display the total ONCALL requirement & total allocated shifts for the given workplace and requirement
		for(day=0;day<Day_Indic.length;day++){

			if(Day_Indic[day].equalsIgnoreCase("W")&&(Oncall_Req.size()>0))
				optimal=Integer.parseInt((String)Oncall_Req.get(0)==null?"0":(String)Oncall_Req.get(0));
			if(Day_Indic[day].equalsIgnoreCase("N")&&(Oncall_Req.size()>1))
				optimal=Integer.parseInt((String)Oncall_Req.get(1)==null?"0":(String)Oncall_Req.get(1));
			if(Oncall_Allocated.length > 0)
				alloc_total=Oncall_Allocated[day];
			if(alloc_total < optimal)
				classval="BELOWOPTIMAL";
			if(alloc_total > optimal)
				classval="ABOVEOPTIMAL";
			if(alloc_total == optimal)
				classval="OPTIMAL";
			if((optimal == 0)&&(alloc_total == 0))
				classval="REQUIREMENT";
%>
			<td width='8%' class='<%=classval%>' align='center' id='oncall_total<%=day%>'><%=alloc_total%>/<%=optimal%></td>
			<input type='hidden' name='oncall_req<%=day%>' id='oncall_req<%=day%>' value='<%=optimal%>'>
			<input type='hidden' name='oncall_alloc<%=day%>' id='oncall_alloc<%=day%>' value='<%=alloc_total%>'>
<%
		}/*end of requirement display (for)..*/
%>			
		</tr>
		<tr>
			<td colspan='2' width='10%' class='REQUIREMENT'>&nbsp;</td>
			<td width='35%' class='REQUIREMENT' align='left'>&nbsp;<b><fmt:message key="eRS.UnproductiveShift.label" bundle="${rs_labels}"/></b></td>
<%
		optimal=0;
		alloc_total=0;
		Day_Indic=(String[])Day_Indicator.get(0);
		//to display the total ONCALL requirement & total allocated shifts for the given workplace and requirement
		for(day=0;day<Day_Indic.length;day++){

			if(Unprod_Allocated.length > 0)
				alloc_total=Unprod_Allocated[day];
%>
			<td width='8%' class='REQUIREMENT' align='center' id='unproductive_total<%=day%>'><%=alloc_total%></td>
			<input type='hidden' name='unproductive_alloc<%=day%>' id='unproductive_alloc<%=day%>' value='<%=alloc_total%>'>
<%
		}/*end of requirement display (for)..*/
%>			
		</tr>

<%
		if(Positionwise_Req.size()<=0){
			if(position_code !=null){
				String position_desc="";
				//String sql_possition_desc="select distinct position_desc from am_position  where position_code=? ";
				String sql_possition_desc="select position_desc from am_position_lang_vw  where position_code=? and language_id = ? ";
				pstmt_Position_Desc 	= conn.prepareStatement( sql_possition_desc);
				pstmt_Position_Desc.setString(1,position_code);
				pstmt_Position_Desc.setString(2,locale);
				rs_Position_Desc		 					= pstmt_Position_Desc.executeQuery();
				while (rs_Position_Desc != null && rs_Position_Desc.next()){
					position_desc=rs_Position_Desc.getString("position_desc");
				}
%>
				<tr><td colspan='10'><b><%=position_desc%></b></td>
<%
			}
                 if(pstmt_Position_Desc != null)
							pstmt_Position_Desc.close();
						if(rs_Position_Desc != null)
							rs_Position_Desc.close();

		}else{
/***********-------------------Position Wise Data rows --------------------------*****************/
			position_record=(String[])Positionwise_Req.get(0);
			posit_code="";
			for(int position=0;position<Positionwise_Req.size();position++){
				if(position_record != null){
					shift_code=position_record[2];
					if(!posit_code.equals(position_record[0])){
						Unproductive_Shift	 =	 new ArrayList();
						Oncall_Shift			=	new ArrayList();
						//sql_unproductive_shift="SELECT  distinct a.shift_code, a.mnemonic_key, a.productive_flag, a.short_desc FROM am_shift a, rs_workplace_requirement_dtl b WHERE a.shift_code IN (SELECT shift_code FROM am_shift_for_position WHERE position_code = ? AND shift_code IN (SELECT shift_code FROM rs_shift_for_workplace WHERE facility_id = ? AND workplace_code = ?) AND (a.shift_indicator = 'U' OR (a.productive_flag = 'O' and b.requirement_id=? and a.shift_code=b.shift_code)) AND eff_status = 'E')ORDER BY shift_code";
						sql_unproductive_shift="SELECT  distinct a.shift_code, a.mnemonic_key, a.productive_flag, a.short_desc FROM am_shift_lang_vw a, rs_workplace_requirement_dtl b WHERE a.shift_code IN (SELECT shift_code FROM am_shift_for_position WHERE position_code = ? AND shift_code IN (SELECT shift_code FROM rs_shift_for_workplace WHERE facility_id = ? AND workplace_code = ?) AND (a.shift_indicator = 'U' OR (a.productive_flag = 'O' and b.requirement_id=? and a.shift_code=b.shift_code)) AND eff_status = 'E') and a.language_id = ? ORDER BY shift_code";
						pstmt_Unproductive 	= conn.prepareStatement( sql_unproductive_shift);
						pstmt_Unproductive.setString(1,position_record[0]);
						pstmt_Unproductive.setString(2,facility_id);
						pstmt_Unproductive.setString(3,workplace_code);
						pstmt_Unproductive.setString(4,requirement_id);
						pstmt_Unproductive.setString(5,locale);
						rs_Unproductive		 					= pstmt_Unproductive.executeQuery();
						while (rs_Unproductive != null && rs_Unproductive.next()){
							record	= new String[3];
							String p_flag=rs_Unproductive.getString("productive_flag");
							if((p_flag != null)&&p_flag.equals("O")){
								record[0]=rs_Unproductive.getString("shift_code");
								record[1]=rs_Unproductive.getString("mnemonic_key");
								record[2]=rs_Unproductive.getString("short_desc");
								Oncall_Shift.add(record);
							}else{
								record[0]=rs_Unproductive.getString("shift_code");
								record[1]=rs_Unproductive.getString("mnemonic_key");
								record[2]=rs_Unproductive.getString("short_desc");
								Unproductive_Shift.add(record);
							}
						}
						if(pstmt_Unproductive != null)
							pstmt_Unproductive.close();
						if(rs_Unproductive != null)
							rs_Unproductive.close();

						shift_count=0;
						posit_code=position_record[0];
						PositionShift_Data=new ArrayList();
						PositionShift_Data =(ArrayList) PositionShift_Dtl.get(posit_code);
						p_shift_code="";
						p_shift_mnemonic="";
						u_shift_code="";
						u_shift_mnemonic="";
						o_shift_code="";
						o_shift_mnemonic="";
						for(int i=0;i<PositionShift_Data.size();i++){
							record=(String[])PositionShift_Data.get(i);
							if(p_shift_code.equals("")){
								p_shift_code=record[0];
								p_shift_mnemonic=record[1];
							}else{
								p_shift_code=p_shift_code+"|"+record[0];
								p_shift_mnemonic=p_shift_mnemonic+"|"+record[1];
							}
						}
						for(int i=0; i<Unproductive_Shift.size();i++){
							record=(String[])Unproductive_Shift.get(i);
							if(u_shift_code.equals("")){
								u_shift_code=record[0];
								u_shift_mnemonic=record[1];
							}else{
								u_shift_code=u_shift_code+"|"+record[0];
								u_shift_mnemonic=u_shift_mnemonic+"|"+record[1];
							}
						}

						for(int i=0; i<Oncall_Shift.size();i++){
							record=(String[])Oncall_Shift.get(i);
							if(o_shift_code.equals("")){
								o_shift_code=record[0];
								o_shift_mnemonic=record[1];
							}else{
								o_shift_code=o_shift_code+"|"+record[0];
								o_shift_mnemonic=o_shift_mnemonic+"|"+record[1];
							}
						}
						int tot_shift = PositionShift_Data.size()+Oncall_Shift.size()+Oncall_Shift.size();
						String exp_legend="-";
						if(PositionShift_Data.size()>0)
							exp_legend="+";
						else
							exp_legend="-";
	%>					
						<tr  id='posit<%=position_record[0]%>'><td  onclick='javascript:expanddetails(this,"<%=position_record[0]%>")' align="center" width='5%'  class='STAFF'><a id=view<%=position_record[0]%>  href='' ><b><%=exp_legend%></b></a></td><td colspan='9' class='STAFF'><b><%=position_record[1]%></b></td>
						<div id="master_menu<%=position_record[0]%>" onmouseover="over()" onMouseout="out()" onmousedown='Un_Oncall_assign();' style='display:none;'>
<%
						if(PositionShift_Data.size()>0){
%>
							<div id='Working<%=position_record[0]%>' class="master_menuitem_hdr" value='P' ><fmt:message key="eRS.WorkingShifts.label" bundle="${rs_labels}"/></div>
<%
							for(int i=0; i<PositionShift_Data.size();i++){
								record=(String[])PositionShift_Data.get(i);
%>
								<div id='working<%=position_record[0]%>' class="master_menuitem" value='<%=record[0]%>|P|W' text='<%=record[1]%>' ><%=record[1]%>&nbsp;-&nbsp;<%=record[2]%></div>
<%
							}
						}
						if(Oncall_Shift.size()>0){
%>
							<div id='Oncall<%=position_record[0]%>' class="master_menuitem_hdr" value='O' >
							<fmt:message key="eRS.OncallShifts.label"  bundle="${rs_labels}"/></div>
<%
							for(int i=0; i<Oncall_Shift.size();i++){
								record=(String[])Oncall_Shift.get(i);
%>
								<div id='oncall<%=position_record[0]%>' class="master_menuitem" value='<%=record[0]%>|P|O' text='<%=record[1]%>' ><%=record[1]%>&nbsp;-&nbsp;<%=record[2]%></div>
<%						}
						}
						if(Unproductive_Shift.size()>0){
%>
							<div id='Unproductive<%=position_record[0]%>' class="master_menuitem_hdr" value='U' >
							<fmt:message key="eRS.UnproductiveShifts.label" bundle="${rs_labels}"/>
							</div>
<%		
							for(int i=0; i<Unproductive_Shift.size();i++){
								record=(String[])Unproductive_Shift.get(i);
%>
								<div id='unprd<%=position_record[0]%>' class="master_menuitem" value='<%=record[0]%>|U' text='<%=record[1]%>'> <%=record[1]%>&nbsp;-&nbsp;<%=record[2]%></div>
<%
							}
						}
%>
						</div>
						<input type='hidden' name='<%=posit_code%>p_shift_code_list' id='<%=posit_code%>p_shift_code_list' value='<%=p_shift_code%>'>
						<input type='hidden' name='<%=posit_code%>p_shift_mnemonic_list' id='<%=posit_code%>p_shift_mnemonic_list' value='<%=p_shift_mnemonic%>'>
						<input type='hidden' name='<%=posit_code%>u_shift_code_list' id='<%=posit_code%>u_shift_code_list' value='<%=u_shift_code%>'>
						<input type='hidden' name='<%=posit_code%>u_shift_mnemonic_list' id='<%=posit_code%>u_shift_mnemonic_list' value='<%=u_shift_mnemonic%>'>
						<input type='hidden' name='<%=posit_code%>o_shift_code_list' id='<%=posit_code%>o_shift_code_list' value='<%=o_shift_code%>'>
						<input type='hidden' name='<%=posit_code%>o_shift_mnemonic_list' id='<%=posit_code%>o_shift_mnemonic_list' value='<%=o_shift_mnemonic%>'>
						<input type='hidden' name='total_shifts<%=posit_code%>' id='total_shifts<%=posit_code%>' value=<%=tot_shift%>>
						</tr>
<% 
		}
					Posit_Allocated_Values=new int[7];
					Positionwise_Alloc.clear();
					String sql_positionwise_alloc="select a.shift_code,a.week_no,a.day_no, count(shift_mnemonic) allocated from rs_master_schedule a where a.facility_id = ? and a.workplace_code = ? and a.requirement_id = ? and a.position_code = ? and a.week_no = ? and a.shift_code=? group by a.shift_code, a.week_no, a.day_no order by a.shift_code";

					//to get the Positionwise Shiftwise Day Totals Requirements 
					pstmt_Positionwise_Alloc = conn.prepareStatement( sql_positionwise_alloc);
					pstmt_Positionwise_Alloc.setString(1,facility_id);
					pstmt_Positionwise_Alloc.setString(2,workplace_code);
					pstmt_Positionwise_Alloc.setString(3,requirement_id);
					pstmt_Positionwise_Alloc.setString(4,posit_code);
					pstmt_Positionwise_Alloc.setString(5,String.valueOf(week_no));
					pstmt_Positionwise_Alloc.setString(6,shift_code);
					rs_Positionwise_Alloc = pstmt_Positionwise_Alloc.executeQuery() ;
					while (rs_Positionwise_Alloc != null && rs_Positionwise_Alloc.next()){
						day_no=Integer.parseInt(rs_Positionwise_Alloc.getString("day_no")==null?"0":rs_Positionwise_Alloc.getString("day_no"));
						Posit_Allocated_Values[day_no-1]=Integer.parseInt(rs_Positionwise_Alloc.getString("allocated")==null?"0":rs_Positionwise_Alloc.getString("allocated"));
						Positionwise_Alloc.put(rs_Positionwise_Alloc.getString("shift_code"),Posit_Allocated_Values);
					}
					
					if(pstmt_Positionwise_Alloc != null)
							pstmt_Positionwise_Alloc.close();
						if(rs_Positionwise_Alloc != null)
							rs_Positionwise_Alloc.close();

%>		
					<tr id='posit<%=position_record[0]%>' style='display:none;'>
					<td colspan='2' class='ALOCATED'>&nbsp;</td>
					<td class='ALOCATED' width='35%' align='left'>&nbsp;<%=position_record[4]%>&nbsp;-&nbsp;<%=position_record[3]%></td>
					<input type='hidden' name='<%=position_record[0]%>shifts' id='<%=position_record[0]%>shifts' value='<%=++shift_count%>'>	
<%	
					Posit_Allocated_Values=new int[7];
					Posit_Allocated_Values=(int[])Positionwise_Alloc.get(shift_code);		
					Day_Indic=(String[])Day_Indicator.get(0);
					for(day=0;day<Day_Indic.length;day++){

						if(Posit_Allocated_Values != null)
							alloc_val=Posit_Allocated_Values[day];
						else 
							alloc_val=0;
						if(Day_Indic[day].equalsIgnoreCase("W"))
							req_val=Integer.parseInt(position_record[5]==null?"0":position_record[5]);
						if(Day_Indic[day].equalsIgnoreCase("N"))
							req_val=Integer.parseInt(position_record[6]==null?"0":position_record[6]);
						if(Day_Indic[day].equalsIgnoreCase("H"))
							req_val=Integer.parseInt(position_record[7]==null?"0":position_record[7]); 

						if(alloc_val < req_val)
							classval="BELOWOPTIMAL";
						if(alloc_val > req_val)
							classval="ABOVEOPTIMAL";
						if(alloc_val == req_val)
							classval="OPTIMAL";
						if((req_val==0)&&(alloc_val == 0))
							classval="ALOCATED";
%>

						<td width='8%' class='<%=classval%>' align='center' id='req_alloc_position<%=posit_code%><%=shift_code%><%=day%>'><%=alloc_val%>/<%=req_val%></td>
						<input type='hidden' name='req_position<%=posit_code%><%=shift_code%><%=day%>' id='req_position<%=posit_code%><%=shift_code%><%=day%>' value='<%=req_val%>'>
						<input type='hidden' name='alloc_position<%=posit_code%><%=shift_code%><%=day%>' id='alloc_position<%=posit_code%><%=shift_code%><%=day%>' value='<%=alloc_val%>'>
<%
					}
%>
					</tr>
<%
					//check for next position
					if((position+1)<Positionwise_Req.size())
						position_record=(String[])Positionwise_Req.get(position+1);
					//if next position found
					if(!posit_code.equals(position_record[0])){

						//to get the Staff List 

						Staff_Data.clear();
						pstmt_Staff_List = conn.prepareStatement( sql_staff_list);
						pstmt_Staff_List.setString(1,facility_id);
						pstmt_Staff_List.setString(2,workplace_code);
						pstmt_Staff_List.setString(3,role_type);
						pstmt_Staff_List.setString(4,role_type);
						pstmt_Staff_List.setString(5,staff_type);
						pstmt_Staff_List.setString(6,staff_type);
						pstmt_Staff_List.setString(7,staff_id);
						pstmt_Staff_List.setString(8,staff_id);
						pstmt_Staff_List.setString(9,facility_id);
						pstmt_Staff_List.setString(10,workplace_code);
						pstmt_Staff_List.setString(11,requirement_id);
						pstmt_Staff_List.setString(12,posit_code);
						pstmt_Staff_List.setString(13,facility_id);
						pstmt_Staff_List.setString(14,workplace_code);
						pstmt_Staff_List.setString(15,requirement_id);
						pstmt_Staff_List.setString(16,posit_code);
						pstmt_Staff_List.setInt(17,week_no);
						pstmt_Staff_List.setString(18,locale);
						rs_Staff_List = pstmt_Staff_List.executeQuery() ;
						while (rs_Staff_List != null && rs_Staff_List.next()) {
							record = new String[9];				
							record[0] = rs_Staff_List.getString("role_type") ;
							record[1] = rs_Staff_List.getString("staff_type") ;
							record[2] = rs_Staff_List.getString("staff_id") ;
							record[3] = rs_Staff_List.getString("shift_code") ;
							record[4] = rs_Staff_List.getString("productive_flag") ;
							record[5] = rs_Staff_List.getString("shift_indicator") ;
							record[6] = rs_Staff_List.getString("shift_mnemonic") ;
							record[7] = rs_Staff_List.getString("day_no") ;
							record[8] = rs_Staff_List.getString("staff_name") ;
							Staff_Data.add(record);
						}
						if(pstmt_Staff_List != null)
							pstmt_Staff_List.close();
						if(rs_Staff_List != null)
							rs_Staff_List.close();

						day=0;
						day_count=0;
						prev_staff="";
						prev_role="";
						//if staff list found
						if(Staff_Data.size()>0){

							staff_data=(String[])Staff_Data.get(0);
							role_typ=staff_data[0];
							staff_typ=staff_data[1];
							staff_id1=staff_data[2];
							shift_cod=staff_data[3]==null?"":staff_data[3];
							prod_flag=staff_data[4]==null?"":staff_data[4];
							shift_indicator=staff_data[5]==null?"":staff_data[5];
							shift_mnemonic=staff_data[6]==null?"":staff_data[6];
							day_no=Integer.parseInt(staff_data[7]==null?"0":staff_data[7]);
							staff_name=staff_data[8]==null?"":staff_data[8];
							//for- to display multiple staff for position
							for(int staff=0;staff<Staff_Data.size();staff++){

								if(prod_flag.equals("O"))
									classval="TXTONCALL";
								else
									if(shift_indicator.equals("U"))
									classval="TXTUNPRODUCTIVE";
								else
									classval="TXTSTAFF";

								role_typ=staff_data[0];
								//check for next staff
								if(!(prev_staff.equalsIgnoreCase(staff_id1))||!(prev_role.equalsIgnoreCase(role_typ))){
									prev_staff=staff_id1;
									prev_role=role_typ;
%>
									</tr>
									<tr  id='posit<%=posit_code%>' style='display:none;'>
										<td align='center' width='5%'  class='STAFF' onclick='javascript:clearstaff("<%=role_typ%>","<%=staff_id1%>","<%=posit_code%>")'> 
												<a id='clear<%=staff_id1%>'  href='#'>C</a></td>
										<td align='center' width='5%'  class='STAFF' onclick='javascript:getShiftPattern("<%=role_typ%>","<%=staff_id1%>","<%=posit_code%>",<%=total_records%>)'> 
											<a id='clear<%=staff_id1%>'  href='#' class='STAFF'>SP
											<input type='hidden' name='role_type<%=total_records%>' id='role_type<%=total_records%>' value='<%=role_typ%>'>
											<input type='hidden' name='staff_type<%=total_records%>' id='staff_type<%=total_records%>' value='<%=staff_typ%>'>
											<input type='hidden' name='position_code<%=total_records%>' id='position_code<%=total_records%>' value='<%=posit_code%>'>
											<input type='hidden' name='shift_pattern_id<%=total_records%>' id='shift_pattern_id<%=total_records%>' value=''>
											<input type='hidden' name='shift_pattern_desc<%=total_records%>' id='shift_pattern_desc<%=total_records%>' value=''>
											<input type='hidden' name='staff<%= total_records%>' id='staff<%= total_records%>' value='<%=staff_id1%>'>
										</td>
										<td align='left' width='35%'  class='STAFF'>&nbsp;<%=staff_name%></td>
<%	
									total_records++;
									day=0; day_count=0;
								} /*end if check for next staff*/
								//check to display allocated day-shift
								if(day_no==(day+1)){
									day_count++;
%>
									<td width='8%' align='center' class='STAFF' onclick='showPopup("<%=posit_code%>","<%=prev_role%>","<%=prev_staff%>","<%=day%>");'><input type='text' size='2' maxlength='1' class='<%=classval%>' align='center' onclick='txtclick();' name='shift<%=prev_role%><%=prev_staff%><%=day%>' class='<%=classval%>' class='<%=classval%>' value='<%=shift_mnemonic%>' onkeypress='return checkshift(<%=day%>,"<%=prev_role%>", "<%=prev_staff%>","<%=posit_code%>");' onfocus='unSelect(this);' onchange='checkshiftlost(this,"<%=prev_role%>","<%=prev_staff%>","<%=day%>","<%=posit_code%>"); onallocation( <%=day%>,"<%=posit_code%>","<%=prev_role%>","<%=prev_staff%>");' onblur='check(this,"<%=posit_code%>","<%=prev_role%>","<%=prev_staff%>","<%=day%>");'> </td>
									<input type='hidden' name='shift_code<%=prev_role%><%=prev_staff%><%=day%>' id='shift_code<%=prev_role%><%=prev_staff%><%=day%>' value='<%=shift_cod%>'>
									<input type='hidden' name='db_action<%=prev_role%><%=prev_staff%><%=day%>' id='db_action<%=prev_role%><%=prev_staff%><%=day%>' value='U'>
									<input type='hidden' name='shift_indicator<%=prev_role%><%=prev_staff%><%=day%>' id='shift_indicator<%=prev_role%><%=prev_staff%><%=day%>' value='<%=shift_indicator%>'>
									<input type='hidden' name='productive_flag<%=prev_role%><%=prev_staff%><%=day%>' id='productive_flag<%=prev_role%><%=prev_staff%><%=day%>' value='<%=prod_flag%>'>
<%
								}else{
									//check allocated day
									if(day_no !=0){
										//to display empty text for nonallocated days
										for(day=day_count;day<(day_no-1);day++){
%>
											<td width='8%' align='center' class='STAFF' onclick='showPopup("<%=posit_code%>","<%=prev_role%>","<%=prev_staff%>","<%=day%>");'>
											<input type='text' size='2' maxlength='1' align='center' class='<%=classval%>' onclick='txtclick();' name='shift<%=role_typ%><%=staff_id1%><%=day%>' value='' onkeypress='return checkshift(<%=day%>,"<%=role_typ%>","<%=staff_id1%>","<%=posit_code%>");' onchange='checkshiftlost(this,"<%=role_typ%>","<%=staff_id1%>","<%=day%>","<%=posit_code%>"); onallocation( <%=day%>, "<%=posit_code%>", "<%=role_typ%>", "<%=staff_id1%>");'onblur='check(this,"<%=posit_code%>","<%=role_typ%>","<%=staff_id1%>","<%=day%>")'  onfocus='unSelect(this);'></td>
											<input type='hidden' name='shift_code<%=role_typ%><%=staff_id1%><%=day%>' id='shift_code<%=role_typ%><%=staff_id1%><%=day%>' value=''>
											<input type='hidden' name='db_action<%=role_typ%><%=staff_id1%><%=day%>' id='db_action<%=role_typ%><%=staff_id1%><%=day%>' value='I'>
											<input type='hidden' name='shift_indicator<%=role_typ%><%=staff_id1%><%=day%>' id='shift_indicator<%=role_typ%><%=staff_id1%><%=day%>' value=''>
											<input type='hidden' name='productive_flag<%=role_typ%><%=staff_id1%><%=day%>' id='productive_flag<%=role_typ%><%=staff_id1%><%=day%>' value=''>
<%
										}//end for nonallocated cells
										day_count=day+1;
%>
										<td width='8%' align='center' class='STAFF' onclick='showPopup("<%=posit_code%>","<%=prev_role%>","<%=prev_staff%>","<%=day%>");'>
										<input type='text' size='2' maxlength='1' align='center'  class='<%=classval%>' onclick='txtclick();' name='shift<%=role_typ%><%=staff_id1%><%=day%>' value='<%=shift_mnemonic%>' onkeypress='return checkshift(<%=day%>,"<%=role_typ%>","<%=staff_id1%>","<%=posit_code%>");' onchange='checkshiftlost(this,"<%=role_typ%>","<%=staff_id1%>","<%=day%>","<%=posit_code%>"); onallocation( <%=day%>,"<%=posit_code%>","<%=role_typ%>","<%=staff_id1%>");' onblur='check(this,"<%=posit_code%>","<%=role_typ%>","<%=staff_id1%>","<%=day%>")' onfocus='unSelect(this);'></td>
										<input type='hidden' name='shift_code<%=role_typ%><%=staff_id1%><%=day%>' id='shift_code<%=role_typ%><%=staff_id1%><%=day%>' value='<%=shift_cod%>'>
										<input type='hidden' name='db_action<%=role_typ%><%=staff_id1%><%=day%>' id='db_action<%=role_typ%><%=staff_id1%><%=day%>' value='U'>
										<input type='hidden' name='shift_indicator<%=role_typ%><%=staff_id1%><%=day%>' id='shift_indicator<%=role_typ%><%=staff_id1%><%=day%>' value='<%=shift_indicator%>'>
										<input type='hidden' name='productive_flag<%=role_typ%><%=staff_id1%><%=day%>' id='productive_flag<%=role_typ%><%=staff_id1%><%=day%>' value='<%=prod_flag%>'>

<%
									}//end if allocated day
								}//end else 
								//check for next staff 
								if((staff+1 )<Staff_Data.size())
									staff_data=(String[])Staff_Data.get(staff+1);
								role_typ=staff_data[0];
								staff_typ=staff_data[1];
								staff_id1=staff_data[2];
								shift_cod=staff_data[3]==null?"":staff_data[3];
								prod_flag=staff_data[4]==null?"":staff_data[4];
								shift_indicator=staff_data[5]==null?"":staff_data[5];
								shift_mnemonic=staff_data[6]==null?"":staff_data[6];
								day_no=Integer.parseInt(staff_data[7]==null?"0":staff_data[7]);
								staff_name=staff_data[8]==null?"":staff_data[8];

								//check for next staff
								if((!prev_staff.equals(staff_id1))||(!prev_role.equals(role_typ))){
									//check for nonallocated days with week days for prev staff
									if(day_count<7){
										//for - to display empty text for non allocateed days
										for(day=day_count;day<7;day++){
%>
											<td width='8%' align='center' class='STAFF' onclick='showPopup("<%=posit_code%>","<%=prev_role%>","<%=prev_staff%>","<%=day%>");'>
											<input type='text' size='2' maxlength='1' align='center' class='TXTSTAFF' onclick='txtclick();' name='shift<%=prev_role%><%=prev_staff%><%=day%>' id='shift<%=prev_role%><%=prev_staff%><%=day%>' value='' onkeypress='return checkshift(<%=day%>,"<%=prev_role%>","<%=prev_staff%>","<%=posit_code%>");' onchange='checkshiftlost(this,"<%=prev_role%>","<%=prev_staff%>",<%=day%>,"<%=posit_code%>");onallocation( <%=day%>,"<%=posit_code%>","<%=prev_role%>", "<%=prev_staff%>");'onblur='check(this,"<%=posit_code%>","<%=prev_role%>","<%=prev_staff%>","<%=day%>")'  onfocus='unSelect(this);'></td>
											<input type='hidden' name='shift_code<%=prev_role%><%=prev_staff%><%=day%>' id='shift_code<%=prev_role%><%=prev_staff%><%=day%>' value=''>
											<input type='hidden' name='db_action<%=prev_role%><%=prev_staff%><%=day%>' id='db_action<%=prev_role%><%=prev_staff%><%=day%>' value='I'>
											<input type='hidden' name='shift_indicator<%=prev_role%><%=prev_staff%><%=day%>' id='shift_indicator<%=prev_role%><%=prev_staff%><%=day%>' value=''>
											<input type='hidden' name='productive_flag<%=prev_role%><%=prev_staff%><%=day%>' id='productive_flag<%=prev_role%><%=prev_staff%><%=day%>' value=''>
<%
										}
										day_count=0;
%>
										</tr>
<%
									}//end of weekdays
								}
							}
%>
					
	<!-- ****************************************** -->
<%			
							if(day_count<7){
								for(day=day_count;day<7;day++){
%>
									<td width='8%' align='center' class='STAFF' onclick='showPopup("<%=posit_code%>","<%=prev_role%>","<%=prev_staff%>","<%=day%>");'>
									<input type='text' size='2' maxlength='1' align='center' class='TXTSTAFF' onclick='txtclick();' name='shift<%=prev_role%><%=prev_staff%><%=day%>' id='shift<%=prev_role%><%=prev_staff%><%=day%>' value='' onkeypress='return checkshift(<%=day%>,"<%=prev_role%>","<%=prev_staff%>","<%=posit_code%>");' onchange='checkshiftlost(this,"<%=prev_role%>","<%=prev_staff%>","<%=day%>","<%=posit_code%>"); onallocation( <%=day%>,"<%=posit_code%>","<%=prev_role%>", "<%=prev_staff%>");'onblur='check(this,"<%=posit_code%>","<%=prev_role%>","<%=prev_staff%>", "<%=day%>")' onfocus='unSelect(this);'></td>
									<input type='hidden' name='shift_code<%=prev_role%><%=prev_staff%><%=day%>' id='shift_code<%=prev_role%><%=prev_staff%><%=day%>' value=''>
									<input type='hidden' name='db_action<%=prev_role%><%=prev_staff%><%=day%>' id='db_action<%=prev_role%><%=prev_staff%><%=day%>' value='I'>
									<input type='hidden' name='shift_indicator<%=prev_role%><%=prev_staff%><%=day%>' id='shift_indicator<%=prev_role%><%=prev_staff%><%=day%>' value=''>
									<input type='hidden' name='productive_flag<%=prev_role%><%=prev_staff%><%=day%>' id='productive_flag<%=prev_role%><%=prev_staff%><%=day%>' value=''>
<%
								}
								day_count=0;	
%>
								</tr>
<%
							}
						}/*end if staff list found*/
					}/*end if next position found*/
				}/*end if position data not null*/
			}/*end for (multiple position)*/

			//to get the Staff List 

			Staff_Data.clear();
			pstmt_Staff_List = conn.prepareStatement( sql_staff_list);
			pstmt_Staff_List.setString(1,facility_id);
			pstmt_Staff_List.setString(2,workplace_code);
			pstmt_Staff_List.setString(3,role_type);
			pstmt_Staff_List.setString(4,role_type);
			pstmt_Staff_List.setString(5,staff_type);
			pstmt_Staff_List.setString(6,staff_type);
			pstmt_Staff_List.setString(7,staff_id);
			pstmt_Staff_List.setString(8,staff_id);
			pstmt_Staff_List.setString(9,facility_id);
			pstmt_Staff_List.setString(10,workplace_code);
			pstmt_Staff_List.setString(11,requirement_id);
			pstmt_Staff_List.setString(12,posit_code);
			pstmt_Staff_List.setString(13,facility_id);
			pstmt_Staff_List.setString(14,workplace_code);
			pstmt_Staff_List.setString(15,requirement_id);
			pstmt_Staff_List.setString(16,posit_code);
			pstmt_Staff_List.setInt(17,week_no);
			pstmt_Staff_List.setString(18,locale);
			rs_Staff_List = pstmt_Staff_List.executeQuery() ;
//System.err.println("sql_staff_list="+sql_staff_list);
//System.err.println("facility_id="+facility_id+" workplace_code="+workplace_code+" role_type="+role_type+" staff_type="+staff_type+" staff_id="+staff_id+" requirement_id="+requirement_id+" posit_code"+posit_code+" week_no="+week_no);
			while (rs_Staff_List != null && rs_Staff_List.next()) {
				record = new String[9];				
				record[0] = rs_Staff_List.getString("role_type") ;
				record[1] = rs_Staff_List.getString("staff_type") ;
				record[2] = rs_Staff_List.getString("staff_id") ;
				record[3] = rs_Staff_List.getString("shift_code") ;
				record[4] = rs_Staff_List.getString("productive_flag") ;
				record[5] = rs_Staff_List.getString("shift_indicator") ;
				record[6] = rs_Staff_List.getString("shift_mnemonic") ;
				record[7] = rs_Staff_List.getString("day_no") ;
				record[8] = rs_Staff_List.getString("staff_name") ;
				Staff_Data.add(record);
			}
			if(pstmt_Staff_List != null)
				pstmt_Staff_List.close();
			if(rs_Staff_List != null)
				rs_Staff_List.close();

			prev_staff="";
			prev_role="";
			if(Staff_Data.size()>0){
				staff_data=(String[])Staff_Data.get(0);
				role_typ=staff_data[0];
				staff_typ=staff_data[1];
				staff_id1=staff_data[2];
				shift_cod=staff_data[3]==null?"":staff_data[3];
				prod_flag=staff_data[4]==null?"":staff_data[4];
				shift_indicator=staff_data[5]==null?"":staff_data[5];
				shift_mnemonic=staff_data[6]==null?"":staff_data[6];
				day_no=Integer.parseInt(staff_data[7]==null?"0":staff_data[7]);
				staff_name=staff_data[8]==null?"":staff_data[8];

				for(int staff=0;staff<Staff_Data.size();staff++){
					if(prod_flag.equals("O"))
						classval="TXTONCALL";
					else
						if(shift_indicator.equals("U"))
						classval="TXTUNPRODUCTIVE";
					else
						classval="TXTSTAFF";

					if((!prev_staff.equalsIgnoreCase(staff_id1))||(!prev_role.equals(role_typ))){
						prev_staff=staff_id1;
						prev_role=role_typ;
%>
						</tr>
						<tr  id='posit<%=posit_code%>' style='display:none;'>
							<td align='center' width='5%' class='STAFF' onclick='javascript:clearstaff("<%=role_typ%>","<%=staff_id1%>","<%=posit_code%>")'> 
									<a id='clear<%=staff_id1%>'  href='#'>C</a></td>
							<td align='center' width='5%' class='STAFF' onclick='javascript:getShiftPattern("<%=role_typ%>","<%=staff_id1%>","<%=posit_code%>",<%=total_records%>)'> 
								<a id='clear<%=staff_id1%>'  href='#' class='STAFF'>SP
								<input type='hidden' name='role_type<%=total_records%>' id='role_type<%=total_records%>' value='<%=role_typ%>'>
								<input type='hidden' name='staff_type<%=total_records%>' id='staff_type<%=total_records%>' value='<%=staff_typ%>'>
								<input type='hidden' name='position_code<%=total_records%>' id='position_code<%=total_records%>' value='<%=posit_code%>'>
								<input type='hidden' name='shift_pattern_id<%=total_records%>' id='shift_pattern_id<%=total_records%>' value=''>
								<input type='hidden' name='shift_pattern_desc<%=total_records%>' id='shift_pattern_desc<%=total_records%>' value=''>
								<input type='hidden' name='staff<%= total_records%>' id='staff<%= total_records%>' value='<%=staff_id1%>'>
							</td>
							<td align='left' width='35%' class='STAFF'>&nbsp;<%=staff_name%></td>
<%
						total_records++;
						day=0; day_count=0;
					}
					 /*if its same staff with shifts*/
//System.err.println("staff_id1="+staff_id1+ "day_no="+day_no+" day="+day+ "   day_count="+day_count);
					if(day_no==(day+1)){
						day_count++;
%>
						<td width='8%' align='center' class='STAFF' onclick='showPopup("<%=posit_code%>","<%=prev_role%>","<%=prev_staff%>","<%=day%>");'><input type='text' size='2' maxlength='1' align='center' onclick='txtclick();' name='shift<%=role_typ%><%=staff_id1%><%=day%>' id='shift<%=role_typ%><%=staff_id1%><%=day%>' class='<%=classval%>' value='<%=shift_mnemonic%>' onkeypress='return checkshift(<%=day%>,"<%=role_typ%>", "<%=staff_id1%>","<%=posit_code%>");'onchange='checkshiftlost(this,"<%=role_typ%>","<%=staff_id1%>","<%=day%>","<%=posit_code%>"); onallocation( <%=day%>,"<%=posit_code%>","<%=role_typ%>","<%=staff_id1%>");' onblur='check(this,"<%=posit_code%>","<%=role_typ%>","<%=staff_id1%>","<%=day%>")' onfocus='unSelect(this);'></td>
						<input type='hidden' name='shift_code<%=role_typ%><%=staff_id1%><%=day%>' id='shift_code<%=role_typ%><%=staff_id1%><%=day%>' value='<%=shift_cod%>'>
						<input type='hidden' name='db_action<%=role_typ%><%=staff_id1%><%=day%>' id='db_action<%=role_typ%><%=staff_id1%><%=day%>' value='U'>
						<input type='hidden' name='shift_indicator<%=role_typ%><%=staff_id1%><%=day%>' id='shift_indicator<%=role_typ%><%=staff_id1%><%=day%>' value='<%=shift_indicator%>'>
						<input type='hidden' name='productive_flag<%=role_typ%><%=staff_id1%><%=day%>' id='productive_flag<%=role_typ%><%=staff_id1%><%=day%>' value='<%=prod_flag%>'>
<%
					}else{ 
						if(day_no !=0){
							for(day=day_count;day<(day_no-1);day++){
%>
								<td width='8%' align='center' class='STAFF' onclick='showPopup("<%=posit_code%>","<%=prev_role%>","<%=prev_staff%>","<%=day%>");'>
								<input type='text' size='2' maxlength='1' align='center' class='TXTSTAFF' onclick='txtclick();' name='shift<%=role_typ%><%=staff_id1%><%=day%>' id='shift<%=role_typ%><%=staff_id1%><%=day%>' value='' onkeypress='return checkshift(<%=day%>,"<%=role_typ%>","<%=staff_id1%>","<%=posit_code%>");' onchange='checkshiftlost(this,"<%=role_typ%>","<%=staff_id1%>","<%=day%>","<%=posit_code%>"); onallocation( <%=day%>,"<%=posit_code%>","<%=role_typ%>","<%=staff_id1%>");' onblur='check(this,"<%=posit_code%>","<%=role_typ%>","<%=staff_id1%>","<%=day%>")' onfocus='unSelect(this);'></td>
								<input type='hidden' name='shift_code<%=role_typ%><%=staff_id1%><%=day%>' id='shift_code<%=role_typ%><%=staff_id1%><%=day%>' value=''>
								<input type='hidden' name='db_action<%=role_typ%><%=staff_id1%><%=day%>' id='db_action<%=role_typ%><%=staff_id1%><%=day%>' value='I'>
								<input type='hidden' name='shift_indicator<%=role_typ%><%=staff_id1%><%=day%>' id='shift_indicator<%=role_typ%><%=staff_id1%><%=day%>' value=''>
								<input type='hidden' name='productive_flag<%=role_typ%><%=staff_id1%><%=day%>' id='productive_flag<%=role_typ%><%=staff_id1%><%=day%>' value=''>
<%
							}
							day_count=day+1;
%>
							<td width='8%' align='center' class='STAFF' onclick='showPopup("<%=posit_code%>","<%=prev_role%>","<%=prev_staff%>","<%=day%>");'>
							<input type='text' size='2' maxlength='1' align='center' class='<%=classval%>' name='shift<%=role_typ%><%=staff_id1%><%=day%>' value='<%=shift_mnemonic%>' onclick='txtclick();' onkeypress='return  checkshift(<%=day%>,"<%=role_typ%>","<%=staff_id1%>","<%=posit_code%>");' onchange='checkshiftlost(this,"<%=role_typ%>","<%=staff_id1%>","<%=day%>","<%=posit_code%>"); onallocation( <%=day%>,"<%=posit_code%>","<%=role_typ%>","<%=staff_id1%>");' onblur='check(this,"<%=posit_code%>","<%=role_typ%>","<%=staff_id1%>","<%=day%>")' onfocus='unSelect(this);'></td>
							<input type='hidden' name='shift_code<%=role_typ%><%=staff_id1%><%=day%>' id='shift_code<%=role_typ%><%=staff_id1%><%=day%>' value='<%=shift_cod%>'>
							<input type='hidden' name='db_action<%=role_typ%><%=staff_id1%><%=day%>' id='db_action<%=role_typ%><%=staff_id1%><%=day%>' value='U'>
							<input type='hidden' name='shift_indicator<%=role_typ%><%=staff_id1%><%=day%>' id='shift_indicator<%=role_typ%><%=staff_id1%><%=day%>' value='<%=shift_indicator%>'>
							<input type='hidden' name='productive_flag<%=role_typ%><%=staff_id1%><%=day%>' id='productive_flag<%=role_typ%><%=staff_id1%><%=day%>' value='<%=prod_flag%>'>
<%
						}
					}
					if((staff+1 )<Staff_Data.size())
						staff_data=(String[])Staff_Data.get(staff+1);
					role_typ=staff_data[0];
					staff_typ=staff_data[1];
					staff_id1=staff_data[2];
					shift_cod=staff_data[3]==null?"":staff_data[3];
					prod_flag=staff_data[4]==null?"":staff_data[4];
					shift_indicator=staff_data[5]==null?"":staff_data[5];
					shift_mnemonic=staff_data[6]==null?"":staff_data[6];
					day_no=Integer.parseInt(staff_data[7]==null?"0":staff_data[7]);
					staff_name=staff_data[8]==null?"":staff_data[8];

					if((!prev_staff.equals(staff_data[2]))||(!prev_role.equals(role_typ))){
						if(day_count<7){
							for(day=day_count;day<7;day++){
%>
								<td width='8%' align='center' class='STAFF' onclick='showPopup("<%=posit_code%>","<%=prev_role%>","<%=prev_staff%>","<%=day%>");'>
								<input type='text' size='2' maxlength='1' align='center' class='TXTSTAFF' onclick='txtclick();' name='shift<%=prev_role%><%=prev_staff%><%=day%>' id='shift<%=prev_role%><%=prev_staff%><%=day%>' value='' onkeypress='return checkshift(<%=day%>,"<%=prev_role%>","<%=prev_staff%>","<%=posit_code%>");' onchange='checkshiftlost(this,"<%=prev_role%>","<%=prev_staff%>","<%=day%>","<%=posit_code%>"); onallocation( <%=day%>,"<%=posit_code%>","<%=prev_role%>","<%=prev_staff%>");' onblur='check(this,"<%=posit_code%>","<%=prev_role%>","<%=prev_staff%>","<%=day%>")'  onfocus='unSelect(this);'></td>
								<input type='hidden' name='shift_code<%=prev_role%><%=prev_staff%><%=day%>' id='shift_code<%=prev_role%><%=prev_staff%><%=day%>' value=''>
								<input type='hidden' name='db_action<%=prev_role%><%=prev_staff%><%=day%>' id='db_action<%=prev_role%><%=prev_staff%><%=day%>' value='I'>
								<input type='hidden' name='shift_indicator<%=prev_role%><%=prev_staff%><%=day%>' id='shift_indicator<%=prev_role%><%=prev_staff%><%=day%>' value=''>
								<input type='hidden' name='productive_flag<%=prev_role%><%=prev_staff%><%=day%>' id='productive_flag<%=prev_role%><%=prev_staff%><%=day%>' value=''>
<%
							}
							day_count=0;	
%>
							</tr>
<%
						}
					}
				}
			
	/*******************----------------------------***********************/
		
				if(day_count<7){
					for(day=day_count;day<7;day++){
%>
						<td width='8%' align='center' class='STAFF' onclick='showPopup("<%=posit_code%>","<%=prev_role%>","<%=prev_staff%>","<%=day%>");'>
						<input type='text' size='2' maxlength='1' align='center' class='TXTSTAFF' onclick='txtclick();' name='shift<%=prev_role%><%=prev_staff%><%=day%>' id='shift<%=prev_role%><%=prev_staff%><%=day%>' value='' onkeypress='return checkshift(<%=day%>,"<%=prev_role%>","<%=prev_staff%>","<%=posit_code%>");' onchange='checkshiftlost(this,"<%=prev_role%>","<%=prev_staff%>","<%=day%>","<%=posit_code%>"); onallocation( <%=day%>,"<%=posit_code%>","<%=prev_role%>","<%=prev_staff%>");' onblur='check(this,"<%=posit_code%>","<%=prev_role%>","<%=prev_staff%>","<%=day%>")' onfocus='unSelect(this);'></td>
						<input type='hidden' name='shift_code<%=prev_role%><%=prev_staff%><%=day%>' id='shift_code<%=prev_role%><%=prev_staff%><%=day%>' value=''>
						<input type='hidden' name='db_action<%=prev_role%><%=prev_staff%><%=day%>' id='db_action<%=prev_role%><%=prev_staff%><%=day%>' value='I'>
						<input type='hidden' name='shift_indicator<%=prev_role%><%=prev_staff%><%=day%>' id='shift_indicator<%=prev_role%><%=prev_staff%><%=day%>' value=''>
						<input type='hidden' name='productive_flag<%=prev_role%><%=prev_staff%><%=day%>' id='productive_flag<%=prev_role%><%=prev_staff%><%=day%>' value=''>
<%
					}
					day_count=0;	
%>
					</tr>
<%
				}
			}
/******************************/
%>
			<tr>
			<td colspan='2' rowspan='<%=totalShifts%>' class='SHIFTTOTAL'>&nbsp;Shift&nbsp;Total&nbsp;</td>
<%
			//to display Shift Total data
			for(int shift=0;shift<totalShifts;shift++){

				Shift_Allocated_Values=new int[7];
				shift_record=(String[])Shift_Data.get(shift);
				shift_code=shift_record[0];
				//to get the Shiftwise Requirements Total
				String sql_shiftwise_alloc="select a.shift_code,a.week_no,a.day_no, count(shift_mnemonic) allocated from rs_master_schedule a where a.facility_id = ? and a.workplace_code = ? and a.requirement_id = ? and shift_code=? and a.week_no = ? group by a.shift_code,a.week_no,a.day_no order by a.shift_code";
				pstmt_Shiftwise_Alloc = conn.prepareStatement( sql_shiftwise_alloc);
				pstmt_Shiftwise_Alloc.setString(1,facility_id);
				pstmt_Shiftwise_Alloc.setString(2,workplace_code);
				pstmt_Shiftwise_Alloc.setString(3,requirement_id);
				pstmt_Shiftwise_Alloc.setString(4,shift_code);
				pstmt_Shiftwise_Alloc.setString(5,String.valueOf(week_no));
				rs_Shiftwise_Alloc = pstmt_Shiftwise_Alloc.executeQuery() ;

				while (rs_Shiftwise_Alloc != null && rs_Shiftwise_Alloc.next()) {
					day_no=Integer.parseInt(rs_Shiftwise_Alloc.getString("day_no")==null?"0":rs_Shiftwise_Alloc.getString("day_no"));
					Shift_Allocated_Values[day_no-1]=Integer.parseInt(rs_Shiftwise_Alloc.getString("allocated")==null?"0":rs_Shiftwise_Alloc.getString("allocated"));
					Shiftwise_Alloc.put(rs_Shiftwise_Alloc.getString("shift_code"),Shift_Allocated_Values);
				}
				if(pstmt_Shiftwise_Alloc != null) 
			    pstmt_Shiftwise_Alloc.close() ;
			      if(rs_Shiftwise_Alloc != null) 
			     rs_Shiftwise_Alloc.close() ;

				if(Shiftwise_Req.containsKey(shift_code))
					shift_req=(String[])Shiftwise_Req.get(shift_code);
				else
					shift_req=null;
				if(Shiftwise_Alloc.containsKey(shift_code))
					Shift_Allocated_Values=(int[])Shiftwise_Alloc.get(shift_code);
				else
					Shift_Allocated_Values=null;
%>
	<!-- Shift Requirement Rows -->
				<td class='SHIFTTOTAL' width='19%' align='left'>&nbsp;<%=shift_record[2]%>&nbsp;-&nbsp;<%=shift_record[1]%></td>
<%
				Day_Indic=(String[])Day_Indicator.get(0);//Day_Indic.length
				for(day=0;day<Day_Indic.length;day++){
					alloc_val=0;
					req_val=0;
					if(Shift_Allocated_Values !=null)
						alloc_val=Shift_Allocated_Values[day];
					else
						alloc_val=0;
					if(Day_Indic[day].equalsIgnoreCase("W")){
						if(shift_req !=null)
							req_val=Integer.parseInt(shift_req[0]==null?"":shift_req[0]);
						else
							req_val=0;
					}
					else{
						if(Day_Indic[day].equalsIgnoreCase("N")){
							if(shift_req !=null)
								req_val=Integer.parseInt(shift_req[1]==null?"0":shift_req[1]);
							else
								req_val=0;
						}
						else{
							if(Day_Indic[day].equalsIgnoreCase("H")){
								if(shift_req !=null)
									req_val=Integer.parseInt(shift_req[2]==null?"0":shift_req[2]);
								else
									req_val=0;
							}
						}
					}
					if(alloc_val < req_val)
						classval="BELOWOPTIMAL";
					if(alloc_val >req_val)
						classval="ABOVEOPTIMAL";
					if(alloc_val == req_val)
						classval="OPTIMAL";
					if((req_val==0)&&(alloc_val == 0))
						classval="SHIFTTOTAL";
%>
					<td width='8%' class='<%=classval%>' align='center' id='req_alloc_shift<%=shift_code%><%=day%>'><%=alloc_val%>/<%=req_val%></td>
					<input type='hidden' name='req_shift<%=shift_code%><%=day%>' id='req_shift<%=shift_code%><%=day%>' value='<%=req_val%>'>
					<input type='hidden' name='alloc_shift<%=shift_code%><%=day%>' id='alloc_shift<%=shift_code%><%=day%>' value='<%=alloc_val%>'>
<%
				}
%>			
				</tr>	
<%
			}
		}/*position exists(else part)*/
%>
	
<!-- /*********************/ -->
		</table>
		<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name='user_id' id='user_id' value='<%=user_id%>'>
		<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
		<input type='hidden' name='workplace_code' id='workplace_code' value='<%=workplace_code%>'>
		<input type='hidden' name='requirement_id' id='requirement_id' value='<%=requirement_id%>'>
		<input type='hidden' name='total_records' id='total_records' value='<%=total_records%>'>
		<input type='hidden' name='view' id='view' value='<%=view%>'>
		<input type='hidden' name='week_no' id='week_no' value='<%=week_no%>'>

		<input type='hidden' name='locn_type' id='locn_type' value='<%=locn_type%>'>
		<input type='hidden' name='role_type' id='role_type' value='<%=role_type%>'>
		<input type='hidden' name='staff_type' id='staff_type' value='<%=staff_type%>'>
		<input type='hidden' name='position_code' id='position_code' value='<%=position_code%>'>
		<input type='hidden' name='staff_id' id='staff_id' value='<%=staff_id%>'>
		
		</form>

</body>
<%	
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	}
	finally {

		if(pstmt_Req_Total != null) 
			pstmt_Req_Total.close() ;

		if(pstmt_Alloc_Total != null) 
			pstmt_Alloc_Total.close() ;

		if(pstmt_Shiftwise_Req != null) 
			pstmt_Shiftwise_Req.close() ;

		if(pstmt_Positionwise_Req != null) 
			pstmt_Positionwise_Req.close() ;

		if(pstmt_Shiftwise_Alloc != null) 
			pstmt_Shiftwise_Alloc.close() ;

		if(pstmt_Positionwise_Alloc != null) 
			pstmt_Positionwise_Alloc.close() ;

		if(pstmt_Day_Indicator != null) 
			pstmt_Day_Indicator.close() ;

		if(pstmt_Staff_List != null) 
			pstmt_Staff_List.close() ;

		if(rs_Req_Total != null) 
			rs_Req_Total.close() ;

		if(rs_Alloc_Total != null) 
			rs_Alloc_Total.close() ;

		if(rs_Shiftwise_Req != null) 
			rs_Shiftwise_Req.close() ;

		if(rs_Positionwise_Req != null) 
			rs_Positionwise_Req.close() ;

		if(rs_Shiftwise_Alloc != null) 
			rs_Shiftwise_Alloc.close() ;

		if(rs_Positionwise_Alloc != null) 
			rs_Positionwise_Alloc.close() ;

		if(rs_Day_Indicator != null) 
			rs_Day_Indicator.close() ;

		if(rs_Staff_List != null) 
			rs_Staff_List.close() ;

		ConnectionManager.returnConnection(conn,request);
	}
%>
</html>

