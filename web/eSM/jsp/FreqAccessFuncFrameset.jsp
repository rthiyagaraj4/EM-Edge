<!DOCTYPE html>

<html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<head>
	<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../js/FreqAccessFunc.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<script>

</script>
<%
    request.setCharacterEncoding("UTF-8");
	Connection conn = null;
	Statement stmt = null;
	try{
		conn = ConnectionManager.getConnection(request);
	ResultSet rset=null;
	stmt = conn.createStatement();
	
	String responsibility_id= (String) session.getValue("responsibility_id");
	String menu="";
	String menu_id="";
	
	String sqlMenu="Select a.menu_name,a.menu_id from sm_resp_vw a  where a.resp_id='"+responsibility_id+"'   ";
	rset = stmt.executeQuery(sqlMenu);
	if(rset!=null  && rset.next())
	{
		menu=rset.getString(1);
		menu_id=rset.getString(2);
	}
	if(rset!=null)rset.close();
	if(stmt!=null)stmt.close();
%>

<iframe name='addSearch' id='addSearch' 	src='../../eSM/jsp/AddModifyFreqAccessFunc.jsp?menu_id= <%=menu_id%>&menu=<%=menu%>'   frameborder=0 scrolling=auto noresize style='height:50vh;width:100vw'></iframe>
	<iframe name='Search' id='Search' 	src='../../eSM/jsp/FreqAccessSearchCriteria.jsp?menu_id= <%=menu_id%>&menu=<%=menu%>'   frameborder=0 scrolling=auto noresize style='height:9vh;width:100vw'></iframe>
	<iframe name='FunctionInclude' id='FunctionInclude'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:41vh;width:100vw'></iframe>
<%
}catch(Exception e){out.println(e);}
			finally {
				if(stmt!=null) stmt.close();
				
	ConnectionManager.returnConnection(conn,request);
}		
%>
</html>

