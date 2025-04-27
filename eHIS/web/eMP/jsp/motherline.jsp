<!DOCTYPE html>
<!-- Last Modified Date Time : 10/4/2005 10:01 AM --> 

<html>

<%@ page contentType="text/html; charset=UTF-8" import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.util.StringTokenizer, webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
		request.setCharacterEncoding("UTF-8");
		Connection con			= null;
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;

		con = ConnectionManager.getConnection(request);

		String motherid		= request.getParameter("mother_id") == null ? "" : request.getParameter("mother_id");
		String encounterid	= request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
		String nursingunit	= request.getParameter("nursing_unit") == null ? "" : request.getParameter("nursing_unit");

		if(!encounterid.equals("")) encounterid = "Encounter ID :"+encounterid;
		if(!nursingunit.equals("")) nursingunit = "Nursing Unit :"+nursingunit;
		%>
	</head>
	<body onKeyDown = 'lockKey()'>
		<%
			String name				= "";
			String id				= "";
			String op_install_yn	= "";
			String pid				= "";

			try
			{
				pstmt = con.prepareStatement("SELECT install_yn FROM sm_module WHERE module_id = 'OP'");
				rs = pstmt.executeQuery();
				if(rs != null && rs.next())
				{
					op_install_yn = rs.getString(1);
					if(op_install_yn == null) op_install_yn = "";
				}
			}
			catch(Exception ex)
			{
				out.println(ex.toString());
			}
		
			try
			{
				String strToken = "";

				if(op_install_yn.equals("Y"))
				{
					pstmt = con.prepareStatement("SELECT get_patient.get_line_detail('"+motherid+"','"+localeName+"') Pline FROM dual");

					strToken = "|";
					rs = pstmt.executeQuery();

					if(rs != null)
					{
						if(rs.next())
						{
							String s = rs.getString("Pline");
							StringTokenizer token = new StringTokenizer(s,strToken);
							while(token.hasMoreTokens())
							{
								name	= token.nextToken();
								id		= token.nextToken();
							}
						}
					}
					pid = motherid;
				}
				else
				{
					pstmt = con.prepareStatement("SELECT get_patient_line('"+motherid+"','"+localeName+"') Pline FROM dual");	

					strToken = ",";
					rs = pstmt.executeQuery();
					if(rs != null)
					{
						if(rs.next())
						{
							String s				= rs.getString("Pline");
							StringTokenizer token	= new StringTokenizer(s,strToken);
							while(token.hasMoreTokens())
							{
								name += token.nextToken();
							}
						}
						name = name.substring(0,name.length()-6);
					}
					pid = "";
				}
			}
			catch(Exception e){out.println(e.toString());}
			finally
			{
				if(pstmt!=null)	pstmt.close();
				if(rs!=null)	rs.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);
  			}
		%>
		<form name="f" id="f">
		<table  width='100%' height='100%' style="" border=0 valign='top' CELLSPACING=0 CELLPADDING=0>
			<tr>
				<td colspan=2 align=left class='PATIENTLINECOLOROTHLANG' nowrap>
				<FONT size='2'><b><%=name+", "+pid%></td>
			</tr>
			<tr>
				<td align=left class='PATIENTLINECOLOROTHLANG' nowrap>
				<font size='-1'><%=encounterid%></td>
				<td  align=right class='PATIENTLINECOLOROTHLANG' nowrap>
				<font size='-1'><%=nursingunit%></td>
			</tr>
		</table> 
		<input type="hidden" name="mother_name_age_gender" id="mother_name_age_gender" value="<%=name%>">
	</form>
	</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

