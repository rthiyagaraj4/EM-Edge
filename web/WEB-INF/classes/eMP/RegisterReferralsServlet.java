/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
*	@MODULE			:	OutPatient Management..(OP)
*	@Developer		:	SRIDHAR R
*	@Created On		:	6 SEP 2004
*	@Function Name	:	RegisterReferralsServlet will register the Referral details to PR_REFERRAL_REGISTER table...
*/

package eMP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;//Added by Kamatchi S for security issue against COMMON-ICN-0187

public class RegisterReferralsServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;
	Connection con			= null;

	String called_from			= "";
	String status				= "O";
	String mode					= "";
	String encounterid			= "";
	String patient_id			= "";
	String alt_id1_exp_date		= "";
	String alt_id1_type			= "";
	String alt_id2_exp_date		= "";
	String alt_id2_type			= "";
	String alt_id3_exp_date		= "";
	String alt_id3_type			= "";
	String alt_id4_exp_date		= "";
	String alt_id4_type			= "";
	String birth_place_code		= "";
	String citizen_yn			= "";	
	String ethnic_grp_code		= "";	
	String race_code			= "";	
	String legal_yn				= "";	
	String patient_name			= "";	
	String res_area_code		= "";	
	String res_town_code		= "";	
	String gender				= "";
	String  hdd_discharge_indicator= "";
	String  from_facility_id		= "";
	String  from_encounter_id		= "";
	String  from_hcare_setting_type	= "";
	String  from_ref_code			= "";
	String  from_ref_type			= "";
	String  from_pract_id			= "";
	String  from_pract_name			= "";
	String  from_service_code		= "";
	String  from_speciality_code	= "";
	String  from_locn_type			= "";
	String  from_locn_code			= "";
	String  from_locn_desc			= "";

	String	from_locn_desc1	        =" ";
 
	/// To Values
	String ref_for_ip				= "";
	String to_preferred_date		= "";
	String to_priority				= "";
	String  to_facility_id			= ""; 
	String  to_hcare_setting_type	= ""; 
	String  to_ref_code				= "";
	String  to_ref_type				= ""; 
	String  to_locn_code			= ""; 
	String  to_locn_desc			= ""; 
	String  to_locn_type			= ""; 
	String  to_pract_id				= ""; 
	String  to_pract_name			= ""; 
	String  to_service_code			= ""; 
	String  to_speciality_code		= "";
	String  ref_notes				= ""; 
	String  Transaction_type		= "";
	String  call_function			= "";
	String  function_id				= "";
	String  referral_idS			= "";
	String  RefIDs					= "";
	String client_ip_address		= "";
	String facilityId				= "";
	String addedById				= "";
	String modifiedById				= "";
	String addedFacilityId			= "";
	String modifiedFacilityId		= "";
	String addedAtWorkstation		= "";
	String modifiedAtWorkstation	= "";
	String bedSideReferral_id	= "";
	String BedSideDate			= "";
	String bedside_ref_review_status=""; //Aadded for this CRF HSA-CRF-146.1
	String allow_muti_bedside_review_yn=""; //Aadded for this CRF HSA-CRF-146.1

	String referral_reason_code = "";

	
	String ca_ref_letter_notes_rec_yn ="";//Added by Rameswar on 30-Jan-16 for ML-MMOH-CRF-0362

	StringBuffer Pat_Sql = new StringBuffer();

	HttpSession session;


	boolean inserted		= false;
	PreparedStatement pstmt	= null;
	Statement stmt			= null;
	PreparedStatement pstmt1= null;
	ResultSet rs			= null;
	ResultSet rs1			= null;
    ResultSet rs2           =null;//this line Added for this incident [41098]
	int rs_am_ref			= 0;
	String referral_id		= "";
//	String current_year		= "";
	String generate_Ref_id	= "";
//	String alternate_Ref_id	= "";
	String date_of_birth	= "";
	String email_id			= "";
	String name_prefix		= "";
	String family_name		= "";
	String name_suffix		= "";
	String first_name		= "";
	String second_name		= "";
	String third_name		= "";
	String national_id_no	= "";
	String nationality_code = "";
	String oth_alt_id_no	= "";
	String oth_alt_id_type	= "";
	String alt_id1_no		= "";
	String alt_id2_no		= "";
	String alt_id3_no		= "";
	String alt_id4_no		= "";
	String locale			= "" ;
	String name_prefix_loc_lang = "" ;
	String first_name_loc_lang  = "" ; 
	String second_name_loc_lang = "" ;
	String third_name_loc_lang  = "" ;
	String family_name_loc_lang = "" ;
	String name_suffix_loc_lang = "" ;
	String patient_name_loc_lang = "" ;
	String regtrd_yn = "" ;
	
	/*Below line Added for this CRF Bru-HIMS-CRF-261*/
	String bedcode="";
	String bedtype="";
	String visitadmtype="";
	String sStyle="";
	String quick_admission="";
	//End Bru-HIMS-CRF-261
	
	/*Below variables added by venkatesh.s against MMS-SCF-0310 [IN:047602]  on 13-Mar-2014*/
	String addr_line1="";
	String addr_line2="";
	String addr_line3="";
	String addr_line4="";
	String postal_code="";
	String country_code="";
	String region_code="";
	String contact1_no="";
	String contact2_no="";
	String mail_addr_line1="";
	String mail_addr_line2="";
	String mail_addr_line3="";
	String mail_addr_line4="";
	String mail_res_town_code="";
	String mail_res_area_code="";
	String mail_country_code="";
	String mail_postal_code="";
	String mail_region_code="";
	String transfer_case_yn=""; //Added by Afruddin for ML-MMOH-CRF-1527 US3 on 23.07.2020
	String for_ip_adm_status=""; //Added by Santhosh for ML-MMOH-CRF-1972

	//Added by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978
	String patient_class="";
	boolean isBedSideReferralApplforAE = false;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");		
		String bedside_referral_yn	= ""; //this line Added for this CRF Bru-HIMS-CRF-354 [IN:038538] 
		locale = p.getProperty("LOCALE");
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			//Added by Kamatchi S for security issue against COMMON-ICN-0187
			req = new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
			//Added by Kamatchi S for security issue against COMMON-ICN-0187 END
			this.out = res.getWriter();
			sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
					|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
					.getAttribute("PREFERRED_STYLE")
					: "IeStyle.css";
			out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link><script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'> async function callRegisterReferralsServletHtml (){ ");			
			con = ConnectionManager.getConnection(req);

			isBedSideReferralApplforAE = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "BED_SIDE_REFERRAL_FOR_AE");//Added by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978

			Transaction_type	= checkForNull(req.getParameter("Transaction_type"));
			call_function		= checkForNull(req.getParameter("call_function"));
			patient_class		= checkForNull(req.getParameter("patient_class"));
			function_id			= checkForNull(req.getParameter("func_id"));
			encounterid			= checkForNull(req.getParameter("encounter_id"));
			bedSideReferral_id	= checkForNull(req.getParameter("referral_id"));
			BedSideDate			= checkForNull(req.getParameter("BedSideDate"));
			//for_ip_adm_status	= checkForNull(req.getParameter("for_admission"));
			if(call_function.equals("for_admission")){
				for_ip_adm_status="1";
			}
			if(!BedSideDate.equals("")){
				BedSideDate=DateUtils.convertDate(BedSideDate,"DMY",locale,"en");
			}
            //Added for this CRF HSA-CRF-146.1
			bedside_ref_review_status = checkForNull(req.getParameter("bedside_ref_review_status"));
			allow_muti_bedside_review_yn = checkForNull(req.getParameter("allow_muti_bedside_review_yn"),"N");
			
			if(Transaction_type.equals("DA"))
			{
				status = "D";
			}
			else if(Transaction_type.equals("DP"))
			{
				status = "O";
			}
			else if(Transaction_type.equals("CO"))
			{
				status = "O";
			}
	
			referral_idS	= checkForNull(req.getParameter("referral_idS"));

			StringTokenizer tokens = new StringTokenizer (referral_idS,"/") ;
			int len = tokens.countTokens();
			
			

			if(len !=0 )
			{
				for( int i=1;i<=len;i++ )
				{
					RefIDs =  RefIDs + "'"+tokens.nextToken()+"'" ;
					if(i != len)
						RefIDs = RefIDs + "," ;
				}
			}
			
			
			/*Below line Added for this CRF Bru-HIMS-CRF-261*/
			  quick_admission=checkForNull(req.getParameter("quick_admission"));
			  bedcode=checkForNull(req.getParameter("Bedcode"));
			  bedtype=checkForNull(req.getParameter("bed_type"));
			  visitadmtype=checkForNull(req.getParameter("visit_adm_type"));
			  
			 if(quick_admission.equals("on")){
			   quick_admission="Y";
			 }else{
			   quick_admission="N";
             }			
			
			//End CRF Bru-HIMS-CRF-261
			

			patient_id				= checkForNull(req.getParameter("patient_id"));
			hdd_discharge_indicator	=
					checkForNull(req.getParameter("hdd_discharge_indicator"));
			from_facility_id		= checkForNull(req.getParameter("from_facility_id"));
			from_encounter_id		= checkForNull(req.getParameter("from_encounter_id"));
			from_hcare_setting_type	= 
					checkForNull(req.getParameter("from_hcare_setting_type"));
			from_locn_type			= checkForNull(req.getParameter("from_locn_type"));
			from_locn_code			= checkForNull(req.getParameter("from_locn_code"));
			from_locn_desc			= checkForNull(req.getParameter("from_locn_desc"));
			from_ref_type			= checkForNull(req.getParameter("from_ref_type"));
			from_pract_id			= checkForNull(req.getParameter("from_pract_id"));
			from_pract_name			= checkForNull(req.getParameter("from_pract_name"));
			from_service_code		= checkForNull(req.getParameter("from_service_code"));
			transfer_case_yn		= checkForNull(req.getParameter("transfer_case_yn"),"N"); //Added by Afruddin for ML-MMOH-CRF-1527 US3 on 23.07.2020
            
			from_speciality_code	= 
					checkForNull(req.getParameter("from_speciality_code"));

			to_hcare_setting_type	=	
					checkForNull(req.getParameter("hcare_setting_type"));
			to_ref_code				=	checkForNull(req.getParameter("referred_to"));
			to_ref_type				=	checkForNull(req.getParameter("referral_type"));
			if(to_ref_type.equals("L") || to_ref_type.equals("E"))
				to_ref_code = "";

			to_facility_id			=	checkForNull(req.getParameter("referred_to"));
			if(to_ref_type.equals("X"))	to_facility_id = "";

			to_priority				=	checkForNull(req.getParameter("priority"));
			to_preferred_date		=	checkForNull(req.getParameter("preferred_date"));
			if(!locale.equals("en"))
			{ 	
				if(!to_preferred_date.equals(""))
				to_preferred_date= DateUtils.convertDate(to_preferred_date,"DMY",locale,"en");
			//	to_preferred_date= DateUtils.convertDate(to_preferred_date,"DMYHM",locale,"en");
			}	
			to_speciality_code		=	checkForNull(req.getParameter("speciality"));
			to_service_code			=	checkForNull(req.getParameter("service"));


			to_locn_type			=	checkForNull(req.getParameter("location0"));
			to_locn_code			=	checkForNull(req.getParameter("location1"));

			if(to_locn_code.equals(""))
				to_locn_desc		=	checkForNull(req.getParameter("location2"));
			else
				to_locn_desc = "";
		
		if(to_ref_type.equals("X"))
		{
		String	to_pract_name_ext		   =	checkForNull(req.getParameter("pract_name"));
			to_pract_id				   =	checkForNull(req.getParameter("practitioner"));
		String	from_ext_practitioner_id   =	checkForNull(req.getParameter("from_ext_practitioner_id"));

			if(to_pract_name_ext.equals(""))
			{
				   to_pract_name=from_ext_practitioner_id; 
				   to_pract_id="";
				   regtrd_yn="N"; 
			 }
			else 
			{
				   regtrd_yn="Y"; 
			       to_pract_name="";
			}

		}
		else
		{
			to_pract_id				=	checkForNull(req.getParameter("practitioner"));
			to_pract_name = "";
		//	to_pract_name			=	checkForNull(req.getParameter("pract_name"));
		}


			ref_for_ip				=	checkForNull(req.getParameter("ref_for_ip"));
			ref_notes				=	checkForNull(req.getParameter("ReferralNotes"));
			referral_reason_code	=	checkForNull(req.getParameter("referral_reason_code"));
		
			ca_ref_letter_notes_rec_yn =checkForNull(req.getParameter("CA_REF_LETTER_NOTES_REC_YN"),"N");//Added by Rameswar on 30-Jan-16 for ML-MMOH-CRF-0362

		
			
			mode					=	checkForNull(req.getParameter("mode"));
			String practid	= checkForNull(req.getParameter("practid"));


			addedById				= p.getProperty("login_user");
			modifiedById			= addedById ;
			addedFacilityId			= facilityId;
			modifiedFacilityId		= addedFacilityId;
			addedAtWorkstation		= client_ip_address;
			modifiedAtWorkstation	= addedAtWorkstation;

				
			if(function_id.equals("PRACT_FOR_BEDSIDE_REFERRAL"))
			{


				try
				{

					stmt	= con.createStatement();
					int cnt	= stmt.executeUpdate("update PR_REFERRAL_REGISTER set to_pract_id = '"+practid+"' , modified_by_id = '"+addedById+"', modified_date = sysdate, modified_at_ws_no = '"+addedAtWorkstation+"', modified_facility_id = '"+facilityId+"' where added_facility_id = '"+facilityId+"' and bedside_referral_yn = 'Y' and referral_id = '"+bedSideReferral_id+"'");
						
					
					if(cnt > 0)
					{
						con.commit();
						java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED","SM");
						String error = (String) message.get("message");
						out.println("alert(\""+error+"\");");
						out.println("window.close();");
						message.clear();
					}
					else
					{
						con.rollback();
						out.println("alert('Error in PR_REFERRAL_REGISTER update');");
					}

					if(stmt!=null) stmt.close();
				}catch(Exception e)
				{

				}
			}
			else if(call_function.equals("ReferralPatientDetails"))
			{
				from_ref_type			= "L";

				if(isBedSideReferralApplforAE && patient_class.equals("EM")){
					from_locn_type			= "C";
				}else{
					from_locn_type			= "N";
				}
				

				
				called_from				= checkForNull(req.getParameter("called_from"));
				from_facility_id		= checkForNull(req.getParameter("facilityId"));
				from_hcare_setting_type	= 			
							checkForNull(req.getParameter("from_hcare_setting_type_code"));
				from_locn_code			= 
					checkForNull(req.getParameter("nursingunitcode"));
				from_locn_desc			= checkForNull(req.getParameter("nursing_unit_short_desc"));


				//from_pract_id			=checkForNull(req.getParameter("practitioner_id"));
				
				/*Above line commented and Below line Added for this CRF Bru-HIMS-CRF-354 [IN:038538]*/
				bedside_referral_yn		= checkForNull(req.getParameter("Bedside"));
				
				if(bedside_referral_yn.equals("Y"))
				from_pract_id			=checkForNull(req.getParameter("frm_practitioner"));
				else
				from_pract_id			=checkForNull(req.getParameter("practitioner_id"));
				
				
				
				//End this CRF Bru-HIMS-CRF-354 [IN:038538]				
				
				
				from_encounter_id		= checkForNull(req.getParameter("encounter_id"));
				to_locn_desc			= checkForNull(req.getParameter("location2"));
			//	to_pract_name			= checkForNull(req.getParameter("practitioner1"));
//				bedside_referral_yn		= checkForNull(req.getParameter("Bedside"),"N");



				insertReferralDetails(req,res);
			}
			else if(call_function.equals("BedSideReferral"))
			{
				
				updateBedSideReferralDetails(req);
			}
			else if(mode.equals("update"))
			{
				updateReferralDetails();

			}
			/* added by lakshmanan for ML-MMOH-CRF-1972 on 20-07-2023 start */
			else if(mode.equals("modify")){
				System.err.println("460 in RegisterReferralsServlet.java Modify referral");
				modifyReferralDetails(req,res);
			}
			/* added by lakshmanan for ML-MMOH-CRF-1972 on 20-07-2023 end */
			else
			{
				insertReferralDetails(req,res);
			}
			out.println("} callRegisterReferralsServletHtml ();</script></body></html>");			
		}catch(Exception e)
		{
			e.printStackTrace() ;
			
		}
		finally
		{
			if(con != null)	ConnectionManager.returnConnection(con,req);
		}
	}


	private void updateBedSideReferralDetails(HttpServletRequest req)
	{
	    
		//Statement stmt = null;
		int count = 0;
		boolean result = false;
        		
		//Added fro this CRF ML-MMOH-CRF-0566
		boolean bedsideReferral;
		String referral_reason_code="";
		//End this CRF ML-MMOH-CRF-0566
		
		//Added for this CRF HSA-CRF-146.1 	
		String ref_status="C";  
        try
		{   		
		if(allow_muti_bedside_review_yn.equals("Y") && bedside_ref_review_status.equals("C")) ref_status="C";
		if(allow_muti_bedside_review_yn.equals("Y") && bedside_ref_review_status.equals("P")) ref_status="O";
		if(allow_muti_bedside_review_yn.equals("Y") && bedside_ref_review_status.equals("N")) ref_status="C";
		
		//Below line added for this CRF ML-MMOH-CRF-0566
		 bedsideReferral = eCommon.Common.CommonBean.isSiteSpecific(con, "IP", "RECNL_REFERRAL_REGISTER");
		 if(bedsideReferral && bedside_ref_review_status.equals("X")) ref_status="X";
		 //if(bedsideReferral && bedside_ref_review_status.equals("N")) ref_status="C";
		 if(bedsideReferral && bedside_ref_review_status.equals("S")) ref_status="C";
		 
		 referral_reason_code=req.getParameter("referral_reg_id");
		 if(referral_reason_code==null) referral_reason_code="";
		//End this CRF ML-MMOH-CRF-0566	
		
		if(allow_muti_bedside_review_yn.equals("N")) bedside_ref_review_status="";
				
			StringBuffer sqlBuffer = new StringBuffer(); //Below line modified for this CRF  HSA-CRF-146.1 
			sqlBuffer.append("update PR_REFERRAL_REGISTER set status = '"+ref_status+"', referred_in_func = 5, BEDSIDE_REF_SEEN_DATE = to_date('"+BedSideDate+"','dd/mm/rrrr hh24:mi'), bedside_ref_review_status='"+bedside_ref_review_status+"', modified_by_id = '"+addedById+"', ");
			sqlBuffer.append(" modified_date = sysdate, modified_at_ws_no = '"+addedAtWorkstation+"',"); 
			sqlBuffer.append(" modified_facility_id = '"+facilityId+"',cancel_reject_reason_code='"+referral_reason_code+"', cancel_reject_date_time=sysdate  where ADDED_FACILITY_ID = '"+facilityId+"' and "); 
			sqlBuffer.append(" FROM_ENCOUNTER_ID= '"+encounterid+"' and BEDSIDE_REFERRAL_YN	= 'Y' and REFERRAL_ID='"+bedSideReferral_id+"' ");
			
			//Above line modified for this CRF ML-MMOH-CRF-0566

			stmt	= con.createStatement();
			count	= stmt.executeUpdate(sqlBuffer.toString());
	
	
			if(sqlBuffer.length() > 0)  sqlBuffer.delete(0,sqlBuffer.length());

			if(count>0)
				result=true;
			else
				result=false;
		
			if(stmt!=null) stmt.close();
		}catch(Exception e)
		{
			try
			{
				con.rollback();
			}catch(Exception exx){
			
			exx.printStackTrace() ;
			
			}
			result=false;
			e.printStackTrace() ;
		}

		if(result)
		{
			java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED","SM");
			String error = (String) message.get("message");
			//error= error.substring(0,error.indexOf("<br>"));
			out.println("alert(\""+error+"\");");	
			out.println("window.returnValue='Success';");
			out.println("window.close();");  			
			
			message.clear();
				
			try
			{
				con.commit();
			}catch(Exception ex){
				ex.printStackTrace() ;
			
			}
		}
		else
		{
			out.println("alert('Transaction Failed...')");
			out.println("window.close();");
			try
			{
				con.rollback();
			}catch(Exception exx){
				exx.printStackTrace() ;
			
			}
		}
	}/// End.of Else bed side


	private void updateReferralDetails()
	{ 
	 
	 
	
		PreparedStatement update_ref_stmt	= null;
		int update_ref		= 0;
        
				
		try
		{  
			if(Transaction_type.equals("DP") && !RefIDs.equals("") && allow_muti_bedside_review_yn.equals("N"))
			{
			   /*Added the audit column*/
				String update_ref_sql = " UPDATE PR_REFERRAL_REGISTER SET status = 'O' , modified_by_id = '"+modifiedById+"', modified_date = sysdate, modified_at_ws_no = '"+modifiedAtWorkstation+"', modified_facility_id = '"+modifiedFacilityId+"' WHERE ADDED_FACILITY_ID = '"+facilityId+"' AND from_encounter_id = '"+from_encounter_id+"' AND referral_id IN ("+RefIDs+")";
                
				
				
				update_ref_stmt	= con.prepareStatement(update_ref_sql);
				update_ref		= update_ref_stmt.executeUpdate();
                				
	
				if(update_ref>0)
					con.commit();
					
				else
					con.rollback();
			}
			if(update_ref_stmt !=null) update_ref_stmt.close();
			
		}catch ( Exception exp )
		{
			exp.printStackTrace() ;
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+exp.toString());
		}
		
	}

	private void insertReferralDetails(HttpServletRequest req, HttpServletResponse res)
	{  
	
	
	
		String error ="";
		boolean insertable=false;
		String errormsg="";
		CallableStatement cstmt=null;
		try
		{
			/*
			alternate_Ref_id="select to_char(sysdate,'yyyy') from dual";
			pstmt1	= con.prepareStatement(alternate_Ref_id);
			rs1	= pstmt1.executeQuery();
			if(rs1 !=null)
			{
				if(rs1.next())
				{
					current_year =	rs1.getString(1);
				}
			}
			if(rs1 !=null) rs1.close();
			if(pstmt1 !=null) pstmt1.close();
			*/
			try
			{
			cstmt=con.prepareCall("{call PR_GENERATE_REFERRAL_ID(?,to_char(sysdate,'yyyy'),?,?,?,?)}");
			cstmt.setString(1,facilityId);
		//	cstmt.setString(2,current_year);
			cstmt.setString(2,addedById);
			cstmt.setString(3,addedAtWorkstation);
			cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
			cstmt.execute();
			errormsg=cstmt.getString(5);
			if(errormsg ==null) errormsg="";
			
			if(errormsg.equals(""))
				{
					referral_id=cstmt.getString(4);
					insertable = true ;
								
				}else
				{
					insertable = false ;
					
				}
				
			if(cstmt != null) cstmt.close();

			}catch(Exception e)
			{
				insertable = false ;
				e.printStackTrace();
			}

		/*
			String dupflag="N";
			
			if(insertable)
			{
				String dupsql="select * from pr_referral_register where from_facility_id='"+from_facility_id+"' and referral_id = '"+referral_id+"'";
				
				pstmt=con.prepareStatement(dupsql);
				rs=pstmt.executeQuery();
				if(!rs.next())
				{
					inserted = InsertRecords(req);
				}
				else
				{
					dupflag="Y";
					inserted =false;
				}
			}
		*/
			if(insertable)
				inserted = InsertRecords(req,res);
			
			String updateprenc="";
			String updateoppatq="";
		
			if(inserted)
			{	
            	if(insertable)
				{
				 	try
					{
						int prencnt=0;
						/*Added audit column in the below query*/
						updateprenc="update PR_ENCOUNTER set DISP_REFERRAL_ID='"+referral_id+"', DISP_FACILITY_ID='"+facilityId+"',modified_by_id='"+modifiedById+"',modified_date=sysdate,modified_at_ws_no='"+modifiedAtWorkstation+"',modified_facility_id='"+modifiedFacilityId+"'  where encounter_id='"+from_encounter_id+"' and FACILITY_ID='"+facilityId+"'";
						pstmt=con.prepareStatement(updateprenc);
						prencnt=pstmt.executeUpdate();
						if(prencnt > 0)
							insertable=true;
						else
							insertable=false;
						if(pstmt !=null) pstmt.close();
					}catch(Exception e)
					{
						insertable=false;
						e.printStackTrace() ;
						
					}
				}
					
				if(Transaction_type.equals("CO"))
				{
					if(insertable)
					{
						try
						{
							int oppatcnt=0;
							/*Added Audit column in the below query*/							
							updateoppatq="update OP_PATIENT_QUEUE set DISP_REFERRAL_ID='"+referral_id+"',DISP_FACILITY_ID='"+facilityId+"',modified_by_id='"+modifiedById+"',modified_date = sysdate,modified_at_ws_no='"+modifiedAtWorkstation+"',modified_facility_id='"+modifiedFacilityId+"' where encounter_id='"+from_encounter_id+"' and facility_id='"+facilityId+"'";
							pstmt=con.prepareStatement(updateoppatq);
							oppatcnt=pstmt.executeUpdate();
							if(oppatcnt > 0)
								insertable=true;
							else
								insertable=false;
							if(pstmt !=null) pstmt.close();
						}catch(Exception e)
						{
							insertable=false;
							e.printStackTrace() ;
							
						}
					}
				}
			
				
				if(insertable)
				{
					con.commit();
					java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_MODIFIED","SM" ) ;
					error = (String) message.get("message") ;
				//	error= error.substring(0,error.indexOf("<br>")) ;
					out.println("alert(\""+error+"\");") ;
					
					message.clear();

				if(call_function.equals("ReferralPatientDetails"))
				{
					if(!called_from.equals("CA"))
					{
						Hashtable  continue_message = MessageManager.getMessage( locale,"CONTINUE_REFERRAL","Common");
						error = (String) continue_message.get("message");
						continue_message.clear();
						//error= error.substring(0,error.indexOf("<br>"));
						
						out.print("var truthBeTold = window.confirm(\""+error+"\");");	
						out.print("if(!truthBeTold)parent.window.close();");
					}

					if(called_from.equals("CA"))
					{
						out.print("if(parent.frames[1].document.RefPatientDtls_form && parent.frames[1].document.RefPatientDtls_form.Bedside) { parent.frames[1].document.RefPatientDtls_form.Bedside.checked=true;parent.frames[1].setVal();parent.frames[1].document.RefPatientDtls_form.Bedside.disabled=true; parent.frames[1].document.RefPatientDtls_form.CA_REF_LETTER_NOTES_REC_YN.value='N';parent.frames[1].document.RefPatientDtls_form.temp_field.value='N';} ");/*Modified by Rameswar for ML-MMOH-CRF-0362*/
					}
					else
					{
						/*Modified By Dharma on 18th Feb 2016 against ML-MMOH-CRF-0340 [IN057178] Start*/
						
						//out.print("<script>if(parent.frames[1].document.RefPatientDtls_form && parent.frames[1].document.RefPatientDtls_form.Bedside) { parent.frames[1].document.RefPatientDtls_form.Bedside.checked=false;parent.frames[1].document.RefPatientDtls_form.Bedside.onclick();}</script>");
						out.print("if(parent.frames[1].document.RefPatientDtls_form){parent.frames[1].location.href=parent.frames[1].location.href;}");
						/*Modified By Dharma on 18th Feb 2016 against ML-MMOH-CRF-0340 [IN057178] End*/

					}

					
			

				}else if(call_function.equals("RegPatRefFromAEAssessment")){
					/*This Else if part added for For AAKH-CRF-0010 [IN:038535] by Dharma on Mar 11th 2014*/
						out.print("parent.window.close();");
				}else{	

					if(hdd_discharge_indicator.equals("ED"))
					{
						out.print("parent.frames[1].document.forms[0].referral_type.value = 'X';parent.frames[1].popExternal(parent.frames[1].document.forms[0].referral_type);");
					}
					out.print("if(top.frames['dialog-body']){iFramePath=top.frames['dialog-body'];}iFramePath.frames[1].document.getElementById('clear').onclick();");
					out.print("iFramePath.frames[2].location.href = '../eMP/jsp/ReferralDetailsResult.jsp?encounter_id="+from_encounter_id+"&patient_id="+patient_id+"&Transaction_type="+Transaction_type+" ';");	
					out.print("if(iFramePath.frames[1].document.forms[0].close){iFramePath.frames[1].document.forms[0].close.disabled = false;}");
					
					
			/*Below line Added for this CRF Bru-HIMS-CRF-261 */
		
			if(insertable && quick_admission.equals("Y")){ 
			
			/*Below line Added for this incident[41098]*/
			String admission_type="";
			try
					{						
						String ip_paracheck="select allowed_admission_type from ip_param where facility_id ='"+facilityId+"'";
						pstmt=con.prepareStatement(ip_paracheck);
						rs2=pstmt.executeQuery();
						if(rs2.next()){
							admission_type=checkForNull(rs2.getString("allowed_admission_type"));
						}
						
						if(pstmt !=null) pstmt.close(); if(rs2 !=null) rs2.close(); 
					}catch(Exception e)
					{
						
						e.printStackTrace() ;
						
					}
                //End this incident[41098] 
              			
			    out.println("parent.frames[2].view_admitpatient('"+referral_id+"','"+from_encounter_id+"','"+admission_type+"');");
		   	}else{	
			
				out.print("iFramePath.frames[1].location.href= iFramePath.frames[1].location.href;");/*Added By Dharma on 18th Feb 2016 against ML-MMOH-CRF-0340 [IN057178]*/
			}
					
				}
				
				}
				else
				{
					
					con.rollback();
					error = "Errors Encountered..";
					//error= error.substring(0,error.indexOf("<br>")) ;
					out.println("alert(\""+error+"\");parent.window.close();") ;
				}
			}
			else
			{
				/*
				if(dupflag.equals("Y"))
				{
					java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_EXISTS","SM" ) ;
					error = (String) message.get("message") ;
					//error= error.substring(0,error.indexOf("<br>")) ;
					
					out.println("<script>alert(\""+error+"\");parent.window.close()</script>") ;
				}else
				{
					*/
				error = "Errors Encountered..";
				//error= error.substring(0,error.indexOf("<br>")) ;
				out.println("alert(\""+error+"\");parent.window.close();") ;
				//}
			}
				

		}catch ( Exception e )
		{
			e.printStackTrace() ;
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}
	}

	public boolean InsertRecords(HttpServletRequest req,HttpServletResponse res)
	{
		String bedside_referral_yn = checkForNull(req.getParameter("Bedside"),"N");
	    
		

		Pat_Sql.setLength(0);
		try
		{
		
		   	/*Below Query Modified  by venkatesh.s against MMS-SCF-0310 [IN:047602]  on 13-Mar-2014*/
			Pat_Sql.append(" SELECT to_char(alt_id1_exp_date,'dd/mm/yyyy') alt_id1_exp_date, alt_id1_no, alt_id1_type, to_char(alt_id2_exp_date,'dd/mm/yyyy') alt_id2_exp_date,alt_id2_no, alt_id2_type, to_char(alt_id3_exp_date,'dd/mm/yyyy') alt_id3_exp_date, alt_id3_no, alt_id3_type, to_char(alt_id4_exp_date,'dd/mm/yyyy')"); Pat_Sql.append("alt_id4_exp_date, alt_id4_no, alt_id4_type, birth_place_code, citizen_yn, to_char(date_of_birth,'dd/mm/yyyy') date_of_birth, email_id,ethnic_grp_code, race_code, family_name, first_name, legal_yn, name_prefix, name_suffix, national_id_no, nationality_code, oth_alt_id_no,oth_alt_id_type, patient_name, place_of_birth, res_area_code, res_town_code, res_town_desc, second_name, sex, third_name   , name_prefix_loc_lang ,first_name_loc_lang  ,second_name_loc_lang ,third_name_loc_lang ,family_name_loc_lang  , name_suffix_loc_lang ,patient_name_loc_lang ,b.ADDR1_TYPE,b.addr1_line1,b.addr1_line2,b.addr1_line3, b.addr1_line4,b.postal1_code,b.country1_code,a.res_area_code,a.res_town_code,a.region_code,b.addr2_line1,b.addr2_line2, b.addr2_line3,b.addr2_line4,b.res_area2_code,b.res_town2_code,b.region2_code,a.contact1_no, a.contact2_no, a.email_id,b.country2_code,b.postal2_code FROM  mp_patient a , mp_pat_addresses b where  b.patient_id = a.PATIENT_ID AND a.patient_id = '"+patient_id+"' ");
			
			
			pstmt	= con.prepareStatement(Pat_Sql.toString());
			rs	= pstmt.executeQuery();
			if(rs !=null && rs.next())
			{
				date_of_birth	=	checkForNull(rs.getString("date_of_birth"));
				email_id		=	checkForNull(rs.getString("email_id"));
				name_prefix		=	checkForNull(rs.getString("name_prefix"));
				family_name		=	checkForNull(rs.getString("family_name"));
				name_suffix		=	checkForNull(rs.getString("name_suffix"));
				first_name		=	checkForNull(rs.getString("first_name"));
				second_name		=	checkForNull(rs.getString("second_name"));
				third_name		=	checkForNull(rs.getString("third_name"));
				national_id_no	=	checkForNull(rs.getString("national_id_no"));
				nationality_code=	checkForNull(rs.getString("nationality_code"));
				oth_alt_id_no	=	checkForNull(rs.getString("oth_alt_id_no"));
				oth_alt_id_type	=	checkForNull(rs.getString("oth_alt_id_type"));
				alt_id1_no		=	checkForNull(rs.getString("alt_id1_no"));
				alt_id2_no		=	checkForNull(rs.getString("alt_id2_no"));
				alt_id3_no		=	checkForNull(rs.getString("alt_id3_no"));
				alt_id4_no		=	checkForNull(rs.getString("alt_id4_no"));	
				alt_id1_exp_date=	checkForNull(rs.getString("alt_id1_exp_date")); 
				alt_id1_type	=	checkForNull(rs.getString("alt_id1_type"));  
				alt_id2_exp_date=	checkForNull(rs.getString("alt_id2_exp_date"));
				alt_id2_type	=	checkForNull(rs.getString("alt_id2_type")); 
				alt_id3_exp_date=	checkForNull(rs.getString("alt_id3_exp_date"));
				alt_id3_type	=	checkForNull(rs.getString("alt_id3_type"));  
				alt_id4_exp_date=	checkForNull(rs.getString("alt_id4_exp_date"));
				alt_id4_type	=	checkForNull(rs.getString("alt_id4_type")); 
				birth_place_code=	checkForNull(rs.getString("birth_place_code"));
				citizen_yn		=	checkForNull(rs.getString("citizen_yn"));  
				ethnic_grp_code	=	checkForNull(rs.getString("ethnic_grp_code")); 
				race_code		=	checkForNull(rs.getString("race_code")); 
				legal_yn		=	checkForNull(rs.getString("legal_yn")); 
				patient_name	=	checkForNull(rs.getString("patient_name")); 
				
				res_area_code	=	checkForNull(rs.getString("res_area_code")); 
				res_town_code	=	checkForNull(rs.getString("res_town_code"));
				gender			=	checkForNull(rs.getString("sex"));

				name_prefix_loc_lang			=	checkForNull(rs.getString("name_prefix_loc_lang"));
				first_name_loc_lang			=	checkForNull(rs.getString("first_name_loc_lang"));
				second_name_loc_lang			=	checkForNull(rs.getString("second_name_loc_lang"));
				third_name_loc_lang			=	checkForNull(rs.getString("third_name_loc_lang"));
				family_name_loc_lang			=	checkForNull(rs.getString("family_name_loc_lang"));
				name_suffix_loc_lang			=	checkForNull(rs.getString("name_suffix_loc_lang"));
				patient_name_loc_lang			=	checkForNull(rs.getString("patient_name_loc_lang"));
				
				  addr_line1                    =	checkForNull(rs.getString("addr1_line1")); 
				  addr_line2                    =	checkForNull(rs.getString("addr1_line2")); 
				  addr_line3                    =	checkForNull(rs.getString("addr1_line3")); 
				  addr_line4					=	checkForNull(rs.getString("addr1_line4")); 
				  postal_code					=	checkForNull(rs.getString("postal1_code")); 
				  country_code					=	checkForNull(rs.getString("country1_code")); 
				  region_code					=	checkForNull(rs.getString("region_code")); 
				  contact1_no					=	checkForNull(rs.getString("contact1_no")); 
				  contact2_no					=	checkForNull(rs.getString("contact2_no")); 
				  mail_addr_line1				=	checkForNull(rs.getString("addr2_line1")); 
				  mail_addr_line2				=	checkForNull(rs.getString("addr2_line2")); 
				  mail_addr_line3				=	checkForNull(rs.getString("addr2_line3")); 
				  mail_addr_line4				=	checkForNull(rs.getString("addr2_line4")); 
				  mail_res_town_code			=	checkForNull(rs.getString("res_town2_code"));
				  
				  mail_res_area_code			=	checkForNull(rs.getString("res_area2_code")); 
				  mail_country_code			=	checkForNull(rs.getString("country2_code")); 
				  mail_postal_code			=	checkForNull(rs.getString("postal2_code")); 
				  mail_region_code			=	checkForNull(rs.getString("region2_code"));

				
			}
			Pat_Sql.setLength(0);
			if(rs !=null) rs.close(); if(pstmt !=null) pstmt.close();
			int r=0;
			
				Pat_Sql.append("insert into pr_referral_register (REFERRAL_ID, STATUS, BEDSIDE_REFERRAL_YN, date_of_birth, ALT_ID1_DATE, ALT_ID2_DATE,");
				Pat_Sql.append("ALT_ID3_DATE,ALT_ID4_DATE,ALT_ID1_TYPE,ALT_ID2_TYPE,ALT_ID3_TYPE,ALT_ID4_TYPE,BIRTH_PLACE_CODE,ETHNIC_GRP_CODE,RACE_CODE,RES_AREA_CODE,RES_TOWN_CODE,EMAIL_ID,NAME_PREFIX,FAMILY_NAME,NAME_SUFFIX,FIRST_NAME,SECOND_NAME,THIRD_NAME,NATIONAL_ID_NO,NATIONALITY_CODE,OTH_ALT_ID_NO,OTH_ALT_ID_TYPE,ALT_ID1_NO,ALT_ID2_NO,ALT_ID3_NO,ALT_ID4_NO,PATIENT_ID,PATIENT_NAME,CITIZEN_YN,LEGAL_ILLEGAL_YN,SEX,FROM_FACILITY_ID,FROM_ENCOUNTER_ID,FROM_HCARE_SETTING_TYPE,FROM_REF_CODE,FROM_LOCN_TYPE,FROM_LOCN_CODE,FROM_LOCN_DESC,FROM_REF_TYPE,FROM_PRACT_ID,FROM_PRACT_NAME,FROM_SERVICE_CODE,FROM_SPECIALITY_CODE,TO_FACILITY_ID,TO_REF_TYPE,TO_HCARE_SETTING_TYPE,TO_REF_CODE,REFERRAL_PRIORITY,TO_SPECIALITY_CODE,TO_SERVICE_CODE,TO_LOCN_TYPE,");	
				Pat_Sql.append("TO_LOCN_DESC,TO_LOCN_CODE,TO_PRACT_NAME,TO_PRACT_ID,REFERRED_FOR_IP,REF_NOTES,PREFERRED_TREATMENT_DATE,REFERRAL_DATE,added_by_id,added_date,added_facility_id,");
				Pat_Sql.append("added_at_ws_no,modified_by_id,modified_date,modified_facility_id,modified_at_ws_no, name_prefix_loc_lang ,first_name_loc_lang  ,second_name_loc_lang ,third_name_loc_lang ,family_name_loc_lang  , name_suffix_loc_lang ,patient_name_loc_lang,REFERRAL_REASON_CODE,assign_bed_type_code,assign_bed_class_code,visit_adm_type,quick_admission_yn,addr_line1, addr_line2, addr_line3, addr_line4, postal_code, country_code, contact1_no, contact2_no, mail_addr_line1, mail_addr_line2, mail_addr_line3, mail_addr_line4, mail_res_town_code, mail_res_area_code,mail_country_code, mail_postal_code, mail_region_code,region_code,ca_ref_letter_notes_rec_yn,transfer_case_yn,for_ip_adm_status) values(?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),sysdate,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); //Modified by Afruddin for ML-MMOH-CRF-1527 US3 on 23.07.2020
				/*Added by Rameswar on 30-Jan-16 for ML-MMOH-CRF-0362 */
				
				try
				{
					pstmt1=con.prepareStatement(Pat_Sql.toString());
					pstmt1.setString(1, referral_id);
					pstmt1.setString(2, status);
					pstmt1.setString(3, bedside_referral_yn);
					pstmt1.setString(4, date_of_birth);
					pstmt1.setString(5, alt_id1_exp_date);
					pstmt1.setString(6, alt_id2_exp_date);
					pstmt1.setString(7, alt_id3_exp_date);
					pstmt1.setString(8, alt_id4_exp_date);
					pstmt1.setString(9, alt_id1_type);
					pstmt1.setString(10, alt_id2_type);
					pstmt1.setString(11, alt_id3_type);
					pstmt1.setString(12, alt_id4_type);
					pstmt1.setString(13, birth_place_code);
					pstmt1.setString(14, ethnic_grp_code);
					pstmt1.setString(15, race_code);
					pstmt1.setString(16, res_area_code);
					pstmt1.setString(17, res_town_code);
					pstmt1.setString(18, email_id);
					pstmt1.setString(19, name_prefix);
					pstmt1.setString(20, family_name);
					pstmt1.setString(21, name_suffix);
					pstmt1.setString(22, first_name);
					pstmt1.setString(23, second_name);
					pstmt1.setString(24, third_name);
					pstmt1.setString(25, national_id_no);
					pstmt1.setString(26, nationality_code);
					pstmt1.setString(27, oth_alt_id_no);
					pstmt1.setString(28, oth_alt_id_type);
					pstmt1.setString(29, alt_id1_no);
					pstmt1.setString(30, alt_id2_no);
					pstmt1.setString(31, alt_id3_no);
					pstmt1.setString(32, alt_id4_no);
					pstmt1.setString(33, patient_id);
					pstmt1.setString(34, patient_name);
					pstmt1.setString(35, citizen_yn);
					pstmt1.setString(36, legal_yn);
					pstmt1.setString(37, gender);
					pstmt1.setString(38, from_facility_id);
					pstmt1.setString(39, from_encounter_id);
					pstmt1.setString(40, from_hcare_setting_type);
					pstmt1.setString(41, from_ref_code);
					pstmt1.setString(42, from_locn_type);
					pstmt1.setString(43, from_locn_code);
			//		from_locn_desc=checkForNull(req.getParameter("nursing_unit_short_desc"));
					pstmt1.setString(44, from_locn_desc);
		
					pstmt1.setString(45, from_ref_type);
					pstmt1.setString(46, from_pract_id);
					pstmt1.setString(47, from_pract_name);
					pstmt1.setString(48, from_service_code);
					pstmt1.setString(49, from_speciality_code);
					pstmt1.setString(50, to_facility_id);
					pstmt1.setString(51, to_ref_type);
					pstmt1.setString(52, to_hcare_setting_type);
					pstmt1.setString(53, to_ref_code);
					pstmt1.setString(54, to_priority);
					pstmt1.setString(55, to_speciality_code);
					pstmt1.setString(56, to_service_code);
					pstmt1.setString(57, to_locn_type);
					pstmt1.setString(58, to_locn_desc);
					pstmt1.setString(59, to_locn_code);
					pstmt1.setString(60, to_pract_name);
					pstmt1.setString(61, to_pract_id);
					pstmt1.setString(62, ref_for_ip);
					pstmt1.setString(63, ref_notes);
					pstmt1.setString(64, to_preferred_date);
					pstmt1.setString(65, addedById);
					pstmt1.setString(66, facilityId);
					pstmt1.setString(67, addedAtWorkstation);
					pstmt1.setString(68, modifiedById);
					pstmt1.setString(69, modifiedFacilityId);
					pstmt1.setString(70, modifiedAtWorkstation);

					pstmt1.setString(71, name_prefix_loc_lang);
					pstmt1.setString(72, first_name_loc_lang);
					pstmt1.setString(73, second_name_loc_lang);
					pstmt1.setString(74, third_name_loc_lang);
					pstmt1.setString(75, family_name_loc_lang);
					pstmt1.setString(76, name_suffix_loc_lang);
					pstmt1.setString(77, patient_name_loc_lang);
					pstmt1.setString(78, referral_reason_code);
					
					/*Below line Added for this CRF Bru-HIMS-CRF-261*/	
					pstmt1.setString(79, bedcode);
					pstmt1.setString(80, bedtype);
					pstmt1.setString(81, visitadmtype);
					pstmt1.setString(82, quick_admission);
					
					//venkat
					 
					pstmt1.setString(83, addr_line1);
					pstmt1.setString(84, addr_line2);
					pstmt1.setString(85, addr_line3);
					pstmt1.setString(86, addr_line4);
					pstmt1.setString(87, postal_code);
					pstmt1.setString(88, country_code);
					pstmt1.setString(89, contact1_no);
					pstmt1.setString(90, contact2_no);
					pstmt1.setString(91, mail_addr_line1);
					pstmt1.setString(92, mail_addr_line2);
					pstmt1.setString(93, mail_addr_line3);
					pstmt1.setString(94, mail_addr_line4);
					pstmt1.setString(95, mail_res_town_code);
					pstmt1.setString(96, mail_res_area_code);
					pstmt1.setString(97, mail_country_code);
					pstmt1.setString(98, mail_postal_code);
					pstmt1.setString(99, mail_region_code);
					pstmt1.setString(100, region_code);
					pstmt1.setString(101, ca_ref_letter_notes_rec_yn);//Added by Rameswar on 30-Jan-16 for ML-MMOH-CRF-0362 
					pstmt1.setString(102, transfer_case_yn); // Added by Afruddin for ML-MMOH-CRF-1527 US3 on 23.07.2020
					pstmt1.setString(103, for_ip_adm_status); // Added by Santhosh for ML-MMOH-CRF-1972
					
					
					//End Bru-HIMS-CRF-261

					//pstmt1.setString(79, from_locn_desc);

					

					r=pstmt1.executeUpdate();
					if(r != 0)	{
						inserted = true;
						 if(!(call_function.equals("ReferralPatientDetails")))
					    		{
					    	 doOnlineReports(req,res,referral_id,sStyle,locale,patient_id);          // HSA-CRF-0261
					    		}
						}
					else
						inserted = false;
					Pat_Sql.setLength(0);
					if(pstmt1 !=null) pstmt1.close();
					
				}catch(Exception e) 
				{
					e.printStackTrace() ;
					
					inserted = false;
				}
			
			if(rs !=null) rs.close(); if(pstmt != null) pstmt.close();
		}catch(Exception e)	
		{
			e.printStackTrace() ;
			
			inserted = false;
		}
		
		return inserted;
	}
// Added for HSA-CRF-0261
private void doOnlineReports(HttpServletRequest req,HttpServletResponse res, String refid,String sStylerep,String locale,String patientid) throws ServletException, IOException, SQLException
    {
		 PrintWriter out				= null;
		out								= res.getWriter();
		StringBuffer htmlFor	= new StringBuffer();
		htmlFor.setLength(0);
		String sqlString		= "";
		String referralid_insert= "";
		sqlString				= " select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = 'OP' AND REPORT_ID = 'OPRFLETR' AND language_id='"+locale+"'";
		String referralid		= refid;
		String p_locn_code		= req.getParameter("locn_code")==null?"":req.getParameter("locn_code");
		String locn_type		= req.getParameter("locn_type")==null?"":req.getParameter("locn_type");
		if(referralid.equals("") || referralid==null) referralid=referralid_insert;
		String p_encounter_id	= "";
		String reportParamNames = "p_referral_id";
		String reportParamValues = ""+referralid+"";
		if(patientid==null) patientid = "";
        htmlFor.append( "  var dialogHeight    = '90vh' ;");
        htmlFor.append( " var dialogWidth = '90vw' ;");
        htmlFor.append(  "var dialogTop = 15;" );
        htmlFor.append( "  var arguments =   ''; ");
        htmlFor.append( "  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&EncounterId="+p_encounter_id+"&dest_locn_type="+locn_type+"&dest_locn_code="+p_locn_code+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&Patient_ID="+patientid+"';");
        htmlFor.append( " var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
        htmlFor.append(" var iFramePath = parent.frames[2].name=='f_query_add_mod'?parent.frames[2]:parent;");
        htmlFor.append(" if(top.frames['dialog-body'] && top.frames['dialog-body'].frames['dialog-body']){");
        htmlFor.append("  retVal            =   await top.frames['dialog-body'].frames['dialog-body'].Referral_Detail_frame.showModalDialog(getUrl,arguments,features); ");
        htmlFor.append(" iFramePath  = top.frames['dialog-body'].frames['dialog-body']?top.frames['dialog-body'].frames['dialog-body']:top.frames['dialog-body'] ;");
        htmlFor.append(" }else{");
        htmlFor.append("  retVal            =   await top.window.showModalDialog(getUrl,arguments,features);  ");
        htmlFor.append(" }");
        out.println(htmlFor.toString());
		htmlFor.setLength(0);
	}
/* added by lakshmanan for ML-MMOH-CRF-1972 on 20-07-2023 start */
private void modifyReferralDetails(HttpServletRequest req, HttpServletResponse res)
{ 
	PreparedStatement update_ref_stmt	= null;
	int update_ref1		= 0;
	try
	{  
			String referral_id		= req.getParameter("referral_id")==null?"":req.getParameter("referral_id");
			String to_ref_type		= req.getParameter("referral_type")==null?"":req.getParameter("referral_type");
			String to_hcare_setting_type		= req.getParameter("hcare_setting_type")==null?"":req.getParameter("hcare_setting_type");
			String transfer_case_yn		= req.getParameter("transfer_case_yn")==null?"":req.getParameter("transfer_case_yn");
			String to_ref_code		= req.getParameter("referred_to")==null?"":req.getParameter("referred_to");
			String to_facility_id		= req.getParameter("referred_to")==null?"":req.getParameter("referred_to");
			String to_speciality_code		= req.getParameter("speciality")==null?"":req.getParameter("speciality");
			String to_locn_type		= req.getParameter("location0")==null?"":req.getParameter("location0");
			String to_locn_code		= req.getParameter("location1")==null?"":req.getParameter("location1");
			String to_service_code		= req.getParameter("service")==null?"":req.getParameter("service");
			String referred_for_ip		= req.getParameter("ref_for_ip")==null?"":req.getParameter("ref_for_ip");
			String preferred_treatment_date		= req.getParameter("preferred_date")==null?"":req.getParameter("preferred_date");
			String referral_reason_code		= req.getParameter("referral_reason_code")==null?"":req.getParameter("referral_reason_code");
			String referral_priority		= req.getParameter("priority")==null?"":req.getParameter("priority");
			if(to_ref_type.equals("L") || to_ref_type.equals("E"))
				to_ref_code = "";	
			String to_pract_name="";
			String to_pract_id	="";
			String to_locn_desc="";
			if(to_locn_code.equals(""))
				to_locn_desc		=	checkForNull(req.getParameter("location2"));
			else
				to_locn_desc = "";
			if(to_ref_type.equals("X"))
			{
				to_facility_id="";
			String	to_pract_name_ext		   =	checkForNull(req.getParameter("pract_name"));
			to_pract_id				   =	checkForNull(req.getParameter("practitioner"));
			String	from_ext_practitioner_id   =	checkForNull(req.getParameter("from_ext_practitioner_id"));

				if(to_pract_name_ext.equals(""))
				{
					   to_pract_name=from_ext_practitioner_id; 
					   to_pract_id="";
				 }
				else 
				{
				       to_pract_name="";
				}

			}
			else
			{
				to_pract_id				=	checkForNull(req.getParameter("practitioner"));
				to_pract_name = "";
			}
			
			
			
			
			String update_ref_sql1 = " UPDATE PR_REFERRAL_REGISTER SET status = 'O' , modified_by_id = ?, modified_date = sysdate, modified_at_ws_no = ? , modified_facility_id = ?, to_ref_type=?, to_hcare_setting_type=? ,transfer_case_yn=? ,  to_facility_id=? ,  to_ref_code=? ,to_speciality_code=? , to_locn_type=?, to_locn_code=? ,to_locn_desc=?, to_service_code=? ,to_pract_name=?, to_pract_id=? , referred_for_ip=? , preferred_treatment_date=to_date(?,'dd/mm/yyyy') , referral_reason_code=? , referral_priority=? , for_ip_adm_status='2' WHERE ADDED_FACILITY_ID = ? AND from_encounter_id = ? AND referral_id=? ";
      			
			update_ref_stmt	= con.prepareStatement(update_ref_sql1);
			update_ref_stmt.setString(1,modifiedById);
			update_ref_stmt.setString(2,modifiedAtWorkstation);
			update_ref_stmt.setString(3,modifiedFacilityId );
			update_ref_stmt.setString(4,to_ref_type);
			update_ref_stmt.setString(5,to_hcare_setting_type);
			update_ref_stmt.setString(6,transfer_case_yn);
			update_ref_stmt.setString(7,to_facility_id);
			update_ref_stmt.setString(8,to_ref_code);
			update_ref_stmt.setString(9,to_speciality_code);
			update_ref_stmt.setString(10,to_locn_type);
			update_ref_stmt.setString(11,to_locn_code);
			update_ref_stmt.setString(12,to_locn_desc);
			update_ref_stmt.setString(13,to_service_code);
			update_ref_stmt.setString(14,to_pract_name);
			update_ref_stmt.setString(15,to_pract_id);
			update_ref_stmt.setString(16,referred_for_ip);
			update_ref_stmt.setString(17,preferred_treatment_date);
			update_ref_stmt.setString(18,referral_reason_code);
			update_ref_stmt.setString(19,referral_priority);
			update_ref_stmt.setString(20,facilityId );
			update_ref_stmt.setString(21,from_encounter_id);
			update_ref_stmt.setString(22,referral_id);			
			update_ref1		= update_ref_stmt.executeUpdate();	
			System.err.println("in RegisterReferralsServlet.java update_ref1=="+update_ref1);
			if(update_ref1>0) {
				con.commit();
			}
			else
				con.rollback();
		
		if(update_ref_stmt !=null) update_ref_stmt.close();
		
		
	}catch ( Exception exp )
	{
		exp.printStackTrace() ;
	}
}
/* added by lakshmanan for ML-MMOH-CRF-1972 on 20-07-2023 end */
//End
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}// E.O class RegisterReferralsServlet method




