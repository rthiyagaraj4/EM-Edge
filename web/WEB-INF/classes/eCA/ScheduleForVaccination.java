/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?            created
12/07/2012	  IN33073		 Nijitha S	 New Vaccines added to the existing category does not appear in CA
07/09/2023	   41654			Twinkle Shah		Ramesh Goli                   MMS-JU-CRF-0015.4	
--------------------------------------------------------------------------------------------------------
*/ 
package eCA;
import java.sql.*;
import java.io.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;

public class ScheduleForVaccination  implements java.io.Serializable
{
	public void createScheduleForVaccination(Map paramMap) throws Exception
	{
		if (paramMap != null)
		{
			String patient_id = (String)paramMap.get("PATIENT_ID");
			String vacc_categ_id = (String)paramMap.get("VACC_CATEG_ID");
			String dob = (String)paramMap.get("DOB");
			Connection con = (Connection)paramMap.get("CON_OBJ");
			String encounter_id = (String)paramMap.get("ENCOUNTER_ID");
			String facility_id = (String)paramMap.get("FACILITY_ID");
			String scheduled_user_id = (String)paramMap.get("SCHEDULED_USER_ID");
			String login_user_id = (String)paramMap.get("LOGIN_USER_ID");
			String client_ip_address = (String)paramMap.get("CLIENT_IP_ADDRESS");
			//String locale = (String)paramMap.get("LOCALE");//Checkstyle
			String vac_sch_ref = (String)paramMap.get("VAC_SCH_REF");//IN033073

			PreparedStatement pstmt = null;
			PreparedStatement pstmtVaccine = null;//IN033073
			ResultSet rs = null;
			ResultSet vaccinePatientRS = null;//IN033073
			String sqlQuery = "";
			int result = 0;
			int [] results			= null;

			sqlQuery = "SELECT 1 FROM CA_IM_PAT_VAC_SCH_HDR WHERE PATIENT_ID=? AND VACC_CATEG_ID=?";
			pstmt = con.prepareStatement(sqlQuery);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,vacc_categ_id);
			/*//IN033073 rs = pstmt.executeQuery();
			if (!rs.next())
			{
				if (rs != null)rs.close();
				if (pstmt != null)pstmt.close();
			*/
			vaccinePatientRS = pstmt.executeQuery();//IN033073

				Map<String,Map<String,String>> vaccineMap  = new HashMap<String,Map<String,String>>();
				HashMap<String,String>  scheduleMap= null;
				//String schedule_days = "";//Checkstyle
				//String schedule_yrs = "";//Checkstyle
				//String schedule_mths = "";//Checkstyle
				String schedule_date = "";
				int schedule_duration = 0;
			//	sqlQuery = "SELECT VACCINE_ID,DOSE_NO,APPL_AGE_YEARS,APPL_AGE_MONTHS,APPL_AGE_DAYS FROM CA_IM_VAC_SCH_FOR_CATEG where VACC_CATEG_ID=?";
				sqlQuery = "SELECT VACCINE_ID,DOSE_NO, to_char(add_months(to_date(?,'dd/mm/yyyy')+ Nvl(APPL_AGE_DAYS,0),nvl(APPL_AGE_YEARS,0)*12+nvl(APPL_AGE_MONTHS,0)),'dd/mm/yyyy') schedule_date FROM CA_IM_VAC_SCH_FOR_CATEG where VACC_CATEG_ID=? AND vaccine_id NOT IN (SELECT vaccine_id FROM CA_IM_PAT_VAC_SCH_DTL WHERE vac_sch_ref = ? )"; // IN33073
				// IN33073 Starts
				/*pstmt = con.prepareStatement(sqlQuery);
				pstmt.setString(1,dob);
				pstmt.setString(2,vacc_categ_id);
				rs = pstmt.executeQuery();*/

				pstmtVaccine = con.prepareStatement(sqlQuery);
				pstmtVaccine.setString(1,dob);
				pstmtVaccine.setString(2,vacc_categ_id);
				pstmtVaccine.setString(3, vac_sch_ref);
				rs = pstmtVaccine.executeQuery();
				// IN33073 Ends

				while (rs.next())
				{
					schedule_duration = 0;
					scheduleMap = new HashMap<String,String>();
					scheduleMap.put("VACCINE_ID",rs.getString("VACCINE_ID"));
					scheduleMap.put("DOSE_NO",rs.getString("DOSE_NO"));
					schedule_date = rs.getString("SCHEDULE_DATE")==null?"":rs.getString("SCHEDULE_DATE");
					scheduleMap.put("SCHEDULE_DATE",schedule_date);
					vaccineMap.put(rs.getString("VACCINE_ID")+"_"+rs.getString("DOSE_NO"),scheduleMap);
				}

				if (rs != null)rs.close();
				if (pstmtVaccine != null)pstmtVaccine.close();
				//IN033073 Starts
				//IN033073 if (pstmt!= null)pstmt.close();
				//IN033073 Starts
				if(!vaccinePatientRS.next()){
					
					//IN033073 Ends
					/* if (vaccineMap.size() > 0)
					{ IN033073*/

					sqlQuery ="INSERT INTO CA_IM_PAT_VAC_SCH_HDR ( VAC_SCH_REF, PATIENT_ID, VACC_CATEG_ID, INITIATING_ENCOUNTER_ID, INITIATING_FACILITY_ID, SCHEDULED_USER_ID, SCH_CREATED_DATE, SCH_STATUS, ADDED_BY_ID, ADDED_DATE,ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE,MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES ( CA_IM_PAT_VAC_SCH_HDR_SEQ.NEXTVAL,?,?,?,?,?,to_date(SYSDATE,'DD/MM/YYYY HH24:MI'),?,?,sysdate,?,?,?,sysdate,?,? )";

					pstmt = con.prepareStatement(sqlQuery);
					pstmt.setString(1,patient_id);
					pstmt.setString(2,vacc_categ_id);
					pstmt.setString(3,encounter_id);
					pstmt.setString(4,facility_id);
					pstmt.setString(5,scheduled_user_id);
					//pstmt.setString(6,dob);
					//pstmt.setString(7,sch_closed_date);
					pstmt.setString(6,"A");
					pstmt.setString(7,login_user_id);
					pstmt.setString(8,client_ip_address);
					pstmt.setString(9,facility_id);
					pstmt.setString(10,login_user_id);
					pstmt.setString(11,client_ip_address);
					pstmt.setString(12,facility_id);

					result = pstmt.executeUpdate();
//					if(pstmt != null) pstmt.close();//IN033073
					//if (result > 0)
					
					
					if(result > 0 && null!=vaccineMap && vaccineMap.size() > 0){// IN33073 
						
						sqlQuery=" Insert into CA_IM_PAT_VAC_SCH_DTL( VAC_SCH_REF ,VACCINE_ID, DOSE_NO	, SCHEDULE_DATE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,OUTCOME_CODE) values( CA_IM_PAT_VAC_SCH_HDR_SEQ.CURRVAL,?,?,to_date(?,'DD/MM/YYYY'),?,sysdate,?,?, ?, sysdate, ?,?,'A') ";

						pstmt=con.prepareStatement(sqlQuery);

						for (String keys:vaccineMap.keySet())
						{
							Map<String,String> valueMap = vaccineMap.get(keys);
							pstmt.clearParameters();
							//pstmt.setString(1,val123);
							pstmt.setString(1,valueMap.get("VACCINE_ID"));
							pstmt.setString(2,valueMap.get("DOSE_NO"));
							//pstmt.setString(3,sch_created_date);
							pstmt.setString(3,valueMap.get("SCHEDULE_DATE"));
							pstmt.setString(4,login_user_id);
							pstmt.setString(5,client_ip_address);
							pstmt.setString(6,facility_id);
							pstmt.setString(7,login_user_id);
							pstmt.setString(8,client_ip_address);
							pstmt.setString(9,facility_id);
							pstmt.addBatch();
						}
						results = pstmt.executeBatch();
					}
					}// IN33073 Starts
					else if (null!=vac_sch_ref && !"".equals(vac_sch_ref) && null!=vaccineMap && vaccineMap.size() > 0)
					{
						sqlQuery=" Insert into CA_IM_PAT_VAC_SCH_DTL( VAC_SCH_REF ,VACCINE_ID, DOSE_NO	, SCHEDULE_DATE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,OUTCOME_CODE) values( ?,?,?,to_date(?,'DD/MM/YYYY'),?,sysdate,?,?, ?, sysdate, ?,?,'A') ";// IN33073

						pstmt=con.prepareStatement(sqlQuery);

						for (String keys:vaccineMap.keySet())
						{
							Map<String,String> valueMap = vaccineMap.get(keys);
							pstmt.clearParameters();
							//pstmt.setString(1,val123);
							pstmt.setString(1,vac_sch_ref);
							pstmt.setString(2,valueMap.get("VACCINE_ID"));
							pstmt.setString(3,valueMap.get("DOSE_NO"));
							//pstmt.setString(3,sch_created_date);
							pstmt.setString(4,valueMap.get("SCHEDULE_DATE"));
							pstmt.setString(5,login_user_id);
							pstmt.setString(6,client_ip_address);
							pstmt.setString(7,facility_id);
							pstmt.setString(8,login_user_id);
							pstmt.setString(9,client_ip_address);
							pstmt.setString(10,facility_id);
							pstmt.addBatch();
						}
						results = pstmt.executeBatch();
				}else{
				}
				if (vaccinePatientRS != null)vaccinePatientRS.close();
					// IN33073 Ends
					boolean insFlag = false;
					if(null!=results && results.length > 0)//IN33073
					{
					for(int k=0; k< results.length;++k )
					{
						if(results[k]<0  && results[k] != -2)
						{
							insFlag = false;
							break;
						}
						else
						{
							insFlag = true;
						}
					if(insFlag)
						con.commit();
					else
						con.rollback();
				}

				}
			if (pstmt != null)pstmt.close();
		}
		else
		{
			throw new Exception("paramMap cant be null.");
		}
	}

	public String createAdhocSchedule(Map paramMap)
	{
		String retVal = "TRANS_FAILED";
		if (paramMap != null)
		{
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sqlQuery = "";
			int result = 0;
			try
			{
				con = ConnectionManager.getConnection();
				String patient_id = (String)paramMap.get("PATIENT_ID");
				String vacc_categ_id = (String)paramMap.get("VACC_CATEG_ID");
				String encounter_id = (String)paramMap.get("ENCOUNTER_ID");
				String facility_id = (String)paramMap.get("FACILITY_ID");
				String scheduled_user_id = (String)paramMap.get("SCHEDULED_USER_ID");
				String login_user_id = (String)paramMap.get("LOGIN_USER_ID");
				String client_ip_address = (String)paramMap.get("CLIENT_IP_ADDRESS");





				sqlQuery = "SELECT 1 FROM CA_IM_PAT_VAC_SCH_HDR WHERE PATIENT_ID=? AND VACC_CATEG_ID=?";
				pstmt = con.prepareStatement(sqlQuery);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,vacc_categ_id);
				rs = pstmt.executeQuery();
				if (!rs.next())
				{
					if (rs != null)rs.close();
					if (pstmt != null)pstmt.close();

				 //sqlQuery ="INSERT INTO CA_IM_PAT_VAC_SCH_HDR ( VAC_SCH_REF, PATIENT_ID, VACC_CATEG_ID, INITIATING_ENCOUNTER_ID, INITIATING_FACILITY_ID, SCHEDULED_USER_ID, SCH_CREATED_DATE, SCH_STATUS, ADDED_BY_ID, ADDED_DATE,ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE,MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES ( CA_IM_PAT_VAC_SCH_HDR_SEQ.NEXTVAL,?,?,?,?,?,to_date(SYSDATE,'DD/MM/YYYY HH24:MI'),?,?,sysdate,?,?,?,sysdate,?,? )"; //41654
					sqlQuery ="INSERT INTO CA_IM_PAT_VAC_SCH_HDR ( VAC_SCH_REF, PATIENT_ID, VACC_CATEG_ID, INITIATING_ENCOUNTER_ID, INITIATING_FACILITY_ID, SCHEDULED_USER_ID, SCH_CREATED_DATE, SCH_STATUS, ADDED_BY_ID, ADDED_DATE,ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE,MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES ( CA_IM_PAT_VAC_SCH_HDR_SEQ.NEXTVAL,?,?,?,?,?,sysdate,?,?,sysdate,?,?,?,sysdate,?,? )";  // 41654   Adhoc SCH_CREATED_DATE was wrong formate

					pstmt = con.prepareStatement(sqlQuery);
					pstmt.setString(1,patient_id);
					pstmt.setString(2,vacc_categ_id);
					pstmt.setString(3,encounter_id);
					pstmt.setString(4,facility_id);
					pstmt.setString(5,scheduled_user_id);
					pstmt.setString(6,"A");
					pstmt.setString(7,login_user_id);
					pstmt.setString(8,client_ip_address);
					pstmt.setString(9,facility_id);
					pstmt.setString(10,login_user_id);
					pstmt.setString(11,client_ip_address);
					pstmt.setString(12,facility_id);

					result = pstmt.executeUpdate();
					if(pstmt != null) pstmt.close();
					if (result > 0)
					{
						retVal = "TRANS_SUCCESS";
						con.commit();
					}


				}
				if (rs != null)rs.close();
				if (pstmt != null)pstmt.close();
				return retVal;
			}
			catch (Exception e)
			{
				try
				{
					retVal = "TRANS_FAILED";
					con.rollback();
				}
				catch (Exception ee)
				{
					ee.printStackTrace();
				}
				e.printStackTrace();
			}finally {

				try
				{
					if(con != null)con.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}

		}
		return retVal;
	}

	public String setLinkForRXVaccine(Map paramMap)
	{

		Connection con = null;
		CallableStatement cst = null;
		String result = "TRANS_FAILED";
		try
		{
			String vac_sch_ref = (String)paramMap.get("VAC_SCH_REF");
			String vaccine_id = (String)paramMap.get("VACCINE_ID");
			String dose_no = (String)paramMap.get("DOSE_NO");
			String new_dose_no = (String)paramMap.get("NEW_DOSE_NO");
			String new_vaccine_id = (String)paramMap.get("NEW_VACCINE_ID");
			String new_vac_sch_ref = (String)paramMap.get("NEW_VAC_SCH_REF");
			String updProcLknVaccSch ="call CA_IM_UPD_LINK_VACC_SCH(?,?,?,?,?,?,?)";

			con = ConnectionManager.getConnection();
			cst = con.prepareCall("{"+updProcLknVaccSch+"}");
			cst.clearParameters();
			cst.setString(1, vac_sch_ref);
			cst.setString(2, vaccine_id);
			cst.setString(3, dose_no);
			cst.setString(4, new_vac_sch_ref);
			cst.setString(5, new_vaccine_id);
			cst.setString(6, new_dose_no);
			cst.registerOutParameter(7,Types.VARCHAR) ;
			cst.execute();
			result = cst.getString(7)==null?"TRANS_FAILED":cst.getString(7);
			if(cst != null)
			{
				cst.close();
			}
			con.commit();
		}
		catch (Exception e)
		{
			try
			{
				if (con != null)
				{
					con.rollback();
				}
			}
			catch (Exception ee )
			{
				ee.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (con != null)
				{
					con.close();
				}
			}
			catch (Exception e )
			{
				e.printStackTrace();
			}

		}
		return 	result;

	}

public Map<String,List<String>> getBMI(String patient_id,String facility_id)
{
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Map<String,List<String>> bmiMap = null;
	List<String> bmiList = null;
	try
	{
		bmiMap = new HashMap<String,List<String>>();

		String sqlQuery = "SELECT  distinct d.discr_msr_id, d.discr_msr_result_num, d.discr_msr_result_num_uom,TO_CHAR (d.test_observ_dt_tm, 'dd/mm/yyyy') test_observ_dt_tm FROM ca_encntr_discr_msr d WHERE d.facility_id = ? AND d.discr_msr_id IN ('HEIGHT', 'WEIGHT') AND d.patient_id = ? AND d.discr_msr_result_num_uom IS NOT NULL AND (d.discr_msr_id, d.TEST_OBSERV_DT_TM) IN (select discr_msr_id,max(TEST_OBSERV_DT_TM) from ca_encntr_discr_msr  WHERE facility_id = ? AND discr_msr_id IN ('HEIGHT', 'WEIGHT') AND patient_id = ? AND discr_msr_result_num_uom IS NOT NULL group by discr_msr_id)";

		con = ConnectionManager.getConnection();
		pstmt = con.prepareStatement(sqlQuery);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,patient_id);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,patient_id);

		String testDate = "";

		rs = pstmt.executeQuery();
		while (rs.next())
		{
			bmiList = new ArrayList<String>();
			bmiList.add(rs.getString("DISCR_MSR_RESULT_NUM")==null?"":rs.getString("DISCR_MSR_RESULT_NUM"));
			bmiList.add(rs.getString("DISCR_MSR_RESULT_NUM_UOM")==null?"":rs.getString("DISCR_MSR_RESULT_NUM_UOM"));
			testDate = rs.getString("TEST_OBSERV_DT_TM")==null?"":rs.getString("TEST_OBSERV_DT_TM");
			bmiList.add(testDate);
			bmiMap.put(rs.getString("DISCR_MSR_ID").toUpperCase(),bmiList);
		}
		if(rs != null)rs.close();
		if(pstmt != null)pstmt.close();



		List<String> chcHeightLst = bmiMap.get("HEIGHT");
		List<String> chcWeightLst = bmiMap.get("WEIGHT");
		if ((chcHeightLst == null )  || (chcWeightLst == null ) )
		{
			bmiMap = null;
			bmiMap = new HashMap<String,List<String>>();
			sqlQuery = "SELECT HEIGHT, HEIGHT_UOM, WEIGHT, WEIGHT_UOM, TO_CHAR(ADDED_DATE,'DD/MM/YYYY HH24:MI') ADDED_DATE_STR FROM  PH_PATIENT_DRUG_PROFILE WHERE PATIENT_ID=? AND ADDED_DATE=(SELECT MAX(ADDED_DATE) FROM  PH_PATIENT_DRUG_PROFILE WHERE PATIENT_ID=? AND HEIGHT IS NOT NULL) AND ROWNUM =1";
			pstmt = con.prepareStatement(sqlQuery);
			pstmt.setString(1, patient_id);
			pstmt.setString(2, patient_id);
			rs = pstmt.executeQuery();
			if (rs.next())
			{
				bmiList = new ArrayList<String>();
				bmiList.add(rs.getString("HEIGHT")==null?"":rs.getString("HEIGHT"));
				bmiList.add(rs.getString("HEIGHT_UOM")==null?"":rs.getString("HEIGHT_UOM"));
				bmiList.add(rs.getString("ADDED_DATE_STR")==null?"":rs.getString("ADDED_DATE_STR"));
				bmiMap.put("HEIGHT",bmiList);

				bmiList = new ArrayList<String>();
				bmiList.add(rs.getString("WEIGHT")==null?"":rs.getString("WEIGHT"));
				bmiList.add(rs.getString("WEIGHT_UOM")==null?"":rs.getString("WEIGHT_UOM"));
				bmiList.add(rs.getString("ADDED_DATE_STR")==null?"":rs.getString("ADDED_DATE_STR"));
				bmiMap.put("WEIGHT",bmiList);

			}
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();

		}
		else
		{

			sqlQuery = "SELECT HEIGHT, HEIGHT_UOM, WEIGHT, WEIGHT_UOM, TO_CHAR(ADDED_DATE,'DD/MM/YYYY') ADDED_DATE_STR FROM  PH_PATIENT_DRUG_PROFILE WHERE PATIENT_ID=? AND ADDED_DATE=(SELECT MAX(ADDED_DATE) FROM  PH_PATIENT_DRUG_PROFILE WHERE PATIENT_ID=? AND HEIGHT IS NOT NULL) AND ROWNUM = 1 AND ADDED_DATE > TO_DATE(? ,'dd/mm/yyyy') ";
			pstmt = con.prepareStatement(sqlQuery);
			pstmt.setString(1, patient_id);
			pstmt.setString(2, patient_id);
			pstmt.setString(3, testDate);
			rs = pstmt.executeQuery();
			if (rs.next())
			{
				bmiMap = null;
				bmiMap = new HashMap<String,List<String>>();
				bmiList = new ArrayList<String>();
				bmiList.add(rs.getString("HEIGHT")==null?"":rs.getString("HEIGHT"));
				bmiList.add(rs.getString("HEIGHT_UOM")==null?"":rs.getString("HEIGHT_UOM"));
				bmiList.add(rs.getString("ADDED_DATE_STR")==null?"":rs.getString("ADDED_DATE_STR"));
				bmiMap.put("HEIGHT",bmiList);

				bmiList = new ArrayList<String>();
				bmiList.add(rs.getString("WEIGHT")==null?"":rs.getString("WEIGHT"));
				bmiList.add(rs.getString("WEIGHT_UOM")==null?"":rs.getString("WEIGHT_UOM"));
				bmiList.add(rs.getString("ADDED_DATE_STR")==null?"":rs.getString("ADDED_DATE_STR"));
				bmiMap.put("WEIGHT",bmiList);

			}
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();


		}
		return bmiMap;
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}finally{
		try
		{
			if (con != null)
			{
				con.close();
			}
		}
		catch (Exception e )
		{
			e.printStackTrace();
		}
	}


return null;
}
}
