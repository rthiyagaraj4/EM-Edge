<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<html>
	<head>
		<%
		request.setCharacterEncoding("UTF-8");
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
 <body OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
		<%
			Connection con=null;
			Statement stmt = null;
			try{
			con = ConnectionManager.getConnection(request);
			
			ResultSet rs =null;
			
			stmt	=	con.createStatement();
			rs = stmt.executeQuery( "select site_id from sm_site_param" );

	      if( rs.next() )
	      {
					  
			  %>
				  <script>
				     parent.frames[0].document.forms[0].create.disabled=true;
				  </script>
			  <%
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
		  }
	String Role_id ="";


	stmt=con.createStatement();
	
	String responsibility_id= (String) session.getAttribute("responsibility_id");

	String sqlRole ="select ora_role_id  from sm_resp  where resp_id='"+responsibility_id+"' ";
	rs=stmt.executeQuery(sqlRole);
	if (rs !=null){
		while (rs.next()){
					Role_id=rs.getString(1);
			}
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	}	


if (!Role_id.equals("MEDADMIN"))
{
%>
<script>
var error=getMessage('INVALID_USER','SM');
alert(error);
self.location.href='../../eCommon/html/blank.html';
</script>
			  <%
				}
			
			}catch(Exception e){out.println(e);}
			finally { 
				if(stmt!=null) stmt.close();
	ConnectionManager.returnConnection(con,request);
}

			

		%>
</body>
</html>

