<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facilityId	=(String) session.getValue("facility_id");
	String locale = (String)session.getAttribute("LOCALE");
	String locn_type=request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
	String care_locn_ind=request.getParameter("care_locn_ind")==null?"":request.getParameter("care_locn_ind");
	String speciality_code=request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");	
	String clinic_code=request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");	
	String clinic_desc=request.getParameter("clinic_desc")==null?"":request.getParameter("clinic_desc");	
	clinic_desc=clinic_desc.replaceAll("'","''");// included for the SCF ML-BRU-SCF-0253 33367
	String start_ends_contains=request.getParameter("start_ends_contains")==null?"":request.getParameter("start_ends_contains");	
	String whereClause = request.getParameter("whereclause")==null?"":request.getParameter("whereclause");
	String search_click = request.getParameter("search_click")==null?"N":request.getParameter("search_click");
	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String tab_Selected = request.getParameter("tab_Selected")==null?"":request.getParameter("tab_Selected");
	String oper_stn_id = request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
	String order_catalog_code=request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");
	String order_by=request.getParameter("order_by")==null?"":request.getParameter("order_by");
	String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");
	String displayAll=request.getParameter("displayAll")==null?"N":request.getParameter("displayAll");
	
	if(rd_appt_yn.equals(""))rd_appt_yn="N";
	
%>	

<html>
    <head>
        <title></title>
<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
        <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language='javascript' src='../../eOA/js/OALocationlookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	Connection con=null;
	PreparedStatement pstmt=null;
	//Statement s=null;
	ResultSet rs=null;
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
	String loginuser 	= (String) session.getValue( "login_user" ) ;
	StringBuffer sql_sb=new StringBuffer();
	String code="";
	String desc="";
	String open_to_all_pract_yn="";
	String retval="";
	String sql="";
	String ident_at_checkin="";
	String care_loc_ind="";
	if(care_locn_ind.equals("Y")){
		care_loc_ind="D";
	}else{
		care_loc_ind=care_locn_ind;
	}

	if(locn_type.equals("D"))
	locn_type="Y";

	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

		

	if(function_id.equals("WAIT_LIST")){
	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql_sb.append("AND a.facility_id='"+facilityId+"' AND language_id='"+locale+"' AND  clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_locn_ind+"'  and a.clinic_type=b.LOCN_TYPE ");
		if(!speciality_code.equals("")){
			sql_sb.append(" AND A.SPECIALITY_CODE='"+speciality_code+"' ");
			}
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}

	if(locn_type.equals("N")){
		sql="Select a.long_desc long_desc, a.NURSING_UNIT_CODE clinic_code from IP_Nursing_unit_lang_vw a , am_locn_for_oper_stn b,ip_nurs_unit_for_specialty c  where B.locn_type = 'N' and a.facility_id='"+facilityId+"' and a.facility_id = b.facility_id and a.NURSING_UNIT_CODE=b.locn_code and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate)))  AND A.EFF_STATUS = 'E' and c.SPECIALTY_CODE='"+speciality_code+"' and a.language_id='"+locale+"' and c.NURSING_UNIT_CODE=a.NURSING_UNIT_CODE and c.facility_id='"+facilityId+"' and a.facility_id=c.Facility_id ";//query modified for 33672

	}else{
		sql="Select a.long_desc long_desc, a.alcn_criteria alcn_criteria,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type,a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn,ident_at_checkin,fi_visit_type_appl_yn,to_char(WORKING_DAY_START_TIME,'HH24:mi') STime,to_char(WORKING_DAY_END_TIME,'HH24:mi') ETime, to_char(BASE_SLOT_SLAB_TIME,'HH24:mi') dur from op_clinic_lang_vw a , am_locn_for_oper_stn b  where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.eff_status='E' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' and a.language_id='"+locale+"' "+whereClause+"  ";

	}
	}else if(function_id.equals("WAIT_LIST_MODIFY")){
	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql_sb.append("AND a.facility_id='"+facilityId+"' AND language_id='"+locale+"' AND  clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_locn_ind+"'  and a.clinic_type=b.LOCN_TYPE ");
		if(!speciality_code.equals("")){
			sql_sb.append(" AND A.SPECIALITY_CODE='"+speciality_code+"' ");
			}
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}

	if(locn_type.equals("N")){
	sql="Select a.long_desc long_desc, a.NURSING_UNIT_CODE clinic_code from IP_Nursing_unit_lang_vw a , AM_OS_USER_LOCN_ACCESS_VW b, ip_nurs_unit_for_specialty c  where B.locn_type = 'N' and a.facility_id = b.facility_id and a.NURSING_UNIT_CODE=b.locn_code and b.oper_stn_id='"+oper_stn_id+"'  AND A.EFF_STATUS = 'E'  and a.facility_id='"+facilityId+"' and c.SPECIALTY_CODE='"+speciality_code+"' and language_id = '"+locale+"' and c.NURSING_UNIT_CODE=a.NURSING_UNIT_CODE and c.facility_id='"+facilityId+"' AND b.appl_user_id='"+loginuser+"' AND b.MODIFY_WAIT_LIST_YN='Y' ";
	}else{
	sql="Select a.long_desc long_desc, a.clinic_code clinic_code, a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn from op_clinic_lang_vw a , AM_OS_USER_LOCN_ACCESS_VW b  where  a.facility_id=b.facility_id and b.oper_stn_id='"+oper_stn_id+"'  AND a.clinic_code=b.locn_code AND b.appl_user_id='"+loginuser+"' AND b.MODIFY_WAIT_LIST_YN='Y' "+whereClause+" and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id='"+oper_stn_id+"' and a.rd_appl_yn = '"+rd_appt_yn+"' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' and a.clinic_type=b.locn_type ";
	}

	}else if(function_id.equals("QRY_APPT_PAT")|| function_id.equals("QRY_BLK_APPT")){
	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql_sb.append("AND a.facility_id='"+facilityId+"' AND language_id='"+locale+"' AND  clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_locn_ind+"' ");
		if(!speciality_code.equals("")){
			sql_sb.append(" AND A.SPECIALITY_CODE='"+speciality_code+"' ");
			}
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="SELECT clinic_code clinic_code,a.long_desc long_desc,open_to_all_pract_yn,primary_resource_class FROM  op_clinic_lang_vw a WHERE level_of_care_ind = 'A' AND a.eff_status='E' "+whereClause+"  ";//query modified for 33238

	}else if(function_id.equals("CLINICS_FOR_DAY") || function_id.equals("GRP_APPT_DOCT") || function_id.equals("QRY_APPT_DOCT") || function_id.equals("QRY_SCH")){
	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql_sb.append("AND a.facility_id='"+facilityId+"' AND language_id='"+locale+"' AND  clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_locn_ind+"' ");
		if(!speciality_code.equals("")){
			sql_sb.append(" AND A.SPECIALITY_CODE='"+speciality_code+"' ");
			}
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="SELECT clinic_code clinic_code,a.long_desc long_desc,open_to_all_pract_yn,primary_resource_class FROM  op_clinic_lang_vw a WHERE level_of_care_ind = 'A' AND a.eff_status='E' "+whereClause+"  ";//query modified for 33238
	}else if(function_id.equals("TRANSFER_CANCEL_APPT")){
		sql_sb.append(" AND a.clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_loc_ind+"' ");
		
			if(displayAll.equals("N")){
				sql_sb.append(" and a.rd_appl_yn = '"+rd_appt_yn+"' ");
			}

	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
			if(!order_catalog_code.equals("")){
				sql_sb.append(" AND ( c.order_catalog_code='"+order_catalog_code+"' OR EXISTS (SELECT 1 FROM OR_ORDER_SET_COMPONENT WHERE  ORDER_SET_CODE=c.ORDER_CATALOG_CODE AND ORDER_CATALOG_CODE='"+order_catalog_code+"' ) )");
			}
		whereClause=new String(sql_sb.toString());
	}
	
	
	if(!order_catalog_code.equals("")){
		//sql="select a.long_desc long_desc,a.clinic_code clinic_code,open_to_all_pract_yn open_to_all_pract_yn  from op_clinic_lang_vw a,am_os_user_locn_access_vw b,op_catalog_for_clinic c where a.level_of_care_ind = 'A' and a.facility_id='"+facilityId+"' and a.eff_status = 'E' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and  b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.appl_user_id='"+loginuser+"' and a.language_id='"+locale+"' and (b.tfr_appt_yn='Y' or b.canc_appt_yn='Y') and a.clinic_type=b.locn_type and a.facility_id=c.facility_id and a.clinic_code=c.clinic_code " +whereClause+"  ";
        /*Below Line Added and Above Line Commented for this SCF ML-BRU-SCF-0240 [IN:033238]*/		
		sql="select a.long_desc long_desc,a.clinic_code clinic_code,open_to_all_pract_yn open_to_all_pract_yn,a.PRIMARY_RESOURCE_CLASS PRIMARY_RESOURCE_CLASS  from op_clinic_lang_vw a,am_os_user_locn_access_vw b,op_catalog_for_clinic c where a.level_of_care_ind = 'A' and a.facility_id='"+facilityId+"' and a.eff_status = 'E' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and  b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.appl_user_id='"+loginuser+"' and a.language_id='"+locale+"' and (b.tfr_appt_yn='Y' or b.canc_appt_yn='Y') and a.clinic_type=b.locn_type and a.facility_id=c.facility_id and  a.clinic_code=c.clinic_code " +whereClause+"  ";

	}else{
		//sql="select a.long_desc long_desc,a.clinic_code clinic_code,open_to_all_pract_yn open_to_all_pract_yn  from op_clinic_lang_vw a,am_os_user_locn_access_vw b where a.level_of_care_ind = 'A' and a.facility_id='"+facilityId+"' and a.eff_status = 'E' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and  b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.appl_user_id='"+loginuser+"' and a.language_id='"+locale+"' and (b.tfr_appt_yn='Y' or b.canc_appt_yn='Y') and a.clinic_type=b.locn_type " +whereClause+"  ";
		/*Below Line Added and Above Line Commented for this SCF ML-BRU-SCF-0240 [IN:033238]*/		
		sql="select a.long_desc long_desc,a.clinic_code clinic_code,open_to_all_pract_yn open_to_all_pract_yn,a.PRIMARY_RESOURCE_CLASS PRIMARY_RESOURCE_CLASS  from op_clinic_lang_vw a,am_os_user_locn_access_vw b where a.level_of_care_ind = 'A' and a.facility_id='"+facilityId+"' and a.eff_status = 'E' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and  b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.appl_user_id='"+loginuser+"' and a.language_id='"+locale+"' and (b.tfr_appt_yn='Y' or b.canc_appt_yn='Y')  and a.clinic_type=b.locn_type " +whereClause+"  ";
	}

	}else if(function_id.equals("SetUpDailySchedule")){

		sql_sb.append(" AND a.clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_loc_ind+"' ");
	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="Select care_locn_type_ind,a.long_desc long_desc, a.alcn_criteria alcn_criteria,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type,a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn,ident_at_checkin,fi_visit_type_appl_yn,to_char(WORKING_DAY_START_TIME,'HH24:mi') STime,to_char(WORKING_DAY_END_TIME,'HH24:mi') ETime, to_char(BASE_SLOT_SLAB_TIME,'HH24:mi') dur,a.PRIMARY_RESOURCE_CLASS,a.rd_appl_yn from op_clinic_lang_vw a , am_locn_for_oper_stn b  where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.eff_status='E' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' "+whereClause+" and b.locn_type=a.clinic_type ";


	}else if(function_id.equals("GEN_SCH")){
		sql_sb.append(" AND clinic_type='"+locn_type+"' AND CARE_LOCN_TYPE_IND='"+care_loc_ind+"' ");
	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="Select a.long_desc long_desc, a.alcn_criteria alcn_criteria,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type,a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn,ident_at_checkin,fi_visit_type_appl_yn from op_clinic_lang_vw a , am_locn_for_oper_stn b  where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.language_id='"+locale+"'"+whereClause+"  and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id  AND b. appl_user_id ='"+loginuser+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.eff_status='E' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' and a.clinic_type=b.locn_type ";


	}else if(function_id.equals("BLK_APPT_SLOTS")){

		sql_sb.append(" AND a.clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_loc_ind+"' ");
	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="Select a.long_desc long_desc,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type,a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn,ident_at_checkin  from op_clinic_lang_vw a, am_locn_for_oper_stn b  where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code  and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.eff_status='E' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' "+whereClause+" and a.clinic_type=b.locn_type ";


	}else if(function_id.equals("TRAN_SCH")){

		sql_sb.append(" AND a.clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_loc_ind+"' ");
	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="select a.long_desc long_desc, a.clinic_code clinic_code, open_to_all_pract_yn,a.clinic_type locn_type from op_clinic_lang_vw a, am_care_locn_type b ,am_locn_for_oper_stn c where a.facility_id='"+facilityId+"' and c.OPER_STN_ID =(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and a.language_id='"+locale+"' and a.allow_appt_yn='Y' and a.eff_status='E' and a.level_of_care_ind = 'A' and a.clinic_type = b.locn_type and c.locn_code=a.clinic_code"+whereClause+" and b.locn_type=a.clinic_type and b.locn_type=c.locn_type and a.facility_id=c.facility_id ";//condition modified for 33672



	}else if(function_id.equals("BLK_LIFT_CANC_SCH")||function_id.equals("PURG_SCH_REC")){
		sql_sb.append(" AND a.clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_loc_ind+"' ");
	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="select a.long_desc long_desc, a.clinic_code clinic_code, open_to_all_pract_yn, a.ident_at_checkin,a.clinic_type locn_type,a.primary_resource_class  from op_clinic_lang_vw   a, am_care_locn_type b ,am_locn_for_oper_stn c where c.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"'  AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and c.locn_code=a.clinic_code and a.language_id='"+locale+"' and a.facility_id='"+facilityId+"' and a.facility_id=c.facility_id and allow_appt_yn='Y' and a.eff_status='E' and a.level_of_care_ind = 'A' and a.clinic_type=b.locn_type and  B.LOCN_TYPE=C.LOCN_TYPE"+whereClause+" ";//condition modified for 33672



	}else if(function_id.equals("PRACT_DUTY_ROSTER")){
		sql_sb.append(" AND a.clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_loc_ind+"' ");
	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="Select a.long_desc long_desc, a.alcn_criteria alcn_criteria,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type,a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn,ident_at_checkin,fi_visit_type_appl_yn,to_char(WORKING_DAY_START_TIME,'HH24:mi') STime,to_char(WORKING_DAY_END_TIME,'HH24:mi') ETime, to_char(BASE_SLOT_SLAB_TIME,'HH24:mi') dur from op_clinic_lang_vw a , am_locn_for_oper_stn b  where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.language_id='"+locale+"' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.eff_status='E' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' and a.clinic_type=b.locn_type "+whereClause+"  ";


	}else if(function_id.equals("CHG_PRACT_SCH")){

		sql_sb.append(" AND a.clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_loc_ind+"' ");
	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="select a.long_desc long_desc,a.clinic_code clinic_code,a.clinic_type clinic_type, a.open_to_all_pract_yn open_to_all_pract_yn  from OP_CLINIC_lang_vw a,am_locn_for_oper_stn b where a.facility_id='"+ facilityId + "' and a.allow_appt_yn='Y' and b.OPER_STN_ID =(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id  AND b. appl_user_id ='"+loginuser+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and a.level_of_care_ind = 'A' and a.eff_status='E' and a.language_id='"+locale+"' and  a.facility_id=b.facility_id and a.clinic_code = b.locn_code and a.clinic_type=b.locn_type "+whereClause+"  ";//condition modified for 33672



	}else if(function_id.equals("HOLIDAY")){
		if(tab_Selected.equals("Location")){

		sql_sb.append(" AND a.clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_loc_ind+"' ");
	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	if(clinic_code.equals("") && clinic_desc.equals("")){
		//below Query is modified for SS-SCF-0788 by Kamatchi S on 02-SEP-2020
		sql="SELECT care_locn_type_ind,long_desc,clinic_code,clinic_type FROM (Select a.care_locn_type_ind care_locn_type_ind,a.long_desc long_desc,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type from op_clinic_lang_vw a WHERE a.clinic_code  IN (SELECT locn_code FROM oa_holiday where facility_id='"+facilityId+"')  and a.facility_id='"+facilityId+"' and a.EFF_STATUS='E'  and language_id='"+locale+"' and a.level_of_care_ind = 'A' and a.ALLOW_APPT_YN='Y' "+whereClause+" ) ";
	}else{
		//below Query is modified for SS-SCF-0788 by Kamatchi S on 02-SEP-2020
		sql="Select a.care_locn_type_ind care_locn_type_ind,a.long_desc long_desc,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type from op_clinic_lang_vw a WHERE a.clinic_code  IN (SELECT locn_code FROM oa_holiday where facility_id='"+facilityId+"')  and a.facility_id='"+facilityId+"' and a.EFF_STATUS='E'  and language_id='"+locale+"' and a.level_of_care_ind = 'A' and a.ALLOW_APPT_YN='Y' "+whereClause+" ";
	}

	

		}else if(tab_Selected.equals("Holiday")){

		sql_sb.append(" AND a.clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_loc_ind+"' ");
	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	if(clinic_code.equals("") && clinic_desc.equals("")){
	sql="SELECT care_locn_type_ind,long_desc,clinic_code,clinic_type FROM (Select care_locn_type_ind,a.long_desc long_desc,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type from op_clinic_lang_vw a   where    LANGUAGE_ID = '"+locale+"' AND a.clinic_code not in (select locn_code from oa_holiday where facility_id='"+facilityId+"' ) and a.facility_id='"+facilityId+"' and a.EFF_STATUS='E' and a.level_of_care_ind = 'A'   and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' "+whereClause+" ) ";
	}else{
	sql="Select care_locn_type_ind,a.long_desc long_desc,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type from op_clinic_lang_vw a   where    LANGUAGE_ID = '"+locale+"' AND a.clinic_code not in (select locn_code from oa_holiday where facility_id='"+facilityId+"' ) and a.facility_id='"+facilityId+"' and a.EFF_STATUS='E' and a.level_of_care_ind = 'A'   and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' "+whereClause+" ";
	}
	
	}

	}else if(function_id.equals("APPT_WAIT_LIST")){
	if ( (whereClause == null || whereClause.equals("")) )
	{
		if(locn_type.equals("N")){ 
			// modified on 22 mar 2010 to handle the ursing unit lookup. if condition added
			sql_sb.append("AND a.facility_id='"+facilityId+"' AND a.language_id='"+locale+"' and a.LOCN_TYPE=b.LOCN_TYPE ");
			if(!speciality_code.equals("")){
				sql_sb.append(" AND c.SPECIALTY_CODE='"+speciality_code+"' ");
			}
		}else{
			sql_sb.append("AND a.facility_id='"+facilityId+"' AND a.language_id='"+locale+"' AND  clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_locn_ind+"'  and a.clinic_type=b.LOCN_TYPE ");
			if(!speciality_code.equals("")){
				sql_sb.append(" AND A.SPECIALITY_CODE='"+speciality_code+"' ");
			}
		}
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}

	if(locn_type.equals("N")){
		sql="Select a.long_desc long_desc, a.NURSING_UNIT_CODE clinic_code from IP_Nursing_unit_lang_vw a , AM_OS_USER_LOCN_ACCESS_VW b,ip_nurs_unit_for_specialty c  where B.locn_type = 'N'  and a.facility_id = b.facility_id and a.NURSING_UNIT_CODE=b.locn_code and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate)))  AND A.EFF_STATUS = 'E' and c.NURSING_UNIT_CODE=a.NURSING_UNIT_CODE and c.facility_id='"+facilityId+"' AND b.appl_user_id='"+loginuser+"' AND b.CREATE_WAIT_LIST_YN='Y' "+whereClause+" ";


	}else{
		sql="Select a.long_desc long_desc, a.alcn_criteria alcn_criteria,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type,a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn,ident_at_checkin,fi_visit_type_appl_yn,to_char(WORKING_DAY_START_TIME,'HH24:mi') STime,to_char(WORKING_DAY_END_TIME,'HH24:mi') ETime, to_char(BASE_SLOT_SLAB_TIME,'HH24:mi') dur from op_clinic_lang_vw a , AM_OS_USER_LOCN_ACCESS_VW b  where a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and a.eff_status='E' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' and b.CREATE_WAIT_LIST_YN='Y' and b.appl_user_id='"+loginuser+"'"+whereClause+"  and a.clinic_type=b.LOCN_TYPE and a.rd_appl_yn='"+rd_appt_yn+"'";
	}

	}else if(function_id.equals("SCH_APPT")){
	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql_sb.append(" AND  clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_locn_ind+"' ");
		if(!speciality_code.equals("")){
			sql_sb.append(" AND A.SPECIALITY_CODE='"+speciality_code+"' ");
			}
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="select a.open_to_all_pract_yn,a.long_desc,a.clinic_code from op_clinic_lang_vw a,am_os_user_locn_access_vw b where a.facility_id='"+facilityId+"' and a.rd_appl_yn='"+rd_appt_yn+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and a.level_of_care_ind = 'A' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.appl_user_id='"+loginuser+"' and (b.book_appt_yn='Y' or b.tfr_appt_yn='Y' or b.canc_appt_yn='Y') and a.eff_status = 'E' and a.language_id='"+locale+"' and a.clinic_type=b.locn_type "+whereClause+"  ";

	}else if(function_id.equals("BULK_TRANSFER")){
		//code for bulk transfer
	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql_sb.append("AND a.facility_id='"+facilityId+"' AND language_id='"+locale+"' AND  clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_locn_ind+"' ");
		if(!speciality_code.equals("")){
			sql_sb.append(" AND A.SPECIALITY_CODE='"+speciality_code+"' ");
			}
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="select a.long_desc,a.clinic_code,open_to_all_pract_yn,PRIMARY_RESOURCE_CLASS from op_clinic_lang_vw a,am_os_user_locn_access_vw b where a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and a.level_of_care_ind = 'A' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.appl_user_id='"+loginuser+"' and (b.tfr_appt_yn='Y' or b.canc_appt_yn='Y') and a.eff_status = 'E' and a.clinic_type=b.locn_type "+whereClause+" "; 
	}else{
	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql_sb.append("AND a.facility_id='"+facilityId+"' AND language_id='"+locale+"' AND  clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_locn_ind+"' ");
		if(!speciality_code.equals("")){
			sql_sb.append(" AND A.SPECIALITY_CODE='"+speciality_code+"' ");
			}
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="SELECT a.clinic_code clinic_code,a.long_desc long_desc,open_to_all_pract_yn FROM  op_clinic_lang_vw a WHERE level_of_care_ind = 'A' AND a.eff_status='E' "+whereClause+"  ";
	}
	/*
	if(function_id.equals("HOLIDAY") && tab_Selected.equals("Location")){
		if(order_by.equals("D")){
			sql = sql + "order by Nvl(care_locn_type_ind,'!') , long_desc";
		}else{
			sql = sql + "order by Nvl(care_locn_type_ind,'!') , clinic_code";
		}
	} else {
	if(order_by.equals("D")){
		sql = sql + "order by long_desc";
	}else{
		sql = sql + "order by clinic_code";
	}
	}
	*/
	if(order_by.equals("D")){
		sql = sql + "order by long_desc";
	}else{
		sql = sql + "order by clinic_code";
	}


	
	int cnt=0;	
	try{
	con = ConnectionManager.getConnection(request);
	if(pstmt!=null)pstmt.close();
	if(rs!=null)rs.close();
	pstmt = con.prepareStatement(sql);
	rs=pstmt.executeQuery();
	
	if(function_id.equals("HOLIDAY") && (rs!=null && rs.next())){  
		if(function_id.equals("HOLIDAY") && tab_Selected.equals("Location")){  
			if(clinic_code.equals("") && clinic_desc.equals("")){
				//below Query is modified for SS-SCF-0788 by Kamatchi S on 13-AUG-2020
				sql="SELECT care_locn_type_ind,long_desc,clinic_code,clinic_type FROM (Select a.care_locn_type_ind care_locn_type_ind,a.long_desc long_desc,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type from op_clinic_lang_vw a WHERE a.clinic_code  IN (SELECT locn_code FROM oa_holiday where facility_id='"+facilityId+"')  and a.facility_id='"+facilityId+"'  and a.EFF_STATUS='E' and language_id='"+locale+"' and a.level_of_care_ind = 'A' and a.ALLOW_APPT_YN='Y' "+whereClause+" UNION Select NULL care_locn_type_ind,'*All' long_desc,'*A' clinic_code,null clinic_type from dual) ";
			}else{
				//below Query is modified for SS-SCF-0788 by Kamatchi S on 02-SEP-2020
				sql="Select a.care_locn_type_ind care_locn_type_ind,a.long_desc long_desc,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type from op_clinic_lang_vw a WHERE a.clinic_code  IN (SELECT locn_code FROM oa_holiday where facility_id='"+facilityId+"')  and a.facility_id='"+facilityId+"' and a.EFF_STATUS='E' and language_id='"+locale+"' and a.level_of_care_ind = 'A' and a.ALLOW_APPT_YN='Y' "+whereClause+" ";
			}
		}else if(function_id.equals("HOLIDAY") && tab_Selected.equals("Holiday")){
			if(clinic_code.equals("") && clinic_desc.equals("")){
				sql="SELECT care_locn_type_ind,long_desc,clinic_code,clinic_type FROM (Select care_locn_type_ind,a.long_desc long_desc,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type from op_clinic_lang_vw a   where    LANGUAGE_ID = '"+locale+"' AND a.clinic_code not in (select locn_code from oa_holiday where facility_id='"+facilityId+"' ) and a.facility_id='"+facilityId+"' and a.EFF_STATUS='E' and a.level_of_care_ind = 'A'   and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' "+whereClause+" UNION Select NULL care_locn_type_ind,'*All' long_desc,'*A' clinic_code,null clinic_type from dual) ";
			}else{
				sql="Select care_locn_type_ind,a.long_desc long_desc,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type from op_clinic_lang_vw a   where    LANGUAGE_ID = '"+locale+"' AND a.clinic_code not in (select locn_code from oa_holiday where facility_id='"+facilityId+"' ) and a.facility_id='"+facilityId+"' and a.EFF_STATUS='E' and a.level_of_care_ind = 'A'   and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' "+whereClause+" ";
			}
		}		
		if(order_by.equals("D")){
			sql = sql + "order by long_desc";
		}else{
			sql = sql + "order by clinic_code";
		}
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();		
		pstmt = con.prepareStatement(sql);
		rs=pstmt.executeQuery();
	}
	
	
	if(start !=1){
		for(int j=1;j<start;i++,j++){
			rs.next() ;
		}
	 }

	while(i<=end && rs.next()){
		if(cnt==0){
			
%>
<p>
	<table align='right' cellspacing="0">
	 <tr>
	 <% 
	if ( !(start <= 1) )
	 out.println("<td><A HREF=\"../../eOA/jsp/OALocationlookupresult.jsp?from="+(start-14)+"&to="+(end-14)+"&function_id="+function_id+"&tab_Selected="+tab_Selected+"&oper_stn_id="+oper_stn_id+"&locn_type="+locn_type+"&speciality_code="+speciality_code+"&care_locn_ind="+care_locn_ind+"&search_click="+search_click+"&clinic_code="+clinic_code+"&clinic_desc="+clinic_desc+"&start_ends_contains="+start_ends_contains+"&order_catalog_code="+order_catalog_code+"&order_by="+order_by+"\" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

	 out.println("<td><A id='nextvalue' HREF=\"../../eOA/jsp/OALocationlookupresult.jsp?from="+(start+14)+"&to="+(end+14)+"&function_id="+function_id+"&tab_Selected="+tab_Selected+"&oper_stn_id="+oper_stn_id+"&locn_type="+locn_type+"&speciality_code="+speciality_code+"&care_locn_ind="+care_locn_ind+"&search_click="+search_click+"&clinic_code="+clinic_code+"&clinic_desc="+clinic_desc+"&start_ends_contains="+start_ends_contains+"&order_catalog_code="+order_catalog_code+"&order_by="+order_by+"\" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
	 %>
	 </tr>
	</table>
</p>
<BR><BR>
<table border="1" cellspacing="0" cellpadding="0" width="100%" align="center">
<th ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th ><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<%}
	String classValue = "" ;
	
	        if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;


			if(function_id.equals("SetUpDailySchedule")){
			code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
			desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"":rs.getString("open_to_all_pract_yn");
			String clinic_type=rs.getString("clinic_type")==null?"":rs.getString("clinic_type");
			ident_at_checkin=rs.getString("ident_at_checkin")==null?"":rs.getString("ident_at_checkin");
			String fi_visit_type_appl_yn=rs.getString("fi_visit_type_appl_yn")==null?"":rs.getString("fi_visit_type_appl_yn");
			String alcn_criteria=rs.getString("alcn_criteria")==null?"":rs.getString("alcn_criteria");
			String STime=rs.getString("STime")==null?"":rs.getString("STime");
			String ETime=rs.getString("ETime")==null?"":rs.getString("ETime");
			String dur=rs.getString("dur")==null?"":rs.getString("dur");
			String primary_resource_class=rs.getString("PRIMARY_RESOURCE_CLASS")==null?"":rs.getString("PRIMARY_RESOURCE_CLASS");
			String rd_appl_yn=rs.getString("rd_appl_yn")==null?"N":rs.getString("rd_appl_yn");

			retval=code+"~"+desc+"~"+open_to_all_pract_yn+"~"+clinic_type+"~"+ident_at_checkin+"~"+fi_visit_type_appl_yn+"~"+alcn_criteria+"~"+STime+"~"+ETime+"~"+dur+"~"+primary_resource_class+"~"+rd_appl_yn;
			}else if(function_id.equals("GEN_SCH")){

			code=rs.getString("clinic_code");
			desc=rs.getString("long_desc");
			String locntype=rs.getString("clinic_type");
			retval=code+"~"+desc+"~"+locntype;

			}else if(function_id.equals("BLK_APPT_SLOTS")){

			code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
			desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");
			String clinic_type=rs.getString("clinic_type")==null?"":rs.getString("clinic_type");
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"":rs.getString("open_to_all_pract_yn");
			ident_at_checkin=rs.getString("ident_at_checkin")==null?"":rs.getString("ident_at_checkin");
			retval=code+"~"+desc+"~"+open_to_all_pract_yn+"~"+clinic_type+"~"+ident_at_checkin;

			}else if(function_id.equals("TRAN_SCH")){

			code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
			desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");	
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"":rs.getString("open_to_all_pract_yn");
			String clinic_type=rs.getString("locn_type")==null?"":rs.getString("locn_type");
			retval=code+"~"+desc+"~"+open_to_all_pract_yn+"~"+clinic_type;

			}else if(function_id.equals("CHG_PRACT_SCH")){
			code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
			desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");	
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"":rs.getString("open_to_all_pract_yn");
			String clinic_type=rs.getString("clinic_type")==null?"":rs.getString("clinic_type");
			retval=code+"~"+desc+"~"+open_to_all_pract_yn+"~"+clinic_type;

			}else if(function_id.equals("BLK_LIFT_CANC_SCH")||function_id.equals("PURG_SCH_REC")){

			code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
			desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");	
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"":rs.getString("open_to_all_pract_yn");
			String clinic_type=rs.getString("locn_type")==null?"":rs.getString("locn_type");
			ident_at_checkin=rs.getString("ident_at_checkin")==null?"":rs.getString("ident_at_checkin");
			String primary_resource_class=rs.getString("primary_resource_class")==null?"":rs.getString("primary_resource_class");
			retval=code+"~"+desc+"~"+open_to_all_pract_yn+"~"+clinic_type+"~"+ident_at_checkin+"~"+primary_resource_class;

			}else if(function_id.equals("PRACT_DUTY_ROSTER")){
				///pract
			code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
			desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"":rs.getString("open_to_all_pract_yn");
			String clinic_type=rs.getString("clinic_type")==null?"":rs.getString("clinic_type");
			ident_at_checkin=rs.getString("ident_at_checkin")==null?"":rs.getString("ident_at_checkin");
			String fi_visit_type_appl_yn=rs.getString("fi_visit_type_appl_yn")==null?"":rs.getString("fi_visit_type_appl_yn");
			String alcn_criteria=rs.getString("alcn_criteria")==null?"":rs.getString("alcn_criteria");
			String STime=rs.getString("STime")==null?"":rs.getString("STime");
			String ETime=rs.getString("ETime")==null?"":rs.getString("ETime");
			String dur=rs.getString("dur")==null?"":rs.getString("dur");
			retval=code+"~"+desc+"~"+open_to_all_pract_yn+"~"+clinic_type+"~"+ident_at_checkin+"~"+fi_visit_type_appl_yn+"~"+alcn_criteria+"~"+STime+"~"+ETime+"~"+dur;

			}else if(function_id.equals("HOLIDAY")){
				if(tab_Selected.equals("Location")){
				code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
				desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");
				care_loc_ind=rs.getString("care_locn_type_ind")==null?"":rs.getString("care_locn_type_ind");
				retval=code+"~"+desc+"~"+care_loc_ind;
				}else if(tab_Selected.equals("Holiday")){
				code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
				desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");
				care_loc_ind=rs.getString("care_locn_type_ind")==null?"":rs.getString("care_locn_type_ind");
				retval=code+"~"+desc+"~"+care_loc_ind;
				}
				
			}else if(function_id.equals("WAIT_LIST")){
				String clinic_type="";
				ident_at_checkin="";
				String fi_visit_type_appl_yn="";
				String alcn_criteria="";
				String STime="";
				String ETime="";
				String dur="";
				if(locn_type.equals("N")){
				code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
				desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");
				open_to_all_pract_yn="";
				clinic_type="N";
				ident_at_checkin="";
				fi_visit_type_appl_yn="";
				alcn_criteria="";
				STime="";
				ETime="";
				dur="";
				}else{
				code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
				desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");
				open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"":rs.getString("open_to_all_pract_yn");
				clinic_type=rs.getString("clinic_type")==null?"":rs.getString("clinic_type");
				ident_at_checkin=rs.getString("ident_at_checkin")==null?"":rs.getString("ident_at_checkin");
				fi_visit_type_appl_yn=rs.getString("fi_visit_type_appl_yn")==null?"":rs.getString("fi_visit_type_appl_yn");
				alcn_criteria=rs.getString("alcn_criteria")==null?"":rs.getString("alcn_criteria");
				STime=rs.getString("STime")==null?"":rs.getString("STime");
				ETime=rs.getString("ETime")==null?"":rs.getString("ETime");
				dur=rs.getString("dur")==null?"":rs.getString("dur");
				}
				retval=code+"~"+desc+"~"+open_to_all_pract_yn+"~"+clinic_type+"~"+ident_at_checkin+"~"+fi_visit_type_appl_yn+"~"+alcn_criteria+"~"+STime+"~"+ETime+"~"+dur;
			}else if(function_id.equals("APPT_WAIT_LIST")){
				String clinic_type="";
				ident_at_checkin="";
				String fi_visit_type_appl_yn="";
				String alcn_criteria="";
				String STime="";
				String ETime="";
				String dur="";
				if(locn_type.equals("N")){
				code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
				desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");
				open_to_all_pract_yn="";
				clinic_type="N";
				ident_at_checkin="";
				fi_visit_type_appl_yn="";
				alcn_criteria="";
				STime="";
				ETime="";
				dur="";
				}else{
				code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
				desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");
				open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"":rs.getString("open_to_all_pract_yn");
				clinic_type=rs.getString("clinic_type")==null?"":rs.getString("clinic_type");
				ident_at_checkin=rs.getString("ident_at_checkin")==null?"":rs.getString("ident_at_checkin");
				fi_visit_type_appl_yn=rs.getString("fi_visit_type_appl_yn")==null?"":rs.getString("fi_visit_type_appl_yn");
				alcn_criteria=rs.getString("alcn_criteria")==null?"":rs.getString("alcn_criteria");
				STime=rs.getString("STime")==null?"":rs.getString("STime");
				ETime=rs.getString("ETime")==null?"":rs.getString("ETime");
				dur=rs.getString("dur")==null?"":rs.getString("dur");
				}
				retval=code+"~"+desc+"~"+open_to_all_pract_yn+"~"+clinic_type+"~"+ident_at_checkin+"~"+fi_visit_type_appl_yn+"~"+alcn_criteria+"~"+STime+"~"+ETime+"~"+dur;
			}else if(function_id.equals("SCH_APPT")){
				code=rs.getString("clinic_code");
				desc=rs.getString("long_desc");
				open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
				retval=code+"~"+desc+"~"+open_to_all_pract_yn;
			}else if(function_id.equals("BULK_TRANSFER")){
				code=rs.getString("clinic_code");
				desc=rs.getString("long_desc");
				String primary_resource_class=rs.getString("PRIMARY_RESOURCE_CLASS")==null?"":rs.getString("PRIMARY_RESOURCE_CLASS");
				open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
				//retval=code+"~"+desc+"~"+open_to_all_pract_yn;
				retval=code+"~"+desc+"~"+open_to_all_pract_yn+"~"+primary_resource_class;
			}else if(function_id.equals("WAIT_LIST_MODIFY")){
				desc=rs.getString("long_desc");
				code=rs.getString("clinic_code");
				if(locn_type.equals("N")){
					open_to_all_pract_yn="*";
				}else{
				open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
				}

				retval=code+"~"+desc+"~"+open_to_all_pract_yn;

			}else{
				code=rs.getString("clinic_code");
				desc=rs.getString("long_desc");
				open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
				//retval=code+"~"+desc+"~"+open_to_all_pract_yn;
				/*Below Line Added and Above Line Commented for this SCF ML-BRU-SCF-0240 [IN:033238]*/	
                 String primary_resource_class=rs.getString("PRIMARY_RESOURCE_CLASS")==null?"":rs.getString("PRIMARY_RESOURCE_CLASS");
                 retval=code+"~"+desc+"~"+open_to_all_pract_yn+"~"+primary_resource_class;				 
			}	
			retval=retval.replaceAll("'","\\\\'");// included for the SCF ML-BRU-SCF-0253 33367
		%>
	
		<tr><td class=<%=classValue%>>
 		<!-- <a href='javascript:retvalue("<%=retval%>")'><%=code%></td> Commented by Shanthi for the SCF - ML-BRU-SCF-0253 33367 -->
		<a href="javascript:retvalue('<%=retval%>')"><%=code%></td> 
		<td class=<%=classValue%>><%=desc%></td></tr>
	
	<%

cnt++;
i++;

}
 if(cnt==0)
	 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
 if(!rs.next()&&cnt!=0){
	%>
	<script>	
		document.getElementById("nextvalue").innerHTML=" ";
	<%if((cnt==1 && i==2)&& search_click.equals("N")){%>
		//retvalue("<%=java.net.URLEncoder.encode(retval)%>");
		retvalue("<%=retval%>");
	<%}%>
	</script>
	<input type="hidden" name="functionID" id="functionID" value="<%=function_id%>">
	<%}
}catch(Exception e){
	//out.println("OA failed @@"+e.toString());
	e.printStackTrace();
}finally {
	if(pstmt!=null)pstmt.close();
	if(rs!=null)rs.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}%>
</table>
</html>

