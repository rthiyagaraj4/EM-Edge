<!DOCTYPE html>
<%@ page import="java.sql.*, java.net.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>

<html>
<head>
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
         <script src='../../eSM/js/OperationalStatus.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%	request.setCharacterEncoding("UTF-8");
		Connection con=null;
		con = ConnectionManager.getConnection(request);
		Statement stmt = null;
		Statement stmt1 = null;
		ResultSet rs = null;	

	try
	{	
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;	
		String params = request.getQueryString() ;	
		String source = url + params ;

		int count=0;
		stmt=con.createStatement();

		String sql_site=" select count(*) from  sm_site_param ";
		
		rs = stmt.executeQuery( sql_site ) ;
		if(rs!=null)
		{
			while(rs.next())
			{
				count=rs.getInt(1);
			}
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		
		if(count<=0)
		{
		%>
			<script>alert(getMessage('SITE_NOT_DEFINED','SM'));	
			self.location.href='../../eCommon/html/blank.html';</script>
		<%
		}
		//Commeted By Dharma on 26th Oct 2017 against 65529
		/*else
		{
			String Role_id ="";
			stmt1 = con.createStatement();
			String responsibility_id= (String) session.getValue("responsibility_id");

			String sqlRole ="select ora_role_id  from sm_resp  where resp_id='"+responsibility_id+"' ";
			rs = stmt1.executeQuery(sqlRole);
			if (rs !=null)
			{
				while (rs.next())
				{
					Role_id = rs.getString(1);
				}
			}
			if(rs!=null)rs.close();
			if(stmt1!=null)stmt1.close();

				if (!Role_id.equals("MEDADMIN"))
				{
				%>
				<script>
				//var error=getMessage('INVALID_USER','Common');
				var error=getMessage('INVALID_USER','SM');
				alert(error);
				self.location.href='../../eCommon/html/blank.html';
				</script>
				 <%
				}
		}*/

	%>		
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>	
	<iframe name='f_query_main' id='f_query_main' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:15vh;width:100vw'></iframe>
	<iframe name='f_query_header' id='f_query_header' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:28vh;width:100vw'></iframe>
	<iframe name='f_query_details' id='f_query_details' 	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:40vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
	<%	
		
		}catch(Exception e){out.println(e);}
	finally 
	{ 
		
		
		if(con != null)
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>

