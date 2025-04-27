<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>

<head>
<%
          request.setCharacterEncoding("UTF-8");
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

function fetchVals1()
{
}
</script>
<%
	Connection con = null;
	Statement stmt=null;
	try{
	con = ConnectionManager.getConnection(request);
	
	ResultSet rs=null ;
    String tableid = request.getParameter("tableid");
	int total_column=0;
	String sql="";

	stmt=con.createStatement();
	%>
 	<body  onLoad="FocusFirstElement()" ;onKeyDown = 'lockKey()'; OnMouseDown="CodeArrest()";> 
		<form name='RecordTransForm2' id='RecordTransForm2' action='../../servlet/eOP.VTForClinicServlet' method='post' target='messageFrame'>
			<table align = 'center' width='80%' cellspacing=0 cellpadding=0 border=0>
		<%
				     try{
				     	sql="select count(1) count from sm_record_trans_dtl where table_id= '"+tableid+"'";
				 
						rs=stmt.executeQuery(sql) ;

				        if(rs!=null)
					    {
					      while(rs.next())
					  	   {
							 total_column = rs.getInt("count");
							 out.println("<th align = 'left' colspan="+ total_column +">    				 ");
 
						   }
    				     }
						 if(rs!=null)rs.close();
						 if(stmt!=null)stmt.close();
    				   }
    				    	catch(Exception e){out.println(e.toString());}

				     try{
				     	sql="select language_id, short_name  from sm_language where usage_type= 'M'";
				        rs=stmt.executeQuery(sql) ;

				        if(rs!=null)
					    {
					      while(rs.next())
					  	   {
					         out.println("Main Language : "+rs.getString("short_name")+"</th></tr><tr>");
    				       }
    				     }
						 if(rs!=null)rs.close();
						 if(stmt!=null)stmt.close();
    				   }
    				    	catch(Exception e){out.println(e.toString());}
				        %>
                     
    				 </th>
    			</tr><tr> 
		  				 </th>
    				</tr>           

						</table>

						</form>
</body>
</html>
 <%
	}catch(Exception e){}
finally{
	if(stmt!=null) stmt.close();
if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

