package eDS;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.LinkedHashMap;//Added Against ML-MMOH-CRF-0598
import java.util.HashMap;//Added Against End KDAH-CRF-0350
import eCommon.Common.CommonBean;
import eDS.Common.DSAdapter;
import eDS.Common.DlQuery;
import eDS.Common.JSONObject;
import java.util.concurrent.ConcurrentHashMap;

	public class DSCommonBean extends DSAdapter implements Serializable  {	
		String Attendant_Label_Name;
		String facility_id;
		String locale;
		
		public void setFacilityId(String facility_id)
		{
		this.facility_id=facility_id;
		}
		//MMS-QH-CRF-0079
		public void setLocale(String locale){
			this.locale=locale;
		}
	
	public String getAttendantLabel()
	{
		Attendant_Label_Name="";
		Connection connection  = null ;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try{
			connection	= getConnection() ;
			String query="select Attendent_Label_Name from ds_param_for_facility where operating_Facility_Id=?	";
			psmt = connection.prepareStatement(query);
			psmt.setString(1,facility_id);
			rs=psmt.executeQuery();
			if(rs.next()){
				Attendant_Label_Name=rs.getString("Attendent_Label_Name");				
			}			
		}catch(Exception e){
			System.err.println("eDS Exception 1"+e);			
		}finally{
			try{
				closeConnection( connection );
				psmt.close();
				rs.close();
			}catch(Exception e){
				System.err.println("eDS Exception 2"+e);
			}			
		}
		return Attendant_Label_Name;		
	}
	
	//Added against MMS-QH-CRF-0079 starts
	public ArrayList<JSONObject> getItemTypes()
	{
		//JSONObject jsonList = new JSONObject();		//Common-ICN-0044
		ArrayList<JSONObject> keyValueList = new ArrayList<JSONObject>();
		Connection connection  = null ;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String code = "",short_description="";
		try{
			connection	= getConnection() ;
			String ItemTye_query = "SELECT ds_get_desc.ds_item_type(DSITEMTYPE0_.ITEM_TYPE,'"+locale+"', 2) AS SHORT_DESC, DSITEMTYPE0_.ITEM_TYPE AS ITEM_TYPE FROM DS_ITEM_TYPE DSITEMTYPE0_ WHERE (DSITEMTYPE0_.EFF_STATUS='E' ) ORDER BY  2 , 1";
			psmt = connection.prepareStatement(ItemTye_query);
			rs = psmt.executeQuery();
			while(rs.next()){
				short_description=rs.getString("SHORT_DESC");
				code=rs.getString("ITEM_TYPE");			
				JSONObject ItemTypeList= new JSONObject();
				ItemTypeList.put("Code", CommonBean.checkForNull(code));
				ItemTypeList.put("Short_Desc", CommonBean.checkForNull(short_description));				
				keyValueList.add(ItemTypeList);
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				closeConnection( connection );
				psmt.close();	//Added Against Common-ICN-0031
				rs.close();	//Added Against Common-ICN-0031
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		System.out.println("getItemTypes keyValueList--->"+keyValueList);
		return keyValueList;		
	}
	public ArrayList<JSONObject> getSupplementaryMeal(){
		//JSONObject jsonList = new JSONObject();	//Common-ICN-0044
		ArrayList<JSONObject> keyValueList = new ArrayList<JSONObject>();
		Connection connection  = null ;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String meal_Type = "",short_Desc="";
		String serving_Start_Time,serving_End_Time,irregular_Start_Time,irregular_End_Time;
		String serving_Start_Time_SUP,serving_End_Time_SUP,irregular_Start_Time_SUP,irregular_End_Time_SUP,meal_order,next_Serving_Start_Time_SUP;//Added Agaisnt ML-MMOH-CRF-0825
		try{
			connection	= getConnection() ;
		//	String supplementary_meal="select MEAL_TYPE,SHORT_DESC,nvl(SERVING_START_TIME,'00:01') SERVING_START_TIME,nvl(SERVING_END_TIME,'23:59') SERVING_END_TIME,nvl(IRREGULAR_START_TIME,'00:01') IRREGULAR_START_TIME,nvl(IRREGULAR_END_TIME,'23:59') IRREGULAR_END_TIME from ds_meal_type where eff_Status='E' and SUPPL_DIET_ORDER_YN='Y' and ADDED_FACILITY_ID='"+facility_id+"'";//Commented Against ML-MMOH-CRF-0825
			String supplementary_meal="select c.MEAL_TYPE,SHORT_DESC,nvl(SERVING_START_TIME,'00:01') SERVING_START_TIME,nvl(SERVING_END_TIME,'23:59') SERVING_END_TIME,nvl(IRREGULAR_START_TIME,'00:01') IRREGULAR_START_TIME,nvl(IRREGULAR_END_TIME,'23:59') IRREGULAR_END_TIME ,nvl(serving_start_time_sup,'00:01') serving_start_time_sup,nvl(serving_end_time_sup,'23:59') serving_end_time_sup,nvl(irregular_start_time_sup,'00:01') irregular_start_time_sup,nvl(irregular_end_time_sup,'23:59') irregular_end_time_sup, meal_order, NVL ((SELECT serving_start_time_sup FROM ds_meal_type_lang_vw a WHERE a.meal_order = (SELECT MIN (b.meal_order) FROM ds_meal_type_lang_vw b WHERE b.serving_start_time_sup IS NOT NULL AND b.meal_order > c.meal_order) AND a.language_id ='en'), '23:59' ) next_serving_start_time_sup from ds_meal_type c where eff_Status='E' and SUPPL_DIET_ORDER_YN='Y' and ADDED_FACILITY_ID=? ORDER BY c.meal_order";//Added Against ML-MMOH-CRF-0825
			psmt = connection.prepareStatement(supplementary_meal);
			psmt.setString(1,facility_id);
			rs = psmt.executeQuery();
			while(rs.next()){
				JSONObject mealTypeList= new JSONObject();
				
				meal_Type=rs.getString("meal_Type");
				short_Desc=rs.getString("SHORT_DESC");
				serving_Start_Time=rs.getString("serving_Start_Time");
				serving_End_Time=rs.getString("SERVING_END_TIME");
				irregular_Start_Time=rs.getString("IRREGULAR_START_TIME");
				irregular_End_Time=rs.getString("IRREGULAR_END_TIME");
				//Added Against ML-MMOH-CRF-0825 Starts Here
				serving_Start_Time_SUP=rs.getString("serving_start_time_sup");
				//System.err.println("120 serving_Start_Time_SUP===>"+serving_Start_Time_SUP);
				serving_End_Time_SUP=rs.getString("serving_end_time_sup");
				irregular_Start_Time_SUP=rs.getString("irregular_start_time_sup");
				irregular_End_Time_SUP=rs.getString("irregular_end_time_sup");
				meal_order=rs.getString("MEAL_ORDER");
				next_Serving_Start_Time_SUP=rs.getString("NEXT_SERVING_START_TIME_SUP");
				//Added Against ML-MMOH-CRF-0825 Ends Here
				mealTypeList.put("Meal_Type",meal_Type);
				mealTypeList.put("Short_Desc",short_Desc);
				mealTypeList.put("Serving_Start_Time",serving_Start_Time);
				mealTypeList.put("Serving_End_Time",serving_End_Time);
				mealTypeList.put("Irregular_Start_Time",irregular_Start_Time);
				mealTypeList.put("Irregular_End_Time",irregular_End_Time);
				//Added Against ML-MMOH-CRF-0825 Starts Here
				mealTypeList.put("Serving_Start_Time_sup",serving_Start_Time_SUP);
				//System.err.println("135 mealTypeList===>"+mealTypeList);
				mealTypeList.put("Serving_End_Time_sup",serving_End_Time_SUP);
				mealTypeList.put("Irregular_Start_Time_sup",irregular_Start_Time_SUP);
				mealTypeList.put("Irregular_End_Time_sup",irregular_End_Time_SUP);
				mealTypeList.put("meal_order",meal_order);
				mealTypeList.put("next_Serving_Start_Time_sup",next_Serving_Start_Time_SUP);
				//Added Against ML-MMOH-CRF-0825 Ends Here
				keyValueList.add(mealTypeList);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				closeConnection(connection);
				psmt.close();	//Added Against Common-ICN-0031
				rs.close();	//Added Against Common-ICN-0031
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return keyValueList;
	}
	public ArrayList<JSONObject> getDSParameterValue(){
		ArrayList<JSONObject> DSParamList = new ArrayList<JSONObject>();
		Connection connection  = null ;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		JSONObject DS_Param_Obj= new JSONObject();
		try{
			connection	= getConnection() ;
			String DS_Param_Query="select nvl(Grace_Period,'') Grace_Period,nvl(Grace_Period_Applicable_YN,'N') Grace_Period_Applicable_YN,nvl((maximum_days_allowed-1),'999')maximum_days_allowed,Attendent_Label_Name from DS_Param_For_Facility where OPERATING_FACILITY_ID=?";
			psmt = connection.prepareStatement(DS_Param_Query);
			psmt.setString(1,facility_id);
			
			rs = psmt.executeQuery();
			if(rs.next()){
				String grace_period=CommonBean.checkForNull(rs.getString("grace_period"));
				System.out.println("grace_period--->"+grace_period);
				if(grace_period.equals("") || grace_period=="" || grace_period=="null"){
					grace_period="-";
				}
				DS_Param_Obj.put("Grace_Period",grace_period);
				DS_Param_Obj.put("Grace_Period_Applicable_YN", rs.getString("GRACE_PERIOD_APPLICABLE_YN"));
				DS_Param_Obj.put("Maximum_Days_Allowed", rs.getString("maximum_days_allowed"));
				DS_Param_Obj.put("Attendent_Label_Name",rs.getString("Attendent_Label_Name"));
			}
			
			DSParamList.add(DS_Param_Obj);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				closeConnection(connection);
				psmt.close();	//Added Against Common-ICN-0031
				rs.close();	//Added Against Common-ICN-0031
			}catch(Exception e){
				e.printStackTrace();
			}
		}	
		return DSParamList;
		
	}
	public String wardsForKitchenSetUp(Connection con,String Nursing_unit,String facility_id){
		String result="";
		
		Connection connection=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		try{
			connection=con;
			String wardForKithcen_query=DlQuery.DL_WARDS_FOR_KITCHEN_SETUP;
			psmt=connection.prepareStatement(wardForKithcen_query);
			psmt.setString(1,facility_id);
			psmt.setString(2,Nursing_unit);
			rs=psmt.executeQuery();
			if(rs.next()){				
				int count = rs.getInt(1);
				if(count==0){
					result="N";
				}else{
					result="Y";
				}
			}else{
				result="N";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//Added Against Common-ICN-0031 Starts
		finally{
			try{
				closeConnection(connection);
				psmt.close();	
				rs.close();	
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//Added Against Common-ICN-0031	Ends
		return result;
	}
	//Added against MMS-QH-CRF-0079 ends
	
	public ArrayList<JSONObject> getNursingUnit()
	{
		//JSONObject jsonList = new JSONObject();		//Common-ICN-0044
		ArrayList<JSONObject> keyValueList = new ArrayList<JSONObject>();
		Connection connection  = null ;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String nursing_Unit_Code="";
	    String SHORT_DESC="";
		try{
				connection	= getConnection() ;
				String Nursing_query = "select ip_ward.nursing_Unit_Code, ip_ward.short_Desc from Ip_Nursing_Unit_Lang_Vw ip_ward where ip_ward.eff_Status ='E' and ip_ward.facility_Id='"+facility_id+"' and ip_ward.language_Id ='"+locale+"' order by 2,1";
				psmt = connection.prepareStatement(Nursing_query);
				rs = psmt.executeQuery();
				while(rs.next()){
					SHORT_DESC=rs.getString("SHORT_DESC");
					nursing_Unit_Code=rs.getString("nursing_Unit_Code");			
					JSONObject NursingUnitList= new JSONObject();
					NursingUnitList.put("nursing_Unit_Code", CommonBean.checkForNull(nursing_Unit_Code));
					NursingUnitList.put("Short_Desc", CommonBean.checkForNull(SHORT_DESC));				
					keyValueList.add(NursingUnitList);
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				closeConnection( connection );
				psmt.close();	//Added Against Common-ICN-0031
				rs.close();	//Added Against Common-ICN-0031
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		System.out.println("getNursingUnit keyValueList--->"+keyValueList);
		return keyValueList;		
	}
	
	public ArrayList<JSONObject> getKitchen()
	{
		//JSONObject jsonList = new JSONObject();	//Common-ICN-0044
		ArrayList<JSONObject> ProcesskeyValueList = new ArrayList<JSONObject>();
		Connection connection  = null ;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String KITCHEN_CODE = "";
	    String SHORT_DESC = "";
		try{
				connection	= getConnection() ;
				String Kitchen_query = "select KITCHEN_CODE,ds_get_desc.ds_kitchens('"+facility_id+"',KITCHEN_CODE,'"+locale+"',2) as short_desc from ds_kitchens where  ds_get_desc.ds_kitchens ('"+facility_id+"', kitchen_code, '"+locale+"', 2) IS NOT NULL";
				psmt = connection.prepareStatement(Kitchen_query);
				rs = psmt.executeQuery();
				while(rs.next()){
					SHORT_DESC=rs.getString("SHORT_DESC");
					KITCHEN_CODE=rs.getString("KITCHEN_CODE");			
					JSONObject KitchenList= new JSONObject();
					KitchenList.put("KITCHEN_CODE", CommonBean.checkForNull(KITCHEN_CODE));
					KitchenList.put("SHORT_DESC", CommonBean.checkForNull(SHORT_DESC));				
					ProcesskeyValueList.add(KitchenList);
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				closeConnection( connection );
				psmt.close();	//Added Against Common-ICN-0031
				rs.close();	//Added Against Common-ICN-0031
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		System.out.println("getKitchen ProcesskeyValueList--->"+ProcesskeyValueList);
		return ProcesskeyValueList;		
	}
	
	//Added against MMS-QH-CRF-0079-US11 Starts
	public ArrayList<JSONObject> getWardDetails()
	{
		//JSONObject jsonList = new JSONObject();	//Common-ICN-0044
		ArrayList<JSONObject> WardValueList = new ArrayList<JSONObject>();
		Connection connection  = null ;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String WARD_CODE = "";
	    String SHORT_DESC = "";
		try{
				connection	= getConnection();				
				String Ward_query = DlQuery.DL_WARD_LIST;
				psmt = connection.prepareStatement(Ward_query);
				psmt.setString(1,facility_id);
				rs = psmt.executeQuery();
				while(rs.next()){
					SHORT_DESC=rs.getString("SHORT_DESC");
					WARD_CODE=rs.getString("nursing_unit_code");			
					JSONObject WardList= new JSONObject();
					WardList.put("WARD_CODE", CommonBean.checkForNull(WARD_CODE));
					WardList.put("SHORT_DESC", CommonBean.checkForNull(SHORT_DESC));				
					WardValueList.add(WardList);
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				closeConnection( connection );
				psmt.close();	//Added Against Common-ICN-0031
				rs.close();	//Added Against Common-ICN-0031
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		System.out.println("getWard WardValueList--->"+WardValueList);
		return WardValueList;		
	}

	public ArrayList<JSONObject> getMealType()
	{
		//JSONObject jsonList = new JSONObject();	//Common-ICN-0044
		ArrayList<JSONObject> MealtypeList = new ArrayList<JSONObject>();
		Connection connection  = null ;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String MEAL_TYPE = "";
	    String SHORT_DESC = "";
		try{
				connection	= getConnection();				
				String Mealtype_query = DlQuery.DL_MEAL_TYPE_LIST;
				psmt = connection.prepareStatement(Mealtype_query);
				psmt.setString(1,locale);
				rs = psmt.executeQuery();
				while(rs.next()){
					MEAL_TYPE=rs.getString("meal_type");
					SHORT_DESC=rs.getString("short_desc");
					JSONObject MealList= new JSONObject();
					MealList.put("MEAL_TYPE", CommonBean.checkForNull(MEAL_TYPE));
					MealList.put("SHORT_DESC", CommonBean.checkForNull(SHORT_DESC));				
					MealtypeList.add(MealList);
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				closeConnection( connection );
				psmt.close();	//Added Against Common-ICN-0031
				rs.close();	//Added Against Common-ICN-0031
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		System.out.println("getMealType MealtypeList--->"+MealtypeList);
		return MealtypeList;		
	}
	//Added against MMS-QH-CRF-0079-US11 Ends
	
	//Added against MML-MMOH-CRF-0423-US2 Starts Here
	public String getDietOrderQuery(String wardClinicDesc,String ward_Clinic_code,String patientClass,String facility_id,String locale,String servDate,int gracePeriod, boolean isDietTypeCnt)
	{
		String stafforder_Sql="";
		if(wardClinicDesc.equalsIgnoreCase("Nursing Unit"))
		{
			//mac_only added Against ML-MMOH-CRF-1826
			stafforder_Sql = "SELECT nursing_unit, diet_type, diet_type_desc,tot_order_placed, tot_pat, atten_order,full_nbm, assign_diet_type_cnt, NULL menu_type_desc, 0 menu_count,mac_only FROM (SELECT   nursing_unit, diet_type, diet_type_desc,SUM (tot_order_placed) tot_order_placed, SUM (tot_pat) tot_pat, SUM (atten_order) atten_order, SUM (full_nbm) full_nbm,SUM (assign_diet_type_cnt) assign_diet_type_cnt, SUM (mac_only) mac_only FROM (SELECT nursing_unit, NULL diet_type, NULL diet_type_desc, 0 tot_order_placed, SUM (patient_id) tot_pat, 0 atten_order, 0 full_nbm, 0 assign_diet_type_cnt,0 mac_only FROM (SELECT   ip_get_desc.ip_nursing_unit('"+facility_id+"', a.assign_care_locn_code, '"+locale+"','1' ) nursing_unit, COUNT (*) patient_id FROM pr_encounter a, mp_episode_type_vw v WHERE a.patient_class = v.patient_class AND (   (a.discharge_date_time + '"+gracePeriod+"' / 24) >= SYSDATE OR a.discharge_date_time IS NULL ) AND a.adt_status <> '09' ";//CRF-0902

			if(!ward_Clinic_code.equalsIgnoreCase(""))
			stafforder_Sql +=" AND a.assign_care_locn_code = '"+ward_Clinic_code+"' ";
	 
			stafforder_Sql +="  AND a.patient_class = '"+patientClass+"' AND a.deceased_date_time IS NULL AND a.facility_id = '"+facility_id+"' AND (TRUNC (a.visit_adm_date_time) BETWEEN TO_DATE (NVL (REPLACE ('' || '%', '%', '' ), '15/09/1947' ), 'dd/mm/yyyy' ) AND TO_DATE ('"+servDate+"', 'dd/mm/yyyy') ) GROUP BY a.patient_id, a.assign_care_locn_code) GROUP BY patient_id, nursing_unit UNION SELECT nursing_unit, diet_type, diet_type_desc, tot_order_placed, 0 tot_pat, 0 atten_order, 0 full_nbm, "; 
			//CRF-968
			if(isDietTypeCnt)
				stafforder_Sql +=" tot_order_placed assign_diet_type_cnt,0 mac_only ";
			else
				stafforder_Sql +=" 0 assign_diet_type_cnt,0 mac_only ";
			stafforder_Sql +=" FROM (SELECT ip_get_desc.ip_nursing_unit ('"+facility_id+"', a.assign_care_locn_code, '"+locale+"', '1' ) nursing_unit, hdr.diet_type, ds_get_desc.ds_diet_type (hdr.diet_type, '"+locale+"', '2' ) diet_type_desc, COUNT (hdr.diet_type) tot_order_placed FROM pr_encounter a, mp_episode_type_vw v, ds_epsd_diet_profile_hdr hdr WHERE a.patient_class = v.patient_class AND (   (a.discharge_date_time + '"+gracePeriod+"' / 24) >= SYSDATE OR a.discharge_date_time IS NULL ) AND a.adt_status <> '09' ";//CRF-0902

			if(!ward_Clinic_code.equalsIgnoreCase(""))
			stafforder_Sql +=" AND a.assign_care_locn_code = '"+ward_Clinic_code+"' ";	 
                   
            stafforder_Sql +=" AND (NVL (hdr.status, '!') NOT IN ('C','X', 'F') OR (NVL (hdr.status, '!') = 'C' AND NVL (hdr.discharge_flag_yn, 'N') = 'Y' AND TRUNC (hdr.period_from) = TO_DATE ('"+servDate+"', 'DD/MM/YYYY')))  AND a.patient_class ='"+patientClass+"' AND (  (TRUNC (a.discharge_date_time) >TO_DATE ('"+servDate+"', 'DD/MM/YYYY') OR a.discharge_date_time IS NULL) OR NVL (hdr.discharge_flag_yn, 'N') = 'Y') AND TRUNC (a.visit_adm_date_time) <=TO_DATE ('"+servDate+"', 'DD/MM/YYYY') AND a.deceased_date_time IS NULL AND a.facility_id = '"+facility_id+"' AND hdr.operating_facility_id = a.facility_id AND hdr.encounter_id = a.encounter_id AND (TO_DATE ('"+servDate+"', 'DD/MM/YYYY') BETWEEN TRUNC (period_from) AND NVL (TRUNC (period_to),TO_DATE ('31/12/2999','dd/mm/yyyy'))) GROUP BY a.assign_care_locn_code, hdr.diet_type) "; 
			if(!isDietTypeCnt){//CRF-968
			stafforder_Sql +=" UNION SELECT NURSING_UNIT,  DIET_TYPE , DIET_TYPE_DESC, 0 TOT_ORDER_PLACED,0 TOT_PAT, 0 ATTEN_ORDER,0 FULL_NBM , assign_diet_type_cnt, 0 mac_only FROM (SELECT   ip_get_desc.ip_nursing_unit ('"+facility_id+"', a.assign_care_locn_code,'"+locale+"','1') nursing_unit,dtl.diet_type, ds_get_desc.ds_diet_type(dtl.diet_type, '"+locale+"','2') DIET_TYPE_DESC, COUNT (dtl.diet_type)  assign_diet_type_cnt FROM pr_encounter a, mp_episode_type_vw v, ds_epsd_diet_profile_hdr hdr,       ds_epsd_diet_profile_dtl dtl  WHERE a.patient_class = v.patient_class  AND (   (a.discharge_date_time + '"+gracePeriod+"' / 24) >= SYSDATE   OR a.discharge_date_time IS NULL ) AND a.adt_status <> '09'  AND (NVL (hdr.status, '!') NOT IN ('C','X', 'F') OR (NVL (hdr.status, '!') = 'C' AND NVL (hdr.discharge_flag_yn, 'N') = 'Y' AND TRUNC (hdr.period_from) = TO_DATE ('"+servDate+"', 'DD/MM/YYYY'))) ";//CRF-0902
			
			if(!ward_Clinic_code.equalsIgnoreCase(""))
			stafforder_Sql +=" AND a.assign_care_locn_code = '"+ward_Clinic_code+"' ";
			
			stafforder_Sql +=" AND a.patient_class ='"+patientClass+"' AND ((   TRUNC (a.discharge_date_time) > TO_DATE ('"+servDate+"', 'DD/MM/YYYY') OR a.discharge_date_time IS NULL) OR NVL(hdr.discharge_flag_yn,'N') = 'Y') AND TRUNC (a.visit_adm_date_time) <= TO_DATE ('"+servDate+"', 'DD/MM/YYYY') AND a.deceased_date_time IS NULL   AND a.facility_id = '"+facility_id+"'  AND hdr.operating_facility_id = a.facility_id AND hdr.encounter_id = a.encounter_id   AND hdr.operating_facility_id =dtl.operating_facility_id  AND hdr.encounter_id = dtl.encounter_id  AND hdr.profile_sl = dtl.profile_sl  AND dtl.MEAL_TYPE not in (SELECT MEAL_TYPE FROM ds_meal_type_exclusions WHERE operating_facility_id = a.facility_id AND encounter_id = a.encounter_id AND profile_sl = hdr.profile_sl AND TRUNC (excluded_date) =TO_DATE ('"+servDate+"', 'DD/MM/YYYY')) AND (TO_DATE('"+servDate+"','DD/MM/YYYY') BETWEEN TRUNC(PERIOD_FROM) AND NVL(TRUNC(PERIOD_TO),TO_DATE('31/12/2999','dd/mm/yyyy'))) GROUP BY  a.assign_care_locn_code,dtl.diet_type) ";
			}
			//stafforder_Sql +=" UNION SELECT NURSING_UNIT, NULL DIET_TYPE, NULL DIET_TYPE_DESC,0 TOT_ORDER_PLACED, 0 TOT_PAT, NVL(SUM(ATTEN_ORDER),0) ATTEN_ORDER,0 FULL_NBM ,0 assign_diet_type_cnt FROM ( SELECT   ip_get_desc.ip_nursing_unit ('"+facility_id+"', a.assign_care_locn_code,'"+locale+"','1') nursing_unit,a.assign_care_locn_code,COUNT (att.encounter_id) ATTEN_ORDER FROM pr_encounter a, mp_episode_type_vw v,ds_epsd_diet_profile_hdr hdr,ds_epsd_diet_profile_att att WHERE a.patient_class = v.patient_class AND (   (a.discharge_date_time + '"+gracePeriod+"' / 24) >= SYSDATE OR a.discharge_date_time IS NULL) AND a.adt_status <> '09' AND ( NVL (hdr.status, '!') NOT IN ('C', 'X', 'F') OR (NVL (hdr.status, '!') = 'C' AND NVL (hdr.discharge_flag_yn, 'N') = 'Y' AND TRUNC (hdr.period_from) = TO_DATE ('"+servDate+"', 'DD/MM/YYYY'))) ";//CRF-0902
			stafforder_Sql +=" UNION SELECT NURSING_UNIT, NULL DIET_TYPE, NULL DIET_TYPE_DESC,0 TOT_ORDER_PLACED, 0 TOT_PAT, NVL(SUM(ATTEN_ORDER),0) ATTEN_ORDER,0 FULL_NBM ,0 assign_diet_type_cnt,0 mac_only FROM ( SELECT   ip_get_desc.ip_nursing_unit ('"+facility_id+"', a.assign_care_locn_code,'"+locale+"','1') nursing_unit,a.assign_care_locn_code,COUNT (att.encounter_id) ATTEN_ORDER FROM pr_encounter a, mp_episode_type_vw v,ds_epsd_diet_profile_att att WHERE a.patient_class = v.patient_class AND (   (a.discharge_date_time + '"+gracePeriod+"' / 24) >= SYSDATE OR a.discharge_date_time IS NULL) AND a.adt_status <> '09' ";//CRF-0902

			if(!ward_Clinic_code.equalsIgnoreCase(""))
			stafforder_Sql +=" AND a.assign_care_locn_code = '"+ward_Clinic_code+"' ";
		 
		   //stafforder_Sql +=" AND a.patient_class ='"+patientClass+"' AND ((TRUNC (a.discharge_date_time) > TO_DATE ('"+servDate+"', 'DD/MM/YYYY') OR a.discharge_date_time IS NULL)OR NVL (hdr.discharge_flag_yn, 'N') = 'Y') AND TRUNC (a.visit_adm_date_time) <=TO_DATE ('"+servDate+"', 'DD/MM/YYYY') AND a.deceased_date_time IS NULL AND a.facility_id = '"+facility_id+"' AND hdr.operating_facility_id = a.facility_id  AND hdr.encounter_id = a.encounter_id   AND hdr.encounter_id = att.encounter_id AND (TO_DATE ('"+servDate+"', 'DD/MM/YYYY') BETWEEN TRUNC (hdr.period_from) AND NVL (TRUNC (hdr.period_to), TO_DATE ('31/12/2999', 'dd/mm/yyyy'))) AND (TO_DATE('"+servDate+"','DD/MM/YYYY') BETWEEN TRUNC(att.PERIOD_FROM) AND NVL(TRUNC(att.PERIOD_TO),TO_DATE('31/12/2999','dd/mm/yyyy'))) GROUP BY a.assign_care_locn_code) GROUP BY  NURSING_UNIT UNION SELECT NURSING_UNIT, NULL DIET_TYPE, NULL DIET_TYPE_DESC,0 TOT_ORDER_PLACED, 0 TOT_PAT, 0 ATTEN_ORDER, NVL(SUM(FULL_NBM),0) FULL_NBM, 0 assign_diet_type_cnt FROM(SELECT   ip_get_desc.ip_nursing_unit ('"+facility_id+"',  a.assign_care_locn_code,'"+locale+"','1') nursing_unit,COUNT (assign_care_locn_code) FULL_NBM FROM pr_encounter a, mp_episode_type_vw v, ds_epsd_nbm_profile nbm   WHERE a.patient_class = v.patient_class AND (   (a.discharge_date_time + '"+gracePeriod+"' / 24) >= SYSDATE OR a.discharge_date_time IS NULL)  AND a.adt_status <> '09' ";//CRF-0902
		   stafforder_Sql +=" AND a.patient_class ='"+patientClass+"' AND ((TRUNC (a.discharge_date_time) > TO_DATE ('"+servDate+"', 'DD/MM/YYYY') OR a.discharge_date_time IS NULL)) AND TRUNC (a.visit_adm_date_time) <=TO_DATE ('"+servDate+"', 'DD/MM/YYYY') AND a.deceased_date_time IS NULL AND a.facility_id = '"+facility_id+"' AND att.operating_facility_id = a.facility_id  AND att.encounter_id = a.encounter_id AND (TO_DATE('"+servDate+"','DD/MM/YYYY') BETWEEN TRUNC(att.PERIOD_FROM) AND NVL(TRUNC(att.PERIOD_TO),TO_DATE('31/12/2999','dd/mm/yyyy'))) GROUP BY a.assign_care_locn_code) GROUP BY  NURSING_UNIT UNION SELECT NURSING_UNIT, NULL DIET_TYPE, NULL DIET_TYPE_DESC,0 TOT_ORDER_PLACED, 0 TOT_PAT, 0 ATTEN_ORDER, NVL(SUM(FULL_NBM),0) FULL_NBM, 0 assign_diet_type_cnt,0 mac_only FROM(SELECT   ip_get_desc.ip_nursing_unit ('"+facility_id+"',  a.assign_care_locn_code,'"+locale+"','1') nursing_unit,COUNT (assign_care_locn_code) FULL_NBM FROM pr_encounter a, mp_episode_type_vw v, ds_epsd_nbm_profile nbm   WHERE a.patient_class = v.patient_class AND (   (a.discharge_date_time + '"+gracePeriod+"' / 24) >= SYSDATE OR a.discharge_date_time IS NULL)  AND a.adt_status <> '09' ";//CRF-0902

		   if(!ward_Clinic_code.equalsIgnoreCase(""))
		   stafforder_Sql +=" AND a.assign_care_locn_code = '"+ward_Clinic_code+"' ";
		 
		   stafforder_Sql +=" AND a.patient_class ='"+patientClass+"' AND a.deceased_date_time IS NULL AND a.facility_id = '"+facility_id+"' AND nbm.operating_facility_id = a.facility_id  AND nbm.encounter_id = a.encounter_id AND (TO_DATE('"+servDate+"','DD/MM/YYYY') BETWEEN TRUNC(NIL_BY_MOUTH_FRM) AND NVL(TRUNC(NIL_BY_MOUTH_TO),TO_DATE('31/12/2999', 'dd/mm/yyyy'))) AND NVL(nbm.status,'#') !='X'  AND NOT EXISTS (SELECT 1 FROM ds_epsd_diet_profile_hdr  WHERE operating_facility_id = a.facility_id  AND encounter_id = a.encounter_id AND patient_id = a.patient_id  AND TO_DATE ('"+servDate+"', 'DD/MM/YYYY') BETWEEN period_from  AND NVL(period_to,TO_DATE('31/12/5000','DD/MM/YYYY')))GROUP BY  a.assign_care_locn_code)GROUP BY NURSING_UNIT UNION SELECT   nursing_unit, NULL diet_type, NULL diet_type_desc,0 tot_order_placed, 0 tot_pat, 0 atten_order,0 full_nbm, 0 assign_diet_type_cnt, NVL (SUM (mac_only), 0) mac_only FROM (SELECT   ip_get_desc.ip_nursing_unit('"+facility_id+"', a.assign_care_locn_code,'"+locale+"','1') nursing_unit,COUNT ( distinct n.encounter_id) mac_only FROM pr_encounter a,mp_episode_type_vw v,ds_epsd_diet_profile_att n WHERE a.patient_class = v.patient_class AND (   (a.discharge_date_time + '1' / 24) >= SYSDATE OR a.discharge_date_time IS NULL)AND a.adt_status <> '09' ";
		   
			if(!ward_Clinic_code.equalsIgnoreCase(""))
		   stafforder_Sql +=" AND a.assign_care_locn_code = '"+ward_Clinic_code+"' ";
	   
	   stafforder_Sql +="AND a.patient_class = '"+patientClass+"' AND a.deceased_date_time IS NULL AND a.facility_id = '"+facility_id+"' AND n.operating_facility_id = a.facility_id AND n.encounter_id = a.encounter_id AND (TO_DATE ('"+servDate+"', 'DD/MM/YYYY') BETWEEN TRUNC (n.period_from) AND NVL (TRUNC (n.period_to), TO_DATE ('31/12/2999', 'dd/mm/yyyy')))AND NOT EXISTS (SELECT 1 FROM ds_epsd_diet_profile_hdr WHERE operating_facility_id = a.facility_id AND encounter_id = a.encounter_id AND patient_id = a.patient_id AND TO_DATE ('"+servDate+"', 'DD/MM/YYYY') BETWEEN period_from AND NVL (period_to, TO_DATE ('31/12/5000', 'DD/MM/YYYY'))) AND NOT EXISTS (SELECT 'Y' FROM ds_epsd_nbm_profile WHERE operating_facility_id = a.facility_id AND encounter_id = a.encounter_id AND patient_id = a.patient_id AND (TO_DATE ('"+servDate+"', 'DD/MM/YYYY') BETWEEN TRUNC (nil_by_mouth_frm) AND NVL (TRUNC (nil_by_mouth_to),  TO_DATE ('31/12/2999', 'dd/mm/yyyy'))))GROUP BY a.assign_care_locn_code)GROUP BY nursing_unit) GROUP BY NURSING_UNIT, DIET_TYPE, DIET_TYPE_DESC order by NURSING_UNIT, diet_type ) UNION SELECT nursing_unit, NULL diet_type, NULL diet_type_desc, 0 tot_order_placed, 0 tot_pat, 0 atten_order, 0 full_nbm, 0 assign_diet_type_cnt, menu_type_desc, SUM(menu_count)menu_count,0 mac_only FROM (SELECT ip_get_desc.ip_nursing_unit ('"+facility_id+"',a.assign_care_locn_code,'"+locale+"','1') nursing_unit, ds_get_desc.ds_menu_type(hdr.menu_type,'"+locale+"','2') menu_type_desc, COUNT (hdr.menu_type) menu_count FROM pr_encounter a, mp_episode_type_vw v,ds_epsd_diet_profile_hdr hdr WHERE a.patient_class = v.patient_class AND ((a.discharge_date_time + '1' / 24) >= SYSDATE OR a.discharge_date_time IS NULL) AND a.adt_status <> '09' AND (NVL (hdr.status, '!') NOT IN ('C', 'X', 'F') OR ( NVL (hdr.status, '!') = 'C' AND NVL (hdr.discharge_flag_yn, 'N') = 'Y' AND TRUNC (hdr.period_from) = TO_DATE ('"+servDate+"', 'DD/MM/YYYY'))) AND a.patient_class = '"+patientClass+"' AND ((TRUNC (a.discharge_date_time) > TO_DATE ('"+servDate+"', 'DD/MM/YYYY') OR a.discharge_date_time IS NULL) OR NVL (hdr.discharge_flag_yn, 'N') = 'Y') AND TRUNC (a.visit_adm_date_time) <= TO_DATE ('"+servDate+"', 'DD/MM/YYYY') AND a.deceased_date_time IS NULL AND a.facility_id = '"+facility_id+"' AND hdr.operating_facility_id = a.facility_id AND hdr.encounter_id = a.encounter_id AND (TO_DATE ('"+servDate+"', 'DD/MM/YYYY') BETWEEN TRUNC (period_from) AND NVL (TRUNC (period_to), TO_DATE ('31/12/2999', 'dd/mm/yyyy')))"; 
	   
	   if(!ward_Clinic_code.equalsIgnoreCase(""))
		   stafforder_Sql +=" AND a.assign_care_locn_code = '"+ward_Clinic_code+"' ";
	   
	   stafforder_Sql +=" GROUP BY a.assign_care_locn_code, hdr.diet_type,hdr.menu_type) WHERE menu_count > 0 GROUP BY nursing_unit, menu_type_desc"; //Modified Against ML-MMOH-SCF-1699-TF
		   System.err.println("If-->382 stafforder_Sql==>"+stafforder_Sql);//CRF-0902
		}
		else
		{
		//stafforder_Sql ="SELECT op_clinic, diet_type, diet_type_desc, SUM (tot_order_placed) tot_order_placed, SUM (tot_pat) tot_pat, 0 late_order, 0 full_nbm, SUM (assign_diet_type_cnt) assign_diet_type_cnt, ds_get_desc.ds_menu_type(menu_type,'"+locale+"','2') menu_type_desc, SUM (menu_type_cnt)menu_type_cnt FROM (SELECT   op_clinic, NULL diet_type, NULL diet_type_desc, 0 tot_order_placed, SUM (patient_id) tot_pat, 0 assign_diet_type_cnt, NULL menu_type, 0 menu_type_cnt FROM (SELECT op_get_desc.op_clinic ('"+facility_id+"', appt.clinic_code,'"+locale+"', '1' ) op_clinic, COUNT (*) patient_id FROM oa_appt appt WHERE appt.facility_id = '"+facility_id+"' AND appt_status = '1'";//CRF-0902
		
		stafforder_Sql ="SELECT op_clinic, diet_type, diet_type_desc, SUM (tot_order_placed) tot_order_placed, SUM (tot_pat) tot_pat, 0 late_order, 0 full_nbm, SUM (assign_diet_type_cnt) assign_diet_type_cnt, ds_get_desc.ds_menu_type(menu_type,'"+locale+"','2') menu_type_desc, SUM (menu_type_cnt)menu_type_cnt, 0 mac_only FROM (SELECT   op_clinic, NULL diet_type, NULL diet_type_desc, 0 tot_order_placed, SUM (patient_id) tot_pat, 0 assign_diet_type_cnt, NULL menu_type, 0 menu_type_cnt FROM (SELECT op_get_desc.op_clinic ('"+facility_id+"', appt.clinic_code,'"+locale+"', '1' ) op_clinic, COUNT (*) patient_id FROM oa_appt appt WHERE appt.facility_id = '"+facility_id+"' AND appt_status = '1' ";//CRF-0902
		
		if(!ward_Clinic_code.equalsIgnoreCase(""))
		stafforder_Sql +=" AND appt.clinic_code = '"+ward_Clinic_code+"' ";
	 
		stafforder_Sql +=" AND TRUNC (appt.appt_date) =TO_DATE ('"+servDate+"', 'dd/mm/yyyy') GROUP BY appt.clinic_code UNION ALL SELECT op_get_desc.op_clinic('"+facility_id+"',enct.assign_care_locn_code,'"+locale+"','1') op_clinic,COUNT (*) patient_id FROM oa_appt appt, pr_encounter enct WHERE appt.facility_id = '"+facility_id+"'  AND appt.encounter_id = enct.encounter_id AND appt.facility_id = enct.facility_id AND enct.patient_class = '"+patientClass+"' ";
		
		if(!ward_Clinic_code.equalsIgnoreCase(""))
			stafforder_Sql +=" AND enct.assign_care_locn_code = '"+ward_Clinic_code+"'";
		
		stafforder_Sql +=" AND TRUNC (enct.visit_adm_date_time) =TO_DATE ('"+servDate+"', 'dd/mm/yyyy') GROUP BY enct.assign_care_locn_code UNION ALL SELECT   op_get_desc.op_clinic('"+facility_id+"',	a.assign_care_locn_code,'"+locale+"','1') op_clinic,COUNT (*) patient_id FROM pr_encounter a, mp_episode_type_vw v  WHERE a.patient_class = v.patient_class AND visit_status IN ('01', '02', '03', '04', '07') AND a.appt_case_yn = 'W' ";
	  
	  if(!ward_Clinic_code.equalsIgnoreCase(""))
		stafforder_Sql +=" AND a.assign_care_locn_code = '"+ward_Clinic_code+"' ";
	  
	  stafforder_Sql +=" AND a.patient_class='"+patientClass+"' AND a.facility_id = '"+facility_id+"' AND (TRUNC (a.visit_adm_date_time) = TO_DATE ('"+servDate+"','DD/MM/YYYY')) GROUP BY a.assign_care_locn_code) GROUP BY  op_clinic 	  UNION SELECT OP_CLINIC, NULL DIET_TYPE , NULL DIET_TYPE_DESC, SUM(TOT_ORDER_PLACED),0 TOT_PAT,0 assign_diet_type_cnt , menu_type, SUM (menu_type_cnt)menu_type_cnt FROM ("; //CRF-902

	  
	  //For Out-Patient Alone Starts Here
     if(patientClass.equalsIgnoreCase("OP")){
	  stafforder_Sql +="SELECT   op_get_desc.op_clinic ('"+facility_id+"',a.locn_code,'"+locale+"','1') op_clinic, COUNT (*) tot_order_placed , menu_type, COUNT (menu_type) menu_type_cnt FROM op_patient_queue a, ds_op_diet_order_hdr hdr WHERE a.patient_class = '"+patientClass+"' AND a.queue_status != 99 AND TRUNC (serving_date) =TO_DATE ('"+servDate+"', 'DD/MM/YYYY') AND a.facility_id = '"+facility_id+"' ";//CRF-902
	  if(!ward_Clinic_code.equalsIgnoreCase(""))
     stafforder_Sql +=" AND a.locn_code = '"+ward_Clinic_code+"' ";
	 //Modified
	  stafforder_Sql +=" AND hdr.facility_id = a.facility_id AND hdr.encounter_id = a.encounter_id GROUP BY a.locn_code, menu_type UNION ALL SELECT   op_get_desc.op_clinic ('"+facility_id+"',a.clinic_code,'"+locale+"','1') op_clinic,COUNT (*) tot_order_placed ,menu_type, COUNT (menu_type) menu_type_cnt FROM oa_appt a, ds_op_diet_order_hdr hdr WHERE TRUNC (serving_date) =TO_DATE ('"+servDate+"', 'DD/MM/YYYY') AND a.facility_id = '"+facility_id+"' ";//CRF-902
	  
     if(!ward_Clinic_code.equalsIgnoreCase(""))
     stafforder_Sql +=" AND a.clinic_code = '"+ward_Clinic_code+"' ";
	 
	 stafforder_Sql +=" AND hdr.facility_id = a.facility_id AND hdr.app_no = a.appt_ref_no AND hdr.encounter_id IS NULL GROUP BY a.clinic_code, menu_type) ";//CRF-902 & ML-MMOH-SCF-1109
	 }//For Out-Patient Alone Ends Here
	 
	 
	 //For eMERGENCY-Patient Alone Starts Here
     if(patientClass.equalsIgnoreCase("EM")){
	 stafforder_Sql +="SELECT op_get_desc.op_clinic ('"+facility_id+"', a.locn_code, '"+locale+"','1') op_clinic, COUNT (*) tot_order_placed , menu_type, COUNT (menu_type) menu_type_cnt FROM op_patient_queue a, ds_em_diet_order_hdr hdr WHERE a.patient_class = '"+patientClass+"' AND a.queue_status != 99 AND TRUNC (serving_date) = TO_DATE ('"+servDate+"', 'DD/MM/YYYY') AND a.facility_id = '"+facility_id+"' ";//CRF-902
		
	if(!ward_Clinic_code.equalsIgnoreCase(""))
	stafforder_Sql +=" AND a.locn_code = '"+ward_Clinic_code+"' ";
						 
    stafforder_Sql +=" AND hdr.facility_id = a.facility_id AND hdr.encounter_id = a.encounter_id GROUP BY a.locn_code, menu_type) ";//CRF-902

	 
	 }//For eMERGENCY-Patient Alone ends Here
	 
	 stafforder_Sql +=" GROUP BY op_clinic, menu_type UNION SELECT   op_clinic, diet_type, diet_type_desc, 0 tot_order_placed,0 tot_pat, SUM (assign_diet_type_cnt) assign_diet_type_cnt, NULL menu_type, 0 menu_type_cnt FROM (";//CRF-902
	 
	 
	  //For Out-Patient Alone Starts Here
     if(patientClass.equalsIgnoreCase("OP")){
	 
	 stafforder_Sql +="SELECT   op_get_desc.op_clinic ('"+facility_id+"', a.locn_code ,'"+locale+"','1') op_clinic,DIETTYPE DIET_TYPE, ds_get_desc.ds_diet_type(DIETTYPE,'"+locale+"','2') DIET_TYPE_DESC,COUNT (DIETTYPE) assign_diet_type_cnt FROM op_patient_queue a,DS_OP_DIET_ORDER_DTL dtl WHERE a.patient_class ='"+patientClass+"' AND a.queue_status != 99 ";//Modified for Linked issue-63512 
	 
	 
     if(!ward_Clinic_code.equalsIgnoreCase(""))
      stafforder_Sql +=" AND a.locn_code = '"+ward_Clinic_code+"' ";
	  
	   stafforder_Sql +=" AND TRUNC (SERVING_DATE) = TO_DATE ('"+servDate+"', 'DD/MM/YYYY') AND a.facility_id = '"+facility_id+"'  AND dtl.facility_id = a.facility_id AND dtl.encounter_id = a.encounter_id  GROUP BY  a.locn_code,DIETTYPE  UNION SELECT   op_get_desc.op_clinic ('"+facility_id+"', a.clinic_code ,'"+locale+"','1') op_clinic, DIETTYPE diet_type, ds_get_desc.ds_diet_type(DIETTYPE, '"+locale+"','2') DIET_TYPE_DESC, COUNT (DIETTYPE) assign_diet_type_cnt FROM oa_appt a,ds_op_diet_order_dtl dtl WHERE TRUNC (SERVING_DATE) = TO_DATE ('"+servDate+"', 'DD/MM/YYYY') ";
	  
    if(!ward_Clinic_code.equalsIgnoreCase(""))
    stafforder_Sql +=" AND a.clinic_code = '"+ward_Clinic_code+"' ";
     
	 stafforder_Sql +=" AND a.facility_id = '"+facility_id+"' AND dtl.facility_id = a.facility_id AND dtl.app_no = a.appt_ref_no GROUP BY  a.clinic_code,DIETTYPE ";
	 }
	 //For Out-Patient Alone Ends Here
	 
	 //For eMERGENCY-Patient Alone Starts Here
     if(patientClass.equalsIgnoreCase("EM")){
	 
	  stafforder_Sql +="SELECT op_get_desc.op_clinic ('"+facility_id+"', a.locn_code,'"+locale+"','1') op_clinic, diet_type, ds_get_desc.ds_diet_type (diet_type,'"+locale+"','2') diet_type_desc, COUNT (diet_type) assign_diet_type_cnt FROM op_patient_queue a, ds_em_diet_order_dtl dtl WHERE a.patient_class = '"+patientClass+"' AND a.queue_status != 99 AND TRUNC (serving_date) = TO_DATE ('"+servDate+"', 'DD/MM/YYYY') AND a.facility_id = '"+facility_id+"' AND dtl.facility_id = a.facility_id AND dtl.encounter_id = a.encounter_id ";
	  
	  if(!ward_Clinic_code.equalsIgnoreCase(""))
		stafforder_Sql +=" AND a.locn_code = '"+ward_Clinic_code+"'";
	
	  stafforder_Sql +=" GROUP BY a.locn_code, diet_type";
					}//For eMERGENCY-Patient Alone Starts Here
					
	 stafforder_Sql +=") GROUP BY OP_CLINIC,  DIET_TYPE , DIET_TYPE_DESC) GROUP BY op_clinic, DIET_TYPE, DIET_TYPE_DESC, menu_type order by op_clinic ";//CRF-902

	 System.err.println("Else-->465 stafforder_Sql==>"+stafforder_Sql);
}
return stafforder_Sql;
	}	

	//Added Against MML-MMOH-CRF-0423-US2 Ends Here
	
	/* Added Against Starts MML-MMOH-CRF-673 */
	public ConcurrentHashMap getBedClass(String locale){
		ConcurrentHashMap<String,String> bedMap = new ConcurrentHashMap<String,String>();
		Connection connection  = null ;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try{
			connection	= getConnection() ;
			String sql="SELECT BED_CLASS_CODE,SHORT_DESC FROM IP_BED_CLASS_LANG_VW WHERE EFF_STATUS = 'E' AND LANGUAGE_ID = ? ORDER BY 2";
			psmt = connection.prepareStatement(sql);
			System.err.println("484,sql==="+sql);
			psmt.setString(1,locale);
			rs=psmt.executeQuery(); 
		while(rs.next()){
				bedMap.put(rs.getString("BED_CLASS_CODE"),rs.getString("SHORT_DESC"));
				}
			}catch(Exception e){
		e.printStackTrace();
		}finally{
		 try{
			closeConnection( connection );
			if(psmt!=null) psmt.close();
			if(rs!=null) rs.close();
		 }catch(Exception ee){
			ee.printStackTrace();
			}
		}
	
	System.err.println("506,return bedMap==="+bedMap);
	 return bedMap;
	}  
	
	
	public String getIPBedClass(String nursingUnitCode,String bedNo,String facility_id)
	{
		Connection connection=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String bedClassCode="";
		try{
		
			connection	= getConnection() ;
			String sql="SELECT B.BED_CLASS_CODE FROM IP_NURSING_UNIT_BED A,IP_BED_CLASS B WHERE A.BED_CLASS_CODE = B.BED_CLASS_CODE AND A.NURSING_UNIT_CODE=? AND A.BED_NO=? AND A.FACILITY_ID=? ";
			psmt = connection.prepareStatement(sql);
			psmt.setString(1,nursingUnitCode);
			psmt.setString(2,bedNo);
			psmt.setString(3,facility_id);
			rs=psmt.executeQuery(); 
		while(rs.next()){
				bedClassCode = CommonBean.checkForNull(rs.getString("BED_CLASS_CODE"));
				}
			}
		catch(Exception e){
		System.err.println("getIPBedClass,e====="+e.getMessage());
		e.printStackTrace();
		}finally{
		 try{
			closeConnection( connection );
			if(psmt!=null) psmt.close();
			if(rs!=null) rs.close();
		 }catch(Exception ee){
			System.err.println("getIPBedClass,ee====="+ee.getMessage());
			ee.printStackTrace();
			}
		}
		return bedClassCode;
	}
	
	public HashMap getMealClass()
	{
		HashMap<String,String> mealClassCode = new HashMap<String,String>();
		Connection connection=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try{
			connection	= getConnection() ;
			String sql="SELECT MEAL_CLASS,BED_CLASS_CODE FROM DS_MEAL_CLASS WHERE BED_CLASS_CODE IS NOT NULL ORDER BY 2";
			psmt = connection.prepareStatement(sql);
			rs=psmt.executeQuery(); 
		while(rs.next()){
				mealClassCode.put(rs.getString("MEAL_CLASS"),rs.getString("BED_CLASS_CODE"));
				}
			}
		catch(Exception e){
		System.err.println("getMealClass,e====="+e.getMessage());
		e.printStackTrace();
		}finally{
		 try{
			closeConnection( connection );
			if(psmt!=null) psmt.close();
			if(rs!=null) rs.close();
		 }catch(Exception ee){
			System.err.println("getMealClass,ee====="+ee.getMessage());
			ee.printStackTrace();
			}
		}
		return mealClassCode;
	}
	/* Added Against Ends MML-MMOH-CRF-673 */

	/* Added Against Starts KDAH-CRF-0352 */
	public HashMap getFeedType(String locale){
		HashMap<String,String> feedMap = new HashMap<String,String>();
		Connection connection  = null ;
		PreparedStatement psmt=null;
		ResultSet rs=null;
	try{
		connection	= getConnection() ;
		String sql_feed="SELECT feed_type, short_desc FROM ds_feed_type_lang_vw WHERE language_id = ? AND eff_status = 'E' ORDER BY 1";
		psmt = connection.prepareStatement(sql_feed);

		psmt.setString(1,locale);
		rs=psmt.executeQuery(); 
		while(rs.next()){
		feedMap.put(rs.getString("FEED_TYPE"),rs.getString("SHORT_DESC"));
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				closeConnection( connection );
				if(psmt!=null) psmt.close();
				if(rs!=null) rs.close();
				}catch(Exception ee){
					ee.printStackTrace();
			}
	}	
	return feedMap;
	}
	/* Added Against Ends KDAH-CRF-0352 */
	
	/*Added Against Start KDAH-CRF-0350 for Query Criteria Page - Kitchen Order Ticket
			1.kitchen - 2.MealType - 3.DietCategory - 4.MealClass - 5.DietType
	*/
	
	public HashMap getKitchenQuery(String locale,String facility_id){ // kitchen
		HashMap<String,String> kitchenMap = new HashMap<String,String>();
		Connection connection=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try{
			connection	= getConnection() ;
			String kitchen_query = DlQuery.DL_GET_KITCHEN_CODE;
			psmt = connection.prepareStatement(kitchen_query);			
			psmt.setString(1,locale);
			psmt.setString(2,facility_id);
			rs=psmt.executeQuery(); 
			while(rs.next()){
					kitchenMap.put(rs.getString("kitchen_code"),rs.getString("short_desc"));
				}
			}
		catch(Exception e){
			System.err.println("getKitchenQuery,e====="+e.getMessage());
			e.printStackTrace();
		}finally{
		 try{
				closeConnection( connection );
				if(psmt!=null) psmt.close();
				if(rs!=null) rs.close();
		 }catch(Exception ee){
				ee.printStackTrace();
			}
		}
		return kitchenMap;

	}	
	//Added for CRF-680 MenuType
	public HashMap getMenuType(String locale){ 
		HashMap<String,String> menuTypeMap = new HashMap<String,String>();
		Connection connection=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try{
			connection	= getConnection() ;			
			String menutype_query = "SELECT menu_type,short_desc FROM ds_menu_type_lang_vw WHERE language_id = ?  ORDER BY 2";			
			psmt = connection.prepareStatement(menutype_query);			
			psmt.setString(1,locale);
			rs=psmt.executeQuery(); 
			while(rs.next()){
					menuTypeMap.put(rs.getString("menu_type"),rs.getString("short_desc"));
				}
			}
		catch(Exception e){
			System.err.println("getMenuType,e====="+e.getMessage());
			e.printStackTrace();
		}finally{
		 try{
				closeConnection( connection );
				if(psmt!=null) psmt.close();
				if(rs!=null) rs.close();
		 }catch(Exception ee){
				ee.printStackTrace();
			}
		}
		return menuTypeMap;
	}
//Added for CRF-680 MenuType

	public HashMap getMealTypeQuery(String locale){ // MealType
		HashMap<String,String> mealTypeMap = new HashMap<String,String>();
		Connection connection=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try{
			connection	= getConnection() ;
			String mealType_query = DlQuery.DL_MEAL_TYPE_LIST;
			psmt = connection.prepareStatement(mealType_query);			
			psmt.setString(1,locale);
			rs=psmt.executeQuery(); 
			while(rs.next()){
					mealTypeMap.put(rs.getString("meal_type"),rs.getString("short_Desc"));
				}
			}
		catch(Exception e){
			System.err.println("getMealTypeQuery,e====="+e.getMessage());
			e.printStackTrace();
		}finally{
		 try{
				closeConnection( connection );
				if(psmt!=null) psmt.close();
				if(rs!=null) rs.close();
		 }catch(Exception ee){
				ee.printStackTrace();
			}
		}
		return mealTypeMap;
	}
	
	public HashMap getDietCategory(String locale){ // DietCategory
		HashMap<String,String> dietCategoryMap = new HashMap<String,String>();
		Connection connection=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try{
			connection	= getConnection() ;
			String dietCategory_query  = DlQuery.DL_DS_DIET_CATEGORY;
			psmt = connection.prepareStatement(dietCategory_query);			
			psmt.setString(1,locale);
			rs=psmt.executeQuery(); 
			while(rs.next()){
					dietCategoryMap.put(rs.getString("code"),rs.getString("description"));
				}
			}
		catch(Exception e){
				System.err.println("getDietCategory,e====="+e.getMessage());
				e.printStackTrace();
		}finally{
		 try{
				closeConnection( connection );
				if(psmt!=null) psmt.close();
				if(rs!=null) rs.close();
		 }catch(Exception ee){
				ee.printStackTrace();
			}
		}
		return dietCategoryMap;
	}
	
	public HashMap getMealClassValues(String locale){ // MealClass
		HashMap<String,String> mealClassMap = new HashMap<String,String>();
		Connection connection=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try{
			connection	= getConnection();			
			psmt = connection.prepareStatement("SELECT MEAL_CLASS,SHORT_DESC FROM DS_MEAL_CLASS_LANG_VW WHERE LANGUAGE_ID= ? ORDER BY 2");			
			psmt.setString(1,locale);
			rs=psmt.executeQuery(); 
			while(rs.next()){
				mealClassMap.put(rs.getString("MEAL_CLASS"),rs.getString("SHORT_DESC"));
				}
			}
		catch(Exception e){
			System.err.println("getMealClassValues,e====="+e.getMessage());
			e.printStackTrace();
		}finally{
		 try{
				closeConnection( connection );
				if(psmt!=null) psmt.close();
				if(rs!=null) rs.close();
		 }catch(Exception ee){
				ee.printStackTrace();
			}
		}
		return mealClassMap;
	}
	
	public HashMap getDietType(String locale){  // DietType
		HashMap<String,String> dietTypeMap = new HashMap<String,String>();
		Connection connection=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try{
			connection	= getConnection();
			psmt = connection.prepareStatement("SELECT DIET_TYPE,SHORT_DESC FROM DS_DIET_TYPE_LANG_VW WHERE LANGUAGE_ID= ? ORDER BY 2");
			psmt.setString(1,locale);
			rs=psmt.executeQuery(); 
			while(rs.next()){
					dietTypeMap.put(rs.getString("DIET_TYPE"),rs.getString("SHORT_DESC"));
				}
			}
		catch(Exception e){
			System.err.println("getDietType,e====="+e.getMessage());
			e.printStackTrace();
		}finally{
		 try{
				closeConnection( connection );
				if(psmt!=null) psmt.close();
				if(rs!=null) rs.close();
		 }catch(Exception ee){
				ee.printStackTrace();
			}
		}
		return dietTypeMap;
	}
	
	public String getFoodItems(String locale,String facility_id,String kitchen_code,String meal_type,String patient_class,String diet_category,String meal_class,String diet_type,String serving_date){  // Food Items for Result Page - Kitchen Order Ticket
		Connection connection=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		int i=0;
		int count=0;
		StringBuffer foodItemsQuery = new StringBuffer();
		StringBuffer kitchenOrderQuery= new StringBuffer();
		String QueryValue="";
		try{
			connection	= getConnection() ;
			foodItemsQuery.append ("SELECT  ds_get_desc.ds_items(a.item_code,a.item_type,?,'1') FOOD_ITEM_DESC, ds_get_desc.ds_meal_type(a.meal_type,?,'2') MEAL_TYPE_DESC,SUM(QTY) ITEM_QTY FROM( SELECT b.item_code,b.item_type, b.meal_type, b.item_qty qty FROM ds_epsd_meal_plan_hdr a, ds_epsd_meal_plan_dtl b WHERE a.operating_facility_id = ? AND a.operating_facility_id = b.operating_facility_id AND a.encounter_id = b.encounter_id AND a.serving_date = b.serving_date AND a.meal_type    = b.meal_type    AND TRUNC(a.serving_date) = TO_DATE (?, 'DD/MM/YYYY') AND a.kitchen_code = NVL (?, a.kitchen_code) AND a.meal_type = NVL (?, a.meal_type) AND (? = 'IP' OR ? IS NULL) AND a.diet_category_code = NVL (?, a.diet_category_code) AND a.meal_class = NVL (?, a.meal_class) AND a.diet_type = NVL (?, a.diet_type)");
			foodItemsQuery.append (" UNION ALL SELECT c.item_code,c.item_type, meal_type, (d.cnt * c.item_qty) qty FROM ds_menu_item c,(SELECT   menu_code, b.mealtype meal_type, COUNT (menu_code) cnt FROM ds_diet_menu_time_table a, ds_op_diet_order_dtl b, ds_op_diet_order_hdr c, ds_diet_type d WHERE a.operating_facility_id = ? AND a.operating_facility_id = b.facility_id AND b.diettype IS NOT NULL AND a.diet_type = b.diettype AND a.meal_type = b.mealtype AND c.facility_id = b.facility_id AND NVL (c.encounter_id, c.app_no) = NVL (b.encounter_id, b.app_no)  AND c.serving_date = b.serving_date AND b.diettype = d.diet_type AND a.day_no IN (select ds_get_day_ref_fun ( ?, TO_DATE ( ?, 'dd/mm/yyyy'), a.diet_type,'')  from dual)AND TRUNC (b.serving_date) = TO_DATE (?, 'DD/MM/YYYY') AND c.kitchen = NVL (?, c.kitchen) AND b.mealtype = NVL (?, b.mealtype) AND (? = 'OP' OR ? IS NULL) AND ? IS NULL  AND d.diet_category_code = NVL (?, d.diet_category_code) AND a.diet_type = NVL (?, a.diet_type) GROUP BY menu_code, b.mealtype) d WHERE c.menu_code = d.menu_code");
			foodItemsQuery.append (" UNION ALL SELECT c.item_code,c.item_type,meal_type, (d.cnt * c.item_qty) qty FROM ds_menu_item c,(SELECT   menu_code, b.meal_type, COUNT (menu_code) cnt FROM ds_diet_menu_time_table a, ds_em_diet_order_dtl b, ds_em_diet_order_hdr c, ds_diet_type d WHERE a.operating_facility_id = ? AND a.operating_facility_id = b.facility_id AND b.diet_type IS NOT NULL AND a.diet_type = b.diet_type AND a.meal_type = b.meal_type AND c.facility_id = b.facility_id AND c.encounter_id = b.encounter_id AND c.serving_date = b.serving_date AND b.diet_type = d.diet_type AND a.day_no IN (select ds_get_day_ref_fun (?, TO_DATE (?, 'dd/mm/yyyy'), a.diet_type,'') from dual) AND TRUNC (b.serving_date) = TO_DATE (?, 'DD/MM/YYYY') AND c.kitchen = NVL (?, c.kitchen) AND b.meal_type = NVL (?, b.meal_type) AND (? = 'EM' OR ? IS NULL) AND ? IS NULL AND d.diet_category_code = NVL (?, d.diet_category_code) AND a.diet_type = NVL (?, a.diet_type) GROUP BY menu_code, b.meal_type) d WHERE c.menu_code = d.menu_code");
			foodItemsQuery.append (" UNION ALL SELECT c.item_code,c.item_type, meal_type, (d.cnt * c.item_qty) qty FROM ds_menu_item c,(SELECT   menu_code, b.meal_type, COUNT (menu_code) * b.no_of_meals_orders cnt FROM ds_diet_menu_time_table a, ds_staff_orders_dtl b, ds_staff_orders_hdr c, ds_diet_type d WHERE a.operating_facility_id = ? AND a.operating_facility_id = b.facility_id AND b.diet_type IS NOT NULL AND C.EFF_STATUS IS NULL AND a.diet_type = b.diet_type AND a.meal_type = b.meal_type AND c.facility_id = b.facility_id AND c.staff_order_id = b.staff_order_id AND b.diet_type = d.diet_type AND a.day_no IN (select ds_get_day_ref_fun (?, TO_DATE (?, 'dd/mm/yyyy'), a.diet_type,b.meal_class) from dual) AND TO_DATE (?, 'DD/MM/YYYY') BETWEEN TRUNC (c.order_from_date) AND TRUNC (c.order_to_date) AND a.kitchen_code = NVL (?, a.kitchen_code) AND b.meal_type = NVL (?, b.meal_type) AND (? = 'ST' OR ? IS NULL) AND d.diet_category_code = NVL (?, d.diet_category_code) AND a.diet_type = NVL (?, a.diet_type) GROUP BY menu_code, b.meal_type, b.no_of_meals_orders) d WHERE c.menu_code = d.menu_code ) a, ds_meal_type b WHERE a.meal_type = b.meal_type group by item_code,a.item_type, a.meal_type, MEAL_ORDER order by meal_order, lower(FOOD_ITEM_DESC)");
		
			psmt = connection.prepareStatement(foodItemsQuery.toString());
			System.err.println("foodItemsQuery==="+foodItemsQuery.toString());
			psmt.setString(++count,locale);
			psmt.setString(++count,locale);
			psmt.setString(++count,facility_id);
			psmt.setString(++count,serving_date);
			psmt.setString(++count,kitchen_code);
			psmt.setString(++count,meal_type);
			psmt.setString(++count,patient_class);
			psmt.setString(++count,patient_class);
			psmt.setString(++count,diet_category);
			psmt.setString(++count,meal_class);
			psmt.setString(++count,diet_type); // before union 1
			psmt.setString(++count,facility_id);
			psmt.setString(++count,facility_id);
			psmt.setString(++count,serving_date);
			psmt.setString(++count,serving_date);
			psmt.setString(++count,kitchen_code);
			psmt.setString(++count,meal_type);
			psmt.setString(++count,patient_class);
			psmt.setString(++count,patient_class);
			psmt.setString(++count,meal_class);
			psmt.setString(++count,diet_category);
			psmt.setString(++count,diet_type); // till 1st union
			psmt.setString(++count,facility_id); 
			psmt.setString(++count,facility_id); 
			psmt.setString(++count,serving_date); 
			psmt.setString(++count,serving_date); 
			psmt.setString(++count,kitchen_code); 
			psmt.setString(++count,meal_type); 
			psmt.setString(++count,patient_class); 
			psmt.setString(++count,patient_class); 
			psmt.setString(++count,meal_class);
			psmt.setString(++count,diet_category); 
			psmt.setString(++count,diet_type); //till 2nd union
			psmt.setString(++count,facility_id); 
			psmt.setString(++count,facility_id); 
			psmt.setString(++count,serving_date); 
			psmt.setString(++count,serving_date); 
			psmt.setString(++count,kitchen_code); 
			psmt.setString(++count,meal_type); 
			psmt.setString(++count,patient_class); 
			psmt.setString(++count,patient_class);
			psmt.setString(++count,diet_category);
			psmt.setString(++count,diet_type); // till 3rd union
			rs=psmt.executeQuery(); 
			while(rs!= null && rs.next()){
				if(!(i==0)){
				kitchenOrderQuery.append("##");
				}
				kitchenOrderQuery.append(rs.getString("MEAL_TYPE_DESC")+","+rs.getString("FOOD_ITEM_DESC")+","+rs.getString("ITEM_QTY"));
				i++;
				}
			QueryValue = kitchenOrderQuery.toString();
		}
		catch(Exception e){
			System.err.println("getFoodItems,e====="+e.getMessage());
			e.printStackTrace();
		}finally{
		 try{
				closeConnection( connection );
				if(psmt!=null) psmt.close();
				if(rs!=null) rs.close();
		 }catch(Exception ee){
				ee.printStackTrace();
			}
		}		
		System.err.println("return,QueryValue==="+QueryValue);		
		return QueryValue;
	}	
/*Added Against End KDAH-CRF-0350*/


/* Added Against MML-MMOH-CRF-0598 starts Here */
	public LinkedHashMap getPatientClass(String locale){
		LinkedHashMap map = new LinkedHashMap();
		Connection connection  = null ;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try{
			connection	= getConnection() ;
			String sql="SELECT PATIENT_CLASS,SHORT_DESC FROM AM_PATIENT_CLASS_LANG_VW WHERE LANGUAGE_ID=? ORDER BY 1";
			psmt = connection.prepareStatement(sql);
			psmt.setString(1,locale);
			rs=psmt.executeQuery(); 
			while(rs.next()){
				map.put(rs.getString(1),rs.getString(2));
				}
			}catch(Exception e){
			e.printStackTrace();
			}finally{
			 try{
				closeConnection( connection );
				if(psmt!=null) psmt.close();
				if(rs!=null) rs.close();
			 }catch(Exception ee){
				ee.printStackTrace();
				}
			}
	 return map;
	}  
	/* Added Against MML-MMOH-CRF-0598 Ends Here */	

	/* Added Against MML-MMOH-CRF-0685 Starts Here */
	public ArrayList<JSONObject> getRejectionList(String oncall,String servingFrom_date,String servingTo_date,String patient_class1,String acknowledge_yn,String patient_id1,String patient_status,String locale,String facility_id)
	{		
		//JSONObject jsonList = new JSONObject();	//Common-ICN-0044
		int index = 0;
		ArrayList<JSONObject> RejectionList = new ArrayList<JSONObject>();
		Connection connection  = null ;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String serving_date = "";
	    String patient_id = "";
		String patient_name = "";
		String patient_class = "";
		String location = "";
		String meal_type = "";
		String complaints = "";
		String rejection_date_time = "";
		String food_replacement = "";
		String acknowledged_by = "";
		String acknowledged_date_time = "";
		String acknowledge="";
		String encounter_id="";
		String app_no="";
		String mealtype_code="";
		String status="";		
		String RejectionList_query = "";

	try{
			connection	= getConnection();

			//complaint_desc - column change for MML-MMOH-CRF-1125-US006
			RejectionList_query = "SELECT TO_CHAR (a.serving_date, 'DD/MM/YYYY') serving_date, c.patient_id,a.serving_date serv_date,d.patient_name, 'Inpatient' patient_type,ip_get_desc.ip_nursing_unit ('"+facility_id+"', assign_care_locn_code, '"+locale+"', '2') location_desc,ds_get_desc.ds_meal_type (a.meal_type, '"+locale+"', '2' ) meal_type_desc,case when a.complaint_code is not null then a.complaint_desc else a.oth_complaint_desc end complaint_desc, TO_CHAR(a.event_date_time,'DD/MM/YYYY HH24:MI') reject_date_time,DECODE (a.meal_replace_yn, 'Y', 'Yes', 'N', 'No', 'No') food_replace,CASE WHEN acknowledge_by_id IS NOT NULL THEN sm_get_desc.sm_appl_user (acknowledge_by_id, '"+locale+"','1') END acknowledge_by, TO_CHAR(b.acknowledge_date_time,'DD/MM/YYYY HH24:MI') acknowledge_date_time, DECODE (b.acknowledge_yn, 'Y', 'Yes', 'N', 'No', 'No') acknowledge_yn,a.encounter_id,null app_no, a.meal_type, a.status FROM ds_epsd_meal_plan_hdr_audit a,ds_meal_complaint_acknowledge b,pr_encounter c,mp_patient d WHERE a.status IN ('MJ') AND (a.complaint_code IS NOT NULL OR a.oth_complaint_desc IS NOT NULL) AND a.operating_facility_id = c.facility_id AND a.encounter_id = c.encounter_id AND c.patient_id = d.patient_id AND a.operating_facility_id = b.operating_facility_id(+) AND a.encounter_id = b.encounter_id(+) AND a.serving_date = b.serving_date(+)AND a.meal_type = b.meal_type(+) and a.status = b.status(+)";
		if(oncall.equalsIgnoreCase("onLoad"))
		{
			RejectionList_query +=" AND NVL(b.acknowledge_yn,'N') = ?";
		}
		else
		{
			RejectionList_query +=" AND a.serving_date between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') AND (? = 'IP' OR ? IS NULL)";
		if(!acknowledge_yn.equalsIgnoreCase("A"))
		{
			RejectionList_query +=" AND NVL(b.acknowledge_yn,'N') = ?";
		}
		//Active & Discharge
		if(patient_status.equalsIgnoreCase("A"))
		{
			RejectionList_query +=" AND discharge_date_time IS NULL";
		}
		else if (patient_status.equalsIgnoreCase("D"))
		{
			RejectionList_query +=" AND discharge_date_time IS NOT NULL";
		}
			RejectionList_query +=" AND c.patient_id= NVL(?,  c.patient_id)";
		}
			//complaint_desc - column change for MML-MMOH-CRF-1125-US006
			RejectionList_query += " UNION SELECT TO_CHAR (a.serving_date, 'DD/MM/YYYY') serving_date, c.patient_id,a.serving_date serv_date,d.patient_name, 'Outpatient' patient_type,op_get_desc.op_clinic ('"+facility_id+"', locn_code, '"+locale+"', '2') location_desc,ds_get_desc.ds_meal_type (a.mealtype, '"+locale+"', '2' ) meal_type_desc,case when a.complaint_code is not null then ds_get_desc.ds_complaints(a.Complaint_code,'"+locale+"','1') else a.oth_complaint_desc end complaint_desc,TO_CHAR(a.acknowledge_date_time,'DD/MM/YYYY HH24:MI') reject_date_time, DECODE (a.meal_replace_yn, 'Y', 'Yes', 'N', 'No', 'No') food_replace,CASE WHEN acknowledge_by_id IS NOT NULL THEN sm_get_desc.sm_appl_user (acknowledge_by_id, '"+locale+"','1') END acknowledge_by,TO_CHAR(b.acknowledge_date_time,'DD/MM/YYYY HH24:MI') acknowledge_date_time, DECODE (b.acknowledge_yn, 'Y', 'Yes', 'N', 'No', 'No') acknowledge_yn,a.encounter_id,null app_no, a.mealtype meal_type, a.status FROM ds_op_diet_order_dtl a,ds_meal_complaint_acknowledge b, op_patient_queue c,mp_patient d WHERE a.status IN ('MR') AND (a.complaint_code IS NOT NULL OR a.oth_complaint_desc IS NOT NULL) AND a.facility_id = c.facility_id AND a.encounter_id = c.encounter_id AND c.patient_id = d.patient_id AND a.facility_id = b.operating_facility_id(+) AND a.encounter_id = b.encounter_id(+) AND a.serving_date = b.serving_date(+) AND a.mealtype = b.meal_type(+) and a.status = b.status(+)";

		if(oncall.equalsIgnoreCase("onLoad"))
		{
			RejectionList_query +=" AND NVL(b.acknowledge_yn,'N') = ?";
		}
		else
		{
			RejectionList_query +=" AND a.serving_date between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') AND (? = 'OP' OR ? IS NULL) ";
		if(!acknowledge_yn.equalsIgnoreCase("A"))
		{
			RejectionList_query +=" AND NVL(b.acknowledge_yn,'N') = ?";
		}
		//Active & Discharge
		if(patient_status.equalsIgnoreCase("A"))
		{
			RejectionList_query +=" AND discharge_date_time IS NULL";
		}
		else if (patient_status.equalsIgnoreCase("D"))
		{
			RejectionList_query +=" AND discharge_date_time IS NOT NULL";
		}
			RejectionList_query +="  AND c.patient_id = NVL(?,  c.patient_id)";
		}
			//complaint_desc - column change for MML-MMOH-CRF-1125-US006
			RejectionList_query += " UNION SELECT TO_CHAR (a.serving_date, 'DD/MM/YYYY') serving_date, c.patient_id,a.serving_date serv_date,c.patient_name, 'Outpatient' patient_type,op_get_desc.op_clinic ('"+facility_id+"', clinic_code, '"+locale+"', '2') location_desc,ds_get_desc.ds_meal_type (a.mealtype, '"+locale+"', '2' ) meal_type_desc,case when a.complaint_code is not null then ds_get_desc.ds_complaints(a.Complaint_code,'"+locale+"','1') else a.oth_complaint_desc end complaint_desc, TO_CHAR(a.acknowledge_date_time,'DD/MM/YYYY HH24:MI') reject_date_time, DECODE (a.meal_replace_yn, 'Y', 'Yes', 'N', 'No', 'No') food_replace, CASE WHEN acknowledge_by_id IS NOT NULL THEN sm_get_desc.sm_appl_user (acknowledge_by_id, '"+locale+"','1') END acknowledge_by, TO_CHAR(b.acknowledge_date_time,'DD/MM/YYYY HH24:MI') acknowledge_date_time, DECODE (b.acknowledge_yn, 'Y', 'Yes', 'N', 'No', 'No') acknowledge_yn,null encounter_id,a.app_no, a.mealtype meal_type, a.status FROM ds_op_diet_order_dtl a, ds_meal_complaint_acknowledge b, oa_appt c WHERE a.status IN ('MR') AND (a.complaint_code IS NOT NULL OR a.oth_complaint_desc IS NOT NULL) AND a.facility_id = c.facility_id AND a.APP_NO = c.APPT_REF_NO AND a.facility_id = b.operating_facility_id(+) AND a.APP_NO = b.APP_NO(+) AND a.serving_date = b.serving_date(+) AND a.mealtype = b.meal_type(+) and a.status = b.status(+)";

		if(oncall.equalsIgnoreCase("onLoad"))
		{
			RejectionList_query +=" AND NVL(b.acknowledge_yn,'N') = ?";
		}
		else
		{
			RejectionList_query +=" AND a.serving_date between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') AND (? = 'OP' OR ? IS NULL) ";
		if(!acknowledge_yn.equalsIgnoreCase("A"))
		{
			RejectionList_query +=" AND NVL(b.acknowledge_yn,'N') = ?";
		}
		//Active & Discharge
		if(patient_status.equalsIgnoreCase("A"))
		{
			RejectionList_query +=" AND APPT_STATUS = '1'";
		}
		else if (patient_status.equalsIgnoreCase("D"))
		{
			RejectionList_query +=" AND APPT_STATUS = 'A'";
		}
			RejectionList_query +="  AND c.patient_id = NVL (?, c.patient_id)";
		}

			//complaint_desc - column change for MML-MMOH-CRF-1125-US006
			RejectionList_query +=" UNION SELECT TO_CHAR (a.serving_date, 'DD/MM/YYYY') serving_date, c.patient_id, a.serving_date serv_date,d.patient_name,'Emergency' patient_type,op_get_desc.op_clinic ('"+facility_id+"', locn_code, '"+locale+"', '2') location_desc,ds_get_desc.ds_meal_type (a.meal_type, '"+locale+"', '2' ) meal_type_desc,case when a.complaint_code is not null then ds_get_desc.ds_complaints(a.Complaint_code,'"+locale+"','1') else a.oth_complaint_desc end complaint_desc, TO_CHAR(a.acknowledge_date_time,'DD/MM/YYYY HH24:MI') reject_date_time, DECODE (a.meal_replace_yn, 'Y', 'Yes', 'N', 'No', 'No') food_replace, CASE WHEN acknowledge_by_id IS NOT NULL THEN sm_get_desc.sm_appl_user (acknowledge_by_id, '"+locale+"','1') END acknowledge_by,TO_CHAR(b.acknowledge_date_time,'DD/MM/YYYY HH24:MI') acknowledge_date_time, DECODE (b.acknowledge_yn, 'Y', 'Yes', 'N', 'No', 'No') acknowledge_yn,a.encounter_id,null app_no, a.meal_type, a.status FROM ds_em_diet_order_dtl a, ds_meal_complaint_acknowledge b, op_patient_queue c, mp_patient d WHERE a.status IN ('MR') AND (a.complaint_code IS NOT NULL OR a.oth_complaint_desc IS NOT NULL) AND a.facility_id = c.facility_id AND a.encounter_id = c.encounter_id AND c.patient_id = d.patient_id AND a.facility_id = b.operating_facility_id(+) AND a.encounter_id = b.encounter_id(+) AND a.serving_date = b.serving_date(+) AND a.meal_type = b.meal_type(+) and a.status = b.status(+)";

		if(oncall.equalsIgnoreCase("onLoad"))
		{
			RejectionList_query +=" AND NVL(b.acknowledge_yn,'N') = ?";
		}
		else
		{
			RejectionList_query +=" AND a.serving_date between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') AND (? = 'EM' OR ? IS NULL)";
		if(!acknowledge_yn.equalsIgnoreCase("A"))
		{
			RejectionList_query +=" AND NVL(b.acknowledge_yn,'N') = ?";
		}
		//Active & Discharge
		if(patient_status.equalsIgnoreCase("A"))
		{
			RejectionList_query +=" AND discharge_date_time IS NULL";
		}
		else if (patient_status.equalsIgnoreCase("D"))
		{
			RejectionList_query +=" AND discharge_date_time IS NOT NULL";
		}
			RejectionList_query +="  AND c.patient_id = NVL(?,  c.patient_id)";
		}
			RejectionList_query +=" order by serv_date";
			
			psmt = connection.prepareStatement(RejectionList_query);
		if(oncall.equalsIgnoreCase("onLoad"))
		{
			psmt.setString(++index,acknowledge_yn);
			psmt.setString(++index,acknowledge_yn);
			psmt.setString(++index,acknowledge_yn);
			psmt.setString(++index,acknowledge_yn);					
		}
		else
		{
			psmt.setString(++index,servingFrom_date);
			psmt.setString(++index,servingTo_date);
			psmt.setString(++index,patient_class1);
			psmt.setString(++index,patient_class1);
		if(!acknowledge_yn.equalsIgnoreCase("A"))
		{
			psmt.setString(++index,acknowledge_yn);							
		}						
			psmt.setString(++index,patient_id1);					
			psmt.setString(++index,servingFrom_date);
			psmt.setString(++index,servingTo_date);
			psmt.setString(++index,patient_class1);
			psmt.setString(++index,patient_class1);
		if(!acknowledge_yn.equalsIgnoreCase("A"))
		{
			psmt.setString(++index,acknowledge_yn);	
		}
			psmt.setString(++index,patient_id1);				
			psmt.setString(++index,servingFrom_date);
			psmt.setString(++index,servingTo_date);
			psmt.setString(++index,patient_class1);
			psmt.setString(++index,patient_class1);
		if(!acknowledge_yn.equalsIgnoreCase("A"))
		{
			psmt.setString(++index,acknowledge_yn);	
		}
			psmt.setString(++index,patient_id1);				
			psmt.setString(++index,servingFrom_date);
			psmt.setString(++index,servingTo_date);
			psmt.setString(++index,patient_class1);
			psmt.setString(++index,patient_class1);
		if(!acknowledge_yn.equalsIgnoreCase("A"))
		{
			psmt.setString(++index,acknowledge_yn);
		}
			psmt.setString(++index,patient_id1);
		}

	rs = psmt.executeQuery();
	while(rs.next()){
		serving_date=rs.getString(1);
		patient_id=rs.getString(2);	
		patient_name=rs.getString(4);			
		patient_class =rs.getString(5);			
		location = rs.getString(6);			
		meal_type = rs.getString(7);			
		complaints = rs.getString(8);			
		rejection_date_time =rs.getString(9);			
		food_replacement = rs.getString(10);			
		acknowledged_by = rs.getString(11);			
		acknowledged_date_time = rs.getString(12);			
		acknowledge=rs.getString(13);			
		encounter_id=rs.getString(14);			
		app_no=rs.getString(15);			
		mealtype_code=rs.getString(16);			
		status=rs.getString(17);			

		JSONObject RejectionListobj= new JSONObject();
		RejectionListobj.put("serving_date", CommonBean.checkForNull(serving_date));
		RejectionListobj.put("patient_id", CommonBean.checkForNull(patient_id));	
		RejectionListobj.put("patient_name", CommonBean.checkForNull(patient_name));				
		RejectionListobj.put("patient_class", CommonBean.checkForNull(patient_class));
		RejectionListobj.put("location", CommonBean.checkForNull(location));
		RejectionListobj.put("meal_type", CommonBean.checkForNull(meal_type));
		RejectionListobj.put("complaints", CommonBean.checkForNull(complaints));
		RejectionListobj.put("rejection_date_time", CommonBean.checkForNull(rejection_date_time));
		RejectionListobj.put("food_replacement", CommonBean.checkForNull(food_replacement));
		RejectionListobj.put("acknowledged_by", CommonBean.checkForNull(acknowledged_by));
		RejectionListobj.put("acknowledged_date_time", CommonBean.checkForNull(acknowledged_date_time));
		RejectionListobj.put("acknowledge", CommonBean.checkForNull(acknowledge));
		RejectionListobj.put("encounter_id", CommonBean.checkForNull(encounter_id));
		RejectionListobj.put("app_no", CommonBean.checkForNull(app_no));
		RejectionListobj.put("mealtype_code", CommonBean.checkForNull(mealtype_code));
		RejectionListobj.put("status", CommonBean.checkForNull(status));
		RejectionList.add(RejectionListobj);

		}			
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			closeConnection( connection );
			psmt.close();	//Added Against Common-ICN-0031
				rs.close();	//Added Against Common-ICN-0031
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		System.err.println("RejectionList--DSCommonBean-->"+RejectionList);
		return RejectionList;		
	}
	//Added Against ML-MMOH-CRF-0685 Ends Here
	
	/* Added Against ML-MMOH-CRF-0687 Starts Here */
	public ArrayList<JSONObject> getComplaintList(String oncall,String servingFrom_date,String servingTo_date,String patient_class1,String acknowledge_yn,String patient_id1,String patient_status,String locale,String facility_id)
	{		
		//JSONObject jsonList = new JSONObject();	//Common-ICN-0044
		int index = 0;
		ArrayList<JSONObject> ComplaintList = new ArrayList<JSONObject>();
		Connection connection  = null ;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String serving_date = "";
	    String patient_id = "";
		String patient_name = "";
		String patient_class = "";
		String location = "";
		String meal_type = "";
		String meal_status = "";
		String complaints = "";
		String complaint_date_time = "";
		String acknowledged_by = "";
		String acknowledged_date_time = "";
		String acknowledge="";
		String encounter_id="";
		String app_no="";
		String mealtype_code="";
		String status="";		
		String ComplaintList_query = "";

	try{
			connection	= getConnection();
			/*ML_MMOH_CRF-1061_Acknowledgement Status Changed*/
			ComplaintList_query = "SELECT TO_CHAR (a.serving_date, 'DD/MM/YYYY') serving_date, c.patient_id,a.serving_date serv_date,d.patient_name, 'Inpatient' patient_type,ip_get_desc.ip_nursing_unit ('"+facility_id+"', assign_care_locn_code, '"+locale+"', '2') location_desc,ds_get_desc.ds_meal_type (a.meal_type, '"+locale+"', '2' ) meal_type_desc,E.STATUS_DESC meal_status,complaint_desc, TO_CHAR(a.event_date_time,'DD/MM/YYYY HH24:MI') comp_date_time, CASE WHEN acknowledge_by_id IS NOT NULL THEN sm_get_desc.sm_appl_user (acknowledge_by_id, '"+locale+"','1') END acknowledge_by, TO_CHAR(b.acknowledge_date_time,'DD/MM/YYYY HH24:MI') acknowledge_date_time, DECODE (b.acknowledge_yn, 'Y', 'Yes', 'N', 'No', 'No') acknowledge_yn,a.encounter_id,null app_no, a.meal_type, a.status FROM ds_epsd_meal_plan_hdr_audit a,ds_meal_complaint_acknowledge b,pr_encounter c,mp_patient d,ds_meal_ack_status_mast e WHERE a.status NOT IN ('MJ') AND (a.complaint_code IS NOT NULL AND UPPER(a.complaint_code) != 'NULL') AND a.operating_facility_id = c.facility_id AND a.encounter_id = c.encounter_id AND c.patient_id = d.patient_id AND e.PATIENT_CLASS ='IP' AND e.status_code = A.STATUS AND a.operating_facility_id = b.operating_facility_id(+) AND a.encounter_id = b.encounter_id(+) AND a.serving_date = b.serving_date(+)AND a.meal_type = b.meal_type(+) and a.status = b.status(+)";
		if(oncall.equalsIgnoreCase("onLoad"))
		{
			ComplaintList_query +=" AND NVL(b.acknowledge_yn,'N') = ?";
		}
		else
		{
			ComplaintList_query +=" AND a.serving_date between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') AND (? = 'IP' OR ? IS NULL)";
		if(!acknowledge_yn.equalsIgnoreCase("A"))
		{
			ComplaintList_query +=" AND NVL(b.acknowledge_yn,'N') = ?";
		}
		//Active & Discharge
		if(patient_status.equalsIgnoreCase("A"))
		{
			ComplaintList_query +=" AND discharge_date_time IS NULL";
		}
		else if (patient_status.equalsIgnoreCase("D"))
		{
			ComplaintList_query +=" AND discharge_date_time IS NOT NULL";
		}
			ComplaintList_query +=" AND c.patient_id= NVL(?,  c.patient_id)";
		}
			ComplaintList_query += " UNION SELECT TO_CHAR (a.serving_date, 'DD/MM/YYYY') serving_date, c.patient_id,a.serving_date serv_date,d.patient_name, 'Outpatient' patient_type,op_get_desc.op_clinic ('"+facility_id+"', locn_code, '"+locale+"', '2') location_desc,ds_get_desc.ds_meal_type (a.mealtype, '"+locale+"', '2' ) meal_type_desc,E.STATUS_DESC meal_status,ds_get_desc.ds_complaints(a.Complaint_code,'"+locale+"','1') complaint_desc,TO_CHAR(a.acknowledge_date_time,'DD/MM/YYYY HH24:MI') comp_date_time, CASE WHEN acknowledge_by_id IS NOT NULL THEN sm_get_desc.sm_appl_user (acknowledge_by_id, '"+locale+"','1') END acknowledge_by,TO_CHAR(b.acknowledge_date_time,'DD/MM/YYYY HH24:MI') acknowledge_date_time, DECODE (b.acknowledge_yn, 'Y', 'Yes', 'N', 'No', 'No') acknowledge_yn,a.encounter_id,null app_no, a.mealtype meal_type, a.status FROM ds_op_diet_order_dtl a,ds_meal_complaint_acknowledge b, op_patient_queue c,mp_patient d,ds_meal_ack_status_mast e WHERE a.status NOT IN ('MR') AND (a.complaint_code IS NOT NULL AND UPPER(a.complaint_code) != 'NULL') AND a.facility_id = c.facility_id AND a.encounter_id = c.encounter_id AND c.patient_id = d.patient_id  AND e.PATIENT_CLASS ='OP'     AND e.status_code = A.STATUS AND a.facility_id = b.operating_facility_id(+) AND a.encounter_id = b.encounter_id(+) AND a.serving_date = b.serving_date(+) AND a.mealtype = b.meal_type(+) and a.status = b.status(+)";

		if(oncall.equalsIgnoreCase("onLoad"))
		{
			ComplaintList_query +=" AND NVL(b.acknowledge_yn,'N') = ?";
		}
		else
		{
			ComplaintList_query +=" AND a.serving_date between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') AND (? = 'OP' OR ? IS NULL) ";
		if(!acknowledge_yn.equalsIgnoreCase("A"))
		{
			ComplaintList_query +=" AND NVL(b.acknowledge_yn,'N') = ?";
		}
		//Active & Discharge
		if(patient_status.equalsIgnoreCase("A"))
		{
			ComplaintList_query +=" AND discharge_date_time IS NULL";
		}
		else if (patient_status.equalsIgnoreCase("D"))
		{
			ComplaintList_query +=" AND discharge_date_time IS NOT NULL";
		}
			ComplaintList_query +="  AND c.patient_id = NVL(?,  c.patient_id)";
		}
			ComplaintList_query += " UNION SELECT TO_CHAR (a.serving_date, 'DD/MM/YYYY') serving_date, c.patient_id,a.serving_date serv_date,c.patient_name, 'Outpatient' patient_type,op_get_desc.op_clinic ('"+facility_id+"', clinic_code, '"+locale+"', '2') location_desc,ds_get_desc.ds_meal_type (a.mealtype, '"+locale+"', '2' ) meal_type_desc,E.STATUS_DESC meal_status,ds_get_desc.ds_complaints(a.Complaint_code,'"+locale+"','1') complaint_desc, TO_CHAR(a.acknowledge_date_time,'DD/MM/YYYY HH24:MI') comp_date_time, CASE WHEN acknowledge_by_id IS NOT NULL THEN sm_get_desc.sm_appl_user (acknowledge_by_id, '"+locale+"','1') END acknowledge_by, TO_CHAR(b.acknowledge_date_time,'DD/MM/YYYY HH24:MI') acknowledge_date_time, DECODE (b.acknowledge_yn, 'Y', 'Yes', 'N', 'No', 'No') acknowledge_yn,null encounter_id,a.app_no, a.mealtype meal_type, a.status FROM ds_op_diet_order_dtl a, ds_meal_complaint_acknowledge b, oa_appt c,ds_meal_ack_status_mast e WHERE a.status NOT IN ('MR') AND (a.complaint_code IS NOT NULL AND UPPER(a.complaint_code) != 'NULL') AND a.facility_id = c.facility_id AND a.APP_NO = c.APPT_REF_NO  AND e.PATIENT_CLASS ='OP' AND e.status_code = A.STATUS AND a.facility_id = b.operating_facility_id(+) AND a.APP_NO = b.APP_NO(+) AND a.serving_date = b.serving_date(+) AND a.mealtype = b.meal_type(+) and a.status = b.status(+)";

		if(oncall.equalsIgnoreCase("onLoad"))
		{
			ComplaintList_query +=" AND NVL(b.acknowledge_yn,'N') = ?";
		}
		else
		{
			ComplaintList_query +=" AND a.serving_date between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') AND (? = 'OP' OR ? IS NULL) ";
		if(!acknowledge_yn.equalsIgnoreCase("A"))
		{
			ComplaintList_query +=" AND NVL(b.acknowledge_yn,'N') = ?";
		}
		//Active & Discharge
		if(patient_status.equalsIgnoreCase("A"))
		{
			ComplaintList_query +=" AND APPT_STATUS = '1'";
		}
		else if (patient_status.equalsIgnoreCase("D"))
		{
			ComplaintList_query +=" AND APPT_STATUS = 'A'";
		}
			ComplaintList_query +="  AND c.patient_id = NVL (?, c.patient_id)";
		}

			ComplaintList_query +=" UNION SELECT TO_CHAR (a.serving_date, 'DD/MM/YYYY') serving_date, c.patient_id, a.serving_date serv_date,d.patient_name,'Emergency' patient_type,op_get_desc.op_clinic ('"+facility_id+"', locn_code, '"+locale+"', '2') location_desc,ds_get_desc.ds_meal_type (a.meal_type, '"+locale+"', '2' ) meal_type_desc,E.STATUS_DESC meal_status,ds_get_desc.ds_complaints(a.Complaint_code,'"+locale+"','1') complaint_desc,TO_CHAR(a.acknowledge_date_time,'DD/MM/YYYY HH24:MI') comp_date_time, CASE WHEN acknowledge_by_id IS NOT NULL THEN sm_get_desc.sm_appl_user (acknowledge_by_id, '"+locale+"','1') END acknowledge_by,TO_CHAR(b.acknowledge_date_time,'DD/MM/YYYY HH24:MI') acknowledge_date_time, DECODE (b.acknowledge_yn, 'Y', 'Yes', 'N', 'No', 'No') acknowledge_yn,a.encounter_id,null app_no, a.meal_type, a.status FROM ds_em_diet_order_dtl a, ds_meal_complaint_acknowledge b, op_patient_queue c, mp_patient d,ds_meal_ack_status_mast e WHERE a.status NOT IN ('MR') AND (a.complaint_code IS NOT NULL AND UPPER(a.complaint_code) != 'NULL') AND a.facility_id = c.facility_id AND a.encounter_id = c.encounter_id AND c.patient_id = d.patient_id AND e.PATIENT_CLASS ='OP' AND e.status_code = A.STATUS AND a.facility_id = b.operating_facility_id(+) AND a.encounter_id = b.encounter_id(+) AND a.serving_date = b.serving_date(+) AND a.meal_type = b.meal_type(+) and a.status = b.status(+)";
			/*ML_MMOH_CRF-1061_Acknowledgement Status Changed*/

		if(oncall.equalsIgnoreCase("onLoad"))
		{
			ComplaintList_query +=" AND NVL(b.acknowledge_yn,'N') = ?";
		}
		else
		{
			ComplaintList_query +=" AND a.serving_date between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY') AND (? = 'EM' OR ? IS NULL)";
		if(!acknowledge_yn.equalsIgnoreCase("A"))
		{
			ComplaintList_query +=" AND NVL(b.acknowledge_yn,'N') = ?";
		}
		//Active & Discharge
		if(patient_status.equalsIgnoreCase("A"))
		{
			ComplaintList_query +=" AND discharge_date_time IS NULL";
		}
		else if (patient_status.equalsIgnoreCase("D"))
		{
			ComplaintList_query +=" AND discharge_date_time IS NOT NULL";
		}
			ComplaintList_query +="  AND c.patient_id = NVL(?,  c.patient_id)";
		}
			ComplaintList_query +=" order by serv_date";	
			
			psmt = connection.prepareStatement(ComplaintList_query);
		if(oncall.equalsIgnoreCase("onLoad"))
		{
			psmt.setString(++index,acknowledge_yn);
			psmt.setString(++index,acknowledge_yn);
			psmt.setString(++index,acknowledge_yn);
			psmt.setString(++index,acknowledge_yn);					
		}
		else
		{
			psmt.setString(++index,servingFrom_date);
			psmt.setString(++index,servingTo_date);
			psmt.setString(++index,patient_class1);
			psmt.setString(++index,patient_class1);
		if(!acknowledge_yn.equalsIgnoreCase("A"))
		{
			psmt.setString(++index,acknowledge_yn);							
		}						
			psmt.setString(++index,patient_id1);					
			psmt.setString(++index,servingFrom_date);
			psmt.setString(++index,servingTo_date);
			psmt.setString(++index,patient_class1);
			psmt.setString(++index,patient_class1);
		if(!acknowledge_yn.equalsIgnoreCase("A"))
		{
			psmt.setString(++index,acknowledge_yn);	
		}
			psmt.setString(++index,patient_id1);				
			psmt.setString(++index,servingFrom_date);
			psmt.setString(++index,servingTo_date);
			psmt.setString(++index,patient_class1);
			psmt.setString(++index,patient_class1);
		if(!acknowledge_yn.equalsIgnoreCase("A"))
		{
			psmt.setString(++index,acknowledge_yn);	
		}
			psmt.setString(++index,patient_id1);				
			psmt.setString(++index,servingFrom_date);
			psmt.setString(++index,servingTo_date);
			psmt.setString(++index,patient_class1);
			psmt.setString(++index,patient_class1);
		if(!acknowledge_yn.equalsIgnoreCase("A"))
		{
			psmt.setString(++index,acknowledge_yn);
		}
			psmt.setString(++index,patient_id1);
		}

	rs = psmt.executeQuery();
	while(rs.next()){
		serving_date=rs.getString(1);
		patient_id=rs.getString(2);	
		patient_name=rs.getString(4);			
		patient_class =rs.getString(5);			
		location = rs.getString(6);			
		meal_type = rs.getString(7);
		meal_status = rs.getString(8);
		complaints = rs.getString(9);			
		complaint_date_time =rs.getString(10);						
		acknowledged_by = rs.getString(11);			
		acknowledged_date_time = rs.getString(12);			
		acknowledge=rs.getString(13);			
		encounter_id=rs.getString(14);			
		app_no=rs.getString(15);			
		mealtype_code=rs.getString(16);			
		status=rs.getString(17);			

		JSONObject ComplaintListobj= new JSONObject();
		ComplaintListobj.put("serving_date", CommonBean.checkForNull(serving_date));
		ComplaintListobj.put("patient_id", CommonBean.checkForNull(patient_id));	
		ComplaintListobj.put("patient_name", CommonBean.checkForNull(patient_name));				
		ComplaintListobj.put("patient_class", CommonBean.checkForNull(patient_class));
		ComplaintListobj.put("location", CommonBean.checkForNull(location));
		ComplaintListobj.put("meal_type", CommonBean.checkForNull(meal_type));
		ComplaintListobj.put("meal_status", CommonBean.checkForNull(meal_status));
		ComplaintListobj.put("complaints", CommonBean.checkForNull(complaints));
		ComplaintListobj.put("complaint_date_time", CommonBean.checkForNull(complaint_date_time));
		ComplaintListobj.put("acknowledged_by", CommonBean.checkForNull(acknowledged_by));
		ComplaintListobj.put("acknowledged_date_time", CommonBean.checkForNull(acknowledged_date_time));
		ComplaintListobj.put("acknowledge", CommonBean.checkForNull(acknowledge));
		ComplaintListobj.put("encounter_id", CommonBean.checkForNull(encounter_id));
		ComplaintListobj.put("app_no", CommonBean.checkForNull(app_no));
		ComplaintListobj.put("mealtype_code", CommonBean.checkForNull(mealtype_code));
		ComplaintListobj.put("status", CommonBean.checkForNull(status));
		ComplaintList.add(ComplaintListobj);

		}			
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			closeConnection( connection );
			psmt.close();	//Added Against Common-ICN-0031
				rs.close();	//Added Against Common-ICN-0031
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		//System.err.println("ComplaintList--DSCommonBean-->"+ComplaintList);
		return ComplaintList;		
	}
	//Added Against ML-MMOH-CRF-0687 Ends Here	
	 
}