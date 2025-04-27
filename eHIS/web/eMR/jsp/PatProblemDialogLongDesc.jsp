<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale					= (String) session.getValue( "LOCALE" ) ;

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
//String longDesc = java.net.URLDecoder.decode(request.getParameter("longDesc"));
Connection con = null;
PreparedStatement stmt = null; 
ResultSet rs = null;

String term_code = java.net.URLDecoder.decode(request.getParameter("term_code"));
String term_set_id = java.net.URLDecoder.decode(request.getParameter("term_set_id"));

String longDesc = "";
String calledFrom = request.getParameter("calledFrom")==null ? "" : request.getParameter("calledFrom");
if(calledFrom.equals("charting")){
	out.println("<title>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Result.label","common_labels")+"</title>");
}else{
	out.println("<title>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")+"</title>");
}
try{
		String sql = " select LONG_DESC from mr_d_"+term_set_id+"_lang_vw  where term_code = ? and term_set_id = ? and language_id=?";
		
		con = ConnectionManager.getConnection(request);
		stmt = con.prepareStatement(sql);
		stmt.setString(1,term_code);
		stmt.setString(2,term_set_id);
		stmt.setString(3,locale);
		rs = stmt.executeQuery();
		if(rs!=null){
			if(rs.next()){
				longDesc = rs.getString("LONG_DESC");
			}
		}
		
%>
<body  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload ="document.forms[0].closeWindow.focus();" scroll=no >

<form name="frmlngDescription" id="frmlngDescription">
	<center>
		<table border='1' cellpadding='3' cellspacing='0' width="100%" height='100%' align="center">
			<tr>
				<td class="label">
					<%if(!calledFrom.equals("charting")){%>
					<B><U><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></U></B><br><br>
					<%
						}
						else
						{
							out.println("<B><U>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Result.label","common_labels")+"</U></B><br><br>");
						}
					%>
					<textarea style="resize:none" name="longDescription" rows="14" cols="45" readonly><%=longDesc%></textarea><br>
				</td>
				</tr>
				<tr>
					<td align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" name="closeWindow" id="closeWindow" class="button" onclick="parent.document.getElementById('dialog_tag').close();" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%> '>
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
catch(Exception ex)
{
	ex.printStackTrace();
}finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}	
%>

