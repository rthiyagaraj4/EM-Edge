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
import java.util.*;
import webbeans.eCommon.*;
public class ChangePasswordServlet extends HttpServlet {
	Connection con ;
	PreparedStatement pstmt ;
	PreparedStatement pstmt1 ;
	ResultSet rs = null;
	ResultSet rs_ora=null;
    Properties p;
	String locale="";
	HttpSession session;
	//Added by Maheshwaran K for the Password Validation as on 11/07/2012
	//Start
	CallableStatement cs1=null;
	PreparedStatement pcs1=null;
	String user_status="";
	String tot_msg="";
	//End			
	public synchronized void  doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		session = req.getSession(false);
		PrintWriter out 			= res.getWriter() ;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
        this.p		  		= (java.util.Properties) session.getValue( "jdbc" ) ;
		String user 			= (String) session.getValue( "login_user" ) ;
		String password			= req.getParameter( "new_password1" ) ;
		String ph_install_yn	= req.getParameter( "ph_install_yn" ) ;
        String changepwdfor= req.getParameter("changepwdfor") ==null?"":req.getParameter( "changepwdfor" );
		String facility_id =(String) session.getValue( "facility_id" ) ;
        int result=0;
		String case_sensitive_password_yn			= req.getParameter( "case_sensitive_password_yn" ) ;//Maheshwaran added for the MMS-QH-CRF-0149
		int password_length_min		=0;
		int password_length_max		=0;
	//	int password_length_min			= Integer.parseInt(req.getParameter( "password_length_min" )) ;//Maheshwaran added for the MOHE-SCF-0155 as on 18-11-2021
	//	int password_length_max			= Integer.parseInt(req.getParameter( "password_length_max" )) ;//Maheshwaran added for the MOHE-SCF-0155 as on 18-11-2021
		//Added by Maheshwaran K for the Password Validation as on 11/07/2012
		//Start
		String old_password			= req.getParameter( "old_password" ) ;
		String resp_group_id		= req.getParameter("resp_group_id") ==null?"":req.getParameter("resp_group_id");
		//End
		String output				= "<html><head>  <link rel='stylesheet' type='text/css' href='../eCommon/html/IeStyle.css'></link> <Script src='../eCommon/js/messages.js' language='JavaScript'></Script></head>" ;
		output				= output + "<body onLoad=\"window.document.title='eCIS'\">" ;
		//String backToLogin			="<hr><center><input type='submit' class='BUTTON' value='Back' onClick='history.back();'></center>" ;
		//Added by Maheshwaran K for the Password Validation as on 11/07/2012
		//Start
		String backToLogin			="<hr><center><script>function HistBack(){document.location.href='../eSM/jsp/change_password_form.jsp?mainyn=Y';}</script><input type='button' class='BUTTON' value='Back' onClick='HistBack()'></center>" ;
		//End
		backToLogin			= backToLogin + "</body></html>" ;

		String connection_pooling_yn="";
		String ora_role_password="";
		
		MessageManager mm=new MessageManager();


		if ( password == null ) password = "" ;
		
		try
			{
			con=ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			pstmt	 = con.prepareStatement("select PASSWORD_LENGTH_MIN,PASSWORD_LENGTH_MAX from sm_site_param");
			rs=pstmt.executeQuery();
			if(rs.next())
				{
			//	ENFORCE_PASSWORD_POLICY_YN=rs.getString("ENFORCE_PASSWORD_POLICY_YN");
			//	CASE_SENSITIVE_PASSWORD_YN=rs.getString("CASE_SENSITIVE_PASSWORD_YN");
			//	ALLOWED_SPL_CHAR_IN_PASSWORD=rs.getString("ALLOWED_SPL_CHAR_IN_PASSWORD");
				password_length_min=rs.getInt("PASSWORD_LENGTH_MIN");
				password_length_max=rs.getInt("PASSWORD_LENGTH_MAX");
				}
			if(pstmt!=null)pstmt.close();	
			if(rs!=null)rs.close();	
			}
		catch(Exception e)	
			{
			System.out.println("Exception in sm_site_param : "+e);
			}
		//	System.out.println("ChangePasswordServlet.java-password.length()===="+password.length());
		//Added by Maheshwaran K for the MOHE-SCF-0155
		if(changepwdfor.equals("L"))
			{
		if ( password.length() < password_length_min)
			{
			out.println("<script>alert('APP-SM0153 Password should be of minimum "+password_length_min+" characters')");
			out.println("parent.window.close();</script>");
			return;
			}
		if (password.length() > password_length_max )
			{
			out.println("<script>alert('APP-SM0152 Password should be of maximum "+password_length_max+" characters')");
			out.println("parent.window.close();</script>");
			return;
			}
			}
		//End	
//	System.out.println("ChangePasswordServlet.java-password.length()1===="+password.length());
//Maheshwaran added for the MMS-QH-CRF-0149	

		try {
				
				connection_pooling_yn= (String) session.getValue("connection_pooling_yn");
				if(connection_pooling_yn.equals("Y")) 
				{
				String sql_ora=" Select APP_PASSWORD.DECRYPT(ORA_ROLE_PASSWORD) from sm_ora_role where ora_role_id='MEDADMIN' ";
					pstmt=con.prepareStatement(sql_ora);
					rs_ora=pstmt.executeQuery();
					if(rs_ora!=null)
					{
						while(rs_ora.next())
						{
							ora_role_password=rs_ora.getString(1);
						}
					}
					else
					{
						java.util.Hashtable mesg=mm.getMessage(locale, "NOT_FND_FOR_MEDADMIN", "SM") ;
                        String msg=(String)mesg.get("message");
						out.println("<script>alert('"+msg+"');</script>");
						mesg.clear();
					}

					if(ora_role_password !=null && !ora_role_password.equals("")){
						try{
							sql_ora="Set Role MEDADMIN identified by "+ora_role_password;
							if(pstmt!=null) pstmt.close();
							pstmt=con.prepareStatement(sql_ora);
							pstmt.execute();
							if(pstmt!=null) pstmt.close();
						}catch(Exception e){
							e.printStackTrace();
						}
					}else{
						try{
						sql_ora="Set Role MEDADMIN";
						if(pstmt!=null) pstmt.close();
						pstmt=con.prepareStatement(sql_ora);
						pstmt.execute();
						if(pstmt!=null) pstmt.close();
						}catch(Exception e){
							e.printStackTrace();
						}
					}				
			}

			if(pstmt!=null)  pstmt.close();
			//Added by Maheshwaran K for the Password Validation as on 11/07/2012
			//Start
			if(changepwdfor.equals("L")){
			if (!resp_group_id.equals(""))
				{	
				String alertVal = "";
				try
					{
					cs1 = con.prepareCall( "{ call SM_VALIDATE_USER.FAIL_LOGIN_ATTEMPT(?, ?, ?)}");
					cs1.setString ( 1,user   ) ;
					//Maheshwaran modified for the MMS-QH-CRF-0149
					if(case_sensitive_password_yn.equals("N"))
						{
						cs1.setString ( 2,old_password.toUpperCase() ) ;
						}
					else
						{
						cs1.setString ( 2,old_password) ;
						}
					cs1.registerOutParameter( 3, java.sql.Types.VARCHAR ) ;
					cs1.execute();
					user_status=cs1.getString(3);  
					if (user_status == null)
					user_status = "";
					cs1.close();
					}
				catch(Exception e)	
					{
					System.out.println("Exception occurred while calling SM_VALIDATE_USER.FAIL_LOGIN_ATTEMPT Procedure "+e);
					e.printStackTrace();
					}
				tot_msg = user_status;
				if (user_status.equals("INVALID_PASSWORD"))
					{
					out.println("<script>alert(' APP-SM1015 Invalid Password ')");
                    out.println("document.location.href='../eSM/jsp/change_password_form.jsp?mainyn=Y';</script>");
					}
				else if (user_status.equals("USER_LOCKED"))
					{
					out.println("<script>alert('APP-SM0064 User Account Locked.')");
                    out.println("parent.window.close();</script>");
                    return;
					}	
				else if (user_status.equals("MAX_LOGIN_ATTEMP_EXCEDDED"))
					{
					 out.println("<script>alert('APP-SM0132 Maximum Login Attempt Exceeded')");
                	out.println("parent.window.close();<script>");
                    return;
					}
				else if (user_status.equals("SUCCESS"))
					{					 
					}	
				else if (user_status.equals("PASSWORD_EXPIRED"))
					{
					out.println("<script>alert('APP-SM0133 Database Password Expired.');</script>");	
                    return;	
					}
				else	
					{							
					out.println("<script>alert(' "+ tot_msg + " ')");
                    out.println("document.location.href='../eSM/jsp/change_password_form.jsp?mainyn=Y';");
					session.putValue("login_user",user);					
                    return;
					}	
				try
					{
					String valcal = "select SM_VALIDATE_USER.PASS_VALID_CHECK(?, ?) FROM dual";
					pcs1=con.prepareStatement(valcal);
					pcs1.setString ( 1,user   ) ;
					//Maheshwaran modified for the MMS-QH-CRF-0149
					if(case_sensitive_password_yn.equals("N"))
						{
						pcs1.setString ( 2,password.toUpperCase() ) ;
						}
					else
						{
						pcs1.setString ( 2,password) ;
						}
					if(rs!=null) rs.close();
					rs = pcs1.executeQuery();
					if (rs != null && rs.next())
						{
						user_status = rs.getString(1) == null ? "" : rs.getString(1);
						}
					if (rs != null)
						rs.close();
					if (pcs1 != null)
						pcs1.close();	
					}
				catch(Exception e)	
					{
					System.out.println("Exception occurred while calling SM_VALIDATE_USER.PASS_VALID_CHECK Procedure "+e);
					e.printStackTrace();
					}
				if(user_status.equals("CANNOT_REUSE:1"))
					{
					java.util.Hashtable mesg=mm.getMessage(locale, "CANNOT_REUSE:1", "SM") ;
					alertVal=(String)mesg.get("message");
					mesg.clear();
					out.println("<script>alert(\""+alertVal+"\")");
                    out.println("document.location.href='../eSM/jsp/change_password_form.jsp?mainyn=Y';</script>");
					return;
					}
				else if(user_status.equals("CANNOT_REUSE:2"))
					{
					java.util.Hashtable mesg=mm.getMessage(locale, "CANNOT_REUSE:2", "SM") ;
					alertVal=(String)mesg.get("message");
					mesg.clear();
					out.println("<script>alert(\""+alertVal+"\")");
                    out.println("document.location.href='../eSM/jsp/change_password_form.jsp?mainyn=Y';</script>");
					return;
					}	
				else if(user_status.equals("CANNOT_REUSE:3"))
					{
					java.util.Hashtable mesg=mm.getMessage(locale, "CANNOT_REUSE:3", "SM") ;
					alertVal=(String)mesg.get("message");
					mesg.clear();
					out.println("<script>alert(\""+alertVal+"\")");
                    out.println("document.location.href='../eSM/jsp/change_password_form.jsp?mainyn=Y';</script>");
					return;
					}	
				}
				}
			//End
			if(changepwdfor.equals("L"))
			{
			try
				{
				String dbsql = " alter user "+user+" identified by "+'"'+""+password.toUpperCase()+""+'"'+"";//Maheshwaran added for the MMS-QH-CRF-0149
				pstmt = con.prepareStatement( dbsql );
				pstmt.execute();
				}
			catch(Exception e)	
				{
				System.out.println("Exception occurred while altering USER "+e.toString());
				e.printStackTrace();
				}
			if(pstmt!=null)  pstmt.close();
			pstmt = con.prepareCall( "update sm_appl_user set appl_user_password = app_password.encrypt(?),modified_date=sysdate,FIRST_LOGIN_YN=?  where appl_user_id = ? " ) ;
			//Maheshwaran modified for the MMS-QH-CRF-0149
			if(case_sensitive_password_yn.equals("N"))
				{
				pstmt.setString( 1, password.toUpperCase() ) ;
				}
			else
				{
				pstmt.setString( 1, password) ;
				}
			pstmt.setString( 2, "N" ) ;
			pstmt.setString( 3, user ) ;
			result=pstmt.executeUpdate() ;
            if(pstmt!=null)pstmt.close();
			
			
			}else if(changepwdfor.equals("P"))
			{
			pstmt = con.prepareCall( "update sm_appl_user set PIN_NO = app_password.encrypt(?)  where appl_user_id = ? " ) ;
			pstmt.setString( 1, password ) ;
			pstmt.setString( 2, user ) ;
			result=pstmt.executeUpdate() ;
            if(pstmt!=null)pstmt.close();
			


			}else if(changepwdfor.equals("S"))
			{
			pstmt = con.prepareCall( "update mr_user_access_rights set SEN_DIAG_PASSWORD = app_password.encrypt(?)  where appl_user_id = ? and FACILITY_ID=?" ) ;
			pstmt.setString( 1, password ) ;
			pstmt.setString( 2, user ) ;
			pstmt.setString( 3, facility_id ) ;
			result=pstmt.executeUpdate() ;
            if(pstmt!=null)pstmt.close();
			}else if(changepwdfor.equals("H"))
			{
			pstmt = con.prepareCall( "update mr_user_access_rights set HIGH_RISK_PASSWORD = app_password.encrypt(?)  where appl_user_id = ? and FACILITY_ID=?" ) ;
			pstmt.setString( 1, password ) ;
			pstmt.setString( 2, user ) ;
			pstmt.setString( 3, facility_id ) ;
			result=pstmt.executeUpdate() ;
            if(pstmt!=null)pstmt.close();
					
			}else if(changepwdfor.equals("PH") && ph_install_yn.equals("Y"))
			{
			 pstmt = con.prepareCall( "update PH_DISP_USERS set DISP_PASSWORD = app_password.encrypt(?)  where appl_user_id = ? " ) ;
			pstmt.setString( 1, password ) ;
			pstmt.setString( 2, user ) ;
			result=pstmt.executeUpdate() ;
            if(pstmt!=null)pstmt.close();
			}

			if ( result != 0 ) {
				if(changepwdfor.equals("L"))
					session.putValue( "login_password",password) ;
					con.commit();
					String alertVal = "";
					/*pstmt1 = con.prepareStatement("Select MESSAGE_ID, MESSAGE_TEXT_SYSDEF From SM_MESSAGE Where MESSAGE_REF = ? ");
					pstmt1.setString( 1, "PASSWORD_CHANGED" ) ;
					rs = pstmt1.executeQuery();

					if(rs.next())
					{
						String val1 = rs.getString(1);	
						String val2	= rs.getString(2);
						alertVal = "APP-"+val1+" "+val2;
					}*/
                      java.util.Hashtable mesg=mm.getMessage(locale, "PASSWORD_CHANGED", "SM") ;
                        alertVal=(String)mesg.get("message");
						mesg.clear();
					out.println("<script>alert(\""+alertVal+"\");parent.window.returnValue='"+password+"'; parent.window.close();</script>");
					
					
				}
			else{
				con.rollback();
				out.println("<script>parent.window.returnValue='F';parent.window.close();</script>");
			}

			if(rs != null)rs.close();
			if(rs_ora !=null) rs_ora.close();
			if ( pstmt != null ) pstmt.close() ;
			if ( pstmt1 != null ) pstmt1.close() ;

		} catch ( Exception e ) {
			try{
			con.rollback();
			}
			catch(Exception es){
				es.printStackTrace();
			}
			out.println(output);
			out.println(e.getMessage() ) ;
			out.println(backToLogin);
			e.printStackTrace();
		} 
		
		finally	{
			  if (con != null)
			  {
			   try {
								 
				 ConnectionManager.returnConnection(con,req);
		       } catch (Exception ee) {
				   ee.printStackTrace();
			   }
		      }

		}

	}
}
