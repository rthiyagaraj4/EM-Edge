<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	WorkPlaceAllocationResult1.jsp
*	Purpose 		:
*	Created By		:	Sreenivasulu.Y
*	Created On		:	10 Dec 2004
*/
%>
<%-- JSP Page specific attributes start --%>
<jsp:useBean id="apptRecordSet" class="webbeans.eCommon.RecordSet" scope="session"/>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");


String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
try
{
String sql_workplace_aclloc_det="";
String facility_id = request.getParameter( "facility_id") ;
String locn_type= request.getParameter("locn_type");
String workplace_code=request.getParameter("workplace_code");
String group_by=request.getParameter("group_by");
String view_opt=request.getParameter("view_opt");
String from_date = request.getParameter( "from_date") ;
String to_date= request.getParameter("to_date");
String new_todate=request.getParameter("new_todate");
String next_fromdate=request.getParameter("next_fromdate");
String onclick_of=request.getParameter("onclick_of");

if(facility_id ==null) facility_id="";
if(locn_type ==null) locn_type="";
if(workplace_code ==null) workplace_code="";
if(group_by ==null) group_by="";
if(view_opt ==null) view_opt="";
if(from_date ==null) from_date="";
if(to_date ==null) to_date="";
if(new_todate ==null) new_todate="";
if(next_fromdate ==null) next_fromdate="";
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- <link rel='stylesheet' type='text/css' href='../../eRS/html/RSStylesheet.css'></link>
 --><script src="../../eOP/js/Validate.js" language="JavaScript"></script>

<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script src="../../eOP/js/Validate.js" language="javascript"></script>
<script language="javascript" src="../js/WorkplaceAllocation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()"onKeyDown = 'lockKey()' >
	
<%
Connection con = null;
PreparedStatement stmt_workplace_aclloc_det =null;
ResultSet rs_workplace_aclloc_det=null;
CallableStatement statement =null;
try
{
try{
		con = ConnectionManager.getConnection(request);
		statement=con.prepareCall("{call Rs_Get_Dd_Day_String(?,?,?,?,?,?,?,?,?,?)}");
		statement.setString( 1, from_date) ;
		statement.setString( 2, to_date) ;
		statement.setString( 3, onclick_of) ;
		statement.setString( 4, next_fromdate) ;
		statement.setString( 5, new_todate) ;
		statement.registerOutParameter(6,Types.VARCHAR) ;
		statement.registerOutParameter(7,Types.VARCHAR) ;
		statement.registerOutParameter(8,Types.VARCHAR) ;
		statement.registerOutParameter(9,Types.VARCHAR) ;
		statement.registerOutParameter(10,Types.VARCHAR) ;
		statement.execute() ;
		}catch(Exception e) {
			e.printStackTrace();
		}
			String date_day = statement.getString(6);
			//System.err.println("date_day---------->"+date_day);
			String mon_year = statement.getString(7);
			String new_from_date = statement.getString(8);
			String new_to_date = statement.getString(9);
			String end_ind = statement.getString(10);

			if(statement!=null) statement.close();
			
            if (date_day==null) date_day="";
            StringTokenizer d_token = new StringTokenizer(date_day, "~");
			//System.err.println("date_day------>"+date_day);
			int d_counter=d_token.countTokens();
			//System.err.println("d_counter------>"+d_counter);

			String d_code[]=new String[d_counter];
			String d_code1[]=new String[d_counter];
			String d_code2[]=new String[d_counter];
			int d_track=0;
			while (d_token.hasMoreTokens())
			{
			d_code[d_track]=d_token.nextToken();
			StringTokenizer d_token1 = new StringTokenizer(d_code[d_track], "-");
			d_code1[d_track]=d_token1.nextToken();
			d_code2[d_track]=d_token1.nextToken();
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
			while (mm_year.hasMoreTokens())
			{
			mm_yy[d_track1]=mm_year.nextToken();
			d_track1++;
			}
			
			if(yy1>2){
				if(mm_yy[3] !=null)
				{
				cc3=mm_yy[3];
				d_diff1=Integer.parseInt(cc3);
				}
			}
			if(yy1>4){
				if(mm_yy[5] !=null)
				{
				cc4=mm_yy[5];
				d_diff2=Integer.parseInt(cc4);
				}
			}

			int d_diff=Integer.parseInt(mm_yy[1]);
						
			//sql_workplace_aclloc_det="select rs_workplace.workplace_desc workplace_desc, trunc(schedule_date) sch_date,(trunc(schedule_date)- trunc(to_date(?,'dd/mm/yyyy'))) cell_no,sum(required_staff) required_staff,sum(allocated_staff) allocated_staff from rs_work_schedule_summ, rs_workplace, am_shift where rs_work_schedule_summ.facility_id = ? and (? is null or rs_work_schedule_summ.workplace_code = ?) and rs_work_schedule_summ.schedule_date between to_date(?,'dd/mm/yyyy') and (to_date(?,'dd/mm/yyyy')) and rs_workplace.workplace_code = rs_work_schedule_summ.workplace_code and am_shift.shift_code = rs_work_schedule_summ.shift_code and am_shift.shift_indicator = 'P' group by rs_workplace.workplace_desc,trunc(schedule_date),(trunc(schedule_date)- trunc(to_date(?,'dd/mm/yyyy'))) order by workplace_desc,sch_date";
			sql_workplace_aclloc_det="select rs_workplace_lang_vw.workplace_desc workplace_desc, trunc(schedule_date) sch_date,(trunc(schedule_date)- trunc(to_date(?,'dd/mm/yyyy'))) cell_no,sum(required_staff) required_staff,sum(allocated_staff) allocated_staff from rs_work_schedule_summ, rs_workplace_lang_vw, am_shift where rs_work_schedule_summ.facility_id = ? and (? is null or rs_work_schedule_summ.workplace_code = ?) and rs_work_schedule_summ.schedule_date between to_date(?,'dd/mm/yyyy') and (to_date(?,'dd/mm/yyyy')) and rs_workplace_lang_vw.workplace_code = rs_work_schedule_summ.workplace_code and am_shift.shift_code = rs_work_schedule_summ.shift_code and am_shift.shift_indicator = 'P' and rs_workplace_lang_vw.language_id = ? group by rs_workplace_lang_vw.workplace_desc,trunc(schedule_date),(trunc(schedule_date)- trunc(to_date(?,'dd/mm/yyyy')))  order by workplace_desc,sch_date";
	
	try{		
		stmt_workplace_aclloc_det=con.prepareStatement(sql_workplace_aclloc_det);
        stmt_workplace_aclloc_det.setString(1,new_from_date);
		stmt_workplace_aclloc_det.setString(2,facility_id);
		stmt_workplace_aclloc_det.setString(3,workplace_code);
		stmt_workplace_aclloc_det.setString(4,workplace_code);
		stmt_workplace_aclloc_det.setString(5,new_from_date);
		stmt_workplace_aclloc_det.setString(6,new_to_date);
		stmt_workplace_aclloc_det.setString(7,locale);
		stmt_workplace_aclloc_det.setString(8,new_from_date);
		rs_workplace_aclloc_det=stmt_workplace_aclloc_det.executeQuery();
	}catch(Exception e)
	{
		out.println("bfr tbl1:"+e);
	}
			
%>
<! -- USH CHECK-OUT -->

<table border=0 width='99%' >
<tr>
<td width='13%' class=ush>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>

<%

for(int p=0;p<14;p++){
	if( p == d_diff ){
						String te1=mm_yy[0].substring(0,4)+com.ehis.util.DateUtils.convertDate(mm_yy[0].substring(4),"YY","en",locale);						
		%>
		<td width='7%' align=right class=ush colspan=2 nowrap><%=te1%>&nbsp;</td>
	
	<%}else if( d_diff1 !=0 && p == d_diff1){
		String te2=mm_yy[2].substring(0,4)+com.ehis.util.DateUtils.convertDate(mm_yy[2].substring(4),"YY","en",locale);
		%>
		<td width='7%' colspan=2 align=centre class=ush nowrap>&nbsp;&nbsp;<%=te2%>&nbsp;</td>
		<%} 
	else if( d_diff2 !=0 && p == d_diff2){
		String te3=mm_yy[4].substring(0,4)+com.ehis.util.DateUtils.convertDate(mm_yy[4].substring(4),"YY","en",locale);
		%>
		<td width='7%' colspan=2 align=centre class=ush nowrap>&nbsp;<%=te3%></td>
		<%
	}
	else
	{%>
		<td width='2%' class=ush>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
	<%}
	
}
%>
</tr>
</table>
<table border=1 width='99%'  id='colors'>
<tr>
<form name='calender1' id='calender1'>
<td  align="left" class=Day width="13%" nowrap><b><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input type='hidden' name='u1' id='u1' value='u1'>
</td>
<%
for(int u=0;u<d_track;u++)
{
%>
	<td class=Day width="3.5%" title="<%=d_code2[u]%>" align='center'><%=d_code2[u]%>
	</td><input type='hidden' name='"<%=d_code2[u]%>"' id='"<%=d_code2[u]%>"' value='"<%=d_code2[u]%>"'>
	</td>		
<%}
for(int u=0;u<(14-d_track);u++){%>
	<td class=EmptyCell width="3.5%" align="middle">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<%}%>
</form>
</tr>
<tr>
<form name='calender1' id='calender1'>

		<td  align="left" class=Day width="3.5%" nowrap><b>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;  <input type='hidden' name='u1' id='u1' value='u1'></b></td>
		
<%
for(int u=0;u<d_track;u++){%>
	
	<td class=Day width="3.5%" title="<%=d_code1[u]%>" align='center'><%=d_code1[u]%>
	</td><input type='hidden' name='"<%=d_code1[u]%>"' id='"<%=d_code1[u]%>"' value='"<%=d_code1[u]%>"'>
		
<%}
for(int u=0;u<(14-d_track);u++){%>
	<td class=EmptyCell width="3.5%" align='center'>&nbsp;&nbsp;&nbsp;</td>
<%}%>
</form>
</tr>
<form name='calender' id='calender'>
<%
int all=0;
int req=0;
String classval	="";
String classValue="";
int cell=0;
String	wp_temp = "";
String wp = "";
String a[]=new String[14];
String r[]=new String[14];
int cell_no1[]=new int[100];
int hh=0;
if(rs_workplace_aclloc_det.next())
{
String flag = "1";
wp = rs_workplace_aclloc_det.getString("workplace_desc");
wp_temp = wp;
int i=0;
while(flag.equals("1"))
{		
	if ( hh % 2 == 0 )
		classValue = "EmptyEven" ;
	else
		classValue = "EmptyOdd" ;

	for(int q = 0; q<14; q++)
		cell_no1[q] = -1;

	while (wp_temp.equals(wp) && flag.equals("1"))
	{ 
	    cell = Integer.parseInt(rs_workplace_aclloc_det.getString("cell_no"));
		cell_no1[cell]=cell;
		a[cell] = rs_workplace_aclloc_det.getString("allocated_staff");
		r[cell] = rs_workplace_aclloc_det.getString("required_staff");
		classval="";

		if (rs_workplace_aclloc_det.next())
		{
			wp = rs_workplace_aclloc_det.getString("workplace_desc");
			i++;
		}
		else
		{
			flag = "0";		
		}
	}
%>
<tr>
<td class='<%=classValue%>' width='3%' nowrap><b><%=wp_temp%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<%
	for(int kkk=0;kkk<14;kkk++){
	if(cell_no1[kkk]==kkk ){
		all=Integer.parseInt(a[kkk]);
		req=Integer.parseInt(r[kkk]);
		if(all==req)
		{
 			classval	=	"OPTIMAL";
		}else
		if(all > req)
		{
			classval	=	"ABOVEOPTIMAL";
			
		}else
		if(all < req)
		{
			classval	=	"BELOWOPTIMAL";		
		}
		if(( all == 0 ) && ( req == 0 ))
		{
			classval	=	"EmptyCell";		
		}

%>
<td class="<%=classval%>" width='3%' align='center' id=<%=kkk%>><%=a[kkk]%>/<%=r[kkk]%>
		<%
		}else{
			%>
	<td class="<%=classValue%>" id="<%=kkk%>" width='3%'>&nbsp;
		<%				
		}
	}
		
/*		build the table using the string*/
for(int kkk=0;kkk<14;kkk++){
	a[kkk] ="&nbsp;";
}
	wp_temp = wp;%>	
	</tr> <%
		hh++;		
	}
}
%>
</form>
<script>
parent.parent.frames[2].frames[0].document.forms[0].p_from_date.value='<%=new_from_date%>';
parent.parent.frames[2].frames[0].document.forms[0].p_to_date.value='<%=new_to_date%>';
parent.parent.frames[2].frames[0].document.forms[0].p_end.value='<%=end_ind%>';
</script>
<%
}catch(Exception e)
{
   out.println(e.toString());
	}
	finally
	{
	try
	{
	if(statement!=null) statement.close();
	if(stmt_workplace_aclloc_det!=null) stmt_workplace_aclloc_det.close();
	if(rs_workplace_aclloc_det!=null) rs_workplace_aclloc_det.close();
	ConnectionManager.returnConnection(con,request);	
	}
	catch(Exception exp)
	{
		exp.toString();
	}
	}
%>
</form>
</body>
<% } catch(Exception e) {
	e.printStackTrace();
} 
%>
</html>

