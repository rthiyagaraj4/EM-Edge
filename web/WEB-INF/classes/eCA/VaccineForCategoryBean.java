/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA;
import java.sql.*;
import java.io.*;
//import javax.servlet.*;
//import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import java.text.*;
//import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
public class VaccineForCategoryBean  implements java.io.Serializable
 {
	//Connection con;
	//PreparedStatement ps;
	//ResultSet rs;
	String finalString;
	int descLength;
	ArrayList retArray = new ArrayList();
	ArrayList list = new ArrayList();
	ArrayList retArray1 = new ArrayList();
	ArrayList retArray2 = new ArrayList();
	ArrayList indexList = new ArrayList();
	private Map<String, ArrayList<Map<String, String>>> vaccineCategSchMap = null;
	private CommonCollectionUtils<String, Map<String, String>> selectedVaccineLst = null;
	private CommonCollectionUtils<String, String> vaccineList  = null;
	private Map<String, String> doseMap = null;
	private Map<String, String> dlftSiteMap = null;
	private Map<String, String> chkPrevAdminMap = null;
	private Map<String, String> chkPrevDaysMap = null;
	private Map<String, String> chkPrevActionMap = null;

	public  VaccineForCategoryBean()
	{
		vaccineCategSchMap = new HashMap<String, ArrayList<Map<String, String>>>();
		selectedVaccineLst = new CommonCollectionUtils<String, Map<String,String>>();
		vaccineList = new CommonCollectionUtils<String, String>();
		 doseMap = new HashMap<String, String>();
		 dlftSiteMap = new HashMap<String, String>();
		 chkPrevAdminMap = new HashMap<String, String>();
		 chkPrevDaysMap = new HashMap<String, String>();
		 chkPrevActionMap = new HashMap<String, String>();
	}

	public void setDoseNo(String vaccID, String doseNo)
	{
		doseMap.put(vaccID, doseNo);
	}

	public String getVaccineDose(String vaccID)
	{
		return doseMap.get(vaccID);
	}

	public void setDLFTSite(String vaccID, String siteID)
	{
		dlftSiteMap.put(vaccID, siteID);
	}

	public String getVaccineDLFTSite(String vaccID)
	{
		return dlftSiteMap.get(vaccID);
	}

	public void setChkPrevAdmin(String vaccID, String prevAdminYN)
	{
		chkPrevAdminMap.put(vaccID, prevAdminYN);
	}

	public String getVaccineChkPrevAdmin(String vaccID)
	{
		return chkPrevAdminMap.get(vaccID);
	}

	public void setChkPrevDays(String vaccID, String prevDays)
	{
		chkPrevDaysMap.put(vaccID, prevDays);
	}

	public String getVaccineChkPrevDays(String vaccID)
	{
		return chkPrevDaysMap.get(vaccID);
	}


	public void setChkPrevAction(String vaccID, String prevAction)
	{
		chkPrevActionMap.put(vaccID, prevAction);
	}

	public String getVaccineChkPrevAction(String vaccID)
	{
		return chkPrevActionMap.get(vaccID);
	}






/**
*	deleteRow	-	will be called when a row has to be deleted from the Table
*	@param	remove_value - this is String
*	@param	connection - this is Connection
*	@param	categoryId - this is String
*
*/
	public void deleteRow(String remove_value,Connection connection,String categoryId,Properties p)
	{
		PreparedStatement ps,ps1;
		try{
			ps = connection.prepareStatement("delete from CA_IM_VAC_FOR_CATEG where VACC_CATEG_ID =? and VACCINE_ID = ?");
			ps.setString (1,categoryId);
			ps.setString (2,remove_value);
			ps.executeUpdate();

			ps1 = connection.prepareStatement("delete from CA_IM_VAC_SCH_FOR_CATEG where VACC_CATEG_ID =? and VACCINE_ID = ?");
			ps1.setString (1,categoryId);
			ps1.setString (2,remove_value);
			ps1.executeUpdate();

			if(ps != null )ps.close();
			if(ps1 != null )ps1.close();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		finally
		{
			//if(connection != null) ConnectionManager.returnConnection(connection,p);
		}

	}
/**
*	getQueryVaccineForCategory	-	will be called to display Six Records at a time from Database in a table 											Format in the JSP
*	@param	categoryId - this is String
*	@param	connection - this is Connection
*	@param	searchText - this is String
*	@param	start - this is int
*	@param	end - this is int
*/
	// public void getQueryVaccineForCategory(String categoryId,String searchText,Connection connection,int start,int end)
	public CommonCollectionUtils<String, String> getVaccineList(String searchText,String vacc_categ_id)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		//String sql = "SELECT a.short_desc description, a.vaccine_id VACCINE_ID FROM ca_im_vaccine a WHERE UPPER (a.short_desc) LIKE UPPER (?) AND a.eff_status = 'E' ORDER BY 1";

		String sql = "SELECT   a.short_desc description, a.vaccine_id vaccine_id, a.adhoc_yn FROM ca_im_vaccine a WHERE UPPER (a.short_desc) LIKE UPPER (?) AND a.eff_status = 'E' and a.ADHOC_YN LIKE ( SELECT case when b.ADHOC_YN = 'Y' THEN 'Y' ELSE '%' END from CA_IM_VAC_CATEG b where b.VACC_CATEG_ID = ?) ORDER BY 1";

		CommonCollectionUtils<String, String> vaccList = new CommonCollectionUtils<String, String>();

		/*String sql = "SELECT A.SHORT_DESC description, A.VACCINE_ID,B.ORDER_SRL_NO seq_num, B.MANDATORY_YN mandatory, B.NO_OF_DOSE , B.DEFAULT_SITE_ID, B.CHECK_PREV_ADM_YN, B.PREV_CHECK_DAYS, B.PREV_CHECK_ACTION,decode(B.ORDER_SRL_NO,null,'N','Y') flag from CA_IM_VACCINE A, CA_IM_VAC_FOR_CATEG B where B.VACC_CATEG_ID(+) =? and A.VACCINE_ID = B.VACCINE_ID(+) and upper(A.SHORT_DESC) like upper(?) and A.EFF_STATUS='E' ORDER BY 1";

		String sql1 = "SELECT FREQ_DURATION, FREQ_DURATION_TYPE from CA_IM_VAC_SCH_FOR_CATEG where VACC_CATEG_ID =? AND  VACCINE_ID = ? ";

		String sql2 = "SELECT count(*) total from CA_IM_VAC_SCH_FOR_CATEG where VACC_CATEG_ID =? AND  VACCINE_ID = ? ";*/



		try{
				con =  ConnectionManager.getConnection();

				ps = con.prepareStatement(sql);
				ps.setString(1, searchText);
				ps.setString(2, vacc_categ_id);
				rs = ps.executeQuery();
				String vaccId = "";
				while(rs.next())
				{
					vaccId = rs.getString("VACCINE_ID")==null ? "" :rs.getString("VACCINE_ID");
					if (vaccId != null && !vaccId.equals("") && !vaccList.containsKey(vaccId))
					{
						vaccList.add(vaccId, rs.getString("description")==null ? "" : rs.getString("description"));
					}

				}
				if(rs != null) rs.close();
				if(ps != null)ps.close();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
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
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return vaccList.size()>0?vaccList:null;
	}
/**
*	getMaxRecord	-	will be called to get the total Number of Records from the database based upon 								Criteria matching
*	@param	categoryId - this is String
*	@param	connection - this is Connection
*	@param	searchText - this is String
*/
	public int getMaxRecord(String categoryId,String searchText,Connection connection)
	{
		int total=0;
		PreparedStatement ps;
		ResultSet rs;

		try{
		//ps = connection.prepareStatement("select count(*) total from am_discr_msr a, ca_chart_section b where a.DISCR_MSR_ID = b.PANEL_ID(+) and RESULT_TYPE in ('G') and CHART_ID(+) = ? and upper(a.SHORT_DESC) like upper(?) and a.eff_status='E'");
		ps = connection.prepareStatement("select count(*) total from CA_IM_VACCINE where upper(SHORT_DESC) like upper(?) and EFF_STATUS='E'");

	//	ps.setString(1,categoryId);
		ps.setString(1,searchText);
		rs = ps.executeQuery();
		while(rs.next())
		{
			total = rs.getInt("total");
		}
		if(rs != null) rs.close();
		if(ps != null)ps.close();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}

		return total;
	}
/**
*	getQueryVaccineForCategory	-
*	@param	categoryId - this is String
*/
	public void getQueryVaccineForCategory(String categoryId)
	{

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT A.SHORT_DESC description, B.VACCINE_ID,B.ORDER_SRL_NO seq_num, B.MANDATORY_YN mandatory, B.NO_OF_DOSE , B.DEFAULT_SITE_ID, B.CHECK_PREV_ADM_YN, B.PREV_CHECK_DAYS, B.PREV_CHECK_ACTION,decode(B.ORDER_SRL_NO,null,'N','Y') flag from CA_IM_VACCINE A, CA_IM_VAC_FOR_CATEG B where B.VACC_CATEG_ID =? AND A.VACCINE_ID = B.VACCINE_ID and A.EFF_STATUS='E' ORDER BY B.ORDER_SRL_NO";

		try{
				con =  ConnectionManager.getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(1,categoryId);
				rs = ps.executeQuery();
				int i = 0;
				Hashtable schVaccMap = new Hashtable();
				String vaccId = "";

				while(rs.next())
				{
					schVaccMap.put("vaccineDesc"+i, rs.getString("description")==null ? "" : rs.getString("description"));
					schVaccMap.put("vaccineId"+i, rs.getString("VACCINE_ID")==null ? "" :rs.getString("VACCINE_ID"));
					schVaccMap.put("orderSqeNo"+i, rs.getString("seq_num")==null ? "" :rs.getString("seq_num"));
					schVaccMap.put("noDoeses"+i, rs.getString("NO_OF_DOSE")==null ? "" :rs.getString("NO_OF_DOSE"));
					schVaccMap.put("defaultSite"+i, rs.getString("DEFAULT_SITE_ID")==null ? "" :rs.getString("DEFAULT_SITE_ID"));
					schVaccMap.put("Mandatory"+i, rs.getString("mandatory")==null ? "" :rs.getString("mandatory"));
					schVaccMap.put("checkPrevAdministered"+i, rs.getString("CHECK_PREV_ADM_YN")==null ? "" :rs.getString("CHECK_PREV_ADM_YN"));
					schVaccMap.put("checkPrevDays"+i, rs.getString("PREV_CHECK_DAYS")==null ? "" :rs.getString("PREV_CHECK_DAYS"));
					schVaccMap.put("checkPrevAction"+i, rs.getString("PREV_CHECK_ACTION")==null ? "" :rs.getString("PREV_CHECK_ACTION"));
					schVaccMap.put("flag"+i, rs.getString("flag"));
					vaccId = rs.getString("VACCINE_ID")==null ? "" :rs.getString("VACCINE_ID");
					setVaccine(vaccId, rs.getString("description")==null ? "" : rs.getString("description"));
					getQueryVaccineSchedule(categoryId,vaccId,"0");
					i++;
				}
				
				if (rs != null)
				{
					rs.close();
				}
				if (ps != null)
				{
					ps.close();
				}
				if (schVaccMap.size() > 0)
				{
					setSelectedVaccineList(schVaccMap, i);
				}

		}
		catch(Exception ee)
		{
			
			ee.printStackTrace();
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
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}


	}

/**
*	returnConnection	-	used to Close Connections and Statement Objects
	public void  returnConnection()
	{
		Connection con;
		PreparedStatement ps;
		ResultSet rs;

		con=conection;
		this.ps=ps;
		this.rs=rs;

		try{
				if(rs != null) rs.close();
				if(ps != null)ps.close();
				if(con != null)ConnectionManager.returnConnection(con);
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
	*/

/**
*	getConcatenatedString	-	returns a Contenated String
*/
	public String getConcatenatedString()
	{
		return this.finalString;
	}
	/**
*	setConcatenatedString	-	sets a Contenated String to Final String of Instance Variable
*/
	public void setConcatenatedString(String finalString)
	{
		this.finalString = finalString;
	}
/**
*	setLength	-	sets the length of the Concatenated String
*/
	public void setLength(int descLength)
	{
		this.descLength = descLength;

	}
/**
*	getLength	-	returns the length of the Concatenated String
*/
	public int  getLength()
	{
		return this.descLength;
	}

	public String setFinalString(ArrayList list)
	 {
		ArrayList arrCode = (ArrayList)list.get(2);
		ArrayList arrDesc = (ArrayList)list.get(0);
		ArrayList arrSeqNum = (ArrayList)list.get(1);
		ArrayList arrFlag = (ArrayList)list.get(3);
		ArrayList numDosesList = (ArrayList)list.get(4);
		ArrayList defaultSiteList = (ArrayList)list.get(5);
		ArrayList mandatoryList = (ArrayList)list.get(6);
		ArrayList chkPrvAdmList = (ArrayList)list.get(7);
		ArrayList chkPrvDaysList = (ArrayList)list.get(8);
		ArrayList chkPrvActionList = (ArrayList)list.get(9);
		ArrayList freqDurationList = (ArrayList)list.get(10);
		ArrayList freqDurTypeList = (ArrayList)list.get(11);


		String code = "";
		String desc = "";
		String ordSeq = "";
		String flag = "";
		String mandatory = "";
		String numDoses = "";
		String defaultSite = "";
		String chkPrvAdm = "";
		String chkPrvDays = "";
		String chkPrvAction = "";

		String freqDuration = "";
		String freqDurType = "";

		finalString  = "";
		for(int i=0;i<arrCode.size();i++)
		{
			code = 	(String) arrCode.get(i);
			desc = 	(String) arrDesc.get(i);
			ordSeq = (String) arrSeqNum.get(i);
			flag = 	(String) arrFlag.get(i);
			numDoses = (String)numDosesList.get(i);
			defaultSite = (String)defaultSiteList.get(i);
			mandatory = (String)mandatoryList.get(i);
			chkPrvAdm = (String)chkPrvAdmList.get(i);
			chkPrvDays = (String)chkPrvDaysList.get(i);
			chkPrvAction = (String)chkPrvActionList.get(i);
			freqDuration = (String)freqDurationList.get(i);
			freqDurType =	(String)freqDurTypeList.get(i);

			if (mandatory.equals(""))
			{
				mandatory = "N";
			}
			if (numDoses.equals(""))
			{
				numDoses = "1";
			}
			if (defaultSite.equals(""))
			{
				defaultSite = "Q";
			}
			if (chkPrvAdm.equals(""))
			{
				chkPrvAdm = "N";
			}

			if (chkPrvDays.equals(""))
			{
				chkPrvDays = "Q";
			}
			if (chkPrvAction.equals(""))
			{
				chkPrvAction = "Q";
			}
			if (freqDuration.equals(""))
			{
				freqDuration = "Q";
			}
			if (freqDurType.equals(""))
			{
				freqDurType = "Q";
			}

			if (flag.equals("Y"))
			{
				if(finalString.equals(""))
				{
					finalString = desc + "||" + code + "||" +  ordSeq + "||" +  flag + "||" +numDoses+ "||" +defaultSite+ "||"+mandatory+ "||" +chkPrvAdm+ "||" +chkPrvDays+ "||" +chkPrvAction+ "||" +freqDuration+ "||" +freqDurType;
				}
				else
				{
					finalString = finalString + "~" + desc + "||" + code + "||" +  ordSeq + "||" +  flag + "||" +numDoses+ "||" +defaultSite+ "||" +mandatory+ "||" +chkPrvAdm+ "||" +chkPrvDays+ "||" +chkPrvAction+ "||" +freqDuration+ "||" +freqDurType;
				}
			}

	 }
			return finalString;
	}


	public void setArrayList(ArrayList list)
	 {
		 retArray1 = list;
	 }

	public ArrayList retrieveArrayList()
	{
		return retArray1;
	}

	public void clearArray(ArrayList retArray)
	 {
		retArray = null;
	 }

	 public void getQueryVaccineSchedule(String categoryId, String vaccineId, String rowCount)
	 {
		Connection con = null;
		PreparedStatement ps,ps1,ps2;
		ResultSet rs,rs1;

		int noOfRows = Integer.parseInt(rowCount);
		int noOfDoses = 0;
		/*
			added by kishore kumar N on 04/Nov/2009 for CRF 0691.1,

				added DUE_BEFORE, DUE_BEFORE_TYPE, ELAPSED_AFTER, ELAPSED_AFTER_TYPE APPL_AGE_YEARS, APPL_AGE_MONTHS, APPL_AGE_DAYS
				to the select query.
		*/
		String sql = "SELECT DOSE_NO,FREQ_DURATION,FREQ_DURATION_TYPE,MANDATORY_YN,DEFUALT_OPTION, DUE_BEFORE, DUE_BEFORE_TYPE, ELAPSED_AFTER, ELAPSED_AFTER_TYPE,APPL_AGE_YEARS,APPL_AGE_MONTHS,APPL_AGE_DAYS    from CA_IM_VAC_SCH_FOR_CATEG where VACC_CATEG_ID =? and VACCINE_ID = ? ORDER BY 1";

		String sql2 = "Delete from CA_IM_VAC_SCH_FOR_CATEG where VACC_CATEG_ID =? AND  VACCINE_ID = ?";
		String sql1 = "Select count(*) total from CA_IM_VAC_SCH_FOR_CATEG where VACC_CATEG_ID =? AND  VACCINE_ID = ?";

		try{

				con =  ConnectionManager.getConnection();
				ps1 = con.prepareStatement(sql1);
				ps1.setString(1,categoryId);
				ps1.setString(2,vaccineId);
				rs1 = ps1.executeQuery();

				while (rs1.next())
				{
					noOfDoses = Integer.parseInt(rs1.getString("total"));
				}
				if (rs1 != null) rs1.close();
				if (ps1 != null) ps1.close();

				ps2 = con.prepareStatement(sql2);
				ps2.setString(1,categoryId);
				ps2.setString(2,vaccineId);


				if (noOfDoses == 1 && noOfRows > 1)
				{
					ps2.execute();
				}

				ps = con.prepareStatement(sql);
				ps.setString(1,categoryId);
				ps.setString(2,vaccineId);
				rs = ps.executeQuery();

				Hashtable scheduleMap = new Hashtable();
				int i = 0;

				while(rs.next())
				{

					scheduleMap.put("Yrs"+i, rs.getString("APPL_AGE_YEARS")==null ? "" :rs.getString("APPL_AGE_YEARS"));
					scheduleMap.put("Months"+i,rs.getString("APPL_AGE_MONTHS")==null ? "" :rs.getString("APPL_AGE_MONTHS"));
					scheduleMap.put("Days"+i, rs.getString("APPL_AGE_DAYS")==null ? "" :rs.getString("APPL_AGE_DAYS"));
					scheduleMap.put("mandatory"+i, rs.getString("MANDATORY_YN")==null ? "" :rs.getString("MANDATORY_YN"));
					scheduleMap.put("defaultC"+i, rs.getString("DEFUALT_OPTION")==null ? "" :rs.getString("DEFUALT_OPTION"));
					scheduleMap.put("duration"+i,rs.getString("FREQ_DURATION")==null ? "" :rs.getString("FREQ_DURATION"));
					scheduleMap.put("durationType"+i,rs.getString("FREQ_DURATION_TYPE")==null ? "" :rs.getString("FREQ_DURATION_TYPE"));
					scheduleMap.put("Due"+i, rs.getString("DUE_BEFORE")==null ? "" :rs.getString("DUE_BEFORE"));
					scheduleMap.put("elapsed"+i, rs.getString("ELAPSED_AFTER")==null ? "" :rs.getString("ELAPSED_AFTER"));
					scheduleMap.put("elapsedType"+i,rs.getString("ELAPSED_AFTER_TYPE")==null ? "" :rs.getString("ELAPSED_AFTER_TYPE"));
					scheduleMap.put("dueType"+i, rs.getString("DUE_BEFORE_TYPE")==null ? "" :rs.getString("DUE_BEFORE_TYPE"));

					i++;
				}
				if(rs != null) rs.close();
				if(ps2 != null) ps2.close();
				if(ps != null) ps.close();
				if (scheduleMap.size() > 0)
				{
					setVaccnieSchedule(vaccineId, i, scheduleMap,"N" ,"","N", "");
				}

		}
		catch(Exception ee)
		{
			
			ee.printStackTrace();
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
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public boolean isAdhocAgeSpecific(String vaccCategoryId, Connection con)
	{
		try
		{
			String sql = "select age_specific_yn from ca_im_vac_categ where vacc_categ_id = ? ";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, vaccCategoryId);
			ResultSet rs = pst.executeQuery();
			if (rs.next())
			{
				String adhocAgeSpec = rs.getString(1) == null?"N":rs.getString(1);

				if(adhocAgeSpec.equals("Y"))
				{
					return true;
				}
			}

			if (rs != null)
			{
				rs.close();
			}

			if (pst != null)
			{
				pst.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public String setVaccnieSchedule(String vaccineId , int doseCnt, Hashtable vaccSchMap, String duplicateYN, String duplicateDays, String isAdhocAgeSpec, String categoryId)
	{

		if(vaccSchMap != null)
		{
			ArrayList<Map<String, String>> scheduleLst = new ArrayList<Map<String,String>>();
			Map<String, String> scheduleMap = null;
			String yrs = "";
			String months = "";
			String days = "";
			Connection con = null;
			PreparedStatement pstmt = null;
			String retVal = "";

			try
			{
				con =  ConnectionManager.getConnection();
				String strSql = "SELECT 1 FROM CA_IM_VAC_SCH_FOR_CATEG IA, CA_IM_VAC_CATEG IC, CA_IM_VACCINE IC WHERE IC.VACC_CATEG_ID  = IA.VACC_CATEG_ID AND IC.VACCINE_ID = IA.VACCINE_ID AND IC.AGE_SPECIFIC_YN='Y' AND IA.VACCINE_ID = ? AND IA.VACC_CATEG_ID NOT IN  (?) AND ABS (  ADD_MONTHS (TRUNC (SYSDATE) + NVL (?, 0), NVL (?, 0) * 12 + NVL (?, 0) ) - ADD_MONTHS (TRUNC (SYSDATE) + NVL (IA.APPL_AGE_DAYS, 0), NVL (IA.APPL_AGE_YEARS, 0) * 12 + NVL (IA.APPL_AGE_MONTHS, 0) )) < NVL (IC.DUPL_CHECK_DAYS, 0) ";

				
				pstmt = con.prepareStatement(strSql);
				pstmt.setString(1, vaccineId);
				pstmt.setString(2, categoryId);
				for(int i=0; i<doseCnt; i++)
				{
					scheduleMap = new HashMap<String, String>();
					yrs = (String)vaccSchMap.get("Yrs"+i);
					months = (String)vaccSchMap.get("Months"+i);
					days = (String)vaccSchMap.get("Days"+i);
					if(duplicateYN != null && duplicateYN.equals("Y")  && isAdhocAgeSpec != null && isAdhocAgeSpec.equals("Y"))
					{
						if(chkDuplicateVaccinesForAgeSpecific(pstmt, yrs, months, days))
						{
							retVal = "DUPLICATE_CHECK";
						}
					}
					scheduleMap.put("Yrs", yrs);
					scheduleMap.put("Months", months);
					scheduleMap.put("Days", days);
					scheduleMap.put("mandatory", (String)vaccSchMap.get("mandatory"+i));
					scheduleMap.put("defaultC", (String)vaccSchMap.get("defaultC"+i));
					scheduleMap.put("duration", (String)vaccSchMap.get("duration"+i));
					scheduleMap.put("durationType", (String)vaccSchMap.get("durationType"+i));
					scheduleMap.put("Due", (String)vaccSchMap.get("Due"+i));
					scheduleMap.put("elapsed", (String)vaccSchMap.get("elapsed"+i));
					scheduleMap.put("elapsedType", (String)vaccSchMap.get("elapsedType"+i));
					scheduleMap.put("dueType", (String)vaccSchMap.get("dueType"+i));

					if(scheduleMap.size() > 0)
					{
						scheduleLst.add(scheduleMap);
					}
				}
				if(scheduleLst.size() > 0)
				{
					vaccineCategSchMap.put(vaccineId, scheduleLst);
				}
				if (pstmt != null)pstmt.close();

			}
			catch (Exception e)
			{
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
				catch (Exception ee)
				{
					ee.printStackTrace();
				}
			}
			return retVal;
		}
		return "";
	}

	public Map<String, ArrayList<Map<String, String>>> getVaccineCategSchMap()
	{
		return vaccineCategSchMap;
	}

	public ArrayList<Map<String, String>> getVaccineCategSchList(String vaccineId)
	{
		if(vaccineCategSchMap.containsKey(vaccineId))
		{
			return vaccineCategSchMap.get(vaccineId)==null?null:vaccineCategSchMap.get(vaccineId);
		}
		return null;
	}

	public void clearVaccineScheduleMap()
	{
		vaccineCategSchMap.clear();
	}

	public void removeVaccineSchedule(String vaccineId)
	{
		if(vaccineCategSchMap.containsKey(vaccineId))
		{
			vaccineCategSchMap.remove(vaccineId);
		}
	}

	public List<String> checkAllSelectedVaccineAreScheduled(String locale)
	{
		List<String> schVaccineLst = getSelectedVaccineList().keyList();
		Set<String> seclectedVaccineSet = getVaccineCategSchMap().keySet();


		List<String> notSchVaccLst = new ArrayList<String>();

		if (seclectedVaccineSet  != null && seclectedVaccineSet.size() > 0 && schVaccineLst != null && schVaccineLst.size() > 0)
		{
			for(String vaccId : schVaccineLst)
			{
				if(!seclectedVaccineSet.contains(vaccId))
				{
					notSchVaccLst.add(vaccId);
				}
				else
				{
					int schDoseCnt =  -1;
					int noDoesCnt = -1;
					List<Map<String, String>> doseList = getVaccineCategSchMap().get(vaccId);
					if (doseList != null)
					{
						schDoseCnt = doseList.size();
					}

					 Map<String, String> schDoseMap = getSelectedVaccineList().get(vaccId);
					 String doseCnt = "";
					 if (schDoseMap != null)
					 {
						 doseCnt =schDoseMap.get("noDoeses")==null?"":schDoseMap.get("noDoeses");
						 doseCnt = doseCnt.equals("")?"0":doseCnt;
					 }
					 noDoesCnt = Integer.parseInt(doseCnt);

					 if( noDoesCnt != schDoseCnt)
					 {
						 notSchVaccLst.add(vaccId+" `~ [ "+(String)MessageManager.getMessage(locale, "DOSE_COUNT_NOT_MATCH","CA").get("message")+" ]");
					 }
				}
			}
		}
		else if (seclectedVaccineSet!= null && seclectedVaccineSet.size() > 0 && schVaccineLst != null && schVaccineLst.size() == 0)
		{
			for (String schVacc: seclectedVaccineSet)
			{
				notSchVaccLst.add(schVacc);
			}
		}
		else if (schVaccineLst!= null && schVaccineLst.size() > 0 && seclectedVaccineSet != null && seclectedVaccineSet.size() == 0)
		{
			for (String schVacc: schVaccineLst)
			{
				notSchVaccLst.add(schVacc);
			}
		}

		return notSchVaccLst.size() >0 ? notSchVaccLst :null;
	}

	public void setSelectedVaccineList(Hashtable vaccMap, int vaccineCnt)
	{
		Map<String, String> schVaccMap = null;
		String vaccId = "";
		for(int i = 0; i < vaccineCnt; i++)
		{
			schVaccMap = new HashMap<String, String>();
			vaccId = (String)vaccMap.get("vaccineId"+i);
			schVaccMap.put("vaccineId", vaccId);
			schVaccMap.put("orderSqeNo", (String)vaccMap.get("orderSqeNo"+i));
			schVaccMap.put("vaccineDesc", getVaccineList().get(vaccId));
			schVaccMap.put("noDoeses", (String)vaccMap.get("noDoeses"+i));
			schVaccMap.put("defaultSite", (String)vaccMap.get("defaultSite"+i));
			schVaccMap.put("Mandatory", (String)vaccMap.get("Mandatory"+i));
			schVaccMap.put("checkPrevAdministered", (String)vaccMap.get("checkPrevAdministered"+i));
			schVaccMap.put("checkPrevDays", (String)vaccMap.get("checkPrevDays"+i));
			schVaccMap.put("checkPrevAction", (String)vaccMap.get("checkPrevAction"+i));
			schVaccMap.put("flag"+i, (String)vaccMap.get("flag"+i)==null?"":(String)vaccMap.get("flag"+i));

			if (selectedVaccineLst.containsKey(vaccId.trim()))
			{
				//selectedVaccineLst.removeKey(vaccId.trim());
				selectedVaccineLst.replaceValue(vaccId.trim(), schVaccMap);
			}
			else
			{
				selectedVaccineLst.add(vaccId.trim(), schVaccMap);
			}
		}
	}

	public void removeSelectedVaccineList(String vaccineId)
	{
		if(selectedVaccineLst.containsKey(vaccineId))
		{
			selectedVaccineLst.removeKey(vaccineId);
		}
	}

	public CommonCollectionUtils<String, Map<String, String>> getSelectedVaccineList()
	{
		return selectedVaccineLst;
	}

	public void setSelectedVaccine(String vaccineId, String vaccDesc)
	{
		if(!vaccineList.containsKey(vaccineId))
		{
			vaccineList.add(vaccineId, vaccDesc);
			Map<String, String> schVaccMap =  new HashMap<String, String>();
			schVaccMap.put("vaccineId", "");
			schVaccMap.put("orderSqeNo", "");
			schVaccMap.put("vaccineDesc", "");
			schVaccMap.put("noDoeses", "");
			schVaccMap.put("defaultSite", "");
			schVaccMap.put("Mandatory", "");
			schVaccMap.put("checkPrevAdministered", "");
			schVaccMap.put("checkPrevDays", "");
			schVaccMap.put("checkPrevAction", "");
			schVaccMap.put("flag", "Y");
			selectedVaccineLst.add(vaccineId, schVaccMap);
		}
	}

	public CommonCollectionUtils<String, String> getScheduleVaccineList()
	{
		return vaccineList;
	}

	public void removeVaccineList(String vaccineId)
	{
		if(vaccineList.containsKey(vaccineId))
		{
			vaccineList.removeKey(vaccineId);
		}
	}

	public void setVaccine(String vaccineId, String vaccDesc)
	{

		if(vaccineId != null && !vaccineId.equals("") &&!vaccineList.containsKey(vaccineId))
		{
			vaccineList.add(vaccineId, vaccDesc);
		}
	}

	public CommonCollectionUtils<String, String> getVaccineList()
	{
		return vaccineList;
	}

	public void clearVaccineBean()
	{
		getScheduleVaccineList().clear();
		getSelectedVaccineList().clear();
		getVaccineCategSchMap().clear();
		doseMap.clear();
		dlftSiteMap.clear();
		chkPrevAdminMap.clear();
		chkPrevDaysMap.clear();
		chkPrevActionMap.clear();
	}

	public void insertOrUpdate(String categoryId, Properties properties, String facilityId)
	{
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement checkCategPst = null;
		PreparedStatement insertPst = null;
		PreparedStatement updatePst = null;
		PreparedStatement schInsPst = null;
		PreparedStatement schDelPst = null;
		String sqlInsert = "Insert into CA_IM_VAC_FOR_CATEG (VACC_CATEG_ID, VACCINE_ID, ORDER_SRL_NO,MANDATORY_YN,NO_OF_DOSE,DEFAULT_SITE_ID,CHECK_PREV_ADM_YN,PREV_CHECK_DAYS,PREV_CHECK_ACTION, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";

		String sqlUpdate = "update CA_IM_VAC_FOR_CATEG set  ORDER_SRL_NO=?, MANDATORY_YN=?, NO_OF_DOSE=?, DEFAULT_SITE_ID=?, CHECK_PREV_ADM_YN=?, PREV_CHECK_DAYS=?, PREV_CHECK_ACTION=?, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where VACC_CATEG_ID= ? and  VACCINE_ID =?";

		String sqlSelect = "select VACC_CATEG_ID, VACCINE_ID,ORDER_SRL_NO from CA_IM_VAC_FOR_CATEG where VACC_CATEG_ID=? and  VACCINE_ID=?";

		String sqlDuration1 = "Insert into CA_IM_VAC_SCH_FOR_CATEG (VACC_CATEG_ID, VACCINE_ID, DOSE_NO,FREQ_DURATION,FREQ_DURATION_TYPE,MANDATORY_YN,DEFUALT_OPTION,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID, DUE_BEFORE, DUE_BEFORE_TYPE, ELAPSED_AFTER, ELAPSED_AFTER_TYPE, APPL_AGE_YEARS, APPL_AGE_MONTHS, APPL_AGE_DAYS) values(?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?)";

		//String sqlUpdDuration1 = "UPDATE CA_IM_VAC_SCH_FOR_CATEG SET FREQ_DURATION=?,FREQ_DURATION_TYPE=?,MANDATORY_YN=?,  MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE VACC_CATEG_ID=? AND VACCINE_ID=? ";

		String sqlSelDuration1 = "SELECT COUNT(*) AS No_DOSES FROM CA_IM_VAC_SCH_FOR_CATEG WHERE VACC_CATEG_ID=? AND VACCINE_ID=? ";
		String sqlDelDuration1 = "DELETE FROM CA_IM_VAC_SCH_FOR_CATEG WHERE VACC_CATEG_ID=? AND VACCINE_ID=? ";

		try
		{
			String client_ip_addr =	properties.getProperty("client_ip_address");
			String addedId =  (properties.getProperty("login_user")==null)?"":properties.getProperty("login_user")  ;

			con =  ConnectionManager.getConnection();
			con.setAutoCommit(false);
			checkCategPst = con.prepareStatement(sqlSelect);
			updatePst = con.prepareStatement(sqlUpdate);
			insertPst = con.prepareStatement(sqlInsert);
			schInsPst = con.prepareStatement(sqlDuration1);
			schDelPst = con.prepareStatement(sqlDelDuration1);
			pst = con.prepareStatement(sqlSelDuration1);


			CommonCollectionUtils<String, Map<String, String>> selVaccineList = getSelectedVaccineList();

			if (selVaccineList != null)
			{
				List<String> vaccList = selVaccineList.keyList();

				if (vaccList != null)
				{
					for (String vaccId : vaccList)
					{
						Map<String, String> vaccMap = selVaccineList.get(vaccId);

						if (isVaccineForCategoryEixsts(checkCategPst, categoryId, vaccId))
						{
							updatePst.setString(1,vaccMap.get("orderSqeNo"));
							updatePst.setString(2,vaccMap.get("Mandatory"));
							updatePst.setString(3,vaccMap.get("noDoeses"));
							updatePst.setString(4,vaccMap.get("defaultSite"));
							updatePst.setString(5,vaccMap.get("checkPrevAdministered"));
							updatePst.setString(6,vaccMap.get("checkPrevDays"));
							updatePst.setString(7,vaccMap.get("checkPrevAction").equals("null") ? "" : vaccMap.get("checkPrevAction"));
							updatePst.setString(8,addedId);
							updatePst.setString(9,client_ip_addr);
							updatePst.setString(10,facilityId);
							updatePst.setString(11,categoryId);
							updatePst.setString(12,vaccId);
							updatePst.executeUpdate();
						}
						else
						{
							insertPst.setString(1, categoryId);
							insertPst.setString(2, vaccId);
							insertPst.setString(3, vaccMap.get("orderSqeNo"));
							insertPst.setString(4, vaccMap.get("Mandatory"));
							insertPst.setString(5, vaccMap.get("noDoeses"));
							insertPst.setString(6, vaccMap.get("defaultSite") );
							insertPst.setString(7, vaccMap.get("checkPrevAdministered"));
							insertPst.setString(8, vaccMap.get("checkPrevDays"));
							insertPst.setString(9, vaccMap.get("checkPrevAction").equals("null") ? "" : vaccMap.get("checkPrevAction"));
							insertPst.setString(10, addedId);
							insertPst.setString(11, client_ip_addr);
							insertPst.setString(12, facilityId);
							insertPst.setString(13, addedId);
							insertPst.setString(14, client_ip_addr);
							insertPst.setString(15, facilityId);
							insertPst.executeUpdate();
						}
					}
				}

			}

			Map<String, ArrayList<Map<String, String>>> scheduleVaccMap = getVaccineCategSchMap();
			if (scheduleVaccMap != null)
			{
				Set<String> vaccSet = scheduleVaccMap.keySet();

				if(vaccSet != null)
				{
					for (String vaccId : vaccSet)
					{
						if (isScheduleForVaccineEixsts(pst, categoryId, vaccId))
						{
							schDelPst.setString(1, categoryId);
							schDelPst.setString(2, vaccId);
							schDelPst.executeUpdate();
						}

						ArrayList<Map<String, String>> schList = scheduleVaccMap.get(vaccId);

						if(schList != null)
						{
							int cnt = 1;
							for(Map<String, String> schMap : schList)
							{
								schInsPst.setString(1, categoryId);
								schInsPst.setString(2, vaccId);
								schInsPst.setString(3, String.valueOf(cnt));
								schInsPst.setString(4, schMap.get("duration")==null?"O":schMap.get("duration"));
								schInsPst.setString(5, schMap.get("durationType")==null?"D":schMap.get("durationType"));
								schInsPst.setString(6, schMap.get("mandatory")==null?"N":schMap.get("mandatory"));
								schInsPst.setString(7, schMap.get("defaultC")==null?"":schMap.get("defaultC"));
								schInsPst.setString(8, addedId);
								schInsPst.setString(9, client_ip_addr);
								schInsPst.setString(10, facilityId);
								schInsPst.setString(11, addedId);
								schInsPst.setString(12, client_ip_addr);
								schInsPst.setString(13, facilityId);
								schInsPst.setString(14, schMap.get("Due")==null?"0":schMap.get("Due"));
								schInsPst.setString(15, schMap.get("dueType")==null?"D":schMap.get("dueType"));
								schInsPst.setString(16, schMap.get("elapsed")==null?"0":schMap.get("elapsed"));
								schInsPst.setString(17, schMap.get("elapsedType")==null?"D":schMap.get("elapsedType"));
								schInsPst.setString(18, schMap.get("Yrs")==null?"":schMap.get("Yrs"));
								schInsPst.setString(19, schMap.get("Months")==null?"":schMap.get("Months"));
								schInsPst.setString(20, schMap.get("Days")==null?"0":schMap.get("Days"));
								schInsPst.executeUpdate();
								cnt++;
							}
						}
					}
				}
			}
			if (checkCategPst != null)
			{
				checkCategPst.close();
			}
			if (updatePst != null)
			{
				updatePst.close();
			}
			if (insertPst != null)
			{
				insertPst.close();
			}
			if (schInsPst != null)
			{
				schInsPst.close();
			}
			if (schDelPst != null)
			{
				schDelPst.close();
			}
			if (pst != null)
			{
				pst.close();
			}
			con.commit();
			clearVaccineBean();

		}
		catch (Exception e)
		{
			e.printStackTrace();
			try
			{
				con.rollback();
			}
			catch (Exception ee)
			{
				ee.printStackTrace();
			}
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
			catch (Exception ee)
			{
				ee.printStackTrace();
			}
		}
	}

	private boolean isVaccineForCategoryEixsts(PreparedStatement pst, String categoryId, String vaccineId) throws Exception
	{
		pst.setString(1, categoryId);
		pst.setString(2, vaccineId);
		ResultSet rs = pst.executeQuery();

		if (rs.next())
		{

			return true;
		}

		if (rs != null)
		{
			rs.close();
		}

		return false;
	}

	private boolean isScheduleForVaccineEixsts(PreparedStatement pst, String categoryId, String vaccineId) throws Exception
	{
		pst.setString(1, categoryId);
		pst.setString(2, vaccineId);
		ResultSet rs = pst.executeQuery();
		if (rs.next())
		{
			return true;
		}

		if (rs != null)
		{
			rs.close();
		}
		return false;
	}

	public Map<String, String> getScheduleAge(String categoryId)
	{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try
		{
			String sql = "SELECT ia.age_unit, ia.min_age, ia.max_age  FROM "+
				" am_age_group ia, CA_IM_VAC_CATEG a WHERE ia.age_group_code = "+
				" a.age_group_code  and a.VACC_CATEG_ID = ? ";
			con =  ConnectionManager.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, categoryId);
			rs = pst.executeQuery();
			Map<String, String> scbAgeMap = new HashMap<String, String>();
			if(rs.next())
			{
				scbAgeMap.put("AgeUnit", rs.getString(1));
				scbAgeMap.put("MinAge", rs.getString(2));
				scbAgeMap.put("MaxAGe", rs.getString(3));
			}

			if (rs != null)
			{
				rs.close();
			}
			if (pst != null)
			{
				pst.close();
			}

			return scbAgeMap.size()>0?scbAgeMap : null;
		}
		catch (Exception e)
		{
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
			catch (Exception ee)
			{
				ee.printStackTrace();
			}
		}
		return null;
	}

	public void deleteVaccineFromSchedule(String categoryId, String vaccineId)
	{
		Connection con = null;
		PreparedStatement pst = null;
		try
		{
			String sql = "DELETE FROM CA_IM_VAC_FOR_CATEG WHERE VACC_CATEG_ID = ? AND VACCINE_ID =?";
			String sql1 = "DELETE FROM CA_IM_VAC_SCH_FOR_CATEG WHERE VACC_CATEG_ID=? AND  VACCINE_ID = ?";
			con =  ConnectionManager.getConnection();
			con.setAutoCommit(false);
			pst = con.prepareStatement(sql);
			pst.setString(1, categoryId);
			pst.setString(2, vaccineId);
			int cnt = pst.executeUpdate();
			cnt = cnt;
			if (pst != null) pst.close();

			pst = con.prepareStatement(sql1);
			pst.setString(1, categoryId);
			pst.setString(2, vaccineId);
			int cnt1 = pst.executeUpdate();
			cnt1 = cnt1;
			if (pst != null) pst.close();

			con.commit();

		}
		catch (Exception e)
		{
			try
			{
				con.rollback();
			}
			catch (Exception er)
			{
				er.printStackTrace();
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
			catch (Exception ee)
			{
				ee.printStackTrace();
			}
		}
	}

	public String getCategoryDesc(String categoryId, String locale)
	{
		String sql = "SELECT CA_GET_DESC.CA_IM_VAC_CATEG (?, ?, 2) VACC_CATEG_DESC FROM DUAL";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{

			con =  ConnectionManager.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, categoryId);
			pst.setString(2, locale);
			rs = pst.executeQuery();
			if(rs.next())
				return rs.getString("VACC_CATEG_DESC")==null?null:rs.getString("VACC_CATEG_DESC");

			if (rs != null)
			{
				rs.close();
			}
			if (pst != null)
			{
				pst.close();
			}

		}
		catch (Exception e)
		{
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
			catch (Exception ee)
			{
				ee.printStackTrace();
			}
		}
		return null;
	}

	public boolean isAdhocCategory(String categoryId)
	{
		String sql = "select ADHOC_YN  from CA_IM_VAC_CATEG where VACC_CATEG_ID = ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String isAdhoc = "";
		try
		{

			con =  ConnectionManager.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, categoryId);
			rs = pst.executeQuery();

			if(rs.next())
				isAdhoc = rs.getString("ADHOC_YN")==null?"N":rs.getString("ADHOC_YN");

			if (rs != null)
			{
				rs.close();
			}
			if (pst != null)
			{
				pst.close();
			}
		}
		catch (Exception e)
		{
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
			catch (Exception ee)
			{
				ee.printStackTrace();
			}
		}
		return isAdhoc.equals("Y")?true:false;
	}

	public Map<String,String> chkDuplicateVaccination(String patient_id,String vaccine_id,String dupl_check_days,String admin_date)
	{
		Connection con = null;
		CallableStatement cstmt = null;
		Map<String,String> resultMap = null;
		try
		{
			resultMap  = new HashMap<String,String>();
			con =  ConnectionManager.getConnection();
			String strSql = "call CA_IM_CHK_VACC_DUP(?,?,?,?,?,?,?)";
			cstmt = con.prepareCall("{"+strSql+"}");
			cstmt.clearParameters();
			cstmt.setString(1, patient_id);
			cstmt.setString(2, vaccine_id);
			cstmt.setString(3, dupl_check_days);
			cstmt.setString(4, admin_date);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.registerOutParameter(6, Types.DATE);
			cstmt.registerOutParameter(7, Types.VARCHAR);
			cstmt.execute();
			if (cstmt.getString(5)==null || cstmt.getString(6) =="")
			{
				resultMap.put("DUPL_CHECK_ACTION",cstmt.getString(5));
				resultMap.put("ADMINISTERED_DATE",cstmt.getString(6));
				resultMap.put("DUPL_CHECK_ACTION",cstmt.getString(7));
			}
			
			if(cstmt != null) cstmt.close();

			return resultMap;
		}
		catch (Exception e)
		{
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
			catch (Exception ee)
			{
				ee.printStackTrace();
			}
		}
		return null;
	}

	public boolean chkDuplicateVaccinesForAgeSpecific(PreparedStatement pst, String yrs, String months, String days) throws Exception
	{
		ResultSet rs = null;

		pst.setString(3, days);
		pst.setString(4, yrs);
		pst.setString(5, months);
		rs = pst.executeQuery();

		if (rs.next())
		{
			return true;
		}
		if (rs != null)rs.close();

		return false;
	}

	public Map<String, String> getDuplicateVaccDlt(String vaccID)
	{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Map<String, String> dupliVaccDlt = null;
		try
		{
			dupliVaccDlt = new HashMap<String, String>();
			con =  ConnectionManager.getConnection();
			String strSql = " select DUPL_CHECK_DAYS, DUPL_CHECK_ACTION   from CA_IM_VACCINE where VACCINE_ID = ? AND CHECK_DUPLICATE_YN ='Y'";
			pst = con.prepareStatement(strSql);

			pst.setString(1, vaccID);
			rs = pst.executeQuery();

			if (rs.next())
			{
				String check_duplicate_yn = rs.getString("DUPL_CHECK_DAYS")== null?"":rs.getString("DUPL_CHECK_DAYS");
				if (!check_duplicate_yn.equals("") && check_duplicate_yn.equals("Y"))
				{
					dupliVaccDlt.put("DUPL_CHECK_DAYS", rs.getString("DUPL_CHECK_DAYS")== null?"":rs.getString("DUPL_CHECK_DAYS"));
					dupliVaccDlt.put("DUPL_CHECK_ACTION", rs.getString("DUPL_CHECK_ACTION")== null?"":rs.getString("DUPL_CHECK_ACTION"));

				}
			}
			if (rs != null)rs.close();
			if (pst != null)pst.close();
			return dupliVaccDlt.size()>0?dupliVaccDlt:null;
		}
		catch (Exception e)
		{
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
			catch (Exception ee)
			{
				ee.printStackTrace();
			}
		}
		return null;
	}
}
