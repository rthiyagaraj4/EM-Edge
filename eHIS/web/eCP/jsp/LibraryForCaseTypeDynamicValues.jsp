<!DOCTYPE html>
<%@ page language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.
Connection con = null;
//Statement stmt=null;
  PreparedStatement pstmt	= null;

ResultSet rs=null;
String clearAll="";
con = ConnectionManager.getConnection(request);
String case_type_code="";
String   sql  ="";
String library_id="";
String version_no="";
String two_vals="";

try
{
 case_type_code=request.getParameter("case_type_code");
if(case_type_code == null) case_type_code="";

 clearAll = request.getParameter("clearAll");
	if(clearAll == null) clearAll="";
RecordSet	CaseTypeNote	=	null;
CaseTypeNote	=	(webbeans.eCommon.RecordSet)	session.getAttribute("CaseTypeNote");

if(clearAll.equals("clearAll"))
{
CaseTypeNote.clearAll();
}
else if(clearAll.equals("notCleared"))
{
CaseTypeNote.clearAll();

  // sql  =" select library_id,version_no,long_desc, 'I' db_action from CP_LIBRARY  where library_basis = 'C'    and status = 'F' and eff_status = 'E' and (library_id,version_no) not in (select library_id,version_no from cp_case_type_for_library where case_type_code = '"+case_type_code+"') union all select a.library_id,a.version_no,b.long_desc, 'I' db_action from cp_case_type_for_library a, cp_library b where a.case_type_code = '"+case_type_code+"' and b.library_id = a.library_id and b.version_no = a.version_no order by 3";
  //sql  =" select library_id,version_no,long_desc, 'I' db_action from CP_LIBRARY  where library_basis = 'C'    and status = 'F' and eff_status = 'E' and (library_id,version_no) not in (select library_id,version_no from cp_case_type_for_library where case_type_code = ?) union all select a.library_id,a.version_no,b.long_desc, 'I' db_action from cp_case_type_for_library a, cp_library b where a.case_type_code = ? and b.library_id = a.library_id and b.version_no = a.version_no order by 3";

  //sql  =" SELECT distinct library_id, version_no, long_desc, db_action FROM (SELECT library_id, version_no, long_desc, db_action, status, first_value(status) OVER (PARTITION BY library_id) firstvalue FROM (SELECT DISTINCT ad.library_id,ad.term_code,ad.version_no,ad.term_Set_id, ad.long_desc, ad.db_action, DECODE(b.term_code,NULL,'N','Y') status FROM (SELECT   DISTINCT a.library_id, a.version_no, b.term_code,b.term_set_id,a.long_desc, 'U' db_action FROM cp_library a, cp_term_code_for_case_type b WHERE a.library_basis = 'C' AND a.status = 'F' AND a.eff_status = 'E' AND b.case_type_code= '"+case_type_code+"') ad,cp_library_intervention b WHERE ad.library_id = b.library_id(+) AND ad.term_code = b.term_code(+) AND ad.term_set_id = b.term_set_id(+) AND ad.version_no = b.version_no(+) ORDER BY status)) WHERE firstvalue = 'Y' AND (library_id, version_no) not in (select library_id,version_no from cp_case_type_for_library where case_type_code = ?) union all select a.library_id,a.version_no,b.long_desc, 'I' db_action from cp_case_type_for_library a, cp_library b where a.case_type_code = ? and b.library_id = a.library_id and b.version_no = a.version_no order by 3"; //common-icn-0180
  sql  =" SELECT distinct library_id, version_no, long_desc, db_action FROM (SELECT library_id, version_no, long_desc, db_action, status, first_value(status) OVER (PARTITION BY library_id) firstvalue FROM (SELECT DISTINCT ad.library_id,ad.term_code,ad.version_no,ad.term_Set_id, ad.long_desc, ad.db_action, DECODE(b.term_code,NULL,'N','Y') status FROM (SELECT   DISTINCT a.library_id, a.version_no, b.term_code,b.term_set_id,a.long_desc, 'U' db_action FROM cp_library a, cp_term_code_for_case_type b WHERE a.library_basis = 'C' AND a.status = 'F' AND a.eff_status = 'E' AND b.case_type_code= ?) ad,cp_library_intervention b WHERE ad.library_id = b.library_id(+) AND ad.term_code = b.term_code(+) AND ad.term_set_id = b.term_set_id(+) AND ad.version_no = b.version_no(+) ORDER BY status)) WHERE firstvalue = 'Y' AND (library_id, version_no) not in (select library_id,version_no from cp_case_type_for_library where case_type_code = ?) union all select a.library_id,a.version_no,b.long_desc, 'I' db_action from cp_case_type_for_library a, cp_library b where a.case_type_code = ? and b.library_id = a.library_id and b.version_no = a.version_no order by 3"; //common-icn-0180

 //stmt=con.createStatement();
 pstmt = con.prepareStatement( sql);
 pstmt.setString(1,case_type_code);//common-icn-0181
 pstmt.setString(2,case_type_code);
 pstmt.setString(3,case_type_code);
 
	rs=pstmt.executeQuery();
 //rs=stmt.executeQuery(sql);
while(rs.next())
{
	 library_id=rs.getString("library_id");
	 version_no=rs.getString("version_no");
	 two_vals=library_id+"~"+version_no;
CaseTypeNote.putObject(two_vals);
}
}
%>

<html>
<head>
</head>
<body CLASS='MESSAGE'>
	<form name=Dynamic_form>
		<input type=hidden name=E value='<%=clearAll%>'>
		<input type=hidden name=R value=''>
		<input type=hidden name=S value=''>
		<input type=hidden name=X value=''>
		<input type=hidden name=Y value=''>
	</form>
</body>
</html>
<%}
catch(Exception e){
	//out.print(e);//COMMON-ICN-0181
       e.printStackTrace();//COMMON-ICN-0181
	}
  finally
  {
	  if(rs!=null) rs.close();
	  if(pstmt!=null) pstmt.close();
	ConnectionManager.returnConnection(con,request);

  }
%> 

