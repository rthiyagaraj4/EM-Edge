/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/***** Last Modified Date 9/22/2005 12:22 PM 

 * @filename DocumentTypeServlet.java
 *
 * @version 3.0 modified on 2/21/2005
 *	
 *******/
package eMP;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.Properties;

import com.ehis.eslp.ServiceLocator;

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;

import eCommon.XSSRequestWrapper;//Added by Kamatchi S for security issue against COMMON-ICN-0187

/*** @todo Class data members should be moved to method level scope ***/
public class DocumentTypeServlet extends HttpServlet{
	PrintWriter out;
	Properties p;
	
	String docType;
	String longDesc ;
	String shortDesc ;
	String effectiveDateFrom ;
	String effectiveDateTo ;
	String effectiveStatus ;
	String facilityId ;
	String client_ip_address ;
	//Added by Sangeetha on 18/apr/17 for KDAH-CRF-0347 
	//String supp_doc_type;
	String supp_doc_type_add;
	String supp_doc_type_iden;
	String supp_doc_desc;
	
	/**
	 * @todo Synchronization can be removed once variables are moved to method level
	 */
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
														    throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		//Added by Kamatchi S for security issue against COMMON-ICN-0187
		req = new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		//Added by Kamatchi S for security issue against COMMON-ICN-0187 END
		HttpSession session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");

	  	try {
			this.out = res.getWriter();
			String operation = req.getParameter("function");

			if ( operation.equals("insert") )
				insertDocumentType(req, res);
			if ( operation.equals("modify"))
					modifyDocumentType(req, res);
		}catch (Exception e){		
			//out.println(e.toString());
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		try	{
			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/DocumentType.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html>");
		} catch(Exception e){	
			e.printStackTrace();
		}
	}

	private void modifyDocumentType(HttpServletRequest req, HttpServletResponse res){
		try {
			docType = req.getParameter("doc_type");
			longDesc = req.getParameter("long_desc");
			shortDesc = req.getParameter("short_desc");
			effectiveDateFrom = req.getParameter("eff_date_from");
			effectiveDateTo = req.getParameter("eff_date_to");
			effectiveStatus = req.getParameter("eff_status");
			if ( effectiveStatus == null )
				effectiveStatus="D";

			//Added by Sangeetha on 18/apr/17 for KDAH-CRF-0347 
			supp_doc_desc =  req.getParameter("supp_doc_desc");
			if((supp_doc_desc==null) || (supp_doc_desc.equals("null")))
				supp_doc_desc = "";
		
			
			//supp_doc_type  =  req.getParameter("supp_doc_type");
			//if((supp_doc_type==null) || (supp_doc_type.equals("null")))
				//supp_doc_type = "";
			
			//Modified by Sangeetha for PMG2017-KDAH-CRF-0001
			supp_doc_type_add  =  req.getParameter("supp_doc_type_add");
			if((supp_doc_type_add==null) || (supp_doc_type_add.equals("null")))
				supp_doc_type_add = "N";

			supp_doc_type_iden  =  req.getParameter("supp_doc_type_iden");
			if((supp_doc_type_iden==null) || (supp_doc_type_iden.equals("null")))
				supp_doc_type_iden = "N";
		

			String addedById = p.getProperty( "login_user" ) ;

			String modifiedById = addedById ;
			String modifiedFacilityId = facilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();
			tabdata.put("doc_type",docType);
			tabdata.put("long_desc",longDesc);
			tabdata.put("short_desc",shortDesc);
			tabdata.put("eff_date_from",effectiveDateFrom);
			tabdata.put("eff_date_to",effectiveDateTo);
			tabdata.put("eff_status",effectiveStatus);
			//Added by Sangeetha on 18/apr/17 for KDAH-CRF-0347 
			//tabdata.put("supp_doc_type",supp_doc_type);
			tabdata.put("address_proof_yn",supp_doc_type_add);
			tabdata.put("identity_proof_yn",supp_doc_type_iden);
			tabdata.put("supp_doc_desc",supp_doc_desc);

			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds=new HashMap();
			condflds.put("doc_type",docType);

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = "MP_DOCUMENT_TYPE";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;			

			String error = (String) results.get("error") ;
			String error_value = "0" ;

			if ( inserted ) error_value = "1" ;
			tabdata.clear();
			 condflds.clear();
			 results.clear();
    		 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );

			 

		} catch ( Exception e ) {
			/*out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( docType + " "+longDesc + " "+shortDesc +" "+ effectiveDateFrom+" "+ effectiveDateTo + " "+ effectiveStatus ); */
			e.printStackTrace();
		}
	}
	private void insertDocumentType(HttpServletRequest req, HttpServletResponse res)	{
		try {
			docType = req.getParameter("doc_type");
			longDesc = req.getParameter("long_desc");
			shortDesc = req.getParameter("short_desc");
			effectiveDateFrom = req.getParameter("eff_date_from");
			effectiveDateTo = req.getParameter("eff_date_to");
			effectiveStatus = req.getParameter("eff_status");
			supp_doc_type_iden = req.getParameter("supp_doc_type_iden");
			supp_doc_type_add  = req.getParameter("supp_doc_type_add");
			if ( effectiveStatus == null )
					effectiveStatus="D";

			//Added by Sangeetha on 18/apr/17 for KDAH-CRF-0347 
			supp_doc_desc =  req.getParameter("supp_doc_desc");
			if((supp_doc_desc==null) || (supp_doc_desc.equals("null")))
				supp_doc_desc = "";
			

			//supp_doc_type  =  req.getParameter("supp_doc_type");
			//if((supp_doc_type==null) || (supp_doc_type.equals("null")))
				//supp_doc_type = "";
			
			//Modified by Sangeetha for PMG2017-KDAH-CRF-0001
			supp_doc_type_add  =  req.getParameter("supp_doc_type_add");
			if((supp_doc_type_add==null) || (supp_doc_type_add.equals("null")))
				supp_doc_type_add = "N";

			supp_doc_type_iden  =  req.getParameter("supp_doc_type_iden");
			if((supp_doc_type_iden==null) || (supp_doc_type_iden.equals("null")))
				supp_doc_type_iden = "N";



			System.err.println("supp_doc_type_add==>"+supp_doc_type_add);
			System.err.println("supp_doc_type_iden==>"+supp_doc_type_iden);



			String addedById = p.getProperty( "login_user" );
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = facilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();
			tabdata.put("doc_type",docType);
			tabdata.put("long_desc",longDesc);
			tabdata.put("short_desc",shortDesc);
			tabdata.put("eff_date_from",effectiveDateFrom);
			tabdata.put("eff_date_to",effectiveDateTo);
			tabdata.put("eff_status",effectiveStatus);
			//Added by Sangeetha on 18/apr/17 for KDAH-CRF-0347 
			//tabdata.put("supp_doc_type",supp_doc_type);
			tabdata.put("address_proof_yn",supp_doc_type_add);
			tabdata.put("identity_proof_yn",supp_doc_type_iden);
			tabdata.put("supp_doc_desc",supp_doc_desc);

			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", addedFacilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);	
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			String dupflds[]={"doc_type"};

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = "MP_DOCUMENT_TYPE";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			tabdata.clear();
			results.clear();
			if ( inserted ) error_value = "1" ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
			
			

		} catch ( Exception e ) {
			//out.println(e.getMessage());
			//out.println(e.toString());
			e.printStackTrace();
		}
	}

	boolean isLocalEJB(){
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				return true;
		else
				return false;
	}
}
