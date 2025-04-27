<!DOCTYPE html>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<%
Connection con = null;
ResultSet rs=null;
ResultSet rs1=null;
Statement stmt = null;
Statement stmt1 = null;
PreparedStatement pstmt=null;
try{
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
 stmt = con.createStatement();
 stmt1 = con.createStatement();
String to_date = request.getParameter("to_date");
String from_date=request.getParameter("from_date");
if(to_date == null || to_date.equals("null") )	to_date=from_date;
if(from_date == null || from_date.equals("null")) from_date=to_date;

	String wd1="";
	String wd2="";
	
	//String sql="select to_date('"+to_date+"', 'dd/mm/yyyy') - to_date('"+from_date+"', 'dd/mm/yyyy') from dual";
	String sql="select to_date(?, 'dd/mm/yyyy') - to_date(?, 'dd/mm/yyyy') from dual";
		//rs = stmt.executeQuery(sql);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,to_date);
		pstmt.setString(2,from_date);
		rs = pstmt.executeQuery();
		while(rs.next()){
		wd1 = rs.getString(1);
		}
		
	//String sql2="select to_char(to_date('"+from_date+"','dd/mm/yyyy')+30,'dd/mm/yyyy') from dual";
	String sql2="select to_char(to_date(?,'dd/mm/yyyy')+30,'dd/mm/yyyy') from dual";
	//rs1=stmt1.executeQuery(sql2);
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(1,from_date);
		rs1 = pstmt.executeQuery();
		while(rs1.next()){
		wd2= rs1.getString(1);
		}
	
int check=Integer.parseInt(wd1);
if(check > 29 ){
	String a1="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script>parent.frames[1].document.frames[1].document.forms[0].prefenddate.value='"+wd2+"';</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";
out.println(a1);
	}
	else	
	{
	String a1="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/'"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script>"
		+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";
	out.println(a1);
	}

}catch(Exception e){out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/'"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body>"); }
finally{

if(rs !=null) rs.close();
if(rs1 !=null) rs1.close();
if(stmt !=null) stmt.close();
if(stmt1 !=null) stmt1.close();
ConnectionManager.returnConnection(con,request);
}
%>



