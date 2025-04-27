
<%@ page import ="java.sql.*,java.util.*,java.net.*,webbeans.eCommon.*,eDS.Common.JSONObject,eDS.Common.JSONArray,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
// This file added by dharma against KDAH-CRF-0104.. this file retruns a json array...
	request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	conn=ConnectionManager.getConnection(request);

try{
	String locale					= (String)session.getAttribute("LOCALE");
	String facility_id				= (String) session.getValue( "facility_id" ) ;
	String login_user				= (String)session.getAttribute("login_user");
	String action					= request.getParameter("action")==null?"":request.getParameter("action");
	Statement stmt					= null;
	ResultSet rs					= null;
	JSONObject json 				= new JSONObject();
	if(action.equals("initiate_pre_discharge")){
		String nursing_unit			= (request.getParameter("nursing_unit")==null || request.getParameter("nursing_unit").equals(""))?"":request.getParameter("nursing_unit");
		String dis_date_from		= (request.getParameter("dis_date_from")==null || request.getParameter("dis_date_from").equals(""))?"":request.getParameter("dis_date_from");
		String dis_date_to			= (request.getParameter("dis_date_to")==null || request.getParameter("dis_date_to").equals(""))?"":request.getParameter("dis_date_to");                                                                                                                                                                                                                                                                                               
		String Splcode				= (request.getParameter("Splcode")==null || request.getParameter("Splcode").equals(""))?"":request.getParameter("Splcode");                                                                                                                                                                                                                                                                                               
		String practid				= (request.getParameter("practid")==null || request.getParameter("practid").equals(""))?"":request.getParameter("practid");                                                                                                                                                                                                                                                                                               
		String patient_id			= (request.getParameter("patient_id")==null || request.getParameter("patient_id").equals(""))?"":request.getParameter("patient_id");                                                                                                                                                                                                                                                                                               
		String encounter_id			= (request.getParameter("encounter_id")==null || request.getParameter("encounter_id").equals(""))?"":request.getParameter("encounter_id");
		String oper_stn_id			= (request.getParameter("oper_stn_id")==null || request.getParameter("oper_stn_id").equals(""))?"":request.getParameter("oper_stn_id");
		StringBuffer where_criteria = new StringBuffer();
		int rowcnt					= 0;
		String recordslist			= "";
		
		//Display Fields Start//
		String res_admission_date_time			= "";
		String res_encounter_id					= "";
		String classValue						= "";
		String res_specialty_short_desc			= "";
		String res_header_spec_pract			= "";
		String practitioner_name				= "";
		String res_patient_id					= "";	
		String res_patient_name					= "";
		String res_gender						= "";
		String res_nursing_unit_short_desc		= "";
		String res_bed_class_short_desc			= "";
		String res_bed_type_short_desc  		= "";
		String res_bed_no						= "";
		String res_room_no						= "";
		String res_location_desc				= "";
		String res_pre_dis_initiate_yn			= "";
		//Display Fields End//
		
		 //Added for this CRF GHL-CRF-0468 
		 ArrayList encounterArrList=new ArrayList();
		 session.removeAttribute("encounterList");
		 //End GHL-CRF-0468 
		
		String  sql = "select a.pre_dis_initiate_yn,a.room_num room_no, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc, ip_get_desc.ip_bed_type(a.bed_type_code,'"+locale+"',2)bed_type_short_desc, to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, b.sex gender, am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc, a.nursing_unit_code, am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_short_name, a.encounter_id, a.patient_id, to_char(b.date_of_birth, 'dd/mm/rrrr hh24:mi') date_of_birth, get_age(b.date_of_birth) age , decode('"+locale+"','"+locale+"',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc, a.bed_num bed_no, a.blocked_bed_no, a.attend_practitioner_id practitioner_id, a.oth_adt_status, a.ip_leave_status, a.leave_expiry_date_time, decode(sign(( a.leave_expiry_date_time - sysdate)),-1,'Y','N') leave_flag, DECODE (a.pat_curr_locn_type, 'N', ip_get_desc.ip_nursing_unit (a.facility_id, a.pat_curr_locn_code, '"+locale+"', 2 ), 'R', a.pat_curr_locn_code, op_get_desc.op_clinic (a.facility_id, a.pat_curr_locn_code, '"+locale+"', 1)) location_desc, a.patient_class,b.pat_dtls_unknown_yn,b.pat_ser_grp_code,c.contact1_name,c.contact2_name,(select Or_patient_Order_Pend(a.patient_id,a.facility_id,a.encounter_id,'A') from dual) pend_ord_stats from IP_OPEN_ENCOUNTER a, MP_PATIENT b, MP_PAT_REL_CONTACTS c   where a.facility_id='"+facility_id+"'  and exists (Select locn_code from AM_OS_USER_LOCN_ACCESS_VW b where b.facility_id = a.facility_id and b.locn_code = a.nursing_unit_code and b.locn_type = 'N' and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+login_user+"'  and b.DISCHARGE_ADVICE_YN='Y' ) and (leave_expiry_date_time < sysdate or leave_expiry_date_time is null) AND (a.oth_adt_status != 7 or a.oth_adt_status is null)   AND a.patient_id = b.patient_id AND b.patient_id=c.patient_id ";
		if(!nursing_unit.equals("")){
			where_criteria.append(" and a.nursing_unit_code='"+nursing_unit+"'");
		}
		if(!dis_date_from.equals("")){
			where_criteria.append(" and trunc(admission_date_time) >= to_date('");
			where_criteria.append(dis_date_from);
			where_criteria.append("' , 'dd/mm/rrrr') ");
		}
		if(!dis_date_to.equals("")){
			where_criteria.append(" and trunc(admission_date_time) <= to_date('");
			where_criteria.append(dis_date_to);
			where_criteria.append("' , 'dd/mm/rrrr') ");
		}
		if(!Splcode.equals("")){
			where_criteria.append(" and specialty_code='"+Splcode+"'");
		}
		if(!practid.equals("")){
			where_criteria.append(" and attend_practitioner_id='"+practid+"'");
		}
		if(!patient_id.equals("")){
			where_criteria.append(" and a.patient_id like '%"+patient_id+"%'");
		}
		if(!encounter_id.equals("")){
			where_criteria.append(" and a.encounter_id='"+encounter_id+"'");
		}
		String order_by = " order by specialty_short_desc, practitioner_short_name, admission_date_time, to_date(admission_date_time, 'DD/MM/RRRR HH24:MI') ";
		sql	= sql  + where_criteria.toString()+order_by;		
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql.toString());
		JSONArray JsonlistArr = new JSONArray();
		while(rs.next()){
	 		JSONObject jsonobj = new JSONObject();
						
	 		res_admission_date_time=rs.getString("admission_date_time");
			if(res_admission_date_time == null) res_admission_date_time="&nbsp;";
			if(!res_admission_date_time.equals("&nbsp;")){
				jsonobj.put("admission_date_time",DateUtils.convertDate(res_admission_date_time,"DMYHM","en",locale));
			}else{
				jsonobj.put("admission_date_time",res_admission_date_time);
			}
			
			res_encounter_id=rs.getString("encounter_id");
			if(res_encounter_id == null) res_encounter_id="";
			jsonobj.put("encounter_id",res_encounter_id);
			
			res_specialty_short_desc=rs.getString("specialty_short_desc");
			if(res_specialty_short_desc == null) res_specialty_short_desc="&nbsp;";
			res_header_spec_pract	= res_specialty_short_desc;
			practitioner_name=rs.getString("practitioner_short_name");
			if((practitioner_name == null) || (practitioner_name.equals(""))) 	practitioner_name="";
			if (!practitioner_name.equals(""))
				res_header_spec_pract = res_header_spec_pract+"/"+practitioner_name;
			jsonobj.put("res_header_spec_pract",res_header_spec_pract);
			
			res_patient_id = rs.getString("patient_id");
			if( res_patient_id == null) res_patient_id="";
			jsonobj.put("patient_id",res_patient_id);
			
			res_patient_name=rs.getString("patient_name");
			if ((res_patient_name == null) || (res_patient_name.equals(""))) 
				res_patient_name="";
			jsonobj.put("patient_name",res_patient_name);
			
			res_gender =rs.getString("gender");
			if(res_gender == null )
				res_gender="";
			else if (res_gender.equals("M"))
				res_gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else if (res_gender.equals("F"))
				res_gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			else 
				res_gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			jsonobj.put("gender",res_gender);
			
			res_nursing_unit_short_desc=rs.getString("nursing_unit_short_desc");
			if(res_nursing_unit_short_desc== null) res_nursing_unit_short_desc="&nbsp;";
			jsonobj.put("nursing_unit_short_desc",res_nursing_unit_short_desc);
			
			res_bed_class_short_desc = rs.getString("bed_class_short_desc");
			if( res_bed_class_short_desc == null) res_bed_class_short_desc="&nbsp;";
			jsonobj.put("bed_class_short_desc",res_bed_class_short_desc);

			
			res_bed_type_short_desc = rs.getString("bed_type_short_desc");
			if( res_bed_type_short_desc == null) res_bed_type_short_desc="&nbsp;";
			jsonobj.put("bed_type_short_desc",res_bed_type_short_desc);
			
			res_bed_no = rs.getString("bed_no");
			if(res_bed_no == null) res_bed_no="&nbsp;";
			jsonobj.put("bed_no",res_bed_no);
			
			res_room_no = rs.getString("room_no");
			if( res_room_no == null) res_room_no="&nbsp;";
			jsonobj.put("room_no",res_room_no);
			
			res_location_desc = rs.getString("location_desc");
			if(res_location_desc == null) res_location_desc = "&nbsp;";
			jsonobj.put("location_desc",res_location_desc);
			
			res_pre_dis_initiate_yn	= rs.getString("pre_dis_initiate_yn");
			if(res_pre_dis_initiate_yn == null) res_pre_dis_initiate_yn = "N";
			jsonobj.put("pre_dis_initiate_yn",res_pre_dis_initiate_yn);
			
			//Added for this CRF GHL-CRF-0468
			if(res_pre_dis_initiate_yn.equals("Y")){
			   encounterArrList.add(res_encounter_id); 
			}
			//End this CRF GHL-CRF-0468
			
			if(rowcnt%2==0)
	 			classValue="QRYODDSMALL";
			else
				classValue="QRYEVENSMALL";
			jsonobj.put("classValue",classValue);
			JsonlistArr.put(jsonobj);
			rowcnt++;
		}
		if(rowcnt>0){
			recordslist = JsonlistArr.toString();	
		}
		if(stmt != null) stmt.close();
		if(rs  != null) rs.close();
		json.put("recordslist", recordslist);
		json.put("rowcnt", rowcnt);
		out.print(json);
		
		//Added for this CRF GHL-CRF-0468
		   			
		session.setAttribute("encounterList",encounterArrList);		
	    //End this CRF GHL-CRF-0468
		
	}
}catch(Exception e) { 
	e.printStackTrace();
	
}finally{ 
	if(conn != null) {
		ConnectionManager.returnConnection(conn,request);
	}	
}                           
%>          
            
            
