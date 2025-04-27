/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/****** Last Modified Date Time 9/22/2005 11:22 AM *****/
package eMP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;

import eCommon.SingleTabHandler.*;

public class MpAuditTrialParameter extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	
	String facilityId ;
	String client_ip_address ;
	String ModuleID;
	String Sex;
	String BirthDate;
	String LegalName;
	String AliasName;
	String Address;
	String OcpnEmpl;
	String Nationality;
	String SuspendReinstate;
	String InactiveActivate;
	String RecordRevoke;

	String ID1Type;
	String ID2Type;
	String ID3Type;
	String ID4Type;

	String FamilyLink_yn="";
	String Oraganization_mem_yn="";
	String Category_yn="";
	String NatId_yn = "";
	String BirthPlace_yn="";
	String pat_ser_grp_hist_yn="";
//added by N Munisekhar against Bru-HIMS-CRF-315 [IN036041]

	String old_file_no_yn="";
	
	// added by mujafar for ML-MMOH-CRF-0998 START
	
	String other_alt_no_yn="";
	String mar_status_yn = "";
	String residence_desc_yn="";
	String regn_date_time_yn="";
	String status_desc_yn="";
	String race_yn="";
	String religion_yn= "";
	String ethnicity_yn = "";
	String next_of_kin_hist_yn="";
	String first_notify_hist_yn="";
	
	// added by mujafar for ML-MMOH-CRF-0998

	//Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534
	String contact1_no_yn = "";
	String contact2_no_yn = "";

	HttpSession session;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();

			modifyAuditTrial(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();


			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;

			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/MPAuditTrialParameter.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	{	}
	}

	private void modifyAuditTrial(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			 ModuleID			= req.getParameter("module_id");
			 Sex					= req.getParameter("Sex_yn");
			 BirthDate			= req.getParameter("BirthDate_yn");
			 LegalName			= req.getParameter("LegalName_yn");
			 AliasName			= req.getParameter("AliasName_yn");
			 Address				= req.getParameter("Address_yn");
			 OcpnEmpl			= req.getParameter("OcpnEmpl_yn");
			 Nationality			= req.getParameter("Nationality_hist_yn");
			 SuspendReinstate	= req.getParameter("SuspendReinstate_yn");
			 InactiveActivate	= req.getParameter("InactiveActivate_yn");
			 RecordRevoke		= req.getParameter("RecordRevoke_yn");

			 ID1Type				=  req.getParameter("alt_id1_hist_yn");
			 ID2Type				=  req.getParameter("alt_id2_hist_yn");
			 ID3Type				=  req.getParameter("alt_id3_hist_yn");
			 ID4Type				=  req.getParameter("alt_id4_hist_yn");
			 //Newly added on 06/02/2006 by Shyam
             FamilyLink_yn			=  req.getParameter("FamilyLink_yn");
			 Oraganization_mem_yn			=  req.getParameter("Oraganization_mem_yn");
			 Category_yn			=  req.getParameter("Category_yn");
			 NatId_yn				=  req.getParameter("NatId_yn");
			 BirthPlace_yn			=  req.getParameter("BirthPlace_yn");
             pat_ser_grp_hist_yn=  req.getParameter("patseries_yn");
			 
			 // added by mujafar for ML-MMOH-CRF-0998 start
			 other_alt_no_yn    = req.getParameter("other_alt_no_yn");
			 mar_status_yn      = req.getParameter("mar_status_yn");
			 residence_desc_yn  = req.getParameter("residence_desc_yn");
			 regn_date_time_yn  = req.getParameter("regn_date_time_yn");
			 status_desc_yn  = req.getParameter("status_desc_yn");
			 race_yn     = req.getParameter("race_yn");
			 religion_yn  = req.getParameter("religion_yn");
			 ethnicity_yn  = req.getParameter("ethnicity_yn");
			 next_of_kin_hist_yn  = req.getParameter("next_of_kin_hist_yn");
			 first_notify_hist_yn  = req.getParameter("first_notify_hist_yn");
			 
			 // added by mujafar for ML-MMOH-CRF-0998 END
			
			 //Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534
			 contact1_no_yn  = req.getParameter("contact1_no_yn");
			 contact2_no_yn  = req.getParameter("contact2_no_yn");
			
        //modified by N Munisekhar against Bru-HIMS-CRF-315 [IN036041]

             old_file_no_yn=  req.getParameter("oldfileNo_yn");
			if ( pat_ser_grp_hist_yn== null )pat_ser_grp_hist_yn="N";
			if ( Sex == null )				Sex="N";
			if ( BirthDate == null )			BirthDate="N";
			if ( LegalName == null )		LegalName="N";
			if ( AliasName == null )		AliasName="N";
			if ( Address == null )			Address="N";
			if ( OcpnEmpl == null )		OcpnEmpl="N";
			if ( Nationality == null )		Nationality="N";
			if ( SuspendReinstate == null )	SuspendReinstate="N";
			if ( InactiveActivate == null )	InactiveActivate="N";
			if ( RecordRevoke == null )		RecordRevoke="N";
			if ( ID1Type == null )			ID1Type ="N";
			if ( ID2Type == null )			ID2Type="N";
			if ( ID3Type == null )			ID3Type="N";
			if ( ID4Type == null )			ID4Type="N";
			
			// added by mujafar for ML-MMOH-CRF-0998 START
			
	 if(other_alt_no_yn == null)  other_alt_no_yn="N";
	 if(mar_status_yn   == null)  mar_status_yn="N";
	  if(residence_desc_yn  == null)  residence_desc_yn="N";
	  if(regn_date_time_yn  == null)  regn_date_time_yn="N";
	  if(status_desc_yn  == null)  status_desc_yn="N";
	  if(race_yn  == null)  race_yn="N";
	  if(religion_yn  == null)  religion_yn="N";
	  if(ethnicity_yn  == null)  ethnicity_yn="N";
	  if(next_of_kin_hist_yn  == null)  next_of_kin_hist_yn="N";
	  if(first_notify_hist_yn  == null)  first_notify_hist_yn="N";
			
			
			
			
			// added by mujafar for ML-MMOH-CRF-0998 END

			//Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534
			if(contact1_no_yn == null)  contact1_no_yn = "N";
			if(contact2_no_yn == null)  contact2_no_yn = "N";
			
          //added by N Munisekhar against Bru-HIMS-CRF-315 [IN036041]

			if(old_file_no_yn==null)     old_file_no_yn="N";

			if ( FamilyLink_yn == null )			FamilyLink_yn="N";
			if ( Oraganization_mem_yn == null )		Oraganization_mem_yn="N";
			if ( Category_yn == null )			    Category_yn="N";
			if ( NatId_yn == null )					NatId_yn="N";
			if ( BirthPlace_yn == null )			BirthPlace_yn="N";

				String addedById = p.getProperty( "login_user" ) ;
				String modifiedById = addedById ;
				String modifiedFacilityId = facilityId ;
				String addedAtWorkstation=client_ip_address;
				String modifiedAtWorkstation = addedAtWorkstation ;

				HashMap tabdata=new HashMap();
				tabdata.put("SEX_HIST_YN",Sex);
				tabdata.put("BIRTH_DATE_HIST_YN",BirthDate);
				tabdata.put("LEGAL_NAME_HIST_YN",LegalName);
				tabdata.put("ALIAS_NAME_HIST_YN",AliasName);
				tabdata.put("ADDRESS_HIST_YN",Address);
				tabdata.put("OCPN_N_EMPL_HIST_YN",OcpnEmpl);
				tabdata.put("NATIONALITY_HIST_YN",Nationality);
				tabdata.put("SUSPEND_REINSTATE_HIST_YN",SuspendReinstate);
				tabdata.put("INACT_ACT_HIST_YN",InactiveActivate);
				tabdata.put("REC_REVOKE_DEATH_HIST_YN",RecordRevoke);
				tabdata.put("ALT_ID1_HIST_YN",ID1Type);
				tabdata.put("ALT_ID2_HIST_YN",ID2Type);
				tabdata.put("ALT_ID3_HIST_YN",ID3Type);
				tabdata.put("ALT_ID4_HIST_YN",ID4Type);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
				//Newly added on 06/02/2006 By shyam
				tabdata.put("FAMILY_LINK_HIST_YN",FamilyLink_yn );
				tabdata.put("ORG_MEMBER_HIST_YN",Oraganization_mem_yn );
				tabdata.put("PAT_CAT_HIST_YN",Category_yn );
				tabdata.put("NAT_ID_HIST_YN",NatId_yn );
				tabdata.put("BIRTH_PLACE_CODE_HIST_YN",BirthPlace_yn );
                                 tabdata.put("pat_ser_grp_hist_yn",pat_ser_grp_hist_yn);
                     //added by N Munisekhar against Bru-HIMS-CRF-315 [IN036041]

                                   tabdata.put("OLD_FILE_NO_YN",old_file_no_yn);
								   
				// added by mujafar for ML-MMOH-CRF-0998 START
				
				tabdata.put("other_alt_no_yn",other_alt_no_yn );
				tabdata.put("mar_status_yn",mar_status_yn );
				tabdata.put("residence_desc_yn",residence_desc_yn );
				tabdata.put("regn_date_time_yn",regn_date_time_yn );
				tabdata.put("status_desc_yn",status_desc_yn );
				tabdata.put("race_yn",race_yn );
				tabdata.put("religion_yn",religion_yn );
				tabdata.put("ethnicity_yn",ethnicity_yn );
				tabdata.put("next_of_kin_hist_yn",next_of_kin_hist_yn );
				tabdata.put("first_notify_hist_yn",first_notify_hist_yn );
			
				// added by mujafar for ML-MMOH-CRF-0998 END

				//Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534
				tabdata.put("contact1_no_yn",contact1_no_yn );
				tabdata.put("contact2_no_yn",contact2_no_yn );
				
				HashMap condflds=new HashMap();
				condflds.put("MODULE_ID",ModuleID);

				boolean local_ejbs = isLocalEJB();
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = tabdata;
				argArray[2] = condflds;
				argArray[3] = "MP_PARAM";

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
				tabdata.clear();
				condflds.clear();
				results.clear();
				if ( inserted )
				{
					 error_value = "1" ;
					 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
				}
				else
				{
					
					 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error, "UTF-8") );
				}	
				
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			//out.println( "Values sent are : <br>" ) ;
			//out.println( Sex+"  "+BirthDate+"  "+LegalName+"  "+AliasName+"  "+Address+"  "+OcpnEmpl+"  "+SuspendReinstate+"  "+InactiveActivate+"  "+RecordRevoke );
			e.printStackTrace(); // Added by lakshmanan for security issue ID 169517485 on 28-08-2023
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
