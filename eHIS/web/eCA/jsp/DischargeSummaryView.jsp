<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
Connection con			=null;
PreparedStatement stmt			=null;
ResultSet rs			=null;   

String sql				="";
boolean ca_note_param_value=false;
try
{
	con	 = ConnectionManager.getConnection(request);
	stmt = null;
	rs	 = null;     
	sql="Select disch_summ_note_type from ca_note_param";
	stmt=con.prepareStatement(sql);
	rs=stmt.executeQuery();

	if(rs!=null)
	{
		while(rs.next())
			ca_note_param_value=true;
	}	

if(ca_note_param_value)
{
%>
<iframe name ='DischargeSummeryQuery' marginwidth=0 marginheight=0 frameborder=no scrolling='no'  src="../../eCommon/html/blank.html" style='height:1%;width:100vw'></iframe>
	<iframe name ='blank' marginwidth=0 marginheight=0 frameborder=auto scrolling='auto'  src="../../eCA/jsp/DischargeSummeryResult.jsp?<%=request.getQueryString()%>" style='height:45%;width:100vw'></iframe>
	
	<iframe name ='PhysicainNoteResultDetails' marginwidth=0 marginheight=0 frameborder=auto scrolling='auto' src="../../eCommon/html/blank.html" style='height:49%;width:100vw'></iframe>	
 

<%
}
else{
%>
<script>
	alert(getMessage('DEFINE_NOTE_PARAM','CA'));
</script>

<%
	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
}
}
catch(Exception e)
{
//out.println("EXCEPTION"+e.toString());//COMMON-ICN-0181
  e.printStackTrace();//COMMON-ICN-0181
}
finally
{		
		if(con!=null)ConnectionManager.returnConnection(con,request);
}
%>
</html>

