<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% 
Connection con=null;
try{
	  request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
	Statement stmt=con.createStatement();
	ResultSet rs=null;
	String Module_Id = request.getParameter("Module_ID")==null ? "" : request.getParameter("Module_ID");
	String Report_Id = request.getParameter("Report_ID")==null ? "" : request.getParameter("Report_ID");
	String Facility_Id = request.getParameter("Facility_ID")==null ? "" : request.getParameter("Facility_ID");
	String Report_Desc ="";
	String Report_Group_Id = "";
	String Facility_Name ="";
	String Module_Name="";

	String sql="Select * from Sm_Report_For_Fcy_Vw where Module_Id='" + Module_Id + "' and Report_Id='" + Report_Id + "' and  Facility_Id='" + Facility_Id + "'";	
	
	rs = stmt.executeQuery(sql);	
	if(rs !=null) {
		if(rs.next()) {
			Module_Name = rs.getString("Module_Name");
			Report_Desc = rs.getString("Report_Desc");
			Report_Group_Id = rs.getString("Report_Group_Id");
			Facility_Name =rs.getString("Facility_Name");
		}
	}	
%>	
<html>
	<head>
		<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
	<body  onMouseDown="CodeArrest()" onload='FocusFirstElement()'; onKeyDown = 'lockKey()'; >
	<form name="report_for_facility" id="report_for_facility" action="../../servlet/eSM.ReportForFacilityServlet" method="post" target="messageFrame">
	<center>
	<br><br><br><br><br><br><br><br><br><br>
 		<table border="0" cellpadding="0" cellspacing="0" width="auto">
 		<tr>
			<td width='10%'>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td width='10%'>&nbsp;</td>
		</tr>

			<tr>
				<td>&nbsp;</td>
				<td class="label"><!--width="40%"--><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
				<td class='fields'><!-- width="60%"--><input type="text" name="Module_name" id="Module_name" size="30" maxlength="30" value="<%=Module_Name%>" readonly>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
				<input type="hidden" name="Module_Id" id="Module_Id"  value="<%=Module_Id%>" readonly>
				</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>

  			<tr>
  				<td>&nbsp;</td>
  				<td class="label"><!--width="40%"--><fmt:message key="Common.report.label" bundle="${common_labels}"/></td>
  		    		<td class='fields'><!-- width="60%"--><input type="text" name="Report_Desc" id="Report_Desc" size="30" maxlength="30" value="<%=Report_Desc%>" readonly>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
  		    		<td>&nbsp;</td>
  			</tr>
  			<tr>
  				<td>&nbsp;</td>
  				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>

  			<tr>
  				<td>&nbsp;</td>
  				<td class="label"><!--width="40%"--><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
  		    		<td><!--width="60%"--><input type="text" name="Facility_Name" id="Facility_Name" size="70" maxlength="35" value="<%=Facility_Name%>" readonly>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
  		    		<td>&nbsp;</td>
  			</tr>
  			<tr>
  				<td>&nbsp;</td>
  				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>

			<tr>
				<td>&nbsp;</td>
    				<td class="label"><!-- width="28%"--><fmt:message key="eSM.ReportGroup.label" bundle="${sm_labels}"/></td>
    				<td class='fields'><!-- width="20%"--><Select name="Report_Group_Id" id="Report_Group_Id">
				<Option value="">------------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------
    					<%
    					
						if(rs!=null)rs.close();

						rs = stmt.executeQuery("Select Report_Group_Id,Short_Desc from Sm_Report_Group where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by short_desc" );
						if(rs!=null) {
							while(rs.next())	{								
								if(Report_Group_Id.equals(rs.getString("Report_Group_Id"))) 
									out.println("<Option value='" + rs.getString("Report_Group_Id") + "' selected>" + rs.getString("Short_Desc"));
								else 	
									out.println("<Option value='" + rs.getString("Report_Group_Id") + "'>" + rs.getString("Short_Desc"));
							}
						}
				%>
    					</Select>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
    				<td>&nbsp;</td>	
    			</tr>
    			<tr>
    				<td>&nbsp;</td>
    				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>

			      	<%
	         			if( rs != null) rs.close();
						if( stmt != null) stmt.close();
	         			
	      			%>
					<input type="hidden" name="function" id="function" value="modify">
					<input type="hidden" name="function_name" id="function_name" value="modify">
					<input type="hidden" name="Report_Id" id="Report_Id" size="30" maxlength="30" value="<%=Report_Id%>">
					<input type="hidden" name="Facility_Id" id="Facility_Id" size="30" maxlength="30" value="<%=Facility_Id%>">
		</table></center>			
	</form>
</body>
</html>
<%
}catch(Exception e){out.println(e);}
finally { 
	ConnectionManager.returnConnection(con,request);
}						
%>

