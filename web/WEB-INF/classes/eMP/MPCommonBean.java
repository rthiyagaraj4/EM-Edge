/*Created by Ashwini on 30-Jun-2017 for AMS-CRF-0132*/
package eMP;

import java.sql.*;
import java.io.*;
import java.util.*;
import org.json.simple.*;

//import oracle.jdbc.OracleCallableStatement;
//import oracle.jdbc.OracleTypes;

public class MPCommonBean implements Serializable{
	
	public static int getGSTRegionCnt(Connection con,String GST_Region) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		String sql					= "";
		int cnt				= 0;
		try{
			sql				= " select count(*) gstCnt from MP_REGION where GST_Region = '"+GST_Region+"'";
			pstmt			= con.prepareStatement(sql);
			rs				= pstmt.executeQuery();
			if(rs!=null && rs.next()){
				cnt			= rs.getInt("gstCnt");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getGSTRegionCnt method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return cnt;
	}
	/* below method added by mujafar for ML-MMOH-CRF-0998 */
	public static JSONObject getMPAuditTrailDetails(Connection con) throws Exception{
		
	PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		
		String sql					= "";
	String module			="";
	String Hist_Sex			="";
	String Hist_Birth		="";
	String Hist_Legal		="";
	String Hist_Alias		="";
	String Hist_Address		="";
	String Hist_Occ_Empl	="";	
	String Hist_Susp_Reins	="";
	String Hist_Inac_Acti	="";
	String Hist_Rec_Rev		="";
	String ID1_Type		=	"";
	String ID2_Type		=	"";
	String ID3_Type		=	"";
	String ID4_Type		=	"";
	String Nationality_hist_yn	=	"";
	String Alt_id1_hist_yn		=	"";
	String Alt_id2_hist_yn		=	"";
	String Alt_id3_hist_yn		=	"";
	String Alt_id4_hist_yn		=	"";
	String Alt_id1_desc = "";
	String Alt_id2_desc = "";
	String Alt_id3_desc = "";
	String Alt_id4_desc = "";
	String family_hist_link_yn = "";
	String org_memeber_hist_yn = "";
	String pat_cat_hist_yn = "";
	String family_no_link_yn = "";
	String family_org_id_accept_yn = "";
	String nat_id_prompt = "";
	String nat_id_hist_yn = "";
	String birth_place_code_hist_yn = "";

	String pat_series_yn="";
    String old_file_no_yn="";
	int count=0;
	
	String other_alt_no_yn ="";
	String mar_status_yn="";
	String residence_desc_yn="";
	String regn_date_time_yn="";
	String status_desc_yn="";
	String race_yn="";
	String religion_yn= "";
	String ethnicity_yn = "";
	String next_of_kin_hist_yn="";
	String first_notify_hist_yn="";

	//Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534
	String contact1_no_yn = "";
	String contact2_no_yn = "";

	//Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1
	String country_reqd_yn = "";
	String region_reqd_yn = "";
	String dft_national_id="";//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
	
		
	JSONObject jsonObj			= new JSONObject();		

	try
	{
			sql						= "Select MODULE_ID,old_file_no_yn, SEX_HIST_YN,PAT_SER_GRP_HIST_YN, BIRTH_DATE_HIST_YN, LEGAL_NAME_HIST_YN, ALIAS_NAME_HIST_YN, ADDRESS_HIST_YN, OCPN_N_EMPL_HIST_YN,SUSPEND_REINSTATE_HIST_YN, INACT_ACT_HIST_YN, REC_REVOKE_DEATH_HIST_YN,NATIONALITY_HIST_YN,ALT_ID1_HIST_YN,ALT_ID2_HIST_YN,ALT_ID3_HIST_YN,ALT_ID4_HIST_YN,ALT_ID1_TYPE,ALT_ID2_TYPE,ALT_ID3_TYPE,ALT_ID4_TYPE,FAMILY_LINK_HIST_YN,ORG_MEMBER_HIST_YN,PAT_CAT_HIST_YN,FAMILY_NO_LINK_YN,FAMILY_ORG_ID_ACCEPT_YN,nvl(nat_id_prompt,'National ID No') NAT_ID_PROMPT,NAT_ID_HIST_YN,BIRTH_PLACE_CODE_HIST_YN,other_alt_no_yn,mar_status_yn,residence_desc_yn,regn_date_time_yn,status_desc_yn,race_yn,religion_yn,ethnicity_yn,next_of_kin_hist_yn,first_notify_hist_yn,contact1_no_yn,contact2_no_yn, country_reqd_yn, region_reqd_yn,dft_national_id from mp_param";
			pstmt					= con.prepareStatement(sql);
			rs						= pstmt.executeQuery();
			
		
		if(rs!=null && rs.next()){
			
		
		
		module	= rs.getString("MODULE_ID");
		Hist_Sex = rs.getString("SEX_HIST_YN");
		pat_series_yn=rs.getString("PAT_SER_GRP_HIST_YN");
		Hist_Birth = rs.getString("BIRTH_DATE_HIST_YN");
		Hist_Legal = rs.getString("LEGAL_NAME_HIST_YN");
		Hist_Alias = rs.getString("ALIAS_NAME_HIST_YN");
		Hist_Address = rs.getString("ADDRESS_HIST_YN");
		Hist_Occ_Empl = rs.getString("OCPN_N_EMPL_HIST_YN");
		Hist_Susp_Reins = rs.getString("SUSPEND_REINSTATE_HIST_YN");
		Hist_Inac_Acti = rs.getString("INACT_ACT_HIST_YN");
		Hist_Rec_Rev = rs.getString("REC_REVOKE_DEATH_HIST_YN");
		ID1_Type= rs.getString("ALT_ID1_TYPE");
		ID2_Type= checkForNull(rs.getString("ALT_ID2_TYPE")); // checkForNull added by mujafar for IN:067104
		ID3_Type= checkForNull(rs.getString("ALT_ID3_TYPE")); // checkForNull added by mujafar for IN:067104
		ID4_Type= checkForNull(rs.getString("ALT_ID4_TYPE")); // checkForNull added by mujafar for IN:067104
		
		
		
		Nationality_hist_yn	=	rs.getString("NATIONALITY_HIST_YN");
		Alt_id1_hist_yn		=	rs.getString("ALT_ID1_HIST_YN");
		Alt_id2_hist_yn		=	rs.getString("ALT_ID2_HIST_YN");
		Alt_id3_hist_yn		=	rs.getString("ALT_ID3_HIST_YN");
		Alt_id4_hist_yn		=	rs.getString("ALT_ID4_HIST_YN");
		family_hist_link_yn		=	rs.getString("FAMILY_LINK_HIST_YN");
		org_memeber_hist_yn		=	rs.getString("ORG_MEMBER_HIST_YN");
		pat_cat_hist_yn		=	rs.getString("PAT_CAT_HIST_YN");
		family_no_link_yn		=	rs.getString("FAMILY_NO_LINK_YN");
		family_org_id_accept_yn		=	rs.getString("FAMILY_ORG_ID_ACCEPT_YN");
		nat_id_hist_yn		=	rs.getString("NAT_ID_HIST_YN");
		nat_id_prompt		=	checkForNull(rs.getString("NAT_ID_PROMPT")); // checkForNull added by mujafar for IN:067104	
		      
		birth_place_code_hist_yn	=	rs.getString("BIRTH_PLACE_CODE_HIST_YN");
             
		old_file_no_yn	=	rs.getString("old_file_no_yn");
		
		other_alt_no_yn =  rs.getString("other_alt_no_yn");
		mar_status_yn   =  rs.getString("mar_status_yn"); 
		residence_desc_yn   =  rs.getString("residence_desc_yn"); 
		regn_date_time_yn  = rs.getString("regn_date_time_yn");
		
		status_desc_yn  = rs.getString("status_desc_yn");
		race_yn  = rs.getString("race_yn");
		religion_yn  = rs.getString("religion_yn");
		ethnicity_yn  = rs.getString("ethnicity_yn");
		next_of_kin_hist_yn  = rs.getString("next_of_kin_hist_yn");
		first_notify_hist_yn  = rs.getString("first_notify_hist_yn");

		//Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534
		contact1_no_yn  = rs.getString("contact1_no_yn");
		contact2_no_yn  = rs.getString("contact2_no_yn");

		//Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1
		country_reqd_yn = checkForNull(rs.getString("country_reqd_yn"),"N");
		region_reqd_yn = checkForNull(rs.getString("region_reqd_yn"),"N");
		dft_national_id = checkForNull(rs.getString("dft_national_id"),"");//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
		
		
		}
		
		if(ID1_Type != null)
			count++;
		if(ID2_Type != null)
			count++;
		if(ID3_Type != null)
			count++;
		if(ID4_Type != null)
			count++;
			
		if(!ID1_Type.equals(""))
		{
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		pstmt = con.prepareStatement("Select long_desc from MP_ALTERNATE_ID_TYPE where alt_id_type = '"+ID1_Type+"'");
		rs = pstmt.executeQuery();
		if(rs.next())
		{	
			Alt_id1_desc = rs.getString("long_desc")==null?"":rs.getString("long_desc");
		}
		}
		
		if(!ID2_Type.equals(""))
		{
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		pstmt = con.prepareStatement("Select long_desc from MP_ALTERNATE_ID_TYPE where alt_id_type = '"+ID2_Type+"'");
		rs = pstmt.executeQuery();
		if(rs.next())
		{	
			Alt_id2_desc = rs.getString("long_desc")==null?"":rs.getString("long_desc");
		}
		}
		
		if(!ID3_Type.equals(""))
		{
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		pstmt = con.prepareStatement("Select long_desc from MP_ALTERNATE_ID_TYPE where alt_id_type = '"+ID3_Type+"'");
		rs = pstmt.executeQuery();
		if(rs.next())
		{	
			Alt_id3_desc = rs.getString("long_desc")==null?"":rs.getString("long_desc");
		}
		}
		
		if(!ID4_Type.equals(""))
		{
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		pstmt = con.prepareStatement("Select long_desc from MP_ALTERNATE_ID_TYPE where alt_id_type = '"+ID4_Type+"'");
		rs = pstmt.executeQuery();
		if(rs.next())
		{	
			Alt_id4_desc = rs.getString("long_desc")==null?"":rs.getString("long_desc");
		}
		}
		
		jsonObj.put("ID1_Type",ID1_Type);
		jsonObj.put("ID2_Type",ID2_Type);
		jsonObj.put("ID3_Type",ID3_Type);
		jsonObj.put("ID4_Type",ID4_Type);
		
		
		jsonObj.put("module",module);
		jsonObj.put("Hist_Sex",Hist_Sex);
		jsonObj.put("pat_series_yn",pat_series_yn);
		jsonObj.put("Hist_Birth",Hist_Birth);
		jsonObj.put("Hist_Legal",Hist_Legal);
		jsonObj.put("Hist_Alias",Hist_Alias);
		jsonObj.put("Hist_Address",Hist_Address);
		jsonObj.put("Hist_Occ_Empl",Hist_Occ_Empl);
		jsonObj.put("Hist_Susp_Reins",Hist_Susp_Reins);
		jsonObj.put("Hist_Inac_Acti",Hist_Inac_Acti);
		jsonObj.put("Hist_Rec_Rev",Hist_Rec_Rev);
		jsonObj.put("Nationality_hist_yn",Nationality_hist_yn);
		jsonObj.put("Alt_id1_hist_yn",Alt_id1_hist_yn);
		jsonObj.put("Alt_id2_hist_yn",Alt_id2_hist_yn);
		jsonObj.put("Alt_id3_hist_yn",Alt_id3_hist_yn);
		jsonObj.put("Alt_id4_hist_yn",Alt_id4_hist_yn);
		jsonObj.put("family_hist_link_yn",family_hist_link_yn);
		jsonObj.put("org_memeber_hist_yn",org_memeber_hist_yn);
		jsonObj.put("pat_cat_hist_yn",pat_cat_hist_yn);
		jsonObj.put("family_no_link_yn",family_no_link_yn);
		jsonObj.put("family_org_id_accept_yn",family_org_id_accept_yn);
		jsonObj.put("nat_id_hist_yn",nat_id_hist_yn);
		jsonObj.put("nat_id_prompt",nat_id_prompt);
		jsonObj.put("birth_place_code_hist_yn",birth_place_code_hist_yn);
		jsonObj.put("old_file_no_yn",old_file_no_yn); 
		jsonObj.put("Alt_id1_desc",Alt_id1_desc);
		jsonObj.put("Alt_id2_desc",Alt_id2_desc);
		jsonObj.put("Alt_id3_desc",Alt_id3_desc);
		jsonObj.put("Alt_id4_desc",Alt_id4_desc); 
		jsonObj.put("count",count); 
		
		jsonObj.put("other_alt_no_yn",other_alt_no_yn); 
		jsonObj.put("mar_status_yn",mar_status_yn); 
		jsonObj.put("residence_desc_yn",residence_desc_yn); 
		jsonObj.put("regn_date_time_yn",regn_date_time_yn);
		
		jsonObj.put("status_desc_yn",status_desc_yn);
		jsonObj.put("race_yn",race_yn);
		jsonObj.put("religion_yn",religion_yn);
		jsonObj.put("ethnicity_yn",ethnicity_yn);
		jsonObj.put("next_of_kin_hist_yn",next_of_kin_hist_yn);
		jsonObj.put("first_notify_hist_yn",first_notify_hist_yn);
		
		
		//Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534
		jsonObj.put("contact1_no_yn",contact1_no_yn);
		jsonObj.put("contact2_no_yn",contact2_no_yn);

		//Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1
		jsonObj.put("country_reqd_yn",country_reqd_yn);
		jsonObj.put("region_reqd_yn",region_reqd_yn);
		//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
		jsonObj.put("dft_national_id",dft_national_id);
	    
	}   
	
	catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getMPAuditTrailDetails method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
	
	return jsonObj;

}

	/*Added by Thamizh selvi on 5th June 2018 for MMS-DM-CRF-0115.1 Start*/
	public static int getCDRCount(Connection con, String nationalityId,String altID1,String patientId) throws Exception{
		//OracleCallableStatement cstmt = null;
		ResultSet rs 				  = null;
		PreparedStatement pstmt=null;
		int cdrCount				  = 0;
		//int encounterCnt			  = 0;

		try{

				System.err.println("MPCommonBean.java ==> 297 nationalityId==>"+nationalityId);
				System.err.println("MPCommonBean.java ==> 298 altID1==>"+altID1);

				/*String sql = "BEGIN ? :=  EM_CDR_PTNT_CNT_UPD(?,?,?); end;";
				cstmt = (OracleCallableStatement)con.prepareCall(sql);
				cstmt.registerOutParameter(1, OracleTypes.INTEGER);
				cstmt.setString(2,nationalityId);
				cstmt.setString(3,altID1);
				cstmt.setString(4,patientId);
				cstmt.execute();
				
				cdrCount	= cstmt.getInt(1);*/
				String sql = "select EM_CDR_PTNT_CNT_UPD(?,?,?) val from dual";
				pstmt			= con.prepareStatement(sql);
				pstmt.setString(1, nationalityId);
				pstmt.setString(2, altID1);
				pstmt.setString(3, patientId);
				rs				= pstmt.executeQuery();
				if(rs!=null && rs.next()){
					cdrCount = rs.getInt(1);
				}
				System.err.println("MPCommonBean.java 308 ==>cdrCount==>"+cdrCount);
				
					
		
			
		}catch(Exception ex){
			System.err.println("Exception in getCDRCount - "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				//if(cstmt!=null)cstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getCDRCount - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return cdrCount;
	}/*End*/

	/*Added by Thamizh selvi on 27th June 2018 for MMS-DM-CRF-0115.1 Start*/
	public static void insReferralDataForCDR(Connection con, String patientId, String repDb) throws Exception{
		CallableStatement cstmt = null;
		ResultSet rs 			= null;
		int encounterId			= 0;

		try{
		
			cstmt = con.prepareCall("{call Proc_Get_Clob_Data_CDR(?,?,?,?)}");

			cstmt.setString (1, patientId);
			cstmt.setLong   (2, encounterId);
			cstmt.setString (3, repDb.substring(1,repDb.length()));
			cstmt.setString (4, "PR_REFERRAL_REGISTER");
			cstmt.execute();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(cstmt!=null)cstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in insReferralDataForCDR - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
	}/*End*/

	public static int getHistAllergyCnt(Connection con, String patientId) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		int histAllergyCnt		= 0;
	
		try{
			if(patientId != null && !("").equals(patientId)){
				String sql = " SELECT COUNT (*) cnt FROM CR_ENCOUNTER_DETAIL WHERE HIST_REC_TYPE = 'FDOC' AND CONTR_SYS_EVENT_CODE = 'DMALLERGY' AND EVENT_CLASS = 'DMA' AND PATIENT_ID = ? AND ADDED_BY_ID = 'DM' ";
				pstmt			= con.prepareStatement(sql);
				pstmt.setString(1, patientId);
				rs				= pstmt.executeQuery();
				if(rs!=null && rs.next()){
					histAllergyCnt = rs.getInt("cnt");
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getHistAllergyCnt - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return histAllergyCnt;
	}/*End*/
	public static JSONObject getOTRDInstalledYN(Connection con) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		JSONObject jsonObj		= new JSONObject();
		String ot_yn			= "N";
		String rd_yn			= "N";
		try{
			String sql = "select module_id,nvl(install_yn,'N') install_yn from sm_module where module_id in ( 'OT','RD')";
			pstmt = con.prepareStatement(sql);
			rs	= pstmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					if(rs.getString("module_id").equals("OT")){
						if(rs.getString("install_yn").equals("Y")){
							ot_yn="Y";
						}
					}else if(rs.getString("module_id").equals("RD")){
						if(rs.getString("install_yn").equals("Y")){
							rd_yn="Y";
						}
					}
				}
				jsonObj.put("ot_yn",ot_yn);
				jsonObj.put("rd_yn",rd_yn);				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getOTRDInstalledYN - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}
	/*End ML-MMOH-CRF-0833*/

	/*Added by Thamizh selvi on 27th July 2018 for ML-MMOH-CRF-1177 Start*/
	public static JSONObject getDOBFrmNationalityId(Connection con, String nationalityID) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		JSONObject jsonObj		= new JSONObject();
		String result			= "";
		String dateOfBirth		= "";
		String errorMsg			= "";
		
		try{
			
			if(nationalityID != null){

				String sql = " select VERIFY_NATIONAL_ID(?) FROM DUAL ";

				pstmt			= con.prepareStatement(sql);
				pstmt.setString(1, nationalityID);
				rs				= pstmt.executeQuery();
				if(rs!=null && rs.next()){
					result = rs.getString(1);
					StringTokenizer strTok = new StringTokenizer(result,"$");
					if (strTok.hasMoreTokens())
						result = strTok.nextToken();
					if ( result.equals("TRUE") ){
						if (strTok.hasMoreTokens())
							dateOfBirth = strTok.nextToken();	
					}else{
						if (strTok.hasMoreTokens())
							errorMsg = strTok.nextToken();	
					}
				
					jsonObj.put("dateOfBirth",dateOfBirth);
					jsonObj.put("errorMsg",errorMsg);
					jsonObj.put("result",result);
				
				}
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getDOBFrmNationalityId - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}/*End*/

	public static int getInactiveNatIdCnt(Connection con,String natId) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		String sql					= "";
		int cnt				= 0;
		try{
			sql				= " select count(*) cnt from MP_INACTIVE_PATIENT where NATIONAL_ID_NO = '"+natId+"'";
			pstmt			= con.prepareStatement(sql);
			rs				= pstmt.executeQuery();
			if(rs!=null && rs.next()){
				cnt			= rs.getInt("cnt");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getInactiveNatIdCnt method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return cnt;
	}
		/*Added by Dharma on 25th Mar 2019 NMC-JD-CRF-0018 [IN:069750] Start*/
		/*Added by Dharma on 24th Apr against MMS-DM-CRF-0152.1 [IN:070226] Start*/
		public static JSONObject chkNatIDAltIDAvail(Connection con,String patientId,String locale) throws Exception{
			PreparedStatement pstmt		= null;
			ResultSet rs 				= null;
			JSONObject jsonObj		= new JSONObject();
			String sql					= "";
			Integer age_not_consider_natid_altid	= 0;
			//Integer interval			 = 0; //Commented for checkstyle
			Integer ageDiff				 = 0;
			String showAlert			 = "Y";
			
			try{
				sql = "select mp_get_desc.mp_alternate_id_type(alt_id1_type,'"+locale+"',1) alt_id1_type_desc,mp_get_desc.mp_alternate_id_type(alt_id2_type,'"+locale+"',1) alt_id2_type_desc,nat_id_prompt,age_not_consider_natid_altid,marital_status_reqd_yn,occupation_reqd_yn,mand_visit_admssn_reg_yn,religion_reqd_yn from mp_param";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs!=null && rs.next()){
					jsonObj.put("alt_id1_type_desc",checkForNull(rs.getString("alt_id1_type_desc")));
					jsonObj.put("alt_id2_type_desc",checkForNull(rs.getString("alt_id2_type_desc")));
					jsonObj.put("nat_id_prompt",checkForNull(rs.getString("nat_id_prompt")));
					jsonObj.put("marital_status_reqd_yn",checkForNull(rs.getString("marital_status_reqd_yn")));
					jsonObj.put("occupation_reqd_yn",checkForNull(rs.getString("occupation_reqd_yn")));
					jsonObj.put("mand_visit_admssn_reg_yn",checkForNull(rs.getString("mand_visit_admssn_reg_yn")));
					jsonObj.put("religion_reqd_yn",checkForNull(rs.getString("religion_reqd_yn")));
					age_not_consider_natid_altid = rs.getInt("age_not_consider_natid_altid");
				}
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				sql = "select ocpn_code from MP_PAT_REL_CONTACTS where patient_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patientId);
				rs = pstmt.executeQuery();
				if(rs!=null && rs.next()){
					jsonObj.put("ocpn_class_code",checkForNull(rs.getString("ocpn_code")));
				}
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				System.err.println("patientId==>"+patientId);
				sql = "";
				sql	= "select national_id_no, alt_id1_no, alt_id2_no, pat_dtls_unknown_yn,citizen_yn,visa_type,trunc(sysdate-date_of_birth) difference,national_id_no_dft,mar_status_code,relgn_code from mp_patient where patient_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patientId);
				rs = pstmt.executeQuery();
				if(rs!=null && rs.next()){
					String national_id_no = checkForNull(rs.getString("national_id_no"));
					String national_id_no_dft = checkForNull(rs.getString("national_id_no_dft"));//Added by Maheshwaran K for AAKH-CRF-0168					
					String alt_id1_no = checkForNull(rs.getString("alt_id1_no"));
					String alt_id2_no = checkForNull(rs.getString("alt_id2_no"));
					String pat_dtls_unknown_yn = checkForNull(rs.getString("pat_dtls_unknown_yn"));
					String citizen_yn = checkForNull(rs.getString("citizen_yn"));
					String visa_type = checkForNull(rs.getString("visa_type"));
					String mar_status_code = checkForNull(rs.getString("mar_status_code"));
					String relgn_code = checkForNull(rs.getString("relgn_code"));
					
 
					ageDiff	= rs.getInt("difference");
					System.err.println("ageDiff==>"+ageDiff);
					System.err.println("age_not_consider_natid_altid==>"+age_not_consider_natid_altid);
					if(ageDiff <= age_not_consider_natid_altid){
						showAlert	= "N";
					}
				
					System.err.println("showAlert==>"+showAlert);
					jsonObj.put("showAlert",showAlert);
					jsonObj.put("citizen_yn",citizen_yn);
					jsonObj.put("visa_type",visa_type);
					jsonObj.put("pat_dtls_unknown_yn",pat_dtls_unknown_yn);
					jsonObj.put("alt_id2_no",alt_id2_no);
					jsonObj.put("alt_id1_no",alt_id1_no);
					jsonObj.put("national_id_no",national_id_no);
					jsonObj.put("national_id_no_dft",national_id_no_dft);
					jsonObj.put("mar_status_code",mar_status_code);
					jsonObj.put("relgn_code",relgn_code);
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
				}catch(Exception ex){
					System.err.println("Exception in chkNatIDAltIDAvail method  - "+ex.getMessage());
					ex.printStackTrace();
				}
			}
		return jsonObj;
		}
		/*Added by Dharma on 24th Apr against MMS-DM-CRF-0152.1 [IN:070226] End*/
		/*Added by Dharma on 25th Mar 2019 NMC-JD-CRF-0018 [IN:069750] End*/
	
	// added by mujafar for AMRI-CRF-0357 START
	
		public static String getUHIDValidCount(Connection con,String patientId,String facilityId) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		String sql					= "";
		
		int cnt				= 0;
		String ret_val = "1";
		String temp = "";
		String pat_ser_grp_code= "";
		try{
			//sql				= " select UHID_VALID_DAYS cnt from mp_param";
			sql				= "SELECT nvl(uhid_valid_days,0) cnt, (SELECT pat_ser_grp_code FROM mp_patient WHERE patient_id = '"+patientId+"') pat_ser_grp_code FROM mp_param  WHERE module_id = 'MP'";
			pstmt			= con.prepareStatement(sql);
			rs				= pstmt.executeQuery();
			if(rs!=null && rs.next()){
				cnt			= rs.getInt("cnt");
				pat_ser_grp_code = rs.getString("pat_ser_grp_code");
				//System.out.println("cnt==========>"+cnt);
			}
			
			
			if(cnt >0)
			{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				
				sql = "Select Nvl (V_Date, (Select Regn_Date From Mp_Patient Where Patient_Id = '"+patientId+"'))+"+cnt+" V_Date_Max From (Select Max (UHID_RENEW_DATE_TIME) V_Date From BL_PAT_UHID_RENEW_DTLS Where OPERATING_FACILITY_ID='"+facilityId+"' and Patient_Id = '"+patientId+"') Where Nvl (V_Date, (Select Regn_Date From Mp_Patient Where Patient_Id = '"+patientId+"'))+"+cnt+" <= Sysdate";
				
				//System.out.println("sql::===>"+sql);
				pstmt			= con.prepareStatement(sql);
				rs				= pstmt.executeQuery();
				if(rs!=null && rs.next())
				{
				temp			= rs.getString("V_Date_Max")==null?"":rs.getString("V_Date_Max");
				//System.out.println("temp val::"+temp);
				if(!temp.equals(""))ret_val= "0";
				}
			
				
				
			}
			
		
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getUHIDValidCount method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		
		if(!pat_ser_grp_code.equals(""))
			ret_val = ret_val+"~~"+pat_ser_grp_code;
		
		System.out.println("ret_val final::"+ret_val);
			
		return ret_val;
	}
	
	
	// added by mujafar for AMRI-CRF-0357 end

/*Added by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
public static JSONObject getNationalIdValidationYN(Connection con, String new_patient_id, String facility_id, String module_id) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		JSONObject jsonObj		= new JSONObject();
		String sql				= "";

		try{

			if(module_id.equals("AE"))
			{
				 sql = "SELECT CASE WHEN ae_param = 'Y' AND NVL(mp_age,0) < mp_days THEN 'Y' ELSE 'N' END RESULT,NAT_ID,CITIZEN_YN FROM (SELECT (SELECT validate_natid_reg_attn FROM ae_param WHERE operating_facility_id = ?) ae_param, (SELECT age_not_consider_natid FROM mp_param WHERE module_id ='MP') mp_age, (SELECT TRUNC (SYSDATE) - TRUNC (date_of_birth) FROM mp_patient WHERE patient_id = ?) mp_days, (SELECT NATIONAL_ID_NO FROM mp_patient WHERE patient_id = ?)NAT_ID, (SELECT citizen_yn FROM mp_patient WHERE patient_id = ?)CITIZEN_YN FROM DUAL)";
			}else if(module_id.equals("IP"))
			{
				 sql = "SELECT CASE WHEN ip_param = 'Y' AND NVL(mp_age,0) < mp_days THEN 'Y' ELSE 'N' END RESULT,NAT_ID,CITIZEN_YN FROM (SELECT (SELECT validate_natid_ip_admsn FROM ip_param WHERE facility_id = ?) ip_param, (SELECT age_not_consider_natid FROM mp_param WHERE module_id ='MP') mp_age, (SELECT TRUNC (SYSDATE) - TRUNC (date_of_birth) FROM mp_patient WHERE patient_id = ?) mp_days, (SELECT NATIONAL_ID_NO FROM mp_patient WHERE patient_id = ?)NAT_ID, (SELECT citizen_yn FROM mp_patient WHERE patient_id = ?)CITIZEN_YN FROM DUAL)";
			}else if(module_id.equals("OP"))
			{
				 sql = "SELECT CASE WHEN op_param = 'Y' AND NVL(mp_age,0) < mp_days THEN 'Y' ELSE 'N' END RESULT,NAT_ID,CITIZEN_YN FROM (SELECT (SELECT validate_natid_reg_visit FROM op_param WHERE operating_facility_id = ?) op_param, (SELECT age_not_consider_natid FROM mp_param WHERE module_id ='MP') mp_age, (SELECT TRUNC (SYSDATE) - TRUNC (date_of_birth) FROM mp_patient WHERE patient_id = ?) mp_days, (SELECT NATIONAL_ID_NO FROM mp_patient WHERE patient_id = ?)NAT_ID, (SELECT citizen_yn FROM mp_patient WHERE patient_id = ?)CITIZEN_YN FROM DUAL)";
			}
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,new_patient_id);
			pstmt.setString(3,new_patient_id);
			pstmt.setString(4,new_patient_id);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){

					String validate_yn = checkForNull(rs.getString("RESULT"));
					String national_id = checkForNull(rs.getString("NAT_ID"));
					String citizen_yn  = checkForNull(rs.getString("CITIZEN_YN"));

					jsonObj.put("validate_yn",validate_yn);
					jsonObj.put("national_id",national_id);
					jsonObj.put("citizen_yn",citizen_yn);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getNationalIdValidationYN - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
}
/*End MO-CRF-20148*/

/*Added by Ashwini on 14-May-2019 for TBMC-CRF-0010.1*/
public static JSONObject getEmpPrivilegeData(Connection con, String National_ID, String Language_ID) throws Exception{
		
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		JSONObject jsonObj		= new JSONObject();
		String sql				= "";

		try{

			 sql = "SELECT national_id_no, employee_or_family, name_prefix, first_name, second_name, last_name, ref_employee_id, relationship_to_employee, (SELECT short_desc description FROM mp_relationship_lang_vw WHERE relationship_code = a.relationship_to_employee AND eff_status = 'E' AND language_id = ?) relationship_to_emp_desc, (SELECT eff_status FROM mp_name_prefix WHERE name_prefix = a.name_prefix) prefix_eff_status, (SELECT eff_status FROM mp_alternate_id_type WHERE alt_id_type = 'ID5') alt_id_eff_status FROM xh_ext_hr_ib_info a WHERE national_id_no = ? AND process_status = 'N'";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,Language_ID);
			pstmt.setString(2,National_ID);

			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){

					String national_id_no = checkForNull(rs.getString("national_id_no"));
					String employee_or_family = checkForNull(rs.getString("employee_or_family"));
					String name_prefix = checkForNull(rs.getString("name_prefix"));
					String first_name = checkForNull(rs.getString("first_name"));
					String second_name = checkForNull(rs.getString("second_name"));
					String last_name = checkForNull(rs.getString("last_name"));
					String ref_employee_id = checkForNull(rs.getString("ref_employee_id"));
					String relationship_to_employee = checkForNull(rs.getString("relationship_to_employee"));
					String relationship_to_emp_desc = checkForNull(rs.getString("relationship_to_emp_desc"));
					String prefix_eff_status = checkForNull(rs.getString("prefix_eff_status"));
					String alt_id_eff_status = checkForNull(rs.getString("alt_id_eff_status"));
					
					jsonObj.put("national_id_no",national_id_no);
					jsonObj.put("employee_or_family",employee_or_family);
					jsonObj.put("name_prefix",name_prefix);
					jsonObj.put("first_name",first_name);
					jsonObj.put("second_name",second_name);
					jsonObj.put("last_name",last_name);
					jsonObj.put("ref_employee_id",ref_employee_id);
					jsonObj.put("relationship_to_employee",relationship_to_employee);
					jsonObj.put("relationship_to_emp_desc",relationship_to_emp_desc);
					jsonObj.put("prefix_eff_status",prefix_eff_status);
					jsonObj.put("alt_id_eff_status",alt_id_eff_status);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getEmpPrivilegeData - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return jsonObj;
}

public static JSONObject getUploadedPatYN(Connection con, String patient_ID, String National_ID) throws Exception{
		
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		JSONObject jsonObj		= new JSONObject();
		String sql				= "";

		try{

			 sql = "SELECT uploaded_pat_yn FROM mp_patient WHERE patient_id = ? and national_id_no = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,patient_ID);
			pstmt.setString(2,National_ID);

			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){

					String uploaded_pat_yn = checkForNull(rs.getString("uploaded_pat_yn"));
					
					jsonObj.put("uploaded_pat_yn",uploaded_pat_yn);
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getUploadedPatYN - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return jsonObj;
}
/*End TBMC-CRF-0010.1*/

	/*Added by Ashwini on 09-Sep-2019 for ML-MMOH-CRF-1158*/
	public static String getMorseFallScaleScore(Connection con, String episode_id, String patient_id) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String MFSScore			= null;

		try{

			String MFSScoreSql = "SELECT result_str FROM (SELECT result_str FROM cr_encounter_detail a, ca_encntr_note b WHERE a.patient_id = b.patient_id AND a.contr_sys_event_code = 'NU0090' AND a.encounter_id = '"+episode_id+"' AND a.patient_id = '"+patient_id+"' AND a.hist_rec_type = 'PTCR' AND a.contr_sys_id = 'OR' AND b.note_type = 'NU23' AND b.accession_num = SUBSTR (a.accession_num, 0, INSTR (a.accession_num, 'NU30') - 1 ) ORDER BY a.modified_date DESC) WHERE ROWNUM = 1";

			pstmt = con.prepareStatement(MFSScoreSql);
			rs = pstmt.executeQuery();
			
			if(rs!=null && rs.next()){
				MFSScore = rs.getString("result_str")==null?"":rs.getString("result_str");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getMorseFallScaleScore - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return MFSScore;
	}
	/*End ML-MMOH-CRF-1158*/

	/*Added by Ashwini on 16-Dec-2019 for AAKH-CRF-0079.11*/
	public static JSONObject getPatDemographicDtls(Connection con, String patient_id) throws Exception{
			
			PreparedStatement pstmt	= null;
			ResultSet rs 			= null;
			JSONObject jsonObj		= new JSONObject();
			String sql				= "";

			try{

				 sql = "SELECT patient_name, contact1_no, TO_CHAR (date_of_birth, 'dd/mm/yyyy') date_of_birth, DECODE (sex, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender FROM mp_patient WHERE patient_id = ?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patient_id);

				rs = pstmt.executeQuery();

				if(rs!=null && rs.next()){

						String patient_name = checkForNull(rs.getString("patient_name"));
						String contact_no = checkForNull(rs.getString("contact1_no"));
						String date_of_birth = checkForNull(rs.getString("date_of_birth"));
						String gender = checkForNull(rs.getString("gender"));
						
						jsonObj.put("patient_name",patient_name);
						jsonObj.put("contact_no",contact_no);
						jsonObj.put("date_of_birth",date_of_birth);
						jsonObj.put("gender",gender);
				}
				
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
				}catch(Exception ex){
					System.err.println("Exception in getPatDemographicDtls - "+ex.getMessage());
					ex.printStackTrace();
				}
			}

			return jsonObj;
	}

	public static JSONObject getPatEncDtls(Connection con, String patient_id, String facility_id) throws Exception{
			
			PreparedStatement pstmt	= null;
			ResultSet rs 			= null;
			JSONObject json			= new JSONObject();
			JSONArray arrJSON		= new JSONArray();
			String sql				= "";
			int noOfRecords			= 0;

			try{

				 sql = "SELECT COUNT (*) OVER () noofrecords, a.encounter_id FROM pr_encounter a WHERE a.patient_id = ? AND a.facility_id = ? ORDER BY a.added_date";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,facility_id);

				rs = pstmt.executeQuery();

				while(rs!=null && rs.next()){

						JSONObject jsonObj	= new JSONObject();
						
						noOfRecords = rs.getInt("noOfRecords");
						String encounter_id = checkForNull(rs.getString("encounter_id"));
						
						jsonObj.put("encounter_id",encounter_id);

						arrJSON.add(jsonObj);
				}

				json.put("encDtlArray",arrJSON);
				json.put("noOfRecords",noOfRecords);
				
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
				}catch(Exception ex){
					System.err.println("Exception in getPatEncDtls - "+ex.getMessage());
					ex.printStackTrace();
				}
			}

			return json;
	}

	public static JSONObject getPatDocDtls(Connection con, String patient_id, String facility_id, String enc_id, String srl_no) throws Exception{
			
			PreparedStatement pstmt	= null;
			ResultSet rs 			= null;
			JSONObject jsonObj		= new JSONObject();
			String sql				= "";
			int noOfRecords			= 0;

			try{

				 sql = "SELECT b.insurance_type, b.serial_no FROM mp_upload_document b WHERE b.patient_id = ? AND b.facility_id = ? AND b.encounter_id = ? AND b.serial_no = ?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,enc_id);
				pstmt.setString(4,srl_no);

				rs = pstmt.executeQuery();

				if(rs!=null && rs.next()){
						
						String insurance_type = checkForNull(rs.getString("insurance_type"));
						String serial_no = checkForNull(rs.getString("serial_no"));
						
						jsonObj.put("insurance_type",insurance_type);
						jsonObj.put("serial_no",serial_no);
				}
				
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
				}catch(Exception ex){
					System.err.println("Exception in getPatDocDtls - "+ex.getMessage());
					ex.printStackTrace();
				}
			}

			return jsonObj;
	}

	public static JSONObject getInsuranceType(Connection con, String language_id, String encounter_id, String patient_id) throws Exception{
			
			PreparedStatement pstmt	= null;
			ResultSet rs 			= null;
			JSONObject json			= new JSONObject();
			JSONArray arrJSON		= new JSONArray();
			String sql				= "";

			try{

				 sql = "SELECT distinct a.policy_type_code, blcommonproc.get_polity_type_desc (a.policy_type_code, ?, 'S' ) policy_name, a.priority, b.ins_rep_id FROM bl_encounter_payer_priority a, ar_customer b WHERE a.cust_code = b.cust_code AND a.settlement_ind = 'X' AND DECODE (a.episode_type, 'O', a.episode_id || LPAD (a.visit_id, 4, '0'), 'E', a.episode_id || LPAD (a.visit_id, 4, '0'), 'I', a.episode_id, 'D', a.episode_id ) = ? AND a.patient_id = ? ORDER BY a.priority";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,language_id);
				pstmt.setString(2,encounter_id);
				pstmt.setString(3,patient_id);

				rs = pstmt.executeQuery();

				while(rs!=null && rs.next()){

						JSONObject jsonObj	= new JSONObject();

						String ins_type = checkForNull(rs.getString("policy_type_code"));
						String ins_name = checkForNull(rs.getString("policy_name"));
						
						jsonObj.put("ins_type",ins_type);
						jsonObj.put("ins_name",ins_name);
						arrJSON.add(jsonObj);
				}

				json.put("insTypeArray",arrJSON);
				
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
				}catch(Exception ex){
					System.err.println("Exception in getInsuranceType - "+ex.getMessage());
					ex.printStackTrace();
				}
			}

			return json;
	}

	public static int getInsuranceCount(Connection con, String encounter_id, String patient_id) throws Exception{
			
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int cnt	= 0;

		try{

			sql	= "select count(*) ins_count from bl_encounter_payer_priority where patient_id = ?  AND DECODE(EPISODE_TYPE,'O',EPISODE_ID||LPAD(VISIT_ID,4,'0'),'E',EPISODE_ID||LPAD(VISIT_ID,4,'0'),'I',EPISODE_ID,'D',EPISODE_ID)  = ? AND settlement_ind = 'X'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, patient_id);
			pstmt.setString(2, encounter_id);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				cnt	= rs.getInt("ins_count");
			}

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getInsuranceCount - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return cnt;

	}
	/*End AAKH-CRF-0079.11*/

	public static int getPrimaryNuhdeek(Connection con,String alt_id3_no,String patient_id) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		String sql					= "";
		String wherClause	 ="";
		int cnt				= 0;
		try{

			if(!patient_id.equals("")){
				wherClause	= " and patient_id <> '"+patient_id+"'";
			}
			sql	= "select count(*) primaryNuhdeekCnt from MP_PATIENT where ALT_ID3_NO = '"+alt_id3_no+"' and PRIMARY_NUHDEEK_YN='Y' "+wherClause+"";
			pstmt			= con.prepareStatement(sql);
			rs				= pstmt.executeQuery();
			if(rs!=null && rs.next()){
				cnt			= rs.getInt("primaryNuhdeekCnt");
			}
			System.err.println("cnt-->"+cnt);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getPrimaryNuhdeek method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return cnt;
	}

	/*Added By Dharma on 12th May 2020 against KDAH-CRF-0522.1 Start*/	
public static String chkMPMandFieldsForEncCreation(Connection con, String patientId, String local) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String funRetValue		= "";
		// String[] arrOfFunRetValue		= null;
		String returnValue		= "Y";
		try{

			System.err.println("patientId==>"+patientId);
			System.err.println("local==>"+local);
			String sql = "select mp_chk_pat_mand_flds(?,?) val from dual";
			pstmt			= con.prepareStatement(sql);
			pstmt.setString(1, patientId);
			pstmt.setString(2, local);
			rs				= pstmt.executeQuery();
			
			if(rs!=null && rs.next()){
				funRetValue = checkForNull(rs.getString("val"));
				System.err.println("funRetValue==>"+funRetValue);
				if(!funRetValue.equals("")){
					StringTokenizer strTok = new StringTokenizer(funRetValue,"|");
					if (strTok.hasMoreTokens()){
						returnValue = strTok.nextToken();
						if ( returnValue.equals("N") ){
							if (strTok.hasMoreTokens())
								returnValue = strTok.nextToken();
						}
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in chkMPMandFieldsForEncCreation - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return returnValue;
	}
/*Added By Dharma on 12th May 2020 against KDAH-CRF-0522.1 End*/
	
	/*Added by Ashwini on 27-Jul-2020 for ML-MMOH-CRF-1549*/
	public static JSONObject getLicenceEncDate(Connection con, String facility_id) throws Exception{
			
		JSONObject jsonObj		= new JSONObject();
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql				= "";
		String licence_date		= "";

		try{

			sql = "SELECT dir_main_dtl licence_date FROM sm_facility_param WHERE facility_id = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				licence_date = checkForNull(rs.getString("licence_date"));
			}

			jsonObj.put("licence_date",licence_date);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getLicenceEncDate - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return jsonObj;
	}

	public static JSONObject getLicenceExpYN(Connection con, String decrypted_date) throws Exception{
			
		JSONObject jsonObj		= new JSONObject();
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql				= "";
		String lic_exp_yn		= "";

		try{

			sql = "SELECT NVL ((SELECT 'Y' FROM DUAL WHERE TO_DATE (TO_CHAR (SYSDATE, 'DD/MM/YYYY'), 'DD/MM/YYYY') > TO_DATE (?, 'DD/MM/YYYY')), 'N' ) lic_exp_yn FROM DUAL";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,decrypted_date);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				lic_exp_yn = checkForNull(rs.getString("lic_exp_yn"));
			}

			jsonObj.put("lic_exp_yn",lic_exp_yn);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getLicenceExpYN - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return jsonObj;
	}

	public static JSONObject getKeyForValidation(Connection con) throws Exception{
			
		JSONObject jsonObj		= new JSONObject();
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql				= "";
		String lic_key			= "";

		try{

			sql = "SELECT key_2 FROM sm_function_control WHERE module_id = 'MR' AND functionality_id = 'SMRP' AND site_id = (SELECT customer_id FROM sm_site_param)";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				lic_key = checkForNull(rs.getString("key_2"));
			}

			jsonObj.put("lic_key",lic_key);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getKeyForValidation - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return jsonObj;
	}
	/*End ML-MMOH-CRF-1549*/

	/*Added by Ashwini on 02-Feb-2021 for AAKH-CRF-0128.1*/
	public static JSONObject getMPPatContactDetails(Connection con, String patient_id) throws Exception{
			
		JSONObject jsonObj		= new JSONObject();
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql				= "";
		String country_code		= "";
		String region_code		= "";

		try{

			sql = "SELECT a.region_code, b.country1_code FROM mp_patient a, mp_pat_addresses b WHERE a.patient_id = b.patient_id AND a.patient_id = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,patient_id);
			rs = pstmt.executeQuery();		

			if(rs!=null && rs.next()){
				country_code = checkForNull(rs.getString("country1_code"));
				region_code = checkForNull(rs.getString("region_code"));
			}

			jsonObj.put("country_code",country_code);
			jsonObj.put("region_code",region_code);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getMPPatContactDetails - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return jsonObj;
	}
	/*End AAKH-CRF-0128.1*/
	/*Added by Kamatchi for ML-MMOH-CRF-1182 */
	public static String getFPPDetails(Connection con,String facilityId,String episodeType,String episode_id) throws Exception{
		
		CallableStatement callStmt = null;
		ResultSet rs 				= null;
		String sql					= "";
		String isFPPPatientYN		= "";
		try{

			long episodeid = Long.parseLong(episode_id);
			callStmt = con.prepareCall("{? = call blcommon.fpp_patient_yn(?,?,?,?)}");
			callStmt.registerOutParameter(1,java.sql.Types.VARCHAR);

			callStmt.setString(2, facilityId);
			callStmt.setString(3, episodeType);
			callStmt.setLong(4, episodeid);
			callStmt.registerOutParameter(5,java.sql.Types.VARCHAR);

			callStmt.execute();
			isFPPPatientYN 		= callStmt.getString(1);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				
				if(callStmt!=null)callStmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getFPPDetails method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return isFPPPatientYN;
	}
public static String getPatientEncounterDetails(Connection con, String facility_id, String encounter_id) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql					= "";
		String patient_class		= "";
		String episode_Type			= "";
		try{
			sql = "SELECT patient_class FROM pr_encounter WHERE facility_id = ? AND encounter_id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){

					patient_class = rs.getString("patient_class");

			}
		if(patient_class.equals("IP"))
				episode_Type="I";
		else if(patient_class.equals("DC"))
				episode_Type="D";
		else if(patient_class.equals("OP"))
				episode_Type="O";
		else if(patient_class.equals("EM"))
				episode_Type="E";
		else
				episode_Type="";	
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getPatientEncounterDetails - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return episode_Type;
	}
/*Added by Kamatchi for ML-MMOH-CRF-1182 END*/

	/*Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187*/
	public static JSONObject getSpecDescforLoc(Connection con, String location_code, String location_type, String facility_id, String language_id) throws Exception{
			
			PreparedStatement pstmt	= null;
			ResultSet rs 			= null;
			JSONObject jsonObj		= new JSONObject();
			String sql				= "";
			String specialty_desc	= "";
			String specialty_code	= "";

			try{

				sql = "SELECT short_desc specialty_desc, speciality_code specialty_code FROM am_speciality_lang_vw WHERE language_id = ? AND speciality_code = (SELECT speciality_code FROM op_clinic_lang_vw WHERE clinic_code = ? AND clinic_type = ? AND facility_id = ? AND language_id = ?)";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,language_id);
				pstmt.setString(2,location_code);
				pstmt.setString(3,location_type);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,language_id);

				rs = pstmt.executeQuery();
				
				if(rs!=null && rs.next())
				{
					specialty_desc = checkForNull(rs.getString("specialty_desc"));
					specialty_code = checkForNull(rs.getString("specialty_code"));
					jsonObj.put("specialty_desc",specialty_desc);
					jsonObj.put("specialty_code",specialty_code);
				}

			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
				}catch(Exception ex){
					System.err.println("Exception in getSpecDescforLoc - "+ex.getMessage());
					ex.printStackTrace();
				}
			}

			return jsonObj;
	}

	public static JSONObject getSpecDescforLocNurUnit(Connection con, String location_code, String facility_id, String language_id) throws Exception{
			
			PreparedStatement pstmt	= null;
			ResultSet rs 			= null;
			JSONObject jsonObj		= new JSONObject();
			String sql				= "";
			int noOfRecords			= 0;
			String specialty_desc	= "";
			String specialty_code	= "";

			try{

				sql = "SELECT COUNT (*) OVER () noOfRecords, short_desc specialty_desc, speciality_code specialty_code FROM am_speciality_lang_vw a, ip_nurs_unit_for_specialty b WHERE a.speciality_code = b.specialty_code AND a.eff_status = 'E' AND b.nursing_unit_code = ? AND b.facility_id = ? AND language_id = ?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,location_code);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,language_id);

				rs = pstmt.executeQuery();
				
				while(rs!=null && rs.next())
				{
					noOfRecords = rs.getInt("noOfRecords");
					specialty_desc = checkForNull(rs.getString("specialty_desc"));
					specialty_code = checkForNull(rs.getString("specialty_code"));
				}
				
				jsonObj.put("noOfRecords",noOfRecords);
				jsonObj.put("specialty_desc",specialty_desc);
				jsonObj.put("specialty_code",specialty_code);

			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
				}catch(Exception ex){
					System.err.println("Exception in getSpecDescforLocNurUnit - "+ex.getMessage());
					ex.printStackTrace();
				}
			}

			return jsonObj;
	}

	public static JSONObject getCurrentFromAndToDate(Connection con) throws Exception{
			
			PreparedStatement pstmt	= null;
			ResultSet rs 			= null;
			JSONObject jsonObj		= new JSONObject();
			String sql				= "";
			
			try{

				 sql = "SELECT TO_CHAR (SYSDATE - 30, 'dd/mm/yyyy') current_from_date, TO_CHAR (SYSDATE, 'dd/mm/yyyy') current_to_date FROM DUAL";

				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

				if(rs!=null && rs.next()){
						
						String current_from_date = checkForNull(rs.getString("current_from_date"));
						String current_to_date = checkForNull(rs.getString("current_to_date"));
						
						jsonObj.put("current_from_date",current_from_date);
						jsonObj.put("current_to_date",current_to_date);
				}
				
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
				}catch(Exception ex){
					System.err.println("Exception in getCurrentFromAndToDate - "+ex.getMessage());
					ex.printStackTrace();
				}
			}

			return jsonObj;
	}
	/*End MMS-DM-CRF-0187*/
	// Added by lakshmanan for MO-CRF-20183.2 US001 start
public static JSONObject checkEmpServiceNo(Connection con, String empServNo,String empServNumCode,String pract_id,String fieldName,String headId ) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs = null;
		String sql = "";
		JSONObject jsonObj = new JSONObject();
		String employee_service_no="";
		try{
			if(fieldName.equals("alt_id1_no")){
		//	sql = "select distinct b.employee_service_no from am_practitioner b where b.practitioner_id='"+pract_id+"' and b.employee_service_no='"+empServNo+"'  AND Not EXISTS  (select c.employee_service_no from mp_patient c where b.employee_service_no = c.employee_service_no)";
			sql = "select distinct b.employee_service_no from am_practitioner b where  b.employee_service_no='"+empServNo+"'  AND Not EXISTS  (select c.employee_service_no from mp_patient c where b.employee_service_no = c.employee_service_no)";
			}
			else if(fieldName.equals("family_link_no") && !headId.equals(""))
				{
		//		sql = "select distinct b.employee_service_no from mp_patient  a,am_practitioner b WHERE  a.patient_id = '"+headId+"'  AND b.practitioner_id = '"+pract_id+"'  AND a.employee_service_no = b.employee_service_no";
				sql = "select distinct b.employee_service_no from mp_patient  a,am_practitioner b WHERE  a.patient_id = '"+headId+"'   AND a.employee_service_no = b.employee_service_no";
				}
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				employee_service_no = checkForNull(rs.getString("employee_service_no"));
			}
			jsonObj.put("employee_service_no",employee_service_no);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getFamilyLinkNo - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}

// Added by lakshmanan for MO-CRF-20183.2 US001 end

//Added by Kamatchi S for ML-MMOH-CRF-1930 US004
public static String getCountryFrmFacility(Connection con, String facility_id, String language_id) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql					= "";
		String country_code		= "";
		String episode_Type			= "";
		try{
			sql = "select COUNTRY_CODE from sm_facility_param_lang_vw where facility_id = ? and language_id = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,language_id);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){

					country_code = rs.getString("COUNTRY_CODE");

			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getCountryFrmFacility - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return country_code;
	}


//Added by Ajay for AAKH-CRF-0179
public static String getEnableDeathRegisterFormYN(Connection con) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;	 
		String enable_death_reg_form_applYN		= "N";
		try{
			pstmt = con.prepareStatement(" SELECT ENBL_DEATH_REG_FORM_DECEASED FROM MP_PARAM WHERE MODULE_ID='MP'");
			rs = pstmt.executeQuery();
			if(rs != null && rs.next()) {
				enable_death_reg_form_applYN	= checkForNull(rs.getString("ENBL_DEATH_REG_FORM_DECEASED"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getEnableDeathRegisterFormYN - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return enable_death_reg_form_applYN;
	}
//Ends
//Added by Kamatchi S for MOHE-CRF-0154 
public static String getRegisterReferralYN(Connection con,String facilityId) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String isRegisterReferralYN		= "";
		try{

			String sql = "select allow_reg_referral_yn from ip_param where facility_id=?";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,facilityId);
			rs	= pstmt.executeQuery();

			while(rs!=null && rs.next()){
				isRegisterReferralYN		= checkForNull(rs.getString("allow_reg_referral_yn"));
			}
			                                                                     
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getRegisterReferralYN - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return isRegisterReferralYN;
	}
// checkForNull added by mujafar for IN:067104
//Added by Prakash for PMG2023-COMN-CRF-0002.4-US001
public static String getArchivalYN(Connection con,String patient_id) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String isArchivalYN		= "";
		try{

			String sql = "select ENC_PURGE_YN from mp_patient where patient_id=?";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,patient_id);
			rs	= pstmt.executeQuery();

			while(rs!=null && rs.next()){
				isArchivalYN		= checkForNull(rs.getString("ENC_PURGE_YN"));
			}
			System.err.println("MPCommonBean.java ==>isArchivalYN==>"+isArchivalYN);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getArchivalYN - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return isArchivalYN;
	}
public static String getUserPassword(Connection con,String login_user_id) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String user_password		= "";
		try{
			System.err.println("MPCommonBean.java ==>login_user_id called==>"+login_user_id);
			String sql = "SELECT appl_user_password FROM sm_appl_user WHERE appl_user_id =?";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,login_user_id);
			rs	= pstmt.executeQuery();

			while(rs!=null && rs.next()){
				user_password		= checkForNull(rs.getString("appl_user_password"));
			}
			System.err.println("MPCommonBean.java ==>user_password==>"+user_password);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getUserPassword - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return user_password;
	}	
public static String getArchivalDBUrl(Connection con) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;	 
		String ArchivalDBUrl	= "";
		try{
			pstmt = con.prepareStatement(" SELECT ARCH_DB_3TIER_URL FROM EM_PRGE_USR.PR_EM_DT_ARCH_PRM");
			rs = pstmt.executeQuery();
			if(rs != null && rs.next()) {
				ArchivalDBUrl	= checkForNull(rs.getString("ARCH_DB_3TIER_URL"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getArchivalDBUrl - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return ArchivalDBUrl;
	}

	/*Added by Ashwini on 22-Dec-2023 for PMG2023-COMN-CRF-0002.9 54635 Bug*/
	public static String getLstPurgeEncId(Connection con,String patient_id) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		String lst_purge_encntr_id	= "";
		try{

			String sql = "SELECT lst_purge_encntr_id FROM mp_patient WHERE patient_id = ?";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,patient_id);
			rs	= pstmt.executeQuery();

			while(rs!=null && rs.next()){
				lst_purge_encntr_id	= checkForNull(rs.getString("lst_purge_encntr_id"));
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getLstPurgeEncId - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return lst_purge_encntr_id;
	}
	//Added by kamatchi s for ML-MMOH-CRF-2095
	public static JSONObject getLengthHeadValueYN(Connection con) throws Exception{
			
		JSONObject jsonObj		= new JSONObject();
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql				= "";
		String length_of_baby_yn		= "";
		String head_circumference_of_baby_yn		= "";
		String mandate_first_newborn_yn = "";
		String mandate_first_newborn_ip_yn = "";
		String mandate_first_newborn_ae_yn = "";
		String mandate_second_newborn_yn = "";
		String mandate_second_newborn_ip_yn = "";
		String mandate_second_newborn_ae_yn = "";
		String mandate_third_newborn_yn = "";
		String mandate_third_newborn_ip_yn = "";
		String mandate_third_newborn_ae_yn = "";
		String mand_antenatal_newborn_yn = "";
		String mand_antenatal_newborn_ip_yn = "";
		String mand_antenatal_newborn_ae_yn = "";
		String enable_marital_status = "";
		String dflt_father_first_name_prompt = "";
		String dflt_father_Second_name_prompt = "";
		String dflt_father_third_name_prompt = "";
		String dflt_father_family_name_prompt = "";
		String first_name_length = "";
		String second_name_length = "";
		String third_name_length = "";
		String family_name_length = "";
		try{
			sql = "SELECT LENGTH_OF_BABY_YN,HEAD_CIRCUMFERENCE_OF_BABY_YN,Mandate_First_NewBorn_yn,Mandate_First_NewBorn_IP_yn,Mandate_First_NewBorn_AE_yn, Mandate_Second_NewBorn_yn,Mandate_Second_NewBorn_IP_yn,Mandate_Second_NewBorn_AE_yn,Mandate_Third_NewBorn_yn,Mandate_Third_NewBorn_IP_yn,Mandate_Third_NewBorn_AE_yn,Mand_Antenatal_NewBorn_yn,Mand_Antenatal_NewBorn_IP_yn,Mand_Antenatal_NewBorn_AE_yn,enable_marital_status,dflt_father_first_name_prompt,dflt_father_Second_name_prompt,dflt_father_third_name_prompt,dflt_father_family_name_prompt,first_name_length,second_name_length,third_name_length,family_name_length FROM mp_param WHERE module_id = 'MP'";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				length_of_baby_yn = checkForNull(rs.getString("LENGTH_OF_BABY_YN"));
				head_circumference_of_baby_yn = checkForNull(rs.getString("HEAD_CIRCUMFERENCE_OF_BABY_YN"));
				mandate_first_newborn_yn    = checkForNull(rs.getString( "Mandate_First_NewBorn_yn"));
				mandate_first_newborn_ip_yn    = checkForNull(rs.getString( "Mandate_First_NewBorn_IP_yn"));
				mandate_first_newborn_ae_yn    = checkForNull(rs.getString( "Mandate_First_NewBorn_AE_yn"));
				mandate_second_newborn_yn    = checkForNull(rs.getString( "Mandate_Second_NewBorn_yn"));
				mandate_second_newborn_ip_yn    = checkForNull(rs.getString( "Mandate_Second_NewBorn_IP_yn"));
				mandate_second_newborn_ae_yn    = checkForNull(rs.getString( "Mandate_Second_NewBorn_AE_yn"));
				mandate_third_newborn_yn    = checkForNull(rs.getString( "Mandate_Third_NewBorn_yn"));
				mandate_third_newborn_ip_yn    = checkForNull(rs.getString( "Mandate_Third_NewBorn_IP_yn"));
				mandate_third_newborn_ae_yn    = checkForNull(rs.getString( "Mandate_Third_NewBorn_AE_yn"));
				mand_antenatal_newborn_yn    = checkForNull(rs.getString( "Mand_Antenatal_NewBorn_yn"));
				mand_antenatal_newborn_ip_yn    = checkForNull(rs.getString( "Mand_Antenatal_NewBorn_IP_yn"));
				mand_antenatal_newborn_ae_yn    = checkForNull(rs.getString( "Mand_Antenatal_NewBorn_AE_yn"));
				enable_marital_status    = checkForNull(rs.getString( "enable_marital_status"));
				dflt_father_first_name_prompt    = checkForNull(rs.getString( "dflt_father_first_name_prompt"));
				dflt_father_Second_name_prompt    = checkForNull(rs.getString( "dflt_father_Second_name_prompt"));
				dflt_father_third_name_prompt    = checkForNull(rs.getString( "dflt_father_third_name_prompt"));
				dflt_father_family_name_prompt    = checkForNull(rs.getString( "dflt_father_family_name_prompt"));
				first_name_length    = checkForNull(rs.getString( "first_name_length"));
				second_name_length    = checkForNull(rs.getString( "second_name_length"));
				third_name_length    = checkForNull(rs.getString( "third_name_length"));
				family_name_length    = checkForNull(rs.getString( "family_name_length"));
			} 

			jsonObj.put("length_of_baby_yn",length_of_baby_yn);
			jsonObj.put("head_circumference_of_baby_yn",head_circumference_of_baby_yn);
			jsonObj.put("mandate_first_newborn_yn",mandate_first_newborn_yn);
			jsonObj.put("mandate_first_newborn_ip_yn",mandate_first_newborn_ip_yn);
			jsonObj.put("mandate_first_newborn_ae_yn",mandate_first_newborn_ae_yn);
			jsonObj.put("mandate_second_newborn_yn",mandate_second_newborn_yn);
			jsonObj.put("mandate_second_newborn_ip_yn",mandate_second_newborn_ip_yn);
			jsonObj.put("mandate_second_newborn_ae_yn",mandate_second_newborn_ae_yn);
			jsonObj.put("mandate_third_newborn_yn",mandate_third_newborn_yn);
			jsonObj.put("mandate_third_newborn_ip_yn",mandate_third_newborn_ip_yn);
			jsonObj.put("mandate_third_newborn_ae_yn",mandate_third_newborn_ae_yn);
			jsonObj.put("mand_antenatal_newborn_yn",mand_antenatal_newborn_yn);
			jsonObj.put("mand_antenatal_newborn_ip_yn",mand_antenatal_newborn_ip_yn);
			jsonObj.put("mand_antenatal_newborn_ae_yn",mand_antenatal_newborn_ae_yn);
			jsonObj.put("enable_marital_status",enable_marital_status);
			jsonObj.put("dflt_father_first_name_prompt",dflt_father_first_name_prompt);
			jsonObj.put("dflt_father_Second_name_prompt",dflt_father_Second_name_prompt);
			jsonObj.put("dflt_father_third_name_prompt",dflt_father_third_name_prompt);
			jsonObj.put("dflt_father_family_name_prompt",dflt_father_family_name_prompt);
			jsonObj.put("first_name_length",first_name_length);
			jsonObj.put("second_name_length",second_name_length);
			jsonObj.put("third_name_length",third_name_length);
			jsonObj.put("family_name_length",family_name_length);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getLengthHeadValueYN - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return jsonObj;
	}

	//Added by kamatchi s for MMS-DM-CRF-0261
		public static JSONObject getPatDtlsAPI(Connection con,String encounter_id,String user_id,String facility_id,String patient_id) throws Exception{
			
		JSONObject jsonObj		= new JSONObject();
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		PreparedStatement pstmt1	= null;
		ResultSet rs1			= null;
		PreparedStatement pstmt2	= null;
		ResultSet rs2			= null;
		PreparedStatement pstmt3	= null;
		ResultSet rs3			= null;
		PreparedStatement pstmt4	= null;
		ResultSet rs4			= null;
		String sql				= "";
		String sql1				= "";
		String sql2			= "";
		String sql3			= "";
		StringBuffer sql4 = new StringBuffer();	
		String dob		= "";
		String serverUrl		= "";
		String sessionTimeout		= "";
		String func_role_id		= "";
		String nphies_fac_id	= "";
		String attend_pract_id	= "";
		String admit_pract_id	= "";
		try{
			sql = "Select to_char(a.DATE_OF_BIRTH,'yyyy-MM-dd') DATE_OF_BIRTH from mp_patient a,pr_encounter b where b.encounter_id = ? and a.patient_id = b.patient_id";
			sql1 =  "SELECT server_url, session_timeout FROM mp_nphies_config";
			sql2 =  "select FUNC_ROLE_ID from sm_appl_user where appl_user_id =? and func_role = 'P'";
			sql3 =  "select NPHIES_FACILITY from mp_nphies_facility_map where EM_FACILITY = ?";
			sql4.append("SELECT attend_practitioner_id, admit_practitioner_id FROM pr_encounter ");
			if(!patient_id.equals("") && !encounter_id.equals("")){
			sql4.append("WHERE patient_id = ? and encounter_id = ? ");
			}
			else if(!patient_id.equals("")){
			sql4.append("WHERE patient_id = ? ");
			}
			else if(!encounter_id.equals("")){
			sql4.append("WHERE encounter_id = ? "); 
			}
			sql4.append("and (( admit_practitioner_id IN (SELECT practitioner_id FROM am_practitioner)) OR (attend_practitioner_id IN (SELECT practitioner_id FROM am_practitioner)) ) ");
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,encounter_id);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				dob = checkForNull(rs.getString("DATE_OF_BIRTH"));
			} 

			pstmt1 = con.prepareStatement(sql1);
			rs1 = pstmt1.executeQuery();

			if(rs1!=null && rs1.next()){
				serverUrl = checkForNull(rs1.getString("server_url"));
				sessionTimeout = checkForNull(rs1.getString("session_timeout"));
			} 

			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setString(1,user_id);
			rs2 = pstmt2.executeQuery();

			if(rs2!=null && rs2.next()){
				func_role_id = checkForNull(rs2.getString("FUNC_ROLE_ID"));
			}

			pstmt3 = con.prepareStatement(sql3);
			pstmt3.setString(1,facility_id);
			rs3 = pstmt3.executeQuery();

			if(rs3!=null && rs3.next()){
				nphies_fac_id = checkForNull(rs3.getString("NPHIES_FACILITY"));
			}
			pstmt4 = con.prepareStatement(sql4.toString());
			if(!patient_id.equals("") && !encounter_id.equals("")){
			pstmt4.setString(1,checkForNull(patient_id));
			pstmt4.setString(2,checkForNull(encounter_id));
			}
			else if(!patient_id.equals("")){
			pstmt4.setString(1,checkForNull(patient_id));
			}
			else if(!encounter_id.equals("")){
			pstmt4.setString(1,checkForNull(encounter_id));
			}
			rs4 = pstmt4.executeQuery();
			if(rs4!=null && rs4.next()){
				attend_pract_id = checkForNull(rs4.getString("attend_practitioner_id"));
				admit_pract_id = checkForNull(rs4.getString("admit_practitioner_id"));
			}
			jsonObj.put("dob",dob);
			jsonObj.put("serverUrl",serverUrl);
			jsonObj.put("sessionTimeout",sessionTimeout);
			jsonObj.put("func_role_id",func_role_id);
			jsonObj.put("nphies_fac_id",nphies_fac_id);
			jsonObj.put("attend_pract_id",attend_pract_id);
			jsonObj.put("admit_pract_id",admit_pract_id);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(rs1!=null)rs1.close();
				if(pstmt1!=null)pstmt1.close();
				if(rs2!=null)rs2.close();
				if(pstmt2!=null)pstmt2.close();
				if(rs3!=null)rs3.close();
				if(pstmt3!=null)pstmt3.close();
				if(rs4!=null)rs4.close();
				if(pstmt4!=null)pstmt4.close();
			}catch(Exception ex){
				System.err.println("Exception in getPatDtlsAPI - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return jsonObj;
	}


public static JSONObject getComplicationValue(Connection con,String patient_id) throws Exception{
			
		JSONObject jsonObj		= new JSONObject();
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql				= "";
		String emer_regn_nb_yn		= "";
		String ip_regn_nb_yn		= "";
		String mp_regn_nb_yn = "";
		String ant_care_gvn_at = "";
		String ant_care_locn_type = "";
		String ant_care_locn_code = "";
		String no_marital_status = "";
		try{
			sql = "select EMER_REGN_NB_YN,IP_REGN_NB_YN,MP_REGN_NB_YN,ANT_CARE_GVN_AT,ANT_CARE_LOCN_TYPE,ANT_CARE_LOCN_CODE,NO_MARITAL_STATUS from mp_birth_register where patient_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,patient_id);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				emer_regn_nb_yn = checkForNull(rs.getString("EMER_REGN_NB_YN"));
				ip_regn_nb_yn = checkForNull(rs.getString("IP_REGN_NB_YN"));
				mp_regn_nb_yn    = rs.getString( "MP_REGN_NB_YN");
				ant_care_gvn_at    = rs.getString( "ANT_CARE_GVN_AT");
				ant_care_locn_type    = rs.getString( "ANT_CARE_LOCN_TYPE");
				ant_care_locn_code    = rs.getString( "ANT_CARE_LOCN_CODE");
				no_marital_status    = rs.getString( "NO_MARITAL_STATUS");
			}

			jsonObj.put("emer_regn_nb_yn",emer_regn_nb_yn);
			jsonObj.put("ip_regn_nb_yn",ip_regn_nb_yn);
			jsonObj.put("mp_regn_nb_yn",mp_regn_nb_yn);
			jsonObj.put("ant_care_gvn_at",ant_care_gvn_at);
			jsonObj.put("ant_care_locn_type",ant_care_locn_type);
			jsonObj.put("ant_care_locn_code",ant_care_locn_code);
			jsonObj.put("no_marital_status",no_marital_status);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getComplicationValue - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return jsonObj;
	}
	
public static JSONObject getAbhaCallDetails(Connection con,String Abha_ID) throws Exception{
			
		JSONObject jsonObj		= new JSONObject();
		PreparedStatement pstmt	= null;
		PreparedStatement pstmt1	= null;
		PreparedStatement prpstmt	= null;
		ResultSet rs 			= null;
		ResultSet rs1			= null;
		ResultSet rs2			= null;
		String sql				= "";
		String sql1				= "";
		String sql2				= "";
		String patient_name		= "";
		String date_of_birth		= "";
		String sex = "";
		String email = "";
		String contact1_no = "";
		String first_name_accept_yn = "";
		String second_name_accept_yn = "";
		String third_name_accept_yn = "";
		String family_name_accept_yn = "";
		String area_code_desc = "";
		String region_code_desc = "";
		String area_code = "";
		String region_code = "";
		try{
			sql = "select PATIENT_NAME,to_char(DATE_OF_BIRTH, 'dd/mm/yyyy') DATE_OF_BIRTH,SEX,CONTACT1_NO,AREA_DESC AREA_CODE_DESC,REGION_DESC REGION_CODE_DESC,EMAIL from XH_PATIENT_EXT_INFO where PATIENT_ID=? and rownum=1";
			sql1="SELECT first_name_accept_yn, second_name_accept_yn, third_name_accept_yn,  family_name_accept_yn FROM mp_param where module_id='MP'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,Abha_ID);
			rs = pstmt.executeQuery();


			if(rs!=null && rs.next()){
				patient_name = checkForNull(rs.getString("PATIENT_NAME"));
				date_of_birth = checkForNull(rs.getString("DATE_OF_BIRTH"));
				sex    = rs.getString( "SEX");
				email    = rs.getString( "EMAIL");
				contact1_no    = rs.getString( "CONTACT1_NO");
				area_code_desc    = rs.getString( "AREA_CODE_DESC");
				region_code_desc    = rs.getString( "REGION_CODE_DESC");
			}
			
			System.err.println("area_code_desc ===>"+area_code_desc);
			System.err.println("region_code_desc ===>"+region_code_desc);
			
			pstmt1 = con.prepareStatement(sql1);
			rs1 = pstmt1.executeQuery();
			
			if(rs1!=null && rs1.next()){
				first_name_accept_yn = checkForNull(rs1.getString("first_name_accept_yn"));
				second_name_accept_yn = checkForNull(rs1.getString("second_name_accept_yn"));
				third_name_accept_yn    = rs1.getString( "third_name_accept_yn");
				family_name_accept_yn    = rs1.getString( "family_name_accept_yn");
			}

			sql2="select b.res_area_code res_area_code,a.region_code  region_code from mp_region a ,mp_res_area b where a.region_code=b.region_code and UPPER(a.short_desc) = UPPER('"+region_code_desc+"') and UPPER(b.short_desc) = UPPER('"+area_code_desc+"')"; 
			System.err.println("sql2=====>"+sql2.toString());
			prpstmt = con.prepareStatement(sql2);
			rs2 = prpstmt.executeQuery();
			
			if(rs2!=null && rs2.next()){		
			area_code = checkForNull(rs2.getString("res_area_code"));
			region_code = checkForNull(rs2.getString("region_code"));
			} else {
			area_code = "";
			region_code="";
			}
			
			jsonObj.put("patient_name",patient_name);
			jsonObj.put("date_of_birth",date_of_birth);
			jsonObj.put("sex",sex);
			jsonObj.put("email",email);
			jsonObj.put("contact1_no",contact1_no);
			
			jsonObj.put("first_name_accept_yn",first_name_accept_yn);
			jsonObj.put("second_name_accept_yn",second_name_accept_yn);
			jsonObj.put("third_name_accept_yn",third_name_accept_yn);
			jsonObj.put("family_name_accept_yn",family_name_accept_yn);
			
			jsonObj.put("area_code_desc",area_code_desc);
			jsonObj.put("region_code_desc",region_code_desc);
			jsonObj.put("area_code",area_code);
			jsonObj.put("region_code",region_code);
		
			System.err.println("area_code_desc ===>"+area_code_desc);
			System.err.println("region_code_desc ===>"+region_code_desc);
			System.err.println("area_code ===>"+area_code);
			System.err.println("region_code ===>"+region_code);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(rs1!=null)rs1.close();
				if(rs2!=null)rs2.close();
				if(pstmt!=null)pstmt.close();
				if(pstmt1!=null)pstmt1.close();
				if(prpstmt!=null)prpstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getAbhaCallDetails - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return jsonObj;
	}

public static JSONObject getEnableAlternateIDs(Connection con,String userId,String Language_ID,String facilityId) throws Exception{
			
		JSONObject jsonObj		= new JSONObject();
		PreparedStatement pstmt	= null;
		PreparedStatement pstmt1	= null;
		ResultSet rs 			= null;
		ResultSet rs1			= null;
		String sql				= "";
		String sql1				= "";
		String enable_alternate_id1_yn		= "";
		String enable_alternate_id2_yn		= "";
		String enable_alternate_id3_yn = "";
		String enable_alternate_id4_yn = "";
		
		String alt_id1_desc = "";
		String alt_id2_desc = "";
		String alt_id3_desc = "";
		String alt_id4_desc = "";
		try{
			sql = "select P.ENABLE_ALTERNATE_ID1_YN,P.ENABLE_ALTERNATE_ID2_YN,P.ENABLE_ALTERNATE_ID3_YN,P.ENABLE_ALTERNATE_ID4_YN from MR_USER_ACCESS_RIGHTS P where P.APPL_USER_ID=? and P.FACILITY_ID=?";
			sql1="Select mp_get_desc.mp_alternate_id_type(param.alt_id1_type, param.language_id, '1') alt_id1_desc,param.alt_id2_type,mp_get_desc.mp_alternate_id_type(param.alt_id2_type, param.language_id, '1') alt_id2_desc,param.alt_id3_type,mp_get_desc.mp_alternate_id_type(param.alt_id3_type, param.language_id, '1') alt_id3_desc,param.alt_id4_type,mp_get_desc.mp_alternate_id_type(param.alt_id4_type, param.language_id, '1') alt_id4_desc FROM mp_param_lang_vw param WHERE param.module_id = 'MP' AND param.language_id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,userId);
			pstmt.setString(2,facilityId);
			rs = pstmt.executeQuery();


			if(rs!=null && rs.next()){
				enable_alternate_id1_yn = checkForNull(rs.getString("ENABLE_ALTERNATE_ID1_YN"));
				enable_alternate_id2_yn = checkForNull(rs.getString("ENABLE_ALTERNATE_ID2_YN"));
				enable_alternate_id3_yn = checkForNull(rs.getString("ENABLE_ALTERNATE_ID3_YN"));
				enable_alternate_id4_yn = checkForNull(rs.getString("ENABLE_ALTERNATE_ID4_YN"));
				
			}
			
			pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1,Language_ID);
			rs1 = pstmt1.executeQuery();
			
			if(rs1!=null && rs1.next()){
				alt_id1_desc = checkForNull(rs1.getString("alt_id1_desc"));
				alt_id2_desc = checkForNull(rs1.getString("alt_id2_desc"));
				alt_id3_desc    = rs1.getString( "alt_id3_desc");
				alt_id4_desc    = rs1.getString( "alt_id4_desc");
			}

			jsonObj.put("enable_alternate_id1_yn",enable_alternate_id1_yn);
			jsonObj.put("enable_alternate_id2_yn",enable_alternate_id2_yn);
			jsonObj.put("enable_alternate_id3_yn",enable_alternate_id3_yn);
			jsonObj.put("enable_alternate_id4_yn",enable_alternate_id4_yn);
			
			jsonObj.put("alt_id1_desc",alt_id1_desc);
			jsonObj.put("alt_id2_desc",alt_id2_desc);
			jsonObj.put("alt_id3_desc",alt_id3_desc);
			jsonObj.put("alt_id4_desc",alt_id4_desc);
		
		System.err.println("userId java===>"+userId);
		System.err.println("Language_ID java ===>"+Language_ID);
		System.err.println("facilityId java  ===>"+facilityId);
		
			System.err.println("enable_alternate_id1_yn ===>"+enable_alternate_id1_yn);
			System.err.println("enable_alternate_id2_yn ===>"+enable_alternate_id2_yn);
			System.err.println("enable_alternate_id3_yn ===>"+enable_alternate_id3_yn);
			System.err.println("enable_alternate_id4_yn ===>"+enable_alternate_id4_yn);
			
			System.err.println("alt_id1_desc ===>"+alt_id1_desc);
			System.err.println("alt_id2_desc ===>"+alt_id2_desc);
			System.err.println("alt_id3_desc ===>"+alt_id3_desc);
			System.err.println("alt_id4_desc ===>"+alt_id4_desc);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(rs1!=null)rs1.close();
				if(pstmt!=null)pstmt.close();
				if(pstmt1!=null)pstmt1.close();
			}catch(Exception ex){
				System.err.println("Exception in getEnableAlternateIDs - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return jsonObj;
}

public static JSONObject getRestrictReferralDetails(Connection con,String referral_id,String patient_id) throws Exception{
			
		JSONObject jsonObj		= new JSONObject();
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql				= "";
		String from_ref_type		= "";
		String from_ref_code		= "";
		String from_locn_type = "";
		String from_locn_code = "";
		String from_pract_id = "";
		String bedside_referral_yn = "";
		String to_pract_id = "";
		String to_locn_code = "";
		String to_locn_type = "";
		try{
			sql = "SELECT FROM_REF_TYPE,FROM_REF_CODE,FROM_LOCN_TYPE,FROM_LOCN_CODE,FROM_PRACT_ID,BEDSIDE_REFERRAL_YN,TO_PRACT_ID,TO_LOCN_CODE,TO_LOCN_TYPE FROM FROM PR_REFERRAL_REGISTER WHERE REFERRAL_ID=? AND PATIENT_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,referral_id);
			pstmt.setString(2,patient_id);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				from_ref_type = checkForNull(rs.getString("FROM_REF_TYPE"));
				from_ref_code = checkForNull(rs.getString("FROM_REF_CODE"));
				from_locn_type    = rs.getString( "FROM_LOCN_TYPE");
				from_locn_code    = rs.getString( "FROM_LOCN_CODE");
				from_pract_id    = rs.getString( "FROM_PRACT_ID");
				bedside_referral_yn    = rs.getString( "BEDSIDE_REFERRAL_YN");
				to_pract_id    = rs.getString( "TO_PRACT_ID");
				to_locn_code    = rs.getString( "TO_LOCN_CODE");
				to_locn_type    = rs.getString( "TO_LOCN_TYPE");
			}

			jsonObj.put("from_ref_type",from_ref_type);
			jsonObj.put("from_ref_code",from_ref_code);
			jsonObj.put("from_locn_type",from_locn_type);
			jsonObj.put("from_locn_code",from_locn_code);
			jsonObj.put("from_pract_id",from_pract_id);
			jsonObj.put("bedside_referral_yn",bedside_referral_yn);
			jsonObj.put("to_pract_id",to_pract_id);
			jsonObj.put("to_locn_code",to_locn_code);
			jsonObj.put("to_locn_type",to_locn_type);
			
			System.err.println("from_ref_type ===>"+from_ref_type);
			System.err.println("from_ref_code ===>"+from_ref_code);
			System.err.println("from_locn_type ===>"+from_locn_type);
			System.err.println("from_locn_code ===>"+from_locn_code);
			System.err.println("from_pract_id ===>"+from_pract_id);
			System.err.println("bedside_referral_yn ===>"+bedside_referral_yn);
			System.err.println("to_pract_id ===>"+to_pract_id);
			System.err.println("to_locn_code ===>"+to_locn_code);
			System.err.println("to_locn_type ===>"+to_locn_type);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getRestrictReferralDetails - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return jsonObj;
	}
	
public static JSONObject getMRParamDetails(Connection con) throws Exception{
			
		JSONObject jsonObj		= new JSONObject();
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql				= "";
		String restrict_pract_self_referral		= "";
		String restrict_pract_self_rfl_ip_op		= "";
		String restrict_pract_self_rfl_op_ip = "";
		String restrict_bedside_self_referral = "";
		try{
			sql = "select RESTRICT_PRACT_SELF_REFERRAL,RESTRICT_PRACT_SELF_RFL_IP_OP,RESTRICT_PRACT_SELF_RFL_OP_IP,RESTRICT_BEDSIDE_SELF_REFERRAL from mr_parameter";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				restrict_pract_self_referral = checkForNull(rs.getString("RESTRICT_PRACT_SELF_REFERRAL"));
				restrict_pract_self_rfl_ip_op = checkForNull(rs.getString("RESTRICT_PRACT_SELF_RFL_IP_OP"));
				restrict_pract_self_rfl_op_ip    = rs.getString( "RESTRICT_PRACT_SELF_RFL_OP_IP");
				restrict_bedside_self_referral    = rs.getString( "RESTRICT_BEDSIDE_SELF_REFERRAL");
			}

			jsonObj.put("restrict_pract_self_referral",restrict_pract_self_referral);
			jsonObj.put("restrict_pract_self_rfl_ip_op",restrict_pract_self_rfl_ip_op);
			jsonObj.put("restrict_pract_self_rfl_op_ip",restrict_pract_self_rfl_op_ip);
			jsonObj.put("restrict_bedside_self_referral",restrict_bedside_self_referral);
			
			System.err.println("restrict_pract_self_referral ===>"+restrict_pract_self_referral);
			System.err.println("restrict_pract_self_rfl_ip_op ===>"+restrict_pract_self_rfl_ip_op);
			System.err.println("restrict_pract_self_rfl_op_ip ===>"+restrict_pract_self_rfl_op_ip);
			System.err.println("restrict_bedside_self_referral ===>"+restrict_bedside_self_referral);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getMRParamDetails - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return jsonObj;
	}

public static String getPackageData(Connection con,String patient_id,String encounter_id,String visit_id) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;	 
		String packageValue	= "";
		try{
			pstmt = con.prepareStatement("select bl_pack_util_func(?,?,?) packageValue from dual");
			pstmt.setString(1,patient_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,visit_id);
			rs = pstmt.executeQuery();
			if(rs != null && rs.next()) {
				packageValue	= checkForNull(rs.getString("packageValue"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getPackageData - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return packageValue;
	}

public static String checkForNull(String inputString){
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString,String defaultValue){
		return(((inputString == null) || (inputString.equals("null")) || (inputString.equals("")) ) ? defaultValue : inputString);
	}
	
	public static String getNDHMApplicable(Connection con){
		String sqlNDHMApplicable="SELECT count(*) FROM XH_STANDARD_PROFILE WHERE PROFILE_ID LIKE '%NDHMPROF1%' and NVL(EFF_STATUS,'Y') = 'Y' AND ROWNUM = 1  ";
		int count=0;
		String ndhmYN="N";
		PreparedStatement pstmt=null;
		ResultSet  rs=null;
		try{
			pstmt=con.prepareStatement(sqlNDHMApplicable);
			rs=pstmt.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
			if(count > 0){
				ndhmYN="Y";
			}
		}catch(Exception ex){
			System.err.println("Exception in getNDHMApplicable --> "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			}
			catch(Exception fe){
			}
		}
		return ndhmYN;
	}

//Added By Gaurav Against MMS-MEA-CRF-0004...starts

public static JSONObject getNationalIds(Connection con) throws Exception{
			
		JSONObject jsonObj		= new JSONObject();
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql				= "";
		String start_with		= "";
		String alt_id1_start_with = "";
		String alt_id2_start_with = "";
		String alt_id3_start_with = "";
		String alt_id4_start_with = "";
		try{
			sql = "SELECT START_ID_WITH,ALT_ID1_START_WITH,ALT_ID2_START_WITH,ALT_ID3_START_WITH,ALT_ID4_START_WITH FROM MP_PARAM";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				start_with = checkForNull(rs.getString("START_ID_WITH"));
				alt_id1_start_with	   = checkForNull(rs.getString("ALT_ID1_START_WITH"));
				alt_id2_start_with    = checkForNull(rs.getString( "ALT_ID2_START_WITH"));
				alt_id3_start_with    = checkForNull(rs.getString( "ALT_ID3_START_WITH"));
				alt_id4_start_with    = checkForNull(rs.getString( "ALT_ID4_START_WITH"));
			}

			jsonObj.put("start_with",start_with);
			jsonObj.put("alt_id1_start_with",alt_id1_start_with);
			jsonObj.put("alt_id2_start_with",alt_id2_start_with);
			jsonObj.put("alt_id3_start_with",alt_id3_start_with);
			jsonObj.put("alt_id4_start_with",alt_id4_start_with);
						
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getNationalIds - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return jsonObj;
	}
//Added By Gaurav Against MMS-MEA-CRF-0004...starts	
}