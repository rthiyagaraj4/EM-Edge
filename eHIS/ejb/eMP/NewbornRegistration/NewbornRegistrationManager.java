/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/***  Last Modified Date TIle : 12/5/2005 3:48 PM ***/

package eMP.NewbornRegistration ;

import webbeans.eCommon.*;
import eCommon.Common.*;
import java.rmi.* ;
import java.util.* ;
import javax.ejb.* ;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*; 

/**
*
* @ejb.bean
*	name="NewbornRegistration"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="NewbornRegistration"
*	local-jndi-name="NewbornRegistration"
*	impl-class-name="eMP.NewbornRegistration.NewbornRegistrationManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eMP.NewbornRegistration.NewbornRegistrationLocal"
*	remote-class="eMP.NewbornRegistration.NewbornRegistrationRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eMP.NewbornRegistration.NewbornRegistrationLocalHome"
*	remote-class="eMP.NewbornRegistration.NewbornRegistrationHome"
*	generate= "local,remote"
*
*
*/

	public class NewbornRegistrationManager implements SessionBean 
	{


		SessionContext ctx;

	    public final String RECORD_INSERTED = "RECORD_INSERTED";
    
		public void ejbCreate() {}
		public void ejbRemove() {}
		public void ejbActivate() {}
		public void ejbPassivate() {}
   
		public void setSessionContext(SessionContext sessioncontext) 
		{
			ctx = sessioncontext;
		}

		

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    
public HashMap insertNewbornRegistration(Properties p,HashMap tabdata){

		Connection con				= null;
	
		Statement stmt1				= null;	
		PreparedStatement stmt		= null;
		PreparedStatement pstmt2	= null;
		PreparedStatement stmtz		= null;
	
		ResultSet resz				= null;
	
		ResultSet rset				= null;
	
		//String sql						= "";
		//String multisql					= "";
		String motherpatientid			= "";
		String active_yn				= "";
		String deceased_yn				= "";
		String patient_id				= "";
		//String relnshp					= "";
		String gender					= "";
		String hdRelnShp				= "";
		String bl_install_yn			= "";
		String sStyle					= "";
		String bl_success_msg	= "";

		String nb_name_prefix	= "";
		String nb_first_name	= "";
		String nb_second_name	= "";
		String nb_third_name	= "";
		String nb_family_name	= "";
		String nb_name_suffix	= "";
		String nb_patient_name	= "";
		String nb_name_prefix_loc_lang	= "";
		String nb_first_name_loc_lang	= "";
		String nb_second_name_loc_lang	= "";
		String nb_third_name_loc_lang	= "";
		String nb_family_name_loc_lang	= "";
		String nb_name_suffix_loc_lang	= "";
		String nb_patient_name_loc_lang	= "";
		String deriveBabyNameYN	= "N";
		String added_date= "Y";
		Boolean birth_order_format=false; //Added HSA-CRF-0304 [IN:054703]
		StringBuffer sql1 =new StringBuffer();
		 
		 
		
		Boolean newborn_birth_order=false; //This line added for this CRF MMS-ME-CRF-0006
		
		int multibabiesregistered	= 0;
		int tempflag				= 0;
		int numOfbaby				= 1;
		int birth_order				= 0;
		StringBuffer sbMessage = new StringBuffer("");
		StringBuffer insertsql = new StringBuffer("");
		StringBuffer sb  = new StringBuffer();
		StringBuffer am  = new StringBuffer();
		HashMap results = new HashMap() ;


	boolean result = false;
	String locale="";
	String localeName="";
	locale=p.getProperty("LOCALE");
	
		if(locale.equals("th"))
				localeName="th";
		else
				localeName="en";	
        

	try{
		//re initializing variables Starts
		//sql						= "";
		//multisql				= "";
		motherpatientid			= "";
		active_yn				= "";
		deceased_yn				= "";
		patient_id				= "";
		//relnshp					= "";
		gender					= "";
		hdRelnShp				= "";
		bl_install_yn			= "";
		sStyle					= "";
		bl_success_msg	= "";

		nb_name_prefix	= "";
		nb_first_name	= "";
		nb_second_name	= "";
		nb_third_name	= "";
		nb_family_name	= "";
		nb_name_suffix	= "";
		nb_patient_name	= "";
		nb_name_prefix_loc_lang	= "";
		nb_first_name_loc_lang	= "";
		nb_second_name_loc_lang	= "";
		nb_third_name_loc_lang	= "";
		nb_family_name_loc_lang	= "";
		nb_name_suffix_loc_lang	= "";
		nb_patient_name_loc_lang	= "";
		deriveBabyNameYN	= "N";
		sql1 =new StringBuffer();
		multibabiesregistered	= 0;
		tempflag				= 0;
		numOfbaby				= 1;
		birth_order				= 0;
		//re initializing variables Ends

 
		con = ConnectionManager.getConnection(p);
		String numberofbirths = (String)tabdata.get("no_of_birth");
		sStyle = (String)tabdata.get("sStyle");
		int noofbirths = Integer.parseInt(numberofbirths);
		int no_of_baby	= 0; 
		String calt_id1_no	= "";
		String idtype		= "";

		String emer_regn_nb_yn							= checkForNull((String)tabdata.get("emer_regn_nb_yn"),"N");//Added by Dharma on Aug 14th 2017 against ML-MMOH-CRF-0631 [IN:062148] 
		/*Added by Dharma on 4th June 2018 against ML-MMOH-CRF-0898 [IN:064757] Start*/
		String mother_witnessed_by1			= checkForNull((String)tabdata.get("mother_witnessed_by1"));
		String mother_witnessed_by2			= checkForNull((String)tabdata.get("mother_witnessed_by2"));
		String mother_alive_yn				= checkForNull((String)tabdata.get("mother_alive_yn"),"Y");
		/*Added by Dharma on 4th June 2018 against ML-MMOH-CRF-0898 [IN:064757] End*/
		String mnid							= checkForNull((String)tabdata.get("mthr_nat_id_no"));
		String malt_id1_no					= checkForNull((String)tabdata.get("mthr_alt_id1_no"));
		String malt_id1_type				= checkForNull((String)tabdata.get("mthr_alt_id1_type")); 		
		//int no_of_babies_regd = 0 ;
		/*added for CCRF 689 & 695 Strats*/
		String heart_rate_in_1_min			= (String)tabdata.get("heart_rate_in_1_min") ;
		String siteId						= (String)tabdata.get("siteId") ;
		String breathing_in_1_min			= (String)tabdata.get("breathing_in_1_min") ;
		String grimace_in_1_min				= (String)tabdata.get("grimace_in_1_min") ;
		String activity_in_1_min			= (String)tabdata.get("activity_in_1_min") ;
		String appearance_in_1_min			= (String)tabdata.get("appearance_in_1_min") ;
		String heart_rate_in_5_min			= (String)tabdata.get("heart_rate_in_5_min") ;
		String breathing_in_5_min			= (String)tabdata.get("breathing_in_5_min") ;
		String grimace_in_5_min				= (String)tabdata.get("grimace_in_5_min") ;
		String activity_in_5_min			= (String)tabdata.get("activity_in_5_min") ;
		String appearance_in_5_min			= (String)tabdata.get("appearance_in_5_min") ;
		String heart_rate_in_10_min			= (String)tabdata.get("heart_rate_in_10_min") ;
		String breathing_in_10_min			= (String)tabdata.get("breathing_in_10_min") ;
		String grimace_in_10_min			= (String)tabdata.get("grimace_in_10_min") ;
		String activity_in_10_min			= (String)tabdata.get("activity_in_10_min") ;
		String appearance_in_10_min			= (String)tabdata.get("appearance_in_10_min") ;
		String pract_id_still_birth			= (String)tabdata.get("pract_id_still_birth") ;
		String attendant_at_birth			= (String)tabdata.get("attendant_at_birth") ;
		String autopsy_reqd_yn				= (String)tabdata.get("autopsy_reqd_yn") ; 
		
		//Added for this CRF ML-MMOH-CRF-0621		
		if(autopsy_reqd_yn==null || autopsy_reqd_yn.equals("null") || autopsy_reqd_yn.equals("") )autopsy_reqd_yn="N"; 
		String parity_on_admission = (String)tabdata.get("parity_on_admission") ; 
		if(parity_on_admission==null || parity_on_admission.equals("null")) parity_on_admission=""; 
		String resuscit_attend_pract_id = (String)tabdata.get("resuscit_attend_pract_id") ; 
		if(resuscit_attend_pract_id==null || resuscit_attend_pract_id.equals("null")) resuscit_attend_pract_id=""; 
		
		//End  ML-MMOH-CRF-0621	
		
		
		String mate_cond_main_cod			= (String)tabdata.get("mate_cond_main_cod") ;
		String mate_cond_main_cod_dur		= (String)tabdata.get("mate_cond_main_cod_dur") ;
		String mate_cond_oth_cod			= (String)tabdata.get("mate_cond_oth_cod") ;
		String mate_cond_oth_cod_dur		= (String)tabdata.get("mate_cond_oth_cod_dur") ;
		String mate_cond_preexist_cod		= (String)tabdata.get("mate_cond_preexist_cod") ;
		String mate_cond_preexist_cod_dur	= (String)tabdata.get("mate_cond_preexist_cod_dur") ;
		String oth_rel_mate_cond_rel_cod	= (String)tabdata.get("oth_rel_mate_cond_rel_cod") ;
		String oth_rel_mate_cond_rel_cod_dur= (String)tabdata.get("oth_rel_mate_cond_rel_cod_dur") ;
		String cond_cau_dea_main_cod		= (String)tabdata.get("cond_cau_dea_main_cod") ;
		String cond_cau_dea_main_cod_dur	= (String)tabdata.get("cond_cau_dea_main_cod_dur") ;
		String cond_cau_dea_oth_cod			= (String)tabdata.get("cond_cau_dea_oth_cod") ;
		String cond_cau_dea_oth_cod_dur		= (String)tabdata.get("cond_cau_dea_oth_cod_dur") ;
		String cond_cau_dea_preexist_cod	= (String)tabdata.get("cond_cau_dea_preexist_cod") ;
		String cond_cau_dea_preexist_cod_dur= (String)tabdata.get("cond_cau_dea_preexist_cod_dur") ;
		String rel_cond_cau_dea_rel_cod		= (String)tabdata.get("rel_cond_cau_dea_rel_cod") ;
		String rel_cond_cau_dea_rel_cod_dur	= (String)tabdata.get("rel_cond_cau_dea_rel_cod_dur") ;
		
		String dflt_race_nat_setup_nb_as_per= "";
		String citizen_nationality_code		= "";
		String default_race_code			= "";
		String lmp_ca						="";
		int    next_del_seq_no				=1;
		/*added for CCRF 689 & 695 ends*/
		String pat_no_gen_yn	= (String)tabdata.get("pat_no_gen_yn") ;
		String patsergrpcode	= (String)tabdata.get("pat_ser_grp_code");
		String facilityId		= (String)tabdata.get("added_facility_id");
		String ip_install_yn	= (String)tabdata.get("ip_install_yn");
		String called_function	= (String)tabdata.get("called_function");
		String family_org_id_accept_yn_hd	= (String)tabdata.get("family_org_id_accept_yn_hd");				
		nb_patient_name	= checkForNull((String)tabdata.get("nb_patient_name"));	
		nb_patient_name_loc_lang = checkForNull((String)tabdata.get("nb_patient_name_loc_lang"));
		birth_order_format=CommonBean.isSiteSpecific(con, "MP","MP_NEWBORN_ORDER");//Mahesh HSA-CRF-0304 [IN:054703]
		
		//Added for this CRF MMS-ME-CRF-0006 
        String multi_birth_pat_name="";		
		newborn_birth_order=CommonBean.isSiteSpecific(con, "MP","MP_NEWBORN_BIRTH_ORDER");
		String multiple_birth_patname	= (String)tabdata.get("multiple_birth_patname");
		String nameprefix	= (String)tabdata.get("nameprefix");
		String firstNamederieved = (String)tabdata.get("firstNamederieved");
		String familyderievedName = (String)tabdata.get("familyderievedName");
		
		String first_name_local="";
		//String patient_name_local_family=""; //Commented for checkstyle
		//String patient_name_local_second=""; //Commented for checkstyle
		//String patient_name_local_third=""; //Commented for checkstyle
		String family_name_local="";
		String name_prefix_local="";
		String multi_birth_pat_name_local="";
        String patient_name_local="";  		
		
		//End MMS-ME-CRF-0006
		
		if(nb_patient_name.equals("") && nb_patient_name_loc_lang.equals(""))
			deriveBabyNameYN = "Y";				
			
		String site_or_facility	= "";
		String SRF              = "";
		patient_id				= (String)tabdata.get("patient_id") ;
		bl_install_yn			= (String)tabdata.get("bl_install_yn");
		String patnoctrl        = "";
		String p_err_msg        = "";
		CallableStatement cs = null;
		//Added MMS-QH-CRF-0145.1 [IN:047497]
		String date_of_birth_hj= (String)tabdata.get("date_of_birth_hj"); 

		boolean insertable = true;
		boolean newmotherFlag=true;

	MessageManager mess = new MessageManager();
	
	
		try{
			

			
			cs = con.prepareCall("{call generate_patient_id(?,?,?,?,?,?,?) }");
			

			if(pat_no_gen_yn.equals("Y")){
				stmt = con.prepareStatement("SELECT pat_no_ctrl, id_type FROM mp_pat_ser_grp WHERE pat_ser_grp_code = ?");
				stmt.setString(1,	patsergrpcode);
				rset = stmt.executeQuery();
				if(rset != null && rset.next()){
					patnoctrl = rset.getString("pat_no_ctrl") == null ? "" : rset.getString("pat_no_ctrl");
					idtype = rset.getString("id_type") == null ? "" : rset.getString("id_type"); 		
				}
				if(patnoctrl.equals("U")){
					if(stmt != null) stmt.close();
					if(rset != null) rset.close();
					cs.setString( 1 ,patsergrpcode);
					cs.setString( 2 ,(String)tabdata.get("facilityId"));
					cs.setString( 3 ,(String)tabdata.get("alt_id1_no"));
					cs.setString( 4 ,"");
					cs.setString( 5 ,(String)tabdata.get("nb_sex"));
					cs.registerOutParameter(6,Types.VARCHAR);
					cs.registerOutParameter(7,Types.VARCHAR);							
					SRF = facilityId;
					site_or_facility = "F";
				}else if(patnoctrl.equals("Z")){

					/*
					if(stmt != null) stmt.close();
					if(rset != null) rset.close();
					stmt = con.prepareStatement("SELECT site_id FROM sm_site_param");
					rset = stmt.executeQuery();
					rset.next();
					SRF = rset.getString(1);
					if(stmt != null) stmt.close();
					if(rset != null) rset.close();
					*/

				 	cs.setString( 1 ,patsergrpcode);
					cs.setString( 2 ,siteId );
					cs.setString( 3 ,(String)tabdata.get("alt_id1_no"));
					cs.setString( 4 ,"");
					cs.setString( 5 ,(String)tabdata.get("nb_sex"));
					cs.registerOutParameter(6,Types.VARCHAR);
					cs.registerOutParameter(7,Types.VARCHAR);
					site_or_facility = "S";
				}else if(patnoctrl.equals("N")){
					/*
					if(stmt != null) stmt.close();
					if(rset != null) rset.close();
					stmt = con.prepareStatement("SELECT site_id FROM sm_site_param");
					rset = stmt.executeQuery();
					rset.next();
					SRF = rset.getString(1);
					if(stmt != null) stmt.close();
					if(rset != null) rset.close();
					*/
					cs.setString( 1 ,patsergrpcode);
					cs.setString( 2 ,siteId );
					cs.setString( 3 ,(String)tabdata.get("alt_id1_no"));
					cs.setString( 4 ,"");
					cs.setString( 5 ,(String)tabdata.get("nb_sex"));
					cs.registerOutParameter(6,Types.VARCHAR);
					cs.registerOutParameter(7,Types.VARCHAR);
					site_or_facility = "N";
				}
				cs.execute();
				patient_id		= cs.getString(6);
				p_err_msg		= cs.getString(7);
				if (patient_id==null){
					patient_id = "";
				}
				if(p_err_msg==null){
					p_err_msg = "";
				}
				if(cs != null) cs.close();
				if (!p_err_msg.equals("")){
					insertable =  false;
					sb.append("Error in Gen Patient Id" + MessageManager.getMessage(locale,"ERROR_GEN_PAT_ID","MP")) ;
					insertable = false;
					throw new Exception("");
				}else{
					insertable = true;
				}						
			}else{
				if(stmt != null) stmt.close();
				if(rset != null) rset.close();
				stmt = con.prepareStatement("SELECT 1 FROM mp_birth_register WHERE patient_id = ?");
				stmt.setString(1,patient_id);
				rset = stmt.executeQuery();
				if(rset.next()){
					insertable = false;
					sb.append(MessageManager.getMessage(locale,"CODE_ALREADY_EXISTS", "MP"));
				}
				if(rset != null) rset.close();
				if (stmt != null) stmt.close();
			}
		}catch(Exception e){
			insertable = false;
			e.printStackTrace();
		}
	 
		String outcome_chk = (String)tabdata.get("outcome");
		if(outcome_chk.equals("L")){
			active_yn	= "Y";
			deceased_yn	= "N";
		}else{
			active_yn	= "N";
			deceased_yn	= "Y";
		}
		if(insertable){
			try{
				/*
				try{
					stmtw = con.prepareStatement("SELECT id_type FROM mp_pat_ser_grp WHERE pat_ser_grp_code = ? ");		
					stmtw.setString(1,	patsergrpcode);
					resw=stmtw.executeQuery();
					if(resw.next()){
						idtype = resw.getString(1);
						if(idtype == null) idtype = "";
					}
				}catch(Exception e){
					sb.append(e.toString());
					e.printStackTrace();
				}
				*/
				try{
					stmtz = con.prepareStatement("SELECT BIRTH_ORDER, NO_OF_MULTI_BABIES_REGD FROM mp_birth_register WHERE mother_patient_id = ? ORDER BY ADDED_DATE DESC");
					stmtz.setString(1, (String)tabdata.get("mother_patient_id"));
					resz = stmtz.executeQuery();
					if(resz!=null && resz.next()){
						multibabiesregistered = resz.getInt("NO_OF_MULTI_BABIES_REGD");
						birth_order = resz.getInt("BIRTH_ORDER");
						newmotherFlag=false;
					}								
				}catch(Exception e){
					sb.append( e.toString());
					e.printStackTrace();
				}
				stmtz = con.prepareStatement("select max(NVL(DEL_SEQ_NO,0)+1) NEXT_DEL_SEQ_NO from mp_birth_register where mother_patient_id=?");
				stmtz.setString(1, (String)tabdata.get("mother_patient_id"));
				if(resz!=null)resz.close();
				resz = stmtz.executeQuery();
				if(resz.next()){
					next_del_seq_no=resz.getInt("NEXT_DEL_SEQ_NO");
					if(next_del_seq_no ==0){
						next_del_seq_no=1;
					}
				}		
				if(multibabiesregistered == 0){
					if(newmotherFlag){
						numOfbaby = 1; 							
					}else{		// Added the below code for SRR20056-SCF-5747 [IN:024592] by Suresh M on 26.10.2010				
						stmtz = con.prepareStatement("select decode(trunc(added_date),trunc(sysdate),'N','Y') added_date from (SELECT max(added_date) added_date FROM mp_birth_register WHERE mother_patient_id =?)");
						stmtz.setString(1, (String)tabdata.get("mother_patient_id"));
						if(resz!=null)resz.close();
						resz = stmtz.executeQuery();
						if(resz.next()){
							added_date=resz.getString("added_date");	

						if(added_date.equals("N")){
							insertable = false;
							final java.util.Hashtable message = mess.getMessage( locale, "NEW_BORN_REG_DIFF_USER","MP" ) ;
							am.append( (String) message.get("message") );							
							message.clear();
						} else {
							insertable = true;							
						}						
				     }
				  } //Ends Suresh M
				}else if(multibabiesregistered > 0){
					numOfbaby = birth_order+1;	
					
					if(numOfbaby > 1){
						next_del_seq_no=next_del_seq_no-1;
					}
				}				
				/*
				try {
					stmty = con.prepareStatement(" SELECT national_id_no, alt_id1_no, ALT_ID1_TYPE FROM mp_patient WHERE patient_id = ? ");
					stmty.setString(1, (String)tabdata.get("mother_patient_id"));
					resy = stmty.executeQuery();
					if(resy.next()) 
					{ 									
						mnid = resy.getString(1);
						if(mnid == null) mnid = "";
									
						malt_id1_no = resy.getString("alt_id1_no");
						malt_id1_type = resy.getString("ALT_ID1_TYPE");
						if(malt_id1_no == null) malt_id1_no = ""; 								
					    if(malt_id1_type == null) malt_id1_type = ""; 	
					}
				} catch(Exception e) {
					sb.append(e.toString());
					e.printStackTrace();
    			}
				*/

				if((idtype.equals("N")) || (idtype.equals("A"))){
					/*
					try{
						stmty = con.prepareStatement(" SELECT national_id_no, alt_id1_no FROM mp_patient WHERE patient_id = ? ");
						stmty.setString(1, (String)tabdata.get("mother_patient_id"));
						resy = stmty.executeQuery();
						if(resy.next()){
							if(idtype.equals("N")){
								mnid = resy.getString(1);
								if(mnid == null) mnid = "";
							}
							if(idtype.equals("A")){
								malt_id1_no = resy.getString("alt_id1_no");
								if(malt_id1_no == null) malt_id1_no = "";
							}
						}
					}catch(Exception e){
						sb.append(e.toString());
						e.printStackTrace();
					}
					*/

					/*
					if(!mnid.equals("") || !malt_id1_no.equals("")) 
					{
					try 
					{
					stmtz = con.prepareStatement(" SELECT to_char(count(*)) AS total FROM mp_birth_register WHERE mother_patient_id = ? ");
					stmtz.setString(1, (String)tabdata.get("mother_patient_id"));

					resz = stmtz.executeQuery();
					if(resz.next()) 
					{
					no_of_baby = resz.getString(1);
					}
					if(!mnid.equals(""))
					if(!malt_id1_no.equals(""))
					calt_id1_no = malt_id1_no;
					sb.append("calt_id1_no"+ calt_id1_no);
					}
					catch(Exception e) 
					{
					sb.append( e.toString());
					e.printStackTrace();
					}

					}
					*/ 
						
					if(!mnid.equals("") || !malt_id1_no.equals("")) {
						no_of_baby = numOfbaby;
						if(!mnid.equals(""))
							if(!malt_id1_no.equals(""))
								calt_id1_no = malt_id1_no;
						sb.append("calt_id1_no"+ calt_id1_no);
					}					
				}
				//if(resx != null) resx.close();
			
				if(resz != null) resz.close();
				 if(stmtz != null)stmtz.close();
				//if(resw != null) resw.close();
			}catch(Exception e){
				insertable = false;
				sb.append(" Error in constructing the child national id");
				sb.append(e.toString());
				e.printStackTrace();
			}
		}
				if(insertable) 
				{

					try 
					{
						/*
						PreparedStatement st = con.prepareStatement("SELECT to_char(count(*)) AS total FROM mp_birth_register WHERE mother_patient_id = ?");
						st.setString(1,	(String)tabdata.get("mother_patient_id"));
						
						ResultSet rs=st.executeQuery();
						if(rs.next()) 
						{
							numOfbaby = rs.getInt(1);
							numOfbaby++;
						}
						else if(numOfbaby == 0) numOfbaby=numOfbaby+1;
						*/						
						
						String npmn					= checkForNull((String)tabdata.get("name_prefix_male_nb"));
						String npfn					= checkForNull((String)tabdata.get("name_prefix_female_nb"));
						String nsmn					= checkForNull((String)tabdata.get("name_suffix_male_nb"));
						String nsfn					= checkForNull((String)tabdata.get("name_suffix_female_nb"));
						String mp_suffix			= checkForNull((String)tabdata.get("name_suffix"));
						String mp_suffix_loc_lang	= "";
						String mp_prefix			= "";
						String mp_prefix_loc_lang	= "";
						
						dflt_race_nat_setup_nb_as_per = checkForNull((String)tabdata.get("dflt_race_nat_setup"));
						citizen_nationality_code = checkForNull((String)tabdata.get("citizen_nationality_code"));
						default_race_code = checkForNull((String)tabdata.get("default_race_code"));
						
						gender = (String)tabdata.get("nb_sex");

						if(gender.equals("F")) {
							//relnshp	= "NB_FEMALE_RELNSHIP  ";
							hdRelnShp = checkForNull((String)tabdata.get("nb_female_relnship"));
						} else if(gender.equals("M")) {
							//relnshp	= "NB_MALE_RELNSHIP  ";
							hdRelnShp = checkForNull((String)tabdata.get("nb_male_relnship"));
						} else if(gender.equals("U")) {
							//relnshp	= "NB_UNKNOWN_RELNSHIP  ";
							hdRelnShp = checkForNull((String)tabdata.get("nb_unknown_relnship"));
						}

						if(deriveBabyNameYN.equals("Y")) {

							if(!npmn.equals("") && gender.equals("M")) {
								mp_prefix_loc_lang = checkForNull((String)tabdata.get("name_pfx_loc_lang_male_nb"));
							} else if(!npfn.equals("") && gender.equals("F")) {
								mp_prefix_loc_lang = checkForNull((String)tabdata.get("name_pfx_loc_lang_female_nb"));	
							} 
							if(!nsmn.equals("") && gender.equals("M")) {
								mp_suffix_loc_lang = checkForNull((String)tabdata.get("name_sfx_loc_lang_male_nb"));
							}
							else if(!nsfn.equals("") && gender.equals("F")) {
								mp_suffix_loc_lang = checkForNull((String)tabdata.get("name_sfx_loc_lang_female_nb"));
							}
						}
						
						/*
						try 
						{
							stmtk = con.prepareStatement("SELECT name_prefix_male_nb, name_prefix_female_nb, name_suffix_male_nb, name_suffix_female_nb,"+relnshp +" ,DFLT_RACE_NAT_SETUP_NB_AS_PER,citizen_nationality_code,default_race_code FROM mp_param");
							rsetk = stmtk.executeQuery();
							
							mp_suffix = (String)tabdata.get("name_suffix");
							if(mp_suffix == null) mp_suffix = "";
							if(rsetk.next()) 
							{
								npmn = rsetk.getString(1);
								npfn = rsetk.getString(2);
								nsmn = rsetk.getString(3);
								nsfn = rsetk.getString(4);
								hdRelnShp = rsetk.getString(5);
								dflt_race_nat_setup_nb_as_per = rsetk.getString(6);
								citizen_nationality_code = rsetk.getString(7);
								default_race_code = rsetk.getString(8);

								if(npmn == null) npmn = "";
								if(npfn == null) npfn = "";
								if(nsmn == null) nsmn = "";
								if(nsfn == null) nsfn = "";
								if(hdRelnShp == null) hdRelnShp = "";
								if(hdRelnShp.equals(""))
								hdRelnShp = ((String)tabdata.get("sltRelationship")).trim();
								
							}
							if(rsetk != null) rsetk.close();
							if(stmtk != null) stmtk.close();
						}
						catch(Exception e) 
						{
							insertable = false;
							e.printStackTrace();
						} 						

						if(deriveBabyNameYN.equals("Y")) {

							try 
							{
								String sex = (String)tabdata.get("nb_sex");
								if(!npmn.equals("") && sex.equals("M")) 
								{
									stmtk = con.prepareStatement(" SELECT name_prefix_loc_lang FROM mp_name_prefix where name_prefix= ? AND prefix_sex IN ('M', 'B') ");
									stmtk.setString(1, npmn);
									rsetk = stmtk.executeQuery();
									if(rsetk.next()) 
									{
										mp_prefix_loc_lang = rsetk.getString(1);
										if(mp_prefix_loc_lang == null) mp_prefix_loc_lang = "";
									}
								}
								else if(!npfn.equals("") && sex.equals("F")) 
								{
									stmtk = con.prepareStatement(" SELECT name_prefix_loc_lang FROM mp_name_prefix WHERE name_prefix = ? AND prefix_sex IN ('F', 'B') ");
									stmtk.setString(1, npfn);
									rsetk = stmtk.executeQuery();
									if (rsetk.next()) 
									{
										mp_prefix_loc_lang = rsetk.getString(1);
										if(mp_prefix_loc_lang == null) mp_prefix_loc_lang = "";
									}
								}

	// this to get other lang suffix equivalet to english default suffix 
								if(!nsmn.equals("") && sex.equals("M")) 
								{
									stmtk = con.prepareStatement(" SELECT name_suffix_loc_lang FROM mp_name_suffix where name_suffix= ? and baby_suffix_yn='Y' AND BABY_SEX IN ('M', 'B') ");
									stmtk.setString(1, nsmn);
									rsetk = stmtk.executeQuery();
									if(rsetk.next()) 
									{
										mp_suffix_loc_lang = rsetk.getString(1);
										if(mp_suffix_loc_lang == null) mp_suffix_loc_lang = "";
									}
								}
								else if(!nsfn.equals("") && sex.equals("F")) 
								{
									stmtk = con.prepareStatement(" SELECT name_suffix_loc_lang FROM mp_name_suffix WHERE name_suffix = ? and baby_suffix_yn='Y' AND BABY_SEX IN ('F', 'B') ");
									stmtk.setString(1, nsfn);
									rsetk = stmtk.executeQuery();
									if (rsetk.next()) 
									{
										mp_suffix_loc_lang = rsetk.getString(1);
										if(mp_suffix_loc_lang == null) mp_suffix_loc_lang = "";
									}
								}


								if(rsetk != null) rsetk.close();
								if(stmtk != null) stmtk.close();
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						*/

						String extFamilyName = "";
						//Colums to be appended to select statement to added only at the end
						stmt = con.prepareStatement(" SELECT RACE_CODE, ETHNIC_GRP_CODE, CONTACT1_MODE,CONTACT1_STATUS, CONTACT1_NO, REGION_CODE, CONTACT2_MODE, CONTACT2_STATUS,CONTACT2_NO, CONTACT3_MODE,CONTACT3_STATUS, CONTACT3_NO, CONTACT4_MODE, CONTACT4_STATUS, CONTACT4_NO, CONTACT5_MODE, CONTACT5_STATUS, CONTACT5_NO, RES_AREA_CODE, RES_TOWN_CODE, RES_TOWN_DESC, GENERIC_SNDX_FIRST, GENERIC_SNDX_SECOND, GENERIC_SNDX_THIRD, GENERIC_SNDX_FAMILY, GENERIC_SNDX_FIRST_SECOND, GENERIC_SNDX_FIRST_FAMILY,ETHNIC_SNDX_FIRST, ETHNIC_SNDX_SECOND, ETHNIC_SNDX_THIRD, ETHNIC_SNDX_FAMILY, ETHNIC_SNDX_FIRST_SECOND, ETHNIC_SNDX_FIRST_FAMILY, RELGN_CODE, RELGN_SECT_CODE, NATIONALITY_CODE, PREF_FACILITY_ID, to_char(SYSDATE,'dd/mm/yyyy hh24:mi') sys_date, FIRST_NAME_LOC_LANG, SECOND_NAME_LOC_LANG, THIRD_NAME_LOC_LANG, FAMILY_NAME_LOC_LANG, PATIENT_NAME_LOC_LANG, FIRST_NAME, SECOND_NAME, THIRD_NAME, FAMILY_NAME, PATIENT_NAME, FAMILY_LINK_NO, citizen_yn, legal_yn FROM mp_patient WHERE patient_id = ?");
						
						stmt.setString(1,(String)tabdata.get("mother_patient_id"));
						rset = stmt.executeQuery();
						
						motherpatientid = (String)tabdata.get("mother_patient_id");
						if(rset.next()) 
						{
							String temp			= "";
							//String patientname	= "";
							String fln			= (String)tabdata.get("father_patient_id");

							if(fln == null||fln.equals("")) 
							{
								fln = (String)tabdata.get("mother_patient_id");
								if(fln == null) fln = "";
							}
							String sex = (String)tabdata.get("nb_sex");		
							

							if(noofbirths > 1) 
							{
								/*
								mstmt = con.createStatement();
								
								if(numOfbaby > 1) 
								{
									multisql = " SELECT min(no_of_multi_babies_regd) FROM mp_birth_register WHERE multiple_birth_yn = 'Y' AND mother_patient_id = '"+motherpatientid+"' AND no_of_multi_babies_regd > 0 ";
								}
								else 
								{
									multisql = " SELECT min(no_of_multi_babies_regd) FROM mp_birth_register WHERE multiple_birth_yn = 'Y' AND mother_patient_id = '"+motherpatientid+"'";
								}
								mrset = mstmt.executeQuery(multisql);

								
								if(mrset != null) 
								{
									if(mrset.next()) multibabiesregistered = mrset.getInt(1);
								}
								else 
								{
									multibabiesregistered = 0;
								}
								*/

								if(multibabiesregistered == 0) 
								{
									tempflag = noofbirths - 1; 									
									//int tempvar = (noofbirths - tempflag);
									//Below line added for this CRF MMS-ME-CRF-0006
									if(newborn_birth_order){
									extFamilyName =  "(" + 1 + "/" + noofbirths + ") "; 
									}else {
									extFamilyName =  " (" + 1 + "/" + noofbirths + ")" ; 
									}
									//End this CRF MMS-ME-CRF-0006
																	
								}
								if(multibabiesregistered > 0) 
								{
									tempflag = multibabiesregistered - 1;									
									int tempvar = noofbirths - tempflag;
									//Below line added for this CRF MMS-ME-CRF-0006
									if(newborn_birth_order){
									 extFamilyName = "(" + tempvar + "/" + noofbirths + ") " ; 
                                    }else{
									 extFamilyName = " (" + tempvar + "/" + noofbirths + ")" ; 
									}									
                                    //End MMS-ME-CRF-0006
									
								} 
								
								
							}
												
							if(sex.equals("F")) 
							{
								if(mp_suffix.equals("")) mp_suffix=nsfn;
								mp_prefix=npfn;
							}
							else if(sex.equals("M")) 
							{
								if(mp_suffix.equals("")) mp_suffix=nsmn;
								mp_prefix=npmn;
							}
							
							//String baby_patient_name = ""; 
							//String baby_patient_name_oth_lang = "";
						
						//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
						String nb_derv_logic_appl = (String)tabdata.get("nb_derv_logic_appl");
							
						/*Below line added for this CRF MMS-ME-CRF-0006*/						
						if(((deriveBabyNameYN.equals("Y")) || (noofbirths > 1 && birth_order_format==true) || (noofbirths > 1 && newborn_birth_order==true)) && (!nb_derv_logic_appl.equals("Y"))) { 											 
								String name_drvn_logic = (String)tabdata.get("name_dervn_logic");
								String name_dervn_logic_oth_lang = (String)tabdata.get("name_dervn_logic_oth_lang");
								
								
								StringTokenizer name_drvn_tokens = new StringTokenizer(name_drvn_logic, "+");
								while(name_drvn_tokens.hasMoreTokens())
								{
									String token_name = name_drvn_tokens.nextToken();
									if(token_name.equals("1N"))
									{
										if(rset.getString("FIRST_NAME") != null)
										{
											nb_patient_name = nb_patient_name+rset.getString("FIRST_NAME"); 
											
										}
									}
									else if(token_name.equals("2N"))
									{
										if(rset.getString("SECOND_NAME") != null)
										{
											nb_patient_name = nb_patient_name+rset.getString("SECOND_NAME");
											
										}
									}
									else if(token_name.equals("3N"))
									{
										if(rset.getString("THIRD_NAME") != null)
										{
											nb_patient_name = nb_patient_name+rset.getString("THIRD_NAME"); 
											
										}
									}
									else if(token_name.equals("FN"))
									{
									
									
										if(rset.getString("FAMILY_NAME") != null)
										{
										if(birth_order_format)
											{
											
											nb_patient_name = nb_patient_name+extFamilyName; 
											
											
											}
											else{	
											
											nb_patient_name = nb_patient_name+rset.getString("FAMILY_NAME")+extFamilyName;
											
																
										}
										}
									}
									else if(token_name.equals("PR"))
									{
										if(!mp_prefix.equals(""))
										{
											if(birth_order_format)
											{
											nb_patient_name = nb_patient_name;  
                                            											
											}
											else
											{
											nb_patient_name = mp_prefix+" "+nb_patient_name;  
                                           											
											}
										}
									}
									else if(token_name.equals("SF"))
									{
										if(!mp_suffix.equals(""))
										{
											nb_patient_name = nb_patient_name+mp_suffix; 
											
										}
									}
									else
									{
										if(!token_name.equals("1N") && !token_name.equals("2N") && !token_name.equals("3N") && !token_name.equals("FN") && !token_name.equals("PR") && !token_name.equals("SF"))
										{   
											int tokens_length = token_name.length(); 
											String separator_value = 	token_name.substring(1,tokens_length-1); 
											if(nb_patient_name.equals("")) separator_value = "";  
											nb_patient_name = nb_patient_name+separator_value;									
											
										}
									}
								}

								StringTokenizer name_drvn_tokens_oth_lang = new StringTokenizer(name_dervn_logic_oth_lang, "+");
								
								
								while(name_drvn_tokens_oth_lang.hasMoreTokens())
								{
									String token_name = name_drvn_tokens_oth_lang.nextToken();
									if(token_name.equals("1N"))
									{
										if(rset.getString("FIRST_NAME_LOC_LANG") != null)
										{
										    /*Below line added for this CRF MMS-ME-CRF-0006*/
												if(newborn_birth_order){
												      first_name_local = rset.getString("FIRST_NAME_LOC_LANG"); 
												}else{											
												      nb_patient_name_loc_lang = nb_patient_name_loc_lang+rset.getString("FIRST_NAME_LOC_LANG"); 
												}
											//End MMS-ME-CRF-0006
										}
									}
									else if(token_name.equals("2N"))
									{
										if(rset.getString("SECOND_NAME_LOC_LANG") != null)
										{
										   /*Below line added for this CRF MMS-ME-CRF-0006*/
										    if(newborn_birth_order){
										               //patient_name_local_second= rset.getString("SECOND_NAME_LOC_LANG");
													  patient_name_local=patient_name_local+rset.getString("SECOND_NAME_LOC_LANG")+" ";
										    }else {
											           nb_patient_name_loc_lang = nb_patient_name_loc_lang+rset.getString("SECOND_NAME_LOC_LANG");
											
											}
											//End MMS-ME-CRF-0006
										}
									}
									else if(token_name.equals("3N"))
									{
										if(rset.getString("THIRD_NAME_LOC_LANG") != null)
										{
											/*Below line added for this CRF MMS-ME-CRF-0006*/
										    if(newborn_birth_order){											
										           //patient_name_local_third = rset.getString("THIRD_NAME_LOC_LANG");
                                                   patient_name_local=patient_name_local+rset.getString("THIRD_NAME_LOC_LANG")+" ";												   
										    }else {											
											      nb_patient_name_loc_lang = nb_patient_name_loc_lang+rset.getString("THIRD_NAME_LOC_LANG"); 
											}
											//End this CRF MMS-ME-CRF-0006
										}
									}
									else if(token_name.equals("FN"))
									{
										if(rset.getString("FAMILY_NAME_LOC_LANG") != null)
										{
										if(birth_order_format)
											{
											
											nb_patient_name_loc_lang = nb_patient_name_loc_lang+extFamilyName; 
											/*Below line added for this CRF MMS-ME-CRF-0006*/
											}else if(newborn_birth_order){
											   family_name_local = rset.getString("FAMILY_NAME_LOC_LANG");											   
											   //patient_name_local_family=rset.getString("FAMILY_NAME_LOC_LANG");	
											   patient_name_local=patient_name_local+rset.getString("FAMILY_NAME_LOC_LANG")+" ";
											   
											}else{	
											 //End MMS-ME-CRF-0006
											nb_patient_name_loc_lang = nb_patient_name_loc_lang+rset.getString("FAMILY_NAME_LOC_LANG")+extFamilyName; 
											
											}
										}
									}
									else if(token_name.equals("PR"))
									{
										if(!mp_prefix.equals(""))
										{
										if(birth_order_format){
											nb_patient_name_loc_lang = nb_patient_name_loc_lang;       
										 /*Below line added for this CRF MMS-ME-CRF-0006*/	
										 }else if(newborn_birth_order){
										  
										  //name_prefix_local=mp_prefix_loc_lang;
										  name_prefix_local	= checkForNull((String)tabdata.get("nb_name_prefix_loc_lang"));
										  	
										}else{
										   //End this CRF MMS-ME-CRF-0006
										   nb_patient_name_loc_lang = mp_prefix+" "+nb_patient_name_loc_lang; 

											
											}	
										//nb_patient_name_loc_lang = nb_patient_name_loc_lang+mp_prefix_loc_lang; 
										}
									}
									else if(token_name.equals("SF"))
									{
										if(!mp_suffix.equals(""))
										{
											nb_patient_name_loc_lang = nb_patient_name_loc_lang+mp_suffix_loc_lang; 
										}
									}
									else
									{
										if(!token_name.equals("1N") && !token_name.equals("2N") && !token_name.equals("3N") && !token_name.equals("FN") && !token_name.equals("PR") && !token_name.equals("SF"))
										{
											int tokens_length = token_name.length();
											String separator_value = 	token_name.substring(1,tokens_length-1);
											if(nb_patient_name_loc_lang.equals("")) separator_value = "";
											nb_patient_name_loc_lang = nb_patient_name_loc_lang+separator_value;
										}
									}
								}

								if(((String)tabdata.get("pat_name_as_multipart_yn")).equals("N"))
									{
										if(nb_patient_name.length() > 60) 
										{
											nb_patient_name = nb_patient_name.substring(0,60);
											
										}
									}
								else 
								{
									
								/*Below line added for this CRF MMS-ME-CRF-0006*/
								if(newborn_birth_order){
								 								  
								    if(firstNamederieved.length()>14){
										  int patnamelength=20;
										  firstNamederieved=firstNamederieved.substring(0,patnamelength-extFamilyName.length());
										  firstNamederieved=extFamilyName+firstNamederieved;
								    }else if(firstNamederieved.length()==14){ 
										  firstNamederieved=firstNamederieved.substring(0, firstNamederieved.length()-1);
										  firstNamederieved=extFamilyName+firstNamederieved;
									}else{
									     firstNamederieved=extFamilyName+firstNamederieved;								  
								    }
									
								 multi_birth_pat_name=nameprefix+" "+firstNamederieved+multiple_birth_patname; 								   
								 if(multi_birth_pat_name.length() > 100 ) multi_birth_pat_name = multi_birth_pat_name.substring(0,100);
								 
								// String firstnameBirthOrder="";
								 //String firstname_local_lang="";
								 if(first_name_local.length()>14){
										  int patlocalnamelength=20;
										  first_name_local=first_name_local.substring(0,patlocalnamelength-extFamilyName.length());							  
										  first_name_local=extFamilyName+first_name_local;										 
								    }else if(first_name_local.length()==14){ 
										  first_name_local=first_name_local.substring(0, first_name_local.length()-1);										  
										  first_name_local=extFamilyName+first_name_local;										
									}else{
									      
									      first_name_local=extFamilyName+first_name_local;
                                         									  
								    }
								
								multi_birth_pat_name_local=name_prefix_local+" "+first_name_local+" "+patient_name_local;
								
								//multi_birth_pat_name_local=patient_name_local+" "+first_name_local+" "+name_prefix_local;
								
								
								if(multi_birth_pat_name_local.length() > 0) multi_birth_pat_name_local=multi_birth_pat_name_local.trim();
								
								if(multi_birth_pat_name_local.length() > 100 ) multi_birth_pat_name_local = multi_birth_pat_name_local.substring(0,100);
								
								}else{
										   if(nb_patient_name.length() > 40)
											{
												nb_patient_name = nb_patient_name.substring(0,40);
											}									
									}
									
									//End this CRF MMS-ME-CRF-0006
								} 					

								nb_first_name_loc_lang = checkForNull(rset.getString("FIRST_NAME_LOC_LANG"));
								nb_second_name_loc_lang = checkForNull(rset.getString("SECOND_NAME_LOC_LANG"));
								nb_third_name_loc_lang = checkForNull(rset.getString("THIRD_NAME_LOC_LANG"));
								nb_family_name_loc_lang = checkForNull(rset.getString("FAMILY_NAME_LOC_LANG"));
								
								if(noofbirths > 1 && !nb_family_name_loc_lang.equals("")) 
								{
								if(birth_order_format)
										{
									String nb_family_name_loc_lang1	= checkForNull((String)tabdata.get("FAMILY_NAME_LOC_LANG"));
									if(!nb_family_name_loc_lang1.equals(nb_family_name_loc_lang))
										{
										if(nb_family_name_loc_lang1.length()>70){
											nb_family_name_loc_lang1 = nb_family_name_loc_lang1.substring(0,70);
										}
										nb_family_name_loc_lang = nb_family_name_loc_lang1 + extFamilyName;
										}
									else
										{
										if(nb_family_name_loc_lang.length()>70){
											nb_family_name_loc_lang = nb_family_name_loc_lang.substring(0,70);
										}
										nb_family_name_loc_lang = nb_family_name_loc_lang + extFamilyName;
										}
										}
									else
										{
										nb_family_name_loc_lang = nb_family_name_loc_lang + extFamilyName;
										}
								}					
								
								nb_first_name = checkForNull(rset.getString("FIRST_NAME"));
								nb_second_name = checkForNull(rset.getString("SECOND_NAME"));
								nb_third_name = checkForNull(rset.getString("THIRD_NAME"));
								nb_family_name = checkForNull(rset.getString("FAMILY_NAME"));
								

								if(noofbirths > 1 && !nb_family_name.equals("")) 
								{
									if(birth_order_format)
										{
									String nb_family_name1	= checkForNull((String)tabdata.get("nb_family_name"));
									
									if(!nb_family_name1.equals(nb_family_name))
										{
										
										
										if(nb_family_name1.length()>70){
											nb_family_name1 = nb_family_name1.substring(0,70);
										}
										nb_family_name = nb_family_name1 + extFamilyName;
										
										}
									else
										{
										
										
										if(nb_family_name1.length()>70){
											nb_family_name = nb_family_name.substring(0,70);
										}
										nb_family_name = nb_family_name + extFamilyName;
																				
										
										}
										}
									else
										{
										
										
										nb_family_name = nb_family_name + extFamilyName;
										
										
										
										}
								}
								nb_name_prefix	= mp_prefix;
								nb_name_suffix	= mp_suffix;
								nb_name_prefix_loc_lang	= mp_prefix_loc_lang;
								nb_name_suffix_loc_lang	= mp_suffix_loc_lang;

							} else {

								nb_name_prefix	= checkForNull((String)tabdata.get("nb_name_prefix"));
								nb_first_name	= checkForNull((String)tabdata.get("nb_first_name"));
								nb_second_name	= checkForNull((String)tabdata.get("nb_second_name"));
								nb_third_name	= checkForNull((String)tabdata.get("nb_third_name"));
								nb_family_name	= checkForNull((String)tabdata.get("nb_family_name"));
								nb_name_suffix	= checkForNull((String)tabdata.get("nb_name_suffix"));
								nb_patient_name	= checkForNull((String)tabdata.get("nb_patient_name"));
								
								

								nb_name_prefix_loc_lang	= checkForNull((String)tabdata.get("nb_name_prefix_loc_lang"));
								nb_first_name_loc_lang	= checkForNull((String)tabdata.get("nb_first_name_loc_lang"));
								nb_second_name_loc_lang	= checkForNull((String)tabdata.get("nb_second_name_loc_lang"));
								nb_third_name_loc_lang	= checkForNull((String)tabdata.get("nb_third_name_loc_lang"));
								nb_family_name_loc_lang	= checkForNull((String)tabdata.get("nb_family_name_loc_lang"));
								nb_name_suffix_loc_lang	= checkForNull((String)tabdata.get("nb_name_suffix_loc_lang"));
								nb_patient_name_loc_lang = checkForNull((String)tabdata.get("nb_patient_name_loc_lang")); 
								
								
							}
						int j = 1;
                     
						
                        
                        String legal_yn = rset.getString("legal_yn") == null? "N" : rset.getString("legal_yn");
                        String citizen_yn = rset.getString("citizen_yn") == null ? "N" : rset.getString("citizen_yn");
                        if(sql1.length() > 0) sql1.delete(0,sql1.length());
                        //Colums to be appended to select statement to added only at the end

                        sql1.append("INSERT INTO mp_patient(PATIENT_ID, PAT_SER_GRP_CODE, RACE_CODE, ETHNIC_GRP_CODE, CONTACT1_MODE,CONTACT1_STATUS, CONTACT1_NO,REGION_CODE, CONTACT2_MODE, CONTACT2_STATUS, CONTACT2_NO, CONTACT3_MODE, CONTACT3_STATUS, CONTACT3_NO, CONTACT4_MODE, CONTACT4_STATUS, CONTACT4_NO, CONTACT5_MODE, CONTACT5_STATUS, CONTACT5_NO, RES_AREA_CODE, RES_TOWN_CODE, RES_TOWN_DESC, GENERIC_SNDX_FIRST, GENERIC_SNDX_SECOND, GENERIC_SNDX_THIRD, GENERIC_SNDX_FAMILY, GENERIC_SNDX_FIRST_SECOND, GENERIC_SNDX_FIRST_FAMILY, ETHNIC_SNDX_FIRST, ETHNIC_SNDX_SECOND, ETHNIC_SNDX_THIRD, ETHNIC_SNDX_FAMILY, ETHNIC_SNDX_FIRST_SECOND, ETHNIC_SNDX_FIRST_FAMILY, RELGN_CODE, RELGN_SECT_CODE, NATIONALITY_CODE, PREF_FACILITY_ID, REGN_DATE, FIRST_NAME_LOC_LANG, SECOND_NAME_LOC_LANG, THIRD_NAME_LOC_LANG, FAMILY_NAME_LOC_LANG, PATIENT_NAME_LOC_LANG, FIRST_NAME, SECOND_NAME, THIRD_NAME, FAMILY_NAME, SEX, DATE_OF_BIRTH, REGN_FACILITY_ID, EMEG_REGN_YN, INHOUSE_BIRTH_YN, ACTIVE_YN, SUSPEND_YN, DECEASED_YN, PATIENT_NAME, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, NEWBORN_ID_NO_SUFFIX, NAME_PREFIX, NAME_PREFIX_LOC_LANG, NAME_SUFFIX, FAMILY_LINK_NO, RELATIONSHIP_TO_HEAD, CITIZEN_YN, LEGAL_YN,  BED_ASSIGNED_FOR_NB_YN,FAMILY_ORG_ID,FAMILY_ORG_MEMBERSHIP,ALT_ID1_NO,pat_cat_code,PAT_CAT_CODE_EXP_DATE, mother_patient_id, family_org_sub_id, father_patient_id, name_suffix_loc_lang, ALT_ID1_TYPE,PATIENT_LONG_NAME,PATIENT_LONG_NAME_LOC_LANG ");
                        if(deceased_yn.equals("Y")) sql1.append(", DECEASED_DATE ");
                        sql1.append(" ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi'),?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr'),?,?,?,?,?,?,? "); 
                        if(deceased_yn.equals("Y")) { 
							sql1.append(",to_date(?,'dd/mm/rrrr hh24:mi')");
						}
                        sql1.append(")");
                        
                        pstmt2=con.prepareStatement(sql1.toString());
                        
                        pstmt2.setString(1,patient_id);//new born patient id
                        pstmt2.setString(2,patsergrpcode);

						for(int i=3;i<41;i++){
							temp = rset.getString(j)==null?"":rset.getString(j);									
							if(j == 1){//setting race code
								if(dflt_race_nat_setup_nb_as_per.equals("F")){
									if(!((String)tabdata.get("cboEthnicGroup")).equals("")){
										temp = (String)tabdata.get("cboEthnicGroup");
									}
								}else if(dflt_race_nat_setup_nb_as_per.equals("M")){
									temp = rset.getString("RACE_CODE")==null?"":rset.getString("RACE_CODE");
								}else if(dflt_race_nat_setup_nb_as_per.equals("P")){
									temp =default_race_code;
								}
							}
							if(j == 36){//setting nationality code
								if(dflt_race_nat_setup_nb_as_per.equals("F")){
									if(!((String)tabdata.get("cboNationality")).equals("")){
										temp = (String)tabdata.get("cboNationality");
									}
								}else if(dflt_race_nat_setup_nb_as_per.equals("M")){
									temp = rset.getString("NATIONALITY_CODE")==null?"":rset.getString("NATIONALITY_CODE");
								}else if(dflt_race_nat_setup_nb_as_per.equals("P")){
									temp=citizen_nationality_code;
								}
							}
							if(j==37){								
								temp = (String)tabdata.get("added_facility_id");
							}
							pstmt2.setString(i,temp);
							j++;
						}
			           
					   /*Below line added for this CRF MMS-ME-CRF-0006*/
					    if(newborn_birth_order && noofbirths > 1){ 
					    pstmt2.setString(41,first_name_local);
					    }else{
						pstmt2.setString(41,nb_first_name_loc_lang);
						}
						//End MMS-ME-CRF-0006
						pstmt2.setString(42,nb_second_name_loc_lang);
						pstmt2.setString(43,nb_third_name_loc_lang);
						/*Below line added for this CRF MMS-ME-CRF-0006*/
					    if(newborn_birth_order && noofbirths > 1){
                        pstmt2.setString(44,family_name_local);
                        }else{					
						pstmt2.setString(44,nb_family_name_loc_lang);
						}
						//End this CRF MMS-ME-CRF-0006
						
						/*Below line added for this CRF MMS-ME-CRF-0006*/
					    if(newborn_birth_order && noofbirths > 1){
						      pstmt2.setString(45,multi_birth_pat_name_local);
						}else {						
						      pstmt2.setString(45,nb_patient_name_loc_lang);
						}
						//End this CRF MMS-ME-CRF-0006
						/*Below line added for this CRF MMS-ME-CRF-0006*/
					    if(newborn_birth_order && noofbirths > 1){
                            pstmt2.setString(46,firstNamederieved);
                        }else{						
						    pstmt2.setString(46,nb_first_name);
						}
						//End this CRF MMS-ME-CRF-0006
						pstmt2.setString(47,nb_second_name);
						pstmt2.setString(48,nb_third_name);						
						/*Below line added for this CRF MMS-ME-CRF-0006*/
					    if(newborn_birth_order && noofbirths > 1){
						pstmt2.setString(49,familyderievedName);
						}else {
						pstmt2.setString(49,nb_family_name);					
						}						
                        //End this CRF	MMS-ME-CRF-0006					
						
                        String date_of_birth_temp = (String)tabdata.get("date_of_birth");

                        pstmt2.setString(50,(String)tabdata.get("nb_sex"));

                        pstmt2.setString(51,date_of_birth_temp);
                        pstmt2.setString(52,(String)tabdata.get("added_facility_id"));
                        pstmt2.setString(53,"N");
                        pstmt2.setString(54,(String)tabdata.get("inhouse_birth_yn"));
                        pstmt2.setString(55,active_yn);
                        pstmt2.setString(56,"N");
                        pstmt2.setString(57,deceased_yn);
						
						//Below line added for this CRF MMS-ME-CRF-0006
						if(newborn_birth_order && noofbirths > 1){
						pstmt2.setString(58,multi_birth_pat_name); 
                        }else{
						pstmt2.setString(58,nb_patient_name);
						}
						//End MMS-ME-CRF-0006
						
                        pstmt2.setString(59,(String)tabdata.get("added_by_id"));
                        pstmt2.setString(60,(String)tabdata.get("added_at_ws_no"));
                        pstmt2.setString(61,(String)tabdata.get("added_facility_id"));
                        pstmt2.setString(62,(String)tabdata.get("added_by_id"));
                        pstmt2.setString(63,(String)tabdata.get("added_at_ws_no"));
                        pstmt2.setString(64,(String)tabdata.get("added_facility_id"));
                        pstmt2.setInt(65,no_of_baby);

						if(family_org_id_accept_yn_hd.equals("Y")) {
							pstmt2.setString(66,(String)tabdata.get("sltRelationship"));
						} else {
						    
							//pstmt2.setString(66,nb_name_prefix);	
							/*Above line commented and below line added for this CRF MMS-ME-CRF-0006*/
							 pstmt2.setString(66,(String)tabdata.get("nb_name_prefix"));	
						}

						//pstmt2.setString(67,nb_name_prefix_loc_lang);
						/*Above line commented and below line added for this CRF MMS-ME-CRF-0006*/
						pstmt2.setString(67,(String)tabdata.get("nb_name_prefix_loc_lang"));
						
						pstmt2.setString(68,nb_name_suffix);						
						
						if(family_org_id_accept_yn_hd.equals("Y"))
						{
                           pstmt2.setString(69,(String)tabdata.get("HeadPatientid"));
                           pstmt2.setString(70,(String)tabdata.get("relation_child"));
						}
						else
						{
							 pstmt2.setString(69,fln);
                             pstmt2.setString(70,hdRelnShp);
						}
                        
                        pstmt2.setString(71,citizen_yn);
                        pstmt2.setString(72,legal_yn);

                        String baby_bed_number = (String)tabdata.get("bed_number");
                        String mother_bed_number = (String)tabdata.get("mother_bed_no");

                        if(!baby_bed_number.equals("")&&!mother_bed_number.equals(""))
                        {
							pstmt2.setString(73,"Y");
						}
                        else 
						{
						   pstmt2.setString(73,"N");
						}
                        pstmt2.setString(74,(String)tabdata.get("family_org_id"));
						pstmt2.setString(75,"2");

                        //pstmt2.setString(76,(String)tabdata.get("alt_id1_no"));						
                        pstmt2.setString(76,"");						
						pstmt2.setString(77,(String)tabdata.get("relation_child11"));
                        pstmt2.setString(78,(String)tabdata.get("exp_cat_date"));
						pstmt2.setString(79,(String)tabdata.get("mother_patient_id"));
						pstmt2.setString(80,(String)tabdata.get("family_org_sub_id"));
						pstmt2.setString(81,(String)tabdata.get("father_patient_id")); 
						 				
						pstmt2.setString(82,nb_name_suffix_loc_lang); 
						pstmt2.setString(83,malt_id1_type); 
						pstmt2.setString(84,(String)tabdata.get("nb_patient_long_name")); 
						pstmt2.setString(85,(String)tabdata.get("nb_patient_long_name_loc_lang")); 

                        if(deceased_yn.equals("Y"))	{ 
							pstmt2.setString(86,(String)tabdata.get("time_of_birth"));
						}
                        
                        int res2 = pstmt2.executeUpdate();

                        if(res2!=0){
                            insertable = true;
                        }else{
                            insertable = false;
                            sb.append(" Insert into mp_patient has failed");
                        }
						if(pstmt2!=null) pstmt2.close(); //checkstyle voilation
						if(insertable){
							if(outcome_chk.equals("S")){
								String stillBirthDtlsSql="insert into mp_still_birth_details(patient_id, auth_practitioner_id, attendant_at_birth, autopsy_reqd_yn, mate_cond_main_cod, mate_cond_main_cod_dur, mate_cond_oth_cod, mate_cond_oth_cod_dur, mate_cond_preexist_cod, mate_cond_preexist_cod_dur, oth_rel_mate_cond_rel_cod, oth_rel_mate_cond_rel_cod_dur, cond_cau_dea_main_cod, cond_cau_dea_main_cod_dur, cond_cau_dea_oth_cod, cond_cau_dea_oth_cod_dur, cond_cau_dea_preexist_cod, cond_cau_dea_preexist_cod_dur, rel_cond_cau_dea_rel_cod, rel_cond_cau_dea_rel_cod_dur,added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
								pstmt2=con.prepareStatement(stillBirthDtlsSql.toString());
								pstmt2.setString(1,patient_id);
								pstmt2.setString(2,pract_id_still_birth);
								pstmt2.setString(3,attendant_at_birth);
								pstmt2.setString(4,autopsy_reqd_yn);
								pstmt2.setString(5,mate_cond_main_cod);
								pstmt2.setString(6,mate_cond_main_cod_dur);
								pstmt2.setString(7,mate_cond_oth_cod);
								pstmt2.setString(8,mate_cond_oth_cod_dur);
								pstmt2.setString(9,mate_cond_preexist_cod);
								pstmt2.setString(10,mate_cond_preexist_cod_dur);
								pstmt2.setString(11,oth_rel_mate_cond_rel_cod);
								pstmt2.setString(12,oth_rel_mate_cond_rel_cod_dur);
								pstmt2.setString(13,cond_cau_dea_main_cod);
								pstmt2.setString(14,cond_cau_dea_main_cod_dur);
								pstmt2.setString(15,cond_cau_dea_oth_cod);
								pstmt2.setString(16,cond_cau_dea_oth_cod_dur);
								pstmt2.setString(17,cond_cau_dea_preexist_cod);
								pstmt2.setString(18,cond_cau_dea_preexist_cod_dur);
								pstmt2.setString(19,rel_cond_cau_dea_rel_cod);
								pstmt2.setString(20,rel_cond_cau_dea_rel_cod_dur);
								pstmt2.setString(21,(String)tabdata.get("added_by_id"));
								pstmt2.setString(22,(String)tabdata.get("added_at_ws_no"));
								pstmt2.setString(23,(String)tabdata.get("added_facility_id"));
								pstmt2.setString(24,(String)tabdata.get("added_by_id"));
								pstmt2.setString(25,(String)tabdata.get("added_at_ws_no"));
								pstmt2.setString(26,(String)tabdata.get("added_facility_id"));
								res2 = pstmt2.executeUpdate();
								if(res2!=0){
								insertable = true;
								}else{
									insertable = false;
									sb.append(" Insert into mp_still_birth_details has failed");
								}
							}
							if (rset!=null) rset.close();
							if (stmt!=null) stmt.close();
							if (stmt1!=null)stmt1.close();
						}
					}
                }
				catch(Exception ee) 
				{
                    insertable = false;
                    sb.append(ee.toString());
					ee.printStackTrace();
                }
            }
            if(insertable) 
			{

                try
				{
					//int m = 1;
					lmp_ca=(String)(tabdata.get("lmp_ca")==null?"":tabdata.get("lmp_ca"));
					String mc_cycle_no=(String)(tabdata.get("mc_cycle_no")==null?"":tabdata.get("mc_cycle_no"));
					if(lmp_ca.equals("")){
						mc_cycle_no="0";
					}
					/*Added by Rameswar on 17-Feb-16 for ML-MMOH-CRF-0383*/
						String	insquery ="";
						String	conquery ="";
						if(!(((String)tabdata.get("patency_of_anus_checked_by_id")).equals(""))) {
							insquery = " ,PATENCY_ANUS_CHECKED_DATE";
							conquery = " ,sysdate" ;
						}
					/*Added by Rameswar on 17-Feb-16 for ML-MMOH-CRF-0383*/
					/*Below line modified for this CRF ML-MMOH-CRF-0621*/
					//emer_regn_nb_yn Added by Dharma on Aug 14th 2017 against ML-MMOH-CRF-0631 [IN:062148]
					if(insertsql.length() > 0) insertsql.delete(0,insertsql.length());
                   insertsql.append(" INSERT INTO mp_birth_register(patient_id, pat_ser_grp_code, mother_patient_id, encounter_facility_id, mother_encounter_id, nb_sex, bba_yn, born_at, outcome, indicator_mark, time_of_birth, weight, weight_unit, circumference, circumference_unit, length, length_unit, gestational_period, gestational_unit, apgar_score, umbilical_cord_status, patency_of_anus_yn, multiple_birth_yn, birth_order, name_suffix, nod_type, gravida, parity, feeding, stools, complications, BCG_YN, attend_physician_id, attend_midwife_id, father_patient_id, father_name, remarks, added_by_id, added_date, added_facility_id, added_at_ws_no, modified_by_id, modified_date, modified_facility_id, modified_at_ws_no, chest_circumference, VITAMIN_K_YN, apgar_score_in_5_mins, community_nurse_id, compln_dely_code, umb_cord_cut_by, cong_anomalies_code, administered_by, administered_designation, father_national_id_no, father_oth_alt_id_type, father_oth_alt_id_no, father_nationality_code, father_ethnic_group_code, father_religion_code, father_ocpn_code, father_ocpn_class_code, father_remarks, FATHER_OCPN_DESC,  HEPB_YN, FATHER_GOVE_EMPLOYEE_YN, Mother_Pmi_no, Dely_ind_code, Proc_class_Code, Vaginal_dely_type_code, Dely_surg_class_code, birth_place_code, birth_certificate_no, vaccination_site, no_of_births, vitak_vacc_site, vitak_administered_by, vitak_administered_desig, hepb_vacc_site, hepb_administered_by, hepb_administered_desig, nb_compln_dely_code, chest_circum_unit , bcg_vacc_admn_date, vitk_vacc_admn_date, hepb_vacc_admn_date, apgar_score_in_10_mins, born_at_locn_type, born_at_locn_code, no_of_multi_babies_regd, father_alt_id1_type, father_alt_id1_no,antenatal_care_yn,ant_care_gvn_at,ant_care_locn_type,ant_care_locn_code,gestational_period_in_days,nb_name_prefix, nb_first_name, nb_second_name, nb_third_name, nb_family_name_prefix, nb_family_name, nb_name_suffix, nb_patient_name, nb_name_prefix_loc_lang, nb_first_name_loc_lang, nb_second_name_loc_lang, nb_third_name_loc_lang, nb_family_name_loc_lang, nb_name_suffix_loc_lang, nb_patient_name_loc_lang, father_name_prefix, father_first_name, father_second_name, father_third_name, father_family_name_prefix, father_family_name, father_name_suffix, father_patient_name, father_name_prefix_loc_lang, father_first_name_loc_lang, father_second_name_loc_lang, father_third_name_loc_lang, father_family_name_loc_lang, father_name_suffix_loc_lang, father_patient_name_loc_lang, finalized_yn, complns_1st_stage_labour_code, complns_2nd_stage_labour_code, complns_3rd_stage_labour_code, compln_pregnancy_code,compln_nr_pregnancy_code,Heart_Rate_In_1_Min,Heart_Rate_In_5_Min,Heart_Rate_In_10_Min,Breathing_In_1_Min,Breathing_In_5_Min,Breathing_In_10_Min,Grimace_In_1_Min,Grimace_In_5_Min,Grimace_In_10_Min,Activity_In_1_Min,Activity_In_5_Min,Activity_In_10_Min,Appearance_In_1_Min,Appearance_In_5_Min,Appearance_In_10_Min,lmp,mc_cycle_no,del_seq_no,father_pat_long_name,father_pat_long_name_loc_lang,nb_patient_long_name,nb_patient_long_name_loc_lang,HIJRI_BIRTH_DATE,father_alt_id2_type, father_alt_id2_no,father_alt_id3_type, father_alt_id3_no,father_alt_id4_type, father_alt_id4_no,MOTHER_ALT_ID1_TYPE,MOTHER_ALT_ID2_TYPE,MOTHER_ALT_ID3_TYPE,MOTHER_ALT_ID4_TYPE,MOTHER_ALT_ID2_NO,MOTHER_ALT_ID3_NO,MOTHER_ALT_ID4_NO,MOTHER_NATIONAL_ID_NO,MOTHER_OTH_ALT_ID_NO,MOTHER_OTH_ALT_ID_TYPE,PATENCY_OF_ANUS_CHECKED_BY,ACCESSION_NUM,parity_on_admission,resuscitated_pract_id,emer_regn_nb_yn,mother_witnessed_by1,mother_witnessed_by2,mother_alive_yn "+insquery+") values(?,?,?,?,?,?,?,?,?,?,to_date('"+(String)tabdata.get("date_of_birth")+"','dd/mm/yyyy hh24:mi:ss'), ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date('"+(String)tabdata.get("bcg_datetime")+"' , 'dd/mm/rrrr hh24:mi'), to_date('"+(String)tabdata.get("vitk_datetime")+"','dd/mm/rrrr hh24:mi'), to_date('"+(String)tabdata.get("hepb_datetime")+"','dd/mm/rrrr hh24:mi'), ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"+conquery+")"); 
                    //Modified by Rameswar on 20-Jan-16 for ML-MMOH-CRF-0382
					// PATENCY_ANUS_CHECKED_DATE is added in query by Rameswar on 17-Feb-16 for ML-MMOH-CRF-0383
					//Modified by Ashwini on 24-oct-2016 for MO-CRF-20108
                    stmt = con.prepareStatement(insertsql.toString());
                    stmt.setString(1,patient_id);
                    stmt.setString(2,(String)tabdata.get("pat_ser_grp_code"));
                    stmt.setString(3,(String)tabdata.get("mother_patient_id"));
                    stmt.setString(4,(String)tabdata.get("added_facility_id"));
                    stmt.setString(5,(String)tabdata.get("mother_encounter_id"));
                    stmt.setString(6,(String)tabdata.get("nb_sex"));
                    stmt.setString(7,(String)tabdata.get("bbayn"));
                    stmt.setString(8,(String)tabdata.get("born_at"));
                    stmt.setString(9,(String)tabdata.get("outcome"));
                    stmt.setString(10,(String)tabdata.get("indicator_mark"));
                    stmt.setString(11,(String)tabdata.get("weight"));
                    stmt.setString(12,(String)tabdata.get("weight_unit"));
                    stmt.setString(13,(String)tabdata.get("circumference"));
                    stmt.setString(14,(String)tabdata.get("circumference_unit"));
                    stmt.setString(15,(String)tabdata.get("length"));
                    stmt.setString(16,(String)tabdata.get("length_unit"));
                    stmt.setString(17,(String)tabdata.get("gestational_period"));
                    stmt.setString(18,(String)tabdata.get("gestational_unit"));
                    stmt.setString(19,(String)tabdata.get("apgar_score"));
                    stmt.setString(20,(String)tabdata.get("umbilical_cord_status"));
                    stmt.setString(21,(String)tabdata.get("patency_of_anus_yn"));
                    stmt.setString(22,(String)tabdata.get("multiple_birth_yn"));

                    stmt.setInt(23,numOfbaby);
                    stmt.setString(24,(String)tabdata.get("name_suffix"));
                    stmt.setString(25,(String)tabdata.get("nod_type"));
                    stmt.setString(26,(String)tabdata.get("gravida"));
                    stmt.setString(27,(String)tabdata.get("parity"));
                    stmt.setString(28,(String)tabdata.get("feeding"));
                    stmt.setString(29,(String)tabdata.get("stools"));
                    stmt.setString(30,(String)tabdata.get("complications"));
                    stmt.setString(31,(String)tabdata.get("bcg_given_yn"));
                    stmt.setString(32,(String)tabdata.get("attend_physician_id"));
                    stmt.setString(33,(String)tabdata.get("attend_midwife_id"));
                    stmt.setString(34,(String)tabdata.get("father_patient_id"));
                    stmt.setString(35,(String)tabdata.get("father_name"));
                    stmt.setString(36,(String)tabdata.get("remarks"));
                    stmt.setString(37,(String)tabdata.get("added_by_id"));
                    stmt.setString(38,(String)tabdata.get("added_facility_id"));
                    stmt.setString(39,(String)tabdata.get("added_at_ws_no"));
                    stmt.setString(40,(String)tabdata.get("added_by_id"));
                    stmt.setString(41,(String)tabdata.get("added_facility_id"));
                    stmt.setString(42,(String)tabdata.get("added_at_ws_no"));
                    stmt.setString(43,(String)tabdata.get("chest_circumference"));
                    stmt.setString(44,(String)tabdata.get("vitak_given_yn"));
                    stmt.setString(45,(String)tabdata.get("apgar_score_in_5_mins"));
                    stmt.setString(46,(String)tabdata.get("community_nurse"));
                    stmt.setString(47,(String)tabdata.get("complications_delivery"));
                    stmt.setString(48,(String)tabdata.get("Umb_cord_cut_by"));
                    stmt.setString(49,(String)tabdata.get("Congenital_Anomalies"));
                    stmt.setString(50,(String)tabdata.get("administeredBy"));
                    stmt.setString(51,(String)tabdata.get("Designation"));
                    stmt.setString(52,(String)tabdata.get("National_id"));
                    stmt.setString(53,(String)tabdata.get("cboOtherAltID"));
                    stmt.setString(54,(String)tabdata.get("txtOtherAltID"));
                    stmt.setString(55,(String)tabdata.get("cboNationality"));
                    stmt.setString(56,(String)tabdata.get("cboEthnicGroup"));
                    stmt.setString(57,(String)tabdata.get("cboReligion"));
                    stmt.setString(58,(String)tabdata.get("cboOccupation"));
                    stmt.setString(59,(String)tabdata.get("cboOccupationClass"));
                    stmt.setString(60,(String)tabdata.get("fatherRemarks"));
                    stmt.setString(61,(String)tabdata.get("Occupation_Desc"));
                    stmt.setString(62,(String)tabdata.get("hep_given_yn"));
                    stmt.setString(63,(String)tabdata.get("fthGovtEmpl"));
                    stmt.setString(64,(String)tabdata.get("Mother_Pmi_no"));
                    stmt.setString(65,(String)tabdata.get("Dely_ind_code"));
                    stmt.setString(66,(String)tabdata.get("Proc_class_Code"));
                    stmt.setString(67,(String)tabdata.get("Vaginal_dely_type_code"));
                    stmt.setString(68,(String)tabdata.get("Dely_surg_class_code"));
                    stmt.setString(69,(String)tabdata.get("birth_place_code"));
                    stmt.setString(70,(String)tabdata.get("birth_certificate_no"));
                    stmt.setString(71,(String)tabdata.get("vaccination_site"));
                    stmt.setString(72,(String)tabdata.get("no_of_birth"));
                    stmt.setString(73,(String)tabdata.get("vitak_vacc_site"));
                    stmt.setString(74,(String)tabdata.get("vitak_administered_By"));
                    stmt.setString(75,(String)tabdata.get("vitak_administered_Designation"));
                    stmt.setString(76,(String)tabdata.get("hepb_vacc_site"));
                    stmt.setString(77,(String)tabdata.get("hepb_administered_By"));
                    stmt.setString(78,(String)tabdata.get("hepb_administered_Designation"));
                    stmt.setString(79,(String)tabdata.get("nb_complication_delivery"));
                    stmt.setString(80,(String)tabdata.get("chest_circumference_unit"));
                    stmt.setString(81,(String)tabdata.get("apgar_score_in_10_mins"));
                    stmt.setString(82,(String)tabdata.get("born_at_locn_type"));
                    stmt.setString(83,(String)tabdata.get("born_at_locn_code"));
				    stmt.setInt(84,tempflag);
					stmt.setString(85,(String)tabdata.get("father_alt_id1_desc"));
                    stmt.setString(86,(String)tabdata.get("father_alt_id1_no"));
                    stmt.setString(87,(String)tabdata.get("antenatal_care"));
                    stmt.setString(88,(String)tabdata.get("ate_born_where"));
                    stmt.setString(89,(String)tabdata.get("ate_born_at_locn_type"));
                    stmt.setString(90,(String)tabdata.get("ate_born_at_locn_code"));               
                    stmt.setString(91,(String)tabdata.get("gestational_period_days"));				

                    //stmt.setString(92, nb_name_prefix); 
					/*Above line commented and below line added for this CRF MMS-ME-CRF-0006*/
					 stmt.setString(92, (String)tabdata.get("nb_name_prefix")); 
					
					//Below line added for this CRF MMS-ME-CRF-0006
					if(newborn_birth_order && noofbirths > 1){
					 stmt.setString(93, firstNamederieved);
					}else{
                     stmt.setString(93, nb_first_name); 
					}
					//End this CRF MMS-ME-CRF-0006
                    stmt.setString(94, nb_second_name); 
                    stmt.setString(95, nb_third_name); 
                    stmt.setString(96,(String)tabdata.get("nb_family_name_prefix")); 
					//Added for this CRF MMS-ME-CRF-0006
					if(newborn_birth_order && noofbirths > 1){
					stmt.setString(97, familyderievedName); 
					}else{
                    stmt.setString(97, nb_family_name); 
					}
					//End this CRF MMS-ME-CRF-0006
                    stmt.setString(98, nb_name_suffix); 
                    
					//Below line added for this CRF MMS-ME-CRF-0006
					if(newborn_birth_order && noofbirths > 1){
						stmt.setString(99,multi_birth_pat_name); 
                    }else{					
					    stmt.setString(99, nb_patient_name); 
					}
										
					//End this CRF MMS-ME-CRF-0006
					
                    //stmt.setString(100, nb_name_prefix_loc_lang); 
					/*Above line commented and below line added for this CRF MMS-ME-CRF-0006*/
					stmt.setString(100, (String)tabdata.get("nb_name_prefix_loc_lang")); 
					
					
					//Below line added for this CRF MMS-ME-CRF-0006
					if(newborn_birth_order && noofbirths > 1){
					stmt.setString(101, first_name_local); 
					}else{
					stmt.setString(101, nb_first_name_loc_lang); 
					}
                    //End MMS-ME-CRF-0006
                    stmt.setString(102, nb_second_name_loc_lang); 
                    stmt.setString(103, nb_third_name_loc_lang); 
					//Below line added for this CRF MMS-ME-CRF-0006
					if(newborn_birth_order && noofbirths > 1){					
                      stmt.setString(104, family_name_local);
                    }else{
					 stmt.setString(104, nb_family_name_loc_lang);
					}
                    //End MMS-ME-CRF-0006					
                    stmt.setString(105, nb_name_suffix_loc_lang); 
					
					//Below line added for this CRF MMS-ME-CRF-0006
					if(newborn_birth_order && noofbirths > 1){					
                    stmt.setString(106, multi_birth_pat_name_local);
                    }else{
					stmt.setString(106, nb_patient_name_loc_lang);
					}
                    //End MMS-ME-CRF-0006 					

                    stmt.setString(107,(String)tabdata.get("father_name_prefix")); 
                    stmt.setString(108,(String)tabdata.get("father_first_name")); 
                    stmt.setString(109,(String)tabdata.get("father_second_name")); 
                    stmt.setString(110,(String)tabdata.get("father_third_name")); 
                    stmt.setString(111,(String)tabdata.get("father_family_name_prefix")); 
                    stmt.setString(112,(String)tabdata.get("father_family_name")); 
                    stmt.setString(113,(String)tabdata.get("father_name_suffix")); 
                    stmt.setString(114,(String)tabdata.get("father_patient_name")); 
                    stmt.setString(115,(String)tabdata.get("father_name_prefix_loc_lang")); 
                    stmt.setString(116,(String)tabdata.get("father_first_name_loc_lang")); 
                    stmt.setString(117,(String)tabdata.get("father_second_name_loc_lang")); 
                    stmt.setString(118,(String)tabdata.get("father_third_name_loc_lang")); 
                    stmt.setString(119,(String)tabdata.get("father_family_name_loc_lang")); 
                    stmt.setString(120,(String)tabdata.get("father_name_suffix_loc_lang")); 
                    stmt.setString(121,(String)tabdata.get("father_patient_name_loc_lang"));
					
					stmt.setString(122,(String)tabdata.get("finalized_yn")); 
                    stmt.setString(123,(String)tabdata.get("complns_1st_stage_labour_code")); 
                    stmt.setString(124,(String)tabdata.get("complns_2nd_stage_labour_code")); 
                    stmt.setString(125,(String)tabdata.get("complns_3rd_stage_labour_code")); 
                    stmt.setString(126,(String)tabdata.get("compln_pregnancy_code")); 
                    stmt.setString(127,(String)tabdata.get("compln_nr_pregnancy_code")); 
                    stmt.setString(128,heart_rate_in_1_min); 
                    stmt.setString(129,heart_rate_in_5_min); 
                    stmt.setString(130,heart_rate_in_10_min); 
                    stmt.setString(131,breathing_in_1_min); 
                    stmt.setString(132,breathing_in_5_min); 
                    stmt.setString(133,breathing_in_10_min); 
                    stmt.setString(134,grimace_in_1_min); 
                    stmt.setString(135,grimace_in_5_min); 
                    stmt.setString(136,grimace_in_10_min); 
                    stmt.setString(137,activity_in_1_min); 
                    stmt.setString(138,activity_in_5_min); 
                    stmt.setString(139,activity_in_10_min); 
                    stmt.setString(140,appearance_in_1_min); 
                    stmt.setString(141,appearance_in_5_min); 
                    stmt.setString(142,appearance_in_10_min); 
                    stmt.setString(143,lmp_ca); 
                    stmt.setString(144,mc_cycle_no); 
                    stmt.setInt(145,next_del_seq_no); 
                    stmt.setString(146,(String)tabdata.get("father_pat_long_name")); 
                    stmt.setString(147,(String)tabdata.get("father_pat_long_name_loc_lang")); 
                    stmt.setString(148,(String)tabdata.get("nb_patient_long_name")); 
                    stmt.setString(149,(String)tabdata.get("nb_patient_long_name_loc_lang")); 
					//Added for this CRF MMS-QH-CRF-0145.1 [IN:047497]
				    stmt.setString(150,date_of_birth_hj); 
				    stmt.setString(151,(String)tabdata.get("father_alt_id2_desc"));
                    stmt.setString(152,(String)tabdata.get("father_alt_id2_no"));
                    stmt.setString(153,(String)tabdata.get("father_alt_id3_desc"));
                    stmt.setString(154,(String)tabdata.get("father_alt_id3_no"));
                    stmt.setString(155,(String)tabdata.get("father_alt_id4_desc"));
                    stmt.setString(156,(String)tabdata.get("father_alt_id4_no"));
                    stmt.setString(157,(String)tabdata.get("father_alt_id1_desc"));
                    stmt.setString(158,(String)tabdata.get("father_alt_id2_desc"));
                    stmt.setString(159,(String)tabdata.get("father_alt_id3_desc")); 
                    stmt.setString(160,(String)tabdata.get("father_alt_id4_desc"));
                    stmt.setString(161,(String)tabdata.get("mthr_alt_id2_no"));
                    stmt.setString(162,(String)tabdata.get("mthr_alt_id3_no"));
                    stmt.setString(163,(String)tabdata.get("mthr_alt_id4_no"));
                    stmt.setString(164,(String)tabdata.get("mthr_nat_id_no"));
                    stmt.setString(165,(String)tabdata.get("mthr_oth_alt_id_No"));
                    stmt.setString(166,(String)tabdata.get("oth_alt_id_type"));

					stmt.setString(167,(String)tabdata.get("patency_of_anus_checked_by_id")); //Added by Rameswar on 20-Jan-16 for ML-MMOH-CRF-0382
					//check
					stmt.setString(168,(String)tabdata.get("sel_accession_num"));//Added by Ashwini on 24-oct-2016 for MO-CRF-20108
					/*Below line added for this CRF ML-MMOH-CRF-0621*/
					stmt.setString(169,(String)tabdata.get("parity_on_admission"));
					stmt.setString(170,(String)tabdata.get("resuscit_attend_pract_id"));
					stmt.setString(171,emer_regn_nb_yn);
					/*Added by Dharma on 4th June 2018 against ML-MMOH-CRF-0898 [IN:064757] Start*/
					stmt.setString(172,mother_witnessed_by1);
					stmt.setString(173,mother_witnessed_by2);
					stmt.setString(174,mother_alive_yn);
					/*Added by Dharma on 4th June 2018 against ML-MMOH-CRF-0898 [IN:064757] End*/
					

					int res2 =0;
                  
                    if(numOfbaby<=99)
					{						
                        res2= stmt.executeUpdate();
                    }
                    if(res2 != 0)
					{	
                        insertable = true;
                    }
					else
					{						
						insertable = false;
                        if(numOfbaby > 99)
						{
                           /* java.util.Hashtable ht= MessageManager.getMessage(locale,"BIRTH_ORDER_EXCEEDED","");
                            String mess=(String) ht.get("message");
                            mess = mess.substring(mess.indexOf("=")+1);
                            mess = mess.substring(0,(mess.length()) -2);
                            sb.append(mess);
							ht.clear();*/
                        }
						else
						{							
                            sb.append(" Insert into MP_BIRTH_REGISTER has failed ");
                        }

                    }
                    if (stmt!=null) stmt.close();
                }
				catch(Exception ee) 
				{ 
                    insertable = false;
                    sb.append(ee.toString());
					ee.printStackTrace();
                }
            }

            String temp_baby_bed_no = (String)tabdata.get("bed_number");
            //Added for the Incident - IN042479 - start
            int cnt_ip_open_enc=0;
            if((String)tabdata.get("mother_encounter_id") !=null && !("".equals((String)tabdata.get("mother_encounter_id")))){
	            String ip_open_enc_sql="select count(*) from ip_open_encounter where facility_id='"+facilityId+"' and encounter_id="+(String)tabdata.get("mother_encounter_id");
	            if(stmt != null) stmt.close();
	            if(rset != null) rset.close();
	            stmt =con.prepareStatement(ip_open_enc_sql);
	            rset=stmt.executeQuery();
	            while(rset.next()){
	            	cnt_ip_open_enc=rset.getInt(1);
	            }
            }
            //Added for the incident - IN042479 - End
            //Below condition modified for the incident IN042479
            if(called_function.equals("IP") || called_function.equals("MP")) 
			{
			  if (!temp_baby_bed_no.equals("")) 
			  {
                if(ip_install_yn.equals("Y") ) 
				{
                    if(insertable) 
					{
                        try 
						{
                            if(stmt != null) stmt.close();
                            if(rset != null) rset.close();
                            String sql_ip_nb = " UPDATE ip_nursing_unit_bed SET occupying_patient_id = ?, current_status = 'O', modified_by_id = ?, modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id = ?, mothers_patient_id = ?, mothers_encounter_id = ? WHERE facility_id = ? AND nursing_unit_code = ? and bed_no = ? AND main_bed_no = ? ";
                            
                            stmt =con.prepareStatement(sql_ip_nb);
                            stmt.setString(1,patient_id);
                            stmt.setString(2,(String)tabdata.get("added_by_id"));
                            stmt.setString(3,(String)tabdata.get("added_at_ws_no"));
                            stmt.setString(4,(String)tabdata.get("added_facility_id"));
                            stmt.setString(5,(String)tabdata.get("mother_patient_id"));
                            stmt.setString(6,(String)tabdata.get("mother_encounter_id"));
                            stmt.setString(7, facilityId);
                            stmt.setString(8,(String)tabdata.get("mother_nursing_unit_code"));
                            stmt.setString(9,(String)tabdata.get("bed_number"));
                            stmt.setString(10,(String)tabdata.get("mother_bed_no"));
							
                            int res3 = stmt.executeUpdate();
                            if(res3 != 0)
							{
                                insertable = true;
                            }
							else
							{
                                insertable = false;
                                sb.append(" update of ip_nursing_unit_bed has failed ");
                            }
                        }
                        catch(Exception e) 
						{                          
                            sb.append(e.toString());
							e.printStackTrace();
                        }
                        if ( (insertable) &&  ((String)tabdata.get("outcome")).equals("L") )
						{
                            try
							{
						
                                if(stmt != null) stmt.close();
                                String sql_ip_nb2 = " UPDATE ip_open_encounter SET BABY_LINKED_YN = 'Y',MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE facility_id = ? AND encounter_id = ? ";
                                stmt =con.prepareStatement(sql_ip_nb2);
								stmt.setString(1,(String)tabdata.get("added_by_id"));
                                stmt.setString(2,(String)tabdata.get("added_at_ws_no"));
                                stmt.setString(3,(String)tabdata.get("added_facility_id"));
                                stmt.setString(4, facilityId);
                                stmt.setString(5,(String)tabdata.get("mother_encounter_id"));
                                int res7 = stmt.executeUpdate();
                                if(res7!=0){
                                    insertable = true;
                                }else {
                                    insertable = false;
                                    sb.append(" update of ip_open_encounter has failed ");
                                }
                            }
                            catch(Exception e)
                            {								
								sb.append(e.toString());
								e.printStackTrace();
                            }
                        }
                    }
                }//end of chk for IP installed
                } //Bed not null
				else
				{
					 if ( (insertable) &&  ((String)tabdata.get("outcome")).equals("L") && cnt_ip_open_enc==1 )//Condition modified for the incident IN042479
						{
                            try
							{
								
                                if(stmt != null) stmt.close();
                                String sql_ip_nb2 = " UPDATE ip_open_encounter SET BABY_DELINKED_YN = 'Y', BABY_LINKED_YN = 'N',MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE facility_id = ? AND encounter_id = ? ";
                                stmt =con.prepareStatement(sql_ip_nb2);
                                stmt.setString(1,(String)tabdata.get("added_by_id"));
                                stmt.setString(2,(String)tabdata.get("added_at_ws_no"));
                                stmt.setString(3,(String)tabdata.get("added_facility_id"));
                                stmt.setString(4, facilityId);
                                stmt.setString(5,(String)tabdata.get("mother_encounter_id"));
                                int res7 = stmt.executeUpdate();
                                if(res7!=0){
                                    insertable = true;
                                }else {
                                    insertable = false;
                                    sb.append(" update of ip_open_encounter has failed ");
                                }
                            }
                            catch(Exception e)
                            {								
								sb.append(e.toString());
                            }
                        }
				}
            }//end of call funciton chk
                        
            if(insertable) 
			{

                try 
				{
                    if(stmt != null) stmt.close();
                    if(rset != null) rset.close();                         
                 
						if(sql1.length() > 0) sql1.delete(0,sql1.length());
                        sql1.append(" insert into MP_PAT_ADDRESSES(PATIENT_ID, RES_AREA2_CODE, RES_TOWN2_CODE, REGION2_CODE,RES_AREA1_CODE, RES_TOWN1_CODE, REGION1_CODE, ADDR1_TYPE, ADDR1_LINE1, ADDR1_LINE2, ADDR1_LINE3, ADDR1_LINE4, POSTAL1_CODE, COUNTRY1_CODE, CONTACT1_NAME, INVALID1_YN, ADDR2_TYPE, ADDR2_LINE1, ADDR2_LINE2, ADDR2_LINE3, ADDR2_LINE4, POSTAL2_CODE, COUNTRY2_CODE, CONTACT2_NAME, INVALID2_YN, ADDR3_TYPE, ADDR3_LINE1, ADDR3_LINE2, ADDR3_LINE3, ADDR3_LINE4, POSTAL3_CODE, COUNTRY3_CODE, CONTACT3_NAME, INVALID3_YN, ADDR4_TYPE, ADDR4_LINE1, ADDR4_LINE2, ADDR4_LINE3, ADDR4_LINE4, POSTAL4_CODE, COUNTRY4_CODE, CONTACT4_NAME, INVALID4_YN, ADDR5_TYPE, ADDR5_LINE1, ADDR5_LINE2, ADDR5_LINE3, ADDR5_LINE4, POSTAL5_CODE, COUNTRY5_CODE, CONTACT5_NAME, INVALID5_YN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) (select ?,RES_AREA2_CODE, RES_TOWN2_CODE, REGION2_CODE,RES_AREA1_CODE, RES_TOWN1_CODE, REGION1_CODE, ADDR1_TYPE, ADDR1_LINE1, ADDR1_LINE2, ADDR1_LINE3, ADDR1_LINE4, POSTAL1_CODE, COUNTRY1_CODE, CONTACT1_NAME, INVALID1_YN, ADDR2_TYPE, ADDR2_LINE1, ADDR2_LINE2, ADDR2_LINE3, ADDR2_LINE4, POSTAL2_CODE, COUNTRY2_CODE, CONTACT2_NAME, INVALID2_YN, ADDR3_TYPE, ADDR3_LINE1, ADDR3_LINE2, ADDR3_LINE3, ADDR3_LINE4, POSTAL3_CODE, COUNTRY3_CODE, CONTACT3_NAME, INVALID3_YN, ADDR4_TYPE, ADDR4_LINE1, ADDR4_LINE2, ADDR4_LINE3, ADDR4_LINE4, POSTAL4_CODE, COUNTRY4_CODE, CONTACT4_NAME, INVALID4_YN, ADDR5_TYPE, ADDR5_LINE1, ADDR5_LINE2, ADDR5_LINE3, ADDR5_LINE4, POSTAL5_CODE, COUNTRY5_CODE, CONTACT5_NAME, INVALID5_YN,?,sysdate,?,?,?,sysdate,?,? from MP_PAT_ADDRESSES where patient_id=?)");
                        
                        pstmt2 = con.prepareStatement(sql1.toString());
                        pstmt2.setString(1,patient_id);                   
                        pstmt2.setString(2, (String)tabdata.get("added_by_id"));
                        pstmt2.setString(3, (String)tabdata.get("added_at_ws_no"));
                        pstmt2.setString(4, (String)tabdata.get("added_facility_id"));
                        pstmt2.setString(5, (String)tabdata.get("added_by_id"));
                        pstmt2.setString(6, (String)tabdata.get("added_at_ws_no"));
                        pstmt2.setString(7, (String)tabdata.get("added_facility_id"));				 
						pstmt2.setString(8, (String)tabdata.get("mother_patient_id"));
                        
                        int res2 = pstmt2.executeUpdate();
                        
                        if(res2!=0)
						{
                            insertable = true;
                        }
						else
						{
                            insertable = false;
                            sb.append(" Insert into MP_PAT_ADDRESSES has failed ");
                        }     
                                       
                    if(pstmt2 != null)pstmt2.close();
                }
				catch(Exception e) 
				{
                    insertable = false;
                    sb.append( e.toString());
					e.printStackTrace();
                }

            }
            if(insertable) 
			{  
                try 
				{             
                        if(sql1.length() > 0) sql1.delete(0,sql1.length());
                        //sql1.append("insert into mp_pat_rel_contacts(PATIENT_ID,CONTACT1_ROLE,CONTACT1_RELATION,CONTACT1_NAME,JOB1_TITLE,ADDR1_LINE1,ADDR1_LINE2,ADDR1_LINE3,ADDR1_LINE4,POSTAL1_CODE,COUNTRY1_CODE,RES1_TEL_NO,OFF1_TEL_NO,CONTACT2_ROLE,CONTACT2_RELATION,CONTACT2_NAME,JOB2_TITLE,ADDR2_LINE1,ADDR2_LINE2,ADDR2_LINE3,ADDR2_LINE4,POSTAL2_CODE,COUNTRY2_CODE,RES2_TEL_NO,OFF2_TEL_NO,CONTACT4_ROLE,CONTACT4_RELATION,CONTACT4_NAME,JOB4_TITLE,ADDR4_LINE1,ADDR4_LINE2,ADDR4_LINE3,ADDR4_LINE4,POSTAL4_CODE,COUNTRY4_CODE,RES4_TEL_NO,OFF4_TEL_NO,CONTACT5_ROLE,CONTACT5_RELATION,CONTACT5_NAME,JOB5_TITLE,ADDR5_LINE1,ADDR5_LINE2,ADDR5_LINE3,ADDR5_LINE4,POSTAL5_CODE,COUNTRY5_CODE,RES5_TEL_NO,OFF5_TEL_NO,OFF_FAX_NO,CONTACT1_NAT_ID_NO,CONTACT1_ALT_ID1_TYPE,CONTACT1_ALT_ID1_NO,CONTACT1_ALT_ID2_TYPE,CONTACT1_ALT_ID2_NO, CONTACT1_ALT_ID3_TYPE,CONTACT1_ALT_ID3_NO,CONTACT1_ALT_ID4_TYPE, CONTACT1_ALT_ID4_NO,CONTACT1_OTH_ALT_ID_TYPE,CONTACT1_OTH_ALT_ID_NO, CONTACT1_RES_TOWN_CODE,CONTACT1_RES_AREA_CODE,CONTACT1_REGION_CODE,CONTACT1_MOB_TEL_NO,CONTACT1_EMAIL_ID,CONTACT2_NAT_ID_NO,CONTACT2_OTH_ALT_ID_TYPE,CONTACT2_OTH_ALT_ID_NO,CONTACT2_RES_TOWN_CODE,CONTACT2_RES_AREA_CODE,CONTACT2_REGION_CODE,CONTACT2_MOB_TEL_NO, CONTACT2_EMAIL_ID,CONTACT1_BIRTH_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO, ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) (select ?,CONTACT1_ROLE,CONTACT1_RELATION,CONTACT1_NAME,JOB1_TITLE,ADDR1_LINE1,ADDR1_LINE2,ADDR1_LINE3,ADDR1_LINE4,POSTAL1_CODE,COUNTRY1_CODE,RES1_TEL_NO,OFF1_TEL_NO,CONTACT2_ROLE,CONTACT2_RELATION,CONTACT2_NAME,JOB2_TITLE,ADDR2_LINE1,ADDR2_LINE2,ADDR2_LINE3,ADDR2_LINE4,POSTAL2_CODE,COUNTRY2_CODE,RES2_TEL_NO,OFF2_TEL_NO,CONTACT4_ROLE,CONTACT4_RELATION,CONTACT4_NAME,JOB4_TITLE,ADDR4_LINE1,ADDR4_LINE2,ADDR4_LINE3,ADDR4_LINE4,POSTAL4_CODE,COUNTRY4_CODE,RES4_TEL_NO,OFF4_TEL_NO,CONTACT5_ROLE,CONTACT5_RELATION,CONTACT5_NAME,JOB5_TITLE,ADDR5_LINE1,ADDR5_LINE2,ADDR5_LINE3,ADDR5_LINE4,POSTAL5_CODE,COUNTRY5_CODE,RES5_TEL_NO,OFF5_TEL_NO,OFF_FAX_NO,CONTACT1_NAT_ID_NO,CONTACT1_ALT_ID1_TYPE,CONTACT1_ALT_ID1_NO,CONTACT1_ALT_ID2_TYPE,CONTACT1_ALT_ID2_NO, CONTACT1_ALT_ID3_TYPE,CONTACT1_ALT_ID3_NO,CONTACT1_ALT_ID4_TYPE, CONTACT1_ALT_ID4_NO,CONTACT1_OTH_ALT_ID_TYPE,CONTACT1_OTH_ALT_ID_NO, CONTACT1_RES_TOWN_CODE,CONTACT1_RES_AREA_CODE,CONTACT1_REGION_CODE,CONTACT1_MOB_TEL_NO,CONTACT1_EMAIL_ID,CONTACT2_NAT_ID_NO,CONTACT2_OTH_ALT_ID_TYPE,CONTACT2_OTH_ALT_ID_NO,CONTACT2_RES_TOWN_CODE,CONTACT2_RES_AREA_CODE,CONTACT2_REGION_CODE,CONTACT2_MOB_TEL_NO, CONTACT2_EMAIL_ID,CONTACT1_BIRTH_DATE,?,sysdate,?,?,?,sysdate,?,? from mp_pat_rel_contacts where patient_id= ?)");	
                        
                        sql1.append("insert into mp_pat_rel_contacts(PATIENT_ID,CONTACT1_ROLE,CONTACT1_RELATION,CONTACT1_NAME,JOB1_TITLE,ADDR1_LINE1,ADDR1_LINE2,ADDR1_LINE3,ADDR1_LINE4,POSTAL1_CODE,COUNTRY1_CODE,RES1_TEL_NO,OFF1_TEL_NO,CONTACT2_ROLE,CONTACT2_RELATION,CONTACT2_NAME,JOB2_TITLE,ADDR2_LINE1,ADDR2_LINE2,ADDR2_LINE3,ADDR2_LINE4,POSTAL2_CODE,COUNTRY2_CODE,RES2_TEL_NO,OFF2_TEL_NO,CONTACT4_ROLE,CONTACT4_RELATION,CONTACT4_NAME,JOB4_TITLE,ADDR4_LINE1,ADDR4_LINE2,ADDR4_LINE3,ADDR4_LINE4,POSTAL4_CODE,COUNTRY4_CODE,RES4_TEL_NO,OFF4_TEL_NO,CONTACT5_ROLE,CONTACT5_RELATION,CONTACT5_NAME,JOB5_TITLE,ADDR5_LINE1,ADDR5_LINE2,ADDR5_LINE3,ADDR5_LINE4,POSTAL5_CODE,COUNTRY5_CODE,RES5_TEL_NO,OFF5_TEL_NO,OFF_FAX_NO,CONTACT1_NAT_ID_NO,CONTACT1_ALT_ID1_TYPE,CONTACT1_ALT_ID1_NO,CONTACT1_ALT_ID2_TYPE,CONTACT1_ALT_ID2_NO, CONTACT1_ALT_ID3_TYPE,CONTACT1_ALT_ID3_NO,CONTACT1_ALT_ID4_TYPE, CONTACT1_ALT_ID4_NO,CONTACT1_OTH_ALT_ID_TYPE,CONTACT1_OTH_ALT_ID_NO, CONTACT1_RES_TOWN_CODE,CONTACT1_RES_AREA_CODE,CONTACT1_REGION_CODE,CONTACT1_MOB_TEL_NO,CONTACT1_EMAIL_ID,CONTACT2_NAT_ID_NO,CONTACT2_OTH_ALT_ID_TYPE,CONTACT2_OTH_ALT_ID_NO,CONTACT2_RES_TOWN_CODE,CONTACT2_RES_AREA_CODE,CONTACT2_REGION_CODE,CONTACT2_MOB_TEL_NO, CONTACT2_EMAIL_ID,CONTACT1_BIRTH_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO, ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) (select ?, a.CONTACT1_ROLE, a.CONTACT1_RELATION, a.CONTACT1_NAME, a.JOB1_TITLE, a.ADDR1_LINE1, a.ADDR1_LINE2, a.ADDR1_LINE3, a.ADDR1_LINE4, a.POSTAL1_CODE, a.COUNTRY1_CODE, RES1_TEL_NO, OFF1_TEL_NO, a.CONTACT2_ROLE, ?, substr((select decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) nb_patient_name from mp_patient where patient_id=?),1,30)patient_name, a.JOB2_TITLE, b.ADDR1_LINE1, b.ADDR1_LINE2, b.ADDR1_LINE3, b.ADDR1_LINE4, b.POSTAL1_CODE, b.COUNTRY1_CODE, c.CONTACT1_NO, c.CONTACT2_NO, a.CONTACT4_ROLE, a.CONTACT4_RELATION, a.CONTACT4_NAME, a.JOB4_TITLE, a.ADDR4_LINE1, a.ADDR4_LINE2, a.ADDR4_LINE3, a.ADDR4_LINE4, a.POSTAL4_CODE, a.COUNTRY4_CODE, a.RES4_TEL_NO, a.OFF4_TEL_NO, a.CONTACT5_ROLE, a.CONTACT5_RELATION, a.CONTACT5_NAME, a.JOB5_TITLE, a.ADDR5_LINE1, a.ADDR5_LINE2, a.ADDR5_LINE3, a.ADDR5_LINE4, a.POSTAL5_CODE, a.COUNTRY5_CODE, a.RES5_TEL_NO, a.OFF5_TEL_NO, a.OFF_FAX_NO, CONTACT1_NAT_ID_NO, CONTACT1_ALT_ID1_TYPE, CONTACT1_ALT_ID1_NO, CONTACT1_ALT_ID2_TYPE, CONTACT1_ALT_ID2_NO, CONTACT1_ALT_ID3_TYPE, CONTACT1_ALT_ID3_NO, CONTACT1_ALT_ID4_TYPE, CONTACT1_ALT_ID4_NO, CONTACT1_OTH_ALT_ID_TYPE, CONTACT1_OTH_ALT_ID_NO, CONTACT1_RES_TOWN_CODE, CONTACT1_RES_AREA_CODE, CONTACT1_REGION_CODE, CONTACT1_MOB_TEL_NO, CONTACT1_EMAIL_ID, c.NATIONAL_ID_NO, c.OTH_ALT_ID_TYPE, c.OTH_ALT_ID_NO, c.RES_TOWN_CODE, c.RES_AREA_CODE, c.REGION_CODE, c.CONTACT2_NO, c.EMAIL_ID, CONTACT1_BIRTH_DATE, ?,sysdate,?,?,?,sysdate,?,? from mp_pat_rel_contacts a, mp_pat_addresses b, mp_patient c where a.patient_id= ? and a.patient_id = b.patient_id and a.patient_id = c.patient_id)");
                        
                        pstmt2 = con.prepareStatement(sql1.toString());	
																
                        pstmt2.setString(1,patient_id);                   
                        pstmt2.setString(2,(String)tabdata.get("nb_dflt_relnship_code"));  
						pstmt2.setString(3,(String)tabdata.get("mother_patient_id"));
                        pstmt2.setString(4,(String)tabdata.get("added_by_id"));
                        pstmt2.setString(5,(String)tabdata.get("added_at_ws_no"));
                        pstmt2.setString(6,(String)tabdata.get("added_facility_id"));
                        pstmt2.setString(7,(String)tabdata.get("added_by_id"));
                        pstmt2.setString(8,(String)tabdata.get("added_at_ws_no"));
                        pstmt2.setString(9,(String)tabdata.get("added_facility_id"));						pstmt2.setString(10,(String)tabdata.get("mother_patient_id"));

                        int res2 = pstmt2.executeUpdate();

                     
                        if(res2 != 0)
						{
                            insertable = true;
                        } 
						else 
						{
                            insertable = false;
                            sb.append(" Insert into mp_pat_rel_contacts has failed ");
                        }             
                }
				catch(Exception ee) 
				{
                    insertable = false;
                    sb.append(ee.toString()+" in mp_pat_rel_contacts ");
                    sb.append( ee.toString());
					ee.printStackTrace();
                }
                finally 
				{
					if(rset!=null) rset.close();
                    if(stmt!=null) stmt.close();
                    if(stmt1!=null)stmt1.close();
                }

            }
            if(insertable) 
			{

                try 
				{
					if(sql1.length() > 0) sql1.delete(0,sql1.length());
					
                    sql1.append("insert into MP_PAT_OTH_DTLS (PATIENT_ID,REGN_COMPLETE_YN,LIVING_DEPENDENCY,LIVING_ARRANGEMENT,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,BLOOD_GRP,RH_FACTOR) values (?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?)");
                  
                    pstmt2 = con.prepareStatement(sql1.toString());
										
                    pstmt2.setString(1,patient_id);
                    pstmt2.setString(2,"Y");
                    pstmt2.setString(3,"UN");
                    pstmt2.setString(4,"U");
                    pstmt2.setString(5,(String)tabdata.get("added_by_id"));
                    pstmt2.setString(6,(String)tabdata.get("added_at_ws_no"));
                    pstmt2.setString(7,(String)tabdata.get("added_facility_id"));
                    pstmt2.setString(8,(String)tabdata.get("added_by_id"));
                    pstmt2.setString(9,(String)tabdata.get("added_at_ws_no"));
                    pstmt2.setString(10,(String)tabdata.get("added_facility_id"));
                    pstmt2.setString(11,(String)tabdata.get("blood_group"));
                    pstmt2.setString(12,(String)tabdata.get("rf_code"));


                    int res2 = pstmt2.executeUpdate();
                  
                    if(res2 != 0)
					{
                        insertable = true;
                    }
                    else 
					{
                        insertable = false;
                        sb.append(" Insert into MP_PAT_OTH_DTLS has failed");
                    }
                    
					if(rset != null) rset.close();
                    if(stmt != null) stmt.close();
                    if (stmt1!=null)stmt1.close();
                }
				catch(Exception ee) 
				{
					sb.append(ee.toString());
                    insertable = false;
					ee.printStackTrace();
                   
                }

            }
            if(insertable)
			{
                try 
				{
                    if(bl_install_yn.equalsIgnoreCase("Y"))
						insertable = updateBilling("I",tabdata,p,con,patient_id,results,sb) ; //HMC#02
						
                    if(!insertable) 
					{
                        con.rollback();
                        
                    }
                    if(rset != null) rset.close();
                    if(pstmt2 != null) pstmt2.close();
                }
                catch(Exception exc){exc.printStackTrace();}
            }
            // End of addition on 04/08/2003 for Billing
            
            if(insertable) 
			{
                String generate_file = (String)tabdata.get("generate_file");
                String function_name_nb = (String)tabdata.get("function_name_nb");
                String function_id_mg = (String)tabdata.get("function_id_mg");
                String called_from_mothercare = (String)tabdata.get("called_from_mothercare");
                String single_stage_nb_reg_appl_yn = (String)tabdata.get("single_stage_nb_reg_appl_yn");
                String GeneratedFileNo = "";

				String nbUseMotherSer = (String)tabdata.get("nb_use_mother_ser");
				String called_from = (String)tabdata.get("called_from");
			//	System.out.println("called_from---->"+called_from);
				String patIidLength = (String)tabdata.get("maxLength");
				String nbPatSerGrp = (String)tabdata.get("newborn_pat_ser_grp");
				String invkAdmFrmNBYn = (String)tabdata.get("invoke_adm_from_newborn_yn");
				String ipInstallYn = (String)tabdata.get("ip_install_yn");
				//String siteId = (String)tabdata.get("siteId"); 

                showModalForOldFileNo((String)tabdata.get("added_facility_id"), (String)tabdata.get("pat_ser_grp_code"), GeneratedFileNo,generate_file,"N",true,    (String)tabdata.get("maintain_doc_or_file"), sStyle,function_name_nb,function_id_mg,called_from_mothercare,single_stage_nb_reg_appl_yn,checkForNull((String)tabdata.get("mother_patient_id")), nbUseMotherSer, patIidLength, nbPatSerGrp, invkAdmFrmNBYn, ipInstallYn, siteId,called_from,patient_id,results,sb);
            }
            
            
            
            if(insertable) 
			{
				result = true ;
                con.commit();
                final java.util.Hashtable message = mess.getMessage( locale, RECORD_INSERTED,"SM" ) ;
                sbMessage.append( (String) message.get("message") );
				message.clear();
            }
            else
			{
                con.rollback();
            }
            if(rset != null) rset.close();
            if(stmt != null) stmt.close();
            if(stmt1 != null)stmt1.close();
      
    
         
            if(stmtz != null)stmtz.close();
            //if(stmtw != null)stmtw.close();
          
            //if(resx != null) resx.close();
         
            if(resz != null) resz.close();
            //if(resw != null) resw.close();
            if(pstmt2 != null) pstmt2.close();
        }
        catch(Exception e)
		{
            sb.append("Catch :"+e.toString());
			e.printStackTrace();
        }
        finally 
		{
            if(con != null) ConnectionManager.returnConnection(con,p);
        }

		/*
		if(!((String)results.get("showModalForOldFileNoErrors")).equals("")){
			sb.append((String)results.get("showModalForOldFileNoErrors"));
		}
		if(!((String) results.get("updateBillingErrors")).equals("")){
			sb.append((String)results.get("updateBillingErrors"));
		}
		*/
        results.put("status",new Boolean(result));
        results.put("error",sb.toString());
        results.put("error1",am.toString());
        results.put("patient",patient_id);
        results.put("ResultFromMessageManager", sbMessage.toString());
        results.put("active",active_yn);
        results.put("debug_message",sb);
        results.put("numOfbaby",new Integer(numOfbaby));
        results.put("mother_nursing_unit",tabdata.get("mother_nursing_unit_code"));
        results.put("mother_bed_no",tabdata.get("mother_bed_no"));
        results.put("tempflag",new Integer(tempflag));
        results.put("bl_success_msg",bl_success_msg);
        results.put("mother_id",checkForNull((String)tabdata.get("mother_patient_id")));
		
		sb.setLength(0);
		am.setLength(0);
        return results;
		
    }
    
    ////////////// U P D A T E   M O D E   S T A R T S  H E R E //////////////
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap updateNewbornRegistration(Properties p,HashMap tabdata) 
	{ 

		Connection con				= null;
	
		Statement stmt1				= null;
	
		PreparedStatement stmt		= null;
		PreparedStatement pstmt2	= null;		
		ResultSet rset				= null;
	
		//String sql						= ""; //Commented for checkstyle
		//String multisql					= ""; //Commented for checkstyle
		//String motherpatientid			= ""; //Commented for checkstyle
		String active_yn				= "";
		//String deceased_yn				= ""; //Commented for checkstyle
		String patient_id				= "";
		//String relnshp					= ""; //Commented for checkstyle
		String gender					= "";
		String hdRelnShp				= "";
		//String bl_install_yn			= ""; //Commented for checkstyle
		//String sStyle					= ""; //Commented for checkstyle
		//String bl_success_msg	= ""; //Commented for checkstyle

		//String nb_name_prefix	= ""; //Commented for checkstyle
		//String nb_first_name	= ""; //Commented for checkstyle
		//String nb_second_name	= ""; //Commented for checkstyle
		//String nb_third_name	= ""; //Commented for checkstyle
		//String nb_family_name	= ""; //Commented for checkstyle
		//String nb_name_suffix	= ""; //Commented for checkstyle
		//String nb_patient_name	= ""; //Commented for checkstyle
		//String nb_name_prefix_loc_lang	= ""; //Commented for checkstyle
		//String nb_first_name_loc_lang	= ""; //Commented for checkstyle
		//String nb_second_name_loc_lang	= ""; //Commented for checkstyle
		//String nb_third_name_loc_lang	= ""; //Commented for checkstyle
		//String nb_family_name_loc_lang	= ""; //Commented for checkstyle
		//String nb_name_suffix_loc_lang	= ""; //Commented for checkstyle
		//String nb_patient_name_loc_lang	= ""; //Commented for checkstyle
		//String deriveBabyNameYN	= "N"; //Commented for checkstyle
		//String added_date= "Y"; //Commented for checkstyle

		//StringBuffer sql1 =new StringBuffer(); //Commented for checkstyle

		//int multibabiesregistered	= 0; //Commented for checkstyle
		//int tempflag				= 0; //Commented for checkstyle
		//int numOfbaby				= 1; //Commented for checkstyle
		//int birth_order				= 0; //Commented for checkstyle
		StringBuffer sbMessage = new StringBuffer("");
		//StringBuffer insertsql = new StringBuffer(""); //Commented for checkstyle
		StringBuffer sb  = new StringBuffer();
		//StringBuffer am  = new StringBuffer(); //Commented for checkstyle
		HashMap results = new HashMap() ;

	
        boolean result = false;
		String locale="";
		//String localeName=""; //Commented for checkstyle
		locale=p.getProperty("LOCALE");
		
        try{ 
			con = ConnectionManager.getConnection(p);
			String facilityId		= (String)tabdata.get("added_facility_id");
			String ip_install_yn	= (String)tabdata.get("ip_install_yn");
            String called_function	= (String)tabdata.get("called_function");
			String family_no_link_yn="";
			String family_org_id_accept_yn="";

			String father_patient_id = checkForNull((String)tabdata.get("father_patient_id"));
			String mother_pat_id = checkForNull((String)tabdata.get("mother_patient_id"));
            
			patient_id = (String)tabdata.get("patient_id") ;
			
			boolean insertable = true;

			/*added for CCRF 689 & 695 Strats*/
			String heart_rate_in_1_min	= (String)tabdata.get("heart_rate_in_1_min") ;
			String breathing_in_1_min	= (String)tabdata.get("breathing_in_1_min") ;
			String grimace_in_1_min		= (String)tabdata.get("grimace_in_1_min") ;
			String activity_in_1_min	= (String)tabdata.get("activity_in_1_min") ;
			String appearance_in_1_min	= (String)tabdata.get("appearance_in_1_min") ;

			String heart_rate_in_5_min	= (String)tabdata.get("heart_rate_in_5_min") ;
			String breathing_in_5_min	= (String)tabdata.get("breathing_in_5_min") ;
			String grimace_in_5_min		= (String)tabdata.get("grimace_in_5_min") ;
			String activity_in_5_min	= (String)tabdata.get("activity_in_5_min") ;
			String appearance_in_5_min	= (String)tabdata.get("appearance_in_5_min") ;

			String heart_rate_in_10_min	= (String)tabdata.get("heart_rate_in_10_min") ;
			String breathing_in_10_min	= (String)tabdata.get("breathing_in_10_min") ;
			String grimace_in_10_min	= (String)tabdata.get("grimace_in_10_min") ;
			String activity_in_10_min	= (String)tabdata.get("activity_in_10_min") ;
			String appearance_in_10_min	= (String)tabdata.get("appearance_in_10_min") ;
			

			String pract_id_still_birth			= (String)tabdata.get("pract_id_still_birth") ;
			String attendant_at_birth			= (String)tabdata.get("attendant_at_birth") ;
			String autopsy_reqd_yn				= (String)tabdata.get("autopsy_reqd_yn") ;
			String mate_cond_main_cod			= (String)tabdata.get("mate_cond_main_cod") ;
			String mate_cond_main_cod_dur		= (String)tabdata.get("mate_cond_main_cod_dur") ;
			String mate_cond_oth_cod			= (String)tabdata.get("mate_cond_oth_cod") ;
			String mate_cond_oth_cod_dur		= (String)tabdata.get("mate_cond_oth_cod_dur") ;
			String mate_cond_preexist_cod		= (String)tabdata.get("mate_cond_preexist_cod") ;
			String mate_cond_preexist_cod_dur	= (String)tabdata.get("mate_cond_preexist_cod_dur") ;
			String oth_rel_mate_cond_rel_cod	= (String)tabdata.get("oth_rel_mate_cond_rel_cod") ;
			String oth_rel_mate_cond_rel_cod_dur= (String)tabdata.get("oth_rel_mate_cond_rel_cod_dur") ;
			String cond_cau_dea_main_cod		= (String)tabdata.get("cond_cau_dea_main_cod") ;
			String cond_cau_dea_main_cod_dur	= (String)tabdata.get("cond_cau_dea_main_cod_dur") ;
			String cond_cau_dea_oth_cod			= (String)tabdata.get("cond_cau_dea_oth_cod") ;
			String cond_cau_dea_oth_cod_dur		= (String)tabdata.get("cond_cau_dea_oth_cod_dur") ;
			String cond_cau_dea_preexist_cod	= (String)tabdata.get("cond_cau_dea_preexist_cod") ;
			String cond_cau_dea_preexist_cod_dur= (String)tabdata.get("cond_cau_dea_preexist_cod_dur") ;
			String rel_cond_cau_dea_rel_cod		= (String)tabdata.get("rel_cond_cau_dea_rel_cod") ;
			String rel_cond_cau_dea_rel_cod_dur	= (String)tabdata.get("rel_cond_cau_dea_rel_cod_dur") ;
			/*Added by Dharma on 4th June 2018 against ML-MMOH-CRF-0898 [IN:064757] Start*/
			String mother_witnessed_by1			= checkForNull((String)tabdata.get("mother_witnessed_by1"));
			String mother_witnessed_by2			= checkForNull((String)tabdata.get("mother_witnessed_by2"));
			String mother_alive_yn				= checkForNull((String)tabdata.get("mother_alive_yn"),"Y");
			String accession_num_nb_note				= checkForNull((String)tabdata.get("accession_num_nb_note"));
			/*Added by Dharma on 4th June 2018 against ML-MMOH-CRF-0898 [IN:064757] End*/
			/*added for CCRF 689 & 695 ENds*/
			//Added MMS-QH-CRF-0145.1 [IN:047497]
		String date_of_birth_hj= (String)tabdata.get("date_of_birth_hj"); 
            
			//Modified below query MMS-QH-CRF-0145.1 [IN:047497]

			/*Added by Rameswar on 17-Feb-16 for ML-MMOH-CRF-0383*/
					String prev_patency_prac =checkForNull((String)tabdata.get("prev_patency_prac_hidden"));
					String updquery="";
										
					if(!(((String)tabdata.get("patency_of_anus_checked_by_id")).equals(""))){
					if(!(prev_patency_prac.equals((String)tabdata.get("patency_of_anus_checked_by_id")))) {
						updquery=",PATENCY_ANUS_CHECKED_DATE = sysdate" ;
						
					} }
			/*Added by Rameswar on 17-Feb-16 for ML-MMOH-CRF-0383*/
			
			/*Below line modified for this CRF ML-MMOH-CRF-0621*/
			
            stmt = con.prepareStatement(" UPDATE  mp_birth_register SET mother_patient_id=?, weight=?, circumference=?, length=?, gestational_period=?, apgar_score=?, umbilical_cord_status=?, patency_of_anus_yn=?, name_suffix=?, nod_type=?, gravida=?, parity=?, feeding=?, stools=?, complications=?, attend_physician_id=?, attend_midwife_id=?, father_patient_id=?, father_name=?, remarks=?, modified_by_id=?, modified_date=sysdate, modified_facility_id=?, modified_at_ws_no=?, chest_circumference=?, apgar_score_in_5_mins=?, indicator_mark=?, bba_yn=?, born_at=?, time_of_birth=to_date(?,'dd/mm/rrrr hh24:mi'), nb_sex=?, community_nurse_id=?, compln_dely_code=?, umb_cord_cut_by=?, cong_anomalies_code=?, administered_by=?, vaccination_site=?, administered_designation=?, father_national_id_no=?, father_oth_alt_id_type=?, father_oth_alt_id_no=?, father_nationality_code=?, father_ethnic_group_code=?, father_religion_code=?, father_ocpn_code=?, father_ocpn_class_code=?, father_remarks=?, BCG_YN=?, VITAMIN_K_YN=?, HEPB_YN=?, FATHER_OCPN_DESC=?, Mother_Pmi_no=?, Dely_ind_code=?, Proc_class_Code=?, Vaginal_dely_type_code=?, Dely_surg_class_code=?, birth_place_code=?, birth_certificate_no=?, no_of_births=?, vitak_vacc_site=?, vitak_administered_by=?, vitak_administered_desig=?, hepb_vacc_site=?, hepb_administered_by=?, hepb_administered_desig=?, nb_compln_dely_code=?, FATHER_GOVE_EMPLOYEE_YN=?, BCG_VACC_ADMN_DATE=to_date('"+(String)tabdata.get("bcg_datetime")+"','dd/mm/rrrr hh24:mi'), VITK_VACC_ADMN_DATE=to_date('"+(String)tabdata.get("vitk_datetime")+"','dd/mm/rrrr hh24:mi'), HEPB_VACC_ADMN_DATE=to_date('"+(String)tabdata.get("hepb_datetime")+"','dd/mm/rrrr hh24:mi'), apgar_score_in_10_mins = ?, born_at_locn_type =?, born_at_locn_code = ?, father_alt_id1_type = ?, father_alt_id1_no = ?, gestational_period_in_days = ?, nb_name_prefix = ?, nb_first_name = ?, nb_second_name = ?, nb_third_name = ?, nb_family_name_prefix = ?, nb_family_name = ?, nb_name_suffix = ?, nb_patient_name = ?, nb_name_prefix_loc_lang = ?, nb_first_name_loc_lang = ?, nb_second_name_loc_lang = ?, nb_third_name_loc_lang = ?, nb_family_name_loc_lang = ?, nb_name_suffix_loc_lang = ?, nb_patient_name_loc_lang = ?, father_name_prefix = ?, father_first_name = ?, father_second_name = ?, father_third_name = ?, father_family_name_prefix = ?, father_family_name = ?, father_name_suffix = ?, father_patient_name = ?, father_name_prefix_loc_lang = ?, father_first_name_loc_lang = ?, father_second_name_loc_lang = ?, father_third_name_loc_lang = ?, father_family_name_loc_lang = ?, father_name_suffix_loc_lang = ?, father_patient_name_loc_lang = ?, finalized_yn = ?, complns_1st_stage_labour_code = ?, complns_2nd_stage_labour_code = ?, complns_3rd_stage_labour_code = ?, compln_pregnancy_code = ?, compln_nr_pregnancy_code = ?,heart_rate_in_1_min = ?, heart_rate_in_5_min = ?, heart_rate_in_10_min = ?, breathing_in_1_min = ?, breathing_in_5_min = ?, breathing_in_10_min = ?, grimace_in_1_min = ?, grimace_in_5_min = ?, grimace_in_10_min = ?, activity_in_1_min = ?, activity_in_5_min = ?, activity_in_10_min = ?, appearance_in_1_min = ?, appearance_in_5_min = ?, appearance_in_10_min  = ?, antenatal_care_yn = ?, ant_care_gvn_at = ?, ant_care_locn_type = ?, ant_care_locn_code = ?,HIJRI_BIRTH_DATE=?,father_alt_id2_type=?, father_alt_id2_no=?,father_alt_id3_type=?, father_alt_id3_no=?,father_alt_id4_type=?,father_alt_id4_no=?,MOTHER_ALT_ID1_TYPE=?,MOTHER_ALT_ID2_TYPE=?,MOTHER_ALT_ID3_TYPE=?,MOTHER_ALT_ID4_TYPE=?,MOTHER_ALT_ID2_NO=?,MOTHER_ALT_ID3_NO=?,MOTHER_ALT_ID4_NO=?,MOTHER_NATIONAL_ID_NO=?,MOTHER_OTH_ALT_ID_NO=?,MOTHER_OTH_ALT_ID_TYPE=?,PATENCY_OF_ANUS_CHECKED_BY=?,ACCESSION_NUM=?,parity_on_admission=?,resuscitated_pract_id=?,mother_witnessed_by1='"+mother_witnessed_by1+"',mother_witnessed_by2='"+mother_witnessed_by2+"',mother_alive_yn='"+mother_alive_yn+"',accession_num_nb_note='"+accession_num_nb_note+"' "+updquery+" where patient_id = ? ");
			//Modified by Rameswar on 17-Feb-16 for ML-MMOH-CRF-0383
			//Modified by Ashwini on 24-oct-2016 for MO-CRF-20108
            stmt.setString(1,mother_pat_id);
            stmt.setString(2,(String)tabdata.get("weight"));
            stmt.setString(3,(String)tabdata.get("circumference"));
            stmt.setString(4,(String)tabdata.get("length"));
            stmt.setString(5,(String)tabdata.get("gestational_period"));
            stmt.setString(6,(String)tabdata.get("apgar_score"));
            stmt.setString(7,(String)tabdata.get("umbilical_cord_status"));
            stmt.setString(8,(String)tabdata.get("patency_of_anus_yn"));
            stmt.setString(9,(String)tabdata.get("name_suffix"));
            stmt.setString(10,(String)tabdata.get("nod_type"));
            stmt.setString(11,(String)tabdata.get("gravida"));
            stmt.setString(12,(String)tabdata.get("parity"));
            stmt.setString(13,(String)tabdata.get("feeding"));
            stmt.setString(14,(String)tabdata.get("stools"));
            stmt.setString(15,(String)tabdata.get("complications"));
            stmt.setString(16,(String)tabdata.get("attend_physician_id"));
            stmt.setString(17,(String)tabdata.get("attend_midwife_id"));
            stmt.setString(18,father_patient_id);
            stmt.setString(19,(String)tabdata.get("father_name"));
            stmt.setString(20,(String)tabdata.get("remarks"));
            stmt.setString(21,(String)tabdata.get("added_by_id"));
            stmt.setString(22,(String)tabdata.get("added_facility_id"));
            stmt.setString(23,(String)tabdata.get("added_at_ws_no"));
            stmt.setString(24,(String)tabdata.get("chest_circumference"));
            stmt.setString(25,(String)tabdata.get("apgar_score_in_5_mins"));
            stmt.setString(26,(String)tabdata.get("indicator_mark"));
            stmt.setString(27,(String)tabdata.get("bbayn"));
            stmt.setString(28,(String)tabdata.get("born_at"));
            stmt.setString(29,(String)tabdata.get("time_of_birth"));
            stmt.setString(30,(String)tabdata.get("nb_sex"));
            stmt.setString(31,(String)tabdata.get("community_nurse"));
            stmt.setString(32,(String)tabdata.get("complications_delivery"));
            stmt.setString(33,(String)tabdata.get("Umb_cord_cut_by"));
            stmt.setString(34,(String)tabdata.get("Congenital_Anomalies"));
            stmt.setString(35,(String)tabdata.get("administeredBy"));
            stmt.setString(36,(String)tabdata.get("vaccination_site"));
            stmt.setString(37,(String)tabdata.get("Designation"));
            stmt.setString(38,(String)tabdata.get("National_id"));
            stmt.setString(39,(String)tabdata.get("cboOtherAltID"));
            stmt.setString(40,(String)tabdata.get("txtOtherAltID"));
            stmt.setString(41,(String)tabdata.get("cboNationality"));
            stmt.setString(42,(String)tabdata.get("cboEthnicGroup"));
            stmt.setString(43,(String)tabdata.get("cboReligion"));
            stmt.setString(44,(String)tabdata.get("cboOccupation"));
            stmt.setString(45,(String)tabdata.get("cboOccupationClass"));
            stmt.setString(46,(String)tabdata.get("fatherRemarks"));
            stmt.setString(47,(String)tabdata.get("bcg_given_yn"));
            stmt.setString(48,(String)tabdata.get("vitak_given_yn"));
            stmt.setString(49,(String)tabdata.get("hep_given_yn"));
            stmt.setString(50,(String)tabdata.get("Occupation_Desc"));
            stmt.setString(51,(String)tabdata.get("Mother_Pmi_no"));
            stmt.setString(52,(String)tabdata.get("Dely_ind_code"));
            stmt.setString(53,(String)tabdata.get("Proc_class_Code"));
            stmt.setString(54,(String)tabdata.get("Vaginal_dely_type_code"));
            stmt.setString(55,(String)tabdata.get("Dely_surg_class_code"));
            stmt.setString(56,(String)tabdata.get("birth_place_code"));
            stmt.setString(57,(String)tabdata.get("birth_certificate_no"));
            stmt.setString(58,(String)tabdata.get("no_of_birth"));
            stmt.setString(59,(String)tabdata.get("vitak_vacc_site"));
            stmt.setString(60,(String)tabdata.get("vitak_administered_By"));
            stmt.setString(61,(String)tabdata.get("vitak_administered_Designation"));
            stmt.setString(62,(String)tabdata.get("hepb_vacc_site"));
            stmt.setString(63,(String)tabdata.get("hepb_administered_By"));		stmt.setString(64,(String)tabdata.get("hepb_administered_Designation"));
            stmt.setString(65,(String)tabdata.get("nb_complication_delivery"));
            stmt.setString(66,(String)tabdata.get("fthGovtEmpl"));
            stmt.setString(67,(String)tabdata.get("apgar_score_in_10_mins"));
            stmt.setString(68,(String)tabdata.get("born_at_locn_type"));
            stmt.setString(69,(String)tabdata.get("born_at_locn_code"));
			stmt.setString(70,(String)tabdata.get("father_alt_id1_desc"));
            stmt.setString(71,(String)tabdata.get("father_alt_id1_no"));
            stmt.setString(72,(String)tabdata.get("gestational_period_days"));

			stmt.setString(73,(String)tabdata.get("nb_name_prefix")); 
            stmt.setString(74,(String)tabdata.get("nb_first_name")); 
            stmt.setString(75,(String)tabdata.get("nb_second_name")); 
            stmt.setString(76,(String)tabdata.get("nb_third_name")); 
            stmt.setString(77,(String)tabdata.get("nb_family_name_prefix")); 
            stmt.setString(78,(String)tabdata.get("nb_family_name")); 
            stmt.setString(79,(String)tabdata.get("nb_name_suffix")); 
            stmt.setString(80,(String)tabdata.get("nb_patient_name")); 
            stmt.setString(81,(String)tabdata.get("nb_name_prefix_loc_lang")); 
            stmt.setString(82,(String)tabdata.get("nb_first_name_loc_lang")); 
            stmt.setString(83,(String)tabdata.get("nb_second_name_loc_lang")); 
            stmt.setString(84,(String)tabdata.get("nb_third_name_loc_lang")); 
            stmt.setString(85,(String)tabdata.get("nb_family_name_loc_lang")); 
            stmt.setString(86,(String)tabdata.get("nb_name_suffix_loc_lang")); 
            stmt.setString(87,(String)tabdata.get("nb_patient_name_loc_lang")); 
            stmt.setString(88,(String)tabdata.get("father_name_prefix")); 
            stmt.setString(89,(String)tabdata.get("father_first_name")); 
            stmt.setString(90,(String)tabdata.get("father_second_name")); 
            stmt.setString(91,(String)tabdata.get("father_third_name")); 
            stmt.setString(92,(String)tabdata.get("father_family_name_prefix")); 
            stmt.setString(93,(String)tabdata.get("father_family_name")); 
            stmt.setString(94,(String)tabdata.get("father_name_suffix")); 
            stmt.setString(95,(String)tabdata.get("father_patient_name")); 
            stmt.setString(96,(String)tabdata.get("father_name_prefix_loc_lang")); 
            stmt.setString(97,(String)tabdata.get("father_first_name_loc_lang")); 
            stmt.setString(98,(String)tabdata.get("father_second_name_loc_lang")); 
            stmt.setString(99,(String)tabdata.get("father_third_name_loc_lang")); 
            stmt.setString(100,(String)tabdata.get("father_family_name_loc_lang")); 
            stmt.setString(101,(String)tabdata.get("father_name_suffix_loc_lang")); 
            stmt.setString(102,(String)tabdata.get("father_patient_name_loc_lang"));
					
			stmt.setString(103,(String)tabdata.get("finalized_yn")); 
            stmt.setString(104,(String)tabdata.get("complns_1st_stage_labour_code")); 
            stmt.setString(105,(String)tabdata.get("complns_2nd_stage_labour_code")); 
            stmt.setString(106,(String)tabdata.get("complns_3rd_stage_labour_code")); 
            stmt.setString(107,(String)tabdata.get("compln_pregnancy_code")); 
            stmt.setString(108,(String)tabdata.get("compln_nr_pregnancy_code")); 
			/*added for CCRF 689 & 695 Strats*/
			stmt.setString(109,heart_rate_in_1_min); 
			stmt.setString(110,heart_rate_in_5_min); 
			stmt.setString(111,heart_rate_in_10_min); 
			stmt.setString(112,breathing_in_1_min); 
			stmt.setString(113,breathing_in_5_min); 
			stmt.setString(114,breathing_in_10_min); 
			stmt.setString(115,grimace_in_1_min); 
			stmt.setString(116,grimace_in_5_min); 
			stmt.setString(117,grimace_in_10_min); 
			stmt.setString(118,activity_in_1_min); 
			stmt.setString(119,activity_in_5_min); 
			stmt.setString(120,activity_in_10_min); 
			stmt.setString(121,appearance_in_1_min); 
			stmt.setString(122,appearance_in_5_min); 
			stmt.setString(123,appearance_in_10_min);
			
			stmt.setString(124,(String)tabdata.get("antenatal_care")); 
			stmt.setString(125,(String)tabdata.get("ate_born_where")); 
			stmt.setString(126,(String)tabdata.get("ate_born_at_locn_type")); 
			stmt.setString(127,(String)tabdata.get("ate_born_at_locn_code"));
			/*added for CCRF 689 & 695 Ends*/			

			stmt.setString(128,date_of_birth_hj); //Added MMS-QH-CRF-0145.1 [IN:047497]
			
            stmt.setString(129,(String)tabdata.get("father_alt_id2_desc"));
            stmt.setString(130,(String)tabdata.get("father_alt_id2_no"));
            stmt.setString(131,(String)tabdata.get("father_alt_id3_desc"));
            stmt.setString(132,(String)tabdata.get("father_alt_id3_no"));
            stmt.setString(133,(String)tabdata.get("father_alt_id4_desc"));
            stmt.setString(134,(String)tabdata.get("father_alt_id4_no"));
            stmt.setString(135,(String)tabdata.get("father_alt_id1_desc"));
            stmt.setString(136,(String)tabdata.get("father_alt_id2_desc"));
            stmt.setString(137,(String)tabdata.get("father_alt_id3_desc")); 
            stmt.setString(138,(String)tabdata.get("father_alt_id4_desc"));
            stmt.setString(139,(String)tabdata.get("mthr_alt_id2_no"));
            stmt.setString(140,(String)tabdata.get("mthr_alt_id3_no"));
            stmt.setString(141,(String)tabdata.get("mthr_alt_id4_no"));
            stmt.setString(142,(String)tabdata.get("mthr_nat_id_no"));
            stmt.setString(143,(String)tabdata.get("mthr_oth_alt_id_No"));
            stmt.setString(144,(String)tabdata.get("oth_alt_id_type"));
			
			stmt.setString(145,(String)tabdata.get("patency_of_anus_checked_by_id"));//Added by Rameswar on 20-Jan-16 for ML-MMOH-CRF-0382

			stmt.setString(146,(String)tabdata.get("sel_accession_num"));//Added by Ashwini on 03-nov-2016 for MO-CRF-20108
			
            /*Below line added for this CRF ML-MMOH-CRF-0621*/
			stmt.setString(147,(String)tabdata.get("parity_on_admission"));
			stmt.setString(148,(String)tabdata.get("resuscit_attend_pract_id"));

            stmt.setString(149,(String)tabdata.get("patient_id"));
			
	
            int res2 = stmt.executeUpdate();
         
		  if(stmt!=null) stmt.close(); //checkstyle voilation
            if(res2!=0) 
			{
				gender = (String)tabdata.get("nb_sex");
                if(gender.equals("F"))
				{
                    //relnshp = " NB_FEMALE_RELNSHIP  ";
					hdRelnShp =  checkForNull((String)tabdata.get("nb_female_relnship"));
                }
				else if(gender.equals("M"))
				{
                    //relnshp = " NB_MALE_RELNSHIP  ";
					hdRelnShp =  checkForNull((String)tabdata.get("nb_male_relnship"));
                }
				else if(gender.equals("U"))
				{
                    //relnshp = " NB_UNKNOWN_RELNSHIP  ";
					hdRelnShp =  checkForNull((String)tabdata.get("nb_unknown_relnship"));
                }

				family_no_link_yn = checkForNull((String)tabdata.get("family_no_link_yn"),"N");				
				family_org_id_accept_yn = checkForNull((String)tabdata.get("family_org_id_accept_yn"),"N");		
                
				/*
                try 
				{
                    stmtk = con.prepareStatement(" select "+relnshp +", family_no_link_yn, family_org_id_accept_yn from MP_PARAM ");
                    rsetk = stmtk.executeQuery();
                    
                    if(rsetk != null)
					{
                        if(rsetk.next())
						{
                            hdRelnShp=rsetk.getString(1);
							if(hdRelnShp == null) hdRelnShp = "";
							if(hdRelnShp.equals(""))
								hdRelnShp = ((String)tabdata.get("sltRelationship")).trim();
							family_no_link_yn=rsetk.getString("family_no_link_yn");
							if(family_no_link_yn == null)family_no_link_yn = "N";
							family_org_id_accept_yn=rsetk.getString("family_org_id_accept_yn");
							if(family_org_id_accept_yn == null)family_org_id_accept_yn = "N";
                        }
                    }
                    if(rsetk != null) rsetk.close();
                    if(stmtk != null) stmtk.close();
                }
                catch(Exception e) 
				{
                    insertable = false;
					e.printStackTrace();
                }
				*/

                try{

					String alt_id1_no		 = "";	
					String alt_id1_type		 = "";		
					String family_org_sub_id = "";	
					String family_org_id	 = "";	
					String family_link_no	 = "";	
					
					if(family_org_id_accept_yn.equals("Y") ) //||family_no_link_yn.equals("Y")
					{
					   alt_id1_no		 = checkForNull((String)tabdata.get("alt_id1_no"));	
					   alt_id1_type		 = checkForNull((String)tabdata.get("mthr_alt_id1_type"));	
					   family_org_sub_id = checkForNull((String)tabdata.get("family_org_sub_id"));	
					   family_org_id	 = checkForNull((String)tabdata.get("family_org_id"));	
					   family_link_no	 = checkForNull((String)tabdata.get("HeadPatientid"));	

						/*
                       String sql_m="select ALT_ID1_NO,ALT_ID1_TYPE,FAMILY_ORG_SUB_ID,FAMILY_ORG_ID,FAMILY_LINK_NO from mp_patient where patient_id='"+mother_pat_id+"'";
					   stmtk = con.prepareStatement(sql_m);
					   rsetk = stmtk.executeQuery(); 
					   if(rsetk.next())
					   {
						   alt_id1_no		 = checkForNull(rsetk.getString("ALT_ID1_NO"));
						   alt_id1_type		 = checkForNull(rsetk.getString("ALT_ID1_TYPE"));
						   family_org_sub_id = checkForNull(rsetk.getString("FAMILY_ORG_SUB_ID"));
						   family_org_id	 = checkForNull(rsetk.getString("FAMILY_ORG_ID"));
						   family_link_no	 = checkForNull(rsetk.getString("FAMILY_LINK_NO"));

					   }				
					   if(family_org_id_accept_yn.equals("N")){
                          family_org_sub_id="";family_org_id="";
					   }
					   if(family_no_link_yn.equals("N")){
						   family_link_no="";
					   }
					   */

					} else {  						
						if(!father_patient_id.equals(""))
							family_link_no = father_patient_id;
						else
							family_link_no =  mother_pat_id;
					}
					
					//end
					StringBuffer stbuff=new StringBuffer();
					String baby_bed_number = (String)tabdata.get("bed_number");
					String mother_bed_number = (String)tabdata.get("mother_bed_no");

					stbuff.append("update  MP_PATIENT set sex=?, RELATIONSHIP_TO_HEAD=?,");
					if(family_org_id_accept_yn.equals("Y")) {                      									stbuff.append("pat_cat_code=?, PAT_CAT_CODE_EXP_DATE=to_date(?,'dd/mm/yyyy'), 		ALT_ID1_NO=?, ALT_ID1_TYPE=?, FAMILY_ORG_SUB_ID=?, FAMILY_ORG_ID=?,");
					}
					stbuff.append("FAMILY_LINK_NO=?, BED_ASSIGNED_FOR_NB_YN=?, FATHER_PATIENT_ID=?, MOTHER_PATIENT_ID=?, NAME_PREFIX=?, FIRST_NAME=?, SECOND_NAME=?, THIRD_NAME=?, FAMILY_NAME_PREFIX=?, FAMILY_NAME=?, NAME_SUFFIX=?, PATIENT_NAME=?, NAME_PREFIX_LOC_LANG=?, FIRST_NAME_LOC_LANG=?, SECOND_NAME_LOC_LANG=?, THIRD_NAME_LOC_LANG=?, FAMILY_NAME_LOC_LANG=?, NAME_SUFFIX_LOC_LANG=?, PATIENT_NAME_LOC_LANG=?,MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where patient_id=?");
                    if(stmt!=null) stmt.close(); //checkstyle voilation
					stmt = con.prepareStatement(stbuff.toString());                
					stmt.setString(1,(String)tabdata.get("nb_sex"));

					if(family_org_id_accept_yn.equals("Y"))
					{
						
						  stmt.setString(2,(String)tabdata.get("relation_child"));
						  stmt.setString(3,(String)tabdata.get("relation_child11"));
						  stmt.setString(4,(String)tabdata.get("exp_cat_date"));						 
						  stmt.setString(5,alt_id1_no);
						  stmt.setString(6,alt_id1_type);
						  stmt.setString(7,family_org_sub_id);
						  stmt.setString(8,family_org_id);
						  stmt.setString(9,family_link_no);
						  if(!baby_bed_number.equals("")&&!mother_bed_number.equals(""))
						  {
							stmt.setString(10,"Y");
						  }
						  else
						  {
							stmt.setString(10,"N");
						  }
						  stmt.setString(11,father_patient_id);  
						  stmt.setString(12,mother_pat_id); 

						  stmt.setString(13,(String)tabdata.get("sltRelationship")); 
						  stmt.setString(14,(String)tabdata.get("nb_first_name")); 
						  stmt.setString(15,(String)tabdata.get("nb_second_name")); 
						  stmt.setString(16,(String)tabdata.get("nb_third_name")); 
						  stmt.setString(17,(String)tabdata.get("nb_family_name_prefix")); 
						  stmt.setString(18,(String)tabdata.get("nb_family_name")); 
						  stmt.setString(19,(String)tabdata.get("nb_name_suffix")); 
						  stmt.setString(20,(String)tabdata.get("nb_patient_name")); 
						  stmt.setString(21,(String)tabdata.get("nb_name_prefix_loc_lang")); 
						  stmt.setString(22,(String)tabdata.get("nb_first_name_loc_lang")); 
						  stmt.setString(23,(String)tabdata.get("nb_second_name_loc_lang")); 
						  stmt.setString(24,(String)tabdata.get("nb_third_name_loc_lang")); 
						  stmt.setString(25,(String)tabdata.get("nb_family_name_loc_lang")); 
						  stmt.setString(26,(String)tabdata.get("nb_name_suffix_loc_lang")); 
						  stmt.setString(27,(String)tabdata.get("nb_patient_name_loc_lang")); 
						  stmt.setString(28,(String)tabdata.get("added_by_id"));
                          stmt.setString(29,(String)tabdata.get("added_at_ws_no"));
                          stmt.setString(30,(String)tabdata.get("added_facility_id"));
						  stmt.setString(31,(String)tabdata.get("patient_id"));
				  }
				  else
				   {
					 	stmt.setString(2,hdRelnShp);
						stmt.setString(3,family_link_no);

						if(!baby_bed_number.equals("")&&!mother_bed_number.equals("")) {
							stmt.setString(4,"Y");
						} else {
							stmt.setString(4,"N");
						}
						stmt.setString(5,father_patient_id);  
					    stmt.setString(6,mother_pat_id); 

						stmt.setString(7,(String)tabdata.get("nb_name_prefix")); 
						stmt.setString(8,(String)tabdata.get("nb_first_name")); 
						stmt.setString(9,(String)tabdata.get("nb_second_name")); 
						stmt.setString(10,(String)tabdata.get("nb_third_name")); 
						stmt.setString(11,(String)tabdata.get("nb_family_name_prefix")); 
						stmt.setString(12,(String)tabdata.get("nb_family_name")); 
						stmt.setString(13,(String)tabdata.get("nb_name_suffix")); 
						stmt.setString(14,(String)tabdata.get("nb_patient_name")); 
						stmt.setString(15,(String)tabdata.get("nb_name_prefix_loc_lang")); 
						stmt.setString(16,(String)tabdata.get("nb_first_name_loc_lang")); 
						stmt.setString(17,(String)tabdata.get("nb_second_name_loc_lang")); 
						stmt.setString(18,(String)tabdata.get("nb_third_name_loc_lang")); 
						stmt.setString(19,(String)tabdata.get("nb_family_name_loc_lang")); 
						stmt.setString(20,(String)tabdata.get("nb_name_suffix_loc_lang")); 
						stmt.setString(21,(String)tabdata.get("nb_patient_name_loc_lang")); 

						stmt.setString(22,(String)tabdata.get("patient_id"));
					}
								
                res2 = stmt.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
                if(res2!=0) 
				{
                    insertable = true;
                }
                else 
				{
                    insertable = false;
                    sb.append(" Update of MP_PATIENT Failed");
                }
            }
            else
			{
                insertable = false;
                sb.append(" Update of MP_BIRTH_REGISTER has failed here inside the Bean ");
            }

			if(insertable)
			{
				if(stmt != null) stmt.close();

				try
				{
					stmt =con.prepareStatement("update MP_PAT_OTH_DTLS set BLOOD_GRP= ?, RH_FACTOR =?, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where PATIENT_ID = ?");	

					stmt.setString(1,checkForNull((String)tabdata.get("blood_group")));
                    stmt.setString(2,checkForNull((String)tabdata.get("rf_code")));
                    stmt.setString(3,(String)tabdata.get("added_by_id"));
                    stmt.setString(4,(String)tabdata.get("added_at_ws_no"));
                    stmt.setString(5,(String)tabdata.get("added_facility_id"));
                    stmt.setString(6,patient_id);
                   
                    int res4 = stmt.executeUpdate();
                                    
                    if(res4!=0)
					{
                         insertable = true;
                    }
					else
					{
                         insertable = false;
                         sb.append(" update of MP_PAT_OTH_DTLS has failed ");
                    }
					if(stmt != null) stmt.close(); //Added for checkstyle
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			/*added for CCRF 689 & 695 Strats*/
			if(((String)tabdata.get("outcome")).equals("S")){
				String babyID=(String)tabdata.get("patient_id");
				String stillBirthCheck="select count(*) from mp_still_birth_details where patient_id='"+babyID+"'";
				stmt=con.prepareStatement(stillBirthCheck);
				ResultSet rsCheck=stmt.executeQuery();
				int stillBirthCount=0;
				if(rsCheck!=null && rsCheck.next()){
					stillBirthCount = rsCheck.getInt(1);
				}
				if(rsCheck!=null)rsCheck.close();
				if(stmt!=null)stmt.close();
				if(stillBirthCount ==1){				
					String stillBirthDtlsSql="update mp_still_birth_details set auth_practitioner_id =?, attendant_at_birth =?,autopsy_reqd_yn =?,mate_cond_main_cod =?,mate_cond_main_cod_dur =?,mate_cond_oth_cod =?,mate_cond_oth_cod_dur =?,mate_cond_preexist_cod =?,mate_cond_preexist_cod_dur =?,oth_rel_mate_cond_rel_cod =?,oth_rel_mate_cond_rel_cod_dur =?,cond_cau_dea_main_cod =?,cond_cau_dea_main_cod_dur =?,cond_cau_dea_oth_cod =?,cond_cau_dea_oth_cod_dur =?,cond_cau_dea_preexist_cod =?,cond_cau_dea_preexist_cod_dur =?,rel_cond_cau_dea_rel_cod =?,rel_cond_cau_dea_rel_cod_dur =?, modified_by_id=?, modified_date=sysdate, modified_at_ws_no=?, modified_facility_id=? where patient_id=?";
					stmt=con.prepareStatement(stillBirthDtlsSql.toString());
					stmt.setString(1,pract_id_still_birth);
					stmt.setString(2,attendant_at_birth);
					stmt.setString(3,autopsy_reqd_yn);
					stmt.setString(4,mate_cond_main_cod);
					stmt.setString(5,mate_cond_main_cod_dur);
					stmt.setString(6,mate_cond_oth_cod);
					stmt.setString(7,mate_cond_oth_cod_dur);
					stmt.setString(8,mate_cond_preexist_cod);
					stmt.setString(9,mate_cond_preexist_cod_dur);
					stmt.setString(10,oth_rel_mate_cond_rel_cod);
					stmt.setString(11,oth_rel_mate_cond_rel_cod_dur);
					stmt.setString(12,cond_cau_dea_main_cod);
					stmt.setString(13,cond_cau_dea_main_cod_dur);
					stmt.setString(14,cond_cau_dea_oth_cod);
					stmt.setString(15,cond_cau_dea_oth_cod_dur);
					stmt.setString(16,cond_cau_dea_preexist_cod);
					stmt.setString(17,cond_cau_dea_preexist_cod_dur);
					stmt.setString(18,rel_cond_cau_dea_rel_cod);
					stmt.setString(19,rel_cond_cau_dea_rel_cod_dur);
					stmt.setString(20,(String)tabdata.get("added_by_id"));
					stmt.setString(21,(String)tabdata.get("added_at_ws_no"));
					stmt.setString(22,(String)tabdata.get("added_facility_id"));
					stmt.setString(23,(String)tabdata.get("patient_id"));
					int resStillBirth = stmt.executeUpdate();
					if(resStillBirth!=0){
						insertable = true;
					}else{
						insertable = false;
						sb.append(" Insert into mp_still_birth_details has failed");
					}
				}else{
					String stillBirthDtlsSql="insert into mp_still_birth_details(patient_id, auth_practitioner_id, attendant_at_birth, autopsy_reqd_yn, mate_cond_main_cod, mate_cond_main_cod_dur, mate_cond_oth_cod, mate_cond_oth_cod_dur, mate_cond_preexist_cod, mate_cond_preexist_cod_dur, oth_rel_mate_cond_rel_cod, oth_rel_mate_cond_rel_cod_dur, cond_cau_dea_main_cod, cond_cau_dea_main_cod_dur, cond_cau_dea_oth_cod, cond_cau_dea_oth_cod_dur, cond_cau_dea_preexist_cod, cond_cau_dea_preexist_cod_dur, rel_cond_cau_dea_rel_cod, rel_cond_cau_dea_rel_cod_dur,added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
					pstmt2=con.prepareStatement(stillBirthDtlsSql.toString());
					pstmt2.setString(1,babyID);
					pstmt2.setString(2,pract_id_still_birth);
					pstmt2.setString(3,attendant_at_birth);
					pstmt2.setString(4,autopsy_reqd_yn);
					pstmt2.setString(5,mate_cond_main_cod);
					pstmt2.setString(6,mate_cond_main_cod_dur);
					pstmt2.setString(7,mate_cond_oth_cod);
					pstmt2.setString(8,mate_cond_oth_cod_dur);
					pstmt2.setString(9,mate_cond_preexist_cod);
					pstmt2.setString(10,mate_cond_preexist_cod_dur);
					pstmt2.setString(11,oth_rel_mate_cond_rel_cod);
					pstmt2.setString(12,oth_rel_mate_cond_rel_cod_dur);
					pstmt2.setString(13,cond_cau_dea_main_cod);
					pstmt2.setString(14,cond_cau_dea_main_cod_dur);
					pstmt2.setString(15,cond_cau_dea_oth_cod);
					pstmt2.setString(16,cond_cau_dea_oth_cod_dur);
					pstmt2.setString(17,cond_cau_dea_preexist_cod);
					pstmt2.setString(18,cond_cau_dea_preexist_cod_dur);
					pstmt2.setString(19,rel_cond_cau_dea_rel_cod);
					pstmt2.setString(20,rel_cond_cau_dea_rel_cod_dur);
					pstmt2.setString(21,(String)tabdata.get("added_by_id"));
					pstmt2.setString(22,(String)tabdata.get("added_at_ws_no"));
					pstmt2.setString(23,(String)tabdata.get("added_facility_id"));
					pstmt2.setString(24,(String)tabdata.get("added_by_id"));
					pstmt2.setString(25,(String)tabdata.get("added_at_ws_no"));
					pstmt2.setString(26,(String)tabdata.get("added_facility_id"));
					res2 = pstmt2.executeUpdate();
					if(res2!=0){
					insertable = true;
					}else{
					insertable = false;
					sb.append(" Insert into mp_still_birth_details has failed");
					}
					if(pstmt2!=null)pstmt2.close();
				}
			}
			/*added for CCRF 689 & 695 Ends*/
            
  /** The following section updates bed no If IP is Installed and the entered bed no isn't blank **/
            if(called_function.equals("IP")) 
			{
                String temp_baby_bed_no_old = (String)tabdata.get("old_bed_number");
                String temp_baby_bed_no_new = (String)tabdata.get("bed_number");                
                if(ip_install_yn.equals("Y") && !(temp_baby_bed_no_old.equals("")&& temp_baby_bed_no_new.equals(""))) 
				{
                    if(insertable) 
					{
                        try 
						{
                            if(stmt != null) stmt.close();
                            String old_bed_no = (String)tabdata.get("old_bed_number");
                            String new_bed_no = (String)tabdata.get("bed_number");
                            if(!old_bed_no.equals(new_bed_no)) 
							{
                                if(!new_bed_no.equals("")) 
								{
									stmt =con.prepareStatement("update ip_nursing_unit_bed set OCCUPYING_PATIENT_ID= ?, CURRENT_STATUS ='O', MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,MOTHERS_PATIENT_ID=?,MOTHERS_ENCOUNTER_ID=? where facility_id = ? and nursing_unit_code = ? and bed_no = ? and main_bed_no = ?");
                                    
                                    stmt.setString(1,patient_id);
                                    stmt.setString(2,(String)tabdata.get("added_by_id"));
                                    stmt.setString(3,(String)tabdata.get("added_at_ws_no"));
                                    stmt.setString(4,(String)tabdata.get("added_facility_id"));
                                    stmt.setString(5,mother_pat_id);
                                    stmt.setString(6,(String)tabdata.get("mother_encounter_id"));
                                    stmt.setString(7, facilityId);
                                    stmt.setString(8,(String)tabdata.get("mother_nursing_unit_code"));
                                    stmt.setString(9,(String)tabdata.get("bed_number"));
                                    stmt.setString(10,(String)tabdata.get("mother_bed_no"));
                                    
                                    int res4 = stmt.executeUpdate();
                                    
                                    if(res4!=0)
									{
                                        insertable = true;
                                    }
									else
									{
                                        insertable = false;
                                        sb.append(" update of ip_nursing_unit_bed has failed ");
                                    }
                                     if ( (insertable) &&  ((String)tabdata.get("outcome")).equals("L") ) 
									{
                                        try
										{											
                                            if(stmt != null) stmt.close();
                                            String sql_ip_nb3 = " update ip_open_encounter set BABY_LINKED_YN = 'Y',MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where facility_id = ? and encounter_id = ? ";
                                            stmt =con.prepareStatement(sql_ip_nb3);
											stmt.setString(1,(String)tabdata.get("added_by_id"));
                                            stmt.setString(2,(String)tabdata.get("added_at_ws_no"));
                                            stmt.setString(3,(String)tabdata.get("added_facility_id"));
                                            stmt.setString(4, facilityId);
                                            stmt.setString(5,(String)tabdata.get("mother_encounter_id"));
                                            int res8 = stmt.executeUpdate();
                                            if(res8!=0)
											{
                                                insertable = true;
                                            }
											else
											{
                                                insertable = false;
                                                sb.append(" Insert into ip_open_encounter has failed ");
                                            }
                                        }
                                        catch(Exception e) 
										{
                                            sb.append(e.toString());
											e.printStackTrace();
                                        }
                                    }
                                }//check blank bed ends
                                if(insertable)
								{
                                    if(!old_bed_no.equals("")) 
									{
                                        if(stmt != null) stmt.close();
                                        stmt = con.prepareStatement("update ip_nursing_unit_bed set OCCUPYING_PATIENT_ID=null, CURRENT_STATUS ='A', MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, MOTHERS_PATIENT_ID=null, MOTHERS_ENCOUNTER_ID=null where facility_id = ? and nursing_unit_code = ? and bed_no = ? and main_bed_no = ?");
                                        
                                        stmt.setString(1,(String)tabdata.get("added_by_id"));
                                        stmt.setString(2,(String)tabdata.get("added_at_ws_no"));
                                        stmt.setString(3,(String)tabdata.get("added_facility_id"));
                                        stmt.setString(4, facilityId);
										stmt.setString(5,(String)tabdata.get("mother_nursing_unit_code"));
                                        stmt.setString(6,(String)tabdata.get("old_bed_number"));
                                        stmt.setString(7,(String)tabdata.get("mother_bed_no"));
                                        
                                        int res5 = stmt.executeUpdate();
                                        
                                        if(res5!=0)
										{
                                            insertable = true;
                                        }
										else 
										{
                                            insertable = false;
                                            sb.append(" update into ip_nursing_unit_bed has failed ");
                                        }
                                    }
									/* Commented by Krishnan as this update will nullify the previous update

										else if ( (insertable) &&  ((String)tabdata.get("outcome")).equals("L") )
									{
										try
										{
											if(stmt != null) stmt.close();
											String sql_ip_nb2 = "UPDATE ip_open_encounter SET BABY_DELINKED_YN = 'Y', BABY_LINKED_YN = 'N' WHERE facility_id = ? AND encounter_id = ? ";
											stmt =con.prepareStatement(sql_ip_nb2);
											stmt.setString(1, facilityId);
											stmt.setString(2,(String)tabdata.get("mother_encounter_id"));
											int res7 = stmt.executeUpdate();
											if(res7!=0){
												insertable = true;
											}else {
												insertable = false;
												sb.append(" update of ip_open_encounter has failed ");
											}
										}
										catch(Exception e)
										{								
											sb.append(e.toString());
										}
									}*/
                                }//end for if insertable
                            }//else for old and new bed no
						}
                        catch(Exception e) 
						{
							sb.append(e.toString());
							e.printStackTrace();
                        }
                    }
                }//end of ip install chk
            }//end of call_fucntion  chk
        
            MessageManager mess = new MessageManager();
            if(insertable)
			{ 
                sb.append("patient_id"+patient_id);
                result = true ;
                con.commit();
                final java.util.Hashtable message = mess.getMessage( locale, RECORD_INSERTED, "SM" ) ;
                sbMessage.append( (String) message.get("message") );
				message.clear();
            }
            else
			{
                con.rollback();
                sb.append("Transaction Failed");
            }
            if(rset != null) rset.close();
            if(stmt != null) stmt.close();
            if(stmt1 != null) stmt1.close();           
        }catch(Exception e){
			sb.append("Catch :"+e.toString());
			e.printStackTrace();
        }finally{
            if(con != null) ConnectionManager.returnConnection(con,p);
        }
				
        results.put("status",new Boolean(result));
        results.put("error",sb.toString());
        results.put("patient",patient_id);
        results.put("ResultFromMessageManager", sbMessage.toString());
        results.put("active",active_yn);
        results.put("debug_message",sb);
        results.put("mother_id",checkForNull((String)tabdata.get("mother_patient_id")));
        sb.setLength(0);
		return results;
    }
    private void showModalForOldFileNo(String facility_id, String pat_ser_grp_code, String GeneratedFileNo, String gen_file_no, String OldFilePrompt, boolean showModal, String maintain_doc_or_file, String sStyle, String function_name_nb,String function_id_mg,String called_from_mothercare,String single_stage_nb_reg_appl_yn, String mother_id, String nbUseMotherSer, String patIidLength, String nbPatSerGrp, String invkAdmFrmNBYn, String ipInstallYn, String siteId,String called_from,String patient_id,HashMap results,StringBuffer sb) 
	{
	//	StringBuffer sb  = new StringBuffer();
        try 
		{
			gen_file_no = gen_file_no;
			OldFilePrompt = OldFilePrompt;
			
            /*String outputVal="<html>"+
            "<head>"+
            "<link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link>"+
            "<script>"+
            "function showModal(){"+
            "var retVal;"+
            "var dialogHeight   = '18' ;"+
            "var dialogWidth    = '23' ;"+
            "var features   = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';"+
            "var arguments  = '"+GeneratedFileNo+"' ;"+
            "retVal = window.showModalDialog('../eMP/jsp/CallCreateFileComponent.jsp?Called_From=MP&Location_Type=null&Location_Code=null&P_Patient_ID="+patient_id+"&P_Pat_Ser_Grp_Code="+pat_ser_grp_code+"',arguments,features);"+
            "if(retVal== null)  retVal = '';" +
            "var arr = retVal.split('`');  " +
            "document.all.old_file_no.value = arr[0];   "+

            "document.form1.submit();"+
            "}"+
            "</script>"+
            "</head>"+
            "<body class='message'>"+
            "<form name='form1' method='post' action='../servlet/eMP.NewbornRegistrationServlet' target='messageFrame'>"+
            "<input type='hidden' name='old_file_no'></input>"+
            "<input type='hidden' name='fs_locn_code'></input>"+
            "<input type='hidden' name='pat_ser_grp_code' value='"+pat_ser_grp_code+"'></input>"+
            "<input type='hidden' name='patient_id' value='"+patient_id+"'></input>"+
            "<input type='hidden' name='facility_id' value='"+facility_id+"'></input>"+
            "<input type='hidden' name='gen_file_no' value='"+GeneratedFileNo+"'></input>"+
            "<input type='hidden' name='sStyle' value='"+sStyle+"'></input>"+
			"<input type='hidden' name='maintain_doc_or_file' value='"+maintain_doc_or_file+"'></input>"+
			"<input type='hidden' name='function_name_nb' value='"+function_name_nb+"'></input>"+
			"<input type='hidden' name='function_id_mg' value='"+function_id_mg+"'></input>"+

			"<input type='hidden' name='nb_use_mother_ser' value='"+nbUseMotherSer+"'></input>"+
			"<input type='hidden' name='called_from' value='"+called_from+"'></input>"+
			"<input type='hidden' name='maxLength' value='"+patIidLength+"'></input>"+
			"<input type='hidden' name='newborn_pat_ser_grp' value='"+nbPatSerGrp+"'></input>"+
			"<input type='hidden' name='invoke_adm_from_newborn_yn' value='"+invkAdmFrmNBYn+"'></input>"+
			"<input type='hidden' name='ip_install_yn' value='"+ipInstallYn+"'></input>"+
			"<input type='hidden' name='siteId' value='"+siteId+"'></input>"+

			"<input type='hidden' name='called_from_mothercare' value='"+called_from_mothercare+"'></input>"+
			"<input type='hidden' name='mother_id' value='"+mother_id+"'></input>"+
			"<input type='hidden' name='single_stage_nb_reg_appl_yn' value='"+single_stage_nb_reg_appl_yn+"'></input>"+
            "<input type='hidden' name='function_name' value='update_file_no'></input> "+
            "</form>"+
            "<script>"+
            "if("+showModal+")showModal();"+
            "else {document.form1.submit();}" +
            "</script>"+
            "</body>"+
            "</html>";*/
			
			/*String outputVal="<html>"+
		           "<head>"+
		           "<link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link>"+
		           "<script>"+
		           "async function showModal(){"+
		           "var retVal;"+
		            "var dialogHeight   = '18' ;"+
		            "var dialogWidth    = '23' ;"+
		            "var features   = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';"+
		            "var arguments  = '"+GeneratedFileNo+"' ;"+
		            "retVal = await window.showModalDialog('../eMP/jsp/CallCreateFileComponent.jsp?Called_From=MP&Location_Type=null&Location_Code=null&P_Patient_ID="+patient_id+"&P_Pat_Ser_Grp_Code="+pat_ser_grp_code+"',arguments,features);"+
		            "if(retVal== null)  retVal = '';" +
		            "var arr = retVal.split('`');  " +
		            "document.getElementById('old_file_no').value = arr[0];   "+

		            "document.form1.submit();"+
		            "}"+
		            "</script>"+
		            "</head>"+
		            "<body class='message'>"+*/
		            String outputVal="var HTMLVal = `<form name='form1' method='post' action='../servlet/eMP.NewbornRegistrationServlet' target='messageFrame'>"+
		            "<input type='hidden' id='old_file_no' name='old_file_no'></input>"+
		            "<input type='hidden' id='fs_locn_code' name='fs_locn_code'></input>"+
		            "<input type='hidden' id='pat_ser_grp_code' name='pat_ser_grp_code' value='"+pat_ser_grp_code+"'></input>"+
		            "<input type='hidden' id='patient_id' name='patient_id' value='"+patient_id+"'></input>"+
		            "<input type='hidden' id='facility_id' name='facility_id' value='"+facility_id+"'></input>"+
		            "<input type='hidden' id='gen_file_no' name='gen_file_no' value='"+GeneratedFileNo+"'></input>"+
		            "<input type='hidden' id='sStyle' name='sStyle' value='"+sStyle+"'></input>"+
					"<input type='hidden' id='maintain_doc_or_file' name='maintain_doc_or_file' value='"+maintain_doc_or_file+"'></input>"+
					"<input type='hidden' id='function_name_nb' name='function_name_nb' value='"+function_name_nb+"'></input>"+
					"<input type='hidden' id='function_id_mg'  name='function_id_mg' value='"+function_id_mg+"'></input>"+

					"<input type='hidden' id='nb_use_mother_ser' name='nb_use_mother_ser' value='"+nbUseMotherSer+"'></input>"+
					"<input type='hidden' id='called_from' name='called_from' value='"+called_from+"'></input>"+
					"<input type='hidden' id='maxLength'  name='maxLength' value='"+patIidLength+"'></input>"+
					"<input type='hidden' id='newborn_pat_ser_grp' name='newborn_pat_ser_grp' value='"+nbPatSerGrp+"'></input>"+
					"<input type='hidden' id='invoke_adm_from_newborn_yn' name='invoke_adm_from_newborn_yn' value='"+invkAdmFrmNBYn+"'></input>"+
					"<input type='hidden' id='ip_install_yn' name='ip_install_yn' value='"+ipInstallYn+"'></input>"+
					"<input type='hidden' id='siteId' name='siteId' value='"+siteId+"'></input>"+

					"<input type='hidden' id='called_from_mothercare' name='called_from_mothercare' value='"+called_from_mothercare+"'></input>"+
					"<input type='hidden' id='mother_id'  name='mother_id' value='"+mother_id+"'></input>"+
					"<input type='hidden' id='single_stage_nb_reg_appl_yn' name='single_stage_nb_reg_appl_yn' value='"+single_stage_nb_reg_appl_yn+"'></input>"+
		            "<input type='hidden' id='function_name' name='function_name' value='update_file_no'></input> "+
		            "</form>`;self.document.write(HTMLVal);"+
		            //"<script>"+
		            "if("+showModal+")"+
		            "{" +
		            "var retVal;"+
		            "var dialogHeight   = '35vh' ;"+
		            "var dialogWidth    = '30vw' ;"+
		            "var features   = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';"+
		            "var arguments  = '"+GeneratedFileNo+"' ;"+
		            "retVal = await window.showModalDialog('../../eMP/jsp/CallCreateFileComponent.jsp?Called_From=MP&Location_Type=null&Location_Code=null&P_Patient_ID="+patient_id+"&P_Pat_Ser_Grp_Code="+pat_ser_grp_code+"',arguments,features);"+
		            "if(retVal== null)  retVal = '';" +
		            "var arr = retVal.split('`');  " +
		            "document.getElementById('old_file_no').value = arr[0];   "+

		            "document.form1.submit();await new Promise(resolve => setTimeout(resolve, 1000));"+
		            "}"+
		            "else {document.form1.submit();await new Promise(resolve => setTimeout(resolve, 1000));}" ;
		            //"</script>"+
		            //"</body>"+
		            //"</html>";

            results.put("MRNPrompt", outputVal) ;
        }catch(Exception e) {
            sb.append("error in calling modal window "+e.toString());
			e.printStackTrace();
        }
	//	results.put("showModalForOldFileNoErrors", sb.toString()) ;

		
    }
   
   private boolean updateBilling(String mode,HashMap tabdata,Properties p,Connection con,String patient_id,HashMap results,StringBuffer sb) { 
		boolean insertable = true;
        Hashtable hashBL = new Hashtable();
	//	StringBuffer sb  = new StringBuffer();
		String locale="";
		String bl_success_msg	= "";
		locale=p.getProperty("LOCALE");
		PreparedStatement pstmt2	= null;
		ResultSet rset				= null;
        try {  
				hashBL.put("patient_id",tabdata.get("patient_id"));
				hashBL.put("pat_ser_grp_code",tabdata.get("pat_ser_grp_code"));
				hashBL.put("mother_patient_id",tabdata.get("mother_patient_id"));
				hashBL.put("mother_encounter_id",tabdata.get("mother_encounter_id"));
				hashBL.put("nb_sex",tabdata.get("nb_sex"));hashBL.put("bbayn",tabdata.get("bbayn"));
				hashBL.put("born_at",tabdata.get("born_at"));hashBL.put("outcome",tabdata.get("outcome"));
				hashBL.put("indicator_mark",tabdata.get("indicator_mark"));
				hashBL.put("bcg_datetime",tabdata.get("bcg_datetime"));
				hashBL.put("vitk_datetime",tabdata.get("vitk_datetime"));
				hashBL.put("hepb_datetime",tabdata.get("hepb_datetime"));
				hashBL.put("ip_install_yn",tabdata.get("ip_install_yn"));
				hashBL.put("mother_nursing_unit_code",tabdata.get("mother_nursing_unit_code"));
				hashBL.put("mother_bed_no",tabdata.get("mother_bed_no"));
				hashBL.put("bed_number",tabdata.get("bed_number"));
				hashBL.put("called_function",tabdata.get("called_function"));
				hashBL.put("date_of_birth",tabdata.get("date_of_birth"));
				hashBL.put("time_of_birth",tabdata.get("time_of_birth"));
				hashBL.put("weight",tabdata.get("weight"));hashBL.put("weight_unit",tabdata.get("weight_unit"));
				hashBL.put("circumference",tabdata.get("circumference"));
				hashBL.put("circumference_unit",tabdata.get("circumference_unit"));
				hashBL.put("chest_circumference_unit",tabdata.get("chest_circumference_unit"));
				hashBL.put("length",tabdata.get("length"));hashBL.put("length_unit",tabdata.get("length_unit"));
				hashBL.put("gestational_period",tabdata.get("gestational_period"));
				hashBL.put("gestational_unit",tabdata.get("gestational_unit"));
				hashBL.put("apgar_score",tabdata.get("apgar_score"));
				hashBL.put("umbilical_cord_status",tabdata.get("umbilical_cord_status"));
				hashBL.put("born_at_locn_type",tabdata.get("born_at_locn_type"));
				hashBL.put("born_at_locn_code",tabdata.get("born_at_locn_code"));
				hashBL.put("patency_of_anus_yn",tabdata.get("patency_of_anus_yn"));
				hashBL.put("multiple_birth_yn",tabdata.get("multiple_birth_yn"));
				hashBL.put("no_of_birth",tabdata.get("no_of_birth"));
				hashBL.put("name_suffix",tabdata.get("name_suffix"));
				hashBL.put("nod_type",tabdata.get("nod_type"));hashBL.put("gravida",tabdata.get("gravida"));
				hashBL.put("parity",tabdata.get("parity"));hashBL.put("feeding",tabdata.get("feeding"));
				hashBL.put("stools",tabdata.get("stools"));
				hashBL.put("complications",tabdata.get("complications"));
				hashBL.put("attend_physician_id",tabdata.get("attend_physician_id"));
				hashBL.put("attend_midwife_id",tabdata.get("attend_midwife_id"));
				hashBL.put("father_patient_id",tabdata.get("father_patient_id"));
				hashBL.put("mother_patient_id",tabdata.get("mother_patient_id"));
				hashBL.put("father_name",tabdata.get("father_name"));
				hashBL.put("fatherRemarks",tabdata.get("fatherRemarks"));
				hashBL.put("inhouse_birth_yn",tabdata.get("inhouse_birth_yn"));
				hashBL.put("pat_no_gen_yn",tabdata.get("pat_no_gen_yn"));
				hashBL.put("chest_circumference",tabdata.get("chest_circumference"));
				hashBL.put("bcg_given_yn",tabdata.get("bcg_given_yn"));
				hashBL.put("vitak_given_yn",tabdata.get("vitak_given_yn"));
				hashBL.put("hep_given_yn",tabdata.get("hep_given_yn"));
				hashBL.put("vaccination_site",tabdata.get("vaccination_site"));
				hashBL.put("vitak_vacc_site",tabdata.get("vitak_vacc_site"));
				hashBL.put("hepb_vacc_site",tabdata.get("hepb_vacc_site"));
				hashBL.put("remarks",tabdata.get("remarks"));
				hashBL.put("apgar_score_in_5_mins",tabdata.get("apgar_score_in_5_mins"));
				hashBL.put("apgar_score_in_10_mins",tabdata.get("apgar_score_in_10_mins"));
				hashBL.put("community_nurse",tabdata.get("community_nurse"));
				hashBL.put("complications_delivery",tabdata.get("complications_delivery"));
				hashBL.put("nb_complication_delivery",tabdata.get("nb_complication_delivery"));
				hashBL.put("Congenital_Anomalies",tabdata.get("Congenital_Anomalies"));
				hashBL.put("administeredBy",tabdata.get("administeredBy"));
				hashBL.put("vitak_administered_By",tabdata.get("vitak_administered_By"));
				hashBL.put("hepb_administered_By",tabdata.get("hepb_administered_By"));
				hashBL.put("Designation",tabdata.get("Designation"));
				hashBL.put("hepb_administered_Designation",tabdata.get("hepb_administered_Designation"));
				hashBL.put("vitak_administered_Designation",tabdata.get("vitak_administered_Designation"));
				hashBL.put("National_id",tabdata.get("National_id"));
				hashBL.put("cboOtherAltID",tabdata.get("cboOtherAltID"));
				hashBL.put("txtOtherAltID",tabdata.get("txtOtherAltID"));
				hashBL.put("cboNationality",tabdata.get("cboNationality"));
				hashBL.put("cboEthnicGroup",tabdata.get("cboEthnicGroup"));
				hashBL.put("cboReligion",tabdata.get("cboReligion"));
				hashBL.put("cboOccupationClass",tabdata.get("cboOccupationClass"));
				hashBL.put("cboOccupation",tabdata.get("cboOccupation"));
				hashBL.put("Occupation_Desc",tabdata.get("Occupation_Desc"));
				hashBL.put("fatherRemarks",tabdata.get("fatherRemarks"));
				hashBL.put("fthGovtEmpl",tabdata.get("fthGovtEmpl"));
				hashBL.put("Mother_Pmi_no",tabdata.get("Mother_Pmi_no"));
				hashBL.put("Dely_ind_code",tabdata.get("Dely_ind_code"));
				hashBL.put("Proc_class_Code",tabdata.get("Proc_class_Code"));
				hashBL.put("Vaginal_dely_type_code",tabdata.get("Vaginal_dely_type_code"));
				hashBL.put("Dely_surg_class_code",tabdata.get("Dely_surg_class_code"));
				hashBL.put("birth_place_code",tabdata.get("birth_place_code"));
				hashBL.put("birth_certificate_no",tabdata.get("birth_certificate_no"));
				hashBL.put("generate_file",tabdata.get("generate_file"));
				hashBL.put("bl_install_yn",tabdata.get("bl_install_yn"));
				hashBL.put("dflt_nb_regn_blng_class",tabdata.get("dflt_nb_regn_blng_class"));
				
			String sql = "SELECT bl_get_new_born_billing_group(?) FROM DUAL";
			String strBG = "", settlement_ind = "";
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setString(1,(String)tabdata.get("mother_patient_id"));
			rset = pstmt2.executeQuery();
			while(rset.next()) {
				strBG = rset.getString(1) == null ? "" : rset.getString(1);
			}
			if(pstmt2 != null) pstmt2.close(); if(rset != null) rset.close();
			pstmt2 = con.prepareStatement(" select settlement_ind from bl_blng_grp where blng_grp_id = ? ");
			pstmt2.setString(1,strBG);
			rset = pstmt2.executeQuery();
			while(rset.next()) {
				settlement_ind = rset.getString(1) == null ? "" : rset.getString(1);
			}
			if(rset != null) rset.close(); if(pstmt2 != null) pstmt2.close();
				hashBL.put("operation_mode",mode);
				hashBL.put("patient_id_new",patient_id);
				hashBL.put("billing_group",strBG);
				hashBL.put("billing_class",(String)tabdata.get("dflt_nb_regn_blng_class"));
//				hashBL.put("employer_code","");
				hashBL.put("setlmt_ind",settlement_ind);
//				hashBL.put("credit_doc_ref_desc","");
//				hashBL.put("credit_doc_date","");
//				hashBL.put("cust_code","");
//				hashBL.put("slmt_type_code","");
//				hashBL.put("slmt_doc_ref_desc","");
//				hashBL.put("slmt_doc_ref_date","");
//				hashBL.put("slmt_doc_remarks","");
//				hashBL.put("policy_type","");
//				hashBL.put("policy_no","");
//				hashBL.put("policy_expiry_date","");
//				hashBL.put("non_insur_blng_grp","");
//				hashBL.put("cust_4","");
//				hashBL.put("resp_for_payment","");
				hashBL.put("calling_function_id","NEWBORN_REG");
//				hashBL.put("CRED_START_DT","");
//				hashBL.put("credit_auth_user_id","");
//				hashBL.put("GL_HOLDER_NAME","");
//				hashBL.put("GL_HOLDER_RELN","");
				hashBL.put("facility_id",(String)tabdata.get("added_facility_id"));
				hashBL.put("added_by_id",(String)tabdata.get("added_by_id"));
				hashBL.put("added_at_ws_no",(String)tabdata.get("added_at_ws_no"));
				hashBL.put("locale",locale);					  

//				hashBL.put("GL_HOLDER_RELN","");

				HashMap fin_dtls=new HashMap();
				String blng_grp=strBG;
				String blng_class=(String)tabdata.get("dflt_nb_regn_blng_class");
				String slmt_ind=settlement_ind;

				fin_dtls.put("blng_grp",blng_grp);
				fin_dtls.put("blng_class",blng_class);
				fin_dtls.put("slmt_ind",slmt_ind);


				hashBL.put("fin_dtls",(HashMap)fin_dtls);

			if(strBG.equalsIgnoreCase("null") || strBG.equals("")) {
                java.util.Hashtable ht= MessageManager.getMessage(locale,"NEWBORN_PARAM_NOT_DEFINED","MP");
                String n_error=(String) ht.get("message");
                sb.append(n_error);
                insertable = false;
				ht.clear();
			}
            if(insertable) {
				blmpin.BLMPInterface blmpIn = new  blmpin.BLMPInterface();
                Hashtable resultsHashtable = blmpIn.billPatientService(p,con,hashBL);
                insertable = ((Boolean)resultsHashtable.get("transaction_completed")).booleanValue();
				
				if(!insertable)
				{
					String strBLMessage = "";
					
											
					strBLMessage = (String) resultsHashtable.get("error");
					resultsHashtable.clear(); blmpIn = null;

					/*
					if (strBLMessage != null) {
								if (!(strBLMessage.equals(""))) {
					strBLMessage=strBLMessage.trim();
					strBLMessage=strBLMessage.replace("\"","'");
					strBLMessage=strBLMessage.substring(0,strBLMessage.indexOf("'")-15);
								}
					}
					*/

					sb.append(strBLMessage);
				} else {
					bl_success_msg = (String) resultsHashtable.get("success_message");
				}
				
			}

		} catch(Exception ex) 
		{ 
			sb.append("Billing Error="+ex); 
			ex.printStackTrace();
		}
	//	results.put("updateBillingErrors", sb.toString()) ;
		return(insertable);
    }
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}
