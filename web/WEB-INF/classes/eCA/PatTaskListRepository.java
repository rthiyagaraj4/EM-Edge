/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------
Date       Edit History      Name        		Description
-------------------------------------------------------------------------------------------------------
?             100            ?					created
02/11/2011    IN029366      Chowminya G			Incident No: IN029366 - <Med Admin under task list - display for
																	discharged patients> 
08/12/2011	  IN29788		Menaka V			Patient Id length should be changed based on the MP Parameter
												Setup (maximum up to 12 chrs).						
22/03/2012    IN29559       DineshT				Record consent criteria in TaskList function											
22/06/2012    IN033488      Chowminya G    		Incident No: IN033488 -  Error Marking - Result completed indicator> 										
25/07/2012	  IN034216		Menaka V			Blood Unit Consumption Records are not displaying in Task List.			
12/09/2012    IN31901		NijithaS	    	Incident No: IN31901 - Bru-HIMS-CRF-263		
20/09/2012    IN034888		Chowminya G	   		CRF-CA- Bru-HIMS-CRF-121/01-Only One Orderable is displayed
02/11/2012    IN033063      Chowminya G    		Reopen:Package services allowed to be availed after the Package valid day
12/06/2013	  IN040761		Akbar				Task List : Include Bed Number & Priority Zone (AE)
26/06/2013	  	IN041063		Nijitha			ALPHA-CA-For discharged Inpatients the Bed No, and for Emergency patients Priority Zone is displayed at Tasklist function.
27/06/2013	  IN041260		Ramesh G			Records are not displaying in Task List --> Blood Unit Consumption.
19/04/2016	  IN058250		Krishna Gowtham		System allowing registering order even if that order type is not assigned to user.
12/05/2016	  IN060299		Krishna Gowtham		12.X-ALPHA-CIS-OR-System allows to do result reporting though responsibility doesn't have access.
--------------------------------------------------------------------------------------------------------
Date			Edit History	Name				Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------
20/01/2017		IN061898		Raja S				23/01/2017		Ramesh G		ML-MMOH-CRF-0550
10/07/2017		IN061903		Krishna Gowtham J 	10/07/2017		Ramesh G		ML-MMOH-CRF-0555
19/10/2017		IN065324		Dinesh T			19/10/2017		Ramesh G		To display the price in OR screen and the billing status in Manage Specimen screen
15/12/2017		IN065942		Dinesh T			15/12/2017		Ramesh G		In Nuclear medicine  department we required the barcode functionality at the time of Registration of order,required patient Id,patient name,age,sex,register date and name 	of study.
2/05/2019  		IN070316       	sivabagyam      	2/05/2019      	Ramesh G    	SKR-SCF-1193
13/04/2020		IN072674		Ramesh Goli			13/04/2020		Ramesh G		MMS-KH-CRF-0032
23/04/2020	  	IN071618	    Nijitha S			23/04/2020  	Ramesh G		PMG2019-MMS-CRF-0004
26/10/2020		IN067210		SIVABAGYAM M		26/10/2020		RAMESH G		ML-MMOH-CRF-1144
27/05/2021 		IN17999        	chandrashekar a                                     AAKH-CRF-0132.1
27/07/2022		26826			Ramesh G											MMS-DM-CRF-0197
-------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import eCommon.Common.*;
import eCA.Common.*;//IN065324
public class  PatTaskListRepository implements java.io.Serializable
{

	//HttpServletRequest request = null;
	//HttpServletResponse response = null;
	//Connection con = null;
/**
*	getQueryForTask	-	will Retrieve all Enabled the Intervention Type
*	@param	property - This is a Properties Object used to obtain Connection
*/
	public CaAdapter adapter = new CaAdapter();//IN065324
	private LinkedHashMap hash_values			= new LinkedHashMap();
//IN067210 STARTS
private ArrayList<String> tasklist=new ArrayList<String>();
	 public ArrayList<String> getTasklist() {
	return tasklist;
}

public void setTasklist(ArrayList<String> tasklist) {
	this.tasklist = tasklist;
}
//IN067210 ENDS
	 public ArrayList  getOrderCategory(Properties property) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList orderCategory		= new ArrayList();
		String locale				= (String) property.getProperty("LOCALE");

		try {
			connection = ConnectionManager.getConnection();
			pstmt = connection.prepareStatement("SELECT  short_desc,order_category FROM or_order_category_lang_vw  WHERE language_id=?  and order_category not in ('CN','CS') ORDER BY short_desc") ;
			pstmt.setString( 1, locale);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] order_cat 			= new String[2];
				order_cat[0] = resultSet.getString(1)  ;
				order_cat[1] = resultSet.getString(2)  ;
				orderCategory.add(order_cat);

			}


		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			ConnectionManager.returnConnection(connection);
		}

		return orderCategory;
	}

	 public ArrayList  getOrderType(Properties property,String order_cat) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList orderType		= new ArrayList();
		String locale				= (String) property.getProperty("LOCALE");

		try {
			connection = ConnectionManager.getConnection();
			pstmt = connection.prepareStatement("select short_desc,order_type_code from or_order_type_lang_vw where EFF_STATUS='E' and order_category=? and language_id=? order by short_desc") ;
			pstmt.setString( 1, order_cat);
			pstmt.setString( 2, locale);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] order_Type 			= new String[2];
				order_Type[0] = resultSet.getString(1)  ;
				order_Type[1] = resultSet.getString(2)  ;
				orderType.add(order_Type);

			}


		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			ConnectionManager.returnConnection(connection);
		}

		return orderType;
	}

	public ArrayList  getAdminRoute(Properties property) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList AdminRoute		= new ArrayList();
		String locale				= (String) property.getProperty("LOCALE");

		try {
			connection = ConnectionManager.getConnection();
			pstmt = connection.prepareStatement("SELECT ROUTE_DESC route_desc, ROUTE_CODE route_code FROM PH_ROUTE_LANG_VW where EFF_STATUS = 'E' and language_id = ? order by route_desc") ;
			pstmt.setString( 1, locale);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] admin_route = new String[2];
				admin_route[0] = resultSet.getString(1)  ;
				admin_route[1] = resultSet.getString(2)  ;
				AdminRoute.add(admin_route);

			}


		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			ConnectionManager.returnConnection(connection);
		}

		return AdminRoute;
	}

	public ArrayList  getInterventionType(Properties property,String definition) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList interventionType	= new ArrayList();
		StringBuffer sql			= new StringBuffer();

		try
		{
			connection = ConnectionManager.getConnection();
			sql.append("select INTERVENTION_TYPE, SHORT_DESC from ca_intervention_type where ");
			if(definition.equals("S"))
				sql.append(" SYSTEM_DEFINED_YN = 'Y' ");
			else
				sql.append(" SYSTEM_DEFINED_YN = 'N' ");
			sql.append(" order by short_desc ");

			pstmt = connection.prepareStatement(sql.toString()) ;

			resultSet = pstmt.executeQuery() ;

			while(resultSet != null && resultSet.next())
			{
				String[] inter_Type = new String[2];
				inter_Type[0] = resultSet.getString(1)  ;
				inter_Type[1] = resultSet.getString(2)  ;
				interventionType.add(inter_Type);

			}


		}
		catch ( Exception e )
		{
			e.printStackTrace() ;
			throw e ;
		}
		finally
		{
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			ConnectionManager.returnConnection(connection);
		}

		return interventionType;
	}

	public String getCalender(String datee) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String cal_values=null;
		try{
		connection = ConnectionManager.getConnection();
		pstmt = connection.prepareStatement("select CA_Task_list_Cal(to_char(sysdate,'mm/yyyy' )) from dual") ;
		resultSet = pstmt.executeQuery() ;
		if( resultSet != null && resultSet.next() )
			cal_values=resultSet.getString(1)  ;
		}
		catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			ConnectionManager.returnConnection(connection);
		}

		return cal_values;
	}

	public void putHashvalues(String key,String value)
	{
		hash_values.put(key,value);
	}
	public void clearHashValues()
	{
	hash_values.put("c_locn_desc","");
	hash_values.put("c_locn_code","");
	hash_values.put("c_location_type","");
	hash_values.put("c_patient_id","");
	hash_values.put("c_status_code","");
	hash_values.put("c_taskSelect","");
	hash_values.put("c_OrderCategory","");
	hash_values.put("c_OrderType","");
	hash_values.put("c_Groupby","");
	hash_values.put("c_To_date","");
	hash_values.put("c_From_date","");
	hash_values.put("c_pat_discharge","");
	hash_values.put("c_onclickS","");
	hash_values.put("c_clickdate","");
	hash_values.put("c_search","");
	hash_values.put("c_patientname","");
	hash_values.put("c_chkAll","");
	hash_values.put("c_ckhDue","");
	hash_values.put("c_chkOverdue","");
	hash_values.put("c_chkElapsed","");
	hash_values.put("c_chkPerformed","");
	hash_values.put("c_chkReg","");
	hash_values.put("c_chkFuture","");
	hash_values.put("c_taskListFlag","");
	hash_values.put("c_taskSelectAll","");

	}
	public String get_hashValues(String key)
	{
	return (String)hash_values.get(key);
	}

	public LinkedHashMap get_hash()
	{
	return hash_values;
	}

	//public ArrayList getTaskResult(Properties property,String locn_desc, String locn_code,String location_type,String status_code,String taskSelect,String OrderCategory,String OrderType,String Groupby,String To_date,String From_date,String pat_discharge,String patient_id, String facilityId,String chkAll,String ckhDue,String chkElapsed,String chkPerformed,String chkFuture,String chkReg,String chkOverdue,String chkUnclassify, String practitioner_id,String resp_id,ArrayList TaskAlldata,String AdminRoute,String bt_status, String definition, String interventionType, int start,int end) throws Exception

	// Added By Sridhar Reddy PMG20089-CRF-0691
	public ArrayList getTaskResult(Properties property,HashMap paramListMap) throws Exception
	{

		String locn_code = (String)paramListMap.get("locn_code");
		String location_type = (String)paramListMap.get("location_type");
		String status_code = (String)paramListMap.get("status_code");
		String taskSelect = (String)paramListMap.get("taskSelect");
		String OrderCategory = (String)paramListMap.get("OrderCategory");
		String OrderType = (String)paramListMap.get("OrderType");
		String Groupby = (String)paramListMap.get("Groupby");
		String To_date = (String)paramListMap.get("To_date");
		String From_date = (String)paramListMap.get("From_date");
		String patient_id = (String)paramListMap.get("patient_id");
		String facilityId = (String)paramListMap.get("facilityId");
		String ckhDue = (String)paramListMap.get("ckhDue");
		String chkElapsed = (String)paramListMap.get("chkElapsed");
		String chkPerformed = (String)paramListMap.get("chkPerformed");
		String chkFuture = (String)paramListMap.get("chkFuture");
		String chkOverdue = (String)paramListMap.get("chkOverdue");
		String chkUnclassify = (String)paramListMap.get("chkUnclassify");
		String practitioner_id = (String)paramListMap.get("practitioner_id");
		String resp_id = (String)paramListMap.get("resp_id");
		ArrayList TaskAlldata = (ArrayList)paramListMap.get("TaskAlldata");
		String AdminRoute = (String)paramListMap.get("AdminRoute");
		String bt_status = (String)paramListMap.get("bt_status");
		String definition = (String)paramListMap.get("definition");
		String interventionType = (String)paramListMap.get("interventionType");
		int start =((Integer)paramListMap.get("start")).intValue();
		int end = ((Integer)paramListMap.get("end")).intValue();
		String callFrom = (String)paramListMap.get("callFrom");
		String viewBy = (String)paramListMap.get("viewBy");
		String encounter_id = (String)paramListMap.get("encounter_id");
		String relationship_id = (String)paramListMap.get("relationship_id");

		int start_tmp = start;
		int k=0 ;

		String resultReport="";
		String registerOrder="";
		String intervention="";
		String medAdmin="";
		String specCollection="";
		String bloodUnit = "";
		String access_previlage="";
		String recConsent="";//Chowminya,IN29559

		for (int x=0;x<TaskAlldata.size() ;x++ )
		{
			
			if (((String)TaskAlldata.get(x)).equals("CA_TASK_LIST_RESREP"))
			{
				resultReport = "CA_TASK_LIST_RESREP";
			}else if (((String)TaskAlldata.get(x)).equals("CA_TASK_LIST_REGORD"))
			{
				registerOrder = "CA_TASK_LIST_REGORD";
			}else if (((String)TaskAlldata.get(x)).equals("CA_TASK_LIST_MSPECI"))
			{
				specCollection = "CA_TASK_LIST_MSPECI";
			}else if (((String)TaskAlldata.get(x)).equals("CA_TASK_LIST_MEDADMN"))
			{
				medAdmin = "CA_TASK_LIST_MEDADMN";
			}else if (((String)TaskAlldata.get(x)).equals("CA_TASK_LIST_INT"))
			{
				intervention = "CA_TASK_LIST_INT";
			}else if (((String)TaskAlldata.get(x)).equals("CA_TASK_LIST_BLDCONS"))
			{
				bloodUnit = "CA_TASK_LIST_BLDCONS";
			}else if (((String)TaskAlldata.get(x)).equals("CA_TASK_LIST_RECCONS")) //Chowminya,IN29559
			{
				recConsent = "CA_TASK_LIST_RECCONS";
			}
		}

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList taskResult		= new ArrayList();
		String ALL="%";
		StringBuffer sql=new StringBuffer();
		String locale				= (String) property.getProperty("LOCALE");
	//	String practionerID				= "%";
		String[] ResultingCheck	= new String[2];
		int i=0;
		String resultvalue="";
		String resultby="";
		//String login_user = "";
		
		//String OTinstalled =isModuleInstalled(facilityId,"OT");//IN31901
		String RDinstalled =isModuleInstalled(facilityId,"RD");

		try {

			//login_user	 = ((String) session.getValue("ca_practitioner_id")).trim();


			ResultingCheck			= checkResulting(practitioner_id,resp_id);
			if(ResultingCheck.length>0)
			{
				resultvalue					= ResultingCheck[0];
				resultby						= ResultingCheck[1];

			}
			connection = ConnectionManager.getConnection();

			// Added by Sridhar Reddy V on 25/06/2009 to Fix INCIDENT 11789
				String prevQuery = "select 'X' from OR_RESULT_USER where (Practitioner_id  =? and rownum=1)";
				pstmt = connection.prepareStatement(prevQuery);
				pstmt.setString(1,practitioner_id);
				resultSet  = pstmt.executeQuery();
				if (resultSet.next())
				{
					access_previlage = resultSet.getString(1) == null ? "":  resultSet.getString(1);
				}
				if (resultSet == null)resultSet.close();
				if (pstmt == null)pstmt.close();
			// End

			
				System.out.println("taskSelect========>404=================pattasklistrepository====>"+taskSelect);
				System.out.println("resultReport========>405=================pattasklistrepository====>"+resultReport);
			if(taskSelect.equals("O") || (taskSelect.equals("") && resultReport.equals("CA_TASK_LIST_RESREP")))
			{
		
			String Admin_Status_str="";
			/**
				modified by Deepa on 5/14/2010 at 3:16 PM for IN021020
				modified query to retrieve Dob to handle multiple reference range 
			**/

			if(sql.length() > 0) sql.delete(0,sql.length());
			////IN040761 - commented
			//sql.append("SELECT	'O' TASK_CATEG, DECODE ('en',?, d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,TRUNC(c.start_date_time) start_date,to_char (c.start_date_time,'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (c.start_date_time, 'HH24:MI') schedule_time_string,b.order_type_code task_type,or_get_desc.or_order_type (b.order_type_code,?,'2') task_type_desc, or_get_order_catalog (b.order_id,b.order_type_code,?,'MD',c.order_line_num) task_desc,c.order_catalog_code task_code,TO_CHAR (c.start_date_time, 'DD/MM/YYYY') schedule_date_string,NULL task_srl_no,am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (C.order_LINE_status,?,'2') status_desc, get_age (d.date_of_birth) age, to_char(d.date_of_birth,'DD/MM/YYYY') dob, d.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_status order_status, or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,b.encounter_id encounter_id, e.patient_class patient_class,c.order_line_num order_line_num,b.performing_facility_id performing_facility_id,     b.performing_deptloc_type performing_deptloc_type,b.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext FROM or_performing_deptloc WHERE performing_facility_id = b.performing_facility_id  AND performing_deptloc_type = b.performing_deptloc_type  AND performing_deptloc_code = b.performing_deptloc_code) int_or_ext,'N' image_ref_yn, b.source_type source_type,b.source_code source_code, b.order_type_code order_type_code,b.order_id order_id, b.patient_id patient_id,or_get_result_rep_opern (b.ordering_facility_id, b.order_id,b.order_category,b.order_type_code,b.cont_order_ind,                           b.order_status,c.ref_sent_pract_id, c.ref_recieved_date_time,b.performing_facility_id,                               b.performing_deptloc_type,b.performing_deptloc_code,c.result_applicable_yn,c.order_catalog_code,c.order_line_num,c.order_line_status,null,?,?,?) result_options,CASE WHEN b.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(b.ordering_facility_id,                       b.source_code,?,'2') ELSE op_get_desc.op_clinic (b.ordering_facility_id,                                        b.source_code,?,'2') END location_description, nvl((SELECT 'C'  FROM or_order_status_code Ia, or_status_applicability Ib WHERE Ib.oper_or_group_ref = 'EXT_COMPL_ORD'  AND Ia.order_status_type = Ib.order_status_type AND IA.ORDER_STATUS_CODE=b.order_status),'D' )   Admin_Status,null RESULT_TYPE ,null RESULT_ID,b.cont_order_ind,c.APPT_REF_NUM,b.ord_pract_id, NULL consent_status,b.order_set_id order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = c.order_line_num and rownum=1) linked_note_accession_num   FROM or_order b, or_order_line c, mp_patient d,pr_encounter e WHERE b.patient_id = e.patient_id and b.encounter_id = e.encounter_id and b.performing_facility_id = e.facility_id and b.order_id = c.order_id AND d.patient_id = b.patient_id  and nvl(b.CONT_ORDER_IND,'xx') not in ('DR','CR') AND c.start_date_time BETWEEN TO_DATE (?,'dd/mm/yyyy')  AND   TO_DATE (?, 'dd/mm/yyyy')+ .99999 /*AND c.order_line_num=1*/ AND b.ordering_facility_id=? AND B.ORD_DATE_TIME BETWEEN TO_DATE (?, 'dd/mm/yyyy')-30  AND   TO_DATE (?, 'dd/mm/yyyy')+ 30.99999 AND C.order_line_status IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = ?  AND a.order_status_type = b.order_status_type) and (performing_appl_id IS NULL  OR performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE  NVL (result_entry, 'OR') = 'OR')) AND substr(b.order_id,1,2)!='CS' and OR_Check_resulting_YN(?,?, b.order_category,b.order_type_code,b.order_id,b.performing_facility_id,b.performing_deptloc_type,b.performing_deptloc_code) ='Y' and b.performing_facility_id =? ")
;
			
			//IN040761 AE_BED_NO -> INCLUDED
			//sql.append("SELECT	'O' TASK_CATEG, DECODE ('en',?, d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,TRUNC(c.start_date_time) start_date,to_char (c.start_date_time,'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (c.start_date_time, 'HH24:MI') schedule_time_string,b.order_type_code task_type,or_get_desc.or_order_type (b.order_type_code,?,'2') task_type_desc, or_get_order_catalog (b.order_id,b.order_type_code,?,'MD',c.order_line_num) task_desc,c.order_catalog_code task_code,TO_CHAR (c.start_date_time, 'DD/MM/YYYY') schedule_date_string,NULL task_srl_no,am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (C.order_LINE_status,?,'2') status_desc, get_age (d.date_of_birth) age, to_char(d.date_of_birth,'DD/MM/YYYY') dob, d.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_status order_status, or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,b.encounter_id encounter_id, e.patient_class patient_class,c.order_line_num order_line_num,b.performing_facility_id performing_facility_id,     b.performing_deptloc_type performing_deptloc_type,b.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext FROM or_performing_deptloc WHERE performing_facility_id = b.performing_facility_id  AND performing_deptloc_type = b.performing_deptloc_type  AND performing_deptloc_code = b.performing_deptloc_code) int_or_ext,'N' image_ref_yn, b.source_type source_type,b.source_code source_code, b.order_type_code order_type_code,b.order_id order_id, b.patient_id patient_id,or_get_result_rep_opern (b.ordering_facility_id, b.order_id,b.order_category,b.order_type_code,b.cont_order_ind,                           b.order_status,c.ref_sent_pract_id, c.ref_recieved_date_time,b.performing_facility_id,                               b.performing_deptloc_type,b.performing_deptloc_code,c.result_applicable_yn,c.order_catalog_code,c.order_line_num,c.order_line_status,null,?,?,?) result_options,CASE WHEN b.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(b.ordering_facility_id,                       b.source_code,?,'2') ELSE op_get_desc.op_clinic (b.ordering_facility_id,                                        b.source_code,?,'2') END location_description, nvl((SELECT 'C'  FROM or_order_status_code Ia, or_status_applicability Ib WHERE Ib.oper_or_group_ref = 'EXT_COMPL_ORD'  AND Ia.order_status_type = Ib.order_status_type AND IA.ORDER_STATUS_CODE=b.order_status),'D' )   Admin_Status,null RESULT_TYPE ,null RESULT_ID,b.cont_order_ind,c.APPT_REF_NUM,b.ord_pract_id, NULL consent_status,b.order_set_id order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = c.order_line_num and rownum=1) linked_note_accession_num ,  e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone  FROM or_order b, or_order_line c, mp_patient d,pr_encounter e WHERE b.patient_id = e.patient_id and b.encounter_id = e.encounter_id and b.performing_facility_id = e.facility_id and b.order_id = c.order_id AND d.patient_id = b.patient_id  and nvl(b.CONT_ORDER_IND,'xx') not in ('DR','CR') AND c.start_date_time BETWEEN TO_DATE (?,'dd/mm/yyyy')  AND   TO_DATE (?, 'dd/mm/yyyy')+ .99999 /*AND c.order_line_num=1*/ AND b.ordering_facility_id=? AND B.ORD_DATE_TIME BETWEEN TO_DATE (?, 'dd/mm/yyyy')-30  AND   TO_DATE (?, 'dd/mm/yyyy')+ 30.99999 AND C.order_line_status IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = ?  AND a.order_status_type = b.order_status_type) and (performing_appl_id IS NULL  OR performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE NVL (result_entry, 'OR') = 'OR')) AND substr(b.order_id,1,2)!='CS' and OR_Check_resulting_YN(?,?, b.order_category,b.order_type_code,b.order_id,b.performing_facility_id,b.performing_deptloc_type,b.performing_deptloc_code) ='Y' and b.performing_facility_id =? "); //IN041063
			//sql.append("SELECT	'O' TASK_CATEG, DECODE ('en',?, d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,TRUNC(c.start_date_time) start_date,to_char (c.start_date_time,'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (c.start_date_time, 'HH24:MI') schedule_time_string,b.order_type_code task_type,or_get_desc.or_order_type (b.order_type_code,?,'2') task_type_desc, or_get_order_catalog (b.order_id,b.order_type_code,?,'MD',c.order_line_num) task_desc,c.order_catalog_code task_code,TO_CHAR (c.start_date_time, 'DD/MM/YYYY') schedule_date_string,NULL task_srl_no,am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (C.order_LINE_status,?,'2') status_desc, get_age (d.date_of_birth) age, to_char(d.date_of_birth,'DD/MM/YYYY') dob, d.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_status order_status, or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,b.encounter_id encounter_id, e.patient_class patient_class,c.order_line_num order_line_num,b.performing_facility_id performing_facility_id,     b.performing_deptloc_type performing_deptloc_type,b.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext FROM or_performing_deptloc WHERE performing_facility_id = b.performing_facility_id  AND performing_deptloc_type = b.performing_deptloc_type  AND performing_deptloc_code = b.performing_deptloc_code) int_or_ext,'N' image_ref_yn, b.source_type source_type,b.source_code source_code, b.order_type_code order_type_code,b.order_id order_id, b.patient_id patient_id,or_get_result_rep_opern (b.ordering_facility_id, b.order_id,b.order_category,b.order_type_code,b.cont_order_ind,                           b.order_status,c.ref_sent_pract_id, c.ref_recieved_date_time,b.performing_facility_id,                               b.performing_deptloc_type,b.performing_deptloc_code,c.result_applicable_yn,c.order_catalog_code,c.order_line_num,c.order_line_status,null,?,?,?) result_options,CASE WHEN b.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(b.ordering_facility_id,                       b.source_code,?,'2') ELSE op_get_desc.op_clinic (b.ordering_facility_id,                                        b.source_code,?,'2') END location_description, nvl((SELECT 'C'  FROM or_order_status_code Ia, or_status_applicability Ib WHERE Ib.oper_or_group_ref = 'EXT_COMPL_ORD'  AND Ia.order_status_type = Ib.order_status_type AND IA.ORDER_STATUS_CODE=b.order_status),'D' )   Admin_Status,null RESULT_TYPE ,null RESULT_ID,b.cont_order_ind,c.APPT_REF_NUM,b.ord_pract_id, NULL consent_status,b.order_set_id order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = c.order_line_num and rownum=1) linked_note_accession_num ,  e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone ,e.VISIT_STATUS,e.adt_status FROM or_order b, or_order_line c, mp_patient d,pr_encounter e WHERE b.patient_id = e.patient_id and b.encounter_id = e.encounter_id and b.performing_facility_id = e.facility_id and b.order_id = c.order_id AND d.patient_id = b.patient_id  and nvl(b.CONT_ORDER_IND,'xx') not in ('DR','CR') AND c.start_date_time BETWEEN TO_DATE (?,'dd/mm/yyyy')  AND   TO_DATE (?, 'dd/mm/yyyy')+ .99999 /*AND c.order_line_num=1*/ AND b.ordering_facility_id=? AND B.ORD_DATE_TIME BETWEEN TO_DATE (?, 'dd/mm/yyyy')-30  AND   TO_DATE (?, 'dd/mm/yyyy')+ 30.99999 AND C.order_line_status IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = ?  AND a.order_status_type = b.order_status_type) and (performing_appl_id IS NULL  OR performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE NVL (result_entry, 'OR') = 'OR')) AND substr(b.order_id,1,2)!='CS' and OR_Check_resulting_YN(?,?, b.order_category,b.order_type_code,b.order_id,b.performing_facility_id,b.performing_deptloc_type,b.performing_deptloc_code) ='Y' and b.performing_facility_id =? ");//IN041063//IN065942
	//sql.append("SELECT	'O' TASK_CATEG, DECODE ('en',?, d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,TRUNC(c.start_date_time) start_date,to_char (c.start_date_time,'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (c.start_date_time, 'HH24:MI') schedule_time_string,b.order_type_code task_type,or_get_desc.or_order_type (b.order_type_code,?,'2') task_type_desc, or_get_order_catalog (b.order_id,b.order_type_code,?,'MD',c.order_line_num) task_desc,c.order_catalog_code task_code,TO_CHAR (c.start_date_time, 'DD/MM/YYYY') schedule_date_string,NULL task_srl_no,am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (C.order_LINE_status,?,'2') status_desc, get_age (d.date_of_birth) age, to_char(d.date_of_birth,'DD/MM/YYYY') dob, d.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_status order_status, or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,b.encounter_id encounter_id, e.patient_class patient_class,c.order_line_num order_line_num,b.performing_facility_id performing_facility_id,     b.performing_deptloc_type performing_deptloc_type,b.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext FROM or_performing_deptloc WHERE performing_facility_id = b.performing_facility_id  AND performing_deptloc_type = b.performing_deptloc_type  AND performing_deptloc_code = b.performing_deptloc_code) int_or_ext,'N' image_ref_yn, b.source_type source_type,b.source_code source_code, b.order_type_code order_type_code,b.order_id order_id, b.patient_id patient_id,or_get_result_rep_opern (b.ordering_facility_id, b.order_id,b.order_category,b.order_type_code,b.cont_order_ind,                           b.order_status,c.ref_sent_pract_id, c.ref_recieved_date_time,b.performing_facility_id, b.performing_deptloc_type,b.performing_deptloc_code,c.result_applicable_yn,c.order_catalog_code,c.order_line_num,c.order_line_status,null,?,?,?) result_options,CASE WHEN b.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(b.ordering_facility_id, b.source_code,?,'2') ELSE op_get_desc.op_clinic (b.ordering_facility_id, b.source_code,?,'2') END location_description, nvl((SELECT 'C'  FROM or_order_status_code Ia, or_status_applicability Ib WHERE Ib.oper_or_group_ref = 'EXT_COMPL_ORD'  AND Ia.order_status_type = Ib.order_status_type AND IA.ORDER_STATUS_CODE=b.order_status),'D' )   Admin_Status,null RESULT_TYPE ,null RESULT_ID,b.cont_order_ind,c.APPT_REF_NUM,b.ord_pract_id, NULL consent_status,b.order_set_id order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = c.order_line_num and rownum=1) linked_note_accession_num ,  e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone ,e.VISIT_STATUS,e.adt_status,'N' prn_reg_ord FROM or_order b, or_order_line c, mp_patient d,pr_encounter e WHERE b.patient_id = e.patient_id and b.encounter_id = e.encounter_id and b.performing_facility_id = e.facility_id and b.order_id = c.order_id AND d.patient_id = b.patient_id  and nvl(b.CONT_ORDER_IND,'xx') not in ('DR','CR') AND c.start_date_time BETWEEN TO_DATE (?,'dd/mm/yyyy')  AND   TO_DATE (?, 'dd/mm/yyyy')+ .99999 /*AND c.order_line_num=1*/ AND b.ordering_facility_id=? AND B.ORD_DATE_TIME BETWEEN TO_DATE (?, 'dd/mm/yyyy')-30  AND   TO_DATE (?, 'dd/mm/yyyy')+ 30.99999 AND C.order_line_status IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = ?  AND a.order_status_type = b.order_status_type) and (performing_appl_id IS NULL  OR performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE NVL (result_entry, 'OR') = 'OR')) AND substr(b.order_id,1,2)!='CS' and OR_Check_resulting_YN(?,?, b.order_category,b.order_type_code,b.order_id,b.performing_facility_id,b.performing_deptloc_type,b.performing_deptloc_code) ='Y' and b.performing_facility_id =? ");//IN041063//IN065942////IN070316 
			sql.append("SELECT	'O' TASK_CATEG, DECODE ('en',?, d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,TRUNC(c.start_date_time) start_date,to_char (c.start_date_time,'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (c.start_date_time, 'HH24:MI') schedule_time_string,b.order_type_code task_type,or_get_desc.or_order_type (b.order_type_code,?,'2') task_type_desc, or_get_order_catalog (b.order_id,b.order_type_code,?,'MD',c.order_line_num) task_desc,c.order_catalog_code task_code,TO_CHAR (c.start_date_time, 'DD/MM/YYYY') schedule_date_string,NULL task_srl_no,am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (C.order_LINE_status,?,'2') status_desc, get_age (d.date_of_birth) age, to_char(d.date_of_birth,'DD/MM/YYYY') dob, d.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,c.order_LINE_status order_status, or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,b.encounter_id encounter_id, e.patient_class patient_class,c.order_line_num order_line_num,b.performing_facility_id performing_facility_id,     b.performing_deptloc_type performing_deptloc_type,b.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext FROM or_performing_deptloc WHERE performing_facility_id = b.performing_facility_id  AND performing_deptloc_type = b.performing_deptloc_type  AND performing_deptloc_code = b.performing_deptloc_code) int_or_ext,'N' image_ref_yn, b.source_type source_type,b.source_code source_code, b.order_type_code order_type_code,b.order_id order_id, b.patient_id patient_id,or_get_result_rep_opern (b.ordering_facility_id, b.order_id,b.order_category,b.order_type_code,b.cont_order_ind,                           b.order_status,c.ref_sent_pract_id, c.ref_recieved_date_time,b.performing_facility_id, b.performing_deptloc_type,b.performing_deptloc_code,c.result_applicable_yn,c.order_catalog_code,c.order_line_num,c.order_line_status,null,?,?,?) result_options,CASE WHEN b.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(b.ordering_facility_id, b.source_code,?,'2') ELSE op_get_desc.op_clinic (b.ordering_facility_id, b.source_code,?,'2') END location_description, nvl((SELECT 'C'  FROM or_order_status_code Ia, or_status_applicability Ib WHERE Ib.oper_or_group_ref = 'EXT_COMPL_ORD'  AND Ia.order_status_type = Ib.order_status_type AND IA.ORDER_STATUS_CODE=c.order_line_status),'D' )   Admin_Status,null RESULT_TYPE ,null RESULT_ID,b.cont_order_ind,c.APPT_REF_NUM,b.ord_pract_id, NULL consent_status,b.order_set_id order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status,(SELECT linked_note_accession_num FROM or_result_detail WHERE order_id = b.order_id AND line_srl_no = c.order_line_num and rownum=1) linked_note_accession_num ,  e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone ,e.VISIT_STATUS,e.adt_status,'N' prn_reg_ord FROM or_order b, or_order_line c, mp_patient d,pr_encounter e WHERE b.patient_id = e.patient_id and b.encounter_id = e.encounter_id and b.performing_facility_id = e.facility_id and b.order_id = c.order_id AND d.patient_id = b.patient_id  and nvl(b.CONT_ORDER_IND,'xx') not in ('DR','CR') AND c.start_date_time BETWEEN TO_DATE (?,'dd/mm/yyyy')  AND   TO_DATE (?, 'dd/mm/yyyy')+ .99999 /*AND c.order_line_num=1*/ AND b.ordering_facility_id=? AND B.ORD_DATE_TIME BETWEEN TO_DATE (?, 'dd/mm/yyyy')-30  AND   TO_DATE (?, 'dd/mm/yyyy')+ 30.99999 AND C.order_line_status IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = ?  AND a.order_status_type = b.order_status_type) and (performing_appl_id IS NULL  OR performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE NVL (result_entry, 'OR') = 'OR')) AND substr(b.order_id,1,2)!='CS' and OR_Check_resulting_YN(?,?, b.order_category,b.order_type_code,b.order_id,b.performing_facility_id,b.performing_deptloc_type,b.performing_deptloc_code) ='Y' and b.performing_facility_id =? ");//IN041063//IN065942//IN070316 
			if(RDinstalled.equalsIgnoreCase("Y"))
			{
				sql.append(" and substr(b.order_id,1,2)!='RD'" );
			}
			//IN060299 Start
			// Added by Sridhar Reddy V on 25/06/2009 to Fix INCIDENT 11789
			/*if (access_previlage.equals("X"))
			{
				sql.append(" and b.order_category in (Select Order_category from or_order_category b where exists(select 1 from or_result_user a where a.order_category  = b.order_category  AND practitioner_id = ?))");
			}else{
				sql.append(" and b.order_category in (Select Order_category from or_order_category b where exists(select 1 from or_result_user a where a.order_category  = b.order_category  AND resp_id = ?)) ");
			}*/
			
			sql.append(" and ((b.order_category in (Select Order_category from or_order_category b where exists(select 1 from or_result_user a where a.order_category  = b.order_category AND(practitioner_id = ? OR resp_id = ?)AND order_type_code='*ALL'))OR( b.ORDER_TYPE_CODE in (Select ORDER_TYPE_CODE from or_order_type b where exists(select 1 from or_result_user a where a.ORDER_TYPE_CODE  = b.ORDER_TYPE_CODE AND (practitioner_id = ? OR resp_id=?))))))");
			//IN060299 End

			if(patient_id.equals(""))
				sql.append("and b.patient_id like ? ");
			else
				sql.append("and b.patient_id = ? ");


			if(location_type.equals(""))
			{
				sql.append("AND  e.ASSIGN_CARE_LOCN_TYPE like ? ");
			}
			else
			{
				if(location_type.equals("C"))
				{
					sql.append("AND  e.ASSIGN_CARE_LOCN_TYPE in ('C','E') ");
				}
				else
				{
					sql.append("AND  e.ASSIGN_CARE_LOCN_TYPE=? ");
				}
			}

			if(locn_code.equals(""))
			sql.append("AND  e.ASSIGN_CARE_LOCN_CODE like ? ");
			else
			sql.append("AND  e.ASSIGN_CARE_LOCN_CODE=? ");

			if(OrderCategory.equals(""))
			sql.append("AND  B.ORDER_CATEGORY like ? ");
			else
			sql.append("AND  B.ORDER_CATEGORY=? ");

			if(OrderType.equals(""))
			sql.append("AND  B.ORDER_TYPE_CODE like ? ");
			else
			sql.append("AND  B.ORDER_TYPE_CODE=? ");

			if (chkFuture.equals("Y") )
			{
				Admin_Status_str="'F'";
			}
			if (ckhDue.equals("Y") )
			{
				if (!Admin_Status_str.equals(""))
				{
					Admin_Status_str=Admin_Status_str+",";
				}
				Admin_Status_str=Admin_Status_str+"'D'";
			}
			if (chkPerformed.equals("Y") )
			{
				if (!Admin_Status_str.equals(""))
				{
					Admin_Status_str=Admin_Status_str+",";
				}
				Admin_Status_str=Admin_Status_str+"'C','PF'";
			}

		/*	if (ckhDue.equals("Y"))
			{
				if (chkPerformed.equals("N") && chkFuture.equals("N"))
				{

					sql.append("  AND c.START_date_time<=sysdate  AND B.order_status not IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = 'EXT_COMPL_ORD'  AND a.order_status_type = b.order_status_type) ");
				}
				else if (chkFuture.equals("N") && chkPerformed.equals("Y"))
				{

					sql.append("  AND c.START_date_time<=sysdate or B.order_status IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = 'EXT_COMPL_ORD'  AND a.order_status_type = b.order_status_type) ");
				}
				else if(chkFuture.equals("Y") && chkPerformed.equals("N"))
				{

					sql.append(" AND  B.order_status not IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = 'EXT_COMPL_ORD'  AND a.order_status_type = b.order_status_type) ");
				}

			}
			else
			{

				if (chkPerformed.equals("Y") && chkFuture.equals("Y")){

					sql.append(" AND c.START_date_time>sysdate or B.order_status IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = 'EXT_COMPL_ORD'  AND a.order_status_type = b.order_status_type) ");}
				else if (chkFuture.equals("Y") && chkPerformed.equals("N")){

					sql.append(" AND c.START_date_time>sysdate ");}
				else if (chkPerformed.equals("Y") && chkFuture.equals("N")){
					sql.append(" AND B.order_status IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = 'EXT_COMPL_ORD'  AND a.order_status_type = b.order_status_type) ");}
				else{
					sql.append(" AND 1= 2 ");}
			}*/

			if(chkFuture.equals("Y") || ckhDue.equals("Y") || chkPerformed.equals("Y"))
				//sql.append(" and nvl((SELECT 'C'  FROM or_order_status_code Ia, or_status_applicability Ib WHERE Ib.oper_or_group_ref = 'EXT_COMPL_ORD'  AND Ia.order_status_type = Ib.order_status_type AND IA.ORDER_STATUS_CODE=b.order_status),  'D'  )   in ("+Admin_Status_str+") ");//IN070316 
				sql.append(" and nvl((SELECT 'C'  FROM or_order_status_code Ia, or_status_applicability Ib WHERE Ib.oper_or_group_ref = 'EXT_COMPL_ORD'  AND Ia.order_status_type = Ib.order_status_type AND IA.ORDER_STATUS_CODE=c.order_LINE_status),  'D'  )   in ("+Admin_Status_str+") ");//IN070316 
		     else 
				sql.append(" and 1=2 ");
			//commented by Jyothi on 17/07/2009 to fix the incident number 11767.
			/*if (chkAll.equals("N"))
			{
				//
				if (chkFuture.equals("Y"))
				{
					if (ckhDue.equals("Y")||chkElapsed.equals("Y")||chkOverdue.equals("Y"))
					{
						if (chkPerformed.equals("N"))
						{
							sql.append("  AND B.order_status not IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = 'EXT_COMPL_ORD'  AND a.order_status_type = b.order_status_type) ");
						}
					}
					else
					{
						if (chkPerformed.equals("N"))
							sql.append(" AND c.START_date_time>sysdate ");
						else
  						    sql.append(" AND ( c.START_date_time>sysdate or  B.order_status IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = 'EXT_COMPL_ORD'  AND a.order_status_type = b.order_status_type)) ");
					}
				}
				else
				{
					if (ckhDue.equals("Y")||chkElapsed.equals("Y")||chkOverdue.equals("Y"))
					{
						if (chkPerformed.equals("N"))
						{
							sql.append("  AND c.START_date_time<=sysdate  AND B.order_status not IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = 'EXT_COMPL_ORD'  AND a.order_status_type = b.order_status_type) ");
						}
					}
					else
					{
						if (chkPerformed.equals("N"))
							sql.append(" AND c.START_date_time<=sysdate ");
						else
  						    sql.append(" AND ( c.START_date_time<=sysdate or  B.order_status IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = 'EXT_COMPL_ORD'  AND a.order_status_type = b.order_status_type)) ");
				     }
				}
				//
			}*/
					//PE Changes by Shaiju starts

			//		if(taskSelect.equals("") && resultReport.equals("CA_TASK_LIST_RESREP"))
			//		{
			// IN31901 Starts
			
				sql.append(" AND decode(b.order_category,'OT',performing_deptloc_CODE,'X') IS NOT NULL ");
			
			// IN31901 Ends
						if(!(sql.toString()).equals(""))
						{
							if (Groupby.equals("P"))
							{
								sql.append("ORDER BY 2, b.patient_id,3 DESC, 5 ASC ");
							}else if (Groupby.equals("T"))
							{
								sql.append("ORDER BY  3 DESC, 5 ASC, 2 ");
							}
							System.out.println("sql.toString()========>594====pattasklistrepository====>"+sql.toString());
							pstmt = connection.prepareStatement(sql.toString()) ;
																					
							i=0;
							
							pstmt.setString( ++i, locale);
							pstmt.setString( ++i, locale);
							pstmt.setString( ++i, locale);
							pstmt.setString( ++i, locale);
							pstmt.setString( ++i, locale);
						//	pstmt.setString( 5, locale);
							pstmt.setString( ++i, locale);
							pstmt.setString( ++i, practitioner_id);
							pstmt.setString( ++i, resp_id);
							pstmt.setString( ++i, relationship_id);
							pstmt.setString( ++i, locale);
							pstmt.setString( ++i, locale);
							pstmt.setString( ++i, From_date);
							pstmt.setString( ++i, To_date);
							pstmt.setString( ++i, facilityId);
							pstmt.setString( ++i, From_date);
							pstmt.setString( ++i, To_date);
							pstmt.setString( ++i, status_code);
							pstmt.setString( ++i, resultvalue);
							pstmt.setString( ++i, resultby);
							pstmt.setString( ++i, facilityId);
							// IN060299 Start IN060299
							/*if (access_previlage.equals("X"))
							{
								pstmt.setString(++i,practitioner_id);
							}else{
								pstmt.setString(++i,resp_id);
							}*/
							pstmt.setString(++i,practitioner_id);
							pstmt.setString(++i,resp_id);
							pstmt.setString(++i,practitioner_id);
							pstmt.setString(++i,resp_id);
							// IN060299 End
							if(patient_id.equals(""))
							pstmt.setString( ++i, ALL);
							else
							pstmt.setString( ++i, patient_id);
							if(location_type.equals(""))
							{
								pstmt.setString( ++i, ALL);
							}
							else
							{
								if(!location_type.equals("C"))
								{
									pstmt.setString( ++i, location_type);
								}
							}
							if(locn_code.equals(""))
							pstmt.setString( ++i, ALL);
							else
							pstmt.setString( ++i, locn_code);

							if(OrderCategory.equals(""))
							pstmt.setString( ++i, ALL);
							else
							pstmt.setString( ++i, OrderCategory);

							if(OrderType.equals(""))
							pstmt.setString( ++i, ALL);
							else
							pstmt.setString( ++i, OrderType);
					
							resultSet = pstmt.executeQuery() ;
						
						if(resultSet!=null) {
						
						if(start > 0)
						{
							for(k=0;(k<start-1 && resultSet.next());k++);
							start = start-k;
						}
						

						while ( start_tmp <= end && resultSet!=null && resultSet.next()) {
					//while ( resultSet != null && resultSet.next() ) {
						/**
						Modified by Deepa on 5/17/2010 at 12:08 PM for IN021020
						increased the size of taskResult_val to 50 from 49, to include dob in the array
						**/
						//String[] taskResult_val 			= new String[51];
						//String[] taskResult_val 			= new String[54]; //IN030473  [IN040761 increased to 54 from 52]
						//String[] taskResult_val 			= new String[56]; //IN041063  [IN041063 increased to 56 from 54]//IN065942
						//String[] taskResult_val 			= new String[58]; //IN041063  [IN041063 increased to 56 from 54]//IN065942//IN071618
						String[] taskResult_val 			= new String[59]; //26826
						taskResult_val[0] = checkForNull(resultSet.getString("task_type"))  ;
						taskResult_val[1] = checkForNull(resultSet.getString("task_type_desc").trim())  ;
						taskResult_val[2] = checkForNull(resultSet.getString("task_code"))  ;
						taskResult_val[3] = checkForNull(resultSet.getString("schedule_date").trim())  ;
						taskResult_val[4] = checkForNull(resultSet.getString("schedule_date_string").trim())  ;
						taskResult_val[5] = checkForNull(resultSet.getString("Admin_Status"))  ;
						taskResult_val[6] = checkForNull(resultSet.getString("task_srl_no"))  ;
						taskResult_val[7] = checkForNull(resultSet.getString("ordering_pract_name"))  ;
						taskResult_val[8] = checkForNull(resultSet.getString("priority"))  ;
						taskResult_val[9] = checkForNull(resultSet.getString("stage_short_desc"))  ;
						taskResult_val[10] = checkForNull(resultSet.getString("position_code"))  ;
						taskResult_val[11] = checkForNull(resultSet.getString("status_desc"))  ;
						taskResult_val[12] = checkForNull(resultSet.getString("patient_name"))  ;
						taskResult_val[13] = checkForNull(resultSet.getString("age"))  ;
						taskResult_val[14] = checkForNull(resultSet.getString("sex"))  ;
						taskResult_val[15] = checkForNull(resultSet.getString("task_desc"))  ;
						taskResult_val[16] = checkForNull(resultSet.getString("Result_options"))  ;
						taskResult_val[17] = checkForNull(resultSet.getString("schedule_time_string").trim())  ;
						taskResult_val[18] = checkForNull(resultSet.getString("order_category_short_desc"))  ;
						taskResult_val[19] = checkForNull(resultSet.getString("order_id"))  ;
						taskResult_val[20] = checkForNull(resultSet.getString("encounter_id"))  ;
						taskResult_val[21] = checkForNull(resultSet.getString("patient_class"))  ;
						taskResult_val[22] = checkForNull(resultSet.getString("patient_id"))  ;
						taskResult_val[23] = checkForNull(resultSet.getString("order_category"))  ;
						taskResult_val[24] = checkForNull(resultSet.getString("order_status"))  ;
						taskResult_val[25] = checkForNull(resultSet.getString("order_line_num"))  ;
						taskResult_val[26] = checkForNull(resultSet.getString("performing_facility_id"))  ;
						taskResult_val[27] = checkForNull(resultSet.getString("performing_deptloc_type"))  ;
						taskResult_val[28] = checkForNull(resultSet.getString("performing_deptloc_code"))  ;
						taskResult_val[29] = checkForNull(resultSet.getString("int_or_ext"))  ;
						taskResult_val[30] = checkForNull(resultSet.getString("order_type_code"))  ;
						taskResult_val[31] = checkForNull(resultSet.getString("source_type"))  ;
						taskResult_val[32] = checkForNull(resultSet.getString("source_code"))  ;
						taskResult_val[33] = checkForNull(resultSet.getString("location_description"))  ;
						taskResult_val[34] = checkForNull(resultSet.getString("TASK_CATEG"))  ;
						taskResult_val[35] = checkForNull(resultSet.getString("RESULT_TYPE"))  ;
						taskResult_val[36] = checkForNull(resultSet.getString("RESULT_ID"))  ;
						taskResult_val[37] = checkForNull(resultSet.getString("cont_order_ind"))  ;
						taskResult_val[38] = checkForNull(resultSet.getString("APPT_REF_NUM"))  ;
						taskResult_val[39] = checkForNull(resultSet.getString("ord_pract_id"))  ;
						taskResult_val[40] = checkForNull(resultSet.getString("consent_status"))  ;
						taskResult_val[41] = checkForNull(resultSet.getString("order_set_id"))  ;
						taskResult_val[42] = checkForNull(resultSet.getString("SPECIMEN_NO"))  ;
						taskResult_val[43] = checkForNull(resultSet.getString("OPERATING_FACILITY_ID"))  ;
						taskResult_val[44] = checkForNull(resultSet.getString("UNIT_NO"))  ;
						taskResult_val[45] = checkForNull(resultSet.getString("PRODUCT_CODE"))  ;
						taskResult_val[46] = checkForNull(resultSet.getString("row_id"))  ;
						taskResult_val[47] = checkForNull(resultSet.getString("bt_status"))  ;
						taskResult_val[49] = checkForNull(resultSet.getString("dob"))  ;
						taskResult_val[50] = checkForNull(resultSet.getString("linked_note_accession_num"))  ;
						taskResult_val[51] = "" ;//IN030473
						taskResult_val[52] = checkForNull(resultSet.getString("ae_bed_no"))  ;//IN040761
						taskResult_val[53] = checkForNull(resultSet.getString("ae_pri_zone"))  ;//IN040761
						taskResult_val[54] = checkForNull(resultSet.getString("VISIT_STATUS"))   ;//IN041063
						taskResult_val[55] = checkForNull(resultSet.getString("ADT_STATUS"))   ;//IN041063
						taskResult_val[56] = checkForNull(resultSet.getString("prn_reg_ord"))   ;//IN065942
						taskResult_val[57] = "" ;//	IN071618
						taskResult_val[58] = "" ;//	26826
						taskResult.add(taskResult_val);
						start_tmp++;
					}
						if (resultSet.next())
						{
							String[] templist = (String[])taskResult.get(0);
							templist[48] = ""+(end+50);
							taskResult.set(0,templist);
						}
					}
					
					
					}
			//		}


			
					// PE Changes by Shaiju Ends
			}
			
			System.out.println("registerOrder========>761=================pattasklistrepository====>"+registerOrder);
			System.out.println("chkUnclassify========>762=================pattasklistrepository====>"+chkUnclassify);
			if(taskSelect.equals("R") || (taskSelect.equals("") && registerOrder.equals("CA_TASK_LIST_REGORD")) && chkUnclassify.equals("Y"))
			{
				//if(taskSelect.equals(""))
				//sql.append(" UNION ALL ");
			if(sql.length() > 0) sql.delete(0,sql.length());
			//IN040761 - commented
			//sql.append("SELECT 'R' TASK_CATEG, DECODE ('en',?, d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,TRUNC(b.ORD_DATE_TIME) start_date,to_char (b.ORD_DATE_TIME,'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (b.ORD_DATE_TIME, 'HH24:MI') schedule_time_string,b.order_type_code task_type,or_get_desc.or_order_type (b.order_type_code,?,'2') task_type_desc, or_get_order_catalog (b.order_id,b.order_type_code,?,'MD') task_desc,c.order_catalog_code task_code,TO_CHAR (b.ORD_DATE_TIME, 'DD/MM/YYYY') schedule_date_string,NULL task_srl_no,am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (b.order_status,?,'2') status_desc, get_age (d.date_of_birth) age, to_char(d.date_of_birth,'DD/MM/YYYY') dob, d.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_status order_status, or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,b.encounter_id encounter_id, e.patient_class patient_class,c.order_line_num order_line_num,b.performing_facility_id performing_facility_id,     b.performing_deptloc_type performing_deptloc_type,b.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext FROM or_performing_deptloc WHERE performing_facility_id = b.performing_facility_id  AND performing_deptloc_type = b.performing_deptloc_type  AND performing_deptloc_code = b.performing_deptloc_code) int_or_ext,'N' image_ref_yn, b.source_type source_type,b.source_code source_code, b.order_type_code order_type_code,b.order_id order_id, b.patient_id patient_id,'N|N|N|N|N|_|N|N|N|N|_|N|N|' result_options,CASE WHEN b.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(b.ordering_facility_id,                       b.source_code,?,'2') ELSE op_get_desc.op_clinic (b.ordering_facility_id,                                        b.source_code,?,'2') END location_description,NULL Admin_Status,null RESULT_TYPE ,null RESULT_ID,b.cont_order_ind,c.APPT_REF_NUM,b.ord_pract_id, nvl((SELECT ord_consent_status FROM or_order_line WHERE order_id = b.order_id AND ord_consent_reqd_yn = 'Y' AND ord_consent_status='P' and ROWNUM <=1),'N') consent_status,b.order_set_id  order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status FROM or_order b, or_order_line c, mp_patient d,pr_encounter e WHERE b.patient_id=e.patient_id and b.encounter_id= e.encounter_id and e.facility_id = b.performing_facility_id and b.order_id = c.order_id AND d.patient_id = b.patient_id  AND c.start_date_time BETWEEN TO_DATE (?,'dd/mm/yyyy')  AND   least(TRUNC(SYSDATE),TO_DATE (?, 'dd/mm/yyyy'))+ .99999 AND c.order_line_num=1 AND b.performing_facility_id=? AND B.ORD_DATE_TIME BETWEEN TO_DATE (?, 'dd/mm/yyyy')-30  AND   TO_DATE (?, 'dd/mm/yyyy')+ 30.99999 AND B.order_status IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = ?  AND a.order_status_type = b.order_status_type)   and nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR') AND (performing_appl_id IS NULL  OR performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE  NVL (result_entry, 'OR') = 'OR')) AND b.order_id = nvl((''),b.order_id) and exists (select order_id from or_order_line where order_id= b.order_id and (appt_ref_num is null or appt_ref_num is not null and trunc(sysdate) >= trunc(appt_date_time)) ) and b.Priority=nvl((''),b.Priority) and (performing_appl_id IS NULL  OR performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE  NVL (result_entry, 'OR') = 'OR')) AND substr(b.order_id,1,2)!='CS'  and OR_Check_resulting_YN(?,?, b.order_category,b.order_type_code,b.order_id,b.performing_facility_id,b.performing_deptloc_type,b.performing_deptloc_code) ='Y' and b.order_category!='PH' and (C.appt_ref_num is null or C.appt_ref_num is not null and trunc(sysdate) >= trunc(appt_date_time))  ");//Commented n modified --[IN033063]
						//IN040761 -> included ae_bed_no & ae_pri_zone
			//sql.append("SELECT 'R' TASK_CATEG, DECODE ('en',?, d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,TRUNC(b.ORD_DATE_TIME) start_date,to_char (b.ORD_DATE_TIME,'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (b.ORD_DATE_TIME, 'HH24:MI') schedule_time_string,b.order_type_code task_type,or_get_desc.or_order_type (b.order_type_code,?,'2') task_type_desc, or_get_order_catalog (b.order_id,b.order_type_code,?,'MD') task_desc,c.order_catalog_code task_code,TO_CHAR (b.ORD_DATE_TIME, 'DD/MM/YYYY') schedule_date_string,NULL task_srl_no,am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (b.order_status,?,'2') status_desc, get_age (d.date_of_birth) age, to_char(d.date_of_birth,'DD/MM/YYYY') dob, d.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_status order_status, or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,b.encounter_id encounter_id, e.patient_class patient_class,c.order_line_num order_line_num,b.performing_facility_id performing_facility_id,     b.performing_deptloc_type performing_deptloc_type,b.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext FROM or_performing_deptloc WHERE performing_facility_id = b.performing_facility_id  AND performing_deptloc_type = b.performing_deptloc_type  AND performing_deptloc_code = b.performing_deptloc_code) int_or_ext,'N' image_ref_yn, b.source_type source_type,b.source_code source_code, b.order_type_code order_type_code,b.order_id order_id, b.patient_id patient_id,'N|N|N|N|N|_|N|N|N|N|_|N|N|' result_options,CASE WHEN b.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(b.ordering_facility_id,                       b.source_code,?,'2') ELSE op_get_desc.op_clinic (b.ordering_facility_id,                                        b.source_code,?,'2') END location_description,NULL Admin_Status,null RESULT_TYPE ,null RESULT_ID,b.cont_order_ind,c.APPT_REF_NUM,b.ord_pract_id, nvl((SELECT ord_consent_status FROM or_order_line WHERE order_id = b.order_id AND ord_consent_reqd_yn = 'Y' AND ord_consent_status='P' and ROWNUM <=1),'N') consent_status,b.order_set_id  order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status, e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone FROM or_order b, or_order_line c, mp_patient d,pr_encounter e WHERE b.patient_id=e.patient_id and b.encounter_id= e.encounter_id and e.facility_id = b.performing_facility_id and b.order_id = c.order_id AND d.patient_id = b.patient_id  AND c.start_date_time BETWEEN TO_DATE (?,'dd/mm/yyyy')  AND   least(TRUNC(SYSDATE),TO_DATE (?, 'dd/mm/yyyy'))+ .99999 AND c.order_line_num=1 AND b.performing_facility_id=? AND B.ORD_DATE_TIME BETWEEN TO_DATE (?, 'dd/mm/yyyy')-30  AND   TO_DATE (?, 'dd/mm/yyyy')+ 30.99999 AND B.order_status IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = ?  AND a.order_status_type = b.order_status_type)   and nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR') AND (performing_appl_id IS NULL  OR performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE  NVL (result_entry, 'OR') = 'OR')) AND b.order_id = nvl((''),b.order_id) and exists (select order_id from or_order_line where order_id= b.order_id and (appt_ref_num is null or appt_ref_num is not null and trunc(sysdate) >= trunc(appt_date_time)) ) and b.Priority=nvl((''),b.Priority) and (performing_appl_id IS NULL  OR performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE  NVL (result_entry, 'OR') = 'OR')) AND substr(b.order_id,1,2)!='CS'  and OR_Check_resulting_YN(?,?, b.order_category,b.order_type_code,b.order_id,b.performing_facility_id,b.performing_deptloc_type,b.performing_deptloc_code) ='Y' and b.order_category!='PH' and (C.appt_ref_num is null or C.appt_ref_num is not null and trunc(sysdate) >= trunc(appt_date_time)) and ((c.billing_package_ref is null) or( (b.ord_date_time + (Select pkg_valid_days from bl_package_sub_hdr where package_seq_no = c.billing_package_ref) +(select NVL(valid_days_for_pkg_orders,'0') from bl_parameters where operating_facility_id = ?)) >= sysdate))  ");
			// Added by Uma on 6/26/2009 to Fix INCIDENT 11789
			//IN061903 start
			//sql.append("SELECT 'R' TASK_CATEG, DECODE ('en',?, d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,TRUNC(b.ORD_DATE_TIME) start_date,to_char (b.ORD_DATE_TIME,'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (b.ORD_DATE_TIME, 'HH24:MI') schedule_time_string,b.order_type_code task_type,or_get_desc.or_order_type (b.order_type_code,?,'2') task_type_desc, or_get_order_catalog (b.order_id,b.order_type_code,?,'MD') task_desc,c.order_catalog_code task_code,TO_CHAR (b.ORD_DATE_TIME, 'DD/MM/YYYY') schedule_date_string,NULL task_srl_no,am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (b.order_status,?,'2') status_desc, get_age (d.date_of_birth) age, to_char(d.date_of_birth,'DD/MM/YYYY') dob, d.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_status order_status, or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,b.encounter_id encounter_id, e.patient_class patient_class,c.order_line_num order_line_num,b.performing_facility_id performing_facility_id,     b.performing_deptloc_type performing_deptloc_type,b.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext FROM or_performing_deptloc WHERE performing_facility_id = b.performing_facility_id  AND performing_deptloc_type = b.performing_deptloc_type  AND performing_deptloc_code = b.performing_deptloc_code) int_or_ext,'N' image_ref_yn, b.source_type source_type,b.source_code source_code, b.order_type_code order_type_code,b.order_id order_id, b.patient_id patient_id,'N|N|N|N|N|_|N|N|N|N|_|N|N|' result_options,CASE WHEN b.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(b.ordering_facility_id,                       b.source_code,?,'2') ELSE op_get_desc.op_clinic (b.ordering_facility_id,                                        b.source_code,?,'2') END location_description,NULL Admin_Status,null RESULT_TYPE ,null RESULT_ID,b.cont_order_ind,c.APPT_REF_NUM,b.ord_pract_id, nvl((SELECT ord_consent_status FROM or_order_line WHERE order_id = b.order_id AND ord_consent_reqd_yn = 'Y' AND ord_consent_status='P' and ROWNUM <=1),'N') consent_status,b.order_set_id  order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status, e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone,e.VISIT_STATUS,e.adt_status FROM or_order b, or_order_line c, mp_patient d,pr_encounter e WHERE b.patient_id=e.patient_id and b.encounter_id= e.encounter_id and e.facility_id = b.performing_facility_id and b.order_id = c.order_id AND d.patient_id = b.patient_id  AND c.start_date_time BETWEEN TO_DATE (?,'dd/mm/yyyy')  AND   least(TRUNC(SYSDATE),TO_DATE (?, 'dd/mm/yyyy'))+ .99999 AND c.order_line_num=1 AND b.performing_facility_id=? AND B.ORD_DATE_TIME BETWEEN TO_DATE (?, 'dd/mm/yyyy')-30  AND   TO_DATE (?, 'dd/mm/yyyy')+ 30.99999 AND B.order_status IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = ?  AND a.order_status_type = b.order_status_type)   and nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR') AND (performing_appl_id IS NULL  OR performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE  NVL (result_entry, 'OR') = 'OR')) AND b.order_id = nvl((''),b.order_id) and exists (select order_id from or_order_line where order_id= b.order_id and (appt_ref_num is null or appt_ref_num is not null and trunc(sysdate) >= trunc(appt_date_time)) ) and b.Priority=nvl((''),b.Priority) and (performing_appl_id IS NULL  OR performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE  NVL (result_entry, 'OR') = 'OR')) AND substr(b.order_id,1,2)!='CS'  and OR_Check_resulting_YN(?,?, b.order_category,b.order_type_code,b.order_id,b.performing_facility_id,b.performing_deptloc_type,b.performing_deptloc_code) ='Y' and b.order_category!='PH' and (C.appt_ref_num is null or C.appt_ref_num is not null and trunc(sysdate) >= trunc(appt_date_time)) and ((c.billing_package_ref is null) or( (b.ord_date_time + (Select pkg_valid_days from bl_package_sub_hdr where package_seq_no = c.billing_package_ref) +(select NVL(valid_days_for_pkg_orders,'0') from bl_parameters where operating_facility_id = ?)) >= sysdate))  ");//IN041063
			//sql.append("SELECT 'R' TASK_CATEG, DECODE ('en',?, d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,TRUNC(b.ORD_DATE_TIME) start_date,to_char (b.ORD_DATE_TIME,'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (b.ORD_DATE_TIME, 'HH24:MI') schedule_time_string,b.order_type_code task_type,or_get_desc.or_order_type (b.order_type_code,?,'2') task_type_desc, or_get_order_catalog (b.order_id,b.order_type_code,?,'MD') task_desc,c.order_catalog_code task_code,TO_CHAR (b.ORD_DATE_TIME, 'DD/MM/YYYY') schedule_date_string,NULL task_srl_no,am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (b.order_status,?,'2') status_desc, get_age (d.date_of_birth) age, to_char(d.date_of_birth,'DD/MM/YYYY') dob, d.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_status order_status, or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,b.encounter_id encounter_id, e.patient_class patient_class,c.order_line_num order_line_num,b.performing_facility_id performing_facility_id,     b.performing_deptloc_type performing_deptloc_type,b.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext FROM or_performing_deptloc WHERE performing_facility_id = b.performing_facility_id  AND performing_deptloc_type = b.performing_deptloc_type  AND performing_deptloc_code = b.performing_deptloc_code) int_or_ext,'N' image_ref_yn, b.source_type source_type,b.source_code source_code, b.order_type_code order_type_code,b.order_id order_id, b.patient_id patient_id,'N|N|N|N|N|_|N|N|N|N|N|_|N|N|' result_options,CASE WHEN b.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(b.ordering_facility_id,                       b.source_code,?,'2') ELSE op_get_desc.op_clinic (b.ordering_facility_id,                                        b.source_code,?,'2') END location_description,NULL Admin_Status,null RESULT_TYPE ,null RESULT_ID,b.cont_order_ind,c.APPT_REF_NUM,b.ord_pract_id, nvl((SELECT ord_consent_status FROM or_order_line WHERE order_id = b.order_id AND ord_consent_reqd_yn = 'Y' AND ord_consent_status='P' and ROWNUM <=1),'N') consent_status,b.order_set_id  order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status, e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone,e.VISIT_STATUS,e.adt_status FROM or_order b, or_order_line c, mp_patient d,pr_encounter e WHERE b.patient_id=e.patient_id and b.encounter_id= e.encounter_id and e.facility_id = b.performing_facility_id and b.order_id = c.order_id AND d.patient_id = b.patient_id  AND c.start_date_time BETWEEN TO_DATE (?,'dd/mm/yyyy')  AND   least(TRUNC(SYSDATE),TO_DATE (?, 'dd/mm/yyyy'))+ .99999 AND c.order_line_num=1 AND b.performing_facility_id=? AND B.ORD_DATE_TIME BETWEEN TO_DATE (?, 'dd/mm/yyyy')-30  AND   TO_DATE (?, 'dd/mm/yyyy')+ 30.99999 AND B.order_status IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = ?  AND a.order_status_type = b.order_status_type)   and nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR') AND (performing_appl_id IS NULL  OR performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE  NVL (result_entry, 'OR') = 'OR')) AND b.order_id = nvl((''),b.order_id) and exists (select order_id from or_order_line where order_id= b.order_id and (appt_ref_num is null or appt_ref_num is not null and trunc(sysdate) >= trunc(appt_date_time)) ) and b.Priority=nvl((''),b.Priority) and (performing_appl_id IS NULL  OR performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE  NVL (result_entry, 'OR') = 'OR')) AND substr(b.order_id,1,2)!='CS'  and OR_Check_resulting_YN(?,?, b.order_category,b.order_type_code,b.order_id,b.performing_facility_id,b.performing_deptloc_type,b.performing_deptloc_code) ='Y' and b.order_category!='PH' and (C.appt_ref_num is null or C.appt_ref_num is not null and trunc(sysdate) >= trunc(appt_date_time)) and ((c.billing_package_ref is null) or( (b.ord_date_time + (Select pkg_valid_days from bl_package_sub_hdr where package_seq_no = c.billing_package_ref) +(select NVL(valid_days_for_pkg_orders,'0') from bl_parameters where operating_facility_id = ?)) >= sysdate))  ");//IN065942
			sql.append("SELECT 'R' TASK_CATEG, DECODE ('en',?, d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,TRUNC(b.ORD_DATE_TIME) start_date,to_char (b.ORD_DATE_TIME,'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (b.ORD_DATE_TIME, 'HH24:MI') schedule_time_string,b.order_type_code task_type,or_get_desc.or_order_type (b.order_type_code,?,'2') task_type_desc, or_get_order_catalog (b.order_id,b.order_type_code,?,'MD') task_desc,c.order_catalog_code task_code,TO_CHAR (b.ORD_DATE_TIME, 'DD/MM/YYYY') schedule_date_string,NULL task_srl_no,am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (b.order_status,?,'2') status_desc, get_age (d.date_of_birth) age, to_char(d.date_of_birth,'DD/MM/YYYY') dob, d.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_status order_status, or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,b.encounter_id encounter_id, e.patient_class patient_class,c.order_line_num order_line_num,b.performing_facility_id performing_facility_id,     b.performing_deptloc_type performing_deptloc_type,b.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext FROM or_performing_deptloc WHERE performing_facility_id = b.performing_facility_id  AND performing_deptloc_type = b.performing_deptloc_type  AND performing_deptloc_code = b.performing_deptloc_code) int_or_ext,'N' image_ref_yn, b.source_type source_type,b.source_code source_code, b.order_type_code order_type_code,b.order_id order_id, b.patient_id patient_id,'N|N|N|N|N|_|N|N|N|N|N|_|N|N|' result_options,CASE WHEN b.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(b.ordering_facility_id,                       b.source_code,?,'2') ELSE op_get_desc.op_clinic (b.ordering_facility_id,                                        b.source_code,?,'2') END location_description,NULL Admin_Status,null RESULT_TYPE ,null RESULT_ID,b.cont_order_ind,c.APPT_REF_NUM,b.ord_pract_id, nvl((SELECT ord_consent_status FROM or_order_line WHERE order_id = b.order_id AND ord_consent_reqd_yn = 'Y' AND ord_consent_status='P' and ROWNUM <=1),'N') consent_status,b.order_set_id  order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status, e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone,e.VISIT_STATUS,e.adt_status,case when c.order_category = 'RX' then nvl((select prn_regd_ord from or_order_catalog where order_catalog_code in(select order_catalog_code from or_order_line where order_id = b.order_id) and prn_regd_ord = 'Y' and rownum=1),'N') else 'N' end prn_reg_ord,or_reg_split_unbilled_order_yn(?,b.order_id,b.patient_id,b.encounter_id) split_unbilled_order_dtls FROM or_order b, or_order_line c, mp_patient d,pr_encounter e WHERE b.patient_id=e.patient_id and b.encounter_id= e.encounter_id and e.facility_id = b.performing_facility_id and b.order_id = c.order_id AND d.patient_id = b.patient_id  AND c.start_date_time BETWEEN TO_DATE (?,'dd/mm/yyyy')  AND   least(TRUNC(SYSDATE),TO_DATE (?, 'dd/mm/yyyy'))+ .99999 AND c.order_line_num=1 AND b.performing_facility_id=? AND B.ORD_DATE_TIME BETWEEN TO_DATE (?, 'dd/mm/yyyy')-30  AND   TO_DATE (?, 'dd/mm/yyyy')+ 30.99999 AND B.order_status IN (SELECT order_status_code  FROM or_order_status_code a, or_status_applicability b WHERE b.oper_or_group_ref = ?  AND a.order_status_type = b.order_status_type)   and nvl(b.cont_order_ind,'DO') in ('DO','DR','CO','CR') AND (performing_appl_id IS NULL  OR performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE  NVL (result_entry, 'OR') = 'OR')) AND b.order_id = nvl((''),b.order_id) and exists (select order_id from or_order_line where order_id= b.order_id and (appt_ref_num is null or appt_ref_num is not null and trunc(sysdate) >= trunc(appt_date_time)) ) and b.Priority=nvl((''),b.Priority) and (performing_appl_id IS NULL  OR performing_appl_id IN ( SELECT ext_image_appl_id FROM ca_ext_image_appl WHERE  NVL (result_entry, 'OR') = 'OR')) AND substr(b.order_id,1,2)!='CS'  and OR_Check_resulting_YN(?,?, b.order_category,b.order_type_code,b.order_id,b.performing_facility_id,b.performing_deptloc_type,b.performing_deptloc_code) ='Y' and b.order_category!='PH' and (C.appt_ref_num is null or C.appt_ref_num is not null and trunc(sysdate) >= trunc(appt_date_time)) and ((c.billing_package_ref is null) or( (b.ord_date_time + (Select pkg_valid_days from bl_package_sub_hdr where package_seq_no = c.billing_package_ref) +(select NVL(valid_days_for_pkg_orders,'0') from bl_parameters where operating_facility_id = ?)) >= sysdate))  ");//IN065942// Added split_unbilled_order_dtls for IN071618
			//IN061903 ends
			//Commented as part of IN31901
			/*if (OTinstalled.equalsIgnoreCase("Y"))
			{
				sql.append(" and substr(b.order_id,1,2)!='OT'" );
			}
			else */
			if(RDinstalled.equalsIgnoreCase("Y"))
			{
				sql.append(" and substr(b.order_id,1,2)!='RD'" );
			}
			//IN058250 Start
		/*	if (access_previlage.equals("X"))
			{
				sql.append(" and b.ORDER_TYPE_CODE in (Select ORDER_TYPE_CODE from or_order_type b where exists(select 1 from or_result_user a where a.ORDER_TYPE_CODE  = b.ORDER_TYPE_CODE  AND practitioner_id = ?))");
			}else{
				sql.append(" and b.order_category in (Select Order_category from or_order_category b where exists(select 1 from or_result_user a where a.order_category  = b.order_category  AND resp_id = ?)) ");
			}*/
			//end
			sql.append(" and ((b.order_category in (Select Order_category from or_order_category b where exists(select 1 from or_result_user a where a.order_category  = b.order_category AND(practitioner_id = ? OR resp_id = ?)AND order_type_code='*ALL'))OR(b.ORDER_TYPE_CODE in (Select ORDER_TYPE_CODE from or_order_type b where exists(select 1 from or_result_user a where a.ORDER_TYPE_CODE  = b.ORDER_TYPE_CODE  AND( practitioner_id = ? OR resp_id = ?)))))) ");
			//IN058250 End
			if(patient_id.equals(""))
				sql.append("and b.patient_id like ? ");
			else
				sql.append("and b.patient_id = ? ");


			if(location_type.equals(""))
			{
				sql.append("AND  e.ASSIGN_CARE_LOCN_TYPE like ? ");
			}
			else
			{
				if(location_type.equals("C"))
				{
					sql.append("AND  e.ASSIGN_CARE_LOCN_TYPE in ('C','E') ");
				}
				else
				{
					sql.append("AND  e.ASSIGN_CARE_LOCN_TYPE=? ");
				}
			}

			if(locn_code.equals(""))
			sql.append("AND  e.ASSIGN_CARE_LOCN_CODE like ? ");
			else
			sql.append("AND  e.ASSIGN_CARE_LOCN_CODE=? ");

			if(OrderCategory.equals(""))
			sql.append("AND  B.ORDER_CATEGORY like ? ");
			else
			sql.append("AND  B.ORDER_CATEGORY=? ");

			if(OrderType.equals(""))
			sql.append("AND  B.ORDER_TYPE_CODE like ? ");
			else
			sql.append("AND  B.ORDER_TYPE_CODE=? ");
			// IN31901 Starts
		
				sql.append("  AND decode(b.order_category,'OT',performing_deptloc_CODE,'X') IS NOT NULL ");
			
			// IN31901 Ends
			// PE Changes by Shaiju starts

		//	if( (taskSelect.equals("") && registerOrder.equals("CA_TASK_LIST_REGORD")) && chkUnclassify.equals("Y"))
			//{
			
				if(!(sql.toString()).equals(""))
				{
					if (Groupby.equals("P"))
					{
						sql.append("ORDER BY 2, b.patient_id,3 DESC, 5 ASC ");
					}else if (Groupby.equals("T"))
					{
						sql.append("ORDER BY  3 DESC, 5 ASC, 2 ");
					}
					pstmt = connection.prepareStatement(sql.toString()) ;
					System.out.println("sql.toString()========>850=============pattasklistrepository====>"+sql.toString());
					i=0;
					
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
				//	pstmt.setString( 5, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, facilityId);//IN071618
					pstmt.setString( ++i, From_date);
					pstmt.setString( ++i, To_date);
					pstmt.setString( ++i, facilityId);
					pstmt.setString( ++i, From_date);
					pstmt.setString( ++i, To_date);
					pstmt.setString( ++i, "REGISTER_ORD");
					pstmt.setString( ++i, resultvalue);
					pstmt.setString( ++i, resultby);
					pstmt.setString( ++i, facilityId);//--[IN033063]
					//IN058250 Start
					//if (access_previlage.equals("X"))
				//	{
						pstmt.setString(++i,practitioner_id);
					//}
				//	else
				//	{
						pstmt.setString(++i,resp_id);
						pstmt.setString(++i,practitioner_id);
						pstmt.setString(++i,resp_id);
					//}
					//IN058250 End
					if(patient_id.equals(""))
					pstmt.setString( ++i, ALL);
					else
					pstmt.setString( ++i, patient_id);
					if(location_type.equals(""))
					{
						pstmt.setString( ++i, ALL);
					}
					else
					{
						if(!location_type.equals("C"))
						{
							pstmt.setString( ++i, location_type);
						}
					}
					if(locn_code.equals(""))
					pstmt.setString( ++i, ALL);
					else
					pstmt.setString( ++i, locn_code);

					if(OrderCategory.equals(""))
					pstmt.setString( ++i, ALL );
					else
					pstmt.setString( ++i, OrderCategory);

					if(OrderType.equals(""))
					pstmt.setString( ++i,ALL );
					else
					pstmt.setString( ++i, OrderType);
					resultSet = pstmt.executeQuery() ;
					
					
					if(resultSet!=null) {
						if(start > 0)
						{
							for(k=0;(k<start-1 && resultSet.next());k++);
							start = start-k;
						}
						while ( start_tmp <= end && resultSet!=null && resultSet.next()) {
					//while ( resultSet != null && resultSet.next() ) {
						/**
						Modified by Deepa on 5/17/2010 at 12:08 PM for IN021020
						increased the size of taskResult_val to 50 from 49, to include dob in the array
						**/
						//String[] taskResult_val 			= new String[51];
						//String[] taskResult_val 			= new String[54]; //IN030473	[IN040761 --> increased to 54 from 52]
						//String[] taskResult_val 			= new String[56]; //IN041063	[IN041063 --> increased to 56 from 54]//IN065942
						//String[] taskResult_val 			= new String[58]; //IN041063	[IN041063 --> increased to 56 from 54]//IN065942//IN071618
						String[] taskResult_val 			= new String[59]; //26826
						taskResult_val[0] = checkForNull(resultSet.getString("task_type"))  ;
						taskResult_val[1] = checkForNull(resultSet.getString("task_type_desc").trim())  ;
						taskResult_val[2] = checkForNull(resultSet.getString("task_code"))  ;
						taskResult_val[3] = checkForNull(resultSet.getString("schedule_date").trim())  ;
						taskResult_val[4] = checkForNull(resultSet.getString("schedule_date_string").trim())  ;
						taskResult_val[5] = checkForNull(resultSet.getString("Admin_Status"))  ;
						taskResult_val[6] = checkForNull(resultSet.getString("task_srl_no"))  ;
						taskResult_val[7] = checkForNull(resultSet.getString("ordering_pract_name"))  ;
						taskResult_val[8] = checkForNull(resultSet.getString("priority"))  ;
						taskResult_val[9] = checkForNull(resultSet.getString("stage_short_desc"))  ;
						taskResult_val[10] = checkForNull(resultSet.getString("position_code"))  ;
						taskResult_val[11] = checkForNull(resultSet.getString("status_desc"))  ;
						taskResult_val[12] = checkForNull(resultSet.getString("patient_name"))  ;
						taskResult_val[13] = checkForNull(resultSet.getString("age"))  ;
						taskResult_val[14] = checkForNull(resultSet.getString("sex"))  ;
						taskResult_val[15] = checkForNull(resultSet.getString("task_desc"))  ;
						taskResult_val[16] = checkForNull(resultSet.getString("Result_options"))  ;
						taskResult_val[17] = checkForNull(resultSet.getString("schedule_time_string").trim())  ;
						taskResult_val[18] = checkForNull(resultSet.getString("order_category_short_desc"))  ;
						taskResult_val[19] = checkForNull(resultSet.getString("order_id"))  ;
						taskResult_val[20] = checkForNull(resultSet.getString("encounter_id"))  ;
						taskResult_val[21] = checkForNull(resultSet.getString("patient_class"))  ;
						taskResult_val[22] = checkForNull(resultSet.getString("patient_id"))  ;
						taskResult_val[23] = checkForNull(resultSet.getString("order_category"))  ;
						taskResult_val[24] = checkForNull(resultSet.getString("order_status"))  ;
						taskResult_val[25] = checkForNull(resultSet.getString("order_line_num"))  ;
						taskResult_val[26] = checkForNull(resultSet.getString("performing_facility_id"))  ;
						taskResult_val[27] = checkForNull(resultSet.getString("performing_deptloc_type"))  ;
						taskResult_val[28] = checkForNull(resultSet.getString("performing_deptloc_code"))  ;
						taskResult_val[29] = checkForNull(resultSet.getString("int_or_ext"))  ;
						taskResult_val[30] = checkForNull(resultSet.getString("order_type_code"))  ;
						taskResult_val[31] = checkForNull(resultSet.getString("source_type"))  ;
						taskResult_val[32] = checkForNull(resultSet.getString("source_code"))  ;
						taskResult_val[33] = checkForNull(resultSet.getString("location_description"))  ;
						taskResult_val[34] = checkForNull(resultSet.getString("TASK_CATEG"))  ;
						taskResult_val[35] = checkForNull(resultSet.getString("RESULT_TYPE"))  ;
						taskResult_val[36] = checkForNull(resultSet.getString("RESULT_ID"))  ;
						taskResult_val[37] = checkForNull(resultSet.getString("cont_order_ind"))  ;
						taskResult_val[38] = checkForNull(resultSet.getString("APPT_REF_NUM"))  ;
						taskResult_val[39] = checkForNull(resultSet.getString("ord_pract_id"))  ;
						taskResult_val[40] = checkForNull(resultSet.getString("consent_status"))  ;
						taskResult_val[41] = checkForNull(resultSet.getString("order_set_id"))  ;
						taskResult_val[42] = checkForNull(resultSet.getString("SPECIMEN_NO"))  ;
						taskResult_val[43] = checkForNull(resultSet.getString("OPERATING_FACILITY_ID"))  ;
						taskResult_val[44] = checkForNull(resultSet.getString("UNIT_NO"))  ;
						taskResult_val[45] = checkForNull(resultSet.getString("PRODUCT_CODE"))  ;
						taskResult_val[46] = checkForNull(resultSet.getString("row_id"))  ;
						taskResult_val[47] = checkForNull(resultSet.getString("bt_status"))  ;
						taskResult_val[49] = checkForNull(resultSet.getString("dob"))  ;
						taskResult_val[50] = ""  ;
						taskResult_val[51] = ""  ;//IN030473
						taskResult_val[52] = checkForNull(resultSet.getString("ae_bed_no"))  ;//IN040761
						taskResult_val[53] = checkForNull(resultSet.getString("ae_pri_zone"))   ;//IN040761
						taskResult_val[54] = checkForNull(resultSet.getString("VISIT_STATUS"))   ;//IN041063
						taskResult_val[55] = checkForNull(resultSet.getString("ADT_STATUS"))   ;//IN041063
						taskResult_val[56] = checkForNull(resultSet.getString("prn_reg_ord"))   ;//IN065942
						taskResult_val[57] = checkForNull(resultSet.getString("split_unbilled_order_dtls"))   ;//IN071618
						taskResult_val[58] = "" ;//	26826
						taskResult.add(taskResult_val);
						start_tmp++;

					}
						if (resultSet.next())
						{
							String[] templist = (String[])taskResult.get(0);
							templist[48] = ""+(end+50);
							taskResult.set(0,templist);
						}
					}
					
				
				
				
				}


		//	}
			// PE Changes by Shaiju ends

			}

			System.out.println("intervention========>1014=================pattasklistrepository====>"+intervention);
			if(taskSelect.equals("I") || (taskSelect.equals("") && intervention.equals("CA_TASK_LIST_INT")))
			{

			//	if(taskSelect.equals(""))
			//	sql.append(" UNION ALL ");
				if(sql.length() > 0) sql.delete(0,sql.length());
				
				//IN040761 - commented
				//sql.append("SELECT  'I' TASK_CATEG ,DECODE ('en',?, C.patient_name,NVL (C.patient_name_loc_lang, C.patient_name)) patient_name,TRUNC(A.SCHEDULE_DATETIME) start_date,to_char (A.SCHEDULE_DATETIME,'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (A.SCHEDULE_DATETIME, 'HH24:MI') schedule_time_string,A.TASK_TYPE task_type,CA_get_desc.CA_INTERVENTION_TYPE (A.TASK_TYPE,?,'2') task_type_desc,CA_get_desc.CA_INTERVENTION (A.TASK_CODE,?,'2') task_desc,A.TASK_CODE task_code,        TO_CHAR (A.SCHEDULE_DATETIME, 'DD/MM/YYYY') schedule_date_string,A.TASK_SRL_NO task_srl_no,NULL ordering_pract_name,nvl(A.PRIORITY,'R') priority, NULL stage_short_desc, NULL position_code,decode(nvl(A.Status,'O'),'O','Pending','P','Performed','N','Not Performed','D','Discontinued', '9','Cancelled')  status_desc,get_age (C.date_of_birth) age, to_char(C.date_of_birth,'DD/MM/YYYY') dob, C.sex sex,nvl(A.PRIORITY,'R') priority, 'CP' order_category,nvl(A.Status,'O') order_status,'Care plan' order_category_short_desc,a.encounter_id encounter_id,E.patient_class patient_class,null order_line_num,A.FACILITY_ID performing_facility_id,null performing_deptloc_type,null performing_deptloc_code,null int_or_ext,'N' image_ref_yn,null source_type , null source_code, null order_type_code,null order_id, a.patient_id patient_id,  null result_options,null location_description,case when nvl(A.Status,'O') in ('P','N') then 'C'	 WHEN A.SCHEDULE_DATETIME>sysdate+.0208 then 'F' when A.SCHEDULE_DATETIME>sysdate  then 'D'  when (CASE WHEN e.PATIENT_CLASS IN ('IP','DC') AND (e.DISCHARGE_DATE_TIME IS NULL OR e.DISCHARGE_DATE_TIME > SYSDATE - (select Id.CUT_OFF_DAYS from ca_transription_req ia, ca_note_type ic, ca_note_group id where ia.REQ_ACCESSION_NUM = a.REQ_ACCESSION_NUM and ia.NOTE_TYPE = ic.note_type and id.note_group = ic.note_group_id and rownum=1 ))  THEN  'Y' WHEN  e.VISIT_ADM_DATE_TIME > SYSDATE - (select Id.CUT_OFF_DAYS from ca_transription_req Ia, ca_pat_task_list Ib, ca_note_type Ic, ca_note_group Id where Ib.REQ_ACCESSION_NUM = a.REQ_ACCESSION_NUM and Ia.NOTE_TYPE = Ic.note_type and Id.note_group = Ic.note_group_id and rownum=1 ) THEN 'Y' ELSE 'N' END)='N' then 'E' else 'O' END Admin_Status,B.RESULT_TYPE ,B.RESULT_ID,null cont_order_ind,null APPT_REF_NUM,null ord_pract_id, NULL consent_status,null order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status,B.CONSENT_FORM_ID consentFromId FROM MP_PATIENT C, PR_ENCOUNTER E, CA_PAT_TASK_LIST A  ,CA_INTERVENTION B ,CA_INTERVENTION_TYPE D WHERE    A.FACILITY_ID =E.FACILITY_ID AND A.ENCOUNTER_ID=E.ENCOUNTER_ID AND D.INTERVENTION_TYPE = A.TASK_TYPE   AND B.INTERVENTION_CODE =  A.TASK_CODE  AND C.PATIENT_ID = A.PATIENT_ID  AND A.FACILITY_ID = ?  AND A.SCHEDULE_DATETIME BETWEEN TO_DATE(rtrim(?),'DD/MM/YYYY') AND TO_DATE(rtrim(?),'DD/MM/YYYY')+.9999 AND a.status in ('O','P','N' ) and nvl(PERFORMED_BY_ID,'*' ) in ('*',?) ");

				//IN040761 - added ae_bed_no & ae_pri_zone
				//sql.append("SELECT  'I' TASK_CATEG ,DECODE ('en',?, C.patient_name,NVL (C.patient_name_loc_lang, C.patient_name)) patient_name,TRUNC(A.SCHEDULE_DATETIME) start_date,to_char (A.SCHEDULE_DATETIME,'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (A.SCHEDULE_DATETIME, 'HH24:MI') schedule_time_string,A.TASK_TYPE task_type,CA_get_desc.CA_INTERVENTION_TYPE (A.TASK_TYPE,?,'2') task_type_desc,CA_get_desc.CA_INTERVENTION (A.TASK_CODE,?,'2') task_desc,A.TASK_CODE task_code,        TO_CHAR (A.SCHEDULE_DATETIME, 'DD/MM/YYYY') schedule_date_string,A.TASK_SRL_NO task_srl_no,NULL ordering_pract_name,nvl(A.PRIORITY,'R') priority, NULL stage_short_desc, NULL position_code,decode(nvl(A.Status,'O'),'O','Pending','P','Performed','N','Not Performed','D','Discontinued', '9','Cancelled')  status_desc,get_age (C.date_of_birth) age, to_char(C.date_of_birth,'DD/MM/YYYY') dob, C.sex sex,nvl(A.PRIORITY,'R') priority, 'CP' order_category,nvl(A.Status,'O') order_status,'Care plan' order_category_short_desc,a.encounter_id encounter_id,E.patient_class patient_class,null order_line_num,A.FACILITY_ID performing_facility_id,null performing_deptloc_type,null performing_deptloc_code,null int_or_ext,'N' image_ref_yn,null source_type , null source_code, null order_type_code,null order_id, a.patient_id patient_id,  null result_options,null location_description,case when nvl(A.Status,'O') in ('P','N') then 'C'	 WHEN A.SCHEDULE_DATETIME>sysdate+.0208 then 'F' when A.SCHEDULE_DATETIME>sysdate  then 'D'  when (CASE WHEN e.PATIENT_CLASS IN ('IP','DC') AND (e.DISCHARGE_DATE_TIME IS NULL OR e.DISCHARGE_DATE_TIME > SYSDATE - (select Id.CUT_OFF_DAYS from ca_transription_req ia, ca_note_type ic, ca_note_group id where ia.REQ_ACCESSION_NUM = a.REQ_ACCESSION_NUM and ia.NOTE_TYPE = ic.note_type and id.note_group = ic.note_group_id and rownum=1 ))  THEN  'Y' WHEN  e.VISIT_ADM_DATE_TIME > SYSDATE - (select Id.CUT_OFF_DAYS from ca_transription_req Ia, ca_pat_task_list Ib, ca_note_type Ic, ca_note_group Id where Ib.REQ_ACCESSION_NUM = a.REQ_ACCESSION_NUM and Ia.NOTE_TYPE = Ic.note_type and Id.note_group = Ic.note_group_id and rownum=1 ) THEN 'Y' ELSE 'N' END)='N' then 'E' else 'O' END Admin_Status,B.RESULT_TYPE ,B.RESULT_ID,null cont_order_ind,null APPT_REF_NUM,null ord_pract_id, NULL consent_status,null order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status,B.CONSENT_FORM_ID consentFromId ,  e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone FROM MP_PATIENT C, PR_ENCOUNTER E, CA_PAT_TASK_LIST A  ,CA_INTERVENTION B ,CA_INTERVENTION_TYPE D WHERE    A.FACILITY_ID =E.FACILITY_ID AND A.ENCOUNTER_ID=E.ENCOUNTER_ID AND D.INTERVENTION_TYPE = A.TASK_TYPE   AND B.INTERVENTION_CODE =  A.TASK_CODE  AND C.PATIENT_ID = A.PATIENT_ID  AND A.FACILITY_ID = ?  AND A.SCHEDULE_DATETIME BETWEEN TO_DATE(rtrim(?),'DD/MM/YYYY') AND TO_DATE(rtrim(?),'DD/MM/YYYY')+.9999 AND a.status in ('O','P','N' ) and nvl(PERFORMED_BY_ID,'*' ) in ('*',?) ");
				//sql.append("SELECT  'I' TASK_CATEG ,DECODE ('en',?, C.patient_name,NVL (C.patient_name_loc_lang, C.patient_name)) patient_name,TRUNC(A.SCHEDULE_DATETIME) start_date,to_char (A.SCHEDULE_DATETIME,'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (A.SCHEDULE_DATETIME, 'HH24:MI') schedule_time_string,A.TASK_TYPE task_type,CA_get_desc.CA_INTERVENTION_TYPE (A.TASK_TYPE,?,'2') task_type_desc,CA_get_desc.CA_INTERVENTION (A.TASK_CODE,?,'2') task_desc,A.TASK_CODE task_code,        TO_CHAR (A.SCHEDULE_DATETIME, 'DD/MM/YYYY') schedule_date_string,A.TASK_SRL_NO task_srl_no,NULL ordering_pract_name,nvl(A.PRIORITY,'R') priority, NULL stage_short_desc, NULL position_code,decode(nvl(A.Status,'O'),'O','Pending','P','Performed','N','Not Performed','D','Discontinued', '9','Cancelled')  status_desc,get_age (C.date_of_birth) age, to_char(C.date_of_birth,'DD/MM/YYYY') dob, C.sex sex,nvl(A.PRIORITY,'R') priority, 'CP' order_category,nvl(A.Status,'O') order_status,'Care plan' order_category_short_desc,a.encounter_id encounter_id,E.patient_class patient_class,null order_line_num,A.FACILITY_ID performing_facility_id,null performing_deptloc_type,null performing_deptloc_code,null int_or_ext,'N' image_ref_yn,null source_type , null source_code, null order_type_code,null order_id, a.patient_id patient_id,  null result_options,null location_description,case when nvl(A.Status,'O') in ('P','N') then 'C'	 WHEN A.SCHEDULE_DATETIME>sysdate+.0208 then 'F' when A.SCHEDULE_DATETIME>sysdate  then 'D'  when (CASE WHEN e.PATIENT_CLASS IN ('IP','DC') AND (e.DISCHARGE_DATE_TIME IS NULL OR e.DISCHARGE_DATE_TIME > SYSDATE - (select Id.CUT_OFF_DAYS from ca_transription_req ia, ca_note_type ic, ca_note_group id where ia.REQ_ACCESSION_NUM = a.REQ_ACCESSION_NUM and ia.NOTE_TYPE = ic.note_type and id.note_group = ic.note_group_id and rownum=1 ))  THEN  'Y' WHEN  e.VISIT_ADM_DATE_TIME > SYSDATE - (select Id.CUT_OFF_DAYS from ca_transription_req Ia, ca_pat_task_list Ib, ca_note_type Ic, ca_note_group Id where Ib.REQ_ACCESSION_NUM = a.REQ_ACCESSION_NUM and Ia.NOTE_TYPE = Ic.note_type and Id.note_group = Ic.note_group_id and rownum=1 ) THEN 'Y' ELSE 'N' END)='N' then 'E' else 'O' END Admin_Status,B.RESULT_TYPE ,B.RESULT_ID,null cont_order_ind,null APPT_REF_NUM,null ord_pract_id, NULL consent_status,null order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status,B.CONSENT_FORM_ID consentFromId ,  e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone,e.VISIT_STATUS,e.adt_status FROM MP_PATIENT C, PR_ENCOUNTER E, CA_PAT_TASK_LIST A  ,CA_INTERVENTION B ,CA_INTERVENTION_TYPE D WHERE    A.FACILITY_ID =E.FACILITY_ID AND A.ENCOUNTER_ID=E.ENCOUNTER_ID AND D.INTERVENTION_TYPE = A.TASK_TYPE   AND B.INTERVENTION_CODE =  A.TASK_CODE  AND C.PATIENT_ID = A.PATIENT_ID  AND A.FACILITY_ID = ?  AND A.SCHEDULE_DATETIME BETWEEN TO_DATE(rtrim(?),'DD/MM/YYYY') AND TO_DATE(rtrim(?),'DD/MM/YYYY')+.9999 AND a.status in ('O','P','N' ) and nvl(PERFORMED_BY_ID,'*' ) in ('*',?) ");//IN041063//IN065942
				sql.append("SELECT  'I' TASK_CATEG ,DECODE ('en',?, C.patient_name,NVL (C.patient_name_loc_lang, C.patient_name)) patient_name,TRUNC(A.SCHEDULE_DATETIME) start_date,to_char (A.SCHEDULE_DATETIME,'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (A.SCHEDULE_DATETIME, 'HH24:MI') schedule_time_string,A.TASK_TYPE task_type,CA_get_desc.CA_INTERVENTION_TYPE (A.TASK_TYPE,?,'2') task_type_desc,CA_get_desc.CA_INTERVENTION (A.TASK_CODE,?,'2') task_desc,A.TASK_CODE task_code,        TO_CHAR (A.SCHEDULE_DATETIME, 'DD/MM/YYYY') schedule_date_string,A.TASK_SRL_NO task_srl_no,NULL ordering_pract_name,nvl(A.PRIORITY,'R') priority, NULL stage_short_desc, NULL position_code,decode(nvl(A.Status,'O'),'O','Pending','P','Performed','N','Not Performed','D','Discontinued', '9','Cancelled')  status_desc,get_age (C.date_of_birth) age, to_char(C.date_of_birth,'DD/MM/YYYY') dob, C.sex sex,nvl(A.PRIORITY,'R') priority, 'CP' order_category,nvl(A.Status,'O') order_status,'Care plan' order_category_short_desc,a.encounter_id encounter_id,E.patient_class patient_class,null order_line_num,A.FACILITY_ID performing_facility_id,null performing_deptloc_type,null performing_deptloc_code,null int_or_ext,'N' image_ref_yn,null source_type , null source_code, null order_type_code,null order_id, a.patient_id patient_id,  null result_options,null location_description,case when nvl(A.Status,'O') in ('P','N') then 'C'	 WHEN A.SCHEDULE_DATETIME>sysdate+.0208 then 'F' when A.SCHEDULE_DATETIME>sysdate  then 'D'  when (CASE WHEN e.PATIENT_CLASS IN ('IP','DC') AND (e.DISCHARGE_DATE_TIME IS NULL OR e.DISCHARGE_DATE_TIME > SYSDATE - (select Id.CUT_OFF_DAYS from ca_transription_req ia, ca_note_type ic, ca_note_group id where ia.REQ_ACCESSION_NUM = a.REQ_ACCESSION_NUM and ia.NOTE_TYPE = ic.note_type and id.note_group = ic.note_group_id and rownum=1 ))  THEN  'Y' WHEN  ( e.discharge_date_time IS NULL OR e.visit_adm_date_time > SYSDATE - (select Id.CUT_OFF_DAYS from ca_transription_req Ia, ca_pat_task_list Ib, ca_note_type Ic, ca_note_group Id where Ib.REQ_ACCESSION_NUM = a.REQ_ACCESSION_NUM and Ia.NOTE_TYPE = Ic.note_type and Id.note_group = Ic.note_group_id and rownum=1 )) THEN 'Y' ELSE 'N' END)='N' then 'E' else 'O' END Admin_Status,B.RESULT_TYPE ,B.RESULT_ID,null cont_order_ind,null APPT_REF_NUM,null ord_pract_id, NULL consent_status,null order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status,B.CONSENT_FORM_ID consentFromId ,  e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone,e.VISIT_STATUS,e.adt_status,'N' prn_reg_ord, (CASE WHEN b.result_type='OR' THEN (select ORDER_CATEGORY from OR_ORDER_CATALOG  where order_catalog_code= b.result_id) ELSE '' END) orderCatagory FROM MP_PATIENT C, PR_ENCOUNTER E, CA_PAT_TASK_LIST A  ,CA_INTERVENTION B ,CA_INTERVENTION_TYPE D WHERE    A.FACILITY_ID =E.FACILITY_ID AND A.ENCOUNTER_ID=E.ENCOUNTER_ID AND D.INTERVENTION_TYPE = A.TASK_TYPE   AND B.INTERVENTION_CODE =  A.TASK_CODE  AND C.PATIENT_ID = A.PATIENT_ID  AND A.FACILITY_ID = ?  AND A.SCHEDULE_DATETIME BETWEEN TO_DATE(rtrim(?),'DD/MM/YYYY') AND TO_DATE(rtrim(?),'DD/MM/YYYY')+.9999 AND a.status in ('O','P','N' ) and nvl(PERFORMED_BY_ID,'*' ) in ('*',?) ");//IN041063//IN065942
				if(patient_id.equals(""))
					sql.append("and a.patient_id like ? ");
				else
					sql.append("and a.patient_id = ? ");

				if(!location_type.equals(""))
					sql.append("AND  E.ASSIGN_CARE_LOCN_TYPE=? ");

				if(!locn_code.equals(""))
					sql.append("AND  E.ASSIGN_CARE_LOCN_CODE=? ");

				if(definition.equals("S"))
					sql.append("AND  D.SYSTEM_DEFINED_YN = 'Y' ");
				else if(definition.equals("U"))
					sql.append("AND  D.SYSTEM_DEFINED_YN = 'N' ");

				if(!interventionType.equals(""))
					sql.append("AND  D.INTERVENTION_TYPE = ? ");

				if(chkFuture.equals("N") && chkElapsed.equals("N") && ckhDue.equals("N") && chkOverdue.equals("N") && chkPerformed.equals("N"))
				{
					sql.append(" and 1 = 2 ");
				}
				else
				{
					String Admin_Status_str="";

					if (chkFuture.equals("Y") )
					{
						Admin_Status_str="'F'";
					}
					if (chkElapsed.equals("Y"))
					{
						if (!Admin_Status_str.equals(""))
						{
							Admin_Status_str=Admin_Status_str+",";
						}
						Admin_Status_str=Admin_Status_str+"'E'";
					}
					if (ckhDue.equals("Y") )
					{
						if (!Admin_Status_str.equals(""))
						{
							Admin_Status_str=Admin_Status_str+",";
						}
						Admin_Status_str=Admin_Status_str+"'D'";
					}
					if (chkOverdue.equals("Y") )
					{
						if (!Admin_Status_str.equals(""))
						{
							Admin_Status_str=Admin_Status_str+",";
						}
						Admin_Status_str=Admin_Status_str+"'O'";
					}
					if (chkPerformed.equals("Y") )
					{
						if (!Admin_Status_str.equals(""))
						{
							Admin_Status_str=Admin_Status_str+",";
						}
						Admin_Status_str=Admin_Status_str+"'C'";

					}

					if (chkFuture.equals("Y") || chkElapsed.equals("Y") || ckhDue.equals("Y") || chkOverdue.equals("Y") || chkPerformed.equals("Y"))
						sql.append(" and ((case when nvl(A.Status,'O') in ('P','N') then 'C'	 WHEN A.SCHEDULE_DATETIME>sysdate+.0208 then 'F' when A.SCHEDULE_DATETIME>sysdate  then 'D'  when (CASE WHEN e.PATIENT_CLASS IN ('IP','DC') AND (e.DISCHARGE_DATE_TIME IS NULL OR e.DISCHARGE_DATE_TIME > SYSDATE - (select Id.CUT_OFF_DAYS from ca_transription_req ia, ca_note_type ic, ca_note_group id where ia.REQ_ACCESSION_NUM = a.REQ_ACCESSION_NUM and ia.NOTE_TYPE = ic.note_type and id.note_group = ic.note_group_id and rownum=1 ))  THEN  'Y'  WHEN ( e.discharge_date_time IS NULL OR e.visit_adm_date_time > SYSDATE - (select Id.CUT_OFF_DAYS from ca_transription_req Ia, ca_pat_task_list Ib, ca_note_type Ic, ca_note_group Id where Ib.REQ_ACCESSION_NUM = a.REQ_ACCESSION_NUM and Ia.NOTE_TYPE = Ic.note_type and Id.note_group = Ic.note_group_id and rownum=1 )) THEN 'Y' ELSE 'N' END)='N' then 'E' else 'O' END) in ("+Admin_Status_str+") )");
				}
				/*if (chkAll.equals("N"))
				{
					if (chkFuture.equals("Y") ||chkElapsed.equals("Y")||ckhDue.equals("Y")||chkOverdue.equals("Y") )
					{
						if (chkPerformed.equals("N") )
						{
							sql.append(" and nvl(A.Status,'O') not in ('P','N') ");
						}
					}
					else if (chkPerformed.equals("Y"))
					{
						sql.append(" and nvl(A.Status,'O') in ('P','N') ");
					}

					if (chkFuture.equals("N"))
					{
						sql.append(" and A.SCHEDULE_DATETIME <=sysdate +.0208 ");
					}
					else if (chkPerformed.equals("N")&&chkElapsed.equals("N")&&ckhDue.equals("N")&&chkOverdue.equals("N") )
					{
						sql.append(" and A.SCHEDULE_DATETIME > sysdate +.0208 ");
					}

					if (chkElapsed.equals("Y") && chkPerformed.equals("N") && chkElapsed.equals("N") && ckhDue.equals("N") && chkOverdue.equals("N") )
					{
						//sql.append(" and A.SCHEDULE_DATETIME >=sysdate-.25 ");
						sql.append(" and (CASE WHEN e.PATIENT_CLASS IN ('IP','DC') AND (e.DISCHARGE_DATE_TIME IS NULL OR e.DISCHARGE_DATE_TIME > SYSDATE - (select Id.CUT_OFF_DAYS from ca_transription_req ia, ca_note_type ic, ca_note_group id where ia.REQ_ACCESSION_NUM = a.REQ_ACCESSION_NUM and ia.NOTE_TYPE = ic.note_type and id.note_group = ic.note_group_id and rownum=1 ))  THEN  'Y' WHEN  e.VISIT_ADM_DATE_TIME > SYSDATE - (select Id.CUT_OFF_DAYS from ca_transription_req Ia, ca_pat_task_list Ib, ca_note_type Ic, ca_note_group Id where Ib.REQ_ACCESSION_NUM = a.REQ_ACCESSION_NUM and Ia.NOTE_TYPE = Ic.note_type and Id.note_group = Ic.note_group_id and rownum=1 ) THEN 'Y' ELSE 'N' END ) = 'N' ");
					}
					else if (chkElapsed.equals("N"))
					{
						sql.append(" and (CASE WHEN e.PATIENT_CLASS IN ('IP','DC') AND (e.DISCHARGE_DATE_TIME IS NULL OR e.DISCHARGE_DATE_TIME > SYSDATE - (select Id.CUT_OFF_DAYS from ca_transription_req ia, ca_note_type ic, ca_note_group id where ia.REQ_ACCESSION_NUM = a.REQ_ACCESSION_NUM and ia.NOTE_TYPE = ic.note_type and id.note_group = ic.note_group_id and rownum=1 ))  THEN  'Y' WHEN  e.VISIT_ADM_DATE_TIME > SYSDATE - (select Id.CUT_OFF_DAYS from ca_transription_req Ia, ca_pat_task_list Ib, ca_note_type Ic, ca_note_group Id where Ib.REQ_ACCESSION_NUM = a.REQ_ACCESSION_NUM and Ia.NOTE_TYPE = Ic.note_type and Id.note_group = Ic.note_group_id and rownum=1 ) THEN 'Y' ELSE 'N' END ) = 'Y' ");
					}

					if (ckhDue.equals("Y") && chkOverdue.equals("N"))
					{
						//sql.append(" and A.SCHEDULE_DATETIME not between sysdate-.25 and sysdate ");
						if (chkPerformed.equals("Y"))
						{
								sql.append("  and (A.SCHEDULE_DATETIME > sysdate-.0208  or  nvl(A.Status,'O') in ('P','N') )");
						}
						else
							sql.append(" and A.SCHEDULE_DATETIME > sysdate-.0208 ");
					}
					if (chkOverdue.equals("Y"))
					{
						//sql.append(" and A.SCHEDULE_DATETIME not between sysdate and sysdate+.0208 ");
						sql.append(" and A.SCHEDULE_DATETIME >  sysdate-90 ");
					}

				}*/

				//PE Changes by Shaiju Starts

			//	if(taskSelect.equals("") && intervention.equals("CA_TASK_LIST_INT"))  //Intervention
			//	{
					
					if(!(sql.toString()).equals(""))
					{
						if (Groupby.equals("P"))
						{
							sql.append("ORDER BY 2,a.patient_id, 3 DESC, 5 ASC ");
						}else if (Groupby.equals("T"))
						{
							sql.append("ORDER BY  3 DESC, 5 ASC, 2 ");
						}
						System.out.println("sql.toString()========>1159======================pattasklistrepository====>"+sql.toString());
						pstmt = connection.prepareStatement(sql.toString()) ;
						
						i=0;
						
						pstmt.setString( ++i, locale);
						pstmt.setString( ++i, locale);
						pstmt.setString( ++i, locale);
						pstmt.setString( ++i, facilityId);
						pstmt.setString( ++i, From_date);
						pstmt.setString( ++i, To_date);
						pstmt.setString( ++i, practitioner_id);

						if(patient_id.equals(""))
							pstmt.setString( ++i, ALL);
						else
							pstmt.setString( ++i, patient_id);

						if(!location_type.equals(""))
							pstmt.setString( ++i, location_type);
						if(!locn_code.equals(""))
							pstmt.setString( ++i, locn_code);
						if(!interventionType.equals(""))
							pstmt.setString( ++i, interventionType);

						resultSet = pstmt.executeQuery() ;

						if(resultSet!=null) {

						if(start > 0)
						{
							for(k=0;(k<start-1 && resultSet.next());k++);
							start = start-k;
						}
						while ( start_tmp <= end && resultSet!=null && resultSet.next()) {
					//while ( resultSet != null && resultSet.next() ) {
						/**
						Modified by Deepa on 5/17/2010 at 12:08 PM for IN021020
						increased the size of taskResult_val to 50 from 49, to include dob in the array
						**/
						//String[] taskResult_val 			= new String[51];
						//String[] taskResult_val 			= new String[54]; //IN030473	[IN040761 increased to 54 from 52]
						//String[] taskResult_val 			= new String[56]; //IN041063 	[IN041063  increased to 56 from 54]//IN065942
						//String[] taskResult_val 			= new String[58]; //IN041063 	[IN041063  increased to 56 from 54]//IN065942//IN071618
						String[] taskResult_val 			= new String[59]; //26826
						taskResult_val[0] = checkForNull(resultSet.getString("task_type"))  ;
						taskResult_val[1] = checkForNull(resultSet.getString("task_type_desc").trim())  ;
						taskResult_val[2] = checkForNull(resultSet.getString("task_code"))  ;
						taskResult_val[3] = checkForNull(resultSet.getString("schedule_date").trim())  ;
						taskResult_val[4] = checkForNull(resultSet.getString("schedule_date_string").trim())  ;
						taskResult_val[5] = checkForNull(resultSet.getString("Admin_Status"))  ;
						taskResult_val[6] = checkForNull(resultSet.getString("task_srl_no"))  ;
						taskResult_val[7] = checkForNull(resultSet.getString("ordering_pract_name"))  ;
						taskResult_val[8] = checkForNull(resultSet.getString("priority"))  ;
						taskResult_val[9] = checkForNull(resultSet.getString("stage_short_desc"))  ;
						taskResult_val[10] = checkForNull(resultSet.getString("position_code"))  ;
						taskResult_val[11] = checkForNull(resultSet.getString("status_desc"))  ;
						taskResult_val[12] = checkForNull(resultSet.getString("patient_name"))  ;
						taskResult_val[13] = checkForNull(resultSet.getString("age"))  ;
						taskResult_val[14] = checkForNull(resultSet.getString("sex"))  ;
						taskResult_val[15] = checkForNull(resultSet.getString("task_desc"))  ;
						taskResult_val[16] = checkForNull(resultSet.getString("Result_options"))  ;
						taskResult_val[17] = checkForNull(resultSet.getString("schedule_time_string").trim())  ;
						taskResult_val[18] = checkForNull(resultSet.getString("order_category_short_desc"))  ;
						taskResult_val[19] = checkForNull(resultSet.getString("order_id"))  ;
						taskResult_val[20] = checkForNull(resultSet.getString("encounter_id"))  ;
						taskResult_val[21] = checkForNull(resultSet.getString("patient_class"))  ;
						taskResult_val[22] = checkForNull(resultSet.getString("patient_id"))  ;
						taskResult_val[23] = checkForNull(resultSet.getString("order_category"))  ;
						taskResult_val[24] = checkForNull(resultSet.getString("order_status"))  ;
						taskResult_val[25] = checkForNull(resultSet.getString("order_line_num"))  ;
						taskResult_val[26] = checkForNull(resultSet.getString("performing_facility_id"))  ;
						taskResult_val[27] = checkForNull(resultSet.getString("performing_deptloc_type"))  ;
						taskResult_val[28] = checkForNull(resultSet.getString("performing_deptloc_code"))  ;
						taskResult_val[29] = checkForNull(resultSet.getString("int_or_ext"))  ;
						taskResult_val[30] = checkForNull(resultSet.getString("order_type_code"))  ;
						taskResult_val[31] = checkForNull(resultSet.getString("source_type"))  ;
						taskResult_val[32] = checkForNull(resultSet.getString("source_code"))  ;
						taskResult_val[33] = checkForNull(resultSet.getString("location_description"))  ;
						taskResult_val[34] = checkForNull(resultSet.getString("TASK_CATEG"))  ;
						taskResult_val[35] = checkForNull(resultSet.getString("RESULT_TYPE"))  ;
						taskResult_val[36] = checkForNull(resultSet.getString("RESULT_ID"))  ;
						taskResult_val[37] = checkForNull(resultSet.getString("cont_order_ind"))  ;
						taskResult_val[38] = checkForNull(resultSet.getString("APPT_REF_NUM"))  ;
						taskResult_val[39] = checkForNull(resultSet.getString("ord_pract_id"))  ;
						taskResult_val[40] = checkForNull(resultSet.getString("consent_status"))  ;
						taskResult_val[41] = checkForNull(resultSet.getString("order_set_id"))  ;
						taskResult_val[42] = checkForNull(resultSet.getString("SPECIMEN_NO"))  ;
						taskResult_val[43] = checkForNull(resultSet.getString("OPERATING_FACILITY_ID"))  ;
						taskResult_val[44] = checkForNull(resultSet.getString("UNIT_NO"))  ;
						taskResult_val[45] = checkForNull(resultSet.getString("PRODUCT_CODE"))  ;
						taskResult_val[46] = checkForNull(resultSet.getString("row_id"))  ;
						taskResult_val[47] = checkForNull(resultSet.getString("bt_status"))  ;
						taskResult_val[49] = checkForNull(resultSet.getString("dob"))  ;
						taskResult_val[50] = ""  ;
						taskResult_val[51] = checkForNull(resultSet.getString("consentFromId"))  ;//IN030473
						taskResult_val[52] = checkForNull(resultSet.getString("ae_bed_no"))  ;	//IN040761
						taskResult_val[53] = checkForNull(resultSet.getString("ae_pri_zone"))  ;	//IN040761
						taskResult_val[54] = checkForNull(resultSet.getString("VISIT_STATUS"))  ;	//IN041063
						taskResult_val[55] = checkForNull(resultSet.getString("ADT_STATUS"))  ;	//IN041063
						taskResult_val[56] = checkForNull(resultSet.getString("prn_reg_ord"))  ;	//IN065942
						taskResult_val[57] = "" ;	//IN071618
						taskResult_val[58] = checkForNull(resultSet.getString("orderCatagory"))  ;//	26826 
						taskResult.add(taskResult_val);
						start_tmp++;

					}
						if (resultSet.next())
						{
							String[] templist = (String[])taskResult.get(0);
							templist[48] = ""+(end+50);
							taskResult.set(0,templist);
						}
					}


					}
			//	}


				//PE Changes by Shaiju Ends

			}
			System.out.println("medAdmin========>1282=================pattasklistrepository====>"+medAdmin);

			if(taskSelect.equals("M") || (taskSelect.equals("") && medAdmin.equals("CA_TASK_LIST_MEDADMN")))
			{
				//if(taskSelect.equals(""))
				//sql.append(" UNION ALL ");
				//modified by Ambiga.M on 2/12/2010 for 18905
				if(sql.length() > 0) sql.delete(0,sql.length());
				//IN040761 - commented
				//sql.append("SELECT   'M' TASK_CATEG , DECODE ('en',?, C.patient_name,NVL (C.patient_name_loc_lang, C.patient_name)) patient_name, TRUNC(A.SCH_DATE_TIME) start_date,to_char (A.SCH_DATE_TIME,'dd/mm/yyyy HH24:MI') schedule_date, TO_CHAR (A.SCH_DATE_TIME, 'HH24:MI') schedule_time_string,NVL(D.IV_PREP_YN,'N') task_type, or_get_desc.or_order_type(D.order_type_code,?,'2') task_type_desc, or_get_order_catalog (D.order_id,D.order_type_code,?,'MD',g.order_line_num,'Y') task_desc,A.ORD_DRUG_CODE  task_code, TO_CHAR (A.SCH_DATE_TIME, 'DD/MM/YYYY') schedule_date_string, A.DOSAGE_SEQ_NO task_srl_no	,  am_get_desc.am_practitioner (d.ord_pract_id,?,'1')  ordering_pract_name, nvl(g.PRIORITY,'R') priority, NULL stage_short_desc, NULL position_code	, or_get_desc.or_order_status_code (G.order_line_status,?,'2')   status_desc, get_age (C.date_of_birth) age, to_char(C.date_of_birth,'DD/MM/YYYY') dob, C.sex sex	, nvl(g.PRIORITY,'R') priority	, 'PH' order_category, g.order_line_status order_status,or_get_desc.OR_ORDER_CATEGORY ('PH',?,'2') order_category_short_desc,a.encounter_id encounter_id, E.patient_class patient_class	,A.ORDER_LINE_NUM order_line_num, A.FACILITY_ID performing_facility_id, null performing_deptloc_type, null performing_deptloc_code, null int_or_ext	,'N' image_ref_yn	, null source_type, null source_code, null order_type_code,A.ORDER_ID order_id, a.patient_id patient_id	,  null result_options,  null location_description,    NVL2(A.ADMIN_RECORDED_BY,'C','D') Admin_Status,null RESULT_TYPE,null RESULT_ID,D.cont_order_ind,G.APPT_REF_NUM,D.ord_pract_id, NULL consent_status,null  order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status FROM MP_PATIENT C  , PR_ENCOUNTER E	,PH_MEDN_ADMIN A, OR_ORDER_LINE G, OR_ORDER D ,OR_ORDER_CATALOG  B ,PH_FACILITY_PARAM F WHERE A.FACILITY_ID =E.FACILITY_ID AND A.ENCOUNTER_ID=E.ENCOUNTER_ID AND G.ORDER_ID =A.ORDER_ID AND G.ORDER_LINE_NUM=A.ORDER_LINE_NUM 	AND E.FACILITY_ID=? AND C.PATIENT_ID=A.PATIENT_ID AND B.ORDER_CATALOG_CODE=A.ORD_DRUG_CODE AND F.FACILITY_ID=A.FACILITY_ID AND F.FACILITY_ID=? 	AND A.SCH_DATE_TIME    BETWEEN SYSDATE-F.REC_ADMIN_WITHIN_HRS/24 AND SYSDATE AND D.ORDER_ID=A.ORDER_ID  and  A.SCH_DATE_TIME between to_date(rtrim(?),'dd/mm/yyyy') and to_date(rtrim(?),'dd/mm/yyyy')+.99999   AND  a.sch_date_time>=G.start_date_time  	and (( D.IV_PREP_YN IS NULL ) or (D.IV_PREP_YN  in ('1','3','5','9') and A.ORDER_LINE_NUM=1) ) AND G.ORDER_LINE_STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE  WHERE ORDER_STATUS_TYPE in ('45','50','93','99')) AND ((E.PATIENT_CLASS IN ('OP','EM') AND E.VISIT_STATUS BETWEEN '01' AND '09') OR (E.PATIENT_CLASS IN ('IP','DC') and  ADT_STATUS BETWEEN '01' AND '08')) ");
				
				//IN040761 - added ae_bed_no & ae_pri_zone
				//sql.append("SELECT   'M' TASK_CATEG , DECODE ('en',?, C.patient_name,NVL (C.patient_name_loc_lang, C.patient_name)) patient_name, TRUNC(A.SCH_DATE_TIME) start_date,to_char (A.SCH_DATE_TIME,'dd/mm/yyyy HH24:MI') schedule_date, TO_CHAR (A.SCH_DATE_TIME, 'HH24:MI') schedule_time_string,NVL(D.IV_PREP_YN,'N') task_type, or_get_desc.or_order_type(D.order_type_code,?,'2') task_type_desc, or_get_order_catalog (D.order_id,D.order_type_code,?,'MD',g.order_line_num,'Y') task_desc,A.ORD_DRUG_CODE  task_code, TO_CHAR (A.SCH_DATE_TIME, 'DD/MM/YYYY') schedule_date_string, A.DOSAGE_SEQ_NO task_srl_no	,  am_get_desc.am_practitioner (d.ord_pract_id,?,'1')  ordering_pract_name, nvl(g.PRIORITY,'R') priority, NULL stage_short_desc, NULL position_code	, or_get_desc.or_order_status_code (G.order_line_status,?,'2')   status_desc, get_age (C.date_of_birth) age, to_char(C.date_of_birth,'DD/MM/YYYY') dob, C.sex sex	, nvl(g.PRIORITY,'R') priority	, 'PH' order_category, g.order_line_status order_status,or_get_desc.OR_ORDER_CATEGORY ('PH',?,'2') order_category_short_desc,a.encounter_id encounter_id, E.patient_class patient_class	,A.ORDER_LINE_NUM order_line_num, A.FACILITY_ID performing_facility_id, null performing_deptloc_type, null performing_deptloc_code, null int_or_ext	,'N' image_ref_yn	, null source_type, null source_code, null order_type_code,A.ORDER_ID order_id, a.patient_id patient_id	,  null result_options,  null location_description,    NVL2(A.ADMIN_RECORDED_BY,'C','D') Admin_Status,null RESULT_TYPE,null RESULT_ID,D.cont_order_ind,G.APPT_REF_NUM,D.ord_pract_id, NULL consent_status,null  order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status,  e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone   FROM MP_PATIENT C  , PR_ENCOUNTER E	,PH_MEDN_ADMIN A, OR_ORDER_LINE G, OR_ORDER D ,OR_ORDER_CATALOG  B ,PH_FACILITY_PARAM F WHERE A.FACILITY_ID =E.FACILITY_ID AND A.ENCOUNTER_ID=E.ENCOUNTER_ID AND G.ORDER_ID =A.ORDER_ID AND G.ORDER_LINE_NUM=A.ORDER_LINE_NUM 	AND E.FACILITY_ID=? AND C.PATIENT_ID=A.PATIENT_ID AND B.ORDER_CATALOG_CODE=A.ORD_DRUG_CODE AND F.FACILITY_ID=A.FACILITY_ID AND F.FACILITY_ID=? 	AND A.SCH_DATE_TIME    BETWEEN SYSDATE-F.REC_ADMIN_WITHIN_HRS/24 AND SYSDATE AND D.ORDER_ID=A.ORDER_ID  and  A.SCH_DATE_TIME between to_date(rtrim(?),'dd/mm/yyyy') and to_date(rtrim(?),'dd/mm/yyyy')+.99999   AND  a.sch_date_time>=G.start_date_time  	and (( D.IV_PREP_YN IS NULL ) or (D.IV_PREP_YN  in ('1','3','5','9') and A.ORDER_LINE_NUM=1) ) AND G.ORDER_LINE_STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE  WHERE ORDER_STATUS_TYPE in ('45','50','93','99')) AND ((E.PATIENT_CLASS IN ('OP','EM') AND E.VISIT_STATUS BETWEEN '01' AND '09') OR (E.PATIENT_CLASS IN ('IP','DC') and  ADT_STATUS BETWEEN '01' AND '08')) ");
				//sql.append("SELECT   'M' TASK_CATEG , DECODE ('en',?, C.patient_name,NVL (C.patient_name_loc_lang, C.patient_name)) patient_name, TRUNC(A.SCH_DATE_TIME) start_date,to_char (A.SCH_DATE_TIME,'dd/mm/yyyy HH24:MI') schedule_date, TO_CHAR (A.SCH_DATE_TIME, 'HH24:MI') schedule_time_string,NVL(D.IV_PREP_YN,'N') task_type, or_get_desc.or_order_type(D.order_type_code,?,'2') task_type_desc, or_get_order_catalog (D.order_id,D.order_type_code,?,'MD',g.order_line_num,'Y') task_desc,A.ORD_DRUG_CODE  task_code, TO_CHAR (A.SCH_DATE_TIME, 'DD/MM/YYYY') schedule_date_string, A.DOSAGE_SEQ_NO task_srl_no	,  am_get_desc.am_practitioner (d.ord_pract_id,?,'1')  ordering_pract_name, nvl(g.PRIORITY,'R') priority, NULL stage_short_desc, NULL position_code	, or_get_desc.or_order_status_code (G.order_line_status,?,'2')   status_desc, get_age (C.date_of_birth) age, to_char(C.date_of_birth,'DD/MM/YYYY') dob, C.sex sex	, nvl(g.PRIORITY,'R') priority	, 'PH' order_category, g.order_line_status order_status,or_get_desc.OR_ORDER_CATEGORY ('PH',?,'2') order_category_short_desc,a.encounter_id encounter_id, E.patient_class patient_class	,A.ORDER_LINE_NUM order_line_num, A.FACILITY_ID performing_facility_id, null performing_deptloc_type, null performing_deptloc_code, null int_or_ext	,'N' image_ref_yn	, null source_type, null source_code, null order_type_code,A.ORDER_ID order_id, a.patient_id patient_id	,  null result_options,  null location_description,    NVL2(A.ADMIN_RECORDED_BY,'C','D') Admin_Status,null RESULT_TYPE,null RESULT_ID,D.cont_order_ind,G.APPT_REF_NUM,D.ord_pract_id, NULL consent_status,null  order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status,  e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone,e.VISIT_STATUS,e.adt_status   FROM MP_PATIENT C  , PR_ENCOUNTER E	,PH_MEDN_ADMIN A, OR_ORDER_LINE G, OR_ORDER D ,OR_ORDER_CATALOG  B ,PH_FACILITY_PARAM F WHERE A.FACILITY_ID =E.FACILITY_ID AND A.ENCOUNTER_ID=E.ENCOUNTER_ID AND G.ORDER_ID =A.ORDER_ID AND G.ORDER_LINE_NUM=A.ORDER_LINE_NUM 	AND E.FACILITY_ID=? AND C.PATIENT_ID=A.PATIENT_ID AND B.ORDER_CATALOG_CODE=A.ORD_DRUG_CODE AND F.FACILITY_ID=A.FACILITY_ID AND F.FACILITY_ID=? 	AND A.SCH_DATE_TIME    BETWEEN SYSDATE-F.REC_ADMIN_WITHIN_HRS/24 AND SYSDATE AND D.ORDER_ID=A.ORDER_ID  and  A.SCH_DATE_TIME between to_date(rtrim(?),'dd/mm/yyyy') and to_date(rtrim(?),'dd/mm/yyyy')+.99999   AND  a.sch_date_time>=G.start_date_time  	and (( D.IV_PREP_YN IS NULL ) or (D.IV_PREP_YN  in ('1','3','5','9') and A.ORDER_LINE_NUM=1) ) AND G.ORDER_LINE_STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE  WHERE ORDER_STATUS_TYPE in ('45','50','93','99')) AND ((E.PATIENT_CLASS IN ('OP','EM') AND E.VISIT_STATUS BETWEEN '01' AND '09') OR (E.PATIENT_CLASS IN ('IP','DC') and  ADT_STATUS BETWEEN '01' AND '08')) ");//IN041063 //Modified - [IN029366]//IN065942
				sql.append("SELECT   'M' TASK_CATEG , DECODE ('en',?, C.patient_name,NVL (C.patient_name_loc_lang, C.patient_name)) patient_name, TRUNC(A.SCH_DATE_TIME) start_date,to_char (A.SCH_DATE_TIME,'dd/mm/yyyy HH24:MI') schedule_date, TO_CHAR (A.SCH_DATE_TIME, 'HH24:MI') schedule_time_string,NVL(D.IV_PREP_YN,'N') task_type, or_get_desc.or_order_type(D.order_type_code,?,'2') task_type_desc, or_get_order_catalog (D.order_id,D.order_type_code,?,'MD',g.order_line_num,'Y') task_desc,A.ORD_DRUG_CODE  task_code, TO_CHAR (A.SCH_DATE_TIME, 'DD/MM/YYYY') schedule_date_string, A.DOSAGE_SEQ_NO task_srl_no	,  am_get_desc.am_practitioner (d.ord_pract_id,?,'1')  ordering_pract_name, nvl(g.PRIORITY,'R') priority, NULL stage_short_desc, NULL position_code	, or_get_desc.or_order_status_code (G.order_line_status,?,'2')   status_desc, get_age (C.date_of_birth) age, to_char(C.date_of_birth,'DD/MM/YYYY') dob, C.sex sex	, nvl(g.PRIORITY,'R') priority	, 'PH' order_category, g.order_line_status order_status,or_get_desc.OR_ORDER_CATEGORY ('PH',?,'2') order_category_short_desc,a.encounter_id encounter_id, E.patient_class patient_class	,A.ORDER_LINE_NUM order_line_num, A.FACILITY_ID performing_facility_id, null performing_deptloc_type, null performing_deptloc_code, null int_or_ext	,'N' image_ref_yn	, null source_type, null source_code, null order_type_code,A.ORDER_ID order_id, a.patient_id patient_id	,  null result_options,  null location_description,    NVL2(A.ADMIN_RECORDED_BY,'C','D') Admin_Status,null RESULT_TYPE,null RESULT_ID,D.cont_order_ind,G.APPT_REF_NUM,D.ord_pract_id, NULL consent_status,null  order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status,  e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone,e.VISIT_STATUS,e.adt_status,'N' prn_reg_ord FROM MP_PATIENT C  , PR_ENCOUNTER E	,PH_MEDN_ADMIN A, OR_ORDER_LINE G, OR_ORDER D ,OR_ORDER_CATALOG  B ,PH_FACILITY_PARAM F WHERE A.FACILITY_ID =E.FACILITY_ID AND A.ENCOUNTER_ID=E.ENCOUNTER_ID AND G.ORDER_ID =A.ORDER_ID AND G.ORDER_LINE_NUM=A.ORDER_LINE_NUM 	AND E.FACILITY_ID=? AND C.PATIENT_ID=A.PATIENT_ID AND B.ORDER_CATALOG_CODE=A.ORD_DRUG_CODE AND F.FACILITY_ID=A.FACILITY_ID AND F.FACILITY_ID=? 	AND A.SCH_DATE_TIME    BETWEEN SYSDATE-F.REC_ADMIN_WITHIN_HRS/24 AND SYSDATE AND D.ORDER_ID=A.ORDER_ID  and  A.SCH_DATE_TIME between to_date(rtrim(?),'dd/mm/yyyy') and to_date(rtrim(?),'dd/mm/yyyy')+.99999   AND  a.sch_date_time>=G.start_date_time  	and (( D.IV_PREP_YN IS NULL ) or (D.IV_PREP_YN  in ('1','3','5','9') and A.ORDER_LINE_NUM=1) ) AND G.ORDER_LINE_STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE  WHERE ORDER_STATUS_TYPE in ('45','50','93','99')) AND ((E.PATIENT_CLASS IN ('OP','EM') AND E.VISIT_STATUS BETWEEN '01' AND '09') OR (E.PATIENT_CLASS IN ('IP','DC') and  ADT_STATUS BETWEEN '01' AND '08')) ");//IN041063 //Modified - [IN029366]//IN065942
				if(chkPerformed.equals("N") && ckhDue.equals("Y"))
				{
					sql.append(" and nvl(A.ADMIN_RECORDED_BY,'***')='***' ");
				}
				else if (chkPerformed.equals("Y") && ckhDue.equals("N"))
				{
						sql.append(" and A.ADMIN_RECORDED_BY is not null ");
				}
				else if (chkPerformed.equals("N") && ckhDue.equals("N"))
				{
						sql.append(" and 1=2 ");
				}

				String Admin_Status_str="";

				if (ckhDue.equals("Y") )
				{
					if (!Admin_Status_str.equals(""))
					{
						Admin_Status_str=Admin_Status_str+",";
					}
					Admin_Status_str=Admin_Status_str+"'D'";
				}
				if (chkPerformed.equals("Y") )
				{
					if (!Admin_Status_str.equals(""))
					{
						Admin_Status_str=Admin_Status_str+",";
					}
					Admin_Status_str=Admin_Status_str+"'C'";

				}

				if(patient_id.equals(""))
					sql.append("and A.patient_id like ? ");
				else
					sql.append("and A.patient_id = ? ");
				if(location_type.equals(""))
				{
					sql.append("AND  E.ASSIGN_CARE_LOCN_TYPE like ? ");
				}
				else
				{
					if(location_type.equals("C"))
					{
						sql.append("AND  E.ASSIGN_CARE_LOCN_TYPE in ('C','E') ");
					}
					else
					{
						sql.append("AND  E.ASSIGN_CARE_LOCN_TYPE=? ");
					}
				}

				if(locn_code.equals(""))
					sql.append("AND E.ASSIGN_CARE_LOCN_CODE like ? ");
				else
					sql.append("AND  E.ASSIGN_CARE_LOCN_CODE=? ");

				if(OrderCategory.equals(""))
					sql.append("AND  D.ORDER_CATEGORY like ? ");
				else
					sql.append("AND  D.ORDER_CATEGORY=? ");

				if(OrderType.equals(""))
					sql.append("AND  D.ORDER_TYPE_CODE like ? ");
				else
					sql.append("AND  D.ORDER_TYPE_CODE=? ");

				if(!AdminRoute.equals(""))
					sql.append("AND  G.ROUTE_CODE = ? ");

				if (callFrom.equals("IM"))
				{
					if (viewBy.equals("C"))
						sql.append(" AND a.encounter_id = ?");

					sql.append(" and b.LINKED_VACCINE_ID IS NOT NULL ");

				}

				if (ckhDue.equals("Y") || chkPerformed.equals("Y") )
					sql.append("AND NVL2(A.ADMIN_RECORDED_BY,'C','D') in ("+Admin_Status_str+")");

					//PE Changes by Shaiju Starts

		//	if(taskSelect.equals("") && medAdmin.equals("CA_TASK_LIST_MEDADMN")) //Medication
		//	{
				
				if(!(sql.toString()).equals(""))
				{
					if (Groupby.equals("P"))
					{
						sql.append("ORDER BY 2, a.patient_id,3 DESC, 5 ASC ");
					}else if (Groupby.equals("T"))
					{
						sql.append("ORDER BY  3 DESC, 5 ASC, 2 ");
					}
					pstmt = connection.prepareStatement(sql.toString()) ;
					System.out.println("sql.toString()========>1391======================pattasklistrepository====>"+sql.toString());
					i=0;

					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, facilityId);
					pstmt.setString( ++i, facilityId);
					pstmt.setString( ++i, From_date);
					pstmt.setString( ++i, To_date);

					if(patient_id.equals(""))
						pstmt.setString( ++i, ALL);
					else
						pstmt.setString( ++i, patient_id);

					if(location_type.equals(""))
					{
						pstmt.setString( ++i, ALL);
					}
					else
					{
						if(!location_type.equals("C"))
						{
							pstmt.setString( ++i, location_type);
						}
					}
					if(locn_code.equals(""))
						pstmt.setString( ++i, ALL);
					else
						pstmt.setString( ++i, locn_code);

					if(OrderCategory.equals(""))
						pstmt.setString( ++i, ALL);
					else
						pstmt.setString( ++i, OrderCategory);

					if(OrderType.equals(""))
						pstmt.setString( ++i, ALL);
					else
						pstmt.setString( ++i, OrderType);
					if(!AdminRoute.equals(""))
						pstmt.setString( ++i, AdminRoute);

					if (callFrom.equals("IM"))
					{
						if (viewBy.equals("C"))
							pstmt.setString( ++i, encounter_id);
					}


						resultSet = pstmt.executeQuery() ;

						if(resultSet!=null) {
						if(start > 0)
						{
							for(k=0;(k<start-1 && resultSet.next());k++);
							start = start-k;
						}

						while ( start_tmp <= end && resultSet!=null && resultSet.next()) {
					//while ( resultSet != null && resultSet.next() ) {
						/**
						Modified by Deepa on 5/17/2010 at 12:08 PM for IN021020
						increased the size of taskResult_val to 50 from 49, to include dob in the array
						**/
						//String[] taskResult_val 			= new String[51];
						//String[] taskResult_val 			= new String[54]; //IN030473	[IN040761 increased to 54 from 52]
						//String[] taskResult_val 			= new String[56]; //IN041063	[IN041063 increased to 56 from 54]//IN065942
						//String[] taskResult_val 			= new String[58]; //IN041063	[IN041063 increased to 56 from 54]//IN065942//IN071618
						String[] taskResult_val 			= new String[59]; //26826
						taskResult_val[0] = checkForNull(resultSet.getString("task_type"))  ;
						taskResult_val[1] = checkForNull(resultSet.getString("task_type_desc").trim())  ;
						taskResult_val[2] = checkForNull(resultSet.getString("task_code"))  ;
						taskResult_val[3] = checkForNull(resultSet.getString("schedule_date").trim())  ;
						taskResult_val[4] = checkForNull(resultSet.getString("schedule_date_string").trim())  ;
						taskResult_val[5] = checkForNull(resultSet.getString("Admin_Status"))  ;
						taskResult_val[6] = checkForNull(resultSet.getString("task_srl_no"))  ;
						taskResult_val[7] = checkForNull(resultSet.getString("ordering_pract_name"))  ;
						taskResult_val[8] = checkForNull(resultSet.getString("priority"))  ;
						taskResult_val[9] = checkForNull(resultSet.getString("stage_short_desc"))  ;
						taskResult_val[10] = checkForNull(resultSet.getString("position_code"))  ;
						taskResult_val[11] = checkForNull(resultSet.getString("status_desc"))  ;
						taskResult_val[12] = checkForNull(resultSet.getString("patient_name"))  ;
						taskResult_val[13] = checkForNull(resultSet.getString("age"))  ;
						taskResult_val[14] = checkForNull(resultSet.getString("sex"))  ;
						taskResult_val[15] = checkForNull(resultSet.getString("task_desc"))  ;
						taskResult_val[16] = checkForNull(resultSet.getString("Result_options"))  ;
						taskResult_val[17] = checkForNull(resultSet.getString("schedule_time_string").trim())  ;
						taskResult_val[18] = checkForNull(resultSet.getString("order_category_short_desc"))  ;
						taskResult_val[19] = checkForNull(resultSet.getString("order_id"))  ;
						taskResult_val[20] = checkForNull(resultSet.getString("encounter_id"))  ;
						taskResult_val[21] = checkForNull(resultSet.getString("patient_class"))  ;
						taskResult_val[22] = checkForNull(resultSet.getString("patient_id"))  ;
						taskResult_val[23] = checkForNull(resultSet.getString("order_category"))  ;
						taskResult_val[24] = checkForNull(resultSet.getString("order_status"))  ;
						taskResult_val[25] = checkForNull(resultSet.getString("order_line_num"))  ;
						taskResult_val[26] = checkForNull(resultSet.getString("performing_facility_id"))  ;
						taskResult_val[27] = checkForNull(resultSet.getString("performing_deptloc_type"))  ;
						taskResult_val[28] = checkForNull(resultSet.getString("performing_deptloc_code"))  ;
						taskResult_val[29] = checkForNull(resultSet.getString("int_or_ext"))  ;
						taskResult_val[30] = checkForNull(resultSet.getString("order_type_code"))  ;
						taskResult_val[31] = checkForNull(resultSet.getString("source_type"))  ;
						taskResult_val[32] = checkForNull(resultSet.getString("source_code"))  ;
						taskResult_val[33] = checkForNull(resultSet.getString("location_description"))  ;
						taskResult_val[34] = checkForNull(resultSet.getString("TASK_CATEG"))  ;
						taskResult_val[35] = checkForNull(resultSet.getString("RESULT_TYPE"))  ;
						taskResult_val[36] = checkForNull(resultSet.getString("RESULT_ID"))  ;
						taskResult_val[37] = checkForNull(resultSet.getString("cont_order_ind"))  ;
						taskResult_val[38] = checkForNull(resultSet.getString("APPT_REF_NUM"))  ;
						taskResult_val[39] = checkForNull(resultSet.getString("ord_pract_id"))  ;
						taskResult_val[40] = checkForNull(resultSet.getString("consent_status"))  ;
						taskResult_val[41] = checkForNull(resultSet.getString("order_set_id"))  ;
						taskResult_val[42] = checkForNull(resultSet.getString("SPECIMEN_NO"))  ;
						taskResult_val[43] = checkForNull(resultSet.getString("OPERATING_FACILITY_ID"))  ;
						taskResult_val[44] = checkForNull(resultSet.getString("UNIT_NO"))  ;
						taskResult_val[45] = checkForNull(resultSet.getString("PRODUCT_CODE"))  ;
						taskResult_val[46] = checkForNull(resultSet.getString("row_id"))  ;
						taskResult_val[47] = checkForNull(resultSet.getString("bt_status"))  ;
						taskResult_val[49] = checkForNull(resultSet.getString("dob"))  ;
						taskResult_val[50] = ""  ;
						taskResult_val[51] = ""  ;//IN030473
						taskResult_val[52] = checkForNull(resultSet.getString("ae_bed_no"))  ;//IN040761
						taskResult_val[53] = checkForNull(resultSet.getString("ae_pri_zone"))  ;//IN040761
						taskResult_val[54] = checkForNull(resultSet.getString("VISIT_STATUS"))  ;//IN041063
						taskResult_val[55] = checkForNull(resultSet.getString("ADT_STATUS"))  ;//IN041063
						taskResult_val[56] = checkForNull(resultSet.getString("prn_reg_ord"))  ;//IN065942
						taskResult_val[57] = "" ;//IN071618	
						taskResult_val[58] = "" ;//	26826
						taskResult.add(taskResult_val);
						start_tmp++;

					}
						if (resultSet.next())
						{
							String[] templist = (String[])taskResult.get(0);
							templist[48] = ""+(end+50);
							taskResult.set(0,templist);
						}
					}



				}


			//}
			
			//PE Changes by Shaiju Ends

			}

			System.out.println("specCollection========>1547=================pattasklistrepository====>"+specCollection);
			System.out.println("chkUnclassify========>1548=================pattasklistrepository====>"+chkUnclassify);
			if(taskSelect.equals("S") || (taskSelect.equals("") && specCollection.equals("CA_TASK_LIST_MSPECI")) && chkUnclassify.equals("Y"))
			{

				//if(taskSelect.equals(""))
				//sql.append(" UNION ALL ");
				if(sql.length() > 0) sql.delete(0,sql.length());
				//IN040761 - commented
				//sql.append("SELECT 'S' TASK_CATEG ,DECODE ('en',?, d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,TRUNC(c.start_date_time) start_date,to_char(c.start_date_time,'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (c.start_date_time, 'HH24:MI') schedule_time_string,b.order_type_code task_type,or_get_desc.or_order_type (b.order_type_code,?,'2') task_type_desc,or_get_order_catalog (b.order_id,b.order_type_code,?,'MD') task_desc,c.order_catalog_code task_code,TO_CHAR (c.start_date_time, 'DD/MM/YYYY') schedule_date_string,NULL task_srl_no,        am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (b.order_status,?,'2') status_desc,get_age (d.date_of_birth) age, to_char(d.date_of_birth,'DD/MM/YYYY') dob, d.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_status order_status,         or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,b.encounter_id encounter_id, b.patient_class patient_class,c.order_line_num order_line_num,b.performing_facility_id performing_facility_id,        b.performing_deptloc_type performing_deptloc_type,b.performing_deptloc_code performing_deptloc_code,        NULL  int_or_ext,'N' image_ref_yn, b.source_type source_type,b.source_code source_code, b.order_type_code order_type_code,b.order_id order_id, b.patient_id patient_id,(select case when  PEND_STATUS_IND IN ('SN')  then 'N|N|N|N|N|_|N|N|N|N|_|N|N|_|Y|N|Y|N|N|'     when  PEND_STATUS_IND IN ('SC') then 'N|N|N|N|N|_|N|N|N|N|_|N|N|_|Y|N|N|Y|N|'      when PEND_STATUS_IND IN ('SD')   THEN 'N|N|N|N|N|_|N|N|N|N|_|N|N|_|Y|N|N|N|Y|' END FROM or_order_pend_status_log IB WHERE IB.ORDER_ID=B.ORDER_ID AND ROWNUM=1 and ib.pend_status_ind in ('SN','SC','SD'))  result_options,CASE  WHEN b.patient_class IN ('IP', 'DC')  THEN ip_get_desc.ip_nursing_unit(b.ordering_facility_id,b.source_code,?,'2') ELSE op_get_desc.op_clinic (b.ordering_facility_id,b.source_code,?,'2') END location_description,NULL admin_status,NULL RESULT_TYPE,NULL RESULT_ID,null cont_order_ind,null APPT_REF_NUM,b.ord_pract_id, NULL consent_status,null order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status FROM or_order_pend_status_log a,or_order b, or_order_line c, mp_patient d,pr_encounter e WHERE b.encounter_id = e.encounter_id and e.facility_id = b.performing_facility_id and b.order_id = c.order_id AND d.patient_id = b.patient_id AND c.order_line_num=1 	AND b.ORDER_CATEGORY = 'LB' AND c.ORDER_ID NOT LIKE 'CS%' AND b.ordering_facility_id=? and a.order_id=c.order_id and a.order_line_num=c.order_line_num and a.order_id = b.order_id and c.start_DATE_time BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND   TO_DATE (?, 'dd/mm/yyyy')  + .99999     AND B.order_status IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('10','15','20')) AND a.pend_status_ind IN ('SN', 'SD', 'SC') /* AND EXISTS (SELECT 'X' FROM OR_ORDER_LINE_LB ib WHERE ORDER_ID = b.ORDER_ID AND ORDER_LINE_NUM = 1  and (NVL (ib.coll_label_gen_rule, 'P') IN ('P') or (NVL (ib.coll_label_gen_rule, 'P') IN ('G', 'X') AND ib.coll_reqd_yn = 'Y'  AND ib.specimen_collect_yn = 'N'  AND ib.specimen_dispatch_yn = 'N'  AND ib.coll_label_gen_date_time IS NULL ) or((ib.dispatch_reqd_yn = 'Y' AND ib.specimen_dispatch_yn = 'N') AND (   ib.coll_reqd_yn = 'N' OR (ib.coll_reqd_yn = 'Y' AND ib.specimen_collect_yn = 'Y')) AND ib.coll_label_gen_rule IN ('G', 'X')  ) ))*/ ");
				
				//IN040761 - added ae_bed_no & ae_pri_zone
				//sql.append("SELECT 'S' TASK_CATEG ,DECODE ('en',?, d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,TRUNC(c.start_date_time) start_date,to_char(c.start_date_time,'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (c.start_date_time, 'HH24:MI') schedule_time_string,b.order_type_code task_type,or_get_desc.or_order_type (b.order_type_code,?,'2') task_type_desc,or_get_order_catalog (b.order_id,b.order_type_code,?,'MD') task_desc,c.order_catalog_code task_code,TO_CHAR (c.start_date_time, 'DD/MM/YYYY') schedule_date_string,NULL task_srl_no,        am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (b.order_status,?,'2') status_desc,get_age (d.date_of_birth) age, to_char(d.date_of_birth,'DD/MM/YYYY') dob, d.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_status order_status,         or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,b.encounter_id encounter_id, b.patient_class patient_class,c.order_line_num order_line_num,b.performing_facility_id performing_facility_id,        b.performing_deptloc_type performing_deptloc_type,b.performing_deptloc_code performing_deptloc_code,        NULL  int_or_ext,'N' image_ref_yn, b.source_type source_type,b.source_code source_code, b.order_type_code order_type_code,b.order_id order_id, b.patient_id patient_id,(select case when  PEND_STATUS_IND IN ('SN')  then 'N|N|N|N|N|_|N|N|N|N|_|N|N|_|Y|N|Y|N|N|'     when  PEND_STATUS_IND IN ('SC') then 'N|N|N|N|N|_|N|N|N|N|_|N|N|_|Y|N|N|Y|N|'      when PEND_STATUS_IND IN ('SD')   THEN 'N|N|N|N|N|_|N|N|N|N|_|N|N|_|Y|N|N|N|Y|' END FROM or_order_pend_status_log IB WHERE IB.ORDER_ID=B.ORDER_ID AND ROWNUM=1 and ib.pend_status_ind in ('SN','SC','SD'))  result_options,CASE  WHEN b.patient_class IN ('IP', 'DC')  THEN ip_get_desc.ip_nursing_unit(b.ordering_facility_id,b.source_code,?,'2') ELSE op_get_desc.op_clinic (b.ordering_facility_id,b.source_code,?,'2') END location_description,NULL admin_status,NULL RESULT_TYPE,NULL RESULT_ID,null cont_order_ind,null APPT_REF_NUM,b.ord_pract_id, NULL consent_status,null order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status ,  e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone FROM or_order_pend_status_log a,or_order b, or_order_line c, mp_patient d,pr_encounter e WHERE b.encounter_id = e.encounter_id and e.facility_id = b.performing_facility_id and b.order_id = c.order_id AND d.patient_id = b.patient_id AND c.order_line_num=1 	AND b.ORDER_CATEGORY = 'LB' AND c.ORDER_ID NOT LIKE 'CS%' AND b.ordering_facility_id=? and a.order_id=c.order_id and a.order_line_num=c.order_line_num and a.order_id = b.order_id and c.start_DATE_time BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND   TO_DATE (?, 'dd/mm/yyyy')  + .99999     AND B.order_status IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('10','15','20')) AND a.pend_status_ind IN ('SN', 'SD', 'SC') /* AND EXISTS (SELECT 'X' FROM OR_ORDER_LINE_LB ib WHERE ORDER_ID = b.ORDER_ID AND ORDER_LINE_NUM = 1  and (NVL (ib.coll_label_gen_rule, 'P') IN ('P') or (NVL (ib.coll_label_gen_rule, 'P') IN ('G', 'X') AND ib.coll_reqd_yn = 'Y'  AND ib.specimen_collect_yn = 'N'  AND ib.specimen_dispatch_yn = 'N'  AND ib.coll_label_gen_date_time IS NULL ) or((ib.dispatch_reqd_yn = 'Y' AND ib.specimen_dispatch_yn = 'N') AND (   ib.coll_reqd_yn = 'N' OR (ib.coll_reqd_yn = 'Y' AND ib.specimen_collect_yn = 'Y')) AND ib.coll_label_gen_rule IN ('G', 'X')  ) ))*/ ");
				//IN061903 start
				//sql.append("SELECT 'S' TASK_CATEG ,DECODE ('en',?, d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,TRUNC(c.start_date_time) start_date,to_char(c.start_date_time,'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (c.start_date_time, 'HH24:MI') schedule_time_string,b.order_type_code task_type,or_get_desc.or_order_type (b.order_type_code,?,'2') task_type_desc,or_get_order_catalog (b.order_id,b.order_type_code,?,'MD') task_desc,c.order_catalog_code task_code,TO_CHAR (c.start_date_time, 'DD/MM/YYYY') schedule_date_string,NULL task_srl_no,        am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (b.order_status,?,'2') status_desc,get_age (d.date_of_birth) age, to_char(d.date_of_birth,'DD/MM/YYYY') dob, d.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_status order_status,         or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,b.encounter_id encounter_id, b.patient_class patient_class,c.order_line_num order_line_num,b.performing_facility_id performing_facility_id,        b.performing_deptloc_type performing_deptloc_type,b.performing_deptloc_code performing_deptloc_code,        NULL  int_or_ext,'N' image_ref_yn, b.source_type source_type,b.source_code source_code, b.order_type_code order_type_code,b.order_id order_id, b.patient_id patient_id,(select case when  PEND_STATUS_IND IN ('SN')  then 'N|N|N|N|N|_|N|N|N|N|_|N|N|_|Y|N|Y|N|N|'     when  PEND_STATUS_IND IN ('SC') then 'N|N|N|N|N|_|N|N|N|N|_|N|N|_|Y|N|N|Y|N|'      when PEND_STATUS_IND IN ('SD')   THEN 'N|N|N|N|N|_|N|N|N|N|_|N|N|_|Y|N|N|N|Y|' END FROM or_order_pend_status_log IB WHERE IB.ORDER_ID=B.ORDER_ID AND ROWNUM=1 and ib.pend_status_ind in ('SN','SC','SD'))  result_options,CASE  WHEN b.patient_class IN ('IP', 'DC')  THEN ip_get_desc.ip_nursing_unit(b.ordering_facility_id,b.source_code,?,'2') ELSE op_get_desc.op_clinic (b.ordering_facility_id,b.source_code,?,'2') END location_description,NULL admin_status,NULL RESULT_TYPE,NULL RESULT_ID,null cont_order_ind,null APPT_REF_NUM,b.ord_pract_id, NULL consent_status,null order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status ,  e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone,e.VISIT_STATUS,e.adt_status FROM or_order_pend_status_log a,or_order b, or_order_line c, mp_patient d,pr_encounter e WHERE b.encounter_id = e.encounter_id and e.facility_id = b.performing_facility_id and b.order_id = c.order_id AND d.patient_id = b.patient_id AND c.order_line_num=1 	AND b.ORDER_CATEGORY = 'LB' AND c.ORDER_ID NOT LIKE 'CS%' AND b.ordering_facility_id=? and a.order_id=c.order_id and a.order_line_num=c.order_line_num and a.order_id = b.order_id and c.start_DATE_time BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND   TO_DATE (?, 'dd/mm/yyyy')  + .99999     AND B.order_status IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('10','15','20')) AND a.pend_status_ind IN ('SN', 'SD', 'SC') /* AND EXISTS (SELECT 'X' FROM OR_ORDER_LINE_LB ib WHERE ORDER_ID = b.ORDER_ID AND ORDER_LINE_NUM = 1  and (NVL (ib.coll_label_gen_rule, 'P') IN ('P') or (NVL (ib.coll_label_gen_rule, 'P') IN ('G', 'X') AND ib.coll_reqd_yn = 'Y'  AND ib.specimen_collect_yn = 'N'  AND ib.specimen_dispatch_yn = 'N'  AND ib.coll_label_gen_date_time IS NULL ) or((ib.dispatch_reqd_yn = 'Y' AND ib.specimen_dispatch_yn = 'N') AND (   ib.coll_reqd_yn = 'N' OR (ib.coll_reqd_yn = 'Y' AND ib.specimen_collect_yn = 'Y')) AND ib.coll_label_gen_rule IN ('G', 'X')  ) ))*/ ");//IN041063
				//sql.append("SELECT 'S' TASK_CATEG ,DECODE ('en',?, d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,TRUNC(c.start_date_time) start_date,to_char(c.start_date_time,'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (c.start_date_time, 'HH24:MI') schedule_time_string,b.order_type_code task_type,or_get_desc.or_order_type (b.order_type_code,?,'2') task_type_desc,or_get_order_catalog (b.order_id,b.order_type_code,?,'MD') task_desc,c.order_catalog_code task_code,TO_CHAR (c.start_date_time, 'DD/MM/YYYY') schedule_date_string,NULL task_srl_no,        am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (b.order_status,?,'2') status_desc,get_age (d.date_of_birth) age, to_char(d.date_of_birth,'DD/MM/YYYY') dob, d.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_status order_status,         or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,b.encounter_id encounter_id, b.patient_class patient_class,c.order_line_num order_line_num,b.performing_facility_id performing_facility_id,        b.performing_deptloc_type performing_deptloc_type,b.performing_deptloc_code performing_deptloc_code,        NULL  int_or_ext,'N' image_ref_yn, b.source_type source_type,b.source_code source_code, b.order_type_code order_type_code,b.order_id order_id, b.patient_id patient_id,(select case when  PEND_STATUS_IND IN ('SN')  then 'N|N|N|N|N|_|N|N|N|N|N|_|N|N|_|Y|N|Y|N|N|'     when  PEND_STATUS_IND IN ('SC') then 'N|N|N|N|N|_|N|N|N|N|N|_|N|N|_|Y|N|N|Y|N|'      when PEND_STATUS_IND IN ('SD')   THEN 'N|N|N|N|N|_|N|N|N|N|N|_|N|N|_|Y|N|N|N|Y|' END FROM or_order_pend_status_log IB WHERE IB.ORDER_ID=B.ORDER_ID AND ROWNUM=1 and ib.pend_status_ind in ('SN','SC','SD'))  result_options,CASE  WHEN b.patient_class IN ('IP', 'DC')  THEN ip_get_desc.ip_nursing_unit(b.ordering_facility_id,b.source_code,?,'2') ELSE op_get_desc.op_clinic (b.ordering_facility_id,b.source_code,?,'2') END location_description,NULL admin_status,NULL RESULT_TYPE,NULL RESULT_ID,null cont_order_ind,null APPT_REF_NUM,b.ord_pract_id, NULL consent_status,null order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status ,  e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone,e.VISIT_STATUS,e.adt_status FROM or_order_pend_status_log a,or_order b, or_order_line c, mp_patient d,pr_encounter e WHERE b.encounter_id = e.encounter_id and e.facility_id = b.performing_facility_id and b.order_id = c.order_id AND d.patient_id = b.patient_id AND c.order_line_num=1 	AND b.ORDER_CATEGORY = 'LB' AND c.ORDER_ID NOT LIKE 'CS%' AND b.ordering_facility_id=? and a.order_id=c.order_id and a.order_line_num=c.order_line_num and a.order_id = b.order_id and c.start_DATE_time BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND   TO_DATE (?, 'dd/mm/yyyy')  + .99999     AND B.order_status IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('10','15','20')) AND a.pend_status_ind IN ('SN', 'SD', 'SC') /* AND EXISTS (SELECT 'X' FROM OR_ORDER_LINE_LB ib WHERE ORDER_ID = b.ORDER_ID AND ORDER_LINE_NUM = 1  and (NVL (ib.coll_label_gen_rule, 'P') IN ('P') or (NVL (ib.coll_label_gen_rule, 'P') IN ('G', 'X') AND ib.coll_reqd_yn = 'Y'  AND ib.specimen_collect_yn = 'N'  AND ib.specimen_dispatch_yn = 'N'  AND ib.coll_label_gen_date_time IS NULL ) or((ib.dispatch_reqd_yn = 'Y' AND ib.specimen_dispatch_yn = 'N') AND (   ib.coll_reqd_yn = 'N' OR (ib.coll_reqd_yn = 'Y' AND ib.specimen_collect_yn = 'Y')) AND ib.coll_label_gen_rule IN ('G', 'X')  ) ))*/ ");//IN065942
				sql.append("SELECT 'S' TASK_CATEG ,DECODE ('en',?, d.patient_name,NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,TRUNC(c.start_date_time) start_date,to_char(c.start_date_time,'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (c.start_date_time, 'HH24:MI') schedule_time_string,b.order_type_code task_type,or_get_desc.or_order_type (b.order_type_code,?,'2') task_type_desc,or_get_order_catalog (b.order_id,b.order_type_code,?,'MD') task_desc,c.order_catalog_code task_code,TO_CHAR (c.start_date_time, 'DD/MM/YYYY') schedule_date_string,NULL task_srl_no,        am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (b.order_status,?,'2') status_desc,get_age (d.date_of_birth) age, to_char(d.date_of_birth,'DD/MM/YYYY') dob, d.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_status order_status,         or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,b.encounter_id encounter_id, b.patient_class patient_class,c.order_line_num order_line_num,b.performing_facility_id performing_facility_id,        b.performing_deptloc_type performing_deptloc_type,b.performing_deptloc_code performing_deptloc_code,        NULL  int_or_ext,'N' image_ref_yn, b.source_type source_type,b.source_code source_code, b.order_type_code order_type_code,b.order_id order_id, b.patient_id patient_id,(select case when  PEND_STATUS_IND IN ('SN')  then 'N|N|N|N|N|_|N|N|N|N|N|_|N|N|_|Y|N|Y|N|N|'     when  PEND_STATUS_IND IN ('SC') then 'N|N|N|N|N|_|N|N|N|N|N|_|N|N|_|Y|N|N|Y|N|'      when PEND_STATUS_IND IN ('SD')   THEN 'N|N|N|N|N|_|N|N|N|N|N|_|N|N|_|Y|N|N|N|Y|' END FROM or_order_pend_status_log IB WHERE IB.ORDER_ID=B.ORDER_ID AND ROWNUM=1 and ib.pend_status_ind in ('SN','SC','SD'))  result_options,CASE  WHEN b.patient_class IN ('IP', 'DC')  THEN ip_get_desc.ip_nursing_unit(b.ordering_facility_id,b.source_code,?,'2') ELSE op_get_desc.op_clinic (b.ordering_facility_id,b.source_code,?,'2') END location_description,NULL admin_status,NULL RESULT_TYPE,NULL RESULT_ID,null cont_order_ind,null APPT_REF_NUM,b.ord_pract_id, NULL consent_status,null order_set_id, NULL SPECIMEN_NO, NULL OPERATING_FACILITY_ID,NULL UNIT_NO, NULL PRODUCT_CODE, NULL row_id, NULL bt_status ,  e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone,e.VISIT_STATUS,e.adt_status,'N' prn_reg_ord FROM or_order_pend_status_log a,or_order b, or_order_line c, mp_patient d,pr_encounter e WHERE b.encounter_id = e.encounter_id and e.facility_id = b.performing_facility_id and b.order_id = c.order_id AND d.patient_id = b.patient_id AND c.order_line_num=1 	AND b.ORDER_CATEGORY = 'LB' AND c.ORDER_ID NOT LIKE 'CS%' AND b.ordering_facility_id=? and a.order_id=c.order_id and a.order_line_num=c.order_line_num and a.order_id = b.order_id and c.start_DATE_time BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND   TO_DATE (?, 'dd/mm/yyyy')  + .99999     AND B.order_status IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('10','15','20')) AND a.pend_status_ind IN ('SN', 'SD', 'SC') /* AND EXISTS (SELECT 'X' FROM OR_ORDER_LINE_LB ib WHERE ORDER_ID = b.ORDER_ID AND ORDER_LINE_NUM = 1  and (NVL (ib.coll_label_gen_rule, 'P') IN ('P') or (NVL (ib.coll_label_gen_rule, 'P') IN ('G', 'X') AND ib.coll_reqd_yn = 'Y'  AND ib.specimen_collect_yn = 'N'  AND ib.specimen_dispatch_yn = 'N'  AND ib.coll_label_gen_date_time IS NULL ) or((ib.dispatch_reqd_yn = 'Y' AND ib.specimen_dispatch_yn = 'N') AND (   ib.coll_reqd_yn = 'N' OR (ib.coll_reqd_yn = 'Y' AND ib.specimen_collect_yn = 'Y')) AND ib.coll_label_gen_rule IN ('G', 'X')  ) ))*/ ");//IN065942
				//IN061903 ENDS
				if(patient_id.equals(""))
				sql.append("and b.patient_id like ? ");
			else
				sql.append("and b.patient_id = ? ");


			if(location_type.equals(""))
			{
				sql.append("AND  e.ASSIGN_CARE_LOCN_TYPE like ? ");
			}
			else
			{
				if(location_type.equals("C"))
				{
					sql.append("AND  e.ASSIGN_CARE_LOCN_TYPE in ('C','E') ");
				}
				else
				{
					sql.append("AND  e.ASSIGN_CARE_LOCN_TYPE=? ");
				}
			}

			if(locn_code.equals(""))
			sql.append("AND  e.ASSIGN_CARE_LOCN_CODE like ? ");
			else
			sql.append("AND e.ASSIGN_CARE_LOCN_CODE=? ");

			if(OrderCategory.equals(""))
			sql.append("AND  B.ORDER_CATEGORY like ? ");
			else
			sql.append("AND  B.ORDER_CATEGORY=? ");

			if(OrderType.equals(""))
			sql.append("AND  B.ORDER_TYPE_CODE like ? ");
			else
			sql.append("AND  B.ORDER_TYPE_CODE=? ");

			sql.append("AND  B.PERFORMING_FACILITY_ID=? ");

			//PE Changes by Shaiju Starts

		//	if((taskSelect.equals("") && specCollection.equals("CA_TASK_LIST_MSPECI")) && chkUnclassify.equals("Y"))   //Specimen
		//	{
				
				if(!(sql.toString()).equals(""))
				{
					if (Groupby.equals("P"))
					{
						sql.append("ORDER BY 2, b.patient_id,3 DESC, 5 ASC ");
					}else if (Groupby.equals("T"))
					{
						sql.append("ORDER BY  3 DESC, 5 ASC, 2 ");
					}
				
					pstmt = connection.prepareStatement(sql.toString()) ;
					System.out.println("sql.toString()========>1614=============pattasklistrepository====>"+sql.toString());
					i=0;
					
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
				//	pstmt.setString( 5, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, facilityId);
					pstmt.setString( ++i, From_date);
					pstmt.setString( ++i, To_date);
					if(patient_id.equals(""))
					pstmt.setString( ++i, ALL);
					else
					pstmt.setString( ++i, patient_id);
					if(location_type.equals(""))
					{
						pstmt.setString( ++i, ALL);
					}
					else
					{
						if(!location_type.equals("C"))
						{
							pstmt.setString( ++i, location_type);
						}
					}
					if(locn_code.equals(""))
					pstmt.setString( ++i, ALL);
					else
					pstmt.setString( ++i, locn_code);

					if(OrderCategory.equals(""))
					pstmt.setString( ++i, ALL);
					else
					pstmt.setString(++i, OrderCategory);

					if(OrderType.equals(""))
					pstmt.setString( ++i, ALL);
					else
					pstmt.setString( ++i, OrderType);

					pstmt.setString( ++i, facilityId);

					resultSet = pstmt.executeQuery() ;

						if(resultSet!=null) {
						if(start > 0)
						{
							for(k=0;(k<start-1 && resultSet.next());k++);
							start = start-k;
						}

						while ( start_tmp <= end && resultSet!=null && resultSet.next()) {
					//while ( resultSet != null && resultSet.next() ) {
						/**
						Modified by Deepa on 5/17/2010 at 12:08 PM for IN021020
						increased the size of taskResult_val to 50 from 49, to include dob in the array
						**/
						//String[] taskResult_val 			= new String[51];
						//String[] taskResult_val 			= new String[54]; //IN030473	[//IN040761 increased to 54 from 52]
						//String[] taskResult_val 			= new String[56]; //IN041063	[//IN041063  increased to 56 from 54]//IN065942
						//String[] taskResult_val 			= new String[58]; //IN041063	[//IN041063  increased to 56 from 54]//IN065942//IN071618						
						String[] taskResult_val 			= new String[59]; //26826
						taskResult_val[0] = checkForNull(resultSet.getString("task_type"))  ;
						taskResult_val[1] = checkForNull(resultSet.getString("task_type_desc").trim())  ;
						taskResult_val[2] = checkForNull(resultSet.getString("task_code"))  ;
						taskResult_val[3] = checkForNull(resultSet.getString("schedule_date").trim())  ;
						taskResult_val[4] = checkForNull(resultSet.getString("schedule_date_string").trim())  ;
						taskResult_val[5] = checkForNull(resultSet.getString("Admin_Status"))  ;
						taskResult_val[6] = checkForNull(resultSet.getString("task_srl_no"))  ;
						taskResult_val[7] = checkForNull(resultSet.getString("ordering_pract_name"))  ;
						taskResult_val[8] = checkForNull(resultSet.getString("priority"))  ;
						taskResult_val[9] = checkForNull(resultSet.getString("stage_short_desc"))  ;
						taskResult_val[10] = checkForNull(resultSet.getString("position_code"))  ;
						taskResult_val[11] = checkForNull(resultSet.getString("status_desc"))  ;
						taskResult_val[12] = checkForNull(resultSet.getString("patient_name"))  ;
						taskResult_val[13] = checkForNull(resultSet.getString("age"))  ;
						taskResult_val[14] = checkForNull(resultSet.getString("sex"))  ;
						taskResult_val[15] = checkForNull(resultSet.getString("task_desc"))  ;
						taskResult_val[16] = checkForNull(resultSet.getString("Result_options"))  ;
						taskResult_val[17] = checkForNull(resultSet.getString("schedule_time_string").trim())  ;
						taskResult_val[18] = checkForNull(resultSet.getString("order_category_short_desc"))  ;
						taskResult_val[19] = checkForNull(resultSet.getString("order_id"))  ;
						taskResult_val[20] = checkForNull(resultSet.getString("encounter_id"))  ;
						taskResult_val[21] = checkForNull(resultSet.getString("patient_class"))  ;
						taskResult_val[22] = checkForNull(resultSet.getString("patient_id"))  ;
						taskResult_val[23] = checkForNull(resultSet.getString("order_category"))  ;
						taskResult_val[24] = checkForNull(resultSet.getString("order_status"))  ;
						taskResult_val[25] = checkForNull(resultSet.getString("order_line_num"))  ;
						taskResult_val[26] = checkForNull(resultSet.getString("performing_facility_id"))  ;
						taskResult_val[27] = checkForNull(resultSet.getString("performing_deptloc_type"))  ;
						taskResult_val[28] = checkForNull(resultSet.getString("performing_deptloc_code"))  ;
						taskResult_val[29] = checkForNull(resultSet.getString("int_or_ext"))  ;
						taskResult_val[30] = checkForNull(resultSet.getString("order_type_code"))  ;
						taskResult_val[31] = checkForNull(resultSet.getString("source_type"))  ;
						taskResult_val[32] = checkForNull(resultSet.getString("source_code"))  ;
						taskResult_val[33] = checkForNull(resultSet.getString("location_description"))  ;
						taskResult_val[34] = checkForNull(resultSet.getString("TASK_CATEG"))  ;
						taskResult_val[35] = checkForNull(resultSet.getString("RESULT_TYPE"))  ;
						taskResult_val[36] = checkForNull(resultSet.getString("RESULT_ID"))  ;
						taskResult_val[37] = checkForNull(resultSet.getString("cont_order_ind"))  ;
						taskResult_val[38] = checkForNull(resultSet.getString("APPT_REF_NUM"))  ;
						taskResult_val[39] = checkForNull(resultSet.getString("ord_pract_id"))  ;
						taskResult_val[40] = checkForNull(resultSet.getString("consent_status"))  ;
						taskResult_val[41] = checkForNull(resultSet.getString("order_set_id"))  ;
						taskResult_val[42] = checkForNull(resultSet.getString("SPECIMEN_NO"))  ;
						taskResult_val[43] = checkForNull(resultSet.getString("OPERATING_FACILITY_ID"))  ;
						taskResult_val[44] = checkForNull(resultSet.getString("UNIT_NO"))  ;
						taskResult_val[45] = checkForNull(resultSet.getString("PRODUCT_CODE"))  ;
						taskResult_val[46] = checkForNull(resultSet.getString("row_id"))  ;
						taskResult_val[47] = checkForNull(resultSet.getString("bt_status"))  ;
						taskResult_val[49] = checkForNull(resultSet.getString("dob"))  ;
						taskResult_val[50] = ""  ;
						taskResult_val[51] = ""  ;
						taskResult_val[52] = checkForNull(resultSet.getString("ae_bed_no"))  ; //IN040761
						taskResult_val[53] = checkForNull(resultSet.getString("ae_pri_zone")) ; //IN040761						
						taskResult_val[54] = checkForNull(resultSet.getString("VISIT_STATUS")) ; //IN041063
						taskResult_val[55] = checkForNull(resultSet.getString("ADT_STATUS")) ; //IN041063
						taskResult_val[56] = checkForNull(resultSet.getString("prn_reg_ord")) ; //IN065942
						taskResult_val[57] = "" ;	//IN071618
						taskResult_val[58] = "" ;//	26826
						taskResult.add(taskResult_val);
						start_tmp++;

					}
						if (resultSet.next())
						{
							String[] templist = (String[])taskResult.get(0);
							templist[48] = ""+(end+50);
							taskResult.set(0,templist);
						}
					}

			
			
			}

		//	}





			//PE Changes by Shaiju Ends
			}
			
		//	System.out.println("bloodUnit========>404=================pattasklistrepository====>"+bloodUnit);
			
			if((taskSelect.equals("B") || (taskSelect.equals("") && bloodUnit.equals("CA_TASK_LIST_BLDCONS"))) && chkUnclassify.equals("Y"))
			{
				//if(taskSelect.equals(""))
				//	sql.append(" UNION ALL ");
				if(sql.length() > 0) sql.delete(0,sql.length());
				//sql.append("SELECT 'B' task_categ,DECODE ('en',?, d.patient_name, NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,TRUNC (a.required_date) start_date, TO_CHAR (a.required_date, 'dd/mm/yyyy HH24:MI') schedule_date, TO_CHAR (a.required_date, 'HH24:MI') schedule_time_string,       b.order_type_code task_type, or_get_desc.or_order_type (b.order_type_code, 'en', '2') task_type_desc, or_get_order_catalog (b.order_id, b.order_type_code, 'en', 'MD',c.ORDER_LINE_NUM )||'-('||A.unit_no||')' task_desc, c.order_catalog_code task_code, TO_CHAR (a.required_date, 'DD/MM/YYYY') schedule_date_string, NULL task_srl_no,am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (b.order_status, ?,'2') status_desc,get_age (d.date_of_birth) age, to_char(d.date_of_birth,'DD/MM/YYYY') dob, d.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_status order_status,or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,b.encounter_id encounter_id, b.patient_class patient_class,c.order_line_num order_line_num,b.performing_facility_id performing_facility_id,b.performing_deptloc_type performing_deptloc_type,b.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext FROM or_performing_deptloc  WHERE performing_facility_id = b.performing_facility_id  AND performing_deptloc_type = b.performing_deptloc_type AND performing_deptloc_code = b.performing_deptloc_code) int_or_ext,'N' image_ref_yn, b.source_type source_type, b.source_code source_code,b.order_type_code order_type_code, b.order_id order_id, b.patient_id patient_id, A.result_options,CASE WHEN b.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(b.ordering_facility_id,b.source_code,?, '2')ELSE op_get_desc.op_clinic (b.ordering_facility_id, b.source_code, ?, '2' ) END location_description,NULL admin_status, NULL result_type, NULL result_id, b.cont_order_ind,c.appt_ref_num, b.ord_pract_id, TO_CHAR (NULL) consent_status,b.order_set_id order_set_id,A.specimen_no SPECIMEN_NO, A.operating_facility_id OPERATING_FACILITY_ID,A.unit_no UNIT_NO, A.product_code PRODUCT_CODE, A.ROWID row_id, CASE WHEN unit_status = 'UR' AND REQUEST_FOR_ISSUE_BY IS NULL THEN 'ReserveNotRequest'  WHEN unit_status='UR' AND REQUEST_FOR_ISSUE_BY IS NOT NULL THEN 'ReserveAndRequest' WHEN unit_status='UI' THEN 'Issued' WHEN unit_status='UT' THEN 'Transfused' END bt_status, f.assign_bed_num ae_bed_no '<span style = background-color:' || decode(f.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= f.PRIORITY_ZONE) || '</span>' ae_pri_zone FROM (SELECT patient_id,unit_status,REQUEST_FOR_ISSUE_BY,product_code,unit_no, operating_facility_id,CASE WHEN unit_status = 'UR' THEN RESERVED_DATE  WHEN unit_status='UI' THEN ISSUED_DATE WHEN unit_status='UT' THEN TRANSFUSE_ST_DATE_TIME END required_date, CA_BT_GET_OPTION(patient_id,REQUEST_FOR_ISSUE_BY,UNIT_STATUS)  result_options,specimen_no FROM bt_unit_request_dtl b WHERE "); //IN041260
				//sql.append("SELECT 'B' task_categ,DECODE ('en',?, d.patient_name, NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,TRUNC (a.required_date) start_date, TO_CHAR (a.required_date, 'dd/mm/yyyy HH24:MI') schedule_date, TO_CHAR (a.required_date, 'HH24:MI') schedule_time_string,       b.order_type_code task_type, or_get_desc.or_order_type (b.order_type_code, 'en', '2') task_type_desc, or_get_order_catalog (b.order_id, b.order_type_code, 'en', 'MD',c.ORDER_LINE_NUM )||'-('||A.unit_no||')' task_desc, c.order_catalog_code task_code, TO_CHAR (a.required_date, 'DD/MM/YYYY') schedule_date_string, NULL task_srl_no,am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (b.order_status, ?,'2') status_desc,get_age (d.date_of_birth) age, to_char(d.date_of_birth,'DD/MM/YYYY') dob, d.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_status order_status,or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,b.encounter_id encounter_id, b.patient_class patient_class,c.order_line_num order_line_num,b.performing_facility_id performing_facility_id,b.performing_deptloc_type performing_deptloc_type,b.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext FROM or_performing_deptloc  WHERE performing_facility_id = b.performing_facility_id  AND performing_deptloc_type = b.performing_deptloc_type AND performing_deptloc_code = b.performing_deptloc_code) int_or_ext,'N' image_ref_yn, b.source_type source_type, b.source_code source_code,b.order_type_code order_type_code, b.order_id order_id, b.patient_id patient_id, A.result_options,CASE WHEN b.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(b.ordering_facility_id,b.source_code,?, '2')ELSE op_get_desc.op_clinic (b.ordering_facility_id, b.source_code, ?, '2' ) END location_description,NULL admin_status, NULL result_type, NULL result_id, b.cont_order_ind,c.appt_ref_num, b.ord_pract_id, TO_CHAR (NULL) consent_status,b.order_set_id order_set_id,A.specimen_no SPECIMEN_NO, A.operating_facility_id OPERATING_FACILITY_ID,A.unit_no UNIT_NO, A.product_code PRODUCT_CODE, A.ROWID row_id, CASE WHEN unit_status = 'UR' AND REQUEST_FOR_ISSUE_BY IS NULL THEN 'ReserveNotRequest'  WHEN unit_status='UR' AND REQUEST_FOR_ISSUE_BY IS NOT NULL THEN 'ReserveAndRequest' WHEN unit_status='UI' THEN 'Issued' WHEN unit_status='UT' THEN 'Transfused' END bt_status, f.assign_bed_num ae_bed_no,f.VISIT_STATUS,f.adt_status, '<span style = background-color:' || decode(f.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= f.PRIORITY_ZONE) || '</span>' ae_pri_zone FROM (SELECT patient_id,unit_status,REQUEST_FOR_ISSUE_BY,product_code,unit_no, operating_facility_id,CASE WHEN unit_status = 'UR' THEN RESERVED_DATE  WHEN unit_status='UI' THEN ISSUED_DATE WHEN unit_status='UT' THEN TRANSFUSE_ST_DATE_TIME END required_date, CA_BT_GET_OPTION(patient_id,REQUEST_FOR_ISSUE_BY,UNIT_STATUS)  result_options,specimen_no FROM bt_unit_request_dtl b WHERE "); //IN041260//IN065942
				sql.append("SELECT 'B' task_categ,DECODE ('en',?, d.patient_name, NVL (d.patient_name_loc_lang, d.patient_name)) patient_name,TRUNC (a.required_date) start_date, TO_CHAR (a.required_date, 'dd/mm/yyyy HH24:MI') schedule_date, TO_CHAR (a.required_date, 'HH24:MI') schedule_time_string,       b.order_type_code task_type, or_get_desc.or_order_type (b.order_type_code, 'en', '2') task_type_desc, or_get_order_catalog (b.order_id, b.order_type_code, 'en', 'MD',c.ORDER_LINE_NUM )||'-('||A.unit_no||')' task_desc, c.order_catalog_code task_code, TO_CHAR (a.required_date, 'DD/MM/YYYY') schedule_date_string, NULL task_srl_no,am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (b.order_status, ?,'2') status_desc,get_age (d.date_of_birth) age, to_char(d.date_of_birth,'DD/MM/YYYY') dob, d.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_status order_status,or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,b.encounter_id encounter_id, b.patient_class patient_class,c.order_line_num order_line_num,b.performing_facility_id performing_facility_id,b.performing_deptloc_type performing_deptloc_type,b.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext FROM or_performing_deptloc  WHERE performing_facility_id = b.performing_facility_id  AND performing_deptloc_type = b.performing_deptloc_type AND performing_deptloc_code = b.performing_deptloc_code) int_or_ext,'N' image_ref_yn, b.source_type source_type, b.source_code source_code,b.order_type_code order_type_code, b.order_id order_id, b.patient_id patient_id, A.result_options,CASE WHEN b.patient_class IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit(b.ordering_facility_id,b.source_code,?, '2')ELSE op_get_desc.op_clinic (b.ordering_facility_id, b.source_code, ?, '2' ) END location_description,NULL admin_status, NULL result_type, NULL result_id, b.cont_order_ind,c.appt_ref_num, b.ord_pract_id, TO_CHAR (NULL) consent_status,b.order_set_id order_set_id,A.specimen_no SPECIMEN_NO, A.operating_facility_id OPERATING_FACILITY_ID,A.unit_no UNIT_NO, A.product_code PRODUCT_CODE, A.ROWID row_id, CASE WHEN unit_status = 'UR' AND REQUEST_FOR_ISSUE_BY IS NULL THEN 'ReserveNotRequest'  WHEN unit_status='UR' AND REQUEST_FOR_ISSUE_BY IS NOT NULL THEN 'ReserveAndRequest' WHEN unit_status='UI' THEN 'Issued' WHEN unit_status='UT' THEN 'Transfused' END bt_status, f.assign_bed_num ae_bed_no,f.VISIT_STATUS,f.adt_status,'N' prn_reg_ord, '<span style = background-color:' || decode(f.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= f.PRIORITY_ZONE) || '</span>' ae_pri_zone FROM (SELECT patient_id,unit_status,REQUEST_FOR_ISSUE_BY,product_code,unit_no, operating_facility_id,CASE WHEN unit_status = 'UR' THEN RESERVED_DATE  WHEN unit_status='UI' THEN ISSUED_DATE WHEN unit_status='UT' THEN TRANSFUSE_ST_DATE_TIME END required_date, CA_BT_GET_OPTION(patient_id,REQUEST_FOR_ISSUE_BY,UNIT_STATUS)  result_options,specimen_no FROM bt_unit_request_dtl b WHERE "); //IN041260//IN065942
				
				if(!patient_id.equals(""))
					sql.append(" b.patient_id = ? ");
				else
				{
					if(location_type.equals(""))
						sql.append(" b.patient_id in (select patient_id from ip_open_encounter where FACILITY_ID = ? and NURSING_UNIT_CODE = ? ) ");
					else
						sql.append(" exists (select 1 from pr_encounter where FACILITY_ID = ? and ASSIGN_CARE_LOCN_TYPE = ? and ASSIGN_CARE_LOCN_CODE = ?  and patient_id = b.patient_id) ");
				}
				
				
				sql.append(" and unit_status in('UR','UI','UT') ");

				//sql.append("  ) A, or_order b, or_order_line c, mp_patient d,or_order_catalog e WHERE c.accession_num = TO_CHAR (a.specimen_no) AND c.order_id = b.order_id AND d.patient_id = a.patient_id and e.order_catalog_code =c.order_catalog_code and a.product_code=e.CONTR_MSR_PANEL_ID and PERFORMING_FACILITY_ID = ? ");//IN034216
				sql.append("  ) A, or_order b, or_order_line c, mp_patient d,or_order_catalog e,pr_encounter f WHERE b.encounter_id = f.encounter_id and f.facility_id = b.performing_facility_id and c.accession_num = TO_CHAR (a.specimen_no) AND c.order_id = b.order_id AND d.patient_id = a.patient_id and e.order_catalog_code =c.order_catalog_code and a.product_code=e.CONTR_MSR_PANEL_ID and ORDERING_FACILITY_ID = ? ");//IN034216

				if(!patient_id.equals(""))
					sql.append(" AND a.patient_id = ? ");
				else
				{
					if(location_type.equals(""))
						sql.append(" AND a.patient_id in (select patient_id from ip_open_encounter where FACILITY_ID = ? and NURSING_UNIT_CODE = ? ) ");
					else
						sql.append(" AND exists (select 1 from pr_encounter where FACILITY_ID = ? and ASSIGN_CARE_LOCN_TYPE = ? and ASSIGN_CARE_LOCN_CODE = ?  and patient_id = a.patient_id) ");
				}

				if(bt_status.equals("UR"))
					sql.append(" AND a.unit_status = 'UR' AND a.REQUEST_FOR_ISSUE_BY is not null ");
				else if(bt_status.equals("URN"))
					sql.append(" AND a.unit_status = 'UR' AND a.REQUEST_FOR_ISSUE_BY is null ");
				else if(bt_status.equals("UI"))
					sql.append(" AND a.unit_status = 'UI' ");
				else if(bt_status.equals("UT"))
					sql.append(" AND a.unit_status = 'UT' ");
				sql.append(" AND a.required_date between TO_DATE(rtrim(?),'DD/MM/YYYY HH24:MI') AND TO_DATE(rtrim(?),'DD/MM/YYYY HH24:MI')+.99999 ");

					//PE Changes by Shaiju Starts

		//	if(((taskSelect.equals("") && bloodUnit.equals("CA_TASK_LIST_BLDCONS")))&& chkUnclassify.equals("Y"))
		//	{
				
				if(!(sql.toString()).equals(""))
				{
					if (Groupby.equals("P"))
					{
						sql.append("ORDER BY 2, b.patient_id,3 DESC, 5 ASC ");
					}else if (Groupby.equals("T"))
					{
						sql.append("ORDER BY  3 DESC, 5 ASC, 2 ");
					}
					pstmt = connection.prepareStatement(sql.toString()) ;
					System.out.println("sql.toString()========>1822==============pattasklistrepository====>"+sql.toString());
					i=0;
					
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
					pstmt.setString( ++i, locale);
					
					if(!patient_id.equals(""))
						pstmt.setString( ++i, patient_id);
					else
					{
						if(location_type.equals(""))
						{
							pstmt.setString( ++i, facilityId);
							pstmt.setString( ++i, locn_code);
						}
						else
						{
							pstmt.setString( ++i, facilityId);
							pstmt.setString( ++i, location_type);
							pstmt.setString( ++i, locn_code);
						}
					}

					pstmt.setString( ++i, facilityId);
					if(!patient_id.equals(""))
						pstmt.setString( ++i, patient_id);
					else
					{
						if(location_type.equals(""))
						{
							pstmt.setString( ++i, facilityId);
							pstmt.setString( ++i, locn_code);
						}
						else
						{
							pstmt.setString( ++i, facilityId);
							pstmt.setString( ++i, location_type);
							pstmt.setString( ++i, locn_code);
						}
					}
				  pstmt.setString( ++i, From_date);
				  pstmt.setString( ++i, To_date);


				  resultSet = pstmt.executeQuery() ;

						if(resultSet!=null) {
						if(start > 0)
						{
							for(k=0;(k<start-1 && resultSet.next());k++);
							start = start-k;
						}
						while ( start_tmp <= end && resultSet!=null && resultSet.next()) {
					//while ( resultSet != null && resultSet.next() ) {
						/**
						Modified by Deepa on 5/17/2010 at 12:08 PM for IN021020
						increased the size of taskResult_val to 50 from 49, to include dob in the array
						**/
						//String[] taskResult_val 			= new String[51];
						//String[] taskResult_val 			= new String[54]; //IN030473	[increased to 54 from 52]  //IN041260
						//String[] taskResult_val 			= new String[56]; //IN030473	[increased to 56 from 54]	//IN041260//IN065942
						//String[] taskResult_val 			= new String[58]; //IN030473	[increased to 56 from 54]	//IN041260//IN065942
						String[] taskResult_val 			= new String[59]; //26826
						taskResult_val[0] = checkForNull(resultSet.getString("task_type"))  ;
						taskResult_val[1] = checkForNull(resultSet.getString("task_type_desc").trim())  ;
						taskResult_val[2] = checkForNull(resultSet.getString("task_code"))  ;
						taskResult_val[3] = checkForNull(resultSet.getString("schedule_date").trim())  ;
						taskResult_val[4] = checkForNull(resultSet.getString("schedule_date_string").trim())  ;
						taskResult_val[5] = checkForNull(resultSet.getString("Admin_Status"))  ;
						taskResult_val[6] = checkForNull(resultSet.getString("task_srl_no"))  ;
						taskResult_val[7] = checkForNull(resultSet.getString("ordering_pract_name"))  ;
						taskResult_val[8] = checkForNull(resultSet.getString("priority"))  ;
						taskResult_val[9] = checkForNull(resultSet.getString("stage_short_desc"))  ;
						taskResult_val[10] = checkForNull(resultSet.getString("position_code"))  ;
						taskResult_val[11] = checkForNull(resultSet.getString("status_desc"))  ;
						taskResult_val[12] = checkForNull(resultSet.getString("patient_name"))  ;
						taskResult_val[13] = checkForNull(resultSet.getString("age"))  ;
						taskResult_val[14] = checkForNull(resultSet.getString("sex"))  ;
						taskResult_val[15] = checkForNull(resultSet.getString("task_desc"))  ;
						taskResult_val[16] = checkForNull(resultSet.getString("Result_options"))  ;
						taskResult_val[17] = checkForNull(resultSet.getString("schedule_time_string").trim())  ;
						taskResult_val[18] = checkForNull(resultSet.getString("order_category_short_desc"))  ;
						taskResult_val[19] = checkForNull(resultSet.getString("order_id"))  ;
						taskResult_val[20] = checkForNull(resultSet.getString("encounter_id"))  ;
						taskResult_val[21] = checkForNull(resultSet.getString("patient_class"))  ;
						taskResult_val[22] = checkForNull(resultSet.getString("patient_id"))  ;
						taskResult_val[23] = checkForNull(resultSet.getString("order_category"))  ;
						taskResult_val[24] = checkForNull(resultSet.getString("order_status"))  ;
						taskResult_val[25] = checkForNull(resultSet.getString("order_line_num"))  ;
						taskResult_val[26] = checkForNull(resultSet.getString("performing_facility_id"))  ;
						taskResult_val[27] = checkForNull(resultSet.getString("performing_deptloc_type"))  ;
						taskResult_val[28] = checkForNull(resultSet.getString("performing_deptloc_code"))  ;
						taskResult_val[29] = checkForNull(resultSet.getString("int_or_ext"))  ;
						taskResult_val[30] = checkForNull(resultSet.getString("order_type_code"))  ;
						taskResult_val[31] = checkForNull(resultSet.getString("source_type"))  ;
						taskResult_val[32] = checkForNull(resultSet.getString("source_code"))  ;
						taskResult_val[33] = checkForNull(resultSet.getString("location_description"))  ;
						taskResult_val[34] = checkForNull(resultSet.getString("TASK_CATEG"))  ;
						taskResult_val[35] = checkForNull(resultSet.getString("RESULT_TYPE"))  ;
						taskResult_val[36] = checkForNull(resultSet.getString("RESULT_ID"))  ;
						taskResult_val[37] = checkForNull(resultSet.getString("cont_order_ind"))  ;
						taskResult_val[38] = checkForNull(resultSet.getString("APPT_REF_NUM"))  ;
						taskResult_val[39] = checkForNull(resultSet.getString("ord_pract_id"))  ;
						taskResult_val[40] = checkForNull(resultSet.getString("consent_status"))  ;
						taskResult_val[41] = checkForNull(resultSet.getString("order_set_id"))  ;
						taskResult_val[42] = checkForNull(resultSet.getString("SPECIMEN_NO"))  ;
						taskResult_val[43] = checkForNull(resultSet.getString("OPERATING_FACILITY_ID"))  ;
						taskResult_val[44] = checkForNull(resultSet.getString("UNIT_NO"))  ;
						taskResult_val[45] = checkForNull(resultSet.getString("PRODUCT_CODE"))  ;
						taskResult_val[46] = checkForNull(resultSet.getString("row_id"))  ;
						taskResult_val[47] = checkForNull(resultSet.getString("bt_status"))  ;
						taskResult_val[49] = checkForNull(resultSet.getString("dob"))  ;
						taskResult_val[50] = ""  ;
						taskResult_val[51] = ""  ;//IN030473
						taskResult_val[52] = checkForNull(resultSet.getString("ae_bed_no"))   ; //IN040761
						taskResult_val[53] = checkForNull(resultSet.getString("ae_pri_zone"))  ;//IN040761
						taskResult_val[54] = checkForNull(resultSet.getString("VISIT_STATUS"))  ;//IN041063
						taskResult_val[55] = checkForNull(resultSet.getString("ADT_STATUS"))  ;//IN041063
						taskResult_val[56] = checkForNull(resultSet.getString("prn_reg_ord"))  ;//IN065942
						taskResult_val[57] = "" ;	//IN071618
						taskResult_val[58] = "" ;//	26826
						taskResult.add(taskResult_val);
						start_tmp++;

					}
						if (resultSet.next())
						{
							String[] templist = (String[])taskResult.get(0);
							templist[48] = ""+(end+50);
							taskResult.set(0,templist);
						}
					}

			
			
			
			
			}
		//	}




					//PE Changes by Shaiju Ends
			}
		//IN29559,starts
			System.out.println("recConsent========>404=================pattasklistrepository====>"+recConsent);
		if(taskSelect.equals("C") || (taskSelect.equals("") && recConsent.equals("CA_TASK_LIST_RECCONS")) && chkUnclassify.equals("Y"))
		{
			if(sql.length() > 0) sql.delete(0,sql.length());
			//IN040761 - commented
			//sql.append("SELECT 'C' task_categ,DECODE ('en',?, c.patient_name,NVL (c.patient_name_loc_lang, c.patient_name)) patient_name,TRUNC(b.ord_date_time) start_date,TO_CHAR (b.ord_date_time, 'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (b.ord_date_time, 'HH24:MI') schedule_time_string,b.order_type_code task_type,or_get_desc.or_order_type (b.order_type_code, ?, '2') task_type_desc,/*or_get_order_catalog (b.order_id,b.order_type_code,?,'MD',b.order_line_num,'Y') task_desc*/ OR_GET_ORDER_CATALOG(d.ORDER_ID,d.ORDER_TYPE_CODE,?) task_desc,b.order_catalog_code task_code,TO_CHAR (b.ord_date_time, 'DD/MM/YYYY') schedule_date_string,NULL task_srl_no,am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (b.order_line_status,?,'2')status_desc,get_age (c.date_of_birth) age,TO_CHAR (c.date_of_birth, 'DD/MM/YYYY') dob, c.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_line_status order_status,or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,a.encounter_id encounter_id, a.patient_class patient_class,b.order_line_num order_line_num,d.performing_facility_id performing_facility_id,d.performing_deptloc_type performing_deptloc_type,d.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext FROM or_performing_deptloc WHERE performing_facility_id = d.performing_facility_id AND performing_deptloc_type = d.performing_deptloc_type      AND performing_deptloc_code = d.performing_deptloc_code) int_or_ext,'N' image_ref_yn, d.source_type source_type,d.source_code source_code,d.order_type_code order_type_code,d.order_id order_id, d.patient_id patient_id,'N|N|N|N|N|_|N|N|N|N|_|N|N|' result_options,CASE WHEN d.patient_class IN ('IP', 'DC')THEN ip_get_desc.ip_nursing_unit(d.ordering_facility_id,d.source_code,?,'2')ELSE op_get_desc.op_clinic (d.ordering_facility_id,d.source_code,?,'2') END location_description,NULL admin_status, NULL result_type, NULL result_id,b.cont_order_ind, b.appt_ref_num, b.ord_pract_id,NVL ((SELECT ord_consent_status FROM or_order_line WHERE order_id = b.order_id AND ord_consent_reqd_yn = 'Y' AND ord_consent_status = 'P' AND ROWNUM <= 1),'N') consent_status,b.order_set_id order_set_id, NULL specimen_no,NULL operating_facility_id, NULL unit_no, NULL product_code,NULL row_id, NULL bt_status FROM or_order_pend_status_log a,or_order_line b,mp_patient c,or_order d,         or_catalog_synonym_lang_vw f WHERE b.order_id = a.order_id AND b.order_catalog_code = f.order_catalog_code AND f.language_id = ? AND catalog_synonym_type = or_get_synonym_type ('RD', b.order_catalog_code) AND d.order_id = a.order_id AND a.order_line_num = b.order_line_num AND c.patient_id = a.patient_id ");//--[IN034888]
			
			//IN040761 - added ae_bed_no & ae_pri_zone
			//sql.append("SELECT 'C' task_categ,DECODE ('en',?, c.patient_name,NVL (c.patient_name_loc_lang, c.patient_name)) patient_name,TRUNC(b.ord_date_time) start_date,TO_CHAR (b.ord_date_time, 'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (b.ord_date_time, 'HH24:MI') schedule_time_string,b.order_type_code task_type,or_get_desc.or_order_type (b.order_type_code, ?, '2') task_type_desc,/*or_get_order_catalog (b.order_id,b.order_type_code,?,'MD',b.order_line_num,'Y') task_desc*/ OR_GET_ORDER_CATALOG(d.ORDER_ID,d.ORDER_TYPE_CODE,?) task_desc,b.order_catalog_code task_code,TO_CHAR (b.ord_date_time, 'DD/MM/YYYY') schedule_date_string,NULL task_srl_no,am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (b.order_line_status,?,'2')status_desc,get_age (c.date_of_birth) age,TO_CHAR (c.date_of_birth, 'DD/MM/YYYY') dob, c.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_line_status order_status,or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,a.encounter_id encounter_id, a.patient_class patient_class,b.order_line_num order_line_num,d.performing_facility_id performing_facility_id,d.performing_deptloc_type performing_deptloc_type,d.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext FROM or_performing_deptloc WHERE performing_facility_id = d.performing_facility_id AND performing_deptloc_type = d.performing_deptloc_type      AND performing_deptloc_code = d.performing_deptloc_code) int_or_ext,'N' image_ref_yn, d.source_type source_type,d.source_code source_code,d.order_type_code order_type_code,d.order_id order_id, d.patient_id patient_id,'N|N|N|N|N|_|N|N|N|N|_|N|N|' result_options,CASE WHEN d.patient_class IN ('IP', 'DC')THEN ip_get_desc.ip_nursing_unit(d.ordering_facility_id,d.source_code,?,'2')ELSE op_get_desc.op_clinic (d.ordering_facility_id,d.source_code,?,'2') END location_description,NULL admin_status, NULL result_type, NULL result_id,b.cont_order_ind, b.appt_ref_num, b.ord_pract_id,NVL ((SELECT ord_consent_status FROM or_order_line WHERE order_id = b.order_id AND ord_consent_reqd_yn = 'Y' AND ord_consent_status = 'P' AND ROWNUM <= 1),'N') consent_status,b.order_set_id order_set_id, NULL specimen_no,NULL operating_facility_id, NULL unit_no, NULL product_code,NULL row_id, NULL bt_status, e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone FROM or_order_pend_status_log a,or_order_line b,mp_patient c,or_order d, pr_encounter e  , or_catalog_synonym_lang_vw f WHERE  d.patient_id = e.patient_id and d.encounter_id = e.encounter_id and d.performing_facility_id = e.facility_id  and b.order_id = a.order_id AND b.order_catalog_code = f.order_catalog_code AND f.language_id = ? AND catalog_synonym_type = or_get_synonym_type ('RD', b.order_catalog_code) AND d.order_id = a.order_id AND a.order_line_num = b.order_line_num AND c.patient_id = a.patient_id ");//--[IN034888]
			//IN061903 START
			//sql.append("SELECT 'C' task_categ,DECODE ('en',?, c.patient_name,NVL (c.patient_name_loc_lang, c.patient_name)) patient_name,TRUNC(b.ord_date_time) start_date,TO_CHAR (b.ord_date_time, 'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (b.ord_date_time, 'HH24:MI') schedule_time_string,b.order_type_code task_type,or_get_desc.or_order_type (b.order_type_code, ?, '2') task_type_desc,/*or_get_order_catalog (b.order_id,b.order_type_code,?,'MD',b.order_line_num,'Y') task_desc*/ OR_GET_ORDER_CATALOG(d.ORDER_ID,d.ORDER_TYPE_CODE,?) task_desc,b.order_catalog_code task_code,TO_CHAR (b.ord_date_time, 'DD/MM/YYYY') schedule_date_string,NULL task_srl_no,am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (b.order_line_status,?,'2')status_desc,get_age (c.date_of_birth) age,TO_CHAR (c.date_of_birth, 'DD/MM/YYYY') dob, c.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_line_status order_status,or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,a.encounter_id encounter_id, a.patient_class patient_class,b.order_line_num order_line_num,d.performing_facility_id performing_facility_id,d.performing_deptloc_type performing_deptloc_type,d.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext FROM or_performing_deptloc WHERE performing_facility_id = d.performing_facility_id AND performing_deptloc_type = d.performing_deptloc_type      AND performing_deptloc_code = d.performing_deptloc_code) int_or_ext,'N' image_ref_yn, d.source_type source_type,d.source_code source_code,d.order_type_code order_type_code,d.order_id order_id, d.patient_id patient_id,'N|N|N|N|N|_|N|N|N|N|_|N|N|' result_options,CASE WHEN d.patient_class IN ('IP', 'DC')THEN ip_get_desc.ip_nursing_unit(d.ordering_facility_id,d.source_code,?,'2')ELSE op_get_desc.op_clinic (d.ordering_facility_id,d.source_code,?,'2') END location_description,NULL admin_status, NULL result_type, NULL result_id,b.cont_order_ind, b.appt_ref_num, b.ord_pract_id,NVL ((SELECT ord_consent_status FROM or_order_line WHERE order_id = b.order_id AND ord_consent_reqd_yn = 'Y' AND ord_consent_status = 'P' AND ROWNUM <= 1),'N') consent_status,b.order_set_id order_set_id, NULL specimen_no,NULL operating_facility_id, NULL unit_no, NULL product_code,NULL row_id, NULL bt_status, e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone,e.VISIT_STATUS,e.adt_status FROM or_order_pend_status_log a,or_order_line b,mp_patient c,or_order d, pr_encounter e  , or_catalog_synonym_lang_vw f WHERE  d.patient_id = e.patient_id and d.encounter_id = e.encounter_id and d.performing_facility_id = e.facility_id  and b.order_id = a.order_id AND b.order_catalog_code = f.order_catalog_code AND f.language_id = ? AND catalog_synonym_type = or_get_synonym_type ('RD', b.order_catalog_code) AND d.order_id = a.order_id AND a.order_line_num = b.order_line_num AND c.patient_id = a.patient_id ");//--[IN034888]//IN041063 
			//sql.append("SELECT 'C' task_categ,DECODE ('en',?, c.patient_name,NVL (c.patient_name_loc_lang, c.patient_name)) patient_name,TRUNC(b.ord_date_time) start_date,TO_CHAR (b.ord_date_time, 'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (b.ord_date_time, 'HH24:MI') schedule_time_string,b.order_type_code task_type,or_get_desc.or_order_type (b.order_type_code, ?, '2') task_type_desc,/*or_get_order_catalog (b.order_id,b.order_type_code,?,'MD',b.order_line_num,'Y') task_desc*/ OR_GET_ORDER_CATALOG(d.ORDER_ID,d.ORDER_TYPE_CODE,?) task_desc,b.order_catalog_code task_code,TO_CHAR (b.ord_date_time, 'DD/MM/YYYY') schedule_date_string,NULL task_srl_no,am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (b.order_line_status,?,'2')status_desc,get_age (c.date_of_birth) age,TO_CHAR (c.date_of_birth, 'DD/MM/YYYY') dob, c.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_line_status order_status,or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,a.encounter_id encounter_id, a.patient_class patient_class,b.order_line_num order_line_num,d.performing_facility_id performing_facility_id,d.performing_deptloc_type performing_deptloc_type,d.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext FROM or_performing_deptloc WHERE performing_facility_id = d.performing_facility_id AND performing_deptloc_type = d.performing_deptloc_type      AND performing_deptloc_code = d.performing_deptloc_code) int_or_ext,'N' image_ref_yn, d.source_type source_type,d.source_code source_code,d.order_type_code order_type_code,d.order_id order_id, d.patient_id patient_id,'N|N|N|N|N|_|N|N|N|N|N|_|N|N|' result_options,CASE WHEN d.patient_class IN ('IP', 'DC')THEN ip_get_desc.ip_nursing_unit(d.ordering_facility_id,d.source_code,?,'2')ELSE op_get_desc.op_clinic (d.ordering_facility_id,d.source_code,?,'2') END location_description,NULL admin_status, NULL result_type, NULL result_id,b.cont_order_ind, b.appt_ref_num, b.ord_pract_id,NVL ((SELECT ord_consent_status FROM or_order_line WHERE order_id = b.order_id AND ord_consent_reqd_yn = 'Y' AND ord_consent_status = 'P' AND ROWNUM <= 1),'N') consent_status,b.order_set_id order_set_id, NULL specimen_no,NULL operating_facility_id, NULL unit_no, NULL product_code,NULL row_id, NULL bt_status, e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone,e.VISIT_STATUS,e.adt_status FROM or_order_pend_status_log a,or_order_line b,mp_patient c,or_order d, pr_encounter e  , or_catalog_synonym_lang_vw f WHERE  d.patient_id = e.patient_id and d.encounter_id = e.encounter_id and d.performing_facility_id = e.facility_id  and b.order_id = a.order_id AND b.order_catalog_code = f.order_catalog_code AND f.language_id = ? AND catalog_synonym_type = or_get_synonym_type ('RD', b.order_catalog_code) AND d.order_id = a.order_id AND a.order_line_num = b.order_line_num AND c.patient_id = a.patient_id ");//IN065942
			sql.append("SELECT 'C' task_categ,DECODE ('en',?, c.patient_name,NVL (c.patient_name_loc_lang, c.patient_name)) patient_name,TRUNC(b.ord_date_time) start_date,TO_CHAR (b.ord_date_time, 'dd/mm/yyyy HH24:MI') schedule_date,TO_CHAR (b.ord_date_time, 'HH24:MI') schedule_time_string,b.order_type_code task_type,or_get_desc.or_order_type (b.order_type_code, ?, '2') task_type_desc,/*or_get_order_catalog (b.order_id,b.order_type_code,?,'MD',b.order_line_num,'Y') task_desc*/ OR_GET_ORDER_CATALOG(d.ORDER_ID,d.ORDER_TYPE_CODE,?) task_desc,b.order_catalog_code task_code,TO_CHAR (b.ord_date_time, 'DD/MM/YYYY') schedule_date_string,NULL task_srl_no,am_get_desc.am_practitioner (b.ord_pract_id,?,'1') ordering_pract_name,b.priority priority, NULL stage_short_desc, NULL position_code,or_get_desc.or_order_status_code (b.order_line_status,?,'2')status_desc,get_age (c.date_of_birth) age,TO_CHAR (c.date_of_birth, 'DD/MM/YYYY') dob, c.sex sex,NVL (b.priority, 'R') priority, b.order_category order_category,b.order_line_status order_status,or_get_desc.or_order_category(b.order_category,?,'2') order_category_short_desc,a.encounter_id encounter_id, a.patient_class patient_class,b.order_line_num order_line_num,d.performing_facility_id performing_facility_id,d.performing_deptloc_type performing_deptloc_type,d.performing_deptloc_code performing_deptloc_code,(SELECT int_or_ext FROM or_performing_deptloc WHERE performing_facility_id = d.performing_facility_id AND performing_deptloc_type = d.performing_deptloc_type      AND performing_deptloc_code = d.performing_deptloc_code) int_or_ext,'N' image_ref_yn, d.source_type source_type,d.source_code source_code,d.order_type_code order_type_code,d.order_id order_id, d.patient_id patient_id,'N|N|N|N|N|_|N|N|N|N|N|_|N|N|' result_options,CASE WHEN d.patient_class IN ('IP', 'DC')THEN ip_get_desc.ip_nursing_unit(d.ordering_facility_id,d.source_code,?,'2')ELSE op_get_desc.op_clinic (d.ordering_facility_id,d.source_code,?,'2') END location_description,NULL admin_status, NULL result_type, NULL result_id,b.cont_order_ind, b.appt_ref_num, b.ord_pract_id,NVL ((SELECT ord_consent_status FROM or_order_line WHERE order_id = b.order_id AND ord_consent_reqd_yn = 'Y' AND ord_consent_status = 'P' AND ROWNUM <= 1),'N') consent_status,b.order_set_id order_set_id, NULL specimen_no,NULL operating_facility_id, NULL unit_no, NULL product_code,NULL row_id, NULL bt_status, e.assign_bed_num ae_bed_no, '<span style = background-color:' || decode(e.PRIORITY_ZONE,'R','Red','G','Green','Y','Yellow','U','Orange') || '>' || (select PRIORITY_ZONE_TAB_DESC from ae_priority_zone where PRIORITY_ZONE= e.PRIORITY_ZONE) || '</span>' ae_pri_zone,e.VISIT_STATUS,e.adt_status ,'N' prn_reg_ord FROM or_order_pend_status_log a,or_order_line b,mp_patient c,or_order d, pr_encounter e  , or_catalog_synonym_lang_vw f WHERE  d.patient_id = e.patient_id and d.encounter_id = e.encounter_id and d.performing_facility_id = e.facility_id  and b.order_id = a.order_id AND b.order_catalog_code = f.order_catalog_code AND f.language_id = ? AND catalog_synonym_type = or_get_synonym_type ('RD', b.order_catalog_code) AND d.order_id = a.order_id AND a.order_line_num = b.order_line_num AND c.patient_id = a.patient_id ");//IN065942
			//IN061903 ENDS
			if(patient_id.equals(""))
				sql.append("and d.patient_id like ? ");
			else
				sql.append("and d.patient_id = ? ");

			//sql.append("  AND a.pend_status_ind = 'PC' AND a.ordering_facility_id = ? AND NVL (a.priority, 'R') = NVL ((''), NVL (a.priority, 'R')) AND
			//(a.source_type != 'R' AND (DECODE (a.source_type,'D', 'N','E', 'C',a.source_type),a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N', //locn_type),locn_code FROM ca_pract_by_locn_detail");
			
			sql.append("  AND a.pend_status_ind = 'PC' AND a.ordering_facility_id = ? AND NVL (a.priority, 'R') = NVL ((''), NVL (a.priority, 'R')) AND (a.source_type != 'R' AND (DECODE (a.source_type,'D', 'N','E', 'C',a.source_type),a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N', locn_type),locn_code FROM ca_pract_by_locn_detail");
			
			sql.append(" WHERE facility_id = ? AND practitioner_id = ?) OR a.source_type = 'R') AND a.order_date BETWEEN TO_DATE (NVL ((?), '01/01/1000'), 'dd/mm/yyyy') AND TO_DATE (NVL ((?), '31/12/9999'),'dd/mm/yyyy')+ .9999 AND NVL (a.cont_order_ind, 'DO') IN ('CO', 'DO', 'CR', 'DR')");
			
			if(OrderCategory.equals(""))
			sql.append("AND  B.ORDER_CATEGORY like ? ");
			else
			sql.append("AND  B.ORDER_CATEGORY=? ");

			if(OrderType.equals(""))
			sql.append("AND  B.ORDER_TYPE_CODE like ? ");
			else
			sql.append("AND  B.ORDER_TYPE_CODE=? ");
			
			// IN31901 Starts
			
			//sql.append(" AND decode(b.order_category,'OT',performing_deptloc_CODE,'X') IS NOT NULL "); //Commented - [IN034888]
		
			// IN31901 Ends
			if(!(sql.toString()).equals(""))
			{
				if (Groupby.equals("P"))
				{
					sql.append("ORDER BY 2, d.patient_id,3 DESC, 5 ASC ");
				}else if (Groupby.equals("T"))
				{
					sql.append("ORDER BY  3 DESC, 5 ASC, 2 ");
				}
				pstmt = connection.prepareStatement(sql.toString()) ;
				System.out.println("sql.toString()========>2019================pattasklistrepository====>"+sql.toString());
				i=0;
					
				pstmt.setString( ++i, locale);
				pstmt.setString( ++i, locale);
				pstmt.setString( ++i, locale);
				pstmt.setString( ++i, locale);
				pstmt.setString( ++i, locale);
				pstmt.setString( ++i, locale);
				pstmt.setString( ++i, locale);
				pstmt.setString( ++i, locale);
				pstmt.setString( ++i, locale);
				
				if(patient_id.equals(""))
					pstmt.setString( ++i, ALL);
				else
					pstmt.setString( ++i, patient_id);

				pstmt.setString(++i,facilityId);	
				pstmt.setString(++i,facilityId);	
				pstmt.setString(++i,practitioner_id);	
				pstmt.setString( ++i, From_date);
				pstmt.setString( ++i, To_date);
					
				if(OrderCategory.equals(""))
					pstmt.setString( ++i, ALL );
				else
				pstmt.setString( ++i, OrderCategory);

				if(OrderType.equals(""))
					pstmt.setString( ++i,ALL );
				else
					pstmt.setString( ++i, OrderType);

				resultSet = pstmt.executeQuery() ;

				if(resultSet!=null) 
				{
					if(start > 0)
					{
						for(k=0;(k<start-1 && resultSet.next());k++);
							start = start-k;
					}
					while ( start_tmp <= end && resultSet!=null && resultSet.next()) 
					{
						//String[] taskResult_val 			= new String[51];
						//String[] taskResult_val 			= new String[54]; //IN030473	[//IN040761 increased to 54 from 52]
						//String[] taskResult_val 			= new String[56]; //IN041063	[//IN041063 increased to 56 from 54]//IN065942
						//String[] taskResult_val 			= new String[58]; //IN041063	[//IN041063 increased to 56 from 54]//IN065942//IN071618
						String[] taskResult_val 			= new String[59]; //26826
						taskResult_val[0] = checkForNull(resultSet.getString("task_type"))  ;
						taskResult_val[1] = checkForNull(resultSet.getString("task_type_desc").trim())  ;
						taskResult_val[2] = checkForNull(resultSet.getString("task_code"))  ;
						taskResult_val[3] = checkForNull(resultSet.getString("schedule_date").trim())  ;
						taskResult_val[4] = checkForNull(resultSet.getString("schedule_date_string").trim())  ;
						taskResult_val[5] = checkForNull(resultSet.getString("Admin_Status"))  ;
						taskResult_val[6] = checkForNull(resultSet.getString("task_srl_no"))  ;
						taskResult_val[7] = checkForNull(resultSet.getString("ordering_pract_name"))  ;
						taskResult_val[8] = checkForNull(resultSet.getString("priority"))  ;
						taskResult_val[9] = checkForNull(resultSet.getString("stage_short_desc"))  ;
						taskResult_val[10] = checkForNull(resultSet.getString("position_code"))  ;
						taskResult_val[11] = checkForNull(resultSet.getString("status_desc"))  ;
						taskResult_val[12] = checkForNull(resultSet.getString("patient_name"))  ;
						taskResult_val[13] = checkForNull(resultSet.getString("age"))  ;
						taskResult_val[14] = checkForNull(resultSet.getString("sex"))  ;
						taskResult_val[15] = checkForNull(resultSet.getString("task_desc"))  ;
						taskResult_val[16] = checkForNull(resultSet.getString("Result_options"))  ;
						taskResult_val[17] = checkForNull(resultSet.getString("schedule_time_string").trim())  ;
						taskResult_val[18] = checkForNull(resultSet.getString("order_category_short_desc"))  ;
						taskResult_val[19] = checkForNull(resultSet.getString("order_id"))  ;
						taskResult_val[20] = checkForNull(resultSet.getString("encounter_id"))  ;
						taskResult_val[21] = checkForNull(resultSet.getString("patient_class"))  ;
						taskResult_val[22] = checkForNull(resultSet.getString("patient_id"))  ;
						taskResult_val[23] = checkForNull(resultSet.getString("order_category"))  ;
						taskResult_val[24] = checkForNull(resultSet.getString("order_status"))  ;
						taskResult_val[25] = checkForNull(resultSet.getString("order_line_num"))  ;
						taskResult_val[26] = checkForNull(resultSet.getString("performing_facility_id"))  ;
						taskResult_val[27] = checkForNull(resultSet.getString("performing_deptloc_type"))  ;
						taskResult_val[28] = checkForNull(resultSet.getString("performing_deptloc_code"))  ;
						taskResult_val[29] = checkForNull(resultSet.getString("int_or_ext"))  ;
						taskResult_val[30] = checkForNull(resultSet.getString("order_type_code"))  ;
						taskResult_val[31] = checkForNull(resultSet.getString("source_type"))  ;
						taskResult_val[32] = checkForNull(resultSet.getString("source_code"))  ;
						taskResult_val[33] = checkForNull(resultSet.getString("location_description"))  ;
						taskResult_val[34] = checkForNull(resultSet.getString("TASK_CATEG"))  ;
						taskResult_val[35] = checkForNull(resultSet.getString("RESULT_TYPE"))  ;
						taskResult_val[36] = checkForNull(resultSet.getString("RESULT_ID"))  ;
						taskResult_val[37] = checkForNull(resultSet.getString("cont_order_ind"))  ;
						taskResult_val[38] = checkForNull(resultSet.getString("APPT_REF_NUM"))  ;
						taskResult_val[39] = checkForNull(resultSet.getString("ord_pract_id"))  ;
						taskResult_val[40] = checkForNull(resultSet.getString("consent_status"))  ;
						taskResult_val[41] = checkForNull(resultSet.getString("order_set_id"))  ;
						taskResult_val[42] = checkForNull(resultSet.getString("SPECIMEN_NO"))  ;
						taskResult_val[43] = checkForNull(resultSet.getString("OPERATING_FACILITY_ID"))  ;
						taskResult_val[44] = checkForNull(resultSet.getString("UNIT_NO"))  ;
						taskResult_val[45] = checkForNull(resultSet.getString("PRODUCT_CODE"))  ;
						taskResult_val[46] = checkForNull(resultSet.getString("row_id"))  ;
						taskResult_val[47] = checkForNull(resultSet.getString("bt_status"))  ;
						taskResult_val[49] = checkForNull(resultSet.getString("dob"))  ;
						taskResult_val[50] = ""  ;
						taskResult_val[51] = ""  ;//IN030473
						taskResult_val[52] = checkForNull(resultSet.getString("ae_bed_no")) ; //IN040761
						taskResult_val[53] = checkForNull(resultSet.getString("ae_pri_zone"))  ;//IN040761
						taskResult_val[54] = checkForNull(resultSet.getString("VISIT_STATUS"))  ;//IN041063
						taskResult_val[55] = checkForNull(resultSet.getString("ADT_STATUS"))  ;//IN041063
						taskResult_val[56] = checkForNull(resultSet.getString("prn_reg_ord"))  ;//IN065942
						taskResult_val[57] = "" ;	//IN071618
						taskResult_val[58] = "" ;//	26826
						taskResult.add(taskResult_val);
						start_tmp++;
					}
						
					if (resultSet.next())
					{
						String[] templist = (String[])taskResult.get(0);
						templist[48] = ""+(end+50);
						taskResult.set(0,templist);
					}
				}	
			}
		}
		//IN29559,ends
			/*
			if(!taskSelect.equals(""))
			{
				if(!(sql.toString()).equals(""))
				{
					if (Groupby.equals("P"))
					{
						sql.append("ORDER BY 2, 3 DESC, 5 ASC ");
					}else if (Groupby.equals("T"))
					{
						sql.append("ORDER BY  3 DESC, 5 ASC, 2 ");
					}
				}
			}

			if(!(sql.toString()).equals(""))
			{
			pstmt = connection.prepareStatement(sql.toString()) ;



			//if(taskSelect.equals("O") || (taskSelect.equals("") && resultReport.equals("CA_TASK_LIST_RESREP")))
			if(taskSelect.equals("O"))
			{
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
		//	pstmt.setString( 5, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, From_date);
			pstmt.setString( ++i, To_date);
			pstmt.setString( ++i, facilityId);
			pstmt.setString( ++i, From_date);
			pstmt.setString( ++i, To_date);
			pstmt.setString( ++i, status_code);
			pstmt.setString( ++i, resultvalue);
			pstmt.setString( ++i, resultby);
			if (access_previlage.equals("X"))
			{
				pstmt.setString(++i,practitioner_id);
			}else{
				pstmt.setString(++i,resp_id);
			}

			if(patient_id.equals(""))
			pstmt.setString( ++i, ALL);
			else
			pstmt.setString( ++i, patient_id);
			if(location_type.equals(""))
			pstmt.setString( ++i, ALL);
			else
			pstmt.setString( ++i, location_type);
			if(locn_code.equals(""))
			pstmt.setString( ++i, ALL);
			else
			pstmt.setString( ++i, locn_code);

			if(OrderCategory.equals(""))
			pstmt.setString( ++i, ALL);
			else
			pstmt.setString( ++i, OrderCategory);

			if(OrderType.equals(""))
			pstmt.setString( ++i, ALL);
			else
			pstmt.setString( ++i, OrderType);
			}

			//if(taskSelect.equals("R") || (taskSelect.equals("") && registerOrder.equals("CA_TASK_LIST_REGORD")) && chkUnclassify.equals("Y"))
			if(taskSelect.equals("R") && chkUnclassify.equals("Y"))
			{
				if(!taskSelect.equals(""))
					i=0;
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
		//	pstmt.setString( 5, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, From_date);
			pstmt.setString( ++i, To_date);
			pstmt.setString( ++i, facilityId);
			pstmt.setString( ++i, From_date);
			pstmt.setString( ++i, To_date);
			pstmt.setString( ++i, "REGISTER_ORD");
			pstmt.setString( ++i, resultvalue);
			pstmt.setString( ++i, resultby);
			if (access_previlage.equals("X"))
			{
				pstmt.setString(++i,practitioner_id);
			}
			else
			{
				pstmt.setString(++i,resp_id);
			}
			if(patient_id.equals(""))
			pstmt.setString( ++i, ALL);
			else
			pstmt.setString( ++i, patient_id);
			if(location_type.equals(""))
			pstmt.setString( ++i, ALL);
			else
			pstmt.setString( ++i, location_type);
			if(locn_code.equals(""))
			pstmt.setString( ++i, ALL);
			else
			pstmt.setString( ++i, locn_code);

			if(OrderCategory.equals(""))
			pstmt.setString( ++i, ALL );
			else
			pstmt.setString( ++i, OrderCategory);

			if(OrderType.equals(""))
			pstmt.setString( ++i,ALL );
			else
			pstmt.setString( ++i, OrderType);
			}

			if(taskSelect.equals("I") || (taskSelect.equals("") && intervention.equals("CA_TASK_LIST_INT")))  //Intervention
			{
				if(!taskSelect.equals(""))
					i=0;
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, facilityId);
			pstmt.setString( ++i, From_date);
			pstmt.setString( ++i, To_date);
			pstmt.setString( ++i, practitioner_id);

			if(patient_id.equals(""))
				pstmt.setString( ++i, ALL);
			else
				pstmt.setString( ++i, patient_id);

			if(!location_type.equals(""))
				pstmt.setString( ++i, location_type);
			if(!locn_code.equals(""))
				pstmt.setString( ++i, locn_code);
			if(!interventionType.equals(""))
				pstmt.setString( ++i, interventionType);
			}


			if(taskSelect.equals("M") || (taskSelect.equals("") && medAdmin.equals("CA_TASK_LIST_MEDADMN"))) //Medication
			{
				if(!taskSelect.equals(""))
					i=0;

			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, facilityId);
			pstmt.setString( ++i, facilityId);
			pstmt.setString( ++i, From_date);
			pstmt.setString( ++i, To_date);

			if(patient_id.equals(""))
				pstmt.setString( ++i, ALL);
			else
				pstmt.setString( ++i, patient_id);

			if(location_type.equals(""))
				pstmt.setString( ++i, ALL);
			else
				pstmt.setString( ++i, location_type);
			if(locn_code.equals(""))
				pstmt.setString( ++i, ALL);
			else
				pstmt.setString( ++i, locn_code);

			if(OrderCategory.equals(""))
				pstmt.setString( ++i, ALL);
			else
				pstmt.setString( ++i, OrderCategory);

			if(OrderType.equals(""))
				pstmt.setString( ++i, ALL);
			else
				pstmt.setString( ++i, OrderType);
			if(!AdminRoute.equals(""))
				pstmt.setString( ++i, AdminRoute);

			if (callFrom.equals("IM"))
			{
				if (viewBy.equals("C"))
					pstmt.setString( ++i, encounter_id);
			}
			}
			if(taskSelect.equals("S") || (taskSelect.equals("") && specCollection.equals("CA_TASK_LIST_MSPECI")) && chkUnclassify.equals("Y"))   //Specimen
			{
				if(!taskSelect.equals(""))
					i=0;
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
		//	pstmt.setString( 5, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, locale);
			pstmt.setString( ++i, facilityId);
			pstmt.setString( ++i, From_date);
			pstmt.setString( ++i, To_date);
			if(patient_id.equals(""))
			pstmt.setString( ++i, ALL);
			else
			pstmt.setString( ++i, patient_id);
			if(location_type.equals(""))
			pstmt.setString( ++i, ALL);
			else
			pstmt.setString( ++i, location_type);
			if(locn_code.equals(""))
			pstmt.setString( ++i, ALL);
			else
			pstmt.setString( ++i, locn_code);

			if(OrderCategory.equals(""))
			pstmt.setString( ++i, ALL);
			else
			pstmt.setString(++i, OrderCategory);

			if(OrderType.equals(""))
			pstmt.setString( ++i, ALL);
			else
			pstmt.setString( ++i, OrderType);

			pstmt.setString( ++i, facilityId);

			}
			if((taskSelect.equals("B") || (taskSelect.equals("") && bloodUnit.equals("CA_TASK_LIST_BLDCONS")))&& chkUnclassify.equals("Y"))
			{
				if(!taskSelect.equals(""))
					i=0;
				pstmt.setString( ++i, locale);
				pstmt.setString( ++i, locale);
				pstmt.setString( ++i, locale);
				pstmt.setString( ++i, locale);
				pstmt.setString( ++i, locale);
				pstmt.setString( ++i, locale);
				if(!patient_id.equals(""))
					pstmt.setString( ++i, patient_id);
				else
				{
					if(location_type.equals(""))
					{
						pstmt.setString( ++i, facilityId);
						pstmt.setString( ++i, locn_code);
					}
					else
					{
						pstmt.setString( ++i, facilityId);
						pstmt.setString( ++i, location_type);
						pstmt.setString( ++i, locn_code);
					}
				}
              pstmt.setString( ++i, From_date);
			  pstmt.setString( ++i, To_date);

			}
			if (!taskSelect.equals(""))
			{
				resultSet = pstmt.executeQuery() ;
			}else if (taskSelect.equals(""))
			{
				if (resultReport.equals("CA_TASK_LIST_RESREP") || registerOrder.equals("CA_TASK_LIST_REGORD") || intervention.equals("CA_TASK_LIST_INT") || medAdmin.equals("CA_TASK_LIST_MEDADMN") || specCollection.equals("CA_TASK_LIST_MSPECI") || bloodUnit.equals("CA_TASK_LIST_BLDCONS"))
				{
					resultSet = pstmt.executeQuery() ;
				}else {
					return taskResult;
				}

			}


			if(resultSet!=null) {
				if(start > 0)
					for(int k=0;(k<start-1 && resultSet.next());k++);
				while ( start <= end && resultSet!=null && resultSet.next()) {
			//while ( resultSet != null && resultSet.next() ) {
				
				//Modified by Deepa on 5/17/2010 at 12:08 PM for IN021020
				increased the size of taskResult_val to 50 from 49, to include dob in the array
				
				String[] taskResult_val 			= new String[50];
				taskResult_val[0] = checkForNull(resultSet.getString("task_type"))  ;
				taskResult_val[1] = checkForNull(resultSet.getString("task_type_desc").trim())  ;
				taskResult_val[2] = checkForNull(resultSet.getString("task_code"))  ;
				taskResult_val[3] = checkForNull(resultSet.getString("schedule_date").trim())  ;
				taskResult_val[4] = checkForNull(resultSet.getString("schedule_date_string").trim())  ;
				taskResult_val[5] = checkForNull(resultSet.getString("Admin_Status"))  ;
				taskResult_val[6] = checkForNull(resultSet.getString("task_srl_no"))  ;
				taskResult_val[7] = checkForNull(resultSet.getString("ordering_pract_name"))  ;
				taskResult_val[8] = checkForNull(resultSet.getString("priority"))  ;
				taskResult_val[9] = checkForNull(resultSet.getString("stage_short_desc"))  ;
				taskResult_val[10] = checkForNull(resultSet.getString("position_code"))  ;
				taskResult_val[11] = checkForNull(resultSet.getString("status_desc"))  ;
				taskResult_val[12] = checkForNull(resultSet.getString("patient_name"))  ;
				taskResult_val[13] = checkForNull(resultSet.getString("age"))  ;
				taskResult_val[14] = checkForNull(resultSet.getString("sex"))  ;
				taskResult_val[15] = checkForNull(resultSet.getString("task_desc"))  ;
				taskResult_val[16] = checkForNull(resultSet.getString("Result_options"))  ;
				taskResult_val[17] = checkForNull(resultSet.getString("schedule_time_string").trim())  ;
				taskResult_val[18] = checkForNull(resultSet.getString("order_category_short_desc"))  ;
				taskResult_val[19] = checkForNull(resultSet.getString("order_id"))  ;
				taskResult_val[20] = checkForNull(resultSet.getString("encounter_id"))  ;
				taskResult_val[21] = checkForNull(resultSet.getString("patient_class"))  ;
				taskResult_val[22] = checkForNull(resultSet.getString("patient_id"))  ;
				taskResult_val[23] = checkForNull(resultSet.getString("order_category"))  ;
				taskResult_val[24] = checkForNull(resultSet.getString("order_status"))  ;
				taskResult_val[25] = checkForNull(resultSet.getString("order_line_num"))  ;
				taskResult_val[26] = checkForNull(resultSet.getString("performing_facility_id"))  ;
				taskResult_val[27] = checkForNull(resultSet.getString("performing_deptloc_type"))  ;
				taskResult_val[28] = checkForNull(resultSet.getString("performing_deptloc_code"))  ;
				taskResult_val[29] = checkForNull(resultSet.getString("int_or_ext"))  ;
				taskResult_val[30] = checkForNull(resultSet.getString("order_type_code"))  ;
				taskResult_val[31] = checkForNull(resultSet.getString("source_type"))  ;
				taskResult_val[32] = checkForNull(resultSet.getString("source_code"))  ;
				taskResult_val[33] = checkForNull(resultSet.getString("location_description"))  ;
				taskResult_val[34] = checkForNull(resultSet.getString("TASK_CATEG"))  ;
				taskResult_val[35] = checkForNull(resultSet.getString("RESULT_TYPE"))  ;
				taskResult_val[36] = checkForNull(resultSet.getString("RESULT_ID"))  ;
				taskResult_val[37] = checkForNull(resultSet.getString("cont_order_ind"))  ;
				taskResult_val[38] = checkForNull(resultSet.getString("APPT_REF_NUM"))  ;
				taskResult_val[39] = checkForNull(resultSet.getString("ord_pract_id"))  ;
				taskResult_val[40] = checkForNull(resultSet.getString("consent_status"))  ;
				taskResult_val[41] = checkForNull(resultSet.getString("order_set_id"))  ;
				taskResult_val[42] = checkForNull(resultSet.getString("SPECIMEN_NO"))  ;
				taskResult_val[43] = checkForNull(resultSet.getString("OPERATING_FACILITY_ID"))  ;
				taskResult_val[44] = checkForNull(resultSet.getString("UNIT_NO"))  ;
				taskResult_val[45] = checkForNull(resultSet.getString("PRODUCT_CODE"))  ;
				taskResult_val[46] = checkForNull(resultSet.getString("row_id"))  ;
				taskResult_val[47] = checkForNull(resultSet.getString("bt_status"))  ;
				taskResult_val[49] = checkForNull(resultSet.getString("dob"))  ;
				taskResult.add(taskResult_val);
				start++;
			}
				if (resultSet.next())
				{
					String[] templist = (String[])taskResult.get(0);
					templist[48] = ""+(end+50);
					taskResult.set(0,templist);
				}
			}
			*/
			//}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			ConnectionManager.returnConnection(connection);
		}
		
		return taskResult;
	}
	public  ArrayList getQueryForTask(Properties property)
	{

		String locale				= (String) property.getProperty("LOCALE");
		PreparedStatement pstmt		= null;

		ResultSet rs=null;
		ArrayList retArray		= new ArrayList();
		ArrayList arrayCode		= new ArrayList();
		ArrayList arrayDesc		= new ArrayList();

		String tempString = "";

		String sql = "SELECT INTERVENTION_TYPE,SHORT_DESC  FROM CA_INTERVENTION_TYPE_LANG_VW   WHERE EFF_STATUS='E'  AND LANGUAGE_ID = ?  ORDER BY SHORT_DESC ";

		Connection con = null;
		try
		{
			con = ConnectionManager.getConnection(property);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				tempString = checkForNull(rs.getString(2));
				arrayDesc.add(tempString);
				tempString = checkForNull(rs.getString(1));
				arrayCode.add(tempString);
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			retArray.add(arrayDesc);
			retArray.add(arrayCode);

			//arrayCode.clear();
			//arrayDesc.clear();

		}
		catch(Exception ee)
		{
			ee.printStackTrace();			
		}
		finally
		{
			if(con != null)
			{
				ConnectionManager.returnConnection(con);
			}
		}
		return retArray;
	}
	public String checkForNull(String IntermediateString)
	{
		if(IntermediateString == null ||IntermediateString.equals(""))
		IntermediateString="";

		return IntermediateString;
	}
/**
*	getQueryForTask	-	will Retrieve all Enabled the Intervention Type
*	@param	property - This is a Properties Object used to obtain Connection
*	@param	task -		 Intervention Type
*	@param	taskDesc - used to Obtain the Task Code And Task Description
*/
	public ArrayList getQueryForTask(Properties property,String task,String taskDesc)
	{
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		ArrayList retArray= new ArrayList();
		ArrayList arrayCode = new ArrayList();
		ArrayList arrayDesc = new ArrayList();
		StringBuffer taskBuffer = new StringBuffer(task);
		StringBuffer taskDescBuffer = new StringBuffer(taskDesc);

		String locale = (String) property.getProperty("LOCALE");

		String sql = "SELECT INTERVENTION_CODE,SHORT_DESC FROM CA_INTERVENTION_LANG_vW WHERE INTERVENTION_TYPE like upper(?)  AND EFF_STATUS='E' and upper(SHORT_DESC) like upper(?) AND LANGUAGE_ID = ? ORDER BY SHORT_DESC ";
		Connection con = null;
		try
		{
			con = ConnectionManager.getConnection(property);
			if(taskBuffer.toString().equals(""))
			{
				taskBuffer = new StringBuffer();
				taskBuffer.append("%");
			}
			else
			{
				taskBuffer.append("%");
			}

			if(taskDescBuffer.toString().equals(""))
			{
				taskDescBuffer = new StringBuffer();
				taskDescBuffer.append("%");
			}
			else
				taskDescBuffer.append("%");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,taskBuffer.toString());
			pstmt.setString(2,taskDescBuffer.toString());
			pstmt.setString(3,locale);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				arrayCode.add(checkForNull(rs.getString(1)));
				arrayDesc.add(checkForNull(rs.getString(2)));
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			retArray.add(arrayDesc);
			retArray.add(arrayCode);
			//arrayDesc.clear();
			//arrayCode.clear();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();			
		}
		finally
		{
			if(con != null)
			{
				ConnectionManager.returnConnection(con);
			}
		}
		return retArray;

	}
	public ArrayList getQueryForLocation(Properties property,String locationType,String facility_id,String locationDesc)
	{
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		ArrayList retArray= new ArrayList();
		ArrayList arrayCode = new ArrayList();
		ArrayList arrayDesc = new ArrayList();
		String locale = (String) property.getProperty("LOCALE");
		Connection con = null;
		try
		{
			String sql = "";
			con = ConnectionManager.getConnection(property);
			if(locationType.equals("C"))
			{
				//sql =  "SELECT CLINIC_CODE code,LONG_DESC description FROM OP_CLINIC_LANG_VW WHERE  upper(SHORT_DESC) like upper(?)	 AND FACILITY_ID='"+facility_id+"' and EFF_STATUS='E' AND LANGUAGE_ID ='"+locale+"'	 ORDER BY SHORT_DESC ";//common-icn-0180
				sql =  "SELECT CLINIC_CODE code,LONG_DESC description FROM OP_CLINIC_LANG_VW WHERE  upper(SHORT_DESC) like upper(?)	 AND FACILITY_ID=? and EFF_STATUS='E' AND LANGUAGE_ID = ? 	 ORDER BY SHORT_DESC ";//common-icn-0180
				
			}
			else
			{
				//sql = "SELECT NURSING_UNIT_CODE code,LONG_DESC description FROM IP_NURSING_UNIT_LANG_VW WHERE upper(SHORT_DESC) like upper(?)	AND FACILITY_ID='"+facility_id+"' and EFF_STATUS='E'  AND LANGUAGE_ID ='"+locale+"'	 ORDER BY SHORT_DESC ";//common-icn-0180
				sql = "SELECT NURSING_UNIT_CODE code,LONG_DESC description FROM IP_NURSING_UNIT_LANG_VW WHERE upper(SHORT_DESC) like upper(?)	AND FACILITY_ID= ? and EFF_STATUS='E'  AND LANGUAGE_ID = ?	 ORDER BY SHORT_DESC ";//common-icn-0180
				
			}
			int pstmtcount =1;//common-icn-0180
			pstmt = con.prepareStatement(sql);//common-icn-0180
			//pstmt.setString(1,locationDesc + "%");//common-icn-0180
			//common-icn-0180 starts
			if(locationType.equals("C")){
				pstmt.setString(pstmtcount++,locationDesc + "%");
				pstmt.setString(pstmtcount++,facility_id);
				pstmt.setString(pstmtcount++,locale);
			}
			else{
				pstmt.setString(pstmtcount++,locationDesc + "%");
				pstmt.setString(pstmtcount++,facility_id);
				pstmt.setString(pstmtcount++,locale);
			}
			//common-icn-0180 ends
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				arrayCode.add(checkForNull(rs.getString(1)));
				arrayDesc.add(checkForNull(rs.getString(2)));
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			retArray.add(arrayDesc);
			retArray.add(arrayCode);

//			arrayDesc.clear();
	//		arrayCode.clear();

		}
		catch(Exception ee)
		{
			ee.printStackTrace();			
		}
		finally
		{
			if(con != null)
			{
				ConnectionManager.returnConnection(con);
			}
		}
		return retArray;
	}
public String getSysdateFromTime()
{
		String date = "";
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Connection con = null;

		try
		{
			con = ConnectionManager.getConnection();
			String sql = "select to_char(sysdate,'dd/mm/yyyy' )||' '||'00:00' from dual ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				date = rs.getString(1);
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

		}
		catch(Exception ee)
		{
			ee.printStackTrace();			
		}
		finally
		{
			if(con != null)
			{
				ConnectionManager.returnConnection(con);
			}
		}
		return date;
	}

public ArrayList getSysDateTime_L() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList  currentDate		= new ArrayList();

		try {
			connection = ConnectionManager.getConnection();
			pstmt = connection.prepareStatement("select to_char(sysdate,'HH24:MI') sys_time,to_char(sysdate,'dd/mm/yyyy') sys_date ,to_char(sysdate,'DD/mm/yyyy') curr_date, to_char(sysdate - 7,'DD/mm/yyyy') last_week_date, to_char(sysdate + 7,'DD/mm/yyyy') next_week_date, to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time from dual") ;
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				currentDate.add(resultSet.getString("curr_date"))  ;
				currentDate.add(resultSet.getString("last_week_date"))  ;
				currentDate.add(resultSet.getString("sys_date_time"))  ;
				currentDate.add(resultSet.getString("sys_date_time"))  ;
			}
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			ConnectionManager.returnConnection(connection);
		}

		return currentDate;
	}
	//IN072674 Start.
	public ArrayList getTaskListFilterDate(String selectedSubFunciton,String local,String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList  currentDate		= new ArrayList();
		String intervalTime		= "15";
		try {
			connection = ConnectionManager.getConnection();
			pstmt = connection.prepareStatement("SELECT THIRDPARTY_VITALS_TIME_DUR FROM CA_PARAM_BY_FACILITY WHERE FACILITY_ID=?");
			pstmt.setString(1,facility_id);
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				intervalTime=checkForNull(resultSet.getString("THIRDPARTY_VITALS_TIME_DUR"))  ;				
			}
			
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			
			if("V".equals(selectedSubFunciton)){
				pstmt = connection.prepareStatement("select SM_CONVERT_DATETIME_2T((sysdate - interval '"+intervalTime+"' minute),?) FromDate,SM_CONVERT_DATETIME_2T(sysdate,'en') ToDate from dual") ;
			}else{
				pstmt = connection.prepareStatement("select SM_CONVERT_DATE_2T((sysdate - interval '7 0:00' day to minute),?) FromDate,SM_CONVERT_DATE_2T(sysdate,'en') ToDate from dual") ;
			}
			
			pstmt.setString(1,local);
			resultSet = pstmt.executeQuery() ;

			if( resultSet != null && resultSet.next() ) {
				currentDate.add(resultSet.getString("FromDate"))  ;
				currentDate.add(resultSet.getString("ToDate"))  ;
				
			}
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			ConnectionManager.returnConnection(connection);
		}

		return currentDate;
	}
	//IN072674 End.
public String getSysdateTime()
{
		String date = "";
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Connection con = null;
		try
		{
			con = ConnectionManager.getConnection();
			String sql = "select to_char(sysdate,'dd/mm/yyyy' ) ||' '||'23:59' from dual ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				date = rs.getString(1);
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

		}
		catch(Exception ee)
		{
			ee.printStackTrace();			
		}
		finally
		{
			if(con != null)
			{
				ConnectionManager.returnConnection(con);
			}
		}
		return date;
	}
	//
public String getSysdateTimeForIntervention()
{
		String date = "";
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Connection con = null;
		try
		{
			con = ConnectionManager.getConnection();
			String sql = "select to_char(sysdate,'dd/mm/yyyy hh24:mi' ) from dual ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				date = rs.getString(1);
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

		}
		catch(Exception ee)
		{
			ee.printStackTrace();			
		}
		finally
		{
			if(con != null)
			{
				ConnectionManager.returnConnection(con);
			}
		}
		return date;
	}
//
public String getSysdate()
{
		String date = "";
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Connection con = null;
		try
		{
			con = ConnectionManager.getConnection();
			String sql = "select to_char(sysdate,'dd/mm/yyyy') from dual ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				date = rs.getString(1);
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

		}
		catch(Exception ee)
		{
			ee.printStackTrace();			
		}
		finally
		{
			if(con != null)
			{
				ConnectionManager.returnConnection(con);
			}
		}
		return date;
	}


	public ArrayList getTaskListQuery(HttpServletRequest request, String locale)
	{

		ArrayList retArray = new ArrayList();
		ArrayList arrayDateTime = new ArrayList();
		ArrayList arrayTaskType= new ArrayList();
		ArrayList arrayTask= new ArrayList();
		ArrayList arrayPriority= new ArrayList();
		ArrayList arrayPatDetail= new ArrayList();
		ArrayList arrayStatus= new ArrayList();
		ArrayList arrayTaskSrlNo= new ArrayList();
		ArrayList arrayRemarks= new ArrayList();
		ArrayList arrayPerformedId= new ArrayList();
		ArrayList arrayResultType= new ArrayList();
		ArrayList arrayResultId= new ArrayList();
		ArrayList arrayEncounterId= new ArrayList();
		ArrayList arrayPatientClass= new ArrayList();
		ArrayList arrayFacilityId= new ArrayList();
		ArrayList arrayTaskCategory = new ArrayList();
		ArrayList arrayScheduleDateTime = new ArrayList();
		ArrayList arrayOrderId = new ArrayList();
		ArrayList arrayOrderNum = new ArrayList();
		ArrayList arrayStatusDesc = new ArrayList();
		ArrayList arrayPatientId = new ArrayList();
		ArrayList arrayOrderStatusCode = new ArrayList();
		ArrayList arrayStageDesc = new ArrayList();

		ArrayList arrayApplicableYN = new ArrayList();
		ArrayList arrayPositionDesc = new ArrayList();
		ArrayList arrayGuildeLinelength = new ArrayList();

		PreparedStatement pstmt = null;
		ResultSet rs=null;
		StringBuffer  sql = new StringBuffer();
		Connection con = null;
		try
		{
			con = ConnectionManager.getConnection(request);
			String patientId =checkForNull(request.getParameter("PatientId"));

			String encounterId = checkForNull(request.getParameter("encounterId"));

			String task =  checkForNull(request.getParameter("task"));

			String taskCode = checkForNull(request.getParameter("taskCode"));

			String locationCode =  checkForNull(request.getParameter("locationCode"));

			String locationType =  checkForNull(request.getParameter("locationType"));

			//String shift =   checkForNull(request.getParameter("shift"));

			String ca_practitioner_id = checkForNull(request.getParameter("ca_practitioner_id"));

			String priority =  checkForNull(request.getParameter("priority"));

			String fromDate =  checkForNull(request.getParameter("fromDate"));

			if (fromDate.equals(""))
				fromDate="01/01/2000 00:00";
			String toDate =  checkForNull(request.getParameter("toDate"));

			if (toDate.equals(""))
				toDate="01/01/2200 00:00";

			fromDate	= com.ehis.util.DateUtils.convertDate(fromDate,"DMYHM",locale,"en");
			toDate	= com.ehis.util.DateUtils.convertDate(toDate,"DMYHM",locale,"en");

			java.util.Locale loc = new java.util.Locale(locale);

			String stage =  checkForNull(request.getParameter("stage"));
			String status = checkForNull(request.getParameter("status"));
			String dateTime =  checkForNull(request.getParameter("dateTime"));
			String patientDetail =  checkForNull(request.getParameter("patientDetail"));
			String taskSelect =  checkForNull(request.getParameter("taskSelect"));
			String facilityId =  checkForNull(request.getParameter("facility_id"));
			String sortSelection = checkForNull(request.getParameter("sortSelection"));
			String CP = checkForNull(request.getParameter("CP"));
			String md_care_plan_id = checkForNull(request.getParameter("md_care_plan_id"));
			String care_plan_id = checkForNull(request.getParameter("care_plan_id"));
			String checkIntervention = (request.getParameter("checkIntervention")==null?"N":request.getParameter("checkIntervention"));
			String checkAdminMedication = (request.getParameter("checkAdminMedication")==null?"N":request.getParameter("checkAdminMedication"));
			String checkSpecimen = (request.getParameter("checkSpecimen")==null?"N":request.getParameter("checkSpecimen"));
			String checkResult = (request.getParameter("checkResult")==null?"N":request.getParameter("checkResult"));
			String viewScope = (request.getParameter("viewScope")==null?"N":request.getParameter("viewScope"));
			String sortOrder= "";
			if(checkIntervention.equals("Y"))
			{
				sql.append(" SELECT  'I' TASK_CATEG ,A.TASK_TYPE ,D.SHORT_DESC 	TASK_TYPE_DESC ,A.TASK_CODE ,B.SHORT_DESC   TASK_DESC ,TRUNC(A.SCHEDULE_DATETIME) SCHEDULE_DATE ,TO_CHAR(A.SCHEDULE_DATETIME,'DD/MM/YYYY HH24:MI') SCHEDULE_DATETIME_STRING  ,A.SCHEDULE_DATETIME  ,A.PATIENT_ID  ,C.PATIENT_ID || ', ' || C.PATIENT_NAME || ', ' ||  C.SEX || ', ' || GET_AGE(C.DATE_OF_BIRTH)     PATIENT_DETAILS  ,nvl(A.PRIORITY,'R') PRIORITY ,A.STATUS   ,A.REMARKS ,(SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER   WHERE PRACTITIONER_ID= A.PERFORMED_BY_ID)    PERFORMED_BY_NAME ,TO_CHAR(A.PERFORMED_DATE,'DD/MM/YYYY HH24:MI') PERFORMED_DATETIME_STRING ,B.RESULT_TYPE ,B.RESULT_ID   ,A.TASK_SRL_NO ,A.FACILITY_ID  ,A.ENCOUNTER_ID ,E.PATIENT_CLASS ,null ORDER_ID  ,to_number(null) ORDER_LINE_NUM,decode(nvl(A.Status,'O'),'O','Pending','P','Performed','N','Not Performed','D','Discontinued', '9','Cancelled') status_desc ,case when nvl(A.Status,'O') in ('P','N') then 'C'  WHEN A.SCHEDULE_DATETIME>sysdate+.0208 then 'F' when A.SCHEDULE_DATETIME>sysdate then 'D' when A.SCHEDULE_DATETIME>sysdate-.25 then 'O' ELSE 'E' END Admin_Status, /*(SELECT SHORT_DESC  FROM CP_STAGE WHERE EFF_STATUS='E'  AND STAGE_CODE = A.STAGE_CODE)*/ null STAGE_SHORT_DESC,");

				if ( viewScope.equals("A"))
				{
					if (CP.equals("Y"))
					{
						sql.append(" 'N' ");
					}
					else
					{
						sql.append(" nvl((SELECT 'Y' FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=? AND POSITION_CODE=A.POSITION_CODE),NVL2(A.POSITION_CODE,'N','Y') ) ");
					}
				}
				else
				{
					sql.append(" 'Y' ");
				}
				sql.append(" APPLICABLE_YN,(SELECT POSITION_DESC FROM AM_POSITION WHERE POSITION_CODE=a.POSITION_CODE) POSITION_DESC, LENGTH(INTERVENTION_GUIDELINE) GUIDELINE_LENGTH    FROM MP_PATIENT C, PR_ENCOUNTER E, CA_PAT_TASK_LIST A  ,CA_INTERVENTION B ,CA_INTERVENTION_TYPE D  WHERE    A.FACILITY_ID =E.FACILITY_ID AND A.ENCOUNTER_ID=E.ENCOUNTER_ID AND  D.INTERVENTION_TYPE = A.TASK_TYPE   AND B.INTERVENTION_CODE =  A.TASK_CODE  AND C.PATIENT_ID = A.PATIENT_ID  AND A.FACILITY_ID = ? AND A.SCHEDULE_DATETIME >= TO_DATE(rtrim(?),'DD/MM/YYYY HH24:MI') AND A. SCHEDULE_DATETIME <= TO_DATE(rtrim(?),'DD/MM/YYYY HH24:MI') AND a.status in ('O','P','N' ) ");
				if (!md_care_plan_id.equals(""))
				{
					sql.append(" AND MD_CARE_PLAN_ID=? ");
				}
				if (!care_plan_id.equals(""))
				{
					sql.append(" AND CARE_PLAN_ID  =? ");
				}
				if ( viewScope.equals("S"))
				{
					sql.append(" AND (POSITION_CODE IS NULL OR EXISTS ( SELECT 1 FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=?  AND POSITION_CODE=A.POSITION_CODE))");
				}
				if(encounterId.equals("") && patientId.equals(""))
				{
					if (locationType.equals("N"))
					{
						sql.append(" AND  E.facility_id=? AND ADT_STATUS BETWEEN '01' AND '07' AND ASSIGN_CARE_LOCN_CODE=?  AND PATIENT_CLASS IN ('IP','DC')   " );
					}
					else if (locationType.equals("C"))
					{
						sql.append(" AND E.facility_id=? AND VISIT_STATUS BETWEEN '01' AND '06' AND ASSIGN_CARE_LOCN_CODE=?  AND PATIENT_CLASS IN ('OP','EM') " );
					}
				}
				if(!patientId.equals(""))
				{
					sql.append(" and E.PATIENT_ID = rtrim(?) ");
				}
				if(!taskCode.equals(""))
				{
					sql.append(" and A.TASK_CODE = ? ");
				}
				if(!task.equals(""))
				{
					sql.append(" and A.TASK_TYPE = ? ");
				}
				if(!encounterId.equals(""))
				{
					sql.append(" AND A.FACILITY_ID=? and A.ENCOUNTER_ID = rtrim(?) ");
				}
				if(!priority.equals(""))
				{
					sql.append(" and A.PRIORITY = ? ");
				}
				if(!status.equals(""))
				{
					if (status.equals("D"))
					{
						sql.append(" and A.STATUS ='O' and A.SCHEDULE_DATETIME BETWEEN SYSDATE-0.0208 AND SYSDATE  ");
					}
					else if (status.equals("O"))
					{
						sql.append("and A.STATUS ='O'  and A.SCHEDULE_DATETIME BETWEEN SYSDATE-0.25 AND SYSDATE-0.0208 ");
					}
					else if (status.equals("E"))
					{
						sql.append(" and A.STATUS ='O' and A.SCHEDULE_DATETIME < SYSDATE-0.25 ");
					}
					else if (status.equals("C"))
					{
						sql.append(" and A.STATUS IN ('P','N') ");
					}
					else if (status.equals("F"))
					{
						sql.append(" and A.SCHEDULE_DATETIME > SYSDATE ");
					}
				}
				if(!stage.equals(""))
				{
						sql.append(" and A.STAGE_CODE = ? ");
				}
			}

			if(checkAdminMedication.equals("Y"))/* && ((status.equals("D")|| (status.equals("O"))*/
			{
				if(checkIntervention.equals("Y"))
				{
					sql.append(" UNION ALL ");
				}
				sql.append("  SELECT   'M' TASK_CATEG    ,D.IV_PREP_YN TASK_TYPE    ,DECODE(NVL(D.IV_PREP_YN,'N'),'N','Normal Rx','1','IV With Additives (without  Admixture)'  , '3','IV With Piggy Back(without Admixture)'  ,'5','IV Without  Additives','7','TPN Standard Regimen'  ,'9','Cyto Orders',D.IV_PREP_YN||'OTHERS')   TASK_TYPE_DESC  ,A.ORD_DRUG_CODE    TASK_CODE    ,rtrim(rtrim(replace(B.SHORT_DESC||'~'||SUBSTR(A.IV_INGREDIANTS,instr(A.IV_INGREDIANTS,'|')+1),'|', ', '),', '),'~')  TASK_DESC  ,TRUNC(A.SCH_DATE_TIME) SCHEDULE_DATE   ,TO_CHAR(A.SCH_DATE_TIME,'DD/MM/YYYY HH24:MI') SCHEDULE_DATETIME_STRING   ,A.SCH_DATE_TIME SCHEDULE_DATETIME   ,A.PATIENT_ID  ,A.PATIENT_ID || ', ' || C.PATIENT_NAME || ', ' ||  C.SEX || ', ' || GET_AGE(C.DATE_OF_BIRTH)  PATIENT_DETAILS    ,nvl(G.PRIORITY,'R') PRIORITY   ,NVL2(A.ADMIN_RECORDED_BY,'P','O') STATUS  , NULL REMARKS   , NULL PERFORMED_BY_NAME   , null performed_datetime_string  , NULL RESULT_TYPE   , NULL RESULT_ID   ,A.DOSAGE_SEQ_NO TASK_SRL_NO   ,A.FACILITY_ID   ,A.ENCOUNTER_ID, E.PATIENT_CLASS  ,A.ORDER_ID   ,A.ORDER_LINE_NUM  ,or_get_desc.OR_ORDER_STATUS_CODE(g.order_line_status,?,2)  status_desc,NVL2(A.ADMIN_RECORDED_BY,'C','D') Admin_Status ,null stage_short_desc, 'Y' APPLICABLE_YN, '' POSITION_DESC, 0 GUIDELINE_LENGTH     FROM MP_PATIENT C  , PR_ENCOUNTER E,PH_MEDN_ADMIN A  , OR_ORDER_LINE G, OR_ORDER D  ,OR_ORDER_CATALOG  B  ,PH_FACILITY_PARAM F  WHERE A.FACILITY_ID =E.FACILITY_ID AND A.ENCOUNTER_ID=E.ENCOUNTER_ID AND G.ORDER_ID =A.ORDER_ID AND G.ORDER_LINE_NUM=A.ORDER_LINE_NUM AND E.FACILITY_ID=?    AND C.PATIENT_ID=A.PATIENT_ID  AND B.ORDER_CATALOG_CODE=A.ORD_DRUG_CODE   AND F.FACILITY_ID=A.FACILITY_ID   AND F.FACILITY_ID=?  AND A.SCH_DATE_TIME    BETWEEN SYSDATE-F.REC_ADMIN_WITHIN_HRS/24 AND SYSDATE   AND D.ORDER_ID=A.ORDER_ID    and  A.SCH_DATE_TIME >= TO_DATE(rtrim(?),'DD/MM/YYYY HH24:MI') AND A.SCH_DATE_TIME <= TO_DATE(rtrim(?),'DD/MM/YYYY HH24:MI')   AND  a.sch_date_time>=D.ord_date_time  and (( D.IV_PREP_YN IS NULL ) or (D.IV_PREP_YN  in ('1','3','5','9') and A.ORDER_LINE_NUM=1) ) and A.ADMIN_RECORDED_BY is null AND G.ORDER_LINE_STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE   WHERE ORDER_STATUS_TYPE in ('45','50','93','99')) ");
				if(encounterId.equals("") && patientId.equals(""))
				{
					if (locationType.equals("N"))
					{
						sql.append(" AND E.facility_id=? AND E.ADT_STATUS BETWEEN '01' AND '07' AND E.ASSIGN_CARE_LOCN_CODE=?  AND E.PATIENT_CLASS IN ('IP','DC') " );
					}
					else if (locationType.equals("C"))
					{
						sql.append(" AND E.facility_id=? AND E.VISIT_STATUS BETWEEN '01' AND '06' AND E.ASSIGN_CARE_LOCN_CODE=?  AND E.PATIENT_CLASS IN ('OP','EM') " );
					}
				}
				if(!patientId.equals(""))
				{
					sql.append(" and E.PATIENT_ID = rtrim(?) ");
				}

				if(!taskCode.equals(""))
				{
					sql.append(" and A.ORD_DRUG_CODE = ? ");
				}
				if(!task.equals(""))
				{
					sql.append(" and D.IV_PREP_YN = ? ");
				}

				if(!priority.equals("") )
					sql.append(" and G.PRIORITY = ? ");

				if(!encounterId.equals(""))
				{
					sql.append(" AND A.FACILITY_ID=? and A.ENCOUNTER_ID = rtrim(?) ");
				}
                if(!status.equals(""))
                    if(status.equals("D"))
                        sql.append(" AND A.ADMIN_RECORDED_BY IS NULL  ");
                    else
                    if(status.equals("C"))
                        sql.append(" AND A.ADMIN_RECORDED_BY IS NOT NULL ");
                    else
                        sql.append(" AND 1=2 ");
			}

			if( checkResult.equals("Y"))
			{
				if (checkAdminMedication.equals("Y") || checkIntervention.equals("Y"))
					sql.append(" UNION ALL  ");

					sql.append("SELECT 'O' task_categ, a.order_type_code task_type,or_get_desc.or_order_type (a.order_type_code, ?,'2') task_type_desc,b.order_catalog_code task_code,or_get_order_catalog (a.order_id, a.order_type_code,?) task_desc,TRUNC (b.start_date_time) schedule_date,TO_CHAR (b.start_date_time,'DD/MM/YYYY HH24:MI' ) schedule_datetime_string,b.start_date_time, a.patient_id,a.patient_id|| ', '|| DECODE('en',?,C.patient_name,nvl(c.PATIENT_NAME_LOC_LANG,c.patient_name))|| ',' || C.sex || ', '|| get_age (C.date_of_birth) patient_details, NVL (a.priority, 'R') priority, 'O' status, NULL remarks, NULL performed_by_name, NULL performed_datetime_string,NULL result_type, NULL result_id, b.order_line_num task_srl_no,a.ordering_facility_id facility_id, a.encounter_id,e.PATIENT_CLASS,a.order_id order_id, 1 order_line_num,or_get_desc.or_order_status_code (b.order_line_status, ?, '2') status_desc,case  WHEN b.START_date_time>sysdate then 'F' else 'D'  END  admin_status, NULL stage_short_desc, 'Y' applicable_yn, '' position_desc, 0 guideline_length  FROM pr_encounter e, or_order a, or_order_line b,mp_patient c WHERE a.performing_facility_id = e.facility_id   AND a.encounter_id = e.encounter_id AND C.PATIENT_ID=A.PATIENT_ID AND b.order_id = a.order_id AND b.order_line_num = 1 AND B.order_category IN ('NC', 'PC') AND B.order_LINE_status IN ( SELECT order_status_code FROM or_order_status_code WHERE order_status_type NOT IN ('00', '03', '05','10','15','16','17', '20','23','45','50','70','75','85','90','91','92','93','97','99' ))  AND a.cont_order_ind NOT IN ('DR', 'CR')  AND B.START_date_time >= TO_DATE (RTRIM (?), 'DD/MM/YYYY HH24:MI') AND B.START_date_time <= TO_DATE (RTRIM (?), 'DD/MM/YYYY HH24:MI') +0.999999 ");

				if(encounterId.equals("") && patientId.equals(""))
				{
					if (locationType.equals("N"))
					{
						sql.append(" AND E.facility_id=? AND E.ADT_STATUS BETWEEN '01' AND '07' AND E.ASSIGN_CARE_LOCN_CODE=?  AND E.PATIENT_CLASS IN ('IP','DC') " );
					}
					else if (locationType.equals("C"))
					{
						sql.append(" AND E.facility_id=? AND E.VISIT_STATUS BETWEEN '01' AND '06' AND E.ASSIGN_CARE_LOCN_CODE=?  AND E.PATIENT_CLASS IN ('OP','EM') " );
					}
				}

				if(!patientId.equals(""))
				{
					sql.append(" and A.PATIENT_ID = rtrim(?) ");
				}

				if(!taskCode.equals(""))
				{
					sql.append(" and B.ORDER_CATALOG_CODE = ? ");
				}

				if(!task.equals(""))
				{
					sql.append(" and A.ORDER_TYPE_CODE = ? ");
				}

				if(!encounterId.equals(""))
				{
					sql.append(" AND A.ORDERING_FACILITY_ID=?  and A.ENCOUNTER_ID = rtrim(?) ");
				}

				if(!priority.equals(""))
				{
					sql.append(" and A.PRIORITY = ? ");
				}

				if(!status.equals("")&& !status.equals("D"))
                    sql.append(" AND 1=2 ");
			}

			if(checkSpecimen.equals("Y"))
			{
				if (checkAdminMedication.equals("Y") || checkIntervention.equals("Y") || checkResult.equals("Y"))
					sql.append(" UNION ALL ");


				sql.append(" SELECT  'S' TASK_CATEG   ,A.ORDER_TYPE_CODE TASK_TYPE     ,A.ORDER_TYPE_SHORT_DESC	TASK_TYPE_DESC  ,'X' TASK_CODE	   ,OR_GET_ORDER_CATALOG( A.ORDER_ID ,A.ORDER_TYPE_CODE )   TASK_DESC   ,TRUNC(c.START_DATE_TIME) SCHEDULE_DATE   ,TO_CHAR(c.START_DATE_TIME,'DD/MM/YYYY HH24:MI') SCHEDULE_DATETIME_STRING   ,c.START_DATE_TIME START_DATE_TIME  ,A.PATIENT_ID   ,a.PATIENT_ID || ', ' ||a.PATIENT_NAME || ', ' ||  a.SEX || ', ' || GET_AGE(a.DATE_OF_BIRTH) 	PATIENT_DETAILS  ,nvl(A.PRIORITY,'R') PRIORITY   ,OR_GET_DESC.OR_ORDER_STATUS_CODE(A.ORDER_STATUS,?,'2') STATUS    ,null REMARKS   ,null PERFORMED_BY_NAME  ,null performed_datetime_string  ,null RESULT_TYPE   ,null RESULT_ID ,1 TASK_SRL_NO   ,A.ORDERING_FACILITY_ID FACILITY_ID  ,A.ENCOUNTER_ID,E.PATIENT_CLASS  ,a.order_id ORDER_ID   ,1 ORDER_LINE_NUM,OR_GET_DESC.OR_ORDER_STATUS_CODE(A.ORDER_STATUS,?,'2') status_desc,'D' Admin_Status,null  STAGE_SHORT_DESC, 'Y' APPLICABLE_YN, '' POSITION_DESC, 0 GUIDELINE_LENGTH         FROM  PR_ENCOUNTER E,OR_ORDER_VW A,OR_ORDER_LINE C  WHERE  c.ORDER_ID=a.order_id and c.order_line_num=1 and A.ORDERING_FACILITY_ID =E.FACILITY_ID AND A.ENCOUNTER_ID=E.ENCOUNTER_ID AND A.ORDER_CATEGORY = 'LB'  AND A.ORDER_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('10','15','20'))  AND EXISTS (SELECT 'X' FROM OR_ORDER_LINE_LB  WHERE ORDER_ID = A.ORDER_ID AND ORDER_LINE_NUM = 1  AND COLL_LABEL_GEN_RULE = 'G'   AND COLL_REQD_YN = 'Y' AND ORDER_ID NOT LIKE 'CS%' AND SPECIMEN_COLLECT_YN = 'N'  AND SPECIMEN_DISPATCH_YN = 'N' AND COLL_LABEL_GEN_DATE_TIME IS NULL) and A.ORD_DATE_TIME >= TO_DATE(rtrim(?),'DD/MM/YYYY HH24:MI') AND A.ORD_DATE_TIME <= TO_DATE(rtrim(?),'DD/MM/YYYY HH24:MI') ");
				if(encounterId.equals("") && patientId.equals(""))
				{
					if (locationType.equals("N"))
					{
						sql.append(" AND E.facility_id=? AND E.ADT_STATUS BETWEEN '01' AND '07' AND E.ASSIGN_CARE_LOCN_CODE=?  AND E.PATIENT_CLASS IN ('IP','DC') " );
					}
					else if (locationType.equals("C"))
					{
						sql.append(" AND E.facility_id=? AND E.VISIT_STATUS BETWEEN '01' AND '06' AND E.ASSIGN_CARE_LOCN_CODE=?  AND E.PATIENT_CLASS IN ('OP','EM') " );
					}
				}
				if(!patientId.equals(""))
				{
					sql.append(" and A.PATIENT_ID = rtrim(?) ");
				}

				if(!task.equals(""))
				{
					sql.append(" and A.ORDER_TYPE_CODE = ? ");
				}
				if(!encounterId.equals(""))
				{
					sql.append(" AND A.ORDERING_FACILITY_ID=? and A.ENCOUNTER_ID = rtrim(?) ");
				}
				if(!priority.equals(""))
				{
					sql.append(" and A.PRIORITY = ? ");
				}
				if(!status.equals("")&& !status.equals("D"))
                    sql.append(" AND 1=2 ");

			}
			sql.append(" ORDER BY ") ;

			if(!dateTime.equals(""))
				{
					sql.append("     "+dateTime);
				}
				if(!patientDetail.equals(""))
				{
					sql.append(" , "+patientDetail);
				}
				if(!taskSelect.equals(""))
				{
					sql.append(" ,  "+taskSelect);
				}

				if(!sortSelection.equals(""))
				{
					sortOrder = checkForNull(request.getParameter("sortOrder"));
					if(!dateTime.equals("") || !taskSelect.equals("") || !patientDetail.equals("") )
					sql.append(" ,  ");
					else
					sql.append("  ");
					sql.append(sortSelection);

				}
		if(!dateTime.equals("") || !taskSelect.equals("") || !patientDetail.equals("") )
				sql.append("  ,8  ") ;
				else
				{
					if(!sortSelection.equals(""))
						sql.append("	 ,8  ") ;
					else
						sql.append("	 8  ") ;
				}

				if(!sortSelection.equals(""))
				{
					sql.append("  ");
					sql.append(sortOrder);
				}

			pstmt = con.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY);
			String tempString = "";
			int count =0;
			if(checkIntervention.equals("Y"))
			{
		/*		if (!md_care_plan_id.equals(""))
				{
					pstmt.setString(++count,md_care_plan_id);
				}
				if (!care_plan_id.equals(""))
				{
					pstmt.setString(++count,care_plan_id);
				}*/
				if ( viewScope.equals("A"))
					if (!CP.equals("Y"))
						pstmt.setString(++count,ca_practitioner_id);

				pstmt.setString(++count,facilityId);
				pstmt.setString(++count,fromDate);
				pstmt.setString(++count,toDate);
				if (!md_care_plan_id.equals(""))
				{
					pstmt.setString(++count,md_care_plan_id);
				}
				if (!care_plan_id.equals(""))
				{
					pstmt.setString(++count,care_plan_id);
				}
				if ( viewScope.equals("S"))
						pstmt.setString(++count,ca_practitioner_id);
				if(encounterId.equals("") && patientId.equals(""))
				{
					if (locationType.equals("N"))
					{

						pstmt.setString(++count,facilityId);
						pstmt.setString(++count,locationCode);
					}
					else if (locationType.equals("C"))
					{
						pstmt.setString(++count,facilityId);
						pstmt.setString(++count,locationCode);

					}
				}
				if(!patientId.equals(""))
					pstmt.setString(++count,patientId);

				if(!taskCode.equals(""))
					pstmt.setString(++count,taskCode);

				if(!task.equals(""))
					pstmt.setString(++count,task);

				if(!encounterId.equals(""))
				{
					pstmt.setString(++count,facilityId);
					pstmt.setString(++count,encounterId);
				}

				if(!priority.equals(""))
				{
					pstmt.setString(++count,priority);
				}

				if(!stage.equals(""))
				{
					pstmt.setString(++count,stage);
				}
			}

			if(checkAdminMedication.equals("Y"))
			{
				pstmt.setString(++count,locale);
				pstmt.setString(++count,facilityId);
				pstmt.setString(++count,facilityId);
				pstmt.setString(++count,fromDate);
				pstmt.setString(++count,toDate);
				if(encounterId.equals("") && patientId.equals(""))
				{
					if (locationType.equals("N"))
					{

						pstmt.setString(++count,facilityId);
						pstmt.setString(++count,locationCode);
					}
					else if (locationType.equals("C"))
					{
						pstmt.setString(++count,facilityId);
						pstmt.setString(++count,locationCode);

					}
				}
				if(!patientId.equals(""))
					pstmt.setString(++count,patientId);
				if(!taskCode.equals(""))
					pstmt.setString(++count,taskCode);
				if(!task.equals(""))
					pstmt.setString(++count,task);

				if(!priority.equals("") )
					pstmt.setString(++count,priority);

				if(!encounterId.equals(""))
				{
					pstmt.setString(++count,facilityId);
					pstmt.setString(++count,encounterId);
				}
			}
			if( checkResult.equals("Y"))
			{
				pstmt.setString(++count,locale);
				pstmt.setString(++count,locale);
				pstmt.setString(++count,locale);
				pstmt.setString(++count,locale);
				pstmt.setString(++count,fromDate);
				pstmt.setString(++count,toDate);
				if(encounterId.equals("") && patientId.equals(""))
				{
					if (locationType.equals("N"))
					{

						pstmt.setString(++count,facilityId);
						pstmt.setString(++count,locationCode);
					}
					else if (locationType.equals("C"))
					{
						pstmt.setString(++count,facilityId);
						pstmt.setString(++count,locationCode);

					}
				}

				if(!patientId.equals(""))
					pstmt.setString(++count,patientId);

				if(!taskCode.equals(""))
					pstmt.setString(++count,taskCode);

				if(!task.equals(""))
					pstmt.setString(++count,task);

				if(!encounterId.equals(""))
				{
					pstmt.setString(++count,facilityId);
					pstmt.setString(++count,encounterId);
				}

				if(!priority.equals(""))
					pstmt.setString(++count,priority);
			}


			if(checkSpecimen.equals("Y"))
			{
				pstmt.setString(++count,locale);
				pstmt.setString(++count,locale);
				pstmt.setString(++count,fromDate);
				pstmt.setString(++count,toDate);

				if(encounterId.equals("") && patientId.equals(""))
				{
					if (locationType.equals("N"))
					{
						pstmt.setString(++count,facilityId);
						pstmt.setString(++count,locationCode);
					}
					else if (locationType.equals("C"))
					{
						pstmt.setString(++count,facilityId);
						pstmt.setString(++count,locationCode);

					}
				}

				if(!patientId.equals(""))
					pstmt.setString(++count,patientId);

				if(!task.equals(""))
					pstmt.setString(++count,task);

				if(!encounterId.equals(""))
				{
					pstmt.setString(++count,facilityId);
					pstmt.setString(++count,encounterId);
				}
				if(!priority.equals(""))
					pstmt.setString(++count,priority);
			}

			rs = pstmt.executeQuery();

			while(rs.next())
			{
				arrayPatDetail.add(checkForNull(rs.getString("PATIENT_DETAILS")));
				arrayDateTime.add(checkForNull(rs.getString("PERFORMED_DATETIME_STRING")));
				tempString	  = checkForNull(rs.getString("TASK_TYPE"));

				if(tempString.equals(""))
					tempString = "X";

				arrayTaskType.add(checkForNull(rs.getString("TASK_TYPE_DESC")) + ":" +tempString);
				tempString	  = checkForNull(rs.getString("TASK_CODE"));
				if(tempString.equals(""))
					tempString = "X";

				arrayTask.add(checkForNull(rs.getString("TASK_DESC"))+ ":" + tempString);
				arrayTaskSrlNo.add(checkForNull(rs.getString("TASK_SRL_NO")));
				arrayRemarks.add(checkForNull(rs.getString("remarks")));
				arrayPerformedId.add(checkForNull(rs.getString("PERFORMED_BY_NAME")));
				arrayPatientId.add(checkForNull(rs.getString("patient_id")));
				arrayOrderStatusCode.add(checkForNull(rs.getString("Admin_Status")));

				priority = checkForNull(rs.getString("PRIORITY"));


				if(!priority.equals(""))
				{
					if(priority.equals("R"))
					{//priority="Routine";
						java.util.ResourceBundle common_labels	= java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
						priority = common_labels.getString("Common.routine.label");
					}
					else if(priority.equals("S"))
					{	//priority="Stat";
						java.util.ResourceBundle or_labels	= java.util.ResourceBundle.getBundle( "eOR.resources.Labels",loc);
						priority = or_labels.getString("eOR.Stat.label");
					}
					else if(priority.equals("U"))
					{	//priority="Urgent";
						java.util.ResourceBundle common_labels	= java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
						priority = common_labels.getString("Common.urgent.label");
					}
					else
					{	//priority="Normal";
						java.util.ResourceBundle common_labels	= java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
						priority = common_labels.getString("Common.Normal.label");
					}
				}

				arrayPriority.add(priority);

				status=checkForNull(rs.getString("STATUS"));
				if(!status.equals(""))
				{
					if(status.equals("O"))
					{//status="Pending";
						java.util.ResourceBundle common_labels	= java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
						status = common_labels.getString("Common.Pending.label");
					}
					else if(status.equals("P"))
					{	//status="Performed";
						java.util.ResourceBundle common_labels	= java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
						status = common_labels.getString("Common.Performed.label");
					}
					else if(status.equals("N"))
					{	//status="Not Performed";
						java.util.ResourceBundle common_labels	= java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
						status = common_labels.getString("Common.NotPerformed.label");
					}
					else if(status.equals("D"))
					{	//status="Discontinued";
						java.util.ResourceBundle ph_labels	= java.util.ResourceBundle.getBundle( "ePH.resources.Labels",loc);
						status = ph_labels.getString("ePH.Discontinued.label");
					}
					else if(status.equals("9"))
					{	//status="Cancelled";
						java.util.ResourceBundle common_labels	= java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
						status = common_labels.getString("Common.cancelled.label");
					}
					else
					{	//status="Pending";
						java.util.ResourceBundle common_labels	= java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
						status = common_labels.getString("Common.Pending.label");
					}
				}
				arrayStatus.add(status);
				arrayResultType.add(checkForNull(rs.getString("RESULT_TYPE")));
				arrayResultId.add(checkForNull(rs.getString("RESULT_ID")));
				arrayEncounterId.add(checkForNull(rs.getString("encounter_id")));
				arrayPatientClass.add(checkForNull(rs.getString("PATIENT_CLASS")));
				arrayFacilityId.add(checkForNull(rs.getString("facility_id")));
				arrayTaskCategory.add(checkForNull(rs.getString("TASK_CATEG")));
				arrayStatusDesc.add(checkForNull(rs.getString("status_desc")));	arrayScheduleDateTime.add(checkForNull(rs.getString("SCHEDULE_DATETIME_STRING")));
				arrayOrderId.add(checkForNull(rs.getString("ORDER_ID")));
				arrayOrderNum.add(checkForNull(rs.getString("ORDER_LINE_NUM")));
				arrayStageDesc.add(checkForNull(rs.getString("stage_short_desc")).equals("")?"&nbsp;":checkForNull(rs.getString("stage_short_desc")));

				arrayApplicableYN.add(checkForNull(rs.getString("APPLICABLE_YN")));
				arrayPositionDesc.add(checkForNull(rs.getString("POSITION_DESC")).equals("")?"&nbsp;":checkForNull(rs.getString("POSITION_DESC")));
				arrayGuildeLinelength.add(checkForNull(rs.getString("GUIDELINE_LENGTH")).equals("")?"0":checkForNull(rs.getString("GUIDELINE_LENGTH")));
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			retArray.add(arrayDateTime);
			retArray.add(arrayTaskType);
			retArray.add(arrayTask);
			retArray.add(arrayPriority);
			retArray.add(arrayPatDetail);
			retArray.add(arrayStatus);
			retArray.add(arrayTaskSrlNo);
			retArray.add(arrayRemarks);
			retArray.add(arrayPerformedId);
			retArray.add(arrayResultType);
			retArray.add(arrayResultId);
			retArray.add(arrayEncounterId);
			retArray.add(arrayFacilityId);
			retArray.add(arrayTaskCategory);
			retArray.add(arrayScheduleDateTime);
			retArray.add(arrayOrderId);
			retArray.add(arrayOrderNum);
			retArray.add(arrayPatientId);
			retArray.add(arrayStatusDesc);

			retArray.add(arrayOrderStatusCode);
			retArray.add(arrayStageDesc);

			retArray.add(arrayApplicableYN);
			retArray.add(arrayGuildeLinelength);
			retArray.add(arrayPositionDesc);
			retArray.add(arrayPatientClass);

		/*	arrayDateTime.clear();
			arrayTaskType.clear();
			arrayTask.clear();
			arrayPriority.clear();
			arrayPatDetail.clear();
			arrayStatus.clear();
			arrayTaskSrlNo.clear();
			arrayRemarks.clear();
			arrayPerformedId.clear();
			arrayResultType.clear();
			arrayResultId.clear();
			arrayEncounterId.clear();
			arrayFacilityId.clear();
			arrayTaskCategory.clear();
			arrayScheduleDateTime.clear();
			arrayOrderId.clear();
			arrayOrderNum.clear();
			arrayPatientId.clear();
			arrayStatusDesc.clear();
			arrayOrderStatusCode.clear();
			arrayStageDesc.clear();
			arrayApplicableYN.clear();
			arrayGuildeLinelength.clear();
			arrayPositionDesc.clear();*/
		}
		catch(Exception ee)
		{			
			ee.printStackTrace(System.err);
		}
		finally
		{
			if(con != null)
			{
				ConnectionManager.returnConnection(con);
			}
		}
		return retArray;
	}
	public boolean getPatientId(HttpServletRequest request,String flag)
	{

			String patientId = request.getParameter("patientId")==null ? "" : request.getParameter("patientId").trim();

			String encounterId = checkForNull(request.getParameter("patientId")).trim();
			int count = 0;
			Connection con = null;
			try
			{
				con = ConnectionManager.getConnection(request);
				PreparedStatement pstmt = null;
				ResultSet rs=null;
				String  sql = "";
				if(flag.equals("Patient"))
				{
					sql = "select 1 from mp_patient where patient_id = ? ";
				}
				else
				{
					sql = "select 1 from pr_encounter where encounter_id = ? ";
				}
				pstmt = con.prepareStatement(sql);
				if(flag.equals("Patient"))
				{
					pstmt.setString(1,patientId);
				}
				else
				{
					pstmt.setString(1,encounterId);
				}
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					count= (checkForNull(rs.getString(1))=="") ? 0 : Integer.parseInt(rs.getString(1));
				}

				if(rs!=null) rs.close();
				if(pstmt !=null )pstmt.close();
			}
			catch(Exception ee)
			{
				ee.printStackTrace();			
			}
			finally
			{
				if(con != null)
				{
					ConnectionManager.returnConnection(con);
				}
			}
			if(count ==0)
				return false;
			else
				return true;

	}
	public ArrayList getLocationCode(Properties p,String facility_id)
	{
		ResultSet rs = null;
		PreparedStatement ps = null;

		ArrayList retArray = new ArrayList();
		ArrayList arrayCode = new ArrayList();
		ArrayList arrayDesc = new ArrayList();
		ArrayList arrayCodeC = new ArrayList();
		ArrayList arrayDescC = new ArrayList();

		String locale = (String) p.getProperty("LOCALE");
		Connection con = null;

		try
		{
			con = ConnectionManager.getConnection(p);

			String sql = "";

			sql = "SELECT CLINIC_CODE code,LONG_DESC description FROM OP_CLINIC_LANG_VW where FACILITY_ID='"+facility_id+"' and EFF_STATUS='E' 	 AND LANGUAGE_ID = '"+locale+"' ORDER BY SHORT_DESC ";

			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next())
			{
					arrayCodeC.add(checkForNull(rs.getString("code")));
					arrayDescC.add(checkForNull(rs.getString("description")));
			}
			if (rs != null)rs.close();
			if (ps != null)ps.close();

			sql = "SELECT NURSING_UNIT_CODE code,LONG_DESC description FROM IP_NURSING_UNIT_LANG_VW WHERE  FACILITY_ID='"+facility_id+"' and EFF_STATUS='E' AND LANGUAGE_ID = '"+locale+"'  ORDER BY SHORT_DESC";

			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next())
			{
					arrayCode.add(checkForNull(rs.getString("code")));
					arrayDesc.add(checkForNull(rs.getString("description")));
			}

			if (rs != null)rs.close();
			if (ps != null)ps.close();
			retArray.add(arrayCode);
			retArray.add(arrayDesc);
			retArray.add(arrayCodeC);
			retArray.add(arrayDescC);

/*			arrayCode.clear();
			arrayDesc.clear();
			arrayCodeC.clear();
			arrayDescC.clear();*/

		}
		catch(Exception ee)
		{
			ee.printStackTrace();			
		}
		finally
		{
			if(con != null)
			{
			  try
				{
				   ConnectionManager.returnConnection(con);
				}
				catch(Exception ee){}
			}
		}
		return (retArray);


	}
	public ArrayList getInterventionType(String task,String taskType,HttpServletRequest req,String locale)
	{

		taskType=taskType;

		ArrayList retArray=new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try
		{
			con = ConnectionManager.getConnection(req);
			String sql = " SELECT B.SHORT_DESC   Intervention_desc,A.SHORT_DESC   Intervention_type_desc,B.INTERVENTION_GUIDELINE	 FROM CA_INTERVENTION_LANG_VW B ,CA_INTERVENTION_TYPE_LANG_VW A  WHERE   B.INTERVENTION_TYPE=A.INTERVENTION_TYPE  AND B.INTERVENTION_CODE = ?  AND B.LANGUAGE_ID = ? AND A.LANGUAGE_ID = ?" ;
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,task);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);

			rs = pstmt.executeQuery();
			while(rs.next())
			{
				retArray.add(checkForNull(rs.getString("Intervention_desc")));
				retArray.add(checkForNull(rs.getString("Intervention_type_desc")));
				retArray.add(checkForNull(rs.getString("INTERVENTION_GUIDELINE")));
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

		}
		catch(Exception ee)
		{
			ee.printStackTrace();			
		}
		finally
		{
			try
			{

			if(con != null)
				ConnectionManager.returnConnection(con);
			}
			catch(Exception ee)
			{
			}
		}
		return retArray;
	}
	public HashMap getQueryForDiscrete(HttpServletRequest request)
	{
		String resultType  = checkForNull(request.getParameter("resultType"));
		String resultId   = checkForNull(request.getParameter("Chart_Id"));
		String sql = "";
		HashMap hashData = new HashMap();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		try
		{
			con = ConnectionManager.getConnection(request);

			if(!resultType.equals(""))
			{

				if(resultType.equals("DP"))
					{

						sql  = " SELECT  discr_msr_id  , short_desc ,unit_of_measure ,result_type ,num_digits_max ,num_digits_min ,num_digits_dec 	,mandatory_yn  FROM am_discr_msr_battery_view   	where DISCR_MSR_BATTERY_ID = ?  	order by ORDER_SRL_NO ";
					}
					else
					{
						sql  = " SELECT  discr_msr_id , short_desc ,NULL unit_of_measure ,result_type ,num_digits_max ,num_digits_min ,num_digits_dec ,'Y' mandatory_yn FROM am_discr_msr WHERE DISCR_MSR_ID=? ";

					}
					ps = con.prepareStatement(sql);
					ps.setString(1,resultId);
					rs = ps.executeQuery();
					int count=0;
					while(rs.next())
					{
						hashData.put("discr_msr_id"+count,checkForNull(rs.getString("discr_msr_id")));
						hashData.put("short_desc"+count,checkForNull(rs.getString("short_desc")));
						hashData.put("unit_of_measure"+count,checkForNull(rs.getString("unit_of_measure")));
						hashData.put("result_type"+count,checkForNull(rs.getString("result_type")));
						hashData.put("num_digits_max"+count,checkForNull(rs.getString("num_digits_max")));
						hashData.put("num_digits_min"+count,checkForNull(rs.getString("num_digits_min")));
						hashData.put("num_digits_dec"+count,checkForNull(rs.getString("num_digits_dec")));
						hashData.put("mandatory_yn"+count,checkForNull(rs.getString("mandatory_yn")));
							count++;
					}
					if(ps != null) ps.close();
					if(rs != null) rs.close();
			}

		}
		catch(Exception ee)
		{
			ee.printStackTrace();			
		}
		finally
		{

			if(con != null) ConnectionManager.returnConnection(con);
		}
		return hashData;

	}
	public ArrayList getListItemsForDiscreteMeasure(String discrMsrId)
	{
		ArrayList retArray = new ArrayList();
		ArrayList arrayCode  = new ArrayList();
		ArrayList arrayDesc  = new ArrayList();
		String sql = "select ref_rng_desc,NORM_ABNORM_IND,DFLT_YN,NUMERIC_VALUE REF_RANGE_SEQ from am_discr_msr_ref_rng_list where  discr_msr_id= ? order by SORT_ORDER,ref_rng_desc ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		try
		{
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1,discrMsrId);
			rs = ps.executeQuery();
			while(rs.next())
			{
				arrayCode.add(checkForNull(rs.getString(4)));
				arrayDesc.add(checkForNull(rs.getString(1)));
			}
			retArray.add(arrayCode);
			retArray.add(arrayDesc);
			//arrayDesc.clear();
	//		arrayCode.clear();
			if(rs != null) rs.close();
			if(ps != null)ps.close();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();			
		}
		finally
		{
			if(con != null)ConnectionManager.returnConnection(con);
		}
		return retArray;
	}
	public ArrayList getListItemsForStage()
	{
		ArrayList retArray = new ArrayList();
		//ArrayList arrayCode  = new ArrayList();
		//ArrayList arrayDesc  = new ArrayList();

		/*String sql = "SELECT SHORT_DESC,STAGE_CODE FROM CP_STAGE WHERE  EFF_STATUS='E'  ORDER BY SHORT_DESC ";

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try
		{
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				arrayCode.add(checkForNull(rs.getString(2)));
				arrayDesc.add(checkForNull(rs.getString(1)));
			}
			retArray.add(arrayCode);
			retArray.add(arrayDesc);
			//arrayCode.clear();
			//arrayDesc.clear();
			if(rs != null) rs.close();
			if(ps != null)ps.close();
		}
		catch(Exception ee)
		{
		}
		finally
		{
			if(con != null)ConnectionManager.returnConnection(con);
		}*/
		return retArray;
	}

	public String[] checkResulting(String practitioner_id,String resp_id) throws Exception
	{
		String[] Resulting	= new String[2];
		int total=0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		con = ConnectionManager.getConnection();
		try
		{
			if (practitioner_id != null && !practitioner_id.equals(""))
					{
						String sql="Select count(*) total from or_result_user a where practitioner_id = ?";
						ps = con.prepareStatement(sql);
						ps.setString(1,practitioner_id.trim());
						rs = ps.executeQuery();
						while(rs.next())
						{
							total = rs.getInt(1)  ;
						}
						if(total>0)
						{
							Resulting[0]="pract";
							Resulting[1]=practitioner_id.trim();
						}

						if(rs != null) rs.close();
						if(ps != null)ps.close();


					}
					if ((total == 0) && ((resp_id != null) && (!resp_id.equals(""))) )
					{
						String sql="select count(*) total from or_result_user a where  resp_id = ?";
						ps = con.prepareStatement(sql);
						ps.setString(1,resp_id);

						rs = ps.executeQuery();
						while(rs.next())
						{
							total = rs.getInt(1)  ;
						}
						if(total>0)
						{
							Resulting[0]="resp";
							Resulting[1]=resp_id.trim();
						}

						if(rs != null) rs.close();
						if(ps != null)ps.close();
					}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();			
		}
		finally
		{
			if(con != null)ConnectionManager.returnConnection(con);
		}
		return Resulting;
	}


	public String  isModuleInstalled(String facility_id, String order_category) throws Exception {
		Connection con 				= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String install_yn			= "";

		try {

			con = ConnectionManager.getConnection();
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;
			pstmt = con.prepareStatement("SELECT operational_yn FROM sm_modules_facility WHERE module_id= ? AND facility_id = ? ") ;
			pstmt.setString(1, order_category.trim());
			pstmt.setString(2, facility_id.trim());
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				install_yn = resultSet.getString(1)  ;
			}else{
				install_yn  = "N";
			}

			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();

		} catch ( Exception ee )	{
			
			ee.printStackTrace() ;
			throw ee ;
		} finally {
				if(con != null)ConnectionManager.returnConnection(con);
		}

		return install_yn;
	}

	public String  parentOrderID(String child_order_id) throws Exception 
	{
		Connection con 				= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String parent_order_id			= "";

		try {

			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement("select parent_order_id from or_order where order_id=?") ;
			pstmt.setString(1, child_order_id);
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) 
			{
				parent_order_id = resultSet.getString(1)  ;
			}
			else
			{
				parent_order_id  = "";
			}

			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();

		} catch ( Exception ee )	{
			
			ee.printStackTrace() ;
			throw ee ;
		} finally {
				if(con != null)ConnectionManager.returnConnection(con);
		}

		return parent_order_id;
	}
/*The below two methods,getCustomerID and getAllergyYN, were added By Dinesh T for the CRF IN27929*/
public String getCustomerID() throws Exception
{
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 			= null;
	String custID = "";

	try { 
		connection = ConnectionManager.getConnection();
		pstmt = connection.prepareStatement("SELECT CUSTOMER_ID FROM SM_SITE_PARAM") ;			
		resultSet = pstmt.executeQuery() ;

		if ( resultSet != null && resultSet.next() ) {
			custID = resultSet.getString("CUSTOMER_ID");	
		}
	} catch ( Exception e )	{			
		e.printStackTrace() ;
		throw e ;
	} finally {
		if(resultSet != null) resultSet.close();
		if(pstmt != null) pstmt.close();
		if(connection != null)ConnectionManager.returnConnection(connection);
	}
	return custID;
}

public String getAllergyYN(String patientID) throws Exception
{
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String allergyCnt = "";

	try { 
		connection =  ConnectionManager.getConnection();
		pstmt = connection.prepareStatement("select count(*) allergyCnt from (SELECT   a.adv_reac_code allergy_type_code,  TO_CHAR (reaction_date, 'DD/MM/YYYY') reac_date,reaction_date   FROM pr_adverse_event_reaction a,  pr_allergy_sensitivity C, ph_drug d  WHERE a.adv_event_type = 'DA'  AND a.patient_id = ?  and a.STATUS= 'A' AND A.PATIENT_ID=C.PATIENT_ID AND  A.ADV_EVENT_TYPE_IND=C.ADV_EVENT_TYPE_IND AND  A.ADV_EVENT_TYPE =C.ADV_EVENT_TYPE AND  A.ALLERGEN_CODE =C.ALLERGEN_CODE AND  A.ADV_EVENT_SRL_NO=C.ADV_EVENT_SRL_NO AND C.STATUS= 'A' union ALL SELECT adv_reac_code allergy_type_code,  TO_CHAR (reaction_date, 'DD/MM/YYYY') reac_date,reaction_date   FROM pr_adverse_event_reaction a ,pr_allergy_sensitivity C WHERE a.adv_event_type = 'DA' AND a.patient_id = ?  AND a.adv_reac_code  ='Oth'and a.STATUS= 'A' AND A.PATIENT_ID=C.PATIENT_ID AND  A.ADV_EVENT_TYPE_IND=C.ADV_EVENT_TYPE_IND AND A.ADV_EVENT_TYPE =C.ADV_EVENT_TYPE AND  A.ALLERGEN_CODE =C.ALLERGEN_CODE AND  A.ADV_EVENT_SRL_NO=C.ADV_EVENT_SRL_NO AND C.STATUS= 'A' )");
		pstmt.setString(1,patientID);
		pstmt.setString(2,patientID);
		resultSet = pstmt.executeQuery() ;
		
		if ( resultSet != null && resultSet.next() ) {
			allergyCnt = resultSet.getString("allergyCnt");	
		}
	} catch ( Exception e )	{			
		e.printStackTrace() ;
		throw e ;
	} finally {
		if(resultSet != null) resultSet.close();
		if(pstmt != null) pstmt.close();
		if(connection != null)ConnectionManager.returnConnection(connection);
	}
	//return (Integer.parseInt(AllergyCnt) == 0)?new Boolean("false"):new Boolean("true");
	return allergyCnt;
}
	//IN29788 starts
	public String getPatientIDLength()
	{
		Connection connection 		= null;
		Statement patIdLenStmt 	= null;
		ResultSet patIdLenRs = null;
		String patientLength="";
		try
		{
			connection = ConnectionManager.getConnection();
			patIdLenStmt = connection.createStatement();
			patIdLenRs = patIdLenStmt.executeQuery(" SELECT PATIENT_ID_LENGTH FROM MP_PARAM ");
			while(patIdLenRs.next())
			{
				patientLength = patIdLenRs.getString("PATIENT_ID_LENGTH");
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
				if(patIdLenRs!=null)
					patIdLenRs.close();
				if(patIdLenStmt != null) 
					patIdLenStmt.close();
				ConnectionManager.returnConnection(connection);		
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return patientLength;
	}
	//IN29788 Ends
	
	//--[IN033488]
public ArrayList getRltNoteSts(String order_id,String langId)throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String sql ="";
		ArrayList NoteStatus = new ArrayList() ;
		try
		{
			connection = ConnectionManager.getConnection();
			sql = "select am_get_desc.am_practitioner (action_by_id,?, '1') action_by_id,ACTION_DATE_TIME,ACTION_TYPE from (SELECT action_by_id,ACCESSION_NUM,ACTION_DATE_TIME,ACTION_TYPE FROM ca_encntr_note_audit_log a,or_result_detail b WHERE a.accession_num = b.linked_note_accession_num AND b.order_id = ? order by action_date_time desc) where rownum= 1";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString( 1, langId ) ;
			pstmt.setString( 2, order_id ) ;
			resultSet = pstmt.executeQuery() ;		
			while ( resultSet != null && resultSet.next() ) 
			{
				String[] record = new String[3];
				record[0] = resultSet.getString( "action_by_id" )  ;
				record[1] = resultSet.getString( "ACTION_DATE_TIME" )  ;
				record[2] = resultSet.getString( "ACTION_TYPE" )  ;

				NoteStatus.add(record) ;
			}	
		}	
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			try
			{
				if(resultSet!=null)
					resultSet.close();
				if(pstmt != null) 
					pstmt.close();
				ConnectionManager.returnConnection(connection);		
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}	
		return NoteStatus;
	}
//--[IN033488]

//IN061898 Changes Starts
public String[] getTaskListQLinkValue(String ql_ref,String default_yn,String c_location_type,String login_user,String resp_id,String locale) throws SQLException
 {
 String default_sql = "";
 Connection con 		= null;
 con = ConnectionManager.getConnection();
 PreparedStatement stmtsql = null;
 ResultSet rs = null;
 StringBuffer default_query = new StringBuffer();
 int existance_Count = 0;
 String sqlFilter = "";
 HashMap map = new HashMap();
 
 String column_id = "",value_type = "",	actual_value = "";
 String date_time_rel_id = "",	date_time_rel_val = "",	date_time_rel_unit = "",	relative_value = "";
 String final_value = "";
 String locSql;

 String[] def_Nurs_unit = new String[2];
 String locn_code ="";

 try{

	if(ql_ref.equals("") && !default_yn.equals("N")&& c_location_type.equals(""))
	{
		default_sql = "SELECT count(*) existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b, SM_QUICK_LINK_LIST_LANG_VW c WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id = ? AND b.link_type = 'F' AND a.option_id = b.option_id AND b.option_id = 'CA_TASK_LIST' AND c.eff_STATUS='E' AND c.LANGUAGE_ID = ? AND c.FUNCTION_SPEC_YN ='Y'";
		stmtsql = con.prepareStatement(default_sql);
		stmtsql.setString(1,login_user);
		stmtsql.setString(2,resp_id);
		stmtsql.setString(3,locale);
		rs = stmtsql.executeQuery();
		if(rs.next())
		{
			existance_Count = rs.getInt("EXISTANCE_COUNT");
		}

		if(rs != null) rs.close();
		if(stmtsql != null) stmtsql.close();

		default_query.append("select A.QUICK_LINK_REF from SM_QUICK_LINK_LIST_LANG_VW B, ");
		if(existance_Count>0)
			default_query.append(" SM_QUICK_LINK_FOR_USER A where A.APPL_USER_ID = ? ");
		else
			default_query.append(" SM_QUICK_LINK_RESP A where A.RESP_ID = ? ");
		default_query.append(" and A.OPTION_ID = 'CA_TASK_LIST' and A.LINK_TYPE = 'F' and A.DEFAULT_YN = 'Y' ");
	
		default_query.append(" and B.QUICK_LINK_REF = A.QUICK_LINK_REF and B.FUNCTION_SPEC_YN = 'Y' AND B.EFF_STATUS = 'E' AND B.LANGUAGE_ID= ?");
		stmtsql = con.prepareStatement(default_query.toString());
		if(existance_Count>0)
			stmtsql.setString(1,login_user);
		else
			stmtsql.setString(1,resp_id);
			stmtsql.setString(2,locale);
	
		rs = stmtsql.executeQuery();

		if(rs.next())
		{
			ql_ref = rs.getString(1) == null ? "" : rs.getString(1);
		}
		
		if(rs != null) rs.close();
		if(stmtsql != null) stmtsql.close();
		


	}
			
	if(!ql_ref.equals(""))
	{
	
		sqlFilter = "select a.COLUMN_ID, a.VALUE_TYPE, a.ACTUAL_VALUE, a.DATETIME_RELATIVE_IND, a.DATETIME_RELATIVE_VAL, a.DATETIME_RELATIVE_UNIT, a.RELATIVE_FIELD_REF from SM_QUICK_LINK_DEFN a where QUICK_LINK_REF = ?";
		stmtsql = con.prepareStatement(sqlFilter);
		stmtsql.setString(1,ql_ref);
		rs = stmtsql.executeQuery();

		while(rs.next())
		{
			column_id = rs.getString("COLUMN_ID") == null ? "" : rs.getString("COLUMN_ID");
			value_type = rs.getString("VALUE_TYPE") == null ? "" : rs.getString("VALUE_TYPE");
			actual_value = rs.getString("ACTUAL_VALUE") == null ? "" : rs.getString("ACTUAL_VALUE");
			date_time_rel_id = rs.getString("DATETIME_RELATIVE_IND") == null ? "" : rs.getString("DATETIME_RELATIVE_IND");
			date_time_rel_val = rs.getString("DATETIME_RELATIVE_VAL") == null ? "" : rs.getString("DATETIME_RELATIVE_VAL");
			date_time_rel_unit = rs.getString("DATETIME_RELATIVE_UNIT") == null ? "" : rs.getString("DATETIME_RELATIVE_UNIT");
			relative_value = rs.getString("RELATIVE_FIELD_REF") == null ? "" : rs.getString("RELATIVE_FIELD_REF");
			if(value_type.equals("A"))
				final_value = actual_value;
			else
			{
				if(column_id.equals("PERIOD_FROM") || column_id.equals("PERIOD_TO"))
				{
					if(!date_time_rel_id.equals("") && !date_time_rel_val.equals("") && !date_time_rel_unit.equals("") && !relative_value.equals(""))
					{	
						final_value = date_time_rel_id + "|" + date_time_rel_val + "|" + date_time_rel_unit + "|" + relative_value;
					}
					else
						final_value = "";
				}
				else
					final_value = relative_value;
			}

			map.put(column_id,final_value);

		}
	
		if("".equals(c_location_type) || "N".equals(c_location_type)){
		
			locn_code= (String)map.get("NURSING_UNIT");
			def_Nurs_unit[0]=locn_code;
			
			locSql= "select LONG_DESC Nursing_unit from Ip_NURSING_UNIT_lang_vw where EFF_STATUS='E' and LANGUAGE_ID= ? and NURSING_UNIT_CODE = ? ";
			stmtsql = con.prepareStatement(locSql);
			stmtsql.setString(1,locale);
			stmtsql.setString(2,locn_code);
			rs = stmtsql.executeQuery();
		
			while(rs.next())
			{
				def_Nurs_unit[1] = rs.getString("Nursing_unit") == null ? "" : rs.getString("Nursing_unit");
			}
		}
		if(rs != null) rs.close();
		if(stmtsql != null) stmtsql.close();
	}
	

	}catch (Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(rs != null) rs.close();
		if(stmtsql != null)stmtsql.close();
		ConnectionManager.returnConnection(con);
	}
  return def_Nurs_unit;
  }
//IN061898 Changes Ends
//IN067210 STARTS
public void getTaskApplicability(String facility_id,String practitioner_id) throws SQLException
{
	PreparedStatement	pstmt1	= null;
	ResultSet			rs1	= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs	= null;
	 Connection con 		= null;
	 con = ConnectionManager.getConnection();
	 tasklist.clear();
	 try{
	String practType="Select pract_type from am_practitioner where practitioner_id=?";
	String clinician_id="";
	pstmt= con.prepareStatement(practType);
	pstmt.setString(1,practitioner_id);
	rs= pstmt.executeQuery();
	while(rs.next())
	{
		clinician_id=rs.getString("pract_type");
	}
	String tasksetQuery="SELECT CA_TASK_LIST_MSPECI,CA_TASK_LIST_REGORD,CA_TASK_LIST_RESREP,CA_TASK_LIST_MEDADMN,CA_TASK_LIST_INT,CA_TASK_LIST_BLDCONS,CA_TASK_LIST_RECCONS,CA_TASK_LIST_VITAL,FACILITY_ID,ORDER_CATEGORY ORDER_CATEGORY FROM CA_ROLE_BASED_ACC_TASK_LIST a,am_pract_type b WHERE a.pract_type=b.pract_type and a.FACILITY_ID=? and a.pract_type=? order by a.pract_type";
	pstmt1= con.prepareStatement(tasksetQuery);
	pstmt1.setString(1,facility_id);
	pstmt1.setString(2,clinician_id);
	rs1= pstmt1.executeQuery();
	while(rs1.next())
	{
		tasklist.add(rs1.getString("CA_TASK_LIST_MSPECI")==null?"Y":rs1.getString("CA_TASK_LIST_MSPECI"));
		tasklist.add(rs1.getString("CA_TASK_LIST_REGORD")==null?"Y":rs1.getString("CA_TASK_LIST_REGORD"));
		tasklist.add(rs1.getString("CA_TASK_LIST_RESREP")==null?"Y":rs1.getString("CA_TASK_LIST_RESREP"));
		tasklist.add(rs1.getString("CA_TASK_LIST_MEDADMN")==null?"Y":rs1.getString("CA_TASK_LIST_MEDADMN"));
		tasklist.add(rs1.getString("CA_TASK_LIST_INT")==null?"Y":rs1.getString("CA_TASK_LIST_INT"));
		tasklist.add(rs1.getString("CA_TASK_LIST_BLDCONS")==null?"Y":rs1.getString("CA_TASK_LIST_BLDCONS"));
		tasklist.add(rs1.getString("CA_TASK_LIST_RECCONS")==null?"Y":rs1.getString("CA_TASK_LIST_RECCONS"));
		tasklist.add(rs1.getString("CA_TASK_LIST_VITAL")==null?"Y":rs1.getString("CA_TASK_LIST_VITAL"));
		tasklist.add(rs1.getString("ORDER_CATEGORY")==null?"":rs1.getString("ORDER_CATEGORY"));
	}
	setTasklist(tasklist);
	}catch(Exception e)
	 {
		e.printStackTrace();
	 }
	 finally{
		 if(rs!=null) rs.close();
		 if(pstmt!=null) pstmt.close();
		 
		 if(rs1!=null) rs1.close();
		 if(pstmt1!=null) pstmt1.close();
		 ConnectionManager.returnConnection(con);
		 
	 }
}//IN067210ENDS
//Adding start for INC:17999
public ArrayList getEncounterList(String patient_id)throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String sql ="";
		ArrayList activeEncList = new ArrayList() ;
		String encounter_id ="";
		try
		{
			connection = ConnectionManager.getConnection();
			sql = "SELECT ENCOUNTER_ID FROM PR_ENCOUNTER WHERE (VISIT_STATUS != '99' OR ADT_STATUS != '09') AND DISCHARGE_DATE_TIME IS NULL AND PATIENT_ID = ? ORDER BY VISIT_ADM_DATE_TIME DESC";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString( 1, patient_id ) ;
			resultSet = pstmt.executeQuery() ;		
			while ( resultSet != null && resultSet.next() ) 
			{
				
				encounter_id = resultSet.getString( "ENCOUNTER_ID" )  ;
				
				activeEncList.add(encounter_id) ;
			}	
		}	
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			try
			{
				if(resultSet!=null)
					resultSet.close();
				if(pstmt != null) 
					pstmt.close();
				ConnectionManager.returnConnection(connection);		
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}	
		return activeEncList;
	}//Adding end for INC:17999
}
