<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.Common.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/UnusualOccur.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false"--> <!--Commented Against GHL-SCF-1519-->
<body>
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
String unusual_occur_code = request.getParameter("unusual_occur_code")==null?"":request.getParameter( "unusual_occur_code" );
String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String unusual_occur_code_disable="";
String long_desc="";
String short_desc="";
String print_yn="";
String status="";
String sql="";
String print_checked="";
String print_value="Y";
print_yn =
request.getParameter("print_yn")==null?"":request.getParameter( "print_yn" );
String sql1="";
if(mode.equals("modify"))
{
	try{
		con=ConnectionManager.getConnection(request);
		//sql=" Select unusual_occur_code, long_desc, short_desc, nvl(print_yn,'N') print, nvl(status,'E') status from OT_UNUSUAL_OCCUR_CODE where unusual_occur_code= ?";
		sql=" Select unusual_occur_code, long_desc, short_desc, nvl(print_yn,'N') print, nvl(status,'E') status from OT_UNUSUAL_OCCUR_CODE_LANG_VW where LANGUAGE_ID= ? AND unusual_occur_code= ?";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,unusual_occur_code);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			long_desc=rs.getString("long_desc");
			short_desc=rs.getString("short_desc");
			print_yn=rs.getString("print");
			status=rs.getString("status");
		}
		if(print_yn.equals("Y"))
	     {
             print_yn="Y";
			 disable_flag="";
		 }
		 else
	     {
			 
			 disable_flag="disabled";
			 print_yn="N";
		 }
		if(status.equals("E"))
		{
			chk_checked="checked";
			disable_flag="";
			
		}
		else
		{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}
		
	unusual_occur_code_disable="disabled";	
}catch(Exception e)
	{
	e.printStackTrace();
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
			e.printStackTrace();
			}
		
		}
}
%>
<form name="unsual_occur_form" id="unsual_occur_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.UnusualOccurServlet" method="post" target="messageFrame"> 
<br><br>
<table border=0 cellspacing=0 cellpadding=3 width='60%'  align=center>
<!-- <tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr> -->

<tr>
	<td class='label'><fmt:message key="eOT.UnusualOccurenceCode.Label" bundle="${ot_labels}"/></td>
	<td class='fields'>&nbsp;<input type="text" name="unusual_occur_code" id="unusual_occur_code" value="<%=unusual_occur_code%>" size=4 maxlength=4  <%=unusual_occur_code_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<tr>
	<td class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td class='fields'>&nbsp;<input type="text" name="long_desc" id="long_desc" value="<%=long_desc%>"  size=40 maxlength=50 <%=disable_flag%>>
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td class='fields'>&nbsp;<input type="text" name="short_desc" id="short_desc" value="<%=short_desc%>" size=30 maxlength=30 <%=disable_flag%>>
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>


<tr>
     <%
	if(mode.equals("insert"))
	{
	%>
    <td class='label'><fmt:message key="Common.print.label" bundle="${common_labels}"/>&nbsp;</td>
    <td class='fields'>
     &nbsp;<select name="print_yn" id="print_yn">
           <option value='N' selected ><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
           <option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
		<% }else if (mode.equals("modify"))
	        { %>
        <td class='label'><fmt:message key="Common.print.label" bundle="${common_labels}"/>&nbsp;</td>
       <td class='fields'>  
		&nbsp;<select name="print_yn" id="print_yn" >
		     <% 

		
			if(status.equals("E"))
				{
			  if ( print_yn.equals("N"))
			   {
		     %>
		      <option value=<%=print_yn%> selected><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
			<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
			  
		    <% }// end of 2nd if
			
		   else{ 
		      %>
		       <option value=<%=print_yn%> selected><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
               <option value='N'><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
		<%}
		
		}else if (status.equals("D"))
				{
			        if ( print_yn.equals("N"))
			   {
		     %>
		      <option value=<%=print_yn%> disabled><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
			
			  
		    <% }// end of 2nd if
			
		   else{ 
		      %>
		       <option value=<%=print_yn%> disabled><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
              <%
		       }
			}//end of if else for status D

			}//end of if else for modify
		/*}
  }catch(Exception e){e.printStackTrace();}
  finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
			e.printStackTrace();
			}
		
		}

	} */
			
			%>
	        </select>
    </td>
</tr>



<tr>
	<td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td class='label'><input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> ></td>
</tr>
<!-- <tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr> -->
</table>
<input type=hidden name='mode' id='mode' value='<%=mode%>'>
<input type=hidden name=unusual_occur_code1 value="<%=unusual_occur_code%>">
<input type=hidden name=long_desc1 value="<%=long_desc%>">
<input type=hidden name=short_desc1 value="<%=short_desc%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


