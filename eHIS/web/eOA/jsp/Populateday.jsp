<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.* " %>
<%
PreparedStatement pstmt=null;
ResultSet rset=null;
Connection conn = null;
request.setCharacterEncoding("UTF-8");
String dat = request.getParameter("dat")==null?"":request.getParameter("dat");
String sysday="";
String sql;
try{
if (!dat.equals(""))
{

		conn = ConnectionManager.getConnection(request);
		//sql="select to_char(to_date('"+dat+"','dd/mm/rrrr'),'DAY') day from dual";
		sql="select to_char(to_date(?,'dd/mm/rrrr'),'DAY') day from dual";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,dat);
		rset = pstmt.executeQuery () ;

		if(rset != null)
		{
			while(rset.next())
			{
				sysday=rset.getString("day");
			}
		}
%>
	<script>
	parent.frames[1].document.forms[0].sys1.innerText='<%=sysday%>';
	</script>
	<%
}
else
{
%>
	<script>
	parent.frames[1].document.forms[0].sys1.innerText="";
	</script>

<%
}
  	if ( rset != null ) rset.close() ;
	if ( pstmt != null ) pstmt.close() ;

 }
catch ( Exception e )
{
//out.println(e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{
	ConnectionManager.returnConnection(conn,request);
}
%>
	<script>
	location.href = '../../eCommon/jsp/error.jsp';
	</script>		
