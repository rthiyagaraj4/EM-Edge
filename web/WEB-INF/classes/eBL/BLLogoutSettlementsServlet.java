/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;
import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;



//import oracle.aurora.jndi.sess_iiop.ServiceCtx ;
public class BLLogoutSettlementsServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	//HttpServletRequest	 HTTPreq ;	//HttpServletResponse	HTTPres;
	public void init(ServletConfig config) throws ServletException	{		
	super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		
		boolean ss = new Boolean((Boolean) req.getSession().getAttribute("ssv")).booleanValue();   //sarathkumar added code to make as siteSpecific GDOH-CRF-0117...
		
		//debug("Entering="+ (System.currentTimeMillis()) );
		String client_ip_address="";String login_user="";String facility_id = "";	String cashcounter = "";
		//String opening_balance = "";
		java.util.Properties p = null;
		PreparedStatement pstmt = null;
		String logout_time = "0";String login_time = "0";	String error_level = "";
		//String err_code = "0";
		String sys_message_id = "";	String error_text = "";		String locale="";
		HttpSession session = req.getSession(false);
		 locale	= (String)session.getAttribute("LOCALE");
		// Parameters for the Cancel Amount, Actual, Discrepancy amount
		String parcan = "0";	String paract = "0";	String pardis = "0";String parrcp = "0"; //Calculated Slmt amount
		// Getting the values from the above parameters
		String strcan = "0";String stract = "0";String strdis = "0";	String strrcp = "0";
		// Storing in double.
		double dblcan = 0.0;double dblact = 0.0;	double dbldis = 0.0;	double dblrcp = 0.0;
		int intRow = 0;
		boolean boolSuccess = true;
		String strQuery = "0";		String strSlmtType = "0";
		String called_frm = "";
		//Vector vecotorSlmt = new Vector();
		ArrayList arrListSlmt = new ArrayList();

		double 	dbl_tot_cash_bills_amt	 = 0.0;  	double 	dbl_tot_credit_bills_amt = 0.0;  	
		double 	dbl_tot_rcp			 = 0.0;  		double 	dbl_tot_act			 = 0.0;  		           
		double 	dbl_tot_can			 = 0.0;  		           
		
		String 	str_tot_cash_bills_amt	 = "0";	String  str_tot_credit_bills_amt = "0";  	
		String  str_tot_rcp			 = "0";  	String  str_tot_act			 = "0";  		           
		String 	str_tot_can			 = "0";  	
		String logout_time_blrp1="",login_time_blrp1="",logout_time_blrp2="",login_time_blrp2="";

		str_tot_cash_bills_amt		= req.getParameter("tot_cash_bills_amt");
		str_tot_credit_bills_amt	= req.getParameter("tot_credit_bills_amt");
		str_tot_rcp					=  req.getParameter("tot_rcp");
		str_tot_act					=  req.getParameter("tot_act");
		str_tot_can					=  req.getParameter("tot_can");
		String cash_ctr_logout_with_cb_yn = req.getParameter("cash_ctr_logout_with_cb_yn");
		if ((cash_ctr_logout_with_cb_yn == null)||(cash_ctr_logout_with_cb_yn.equals(""))) cash_ctr_logout_with_cb_yn="";
		String cash_ctr_logout_rep_ind = req.getParameter("cash_ctr_logout_rep_ind");
			if ((cash_ctr_logout_rep_ind == null)||(cash_ctr_logout_rep_ind.equals(""))) cash_ctr_logout_rep_ind="";

			String hand_without_counter_chk_out = req.getParameter("hand_without_counter_chk_out");
			if ((hand_without_counter_chk_out == null)||(hand_without_counter_chk_out.equals(""))) hand_without_counter_chk_out="";
			


	
		logout_time = req.getParameter("logout_time");
		login_time = req.getParameter("login_time"); 
//		System.out.println("logout_time :"+logout_time);
//		System.out.println("login_time :"+login_time);		
		//debug("logout_time = "+logout_time);
		String logoutsucc=req.getParameter("logoutSuccesful");
		String logoutsubm=req.getParameter("logoutSubmit");
		called_frm = req.getParameter("called_frm");
		if(called_frm == null) called_frm="";
//		System.out.println("called_frm in serv :"+called_frm);		
		String strResults="";
		//System.out.println("succesful"+logoutsucc);
		//System.out.println("subm"+logoutsubm);
		try
		{
			str_tot_cash_bills_amt = ((str_tot_cash_bills_amt == null)||(str_tot_cash_bills_amt.equals(""))) ? "0" : str_tot_cash_bills_amt;
			str_tot_credit_bills_amt = ((str_tot_credit_bills_amt == null)||(str_tot_credit_bills_amt.equals(""))) ? "0" : str_tot_credit_bills_amt;
			str_tot_rcp = ((str_tot_rcp == null)||(str_tot_rcp.equals(""))) ? "0" : str_tot_rcp;
			str_tot_can = ((str_tot_can == null)||(str_tot_can.equals(""))) ? "0" : str_tot_can;

			logout_time = ((logout_time == null)||(logout_time.equals("")))? "0" :logout_time;
			login_time = ((login_time == null)||(login_time.equals("")))? "0" :login_time;

			dbl_tot_cash_bills_amt	 = Double.parseDouble(str_tot_cash_bills_amt);  	
			dbl_tot_credit_bills_amt = Double.parseDouble(str_tot_credit_bills_amt);  	
			dbl_tot_rcp				 = Double.parseDouble(str_tot_rcp);  		
			dbl_tot_act				 = Double.parseDouble(str_tot_act);  		
			dbl_tot_can				 = Double.parseDouble(str_tot_can);  		

		}
		catch(Exception exp)
		{				

		}

		cashcounter = req.getParameter("cash_counter");		
//		System.out.println("cashcounter :"+cashcounter);
		if ((cashcounter == null)||(cashcounter.equals(""))) cashcounter="";
		facility_id = (String)session.getAttribute("facility_id") ;
		p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		login_user = p.getProperty( "login_user" ) ;

		//debug("Properties="+p);	
		//debug("facility_id="+facility_id);
		//debug("cashcounter="+cashcounter);

		try 
		{
				this.out = res.getWriter();
				//out.println("<html><head><script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script></head></html>");
				out.println("<html>");
				out.println("<head>");
				Connection con = ConnectionManager.getConnection(req);
				//debug("boolSuccess="+boolSuccess);
				if (boolSuccess)
				{
						try
						{
							

							CallableStatement call = con.prepareCall("{ call bl_cash_counter_check.check_before_closing_counter(?,?,?,?,?,?) }");						
							call.setString(1,facility_id);
							call.setString(2,cashcounter);
							call.setString(3,logout_time);
							call.registerOutParameter(4,java.sql.Types.VARCHAR); 
							call.registerOutParameter(5,java.sql.Types.VARCHAR); 
							call.registerOutParameter(6,java.sql.Types.VARCHAR); 

							call.execute();

							error_level = call.getString(4);   
							if(error_level==null) error_level="";	

							sys_message_id = call.getString(5);   
							if(sys_message_id==null) sys_message_id="";	

							error_text = call.getString(6);   
							if(error_text==null) error_text="";	

																
							//if ((err_code == null)|| err_code.equalsIgnoreCase("null")) err_code = "0";

							if (!sys_message_id.equals("")||(error_level.equals("10") && !error_text.equals("")))
							{
								boolSuccess = false;
								
							}
							else
							{
								boolSuccess = true;

							}
							
							call.close();
						

						
						}
						catch(Exception exp)
						{
							//debug(exp+"");;
							boolSuccess = false; //Added V171114-Gayathri/MMS-ICN-00045
							System.out.println("before closing cash counter="+exp.toString());
						
						}

					}

			


			if (boolSuccess)
			{ //Added V171114-Gayathri/MMS-ICN-00045/Start
				try
				{
					String slmt_array  = req.getParameter("slmt_array");
					StringTokenizer strTokenizer = new StringTokenizer(slmt_array,"|");
					int intSlmtCounter = 0;
					while(strTokenizer.hasMoreElements())
					{
						//vecotorSlmt.insertElementAt(strTokenizer.nextElement(),intSlmtCounter);
						arrListSlmt.add(intSlmtCounter,strTokenizer.nextElement());
						++intSlmtCounter;
					}
				}
				catch(Exception exp)
				{
				}
			CallableStatement call = null;
				try{
					
					call = con.prepareCall("{ call bl_cash_counter_check.insert_cash_counter_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?) }");	
					
					for (int i=0 ;i<arrListSlmt.size();i++)
					{
					if(boolSuccess)
					{
					strSlmtType = (String) arrListSlmt.get(i) ;
					parcan = (String)arrListSlmt.get(i) +"_can";
					paract = (String)arrListSlmt.get(i) +"_act";
					pardis = (String)arrListSlmt.get(i) +"_dis";
					parrcp = (String)arrListSlmt.get(i) +"_rcp";
					strcan = (String)req.getParameter(parcan);
					stract =  (String)req.getParameter(paract);
					strdis =  (String)req.getParameter(pardis);
					strrcp = (String)req.getParameter(parrcp);

					if ((strcan == null) ||(strcan.equals("")))
					{
						strcan = "0";
					}
					if ((stract == null) ||(stract.equals("")))
					{
						stract = "0";
					}

					if ((strdis == null) ||(strdis.equals("")))
					{
						strdis = "0";
					}
					if ((strrcp == null) ||(strrcp.equals("")))
					{
						strrcp = "0";
					}
					dblcan = Double.parseDouble(	strcan);
					dblact =  Double.parseDouble(	stract);
					dbldis = Double.parseDouble(strdis);
					dblrcp = Double.parseDouble(strrcp);
					call.setString(1,facility_id);          	
					call.setString(2,cashcounter);          
					call.setString(3,login_user);           
					call.setString(4,login_time);        
					call.setString(5,strSlmtType);           
					call.setDouble(6,dblrcp);                
					call.setDouble(7,dblcan);                
					call.setDouble(8,dblact);                
					call.setDouble(9,dbldis);                
					call.setString(10,login_user);           
					call.registerOutParameter(11,java.sql.Types.VARCHAR); 
					call.registerOutParameter(12,java.sql.Types.VARCHAR); 
					call.registerOutParameter(13,java.sql.Types.VARCHAR); 
					
					System.out.println("Inside Logout Procedure check_after_closing_counter dblcan"+dblcan+"dblact "+dblact+" dbldis"+dbldis+" dblrcp "+dblrcp+" strSlmtType "+strSlmtType+" login_time "+login_time+"login_user "+login_user+"cashcounter"+cashcounter);
					call.execute();
					
					error_level = call.getString(11);   
					if(error_level==null) error_level="";	

					sys_message_id = call.getString(12);   
					if(sys_message_id==null) sys_message_id="";	

					error_text = call.getString(13);   
					if(error_text==null) error_text="";	
					
					System.out.println("Inside Logout Procedure check_after_closing_counter error_level"+error_level+"sys_message_id "+sys_message_id+" error_text"+error_text);
					if (!sys_message_id.equals("")||(error_level.equals("10") && !error_text.equals("")))
					{
						boolSuccess = false;
						
					}
					else
					{
						boolSuccess = true;

					}
					
				}

				}
					
					call.close();	
					
				}
				catch(Exception exp)
				{
					//debug(exp+"");;
					boolSuccess = false;
					System.out.println("before closing cash counter="+exp.toString());
				
				}

			}
		//Added V171114-Gayathri/MMS-ICN-00045/End	

			if (boolSuccess)
			{
					CallableStatement call = null;
					try
					{
//						System.out.println("Inside Logout Procedure");
						call = con.prepareCall("{ call bl_cash_counter_check.close_cash_cunter(?,?,?,?,?,?,?,?,?,?,?,?,?) }");						

						call.setString(1,facility_id);
						call.setString(2,login_user);
						call.setString(3,cashcounter);
						call.setDouble(4,dbl_tot_cash_bills_amt);
						call.setDouble(5,dbl_tot_credit_bills_amt);
						call.setDouble(6,dbl_tot_rcp);
						call.setDouble(7,dbl_tot_act);
						call.setDouble(8,dbl_tot_can);
						call.setString(9,logout_time);
						call.setString(10,client_ip_address);
						call.registerOutParameter(11,java.sql.Types.VARCHAR);
						call.registerOutParameter(12,java.sql.Types.VARCHAR);
						call.registerOutParameter(13,java.sql.Types.VARCHAR);


						call.execute();

						error_level = call.getString(11);   
						if(error_level==null) error_level="";	

						sys_message_id = call.getString(12);
						if(sys_message_id==null) sys_message_id="";	

						error_text = call.getString(13);
						if(error_text==null) error_text="";	
						
//						System.out.println("error_level in Logout Servlet is :"+error_level);
//						System.out.println("error_text in Logout Servlet is :"+error_text);
//						System.out.println("sys_message_id in Logout Servlet is :"+sys_message_id);
						
						//if ((err_code == null)|| err_code.equalsIgnoreCase("null")) err_code = "0";

						if (!sys_message_id.equals("")||(error_level.equals("10") && !error_text.equals("")))				
						{
							boolSuccess = false;
							
						}
						else
						{
							boolSuccess = true;
							
							//strMessageText = call.getString(12);
						}
						call.close();

					}
					catch(Exception exp)
					{
						//debug(exp+"");;
						boolSuccess = false;//Added V171114-Gayathri/MMS-ICN-00045
						//out.println("error="+exp);
						exp.printStackTrace();
					}
				}
				//Added V171114-Gayathri/MMS-ICN-00045/Start
			
			if(boolSuccess == true){
				try
				{
					String slmt_array  = req.getParameter("slmt_array");
					StringTokenizer strTokenizer = new StringTokenizer(slmt_array,"|");
					int intSlmtCounter = 0;
					while(strTokenizer.hasMoreElements())
					{
						//vecotorSlmt.insertElementAt(strTokenizer.nextElement(),intSlmtCounter);
						arrListSlmt.add(intSlmtCounter,strTokenizer.nextElement());
						++intSlmtCounter;
					}
				}
				catch(Exception exp)
				{
				}
				
				
				
				CallableStatement call = null;
				try
				{
					System.out.println("Inside Logout Procedure check_after_closing_counter");
					call = con.prepareCall("{ call bl_cash_counter_check.check_after_closing_counter(?,?,?,?,?,?,?,?,?,?,?,?,?) }");			
					
for (int i=0 ;i<arrListSlmt.size();i++)
				{  
				if(boolSuccess)
					{
					strSlmtType = (String) arrListSlmt.get(i) ;
					
					paract = (String)arrListSlmt.get(i) +"_act";
					pardis = (String)arrListSlmt.get(i) +"_dis";
					
					
					stract =  (String)req.getParameter(paract);
					strdis =  (String)req.getParameter(pardis);
					
					dblact =  Double.parseDouble(	stract);
					dbldis = Double.parseDouble(strdis);
				
					if ((stract == null) ||(stract.equals("")))
					{
						stract = "0";
					}

					if ((strdis == null) ||(strdis.equals("")))
					{
						strdis = "0";
					}
					
					call.setString(1,facility_id);
					call.setString(2,cashcounter);
					call.setString(3,login_user);
					call.setString(4,login_time);
					call.setString(5,logout_time);
					call.setDouble(6,dblact);
					call.setDouble(7,dbldis);
					call.setDouble(8,dbl_tot_rcp);
					call.setDouble(9,dbl_tot_act);
					call.setDouble(10,dbl_tot_can);
					call.registerOutParameter(11,java.sql.Types.VARCHAR);
					call.registerOutParameter(12,java.sql.Types.VARCHAR);
					call.registerOutParameter(13,java.sql.Types.VARCHAR);


					call.execute();
					System.out.println("Inside Logout Procedure check_after_closing_counter");
					error_level = call.getString(11);   
					if(error_level==null) error_level="";	

					sys_message_id = call.getString(12);
					if(sys_message_id==null) sys_message_id="";	

					error_text = call.getString(13);
					if(error_text==null) error_text="";	
					
					
					System.out.println("before closing cash counter= 111 "+error_level+" sys_message_id "+sys_message_id+" error_text"+error_text);
				System.out.println("error_level in Logout Servlet is :"+error_level);
				System.out.println("error_text in Logout Servlet is :"+error_text);
					System.out.println("sys_message_id in Logout Servlet is :"+sys_message_id);
					
					//if ((err_code == null)|| err_code.equalsIgnoreCase("null")) err_code = "0";

					if (!sys_message_id.equals("")||(error_level.equals("10") && !error_text.equals("")))				
					{
						boolSuccess = false;
						
					}
					else
					{
						boolSuccess = true;
						
						//strMessageText = call.getString(12);
					}
				
}
					}
call.close();
				}
				catch(Exception exp)
				{
					//debug(exp+"");;
					
					boolSuccess = false;//Added V171114-Gayathri/MMS-ICN-00045
					//out.println("error="+exp);
					//System.out.println("before closing cash counter="+exp.toString());
					exp.printStackTrace();
				}
				
				
				
				
				
				
				
			}
	//Added V171114-Gayathri/MMS-ICN-00045/End
			if (boolSuccess == true)
			{
				
								

				con.commit();
		      //debug("Commit ="+ (System.currentTimeMillis()) );
			  
				String module_id = "BL";
				String temp_login_time = login_time.substring(0,10) + (login_time.substring(11));			
//				System.out.println("temp_login_time " +temp_login_time);
				int intTempIndex = 0;
				while (true)
				{
					intTempIndex = temp_login_time.indexOf(":");
					if (intTempIndex <=0)
					{
						break;
					}
					temp_login_time = temp_login_time.substring(0,intTempIndex) + temp_login_time.substring(intTempIndex+1);
				} 
//				System.out.println("temp_login_time ll" +temp_login_time);


		//added by ram for converting logout time("yyyy/mm/ddhh24miss")31/10/2008
			try{
				ResultSet rs=null;																					
				pstmt = con.prepareStatement("SELECT To_Char(To_Date('"+logout_time+"','dd/mm/yyyy hh24:mi:ss'),'yyyy/mm/ddhh24miss') FROM dual");			
				rs = pstmt.executeQuery();			
				while(rs.next())
				{
					logout_time_blrp1 =  rs.getString(1);		

				}	
				rs.close();
				pstmt.close();
//				System.out.println("logout_time_blrp1 :"+logout_time_blrp1);
				}catch(Exception e)
					{
				System.out.println("logout_time_blrp1="+e.toString());
					}
			
			//end 
			//added by ram for converting login time("yyyy/mm/ddhh24miss")31/10/2008
			try{
				ResultSet rs=null;																					
				pstmt = con.prepareStatement("SELECT To_Char(To_Date('"+login_time+"','dd/mm/yyyy hh24:mi:ss'),'yyyy/mm/ddhh24miss') FROM dual");			
				rs = pstmt.executeQuery();			
				while(rs.next())
				{
					login_time_blrp1 =  rs.getString(1);		

				}	
				rs.close();
				pstmt.close();
//				System.out.println("login_time_blrp1 :"+login_time_blrp1);
				}catch(Exception e)
					{
				System.out.println("login_time_blrp1="+e.toString());
					}
			
				//end 

				//added by ram for converting logout time("dd/mm/RRRR hh24miss")31/10/2008
			try{
				ResultSet rs=null;																					
				pstmt = con.prepareStatement("SELECT To_Char(To_Date('"+logout_time+"','dd/mm/yyyy hh24:mi:ss'),'DD/MM/RRRRHH24MISS') FROM dual");			
				rs = pstmt.executeQuery();			
				while(rs.next())
				{
					logout_time_blrp2 =  rs.getString(1);		

				}	
				rs.close();
				pstmt.close();
//				System.out.println("logout_time_blrp2 :"+logout_time_blrp2);
				}catch(Exception e)
					{
				System.out.println("logout_time_blrp2="+e.toString());
					}
			
			//end 
			//added by ram for converting login time("dd/mm/RRRR hh24miss")31/10/2008
			try{
				ResultSet rs=null;																					
				pstmt = con.prepareStatement("SELECT To_Char(To_Date('"+login_time+"','dd/mm/yyyy hh24:mi:ss'),'DD/MM/RRRRHH24MISS') FROM dual");			
				rs = pstmt.executeQuery();			
				while(rs.next())
				{
					login_time_blrp2 =  rs.getString(1);		

				}	
				rs.close();
				pstmt.close();
//				System.out.println("login_time_blrp2 :"+login_time_blrp2);
				}catch(Exception e)
					{
				System.out.println("login_time_blrp2="+e.toString());
					}
			
				//end 


				
			
				
					
				//out.println(" <script> alert('Logged Out Successfully'); </script>");
				//out.println(" <script> document.write.alert(getMessage(\"BL9322\",\"BL\")); </script>");
				//out.println(" <script> alert('Cash Counter Logout Report Submitted to the Server'); parent.window.close(); </script>");
				//out.println(" <script> alert(getMessage(\"BL9323\",\"BL\")); parent.window.close(); </script>");			
				out.println("<script> alert('"+logoutsucc+"');  </script>");
				//sarathkumar added code to make as siteSpecific GDOH-CRF-0117...
				if(!ss){
					out.println("<script> alert('"+logoutsubm+"');  </script>");	
				}
					
				
				//Added By Rajesh V - CRF - RUT009
				String custId = BLReportIdMapper.getCustomerId();
				String onlineReportScript = "<script>"
								+" var dialogHeight= '11' ; "
								+" var dialogWidth	= '27' ; "
								+" var dialogTop = '225' ; "
								+" var center = '1' ;	"												   
								+" var status='no'; "
								+" var features	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + '; center: ' + center + '; status: ' + status + '; dialogTop :' + dialogTop; "
									+" var arguments	= '' ;	 "
								+" var retVal2 = window.showModalDialog('../eBL/jsp/BLCollectionReports.jsp',arguments,features);  "
								+" if(retVal2 != 'undefined' && retVal2 != undefined){	 "									
								+" 	var xmlDoc = new ActiveXObject( 'Microsoft.XMLDom' ) ;  "
								+" 	var xmlHttp = new ActiveXObject( 'Microsoft.XMLHTTP' ) ;  "
								+" 	var xmlStr ='<root><SEARCH ';  "
								+" 	xmlStr +=' /></root>';  "
								+" 	xmlDoc.loadXML(xmlStr);  "
								+" 	xmlHttp.open('POST','../eBL/jsp/BLPrtOnlineReport.jsp?func_mode=PrintOnlineReport&param='+retVal2,false);  "
										+" 	xmlHttp.send(xmlDoc);  "
								+" }  "
								+ " </script>";
				//custId = "RTN";
				if("RTN".equalsIgnoreCase(custId)){
					out.println(onlineReportScript);
				}
				
				//Added By Rajesh V - CRF - RUT009
//				System.out.println("success part");
				if(called_frm.equals("DISC_FUN"))
				{
//System.out.println("success part1");
		out.println("<script> parent.parent.frames[1].location.href='../eBL/jsp/BLLogoutCashCounterMain.jsp?win_close_for_disc_call=Y';	</script>");
				}
				else
				{
					out.println("<script> parent.parent.frames[1].location.href ='../eBL/jsp/BLLogoutCashCounterMain.jsp';	</script>");
				}

				System.out.println("cash_ctr_logout_rep_ind"+cash_ctr_logout_rep_ind);
				if(cash_ctr_logout_rep_ind.equals("D"))
				{
					String report_id = "BLRSRJ01";
					
//					System.out.println("FIRST report_id" +report_id);
				OnlineReport onlinereportParam = new OnlineReport(facility_id, module_id, report_id);
				onlinereportParam.addParameter("p_opr_facility_id",facility_id);
				onlinereportParam.addParameter("p_operator",login_user);
				onlinereportParam.addParameter("p_report_id",report_id);
				onlinereportParam.addParameter("p_cash_counter_code",cashcounter);
				onlinereportParam.addParameter("p_cash_counter_user_id",login_user);
				onlinereportParam.addParameter("p_login_date_time",login_time_blrp1);
				onlinereportParam.addParameter("p_logout_date_time",logout_time_blrp1);
				onlinereportParam.addParameter("P_LANGUAGE_ID",locale);

				onlinereportParam.addParameter("p_module",module_id);
				res.flushBuffer();

				OnlineReports onlinereports = new OnlineReports();
				onlinereports.add(onlinereportParam);
				HttpServletResponse httpservletresponse = res;
				strResults =  onlinereports.execute(req, httpservletresponse);
//				System.out.println("strResults 3:"+strResults);
				if ((strResults == null)||(strResults.equals(""))) strResults="";
				

				onlinereportParam = null;
				onlinereports = null;

				  report_id = "BLRSRJ02";
					
//					System.out.println("FIRST report_id 2" +report_id);
				 onlinereportParam = new OnlineReport(facility_id, module_id, report_id);
				onlinereportParam.addParameter("p_opr_facility_id",facility_id);
				onlinereportParam.addParameter("p_operator",login_user);
				onlinereportParam.addParameter("p_report_id",report_id);
				onlinereportParam.addParameter("p_cash_counter_code",cashcounter);
				onlinereportParam.addParameter("p_cash_counter_user_id",login_user);
				onlinereportParam.addParameter("p_login_date_time",login_time_blrp2);
				onlinereportParam.addParameter("p_logout_date_time",logout_time_blrp2);
				onlinereportParam.addParameter("P_LANGUAGE_ID",locale);

				onlinereportParam.addParameter("p_module",module_id);
				res.flushBuffer();

				 onlinereports = new OnlineReports();
				onlinereports.add(onlinereportParam);
				//HttpServletResponse httpservletresponse = res;
				 strResults =  onlinereports.execute(req, httpservletresponse);
//				System.out.println("strResults 3:"+strResults);
				if ((strResults == null)||(strResults.equals(""))) strResults="";

				onlinereportParam = null;
				onlinereports = null;
				

					

				
				}
				else{
					System.out.println("insidee else");
					//sarathkumar added code to make as siteSpecific GDOH-CRF-0117...
					if(!ss){
						System.out.println("sitespecific gdof false");
						String report_id="";
						if(hand_without_counter_chk_out.equals("Y")){
						 report_id = "BLRLOGOT";}
						else{
						 report_id = "BLR00003";
						}
									
//									System.out.println("THIRD report_id" +report_id);
//				System.out.println("=====facility_id:"+facility_id);
//				System.out.println("=====login_user:"+login_user);
//				System.out.println("=====report_id:"+report_id);
//				System.out.println("=====cashcounter:"+cashcounter);
//				System.out.println("=====temp_login_time:"+temp_login_time);
//				System.out.println("=====locale:"+locale);
//				System.out.println("=====module_id:"+module_id);
				OnlineReport onlinereportParam = new OnlineReport(facility_id, module_id, report_id);
				onlinereportParam.addParameter("p_opr_facility_id",facility_id);
				onlinereportParam.addParameter("p_operator",login_user);
				onlinereportParam.addParameter("p_report_id",report_id);
				onlinereportParam.addParameter("p_cash_counter_code",cashcounter);
				onlinereportParam.addParameter("p_cash_counter_user_id",login_user);
				onlinereportParam.addParameter("p_login_date_time",temp_login_time);
				onlinereportParam.addParameter("P_LANGUAGE_ID",locale);

				onlinereportParam.addParameter("p_module",module_id);
				res.flushBuffer();

				OnlineReports onlinereports = new OnlineReports();
				onlinereports.add(onlinereportParam);
				HttpServletResponse httpservletresponse = res;
				strResults =  onlinereports.execute(req, httpservletresponse);
//				System.out.println("strResults 3:"+strResults);
				if ((strResults == null)||(strResults.equals(""))) strResults="";


				onlinereportParam = null;
				onlinereports = null;
					}
					
				}
			}
			else
			{
				con.rollback();	
				if(error_level.equals("10") && !error_text.equals(""))
				{
					out.println("<script> alert('"+error_text+"');  parent.window.close(); </script>");
					return;
				}

				if(!error_level.equals("") &&!error_level.equals("10") && !error_text.equals(""))
				{
					out.println("<script> alert('"+error_text+"');  parent.window.close(); </script>");					
				}
				if(!sys_message_id.equals(""))
				{
					out.println("<script> alert(getMessage('"+sys_message_id+"','BL'));  parent.window.close(); </script>");
					return;

					//out.println("<script> alert('"+err_code+"');  parent.window.close(); </script>");
				}

			}

//			System.out.println("End of Report Calling");
			
			ConnectionManager.returnConnection(con, req);
			out.println("</head>");
			out.println("</html>");
		}
		catch(Exception e)
		{
								
			//debug(e+"");;
			e.printStackTrace();
		}
		 			

	
	}
	/*
				String reportParamNames = "p_opr_facility_id"+comma+"p_module"+comma+"p_operator"+comma+
			"p_report_id"+comma+"p_cash_counter_code"+comma+"p_cash_counter_user_id"+comma+"p_login_date_time";
			String reportParamValues = facility_id+comma+module_id+comma+login_user+comma+report_id+comma+cashcounter+comma+login_user+comma+login_time;
			String htmlFor = " <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link>";
			htmlFor += "</head><body class='message'>";
			htmlFor += " <script> alert('Logged Out Successfully'); </script>";
			htmlFor += " <script> alert('Report Submitted to the Server'); </script>";
			htmlFor += "<script language = 'JavaScript'>" ;
			htmlFor += "  var dialogHeight    = '25' ;";
			htmlFor +=  " var dialogWidth = '45' ;";
			htmlFor +=  "var dialogTop = 58;" ;
			htmlFor += "  var arguments =   ''; ";
			htmlFor += "  var getUrl        =   '../eCommon/jsp/InternalReportsPrint.jsp?reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+
				"&facility_id="+facility_id+"&total="+total+"&reportid0="+report_id+"&moduleid0="+module_id+"&chk0=Y"+
				"&first_time_only="+first_time_only+"&step="+step+"';";
			htmlFor += " var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;";
			htmlFor += "  retVal            =   window.showModalDialog(getUrl,arguments,features); ";
			htmlFor += " </script>"  ;

	*/
}
