<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%	String sStyle = ( session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eMR/js/QueryProcedure.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%	

Connection connection 		= null;
Statement statement		= null;
ResultSet resultSet		= null;
String proc_code			= "";
String proc_desc			= "";
try
{
     connection	= ConnectionManager.getConnection(request);
	 statement	= connection.createStatement();
	 resultSet	= statement.executeQuery("SELECT DECODE(PROC_CODE_SCHEME,'3','ICD 9CM','4','CPT 4') SCHEME_DESC, PROC_CODE_SCHEME FROM MR_PARAMETER");
		
	if ((resultSet != null) && (resultSet.next()))
	{
		proc_code = resultSet.getString("proc_code_scheme");
		proc_desc = resultSet.getString("scheme_desc");
	}
	 StringBuffer tm_set_list=new StringBuffer();
	 resultSet=statement.executeQuery("SELECT TERM_SET_ID,TERM_SET_DESC,DEFN_LEVELS FROM MR_TERM_SET WHERE EFF_STATUS='E' AND PROC_SPEC_YN = 'Y' ORDER BY TERM_SET_DESC");
	 while(resultSet.next()){
			tm_set_list.append("<option value='"+resultSet.getString("TERM_SET_ID")+"'>"+resultSet.getString("TERM_SET_DESC")+"</option>");
	 }	
	if(resultSet!=null)  resultSet.close();
	if(statement!=null)  statement.close();
%>
	<body  onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
	<form name='procedure_criteria' id='procedure_criteria'>
		<table border='0' cellpadding='0' cellspacing='0' width='100%'>
		<tr>
			<td width="10%" class='label' nowrap><fmt:message key="eMR.ProcedureCodeScheme.label" bundle="${mr_labels}"/></td>
			<td width="25%" class='fields' >
					<select name='mr_procedure_set' id='mr_procedure_set' onchange="clearProcCode()">
							<option  value=''>---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option> 
							<%=tm_set_list.toString()%>
					</select>
					<img src='../../eCommon/images/mandatory.gif'></img>
			</td>
				<td class='label' width="20%">&nbsp;</td>
				<td class='label' width="20vw">&nbsp;</td>
				<td class='label' width="30vw">&nbsp;</td>
				
			</tr>
		<tr>
			<tr>
				<td class='label' ><fmt:message key="Common.ProcedureCode.label" bundle="${common_labels}"/></td>
				<td class='fields' width="10%"><input type='text' name='procedure_code' id='procedure_code' disabled onblur='getProcedureDesc();'><input type='button' class='button' name='procedure_code_button' id='procedure_code_button' value='?' onClick="getProcedureDetails();"><img src='../../eCommon/images/mandatory.gif'></img></td>
				<td class ='label'  nowrap><fmt:message key="Common.ProcedureDescription.label" bundle="${common_labels}"/></td>
				<td class ='fields' width="10%" ><input type='text' name='procedure_desc' id='procedure_desc' readonly size="40" maxlength='40'></input> 
			<td class='label' ></td>
			</tr>
			<tr>
				<td class='label' >&nbsp;</td>
				<td class='label' >&nbsp;</td>
				<td class='label' >&nbsp;</td>
				<td class='label' >&nbsp;</td>
				<td  class='button'>
				<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' style="float: right;" onclick='clearAll();'>
				<input type='button' name='search' id='search' style="float: right;" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'>
				</td>
			</tr>
		</table>
		<input type="Hidden" name="proc_code" id="proc_code" value = "<%=proc_code%>">
		<input type="Hidden" name="proc_desc" id="proc_desc" value = "<%=proc_desc%>">
	</form>
	</body>

<%	}catch(Exception exception)
	{
		//out.println("Exception : "+exception.toString());
		exception.printStackTrace();
	}
	finally
    {
		try
		{
			if(statement!=null) statement.close();
			if(resultSet!=null) resultSet.close();
		}
		catch (Exception e){}
		ConnectionManager.returnConnection(connection,request);
    }
%>
</html>

<%!
	// To Handle java.lang.NullPointerException
	public static String checkForNull(String inputString)
	{
		return( ((inputString==null) || (inputString.equals("null"))) ? "" : inputString );
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return( ((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString );
	}

%>

