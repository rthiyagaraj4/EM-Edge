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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Date;

import java.io.PrintWriter;
import java.io.IOException;

import java.util.Properties;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import com.ehis.eslp.ServiceLocator;

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;

/**
 * @todo Class data members should be moved to method level scope
 */
public class ContactReasonServlet extends HttpServlet{
	PrintWriter out;
	Properties p;
	String contact;
	String reason;
    String reason_for_recall_yn   ;
	String visit_registration_yn   ;
	String cancel_visit_yn         ;
	String book_appointment_yn     ;
	String transfer_appointment_yn ;
	String cancel_appointment_yn   ;
	String lift_schedule_yn        ;
	String patient_depart_yn="";
	String block_schedule_yn       ;
	String cancel_schedule_yn      ;
	String transfer_schedule_yn    ;
	String revise_visit_yn    ;
	String reason_for_referral_yn ;
   	String cancel_booking_yn="";
   	String cancel_admission_yn="";
   	String cancel_discharge_advice_yn="";
	String reason_for_revise_bkg_yn=""; 
	String cancel_transfer_yn=""; 
	String REGISTER_ATTENDANCE_YN=""; 
    String followup_of_referral_yn="";
	String rejection_of_referral_yn="";
	String effectiveStatus ;
	String facilityId ;
	String client_ip_address ;
	String cancel_wait_list_yn="";
    String modify_wait_list_yn="";	
	String cancel_discharge_yn = "";
	String late_discharge_reason_yn="";//added for the CRF - Bru-HIMS-CRF-157
	String CANCEL_AE_CHECKOUT_YN="";
	String REVERT_MO_RELEASE_YN="";
	String CANCEL_OP_CHECKOUT_YN="";
	String pract_override_reason_yn="";
	String trans_exceed_reason_yn="";
	//String emergency_transfer_yn="";
	String CHANGE_ADMISSION_DTLS_YN="";
	String CANCEL_EMBALM_YN="";  // Against Bru-HIMS-CRF-348 [IN:038247] By Saanthaakumar
	String cancelMedRequestYn = ""; //Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719
	String rejectRequest_mrp_yn = ""; //Added by mujafar for ML-MMOH-CRF-0713
	String rejectReport_mrp_yn = ""; //Added by mujafar for ML-MMOH-CRF-0714
	
	//Below line added for this CRF ML-MMOH-RF-0566
	String reject_referral_reason_yn="";
    String cancel_referral_reason_yn="";
	//End thsi CRF ML-MMOH-CRF-0566
    
    /* Added by lakshmanan for ML-MMOH-CRF-1955 on 01-07-2023 start*/
    String mark_nonmlc_yn="";
    String mark_mlc_yn="";
    /* Added by lakshmanan for ML-MMOH-CRF-1955 on 01-07-2023 start*/
	String external_appl_reason_yn = ""; //Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1

	String UNIT_TRANSFER_REASON_YN = ""; //Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
	String BARCODE_SCANNING_YN = "";//Added for MMS-DM-CRF-0157 on 26-MAR-2020 By KAMATCHI S
	/*Added By Dharma on 10th Mar 2020 against ML-MMOH-CRF-1473 Start*/
	   String rejected_to_mrd_by_pract_yn = "";
	   String return_to_hod_by_pract_yn	= "";
	/*Added By Dharma on 10th Mar 2020 against ML-MMOH-CRF-1473 End*/
	   
	   String cancel_For_admission_yn="";
	   String REASON_BIOMETRIC_REJECTION_YN="";
	   
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{

		session = req.getSession(false);		
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		/*serviceURL=(String) session.getValue("serviceURL");
		objectName="/test/SingleTabHandlerManager";*/

		try{
			res.setContentType("text/html");
			this.out = res.getWriter();
			String operation = req.getParameter("function");

			if ( operation.equals("insert") )   insertContactReason(req);
			if ( operation.equals("modify"))    modifyContactReason(req, res);
		}catch(Exception e){
			out.println(e.toString());
			e.printStackTrace();
		}
	}

	/*public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		try
		{
			this.out = res.getWriter();
			res.setContentType("text/html");
			out.println(" ");
		}
		catch(Exception e)	{	}
	}*/

	private void modifyContactReason(HttpServletRequest req, HttpServletResponse res){
		try{			
			
			contact =req.getParameter("contact_reason_code");
			reason = req.getParameter("contact_reason");
			effectiveStatus = req.getParameter("eff_status");
			visit_registration_yn   =(req.getParameter("visit_registration_yn"	)==null)?"N"	:req.getParameter("visit_registration_yn");
			cancel_visit_yn         =(req.getParameter("cancel_visit_yn"		)==null)?"N"	:req.getParameter("cancel_visit_yn");
			REGISTER_ATTENDANCE_YN  = (req.getParameter("REGISTER_ATTENDANCE_YN")==null)? "N"	:req.getParameter("REGISTER_ATTENDANCE_YN");
			book_appointment_yn     =(req.getParameter("book_appointment_yn"	)==null)?"N"	:req.getParameter("book_appointment_yn");
			transfer_appointment_yn =(req.getParameter("transfer_appointment_yn")==null)?"N"	:req.getParameter("transfer_appointment_yn");
			cancel_appointment_yn   =(req.getParameter("cancel_appointment_yn"	)==null)?"N"	:req.getParameter("cancel_appointment_yn");
			lift_schedule_yn        =(req.getParameter("lift_schedule_yn"		)==null)?"N"	:req.getParameter("lift_schedule_yn");
			block_schedule_yn       =(req.getParameter("block_schedule_yn"		)==null)?"N"	:req.getParameter("block_schedule_yn");
			cancel_schedule_yn      =(req.getParameter("cancel_schedule_yn"		)==null)?"N"	:req.getParameter("cancel_schedule_yn");
			transfer_schedule_yn    =(req.getParameter("transfer_schedule_yn"	)==null)?"N"	:req.getParameter("transfer_schedule_yn");
			revise_visit_yn		    =(req.getParameter("revise_visit_yn"		)==null)?"N"	:req.getParameter("revise_visit_yn");
			reason_for_recall_yn	    =(req.getParameter("reason_for_recall_yn"		)==null)?"N"	:req.getParameter("reason_for_recall_yn");
			patient_depart_yn	    =(req.getParameter("patient_depart_yn"		)==null)?"N"	:req.getParameter("patient_depart_yn");
			reason_for_referral_yn  =req.getParameter("reason_for_referral_yn" );
			if(reason_for_referral_yn == null)	reason_for_referral_yn = "N";
			if(reason_for_referral_yn.equals("")) reason_for_referral_yn="N" ;
            followup_of_referral_yn  =req.getParameter("followup_of_referral_yn1" );
			if(followup_of_referral_yn == null)	followup_of_referral_yn = "N";
			if(followup_of_referral_yn.equals("")) followup_of_referral_yn="N" ;
  		    rejection_of_referral_yn  =req.getParameter("rejection_of_referral_yn1" );
			if(rejection_of_referral_yn == null)	rejection_of_referral_yn = "N";
			if(rejection_of_referral_yn.equals("")) rejection_of_referral_yn="N" ;
			cancel_booking_yn		    =(req.getParameter("cancel_booking_yn"		)==null)?"N"	:req.getParameter("cancel_booking_yn");
			cancel_admission_yn		    =(req.getParameter("cancel_admission_yn"		)==null)?"N"	:req.getParameter("cancel_admission_yn");
			cancel_discharge_advice_yn		    =(req.getParameter("cancel_discharge_advice_yn"		)==null)?"N"	:req.getParameter("cancel_discharge_advice_yn");
			reason_for_revise_bkg_yn     =req.getParameter("reason_for_revise_bkg_yn");
			// added on Jun 20 2005
			cancel_wait_list_yn=req.getParameter("cancel_wait_list_yn");

			cancel_discharge_yn		    =(req.getParameter("cancel_discharge_yn"		)==null)?"N"	:req.getParameter("cancel_discharge_yn");

			if(cancel_wait_list_yn==null || (cancel_wait_list_yn.equals("null")))
				cancel_wait_list_yn="N";
			modify_wait_list_yn=req.getParameter("modify_wait_list_yn1");
			if(modify_wait_list_yn==null || (modify_wait_list_yn.equals("null")))
				modify_wait_list_yn="N";
			if(reason_for_revise_bkg_yn == null)
				reason_for_revise_bkg_yn = "N";	
			if(reason_for_revise_bkg_yn.equals(""))
				reason_for_revise_bkg_yn = "N";
			cancel_transfer_yn     =req.getParameter("cancel_transfer_yn");
			if(cancel_transfer_yn == null)
				cancel_transfer_yn = "N";	
			if(cancel_transfer_yn.equals(""))
				cancel_transfer_yn = "N";
			if(cancel_discharge_yn.equals(""))
				cancel_discharge_yn = "N";
			if ( effectiveStatus == null )
				effectiveStatus="D";

			CANCEL_OP_CHECKOUT_YN   =(req.getParameter("CANCEL_OP_CHECKOUT_YN")==null)?"N"		:req.getParameter("CANCEL_OP_CHECKOUT_YN");
			CANCEL_AE_CHECKOUT_YN   =(req.getParameter("CANCEL_AE_CHECKOUT_YN")==null)?"N"		:req.getParameter("CANCEL_AE_CHECKOUT_YN");
			REVERT_MO_RELEASE_YN   =(req.getParameter("REVERT_MO_RELEASE_YN")==null)?"N"	:req.getParameter("REVERT_MO_RELEASE_YN");
			// Against Bru-HIMS-CRF-348 [IN:038247] By Saanthaakumar
			CANCEL_EMBALM_YN   =(req.getParameter("CANCEL_EMBALM_YN")==null)?"N"	:req.getParameter("CANCEL_EMBALM_YN");
			
			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			external_appl_reason_yn = (req.getParameter("external_appl_reason_yn")==null)?"N":req.getParameter("external_appl_reason_yn");

			//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
			UNIT_TRANSFER_REASON_YN = (req.getParameter("UNIT_TRANSFER_REASON_YN")==null)?"N":req.getParameter("UNIT_TRANSFER_REASON_YN");
			//Added for MMS-DM-CRF-0157 on 26-MAR-2020 By KAMATCHI S
			BARCODE_SCANNING_YN = (req.getParameter("BARCODE_SCANNING_YN")==null)?"N":req.getParameter("BARCODE_SCANNING_YN");
			/*Added By Dharma on 10th Mar 2020 against ML-MMOH-CRF-1473 Start*/
			rejected_to_mrd_by_pract_yn = (req.getParameter("rejected_to_mrd_by_pract_yn")==null || req.getParameter("rejected_to_mrd_by_pract_yn")=="")?"N":req.getParameter("rejected_to_mrd_by_pract_yn");
			return_to_hod_by_pract_yn = (req.getParameter("return_to_hod_by_pract_yn")==null || req.getParameter("return_to_hod_by_pract_yn")=="")?"N":req.getParameter("return_to_hod_by_pract_yn");
			/*Added By Dharma on 10th Mar 2020 against ML-MMOH-CRF-1473 End*/
			
			cancelMedRequestYn  =(req.getParameter("cancel_med_request_yn")==null || req.getParameter("cancel_med_request_yn")=="")? "N" : req.getParameter("cancel_med_request_yn");//Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719
			rejectRequest_mrp_yn=(req.getParameter("rejectRequest_mrp_yn")==null || req.getParameter("rejectRequest_mrp_yn")=="")?"N":req.getParameter("rejectRequest_mrp_yn");//Added by Mujafar for ML-MMOH-CRF-0713
			rejectReport_mrp_yn=(req.getParameter("rejectReport_mrp_yn")==null || req.getParameter("rejectReport_mrp_yn")=="")?"N":req.getParameter("rejectReport_mrp_yn");//Added by Mujafar for ML-MMOH-CRF-0714
			//Below line added for this CRF ML-MMOH-CRF-0566
			reject_referral_reason_yn=(req.getParameter("reject_referral_reason_yn")==null || req.getParameter("reject_referral_reason_yn")=="")? "N" : req.getParameter("reject_referral_reason_yn");
			cancel_referral_reason_yn=(req.getParameter("cancel_referral_reason_yn")==null || req.getParameter("cancel_referral_reason_yn")=="")? "N" : req.getParameter("cancel_referral_reason_yn");
			//End this CRF ML-MMOH-CRF-0566

			if(CANCEL_OP_CHECKOUT_YN.equals(""))
				CANCEL_OP_CHECKOUT_YN = "N";
			if(CANCEL_AE_CHECKOUT_YN.equals(""))
				CANCEL_AE_CHECKOUT_YN = "N";
			
				if(REVERT_MO_RELEASE_YN.equals(""))
				REVERT_MO_RELEASE_YN = "N";
				// Below Condition Against Bru-HIMS-CRF-348 [IN:038247] By Saanthaakumar
				if(CANCEL_EMBALM_YN.equals(""))
				CANCEL_EMBALM_YN = "N";
			/*emergency_transfer_yn   =(req.getParameter("emergency_transfer_yn")==null)?"N"		:req.getParameter("emergency_transfer_yn");
			if(emergency_transfer_yn.equals(""))
				emergency_transfer_yn = "N";*/

				//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
				if(external_appl_reason_yn.equals(""))
				external_appl_reason_yn = "N";

				//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
				if(UNIT_TRANSFER_REASON_YN.equals(""))
				UNIT_TRANSFER_REASON_YN = "N";
				//Added for MMS-DM-CRF-0157 on 26-MAR-2020 By KAMATCHI S
				if(BARCODE_SCANNING_YN.equals(""))
					BARCODE_SCANNING_YN = "N";

			CHANGE_ADMISSION_DTLS_YN   =(req.getParameter("CHANGE_ADMISSION_DTLS_YN")==null)?"N" :req.getParameter("CHANGE_ADMISSION_DTLS_YN");
			if(CHANGE_ADMISSION_DTLS_YN.equals(""))
				CHANGE_ADMISSION_DTLS_YN = "N";

			pract_override_reason_yn   =(req.getParameter("pract_override_reason_yn")==null)?"N"		:req.getParameter("pract_override_reason_yn");
			if(pract_override_reason_yn.equals(""))
				pract_override_reason_yn = "N";
			trans_exceed_reason_yn   =(req.getParameter("trans_exceed_reason_yn")==null)?"N"		:req.getParameter("trans_exceed_reason_yn");
			if(trans_exceed_reason_yn.equals(""))
				trans_exceed_reason_yn = "N";
				
			//added for the CRF - Bru-HIMS-CRF-157
			late_discharge_reason_yn =(req.getParameter("late_discharge_reason_yn")==null)?"N"		:req.getParameter("late_discharge_reason_yn");
			if(late_discharge_reason_yn.equals(""))
				late_discharge_reason_yn = "N";
			/* Added by lakshmanan for ML-MMOH-CRF-1955 on 01-07-2023 start */
			mark_mlc_yn   =(req.getParameter("mark_mlc_yn")==null)?"N" :req.getParameter("mark_mlc_yn");
			if(mark_mlc_yn.equals(""))
				mark_mlc_yn = "N";
			mark_nonmlc_yn   =(req.getParameter("mark_nonmlc_yn")==null)?"N" :req.getParameter("mark_nonmlc_yn");
			if(mark_nonmlc_yn.equals(""))
				mark_nonmlc_yn = "N";
			/* Added by lakshmanan for ML-MMOH-CRF-1955 on 01-07-2023 end */
			
			cancel_For_admission_yn   =(req.getParameter("cancel_For_admission_yn")==null)?"N" :req.getParameter("cancel_For_admission_yn");
			REASON_BIOMETRIC_REJECTION_YN   =(req.getParameter("REASON_BIOMETRIC_REJECTION_YN")==null)?"N" :req.getParameter("REASON_BIOMETRIC_REJECTION_YN");
			

			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
		//	java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;
			HashMap tabdata=new HashMap();
			tabdata.put("contact_reason",reason);
			tabdata.put("eff_status",effectiveStatus);
			tabdata.put("added_by_id",addedById);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("visit_registration_yn"	 ,visit_registration_yn  );
			tabdata.put("cancel_visit_yn"		 ,cancel_visit_yn        );
			tabdata.put("REGISTER_ATTENDANCE_YN" ,REGISTER_ATTENDANCE_YN );
			tabdata.put("book_appointment_yn"	 ,book_appointment_yn    );
			tabdata.put("transfer_appointment_yn",transfer_appointment_yn);
			tabdata.put("cancel_appointment_yn"	 ,cancel_appointment_yn  );
			tabdata.put("lift_schedule_yn"		 ,lift_schedule_yn       );
			tabdata.put("block_schedule_yn"		 ,block_schedule_yn      );
			tabdata.put("cancel_schedule_yn"	 ,cancel_schedule_yn     );
			tabdata.put("transfer_schedule_yn"	 ,transfer_schedule_yn   );
			tabdata.put("revise_visit_yn"		 ,revise_visit_yn		 );
		    tabdata.put("followup_of_referral_yn" ,followup_of_referral_yn );
		    tabdata.put("rejection_of_referral_yn" ,rejection_of_referral_yn );
			tabdata.put("reason_for_referral_yn" ,reason_for_referral_yn );
			tabdata.put("cancel_booking_yn"		 ,cancel_booking_yn		 );
			tabdata.put("patient_depart_yn"		 ,patient_depart_yn		 );
			tabdata.put("cancel_admission_yn"		 ,cancel_admission_yn );
			tabdata.put("cancel_discharge_advice_yn"		 ,cancel_discharge_advice_yn );
			tabdata.put("reason_for_revise_bkg_yn" , reason_for_revise_bkg_yn);
			tabdata.put("CANCEL_TRANSFER_YN" , cancel_transfer_yn);
			tabdata.put("reason_for_recall_yn" ,reason_for_recall_yn );
            tabdata.put("cancel_wait_list_yn" ,cancel_wait_list_yn );
			tabdata.put("modify_wait_list_yn" ,modify_wait_list_yn );
			tabdata.put("CANCEL_DISCHARGE_YN" ,cancel_discharge_yn );
			tabdata.put("CANCEL_OP_CHECKOUT_YN",CANCEL_OP_CHECKOUT_YN );
			tabdata.put("CANCEL_AE_CHECKOUT_YN",CANCEL_AE_CHECKOUT_YN );
			tabdata.put("REVERT_MO_RELEASE_YN",REVERT_MO_RELEASE_YN );
			tabdata.put("CANCEL_EMBALM_YN",CANCEL_EMBALM_YN ); // Against Bru-HIMS-CRF-348 [IN:038247] By Saanthaakumar
			//tabdata.put("emergency_transfer_yn",emergency_transfer_yn );
			tabdata.put("cancel_medical_request_yn",cancelMedRequestYn ); //Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719
			tabdata.put("reject_request_mrp_yn",rejectRequest_mrp_yn ); //Added by Mujafar for ML-MMOH-CRF-0713
			tabdata.put("reject_report_mrp_yn",rejectReport_mrp_yn ); //Added by Mujafar for ML-MMOH-CRF-0714
			tabdata.put("CHANGE_ADMISSION_DTLS_YN",CHANGE_ADMISSION_DTLS_YN );
			tabdata.put("pract_override_reason_yn",pract_override_reason_yn );
			tabdata.put("trans_exceed_reason_yn",trans_exceed_reason_yn );
			tabdata.put("REASON_FOR_LATE_DISCH_YN",late_discharge_reason_yn); //added for the CRF - Bru-HIMS-CRF-157
			//System.out.println("ContactReasonServlet modifyContactReason tabdata :"+tabdata.toString());
			//Below line added for this CRF ML-MMOH-CRF-0566
			tabdata.put("REJECT_REF_REASON_YN",reject_referral_reason_yn);
			tabdata.put("CANCEL_REF_REASON_YN",cancel_referral_reason_yn);			 
			//End this ML-MMOH-CRF-0566
			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			tabdata.put("exclude_yn",external_appl_reason_yn);
			//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
			tabdata.put("UNIT_TRANSFER_REASON_YN",UNIT_TRANSFER_REASON_YN);
			//Added for MMS-DM-CRF-0157 on 26-MAR-2020 By KAMATCHI S
			tabdata.put("BARCODE_SCANNING_YN",BARCODE_SCANNING_YN);
			/*Added By Dharma on 10th Mar 2020 against ML-MMOH-CRF-1473 Start*/
			tabdata.put("rejected_to_mrd_by_pract_yn",rejected_to_mrd_by_pract_yn);
			tabdata.put("return_to_hod_by_pract_yn",return_to_hod_by_pract_yn);
			/*Added By Dharma on 10th Mar 2020 against ML-MMOH-CRF-1473 End*/
				tabdata.put("cancel_For_admission_yn",cancel_For_admission_yn);	//<!--Added by Himanshu Saxena on 16-Jun-2023 for ML-MMOH-CRF-1972-->
			/* Added by lakshmanan for ML-MMOH-CRF-1955 on 01-07-2023 start */
			tabdata.put("mark_nonmlc_yn",mark_nonmlc_yn);
			tabdata.put("mark_mlc_yn",mark_mlc_yn);
			/* Added by lakshmanan for ML-MMOH-CRF-1955 on 01-07-2023 end */
				
				tabdata.put("REASON_BIOMETRIC_REJECTION_YN",REASON_BIOMETRIC_REJECTION_YN); //<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175 U11-->
			
			HashMap condflds=new HashMap();
			condflds.put("contact_reason_code",contact);
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				String table_name="am_contact_reason";
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
			HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			tabdata.clear();
			condflds.clear();
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ){
			     error_value = "1" ;
			    res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  )+"&err_value="+ error_value);
			}else{
			     error = (String) results.get("error") ;
			    res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error ,"UTF-8" ) );
			}results.clear();
		}catch ( Exception e ){		
			out.println(" Exception raise by Servlet ...So Record Not Modified  Foll: Error Received : "+e.toString());
			out.println( "Values sent are : " ) ;
			out.println( contact + " "+reason+ " "+ effectiveStatus );
			e.printStackTrace();
		}
	}

	private void insertContactReason(HttpServletRequest req){
		try	{
			
			contact =req.getParameter("contact_reason_code");
			reason = req.getParameter("contact_reason");
			effectiveStatus = req.getParameter("eff_status");
			visit_registration_yn   =(req.getParameter("visit_registration_yn")==null)?"N"	:req.getParameter("visit_registration_yn");
			cancel_visit_yn         =(req.getParameter("cancel_visit_yn")==null)?"N"		:req.getParameter("cancel_visit_yn");
			REGISTER_ATTENDANCE_YN         =(req.getParameter("REGISTER_ATTENDANCE_YN")==null)?"N"		:req.getParameter("REGISTER_ATTENDANCE_YN");
            followup_of_referral_yn  =req.getParameter("followup_of_referral_yn1" );
			if(followup_of_referral_yn == null)	followup_of_referral_yn = "N";
			if(followup_of_referral_yn.equals("")) followup_of_referral_yn="N" ;
  		    rejection_of_referral_yn  =req.getParameter("rejection_of_referral_yn1" );
			if(rejection_of_referral_yn == null)	rejection_of_referral_yn = "N";
			if(rejection_of_referral_yn.equals("")) rejection_of_referral_yn="N" ;
			book_appointment_yn     =(req.getParameter("book_appointment_yn")
			==null)?"N"	:req.getParameter("book_appointment_yn");
			transfer_appointment_yn =(req.getParameter("transfer_appointment_yn")==null)?"N":req.getParameter("transfer_appointment_yn");
			cancel_appointment_yn   =(req.getParameter("cancel_appointment_yn")==null)?"N"	:req.getParameter("cancel_appointment_yn");
			lift_schedule_yn        =(req.getParameter("lift_schedule_yn")==null)?"N"		:req.getParameter("lift_schedule_yn");
			block_schedule_yn       =(req.getParameter("block_schedule_yn")==null)?"N"		:req.getParameter("block_schedule_yn");
			cancel_schedule_yn      =(req.getParameter("cancel_schedule_yn")
			==null)?"N"		:req.getParameter("cancel_schedule_yn");
			transfer_schedule_yn    =(req.getParameter("transfer_schedule_yn")
			==null)?"N"	:req.getParameter("transfer_schedule_yn");
			revise_visit_yn		    =(req.getParameter("revise_visit_yn"		)==null)?"N"	:req.getParameter("revise_visit_yn");
			reason_for_referral_yn  =(req.getParameter("reason_for_referral_yn")==null)?"N" :req.getParameter("reason_for_referral_yn");
            reason_for_recall_yn	    =(req.getParameter("reason_for_recall_yn"		)==null)?"N"	:req.getParameter("reason_for_recall_yn");
		     
			cancel_booking_yn		    =(req.getParameter("cancel_booking_yn"		)==null)?"N"	:req.getParameter("cancel_booking_yn");
			cancel_admission_yn		    =(req.getParameter("cancel_admission_yn"		)==null)?"N"	:req.getParameter("cancel_admission_yn");
			cancel_discharge_advice_yn		    =(req.getParameter("cancel_discharge_advice_yn"		)==null)?"N"	:req.getParameter("cancel_discharge_advice_yn");
			reason_for_revise_bkg_yn   =(req.getParameter("reason_for_revise_bkg_yn")==null)?"N" :req.getParameter("reason_for_revise_bkg_yn");
			//reason_for_revise_bkg_yn = "N";
			cancel_transfer_yn     =req.getParameter("cancel_transfer_yn");
			//added on 20 jun 2005
            patient_depart_yn	    =(req.getParameter("patient_depart_yn")==null)?"N"	:req.getParameter("patient_depart_yn");   
			cancel_wait_list_yn=req.getParameter("cancel_wait_list_yn");
			
			if(cancel_wait_list_yn==null || (cancel_wait_list_yn.equals("null")))
				cancel_wait_list_yn="N";
           

			//newly added on 09/01/2006
			modify_wait_list_yn		    =(req.getParameter("modify_wait_list_yn1"));
			if(modify_wait_list_yn ==null || (modify_wait_list_yn.equals("null"))) 
				modify_wait_list_yn="N";

			cancel_discharge_yn = (req.getParameter("cancel_discharge_yn"		)==null)?"N"	:req.getParameter("cancel_discharge_yn");
		
			//
			if(cancel_transfer_yn == null)
				cancel_transfer_yn = "N";	
			if(cancel_transfer_yn.equals(""))
				cancel_transfer_yn = "N";
			if ( effectiveStatus == null )
				effectiveStatus="D";

			if(cancel_discharge_yn.equals(""))
				cancel_discharge_yn = "N";

			CANCEL_OP_CHECKOUT_YN   =(req.getParameter("CANCEL_OP_CHECKOUT_YN")==null)?"N"		:req.getParameter("CANCEL_OP_CHECKOUT_YN");
			CANCEL_AE_CHECKOUT_YN   =(req.getParameter("CANCEL_AE_CHECKOUT_YN")==null)?"N"		:req.getParameter("CANCEL_AE_CHECKOUT_YN");
			REVERT_MO_RELEASE_YN   =(req.getParameter("REVERT_MO_RELEASE_YN")==null)?"N":req.getParameter("REVERT_MO_RELEASE_YN");
			// Against Bru-HIMS-CRF-348 [IN:038247] By Saanthaakumar
			CANCEL_EMBALM_YN   =(req.getParameter("CANCEL_EMBALM_YN")==null)?"N":req.getParameter("CANCEL_EMBALM_YN");
			cancelMedRequestYn  =(req.getParameter("cancel_med_request_yn")==null || req.getParameter("cancel_med_request_yn")=="")?"N":req.getParameter("cancel_med_request_yn");//Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719
			rejectRequest_mrp_yn=(req.getParameter("rejectRequest_mrp_yn")==null || req.getParameter("rejectRequest_mrp_yn")=="")?"N":req.getParameter("rejectRequest_mrp_yn");//Added by Mujafar for ML-MMOH-CRF-0713
			rejectReport_mrp_yn=(req.getParameter("rejectReport_mrp_yn")==null || req.getParameter("rejectReport_mrp_yn")=="")?"N":req.getParameter("rejectReport_mrp_yn");//Added by Mujafar for ML-MMOH-CRF-0714
			//Below line added for this CRF ML-MMOH-CRF-0566
			reject_referral_reason_yn=(req.getParameter("reject_referral_reason_yn")==null || req.getParameter("reject_referral_reason_yn")=="")? "N" : req.getParameter("reject_referral_reason_yn");
			cancel_referral_reason_yn=(req.getParameter("cancel_referral_reason_yn")==null || req.getParameter("cancel_referral_reason_yn")=="")? "N" : req.getParameter("cancel_referral_reason_yn");
			//End this CRF ML-MMOH-CRF-0566
			
			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			external_appl_reason_yn = (req.getParameter("external_appl_reason_yn")==null)?"N":req.getParameter("external_appl_reason_yn");

			//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
			UNIT_TRANSFER_REASON_YN = (req.getParameter("UNIT_TRANSFER_REASON_YN")==null)?"N":req.getParameter("UNIT_TRANSFER_REASON_YN");
			//Added for MMS-DM-CRF-0157 on 26-MAR-2020 By KAMATCHI S
			BARCODE_SCANNING_YN = (req.getParameter("BARCODE_SCANNING_YN")==null)?"N":req.getParameter("BARCODE_SCANNING_YN");
			/*Added By Dharma on 10th Mar 2020 against ML-MMOH-CRF-1473 Start*/
			rejected_to_mrd_by_pract_yn = (req.getParameter("rejected_to_mrd_by_pract_yn")==null || req.getParameter("rejected_to_mrd_by_pract_yn")=="")?"N":req.getParameter("rejected_to_mrd_by_pract_yn");
			return_to_hod_by_pract_yn = (req.getParameter("return_to_hod_by_pract_yn")==null || req.getParameter("return_to_hod_by_pract_yn")=="")?"N":req.getParameter("return_to_hod_by_pract_yn");
			/*Added By Dharma on 10th Mar 2020 against ML-MMOH-CRF-1473 End*/

			if(CANCEL_OP_CHECKOUT_YN.equals(""))
				CANCEL_OP_CHECKOUT_YN = "N";
			if(CANCEL_AE_CHECKOUT_YN.equals(""))CANCEL_AE_CHECKOUT_YN = "N";
			if(REVERT_MO_RELEASE_YN.equals(""))REVERT_MO_RELEASE_YN = "N";
			if(CANCEL_EMBALM_YN.equals(""))CANCEL_EMBALM_YN = "N"; // Against Bru-HIMS-CRF-348 [IN:038247] By Saanthaakumar

			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			if(external_appl_reason_yn.equals(""))external_appl_reason_yn = "N";

			//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
			if(UNIT_TRANSFER_REASON_YN.equals(""))UNIT_TRANSFER_REASON_YN = "N";
			//Added for MMS-DM-CRF-0157 on 26-MAR-2020 By KAMATCHI S
			if(BARCODE_SCANNING_YN.equals(""))BARCODE_SCANNING_YN = "N";
			
			/*emergency_transfer_yn   =(req.getParameter("emergency_transfer_yn")==null)?"N"		:req.getParameter("emergency_transfer_yn");
			if(emergency_transfer_yn.equals(""))
				emergency_transfer_yn = "N";*/

			CHANGE_ADMISSION_DTLS_YN   =(req.getParameter("CHANGE_ADMISSION_DTLS_YN")==null)?"N" :req.getParameter("CHANGE_ADMISSION_DTLS_YN");
			if(CHANGE_ADMISSION_DTLS_YN.equals(""))
				CHANGE_ADMISSION_DTLS_YN = "N";

			pract_override_reason_yn   =(req.getParameter("pract_override_reason_yn")==null)?"N"		:req.getParameter("pract_override_reason_yn");
			if(pract_override_reason_yn.equals(""))
				pract_override_reason_yn = "N";
			trans_exceed_reason_yn   =(req.getParameter("trans_exceed_reason_yn")==null)?"N"		:req.getParameter("trans_exceed_reason_yn");
			if(trans_exceed_reason_yn.equals(""))
				trans_exceed_reason_yn = "N";
			//added for the CRF - Bru-HIMS-CRF-157
			late_discharge_reason_yn =(req.getParameter("late_discharge_reason_yn")==null)?"N"		:req.getParameter("late_discharge_reason_yn");
			if(late_discharge_reason_yn.equals(""))
				late_discharge_reason_yn = "N";
			cancel_For_admission_yn   =(req.getParameter("cancel_For_admission_yn")==null)?"N" :req.getParameter("cancel_For_admission_yn");	

			/* Added by lakshmanan for ML-MMOH-CRF-1955 on 01-07-2023 start */
			mark_mlc_yn   =(req.getParameter("mark_mlc_yn")==null)?"N" :req.getParameter("mark_mlc_yn");
			if(mark_mlc_yn.equals(""))
				mark_mlc_yn = "N";
			mark_nonmlc_yn   =(req.getParameter("mark_nonmlc_yn")==null)?"N" :req.getParameter("mark_nonmlc_yn");
			if(mark_nonmlc_yn.equals(""))
				mark_nonmlc_yn = "N";
			/* Added by lakshmanan for ML-MMOH-CRF-1955 on 01-07-2023 end */
		
			REASON_BIOMETRIC_REJECTION_YN   =(req.getParameter("REASON_BIOMETRIC_REJECTION_YN")==null)?"N" :req.getParameter("REASON_BIOMETRIC_REJECTION_YN");
			//System.out.println("In insertContactReason -- late_discharge_reason_yn: "+late_discharge_reason_yn);
			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			HashMap tabdata=new HashMap();
			tabdata.put("contact_reason_code",contact);
			tabdata.put("contact_reason",reason);
			tabdata.put("eff_status",effectiveStatus);
			tabdata.put("visit_registration_yn"	 ,visit_registration_yn  );
			tabdata.put("cancel_visit_yn"		 ,cancel_visit_yn        );
			tabdata.put("REGISTER_ATTENDANCE_YN",REGISTER_ATTENDANCE_YN  );
			tabdata.put("book_appointment_yn"	 ,book_appointment_yn    );
			tabdata.put("transfer_appointment_yn",transfer_appointment_yn);
			tabdata.put("cancel_appointment_yn"	 ,cancel_appointment_yn  );
			tabdata.put("lift_schedule_yn"		 ,lift_schedule_yn       );
			tabdata.put("block_schedule_yn"		 ,block_schedule_yn      );
			tabdata.put("cancel_schedule_yn"	 ,cancel_schedule_yn     );
			tabdata.put("transfer_schedule_yn"	 ,transfer_schedule_yn   );
			tabdata.put("revise_visit_yn"		 ,revise_visit_yn	     );
			tabdata.put("reason_for_referral_yn",reason_for_referral_yn );
			tabdata.put("reason_for_recall_yn"		 ,reason_for_recall_yn  );
			tabdata.put("cancel_booking_yn"		 ,cancel_booking_yn		 );
			tabdata.put("patient_depart_yn"		 ,patient_depart_yn		 );
		    tabdata.put("cancel_admission_yn"		 ,cancel_admission_yn		 );
			tabdata.put("cancel_discharge_advice_yn"		 ,cancel_discharge_advice_yn		 );
			tabdata.put("reason_for_revise_bkg_yn" ,reason_for_revise_bkg_yn);
			tabdata.put("CANCEL_TRANSFER_YN" ,cancel_transfer_yn);
            tabdata.put("followup_of_referral_yn" ,followup_of_referral_yn );
		    tabdata.put("rejection_of_referral_yn" ,rejection_of_referral_yn );
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("cancel_wait_list_yn",cancel_wait_list_yn );
			tabdata.put("modify_wait_list_yn",modify_wait_list_yn );
			tabdata.put("CANCEL_DISCHARGE_YN",cancel_discharge_yn );
			tabdata.put("CANCEL_OP_CHECKOUT_YN",CANCEL_OP_CHECKOUT_YN );
			tabdata.put("CANCEL_AE_CHECKOUT_YN",CANCEL_AE_CHECKOUT_YN );
			tabdata.put("REVERT_MO_RELEASE_YN",REVERT_MO_RELEASE_YN );
			tabdata.put("CANCEL_EMBALM_YN",CANCEL_EMBALM_YN ); // Against Bru-HIMS-CRF-348 [IN:038247] By Saanthaakumar
			//tabdata.put("emergency_transfer_yn",emergency_transfer_yn );
			tabdata.put("cancel_medical_request_yn",cancelMedRequestYn ); //Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719
			
			tabdata.put("reject_request_mrp_yn",rejectRequest_mrp_yn ); //Added by Mujafar for ML-MMOH-CRF-0713
			tabdata.put("reject_report_mrp_yn",rejectReport_mrp_yn ); //Added by Mujafar for ML-MMOH-CRF-0714
			tabdata.put("CHANGE_ADMISSION_DTLS_YN",CHANGE_ADMISSION_DTLS_YN );
			tabdata.put("pract_override_reason_yn",pract_override_reason_yn );
			tabdata.put("trans_exceed_reason_yn",trans_exceed_reason_yn );
			//added for the CRF - Bru-HIMS-CRF-157
			tabdata.put("REASON_FOR_LATE_DISCH_YN",late_discharge_reason_yn);
			
			//Below line added for this CRF ML-MMOH-CRF-0566
			tabdata.put("REJECT_REF_REASON_YN",reject_referral_reason_yn);
			tabdata.put("CANCEL_REF_REASON_YN",cancel_referral_reason_yn);			 
			//End this ML-MMOH-CRF-0566

			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			tabdata.put("exclude_yn",external_appl_reason_yn);

			//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
			tabdata.put("UNIT_TRANSFER_REASON_YN",UNIT_TRANSFER_REASON_YN);
			//Added for MMS-DM-CRF-0157 on 26-MAR-2020 By KAMATCHI S
			tabdata.put("BARCODE_SCANNING_YN",BARCODE_SCANNING_YN);
			/*Added By Dharma on 10th Mar 2020 against ML-MMOH-CRF-1473 Start*/
			tabdata.put("return_to_hod_by_pract_yn",return_to_hod_by_pract_yn);
			tabdata.put("rejected_to_mrd_by_pract_yn",rejected_to_mrd_by_pract_yn);
			/*Added By Dharma on 10th Mar 2020 against ML-MMOH-CRF-1473 End*/
			/* Added by lakshmanan for ML-MMOH-CRF-1955 on 01-07-2023 start */
			tabdata.put("mark_nonmlc_yn",mark_nonmlc_yn);
			tabdata.put("mark_mlc_yn",mark_mlc_yn);
			/* Added by lakshmanan for ML-MMOH-CRF-1955 on 01-07-2023 end */
			
			//System.out.println("In insertContactReason -- in tabdata - late_discharge_reason_yn: "+tabdata.get("REASON_FOR_LATE_DISCH_YN"));
			//System.out.println("ContactReasonServlet insertContactReason tabdata :"+tabdata.toString());
			
			tabdata.put("cancel_For_admission_yn",cancel_For_admission_yn);	//<!--Added by Himanshu Saxena on 16-Jun-2023 for ML-MMOH-CRF-1972-->
			
			tabdata.put("REASON_BIOMETRIC_REJECTION_YN",REASON_BIOMETRIC_REJECTION_YN);	//<!--Added by Himanshu Saxena on 16-Jun-2023 for AAKH-CRF-0175 U11-->
			
			String dupflds[]={"contact_reason_code"};
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				String table_name="am_contact_reason";
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
			HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			tabdata.clear();
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			//out.println("<script>alert('reason_for_revise_bkg_yn.value:" +reason_for_revise_bkg_yn+"')</script>");
			if ( inserted ){
			     error_value = "1" ;
				}else{
			     error = (String) results.get("error") ;
				}results.clear();
			out.println("<script>document.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+ "&err_value=" + error_value+"'</script>" );			
		}catch ( Exception e ){
			out.println(" Exception raise by Servlet ...So Record Not Modified  Foll: Error Received : "+e.toString());
			out.println( "Values sent are : " ) ;
			out.println( contact+ " "+reason+" "+ effectiveStatus );
			e.printStackTrace();
		}
	}
}
