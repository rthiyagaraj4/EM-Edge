/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR.MedRecRequest;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="MedRecRequest"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="MedRecRequest"
*	local-jndi-name="MedRecRequest"
*	impl-class-name="eMR.MedRecRequest.MedRecRequestManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMR.MedRecRequest.MedRecRequestLocal"
*	remote-class="eMR.MedRecRequest.MedRecRequestRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMR.MedRecRequest.MedRecRequestLocalHome"
*	remote-class="eMR.MedRecRequest.MedRecRequestHome"
*	generate= "local,remote"
*
*
*/

public class MedRecRequestManager implements SessionBean
{

	Connection			con		= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;
	ResultSet			rset	= null;
	Statement			Stmt	= null;
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void setSessionContext (SessionContext context){ /*this.ctx=context;*/}
	int count = 0;
	int count2= 0;

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

public java.util.HashMap insertMedRecRequest(java.util.Properties p,java.util.HashMap tableData)
{
			
	String encounter_id				=	(String)tableData.get("encounter_id"); 
	String patient_id				=	(String)tableData.get("patient_id"); 
	String Requestor_Code			=	(String)tableData.get("Requestor_Code"); 
	String appln_date				=	(String)tableData.get("appln_date"); 
	String MedicalMembers			=	(String)tableData.get("MedicalMembers"); 
	String practitioner_id			=	(String)tableData.get("practitioner_id"); 
	String team_id					=	(String)tableData.get("team_id"); 
	String collect_date				=	(String)tableData.get("collect_date"); 
	String remarks					=	(String)tableData.get("remarks"); 
	String addedById				=	(String)tableData.get("addedById"); 
	String modifiedById				=	(String)tableData.get("modifiedById"); 
	String addedFacilityId			=	(String)tableData.get("addedFacilityId"); 
	String modifiedFacilityId		=	(String)tableData.get("modifiedFacilityId"); 
	String addedAtWorkstation		=	(String)tableData.get("addedAtWorkstation"); 
	String modifiedAtWorkstation	=	(String)tableData.get("modifiedAtWorkstation"); 
	String facilityId				=	(String)tableData.get("facilityId"); 
	String other_application_ref_no	=	(String)tableData.get("other_application_ref_no");//Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360
	String relationship_type = (String)tableData.get("relationship_type");
	String appl_addr_line1 = (String)tableData.get("appl_addr_line1");
	String appl_addr_line2 = (String)tableData.get("appl_addr_line2");
	String appl_addr_line3 = (String)tableData.get("appl_addr_line3");
	String appl_addr_line4 = (String)tableData.get("appl_addr_line4");
	String appl_town_code = (String)tableData.get("appl_town_code");
	String appl_area_code = (String)tableData.get("appl_area_code");
	String appl_region_code = (String)tableData.get("appl_region_code");
	String appl_postal_code = (String)tableData.get("appl_postal_code");
	String appl_country_code = (String)tableData.get("appl_country_code");
	String del_addr_line1= (String)tableData.get("del_addr_line1");
	String del_addr_line2= (String)tableData.get("del_addr_line2");
	String del_addr_line3= (String)tableData.get("del_addr_line3");
	String del_addr_line4= (String)tableData.get("del_addr_line4");
	String del_res_town_code= (String)tableData.get("del_res_town_code");
	String del_res_area_code= (String)tableData.get("del_res_area_code");
	String del_region_code= (String)tableData.get("del_region_code");
	String del_postal_code= (String)tableData.get("del_postal_code");
	String del_country_code= (String)tableData.get("del_country_code");
	String relationship= (String)tableData.get("relationship");
	String req_type= (String)tableData.get("req_type");
	String appl_type= (String)tableData.get("appl_type");
	String appl_no= (String)tableData.get("appl_no");
	String appl_name= (String)tableData.get("appl_name");
	String cons_letter= (String)tableData.get("cons_letter");
	String appl_refno= (String)tableData.get("appl_refno");
	String for_attn= (String)tableData.get("for_attn");
	String rep_type= (String)tableData.get("rep_type");
	String dept_spl= (String)tableData.get("dept_spl");
	String appl_status= (String)tableData.get("appl_status");
	String appl_comp_dat= (String)tableData.get("appl_comp_dat");
	String reqd_docs= (String)tableData.get("reqd_docs");
	String board_type= (String)tableData.get("board_type");
	String charges_appllicable_YN	= (String)tableData.get("charges_appllicable");
	String additional_charges_YN	= (String)tableData.get("additional_charges");
	String amount	= (String)tableData.get("amount");
	String addl_amount	= (String)tableData.get("addl_amount");
	String add_recp_dat	= (String)tableData.get("add_recp_dat");
	String recp_dat	= (String)tableData.get("recp_dat");
	String locale = p.getProperty("LOCALE");
	// added by mujafar for ML-MMOH-CRF-0762 start
	String classification_appl_yn = checkForNull((String)tableData.get("classification_appl_yn"));
	
	String classification_ind = "";
	String chk_list_code0 = "",chk_list_code1 = "",chk_list_code2 = "",chk_list_code3 = "",chk_list_code4 = "",chk_list_code5 = "",chk_list_code6 = "",chk_list_code7 = "",chk_list_code8 = "",chk_list_code9 = "",chk_list_code10 = "",chk_list_code11 = "",chk_list_code12 = "",chk_list_code13 = "",chk_list_code14 = "",chk_list_code15 = "",chk_list_code16 = "",chk_list_code17 = "",chk_list_code18 = "",chk_list_code19 = "",chk_list_code20 = "",chk_list_code21 = "",chk_list_code22 = "",chk_list_code23 = "",chk_list_code24 = "";//Added by Kamatchi S by ML-MMOH-CRF-1464
	String chk_list_code_status0="",chk_list_code_status1="",chk_list_code_status2="",chk_list_code_status3="",chk_list_code_status4="",chk_list_code_status5="",chk_list_code_status6="",chk_list_code_status7="",chk_list_code_status8="",chk_list_code_status9="",chk_list_code_status10="",chk_list_code_status11="",chk_list_code_status12="",chk_list_code_status13="",chk_list_code_status14="",chk_list_code_status15="",chk_list_code_status16="",chk_list_code_status17="",chk_list_code_status18="",chk_list_code_status19="",chk_list_code_status20="",chk_list_code_status21="",chk_list_code_status22="",chk_list_code_status23="",chk_list_code_status24="";//Added by Kamatchi S by ML-MMOH-CRF-1464
	String contact2_nat_id_no = "";
	String contact1_oth_alt_id_type ="";
	String contact1_oth_alt_id_no = "";
	int count = 0;
	String req_type_ind = ""; // added by mujafar for ML-MMOH-CRF-0762 end
	
	if(classification_appl_yn.equals("true"))
	{ // added by mujafar for ML-MMOH-CRF-0762 start
	
	 contact2_nat_id_no = checkForNull((String)tableData.get("contact2_nat_id_no"));
	 contact1_oth_alt_id_type = checkForNull((String)tableData.get("contact1_oth_alt_id_type"));
	 contact1_oth_alt_id_no =  checkForNull((String)tableData.get("contact1_oth_alt_id_no"));
	
	  req_type_ind = req_type;

		
	
	
	
	chk_list_code0 = checkForNull((String)tableData.get("chk_list_code0"));
	chk_list_code1 = checkForNull((String)tableData.get("chk_list_code1"));
	chk_list_code2 = checkForNull((String)tableData.get("chk_list_code2"));
	chk_list_code3 = checkForNull((String)tableData.get("chk_list_code3"));
	chk_list_code4 = checkForNull((String)tableData.get("chk_list_code4"));
	chk_list_code5 = checkForNull((String)tableData.get("chk_list_code5"));
	chk_list_code6 = checkForNull((String)tableData.get("chk_list_code6"));
	chk_list_code7 = checkForNull((String)tableData.get("chk_list_code7"));
	chk_list_code8 = checkForNull((String)tableData.get("chk_list_code8"));
	chk_list_code9 = checkForNull((String)tableData.get("chk_list_code9"));
	//Added by Kamatchi S by ML-MMOH-CRF-1464 START
	chk_list_code10 = checkForNull((String)tableData.get("chk_list_code10"));
	chk_list_code11 = checkForNull((String)tableData.get("chk_list_code11"));
	chk_list_code12 = checkForNull((String)tableData.get("chk_list_code12"));
	chk_list_code13 = checkForNull((String)tableData.get("chk_list_code13"));
	chk_list_code14 = checkForNull((String)tableData.get("chk_list_code14"));
	chk_list_code15 = checkForNull((String)tableData.get("chk_list_code15"));
	chk_list_code16 = checkForNull((String)tableData.get("chk_list_code16"));
	chk_list_code17 = checkForNull((String)tableData.get("chk_list_code17"));
	chk_list_code18 = checkForNull((String)tableData.get("chk_list_code18"));
	chk_list_code19 = checkForNull((String)tableData.get("chk_list_code19"));
	chk_list_code20 = checkForNull((String)tableData.get("chk_list_code20"));
	chk_list_code21 = checkForNull((String)tableData.get("chk_list_code21"));
	chk_list_code22 = checkForNull((String)tableData.get("chk_list_code22"));
	chk_list_code23 = checkForNull((String)tableData.get("chk_list_code23"));
	chk_list_code24 = checkForNull((String)tableData.get("chk_list_code24"));
	//Added by Kamatchi S by ML-MMOH-CRF-1464 END
	chk_list_code_status0 = checkForNull((String)tableData.get("chk_list_code_status0"));
	chk_list_code_status1 = checkForNull((String)tableData.get("chk_list_code_status1"));
	chk_list_code_status2 = checkForNull((String)tableData.get("chk_list_code_status2"));
	chk_list_code_status3 = checkForNull((String)tableData.get("chk_list_code_status3"));
	chk_list_code_status4 = checkForNull((String)tableData.get("chk_list_code_status4"));
	chk_list_code_status5 = checkForNull((String)tableData.get("chk_list_code_status5"));
	chk_list_code_status6 = checkForNull((String)tableData.get("chk_list_code_status6"));
	chk_list_code_status7 = checkForNull((String)tableData.get("chk_list_code_status7"));
	chk_list_code_status8 = checkForNull((String)tableData.get("chk_list_code_status8"));
	chk_list_code_status9 = checkForNull((String)tableData.get("chk_list_code_status9"));
	//Added by Kamatchi S by ML-MMOH-CRF-1464 START
	chk_list_code_status10 = checkForNull((String)tableData.get("chk_list_code_status10"));
	chk_list_code_status11 = checkForNull((String)tableData.get("chk_list_code_status11"));
	chk_list_code_status12 = checkForNull((String)tableData.get("chk_list_code_status12"));
	chk_list_code_status13 = checkForNull((String)tableData.get("chk_list_code_status13"));
	chk_list_code_status14 = checkForNull((String)tableData.get("chk_list_code_status14"));
	chk_list_code_status15 = checkForNull((String)tableData.get("chk_list_code_status15"));
	chk_list_code_status16 = checkForNull((String)tableData.get("chk_list_code_status16"));
	chk_list_code_status17 = checkForNull((String)tableData.get("chk_list_code_status17"));
	chk_list_code_status18 = checkForNull((String)tableData.get("chk_list_code_status18"));
	chk_list_code_status19 = checkForNull((String)tableData.get("chk_list_code_status19"));
	chk_list_code_status20 = checkForNull((String)tableData.get("chk_list_code_status20"));
	chk_list_code_status21 = checkForNull((String)tableData.get("chk_list_code_status21"));
	chk_list_code_status22 = checkForNull((String)tableData.get("chk_list_code_status22"));
	chk_list_code_status23 = checkForNull((String)tableData.get("chk_list_code_status23"));
	chk_list_code_status24 = checkForNull((String)tableData.get("chk_list_code_status24"));
	//Added by Kamatchi S by ML-MMOH-CRF-1464 END
	
	
	
	 classification_ind = checkForNull((String)tableData.get("classification_ind"));
	
	
		
		
	}
	
// added by mujafar for ML-MMOH-CRF-0762 end
	
	
	
	
	

	//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
	String chklst_consent_fr_pat	= checkForNull((String)tableData.get("CHKLST_CONSENT_FR_PAT"));
	String chklst_ident_doc			= checkForNull((String)tableData.get("CHKLST_IDENT_DOC"));
	String chklst_marital_cert		= checkForNull((String)tableData.get("CHKLST_MARITAL_CERT"));
	String chklst_stat_dec			= checkForNull((String)tableData.get("CHKLST_STAT_DEC"));
	String chklst_consent_fr_embsy	= checkForNull((String)tableData.get("CHKLST_CONSENT_FR_EMBSY"));
	String chklst_payment			= checkForNull((String)tableData.get("CHKLST_PAYMENT"));
	
	/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
	String appl_contact_no1			= checkForNull((String)tableData.get("contact_no1"));
	String appl_contact_no2			= checkForNull((String)tableData.get("contact_no2"));
	String appl_email_id			= checkForNull((String)tableData.get("appl_email_id"));
	
	String receipt_no_str	= checkForNull((String)tableData.get("receipt_no"));
	String addl_receipt_no_str	= checkForNull((String)tableData.get("addl_receipt_no"));
	StringBuffer sbSql = new StringBuffer();
	StringBuffer sbMsg = new StringBuffer();
	boolean	result		= true ;
	ResultSet reqIDRS	= null;
	Statement reqIDStmt	= null;
	String Str_req_id = "";

	//int to long Modified for ML-MMOH-CRF-0702
	//int req_id = 0;
	long req_id = 0;

	long EncounterID = 0;
	String name_prefix	= "";			String first_name = "";
	String second_name	= "";			String third_name ="";
	String family_name ="";
	String name_suffix	="";			String patient_name ="";
	String national_id_no = "";			String alt_id1_type = "";
	String alt_id1_no	="";			String alt_id2_type = "";
	String alt_id2_no	 = "";			String alt_id3_type = "";
	String alt_id3_no	 = "";			String alt_id4_type = "";
	String alt_id4_no	="";			String oth_alt_id_type ="";
	String oth_alt_id_no ="";			String sex = "";

	//Added by Ashwini on 14-Jul-2017 for ML-MMOH-CRF-0702
	int updtReqIdRS	= 0;
	//int nxtSrlNo = 0;
	//int maxSrlNo = 0;
	long nxtSrlNo = 0;
	long maxSrlNo = 0;
	String reqIDSql = "";
	String updtReqIDSql = "";
	Boolean transContinue = true;
	Boolean isreqIdFromSetup = false; 
	Statement updtReqIDStmt	= null;

	try
	{
		try
		{
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);

			//String reqIDSql=" SELECT NVL(MAX(REQUEST_ID),0)+1 FROM MR_REPORT_REQUEST_HDR WHERE FACILITY_ID = '"+facilityId+"' ";

			/* Added by Ashwini on 28-Jun-2017 for ML-MMOH-CRF-0702 Start */
			isreqIdFromSetup = eCommon.Common.CommonBean.isSiteSpecific(con, "MR", "REQUEST_ID_SEQUENCE");

			if(isreqIdFromSetup == true)
			{	
				reqIDSql=" Select to_char(year_num) || lpad(to_char(NEXT_SRL_NO),length(MAX_SRL_NO),'0') ref_id , year_num,next_srl_no,max_srl_no From MR_REQUEST_ID_FOR_FCY where facility_id = '"+facilityId+"' and year_num = to_number(to_char(sysdate,'rrrr')) ";
			}else
			{
				reqIDSql=" select MR_MED_REPORT_REQUEST_SEQ.NEXTVAL from dual ";
			}

			reqIDStmt = con.createStatement() ;
			reqIDRS	= reqIDStmt.executeQuery(reqIDSql) ;

			if(reqIDRS !=null && reqIDRS.next())
			{ 			
					if(isreqIdFromSetup == true )
					{
					//nxtSrlNo	 = reqIDRS.getInt(3);
					//maxSrlNo	 = reqIDRS.getInt(4);
					nxtSrlNo	 = reqIDRS.getLong(3);
					maxSrlNo	 = reqIDRS.getLong(4);

						if(nxtSrlNo > maxSrlNo)
						{
						result = false;
						java.util.Hashtable message = MessageManager.getMessage(locale,"NXT_NO_GR_MAX_NO","Common");						
						String Str = (String) message.get("message");
						Str = Str.replace("$",String.valueOf(maxSrlNo));						
						sbMsg.append(Str) ;						
						message.clear();
						transContinue = false;

						}else
						{
						//req_id	= reqIDRS.getInt(1);
						req_id	= reqIDRS.getLong(1);

						
						}
						
					}else
					{
					//req_id	= reqIDRS.getInt(1);
					req_id	= reqIDRS.getLong(1);
					}
				
			} else
			{
				transContinue = false;
				result = false;
				java.util.Hashtable message = MessageManager.getMessage(locale,"REQ_ID_GEN_CURNT_YR","Common");
				sbMsg.append((String) message.get("message") ) ;
				message.clear();
			}
			/* End ML-MMOH-CRF-0702 */

			//	Integer Int_req_id	= new Integer(req_id);
			//	Str_req_id = Int_req_id.toString();


	}catch(Exception e1)
	{
		e1.printStackTrace();
		result = false;
	}

	//Added by Ashwini on 14-Jul-2017 for ML-MMOH-CRF-0702
	if(result)
	{
	String REQUEST_STATUS = "1";
	req_type = "MR";
	//Getting patient detaisl from MP_PATIENT table...start here
	if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
	sbSql.append("select b.name_prefix,b.first_name,b.second_name,b.third_name,");
	sbSql.append("b.family_name_prefix,b.family_name,b.name_suffix,b.patient_name,b.national_id_no");
	sbSql.append(" ,b.alt_id1_type,b.alt_id1_no,b.alt_id2_type,b.alt_id2_no,b.alt_id3_type,");
	sbSql.append("b.alt_id3_no,b.alt_id4_type,b.alt_id4_no,b.oth_alt_id_type, b.oth_alt_id_no,");
	sbSql.append("b.sex,decode (b.sex, 'm', 'male', 'f','female','u','unknown') gender from "); 
	sbSql.append(" mp_patient b where b.patient_id =?");
	pstmt = con.prepareStatement( sbSql.toString() );
	pstmt.setString(1, patient_id ) ;
	rset	= pstmt.executeQuery();
	while(rset.next())
	{
		name_prefix = checkForNull(rset.getString("name_prefix"));
		first_name = checkForNull(rset.getString("first_name"));
		second_name = checkForNull(rset.getString("second_name"));
		third_name = checkForNull(rset.getString("third_name"));
		family_name = checkForNull(rset.getString("family_name"));
		name_suffix = checkForNull(rset.getString("name_suffix"));
		patient_name = checkForNull(rset.getString("patient_name"));
		national_id_no = checkForNull(rset.getString("national_id_no"));
		alt_id1_type = checkForNull(rset.getString("alt_id1_type"));
		alt_id1_no = checkForNull(rset.getString("alt_id1_no"));
		alt_id2_type = checkForNull(rset.getString("alt_id2_type"));
		alt_id2_no = checkForNull(rset.getString("alt_id2_no"));
		alt_id3_type = checkForNull(rset.getString("alt_id3_type"));
		alt_id3_no = checkForNull(rset.getString("alt_id3_no"));
		alt_id4_type = checkForNull(rset.getString("alt_id4_type"));
		alt_id4_no = checkForNull(rset.getString("alt_id4_no"));
		oth_alt_id_type = checkForNull(rset.getString("oth_alt_id_type"));
		oth_alt_id_no = checkForNull(rset.getString("oth_alt_id_no"));
		sex = checkForNull(rset.getString("sex"));
	}

	if(rset != null) rset.close();
	if(pstmt != null) pstmt.close();
	
	if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
	sbSql.append(" insert into  MR_REPORT_REQUEST_HDR ");
	sbSql.append(" (REQUESTOR_CODE, REQUEST_STATUS, REMARKS, ");
	sbSql.append(" PREPARE_TEAM_ID, REQUESTING_PRACT_ID, PATIENT_ID, MED_BOARD_MEMBERS, "); sbSql.append(" FACILITY_ID, COLLECT_DATE, REQUEST_ID,");
	sbSql.append(" ADDED_FACILITY_ID,ADDED_DATE, ADDED_BY_ID, ADDED_AT_WS_NO,");
	sbSql.append(" MODIFIED_FACILITY_ID,MODIFIED_DATE,MODIFIED_BY_ID,MODIFIED_AT_WS_NO,"); 
	sbSql.append(" RELATIONSHIP_TYPE, ");
	sbSql.append(" APPL_ADDR_LINE1, APPL_ADDR_LINE2, APPL_ADDR_LINE3, APPL_ADDR_LINE4,");
	sbSql.append(" APPL_TOWN_CODE, APPL_AREA_CODE, APPL_REGION_CODE, ");
	sbSql.append(" APPL_POSTAL_CODE, APPL_COUNTRY_CODE, ");
	sbSql.append(" POSTED_ADDR_LINE1,POSTED_ADDR_LINE2,POSTED_ADDR_LINE3,POSTED_ADDR_LINE4,");
	sbSql.append(" POSTED_TOWN_CODE, POSTED_AREA_CODE, POSTED_REGION_CODE, ");
	sbSql.append(" POSTED_POSTAL_CODE, POSTED_COUNTRY_CODE, ");
	sbSql.append("RELATIONSHIP_CODE,REQUEST_TYPE,APPL_TYPE_CODE,APPL_NO,APPLICANT_NAME,");
	sbSql.append(" CONSENT_LETTER_APPL,APPLICATION_REF_NO,FOR_ATTN_OF,REPORT_TYPE_CODE,");
	sbSql.append(" SPECIALTY_CODE, APPL_STATUS, APPL_COMPLETION_DATE, ");
	sbSql.append(" REQUIRED_DOCS, MED_BOARD_TYPE_CODE, REQUEST_DATE, CHARGES_APPL_YN, ");
	sbSql.append("ADDL_CHARGES_YN, APPLICATION_DATE,NAME_PREFIX,FIRST_NAME, SECOND_NAME,");
	sbSql.append(" THIRD_NAME,FAMILY_NAME,NAME_SUFFIX,PATIENT_NAME,GENDER,NATIONAL_ID_NO,");
	sbSql.append(" ALT_ID1_TYPE,ALT_ID1_NO,ALT_ID2_TYPE,ALT_ID2_NO,ALT_ID3_TYPE, ");
	//OTHER_APPLICATION_REF_NO Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360
		if(classification_appl_yn.equals("true"))
		{ // added by mujafar for ML-MMOH-CRF-0762
			if(classification_ind.equals("N"))
			sbSql.append("ALT_ID3_NO,ALT_ID4_TYPE,ALT_ID4_NO,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO, AMOUNT, RECEIPT_NO, ADDL_AMOUNT, ADDL_RECEIPT_NO, ADDL_RECEIPT_DATE, RECEIPT_DATE, CHKLST_CONSENT_FR_PAT, CHKLST_IDENT_DOC, CHKLST_MARITAL_CERT, CHKLST_STAT_DEC, CHKLST_CONSENT_FR_EMBSY, CHKLST_PAYMENT, contact_no1, contact_no2, appl_email_id,OTHER_APPLICATION_REF_NO,NEXT_NATIONAL_ID_NO,NEXT_OTH_ALT_ID_TYPE,NEXT_OTH_ALT_ID_NO,REQUESTOR_TYPE_IND ) VALUES ( ");
			else
			if(classification_ind.equals("P"))
			sbSql.append("ALT_ID3_NO,ALT_ID4_TYPE,ALT_ID4_NO,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO, AMOUNT, RECEIPT_NO, ADDL_AMOUNT, ADDL_RECEIPT_NO, ADDL_RECEIPT_DATE, RECEIPT_DATE, CHKLST_CONSENT_FR_PAT, CHKLST_IDENT_DOC, CHKLST_MARITAL_CERT, CHKLST_STAT_DEC, CHKLST_CONSENT_FR_EMBSY, CHKLST_PAYMENT, contact_no1, contact_no2,appl_email_id,OTHER_APPLICATION_REF_NO,REQUESTOR_TYPE_IND ) VALUES ( ");	
			else
			sbSql.append("ALT_ID3_NO,ALT_ID4_TYPE,ALT_ID4_NO,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO, AMOUNT, RECEIPT_NO, ADDL_AMOUNT, ADDL_RECEIPT_NO, ADDL_RECEIPT_DATE, RECEIPT_DATE, CHKLST_CONSENT_FR_PAT, CHKLST_IDENT_DOC, CHKLST_MARITAL_CERT, CHKLST_STAT_DEC, CHKLST_CONSENT_FR_EMBSY, CHKLST_PAYMENT, contact_no1, contact_no2,appl_email_id,OTHER_APPLICATION_REF_NO, REQUESTOR_TYPE_IND ) VALUES ( ");
			
		}
		else
		{
			sbSql.append("ALT_ID3_NO,ALT_ID4_TYPE,ALT_ID4_NO,OTH_ALT_ID_TYPE,OTH_ALT_ID_NO, AMOUNT, RECEIPT_NO, ADDL_AMOUNT, ADDL_RECEIPT_NO, ADDL_RECEIPT_DATE, RECEIPT_DATE, CHKLST_CONSENT_FR_PAT, CHKLST_IDENT_DOC, CHKLST_MARITAL_CERT, CHKLST_STAT_DEC, CHKLST_CONSENT_FR_EMBSY, CHKLST_PAYMENT, contact_no1, contact_no2,appl_email_id,OTHER_APPLICATION_REF_NO ) VALUES ( ");
		}
	sbSql.append("?,?,?,?,?,?,?,"); 
	sbSql.append("?,to_date(?,'dd/mm/yyyy hh24:MI'), ?,");
	sbSql.append("?,sysdate,?,?,");
	sbSql.append("?,sysdate,?,?,?,"); 
	sbSql.append("?,?, ?,?,?,?,?,");
	sbSql.append("?,?,?,?,?,?,");
	sbSql.append("?,?,?,?,?,");
	sbSql.append("?,?,?,?,?,");
	sbSql.append("?,?, ?, ?,");
	sbSql.append("?,?,to_date(?,'dd/mm/yyyy hh24:MI'),?,?,sysdate,?,?,to_date(?,'dd/mm/yyyy hh24:MI') ");
	sbSql.append(",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:MI'), to_date(?,'dd/mm/yyyy hh24:MI'),?,?,?,?,?,?,?,?,?,? ");
	
	if(classification_appl_yn.equals("true"))
	{ // added by mujafar for ML-MMOH-CRF-0762
	
	if(classification_ind.equals("N"))
			sbSql.append(",?,?,? ");
	
			sbSql.append(",? ");
	
	}
	
	sbSql.append(" )");
	
	

	if (pstmt != null)  pstmt = null;
	pstmt = con.prepareStatement( sbSql.toString() );
	pstmt.setString(1, Requestor_Code ) ;
	pstmt.setString(2, REQUEST_STATUS ) ;
	pstmt.setString(3, remarks);
	pstmt.setString(4, team_id);
	pstmt.setString(5, practitioner_id);
	pstmt.setString(6, patient_id);
	pstmt.setString(7, MedicalMembers);
	pstmt.setString(8, addedFacilityId);
	pstmt.setString(9, collect_date);
	//pstmt.setInt   (10, req_id ) ;
	pstmt.setLong   (10, req_id ) ; //int to long Modified for ML-MMOH-CRF-0702
	pstmt.setString(11, addedFacilityId ) ;
	pstmt.setString(12, addedById);
	pstmt.setString(13, addedAtWorkstation ) ;
	pstmt.setString(14, modifiedFacilityId ) ;
	pstmt.setString(15, modifiedById ) ;
	pstmt.setString(16, modifiedAtWorkstation ) ;
	pstmt.setString(17, relationship_type ) ;
	pstmt.setString(18,appl_addr_line1 );
	pstmt.setString(19,appl_addr_line2 );
	pstmt.setString(20,appl_addr_line3 );
	pstmt.setString(21,appl_addr_line4 );
	pstmt.setString(22,appl_town_code );
	pstmt.setString(23,appl_area_code );
	pstmt.setString(24,appl_region_code );
	pstmt.setString(25,appl_postal_code );
	pstmt.setString(26,appl_country_code );
	pstmt.setString(27,del_addr_line1); 
	pstmt.setString(28,del_addr_line2); 
	pstmt.setString(29,del_addr_line3); 
	pstmt.setString(30,del_addr_line4); 
	pstmt.setString(31,del_res_town_code);
	pstmt.setString(32,del_res_area_code);
	pstmt.setString(33,del_region_code); 
	pstmt.setString(34,del_postal_code); 
	pstmt.setString(35,del_country_code);
	pstmt.setString(36,relationship); 
	pstmt.setString(37,req_type); 
	pstmt.setString(38,appl_type);
	pstmt.setString(39,appl_no); 
	pstmt.setString(40,appl_name);
	pstmt.setString(41,cons_letter);
	pstmt.setString(42,appl_refno); 
	pstmt.setString(43,for_attn); 
	pstmt.setString(44,rep_type); 
	pstmt.setString(45,dept_spl); 
	pstmt.setString(46,appl_status);
	pstmt.setString(47,appl_comp_dat);
	pstmt.setString(48,reqd_docs); 
	pstmt.setString(49,board_type);
	pstmt.setString(50,charges_appllicable_YN);
	pstmt.setString(51,additional_charges_YN);
	pstmt.setString(52,appln_date);
	pstmt.setString(53,name_prefix);
	pstmt.setString(54,first_name);
	pstmt.setString(55,second_name);
	pstmt.setString(56,third_name);
	pstmt.setString(57,family_name);
	pstmt.setString(58,name_suffix);
	
	if(classification_appl_yn.equals("true"))
	{ // added by mujafar for ML-MMOH-CRF-0762
	 if(classification_ind.equals("P"))
		pstmt.setString(59,appl_name);
	 else
		pstmt.setString(59,patient_name); 
	}
	else
	{
	pstmt.setString(59,patient_name);
	}
	pstmt.setString(60,sex);
	pstmt.setString(61,national_id_no);
	pstmt.setString(62,alt_id1_type);
	pstmt.setString(63,alt_id1_no);
	pstmt.setString(64,alt_id2_type);
	pstmt.setString(65,alt_id2_no);
	pstmt.setString(66,alt_id3_type);
	pstmt.setString(67,alt_id3_no);
	pstmt.setString(68,alt_id4_type);
	pstmt.setString(69,alt_id4_no);
	if(classification_appl_yn.equals("true"))
	{ // added by mujafar for ML-MMOH-CRF-0762
		if(classification_ind.equals("P"))
		{
			pstmt.setString(70,contact1_oth_alt_id_type);
			pstmt.setString(71,contact1_oth_alt_id_no);
			
		}
		else
		{
		pstmt.setString(70,oth_alt_id_type);
		pstmt.setString(71,oth_alt_id_no);
		}
	}
	else
	{
	pstmt.setString(70,oth_alt_id_type);
	pstmt.setString(71,oth_alt_id_no);
	}
	pstmt.setString(72,amount);
	pstmt.setString(73,receipt_no_str);
	pstmt.setString(74,addl_amount);
	pstmt.setString(75,addl_receipt_no_str);
	pstmt.setString(76,add_recp_dat);
	pstmt.setString(77,recp_dat);

	//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
	pstmt.setString(78,chklst_consent_fr_pat);
	pstmt.setString(79,chklst_ident_doc);
	pstmt.setString(80,chklst_marital_cert);
	pstmt.setString(81,chklst_stat_dec);
	pstmt.setString(82,chklst_consent_fr_embsy);
	pstmt.setString(83,chklst_payment);

	/*Added by Ashwini on 20-Nov-2017 for ML-MMOH-CRF-0707*/
	pstmt.setString(84,appl_contact_no1);
	pstmt.setString(85,appl_contact_no2);
	pstmt.setString(86,appl_email_id);
	pstmt.setString(87,other_application_ref_no);//Added By Dharma on 28/11/2019 against  ML-MMOH-CRF-1360 
	if(classification_appl_yn.equals("true"))
		{ // added by mujafar for ML-MMOH-CRF-0762
				if(classification_ind.equals("N"))
				{
				pstmt.setString(88,contact2_nat_id_no);
				pstmt.setString(89,contact1_oth_alt_id_type);
				pstmt.setString(90,contact1_oth_alt_id_no);
				pstmt.setString(91,req_type_ind);
				}
				else
				{
				pstmt.setString(88,req_type_ind);	
				}
			
		
		}
	
	

	count	= pstmt.executeUpdate();
	pstmt.close();

		if(count>0)
			result = true; 
		else 
			result = false;
		
		
		if(result)
		{
			if(classification_appl_yn.equals("true"))
			{ // added by mujafar for ML-MMOH-CRF-0762
				
				try{
					int count1=0;
					if(rset != null) rset.close();
					if(pstmt != null) pstmt.close();
					
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					
					sbSql.append(" insert into  MR_CHECK_LIST_HDR (REQUEST_ID,PATIENT_ID,FACILITY_ID,CHECK_LIST1_CODE,CHECK_LIST2_CODE,CHECK_LIST3_CODE,CHECK_LIST4_CODE,CHECK_LIST5_CODE,CHECK_LIST6_CODE,CHECK_LIST7_CODE,CHECK_LIST8_CODE,CHECK_LIST9_CODE,CHECK_LIST10_CODE,CHECK_LIST1_STATUS,CHECK_LIST2_STATUS,CHECK_LIST3_STATUS,CHECK_LIST4_STATUS,CHECK_LIST5_STATUS,CHECK_LIST6_STATUS,CHECK_LIST7_STATUS,CHECK_LIST8_STATUS,CHECK_LIST9_STATUS,CHECK_LIST10_STATUS, ");
					sbSql.append(" ADDED_FACILITY_ID,ADDED_DATE, ADDED_BY_ID, ADDED_AT_WS_NO,");
					sbSql.append(" MODIFIED_FACILITY_ID,MODIFIED_DATE,MODIFIED_BY_ID,MODIFIED_AT_WS_NO, CHECK_LIST11_CODE,CHECK_LIST12_CODE,CHECK_LIST13_CODE,CHECK_LIST14_CODE,CHECK_LIST15_CODE,CHECK_LIST16_CODE,CHECK_LIST17_CODE,CHECK_LIST18_CODE,CHECK_LIST19_CODE,CHECK_LIST20_CODE,CHECK_LIST21_CODE,CHECK_LIST22_CODE,CHECK_LIST23_CODE,CHECK_LIST24_CODE,CHECK_LIST25_CODE,CHECK_LIST11_STATUS,CHECK_LIST12_STATUS,CHECK_LIST13_STATUS,CHECK_LIST14_STATUS,CHECK_LIST15_STATUS,CHECK_LIST16_STATUS,CHECK_LIST17_STATUS,CHECK_LIST18_STATUS,CHECK_LIST19_STATUS,CHECK_LIST20_STATUS,CHECK_LIST21_STATUS,CHECK_LIST22_STATUS,CHECK_LIST23_STATUS,CHECK_LIST24_STATUS,CHECK_LIST25_STATUS) values ( "); //Modified by Kamatchi S by ML-MMOH-CRF-1464
					sbSql.append("?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); //Modified by Kamatchi S by ML-MMOH-CRF-1464
					
				if (pstmt != null)  pstmt = null;
				pstmt = con.prepareStatement( sbSql.toString() );
					
					pstmt.setLong (1, req_id ) ;
					pstmt.setString(2,patient_id); 
					pstmt.setString(3,addedFacilityId);
					
				pstmt.setString(4,chk_list_code0);
				pstmt.setString(5,chk_list_code1);
				pstmt.setString(6,chk_list_code2);
				pstmt.setString(7,chk_list_code3);
				pstmt.setString(8,chk_list_code4);
				pstmt.setString(9,chk_list_code5);
				pstmt.setString(10,chk_list_code6);
				pstmt.setString(11,chk_list_code7);
				pstmt.setString(12,chk_list_code8);
				pstmt.setString(13,chk_list_code9);
				
				
				pstmt.setString(14,chk_list_code_status0);
				pstmt.setString(15,chk_list_code_status1);
				pstmt.setString(16,chk_list_code_status2);
				pstmt.setString(17,chk_list_code_status3);
				pstmt.setString(18,chk_list_code_status4);
				pstmt.setString(19,chk_list_code_status5);
				pstmt.setString(20,chk_list_code_status6);
				pstmt.setString(21,chk_list_code_status7);
				pstmt.setString(22,chk_list_code_status8);
				pstmt.setString(23,chk_list_code_status9);
				
				pstmt.setString(24,addedFacilityId);
				pstmt.setString(25,addedById);
				pstmt.setString(26,addedAtWorkstation);
				pstmt.setString(27,modifiedFacilityId);
				pstmt.setString(28,modifiedById);
				pstmt.setString(29,modifiedAtWorkstation);
				//Modified by Kamatchi S by ML-MMOH-CRF-1464
				pstmt.setString(30,chk_list_code10);
				pstmt.setString(31,chk_list_code11);
				pstmt.setString(32,chk_list_code12);
				pstmt.setString(33,chk_list_code13);
				pstmt.setString(34,chk_list_code14);
				pstmt.setString(35,chk_list_code15);
				pstmt.setString(36,chk_list_code16);
				pstmt.setString(37,chk_list_code17);
				pstmt.setString(38,chk_list_code18);
				pstmt.setString(39,chk_list_code19);
				pstmt.setString(40,chk_list_code20);
				pstmt.setString(41,chk_list_code21);
				pstmt.setString(42,chk_list_code22);
				pstmt.setString(43,chk_list_code23);
				pstmt.setString(44,chk_list_code24);

				pstmt.setString(45,chk_list_code_status10);
				pstmt.setString(46,chk_list_code_status11);
				pstmt.setString(47,chk_list_code_status12);
				pstmt.setString(48,chk_list_code_status13);
				pstmt.setString(49,chk_list_code_status14);
				pstmt.setString(50,chk_list_code_status15);
				pstmt.setString(51,chk_list_code_status16);
				pstmt.setString(52,chk_list_code_status17);
				pstmt.setString(53,chk_list_code_status18);
				pstmt.setString(54,chk_list_code_status19);
				pstmt.setString(55,chk_list_code_status20);
				pstmt.setString(56,chk_list_code_status21);
				pstmt.setString(57,chk_list_code_status22);
				pstmt.setString(58,chk_list_code_status23);
				pstmt.setString(59,chk_list_code_status24);
				
				//Modified by Kamatchi S by ML-MMOH-CRF-1464
				count1	= pstmt.executeUpdate();
				pstmt.close();

				if(count1>0)
					result = true; 
				else 
					result = false;
					
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
					result = false;
				}
				
				
				
				
			}
			
			
			
			
			
			
		} // added by mujafar for ML-MMOH-CRF-0762 end
		
		

		//Added by Ashwini on 14-Jul-2017 for ML-MMOH-CRF-0702
		try
		{
			if(isreqIdFromSetup == true)
			{
			updtReqIDSql = " Update MR_REQUEST_ID_FOR_FCY set NEXT_SRL_NO = NEXT_SRL_NO + 1,MODIFIED_BY_ID='"+modifiedById+"',MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"',MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where facility_id = '"+facilityId+"' and year_num = to_number(to_char(sysdate,'rrrr')) ";
		
			updtReqIDStmt = con.createStatement() ;
			updtReqIdRS	= updtReqIDStmt.executeUpdate(updtReqIDSql) ;
			}
		}catch(Exception e1)
		{
			e1.printStackTrace();
			result = false;
		}
	}
	}catch(Exception e2)
	{
		e2.printStackTrace();
		sbMsg.append("Exception in inserting into MR_REPORT_REQUEST_HDR : " + e2);
		result = false;
	}
	if(result)
	{
		StringTokenizer tokens = new StringTokenizer (encounter_id,"|") ;
		int len = tokens.countTokens();
		String EncIDs="";
		for( int i=1;i<=len;i++ )
		{
			try
			{
				EncIDs = tokens.nextToken() ;
				EncounterID = Long.parseLong(EncIDs);

				//////////////////// SRL_NO & Req ID selection ///////////
				//int SRL_NO = 0;
				long SRL_NO = 0; //int to long Modified for ML-MMOH-CRF-0702
				String Sql=" SELECT NVL(MAX(SRL_NO),0)+1 FROM MR_REPORT_REQUEST_DTL WHERE FACILITY_ID = '"+facilityId+"'and request_id = '"+req_id+"' ";

				Stmt = con.createStatement() ;
				rset = Stmt.executeQuery(Sql) ;

				if( rset !=null )
				{
					while(rset.next())
					{
						//SRL_NO	= rset.getInt(1);
						SRL_NO	= rset.getLong(1); //int to long Modified for ML-MMOH-CRF-0702
					}
				}

				if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
				sbSql.append(" insert into  MR_REPORT_REQUEST_DTL ");
				sbSql.append("(REQUESTOR_CODE,ENCOUNTER_ID,PATIENT_ID,REQUEST_ID,SRL_NO,");
				sbSql.append(" FACILITY_ID,ADDED_FACILITY_ID, ADDED_DATE, ");
				sbSql.append(" ADDED_BY_ID, ADDED_AT_WS_NO, MODIFIED_FACILITY_ID, ");
				sbSql.append(" MODIFIED_DATE, MODIFIED_BY_ID, MODIFIED_AT_WS_NO) ");
				sbSql.append(" VALUES (?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,? ) ");

				if (pstmt != null)  pstmt = null;
				pstmt = con.prepareStatement( sbSql.toString() );

				pstmt.setString ( 1, Requestor_Code ) ;
				pstmt.setLong	( 2, EncounterID ) ;
				pstmt.setString ( 3, patient_id);
				pstmt.setLong	( 4, req_id); 
				//pstmt.setInt	( 5, SRL_NO);
				pstmt.setLong	( 5, SRL_NO); //int to long Modified for ML-MMOH-CRF-0702
				pstmt.setString ( 6, facilityId);
				pstmt.setString ( 7, addedFacilityId ) ;
				pstmt.setString ( 8, addedById);
				pstmt.setString ( 9, addedAtWorkstation ) ;
				pstmt.setString ( 10, modifiedFacilityId ) ;
				pstmt.setString ( 11, modifiedById ) ;
				pstmt.setString ( 12, modifiedAtWorkstation ) ;

				count2 = pstmt.executeUpdate();
				if(count2>0)
					result = true; 
				else 
					result = false;

			}catch(Exception e1)
			{
				e1.printStackTrace();
				sbMsg.append("Exception in inserting into MR_REPORT_REQUEST_DTL : " + e1);
				result = false;
			}
		}//		for(that enc id)
	}

try
{
	 //Added by Ashwini on 14-Jul-2017 for ML-MMOH-CRF-0702
	if(transContinue == true){
	if(result)
	{
		con.commit();
		result = true;
		java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
		sbMsg.append( (String) message.get("message") ) ;
		if ( message != null ) message.clear();
	 }
	else
	{
		result = false;
		con.rollback() ;
		sbMsg.append( " Error in EJB...Record Not Modified ") ;		
	}
	}
	
}catch(Exception Exe)
{
	Exe.printStackTrace();
	sbMsg.append( " Error in Commiting / Rollback ") ;
}
finally
{
	try
	{
		if(rs!=null)		rs.close();
		if(pstmt!=null)		pstmt.close();
		if(reqIDRS!=null)	reqIDRS.close();
		if(reqIDStmt!=null) reqIDStmt.close();
		if(rset!=null)		rset.close();
		if(Stmt!=null)		Stmt.close();

		if(con != null)      ConnectionManager.returnConnection(con,p);
	}catch(Exception e) 
	{
		e.printStackTrace();
	}
}
		//Integer Int_req_id	= new Integer(req_id);
		Long Int_req_id	= new Long(req_id); //int to long Modified for ML-MMOH-CRF-0702
		Str_req_id = Int_req_id.toString();

		HashMap results = new java.util.HashMap();
		results.put("status", new Boolean(result));
		results.put("error", sbMsg.toString()) ;
		results.put("req_id",Str_req_id);		
		return results ;
}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

public java.util.HashMap insertReviseRequestbean(java.util.Properties p,java.util.HashMap tableData)
{
	String patient_id				=	(String)tableData.get("patient_id"); 
	String Requestor_Code			=	(String)tableData.get("Requestor_Code"); 
	String revised_date				=	(String)tableData.get("revised_date"); 
	String Auth_by					=	(String)tableData.get("Auth_by"); 
	String reqst_id					=	(String)tableData.get("request_id"); 

	String addedById				=	(String)tableData.get("addedById"); 
	String modifiedById				=	(String)tableData.get("modifiedById"); 
	String addedFacilityId			=	(String)tableData.get("addedFacilityId"); 
	String modifiedFacilityId		=	(String)tableData.get("modifiedFacilityId"); 
	String addedAtWorkstation		=	(String)tableData.get("addedAtWorkstation"); 
	String modifiedAtWorkstation	=	(String)tableData.get("modifiedAtWorkstation"); 
	String facilityId				=	(String)tableData.get("facilityId"); 
	String locale					=	p.getProperty("LOCALE");

	StringBuffer sbSql = new StringBuffer();
	StringBuffer sbMsg = new StringBuffer();
	boolean	result		= true ;
	ResultSet reqIDRS	= null;
	Statement reqIDStmt	= null;
	Statement stmt	= null;

	//int to long Modified for ML-MMOH-CRF-0702
	//int SRL_NUM = 0;
	long SRL_NUM = 0;

try
{
	try
	{
		con = ConnectionManager.getConnection(p);
		con.setAutoCommit(false);

		String Sql=" SELECT NVL(MAX(SRL_NO),0)+1 FROM MR_REPORT_REQUEST_REV_DTL WHERE FACILITY_ID = '"+facilityId+"'and request_id = '"+reqst_id+"' ";

		Stmt = con.createStatement() ;
		rset = Stmt.executeQuery(Sql) ;

		if( rset !=null )
		{
			while(rset.next())
			{
				//SRL_NUM	= rset.getInt(1);
				SRL_NUM	= rset.getLong(1); //int to long Modified for ML-MMOH-CRF-0702
			}
		}
	}catch(Exception e1)
	{
		e1.printStackTrace();
		result = false;
		sbMsg.append( " Exception in request ID || Srl_no : "+e1) ;
	}

		sbSql.append(" insert into  mr_report_request_rev_dtl");
		sbSql.append("( facility_id, request_id, srl_no, patient_id, requestor_code,revised_date, auth_by_id, "); 
		sbSql.append(" ADDED_FACILITY_ID, ADDED_DATE, ADDED_BY_ID, ADDED_AT_WS_NO,");
		sbSql.append(" MODIFIED_FACILITY_ID, MODIFIED_DATE, MODIFIED_BY_ID, MODIFIED_AT_WS_NO) VALUES (?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:MI'),?,?,sysdate,?,?,?,sysdate,?,?)");
		if (pstmt != null)  pstmt.close();

		pstmt = con.prepareStatement( sbSql.toString() );
		pstmt.setString ( 1, addedFacilityId ) ;
		pstmt.setString ( 2, reqst_id ) ;
		//pstmt.setInt	( 3, SRL_NUM);
		pstmt.setLong	( 3, SRL_NUM); //int to long Modified for ML-MMOH-CRF-0702
		pstmt.setString ( 4, patient_id);
		pstmt.setString ( 5, Requestor_Code);
		pstmt.setString ( 6, revised_date);
		pstmt.setString ( 7, Auth_by);
		pstmt.setString ( 8, addedFacilityId ) ;
		pstmt.setString ( 9, addedById);
		pstmt.setString ( 10, addedAtWorkstation ) ;
		pstmt.setString ( 11, modifiedFacilityId ) ;
		pstmt.setString ( 12, modifiedById ) ;
		pstmt.setString ( 13, modifiedAtWorkstation ) ;

		count	= pstmt.executeUpdate();

		if(count>0)
			result = true; 
		else 
			result = false;

}catch(Exception e2)
{
	sbMsg.append(" Error in inserting into mr_report_request_rev_dtl: "+ e2);
	e2.printStackTrace();
	result = false;
}

try
{
	String sql = "";
	if(result)
	{
		if(patient_id.equals(""))
		{
			sql = " update MR_REPORT_REQUEST_HDR set revised_collect_date = to_date('"+revised_date+"','dd/mm/yyyy hh24:MI') ,MODIFIED_BY_ID='"+modifiedById+"',MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"',MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where facility_id='"+facilityId+"' and REQUEST_ID='"+reqst_id+"'"; 
		}
		else
		{
			sql = " update MR_REPORT_REQUEST_HDR set /* REQUEST_STATUS='0',*/ revised_collect_date = to_date('"+revised_date+"','dd/mm/yyyy hh24:MI'),MODIFIED_BY_ID='"+modifiedById+"',MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"',MODIFIED_FACILITY_ID='"+modifiedFacilityId+"' where facility_id='"+facilityId+"' and patient_id='"+patient_id+"' and REQUEST_ID='"+reqst_id+"'"; 
		}

		stmt = con.createStatement() ;
		int res11 = stmt.executeUpdate(sql);

		if(res11>0)
			result = true; 
		else 
			result = false;
	}
}catch(Exception upExe)
{
	sbMsg.append("Error updating MR_REPORT_REQUEST_HDR : "+upExe);
	upExe.printStackTrace();
}

try
{
	if(result)
	{
		con.commit();
		result =	true;
		java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
		sbMsg.append( (String) message.get("message"));
		if ( message != null ) message.clear();
	}
	else
	{
		result =	false;
		con.rollback() ;
		sbMsg.append(" Error in EJB...Record Not Modified ");
	}
	
}catch(Exception Exe)
{
	Exe.printStackTrace();
	sbMsg.append( " Error in Commiting / Rollback ") ;
}
finally
{
	try
	{
		if(rs!=null)		rs.close();
		if(pstmt!=null)		pstmt.close();
		if(reqIDRS!=null)	reqIDRS.close();
		if(reqIDStmt!=null) reqIDStmt.close();
		if(rset!=null)		rset.close();
		if(Stmt!=null)		Stmt.close();

		if(con != null)      ConnectionManager.returnConnection(con,p);
	}catch(Exception e) 
	{
		e.printStackTrace();
	}
}

		HashMap results = new java.util.HashMap() ;
		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sbMsg.toString() ) ;
		return results ;
	
}
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
} // end session bean
