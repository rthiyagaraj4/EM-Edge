/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class AESpAssgnBedToTrtmtAreaServlet extends HttpServlet implements SingleThreadModel{
	PrintWriter out;
	String facilityId;
	HttpSession session;
	Properties p;
	String client_ip_address; 
	String clinic_code = "";
	String treatment_area_code = "";
	String status = "";
	String bay_no = "";
	String bay_type="";
	
	String spare_bays_yn="";
	String insert_table = "";
	String valid_values="";
	String n="";
    String locale="";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
 	    res.setContentType("text/html;charset=UTF-8");
		this.out = res.getWriter();
	
		try	{
			String modi=req.getParameter("modi")==null?"":req.getParameter("modi");
			session 			= req.getSession(true);
			this.facilityId = (String) session.getValue( "facility_id" ) ;
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			locale=p.getProperty("LOCALE");
			 
			 if(modi.equals("modi")) {
				modifyTreatAreaSer(req,res);	 
			} else {
				this.client_ip_address = p.getProperty("client_ip_address");
				clinic_code 					=  req.getParameter("clinic_code")==null?"":req.getParameter("clinic_code");
				treatment_area_code				=  req.getParameter("treatment_area_code")==null?"":req.getParameter("treatment_area_code");
				status = req.getParameter("status");
				if(status.equals("null"))
					status="A";

				insert_table = req.getParameter("insert_table")==null?"":req.getParameter("insert_table");
    				valid_values=req.getParameter("valid_values")==null?"":req.getParameter("valid_values");
				n=req.getParameter("n")==null?"":req.getParameter("n");
				if(n.equals("0") || n.equals(""))  {
					MessageManager mm=new MessageManager();
					final java.util.Hashtable mesg = mm.getMessage(locale, "NO_CHANGE_TO_SAVE", "Common") ;
					String msg = ((String) mesg.get("message"));	
					out.println("<script>alert('"+msg+"');parent.messageFrame.location='../eCommon/jsp/MstCodeError.jsp?err_num=';parent.frames(1).frames(1).location.reload();</script>");
				   mesg.clear();
				} else{
					modifyTreatmentArea(req,res);
				}
				  
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void modifyTreatAreaSer(HttpServletRequest req, HttpServletResponse res){
		try{
			clinic_code 					    =  req.getParameter("clinic_code")==null?"":req.getParameter("clinic_code");
			String clinic_desc 					=  req.getParameter("clinic_desc")==null?"":req.getParameter("clinic_desc");
			String trmt_code 					=  req.getParameter("trmt_code")==null?"":req.getParameter("trmt_code");
			String trmt_desc 					=  req.getParameter("trmt_desc")==null?"":req.getParameter("trmt_desc");
			bay_no 					            =  req.getParameter("bay_no")==null?"":req.getParameter("bay_no");
			String eff_status 					=  req.getParameter("eff_status")==null?"":req.getParameter("eff_status");
			String pseudo_bay 					=  req.getParameter("pseudo_bay")==null?"":req.getParameter("pseudo_bay");
			if(eff_status.equals("E")) {
				eff_status="E" ;
			} else {
				eff_status="D";
			}
			if(pseudo_bay.equals("Y")) {
				 pseudo_bay="Y" ;
			} else {
				pseudo_bay="N";
			}
	
			java.util.HashMap tabdata=new HashMap();
			tabdata.put("eff_status",eff_status);
		
			java.util.HashMap condflds=new HashMap();
			condflds.put("bed_no",bay_no);
			condflds.put("clinic_code",clinic_code);
			boolean local_ejbs = false;
			String tablename ="AE_BED_FOR_TRMT_AREA";

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tablename;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tablename.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String tablename1 ="op_clinic";
		
			java.util.HashMap tabdata2=new HashMap();
			tabdata2.put("long_desc",clinic_desc);
							
			java.util.HashMap condflds1=new HashMap();
			condflds1.put("clinic_code",clinic_code);

			argArray[0] = p; 
			argArray[1] = tabdata2;
			argArray[2] = condflds1;
			argArray[3] = tablename1;
		
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata2.getClass();
			paramArray[2] = condflds1.getClass();
			paramArray[3] = tablename1.getClass();


			java.util.HashMap results1 = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
	               
			boolean inserted1 = ( ((Boolean) results1.get( "status" )).booleanValue() ) ;
			String tablename2 ="ae_tmt_area_for_clinic";

			java.util.HashMap tabdata3=new HashMap();
			tabdata3.put("short_desc",trmt_desc );
							
			java.util.HashMap condflds2=new HashMap();
			condflds2.put("Treatment_area_code",trmt_code);

			argArray[0] = p; 
			argArray[1] = tabdata3;
			argArray[2] = condflds2;
			argArray[3] = tablename2;
		
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata3.getClass();
			paramArray[2] = condflds2.getClass();
			paramArray[3] = tablename2.getClass();
		   
			java.util.HashMap results2 = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			boolean inserted3 = ( ((Boolean) results2.get( "status" )).booleanValue() ) ;
		
			String error=(String)results2.get("error");
		 
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if(inserted1&&inserted3&&inserted) {
				String error_value="1";
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"	 ) + "&err_value=" + error_value );
			}
			tabdata.clear();
			condflds.clear();
			results.clear();
			tabdata2.clear();
			condflds1.clear();
			results1.clear();
			tabdata3.clear();
			condflds2.clear();
			results2.clear();

			} catch(Exception e) {
				e.printStackTrace();
		}
	}

	private void  modifyTreatmentArea(HttpServletRequest req, HttpServletResponse res){
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	
		Connection con;
		con = ConnectionManager.getConnection(p);
		
		String addedById			= p.getProperty( "login_user" ) ;
		String addedDate			= dateFormat.format( new java.util.Date() ) ;
		String modifiedById			= addedById ;
		String modifiedDate			= addedDate ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	=client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;
		String error="";
		String tokvalue="";
		String addeddate = dateFormat.format(new  java.util.Date());
		java.sql.Date added_date = java.sql.Date.valueOf(addeddate);
		StringTokenizer sttoks ;
		StringTokenizer sttoks1;
		//StringBuffer sql = new StringBuffer();
		//PreparedStatement ps=null;
		int i;
		sttoks	=  new StringTokenizer(valid_values, ",");
		int cnt = sttoks.countTokens();
		java.util.HashMap tabdata1=null;
		java.util.HashMap results =null;
		

		try{
			StringBuffer sql = new StringBuffer();
			sql.append(" select treatment_area_code,bed_no from ");
			sql.append(" ae_bed_for_trmt_area where treatment_area_code=? ");
			sql.append(" and bed_no=? and clinic_code=? ");
			PreparedStatement ps=con.prepareStatement(sql.toString());
			ResultSet rs2=null;
			
			for(i=0;i<cnt;i++) {      
				if (sttoks.hasMoreTokens())
					tokvalue = 	sttoks.nextToken();

				sttoks1 = new StringTokenizer(tokvalue,"$");
				int cntt=sttoks1.countTokens();

				for(int j=0;j<cntt;j++)  {
					if (sttoks1.hasMoreTokens())
						bay_no = sttoks1.nextToken();
					if (sttoks1.hasMoreTokens())
						 bay_type=sttoks1.nextToken();	
					if (sttoks1.hasMoreTokens())
						spare_bays_yn=sttoks1.nextToken();	
					if (insert_table.equals("Y")) {
						//StringBuffer sql = new StringBuffer();
						//sql.append(" select treatment_area_code,bed_no from ");
						//sql.append(" ae_bed_for_trmt_area where treatment_area_code=? ");
						//sql.append(" and bed_no=? and clinic_code=? ");
						//PreparedStatement ps=con.prepareStatement(sql.toString());
						//ps=con.prepareStatement(sql.toString());
						ps.setString(1,treatment_area_code);
						ps.setString(2,bay_no);
						ps.setString(3,clinic_code);
						//ResultSet rs2=ps.executeQuery();
						rs2=ps.executeQuery();
						if(rs2.next()) { 	}
						else {
							tabdata1=new HashMap();
							tabdata1.put("facility_Id",facilityId);
							tabdata1.put("clinic_code",clinic_code);
							tabdata1.put("treatment_area_code",treatment_area_code);
							tabdata1.put("bed_no",bay_no);
							tabdata1.put("pseudo_bed_yn",spare_bays_yn );
							tabdata1.put("occupying_patient_id","");
							tabdata1.put("occupied_until_date_time","");
							tabdata1.put("current_status","A");
							tabdata1.put("eff_status","E");
							tabdata1.put("added_by_id",addedById );
							tabdata1.put("added_date",added_date);
							tabdata1.put("added_at_ws_no",addedAtWorkstation);
							tabdata1.put("added_facility_id", addedFacilityId);
							tabdata1.put("modified_by_id",modifiedById);
							tabdata1.put("modified_date",modifiedDate);
							tabdata1.put("modified_at_ws_no",modifiedAtWorkstation); 
							tabdata1.put("modified_facility_id", modifiedFacilityId);
							tabdata1.put("reason_for_reserve","");
							tabdata1.put("bay_type_code",bay_type);
								
							String dupflds[]={};
					   		boolean local_ejbs = false;
							String tabName ="ae_bed_for_trmt_area";

							if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
                              
							Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
							Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
								
							Object argArray[] = new Object[4];
							argArray[0] =p;
							argArray[1] = tabdata1;
							argArray[2] = dupflds;
							argArray[3] = tabName;

							Class [] paramArray = new Class[4];
							paramArray[0] = p.getClass();
							paramArray[1] = tabdata1.getClass();
							paramArray[2] = dupflds.getClass();
							paramArray[3] = tabName.getClass();
					
							results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
							(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
							error=(String)results.get("error");
						}
						if(rs2!=null) rs2.close();
					}
				}//end of for loop
			}//end of outter for loop
			String error_value="1";
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8"	 ) + "&err_value=" + error_value );
			tabdata1.clear();
			results.clear();
			if(rs2!=null) rs2.close();
			if(ps!=null) ps.close();
			sql.delete(0,sql.length());
				
		}catch(Exception ee) { ee.printStackTrace();  }
		finally {
			if(con != null)  ConnectionManager.returnConnection(con,req);
		}
	}
}

		
		
		
		
		
		
		
		
		
		    
	 



