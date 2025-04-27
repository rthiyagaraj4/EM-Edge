/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.ehis.eslp.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import eSM.MenuRstrnForResp.*;

public class MenuRstrnForRespServlet extends javax.servlet.http.HttpServlet{
		PrintWriter out;
		Properties p;
		String facilityId ;
		String client_ip_address ;

		public void init(ServletConfig config) throws ServletException{
				super.init(config);
			}

		public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
				throws javax.servlet.ServletException,IOException
			{
			    req.setCharacterEncoding("UTF-8");
			    res.setContentType("text/html;charset=UTF-8");

				HttpSession session		= req.getSession(true);
				this.p			  		= (java.util.Properties) session.getValue( "jdbc" ) ;
				client_ip_address = p.getProperty("client_ip_address");
			try {
					this.out = res.getWriter();
					modify(req, res);
				}catch (Exception e)
					{
						out.println(e.toString());
					}
			}
		private void modify(HttpServletRequest req, HttpServletResponse res)	{
			try {


					Enumeration enum1 	=	req.getParameterNames();
					ArrayList AE=new ArrayList();		//Exclude				both
					ArrayList AA=new ArrayList();		//Access Rights	none
					ArrayList AI=new ArrayList();		//Insert		 shd be inserted for option_id='F'
					ArrayList AU=new ArrayList();		//Update	shd be inserted for option_id='F'
					ArrayList AD=new ArrayList();		//Delete	shd be inserted for option_id='F'
					ArrayList AP=new ArrayList();		//Print		shd be inserted for option_id='F'
					ArrayList AQ=new ArrayList();		//Query		shd be inserted for option_id='F'
					ArrayList AC=new ArrayList();		//Add		none
					ArrayList AO=new ArrayList();		//Option_Sequence_No	for both
					ArrayList AM=new ArrayList();		//Module_id		for both
					ArrayList AF=new ArrayList();		//Function_id	shd be inserted for option_id='F'
					ArrayList AS=new ArrayList();		//Submenu_id shd be inserted for option_id='M'
					ArrayList AN=new ArrayList();		//Menu_id shd be inserted for option_id='M'
					ArrayList SFA = new ArrayList();		//for SubFunction Values
					
					//Removing Frame
					ArrayList RE=new ArrayList();		//Exclude
					ArrayList RA=new ArrayList();		//Access Rights
					ArrayList RC=new ArrayList();		//Add
					ArrayList RO=new ArrayList();		//Option_Sequence_No
					ArrayList RM=new ArrayList();	//Module_id
					ArrayList RS=new ArrayList();		//Submenu_id  

					int ac=0;
					int rc=0;

					while (enum1.hasMoreElements())
					{
							String param_name=(String)enum1.nextElement();


							String substr_param = param_name.substring(0,2);

							String param_num = param_name.substring(2,param_name.length() );


							 if(substr_param.equals("RC") || substr_param.equals("AC") )
							 {
								if(substr_param.equals("RC"))
								{
									RC.add(req.getParameter(param_name));
									RE.add(( req.getParameter("RE"+param_num) == null ?"R":req.getParameter("RE"+param_num)));
									RA.add(req.getParameter("RA"+param_num));
									RO.add(req.getParameter("RO"+param_num));
									RM.add(( req.getParameter("RM"+param_num).equals("null") ?"":req.getParameter("RM"+param_num)));
									RS.add(( req.getParameter("RS"+param_num).equals("null") ?"":req.getParameter("RS"+param_num))); 
									rc++;
								}
								else
								{
									AC.add(req.getParameter(param_name));

									AE.add(( req.getParameter("AE"+param_num) == null ?"R":req.getParameter("AE"+param_num)));

									AA.add(req.getParameter("AA"+param_num));
									AI.add(( req.getParameter("AI"+param_num) == null ?"N":req.getParameter("AI"+param_num)));
									AU.add(( req.getParameter("AU"+param_num) == null ?"N":req.getParameter("AU"+param_num)));
									AD.add(( req.getParameter("AD"+param_num) == null ?"N":req.getParameter("AD"+param_num)));
									AP.add(( req.getParameter("AP"+param_num) == null ?"N":req.getParameter("AP"+param_num)));
									AQ.add(( req.getParameter("AQ"+param_num) == null ?"N":req.getParameter("AQ"+param_num)));
									AO.add(req.getParameter("AO"+param_num));
									AF.add(( req.getParameter("AF"+param_num) == null ?"":req.getParameter("AF"+param_num)));

									AM.add(( req.getParameter("AM"+param_num).equals("null") ?"":req.getParameter("AM"+param_num)));


									AS.add(( req.getParameter("AS"+param_num) == null ?"":req.getParameter("AS"+param_num)));
									AN.add(( req.getParameter("AN"+param_num) == null ?"":req.getParameter("AN"+param_num)));
									SFA.add(( req.getParameter("SF"+param_num) == null ?"":req.getParameter("SF"+param_num)));
									ac++;
								}
							 }
					}

				boolean local_ejbs = false;
				
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/MenuRstrnForRespManager",MenuRstrnForRespHome.class,local_ejbs);

				//Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/MenuRstrnForResp",MenuRstrnForRespHome.class,local_ejbs);



				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				
				Object argArray[] = new Object[1];
				HashMap argMap=new HashMap();
				argMap.put("p",p);
				argMap.put("RC",RC);
				argMap.put("RE",RE);
				argMap.put("RO",RO);
				argMap.put("AC",AC);
				argMap.put("AE",AE);
				argMap.put("AI",AI);
				argMap.put("AU",AU);
				argMap.put("AD",AD);
				argMap.put("AP",AP);
				argMap.put("AQ",AQ);
				argMap.put("AO",AO);
				argMap.put("AM",AM);
				argMap.put("AF",AF);
				argMap.put("AS",AS);
				argMap.put("RS",RS);
				argMap.put("RM",RM);
				argMap.put("AN",AN);
				argMap.put("SFA",SFA);
				argMap.put("resp_id",req.getParameter("resp_id"));


				argMap.put("menu_id",req.getParameter("menu_id")== null ?"":req.getParameter("menu_id"));
	
				argMap.put("submenu_id",req.getParameter("submenu_id")== null ?"":req.getParameter("submenu_id"));

				argMap.put("option_type",req.getParameter("option_type")== null ?"":req.getParameter("option_type"));
				argMap.put("facilityId",facilityId);
				argMap.put("client_ip_address",client_ip_address);
				argArray[0] = argMap;
	



				Class [] paramArray = new Class[1];

				paramArray[0] = argMap.getClass();

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				AE.clear(); AA.clear(); AI.clear(); AU.clear(); AD.clear(); AP.clear();
				AQ.clear(); AC.clear(); AO.clear(); AM.clear(); AF.clear(); AS.clear();
			    AN.clear(); SFA.clear(); RE.clear(); RA.clear(); RC.clear();RO.clear();
				RM.clear(); RS.clear();

				argMap.clear();

						boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
						String error = (String) results.get("error");
						String error_value = "0" ;
						results.clear();

						if ( inserted ) error_value = "1" ;
							res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
						//results.clear();

				} catch ( Exception e ) {

					out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
					out.println( "Values sent are : <br>" ) ;

					}
			}//E.O.Method
		}
