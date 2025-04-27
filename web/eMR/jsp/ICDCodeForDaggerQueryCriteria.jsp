<!DOCTYPE html>
<%
/***
/// MODULE			:	Medical Records..(MR)
/// Function Name	:	Asterisk Codes for Dagger Codes 
/// Developer		:	SRIDHAR R
/// Created On		:	1 DEC 2004
/// Function 		:   Used to associate Asterisk Codes for a selected Dagger Code...
***/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>	 
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Connection con = null;
	Statement stmt = null;
	ResultSet rstlRs = null;

	String scheme      = "";
	String scheme_desc = "";

	try
	{
		con = ConnectionManager.getConnection(request);

		String mrParamsql="select diag_code_scheme scheme,decode(diag_code_scheme,'1','ICD 10','2','ICD 9CM','5','READ')scheme_desc from mr_parameter";
		
		stmt = con.createStatement();
		rstlRs = stmt.executeQuery(mrParamsql);
		if(rstlRs.next())
		{
			scheme      = rstlRs.getString("scheme");
			scheme_desc = rstlRs.getString("scheme_desc");
		}

	}catch(Exception e)
	{
		//out.println("Error in query : "+e);
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if(stmt != null){ stmt.close(); }
			if(rstlRs != null){ rstlRs.close(); }
		}
		catch(Exception e)
		{
			//out.println("Exception @ finally"+e.toString());	
			e.printStackTrace();
		}
		ConnectionManager.returnConnection(con,request);
	}
%>

<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<script src='../../eMR/js/ICDCodeForDagger.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

</head>

<body OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'onload='FocusFirstElement();'>
	<form name='tabListCriteriaform' id='tabListCriteriaform' method="post" target='messageFrame'>
		<table  align='center' cellpadding=5 cellspacing=0 border=0 width='100%'>
			<tr>
				<td class='label' width='20%' ><fmt:message key="eMR.DaggerCode.label" bundle="${mr_labels}"/></td>
				<td class='fields' width='60%'><input type='text' name='dagger_code' id='dagger_code' size='10' maxlength='10' value="" readonly><input type='button' name='code_butt' id='code_butt' value='?' class='button' onClick="show_window();" ><img src='../../eCommon/images/mandatory.gif'></img></td>
				<td class='label' width='20%' ></td>
			</tr>
			<tr>
				<!-- <td class='label' align='right' nowrap >&nbsp;&nbsp;&nbsp;&nbsp;Short Description&nbsp;</td><td align=left id='DaggerDescription' class='querydata' ></td>
				 -->
				 <td class='label' colspan='2' ></td>
				 <td class='button'><input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' name='search' onClick='populateResult()'><input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearValues()'></td>
			</tr>
				<input type="hidden" name="scheme" id="scheme" value="<%=scheme%>">
				<input type="hidden" name="scheme_desc" id="scheme_desc" value="<%=scheme_desc%>">
		</table>

	</form>
</body>
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

