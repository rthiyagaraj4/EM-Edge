<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script language='javascript' src='../../eMP/js/PatientSeriesGroupForUser.js'></Script> 
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title>
</title>
</head>
<%
	Connection con=null;
	Statement stmt=null;
	ResultSet rSet=null;
	String patcode="";
	String shortdesc="";
	try{
		request.setCharacterEncoding("UTF-8");
		con = ConnectionManager.getConnection(request);
		stmt=con.createStatement();
		rSet=stmt.executeQuery("select PAT_SER_GRP_CODE,SHORT_DESC from mp_pat_ser_grp");		
%>
<body onLoad="FocusFirstElement()" onKeyDown = 'lockKey()' OnMouseDown="CodeArrest()">
<form name='MPPatSerGrpUserCriteria' id='MPPatSerGrpUserCriteria'>

<table border='0' cellpadding='5' cellspacing='0' width='98%'>
		
		<tr>
			<td width='40%' class='label'>
				<fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></td>	
			</td>
			<td width="60%" colspan="3" class="fields"  nowrap>
			<select name='pat_ser_grp_code' id='pat_ser_grp_code'>
				<OPTION VALUE=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
			<%
				if( rSet != null){
					while(rSet.next()){
						patcode = rSet.getString( "PAT_SER_GRP_CODE" );
						shortdesc=rSet.getString("SHORT_DESC");								
						%>
						<OPTION VALUE='<%= patcode%>' ><%= shortdesc%></option>
						<%
					}
				}
			%>
			</select><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
			</tr>
			<tr>
			<!--<td width='40%' class='label'>
				<fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></td>	
			</td>
			<td width='25%' class='fields'>
				<select name="search_criteria" id="search_criteria">
					<option value="S"><fmt:message  key="Common.startsWith.label" bundle="${common_labels}"/>
					<option value="E"><fmt:message  key="Common.endsWith.label" bundle="${common_labels}"/>
					<option value="C"><fmt:message  key="Common.contains.label" bundle="${common_labels}"/>
				</select>-->
		<td width='25%' class='label' ><fmt:message key="Common.SearchUser.label" bundle="${common_labels}"/></td>
			<td width='25%' class='fields'><INPUT TYPE="text" onBlur='makeValidQueryCriteria(this)' name="searchuser" id="searchuser" maxlength="30" onKeyPress="return blockevent(event)"><td width='25%' class='label' ><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></td>
			<td width='25%' class='fields'><select name="search_criteria" id="search_criteria">
				<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
				<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
				<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
				</select>
			</td>
			</td>			
		</tr>		
	
	<tr>
		<td colspan='4' class='button' align='Right'>
		<input type='button' name='Search' id='Search' class='button' value='<fmt:message  key="Common.search.label" bundle="${common_labels}"/>' onClick='PatSerUserLinkResult()'>
		</td>
	</tr>
</table>
</form>
</body>
<%
	}catch(Exception e){
		//out.println(e);
		e.printStackTrace(); // Added by lakshmanan for security issue ID 174252266 on 31-08-2023
	}finally { 
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

