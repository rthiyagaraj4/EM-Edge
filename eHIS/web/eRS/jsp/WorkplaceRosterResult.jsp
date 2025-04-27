<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	Karabi S.
*	Created On		:	02 Dec 2004
-->
<%-- JSP Page specific attributes start --%>
<jsp:useBean id="apptRecordSet" class="webbeans.eCommon.RecordSet" scope="session"/>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<%
try{
String sch_date="";
String facility_id	=(String)session.getValue( "facility_id" ) ;
String sql_workplace_roster_det="";
String mode	   = request.getParameter("mode") ;
String function_id = request.getParameter( "function_id") ;
String workplace_code= request.getParameter("workplace_code");
String from_date = request.getParameter( "from_date") ;
String to_date= request.getParameter("to_date");
String new_todate=request.getParameter("new_todate");
String next_fromdate=request.getParameter("next_fromdate");
String onclick_of=request.getParameter("onclick_of");

	if(mode ==null) mode="";
	if(function_id ==null) function_id="";
	if(workplace_code ==null) workplace_code="";
	if(from_date ==null) from_date="";
	if(to_date ==null) to_date="";
	if(new_todate ==null) new_todate="";
	if(next_fromdate ==null) next_fromdate="";
	

request.setCharacterEncoding("UTF-8");
String locale=(String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- <link rel='stylesheet' type='text/css' href='../../eRS/html/RSStylesheet.css'></link>
 -->

 <script src='../../eCommon/js/common.js' language='javascript'></script> 
 <script src="../../eOP/js/Validate.js" language="javascript"></script>
<!-- <script src='../../eCommon/js/messages.js' language='javascript'></script> -->
<Script src="../../eOA/js/Validate1.js" language="JavaScript"></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()"onKeyDown = 'lockKey()' >
<%
Connection con = null;
PreparedStatement stmt_workplace_roster_det =null;
ResultSet rs_workplace_roster_det=null;
CallableStatement statement2 = null;
try{
try{
		con = ConnectionManager.getConnection(request);
		statement2=con.prepareCall("{call Rs_Get_Dd_Day_String(?,?,?,?,?,?,?,?,?,?)}");
		statement2.setString( 1, from_date) ;
		statement2.setString( 2, to_date) ;
		statement2.setString( 3, onclick_of) ;
		statement2.setString( 4, next_fromdate) ;
		statement2.setString( 5, new_todate) ;
		statement2.registerOutParameter(6,Types.VARCHAR) ;
		statement2.registerOutParameter(7,Types.VARCHAR) ;
		statement2.registerOutParameter(8,Types.VARCHAR) ;
		statement2.registerOutParameter(9,Types.VARCHAR) ;
		statement2.registerOutParameter(10,Types.VARCHAR) ;
		statement2.execute() ;
		}catch(Exception e) {
			e.printStackTrace();
		}
			String date_day = statement2.getString(6);
			String mon_year = statement2.getString(7);
			String new_from_date = statement2.getString(8);
			String new_to_date = statement2.getString(9);
			String end_ind = statement2.getString(10);
				
            if (date_day==null) date_day="";
            StringTokenizer d_token = new StringTokenizer(date_day, "~");
			int d_counter=d_token.countTokens();
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
					
			sql_workplace_roster_det="select a.Staff_Id, b.staff_name,to_char(a.schedule_date,'dd/mm/yyyy') sch_date,a.shift_mnemonic,(trunc(schedule_date)- trunc(to_date(?,'dd/mm/yyyy'))) cell_no,a.role_type role_type  from 	rs_work_schedule a, am_staff_vw b where a.facility_id = ? and	a.workplace_code = ? and	a.schedule_date between to_date(?,'dd/mm/yyyy') and	to_date(?,'dd/mm/yyyy') and	b.role_type = a.role_type and  b.staff_id = a.staff_id order by b.staff_name, a.schedule_date ";


		try
	    {
		stmt_workplace_roster_det=con.prepareStatement(sql_workplace_roster_det);
		stmt_workplace_roster_det.setString(1,new_from_date);
		stmt_workplace_roster_det.setString(2,facility_id);
		stmt_workplace_roster_det.setString(3,workplace_code);
		stmt_workplace_roster_det.setString(4,new_from_date);
		stmt_workplace_roster_det.setString(5,new_to_date);
		rs_workplace_roster_det=stmt_workplace_roster_det.executeQuery();
		}
		catch(Exception exp)
	    {
			out.println(exp.toString());
	    }
%>
<! -- USH CHECK-OUT -->

<table border=0 width='99%' >
<tr>
<td width='13%' class=ush>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<%
for(int p=0;p<14;p++)
{
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
<td  align="left" class="Day" width="13%" nowrap><b><fmt:message key="eRS.Staff.label" bundle="${rs_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input type='hidden' name='u1' id='u1' value='u1'>
</td>
<%
for(int u=0;u<d_track;u++){%>
<td class="Day" width="3.5%" title="<%=d_code2[u]%>" align='center'><%=d_code2[u]%>
</td><input type='hidden' name='"<%=d_code2[u]%>"' id='"<%=d_code2[u]%>"' value='"<%=d_code2[u]%>"'>
</td>		
<%}
for(int u=0;u<(14-d_track);u++){%>
<td class="Emptycell" width="3.5%" align="middle">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<%}%>
</form>
</tr>
<tr>
<form name='calender1' id='calender1'>
<td  align="left" class="Day" width="3.5%" nowrap><b>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;  <input type='hidden' name='u1' id='u1' value='u1'></b></td>
<%
for(int u=0;u<d_track;u++){%>
<td class="Day" width="3.5%" title="<%=d_code1[u]%>" align='center'>&nbsp;<%=d_code1[u]%>&nbsp;
</td><input type='hidden' name='"<%=d_code1[u]%>"' id='"<%=d_code1[u]%>"' value='"<%=d_code1[u]%>"'>
</td>		
<%}
for(int u=0;u<(14-d_track);u++){%>
<td class="Emptycell" width="3.5%" align='center'>&nbsp;&nbsp;&nbsp;</td>
<%}%>
</form>
</tr>
<form name='calender' id='calender'>
<%
int cell=0;
String sch_date1="";
String sh_mnemonic="";
String	st_temp = "";
String st = "";
String m[]=new String[14];
String mm[]=new String[14];
int cell_no1[]=new int[100];
int hh=0;
String role_type="";
String role_type1="";

if(rs_workplace_roster_det.next())
{
String flag = "1";
st = rs_workplace_roster_det.getString("Staff_Id");
st_temp = st;

while(flag.equals("1"))
{		

	for(int q = 0; q<14; q++)
	cell_no1[q] = -1;
	while (st_temp.equals(st) && flag.equals("1"))
	{ 
		cell = Integer.parseInt(rs_workplace_roster_det.getString("cell_no"));
		cell_no1[cell]=cell;
		mm[cell] = rs_workplace_roster_det.getString("shift_mnemonic");
		role_type = rs_workplace_roster_det.getString("role_type");
		sch_date = rs_workplace_roster_det.getString("sch_date");

     if(sch_date.equals(sch_date1)&&role_type.equals(role_type1))
     {
	 	m[cell] = sh_mnemonic+"|"+mm[cell];
     }
     else
     {
		m[cell] = mm[cell];
     }
		role_type1 = role_type;
		sch_date1 = sch_date;
		sh_mnemonic = mm[cell];
		
		if (rs_workplace_roster_det.next())
		{
			st = rs_workplace_roster_det.getString("Staff_Id");
     	}
		else
		{
			flag = "0";		
		}
	
	}
%>
<tr>
<td class='WRKPV' width='3%' nowrap><b><%=st_temp%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
<%
for(int kkk=0;kkk<14;kkk++)
{
   if(cell_no1[kkk]==kkk ){ %>
<td class="EmptyCell" width='3%' align='center' id=<%=kkk%>>&nbsp;<%=m[kkk]%>&nbsp;
<%
}
else
{
%>
<td class="EmptyCell" id=<%=kkk%> width='3%'>&nbsp;&nbsp;
<%				
}
}
/*		build the table using the string*/
for(int kkk=0;kkk<14;kkk++){
	m[kkk] ="&nbsp;";
}
	st_temp = st;%>	
</tr>
<%
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
	e.printStackTrace();
}
finally
{
try
{
if(statement2 !=null) statement2.close();
if(rs_workplace_roster_det !=null) rs_workplace_roster_det.close();
if(stmt_workplace_roster_det !=null) stmt_workplace_roster_det.close();
ConnectionManager.returnConnection(con,request);
}
catch(Exception exp)
{
	out.println(exp.toString());
}
}
%>
</form>
</body>
<% 
	} 
catch(Exception e) 
{
	e.printStackTrace();
} 
finally
{

}
%>
</html>

