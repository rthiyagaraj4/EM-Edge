/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;
import eMR.RecDiagnosis.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public class RecDiagnosisServlet extends javax.servlet.http.HttpServlet	
{

	PrintWriter out;
	Properties p;
	String mode						= "";
	String stage_code				= "";
	String old_onset_type			= "";
	String cause_of_death_yn		= "N";
	String code_set					= "";	String diagprob_code			= "";	
	String x_facility_id			= "";	String diag_Description			= "";
	String client_ip_address		= "";	String nature					= "";
	String priority					= "";	String severity					= "";
	String onset_date				= "";	String type						= "";
	String status					= "";	String status_date				= "";
	String reason					= "";	String remarks					= "";
	String Practitioner_Id			= "";	String relationship_id			= ""; 
	String Locn_Code				= "";	String Locn_Type				= "";
	String Patient_Id				= "";	String Encounter_Id				= "";
	String accry_code				= "";	String accry_code_ind			= "";
	String priority_appl_yn			= "";	String patient_class			= "";
	String sex						= "";	String diff_group_id_hid		= "";
	String associate_codes			= "";	String dob						= "";
	String occur_srl_no_hid			= "";		
	String associate_codes_modify	= "";	String code_indicator		    = "";
	String as_evidenced_by_hid		= "";	String curr_encr_flag		    = "";
	String diff_group_vals			= "";	String modal_yn					= "";
	String locale					= "";
	String isCalledFromCA			= "N";
	String practitioner_type		= "";
	String old_encounter_id			= "";
	String anatomical_site			= "";
	String applicable_side			= "";
	String accession_number			= "";
	String option_id				= "";
	String onset_encounter_id   = ""; //Mahesh added 06/04/2014
	String high_risk_code			= " "; 
	String diag_class_code			= " "; 
	String complaint_id			    = ""; 
	String anatomical_oral_sites    = ""; 
	String aud_complaint_desc		= "";
	String complaint_desc			= "";
	
	//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
	String link_diag_pri_sec_yn		= "N";
	String primary_diag_class		= "";
	String secondary_diag_class		= "";


	String diag_enc_level  ="";
	String restrict_sec_diag_yn  ="";
	String diag_catg_code  =""; // Added by Ajay for TH-KW-CRF-165.1
	String notifiable_code="";//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
	String curr_encounter_id="";//Maheshwaran K added for the Incident No :43698(related to SKR-CRF-0020 -29795) as on 24/09/2013	
	String mode_modify_curr_enc = "";//Added by Ajay Hatwate for ML-MMOH-CRF-1741
	StringBuffer reqstr			= new StringBuffer();
	/*Added on 9/23/2009 for MDR--450*/
	String call_from					="";
	String totalRecords			=	"";
	String diag_class_type="";			
	int mdr_totalRecords		= 0;
	String p_called_from_widget = "";  //CHL-CRF- 0008 - IN:001472
	String function_id = "";  //Added by Suji

	String slink_flag = ""; //Added by Ashwini on 21-Sep-2022 for ML-MMOH-SCF-1818
	
  
    String called_from_ot="",called_from_ot_desc=""; //variable Added for this CRF [PMG2012-CRF-0030]  

	String accession_num_work_related="", accession_num_notifiable=""; //Added for this CRF Bru-HIMS-CRF-024.2

	RecordSet OHDiagLinkConditionOBJ= null;
	HttpSession session				= null;

	/*
		12/2/2008 intialising connnection,preparedStatement,ResultSet
	*/

	String poa_indicator	= ""; //Added By Dharma on June 3rd 2020 against AAKH-CRF-0122.2
	
	Connection con =null;
	PreparedStatement pstmt			= null;
	ResultSet rs					= null;

	HashMap tabdata=new HashMap();

	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
	public synchronized void doGet(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		doPost(req,res);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		//MMS-ME-SCF-0096 vulnerability Issue
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		//MMS-ME-SCF-0096 vulnerability Issue
		session						= req.getSession(false);
		this.x_facility_id			= (String)session.getValue("facility_id") ;
		this.p						= (Properties) session.getValue( "jdbc" ) ;
		locale						= p.getProperty("LOCALE");
		this.client_ip_address		= this.p.getProperty("client_ip_address");
	
		StringBuffer Sql			= new StringBuffer();

		
		
		try 
		{
			mode					= checkForNull(req.getParameter("mode"));
			//Added by Ajay Hatwate for ML-MMOH-CRF-1741
			mode_modify_curr_enc	= checkForNull(req.getParameter("mode_modify_curr_enc"));
			if(mode_modify_curr_enc.equals("modify_curr_enc")){
				mode = mode_modify_curr_enc;
			}//End of ML-MMOH-CRF-1741
			old_onset_type			= checkForNull(req.getParameter("old_onset_type"));
			Practitioner_Id			= checkForNull(req.getParameter("Practitioner_Id"));
			relationship_id			= checkForNull(req.getParameter("relationship_id"));
			Locn_Code				= checkForNull(req.getParameter("Locn_Code"));
			Locn_Type				= checkForNull(req.getParameter("Locn_Type"));
			Patient_Id				= checkForNull(req.getParameter("Patient_Id"));
			patient_class			= checkForNull(req.getParameter("patient_class"));
			Encounter_Id			= checkForNull(req.getParameter("Encounter_Id"));
			curr_encounter_id			= checkForNull(req.getParameter("curr_encounter_id"));//Maheshwaran K added for the Incident No :43698(related to SKR-CRF-0020 -29795) as on 24/09/2013
			code_set				= checkForNull(req.getParameter("code_set"));
			priority_appl_yn		= checkForNull(req.getParameter("priority_appl_yn"));
			diagprob_code			= checkForNull(req.getParameter("diagprob_code"));
			if(diagprob_code.equals(""))
				diagprob_code		= "*OTH";
			diag_Description		= checkForNull(req.getParameter("diagprob_desc"));

			String term_oth_desc =    checkForNull(req.getParameter("term_oth_desc")); //  Added by mujafar for ML-MMOH-CRF-1281 US3
			String isMultiDescAppl=   checkForNull(req.getParameter("isMultiDescAppl"));
			String temp_var = "";
			if(!term_oth_desc.equals("") && isMultiDescAppl.equals("true"))
			diag_Description = term_oth_desc;

			stage_code				= checkForNull(req.getParameter("diag_stage"));
			cause_of_death_yn		= checkForNull(req.getParameter("CAUSE_OF_DEATH_YN"),"N");
			link_diag_pri_sec_yn	= checkForNull(req.getParameter("link_diag_pri_sec_yn"),"N");//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
			accry_code				= checkForNull(req.getParameter("accry_code"));
			accry_code_ind			= checkForNull(req.getParameter("accry_code_ind"));
			nature					= checkForNull(req.getParameter("nature"));
			poa_indicator					= checkForNull(req.getParameter("poa_indicator"));
			priority				= checkForNull(req.getParameter("priority"));
			severity				= checkForNull(req.getParameter("severity"));
			onset_date				= checkForNull(req.getParameter("onset_date"));
			
			notifiable_code				= checkForNull(req.getParameter("notifiable_code"));//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
			if(!(onset_date==null || onset_date.equals("")))
				onset_date			= DateUtils.convertDate(onset_date,"DMYHM",locale,"en");
			
			type					= checkForNull(req.getParameter("type"),"N");
			status					= checkForNull(req.getParameter("status"));
			status_date				= checkForNull(req.getParameter("status_date"));
			
			if(!(status_date==null || status_date.equals("")))
				status_date			= DateUtils.convertDate(status_date,"DMY",locale,"en");
			
			reason					= checkForNull(req.getParameter("reason"));
			remarks					= checkForNull(req.getParameter("remarks"));
			aud_complaint_desc 		= checkForNull(req.getParameter("aud_complaint_desc"));
			complaint_desc	 		= checkForNull(req.getParameter("complaint_desc"));
			as_evidenced_by_hid		= checkForNull(req.getParameter("as_evidenced_by_hid"));
			associate_codes			= checkForNull(req.getParameter("associate_codes"));
			associate_codes			= java.net.URLDecoder.decode((String)associate_codes);
			sex						= checkForNull(req.getParameter("sex"));
			dob						= checkForNull(req.getParameter("dob"));
			associate_codes_modify	= checkForNull(req.getParameter("associate_codes_modify"));
			associate_codes_modify	= java.net.URLDecoder.decode((String)associate_codes_modify);
			diff_group_id_hid		= checkForNull(req.getParameter("diff_group_id_hid"));
			occur_srl_no_hid		= req.getParameter("occur_srl_no_hid");
			if(occur_srl_no_hid== null) occur_srl_no_hid="0";
			code_indicator			= checkForNull(req.getParameter("code_indicator"));
			curr_encr_flag			= checkForNull(req.getParameter("curr_encr_flag"));
			slink_flag				= checkForNull(req.getParameter("slink_flag")); //Added by Ashwini on 21-Sep-2022 for ML-MMOH-SCF-1818
			diff_group_vals			= checkForNull(req.getParameter("diff_group_vals"));
			modal_yn				= checkForNull(req.getParameter("modal_yn"));
			isCalledFromCA			= checkForNull(req.getParameter("isCalledFromCA"));
			practitioner_type		= checkForNull(req.getParameter("practitioner_type"));	
			old_encounter_id		= checkForNull(req.getParameter("old_encounter_id"));	
			onset_encounter_id		= checkForNull(req.getParameter("onset_encounter_id"));	//Mahesh added 06/04/2014
			anatomical_site			= checkForNull(req.getParameter("anatomical_site"));	
			applicable_side			= checkForNull(req.getParameter("applicable_side"));	
			accession_number		= checkForNull(req.getParameter("accession_number"));
			option_id				= checkForNull(req.getParameter("option_id"));	
			diag_class_code			= checkForNull(req.getParameter("diag_classfication"));
			high_risk_code			= checkForNull(req.getParameter("high_risk_code"));
			complaint_id			= checkForNull(req.getParameter("complaint_id"));
			anatomical_oral_sites	= checkForNull(req.getParameter("anatomical_oral_sites"));
			diag_class_type= checkForNull(req.getParameter("diag_class_type"));
			diag_enc_level= checkForNull(req.getParameter("diag_enc_level"));
			diag_catg_code= checkForNull(req.getParameter("diag_category"));//Added by Ajay for TH-KW-CRF-165.1
			restrict_sec_diag_yn= checkForNull(req.getParameter("restrict_sec_diag_yn"));////Maheshwaran K added for MMS-DM-CRF-0197.1
			p_called_from_widget = checkForNull(req.getParameter("p_called_from_widget")); //CHL-CRF- 0008 - IN:001472
			function_id = checkForNull(req.getParameter("function_id")); //function_id Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021
			if(function_id.equals(""))
			{
               function_id="RECD";
			}
						
			
			called_from_ot=checkForNull(req.getParameter("called_from_ot"));// Added for this CRF [PMG2012-CRF-0030]
			if(!called_from_ot.equals(""))
			  called_from_ot_desc="Y";
			else
			  called_from_ot_desc="N";
			
			call_from						= checkForNull(req.getParameter("call_from"));//Getting From MDR Added On 9/15/2009
			if(!call_from.equals("")){
				totalRecords					= checkForNull(req.getParameter("totalRecords"));//Getting From MDR Added On 9/15/2009
				mdr_totalRecords			=	Integer.parseInt(totalRecords);//Getting From MDR Added On 9/15/2009
			}
			//Added for this CRF Bru-HIMS-CRF-024.2
			accession_num_work_related=checkForNull(req.getParameter("notifiable_note_form"));
            accession_num_notifiable=checkForNull(req.getParameter("accession_number"));
			if(mode.equals("modify")&&(accession_num_notifiable.equals("")))
			accession_num_notifiable=checkForNull(req.getParameter("accession_num_notifiable"));
			
			OHDiagLinkConditionOBJ	=	(webbeans.eCommon.RecordSet)	session.getAttribute("OHDiagLinkConditionOBJ");
			tabdata.put("x_facility_id",x_facility_id);
			tabdata.put("client_ip_address",client_ip_address);
			tabdata.put("old_onset_type",old_onset_type);
			tabdata.put("Practitioner_Id",Practitioner_Id);
			tabdata.put("relationship_id",relationship_id);
			tabdata.put("Locn_Code",Locn_Code);
			tabdata.put("Locn_Type",Locn_Type);
			tabdata.put("Patient_Id",Patient_Id);
			tabdata.put("Encounter_Id",Encounter_Id);
			tabdata.put("curr_encounter_id",curr_encounter_id);//Maheshwaran K added for the Incident No :43698(related to SKR-CRF-0020 -29795) as on 24/09/2013
			tabdata.put("code_set",code_set);
			tabdata.put("diagprob_code",diagprob_code);
			tabdata.put("diag_Description",diag_Description);
			tabdata.put("accuracy",accry_code);
			tabdata.put("accuracy_ind",accry_code_ind);
			tabdata.put("nature",nature);
			tabdata.put("poa_indicator",poa_indicator);
			tabdata.put("priority",priority);
			tabdata.put("severity",severity);
			tabdata.put("onset_date",onset_date);
			tabdata.put("type",type);
			tabdata.put("status",status);
			tabdata.put("status_date",status_date);
			tabdata.put("reason",reason);
			tabdata.put("remarks",remarks);
			tabdata.put("aud_complaint_desc", aud_complaint_desc);
			tabdata.put("complaint_desc", complaint_desc);
			tabdata.put("mode",mode);
			tabdata.put("priority_appl_yn",priority_appl_yn);
			tabdata.put("as_evidenced_by_hid",as_evidenced_by_hid);
			tabdata.put("associate_codes",associate_codes);
			tabdata.put("diff_group_id_hid",diff_group_id_hid);
			tabdata.put("occur_srl_no_hid",occur_srl_no_hid);
			tabdata.put("associate_codes_modify",associate_codes_modify);
			tabdata.put("code_indicator",code_indicator);
			tabdata.put("curr_encr_flag",curr_encr_flag);
			tabdata.put("slink_flag",slink_flag); //Added by Ashwini on 21-Sep-2022 for ML-MMOH-SCF-1818
			tabdata.put("diff_group_vals",diff_group_vals);
			tabdata.put("stage_code",stage_code);
			tabdata.put("cause_of_death_yn",cause_of_death_yn);
			tabdata.put("link_diag_pri_sec_yn",link_diag_pri_sec_yn);//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
			tabdata.put("old_encounter_id",old_encounter_id);
			tabdata.put("anatomical_site",anatomical_site);
			tabdata.put("applicable_side",applicable_side);
			tabdata.put("accession_number",accession_number);
			tabdata.put("high_risk_code",high_risk_code);
			tabdata.put("diag_class_code",diag_class_code);
			tabdata.put("complaint_id",complaint_id);
			tabdata.put("diag_enc_level",diag_enc_level);
			tabdata.put("diag_catg_code",diag_catg_code);//Added by Ajay for TH-KW-CRF-165.1
			tabdata.put("restrict_sec_diag_yn",restrict_sec_diag_yn);			
			tabdata.put("anatomical_oral_sites",anatomical_oral_sites);
			tabdata.put("notifiable_code",notifiable_code);//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
			tabdata.put("call_from",call_from);//From MDR added On 9/15/2009
			tabdata.put("onset_encounter_id",onset_encounter_id);//From MDR added On 9/15/2009
		   tabdata.put("called_from_ot_desc",called_from_ot_desc); // Added for this CRF [PMG2012-CRF-0030]
		   //Added for this CRF Bru-HIMS-CRF-024.2
		    tabdata.put("accession_num_work_related",accession_num_work_related); 
		    tabdata.put("accession_num_notifiable",accession_num_notifiable);
			 tabdata.put("isMultiDescAppl",isMultiDescAppl);  // Added by mujafar for ML-MMOH-CRF-1281 US3
			tabdata.put("term_oth_desc",term_oth_desc);
			if(OHDiagLinkConditionOBJ!=null)
				tabdata.put("OHDiagLinkConditionBean",OHDiagLinkConditionOBJ);
			
						
				int count			= 0;
				//String class_Code	= "";
				con					= ConnectionManager.getConnection(p);

				if(diag_class_code=="" ||diag_class_code.equals("")){					
				   insertRecDiagnosis(req, res);
				}else{	  
						boolean validFlow = false;
						if(!status.equals("A")){							
							insertRecDiagnosis(req, res);
							validFlow = true;
						}
						if(!diag_class_code.equals("") && diag_class_type.equals("")){

							if(Sql.length() > 0) Sql.delete(0,Sql.length());
							Sql.append("SELECT   DIAG_CLASS_TYPE FROM  MR_DIAG_CLASS WHERE  DIAG_CLASS_CODE=?");
							pstmt		= con.prepareStatement( Sql.toString() ) ;
							pstmt.setString( 1, diag_class_code) ;
							rs			= pstmt.executeQuery() ;
							if(rs.next());							
							diag_class_type = rs.getString("DIAG_CLASS_TYPE");
						//class_Code = rs.getString("DIAG_CLASS_TYPE");
							if(rs!=null) rs.close();
							if(pstmt!=null) pstmt.close();
						}

						//if(class_Code.equals("PD")){
						if(diag_class_type.equals("PD")){
									if(Sql.length() > 0) Sql.delete(0,Sql.length());
									//Sql.append("select count(*)  from pr_diagnosis a, MR_DIAG_CLASS b where a.ONSET_FACILITY_ID=? AND a.ONSET_ENCOUNTER_ID=? and a.term_set_id=? and a.DIAG_CLASS_CODE=b.DIAG_CLASS_CODE and b.DIAG_CLASS_TYPE='PD'  and a.CURR_STATUS ='A'");
									/*Thursday, March 18, 2010 , CURR_ENCOUNTER_ID added for walkthrough issue (System allows having two principal diagnoses in the same encounter for the same term set.)*/
									/*Sql.append("select count(*)  from pr_diagnosis a, MR_DIAG_CLASS b where a.ONSET_FACILITY_ID=? AND a.CURR_ENCOUNTER_ID=? and a.term_set_id=? and a.DIAG_CLASS_CODE=b.DIAG_CLASS_CODE and b.DIAG_CLASS_TYPE='PD'  and a.CURR_STATUS ='A'");*/
									//Maheshwaran K modified the Query as on 12/09/2013
									Sql.append("select count(*)  from pr_diagnosis_enc_dtl a, MR_DIAG_CLASS b where a.FACILITY_ID=? AND a.ENCOUNTER_ID=? and a.term_set_id=? and a.DIAG_CLASS_CODE=b.DIAG_CLASS_CODE and b.DIAG_CLASS_TYPE='PD'  and a.STATUS ='A'");
									pstmt = con.prepareStatement( Sql.toString() ) ;
									pstmt.setString( 1, x_facility_id) ;
									pstmt.setString( 2, Encounter_Id) ;
									pstmt.setString( 3, code_set) ;
									
									rs = pstmt.executeQuery() ;
									if(rs.next())
									count=rs.getInt(1);									
									 if(rs!=null) rs.close();
									if(pstmt!=null) pstmt.close();
									
									
									if(count== 0 && !(validFlow)){										
										insertRecDiagnosis(req, res);										
										validFlow = true;
									}

								//if((!mode.equals("") || !mode.equals("R")) && !diagprob_code.equals("*OTH"))
								if(mode.equals("modify"))
								{
									if(Sql.length() > 0) Sql.delete(0,Sql.length());
									 //Sql.append("select count(*)  from pr_diagnosis a, MR_DIAG_CLASS b where a.ONSET_FACILITY_ID=? AND a.ONSET_ENCOUNTER_ID=? and a.term_set_id=? and a.DIAG_CLASS_CODE=b.DIAG_CLASS_CODE and b.DIAG_CLASS_TYPE='PD' and a.TERM_CODE=? and a.CURR_STATUS ='A'");
									/*Thursday, March 18, 2010 , CURR_ENCOUNTER_ID added for walkthrough issue (System allows having two principal diagnoses in the same encounter for the same term set.)*/
									 /*Sql.append("select count(*)  from pr_diagnosis a, MR_DIAG_CLASS b where a.ONSET_FACILITY_ID=? AND a.CURR_ENCOUNTER_ID=? and a.term_set_id=? and a.DIAG_CLASS_CODE=b.DIAG_CLASS_CODE and b.DIAG_CLASS_TYPE='PD' and a.TERM_CODE=? and a.CURR_STATUS ='A'");*/
									 //Maheshwaran K modified the Query as on 12/09/2013
									 Sql.append("select count(*)  from pr_diagnosis_enc_dtl a, MR_DIAG_CLASS b where a.FACILITY_ID=? AND a.ENCOUNTER_ID=? and a.term_set_id=? and a.DIAG_CLASS_CODE=b.DIAG_CLASS_CODE and b.DIAG_CLASS_TYPE='PD' and a.TERM_CODE=? and a.STATUS ='A'");


									 pstmt = con.prepareStatement( Sql.toString() ) ;
									pstmt.setString( 1, x_facility_id) ;
									pstmt.setString( 2, Encounter_Id) ;
									pstmt.setString( 3, code_set) ;
									pstmt.setString( 4, diagprob_code) ;
									rs = pstmt.executeQuery() ;
									if(rs.next())
									count=rs.getInt(1);

									 if(rs!=null) rs.close();
									if(pstmt!=null) pstmt.close();
									
									
									if(count== 1 && !(validFlow)){											
										insertRecDiagnosis(req, res);
										validFlow = true;
									}										
								}
									if(Sql.length() > 0) Sql.delete(0,Sql.length());
									// Sql.append("select count(*)  from pr_diagnosis a, MR_DIAG_CLASS b where a.ONSET_FACILITY_ID=? AND a.ONSET_ENCOUNTER_ID=? and a.term_set_id=? and a.DIAG_CLASS_CODE=b.DIAG_CLASS_CODE and b.DIAG_CLASS_TYPE='PD'");
									/*Thursday, March 18, 2010 , CURR_ENCOUNTER_ID added for walkthrough issue (System allows having two principal diagnoses in the same encounter for the same term set.)*/
									 /*Sql.append("select count(*)  from pr_diagnosis a, MR_DIAG_CLASS b where a.ONSET_FACILITY_ID=? AND a.CURR_ENCOUNTER_ID=? and a.term_set_id=? and a.DIAG_CLASS_CODE=b.DIAG_CLASS_CODE and b.DIAG_CLASS_TYPE='PD'");*/
									 //Maheshwaran K modified the Query as on 12/09/2013
									// Dharma on 12th Feb 2014 if(!mode.equals("modify") && !(count>0))
									//	{
										Sql.append("select count(*)  from pr_diagnosis_enc_dtl a, MR_DIAG_CLASS b where a.FACILITY_ID=? AND a.ENCOUNTER_ID=? and a.term_set_id=? and a.DIAG_CLASS_CODE=b.DIAG_CLASS_CODE and b.DIAG_CLASS_TYPE='PD' AND a.STATUS ='A'");
										pstmt = con.prepareStatement( Sql.toString() ) ;
										pstmt.setString( 1, x_facility_id) ;
										pstmt.setString( 2, Encounter_Id) ;
										pstmt.setString( 3, code_set) ;
										rs = pstmt.executeQuery() ;
										if(rs.next())
										count=rs.getInt(1);									
										if(rs!=null) rs.close();
										if(pstmt!=null) pstmt.close();		
										
										//}									
									if(count== 0 && !(validFlow)){	
										insertRecDiagnosis(req, res);
										validFlow = true;
									}else{										
										if(!validFlow){
											java.util.Hashtable message = MessageManager.getMessage( locale,"PRIMARY_DIAGNOSIS_TERM_SET","MR");
											String mesge = (String) message.get("message");											
											message.clear();
											res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(mesge,"UTF-8"));
										}
									}
						}else{							
							if(!(validFlow))
							  insertRecDiagnosis(req, res);
						}
				}
				
				
				
				

		}
		catch (Exception ex)
		{
			ex.printStackTrace();

		}
		finally{
			
			if(con != null)
				ConnectionManager.returnConnection(con,p);
			
		}
	}

	
	/**	INSERT **/
	private void insertRecDiagnosis(HttpServletRequest req, HttpServletResponse res){
		String error	="";
		req = req;
		try
		{
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RecDiagnosis",RecDiagnosisHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;

			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("insertRecDiagnosis",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			error = (String) results.get("error") ;
			String error_value = "0" ;
			String flag="";
			String reload_mdr	="";// Added On 9/23/2009 For MDR

			if ( inserted ){
				if(OHDiagLinkConditionOBJ!=null)
					OHDiagLinkConditionOBJ.clearAll();
				session.removeAttribute("OHDiagLinkConditionOBJ"); 
				session.removeAttribute("linkComplaint");			
				error_value = "1" ;
				if(accry_code_ind.equals("U")){
				flag= (String) results.get("diff_flaf") ;
				}
				else
				{
					flag="";
				}

				error= (String) results.get("message") ;
			
				if(!mode.equals("modify"))
					occur_srl_no_hid= (String) results.get("occur_srl_no");
				/*Added On 9/23/2009 For MDR*/
				if(call_from.equals("MAINTAIN_DEATH_REGISTER")){

					/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
					Boolean isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","DECEASED_DIAG_CLASS_DEATH_REG");
					primary_diag_class = checkForNull(req.getParameter("primary_diag_class"));
					secondary_diag_class = checkForNull(req.getParameter("secondary_diag_class"));
					/*End ML-MMOH-CRF-1742*/

						reload_mdr="Y";
						HashMap combined_map		= new HashMap(); 
						HashMap diag_dates_map	= new HashMap(); 
						combined_map = (HashMap)session.getAttribute("combined_map");
						diag_dates_map = (HashMap)session.getAttribute("diag_dates_map");
						ArrayList primaryList=(ArrayList)combined_map.get("C");
						ArrayList OthersList=(ArrayList)combined_map.get("O");
						ArrayList general_list=(ArrayList)combined_map.get("R");
						int index=(mdr_totalRecords+1);
						String diag_dtl_record	=	index+"#"+"A"+"#"+diagprob_code+"#"+code_set+"#"+occur_srl_no_hid+"#"+diag_Description+"#"+"I";

						/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
						if(isDeceasedDiagClassDeathRegAppl){
							if(!primary_diag_class.equals("") && secondary_diag_class.equals("")){
								if(diag_class_code.equals(primary_diag_class)){
									primaryList.add(diag_dtl_record);
									combined_map.put("C",primaryList);
								}else{
									general_list.add(diag_dtl_record);
									combined_map.put("R",general_list);
								}
							}else if(primary_diag_class.equals("") && !secondary_diag_class.equals("")){
								if(diag_class_code.equals(secondary_diag_class)){
									OthersList.add(diag_dtl_record);
									combined_map.put("O",OthersList);
								}else{
									general_list.add(diag_dtl_record);
									combined_map.put("R",general_list);
								}
							}else if(!primary_diag_class.equals("") && !secondary_diag_class.equals("")){
								if(diag_class_code.equals(primary_diag_class)){
									primaryList.add(diag_dtl_record);
									combined_map.put("C",primaryList);
								}else if(diag_class_code.equals(secondary_diag_class)){
									OthersList.add(diag_dtl_record);
									combined_map.put("O",OthersList);
								}else{
									general_list.add(diag_dtl_record);
									combined_map.put("R",general_list);
								}
							}else{
								primaryList.add(diag_dtl_record);
								combined_map.put("C",primaryList);
							}
						}else{
							primaryList.add(diag_dtl_record);
							combined_map.put("C",primaryList);
						}
						/*End ML-MMOH-CRF-1742*/

						session.setAttribute("combined_map",combined_map);
						onset_date=DateUtils.convertDate(onset_date,"DMYHM","en",locale);
						diag_dates_map.put(diag_dtl_record,onset_date);
						session.setAttribute("diag_dates_map",diag_dates_map);
						//res.sendRedirect("../eMR/jsp/RecDiagnosiserror.jsp?function_id=RECD&Patient_Id="+Patient_Id+"&patient_class="+patient_class+"&Encounter_Id="+Encounter_Id+"&mode="+mode+"&modal_yn="+modal_yn+"&flag="+flag+"&term_set_id="+code_set+"&term_set_code="+diagprob_code+"&diag_Description="+diag_Description+"&onset_date="+onset_date+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&sex="+sex+"&dob="+dob+"&occur_srl_no="+occur_srl_no_hid+"&error=" + java.net.URLEncoder.encode( error, "UTF-8" )+ "&err_value=" + error_value+"&mode=insert" );
						//Maheshwaran K added 'curr_encounter_id' for the Incident No :43698(related to SKR-CRF-0020 -29795) as on 24/09/2013
						reqstr.setLength(0);
						//String reqstr1="../eMR/jsp/RecDiagnosiserror.jsp?function_id=RECD&Patient_Id="+Patient_Id+"&patient_class="+patient_class+"&Encounter_Id="+curr_encounter_id+"&mode="+mode+"&modal_yn="+modal_yn+"&flag="+flag+"&term_set_id="+code_set+"&term_set_code="+diagprob_code+"&diag_Description="+"&p_called_from_widget="+p_called_from_widget;
						String reqstr1="../eMR/jsp/RecDiagnosiserror.jsp?function_id="+function_id+"&Patient_Id="+Patient_Id+"&patient_class="+patient_class+"&Encounter_Id="+Encounter_Id+"&mode="+mode+"&modal_yn="+modal_yn+"&flag="+flag+"&term_set_id="+code_set+"&term_set_code="+diagprob_code+"&p_called_from_widget="+p_called_from_widget; //function_id Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021
						reqstr.append(reqstr1);
                    /* Below one line commented by Venkatesh.S on 05-Nov-2013 against MMS-SCF-0135 [IN:044598].The Reason is when "diag_Description" value come with apostrophe (') request not sending properly to ../eMR/jsp/RecDiagnosiserror.jsp page */	
					
						//reqstr.append(java.net.URLEncoder.encode(diag_Description));
						String reqstr2=reqstr.toString()+"&onset_date="+java.net.URLEncoder.encode(onset_date)+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&sex="+sex+"&dob="+java.net.URLEncoder.encode(dob)+"&occur_srl_no="+occur_srl_no_hid+"&error=" + java.net.URLEncoder.encode( error, "UTF-8" )+ "&err_value=" + error_value+"&mode=insert&isCalledFromCA="+isCalledFromCA+"&practitioner_type="+practitioner_type+"&option_id="+option_id+"&accession_number="+accession_number+"&call_from="+call_from+"&reload_mdr="+reload_mdr+"&called_from_ot="+called_from_ot; //this line Modified for this CRF  CRF [PMG2012-CRF-0030]
						res.sendRedirect(reqstr2);
						
					}else{
							reload_mdr="N";
								//res.sendRedirect("../eMR/jsp/RecDiagnosiserror.jsp?function_id=RECD&Patient_Id="+Patient_Id+"&patient_class="+patient_class+"&Encounter_Id="+Encounter_Id+"&mode="+mode+"&modal_yn="+modal_yn+"&flag="+flag+"&term_set_id="+code_set+"&term_set_code="+diagprob_code+"&diag_Description="+diag_Description+"&onset_date="+onset_date+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&sex="+sex+"&dob="+dob+"&occur_srl_no="+occur_srl_no_hid+"&error=" + java.net.URLEncoder.encode( error, "UTF-8" )+ "&err_value=" + error_value+"&mode=insert" );
							
							reqstr.setLength(0);
							//String reqstr1="../eMR/jsp/RecDiagnosiserror.jsp?function_id=RECD&Patient_Id="+Patient_Id+"&patient_class="+patient_class+"&Encounter_Id="+curr_encounter_id+"&mode="+mode+"&modal_yn="+modal_yn+"&flag="+flag+"&term_set_id="+code_set+"&term_set_code="+diagprob_code+"&diag_Description="+"&p_called_from_widget="+p_called_from_widget;  //CHL-CRF- 0008 - IN:001472 
							String reqstr1="../eMR/jsp/RecDiagnosiserror.jsp?function_id="+function_id+"&Patient_Id="+Patient_Id+"&patient_class="+patient_class+"&Encounter_Id="+Encounter_Id+"&mode="+mode+"&modal_yn="+modal_yn+"&flag="+flag+"&term_set_id="+code_set+"&term_set_code="+diagprob_code+"&p_called_from_widget="+p_called_from_widget;  //CHL-CRF- 0008 - IN:001472 //function_id Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021
							reqstr.append(reqstr1);
							 /*Below one line commented by Venkatesh.S on 05-Nov-2013 against MMS-SCF-0135 [IN:044598]..The Reason is when "diag_Description" value come with apostrophe (') request not sending properly to ../eMR/jsp/RecDiagnosiserror.jsp page */
							
							//reqstr.append(java.net.URLEncoder.encode(diag_Description));
							String reqstr2=reqstr.toString()+"&onset_date="+java.net.URLEncoder.encode(onset_date)+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&sex="+sex+"&dob="+java.net.URLEncoder.encode(dob)+"&occur_srl_no="+occur_srl_no_hid+"&error=" + java.net.URLEncoder.encode( error, "UTF-8" )+ "&err_value=" + error_value+"&mode=insert&isCalledFromCA="+isCalledFromCA+"&practitioner_type="+practitioner_type+"&option_id="+option_id+"&accession_number="+accession_number+"&call_from="+call_from+"&reload_mdr="+reload_mdr+"&called_from_ot="+called_from_ot; //this line Modified for this CRF  CRF [PMG2012-CRF-0030]
							res.sendRedirect(reqstr2);
					}
					//res.sendRedirect("../eMR/jsp/RecDiagnosiserror.jsp?function_id=RECD&Patient_Id="+Patient_Id+"&patient_class="+patient_class+"&Encounter_Id="+Encounter_Id+"&mode="+mode+"&modal_yn="+modal_yn+"&flag="+flag+"&term_set_id="+code_set+"&term_set_code="+diagprob_code+"&diag_Description="+diag_Description+"&onset_date="+onset_date+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&sex="+sex+"&dob="+dob+"&occur_srl_no="+occur_srl_no_hid+"&error=" + java.net.URLEncoder.encode( error, "UTF-8" )+ "&err_value=" + error_value+"&mode=insert&isCalledFromCA="+isCalledFromCA+"&practitioner_type="+practitioner_type+"&option_id="+option_id+"&accession_number="+accession_number);
			}
			else{
				error = (String) results.get("error") ;
				error_value = "1" ;
				reload_mdr = "N";
				//res.sendRedirect("../eMR/jsp/RecDiagnosiserror.jsp?function_id=RECD&Patient_Id="+Patient_Id+"&patient_class="+patient_class+"&modal_yn="+modal_yn+"&Encounter_Id="+Encounter_Id+"&term_set_id="+code_set+"&term_set_code="+diagprob_code+"&diag_Description="+diag_Description+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&sex="+sex+"&dob="+dob+"&error=" + java.net.URLEncoder.encode( error, "UTF-8" )+ "&err_value=" + error_value+"&mode=insert"  );
			/*Below Line modified for this CRF PMG2012-CRF-0030 */
			
				//res.sendRedirect("../eMR/jsp/RecDiagnosiserror.jsp?function_id=RECD&Patient_Id="+Patient_Id+"&patient_class="+patient_class+"&modal_yn="+modal_yn+"&Encounter_Id="+curr_encounter_id+"&term_set_id="+code_set+"&term_set_code="+diagprob_code+"&diag_Description="+diag_Description+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&sex="+sex+"&dob="+dob+"&error=" + java.net.URLEncoder.encode( error, "UTF-8" )+ "&err_value=" + error_value+"&mode=insert&isCalledFromCA="+isCalledFromCA+"&practitioner_type="+practitioner_type+"&option_id="+option_id+"&accession_number="+accession_number+"&call_from="+call_from+"&reload_mdr="+reload_mdr+"&p_called_from_widget="+p_called_from_widget+"&called_from_ot="+called_from_ot); //CHL-CRF- 0008 - IN:001472
				res.sendRedirect("../eMR/jsp/RecDiagnosiserror.jsp?function_id="+function_id+"&Patient_Id="+Patient_Id+"&patient_class="+patient_class+"&modal_yn="+modal_yn+"&Encounter_Id="+Encounter_Id+"&term_set_id="+code_set+"&term_set_code="+diagprob_code+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&sex="+sex+"&dob="+dob+"&error=" + java.net.URLEncoder.encode( error, "UTF-8" )+ "&err_value=" + error_value+"&mode=insert&isCalledFromCA="+isCalledFromCA+"&practitioner_type="+practitioner_type+"&option_id="+option_id+"&accession_number="+accession_number+"&call_from="+call_from+"&reload_mdr="+reload_mdr+"&p_called_from_widget="+p_called_from_widget+"&called_from_ot="+called_from_ot); //CHL-CRF- 0008 - IN:001472 //function_id Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021
			}
			if ( results != null) results.clear();
		}catch ( Exception e ) {
			e.printStackTrace();
			try{
				error="Exception in Servlet::"+e.toString();
				
				String error_value = "0" ;	//res.sendRedirect("../eMR/jsp/RecDiagnosiserror.jsp?function_id=RECD&Patient_Id="+Patient_Id+"&patient_class="+patient_class+"&Encounter_Id="+Encounter_Id+"&term_set_id="+code_set+"&term_set_code="+diagprob_code+"&diag_Description="+diag_Description+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&sex="+sex+"&dob="+dob+"&mode=insert&error=" + java.net.URLEncoder.encode( error, "UTF-8" )+ "&err_value=" + error_value  );
				/*Below Line modified for this CRF PMG2012-CRF-0030 */
				//res.sendRedirect("../eMR/jsp/RecDiagnosiserror.jsp?function_id=RECD&Patient_Id="+Patient_Id+"&patient_class="+patient_class+"&Encounter_Id="+curr_encounter_id+"&term_set_id="+code_set+"&term_set_code="+diagprob_code+"&diag_Description="+diag_Description+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&sex="+sex+"&dob="+dob+"&mode=insert&isCalledFromCA="+isCalledFromCA+"&practitioner_type="+practitioner_type+"&option_id="+option_id+"&accession_number="+accession_number+"&error=" + java.net.URLEncoder.encode( error, "UTF-8" )+ "&err_value=" + error_value+"&p_called_from_widget="+p_called_from_widget+"&called_from_ot="+called_from_ot); //CHL-CRF- 0008 - IN:001472
				res.sendRedirect("../eMR/jsp/RecDiagnosiserror.jsp?function_id="+function_id+"&Patient_Id="+Patient_Id+"&patient_class="+patient_class+"&Encounter_Id="+Encounter_Id+"&term_set_id="+code_set+"&term_set_code="+diagprob_code+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&sex="+sex+"&dob="+dob+"&mode=insert&isCalledFromCA="+isCalledFromCA+"&practitioner_type="+practitioner_type+"&option_id="+option_id+"&accession_number="+accession_number+"&error=" + java.net.URLEncoder.encode( error, "UTF-8" )+ "&err_value=" + error_value+"&p_called_from_widget="+p_called_from_widget+"&called_from_ot="+called_from_ot); //CHL-CRF- 0008 - IN:001472 //function_id Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
	}
	public static String checkForNull(String s)
    {
        return s != null && !s.equals("null") ? s : "";
    }
	
	public static String checkForNull(String inputString, String defaultValue) {
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? defaultValue : inputString );
	}

}
