<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMRequestFile.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<FORM name = 'fm_requestee_form'>
<%
	Connection con = null;
	java.sql.Statement stmt		= null;	
	ResultSet rs						= null;	

	String p_check_fcy				= request.getParameter("p_print_enter_fcy");
	String p_selected_fcy			= request.getParameter("selected_fcy");
	String disabled_selected_fcy	= request.getParameter("disabled_selected_fcy");
	String p_chosen_fcy				= request.getParameter("p_chosen_fcy");
	String reset_mode				= request.getParameter("reset_mode");
	String doc_or_file					= request.getParameter("doc_or_file")==null?"F":request.getParameter("doc_or_file");	
   String p_flag=	request.getParameter("p_flag");
	if(p_check_fcy == null) p_check_fcy = "N";
	if(p_flag == null) p_flag = "";
	if(p_selected_fcy == null) p_selected_fcy = "";
	if(disabled_selected_fcy == null) disabled_selected_fcy = "";
	if(p_chosen_fcy == null)
	{
		p_chosen_fcy = "L";
		p_selected_fcy = "YN";
		disabled_selected_fcy ="disabled";
	}
	if(reset_mode==null) reset_mode="";

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		String facilityid	= (String) session.getValue("facility_id");

		String sql			= "";	
		String p_function	= "insert";
		String p_code		= "";
		String p_desc		= "";
    	if(p_flag.equals("") && p_chosen_fcy.equals("E"))
		{
		sql = " select facility_id,SM_GET_DESC.SM_FACILITY_PARAM(facility_id,'"+localeName+"','1') facility_name from sm_facility_param where facility_id <> '"+facilityid+"'   order by facility_name " ;
		rs = stmt.executeQuery(sql);
		
		}
	%>
	<TABLE border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
		<TR><Td colspan='4' class='COLUMNHEADER'><fmt:message key="eFM.RequestTo.label" bundle="${fm_labels}"/></Td></TR>
		<TR>
			<TD width='25%' class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></TD>
			<TD width='25%' class='fields'>
			<select name=logged_fcy onChange="javascript:log_ent_fcy('<%=p_selected_fcy%>')" <%=disabled_selected_fcy%> <%=reset_mode%>>

			<% if(p_selected_fcy.equals("YN")) { %>
				<option value='L' selected><fmt:message key="Common.loggedinfacility.label" bundle="${common_labels}"/></option>

			<% } else if(p_selected_fcy.equals("NY")) { %>
				<option value='E' selected><fmt:message key="Common.enterprisefacility.label" bundle="${common_labels}"/></option>

			<% }
				else
				{ 
					if(p_chosen_fcy.equals("L"))
					{
						%>
						<option value='L' selected><fmt:message key="Common.loggedinfacility.label" bundle="${common_labels}"/></option>
						<option value='E' ><fmt:message key="Common.enterprisefacility.label" bundle="${common_labels}"/></option>
						<%
					}
					else
					{
						%>
						<option value='L' ><fmt:message key="Common.loggedinfacility.label" bundle="${common_labels}"/></option>
						<option value='E' selected><fmt:message key="Common.enterprisefacility.label" bundle="${common_labels}"/></option>
						<%
					}
				}
				%>
				</select>
			</TD>
			
		<%
		if(p_check_fcy.equals("N"))
		{
			%>
				<TD width = '25%'   ></TD>
				<TD width = '25%'    ></TD>
			<%
		}
		else
		{
			%>
			<TD width='25%' class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></TD>	
			<TD width ='25%'  class= 'fields'>
				<select name=enter_fcy onChange="getExternalFiles(this.value)">
				<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
				<%
				if(p_flag.equals(""))
			{
			
			  while(rs.next())
				{
					p_code = rs.getString("facility_id");
					p_desc = rs.getString("facility_name");

					if(facilityid.equals(p_code))
					{
						%>
						<option value='<%=p_code%>' selected><%=p_desc%></option>
						<%
					}
					else
					{
						%>
						<option value='<%=p_code%>' ><%=p_desc%></option>
						<%
					}
				}
				
			}
				if(rs!=null)	rs.close();
				%>
				</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
				</TD>
			</TR>
			<%
		}
		%>
	</TABLE>
	<input type='hidden' name=functionval value='<%=p_function%>'>
	<input type='hidden' name=doc_or_file value='<%=doc_or_file%>'>
	</FORM>
<%
if(stmt!=null) stmt.close();
}
catch(Exception e)
{
	out.println("Exception e :"+e);
}
finally
{		
	ConnectionManager.returnConnection(con,request);
}
%>
</BODY>
</HTML>


<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

