/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eCommon.SingleTabHandler.*; 
import webbeans.eCommon.*;
public class DiagnosisClassificationServlet extends javax.servlet.http.HttpServlet	
{
PrintWriter out;
java.util.Properties p;

String diag_class_code;
String long_desc;
String short_desc;
String diag_class_type;
String eff_status;
/*Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012*/
/*Start*/
String default_status;
/*End*/
String finalTermset;
String termSet;

String client_ip_address ;
String facilityId="";





public void init(ServletConfig config) throws ServletException	{
	super.init(config);
	
	
	}
public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");	
		
		HttpSession session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;

		client_ip_address = p.getProperty("client_ip_address");

		try {
			this.out = res.getWriter();
			String operation = req.getParameter("mode");
			this.facilityId = (String) session.getAttribute( "facility_id" ) ;
		if ( operation.equals("insert") )
			insertDiagnosisClassification(req, res);
		else if ( operation.equals("modify") )
				modifyDiagnosisClassification(req, res);
		}
		catch (Exception e)	{
			out.println(e.toString());
			}
		}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
		res.setContentType("text/html;charset=UTF-8");
			doPost(req,res);
			
			
			}



public void insertDiagnosisClassification(HttpServletRequest req, HttpServletResponse res){
	
	int res1 =0;
	String Sql="";
	Connection con=null;
	Statement pstmt1=null;
	res.setContentType("text/html;charset=UTF-8");
	try{
		 con = ConnectionManager.getConnection(req);
		 pstmt1=con.createStatement();

		diag_class_code=req.getParameter("diag_class_code");
		if (diag_class_code == null)diag_class_code = "";
		long_desc=req.getParameter("long_desc");
		if (long_desc == null)long_desc = "";
		short_desc=req.getParameter("short_desc");
		if (short_desc == null)short_desc = "";
		diag_class_type=req.getParameter("diag_class_type");
		if (diag_class_type == null)diag_class_type = "";
		eff_status=req.getParameter("eff_status")==null ? "D":req.getParameter("eff_status");
		/*Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012*/
		/*Start*/
		//default_status=req.getParameter("default_status")==null ? "N":req.getParameter("default_status");
		/*End*/
		String defaulttermset	= req.getParameter("defaulttermset")==null ? "":req.getParameter("defaulttermset");
		String default_status	= "N";
		
		String addedById = p.getProperty( "login_user" ) ;
		String modifiedById = addedById ;
		String addedAtWorkstation=client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;
		
		if (finalTermset == null)finalTermset = "";
		finalTermset=req.getParameter("final_termSet");

			


		HashMap tabdata=new HashMap();
		tabdata.put("diag_class_code",diag_class_code);
		tabdata.put("long_desc",long_desc);
		tabdata.put("short_desc",short_desc);
		tabdata.put("diag_class_type",diag_class_type);
		tabdata.put("eff_status",eff_status);
		/*Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012*/
		/*Start*/
		//tabdata.put("default_status",default_status);
		/*End*/
		//tabdata.put("term_set_id",termSetId);
		tabdata.put("added_by_id",addedById);
		tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("added_at_ws_no",addedAtWorkstation);
		tabdata.put("added_facility_id",facilityId);
		tabdata.put("added_facility_id",facilityId);
		tabdata.put("modified_by_id",modifiedById);
		tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
		tabdata.put("modified_facility_id",facilityId );

		String dupfields[] = {"diag_class_code"};

		boolean local_ejbs = isLocalEJB();
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		 Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tabdata;
		argArray[2] = dupfields;
		argArray[3] = "MR_DIAG_CLASS";

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass(); ;
		paramArray[1] = tabdata.getClass();
		paramArray[2] = dupfields.getClass();
		paramArray[3] = String.class;
	
	java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
	(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

	
	boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
	String error = (String) results.get("error") ;
	String error_value = "0" ;
	boolean inserted1=false;
			if(inserted)
			{
				

				StringTokenizer StrToken = new StringTokenizer(finalTermset,"@");
				StringTokenizer Strdefaulttermset = new StringTokenizer(defaulttermset,"|#|");
				ArrayList deftermset = new ArrayList();
				while(Strdefaulttermset.hasMoreTokens()){
					deftermset.add(Strdefaulttermset.nextToken());
				}
				while(StrToken.hasMoreTokens())
					
				{

				termSet=StrToken.nextToken();

				if(!(termSet == null)&&!(termSet .equals(""))){
					if(!defaulttermset.equals("")){
						if(deftermset.contains(termSet)){
							default_status	= "Y";
						}else{
							default_status	= "N";
						}
					}
					Sql="insert into MR_DIAG_CLASS_DTL(DIAG_CLASS_CODE,TERM_SET_ID,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,DEFAULT_STATUS) values ('"+diag_class_code+"','"+termSet+"','"+addedById+"',sysdate,'"+facilityId+"','"+addedAtWorkstation+"','"+modifiedById+"',sysdate,'"+modifiedAtWorkstation+"','"+facilityId+"','"+default_status+"')";

							res1 = pstmt1.executeUpdate(Sql);
							
							if(res1 !=0){
									con.commit(); 
									inserted1 = true;
								}
							else{
								con.rollback();
								
								inserted1 = false;
							}

			}	

		}


	}			
	if ( inserted1 ){
				error_value = "1" ;
			//con.commit();  
		
			out.println("<script>parent.onSuccess('true');</script>");
		}
	else
		{
			
			out.println("<script>parent.onSuccess('false');</script>");
		}

		if (pstmt1 != null) pstmt1.close();				
			tabdata.clear();
			results.clear();
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
			} 
			catch ( Exception e ) {
			e.printStackTrace();
		}
		finally
			{
				
				ConnectionManager.returnConnection(con,req);
				
			}
		

	}
	boolean isLocalEJB(){
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				return true;
		else
				return false;
	}



	public void modifyDiagnosisClassification(HttpServletRequest req, HttpServletResponse res)throws Exception{

	int res3=0;
	int res1=0;
	Connection con=null;
	Statement pstmt=null;
	Statement pstmt1=null;
	String Sql=" ";
	String sql1=" ";
	try{
			con = ConnectionManager.getConnection(req);
			 pstmt=con.createStatement();

			diag_class_code=req.getParameter("diag_class_code")==null ? "":req.getParameter("diag_class_code");
			long_desc=req.getParameter("long_desc")==null ? "":req.getParameter("long_desc");
			short_desc=req.getParameter("short_desc")==null ? "":req.getParameter("short_desc");
			diag_class_type=req.getParameter("diag_class_type")==null ? "":req.getParameter("diag_class_type");
			eff_status=req.getParameter("eff_status")==null ? "D":req.getParameter("eff_status");
			/*Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012*/
			/*Start*/
			//default_status=req.getParameter("default_status")==null ? "N":req.getParameter("default_status");
			/*End*/
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			if (finalTermset == null)finalTermset = "";
			finalTermset=req.getParameter("final_termSet");	
			

			
			HashMap tabdata=new HashMap();
			//tabdata.put("diag_class_code",diag_class_code);
			tabdata.put("long_desc",long_desc);
			tabdata.put("short_desc",short_desc);
			tabdata.put("diag_class_type",diag_class_type);
			tabdata.put("eff_status",eff_status);
			/*Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012*/
			/*Start*/
			//tabdata.put("default_status",default_status);
			/*End*/
			//tabdata.put("term_set_id",termSetId);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("added_facility_id",facilityId);
			tabdata.put("added_facility_id",facilityId);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("modified_facility_id",facilityId );

			HashMap condflds=new HashMap();
			condflds.put("diag_class_code",diag_class_code);
			String hard_val="MR_DIAG_CLASS";
			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			 Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);



				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = tabdata;
				argArray[2] = condflds;
				argArray[3] = hard_val;

				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = tabdata.getClass();
				paramArray[2] = condflds.getClass();
				paramArray[3] = hard_val.getClass();

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				
				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;
				boolean inserted1=true;
				String defaulttermset	= req.getParameter("defaulttermset")==null ? "":req.getParameter("defaulttermset");
				String default_status	= "N";

		if ( inserted ){
				

		if (finalTermset == null)finalTermset = "";
		finalTermset=req.getParameter("final_termSet");
		StringTokenizer StrToken = new StringTokenizer(finalTermset,"@");

		sql1="delete from MR_DIAG_CLASS_DTL where diag_class_code='"+diag_class_code+"'";

		 pstmt1=con.createStatement();
		res1 = pstmt1.executeUpdate(sql1);
		StringTokenizer Strdefaulttermset = new StringTokenizer(defaulttermset,"|#|");
		ArrayList deftermset = new ArrayList();
		while(Strdefaulttermset.hasMoreTokens()){
			deftermset.add(Strdefaulttermset.nextToken());
		}

		while(StrToken.hasMoreTokens())						
		{
			termSet=StrToken.nextToken();
			if(!defaulttermset.equals("")){
				if(deftermset.contains(termSet)){
					default_status	= "Y";
				}else{
					default_status	= "N";
				}
			}
			if(!(termSet == null)&&!(termSet .equals("")))
			{	
				Sql="insert into MR_DIAG_CLASS_DTL(DIAG_CLASS_CODE,TERM_SET_ID,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,default_status) values ('"+diag_class_code+"','"+termSet+"','"+addedById+"',sysdate,'"+facilityId+"','"+addedAtWorkstation+"','"+modifiedById+"',sysdate,'"+modifiedAtWorkstation+"','"+facilityId+"','"+default_status+"')";
				res3 = pstmt.executeUpdate(Sql);
				if(res3 !=0){
					con.commit(); 
					inserted1 = true;
				}
				else{
					con.rollback();
				inserted1 = false;
				}

			}
		}
	}

	if ( inserted1 ){
	error_value = "1" ;
	out.println("<script>parent.onSuccess('true');</script>");
	}
	else
	{
		out.println("<script>parent.onSuccess('false');</script>");
	}
				if (pstmt != null)
					pstmt.close();
				if (pstmt1 != null)
					pstmt1.close();

					condflds.clear();
					results.clear();
					tabdata.clear();
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );			
}
		catch(Exception e){	
			e.printStackTrace();
	}
	finally{
		ConnectionManager.returnConnection(con,req);
	}	
}

}
