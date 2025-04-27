<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.* "  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<% 
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/NoteType.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;

String sql="";
int count =0;
try
{
String notegroup="";
con =	ConnectionManager.getConnection(request);
notegroup = request.getParameter("notegroup");
if(notegroup==null)
	notegroup="";

sql="select count(*)  from ca_note_group where NOTE_GROUP =? and APPL_TASK_ID in ('CLINICAL_NOTES','DISCHARGE_SUMMARY','REFERRAL_LETTER')";


pstmt= con.prepareStatement(sql);
pstmt.setString(1,notegroup);
rs = pstmt.executeQuery(); 
	if(rs.next())
	{
		count =rs.getInt(1);
	}
	if (rs!= null) rs.close();
	if (pstmt!= null) pstmt.close();
if(count>0)
	{%>
	<script>
      parent.frames[1].document.forms[0].doc_link_note.disabled=false;
	</script>
	<%}
 else
 {%>
	<script>
	 parent.frames[1].document.forms[0].doc_link_note.checked=false;
      parent.frames[1].document.forms[0].doc_link_note.disabled=true;
	</script>
	<%}

}
catch(Exception e)
{
	e.printStackTrace() ;
}
finally
	{
		if (con!= null)
		ConnectionManager.returnConnection(con,request);
	} 

%>
</html>


