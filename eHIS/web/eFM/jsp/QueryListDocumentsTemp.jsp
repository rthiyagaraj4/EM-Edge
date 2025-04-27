<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

String sql_query = " select a.doc_folder_id,b.doc_folder_name from fm_encounter_doc_type_link a ,fm_doc_folder b where a.doc_folder_id=b.doc_folder_id and a.patient_id = ? and a.encounter_id = ? ";

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String doc_folder_id = "";
String doc_folder_name = "";
try {
	con = ConnectionManager.getConnection(request);

	pstmt = con.prepareStatement(sql_query);
	pstmt.setString(1,patient_id);
	pstmt.setString(2,encounter_id);
	rs= pstmt.executeQuery();
	if(rs!=null && rs.next())
	{
		doc_folder_id = rs.getString("doc_folder_id")==null?"":rs.getString("doc_folder_id");
		doc_folder_name = rs.getString("doc_folder_name")==null?"":rs.getString("doc_folder_name");
		
	}

%>
	<script>
			parent.frames[1].document.forms[0].doc_folder_id.value='<%=doc_folder_id%>';
			parent.frames[1].document.forms[0].doc_folder_name.value='<%=doc_folder_name%>';
	 </script>
<%	out.println("<script>parent.messageFrame.location.href='../../eCommon/jsp/error.jsp'</script>");
if(rs!=null)rs.close();
if(pstmt!=null)pstmt.close();
}
catch(Exception e)
{
	e.printStackTrace() ;
}
finally{
	
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

%>
