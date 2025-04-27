<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8"%>

<%	
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection con =null;
	Statement stmt=null;
	ResultSet rs =null;
	String param = checkForNull(request.getParameter("param"));
	if(param == null) param = "";
	String facilityID=(String)session.getValue("facility_id");
	
	try{
		con = ConnectionManager.getConnection(request);
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	
	<script src='../js/NursUnitPhysLocn.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

</script>
</head>
<%if(param.equals("create")){%>
	<body onLoad='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%}else{%><body onMouseDown="CodeArrest()" onKeyDown="lockKey()"><%}%>	

<form name='physical_location' id='physical_location' action='../../servlet/eIP.NursUnitPhysLocnServlet' method='post' target='messageFrame'>
<div align='left'>
<BR><BR><BR><BR><BR><BR><BR><BR>
  <table border='0' cellpadding='0' cellspacing='0' width='55%' align='center'>

	<tr>
		<td width="40%" >&nbsp;</td>
  		<td width="60%" colspan="2">&nbsp;</td>
	</tr>

    	<tr>
	 	 <td width='40%'  class='label'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
	  	<% 
	  	try{
		if(param.equals("create")){%>
	  	<td width='60%' align='left' colspan='2'><%
		}
		else{
		%>
	  	<td width='60%' align='left' colspan='2'><%
		}
		if(param.equals("create")) {%>
		<jsp:include page="NursingUnitComponent.jsp" ><jsp:param name="flush" value="true" /></jsp:include><%out.println("<img src='../../eCommon/images/mandatory.gif'></img>");
		}else
		{
			String nursing_unit_code = checkForNull(request.getParameter("nursing_unit_code"));

			String nursing_unit_desc = checkForNull(request.getParameter("nursing_unit_desc"));
		%><input type='hidden' name='nursing_unit' id='nursing_unit' value="<%=nursing_unit_code%>" >
			<input type='text' name='nursing_unit1' id='nursing_unit1' value="<%=nursing_unit_desc%>" readonly >&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>

		<% } %>
	  	</td>
		</tr>

	<tr>
		<td width="40%" >&nbsp;</td>
  		<td width="60%" colspan="2">&nbsp;</td>
	</tr>
	<tr>
	 	<td width='40%'  class='label'><fmt:message key="Common.building.label" bundle="${common_labels}"/></td>
		<td width='60%' align='left' colspan='2'><% if(param.equals("create")) {%> 
		<select name='building' id='building' onChange='validate(this)'><option value='' selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<%		
	       		stmt = con.createStatement();
				StringBuffer sql1 = new StringBuffer();
				sql1.append("Select bldng_code,short_desc  from am_bldng where operating_facility_id='"+facilityID+"'  and eff_status='E' order by short_desc ");
	       		rs = stmt.executeQuery(sql1.toString());

	      if( rs != null )
	      {
	          while( rs.next() )
	          {
				String classcode = checkForNull(rs.getString( "bldng_code" ));
				String classname = checkForNull(rs.getString( "short_desc" ));
%>
				<OPTION VALUE="<%= classcode %>" ><%= classname %>
<%
	          }
	      }
%>
</select><img src='../../eCommon/images/mandatory.gif'></img>
	<% 
		}else
		{ 
			String building_desc = checkForNull(request.getParameter("building_desc"));
			String building_code = checkForNull(request.getParameter("bldng_code"));
	%>
			<input type='hidden' name='building' id='building' value="<%=building_code%>" >
			<input type='text' name='building1' id='building1' value="<%=building_desc%>" readonly ><img src='../../eCommon/images/mandatory.gif'></img>
		<% } %>
</td>
</tr>
	<tr>
		<td width="40%" >&nbsp;</td>
  		<td width="60%" colspan="2">&nbsp;</td>
	</tr>
	<tr>
	 	<td width='40%'  class='label'><fmt:message key="Common.floor.label" bundle="${common_labels}"/></td>
		<td width='60%' align='left' colspan='2'><% if(param.equals("create")) {%>
		<select name='floor' id='floor'><option value='' selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</select><img src='../../eCommon/images/mandatory.gif'></img>
	<% }else
		{
			String floor_code = checkForNull(request.getParameter("floor_code"));
			String floor_desc = checkForNull(request.getParameter("floor_desc"));
		%>
			<input type='hidden' name='floor' id='floor' value="<%=floor_code%>" >
			<input type='text' name='floor1' id='floor1' value="<%=floor_desc%>" readonly ><img src='../../eCommon/images/mandatory.gif'></img>
		<% } %>
	</td>
</tr>
	<tr>
		<td width="40%" >&nbsp;</td>
  		<td width="60%" colspan="2">&nbsp;</td>
	</tr>
	
</table>
</div>
<% if(param.equals("create")) {%>
<input type='hidden' name='function' id='function' value='insert'>
<input type='hidden' name='function_name' id='function_name' value='insert'>
<% } else { %>
<input type='hidden' name='function' id='function' value='delete'>
<input type='hidden' name='function_name' id='function_name' value='delete'>
<% } %>
<input type='hidden' name='eff_date_from' id='eff_date_from' >
<input type='hidden' name='eff_date_to' id='eff_date_to' >
<input type='hidden' name='operating_facility_id' id='operating_facility_id' value="<%=facilityID%>" >
</form>

<%	if ( stmt != null ) stmt.close() ;
	if ( rs != null ) rs.close() ;
}
catch ( Exception e ){
	//out.println(e.toString());
	e.printStackTrace();
	}
}catch(Exception e){
	//out.println("Exception in tryCatch : "+ e.toString());
	e.printStackTrace();
	}
finally
 {
	 ConnectionManager.returnConnection(con,request);
 }
%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>
</body>
</html>

