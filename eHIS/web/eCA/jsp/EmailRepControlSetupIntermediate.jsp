<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>


<%
request.setCharacterEncoding("UTF-8");

Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;

String sql="";

try
{
String module_id="";
String sql_report_id="";
String sql_report_desc="";

con =	ConnectionManager.getConnection(request);
Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
hash = (Hashtable)hash.get( "SEARCH" ) ;
if(hash.containsKey("module_id") ){
	module_id = (String)hash.get("module_id");
	out.println("clearReportId('document');");
	sql="select report_id,report_desc from sm_report where module_id=?  and exists (select 1 from SM_REPORT_MAIL_INFO where module_id=sm_report.module_id and report_ID=sm_report.REPORT_ID) order by 2	";
	pstmt= con.prepareStatement(sql);
	pstmt.setString(1,module_id);
	rs = pstmt.executeQuery(); 
	while (rs.next()) 
	{
			sql_report_id=rs.getString(1)==null?"":rs.getString("report_id");
			sql_report_desc=rs.getString(1)==null?"":rs.getString("report_desc");
			out.println( "addReportId(\""+sql_report_id+"\",\""+sql_report_desc+"\");");
	}
	if (rs!= null) rs.close();
	if (pstmt!= null) pstmt.close();
}
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

