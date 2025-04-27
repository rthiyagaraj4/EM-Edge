package eDS.SupplementaryOrder.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import eDS.Common.JSONArray;
import eDS.Common.JSONObject;
import eDS.SupplementaryOrder.model.PlaceSupplementaryMealOrderRequest;
import eDS.SupplementaryOrder.model.PlaceSupplementaryMealOrderResponse;
import eDS.SupplementaryOrder.model.SupplementaryPlaceOrderRequest;
import eDS.SupplementaryOrder.model.SupplementaryPlaceOrderResponse;
import eDS.SupplementaryOrder.model.SupplementaryPlaceOrderResult;
import eDS.SupplementaryOrder.model.SupplementaryPlaceOrderResultList;
import eDS.SupplementaryOrder.model.SupplementaryProcessRequest;
import eDS.SupplementaryOrder.model.SupplementaryProcessResponse;

public class SupplementaryPlaceOrderDAOImpl implements SupplementaryPlaceOrderDAO{

	List<PlaceSupplementaryMealOrderResponse> supplementaryOrderResponseList;
	
	//@Override
	public SupplementaryPlaceOrderResponse getSupplementayPlaceSearch(
			SupplementaryPlaceOrderRequest request, Connection Conn) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		SupplementaryPlaceOrderResponse response=new SupplementaryPlaceOrderResponse();
		SupplementaryPlaceOrderResult obj=null;
		SupplementaryPlaceOrderResultList Listobj=new SupplementaryPlaceOrderResultList();
		
		String Nursing_Unit_Code,Facility_Id, Locale,Admission_From_Date,Admission_To_Date,PatientId,EncounterId,PractionerId,Gender, Start_Num, End_Num,Grace_Period,Status;//Added Against Start PMG2017-CRF-0012[IN:066074]
		//String irregular_flag=""; // 825-crf	//Common-ICN-0044
		try{
			con=Conn;
		Nursing_Unit_Code=request.getNursing_Unit_Code();
		Facility_Id=request.getFacility_Id();
		Locale=request.getLocale();
		Admission_From_Date=request.getAdmission_From_Date();
		Admission_To_Date=request.getAdmission_To_Date();
		PatientId=request.getPatientId();
		EncounterId=request.getEncounterId();
		PractionerId=request.getPractionerId();
		Gender=request.getGender();
		Start_Num=request.getStart_Num();
		End_Num=request.getEnd_Num();
		Grace_Period=request.getGrace_Period();
		Status=request.getStatus();
		// 825 start
		//String irregular_meal_code=request.getParameter("irregular_meal_code");//409
		//System.err.println("1937,irregular_meal_code==="+irregular_meal_code);
		// 825 end
		
		StringBuffer search_query=new StringBuffer();
		search_query.append("    select * from	");
		search_query.append("	( select ROWNUM rnum ,a.* from	"); 
		search_query.append("	(SELECT DISTINCT TO_CHAR (a.visit_adm_date_time, 'DD/MM/YYYY HH24:MI:SS') Visit_Adm_Date,a.visit_adm_date_time visit_adm_date_time_sort,	");//601090
		search_query.append("	COUNT(*) over () Total_Record,	");
		search_query.append("	a.encounter_id encounter_id, a.patient_id patient_id, m.patient_name patient_name, m.sex sex,	");
		search_query.append("	TO_CHAR (m.date_of_birth, 'DD/MM/YYYY') date_of_birth,	");
		
		search_query.append("	a.assign_care_locn_type assign_care_locn_type, a.assign_care_locn_code assign_care_locn_code,	");
		search_query.append("	i.short_desc short_desc, a.assign_room_num assign_room_num, a.assign_bed_num assign_bed_num,	");
		
		search_query.append("	a.patient_class patient_class, a.discharge_date_time discharge_date_time, a.adt_status adt_status,	");
		search_query.append("	(select 1 from ds_place_supplementary_order a where a.encounter_id = mealplan.encounter_id and a.serving_date >= TRUNC(SYSDATE) AND ROWNUM = 1) color_code,	");
		search_query.append("  get_age (m.date_of_birth) || ' / ' || DECODE (m.sex, 'M', 'Male', 'F', 'Female', 'Unknown') Patient_Age "); //Added Against PMG2017-CRF-0012[IN:066074]
		search_query.append("	FROM pr_encounter a,	");
		search_query.append("	mp_patient m,	");
		search_query.append("	mp_episode_type_vw v,	");
		search_query.append("	ip_nursing_unit_lang_vw i,	");
		search_query.append("	ds_place_supplementary_order mealplan	");
		search_query.append("	WHERE a.patient_class = v.patient_class	");
		search_query.append("	AND i.facility_id = a.facility_id	");
		search_query.append("	AND i.nursing_unit_code = a.assign_care_locn_code	");
		search_query.append("	AND i.language_id = ?	");
		search_query.append("	AND (   (a.discharge_date_time + ? / 24) >= SYSDATE	");
		search_query.append("	OR a.discharge_date_time IS NULL	");
		search_query.append("	)	");
		search_query.append("	AND a.adt_status <> '09'	");
		search_query.append("	AND a.patient_class IN ('IP', 'DC')	");
		search_query.append("	AND a.deceased_date_time IS NULL	");
		search_query.append("	AND a.facility_id = ?	");
		search_query.append("	AND a.patient_id = m.patient_id(+)	");
		search_query.append("	AND i.nursing_unit_code = REPLACE (?, '%', '')	");
		if(!EncounterId.equals("")){
			search_query.append("	and a.encounter_Id = NVL(?,a.encounter_id)	");
		}
		if(!PatientId.equals("")){
			search_query.append("	and a.patient_Id = NVL(?,a.patient_id)	");
		}
		if(!Gender.equals("")){
			search_query.append("	and m.sex =  NVL(?,m.sex)	");
		}
		if(!PractionerId.equals("")){
			search_query.append("	and nvl(a.attend_Practitioner_Id,'XX') = NVL(?,a.attend_Practitioner_Id)	");
		}
		if(!Admission_From_Date.equals("")){
			search_query.append("	and (trunc(a.visit_Adm_Date_Time) between to_date(nvl(replace(?||'%','%',''),'15/09/1947'),'dd/mm/yyyy')	");
		}else{
		search_query.append("	AND (TRUNC (a.visit_adm_date_time)	");
		search_query.append("	BETWEEN TO_DATE (NVL (REPLACE ('' || '%', '%', ''),	");
		search_query.append("	'15/09/1947'	");
		search_query.append("	),	");
		search_query.append("	'dd/mm/yyyy'	");
		search_query.append("	)	");
		}
		if(!Admission_To_Date.equals("")){
			search_query.append("	and to_date(nvl(replace(?||'%','%',''),'31/12/2999'),'dd/mm/yyyy'))	");
		}else{
		search_query.append("	AND TO_DATE (NVL (REPLACE ('' || '%', '%', ''),	");
		search_query.append("	'31/12/2999'	");
		search_query.append("	),	");
		search_query.append("	'dd/mm/yyyy'	");
		search_query.append("	)	");
		search_query.append("	)	");
		}
		search_query.append("	AND mealplan.encounter_id(+) = a.encounter_id	");
		if(Status.equals("O")){
			search_query.append("	AND mealplan.serving_date>=trunc(sysdate)	");
		}
		search_query.append("	GROUP BY a.visit_adm_date_time, a.encounter_id, a.patient_id, patient_name, sex, date_of_birth, assign_care_locn_type,	");
		search_query.append("	assign_care_locn_code, i.short_desc, assign_room_num, assign_bed_num, a.patient_class, discharge_date_time,mealplan.encounter_id, adt_status	");
		search_query.append("	ORDER BY visit_adm_date_time_sort  desc ) a 	");
		search_query.append("	where ROWNUM <= ? ) 	");//end num
		search_query.append("	where rnum  >= ? 	");//start num
		search_query.append("order by visit_adm_date_time_sort desc");//601090
		System.err.println("153,search_query------->"+search_query.toString());
		psmt=con.prepareStatement(search_query.toString());
		int index=0;
		psmt.setString(++index,Locale);
		psmt.setString(++index,Grace_Period);
		psmt.setString(++index,Facility_Id);
		psmt.setString(++index,Nursing_Unit_Code);
		if(!EncounterId.equals("")){
			psmt.setString(++index,EncounterId);
		}
		if(!PatientId.equals("")){
			psmt.setString(++index,PatientId);
		}
		if(!Gender.equals("")){
			psmt.setString(++index,Gender);
		}
		if(!PractionerId.equals("")){
			psmt.setString(++index,PractionerId);
		}
		if(!Admission_From_Date.equals("")){
			psmt.setString(++index,Admission_From_Date);
		}
		if(!Admission_To_Date.equals("")){
			psmt.setString(++index,Admission_To_Date);
		}
		psmt.setString(++index,End_Num);
		psmt.setString(++index,Start_Num);
		
		rs=psmt.executeQuery();
		while(rs.next()){
			//response=new SupplementaryPlaceOrderResponse();
			obj=new SupplementaryPlaceOrderResult();
			
			obj.setPatient_Id(rs.getString("Patient_Id"));
			obj.setPatient_Name(rs.getString("Patient_Name"));
			obj.setEncounter_Id(rs.getString("Encounter_Id"));
			obj.setVisit_Adm_Date(rs.getString("Visit_Adm_Date"));
			obj.setSex(rs.getString("Sex"));
			obj.setDOB(rs.getString("date_of_birth"));
			obj.setAssign_Care_Locn_Type(rs.getString("Assign_Care_Locn_Type"));
			obj.setAssign_Care_Locn_code(rs.getString("Assign_Care_Locn_code"));
			obj.setShort_Desc(rs.getString("Short_Desc"));
			obj.setAssign_Room_Num(rs.getString("Assign_Room_Num"));
			obj.setAssign_Bed_Num(rs.getString("Assign_Bed_Num"));
			obj.setPatient_Class(rs.getString("Patient_Class"));
			obj.setDischarge_Date_Time(rs.getString("Discharge_Date_Time"));
			obj.setADT_Status(rs.getString("ADT_Status"));
			obj.setTotal_Record(rs.getString("Total_Record"));
			obj.setColor_Code(rs.getString("Color_Code"));
			obj.setPatient_Age(rs.getString("Patient_Age")); //Added Against Start PMG2017-CRF-0012[IN:066074]
			Listobj.setList(obj);
			//SupplementaryPlaceList.add(PlaceList);
		}
		if(psmt!=null) psmt.close();	//Added Against Common-ICN-0031
		if(rs!=null) rs.close();	//Added Against Common-ICN-0031
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			
		}
		response.setResultList(Listobj);
		return response;		
	}

	//@Override
	public String insertSupplementaryMealOrder(PlaceSupplementaryMealOrderRequest request, Connection connection) {
		// TODO Auto-generated method stub
		String result="";
		Connection con = null;
		PreparedStatement psmt_insert=null,psmt_delete=null;
		//ResultSet rs=null;	//Common-ICN-0044
		try{
			con=connection;
			
			String encounter_Id=request.getEncounterId();
			//String patient_Id=request.getPatient_Id();	//Common-ICN-0044
			String locale=request.getLocale();
			String facility_Id=request.getFacility_Id();
			String date=request.getDate();
			date = com.ehis.util.DateUtils.convertDate(date,"DMYHM", locale, "en");
			String supplementaryMeal=request.getSupplementaryMeal();
			String str_client_ip_address,login_user;
			str_client_ip_address=request.getStr_client_ip_address();
			login_user=request.getLogin_user();
			
			System.out.println("insertSupplementaryMealOrder requestobj-->"+request);
			
			JSONObject supplementaryMealObj = new JSONObject(supplementaryMeal);
			
			
			System.out.println("supplementaryMealObj--->"+supplementaryMealObj);
			
			String Insert_Supplementary_Meal_Item="insert into DS_PLACE_SUPPLEMENTARY_ORDER(OPERATING_FACILITY_ID,ENCOUNTER_ID,SERVING_DATE,SUPPLEMENTARY_ORDER_FOR,ITEM_TYPE,ITEM_CODE,ITEM_QTY,MEAL_TYPE,INSTRUCTIONS,status,remarks,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			//String Insert_Supplementary_Meal_Item="insert into DS_PLACE_SUPPLEMENTARY_ORDER(OPERATING_FACILITY_ID,ENCOUNTER_ID,SERVING_DATE,SUPPLEMENTARY_ORDER_FOR,ITEM_TYPE,ITEM_CODE,ITEM_QTY,MEAL_TYPE,INSTRUCTIONS,status,remarks,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,irregular_flag_yn) values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)"; //825
			/* String Update_Supplementary_Meal_Item="";
			int update_index=0; */	//Common-ICN-0044
			int insert_index=0;
			
			psmt_insert=con.prepareStatement(Insert_Supplementary_Meal_Item);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String delete_current_and_future_item="delete from DS_PLACE_SUPPLEMENTARY_ORDER where SERVING_DATE>=trunc(sysdate) and encounter_id=? and OPERATING_FACILITY_ID=?	";
			
			psmt_delete=con.prepareStatement(delete_current_and_future_item);
			psmt_delete.setString(1,encounter_Id);
			psmt_delete.setString(2,facility_Id);
			
			int delete_result=psmt_delete.executeUpdate();
			
			if(delete_result!=0){
				con.commit();
			}
			
			for(Object key:supplementaryMealObj.keySet()){
				String keyStr = (String)key;
		        Object keyvalue = supplementaryMealObj.get(keyStr);
		        insert_index=0;	
		        //Print key and value
		        System.out.println("key: "+ keyStr + " value: " + keyvalue);
		        
		        JSONObject indivualMealObj=(JSONObject)keyvalue;
		        System.out.println("Item_Type_Code-->"+indivualMealObj.getString("Item_Type_Code"));
		        
		        //psmt_insert=con.prepareStatement(Insert_Supplementary_Meal_Item);
		        
		        psmt_insert.setString(++insert_index,facility_Id);
		        psmt_insert.setString(++insert_index,encounter_Id);
		        String fromdate=com.ehis.util.DateUtils.convertDate(indivualMealObj.getString("Date").toString(),"DMY",locale,"en");
		        
		        Date servDate = new Date(sdf.parse(fromdate).getTime());
								
		        psmt_insert.setDate(++insert_index,servDate);//
		        psmt_insert.setString(++insert_index,indivualMealObj.getString("SupplementaryOrderForCode"));
		        psmt_insert.setString(++insert_index,indivualMealObj.getString("Item_Type_Code"));
		        psmt_insert.setString(++insert_index,indivualMealObj.getString("Item_Code"));
		        psmt_insert.setString(++insert_index,indivualMealObj.getString("Qty"));
		        psmt_insert.setString(++insert_index,indivualMealObj.getString("Meal_Type_Code"));
		        psmt_insert.setString(++insert_index,indivualMealObj.getString("Instructions"));
		        
		        psmt_insert.setString(++insert_index,indivualMealObj.getString("Status"));
		        psmt_insert.setString(++insert_index,indivualMealObj.getString("remarks"));
		        
		        psmt_insert.setString(++insert_index,login_user);
		        psmt_insert.setString(++insert_index,str_client_ip_address);
		        psmt_insert.setString(++insert_index,facility_Id);
		        
		        
		        psmt_insert.setString(++insert_index,login_user);
		        psmt_insert.setString(++insert_index,str_client_ip_address);
		        psmt_insert.setString(++insert_index,facility_Id);	
/* 825 start
for(int i=0; i<mealTypesForDietType.length; i++){				
				if(irregular_meal_code.contains(mealTypesForDietType[i].trim())){
					System.err.println("2438,mealTypesForDietType[i]=="+mealTypesForDietType[i].trim());
					irregular_flag="Y";					
				}else{
					irregular_flag="N";					
				}
//	825 end */			
		        
		        psmt_insert.addBatch();
		        
			}
			int a[]=psmt_insert.executeBatch();
			System.out.println("isBatchUpdateSucess-->"+isBatchUpdateSucess(a));
			System.out.println("a-->"+a.length);
			System.out.println("a-->"+a.toString());
			con.commit();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
			if(psmt_insert!=null) psmt_insert.close();	//Added Against Common-ICN-0031
			if(psmt_delete!=null) psmt_delete.close();	//Added Against Common-ICN-0031	
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List<PlaceSupplementaryMealOrderResponse> getSupplementaryMealOrder(PlaceSupplementaryMealOrderRequest request,Connection connection){
		Connection con = null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try{
			con = connection;
			supplementaryOrderResponseList=new ArrayList<PlaceSupplementaryMealOrderResponse>();
			
			StringBuffer query=new StringBuffer();
			query.append("	SELECT DECODE (sup.supplementary_order_for,	");
			query.append("	'A', (select ATTENDENT_LABEL_NAME from ds_param_for_facility  where OPERATING_FACILITY_ID=?),	");
			query.append("	'P', 'Patient'	");
			query.append("	) AS supplementary_for_desc,	");
			query.append("	sup.supplementary_order_for AS supplementry_for_code,	");
			query.append("	to_char(sup.serving_date,'DD/MM/YYYY') serving_date,sup.serving_date serving_date_sort, sup.item_type item_type_code, item.short_desc item_type_desc,	");
			query.append("	item_code item_code, items.short_desc item_desc, sup.item_qty AS qty,nvl(sup.instructions,' ') instructions,	");
			query.append("	nvl(sup.meal_type,' ') meal_type, nvl(mealtype.short_desc,' ') mealtype_desc,nvl(sup.status,' ') status,nvl(sup.remarks,' ') remarks	");
			query.append("	FROM ds_place_supplementary_order sup,	");
			query.append("	ds_item_type_lang_vw item,	");
			query.append("	ds_items items,	");
			query.append("	ds_meal_type_lang_vw mealtype	");
			query.append("	WHERE sup.item_type = item.item_type	");
			query.append("	AND sup.item_code = items.food_item_code	");
			query.append("	AND sup.meal_type = mealtype.meal_type(+)	");
			query.append("	AND sup.item_type=items.item_type	");//newly added
			query.append("	AND item.language_id = ?	");//locale
			query.append("	AND items.language_id = ?	");//locale
			query.append("	AND NVL(mealtype.language_id,?) = ?	");//locale two
			query.append("	AND sup.encounter_id=?	");//encounter id
			query.append("	AND sup.operating_facility_id=?	");//Facility_id
			query.append("	AND sup.serving_date >=trunc(sysdate)	");
			query.append("	order by serving_date_sort desc, decode(supplementary_order_for,'P',1,'A',2) , item_type_desc, ITEM_DESC, MEAL_ORDER	");
			
			
			int index=0;
			
			psmt=con.prepareStatement(query.toString());
			String locale=request.getLocale();
			String encounter_id=request.getEncounterId();
			String facility_id=request.getFacility_Id();
			
			psmt.setString(++index, facility_id);
			psmt.setString(++index, locale);
			psmt.setString(++index, locale);
			psmt.setString(++index, locale);
			psmt.setString(++index, locale);
			
			psmt.setString(++index, encounter_id);
			psmt.setString(++index, facility_id);
			
			rs=psmt.executeQuery();
			int sno=0;
			while(rs.next()){
				PlaceSupplementaryMealOrderResponse obj=new PlaceSupplementaryMealOrderResponse();
				
				obj.setSupplementaryOrderForCode(rs.getString("supplementry_for_code"));
				obj.setSupplementaryOrderForDesc(rs.getString("supplementary_for_desc"));
				//obj.setDate(com.ehis.util.DateUtils.convertDate(rs.getString("serving_date"),"DMY", "en", locale));
				obj.setDate(rs.getString("serving_date"));
				obj.setMeal_Type_Code(rs.getString("meal_type"));
				obj.setMeal_Type_Desc(rs.getString("mealtype_desc"));
				System.out.println("Date-->"+rs.getString("serving_date"));
				//System.out.println("Date-->"+rs.getString("item_type"));
				obj.setItem_Type_Code(rs.getString("item_type_code"));
				obj.setItem_Type_Desc(rs.getString("item_type_desc"));
				
				obj.setItem_Code(rs.getString("item_code"));
				obj.setItem_Desc(rs.getString("item_desc"));
				
				obj.setQty(rs.getString("qty"));
				obj.setInstructions(rs.getString("instructions"));
				
				
				obj.setsno(Integer.toString(++sno));
				obj.setStatus(rs.getString("Status"));
				obj.setRemarks(rs.getString("remarks"));
								
				supplementaryOrderResponseList.add(obj);			
			
			}
				if(psmt!=null) psmt.close();	//Added Against Common-ICN-0031
			if(rs!=null) rs.close();	//Added Against Common-ICN-0031	
		}catch(Exception e){
			e.printStackTrace();
		}
		return supplementaryOrderResponseList;
	}
	public List<PlaceSupplementaryMealOrderResponse> getOldSupplementaryMealOrder(PlaceSupplementaryMealOrderRequest request,Connection connection){
		Connection con = null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try{
			con = connection;
			supplementaryOrderResponseList=new ArrayList<PlaceSupplementaryMealOrderResponse>();
			
			StringBuffer query=new StringBuffer();
			
			
			query.append("	SELECT DECODE (sup.supplementary_order_for,	");
			query.append("	'A', (select ATTENDENT_LABEL_NAME from ds_param_for_facility  where OPERATING_FACILITY_ID=?),	");
			query.append("	'P', 'Patient'	");
			query.append("	) AS supplementary_for_desc,	");
			query.append("	sup.supplementary_order_for AS supplementry_for_code,	");
			query.append("	to_char(sup.serving_date,'DD/MM/YYYY') serving_date,sup.serving_date serving_date_sort , sup.item_type item_type_code, item.short_desc item_type_desc,	");
			query.append("	item_code item_code, items.short_desc item_desc, sup.item_qty AS qty,nvl(sup.instructions,' ') instructions,	");
			//query.append("	sup.meal_type, mealtype.short_desc mealtype_desc	");
			query.append("	nvl(sup.meal_type,' ') meal_type, nvl(mealtype.short_desc,' ') mealtype_desc	");
			query.append("	FROM ds_place_supplementary_order sup,	");
			query.append("	ds_item_type_lang_vw item,	");
			query.append("	ds_items items,	");
			query.append("	ds_meal_type_lang_vw mealtype	");
			query.append("	WHERE sup.item_type = item.item_type	");
			query.append("	AND sup.item_code = items.food_item_code	");
			query.append("	AND sup.meal_type = mealtype.meal_type(+)	");
			query.append("	AND sup.item_type=items.item_type	");//Added For Duplicate Record Display
			query.append("	AND item.language_id = ?	");//locale
			query.append("	AND items.language_id = ?	");//locale
			query.append("	AND NVL(mealtype.language_id,?) = ?	");//locale two
			query.append("	AND sup.encounter_id=?	");//encounter id
			query.append("	AND sup.operating_facility_id=?	");//Facility_id
			//query.append("	AND sup.serving_date <trunc(sysdate)	");
			query.append("	order by serving_date_sort desc, decode(supplementary_order_for,'P',1,'A',2) , item_type_desc, ITEM_DESC, MEAL_ORDER	");
			
			
			int index=0;
			
			psmt=con.prepareStatement(query.toString());
			String locale=request.getLocale();
			String encounter_id=request.getEncounterId();
			String facility_id=request.getFacility_Id();
			
			psmt.setString(++index, facility_id);
			psmt.setString(++index, locale);
			psmt.setString(++index, locale);
			psmt.setString(++index, locale);
			psmt.setString(++index, locale);
			
			psmt.setString(++index, encounter_id);
			psmt.setString(++index, facility_id);
			
			rs=psmt.executeQuery();
			int sno=0;
			while(rs.next()){
				PlaceSupplementaryMealOrderResponse obj=new PlaceSupplementaryMealOrderResponse();
				
				obj.setSupplementaryOrderForCode(rs.getString("supplementry_for_code"));
				obj.setSupplementaryOrderForDesc(rs.getString("supplementary_for_desc"));
				//obj.setDate(com.ehis.util.DateUtils.convertDate(rs.getString("serving_date"),"DMY", "en", locale));
				obj.setDate(rs.getString("serving_date"));
				obj.setMeal_Type_Code(rs.getString("meal_type"));
				obj.setMeal_Type_Desc(rs.getString("mealtype_desc"));
				System.out.println("Date-->"+rs.getString("serving_date"));
				//System.out.println("Date-->"+rs.getString("item_type"));
				obj.setItem_Type_Code(rs.getString("item_type_code"));
				obj.setItem_Type_Desc(rs.getString("item_type_desc"));
				
				obj.setItem_Code(rs.getString("item_code"));
				obj.setItem_Desc(rs.getString("item_desc"));
				
				obj.setQty(rs.getString("qty"));
				obj.setInstructions(rs.getString("instructions"));
				
				obj.setStatus("O");
				obj.setsno(Integer.toString(++sno));
				
				
				supplementaryOrderResponseList.add(obj);
			}
			if(psmt!=null) psmt.close();	//Added Against Common-ICN-0031
			if(rs!=null) rs.close();	//Added Against Common-ICN-0031	
			
		}catch(Exception e){
			
		}
		return supplementaryOrderResponseList;
	}
	private int isBatchUpdateSucess(int[] status){
		int size = status.length;
		ArrayList list = new ArrayList();
		for(int k=size-1;k>=0;k--){
			list.add((status[k]!=-3)?"S":"E");
		}
		return (!list.contains("E"))?1:0;
	}
	
	//Get the result for process list page
	public SupplementaryPlaceOrderResponse getProcessSupplementaryOrderList(SupplementaryProcessRequest request,Connection connection){
		SupplementaryPlaceOrderResponse response =new SupplementaryPlaceOrderResponse();
		List<SupplementaryProcessResponse> processSupplementaryOrderResponseList=new ArrayList<SupplementaryProcessResponse>();
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		try{
			con=connection;
			
			String locale=request.getLocale();
			String facility_id=request.getFaciltyId();
			String date=request.getDate();
			String patient_id=request.getPatientId();
			String kitchen=request.getKitchen();
			String nursing_unit=request.getNursingUnit();
			String Supplementary_order_for=request.getSupplementaryOrderFor();
			String start_num=request.getStartNum();
			String end_num=request.getEndNum();
			String gracePeriod=request.getGracePeriod();
			StringBuffer process_sql=new StringBuffer();
			
			process_sql.append("	SELECT *	");
			process_sql.append("	FROM (SELECT ROWNUM rnum, a.*	");
			process_sql.append("	FROM (SELECT   DECODE	");
			process_sql.append("	(sup.supplementary_order_for,	");
			process_sql.append("	'A', (SELECT attendent_label_name	");
			process_sql.append("	FROM ds_param_for_facility	");
			process_sql.append("	WHERE operating_facility_id = ?),	");//facility_id
			process_sql.append("	'P', 'Patient'	");
			process_sql.append("	) AS supplementary_for_desc,	");
			process_sql.append("	sup.encounter_id encounter_id,	");
			process_sql.append("	sup.serving_date serving_date,	");
			process_sql.append("	sup.supplementary_order_for supplementary_order_for,	");
			process_sql.append("	sup.item_type item_type_code,	");
			process_sql.append("	sup.item_code item_code, sup.item_qty item_qty,sup.remarks,	");
			process_sql.append("	NVL (sup.meal_type, ' ') meal_type_code,	");
			process_sql.append("	NVL (sup.status, '') status,	");
			process_sql.append("	item.short_desc item_type_desc,	");
			process_sql.append("	items.short_desc item_short_desc,	");
			process_sql.append("	NVL (mealtype.short_desc, ' ') meal_short_desc,	");
			process_sql.append("	mp.patient_name patient_name,	");
			process_sql.append("	mp.patient_id patient_id,	");
			process_sql.append("	DECODE (sex, 'M', 'Male', 'F', 'Female','U','Unknow') sex,	");
			process_sql.append("	NVL (pr.assign_room_num, ' ') room_no,	");
			process_sql.append("	NVL (pr.assign_bed_num, ' ') bed_no,	");
			process_sql.append("	COUNT (*) OVER () total_record	");
			process_sql.append("	FROM ds_place_supplementary_order sup,	");
			process_sql.append("	ds_item_type_lang_vw item,	");
			process_sql.append("	ds_items items,	");
			process_sql.append("	ds_meal_type_lang_vw mealtype,	");
			process_sql.append("	pr_encounter pr,	");
			process_sql.append("	mp_patient mp,	");
			process_sql.append("	ip_nursing_unit_lang_vw i,	");
			process_sql.append("	ds_wards_for_kitchen kit	");//added
			process_sql.append("	WHERE sup.item_type = item.item_type	");
			process_sql.append("	AND item.language_id = ?	");//locale
			process_sql.append("	AND sup.item_code = items.food_item_code	");
			process_sql.append("	AND sup.meal_type = mealtype.meal_type(+)	");
			process_sql.append("	AND NVL (mealtype.language_id, ?) = ?	");//locale ,locale
			process_sql.append("	AND items.language_id = ?	");//locale
			process_sql.append("	AND sup.operating_facility_id = ?	");//facility_id
			process_sql.append("	AND sup.operating_facility_id = pr.facility_id	");
			process_sql.append("	AND sup.encounter_id = pr.encounter_id	");
			process_sql.append("	AND pr.patient_id = mp.patient_id	");
			process_sql.append("	AND (   (pr.discharge_date_time + ? / 24) >= SYSDATE	");//grace period value
			process_sql.append("	OR pr.discharge_date_time IS NULL	");
			process_sql.append("	)	");
			process_sql.append("	AND i.facility_id = pr.facility_id	");
			process_sql.append("	AND i.nursing_unit_code = pr.assign_care_locn_code	");
			process_sql.append("	AND kit.operating_facility_id = pr.facility_id");
			process_sql.append("	AND KIT.WARD_CODE=I.NURSING_UNIT_CODE	");
			process_sql.append("	AND i.language_id = ?	");//locale
			process_sql.append("	AND SUP.SERVING_DATE=?	");//serving date
			if(!nursing_unit.equals("")){
			process_sql.append("	AND i.nursing_unit_code = REPLACE (?, '%', '')	");//nursing unit
			}
			if(!kitchen.equals("")){
				process_sql.append("	and kit.KITCHEN_CODE=replace(?,'%','') ");//kitchen
			}
			if(!patient_id.equals("")){
				process_sql.append("	and mp.patient_id = NVL(?,mp.patient_id)	");//patient_id
			}
			if(!Supplementary_order_for.equals("B")){
				process_sql.append(" And sup.SUPPLEMENTARY_ORDER_FOR=?	");//Supplementary_order_for
			}
			process_sql.append("	ORDER BY patient_id DESC,	");
			process_sql.append("	DECODE (supplementary_order_for, 'P', 1, 'A', 2),	");
			process_sql.append("	item_type_desc,	");
			process_sql.append("	item_short_desc,	");
			process_sql.append("	meal_order) a	");
			process_sql.append("	WHERE ROWNUM <= ?)	");//end_num
			process_sql.append("	WHERE rnum >= ?	");//start_num
			
			psmt=con.prepareStatement(process_sql.toString());
			int index=0;
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String fromdate=com.ehis.util.DateUtils.convertDate(date,"DMY",locale,"en");
	        Date servDate = new Date(sdf.parse(fromdate).getTime());
			
			psmt.setString(++index,facility_id);
			psmt.setString(++index,locale);
			psmt.setString(++index,locale);
			psmt.setString(++index,locale);
			psmt.setString(++index,locale);
			psmt.setString(++index,facility_id);
			psmt.setString(++index,gracePeriod);
			psmt.setString(++index,locale);
			psmt.setDate(++index,servDate);
			if(!nursing_unit.equals("")){
				psmt.setString(++index,nursing_unit);
			}
			if(!kitchen.equals("")){
				psmt.setString(++index, kitchen);
			}
			if(!patient_id.equals("")){
				psmt.setString(++index, patient_id);
			}
			if(!Supplementary_order_for.equals("B")){
				psmt.setString(++index, Supplementary_order_for);
			}
			psmt.setString(++index,end_num);
			psmt.setString(++index,start_num);
			
			rs=psmt.executeQuery();
			
			while(rs.next()){
				SupplementaryProcessResponse response_obj=new SupplementaryProcessResponse();
				response_obj.setPatientId(rs.getString("patient_id"));
				response_obj.setPatientName(rs.getString("patient_name"));
				response_obj.setGender(rs.getString("sex"));
				response_obj.setRoomNo(rs.getString("room_no"));
				response_obj.setBedNo(rs.getString("bed_no"));
				
				response_obj.setSupplementaryOrderFor(rs.getString("supplementary_for_desc"));
				response_obj.setSupplementaryOrderForCode(rs.getString("supplementary_order_for"));
				
				response_obj.setItemType(rs.getString("item_type_desc"));
				response_obj.setItemTypeCode(rs.getString("item_type_code"));
				
				response_obj.setFoodItem(rs.getString("item_short_desc"));
				response_obj.setFoodItemCode(rs.getString("item_code"));
				
				response_obj.setItemQty(rs.getString("item_qty"));
				
				response_obj.setMealType(rs.getString("meal_short_desc"));
				response_obj.setMealTypeCode(rs.getString("meal_type_code"));
				
				response_obj.setStatus(rs.getString("status"));
				response_obj.setReamarks(rs.getString("remarks"));
				response_obj.setTotalRecord(rs.getString("total_record"));
				response_obj.setEncounter_Id(rs.getString("encounter_id"));
				processSupplementaryOrderResponseList.add(response_obj);
			}
			
			response.setProcessSearchList(processSupplementaryOrderResponseList);
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(psmt!=null) psmt.close();	//Added Against Common-ICN-0031
			if(rs!=null) rs.close();	//Added Against Common-ICN-0031	
			}catch(Exception e){
				
			}
		}
		return response;
	}
	public String updateSupplementaryMealOrder(SupplementaryProcessRequest request,Connection connection){
		try{
			
			Connection con=connection;
			PreparedStatement psmt_with_meal=null,psmt_without_meal=null;
			
			String facility_id=request.getFaciltyId();
			String locale=request.getLocale();
			String processMealArr=request.getProcessSupplementaryMealArray();
			String str_client_ip_address,login_user;
			
			str_client_ip_address=request.getStr_client_ip_address();
			login_user=request.getLogin_user();
						
			//JSONObject processObj=new JSONObject(processMealArr);
			JSONArray processMealArray=new JSONArray(processMealArr);
			
			System.out.println("process--->"+processMealArray);
			
			StringBuffer update_Process_With_Meal=new StringBuffer();
			StringBuffer update_Process_WithOut_Meal=new StringBuffer();
			
			update_Process_With_Meal.append("	update ds_place_supplementary_order	");
			update_Process_With_Meal.append("	set	");
			update_Process_With_Meal.append("	status=?,	");
			update_Process_With_Meal.append("	REMARKS=?,	");
			update_Process_With_Meal.append("	MODIFIED_BY_ID=?,	");
			update_Process_With_Meal.append("	MODIFIED_DATE=sysdate,	");
			update_Process_With_Meal.append("	MODIFIED_AT_WS_NO=?,	");
			update_Process_With_Meal.append("	MODIFIED_FACILITY_ID=?	");
			update_Process_With_Meal.append("	where	");
			update_Process_With_Meal.append("	SERVING_DATE=?	");
			update_Process_With_Meal.append("	AND SUPPLEMENTARY_ORDER_FOR=?	");
			update_Process_With_Meal.append("	AND ITEM_TYPE=?	");
			update_Process_With_Meal.append("	AND ITEM_CODE=?	");
			update_Process_With_Meal.append("	AND MEAL_TYPE=?	");
			update_Process_With_Meal.append("	AND ENCOUNTER_ID=?	");
			update_Process_With_Meal.append("	AND OPERATING_FACILITY_ID=?	");			
			
			update_Process_WithOut_Meal.append("	update ds_place_supplementary_order	");
			update_Process_WithOut_Meal.append("	set	");
			update_Process_WithOut_Meal.append("	status=?,	");
			update_Process_WithOut_Meal.append("	REMARKS=?,	");
			update_Process_WithOut_Meal.append("	MODIFIED_BY_ID=?,	");
			update_Process_WithOut_Meal.append("	MODIFIED_DATE=sysdate,	");
			update_Process_WithOut_Meal.append("	MODIFIED_AT_WS_NO=?,	");
			update_Process_WithOut_Meal.append("	MODIFIED_FACILITY_ID=?	");
			update_Process_WithOut_Meal.append("	where	");
			update_Process_WithOut_Meal.append("	SERVING_DATE=?	");
			update_Process_WithOut_Meal.append("	AND SUPPLEMENTARY_ORDER_FOR=?	");
			update_Process_WithOut_Meal.append("	AND ITEM_TYPE=?	");
			update_Process_WithOut_Meal.append("	AND ITEM_CODE=?	");
			update_Process_WithOut_Meal.append("	AND ENCOUNTER_ID=?	");
			update_Process_WithOut_Meal.append("	AND OPERATING_FACILITY_ID=?	");
			
			psmt_with_meal=con.prepareStatement(update_Process_With_Meal.toString());
			psmt_without_meal=con.prepareStatement(update_Process_WithOut_Meal.toString());
			
			int index=0;
			Boolean withmealflag=false,withoutmealflag=false;
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");						
			
			for(int i=0;i<processMealArray.length();i++){
				JSONObject child=processMealArray.getJSONObject(i);
				System.out.println("child--->"+child);
				index=0;
				if(!child.get("meal_type").equals("")){
					
					String fromdate=com.ehis.util.DateUtils.convertDate(child.getString("serving_date").toString(),"DMY",locale,"en");
					
			        Date servDate = new Date(sdf.parse(fromdate).getTime());
					
					psmt_with_meal.setString(++index,child.getString("Status"));
					psmt_with_meal.setString(++index,child.getString("Remark"));
					psmt_with_meal.setString(++index, login_user);
					psmt_with_meal.setString(++index, str_client_ip_address);
					psmt_with_meal.setString(++index, facility_id);
					psmt_with_meal.setDate(++index,servDate);//serving date
					psmt_with_meal.setString(++index,child.getString("Sup_ord"));
					psmt_with_meal.setString(++index,child.getString("item_type"));
					psmt_with_meal.setString(++index,child.getString("food_item"));
					psmt_with_meal.setString(++index,child.getString("meal_type"));
					psmt_with_meal.setString(++index,child.getString("Encounter_id"));
					psmt_with_meal.setString(++index,facility_id);
					withmealflag=true;
					psmt_with_meal.addBatch();				
				}else{
					String fromdate=com.ehis.util.DateUtils.convertDate(child.getString("serving_date").toString(),"DMY",locale,"en");
					
			        Date servDate = new Date(sdf.parse(fromdate).getTime());
					psmt_without_meal.setString(++index,child.getString("Status"));
					psmt_without_meal.setString(++index,child.getString("Remark"));
					psmt_without_meal.setString(++index, login_user);
					psmt_without_meal.setString(++index, str_client_ip_address);
					psmt_without_meal.setString(++index, facility_id);
					psmt_without_meal.setDate(++index,servDate);//serving date
					psmt_without_meal.setString(++index,child.getString("Sup_ord"));
					psmt_without_meal.setString(++index,child.getString("item_type"));
					psmt_without_meal.setString(++index,child.getString("food_item"));
					psmt_without_meal.setString(++index,child.getString("Encounter_id"));
					psmt_without_meal.setString(++index,facility_id);
					withoutmealflag=true;
					psmt_without_meal.addBatch();
				}
			}
				
				if(withmealflag){
					int a[]=psmt_with_meal.executeBatch();
				}
				if(withoutmealflag){
					int a[]=psmt_without_meal.executeBatch();
				}
				con.commit();
			if(psmt_with_meal!=null) psmt_with_meal.close();	//Added Against Common-ICN-0031
			if(psmt_without_meal!=null) psmt_without_meal.close();	//Added Against Common-ICN-0031	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		
		
		return "";
	}
}
