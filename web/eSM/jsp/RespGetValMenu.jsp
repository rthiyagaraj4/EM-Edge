<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>

<%
    request.setCharacterEncoding("UTF-8");
	String MenuName		= request.getParameter("MenuName");
	String menuid		= request.getParameter("Menu_id");
	Connection con=null;
			try{
			con = ConnectionManager.getConnection(request);
			Statement stmt=null;
			ResultSet rs = null;
			String sql="";
			String dat="";
			String id="";

			String responsibility_id= (String) session.getValue("responsibility_id");
			stmt=con.createStatement();
			String sqlResp="select ora_role_id  from sm_resp  where resp_id='"+responsibility_id+"'";
			rs=stmt.executeQuery(sqlResp);
			if (rs !=null){
				while (rs.next()){

				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			%>
			<html>
				<HEAD>
					<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

				</HEAD>
				<body  onKeyDown = 'lockKey()'; OnMouseDown='CodeArrest()' ; CLASS='MESSAGE'>
				<form name='testform' id='testform'>
			<%
		try{
			if (!(MenuName.equals("") || MenuName == null)){
			%>

			<script>
					var opt = parent.document.frames[1].document.createElement("OPTION");
					opt.text = '------------------------ Select ------------------------------';
					opt.value= '';
					parent.frames[1].document.forms[0].menu_id.add(opt);
				
					</script>
						<%
							sql  = " select menu_id, menu_NAME from sm_menu_hdr where root_menu_yn='Y'  and resp_group_id='"+MenuName+"'  order by  menu_NAME ";
				
						stmt = con.createStatement() ;
						rs = stmt.executeQuery(sql) ;

						if (rs != null)
						{
							while(rs.next())
							{
								dat=rs.getString("menu_NAME");
								id=rs.getString("menu_id");

						

					%>
							<script>
									var p = "<%=menuid%>";
									var d = "<%=id%>";
									var element = parent.frames[1].document.createElement('OPTION');
									element.text = "<%=dat%>";
									element.value= "<%=id%>";
									if (p ==d)
										element.selected=true;
									parent.frames[1].document.forms[0].menu_id.add(element);
							</script>

		<%
			}
					}
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
		}
		else 
				{
			%>
					<script>

					var opt = parent.document.frames[1].document.createElement("OPTION");
					opt.text = '------------------------ Select ------------------------------';
					opt.value= '';
					parent.frames[1].document.forms[0].menu_id.add(opt);
					
					</script>
						<%
						sql  = " select menu_id, menu_NAME from sm_menu_hdr where root_menu_yn='Y'  order by  menu_NAME "  ;
					stmt = con.createStatement() ;
					rs = stmt.executeQuery(sql) ;

					if (rs != null)
					{
						while(rs.next())
						{
							dat=rs.getString("menu_NAME");
							id=rs.getString("menu_id");
		
						

					%>
							<script>
									var p = "<%=menuid%>";
									var d = "<%=id%>";	
									var element = parent.frames[1].document.createElement('OPTION');
									element.text = "<%=dat%>";
									element.value= "<%=id%>";
									if (p ==d)
										element.selected=true;
									parent.frames[1].document.forms[0].menu_id.add(element);
							</script>

		<%}
					}
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();

		}
		}
		catch(Exception e)
		{
			out.print(e);
		}
			if(stmt != null)stmt.close();
			if(rs != null) rs.close();

			}catch(Exception e){out.println(e);}
			finally { 
				ConnectionManager.returnConnection(con,request);
}
%>
</form>
</body>
</html>



