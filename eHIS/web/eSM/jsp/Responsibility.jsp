<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<head>
	<script language='javascript' src='../../eSM/js/Responsibility.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	StringBuffer sb=new StringBuffer();
	sb.append(params);
	String params1=sb.toString();
	String source1 = url + params1 ;
	//Connection con=null;
	//Statement stmt=null;

		try{
			/*con = ConnectionManager.getConnection(request);
			ResultSet rset=null ;
			ResultSet rs=null ;
			String Role_id ="";
			int Medadmin=0;
			String Log_user= (String) session.getValue("login_user");
			String responsibility_id= (String) session.getValue("responsibility_id");
			stmt=con.createStatement();
			String sql="select count(*)  from sm_menu_admin where menu_admin_id='"+Log_user+"' and trunc (sysdate) >= nvl (trunc (eff_date_from), sysdate - 1) and trunc (sysdate) <= nvl (trunc (eff_date_to), sysdate + 1) ";
			
		
			rset=stmt.executeQuery(sql);
			if (rset !=null){
				while (rset.next()){
							Medadmin=Integer.parseInt(rset.getString(1));
					}
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();
			}*/

			/*String sqlRole ="select ora_role_id  from sm_resp  where resp_id='"+responsibility_id+"' ";
			stmt = con.createStatement();
			rs=stmt.executeQuery(sqlRole);
			if (rs !=null){
				while (rs.next()){
							Role_id=rs.getString(1);
					}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			}*/	
		%>
		
				
		<script>
		
		/*if (Role_id=='MEDADMIN' ) {
		document.write("<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>"+
							"<iframe src='../../eCommon/html/blank.html' name='f_query_add_mod' id='f_query_add_mod'  frameborder=0  style='height:83vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>");
		}
		elseif (parseInt(Medadmin) !=0 )
		{*/
		document.write("<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source1%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>"+
							"<iframe src='../../eCommon/html/blank.html' name='f_query_add_mod' id='f_query_add_mod'  frameborder=0  style='height:83vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>");


				/*}
			else
			{	
				var error=getMessage("MENU_ADMIN_ACCESS",'SM');
				alert(error);
				self.location.href='../../eCommon/html/blank.html';
			}*/
		</script>
		<form name=resp>
			<input type='hidden' name='Medadmin' id='Medadmin' value=''>
		</form>
		
		<%
			//if(stmt!=null) stmt.close();
		}catch(Exception e){out.println(e);}
			finally {
					
			//ConnectionManager.returnConnection(con,request);
}	
%>
</html>

