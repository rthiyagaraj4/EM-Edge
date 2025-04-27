/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

/**
 *		FileName : UOMServlet.java
 *		Version	 : 3
 *		Date	 : 15-2-05	
**/
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import eCommon.SingleTabHandler.*;

public class UOMServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	
	java.util.Properties p;
	String department="";
	String longDesc ="";
	String shortDesc ="";
	String effectiveStatus="" ;
	String facilityId ="";
	String client_ip_address="" ;
	String serviceURL="";
	//String objectName="";
	//String effectiveDateFrom="" ;
	//String effectiveDateTo ="";
	String purchase="";
    String stock="";
	String sale="";
	String dosage="";
	String strength="";
	String quantity="";
	String Code="";
	String externalUom="";

	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		res.setContentType("text/html");
		out = res.getWriter();
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		
		facilityId = (String) session.getValue( "facility_id" ) ;
		if(facilityId==null) facilityId="";
		
		client_ip_address = p.getProperty("client_ip_address");
		if(client_ip_address ==null) client_ip_address ="";
		
		serviceURL=(String) session.getValue("serviceURL");
		if(serviceURL==null) serviceURL="";

		try
		{
			String operation = req.getParameter("function");
			out.println("<script>alert('tsd');</script>");

			if ( operation.equals("insert"))   insertUnitOfMeasure(req, res);
			if ( operation.equals("modify"))   modifyUnitOfMeasure(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	/*public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = res.getWriter();
			res.setContentType("text/html");
		
		}
		catch(Exception e)	{	}
	}*/


	private void modifyUnitOfMeasure(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			Code = req.getParameter("Code");
			if(Code==null) Code="";
			longDesc = req.getParameter("long_desc");
			if(longDesc==null) longDesc="";
			shortDesc = req.getParameter("short_desc");
			if(shortDesc==null) shortDesc="";
			effectiveStatus = req.getParameter("eff_status");			
			purchase = req.getParameter("purchase");
			if(purchase ==null) purchase="N";
			stock = req.getParameter("stock");
			if(stock ==null) stock="N";
			sale = req.getParameter("sale");
			if(sale ==null) sale="N";
			dosage = req.getParameter("dosage");
			if(dosage ==null) dosage="N";
			strength = req.getParameter("strength");
			if(strength ==null) strength="N";
			quantity = req.getParameter("quantity");
			if(quantity ==null) quantity="N";

			if ( effectiveStatus == null )
				effectiveStatus="D";
			
			externalUom=req.getParameter("DRUG_DATABASE_UOM_CODE");
			if(externalUom==null) externalUom="";
			String addedById = p.getProperty( "login_user" ) ;
			if(addedById==null) addedById="";
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			if(addedDate ==null) addedDate="";
			String modifiedById = addedById ;
			if(modifiedById==null) modifiedById="";
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			
			HashMap tabdata=new HashMap();
				tabdata.put("LONG_DESC",longDesc);
				tabdata.put("SHORT_DESC",shortDesc);
				tabdata.put("EFF_STATUS",effectiveStatus);
				tabdata.put("UOM_CODE", Code);
				tabdata.put("STOCK_UOM_YN", stock);
				tabdata.put("SALE_UOM_YN", sale);
				tabdata.put("PUR_UOM_YN", purchase);
				tabdata.put("DOSAGE_UOM_YN", dosage);
				tabdata.put("STRENGTH_UOM_YN", strength);
				tabdata.put("QTY_UOM_YN", quantity);
				tabdata.put("MODIFIED_BY_ID",modifiedById);
				tabdata.put("MODIFIED_DATE",modifiedDate);
				tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
				tabdata.put("MODIFIED_FACILITY_ID", modifiedFacilityId);
				tabdata.put("DRUG_DATABASE_UOM_CODE", externalUom);

			HashMap condflds=new HashMap();
				condflds.put("UOM_CODE",Code);

			/*Context context =  new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome=(SingleTabHandlerManagerHome)PortableRemoteObject.narrow(homeObject,
			SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
			final java.util.Hashtable results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"AM_UOM");*/

			//Approach via the ServiceLocator and Reflection
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			/*Object argArray[] = new Object[4];
			String table_name="AM_UOM";
			HashMap hashmap=new HashMap();
			hashmap.put("p",p);
			hashmap.put("tabdata",tabdata);
			hashmap.put("condflds",condflds);
			hashmap.put("table_name",table_name);

			argArray[0] = hashmap;
						
			Class [] paramArray = new Class[1];
			paramArray[0] = hashmap.getClass();*/



					Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
			String table_name="AM_UOM";
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =condflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				//paramArray[0] =hashmap.getClass();
					paramArray[0] =p.getClass();
					paramArray[1] =tabdata.getClass();
					paramArray[2] =condflds.getClass();
					paramArray[3] =table_name.getClass();


			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
						String error_value = "0" ;
						if ( inserted )
						{
						 error_value = "1" ;
						}
						else
						{
						 error = (String) results.get("error") ;
						}

        	error = (String) results.get("error") ;
    		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8" )+"&err_value="+error_value );

			tabdata.clear();
			condflds.clear();
			results.clear();
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( department + " "+longDesc + " "+shortDesc + " "+ effectiveStatus );
		}
	}

	private void insertUnitOfMeasure(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			longDesc = req.getParameter("long_desc");
			if(longDesc==null) longDesc="";
			shortDesc = req.getParameter("short_desc");
			if(shortDesc==null) shortDesc="";
			
			effectiveStatus = req.getParameter("eff_status");
			Code = req.getParameter("Code");
			if(Code==null) Code="";
			purchase = req.getParameter("purchase");
			if(purchase ==null) purchase="N";
			stock = req.getParameter("stock");
			if(stock ==null) stock="N";
			sale = req.getParameter("sale");
			if(sale ==null) sale="N";
			dosage = req.getParameter("dosage");
			if(dosage ==null) dosage="N";
			strength = req.getParameter("strength");
			if(strength ==null) strength="N";
			quantity = req.getParameter("quantity");
			if(quantity ==null) quantity="N";
			if ( effectiveStatus == null )
				effectiveStatus="D";

			externalUom=req.getParameter("DRUG_DATABASE_UOM_CODE");
			if(externalUom==null) externalUom="";
				String addedById = p.getProperty( "login_user" ) ;
				if(addedById==null) addedById="";
				String addedDate = dateFormat.format( new java.util.Date() ) ;
				if(addedDate ==null) addedDate="";

			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			if(modifiedById==null) modifiedById="";
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();
				tabdata.put("LONG_DESC",longDesc);
				tabdata.put("SHORT_DESC",shortDesc);
				tabdata.put("EFF_STATUS",effectiveStatus);
				tabdata.put("UOM_CODE", Code);
				tabdata.put("STOCK_UOM_YN", stock);
				tabdata.put("SALE_UOM_YN", sale);
				tabdata.put("DOSAGE_UOM_YN", dosage);
				tabdata.put("STRENGTH_UOM_YN", strength);
				tabdata.put("QTY_UOM_YN", quantity);
				tabdata.put("PUR_UOM_YN", purchase);
				tabdata.put("ADDED_BY_ID",addedById);
				tabdata.put("ADDED_DATE",addedDate);
				tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
				tabdata.put("ADDED_FACILITY_ID",addedFacilityId);
				tabdata.put("MODIFIED_BY_ID",modifiedById);
				tabdata.put("MODIFIED_DATE",modifiedDate);
				tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
				tabdata.put("MODIFIED_FACILITY_ID", modifiedFacilityId);
				tabdata.put("DRUG_DATABASE_UOM_CODE", externalUom);


			String dupflds[]={"UOM_CODE"};

			/*Context context =  new InitialContext(  ) ;
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome=(SingleTabHandlerManagerHome)PortableRemoteObject.narrow(homeObject,  SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
			final java.util.Hashtable results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"AM_UOM");*/

			//Approach via the ServiceLocator and Reflection
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		/*	Object argArray[] = new Object[4];
			String table_name="AM_UOM";
			HashMap hashmap=new HashMap();
			hashmap.put("p",p);
			hashmap.put("tabdata",tabdata);
			hashmap.put("dupflds",dupflds);
			hashmap.put("table_name",table_name);

			argArray[0] = hashmap;
						
			Class [] paramArray = new Class[1];
			paramArray[0] = hashmap.getClass();*/


			Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
			String table_name="AM_UOM";
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =dupflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				//paramArray[0] =hashmap.getClass();
					paramArray[0] =p.getClass();
					paramArray[1] =tabdata.getClass();
					paramArray[2] =dupflds.getClass();
					paramArray[3] =table_name.getClass();

					

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

						String error = (String) results.get("error") ;
									String error_value = "0" ;
									if ( inserted )
									{
									 error_value = "1" ;
									}
									else
									{
									 error = (String) results.get("error") ;
									}

			        	error = (String) results.get("error") ;
			    		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  )+"&err_value="+error_value );

						tabdata.clear();
						results.clear();
					}
					catch ( Exception e )
					{
						out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
						out.println( "Values sent are : <br>" ) ;
						out.println( department+ " "+longDesc + " "+shortDesc +" "+ effectiveStatus );
		}
	}

}
