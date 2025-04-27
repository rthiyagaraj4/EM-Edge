<!DOCTYPE html>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
//This file is saved on 18/10/2005.
Connection con = null;
Statement stmt=null;
ResultSet rs=null;
String clearAll="";
String sql="";
RecordSet	LibrarySetupAgeGroup	=	null;


con = ConnectionManager.getConnection(request);
try
{
clearAll = request.getParameter("clearAll")==null?"":request.getParameter("clearAll");
 
LibrarySetupAgeGroup	=	(webbeans.eCommon.RecordSet)	session.getAttribute("LibrarySetupAgeGroup");
if(clearAll.equals("clearAll"))
{
	LibrarySetupAgeGroup.clearAll();
}
else if(clearAll.equals("notCleared"))
{

 sql="SELECT AGE_GROUP_CODE, SHORT_DESC,DECODE(GENDER,'M','Male','F','Female','All')Sex_specific,MIN_AGE ||' '|| DECODE(AGE_UNIT,'D','Days','M','Months','Y','Years')AGE_MIN_UNIT,MAX_AGE||' '||DECODE(NVL(AGE_UNIT_MAX,AGE_UNIT),'D','Days','M','Months','Y','Years')AGE_MAX_UNIT,GENDER FROM AM_AGE_GROUP_LANG_VW WHERE EFF_STATUS='E' AND LANGUAGE_ID='"+locale+"'ORDER BY 2";
 stmt=con.createStatement();
 rs=stmt.executeQuery(sql);
while(rs.next())
{
LibrarySetupAgeGroup.putObject(rs.getString(1));

}

}

%>

<html>
<head>
	
</head>
<body CLASS='MESSAGE'>
	<form name="LibraryDynamicForm" id="LibraryDynamicForm"><input type=hidden name=E value='<%=clearAll%>'>
		<input type=hidden name=R value=''>
		<input type=hidden name=S value=''>
		<input type=hidden name=X value=''>
		<input type=hidden name=Y value=''>
	</form>
</body>
</html>
<%
	}
catch(Exception e){
	//out.print(e);//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
	}
  finally
  {
	  if(rs!=null) rs.close();
	  if(stmt!=null) stmt.close();
	
		if(con != null)
			ConnectionManager.returnConnection(con,request);

  }
%>

