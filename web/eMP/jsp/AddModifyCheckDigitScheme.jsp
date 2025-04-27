<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>	
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script src='../js/CheckDigitScheme.js' language='javascript'></script>
</head>

<body OnMouseDown="CodeArrest()" onKeyDown='lockKey();' onLoad='FocusFirstElement()' >

 <%
	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rs		  = null;
	String ID="";
	String Name="";
	String Function="";
	String effstatus="";
	String codeTextAttribute="";
	String otherTextAttribute="";
	String checkBoxAttribute="";
	String eventFunctionForCase="";
	boolean newCheckScheme=false;

	ID=request.getParameter("ID");

	
	if(ID==null)
	 {
		ID="";
		Name="";
		Function="";
		effstatus="E";
		codeTextAttribute="";
		otherTextAttribute="";
		checkBoxAttribute="CHECKED";
		
		newCheckScheme=true;
		
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	 }
	 else
	 {
     try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement("select scheme_name,program_name,eff_status from mp_check_digit_scheme where scheme_id ='"+ID+"'");
		rs = pstmt.executeQuery();

		if (rs!= null)
        {
          while(rs.next())
          {
		
				Name=rs.getString("scheme_name");
				Function=rs.getString("program_name");
				effstatus=rs.getString("eff_status");
				if(effstatus.equals("D"))
				{
					otherTextAttribute="READONLY";
					checkBoxAttribute="";

				}
				else
				{
					otherTextAttribute="";
					checkBoxAttribute="CHECKED";
				
				}
           }
		 }
 
	    }catch(Exception e){out.println(e.toString());}
		finally
		{
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
		} 

		codeTextAttribute="READONLY";
		newCheckScheme=false;
		eventFunctionForCase="";
	 }



%>

<form name='CheckDigitScheme_form' id='CheckDigitScheme_form' action='../../servlet/eMP.CheckDigitSchemeServlet' method='post' target='messageFrame'>
<div>
<br><br><br><br><br><br><br><br><br><br>

<table border='0' cellpadding='3' cellspacing='0' width='auto' align='center'>
<tr>
		<td width='10%'>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td width='10%'>&nbsp;</td>
</tr>
<tr>
		<td>&nbsp;</td>
		<td class='label'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' name='scheme_id' id='scheme_id' value="<%=ID%>" size='3' maxlength='3' <%=codeTextAttribute%> <%=eventFunctionForCase%> onKeyPress="return CheckForSpecChars(event)"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		<td>&nbsp;</td>
</tr>
<tr>
		 <td>&nbsp;</td>
		<td class=label><!-- width='40%'--><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
		<td class='fields'><!-- width='60%' colspan='2'--><input type='text' name='scheme_name' id='scheme_name' size='30' maxlength='30' onBlur='makeValidString(this)' value="<%=Name%>" <%=otherTextAttribute%> ><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		<td>&nbsp;</td>
</tr>
<tr>
			<td>&nbsp;</td>
			<td class=label><!-- width='40%'--><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
			<td class='fields'><!--width='60%' colspan='2'--><input type='text' name='program_name' id='program_name' size='30' maxlength='30' onBlur='makeValidString(this)' value="<%=Function%>" <%=otherTextAttribute%> ><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
			<td>&nbsp;</td>
</tr>
<tr>
				<td>&nbsp;</td>
				<td class='label'> <!--width='40%'--><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<td class='fields'> <!--width='60%' colspan='2'--><input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="Change1()"></td>
				<td>&nbsp;</td>
</tr>
<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
</tr>
</table>

</div>
<%
	if(newCheckScheme)
	{
%>
		<input type='hidden' name='function' id='function' value='insert'>
		<input type='hidden' name='function_name' id='function_name' value='insert'>

<%  }
  	else
	{
%>
		<input type='hidden' name='function' id='function' value='modify'>
		<input type='hidden' name='function_name' id='function_name' value='modify'>
<%
	}
%>
</form>
</body>
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

