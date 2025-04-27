/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.lang.reflect.Method;
import java.net.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*; 
import eXH.XHDBAdapter;
import eXH.ArrayAuditInfo;
import eXH.XHTYPE;

/**																	  						 
 *  Class used to update autorized users setup
 * 
 */
public class AuthorizedUsersAddModifyServlet extends HttpServlet
{

    HttpServletRequest req=null;
    /**
	 * Do post method which implements the functionalities for  autorized users setup
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
        PrintWriter out;
		out=response.getWriter();
		req=request;
        HttpSession session=request.getSession(false);
		
		Properties p;		
		  p = (Properties) session.getValue("jdbc");	
			String locale  = p.getProperty("LOCALE");
 
		request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");
      
        ResultSet rs1 = null;
        Statement stmt1 = null;
		Connection con = null;
       
		String mode=request.getParameter("mode");
	//	System.out.println("AuthorizedUsersAddModifyServlet.java mode : "+mode);
	
	
		String login_name = "";
		String view_yn = "";
		String replay_yn = "";
		String rebuild_yn = "";

		String reload_yn = "";
		String debug_yn = "";
		String audit_yn = "";
		String comm_exc_yn = "";
		String write_to_excel = "";
		String help="";
		String notification_yn = "";
		ArrayList auth_main = new ArrayList();
		ArrayList array_auth_temp = null;
		ArrayList array_auth_del=null;
		ArrayList array_auth_del1=null;
    
         login_name=XHDBAdapter.checkNull(request.getParameter("login_name"));
		 view_yn=XHDBAdapter.checkNullForCheckBox(request.getParameter("view_yn"));
		 replay_yn=XHDBAdapter.checkNullForCheckBox(request.getParameter("replay_yn"));
		 rebuild_yn=XHDBAdapter.checkNullForCheckBox(request.getParameter("rebuild_yn"));
// new fields added 
		 reload_yn=XHDBAdapter.checkNullForCheckBox(request.getParameter("reload_yn"));
		// debug_yn=XHDBAdapter.checkNullForCheckBox("");//Modified by laxman 21/4/09request.getParameter("debug_yn")
          debug_yn="N";
		 audit_yn=XHDBAdapter.checkNullForCheckBox(request.getParameter("audit_yn"));
		 comm_exc_yn=XHDBAdapter.checkNullForCheckBox(request.getParameter("comm_exc_yn"));
		 write_to_excel=XHDBAdapter.checkNullForCheckBox(request.getParameter("write_to_excel"));

				help = XHDBAdapter.checkNullForCheckBox(request.getParameter("help"));
//								System.out.println("write_to_excel : "+write_to_excel);
				notification_yn=XHDBAdapter.checkNullForCheckBox(request.getParameter("notification_yn"));
				
				
						
    	 if(mode.equalsIgnoreCase("I"))
		{
			array_auth_temp = new ArrayList();
			array_auth_temp.add(login_name);
			array_auth_temp.add(view_yn);
			array_auth_temp.add(replay_yn);
			array_auth_temp.add(rebuild_yn);
			array_auth_temp.add(mode);
			array_auth_temp.add(reload_yn);
		//	array_auth_temp.add(debug_yn);                                 Modified by laxman 21/4/09
			array_auth_temp.add(debug_yn);                   //debug_yn empty String replace Modified by laxman 21/4/09
			array_auth_temp.add(audit_yn);
			array_auth_temp.add(comm_exc_yn);
			array_auth_temp.add(write_to_excel);
					array_auth_temp.add(help);
					array_auth_temp.add(notification_yn);
			auth_main.add(array_auth_temp);
		}

        else if(mode!=null){
/*        if(mode.equalsIgnoreCase("D"))
        { */
            try{
                 
				 con=ConnectionManager.getConnection();
			     String sql1="select  b.APPL_USER_NAME,b.appl_user_id,VIEW_YN,REPLAY_YN,EDIT_YN,REBUILD_YN,ALLOW_NOTIFICATION_YN from xh_authorized_user a, sm_appl_user_lang_vw b where b.LANGUAGE_ID='"+locale+"' AND b.appl_user_id = a.LOGIN_NAME order by 1" ;
	//				System.out.println("sql1 : "+sql1);
			     stmt1=con.createStatement();
			     rs1=stmt1.executeQuery(sql1);
		
				 array_auth_del = new ArrayList();
			     while(rs1.next())
			     {
				      login_name=rs1.getString(2);
				  //    temp=XHDBAdapter.checkNullForCheckBox(request.getParameter(login_name+"_action"));
				   //   if(temp.equalsIgnoreCase("Y"))
                    //  {
						 if(mode.equalsIgnoreCase("U"))
						{
							array_auth_temp = new ArrayList();
							array_auth_temp.add(login_name);
								view_yn = XHDBAdapter.checkNullForCheckBox(request.getParameter(login_name+"_view_yn"));
//								System.out.println("view_yn : "+view_yn);
							array_auth_temp.add(view_yn);
								replay_yn = XHDBAdapter.checkNullForCheckBox(request.getParameter(login_name+"_replay_yn"));
//								System.out.println("replay_yn : "+replay_yn);
							array_auth_temp.add(replay_yn);
								rebuild_yn = XHDBAdapter.checkNullForCheckBox(request.getParameter(login_name+"_rebuild_yn"));
//								System.out.println("rebuild_yn : "+rebuild_yn);
							array_auth_temp.add(rebuild_yn);
							array_auth_temp.add(mode);

								reload_yn = XHDBAdapter.checkNullForCheckBox(request.getParameter(login_name+"_reload_yn"));
//								System.out.println("reload_yn : "+reload_yn);
							array_auth_temp.add(reload_yn);
                                //debug_yn=""; 
//								request.getParameter(login_name+"_debug_yn")
								//debug_yn = XHDBAdapter.checkNullForCheckBox("");
								debug_yn = "N";
								//System.out.println("debug_yn : "+debug_yn);
							array_auth_temp.add(debug_yn);
								audit_yn = XHDBAdapter.checkNullForCheckBox(request.getParameter(login_name+"_audit_yn"));
//								System.out.println("audit_yn : "+audit_yn);
							array_auth_temp.add(audit_yn);
								comm_exc_yn = XHDBAdapter.checkNullForCheckBox(request.getParameter(login_name+"_comm_exc_yn"));
//								System.out.println("comm_exc_yn : "+comm_exc_yn);
							array_auth_temp.add(comm_exc_yn);
								write_to_excel = XHDBAdapter.checkNullForCheckBox(request.getParameter(login_name+"_write_to_excel"));
//								System.out.println("write_to_excel : "+write_to_excel);
							array_auth_temp.add(write_to_excel);

							help = XHDBAdapter.checkNullForCheckBox(request.getParameter(login_name+"_help"));
//								System.out.println("write_to_excel : "+write_to_excel);
							array_auth_temp.add(help);
							
							notification_yn = XHDBAdapter.checkNullForCheckBox(request.getParameter(login_name+"_notification_yn"));
							array_auth_temp.add(notification_yn);
							auth_main.add(array_auth_temp);
						}
						 else if(mode.equalsIgnoreCase("D"))
						{ 
							 array_auth_del1 = new ArrayList();
							 array_auth_del1.add(login_name);
							 array_auth_del1.add(mode);
							 array_auth_del.add(array_auth_del1);
						}
            		//  }
				
			     }
				 
				 if(rs1!=null) rs1.close();
			     if(stmt1!=null) stmt1.close();
			     if(con!=null) con.close();
			    
				 }catch(Exception ex ) 
					                 { 
					                   System.out.println("Exception in servlet :"); 
			                           ex.printStackTrace(System.err);
									 }
//		} // end of delete 
		}
      

		ArrayList array_audit=new ArrayList();
		array_audit = ArrayAuditInfo.getArrayAuditInfo(session);
        
		
		HashMap details_hm = new HashMap();
        
		details_hm.put("auth_main", auth_main);
		if(array_auth_del!=null) { details_hm.put("auth_del",array_auth_del); }
        details_hm.put("gen_details",array_audit);

        HashMap result_hm=new HashMap();
		result_hm=callEJB(details_hm,locale);
		RequestDispatcher reqDis=null;
/*		if((mode!=null)&&(mode.equalsIgnoreCase("D")))
        {
		 reqDis= 	session.getServletContext().
			  getRequestDispatcher("/eXH/jsp/DisplayAuthorizedUserResult.jsp?message="+(String)result_hm.get("status"));
		}
		else
		{
	*/	   reqDis = 	session.getServletContext().
			  getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+(String)result_hm.get("status"));
	//	}
	
	
		reqDis.forward(request,response);
		
	auth_main.clear();
	array_auth_temp.clear();
	array_auth_del.clear();
	array_auth_del1.clear();
	array_audit.clear();
	details_hm.clear();
	result_hm.clear();
	auth_main.clear();

    }//end of do post

/**
	 * callEJB method is used to call autorized users setup related database procedures
	 * @param  HashMap details_hm
	 * @param  String locale
	 */
public HashMap callEJB(HashMap details_hm,String locale)
{
    
	Connection connection = null;
	CallableStatement ostmt1 = null;
	//CallableStatement ostmt2 = null;
		
	String message_text2 = "";
	String status="";
	String exceptions="";
	HashMap result_hm=new HashMap();

		
	ArrayList auth_main = (ArrayList) details_hm.get("auth_main");
	//ArrayList auth_del = (ArrayList) details_hm.get("auth_del");
	ArrayList gen_arr = (ArrayList) details_hm.get("gen_details");

	try
	{
	   connection = ConnectionManager.getConnection();
    }catch(Exception exp){
    		               System.out.println("Error in calling getconnection method in callejb method of authorizedusersaddmodifyservlet :"+exp.toString());
		                   exp.printStackTrace(System.err);
		                   exceptions=exceptions+"1"+"*"+exp.toString();
        
      }
	

	ArrayList arr_auth_temp=null;
	for (int j=0;j<auth_main.size();j++)
	{
		arr_auth_temp = (ArrayList)auth_main.get(j);
		 try
	      {
			
			ostmt1 = connection.prepareCall("{ call xhmast.authorized_user(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 

			 String login_name=(String)arr_auth_temp.get(0) ;
			 String view_yn=(String)arr_auth_temp.get(1) ;
			 String replay_yn=(String)arr_auth_temp.get(2) ;
			 String rebuild_yn=(String)arr_auth_temp.get(3) ;
			 String mode=(String)arr_auth_temp.get(4) ;
 			 String reload_yn=(String)arr_auth_temp.get(5) ;
			 String debug_yn=(String)arr_auth_temp.get(6) ;
			 String audit_yn=(String)arr_auth_temp.get(7) ;
			 String comm_exc_yn=(String)arr_auth_temp.get(8) ;
			 String write_to_excel=(String)arr_auth_temp.get(9) ;
             String help=(String)arr_auth_temp.get(10) ;
             String notification_yn = (String)arr_auth_temp.get(11);


			 String s_5=(String)gen_arr.get(0) ;
			 String s_6=(String)gen_arr.get(1) ;
			 String s_7=(String)gen_arr.get(2) ;
			
			ostmt1.setString(1,login_name);
//            System.out.println("login_name :"+login_name);
           
			ostmt1.setString(2,view_yn);
//            System.out.println("view_yn :"+view_yn);

			ostmt1.setString(3,replay_yn);
//            System.out.println("replay_yn :"+replay_yn); 
			ostmt1.setString(4,rebuild_yn);
//            System.out.println("rebuild_yn :"+rebuild_yn); 
			ostmt1.setString(5,mode);
  //          System.out.println("mode :"+mode); 
			ostmt1.setString(6,debug_yn);
//			System.out.println("debug_yn :"+debug_yn);  
			ostmt1.setString(7,audit_yn);
//			System.out.println("audit_yn :"+audit_yn); 
			ostmt1.setString(8,reload_yn);
//            System.out.println("reload_yn :"+reload_yn);  
			ostmt1.setString(9,"N");
			ostmt1.setString(10,comm_exc_yn);
//			System.out.println("comm_exc_yn :"+comm_exc_yn); 
			ostmt1.setString(11,write_to_excel);
			ostmt1.setString(12,help);
  //          System.out.println("write_to_excel :"+write_to_excel); 
			ostmt1.setString(13,notification_yn); 
//          System.out.println("notification_yn :"+notification_yn); 
			
			ostmt1.setString(14,s_5);
			ostmt1.setString(15,s_6);
			ostmt1.setString(16,s_7);
			ostmt1.setString(17,s_7);



			
			ostmt1.registerOutParameter(17,java.sql.Types.VARCHAR);
			ostmt1.registerOutParameter(18,java.sql.Types.VARCHAR);
			ostmt1.registerOutParameter(19,java.sql.Types.VARCHAR);
			ostmt1.execute();
			MessageManager mm=new MessageManager();

			message_text2 = ostmt1.getString(18);	
	//			System.out.println("AuthorizedUsersAddModifyServlet.java message_text2 : "+message_text2);
			if(message_text2.equals("0"))
			{
				connection.commit(); 
				 final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
				//final java.util.Hashtable mesg = mm.getMessage(connection, "XH1001") ; 
			    message_text2 = ((String) mesg.get("message"));
			    mesg.clear();
			}
			else if(message_text2.equals("2"))
		{
			    connection.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "CODE_ALREADY_EXISTS", "Common") ;
				//final java.util.Hashtable mesg = mm.getMessage(connection, "XH1024") ;
			    message_text2 = ((String) mesg.get("message"));		
			    mesg.clear();
		}
			else
			{
				 connection.rollback();
				 final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
			 	// final java.util.Hashtable mesg = mm.getMessage(connection, "XH1000") ;
 				message_text2 = ((String) mesg.get("message"));
 				mesg.clear();
			}
			
			if(ostmt1!=null) ostmt1.close();
				 
	       }
			catch(Exception ex)
	      {
			   System.out.println("Error in dbrealted statements in callejb method of authorizedusersaddmodifyservlet  :"+ex.toString());
		      ex.printStackTrace(System.err);
			  exceptions=exceptions+"3b"+"*"+ex.toString();
		
	      }
	}

  /* ArrayList arr_auth_temp1=null;
	if((auth_del!=null)&&(auth_del.size()!=0)){
	for (int j=0;j<auth_del.size();j++)
	{
		arr_auth_temp1 = (ArrayList)auth_del.get(j);
		 try
	      {
						
			 ostmt2 = connection.prepareCall("{ call xhmast.authorized_user(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" ); 

			 String login_name=(String)arr_auth_temp1.get(0) ;
			 String mode=(String)arr_auth_temp1.get(1) ;

			 String s_5=(String)gen_arr.get(0) ;
			 String s_6=(String)gen_arr.get(1) ;
			 String s_7=(String)gen_arr.get(2) ;
			
			ostmt2.setString(1,login_name);
			ostmt2.setString(2,"");
			ostmt2.setString(3,"");
			ostmt2.setString(4,"");
			ostmt2.setString(5,mode);
			ostmt2.setString(6,"");
			ostmt2.setString(7,"");
			ostmt2.setString(8,"");
			ostmt2.setString(9,"");
			ostmt2.setString(10,"");
			ostmt2.setString(11,s_5);
			ostmt2.setString(12,s_6);
			ostmt2.setString(13,s_7);
			ostmt2.setString(14,s_7);

			
			ostmt2.registerOutParameter(15,java.sql.Types.VARCHAR);
			ostmt2.registerOutParameter(16,java.sql.Types.VARCHAR);
			ostmt2.execute();
			MessageManager mm=new MessageManager();

			message_text2 = ostmt2.getString(15);	
			System.out.println("AuthorizedUsersAddModifyServlet.java message_text2 : "+message_text2);
			if(message_text2.equals("0"))
			{
				connection.commit();
				final java.util.Hashtable mesg = mm.getMessage(connection, "XH1001") ;
			    message_text2 = ((String) mesg.get("message"));
			}
			
			else
			{
				 connection.rollback();
				 final java.util.Hashtable mesg = mm.getMessage(connection, "XH1000") ;
 				message_text2 = ((String) mesg.get("message"));
			}
			if(ostmt2!=null) ostmt2.close();
			 
	       }
			catch(Exception ex)
	      {
			   System.out.println("Error in dbrealted statements in callejb method of authorizedusersaddmodifyservlet  :"+ex.toString());
		      ex.printStackTrace(System.err);
			  exceptions=exceptions+"3b"+"*"+ex.toString();
		
	      }
		      
		   
		}
	}*/

	 try{
					ConnectionManager.returnConnection(connection);
				   }catch(Exception ex){}

	status=status+message_text2;
	System.out.println("AuthorizedUsersAddModifyServlet.java status : "+status);
    result_hm.put("exceptions",exceptions);
	result_hm.put("status",status);
	
	gen_arr.clear();
	arr_auth_temp.clear();
	return result_hm;  
	
}//end of function 	


}//end of class
