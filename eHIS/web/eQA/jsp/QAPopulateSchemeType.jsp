
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script>

<%

String diagnosis = request.getParameter("diagnosis")==null?"":request.getParameter("diagnosis");
String scheme_type = "";

PreparedStatement pstmt =null;
ResultSet rs = null;
Connection conn = ConnectionManager.getConnection(request);
try
{
	pstmt = conn.prepareStatement("select diag_coding_scheme,proc_coding_scheme from mr_param ");
	rs = pstmt.executeQuery();
	if(rs!=null)
	{
		while(rs.next())
		{
	if(diagnosis.equals("D"))
	{
		scheme_type = rs.getString(1);
	}
	else if(diagnosis.equals("P"))
	{
		scheme_type = rs.getString("PROC_CODING_SCHEME");
		
	}
	}
	}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
}catch(Exception ee)
{
out.println("Error"+ee);
}  
finally
{
   ConnectionManager.returnConnection(conn,request);
}
out.println("<script>var obj=parent.f_query_add_mod.document.getElementById('schema_type');</script>");
        out.println("<script> var length = obj.length;for(i=0;i<length;i++) obj.remove(1);</script>");
if(diagnosis.equals("D"))
	{
       	out.println("<script>opt=parent.f_query_add_mod.document.createElement('OPTION');</script>");
        out.println("<script>opt.text='ICD10';</script>");
        out.println("<script>opt.value='1';</script>");
		out.println("<script>parent.f_query_add_mod.document.getElementById('schema_type').add(opt)</script>");
		out.println("<script>opt=parent.f_query_add_mod.document.createElement('OPTION');</script>");
        out.println("<script>opt.text='ICD9-CM';</script>");
        out.println("<script>opt.value='2';</script>");
		out.println("<script>parent.f_query_add_mod.document.getElementById('schema_type').add(opt)</script>");
if(scheme_type.equals("1"))
{
out.println("<script>parent.f_query_add_mod.document.getElementById('schema_type').options[1].selected=true</script>");
}
if(scheme_type.equals("2"))
{
out.println("<script>parent.f_query_add_mod.document.getElementById('schema_type').options[2].selected=true</script>");
}
	}
	else if(diagnosis.equals("P"))
	{
	out.println("<script>opt=parent.f_query_add_mod.document.createElement('OPTION');</script>");
	out.println("<script>opt.text='CPT4';</script>");
	out.println("<script>opt.value='3';</script>");
	out.println("<script>parent.f_query_add_mod.document.getElementById('schema_type').add(opt)</script>");
	out.println("<script>opt=parent.f_query_add_mod.document.createElement('OPTION');</script>");
	out.println("<script>opt.text='ICD9-CM';</script>");
	out.println("<script>opt.value='4';</script>");
	out.println("<script>parent.f_query_add_mod.document.getElementById('schema_type').add(opt)</script>");
	out.println("<script>opt=parent.f_query_add_mod.document.createElement('OPTION');</script>");
	out.println("<script>opt.text='ICD10-PCS';</script>");
	out.println("<script>opt.value='6';</script>");
	out.println("<script>parent.f_query_add_mod.document.getElementById('schema_type').add(opt)</script>");
if(scheme_type.equals("3"))
{
out.println("<script>parent.f_query_add_mod.document.getElementById('schema_type').options[1].selected=true</script>");
}
if(scheme_type.equals("4"))
{
out.println("<script>parent.f_query_add_mod.document.getElementById('schema_type').options[2].selected=true</script>");
}
if(scheme_type.equals("6"))
{
out.println("<script>parent.f_query_add_mod.document.getElementById('schema_type').options[3].selected=true</script>");
}
	}
%>

