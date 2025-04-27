<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import = "java.net.*,java.sql.*, java.text.*,webbeans.eCommon.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<title><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></title>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
   <style>
textarea {
  resize: none;
}
</style>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
Connection con = null;
PreparedStatement stmt = null;
ResultSet rs = null; 
String locale					= (String) session.getValue( "LOCALE" ) ; 
String diagCode = java.net.URLDecoder.decode(request.getParameter("diagCode"));
String termSet = java.net.URLDecoder.decode(request.getParameter("termSet"));
//String longDesc = java.net.URLDecoder.decode(request.getParameter("longDesc"));
String longDesc = "";

try
{
		String sql = " select LONG_DESC from mr_term_code_lang  where term_code = ? and term_set_id = ? and LANGUAGE_ID = ?";
		
		con = ConnectionManager.getConnection(request);
		
		stmt = con.prepareStatement(sql);
		stmt.setString(1,diagCode);
		stmt.setString(2,termSet);
		stmt.setString(3,locale);
		rs = stmt.executeQuery();
		if(rs!=null)
		{
			if(rs.next())
			{ 
			   //modified by N Munisekhar on 06-May-2012 against [IN:039347]
				longDesc =checkForNull(rs.getString("LONG_DESC")); 
				
			}
		}
		
%>

<body onload ="document.forms[0].closeWindow.focus();" scrolling='no' onKeyDown='lockKey()'>

<form name="frmlngDescription" id="frmlngDescription">
	<center>
		<table border='1' cellpadding='0' cellspacing='0' width="100%" height='100%' align=center>
			<tr>
				<td align="left" class="label">
					<B><U><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></U></B><br><br>
					<textarea name="longDescription" rows=14 cols=40 readonly><%=longDesc%></textarea><br>
					<input type="button" name="closeWindow" id="closeWindow" class="button" onclick="parent.document.getElementById('dialog_tag').close(); " value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'>
				</td>
			</tr>
		</table>
	</center>
</form>
</body>
</html>
<%
if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
}
catch(Exception ex){
	ex.printStackTrace();
}finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}	
%>
 <!--added by N Munisekhar on 06-May-2012 against [IN:039347]-->
<%!
public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
%>

