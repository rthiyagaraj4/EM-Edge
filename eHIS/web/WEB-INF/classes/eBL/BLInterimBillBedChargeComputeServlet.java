/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import java.net.*;
import webbeans.eCommon.*;

public class BLInterimBillBedChargeComputeServlet extends javax.servlet.http.HttpServlet 
{
	PrintWriter out;
	public void init(ServletConfig config) throws ServletException	{
		
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		String facility_id = "";
		java.util.Properties p = null;		

		Connection con=null;
		CallableStatement call = null;		
		ResultSet rst1 = null;	
		PreparedStatement pst1=null;
		String login_user= "",client_ip_address="";
		int total_records;
		HttpSession session = req.getSession(false);
		String locale	= (String)session.getAttribute("LOCALE");		
		boolean boolSuccess = true;	
		Hashtable messageHashtable=new Hashtable();
		String msg="";
//		String patient_id="",patient_name="",episode_type="",adm_no="",adm_date="",last_bed_chr_date="",ward="",room_no="",cust_code="",bed_class="",unbill_amt="",unadjust_dep="",outstand_amt="",total_amt="",compute_upto_date="",added_date="",bed_chr_date="";
		String process_key="",process_date="";
		String added_at_ws_no="",strrecordcount="",v_key="",sysdate="";
		String strerrorlevel="", strsysmessageid="",strerrortext=""; 


		facility_id = (String)session.getAttribute("facility_id") ;
		p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		client_ip_address = p.getProperty("client_ip_address");		
		login_user = p.getProperty( "login_user" ) ;		
//		System.out.println("inside servlet interim bed charge");
		try 
		{
			this.out = res.getWriter();			
			out.println("<html>");
			out.println("<head>");
			con = ConnectionManager.getConnection(req);
			//bed_chr_date=req.getParameter("bed_chr_date");	
			con.setAutoCommit(false);
			String str_ws_by_ip_name = "";	
			try{
					String sqlst1="select ws_by_ip_name from sm_facility_param_vw where facility_id = '"+facility_id+"'";
					pst1=con.prepareStatement(sqlst1);
					rst1 = pst1.executeQuery();
					if (rst1!=null)
					{
						if (rst1.next())
						{
						 str_ws_by_ip_name = rst1.getString("ws_by_ip_name");
						}
					}

						if (rst1 != null)   rst1.close();
						if (pst1 != null)   pst1.close();

						if ( str_ws_by_ip_name == null ) str_ws_by_ip_name ="";
						if (str_ws_by_ip_name.equals("I"))
						{
							added_at_ws_no = InetAddress.getByName((String) client_ip_address).getHostName().toUpperCase();
						}
						else
						{	
							added_at_ws_no = client_ip_address; 
						}		
				}catch(Exception ws)
					{ System.out.println("ws exception" +ws);}
					
					try{

						String sqlsysdate="select to_char(sysdate, 'DD/MM/YYYY HH24:MI:SS') from dual";
							pst1=con.prepareStatement(sqlsysdate);
							rst1 = pst1.executeQuery();
							if (rst1!=null)
							{
								if (rst1.next())
								{
								 sysdate = rst1.getString(1);																
								}
							}

								if (rst1 != null)   rst1.close();
								if (pst1 != null)   pst1.close();
								if ( sysdate == null ) sysdate ="";

							String sqlst3="select to_char(sysdate, 'YYYYMMDD') from dual";
							pst1=con.prepareStatement(sqlst3);
							rst1 = pst1.executeQuery();
							if (rst1!=null)
							{
								if (rst1.next())
								{
								 v_key = rst1.getString(1);	
								 
								}
							}

								if (rst1 != null)   rst1.close();
								if (pst1 != null)   pst1.close();
								if ( v_key == null ) v_key ="";

							String sqlst2="select to_char(sysdate, 'YYYYMMDDHH24MMSS') from dual";
							pst1=con.prepareStatement(sqlst2);
							rst1 = pst1.executeQuery();
							if (rst1!=null)
							{
								if (rst1.next())
								{
								 process_date = rst1.getString(1);									 
								}
							}

								if (rst1 != null)   rst1.close();
								if (pst1 != null)   pst1.close();
								if ( process_date == null ) process_date ="";

								if(boolSuccess)
								{
									String seq_no="BEDCAL_JOB_SEQ";
									String sqlProcessKey="{call BLCORE.generate_sequence_common_proc('"+facility_id+"', '"+seq_no+"',  '"+v_key+"',?,?)}";
//									System.out.println("sqlProcessKey" +sqlProcessKey);
									 call = con.prepareCall(sqlProcessKey);		
									
									 call.registerOutParameter(1,java.sql.Types.VARCHAR);
									 call.registerOutParameter(2,java.sql.Types.VARCHAR);
									
									 call.execute();   
									 process_key		 = call.getString(1);										
									 strerrortext     	 = call.getString(2);				
									 if ( process_key == null ) process_key = "";
									 if ( strerrortext == null ) strerrortext = "";								
									
									 
									
									 call.close();	
										if(!strerrortext.equals(""))
										{
											boolSuccess = false; 
											out.println("<script>parent.frames[3].location.href = '../eCommon/jsp/error.jsp?err_num= "+strerrortext+" '</script>");	
											out.println("<script language='JavaScript'>parent.frames[0].funRefresh(); </script>");
										}
										else{

											messageHashtable=MessageManager.getMessage(locale,"BL9981","BL");
											msg=(String)messageHashtable.get("message");										

											String process_msg= msg+process_key;
											out.println("<script>parent.frames[3].location.href = '../eCommon/jsp/error.jsp?err_num= "+process_msg+" '</script>");	
										}
								}


						}catch(Exception ws)
							{ System.out.println("date exp" +ws);}


						strrecordcount=req.getParameter("total_records");	
						if ( strrecordcount == null ) strrecordcount = "";
						total_records=Integer.parseInt(strrecordcount);

//						java.util.Locale loc = new java.util.Locale(locale);
//						java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
//						java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle("eCommon.resources.Labels",loc);


//getting total records
						try{
							if(boolSuccess)
							{
								ArrayList output_records=new ArrayList();
								String[] output1=new String[4];
								output_records=(ArrayList)session.getAttribute("total_records_array");
//								System.out.println("output_records.size :"+output_records.size());
								for(int k=0;k<output_records.size();k++)
								{
									output1=(String[])output_records.get(k);
									//for(int n=0; n<output1.length; n++)
									//{
										
										
										String sqlBedCharge="{ call BL_COMPUTE_BED_CHARGE.Ins_Bed_charge_ctl ('"+output1[0]+"','"+login_user+"','"+process_key+"','"+process_date+"','"+output1[1]+"','"+output1[2]+"','"+output1[3]+"',TO_DATE('"+sysdate+"','DD/MM/YYYY HH24:MI:SS'),'"+login_user+"',TO_DATE('"+sysdate+"','DD/MM/YYYY HH24:MI:SS'),'"+added_at_ws_no+"','"+output1[0]+"',?,?,?)}";	
//										System.out.println("sqlBedCharge "+sqlBedCharge);
										 call = con.prepareCall(sqlBedCharge);						
										 call.registerOutParameter(1,java.sql.Types.VARCHAR);
										 call.registerOutParameter(2,java.sql.Types.VARCHAR);
										 call.registerOutParameter(3,java.sql.Types.VARCHAR);
										 call.execute();   
										 strerrorlevel		 = call.getString(1);		
										 strsysmessageid		 = call.getString(2);		
										 strerrortext     	 = call.getString(3);				
										 if ( strerrorlevel == null ) strerrorlevel = "";
										 if ( strsysmessageid == null ) strsysmessageid ="";
										 if ( strerrortext == null ) strerrortext ="";
//										 System.out.println("strerrorlevel :"+strerrorlevel);
//										 System.out.println("strsysmessageid :"+strsysmessageid);
//										 System.out.println("strerrortext :"+strerrortext);							
										 call.close();	
									// }							

								}
									 if ( strsysmessageid.equals("") && strerrortext.equals("") && strerrorlevel.equals(""))
										{
//											System.out.println("success");				
											con.commit();
											call.close();
										}
									if ((strerrorlevel.equals("10") && (!strerrortext.equals(""))) ||!strsysmessageid.equals(""))
										{		
										   con.rollback();
											call.close();
											boolSuccess=false;

											if (strerrorlevel.equals("10") ||(!strerrortext.equals("")))
											{
//												System.out.println("2 val");																	
												out.println("<script> alert('main proc '+'"+strerrortext+"');  </script>");	
												out.println("<script>parent.parent.interim_main_report.location.href='../eBL/jsp/BLBillInterimReportFrame.jsp';</script>");
												out.println("<script>parent.messageFrame.location.href = '../eCommon/jsp/error.jsp?err_num="+strerrortext+"' </script>)");
											}	
											
											if(!strsysmessageid.equals(""))
											{
												messageHashtable=MessageManager.getMessage(locale,strsysmessageid,"BL");
												msg=(String)messageHashtable.get("message");
												out.println("<script> alert('"+msg+"');  </script>");	
												out.println("<script>parent.parent.interim_main_report.location.href='../eBL/jsp/BLBillInterimReportFrame.jsp';</script>");
												out.println("<script>parent.frames[3].location.href = '../eCommon/jsp/error.jsp?err_num="+msg+"' </script>");
											}

										}else{
										boolSuccess=true;
										//messageHashtable=MessageManager.getMessage(locale,"BL1008","BL");
										//msg=(String)messageHashtable.get("message");
										//out.println("<script>parent.frames(3).location.href='../eCommon/jsp/error.jsp?err_num="+msg+" ' </script>");
										out.println("<script language='JavaScript'>parent.frames(0).funRefresh(); </script>");
										}

									}
							}catch(Exception exp1)
											{
												System.out.println("arryay" +exp1);
											}
//end total records
						
						
					/*	if(boolSuccess)
						{
							for(int i=0;i<total_records;i++)
							{
							System.out.println("Insdide for LOOP");
							String[] records=new String[20];
							records[0]=req.getParameter("patient_id"+i);	
							patient_id=records[0];			
							if ( patient_id == null )  patient_id = "";

							records[1]=req.getParameter("patient_name"+i);	
							patient_name=records[1];			
							if ( patient_name == null )  patient_name = "";

							records[2]=req.getParameter("episode_type"+i);	
							episode_type=records[2];			
							if ( episode_type == null )  episode_type = "";

							records[3]=req.getParameter("adm_no"+i);	
							adm_no=records[3];			
							if ( adm_no == null )  adm_no = "";

							records[4]=req.getParameter("adm_date"+i);	
							adm_date=records[4];			
							if ( adm_date == null )  adm_date = "";

							records[5]=req.getParameter("last_bed_chr_date"+i);	
							last_bed_chr_date=records[5];			
							if ( last_bed_chr_date == null )  last_bed_chr_date = "";

							records[5]=req.getParameter("ward"+i);	
							ward=records[5];			
							if ( ward == null )  ward = "";

							records[6]=req.getParameter("room_no"+i);	
							room_no=records[6];			
							if ( room_no == null )  room_no = "";

							records[7]=req.getParameter("cust_code"+i);	
							cust_code=records[7];			
							if ( cust_code == null )  cust_code = "";
							
							records[8]=req.getParameter("bed_class"+i);	
							bed_class=records[8];			
							if ( bed_class == null )  bed_class = "";

							records[9]=req.getParameter("unbill_amt"+i);	
							unbill_amt=records[9];			
							if ( unbill_amt == null )  unbill_amt = "";

							records[10]=req.getParameter("unadjust_dep"+i);	
							unadjust_dep=records[10];			
							if ( unadjust_dep == null )  unadjust_dep = "";

							records[11]=req.getParameter("outstand_amt"+i);	
							outstand_amt=records[11];			
							if ( outstand_amt == null )  outstand_amt = "";

							records[12]=req.getParameter("total_amt"+i);	
							total_amt=records[12];			
							if ( total_amt == null )  total_amt = "";						
							

							String sqlBedCharge="{ call BL_COMPUTE_BED_CHARGE.Ins_Bed_charge_ctl ('"+facility_id+"','"+login_user+"','"+process_key+"','"+process_date+"','"+patient_id+"','"+episode_type+"','"+adm_no+"',TO_DATE('"+sysdate+"','DD/MM/YYYY HH24:MI:SS'),'"+client_ip_address+"',TO_DATE('"+sysdate+"','DD/MM/YYYY HH24:MI:SS'),'"+added_at_ws_no+"','"+facility_id+"',?,?,?)}";	
							System.out.println("sqlBedCharge "+sqlBedCharge);
							 call = con.prepareCall(sqlBedCharge);						
							 call.registerOutParameter(1,java.sql.Types.VARCHAR);
							 call.registerOutParameter(2,java.sql.Types.VARCHAR);
							 call.registerOutParameter(3,java.sql.Types.VARCHAR);
							 call.execute();   
							 strerrorlevel		 = call.getString(1);		
							 strsysmessageid		 = call.getString(2);		
							 strerrortext     	 = call.getString(3);				
							 if ( strerrorlevel == null ) strerrorlevel = "";
							 if ( strsysmessageid == null ) strsysmessageid ="";
							 if ( strerrortext == null ) strerrortext ="";
							 System.out.println("strerrorlevel :"+strerrorlevel);
							 System.out.println("strsysmessageid :"+strsysmessageid);
							 System.out.println("strerrortext :"+strerrortext);							
							 call.close();				

							}

							if ( strsysmessageid.equals("") && strerrortext.equals("") && strerrorlevel.equals(""))
							{
								System.out.println("success");				
								con.commit();
								call.close();
							}


							if ((strerrorlevel.equals("10") && (!strerrortext.equals(""))) ||!strsysmessageid.equals(""))
							{		
							   con.rollback();
								call.close();
								boolSuccess=false;

								if (strerrorlevel.equals("10") ||(!strerrortext.equals("")))
								{
									System.out.println("2 val");																	
									out.println("<script> alert('main proc '+'"+strerrortext+"');  </script>");	
									out.println("<script>parent.parent.interim_main_report.location.href='../eBL/jsp/BLBillInterimReportFrame.jsp';</script>");
									out.println("<script>parent.messageFrame.location.href = '../eCommon/jsp/error.jsp?err_num="+strerrortext+"' </script>)");
								}	
								
								if(!strsysmessageid.equals(""))
								{
									messageHashtable=MessageManager.getMessage(locale,strsysmessageid,"BL");
									msg=(String)messageHashtable.get("message");
									out.println("<script> alert('"+msg+"');  </script>");	
									out.println("<script>parent.parent.interim_main_report.location.href='../eBL/jsp/BLBillInterimReportFrame.jsp';</script>");
									out.println("<script>parent.frames(3).location.href = '../eCommon/jsp/error.jsp?err_num="+msg+"' </script>");
								}

							}else{
							boolSuccess=true;
							messageHashtable=MessageManager.getMessage(locale,"BL1008","BL");
							msg=(String)messageHashtable.get("message");
							out.println("<script>parent.frames(3).location.href='../eCommon/jsp/error.jsp?err_num="+msg+" ' </script>");
							out.println("<script language='JavaScript'>parent.frames(0).funRefresh(); </script>");
							}
						}*/

							if(boolSuccess)
							{
								String sqlSubmit="{ call BL_COMPUTE_BED_CHARGE.PROC_SUBMIT('BLTBDCAL','"+facility_id+"','"+login_user+"','"+process_key+"','"+process_date+"')}";
//								System.out.println("sqlSubmit "+sqlSubmit);
								call = con.prepareCall(sqlSubmit);	
								 call.execute();   
								 call.close();
							}
		
		out.println("</head>");
		out.println("</html>");

	}catch(Exception exp)
				{
					System.out.println("main" +exp);
				}
				finally
				{
					session.removeAttribute("output_records");

					ConnectionManager.returnConnection(con, req);
				}
	
		
  }
}
