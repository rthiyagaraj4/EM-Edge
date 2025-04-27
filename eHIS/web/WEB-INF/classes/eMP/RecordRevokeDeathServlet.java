/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/****** Last Modified Date Time 9/22/2005 11:55 AM ******/
package eMP;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.naming.*;
import javax.rmi.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import com.ehis.util.*;

import eCommon.SingleTabHandler.*;

public class RecordRevokeDeathServlet extends HttpServlet 
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

		HttpSession session = req.getSession(false);
		Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = p.getProperty("LOCALE");
		PrintWriter out=null;
		Connection con = null;
		
		try 
		{

			out = res.getWriter();
			String Action = req.getParameter("Action")==null ? "Recoke_Patient_Death" : req.getParameter("Action");
			String Deceased_Date =req.getParameter("Deceased_Date")==null ? "" : req.getParameter("Deceased_Date");
			String isPatientEncRevokeDeathAppl =req.getParameter("isPatientEncRevokeDeathAppl")==null ? "false" : req.getParameter("isPatientEncRevokeDeathAppl"); // added by mujafar for ML-MMOH-CRF-1427
			String facilityID =  (String) session.getValue( "facility_id");
			String loginUSER =  p.getProperty( "login_user");
			String client_ip_add =  p.getProperty("client_ip_address");
			String patID = req.getParameter("Patient_Id")==null ? "" : req.getParameter("Patient_Id");
			boolean inserted_yn=true;
			String error_tmp="";
			
		
			
			if(!Deceased_Date.equals(""))
			{
			if(locale.equals("th"))
			{ 	
				Deceased_Date= DateUtils.convertDate(Deceased_Date,"DMYHM","th","en");
			}
			}
			StringTokenizer receivetoks = new StringTokenizer (Deceased_Date," ") ;
			StringTokenizer receivetok1 = new StringTokenizer (receivetoks.nextToken(), "/" ) ;
			String receiveArr[] =new String[3] ;
			for( int q=0;q<3;q++ )
				receiveArr[q] = receivetok1.nextToken() ;

			Deceased_Date = receiveArr[2] +"-"+receiveArr[1]+"-"+ receiveArr[0]+" "+receivetoks.nextToken()+":00"   ;
			
			
			Timestamp deceasedTimestamp= Timestamp.valueOf(Deceased_Date);
			String Deceased_Yn="";
			String active_yn="";
			String Death_Status_Remarks="";
			CallableStatement cs1 = null ;
			if(Action.equals("Record_Patient_Death")) {
				Deceased_Yn = "Y" ;
				active_yn = "N" ;
				Death_Status_Remarks = req.getParameter("Deceased_Remarks")==null ? "" : req.getParameter("Deceased_Remarks");
			}
			else {
				Deceased_Yn ="N" ;
				active_yn = "Y" ;
				Death_Status_Remarks = req.getParameter("Remarks_on_Revoking")==null ? "" : req.getParameter("Remarks_on_Revoking");
				Deceased_Date = "";
			}

			HashMap tabdata=new HashMap();
			String DeceasedDate2 = "";
			tabdata.put("active_yn",active_yn); 
			tabdata.put("deceased_yn",Deceased_Yn);
			if(Action.equals("Record_Patient_Death")) 
				tabdata.put("deceased_date",deceasedTimestamp );
			else
				tabdata.put("deceased_date",DeceasedDate2 );	
			tabdata.put("death_status_remarks",Death_Status_Remarks);

			tabdata.put("modified_by_id",p.getProperty( "login_user"));
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",(String) session.getValue( "facility_id"));
			tabdata.put("modified_at_ws_no",p.getProperty("client_ip_address"));
			
			con = ConnectionManager.getConnection(p);
			
			// below if block added by mujafar for ML-MMOH-CRF-1427
			if(isPatientEncRevokeDeathAppl.equals("true") && Action.equals("Revoke_Patient_Death"))
				
				{
				
				try{
			cs1=con.prepareCall("{call mp_encounter_revoke_death(?,?,?,?,?)}");	
			cs1.setString(1,facilityID);
			cs1.setString(2,patID);
			cs1.setString(3,loginUSER);
			cs1.setString(4,client_ip_add);
			cs1.registerOutParameter(5,java.sql.Types.VARCHAR);
			
			cs1.execute();
		
			
			error_tmp=cs1.getString(5);
			cs1.close();
			if(error_tmp == null) error_tmp="";
			
			 
			if(error_tmp.equals(""))
			{
				
				
			}
			else{
			inserted_yn = false;	
			}
			
			}
			catch(Exception e)
			{
			 e.printStackTrace();
 		     inserted_yn = false;
			 
				
			}				
					
					
					
					
					
				}
			
			
		
			
			
			if(inserted_yn)
			{
			HashMap condflds=new HashMap();
			condflds.put("patient_id",(req.getParameter("Patient_Id")==null ? "" : req.getParameter("Patient_Id")));

			

			cs1 = con.prepareCall("{call MP_AUDIT_FUNCTION.ASSIGN_VALUE('RECORD_REVOKE_PAT')}");
            cs1.execute();
			cs1.close();

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = "mp_patient";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			argArray = null;
			paramArray = null;
			tabdata.clear();
			condflds.clear();
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			results.clear();
			
		
			
			
			
		
			if ( inserted ){
				String error_num = " " ;
			 	res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + error_num + "&err_value=1");
			}else{
				 
				 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8") );
			}
			
		}
		else{
			
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error_tmp, "UTF-8") );
			
		}

		}
		catch (Exception e)	{
			/* out.println(e.getMessage());
			out.println(e.toString()); */
			e.printStackTrace();
		}
		finally
		{
			if (con!= null) ConnectionManager.returnConnection(con,p);
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
