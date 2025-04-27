<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
     <%
	      request.setCharacterEncoding("UTF-8");
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
<%

			Connection con=null;
			Statement stmt = null;
			try{
					con = ConnectionManager.getConnection(request);
					ResultSet rs =null;
					String resp_id=request.getParameter("resp_id");
					String menu_name="";
					String menu_id="";
					String sql="Select menu_name,menu_id from sm_resp_vw where resp_id='"+resp_id+"'";
					stmt=con.createStatement();
					rs=stmt.executeQuery(sql);
					if(rs!=null)
					{
						while(rs.next())
						{
							menu_name=rs.getString("menu_name");
							if(menu_name == null) menu_name="";
							menu_id=rs.getString("menu_id");
							if(menu_id == null) menu_id="";
		%>
			<script>
							var menu_name='<%=menu_name%>';
							var menu_id='<%=menu_id%>';
							parent.frames[1].frames[0].document.getElementById('menudisp').innerText=getLabel('Common.menu.label','common');
							parent.frames[1].frames[0].document.getElementById('menu_name').innerText="<%=menu_name%>";
							parent.frames[1].frames[0].document.forms[0].menu_id.value='<%=menu_id%>';
			</script>
		<%

						}
					}
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
					
		%>
		</head>
		<body class=message onKeyDown = 'lockKey()'>
				<form name='dummyform' id='dummyform'>
				</form>
			</body>
		<%

		if(stmt != null) stmt.close();
		}catch(Exception e){out.println(e);}
	finally {
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>

