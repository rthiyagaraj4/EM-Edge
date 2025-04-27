/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM ;

import java.io.*;
import java.sql.* ;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;


public class ChangeResponsibilityServlet extends HttpServlet {
	 			
	
	

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
	  Connection con = null;
		try
		{
	 	req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		String level					= req.getParameter( "level" ) ;
		if ( level 				== null ) level 			= "1" ;
		
         con=ConnectionManager.getConnection(req);
		if ( level.equals( "1" ) ) processLevel1( req, res,con) ;
		if ( level.equals( "2" ) ) processLevel2( req, res ,con) ;
	  }
	  catch(Exception e ){
		 e.printStackTrace();
		  }finally{
	  if(con!=null)
		  {
		  ConnectionManager.returnConnection(con,req);
		  }

	  }
	 
	}

	private void processLevel1( HttpServletRequest req, HttpServletResponse res,Connection con) throws IOException {
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");
    HttpSession session  				= req.getSession(true) ;
   	
	  PrintWriter out 			= res.getWriter() ;
     String responsibility_id			= req.getParameter( "responsibility_id" )==null?"":req.getParameter( "responsibility_id" ) ;
 	 int facility_count			= 0 ;
   	 String login_user=(String) session.getValue( "login_user" )==null?"":(String) session.getValue( "login_user" );
	try {
			
			PreparedStatement pstmt = con.prepareStatement( "select count(*) as count from sm_facility_param where (facility_id,facility_name) in ( select sm_facility_for_user.facility_id, facility_name from sm_facility_for_user, sm_facility_param where appl_user_id = ? and 	sm_facility_for_user.facility_id = sm_facility_param.facility_id and ( sysdate between nvl(sm_facility_for_user.access_eff_date_from,to_date('01/01/1472','dd/mm/rrrr') ) and nvl(sm_facility_for_user.access_eff_date_to,to_date('31/12/5000','dd/mm/rrrr') ) ) intersect select sm_facility_for_resp.facility_id, facility_name from sm_facility_for_resp, sm_facility_param where resp_id = ? and sm_facility_for_resp.facility_id = sm_facility_param.facility_id )" ) ;
			pstmt.setString( 1, login_user) ;
			pstmt.setString( 2, responsibility_id ) ;
			ResultSet rs = pstmt.executeQuery() ;
			if ( rs != null && rs.next() )
			facility_count = rs.getInt( "count" ) ;
			if ( rs != null ) rs.close() ;
			if ( pstmt != null ) pstmt.close() ;

		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
 
		
		String output				= "<link rel='stylesheet' type='text/css' href='../eCommon/html/IeStyle.css'>" ;
		output				= output + "<body onLoad=\"window.document.title='Switch Responsibility'\">" ;
		String sendBack				= "<hr><center> <input type='button' class='button' value='Back' onClick='history.back();'> </center>" ;
		sendBack				= sendBack + "</body>" ;
		
		if ( facility_count == 0 ) {
			
			//out.println( sendBack ) ;
		
		return ;
		}
		else if(facility_count == 1 ) 
		{
		String facility_id="";
		String facility_name="";
		String curr_user="";
		String ins_facility_id="";
		String ins_facility_name="";
		ResultSet rs_test=null;
		Statement stmt_test=null;
		java.util.Properties pr = new java.util.Properties() ;
		pr=(java.util.Properties)session.getValue("jdbc") ;
		curr_user=pr.getProperty("login_user");
		

		try{
		String facil_str="select facility_id,facility_name from sm_facility_param where (facility_id,facility_name) in ( select sm_facility_for_user.facility_id, facility_name from sm_facility_for_user, sm_facility_param where appl_user_id = '"+curr_user+"' and 	sm_facility_for_user.facility_id = sm_facility_param.facility_id and ( trunc(sysdate) between nvl(sm_facility_for_user.access_eff_date_from,to_date('01/01/1472','dd/mm/rrrr') ) and nvl(sm_facility_for_user.access_eff_date_to,to_date('31/12/5000','dd/mm/rrrr') ) ) intersect select sm_facility_for_resp.facility_id, facility_name from sm_facility_for_resp, sm_facility_param where resp_id ='"+responsibility_id+"' and sm_facility_for_resp.facility_id = sm_facility_param.facility_id )";
		stmt_test=con.createStatement();
		rs_test = stmt_test.executeQuery(facil_str);
		if(rs_test !=null){
		while (rs_test.next())
		{
			 ins_facility_id= rs_test.getString("facility_id");
			 ins_facility_name= rs_test.getString("facility_name");
		}
		}
		
		session.putValue( "responsibility_id",	responsibility_id ) ;
		session.putValue( "responsibility_name",	req.getParameter("responsibility_name")== null ?"":req.getParameter("responsibility_name") ) ;
		facility_id=ins_facility_id;
		facility_name=ins_facility_name;
	
		processLevel2(req,res,con);
		
		if(stmt_test!=null) stmt_test.close();
		if(rs_test!=null) rs_test.close();
	}
	catch ( Exception e ) {
	e.printStackTrace();
		
	}

		}
		else
		{
			session.putValue( "responsibility_id",	responsibility_id ) ;
			session.putValue( "responsibility_name", req.getParameter("responsibility_name")== null ?"":req.getParameter("responsibility_name") ) ;
			try 
			{
				res.sendRedirect( "../eSM/jsp/change_responsibility_form.jsp?level=2" ) ;
			} 
			catch ( Exception e ) 
			{
				e.printStackTrace();
			}
		}

		
	}
	private void processLevel2( HttpServletRequest req, HttpServletResponse res ,Connection con) throws IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out 			= res.getWriter() ;
		HttpSession session	= req.getSession(true) ;
		String responsibility_id			= req.getParameter( "responsibility_id" )==null?"":req.getParameter( "responsibility_id" ) ;
		String responsibility_name			= req.getParameter("responsibility_name")== null ?"":req.getParameter("responsibility_name");
		String bl_operational ="N";
		String operational_yn = "N";
		String bl_install_yn = "N";
		int mp_bl_count=0;
		
		 session.putValue( "responsibility_id",	responsibility_id ) ;
		 session.putValue( "responsibility_name",	responsibility_name ) ;
		String 	facility_id        = req.getParameter( "facility_id" ) ==null?"":req.getParameter( "facility_id" );
		String facility_name		= req.getParameter( "facility_name" )==null?"":req.getParameter( "facility_name" ) ;
        if(!facility_id.equals(""))
		{
		session.putValue("facility_id",facility_id) ;
		session.putValue("facility_name",facility_name) ;
        }
		try {
		//PreparedStatement 	pstmt = con.prepareStatement( "select app_server_ip from sm_facility_param where facility_id = ?" ) ;
		PreparedStatement 	pstmt = con.prepareStatement( "select install_yn bl_install_yn,(select operational_yn from sm_modules_facility where module_id='BL' and facility_id =?)operational_yn,(select app_server_ip from sm_facility_param where facility_id = ?)app_server_ip from sm_module where module_id='BL'" ) ;
			
			pstmt.setString( 1, facility_id ) ;
			pstmt.setString( 2, facility_id ) ;
			ResultSet rs = pstmt.executeQuery() ;

			if ( rs != null && rs.next() ) {
				String app_server_ip = rs.getString( "app_server_ip" ) ;
				bl_install_yn = rs.getString("bl_install_yn") == null ? "N": rs.getString("bl_install_yn");
				operational_yn = rs.getString("operational_yn") == null ? "N": rs.getString("operational_yn");
				if ( app_server_ip == null )
					app_server_ip = java.net.InetAddress.getByName( req.getServerName() ).getHostAddress() ;
				if(bl_install_yn.equals("Y") && operational_yn.equals("Y")){
					bl_operational = "Y";
					mp_bl_count = 1;
				}else{
					bl_operational = "N";
					mp_bl_count = 0;
				}
				session.putValue("bl_install_yn", bl_install_yn);
				session.putValue("bl_operational", bl_operational);
				session.putValue( "app_server_ip", app_server_ip ) ;
				
			}
            if (mp_bl_count > 0){
                session.putValue("mp_bl_oper_yn", "Y");
			}else{
                session.putValue("mp_bl_oper_yn", "N");
			}
			session.putValue("Login","Y");
			res.sendRedirect( "../eCommon/jsp/home.jsp" ) ;
			if ( rs != null ) rs.close() ;
			if ( pstmt != null ) pstmt.close() ;
		} catch ( Exception e ) {
			e.printStackTrace();
		} 
	}

}
