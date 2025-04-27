/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
 
public class PractSpecialtyRelationServlet extends HttpServlet
 {

	public void init(ServletConfig config) throws ServletException
	{
			 super.init(config);
	}

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	 {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");			
			
			final int MAX = 7;
			Connection con = null;	
			PreparedStatement psn = null;
			PreparedStatement psd = null;
			ResultSet rsn = null;
			
			
			String err_val = "";
			int i = 0;
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession(false);
			Properties property = new	Properties();
		
			String ID[][] = new String[2][MAX];

			String error = "";
			String SpecialtyCode = request.getParameter("specialty_code");
			String IPEnc = request.getParameter("IPEnc").equals("")? "null": request.getParameter("IPEnc");
			String IPAdmit = request.getParameter("IPAdmit").equals("") ?"null": request.getParameter("IPAdmit");
			String OPVisit = request.getParameter("OPVisit").equals("")?"null": request.getParameter("OPVisit");
			String AE = request.getParameter("AE").equals("") ?"null" : request.getParameter("AE") ;
			String DayCare = request.getParameter("DayCare").equals("") ? "null" : request.getParameter("DayCare");
			String Ref_rel = request.getParameter("Ref_rel").equals("")? "null" : request.getParameter("Ref_rel");
			String Nurse_rel = request.getParameter("NR").equals("")? "null" : request.getParameter("NR");
			int id[] = new int[MAX];					
			
			int j = 0;
			char d[] = new char[1];
			String dummy = null;
			
			int index = IPEnc.indexOf(":");
			if(index ==-1)
			{
				ID[1][0] = IPEnc;
				id[0] = 0;
			}
			else
			{
			ID[1][0] = IPEnc.substring(j,index);
			j = index+1 ;
			d[0] = IPEnc.charAt(j);
			//dummy = d.toString();
			 dummy = new String(d);
			id[0] = Integer.parseInt(dummy);
			}	
			 j = 0;

			dummy =  null;
			 index = IPAdmit.indexOf(":");
			if(index ==-1)
			{
				ID[1][1] = IPAdmit;
				id[1] = 0;
			}
			else
			{
			ID[1][1] = IPAdmit.substring(j,index);
			j = index+1 ;
			d[0] = IPAdmit.charAt(j);
			//dummy = d.toString();
			dummy = new String(d);
			id[1] = Integer.parseInt(dummy);
			}	
				
		
			dummy =  null;

			 j = 0;
			 index = OPVisit.indexOf(":");
			if(index ==-1)
			{
				ID[1][2] = OPVisit;
				id[1] = 0;
			}
			else
			{
			ID[1][2] = OPVisit.substring(j,index);
			j = index+1 ;
			
			d[0] = OPVisit.charAt(j);
			//dummy = d.toString();
			dummy = new String(d);
			id[2] = Integer.parseInt(dummy);
			}	

			dummy =  null;			
				j = 0;
			 index = AE.indexOf(":");
			if(index ==-1)
			{
				ID[1][3] = AE;
				id[1] = 0;
			}
			else
			{
			ID[1][3] = AE.substring(j,index);
			j = index+1 ;

			d[0] = AE.charAt(j);
			//dummy = d.toString();
			dummy = new String(d);
			id[3] = Integer.parseInt(dummy);
			}	
				j = 0;
							
		dummy =  null;
		 index = DayCare.indexOf(":");
			if(index ==-1)
			{
				ID[1][4] = DayCare;
				id[1] = 0;
			}
			else
			{
			ID[1][4] = DayCare.substring(j,index);
			j = index+1 ;
		
			d[0] = DayCare.charAt(j);
			//dummy = d.toString();
			dummy = new String(d);
			id[4] = Integer.parseInt(dummy);
			}	
			j = 0;
			dummy =  null;				
		 index = Ref_rel.indexOf(":");
			if(index ==-1)
			{
				ID[1][5] = Ref_rel;
				id[5] = 0;
			}
			else
			{
			ID[1][5] = Ref_rel.substring(j,index);
			j = index+1 ;
	
			d[0] = Ref_rel.charAt(j);
			//dummy = d.toString();
			dummy = new String(d);
			id[5] = Integer.parseInt(dummy);
			}	
			j = 0;
			 index = Nurse_rel.indexOf(":");
			dummy =  null;	 			
			if(index ==-1)
			{
				ID[1][6] = Ref_rel;
				id[6] = 0;
			}
			else
			{
			ID[1][6] = Nurse_rel.substring(j,index);
			j = index+1 ;
		
			d[0] = Nurse_rel.charAt(j);
			//dummy = d.toString();
			dummy = new String(d);
			id[6] = Integer.parseInt(dummy);
			}	

			ID[0][0] = "IE";
			ID[0][1] = "IA";
			ID[0][2] = "OP";
			ID[0][3] = "EM";
			ID[0][4] = "DC";
			ID[0][5] = "RF";
			ID[0][6] = "NS";
			
			int rows = 0;
			property = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) property.getProperty("LOCALE");
			String facilityId = (String)session.getValue("facility_id") ;
			String client_ip_address = property.getProperty("client_ip_address");
			//String serviceURL=(String) session.getValue("serviceURL");
			String modifiedById = (property.getProperty("login_user")==null)?"": property.getProperty("login_user")  ;           
			//String modifiedFacilityId		= (facilityId==null)?"":facilityId;                    
			//String modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;         
			
			boolean flag = false;
			out.println("<html>");
			out.println("<body>");
			//String insert ="";
			 
			try
				{
								con = ConnectionManager.getConnection(request);
								
								if((ID[1][0].equals("null")) && (ID[1][1].equals("null")) && (ID[1][2].equals("null")) && (ID[1][3].equals("null")) && (ID[1][4].equals("null")) && (ID[1][5].equals("null")) && (ID[1][6].equals("null")))
								{
											psd = con.prepareStatement("Delete from CA_PP_RELN_FOR_SPLTY where SPECIALITY_CODE = ? ");
											psd.setString(1,SpecialtyCode);
											 psd.executeUpdate();
											if(psd != null) psd.close();
											flag = true;
											con.commit();
								}
								else
								{	
								
											psd = null ;
											psn = con.prepareStatement("INSERT INTO CA_PP_RELN_FOR_SPLTY ( SPECIALITY_CODE, RELN_CATEGORY,RELN_ID, ADDED_BY_ID, ADDED_DATE,ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID ) VALUES (?, ?, ?, ?,SYSDATE,?,?,?,SYSDATE,?,?)");
											psn.setString(1,SpecialtyCode);
											psn.setString(4,modifiedById);	
											psn.setString(5,client_ip_address);	
											psn.setString(6,facilityId);	
											psn.setString(7,modifiedById);	
											psn.setString(8,client_ip_address);	
											psn.setString(9,facilityId);	
											i = 0;
											while(i < MAX)
											{
														if( ! (ID[1][i].equals("null"))  )
														{
															if(id[i] == 0)
															{
																	
																	psd = con.prepareStatement("Delete from CA_PP_RELN_FOR_SPLTY where SPECIALITY_CODE = ?  and RELN_CATEGORY = ?");
																	psd.setString(1,SpecialtyCode);
																	psd.setString(2,ID[0][i]);
																	 psd.executeUpdate();
																	psn.setString(2,ID[0][i]);
																	psn.setString(3,ID[1][i]);
																	rows = rows + psn.executeUpdate();
																	if(psd != null) psd.close();
															}
															else
															{
																	rows++;
															}
														}
														else
														{
															psd = null;
															psd = con.prepareStatement("Delete from CA_PP_RELN_FOR_SPLTY where SPECIALITY_CODE = ?  and RELN_CATEGORY = ?");
															psd.setString(1,SpecialtyCode);
															psd.setString(2,ID[0][i]);
															 psd.executeUpdate();
															rows++;
														}	
													i++;	

											}

								}
								
								if(rows == MAX || flag == true)
									{
										con.commit();	
										error = getMessage(locale, "RECORD_INSERTED","CA");
										err_val = "1";
										response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"&err_value="+err_val);

									}
									else
									{
										con.rollback();	
									}	
									
									

				}
				catch(Exception e)
				{
					//out.println(e);//common-icn-0181
					e.printStackTrace();
					try
					{
						con.rollback();	
					}
					catch(Exception exception){}
				}
				finally
				 {
					try
					 {
						if (rsn != null) rsn.close();
						if (psd != null) psd.close();
						if (psn != null) psn.close();
						if (psd != null) psd.close();
						if(con != null) ConnectionManager.returnConnection(con);
					 }
					 catch(Exception ee){}
					
				 }	
			
			
		 }
		
 }


