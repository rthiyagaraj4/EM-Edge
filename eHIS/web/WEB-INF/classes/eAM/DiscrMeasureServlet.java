/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eAM.DiscrMeasure.*;


public class DiscrMeasureServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;

	String discrmsrid = "";
	String longdesc  = ""  ;
	String shortdesc   = "";
	String servicecode  = "";
	String resulttype  = "";
	int numdigitsmax = 0 ;
	int numdigitsmin = 0 ;
	int numdigitsdec = 0 ;
	String refrangetype  = "";
	String resulttemplateid    = ""  ;
	String effstatus   = "";
	double numreflow = 0;
	double numrefhigh = 0;
	double numcritlow = 0;
	double numcrithigh = 0;
	double numdfltresult = 0;
	String numuom  = "";
	String numericdetailsvalues = "";
	String alphainfovalues   = "";
//	String max ="";

	String facilityId;
	String client_ip_address;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		HttpSession session = req.getSession(false);		
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");

		try
		{
			res.setContentType("text/html");
			this.out = res.getWriter();
			String operation = req.getParameter("mode");
            out.println(operation);
			if(operation.equals("insert")) 	insertDiscrMeasure(req, res);
			else if(operation.equals("modify")) modifyDiscrMeasure(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}


	private void modifyDiscrMeasure(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			//discrmsrid = req.getParameter("discr_measure_id")==null?"":req.getParameter("discr_measure_id");
			//longdesc   = req.getParameter("long_desc")==null?"":req.getParameter("long_desc");
		//	shortdesc  = req.getParameter("short_desc")==null?"":req.getParameter("short_desc");
			//servicecode = req.getParameter("service")==null?"":req.getParameter("service");
			//resulttype = req.getParameter("result_type")==null?"":req.getParameter("result_type");
			String max = req.getParameter("max")==null?"":req.getParameter("max");
			if(!max.equals("")) numdigitsmax = Integer.parseInt(max);
			else numdigitsmax = 0;




			String min = req.getParameter("min")==null?"":req.getParameter("min");
			if(!min.equals("")) numdigitsmin = Integer.parseInt(min);
			else numdigitsmin =0;
			String dec = req.getParameter("decimal")==null?"":req.getParameter("decimal");
			if(!dec.equals("")) numdigitsdec = Integer.parseInt(dec);
			else numdigitsdec = 0;
			refrangetype = req.getParameter("ref_ranges")==null?"":req.getParameter("ref_ranges");
			resulttemplateid     = req.getParameter("free_text_template")==null?"":req.getParameter("free_text_template");
			effstatus  = req.getParameter("eff_status")==null?"D":req.getParameter("eff_status");
			String rl    = req.getParameter("ref_low")==null?"":req.getParameter("ref_low");
			if(!rl.equals("")) numreflow = Double.parseDouble(rl);
			else numreflow = 0;
			String rh   = req.getParameter("ref_high")==null?"":req.getParameter("ref_high");
			if(!rh.equals("")) numrefhigh = Double.parseDouble(rh);			
			else numrefhigh = 0;
			String cl   = req.getParameter("critical_low")==null?"":req.getParameter("critical_low");
			if(!cl.equals("")) numcritlow = Double.parseDouble(cl);		
			else numcritlow = 0;
			String ch  = req.getParameter("critical_high")==null?"":req.getParameter("critical_high");
			if(!ch.equals("")) numcrithigh = Double.parseDouble(ch);		
			else numcrithigh = 0;
			String def = req.getParameter("default_val")==null?"":req.getParameter("default_val");
			if(!def.equals("")) numdfltresult = Double.parseDouble(def);			
			else numdfltresult = 0;
			numuom = req.getParameter("unit_of_measure")==null?"":req.getParameter("unit_of_measure");
			numericdetailsvalues = req.getParameter("numeric_details_values")==null?"":req.getParameter("numeric_details_values");
			alphainfovalues  = req.getParameter("alpha_info_values")==null?"":req.getParameter("alpha_info_values");
			
			/*InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/DiscrMeasure");
			final DiscrMeasureHome discrMeasureHome  = (DiscrMeasureHome) PortableRemoteObject.narrow(homeObject ,DiscrMeasureHome.class);
			final DiscrMeasureRemote discrMeasureRemote = discrMeasureHome.create();
			out.println("modifyDiscrMeasure");
			final java.util.HashMap results = discrMeasureRemote.modifyDiscrMeasure
				(
					p,
					discrmsrid ,                 		
					longdesc    ,                 
					shortdesc   ,                
					servicecode ,              
					resulttype  ,                
					numdigitsmax ,          
					numdigitsmin ,           
					numdigitsdec ,           
					refrangetype ,            
					resulttemplateid      , 
					effstatus   ,                       		
					numreflow     ,                  
					numrefhigh    ,                 
					numcritlow    ,                  
					numcrithigh   ,                 
					numdfltresult ,                 
					numuom,                          
					numericdetailsvalues,   
					alphainfovalues   ,          
					facilityId,
					client_ip_address
				);*/



					boolean local_ejbs = false;
		
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/DiscrMeasure",DiscrMeasureHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					
					HashMap hashmap = new HashMap();
					hashmap.put("p",p);
					hashmap.put("discrmsrid",req.getParameter("discr_measure_id")==null?"":req.getParameter("discr_measure_id"));
					hashmap.put("longdesc", req.getParameter("long_desc")==null?"":req.getParameter("long_desc"));
					hashmap.put("shortdesc",req.getParameter("short_desc")==null?"":req.getParameter("short_desc"));
					hashmap.put("servicecode", req.getParameter("service")==null?"":req.getParameter("service"));
					hashmap.put("resulttype", req.getParameter("result_type")==null?"":req.getParameter("result_type"));
					hashmap.put("numdigitsmax",new Integer(numdigitsmax));
					hashmap.put("numdigitsmin",new Integer(numdigitsmin));
					hashmap.put("numdigitsdec",new Integer(numdigitsdec));
					hashmap.put("refrangetype",refrangetype);
						hashmap.put("resulttemplateid",resulttemplateid);
						hashmap.put("effstatus",effstatus);
						hashmap.put("numreflow",new Double(numreflow));
						hashmap.put("numrefhigh",new Double(numrefhigh));
						hashmap.put("numcritlow", new Double(numcritlow));
						hashmap.put("numcrithigh",new Double(numcrithigh));
						hashmap.put("numdfltresult",new Double(numdfltresult));
						hashmap.put("numuom",numuom);
						hashmap.put("numericdetailsvalues",numericdetailsvalues);
						hashmap.put("alphainfovalues",alphainfovalues);
						hashmap.put("facilityId",facilityId);
						hashmap.put("addedAtWorkstation",client_ip_address);
					
					Object argArray[] = new Object[1];
					argArray[0]=hashmap;
					
												
					Class [] paramArray = new Class[1];
					paramArray[0] = hashmap.getClass();
							


			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("modifyDiscrMeasure",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			out.println(error);
			hashmap.clear();
			results.clear();
			if (inserted)
			{
			     error_value = "1" ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8" ) + "&err_value=" + error_value);
			}
			else
			{
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode(error,"UTF-8" ));
			}
		}
		catch ( Exception e )
		{
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}
	}

	private void insertDiscrMeasure(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			discrmsrid = req.getParameter("discr_measure_id")==null?"":req.getParameter("discr_measure_id");
			longdesc   = req.getParameter("long_desc")==null?"":req.getParameter("long_desc");
			shortdesc  = req.getParameter("short_desc")==null?"":req.getParameter("short_desc");
			servicecode = req.getParameter("service")==null?"":req.getParameter("service");
			resulttype = req.getParameter("result_type")==null?"":req.getParameter("result_type");
			String max = req.getParameter("max")==null?"":req.getParameter("max");
			if(!max.equals("")) numdigitsmax = Integer.parseInt(max);
			else numdigitsmax = 0;
			String min = req.getParameter("min")==null?"":req.getParameter("min");
			if(!min.equals("")) numdigitsmin = Integer.parseInt(min);
			else numdigitsmin =0;
			String dec = req.getParameter("decimal")==null?"":req.getParameter("decimal");
			if(!dec.equals("")) numdigitsdec = Integer.parseInt(dec);
			else numdigitsdec = 0;
			refrangetype = req.getParameter("ref_ranges")==null?"":req.getParameter("ref_ranges");
			resulttemplateid     = req.getParameter("free_text_template")==null?"":req.getParameter("free_text_template");
			effstatus  = req.getParameter("eff_status")==null?"D":req.getParameter("eff_status");
			String rl    = req.getParameter("ref_low")==null?"":req.getParameter("ref_low");
			if(!rl.equals("")) numreflow = Double.parseDouble(rl);
			else numreflow = 0;
			String rh   = req.getParameter("ref_high")==null?"":req.getParameter("ref_high");
			if(!rh.equals("")) numrefhigh = Double.parseDouble(rh);			
			else numrefhigh = 0;
			String cl   = req.getParameter("critical_low")==null?"":req.getParameter("critical_low");

			if(!cl.equals("")) 
				numcritlow = Double.parseDouble(cl);		
			else 
				numcritlow = 0;
			String ch  = req.getParameter("critical_high")==null?"":req.getParameter("critical_high");
			if(!ch.equals("")) numcrithigh = Double.parseDouble(ch);		
			else numcrithigh = 0;
			String def = req.getParameter("default_val")==null?"":req.getParameter("default_val");
			if(!def.equals("")) numdfltresult = Double.parseDouble(def);			
			else numdfltresult = 0;
			numuom = req.getParameter("unit_of_measure")==null?"":req.getParameter("unit_of_measure");
			numericdetailsvalues = req.getParameter("numeric_details_values")==null?"":req.getParameter("numeric_details_values");
			alphainfovalues  = req.getParameter("alpha_info_values")==null?"":req.getParameter("alpha_info_values");
			
			/*InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/DiscrMeasure");
			final DiscrMeasureHome discrMeasureHome  = (DiscrMeasureHome) PortableRemoteObject.narrow(homeObject ,DiscrMeasureHome.class);
			final DiscrMeasureRemote discrMeasureRemote = discrMeasureHome.create();
			out.println("insertDiscrMeasure");
			final java.util.HashMap results = discrMeasureRemote.insertDiscrMeasure
				(
					p,
					discrmsrid ,                 		
					longdesc    ,                 
					shortdesc   ,                
					servicecode ,              
					resulttype  ,                
					numdigitsmax ,          
					numdigitsmin ,           
					numdigitsdec ,           
					refrangetype ,            
					resulttemplateid      , 
					effstatus   ,                       		
					numreflow     ,                  
					numrefhigh    ,                 
					numcritlow    ,                  
					numcrithigh   ,                 
					numdfltresult ,                 
					numuom,                          
					numericdetailsvalues,   
					alphainfovalues   ,          
					facilityId,
					client_ip_address
				);*/


			boolean local_ejbs = false;
		
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/DiscrMeasure",DiscrMeasureHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					
					HashMap hashmap = new HashMap();
					hashmap.put("p",p);
					hashmap.put("discrmsrid",discrmsrid);
					hashmap.put("longdesc",longdesc);
					hashmap.put("shortdesc",shortdesc);
					hashmap.put("servicecode",servicecode);
					hashmap.put("resulttype",resulttype );
					hashmap.put("numdigitsmax",new Integer(numdigitsmax));
					hashmap.put("numdigitsmin",new Integer(numdigitsmin));
					hashmap.put("numdigitsdec",new Integer(numdigitsdec));
					hashmap.put("refrangetype",refrangetype);
						hashmap.put("resulttemplateid",resulttemplateid);
						hashmap.put("effstatus",effstatus);
						hashmap.put("numreflow",new Double(numreflow));
						hashmap.put("numrefhigh",new Double(numrefhigh));
						hashmap.put("numcritlow",new Double(numcritlow));
						hashmap.put("numcrithigh",new Double(numcrithigh));
						hashmap.put("numdfltresult",new Double(numdfltresult));
						hashmap.put("numuom",numuom);
						hashmap.put("numericdetailsvalues",numericdetailsvalues);
						hashmap.put("alphainfovalues",alphainfovalues);
						hashmap.put("addedFacilityId",facilityId);
						hashmap.put("addedAtWorkstation",client_ip_address);
						
	

					Object argArray[] = new Object[1];
					argArray[0]=hashmap;
						
							Class [] paramArray = new Class[1];
							paramArray[0] = hashmap.getClass();
							


		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertDiscrMeasure",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
		out.println(error);
		    hashmap.clear();
			results.clear();
			if ( inserted )
			{
			     error_value = "1" ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error ,"UTF-8" ) );
			}
		}
		catch ( Exception e )
		{
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}
	}
}
