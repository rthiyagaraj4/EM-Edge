/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/ 
package eSM;
 
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.naming.*;
import java.util.*;
import webbeans.eCommon.*;

public class LoginResponseServlet extends HttpServlet{
	String multierr_str="";//Added by Maheshwaran K for the Password Validation as on 07/03/2013
	
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out;
        out = res.getWriter();
		//Changed from global to local variables 
		XMLStringParser obj	=null;
		String domain = "";
		String ext_user_yn = "N";//Changes for IPAD login --  12/04/2013
		String level = "";
		String client_ip_address = "";
		String mode = "";
		String ecis_jdbc_user = "";
		String ecis_jdbc_password = "";
		String responsibility_id = "";
		String responsibility_name = "";
		String facility_id = "";
		String facility_name = "";
		String host = ""; 
		String case_sensitive_password_yn="";//Maheshwaran added for the MMS-QH-CRF-0149
		String first_login_change_password_yn="";//Added by Maheshwaran for AMs-CRF-0098
		String multiple_login_allowed_yn="";//Added By Dharma on 17th Oct 2016 against MO-CRF-20113 [IN:060974]
		
		//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2 
		String active_dir_id = "";
		String login_user_type = "";
		String retValApi = "";

		HashMap userData = new HashMap();

        if (mode == null)
            mode = "";
		obj=new XMLStringParser();
		Map hash = (Map)obj.parseXMLString( req ) ;
		hash = (Map)hash.get("SEARCH") ;

		ecis_jdbc_user=(String) hash.get("name");
		if(ecis_jdbc_user==null)ecis_jdbc_user="";

		ecis_jdbc_password=(String) hash.get("password");
		if(ecis_jdbc_password==null)ecis_jdbc_password="";

		ecis_jdbc_user = java.net.URLDecoder.decode(ecis_jdbc_user,"UTF-8");
		ecis_jdbc_password = java.net.URLDecoder.decode(ecis_jdbc_password,"UTF-8");
		mode=(String) hash.get("mode");
		host = (String) hash.get("compname");
		domain = (String) hash.get("domain");
		case_sensitive_password_yn = (String) hash.get("case_sensitive_password_yn");//Maheshwaran added for the MMS-QH-CRF-0149
		first_login_change_password_yn = (String) hash.get("first_login_change_password_yn");//Added by Maheshwaran for AMs-CRF-0098
		multiple_login_allowed_yn = (String) hash.get("multiple_login_allowed_yn");//Added By Dharma on 17th Oct 2016 against MO-CRF-20113 [IN:060974]
		
		//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
		active_dir_id = (String) hash.get("active_dir_id");
		if(active_dir_id == null) active_dir_id = "";

		active_dir_id = java.net.URLDecoder.decode(active_dir_id,"UTF-8");

		login_user_type = (String) hash.get("login_user_type");
		retValApi = (String) hash.get("retValApi");
			
		ext_user_yn = (String) hash.get("ext_user_yn");//Changes for IPAD login -- 4/12/2013
		userData.put("ext_user_yn",ext_user_yn);//Changes for IPAD login -- 4/12/2013
		client_ip_address = req.getRemoteAddr();
        if (mode.equals("") || mode.equals("begin")) {
            ecis_jdbc_user = ecis_jdbc_user.toUpperCase();
            //ecis_jdbc_password = ecis_jdbc_password.toUpperCase() ;
            try{                
                level = (String) hash.get("level");
                responsibility_id = (String) hash.get("responsibility_id");
                responsibility_name = (String) hash.get("responsibility_name");
                facility_id = (String) hash.get("facility_id");
				facility_name = (String) hash.get("facility_name");
				hash.clear();
                if (level == null)
                    level = "1";
                if (responsibility_id == null)
                    responsibility_id = "";
                if (responsibility_name == null)
                    responsibility_name = "";
                if (facility_id == null)
                    facility_id = "";
                if (facility_name == null)
                    facility_name = "";
                if (level.equals("1")){	
					userData.put("client_ip_address",client_ip_address);
					userData.put("mode",mode);
					userData.put("host",host);
					userData.put("ecis_jdbc_user",ecis_jdbc_user);
					userData.put("ecis_jdbc_password",ecis_jdbc_password);
					userData.put("case_sensitive_password_yn",case_sensitive_password_yn);//Maheshwaran added for the MMS-QH-CRF-0149
					userData.put("first_login_change_password_yn",first_login_change_password_yn);//Added by Maheshwaran for AMs-CRF-0098
					userData.put("multiple_login_allowed_yn",multiple_login_allowed_yn);//Added By Dharma on 17th Oct 2016 against MO-CRF-20113 [IN:060974]
					
					//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
					userData.put("active_dir_id",active_dir_id);
					userData.put("login_user_type",login_user_type);
					userData.put("retValApi",retValApi);
						
                    processLevel1(req, res,userData);
				}
                if (level.equals("2")){
					HttpSession session = req.getSession(true);
					userData = (HashMap)session.getAttribute("userData");
					userData.put("first_login_change_password_yn",first_login_change_password_yn);//Added by Maheshwaran for AMs-CRF-0098
					processLevel2(req, res,userData);
				}
                if (level.equals("3")){
					HttpSession session = req.getSession(true);
					userData = (HashMap)session.getAttribute("userData");
					userData.put("responsibility_id",responsibility_id);
					userData.put("responsibility_name",responsibility_name);
					userData.put("facility_id",facility_id);
					userData.put("facility_name",facility_name);
                    userData.put("first_login_change_password_yn",first_login_change_password_yn);//Added by Maheshwaran for AMs-CRF-0098
                    userData.put("host",host);
					processLevel3(req, res,userData);
				}
            } catch (Exception e) {
                out.println("Exception@1: " + e);
            }
        }else if(mode.equals("Grace")){
			userData.put("client_ip_address",client_ip_address);
			userData.put("mode",mode);
			userData.put("host",host);
			userData.put("ecis_jdbc_user",ecis_jdbc_user);
			userData.put("ecis_jdbc_password",ecis_jdbc_password);
			userData.put("case_sensitive_password_yn",case_sensitive_password_yn);//Maheshwaran added for the MMS-QH-CRF-0149
            processLevel1(req, res,userData);
        }
	multierr_str="";//Added by Maheshwaran K for the Password Validation as on 07/03/2013
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, java.io.IOException {
        String mode = req.getParameter("mode");
        if (mode == null)
            mode = "";
        if (mode.equals("Grace")) {
            doPost(req, res);
        }
    }
    
    private void processLevel1(HttpServletRequest req, HttpServletResponse res,HashMap userData){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
	    PrintWriter out=null;		
        Connection conForPwd = null;
		//Added by Maheshwaran K for the Password Validation as on 11/07/2012
		//Start
		CallableStatement cs1= null;	
		Statement stmt_Pwd=null;
		ResultSet rs_Pwd=null;
		String tot_msg="";
		String user_status="";
		String RSRC_GROUP="";
		String FIRST_LOGIN_YN="";//Maheshwaran added for the MMS-QH-CRF-0149
		//End
		//Changed Global variables to Local Variables
		String primary_lang = "";
		String client_ip_address = (String) (userData.get("client_ip_address")==null?"":userData.get("client_ip_address"));
		String mode = (String) (userData.get("mode")==null?"":userData.get("mode"));
		String ecis_jdbc_user = (String) (userData.get("ecis_jdbc_user")==null?"":userData.get("ecis_jdbc_user"));
		String ecis_jdbc_password = (String) (userData.get("ecis_jdbc_password")==null?"":userData.get("ecis_jdbc_password"));
		String case_sensitive_password_yn = (String) (userData.get("case_sensitive_password_yn")==null?"N":userData.get("case_sensitive_password_yn"));//Maheshwaran added for the MMS-QH-CRF-0149
		String first_login_change_password_yn = (String) (userData.get("first_login_change_password_yn")==null?"N":userData.get("first_login_change_password_yn"));//Added by Maheshwaran for AMs-CRF-0098
		String multiple_login_allowed_yn	= (String) (userData.get("multiple_login_allowed_yn")==null?"Y":userData.get("multiple_login_allowed_yn"));//Added By Dharma on 17th Oct 2016 against MO-CRF-20113 [IN:060974]
		
		//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
		String active_dir_id = (String) (userData.get("active_dir_id")==null?"":userData.get("active_dir_id"));
		String login_user_type = (String) (userData.get("login_user_type")==null?"":userData.get("login_user_type"));
		String retValApi = (String) (userData.get("retValApi")==null?"":userData.get("retValApi"));
	

		String appl_user_name = "";
		String preferred_style = "";
		//APPLUSERS
		String derived_user = "";
		String derived_password = "";
		String derived_connect_string = "";
		String derived_db_driver = "";
		String derived_ejb_connect_string = "";
		String derived_report_connect_string = "";
		String derived_report_server = "";
		String connection_pool_yn = "";
		String report_ssl_yn = "";
		String dfltFacilityId = "";
		String locale = "en";
		int resp_count = 0;
		HttpSession session = req.getSession(true);
		try{
			conForPwd = ConnectionManager.getConnection(req);
			session.invalidate();
			session = req.getSession(true);
			if(ecis_jdbc_password.equals("")){
				//Statement stmtPwd = null;
				ResultSet rsPwd = null;	 
				try {
					String userDtlsQuery ="select app_password.decrypt(APPL_USER_PASSWORD) as password, LANGUAGE_ID,(SELECT LANGUAGE_ID FROM SM_LANGUAGE WHERE PRIMARY_LANG_YN ='Y')PRIMARY_LANG from sm_appl_user where appl_user_id=?";
					pstmt=conForPwd.prepareStatement(userDtlsQuery);
					pstmt.setString(1,ecis_jdbc_user);
					rsPwd = pstmt.executeQuery();
					while (rsPwd.next()) {
						ecis_jdbc_password	= rsPwd.getString("password");
						primary_lang		= rsPwd.getString("PRIMARY_LANG");
						//connection_pool_yn	= rsPwd.getString("connection_pool_yn");
						locale=rsPwd.getString("LANGUAGE_ID");
						if(locale == null)locale="en";
						if(locale.equals(""))locale="en";
					}
					if(rsPwd != null)rsPwd.close();
					if(pstmt != null)pstmt.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			boolean grace_time_alert_flag = false;
			if(mode != null && mode.equals("begin")){
				if(!connectionAvailable(res,userData)){
					try{
						out.println("error_num=1||"+appl_user_name+"||"+"error=DB Info Not Available, Contact System Administrator");
					}
					catch (Exception exc){
						
						exc.printStackTrace();
					}
				}
				//Added by Maheshwaran K for the Password Validation as on 11/07/2012
				//Start
				 /* CheckStyle Violation Commented by Munisekhar */
				//Connection level1Con = ConnectionManager.getConnection();
				try 
					{
					/* CheckStyle Correction added by Munisekhar */
					stmt_Pwd = conForPwd.createStatement();		
					//Maheshwaran modified the query for the MMS-QH-CRF-0149
					rs_Pwd = stmt_Pwd.executeQuery("select ORA_RSRC_GROUP_ID,FIRST_LOGIN_YN,rep_facility_id from sm_appl_user where appl_user_id= '"+ ecis_jdbc_user + "'"); 
					if (rs_Pwd != null && rs_Pwd.next()) 
						{
						RSRC_GROUP = rs_Pwd.getString("ORA_RSRC_GROUP_ID");
						FIRST_LOGIN_YN = rs_Pwd.getString("FIRST_LOGIN_YN");//Maheshwaran added for the MMS-QH-CRF-0149
						dfltFacilityId =rs_Pwd.getString("rep_facility_id")==null ? "" : rs_Pwd.getString("rep_facility_id");
						
						if (RSRC_GROUP == null)
						RSRC_GROUP = "";
						}
					if (rs_Pwd != null)
					rs_Pwd.close();
					if (stmt_Pwd != null)
					stmt_Pwd.close();  
					out = res.getWriter(); 

					//Added Against MMS-MD-SCF-0191 Starts
					
					String chkDisabledUser = "select count(*) count from sm_appl_user where appl_user_id = '"+ecis_jdbc_user+"' and ws_no is null and eff_status='D'";
						int disabledUserCount= 0;
							pstmt1 = conForPwd.prepareStatement(chkDisabledUser);
							rs1 = pstmt1.executeQuery();
							if(rs1 != null && rs1.next()){
								disabledUserCount	= rs1.getInt("count");  
							}
							
						if(rs1 != null)rs1.close();
						if(pstmt1 != null)pstmt1.close();
						
						if(disabledUserCount > 0){
								user_status	= "USER_DISABLED";
							}
							
						 if(user_status.equals("USER_DISABLED")) 
							{				
							out.println("error_num=1||"+ecis_jdbc_user+"||error=APP-SM0160 This User is disabled. Contact System Administrator");
							return;
							} 
					//Added Against MMS-MD-SCF-0191 Ends

					//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
					if(!active_dir_id.equals("")) 
					{
						if(!retValApi.equals("Success")){
							out.println("error_num=1||"+ecis_jdbc_user+"||error=APP-SM0164 "+retValApi);
							return;
						}
					}
					
					session.setAttribute("active_dir_id",active_dir_id);
					session.setAttribute("login_user_type",login_user_type);
					
					if (RSRC_GROUP != "")
						{	 
						try
							{
							 /* CheckStyle Correction added by Munisekhar */ 
    						cs1 = conForPwd.prepareCall( "{ call SM_VALIDATE_USER.VALIDATE_USER(?, ?, ?)}");
							cs1.setString ( 1,ecis_jdbc_user   ) ;
							//Maheshwaran modified for the MMS-QH-CRF-0149
							if(case_sensitive_password_yn.equals("N"))
								{
								cs1.setString ( 2,ecis_jdbc_password.toUpperCase()) ;
								}
							else
								{
								cs1.setString ( 2,ecis_jdbc_password) ;
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
							e.printStackTrace();
							}	
						tot_msg = user_status;
						if(user_status.equals("") && multiple_login_allowed_yn.equals("N")){
							String chkAlreadyLoggedIn	= "Select count(*) tot from SM_APPL_USER_AUDIT where appl_user_id='"+ecis_jdbc_user+"' ";
							int userCount					= 0;
							pstmt1 = conForPwd.prepareStatement(chkAlreadyLoggedIn);
							rs1 = pstmt1.executeQuery();
							if(rs1 != null && rs1.next()){
								userCount	= rs1.getInt("tot");  
							}
							if(userCount > 0){
								user_status	= "USER_ALREADY_LOGGED_IN";
							}
						}
					

						if(rs1 != null)rs1.close();
						if(pstmt1 != null)pstmt1.close();
						
						if (user_status.equals("INVALID_PASSWORD"))
							{				
							out.println("error_num=1||"+ecis_jdbc_user+"||error=Invalid User ID/Password.  Please try again.");
							return;
							}
						else if (user_status.equals("USER_LOCKED"))
							{
							out.println("error_num=1||"+ecis_jdbc_user+"||error=APP-SM0064 User Account Locked");
							return;
							}	
						else if (user_status.equals("MAX_LOGIN_ATTEMP_EXCEDDED"))
							{
							out.println("error_num=1||"+ecis_jdbc_user+"||error=APP-SM0132 Maximum Login Attempt Exceeded");
							return;
							}	
						else if (user_status.equals("PASSWORD_EXPIRED"))
							{
							out.println("error_num=1||"+ecis_jdbc_user+"||error=APP-SM0133 Database Password Expired");
							return;
							}	
						else if (user_status.equals("USER_ALREADY_LOGGED_IN")) {
							out.println("error_num=1||"+ecis_jdbc_user+"||error=User already logged in the system. cannot login again.");
							return;
							}	
						else if (user_status.equals(""))
							{
							out.println("<html><script>alert(' "+ tot_msg + " ')");							
					        out.println("document.location.href='../servlet/eSM.LoginResponseServlet?mode=Grace';");
							session.putValue("login_user",ecis_jdbc_user);	
							out.println("</script></html>");							
                        	}	
						else	
							{	
							if((!FIRST_LOGIN_YN.equals("Y"))&&(!FIRST_LOGIN_YN.equals("R"))){
							//Maheshwaran commented for the MMS-QH-CRF-0149		
							//multierr_str="error_num=3";//Added by Maheshwaran K for the Password Validation as on 07/03/2013
							out.println("error_num=1||"+ecis_jdbc_user+"||"+user_status+"&");		
							session.putValue("login_user",ecis_jdbc_user);	
							}
							
							//Below line added for this SCF AMS-SCF-0597
							 if((!user_status.equals("") && first_login_change_password_yn.equals("N") && FIRST_LOGIN_YN.equals("Y")) || (!user_status.equals("") && first_login_change_password_yn.equals("N") && FIRST_LOGIN_YN.equals("R"))){
							     out.println("error_num=1||"+ecis_jdbc_user+"||"+user_status+"&"); 
							 }
							//End this SCF AMS-SCF-0597
							
							}		
						}
					}
				catch(SQLException e)	
					{
					e.printStackTrace();
					}
				//End
				derived_user					= (String) (userData.get("derived_user")==null?"":userData.get("derived_user"));
				derived_password				= (String) (userData.get("derived_password")==null?"":userData.get("derived_password"));
				derived_connect_string			= (String) (userData.get("derived_connect_string")==null?"":userData.get("derived_connect_string"));
				derived_db_driver				= (String) (userData.get("derived_db_driver")==null?"":userData.get("derived_db_driver"));
				derived_ejb_connect_string		= (String) (userData.get("derived_ejb_connect_string")==null?"":userData.get("derived_ejb_connect_string"));
				derived_report_connect_string	= (String) (userData.get("derived_report_connect_string")==null?"":userData.get("derived_report_connect_string"));
				derived_report_server			= (String) (userData.get("derived_report_server")==null?"":userData.get("derived_report_server"));
				connection_pool_yn				= (String) (userData.get("connection_pool_yn")==null?"":userData.get("connection_pool_yn"));
				report_ssl_yn				= (String) (userData.get("report_ssl_yn")==null?"":userData.get("report_ssl_yn"));
				if(!validLogin(res,userData)){
					return;
				}else{
				//Maheshwaran added for the MMS-QH-CRF-0149

				/*Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] Start*/
				boolean isAuditInfo	= true;
			
				isAuditInfo	= insertAuditInfo(req,res,userData,conForPwd);

				if(isAuditInfo){
				/*Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] End*/
					if((FIRST_LOGIN_YN.equals("Y"))||(FIRST_LOGIN_YN.equals("R")))
						{
						String msg_text="";
						if(FIRST_LOGIN_YN.equals("R"))
						msg_text="PASSWORD_RESET";
						if(FIRST_LOGIN_YN.equals("Y"))
						msg_text="FIRST_LOGIN";
						//boolean res1=true; //commented for checkstyle
						
						if (first_login_change_password_yn.equals("N"))
							{
							//res1=firstLoginYN( req,res,userData,conForPwd,FIRST_LOGIN_YN) ;
							}
						
							//if(res1==true)
							if (first_login_change_password_yn.equals("Y"))
							{//Added by Maheshwaran for AMs-CRF-0098
						java.util.Hashtable message = MessageManager.getMessage(locale,msg_text, "SM");
						multierr_str="error_num=3";
						out.println("error_num=3||"+ecis_jdbc_user+"||"+(String) message.get("message")+"&");
						message.clear();
						}
						session.putValue("login_user",ecis_jdbc_user);	
						}
						session.setAttribute("userData",userData);
						appl_user_name = (String) (userData.get("appl_user_name")==null?"":userData.get("appl_user_name"));
						preferred_style = (String) (userData.get("preferred_style")==null?"":userData.get("preferred_style"));
						locale = (String) (userData.get("locale")==null?"en":userData.get("locale"));
						final java.util.Properties p = new java.util.Properties();
						p.setProperty("ecis_jdbc_dns", derived_connect_string);
						p.setProperty("ecis_jdbc_driver", derived_db_driver);
						if (connection_pool_yn != null && connection_pool_yn.equals("Y")) {
							p.setProperty("ecis_jdbc_user", derived_user);
							p.setProperty("ecis_jdbc_password", derived_password);
						} else if (connection_pool_yn != null && connection_pool_yn.equals("N")) {
							p.setProperty("ecis_jdbc_password", ecis_jdbc_password);
							p.setProperty("ecis_jdbc_user", ecis_jdbc_user);
							session.setAttribute("connection", conForPwd);
						}
						p.setProperty("client_ip_address", client_ip_address);
						p.setProperty("login_user", ecis_jdbc_user);
						p.setProperty("login_password", ecis_jdbc_password);
						p.setProperty("connection_pooling_yn", connection_pool_yn);
						p.setProperty("report_ssl_yn", report_ssl_yn);
						p.setProperty("appl_user_name", appl_user_name);					
						java.util.Hashtable env = new java.util.Hashtable();
						env.put(Context.SECURITY_PRINCIPAL, derived_user);
						env.put(Context.SECURITY_CREDENTIALS, derived_password);
						session.setAttribute("env", env);
						session.setAttribute("serviceURL", derived_ejb_connect_string);
						session.setAttribute("report_connect_string", derived_user + "/"
											+ derived_password + "@"
											+ derived_report_connect_string);
						session.setAttribute("report_server", derived_report_server);            
						session.setAttribute("connection_pooling_yn", connection_pool_yn);
						session.setAttribute("report_ssl_yn", report_ssl_yn);
						session.setAttribute("login_user", ecis_jdbc_user);   
						session.setAttribute("appl_user_name", appl_user_name);   
						session.setAttribute("PREFERRED_STYLE", preferred_style); 

						if(locale == null)locale="en";
						if(locale.equals(""))locale="en";

						session.setAttribute("LOCALE",locale) ;
						session.setAttribute("PRIMARY_LANG",primary_lang);

							p.setProperty("LOCALE", locale);
							p.setProperty("PRIMARY_LANG", primary_lang);
							
							session.setAttribute("jdbc", p);
							env.clear();
					}  //Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613]
				}
				grace_time_alert_flag = findGraceTimeAlert(req,res,userData);
			}
			if (mode.equals("Grace") || (!(grace_time_alert_flag))) {
				session = req.getSession(false);
				ecis_jdbc_user = (String) session.getAttribute("login_user");
				try{
					out = res.getWriter();
					if (pstmt != null)pstmt.close();
					if (rs != null)rs.close();
					String respId=null;
					String respName=null;
					String facId=null;
					String facName=null;
					String resCode_Desc=null;
					String facCode_Desc=null;
					String defaultrespID=null;
					String defaultrespDesc=null;
					String defaultDesktopCode=null;
					String desktop_code="";
					StringBuffer responsibilities=new StringBuffer();
					StringBuffer facilities=new StringBuffer();
					int rscount=0;
					int facCount=0;
					String respsql = " select resp_user.resp_id, resp_name,desktop_code from sm_resp_lang_vw resp, sm_resp_for_user resp_user where resp.resp_id = resp_user.resp_id and language_id = ? and exists (select 1 from sm_menu_hdr where resp.menu_id = menu_id and dev_tool='J') and resp_user.appl_user_id =? and ( (resp_user.eff_date_from <= trunc(sysdate) and resp_user.eff_date_to >= trunc(sysdate)) or (resp_user.eff_date_from <= trunc(sysdate) and resp_user.eff_date_to is null) or (resp_user.eff_date_to >= trunc(sysdate) and resp_user.eff_date_from is null) or (resp_user.eff_date_from is null and resp_user.eff_date_to is null)) and ((resp.eff_date_from <= trunc(sysdate) and resp.eff_date_to >= trunc(sysdate)) or (resp.eff_date_from <= trunc(sysdate) and resp.eff_date_to is null) or (resp.eff_date_to >= trunc(sysdate) and resp.eff_date_from is null) or (resp.eff_date_from is null and resp.eff_date_to is null ) ) and resp.eff_status='E' order by 2";
					pstmt = conForPwd.prepareStatement(respsql) ;
					pstmt.setString( 1, locale ) ;
					pstmt.setString( 2, ecis_jdbc_user ) ;
					rs = pstmt.executeQuery() ;
					while( rs != null && rs.next() ){
						respId	= rs.getString( "resp_id" ) ;
						respName	= rs.getString( "resp_name" ) ;
						desktop_code	= rs.getString( "desktop_code" ) ;
						resCode_Desc=respId+"~"+respName;
						if(rscount==0){
							defaultrespID=respId;
							defaultrespDesc=respName;
							defaultDesktopCode=desktop_code;
							responsibilities.append(resCode_Desc);
						}else{
							responsibilities.append("^^"+resCode_Desc);
						}
						if(desktop_code!=null)
							session.setAttribute(respId,desktop_code);
						rscount++;
					}
					if (pstmt != null)pstmt.close();
					if (rs != null)rs.close();
					resp_count=rscount;
					userData.put("resp_count",resp_count);
					if(rscount ==0){
						out = res.getWriter();
						session.setAttribute("userData",userData);
						out.println("error_num=1||"+appl_user_name+"||"+"error=No responsibility assigned for this user");
					}else if(rscount ==1){
						req.setCharacterEncoding("UTF-8");
						res.setContentType("text/html;charset=UTF-8");
						session.setAttribute("responsibility_id", defaultrespID);
						session.setAttribute("responsibility_name", defaultrespDesc);
						userData.put("responsibility_id",defaultrespID);
						userData.put("responsibility_name",defaultrespDesc);
						session.setAttribute(defaultrespID, defaultDesktopCode);
						session.setAttribute(defaultrespID,defaultDesktopCode);
						session.setAttribute("userData",userData);
						processLevel2(req, res,userData);
					}else if(rscount > 1){
					/* change starts for cross facility validation 17/Jul/2012*/
						String restrict_facility_by_db="N";
						try{
							pstmt = conForPwd.prepareStatement( "SELECT nvl(RESTRICT_FCY_BY_CURR_DB_YN,'N') RESTRICT_FCY_BY_CURR_DB_YN FROM SM_SITE_PARAM" ) ;
							rs = pstmt.executeQuery() ;					
							while(rs!=null && rs.next()){
								restrict_facility_by_db=rs.getString("RESTRICT_FCY_BY_CURR_DB_YN");
							}
						}catch ( Exception ex){
							restrict_facility_by_db="N";
						}finally{
							if (pstmt != null)pstmt.close();
							if (rs != null)rs.close();
						}
						String facsql ="";
						if(restrict_facility_by_db.equals("Y")) 
							{
						facsql="select sm_facility_for_user.facility_id, sm_facility_param.facility_name from sm_facility_for_user, sm_facility_param_lang_vw sm_facility_param where appl_user_id =? and language_id = ? and sm_facility_for_user.facility_id = sm_facility_param.facility_id  and ( (sm_facility_for_user.ACCESS_EFF_DATE_FROM <= trunc(sysdate) and sm_facility_for_user.ACCESS_EFF_DATE_TO >= trunc(sysdate) )  or (sm_facility_for_user.ACCESS_EFF_DATE_FROM <= trunc(sysdate) and sm_facility_for_user.ACCESS_EFF_DATE_TO is null )  or (sm_facility_for_user.ACCESS_EFF_DATE_TO >= trunc(sysdate) and sm_facility_for_user.ACCESS_EFF_DATE_FROM is null)  or (sm_facility_for_user.ACCESS_EFF_DATE_FROM is null and sm_facility_for_user.ACCESS_EFF_DATE_TO is null ) ) and UPPER(sm_facility_param.CURR_DB)= (select UPPER(SUBSTR(CONNECT_STRING,LENGTH(CONNECT_STRING)-LENGTH(sm_facility_param.CURR_DB)+1, LENGTH(sm_facility_param.CURR_DB))) from sm_db_info) intersect select sm_facility_for_resp.facility_id, facility_name from sm_facility_for_resp, sm_facility_param_lang_vw sm_facility_param  where resp_id = ?  and sm_facility_for_resp.facility_id = sm_facility_param.facility_id and language_id = ? and UPPER(sm_facility_param.CURR_DB)= (select UPPER(SUBSTR(CONNECT_STRING,LENGTH(CONNECT_STRING)-LENGTH(sm_facility_param.CURR_DB)+1, 		LENGTH(sm_facility_param.CURR_DB))) from sm_db_info) order by 2";
							}
						else
							{
							facsql="select sm_facility_for_user.facility_id, sm_facility_param.facility_name from sm_facility_for_user, sm_facility_param_lang_vw sm_facility_param where appl_user_id =? and language_id = ? and sm_facility_for_user.facility_id = sm_facility_param.facility_id  and ( (sm_facility_for_user.ACCESS_EFF_DATE_FROM <= trunc(sysdate) and sm_facility_for_user.ACCESS_EFF_DATE_TO >= trunc(sysdate) )  or (sm_facility_for_user.ACCESS_EFF_DATE_FROM <= trunc(sysdate) and sm_facility_for_user.ACCESS_EFF_DATE_TO is null )  or (sm_facility_for_user.ACCESS_EFF_DATE_TO >= trunc(sysdate) and sm_facility_for_user.ACCESS_EFF_DATE_FROM is null)  or (sm_facility_for_user.ACCESS_EFF_DATE_FROM is null and sm_facility_for_user.ACCESS_EFF_DATE_TO is null ) ) intersect select sm_facility_for_resp.facility_id, facility_name from sm_facility_for_resp, sm_facility_param_lang_vw sm_facility_param  where resp_id = ?  and sm_facility_for_resp.facility_id = sm_facility_param.facility_id and language_id = ? order by 2";
							}
						/* change ends for cross facility validation*/			 
						pstmt = conForPwd.prepareStatement( facsql ) ;
						pstmt.setString( 1, ecis_jdbc_user ) ;
						pstmt.setString( 2, locale ) ;
						pstmt.setString( 3, defaultrespID ) ;
						pstmt.setString( 4, locale ) ;
						rs = pstmt.executeQuery() ;					
						while(rs!=null && rs.next()){
							facId=rs.getString( "facility_id" );
							facName=rs.getString( "facility_name" );
							facCode_Desc=facId+"~"+facName;
							if(facCount==0){
								facilities.append(facCode_Desc);
							}else{
								facilities.append("^^"+facCode_Desc);
							}
							facCount++;
						}
						if((FIRST_LOGIN_YN.equals("Y"))||(FIRST_LOGIN_YN.equals("R")))
							{
							String msg_text="";
							if(FIRST_LOGIN_YN.equals("R"))			
							msg_text="PASSWORD_RESET";
							if(FIRST_LOGIN_YN.equals("Y"))
							msg_text="FIRST_LOGIN";
							//boolean res3=true;//commented for checkstyle
						
							if (first_login_change_password_yn.equals("N"))
								{
								//res3=firstLoginYN( req,res,userData,conForPwd,FIRST_LOGIN_YN) ;
								}							
							//if(res3==true)
							if (first_login_change_password_yn.equals("Y"))
							{//Added by Maheshwaran for AMs-CRF-0098
								if(!multierr_str.equals("error_num=3")){
							java.util.Hashtable message = MessageManager.getMessage(locale,msg_text, "SM");
							out.println("error_num=1||"+ecis_jdbc_user+"||"+(String) message.get("message")+"&");
									}
							}
							}
						session.setAttribute("userData",userData);
						out.println("error_num=0||"+appl_user_name+"||"+rscount+"$$"+responsibilities+"=="+facCount+"$$"+facilities+"$$"+dfltFacilityId);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(conForPwd != null)conForPwd.close();
		}catch(Exception connEx){
			connEx.printStackTrace();
		}finally {
			if (conForPwd != null){
				//if (!connection_pool_yn.equalsIgnoreCase("Y"))
					ConnectionManager.returnConnection(conForPwd,req);
			}
		}
    }
    
    private void processLevel2(HttpServletRequest req, HttpServletResponse res,HashMap userData){
		HttpSession session = req.getSession(true);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//Added by Maheshwaran K for the Password Validation as on 07/03/2013
		String FIRST_LOGIN_YN="N";
		String dfltFacilityId="";
		PreparedStatement stmt_Pwd1=null;
		ResultSet rset_Pwd1=null;
		//End
        Connection level2Con = ConnectionManager.getConnection(req);
		PrintWriter out;
		String curr_user = "";
		java.util.Properties pr = new java.util.Properties();
		pr = (java.util.Properties) session.getAttribute("jdbc");
		curr_user = pr.getProperty("login_user");
		String responsibility_id = (String) session.getAttribute("responsibility_id");		
		String responsibility_name = (String) session.getAttribute("responsibility_name");
		String facility_id = "";
		String facility_name = "";
        //facility_count = countFacilities(req,res);// Commented for PF By Sudhakar
		String roleid = "";
        String orarolepassword = "";
		String appl_user_name = (String) (userData.get("appl_user_name")==null?"":userData.get("appl_user_name"));
		String ecis_jdbc_user = (String) (userData.get("ecis_jdbc_user")==null?"":userData.get("ecis_jdbc_user"));//Added by Maheshwaran K for the Password Validation as on 07/03/2013
		String locale = (String) (userData.get("locale")==null?"en":userData.get("locale"));
		int resp_count = (Integer) (userData.get("resp_count")==null?"0":userData.get("resp_count"));
		String first_login_change_password_yn = (String) (userData.get("first_login_change_password_yn")==null?"N":userData.get("first_login_change_password_yn"));//Added by Maheshwaran for AMs-CRF-0098
			try
			{
			out = res.getWriter();
			//con = ConnectionManager.getConnection(req);
			String sel_sql="select FIRST_LOGIN_YN,rep_facility_id from sm_appl_user where appl_user_id= ? ";
			stmt_Pwd1 = level2Con.prepareStatement(sel_sql);		
			stmt_Pwd1.setString ( 1, ecis_jdbc_user   ) ;
			rset_Pwd1 = stmt_Pwd1.executeQuery(); 
			if (rset_Pwd1 != null && rset_Pwd1.next()) {
				FIRST_LOGIN_YN = rset_Pwd1.getString("FIRST_LOGIN_YN");
				dfltFacilityId = rset_Pwd1.getString("rep_facility_id")==null?"":rset_Pwd1.getString("rep_facility_id");
			}

			if (rset_Pwd1 != null)
			rset_Pwd1.close();
			if (stmt_Pwd1 != null)
			stmt_Pwd1.close();  
			}
		catch(Exception e)	
			{
			e.printStackTrace();
			}
        try{
			out = res.getWriter();
			String facId=null;
			String facName=null;
			String facCode_Desc=null;
			int facCount=0;
			StringBuffer facilities=new StringBuffer();
			
			String restrict_facility_by_db="N";
			try{
				pstmt = level2Con.prepareStatement( "SELECT nvl(RESTRICT_FCY_BY_CURR_DB_YN,'N') RESTRICT_FCY_BY_CURR_DB_YN FROM SM_SITE_PARAM" ) ;
				rs = pstmt.executeQuery() ;					
				while(rs!=null && rs.next()){
					restrict_facility_by_db=rs.getString("RESTRICT_FCY_BY_CURR_DB_YN");
				}
			}catch ( Exception ex){
				restrict_facility_by_db="N";
			}finally{
				if (pstmt != null)pstmt.close();
				if (rs != null)rs.close();
			}
			String facsql ="";
			if(restrict_facility_by_db.equals("Y")){
				facsql="select sm_facility_for_user.facility_id, sm_facility_param.facility_name from sm_facility_for_user, sm_facility_param_lang_vw sm_facility_param where appl_user_id =? and language_id = ? and sm_facility_for_user.facility_id = sm_facility_param.facility_id  and ( (sm_facility_for_user.ACCESS_EFF_DATE_FROM <= trunc(sysdate) and sm_facility_for_user.ACCESS_EFF_DATE_TO >= trunc(sysdate) )  or (sm_facility_for_user.ACCESS_EFF_DATE_FROM <= trunc(sysdate) and sm_facility_for_user.ACCESS_EFF_DATE_TO is null )  or (sm_facility_for_user.ACCESS_EFF_DATE_TO >= trunc(sysdate) and sm_facility_for_user.ACCESS_EFF_DATE_FROM is null)  or (sm_facility_for_user.ACCESS_EFF_DATE_FROM is null and sm_facility_for_user.ACCESS_EFF_DATE_TO is null ) ) and UPPER(sm_facility_param.CURR_DB)= (select UPPER(SUBSTR(CONNECT_STRING,LENGTH(CONNECT_STRING)-LENGTH(sm_facility_param.CURR_DB)+1, LENGTH(sm_facility_param.CURR_DB))) from sm_db_info) intersect select sm_facility_for_resp.facility_id, facility_name from sm_facility_for_resp, sm_facility_param_lang_vw sm_facility_param  where resp_id = ?  and sm_facility_for_resp.facility_id = sm_facility_param.facility_id and language_id = ? and UPPER(sm_facility_param.CURR_DB)= (select UPPER(SUBSTR(CONNECT_STRING,LENGTH(CONNECT_STRING)-LENGTH(sm_facility_param.CURR_DB)+1, 		LENGTH(sm_facility_param.CURR_DB))) from sm_db_info) order by 2";
			}else{			
				facsql = "select sm_facility_for_user.facility_id, facility_name from sm_facility_for_user, sm_facility_param_lang_vw sm_facility_param where appl_user_id =?  and language_id = ? and sm_facility_for_user.facility_id = sm_facility_param.facility_id  and ( (sm_facility_for_user.ACCESS_EFF_DATE_FROM <= trunc(sysdate) and sm_facility_for_user.ACCESS_EFF_DATE_TO >= trunc(sysdate) ) or (sm_facility_for_user.ACCESS_EFF_DATE_FROM <= trunc(sysdate) and sm_facility_for_user.ACCESS_EFF_DATE_TO is null ) or (sm_facility_for_user.ACCESS_EFF_DATE_TO >= trunc(sysdate) and sm_facility_for_user.ACCESS_EFF_DATE_FROM is null) or (sm_facility_for_user.ACCESS_EFF_DATE_FROM is null and sm_facility_for_user.ACCESS_EFF_DATE_TO is null ) ) intersect select sm_facility_for_resp.facility_id, facility_name from sm_facility_for_resp, sm_facility_param_lang_vw sm_facility_param where resp_id = ?  and sm_facility_for_resp.facility_id = sm_facility_param.facility_id and language_id = ? order by 2";
			}
			pstmt = level2Con.prepareStatement( facsql ) ;
			pstmt.setString( 1, curr_user ) ;
			pstmt.setString( 2, locale ) ;
			pstmt.setString( 3, responsibility_id ) ;
			pstmt.setString( 4, locale ) ;
			rs = pstmt.executeQuery() ;					
			while(rs!=null && rs.next()){
				facId=rs.getString( "facility_id" );
				facName=rs.getString( "facility_name" );
				facCode_Desc=facId+"~"+facName;
				if(facCount==0){
					facilities.append(facCode_Desc);
				}else{
					facilities.append("^^"+facCode_Desc);
				}
				facCount++;
			}
				userData.put("fac_count",facCount);
				if(facCount == 0){
					try {                    
						session.setAttribute("facility_id", "DF");
						session.setAttribute("facility_name", "Default Facility");                        
						pstmt = level2Con.prepareStatement("select app_password.decrypt(b.ORA_ROLE_PASSWORD) ORA_ROLE_PASSWORD,a.ORA_ROLE_ID from sm_resp a, sm_ora_role b where a.resp_id = ? and a.ora_role_id = b.ora_role_id and a.ORA_ROLE_ID = 'MEDADMIN' ");
						pstmt.setString(1, responsibility_id);
						//pstmt.setString(1, roleid);
						rs = pstmt.executeQuery();
						if (rs != null && rs.next()){
							orarolepassword = rs.getString("ORA_ROLE_PASSWORD");
							roleid = rs.getString("ORA_ROLE_ID") == null ? "" : rs.getString("ORA_ROLE_ID");
							String dbsql = " set role " + roleid+ " identified by " + orarolepassword + "  ";
							if (rs != null) rs.close();
							if (pstmt != null) pstmt.close();                            
							pstmt = level2Con.prepareStatement(dbsql);              
							int r = pstmt.executeUpdate();
							r = r;
							if (pstmt != null) pstmt.close();
							try{
								session.setAttribute("Login","Y");
								session.setAttribute("jdbc",pr);
								facility_id="DF";
								facility_name="Default Facility";
								userData.put("facility_id",facility_id);
								userData.put("facility_name",facility_name);
								processLevel3(req,res,userData);
								//Commented for PE By Sudhakar
								out.println("error_num=0||"+appl_user_name+"||"+resp_count+"$$"+responsibility_id+"~"+responsibility_name+"=="+"1"+"$$"+"DF~Default Facility");
							}catch (Exception e){
								out.println("error_num=1||"+appl_user_name+"||"+"error=No facility assigned for this user");
								e.printStackTrace();
							}								
						}else{//medadmin level
						   out.println("error_num=1||"+appl_user_name+"||"+"error=No facility assigned for this user");
						}
					}catch (Exception e){
						e.printStackTrace();
						out.println("error_num=1||"+appl_user_name+"||"+"error=error=Exception has occured");
					}
				}else if(facCount == 1){
					pr.setProperty("responsibility_name",(String)session.getAttribute("responsibility_name"));
					session.setAttribute("jdbc",pr);
					facility_id=facId;
					facility_name=facName;
					userData.put("facility_id",facility_id);
					userData.put("facility_name",facility_name);
					processLevel3(req,res,userData);
					//commented as part of PE By Sudhakar
					//Maheshwaran K uncommented for the Incident NO :35515 as on 10/10/2012
					//fix for single responsibility
					//Added by Maheshwaran K for the Password Validation as on 07/03/2013
					session.putValue("login_user",ecis_jdbc_user);
					if((FIRST_LOGIN_YN.equals("Y"))||(FIRST_LOGIN_YN.equals("R")))
						{
						String msg_text="";
						if(FIRST_LOGIN_YN.equals("R"))
						msg_text="PASSWORD_RESET";
						if(FIRST_LOGIN_YN.equals("Y"))
						msg_text="FIRST_LOGIN";
						//boolean res1=true; //commented for checkstyle
						if (first_login_change_password_yn.equals("Y"))
							{//Added by Maheshwaran for AMs-CRF-0098
							//res1=firstLoginYN( req,res,userData,level2Con,FIRST_LOGIN_YN) ;
							//if(res1==true){
						//java.util.Hashtable message = MessageManager.getMessage(locale,msg_text, "SM");
						//out.println("error_num=1||"+ecis_jdbc_user+"||"+(String) message.get("message")+"&");
						//}
							}		

							
						
						}
						//End				
					out.println("error_num=0||"+appl_user_name+"||"+resp_count+"$$"+responsibility_id+"~"+responsibility_name+"=="+facCount+"$$"+facilities+"$$"+dfltFacilityId);
				}else if(facCount > 1){
				if((FIRST_LOGIN_YN.equals("Y"))||(FIRST_LOGIN_YN.equals("R")))
					{
					String msg_text="";
					if(FIRST_LOGIN_YN.equals("R"))
					msg_text="PASSWORD_RESET";
					if(FIRST_LOGIN_YN.equals("Y"))
					msg_text="FIRST_LOGIN";
					//boolean res2=true; //commented for checkstyle
					if (first_login_change_password_yn.equals("N"))
						{
						//res2=firstLoginYN( req,res,userData,level2Con,FIRST_LOGIN_YN) ;
						}
					//if(res2==true)
					if (first_login_change_password_yn.equals("Y"))
					{//Added by Maheshwaran for AMs-CRF-0098
					
					if(!multierr_str.equals("error_num=3")){ //This line added for this SCF AMS-SCF-0597
					
					java.util.Hashtable message = MessageManager.getMessage(locale,msg_text, "SM");
					out.println("error_num=1||"+ecis_jdbc_user+"||"+(String) message.get("message")+"&");
					
					}//End this SCF AMS-SCF-597
					
					}
							}
					out.println("error_num=0||"+appl_user_name+"||"+resp_count+"$$"+responsibility_id+"~"+responsibility_name+"=="+facCount+"$$"+facilities+"$$"+dfltFacilityId);
					
				}
				//out.println("error_num=0||"+appl_user_name+"||"+resp_count+"$$"+responsibility_id+"~"+responsibility_name+"=="+facCount+"$$"+facilities);
        }catch(Exception finalexe ){
			finalexe.printStackTrace();
		}finally{
            ConnectionManager.returnConnection(level2Con, req);
        }        
    }
    
    private void processLevel3(HttpServletRequest req, HttpServletResponse res,HashMap userData){
		HttpSession session = req.getSession(true);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PrintWriter out;
		String facility_id = (String)userData.get("facility_id");
		String facility_name = (String)userData.get("facility_name");
		String responsibility_id = (String)userData.get("responsibility_id");
		String responsibility_name = (String)userData.get("responsibility_name");
		//String appl_user_name = (String) (userData.get("appl_user_name")==null?"":userData.get("appl_user_name"));//commented for checkstyle
		String ext_user_yn = (String) (userData.get("ext_user_yn")==null?"N":userData.get("ext_user_yn"));//Changes for IPAD login -- 4/12/2013		
		//String first_login_change_password_yn = (String) (userData.get("first_login_change_password_yn")==null?"N":userData.get("first_login_change_password_yn"));//Added by Maheshwaran for AMs-CRF-0098 //commented for checkstyle
		session.setAttribute("facility_id", facility_id);
		session.setAttribute("facility_name", facility_name);
		session.setAttribute("responsibility_id", responsibility_id);
		session.setAttribute("responsibility_name", responsibility_name);
		Connection level3Con = null;
		String bl_operational ="N";
		String operational_yn = "N";
		String bl_install_yn = "N";
		int mp_bl_count=0;
		String host = (String) (userData.get("host")==null?"":userData.get("host"));
		//Chaged gloabl variables to local variables
		String ip = "";
		try{
			out = res.getWriter();
            try {
				level3Con = ConnectionManager.getConnection(req);
				if(pstmt!=null)  pstmt.close();
                pstmt = level3Con.prepareStatement("select install_yn bl_install_yn,(select operational_yn from sm_modules_facility where module_id='BL' and facility_id =?)operational_yn from sm_module where module_id='BL'");
                pstmt.setString(1, facility_id);
                rs = pstmt.executeQuery();
                if (rs != null && rs.next()) {
                   bl_install_yn = rs.getString("bl_install_yn") == null ? "N": rs.getString("bl_install_yn");
                   operational_yn = rs.getString("operational_yn") == null ? "N": rs.getString("operational_yn");
                }
				if(bl_install_yn.equals("Y") && operational_yn.equals("Y")){
					bl_operational = "Y";
					mp_bl_count = 1;
				}else{
					bl_operational = "N";
					mp_bl_count = 0;
				}
                 session.setAttribute("bl_install_yn", bl_install_yn);
                 session.setAttribute("bl_operational", bl_operational);
                } catch (Exception e) {
					e.printStackTrace();
                }
				//String sql="select CUSTOMER_ID from sm_site_param "; commented By Sudhara during UAT-3 and changed as below
				String sql="select a.PRODUCT_NAME PRODUCT_NAME,a.PRODUCT_DESCRIPTION PRODUCT_DESCRIPTION,a.VERSION_NO VERSION_NO,a.COPYRIGHT_INFO COPYRIGHT_INFO,b.CUSTOMER_ID CUSTOMER_ID from sm_installation a,sm_site_param b";
				if(pstmt!=null)  pstmt.close();
				if(rs!=null)  rs.close();
				pstmt = level3Con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				rs = pstmt.executeQuery();
				if (rs != null && rs.next()){
					session.setAttribute("CUSTOMER_ID", rs.getString("CUSTOMER_ID")==null?"":rs.getString("CUSTOMER_ID"));
					session.setAttribute("version_no",rs.getString("VERSION_NO")==null?"":rs.getString("VERSION_NO"));
					session.setAttribute("product_description",rs.getString("PRODUCT_DESCRIPTION")==null?"":rs.getString("PRODUCT_DESCRIPTION"));
					session.setAttribute("product_name",rs.getString("PRODUCT_NAME")==null?"":rs.getString("PRODUCT_NAME"));
				}
				if(pstmt!=null)  pstmt.close();
				if(rs!=null)  rs.close();
            if (mp_bl_count > 0){
                session.setAttribute("mp_bl_oper_yn", "Y");
			}else{
                session.setAttribute("mp_bl_oper_yn", "N");
			}
				pstmt = level3Con.prepareStatement("select count(*) sekure_ws_count from MP_SEKURE_READER_MAP where WORK_STATION_ID =? and EFF_STATUS='E' and exists (select FUNCTIONALITY_ID from sm_function_control where FUNCTIONALITY_ID='SMART_CARD_INTG' and module_id='MP' and VALUE_2='02'  and SITE_ID in( select customer_id from sm_site_param))");
				pstmt.setString(1, (String)userData.get("host"));
				try{
					rs = pstmt.executeQuery();
					session.setAttribute("sekure_ws_yn", "N");
					if (rs != null && rs.next()) {
						if(rs.getInt("sekure_ws_count")>0){
							session.setAttribute("sekure_ws_yn", "Y");
						}else{
							session.setAttribute("sekure_ws_yn", "N");
						}
					}					
				}catch(Exception ex){
					session.setAttribute("sekure_ws_yn", "N");
				}finally{
					if (rs != null) {
						rs.close();
					}
					if (pstmt != null){
						pstmt.close();
					}
				} 

				pstmt = level3Con.prepareStatement("select nvl(value_2,'0') smart_script from sm_function_control where  FUNCTIONALITY_ID='SMART_CARD_INTG' and module_id='MP' and SITE_ID in( select customer_id from sm_site_param)");
				try{
					rs = pstmt.executeQuery();
					session.setAttribute("smart_path", " ");
					if (rs != null && rs.next()) {
						if(! rs.getString("smart_script").equals("")){
							session.setAttribute("smart_path", "<Script language='JavaScript' src='../../eMP/js/SmartCard"+rs.getString("smart_script")+".js'></Script>");
						}else{
							session.setAttribute("smart_path", " ");
						}
					}					
				}catch(Exception ex){
					session.setAttribute("smart_path", " ");
				}finally{
					if (rs != null) {
						rs.close();
					}
					if (pstmt != null){
						pstmt.close();
					}
				} 
				
			String acc_entity_id = "";
            pstmt = level3Con.prepareStatement("select nvl(a.Ws_by_Ip_Name,'I') Ws_by_Ip_Name, a.app_server_ip, b.ACC_ENTITY_ID ACC_ENTITY_ID from sm_facility_param a, SM_ACC_ENTITY_PARAM_FACL b where a.facility_id = ? and a.facility_id = b.facility_id");//cahnged For PE By Sudhakar
            pstmt.setString(1, facility_id);
            rs = pstmt.executeQuery();
            if (rs != null && rs.next()) {
                String app_server_ip = rs.getString("app_server_ip");
                String ws_by_ip_name = rs.getString("Ws_by_Ip_Name");
				acc_entity_id = rs.getString("ACC_ENTITY_ID");
                session.setAttribute("ACC_ENTITY_ID", acc_entity_id);
                if (app_server_ip == null)
                    app_server_ip = java.net.InetAddress.getByName(
                                        req.getServerName()).getHostAddress();
                session.setAttribute("app_server_ip", app_server_ip);
                ip = req.getParameter("clientIP"); 
                Properties p = (Properties) session.getAttribute("jdbc");
                if (!ws_by_ip_name.equalsIgnoreCase("I")) {
                    
                    if (host.length() > 30)
                        host = host.substring(0, 30);
                    p.setProperty("client_ip_address", host);
                    session.setAttribute("jdbc", p);                    
                } else {
                    p.setProperty("client_ip_address", ip);
                    session.setAttribute("jdbc", p);
                }
            }
            String connection_pool_yn_new = "";			
            connection_pool_yn_new = (String) session.getAttribute("connection_pooling_yn");
			if(connection_pool_yn_new != null && connection_pool_yn_new.equals("N")){
                try{
                    String oraroleid = "";
                    String orarolepassword = "";                                        
                    responsibility_id = (String) session.getAttribute("responsibility_id");
					if(pstmt!=null)  pstmt.close();
                    pstmt = level3Con.prepareStatement("select app_password.decrypt(b.ORA_ROLE_PASSWORD) ORA_ROLE_PASSWORD,a.ORA_ROLE_ID from sm_resp a, sm_ora_role b where a.resp_id = ? and a.ora_role_id = b.ora_role_id and a.ORA_ROLE_ID = 'MEDADMIN' ");
                    pstmt.setString(1, responsibility_id);
                    rs = pstmt.executeQuery();
                    if (rs != null && rs.next()) {
                        oraroleid = rs.getString("ORA_ROLE_ID");
                        orarolepassword = rs.getString("ORA_ROLE_PASSWORD");
                    }
                    if (rs != null)
                        rs.close();
                    if (pstmt != null)
                        pstmt.close();
                    String dbsql = " set role " + oraroleid + " identified by "+ orarolepassword + "  ";
                    pstmt = level3Con.prepareStatement(dbsql);
                    int r = pstmt.executeUpdate();
					r= r;
                    if (pstmt != null) pstmt.close();
					session.setAttribute("Login","Y");

					//Changes for IPAD login -- start 4/12/2013
						if(ext_user_yn!=null && ext_user_yn.equals("N")){//Changes for IPAD login -- start 4/12/2013
							out.println("home.jsp");
						}
                }catch (Exception e){
                   
					e.printStackTrace();
                }     
            }else{
				try{
					session.setAttribute("Login","Y");		
					//Changes for IPAD login -- start -- 4/12/2013
					if(ext_user_yn!=null && ext_user_yn.equals("N")){
						out.println("home.jsp");
						}
                } catch (Exception esc) {					
					esc.printStackTrace();                    
                }
            }
        }catch (Exception es){
			es.printStackTrace();
        }finally{
            ConnectionManager.returnConnection(level3Con, req);
        }
    }
    
    private boolean connectionAvailable(HttpServletResponse res,HashMap userData){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
        boolean result = true;
        PrintWriter out = null;
        Connection localConnection = null;     
		//CHanged Global Variables to Local Variables..
		//APPLUSERS
		String derived_user = "";
		String derived_password = "";
		String derived_connect_string = "";
		String derived_db_driver = "";
		String derived_ejb_connect_string = "";
		String derived_report_connect_string = "";
		String derived_report_server = "";
		String connection_pool_yn = "";
		String report_ssl_yn = "";//Added By Dharma for MOHE-CRF-0009 on Oct 28th 2020
        try {
			out = res.getWriter();
			localConnection = ConnectionManager.getConnection();
            if(rs!=null)rs.close();
            if(pstmt!=null)pstmt.close();            
            pstmt = localConnection.prepareStatement("select nvl(connection_pool_yn,'N') connection_pool_yn,  user_id, app_password.decrypt(password) as password, connect_string, db_driver, ejb_connect_string, report_connect_string, report_server,report_ssl_yn from sm_db_info");
            rs = pstmt.executeQuery();            
            if (rs != null && rs.next()) {                
                derived_user = rs.getString("user_id");
                derived_password = rs.getString("password");
                derived_db_driver = rs.getString("db_driver");
                derived_connect_string = rs.getString("connect_string");
                derived_ejb_connect_string = rs.getString("ejb_connect_string");
                derived_report_connect_string = rs.getString("report_connect_string");
                derived_report_server = rs.getString("report_server");
                connection_pool_yn = rs.getString("connection_pool_yn");
                report_ssl_yn = rs.getString("report_ssl_yn") != null ? rs.getString("report_ssl_yn") : "N";
				userData.put("derived_user",derived_user);
				userData.put("derived_password",derived_password);
				userData.put("derived_connect_string",derived_connect_string);
				userData.put("derived_db_driver",derived_db_driver);
				userData.put("derived_ejb_connect_string",derived_ejb_connect_string);
				userData.put("derived_report_connect_string",derived_report_connect_string);
				userData.put("derived_report_server",derived_report_server);
				userData.put("connection_pool_yn",connection_pool_yn);
				userData.put("report_ssl_yn",report_ssl_yn);
            }else{                
                result = false;
            }            
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();         
        }catch (Exception e){            
            result = false;
            e.printStackTrace();
            out.println(e.getMessage());
        }finally{
            try{
				ConnectionManager.returnConnection(localConnection);
            }catch (Exception ce){
				ce.printStackTrace();
            }
        }
        return result;
    }
    
    private boolean validLogin(HttpServletResponse res,HashMap userData) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
        boolean result = true;
		PrintWriter out = null;
        boolean test_for_login = true;
        Connection validConnection = null;
		//Changed gloabl to local variables
		//MEDSTART
		String startup_user = "";
		String startup_password = "";
		String startup_connect_string = "";
		String startup_db_driver = "";
		String messagetextsysdef = "";
		String messageid = "";
		String invalidmessage = "";
		String ora_password = "";
		String account_status = "";
		String ecis_jdbc_user = (String) (userData.get("ecis_jdbc_user")==null?"":userData.get("ecis_jdbc_user"));
		String ecis_jdbc_password = (String) (userData.get("ecis_jdbc_password")==null?"":userData.get("ecis_jdbc_password"));
		String case_sensitive_password_yn = (String) (userData.get("case_sensitive_password_yn")==null?"N":userData.get("case_sensitive_password_yn"));//Maheshwaran added for the MMS-QH-CRF-0149
		String multiple_login_allowed_yn	= (String) (userData.get("multiple_login_allowed_yn")==null?"Y":userData.get("multiple_login_allowed_yn"));//Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613]
		String appl_user_name = "";
		String preferred_style = "";
		String locale = "";
        try {
           out = res.getWriter();
			validConnection = ConnectionManager.getConnection();
			    
            if (validConnection == null) {
                
                test_for_login = false;
                result = false;
            } else {
                test_for_login = true;
            }
            if (test_for_login) {
                try {
                    
                    //String query = "select preferred_style, LANGUAGE_ID, nvl((select APPL_USER_NAME from sm_appl_user_lang where language_id = sm_appl_user.LANGUAGE_ID and appl_user_id = sm_appl_user.appl_user_id),sm_appl_user.appl_user_name) appl_user_name from sm_appl_user where appl_user_id = ? and UPPER(app_password.decrypt(appl_user_password)) =? and eff_status='E' and ( trunc(sysdate) between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr') ) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr') ) )";
					//Maheshwaran modified the query for the MMS-QH-CRF-0149
					StringBuffer query=new StringBuffer();
					query.append("select preferred_style, LANGUAGE_ID, nvl((select APPL_USER_NAME from sm_appl_user_lang where language_id = sm_appl_user.LANGUAGE_ID and appl_user_id = sm_appl_user.appl_user_id),sm_appl_user.appl_user_name) appl_user_name from sm_appl_user where appl_user_id = ?  and eff_status='E' and ( trunc(sysdate) between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr') ) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr') ) )");
					if(case_sensitive_password_yn.equals("N"))
					query.append(" and upper(app_password.decrypt(appl_user_password)) =? ");
					else
					query.append(" and app_password.decrypt(appl_user_password) =? "); 
					
                    pstmt = validConnection.prepareStatement(query.toString());
					pstmt.setString(1, ecis_jdbc_user);
					//Maheshwaran modified for the MMS-QH-CRF-0149
					if(case_sensitive_password_yn.equals("N"))
						{
						pstmt.setString(2, ecis_jdbc_password.toUpperCase());
						}
					else
						{	
						pstmt.setString(2, ecis_jdbc_password);
						}
                    rs = pstmt.executeQuery();
                    
                    if (rs != null && rs.next()) {
                        result = true;
						preferred_style = rs.getString("preferred_style");
						if( (preferred_style ==null) || (preferred_style.equals("")) ) preferred_style="IeStyle.css";
						locale=rs.getString("LANGUAGE_ID") ;
						locale = (locale==null?"en":locale) ;
						appl_user_name=rs.getString("appl_user_name");
						String cssName	= preferred_style;
						if(cssName.contains("_bu")){
							String[] arrSplit = cssName.split("\\.");
							cssName	= arrSplit[0];
						}else{
							cssName	= cssName.replace(".css","");
						}
						if(locale.equals("bu")){
							if(!cssName.contains("_bu")){
								cssName	= cssName+"_bu.css";
							}else{
								cssName	= cssName+".css";
							}
						}else{
							if(cssName.contains("_bu")){
								cssName	= cssName.replace("_bu",".css");
							}else{
								cssName	= cssName+".css";
							}
						}
						preferred_style	= 	cssName;
						//Commented by Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613]
						/*userData.put("appl_user_name",appl_user_name);
						userData.put("preferred_style",preferred_style);
						userData.put("locale",locale);*/
                    } else {
						out.println("error_num=1||"+ecis_jdbc_user+"||error=Invalid User ID/Password.  Please try again.");
                        
                        result = false;
                    }
				
				
					/*Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] Start*/
					if(result && multiple_login_allowed_yn.equals("N")){
						String chkAlreadyLoggedIn	= "Select count(*) tot from SM_APPL_USER_AUDIT where appl_user_id='"+ecis_jdbc_user+"'";
						int userCount					= 0;
						pstmt1 = validConnection.prepareStatement(chkAlreadyLoggedIn);
						rs1 = pstmt1.executeQuery();
						if(rs1 != null && rs1.next()){
							userCount	= rs1.getInt("tot");  
						}
						if(userCount==0){
							result = true;
						}else{
							out.println("error_num=1||"+ecis_jdbc_user+"||error=User already logged in the system. cannot login again.");
							result = false;
						}
					}

                     if (rs1 != null)
                        rs1.close(); //Added for checkstyle
					if(result){
						if( (preferred_style ==null) || (preferred_style.equals("")) ) preferred_style="IeStyle.css";
								locale = (locale==null?"en":locale) ;
						userData.put("appl_user_name",appl_user_name);
						userData.put("preferred_style",preferred_style);
						userData.put("locale",locale);
					}
					 
                    if (rs != null)
                        rs.close();
                    if (pstmt != null)
                        pstmt.close();
                    //if (rs1 != null)
                        //rs1.close(); //Commented for checkstyle
                    if (pstmt1 != null)
                        pstmt1.close();
                   /*Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] End*/ 
                } catch (Exception e) {
                    e.printStackTrace();
                    result = false;
                }
            }
        } catch (Exception loge) {
            result = false;
            test_for_login = false;
            String get_excp = loge.toString();
            String print_excp = "";
            String print_excp_no = "";
            try {
                
                int count_excp = 1;
                StringTokenizer stoken = new StringTokenizer(get_excp, ":");
                while (stoken.hasMoreTokens()) {
                    print_excp = stoken.nextToken();
                    if (count_excp == 1) {
                        print_excp_no = stoken.nextToken();
                    }
                    count_excp++;
                }
                if (print_excp_no != null && print_excp_no.equals(" ORA-01017")) {
						out.println("error_num=1||"+ecis_jdbc_user+"||error=Invalid User ID/Password.  Please try again.");
                } else if (print_excp_no.equals(" ORA-28000")) {
						out.println("error_num=1||"+appl_user_name+"||error=User Account Is Locked");
                } else if (print_excp_no.equals(" ORA-28001")) {
                    
					    messagetextsysdef = "APP-SM0063 Password is Expired for the User";
                        invalidmessage = messageid + " - " + messagetextsysdef;
                        String changepassword = "<html><link rel='stylesheet' type='text/css' href='../eCommon/html/IeStyle.css'><script>function showChangePassword() { var retVal = new Array(); var features	= 'dialogHeight:20; dialogWidth:30;status=no;scroll=no'; var arguments	= '' ;  retVal = window.showModalDialog('../eSM/jsp/change_password_frames_login.jsp?ecis_jdbc_user="
                                            + ecis_jdbc_user
                                            + "&startup_db_driver="
                                            + startup_db_driver
                                            + "&startup_connect_string="
                                            + startup_connect_string
                                            + "&startup_user="
                                            + startup_user
                                            + "&startup_password="
                                            + startup_password
                                            + "',arguments,features); if(retVal != null && retVal == 'T'){window.location.href='../eSM/jsp/login.jsp?user_name_pass="
                                            + ecis_jdbc_user
                                            + "&change_pass=change_pass'}; };</script><br><br><br><table cellpadding=0 cellspacing=0 align=center border=0><tr><td class=BODYCOLORFILLED colspan=2>"
                                            + ""
                                            + invalidmessage
                                            + "</td></tr></table><hr><table cellpaddin=0 cellspacing=0 align=center border=0><tr><td class=BODYCOLORFILLED colspan=2 align=center><b>Do you want to change it now ? </b></td></tr><tr><td class=BODYCOLORFILLED colspan=2>&nbsp;</td></tr><tr><td class=BODYCOLORFILLED align=center><input type=button class=BUTTON value='  Yes  ' onClick='javascript:showChangePassword()'></td><td class=BODYCOLORFILLED align=center><input type=button class=BUTTON value='   No   ' onClick='window.close()'></td></tr></table>";
                        out.println(changepassword);
                } else {
                    
                    pstmt = validConnection.prepareStatement("select app_password.decrypt(ORA_ROLE_PASSWORD) ORA_ROLE_PASSWORD from sm_ora_role  where ORA_ROLE_ID ='MEDADMIN' ");
                    rs = pstmt.executeQuery();
                    if (rs != null && rs.next()) {
                        ora_password = rs.getString("ORA_ROLE_PASSWORD");
                    }
                    String role_sql = " set role MEDADMIN identified by " + ora_password + "  ";
                    
                    if (rs != null)
                        rs.close();
                    if (pstmt != null)
                        pstmt.close();
                    
                    pstmt = validConnection.prepareStatement(role_sql);
                    
                    int r = pstmt.executeUpdate();
					r=r;
                    String acc_status = "select 'EXPIRED' from dba_users where username='"
                                        + ecis_jdbc_user
                                        + "' and account_status like 'EXPIRE%'";
                    
                    if (pstmt != null)
                        pstmt.close();
                    pstmt = validConnection.prepareStatement(acc_status);
                    
                    rs = pstmt.executeQuery();
                    
                    if (rs != null && rs.next()) {
                        account_status = rs.getString(1);
                    }
                    
                    if (rs != null)
                        rs.close();
                    if (pstmt != null)
                        pstmt.close();
                    
                    if (account_status != null && account_status.equals("EXPIRED")) {
							messagetextsysdef = "APP-SM0063 Password is Expired for the User";
                            invalidmessage = messageid + " - " + messagetextsysdef;
                            String changepassword = "<html><link rel='stylesheet' type='text/css' href='../eCommon/html/IeStyle.css'><script>function showChangePassword() { var retVal = new Array(); var features	= 'dialogHeight:20; dialogWidth:30;status=no;scroll=no';  var arguments	= '' ;  retVal = window.showModalDialog('../eSM/jsp/change_password_frames_login.jsp?ecis_jdbc_user="
                                                + ecis_jdbc_user
                                                + "&startup_db_driver="
                                                + startup_db_driver
                                                + "&startup_connect_string="
                                                + startup_connect_string
                                                + "&startup_user="
                                                + startup_user
                                                + "&startup_password="
                                                + startup_password
                                                + "',arguments,features); if(retVal != null && retVal == 'T'){window.location.href='../eSM/jsp/login.jsp?user_name_pass="
                                                + ecis_jdbc_user
                                                + "&change_pass=change_pass'}; };</script><br><br><br><table cellpadding=0 cellspacing=0 align=center border=0><tr><td class=BODYCOLORFILLED colspan=2>"
                                                + ""
                                                + invalidmessage
                                                + "</td></tr></table><hr><table cellpaddin=0 cellspacing=0 align=center border=0><tr><td class=BODYCOLORFILLED colspan=2 align=center><b>Do you want to change it now ? </b></td></tr><tr><td class=BODYCOLORFILLED colspan=2>&nbsp;</td></tr><tr><td class=BODYCOLORFILLED align=center><input type=button class=BUTTON value='  Yes  ' onClick='javascript:showChangePassword()'></td><td class=BODYCOLORFILLED align=center><input type=button class=BUTTON value='   No   ' onClick='window.close()'></td></tr></table>";
                            out.println(changepassword);
                    } else {
                        invalidmessage = print_excp_no + " : " + print_excp;
						out.println("error_num=1||"+appl_user_name+"||error="+invalidmessage);
                    }
                }
            } catch (Exception eq) {
                eq.printStackTrace();
            }        
            
        }
        
        finally {
            try {
                //validConnection.close();
				if(validConnection!=null){
					ConnectionManager.returnConnection(validConnection);
				}
            } catch (Exception ce) {
            ce.printStackTrace();            
			}
        }
        
        return result;
    }    
    private boolean findGraceTimeAlert(HttpServletRequest req,HttpServletResponse res,HashMap userData) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
        boolean result = true;
        Connection graceConnection = null;
		PrintWriter out = null;
        //Changed global variables to local variables
		int grace_time = 0;
		double expire_after = 0.0;
		String expiry_date = "";
		String ecis_jdbc_user = (String) (userData.get("ecis_jdbc_user")==null?"":userData.get("ecis_jdbc_user"));
        try {
			out = res.getWriter();
            graceConnection = ConnectionManager.getConnection(req);
            String quer = "select to_char(a.expiry_date) expiry_date, nvl(a.expiry_date,sysdate)-sysdate expire_after, nvl(b.ora_pwd_grace_time,0) ora_pwd_grace_time from user_users a, sm_ora_rsrc_grp b,sm_appl_user c where a.username = c.appl_user_id and c.ora_rsrc_group_id =b.ora_rsrc_group_id and a.username='" + ecis_jdbc_user + "'";
			
            
            if(rs!=null)rs.close();
            if(pstmt!=null)pstmt.close();
            
            pstmt = graceConnection.prepareStatement(quer);
            rs = pstmt.executeQuery();
            
            if (rs != null && rs.next()) {
                expiry_date = rs.getString("expiry_date");
                expire_after = rs.getDouble("expire_after");
                grace_time = rs.getInt("ora_pwd_grace_time");
                int expir_time = (int) expire_after;
                
                if (grace_time == 0 || expiry_date == null) {
                    result = false;
                } else {
                    if (expir_time <= grace_time && expir_time >= 1) {
                        out.println("<script>alert('Your Password will be expired with in "+ expir_time + " Days')");
                        out.println("document.location.href='../servlet/eSM.LoginResponseServlet?mode=Grace';");
                        out.println("</script></html>");
                    } else {
                        result = false;
                    }
                }
            } else {
                result = false;
            }
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
            
        } catch (Exception e) {
            out.println("ADEWREWR:" +e.toString());
        } finally {
            ConnectionManager.returnConnection(graceConnection, req);
        }
        return result;
    }
	//Maheshwaran K added for MMS-CRF-149
	private boolean firstLoginYN(HttpServletRequest req,HttpServletResponse res,HashMap userData,Connection con,String FIRST_LOGIN_YN) {
		PreparedStatement stmt_Pwd1=null;
		PrintWriter out = null;
		boolean result=false;
		//HttpSession session = req.getSession(true);//Commented for checkstyle
		//String appl_user_name = (String) (userData.get("appl_user_name")==null?"":userData.get("appl_user_name"));//Commented for checkstyle
		String ecis_jdbc_user = (String) (userData.get("appl_user_name")==null?"":userData.get("ecis_jdbc_user"));
		//String locale = (String) (userData.get("locale")==null?"en":userData.get("locale")); //Commented for checkstyle
		try
			{
			out = res.getWriter();
			String upd_sql="UPDATE SM_APPL_USER SET FIRST_LOGIN_YN = ?  WHERE APPL_USER_ID = ? and FIRST_LOGIN_YN= ? ";
			stmt_Pwd1 = con.prepareStatement(upd_sql);	
			stmt_Pwd1.setString ( 1, "N"   ) ;
			stmt_Pwd1.setString ( 2, ecis_jdbc_user   ) ;
			stmt_Pwd1.setString ( 3, FIRST_LOGIN_YN ) ;
			int a = stmt_Pwd1.executeUpdate();					
			if(stmt_Pwd1!=null)
			stmt_Pwd1.close();
			con.commit();
			if((a==1)&&(!multierr_str.equals("error_num=3")))
				{
				result=true;
				}
			}
		catch(Exception e)
			{
			System.out.println("Exception occurred while updating FIRST_LOGIN_YN in SM_APPL_USER table : "+e);
			e.printStackTrace();
			}
		return result;	
		//End	
	}
	
	/*Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] Start*/
	private boolean insertAuditInfo(HttpServletRequest req,HttpServletResponse res,HashMap userData,Connection con) {
		PreparedStatement stmtAudit=null;
		PrintWriter out = null;
		boolean result=false;
		//HttpSession session = req.getSession(true); //Commented for checkstyle
		String ecis_jdbc_user = (String) (userData.get("appl_user_name")==null?"":userData.get("ecis_jdbc_user"));
		//String locale = (String) (userData.get("locale")==null?"en":userData.get("locale")); //Commented for checkstyle
		try {
				out = res.getWriter();
				String ins_sql="insert into SM_APPL_USER_AUDIT(APPL_USER_ID,RELEASE_YN,ADDED_BY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_AT_WS_NO,LOGIN_DATE,ADDED_DATE,MODIFIED_DATE,LOGIN_TYPE) values(?,?,?,?,?,?,sysdate,sysdate,sysdate,?)";
				stmtAudit = con.prepareStatement(ins_sql);
				int inc	= 1;
				stmtAudit.setString ( inc++, ecis_jdbc_user);
				stmtAudit.setString ( inc++, "N");
				stmtAudit.setString ( inc++, ecis_jdbc_user);
				stmtAudit.setString ( inc++, (String)userData.get("host"));
				stmtAudit.setString ( inc++, ecis_jdbc_user);
				stmtAudit.setString ( inc++, (String)userData.get("host"));
				stmtAudit.setInt ( inc++, 3);
				int resCnt = stmtAudit.executeUpdate();					
				if(stmtAudit!=null)
				stmtAudit.close();
				con.commit();
				if((resCnt==1)) {
					result=true;
				}

			
			}
		catch(Exception e)
			{
			System.err.println("Exception occurred while inserting audit info in SM_APPL_USER_AUDIT table insertAuditInfo method: "+e);
			e.printStackTrace();
			}
		return result;	
		//End	
	}
	/*Added By Dharma on 17th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] End*/

    
}//class
