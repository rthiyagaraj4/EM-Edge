<!DOCTYPE html>
<%/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	ManageWorkSheduleResult.jsp
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
<script language="JavaScript" src="../../eRS/js/ManageWorkSchedule.js"></script>
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
String user_id			=request.getParameter("user_id")==null?"":request.getParameter("user_id");
String function_id= request.getParameter( "function_id")==null?"":request.getParameter( "function_id");

String workplace_code= request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
String role_type		=request.getParameter("role_type")==null?"":request.getParameter("role_type") ;
String position_code= request.getParameter("position_code")==null?"":request.getParameter("position_code");
String staff_id			=request.getParameter("staff_id")==null?"":request.getParameter("staff_id") ;
String view				=request.getParameter("view")==null?"":request.getParameter("view");
String from_date				=request.getParameter("new_from_date")==null?"":request.getParameter("new_from_date");
String to_date				=request.getParameter("new_to_date")==null?"":request.getParameter("new_to_date");
String productive_flag	=	request.getParameter("productive_flag")==null?"W":request.getParameter("productive_flag");
int DAYS=Integer.parseInt(request.getParameter("DAYS")==null?"0":request.getParameter("DAYS"));

//String leaveIcon ="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>" ;
String leaveIcon ="&nbsp;" ;
String classval="";
Connection con 		= null;
PreparedStatement pstmt_PositionTotal	= null;
PreparedStatement pstmt_PositionShiftTotal 		= null;
PreparedStatement pstmt_PositionOncallTotal 		= null;
PreparedStatement pstmt_StaffList 		= null;
PreparedStatement pstmt_StaffLeaveList 		= null;

ResultSet rs_PositionTotal	= null;
ResultSet rs_PositionShiftTotal	= null;
ResultSet rs_PositionOncallTotal	= null;
ResultSet rs_StaffList 		= null;
ResultSet rs_StaffLeaveList 		= null;

ArrayList StaffList		= new ArrayList() ;
ArrayList PositionShiftTotal		= new ArrayList() ;
ArrayList PositionOncallTotal		= new ArrayList() ;
ArrayList PositionTotal		= new ArrayList() ;
ArrayList StaffLeaveDays	 =	 new ArrayList();

HashMap Staff_Leave_Dtl		=	new HashMap();

int posit_req=0, posit_alloc=0, posit_cellno=0, posit_day=0,shift_day=0;
int shift_req=0, shift_alloc=0, shift_cellno=0, shift_count=0,j=0;
int staff_day=0, staff_count=0, staff_cellno=0, k=0,prev_cell=0;
int day=0;
int oncall_cellno=0, oncall_day=0, oncall_count=0, oncall_req=0, oncall_alloc=0; 

String[] record			 = null;
//String[] position_record = null;
String[] shift_record	 = null;
String[] oncall_record	 = null;
String[] staff_record	 =	null;
//String[] staff_leave_record=null;

String posit_code="", posit_desc="", prev_posit="", schedule_date="";
String posit_code1="",shift_code="", shift_desc="", shift_mnemonic="", prev_shift="";
String role_type2="", posit_code2="", staff_id2="", prev_role="", prev_staff="", shift_code2="", shift_mnemonic2="", schedule_date2="", prev_sched_date="", prev_shift2="", prev_mnemonic2="";
String staff_type2="", prev_staff_type="", staff_workplace="",prev_workplace="", staff_name="";
String onposit_code="",oncall_code="";

String sql_StaffList="";
String sql_PositionTotal="";
String sql_PositionShiftTotal="";
String sql_PositionOncallTotal="";
String sql_StaffLeaveList="";
boolean flag=false, wrk_flag=false;

con = ConnectionManager.getConnection(request);
try {

//sql_PositionTotal="select a.position_code, b.position_desc, sum(a.required_staff) required, sum(a.allocated_staff) allocated, to_char(a.schedule_date,'dd/mm/yyyy') schedule_date, (TRUNC (a.schedule_date) - TRUNC (TO_DATE (?, 'dd/mm/yyyy'))) cell_no from rs_work_schedule_summ a, am_position b, am_shift c where 	a.facility_id = ? and a.workplace_code = ? and a.schedule_date between to_date(?,'dd/mm/yyyy')	and to_date(?,'dd/mm/yyyy') and 	(? is null or a.position_code = ?) and a.position_code=b.position_code and a.shift_code=c.shift_code and c.shift_indicator='P' and c.productive_flag='W' group by a.position_code, b.position_desc, a.schedule_date order by a.position_code";

sql_PositionTotal="select a.position_code, b.position_desc, sum(a.required_staff) required, sum(a.allocated_staff) allocated, to_char(a.schedule_date,'dd/mm/yyyy') schedule_date, (TRUNC (a.schedule_date) - TRUNC (TO_DATE (?, 'dd/mm/yyyy'))) cell_no from rs_work_schedule_summ a, am_position_lang_vw b, am_shift c where  a.facility_id = ? and a.workplace_code = ? and a.schedule_date between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') and  (? is null or a.position_code = ?) and a.position_code=b.position_code and a.shift_code=c.shift_code and c.shift_indicator='P' and c.productive_flag='W' and b.language_id = ? group by a.position_code, b.position_desc, a.schedule_date order by a.position_code";

//sql_PositionShiftTotal="SELECT   a.position_code, a.shift_code, a.shift_mnemonic, b.long_desc, SUM (a.required_staff) required, SUM (a.allocated_staff) allocated, TO_CHAR (a.schedule_date, 'dd/mm/yyyy') schedule_date, (  TRUNC (a.schedule_date) - TRUNC (TO_DATE (?, 'dd/mm/yyyy'))) cell_no FROM rs_work_schedule_summ a, am_shift b  WHERE a.facility_id = ? AND a.workplace_code =? AND a.schedule_date BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND TO_DATE (?, 'dd/mm/yyyy') AND (? IS NULL OR a.position_code = ?) AND a.shift_code = b.shift_code AND b.shift_indicator = 'P' AND b.productive_flag = 'W' GROUP BY a.position_code, a.shift_code, b.long_desc, a.shift_mnemonic, a.schedule_date ORDER BY a.position_code, b.long_desc, a.schedule_date";
sql_PositionShiftTotal="SELECT   a.position_code, a.shift_code, a.shift_mnemonic, b.long_desc, SUM (a.required_staff) required, SUM (a.allocated_staff) allocated, TO_CHAR (a.schedule_date, 'dd/mm/yyyy') schedule_date, (  TRUNC (a.schedule_date) - TRUNC (TO_DATE (?, 'dd/mm/yyyy'))) cell_no FROM rs_work_schedule_summ a, am_shift_lang_vw b  WHERE a.facility_id = ? AND a.workplace_code =? AND a.schedule_date BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND TO_DATE (?, 'dd/mm/yyyy') AND (? IS NULL OR a.position_code = ?) AND a.shift_code = b.shift_code AND b.shift_indicator = 'P' AND b.productive_flag = 'W' and b.language_id = ? GROUP BY a.position_code, a.shift_code, b.long_desc, a.shift_mnemonic, a.schedule_date ORDER BY a.position_code, b.long_desc, a.schedule_date";

sql_PositionOncallTotal="SELECT   a.position_code, 'OOOOO' shift_code, SUM (a.required_staff) required, SUM (a.allocated_staff) allocated, TO_CHAR (a.schedule_date, 'dd/mm/yyyy') schedule_date, (TRUNC (a.schedule_date) - TRUNC (TO_DATE (?, 'dd/mm/yyyy'))) cell_no FROM rs_work_schedule_summ a, am_shift b WHERE a.facility_id = ? AND a.workplace_code = ? AND a.schedule_date BETWEEN TO_DATE (?, 'dd/mm/yyyy')  AND TO_DATE (?, 'dd/mm/yyyy') AND (? IS NULL OR a.position_code = ?) AND a.shift_code = b.shift_code AND b.shift_indicator = 'P' AND b.productive_flag = 'O' GROUP BY a.position_code,         a.schedule_date ORDER BY position_code, cell_no";

sql_StaffList="select	a.position_code, a.role_type, a.staff_id, c.staff_name, to_char(a.schedule_date,'dd/mm/yyyy') schedule_date,	a.shift_code, a.shift_mnemonic, to_date(a.schedule_date)-to_date(?,'dd/mm/yyyy') staff_cellno, a.staff_type, a.workplace_code, b.shift_indicator, b.productive_flag  from rs_work_Schedule a, am_shift b, am_staff_vw c where (a.role_type,a.staff_id) in (select role_type,staff_id from rs_staff_for_workplace where facility_id = ? and workplace_code = ? and to_date(?,'dd/mm/yyyy') between eff_date_from and nvl(eff_date_to,to_date('31/12/2200','dd/mm/yyyy')) and to_date(?,'dd/mm/yyyy') between eff_date_from and nvl(eff_date_to,to_date('31/12/2200','dd/mm/yyyy'))) 	and a.schedule_date between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') and	a.facility_id = ? and ( ? is null or a.role_type = ?) and ( ? is null or a.position_code = ?) 	and (? is null or a.staff_id = ?) and b.shift_code = a.shift_code and a.role_type=c.role_type and a.staff_id=c.staff_id  AND c.language_id = ? UNION ALL select b.position_code,a.role_type,a.staff_id, b.staff_name, to_char(null,'dd/mm/yyyy') schedule_date, to_char(null) shift_code, to_char(null) shift_mnemonic, to_number(null) cell_no, b.staff_type, a.workplace_code, to_char(null) shift_indicator, to_char(null) productive_flag from rs_staff_for_workplace a, am_staff_vw b where a.facility_id = ? and a.workplace_code = ? and to_date(?,'dd/mm/yyyy') between a.eff_date_from and nvl(a.eff_date_to,to_date('31/12/2200','dd/mm/yyyy')) and to_date(?,'dd/mm/yyyy') between a.eff_date_from and nvl(a.eff_date_to,to_date('31/12/2200','dd/mm/yyyy')) and (a.role_type,a.staff_id) not in (select role_type,staff_id from rs_work_schedule where facility_id = ? and workplace_code = ? and schedule_date between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') ) and b.role_type = a.role_type and b.staff_id = a.staff_id	and b.position_code in (select position_code from rs_work_schedule_summ where facility_id = ? AND workplace_code = ? AND schedule_date BETWEEN TO_DATE (?, 'dd/mm/yyyy')  AND TO_DATE (?, 'dd/mm/yyyy') ) and ( ? is null or a.role_type = ?) and (? is null or a.staff_id = ?) and (? is null or b.position_code=?) and  B.LANGUAGE_ID = ? order by 1,2,4,8";

sql_StaffLeaveList="select role_type, staff_id, leave_date - to_date(?,'dd/mm/yyyy') staff_leave_cellno from rs_staff_unavailability_log where leave_date BETWEEN TO_DATE (?, 'dd/mm/yyyy')  AND TO_DATE (?, 'dd/mm/yyyy')  and (role_type,staff_id) in (select role_type,staff_id from rs_staff_for_workplace where facility_id = ? and workplace_code = ?) and cancel_reason_code IS NULL order by role_type,staff_id, staff_leave_cellno";


//to get the Position Wise Total
pstmt_PositionTotal=con.prepareStatement(sql_PositionTotal);
pstmt_PositionTotal.setString(1,from_date);
pstmt_PositionTotal.setString(2,facility_id);
pstmt_PositionTotal.setString(3,workplace_code);
pstmt_PositionTotal.setString(4,from_date);
pstmt_PositionTotal.setString(5,to_date);
pstmt_PositionTotal.setString(6,position_code);
pstmt_PositionTotal.setString(7,position_code);
pstmt_PositionTotal.setString(8,locale);

rs_PositionTotal=pstmt_PositionTotal.executeQuery();

while((rs_PositionTotal !=null)&&(rs_PositionTotal.next()))
{
record=new String[6];
record[0]=rs_PositionTotal.getString("position_code");
record[1]=rs_PositionTotal.getString("position_desc");
record[2]=rs_PositionTotal.getString("required");
record[3]=rs_PositionTotal.getString("allocated");
record[4]=rs_PositionTotal.getString("schedule_date");
record[5]=rs_PositionTotal.getString("cell_no");
PositionTotal.add(record);
}

if(pstmt_PositionTotal != null)
pstmt_PositionTotal.close();
if(rs_PositionTotal != null)
rs_PositionTotal.close();

//to get the Position Wise Shift Wise Total
pstmt_PositionShiftTotal=con.prepareStatement(sql_PositionShiftTotal);
pstmt_PositionShiftTotal.setString(1,from_date);
pstmt_PositionShiftTotal.setString(2,facility_id);
pstmt_PositionShiftTotal.setString(3,workplace_code);
pstmt_PositionShiftTotal.setString(4,from_date);
pstmt_PositionShiftTotal.setString(5,to_date);
pstmt_PositionShiftTotal.setString(6,position_code);
pstmt_PositionShiftTotal.setString(7,position_code);
pstmt_PositionShiftTotal.setString(8,locale);

rs_PositionShiftTotal=pstmt_PositionShiftTotal.executeQuery();
while((rs_PositionShiftTotal !=null)&&(rs_PositionShiftTotal.next()))
{
record=new String[8];
record[0]=rs_PositionShiftTotal.getString("position_code");
record[1]=rs_PositionShiftTotal.getString("shift_code");
record[2]=rs_PositionShiftTotal.getString("shift_mnemonic");
record[3]=rs_PositionShiftTotal.getString("long_desc");
record[4]=rs_PositionShiftTotal.getString("required");
record[5]=rs_PositionShiftTotal.getString("allocated");
record[6]=rs_PositionShiftTotal.getString("schedule_date");
record[7]=rs_PositionShiftTotal.getString("cell_no");
PositionShiftTotal.add(record);
}
if(pstmt_PositionShiftTotal != null)
pstmt_PositionShiftTotal.close();
if(rs_PositionShiftTotal != null)
rs_PositionShiftTotal.close();

//to get the Position Wise Shift Wise Total
pstmt_PositionOncallTotal=con.prepareStatement(sql_PositionOncallTotal);
pstmt_PositionOncallTotal.setString(1,from_date);
pstmt_PositionOncallTotal.setString(2,facility_id);
pstmt_PositionOncallTotal.setString(3,workplace_code);
pstmt_PositionOncallTotal.setString(4,from_date);
pstmt_PositionOncallTotal.setString(5,to_date);
pstmt_PositionOncallTotal.setString(6,position_code);
pstmt_PositionOncallTotal.setString(7,position_code);

rs_PositionOncallTotal=pstmt_PositionOncallTotal.executeQuery();

while((rs_PositionOncallTotal !=null)&&(rs_PositionOncallTotal.next())){
record=new String[6];
record[0]=rs_PositionOncallTotal.getString("position_code");
record[1]=rs_PositionOncallTotal.getString("shift_code");
record[2]=rs_PositionOncallTotal.getString("required");
record[3]=rs_PositionOncallTotal.getString("allocated");
record[4]=rs_PositionOncallTotal.getString("schedule_date");
record[5]=rs_PositionOncallTotal.getString("cell_no");

PositionOncallTotal.add(record);
}
if(pstmt_PositionOncallTotal != null)
pstmt_PositionOncallTotal.close();
if(rs_PositionOncallTotal != null)
rs_PositionOncallTotal.close();


//to get the Position Wise Shift Wise Staff List
pstmt_StaffList=con.prepareStatement(sql_StaffList);
pstmt_StaffList.setString(1,from_date);
pstmt_StaffList.setString(2,facility_id);
pstmt_StaffList.setString(3,workplace_code);
pstmt_StaffList.setString(4,from_date);
pstmt_StaffList.setString(5,to_date);
pstmt_StaffList.setString(6,from_date);
pstmt_StaffList.setString(7,to_date);
pstmt_StaffList.setString(8,facility_id);
pstmt_StaffList.setString(9,role_type);
pstmt_StaffList.setString(10,role_type);
pstmt_StaffList.setString(11,position_code);
pstmt_StaffList.setString(12,position_code);
pstmt_StaffList.setString(13,staff_id);
pstmt_StaffList.setString(14,staff_id);
pstmt_StaffList.setString(15,locale);
pstmt_StaffList.setString(16,facility_id);
pstmt_StaffList.setString(17,workplace_code);
pstmt_StaffList.setString(18,from_date);
pstmt_StaffList.setString(19,to_date);
pstmt_StaffList.setString(20,facility_id);
pstmt_StaffList.setString(21,workplace_code);
pstmt_StaffList.setString(22,from_date);
pstmt_StaffList.setString(23,to_date);
pstmt_StaffList.setString(24,facility_id);
pstmt_StaffList.setString(25,workplace_code);
pstmt_StaffList.setString(26,from_date);
pstmt_StaffList.setString(27,to_date);
pstmt_StaffList.setString(28,role_type);
pstmt_StaffList.setString(29,role_type);
pstmt_StaffList.setString(30,staff_id);
pstmt_StaffList.setString(31,staff_id);
pstmt_StaffList.setString(32,position_code);
pstmt_StaffList.setString(33,position_code);
pstmt_StaffList.setString(34,locale);

 
rs_StaffList=pstmt_StaffList.executeQuery();
while((rs_StaffList !=null)&&(rs_StaffList.next())){
record=new String[12];
record[0]=rs_StaffList.getString("role_type")==null?"":rs_StaffList.getString("role_type");
record[1]=rs_StaffList.getString("position_code")==null?"":rs_StaffList.getString("position_code");
record[2]=rs_StaffList.getString("staff_id")==null?"":rs_StaffList.getString("staff_id");
record[3]=rs_StaffList.getString("schedule_date")==null?"":rs_StaffList.getString("schedule_date");
record[4]=rs_StaffList.getString("shift_code")==null?"":rs_StaffList.getString("shift_code");
record[5]=rs_StaffList.getString("shift_mnemonic")==null?"":rs_StaffList.getString("shift_mnemonic");
record[6]=rs_StaffList.getString("staff_cellno")==null?"0":rs_StaffList.getString("staff_cellno");
record[7]=rs_StaffList.getString("staff_type")==null?"":rs_StaffList.getString("staff_type");
record[8]=rs_StaffList.getString("workplace_code")==null?"":rs_StaffList.getString("workplace_code");
record[9]=rs_StaffList.getString("shift_indicator")==null?"":rs_StaffList.getString("shift_indicator");
record[10]=rs_StaffList.getString("productive_flag")==null?"":rs_StaffList.getString("productive_flag");
record[11]=rs_StaffList.getString("staff_name")==null?"":rs_StaffList.getString("staff_name");
StaffList.add(record);
}
if(pstmt_StaffList != null)
pstmt_StaffList.close();
if(rs_StaffList != null)
rs_StaffList.close();

pstmt_StaffLeaveList=con.prepareStatement(sql_StaffLeaveList);
pstmt_StaffLeaveList.setString(1,from_date);
pstmt_StaffLeaveList.setString(2,from_date);
pstmt_StaffLeaveList.setString(3,to_date);
pstmt_StaffLeaveList.setString(4,facility_id);
pstmt_StaffLeaveList.setString(5,workplace_code);

rs_StaffLeaveList=pstmt_StaffLeaveList.executeQuery();
String key="";
while((rs_StaffLeaveList !=null)&&(rs_StaffLeaveList.next())){
String Lstaff_id	 =	 rs_StaffLeaveList.getString("staff_id")==null?"":rs_StaffLeaveList.getString("staff_id");
String Lrole_type	=rs_StaffLeaveList.getString("role_type")==null?"":rs_StaffLeaveList.getString("role_type");
String Lcellno = rs_StaffLeaveList.getString("staff_leave_cellno")==null?"0":rs_StaffLeaveList.getString("staff_leave_cellno");
String key1=Lrole_type+Lstaff_id;


if(!(key.equals(key1)||(key.equals("")))){
Staff_Leave_Dtl.put(key, StaffLeaveDays);
StaffLeaveDays=new ArrayList();
}
StaffLeaveDays.add(Lcellno);
key=Lrole_type+Lstaff_id;
}
Staff_Leave_Dtl.put(key, StaffLeaveDays);

if(pstmt_StaffLeaveList != null)
pstmt_StaffLeaveList.close();
if(rs_StaffLeaveList != null)
rs_StaffLeaveList.close();	
%>

<body onKeyDown="lockKey()" onclick='hidePopup();'>
<form name=formManageWorkScheduleResult >
<table border='1'  align='left' width="100%" cellpadding='0'>
<!-- Posisiton wise details -->
<tr>
<%
if(PositionTotal.size() > 0){
record=(String[])PositionTotal.get(0);
posit_code	=	record[0];			
posit_desc	=	record[1];
posit_req	=	Integer.parseInt(record[2]==null?"0":record[2]);
posit_alloc	=	Integer.parseInt(record[3]==null?"0":record[3]);
schedule_date	=	record[4];
posit_cellno	=	Integer.parseInt(record[5]);

if(posit_alloc > posit_req)
classval	=	"ABOVEOPTIMAL";
if(posit_alloc < posit_req)
classval	=	"BELOWOPTIMAL";
if(posit_alloc == posit_req)
classval	=	"OPTIMAL";
if((posit_alloc == 0)&&(posit_req == 0))
classval	=	"EmptyCell";
%>
</tr>
<tr id='posit<%=posit_code%>'><td  onclick='javascript:expanddetails(this,"<%=posit_code%>")' align="center" width='2%' class=PositionTotal><a id=view<%=posit_code%>  href='' ><b>+</b></a></td>
<td	class='PositionTotal' align=left width='14%' nowrap><%=posit_desc%>
</td>
<%
if(posit_cellno > posit_day){//condition to check the first schedule date > from_date
for(day=posit_day; day<posit_cellno;day++){
%>
<td class='EmptyCell' width="6%" id='posit<%=posit_code%><%=day%>' align='center' nowrap>&nbsp;</td>
<input type='hidden' name='positreq<%=posit_code%><%=day%>' id='positreq<%=posit_code%><%=day%>' value=''>
<input type='hidden' name='positalloc<%=posit_code%><%=day%>' id='positalloc<%=posit_code%><%=day%>' value=''>
<%
}
posit_day=posit_cellno;
}
%>
<td class='<%=classval%>' width="6%" id='posit<%=posit_code%><%=posit_day%>' align='center' nowrap><%=posit_alloc%>/<%=posit_req%></td>	
<input type='hidden' name='positreq<%=posit_code%><%=posit_day%>' id='positreq<%=posit_code%><%=posit_day%>' value='<%=posit_req%>'>
<input type='hidden' name='positalloc<%=posit_code%><%=posit_day%>' id='positalloc<%=posit_code%><%=posit_day%>' value='<%=posit_alloc%>'>
<%	
posit_day++;
prev_posit				=	posit_code;

for(int i=1;i<PositionTotal.size();i++){
//continue with the next position total
record=(String[])PositionTotal.get(i);
posit_code	=	record[0];			
posit_desc	=	record[1];
posit_req	=	Integer.parseInt(record[2]==null?"0":record[2]);
posit_alloc	=	Integer.parseInt(record[3]==null?"0":record[3]);
schedule_date	=	record[4];
posit_cellno	=	Integer.parseInt(record[5]);

//check for next position
if(!prev_posit.equals(posit_code)){
for(day=posit_day;day<DAYS;day++){
%>
<td class='EmptyCell' width="6%" id='posit<%=prev_posit%><%=day%>' align='center' nowrap>&nbsp;</td>
<input type='hidden' name='positreq<%=prev_posit%><%=day%>' id='positreq<%=prev_posit%><%=day%>' value=''>
<input type='hidden' name='positalloc<%=prev_posit%><%=day%>' id='positalloc<%=prev_posit%><%=day%>' value=''>
<%	
}
//********************to display the shift total***********************\\
if(PositionShiftTotal.size() >shift_count) {

shift_record=(String[])PositionShiftTotal.get(shift_count++);

posit_code1	=	shift_record[0];	
shift_code	=shift_record[1];
shift_mnemonic=shift_record[2];
shift_desc	=	shift_record[3];
shift_req	=	Integer.parseInt(shift_record[4]==null?"0":shift_record[4]);
shift_alloc	=	Integer.parseInt(shift_record[5]==null?"0":shift_record[5]);
shift_cellno	=	Integer.parseInt(shift_record[7]);
shift_day=0;

if(shift_alloc > shift_req)
	classval	=	"ABOVEOPTIMAL";
if(shift_alloc < shift_req)
	classval	=	"BELOWOPTIMAL";
if(shift_alloc == shift_req)
	classval	=	"OPTIMAL";
if((shift_alloc == 0)&&(shift_req == 0))
	classval	=	"EmptyCell";

if(prev_posit.equals(posit_code1)){ 
	//check for same position in both 
%>
	</tr>
	<tr id='posit<%=posit_code1%>' style='display:none;'>
		<td	class='PositionShiftTotal' align='left' colspan='2' width='16%'nowrap><%=shift_desc%> - <%=shift_mnemonic%></td>
<%
		if(shift_cellno > shift_day){
			//check for the first schedule date > from date
			for(day=shift_day; day<shift_cellno;day++){
%>
				<td class='EmptyCell' width="6%" id='positshift<%=prev_posit%><%=shift_code%><%=day%>' align='center' nowrap>&nbsp;</td>
				<input type='hidden' name='positshiftreq<%=prev_posit%><%=shift_code%><%=day%>' id='positshiftreq<%=prev_posit%><%=shift_code%><%=day%>' value=''>
				<input type='hidden' name='positshiftalloc<%=prev_posit%><%=shift_code%><%=day%>' id='positshiftalloc<%=prev_posit%><%=shift_code%><%=day%>' value=''>
<%	
			}
			shift_day=shift_cellno;
			
		}
%>
		<td class='<%=classval%>' width="6%" id='positshift<%=prev_posit%><%=shift_code%><%=shift_day%>' align='center' nowrap><%=shift_alloc%>/<%=shift_req%></td>	
		<input type='hidden' name='positshiftreq<%=prev_posit%><%=shift_code%><%=shift_day%>' id='positshiftreq<%=prev_posit%><%=shift_code%><%=shift_day%>' value='<%=shift_req%>'>
		<input type='hidden' name='positshiftalloc<%=prev_posit%><%=shift_code%><%=shift_day%>' id='positshiftalloc<%=prev_posit%><%=shift_code%><%=shift_day%>' value='<%=shift_alloc%>'>
<%
		shift_day++;
		prev_shift=shift_code;

		for(j=shift_count;j<PositionShiftTotal.size();j++)	{
		//continue with the shift data
			shift_record=(String[])PositionShiftTotal.get(j);
			posit_code1	=	shift_record[0];	
			shift_code	=	shift_record[1];
			shift_mnemonic=shift_record[2];
			shift_desc	=	shift_record[3];
			shift_req	=	Integer.parseInt(shift_record[4]==null?"0":shift_record[4]);
			shift_alloc	=	Integer.parseInt(shift_record[5]==null?"0":shift_record[5]);
			shift_cellno	=	Integer.parseInt(shift_record[7]);

			//check for next shift in the same position 
			if((!shift_code.equals(prev_shift))||(!posit_code1.equals(prev_posit))){
				//check for the same position in both
				for(day=shift_day;day<DAYS;day++){
%>
					<td class='EmptyCell' width="6%" id='positshift<%=prev_posit%><%=prev_shift%><%=day%>' align='center' nowrap>&nbsp;</td>
					<input type='hidden' name='positshiftreq<%=prev_posit%><%=prev_shift%><%=day%>' id='positshiftreq<%=prev_posit%><%=prev_shift%><%=day%>' value=''>
					<input type='hidden' name='positshiftalloc<%=prev_posit%><%=prev_shift%><%=day%>' id='positshiftalloc<%=prev_posit%><%=prev_shift%><%=day%>' value=''>
<%
				}
				shift_count=j;
				shift_day=0;

//********************to display the ONCALL shift total***********************\\
				if(!posit_code1.equals(prev_posit)){
					if(PositionOncallTotal.size() >oncall_count){

						oncall_record=(String[])PositionOncallTotal.get(oncall_count++);
						onposit_code	=	oncall_record[0];	
						oncall_code	=oncall_record[1];
						oncall_req	=	Integer.parseInt(oncall_record[2]==null?"0":oncall_record[2]);
						oncall_alloc	=	Integer.parseInt(oncall_record[3]==null?"0":oncall_record[3]);
						oncall_cellno	=	Integer.parseInt(oncall_record[5]);
						oncall_day=0;

						if(oncall_alloc > oncall_req)
							classval	=	"ABOVEOPTIMAL";
						if(oncall_alloc < oncall_req)
							classval	=	"BELOWOPTIMAL";
						if(oncall_alloc == oncall_req)
							classval	=	"OPTIMAL";
						if((oncall_alloc == 0)&&(oncall_req == 0))
							classval	=	"EmptyCell";

						if(prev_posit.equals(onposit_code)){ 
							//check for same position in both 
%>
							</tr>
							<tr id='posit<%=onposit_code%>' style='display:none;'>
								<td	class='PositionShiftTotal' align='left' colspan='2' width='16%'nowrap><fmt:message key="eRS.Oncall.label" bundle="${rs_labels}"/>&nbsp;<fmt:message key="Common.SHIFT.label"bundle="${common_labels}"/></td>
<%	
								if(oncall_cellno > oncall_day){
									//check for the first schedule date > from date
									for(day=oncall_day; day<oncall_cellno;day++){
%>
										<td class='EmptyCell' width="6%" id='positoncall<%=prev_posit%><%=oncall_code%><%=day%>' align='center' nowrap>&nbsp;</td>
										<input type='hidden' name='positoncallreq<%=prev_posit%><%=oncall_code%><%=day%>' id='positoncallreq<%=prev_posit%><%=oncall_code%><%=day%>' value=''>
										<input type='hidden' name='positoncallalloc<%=prev_posit%><%=oncall_code%><%=day%>' id='positoncallalloc<%=prev_posit%><%=oncall_code%><%=day%>' value=''>
<%
									}
									oncall_day=oncall_cellno;
							  }
%>
								<td class='<%=classval%>' width="6%" id='positoncall<%=prev_posit%><%=oncall_code%><%=oncall_day%>' align='center' nowrap><%=oncall_alloc%>/<%=oncall_req%></td>	
								<input type='hidden' name='positoncallreq<%=prev_posit%><%=oncall_code%><%=oncall_day%>' id='positoncallreq<%=prev_posit%><%=oncall_code%><%=oncall_day%>' value='<%=oncall_req%>'>
								<input type='hidden' name='positoncallalloc<%=prev_posit%><%=oncall_code%><%=oncall_day%>' id='positoncallalloc<%=prev_posit%><%=oncall_code%><%=oncall_day%>' value='<%=oncall_alloc%>'>
<%
								oncall_day++;
								for(k=oncall_count;k<PositionOncallTotal.size();k++){
								//continue with the shift data
									oncall_record=(String[])PositionOncallTotal.get(k);
									onposit_code	=	oncall_record[0];	
									oncall_code	=oncall_record[1];
									oncall_req	=	Integer.parseInt(oncall_record[2]==null?"0":oncall_record[2]);
									oncall_alloc	=	Integer.parseInt(oncall_record[3]==null?"0":oncall_record[3]);
									oncall_cellno	=	Integer.parseInt(oncall_record[5]);

									//check for next shift in the same position 
									if(!(onposit_code.equals(prev_posit))){
									//check for the same position in both
										for(day=oncall_day;day<DAYS;day++){
%>
										<td class='EmptyCell' width="6%" id='positoncall<%=prev_posit%><%=oncall_code%><%=day%>' align='center' nowrap>&nbsp;</td>
										<input type='hidden' name='positoncallreq<%=prev_posit%><%=oncall_code%><%=day%>' id='positoncallreq<%=prev_posit%><%=oncall_code%><%=day%>' value=''>
										<input type='hidden' name='positoncallalloc<%=prev_posit%><%=oncall_code%><%=day%>' id='positoncallalloc<%=prev_posit%><%=oncall_code%><%=day%>' value=''>
<%
									}
									oncall_count=k;
									oncall_day=0;
									break;
								}
								if(oncall_cellno > oncall_day){
								//check for the first schedule date > from date
									for(day=oncall_day; day<oncall_cellno;day++){
%>
										<td class='EmptyCell' width="6%" id='positoncall<%=prev_posit%><%=oncall_code%><%=day%>' align='center' nowrap><%=oncall_day%>&nbsp;
										</td>	<input type='hidden' name='positoncallreq<%=prev_posit%><%=oncall_code%><%=day%>' id='positoncallreq<%=prev_posit%><%=oncall_code%><%=day%>' value=''>
										<input type='hidden' name='positoncallalloc<%=prev_posit%><%=oncall_code%><%=day%>' id='positoncallalloc<%=prev_posit%><%=oncall_code%><%=day%>' value=''>
<%
									}
									oncall_day=oncall_cellno;
								}
								if(oncall_alloc > oncall_req)
									classval	=	"ABOVEOPTIMAL";
								if(oncall_alloc < oncall_req)
									classval	=	"BELOWOPTIMAL";
								if(oncall_alloc == oncall_req)
									classval	=	"OPTIMAL";
								if((oncall_alloc == 0)&&(oncall_req == 0))
									classval	=	"EmptyCell";
%>
								<td class='<%=classval%>' width="6%" id='positoncall<%=prev_posit%><%=oncall_code%><%=oncall_day%>' align='center' nowrap><%=oncall_alloc%>/<%=oncall_req%></td>	
								<input type='hidden' name='positoncallreq<%=prev_posit%><%=oncall_code%><%=oncall_day%>' id='positoncallreq<%=prev_posit%><%=oncall_code%><%=oncall_day%>' value='<%=oncall_req%>'>
								<input type='hidden' name='positoncallalloc<%=prev_posit%><%=oncall_code%><%=oncall_day%>' id='positoncallalloc<%=prev_posit%><%=oncall_code%><%=oncall_day%>' value='<%=oncall_alloc%>'>
<%	
								oncall_day++;
							}
						}
						else
							oncall_count--;
					 }

//**********Staff List ******************/
					if(StaffList.size() > staff_count){

						staff_record=(String[])StaffList.get(staff_count++);
						
						role_type2	= staff_record[0];
						posit_code2	=	staff_record[1];	
						staff_id2			=	staff_record[2];
						schedule_date2	=	staff_record[3];
						shift_code2	=staff_record[4];
						shift_mnemonic2=staff_record[5];
						staff_cellno	=	Integer.parseInt(staff_record[6]);
						staff_type2	=	staff_record[7];
						staff_workplace	=	staff_record[8];
						staff_name	=	staff_record[11];
						staff_day=0;
						classval="StaffList";
						key	=	role_type2+staff_id2;
                       
						if(prev_posit.equals(posit_code2)){ 
						//check for same position in both 
							if(Staff_Leave_Dtl.containsKey(key))
								StaffLeaveDays	=	(ArrayList)Staff_Leave_Dtl.get(key);
							else
								StaffLeaveDays	=	new ArrayList();

							if((!staff_workplace.equals(workplace_code))&&(!wrk_flag)){
								classval="StaffOtherWP";
								wrk_flag=true;
							}
%>
							</tr>
							<tr id='posit<%=posit_code2%>' style='display:none;'>
								<td	class='StaffList' align=left colspan='2' width='16%' nowrap><%=staff_name%></td>
								<input type='hidden' name='staffid<%=posit_code2%>' id='staffid<%=posit_code2%>' value='<%=staff_id2%>'>
								<input type='hidden' name='roletype<%=posit_code2%>' id='roletype<%=posit_code2%>' value='<%=staff_id2%>'>

<%
							if((staff_cellno-1) > staff_day){
							   //check for the first schedule date > from date
								for(day=staff_day; day<staff_cellno-1;day++){
									if(StaffLeaveDays.contains(String.valueOf(day))){
										classval = "LeaveStaff";
										prev_mnemonic2="";
										leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
									}
									else
									{
										classval	=	"StaffList";
										leaveIcon=prev_mnemonic2;
									}
%>
									<td class='<%=classval%>' width="6%" onclick='showPopup("<%=facility_id%>", "<%=workplace_code%>","<%=posit_code2%>","<%=role_type2%>","<%=staff_id2%>", "<%=from_date%>","","","<%=productive_flag%>","<%=day%>","<%=staff_type2%>", this);' id='staff<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' align='center' nowrap><%=leaveIcon%></td>
									<input type='hidden' name='staffshift<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' id='staffshift<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' value=''>
									<input type='hidden' name='staffshiftcode<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' id='staffshiftcode<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' value=''>
<%
								}
								staff_day=staff_cellno-1;
							}
							if(staff_workplace.equals(workplace_code)){
								if(prev_role.equals(role_type2)&&prev_staff.equals(staff_id2)&&prev_sched_date.equals(schedule_date2)){
									if(prev_shift2.equals("")){
											prev_shift2		=	shift_code2;
											prev_mnemonic2	=	shift_mnemonic2;
									}
									else{
											prev_shift2=	prev_shift2+"|"+shift_code2;
											prev_mnemonic2=	prev_mnemonic2+"|"+shift_mnemonic2;
									}
								}
								else{
										wrk_flag=false;						
										prev_shift2=shift_code2;
										prev_mnemonic2=shift_mnemonic2;
										prev_sched_date	= schedule_date2;
								}
							}
							prev_staff	=	staff_id2;
							prev_role	=	role_type2;
							prev_cell	 =	 staff_cellno;
							prev_workplace=staff_workplace;
							prev_sched_date	= schedule_date2;

							for(k=staff_count;k<StaffList.size();k++){ //continue with the shift data

								staff_record=(String[])StaffList.get(k);

								role_type2	= staff_record[0];
								posit_code2	=	staff_record[1];	
								staff_id2			=	staff_record[2];
								schedule_date2	=	staff_record[3];
								shift_code2	=staff_record[4];
								shift_mnemonic2=staff_record[5];
								staff_cellno	=	Integer.parseInt(staff_record[6]);
								staff_type2	=	staff_record[7];
								staff_workplace	=	staff_record[8];
								staff_name	=	staff_record[11];

								//check for next staff in the same position 
								if((!staff_id2.equals(prev_staff))||(!role_type2.equals(prev_role))){
									//check for the same position in both
									if(prev_cell > staff_day){
										for(day=staff_day; day<(prev_cell);day++){
											if(StaffLeaveDays.contains(String.valueOf(day))){
												classval = "LeaveStaff";
												prev_mnemonic2="";
												leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
											}
											else
											{
												classval	=	"StaffList";
												leaveIcon =prev_mnemonic2;
												if(leaveIcon=="")
												leaveIcon ="&nbsp;" ;
												
											}
%>
											<td class='<%=classval%>' width="6%" onclick='showPopup("<%=facility_id%>", "<%=workplace_code%>","<%=prev_posit%>","<%=prev_role%>","<%=prev_staff%>", "<%=from_date%>", "","", "","<%=day%>","<%=prev_staff_type%>", this);' id='staff<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' align='center' nowrap><%=leaveIcon%></td>
											<input type='hidden' name='staffshift<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' id='staffshift<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' value=''>
											<input type='hidden' name='staffshiftcode<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' id='staffshiftcode<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' value=''>
			
<%	
										}
										staff_day=prev_cell;
									}

									for(day=staff_day;day<DAYS;day++){
										if(StaffLeaveDays.contains(String.valueOf(day))){
											classval = "LeaveStaff";
											prev_mnemonic2="";
										
											leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
    ; 
											
										}
										else{
											if((!prev_workplace.equals(workplace_code))&&(!wrk_flag)){
												classval="StaffOtherWP";
												wrk_flag=true;
												leaveIcon=prev_mnemonic2;
												}
												leaveIcon=prev_mnemonic2;
													if(leaveIcon=="")
													leaveIcon ="&nbsp;" ;
										}

										if(prev_mnemonic2.equals(""))
										{
											 prev_mnemonic2="&nbsp;";
											
											 
											
										}
%>
										<td class='<%=classval%>' width="6%" onclick='showPopup("<%=facility_id%>", "<%=workplace_code%>","<%=prev_posit%>","<%=prev_role%>","<%=prev_staff%>", "<%=from_date%>", "<%=prev_shift2%>", "<%=prev_mnemonic2%>", "<%=productive_flag%>","<%=day%>","<%=prev_staff_type%>", this);' id='staff<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' align='center' nowrap><%=leaveIcon%></td>
										<input type='hidden' name='staffshift<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' id='staffshift<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' value='<%=prev_mnemonic2%>'>
										<input type='hidden' name='staffshiftcode<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' id='staffshiftcode<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' value='<%=prev_shift2%>'>
<%
										prev_shift2="";
										prev_mnemonic2="&nbsp;";
										classval	=	"StaffList";
									}
									wrk_flag=false;
									staff_day=day;
									staff_count=k;
									if(!posit_code2.equals(prev_posit)){
										flag=true;
										prev_mnemonic2="";
										prev_shift2="";
										break ;
									}
									prev_staff	=	staff_id2;
									prev_role	=	role_type2;
									prev_staff_type	=	staff_type2;
									prev_sched_date	= schedule_date2;
									prev_cell	 =	 staff_cellno;
									prev_workplace	=	staff_workplace;
									prev_mnemonic2="";
									prev_shift2="";
									staff_day=0;
									key=role_type2+staff_id2;

									if(Staff_Leave_Dtl.containsKey(key))
										StaffLeaveDays	=	(ArrayList)Staff_Leave_Dtl.get(key);
									else
										StaffLeaveDays	=	new ArrayList();
%>
									</tr>
									<tr id='posit<%=prev_posit%>' style='display:none;'>
										<td	class='StaffList' align=left colspan='2' width='16%' nowrap><%=staff_name%></td>
<%
								}	
								else
									staff_count--;

								if(prev_cell > staff_day){
									for(day=staff_day; day<(prev_cell);day++)	{
										if(StaffLeaveDays.contains(String.valueOf(day))){
												classval = "LeaveStaff";
												prev_mnemonic2="";
												leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
										}
										else
										{
												classval	=	"StaffList";
												leaveIcon	=	prev_mnemonic2;
												if(leaveIcon=="")
												leaveIcon ="&nbsp;" ;
										}
%>
										<td class='<%=classval%>' width="6%" onclick='showPopup("<%=facility_id%>", "<%=workplace_code%>","<%=posit_code2%>","<%=role_type2%>","<%=staff_id2%>", "<%=from_date%>", "","", "<%=productive_flag%>","<%=day%>","<%=staff_type2%>", this);' id='staff<%=prev_posit%><%=role_type2%><%=staff_id2%><%=day%>' align='center' nowrap><%=leaveIcon%></td>
										<input type='hidden' name='staffshift<%=prev_posit%><%=role_type2%><%=staff_id2%><%=day%>' id='staffshift<%=prev_posit%><%=role_type2%><%=staff_id2%><%=day%>' value=''>
										<input type='hidden' name='staffshiftcode<%=prev_posit%><%=role_type2%><%=staff_id2%><%=day%>' id='staffshiftcode<%=prev_posit%><%=role_type2%><%=staff_id2%><%=day%>' value=''>
<%	
									}
									staff_day=prev_cell;
									classval	=	"StaffList";
									wrk_flag=false;
								}
								if(prev_role.equals(role_type2)&&prev_staff.equals(staff_id2)&&prev_sched_date.equals(schedule_date2)){
									if(staff_workplace.equals(workplace_code)){
										if(prev_shift2.equals("")){
											prev_shift2		=	shift_code2;
											prev_mnemonic2	=	shift_mnemonic2;
										}
										else{
													prev_shift2=	prev_shift2+"|"+shift_code2;
													prev_mnemonic2=	prev_mnemonic2+"|"+shift_mnemonic2;
										}
									}
									if((!prev_workplace.equals(workplace_code))&&(!wrk_flag)){
										classval="StaffOtherWP";
										wrk_flag=true;
									}
								}
								else{
									if(prev_mnemonic2.equals(""))
										prev_mnemonic2="&nbsp;";
									if((!prev_workplace.equals(workplace_code))&&(!wrk_flag)){
										classval="StaffOtherWP";
										wrk_flag=true;
									}
%>
									<td class='<%=classval%>' width="6%" onclick='showPopup("<%=facility_id%>", "<%=workplace_code%>","<%=prev_posit%>","<%=role_type2%>","<%=staff_id2%>", "<%=from_date%>", "<%=prev_shift2%>", "<%=prev_mnemonic2%>", "<%=productive_flag%>","<%=staff_day%>","<%=staff_type2%>", this);' id='staff<%=prev_posit%><%=role_type2%><%=staff_id2%><%=staff_day%>' align='center' nowrap><%=prev_mnemonic2%></td>
									<input type='hidden' name='staffshift<%=prev_posit%><%=role_type2%><%=staff_id2%><%=staff_day%>' id='staffshift<%=prev_posit%><%=role_type2%><%=staff_id2%><%=staff_day%>' value='<%=prev_mnemonic2%>'>
									<input type='hidden' name='staffshiftcode<%=prev_posit%><%=role_type2%><%=staff_id2%><%=staff_day%>' id='staffshiftcode<%=prev_posit%><%=role_type2%><%=staff_id2%><%=staff_day%>' value='<%=prev_shift2%>'>
		
<%	
									if(staff_workplace.equals(workplace_code)){
										prev_shift2		=	shift_code2;
										prev_mnemonic2	=	shift_mnemonic2;
										prev_sched_date	= schedule_date2;
									}
									else{
										prev_shift2		=	"";
										prev_mnemonic2	=	"";
									}
									classval="StaffList";
									wrk_flag=false;
									staff_day++;
								}

								prev_staff	=	staff_id2;
								prev_role	=	role_type2;
								prev_cell	 =	 staff_cellno;
								prev_staff_type=staff_type2;
								prev_sched_date=schedule_date2;
								prev_workplace	=	staff_workplace;
							}
							staff_count=k;
							for(day=staff_day; day<DAYS;day++){
								if(StaffLeaveDays.contains(String.valueOf(day))){
									classval = "LeaveStaff";
									prev_mnemonic2="";
									leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
								}
								else{
									if(wrk_flag){
										classval="StaffOtherWP";
										wrk_flag=false;
									}
									else
										classval	=	"StaffList";

									leaveIcon=prev_mnemonic2;
									if(leaveIcon=="")
									leaveIcon ="&nbsp;" ;
								}
								
%>
								<td class='<%=classval%>' width="6%" onclick='showPopup("<%=facility_id%>", "<%=workplace_code%>","<%=prev_posit%>","<%=prev_role%>","<%=prev_staff%>", "<%=from_date%>", "<%=prev_shift2%>","<%=prev_mnemonic2%>", "<%=productive_flag%>","<%=day%>","<%=prev_staff_type%>", this);' id='staff<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' align='center' nowrap><%=leaveIcon%></td>
								<input type='hidden' name='staffshift<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' id='staffshift<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' value='<%=prev_mnemonic2%>'>
								<input type='hidden' name='staffshiftcode<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' id='staffshiftcode<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' value='<%=prev_shift2%>'>
<%	
								prev_mnemonic2="&nbsp;";
								prev_shift2	=	"";
								classval="StaffList";
								wrk_flag=false;
							}
						}
						else
							staff_count--;
					}
/***************Staff List end *****************************/
				}
				prev_shift	=	shift_code;
				prev_staff	=	staff_id2;
				prev_role	=	role_type2;
				prev_staff_type	=	staff_type2;
				prev_sched_date	=	schedule_date;
				prev_cell	 =	 staff_cellno;
				prev_mnemonic2="";
				prev_shift2="";
				posit_day=0;
				if((flag)||(staff_count == StaffList.size())||(!prev_posit.equals(posit_code1))){
					flag=false;
					break;
				}
%>
				</tr>
				<tr id='posit<%=posit_code1%>' style='display:none;'>
					<td	class='PositionShiftTotal' align=left colspan='2' width='16%' nowrap><%=shift_desc%> - <%=shift_mnemonic%></td>
<%
			}	
			else 
				shift_count--;

			if(shift_cellno > shift_day){
				for(day=shift_day; day<shift_cellno;day++){
					//to complete the prevous shift cells
%>
					<td class='EmptyCell' width="6%" id='positshift<%=prev_posit%><%=prev_shift%><%=day%>' align='center' nowrap>&nbsp;</td>
					<input type='hidden' name='positshiftreq<%=prev_posit%><%=prev_shift%><%=day%>' id='positshiftreq<%=prev_posit%><%=prev_shift%><%=day%>' value=''>
					<input type='hidden' name='positshiftalloc<%=prev_posit%><%=prev_shift%><%=day%>' id='positshiftalloc<%=prev_posit%><%=prev_shift%><%=day%>' value=''>
<%	
				}
				shift_day=shift_cellno;
			}

			if(shift_alloc > shift_req)
				classval	=	"ABOVEOPTIMAL";
			if(shift_alloc < shift_req)
				classval	=	"BELOWOPTIMAL";
			if(shift_alloc == shift_req)
				classval	=	"OPTIMAL";
			if((shift_alloc == 0)&&(shift_req == 0))
				classval	=	"EmptyCell";
%>
			<td class='<%=classval%>' width="6%" id='positshift<%=prev_posit%><%=shift_code%><%=shift_day%>' align='center' nowrap><%=shift_alloc%>/<%=shift_req%></td>
			<input type='hidden' name='positshiftreq<%=prev_posit%><%=shift_code%><%=shift_day%>' id='positshiftreq<%=prev_posit%><%=shift_code%><%=shift_day%>' value='<%=shift_req%>'>
			<input type='hidden' name='positshiftalloc<%=prev_posit%><%=shift_code%><%=shift_day%>' id='positshiftalloc<%=prev_posit%><%=shift_code%><%=shift_day%>' value='<%=shift_alloc%>'>
				
<%
			shift_day++;
		}
		shift_count=j;
}
}
prev_posit=posit_code;
posit_day=0;
shift_day=0;
%>
</tr>
<tr id='posit<%=posit_code%>'><td  onclick='javascript:expanddetails(this,"<%=posit_code%>")' align="center" width='2%' class=PositionTotal><a id=view<%=posit_code%>  href='' ><b>+</b></a></td>
<td	class='PositionTotal' align=left width='14%' nowrap><%=posit_desc%></td>
	
<%
}
if(posit_cellno > posit_day){
for(day=posit_day; day<posit_cellno;day++){
%>
<td class='EmptyCell'  width="6%" id='posit<%=prev_posit%><%=day%>' align='center' nowrap>&nbsp;
</td>
<input type='hidden' name='positreq<%=posit_code%><%=day%>' id='positreq<%=posit_code%><%=day%>' value=''>
<input type='hidden' name='positalloc<%=posit_code%><%=day%>' id='positalloc<%=posit_code%><%=day%>' value=''>
	
<%
}
posit_day=posit_cellno;
}
if(posit_alloc > posit_req)
classval	=	"ABOVEOPTIMAL";
if(posit_alloc < posit_req)
classval	=	"BELOWOPTIMAL";
if(posit_alloc == posit_req)
classval	=	"OPTIMAL";
if((posit_alloc == 0)&&(posit_req == 0))
classval	=	"EmptyCell";

%>
<td class='<%=classval%>' width="6%" id='posit<%=posit_code%><%=posit_day%>' align='center' nowrap><%=posit_alloc%>/<%=posit_req%></td>
<input type='hidden' name='positreq<%=posit_code%><%=posit_day%>' id='positreq<%=posit_code%><%=posit_day%>' value='<%=posit_req%>'>
<input type='hidden' name='positalloc<%=posit_code%><%=posit_day%>' id='positalloc<%=posit_code%><%=posit_day%>' value='<%=posit_alloc%>'>

<%	
posit_day++;
}
for(day=posit_day;day<DAYS;day++){
%>
<td class='EmptyCell'  width="6%" id='posit<%=posit_code%><%=day%>' align='center' nowrap>&nbsp;</td>
<input type='hidden' name='positreq<%=posit_code%><%=day%>' id='positreq<%=posit_code%><%=day%>' value=''>
<input type='hidden' name='positalloc<%=posit_code%><%=day%>' id='positalloc<%=posit_code%><%=day%>' value=''>

<%
}
if(PositionShiftTotal.size() >shift_count){
//to display the shift total
shift_record=(String[])PositionShiftTotal.get(shift_count++);

posit_code1	=	shift_record[0];	
shift_code	=shift_record[1];
shift_mnemonic=shift_record[2];
shift_desc	=	shift_record[3];
shift_req	=	Integer.parseInt(shift_record[4]==null?"0":shift_record[4]);
shift_alloc	=	Integer.parseInt(shift_record[5]==null?"0":shift_record[5]);
shift_cellno	=	Integer.parseInt(shift_record[7]);
shift_day=0;

if(prev_posit.equals(posit_code1)){
//check for same position in both 
%>
</tr>
<tr id='posit<%=posit_code1%>' style='display:none;'>
<td	class='PositionShiftTotal'  align=left colspan='2' width='16%' nowrap><%=shift_desc%> - <%=shift_mnemonic%></td>
<%
if(shift_cellno > shift_day){
//check for the first schedule date > from date
for(day=shift_day; day<shift_cellno;day++){
%>
	<td class='EmptyCell' width="6%" id='positshift<%=prev_posit%><%=shift_code%><%=day%>' align='center' nowrap>&nbsp;</td>
	<input type='hidden' name='positshiftreq<%=prev_posit%><%=shift_code%><%=day%>' id='positshiftreq<%=prev_posit%><%=shift_code%><%=day%>' value=''>
	<input type='hidden' name='positshiftalloc<%=prev_posit%><%=shift_code%><%=day%>' id='positshiftalloc<%=prev_posit%><%=shift_code%><%=day%>' value=''>
<%
}
shift_day=shift_cellno;
}

if(shift_alloc > shift_req)
classval	=	"ABOVEOPTIMAL";
if(shift_alloc < shift_req)
classval	=	"BELOWOPTIMAL";
if(shift_alloc == shift_req)
classval	=	"OPTIMAL";
if((shift_alloc == 0)&&(shift_req == 0))
classval	=	"EmptyCell";

%>
<td class='<%=classval%>' width="6%" id='positshift<%=prev_posit%><%=shift_code%><%=shift_day%>' align='center' nowrap><%=shift_alloc%>/<%=shift_req%></td>	
<input type='hidden' name='positshiftreq<%=prev_posit%><%=shift_code%><%=shift_day%>' id='positshiftreq<%=prev_posit%><%=shift_code%><%=shift_day%>' value='<%=shift_req%>'>
<input type='hidden' name='positshiftalloc<%=prev_posit%><%=shift_code%><%=shift_day%>' id='positshiftalloc<%=prev_posit%><%=shift_code%><%=shift_day%>' value='<%=shift_alloc%>'>
<%
shift_day++;
prev_shift=shift_code;

for(j=shift_count;j<PositionShiftTotal.size();j++)	{
//continue with the shift data
shift_record=(String[])PositionShiftTotal.get(j);
posit_code1	=	shift_record[0];	
shift_code	=	shift_record[1];
shift_mnemonic=shift_record[2];
shift_desc	=	shift_record[3];
shift_req	=	Integer.parseInt(shift_record[4]==null?"0":shift_record[4]);
shift_alloc	=	Integer.parseInt(shift_record[5]==null?"0":shift_record[5]);
shift_cellno	=	Integer.parseInt(shift_record[7]);
//check for next shift in the same position 
if(!shift_code.equals(prev_shift)){
//check for the same position in both
	 for(day=shift_day;day<DAYS;day++){
%>
		<td class='EmptyCell' width="6%" id='positshift<%=prev_posit%><%=prev_shift%><%=day%>' align='center' nowrap>&nbsp;</td>
		<input type='hidden' name='positshiftreq<%=prev_posit%><%=prev_shift%><%=day%>' id='positshiftreq<%=prev_posit%><%=prev_shift%><%=day%>' value=''>
		<input type='hidden' name='positshiftalloc<%=prev_posit%><%=prev_shift%><%=day%>' id='positshiftalloc<%=prev_posit%><%=prev_shift%><%=day%>' value=''>

<%	
	}
	shift_count=j;
	shift_day=0;
	if(!posit_code1.equals(prev_posit)){
//********************to display the ONCALL shift total***********************\\
		if(PositionOncallTotal.size() >oncall_count){

			oncall_record=(String[])PositionOncallTotal.get(oncall_count++);

			onposit_code	=	oncall_record[0];	
			oncall_code	=oncall_record[1];
			oncall_req	=	Integer.parseInt(oncall_record[2]==null?"0":oncall_record[2]);
			oncall_alloc	=	Integer.parseInt(oncall_record[3]==null?"0":oncall_record[3]);
			oncall_cellno	=	Integer.parseInt(oncall_record[5]);
			oncall_day=0;

			if(oncall_alloc > oncall_req)
				classval	=	"ABOVEOPTIMAL";
			if(oncall_alloc < oncall_req)
				classval	=	"BELOWOPTIMAL";
			if(oncall_alloc == oncall_req)
				classval	=	"OPTIMAL";
			if((oncall_alloc == 0)&&(oncall_req == 0))
				classval	=	"EmptyCell";

			if(prev_posit.equals(onposit_code)){ //check for same position in both 
%>
				</tr>
				<tr id='posit<%=onposit_code%>' style='display:none;'>
				<td	class='PositionShiftTotal' align='left' colspan='2' width='16%'nowrap>Oncall&nbsp;Shift
				</td>
<%	
				if(oncall_cellno > oncall_day){//check for the first schedule date > from date
					for(day=oncall_day; day<oncall_cellno;day++){
%>
						<td class='EmptyCell' width="6%" id='positoncall<%=prev_posit%><%=oncall_code%><%=day%>' align='center' nowrap>&nbsp;</td>
						<input type='hidden' name='positoncallreq<%=prev_posit%><%=oncall_code%><%=day%>' id='positoncallreq<%=prev_posit%><%=oncall_code%><%=day%>' value=''>
						<input type='hidden' name='positoncallalloc<%=prev_posit%><%=oncall_code%><%=day%>' id='positoncallalloc<%=prev_posit%><%=oncall_code%><%=day%>' value=''>
<%			
					}
					oncall_day=oncall_cellno;
				}
%>
				<td class='<%=classval%>' width="6%" id='positoncall<%=prev_posit%><%=oncall_code%><%=oncall_day%>' align='center' nowrap><%=oncall_alloc%>/<%=oncall_req%></td>	
				<input type='hidden' name='positoncallreq<%=prev_posit%><%=oncall_code%><%=oncall_day%>' id='positoncallreq<%=prev_posit%><%=oncall_code%><%=oncall_day%>' value='<%=oncall_req%>'>
				<input type='hidden' name='positoncallalloc<%=prev_posit%><%=oncall_code%><%=oncall_day%>' id='positoncallalloc<%=prev_posit%><%=oncall_code%><%=oncall_day%>' value='<%=oncall_alloc%>'>
<%
				oncall_day++;
				for(k=oncall_count;k<PositionOncallTotal.size();k++){ 
				  //continue with the shift data
					oncall_record=(String[])PositionOncallTotal.get(k);

					onposit_code	=	oncall_record[0];	
					oncall_code	=oncall_record[1];
					oncall_req	=	Integer.parseInt(oncall_record[2]==null?"0":oncall_record[2]);
					oncall_alloc	=	Integer.parseInt(oncall_record[3]==null?"0":oncall_record[3]);
					oncall_cellno	=	Integer.parseInt(oncall_record[5]);

					//check for next shift in the same position 
					if(!(onposit_code.equals(prev_posit))){
						//check for the same position in both
						for(day=oncall_day;day<DAYS;day++){
%>
							<td class='EmptyCell' width="6%" id='positoncall<%=prev_posit%><%=oncall_code%><%=day%>' align='center' nowrap>&nbsp;</td>
							<input type='hidden' name='positoncallreq<%=prev_posit%><%=oncall_code%><%=day%>' id='positoncallreq<%=prev_posit%><%=oncall_code%><%=day%>' value=''>
							<input type='hidden' name='positoncallalloc<%=prev_posit%><%=oncall_code%><%=day%>' id='positoncallalloc<%=prev_posit%><%=oncall_code%><%=day%>' value=''>
<%
						}
						oncall_count=k;
						oncall_day=0;
						break;
					}
					if(oncall_cellno > oncall_day){
						//check for the first schedule date > from date
						for(day=oncall_day; day<oncall_cellno;day++){
%>
							<td class='EmptyCell' width="6%" id='positoncall<%=prev_posit%><%=oncall_code%><%=day%>' align='center' nowrap><%=oncall_day%>&nbsp;</td>
							<input type='hidden' name='positoncallreq<%=prev_posit%><%=oncall_code%><%=day%>' id='positoncallreq<%=prev_posit%><%=oncall_code%><%=day%>' value=''>
							<input type='hidden' name='positoncallalloc<%=prev_posit%><%=oncall_code%><%=day%>' id='positoncallalloc<%=prev_posit%><%=oncall_code%><%=day%>' value=''>
<%	
						}
						oncall_day=oncall_cellno;
					}
					if(oncall_alloc > oncall_req)
						classval	=	"ABOVEOPTIMAL";
					if(oncall_alloc < oncall_req)
						classval	=	"BELOWOPTIMAL";
					if(oncall_alloc == oncall_req)
						classval	=	"OPTIMAL";
					if((oncall_alloc == 0)&&(oncall_req == 0))
						classval	=	"EmptyCell";
%>
					<td class='<%=classval%>' width="6%" id='positoncall<%=prev_posit%><%=oncall_code%><%=oncall_day%>' align='center' nowrap><%=oncall_alloc%>/<%=oncall_req%></td>	
					<input type='hidden' name='positoncallreq<%=prev_posit%><%=oncall_code%><%=oncall_day%>' id='positoncallreq<%=prev_posit%><%=oncall_code%><%=oncall_day%>' value='<%=oncall_req%>'>
					<input type='hidden' name='positoncallalloc<%=prev_posit%><%=oncall_code%><%=oncall_day%>' id='positoncallalloc<%=prev_posit%><%=oncall_code%><%=oncall_day%>' value='<%=oncall_alloc%>'>
<%
					oncall_day++;
				}
			}
			else
				oncall_count--;
		}
//**********Staff List ******************/

		if(StaffList.size() > staff_count){
			staff_record=(String[])StaffList.get(staff_count++);
			role_type2	= staff_record[0];
			posit_code2	=	staff_record[1];	
			staff_id2			=	staff_record[2];
			schedule_date2	=	staff_record[3];
			shift_code2	=staff_record[4];
			shift_mnemonic2=staff_record[5];
			staff_cellno	=	Integer.parseInt(staff_record[6]);
			staff_type2	=	staff_record[7];
			staff_workplace	=	staff_record[8];
			staff_name	=	staff_record[11];
			classval="StaffList";
			wrk_flag=false;
			key	=	role_type2+staff_id2;

			if(Staff_Leave_Dtl.containsKey(key))
				StaffLeaveDays	=	(ArrayList)Staff_Leave_Dtl.get(key);
			else
				StaffLeaveDays	=	new ArrayList();

			if((!staff_workplace.equals(workplace_code))&&(!wrk_flag)){
				classval="StaffOtherWP";
				wrk_flag=true;
			}
			if(prev_posit.equals(posit_code2)){
				//check for same position in both 
%>
				</tr>
				<tr id='posit<%=posit_code2%>' style='display:none;'>
				<td	class='StaffList' align=left colspan='2' width='16%' nowrap><%=staff_name%></td>
				<input type='hidden' name='staffid<%=posit_code2%>' id='staffid<%=posit_code2%>' value='<%=staff_id2%>'>
				<input type='hidden' name='roletype<%=posit_code2%>' id='roletype<%=posit_code2%>' value='<%=staff_id2%>'>

<%
				if((staff_cellno-1) > staff_day){
					//check for the first schedule date > from date
					for(day=staff_day; day<staff_cellno;day++){
						if(StaffLeaveDays.contains(String.valueOf(day))){
								classval = "LeaveStaff";
								prev_mnemonic2="";
								leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
						}
						else
						{
								classval	=	"StaffList";
								leaveIcon	=	prev_mnemonic2;
								if(leaveIcon=="")
								leaveIcon ="&nbsp;" ;
						}
%>
						<td class='<%=classval%>' width="6%" onclick='showPopup("<%=facility_id%>", "<%=workplace_code%>","<%=posit_code2%>","<%=role_type2%>","<%=staff_id2%>", "<%=from_date%>","","","<%=productive_flag%>","<%=day%>", "<%=staff_type2%>", this);' id='staff<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' align='center' nowrap><%=leaveIcon%></td>
						<input type='hidden' name='staffshift<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' id='staffshift<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' value=''>
						<input type='hidden' name='staffshiftcode<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' id='staffshiftcode<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' value=''>
<%
					}
					staff_day=staff_cellno;
				}
				if(staff_workplace.equals(workplace_code)){	
					if(prev_role.equals(role_type2)&&prev_staff.equals(staff_id2)&&prev_sched_date.equals(schedule_date2)){
						if(prev_shift2.equals("")){
							prev_shift2		=	shift_code2;
							prev_mnemonic2	=	shift_mnemonic2;
						}
						else{
							prev_shift2=	prev_shift2+"|"+shift_code2;
							prev_mnemonic2=	prev_mnemonic2+"|"+shift_mnemonic2;
						}
					}
					else{
						prev_shift2=shift_code2;
						prev_mnemonic2=shift_mnemonic2;
						prev_sched_date	= schedule_date2;
					}
				}
				prev_staff	=	staff_id2;
				prev_role	=	role_type2;
				prev_staff_type	=	staff_type2;
				prev_cell = staff_cellno;
				prev_workplace=staff_workplace;
				prev_sched_date	= schedule_date2;

				for(k=staff_count;k<StaffList.size();k++)	{
				//continue with the staff data

					staff_record=(String[])StaffList.get(k);
					role_type2	= staff_record[0];
					posit_code2	=	staff_record[1];	
					staff_id2			=	staff_record[2];
					schedule_date2	=	staff_record[3];
					shift_code2	=staff_record[4];
					shift_mnemonic2=staff_record[5];
					staff_cellno	=	Integer.parseInt(staff_record[6]);
					staff_type2	=	staff_record[7];
					staff_workplace	=	staff_record[8];
					staff_name	=	staff_record[11];

					if((!staff_workplace.equals(workplace_code))&&(!wrk_flag)){
						classval="StaffOtherWP";
						wrk_flag=true;
					}

					//check for next staff in the same position 
					if((!staff_id2.equals(prev_staff))||(!role_type2.equals(prev_role))){
						//check for the same position in both
						if(prev_cell > staff_day){
							for(day=staff_day; day<(prev_cell);day++)	{
								if(StaffLeaveDays.contains(String.valueOf(day))){
									classval = "LeaveStaff";
									prev_mnemonic2="";
									leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
								}
								else
								{
									classval	=	"StaffList";
									leaveIcon	=	prev_mnemonic2;
									if(leaveIcon=="")
									leaveIcon ="&nbsp;" ;
								}
%>
								<td class='<%=classval%>' width="6%" onclick='showPopup("<%=facility_id%>", "<%=workplace_code%>","<%=prev_posit%>","<%=prev_role%>","<%=prev_staff%>", "<%=from_date%>", "","", "","<%=day%>","<%=prev_staff_type%>", this);' id='staff<%=prev_posit%><%=role_type2%><%=staff_id2%><%=day%>' align='center' nowrap><%=leaveIcon%></td>
								<input type='hidden' name='staffshift<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' id='staffshift<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' value=''>
								<input type='hidden' name='staffshiftcode<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' id='staffshiftcode<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' value=''>

<%
							}
							staff_day=prev_cell;
						}
						for(day=staff_day;day<DAYS;day++){
							if(StaffLeaveDays.contains(String.valueOf(day))){
									classval = "LeaveStaff";
									prev_mnemonic2="";
									leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
							}
							else{
								if((!prev_workplace.equals(workplace_code))&&(!wrk_flag)){
									classval="StaffOtherWP";
									wrk_flag=true;
								}
								leaveIcon=prev_mnemonic2;
								if(leaveIcon=="")
								leaveIcon ="&nbsp;" ;
							}

							if(prev_mnemonic2.equals(""))
								prev_mnemonic2="&nbsp;";
%>
							<td class='<%=classval%>' width="6%" onclick='showPopup("<%=facility_id%>", "<%=workplace_code%>","<%=prev_posit%>","<%=prev_role%>","<%=prev_staff%>", "<%=from_date%>", "<%=prev_shift2%>", "<%=prev_mnemonic2%>", "<%=productive_flag%>","<%=day%>","<%=prev_staff_type%>", this);' id='staff<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' align='center' nowrap><%=leaveIcon%></td>
							<input type='hidden' name='staffshift<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' id='staffshift<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' value='<%=prev_mnemonic2%>'>
							<input type='hidden' name='staffshiftcode<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' id='staffshiftcode<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' value='<%=prev_shift2%>'>
<%
							prev_shift2="";
							prev_mnemonic2="&nbsp";
							classval="StaffList";
						}
						wrk_flag=false;
						staff_day=day;
						staff_count=k;
						if(!posit_code2.equals(prev_posit)){
							flag=true;
							prev_mnemonic2="";
							prev_shift2="";
							break ;
						}
						prev_staff	=	staff_id2;
						prev_role	=	role_type2;
						prev_staff_type	=	staff_type2;
						prev_sched_date	= schedule_date2;
						prev_cell = staff_cellno;
						prev_workplace	=	staff_workplace;
						prev_mnemonic2="";
						prev_shift2="";
						staff_day=0;
						key=role_type2+staff_id2;

						if(StaffLeaveDays.contains(String.valueOf(day))){
							classval = "LeaveStaff";
							prev_mnemonic2="";
							leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
						}
						else
						{
							classval	=	"StaffList";
							leaveIcon	=	prev_mnemonic2;
							if(leaveIcon=="")
							leaveIcon ="&nbsp;" ;
						}

						if(Staff_Leave_Dtl.containsKey(key))
							StaffLeaveDays	=	(ArrayList)Staff_Leave_Dtl.get(key);
						else
							StaffLeaveDays	=	new ArrayList();
%>
						</tr>
						<tr id='posit<%=posit_code2%>' style='display:none;'>
							<td	class='StaffList' align=left colspan='2' width='16%' nowrap><%=staff_name%></td>
<%
					}	
					if(prev_cell > staff_day){
						for(day=staff_day; day<prev_cell;day++){									
							if(StaffLeaveDays.contains(String.valueOf(day))){
								classval = "LeaveStaff";
								prev_mnemonic2="";
								leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
							}
							else
							{
								classval	=	"StaffList";
								leaveIcon	=	prev_mnemonic2;
								if(leaveIcon=="")
								leaveIcon ="&nbsp;" ;
							}
%>
							<td class='StaffList' width="6%" onclick='showPopup("<%=facility_id%>", "<%=workplace_code%>","<%=posit_code2%>","<%=role_type2%>","<%=staff_id2%>", "<%=from_date%>", "","", "<%=productive_flag%>","<%=day%>","<%=staff_type2%>",this);' id='staff<%=prev_posit%><%=role_type2%><%=staff_id2%><%=day%>' align='center' nowrap>&nbsp;</td>
							<input type='hidden' name='staffshift<%=prev_posit%><%=role_type2%><%=staff_id2%><%=day%>' id='staffshift<%=prev_posit%><%=role_type2%><%=staff_id2%><%=day%>' value=''>
							<input type='hidden' name='staffshiftcode<%=prev_posit%><%=role_type2%><%=staff_id2%><%=day%>' id='staffshiftcode<%=prev_posit%><%=role_type2%><%=staff_id2%><%=day%>' value=''>
<%
						}
						staff_day=prev_cell;
						staff_day=prev_cell;
						classval	=	"StaffList";
						wrk_flag=false;
					}
					if(prev_role.equals(role_type2)&&prev_staff.equals(staff_id2)&&prev_sched_date.equals(schedule_date2)){
						if(staff_workplace.equals(workplace_code)){
							if(prev_shift2.equals("")){
								prev_shift2		=	shift_code2;
								prev_mnemonic2	=	shift_mnemonic2;
							}
							else{
								prev_shift2=	prev_shift2+"|"+shift_code2;
								prev_mnemonic2=	prev_mnemonic2+"|"+shift_mnemonic2;
							}
						}
						if((!prev_workplace.equals(workplace_code))&&(!wrk_flag)){
										classval="StaffOtherWP";
										wrk_flag=true;
						}
					}
					else{

						if(prev_mnemonic2.equals(""))
							prev_mnemonic2="&nbsp;";

						 if((!prev_workplace.equals(workplace_code))&&(!wrk_flag)) {
								classval="StaffOtherWP";
								wrk_flag=true;
						 }
%>
						<td class='<%=classval%>' width="6%" onclick='showPopup("<%=facility_id%>", "<%=workplace_code%>","<%=prev_posit%>","<%=role_type2%>","<%=staff_id2%>", "<%=from_date%>", "<%=prev_shift2%>", "<%=prev_mnemonic2%>", "<%=productive_flag%>","<%=staff_day%>","<%=staff_type2%>",this);' id='staff<%=prev_posit%><%=role_type2%><%=staff_id2%><%=staff_day%>' align='center' nowrap><%=prev_mnemonic2%></td>
						<input type='hidden' name='staffshift<%=prev_posit%><%=role_type2%><%=staff_id2%><%=staff_day%>' id='staffshift<%=prev_posit%><%=role_type2%><%=staff_id2%><%=staff_day%>' value='<%=prev_mnemonic2%>'>
						<input type='hidden' name='staffshiftcode<%=prev_posit%><%=role_type2%><%=staff_id2%><%=staff_day%>' id='staffshiftcode<%=prev_posit%><%=role_type2%><%=staff_id2%><%=staff_day%>' value='<%=prev_shift2%>'>
<%	
						if(staff_workplace.equals(workplace_code)){
							prev_shift2		=	shift_code2;
							prev_mnemonic2	=	shift_mnemonic2;
							prev_sched_date	= schedule_date2;
						}
						else{
							prev_shift2		=	"";
							prev_mnemonic2	=	"";
						}	
						prev_sched_date	= schedule_date2;
						classval="StaffList";
						wrk_flag=false;
						staff_day++;
					}
					prev_staff=staff_id2;
					prev_role= role_type2;
					prev_sched_date	=	schedule_date2;
					prev_workplace=staff_workplace;
					prev_cell = staff_cellno;
				}

				staff_count=k;
				for(day=staff_day; day<DAYS;day++){

					if(StaffLeaveDays.contains(String.valueOf(day))){
						classval = "LeaveStaff";
						prev_mnemonic2="";
						leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
					}
					else{
						if(wrk_flag){
							classval="StaffOtherWP";
							wrk_flag=false;
						}
						else
							classval	=	"StaffList";

						leaveIcon=prev_mnemonic2;
						if(leaveIcon=="")
						leaveIcon ="&nbsp;" ;
					}

					if(prev_mnemonic2.equals(""))
						prev_mnemonic2="&nbsp;";
%>
					<td class='<%=classval%>' width="6%" onclick='showPopup("<%=facility_id%>", "<%=workplace_code%>","<%=prev_posit%>","<%=prev_role%>","<%=prev_staff%>", "<%=from_date%>",  "<%=prev_shift2%>", "<%=prev_mnemonic2%>", "<%=productive_flag%>","<%=day%>","<%=prev_staff_type%>",this);' id='staff<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' align='center' nowrap><%=leaveIcon%></td>
					<input type='hidden' name='staffshift<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' id='staffshift<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' value='<%=prev_mnemonic2%>'>
					<input type='hidden' name='staffshiftcode<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' id='staffshiftcode<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' value='<%=prev_shift2%>'>
<%
					prev_mnemonic2	=	"&nbsp;";
					prev_shift2	=	"";
					classval="StaffList";
					wrk_flag=false;
				}
			}
			else
					staff_count--;
		}
/***************Staff List end *****************************/							
	}
	prev_shift=shift_code;
	shift_day=0;
%>
	</tr>
	<tr id='posit<%=posit_code1%>' style='display:none;'>
	<td	class='PositionShiftTotal' align=left colspan='2' width='16%' nowrap><%=shift_desc%> - <%=shift_mnemonic%></td>
<%
}	
if(shift_cellno > shift_day){
	for(day=shift_day; day<shift_cellno;day++){
%>
		<td class='EmptyCell' width="6%" id='positshift<%=prev_posit%><%=prev_shift%><%=day%>' align='center' nowrap>&nbsp;</td>
		<input type='hidden' name='positshiftreq<%=prev_posit%><%=prev_shift%><%=day%>' id='positshiftreq<%=prev_posit%><%=prev_shift%><%=day%>' value=''>
		<input type='hidden' name='positshiftalloc<%=prev_posit%><%=prev_shift%><%=day%>' id='positshiftalloc<%=prev_posit%><%=prev_shift%><%=day%>' value=''>
<%
	}
	shift_day=shift_cellno;
}
if(shift_alloc > shift_req)
		classval	=	"ABOVEOPTIMAL";
if(shift_alloc < shift_req)
		classval	=	"BELOWOPTIMAL";
if(shift_alloc == shift_req)
		classval	=	"OPTIMAL";
if((shift_alloc == 0)&&(shift_req == 0))
		classval	=	"EmptyCell";

%>
<td class='<%=classval%>' width="6%" id='positshift<%=prev_posit%><%=shift_code%><%=shift_day%>' align='center' nowrap><%=shift_alloc%>/<%=shift_req%></td> 	
<input type='hidden' name='positshiftreq<%=prev_posit%><%=shift_code%><%=shift_day%>' id='positshiftreq<%=prev_posit%><%=shift_code%><%=shift_day%>' value='<%=shift_req%>'>
<input type='hidden' name='positshiftalloc<%=prev_posit%><%=shift_code%><%=shift_day%>' id='positshiftalloc<%=prev_posit%><%=shift_code%><%=shift_day%>' value='<%=shift_alloc%>'>
<%
shift_day++;
}
shift_count=j;
//to complete the prevous shift cells
if(shift_day>0){
for(day=shift_day;day<DAYS;day++){
%>
	<td class='EmptyCell' width="6%" id='positshift<%=prev_posit%><%=prev_shift%><%=day%>' align='center' nowrap>&nbsp;</td>
	<input type='hidden' name='positshiftreq<%=prev_posit%><%=prev_shift%><%=day%>' id='positshiftreq<%=prev_posit%><%=prev_shift%><%=day%>' value=''>
	<input type='hidden' name='positshiftalloc<%=prev_posit%><%=prev_shift%><%=day%>' id='positshiftalloc<%=prev_posit%><%=prev_shift%><%=day%>' value=''>
<%
}
}
}
}
//********************to display the ONCALL shift total***********************\\
if(PositionOncallTotal.size() >oncall_count){

oncall_record=(String[])PositionOncallTotal.get(oncall_count++);
onposit_code	=	oncall_record[0];	
oncall_code	=oncall_record[1];
oncall_req	=	Integer.parseInt(oncall_record[2]==null?"0":oncall_record[2]);
oncall_alloc	=	Integer.parseInt(oncall_record[3]==null?"0":oncall_record[3]);
oncall_cellno	=	Integer.parseInt(oncall_record[5]);
oncall_day=0;

if(oncall_alloc > oncall_req)
classval	=	"ABOVEOPTIMAL";
if(oncall_alloc < oncall_req)
classval	=	"BELOWOPTIMAL";
if(oncall_alloc == oncall_req)
classval	=	"OPTIMAL";
if((oncall_alloc == 0)&&(oncall_req == 0))
classval	=	"EmptyCell";

if(prev_posit.equals(onposit_code)){
//check for same position in both 
%>
</tr>
<tr id='posit<%=onposit_code%>' style='display:none;'>
<td	class='PositionShiftTotal' align='left' colspan='2' width='16%'nowrap><fmt:message key="eRS.Oncall.label" bundle="${rs_labels}"/>&nbsp;<fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></td>
<%
if(oncall_cellno > oncall_day){
	//check for the first schedule date > from date
	 for(day=oncall_day; day<oncall_cellno;day++){
%>
		<td class='EmptyCell' width="6%" id='positoncall<%=prev_posit%><%=oncall_code%><%=day%>' align='center' nowrap>&nbsp;
		</td>	<input type='hidden' name='positoncallreq<%=prev_posit%><%=oncall_code%><%=day%>' id='positoncallreq<%=prev_posit%><%=oncall_code%><%=day%>' value=''>
		<input type='hidden' name='positoncallalloc<%=prev_posit%><%=oncall_code%><%=day%>' id='positoncallalloc<%=prev_posit%><%=oncall_code%><%=day%>' value=''>
<%	
	}
	oncall_day=oncall_cellno;
}
%>
<td class='<%=classval%>' width="6%" id='positoncall<%=prev_posit%><%=oncall_code%><%=oncall_day%>' align='center' nowrap><%=oncall_alloc%>/<%=oncall_req%></td>	
<input type='hidden' name='positoncallreq<%=prev_posit%><%=oncall_code%><%=oncall_day%>' id='positoncallreq<%=prev_posit%><%=oncall_code%><%=oncall_day%>' value='<%=oncall_req%>'>
<input type='hidden' name='positoncallalloc<%=prev_posit%><%=oncall_code%><%=oncall_day%>' id='positoncallalloc<%=prev_posit%><%=oncall_code%><%=oncall_day%>' value='<%=oncall_alloc%>'>
<%
oncall_day++;

for(k=oncall_count;k<PositionOncallTotal.size();k++){
	//continue with the shift data
	oncall_record=(String[])PositionOncallTotal.get(k);

	onposit_code	=	oncall_record[0];	
	oncall_code	=oncall_record[1];
	oncall_req	=	Integer.parseInt(oncall_record[2]==null?"0":oncall_record[2]);
	oncall_alloc	=	Integer.parseInt(oncall_record[3]==null?"0":oncall_record[3]);
	oncall_cellno	=	Integer.parseInt(oncall_record[5]);
	//check for next shift in the same position 
	if(!(onposit_code.equals(prev_posit))){
		//check for the same position in both
		for(day=oncall_day;day<DAYS;day++){
%>
			<td class='EmptyCell' width="6%" id='positoncall<%=prev_posit%><%=oncall_code%><%=day%>' align='center' nowrap>&nbsp;</td>
			<input type='hidden' name='positoncallreq<%=prev_posit%><%=oncall_code%><%=day%>' id='positoncallreq<%=prev_posit%><%=oncall_code%><%=day%>' value=''>
			<input type='hidden' name='positoncallalloc<%=prev_posit%><%=oncall_code%><%=day%>' id='positoncallalloc<%=prev_posit%><%=oncall_code%><%=day%>' value=''>
<%
		}
		oncall_count=k;
		oncall_day=0;
		break;
	}
	if(oncall_cellno > oncall_day){
		//check for the first schedule date > from date
		for(day=oncall_day; day<oncall_cellno;day++){
%>
			<td class='EmptyCell' width="6%" id='positoncall<%=prev_posit%><%=oncall_code%><%=day%>' align='center' nowrap><%=oncall_day%>&nbsp;</td>
			<input type='hidden' name='positoncallreq<%=prev_posit%><%=oncall_code%><%=day%>' id='positoncallreq<%=prev_posit%><%=oncall_code%><%=day%>' value=''>
			<input type='hidden' name='positoncallalloc<%=prev_posit%><%=oncall_code%><%=day%>' id='positoncallalloc<%=prev_posit%><%=oncall_code%><%=day%>' value=''>
<%
		}
		oncall_day=oncall_cellno;
	}
	if(oncall_alloc > oncall_req)
		classval	=	"ABOVEOPTIMAL";
	if(oncall_alloc < oncall_req)
		classval	=	"BELOWOPTIMAL";
	if(oncall_alloc == oncall_req)
		classval	=	"OPTIMAL";
	if((oncall_alloc == 0)&&(oncall_req == 0))
		classval	=	"EmptyCell";
%>
	<td class='<%=classval%>' width="6%" id='positoncall<%=prev_posit%><%=oncall_code%><%=oncall_day%>' align='center' nowrap><%=oncall_alloc%>/<%=oncall_req%></td>	
	<input type='hidden' name='positoncallreq<%=prev_posit%><%=oncall_code%><%=oncall_day%>' id='positoncallreq<%=prev_posit%><%=oncall_code%><%=oncall_day%>' value='<%=oncall_req%>'>
	<input type='hidden' name='positoncallalloc<%=prev_posit%><%=oncall_code%><%=oncall_day%>' id='positoncallalloc<%=prev_posit%><%=oncall_code%><%=oncall_day%>' value='<%=oncall_alloc%>'>
<%
	oncall_day++;
}
}
else
oncall_count--;
}
if(oncall_day >0){
for(day=oncall_day; day<DAYS;day++){
%>
<td class='EmptyCell' width="6%" id='positoncall<%=prev_posit%><%=oncall_code%><%=day%>' align='center' nowrap>&nbsp;</td>
<input type='hidden' name='positoncallreq<%=prev_posit%><%=oncall_code%><%=day%>' id='positoncallreq<%=prev_posit%><%=oncall_code%><%=day%>' value=''>
<input type='hidden' name='positoncallalloc<%=prev_posit%><%=oncall_code%><%=day%>' id='positoncallalloc<%=prev_posit%><%=oncall_code%><%=day%>' value=''>
<%
}
}
//**************************Staff List ***************************/

if(StaffList.size() > staff_count){
staff_record=(String[])StaffList.get(staff_count++);

role_type2	= staff_record[0];
posit_code2	=	staff_record[1];	
staff_id2			=	staff_record[2];
schedule_date2	=	staff_record[3];
shift_code2	=staff_record[4];
shift_mnemonic2=staff_record[5];
staff_cellno	=	Integer.parseInt(staff_record[6]);
staff_type2	=	staff_record[7];
staff_workplace	=	staff_record[8];
staff_name	=	staff_record[11];
classval="StaffList";
wrk_flag=false;
key	=	role_type2+staff_id2;

if(Staff_Leave_Dtl.containsKey(key))
StaffLeaveDays	=	(ArrayList)Staff_Leave_Dtl.get(key);
else
StaffLeaveDays	=	new ArrayList();

if((!staff_workplace.equals(workplace_code))&&(!wrk_flag)){
classval="StaffOtherWP";
wrk_flag=true;
}

staff_day=0;
prev_cell=0;

if(prev_posit.equals(posit_code2)){ 
//check for same position in both 
%>
</tr>
<tr id='posit<%=posit_code2%>' style='display:none;'>
<td	class='StaffList' align=left colspan='2' width='16%'  nowrap><%=staff_name%></td>
<%
if(staff_cellno> staff_day){
	/*check for the first schedule date > from date*/
	for(day=staff_day; day<staff_cellno;day++){
		if(StaffLeaveDays.contains(String.valueOf(day))){
			classval = "LeaveStaff";
			prev_mnemonic2="";
			leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
		}
		else
		{
			classval	=	"StaffList";
			leaveIcon=prev_mnemonic2;
			if(leaveIcon=="")
			leaveIcon ="&nbsp;" ;
		}
%>
		<td class='<%=classval%>' width="6%" onclick='showPopup("<%=facility_id%>", "<%=workplace_code%>","<%=posit_code2%>","<%=role_type2%>","<%=staff_id2%>", "<%=from_date%>", "","", "<%=productive_flag%>","<%=day%>","<%=staff_type2%>",this);' id='staff<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' 
		align='center' nowrap><%=leaveIcon%></td>
		<input type='hidden' name='staffshift<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' id='staffshift<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' value=''>
		<input type='hidden' name='staffshiftcode<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' id='staffshiftcode<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' value=''>
<%
	}
	staff_day=staff_cellno;
}
if(staff_workplace.equals(workplace_code)){
	if(prev_role.equals(role_type2)&&prev_staff.equals(staff_id2)&&prev_sched_date.equals(schedule_date2)){
		if(prev_shift2.equals("")){
			prev_shift2		=	shift_code2;
			prev_mnemonic2	=	shift_mnemonic2;
		}
		else{
			prev_shift2=	prev_shift2+"|"+shift_code2;
			prev_mnemonic2=	prev_mnemonic2+"|"+shift_mnemonic2;
			//System.err.println("prev_mnemonic2---->"+prev_mnemonic2);
		}
	}
	else{					
		prev_shift2		=	shift_code2;
		prev_mnemonic2	=	shift_mnemonic2;
		prev_sched_date	= schedule_date2;
	}
}
prev_staff	=	staff_id2;
prev_role	=	role_type2;
prev_staff_type= staff_type2;
prev_cell= staff_cellno;
prev_workplace=staff_workplace;
prev_sched_date	= schedule_date2;

for(k=staff_count;k<StaffList.size();k++)	{ 
	//continue with the shift data

	staff_record=(String[])StaffList.get(k);
	role_type2	= staff_record[0];
	posit_code2	=	staff_record[1];	
	staff_id2			=	staff_record[2];
	schedule_date2	=	staff_record[3];
	shift_code2	=staff_record[4];
	shift_mnemonic2=staff_record[5];
	staff_cellno	=	Integer.parseInt(staff_record[6]);
	staff_type2	=	staff_record[7];
	staff_workplace	=	staff_record[8];
	staff_name	=	staff_record[11];

	//check for next staff in the same position 
	if((!staff_id2.equals(prev_staff))||(!role_type2.equals(prev_role))){
	//to complete the prevous staff cells
		if(prev_cell > staff_day){

			for(day=staff_day; day<prev_cell;day++){
				if(StaffLeaveDays.contains(String.valueOf(day))){
					classval = "LeaveStaff";
					prev_mnemonic2="&nbsp;";
					leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
				}
				else
				{
					classval	=	"StaffList";
					leaveIcon	=	prev_mnemonic2;
					if(leaveIcon=="")
					leaveIcon ="&nbsp;" ;
				}
%>
				<td class='<%=classval%>' width="6%" onclick='showPopup("<%=facility_id%>", "<%=workplace_code%>","<%=posit_code2%>","<%=prev_role%>","<%=prev_staff%>", "<%=from_date%>", "", "", "","<%=day%>","<%=prev_staff_type%>",this);' id='staff<%=posit_code2%><%=prev_role%><%=prev_staff%><%=day%>' align='center' nowrap><%=leaveIcon%></td>
				<input type='hidden' name='staffshift<%=posit_code2%><%=prev_role%><%=prev_staff%><%=day%>' id='staffshift<%=posit_code2%><%=prev_role%><%=prev_staff%><%=day%>' value=''>
				<input type='hidden' name='staffshiftcode<%=posit_code2%><%=prev_role%><%=prev_staff%><%=day%>' id='staffshiftcode<%=posit_code2%><%=prev_role%><%=prev_staff%><%=day%>' value=''>
<%
			}
			staff_day=prev_cell;
		}
		for(day=staff_day;day<DAYS;day++){
			if(StaffLeaveDays.contains(String.valueOf(day))){
				classval = "LeaveStaff";
				prev_mnemonic2="";
				leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
			}
			else{
				if((!prev_workplace.equals(workplace_code))&&(!wrk_flag)){
					classval="StaffOtherWP";
					wrk_flag=true;
				}
				leaveIcon=prev_mnemonic2;
					if(leaveIcon=="")
					 leaveIcon ="&nbsp;" ;
			}

			if(prev_mnemonic2.equals(""))
				prev_mnemonic2="&nbsp;";
%>
			<td class='<%=classval%>' width="6%" onclick='showPopup("<%=facility_id%>", "<%=workplace_code%>","<%=prev_posit%>","<%=prev_role%>","<%=prev_staff%>", "<%=from_date%>", "<%=prev_shift2%>", "<%=prev_mnemonic2%>", "<%=productive_flag%>","<%=day%>","<%=prev_staff_type%>",this);' id='staff<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' align='center' nowrap><%=leaveIcon%></td>
			<input type='hidden' name='staffshift<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' id='staffshift<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' value='<%=prev_mnemonic2%>'>
			<input type='hidden' name='staffshiftcode<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' id='staffshiftcode<%=prev_posit%><%=prev_role%><%=prev_staff%><%=day%>' value='<%=prev_shift2%>'>
<%
			prev_shift2="";
			prev_mnemonic2="&nbsp;";
			classval="StaffList";
		}
		wrk_flag=false;
		prev_staff	=	staff_id2;
		prev_role	=	role_type2;
		prev_staff_type	=	staff_type2;
		prev_sched_date	=	schedule_date2;
		prev_cell=staff_cellno;
		prev_workplace=staff_workplace;
		staff_day=0;
		key	=	role_type2+staff_id2;

		if(Staff_Leave_Dtl.containsKey(key))
			StaffLeaveDays	=	(ArrayList)Staff_Leave_Dtl.get(key);
		else
			StaffLeaveDays	=	new ArrayList();

		staff_count=k;
		//check for the same position in both
		if(!posit_code2.equals(prev_posit))	{
			staff_day=14;
			break ;										
		}
%>
		</tr>
		<tr id='posit<%=posit_code2%>' style='display:none;'>
			<td	class='StaffList' align=left colspan='2' width='16%' nowrap><%=staff_name%></td> 
<%
	}	
	if(prev_cell > staff_day){
		for(day=staff_day; day<prev_cell;day++){
			if(StaffLeaveDays.contains(String.valueOf(day))){
				classval = "LeaveStaff";
				prev_mnemonic2="";
				leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
			}
			else{
				if(wrk_flag){
					classval="StaffOtherWP";
					wrk_flag=false;
					leaveIcon=prev_mnemonic2;
					if(leaveIcon=="")
					leaveIcon ="&nbsp;" ;
				}
				else
				{
					classval	=	"StaffList";
					leaveIcon=prev_mnemonic2;
					if(leaveIcon=="")
					leaveIcon ="&nbsp;" ;
				}
			}
%>
			<td class='<%=classval%>' width="6%" onclick='showPopup("<%=facility_id%>", "<%=workplace_code%>","<%=posit_code2%>","<%=role_type2%>","<%=staff_id2%>", "<%=from_date%>", "", "", "","<%=day%>","<%=staff_type2%>",this);' id='staff<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' align='center' nowrap><%=leaveIcon%></td>
			<input type='hidden' name='staffshift<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' id='staffshift<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' value=''>
			<input type='hidden' name ='staffshiftcode<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' value=''>
<%	
		}
		staff_day=prev_cell;
		classval	=	"StaffList";
		wrk_flag=false;
	}
	if(prev_role.equals(role_type2) && prev_staff.equals(staff_id2) && prev_sched_date.equals(schedule_date2)){
		if(staff_workplace.equals(workplace_code)){
			if(prev_shift2.equals("")){
				prev_shift2		=	shift_code2;
				prev_mnemonic2	=	shift_mnemonic2;
			}
			else{
					prev_shift2=	prev_shift2+"|"+shift_code2;
					prev_mnemonic2=	prev_mnemonic2+"|"+shift_mnemonic2;
			}
		}
		if((!prev_workplace.equals(workplace_code))&&(!wrk_flag)){
			classval="StaffOtherWP";
				wrk_flag=true;
		}
	}
	else{
		if(prev_mnemonic2.equals(""))
			prev_mnemonic2="&nbsp;";
		if((!prev_workplace.equals(workplace_code))&&(!wrk_flag)){
			classval="StaffOtherWP";
			wrk_flag=true;
		}
%>
		<td class='<%=classval%>' width="6%" onclick='showPopup("<%=facility_id%>", "<%=workplace_code%>","<%=posit_code2%>","<%=role_type2%>","<%=staff_id2%>", "<%=from_date%>", "<%=prev_shift2%>", "<%=prev_mnemonic2%>", "<%=productive_flag%>","<%=staff_day%>","<%=prev_staff_type%>",this);' id='staff<%=posit_code2%><%=role_type2%><%=staff_id2%><%=staff_day%>' align='center' nowrap><%=prev_mnemonic2%></td>
		<input type='hidden' name='staffshift<%=posit_code2%><%=role_type2%><%=prev_staff%><%=staff_day%>' id='staffshift<%=posit_code2%><%=role_type2%><%=prev_staff%><%=staff_day%>' value='<%=prev_mnemonic2%>'>
		<input type='hidden' name='staffshiftcode<%=posit_code2%><%=role_type2%><%=prev_staff%><%=staff_day%>' id='staffshiftcode<%=posit_code2%><%=role_type2%><%=prev_staff%><%=staff_day%>' value='<%=prev_shift2%>'>
<%		
		if(staff_workplace.equals(workplace_code)){
			prev_shift2		=	shift_code2;
			prev_mnemonic2	=	shift_mnemonic2;
			prev_sched_date	= schedule_date2;
		}
		else{
			prev_shift2		=	"";
			prev_mnemonic2	=	"";
		}
		prev_sched_date	=	schedule_date2;
		classval="StaffList";
		wrk_flag=false;
		staff_day++;
	}
	prev_staff	=	staff_id2;
	prev_role	=	role_type2;
	prev_staff_type	=	staff_type2;
	prev_sched_date	=	schedule_date2;
	prev_cell=staff_cellno;
	prev_workplace=staff_workplace;
}
if((prev_cell > staff_day)&&(staff_day>0)){
	for(day=staff_day; day<prev_cell;day++){
		if(StaffLeaveDays.contains(String.valueOf(day))){
			classval = "LeaveStaff";
			prev_mnemonic2="";
			leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
		}
		else
		{
			classval	=	"StaffList";
		}
%>
		<td class='<%=classval%>' width="6%" onclick='showPopup("<%=facility_id%>", "<%=workplace_code%>","<%=posit_code2%>","<%=role_type2%>","<%=staff_id2%>", "<%=from_date%>", "", "", "","<%=day%>","<%=staff_type2%>",this);' id='staff<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' align='center' nowrap><%=leaveIcon%></td>
		<input type='hidden' name='staffshift<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' id='staffshift<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' value=''>
		<input type='hidden' name='staffshiftcode<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' id='staffshiftcode<%=posit_code2%><%=role_type2%><%=staff_id2%><%=day%>' value=''>
<%	
	}
	staff_day=prev_cell;
}
if(staff_day >=0)
	for(day=staff_day;day<DAYS;day++){

		if(StaffLeaveDays.contains(String.valueOf(day))){
			classval = "LeaveStaff";
			prev_mnemonic2="";
			leaveIcon="<div align='center'><img src='../../eRS/images/leave_icon.gif'></img></div>";
		}
		else{
			if((!prev_workplace.equals(workplace_code))&&(!wrk_flag)){
				classval="StaffOtherWP";
				wrk_flag=true;
			}
			leaveIcon=prev_mnemonic2;
		}

		if(prev_mnemonic2.equals(""))
			prev_mnemonic2="&nbsp;";
%>
		<td class='<%=classval%>' width="6%" onclick='showPopup("<%=facility_id%>", "<%=workplace_code%>","<%=posit_code2%>","<%=prev_role%>","<%=prev_staff%>", "<%=from_date%>", "<%=prev_shift2%>", "<%=prev_mnemonic2%>", "<%=productive_flag%>","<%=day%>","<%=prev_staff_type%>",this);' id='staff<%=posit_code2%><%=prev_role%><%=prev_staff%><%=day%>' align='center' nowrap><%=leaveIcon%></td>
		<input type='hidden' name='staffshift<%=posit_code2%><%=prev_role%><%=prev_staff%><%=day%>' id='staffshift<%=posit_code2%><%=prev_role%><%=prev_staff%><%=day%>' value='<%=prev_mnemonic2%>'>
		<input type='hidden' name='staffshiftcode<%=posit_code2%><%=prev_role%><%=prev_staff%><%=day%>' id='staffshiftcode<%=posit_code2%><%=prev_role%><%=prev_staff%><%=day%>' value='<%=prev_shift2%>'>
<%
		prev_shift2="";
		prev_mnemonic2="&nbsp;";
		classval	=	"StaffList";
	}
}
}
}
/***************Staff List end *****************************/		
%>
</tr>
<!-- /*********************/ -->
<div id="manage_menu" onmouseover="over()" onMouseout="out()" onclick='showWindow();'>
<div id='alloc' class="manage_menuitem" value='A'><fmt:message key="eRS.Allocate.label" bundle="${rs_labels}"/></div>
<div id='change' class="manage_menuitem" value='CH'><fmt:message key="Common.change.label" bundle="${common_labels}"/></div>
<div id='swap' class="manage_menuitem" value='S'><fmt:message key="eRS.Swap.label" bundle="${rs_labels}"/></div>
<div id='transfer' class="manage_menuitem" value='T'><fmt:message key="Common.Transfer.label" bundle="${common_labels}"/></div>
<div id='ot' class="manage_menuitem" value='O'><fmt:message key="eRS.Over.label" bundle="${rs_labels}"/>&nbsp;<fmt:message key="Common.time.label" bundle="${common_labels}"/></div>
<div id='leave' class="manage_menuitem" value='L'><fmt:message key="Common.Leave.label" bundle="${common_labels}"/></div>
<div id='cancel' class="manage_menuitem" value='CL'><fmt:message key="Common.cancel.label" bundle="${common_labels}"/></div>
<div id='cancelleave' class="manage_menuitem" value='CnlL'><fmt:message key="eRS.ManageWorkScheduleCancelLeave" bundle="${rs_labels}"/></div>
<div id='view_sched' class="manage_menuitem" value='VS' ><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Schedule.label" bundle="${common_labels}"/></div>
</div>

</table>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
<input type='hidden' name='user_id' id='user_id' value='<%=user_id%>'>
<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
<input type='hidden' name='workplace_code' id='workplace_code' value='<%=workplace_code%>'>
<input type='hidden' name='view' id='view' value='<%=view%>'>
</form>

</body>
<%
}
catch ( Exception e )	{
e.printStackTrace() ;
throw e ;
}
finally{

if(pstmt_PositionShiftTotal != null) 
pstmt_PositionShiftTotal.close();

if(pstmt_PositionTotal != null) 
pstmt_PositionTotal.close();

if(pstmt_StaffList != null) 
pstmt_StaffList.close();

if(pstmt_StaffLeaveList != null) 
pstmt_StaffLeaveList.close();

if(rs_PositionShiftTotal != null) 
rs_PositionShiftTotal.close();

if(rs_PositionTotal != null) 
rs_PositionTotal.close();

if(rs_StaffList != null) 
rs_StaffList.close();

if(rs_StaffLeaveList != null) 
rs_StaffLeaveList.close();

ConnectionManager.returnConnection(con,request);
}
%>
</html>

