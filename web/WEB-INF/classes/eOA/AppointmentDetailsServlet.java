/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
12/08/2011    IN027165       Chowminya   Incident No: IN027165 - <Future order linked orders reschedule - started date update issue> 										 
---------------------------------------------------------------------------------------------------------------
*/
package eOA ;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eOA.AppointmentDetails.*;
import java.net.URLEncoder;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public class AppointmentDetailsServlet extends javax.servlet.http.HttpServlet{  
    
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
    public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)throws javax.servlet.ServletException,IOException{
		PrintWriter out = null;       
		String operation="";
        try{
            out = res.getWriter();
			
            req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			req= new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
            operation = req.getParameter("function1");
    		out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/IeStyle.css'></link>");
    		out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'>");
    		out.println("async function callAppointmentDetailHTML() { ");

			if ( operation.equals("insert") ){
                insertAppointmentDetails(req,res); // cancellation
            }else if ( operation.equals("modify") ){
				modifyAppointmentDetails(req,res); // reschedule
            }else if( operation.equals("bulktransfer")){
				BulkTransfer(req,res) ;// Bulk Transfer
			}else if( operation.equals("BulkCancel")){
				BulkCancel(req,res) ;// Bulk Cancel
			}
			out.println("} callAppointmentDetailHTML();</script><body></body></html>");
		}catch (Exception e){
		
			//out.println("except="+e);
			e.printStackTrace();
		}finally{
		}
	}    

    
    private synchronized void insertAppointmentDetails(HttpServletRequest req, HttpServletResponse res)	{
     String apptrefno="",reasonforcancellation="",reasonforrevision="",rd_appt_yn="";
	  /* Removed Unused local variables by Munisekhar */ 
	 String patientid="",cancel_flag="",alcn_criteria="",pat_cat="",clinic_code="",visitind="",cancel_mode="",referral_value="",episode_type="",appt_date="",capture_fin_dtls_yn="",order_id1="",order_line_num="";
	 
	 //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	 String remarksForCancellation = ""; 
	 String remarksForRevision = ""; 
	 
		Connection 	con 	= null;
		 /* CheckStyle Violation Commented by Munisekhar */ 
		//ResultSet 	rs 		= null;
		//Statement 	stmt 	= null;
		//int 		total 	= 0;
		//int 		maxm 	= 0;
		String 		Forced	= "N";
		PrintWriter out 	= null;
		String operation="";
		java.util.Properties p =null;
		HttpSession session = req.getSession(false);
		p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		String client_ip_address = p.getProperty("client_ip_address");
		 /* CheckStyle Violation Commented by Munisekhar */ 
		//String locale = p.getProperty("LOCALE");
		String facilityId = (String) session.getAttribute( "facility_id" ) ;
		//Bru-HIMS CRF-169 changes start
		String patCnclCount=req.getParameter("pat_cncl_count")==null?"":req.getParameter("pat_cncl_count");
		String pat_cancel_reason=req.getParameter("pat_cancel_reason")==null?"":req.getParameter("pat_cancel_reason");
		String group_id=req.getParameter("group_id")==null?"":req.getParameter("group_id");
		//Bru-HIMS CRF-169 changes end
        try {
			out = res.getWriter();
			con = ConnectionManager.getConnection(req);
			operation = req.getParameter("function1");
			 /* CheckStyle Violation Commented by Munisekhar */ 
			//String specialty_desc_wait = "";
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			java.util.ArrayList passObjectsList = new java.util.ArrayList();
			String bl_operational	= (String)session.getValue("bl_operational");
			//String practitioner_id_local=(String)req.getParameter("practitioner_id");
			//String speciality_code=(String)req.getParameter("speciality_code");
			String send_email_yn=req.getParameter("send_email_yn");
			if(send_email_yn==null || send_email_yn.equals(""))
				send_email_yn="N";

            apptrefno=req.getParameter("appt_ref_no");
            cancel_mode=req.getParameter("mode");
            visitind=req.getParameter("visitind");
            reasonforcancellation=req.getParameter("reason_for_cancellation");
			reasonforrevision=req.getParameter("reason_code_revision");
				clinic_code=req.getParameter("clinic_code");
			
			rd_appt_yn =req.getParameter("rd_appt_yn")==null?"N":req.getParameter("rd_appt_yn");
			order_id1 =req.getParameter("order_id")==null?"":req.getParameter("order_id");
			order_line_num =req.getParameter("order_line_num")==null?"":req.getParameter("order_line_num");
			referral_value =req.getParameter("referral_value");
			if(referral_value ==null) referral_value="";
			cancel_flag=req.getParameter("cancel_flag");
            if ((cancel_flag==null)||(cancel_flag.equals("null"))) cancel_flag="";
           
            alcn_criteria=req.getParameter("pre_pat_alcn_criteria");
            Forced=req.getParameter("Forced");
            if(alcn_criteria==null || alcn_criteria.equals("null")) alcn_criteria="";
            pat_cat=req.getParameter("pre_pat_alcn_catg_code");

			patientid=req.getParameter("patientid");
			if(patientid == null) patientid="";

			episode_type=req.getParameter("episode_type");
			if(episode_type == null) episode_type="";

			appt_date=req.getParameter("appt_date");
			if(appt_date == null) appt_date="";

			capture_fin_dtls_yn=req.getParameter("capture_fin_dtls_yn");
			if(capture_fin_dtls_yn == null) capture_fin_dtls_yn="";
			
			/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
			remarksForCancellation = req.getParameter("other_remarks");
			if(remarksForCancellation == null) remarksForCancellation = "";

			remarksForRevision = req.getParameter("rev_other_remarks");
			if(remarksForRevision == null) remarksForRevision = "";
			/*End ML-MMOH-CRF-1114*/

	        String addedFacilityId=facilityId;
            String addedAtWorkstation=client_ip_address;
            java.util.HashMap passObjects = new java.util.HashMap(); 
			passObjects.put("addedFacilityId",addedFacilityId);
			passObjects.put("apptrefno",apptrefno);
			passObjects.put("visitind",visitind);
			passObjects.put("reasonforcancellation",reasonforcancellation);
			passObjects.put("reasonforrevision",reasonforrevision);
			passObjects.put("alcn_criteria",alcn_criteria);
			passObjects.put("pat_cat",pat_cat);
			passObjects.put("addedFacilityId",addedFacilityId);
			passObjects.put("addedAtWorkstation",addedAtWorkstation);
			passObjects.put("Forced",Forced);
			passObjects.put("referral_value",referral_value);
			passObjects.put("rd_appt_yn",rd_appt_yn);
			passObjects.put("patientid",patientid);
			passObjects.put("episode_type",episode_type);
			passObjects.put("appt_date",appt_date);
			passObjects.put("bl_operational",bl_operational);
			passObjects.put("capture_fin_dtls_yn",capture_fin_dtls_yn);
			passObjects.put("send_email_yn",send_email_yn);
			passObjects.put("order_id1",order_id1);
			passObjects.put("order_line_num",order_line_num);
			passObjects.put("operation",operation);
			passObjects.put("patCnclCount",patCnclCount);//changes for Bru-HIMS-CRF-169
			passObjects.put("pat_cancel_reason",pat_cancel_reason);//changes for Bru-HIMS-CRF-169
			passObjects.put("group_id",group_id);//changes for Bru-HIMS-CRF-169
			/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
			passObjects.put("remarksForCancellation",remarksForCancellation);
			passObjects.put("remarksForRevision",remarksForRevision);
			/*End ML-MMOH-CRF-1114*/
			passObjectsList.add(passObjects);

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AppointmentDetails",AppointmentDetailsHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = passObjectsList;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = passObjectsList.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertAppointmentDetails",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
            boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
            String error = (String) results.get("error") ;
			
            if ( inserted ) {

         /* CheckStyle Violation Commented by Munisekhar */ 
					//stmt=con.createStatement();
				/*String sql_oa_wait1="select SPECIALITY_CODE, facility_id, clinic_code, clinic_date, practitioner_id, nvl(total_slots_booked,0) total, nvl(max_patients_per_day,0) maxm from oa_clinic_schedule where facility_id = '"+addedFacilityId+"' and clinic_code = '"+clinic_code+"' and trunc(clinic_date) = to_date('"+new_date+"','dd/mm/yyyy') and practitioner_id = '"+practitioner_id+"'";

				rs=stmt.executeQuery(sql_oa_wait1);

				
				if(rs!=null)
				{
					if(rs.next())
					{
						total=rs.getInt("total");						 
						total = total+1;
						maxm=rs.getInt("maxm");						
						speciality_code=rs.getString("SPECIALITY_CODE");
					}
				}
				if(rs !=null) rs.close();				
				
/*				String spec_code_sql="select  SPECIALITY_CODE  from op_clinic where facility_id = '"+addedFacilityId+"' and clinic_code='"+clinic_code+"'";

			rs=stmt.executeQuery(spec_code_sql);

			if(rs !=null && rs.next())
			{
				speciality_code=rs.getString("SPECIALITY_CODE");
			}
			if(rs !=null) rs.close();*/
				/*if (total==maxm)
				{	*/			
				/*String sql_oa_wait="select SPECIALITY_DESC from pr_wait_list_vw where SPECIALTY_CODE='"+speciality_code+"' and facility_id='"+addedFacilityId+"' and WAIT_LIST_STATUS='O' ";
				System.out.println("sql_oa_wait in Cancel:"+sql_oa_wait);
				rs=stmt.executeQuery(sql_oa_wait);

				if(rs!=null && rs.next())
				{
					
						specialty_desc_wait=rs.getString("SPECIALITY_DESC");
						 if ((specialty_desc_wait==null)||(specialty_desc_wait.equals("null"))) specialty_desc_wait="";
					
				java.util.Hashtable message = MessageManager.getMessage(locale,"WAITLIST_AVA_SPECIALTY","OA");
			    String	message_display=((String) message.get("message"));
				message_display=message_display.replace("$",specialty_desc_wait);
				 
				out.println("<script>alert('"+message_display+"');</script>");
				out.println("<script>waitListCheck();</script>");
				
				 
				 }
				 if(rs !=null) rs.close();
				 //}			
				if(stmt !=null) stmt.close();*/


                if(cancel_mode!=null && cancel_mode.equals("cancelalone")){
					
                    //out.println("<script>parent.frames[0].onsuccess();</script>");
                	out.println("top.document.getElementById('dialog-body').contentWindow.frames[0].onsuccess();");
                }else{
					
                    //out.println("<script>parent.frames[0].onsuccess();</script>");
                	out.println("top.document.getElementById('dialog-body').contentWindow.frames[0].onsuccess();");

                }
            }
            else {
               error = (String) results.get("error") ;

                int x= error.indexOf("\n");

                if(x !=-1)
                    error= error.substring(0,x)+" "+ error.substring(x+2,error.length());
				
                out.println("alert('"+error.trim()+"');const dialogTag = parent.parent.document.getElementById('dialog_tag');dialogTag.close();");

	

            }
				
           results.clear();
           passObjects.clear();
        }
        catch ( Exception e ) { 	
          //  out.println( "<script>alert('Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : '"+e.toString()+"')</script>");
			e.printStackTrace();
        }finally{
			if (con != null){
				ConnectionManager.returnConnection(con,req);
			}
		}
        
    }//method
    
    private synchronized void modifyAppointmentDetails(HttpServletRequest req, HttpServletResponse res){
	String apptrefno="",reasonforcancellation="",reasonforrevision="",to_over_book_yn="",order_id1="";//Added orderid1 -[IN027165]--
	 /* Removed Unused local variables by Munisekhar */ 
	 String patientid="",resaddrl1="",resaddrl2="",resaddrl3="",resaddrl4="",postalcode="",contdata="",alcn_criteria="",pat_cat="",new_from_time="",new_to_time="",new_date="",old_date="",clinic_code="",practitioner_id="",overbooked_yn="",over_booked="",dateapd="",visitind="",time_table_type="",no_of_slots="",inpatient_yn="",team_id="",clinic_type="",res_type="",sec_resources_selected="",referral_value="",modified_date_time="",episode_type="",capture_fin_dtls_yn="",new_resource_class="",function_mode="";//Added for this incident ML-BRU-SCF-1602 [IN:055253]
	 
	 //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	 String remarksForCancellation = ""; 
	 String remarksForRevision = ""; 
	 String remarksForPractOverride = ""; 
	   
		Connection 			con 	= null;
		ResultSet 			rs 		= null;
		PreparedStatement 	pstmt 	= null;
		Statement 			stmt	= null;
		ArrayList  sec_resources	= null;
		String 		Forced	= "N";
		PrintWriter out 	= null;
		java.util.Properties p =null;
		HttpSession session = req.getSession(false);
		p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		String client_ip_address = p.getProperty("client_ip_address");
		String locale = p.getProperty("LOCALE");
		String facilityId = (String) session.getAttribute( "facility_id" ) ;
        try {
			out = res.getWriter();
			con = ConnectionManager.getConnection(req);
			 /* CheckStyle Violation Commented by Munisekhar */
			//String specialty_desc_wait = "";
			String rule_based_tr = req.getParameter("rule_based_tr")==null?"N":req.getParameter("rule_based_tr");
			String pract_override_reason = req.getParameter("pract_override_reason")==null?"":req.getParameter("pract_override_reason");
			String bl_operational	= (String)session.getValue("bl_operational");
			ArrayList passObjectsList=new ArrayList();
			String from_page="transferappt";
            patientid=req.getParameter("patientid");
            inpatient_yn=req.getParameter("inpatient_yn");
            if(inpatient_yn==null || inpatient_yn.equals("null")) inpatient_yn="";
            team_id=req.getParameter("team_id");
            if(team_id==null || team_id.equals("null")) team_id="";
            alcn_criteria=req.getParameter("alcn_criteria");
            if(inpatient_yn==null || inpatient_yn.equals("null")) inpatient_yn="";
            pat_cat=req.getParameter("alcn_catg_code");
            apptrefno=req.getParameter("appt_ref_no");
            new_from_time=req.getParameter("new_from_time");
            new_to_time=req.getParameter("new_to_time");
            new_date=req.getParameter("appt_date");
			order_id1=req.getParameter("order_id1");//--[IN027165]--
			//Added for this incident ML-BRU-SCF-1602 [IN:055253]
			new_resource_class=req.getParameter("new_resource_class")==null?"":req.getParameter("new_resource_class");
			function_mode=req.getParameter("function_mode")==null?"":req.getParameter("function_mode");
			String to_alcn_cat_code="";
			String entitlement_by_pat_cat_yn=req.getParameter("entitlement_by_pat_cat_yn")==null?"N":req.getParameter("entitlement_by_pat_cat_yn");
			String email_appl_yn=req.getParameter("email_appl_yn")==null?"N":req.getParameter("email_appl_yn");
			String email_appl_for_appt_wo_pid_yn=req.getParameter("email_appl_for_appt_wo_pid_yn")==null?"N":req.getParameter("email_appl_for_appt_wo_pid_yn");
			String slot_appt_ctrl=req.getParameter("slot_appt_ctrl")==null?"N":req.getParameter("slot_appt_ctrl");
			String to_clinic_alcn=req.getParameter("to_clinic_alcn")==null?"":req.getParameter("to_clinic_alcn");
			String transfer_alcn_yn=req.getParameter("transfer_alcn_yn")==null?"N":req.getParameter("transfer_alcn_yn");
			String tfr_alcn_override_yn=req.getParameter("tfr_alcn_override_yn")==null?"N":req.getParameter("tfr_alcn_override_yn");
			String to_pat_alcn_cat=req.getParameter("to_pat_alcn_cat")==null?"":req.getParameter("to_pat_alcn_cat");
			String send_email_yn=req.getParameter("send_email_yn");
			if(send_email_yn==null || send_email_yn.equals(""))
				send_email_yn="N";


			clinic_type=req.getParameter("clinic_type");
			res_type=req.getParameter("res_type");
			sec_resources_selected=req.getParameter("sec_sel222");
			  modified_date_time=req.getParameter("modified_date_time");
			if(modified_date_time ==null) modified_date_time="";

			episode_type=req.getParameter("episode_type");
			if(episode_type == null) episode_type="";

			capture_fin_dtls_yn=req.getParameter("capture_fin_dtls_yn");
			if(capture_fin_dtls_yn == null) capture_fin_dtls_yn="";
			sec_resources=new java.util.ArrayList();
			StringTokenizer sec_sel_st1 = new StringTokenizer(sec_resources_selected,"@");
			while(sec_sel_st1.hasMoreTokens()){
					String sec_sel_str1=sec_sel_st1.nextToken();
					StringTokenizer sec_sel_st2 = new StringTokenizer(sec_sel_str1,",");
					while(sec_sel_st2.hasMoreTokens()){
						String tmp=sec_sel_st2.nextToken();
						if(tmp.equals("*"))
							tmp="";
						sec_resources.add(tmp);
					}			
			}
			clinic_code=req.getParameter("clinic_code");
            practitioner_id=req.getParameter("practitioner_id");
            over_booked=req.getParameter("over_booked");
            dateapd=req.getParameter("dateapd");
            overbooked_yn=req.getParameter("overbooked_yn");
            old_date=req.getParameter("old_date");

            visitind=req.getParameter("visitind");
            to_over_book_yn=req.getParameter("to_over_book_yn");
            Forced=req.getParameter("Forced");
            if (to_over_book_yn==null)to_over_book_yn="";
   
            no_of_slots=req.getParameter("no_of_slots");
            if (no_of_slots==null)no_of_slots ="";
			
            reasonforcancellation=req.getParameter("reason_for_cancellation");
			reasonforrevision=req.getParameter("reason_code_revision");
			String patInsSelectYN=req.getParameter("patInsSelectYN")==null?"N":req.getParameter("patInsSelectYN");
			String procInsSelectYN=req.getParameter("procInsSelectYN")==null?"N":req.getParameter("procInsSelectYN");
			//Bru-HIMS CRF-169 changes start
			String patCnclCount=req.getParameter("pat_cncl_count")==null?"":req.getParameter("pat_cncl_count");
			String pat_cancel_reason=req.getParameter("pat_cancel_reason")==null?"0":req.getParameter("pat_cancel_reason");
			//Bru-HIMS CRF-169 changes end

			/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
			remarksForCancellation = req.getParameter("other_remarks");
			if(remarksForCancellation == null) remarksForCancellation = "";

			remarksForRevision = req.getParameter("rev_other_remarks");
			if(remarksForRevision == null) remarksForRevision = "";

			remarksForPractOverride = req.getParameter("ovr_other_remarks");
			if(remarksForPractOverride == null) remarksForPractOverride = "";
			/*End ML-MMOH-CRF-1114*/

			referral_value = req.getParameter("referral_value");
			if(referral_value ==null) referral_value="";
            time_table_type=req.getParameter("i_time_table_type");
            if(time_table_type !=null && time_table_type.equals("3")) {
                new_from_time=req.getParameter("From_timeval");
                new_to_time=req.getParameter("To_timeval");
            }
            contdata=req.getParameter("contactvals");
            resaddrl1="";
            resaddrl2="";
            resaddrl3="";
            resaddrl4="";
            postalcode="";
			resaddrl1=req.getParameter("resaddrl1");
			resaddrl2=req.getParameter("resaddrl2");
			resaddrl3=req.getParameter("resaddrl3");
			resaddrl4=req.getParameter("resaddrl4");
			postalcode=req.getParameter("postalcode");
            /*if(contdata == null) contdata="";
            if(contdata != " " || contdata != "") {
                contdata=java.net.URLDecoder.decode(contdata);
                StringTokenizer st = new StringTokenizer(contdata,"^");
                
                while(st.hasMoreTokens()) {
                    if (st.hasMoreTokens())
                        resaddrl1=st.nextToken();
                    if (st.hasMoreTokens())
                        resaddrl2=st.nextToken();
                    if (st.hasMoreTokens())
                        resaddrl3=st.nextToken();
                    if (st.hasMoreTokens())
                        resaddrl4=st.nextToken();
                    if (st.hasMoreTokens())
                        postalcode=st.nextToken();
                }

                if(resaddrl1.equals("||"))
                    resaddrl1 = "";
                if(resaddrl2.equals("||"))
                    resaddrl2 = "";
                if(resaddrl3.equals("||"))
                    resaddrl3 = "";
                if(resaddrl4.equals("||"))
                    resaddrl4 = "";
                if(postalcode.equals("||"))
                    postalcode = "";
                
                
            }
            else {
                resaddrl1="";
                resaddrl2="";
                resaddrl3="";
                resaddrl4="";
                postalcode="";
                
            }*/    
            if(resaddrl1 == null) resaddrl1="";
            if(resaddrl2 == null) resaddrl2="";
            if(resaddrl3 == null) resaddrl3="";
            if(resaddrl4 == null) resaddrl4="";
            if(postalcode == null) postalcode="";

            stmt=con.createStatement();
			//String speciality_code="";
			//String entitlement_by_pat_cat_yn="";
			String status_MP="";
			String pat_class="OP";
			String speciality_code=(String)req.getParameter("speciality_code");
			/*String spec_code_sql="select  SPECIALITY_CODE  from op_clinic where facility_id = '"+facilityId+"' and clinic_code='"+clinic_code+"'";
			rs=stmt.executeQuery(spec_code_sql);
			if(rs !=null && rs.next())
			{
				speciality_code=rs.getString("SPECIALITY_CODE");
			}*/

			//commented for PE
			/*if(rs !=null) rs.close();
			String sql_mp_param="select ENTITLEMENT_BY_PAT_CAT_YN from mp_param where module_id='MP'";
			rs=stmt.executeQuery(sql_mp_param);
			if(rs!=null){
				if(rs.next())
				{
					entitlement_by_pat_cat_yn=rs.getString("ENTITLEMENT_BY_PAT_CAT_YN");
				}
			}
			if(rs !=null) rs.close();*/

			if(transfer_alcn_yn.equals("Y") && tfr_alcn_override_yn.equals("Y")){
				//below lines modified by Kamatchi S for security issue against COMMON-ICN-0165
				//String stat_grp_sql="SELECT alcn_catg_code, max_patients, total_booked_patients,total_blocked_slots FROM oa_clinic_schedule_dtl WHERE clinic_date = TO_DATE ('"+new_date+"', 'dd/mm/yyyy') AND facility_id = '"+facilityId+"' AND clinic_code = '"+clinic_code+"' AND NVL (practitioner_id, 'X') = NVL ('"+practitioner_id+"', 'X') and MAX_PATIENTS!=(TOTAL_BOOKED_PATIENTS+TOTAL_BLOCKED_SLOTS) order by ALCN_CATG_CODE";
				String stat_grp_sql="SELECT alcn_catg_code, max_patients, total_booked_patients,total_blocked_slots FROM oa_clinic_schedule_dtl WHERE clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND facility_id = ? AND clinic_code = ? AND NVL (practitioner_id, 'X') = NVL (?, 'X') and MAX_PATIENTS!=(TOTAL_BOOKED_PATIENTS+TOTAL_BLOCKED_SLOTS) order by ALCN_CATG_CODE";
				if(rs!=null ) rs.close();
				pstmt=con.prepareStatement(stat_grp_sql);
				pstmt.setString(1, new_date);
				pstmt.setString(2, facilityId);
				pstmt.setString(3, clinic_code);
				pstmt.setString(4, practitioner_id);
				rs=pstmt.executeQuery();
				if(rs!=null && rs.next()){
					to_alcn_cat_code=rs.getString("alcn_catg_code");
				}
				/* CheckStyle Correction by Munisekhar */ 
				 if(rs!=null ) rs.close();
				 if(pstmt != null) pstmt.close();

			}
			if(tfr_alcn_override_yn!=null && tfr_alcn_override_yn.equals("N")){
				to_alcn_cat_code=to_pat_alcn_cat;
			}

            String	addedFacilityId=facilityId;
            String	addedAtWorkstation=client_ip_address;
			if(entitlement_by_pat_cat_yn.equals("Y") && !patientid.equals("")){
				try{
					pstmt=con.prepareStatement("select MP_ENTITLEMENT_VALIDATION(?,?,?,?,?,?,?,'') from dual");
					pstmt.setString(1,patientid);
					pstmt.setString(2,new_date);
					pstmt.setString(3,addedFacilityId);
					pstmt.setString(4,clinic_type);
					pstmt.setString(5,clinic_code);
					pstmt.setString(6,pat_class);
					pstmt.setString(7,speciality_code);
					rs=pstmt.executeQuery();
					if(rs != null){
						if(rs.next()){
							status_MP=rs.getString(1);
							if(status_MP == null) status_MP="";
						}
					}
					if(pstmt != null) pstmt.close();
					if(rs != null) rs.close();
				}catch(Exception e){ 	
					e.printStackTrace();
				}
			}
			HashMap patInstructionsMap=(java.util.HashMap)session.getAttribute("patInstructionsMap");
			HashMap prcInstructionMap=(java.util.HashMap)session.getAttribute("prcInstructionMap");
			session.removeAttribute("patInstructionsMap");
			session.removeAttribute("prcInstructionMap");
			if(patInsSelectYN.equals("N")){
				patInstructionsMap.clear();
			}
			if(procInsSelectYN.equals("N")){
				prcInstructionMap.clear();
			}
			
		   	java.util.HashMap passObjects = new java.util.HashMap(); 
			passObjects.put("addedFacilityId",addedFacilityId);
			passObjects.put("time_table_type",time_table_type);
			passObjects.put("apptrefno",apptrefno);
			passObjects.put("new_from_time",new_from_time);
			passObjects.put("new_to_time",new_to_time);
			passObjects.put("new_date",new_date);
			passObjects.put("clinic_code",clinic_code);
			passObjects.put("practitioner_id",practitioner_id);
			passObjects.put("over_booked",over_booked);
			passObjects.put("dateapd",dateapd);
			passObjects.put("overbooked_yn",overbooked_yn);
			passObjects.put("old_date",old_date);
			passObjects.put("visitind",visitind);
			passObjects.put("reasonforcancellation",reasonforcancellation);
			passObjects.put("reasonforrevision",reasonforrevision);
			passObjects.put("alcn_criteria",alcn_criteria);
			passObjects.put("pat_cat",pat_cat);
			passObjects.put("no_of_slots",no_of_slots);
			passObjects.put("resaddrl1",resaddrl1);
			passObjects.put("resaddrl2",resaddrl2);
			passObjects.put("resaddrl3",resaddrl3);
			passObjects.put("resaddrl4",resaddrl4);
			passObjects.put("postalcode",postalcode);
			passObjects.put("to_over_book_yn",to_over_book_yn);
			passObjects.put("addedFacilityId",addedFacilityId);
			passObjects.put("addedAtWorkstation",addedAtWorkstation);
			passObjects.put("inpatient_yn",inpatient_yn);
			passObjects.put("team_id",team_id);
			passObjects.put("Forced",Forced);
			passObjects.put("clinic_type",clinic_type);
			passObjects.put("res_type",res_type);
			passObjects.put("sec_resources",sec_resources);
			passObjects.put("referral_value",referral_value);
			passObjects.put("modified_date_time",modified_date_time);
			passObjects.put("episode_type",episode_type);
			passObjects.put("patientid",patientid);
			passObjects.put("bl_operational",bl_operational);
			passObjects.put("capture_fin_dtls_yn",capture_fin_dtls_yn);
			passObjects.put("speciality_code",speciality_code);
			passObjects.put("send_email_yn",send_email_yn);
			passObjects.put("to_clinic_alcn",to_clinic_alcn);
			passObjects.put("transfer_alcn_yn",transfer_alcn_yn);
			passObjects.put("to_pat_alcn_cat",to_pat_alcn_cat);
			passObjects.put("to_alcn_cat_code",to_alcn_cat_code);
			passObjects.put("patInstructionsMap",patInstructionsMap);	
			passObjects.put("prcInstructionMap",prcInstructionMap);	
			passObjects.put("slot_appt_ctrl",slot_appt_ctrl);	
			passObjects.put("email_appl_yn",email_appl_yn);	
			passObjects.put("email_appl_for_appt_wo_pid_yn",email_appl_for_appt_wo_pid_yn);	
			passObjects.put("order_id1",order_id1);	//--[IN027165]--
			passObjects.put("rule_based_tr",rule_based_tr);
			passObjects.put("pract_override_reason",pract_override_reason);
			passObjects.put("patCnclCount",patCnclCount);//changes for Bru-HIMS-CRF-169
			passObjects.put("pat_cancel_reason",pat_cancel_reason);//changes for Bru-HIMS-CRF-169
			passObjects.put("new_resource_class",new_resource_class);//Added for this incident ML-BRU-SCF-1602 [IN:055253]	
            passObjects.put("function_mode",function_mode);//Added for this incident ML-BRU-SCF-1602 [IN:055253]
			/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
            passObjects.put("remarksForCancellation",remarksForCancellation);
            passObjects.put("remarksForRevision",remarksForRevision);
            passObjects.put("remarksForPractOverride",remarksForPractOverride);
			/*End ML-MMOH-CRF-1114*/
		  
			passObjectsList.add(passObjects);

			if(entitlement_by_pat_cat_yn.equals("Y") && !patientid.equals("")){
				if(status_MP.equals("0")){
					boolean local_ejbs = false;
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
						local_ejbs = true;
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AppointmentDetails",AppointmentDetailsHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					Object argArray[] = new Object[2];
					argArray[0] = p;
					argArray[1] = passObjectsList;			

					Class [] paramArray = new Class[2];
					paramArray[0] = p.getClass();
					paramArray[1] = passObjectsList.getClass();

					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("modifyAppointmentDetails",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);			
					boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue());
					String error = (String) results.get("error") ;
					if(inserted){
						/*String sql_oa_wait="select SPECIALITY_DESC from pr_wait_list_vw where SPECIALTY_CODE='"+speciality_code+"' and facility_id='"+addedFacilityId+"' and WAIT_LIST_STATUS='O' ";
						System.out.println("sql_oa_wait in Transfer:"+sql_oa_wait);
						rs=stmt.executeQuery(sql_oa_wait);
						if(rs!=null && rs.next()){
							
								specialty_desc_wait=rs.getString("SPECIALITY_DESC");
								if ((specialty_desc_wait==null)||(specialty_desc_wait.equals("null"))) specialty_desc_wait="";
							
							java.util.Hashtable message = MessageManager.getMessage(locale,"WAITLIST_AVA_SPECIALTY","OA");
							String	message_display=((String) message.get("message"));
							message_display=message_display.replace("$",specialty_desc_wait);
							out.println("<script>alert('"+message_display+"');</script>");				 
						}
						if(rs !=null) rs.close();*/
						doOnlineReports(apptrefno, clinic_code, addedFacilityId,patientid,from_page,req,res,locale);
					}else{
						out.println("alert('APP-OA0019 Appointment is already booked');parent.window.returnValue='closed';parent.window.close(); ");
						error = (String) results.get("error") ;
						int x= error.indexOf("\n");
						if(x !=-1)
							error= error.substring(0,x)+" "+ error.substring(x+2,error.length());
							out.println("alert('" + error.trim()+ "')");
					}
					results.clear();
					passObjects.clear();
				}else if(status_MP.equals("1")){
					java.util.Hashtable message = MessageManager.getMessage(locale,"PAT_CAT_EXP","MP");
 					String msg = ((String) message.get("message"));
					out.println("alert('" +msg+ "');parent.window.close(); ");
				}else if(status_MP.equals("2")){
					java.util.Hashtable message = MessageManager.getMessage(locale,"LOC_NOT_ENTITLED","MP");
					String msg = ((String) message.get("message"));
					out.println("alert('" + msg+ "');parent.window.close(); ");
				}else if(status_MP.equals("3")){
					java.util.Hashtable message = MessageManager.getMessage(locale,"SPL_NOT_ENTITLED","MP");
					String msg = ((String) message.get("message"));
					out.println("alert('" + msg+ "');parent.window.close(); ");	
				}else if(status_MP.equals("4")){
					java.util.Hashtable message = MessageManager.getMessage(locale,"BDCL_NOT_ENTITLED","MP");
					String msg = ((String) message.get("message"));
					out.println("alert('" + msg+ "');parent.window.close(); ");
				}
			}else{
				boolean local_ejbs = false;
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
					local_ejbs = true;							

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AppointmentDetails",AppointmentDetailsHome.class,local_ejbs);

				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				
				Object argArray[] = new Object[2];
				argArray[0] = p;
				argArray[1] = passObjectsList;			

				Class [] paramArray = new Class[2];
				paramArray[0] = p.getClass();
				paramArray[1] = passObjectsList.getClass();			

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("modifyAppointmentDetails",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);			

				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
            
           
				if(inserted){
					/*String sql_oa_wait="select SPECIALITY_DESC from pr_wait_list_vw where SPECIALTY_CODE='"+speciality_code+"' and facility_id='"+addedFacilityId+"' and WAIT_LIST_STATUS='O' ";
					rs=stmt.executeQuery(sql_oa_wait);
					if(rs!=null && rs.next()){
					
						specialty_desc_wait=rs.getString("SPECIALITY_DESC");
						if ((specialty_desc_wait==null)||(specialty_desc_wait.equals("null"))) specialty_desc_wait="";
						
						java.util.Hashtable message = MessageManager.getMessage(locale,"WAITLIST_AVA_SPECIALTY","OA");
						String	message_display=((String) message.get("message"));
						message_display=message_display.replace("$",specialty_desc_wait);
						out.println("<script>alert('"+message_display+"');</script>");				 
					}
					if(rs !=null) rs.close();*/
                    doOnlineReports(apptrefno, clinic_code, addedFacilityId,patientid,from_page,req,res,locale);
                }else{
					out.println("alert('APP-OA0019 Appointment is already booked');parent.window.returnValue='closed';parent.window.close(); ");
					error = (String) results.get("error") ;
					int x= error.indexOf("\n");
					if(x !=-1)
						error= error.substring(0,x)+" "+ error.substring(x+2,error.length());
					out.println("alert('" + error.trim()+ "')");


					error = error.replaceAll("\"","");
					error = error.replaceAll("\n","");
					int error1 = error.indexOf("20098");
					int error2 = error.indexOf("20099");				

					if(error1 ==-1 && error2 ==-1){
						out.println("alert(\""+error.substring(0, error.length() )+"\" );parent.window.close();");				
					}else if(error2 ==-1 && error1 !=-1){
						java.util.Hashtable message = MessageManager.getMessage( locale,"OA0169","OA") ;
						String msg = ((String) message.get("message"));
						out.println("alert(\""+msg.substring(0, msg.length() - 4)+"\");parent.window.close();");
					}else if(error1 ==-1 ){
						java.util.Hashtable message = MessageManager.getMessage( locale,"OA0168","OA") ;
						String msg = ((String) message.get("message"));
						out.println("alert(\""+msg.substring(0, msg.length() - 4)+"\");parent.window.close();");
					}
				}
				if(stmt !=null) stmt.close();
				results.clear();
				passObjects.clear();
			}
        }catch ( Exception e ){ 	
            //out.println( "Exception Raised : " + e );
			e.printStackTrace();
           // out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
        }finally{
			if (con != null){
				ConnectionManager.returnConnection(con,req);
			}
		}
}//method

private synchronized void BulkTransfer(HttpServletRequest req, HttpServletResponse res){
/* Removed Unused local variables by Munisekhar */
String to_over_book_yn="",patientid="",sec_resources_selected="",capture_fin_dtls_yn="";
	Connection 			con 	= null;
	ResultSet 			rs 		= null;
	PreparedStatement 	pstmt 	= null;
	Statement 			stmt	= null;
	ArrayList  sec_resources	= null;
	PrintWriter out 	= null;
	java.util.Properties p =null;
	HttpSession session = req.getSession(false);
	p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
	String client_ip_address = p.getProperty("client_ip_address");
	String locale = p.getProperty("LOCALE");
	String facilityId = (String) session.getAttribute( "facility_id" ) ;
    try {
		out = res.getWriter();
		con = ConnectionManager.getConnection(req);		
		stmt=con.createStatement();
		ArrayList passObjectsList=new ArrayList();
		int listCount=0;
		int checkListCount=0;
		String bl_operational	= (String)session.getValue("bl_operational");
		String from_page="modifyappt";
		String entitlement_by_pat_cat_yn="";
		String status_MP="";
		String final_value=req.getParameter("final_value");
		String sec_resc_selec_final=req.getParameter("sec_resc_selec_final");
		if(sec_resc_selec_final==null) sec_resc_selec_final="";
		String speciality=req.getParameter("speciality");
		String from_speciality=req.getParameter("from_speciality");
		String locn_type=req.getParameter("locn_type");
		String new_date=req.getParameter("to_date");
		String old_date=req.getParameter("from_date");
		String clinic_code_to=req.getParameter("to_locn");
		String clinic_code_from=req.getParameter("from_locn");
		String to_res_class=req.getParameter("to_res_class");
		String practitioner_id=req.getParameter("to_resc");
		String from_resc=req.getParameter("from_resc");
		String time_table_type=req.getParameter("time_table_type");
		String reasonforrevision=req.getParameter("reason_code_revision");
		String appt_ref_num=req.getParameter("appt_ref_num");
		String email_appl_yn=req.getParameter("email_appl_yn");
	   if(email_appl_yn==null || email_appl_yn.equals(""))
			email_appl_yn="N";
		String email_appl_for_appt_wo_pid_yn=req.getParameter("email_appl_for_appt_wo_pid_yn");
		if(email_appl_for_appt_wo_pid_yn==null || email_appl_for_appt_wo_pid_yn.equals(""))
			email_appl_for_appt_wo_pid_yn="N";
		String Forced1="N";
		String team_id="";
		String inpatient_yn="";
		String visitind="";
		String	addedFacilityId=facilityId;
		String	addedAtWorkstation=client_ip_address;
		sec_resources_selected=req.getParameter("sec_sel222");
		String overbooked_yn="";	
		String episode_type=req.getParameter("episode_type");
		if(episode_type==null) episode_type="";
		capture_fin_dtls_yn=req.getParameter("capture_fin_dtls_yn");
		if(capture_fin_dtls_yn == null) capture_fin_dtls_yn="";
		String sql_mp_param="select ENTITLEMENT_BY_PAT_CAT_YN from mp_param where module_id='MP'";
		rs=stmt.executeQuery(sql_mp_param);
		if(rs!=null){
			if(rs.next()){
					entitlement_by_pat_cat_yn=rs.getString("ENTITLEMENT_BY_PAT_CAT_YN");
				}
		}
		if(rs !=null) rs.close();
		int cnt_next=0;
		//15451|10:30|11:00|29/03/2012 13:10|TB|SO00001928$15449|10:00|10:30|29/03/2012 13:10|TB|SO00001927
		StringTokenizer final_val = new StringTokenizer(final_value,"$");
		//int counter=final_val.countTokens();
		 while(final_val.hasMoreTokens()){
			String next_val=final_val.nextToken();
			StringTokenizer final_val1 = new StringTokenizer(next_val,"|");
			String apptrefno="";
			String new_from_time="";
			String new_to_time="";
			String patient_id="";
			String modified_date="";
			String forced_val="";
			String sec_final_value="";
			sec_resources=null;
			sec_resources=new java.util.ArrayList();
			while(final_val1.hasMoreTokens()){
				try{ 
				     
					apptrefno=final_val1.nextToken();
					
					new_from_time=final_val1.nextToken();
					
					new_to_time=final_val1.nextToken();
					
					modified_date=final_val1.nextToken();
				 
					forced_val=final_val1.nextToken();
						
					patient_id=final_val1.nextToken();
					
				
				
					if(patient_id.equals("DUMMY_PATINETID"))
						patient_id="";
					StringTokenizer sec_sel_st1 = new StringTokenizer(sec_resc_selec_final,"@");
					//int d_counter1=sec_sel_st1.countTokens();
					while(sec_sel_st1.hasMoreTokens()){
						String sec_sel_str1=sec_sel_st1.nextToken();
						StringTokenizer sec_sel_st2 = new StringTokenizer(sec_sel_str1,",");
						while(sec_sel_st2.hasMoreTokens()){
							String tmp=sec_sel_st2.nextToken();
							String tmp1=sec_sel_st2.nextToken();
							String tmp2=sec_sel_st2.nextToken();
							String tmp3=sec_sel_st2.nextToken();
							String tmp4=sec_sel_st2.nextToken();
							String tmp5=sec_sel_st2.nextToken();
							String tmp6=sec_sel_st2.nextToken();
							String tmp7=sec_sel_st2.nextToken();
							String tmp8=sec_sel_st2.nextToken();
							String tmp9=sec_sel_st2.nextToken();
							String tmp10=sec_sel_st2.nextToken();
							
							if(tmp9.equals(apptrefno)){
								sec_final_value=sec_final_value+sec_sel_str1+"@";
							}
							tmp="";
							tmp1="";
							tmp2="";
							tmp3="";
							tmp4="";
							tmp5="";
							tmp6="";
							tmp7="";
							tmp8="";
							tmp10="";
						}
					} 		
				}catch(Exception e){ 	
					e.printStackTrace();
				}		
				if(forced_val.equals("FR")){
					Forced1="Y";
				}else{
					Forced1="N";
				}
				if(forced_val.equals("OB")){
					overbooked_yn="Y";
				}else{
					overbooked_yn="N";
				}	
				if(new_from_time.equals(new_to_time)){
					to_over_book_yn="Y";
				}else{
					to_over_book_yn="N";
				}				
				java.util.HashMap passObjects = new java.util.HashMap(); 
				passObjects.put("addedFacilityId",addedFacilityId);
				passObjects.put("time_table_type",time_table_type);
				passObjects.put("apptrefno",apptrefno);
				passObjects.put("new_from_time",new_from_time);
				passObjects.put("new_to_time",new_to_time);
				passObjects.put("new_date",new_date);
				passObjects.put("clinic_code",clinic_code_to);
				passObjects.put("practitioner_id",practitioner_id);
				passObjects.put("over_booked","N");
				passObjects.put("dateapd",old_date);
				passObjects.put("overbooked_yn",overbooked_yn);
				passObjects.put("visitind",visitind);
				passObjects.put("reasonforrevision",reasonforrevision);
				passObjects.put("alcn_criteria","");
				passObjects.put("pat_cat","");
				passObjects.put("no_of_slots","");
				passObjects.put("resaddrl1","");
				passObjects.put("resaddrl2","");
				passObjects.put("resaddrl3","");
				passObjects.put("resaddrl4","");
				passObjects.put("postalcode","");
				passObjects.put("to_over_book_yn",to_over_book_yn);
				passObjects.put("addedFacilityId",addedFacilityId);
				passObjects.put("addedAtWorkstation",addedAtWorkstation);
				passObjects.put("from_bulk","Y");
				passObjects.put("inpatient_yn",inpatient_yn);
				passObjects.put("team_id",team_id);
				passObjects.put("Forced",Forced1);
				passObjects.put("clinic_type",locn_type);
				passObjects.put("res_type",to_res_class);
				passObjects.put("sec_resources",sec_resources);
				passObjects.put("referral_value","");
				passObjects.put("modified_date_time",modified_date);
				passObjects.put("forced_val",forced_val);
				passObjects.put("sec_final_value",sec_final_value);
				passObjects.put("episode_type",episode_type);
				passObjects.put("bl_operational",bl_operational);
				passObjects.put("capture_fin_dtls_yn",capture_fin_dtls_yn);
				passObjects.put("clinic_code_from",clinic_code_from);
				passObjects.put("from_speciality",from_speciality);
				passObjects.put("send_email_yn","Y");
				passObjects.put("email_appl_yn",email_appl_yn);
				passObjects.put("email_appl_for_appt_wo_pid_yn",email_appl_for_appt_wo_pid_yn);

				passObjectsList.add(passObjects);
				listCount++;
			
				if(entitlement_by_pat_cat_yn.equals("Y")&&!patient_id.equals("")){
					try{
						pstmt=con.prepareStatement("select MP_ENTITLEMENT_VALIDATION(?,?,?,?,?,?,?,'') from dual");
						pstmt.setString(1,patient_id);
						pstmt.setString(2,new_date);
						pstmt.setString(3,addedFacilityId);
						pstmt.setString(4,locn_type);
						pstmt.setString(5,clinic_code_to);
						pstmt.setString(6,to_res_class);
						pstmt.setString(7,speciality);
						rs=pstmt.executeQuery();
						if(rs != null){
							if(rs.next()){
								status_MP=rs.getString(1);
								if(status_MP == null) status_MP="";
							}
						}
						if(pstmt != null) pstmt.close();
						if(rs != null) rs.close();
		   
					}catch(Exception e){ 	

						e.printStackTrace();
					}
					if(status_MP.equals("0")){
						/*boolean local_ejbs = false;
						if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
							local_ejbs = true;			

						Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AppointmentDetails",AppointmentDetailsHome.class,local_ejbs);
						Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

						Object argArray[] = new Object[2];
						argArray[0] = p;
						argArray[1] = passObjects;			

						Class [] paramArray = new Class[2];
						paramArray[0] = p.getClass();
						paramArray[1] = passObjects.getClass();
						java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("modifyAppointmentDetails",paramArray)).invoke(busObj,argArray);

						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);			
	
						boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			            String error = (String) results.get("error") ;*/
            
						cnt_next++;
						checkListCount++;
			            /*if(inserted &&(counter==cnt_next)){
							//String error_value = "0" ;
							//  doOnlineReports(appt_ref_num, clinic_code_to, addedFacilityId,patientid,from_page,req,res);
							String order_by=""; doOnlineReports1(appt_ref_num,addedFacilityId,patientid,old_date,new_date,from_resc,practitioner_id,from_speciality,speciality,clinic_code_from,clinic_code_to,order_by,from_page,locn_type,req,res);
							//   out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\";parent.frames[1].onSuccess('true','6');</script>"); 
						}else if(!inserted){

							int x= error.indexOf("\n");
							
							if(x !=-1){
								//doOnlineReports(appt_ref_num, clinic_code_to, addedFacilityId,patientid,req,res);
								//error= error.substring(0,x)+" "+ error.substring(x+2,error.length());
								//out.println("<script>alert('"+error.trim()+"');parent.frames[1].onSuccess('true','6');</script>");
							}else{
								out.println("<script>parent.frames[1].onSuccess('false','1');</script>");
							}
						}
						results.clear();
						passObjects.clear();*/
					}else if(status_MP.equals("1")){
						out.println("parent.frames[1].onSuccess('false','5'); ");
					}else if(status_MP.equals("2")){
						out.println("parent.frames[1].onSuccess('false','4'); ");
						//res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode(msg) );
				  }else if(status_MP.equals("3")){
					  out.println("parent.frames[1].onSuccess('false','3'); ");	
				  }else if(status_MP.equals("4")){
					  out.println("parent.frames[1].onSuccess('false','2'); ");
				  }
			}else{
				checkListCount++;
				
				/*boolean local_ejbs = false;
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
					local_ejbs = true;				

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AppointmentDetails",AppointmentDetailsHome.class,local_ejbs);

				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);


				Object argArray[] = new Object[2];
				argArray[0] = p;
				argArray[1] = passObjects;			

				Class [] paramArray = new Class[2];
				paramArray[0] = p.getClass();
				paramArray[1] = passObjects.getClass();
				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("modifyAppointmentDetails",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				cnt_next++;
	            if(inserted && (counter==cnt_next)){
					// String error_value = "0" ;
					//  doOnlineReports(appt_ref_num, clinic_code_to, addedFacilityId,patientid,from_page,req,res);
					String order_by=""; doOnlineReports1(appt_ref_num,addedFacilityId,patientid,old_date,new_date,from_resc,practitioner_id,from_speciality,speciality,clinic_code_from,clinic_code_to,order_by,from_page,locn_type,req,res);
					//out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\";parent.frames[1].onSuccess('true','6');</script>"); 
			      
				}else if(!inserted){
		    		int x= error.indexOf("\n");
				   if(x !=-1){
					   // doOnlineReports(appt_ref_num, clinic_code_to, addedFacilityId,patientid,req,res);
					  // error= error.substring(0,x)+" "+ error.substring(x+2,error.length());
				      // out.println("<script>alert('"+error.trim()+"');parent.frames[1].onSuccess('false','6');</script>");
				   }else{
					   out.println("<script>parent.frames[1].onSuccess('false','1');</script>");
				   }
			    }
				if(stmt !=null) stmt.close();
				results.clear();
				passObjects.clear();*/
			}
			apptrefno="";
		}
		if(listCount!=checkListCount){
			break;
		}
	}

		
	if(listCount==checkListCount){

		boolean local_ejbs = false;
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AppointmentDetails",AppointmentDetailsHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
	
		Object argArray[] = new Object[2];
		argArray[0] = p;
		argArray[1] = passObjectsList;			
		Class [] paramArray = new Class[2];
		paramArray[0] = p.getClass();
		paramArray[1] = passObjectsList.getClass();
		
		
		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("modifyAppointmentDetails",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		
		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		
		String error = (String) results.get("error") ;
		if(inserted){ 
			String order_by=""; doOnlineReports1(appt_ref_num,addedFacilityId,patientid,old_date,new_date,from_resc,practitioner_id,from_speciality,speciality,clinic_code_from,clinic_code_to,order_by,from_page,locn_type,req,res,locale);
		}else if(!inserted){ 
			int x= error.indexOf("\n");
			
			if(x !=-1){
				out.println("parent.frames[1].onSuccess('false','1');");
		   }else{
			   //out.println("<script>parent.frames[1].onSuccess('false','1');</script>");
		   }
		}
	}
	if(stmt !=null) stmt.close();
 }catch(Exception e){ 	

	 e.printStackTrace();
  }finally{
	  if (con != null){
		  ConnectionManager.returnConnection(con,req);
	  }
  }
}//method

private synchronized void BulkCancel(HttpServletRequest req, HttpServletResponse res){
String apptrefno="",reasonforcancellation="",reasonforrevision="";
/* Removed Unused local variables by Munisekhar */
String patientid="",alcn_criteria="",pat_cat="",visitind="",referral_value="",episode_type="",appt_date="",capture_fin_dtls_yn="";
	Connection 	con 	= null;
	ResultSet 	rs 		= null;
	Statement 	stmt	= null;
	String 		Forced	= "N";
	PrintWriter out 	= null;
	String operation="";
	java.util.Properties p =null;
	HttpSession session = req.getSession(false);
	p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
	String client_ip_address = p.getProperty("client_ip_address");
    /* checkstyle report Commented by Munisekhar */ 
	//String locale = p.getProperty("LOCALE");
	String facilityId = (String) session.getAttribute( "facility_id" ) ;
    try {
		out = res.getWriter();
		con = ConnectionManager.getConnection(req);		
		operation = req.getParameter("function1");
		String bl_operational	= (String)session.getValue("bl_operational");
		stmt=con.createStatement();
		reasonforcancellation=req.getParameter("reason_for_cancellation");
		String function_id=req.getParameter("function_id");
		if(function_id ==null) function_id="";
		String from_part=req.getParameter("from_part");
		if(from_part ==null) from_part="";
		String final_value="";
		String capture_fin_dtls_yn_tmp="";
		String email_appl_yn="";
		String email_appl_for_appt_wo_pid_yn="";
		final_value=req.getParameter("final_value");
		String Bl_sql="select CAPTURE_FIN_DTLS_YN,EMAIL_APPL_YN,EMAIL_APPL_FOR_APPT_WO_PID_YN FROM oa_param where module_id='OA'";
		rs=stmt.executeQuery(Bl_sql);
		if(rs !=null && rs.next()){
			capture_fin_dtls_yn_tmp=rs.getString("CAPTURE_FIN_DTLS_YN");
			email_appl_yn=rs.getString("EMAIL_APPL_YN");
			email_appl_for_appt_wo_pid_yn=rs.getString("EMAIL_APPL_FOR_APPT_WO_PID_YN");
		}
		if(rs !=null) rs.close();
		if(bl_operational.equals("Y")){
			capture_fin_dtls_yn=capture_fin_dtls_yn_tmp;
		}
		alcn_criteria="";
		pat_cat="";
		String addedFacilityId=facilityId;
		String addedAtWorkstation=client_ip_address;
		//int cnt_next=0;
		java.util.ArrayList passObjectsList = new java.util.ArrayList();
		StringTokenizer final_val = new StringTokenizer(final_value,"$");
		int counter=final_val.countTokens();
		int counterCheck=0;
		while(final_val.hasMoreTokens()){
			java.util.HashMap passObjects = new java.util.HashMap();
			String next_val=final_val.nextToken();		
			StringTokenizer final_val1 = new StringTokenizer(next_val,"|");
			apptrefno="";
			referral_value="";
			episode_type="";
			appt_date="";
			Forced="N";
			visitind="";
			patientid="";			
			while(final_val1.hasMoreTokens()){
				apptrefno=final_val1.nextToken();
				referral_value=final_val1.nextToken();
				episode_type=final_val1.nextToken();
				appt_date=final_val1.nextToken();
				Forced=final_val1.nextToken();
				visitind=final_val1.nextToken();
				patientid=final_val1.nextToken();
				if(patientid.equals("dummy_patinetID")){
					patientid="";
				}	
				passObjects.put("addedFacilityId",addedFacilityId);
				passObjects.put("apptrefno",apptrefno);
				passObjects.put("visitind",visitind);
				passObjects.put("reasonforcancellation",reasonforcancellation);
				passObjects.put("reasonforrevision",reasonforrevision);
				passObjects.put("alcn_criteria",alcn_criteria);
				passObjects.put("pat_cat",pat_cat);
				passObjects.put("addedFacilityId",addedFacilityId);
				passObjects.put("addedAtWorkstation",addedAtWorkstation);
				passObjects.put("Forced",Forced);
				passObjects.put("referral_value",referral_value);
				passObjects.put("patientid",patientid);
				passObjects.put("episode_type",episode_type);
				passObjects.put("appt_date",appt_date);
				passObjects.put("bl_operational",bl_operational);
				passObjects.put("capture_fin_dtls_yn",capture_fin_dtls_yn);
				passObjects.put("email_appl_yn",email_appl_yn);
				passObjects.put("email_appl_for_appt_wo_pid_yn",email_appl_for_appt_wo_pid_yn);
				passObjects.put("operation",operation);
				passObjectsList.add(passObjects);
				counterCheck++;
				/*boolean local_ejbs = false;
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AppointmentDetails",AppointmentDetailsHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[2];
				argArray[0] = p;
				argArray[1] = passObjectsList;
				Class [] paramArray = new Class[2];
				paramArray[0] = p.getClass();
				paramArray[1] = passObjectsList.getClass();
				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertAppointmentDetails",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;*/
			}		
        }
		if(counterCheck==counter){
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AppointmentDetails",AppointmentDetailsHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = passObjectsList;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = passObjectsList.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertAppointmentDetails",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			
			
			String error = (String) results.get("error") ;
			
			if(inserted){
				if(!from_part.equals("")){
					error = (String) results.get("error") ;
					int x= error.indexOf("\n");
				

					if(x !=-1)
						error= error.substring(0,x)+" "+ error.substring(x+2,error.length());
					//out.println("<script>alert('"+error.trim()+"');parent.frames[2].onsuccess(true,true);</script>");
					out.println("parent.frames[2].onsuccess(true,true);");
				}else{
					
					error = (String) results.get("error") ;
					int x= error.indexOf("\n");
					
					if(x !=-1)
					   error= error.substring(0,x)+" "+ error.substring(x+2,error.length());
					//out.println("<script>alert('"+error.trim()+"');parent.frames[2].onsuccess(true,false);</script>");
				//out.println("<script>parent.frames[2].onsuccess(true,false);</script>");
				out.println("parent.frames[2].onsuccess(true,false,\""+error+"\");");
				}
			}else{
				error = (String) results.get("error") ;
				int x= error.indexOf("\n");
				if(x !=-1)
					error= error.substring(0,x)+" "+ error.substring(x+2,error.length());
				if(function_id.equals("")){
					out.println("alert('"+error.trim()+"');parent.window.close();");

				}else{
					if(!from_part.equals("")){
					//out.println("<script>alert('"+error.trim()+"');parent.frames[2].onsuccess(false,true);</script>");
					out.println("parent.frames[2].onsuccess(false,true);");
					}else{
						//out.println("<script>alert('"+error.trim()+"');parent.frames[2].onsuccess(false,false);</script>");
						/*error Added By Dharma on 25th Nov 2014 against HSA-SCF-0145 [IN:051698]*/
						out.println("parent.frames[2].onsuccess(false,false,\""+error+"\");");
					}
				}
			}
		}else{
			out.println("alert('Transaction Failed');parent.frames[2].onsuccess(false,false);");
		}
		passObjectsList.clear();
		if(stmt !=null) stmt.close();
	}catch(Exception e){ 	
		e.printStackTrace();
		//out.println( "<script>alert('Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : '"+e.toString()+"')</script>");
	} finally{
		if (con != null){
			  ConnectionManager.returnConnection(con,req);
		  }
	}	
}//method
private void doOnlineReports( String s, String s1, String s3, String s33,String from_page,HttpServletRequest req, HttpServletResponse res,String locale)throws ServletException, IOException, SQLException{
	String s4 = "select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = 'OA' AND REPORT_ID = 'OARAPSL' and language_id = '"+locale+"'";
    String s5 = s;
	String s6 = s1;
	String s9 = "";
	PrintWriter out 	= null;
	out = res.getWriter();
	if(s33==null || s33.equals("null") || s33.equals(""))
	s9="";
	else
	s9=s33;
	//s5=s5+"$";
	String s10 = "p_appt_ref_no,p_facility_id";
	String s11 = s5 + "," + s3;
	StringBuffer s12 = new StringBuffer("");
//	s12.append("<html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link>");
//	s12.append("</head><body class='message'>");
//	s12.append("<script language = 'JavaScript'>");
	s12.append("  var dialogHeight    = '45vh' ;");
	s12.append(" var dialogWidth = '65vw' ;");
	s12.append("var dialogTop = 58;");
	s12.append("  var arguments =   ''; ");
	//modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the Query String.
	/*In below line appt_no added by Venkatesh.S against 39756 on 02-may-2013*/
	s12.append("  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=TRANSFER_CANCEL_APPT&step=1&sqlString=" + URLEncoder.encode(s4,"UTF-8") + "&reportParamNames=" + s10 + "&reportParamValues=" + s11 + "&Patient_ID=" + s9 + "&dest_locn_type=C&dest_locn_code=" + s6 + "&appt_no="+s+"';");
	s12.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
	s12.append("  retVal            =  await top.window.showModalDialog(getUrl,arguments,features); ");
    //s12.append(" parent.frames[0].reportPrints(\""+s4+"\",\""+s10+"\",\""+s11+"\",\""+s9+"\",\""+s6+"\",\""+s+");");
	if(from_page.equals("transferappt")){
		s12.append("top.document.getElementById('dialog-body').contentWindow.frames[0].onsuccess1();  ");
	}else{
		s12.append("if (parent.frames[1] && typeof parent.frames[1].Onsuccess === 'function') { parent.frames[1].onSuccess('true','6'); }");
	}
    out.println(s12.toString());
	s12.setLength(0);
}  
private void doOnlineReports1(String appt_ref_num,String addedFacilityId,String patientid,String old_date,String new_date,String from_resc,String practitioner_id,String from_speciality,String speciality,String clinic_code_from,String clinic_code_to,String order_by,String from_page,String locn_type,HttpServletRequest req,HttpServletResponse res,String locale)throws ServletException, IOException, SQLException{
	PrintWriter out 	= null;
	out = res.getWriter();
    String sql_select = " select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = 'OA' AND REPORT_ID ='OARAPSL' and language_id = '"+locale+"'";
	order_by="APPT_DATE_TIME";
    String s_param= "p_appt_ref_no,p_facility_id,P_APPT_DATE_FROM,P_APPT_DATE_TO,P_PRACTITIONER_ID_FROM,P_PRACTITIONER_ID_TO,P_SPECIALTY_CODE_FROM,P_SPECIALTY_CODE_TO,P_LOCATION_CODE_FROM,P_LOCATION_CODE_TO,P_ORDER_BY";
    String s_param_values = appt_ref_num+ "," +addedFacilityId+ ","+old_date+ "," + new_date+ "," + from_resc+ "," + practitioner_id+"," + from_speciality +"," + speciality+","+clinic_code_from+","+clinic_code_to+","+order_by;
	StringBuffer s12=new StringBuffer();
//	s12 =s12.append( " <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link>");
//	s12 = s12.append("</head><body class='message'>");
//	s12 = s12.append("<script language = 'JavaScript'>");
	//s12 = s12.append(" callReportsPrint(sql_select,s_param,s_param_values,locn_type,clinic_code_to,appt_ref_num);");
	s12.append("  var dialogHeight    = '45vh' ;");
	s12.append(" var dialogWidth = '65vw' ;");
	s12.append("var dialogTop = 58;");
	s12 = s12.append("  var arguments =   ''; ");
	//modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the Query String.
	//In below line appt_ref_num added by Venkatesh.S against 39756 on 02-may-2013
	s12 = s12.append("  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=TRANSFER_CANCEL_APPT&step=1&sqlString=" + URLEncoder.encode(sql_select,"UTF-8") + "&reportParamNames=" + s_param + "&reportParamValues=" + s_param_values+ "&dest_locn_type="+locn_type+"&dest_locn_code="+clinic_code_to+"&appt_no="+appt_ref_num+"';");
	s12 = s12.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
	s12 = s12.append("  retVal           =   await window.showModalDialog(getUrl,arguments,features); ");
	//s12 =s12.append("parent.frames[1].reportPrints1(\""+sql_select+"\",\""+s_param+"\",\""+s_param_values+"\",\""+locn_type+"\",\""+clinic_code_to+"\",\""+appt_ref_num+"\");");
	s12.append("if (parent.frames[1] && ((typeof parent.frames[1].onSuccess === 'function') || typeof parent.frames[1].Onsuccess === 'function')){ parent.frames[1].onSuccess('true','6'); }");
	out.println(s12.toString());
	s12.setLength(0);

	}
   
}

 
