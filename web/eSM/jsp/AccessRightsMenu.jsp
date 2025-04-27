<!DOCTYPE html>
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%
	//Connection con=null;
	//Statement stmt=null;
		try{
		/*	request.setCharacterEncoding("UTF-8");
			con = ConnectionManager.getConnection(request);
			ResultSet rset=null ;
			ResultSet rs=null;
			String Role_id ="";
			int Medadmin=0;
			String Log_user= (String) session.getValue("login_user");
			String responsibility_id= (String) session.getValue("responsibility_id");

			stmt=con.createStatement();*/
			//String sql="select count(*)  from sm_menu_admin where menu_admin_id='"+Log_user+"' 	and to_char(sysdate,'dd/mm/yyyy')>= nvl(to_char(eff_date_from,'dd/mm/yyyy'),sysdate-1) and to_char(sysdate,'dd/mm/yyyy')<=nvl(to_char(eff_date_to,'dd/mm/yyyy'),sysdate+1) ";	
			/*String sql="select count(*)  from sm_menu_admin where menu_admin_id='"+Log_user+"' and trunc (sysdate) >= nvl (trunc (eff_date_from), sysdate - 1) and trunc (sysdate) <= nvl (trunc (eff_date_to), sysdate + 1)";	
			rset=stmt.executeQuery(sql);
			if (rset !=null){
						while (rset.next()){
									Medadmin=Integer.parseInt(rset.getString(1));
						}
						if (rset !=null)rset.close();
					}*/

			/*String sqlRole ="select ora_role_id  from sm_resp  where resp_id='"+responsibility_id+"' ";
			rs=stmt.executeQuery(sqlRole);
			if (rs !=null){
				while (rs.next()){
								Role_id=rs.getString(1);
						}
					if(rs!=null)rs.close();
					if(stmt!=null) stmt.close();
				}	*/
		%>

		<html>
		<head>
	<%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eSM/js/AccessRightsMenuFunc.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		</head>

		<script>
		
		//if (parseInt(Medadmin) >0  || Role_id=='MEDADMIN') {
		//if (parseInt(Medadmin) >0) {

		document.write("<iframe name='f_query_add_mod1' id='f_query_add_mod1' src='../../eSM/jsp/AddModifyAccessRightsMenuFunc.jsp' frameborder=0 scrolling='no' noresize style='height:110%;width:100vw'></iframe><iframe name='function_frame' id='function_frame'  src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:100vh;width:100vw'></iframe>");

		/*}
		else
			{
				var error=getMessage("MENU_ADMIN_ACCESS","SM");
				alert(error);
				self.location.href='../../eCommon/html/blank.html';
			}
*/
		</script>
		<%
		}catch(Exception e){//out.println(e);
			e.printStackTrace();
		} 
			finally {
	
	//ConnectionManager.returnConnection(con,request);
}
%>
</html>

