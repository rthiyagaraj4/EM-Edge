<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
f<%@ page contentType="text/js;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>

function MainMenu() {
<%!
	Connection con ;
	PreparedStatement pstmt ;
	ResultSet rs ;
%>

<%
//	con = (Connection) session.getValue( "connection" ) ;
	try{con=ConnectionManager.getConnection(request);
	String responsibility_id	= (String) session.getValue( "responsibility_id" ) ;
	String root_menu_id = "";

	String menuIdSql		= "select menu_id from sm_resp where resp_id = ? " ;
	pstmt = con.prepareStatement( menuIdSql ) ;
	pstmt.setString( 1, responsibility_id ) ;
	rs = pstmt.executeQuery() ;
	if ( rs != null ) {
			rs.next() ;
			root_menu_id = rs.getString( "menu_id" ) ;
	}

	rs.close();
	pstmt.close();

	String menu_sql	= "select menu_dtl.p_level, menu_dtl.menu_id menu_id, menu_dtl.submenu_id submenu_id, menu_dtl.option_type, "+
        		   "menu_dtl.option_descriptor option_descriptor, menu_dtl.function_id function_id, sm_function.executable_name from "+
        		   "sm_menu_hdr menu_hdr,( select level p_level,menu_id,submenu_id ,function_id,module_id, option_type, option_descriptor "+
 			   "from sm_menu_dtl connect by prior submenu_id=menu_id start with  menu_id=? "+       			   "order by rownum) menu_dtl,sm_module module,sm_function sm_function "+
  			   "where  menu_dtl.menu_id=menu_hdr.menu_id and menu_dtl.module_id = module.module_id (+) and "+
  		           "sm_function.module_id (+) = menu_dtl.module_id   and sm_function.function_id  (+)= menu_dtl.function_id and "+
			   "submenu_id is not null order by p_level desc";

	String submenu_sql	= "select menu_dtl.p_level, menu_dtl.menu_id menu_id, menu_dtl.submenu_id submenu_id, menu_dtl.option_type, "+
        		   "menu_dtl.option_descriptor option_descriptor, menu_dtl.function_id function_id, sm_function.executable_name from "+
        		   "sm_menu_hdr menu_hdr,( select level p_level,menu_id,submenu_id ,function_id,module_id, option_type, option_descriptor,OPTION_SEQUENCE_NO "+
 			   "from sm_menu_dtl connect by prior submenu_id=menu_id start with  menu_id=? "+       			   "order by rownum) menu_dtl,sm_module module,sm_function sm_function "+
  			   "where  menu_dtl.menu_id=menu_hdr.menu_id and menu_dtl.module_id = module.module_id (+) and "+
  		           "sm_function.module_id (+) = menu_dtl.module_id   and sm_function.function_id  (+)= menu_dtl.function_id and "+
			   "submenu_id is not null order by OPTION_SEQUENCE_NO  ";

	String function_sql= "select menu_dtl.p_level, menu_dtl.menu_id menu_id, menu_dtl.submenu_id submenu_id, menu_dtl.option_type, "+
        		   "menu_dtl.option_descriptor option_descriptor, menu_dtl.function_id function_id, sm_function.executable_name from "+
        		   "sm_menu_hdr menu_hdr,( select level p_level,menu_id,submenu_id ,function_id,module_id, option_type, option_descriptor "+
 			   "from sm_menu_dtl connect by prior submenu_id=menu_id start with  menu_id=? "+
       			   "order by rownum) menu_dtl,sm_module module,sm_function sm_function "+
  			   "where  menu_dtl.menu_id=menu_hdr.menu_id and menu_dtl.module_id = module.module_id (+) and "+
  			   "sm_function.module_id (+) = menu_dtl.module_id   and sm_function.function_id  (+)= menu_dtl.function_id and "+
			   "submenu_id is null order by p_level ";

	//Class.forName( "oracle.jdbc.driver.OracleDriver" ) ;
	//con = DriverManager.getConnection( "jdbc:oracle:thin:@192.5.2.235:1521:csdv", "developer", "developer" ) ;

	pstmt = con.prepareStatement( menu_sql ) ;
	pstmt.setString( 1, root_menu_id ) ;
	rs = pstmt.executeQuery() ;

	while ( rs != null && rs.next() ) {
		//String menu_id = rs.getString( "menu_id" ) ;
		//String option_type = rs.getString( "option_type" ) ;
		String submenu_id = rs.getString( "submenu_id" ) ;
		String option_descriptor = rs.getString( "option_descriptor" ) ;
		//String executable_name = rs.getString( "executable_name" ) ;

		if ( submenu_id != null ) {
				out.println( "window." + submenu_id + " = new Menu('" + option_descriptor + "')") ;
		}
	}
	rs.close();
	pstmt.close();

	out.println( "window.mainMenu = new Menu() ;" ) ;

	pstmt = con.prepareStatement( function_sql ) ;
	pstmt.setString( 1, root_menu_id ) ;
	rs = pstmt.executeQuery() ;

	while ( rs != null && rs.next() ) {
		String menu_id = rs.getString( "menu_id" ) ;
		//String option_type = rs.getString( "option_type" ) ;
	//	String submenu_id = rs.getString( "submenu_id" ) ;
		String option_descriptor = rs.getString( "option_descriptor" ) ;
		String executable_name = rs.getString( "executable_name" ) ;

		out.println( menu_id + ".addMenuItem( '" + option_descriptor + "', 'location=\"" + executable_name + "\"' )" ) ;
	}


	pstmt = con.prepareStatement( submenu_sql ) ;
	pstmt.setString( 1, root_menu_id ) ;
	rs = pstmt.executeQuery() ;
	//boolean flag=true;

	while ( rs != null && rs.next() ) {
		String menu_id = rs.getString( "menu_id" ) ;
		//String option_type = rs.getString( "option_type" ) ;
		String submenu_id = rs.getString( "submenu_id" ) ;
		//String option_descriptor = rs.getString( "option_descriptor" ) ;
	//	String executable_name = rs.getString( "executable_name" ) ;

		if ( submenu_id != null ) {
			if ( !menu_id.equalsIgnoreCase( root_menu_id ) ) {
						out.println( menu_id + ".addMenuItem("+submenu_id+")" );
 				} else {
				out.println( "mainMenu.addMenuItem( " + submenu_id + " )" ) ;
			}
		}
	}
	rs.close();
	pstmt.close();
	out.println( "mainMenu.writeMenus() ;" ) ;
%>

<%
	try {
		if ( rs != null ) rs.close() ;
		if ( pstmt != null ) pstmt.close() ;
	} catch ( Exception e ) {}

	}catch(Exception e){out.println(e);}
			finally { 
	if(con!=null)
	ConnectionManager.returnConnection(con,request);
}	
%>
}
</script>

<script language='JavaScript'>
  	if ( document.all ) MainMenu() ;
	if ( document.layers ) MainMenu() ;
</script>

