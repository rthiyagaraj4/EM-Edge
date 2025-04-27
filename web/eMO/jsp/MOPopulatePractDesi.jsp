<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%

Connection con             = null;
ResultSet rs	           = null;
java.sql.Statement stmt	   = null;
String sql         = "";
//String postmortem_reqd_yn = "";
String position_desc         ="";
request.setCharacterEncoding("UTF-8");
String practcode           = request.getParameter("practcode")==null?"":request.getParameter("practcode");
String objval           = request.getParameter("objval")==null?"":request.getParameter("objval");
if(objval.equals("pract_desc1"))objval="desig_desc1";
if(objval.equals("pract_desc2"))objval="desig_desc2";
if(objval.equals("pract_desc3"))objval="desig_desc3";
if(objval.equals("pract_desc4"))objval="desig_desc4";
if(objval.equals("pract_desc5"))objval="desig_desc5";
if(objval.equals("pract_desc6"))objval="desig_desc6";
if(objval.equals("pract_desc7"))objval="desig_desc7";
if(objval.equals("post_perf_pract_desc1"))objval="post_perf_desig_desc1";

//String area_desc           = null;


try
{
	
	
	 sql = "select  position_desc from am_practitioner_vw where PRACTITIONER_ID='"+practcode+"'";
	
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();
	rs = stmt.executeQuery(sql);

	while(rs.next())
	{
		 position_desc			=	rs.getString("position_desc");
	     if(position_desc==null || position_desc.equals("null"))
		 position_desc="";
	
	}          
 
 if(stmt!=null) stmt.close();
	if(rs!=null) rs.close();

 %>
 <script>

eval("parent.frames[2].document.forms[0].<%=objval%>").value='<%=position_desc%>';		
 </script>
 <%}
 catch(Exception ee)
 {
	if(stmt!=null) stmt.close();
	if(rs!=null) rs.close();

	ee.printStackTrace();
 }
finally
{
   ConnectionManager.returnConnection(con,request);
}
%>

