<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>


<%
eCA.UserPrvlgToVeryEmailBean UserPrvlgToVeryEmailBean = null;

UserPrvlgToVeryEmailBean = (eCA.UserPrvlgToVeryEmailBean)getObjectFromBean("UserPrvlgToVeryEmailBean","eCA.UserPrvlgToVeryEmailBean",session);
request.setCharacterEncoding("UTF-8");	

Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;

String sql="";

try
{
String module_id="";
String report_id="";
String sql_report_id="";
String sql_report_desc="";
String searchKey="";
String chkUnchk="";
String user_id="";

con =	ConnectionManager.getConnection(request);
Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
hash = (Hashtable)hash.get( "SEARCH" ) ;
if(hash.containsKey("searchKey")){
searchKey=(String)hash.get("searchKey");
}
if(searchKey.equals("hdrPage") && hash.containsKey("module_id") ){
	module_id = (String)hash.get("module_id");
	out.println("clearReportId('document');");
	sql="select report_id,report_desc from sm_report where module_id=?   and exists (select 1 from SM_REPORT_MAIL_INFO where module_id=sm_report.module_id and report_ID=sm_report.REPORT_ID)  order by 2 ";
	pstmt= con.prepareStatement(sql);
	pstmt.setString(1,module_id);
	rs = pstmt.executeQuery(); 
	//if(rs.next())
	while(rs.next())
	{
			sql_report_id=rs.getString(1)==null?"":rs.getString("report_id");
			sql_report_desc=rs.getString(1)==null?"":rs.getString("report_desc");
			out.println( "addReportId(\""+sql_report_id+"\",\""+sql_report_desc+"\");");
	}
	if (rs!= null) rs.close();
	if (pstmt!= null) pstmt.close();
}else if(searchKey.equals("dtlPage")){
	
	if(hash.containsKey("module_id"))
	module_id = hash.get("module_id")==null?"":(String)hash.get("module_id");
	if(hash.containsKey("report_id"))
	 report_id = hash.get("report_id")==null?"":(String)hash.get("report_id");
	 if(!module_id.equals("") && !report_id.equals("")){
		 UserPrvlgToVeryEmailBean.clearBean();
	pstmt = con.prepareStatement("Select user_id from SM_MAIL_AUTH_USER where module_id=? and report_id=? order by user_id");
	pstmt.setString(1,module_id);
	pstmt.setString(2,report_id);
	rs = pstmt.executeQuery();
	while(rs.next()){
		user_id=rs.getString("user_id")==null?"":rs.getString("user_id");
		if(!user_id.equals(""))
			UserPrvlgToVeryEmailBean.setUserList(user_id);
		}
	 }
	 if (rs!= null) rs.close();
	if (pstmt!= null) pstmt.close();
}else if(searchKey.equals("chkUnchkItem")){
	if(hash.containsKey("chkUnchk"))
		chkUnchk=hash.get("chkUnchk")==null?"":(String)hash.get("chkUnchk");
	if(hash.containsKey("userID"))
		user_id=hash.get("userID")==null?"":(String)hash.get("userID");
	if(!user_id.equals("")){
	if(chkUnchk.equals("Y") ){
		UserPrvlgToVeryEmailBean.setUserList(user_id);
	}else
		UserPrvlgToVeryEmailBean.removeUserList(user_id);
	}
	
	
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
putObjectInBean("UserPrvlgToVeryEmailBean",UserPrvlgToVeryEmailBean,session);

%>

