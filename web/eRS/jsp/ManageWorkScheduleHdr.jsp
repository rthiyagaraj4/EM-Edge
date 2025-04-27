<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	ManageWorkScheduleHdr.jsp
*	Purpose 		:	To display the Back Button & the Navigation Buttons
*	Created By		:	Subbulakshmy. K
*	Created On		:	24-11-2004
*/
%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%
//out.println("Manageworkschedule hdr jsp");
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");


String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- <link rel='stylesheet' type='text/css' href='../../eRS/html/RSStylesheet.css'></link> -->
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../js/ManageWorkSchedule.js"></script>
<!-- <script language="javascript" src="../../eRS/js/RSMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 -->
</head>
<%	
	String facility_id=request.getParameter("facility_id")==null?"":request.getParameter("facility_id") ;
	String user_id			=request.getParameter("user_id")==null?"":request.getParameter("user_id");
	String function_id= request.getParameter( "function_id")==null?"":request.getParameter( "function_id");
	String workplace_code= request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
	String locn_type				= request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
	String role_type		=request.getParameter("role_type")==null?"":request.getParameter("role_type") ;
	String staff_type	=request.getParameter("staff_type")==null?"":request.getParameter("staff_type");
	String position_code= request.getParameter("position_code")==null?"":request.getParameter("position_code");
	String staff_id			=request.getParameter("staff_id")==null?"":request.getParameter("staff_id") ;
	String view				=request.getParameter("view")==null?"":request.getParameter("view");
	String groupby				=request.getParameter("groupby")==null?"":request.getParameter("groupby");
	String from_date				=request.getParameter("from_date")==null?"":request.getParameter("from_date");
	String to_date				=request.getParameter("to_date")==null?"":request.getParameter("to_date");
	String new_fromdate=request.getParameter("new_from_date")==null?"":request.getParameter("new_from_date");
	String new_todate= request.getParameter("new_to_date")==null?"":request.getParameter("new_to_date");
	String onclick_of				=request.getParameter("onclick_of")==null?"":request.getParameter("onclick_of");
	String productive_flag=request.getParameter("productive_flag")==null?"W":request.getParameter("productive_flag");
	int DAYS=Integer.parseInt(request.getParameter("DAYS")==null?"0":request.getParameter("DAYS"));
	String classval="";

	PreparedStatement pstmt_ShiftTotal =null;
	ResultSet rs_ShiftTotal=null;
	CallableStatement cl_DayDate =null;
	ArrayList ShiftTotal	=	new ArrayList();

	String record[]=null;
	String shift_code="";
	String prev_shift="";
	String shift_mnemonic="";
	String shift_desc="";

	int allocated=0;
	int required=0;
	int cell_no=0;
	int shift_count=0;
	int day_count=0;

	//String sql_ShiftTotal="SELECT   a.shift_code, b.long_desc, a.shift_mnemonic, TRUNC (a.schedule_date) schedule_date, SUM (a.required_staff) required, SUM (a.allocated_staff) allocated,(TRUNC (a.schedule_date) - TRUNC (TO_DATE (?, 'dd/mm/yyyy'))) cell_no FROM rs_work_schedule_summ a, am_shift b WHERE a.facility_id = ? AND a.workplace_code = ? AND a.schedule_date BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND TO_DATE (?, 'dd/mm/yyyy') and (? is null or a.position_code=?) and b.shift_indicator ='P'	and b.productive_flag='W' and a.shift_code=b.shift_code GROUP BY a.shift_code, a.shift_mnemonic, a.schedule_date, b.shift_code, b.long_desc ORDER BY a.shift_mnemonic";
	String sql_ShiftTotal="SELECT   a.shift_code, b.long_desc, a.shift_mnemonic, TRUNC (a.schedule_date) schedule_date, SUM (a.required_staff) required, SUM (a.allocated_staff) allocated,(TRUNC (a.schedule_date) - TRUNC (TO_DATE (?, 'dd/mm/yyyy'))) cell_no FROM rs_work_schedule_summ a, am_shift_lang_vw b WHERE a.facility_id = ? AND a.workplace_code = ? AND a.schedule_date BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND TO_DATE (?, 'dd/mm/yyyy') and (? is null or a.position_code=?) and b.shift_indicator ='P' and b.productive_flag='W' and a.shift_code=b.shift_code and b.language_id = ? GROUP BY a.shift_code, a.shift_mnemonic, a.schedule_date, b.shift_code, b.long_desc ORDER BY a.shift_mnemonic";

    Connection con = null;
try{
		con = ConnectionManager.getConnection(request);

		cl_DayDate=con.prepareCall("{call Rs_get_sch_summ_dd_day_string(?,?,?,?,?,?,?,?,?,?,?,?)}");

		cl_DayDate.setString( 1, facility_id) ;
		cl_DayDate.setString( 2, workplace_code) ;
		cl_DayDate.setString( 3, from_date) ;
		cl_DayDate.setString( 4, to_date) ;
		cl_DayDate.setString( 5, onclick_of) ;
		cl_DayDate.setString( 6, new_fromdate) ;
		cl_DayDate.setString( 7, new_todate) ;
		cl_DayDate.registerOutParameter(8,Types.VARCHAR) ;
		cl_DayDate.registerOutParameter(9,Types.VARCHAR) ;
		cl_DayDate.registerOutParameter(10,Types.VARCHAR) ;
		cl_DayDate.registerOutParameter(11,Types.VARCHAR) ;
		cl_DayDate.registerOutParameter(12,Types.VARCHAR) ;
		cl_DayDate.execute() ;

		String date_day = cl_DayDate.getString(8)==null?"":cl_DayDate.getString(8);
		String mon_year = cl_DayDate.getString(9)==null?"":cl_DayDate.getString(9);
		String new_from_date = cl_DayDate.getString(10)==null?"":cl_DayDate.getString(10);
		String new_to_date = cl_DayDate.getString(11)==null?"":cl_DayDate.getString(11);
		String end_ind = cl_DayDate.getString(12)==null?"":cl_DayDate.getString(12);


		if(cl_DayDate != null)
			cl_DayDate.close();
		
		pstmt_ShiftTotal=con.prepareStatement(sql_ShiftTotal);

		pstmt_ShiftTotal.setString(1, new_from_date);
		pstmt_ShiftTotal.setString(2, facility_id);
		pstmt_ShiftTotal.setString(3, workplace_code);
		pstmt_ShiftTotal.setString(4, new_from_date);
		pstmt_ShiftTotal.setString(5, new_to_date);
		pstmt_ShiftTotal.setString(6, position_code);
		pstmt_ShiftTotal.setString(7, position_code);
		pstmt_ShiftTotal.setString(8, locale);

		rs_ShiftTotal=pstmt_ShiftTotal.executeQuery();
		while((rs_ShiftTotal != null)&&(rs_ShiftTotal.next())){
			record	=	new String [7];
			record[0]	=	rs_ShiftTotal.getString("shift_code");
			record[1]	=	rs_ShiftTotal.getString("long_desc");
			record[2]	=	rs_ShiftTotal.getString("shift_mnemonic");
			record[3]	=	rs_ShiftTotal.getString("schedule_date");
			record[4]	=	rs_ShiftTotal.getString("required")==null?"0":rs_ShiftTotal.getString("required");
			record[5]	=	rs_ShiftTotal.getString("allocated")==null?"0":rs_ShiftTotal.getString("allocated");
			record[6]	=	rs_ShiftTotal.getString("cell_no");
			ShiftTotal.add(record);
		}
		if(pstmt_ShiftTotal != null)
			pstmt_ShiftTotal.close();
		if(rs_ShiftTotal != null)
			rs_ShiftTotal.close();
		if (date_day==null) date_day="";
	   StringTokenizer d_token = new StringTokenizer(date_day, "~");
		int d_counter=d_token.countTokens();
		int total_days=d_counter/3;
		String d_code[]=new String[total_days];
		String d_code1[]=new String[total_days];
		String d_code2[]=new String[total_days];
		String req_w[]	 =new String[total_days];
		String alloc_w[]	 =new String[total_days];
		String req_o[]	 =new String[total_days];
		String alloc_o[]	 =new String[total_days];
		String alloc_u[]	 =new String[total_days];
		int d_track=0;

		while (d_token.hasMoreTokens()){
			d_code[d_track]=d_token.nextToken();
			StringTokenizer d_token1 = new StringTokenizer(d_code[d_track], "-");
			d_code1[d_track]	=	d_token1.nextToken();
			d_code2[d_track]	=	d_token1.nextToken();
			req_w[d_track]			=	d_token.nextToken();
			alloc_w[d_track]			=	d_token.nextToken();
			req_o[d_track]			=	d_token.nextToken();
			alloc_o[d_track]			=	d_token.nextToken();
			alloc_u[d_track]			=	d_token.nextToken();
			d_track++;
		}
		StringTokenizer mm_year = new StringTokenizer(mon_year, "|");
		int yy1=mm_year.countTokens();
		String mm_yy[]=new String[yy1];
		int d_track1=0;
		String cc4="0";
		String cc3="0";
		int d_diff1=0;
		int d_diff2=0;
		while (mm_year.hasMoreTokens()){
			mm_yy[d_track1]=mm_year.nextToken();
			d_track1++;
		}
		
		if(yy1>2){
			if(mm_yy[3] !=null){
				cc3=mm_yy[3];
				d_diff1=Integer.parseInt(cc3);
			}
		}
		if(yy1>4){
			if(mm_yy[5] !=null){
				cc4=mm_yy[5];
				d_diff2=Integer.parseInt(cc4);
			}
		}
		int d_diff=Integer.parseInt(mm_yy[1]);
%>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form name=form_ManageWorkScheduleHdr>
	
	<table width="100%" border='0' cellspacing='0' cellpadding='0'>
		<tr>
			<td>
					<table border='0'  align='left' width="100%">
						<tr><td width='16%'>&nbsp;</td>
<%
						for(int p=0;p<30;p++){
							if( p == d_diff ){
								String te1=com.ehis.util.DateUtils.convertDate(mm_yy[0].substring(4),"YY","en",locale);
								String te2=mm_yy[0].substring(0,4)+te1;
%>
								<td  align=left class=Month colspan=2 nowrap><%=te2%>&nbsp;</td>

<%						}
							else 	if( d_diff1 !=0 && p == d_diff1){
								String te3=com.ehis.util.DateUtils.convertDate(mm_yy[2].substring(4),"YY","en",locale);
								String te4=mm_yy[2].substring(0,4)+te3;
%>
								<td  colspan=2 align=left class=Month nowrap><%=te4%></td>
<%			
								} 
							else	if( d_diff2 !=0 && p == d_diff2){
								String te5=com.ehis.util.DateUtils.convertDate(mm_yy[4].substring(4),"YY","en",locale);
								String te6=mm_yy[2].substring(0,4)+te5;
%>
								<td colspan=2 align=left class=Month nowrap>&nbsp;<%=te6%></td>
<%			
							}
							else{
%>
								<td width='10%' class='EmptyCell'>&nbsp;</td>
<%			
							}	
						}		
%>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table border='1' width='100%' bgcolor='white' cellpadding='0'>
					<tr>
						<td width="16%" nowrap class=Date><b>&nbsp;</b>
						</td>
<%	
					for(int day=0;day<d_track;day++){
%>
						<td class=Date width="6%" title="<%=d_code2[day]%>" align='center'><%=d_code2[day]%></td>
						<input type='hidden' name='"<%=d_code2[day]%>"' id='"<%=d_code2[day]%>"' value='"<%=d_code2[day]%>"'>
<%	
					}
					for(int day=d_track;day<DAYS;day++){
%>
						<td class='EmptyCell' width="6%" align='center'>&nbsp;</td>
<%
					}
%>
					</tr>
					<tr>	
						<td  align="left" class=Day width="6%" nowrap><b>&nbsp;</td>
						<input type='hidden' name='u1' id='u1' value='u1'>
<%	
					for(int day=0;day<d_track;day++){
%>
						<td class=Day width="6%" title="<%=d_code1[day]%>" align='center'>&nbsp;<%=d_code1[day]%>&nbsp;</td>
						<input type='hidden' name='"<%=d_code1[day]%>"' id='"<%=d_code1[day]%>"' value='"<%=d_code1[day]%>"'>
<%
					}
					for(int day=d_track;day<DAYS;day++){
%>
						<td class='EmptyCell' width="6%" align='center'>&nbsp;</td>
<%
					}
%>
	<!--Allocated & Requirement total -->
					<tr>	
						<td  align="left" class='EmptyCell' width="16%" nowrap><fmt:message key="eRS.Working.label" bundle="${rs_labels}"/>&nbsp;<fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></td>
						<input type='hidden' name='u1' id='u1' value='u1'>
<%	
					for(int day=0;day<d_track;day++){
						allocated	=	Integer.parseInt(alloc_w[day]==null?"0":alloc_w[day]);
						required	=	Integer.parseInt(req_w[day]==null?"0":req_w[day]);
						if(allocated > required)
							classval	=	"ABOVEOPTIMAL";
						if(allocated < required)
							classval	=	"BELOWOPTIMAL";
						if(allocated == required)
							classval	=	"OPTIMAL";
						if((allocated == 0)&&(required == 0))
							classval	=	"EmptyCell";
%>
						<td class='<%=classval%>' width="6%" id='w_total<%=day%>' align='center' nowrap><%=allocated%>/<%=required%></td>	
						<input type='hidden' name='w_totalreq<%=day%>' id='w_totalreq<%=day%>' value='<%=required%>'>
						<input type='hidden' name='w_totalalloc<%=day%>' id='w_totalalloc<%=day%>' value='<%=allocated%>'>
<%	
					}
					for(int day=d_track;day<DAYS;day++){
%>
						<td class='EmptyCell' width="6%" id='w_total<%=day%>' align='center' nowrap>&nbsp;</td>	
						<input type='hidden' name='w_totalreq<%=day%>' id='w_totalreq<%=day%>' value=''>
						<input type='hidden' name='w_totalalloc<%=day%>' id='w_totalalloc<%=day%>' value=''>
<%
					}
%>
					</tr>
					<tr>	
						<td  align="left" class='EmptyCell' width="16%" nowrap><fmt:message key="eRS.Oncall.label" bundle="${rs_labels}"/>&nbsp;<fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></td>
						<input type='hidden' name='u1' id='u1' value='u1'>
<%
					for(int day=0;day<d_track;day++){
						allocated	=	Integer.parseInt(alloc_o[day]==null?"0":alloc_o[day]);
						required	=	Integer.parseInt(req_o[day]==null?"0":req_o[day]);
						if(allocated > required)
							classval	=	"ABOVEOPTIMAL";
						if(allocated < required)
							classval	=	"BELOWOPTIMAL";
						if(allocated == required)
							classval	=	"OPTIMAL";
						if((allocated == 0)&&(required == 0))
							classval	=	"EmptyCell";
%>
						<td class='<%=classval%>' width="6%" id='o_total<%=day%>' align='center' nowrap><%=allocated%>/<%=required%></td>
						<input type='hidden' name='o_totalreq<%=day%>' id='o_totalreq<%=day%>' value='<%=required%>'>
						<input type='hidden' name='o_totalalloc<%=day%>' id='o_totalalloc<%=day%>' value='<%=allocated%>'>
<%
					}
					for(int day=d_track;day<DAYS;day++){
%>
						<td class='EmptyCell' width="6%" id='o_total<%=day%>' align='center' nowrap>&nbsp;</td>		
						<input type='hidden' name='o_totalreq<%=day%>' id='o_totalreq<%=day%>' value=''>
						<input type='hidden' name='o_totalalloc<%=day%>' id='o_totalalloc<%=day%>' value=''>
<%
					}
%>
					</tr>
					<tr>	
						<td  align="left" class='EmptyCell' width="16%" nowrap><fmt:message key="eRS.Unproductive.label" bundle="${rs_labels}"/>&nbsp;<fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></td>
						<input type='hidden' name='u1' id='u1' value='u1'>
<%
				for(int day=0;day<d_track;day++){
						allocated	=	Integer.parseInt(alloc_u[day]==null?"0":alloc_u[day]);
						if(allocated > required)
							classval	=	"ABOVEOPTIMAL";
						if(allocated < required)
							classval	=	"BELOWOPTIMAL";
						if(allocated == required)
							classval	=	"OPTIMAL";
						if((allocated == 0)&&(required == 0))
							classval	=	"EmptyCell";
%>
						<td class='EmptyCell' width="6%" id='u_total<%=day%>' align='center' nowrap><%=allocated%></td>
						<input type='hidden' name='u_totalalloc<%=day%>' id='u_totalalloc<%=day%>' value='<%=allocated%>'>
<%
				}
				for(int day=d_track;day<DAYS;day++){
%>
					<td class='EmptyCell' width="6%" id='u_total<%=day%>' align='center' nowrap>&nbsp;</td>
					<input type='hidden' name='u_totalalloc<%=day%>' id='u_totalalloc<%=day%>' value=''>

<%
				}
%>
					</tr>
			</table>
			</td>
		</tr>
		<tr>
<!--  To display the Shift Total-->
			<table width='100%' border='1' cellpadding='0'>
				<tr >		
<%	
/***to display first shift first day****/
				if((ShiftTotal!=null)&&(ShiftTotal.size()>0)){
					shift_count=ShiftTotal.size();
					record=(String[])ShiftTotal.get(0);
					shift_code			=	record[0];
					shift_desc			=	record[1];
					shift_mnemonic	=	record[2];
					required				=	Integer.parseInt(record[4]);
					allocated				=	Integer.parseInt(record[5]);
					cell_no				=	Integer.parseInt(record[6]);

					if(allocated > required)
						classval	=	"ABOVEOPTIMAL";
					if(allocated < required)
						classval	=	"BELOWOPTIMAL";
					if(allocated == required)
						classval	=	"OPTIMAL";
					if((allocated == 0)&&(required == 0))
						classval	=	"EmptyCell";

%>
					</tr>
					<tr>
						<td	class='Shift' align=left width='16%' nowrap><%=shift_desc%> - <%=shift_mnemonic%>
						</td>
<%	
					if(cell_no > day_count){
						for(int day=day_count; day<cell_no;day++){
%>
							<td class='EmptyCell' width="6%" id='shift<%=shift_code%><%=day%>' align='center' nowrap>&nbsp;</td>
							<input type='hidden' name='shiftreq<%=shift_code%><%=day%>' id='shiftreq<%=shift_code%><%=day%>' value=''>
							<input type='hidden' name='shiftalloc<%=shift_code%><%=day%>' id='shiftalloc<%=shift_code%><%=day%>' value=''>
<%
						}
						day_count=cell_no;
					}
%>
							<td class='<%=classval%>' width="6%" id='shift<%=shift_code%><%=day_count%>' align='center' nowrap><%=allocated%>/<%=required%></td>
							<input type='hidden' name='shiftreq<%=shift_code%><%=day_count%>' id='shiftreq<%=shift_code%><%=day_count%>' value='<%=required%>'>
							<input type='hidden' name='shiftalloc<%=shift_code%><%=day_count%>' id='shiftalloc<%=shift_code%><%=day_count%>' value='<%=allocated%>'>
<%		
					day_count++;
					prev_shift=shift_code;
					for(int i=1;i<shift_count;i++){
						record=(String[])ShiftTotal.get(i);
						shift_code			=	record[0];
						shift_desc			=	record[1];
						shift_mnemonic	=	record[2];
						required				=	Integer.parseInt(record[4]);
						allocated				=	Integer.parseInt(record[5]);
						cell_no				=	Integer.parseInt(record[6]);

						if(allocated > required)
							classval	=	"ABOVEOPTIMAL";
						if(allocated < required)
							classval	=	"BELOWOPTIMAL";
						if(allocated == required)
							classval	=	"OPTIMAL";
						if((allocated == 0)&&(required == 0))
							classval	=	"EmptyCell";

						if(!prev_shift.equals(shift_code)){
							for(int day=day_count;day<DAYS;day++){
%>
								<td class='EmptyCell' width="6%" id='shift<%=prev_shift%><%=day%>' align='center' nowrap>&nbsp;</td>
								<input type='hidden' name='shiftreq<%=prev_shift%><%=day%>' id='shiftreq<%=prev_shift%><%=day%>' value=''>
								<input type='hidden' name='shiftalloc<%=prev_shift%><%=day%>' id='shiftalloc<%=prev_shift%><%=day%>' value=''>
<%		
							}
							prev_shift=shift_code;
							day_count=0;
%>
							</tr>
							<tr>
								<td	class='Shift' align=left width='16%' nowrap><%=shift_desc%> - <%=shift_mnemonic%></td>
<%		
						}	
						if(cell_no > day_count){
							for(int day=day_count; day<cell_no;day++){
%>
								<td class='EmptyCell' width="6%" id='shift<%=prev_shift%><%=day%>' align='center' nowrap>&nbsp;</td>
								<input type='hidden' name='shiftreq<%=prev_shift%><%=day%>' id='shiftreq<%=prev_shift%><%=day%>' value=''>
								<input type='hidden' name='shiftalloc<%=prev_shift%><%=day%>' id='shiftalloc<%=prev_shift%><%=day%>' value=''>
<%	
							}
							day_count=cell_no;
						}
%>
							<td class='<%=classval%>' width="6%" id='shift<%=shift_code%><%=day_count%>' align='center' nowrap><%=allocated%>/<%=required%></td>
							<input type='hidden' name='shiftreq<%=shift_code%><%=day_count%>' id='shiftreq<%=shift_code%><%=day_count%>' value='<%=required%>'>
							<input type='hidden' name='shiftalloc<%=shift_code%><%=day_count%>' id='shiftalloc<%=shift_code%><%=day_count%>' value='<%=allocated%>'>
							
<%	
						day_count++;
					}
					for(int day=day_count;day<DAYS;day++){
%>
						<td class='EmptyCell' width="6%" id='total<%=day%>' align='center' nowrap>&nbsp;</td>
						<input type='hidden' name='shiftreq<%=shift_code%><%=day%>' id='shiftreq<%=shift_code%><%=day%>' value=''>
						<input type='hidden' name='shiftalloc<%=shift_code%><%=day%>' id='shiftalloc<%=shift_code%><%=day%>' value=''>
								
<%
					}
				}
%>
				</tr>
		</table>
	</table>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='user_id' id='user_id' value='<%=user_id%>'>
	<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
	<input type='hidden' name='locn_type' id='locn_type' value='<%=locn_type%>'>
	<input type='hidden' name='workplace_code' id='workplace_code' value='<%=workplace_code%>'>
	<input type='hidden' name='role_type' id='role_type' value='<%=role_type%>'>
	<input type='hidden' name='staff_type' id='staff_type' value='<%=staff_type%>'>
	<input type='hidden' name='position_code' id='position_code' value='<%=position_code%>'>
	<input type='hidden' name='staff_id' id='staff_id' value='<%=staff_id%>'>
	<input type='hidden' name='from_date' id='from_date' value='<%=from_date%>'>
	<input type='hidden' name='to_date' id='to_date' value='<%=to_date%>'>
	<input type='hidden' name='view' id='view' value='<%=view%>'>
	<input type='hidden' name='groupby' id='groupby' value='<%=groupby%>'>
	<input type='hidden' name='end_ind' id='end_ind' value='<%=end_ind%>'>
</form>
<script>	
	parent.frames[0].document.forms[0].p_from_date.value='<%=new_from_date%>';
	parent.frames[0].document.forms[0].p_to_date.value='<%=new_to_date%>';
	parent.frames[0].document.forms[0].p_end.value='<%=end_ind%>';
	parent.frames[2].location.href='../../eRS/jsp/ManageWorkScheduleResult.jsp?facility_id=<%=facility_id%>&user_id=<%=user_id%>&function_id=<%=function_id%>&workplace_code=<%=workplace_code%>&locn_type=<%=locn_type%>&role_type=<%=role_type%>&staff_type=<%=staff_type%>&position_code=<%=position_code%>&staff_id=<%=staff_id%>&view=<%=view%>&groupby=<%=groupby%>&from_date=<%=from_date%>&to_date=<%=to_date%>&new_from_date=<%=new_from_date%>&new_to_date=<%=new_to_date%>&onclick_of=<%=onclick_of%>&productive_flag=<%=productive_flag%>&DAYS=<%=DAYS%>';
</script>
<%
	}
    catch(Exception e)
	{
		e.printStackTrace();
	} 
	finally
	{
		if(pstmt_ShiftTotal!=null) pstmt_ShiftTotal.close();
		if(cl_DayDate!=null) cl_DayDate.close();
		if(rs_ShiftTotal!=null) rs_ShiftTotal.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

