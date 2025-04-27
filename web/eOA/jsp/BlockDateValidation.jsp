<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<%
request.setCharacterEncoding("UTF-8");	

String to_date = request.getParameter("block_date");

Connection con = null;
Statement stmt =null;
PreparedStatement pstmt=null;
ResultSet rs = null;
ResultSet rs1 = null;
String wd1="";
try{
	con = ConnectionManager.getConnection(request);
 stmt = con.createStatement();
	//String sql="select ( ROUND(to_date('"+to_date+"', 'dd/mm/yyyy') - TRUNC(SYSDATE)) ) d FROM DUAL";
	String sql="select ( ROUND(to_date(?, 'dd/mm/yyyy') - TRUNC(SYSDATE)) ) d FROM DUAL";
	//rs = stmt.executeQuery(sql);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,to_date);
		rs = pstmt.executeQuery();
		while(rs.next()){
		wd1 = rs.getString("d");
		}


int check=Integer.parseInt(wd1);
if(check < 0 ){
	String a1="<html><head>	<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script> <script>parent.frames[1].document.frames[1].document.location.href='../../eCommon/html/blank.html' ; "
	+"alert(getMessage('BLOCK_DATE_LESS_SYSDATE','OA'));parent.frames[1].document.frames[0].document.forms[0].check.value=''; </script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";
	out.println(a1);
	}

else{
String a1="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"+
		"</script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";
		out.println(a1);
     }
	if (rs != null) rs.close();
	if (rs1 != null) rs1.close();
	if (stmt != null) stmt.close();
}catch(Exception e){
//out.println( "validation :" +e);
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
 }
finally
{
	
	ConnectionManager.returnConnection(con,request);
}

%>



