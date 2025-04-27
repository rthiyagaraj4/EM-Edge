/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE; 

import javax.naming.*;
import javax.ejb.*;
import javax.rmi.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.util.*;

import eAE.AEReviseVisit.*;

import eCommon.XSSRequestWrapper;

public class AEReviseVisitServlet extends HttpServlet implements SingleThreadModel{
	PrintWriter out;
	String facilityId; 
	String user_id;
	HttpSession session;
	Properties p;
	String client_ip_address;
	HashMap session_details = new HashMap();
	HashMap ae_escort_type = new HashMap();
	HashMap ae_rel_contacts = new HashMap();
 
	boolean inserted		= false;
	String mode;
	String referal_id =""; 
    String locale="";

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{

		res.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		req = new XSSRequestWrapper(req);
        res.addHeader("X-XSS-Protection", "1; mode=block");
        res.addHeader("X-Content-Type-Options", "nosniff");
		
		this.out = res.getWriter();
		try	{
			session 		= req.getSession(true);
			user_id 		= (String)session.getValue("login_user") ;
			this.facilityId	= (String) session.getValue( "facility_id" ) ;
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.client_ip_address = p.getProperty("client_ip_address");
			referal_id  =  req.getParameter("referal_id"); 
			if((referal_id==null) || (referal_id.equals("null")) || (referal_id=="") || (referal_id.equals(""))) 
			referal_id		="";
			mode 		=  req.getParameter("mode");
			mode 		= (mode == null)?"":mode;
		    locale			=   p.getProperty("LOCALE");
			if(mode.equalsIgnoreCase("ReviseVisit"))
				modifyReviseVisit(req,res);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void  modifyReviseVisit(HttpServletRequest req, HttpServletResponse res){
		try{  
			storeValues(req);
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AEReviseVisit",AEReviseVisitHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = ae_escort_type;
			argArray[2] = ae_rel_contacts;
			argArray[3] = session_details;
			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = ae_escort_type.getClass();
			paramArray[2] = ae_rel_contacts.getClass();
			paramArray[3] = session_details.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateAEReviseVisit",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			inserted = ( ((Boolean) results.get( "status" )).booleanValue()) ;
			String error = (String) results.get("error") ;
			ae_escort_type.clear();
			ae_rel_contacts.clear();
			session_details.clear();
			String error_value = "0" ;
			String function_name=req.getParameter("function_name");
			if ( inserted ) {
				error_value= "1";
                MessageManager mm=new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_MODIFIED", "SM") ;
				String msg = ((String) mesg.get("message"));	
				out.println("<script> alert('"+msg+"')</script>");
				out.println("<script>top.content.location.href='../eAE/jsp/AEReviseVisit.jsp?module_id=AE&function_id=AE_REVISE_VISIT&function_name="+function_name+"&function_type=F&menu_id=AE&access=NYYNN'</script>"); 
				mesg.clear();
			}  else   {
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			}
			results.clear(); 
		}catch ( Exception e )  {
			e.printStackTrace();
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}
	} // End of the modifyAEReviseVisit


	public void storeValues(HttpServletRequest req) {
		
		
		String isAENextofKinchngAppl = req.getParameter("isAENextofKinchngAppl"); // added by mujafar for ML-MMOH-CRF-0632
		String patient_id1_val       = req.getParameter("patient_id1_val"); // added by mujafar for ML-MMOH-CRF-0632
		
		String contact1_birth_date  = "";
		session_details.put("locale",locale);
		session_details.put("user_id",user_id);
		session_details.put("facility_id",facilityId);
		session_details.put("addedAtWorkstation",client_ip_address);
		ae_escort_type.put("referal_id",referal_id);
		ae_escort_type.put("e_town",req.getParameter("e_town")== null ?"":req.getParameter("e_town"));
		ae_escort_type.put("e_region",req.getParameter("e_region")== null ?"":req.getParameter("e_region"));
		ae_escort_type.put("e_area",req.getParameter("e_area")== null ?"":req.getParameter("e_area"));
		ae_escort_type.put("encounter_id",req.getParameter("encounter_id")== null ?"":req.getParameter("encounter_id"));
		ae_escort_type.put("notify_name",req.getParameter("notify_name")== null ?"":req.getParameter("notify_name"));
		ae_escort_type.put("empyr_contact_name",req.getParameter("empyr_contact_name")== null ?"":req.getParameter("empyr_contact_name"));
		ae_escort_type.put("m_area",req.getParameter("m_area")== null ?"":req.getParameter("m_area"));
		ae_escort_type.put("m_town",req.getParameter("m_town")== null ?"":req.getParameter("m_town"));
		ae_escort_type.put("m_region",req.getParameter("m_region")== null ?"":req.getParameter("m_region"));
		ae_escort_type.put("other_alt_id",req.getParameter("other_alt_id")== null ?"":req.getParameter("other_alt_id"));
		ae_escort_type.put("oth_alt_id",req.getParameter("oth_alt_id")== null ?"":req.getParameter("oth_alt_id"));
		ae_escort_type.put("nat_id_no",req.getParameter("nat_id_no")== null ?"":req.getParameter("nat_id_no"));
		ae_escort_type.put("name_of_escort",req.getParameter("name_of_escort")== null ?"":req.getParameter("name_of_escort"));
		ae_escort_type.put("mlc_details_val",req.getParameter("mlc_details_val")== null ?"":req.getParameter("mlc_details_val"));
		ae_escort_type.put("relation_val",req.getParameter("relation_val")== null ?"":req.getParameter("relation_val"));
		ae_escort_type.put("address_of_escort",req.getParameter("e_addr_line1")== null ?"":req.getParameter("e_addr_line1"));
		ae_escort_type.put("address_of_escort1",req.getParameter("e_addr_line2")== null ?"":req.getParameter("e_addr_line2"));
		ae_escort_type.put("address_of_escort2",req.getParameter("e_addr_line3")== null ?"":req.getParameter("e_addr_line3"));
		ae_escort_type.put("address_of_escort3",req.getParameter("e_addr_line4")== null ?"":req.getParameter("e_addr_line4"));
		ae_escort_type.put("m_postal_code",req.getParameter("m_postal_code")== null ?"":req.getParameter("m_postal_code"));
		ae_escort_type.put("next_country1",req.getParameter("next_country1")== null ?"":req.getParameter("next_country1"));
		ae_escort_type.put("ambulance_contact_no",req.getParameter("ambulance_contact_no")== null ?"":req.getParameter("ambulance_contact_no"));
		ae_escort_type.put("accompany_by",req.getParameter("accompany_by")== null ?"":req.getParameter("accompany_by"));
		ae_escort_type.put("motor_vehicle_reg_no",req.getParameter("motor_vehicle_reg_no")== null ?"":req.getParameter("motor_vehicle_reg_no"));
		ae_escort_type.put("arrival_remarks",req.getParameter("arrival_remarks")== null ?"":req.getParameter("arrival_remarks"));
		ae_rel_contacts.put("empyr_off_tel_no",req.getParameter("empyr_off_tel_no")== null ?"":req.getParameter("empyr_off_tel_no"));
		ae_rel_contacts.put("first_country_code",req.getParameter("first_country_code")== null ?"":req.getParameter("first_country_code"));
		ae_rel_contacts.put("empyr_eid",req.getParameter("empyr_eid")== null ?"":req.getParameter("empyr_eid"));
		ae_rel_contacts.put("res3_tel_no",req.getParameter("res3_tel_no")== null ?"":req.getParameter("res3_tel_no"));
		ae_rel_contacts.put("empyr_country_code",req.getParameter("empyr_country_code")== null ?"":req.getParameter("empyr_country_code"));
		ae_rel_contacts.put("employ_postal_code",req.getParameter("employ_postal_code")== null ?"":req.getParameter("employ_postal_code"));
		ae_rel_contacts.put("empyr_contact_name",req.getParameter("empyr_contact_name")== null ?"":req.getParameter("empyr_contact_name"));
		ae_rel_contacts.put("first_res_tel_no",req.getParameter("first_res_tel_no")== null ?"":req.getParameter("first_res_tel_no"));
		ae_rel_contacts.put("first_postal_code",req.getParameter("first_postal_code")== null ?"":req.getParameter("first_postal_code"));
		ae_rel_contacts.put("contact1_email_id",req.getParameter("contact1_email_id")== null ?"":req.getParameter("contact1_email_id"));
		ae_rel_contacts.put("first_job_title",req.getParameter("first_job_title")== null ?"":req.getParameter("first_job_title"));
		ae_rel_contacts.put("organization_name",req.getParameter("organization_name")== null ?"":req.getParameter("organization_name"));
		ae_rel_contacts.put("first_off_tel_no",req.getParameter("first_off_tel_no")== null ?"":req.getParameter("first_off_tel_no"));
		ae_rel_contacts.put("next_off_tel_no",req.getParameter("next_off_tel_no")== null ?"":req.getParameter("next_off_tel_no"));
		ae_rel_contacts.put("next_res_tel_no",req.getParameter("next_res_tel_no")== null ?"":req.getParameter("next_res_tel_no"));
		ae_rel_contacts.put("empl_area_code",req.getParameter("empl_area_code")== null ?"":req.getParameter("empl_area_code"));
		ae_rel_contacts.put("empl_town_code",req.getParameter("empl_town_code")== null ?"":req.getParameter("empl_town_code"));
		ae_rel_contacts.put("empl_region_code",req.getParameter("empl_region_code")== null ?"":req.getParameter("empl_region_code"));
		ae_rel_contacts.put("notify_area_code",req.getParameter("notify_area_code")== null ?"":req.getParameter("notify_area_code"));
		ae_rel_contacts.put("notify_town_code",req.getParameter("notify_town_code")== null ?"":req.getParameter("notify_town_code"));
		ae_rel_contacts.put("notify_region_code",req.getParameter("notify_region_code")== null ?"":req.getParameter("notify_region_code"));
		ae_rel_contacts.put("area_code_no",req.getParameter("area_code_no")== null ?"":req.getParameter("area_code_no"));
		ae_rel_contacts.put("town_code_no",req.getParameter("town_code_no")== null ?"":req.getParameter("town_code_no"));
		ae_rel_contacts.put("region_code_no",req.getParameter("region_code_no")== null ?"":req.getParameter("region_code_no"));
		ae_rel_contacts.put("contact1_email_id",req.getParameter("contact1_email_id")== null ?"":req.getParameter("contact1_email_id"));
		ae_rel_contacts.put("contact1_mob_tel_no",req.getParameter("contact1_mob_tel_no")== null ?"":req.getParameter("contact1_mob_tel_no"));
		ae_rel_contacts.put("contact1_new_nat_id_no",req.getParameter("contact1_new_nat_id_no")== null ?"":req.getParameter("contact1_new_nat_id_no"));
		ae_rel_contacts.put("occ_class",req.getParameter("occ_class")== null ?"":req.getParameter("occ_class"));
		ae_rel_contacts.put("occu_of_per_desc",req.getParameter("occu_of_per_desc")== null ?"":req.getParameter("occu_of_per_desc"));
		ae_rel_contacts.put("next_contact_relation",req.getParameter("next_contact_relation")== null ?"":req.getParameter("next_contact_relation"));
		ae_rel_contacts.put("contact2_nat_id_no",req.getParameter("contact2_nat_id_no")== null ?"":req.getParameter("contact2_nat_id_no"));
		ae_rel_contacts.put("notify_oth_alt_id_type",req.getParameter("notify_oth_alt_id_type")== null ?"":req.getParameter("notify_oth_alt_id_type"));
		ae_rel_contacts.put("contact2_mob_tel_no",req.getParameter("contact2_mob_tel_no")== null ?"":req.getParameter("contact2_mob_tel_no"));
		ae_rel_contacts.put("contact2_email_id",req.getParameter("contact2_email_id")== null ?"":req.getParameter("contact2_email_id"));
		ae_rel_contacts.put("relationship",req.getParameter("first_contact_relation")== null ?"":req.getParameter("first_contact_relation"));
		ae_rel_contacts.put("next_contact_name",req.getParameter("next_contact_name")== null ?"":req.getParameter("next_contact_name"));
		contact1_birth_date = req.getParameter("contact1_birth_date")== null ?"":req.getParameter("contact1_birth_date");
        contact1_birth_date = DateUtils.convertDate(contact1_birth_date,"DMY",locale,"en");
		ae_rel_contacts.put("contact1_birth_date",contact1_birth_date);
		ae_rel_contacts.put("next_name",req.getParameter("next_name")== null ?"":req.getParameter("next_name"));
		ae_rel_contacts.put("empl_name",req.getParameter("empl_name")== null ?"":req.getParameter("empl_name"));
		ae_rel_contacts.put("org_name",req.getParameter("org_name")== null ?"":req.getParameter("org_name"));
		ae_rel_contacts.put("notify_name",req.getParameter("notify_name")== null ?"":req.getParameter("notify_name"));
		ae_rel_contacts.put("next_job_title",req.getParameter("next_job_title")== null ?"":req.getParameter("next_job_title"));
		ae_rel_contacts.put("empl_job_title",req.getParameter("empl_job_title")== null ?"":req.getParameter("empl_job_title"));
		ae_rel_contacts.put("notify_job_title",req.getParameter("notify_job_title")== null ?"":req.getParameter("notify_job_title"));
		ae_rel_contacts.put("next_address",req.getParameter("next_address")== null ?"":req.getParameter("next_address"));
		ae_rel_contacts.put("next_country_code",req.getParameter("next_country_code")== null ?"":req.getParameter("next_country_code"));
		ae_rel_contacts.put("empl_address",req.getParameter("empl_address")== null ?"":req.getParameter("empl_address"));
		ae_rel_contacts.put("notify_address",req.getParameter("notify_address")== null ?"":req.getParameter("notify_address"));
		ae_rel_contacts.put("next_address1",req.getParameter("next_address1")== null ?"":req.getParameter("next_address1"));
		ae_rel_contacts.put("empl_address1",req.getParameter("empl_address1")== null ?"":req.getParameter("empl_address1"));
		ae_rel_contacts.put("notify_address1",req.getParameter("notify_address1")== null ?"":req.getParameter("notify_address1"));
		ae_rel_contacts.put("next_address2",req.getParameter("next_address2")== null ?"":req.getParameter("next_address2"));
		ae_rel_contacts.put("empl_address2",req.getParameter("empl_address2")== null ?"":req.getParameter("empl_address2"));
		ae_rel_contacts.put("notify_address2",req.getParameter("notify_address2")== null ?"":req.getParameter("notify_address2"));
		ae_rel_contacts.put("next_address3",req.getParameter("next_address3")== null ?"":req.getParameter("next_address3"));
		ae_rel_contacts.put("empl_address3",req.getParameter("empl_address3")== null ?"":req.getParameter("empl_address3"));
		ae_rel_contacts.put("notify_address3",req.getParameter("notify_address3")== null ?"":req.getParameter("notify_address3"));
		ae_rel_contacts.put("next_postal_code",req.getParameter("next_postal_code")== null ?"":req.getParameter("next_postal_code"));
		ae_rel_contacts.put("empl_postal_code",req.getParameter("empl_postal_code")== null ?"":req.getParameter("empl_postal_code"));
		ae_rel_contacts.put("notify_postal_code",req.getParameter("notify_postal_code")== null ?"":req.getParameter("notify_postal_code"));
		ae_rel_contacts.put("next_country",req.getParameter("next_country_code")== null ?"":req.getParameter("next_country_code"));
		ae_rel_contacts.put("empl_country",req.getParameter("empl_country")== null ?"":req.getParameter("empl_country"));
		ae_rel_contacts.put("empl_telephone_home",req.getParameter("empl_telephone_home")== null ?"":req.getParameter("empl_telephone_home"));
		ae_rel_contacts.put("notify_country",req.getParameter("notify_country")== null ?"":req.getParameter("notify_country"));
		ae_rel_contacts.put("next_telephone",req.getParameter("next_telephone")== null ?"":req.getParameter("next_telephone"));
		ae_rel_contacts.put("empl_telephone",req.getParameter("empl_telephone")== null ?"":req.getParameter("empl_telephone"));
		ae_rel_contacts.put("notify_telephone",req.getParameter("notify_telephone")== null ?"":req.getParameter("notify_telephone"));
		ae_rel_contacts.put("next_telephone_office",req.getParameter("next_telephone_office")== null ?"":req.getParameter("next_telephone_office"));
		ae_rel_contacts.put("empl_telephone_office",req.getParameter("notify_telephone_office")== null ?"":req.getParameter("notify_telephone_office"));
		ae_rel_contacts.put("first_telephone_office",req.getParameter("first_telephone_office")== null ?"":req.getParameter("first_telephone_office"));
		ae_rel_contacts.put("empl_fax_office",req.getParameter("empl_fax_office")== null ?"":req.getParameter("empl_fax_office"));
		ae_rel_contacts.put("notify_telephone_office",req.getParameter("empl_telephone_office")== null ?"":req.getParameter("empl_telephone_office"));
		ae_rel_contacts.put("empl_occupation",req.getParameter("occ_of_per")== null ?"":req.getParameter("occ_of_per"));
		ae_rel_contacts.put("empl_eid",req.getParameter("empl_eid")== null ?"":req.getParameter("empl_eid"));
		ae_rel_contacts.put("empl_status",req.getParameter("empyr_employment_status")== null ?"":req.getParameter("empyr_employment_status"));
		ae_rel_contacts.put("f_region",req.getParameter("f_region")== null ?"":req.getParameter("f_region"));
		ae_rel_contacts.put("f_area",req.getParameter("f_area")== null ?"":req.getParameter("f_area"));
		ae_rel_contacts.put("f_town",req.getParameter("f_town")== null ?"":req.getParameter("f_town"));
		ae_rel_contacts.put("e_town",req.getParameter("e_town")== null ?"":req.getParameter("e_town"));
		ae_rel_contacts.put("e_region",req.getParameter("e_region")== null ?"":req.getParameter("e_region"));
		ae_rel_contacts.put("e_area",req.getParameter("e_area")== null ?"":req.getParameter("e_area"));
		ae_rel_contacts.put("n_town",req.getParameter("n_town")== null ?"":req.getParameter("n_town"));
		ae_rel_contacts.put("n_region",req.getParameter("n_region")== null ?"":req.getParameter("n_region"));
		ae_rel_contacts.put("n_area",req.getParameter("n_area")== null ?"":req.getParameter("n_area"));
		ae_rel_contacts.put("next_addr_line1",req.getParameter("next_addr_line1")== null ?"":req.getParameter("next_addr_line1"));
		ae_rel_contacts.put("next_addr_line2",req.getParameter("next_addr_line2")== null ?"":req.getParameter("next_addr_line2"));
		ae_rel_contacts.put("next_addr_line3",req.getParameter("next_addr_line3")== null ?"":req.getParameter("next_addr_line3"));
		ae_rel_contacts.put("next_addr_line4",req.getParameter("next_addr_line4")== null ?"":req.getParameter("next_addr_line4"));
		ae_rel_contacts.put("first_addr_line4",req.getParameter("first_addr_line4")== null ?"":req.getParameter("first_addr_line4"));
		ae_rel_contacts.put("first_addr_line3",req.getParameter("first_addr_line3")== null ?"":req.getParameter("first_addr_line3"));
		ae_rel_contacts.put("first_addr_line2",req.getParameter("first_addr_line2")== null ?"":req.getParameter("first_addr_line2"));
		ae_rel_contacts.put("first_addr_line1",req.getParameter("first_addr_line1")== null ?"":req.getParameter("first_addr_line1"));
		ae_rel_contacts.put("employ_addr_line4",req.getParameter("employ_addr_line4")== null ?"":req.getParameter("employ_addr_line4"));
		ae_rel_contacts.put("employ_addr_line3",req.getParameter("employ_addr_line3")== null ?"":req.getParameter("employ_addr_line3"));
		ae_rel_contacts.put("employ_addr_line2",req.getParameter("employ_addr_line2")== null ?"":req.getParameter("employ_addr_line2"));
		ae_rel_contacts.put("employ_addr_line1",req.getParameter("employ_addr_line1")== null ?"":req.getParameter("employ_addr_line1"));
		
		ae_rel_contacts.put("isAENextofKinchngAppl",isAENextofKinchngAppl); // added by mujafar for ML-MMOH-CRF-0632
		ae_rel_contacts.put("patient_id1_val",patient_id1_val); // added by mujafar for ML-MMOH-CRF-0632
		
	
		
		
		

	}
} // End of the Class
