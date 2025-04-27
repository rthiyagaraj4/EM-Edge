<!DOCTYPE html>
<!-- Program for to search the Clinic -->

<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%	
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	Statement stmt=null;
	ResultSet rs =null;
	String called_from=request.getParameter("called_from");
	String facility_id=(String)session.getValue("facility_id");


try{
%>
<html>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../js/FMFileTypeforFSLocn.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onLoad='ChkFileLocn()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
<form name='Search_form' id='Search_form'>
  <table border='0' cellpadding='3' cellspacing='0' width='90%' align='center'>
		<tr><td colspan='4' class='label'>&nbsp;</td></tr>
		<tr><td colspan='4' class='label'></td></tr>
	 <tr>
	  	<td width="20%" class='label'><fmt:message key="Common.FileStorageLocation.label" bundle="${common_labels}"/></td>
		 <td class='fields' id=td5>
		 <%
			/*if(count>15) commented this condition and made true always to get through search and
			left the else part as it is for future modification. */
		
			if(true)
			{	 
		 %>
			 <select name="fs_locn_code" id="fs_locn_code" onChange='PopulateValues(this)'>
				<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option>
				 <%
				 con = ConnectionManager.getConnection(request);
				 stmt=con.createStatement();
				 String sql="select short_desc,fs_locn_code from fm_storage_locn where eff_status='E' and facility_id='"+facility_id+"' order by short_desc ";	
				 rs=stmt.executeQuery(sql);
				 
					if(rs!=null)
					{
					   while(rs.next())
					   {%>
						<option value='<%=rs.getString("fs_locn_code")%>'><%=rs.getString("short_desc")%></option>
					 <%}
					}
					
				%>
			 </select>
			<img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
		<%
			}
			%>
		<td></td>
		<td ><input type=button class=button value='Search' name='Search' id='Search' onclick='PopulateResult()' ></td>		
   	</tr>
	<table border='0' cellpadding='3' cellspacing='0' width='90%' align='center' id=tab style='visibility:hidden'>
	<tr>
	<td class=label width='20%'><fmt:message key="eFM.ClinicType.label" bundle="${fm_labels}"/></td>
	<td  class=label id=td1 width='30%'></td>
	<td class=label  width='20%'><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
	<td  class=label id=td2 width='30%'></td>
	</tr>
	<tr>
		<td class=label ><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/></td>
		<td  class=label id=td3></td>
		<td class=label ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		<td  class=label id=td4></td>
	</tr>
	<tr>
		<td class=label><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td  class=label id=td6></td>
		<td></td>
		<td></td>
	</tr>

<input type=hidden name=called_from value='<%=called_from%>'>
<input type=hidden name=facility_id value='<%=facility_id%>'>
</form>
<%
if ( stmt != null ) stmt.close() ;
if ( rs != null ) rs.close() ;
}
catch ( Exception e ){out.println(e.toString());}
finally
	{		
		ConnectionManager.returnConnection(con,request);
	}

%>
</body>
</html>

