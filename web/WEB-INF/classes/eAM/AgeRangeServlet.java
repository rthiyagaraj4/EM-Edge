/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.SingleThreadModel;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.io.PrintWriter;
import java.io.IOException;

import java.util.Properties;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.ehis.eslp.ServiceLocator;

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import eAM.AgeRange.AgeRangeManagerHome;

/**
 * @todo Class data members should be moved to method level scope
 */
public class AgeRangeServlet extends HttpServlet	{
	PrintWriter out;
	java.util.Properties p;

	
	//String serviceURL;
	//String objectName;
	int		noOfRanges;
	int     range1Fr;
	int     range1To;
	
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
													        throws ServletException,IOException{
		HttpSession session = req.getSession(false);	
		//this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
//		this.client_ip_address = p.getProperty("client_ip_address");
		/*env		= (java.util.Hashtable) session.getValue( "env" ) ;
		serviceURL 	= (String) session.getValue( "serviceURL" ) ;
		objectName 	= "/test/AgeRangeManager" ;*/
		try {
			this.out = res.getWriter();
			String operation = req.getParameter("function");
			if ( operation.equals("insert") )
				insertAgeRange(req, res);
			if ( operation.equals("modify"))
				modifyAgeRange(req, res);
		}catch (Exception e){			
			out.println(e.toString());
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
													 	throws ServletException,IOException{
		try	{
			this.out = res.getWriter();
			res.setContentType("text/html");
			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
			//out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../../eCommon/js/common.js'><script language='javascript' src='../eAM/js/AgeRange.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0 scrolling='no' ><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script src='../../eCommon/js/common.js' language='javascript'></script><script language='javascript' src='../eAM/js/AgeRange.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0 scrolling='no'><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}catch(Exception e)	{	
		}
	}
	private void modifyAgeRange(HttpServletRequest req, HttpServletResponse res)	{
		HttpSession session = req.getSession(false);	
		try {
			String rangeType = req.getParameter("range_type");
			if(rangeType.equals("Age"))  rangeType="A";
			if(rangeType.equals("Weight"))  rangeType="W";
			if(rangeType.equals("Circumference"))  rangeType="C";
			if(rangeType.equals("Length"))  rangeType="L";
			if(rangeType.equals("Gestation"))  rangeType="G";
			if(rangeType.equals("Apgar"))  rangeType="P";
				
			String effectiveStatus = req.getParameter("eff_status");
			String no_of_ranges = req.getParameter("no_of_ranges");
			if ( !no_of_ranges.equals( "" ) )
					noOfRanges= Integer.parseInt( no_of_ranges ) ;
			if ( effectiveStatus == null )
				effectiveStatus="D";
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AgeRangeManager",AgeRangeManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[1];
			HashMap hmParams = new HashMap();
			hmParams.put("p",p);
		    hmParams.put("rangeType",((req.getParameter("range_type")!=null)?req.getParameter("range_type"):""));
		    hmParams.put("rangeId",((req.getParameter("range_id")!=null)?req.getParameter("range_id"):""));
		    hmParams.put("longDesc",((req.getParameter("long_desc")!=null)?req.getParameter("long_desc"):""));
		    hmParams.put("shortDesc",((req.getParameter("short_desc")!=null)?req.getParameter("short_desc"):""));
			hmParams.put("noOfRanges",new Integer(((req.getParameter("no_of_ranges")!=null)?req.getParameter("no_of_ranges"):"")));			
			hmParams.put("range_1_fr",((req.getParameter("range_1_fr")!=null)?req.getParameter("range_1_fr"):""));
		     hmParams.put("range1FrUnit",((req.getParameter("range_1_fr_unit")!=null)?req.getParameter("range_1_fr_unit"):""));
		    hmParams.put("range_1_to",((req.getParameter("range_1_to")!=null)?req.getParameter("range_1_to"):""));
		    hmParams.put("range1ToUnit",((req.getParameter("range_1_to_unit")!=null)?req.getParameter("range_1_to_unit"):""));
		    hmParams.put("range_2_fr",((req.getParameter("range_2_fr")!=null)?req.getParameter("range_2_fr"):""));
		    hmParams.put("range2FrUnit",((req.getParameter("range_2_fr_unit")!=null)?req.getParameter("range_2_fr_unit"):""));
		    hmParams.put("range_2_to",((req.getParameter("range_2_to")!=null)?req.getParameter("range_2_to"):""));
			hmParams.put("range2ToUnit",((req.getParameter("range_2_to_unit")!=null)?req.getParameter("range_2_to_unit"):""));
		    hmParams.put("range_3_fr",((req.getParameter("range_3_fr")!=null)?req.getParameter("range_3_fr"):""));
		    hmParams.put("range3FrUnit",((req.getParameter("range_3_fr_unit")!=null)?req.getParameter("range_3_fr_unit"):""));
		    hmParams.put("range_3_to",((req.getParameter("range_3_to")!=null)?req.getParameter("range_3_to"):""));
		    hmParams.put("range3ToUnit",((req.getParameter("range_3_to_unit")!=null)?req.getParameter("range_3_to_unit"):""));
		 	hmParams.put("range_4_fr",((req.getParameter("range_4_fr")!=null)?req.getParameter("range_4_fr"):""));
		    hmParams.put("range4FrUnit",((req.getParameter("range_4_fr_unit")!=null)?req.getParameter("range_4_fr_unit"):""));
			hmParams.put("range_4_to",((req.getParameter("range_4_to")!=null)?req.getParameter("range_4_to"):""));
			hmParams.put("range4ToUnit",((req.getParameter("range_4_to_unit")!=null)?req.getParameter("range_4_to_unit"):""));
			hmParams.put("range_5_fr",((req.getParameter("range_5_fr")!=null)?req.getParameter("range_5_fr"):""));
			hmParams.put("range5FrUnit",((req.getParameter("range_5_fr_unit")!=null)?req.getParameter("range_5_fr_unit"):""));
			hmParams.put("range_5_to",((req.getParameter("range_5_to")!=null)?req.getParameter("range_5_to"):""));
			hmParams.put("range5ToUnit",((req.getParameter("range_5_to_unit")!=null)?req.getParameter("range_5_to_unit"):""));
			hmParams.put("range_6_fr",((req.getParameter("range_6_fr")!=null)?req.getParameter("range_6_fr"):""));
			hmParams.put("range6FrUnit",((req.getParameter("range_6_fr_unit")!=null)?req.getParameter("range_6_fr_unit"):""));
			hmParams.put("range_6_to",((req.getParameter("range_6_to")!=null)?req.getParameter("range_6_to"):""));
			hmParams.put("range6ToUnit",((req.getParameter("range_6_to_unit")!=null)?req.getParameter("range_6_to_unit"):""));
			hmParams.put("range_7_fr",((req.getParameter("range_7_fr")!=null)?req.getParameter("range_7_fr"):""));
			hmParams.put("range7FrUnit",((req.getParameter("range_7_fr_unit")!=null)?req.getParameter("range_7_fr_unit"):""));
			hmParams.put("range_7_to",((req.getParameter("range_7_to")!=null)?req.getParameter("range_7_to"):""));
			hmParams.put("range7ToUnit",((req.getParameter("range_7_to_unit")!=null)?req.getParameter("range_7_to_unit"):""));
			hmParams.put("range_8_fr",((req.getParameter("range_8_fr")!=null)?req.getParameter("range_8_fr"):""));
			hmParams.put("range8FrUnit",((req.getParameter("range_8_fr_unit")!=null)?req.getParameter("range_8_fr_unit"):""));
			hmParams.put("range_8_to",((req.getParameter("range_8_to")!=null)?req.getParameter("range_8_to"):""));
			hmParams.put("range8ToUnit",((req.getParameter("range_8_to_unit")!=null)?req.getParameter("range_8_to_unit"):""));
			hmParams.put("range_9_fr",((req.getParameter("range_9_fr")!=null)?req.getParameter("range_9_fr"):""));
			hmParams.put("range9FrUnit",((req.getParameter("range_9_fr_unit")!=null)?req.getParameter("range_9_fr_unit"):""));
			hmParams.put("range_9_to",((req.getParameter("range_9_to")!=null)?req.getParameter("range_9_to"):""));
			hmParams.put("range9ToUnit",((req.getParameter("range_9_to_unit")!=null)?req.getParameter("range_9_to_unit"):""));
			hmParams.put("range_10_fr",((req.getParameter("range_10_fr")!=null)?req.getParameter("range_10_fr"):""));
			hmParams.put("range10FrUnit",((req.getParameter("range_10_fr_unit")!=null)?req.getParameter("range_10_fr_unit"):""));
			hmParams.put("range_10_to",((req.getParameter("range_10_to")!=null)?req.getParameter("range_10_to"):""));
			hmParams.put("range10ToUnit",((req.getParameter("range_10_to_unit")!=null)?req.getParameter("range_10_to_unit"):""));
			hmParams.put("range_11_fr",((req.getParameter("range_11_fr")!=null)?req.getParameter("range_11_fr"):""));
			hmParams.put("range11FrUnit",((req.getParameter("range_11_fr_unit")!=null)?req.getParameter("range_11_fr_unit"):""));
			hmParams.put("range_11_to",((req.getParameter("range_11_to")!=null)?req.getParameter("range_11_to"):""));
			hmParams.put("range11ToUnit",((req.getParameter("range_11_to_unit")!=null)?req.getParameter("range_11_to_unit"):""));
			hmParams.put("range_12_fr",((req.getParameter("range_12_fr")!=null)?req.getParameter("range_12_fr"):""));
			hmParams.put("range12FrUnit",((req.getParameter("range_12_fr_unit")!=null)?req.getParameter("range_12_fr_unit"):""));
			hmParams.put("range_12_to",((req.getParameter("range_12_to")!=null)?req.getParameter("range_12_to"):""));
			hmParams.put("range12ToUnit",((req.getParameter("range_12_to_unit")!=null)?req.getParameter("range_12_to_unit"):""));
			hmParams.put("range_13_fr",((req.getParameter("range_13_fr")!=null)?req.getParameter("range_13_fr"):""));
			hmParams.put("range13FrUnit",((req.getParameter("range_13_fr_unit")!=null)?req.getParameter("range_13_fr_unit"):""));
			hmParams.put("range_13_to",((req.getParameter("range_13_to")!=null)?req.getParameter("range_13_to"):""));
			hmParams.put("range13ToUnit",((req.getParameter("range_13_to_unit")!=null)?req.getParameter("range_13_to_unit"):""));
			hmParams.put("range_14_fr",((req.getParameter("range_14_fr")!=null)?req.getParameter("range_14_fr"):""));
			hmParams.put("range14FrUnit",((req.getParameter("range_14_fr_unit")!=null)?req.getParameter("range_14_fr_unit"):""));
			hmParams.put("range_14_to",((req.getParameter("range_14_to")!=null)?req.getParameter("range_14_to"):""));
			hmParams.put("range14ToUnit",((req.getParameter("range_14_to_unit")!=null)?req.getParameter("range_14_to_unit"):""));
			hmParams.put("range_15_fr",((req.getParameter("range_15_fr")!=null)?req.getParameter("range_15_fr"):""));
			hmParams.put("range15FrUnit",((req.getParameter("range_15_fr_unit")!=null)?req.getParameter("range_15_fr_unit"):""));
			hmParams.put("range_15_to",((req.getParameter("range_15_to")!=null)?req.getParameter("range_15_to"):""));
			hmParams.put("range15ToUnit",((req.getParameter("range_15_to_unit")!=null)?req.getParameter("range_15_to_unit"):""));
			hmParams.put("range_16_fr",((req.getParameter("range_16_fr")!=null)?req.getParameter("range_16_fr"):""));
			hmParams.put("range16FrUnit",((req.getParameter("range_16_fr_unit")!=null)?req.getParameter("range_16_fr_unit"):""));
			hmParams.put("range_16_to",((req.getParameter("range_16_to")!=null)?req.getParameter("range_16_to"):""));
			hmParams.put("range16ToUnit",((req.getParameter("range_16_to_unit")!=null)?req.getParameter("range_16_to_unit"):""));
			hmParams.put("range_17_fr",((req.getParameter("range_17_fr")!=null)?req.getParameter("range_17_fr"):""));
			hmParams.put("range17FrUnit",((req.getParameter("range_17_fr_unit")!=null)?req.getParameter("range_17_fr_unit"):""));
			hmParams.put("range_17_to",((req.getParameter("range_17_to")!=null)?req.getParameter("range_17_to"):""));
			hmParams.put("range17ToUnit",((req.getParameter("range_17_to_unit")!=null)?req.getParameter("range_17_to_unit"):""));
			hmParams.put("range_18_fr",((req.getParameter("range_18_fr")!=null)?req.getParameter("range_18_fr"):""));
			hmParams.put("range18FrUnit",((req.getParameter("range_18_fr_unit")!=null)?req.getParameter("range_18_fr_unit"):""));
			hmParams.put("range_18_to",((req.getParameter("range_18_to")!=null)?req.getParameter("range_18_to"):""));
			hmParams.put("range18ToUnit",((req.getParameter("range_18_to_unit")!=null)?req.getParameter("range_18_to_unit"):""));
			hmParams.put("range_19_fr",((req.getParameter("range_19_fr")!=null)?req.getParameter("range_19_fr"):""));
			hmParams.put("range19FrUnit",((req.getParameter("range_19_fr_unit")!=null)?req.getParameter("range_19_fr_unit"):""));
			hmParams.put("range_19_to",((req.getParameter("range_19_to")!=null)?req.getParameter("range_19_to"):""));
			hmParams.put("range19ToUnit",((req.getParameter("range_19_to_unit")!=null)?req.getParameter("range_19_to_unit"):""));
			hmParams.put("range_20_fr",((req.getParameter("range_20_fr")!=null)?req.getParameter("range_20_fr"):""));
			hmParams.put("range20FrUnit",((req.getParameter("range_20_fr_unit")!=null)?req.getParameter("range_20_fr_unit"):""));
			hmParams.put("range_20_to",((req.getParameter("range_20_to")!=null)?req.getParameter("range_20_to"):""));
			hmParams.put("range20ToUnit",((req.getParameter("range_20_to_unit")!=null)?req.getParameter("range_20_to_unit"):""));
			hmParams.put("range_21_fr",((req.getParameter("range_21_fr")!=null)?req.getParameter("range_21_fr"):""));
			hmParams.put("range21FrUnit",((req.getParameter("range_21_fr_unit")!=null)?req.getParameter("range_21_fr_unit"):""));
			hmParams.put("range_21_to",((req.getParameter("range_21_to")!=null)?req.getParameter("range_21_to"):""));
			hmParams.put("range21ToUnit",((req.getParameter("range_21_to_unit")!=null)?req.getParameter("range_21_to_unit"):""));
			hmParams.put("range_22_fr",((req.getParameter("range_22_fr")!=null)?req.getParameter("range_22_fr"):""));
			hmParams.put("range22FrUnit",((req.getParameter("range_22_fr_unit")!=null)?req.getParameter("range_22_fr_unit"):""));
			hmParams.put("range_22_to",((req.getParameter("range_22_to")!=null)?req.getParameter("range_22_to"):""));
			hmParams.put("range22ToUnit",((req.getParameter("range_22_to_unit")!=null)?req.getParameter("range_22_to_unit"):""));
			hmParams.put("range_23_fr",((req.getParameter("range_23_fr")!=null)?req.getParameter("range_23_fr"):""));
			hmParams.put("range23FrUnit",((req.getParameter("range_23_fr_unit")!=null)?req.getParameter("range_23_fr_unit"):""));
			hmParams.put("range_23_to",((req.getParameter("range_23_to")!=null)?req.getParameter("range_23_to"):""));
			hmParams.put("range23ToUnit",((req.getParameter("range_23_to_unit")!=null)?req.getParameter("range_23_to_unit"):""));
			hmParams.put("range_24_fr",((req.getParameter("range_24_fr")!=null)?req.getParameter("range_24_fr"):""));
			hmParams.put("range24FrUnit",((req.getParameter("range_24_fr_unit")!=null)?req.getParameter("range_24_fr_unit"):""));
			hmParams.put("range_24_to",((req.getParameter("range_24_to")!=null)?req.getParameter("range_24_to"):""));
			hmParams.put("range24ToUnit",((req.getParameter("range_24_to_unit")!=null)?req.getParameter("range_24_to_unit"):""));
			hmParams.put("range_25_fr",((req.getParameter("range_25_fr")!=null)?req.getParameter("range_25_fr"):""));
			hmParams.put("range25FrUnit",((req.getParameter("range_25_fr_unit")!=null)?req.getParameter("range_25_fr_unit"):""));
			hmParams.put("range_25_to",((req.getParameter("range_25_to")!=null)?req.getParameter("range_25_to"):""));
			hmParams.put("range25ToUnit",((req.getParameter("range_25_to_unit")!=null)?req.getParameter("range_25_to_unit"):""));
			hmParams.put("effectiveDateFrom",((req.getParameter("effectiveDateFrom")!=null)?req.getParameter("effectiveDateFrom"):""));
			hmParams.put("effectiveDateTo",((req.getParameter("effectiveDateTo")!=null)?req.getParameter("effectiveDateTo"):""));
			hmParams.put("effectiveStatus",effectiveStatus);
			hmParams.put("facilityId",(String) session.getValue( "facility_id" ));
			hmParams.put("client_ip_address",p.getProperty("client_ip_address"));
	
			argArray[0] = hmParams;
			Class [] paramArray = new Class[1];
			paramArray[0] = hmParams.getClass();
			HashMap results = (HashMap)(busObj.getClass().getMethod("updateAgeRange",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			hmParams.clear();
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			out.println("<script>alert('"+inserted+"');</script>");
			results.clear();
			if ( inserted ){
				error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}else{
				error = (String) results.get("error") ;
		     	res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error, "UTF-8" ) );
			}
	} catch ( Exception e ){
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		out.println( "Values sent are : <br>" ) ;
		out.println(req.getParameter("rangeType") + " "+ req.getParameter("range_id") + " "+req.getParameter("long_desc")+" "+req.getParameter("short_desc") +" "+noOfRanges+" "+ req.getParameter("effectiveDateFrom")+" "+ req.getParameter("effectiveDateTo") + " "+ req.getParameter("effectiveStatus")+" "+range1Fr+" "+range1To);
		e.printStackTrace();
	}
}

private void insertAgeRange(HttpServletRequest req, HttpServletResponse res){
	HttpSession session = req.getSession(false);	
	try {
		String effectiveStatus = req.getParameter("eff_status");
		String no_of_ranges = req.getParameter("no_of_ranges");
		if ( !no_of_ranges.equals( "" ) )
			noOfRanges= Integer.parseInt( no_of_ranges ) ;
		if ( effectiveStatus == null )
			effectiveStatus="D";
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AgeRangeManager",AgeRangeManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[1];
			HashMap hmParams = new HashMap();
			hmParams.put("p",p);
         	hmParams.put("rangeType",((req.getParameter("range_type")!=null)?req.getParameter("range_type"):""));
			hmParams.put("rangeId",((req.getParameter("range_id")!=null)?req.getParameter("range_id"):""));
		    hmParams.put("longDesc",((req.getParameter("long_desc")!=null)?req.getParameter("long_desc"):""));
		    hmParams.put("shortDesc",((req.getParameter("short_desc")!=null)?req.getParameter("short_desc"):""));
			hmParams.put("noOfRanges",new Integer(noOfRanges));			
			hmParams.put("range_1_fr",((req.getParameter("range_1_fr")!=null)?req.getParameter("range_1_fr"):""));
			hmParams.put("range1FrUnit",((req.getParameter("range_1_fr_unit")!=null)?req.getParameter("range_1_fr_unit"):""));
			hmParams.put("range_1_to",((req.getParameter("range_1_to")!=null)?req.getParameter("range_1_to"):""));
			hmParams.put("range1ToUnit",((req.getParameter("range_1_to_unit")!=null)?req.getParameter("range_1_to_unit"):""));
			hmParams.put("range_2_fr",((req.getParameter("range_2_fr")!=null)?req.getParameter("range_2_fr"):""));
			hmParams.put("range2FrUnit",((req.getParameter("range_2_fr_unit")!=null)?req.getParameter("range_2_fr_unit"):""));
			hmParams.put("range_2_to",((req.getParameter("range_2_to")!=null)?req.getParameter("range_2_to"):""));
			hmParams.put("range2ToUnit",((req.getParameter("range_2_to_unit")!=null)?req.getParameter("range_2_to_unit"):""));
			hmParams.put("range_3_fr",((req.getParameter("range_3_fr")!=null)?req.getParameter("range_3_fr"):""));
			hmParams.put("range3FrUnit",((req.getParameter("range_3_fr_unit")!=null)?req.getParameter("range_3_fr_unit"):""));
			hmParams.put("range_3_to",((req.getParameter("range_3_to")!=null)?req.getParameter("range_3_to"):""));
			hmParams.put("range3ToUnit",((req.getParameter("range_3_to_unit")!=null)?req.getParameter("range_3_to_unit"):""));
			hmParams.put("range_4_fr",((req.getParameter("range_4_fr")!=null)?req.getParameter("range_4_fr"):""));
			hmParams.put("range4FrUnit",((req.getParameter("range_4_fr_unit")!=null)?req.getParameter("range_4_fr_unit"):""));
			hmParams.put("range_4_to",((req.getParameter("range_4_to")!=null)?req.getParameter("range_4_to"):""));
			hmParams.put("range4ToUnit",((req.getParameter("range_4_to_unit")!=null)?req.getParameter("range_4_to_unit"):""));
			hmParams.put("range_5_fr",((req.getParameter("range_5_fr")!=null)?req.getParameter("range_5_fr"):""));
			hmParams.put("range5FrUnit",((req.getParameter("range_5_fr_unit")!=null)?req.getParameter("range_5_fr_unit"):""));
			hmParams.put("range_5_to",((req.getParameter("range_5_to")!=null)?req.getParameter("range_5_to"):""));
			hmParams.put("range5ToUnit",((req.getParameter("range_5_to_unit")!=null)?req.getParameter("range_5_to_unit"):""));
			hmParams.put("range_6_fr",((req.getParameter("range_6_fr")!=null)?req.getParameter("range_6_fr"):""));
			hmParams.put("range6FrUnit",((req.getParameter("range_6_fr_unit")!=null)?req.getParameter("range_6_fr_unit"):""));
			hmParams.put("range_6_to",((req.getParameter("range_6_to")!=null)?req.getParameter("range_6_to"):""));
			hmParams.put("range6ToUnit",((req.getParameter("range_6_to_unit")!=null)?req.getParameter("range_6_to_unit"):""));
			hmParams.put("range_7_fr",((req.getParameter("range_7_fr")!=null)?req.getParameter("range_7_fr"):""));
			hmParams.put("range7FrUnit",((req.getParameter("range_7_fr_unit")!=null)?req.getParameter("range_7_fr_unit"):""));
			hmParams.put("range_7_to",((req.getParameter("range_7_to")!=null)?req.getParameter("range_7_to"):""));
			hmParams.put("range7ToUnit",((req.getParameter("range_7_to_unit")!=null)?req.getParameter("range_7_to_unit"):""));
			hmParams.put("range_8_fr",((req.getParameter("range_8_fr")!=null)?req.getParameter("range_8_fr"):""));
			hmParams.put("range8FrUnit",((req.getParameter("range_8_fr_unit")!=null)?req.getParameter("range_8_fr_unit"):""));
			hmParams.put("range_8_to",((req.getParameter("range_8_to")!=null)?req.getParameter("range_8_to"):""));
			hmParams.put("range8ToUnit",((req.getParameter("range_8_to_unit")!=null)?req.getParameter("range_8_to_unit"):""));
			hmParams.put("range_9_fr",((req.getParameter("range_9_fr")!=null)?req.getParameter("range_9_fr"):""));
			hmParams.put("range9FrUnit",((req.getParameter("range_9_fr_unit")!=null)?req.getParameter("range_9_fr_unit"):""));
			hmParams.put("range_9_to",((req.getParameter("range_9_to")!=null)?req.getParameter("range_9_to"):""));
			hmParams.put("range9ToUnit",((req.getParameter("range_9_to_unit")!=null)?req.getParameter("range_9_to_unit"):""));
			hmParams.put("range_10_fr",((req.getParameter("range_10_fr")!=null)?req.getParameter("range_10_fr"):""));
			hmParams.put("range10FrUnit",((req.getParameter("range_10_fr_unit")!=null)?req.getParameter("range_10_fr_unit"):""));
			hmParams.put("range_10_to",((req.getParameter("range_10_to")!=null)?req.getParameter("range_10_to"):""));
			hmParams.put("range10ToUnit",((req.getParameter("range_10_to_unit")!=null)?req.getParameter("range_10_to_unit"):""));
			hmParams.put("range_11_fr",((req.getParameter("range_11_fr")!=null)?req.getParameter("range_11_fr"):""));
			hmParams.put("range11FrUnit",((req.getParameter("range_11_fr_unit")!=null)?req.getParameter("range_11_fr_unit"):""));
			hmParams.put("range_11_to",((req.getParameter("range_11_to")!=null)?req.getParameter("range_11_to"):""));
			hmParams.put("range11ToUnit",((req.getParameter("range_11_to_unit")!=null)?req.getParameter("range_11_to_unit"):""));
			hmParams.put("range_12_fr",((req.getParameter("range_12_fr")!=null)?req.getParameter("range_12_fr"):""));
			hmParams.put("range12FrUnit",((req.getParameter("range_12_fr_unit")!=null)?req.getParameter("range_12_fr_unit"):""));
			hmParams.put("range_12_to",((req.getParameter("range_12_to")!=null)?req.getParameter("range_12_to"):""));
			hmParams.put("range12ToUnit",((req.getParameter("range_12_to_unit")!=null)?req.getParameter("range_12_to_unit"):""));
			hmParams.put("range_13_fr",((req.getParameter("range_13_fr")!=null)?req.getParameter("range_13_fr"):""));
			hmParams.put("range13FrUnit",((req.getParameter("range_13_fr_unit")!=null)?req.getParameter("range_13_fr_unit"):""));
			hmParams.put("range_13_to",((req.getParameter("range_13_to")!=null)?req.getParameter("range_13_to"):""));
			hmParams.put("range13ToUnit",((req.getParameter("range_13_to_unit")!=null)?req.getParameter("range_13_to_unit"):""));
			hmParams.put("range_14_fr",((req.getParameter("range_14_fr")!=null)?req.getParameter("range_14_fr"):""));
			hmParams.put("range14FrUnit",((req.getParameter("range_14_fr_unit")!=null)?req.getParameter("range_14_fr_unit"):""));
			hmParams.put("range_14_to",((req.getParameter("range_14_to")!=null)?req.getParameter("range_14_to"):""));
			hmParams.put("range14ToUnit",((req.getParameter("range_14_to_unit")!=null)?req.getParameter("range_14_to_unit"):""));
			hmParams.put("range_15_fr",((req.getParameter("range_15_fr")!=null)?req.getParameter("range_15_fr"):""));
			hmParams.put("range15FrUnit",((req.getParameter("range_15_fr_unit")!=null)?req.getParameter("range_15_fr_unit"):""));
			hmParams.put("range_15_to",((req.getParameter("range_15_to")!=null)?req.getParameter("range_15_to"):""));
			hmParams.put("range15ToUnit",((req.getParameter("range_15_to_unit")!=null)?req.getParameter("range_15_to_unit"):""));
			hmParams.put("range_16_fr",((req.getParameter("range_16_fr")!=null)?req.getParameter("range_16_fr"):""));
			hmParams.put("range16FrUnit",((req.getParameter("range_16_fr_unit")!=null)?req.getParameter("range_16_fr_unit"):""));
			hmParams.put("range_16_to",((req.getParameter("range_16_to")!=null)?req.getParameter("range_16_to"):""));
			hmParams.put("range16ToUnit",((req.getParameter("range_16_to_unit")!=null)?req.getParameter("range_16_to_unit"):""));
			hmParams.put("range_17_fr",((req.getParameter("range_17_fr")!=null)?req.getParameter("range_17_fr"):""));
			hmParams.put("range17FrUnit",((req.getParameter("range_17_fr_unit")!=null)?req.getParameter("range_17_fr_unit"):""));
			hmParams.put("range_17_to",((req.getParameter("range_17_to")!=null)?req.getParameter("range_17_to"):""));
			hmParams.put("range17ToUnit",((req.getParameter("range_17_to_unit")!=null)?req.getParameter("range_17_to_unit"):""));
			hmParams.put("range_18_fr",((req.getParameter("range_18_fr")!=null)?req.getParameter("range_18_fr"):""));
			hmParams.put("range18FrUnit",((req.getParameter("range_18_fr_unit")!=null)?req.getParameter("range_18_fr_unit"):""));
			hmParams.put("range_18_to",((req.getParameter("range_18_to")!=null)?req.getParameter("range_18_to"):""));
			hmParams.put("range18ToUnit",((req.getParameter("range_18_to_unit")!=null)?req.getParameter("range_18_to_unit"):""));
			hmParams.put("range_19_fr",((req.getParameter("range_19_fr")!=null)?req.getParameter("range_19_fr"):""));
			hmParams.put("range19FrUnit",((req.getParameter("range_19_fr_unit")!=null)?req.getParameter("range_19_fr_unit"):""));
			hmParams.put("range_19_to",((req.getParameter("range_19_to")!=null)?req.getParameter("range_19_to"):""));
			hmParams.put("range19ToUnit",((req.getParameter("range_19_to_unit")!=null)?req.getParameter("range_19_to_unit"):""));
			hmParams.put("range_20_fr",((req.getParameter("range_20_fr")!=null)?req.getParameter("range_20_fr"):""));
			hmParams.put("range20FrUnit",((req.getParameter("range_20_fr_unit")!=null)?req.getParameter("range_20_fr_unit"):""));
			hmParams.put("range_20_to",((req.getParameter("range_20_to")!=null)?req.getParameter("range_20_to"):""));
			hmParams.put("range20ToUnit",((req.getParameter("range_20_to_unit")!=null)?req.getParameter("range_20_to_unit"):""));
			hmParams.put("range_21_fr",((req.getParameter("range_21_fr")!=null)?req.getParameter("range_21_fr"):""));
			hmParams.put("range21FrUnit",((req.getParameter("range_21_fr_unit")!=null)?req.getParameter("range_21_fr_unit"):""));
			hmParams.put("range_21_to",((req.getParameter("range_21_to")!=null)?req.getParameter("range_21_to"):""));
			hmParams.put("range21ToUnit",((req.getParameter("range_21_to_unit")!=null)?req.getParameter("range_21_to_unit"):""));
			hmParams.put("range_22_fr",((req.getParameter("range_22_fr")!=null)?req.getParameter("range_22_fr"):""));
			hmParams.put("range22FrUnit",((req.getParameter("range_22_fr_unit")!=null)?req.getParameter("range_22_fr_unit"):""));
			hmParams.put("range_22_to",((req.getParameter("range_22_to")!=null)?req.getParameter("range_22_to"):""));
			hmParams.put("range22ToUnit",((req.getParameter("range_22_to_unit")!=null)?req.getParameter("range_22_to_unit"):""));
			hmParams.put("range_23_fr",((req.getParameter("range_23_fr")!=null)?req.getParameter("range_23_fr"):""));
			hmParams.put("range23FrUnit",((req.getParameter("range_23_fr_unit")!=null)?req.getParameter("range_23_fr_unit"):""));
			hmParams.put("range_23_to",((req.getParameter("range_23_to")!=null)?req.getParameter("range_23_to"):""));
			hmParams.put("range23ToUnit",((req.getParameter("range_23_to_unit")!=null)?req.getParameter("range_23_to_unit"):""));
			hmParams.put("range_24_fr",((req.getParameter("range_24_fr")!=null)?req.getParameter("range_24_fr"):""));
			hmParams.put("range24FrUnit",((req.getParameter("range_24_fr_unit")!=null)?req.getParameter("range_24_fr_unit"):""));
			hmParams.put("range_24_to",((req.getParameter("range_24_to")!=null)?req.getParameter("range_24_to"):""));
			hmParams.put("range24ToUnit",((req.getParameter("range_24_to_unit")!=null)?req.getParameter("range_24_to_unit"):""));
			hmParams.put("range_25_fr",((req.getParameter("range_25_fr")!=null)?req.getParameter("range_25_fr"):""));
			hmParams.put("range25FrUnit",((req.getParameter("range_25_fr_unit")!=null)?req.getParameter("range_25_fr_unit"):""));
			hmParams.put("range_25_to",((req.getParameter("range_25_to")!=null)?req.getParameter("range_25_to"):""));
			hmParams.put("range25ToUnit",((req.getParameter("range_25_to_unit")!=null)?req.getParameter("range_25_to_unit"):""));
		 	hmParams.put("effectiveDateFrom",((req.getParameter("eff_date_from")!=null)?req.getParameter("eff_date_from"):""));
			hmParams.put("effectiveDateTo",((req.getParameter("eff_date_to")!=null)?req.getParameter("eff_date_to"):""));
			hmParams.put("effectiveStatus",effectiveStatus);
			hmParams.put("facilityId",(String) session.getValue("facility_id"));
			hmParams.put("client_ip_address",p.getProperty("client_ip_address"));

			argArray[0] = hmParams;
			Class [] paramArray = new Class[1];
			paramArray[0] = hmParams.getClass();
			HashMap results = (HashMap)(busObj.getClass().getMethod("insertAgeRange",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			hmParams.clear();
		  	boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		    String error = (String) results.get("error") ;
		    String error_value = "0" ;
			results.clear();
		    if ( inserted ){
			 error_value = "1" ;
			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error , "UTF-8" ) + "&err_value=" + error_value );
		    }else{
			 error = (String) results.get("error") ;
			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" ) );
		    }
		}catch ( Exception e ) {
			out.println(e.getMessage());
			out.println(e.toString());
			e.printStackTrace();
		}
	}
}
