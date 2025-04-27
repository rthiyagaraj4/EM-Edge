<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	Prabhu.M
*	Created On		:	13 Dec 2004
-->
<jsp:useBean id="apptRecordSet" class="webbeans.eCommon.RecordSet" scope="session"/>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<%
	Connection con = null;
			
	PreparedStatement pstmt_wp_allocation_det =null;
	ResultSet rs_wp_allocation_det=null;
	CallableStatement statement2 = null;

try{
int total[]=new int[31];
int total11[]=new int[31];

String facility_id	=request.getParameter( "facility_id" ) ;
	String sql_wp_allocation_det="";
	String group_by	   = request.getParameter("group_by") ;
	String function_id = request.getParameter( "function_id") ;
	String locn_type= request.getParameter("locn_type");
	String workplace_code=request.getParameter("workplace_code");
	String from_date = request.getParameter( "from_date") ;
	String to_date= request.getParameter("to_date");
	String new_todate=request.getParameter("new_todate");
	String next_fromdate=request.getParameter("next_fromdate");
	String onclick_of=request.getParameter("onclick_of");
	String view_opt=request.getParameter("view_opt");

	if(group_by ==null) group_by="";
	if(function_id ==null) function_id="";
	if(locn_type ==null) locn_type="";
	if(workplace_code ==null) workplace_code="";
	if(from_date ==null) from_date="";
	if(to_date ==null) to_date="";
	if(new_todate ==null) new_todate="";
	if(next_fromdate ==null) next_fromdate="";
	if(view_opt ==null) view_opt="";
	if(facility_id ==null) facility_id="";


request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");


String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- <link rel='stylesheet' type='text/css' href='../../eRS/html/RSStylesheet.css'></link>	
 --><script src="../../eOP/js/Validate.js" language="javascript"></script>
<!-- <script src='../../eOA/js/oamessages.js' language='javascript'></script>-->
<script src='../../eCommon/js/common.js' language='javascript'></script> 
<script src="../../eOA/js/Validate1.js" language="javascript"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()"onKeyDown = 'lockKey()' >
	
<%
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
						
			//sql_wp_allocation_det="select d.position_desc, b.short_desc shift_desc, trunc(a.schedule_date) sch_date,(trunc(a.schedule_date) - to_date(?,'dd/mm/yyyy')) cell_no,sum(a.required_staff) required, sum(a.allocated_staff) allocated from rs_work_schedule_summ a, am_shift b, am_position d where a.facility_id =? and (? is null or a.workplace_code = ?) and a.schedule_date between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') and d.position_code = a.position_code and b.shift_code = a.shift_code and b.shift_indicator = 'P' group by d.position_desc, b.short_desc, trunc(a.schedule_date), trunc(a.schedule_date) - to_date(?,'dd/mm/yyyy') order by d.position_desc, shift_desc, sch_date";
			sql_wp_allocation_det="select d.position_desc, b.short_desc shift_desc, trunc(a.schedule_date) sch_date,(trunc(a.schedule_date) - to_date(?,'dd/mm/yyyy')) cell_no,sum(a.required_staff) required, sum(a.allocated_staff) allocated from rs_work_schedule_summ a, am_shift_lang_vw b, am_position_lang_vw d where a.facility_id =? and (? is null or a.workplace_code = ?) and a.schedule_date between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') and d.position_code = a.position_code and b.shift_code = a.shift_code and b.shift_indicator = 'P' and b.language_id = ? and d.language_id = b.language_id group by d.position_desc, b.short_desc, trunc(a.schedule_date), trunc(a.schedule_date) - to_date(?,'dd/mm/yyyy') order by d.position_desc, shift_desc, sch_date";

		pstmt_wp_allocation_det=con.prepareStatement(sql_wp_allocation_det);
		pstmt_wp_allocation_det.setString(1, new_from_date);
		pstmt_wp_allocation_det.setString(2, facility_id);
		pstmt_wp_allocation_det.setString(3, workplace_code);
		pstmt_wp_allocation_det.setString(4, workplace_code);
		pstmt_wp_allocation_det.setString(5, new_from_date);
		pstmt_wp_allocation_det.setString(6, new_to_date);
		pstmt_wp_allocation_det.setString(7, locale);
		pstmt_wp_allocation_det.setString(8, new_from_date);
		rs_wp_allocation_det=pstmt_wp_allocation_det.executeQuery();
		
			
%>


<! -- USH CHECK-OUT -->

<table border=0 width='99%' >
<tr>
<td width='13%' class=ush>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>

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

		<td  align="left" class="Day" width="13%" nowrap><b><fmt:message key="Common.Position.label" bundle="${common_labels}"/>/<fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input type='hidden' name='u1' id='u1' value='u1'>
		</td>
		
<%

for(int u=0;u<d_track;u++){%>
	
	<td class="Day" width="3.5%" title="<%=d_code2[u]%>" align='center'><%=d_code2[u]%>
	</td><input type='hidden' name='"<%=d_code2[u]%>"' id='"<%=d_code2[u]%>"' value='"<%=d_code2[u]%>"'>
	</td>		
<%}
for(int u=0;u<(14-d_track);u++){%>
	<td class="EmptyCell" width="3.5%" align="middle">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
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
	<td class="EmptyCell" width="3.5%" align='center'>&nbsp;&nbsp;&nbsp;</td>
<%}%>
</form>
</tr>
<form name='calender' id='calender'>
<%
String classval = "";
String borderc = "";
int cell=0;
String	wp_temp = "";
String wp = "";
String	sh_temp = "";
String sh = "";
int m[]=new int[14];
int n[]=new int[14];

int cell_no1[]=new int[100];
int hh=0;

if(rs_wp_allocation_det.next())
{
String flag  = "1";

wp = rs_wp_allocation_det.getString("position_desc");
sh = rs_wp_allocation_det.getString("shift_desc");
wp_temp = wp;
sh_temp = sh;

while(flag.equals("1"))
{		
	for(int q = 0; q<14; q++)
		cell_no1[q] = -1;
		%>
		<tr >
		<td class='WRKPChange' colspan=15 nowrap><b><%=wp_temp%>&nbsp;</b></td>
<%
	while (wp_temp.equals(wp) && flag.equals("1"))
	{ 
					for(int y = 0; y<14; y++)
					cell_no1[y] = -1;
				while (wp_temp.equals(wp) && sh_temp.equals(sh) && flag.equals("1"))
				{ 
					cell = Integer.parseInt(rs_wp_allocation_det.getString("cell_no"));

					cell_no1[cell]=cell;
					m[cell] = Integer.parseInt(rs_wp_allocation_det.getString("allocated"));
					n[cell] = Integer.parseInt(rs_wp_allocation_det.getString("required"));

					if (rs_wp_allocation_det.next())
					{
						sh = rs_wp_allocation_det.getString("shift_desc");
						wp = rs_wp_allocation_det.getString("position_desc");
					}
					else
					{
						flag = "0";		
					}
				}
				
				%>
				<tr >
					<td class='EmptyEven' width='3%' nowrap><b><%=sh_temp%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
			<%
			sh_temp=sh;
			
				for(int kkk=0;kkk<14;kkk++){
					
				if(cell_no1[kkk]==kkk ){
					if(m[kkk] == n[kkk])
						{
							classval	=	"OPTIMAL";
						}
						if(m[kkk] > n[kkk])
						{
							classval	=	"ABOVEOPTIMAL";
							
						}
						if(m[kkk] < n[kkk])
						{
							classval	=	"BELOWOPTIMAL";		
						}
						if(( m[kkk] == 0 ) && ( n[kkk] == 0 ))
						{
							classval	=	"DEFAULT";		
						}
		%>
				<td class=<%=classval%> width='3%' align='center' id=<%=kkk%> <%=borderc%> >&nbsp;<%=m[kkk]%>/<%=n[kkk]%>&nbsp;
					<%
						if(total[kkk]==0){
						total[kkk]=m[kkk];
						total11[kkk]=total11[kkk]+n[kkk];
				}
				else
					{
					total[kkk]=total[kkk]+m[kkk];
					total11[kkk]=total11[kkk]+n[kkk];
					}
					borderc = "";				
					}else{
						%>
				<td class="EmptyCell" id=<%=kkk%> width='3%'>&nbsp;&nbsp;
					<%				
					}
				}
			for(int kkk=0;kkk<14;kkk++){
				m[kkk] = 0;
				n[kkk] = 0;
					}
			
	}//wp loop
	wp_temp = wp;%>	
	</tr> <%
		hh++;		
	%><tr>
		<td class='Total'  nowrap><b><fmt:message key="eRS.TotalByPosition.label" bundle="${rs_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
		<%
		for(int kkk1=0;kkk1<14;kkk1++)
		{
		String disp=total[kkk1]+"/"+total11[kkk1];
			
		if(total[kkk1]!= 0 && total11[kkk1]!= 0){
						if(total[kkk1] == total11[kkk1])
						{
							classval	=	"OPTIMAL";
						}
						if(total[kkk1] > total11[kkk1])
						{
							classval	=	"ABOVEOPTIMAL";
							
						}
						if(total[kkk1] < total11[kkk1])
						{
							classval	=	"BELOWOPTIMAL";		
						}
						if(( total[kkk1] == 0 ) && ( total11[kkk1] == 0 ))
						{
							classval	=	"DEFAULT";		
							disp="&nbsp;";
						}
						%>
		<td class="<%=classval%>"  width='1%' align='center'>&nbsp;<%=disp%>&nbsp;</td>
		<% 
		}
		else{
					if(total[kkk1] == total11[kkk1])
						{
							classval	=	"OPTIMAL";
						}
						if(total[kkk1] > total11[kkk1])
						{
							classval	=	"ABOVEOPTIMAL";
							
						}
						if(total[kkk1] < total11[kkk1])
						{
							classval	=	"BELOWOPTIMAL";		
						}
						if(( total[kkk1] == 0 ) && ( total11[kkk1] == 0 ))
						{
							classval	=	"EmptyCell";	
							disp="&nbsp;";
						}		%>
				<td width='3%' align='center' class="<%=classval%>" id=<%=kkk1%> > &nbsp; <%=disp%> &nbsp;
					<%			
						}
		}
		%> 
			</tr>
			<%
		for(int tt=0;tt<=14;tt++)
	{
			total[tt]=0;
			total11[tt]=0;
	}
}
}
	if(pstmt_wp_allocation_det != null)
		pstmt_wp_allocation_det.close();
	if(rs_wp_allocation_det != null)
		rs_wp_allocation_det.close();

	%>
</form>
<script>
parent.parent.frames[2].frames[0].document.forms[0].p_from_date.value='<%=new_from_date%>'
parent.parent.frames[2].frames[0].document.forms[0].p_to_date.value='<%=new_to_date%>'
parent.parent.frames[2].frames[0].document.forms[0].p_end.value='<%=end_ind%>'
</script>
</body>
<%
}
catch(Exception e) 
{
	e.printStackTrace();
} 
	finally{
		if(statement2 != null)
			statement2.close();
		if(pstmt_wp_allocation_det != null)
			pstmt_wp_allocation_det.close();
		if(rs_wp_allocation_det != null)
			rs_wp_allocation_det.close();
	
		ConnectionManager.returnConnection(con,request);	
	}
%>
</html>

