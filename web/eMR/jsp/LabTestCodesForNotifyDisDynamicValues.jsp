<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*,eCommon.XSSRequestWrapper"%>

<%  request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
Connection con = null;
//Statement stmt=null;
PreparedStatement stmt = null;
ResultSet rs=null;
String clearAll="";
String notifyDisCode  ="";



try{ 
notifyDisCode=request.getParameter("notifyDisCode")==null?"":request.getParameter("notifyDisCode");
if(notifyDisCode == null) notifyDisCode="";
 clearAll = request.getParameter("clearAll")==null?"":request.getParameter("clearAll");



if(clearAll == null) clearAll="";
RecordSet	LabTestforNotifyDise	=	null;
LabTestforNotifyDise	=	(webbeans.eCommon.RecordSet)	session.getAttribute("LabTestforNotifyDise");

if(clearAll.equals("clearAll"))
{
LabTestforNotifyDise.clearAll();
}
else if(clearAll.equals("notCleared")) 
{
LabTestforNotifyDise.clearAll();
con = ConnectionManager.getConnection(request);

String sql="SELECT   test_code test_code, long_desc test_cod_desc, 'I' db_action FROM rl_test_code WHERE (status is null or status = 'A') AND test_code NOT IN (SELECT test_code FROM mr_labtest_for_notify_dis WHERE notify_disease_code =?) UNION ALL SELECT   a.test_code test_code, b.long_desc test_code, 'U' db_action FROM mr_labtest_for_notify_dis a, rl_test_code b WHERE a.notify_disease_code =? AND b.test_code = a.test_code ORDER BY 2";

 //stmt=con.createStatement();
 stmt = con.prepareStatement(sql);
 stmt.setString(1,notifyDisCode);
 stmt.setString(2,notifyDisCode);
 rs=stmt.executeQuery();

 while(rs.next())
{
LabTestforNotifyDise.putObject(rs.getString(1));

}



}

%>
<html>
<head>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body CLASS='MESSAGE' onKeyDown='lockKey()'>
	<form name=Dynamic_form> 
		<input type=hidden name=E value='<%=clearAll%>'>
		<input type=hidden name=R value=''>
		<input type=hidden name=S value=''>
		<input type=hidden name=X value=''>
		<input type=hidden name=Y value=''>
	</form>
</body>
</html>
<%}catch(Exception e){/* out.print(e); */e.printStackTrace();}
	finally{ 
	if(rs!=null) rs.close();
	  if(stmt!=null) stmt.close();
	ConnectionManager.returnConnection(con,request);
	
	}

%>

