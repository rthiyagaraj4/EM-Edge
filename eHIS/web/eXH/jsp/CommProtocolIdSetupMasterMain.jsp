<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter,eXH.*"%>
<html>   
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eXH/js/CommProtocolId.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<%
//	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;

	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null; 
	Statement stmt1=null;
	ResultSet rs1=null; 

    String sql1 = "select 1 from SM_MENU_DTL where submenu_id='XH_JG_DEVELOPMENT_CONFIG' ";	
	String sql2 = "SELECT 1 FROM SM_MENU_RSTRN_RESP WHERE submenu_id='XH_JG_DEVELOPMENT_CONFIG' ";

	try{
		con = ConnectionManager.getConnection();
		stmt = con.createStatement();		
		rs  = stmt.executeQuery(sql1);
		if(rs.next()) {
//					System.out.println("rs.next 1: ");
			stmt1 = con.createStatement();		
			rs1  = stmt.executeQuery(sql2);
	        if(rs1.next()) {
//				  System.out.println("rs.next :2 ");
			}
			else{
				   params = params.substring(0,params.length()-12);
				   source = url + params+"access=YYYYY" ;
//				  System.out.println("flag source : "+source);
			}
		}
	}
	catch(Exception e){
		e.printStackTrace(System.err);
	}
	finally{		
		con.commit();
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(rs1 != null) rs1.close();
		if(stmt1 != null) stmt1.close();
		if(con != null) con.close();
	}
				
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:6.5vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:62vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod_detail' id='f_query_add_mod_detail'  src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:25vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:6.5vh;width:100vw'></iframe>

</html>





