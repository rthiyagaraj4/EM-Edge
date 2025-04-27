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
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- <link rel='stylesheet' type='text/css' href='../../eRS/html/RSStylesheet.css'></link> -->
<script language="JavaScript" src="../../eRS/js/MasterSchedule.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- <script language="JavaScript" src="../../eRS/js/RSMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%
	String facility_id		= request.getParameter("facility_id")==null?"":request.getParameter("facility_id") ;
	String workplace_code= request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
	String requirement_id	= request.getParameter("requirement_id")==null?"":request.getParameter("requirement_id");
	String role_type		=request.getParameter("role_type")==null?"":request.getParameter("role_type") ;
	String staff_type	=request.getParameter("staff_type")==null?"":request.getParameter("staff_type");
	String position_code= request.getParameter("position_code")==null?"":request.getParameter("position_code");
	String staff_id			=request.getParameter("staff_id")==null?"":request.getParameter("staff_id") ;
	String view				=request.getParameter("view")==null?"":request.getParameter("view");
	int week_count =Integer.parseInt(request.getParameter("week_count")==null?"0":request.getParameter("week_count"));
	int total_days=(week_count*7);
	String classval="";

	Connection conn 		= null;
	PreparedStatement pstmt_WeekDays 			= null;
	PreparedStatement pstmt_Req_Total	= null;
	PreparedStatement pstmt_Alloc_Total	= null;
	PreparedStatement pstmt_Shiftwise_Req 		= null;
	PreparedStatement pstmt_Shiftwise_Alloc 		= null;
	PreparedStatement pstmt_Positionwise_Req 	= null;
	PreparedStatement pstmt_Positionwise_Alloc= null;
	PreparedStatement pstmt_Day_Indicator 		= null;
	PreparedStatement pstmt_Staff_List 		= null;
	PreparedStatement pstmt_Position_Desc 	= null;
	PreparedStatement pstmt_Oncall_Req	 =	 null;
	PreparedStatement pstmt_Unprod_Alloc	 =	 null;

	ResultSet rs_WeekDays 		    = null;
	ResultSet rs_Req_Total		 	= null;
	ResultSet rs_Alloc_Total	 	= null;
	ResultSet rs_Shiftwise_Req 		= null;
	ResultSet rs_Shiftwise_Alloc 	= null;
	ResultSet rs_Positionwise_Req	= null;
	ResultSet rs_Positionwise_Alloc	= null;
	ResultSet rs_Day_Indicator 		= null;
	ResultSet rs_Staff_List 		= null;
	ResultSet rs_Position_Desc		= null;
	ResultSet rs_Oncall_Req			= null;
	ResultSet rs_Unprod_Alloc		= null;

	ArrayList Week_Days		= new ArrayList() ;
	ArrayList Staff_Data		= new ArrayList() ;
	ArrayList Shift_Data		= new ArrayList() ;
	ArrayList req_Optimal_Values		= new ArrayList() ;
	ArrayList Day_Indicator		= new ArrayList() ;
	ArrayList Positionwise_Req		= new ArrayList() ;
	ArrayList Oncall_Req			= new ArrayList() ;

	HashMap Positionwise_Alloc		= new HashMap() ;
	HashMap Shiftwise_Req		= new HashMap() ;
	HashMap Shiftwise_Alloc		= new HashMap() ;
	HashMap Shift_Dtl					= new HashMap() ;

	int Allocated_Values[] = new int[total_days];
	int Shift_Allocated_Values[] = new int[total_days];
	int Posit_Allocated_Values[] = new int[total_days];
	int Oncall_Allocated[] = new int[total_days];
	//int Oncall_Required[] = new int[total_days];
	int Unprod_Allocated[] = new int[total_days];
	int totalShifts=0;
	int week_no=1;
	int day_no=0;
	int req_val=0;
	int alloc_val=0;
	int day=0;
	int day_count=0;
	int optimal=0;
	int alloc_total=0;

	String[] record				= null;
	String[] position_record= null;
	String[] shift_record		= null;
	String[] shift_req=null;
	//String[] shift_alloc=null;
	//String[] position_req=null;
	String[] staff_data=null;
	String[] Day_Indic=null;

	String posit_code="";
	String shift_code="";
	String prev_staff="";
	String staff_id1="";
	String sql_staff_list="";
	String shift_mnemonic="";
	String shift_indicator="";
	String prod_flag="";
	conn = ConnectionManager.getConnection(request);
	try {

		if(view.equals("aloc"))

			sql_staff_list="select a.role_type, a.staff_type, a.staff_id, b.shift_code, c.productive_flag, c.shift_indicator,b.shift_mnemonic, b.day_no, b.week_no from rs_staff_for_workplace a, rs_master_schedule b, am_shift c where a.facility_id=? and a.workplace_code=? and (? is null or a.role_type = ?) and (? is null or a.staff_type = ?) AND (? IS NULL OR a.staff_id = ?) and (a.role_type, a.staff_id) in ( select x.role_type, x.staff_id from am_staff_vw x where x.position_code in (select distinct position_code from rs_workplace_requirement_dtl where facility_id=? and workplace_code=? and requirement_id=? and position_code=?)) and b.facility_id = ? and b.workplace_code = ? and b.requirement_id = ? and b.position_code = ? and b.role_type = a.role_type and b.staff_id = a.staff_id and c.shift_code = b.shift_code order by b.staff_id, b.day_no";

		else 
			sql_staff_list="select a.role_type, a.staff_type, a.staff_id, b.shift_code,c.productive_flag, c.shift_indicator, b.shift_mnemonic, b.day_no, b.week_no from rs_staff_for_workplace a, rs_master_schedule b, am_shift c where a.facility_id=? and a.workplace_code=? and (? is null or a.role_type = ?) and (? is null or a.staff_type = ?) AND (? IS NULL OR a.staff_id = ?) and (a.role_type, a.staff_id) in ( select x.role_type, x.staff_id from am_staff_vw x where x.position_code in (select distinct position_code from rs_workplace_requirement_dtl where facility_id=? and workplace_code=? and requirement_id=? and position_code=?)) and b.facility_id(+) = ? and b.workplace_code(+) = ? and b.requirement_id(+) = ? and b.position_code(+) = ?  and b.role_type(+) = a.role_type and b.staff_id(+) = a.staff_id and c.shift_code(+) = b.shift_code order by b.staff_id, b.day_no";

		String sql_week_days="Select day_no, initcap (substr( day_of_week,1,1) ) day_of_week from sm_day_of_week order by day_no";

		//to get the week days legend
		pstmt_WeekDays = conn.prepareStatement( sql_week_days);
		rs_WeekDays = pstmt_WeekDays.executeQuery() ;
		while (rs_WeekDays != null && rs_WeekDays.next()) 
		{
			record = new String[2];				
			record[0] = rs_WeekDays.getString("day_no");
			record[1] = rs_WeekDays.getString("day_of_week");
			Week_Days.add(record);
		}
		if(pstmt_WeekDays !=null)
			pstmt_WeekDays.close();
		if(rs_WeekDays !=null)
			rs_WeekDays.close();

		//to get the Day Indicator
		for(week_no=1;week_no<=week_count;week_no++){
			String sql_day_indicator="select week_"+week_no+"_day_1 day1, week_"+week_no+"_day_2 day2, week_"+week_no+"_day_3 day3, week_"+week_no+"_day_4 day4, week_"+week_no+"_day_5 day5, week_"+week_no+"_day_6 day6,week_"+week_no+"_day_7 day7 from rs_workplace where facility_id=?and workplace_code=?";

			pstmt_Day_Indicator = conn.prepareStatement( sql_day_indicator);
			pstmt_Day_Indicator.setString(1,facility_id);
			pstmt_Day_Indicator.setString(2,workplace_code);
			rs_Day_Indicator = pstmt_Day_Indicator.executeQuery() ;

			while (rs_Day_Indicator != null && rs_Day_Indicator.next()) 
			{
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
		}
		//to get the Day Totals Requirements
		String sql_req_total="select sum(a.fr_wday_opt) fr_wday_opt, sum(a.fr_nwday_opt) fr_nwday_opt, sum(a.fr_hday_opt)fr_hday_opt from rs_workplace_requirement_dtl a where a.facility_id =? and a.workplace_code = ? and a.requirement_id = ? ";
		pstmt_Req_Total = conn.prepareStatement( sql_req_total);
		pstmt_Req_Total.setString(1,facility_id);
		pstmt_Req_Total.setString(2,workplace_code);
		pstmt_Req_Total.setString(3,requirement_id);
		rs_Req_Total = pstmt_Req_Total.executeQuery() ;
		while (rs_Req_Total != null && rs_Req_Total.next())
		{
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
		while (rs_Oncall_Req != null && rs_Oncall_Req.next()) {
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
			week_no	=	Integer.parseInt(rs_Alloc_Total.getString("week_no")==null?"0":rs_Alloc_Total.getString("week_no"));
			day=Integer.parseInt(rs_Alloc_Total.getString("day_no")==null?"0":rs_Alloc_Total.getString("day_no"));
			day_no=((week_no-1)*7)+day;

			if(week_no <= week_count){
				if((p_flag!=null)&&(p_flag.equals("W"))){
					Allocated_Values[day_no-1]=Integer.parseInt(rs_Alloc_Total.getString("no_of_staff")==null?"0":rs_Alloc_Total.getString("no_of_staff"));
				}else{
					Oncall_Allocated[day_no-1]=Integer.parseInt(rs_Alloc_Total.getString("no_of_staff")==null?"0":rs_Alloc_Total.getString("no_of_staff"));
				}
			}
		}
		if(pstmt_Alloc_Total !=null)
			pstmt_Alloc_Total.close();
		if(rs_Alloc_Total !=null)
			rs_Alloc_Total.close();

		String sql_unproductive_allocated="SELECT   week_no, day_no, NVL (COUNT (staff_id), 0) no_of_staff    FROM rs_master_schedule a, am_shift b  WHERE facility_id = ?  AND workplace_code = ?  AND b.shift_code = a.shift_code AND b.shift_indicator = 'U' and a.requirement_id=? GROUP BY week_no, day_no, b.shift_indicator ORDER BY week_no, day_no";
		pstmt_Unprod_Alloc = conn.prepareStatement( sql_unproductive_allocated);
		pstmt_Unprod_Alloc.setString(1,facility_id);
		pstmt_Unprod_Alloc.setString(2,workplace_code);
		pstmt_Unprod_Alloc.setString(3,requirement_id);
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
		//String sql_shiftwise_total="SELECT   a.shift_code, b.mnemonic_key shift_mnemonic, SUM (a.fr_wday_opt) fr_wday_opt, SUM (a.fr_nwday_opt) fr_nwday_opt, SUM (a.fr_hday_opt) fr_hday_opt, b.short_desc FROM rs_workplace_requirement_dtl a, am_shift b WHERE a.facility_id = ? AND a.workplace_code = ? AND a.requirement_id = ? and a.shift_code=b.SHIFT_CODE and b.productive_flag is not null and b.productive_flag ='W' GROUP BY a.shift_code, b.mnemonic_key, b.short_desc ORDER BY shift_code";
		String sql_shiftwise_total="SELECT   a.shift_code, b.mnemonic_key shift_mnemonic, SUM (a.fr_wday_opt) fr_wday_opt, SUM (a.fr_nwday_opt) fr_nwday_opt, SUM (a.fr_hday_opt) fr_hday_opt, b.short_desc FROM rs_workplace_requirement_dtl a, am_shift_lang_vw b WHERE a.facility_id = ? AND a.workplace_code = ? AND a.requirement_id = ? and a.shift_code=b.SHIFT_CODE and b.productive_flag is not null and b.productive_flag ='W' and b.language_id = ? GROUP BY a.shift_code, b.mnemonic_key, b.short_desc ORDER BY shift_code";
		pstmt_Shiftwise_Req = conn.prepareStatement( sql_shiftwise_total);
		pstmt_Shiftwise_Req.setString(1,facility_id);
		pstmt_Shiftwise_Req.setString(2,workplace_code);
		pstmt_Shiftwise_Req.setString(3,requirement_id);
		pstmt_Shiftwise_Req.setString(4,locale);
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

		//String sql_positionwise_total="select a.position_code, b.position_desc,a.shift_code, c.mnemonic_key, c.short_desc shift_desc, sum(a.fr_wday_opt) fr_wday_opt, sum(a.fr_nwday_opt) fr_nwday_opt, sum(a.fr_hday_opt) fr_hday_opt from rs_workplace_requirement_dtl a, am_position b, am_shift c where a.facility_id = ? and a.workplace_code = ? and a.requirement_id = ? and (? is null or a.position_code = ?) and  a.position_code=b.position_code and a.shift_code=c.shift_code and c.productive_flag is not null and c.productive_flag ='W' group by a.position_code,a.shift_code, b.position_desc, c.mnemonic_key, c.short_desc order by position_desc, shift_code";
		String sql_positionwise_total="select a.position_code, b.position_desc,a.shift_code, c.mnemonic_key, c.short_desc shift_desc, sum(a.fr_wday_opt) fr_wday_opt, sum(a.fr_nwday_opt) fr_nwday_opt, sum(a.fr_hday_opt) fr_hday_opt from rs_workplace_requirement_dtl a, am_position_lang_vw b, am_shift_lang_vw c where a.facility_id = ? and a.workplace_code = ? and a.requirement_id = ? and (? is null or a.position_code = ?) and  a.position_code=b.position_code and a.shift_code=c.shift_code and c.productive_flag is not null and c.productive_flag ='W' and b.language_id = ? and c.language_id = b.language_id group by a.position_code,a.shift_code, b.position_desc, c.mnemonic_key, c.short_desc order by position_desc, shift_code";

		//to get the Positionwise Shiftwise Day Totals Requirements
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
		totalShifts=Shift_Data.size();
%>

<body  onMouseDown="CodeArrest()"   onKeyDown="lockKey()" >
		<form name=formByWorkplaceCompleteView >
		<table border='1' align='left' width="100%" bgcolor='white'>
			<tr><!-- <td width='7%'>&nbsp;</td> -->
				<td rowspan='2' colspan='2'class='master_label' align='left'>&nbsp;</td>
				<td rowspan='2' class='master_label'>&nbsp;</td>
<% 
				for(week_no=0; week_no<week_count; week_no++){
%>
					<td colspan='7' class='master_label' align='center'><b><-------------Week <%=week_no+1%> -------------></b></td>	
<%
				}
%>
				</tr>
				<tr>	
<%
				for(week_no=0; week_no<week_count; week_no++){
					for(int i=0; i<Week_Days.size();i++){
						classval="";
						record=(String[])Week_Days.get(i);
						//if((record[1].equalsIgnoreCase("Sat"))||(record[1].equalsIgnoreCase("Sun")))
						//	classval="WEEKEND";
						//else 
							classval="WORKDAY";
%>
						<td class='<%=classval%>' align='center' width='7%'> <b>&nbsp;&nbsp;&nbsp;&nbsp;<%=record[1]%>&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<%				}

				}
%>
				</tr>		
				<!-- Requirement Data row -->
 				<tr><!-- <td width='7%' class='REQUIREMENT'>&nbsp;</td> -->
				<td  colspan='2' width='10%' class='REQUIREMENT'>&nbsp;</td>
				<td width='34%' class='REQUIREMENT' align='left'>&nbsp;<b><fmt:message key="eRS.WorkingShift.label" bundle="${rs_labels}"/></b></td>
<%	
				optimal=0;
				alloc_total=0;
				Day_Indic=(String[])Day_Indicator.get(0);
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
					<td  colspan='2' width='10%' class='REQUIREMENT'>&nbsp;</td>
					<td width='34%' class='REQUIREMENT' align='left'>&nbsp;<b><fmt:message key="eRS.OncallShift.label" bundle="${rs_labels}"/></b></td>
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
					<td  colspan='2' width='10%' class='REQUIREMENT'>&nbsp;</td>
					<td width='30%' class='REQUIREMENT' align='left'>&nbsp;<b><fmt:message key="eRS.UnproductiveShift.label" bundle="${rs_labels}"/></b></td>
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
					String sql_possition_desc="select position_desc from am_position_lang_vw where position_code=? and language_id = ? ";
					pstmt_Position_Desc 	= conn.prepareStatement( sql_possition_desc);
					pstmt_Position_Desc.setString(1,position_code);
					pstmt_Position_Desc.setString(2,locale);
					rs_Position_Desc		 					= pstmt_Position_Desc.executeQuery();
					while (rs_Position_Desc != null && rs_Position_Desc.next()){
						position_desc=rs_Position_Desc.getString("position_desc");
					}
					if(pstmt_Position_Desc != null) 
			pstmt_Position_Desc.close() ;

		if(rs_Position_Desc != null) 
			rs_Position_Desc.close() ;

%>
				<tr><td class='position' colspan='<%=total_days+2%>'><b> <%=position_desc%></b></td>
<%
				} //out.println("<script>alert('no shift found')</script>");
			}
			else{
%>
	 
			<!-- Position Wise Data rows -->
<%	
				position_record=(String[])Positionwise_Req.get(0);

				for(int position=0;position<Positionwise_Req.size();position++){
					if(position_record != null){
						shift_code=position_record[2];
						if(!posit_code.equals(position_record[0])){
%>
							<tr id='posit<%=posit_code%>'>
								<td  onclick='javascript:expanddetails(this,"<%=position_record[0]%>")' align="center" width='2%' class='position'><a id=view<%=position_record[0]%>  href='' ><b>+</b></a></td><td colspan='<%=total_days+2%>' class='position' ><b>&nbsp;<%=position_record[1]%></b></td>
							</tr>
<%
							posit_code=position_record[0];	
						}
						Posit_Allocated_Values=new int[total_days];
						Positionwise_Alloc.clear();
						String sql_positionwise_alloc="select a.shift_code,a.week_no,a.day_no, count(shift_mnemonic) allocated from rs_master_schedule a where a.facility_id = ? and a.workplace_code = ? and a.requirement_id = ? and a.position_code = ? and a.shift_code=? group by a.shift_code, a.week_no, a.day_no order by a.shift_code";

						//to get the Positionwise Shiftwise Day Totals Requirements 
						pstmt_Positionwise_Alloc = conn.prepareStatement( sql_positionwise_alloc);
						pstmt_Positionwise_Alloc.setString(1,facility_id);
						pstmt_Positionwise_Alloc.setString(2,workplace_code);
						pstmt_Positionwise_Alloc.setString(3,requirement_id);
						pstmt_Positionwise_Alloc.setString(4,posit_code);
						pstmt_Positionwise_Alloc.setString(5,shift_code);
						rs_Positionwise_Alloc = pstmt_Positionwise_Alloc.executeQuery() ;
						while (rs_Positionwise_Alloc != null && rs_Positionwise_Alloc.next()) {
							week_no	=	Integer.parseInt(rs_Positionwise_Alloc.getString("week_no")==null?"0":rs_Positionwise_Alloc.getString("week_no"));
							if(week_no <= week_count){
								day=Integer.parseInt(rs_Positionwise_Alloc.getString("day_no")==null?"0":rs_Positionwise_Alloc.getString("day_no"));
								day_no=((week_no-1)*7)+day;								Posit_Allocated_Values[day_no-1]=Integer.parseInt(rs_Positionwise_Alloc.getString("allocated")==null?"0":rs_Positionwise_Alloc.getString("allocated"));								Positionwise_Alloc.put(rs_Positionwise_Alloc.getString("shift_code"),Posit_Allocated_Values);
							}
						}
						if(pstmt_Positionwise_Alloc != null) 
			pstmt_Positionwise_Alloc.close() ;

		if(rs_Positionwise_Alloc != null) 
			rs_Positionwise_Alloc.close() ;

%>		
						<tr id='posit<%=posit_code%>' style='display:none;'>
						<td class='ALOCATED' colspan='2'>&nbsp;</td>
						<td class='ALOCATED' width='34%' align='left'>&nbsp;<%=position_record[4]%>&nbsp;-&nbsp;<%=position_record[3]%></td>
<%	
						Posit_Allocated_Values=(int[])Positionwise_Alloc.get(shift_code);
						for(week_no=0;week_no<week_count;week_no++){
							Day_Indic=(String[])Day_Indicator.get(week_no);
							for(day_count=0;day_count<Day_Indic.length;day_count++){
								classval="";
								day=(week_no)*7+day_count;
								if(Posit_Allocated_Values != null)
									alloc_val=Posit_Allocated_Values[day];
								else
									alloc_val=0;
								if(Day_Indic[day_count].equalsIgnoreCase("W"))
									req_val=Integer.parseInt(position_record[5]==null?"0":position_record[5]);
								if(Day_Indic[day_count].equalsIgnoreCase("N"))
									req_val=Integer.parseInt(position_record[6]==null?"0":position_record[6]);
								if(Day_Indic[day_count].equalsIgnoreCase("H"))
									req_val=Integer.parseInt(position_record[7]==null?"0":position_record[5]); 

								if(alloc_val < req_val)
									classval="BELOWOPTIMAL";
								if(alloc_val > req_val)
									classval="ABOVEOPTIMAL";
								if(alloc_val == req_val)
									classval="OPTIMAL";
								if((req_val==0)&&(alloc_val == 0))
									classval="ALOCATED";
%>

								<td width='8%' class='<%=classval%>' align='center'><%=alloc_val%>/<%=req_val%> </td>
<%
							}
						}
%>
						</tr>
<!-- StaffWise Allocation (Display)  -->
<%
						//check for next position
						if((position+1)<Positionwise_Req.size())
							position_record=(String[])Positionwise_Req.get(position+1);
							//if next position found
						if(!posit_code.equals(position_record[0])){
			
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
							rs_Staff_List = pstmt_Staff_List.executeQuery() ;
							while (rs_Staff_List != null && rs_Staff_List.next()) {
								record = new String[9];		
								week_no=Integer.parseInt(rs_Staff_List.getString("week_no")==null?"0":rs_Staff_List.getString("week_no"));
								if(week_no <= week_count){
									record[0] = rs_Staff_List.getString("role_type") ;
									record[1] = rs_Staff_List.getString("staff_type") ;
									record[2] = rs_Staff_List.getString("staff_id") ;
									record[3] = rs_Staff_List.getString("shift_code") ;
									record[4] = rs_Staff_List.getString("productive_flag") ;
									record[5] = rs_Staff_List.getString("shift_indicator") ;
									record[6] = rs_Staff_List.getString("shift_mnemonic") ;
									record[7] = rs_Staff_List.getString("day_no") ;
									record[8] = rs_Staff_List.getString("week_no") ;
									Staff_Data.add(record);
								}
							}

							if(pstmt_Staff_List != null) 
			pstmt_Staff_List.close() ;

		if(rs_Staff_List != null) 
			rs_Staff_List.close() ;


							prev_staff="";
							if(Staff_Data.size()>0){
								staff_data=(String[])Staff_Data.get(0);
//								role_typ=staff_data[0];
//								staff_typ=staff_data[1];
								staff_id1=staff_data[2];
//								shift_cod=staff_data[3]==null?"":staff_data[3];
								prod_flag=staff_data[4]==null?"":staff_data[4];
								shift_indicator=staff_data[5]==null?"":staff_data[5];
								shift_mnemonic=staff_data[6]==null?"":staff_data[6];
								day_no=Integer.parseInt(staff_data[7]==null?"0":staff_data[7]);
								week_no=Integer.parseInt(staff_data[8]==null?"0":staff_data[8]);
								day_count=0;
								day=0;
								for(int staff=0;staff<Staff_Data.size();staff++){
									if(prod_flag.equals("O"))
										classval="Oncall";
									else
										if(shift_indicator.equals("U"))
										classval="Unproductive";
									else
										classval="master_label";
									if((week_no !=0)&&(day_no !=0))
										day_count=(week_no-1)*7+(day_no-1);
									else 
										day_count=0;
									if(!(prev_staff.equalsIgnoreCase(staff_id1))){
										prev_staff=staff_id1;
										day=0;
%>
										</tr>
										<tr id='posit<%=posit_code%>' style='display:none;'>
											<td colspan='3' align='left'  class='master_label'><b>&nbsp;<%=staff_id1%></b></td>
<%
									}
									if((day_count==day)&&(!(shift_mnemonic.equals("")))){
										day++;
%>
										<td width='8%' class='<%=classval%>' align='center' ><%=shift_mnemonic%></td>
<%
									}
									else{
										if(day_count !=0){ 
											for(;day<day_count;day++){
%>
												<td width='8%' class='master_label' align='center' >&nbsp;</td>
<%
											}				
%>
											<td width='8%' class='<%=classval%>' align='center' ><%=shift_mnemonic%></td>

<%
											day++;
										}
									}
									if((staff+1 )<Staff_Data.size())
												staff_data=(String[])Staff_Data.get(staff+1);
									staff_id1=staff_data[2];
//									shift_cod=staff_data[3]==null?"":staff_data[3];
									shift_indicator	 =
									prod_flag=staff_data[4]==null?"":staff_data[4];
									shift_indicator=staff_data[5]==null?"":staff_data[5];
									shift_mnemonic=staff_data[6]==null?"":staff_data[6];
									day_no=Integer.parseInt(staff_data[7]==null?"0":staff_data[7]);
									week_no=Integer.parseInt(staff_data[8]==null?"0":staff_data[8]);
									if(!(prev_staff.equals(staff_data[2]))){
										if(day<total_days){
											for(;day<total_days;day++){
%>
												<td width='8%' align='center' class='master_label'>&nbsp;</td>
<%
											}
											day=0;
										}
									}
								}
%>
					
<!-- ****************************************** -->
<%	
								if(day<total_days){
									for(;day<total_days;day++){
%>
										<td width='8%' align='center' class='master_label'>&nbsp;</td>
<%
									}
%>
									</tr>
<%
								}
							}
						}
					}
				}
%>
<!-- /******************************/ -->
<%
				//check for next position
				
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
				rs_Staff_List = pstmt_Staff_List.executeQuery() ;
				while (rs_Staff_List != null && rs_Staff_List.next()) {
					record = new String[9];		
					week_no=Integer.parseInt(rs_Staff_List.getString("week_no")==null?"0":rs_Staff_List.getString("week_no"));
					if(week_no <= week_count){
						record[0] = rs_Staff_List.getString("role_type") ;
						record[1] = rs_Staff_List.getString("staff_type") ;
						record[2] = rs_Staff_List.getString("staff_id") ;
						record[3] = rs_Staff_List.getString("shift_code") ;
						record[4] = rs_Staff_List.getString("productive_flag") ;
						record[5] = rs_Staff_List.getString("shift_indicator") ;
						record[6] = rs_Staff_List.getString("shift_mnemonic") ;
						record[7] = rs_Staff_List.getString("day_no") ;
						record[8] = rs_Staff_List.getString("week_no") ;

						Staff_Data.add(record);
					}
				}
				if(pstmt_Staff_List != null) 
			pstmt_Staff_List.close() ;

		if(rs_Staff_List != null) 
			rs_Staff_List.close() ;


				prev_staff="";
				if(Staff_Data.size()>0){
					staff_data=(String[])Staff_Data.get(0);
//					role_typ=staff_data[0];
//					staff_typ=staff_data[1];
					staff_id1=staff_data[2];
//					shift_cod=staff_data[3]==null?"":staff_data[3];
					prod_flag=staff_data[4]==null?"":staff_data[4];
					shift_indicator=staff_data[5]==null?"":staff_data[5];
					shift_mnemonic=staff_data[6]==null?"":staff_data[6];
					day_no=Integer.parseInt(staff_data[7]==null?"0":staff_data[7]);
					week_no=Integer.parseInt(staff_data[8]==null?"0":staff_data[8]);

					day_count=0;
					day=0;
					for(int staff=0;staff<Staff_Data.size();staff++){
						if(prod_flag.equals("O"))
							classval="Oncall";
						else
							if(shift_indicator.equals("U"))
							classval="Unproductive";
						else
							classval="master_label";
						if((week_no !=0)&&(day_no !=0))
							day_count=(week_no-1)*7+(day_no-1);
						else 
							day_count=0;
						if(!(prev_staff.equalsIgnoreCase(staff_id1))){
							prev_staff=staff_id1;
							day=0;
%>
							</tr>
							<tr id='posit<%=posit_code%>' style='display:none;'>
								<td colspan='3' align='left'  class='master_label'><b>&nbsp;<%=staff_id1%></b></td>
<%
						}
						if((day_count==day)&&(!(shift_mnemonic.equals("")))){
							day++;
%>
							<td width='8%' class='<%=classval%>' align='center' ><%=shift_mnemonic%></td>
<%
						}
						else{ 
							if(day_count !=0){ 
								for(;day<day_count;day++){
%>
									<td width='8%' align='center' class='master_label'>&nbsp;</td>
<%
								}				
%>
								<td width='8%' class='<%=classval%>' align='center' ><%=shift_mnemonic%></td>
<%
								day++;
							}
						}
						if((staff+1 )<Staff_Data.size()){
								staff_data=(String[])Staff_Data.get(staff+1);
						}
						staff_id1=staff_data[2];
//						shift_cod=staff_data[3]==null?"":staff_data[3];
						prod_flag=staff_data[4]==null?"":staff_data[4];
						shift_indicator=staff_data[5]==null?"":staff_data[5];
						shift_mnemonic=staff_data[6]==null?"":staff_data[6];
						day_no=Integer.parseInt(staff_data[7]==null?"0":staff_data[7]);
						week_no=Integer.parseInt(staff_data[8]==null?"0":staff_data[8]);

						if(!(prev_staff.equals(staff_data[2]))){
							if(day<total_days){
								for(;day<total_days;day++){
%>
									<td width='8%' class='master_label' align='center' >&nbsp;</td>
<%
								}
								day=0;
							}
						}
					}
%>
					
<!-- ****************************************** -->
<%	
					if(day<total_days){
						for(;day<total_days;day++){
%>
							<td width='8%' class='master_label' align='center' >&nbsp;</td>
<%
						}
%>
						</tr>
<%
					}
				}
%>			

<!-- /******************************/ -->
				<tr>
				<td  rowspan='<%=totalShifts%>' colspan='2' class='SHIFTTOTAL'>&nbsp;<fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;</td>

<%
				//to display Shift Total data
				for(int shift=0;shift<totalShifts;shift++){
					Shift_Allocated_Values=new int[total_days];
					shift_record=(String[])Shift_Data.get(shift);
					shift_code=shift_record[0];
					//to get the Shiftwise Allocated Total
					String sql_shiftwise_alloc="select a.shift_code,a.week_no,a.day_no, count(shift_mnemonic) allocated from rs_master_schedule a where a.facility_id = ? and a.workplace_code = ? and a.requirement_id = ? and shift_code=? group by a.shift_code,a.week_no,a.day_no order by a.shift_code";
					pstmt_Shiftwise_Alloc = conn.prepareStatement( sql_shiftwise_alloc);
					pstmt_Shiftwise_Alloc.setString(1,facility_id);
					pstmt_Shiftwise_Alloc.setString(2,workplace_code);
					pstmt_Shiftwise_Alloc.setString(3,requirement_id);
					pstmt_Shiftwise_Alloc.setString(4,shift_code);
					rs_Shiftwise_Alloc = pstmt_Shiftwise_Alloc.executeQuery() ;
					while (rs_Shiftwise_Alloc != null && rs_Shiftwise_Alloc.next()) {
						week_no	=	Integer.parseInt(rs_Shiftwise_Alloc.getString("week_no")==null?"0":rs_Shiftwise_Alloc.getString("week_no"));
						if(week_no<=week_count){
							day=Integer.parseInt(rs_Shiftwise_Alloc.getString("day_no")==null?"0":rs_Shiftwise_Alloc.getString("day_no"));
							day_no=((week_no-1)*7)+day;
							Shift_Allocated_Values[day_no-1]=Integer.parseInt(rs_Shiftwise_Alloc.getString("allocated")==null?"0":rs_Shiftwise_Alloc.getString("allocated"));
							Shiftwise_Alloc.put(rs_Shiftwise_Alloc.getString("shift_code"),Shift_Allocated_Values);
						}
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
					<td class='SHIFTTOTAL' width='34%' align='left'>&nbsp;<%=shift_record[2]%> - <%=shift_record[1]%></td>
<%
					for(week_no=0;week_no<week_count;week_no++){
						Day_Indic=(String[])Day_Indicator.get(week_no);
						for(day_count=0;day_count<Day_Indic.length;day_count++){

							classval="";
							alloc_val=0;
							req_val=0;
							day=(week_no*7)+day_count;
							if(Shift_Allocated_Values != null)
								alloc_val=Shift_Allocated_Values[day];
							else
								alloc_val=0;
							if(Day_Indic[day_count].equalsIgnoreCase("W")){
								if(shift_req !=null)
									req_val=Integer.parseInt(shift_req[0]==null?"0":shift_req[0]);
								else
									req_val=0;
							} 
							else{
								if(Day_Indic[day_count].equalsIgnoreCase("N")){
									if(shift_req !=null)
										req_val=Integer.parseInt(shift_req[1]==null?"0":shift_req[1]);
									else
										req_val=0;
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
							<td width='8%' class='<%=classval%>' align='center'><%=alloc_val%>/<%=req_val%> </td>
<%
						}
					}
%>		
					</tr>		
<%
				}
			}
%>	
<!-- /*********************/ -->
			</table>
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

		if(pstmt_WeekDays != null) 
			pstmt_WeekDays.close() ;

		if(rs_WeekDays != null) 
			rs_WeekDays.close() ;

		if(rs_Req_Total != null) 
			rs_Req_Total.close() ;

		if(rs_Alloc_Total != null) 
			rs_Alloc_Total.close() ;

		if(rs_Shiftwise_Req != null) 
			rs_Shiftwise_Req.close() ;

		if(rs_Positionwise_Req != null) 
			rs_Positionwise_Req	.close() ;

		if(rs_Shiftwise_Alloc != null) 
			rs_Shiftwise_Alloc.close() ;

		if(rs_Positionwise_Alloc != null) 
			rs_Positionwise_Alloc	.close() ;

		if(rs_Day_Indicator != null) 
			rs_Day_Indicator.close() ;

		if(rs_Staff_List != null) 
			rs_Staff_List.close() ;

		ConnectionManager.returnConnection(conn,request);

	}
%>
</html>

