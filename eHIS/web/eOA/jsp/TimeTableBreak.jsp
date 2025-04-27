<!DOCTYPE html>
 
<!--
	Developed by 	:	R.Nanda Kumar
	Created on 	:	17/02/2001
	Module		:	OA
	Function	:	This function is used to maintain Break Time
				of the Time Table Function.
-->
 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%
		Connection con = null;
		Statement stmt   	= null ;
		ResultSet rs	   	= null;
try {
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
		con = ConnectionManager.getConnection(request);
		 stmt   	= con.createStatement() ;
		String fac_id    	= (String) session.getValue( "facility_id" ) ;
		String p_clinic_code	= request.getParameter("clinic_code") ;
		String p_pract_id	= request.getParameter("pract_id") ;if(p_pract_id == null || p_pract_id.equals("null")) p_pract_id="";
		String p_day_no		= request.getParameter("day_no") ;
		String p_disp		= request.getParameter("disp") ;
		StringBuffer sql		=new StringBuffer() ;

		if (p_disp.equals("M"))
		{
			sql 	= sql.append("select to_char(break_start_time,'hh24:mi')start_time,to_char(break_end_time,'hh24:mi')end_time from oa_clinic_break where clinic_code = '"+p_clinic_code+"' and ");
			sql=sql.append( "day_no = '"+p_day_no+"' and nvl(practitioner_id,'X') = nvl('"+p_pract_id+"','X') and facility_id = '"+fac_id+"' order by 1,2 ") ;
			rs	= stmt.executeQuery(sql.toString()) ;
		}

%>

	<HTML>
	<HEAD>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"> </link>
	 --><%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/dchk.js"> </script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"> </script>
	<script language="javascript" src="../../eCommon/js/common.js"> 		</script>
	<script language="javascript" src="../../eOA/js/TimeTable.js">		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</HEAD>
	<BODY OnMouseDown="CodeArrest()"onKeyDown = 'lockKey()' >
	<FORM name="TimeTableBreak" id="TimeTableBreak">



	<TABLE WIDTH='100%' CELLPADDING='0' CELLSPACING='0' BORDER='0'>
	<TR>
	<TD CLASS='BORDER'>
	<TABLE WIDTH='250%' CELLPADDING='0' CELLSPACING='0' BORDER='0'  ALIGN='CENTER'>
		<TR>
			<TD class='BORDER'>
				<TABLE WIDTH='100%' CELLPADDING='0' CELLSPACING='0' BORDER='0' ALIGN='CENTER'>
					<TH align='left'>Break Time</TH>
				</TABLE>
			</TD>
		</TR>
	</TABLE>

	<TABLE WIDTH='100%' CELLPADDING='0' CELLSPACING='0' BORDER='0'  ALIGN='CENTER'>

		<TR>
			<TD class="label" align='right' width='34%'>&nbsp;&nbsp;</TD>
			<TD class="label" align='left' width='10%' >&nbsp;&nbsp;&nbsp;From Time</TD>
			<TD class="label" align='right' width='10%'>&nbsp;</TD>
			<TD class="label" align='left' width='46%' >&nbsp;&nbsp;&nbsp;To Time </TD>
		</TR>

	</TABLE>
<%
		if (p_disp.equals("A"))
		{
%>
		<TABLE WIDTH='100%' CELLPADDING='0' CELLSPACING='0' BORDER='0'  ALIGN='CENTER'>
		<%
			int i = 1;
			for( i=1;i<6;i++)
			{
		%>

			<TR>
			<TD class="label" align='right' width='34%'>&nbsp;&nbsp;</TD>
			<TD class="label" align='left' width='10%' >&nbsp;&nbsp;
			<INPUT TYPE=TEXT SIZE=5 MAXLENGTH=5 name='b_from_time<%=i%>' id='b_from_time<%=i%>'
			onKeyUp='javascript:formatBreakFrToTime("<%=i%>")'
			onBlur='ChkTime(this);CallFromBreakTimeValidation(this,
			<%=i%>); '></TD>

			<TD class="label" align='right' width='10%'>&nbsp;</TD>
			<TD class="label" align='left' width='46%' >&nbsp;&nbsp;
			<INPUT TYPE=TEXT SIZE=5 MAXLENGTH=5 name='b_to_time<%=i%>' id='b_to_time<%=i%>' 
			onKeyUp='javascript:formatBreakFrToTime("<%=i%>")'
			onBlur='validateBkTime("document.forms[0].b_from_time<%=i%>",this,<%=i%>);' ></TD>
			</TR>
		<%
			}
		%>
		</TABLE>
<%
	}
	else if (p_disp.equals("M"))
	{

%>
		<TABLE WIDTH='100%' CELLPADDING='0' CELLSPACING='0' BORDER='0'  ALIGN='CENTER'>
		<%
			int i = 1;
			String fr="";
			String to="";
			boolean bool=true;
			for( i=1;i<6;i++)
			{
		%>
				<TR>
				<TD class="label" align='right' width='33%'>&nbsp;&nbsp;</TD>
				<TD class="label" align='left' width='10%' >&nbsp;&nbsp;
				<%
					   if(bool  && rs.next())
					   {
					   	fr=rs.getString("start_time");
					   	to=rs.getString("end_time");
						
					   }
					   else
					   {
					   	fr="";
					   	to="";
					   	bool=false;
					
					   }
						%>
					 <INPUT TYPE=TEXT SIZE=5 MAXLENGTH=5 name='b_from_time<%=i%>' id='b_from_time<%=i%>' VALUE='<%=fr%>'
						onKeyUp='javascript:formatBreakFrToTime("<%=i%>")'
					 onBlur='ChkTime(this);CallFromBreakTimeValidation(this,<%=i%>);'></TD>

					 <TD class="label" align='right' width='10%'>&nbsp;</TD>
					 <TD class="label" align='left' width='45%' >&nbsp;&nbsp;
					 <INPUT TYPE=TEXT SIZE=5 MAXLENGTH=5 name='b_to_time<%=i%>' id='b_to_time<%=i%>' VALUE='<%=to%>'	
					 onKeyUp='javascript:formatBreakFrToTime("<%=i%>")'onBlur='validateBkTime("document.forms[0].b_from_time<%=i%>",this,<%=i%>);'></TD>
					 </TR>
			<%
				}
			%>

			</TABLE>
	<%}%>
		<input type='hidden' name='mode' id='mode' value='<%=p_disp%>'>
<%
	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
}
catch( Exception e ){
//out.println(e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
</TD>
</TR>
</TABLE>
</FORM>
</BODY>
</HTML>

