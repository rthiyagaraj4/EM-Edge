/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eAM.DiscreteMeasurePanel.*;

public class DiscreteMeasurePanelServlet extends javax.servlet.http.HttpServlet
{

PrintWriter out;
java.util.Properties p;


String discr_msr_battery_id = "";
String discr_msr_id  = "";
String order_srl_no  = "";
String old_order_srl_no = "";
String mandatory_yn	 = "";
String mode = "";

String facilityId = "" ;
String client_ip_address = "";


String addedById			= "";

String modifiedById			= "";

String addedFacilityId		= "";
String modifiedFacilityId	= "";
String addedAtWorkstation	= "";
String modifiedAtWorkstation= "";

//java.util.Hashtable env			;
//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;


/*
*	init	-	will initialise the servlet
*	@param	config - this is ServletConfig
*/

public void init(ServletConfig config) throws ServletException	{
	super.init(config);
	}

/*
*	doPost	-	will be called when the method is of post
*	@param	req - this is HttpServletRequest
*	@param	res - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
{
		HttpSession session = req.getSession(false);
		
		this.facilityId = (String) session.getValue("facility_id") ;
		this.p = (java.util.Properties) session.getValue("jdbc") ;
		this.client_ip_address = p.getProperty("client_ip_address");
		//serviceURL 	= (String) session.getValue( "serviceURL" ) ;

		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		//modifiedDate = dateFormat.format( new java.util.Date());
		modifiedFacilityId		= (this.facilityId==null)?"":this.facilityId;
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;

		try{
			res.setContentType("text/html");
			this.out = res.getWriter();
			mode =(req.getParameter("mode")==null)?"":req.getParameter("mode");
			insertNoteTypeParam(req, res);
			} catch(Exception e) {
			out.println(e.toString());
		}

	}


/*
*	doGet	-	will be called when the method is of get
*	@param	req - this is HttpServletRequest
*	@param	res - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/

public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException {
	doPost(req,res);
}


/*
*	insertNoteTypeParam	-	used to populate the request parameters and
*										put in a Hashtable which will be further given as an argument to the
*										EJB - SubSection
*	@param	req - this is HttpServletRequest
*	@param	res - this is HttpServletResponse
*/

private void insertNoteTypeParam(HttpServletRequest req, HttpServletResponse res)	{
	
try
{
	if(mode.trim().equalsIgnoreCase("insert"))
	{
		
	

	discr_msr_battery_id = (req.getParameter("discr_msr_battery_id")==null)?"":req.getParameter("discr_msr_battery_id");
	discr_msr_id		 = (req.getParameter("discr_msr_id")==null)?"":req.getParameter("discr_msr_id");
	order_srl_no         = (req.getParameter("order_srl_no")==null)?"":req.getParameter("order_srl_no");
	old_order_srl_no     = (req.getParameter("old_order_srl_no")==null)?"":req.getParameter("old_order_srl_no");
	mandatory_yn         = (req.getParameter("mandatory_yn")==null)?"N":req.getParameter("mandatory_yn");
	}

	if(mode.trim().equalsIgnoreCase("update") || mode.trim().equalsIgnoreCase("delete"))
	{
	discr_msr_battery_id = (req.getParameter("discr_msr_battery_id_update")==null)?"":
	req.getParameter("discr_msr_battery_id_update");
	discr_msr_id		 = (req.getParameter("discr_msr_id_update")==null)?"":
	req.getParameter("discr_msr_id_update");
	order_srl_no         = (req.getParameter("order_srl_no")==null)?"":req.getParameter("order_srl_no");
	old_order_srl_no         = (req.getParameter("old_order_srl_no")==null)?"":req.getParameter("old_order_srl_no");

	mandatory_yn         = (req.getParameter("mandatory_yn")==null)?"N":req.getParameter("mandatory_yn");
	}


	addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
	//addedDate = dateFormat.format(new java.util.Date()) ;

	addedFacilityId		= (this.facilityId==null)?"":this.facilityId;
	addedAtWorkstation	= (client_ip_address==null)?"":client_ip_address;

	HashMap tabdata=new HashMap();

	tabdata.put("p",p);
	tabdata.put("discr_msr_battery_id",discr_msr_battery_id);
	tabdata.put("discr_msr_id",discr_msr_id);
	tabdata.put("order_srl_no",order_srl_no);
	tabdata.put("old_order_srl_no",old_order_srl_no);
	tabdata.put("mandatory_yn",mandatory_yn);
	tabdata.put("mode",mode);
	tabdata.put("added_by_id",addedById);
	tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
	tabdata.put("added_facility_id",addedFacilityId);
	tabdata.put("added_at_ws_no",addedAtWorkstation);
	tabdata.put("modified_by_id",modifiedById);
	tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
	tabdata.put("modified_facility_id",modifiedFacilityId);
	tabdata.put("modified_at_ws_no",modifiedAtWorkstation );


	

	//String condflds[]={};
    HashMap dupflds=new HashMap();
    dupflds.put("module_id","AM");

   	/*InitialContext context = new InitialContext();
	Object homeObject = context.lookup("java:comp/env/DiscreteMeasurePanel");
	DiscreteMeasurePanelHome   discreteMeasurePanelHome   =(DiscreteMeasurePanelHome)PortableRemoteObject.narrow(homeObject,DiscreteMeasurePanelHome.class);
	DiscreteMeasurePanelRemote discreteMeasurePanelRemote = discreteMeasurePanelHome.create();
	java.util.Hashtable results = new Hashtable();
	results = discreteMeasurePanelRemote.manageDiscreteMeasurePanel(p,tabdata);*/

	boolean local_ejbs = false;
		
	if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
		local_ejbs = true;

	Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/DiscreteMeasurePanel",DiscreteMeasurePanelHome.class,local_ejbs);
	Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

	Object argArray[] = new Object[1];

	HashMap hashmap=new HashMap();
	hashmap.put("tabdata",tabdata);
			
	argArray[0] = hashmap;
	Class [] paramArray = new Class[1];
	paramArray[0] = hashmap.getClass();

	java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("manageDiscreteMeasurePanel",paramArray)).invoke(busObj,argArray);

	(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

	boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
    tabdata.clear();
	dupflds.clear();
	hashmap.clear();
	String error = (String) results.get("error") ;
	String error_value = "0" ;
	results.clear();

	if ( inserted ) error_value = "1" ;
	res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );

	} 
	catch ( Exception e )
	{
		e.printStackTrace();
	}
	}
}
