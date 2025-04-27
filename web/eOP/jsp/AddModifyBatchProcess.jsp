<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");

	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	String module_id = request.getParameter("module_id");
	String bl_install_yn = (String) session.getValue("bl_operational");
	if(module_id==null) module_id=""; 
	String facility_id=(String) session.getValue("facility_id");	

%>
 <html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src="../../eCommon/js/common.js"></script>
	<script src="../../eOP/js/BatchProcess.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' onload='FocusFirstElement()' onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>

<%
	
		
		String bl_interfaced_yn="";
		String allow_chkout_with_bill_stmt_yn = "";

		
		Connection con=null;
		ResultSet rset= null;
		Statement stmt = null;

		try
		{
			con=ConnectionManager.getConnection(request);
			stmt = con.createStatement();

			if(module_id.equals("OP")) {			
				rset=stmt.executeQuery("Select BL_INTERFACED_YN bl_interfaced_yn from op_param where OPERATING_FACILITY_ID='"+facility_id+"'");
			}
			else if(module_id.equals("AE")) {				
				rset=stmt.executeQuery("Select BILLING_INTERFACED_YN bl_interfaced_yn,allow_chkout_with_bill_stmt_yn from AE_PARAM where OPERATING_FACILITY_ID='"+facility_id+"'");
			}			

			if (rset!=null)
			{
				if (rset.next())
				{
					bl_interfaced_yn=rset.getString("bl_interfaced_yn");
					if(module_id.equals("AE")) {
						allow_chkout_with_bill_stmt_yn = rset.getString("allow_chkout_with_bill_stmt_yn");
						allow_chkout_with_bill_stmt_yn = (allow_chkout_with_bill_stmt_yn==null)?"N":allow_chkout_with_bill_stmt_yn; 
					}
				}
			}

		}catch(Exception e) { out.println(e.toString()); e.printStackTrace();}
		finally
		{
			if (stmt != null) stmt.close();
			if (rset != null) rset.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		} 
%>
	<center>
		<form name = 'form1' method=post action='../../servlet/eOP.BatchProcessServlet' target=messageFrame >
		<br>
			<table border='0' cellpadding='0' cellspacing='0' width='80%' align='center'>

				<tr><td colspan='4'>&nbsp;</td></tr>
							
				<tr>
					<td class='label' width='30%' colspan='2'><fmt:message key="Common.Process.label" bundle="${common_labels}"/></td>
					<td  width='50%' class='fields' colspan='2'><select name='opt' id='opt' onchange='callme(this,"<%=bl_interfaced_yn%>","<%=bl_install_yn%>","<%=allow_chkout_with_bill_stmt_yn%>")'><option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
							bundle="${common_labels}"/> --------&nbsp;</option>
							<option value='V'><fmt:message key="eOP.AutoCompleteVisits.label" bundle="${op_labels}"/></option>
				           <%if(module_id.equals("OP"))
				                    {
				                   %>
							<option value='E'><fmt:message key="eOP.AutocloseEpisodes.label" bundle="${op_labels}"/></option>
									   <%}%>
						</select><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
						<input type='hidden' name='cutoff_date' id='cutoff_date' >	
						<input type='hidden' name='service_code' id='service_code'>
						<input type='hidden' name='module_id' id='module_id' value='<%=module_id%>'>
				</tr>		
				
				<tr><td colspan='4'>&nbsp;</td></tr>

			</table>
			
			
		</form>
	</center>
</body>
</html>

