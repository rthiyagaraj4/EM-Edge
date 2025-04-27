<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*,javax.servlet.jsp.*,java.util.*"   contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
<% 
	Connection connection			=	null;
	PreparedStatement pStatement	=	null;
	ResultSet		resultSet		=	null;
	try
	{
     	request.setCharacterEncoding("UTF-8");

		String locale=(String)session.getAttribute("LOCALE"); 
		String	 facilityId 			= (String) session.getValue( "facility_id" ) ;
		String area_code			= checkForNull(request.getParameter("area_code"));
		String bed_no				= checkForNull(request.getParameter("bed_no"));
		String bed_status		= checkForNull(request.getParameter("bed_status"));
		String disable			    = checkForNull(request.getParameter("disable"));
		String patient_id			    = checkForNull(request.getParameter("patient_id"));
		String where_condition= checkForNull(request.getParameter("where_condition"));
	
     
		connection					= (Connection)ConnectionManager.getConnection(request);
		String sqlString			=	"";  
		String code					=	"";   
		String desc					=	"";	  
		String selectValue			=	"";
        String disabled="";
		String sStyle	=
        (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
        <script language='javascript' src='../../eMO/js/MOBayAvailability.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		
	</head>

	<body onMouseDown="CodeArrest();" onLoad='loadMortArea();' onKeyDown = 'lockKey();'>
	<form name='MOBedAvailChartForm' id='MOBedAvailChartForm' action = "../../eMO/jsp/MOBayAvailabilityChartResult.jsp" target='result1' >
	<table cellpadding="0" cellspacing="0" border="0" width="97%" align = "center">
	<tr width="100%">
	<td width="25%" class="LABEL"><fmt:message key="Common.area.label" bundle="${common_labels}"/>
	</td>
	<td width="25%" class="QUERYDATA">

	<%if (bed_status.equals("V")&&disable.equals("yes"))
	 {disable="disabled";%>
	 <input type=hidden  name='bed_status' id='bed_status' value='<%=bed_status%>'>	
	 <%}else if (bed_status.equals("BL")&&disable.equals("yes"))
	 {disable="disabled";%>
	 <input type=hidden  name='bed_status' id='bed_status' value='<%=bed_status%>'>	
	<%}%>

	<%if (!area_code.equals(""))
				{disabled="disabled";%>
				 
			<input type=hidden  name='area_code' id='area_code' value='<%=area_code%>'>	
				<%}%>

	<select name="area_code" id="area_code"  <%=disabled%>  >

	<option value="">--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
	<%
		
		sqlString	= "select area_code,LONG_DESC from mo_area_lang_vw where LANGUAGE_ID='"+locale+"' and facility_id = '"+facilityId+"' AND eff_status='E' order by 2 ";	
        pStatement	= connection.prepareStatement(sqlString);
		resultSet	=	pStatement.executeQuery();

		if (resultSet != null)
		{
			while(resultSet.next())
			{
				code = checkForNull(resultSet.getString("area_code"));
				desc = checkForNull(resultSet.getString("LONG_DESC"));
			
				if (area_code.equals(code))
				{
				%>
				
				<option value="<%=code%>" selected ><%=desc%></option>
				
				<%
				}
				else
				{
				%>
				<option value="<%=code%>" ><%=desc%></option>
				<%
				}
			}
			 
		}   if (resultSet != null)	resultSet.close();
		    if (pStatement != null)	pStatement.close();
	
	%>
	</select>
	</td>
	
	<td width="25%" class="LABEL"><fmt:message key="eMO.LocationStatus.label" bundle="${mo_labels}"/>
	</td>
	<td width="25%" class="QUERYDATA"><select name="bed_status" id="bed_status"  <%=disable%>>
	<option value="B" <%=selectValue%> ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<%
			if(bed_status.equals("O"))
				selectValue  = "Selected";
			else
				selectValue  = "";
		%>
	<option value="O" <%=selectValue%> ><fmt:message key="Common.Occupied.label" bundle="${common_labels}"/></option>
	<%
			if(bed_status.equals("V"))
				selectValue  = "Selected";
			else
				selectValue  = "";
		%>
	<option value="V" <%=selectValue%> ><fmt:message key="Common.Vacant.label" bundle="${common_labels}"/></option>
		<%
			if(bed_status.equals("X"))
				selectValue  = "Selected";
			else
				selectValue  = "";
		%>
      <%
			if(bed_status.equals("BL"))
				selectValue  = "Selected";
			else
				selectValue  = "";
		%>
    <option value="BL" <%=selectValue%> ><fmt:message key="Common.blocked.label" bundle="${common_labels}"/></option>
		
	</select>
	</td>
	</tr>	
	</table>
	<br>
	<table cellpadding="0" cellspacing="0" border="0" width="14.0%" align="right">
	<tr>
	<td class='white'><input type="Button" name="search" id="search" value = '<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="BUTTON" onClick="getBedDetails();"><input type="Button" name="clear" id="clear" value = '<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class="BUTTON" onclick="clearContent();"></td>
	</tr>
	</table>
	
	<input type="Hidden" name="bed_no" id="bed_no" value="<%=bed_no%>">
	<input type="Hidden" name="where_condition" id="where_condition" value="<%=where_condition%>">
	<input type="Hidden" name="bed_patient_id" id="bed_patient_id" value="<%=patient_id%>">
	
	</form>
	</body>
<%
	  if (resultSet != null)	resultSet.close();
	  if (pStatement != null)	pStatement.close();
	}
	catch(Exception exception)
	{
		out.println("Exception in MOBayAvailabilityChartCriteria0 " + exception.toString());
		exception.printStackTrace();
	}
	finally
	{
	   ConnectionManager.returnConnection(connection, request);
	}
%>
</html>
<%!

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%> 

