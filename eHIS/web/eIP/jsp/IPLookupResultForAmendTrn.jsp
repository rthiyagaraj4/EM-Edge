<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,java.net.*,com.ehis.util.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="ForSplChars.jsp" %>
<% 
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
String locale = (String)session.getAttribute("LOCALE");
%>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eIP/js/BlockBed.js' language='javascript'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>

function closeWin(enc,patid)
{
	showModalCurEnc(enc,patid);				
}

async function showModal(enc,patid,bkgref)
{
	if( document.forms[0].modal.value != 'yes')
	{ 
		var oper_stn_id=document.forms[0].oper_stn_id.value;
		var routine_tfr_yn=document.forms[0].routine_tfr_yn.value;
		var bed_block_period_max_int=document.forms[0].bed_block_period_max_int.value;
		var sydate=document.forms[0].sydate.value;
		var priority_applicable_yn=document.forms[0].priority_applicable_yn.value;
		var change_bed_class_yn=document.forms[0].change_bed_class_yn.value;
		var deactivate_pseudo_bed_yn=document.forms[0].deactivate_pseudo_bed_yn.value;
		var bl_interfaced_yn=document.forms[0].bl_interfaced_yn.value;
		var bed_block_period_max_type=document.forms[0].bed_block_period_max_type.value;
		var tot_count=document.forms[0].total_count.value;
		var jsp_name=document.forms[0].jsp_name.value;
		var function_id=document.forms[0].function_id.value;
		
		var win_height=document.forms[0].win_height.value;
		if(win_height == "") win_height="27";
		var dialogTop=document.forms[0].dialogTop.value;
		if(dialogTop == "") dialogTop="80";
		var win_width=document.forms[0].win_width.value;
		if(win_width == "") win_width="40";
		var module=document.forms[0].module.value;
		if(module == "") module="eIP";
		var model_window=document.forms[0].model_window.value;
		if( model_window == "") model_window ="";
		
		if( model_window == 'N')
		{
			parent.frames[3].document.location.href="../../"+module+"/jsp/"+jsp_name+"?encounterId="+enc+"&patientId="+patid+"&Practitioner_Id="+practid+"&callfrom=IP&function_id="+function_id;
		}
		else
		{	var retVal = 	new String();
			var dialogHeight= "1000px" ;
			var dialogWidth	= "1200px" ;
			var dialogTop = "30px";
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;				
			retVal = await top.window.showModalDialog("../../"+module+"/jsp/"+jsp_name+"?encounterId="+enc+"&patientId="+patid+"&booking_ref_no="+bkgref+"&oper_stn_id="+oper_stn_id+"&routine_tfr_yn="+routine_tfr_yn+"&bed_block_period_max_int="+bed_block_period_max_int+"&sydate="+sydate+"&priority_applicable_yn="+priority_applicable_yn+"&change_bed_class_yn="+change_bed_class_yn+"&deactivate_pseudo_bed_yn="+deactivate_pseudo_bed_yn+"&bl_interfaced_yn="+bl_interfaced_yn+"&bed_block_period_max_type="+bed_block_period_max_type+"&function_id="+function_id,arguments,features);
			
			if(tot_count >= 1)
			{
				parent.frames[2].document.location.reload();
			}
			else
			{
				parent.frames[2].document.location.href="../../eCommon/html/blank.html";
			}
		}
	}
	else
	{
		window.parent.returnValue=enc;
		window.parent.close();
	}
}
			
async function showModalCurEnc(enc,patid)
{
	var jsp_name="CurrentEncounterMain.jsp";
	//var win_height=document.forms[0].win_height.value;
	
	 win_height="400px";
	//var win_width=document.forms[0].win_width.value;
	 win_width="900px";
	var retVal = 	new String();
	var dialogHeight= win_height ;
	var dialogWidth	= win_width ;
	var dialogTop = "80" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;				
	retVal = await window.showModalDialog("../../eIP/jsp/"+jsp_name+"?encounterId="+enc+"&patientId="+patid,arguments,features);
	parent.frames[2].document.location.reload();				
}

</script>
<%
	Connection con		= null;
	Statement stmt		= null;
	ResultSet rs		= null;
	String colspan		= "12";

try
{
	con = ConnectionManager.getConnection(request);
	String facility_id				= (String)session.getValue("facility_id");
	String login_user				= (String)session.getValue("login_user");
	String oper_stn_id				= checkForNull(request.getParameter("oper_stn_id"));
	String routine_tfr_yn			= checkForNull(request.getParameter("routine_tfr_yn"),"N");
	String bed_block_period_max_str	= checkForNull(request.getParameter("bed_block_period_max_int"));
	String sydate					= checkForNull(request.getParameter("sydate"));
	String priotity_status			= checkForNull(request.getParameter("priority_applicable_yn"),"N");
	String bed_class_allowed		= checkForNull(request.getParameter("change_bed_class_yn"),"N");
	String deactivate_pseudo_bed_yn	= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
	String bl_interfaced_yn			= checkForNull(request.getParameter("bl_interfaced_yn"),"N");
	String bed_block_period_max_type= checkForNull(request.getParameter("bed_block_period_max_type"));
	String loc_lang					= checkForNull(request.getParameter("loc_lang"));
	int bed_block_period_max_int	= 0;
	String adm_date_display			= "";
	if(! bed_block_period_max_str.equals(""))
		bed_block_period_max_int	= Integer.parseInt(bed_block_period_max_str);

	StringBuffer finalSql				= new StringBuffer();
	StringBuffer where_criteria			= new StringBuffer();
	String admission_date_time			= "";
	String spcl_prev_val				= "";
	String pract_prev_val				= "";
	String priority_desc				= "";
	String soundex_function				= "";	
	String sql							= "";
	String patient_name					= "";
	String fr_nursing_unit_short_desc	= "";
	String specialty_short_desc			= "";
	String practitioner_name			= "";
	String prev_val						= "";
	String prev_val2					= "";
	String booking_ref_no				= "";
	String priority						= "";
	String gender						= ""; 
	String room_no						= ""; 
	String bed_class_short_desc			= ""; 
	String bed_type_short_desc			= ""; 
	String bed_no						= "";

	String to_nursing_unit_short_desc	= "";
	String to_practitioner_name			= "";
	String to_specialty_short_desc		= "";
	String to_subservice_short_desc		= "";
	String to_bed_no					= "";
	String to_room_no					= "";
	String to_bed_class_short_desc		= "";
	String to_bed_type_short_desc		= "";
	String current_location_desc		= "";

	String class_val		= "QRYEVENSMALL";
	String class_value		= "QRYEVENSMALL";
    
	Boolean isCurrentLocDtlsAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","CURNT_LOC_DTLS_APPL");//Added by Shanmukh on 25th-JULY-2018 for ML-MMOH-CRF-1113

	String whereClause		= request.getParameter("whereclause");
	String from				= checkForNull(request.getParameter("from"));
	String to				= checkForNull(request.getParameter("to"));
	String soundex_type		= checkForNull(request.getParameter("soundex"));
	String from_nursing_unit= request.getParameter("from_nursing_unit");
	String nursing_unit_code= request.getParameter("nursing_unit");
	String from_Splcode		= request.getParameter("from_Splcode");	
	String speciality_code	= request.getParameter("Splcode");	
	String encounter_id		= request.getParameter("encounter_id");
	String from_practid		= request.getParameter("from_practid");
	String practitioner_id	= request.getParameter("practid");
	String patient_id		= request.getParameter("patient_id");
	String sex				= checkForNull(request.getParameter("gender"));
	String name_prefix		= checkForNull(request.getParameter("name_prefix"));
	String name_suffix		= checkForNull(request.getParameter("name_suffix"));
	if(name_prefix!=null && !name_prefix.equals(""))
	name_prefix				= singleToDoubleQuotes(name_prefix);
   
	if(name_suffix!=null && !name_suffix.equals(""))
	name_suffix				= singleToDoubleQuotes(name_suffix);
	String first_name		= checkForNull(request.getParameter("first_name"));
	String second_name		= checkForNull(request.getParameter("second_name"));
	String third_name		= checkForNull(request.getParameter("third_name"));
	String family_name		= checkForNull(request.getParameter("family_name"));
	String werecondn		= checkForNull(request.getParameter("wherecondn"));
	String to_nursing_unit	= checkForNull(request.getParameter("to_nursing_unit"));
	String transfer_type	= checkForNull(request.getParameter("transfer_type"));
	String jsp_name			= checkForNull(request.getParameter("jsp_name"));
	String win_height		= checkForNull(request.getParameter("win_height"));
	String dialogTop		= checkForNull(request.getParameter("dialogTop"));
	String win_width		= checkForNull(request.getParameter("win_width"));
	String call_function	= checkForNull(request.getParameter("param"));
	String modal			= checkForNull(request.getParameter("modal"));
	String module			= checkForNull(request.getParameter("module"));
	String model_window		= checkForNull(request.getParameter("model_window"));
	String function_id		= checkForNull(request.getParameter("function_id"));
	String prog_id			= checkForNull(request.getParameter("prog_id"));
	String p_practitioner_id= checkForNull(request.getParameter("practitioner_id"));
	String call_func		= checkForNull(request.getParameter("call_function"));
	String p_oper_stn_id	= checkForNull(request.getParameter("operStation"));
	String from_date			=	checkForNull(request.getParameter("from_date"));
	String to_date				=	checkForNull(request.getParameter("to_date"));

	if(!(from_date==null || from_date.equals("")))
		from_date = DateUtils.convertDate(from_date,"DMY",locale,"en");

	if(!(to_date==null || to_date.equals("")))
		to_date = DateUtils.convertDate(to_date,"DMY",locale,"en");


%>
</head>							
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name='iplookupqueryresult' id='iplookupqueryresult'>
	<%


		if(whereClause==null)
		{
			if(!soundex_type.equals(""))
			{
				if(soundex_type.equals("E"))
					soundex_function = "ethnic_soundex";
				else
					soundex_function = "soundex";
			}
			
			if(where_criteria.length() > 0) where_criteria.delete(0,where_criteria.length());
			where_criteria.append(" where a.facility_id='"+facility_id+"'");


			if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
			{
				if(function_id.equals("CANCEL_TRANS_BOOKING"))
				{
					//where_criteria.append(" and B.NURSING_UNIT_CODE='"+nursing_unit_code+"' ");
					where_criteria.append(" and REQ_NURSING_UNIT_CODE='"+nursing_unit_code+"' ");
				}
				else
				{
					where_criteria.append(" and REQ_NURSING_UNIT_CODE='"+nursing_unit_code+"' ");
				}
			}
			//to nursing_unit_code
			if(to_nursing_unit!=null && !to_nursing_unit.equals(""))
				where_criteria.append(" and nursing_unit_code='"+to_nursing_unit+"' ");

			if(from_date!=null && !from_date.equals(""))
			{
				where_criteria.append(" and trunc(admission_date_time) >= to_date('");
				where_criteria.append(from_date);
				where_criteria.append("' , 'dd/mm/rrrr') ");
			}	
			if(to_date!=null && !to_date.equals(""))
			{
				where_criteria.append(" and trunc(admission_date_time) <= to_date('");
				where_criteria.append(to_date);
				where_criteria.append("' , 'dd/mm/rrrr') ");
			}

			//speciality_code
			if(speciality_code!=null && !speciality_code.equals(""))
			{
				if(function_id.equals("CANCEL_TRANS_BOOKING"))
				{
					//where_criteria.append(" and SPECIALTY_CODE='"+speciality_code+"' ");
					where_criteria.append(" and REQ_SPECIALTY_CODE='"+speciality_code+"' ");
				}
				else
				{
					where_criteria.append(" and REQ_SPECIALTY_CODE='"+speciality_code+"' ");				
				}
			}

			if(from_nursing_unit != null && !from_nursing_unit.equals(""))
			{
				where_criteria.append(" and B.NURSING_UNIT_CODE = '"+from_nursing_unit+"' ");				
			}

			if(from_Splcode != null && !from_Splcode.equals(""))
			{
				where_criteria.append(" and SPECIALTY_CODE = '"+from_Splcode+"' ");				
			}

			//practitioner_id
			if(practitioner_id!=null && !practitioner_id.equals(""))
			{
				if(function_id.equals("CANCEL_TRANS_BOOKING"))
				{
					where_criteria.append(" and REQ_PRACTITIONER_ID='"+practitioner_id+"' ");				
				}
				else
				{
					where_criteria.append(" and REQ_PRACTITIONER_ID='"+practitioner_id+"' ");				
				}
			}


			if(from_practid != null && !from_practid.equals(""))
			{
				where_criteria.append(" and ATTEND_PRACTITIONER_ID = '"+from_practid+"' ");				
			}

			//patient_id
			if(patient_id!=null && !patient_id.equals(""))
				where_criteria.append(" and a.patient_id like '"+patient_id+"%' ");
			//encounter_id
			if(encounter_id != null && !encounter_id.equals(""))
			where_criteria.append(" and a.encounter_id like '"+encounter_id+"%' ");
			//transfer_type
			if(transfer_type != null && !transfer_type.equals(""))
				where_criteria.append(" and a.TFR_REQ_REASON='"+transfer_type+"' ");
			//gender
			if(sex!=null && !sex.equals(""))
				where_criteria.append(" and sex = '"+sex+"' ");
			//name_prefix
			
			if(name_prefix!=null && !name_prefix.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append(" and name_prefix='"+name_prefix+"' ");
				else
					where_criteria.append(" and NAME_PREFIX_LOC_LANG='"+name_prefix+"' ");
			}
			//name_suffix
			if(name_suffix!=null && !name_suffix.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append(" and name_suffix='"+name_suffix+"' ");
				else
					where_criteria.append(" and NAME_SUFFIX_LOC_LANG='"+name_suffix+"' ");
			}
			//first_name
			if(first_name!=null && !first_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append(" and upper  "+soundex_function+"(first_name) like upper "+soundex_function+"('"+first_name+"')  || '%' ");
				else
					where_criteria.append(" and upper  "+soundex_function+"(FIRST_NAME_LOC_LANG) like upper "+soundex_function+"('"+first_name+"')  || '%' ");
			}
			//second_name
			if(second_name!=null && !second_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append(" and upper  "+soundex_function+"(second_name) like upper "+soundex_function+"('"+second_name+"') || '%' ");
				else
					where_criteria.append(" and upper "+soundex_function+"(SECOND_NAME_LOC_LANG) like upper "+soundex_function+"('"+second_name+"')  || '%' ");
			}
			//third_name
			if(third_name!=null && !third_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append(" and upper  "+soundex_function+"(third_name) like upper "+soundex_function+"('"+third_name+"')  || '%' ");
				else
					where_criteria.append(" and upper "+soundex_function+"(THIRD_NAME_LOC_LANG) like upper "+soundex_function+"('"+third_name+"') || '%' ");
			}
			//family_name
			if(family_name!=null && !family_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append(" and upper  "+soundex_function+"(family_name) like upper "+soundex_function+"('"+family_name+"')  || '%' ");
				else
					where_criteria.append(" and upper "+soundex_function+"(FAMILY_NAME_LOC_LANG) like upper "+soundex_function+"('"+family_name+"')  || '%' ");
			}


			if( p_practitioner_id!=null && !p_practitioner_id.equals(""))
			{
				where_criteria.append(" and (practitioner_id ='"+ p_practitioner_id +"'  ");
				where_criteria.append(" or encounter_id in ");
				where_criteria.append("(select encounter_id  ");
				where_criteria.append("  from pr_encounter_pract ");
				where_criteria.append(" where operating_facility_Id= '"+ facility_id +"'  ");
				where_criteria.append(" and practitioner_id= '"+ p_practitioner_id +"' )) ");
			}
		} 
		else
		{
			where_criteria.append(whereClause) ;
		}
		int start		= 0 ;
		int end			= 0 ;
		int maxRecord	= 0;
		int i=1;
		if (from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;
		if (to.equals(""))
			end = 12 ;
		else
		end = Integer.parseInt( to ) ;

		// This new query is added for Confirm Book Bed for Patient Transfer where in based on the priority the records should be displayed.
		/*String strFrm = "";
		if(function_id.equals("CONFIRM_TRANS_BOOKING"))
			strFrm = " a.req_nursing_unit_code in";
		else
			strFrm="B.NURSING_UNIT_CODE in";

		sql  = " select count(*) from IP_TRANSFER_REQUEST a, IP_OPEN_ENCOUNTER b, MP_PATIENT c ";

		StringBuffer nurSql = new StringBuffer();
		nurSql.append(strFrm);
		nurSql.append(" (select a.nursing_unit_code from ip_nursing_unit a,AM_OS_USER_LOCN_ACCESS_VW b where a.facility_id = '"+facility_id+"' and a.facility_id =b.facility_id and a.nursing_unit_code = b.locn_code and a.eff_status='E' and b.locn_type = 'N' and b.oper_stn_id='"+p_oper_stn_id+"' and b.appl_user_id = '"+login_user+"' and b."+werecondn+" = 'Y') ");
		nurSql.append(" and ip_leave_status is null ");

		if(finalSql.length() > 0) finalSql.delete(0,finalSql.length());
		finalSql.append(sql);
		finalSql.append(where_criteria.toString());

		if(bed_class_allowed.equals("Y"))
		{
			finalSql.append(" AND a.TFR_REQ_STATUS = '0' AND BED_CLASS_REQ_STATUS='1' and (PRIORITY_EXP_DATE is null or PRIORITY_EXP_DATE >= sysdate) and ");
			finalSql.append(nurSql.toString());
		}
		else
		{	
			finalSql.append(" AND a.tfr_req_status = '0' and (PRIORITY_EXP_DATE is null or PRIORITY_EXP_DATE >= sysdate) and ");
			finalSql.append(nurSql.toString());
		}

		finalSql.append(" and a.facility_id = b.facility_id and a.encounter_id = b.encounter_id and b.patient_id = c.patient_id  ");

		
		String sql_count  = finalSql.toString();
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql_count);
		rs.next();
		int maxRecord=0;
		maxRecord = rs.getInt(1);
		if(rs!=null)		rs.close();
		if(stmt!=null)		stmt.close();

		if(maxRecord == 0)
		{	
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
			return;
		}
		*/
		String  strFrm = "";
		if(function_id.equals("CONFIRM_TRANS_BOOKING"))
			strFrm = " a.req_nursing_unit_code in ";
		else
			strFrm=" b.nursing_unit_code in";

		StringBuffer nurSql = new StringBuffer();

		if(nurSql.length() > 0) nurSql.delete(0,nurSql.length());
		nurSql.append(strFrm);
		nurSql.append(" (select a.nursing_unit_code from IP_NURSING_UNIT a, AM_OS_USER_LOCN_ACCESS_VW b where a.facility_id = '"+facility_id+"' and a.facility_id =b.facility_id and a.nursing_unit_code = b.locn_code and a.eff_status='E' and b.oper_stn_id='"+p_oper_stn_id+"' and b.locn_type = 'N' and b.appl_user_id = '"+login_user+"' and b."+werecondn+"= 'Y')");


		nurSql.append(" and ip_leave_status is null ");

		sql = " select DECODE (B.PAT_CURR_LOCN_TYPE, 'N', IP_GET_DESC.IP_NURSING_UNIT (B.FACILITY_ID, B.PAT_CURR_LOCN_CODE, '"+locale+"', 2 ), 'R', B.PAT_CURR_LOCN_CODE, OP_GET_DESC.OP_CLINIC (B.FACILITY_ID, B.PAT_CURR_LOCN_CODE, '"+locale+"', 1) ) CURRENT_LOCATION_DESC , A.REQ_BED_NO TO_BED_NO , A.REQ_ROOM_NO TO_ROOM_NO , IP_GET_DESC.IP_BED_CLASS(A.REQ_BED_CLASS_CODE,'"+locale+"', '2') TO_BED_CLASS_SHORT_DESC , IP_GET_DESC.IP_BED_TYPE(A.REQ_BED_TYPE_CODE,'"+locale+"', '2') TO_BED_TYPE_SHORT_DESC , IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID, A.REQ_NURSING_UNIT_CODE,'"+locale+"','2') TO_NURSING_UNIT_SHORT_DESC , AM_GET_DESC.AM_PRACTITIONER(A.REQ_PRACTITIONER_ID,'"+locale+"','1') TO_PRACTITIONER_NAME , AM_GET_DESC.AM_SPECIALITY(A.REQ_SPECIALTY_CODE,'"+locale+"','2') TO_SPECIALTY_SHORT_DESC , AM_GET_DESC.AM_SUBSERVICE(A.REQ_SERVICE_CODE, A.REQ_SUBSERVICE_CODE,'"+locale+"','2') TO_SUBSERVICE_SHORT_DESC , to_char(B.ADMISSION_DATE_TIME, 'dd/mm/rrrr hh24:mi') ADMISSION_DATE_TIME , C.SEX GENDER , B.ROOM_NUM FROM_ROOM_NO , IP_GET_DESC.IP_BED_CLASS(B.BED_CLASS_CODE,'"+locale+"', '2') FROM_BED_CLASS_SHORT_DESC , IP_GET_DESC.IP_BED_TYPE(B.BED_TYPE_CODE,'"+locale+"', '2') FROM_BED_TYPE_SHORT_DESC , B.BED_NUM FROM_BED_NO , A.ENCOUNTER_ID , A.PATIENT_ID , decode('"+locale+"','en',c.patient_name, nvl(c.patient_name_loc_lang, c.patient_name))PATIENT_NAME , AM_GET_DESC.AM_SPECIALITY(a.REQ_SPECIALTY_CODE,'"+locale+"','2') SPECIALTY_SHORT_DESC , AM_GET_DESC.AM_PRACTITIONER(B.ATTEND_PRACTITIONER_ID,'"+locale+"','1') PRACTITIONER_NAME , B.NURSING_UNIT_CODE NURSING_UNIT_CODE , IP_GET_DESC.IP_NURSING_UNIT(B.FACILITY_ID, B.NURSING_UNIT_CODE,'"+locale+"', '2') NURSING_UNIT_SHORT_DESC , A.TFR_REQ_REF_NO , A.PRIORITY_CODE , IP_GET_DESC.IP_TRANSFER_PRIORITY(A.FACILITY_ID, A.PRIORITY_CODE,'"+locale+"', '2') PRIORITY_SHORT_DESC,(SELECT color_code_scheme FROM ip_transfer_priority WHERE facility_id = a.facility_id AND priority_code = a.priority_code) color_scheme from IP_TRANSFER_REQUEST A , IP_OPEN_ENCOUNTER B , MP_PATIENT C ";

		if(finalSql.length() > 0) finalSql.delete(0,finalSql.length());
		finalSql.append(sql);
		finalSql.append(where_criteria.toString());

		if(bed_class_allowed.equals("Y"))
		{
			finalSql.append(" and a.tfr_req_status='0' and bed_class_req_status='1' and (priority_exp_date is null or priority_exp_date >= sysdate) and ");
			finalSql.append(nurSql.toString());
		}
		else
		{
			finalSql.append(" and a.tfr_req_status='0' and (priority_exp_date is null or priority_exp_date >= sysdate) and ");
			finalSql.append(nurSql.toString());
		}

		finalSql.append(" and a.facility_id = b.facility_id and a.encounter_id = b.encounter_id and b.patient_id = c.patient_id  ");

		if(priotity_status.equals("Y")){
			  finalSql.append(" order by 9");
		}else{
			  finalSql.append(" order by 4,5");
		}
		
		stmt		= con.createStatement();
		rs			= stmt.executeQuery(finalSql.toString());
		if ( start != 1 )
			for( int j=1; j<start; i++,j++ ){
				rs.next() ;
			} 
		while(rs!=null &&  i<=end && rs.next()){
		if(maxRecord==0)
		{

		//if (( !(start <= 1) ) || ( !( (start+12) > maxRecord ) ))
		//{
			out.println("<p><table align='right'><tr>");
			if ( !(start <= 1) )
				out.println("<td align='right' id='prev'><A HREF='../jsp/IPLookupResultForAmendTrn.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&param="+call_function+"&from="+(start-12)+"&to="+(end-12)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&operStation="+p_oper_stn_id+"&wherecondn="+werecondn+"&function_id="+function_id+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

			//if ( !( (start+12) > maxRecord ) )
				out.println("<td align='right' id='next' style='visibility:hidden'><A HREF='../jsp/IPLookupResultForAmendTrn.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&param="+call_function+"&from="+(start+12)+"&to="+(end+12)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&wherecondn="+werecondn+"&operStation="+p_oper_stn_id+"&function_id="+function_id+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
			out.println("</tr></table></p>");
			out.println("<br><br>");				
		//}

			out.println(" <table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>");
			out.println("<tr>");
			out.println("<th colspan = 6>&nbsp;</th>");
			if(isCurrentLocDtlsAppl){ //Added by Shanmukh on 25th-JULY-2018 for ML-MMOH-CRF-1113
			out.println("<th colspan = 5>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.current.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDetails.label","common_labels")+"</th>");
			out.println("<th colspan = 3>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.To.label","bl_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDetails.label","common_labels")+"</th>");
			}else{
			out.println("<th colspan = 5>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.FromDetails.label","ip_labels")+"</th>");
			out.println("<th colspan = 3>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ToDetails.label","ip_labels")+"</th>");
			out.println("<th colspan = 2>&nbsp;</th>");}//END
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>&nbsp;</th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AdmissionDateTime.label","common_labels")+"&nbsp;"+"</th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels")+"&nbsp;"+" </th>");
			if(!isCurrentLocDtlsAppl){ //Added by shanmukh on 25th-JULY-2018 for ML-MMOH-CRF-1113
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.currentlocation.label","common_labels")+"&nbsp;"+" </th>");}

		if(priotity_status.equals("Y"))
		{
			out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+"&nbsp;"+" </th>");
			colspan = "16";
		}
		else
		{
			colspan = "15";
		}
		out.println("</tr>");
		}

			//if(rs!=null)
			//{
				/*if ( start != 1 )
				for( int j=1; j<start; i++,j++ )
				{
					rs.next() ;
				} */
				//while(rs!=null && rs.next() && i<=end)
				//{

					if(class_value.equals("QRYEVENSMALL"))
						class_value = "QRYODDSMALL";
					else
						class_value = "QRYEVENSMALL";

					specialty_short_desc=rs.getString("specialty_short_desc");
					if(specialty_short_desc == null) specialty_short_desc="&nbsp;";
					
					admission_date_time=rs.getString("admission_date_time");
					if(admission_date_time == null) admission_date_time="&nbsp;";
					
					if(!admission_date_time.equals("&nbsp;"))
						adm_date_display=DateUtils.convertDate(admission_date_time,"DMYHM","en",locale); 
					
					
					encounter_id=rs.getString("encounter_id");
					if(encounter_id == null) encounter_id="";

					patient_id = rs.getString("patient_id");
					if( patient_id == null) patient_id="";
					
					patient_name=rs.getString("patient_name");
					if(patient_name == null) patient_name="&nbsp;";
					
					fr_nursing_unit_short_desc=rs.getString("nursing_unit_short_desc");
					if(fr_nursing_unit_short_desc== null) fr_nursing_unit_short_desc="&nbsp;";

					gender = rs.getString("gender");
					if(gender== null) 
						gender="&nbsp;";
					else if (gender.equals("M"))
						gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					else if (gender.equals("F"))
						gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					else 
						gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

					room_no=rs.getString("from_room_no");
					if(room_no== null) room_no="&nbsp;";

					to_nursing_unit_short_desc	= checkForNull(rs.getString("to_nursing_unit_short_desc"),"&nbsp;");
					to_practitioner_name		= checkForNull(rs.getString("to_practitioner_name"),"&nbsp;");
					to_specialty_short_desc		= checkForNull(rs.getString("to_specialty_short_desc"),"&nbsp;");
					to_subservice_short_desc	= checkForNull(rs.getString("to_subservice_short_desc"),"&nbsp;");
					to_bed_no					= checkForNull(rs.getString("to_bed_no"),"&nbsp;");
					to_room_no					= checkForNull(rs.getString("to_room_no"),"&nbsp;");
					to_bed_class_short_desc		= checkForNull(rs.getString("to_bed_class_short_desc"),"&nbsp;");
					to_bed_type_short_desc		= checkForNull(rs.getString("to_bed_type_short_desc"),"&nbsp;");

					current_location_desc		= checkForNull(rs.getString("current_location_desc"),"&nbsp;");
										
					bed_class_short_desc=rs.getString("from_bed_class_short_desc");
					if(bed_class_short_desc== null) bed_class_short_desc="&nbsp;";
					
					bed_type_short_desc=rs.getString("from_bed_type_short_desc");
					if(bed_type_short_desc== null) bed_type_short_desc="&nbsp;";
					
					bed_no=rs.getString("from_bed_no");
					if(bed_no== null) bed_no="&nbsp;";

				
					booking_ref_no = rs.getString("TFR_REQ_REF_NO");
				
					practitioner_name=rs.getString("practitioner_name");
					if(practitioner_name == null) practitioner_name="";
				
					priority = 	 rs.getString("PRIORITY_CODE");
					 priority_desc = rs.getString("PRIORITY_SHORT_DESC");
					if(priority_desc == null) priority_desc="&nbsp";

					String color_scheme="";
					color_scheme = rs.getString("color_scheme")==null?"":rs.getString("color_scheme");
					
					if(priority == null) 
						class_val ="&nbsp";				
					 else 
						class_val =color_scheme;
					
					
						
					 
					out.println("<tr>");

					if( ! (jsp_name.equals("") && modal.equals("") ) )
					{

						if(!spcl_prev_val.equals(specialty_short_desc) || !pract_prev_val.equals(practitioner_name) )
						{
							String disp_value = specialty_short_desc;
							if (!practitioner_name.equals(""))
								disp_value = disp_value+"/"+practitioner_name;

							out.println("<td class='CAGROUPHEADING' colspan='"+colspan+"' align='left'>"+disp_value+"</td></tr><tr>");
						}
						
						out.println("<td STYLE='background-color:"+class_val+"' nowrap><a href=\"javascript:closeWin('"+encounter_id+"','"+patient_id+"')\">+</a></td>");

						out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+adm_date_display+"</td>");

						if( call_function.equals("assign_bed"))
						{
						   if	(bed_no.equals("&nbsp;"))
							out.println("<td class='"+class_value+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','IPval','"+booking_ref_no+"')\">"+encounter_id+"</a></td>");
						   else
							out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+encounter_id+"</td>");
						}
						else
						{
							 out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+booking_ref_no+"')\">"+encounter_id+"</a></td>");
						}
					}
					else
					{
						if(!prev_val.equals(fr_nursing_unit_short_desc) || !prev_val2.equals(to_nursing_unit_short_desc) )
						{
							out.println("<td class='CAGROUPHEADING' STYLE='background-color:"+class_val+"' colspan='"+colspan+"' align='left'><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitFrom.label","ip_labels")+" "+fr_nursing_unit_short_desc+" To "+to_nursing_unit_short_desc+"</font></td></tr><tr>");
						}
						out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap><a href=\"javascript:closeWin('"+encounter_id+"','"+patient_id+"')\">+</a></td>");
						out.println("<td class='"+class_value+"' nowrap>"+encounter_id+"</td>");
					}

					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+patient_id+"</td>");
					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+patient_name+"</td>");
					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+gender+"</td>");
					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+fr_nursing_unit_short_desc+"</td>");
					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+bed_class_short_desc+"</td>");
					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+bed_type_short_desc+"</td>");
					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+bed_no+"</td>");
				
					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+room_no+"</td>");
					
					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+to_nursing_unit_short_desc+"</td>");

					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+to_bed_class_short_desc+"</td>");

					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+to_bed_type_short_desc+"</td>");
                    if(!isCurrentLocDtlsAppl){ //Added by shanmukh on 25th-JULY-2018 for ML-MMOH-CRF-1113
					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+current_location_desc+"</td>");
					}
				if(priotity_status.equals("Y"))
					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+priority_desc+"</td>");

					out.println("</tr>");
					
					spcl_prev_val  = specialty_short_desc;
					pract_prev_val = practitioner_name;

					prev_val=fr_nursing_unit_short_desc;
					prev_val2=to_nursing_unit_short_desc;
					i++;
					maxRecord++;
				}

				if(maxRecord<12 || (!rs.next()))
				{%>
					<script >
						if (document.getElementById('next'))
							document.getElementById('next').style.visibility='hidden';
					</script>
				<%}
				else
				{%>
					<script >
						if (document.getElementById('next'))
							document.getElementById('next').style.visibility='visible';
					</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



				<%}

				if(maxRecord==0)
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");

		
				if(rs!=null)		rs.close();
				if(stmt!=null)		stmt.close();
			//}
		out.println("</table>");

	%>
		<input type='hidden' name='total_count' id='total_count' value="<%=(i-1)%>" >
		<input type='hidden' name='jsp_name' id='jsp_name' value='<%=jsp_name%>' >
		<input type='hidden' name='win_height' id='win_height' value='<%=win_height%>' >
		<input type='hidden' name='win_width' id='win_width' value='<%=win_width%>' >
		<input type='hidden' name='dialogTop' id='dialogTop' value='<%=dialogTop%>' >
		<input type='hidden' name='modal' id='modal' value='<%=modal%>' >
		<input type='hidden' name='module' id='module' value='<%=module%>' >
		<input type='hidden' name='model_window' id='model_window' value='<%=model_window%>' >
		<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>' >
		<input type='hidden' name='call_function' id='call_function' value='<%=call_func%>' >
		<input type='hidden' name='prog_id' id='prog_id' value='<%=prog_id%>' >
		<input type='hidden' name='practitioner_id' id='practitioner_id' value='<%=p_practitioner_id%>' >
		<!-- // Added by Sridhar R on Mar 11 2005.. for passing parameters to frame page...-->
		<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
		<input type='hidden' name='routine_tfr_yn' id='routine_tfr_yn' value='<%=routine_tfr_yn%>'>
		<input type='hidden' name='bed_block_period_max_int' id='bed_block_period_max_int' value='<%=bed_block_period_max_int%>'>
		<input type='hidden' name='sydate' id='sydate' value='<%=sydate%>'>
		<input type='hidden' name='priority_applicable_yn' id='priority_applicable_yn' value='<%=priotity_status%>'>
		<input type='hidden' name='change_bed_class_yn' id='change_bed_class_yn' value='<%=bed_class_allowed%>'>
		<input type='hidden' name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' value='<%=deactivate_pseudo_bed_yn%>'>
		<input type='hidden' name='bl_interfaced_yn' id='bl_interfaced_yn' value='<%=bl_interfaced_yn%>'>
		<input type='hidden' name='bed_block_period_max_type' id='bed_block_period_max_type' value='<%=bed_block_period_max_type%>'>
		<input type='hidden' name='sStyle' id='sStyle' value='<%=sStyle%>'>

	</form>	
<%	
	}catch(Exception e)
	{
		out.println(e); e.printStackTrace();
	} 
	finally
	{
		try
		{
			if(stmt != null) stmt.close();	
			if(rs != null) rs.close();
		}
		catch(Exception e)
		{
			out.println("Exception in tryCatch : "+ e.toString());
			e.printStackTrace();
		}
		
		ConnectionManager.returnConnection(con,request);
		out.print("<script>if(parent.frames[1].document.forms[0] != null)");	out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
	}
	%>
</html>


<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>

