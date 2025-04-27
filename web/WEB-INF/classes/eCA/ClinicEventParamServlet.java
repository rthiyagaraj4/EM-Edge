/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import eCA.ClinicEventParam.*;
import webbeans.eCommon.*;

public class ClinicEventParamServlet extends javax.servlet.http.HttpServlet	
{
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		
		try
		{
			out = res.getWriter();
			insertClinicEventParam(req, res, out);
		}
		catch(Exception e)
		{
			out.println("Exception in Main Block : "+e.toString());
			e.printStackTrace();
		}
	}

public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
{
	doPost(req,res);	
}

private void insertClinicEventParam(HttpServletRequest req, HttpServletResponse res, PrintWriter out)	
{
	java.util.Properties p;
	
	String	mode				= "";
	String	facilityId			= "" ;
	String	client_ip_address	= "";
	String  locale				= "";
	
	HttpSession session			= req.getSession(false);
	p							= (java.util.Properties) session.getValue( "jdbc" ) ;
	
	locale						= (String) p.getProperty("LOCALE");
	facilityId					= (String) session.getValue( "facility_id" ) ;
	client_ip_address			= p.getProperty("client_ip_address");
	
	try 
	{
		HashMap tabdata=new HashMap();

		String high_value		=	(req.getParameter("high_value")==null)			?	""	:	req.getParameter("high_value");
		String low_value		=	(req.getParameter("low_value")==null)			?	""	:	req.getParameter("low_value");
		String abnml_value		=	(req.getParameter("abnml_value")==null)			?	""	:	req.getParameter("abnml_value");
		String crtcl_value		=	(req.getParameter("crtcl_value")==null)			?	""	:	req.getParameter("crtcl_value");
		String crtcl_low_value	=	(req.getParameter("crtcl_low_value")==null)		?	""	:	req.getParameter("crtcl_low_value");
		String crtcl_high_value =	(req.getParameter("crtcl_high_value")==null)	?	""	:	req.getParameter("crtcl_high_value");
		String delta_value		=	(req.getParameter("delta_value")==null)	?	""	:	req.getParameter("delta_value");
		mode					=	(req.getParameter("mode")==null)				?	""	:	req.getParameter("mode");
		String high_value_desc		=	(req.getParameter("high_value_desc")==null)			?	""	:	req.getParameter("high_value_desc");
		String high_value_color		=	(req.getParameter("high_value_color")==null)			?	""	:	req.getParameter("high_value_color");
		String low_value_desc		=	(req.getParameter("low_value_desc")==null)			?	""	:	req.getParameter("low_value_desc");
		String low_value_color		=	(req.getParameter("low_value_color")==null)			?	""	:	req.getParameter("low_value_color");
		String abnml_value_desc		=	(req.getParameter("abnml_value_desc")==null)			?	""	:	req.getParameter("abnml_value_desc");
		String abnml_value_color		=	(req.getParameter("abnml_value_color")==null)			?	""	:	req.getParameter("abnml_value_color");
		String crtcl_value_desc		=	(req.getParameter("crtcl_value_desc")==null)			?	""	:	req.getParameter("crtcl_value_desc");
		String crtcl_value_color		=	(req.getParameter("crtcl_value_color")==null)			?	""	:	req.getParameter("crtcl_value_color");
		String crtcl_low_value_desc		=	(req.getParameter("crtcl_low_value_desc")==null)			?	""	:	req.getParameter("crtcl_low_value_desc");
	String crtcl_low_value_color		=	(req.getParameter("crtcl_low_value_color")==null)			?	""	:	req.getParameter("crtcl_low_value_color");
	String crtcl_high_value_desc		=	(req.getParameter("crtcl_high_value_desc")==null)			?	""	:	req.getParameter("crtcl_high_value_desc");
	String crtcl_high_value_color		=	(req.getParameter("crtcl_high_value_color")==null)			?	""	:	req.getParameter("crtcl_high_value_color");


	String highvalue_symbol=(req.getParameter("high_value_symbol")==null)?"":req.getParameter("high_value_symbol");
	String lowvalue_symbol=(req.getParameter("low_value_symbol")==null)?"":req.getParameter("low_value_symbol");
	String abnormalvalue_symbol=(req.getParameter("abnormal_value_symbol")==null)?"":req.getParameter("abnormal_value_symbol");
	String criticalvalue_symbol=(req.getParameter("critical_value_symbol")==null)?"":req.getParameter("critical_value_symbol");
	String criticallow_symbol=(req.getParameter("criticallow_value_symbol")==null)?"":req.getParameter("criticallow_value_symbol");
	String criticalhigh_symbol=(req.getParameter("criticalhigh_value_symbol")==null)?"":req.getParameter("criticalhigh_value_symbol");
	String symbol_colour=(req.getParameter("symbol_colour")==null)?"":req.getParameter("symbol_colour");

	
		String Ord_phys_yn		=	"";
		String Atn_phys_yn		=	"";
		String hist_rec_type	=	"";
	
		String slTotal			=	req.getParameter("count");
		
		int ilTotal				=	Integer.parseInt(slTotal);
		int ilCheckedCount		=	0,	ilCount		=	0;
		
		String addedById				= (String) p.getProperty( "login_user" ) ;
		String modifiedById				= addedById ;
		String addedFacilityId			= facilityId;
		String modifiedFacilityId		= facilityId ;
		String addedAtWorkstation		= client_ip_address;
		String modifiedAtWorkstation	= addedAtWorkstation ;

		String errorMsg = ""; 
		String error_value = "0" ;
		boolean inserted = false;
		
		java.util.HashMap results = new HashMap();

		for(ilCount=0; ilCount<=ilTotal; ilCount++)
		{
			Ord_phys_yn			=	req.getParameter("Ord_phys_yn"+ilCount);
			Atn_phys_yn			=	req.getParameter("Atn_phys_yn"+ilCount);
			hist_rec_type		=	req.getParameter("hist_rec_type"+ilCount);
			
			if(Ord_phys_yn  != null || Atn_phys_yn != null)
			{
				tabdata.put("hist_rec_type"+ilCheckedCount, hist_rec_type);
			
				if(Ord_phys_yn  != null)
					tabdata.put("Ord_phys_yn"+ilCheckedCount, Ord_phys_yn);

				if(Atn_phys_yn != null)
					tabdata.put("Atn_phys_yn"+ilCheckedCount, Atn_phys_yn);

				ilCheckedCount++;
			}
		}
	
		tabdata.put("ilCheckedCount",new Integer(ilCheckedCount));
		tabdata.put("high_value", high_value);
		tabdata.put("low_value", low_value);
		tabdata.put("abnml_value", abnml_value);
		tabdata.put("crtcl_value", crtcl_value);
		tabdata.put("crtcl_low_value", crtcl_low_value);
		tabdata.put("crtcl_high_value", crtcl_high_value);
		tabdata.put("delta_value", delta_value);
		tabdata.put("count", slTotal);
		tabdata.put("mode",mode);
		tabdata.put("module_id","CA");
		tabdata.put("added_by_id",addedById);
		tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("added_facility_id", addedFacilityId);
		tabdata.put("added_at_ws_no",addedAtWorkstation);
		tabdata.put("modified_by_id",modifiedById);
		tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("modified_facility_id",modifiedFacilityId);
		tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
		tabdata.put("locale",locale);
		tabdata.put("high_value_desc", high_value_desc);
		tabdata.put("high_value_color", high_value_color);
		tabdata.put("low_value_desc", low_value_desc);
		tabdata.put("low_value_color", low_value_color);
		tabdata.put("abnml_value_desc", abnml_value_desc);
		tabdata.put("abnml_value_color", abnml_value_color);
		tabdata.put("crtcl_value_desc", crtcl_value_desc);
		tabdata.put("crtcl_value_color", crtcl_value_color);
		tabdata.put("crtcl_low_value_desc", crtcl_low_value_desc);
		tabdata.put("crtcl_low_value_color", crtcl_low_value_color);
		tabdata.put("crtcl_high_value_desc", crtcl_high_value_desc);
		tabdata.put("crtcl_high_value_color", crtcl_high_value_color);

		tabdata.put("highvalue_symbol", highvalue_symbol);
		tabdata.put("lowvalue_symbol", lowvalue_symbol);
		tabdata.put("abnormalvalue_symbol", abnormalvalue_symbol);
		tabdata.put("criticalvalue_symbol", criticalvalue_symbol);	
		tabdata.put("criticallow_symbol", criticallow_symbol);
		tabdata.put("criticalhigh_symbol", criticalhigh_symbol);
		tabdata.put("symbol_colour", symbol_colour);
		
		boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ClinicEventParam",ClinicEventParamHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = tabdata;
		
		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();

		results = (java.util.HashMap)(busObj.getClass().getMethod("manageClinicEventParam",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		
		tabdata.clear();
		argArray = null;
		paramArray = null;
	
		inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		errorMsg = (String) results.get("error") ;
		results.clear();

		if ( inserted ) 
			error_value = "1" ;

		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8")+ "&err_value=" + error_value );
	} 
	catch ( Exception e ) 
	{
		//out.println("Exception in Insert Block :"+e.getMessage());//common-icn-0181
		//out.println("Exception in Insert Block :"+e.toString());//common-icn-0181
		
		e.printStackTrace();
	}
	}
}

