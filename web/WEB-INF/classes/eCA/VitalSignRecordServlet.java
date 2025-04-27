/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           created
11/12/2013      IN034536		Nijitha S		Bru-HIMS-CRF-133 
--------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import javax.naming.*;
import javax.ejb.*;
import javax.rmi.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.rmi.*;
import java.sql.*;
import eCA.DisDataCharting.*;
import webbeans.eCommon.*;

public class VitalSignRecordServlet extends javax.servlet.http.HttpServlet
{
		public void init(ServletConfig config) throws ServletException	
		{
				super.init(config);
		}

		public void doPost(HttpServletRequest req, HttpServletResponse res)  throws javax.servlet.ServletException,IOException
		{
			PrintWriter out = null;				
			HttpSession session = null;

			try
			{
				req.setCharacterEncoding("UTF-8");
				res.setContentType("text/html;charset=UTF-8");		
				session = req.getSession(false);
				out = res.getWriter();
				insertDisDataCharting(req,session,out);
			}
			catch (Exception e)	
			{
				out.println("In post "+e);
				e.printStackTrace();
			}
		}
  
private void insertDisDataCharting(HttpServletRequest req, HttpSession session, PrintWriter out)
{
	java.util.Properties p = (java.util.Properties) session.getValue("jdbc") ;
//	String locale		= (String) p.getProperty("LOCALE");
	String sStyle =	 "";	
	String operatingfacilityid = "";         
	String accessionnum = "";                  
	String episodetype = "";                   
	String episodeid = "";                     
	String visitid = "";                       
	String clinicianid = "";        
	String locncode = "";
	String patientid = "";
	String discrmsrid = ""; 
	String discrmsrresultnum = "";           
	String discrmsrresultnumuom = "";       
	String discrmsrresultstr = "";           
	String discrmsrresultdata = "";          
	String normallow = "";                     
	String normalhigh = "";                    
	String criticallow = "";                   
	String criticalhigh = "";   
	String discrmsrresulttype = "";
	String admdttime = "";
	String defdata = "";
	String normabnormind = "";
	String batteryid = "";
	String Sdate = "";
	String inError="";
	String inReplace="";
	String errorRemarks="";
	String client_ip_address="";
	String location_type ="";
	String module_id="";
	int rowcount=1;
	int noofrec = 0;
	int outrec = 0;
	int noofvals = 15;
	String temp_outrec=outrec+"";
	String temp_noofvals=noofvals+"";
	String p_queue_date = "";//IN034536
	String isPatientEncMovement = "";//IN034536
	String Sydate = "";//IN034536
			
	String finalvalues[][] = null ;

	String outPut1 = "";
	String outPut2 = "<script>top.content.workAreaFrame.frames(0).onsuccess();</script>"+"</BODY></html>";
	String outPut3 = "</BODY></html>";

	sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	outPut1 = "<html><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>"+"<BODY CLASS='MESSAGE'>";

	/**
	added by Deepa on 5/19/2010 for IN021207 
	queried CR_CLIN_EVENT_PARAM table to get the indicators, which were hard coded (L,M,H,K)earlier
	**/
	String lowInd = "";
	String highInd = "";
	String critLowInd = "";
	String critHighInd = "";
	//String criticalInd = "";
	//String abnormalInd = "";

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try
	{		try
			{
				con  = ConnectionManager.getConnection(req);
				ps = con.prepareStatement("SELECT HIGH_STR, LOW_STR, ABN_STR, CRIT_STR, CRIT_HIGH_STR, CRIT_LOW_STR FROM CR_CLIN_EVENT_PARAM");

				rs = ps.executeQuery();

				while(rs.next())
				{
					lowInd = rs.getString("LOW_STR") ==null ? "" : rs.getString("LOW_STR");
					highInd = rs.getString("HIGH_STR") ==null ? "" : rs.getString("HIGH_STR");
					critLowInd = rs.getString("CRIT_LOW_STR") ==null ? "" : rs.getString("CRIT_LOW_STR");
					critHighInd = rs.getString("CRIT_HIGH_STR") ==null ? "" : rs.getString("CRIT_HIGH_STR");
					//criticalInd = rs.getString("CRIT_STR") ==null ? "" : rs.getString("CRIT_STR");
					//abnormalInd = rs.getString("ABN_STR") ==null ? "" : rs.getString("ABN_STR");
				}	

				if(rs != null)  rs.close();
				if(ps != null) ps.close();	 
			}
			catch (Exception ee)
			{
				
				ee.printStackTrace();
			}
			finally
			{
				if(rs != null)  rs.close();
				if(ps != null) ps.close();
				if(con!=null) ConnectionManager.returnConnection(con,p);
			}
			
	/**
	added by Deepa on 5/19/2010 for IN021207 
	queried CR_CLIN_EVENT_PARAM table to get the indicators, which were hard coded (L,M,H,K)earlier
	**/

			Sdate=req.getParameter("sys_date_time");
			patientid = req.getParameter("patient_id");	
			clinicianid = req.getParameter("clinician_id");
			locncode = req.getParameter("locn_code")==null?"":req.getParameter("locn_code");
			episodetype = req.getParameter("patient_class");

			episodeid = req.getParameter("episode_id");    
			visitid = req.getParameter("visit_id")==null?"1":req.getParameter("visit_id");       
			operatingfacilityid = req.getParameter("facility_id")==null?"":req.getParameter("facility_id");
			admdttime = req.getParameter("adm_dt_time")==null?"":req.getParameter("adm_dt_time");
			inError = req.getParameter("in_error")==null?"":req.getParameter("in_error");
			inReplace =req.getParameter("in_replace")==null?"":req.getParameter("in_replace");
			client_ip_address = p.getProperty("client_ip_address");
			location_type = (req.getParameter("location_type")==null)?"":req.getParameter("location_type");
			module_id =req.getParameter("module_id")==null?"":req.getParameter("module_id"); 	

			batteryid =req.getParameter("battery_id")==null?"":req.getParameter("battery_id"); 
			noofrec = Integer.parseInt(req.getParameter("no_of_rec")==null?"":req.getParameter("no_of_rec"));
			outrec = noofrec+1;
			temp_outrec=outrec+"";
			finalvalues =  new String[outrec][noofvals];
			String flag="";	
			System.out.println("inReplace = > "+inReplace+" inError = > "+inError);
			isPatientEncMovement = req.getParameter("isPatientEncMovement")==null?"":req.getParameter("isPatientEncMovement");//IN034536 
			p_queue_date = req.getParameter("p_queue_date")==null?"":req.getParameter("p_queue_date");//IN034536
			Sydate = req.getParameter("Sydate")==null?"":req.getParameter("Sydate");//IN034536

			if(inReplace.equals("Y"))
			{	
				for(rowcount=1; rowcount<=noofrec;rowcount++)
				{
					/* added by Dinesh on 22/07/2010  Starts */
					discrmsrid = "";                      
					discrmsrresultnum = "";               
					discrmsrresultnumuom = "";            
					discrmsrresultstr = "";               
					discrmsrresultdata = "";              
					normallow = "";                       
					normalhigh = "";                      
					criticallow = "";                     
					criticalhigh = "";                    
					discrmsrresulttype = "";              
					normabnormind = "";                   
					inError="";                           
					inReplace="";                         
					errorRemarks="";                      
					/* added by Dinesh on 22/07/2010  ends */

					flag=req.getParameter("flag"+String.valueOf(rowcount-1))==null?"":req.getParameter("flag"+String.valueOf(rowcount-1));

					if(flag.equals("Y"))
					{
						int colcount = 0;
						
						errorRemarks=req.getParameter("remarks"+String.valueOf(rowcount-1))==null?"":req.getParameter("remarks"+String.valueOf(rowcount-1));  
						discrmsrid = req.getParameter("item_id_"+String.valueOf(rowcount))==null?"":req.getParameter("item_id_"+String.valueOf(rowcount));  
						discrmsrresulttype = req.getParameter("result_type_"+String.valueOf(rowcount))==null?"":req.getParameter("result_type_"+String.valueOf(rowcount));

						if(discrmsrresulttype.equals("N") || discrmsrresulttype.equals("I"))
						{
							discrmsrresultnum = req.getParameter("str_id1_"+String.valueOf(rowcount))==null?"":req.getParameter("str_id1_"+String.valueOf(rowcount));
							discrmsrresultnumuom = req.getParameter("uom_id_"+String.valueOf(rowcount))==null?"":req.getParameter("uom_id_"+String.valueOf(rowcount)); 
							normallow = req.getParameter("normal_low_"+String.valueOf(rowcount))==null?"":req.getParameter("normal_low_"+String.valueOf(rowcount));                        
							normalhigh = req.getParameter("normal_high_"+String.valueOf(rowcount))==null?"":req.getParameter("normal_high_"+String.valueOf(rowcount));                      
							criticallow = req.getParameter("num_crit_low_"+String.valueOf(rowcount))==null?"":req.getParameter("num_crit_low_"+String.valueOf(rowcount));                        
							criticalhigh = req.getParameter("num_crit_high_"+String.valueOf(rowcount))==null?"":req.getParameter("num_crit_high_"+String.valueOf(rowcount));                       
					
							if(normallow.equals("")) normallow = "";
							if(normalhigh.equals("")) normalhigh = "";
							if(criticallow.equals("")) criticallow = "";
							if(criticalhigh.equals("")) criticalhigh = "";
						}
						else if(discrmsrresulttype.equals("L") || discrmsrresulttype.equals("C"))
						{
							discrmsrresultstr = req.getParameter("str_id1_"+String.valueOf(rowcount))==null?"":req.getParameter("str_id1_"+String.valueOf(rowcount));           
							discrmsrresultnum = "";
							discrmsrresultnumuom = "";
						}
						else if(discrmsrresulttype.equals("F"))
						{
							discrmsrresultdata = req.getParameter("str_id1_"+String.valueOf(rowcount))==null?"":req.getParameter("str_id1_"+String.valueOf(rowcount));        
							discrmsrresultnum = "";
							discrmsrresultnumuom = "";
						}
						else
						{
							discrmsrresultstr = req.getParameter("str_id1_"+String.valueOf(rowcount))==null?"":req.getParameter("str_id1_"+String.valueOf(rowcount));           
							discrmsrresultnum = "";
							discrmsrresultnumuom = "";
						}
					
						accessionnum= req.getParameter("accession_num_"+String.valueOf(rowcount))==null?"":req.getParameter("accession_num_"+String.valueOf(rowcount));                        
						defdata = req.getParameter("def_data_"+String.valueOf(rowcount))==null?"":req.getParameter("def_data_"+String.valueOf(rowcount));                        
						normabnormind = "";

						if(discrmsrresulttype.equals("N") || discrmsrresulttype.equals("I"))
						{
							discrmsrresultstr = "";
						
							/*if(!discrmsrresultnum.equals(""))	
							{
								double n = Double.parseDouble(discrmsrresultnum);
								
								if(!(normallow.equals("") && criticallow.equals("")))
								{
									double l = Double.parseDouble(normallow);
									double c = Double.parseDouble(criticallow);

									if(l!=0.0 && n<l) 	normabnormind = lowInd;
									if(c!=0.0 && n< c) normabnormind = critLowInd;
								}
								
								if(!(normalhigh.equals("") && criticalhigh.equals("")))
								{
									double h = Double.parseDouble(normalhigh);
									double c = Double.parseDouble(criticalhigh);

									if(h!=0.0 && n > h) normabnormind = highInd;
									if(c!=0.0 && n>c) normabnormind = critHighInd;
								}
							}
						}*/
						if(!discrmsrresultnum.equals(""))	
						{	
							if((!normallow.equals("") && Float.parseFloat(normallow) != 0) && (!normalhigh.equals("") && Float.parseFloat(normalhigh) != 0) && (!criticallow.equals("") && Float.parseFloat(criticallow) != 0) &&  (!criticalhigh.equals("") && Float.parseFloat(criticalhigh) != 0))
							{
								if(Float.parseFloat(discrmsrresultnum) >= Float.parseFloat(criticallow) && Float.parseFloat(discrmsrresultnum) < Float.parseFloat(normallow))
								{
									normabnormind = lowInd;
								}
								else if(Float.parseFloat(discrmsrresultnum) > Float.parseFloat(criticalhigh))
								{
									normabnormind = critHighInd;
								}
								else if(Float.parseFloat(discrmsrresultnum) < Float.parseFloat(criticallow))
								{
									normabnormind = critLowInd;
								}
								else if(Float.parseFloat(discrmsrresultnum) > Float.parseFloat(normalhigh) && Float.parseFloat(discrmsrresultnum) <= Float.parseFloat(criticalhigh))
								{
									normabnormind = highInd;
								}
							}
							else
							{
								if(!normallow.equals("") && Float.parseFloat(normallow) != 0)
								{	
									if(!criticallow.equals("") && Float.parseFloat(criticallow) != 0)
									{
										if(Float.parseFloat(discrmsrresultnum) < Float.parseFloat(criticallow)) 								normabnormind = critLowInd;
										else if((Float.parseFloat(discrmsrresultnum) >= Float.parseFloat(criticallow))&&(Float.parseFloat(discrmsrresultnum) < Float.parseFloat(normallow)))
											normabnormind = lowInd;
									}
									else if(Float.parseFloat(discrmsrresultnum) < Float.parseFloat(normallow)) normabnormind = lowInd;
								}

								if(!normalhigh.equals("") && Float.parseFloat(normalhigh) != 0)
								{	
									if(!criticalhigh.equals("") && Float.parseFloat(criticalhigh) != 0)
									{
										if(Float.parseFloat(discrmsrresultnum) > Float.parseFloat(criticalhigh)) 
											normabnormind = critHighInd;
										else if((Float.parseFloat(discrmsrresultnum) <= Float.parseFloat(criticalhigh))&&(Float.parseFloat(discrmsrresultnum) > Float.parseFloat(normalhigh)))
											normabnormind = highInd;	
									}
									else if(Float.parseFloat(discrmsrresultnum) > Float.parseFloat(normalhigh)) normabnormind = highInd;					
								}
							}												
						}
						}
						
						discrmsrresultdata+=defdata;

						if(discrmsrresulttype.equals("L") && !discrmsrresultstr.equals(""))
								normabnormind = req.getParameter("norm_abnorm_ind_"+String.valueOf(rowcount))==null?"":req.getParameter("norm_abnorm_ind_"+String.valueOf(rowcount)); 
						
						if(discrmsrresulttype.equals("C"))
							if(discrmsrresultstr.equals("")) discrmsrresultstr = "N";
							
						finalvalues[rowcount][colcount++] = accessionnum;                 
						finalvalues[rowcount][colcount++] = discrmsrid;   
						finalvalues[rowcount][colcount++] = discrmsrresulttype;
						finalvalues[rowcount][colcount++] = discrmsrresultnum;         
						finalvalues[rowcount][colcount++] = discrmsrresultnumuom; 
						finalvalues[rowcount][colcount++] = discrmsrresultstr;           
						finalvalues[rowcount][colcount++] = discrmsrresultdata;        
						finalvalues[rowcount][colcount++] = normallow;                        
						finalvalues[rowcount][colcount++] = normalhigh;                      
						finalvalues[rowcount][colcount++] = criticallow;                        
						finalvalues[rowcount][colcount++] = criticalhigh;                       
						finalvalues[rowcount][colcount++] = normabnormind;
						finalvalues[rowcount][colcount++] = "U";
						finalvalues[rowcount][colcount++] = errorRemarks;
					} 
			} // end for
		}
		else if(inError.equals("Y"))
		{
				rowcount=1;
		
				for(int i=0;i<noofrec;i++)	
				{
						
						/* added by Dinesh on 22/07/2010  Starts */
					discrmsrid = "";                      
					discrmsrresultnum = "";               
					discrmsrresultnumuom = "";            
					discrmsrresultstr = "";               
					discrmsrresultdata = "";              
					normallow = "";                       
					normalhigh = "";                      
					criticallow = "";                     
					criticalhigh = "";                    
					discrmsrresulttype = "";              
					normabnormind = "";                   
					inError="";                           
					inReplace="";                         
					errorRemarks="";                      
					/* added by Dinesh on 22/07/2010  ends */
						flag=req.getParameter("flag"+String.valueOf(i));
						
						if(flag.equals("Y"))	
						{
								//this.out = res.getWriter(); --- since out is a parameter
								int colcount = 0;
								errorRemarks=req.getParameter("remarks"+String.valueOf(i))==null?"":req.getParameter("remarks"+String.valueOf(i));  
								discrmsrid = req.getParameter("item_id_"+String.valueOf(i+1));											
								accessionnum= req.getParameter("accession_num_"+String.valueOf(i+1))==null?"":req.getParameter("accession_num_"+String.valueOf(i+1));                 
								finalvalues[rowcount][colcount++] = accessionnum;                 
								finalvalues[rowcount][colcount++] = discrmsrid;   
								finalvalues[rowcount][colcount++] = discrmsrresulttype;
								finalvalues[rowcount][colcount++] = discrmsrresultnum;         
								finalvalues[rowcount][colcount++] = discrmsrresultnumuom; 
								finalvalues[rowcount][colcount++] = discrmsrresultstr;           
								finalvalues[rowcount][colcount++] = discrmsrresultdata;        
								finalvalues[rowcount][colcount++] = normallow;                        
								finalvalues[rowcount][colcount++] = normalhigh;                      
								finalvalues[rowcount][colcount++] = criticallow;                        
								finalvalues[rowcount][colcount++] = criticalhigh;                       
								finalvalues[rowcount][colcount++] = normabnormind;
								finalvalues[rowcount][colcount++] = "U";
								finalvalues[rowcount][colcount++] = errorRemarks;
								rowcount++;
						}
				}
		
				outrec	=	rowcount;
					temp_outrec=outrec+"";
		}
		else
		{	
			for(rowcount=1; rowcount<=noofrec;rowcount++)
			{
				/* added by Dinesh on 22/07/2010  Starts */
					discrmsrid = "";                      
					discrmsrresultnum = "";               
					discrmsrresultnumuom = "";            
					discrmsrresultstr = "";               
					discrmsrresultdata = "";              
					normallow = "";                       
					normalhigh = "";                      
					criticallow = "";                     
					criticalhigh = "";                    
					discrmsrresulttype = "";              
					normabnormind = "";                   
					inError="";                           
					inReplace="";                         
					errorRemarks="";                      
					/* added by Dinesh on 22/07/2010  ends */
				int colcount = 0;
				errorRemarks=req.getParameter("remarks"+String.valueOf(rowcount-1))==null?"":req.getParameter("remarks"+String.valueOf(rowcount-1));  
				discrmsrid = req.getParameter("item_id_"+String.valueOf(rowcount));
				discrmsrresulttype = req.getParameter("result_type_"+String.valueOf(rowcount))==null?"":req.getParameter("result_type_"+String.valueOf(rowcount));

				if(discrmsrresulttype.equals("N") || discrmsrresulttype.equals("I"))
				{
						discrmsrresultnum = req.getParameter("str_id_"+String.valueOf(rowcount))==null?"":req.getParameter("str_id_"+String.valueOf(rowcount));
						discrmsrresultnumuom = req.getParameter("uom_id_"+String.valueOf(rowcount))==null?"":req.getParameter("uom_id_"+String.valueOf(rowcount)); 
						normallow = req.getParameter("normal_low_"+String.valueOf(rowcount))==null?"":req.getParameter("normal_low_"+String.valueOf(rowcount));                        
						normalhigh = req.getParameter("normal_high_"+String.valueOf(rowcount))==null?"":req.getParameter("normal_high_"+String.valueOf(rowcount));                      
						criticallow = req.getParameter("num_crit_low_"+String.valueOf(rowcount))==null?"":req.getParameter("num_crit_low_"+String.valueOf(rowcount));                        
						criticalhigh = req.getParameter("num_crit_high_"+String.valueOf(rowcount))==null?"":req.getParameter("num_crit_high_"+String.valueOf(rowcount));                       
						if(normallow.equals("")) normallow = "";
						if(normalhigh.equals("")) normalhigh = "";
						if(criticallow.equals("")) criticallow = "";
						if(criticalhigh.equals("")) criticalhigh = "";
						discrmsrresultdata = "";
				}
				else if(discrmsrresulttype.equals("L") || discrmsrresulttype.equals("C"))
				{
						discrmsrresultstr = req.getParameter("str_id_"+String.valueOf(rowcount))==null?"":req.getParameter("str_id_"+String.valueOf(rowcount));           
						discrmsrresultnum = "";
						discrmsrresultnumuom = "";
						discrmsrresultdata = "";
				}
				else if(discrmsrresulttype.equals("F"))
				{
						discrmsrresultdata = req.getParameter("str_id_"+String.valueOf(rowcount))==null?"":req.getParameter("str_id_"+String.valueOf(rowcount));        
						discrmsrresultnum = "";
						discrmsrresultnumuom = "";
				}
				else
				{
						discrmsrresultstr = req.getParameter("str_id_"+String.valueOf(rowcount))==null?"":req.getParameter("str_id_"+String.valueOf(rowcount));           
						discrmsrresultnum = "";
						discrmsrresultnumuom = "";
						discrmsrresultdata = "";
				}
						
				accessionnum= req.getParameter("accession_num_"+String.valueOf(rowcount))==null?"":req.getParameter("accession_num_"+String.valueOf(rowcount));                        
				defdata = req.getParameter("def_data_"+String.valueOf(rowcount))==null?"":req.getParameter("def_data_"+String.valueOf(rowcount));
				normabnormind = "";

				if(discrmsrresulttype.equals("N") || discrmsrresulttype.equals("I"))
				{
					discrmsrresultstr = "";
					/*if(!discrmsrresultnum.equals(""))	{
						double n = Double.parseDouble(discrmsrresultnum);
						if(!(normallow.equals("") && criticallow.equals(""))){
							double l = Double.parseDouble(normallow);
							double c = Double.parseDouble(criticallow);

							if(l!=0.0 && n<l) 	normabnormind =lowInd;
							if(c!=0.0 && n< c) normabnormind = critLowInd;
						}
						if(!(normalhigh.equals("") && criticalhigh.equals(""))){
							double h = Double.parseDouble(normalhigh);
							double c = Double.parseDouble(criticalhigh);

							if(h!=0.0 && n > h) normabnormind = highInd;
							if(c!=0.0 && n>c) normabnormind = critHighInd;
						}
					}*/
					if(!discrmsrresultnum.equals(""))	
					{	
						if((!normallow.equals("") && Float.parseFloat(normallow) != 0) && (!normalhigh.equals("") && Float.parseFloat(normalhigh) != 0) && (!criticallow.equals("") && Float.parseFloat(criticallow) != 0) &&  (!criticalhigh.equals("") && Float.parseFloat(criticalhigh) != 0))
						{
							if(Float.parseFloat(discrmsrresultnum) >= Float.parseFloat(criticallow) && Float.parseFloat(discrmsrresultnum) < Float.parseFloat(normallow))
							{
								normabnormind = lowInd;
							}
							else if(Float.parseFloat(discrmsrresultnum) > Float.parseFloat(criticalhigh))
							{
								normabnormind = critHighInd;
							}
							else if(Float.parseFloat(discrmsrresultnum) < Float.parseFloat(criticallow))
							{
								normabnormind = critLowInd;
							}
							else if(Float.parseFloat(discrmsrresultnum) > Float.parseFloat(normalhigh) && Float.parseFloat(discrmsrresultnum) <= Float.parseFloat(criticalhigh))
							{
								normabnormind = highInd;
							}
						}
						else
						{
							if(!normallow.equals("") && Float.parseFloat(normallow) != 0)
							{	
								if(!criticallow.equals("") && Float.parseFloat(criticallow) != 0)
								{
									if(Float.parseFloat(discrmsrresultnum) < Float.parseFloat(criticallow)) 								normabnormind = critLowInd;
									else if((Float.parseFloat(discrmsrresultnum) >= Float.parseFloat(criticallow))&&(Float.parseFloat(discrmsrresultnum) < Float.parseFloat(normallow)))
										normabnormind = lowInd;
								}
								else if(Float.parseFloat(discrmsrresultnum) < Float.parseFloat(normallow)) normabnormind = lowInd;
							}

							if(!normalhigh.equals("") && Float.parseFloat(normalhigh) != 0)
							{	
								if(!criticalhigh.equals("") && Float.parseFloat(criticalhigh) != 0)
								{
									if(Float.parseFloat(discrmsrresultnum) > Float.parseFloat(criticalhigh)) 
										normabnormind = critHighInd;
									else if((Float.parseFloat(discrmsrresultnum) <= Float.parseFloat(criticalhigh))&&(Float.parseFloat(discrmsrresultnum) > Float.parseFloat(normalhigh)))
										normabnormind = highInd;	
								}
								else if(Float.parseFloat(discrmsrresultnum) > Float.parseFloat(normalhigh)) normabnormind = highInd;
							}
						}												
					}
				}
				discrmsrresultdata += defdata;
				if(discrmsrresulttype.equals("L") && !discrmsrresultstr.equals(""))
						normabnormind = req.getParameter("norm_abnorm_ind_"+String.valueOf(rowcount))==null?"":req.getParameter("norm_abnorm_ind_"+String.valueOf(rowcount)); 
				if(discrmsrresulttype.equals("C"))
					if(discrmsrresultstr.equals("")) discrmsrresultstr = "N";

				String operation = req.getParameter("op_type_"+String.valueOf(rowcount));

				finalvalues[rowcount][colcount++] = accessionnum;                 
				finalvalues[rowcount][colcount++] = discrmsrid;   
				finalvalues[rowcount][colcount++] = discrmsrresulttype;
				finalvalues[rowcount][colcount++] = discrmsrresultnum;         
				finalvalues[rowcount][colcount++] = discrmsrresultnumuom; 
				finalvalues[rowcount][colcount++] = discrmsrresultstr;           
				finalvalues[rowcount][colcount++] = discrmsrresultdata;        
				finalvalues[rowcount][colcount++] = normallow;                        
				finalvalues[rowcount][colcount++] = normalhigh;                      
				finalvalues[rowcount][colcount++] = criticallow;                        
				finalvalues[rowcount][colcount++] = criticalhigh;                       
				finalvalues[rowcount][colcount++] = normabnormind;
				finalvalues[rowcount][colcount++] = operation;
				finalvalues[rowcount][colcount++] = errorRemarks;
			} 
		}	

		boolean local_ejbs = false;
	
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/DisDataCharting",DisDataChartingHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		//Object argArray[] = new Object[19];//IN034536
		Object argArray[] = new Object[22];//IN034536

		argArray[0] = p;
		argArray[1] = operatingfacilityid;
		argArray[2] = episodetype;
		argArray[3] = episodeid;
		argArray[4] = visitid;
		argArray[5] = clinicianid;
		argArray[6] = locncode;
		argArray[7] = patientid;
		argArray[8] = batteryid;
		argArray[9] = Sdate;
		argArray[10] = finalvalues;
		argArray[11] = admdttime;
		argArray[12] = temp_outrec;
		argArray[13] = temp_noofvals;
		argArray[14] = client_ip_address;
		argArray[15] = location_type;
		argArray[16] = module_id;
		argArray[17] = inError;
		argArray[18] = inReplace;
		argArray[19] = isPatientEncMovement;//IN034536
		argArray[20] = p_queue_date;//IN034536
		argArray[21] = Sydate;//IN034536
		
		
		
		//Class [] paramArray = new Class[19];//IN034536
		Class [] paramArray = new Class[22];//IN034536

		paramArray[0] = p.getClass();
		paramArray[1] = operatingfacilityid.getClass();
		paramArray[2] = episodetype.getClass();
		paramArray[3] = episodeid.getClass();
		paramArray[4] = visitid.getClass();
		paramArray[5] = clinicianid.getClass();
		paramArray[6] = locncode.getClass();
		paramArray[7] = patientid.getClass();
		paramArray[8] = batteryid.getClass();
		paramArray[9] = Sdate.getClass();
		paramArray[10] = finalvalues.getClass();
		paramArray[11] = admdttime.getClass();
		paramArray[12] = temp_outrec.getClass();
		paramArray[13] = temp_noofvals.getClass();
		paramArray[14] = client_ip_address.getClass();
		paramArray[15] = location_type.getClass();
		paramArray[16] = module_id.getClass();
		paramArray[17] = inError.getClass();
		paramArray[18] = inReplace.getClass();
		paramArray[19] = isPatientEncMovement.getClass();//IN034536
		paramArray[20] = p_queue_date.getClass();//IN034536
		paramArray[21] = Sydate.getClass();//IN034536

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("operateDisDataCharting",paramArray)).invoke(busObj,argArray);
		
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		 boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		 String error = (String) results.get("error") ;
//		 out.println(error);
//		 out.println(results);
		 results.clear();

		if(inserted)	
		{
			if(!module_id.equals(""))
			{
				out.println("<script>alert('"+error+"');</script>");
				out.println("<script>parent.parent.document.getElementById('dialog_tag').close();</script>");
			}
			else
			{
				out.println(outPut1+"<script>alert(' Completed ' );</script>"+outPut2);
			}
		}
		else
		{
				out.println(outPut1+"<script>alert('"+error+"');</script>"+outPut3);
		}

	}catch ( Exception e ) {
           // out.println("in insert "+e.getMessage());//common-icn-0181
            
            e.printStackTrace();
   }
}
} 
