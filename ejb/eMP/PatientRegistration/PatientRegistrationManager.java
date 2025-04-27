/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/***  Last Modified Date TIle : 3/7/2006 3:50 PM ***/
package eMP.PatientRegistration;

 
import webbeans.eCommon.*; 
import java.rmi.*;
import java.util.*;
import javax.ejb.*;
import java.sql.*;
import javax.naming.*;
import javax.rmi.*;
import org.apache.commons.codec.binary.*;
import eCommon.Common.*;
import java.net.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;


/**
*
* @ejb.bean
*	name="PatientRegistration"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PatientRegistration"
*	local-jndi-name="PatientRegistration"
*	impl-class-name="eMP.PatientRegistration.PatientRegistrationManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eMP.PatientRegistration.PatientRegistrationLocal"
*	remote-class="eMP.PatientRegistration.PatientRegistrationRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMP.PatientRegistration.PatientRegistrationLocalHome"
*	remote-class="eMP.PatientRegistration.PatientRegistrationHome"
*	generate= "local,remote"
*
*
*/

public class PatientRegistrationManager implements javax.ejb.SessionBean
{
    Connection con				= null;
    Statement stmt1				= null;
    PreparedStatement stmt		= null;
    ResultSet rset				= null;
    ResultSet rset_patId_req	= null;

    StringBuffer sql				= new StringBuffer();
    StringBuffer debug_buffer		= new StringBuffer();
    StringBuffer msg_buffer			= new StringBuffer();
	StringBuffer message_buf		= new StringBuffer();
	StringBuffer error_buf			= new StringBuffer();
	StringBuffer msg_file_no_buffer	= new StringBuffer();

	boolean transaction_completed	= false;
	boolean tableUpdated			= true;

    HashMap ret_hash		= new HashMap();
    HashMap insert_values	= new HashMap() ;

    String patient_id		= "";
	String Site_or_Facility	= "";
    String SRF				= "";
    String apptrefno		= "";
    String bkg_ref_no		= "";
	String q_booking_type	= "";
    String refrlAappt		= "";
    String refIDValue		= "";
    String pat_ser_grp_code	= "";
	String sStyle			= "";
	String doc_or_file		= "";
	String tableUpdatedMsg	= "";
	String locale			= "";
	String pat_no_ctrl		= "";
	String siteid			= "";
	byte[] decodedData = null;
	byte[] patPhotoDecodedData = null;
	//String encodedData	= "";
	//String image_yn  = "";
	String billdoctype = "";
	String billdocnum = "";
	String billgenlater = "";
	String bl_success_msg	= "";

	String str_bill_prt_format_YN = "N";
	String str_bill_prt_format_vals = "";
	String pgm_id ="";
	String session_id ="";
	String pgm_date ="";
	String mpi_id_rep = "";
	String txtSmart_fn_name ="";
	Boolean isUpdateApptCalled	= false;//Added by Dharma on 9th Oct 2015 against For ML-MMOH-SCF-0298 [IN:057982]

	boolean isPortalPatient= false;
	String site_id="";//Added by Rameswar on 23-Oct-15 for Patient Portal
	String site_IP="";//Added by Rameswar on 23-Oct-15 for Patient Portal
	int port;//Added by Rameswar on 23-Oct-15for Patient Portal
	HashMap hashdata    = new HashMap();//Added by Rameswar on 23-Oct-15 for Patient Portal
	String smartCardFunc="";//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
	SessionContext ctx;

    public void ejbCreate() throws  CreateException {}
    public void ejbRemove() {}
    public void ejbActivate() {}
    public void ejbPassivate() {}
    public void setSessionContext (SessionContext context){ this.ctx = context; }
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap insertPatient(Properties p,HashMap insert_values) {

		debug_buffer.setLength(0);
		msg_buffer.setLength(0);
		message_buf.setLength(0);
		error_buf.setLength(0);
		msg_file_no_buffer.setLength(0);
		bl_success_msg	= "";

		String encodedData = (String)insert_values.get("dla_image") ;
		String patPhotoData = (String)insert_values.get("pat_photo") ;
		txtSmart_fn_name = (String)insert_values.get("txtSmart_fn_name") ;
		String image_yn	= (String)insert_values.get("image_yn");

		//Added by Ashwini
		Boolean isErrorLogInsertAppl = false;


		if(image_yn==null || image_yn.equals("null"))
			image_yn = "";
		if(encodedData==null || encodedData.equals("null"))
			encodedData = "";
		if(patPhotoData==null || patPhotoData.equals("null"))
			patPhotoData = "";

	

		if (encodedData.length() >0)
		{
		  //decodedData  = Base64.decodeBase64(encodedData.getBytes());
		  decodedData  = org.apache.commons.codec.binary.Base64.decodeBase64(encodedData.getBytes());
		}
		if (patPhotoData.length() >0)
		{
		  patPhotoDecodedData  = org.apache.commons.codec.binary.Base64.decodeBase64(patPhotoData.getBytes());
		}
		pat_ser_grp_code = (String)insert_values.get("pat_ser_grp_code");
		this.insert_values = insert_values ;
        try {
            debug_buffer.append("<br>Start insertPatient");
			

			doc_or_file		= (String)insert_values.get("maintain_doc_or_file");
            apptrefno	    = (String)insert_values.get("appt_ref_no");
            bkg_ref_no      = (String)insert_values.get("bkg_ref_no");
			q_booking_type  = (String)insert_values.get("q_booking_type");
			sStyle			= (String)insert_values.get("sStyle");
			locale			= (String)insert_values.get("locale");
			if(sStyle == null || sStyle.equals("null")) sStyle = "IeStyle.css";

			refrlAappt = (String)insert_values.get("refrlAappt");
			refIDValue = (String)insert_values.get("refIDValue");
			if(refrlAappt == null || refrlAappt.equals("null")) refrlAappt = "";
			if(refIDValue == null || refIDValue.equals("null")) refIDValue = "";

			//image_yn = (String)insert_values.get("image_yn");
			//if(image_yn == null || image_yn.equals("null")) image_yn = "";

			con = ConnectionManager.getConnection();
			 smartCardFunc	= CommonBean.isSiteSpecificforBiometric(con);//added by Himanshu Saxena for AAKH-CRF-0175 as on 23-08-2023 
			con.setAutoCommit(false);
            stmt1 = con.createStatement();

            String pat_no_gen_yn = (String)insert_values.get("pat_no_gen_yn") ;

			rset_patId_req=stmt1.executeQuery("select gen_pat_id_yn ,pat_no_ctrl,(SELECT site_id FROM sm_site_param) siteid from MP_PAT_SER_GRP where pat_ser_grp_code = '"+insert_values.get("pat_ser_grp_code")+"'");
			if(rset_patId_req != null) {
				rset_patId_req.next();
				pat_no_gen_yn = rset_patId_req.getString("gen_pat_id_yn");
				pat_no_ctrl	= rset_patId_req.getString("pat_no_ctrl");
				siteid		= rset_patId_req.getString("siteid");
			}
			if(rset_patId_req != null) rset_patId_req.close();
			if(stmt1 != null) stmt1.close();

						//System.out.println("pat_no_gen_yn -- >" + pat_no_gen_yn);

            if(pat_no_gen_yn.equals("Y")) {
				
                patient_id = generatePatientID();
				
			} else {
                patient_id = (String)insert_values.get("patient_id");
                transaction_completed = true;
				
            }

            if(transaction_completed) {


                insertPatientDtls();
				System.out.println("transaction_completed before calling updateExternalDataSource:"+transaction_completed);
				// updating xf_person table
				if(transaction_completed) {
					updateExternalDataSource();
				}
				if(transaction_completed && txtSmart_fn_name.equals("06") && patPhotoData.length() >0) {
					savePatientPhoto();
				}

				if(transaction_completed) {

					if(!image_yn.equals("")) {
						updateDlaphoto(image_yn);
					}


				}

					if(transaction_completed) {
                        if(((String)insert_values.get("Appt_Val")).equals("Appt") || refrlAappt.equals("A")) {
							updateAppointment();
                          /*  if(!((String)insert_values.get("referral_id")).equals(""))
                                insert_values.put("func_act","REF_SEARCH") ;
								*/
								isUpdateApptCalled	= true;//Added by Dharma on 9th Oct 2015 against For ML-MMOH-SCF-0298 [IN:057982] 
                        }
						//if(transaction_completed) {//Modified by Dharma on 9th Oct 2015 against For ML-MMOH-SCF-0298 [IN:057982] 
						if(transaction_completed && !isUpdateApptCalled) {
                            if(!bkg_ref_no.equals("") || refrlAappt.equals("I")) {
                                if(q_booking_type.equals("D")) {
									apptrefno = bkg_ref_no;
									updateAppointment();
								}
								else if(!q_booking_type.equals("D") || refrlAappt.equals("I")) {
									updateIPBooking();
								}
							}
						}
						if(transaction_completed) {
							if(refrlAappt.equals("R")) {
								updateRDAppt();
							}
						}
						if(transaction_completed) {
                            if(insert_values.get("billing_group") != null) {
                                updateBilling(p,con,"I");
							}
						}
						if(transaction_completed && ( ((String)insert_values.get("func_act")).equals("REF_SEARCH")) || refrlAappt.equals("L")) {
							updateRefferal();
						}

						if(transaction_completed) {
							if(!pat_no_gen_yn.equals("N")) {
								if(doc_or_file.equals("F")) {
									getMRNFile();
								}
							}
						}
					
					//added by Himanshu Saxena for AAKH-CRF-0175 as on 23-08-2023 Starts
						try 
							{
							String biometric_reason=(String)insert_values.get("biometric_reason");
							
							
							if(transaction_completed && smartCardFunc.equals("01") && !biometric_reason.equals(""))
								{
								String ref_no=patient_id;
								String fun_id=(String)insert_values.get("fun_id");
								
								String status=CommonBean.insertReasonforBiometric(con,(String)insert_values.get("facility_id"),fun_id,patient_id,ref_no,"",biometric_reason,(String)insert_values.get("added_at_ws_no"),(String)insert_values.get("added_by_id"));
								if(status.equals("S"))
									{
									transaction_completed	= true;	
									}
								else {
									transaction_completed	= false;
									}	
								} 
							}
						catch(Exception e)
							{
							transaction_completed	= false;
							e.printStackTrace();
							}
						//Ends	
						
						
						
						if(transaction_completed) {
							con.commit();
							
				isPortalPatient	=CommonBean.isPortalPatient(con,apptrefno,(String)insert_values.get("facility_id"));
				hashdata		=CommonBean.portalInstallation(con);
				site_id			=(String)hashdata.get("site_id");
				site_IP			=(String)hashdata.get("site_ip");
				port			=(Integer)hashdata.get("port")==null?0:(Integer)hashdata.get("port");
				/* Added by Karthik to Support Online portal Update From EM Operations - Starts */
				System.err.println("isPortalPatient 268 ==>"+isPortalPatient);
				if(isPortalPatient){
					System.err.println("site_IP 268 ==>"+site_IP);
					System.err.println("port 268 ==>"+port);
					if(port!=0&&site_IP!=""&&site_IP!=null){
					URL url = new URL("http://"+site_IP+":"+port+"/patientportal/rest/updateportaldb");    //PatientId and AppointmentId needs to be assigned
						System.err.println("url 265 ==>"+url.toString());
					String postInputJsonParams = "{\"locale\":\""+locale+"\",\"appointmentId\":\""+apptrefno+"\",\"patientId\":\""+patient_id+"\",\"siteId\":\""+site_id+"\"}";
					System.err.println("postInputJsonParams 268 ==>"+postInputJsonParams);
					CommonBean.restPostRequest(url,postInputJsonParams);
					
					}
				}

							String s = getMessage(locale, "PAT_ID_SUCCESS", "MP") ;

							//s = s.substring(0,s.indexOf("<br>"))+ " <B><FONT SIZE=4>" +patient_id +"</B></FONT>, ";
							s = s + " <B><FONT SIZE=4>" +patient_id +"</B></FONT>, ";
							s = s + (String)insert_values.get("patient_name")+", ";

							String sex = (String)insert_values.get("sex") ;
							if(sex.equals("U")) sex = "Unknown";
							else if(sex.equals("M")) sex = "Male";
							else if(sex.equals("F")) sex = "Female";
							s = s +sex+", ";

							if(!((String)insert_values.get("b_age")).equals(""))
							 s = s +(String)insert_values.get("b_age")+"Y " ;
							if(! ((String)insert_values.get("b_months")).equals(""))
								s=s +(String)insert_values.get("b_months") +"M ";
							if(! ((String)insert_values.get("b_days")).equals(""))
								s=s +(String)insert_values.get("b_days")+"D ";
							if(! ((String)insert_values.get("b_hours")).equals(""))
								s=s +(String)insert_values.get("b_hours")+"H ";

							String s1 = msg_buffer.toString();

							msg_buffer = new StringBuffer(s);
							msg_buffer.append(s1);


						}
						else {
							con.rollback();
							isErrorLogInsertAppl = true; //Added by Ashwini
						}
					}
					else
					{
						con.rollback();
						isErrorLogInsertAppl = true; //Added by Ashwini
					}
			}
			if(!tableUpdated) {
				tableUpdatedMsg = getMessage(locale,"PAT_ID_ALREADY_GEN","MP");
				if(tableUpdatedMsg == null || tableUpdatedMsg.equals("null")) tableUpdatedMsg = "";
			}

			debug_buffer.append("<br>End insertPatient") ;
			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e) {
			debug_buffer.append("<br>Main:"+e.toString()) ;
			e.printStackTrace();
			try {
				con.rollback();
				isErrorLogInsertAppl = true; //Added by Ashwini
			}
			catch(Exception e1){e1.printStackTrace();}
		}
		finally {
			//Added by Ashwini
			try 
			{
				if(isErrorLogInsertAppl)
				{
					CallableStatement cs = null; 

					cs = con.prepareCall("{call mp_patient_err_log_proc(?,?,?,sysdate,?) }");

					cs.setString( 1 , patient_id );
					cs.setString( 2 , (String)insert_values.get("added_by_id") );
					cs.setString( 3 , (String)insert_values.get("added_at_ws_no") );
					cs.setString( 4 , debug_buffer.toString() );
					cs.execute();

					if(cs != null)  cs.close();
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			if(con != null) ConnectionManager.returnConnection(con);
		}
		ret_hash.put("Debug_Message",debug_buffer);
		ret_hash.put("Message",msg_buffer) ;
		ret_hash.put("msg_file_no_buffer",msg_file_no_buffer);
		ret_hash.put("Messagebuf",message_buf);
		ret_hash.put("patient_id",patient_id);
		ret_hash.put("Transaction_Completed",new Boolean(transaction_completed));
		ret_hash.put("error_buf",error_buf);
		ret_hash.put("tableUpdated",new Boolean(tableUpdated));
		ret_hash.put("tableUpdatedMsg",tableUpdatedMsg);
		ret_hash.put("billdoctype",billdoctype);
		ret_hash.put("billdocnum",billdocnum);
		ret_hash.put("billgenlater",billgenlater);

		ret_hash.put("bill_prt_format_YN", str_bill_prt_format_YN);
		ret_hash.put("bill_prt_format_vals", str_bill_prt_format_vals);
		ret_hash.put("pgm_id", pgm_id);
		ret_hash.put("session_id", session_id);
		ret_hash.put("pgm_date", pgm_date);
		ret_hash.put("mpi_id_rep", mpi_id_rep);

		ret_hash.put("bl_success_msg",bl_success_msg);


		insert_values.clear();

		return ret_hash;

	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap updatePatient(Properties p, HashMap insert_values)
	{
		ret_hash = null;
		ret_hash = new HashMap();
		this.insert_values.clear();
		this.insert_values = insert_values;
		String function_id = (String)insert_values.get("function_id") ;
		
		// CHG_PAT_PHONE Added by Santhosh for ML-MMOH-CRF-1957
		if(function_id != null && function_id.equals("CHG_PAT_PHONE")) {
			
			sql				= new StringBuffer();
			con = ConnectionManager.getConnection();
			smartCardFunc	= CommonBean.isSiteSpecificforBiometric(con);//added by Himanshu Saxena for AAKH-CRF-0175 as on 23-08-2023 
			transaction_completed = false;
			debug_buffer.setLength(0);
			error_buf.setLength(0);
			try {
				String contact1_no = (String)insert_values.get("contact1_no") ;
				
				String contact2_no = (String)insert_values.get("contact2_no") ;
				
				String Patient_id = (String)insert_values.get("Patient_id") ;
				
				sql.append("update mp_patient set contact1_no='" + contact1_no + "',contact2_no='" + contact2_no + "' where Patient_id='" + Patient_id + "'");
				
				if(stmt!=null)
					stmt.close();
				stmt = con.prepareStatement(sql.toString());
				stmt.executeUpdate();
				transaction_completed = true;
				
				if(transaction_completed)
				{
					con.commit();
					ret_hash.put("Transaction_Completed",new Boolean(transaction_completed));
					//msg_buffer.append(bl_success_msg+"\\n"+getMessage(locale,"PAT_UPD_SUCCESS","MP"));
				}
				else
				{
					con.rollback();
				}
				
			} catch (Exception e) {
				System.err.println("updatePatient number catch called for CHG_PAT_PHONE ============");
				debug_buffer.append("<br>Update Referral:"+e.toString()) ;
				error_buf.append("Error in updateExternalDataSource Uptate xf_person : "+e.toString());

				ret_hash.put("Debug_Message",debug_buffer);
				ret_hash.put("Transaction_Completed",new Boolean(transaction_completed));
				ret_hash.put("error_buf",error_buf);
				
				e.printStackTrace();
			}
			finally
			{
				if(con != null) ConnectionManager.returnConnection(con);
			}
		} else {
			
			bl_success_msg = "";
			debug_buffer	= new StringBuffer();
			msg_buffer		= new StringBuffer();
			error_buf = new StringBuffer();
			
			String encodedData = (String)insert_values.get("dla_image") ;
			String image_yn	= (String)insert_values.get("image_yn");
			String patPhotoData = (String)insert_values.get("pat_photo") ;
			if(patPhotoData==null || patPhotoData.equals("null"))
				patPhotoData = "";	
			if(image_yn==null || image_yn.equals("null"))
				image_yn = "";
			if(encodedData==null || encodedData.equals("null"))
				encodedData = "";
			
			
			
			if (encodedData.length() >0)
			{
				// decodedData  = Base64.decodeBase64(encodedData.getBytes());
				decodedData  = org.apache.commons.codec.binary.Base64.decodeBase64(encodedData.getBytes());
			}
			if (patPhotoData.length() >0)
			{
				patPhotoDecodedData  = org.apache.commons.codec.binary.Base64.decodeBase64(patPhotoData.getBytes());
			} 
			try
			{
				patient_id = (String)insert_values.get("patient_id") ;
				locale			= (String)insert_values.get("locale");
				debug_buffer.append("<br>Start updatePatient") ;
				
				con = ConnectionManager.getConnection();
				
				updatePatientDetails();
				
				if(transaction_completed) {
					
					if(!image_yn.equals("")) {
						updateDlaphoto(image_yn);
					}
				}
				if(transaction_completed && txtSmart_fn_name.equals("06") && patPhotoData.length() >0) {
					savePatientPhoto();
				}
				if(transaction_completed && insert_values.get("billing_group") != null)
				{
					String bl_operation = (String) insert_values.get("bl_operation");
					String fromNewBorn	= (String) insert_values.get("fromNewBorn");
					
					if(bl_operation.equals("Insert"))
					{
						updateBilling(p,con,"I");
					}
					else
					{
						if(fromNewBorn.equals("Y"))
						{
							updateBilling(p,con,"I");
						}
						else
						{
							updateBilling(p,con,"U");
						}
					}
				}

		
				//added by Himanshu Saxena for AAKH-CRF-0175 as on 23-08-2023 Starts
						try 
							{
							String biometric_reason=(String)insert_values.get("biometric_reason");
							smartCardFunc	= CommonBean.isSiteSpecificforBiometric(con);//added by Himanshu Saxena for AAKH-CRF-0175 as on 23-08-2023 
							if(transaction_completed && smartCardFunc.equals("01") && !biometric_reason.equals(""))
								{
								String fun_id=(String)insert_values.get("fun_id");
								String ref_no=patient_id;
								
								System.out.println(fun_id);
								String status=CommonBean.insertReasonforBiometric(con,(String)insert_values.get("facility_id"),fun_id,patient_id,ref_no,"",biometric_reason,(String)insert_values.get("added_at_ws_no"),(String)insert_values.get("added_by_id"));
								if(status.equals("S"))
									{
									transaction_completed	= true;	
									}
								else {
									transaction_completed	= false;
									}	
								} 
							}
						catch(Exception e)
							{
							transaction_completed	= false;
							System.err.println("++++++++++++++++++++++++++++>"+e);
							e.printStackTrace();
							}
						
						//Ends	
			

				if(transaction_completed)
				{
					con.commit();
					
					
					msg_buffer.append(bl_success_msg+"\\n"+getMessage(locale,"PAT_UPD_SUCCESS","MP"));
					//msg_buffer.append( "<br>");
				}
				else
				{
					con.rollback();
				}
				
				if(rset != null) rset.close();
				if(stmt != null) stmt.close();
			}
			catch(Exception e)
			{
				debug_buffer.append("<br>Main:"+e.toString());
				e.printStackTrace();
			}
			finally
			{
				if(con != null) ConnectionManager.returnConnection(con);
			}
			
			debug_buffer.append("<br>End updatePatient");
			
			ret_hash.put("Debug_Message",debug_buffer);
			ret_hash.put("Message",msg_buffer) ;
			ret_hash.put("Transaction_Completed",new Boolean(transaction_completed));
			ret_hash.put("error_buf",error_buf);
			ret_hash.put("billdoctype",billdoctype);
			ret_hash.put("billdocnum",billdocnum);
			ret_hash.put("billgenlater",billgenlater);
			
			ret_hash.put("bill_prt_format_YN", str_bill_prt_format_YN);
			ret_hash.put("bill_prt_format_vals", str_bill_prt_format_vals);
			ret_hash.put("pgm_id", pgm_id);
			ret_hash.put("session_id", session_id);
			ret_hash.put("pgm_date", pgm_date);
			ret_hash.put("mpi_id_rep", mpi_id_rep);
			
			ret_hash.put("bl_success_msg",bl_success_msg);
		}

		insert_values.clear();

		

        return ret_hash;
    }

    private String generatePatientID()
    {
		String gen_patient_id = "";
      //  String patnoctrl	= "";
        String p_err_msg	= "";
        CallableStatement cs = null;
		
		try
        {

            debug_buffer.append("<br>Start PatientID PatientID");
			
		/*	if(sql.length() > 0) sql.delete(0,sql.length());

            sql.append("SELECT pat_no_ctrl FROM mp_pat_ser_grp WHERE pat_ser_grp_code = '"+insert_values.get("pat_ser_grp_code")+"' ");


			stmt = con.prepareStatement(sql.toString());
			rset = stmt.executeQuery();
            if(rset != null && rset.next())
			{
                patnoctrl = rset.getString("pat_no_ctrl") == null ? "" : rset.getString("pat_no_ctrl");
			}
			if(rset != null) rset.close();
			if(stmt != null) stmt.close();  */
			
			//System.out.println("inside pat gen -- >" );
			String relationship_level = (String)insert_values.get("relationship_level");
			String combined_rel_level_code = "";

			
			if(relationship_level.equals("0"))
			{
				combined_rel_level_code = (String)insert_values.get("relationship_to_head");
			}
			else if(relationship_level.equals("1") || relationship_level.equals("2"))	
			{
				combined_rel_level_code = (String)insert_values.get("combined_rel_level_code");
			}
  
			
			
			cs = con.prepareCall("{call generate_patient_id(?,?,?,?,?,?,?) }");
			

		

			 
            if(pat_no_ctrl.equals("U"))
            {
                if(sql.length() > 0) sql.delete(0,sql.length());

				 cs.setString( 1 ,(String)insert_values.get("pat_ser_grp_code") );
				 cs.setString( 2 ,(String)insert_values.get("facility_id") );
				 cs.setString( 3 ,(String)insert_values.get("alt_id1_no") );
				 cs.setString( 4 ,combined_rel_level_code );
				 cs.setString( 5 ,(String)insert_values.get("sex"));
				 cs.registerOutParameter(6,Types.VARCHAR);
				 cs.registerOutParameter(7,Types.VARCHAR);
                 SRF = (String)insert_values.get("facility_id");
                 Site_or_Facility = "F";
               

            }
            else if(pat_no_ctrl.equals("Z"))
            {
           /*     if(sql.length() > 0) sql.delete(0,sql.length());

                sql.append("SELECT site_id FROM sm_site_param");
        		stmt = con.prepareStatement(sql.toString());
				rset = stmt.executeQuery();
                if(rset != null && rset.next())
				{
                    SRF = rset.getString(1);
				}
				if(stmt != null) stmt.close();
				if(rset != null) rset.close();  */

				if(sql.length() > 0) sql.delete(0,sql.length());

				 cs.setString( 1 ,(String)insert_values.get("pat_ser_grp_code") );
				 cs.setString( 2 ,siteid );
				 cs.setString( 3 ,(String)insert_values.get("alt_id1_no") );
				 cs.setString( 4 ,combined_rel_level_code );
				 cs.setString( 5 ,(String)insert_values.get("sex"));
				 cs.registerOutParameter(6,Types.VARCHAR);
				 cs.registerOutParameter(7,Types.VARCHAR);
                 Site_or_Facility = "S";
				 
            }
			else if(pat_no_ctrl.equals("N"))
			{
				if(sql.length() > 0) sql.delete(0,sql.length());

				 cs.setString( 1 ,(String)insert_values.get("pat_ser_grp_code") );
				 cs.setString( 2 ,siteid );
				 cs.setString( 3 ,(String)insert_values.get("alt_id1_no") );
				 cs.setString( 4 ,combined_rel_level_code );
				 cs.setString( 5 ,(String)insert_values.get("sex"));
				 cs.registerOutParameter(6,Types.VARCHAR);
				 cs.registerOutParameter(7,Types.VARCHAR);
                 Site_or_Facility = "N";
			}


			 cs.execute();
			 gen_patient_id = cs.getString(6);
			 p_err_msg		= cs.getString(7);

			
			 if (gen_patient_id==null)
			 {
				 gen_patient_id = "";
			 }
			 if (p_err_msg==null)
			 {
				 p_err_msg = "";
			 }

			if(cs != null)  cs.close();

		    if  (!p_err_msg.equals(""))
            {
				transaction_completed = false;
				error_buf.append(p_err_msg);
		        throw new Exception (""+p_err_msg);
            }
            else
			{
				transaction_completed = true;
			}

			debug_buffer.append("<br>"+transaction_completed+"<BR>End Generated PatientID :"+transaction_completed);

			if(rset != null) rset.close();
		}
		catch(Exception e)
		{
			transaction_completed = false;
			debug_buffer.append("<br>"+transaction_completed+"<BR>Generate Patient ID:"+e.toString()) ;
			e.printStackTrace();
		}
		return gen_patient_id;
	}

	private String getMessage(String locale, String messageId, String moduleId)
	{
        java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
        return(mesg) ;
    }

    private void insertPatientDtls()
    {
		//System.out.println("insert_values--->"+insert_values);
        transaction_completed = false;

        debug_buffer.append("<br>Start insertPatientDtls");
		try
        {
			String pat_name_as_multipart_yn = (String) insert_values.get("pat_name_as_multipart_yn");
		    String family_name = "";
			String upt_contact_dtls_oa_yn=(String) insert_values.get("upt_contact_dtls_oa_yn");
			//CRF GDOH-CRF-0029 [IN:048764]
		String reg_date=(String)insert_values.get("disas_regn_date_time");

			if(pat_name_as_multipart_yn.equals("N"))
			{
				family_name = (String)insert_values.get("family_name");
				StringTokenizer stkTok = new StringTokenizer(family_name," ");

				if(stkTok.hasMoreTokens()) family_name = stkTok.nextToken();
			}else{
				family_name = (String)insert_values.get("family_name");
			}
			
			if(sql.length() > 0) sql.delete(0,sql.length());
              //CRF GDOH-CRF-0029 [IN:048764]
  			//Added  MYHIX element for integration ML-MMOH-CRF-0507.1
			// modifed query by mujafar for KDAH-CRF-0370.1 start
			 //blood_donor Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857]
			 //uploaded_pat_yn Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1
			 //Maheshwaran K added nat_id_exp_date for the TH-KW-CRF-0019
			 ////Maheshwaran K added -GCC for AAKH-CRF-0168 as on 22-10-2022 - 
			 //Maheshwaran K added -national_id_no_dft for AAK-CRF-0168 as on 19-11-2022
			sql.append("insert into MP_PATIENT (patient_id,patient_name,pat_ser_grp_code,national_id_no,national_id_no_dft,pref_facility_id,alt_id1_no,alt_id1_type,alt_id1_exp_date ,alt_id2_no,alt_id2_type,alt_id2_exp_date,alt_id3_no,alt_id3_type,alt_id3_exp_date,alt_id4_no,alt_id4_type,alt_id4_exp_date,gcc,family_link_no ,relationship_to_head,name_prefix,first_name,family_name,second_name,third_name,name_suffix,sex,date_of_birth,place_of_birth,birth_place_code,mar_status_code,alias_name,household_monthly_income,mother_maiden_name,relgn_code,language_id,race_code,pat_cat_code,ref_source_code,nationality_code,contact1_mode,contact1_no,contact1_status,contact2_mode,contact2_no,contact2_status,contact3_mode,contact3_no,contact3_status,contact4_mode,contact4_no,contact4_status,contact5_mode,contact5_no,contact5_status,res_area_code,res_town_code,res_town_desc,region_code,emeg_regn_yn,inhouse_birth_yn,active_yn,suspend_yn,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,regn_facility_id,generic_sndx_first,generic_sndx_second,generic_sndx_third,generic_sndx_family,generic_sndx_first_second,generic_sndx_first_family,ethnic_sndx_first,ethnic_sndx_second,ethnic_sndx_third,ethnic_sndx_family,ethnic_sndx_first_second,ethnic_sndx_first_family,calculated_age_yn,EMAIL_ID,REFERRAL_FACILITY_ID,name_prefix_loc_lang,first_name_loc_lang,second_name_loc_lang,third_name_loc_lang,family_name_loc_lang,name_suffix_loc_lang,patient_name_loc_lang,data_source,regn_date,primary_language_id,ethnic_grp_code,citizen_yn,legal_yn,oth_alt_id_type,oth_alt_id_no,pat_dtls_unknown_yn,family_org_membership,family_org_id,family_org_sub_id,combined_rel_level_code,pat_cat_code_exp_date,known_allergy_yn,eye_indicator,myhix_consent,myhix_id,PATIENT_LONG_NAME,PATIENT_LONG_NAME_LOC_LANG,HIJRI_BIRTH_DATE,form_60_yn,blood_donor,visa_type,uploaded_pat_yn,primary_nuhdeek_yn,nuhdeek_ready_yn,contact2_country_code,contact2_telephone_code");
		
			if(insert_values.get("chkPanValidate")!=null)
			{
			if((insert_values.get("chkPanValidate")).equals("true"))
				sql.append(",PAN_CARD_STATUS,PAN_CARD_HOLDER_NAME,INT_TRANSACTION_ID,PAN_RELATION");
			}
			// Code added by Sethu for KDAH-CRF-0362 
			if(insert_values.get("chkAadhaarValidate")!=null)
			{
				
				if((insert_values.get("chkAadhaarValidate")).equals("true")){
					insert_values.put("national_id_no","");
					sql.append(",AADHAAR_CARD_STATUS, AADHAAR_TRANS_ID");
				}
			}
			if(insert_values.get("nat_id_exp_date")!=null)
			{
			sql.append(",nat_id_expiry_date");	
			}
			//Maheshwaran K added for MO-CRF-20183.2 as on 08-05-2023
			if(insert_values.get("emp_service_no")!=null){
			sql.append(" ,employee_service_no ");	
			}
			// Code added by Sethu for KDAH-CRF-0362 end
			sql.append(")values('"+patient_id+"','"+(String)insert_values.get("patient_name")+"','"+(String)insert_values.get("pat_ser_grp_code")+"','"+(String)insert_values.get("national_id_no")+"','"+(String)insert_values.get("national_id_no_dft")+"','"+(String)insert_values.get("pref_facility_id")+"','"+(String)insert_values.get("alt_id1_no")+"','"+(String)insert_values.get("alt_id1_type")+"',to_date('"+(String)insert_values.get("alt_id1_exp_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("alt_id2_no")+"','"+(String)insert_values.get("alt_id2_type")+"',to_date('"+(String)insert_values.get("alt_id2_exp_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("alt_id3_no")+"','"+(String)insert_values.get("alt_id3_type")+"',to_date('"+(String)insert_values.get("alt_id3_exp_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("alt_id4_no")+"','"+(String)insert_values.get("alt_id4_type")+"',to_date('"+(String)insert_values.get("alt_id4_exp_date")+"','dd/mm/yyyy'),'"+(String) insert_values.get("gcc")+"','"+(String)insert_values.get("family_link_no")+"','"+(String)insert_values.get("relationship_to_head")+"','"+(String)insert_values.get("name_prefix")+"','"+(String)insert_values.get("first_name")+"','"+(String)insert_values.get("family_name")+"','"+(String)insert_values.get("second_name")+"','"+(String)insert_values.get("third_name")+"','"+(String)insert_values.get("name_suffix")+"','"+(String)insert_values.get("sex")+"',to_date('"+(String)insert_values.get("date_of_birth")+"','dd/mm/yyyy hh24:mi:ss'),'"+(String)insert_values.get("place_of_birth")+"','"+(String)insert_values.get("birth_place_code")+"','"+(String)insert_values.get("mar_status_code")+"','"+(String)insert_values.get("alias_name")+"','"+(String)insert_values.get("household_monthly_income")+"','"+(String)insert_values.get("mother_maiden_name")+"','"+(String)insert_values.get("relgn_code")+"','"+(String)insert_values.get("language_code")+"','"+(String)insert_values.get("race_code")+"','"+(String)insert_values.get("pat_cat_code")+"','"+(String)insert_values.get("ref_source_code")+"','"+(String)insert_values.get("nationality_code")+"','PRN','"+(String)insert_values.get("contact1_no")+"','','ORN','"+(String)insert_values.get("contact2_no")+"','','"+(String)insert_values.get("contact3_mode")+"','"+(String)insert_values.get("contact3_no")+"','','"+(String)insert_values.get("contact4_mode")+"','"+(String)insert_values.get("contact4_no")+"','','"+(String)insert_values.get("contact5_mode")+"','"+(String)insert_values.get("contact5_no")+"','','"+(String)insert_values.get("res_area_code")+"','"+(String)insert_values.get("res_town_code")+"','"+(String)insert_values.get("res_town_desc")+"','"+(String)insert_values.get("res_region_code")+"','"+(String)insert_values.get("emeg_regn_yn")+"','N','Y','N','"+(String)insert_values.get("added_by_id")+"',sysdate,'"+(String)insert_values.get("added_at_ws_no")+"','"+(String)insert_values.get("added_facility_id")+"','"+(String)insert_values.get("added_by_id")+"',sysdate,'"+(String)insert_values.get("added_at_ws_no")+"','"+(String)insert_values.get("added_facility_id")+"','"+(String)insert_values.get("facility_id")+"',SOUNDEX('"+(String)insert_values.get("first_name")+"'),SOUNDEX('"+(String)insert_values.get("second_name")+"'),SOUNDEX('"+(String)insert_values.get("third_name")+"'),SOUNDEX('"+family_name+"'),SOUNDEX('"+((String)insert_values.get("first_name")+(String)insert_values.get("second_name"))+"'),SOUNDEX('"+((String)insert_values.get("first_name")+(String)insert_values.get("family_name"))+"'),ETHNIC_SOUNDEX('"+(String)insert_values.get("first_name")+"'),ETHNIC_SOUNDEX('"+(String)insert_values.get("second_name")+"'),ETHNIC_SOUNDEX('"+(String)insert_values.get("third_name")+"'),ETHNIC_SOUNDEX('"+family_name+"'),ETHNIC_SOUNDEX('"+((String)insert_values.get("first_name")+(String)insert_values.get("second_name"))+"'),ETHNIC_SOUNDEX('"+((String)insert_values.get("first_name")+ (String)insert_values.get("family_name"))+"'),'"+(String)insert_values.get("age_or_dob")+"','"+(String)insert_values.get("email_id")+"','','"+(String)insert_values.get("name_prefix_loc_lang")+"','"+(String)insert_values.get("first_name_loc_lang")+"','"+(String)insert_values.get("second_name_loc_lang")+"','"+(String)insert_values.get("third_name_loc_lang")+"','"+(String)insert_values.get("family_name_loc_lang")+"','"+(String)insert_values.get("name_suffix_loc_lang")+"','"+(String)insert_values.get("patient_name_loc_lang")+ "','"+(String)insert_values.get("data_source")+"'");
			// modifed query by mujafar for KDAH-CRF-0370.1 end
			if(!reg_date.equals("")){
			//sql.append(",to_date(reg_date,'dd/mm/yyyy hh24:mi:ss')");
			//Below line Removed the Seconds
			sql.append(",to_date('"+(String)insert_values.get("disas_regn_date_time")+"','dd/mm/yyyy hh24:mi'),");
			}else{
			sql.append(",to_date(to_char(sysdate,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi'),");
			}
			// modifed query by mujafar for KDAH-CRF-0370.1 start
			sql.append("'"+(String)insert_values.get("prime_language")+"','"+(String)insert_values.get("ethnic_group")+"','"+(String)insert_values.get("citizen_yn")+"','"+(String)insert_values.get("legal_yn")+"','"+(String)insert_values.get("other_alt_id")+"','"+(String)insert_values.get("other_alt_Id_text")+"','"+(String)insert_values.get("pat_dtls_unknown_yn")+"','"+(String)insert_values.get("family_org_membership")+"','"+(String)insert_values.get("family_org_id")+"','"+(String)insert_values.get("family_org_sub_id")+"','"+(String)insert_values.get("combined_rel_level_code")+"',to_date('"+(String)insert_values.get("pat_cat_code_exp_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("known_allergy_yn")+"','"+(String)insert_values.get("eye_indicator")+"','"+(String)insert_values.get("myhix_consent")+"','"+(String)insert_values.get("abha_pat_id")+"','"+(String)insert_values.get("patient_name_long")+"','"+(String)insert_values.get("patient_name_loc_lang_long")+"','"+(String)insert_values.get("date_of_birth_hj")+"','"+(String)insert_values.get("form_60_yn")+"','"+(String)insert_values.get("blood_donor")+"','"+(String)insert_values.get("visa_type")+"','"+(String)insert_values.get("uploaded_pat_yn")+"','"+(String)insert_values.get("primary_nuhdeek_yn")+"','"+(String)insert_values.get("nuhdeek_ready_yn")+"','"+(String)insert_values.get("countryC")+"','"+(String)insert_values.get("telephone")+"'"); /*Modified by Ashwini on 14-May-2019 for TBMC-CRF-0010.1*//*Modified by Arthi for ML-MMOH-CRF-1930 US004*/
			 //blood_donor Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857]

			if(insert_values.get("chkPanValidate")!=null)
			{
			if((insert_values.get("chkPanValidate")).equals("true"))
			sql.append(",'"+(String)insert_values.get("pan_status")+"','"+(String)insert_values.get("pan_holder_name")+"','"+(String)insert_values.get("pan_trans_id")+"','"+(String)insert_values.get("pan_rel_mem")+"'");
			}
			// Code added by Sethu for KDAH-CRF-0362 
			if(insert_values.get("chkAadhaarValidate")!=null)
			{
				System.out.println(" ::: insert_values.get(chkAadhaarValidate) ::: "+insert_values.get("chkAadhaarValidate"));
			if((insert_values.get("chkAadhaarValidate")).equals("true"))
			sql.append(",'"+(String)insert_values.get("aadhaarStatus")+"','"+(String)insert_values.get("aadhaarTransId")+"'");
			}
			if(insert_values.get("nat_id_exp_date")!=null)
			{
			sql.append(",to_date('"+(String)insert_values.get("nat_id_exp_date")+"','dd/mm/yyyy')");	
			}
			//Maheshwaran K added for MO-CRF-20183.2 as on 08-05-2023
			if(insert_values.get("emp_service_no")!=null)
			{
			sql.append(" ,'"+(String)insert_values.get("emp_service_no")+"'");	
			}
			// Code added by Sethu for KDAH-CRF-0362 end
			sql.append(")");
			
			// modifed query by mujafar for KDAH-CRF-0370.1 end



			if(stmt!= null) stmt.close();
			
			stmt = con.prepareStatement(sql.toString());
			if(stmt.executeUpdate() >0 )
            {
				if(sql.length() > 0) sql.delete(0,sql.length());

                sql.append("insert into MP_PAT_OTH_DTLS (patient_id,education_level,regn_informant,regn_comments,general_remarks,regn_complete_yn,living_dependency,living_arrangement,addl_field1,addl_field2,addl_field3,addl_field4,addl_field5,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,blood_grp,rh_factor)values('"+patient_id+"','"+insert_values.get("education_level")+"','"+insert_values.get("regn_informant")+"','"+insert_values.get("regn_comments")+"','"+insert_values.get("general_remarks")+"','Y','"+insert_values.get("living_dependency")+"','"+insert_values.get("living_arrangement")+"','"+insert_values.get("addl_field1")+"','"+insert_values.get("addl_field2")+"','"+insert_values.get("addl_field3")+"','"+insert_values.get("addl_field4")+"','"+insert_values.get("addl_field5")+"','"+(String)insert_values.get("added_by_id")+"',sysdate,'"+(String)insert_values.get("added_at_ws_no")+"','"+(String)insert_values.get("added_facility_id")+"','"+(String)insert_values.get("added_by_id")+"',sysdate,'"+(String)insert_values.get("added_at_ws_no")+"','"+(String)insert_values.get("added_facility_id")+"','"+(String)insert_values.get("blood_group")+"','"+(String)insert_values.get("rf_code")+"')");
				if(stmt!=null) stmt.close();
				stmt = con.prepareStatement(sql.toString());

                if(stmt.executeUpdate()>0)
                {
					if(sql.length() > 0) sql.delete(0,sql.length());
					
					//Below query modified for this CRF ML-MMOH-CRF-0860.2
					
                    sql.append("insert into MP_PAT_ADDRESSES(patient_id,addr1_type,addr1_line1,addr1_line2,addr1_line3,addr1_line4,postal1_code,country1_code,contact1_name,addr2_type,addr2_line1,addr2_line2,addr2_line3,addr2_line4,postal2_code,country2_code,contact2_name,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,res_area2_code,res_town2_code,region2_code,res_area1_code,res_town1_code,region1_code,alt_addr_type,alt_addr_line1,alt_addr_line2,alt_addr_line3,alt_addr_line4,alt_region_code,alt_area_code,alt_town_code,alt_postal_code,alt_country_code,alt_contact_name)values('"+patient_id+"','RES','"+insert_values.get("res_addr_line1")+"','"+insert_values.get("res_addr_line2")+"','"+insert_values.get("res_addr_line3")+"','"+insert_values.get("res_addr_line4")+"','"+insert_values.get("res_postal_code")+"','"+insert_values.get("res_country_code")+"','"+insert_values.get("res_contact_name")+"','MAI','"+insert_values.get("mail_addr_line1")+"','"+insert_values.get("mail_addr_line2")+"','"+insert_values.get("mail_addr_line3")+"','"+insert_values.get("mail_addr_line4")+"','"+insert_values.get("mail_postal_code")+"','"+insert_values.get("mail_country_code")+"','"+insert_values.get("mail_contact_name")+"','"+(String)insert_values.get("added_by_id")+"',sysdate,'"+(String)insert_values.get("added_at_ws_no")+"','"+(String)insert_values.get("added_facility_id")+"','"+(String)insert_values.get("added_by_id")+"',sysdate,'"+(String)insert_values.get("added_at_ws_no")+"','"+(String)insert_values.get("added_facility_id")+"','"+(String)insert_values.get("res_area2_code")+"','"+(String)insert_values.get("res_town2_code")+"','"+(String)insert_values.get("region2_code")+"','"+(String)insert_values.get("res_area_code")+"','"+(String)insert_values.get("res_town_code")+"','"+(String)insert_values.get("res_region_code")+"','ALT','"+(String)insert_values.get("alt_addr_line1")+"','"+(String)insert_values.get("alt_addr_line2")+"','"+(String)insert_values.get("alt_addr_line3")+"','"+(String)insert_values.get("alt_addr_line4")+"','"+(String)insert_values.get("alt_region_code")+"','"+(String)insert_values.get("alt_area_code")+"','"+(String)insert_values.get("alt_town_code")+"','"+(String)insert_values.get("alt_postal_code")+"','"+(String)insert_values.get("alt_country_code")+"','"+(String)insert_values.get("alt_contact_name")+"')");

					 if(stmt!=null) stmt.close();
					 stmt = con.prepareStatement(sql.toString());

                     if(stmt.executeUpdate()>0 )
                     {
						if(sql.length() > 0) sql.delete(0,sql.length());

						sql.append( "insert into MP_PAT_REL_CONTACTS(patient_id,contact1_relation,contact1_name,job1_title,addr1_line1,addr1_line2,addr1_line3,addr1_line4,postal1_code,country1_code,res1_tel_no,off1_tel_no,contact2_relation,contact2_name,job2_title,addr2_line1,addr2_line2,addr2_line3,addr2_line4,postal2_code,country2_code,res2_tel_no,off2_tel_no,contact3_name,job3_title,addr3_line1,addr3_line2,addr3_line3,addr3_line4,postal3_code,country3_code,off3_tel_no,off_fax_no,ocpn_code,ocpn_desc,employment_status,patient_employee_id,contact1_role,contact2_role,contact3_role,added_by_id,added_date ,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,organization_name,contact3_res_area_code,contact3_res_town_code,contact3_region_code,contact2_mob_tel_no,contact2_email_id,contact2_res_area_code,contact2_region_code,contact2_res_town_code,contact1_alt_id1_type,contact1_alt_id1_no,contact1_alt_id2_type,contact1_alt_id2_no,contact1_alt_id3_type,contact1_alt_id3_no,contact1_alt_id4_type,contact1_alt_id4_no,contact1_nat_id_no,contact1_oth_alt_id_type,contact1_oth_alt_id_no,contact1_birth_date,contact1_res_area_code,contact1_region_code,contact1_res_town_code,contact1_mob_tel_no,contact1_email_id,res3_tel_no,ocpn_class_code,contact2_nat_id_no,contact2_oth_alt_id_type,contact2_oth_alt_id_no,contact1_aliasname,contact1_nationality,contact1_race,nk_mail_addr_line1,nk_mail_addr_line2,nk_mail_addr_line3,nk_mail_addr_line4,nk_mail_town_code,nk_mail_region_code,nk_mail_area_code,nk_mail_postal_code,nk_mail_country_code,nk_res_contact_name,nk_mail_contact_name,nk_contact3_mode,nk_contact3_no,nk_contact4_mode,nk_contact4_no,nk_contact5_mode,nk_contact5_no,fton_mail_addr_line1,fton_mail_addr_line2,fton_mail_addr_line3,fton_mail_addr_line4,fton_mail_town_code,fton_mail_area_code,fton_mail_region_code,fton_mail_postal_code,fton_mail_country_code,fton_res_contact_name,fton_mail_contact_name,fton_contact3_mode,fton_contact3_no,fton_contact4_mode,fton_contact4_no,fton_contact5_mode,fton_contact5_no,contact1_country_code,contact1_telephone_code,CONTACT1_MOB_COUNTRY_CODE)values('"+patient_id+"','"+(String)insert_values.get("next_contact_relation")+"','"+(String)insert_values.get("next_contact_name")+"','"+(String)insert_values.get("next_job_title")+"','"+(String)insert_values.get("next_addr_line1")+"','"+(String)insert_values.get("next_addr_line2")+"','"+(String)insert_values.get("next_addr_line3")+"','"+(String)insert_values.get("next_addr_line4")+"','"+(String)insert_values.get("next_postal_code")+"','"+(String)insert_values.get("next_country_code")+"','"+(String)insert_values.get("next_res_tel_no")+"','"+(String)insert_values.get("next_off_tel_no")+"','"+(String)insert_values.get("first_contact_relation")+"','"+(String)insert_values.get("first_contact_name")+"','"+(String)insert_values.get("first_job_title")+"','"+(String)insert_values.get("first_addr_line1")+"','"+(String)insert_values.get("first_addr_line2")+"','"+(String)insert_values.get("first_addr_line3")+"','"+(String)insert_values.get("first_addr_line4")+"','"+(String)insert_values.get("first_postal_code")+"','"+(String)insert_values.get("first_country_code")+"','"+(String)insert_values.get("first_res_tel_no")+"','"+(String)insert_values.get("first_off_tel_no")+"','"+(String)insert_values.get("empyr_contact_name")+"','"+(String)insert_values.get("empyr_job_title")+"','"+(String)insert_values.get("employ_addr_line1")+"','"+(String)insert_values.get("employ_addr_line2")+"','"+(String)insert_values.get("employ_addr_line3")+"','"+(String)insert_values.get("employ_addr_line4")+"','"+(String)insert_values.get("employ_postal_code")+"','"+(String)insert_values.get("empyr_country_code")+"','"+(String)insert_values.get("empyr_off_tel_no")+"','"+(String)insert_values.get("empyr_off_fax_no")+"','"+(String)insert_values.get("occ_of_per")+"','"+(String)insert_values.get("occu_of_per_desc")+"','"+(String)insert_values.get("empyr_employment_status")+"','"+(String)insert_values.get("empyr_eid")+"','NEXT','FRST','EMPR','"+(String)insert_values.get("added_by_id")+"',sysdate,'"+(String)insert_values.get("added_at_ws_no")+"','"+(String)insert_values.get("added_facility_id")+"','"+(String)insert_values.get("added_by_id")+"',sysdate,'"+(String)insert_values.get("added_at_ws_no")+"','"+(String)insert_values.get("added_facility_id")+"','"+(String)insert_values.get("organization_name")+"','"+(String)insert_values.get("contact3_res_area_code")+"','"+(String)insert_values.get("contact3_res_town_code")+"','"+(String)insert_values.get("contact3_region_code")+"','"+(String)insert_values.get("contact2_mob_tel_no")+"','"+(String)insert_values.get("contact2_email_id")+"','"+(String)insert_values.get("contact2_res_area_code")+"','"+(String)insert_values.get("contact2_region_code")+"','"+(String)insert_values.get("contact2_res_town_code")+"','"+(String)insert_values.get("contact1_alt_id1_type")+"','"+(String)insert_values.get("contact1_alt_id1_no")+"','"+(String)insert_values.get("contact1_alt_id2_type")+"','"+(String)insert_values.get("contact1_alt_id2_no")+"','"+(String)insert_values.get("contact1_alt_id3_type")+"','"+(String)insert_values.get("contact1_alt_id3_no")+"','"+(String)insert_values.get("contact1_alt_id4_type")+"','"+(String)insert_values.get("contact1_alt_id4_no")+"','"+(String)insert_values.get("contact1_new_nat_id_no")+"','"+(String)insert_values.get("contact1_oth_alt_id_type")+"','"+(String)insert_values.get("contact1_oth_alt_id_no")+"',to_date('"+(String)insert_values.get("contact1_birth_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("contact1_res_area_code")+"','"+(String)insert_values.get("contact1_region_code")+"','"+(String)insert_values.get("contact1_res_town_code")+"','"+(String)insert_values.get("contact1_mob_tel_no")+"','"+(String)insert_values.get("contact1_email_id")+"','"+(String)insert_values.get("res3_tel_no")+"','"+(String)insert_values.get("occ_class")+"','"+(String)insert_values.get("contact2_nat_id_no")+"','"+(String)insert_values.get("notify_oth_alt_id_type")+"','"+(String)insert_values.get("notify_oth_alt_id_text")+"','"+(String)insert_values.get("rel_alias_name")+"','"+(String)insert_values.get("rel_nationality_code")+"','"+(String)insert_values.get("rel_race_code")+"','"+(String)insert_values.get("n_next_addr_line1")+"','"+(String)insert_values.get("n_ma_addr_line2")+"','"+(String)insert_values.get("n_ma_addr_line3")+"','"+(String)insert_values.get("n_ma_addr_line4")+"','"+(String)insert_values.get("n_contact_ma_town_code")+"','"+(String)insert_values.get("n_contac_region_code")+"','"+(String)insert_values.get("n_contact_ma_area_code")+"','"+(String)insert_values.get("n_ma_postal_code")+"','"+(String)insert_values.get("nkin_m_country_desc")+"','"+(String)insert_values.get("resadd_contact_name")+"','"+(String)insert_values.get("mailadd_contact_name")+"','"+(String)insert_values.get("nk_contact3_mode")+"','"+(String)insert_values.get("nk_contact3_no")+"','"+(String)insert_values.get("nk_contact4_mode")+"','"+(String)insert_values.get("nk_contact4_no")+"','"+(String)insert_values.get("nk_contact5_mode")+"','"+(String)insert_values.get("nk_contact5_no")+"','"+(String)insert_values.get("fton_mail_addr_line1")+"','"+(String)insert_values.get("fton_mail_addr_line2")+"','"+(String)insert_values.get("fton_mail_addr_line3")+"','"+(String)insert_values.get("fton_mail_addr_line4")+"','"+(String)insert_values.get("fst_to_no_ma_town_code")+"','"+(String)insert_values.get("fst_to_no_ma_area_code")+"','"+(String)insert_values.get("fst_to_no_ma_reg_cod")+"','"+(String)insert_values.get("fst_no_ma_pos_cod")+"','"+(String)insert_values.get("fton_m_country_desc")+"','"+(String)insert_values.get("fton_resadd_contact_name")+"','"+(String)insert_values.get("fton_mailadd_contact_name")+"','"+(String)insert_values.get("fton_contact3_mode")+"','"+(String)insert_values.get("fton_contact3_no")+"','"+(String)insert_values.get("fton_contact4_mode")+"','"+(String)insert_values.get("fton_contact4_no")+"','"+(String)insert_values.get("fton_contact5_mode")+"','"+(String)insert_values.get("fton_contact5_no")+"','"+(String)insert_values.get("countryC")+"','"+(String)insert_values.get("telephone")+"','"+(String)insert_values.get("CONTACT1_MOB_COUNTRY_CODE")+"')");//Query Modified by Suji Keerthi for ML-MMOH-CRF-1527 US008//Modified by Arthi for ML-MMOH-CRF-1930 US004 //Modified by Ajay for ML-MMOH-CRF-1930
 
						if(stmt!=null) stmt.close();
						stmt = con.prepareStatement(sql.toString());
                        if(stmt.executeUpdate()>0)
                        {
                            updatePatDocs();
                        }
                    }
                }
            }
            debug_buffer.append("<br>"+transaction_completed+"<BR>End insertPatientDtls") ;
		 }
        catch(Exception e)
        {
            transaction_completed = false;
            debug_buffer.append("<br>Update Patient Details:"+e.toString()) ;
			error_buf.append("Error in Insert: "+e.toString());
			e.printStackTrace();
		}
    }

    private void updatePatientList()
    {
       debug_buffer.append("<br>Start updatePatientList");
       transaction_completed = false;
       CallableStatement cs = null;
        try
        {
            cs = con.prepareCall("{call update_patient_access_list(?,?,?)}");
            cs.setString( 1 ,(String)insert_values.get("added_by_id") );
            cs.setString( 2 ,(String)insert_values.get("session_id") );
            cs.setString( 3 , patient_id);
            cs.execute();
            transaction_completed = true ;

            debug_buffer.append("<br>"+transaction_completed+"<BR>End updatePatientList") ;
			 if(cs != null)  cs.close();
        }
        catch(Exception e)
        {
            transaction_completed = false;
            debug_buffer.append("<br>Update Patient List:"+e.toString()) ;
			error_buf.append("Error in Update Patient Access List: "+e.toString());
			e.printStackTrace();
        }

    }

    private void updateAppointment()
    {
        transaction_completed = false;
        debug_buffer.append("<br>Start updateAppointment") ;
		String isVirtualConsultation=(String)insert_values.get("isVirtualConsultation");
		try
        {
            if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("update OA_APPT set patient_id = '"+patient_id+"',name_prefix = '"+insert_values.get("name_prefix")+"',name_suffix = '"+insert_values.get("name_suffix")+"',first_name = '"+insert_values.get("first_name")+"',second_name = '"+insert_values.get("second_name")+"',third_name = '"+insert_values.get("third_name")+"',family_name ='"+insert_values.get("family_name")+"',patient_name = '"+insert_values.get("patient_name")+"',PATIENT_LONG_NAME='"+insert_values.get("patient_name_long")+"',PATIENT_LONG_NAME_LOC_LANG='"+insert_values.get("patient_name_loc_lang_long")+"',name_prefix_loc_lang = '"+insert_values.get("name_prefix_loc_lang")+"',name_suffix_loc_lang = '"+insert_values.get("name_suffix_loc_lang")+"',first_name_loc_lang = '"+insert_values.get("first_name_loc_lang")+"',second_name_loc_lang = '"+insert_values.get("second_name_loc_lang")+"',third_name_loc_lang = '"+insert_values.get("third_name_loc_lang")+"',family_name_loc_lang ='"+insert_values.get("family_name_loc_lang")+"',patient_name_loc_lang = '"+insert_values.get("patient_name_loc_lang")+"' , gender = '"+insert_values.get("sex")+"',res_tel_no = '"+insert_values.get("contact1_no")+"',oth_contact_no = '"+insert_values.get("contact2_no")+"',email_id = '"+insert_values.get("email_id")+"',national_id_no = '"+insert_values.get("national_id_no")+"',alt_id1_no = '"+insert_values.get("alt_id1_no")+"',res_addr_line1 = '"+insert_values.get("res_addr_line1")+"',res_addr_line2 = '"+insert_values.get("res_addr_line2")+"',res_addr_line3 = '"+insert_values.get("res_addr_line3")+"',res_addr_line4 = '"+insert_values.get("res_addr_line4")+"',res_area_code = '"+insert_values.get("res_area_code")+"',res_town_code = '"+insert_values.get("res_town_code")+"',res_region_code = '"+insert_values.get("res_region_code")+"',res_country_code = '"+insert_values.get("res_country_code")+"',postal_code = '"+insert_values.get("res_postal_code")+"',alt_id1_exp_date =to_date('"+(String)insert_values.get("alt_id1_exp_date")+"','dd/mm/yyyy'),alt_id1_type = '"+insert_values.get("alt_id1_type")+"',alt_id2_type = '"+insert_values.get("alt_id2_type")+"',alt_id2_no = '"+insert_values.get("alt_id2_no")+"',alt_id2_exp_date = to_date('"+(String)insert_values.get("alt_id2_exp_date")+"','dd/mm/yyyy'),alt_id3_type = '"+insert_values.get("alt_id3_type")+"',alt_id3_no = '"+insert_values.get("alt_id3_no")+"',alt_id3_exp_date = to_date('"+(String)insert_values.get("alt_id3_exp_date")+"','dd/mm/yyyy'),alt_id4_type = '"+insert_values.get("alt_id4_type")+"',alt_id4_no = '"+insert_values.get("alt_id4_no")+"',alt_id4_exp_date = to_date('"+(String)insert_values.get("alt_id4_exp_date")+"','dd/mm/yyyy'),oth_alt_id_type = '"+(String)insert_values.get("other_alt_id")+"',oth_alt_id_no = '"+(String)insert_values.get("other_alt_Id_text")+"',mail_addr_line1 = '"+insert_values.get("mail_addr_line1")+"',mail_addr_line2 = '"+insert_values.get("mail_addr_line2")+"',mail_addr_line3 = '"+insert_values.get("mail_addr_line3")+"',mail_addr_line4 ='"+insert_values.get("mail_addr_line4")+"',mail_area_code = '"+insert_values.get("mail_area_code")+"',mail_town_code = '"+insert_values.get("mail_town_code")+"',mail_region_code = '"+insert_values.get("mail_region_code")+"',mail_postal_code = '"+insert_values.get("mail_postal_code")+"',mail_country_code = '"+insert_values.get("mail_country_code")+"',date_of_birth = to_date('"+insert_values.get("date_of_birth")+"','dd/mm/yyyy hh24:mi:ss'),race_code = '"+insert_values.get("race_code")+"',ethnic_group_code = '"+insert_values.get("ethnic_group")+"',birth_place_code = '"+insert_values.get("birth_place_code")+"',birth_place_desc = '"+insert_values.get("place_of_birth")+"',citizen_yn = '"+insert_values.get("citizen_yn")+"',legal_yn = '"+insert_values.get("legal_yn")+"',modified_by_id = '"+insert_values.get("added_by_id")+"',modified_date = sysdate,modified_at_ws_no = '"+insert_values.get("added_at_ws_no")+"',modified_facility_id  = '"+insert_values.get("added_facility_id")+"',patient_cat_code  = '"+(String)insert_values.get("pat_cat_code")+"',language_id  = '"+(String)insert_values.get("language_code")+"' ") ; //Modified for ML-MMOH-CRF-1930 US004

			if(isVirtualConsultation.equals("true"))
			{
				sql.append(" ,CONTACT1_MOB_COUNTRY_CODE  = '"+(String)insert_values.get("CONTACT1_MOB_COUNTRY_CODE")+"',contact1_mob_tel_no  = '"+(String)insert_values.get("contact1_mob_tel_no")+"',contact2_country_code  = '"+(String)insert_values.get("countryC")+"',contact2_telephone_code  = '"+(String)insert_values.get("telephone")+"'  ");
			}

			sql.append(" where facility_id =  '"+(String)insert_values.get("facility_id")+"' AND PATIENT_ID is null ");



			if(refrlAappt.equals("A"))
			{
				sql.append(" AND appt_ref_no = '"+refIDValue+"' ");
			}
			else
			{
				sql.append(" AND appt_ref_no = '"+apptrefno+"' ");
			}
			if(stmt!=null) stmt.close();
			stmt = con.prepareStatement(sql.toString());
            if(stmt.executeUpdate()>0) transaction_completed = true ;
			else
			{
				transaction_completed	= false;
				tableUpdated			= false;
			}

            debug_buffer.append("<br>"+transaction_completed+"<BR>End updateAppointment") ;
        }
        catch (Exception e)
        {
            transaction_completed = false;
            debug_buffer.append("<br>Update Appointment:"+e.toString()) ;
			error_buf.append("Error in Update Appointment: "+e.toString());
			e.printStackTrace();
        }
    }

	////start of updateDlaphoto
	private void updateDlaphoto(String image_yn)
    {
        //transaction_completed = false;
        //debug_buffer.append("<br>Start updateDlaphoto") ;

		

		try
        {
			if(sql.length() > 0) sql.delete(0,sql.length());
			if(stmt!=null) stmt.close();

			ResultSet rs = null;  
			int photo_cnt = 0; 		

			//sql.append("select 1 from mp_patient_photo where patient_id='"+patient_id+"'");

			stmt = con.prepareStatement("select 1 from mp_patient_photo where patient_id='"+patient_id+"'");
			rs = stmt.executeQuery();

			if(rs!=null && rs.next())
				photo_cnt = 1;

			if(rs!=null) rs.close(); 			
			if(stmt!=null) stmt.close();

			if(image_yn.equals("Y"))
			{
								
				if( photo_cnt > 0 )
				{
					
					
					sql.append("update MP_PATIENT_PHOTO set PAT_PHOTO_BLOB = ?, modified_by_id = ?, modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id  = ? where patient_id= ?");

					stmt = con.prepareStatement(sql.toString());
					stmt.setBytes(1,decodedData);
					stmt.setString(2,(String)insert_values.get("added_by_id"));
					stmt.setString(3,(String)insert_values.get("added_at_ws_no"));
					stmt.setString(4,(String)insert_values.get("added_facility_id"));
					stmt.setString(5,patient_id);
					//stmt.executeUpdate();

					if(stmt.executeUpdate()>0) {
						
						transaction_completed = true ;
					} else {
						
						transaction_completed	= false;
						//tableUpdated			= false;
					}	
				}
				else
				{

					
				   
				   sql.append("INSERT INTO MP_PATIENT_PHOTO(PAT_PHOTO_BLOB,PATIENT_ID,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) VALUES (?,'"+patient_id+"',?,sysdate,?,?,?,sysdate,?,?)");

				   stmt = con.prepareStatement(sql.toString());
				   stmt.setBytes(1,decodedData);
				   stmt.setString(2,(String)insert_values.get("added_by_id"));
				   stmt.setString(3,(String)insert_values.get("added_at_ws_no"));
				   stmt.setString(4,(String)insert_values.get("added_facility_id"));
				   stmt.setString(5,(String)insert_values.get("added_by_id"));
				   stmt.setString(6,(String)insert_values.get("added_at_ws_no"));
				   stmt.setString(7,(String)insert_values.get("added_facility_id"));

				   //stmt.executeUpdate();

				   if(stmt.executeUpdate()>0) {						    
						transaction_completed = true ;
					} else { 						
						transaction_completed	= false;
						//tableUpdated			= false;
					}	
				}				
			}
			else if(image_yn.equals("N"))
			{
				if( photo_cnt > 0 )
				{					
					stmt = con.prepareStatement("delete from mp_patient_photo where patient_id='"+patient_id+"'");
					//stmt.executeUpdate();
					if(stmt.executeUpdate()>0) {
						transaction_completed = true ;
					} else {
						transaction_completed	= false;
						//tableUpdated			= false;
					}	
				}
			}

			if(rs!=null) 
				rs.close();				
			if(stmt!=null) 
				stmt.close();
        }
        catch (Exception e)
        {
			transaction_completed = false;
			//tableUpdated = false;
            debug_buffer.append("<br>updateDlaphoto: "+e.toString()) ;
			error_buf.append("Exception occured while Insert/Updating DLA Photo in Register Patient...");
			e.printStackTrace();

        }
    }
	////end of updateDlaphoto
	////Update Patient Photo from myKad Reader for Serdang
	private void savePatientPhoto()
    {
        //transaction_completed = false;
        //debug_buffer.append("<br>Start updateDlaphoto") ;


		try
        {
			if(sql.length() > 0) sql.delete(0,sql.length());
			if(stmt!=null) stmt.close();

			ResultSet rs = null;  
			int photo_cnt = 0; 		

			//sql.append("select 1 from mp_patient_photo where patient_id='"+patient_id+"'");

			stmt = con.prepareStatement("select 1 from mp_patient_photo where patient_id='"+patient_id+"'");
			rs = stmt.executeQuery();

			if(rs!=null && rs.next())
				photo_cnt = 1;
			if(rs!=null) rs.close(); 			
			if(stmt!=null) stmt.close();

		//	if(image_yn.equals("Y"))
		//	{
								
				if( photo_cnt > 0 )
				{
					
					
					sql.append("update MP_PATIENT_PHOTO set PAT_PHOTO_BLOB = ?, modified_by_id = ?, modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id  = ? where patient_id= ?");

					stmt = con.prepareStatement(sql.toString());
					stmt.setBytes(1,patPhotoDecodedData);
					stmt.setString(2,(String)insert_values.get("added_by_id"));
					stmt.setString(3,(String)insert_values.get("added_at_ws_no"));
					stmt.setString(4,(String)insert_values.get("added_facility_id"));
					stmt.setString(5,patient_id);
					//stmt.executeUpdate();

					if(stmt.executeUpdate()>0) {
						
						transaction_completed = true ;
					} else {
						
						transaction_completed	= false;
						//tableUpdated			= false;
					}	
				}
				else
				{

					
				   
				   sql.append("INSERT INTO MP_PATIENT_PHOTO(PAT_PHOTO_BLOB,PATIENT_ID,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) VALUES (?,'"+patient_id+"',?,sysdate,?,?,?,sysdate,?,?)");

				   stmt = con.prepareStatement(sql.toString());
				   stmt.setBytes(1,patPhotoDecodedData);
				   stmt.setString(2,(String)insert_values.get("added_by_id"));
				   stmt.setString(3,(String)insert_values.get("added_at_ws_no"));
				   stmt.setString(4,(String)insert_values.get("added_facility_id"));
				   stmt.setString(5,(String)insert_values.get("added_by_id"));
				   stmt.setString(6,(String)insert_values.get("added_at_ws_no"));
				   stmt.setString(7,(String)insert_values.get("added_facility_id"));

				   //stmt.executeUpdate();

				   if(stmt.executeUpdate()>0) {						    
						transaction_completed = true ;
					} else { 						
						transaction_completed	= false;
						//tableUpdated			= false;
					}	
				}				
		/*	}
			else if(image_yn.equals("N"))
			{
				if( photo_cnt > 0 )
				{					
					stmt = con.prepareStatement("delete from mp_patient_photo where patient_id='"+patient_id+"'");
					//stmt.executeUpdate();
					if(stmt.executeUpdate()>0) {
						transaction_completed = true ;
					} else {
						transaction_completed	= false;
						//tableUpdated			= false;
					}	
				}
			}*/

			if(rs!=null) 
				rs.close();				
			if(stmt!=null) 
				stmt.close();
        }
        catch (Exception e)
        {
			transaction_completed = false;
			//tableUpdated = false;
            debug_buffer.append("<br>savePatientPhoto: "+e.toString()) ;
			error_buf.append("Exception occured while saving Patient Photo in Register Patient...");
			e.printStackTrace();

        }
    }
	////Update Patient Photo from myKad Reader for Serdang
	////////////////// updation of table RD_APPT ////////////////////////

	public void updateRDAppt()
	{
        transaction_completed = false;
        debug_buffer.append("<br>Start updateRDAppt") ;
		try
        {
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("UPDATE rd_appt SET "+
                    "patient_id = '"+patient_id+"' ,"+
                    "first_name = '"+insert_values.get("first_name")+"' ,"+
                    "second_name = '"+insert_values.get("second_name")+"' ,"+
                    "third_name = '"+insert_values.get("third_name")+"' ,"+
                    "last_name = '"+insert_values.get("family_name")+"' ,"+
                    "short_name = '"+insert_values.get("patient_name")+"' ,"+
                    "title_code = '"+insert_values.get("name_prefix")+"' ,"+
                    "name_suffix = '"+insert_values.get("name_suffix")+"' ,"+
                    "sex = '"+insert_values.get("sex")+"' ,"+
				    "res_telephone_num = '"+insert_values.get("contact1_no")+"' ,"+
					"other_contact_num = '"+insert_values.get("contact2_no")+"' ,"+
				    "national_id_num = '"+insert_values.get("national_id_no")+"' ,"+
				    "ln1_res_add = '"+insert_values.get("res_addr_line1")+"' ,"+
				    "ln2_res_add = '"+insert_values.get("res_addr_line2")+"' ,"+
				    "ln3_res_add = '"+insert_values.get("res_addr_line3")+"' ,"+
				    "ln4_res_add = '"+insert_values.get("res_addr_line4")+"' ,"+
				    "date_of_birth = to_date('"+insert_values.get("date_of_birth")+"','dd/mm/yyyy hh24:mi:ss'),"+
					"modified_by_id = '"+insert_values.get("added_by_id")+"' ,"+
                    "modified_date = sysdate,"+
                    "modified_at_ws_no = '"+insert_values.get("added_at_ws_no")+"' ,"+
                    "modified_facility_id  = '"+insert_values.get("added_facility_id")+"' "+
                    "where operating_facility_id='"+(String)insert_values.get("facility_id")+"' AND appt_ref_num = '"+refIDValue+"' AND PATIENT_ID is null ") ;

            debug_buffer.append("updateRDAppt:"+sql.toString()) ;


			if(stmt!=null) stmt.close();
			stmt = con.prepareStatement(sql.toString());

            if(stmt.executeUpdate()>0) transaction_completed = true ;
			else
			{
				transaction_completed	= false;
				tableUpdated			= false;
			}

            debug_buffer.append("<br>"+transaction_completed+"<BR>End updateRDAppt") ;
        }
        catch (Exception e)
        {
            transaction_completed = false;
            debug_buffer.append("<br>updateRDAppt:"+e.toString()) ;
			error_buf.append("Error in updateRDAppt : "+e.toString());
			e.printStackTrace();
        }
    }

	//////////////////End of Update RD_APPT///////////////////////

    private void updateIPBooking()
    {
        transaction_completed = false;
        debug_buffer.append("<br>Start updateIPBooking") ;
        try
        {
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" update IP_BOOKING_LIST set patient_id = '"+patient_id+"',name_prefix = '"+insert_values.get("name_prefix")+"',first_name = '"+insert_values.get("first_name")+"',second_name = '"+insert_values.get("second_name")+"',third_name = '"+insert_values.get("third_name")+"',family_name = '"+insert_values.get("family_name")+"',name_suffix = '"+insert_values.get("name_suffix")+"',patient_name = '"+insert_values.get("patient_name")+"',PATIENT_LONG_NAME='"+insert_values.get("patient_name_long")+"',PATIENT_LONG_NAME_LOC_LANG='"+insert_values.get("patient_name_loc_lang_long")+"',name_prefix_loc_lang = '"+insert_values.get("name_prefix_loc_lang")+"',name_suffix_loc_lang = '"+insert_values.get("name_suffix_loc_lang")+"',first_name_loc_lang = '"+insert_values.get("first_name_loc_lang")+"',second_name_loc_lang = '"+insert_values.get("second_name_loc_lang")+"',third_name_loc_lang = '"+insert_values.get("third_name_loc_lang")+"',family_name_loc_lang ='"+insert_values.get("family_name_loc_lang")+"',patient_name_loc_lang = '"+insert_values.get("patient_name_loc_lang")+"',gender = '"+insert_values.get("sex")+"',date_of_birth = to_date('"+insert_values.get("date_of_birth")+"','dd/mm/yyyy hh24:mi:ss'),res_tel_no = '"+insert_values.get("contact1_no")+"',oth_contact_no = '"+insert_values.get("contact2_no")+"',email_id = '"+insert_values.get("email_id")+"',national_id_no = '"+insert_values.get("national_id_no")+"',alt_id1_no = '"+insert_values.get("alt_id1_no")+"',alt_id1_exp_date = to_date('"+insert_values.get("alt_id1_exp_date")+"','dd/mm/yyyy') ,res_addr_line1 = '"+insert_values.get("res_addr_line1")+"',res_addr_line2 = '"+insert_values.get("res_addr_line2")+"',res_addr_line3 = '"+insert_values.get("res_addr_line3")+"',res_addr_line4 = '"+insert_values.get("res_addr_line4")+"',postal_code = '"+insert_values.get("res_postal_code")+"',country_code = '"+insert_values.get("res_country_code")+"',nationality_code = '"+insert_values.get("nationality_code")+"',alt_id1_type = '"+insert_values.get("alt_id1_type")+"',alt_id2_type = '"+insert_values.get("alt_id2_type")+"',alt_id2_no = '"+insert_values.get("alt_id2_no")+"',alt_id2_exp_date = to_date('"+insert_values.get("alt_id2_exp_date")+"','dd/mm/yyyy') ,alt_id3_type = '"+insert_values.get("alt_id3_type")+"',alt_id3_no = '"+insert_values.get("alt_id3_no")+"',alt_id3_exp_date = to_date('"+insert_values.get("alt_id3_exp_date")+"','dd/mm/yyyy'),alt_id4_type = '"+insert_values.get("alt_id4_type")+"',alt_id4_no = '"+insert_values.get("alt_id4_no")+"',alt_id4_exp_date = to_date('"+insert_values.get("alt_id4_exp_date")+"','dd/mm/yyyy') ,oth_alt_id_type = '"+(String)insert_values.get("other_alt_id")+"',oth_alt_id_no = '"+(String)insert_values.get("other_alt_Id_text")+"',res_town_code = '"+insert_values.get("res_town_code")+"',res_area_code = '"+insert_values.get("res_area_code")+"',res_region_code = '"+insert_values.get("res_region_code")+"',mail_addr_line1 = '"+insert_values.get("mail_addr_line1")+"',mail_addr_line2 = '"+insert_values.get("mail_addr_line2")+"',mail_addr_line3 = '"+insert_values.get("mail_addr_line3")+"',mail_addr_line4 = '"+insert_values.get("mail_addr_line4")+"',mail_town_code = '"+insert_values.get("mail_town_code")+"',mail_area_code = '"+insert_values.get("mail_area_code")+"',mail_region_code = '"+insert_values.get("mail_region_code")+"',mail_postal_code = '"+insert_values.get("mail_postal_code")+"',mail_country_code = '"+insert_values.get("mail_country_code")+"',race_code = '"+insert_values.get("race_code")+"',ethnic_grp_code = '"+insert_values.get("ethnic_group")+"',birth_place_code = '"+insert_values.get("birth_place_code")+"',birth_place_desc = '"+insert_values.get("place_of_birth")+"',citizen_yn = '"+insert_values.get("citizen_yn")+"',legal_illegal_yn = '"+insert_values.get("legal_yn")+"',modified_by_id = '"+insert_values.get("added_by_id")+"',modified_date = sysdate ,modified_at_ws_no = '"+insert_values.get("added_at_ws_no")+"',modified_facility_id  = '"+insert_values.get("added_facility_id")+"' where  FACILITY_ID =    '"+insert_values.get("facility_id")+"'  AND PATIENT_ID is null ");

			if(refrlAappt.equals("I"))
			{
				sql.append(" AND  bkg_lst_ref_no = '"+refIDValue+"' ");
			}
			else
			{
				sql.append(" AND  bkg_lst_ref_no = '"+insert_values.get("bkg_ref_no")+"' ");
			}
			if(stmt!=null) stmt.close();
			stmt = con.prepareStatement(sql.toString());


            if(stmt.executeUpdate() >0 ) transaction_completed = true;
			else
			{
				transaction_completed	= false;
				tableUpdated			= false;
			}

           debug_buffer.append("<br>"+transaction_completed+"<BR>End updateIPBooking") ;
        }
        catch(Exception e)
        {
            transaction_completed = false;
            debug_buffer.append("<br>Update IPBooking List:"+e.toString()) ;
			error_buf.append("Error in Update IPBooking: "+e.toString());
			e.printStackTrace();
        }
    }

 private void updateBilling(Properties p,Connection con,String mode)
	{

		  PreparedStatement chk_pstmt = null;
		  ResultSet chk_rset = null;
		  int count = 0;

		  String calling_function_id = (String)insert_values.get("calling_function_id");
		  //Added GDOH-CRF-0029 
		   String pat_regn_date_time = (String)insert_values.get("disas_regn_date_time");
		   String pat_regn_prev_date= (String)insert_values.get("old_regn_datetime");
		  
		  
		  
		  if((calling_function_id == null || calling_function_id.equals("null") || calling_function_id.equals("")) && (mode.equals("U"))) {
			  calling_function_id = "CHG_PAT_DTLS";
		  }
        try
        {
            transaction_completed = false;
	    debug_buffer.append("<br>Start Update Billing2 ") ;

		chk_pstmt = con.prepareStatement("select count(*) from bl_patient_fin_dtls where patient_id=?");
		chk_pstmt.setString(1,patient_id);
		chk_rset = chk_pstmt.executeQuery();
		while(chk_rset.next())
		{
			count = chk_rset.getInt(1);
		}
		if (count==1)
		{
			mode = "U";
		}
		 Hashtable blTabdata = new Hashtable();
		 String strMessage = "";

		 blTabdata.put("calling_function_id",calling_function_id);
		 blTabdata.put("credit_auth_user_id","");
		 blTabdata.put("locale",(String)insert_values.get("locale"));
		 blTabdata.put("patient_id_new", patient_id);
		 blTabdata.put("facility_id",(String)insert_values.get("facility_id"));
		 blTabdata.put("operation_mode",mode);
		 blTabdata.put("added_at_ws_no",(String)insert_values.get("added_at_ws_no"));
		 blTabdata.put("added_by_id",(String)insert_values.get("added_by_id"));
		 blTabdata.put("billing_group",(String)insert_values.get("billing_group"));
		 blTabdata.put("dflt_pat_regn_blng_class",(String)insert_values.get("dflt_pat_regn_blng_class"));
		 blTabdata.put("pat_ser_grp_code",(String)insert_values.get("pat_ser_grp_code"));
		 blTabdata.put("pat_regn_date_time",pat_regn_date_time); //Added GDOH-CRF-0029 
         blTabdata.put("pat_regn_prev_date",pat_regn_prev_date); //Added GDOH-CRF-0029 

		if(refrlAappt.equals("A"))
		{
			blTabdata.put("apptrefno",refIDValue);
		}
		else
		{
			blTabdata.put("apptrefno",apptrefno);
		}

		if(refrlAappt.equals("I"))
		{
			blTabdata.put("bookingrefno",refIDValue);
		}
		else
		{			blTabdata.put("bookingrefno",(String)insert_values.get("bkg_ref_no"));
		}



		try
		{
			HashMap fin_dtls=(HashMap)insert_values.get("fin_dtls");
			if ( fin_dtls!=null )
			{
	 			blTabdata.put("fin_dtls",fin_dtls);
			}
		}
		catch (Exception e)
		{

			e.printStackTrace();
		}


		// blTabdata.put("fin_dtls",(String)insert_values.get("billing_group"));
		blmpin.BLMPInterface blPatReg = new blmpin.BLMPInterface();
		Hashtable resultsBL = blPatReg.billPatientService(p,con,blTabdata);
		boolean boolRes = ((Boolean) (resultsBL.get("transaction_completed"))).booleanValue();



		if (boolRes == false)
		{
		  transaction_completed = false;
		  debug_buffer.append("<br> here in err Code");
		  //msg_buffer.append((String) resultsBL.get("error"));
		  error_buf.append((String) resultsBL.get("error"));
		 }
		 if (boolRes == true)
		 {
		  transaction_completed = true;
		  strMessage = (String) resultsBL.get("error");
		  bl_success_msg = (String) resultsBL.get("success_message");


		  if (strMessage != null)
		  {
			 msg_buffer.append(strMessage + " ");
		  }
		}


		billdoctype = (String) (resultsBL.get("billdoctype"));
		billdocnum = (String) (resultsBL.get("billdocnum"));
		billgenlater = (String) (resultsBL.get("billgenlater"));

		str_bill_prt_format_YN = (String)(resultsBL.get("bill_prt_format_YN"));
		str_bill_prt_format_vals = (String)(resultsBL.get("bill_prt_format_vals"));
		pgm_id = (String)(resultsBL.get("pgm_id"));
		session_id = (String)(resultsBL.get("session_id"));
		pgm_date = (String)(resultsBL.get("pgm_date"));
		mpi_id_rep = (String)(resultsBL.get("mpi_id_rep"));		
		

		blTabdata.clear();
		resultsBL.clear();

		debug_buffer.append("<br>End Update Billing ") ;
		if(chk_pstmt!=null) chk_pstmt.close();
	  	if(chk_rset!=null) chk_rset.close();
	 }
	catch (Exception e)
	{
		 transaction_completed = false;
		 debug_buffer.append("<br>Update Billing :"+e.toString()) ;
		 error_buf.append("Error in Billing Procedure : "+e.getMessage());
		 e.printStackTrace();
	}
}

/*
    private void updateBilling(String mode)
    {
      CallableStatement statement = null;
	  PreparedStatement chk_pstmt = null;
	  ResultSet chk_rset = null;
	  int count = 0;
        try
        {
            transaction_completed = false;
		    debug_buffer.append("<br>Start Update Billing ") ;

			chk_pstmt = con.prepareStatement("select count(*) from bl_patient_fin_dtls where patient_id=?");
			chk_pstmt.setString(1,patient_id);
			chk_rset = chk_pstmt.executeQuery();
			while(chk_rset.next())
			{
				count = chk_rset.getInt(1);

			}
			if (count==1)
			{
				mode = "U";
			}

			if(sql.length() > 0) sql.delete(0,sql.length());
            sql.append("{call INS_UPD_BL_PAT_FIN_DTLS( '"+mode+"','"+patient_id+"','"+(String)insert_values.get("billing_group")+"','"+(String)insert_values.get("dflt_pat_regn_blng_class")+"','"+(String)insert_values.get("employer_code")+"','"+(String)insert_values.get("setlmt_ind")+"','"+(String)insert_values.get("credit_doc_ref_desc")+"',to_date('"+(String)insert_values.get("credit_doc_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("cust_code")+"','"+(String)insert_values.get("slmt_type_code")+"','"+(String)insert_values.get("slmt_doc_ref_desc")+"',to_date('"+(String)insert_values.get("slmt_doc_ref_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("slmt_doc_remarks")+"','"+(String)insert_values.get("remarks")+"','"+(String)insert_values.get("policy_type")+"','"+(String)insert_values.get("policy_no")+"',to_date('"+(String)insert_values.get("policy_expiry_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("non_insur_blng_grp")+"','"+(String)insert_values.get("cust_4")+"','"+insert_values.get("annual_income")+"','"+insert_values.get("family_asset")+"','"+insert_values.get("no_of_dependants")+"','"+(String)insert_values.get("resp_for_payment")+"','"+(String)insert_values.get("added_by_id")+"','"+(String)insert_values.get("facility_id")+"','"+(String)insert_values.get("added_at_ws_no")+"','"+(String)insert_values.get("GL_HOLDER_NAME")+"','"+(String)insert_values.get("GL_HOLDER_RELN")+"',to_date('"+(String)insert_values.get("CRED_START_DT")+"','dd/mm/yyyy'),?)}") ;

            statement=con.prepareCall(sql.toString());
            statement.registerOutParameter( 1,java.sql.Types.VARCHAR);

            statement.execute();

            transaction_completed=true;

            /*-Starts here--Added on 19th March..to dispaly err msg from sm_message--
            String err_code=statement.getString(1)==null?"0":statement.getString(1);

            if(!err_code.equals("0"))
            {
                int chk_code=err_code.indexOf("**");
                transaction_completed=false;
                debug_buffer.append("<br> here in err Code");

                if(chk_code != -1)
                {
                    msg_buffer.append("<br>"+err_code+"<br> ") ;
                }
                else
                {
                    msg_buffer.append((getMessage(locale,"err_code","MP")));

                }
            }
            /*-Ends Here-

            debug_buffer.append("<br>End Update Billing ") ;
			if(statement != null) statement.close();
			if(chk_pstmt!=null) chk_pstmt.close();
			if(chk_rset!=null) chk_rset.close();
        }
        catch(Exception e)
        {

		  transaction_completed = false;
          debug_buffer.append("<br>Update Billing :"+e.toString()) ;
		  error_buf.append("Error in Billing Procedure : "+e.getMessage());
        }

    }
*/
    void updatePatDocs()
    {
		debug_buffer.append("<br>Start updatePatDocs") ;
        transaction_completed = false;
        try
        {
			/*Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 - Begins*/
			/*if( !(insert_values.get("doc1_type").equals("")&&insert_values.get("doc2_type").equals("") && insert_values.get("doc3_type").equals("") && insert_values.get("doc4_type").equals("")))
            {

				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("select 1 from mp_pat_documents where patient_id='"+patient_id+"'");

			    if(stmt!=null) stmt.close();
				if(rset!=null) rset.close();
			    stmt = con.prepareStatement(sql.toString());

				rset = stmt.executeQuery();
                if(rset.next())
                {
					System.out.println("Updating mp_pat_documents with the values from insert_values : "+insert_values.toString());
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("update mp_pat_documents set DOC1_TYPE='"+(String)insert_values.get("doc1_type")+"',DOC1_NUM='"+(String)insert_values.get("doc1_num")+"',DOC1_EXP_DATE=to_date('"+(String)insert_values.get("doc1_exp_date")+"','dd/mm/yyyy'),DOC1_PLACE_OF_ISSUE='"+(String)insert_values.get("doc1_place_of_issue")+"',DOC1_ISS_DATE=to_date('"+(String)insert_values.get("doc1_iss_date")+"','dd/mm/yyyy'),DOC2_TYPE='"+(String)insert_values.get("doc2_type")+"',DOC2_NUM='"+(String)insert_values.get("doc2_num")+"',DOC2_EXP_DATE=to_date('"+(String)insert_values.get("doc2_exp_date")+"','dd/mm/yyyy'),DOC2_PLACE_OF_ISSUE='"+(String)insert_values.get("doc2_place_of_issue")+"',DOC2_ISS_DATE=to_date('"+(String)insert_values.get("doc2_iss_date")+"','dd/mm/yyyy'),DOC3_TYPE='"+(String)insert_values.get("doc3_type")+"',DOC3_NUM='"+(String)insert_values.get("doc3_num")+"',DOC3_EXP_DATE=to_date('"+(String)insert_values.get("doc3_exp_date")+"','dd/mm/yyyy'),DOC3_PLACE_OF_ISSUE='"+(String)insert_values.get("doc3_place_of_issue")+"',DOC3_ISS_DATE=to_date('"+(String)insert_values.get("doc3_iss_date")+"','dd/mm/yyyy'),DOC4_TYPE='"+(String)insert_values.get("doc4_type")+"',DOC4_NUM='"+(String)insert_values.get("doc4_num")+"',DOC4_EXP_DATE=to_date('"+(String)insert_values.get("doc4_exp_date")+"','dd/mm/yyyy'),DOC4_PLACE_OF_ISSUE='"+(String)insert_values.get("doc4_place_of_issue")+"',DOC4_ISS_DATE=to_date('"+(String)insert_values.get("doc4_iss_date")+"','dd/mm/yyyy'),modified_by_id='"+(String)insert_values.get("added_by_id")+"',modified_date = sysdate,modified_at_ws_no = '"+(String)insert_values.get("added_at_ws_no")+"',modified_facility_id =  '"+(String)insert_values.get("added_facility_id")+"' where patient_id='"+patient_id+"'") ;
                }
                else
                {
					System.out.println("inserting into mp_pat_documents with the values from insert_values : "+insert_values.toString());
                    if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("insert into mp_pat_documents(PATIENT_ID,DOC1_TYPE,DOC1_NUM,DOC1_EXP_DATE,DOC1_PLACE_OF_ISSUE,DOC1_ISS_DATE,DOC2_TYPE,DOC2_NUM,DOC2_EXP_DATE,DOC2_PLACE_OF_ISSUE,DOC2_ISS_DATE,DOC3_TYPE,DOC3_NUM,DOC3_EXP_DATE,DOC3_PLACE_OF_ISSUE,DOC3_ISS_DATE,DOC4_TYPE,DOC4_NUM,DOC4_EXP_DATE,DOC4_PLACE_OF_ISSUE,DOC4_ISS_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)values('"+patient_id+"','"+(String)insert_values.get("doc1_type")+"','"+(String)insert_values.get("doc1_num")+"',to_date('"+(String)insert_values.get("doc1_exp_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc1_place_of_issue")+"',to_date('"+(String)insert_values.get("doc1_iss_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc2_type")+"','"+(String)insert_values.get("doc2_num")+"',to_date('"+(String)insert_values.get("doc2_exp_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc2_place_of_issue")+"',to_date('"+(String)insert_values.get("doc2_iss_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc3_type")+"','"+(String)insert_values.get("doc3_num")+"',to_date('"+(String)insert_values.get("doc3_exp_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc3_place_of_issue")+"',to_date('"+(String)insert_values.get("doc3_iss_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc4_type")+"','"+(String)insert_values.get("doc4_num")+"',to_date('"+(String)insert_values.get("doc4_exp_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc4_place_of_issue")+"',to_date('"+(String)insert_values.get("doc4_iss_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("added_by_id")+"',sysdate,'"+(String)insert_values.get("added_at_ws_no")+"','"+(String)insert_values.get("added_facility_id")+"','"+(String)insert_values.get("added_by_id")+"',sysdate,'"+(String)insert_values.get("added_at_ws_no")+"',"+
                        "'"+(String)insert_values.get("added_facility_id")+"')");
                }
                //debug_buffer.append("<br>End updatePatDocs1:"+sql.toString()) ;
				if(stmt!=null) stmt.close();
				stmt = con.prepareStatement(sql.toString());


                if(stmt.executeUpdate()>0)
				{

					transaction_completed = true;
				}
            }
            else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("select 1 from mp_pat_documents where patient_id='"+patient_id+"'");
				if(stmt!=null) stmt.close();
				if(rset!=null) rset.close();
			    stmt = con.prepareStatement(sql.toString());

				rset = stmt.executeQuery();
                if(rset.next())
                {
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("delete from mp_pat_documents where patient_id='"+patient_id+"'");
					if(stmt!=null) stmt.close();
					stmt = con.prepareStatement(sql.toString());
					stmt.executeUpdate();	
				}
				transaction_completed = true;
			}
			if(stmt!=null) stmt.close();
			if(rset!=null) rset.close();*/
			if(sql.length() > 0) sql.delete(0,sql.length());
			int i=1;
			String update_doc_image="";
			String update_doc_path="";/*Added by Rameswar on  23-03-2016 for MMS-DM-CRF-0035*/
			while(i<=4){
				String doctype = (String)insert_values.get("doc"+i+"_type");
				if ((doctype == null || doctype.equals("null") || doctype.equals(""))){
				update_doc_image=update_doc_image+",doc"+i+"_image = null ";

				update_doc_path=update_doc_path+" ,DOC"+i+"_IMAGE_PATH='' ,DOC"+i+"_IMAGE_TYPE='' "	;

				/*for(int j=i+1;j<=4;j++){

				String docjtype = (String)insert_values.get("doc"+j+"_type");
				String docnum = (String)insert_values.get("doc"+j+"_num");
				String docexpdate = (String)insert_values.get("doc"+j+"_exp_date");
				String docplaceofissue	= (String)insert_values.get("doc"+j+"_place_of_issue");
				String docissdate =(String)insert_values.get("doc"+j+"_iss_date");
				
					if (!((docjtype == null || docjtype.equals("null") || docjtype.equals("")))){
					insert_values.put("doc"+i+"_type", docjtype);
					insert_values.put("doc"+i+"_num",docnum);
					insert_values.put("doc"+i+"_exp_date", docexpdate);
					insert_values.put("doc"+i+"_place_of_issue",docplaceofissue);
					insert_values.put("doc"+i+"_iss_date",docissdate);
					
					insert_values.put("doc"+j+"_type","" );
					insert_values.put("doc"+j+"_num","");
					insert_values.put("doc"+j+"_exp_date","");
					insert_values.put("doc"+j+"_place_of_issue","");
					insert_values.put("doc"+j+"_iss_date","");
					break;
						}
					}*/
				}
				i++;
			}

			/*Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1*/
			boolean isEmployeePrivilegeAppl	= CommonBean.isSiteSpecific(con, "MP","EMPLOYEE_PRIVILEGE");

			String operation = (String)insert_values.get("operation") ;
		
			if(!operation.equals("modify")){
				if(!(insert_values.get("doc1_type").equals("") && insert_values.get("doc2_type").equals("") && insert_values.get("doc3_type").equals("") && insert_values.get("doc4_type").equals(""))){
				sql.append("insert into MP_PAT_DOCUMENTS(PATIENT_ID,DOC1_TYPE,DOC1_NUM,DOC1_EXP_DATE,DOC1_PLACE_OF_ISSUE,DOC1_ISS_DATE,DOC2_TYPE,DOC2_NUM,DOC2_EXP_DATE,DOC2_PLACE_OF_ISSUE,DOC2_ISS_DATE,DOC3_TYPE,DOC3_NUM,DOC3_EXP_DATE,DOC3_PLACE_OF_ISSUE,DOC3_ISS_DATE,DOC4_TYPE,DOC4_NUM,DOC4_EXP_DATE,DOC4_PLACE_OF_ISSUE,DOC4_ISS_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)values('"+patient_id+"','"+(String)insert_values.get("doc1_type")+"','"+(String)insert_values.get("doc1_num")+"',to_date('"+(String)insert_values.get("doc1_exp_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc1_place_of_issue")+"',to_date('"+(String)insert_values.get("doc1_iss_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc2_type")+"','"+(String)insert_values.get("doc2_num")+"',to_date('"+(String)insert_values.get("doc2_exp_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc2_place_of_issue")+"',to_date('"+(String)insert_values.get("doc2_iss_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc3_type")+"','"+(String)insert_values.get("doc3_num")+"',to_date('"+(String)insert_values.get("doc3_exp_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc3_place_of_issue")+"',to_date('"+(String)insert_values.get("doc3_iss_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc4_type")+"','"+(String)insert_values.get("doc4_num")+"',to_date('"+(String)insert_values.get("doc4_exp_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc4_place_of_issue")+"',to_date('"+(String)insert_values.get("doc4_iss_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("added_by_id")+"',sysdate,'"+(String)insert_values.get("added_at_ws_no")+"','"+(String)insert_values.get("added_facility_id")+"','"+(String)insert_values.get("added_by_id")+"',sysdate,'"+(String)insert_values.get("added_at_ws_no")+"',"+
                "'"+(String)insert_values.get("added_facility_id")+"')");
				
					if(stmt!=null) stmt.close();
					stmt = con.prepareStatement(sql.toString());
					stmt.executeUpdate();
					transaction_completed = true;
				}
				else{
				transaction_completed = true;
				}

				/*Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1*/
				if(transaction_completed && isEmployeePrivilegeAppl)
				{
					if(sql.length() > 0) sql.delete(0,sql.length());

					sql.append("UPDATE xh_ext_hr_ib_info SET process_status = 'S', modified_by_id = ?, modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id = ? WHERE national_id_no = ?");

					stmt = con.prepareStatement(sql.toString());
					stmt.setString(1,(String)insert_values.get("added_by_id"));
					stmt.setString(2,(String)insert_values.get("added_at_ws_no"));
					stmt.setString(3,(String)insert_values.get("added_facility_id"));
					stmt.setString(4,(String)insert_values.get("national_id_no"));
					stmt.executeUpdate();
					transaction_completed = true;
				}

				if(stmt!= null) stmt.close();
				/*End TBMC-CRF-0010.1*/
			}
			else if(operation.equals("modify")){
					//int cnt=0; //Commented for checkstyle
					//sql.append("delete from mp_pat_documents where patient_id='"+patient_id+"'");
					//if(stmt!=null) stmt.close();
					//stmt = con.prepareStatement(sql.toString());
					//cnt = stmt.executeUpdate();	
						//if( !(insert_values.get("doc1_type").equals("")&&insert_values.get("doc2_type").equals("") && insert_values.get("doc3_type").equals("") && insert_values.get("doc4_type").equals(""))){
						sql.append("select 1 from mp_pat_documents where patient_id='"+patient_id+"'");
						if(stmt!=null) stmt.close();
						if(rset!=null) rset.close();
						stmt = con.prepareStatement(sql.toString());

						rset = stmt.executeQuery();
						if(sql.length() > 0) sql.delete(0,sql.length());
						if(rset.next())
						{

						//sql.append("insert into mp_pat_documents(PATIENT_ID,DOC1_TYPE,DOC1_NUM,DOC1_EXP_DATE,DOC1_PLACE_OF_ISSUE,DOC1_ISS_DATE,DOC2_TYPE,DOC2_NUM,DOC2_EXP_DATE,DOC2_PLACE_OF_ISSUE,DOC2_ISS_DATE,DOC3_TYPE,DOC3_NUM,DOC3_EXP_DATE,DOC3_PLACE_OF_ISSUE,DOC3_ISS_DATE,DOC4_TYPE,DOC4_NUM,DOC4_EXP_DATE,DOC4_PLACE_OF_ISSUE,DOC4_ISS_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)values('"+patient_id+"','"+(String)insert_values.get("doc1_type")+"','"+(String)insert_values.get("doc1_num")+"',to_date('"+(String)insert_values.get("doc1_exp_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc1_place_of_issue")+"',to_date('"+(String)insert_values.get("doc1_iss_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc2_type")+"','"+(String)insert_values.get("doc2_num")+"',to_date('"+(String)insert_values.get("doc2_exp_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc2_place_of_issue")+"',to_date('"+(String)insert_values.get("doc2_iss_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc3_type")+"','"+(String)insert_values.get("doc3_num")+"',to_date('"+(String)insert_values.get("doc3_exp_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc3_place_of_issue")+"',to_date('"+(String)insert_values.get("doc3_iss_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc4_type")+"','"+(String)insert_values.get("doc4_num")+"',to_date('"+(String)insert_values.get("doc4_exp_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc4_place_of_issue")+"',to_date('"+(String)insert_values.get("doc4_iss_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("added_by_id")+"',sysdate,'"+(String)insert_values.get("added_at_ws_no")+"','"+(String)insert_values.get("added_facility_id")+"','"+(String)insert_values.get("added_by_id")+"',sysdate,'"+(String)insert_values.get("added_at_ws_no")+"',"+
						sql.append("update MP_PAT_DOCUMENTS set DOC1_TYPE='"+(String)insert_values.get("doc1_type")+"',DOC1_NUM='"+(String)insert_values.get("doc1_num")+"',DOC1_EXP_DATE=to_date('"+(String)insert_values.get("doc1_exp_date")+"','dd/mm/yyyy'),DOC1_PLACE_OF_ISSUE='"+(String)insert_values.get("doc1_place_of_issue")+"',DOC1_ISS_DATE=to_date('"+(String)insert_values.get("doc1_iss_date")+"','dd/mm/yyyy'),DOC2_TYPE='"+(String)insert_values.get("doc2_type")+"',DOC2_NUM='"+(String)insert_values.get("doc2_num")+"',DOC2_EXP_DATE=to_date('"+(String)insert_values.get("doc2_exp_date")+"','dd/mm/yyyy'),DOC2_PLACE_OF_ISSUE='"+(String)insert_values.get("doc2_place_of_issue")+"',DOC2_ISS_DATE=to_date('"+(String)insert_values.get("doc2_iss_date")+"','dd/mm/yyyy'),DOC3_TYPE='"+(String)insert_values.get("doc3_type")+"',DOC3_NUM='"+(String)insert_values.get("doc3_num")+"',DOC3_EXP_DATE=to_date('"+(String)insert_values.get("doc3_exp_date")+"','dd/mm/yyyy'),DOC3_PLACE_OF_ISSUE='"+(String)insert_values.get("doc3_place_of_issue")+"',DOC3_ISS_DATE=to_date('"+(String)insert_values.get("doc3_iss_date")+"','dd/mm/yyyy'),DOC4_TYPE='"+(String)insert_values.get("doc4_type")+"',DOC4_NUM='"+(String)insert_values.get("doc4_num")+"',DOC4_EXP_DATE=to_date('"+(String)insert_values.get("doc4_exp_date")+"','dd/mm/yyyy'),DOC4_PLACE_OF_ISSUE='"+(String)insert_values.get("doc4_place_of_issue")+"',DOC4_ISS_DATE=to_date('"+(String)insert_values.get("doc4_iss_date")+"','dd/mm/yyyy'),MODIFIED_BY_ID='"+(String)insert_values.get("added_by_id")+"',MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO='"+(String)insert_values.get("added_at_ws_no")+"',MODIFIED_FACILITY_ID='"+(String)insert_values.get("added_facility_id")+"' "+update_doc_image+" "+update_doc_path+" where patient_id ='"+patient_id+"' ");
						
						if(stmt!=null) stmt.close();
						stmt = con.prepareStatement(sql.toString());
						stmt.executeUpdate();
						transaction_completed = true;
						}
						else{
							sql.append("insert into mp_pat_documents(PATIENT_ID,DOC1_TYPE,DOC1_NUM,DOC1_EXP_DATE,DOC1_PLACE_OF_ISSUE,DOC1_ISS_DATE,DOC2_TYPE,DOC2_NUM,DOC2_EXP_DATE,DOC2_PLACE_OF_ISSUE,DOC2_ISS_DATE,DOC3_TYPE,DOC3_NUM,DOC3_EXP_DATE,DOC3_PLACE_OF_ISSUE,DOC3_ISS_DATE,DOC4_TYPE,DOC4_NUM,DOC4_EXP_DATE,DOC4_PLACE_OF_ISSUE,DOC4_ISS_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)values('"+patient_id+"','"+(String)insert_values.get("doc1_type")+"','"+(String)insert_values.get("doc1_num")+"',to_date('"+(String)insert_values.get("doc1_exp_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc1_place_of_issue")+"',to_date('"+(String)insert_values.get("doc1_iss_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc2_type")+"','"+(String)insert_values.get("doc2_num")+"',to_date('"+(String)insert_values.get("doc2_exp_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc2_place_of_issue")+"',to_date('"+(String)insert_values.get("doc2_iss_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc3_type")+"','"+(String)insert_values.get("doc3_num")+"',to_date('"+(String)insert_values.get("doc3_exp_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc3_place_of_issue")+"',to_date('"+(String)insert_values.get("doc3_iss_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc4_type")+"','"+(String)insert_values.get("doc4_num")+"',to_date('"+(String)insert_values.get("doc4_exp_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("doc4_place_of_issue")+"',to_date('"+(String)insert_values.get("doc4_iss_date")+"','dd/mm/yyyy'),'"+(String)insert_values.get("added_by_id")+"',sysdate,'"+(String)insert_values.get("added_at_ws_no")+"','"+(String)insert_values.get("added_facility_id")+"','"+(String)insert_values.get("added_by_id")+"',sysdate,'"+(String)insert_values.get("added_at_ws_no")+"','"+(String)insert_values.get("added_facility_id")+"')");
						
						System.out.println("mp_pat_documents -- insert statement -- "+sql.toString());	
						if(stmt!=null) stmt.close();
						stmt = con.prepareStatement(sql.toString());
						stmt.executeUpdate();
						transaction_completed = true;
						}

						/*Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1*/
						if(transaction_completed && isEmployeePrivilegeAppl)
						{
							if(sql.length() > 0) sql.delete(0,sql.length());

							sql.append("UPDATE xh_ext_hr_ib_info SET process_status = 'S', modified_by_id = ?, modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id = ? WHERE national_id_no = ?");

							stmt = con.prepareStatement(sql.toString());
							stmt.setString(1,(String)insert_values.get("added_by_id"));
							stmt.setString(2,(String)insert_values.get("added_at_ws_no"));
							stmt.setString(3,(String)insert_values.get("added_facility_id"));
							stmt.setString(4,(String)insert_values.get("national_id_no"));
							stmt.executeUpdate();
							transaction_completed = true;
						}

						if(stmt!= null) stmt.close();
						/*End TBMC-CRF-0010.1*/
							
			}
			else{
			transaction_completed = true;
			}
		/*Rameez for SKR-SCF-0646 [IN:035259] on 05-Oct-12 - Ends*/
					
        }
        catch(Exception e)
        {
          transaction_completed = false;
          debug_buffer.append("<br>updatePatDocs :"+e.toString()) ;
		  error_buf.append("Error in Update Patient Documents: "+e.toString());
		  e.printStackTrace();
        }
		debug_buffer.append("<br>End updatePatDocs") ;
    }

   void updatePatientDetails()
   {    
        debug_buffer.append("Start updatePatientDetails") ;
        CallableStatement cs1 = null ;
		//CRF GDOH-CRF-0029 [IN:048764]
		String isVirtualConsultation=(String)insert_values.get("isVirtualConsultation");
		String reg_date=(String)insert_values.get("disas_regn_date_time");
		String upt_contact_dtls_oa_yn=(String) insert_values.get("upt_contact_dtls_oa_yn");//added changes for HSA-CRF-0226 [IN:050599]
		String upd_pat_dtls_referral_yn=(String) insert_values.get("upd_pat_dtls_referral_yn");//Added by Dharma against HSA-CRF-0303 [IN:054572] on Apr 8th 2016
        try
        {

		   String pat_name_as_multipart_yn = (String)insert_values.get("pat_name_as_multipart_yn");
		   String family_name = ""; 
		   if (pat_name_as_multipart_yn.equals("N"))
		   {
				family_name = (String)insert_values.get("family_name");
				StringTokenizer stkTok = new StringTokenizer(family_name," ");
				if (stkTok.hasMoreTokens())
					family_name = stkTok.nextToken();
		   }
		   else
				family_name = (String)insert_values.get("family_name");
            
			cs1 = con.prepareCall("{call MP_AUDIT_FUNCTION.ASSIGN_VALUE('CHG_PAT_DTLS')}");
			
            cs1.execute();
			
			cs1.close();

			if(sql.length() > 0) sql.delete(0,sql.length());
			//Below line modified for GDOH-CRF-0029 [IN:048764]
			////Added  MYHIX element for integration ML-MMOH-CRF-0507.1
			sql.append("update MP_PATIENT set patient_name = '"+(String)insert_values.get("patient_name")+"',pref_facility_id = '"+(String)insert_values.get("pref_facility_id")+"',family_link_no = '"+(String)insert_values.get("family_link_no")+"',relationship_to_head = '"+(String)insert_values.get("relationship_to_head")+"',combined_rel_level_code ='"+(String)insert_values.get("combined_rel_level_code")+"' , national_id_no = '"+(String)insert_values.get("national_id_no")+"' ,national_id_no_dft = '"+(String)insert_values.get("national_id_no_dft")+"' ,pat_ser_grp_code = '"+(String)insert_values.get("pat_ser_grp_code")+"',name_prefix = '"+(String)insert_values.get("name_prefix")+"',first_name = '"+(String)insert_values.get("first_name")+"',family_name = '"+(String)insert_values.get("family_name")+"',second_name = '"+(String)insert_values.get("second_name")+"',third_name = '"+(String)insert_values.get("third_name")+"',name_suffix = '"+(String)insert_values.get("name_suffix")+"',sex = '"+(String)insert_values.get("sex")+"',date_of_birth = to_date('"+(String)insert_values.get("date_of_birth")+"','dd/mm/yyyy hh24:mi:ss'),place_of_birth = '"+(String)insert_values.get("place_of_birth")+"',birth_place_code = '"+(String)insert_values.get("birth_place_code")+"',mar_status_code = '"+(String)insert_values.get("mar_status_code")+"',alias_name = '"+(String)insert_values.get("alias_name")+"',household_monthly_income = '"+(String)insert_values.get("household_monthly_income")+"',mother_maiden_name = '"+(String)insert_values.get("mother_maiden_name")+"',relgn_code = '"+(String)insert_values.get("relgn_code")+"',race_code = '"+(String)insert_values.get("race_code")+"',pat_cat_code = '"+(String)insert_values.get("pat_cat_code")+"',ref_source_code = '"+(String)insert_values.get("ref_source_code")+"',nationality_code = '"+(String)insert_values.get("nationality_code")+"' ,contact1_no = '"+(String)insert_values.get("contact1_no")+"',contact2_no = '"+(String)insert_values.get("contact2_no")+"' ,contact3_mode = '"+(String)insert_values.get("contact3_mode")+"',contact3_no = '"+(String)insert_values.get("contact3_no")+"',contact4_mode = '"+(String)insert_values.get("contact4_mode")+"',contact4_no = '"+(String)insert_values.get("contact4_no")+"',contact5_mode = '"+(String)insert_values.get("contact5_mode")+"',contact5_no = '"+(String)insert_values.get("contact5_no")+"',res_area_code = '"+(String)insert_values.get("res_area_code")+"',res_town_code = '"+(String)insert_values.get("res_town_code")+"',res_town_desc = '"+(String)insert_values.get("res_town_desc")+"',region_code = '"+(String)insert_values.get("res_region_code")+"',LANGUAGE_ID = '"+(String)insert_values.get("language_code")+"',modified_by_id = '"+(String)insert_values.get("added_by_id")+"',modified_date = sysdate,modified_at_ws_no = '"+(String)insert_values.get("added_at_ws_no")+"',modified_facility_id = '"+(String)insert_values.get("added_facility_id")+"',calculated_age_yn = '"+(String)insert_values.get("calculated_age_yn")+"',EMAIL_ID = '"+(String)insert_values.get("email_id")+"',alt_id1_no  = '"+(String)insert_values.get("alt_id1_no")+"',alt_id1_type = '"+(String)insert_values.get("alt_id1_type")+"',alt_id1_exp_date = to_date('"+(String)insert_values.get("alt_id1_exp_date")+"','dd/mm/yyyy'),alt_id2_no = '"+(String)insert_values.get("alt_id2_no")+"',alt_id2_type = '"+(String)insert_values.get("alt_id2_type")+"',alt_id2_exp_date = to_date('"+(String)insert_values.get("alt_id2_exp_date")+"','dd/mm/yyyy'),alt_id3_no = '"+(String)insert_values.get("alt_id3_no")+"',alt_id3_type = '"+(String)insert_values.get("alt_id3_type")+"',alt_id3_exp_date = to_date('"+(String)insert_values.get("alt_id3_exp_date")+"','dd/mm/yyyy'),alt_id4_no = '"+(String)insert_values.get("alt_id4_no")+"',alt_id4_type = '"+(String)insert_values.get("alt_id4_type")+"',alt_id4_exp_date = to_date('"+(String)insert_values.get("alt_id4_exp_date")+"','dd/mm/yyyy'),gcc='"+(String) insert_values.get("gcc")+"',data_source = '"+(String)insert_values.get("data_source")+"',generic_sndx_first         = SOUNDEX('"+(String)insert_values.get("first_name")+"'),generic_sndx_second        = SOUNDEX('"+(String)insert_values.get("second_name")+"'),generic_sndx_third = SOUNDEX('"+(String)insert_values.get("third_name")+"'),generic_sndx_family = SOUNDEX('"+family_name+"'),generic_sndx_first_second  = SOUNDEX('"+((String)insert_values.get("first_name")+(String)insert_values.get("second_name"))+"'),generic_sndx_first_family  = SOUNDEX('"+((String)insert_values.get("first_name")+(String)insert_values.get("family_name"))+"'),ethnic_sndx_first          = ETHNIC_SOUNDEX('"+(String)insert_values.get("first_name")+"'),ethnic_sndx_second         = ETHNIC_SOUNDEX('"+(String)insert_values.get("second_name")+"'),ethnic_sndx_third          = ETHNIC_SOUNDEX('"+(String)insert_values.get("third_name")+"'),ethnic_sndx_family         = ETHNIC_SOUNDEX('"+family_name+"'),ethnic_sndx_first_second   = ETHNIC_SOUNDEX('"+((String)insert_values.get("first_name")+(String)insert_values.get("second_name"))+"'),ethnic_sndx_first_family   = ETHNIC_SOUNDEX('"+((String)insert_values.get("first_name")+(String)insert_values.get("family_name"))+"'),name_prefix_loc_lang = '"+ (String)insert_values.get("name_prefix_loc_lang") +"',first_name_loc_lang = '"+(String)insert_values.get("first_name_loc_lang") +"', second_name_loc_lang = '"+(String)insert_values.get("second_name_loc_lang") +"',third_name_loc_lang = '"+ (String)insert_values.get("third_name_loc_lang") +"',family_name_loc_lang = '"+ (String)insert_values.get("family_name_loc_lang") +"',name_suffix_loc_lang = '"+ (String)insert_values.get("name_suffix_loc_lang") +"',patient_name_loc_lang = '"+ (String)insert_values.get("patient_name_loc_lang") +"',primary_language_id = '"+ (String)insert_values.get("prime_language") +"',ethnic_grp_code = '"+ (String)insert_values.get("ethnic_group") +"',citizen_yn = '"+ (String)insert_values.get("citizen_yn") +"',legal_yn = '"+ (String)insert_values.get("legal_yn") +"',oth_alt_id_type = '"+ (String)insert_values.get("other_alt_id") +"',oth_alt_id_no = '"+ (String)insert_values.get("other_alt_Id_text") +"',pat_dtls_unknown_yn = '"+ (String)insert_values.get("pat_dtls_unknown_yn") +"',family_org_id = '"+ (String)insert_values.get("family_org_id") +"',family_org_sub_id = '"+ (String)insert_values.get("family_org_sub_id") +"',family_org_membership = '"+ (String)insert_values.get("family_org_membership") +"',known_allergy_yn = '"+				(String)insert_values.get("known_allergy_yn")+"',eye_indicator = '"+	(String)insert_values.get("eye_indicator")+"',myhix_consent = '"+	(String)insert_values.get("myhix_consent")+"' , myhix_id = '"+	(String)insert_values.get("abha_pat_id")+"' , pat_cat_code_exp_date = to_date('"+(String)insert_values.get("pat_cat_code_exp_date")+"','dd/mm/yyyy'),patient_long_name='"+	(String)insert_values.get("patient_name_long")+"',patient_long_name_loc_lang='"+	(String)insert_values.get("patient_name_loc_lang_long")+"' ,HIJRI_BIRTH_DATE='"+	(String)insert_values.get("date_of_birth_hj")+"',form_60_yn='"+	(String)insert_values.get("form_60_yn")+"',blood_donor='"+	(String)insert_values.get("blood_donor")+"',visa_type='"+	(String)insert_values.get("visa_type")+"', uploaded_pat_yn='"+(String)insert_values.get("uploaded_pat_yn")+"', primary_nuhdeek_yn='"+(String)insert_values.get("primary_nuhdeek_yn")+"', nuhdeek_ready_yn='"+(String)insert_values.get("nuhdeek_ready_yn")+"',contact2_country_code='"+(String)insert_values.get("countryC")+"',contact2_telephone_code='"+(String)insert_values.get("telephone")+"'");//Modified Arthi for ML-MMOH-CRF-1930 US004
            //blood_donor Added By Dharma on 14th Nov 2018 against ML-MMOH-CRF-0735 [IN:062857]
			//sql.append(" ,REGN_DATE=to_date('"+(String)insert_values.get("disas_regn_date_time")+"','dd/mm/yyyy hh24:mi:ss')");
            if(!reg_date.equals("")){
			//sql.append(",REGN_DATE=to_date(reg_date,'dd/mm/yyyy hh24:mi:ss')");
			//Below line Removed the Seconds
			sql.append(" ,REGN_DATE=to_date('"+(String)insert_values.get("disas_regn_date_time")+"','dd/mm/yyyy hh24:mi')");
			}else{
			sql.append(",REGN_DATE=to_date(to_char(sysdate,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi')");	
            }	
			// added by mujafar for KDAH-CRF-0370.1 start
			if(insert_values.get("chkPanValidate")!=null)
			{
			if((insert_values.get("chkPanValidate")).equals("true"))
				sql.append(",PAN_CARD_STATUS='"+(String)insert_values.get("pan_status")+"',PAN_CARD_HOLDER_NAME='"+(String)insert_values.get("pan_holder_name")+"',INT_TRANSACTION_ID='"+(String)insert_values.get("pan_trans_id")+"',PAN_RELATION='"+(String)insert_values.get("pan_rel_mem")+"' ");
			}
			// added by mujafar for KDAH-CRF-0370.1 end

			// Added by Sethu for KDAH-CRF-0362 
			if(insert_values.get("chkAadhaarValidate")!=null)
			{
				System.out.println(" ::: insert_values.get(chkAadhaarValidate) ::: "+insert_values.get("chkAadhaarValidate"));
				if((insert_values.get("chkAadhaarValidate")).equals("true"))
					sql.append(",AADHAAR_CARD_STATUS='"+(String)insert_values.get("aadhaarStatus")+"',AADHAAR_TRANS_ID='"+(String)insert_values.get("aadhaarTransId")+"' ");
			}
			//Maheshwaran K added for MO-CRF-20183.2 as on 08-05-2023
			if(insert_values.get("emp_service_no")!=null)
			{
			sql.append(" ,employee_service_no='"+(String)insert_values.get("emp_service_no")+"' ");
			}
			// added by mujafar for KDAH-CRF-0370.1 end
			sql.append(" where patient_id = '"+patient_id+"'");		
			
//debug_buffer.append("<br> updatePatientDetails1:"+sql.toString()) ;



			if(stmt!=null) stmt.close();
			stmt = con.prepareStatement(sql.toString());

            if(stmt.executeUpdate()>0)
            {

				if(sql.length() > 0) sql.delete(0,sql.length());
				//Below line Modified for this CRF ML-MMOH-CRF-0860.2
				sql.append("update MP_PAT_ADDRESSES set addr1_line1='"+(String)insert_values.get ("res_addr_line1")+"',addr1_line2= '"+(String)insert_values.get("res_addr_line2")+"',addr1_line3='"+(String)insert_values.get("res_addr_line3")+"',addr1_line4='"+(String)insert_values.get("res_addr_line4")+"',postal1_code='"+(String)insert_values.get("res_postal_code")+"' ,country1_code='"+(String)insert_values.get("res_country_code")+"',invalid1_yn='"+(String)insert_values.get("res_invalid_yn")+"',contact1_name='"+(String)insert_values.get("res_contact_name")+"',addr2_line1='"+(String)insert_values.get("mail_addr_line1")+"',addr2_line2='"+(String)insert_values.get("mail_addr_line2")+"',addr2_line3='"+(String)insert_values.get("mail_addr_line3")+"',addr2_line4='"+(String)insert_values.get("mail_addr_line4")+"',postal2_code='"+(String)insert_values.get("mail_postal_code")+"',country2_code='"+(String)insert_values.get("mail_country_code")+"',invalid2_yn='"+(String)insert_values.get("mail_invalid_yn")+"',contact2_name='"+(String)insert_values.get("mail_contact_name")+"',modified_by_id='"+(String)insert_values.get("added_by_id")+"',modified_date=sysdate,modified_at_ws_no='"+(String)insert_values.get("added_at_ws_no")+"',modified_facility_id='"+(String)insert_values.get("added_facility_id")+"',res_area2_code='"+(String)insert_values.get("res_area2_code")+"',res_town2_code='"+(String)insert_values.get("res_town2_code")+"',region2_code='"+(String)insert_values.get("region2_code")+"',res_area1_code='"+(String)insert_values.get("res_area_code")+"',res_town1_code='"+(String)insert_values.get("res_town_code")+"',region1_code='"+(String)insert_values.get("res_region_code")+"',alt_addr_line1='"+(String)insert_values.get("alt_addr_line1")+"',alt_addr_line2='"+(String)insert_values.get("alt_addr_line2")+"',alt_addr_line3='"+(String)insert_values.get("alt_addr_line3")+"',alt_addr_line4='"+(String)insert_values.get("alt_addr_line4")+"',alt_region_code='"+(String)insert_values.get("alt_region_code")+"',alt_area_code='"+(String)insert_values.get("alt_area_code")+"',alt_town_code='"+(String)insert_values.get("alt_town_code")+"',alt_postal_code='"+(String)insert_values.get("alt_postal_code")+"',alt_country_code='"+(String)insert_values.get("alt_country_code")+"',alt_contact_name='"+(String)insert_values.get("alt_contact_name")+"',alt_invalid_yn='"+(String)insert_values.get("alt_invalid_yn")+"' where patient_id='"+patient_id+"'");
//                    debug_buffer.append("<br> updatePatientDetails2:"+sql.toString()) ;


				if(stmt!=null) stmt.close();
				stmt = con.prepareStatement(sql.toString());

                if (stmt.executeUpdate() >0 )
                {
				//Below  code added FOR HSA-CRF-0226 [IN:050599]
				if(upt_contact_dtls_oa_yn.equals("Y")){
				String  appt_count="select count(*)apt_cnt from oa_appt where patient_id='"+patient_id+"' and APPT_DATE>= to_date(sysdate,'DD MM YY')";
				if(rset!=null) rset.close();
		        if(stmt!=null) stmt.close();
	            stmt = con.prepareStatement(appt_count);
				rset=stmt.executeQuery();
				int apt_cnt=0;
				if(rset != null && rset.next()){
				apt_cnt=rset.getInt("apt_cnt");
				} 
				if(apt_cnt > 0){
				//Below line modified for ML-MMOH-CRF-0860.2
				//Below Query Modified by Afruddin for PMG2020-COMN-CRF-0084-US001 on 20-Nov-2020
				//patient_cat_code added in below query by Suji Keerthi for PMG2020-COMN-CRF-0084-US001 on 22-Jan-2021
				 String  update_appt="update oa_appt set res_tel_no='"+(String)insert_values.get("contact1_no")+"', oth_contact_no='"+(String)insert_values.get("contact2_no")+"',email_id='"+(String)insert_values.get("email_id")+"', res_addr_line1='"+(String)insert_values.get ("res_addr_line1")+"', res_addr_line2='"+(String)insert_values.get ("res_addr_line2")+"',res_addr_line3='"+(String)insert_values.get ("res_addr_line3")+"', res_addr_line4='"+(String)insert_values.get ("res_addr_line4")+"',postal_code='"+(String)insert_values.get("res_postal_code")+"',modified_date=sysdate,modified_facility_id='"+(String)insert_values.get("added_facility_id")+"',modified_by_id='"+(String)insert_values.get("added_by_id")+"', modified_at_ws_no='"+(String)insert_values.get("added_at_ws_no")+"',RES_AREA_CODE='"+(String)insert_values.get("res_area_code")+"',RES_TOWN_CODE='"+(String)insert_values.get("res_town_code")+"',RES_REGION_CODE='"+(String)insert_values.get("res_region_code")+"',MAIL_ADDR_LINE1='"+(String)insert_values.get("mail_addr_line1")+"',MAIL_ADDR_LINE2='"+(String)insert_values.get("mail_addr_line2")+"',MAIL_ADDR_LINE3='"+(String)insert_values.get("mail_addr_line3")+"',MAIL_ADDR_LINE4='"+(String)insert_values.get("mail_addr_line4")+"',MAIL_AREA_CODE='"+(String)insert_values.get("res_area2_code")+"',MAIL_TOWN_CODE='"+(String)insert_values.get("res_town2_code")+"',MAIL_REGION_CODE='"+(String)insert_values.get("region2_code")+"',MAIL_POSTAL_CODE='"+(String)insert_values.get("mail_postal_code")+"',MAIL_COUNTRY_CODE='"+(String)insert_values.get("mail_country_code")+"',RES_COUNTRY_CODE='"+(String)insert_values.get("res_country_code")+"',alt_addr_line1='"+(String)insert_values.get("alt_addr_line1")+"',alt_addr_line2='"+(String)insert_values.get("alt_addr_line2")+"',alt_addr_line3='"+(String)insert_values.get("alt_addr_line3")+"',alt_addr_line4='"+(String)insert_values.get("alt_addr_line4")+"',alt_region_code='"+(String)insert_values.get("alt_region_code")+"',alt_area_code='"+(String)insert_values.get("alt_area_code")+"',alt_town_code='"+(String)insert_values.get("alt_town_code")+"',alt_postal_code='"+(String)insert_values.get("alt_postal_code")+"',alt_country_code='"+(String)insert_values.get("alt_country_code")+"',patient_name='"+(String)insert_values.get("patient_name")+"',name_prefix='"+insert_values.get("name_prefix")+"',first_name='"+insert_values.get("first_name")+"',second_name='"+insert_values.get("second_name")+"',third_name='"+insert_values.get("third_name")+"',family_name='"+insert_values.get("family_name")+"',name_suffix='"+insert_values.get("name_suffix")+"',name_prefix_loc_lang = '"+insert_values.get("name_prefix_loc_lang")+"',name_suffix_loc_lang = '"+insert_values.get("name_suffix_loc_lang")+"',first_name_loc_lang = '"+insert_values.get("first_name_loc_lang")+"',second_name_loc_lang = '"+insert_values.get("second_name_loc_lang")+"',third_name_loc_lang = '"+insert_values.get("third_name_loc_lang")+"',family_name_loc_lang ='"+insert_values.get("family_name_loc_lang")+"',patient_name_loc_lang = '"+insert_values.get("patient_name_loc_lang")+"',gender='"+insert_values.get("sex")+"',date_of_birth=to_date('"+insert_values.get("date_of_birth")+"','dd/mm/yyyy hh24:mi:ss'), country_code='"+insert_values.get("nationality_code")+"', national_id_no='"+insert_values.get("national_id_no")+"', alt_id1_no='"+insert_values.get("alt_id1_no")+"',alt_id1_exp_date=to_date('"+insert_values.get("alt_id1_exp_date")+"','dd/mm/yyyy'),alt_id1_type='"+insert_values.get("alt_id1_type")+"',alt_id2_type='"+insert_values.get("alt_id2_type")+"',alt_id2_no='"+insert_values.get("alt_id2_no")+"',alt_id2_exp_date = to_date('"+insert_values.get("alt_id2_exp_date")+"','dd/mm/yyyy'),alt_id3_type='"+insert_values.get("alt_id3_type")+"',alt_id3_no='"+insert_values.get("alt_id3_no")+"',alt_id3_exp_date=to_date('"+insert_values.get("alt_id3_exp_date")+"','dd/mm/yyyy'),alt_id4_type = '"+insert_values.get("alt_id4_type")+"',alt_id4_no='"+insert_values.get("alt_id4_no")+"',alt_id4_exp_date=to_date('"+insert_values.get("alt_id4_exp_date")+"','dd/mm/yyyy'),oth_alt_id_type='"+(String)insert_values.get("other_alt_id")+"',oth_alt_id_no='"+(String)insert_values.get("other_alt_Id_text")+"',race_code='"+insert_values.get("race_code")+"',ethnic_group_code='"+insert_values.get("ethnic_group")+"',birth_place_code='"+insert_values.get("birth_place_code")+"',birth_place_desc='"+insert_values.get("place_of_birth")+"',citizen_yn='"+insert_values.get("citizen_yn")+"',legal_yn = '"+insert_values.get("legal_yn")+"',patient_cat_code='"+(String)insert_values.get("pat_cat_code")+"' where patient_id='"+patient_id+"' and APPT_DATE>= to_date(sysdate,'DD MM YY') ";//Modified for ML-MMOH-CRF-1930 US004
				
				 

                if(stmt!=null)stmt.close();
            	stmt = con.prepareStatement(update_appt);
            	stmt.executeUpdate();
				}
				}
				//end  of HSA-CRF-0226 [IN:050599]
				//if(sql.length() > 0) sql.delete(0,sql.length());
				//Added for ML-MMOH-CRF-1930 US004
				if(isVirtualConsultation.equals("true"))
				{
				try {
					String  appt_count="select count(*)apt_cnt from oa_appt where patient_id='"+patient_id+"' and APPT_DATE>= to_date(sysdate,'DD MM YY')";
				if(rset!=null) rset.close();
		        if(stmt!=null) stmt.close();
	            stmt = con.prepareStatement(appt_count);
				rset=stmt.executeQuery();
				int apt_cnt=0;
				if(rset != null && rset.next()){
				apt_cnt=rset.getInt("apt_cnt");
				} 
					if(apt_cnt > 0){
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append("Update OA_APPT set CONTACT1_MOB_COUNTRY_CODE  = '"+(String)insert_values.get("CONTACT1_MOB_COUNTRY_CODE")+"',contact1_mob_tel_no  = '"+(String)insert_values.get("contact1_mob_tel_no")+"',	contact2_country_code  = '"+(String)insert_values.get("countryC")+"',contact2_telephone_code  = '"+(String)insert_values.get("telephone")+"'  where patient_id='"+patient_id+"' and APPT_DATE>= to_date(sysdate,'DD MM YY')");
						stmt = con.prepareStatement(sql.toString());
						stmt.executeUpdate();
						if(stmt!=null)stmt.close();
						if(rset!=null)rset.close(); 
					}
				}
				catch(Exception e)
					{
					transaction_completed = false;
					debug_buffer.append("<br>"+transaction_completed+"<br>Error in OA Update:"+e.toString()) ;
					error_buf.append("Error in OA Update: "+e.toString());
					e.printStackTrace();	
					}
				}
				/*Added by Dharma against HSA-CRF-0303 [IN:054572] on Apr 7th 2016 Start*/
				if(upd_pat_dtls_referral_yn.equals("Y")){
					String  referralCountQry="select count(*) referralCount from pr_referral_register where patient_id='"+patient_id+"'";
					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
					stmt = con.prepareStatement(referralCountQry);
					rset=stmt.executeQuery();
					int referralCount=0;
					if(rset != null && rset.next()){
						referralCount=rset.getInt("referralCount");
					} 
					if(referralCount > 0){
					   
					    //Below line Modified for this CRF ML-MMOH-CRF-0860.2
					
						String referralUpdateQry= "update PR_REFERRAL_REGISTER set name_prefix='"+insert_values.get("name_prefix")+"',first_name='"+insert_values.get("first_name")+"',second_name='"+insert_values.get("second_name")+"',third_name='"+insert_values.get("third_name")+"',family_name='"+insert_values.get("family_name")+"',name_suffix='"+insert_values.get("name_suffix")+"',patient_name='"+insert_values.get("patient_name")+"',name_prefix_loc_lang = '"+insert_values.get("name_prefix_loc_lang")+"',name_suffix_loc_lang = '"+insert_values.get("name_suffix_loc_lang")+"',first_name_loc_lang = '"+insert_values.get("first_name_loc_lang")+"',second_name_loc_lang = '"+insert_values.get("second_name_loc_lang")+"',third_name_loc_lang = '"+insert_values.get("third_name_loc_lang")+"',family_name_loc_lang ='"+insert_values.get("family_name_loc_lang")+"',patient_name_loc_lang = '"+insert_values.get("patient_name_loc_lang")+"',sex='"+insert_values.get("sex")+"',date_of_birth=to_date('"+insert_values.get("date_of_birth")+"','dd/mm/yyyy hh24:mi:ss'), nationality_code='"+insert_values.get("nationality_code")+"', addr_line1='"+insert_values.get("res_addr_line1")+"', addr_line2='"+insert_values.get("res_addr_line2")+"',addr_line3='"+insert_values.get("res_addr_line3")+"',addr_line4='"+insert_values.get("res_addr_line4")+"',postal_code='"+insert_values.get("res_postal_code")+"',country_code='"+insert_values.get("res_country_code")+"',res_town_code='"+insert_values.get("res_town_code")+"',res_area_code='"+insert_values.get("res_area_code")+"',region_code='"+insert_values.get("res_region_code")+"',contact1_no='"+insert_values.get("contact1_no")+"',contact2_no='"+insert_values.get("contact2_no")+"',national_id_no='"+insert_values.get("national_id_no")+"',alt_id1_no='"+insert_values.get("alt_id1_no")+"',alt_id1_date=to_date('"+insert_values.get("alt_id1_exp_date")+"','dd/mm/yyyy'),alt_id1_type='"+insert_values.get("alt_id1_type")+"',alt_id2_type='"+insert_values.get("alt_id2_type")+"',alt_id2_no='"+insert_values.get("alt_id2_no")+"',alt_id2_date = to_date('"+insert_values.get("alt_id2_exp_date")+"','dd/mm/yyyy'),alt_id3_type='"+insert_values.get("alt_id3_type")+"',alt_id3_no='"+insert_values.get("alt_id3_no")+"',alt_id3_date=to_date('"+insert_values.get("alt_id3_exp_date")+"','dd/mm/yyyy'),alt_id4_type = '"+insert_values.get("alt_id4_type")+"',alt_id4_no='"+insert_values.get("alt_id4_no")+"',alt_id4_date=to_date('"+insert_values.get("alt_id4_exp_date")+"','dd/mm/yyyy'),oth_alt_id_type='"+(String)insert_values.get("other_alt_id")+"',oth_alt_id_no='"+(String)insert_values.get("other_alt_Id_text")+"',mail_addr_line1='"+insert_values.get("mail_addr_line1")+"',mail_addr_line2='"+insert_values.get("mail_addr_line2")+"',mail_addr_line3 = '"+insert_values.get("mail_addr_line3")+"',mail_addr_line4='"+insert_values.get("mail_addr_line4")+"',mail_res_town_code='"+insert_values.get("mail_town_code")+"',mail_res_area_code='"+insert_values.get("mail_area_code")+"',mail_region_code='"+insert_values.get("mail_region_code")+"',mail_postal_code='"+insert_values.get("mail_postal_code")+"',mail_country_code='"+insert_values.get("mail_country_code")+"',email_id='"+insert_values.get("email_id")+"',race_code='"+insert_values.get("race_code")+"',ethnic_grp_code='"+insert_values.get("ethnic_group")+"',birth_place_code='"+insert_values.get("birth_place_code")+"',birth_place_desc='"+insert_values.get("place_of_birth")+"',citizen_yn='"+insert_values.get("citizen_yn")+"',legal_illegal_yn = '"+insert_values.get("legal_yn")+"',modified_by_id='"+insert_values.get("added_by_id")+"',modified_date = sysdate,modified_at_ws_no='"+insert_values.get("added_at_ws_no")+"',modified_facility_id='"+insert_values.get("added_facility_id")+"',alt_addr_line1='"+(String)insert_values.get("alt_addr_line1")+"',alt_addr_line2='"+(String)insert_values.get("alt_addr_line2")+"',alt_addr_line3='"+(String)insert_values.get("alt_addr_line3")+"',alt_addr_line4='"+(String)insert_values.get("alt_addr_line4")+"',alt_region_code='"+(String)insert_values.get("alt_region_code")+"',alt_area_code='"+(String)insert_values.get("alt_area_code")+"',alt_town_code='"+(String)insert_values.get("alt_town_code")+"',alt_postal_code='"+(String)insert_values.get("alt_postal_code")+"',alt_country_code='"+(String)insert_values.get("alt_country_code")+"' WHERE PATIENT_ID ='"+patient_id+"'";
						
						
						if(stmt!=null)stmt.close();
						if(rset!=null)rset.close();  //Added for checkstyle
						stmt = con.prepareStatement(referralUpdateQry);
						stmt.executeUpdate();
					}
				}
				/*Added by Dharma against HSA-CRF-0303 [IN:054572] on Apr 7th 2016 End*/





					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("update MP_PAT_OTH_DTLS set living_dependency='"+(String)insert_values.get("living_dependency")+"',living_arrangement='"+(String)insert_values.get("living_arrangement")+"',education_level='"+(String)insert_values.get("education_level")+"',regn_informant='"+(String)insert_values.get("regn_informant")+"',regn_comments='"+(String)insert_values.get("regn_comments")+"',general_remarks='"+(String)insert_values.get("general_remarks")+"',addl_field1='"+(String)insert_values.get("addl_field1")+"',addl_field2='"+(String)insert_values.get("addl_field2")+"',addl_field3='"+(String)insert_values.get("addl_field3")+"',addl_field4='"+(String)insert_values.get("addl_field4")+"',addl_field5='"+(String)insert_values.get("addl_field5")+"',modified_by_id='"+(String)insert_values.get("added_by_id")+"',modified_date = sysdate,modified_at_ws_no='"+(String)insert_values.get("added_at_ws_no")+"',modified_facility_id='"+(String)insert_values.get("added_facility_id")+"',blood_grp='"+(String)insert_values.get("blood_group")+"',rh_factor='"+(String)insert_values.get("rf_code")+"' where patient_id = '"+patient_id+"'");
//                    debug_buffer.append("<br> updatePatientDetails3:"+sql.toString()) ;
					if(stmt!=null)stmt.close();
					stmt = con.prepareStatement(sql.toString());

                    if (stmt.executeUpdate() >0 )
                    {

						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append("update MP_PAT_REL_CONTACTS set contact1_relation = '"+(String)insert_values.get("next_contact_relation")+"',contact1_name = '"+(String)insert_values.get("next_contact_name")+"',job1_title =  '"+(String)insert_values.get("next_job_title")+"',addr1_line1= '"+(String)insert_values.get("next_addr_line1")+"',addr1_line2= '"+(String)insert_values.get("next_addr_line2")+"',addr1_line3= '"+(String)insert_values.get("next_addr_line3")+"',addr1_line4 = '"+(String)insert_values.get("next_addr_line4")+"',postal1_code= '"+(String)insert_values.get("next_postal_code")+"',country1_code= '"+(String)insert_values.get("next_country_code")+"',res1_tel_no = '"+(String)insert_values.get("next_res_tel_no")+"',off1_tel_no= '"+(String)insert_values.get("next_off_tel_no")+"',contact2_relation= '"+(String)insert_values.get("first_contact_relation")+"',contact2_name= '"+(String)insert_values.get("first_contact_name")+"',job2_title = '"+(String)insert_values.get("first_job_title")+"',addr2_line1= '"+(String)insert_values.get("first_addr_line1")+"',addr2_line2= '"+(String)insert_values.get("first_addr_line2")+"',addr2_line3= '"+(String)insert_values.get("first_addr_line3")+"',addr2_line4= '"+(String)insert_values.get("first_addr_line4")+"',postal2_code= '"+(String)insert_values.get("first_postal_code")+"',country2_code= '"+(String)insert_values.get("first_country_code")+"',res2_tel_no = '"+(String)insert_values.get("first_res_tel_no")+"',off2_tel_no= '"+(String)insert_values.get("first_off_tel_no")+"',contact3_name='"+(String)insert_values.get("empyr_contact_name")+"',job3_title='"+(String)insert_values.get("empyr_job_title")+"',addr3_line1='"+(String)insert_values.get("employ_addr_line1")+"',addr3_line2='"+(String)insert_values.get("employ_addr_line2")+"',addr3_line3='"+(String)insert_values.get("employ_addr_line3")+"',addr3_line4='"+(String)insert_values.get("employ_addr_line4")+"',postal3_code='"+(String)insert_values.get("employ_postal_code")+"',country3_code='"+(String)insert_values.get("empyr_country_code")+"',off3_tel_no='"+(String)insert_values.get("empyr_off_tel_no")+"',off_fax_no='"+(String)insert_values.get("empyr_off_fax_no")+"',ocpn_code='"+(String)insert_values.get("occ_of_per")+"',ocpn_desc='"+(String)insert_values.get("occu_of_per_desc")+"',employment_status='"+(String)insert_values.get("empyr_employment_status")+"',patient_employee_id='"+(String)insert_values.get("empyr_eid")+"',modified_by_id ='"+(String)insert_values.get("added_by_id")+"',modified_date =sysdate,modified_at_ws_no = '"+(String)insert_values.get("added_at_ws_no")+"',modified_facility_id=  '"+(String)insert_values.get("added_facility_id")+"',organization_name='"+(String)insert_values.get("organization_name")+"',contact3_res_area_code='"+(String)insert_values.get("contact3_res_area_code")+"',contact3_res_town_code='"+(String)insert_values.get("contact3_res_town_code")+"',contact3_region_code='"+(String)insert_values.get("contact3_region_code")+"',contact2_mob_tel_no='"+(String)insert_values.get("contact2_mob_tel_no")+"',contact2_email_id='"+(String)insert_values.get("contact2_email_id")+"',contact2_res_area_code='"+(String)insert_values.get("contact2_res_area_code")+"',contact2_region_code='"+(String)insert_values.get("contact2_region_code")+"',contact2_res_town_code='"+(String)insert_values.get("contact2_res_town_code")+"',contact1_alt_id1_type='"+(String)insert_values.get("contact1_alt_id1_type")+"',contact1_alt_id1_no='"+(String)insert_values.get("contact1_alt_id1_no")+"',contact1_alt_id2_type='"+(String)insert_values.get("contact1_alt_id2_type")+"',contact1_alt_id2_no='"+(String)insert_values.get("contact1_alt_id2_no")+"',contact1_alt_id3_type='"+(String)insert_values.get("contact1_alt_id3_type")+"',contact1_alt_id3_no='"+(String)insert_values.get("contact1_alt_id3_no")+"',contact1_alt_id4_type='"+(String)insert_values.get("contact1_alt_id4_type")+"',contact1_alt_id4_no='"+(String)insert_values.get("contact1_alt_id4_no")+"',contact1_nat_id_no='"+(String)insert_values.get("contact1_new_nat_id_no")+"',contact1_oth_alt_id_type='"+(String)insert_values.get("contact1_oth_alt_id_type")+"',contact1_oth_alt_id_no='"+(String)insert_values.get("contact1_oth_alt_id_no")+"',contact1_birth_date=to_date('"+(String)insert_values.get("contact1_birth_date")+"','dd/mm/yyyy'),contact1_res_area_code='"+(String)insert_values.get("contact1_res_area_code")+"',contact1_region_code='"+(String)insert_values.get("contact1_region_code")+"',contact1_res_town_code='"+(String)insert_values.get("contact1_res_town_code")+"',contact1_mob_tel_no='"+(String)insert_values.get("contact1_mob_tel_no")+"',contact1_email_id='"+(String)insert_values.get("contact1_email_id")+"',res3_tel_no='"+(String)insert_values.get("res3_tel_no")+"',ocpn_class_code='"+(String)insert_values.get("occ_class")+"',contact2_nat_id_no='"+(String)insert_values.get("contact2_nat_id_no")+"',contact2_oth_alt_id_type='"+(String)insert_values.get("notify_oth_alt_id_type")+"',contact2_oth_alt_id_no='"+(String)insert_values.get("notify_oth_alt_id_text")+"',contact1_aliasname = '"+(String)insert_values.get("rel_alias_name")+"',contact1_nationality = '"+(String)insert_values.get("rel_nationality_code")+"',contact1_race = '"+(String)insert_values.get("rel_race_code")+"',nk_mail_addr_line1 = '"+(String)insert_values.get("n_next_addr_line1")+"',nk_mail_addr_line2 = '"+(String)insert_values.get("n_ma_addr_line2")+"',nk_mail_addr_line3 = '"+(String)insert_values.get("n_ma_addr_line3")+"',nk_mail_addr_line4 = '"+(String)insert_values.get("n_ma_addr_line4")+"',nk_mail_town_code = '"+(String)insert_values.get("n_contact_ma_town_code")+"',nk_mail_region_code = '"+(String)insert_values.get("n_contac_region_code")+"',nk_mail_area_code = '"+(String)insert_values.get("n_contact_ma_area_code")+"',nk_mail_postal_code  = '"+(String)insert_values.get("n_ma_postal_code")+"',nk_mail_country_code= '"+(String)insert_values.get("nkin_m_country_desc")+"',nk_res_contact_name= '"+(String)insert_values.get("resadd_contact_name")+"',nk_mail_contact_name= '"+(String)insert_values.get("mailadd_contact_name")+"',nk_contact3_mode = '"+(String)insert_values.get("nk_contact3_mode")+"',nk_contact3_no = '"+(String)insert_values.get("nk_contact3_no")+"',nk_contact4_mode = '"+(String)insert_values.get("nk_contact4_mode")+"',nk_contact4_no = '"+(String)insert_values.get("nk_contact4_no")+"',nk_contact5_mode = '"+(String)insert_values.get("nk_contact5_mode")+"',nk_contact5_no = '"+(String)insert_values.get("nk_contact5_no")+"',fton_mail_addr_line1 = '"+(String)insert_values.get("fton_mail_addr_line1")+"',fton_mail_addr_line2 = '"+(String)insert_values.get("fton_mail_addr_line2")+"',fton_mail_addr_line3 = '"+(String)insert_values.get("fton_mail_addr_line3")+"',fton_mail_addr_line4 = '"+(String)insert_values.get("fton_mail_addr_line4")+"',fton_mail_town_code = '"+(String)insert_values.get("fst_to_no_ma_town_code")+"',fton_mail_area_code = '"+(String)insert_values.get("fst_to_no_ma_area_code")+"',fton_mail_region_code = '"+(String)insert_values.get("fst_to_no_ma_reg_cod")+"',fton_mail_postal_code = '"+(String)insert_values.get("fst_no_ma_pos_cod")+"',fton_mail_country_code = '"+(String)insert_values.get("fton_m_country_desc")+"',fton_res_contact_name = '"+(String)insert_values.get("fton_resadd_contact_name")+"',fton_mail_contact_name = '"+(String)insert_values.get("fton_mailadd_contact_name")+"',fton_contact3_mode = '"+(String)insert_values.get("fton_contact3_mode")+"',fton_contact3_no = '"+(String)insert_values.get("fton_contact3_no")+"',fton_contact4_mode = '"+(String)insert_values.get("fton_contact4_mode")+"',fton_contact4_no = '"+(String)insert_values.get("fton_contact4_no")+"',fton_contact5_mode = '"+(String)insert_values.get("fton_contact5_mode")+"',fton_contact5_no = '"+(String)insert_values.get("fton_contact5_no")+"',contact1_country_code = '"+(String)insert_values.get("countryC")+"',contact1_telephone_code = '"+(String)insert_values.get("telephone")+"', CONTACT1_MOB_COUNTRY_CODE = '"+(String)insert_values.get("CONTACT1_MOB_COUNTRY_CODE")+"' where patient_id = '"+patient_id+"'");//Query Modified by Suji Keerthi for ML-MMOH-CRF-1527 US008 //Modified by Arthi for ML-MMOH-CRF-1930 US004
//						debug_buffer.append("<br> updatePatientDetails5:"+sql.toString()) ;
						if(stmt!=null) stmt.close();
						stmt = con.prepareStatement(sql.toString());

                        if(stmt.executeUpdate()>0)
                        {

                            updatePatDocs();
                        }
                    }
                }
            }
        }
        catch(Exception e)
        {
            transaction_completed = false;
            debug_buffer.append("<br>"+transaction_completed+"<br>Update updatePatientDetails:"+e.toString()) ;
			error_buf.append("Error in Update: "+e.toString());
			e.printStackTrace();
        }
        debug_buffer.append("End updatePatientDetails") ;
    }

    private void updateRefferal()
    {
        transaction_completed = false;
        debug_buffer.append("<br>Start updateReferral") ;
        try
        {
            if(sql.length() > 0) sql.delete(0,sql.length());
			
			//Below line line modified for this ML-MMOH-CRF-0860.2
			
			sql.append("update PR_REFERRAL_REGISTER set patient_id='"+patient_id+"',name_prefix='"+insert_values.get("name_prefix")+"',first_name='"+insert_values.get("first_name")+"',second_name='"+insert_values.get("second_name")+"',third_name='"+insert_values.get("third_name")+"',family_name='"+insert_values.get("family_name")+"',name_suffix='"+insert_values.get("name_suffix")+"',patient_name='"+insert_values.get("patient_name")+"',name_prefix_loc_lang = '"+insert_values.get("name_prefix_loc_lang")+"',name_suffix_loc_lang = '"+insert_values.get("name_suffix_loc_lang")+"',first_name_loc_lang = '"+insert_values.get("first_name_loc_lang")+"',second_name_loc_lang = '"+insert_values.get("second_name_loc_lang")+"',third_name_loc_lang = '"+insert_values.get("third_name_loc_lang")+"',family_name_loc_lang ='"+insert_values.get("family_name_loc_lang")+"',patient_name_loc_lang = '"+insert_values.get("patient_name_loc_lang")+"',sex='"+insert_values.get("sex")+"',date_of_birth=to_date('"+insert_values.get("date_of_birth")+"','dd/mm/yyyy hh24:mi:ss'),nationality_code='"+insert_values.get("nationality_code")+"',addr_line1='"+insert_values.get("res_addr_line1")+"',addr_line2='"+insert_values.get("res_addr_line2")+"',addr_line3='"+insert_values.get("res_addr_line3")+"',addr_line4='"+insert_values.get("res_addr_line4")+"',postal_code='"+insert_values.get("res_postal_code")+"',country_code='"+insert_values.get("res_country_code")+"',res_town_code='"+insert_values.get("res_town_code")+"',res_area_code='"+insert_values.get("res_area_code")+"',region_code='"+insert_values.get("res_region_code")+"',contact1_no='"+insert_values.get("contact1_no")+"',contact2_no='"+insert_values.get("contact2_no")+"',national_id_no='"+insert_values.get("national_id_no")+"',alt_id1_no='"+insert_values.get("alt_id1_no")+"',alt_id1_date=to_date('"+insert_values.get("alt_id1_exp_date")+"','dd/mm/yyyy'),alt_id1_type='"+insert_values.get("alt_id1_type")+"',alt_id2_type='"+insert_values.get("alt_id2_type")+"',alt_id2_no='"+insert_values.get("alt_id2_no")+"',alt_id2_date = to_date('"+insert_values.get("alt_id2_exp_date")+"','dd/mm/yyyy'),alt_id3_type='"+insert_values.get("alt_id3_type")+"',alt_id3_no='"+insert_values.get("alt_id3_no")+"',alt_id3_date=to_date('"+insert_values.get("alt_id3_exp_date")+"','dd/mm/yyyy'),alt_id4_type = '"+insert_values.get("alt_id4_type")+"',alt_id4_no='"+insert_values.get("alt_id4_no")+"',alt_id4_date=to_date('"+insert_values.get("alt_id4_exp_date")+"','dd/mm/yyyy'),oth_alt_id_type='"+(String)insert_values.get("other_alt_id")+"',oth_alt_id_no='"+(String)insert_values.get("other_alt_Id_text")+"',mail_addr_line1='"+insert_values.get("mail_addr_line1")+"',mail_addr_line2='"+insert_values.get("mail_addr_line2")+"',mail_addr_line3 = '"+insert_values.get("mail_addr_line3")+"',mail_addr_line4='"+insert_values.get("mail_addr_line4")+"',mail_res_town_code='"+insert_values.get("mail_town_code")+"',mail_res_area_code='"+insert_values.get("mail_area_code")+"',mail_region_code='"+insert_values.get("mail_region_code")+"',mail_postal_code='"+insert_values.get("mail_postal_code")+"',mail_country_code='"+insert_values.get("mail_country_code")+"',email_id='"+insert_values.get("email_id")+"',race_code='"+insert_values.get("race_code")+"',ethnic_grp_code='"+insert_values.get("ethnic_group")+"',birth_place_code='"+insert_values.get("birth_place_code")+"',birth_place_desc='"+insert_values.get("place_of_birth")+"',citizen_yn='"+insert_values.get("citizen_yn")+"',legal_illegal_yn = '"+insert_values.get("legal_yn")+"',modified_by_id='"+insert_values.get("added_by_id")+"',modified_date = sysdate,modified_at_ws_no='"+insert_values.get("added_at_ws_no")+"',modified_facility_id='"+insert_values.get("added_facility_id")+"',alt_addr_line1='"+(String)insert_values.get("alt_addr_line1")+"',alt_addr_line2='"+(String)insert_values.get("alt_addr_line2")+"',alt_addr_line3='"+(String)insert_values.get("alt_addr_line3")+"',alt_addr_line4='"+(String)insert_values.get("alt_addr_line4")+"',alt_region_code='"+(String)insert_values.get("alt_region_code")+"',alt_area_code='"+(String)insert_values.get("alt_area_code")+"',alt_town_code='"+(String)insert_values.get("alt_town_code")+"',alt_postal_code='"+(String)insert_values.get("alt_postal_code")+"',alt_country_code='"+(String)insert_values.get("alt_country_code")+"' WHERE PATIENT_ID is null ");
			if(refrlAappt.equals("L"))
			{
				sql.append(" AND referral_id = '"+refIDValue+"' ");
			}
			else
			{
				sql.append(" AND referral_id = '"+insert_values.get("referral_id")+"' ");
			}

           // debug_buffer.append("updateReferral1:"+sql.toString());
			if(stmt!=null) stmt.close();

			stmt = con.prepareStatement(sql.toString());
            if(stmt.executeUpdate()>0) transaction_completed = true;
			else
			{
				transaction_completed	= false;
				tableUpdated			= false;
			}
			if(stmt!=null) stmt.close();
            debug_buffer.append("<br>"+transaction_completed+"<BR>End updateReferral") ;
        }
        catch(Exception e)
        {
			transaction_completed = false;
            debug_buffer.append("<br>Update Referral:"+e.toString()) ;
			error_buf.append("Error in Uptate Referral : "+e.toString());
			e.printStackTrace();
        }
    }

    private void getMRNFile() throws Exception
    {
        String GeneratedFileNo="";
		String generate_file = (String)insert_values.get("generate_file");
		debug_buffer.append(" Start getMRNFile ");
		if(generate_file.equals("Y"))
		{
			transaction_completed = false;

			try
			{
				GeneratedFileNo = "";
				showModalForOldFileNo(GeneratedFileNo, true, msg_buffer);
				transaction_completed = true;
			}
			catch(Exception e)
			{
				transaction_completed = false;
				debug_buffer.append("Error in get MRN File "+e.toString());
				error_buf.append("Error in File Number Generation: "+e.toString());
				e.printStackTrace();
			}
		}
        debug_buffer.append(" <br>End getMRNFile ");
    }

  private void showModalForOldFileNo(String GeneratedFileNo, boolean showModal, StringBuffer msgbuffer)
  {
	  debug_buffer.append("<br>start showModalForOldFileNo ") ;
	  try
      {
		  String dflt_locn_code = "" ;
		  //Below code's are changed for edge conversion by Vedesh A D.
         /* String outputVal="<html>"+
                        "<head>"+
                            "<link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link>"+
                            "<script>"+
                                "function showModal(){"+
                                    "var retVal;"+
								    "var arr1;"+
									"var file_no='';"+
									"var fs_location='';"+
                                    "var dialogHeight   = '18' ;"+
                                    "var dialogWidth    = '23' ;"+
                                    "var features   = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';"+
                                    "var arguments  = '"+GeneratedFileNo+"' ;"+
                                    "retVal = window.showModalDialog('../eMP/jsp/CallCreateFileComponent.jsp?Called_From=MP&Location_Type=null&Location_Code=null&P_Patient_ID="+patient_id+"&P_Pat_Ser_Grp_Code="+pat_ser_grp_code+"',arguments,features);"+
									"if(retVal== null)  retVal = '';" +
									"var arr = retVal.split('`');  " +
									"if(arr[0]==null) arr[0]=''; " +
									"if(arr[0]!=''){arr1=arr[0].split('||');if(arr1.length==2) {file_no = arr1[1];fs_location=arr1[0];}else{file_no = arr1[0];fs_location=arr1[0];}}  " +
									"document.all.old_file_no.value = file_no;   "+
                                    "document.all.fs_locn_code.value = fs_location;   "+
                                    "document.form1.submit();"+
                                "}"+
                            "</script>"+
                        "</head>"+
                        "<body class='message'>"+
                            "<form name='form1' method='post' action='../servlet/eMP.PatientRegistrationServlet' target='messageFrame'>"+
                                "<input type='hidden' name='old_file_no'></input>"+
                                "<input type='hidden' name='fs_locn_code'></input>"+
                                "<input type='hidden' name='pat_ser_grp_code' value='"+(String)insert_values.get("pat_ser_grp_code")+"'></input>"+
                                "<input type='hidden' name='patient_id' value='"+patient_id+"'></input>"+
                                "<input type='hidden' name='facility_id' value='"+(String)insert_values.get("facility_id")+"'></input>"+
                                "<input type='hidden' name='gen_file_no' value='"+GeneratedFileNo+"'></input>"+
                                "<input type='hidden' name='operation' value='update_file_no'></input> "+
                                "<input type='hidden' name='function_id' value='"+ (String)insert_values.get("calling_function_id") +"'></input> "+ // added this line by Abirami - Bru-HIMS-CRF-313
                                "<input type='hidden' name='appt_ref_no' value='"+insert_values.get("appt_ref_no")+"'></input>"+
								"<input type='hidden' name='sStyle' value='"+insert_values.get("sStyle")+"'></input>"+
								"<input type='hidden' name='maintain_doc_or_file' value='"+insert_values.get("maintain_doc_or_file")+"'></input>"+
								"<input type='hidden' name='func_act' value='"+(String)insert_values.get("func_act")+"'></input>"+
								"<input type='hidden' name='msg_buffer' value=\""+java.net.URLEncoder.encode(msgbuffer.toString())+"\"></input>"+
                            "</form>"+
                                "<script>"+
                                    "if("+showModal+")showModal();"+
                                    "else {document.all.fs_locn_code.value=\""+dflt_locn_code+"\";document.form1.submit();}" +
                                "</script>"+
                            "</body>"+
                        "</html>";*/
	 String outputVal="var HTMLVal = `<form name='form1' method='post' action='../servlet/eMP.PatientRegistrationServlet' target='messageFrame'>"+
                          "<input type='hidden' id='old_file_no' name='old_file_no'></input>"+
                          "<input type='hidden' id='fs_locn_code'name='fs_locn_code'></input>"+
                          "<input type='hidden' id='pat_ser_grp_code' name='pat_ser_grp_code' value='"+(String)insert_values.get("pat_ser_grp_code")+"'></input>"+
                          "<input type='hidden' id='patient_id' name='patient_id' value='"+patient_id+"'></input>"+
                          "<input type='hidden' id='facility_id' name='facility_id' value='"+(String)insert_values.get("facility_id")+"'></input>"+
                          "<input type='hidden' id='gen_file_no' name='gen_file_no' value='"+GeneratedFileNo+"'></input>"+
                          "<input type='hidden' id='operation' name='operation' value='update_file_no'></input> "+
                          "<input type='hidden' id='function_id' name='function_id' value='"+ (String)insert_values.get("calling_function_id") +"'></input> "+ // added this line by Abirami - Bru-HIMS-CRF-313
                          "<input type='hidden' id='appt_ref_no' name='appt_ref_no' value='"+insert_values.get("appt_ref_no")+"'></input>"+
						  "<input type='hidden' id='sStyle' name='sStyle' value='"+insert_values.get("sStyle")+"'></input>"+
						  "<input type='hidden' id='maintain_doc_or_file' name='maintain_doc_or_file' value='"+insert_values.get("maintain_doc_or_file")+"'></input>"+
						  "<input type='hidden' id='func_act' name='func_act' value='"+(String)insert_values.get("func_act")+"'></input>"+
						  "<input type='hidden' id='msg_buffer' name='msg_buffer' value=\""+java.net.URLEncoder.encode(msgbuffer.toString())+"\"></input>"+
							"</form>`; self.document.write(HTMLVal);"+
                             "if("+showModal+")" +
                              		"{" +
                              		"var retVal;"+
    							    "var arr1;"+
    								"var file_no='';"+
    								"var fs_location='';"+
    								"var dialogHeight   = '55vh' ;"+
    								"var dialogWidth    = '55vw' ;"+
    								"var features   = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';"+
    								"var arguments  = '"+GeneratedFileNo+"' ;"+
    								"retVal = await window.showModalDialog('../../eMP/jsp/CallCreateFileComponent.jsp?Called_From=MP&Location_Type=null&Location_Code=null&P_Patient_ID="+patient_id+"&P_Pat_Ser_Grp_Code="+pat_ser_grp_code+"',arguments,features);"+
    								"if(retVal== null)  retVal = '';" +
    								"var arr = retVal.split('`');  " +
    								"if(arr[0]==null) arr[0]=''; " +
    								"if(arr[0]!=''){arr1=arr[0].split('||');if(arr1.length==2) {file_no = arr1[1];fs_location=arr1[0];}else{file_no = arr1[0];fs_location=arr1[0];}}  " +
    								"document.getElementById('old_file_no').value = file_no;   "+
                                  	"document.getElementById('fs_locn_code').value = fs_location;   "+
                                  	"self.document.form1.submit();await new Promise(resolve => setTimeout(resolve, 1000));"+
                              		"}"+
                              "else {document.getElementById('fs_locn_code').value=\""+dflt_locn_code+"\";self.document.form1.submit();await new Promise(resolve => setTimeout(resolve, 1000));}";
      
            ret_hash.put("MRNPrompt", outputVal) ;

        }
        catch(Exception e)
        {

            debug_buffer.append("<br>error in showModalForOldFileNo"+e) ;
            transaction_completed = false;
			e.printStackTrace();
        }
        debug_buffer.append("<br>end showModalForOldFileNo ") ;
    }
	private void updateExternalDataSource()
    {
        //transaction_completed = false;
        debug_buffer.append("<br>Start updateReferral") ;
        try
        {
            if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("update XF_PERSON set status='S',ehis_pat_id='"+patient_id+"',modified_by_id = '"+insert_values.get("added_by_id")+"',modified_date = sysdate,modified_at_ws_no = '"+insert_values.get("added_at_ws_no")+"',modified_facility_id  = '"+insert_values.get("added_facility_id")+"' WHERE NATIONAL_ID_NO ='"+((String)insert_values.get("national_id_no"))+"' ");
			System.out.println("updateExternalDataSource:"+sql.toString());
			if(stmt!=null) stmt.close();

			stmt = con.prepareStatement(sql.toString());
			int xf_personCount=stmt.executeUpdate();
			System.out.println("xf_personCount :"+xf_personCount);
			
			ResultSet photoRs=null;
			Blob pat_photo_blob=null;
			PreparedStatement photoPstmt =null;
			int patPhotoCount=0;
			//byte [] data =null;
			//long len=0;
			if(xf_personCount > 0){
				photoRs = stmt.executeQuery("Select PAT_PHOTO_BLOB from xf_person where NATIONAL_ID_NO = '"+((String)insert_values.get("national_id_no"))+"' ");
				if(photoRs!=null && photoRs.next()) {
					pat_photo_blob = photoRs.getBlob("PAT_PHOTO_BLOB");	
					patPhotoCount++;
				}
				
				//len = pat_photo_blob.length();
				//data = pat_photo_blob.getBytes(1, len);
				//data = pat_photo_blob.getBytes();
				System.out.println("patPhotoCount :"+patPhotoCount);
				if(patPhotoCount>0){
					String sql ="INSERT INTO MP_PATIENT_PHOTO(PAT_PHOTO_BLOB,PATIENT_ID,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) VALUES (?,'"+patient_id+"',?,sysdate,?,?,?,sysdate,?,?)";
					photoPstmt = con.prepareStatement(sql.toString());
					System.out.println("sql :"+sql.toString());
					photoPstmt.setBlob(1,pat_photo_blob);
					photoPstmt.setString(2,(String)insert_values.get("added_by_id"));
					photoPstmt.setString(3,(String)insert_values.get("added_at_ws_no"));
					photoPstmt.setString(4,(String)insert_values.get("added_facility_id"));
					photoPstmt.setString(5,(String)insert_values.get("added_by_id"));
					photoPstmt.setString(6,(String)insert_values.get("added_at_ws_no"));
					photoPstmt.setString(7,(String)insert_values.get("added_facility_id"));	
					//int patPhotoUpdtCount=photoPstmt.executeUpdate();  //this line commented for checkstyle voilation					
					 photoPstmt.executeUpdate();
					
				}
			}			
			if(stmt!=null) stmt.close();
			if(photoRs!=null) photoRs.close();// added  for Checkstyle  by Munisekhar
			if(photoPstmt!=null) photoPstmt.close();
            debug_buffer.append("<br>"+transaction_completed+"<BR>End xf_person") ;
        }
        catch(Exception e)
        {
			//transaction_completed = false;
            debug_buffer.append("<br>Update Referral:"+e.toString()) ;
			error_buf.append("Error in updateExternalDataSource Uptate xf_person : "+e.toString());
			e.printStackTrace();
        }
    }
}
