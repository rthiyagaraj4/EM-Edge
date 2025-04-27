<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

 <%!
/*public String getStatistics(PageContext pageContext,Connection con,String facility_id,String clinic_type,String clinic_code,String treatment_area_code, String include_checkedout) throws java.sql.SQLException  Tuesday, June 01, 2010 PE_EXE Venkat S
	{ 
		String query_statistics	=	" select tot_assigned, tot_under_tmt, tot_consulted, tot_await_tmt, tot_checked_out from ae_tmt_area_summ where facility_id = ? and trunc(queue_date) = trunc(sysdate) and locn_type = ? and locn_code = ? and treatment_area_code = ?"; 
		int tot_assigned	=	0; 
		int tot_under_tmt	=	0;  
		int tot_consulted	=	0;	
		int tot_await_tmt	=	0;
		int tot_checked_out	=	0;

		PreparedStatement pstmt	=	con.prepareStatement(query_statistics);

		pstmt.setString	(	1,	facility_id	);
		pstmt.setString	(	2,	clinic_type	);
		pstmt.setString	(	3,	clinic_code	);
		pstmt.setString	(	4,	treatment_area_code);

		ResultSet rs =	pstmt.executeQuery();
		if(rs.next())
		{
			tot_checked_out =	rs.getInt("tot_checked_out");
			tot_assigned	=	rs.getInt("tot_assigned");
			tot_under_tmt	=	rs.getInt("tot_under_tmt");
			tot_consulted	=	rs.getInt("tot_consulted");
			tot_await_tmt	=	rs.getInt("tot_await_tmt");
			tot_under_tmt	-=	tot_checked_out;

			if(include_checkedout.equals("N"))
			{
				tot_assigned	-=	tot_checked_out;
				tot_consulted	-=	tot_checked_out;
			}
		}
		if(rs!=null)			rs.close();
        if(pstmt!=null)			pstmt.close();
		StringBuffer tmt_area_statistics	= new StringBuffer();
		tmt_area_statistics.append(" ("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Assigned.label","common_labels")+" : ");
		tmt_area_statistics.append(tot_assigned);
		tmt_area_statistics.append(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.UndergoingTreatment.label","ae_labels")+" : ");
		tmt_area_statistics.append(tot_under_tmt);
		tmt_area_statistics.append(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.Consulted.label","ae_labels")+" : ");
		tmt_area_statistics.append(tot_consulted);
		tmt_area_statistics.append(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AwaitingTreatment.label","ae_labels")+" : ");
		tmt_area_statistics.append(tot_await_tmt);
		tmt_area_statistics.append(" )");
	
		return tmt_area_statistics.toString();
	} */
%> 

<html>
<meta http-equiv="REFRESH" content="600">

<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String loginUser			= checkForNull((String)session.getValue("login_user"));

%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eAE/js/AEUtilities.js'></script>
<script language='javascript' src='../../eAE/js/AEManagePatientGI.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>


<%
	try{

	Connection con				=	null;
	PreparedStatement pstmt		=	null;
	ResultSet rs				=	null;
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String locale				= (String)session.getAttribute("LOCALE");
	StringBuffer	query_patient_queue		= new StringBuffer();		String facility_id				=	"";
	String	clinic_code				=	"";
	String	practitioner_id			=	"", practitioner_full_name="";
	String	patient_id				=	"",		patient_name			=	"";
	String	waiting_time			=	"",		queue_status			=	"";
	String	classValue				=	"";
	String	treatment_area_code		=	"";
	String	treatment_area_desc		=	"",		triage_area				=	"";
	String	classValuePI			=	"";
	String	queue_date				=	"";
	String	encounter_id			=	"",		clinic_type				=	"";
	String	patient_gender			=	"";
	StringBuffer	whereClause		= new StringBuffer();
    StringBuffer  orderByClause		= new StringBuffer(); 
	String	priority				=	"";
	String	trauma_yn				=	"";
	String	tblrow_id				=	"",		queue_date_time			=	"";
	String	sys_date_time			=	"",		checkout_yn				=	"";
	String	brought_dead_yn			=	"";
	String	from 					=	"";
	String	assign_tmt_area_time	=	"";
	String	p_clinic_desc	        =   "";
	String	open_to_all_pract_yn	=	"";
	String service_code             =   "";
	String visit_type_code          =   "";
	String pract_type               =   "";
	String CAInstalled               =   "";
	// Added for MMS-QH-CRF-0126.2 by Dharma Start
	String action_on_pending_bill	= "";
	String visit_num				= "";
	String episode_id				= "";			
	// Added for MMS-QH-CRF-0126.2 by Dharma End
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 2nd 2014 Start*/
	String five_level_triage_appl_yn	=  (request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");
	String priority_zone_bgcolor		= "";
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 2nd 2014 End*/

	String open_to_all_prac_for_clinic_yn	=	"";
	String p_cutoff_hours_prv_day_visit     =	"";
	String patient_class = "";
	String prev_visit = "";
	String oper_stn_id     =	(request.getParameter("oper_stn_id")==null)? "" : request.getParameter("oper_stn_id");


	String priority_zone="";
	//coming from criteria page
	String chk_Select1			=	request.getParameter("chk_Select1");
	

/************************/
String orderCriteria	=	(request.getParameter("orderCriteria")==null)	? "queueDate" : request.getParameter("orderCriteria");
String asc_desc	=	(request.getParameter("asc_desc")==null)	? " asc" : request.getParameter("asc_desc");

if(orderCriteria.equals("")) orderCriteria="queueDate" ;


	String login_user	= (String)session.getValue("login_user");
	if (login_user == null) login_user = "";
	String responsibility_id = (String)session.getValue("responsibility_id");
	if ( responsibility_id  == null) responsibility_id = "";
	int		rowIndex				=	1,		columnIndex				=	1;
//	int columnIndexSec = 1;
//	int		maxRecord				=	0;
	int     i		   = 1;
	int		start					=	0;


	from							=	request.getParameter("from") ;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	try
	{
		con				=	(Connection)	ConnectionManager.getConnection(request);
		/*Added By Dharma against ML-MMOH-CRF-0627 [IN:062144] on 10th Apr 2018 Start*/
	Boolean waitingTimeIndYN			=	CommonBean.isSiteSpecific(con, "AE", "WAITING_TIME_INDICATOR");
	int p_waiting_time					= 0;
	String p_waiting_time_color			= "";
	int p_waiting_time_hours			= 0;
	int p_waiting_time_mins				= 0;
	String firststring     = "";
    String secondstring   = "";
	/*Added By Dharma against ML-MMOH-CRF-0627 [IN:062144] on 10th Apr 2018 End*/
		facility_id		=	(String) session.getValue("facility_id");

		prev_visit			=	(request.getParameter("prev_visit")==null) ? "N" : request.getParameter("prev_visit");

		clinic_code			=	(request.getParameter("clinic_code")==null) ? "" : request.getParameter("clinic_code");
		clinic_type			=	(request.getParameter("clinic_type")==null) ? "" : request.getParameter("clinic_type");
		treatment_area_code	=	(!checkForNull(request.getParameter("treatment_area_code")).equals("")) ? request.getParameter("treatment_area_code") : checkForNull(request.getParameter("treatment_area_code1"));
		practitioner_id		=	(request.getParameter("practitioner_id")==null) ? "" : request.getParameter("practitioner_id");
		patient_id			=	(request.getParameter("patient_id")==null) ? "" : request.getParameter("patient_id");
		priority			=	(request.getParameter("priority")==null) ? "" : request.getParameter("priority");
		patient_gender		=	(request.getParameter("patient_gender")==null) ? "" : request.getParameter("patient_gender");
		checkout_yn	=	(request.getParameter("checkout_yn")==null)	? "" : request.getParameter("checkout_yn");
        p_cutoff_hours_prv_day_visit 	=	(request.getParameter("p_cutoff_hours_prv_day_visit")==null)	? "" : request.getParameter("p_cutoff_hours_prv_day_visit");
		priority_zone	=	(request.getParameter("priority_zone")==null)	? "" : request.getParameter("priority_zone");	
		
		//Added by Ajay Hatwate for MMS-DM-CRF-0210.1
		String hide_pat_unauth_pract = "N";
	   	String access_res_pat_yn = "N";
		//String loginUser			= checkForNull((String)session.getValue("login_user"));
	    
	     pstmt = con.prepareStatement("select (select HIDE_PAT_UNAUTH_PRACT_YN from CA_PARAM_BY_FACILITY where facility_id = ?) hide_pat_unauth_pract_yn, (SELECT a.access_res_pat_yn FROM ca_access_view_restr_patient a WHERE a.practitioner_id = (SELECT func_role_id FROM sm_appl_user WHERE appl_user_id = ?) AND a.facility_id = ? AND (   (    a.access_from_date IS NULL AND a.access_to_date IS NOT NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (a.access_to_date, 'DD/MM/YYYY') ) OR (    a.access_from_date IS NOT NULL AND a.access_to_date IS NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (a.access_from_date, 'DD/MM/YYYY') ) OR (    a.access_from_date IS NOT NULL AND a.access_to_date IS NOT NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (a.access_from_date, 'DD/MM/YYYY') AND TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (a.access_to_date, 'DD/MM/YYYY') ) ))access_res_pat_yn from dual ");
	   	pstmt.setString(1, facility_id);
	   	pstmt.setString(2, loginUser);
	   	pstmt.setString(3, facility_id);
	   	rs = pstmt.executeQuery();
	   	rs.next();
	   	hide_pat_unauth_pract = checkForNull(rs.getString("hide_pat_unauth_pract_yn"),"N");
	   	access_res_pat_yn = checkForNull(rs.getString("access_res_pat_yn"),"N");
	   // System.out.println(hide_pat_unauth_pract + " : hide_pat_unauth_pract; " +access_res_pat_yn + " : access_res_pat_yn");
	    if(pstmt!=null) pstmt.close();
	    if(rs!=null) rs.close();
		//End of MMS-DM-CRF-0210
		

		if(!(clinic_code.equals("")))			whereClause.append(" and a.locn_code = ? and a.locn_type = ? ");
		if(!(treatment_area_code.equals("")))	whereClause.append(" and a.treatment_area_code = ? ");
		if(!(practitioner_id.equals("")))		whereClause.append(" and a.practitioner_id = ? ");
		if(!(patient_id.equals("")))			whereClause.append(" and a.patient_id = ? ");
		if(!(priority.equals("")))				whereClause.append(" and a.priority_indicator = ? ");
		if(!(patient_gender.equals("")))		whereClause.append(" and b.sex = ? ");
      /*  if(priority_zone.equals("R"))		whereClause.append(" and a.priority_zone = 'R' ");
		if(priority_zone.equals("Y"))		whereClause.append(" and a.priority_zone = 'Y' ");
		if(priority_zone.equals("G"))		whereClause.append(" and a.priority_zone = 'G' ");
	    if(priority_zone.equals("U"))		whereClause.append(" and a.priority_zone = 'U' ");*/
	    
	    if(!priority_zone.equals(""))
	    	whereClause.append(" and a.priority_zone = '"+priority_zone+"' ");


/*******order by creation logic**********************/

/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb Mar 6th 2014 Start*/
if(five_level_triage_appl_yn.equals("Y")){
		
	 PreparedStatement pstmt1		=	null;
	 ResultSet rs1					=	null;
	 int priority_zone_order;
	 String priority_zone_code		= "";
	 String priority_zone_orderby	 = "";
	 
	 String sql1="SELECT PRIORITY_ZONE,PRIORITY_ZONE_ORDER FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID=? and EFF_STATUS='E' order by PRIORITY_ZONE_ORDER asc";
	 pstmt1   = con.prepareStatement(sql1.toString());
	 pstmt1.setString(1,locale) ;
	 rs1	=	pstmt1.executeQuery();
	 while(rs1!=null && rs1.next()){
		 priority_zone_code		= rs1.getString("PRIORITY_ZONE");
		 priority_zone_order	= rs1.getInt("PRIORITY_ZONE_ORDER");
		 priority_zone_orderby = priority_zone_orderby + "'"+priority_zone_code+"',"+priority_zone_order+",";
	 }
		if (priority_zone_orderby.length() > 0 && priority_zone_orderby.charAt(priority_zone_orderby.length()-1)==',') {
			priority_zone_orderby = priority_zone_orderby.substring(0, priority_zone_orderby.length()-1);
		}
		
	 
	 if (pstmt1 != null){
			pstmt1.close();
		}
		if (rs1!=null){
			rs1.close();
		}
		orderByClause.append(" DECODE(priority_zone,"+priority_zone_orderby+")asc,queue_date_time desc, ");
}
/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 6th 2014 End*/
orderByClause.append("locn_desc,treatment_area_code ");
	
if(orderCriteria.equals("practitioner"))
		{
			orderByClause.append(",practitioner_name"+asc_desc+" ");
		}
else if(orderCriteria.equals("queueDate"))
		{
			orderByClause.append(",queue_date_time"+asc_desc+" ");
		}
else if(orderCriteria.equals("patientName"))
		{
				orderByClause.append(",patient_name"+asc_desc+" ");
		}
else if(orderCriteria.equals("patientId"))
		{
				orderByClause.append(",patient_id"+asc_desc+" ");
		}
else if(orderCriteria.equals("priorityZone"))
		{
				orderByClause.append(" ,DECODE(priority_zone,'R',1,'Y',2,'G',3,'U',4)"+asc_desc+" ");
		}
		else if(orderCriteria.equals("waitingTime"))
		{
	        orderByClause.append(" ,queue_date_time ");
			orderByClause.append(" "+asc_desc+" ");
		}

       whereClause.append(" AND a.queue_date >= TO_DATE (TO_CHAR (SYSDATE - 1, 'dd/mm/yyyy') || ' 23:59:59','dd/mm/yyyy hh24:mi:ss'   )- ((1 / (24 * 60 * 60)) * 3600 * '"+p_cutoff_hours_prv_day_visit+"')"); 
	 
	    whereClause.append(" and  (a.locn_type, a.locn_code) in  (select locn_type, locn_code from  am_os_user_locn_access_vw  where facility_id = '"+facility_id+"' and Oper_stn_id ='"+oper_stn_id+"' and  appl_user_id ='"+loginUser+"' ");
		
		whereClause.append((checkout_yn.equals("Y"))?"and checkout_pat_yn = 'Y'":"and manage_queue_yn = 'Y' ");

		whereClause.append(" )");
		//Added by Ajay Hatwate for MMS-DM-CRF-0210
		if(access_res_pat_yn.equals("N") && hide_pat_unauth_pract.equals("Y")){
			whereClause.append(" AND ((b.restrict_reinstate_yn = 'N' or b.restrict_reinstate_yn is null)  OR (b.restrict_reinstate_yn = 'Y' AND a.queue_status < '04')) ");
	    }
		//End of MMS-DM-CRF-0210
/**********orderby logic ends**************/		
 		//query_patient_queue.append("select a.locn_code, c.LONG_DESC locn_desc, a.locn_type, a.treatment_area_code, (select install_yn from sm_module where module_id='CA') CAInstalled,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,a.LOCN_CODE,a.TREATMENT_AREA_CODE,'"+locale+"' ,'2') treatment_area_desc, (CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT DECODE (triage_area_yn, 'Y', 'B', 'N', 'C', '', 'A' ) FROM ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ) triage_area, c.open_to_all_pract_yn,  a.practitioner_id, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'2') practitioner_name, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'1') practitioner_full_name, a.priority_indicator, to_char(a.queue_date,'dd/mm/yyyy hh24:mi') queue_date_time, to_char(a.check_in_date_time,'hh24:mi') check_in_date_time, to_char(a.ASSIGN_TMT_AREA_TIME,'hh24:mi') ASSIGN_TMT_AREA_TIME,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time, a.patient_id, (decode('"+locale+"' ,'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))) patient_name, b.sex patient_gender, a.encounter_id, get_waiting_time(NVL (a.cons_srvc_start_date_time, SYSDATE), queue_date) waiting_time, to_char(a.queue_date,'dd/mm/yyyy') queue_date1, to_char(a.assign_tmt_area_time,'dd/mm/yyyy hh24:mi') assign_date, a.queue_status,  a.trauma_yn, a.brought_dead_yn, NVL((CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT open_to_all_prac_for_clinic_yn FROM  ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ),'N') open_to_all_prac_for_clinic_yn, 'EM' patient_class, a.priority_zone, a.visit_type_code,  a.AE_BED_NO bed_no, a.disaster_yn, a.TRAUMA_YN, a.pat_curr_locn_code, a.PAT_CURR_LOCN_TYPE, AM_GET_DESC.AM_CARE_LOCN_TYPE(a.PAT_CURR_LOCN_TYPE,'"+locale+"' ,'2') CURR_LOCN_TYPE_DESC, OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.pat_curr_locn_code,'"+locale+"','1') pat_curr_locn_desc,a.service_code, DECODE(a.priority_indicator, Null, 'N', get_p_status (get_waiting_time(NVL (a.cons_srvc_start_date_time, SYSDATE), a.queue_date), null)) priority_status,AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,'"+locale+"' ,'2') PAT_PRIORITY_DESC  from  ae_current_patient a, mp_patient b,op_clinic_lang_vw c  where a.facility_id = ?   and a.patient_id = b.patient_id and c.language_id = '"+locale+"' and a.facility_id = c.facility_id  and a.locn_code = c.clinic_code  and a.AE_BED_NO is null ");
		
		//Modified for MMS-QH-CRF-0126.2 by Dharma
		//query_patient_queue.append("select a.locn_code, c.LONG_DESC locn_desc, a.locn_type, a.treatment_area_code, (select install_yn from sm_module where module_id='CA') CAInstalled,(select action_on_pending_bill  from ae_param where operating_facility_id = '"+facility_id+"') action_on_pending_bill,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,a.LOCN_CODE,a.TREATMENT_AREA_CODE,'"+locale+"' ,'2') treatment_area_desc, (CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT DECODE (triage_area_yn, 'Y', 'B', 'N', 'C', '', 'A' ) FROM ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ) triage_area, c.open_to_all_pract_yn,  a.practitioner_id, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'2') practitioner_name, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'1') practitioner_full_name, a.priority_indicator, to_char(a.queue_date,'dd/mm/yyyy hh24:mi') queue_date_time, to_char(a.check_in_date_time,'hh24:mi') check_in_date_time, to_char(a.ASSIGN_TMT_AREA_TIME,'hh24:mi') ASSIGN_TMT_AREA_TIME,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time, a.patient_id, (decode('"+locale+"' ,'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))) patient_name, b.sex patient_gender, a.encounter_id, get_waiting_time(NVL (a.cons_srvc_start_date_time, SYSDATE), queue_date) waiting_time, to_char(a.queue_date,'dd/mm/yyyy') queue_date1, to_char(a.assign_tmt_area_time,'dd/mm/yyyy hh24:mi') assign_date, a.queue_status,  a.trauma_yn, a.brought_dead_yn, NVL((CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT open_to_all_prac_for_clinic_yn FROM  ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ),'N') open_to_all_prac_for_clinic_yn, 'EM' patient_class, a.priority_zone, a.visit_type_code,  a.AE_BED_NO bed_no, a.disaster_yn, a.TRAUMA_YN, a.pat_curr_locn_code, a.PAT_CURR_LOCN_TYPE, AM_GET_DESC.AM_CARE_LOCN_TYPE(a.PAT_CURR_LOCN_TYPE,'"+locale+"' ,'2') CURR_LOCN_TYPE_DESC, OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.pat_curr_locn_code,'"+locale+"','1') pat_curr_locn_desc,a.service_code, DECODE(a.priority_indicator, Null, 'N', get_p_status (get_waiting_time(NVL (a.cons_srvc_start_date_time, SYSDATE), a.queue_date), null)) priority_status,AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,'"+locale+"' ,'2') PAT_PRIORITY_DESC,a.OP_EPISODE_VISIT_NUM,a.EPISODE_ID  from  ae_current_patient a, mp_patient b,op_clinic_lang_vw c  where a.facility_id = ?   and a.patient_id = b.patient_id and c.language_id = '"+locale+"' and a.facility_id = c.facility_id  and a.locn_code = c.clinic_code  and a.AE_BED_NO is null ");
		
		//Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 4th 2014(PRIORITY_ZONE_COLOR added)
		query_patient_queue.append("select a.locn_code, c.LONG_DESC locn_desc, a.locn_type, a.treatment_area_code, (select install_yn from sm_module where module_id='CA') CAInstalled,(select action_on_pending_bill  from ae_param where operating_facility_id = '"+facility_id+"') action_on_pending_bill,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,a.LOCN_CODE,a.TREATMENT_AREA_CODE,'"+locale+"' ,'2') treatment_area_desc, (CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT DECODE (triage_area_yn, 'Y', 'B', 'N', 'C', '', 'A' ) FROM ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ) triage_area, c.open_to_all_pract_yn,  a.practitioner_id, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'2') practitioner_name, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'1') practitioner_full_name, a.priority_indicator, to_char(a.queue_date,'dd/mm/yyyy hh24:mi') queue_date_time, to_char(a.check_in_date_time,'hh24:mi') check_in_date_time, to_char(a.ASSIGN_TMT_AREA_TIME,'hh24:mi') ASSIGN_TMT_AREA_TIME,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time, a.patient_id, (decode('"+locale+"' ,'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))) patient_name, b.sex patient_gender, a.encounter_id, get_waiting_time(NVL (a.cons_srvc_start_date_time, SYSDATE), queue_date) waiting_time, to_char(a.queue_date,'dd/mm/yyyy') queue_date1, to_char(a.assign_tmt_area_time,'dd/mm/yyyy hh24:mi') assign_date, a.queue_status,  a.trauma_yn, a.brought_dead_yn, NVL((CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT open_to_all_prac_for_clinic_yn FROM  ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ),'N') open_to_all_prac_for_clinic_yn, 'EM' patient_class, a.priority_zone, a.visit_type_code,  a.AE_BED_NO bed_no, a.disaster_yn, a.TRAUMA_YN, a.pat_curr_locn_code, a.PAT_CURR_LOCN_TYPE, AM_GET_DESC.AM_CARE_LOCN_TYPE(a.PAT_CURR_LOCN_TYPE,'"+locale+"' ,'2') CURR_LOCN_TYPE_DESC, OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.pat_curr_locn_code,'"+locale+"','1') pat_curr_locn_desc,a.service_code, DECODE(a.priority_indicator, Null, 'N', get_p_status (get_waiting_time(NVL (a.cons_srvc_start_date_time, SYSDATE), a.queue_date), null)) priority_status,AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,'"+locale+"' ,'2') PAT_PRIORITY_DESC,a.OP_EPISODE_VISIT_NUM,a.EPISODE_ID ,(SELECT PRIORITY_ZONE_COLOR FROM AE_PRIORITY_ZONE WHERE EFF_STATUS='E' and PRIORITY_ZONE=a.PRIORITY_ZONE ) PRIORITY_ZONE_COLOR " );

		if(waitingTimeIndYN){
			query_patient_queue.append(" ,(SELECT WAITING_TIME_COLOR FROM AE_PRIORITY_ZONE WHERE EFF_STATUS='E' and PRIORITY_ZONE=a.PRIORITY_ZONE ) P_WAITING_TIME_COLOR,(SELECT WAITING_TIME FROM AE_PRIORITY_ZONE WHERE EFF_STATUS='E' and PRIORITY_ZONE=a.PRIORITY_ZONE ) P_WAITING_TIME ");
		}
		
		query_patient_queue.append(" from  ae_current_patient a, mp_patient b,op_clinic_lang_vw c  where a.facility_id = ?   and a.patient_id = b.patient_id and c.language_id = '"+locale+"' and a.facility_id = c.facility_id  and a.locn_code = c.clinic_code  and a.AE_BED_NO is null ");
		
		query_patient_queue.append(whereClause);
		query_patient_queue.append(" and queue_status < '07' order by  ");
		query_patient_queue.append(orderByClause);
		
		pstmt		=	con.prepareStatement(query_patient_queue.toString());
		pstmt.setString	(	1,	facility_id		);
		if(!(clinic_code.equals("")))	
		{
			pstmt.setString	(	++columnIndex,	clinic_code	);
			pstmt.setString	(	++columnIndex,	clinic_type	);
		}
		if(!(treatment_area_code.equals("")))	
			pstmt.setString	(	++columnIndex,	treatment_area_code	);
		if(!(practitioner_id.equals("")))	
			pstmt.setString	(	++columnIndex,	practitioner_id	);
		if(!(patient_id.equals("")))	
			pstmt.setString	(	++columnIndex,	patient_id	);
		if(!(priority.equals("")))	
			pstmt.setString	(	++columnIndex,	priority	);
		if(!(patient_gender.equals("")))	
			pstmt.setString	(	++columnIndex,	patient_gender	);

		rs	=	pstmt.executeQuery();	

	
		
	/**********************************/	
       /* PreparedStatement pstmt11		=	con.prepareStatement(query_patient_queue.toString());

	
		pstmt11.setString	(	1,	facility_id		);

		if(!(clinic_code.equals("")))	
		{
			pstmt11.setString	(	++columnIndexSec,	clinic_code	);
			pstmt11.setString	(	++columnIndexSec,	clinic_type	);
		}
		if(!(treatment_area_code.equals("")))	
			pstmt11.setString	(	++columnIndexSec,	treatment_area_code	);
		if(!(practitioner_id.equals("")))	
			pstmt11.setString	(	++columnIndexSec,	practitioner_id	);
		if(!(patient_id.equals("")))	
			pstmt11.setString	(	++columnIndexSec,	patient_id	);
		if(!(priority.equals("")))	
			pstmt11.setString	(	++columnIndexSec,	priority	);
		if(!(patient_gender.equals("")))	
			pstmt11.setString	(	++columnIndexSec,	patient_gender	);

		ResultSet rs11	=	pstmt11.executeQuery();	

		while(rs11!=null && rs11.next())
		{
		  maxRecord ++;
        }
		
		if(rs11!=null) rs11.close();
		if(pstmt11!=null)			pstmt11.close();
		
		if (maxRecord==0){
		*/

		Boolean chkfrst=rs.isBeforeFirst();
		Boolean chklst=rs.isAfterLast();
		if(!chkfrst && !chklst){
		%>	
		<script>
			var tab= parent.parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.tabIndicator.value;
			if(tab=='others_tab')
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		</script>
<%
		}else{
%>

<body  onMouseDown="CodeArrest()" class='CONTENT' onKeyDown = "lockKey()"onScroll = 'scrollTitle()' >
<center>
		
<form name='AEMPSearchResultForm' id='AEMPSearchResultForm' onLoad='callShowQueryResult();'>
		
<div  id='msg' style="position:absolute;width: 0; height: 0; left: 201; top: 62">
</div>

<div  id='divTitleTable' width='100%' >
<table border='0' cellpadding='0' cellspacing='0' width='100%' id='TitleTab'>
<tr >
<td class='LABEL' align='left' nowrap >&nbsp;</td>
<td class='QueryData' align='left' nowrap >&nbsp;</td>
</tr>
</table>
<table  id='th_table'  cellpadding='0' cellspacing='0' border=1  width='100%'>

<tr>
<th width="5%" ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='selectGif' style='visibility:hidden'></th>
<th  width="10%">&nbsp;&nbsp;&nbsp;</th> 
<th width="15%" onclick ="sort('queueDate');"  style='cursor:pointer' nowrap><fmt:message key="eAE.DateTimeIn.label" bundle="${ae_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='dateGif' style='visibility:hidden'></th> 
<th width="20%" onclick ="sort('patientName');"  style='cursor:pointer' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='patNameGif' style='visibility:hidden'></th> 
<th width="20%" onclick ="sort('patientId');" style='cursor:pointer'  nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='patIdGif' style='visibility:hidden'></th> 
<th width="10%" onclick ="sort('waitingTime');" style='cursor:pointer'   nowrap><fmt:message key="Common.WaitTime.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='waitTimeGif' style='visibility:hidden'></th> 
<th width="20%" onclick ="sort('locType');"  style='cursor:pointer' nowrap><fmt:message key="Common.currentlocation.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='locTypeGif' style='visibility:hidden'></th>
	</tr>
</table>
</div>
<table border='1'  style='border-bottom:#ffffff' cellpadding='0' cellspacing='0' width='100%' id='tb1'>
<%
	String PRIORITY_STATUS="";
	String prev_header="";
	 //if ( start != 1 )
		// for( int j=1; j<start; i++,j++ )
		//{
		//	rs.next() ;
		//}   
		while ( rs!=null && rs.next() )//&& i<=end )   
		{
			classValue				=	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
			rowIndex++;
			tblrow_id				=	"tblrow_id"+rowIndex;
			patient_class = rs.getString("patient_class");
			open_to_all_pract_yn	=	(rs.getString("open_to_all_pract_yn")==null)	?	""	: rs.getString("open_to_all_pract_yn");	

			CAInstalled			=	(rs.getString("CAInstalled")==null)	?	""	: rs.getString("CAInstalled");	
			
			
			// Added for MMS-QH-CRF-0126.2 by Dharma Start
			
			action_on_pending_bill	= (rs.getString("action_on_pending_bill")==null)	?	"N"	: rs.getString("action_on_pending_bill");
			visit_num 				= rs.getString("OP_EPISODE_VISIT_NUM");
			episode_id				= rs.getString("EPISODE_ID");
			
			// Added for MMS-QH-CRF-0126.2 by End
					
			clinic_code				=	(rs.getString("locn_code")==null)	?	""	: rs.getString("locn_code");	

			p_clinic_desc			=	(rs.getString("locn_desc")==null)	?	""	: rs.getString("locn_desc");	

			clinic_type			=	(rs.getString("locn_type")==null)	?	""	: rs.getString("locn_type");	

			treatment_area_code		=	(rs.getString("treatment_area_code")==null)	?	""	: rs.getString("treatment_area_code");	
			treatment_area_desc		=	(rs.getString("treatment_area_desc")==null)	?	""	: rs.getString("treatment_area_desc");	
			triage_area				=	(rs.getString("triage_area")==null)			?	""	: rs.getString("triage_area");	

			practitioner_id			=	(rs.getString("practitioner_id")==null)		?	""	: rs.getString("practitioner_id");
			practitioner_full_name		=	(rs.getString("practitioner_full_name")==null)	?	""	: rs.getString("practitioner_full_name");
			queue_date_time			=	(rs.getString("queue_date_time")==null)		?	""	: rs.getString("queue_date_time");
			sys_date_time			=	(rs.getString("sys_date_time")==null)		?	""	: rs.getString("sys_date_time");
			patient_id				=	(rs.getString("patient_id")==null)			?	""	: rs.getString("patient_id");
			patient_name			=	(rs.getString("patient_name")==null)		?	""	: rs.getString("patient_name");
			
			encounter_id			=	(rs.getString("encounter_id")==null)		?	""	: rs.getString("encounter_id");
			waiting_time			=	(rs.getString("waiting_time")==null)		?	""	: rs.getString("waiting_time");
			queue_date				=	(rs.getString("queue_date1")==null)			?	"&nbsp;"	: rs.getString("queue_date1");	
			queue_status			=	(rs.getString("queue_status")==null)		?	""	: rs.getString("queue_status");	
			
			trauma_yn				=	(rs.getString("trauma_yn")==null)			?	""	: rs.getString("trauma_yn");	
			patient_gender			=	(rs.getString("patient_gender")==null)		?	""			: rs.getString("patient_gender");	
			brought_dead_yn			=	(rs.getString("brought_dead_yn")==null)		?	"N"	: rs.getString("brought_dead_yn");	
			service_code=	(rs.getString("service_code")==null)		?	""	: rs.getString("service_code");

			PRIORITY_STATUS=	(rs.getString("PRIORITY_STATUS")==null)		?	""	: rs.getString("PRIORITY_STATUS");

			open_to_all_prac_for_clinic_yn=	(rs.getString("open_to_all_prac_for_clinic_yn")==null)	?	""	: rs.getString("open_to_all_prac_for_clinic_yn");	
			assign_tmt_area_time	=	(rs.getString("assign_date")==null)			?	""	: rs.getString("assign_date");	

			String priority_zone1=	(rs.getString("priority_zone")==null)		?	""	: rs.getString("priority_zone");

			String curr_location=	checkForNull(rs.getString("CURR_LOCN_TYPE_DESC")) + " / " + checkForNull(rs.getString("pat_curr_locn_desc"));

			visit_type_code     =	(rs.getString("visit_type_code")==null)		?	""	: rs.getString("visit_type_code");


			StringTokenizer wt = new StringTokenizer(waiting_time,":");
            if(wt.hasMoreTokens()){
				firststring = wt.nextToken();
				secondstring = wt.nextToken();
				if(!("").equals(firststring)){
					p_waiting_time_hours	= Integer.parseInt(firststring.trim());
					p_waiting_time_hours	= p_waiting_time_hours * 60;
				}
				if(!("").equals(secondstring))
					p_waiting_time_mins		= Integer.parseInt(secondstring.trim());
				
				p_waiting_time_mins			= p_waiting_time_hours+p_waiting_time_mins;
            }
			if(waitingTimeIndYN){
				p_waiting_time	= rs.getInt("P_WAITING_TIME");
				p_waiting_time_color	= checkForNull(rs.getString("P_WAITING_TIME_COLOR"));
			}

			
		
			/*if	(priority_zone1.equals("R"))		classValuePI	=	"RESUSCITATION";
			else if(priority_zone1.equals("Y"))		classValuePI	=	"OAYELLOW";
			else if(priority_zone1.equals("G"))		classValuePI	=	"URGENT";
			else if(priority_zone1.equals("U"))		classValuePI	=	"EMERGENT";
			else classValuePI	=	classValue;*/
		
			if(!priority_zone1.equals("")){
				priority_zone_bgcolor	= (rs.getString("PRIORITY_ZONE_COLOR")==null || rs.getString("PRIORITY_ZONE_COLOR")=="")?"": rs.getString("PRIORITY_ZONE_COLOR");
			}else{
				priority_zone_bgcolor	= "";
				classValuePI			=	classValue;
			}
			
			
			
		   if(patient_name.equals(" ")) patient_name="&nbsp;";

	       String Header= p_clinic_desc +"/"+ treatment_area_desc;		
			
			if(!(Header.equals(prev_header)))
			{
				
					
	%><tr>
			<th colspan=10 align='left'  nowrap><font size=1><%=Header%></th>
			 </tr> 
	<%
				prev_header	=	Header;
			}
							
	%>		
			<tr id='<%=tblrow_id%>'>	
		
		 <td width="5%" class='<%=classValue%>' align=middle><font size=1>
   <%
	if (brought_dead_yn.equals("Y")){
   %>
    <input type="checkbox" name="<%=patient_id%>*<%=encounter_id%>*<%=service_code%>*<%=practitioner_id%>" id="<%=patient_id%>*<%=encounter_id%>*<%=service_code%>*<%=practitioner_id%>" onclick="check_checked(this,'<%=patient_id%>*<%=encounter_id%>*<%=service_code%>*<%=practitioner_id%>','<%=clinic_code%>','<%=treatment_area_code%>','<%=patient_gender%>')" disabled>
	<%}else{
if(chk_Select1.equals(patient_id+"*"+encounter_id+"*"+service_code+"*"+practitioner_id)	)
{
%>
<input type="checkbox" name="<%=patient_id%>*<%=encounter_id%>*<%=service_code%>*<%=practitioner_id%>" id="<%=patient_id%>*<%=encounter_id%>*<%=service_code%>*<%=practitioner_id%>" onclick="check_checked(this,'<%=patient_id%>*<%=encounter_id%>*<%=service_code%>*<%=practitioner_id%>','<%=clinic_code%>','<%=treatment_area_code%>','<%=patient_gender%>')" checked >
<%
}else{

%>
<input type="checkbox" name="<%=patient_id%>*<%=encounter_id%>*<%=service_code%>*<%=practitioner_id%>" id="<%=patient_id%>*<%=encounter_id%>*<%=service_code%>*<%=practitioner_id%>" onclick="check_checked(this,'<%=patient_id%>*<%=encounter_id%>*<%=service_code%>*<%=practitioner_id%>','<%=clinic_code%>','<%=treatment_area_code%>','<%=patient_gender%>')" >
<%
}
}//brought_dead_yn condition end.
%> 
</td>

			<td width="10%" class='<%=classValuePI%>' <%if(!priority_zone_bgcolor.equals("")){ %> style="background-color:<%=priority_zone_bgcolor%>"<%}%>>&nbsp;</td>
			
			<td width="15%" ondblclick ="sort('queueDate');" nowrap class='<%=classValue%>'><font size=1><%=DateUtils.convertDate(queue_date_time,"DMYHM","en",locale)%></td>
			<% 

			if (checkout_yn.equals("N"))
			{
				if (!queue_status.equals("07"))
				{
			%>
				<td width="20%" ondblclick ="sort('patientName');" class='<%=classValue%>' nowrap>
				
				<a name="desc<%=i%>" onMouseover="onMMove(msg,event,'Brought Dead Patient','<%=brought_dead_yn%>');" onMouseout="onMOut(msg,'<%=brought_dead_yn%>');" href="javascript:DummyRef()"
			onClick="showAllowedOperationsGraphic('<%=clinic_code%>', '<%=java.net.URLEncoder.encode(p_clinic_desc)%>', '<%=clinic_type%>', '<%=patient_id%>', '<%=queue_status%>', '<%=encounter_id%>', '<%=triage_area%>', '<%=trauma_yn%>', '<%=treatment_area_code%>', '<%=practitioner_id%>', '<%=java.net.URLEncoder.encode(practitioner_full_name)%>', '<%=treatment_area_desc%>', '<%=open_to_all_prac_for_clinic_yn%>', '<%=queue_date_time%>', '<%=sys_date_time%>', '<%=queue_date%>', '<%=patient_gender%>', '<%=brought_dead_yn%>', '<%=assign_tmt_area_time%>', '<%=open_to_all_pract_yn%>', '<%=patient_class%>', '<%=priority_zone1%>', '<%=brought_dead_yn%>', '<%=visit_type_code%>', '<%=pract_type%>' , '<%=visit_num%>' , '<%=episode_id%>');" >
				
			<font size=1><%=patient_name%></font></a></td>
			<%
				}
				else
				{  %>
					<td width="20%" ondblclick ="sort('patientName');"  nowrap class='<%=classValue%>'><a name='desc<%=i%>'onMouseover="onMMove(msg,event,'Brought Dead Patient','<%=brought_dead_yn%>');" onMouseout="onMOut(msg,'<%=brought_dead_yn%>');"   href='javascript:DummyRef()' 
			onClick=" CallViewPatDetails1('<%=patient_id%>','<%=encounter_id%>');" ><font size=1><%=patient_name%></a></td>	<% 
				}
			}
			else 
			{  
				if (!queue_status.equals("07"))
				{
				
			%>	
				<td  width="20%" ondblclick ="sort('patientName');" nowrap class='<%=classValue%>'><a name='desc<%=i%>'onMouseover="onMMove(msg,event,'Brought Dead Patient','<%=brought_dead_yn%>');"
			
			onMouseout="onMOut(msg,'<%=brought_dead_yn%>');" href='javascript:LoadChkOut( "<%=encounter_id%>","<%=brought_dead_yn%>","<%=treatment_area_code%>","","<%=open_to_all_prac_for_clinic_yn%>","<%=clinic_code%>","<%=open_to_all_pract_yn%>")' > <font size=1><%=patient_name%></a></td><%
				}
				else
				{ 
				%>
				<td  width="20%" ondblclick ="sort('patientName');" nowrap class='<%=classValue%>'><a name='desc<%=i%>'onMouseover="onMMove(msg,event,'Brought Dead Patient','<%=brought_dead_yn%>');" onMouseout="onMOut(msg,'<%=brought_dead_yn%>');" href='javascript:DummyRef()' 
					onClick=" CallViewPatDetails1('<%=patient_id%>','<%=encounter_id%>');"> <font size=1><%=patient_name%></a></td><%	}
			%>
			<%} if(brought_dead_yn.equals("Y")) {    %>
				
			<td width="20%" ondblclick ="sort('patientId');" class='AEDECEASED'><font size=1><%=patient_id%></td>
			<% }else { %>
				
			<td  width="20%" ondblclick ="sort('patientId');" class='<%=classValue%>'><font size=1><%=patient_id%></td>
			<%}%>
			<%if(PRIORITY_STATUS.equals("Y")){ 	%>
				
				<td width="10%" ondblclick ="sort('waitingTime');"  nowrap class='<%=classValue%>'  align='center' <%if(p_waiting_time !=0 && (p_waiting_time_mins > p_waiting_time) && !("").equals(p_waiting_time_color) && waitingTimeIndYN){%> style="background-color:<%=p_waiting_time_color%>" <%}%>><font size=1><%=waiting_time%></td>
			<%}else{ %>
				
				<td width="10%" ondblclick ="sort('waitingTime');" nowrap class='<%=classValue%>' align='center' <%if(p_waiting_time !=0 && (p_waiting_time_mins > p_waiting_time) && !("").equals(p_waiting_time_color) && waitingTimeIndYN){%> style="background-color:<%=p_waiting_time_color%>" <%}%>><font size=1><%=waiting_time%></td>

			<%}%>
	
			<td width="20%" nowrap class='<%=classValue%>'><font size=1><%=curr_location%></td>	
		</tr>
	<%
		i++;
		}
		if(rs!=null)	rs.close();
		if(pstmt!=null)	pstmt.close();
%>
<tr style='visibility:hidden'>
<th onclick ="sort('blank');" nowrap><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
<th onclick ="sort();" nowrap>&nbsp;&nbsp;&nbsp;</th>
<th onclick ="sort('queueDate');" nowrap><fmt:message key="eAE.DateTimeIn.label" bundle="${ae_labels}"/></th>
<th onclick ="sort('patientName');" nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
<th onclick ="sort('patientId');" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
<th onclick ="sort('waitingTime');" nowrap><fmt:message key="Common.WaitTime.label" bundle="${common_labels}"/></th>
<th onclick ="sort('locType');" nowrap><fmt:message key="Common.currentlocation.label" bundle="${common_labels}"/></th>
</tr>
</table>
<input type='hidden' name='CAInstalled' id='CAInstalled' value='<%=CAInstalled%>'>

<!--Added for MMS-QH-CRF-0126.2 by Dharma Start-->
<input type='hidden' name='action_on_pending_bill' id='action_on_pending_bill' value='<%=action_on_pending_bill%>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
<!--Added for MMS-QH-CRF-0126.2 by Dharma End-->

<input type='hidden' name='queue_date' id='queue_date' value='<%=queue_date%>'>
<input type="hidden" name="chk_Select" id="chk_Select" value="">
<script>
	
hideAllGifs('pseudo');
toggleGifs('<%=orderCriteria%>','<%=asc_desc%>');
</script>
<%
	  
	  
	  }
	if(rs!=null)	rs.close();
	if(pstmt!=null)	pstmt.close();
	}
	catch(Exception e)
	{
			e.printStackTrace();
	}
	finally
	{
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>


</form>
</center>
</body>

<script>
//alignHeading1();
</script>

</html>

	<%
}catch(Exception e)
{
	e.printStackTrace();
} 
%>
<%!
public String specialCharacter(String single){
				int i=0;
				
				
		if(( single.indexOf('\'', i)!=-1)){
			single=(String)single.replace('\'',' ');
		}
	

		return single ;
			
			}	

%>

<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
	}
	public static String checkForNull(String inputString, String defaultValue) {
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}

%>

