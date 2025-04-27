<!DOCTYPE html>

<%@ page import= "java.util.*,java.sql.*,java.text.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
  <%
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
  %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eSM/js/OraRole.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
    request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/MstCodeToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	String ValUser = "";	
	String responsibility_id= (String) session.getValue("responsibility_id");

	//Connection con=null;
	//Statement stmt=null;
	try{
	/*con = ConnectionManager.getConnection(request);
	
	ResultSet rset=null ;
	stmt=con.createStatement();
	String sql="select ora_role_id from sm_resp where resp_id='"+responsibility_id+"'";
	rset=stmt.executeQuery(sql);
	if (rset !=null)
	{
		while (rset.next())
		{
			ValUser =rset.getString(1);					
			if(ValUser == null) ValUser = "";
		}
	}
	if(rset!=null)rset.close();
	if(stmt!=null)stmt.close();
	
	 if (ValUser.equals("MEDADMIN"))
	   {
	*/   
%>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>				
		<iframe name='f_query_add_mod' id='f_query_add_mod' 	 src='../jsp/AddDatabaseRole.jsp' frameborder=0 style='height:37vh;width:100vw'></iframe>
		<iframe name='result' id='result' 	 src="../../eCommon/html/blank.html"; frameborder=0 scrolling='no'  style='height:48vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/MstCodeError.jsp'frameborder=0 noresize scrolling='auto' style='height:7vh;width:100vw'></iframe>
<iframe name='blankFrame' id='blankFrame' 	 src="../../eCommon/html/blank.html"; frameborder=0 scrolling='no' style='height:0vh;width:100vw'></iframe>

<%
	/*  }
	  else
	   {
%>
		<SCRIPT>
			alert(getMessage('INVALID_USER','SM'));			
			self.location.href='../../eCommon/html/blank.html';
		</SCRIPT>
<%		
	   }
	   % style='height:0%;width:100vw'></iframe><%
	*/


	
}catch(Exception e){out.println(e);}
finally {
			//ConnectionManager.returnConnection(con,request);
		}	
%>
</html>

