<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*,java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*,eCommon.Common.*,eAE.*, org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%! public StringBuffer getStatistics(PageContext pageContext,Connection con,String facility_id,String clinic_type,String clinic_code,String treatment_area_code, String include_checkedout) throws java.sql.SQLException    
	{  
		StringBuffer tmt_area_statistics= null;
		StringBuffer queryStat = new StringBuffer();

        queryStat.append("SELECT SUM(DECODE(queue_status,'01',1,0)) Checked_In, SUM(CASE WHEN QUEUE_STATUS='02' AND CONS_SRVC_START_DATE_TIME IS NULL AND CONS_SRVC_END_DATE_TIME IS NULL THEN 1 ELSE 0 END) Assigned_to_Treat_Area, SUM(CASE WHEN (CONS_SRVC_START_DATE_TIME IS NOT NULL AND CONS_SRVC_END_DATE_TIME IS NULL) or queue_status = '03' THEN 1 ELSE 0 END) Undergoing_Treat, SUM(DECODE(CONS_SRVC_END_DATE_TIME,NULL,0,1)) Consulted, SUM(1) Total_Patients,SUM(DECODE(queue_status,'07',1,0)) tot_checked_out FROM op_patient_queue ");
		queryStat.append(" where facility_id = ? and patient_class = 'EM' and queue_status != '99' ");
		queryStat.append(" and trunc(queue_date) = trunc(sysdate) and  ");
		queryStat.append(" locn_type = ? and locn_code = ?  ");
		if (treatment_area_code!="")
		queryStat.append(" and treatment_area_code = ?  ");
		else
		queryStat.append(" and treatment_area_code is null ");


      	int tot_Checked_In			=	0;
		int tot_Assig_to_Treat_Area	=	0; 
		int tot_Undergoing_Treat	=	0;
		int tot_Consulted	=	0;
		int tot_checked_out	=	0;
		int total_patients = 0; 

		PreparedStatement pstmt	=	con.prepareStatement(queryStat.toString());

		pstmt.setString	(	1,	facility_id	);
		pstmt.setString	(	2,	clinic_type	);
		pstmt.setString	(	3,	clinic_code	);
		if (treatment_area_code!="")
		pstmt.setString	(	4,	treatment_area_code);
		ResultSet rs =	pstmt.executeQuery();
		if(rs.next())
		{
			tot_Checked_In			=	rs.getInt("Checked_In");
			tot_Assig_to_Treat_Area	=	rs.getInt("Assigned_to_Treat_Area"); 
			tot_Undergoing_Treat	=	rs.getInt("Undergoing_Treat");
			tot_Consulted			=	rs.getInt("Consulted");
			total_patients			=   rs.getInt("Total_Patients");
			tot_checked_out         =   rs.getInt("tot_checked_out");
		}
		if(rs!=null) rs.close();
		if(pstmt!=null)			pstmt.close();
		if((queryStat != null) && (queryStat.length() > 0))
		{
			queryStat.delete(0,queryStat.length());
		}

		tmt_area_statistics=  new StringBuffer();
		tmt_area_statistics.append(" ( "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedIn.label","common_labels")+" : "+tot_Checked_In+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AssignedtoTreatmentArea.label","ae_labels")+" : "+tot_Assig_to_Treat_Area+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.UndergoingTreatment.label","ae_labels")+" : "+tot_Undergoing_Treat+"  "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.Consulted.label","ae_labels")+" : "+tot_Consulted+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.NoofPatients.label","ae_labels")+" : " +total_patients+" )");
		return tmt_area_statistics;

	}
	/*Commented below method and added it in AECommonBean.java --against ML-MMOH-CRF-0658 on 10th May 2018*/
	//Maheshwaran K added for the HSA-CRF-318
	//Start
	/*	public ArrayList getFieldOrder(Connection con,String facility_id,String user_id ) throws java.sql.SQLException 
	{  
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		ArrayList fields = new ArrayList();
		int recCnt = 0 ;
		
		String fid="";
		String uid="";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select count(*) from AE_CURR_EMERG_PAT_RESULT where Facility_id='"+facility_id+"' and User_id='"+user_id+"'");

			if ((rs != null) && (rs.next()) )
			{
				recCnt = rs.getInt(1);
			}
			
			
			if (recCnt == 0) 
			{
				uid="*ALL";
				fid="DF";
			}
			else
			{
				uid=user_id;
				fid=facility_id;
			}

			pstmt1	=	con.prepareStatement("select field_name from AE_CURR_EMERG_PAT_RESULT where facility_id = ? and user_id = ? order by field_order asc");

			pstmt1.setString(1,fid);
			pstmt1.setString(2,uid);
	
			rs1 =	pstmt1.executeQuery();

			while (rs1.next())
			{
				fields.add(rs1.getString("field_name"));
			}

		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(rs1!=null) rs1.close();
			if(pstmt1!=null)	pstmt1.close();
			if(stmt!=null)	stmt.close();
		
			if(rs!=null) rs.close();
		}
		//The fields are added to the list in the order of their display
		return fields;
		}*/
		//End
%>
<html>
<head>


<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String queue_refresh_interval = "";
/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
String pend_ord_stats	= "N";
String chk_for_pen_orders_bfr_chkout	= "N";
String checkout_allow_yn	= "N";
/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eAE/js/AEUtilities.js'></script>
<script language='javascript' src='../../eAE/js/AEManagePatient.js'></script>
<script language='javascript' src='../../eAE/js/AEPatientByCriteria.js'></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	Connection con				=	null;
	PreparedStatement pstmt		=	null;
	ResultSet rs				=	null;
	ResultSet rs1			    =   null;
	int maxDispRecords			=	6;
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale			= (String)session.getAttribute("LOCALE");
	String loginUser			= checkForNull((String)session.getValue("login_user"));
	
	Properties p=(java.util.Properties) session.getValue("jdbc"); //Added for this CRF ML-MMOH-CRF-0637

	String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String	facility_id				=	"";
	String	clinic_code				=	"";
	String	practitioner_id			=	"",		practitioner_name		=	"" ; 
    String	practitioner_full_name	=	"";
	String	patient_id				=	"",		patient_name			=	"";
	String	waiting_time			=	"",		queue_status			=	"";
	String	queue_status_desc		=	"",		classValue				=	"";
	StringBuffer queue_status_desc1 = new StringBuffer();
	String	treatment_area_code		=	"";
	String	treatment_area_desc		=	"",		triage_area				=	"";
	String	classValuePI			=	"";
	String	oper_stn_id				=	"",		queue_date				=	"";
	String	encounter_id			=	"",		clinic_type				=	"";
	String	patient_gender			=	"",		include_checkedout		=	"";
	String	order_by_priority		=	"";
	String	priority				=	"";
	String	trauma_yn				=	"";
	String	tblrow_id				=	"",		queue_date_time			=	"";
	String	sys_date_time			=	"",		checkout_yn				=	"";
	String	sys_date				=	"",		brought_dead_yn			=	"";
	String  curr_location="";
	String	from 					=	"",		to 						=	"";
	String	assign_tmt_area_time	=	"";
	String	p_clinic_desc	= "";
	String	open_to_all_pract_yn	=	"";
	String  priority_status			=	"",		priority_zone			=	"";
	String	bed_no					=	""; 
	String CAInstalled              =   "";
	String disaster_yn = "";
	String CaseofTrauma_val = "";
	String sys_date_time_1="";
	String sys_date2="";
	String bed_bay_type="";
	String PAT_PRIORITY_DESC="";
	String min_age_for_lmp="";
	String end_date = "";
	String start_date="";
	String dis_regn_reference="";
	String  dis_regn_remarks="";
	//StringBuffer sqlPatQ        = new StringBuffer();
	StringBuffer whereClause    = new StringBuffer();
	StringBuffer orderByClause  = new StringBuffer();
	StringBuffer byObserveId_criteria  = new StringBuffer();
	StringBuffer byObserveId_criteria1  = new StringBuffer();

	StringBuffer sqlPatQ1        = new StringBuffer();
	StringBuffer whereClause1   = new StringBuffer();
	StringBuffer orderByClause1  = new StringBuffer();

	String observe_id="";
	String oberv_clinc_code="";
	String oberv_TMT_code="";

	String check_in_date_time = "";
	String assign_tmt_area_time1 = "";
	String treatment_start_time = "";
	String cons_srvc_start_date_time = "";
	String cons_srvc_end_date_time = "";
	String TRIAGE_DATE_TIME="";
	String p_cutoff_hours_prv_day_visit = "";
	String visit_type_code = "";
	String pract_type      = "";
	String firststring     = "";
    String secondstring   = "";
	String record_vital_signs_yn = "";
	String enable_rights_yn="";
	String pract_type1="";
	String sel_triage_yn="";
	String sel_cons_yn="";
	String rowid="";
	String nursing_unit_code="";
	String allow_chkout_with_bill_stmt_yn ="N";
	String visit_num = "";
	String priority_zone1="";
    ArrayList temp=new ArrayList();
	String action_on_pending_bill	= "N";
	String reg_new_born_yn	= "N"; //Added by Dharma on Aug 1st 2017 against ML-MMOH-CRF-0631 [IN:062148]
	String inv_reg_new_born_yn	= "N"; //Added by Dharma on Aug 1st 2017 against ML-MMOH-CRF-0631 [IN:062148]
	
	String register_reattance_hours="";// Added for this CRF ML-MMOH-CRF-0639
	int reattance_hours=0;

	Boolean isStartConsultationAppl = false;//Added by Thamizh selvi on 3rd Oct 2017 for ML-MMOH-CRF-0623
	
	Boolean isVIPimgpatfrontappl = false;//Added by Mujafar against ML-MMOH-CRF-1070
	
	
	
	
	Boolean isLengthOfStayAppl = false; // added by mujafar for ML-MMOH-CRF-1194  
	String stay_time=""; // added by mujafar for ML-MMOH-CRF-1194

	/*Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658 Start*/
	Boolean isPendingForAdmissionAppl	= false;
	String pendngAdmDateTime			= "";
	String forAdmWaitngTime				= "";
	String forAdmWaitString1			= "";
	String forAdmWaitString2			= "";
	JSONObject fieldOrderJSON			= new JSONObject();
	/*End*/
	
	String stay_time_1 = ""; // added by mujafar for ML-MMOH-CRF-1194
	String stay_time_2 = ""; // added by mujafar for ML-MMOH-CRF-1194

	String	open_to_all_prac_for_clinic_yn	=	"";
	String patient_class = "";
	String prev_visit = "";
	int		rowIndex				=	1,		columnIndex				=	1;
	int		maxRecord				=	0,		i						=	1;
	int		start					=	0,		end						=	0;
	int max = 0;
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014 Start*/
	String five_level_triage_appl_yn	=  (request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");
	String priority_zone_bgcolor		= "";
	String priority_zone_all_codes		= (request.getParameter("priority_zone_all_codes")==null || request.getParameter("priority_zone_all_codes")=="")?"":request.getParameter("priority_zone_all_codes");

	StringBuilder priority_zone_order	 = new StringBuilder();
	if(!priority_zone_all_codes.equals("")){
		if (priority_zone_all_codes.length() > 0 && priority_zone_all_codes.charAt(priority_zone_all_codes.length()-1)==',') {
			priority_zone_all_codes = priority_zone_all_codes.substring(0, priority_zone_all_codes.length()-1);
		}
		
		String[] priority_zone_split = priority_zone_all_codes.split(",");
		for (int  x= 0; x < priority_zone_split.length; x++) {
			priority_zone_order.append("'"+priority_zone_split[x]+"',"+(x+1));
			if (x!= priority_zone_split.length - 1) {
		    	priority_zone_order.append(",");
		    }
		}
		
	}

	
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 28th 2014 End*/
	
	from							=	request.getParameter("from") ;
	to								=	request.getParameter("to") ;
	
//for age
	String year_value				=	"";
	String month_value				=	"";
	String day_value				=	"";
	String complaint_code			=	"";
	String COMPLAINT_DESC			=	"";
	String ret_str					=	"";
	String episode_id               =	"";

	if ( from == null ||from.equals(""))
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null ||to.equals("") )
	  	end = maxDispRecords ;
	else
		end = Integer.parseInt( to ) ;  


/************************/
String orderCriteria	=	(request.getParameter("orderCriteria")==null)	? "queueDate" : request.getParameter("orderCriteria");
String asc_desc	=	(request.getParameter("asc_desc")==null)	? " asc" : request.getParameter("asc_desc");

priority_zone	=	(request.getParameter("priority_zone")==null)	? "" : request.getParameter("priority_zone"); 
priority_zone1	=	(request.getParameter("priority_zone")==null)	? "" : request.getParameter("priority_zone");
String maxRcd = request.getParameter("maxRcd")==null?"":request.getParameter("maxRcd");
if(!maxRcd.equals(""))
 max = Integer.parseInt(maxRcd);

String ch_id	=	(request.getParameter("ch_id")==null)	? "" : request.getParameter("ch_id");  
 if(ch_id.equals("Y")) {
	 ret_str		=	(request.getParameter("ch_x")==null)?"":request.getParameter("ch_x");
	 
	 if(ret_str.length()>0) {
		ret_str=ret_str.substring(0,ret_str.length()-3).trim() ;
		 if(ret_str.indexOf("[")!=-1) {
			ret_str=ret_str.substring(1,ret_str.length()).trim() ;
		}
		 if(ret_str.indexOf("]")!=-1) {
				ret_str=ret_str.substring(0,ret_str.length()-1).trim() ;
		}
     }
}
	try
	{ 
		con				=	(Connection)	ConnectionManager.getConnection(request);
		
		//Added by Ashwini on 20-Apr-2017 for ML-MMOH-CRF-0635
		Boolean sortPriorityZoneTab = CommonBean.isSiteSpecific(con, "AE", "SORT_PRIORITY_ZONE_TAB");
		//Added by Ashwini on 26-Apr-2017 for ML-MMOH-CRF-0641
		Boolean isDisplayAllRemarks = CommonBean.isSiteSpecific(con, "AE", "SEC_TRG_AND_DIS_REG_REMARKS");

		//Added by Mano on 24-Apr-2017 for ML-MMOH-CRF-0644
		boolean allowSplChar =eCommon.Common.CommonBean.isSiteSpecific(con, "AE","ALLOW_SPLCHAR_DISASTERREF");
		//Added by Sangeetha for ML-MMOH-CRF-0636 on 26/apr/2017
		Boolean sortByPriorityZone = CommonBean.isSiteSpecific(con, "AE", "SORT_BY_PRIORITY_ZONE");

		isStartConsultationAppl = CommonBean.isSiteSpecific(con, "AE", "AE_START_CONSULTATION");//Added by Thamizh selvi on 3rd Oct 2017 for ML-MMOH-CRF-0623
		isLengthOfStayAppl      = CommonBean.isSiteSpecific(con, "AE", "LENGTH_OF_STAY_APPL"); // added by mujafar for ML-MMOH-CRF-1194
		
		isVIPimgpatfrontappl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA","VIP_IMG_PAT_NAME_FRONT_APPL");//Added by Mujafar against ML-MMOH-CRF-1070
		
		String disp="";
		String disp_val=""; // added by mujafar for ML-MMOH-CRF-1194
		
		if(isLengthOfStayAppl)
			disp="style=\'display:none'";
		isPendingForAdmissionAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_PENDING_FOR_ADMISSION_TAB");//Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658

		facility_id		=	(String)		session.getValue("facility_id");
		//ArrayList fieldOrder = getFieldOrder(con, facility_id, loginUser ) ;//Maheshwaran K added for the HSA-CRF-318
		/*Commented above line and added below lines by Thamizh selvi on 10th May 2018 against ML-MMOH-CRF-0658 Start*/
		fieldOrderJSON = eAE.AECommonBean.getFieldOrder(con, facility_id, loginUser);
		ArrayList fieldOrder = (ArrayList) fieldOrderJSON.get("fieldNames");
		/*End*/

		//Below line added for this CRF ML-MMOH-CRF-0637
		Boolean registerattendance = CommonBean.isSiteSpecific(con, "AE", "RE_ATTENDANCE");		
		int clspanval=fieldOrder.size();//Modified by Thamizh selvi on 9th May 2018 against ML-MMOH-CRF-0658
		String tdwidth="6%";
		if(registerattendance){
		//clspanval="18";
		tdwidth="4%";
		}
		/*Added By Dharma against ML-MMOH-CRF-0627 [IN:062144] on 10th Apr 2018 Start*/
		 Boolean waitingTimeIndYN			=	CommonBean.isSiteSpecific(con, "AE", "WAITING_TIME_INDICATOR");
		 int p_waiting_time					= 0;
		 String p_waiting_time_color		= "";
		 int p_waiting_time_hours			= 0;
		 int p_waiting_time_mins			= 0;
		  
		 /*Added By Dharma against ML-MMOH-CRF-0627 [IN:062144] on 10th Apr 2018 End*/
		long diff=0;
		//End this CRF ML-MMOH-CRF-0637		

		
		//Added for this CRF ML-MMOH-CRF-0639
		
		register_reattance_hours=AEReattendanceEncounterDetails.getAEReattendanceDetails(con,facility_id,p);
		if(!register_reattance_hours.equals(""))reattance_hours=Integer.parseInt(register_reattance_hours);
		//End ML-MMOH-CRF-0639
		
		p_cutoff_hours_prv_day_visit = checkForNull(request.getParameter("p_cutoff_hours_prv_day_visit"));
		prev_visit          =	checkForNull(request.getParameter("prev_visit"));
		oper_stn_id			=	checkForNull(request.getParameter("oper_stn_id"));
		clinic_code			=	checkForNull(request.getParameter("clinic_code"));
		clinic_type			=	checkForNull(request.getParameter("clinic_type"));
		nursing_unit_code	=	checkForNull(request.getParameter("nursing_unit_code"));
		treatment_area_code	=	checkForNull(request.getParameter("treatment_area_code"));
		practitioner_id		=	checkForNull(request.getParameter("practitioner_id"));
		patient_id			=	checkForNull(request.getParameter("patient_id"));
		priority			=	checkForNull(request.getParameter("priority"));
		patient_gender		=	checkForNull(request.getParameter("gender"));
		include_checkedout	=	checkForNull(request.getParameter("include_checkedout"));
		if(include_checkedout.equals("")) include_checkedout="N";
		order_by_priority	=	checkForNull(request.getParameter("order_by_priority"));
		checkout_yn			=	checkForNull(request.getParameter("checkout_yn"));
		if(checkout_yn.equals("")) checkout_yn="N";
    	priority_status		=	checkForNull(request.getParameter("priority_zone"));	bed_bay_type        =	checkForNull(request.getParameter("bed_bay_type"));
		observe_id				=	checkForNull(request.getParameter("observ_id"));
	    oberv_clinc_code		=	checkForNull(request.getParameter("oberv_clinc_code"));
	    oberv_TMT_code	=	checkForNull(request.getParameter("oberv_TMT_code"));

		
		if(isLengthOfStayAppl && priority_status.equals("")) // added by mujafar for ML-MMOH-CRF-1194
		{
			disp_val="style=\'display:none' ";
			
		}

		PreparedStatement  aepstmt			=	con.prepareStatement("select TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi') end_date,       TO_CHAR (SYSDATE - (DECODE (visit_backdating_allowed_yn, 'Y', max_hours_allow_insert, 0) * 60) / 1440,'dd/mm/yyyy hh24:mi'          ) start_date, min_age_for_lmp,queue_refresh_interval,to_char(sysdate ,'hh24:mi') hmin,record_vital_signs_yn,		CUTOFF_HOURS_PRV_DAY_VISIT,ENABLE_ACCS_RIGHTS_IN_QUEUE,allow_chkout_with_bill_stmt_yn,(select install_yn from sm_module where module_id='CA') CAInstalled,action_on_pending_bill,inv_reg_new_born_yn,chk_for_pen_orders_bfr_chkout,checkout_allow_yn  from ae_param where operating_facility_id = ? ");
		aepstmt.setString	(	1,	facility_id		);
		rs1 = aepstmt.executeQuery();

		if(rs1!= null &&  rs1.next() )
		{
			queue_refresh_interval = rs1.getString("queue_refresh_interval")==null?"0":rs1.getString("queue_refresh_interval");
			min_age_for_lmp=rs1.getString("min_age_for_lmp")==null?"":rs1.getString("min_age_for_lmp");
			sys_date	=	rs1.getString("hmin");
			record_vital_signs_yn =	rs1.getString("record_vital_signs_yn");
			p_cutoff_hours_prv_day_visit = rs1.getString("CUTOFF_HOURS_PRV_DAY_VISIT");
			enable_rights_yn=checkForNull(rs1.getString("ENABLE_ACCS_RIGHTS_IN_QUEUE"));
			allow_chkout_with_bill_stmt_yn =checkForNull(rs1.getString("allow_chkout_with_bill_stmt_yn"));
			end_date =checkForNull(rs1.getString("end_date"));
			start_date =checkForNull(rs1.getString("start_date"));
			CAInstalled = checkForNull(rs1.getString("CAInstalled")); 
			action_on_pending_bill	= rs1.getString("action_on_pending_bill");
			inv_reg_new_born_yn	= rs1.getString("inv_reg_new_born_yn");
			/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
			chk_for_pen_orders_bfr_chkout =checkForNull(rs1.getString("chk_for_pen_orders_bfr_chkout"),"N");
			checkout_allow_yn =checkForNull(rs1.getString("checkout_allow_yn"),"N");
			/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/
		} 
		
       if(rs1!=null) rs1.close();
	   if(aepstmt!=null)			aepstmt.close();

	    if(enable_rights_yn.equals("Y")){
		String pract_sql="select  b.pract_type pract_type from sm_appl_user a,am_practitioner b where a.appl_user_id = ? and a.func_role_id = b.practitioner_id";
		PreparedStatement  prpstmt=con.prepareStatement(pract_sql);
		prpstmt.setString	(1,loginUser);
		rs1 = prpstmt.executeQuery();
		if(rs1!= null &&  rs1.next() ){
			pract_type1=checkForNull(rs1.getString("pract_type"));
		}
		if(rs1!=null) rs1.close();
		if(prpstmt!=null)			prpstmt.close();
		if(!(pract_type1.equals(""))){
		String access_rights_sql="select SEC_TRIAG_YN,CONS_YN,REG_NEW_BORN_YN from AE_ACCS_RIGHTS_BY_PRAC_TYPE where pract_type =?";//REG_NEW_BORN_YN Added by Dharma on Aug 1st 2017 against ML-MMOH-CRF-0631 [IN:062148]
		PreparedStatement  acc_pstmt=con.prepareStatement(access_rights_sql);
		acc_pstmt.setString	(1,pract_type1);
		rs1 = acc_pstmt.executeQuery();
		if(rs1!= null &&  rs1.next() ){
			sel_triage_yn=rs1.getString("SEC_TRIAG_YN");
			sel_cons_yn=rs1.getString("CONS_YN");
			reg_new_born_yn=rs1.getString("REG_NEW_BORN_YN");//Added by Dharma on Aug 1st 2017 against ML-MMOH-CRF-0631 [IN:062148]
		}
		if(rs1!=null) rs1.close();
		if(acc_pstmt!=null)			acc_pstmt.close();
		}
	  }	

		if(!(clinic_code.equals("")))			whereClause1.append(" and a.locn_code = ? and a.locn_type = ? ");
		if(!(treatment_area_code.equals(""))){
			whereClause1.append(" and a.treatment_area_code = ? ");
			}
        if(!(bed_bay_type.equals(""))){
			whereClause1	.append(" and d.bay_type_code = ? ");
			}
		if(!(practitioner_id.equals("")))		whereClause1.append(" and a.practitioner_id = ? ");
		if(!(patient_id.equals("")))			whereClause1.append(" and a.patient_id = ? ");
		if(!(priority.equals("")))				whereClause1.append(" and a.priority_indicator = ? ");
		if(!(patient_gender.equals("")))		whereClause1.append(" and b.sex = ? ");
		if(include_checkedout.equals("Y"))		whereClause1.append(" and a.queue_status <= '07' ");
		if(include_checkedout.equals("N"))		whereClause1.append(" and a.queue_status < '07' ");
		/*Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start*/
		/*if(priority_status.equals("R"))		whereClause1.append(" and a.priority_zone = 'R' ");
		if(priority_status.equals("Y"))		whereClause1.append(" and a.priority_zone = 'Y' ");
		if(priority_status.equals("G"))		whereClause1.append(" and a.priority_zone = 'G' ");
		if(priority_status.equals("U"))		whereClause1.append(" and a.priority_zone = 'U' ");*/
		if(!priority_status.equals("")){
			/*Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658 Start*/
			if(priority_status.equals("for_admission"))
				whereClause1.append(" and a.PENDNG_ADMISSION_DATE_TIME IS NOT NULL ");
			else if(priority_status.equals("observe") && isLengthOfStayAppl )
			{
			whereClause1.append("");
			
			}
			
			else/*End*/
				whereClause1.append(" and a.priority_zone = '"+priority_status+"' ");
		}
		/*Modified For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End*/
		
		
/*******order by creation logic**********************/
if(!priority_zone_order.toString().equals("") && five_level_triage_appl_yn.equals("Y")){
	orderByClause1.append(" DECODE(priority_zone,"+priority_zone_order.toString()+")asc,queue_date_time desc ");
}

/*Added by Thamizh selvi on 15th May 2018 against ML-MMOH-CRF-1029 Start*/
if(orderByClause1.length() > 0){
	orderByClause1.append(" , ");
}
if(priority_status.equals("for_admission") && orderCriteria.equals("")){
	orderCriteria="zone" ;
}else{
	if(orderCriteria.equals("")) orderCriteria="queueDate" ;
}/*End*/

if(!priority_status.equals("for_admission")){//Added by Thamizh selvi on 15th May 2018 against ML-MMOH-CRF-1029
		//Added by Ashwini on 20-Apr-2017 for ML-MMOH-CRF-0635
		if(sortPriorityZoneTab)
		{
		//	if(priority_zone.equals("R") || priority_zone.equals("Y") || (!observe_id.equals("")) )
			//{
		//	orderByClause1.append("a.AE_BED_NO");
			//}else
			//{ commented by mujafar for ML-MMOH-CRF-1194
			orderByClause1.append(" locn_desc,treatment_area_code,practitioner_name ");
			//}
		}else
		{
		orderByClause1.append(" locn_desc,treatment_area_code ");
		}
}

/*Added by Thamizh selvi on 15th May 2018 against ML-MMOH-CRF-1029 Start*/	
if(orderCriteria.matches("practitioner||queueDate||bed_no||patientName||patientId||age||status||priorityZone||waitingTime||zone||for_admission")){
	if(orderByClause1.length() > 0) orderByClause1.append(" , ");
	/*End*/
	if(orderCriteria.equals("practitioner"))
			{
				orderByClause1.append("practitioner_name"+asc_desc+" ");
			}
	else if(orderCriteria.equals("queueDate"))
			{
				orderByClause1.append("queue_date_time ");
				orderByClause1.append(""+asc_desc+" ");
			}
			else if(orderCriteria.equals("bed_no"))
			{
				//Added by Ashwini on 20-Apr-2017 for ML-MMOH-CRF-0635
				if(sortPriorityZoneTab)
				{
					if(priority_zone.equals("Y") || priority_zone.equals("R") || (!observe_id.equals("")) )
					{
					orderByClause1.append(""+asc_desc+" ");
					}else
					{
					orderByClause1.append("a.AE_BED_NO ");
					orderByClause1.append(""+asc_desc+" ");
					}
				}else
				{
				orderByClause1.append("a.AE_BED_NO ");
				orderByClause1.append(""+asc_desc+" ");
				}
			}
	else if(orderCriteria.equals("patientName"))
			{
				orderByClause1.append("b.patient_name"+asc_desc+" ");
			}
	else if(orderCriteria.equals("patientId"))
			{
				orderByClause1.append("a.patient_id"+asc_desc+" ");
			}

	else if(orderCriteria.equals("age"))
			{
				orderByClause1.append("year "+asc_desc+" ");
			}

	else if(orderCriteria.equals("status"))
			{
				orderByClause1.append("a.QUEUE_STATUS"+asc_desc+" ");
			}

	else if(orderCriteria.equals("priorityZone"))
			{
				orderByClause1.append(" PAT_PRIORITY_DESC"+asc_desc+" ");
			}
	else if(orderCriteria.equals("waitingTime"))
			{
				orderByClause1.append("a.QUEUE_DATE ");
				orderByClause1.append(""+asc_desc+" ");
			}
	//Added by Sangeetha on 26/apr/17 for ML-MMOH-CRF-0636
	else if(orderCriteria.equals("zone"))
			{
				if(asc_desc.equals(" asc")){
					orderByClause1.append("DECODE(a.PRIORITY_ZONE, 'G', 1, 'Y', 2, 'R', 3, 'U', 4) ASC");
				} else if(asc_desc.equals(" desc")){
					orderByClause1.append("DECODE(a.PRIORITY_ZONE, 'R', 1, 'Y', 2, 'G', 3, 'U', 4) ASC");
				}
				
				/*Added by Thamizh selvi on 15th May 2018 against ML-MMOH-CRF-1029 Start*/
				if(priority_status.equals("for_admission"))
					orderByClause1.append(",queue_date_time DESC");
				/*End*/
				
			}
	/*Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658 Start*/
	else if(orderCriteria.equals("for_admission")){
		orderByClause1.append(" PENDNG_ADMISSION_DATE_TIME ");
		orderByClause1.append(""+asc_desc+" ");
	}/*End*/	

}

/*Added by Thamizh selvi on 15th May 2018 against ML-MMOH-CRF-1029 Start*/
if(priority_status.equals("for_admission") && orderCriteria.equals("locType")){
	orderByClause1.append(" locn_desc ");
	orderByClause1.append(""+asc_desc+" ");
}/*End*/			
  
/**********orderby logic ends**************/		
			if(!prev_visit.equals("") )	
			{
				whereClause1.append(" and (a.check_in_date_time between trunc(SYSDATE) -((1/(24*60*60))*3600*'"+p_cutoff_hours_prv_day_visit+"') and trunc(sysdate)) ");
			}
			else
			{
				//whereClause1.append(" and (a.check_in_date_time between SYSDATE-1  and sysdate)");
				/*Above line commented and below line added for this ML-MMOH-CRF-0639*/
				whereClause1.append(" AND SYSDATE BETWEEN a.check_in_date_time AND (("+reattance_hours+"/24)+(a.check_in_date_time))");
				//End this CRF ML-MMOH-CRF-0639
				
				
			}

			whereClause1.append(" and  (a.locn_type, a.locn_code) in  (select locn_type, locn_code from  am_os_user_locn_access_vw  where facility_id = '"+facility_id+"' and Oper_stn_id ='"+oper_stn_id+"' and  appl_user_id ='"+loginUser+"' ");
		
		whereClause1.append((checkout_yn.equals("Y"))?"and checkout_pat_yn = 'Y'":"and manage_queue_yn = 'Y' ");

		whereClause1.append(" )");    


	      sqlPatQ1.append("select a.rowid row_id,a.locn_code, c.long_desc locn_desc, a.locn_type, a.treatment_area_code, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,a.LOCN_CODE,a.TREATMENT_AREA_CODE,'"+locale+"' ,'2') treatment_area_desc, (CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT DECODE (triage_area_yn, 'Y', 'B', 'N', 'C', '', 'A' ) FROM ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ) triage_area, c.open_to_all_pract_yn,  a.practitioner_id, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'2') practitioner_name, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'1') practitioner_full_name, a.priority_indicator, to_char(a.queue_date,'dd/mm/yyyy hh24:mi') queue_date_time, to_char(a.check_in_date_time,'dd/mm/yyyy hh24:mi') check_in_date_time, to_char(a.ASSIGN_TMT_AREA_TIME,'dd/mm/yyyy hh24:mi') ASSIGN_TMT_AREA_TIME, to_char(a.TREATMENT_START_TIME,'dd/mm/yyyy hh24:mi') TREATMENT_START_TIME,				TO_CHAR(b.date_of_birth,'dd/mm/yyyy') date_of_birth,	CALCULATE_AGE(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),1) year,		CALCULATE_AGE(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),2) months,		CALCULATE_AGE(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),3) days,		to_char(a.CONS_SRVC_START_DATE_TIME,'dd/mm/yyyy hh24:mi') CONS_SRVC_START_DATE_TIME,to_char(a.TRIAGE_DATE_TIME,'dd/mm/yyyy hh24:mi') TRIAGE_DATE_TIME, to_char(a.CONS_SRVC_END_DATE_TIME,'dd/mm/yyyy hh24:mi') CONS_SRVC_END_DATE_TIME, to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time, to_char(sysdate-1,'dd/mm/yyyy') sys_date_time_1, to_char(sysdate,'dd/mm/yyyy') sys_date, a.patient_id, (decode('"+locale+"' ,'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))) patient_name, b.sex patient_gender, AM_GET_DESC.AM_COMPLAINT(a.COMPLAINT_CODE,'"+locale+"' ,'1') COMPLAINT_DESC, a.encounter_id,get_waiting_time(NVL (a.cons_srvc_start_date_time, SYSDATE), queue_date) waiting_time, to_char(a.queue_date,'dd/mm/yyyy') queue_date1, to_char(a.assign_tmt_area_time,'dd/mm/yyyy hh24:mi') assign_date, a.queue_status,  a.queue_status queue_status_desc, a.trauma_yn, a.brought_dead_yn, NVL((CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT open_to_all_prac_for_clinic_yn FROM  ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ),'N') open_to_all_prac_for_clinic_yn, 'EM' patient_class, a.priority_zone, a.visit_type_code,  a.AE_BED_NO bed_no, a.dis_regn_reference,a.dis_regn_remarks,a.disaster_yn, a.TRAUMA_YN, a.PAT_CURR_LOCN_TYPE, AM_GET_DESC.AM_CARE_LOCN_TYPE(a.PAT_CURR_LOCN_TYPE,'"+locale+"' ,'2') CURR_LOCN_TYPE_DESC, DECODE (a.pat_curr_locn_type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.pat_curr_locn_code,'"+locale+"' ,'2'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(a.facility_id, a.pat_curr_locn_code,'"+locale+"' ,'2'),                       OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.pat_curr_locn_code,'"+locale+"' ,'1')) pat_curr_locn_desc, AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,'"+locale+"' ,'2') PAT_PRIORITY_DESC,(SELECT max(complaint_id) FROM ca_encntr_chief_complaint x WHERE encounter_id = a.encounter_id and facility_id=a.facility_id)complaint_code ,a.episode_id, a.OP_EPISODE_VISIT_NUM, ");  // added by mujafar for HSA-CRF-0240 on 2/4/2015
	      // modified by mujafar for ML-MMOH-CRF-1194
		  
		   if(include_checkedout.equals("Y"))  // modified by mujafar for ML-MMOH-CRF-1194
				sqlPatQ1.append("  get_waiting_time ( NVL (a.DISCHARGE_DATE_TIME,SYSDATE),queue_date) stay_time ");
		  else
				sqlPatQ1.append("  get_waiting_time ( SYSDATE,queue_date) stay_time ");
		  
		  
		
		  /*Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658 Start*/
		  if(include_checkedout.equals("Y"))
				sqlPatQ1.append(", to_char(a.PENDNG_ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') pendngAdmDateTime, get_waiting_time(NVL (a.DISCHARGE_DATE_TIME, SYSDATE), a.PENDNG_ADMISSION_DATE_TIME) pendngForAdmissionTime ");
		  else
				sqlPatQ1.append(", to_char(a.PENDNG_ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') pendngAdmDateTime, get_waiting_time(SYSDATE, a.PENDNG_ADMISSION_DATE_TIME) pendngForAdmissionTime ");
		  /*End*/

		//sqlPatQ1.append("select a.rowid row_id,a.locn_code, c.long_desc locn_desc, a.locn_type, a.treatment_area_code, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,a.LOCN_CODE,a.TREATMENT_AREA_CODE,'"+locale+"' ,'2') treatment_area_desc, (CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT DECODE (triage_area_yn, 'Y', 'B', 'N', 'C', '', 'A' ) FROM ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ) triage_area, c.open_to_all_pract_yn,  a.practitioner_id, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'2') practitioner_name, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'1') practitioner_full_name, a.priority_indicator, to_char(a.queue_date,'dd/mm/yyyy hh24:mi') queue_date_time, to_char(a.check_in_date_time,'hh24:mi') check_in_date_time,            to_char(a.ASSIGN_TMT_AREA_TIME,'hh24:mi') ASSIGN_TMT_AREA_TIME,            to_char(a.TREATMENT_START_TIME,'hh24:mi') TREATMENT_START_TIME,				TO_CHAR(b.date_of_birth,'dd/mm/yyyy') date_of_birth,	CALCULATE_AGE(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),1) year,		CALCULATE_AGE(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),2) months,		CALCULATE_AGE(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),3) days,		to_char(a.CONS_SRVC_START_DATE_TIME,'hh24:mi') CONS_SRVC_START_DATE_TIME,           to_char(a.TRIAGE_DATE_TIME,'hh24:mi') TRIAGE_DATE_TIME,            to_char(a.CONS_SRVC_END_DATE_TIME,'hh24:mi') CONS_SRVC_END_DATE_TIME, to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time, to_char(sysdate-1,'dd/mm/yyyy') sys_date_time_1, to_char(sysdate,'dd/mm/yyyy') sys_date, a.patient_id, (decode('"+locale+"' ,'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name))) patient_name, b.sex patient_gender, AM_GET_DESC.AM_COMPLAINT(a.COMPLAINT_CODE,'"+locale+"' ,'1') COMPLAINT_DESC, a.encounter_id,get_waiting_time(NVL (a.cons_srvc_start_date_time, SYSDATE), queue_date) waiting_time, to_char(a.queue_date,'dd/mm/yyyy') queue_date1, to_char(a.assign_tmt_area_time,'dd/mm/yyyy hh24:mi') assign_date, a.queue_status,  a.queue_status queue_status_desc, a.trauma_yn, a.brought_dead_yn, NVL((CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT open_to_all_prac_for_clinic_yn FROM  ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END ),'N') open_to_all_prac_for_clinic_yn, 'EM' patient_class, a.priority_zone, a.visit_type_code,  a.AE_BED_NO bed_no, a.dis_regn_reference,a.dis_regn_remarks,a.disaster_yn, a.TRAUMA_YN, a.PAT_CURR_LOCN_TYPE, AM_GET_DESC.AM_CARE_LOCN_TYPE(a.PAT_CURR_LOCN_TYPE,'"+locale+"' ,'2') CURR_LOCN_TYPE_DESC, DECODE (a.pat_curr_locn_type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.pat_curr_locn_code,'"+locale+"' ,'2'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(a.facility_id, a.pat_curr_locn_code,'"+locale+"' ,'2'),                       OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.pat_curr_locn_code,'"+locale+"' ,'1')) pat_curr_locn_desc, AE_GET_DESC.AE_PAT_PRIORITY(a.pat_priority,'"+locale+"' ,'2') PAT_PRIORITY_DESC,(SELECT max(complaint_id) FROM ca_encntr_chief_complaint x WHERE encounter_id = a.encounter_id and facility_id=a.facility_id)complaint_code ,a.episode_id, a.OP_EPISODE_VISIT_NUM ");
	  	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 5th 2014 Start*/
		/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
		if(checkout_yn.equals("Y")){
			sqlPatQ1.append(" ,(select Or_patient_Order_Pend(a.patient_id,a.facility_id,a.encounter_id,'C') from dual) pend_ord_stats ");
		}
		/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/
	  	sqlPatQ1.append(" ,(SELECT PRIORITY_ZONE_COLOR FROM AE_PRIORITY_ZONE WHERE EFF_STATUS='E' and PRIORITY_ZONE=a.PRIORITY_ZONE ) PRIORITY_ZONE_COLOR ");
	  	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 5th 2014 End*/
	  	if(waitingTimeIndYN){
			sqlPatQ1.append(",(SELECT WAITING_TIME_COLOR FROM AE_PRIORITY_ZONE WHERE EFF_STATUS='E' and PRIORITY_ZONE=a.PRIORITY_ZONE ) P_WAITING_TIME_COLOR,(SELECT WAITING_TIME FROM AE_PRIORITY_ZONE WHERE EFF_STATUS='E' and PRIORITY_ZONE=a.PRIORITY_ZONE ) P_WAITING_TIME ");
		}
		if(include_checkedout.equals("Y"))
		{
		sqlPatQ1.append(" from  op_patient_queue a, mp_patient b, op_clinic_lang_vw c ");
		}else
		{
		sqlPatQ1.append(" from  ae_current_patient a, mp_patient b, op_clinic_lang_vw c ");
		}
		 
		if(!(bed_bay_type.equals("")))
		{
			sqlPatQ1.append(" ,ae_bed_for_trmt_area d ");
		}

	if (checkout_yn.equals("N"))
		{
		if (observe_id.equals("C"))
		{
			byObserveId_criteria1.append("and a.locn_code='"+oberv_clinc_code+"'");
		}
	  else if(observe_id.equals("T"))
		{
			byObserveId_criteria1.append("and a.treatment_area_code='"+oberv_TMT_code+"'");
		}
		/*else
		{
			if(!priority_status.equals("for_admission")){//Added by Thamizh selvi on 16th May 2018 against ML-MMOH-CRF-0658
				byObserveId_criteria1.append("and  a.locn_code not in(select nursing_unit_code from ae_param where operating_facility_id='"+facility_id+"' and  ae_observe_battery_id = 'C') "); 
			}
		}*///commented on 29th-OCT-2018 for ML-MMOH-SCF-1081
		}
		if(include_checkedout.equals("Y"))
		{
		sqlPatQ1.append(" where a.patient_class = 'EM' and ");
		}
		else
		{
		sqlPatQ1.append(" where ");
		}	
        if(ch_id.equals("Y"))
		{
		sqlPatQ1.append("  a.rowid in('"+ret_str+"') and ");
		}
		sqlPatQ1.append("   a.facility_id = ?  and a.facility_id = c.facility_id and  a.patient_id = b.patient_id  and c.language_id = '"+locale+"'  and a.facility_id=c.facility_id and a.locn_code = c.clinic_code  ");
		if(!(bed_bay_type.equals("")))
		{
			
			sqlPatQ1.append(" and a.facility_id=d.facility_id AND a.locn_code=d.CLINIC_CODE AND a.TREATMENT_AREA_CODE=d.TREATMENT_AREA_CODE AND a.AE_BED_NO=d.bed_no  AND d.occupying_patient_id IS NOT NULL ");
		}
		
    	sqlPatQ1.append(whereClause1);	
		
		sqlPatQ1.append(byObserveId_criteria1);	
		
		sqlPatQ1.append(" ORDER BY ");
		sqlPatQ1.append(orderByClause1);


		pstmt		=	con.prepareStatement(sqlPatQ1.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
    	pstmt.setString	(	1,	facility_id		);

		if(!(clinic_code.equals("")))	
		{
			pstmt.setString	(	++columnIndex,	clinic_code	);
			pstmt.setString	(	++columnIndex,	clinic_type	);
		}
		if(!(treatment_area_code.equals("")))	
			pstmt.setString	(	++columnIndex,	treatment_area_code	);
		if(!(bed_bay_type.equals("")))				
			pstmt.setString	(	++columnIndex,	bed_bay_type	);
		if(!(practitioner_id.equals("")))	
			pstmt.setString	(	++columnIndex,	practitioner_id	);
		if(!(patient_id.equals("")))	
			pstmt.setString	(	++columnIndex,	patient_id	);
		if(!(priority.equals("")))	
			pstmt.setString	(	++columnIndex,	priority	);
		if(!(patient_gender.equals("")))	
			pstmt.setString	(	++columnIndex,	patient_gender	);


		rs	=	pstmt.executeQuery();
		
		if(max == 0) {
			rs.last();
			maxRecord = rs.getRow();			
			rs.beforeFirst();
		} else {
			maxRecord = max;
		}
		
		if	 (maxRecord==0)
		{
%>
		<script>
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		</script>
<%
		}
		else
		{
		
    	%>
			<script>
        var refreshparam;
        var checkout_yn;
		refreshparam='<%=queue_refresh_interval%>'*60*1000;
		self.setInterval('window.location.href = window.location.href;',refreshparam);
		//self.setInterval('parent.AEMPSearchResultFrame.location.reload();',refreshparam);//modified By munisekhar for IN43904
		
       </script>  			
</head>
		
<input type='hidden' name='CAInstalled' id='CAInstalled' value="<%=CAInstalled%>" >   

	<body onMouseDown="CodeArrest()"  onKeyDown = 'lockKey()' class='CONTENT' onscroll='scrollTitle();'>
<center>
<form name='AEMPSearchResultForm' id='AEMPSearchResultForm'>
<div name='msg' id='msg' style="position:absolute;width: 0; height: 0; left: 201; top: 62">
</div>

<div  id='divTitleTable' >
<table border='0' cellpadding='0' cellspacing='0' width='100%' id='TitleTab'>
<tr>
        <td align=left width='10%'>
            <table align=left >
                <tr>
                    <td class=label nowrap><fmt:message key="Common.LastRefreshTime.label" bundle="${common_labels}"/> <b><%=sys_date%></b></td>
                </tr>
            </table>
        </td>
		 
		 <td  width='37%' align='right'>&nbsp;</td>
    </tr>
<!--</td>
                </tr>
            </table>
        </td>
    </tr>-->
</table>
<!--<table  id='th_table' cellspacing=0 cellpadding=0 align='center' width='160%' border='20'>-->
<table  id='th_table'  cellpadding='0' cellspacing='0' border=1 >
		<tr>
<%  String StrHdr = "";
	int size = fieldOrder.size();
	for (int m=0; m < size; ++m)
	{
	 StrHdr = ((String)fieldOrder.get(m)).toLowerCase();
		 
	 /*Below line added for this CRF ML-MMOH-CRF-0637*/
 if (registerattendance && StrHdr.equals("reattendance")) { %>
<th width='5%' nowrap><fmt:message key="eAE.Reattendance.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='reattendanceGif' style='visibility:hidden'></th>
<%}
//End ML-MMOH-CRF-0637	 
else if (StrHdr.equals("practitioner_name")) {  %>
<th  onclick ="sort('practitioner','<%=priority_zone%>');" style='cursor:pointer' nowrap  width='4%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='practitionerGif' style='visibility:hidden'></th>
<%} else if (StrHdr.equals("priority_ind")) { 
//Added by Sangeetha on 26/apr/17 for ML-MMOH-CRF-0636
if(sortByPriorityZone){%>
<th onclick ="sort('zone','<%=priority_zone%>');" nowrap  width='2%' style='cursor:pointer'><fmt:message key="eAE.Zone.label" bundle="${ae_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='zoneGif' style='visibility:hidden'></th>
<%} else{ %>
<th  nowrap  width='1%'  >&nbsp;&nbsp;&nbsp;</th>
<%} } else if (StrHdr.equals("priority")) {  %>
 <th onclick ="sort('priorityZone','<%=priority_zone%>');"  style='cursor:pointer' nowrap width='4%' ><fmt:message key="Common.priority.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='prior' style='visibility:hidden'></th>
 <%} else if (StrHdr.equals("queue_date_time")) {
     if(!isLengthOfStayAppl)
	 {
 %>
<th onclick ="sort('queueDate','<%=priority_zone%>');"  style='cursor:pointer'  nowrap width='4%'><fmt:message key="eAE.DateTimeIn.label" bundle="${ae_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='dateGif' style='visibility:hidden'></th>
	<%
	 }
	 else
	 {
		%>
<th onclick ="sort('queueDate','<%=priority_zone%>');"  style='cursor:pointer'  nowrap width='6%'><fmt:message key="eAE.DateTimeIn.label" bundle="${ae_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='dateGif' style='visibility:hidden'></th>
	<% 
	 }
	
	} else if (StrHdr.equals("bed_no")) {  %>	
<th  onclick ="sort('bed_no','<%=priority_zone%>');"  style='cursor:pointer'  nowrap <% if(sortByPriorityZone){%>width='3%' <%}else{%> width='3%' <%}%>><fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='bedNoGif' style='visibility:hidden'></th>
<%} else if (StrHdr.equals("patient_name")) {  %>
<th onclick ="sort('patientName','<%=priority_zone%>');"  style='cursor:pointer' nowrap width='9%'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='patNameGif' style='visibility:hidden'></th>
<%} else if (StrHdr.equals("patient_id")) {  %>
<th onclick ="sort('patientId','<%=priority_zone%>');" style='cursor:pointer'  nowrap  width='4%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='patIdGif' style='visibility:hidden'></th>
<%} else if (StrHdr.equals("age")) {  %>
<th onclick ="sort('age','<%=priority_zone%>');" style='cursor:pointer'   nowrap width='3%'><fmt:message key="Common.patient.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.age.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='ageGif' style='visibility:hidden'></th>
<%} else if (StrHdr.equals("wait_time")) {  %>
<th onclick ="sort('waitingTime','<%=priority_zone%>');"  style='cursor:pointer'   nowrap width='3%'><fmt:message key="Common.WaitTime.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none align=right name='waitTimeGif' style='visibility:hidden'>&nbsp;&nbsp;</th>
	<%} else if (StrHdr.equals("queue_status")) {  %>
<th onclick ="sort('status','<%=priority_zone%>');"  style='cursor:pointer' nowrap width='15%'><fmt:message key="Common.status.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='statusGif' style='visibility:hidden'></th>
<%} /*Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658 Start*/
else if (isPendingForAdmissionAppl && StrHdr.equals("for_admission")) {  %>
<th onclick ="sort('for_admission','<%=priority_zone%>');" style='cursor:pointer' nowrap width='4%'><fmt:message key="Common.for.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.admission.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='forAdmGif' style='visibility:hidden'></th>
<%}/*End*/ 
else if (StrHdr.equals("presenting_problem")) {  %>
<th style='cursor:pointer' nowrap width='6%'><fmt:message key="Common.PresentingProblem.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right  style='visibility:hidden'></th>
<%} else if (StrHdr.equals("comp_desc")) {  %>
<th style='cursor:pointer' nowrap  width='6%'><fmt:message key="eCA.ChiefComplaints.label" bundle="${ca_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right  style='visibility:hidden'></th>
<%} else if (StrHdr.equals("curr_location")) {  %>
<th onclick ="sort('locType','<%=priority_zone%>');"  style='cursor:pointer' nowrap width='7%'><fmt:message key="Common.currentlocation.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='locTypeGif' style='visibility:hidden'></th>
	<%} else if (StrHdr.equals("disaster_yn")) {  %>
<th nowrap width='5%'><fmt:message key="Common.Disaster.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='loc' style='visibility:hidden'></th>
<%} else if (StrHdr.equals("dis_regn_reference")) {

	if(allowSplChar){%>
	
<th nowrap width='8%'><fmt:message key="eAE.DisasterReference.label" bundle="${ae_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='loc' style='visibility:hidden'></th>
<%} 
else
{
	%>
	<th nowrap width='8%'><fmt:message key="eAE.DisRegnReference.label" bundle="${ae_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='loc' style='visibility:hidden'></th>
	<%
}
}
else if (StrHdr.equals("dis_regn_remarks")) {  %>
<th nowrap width='5%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='loc' style='visibility:hidden'></th>
<%} else if (StrHdr.equals("case_of_trauma")) {  %>
<th nowrap  width='5%' ><fmt:message key="Common.CaseofTrauma.label" bundle="${common_labels}"/><img src='../../eAE/images/Ascending.gif'  border=none  align=right name='locc' style='visibility:hidden'></th>
<%}%>

<%}%>
</tr>

		  </table>
	</div>
<table border='10'  style='border-bottom:#ffffff'  cellspacing='0' width='200%' id='tb1'>
<%
String prev_header  ="";
String Header  ="";
String ind="";
String brought_dead = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.broughtdead.label","common_labels") + " " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels") ;

int tryl=1;
i=1;
if ( rs != null )
{
    int p1=1;
	
	/* if(!ch_id.equals("Y")){
    if ( start != 1 )
    {
	     for( int k=1; k<start; i++,k++ )
	     {
		  rs.next() ;
	     }
    }
	}
      while ( rs.next() && i<=end )*/
	  while ( rs.next())
        {

			ind="";
			classValue				=	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
			rowIndex++;
			tblrow_id				=	"tblrow_id"+rowIndex;
			rowid			        =   checkForNull(rs.getString("row_id"));
			
			if( !temp.contains(rowid))
				    {   
						 temp.add(rowid);
					}
			
			patient_class			=   checkForNull(rs.getString("patient_class"));
			open_to_all_pract_yn	=	checkForNull(rs.getString("open_to_all_pract_yn"));	
			clinic_code			    =	checkForNull(rs.getString("LOCN_CODE"));	
			curr_location           =   checkForNull(rs.getString("CURR_LOCN_TYPE_DESC")) + " / " + checkForNull(rs.getString("pat_curr_locn_desc"));
			p_clinic_desc			=	checkForNull(rs.getString("locn_desc"));	
			clinic_type				=	checkForNull(rs.getString("locn_type"));	
			treatment_area_code		=	checkForNull(rs.getString("treatment_area_code"));	
			treatment_area_desc		=	checkForNull(rs.getString("treatment_area_desc"));	
			triage_area				=	checkForNull(rs.getString("triage_area"));	
			practitioner_id			=	checkForNull(rs.getString("practitioner_id"));
			practitioner_name		=	rs.getString("practitioner_name");
			practitioner_name 		= (practitioner_name == null)?"&nbsp;":practitioner_name;
			practitioner_full_name	=	checkForNull(rs.getString("practitioner_full_name"));
			queue_date_time			=	checkForNull(rs.getString("queue_date_time"));
			sys_date_time			=	checkForNull(rs.getString("sys_date_time"));
			patient_id				=	checkForNull(rs.getString("patient_id"));
			patient_name			=	checkForNull(rs.getString("patient_name"));
			encounter_id			=	checkForNull(rs.getString("encounter_id"));
			waiting_time			=	checkForNull(rs.getString("waiting_time")); 
			
			stay_time               =   checkForNull(rs.getString("stay_time")); // added by mujafar for ML-MMOH-CRF-1194
	
			stay_time = stay_time.replaceAll("\\s", ""); 
	
			/* added by mujafar for ML-MMOH-CRF-1194*/
			StringTokenizer StaytimeWt	= new StringTokenizer(stay_time,":");
            if(StaytimeWt.hasMoreTokens()){
				stay_time_1 = StaytimeWt.nextToken();
				stay_time_2 = StaytimeWt.nextToken();
				
			}
			if(stay_time_1.length() == 1)
				stay_time_1	= "0" + stay_time_1;
				stay_time_2	= stay_time_1 + ":" + stay_time_2;
				
			
			/* added by mujafar for ML-MMOH-CRF-1194*/
			
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
			 if(firststring.length() == 1){
				 firststring = "0"+firststring;
				 waiting_time = firststring +":" +secondstring;
			}
			
			if(waitingTimeIndYN){
				p_waiting_time	= rs.getInt("P_WAITING_TIME");
				p_waiting_time_color	= checkForNull(rs.getString("P_WAITING_TIME_COLOR"));
			}
			/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
			if(checkout_yn.equals("Y")){
				pend_ord_stats	= checkForNull(rs.getString("pend_ord_stats"),"N");
			}
			/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/

			/*Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658 Start*/
			pendngAdmDateTime	=	checkForNull(rs.getString("pendngAdmDateTime"));
			forAdmWaitngTime	=	checkForNull(rs.getString("pendngForAdmissionTime"));
			StringTokenizer frAdmWt	= new StringTokenizer(forAdmWaitngTime,":");
            if(frAdmWt.hasMoreTokens()){
				forAdmWaitString1 = frAdmWt.nextToken();
				forAdmWaitString2 = frAdmWt.nextToken();
			}
			if(forAdmWaitString1.length() == 1){
				forAdmWaitString1	= "0" + forAdmWaitString1;
				forAdmWaitngTime	= forAdmWaitString1 + ":" + forAdmWaitString2;
			}
			/*End*/

			queue_date				=	checkForNull(rs.getString("queue_date1"));	
			queue_status			=	checkForNull(rs.getString("queue_status"));	
			queue_status_desc		=	checkForNull(rs.getString("queue_status"));	
			trauma_yn				=	checkForNull(rs.getString("trauma_yn"));	
            bed_no					=	rs.getString("bed_no");
			bed_no 					=  (bed_no == null)?"":bed_no;
			disaster_yn				=	checkForNull(rs.getString("disaster_yn"));	
			CaseofTrauma_val		=   checkForNull(rs.getString("TRAUMA_YN"));
			patient_gender			=	checkForNull(rs.getString("patient_gender"));	
			brought_dead_yn			=	checkForNull(rs.getString("brought_dead_yn"));	
			open_to_all_prac_for_clinic_yn=	checkForNull(rs.getString("open_to_all_prac_for_clinic_yn"));	
			assign_tmt_area_time	=	checkForNull(rs.getString("assign_date"));
			priority_zone			=	rs.getString("priority_zone");
			priority_zone 		= (priority_zone == null)?"&nbsp;":priority_zone;
			visit_type_code         =	checkForNull(rs.getString("visit_type_code"));
	        //pract_type				=	checkForNull(rs.getString("pract_type"));
			sys_date_time_1			=	checkForNull(rs.getString("sys_date_time_1"));	
			sys_date2				=	checkForNull(rs.getString("sys_date"));	
			/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 5th 2014 Start*/
			priority_zone_bgcolor	=  checkForNull(rs.getString("PRIORITY_ZONE_COLOR"));
			/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 5th 2014 End*/

			dis_regn_reference			=	rs.getString("dis_regn_reference");
			if(dis_regn_reference == null) dis_regn_reference="&nbsp";

	        dis_regn_remarks			=	rs.getString("dis_regn_remarks");
			if(dis_regn_remarks == null) dis_regn_remarks="";
			

			COMPLAINT_DESC			=	rs.getString("COMPLAINT_DESC");
			if(COMPLAINT_DESC == null) COMPLAINT_DESC="&nbsp";

           
			complaint_code			=	rs.getString("complaint_code");
			if(complaint_code == null) complaint_code="";
			
			episode_id=	rs.getString("episode_id");
			if(episode_id == null) episode_id="";

            visit_num =	rs.getString("OP_EPISODE_VISIT_NUM");
			if(visit_num == null) visit_num="";

			year_value				=	checkForNull(rs.getString("year"));	
			month_value				=	checkForNull(rs.getString("months"));	
			day_value				=	checkForNull(rs.getString("days"));	



			PAT_PRIORITY_DESC       =   rs.getString("PAT_PRIORITY_DESC");
			PAT_PRIORITY_DESC 		= (PAT_PRIORITY_DESC == null)?"&nbsp;":PAT_PRIORITY_DESC;

			if(PAT_PRIORITY_DESC == null) PAT_PRIORITY_DESC="";
			
			/*Below line added for this CRF ML-MMOH-CRF-0637*/
			String dischargedate="",visitdate="",currentdate="",clinicdesc="",maxhrsforreattend="",reattance="";
		if(registerattendance){
			ArrayList arrIPList=(ArrayList)AEReattendanceEncounterDetails.getAEEncounterDetails(con, patient_id, facility_id,p);
			 for(int ae=0; ae<arrIPList.size(); ae++){
					AEReattendanceEncounterDetailsBean aeEncounterDetails=(AEReattendanceEncounterDetailsBean)arrIPList.get(ae); 
					dischargedate=aeEncounterDetails.getDischargedate();
					visitdate=aeEncounterDetails.getVisitdate();
					currentdate=aeEncounterDetails.getCurrentdate();
					clinicdesc=aeEncounterDetails.getClinicdesc();
					maxhrsforreattend=aeEncounterDetails.getMaxhrsforreattend();										
		     }
			  if( !dischargedate.equals("") && !maxhrsforreattend.equals("")){					 
						
						 int chk_period_admit=Integer.parseInt(maxhrsforreattend);
						 chk_period_admit=chk_period_admit*60;
					     java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd/MM/yyy HH:mm:ss"); 
						 java.util.Date currentdate_reattence =new java.util.Date();
		                 java.util.Date dischargedate_reattence  =new java.util.Date();
						 currentdate_reattence = format.parse(currentdate);
		                 dischargedate_reattence =format.parse(dischargedate); 
						 diff=(currentdate_reattence.getTime()-dischargedate_reattence.getTime())/60000;
						 	 
						 if(chk_period_admit >= diff  && !maxhrsforreattend.equals("")){
						  reattance=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
						 }
				}		 
			}
			//End this CRF ML-MMOH-CRF-0637
			
			
			if(queue_status_desc1 != null)
				queue_status_desc1.delete(0,queue_status_desc1.length());

			check_in_date_time = rs.getString("check_in_date_time");
			check_in_date_time 		 = (check_in_date_time == null)?"empty":check_in_date_time;
			if (!check_in_date_time.equals("empty"))
				queue_status_desc1.append(" <table border='0' width='90%'  cellspacing='0.5px' ><tr><td><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedIn.label","common_labels")+"</td> <td align='right'><font size=1>- " + check_in_date_time +"</td></tr>" );  // modified by mujafar for HSA-CRF-0240

			assign_tmt_area_time1  = rs.getString("ASSIGN_TMT_AREA_TIME");
			assign_tmt_area_time1 		 = (assign_tmt_area_time1 == null)?"empty":assign_tmt_area_time1;
			if (!assign_tmt_area_time1.equals("empty"))
				queue_status_desc1.append(" <tr><td><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AssignedtoTreatmentArea.label","ae_labels")+"</td> <td align='right'><font size=1>- "+ assign_tmt_area_time1 +"</td></tr>" );  // modified by mujafar for HSA-CRF-0240

			treatment_start_time  = rs.getString("TREATMENT_START_TIME");
			treatment_start_time 		 = (treatment_start_time == null)?"empty":treatment_start_time;
			if (!treatment_start_time.equals("empty"))
				queue_status_desc1.append(" <tr><td><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.UndergoingTreatment.label","ae_labels")+"</td> <td align='right'><font size=1>- " +treatment_start_time +"</td></tr>" );		// modified by mujafar for HSA-CRF-0240			
			cons_srvc_start_date_time  = rs.getString("CONS_SRVC_START_DATE_TIME");
			cons_srvc_start_date_time 		 = (cons_srvc_start_date_time == null)?"empty":cons_srvc_start_date_time;
					
			TRIAGE_DATE_TIME  = rs.getString("TRIAGE_DATE_TIME");
			TRIAGE_DATE_TIME  =(TRIAGE_DATE_TIME == null)?"empty":TRIAGE_DATE_TIME;
			/* follwoing block added by mujafar for HSA-crf-0240 on 2/4/2015.  *start* */
				
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			java.util.Date d1 = null;
			java.util.Date d2 = null;
 			if(!(TRIAGE_DATE_TIME.equals("empty") || cons_srvc_start_date_time.equals("empty")))
			{
					d1 = format.parse(TRIAGE_DATE_TIME);
					d2 = format.parse(cons_srvc_start_date_time);		
					 boolean flag = d1.before(d2);
					 boolean flag1 = d1.equals(d2);
					 if(flag == true || flag1 == true)
						{																										  
						queue_status_desc1.append(" <tr><td><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.SecondaryTriage.label","ae_labels")+"</td> <td align='right'><font size=1>- " +TRIAGE_DATE_TIME +"</td></tr>" ); 
						queue_status_desc1.append(" <tr><td><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.ConsultationStarted.label","ae_labels")+"</td> <td align='right'><font size=1>- " +cons_srvc_start_date_time +"</td></tr>" );
						
					 }
					 else
					 {
						queue_status_desc1.append(" <tr><td><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.ConsultationStarted.label","ae_labels")+"</td> <td align='right'><font size=1>- " +cons_srvc_start_date_time +"</td></tr>" );
						queue_status_desc1.append(" <tr><td><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.SecondaryTriage.label","ae_labels")+"</td> <td align='right'><font size=1>- " +TRIAGE_DATE_TIME +"</td></tr>" ); 
					 }
			
			}
			else
			if( !TRIAGE_DATE_TIME.equals("empty") && cons_srvc_start_date_time.equals("empty"))
			{
				queue_status_desc1.append(" <tr><td><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.SecondaryTriage.label","ae_labels")+"</td> <td align='right'><font size=1>- " +TRIAGE_DATE_TIME +"</td></tr>" ); 
			}
			else
				if(TRIAGE_DATE_TIME.equals("empty") && !cons_srvc_start_date_time.equals("empty"))
				{
				queue_status_desc1.append(" <tr><td><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.ConsultationStarted.label","ae_labels")+"</td> <td align='right'><font size=1>- " +cons_srvc_start_date_time +"</td></tr>" );
				}					
			/* above block added by mujafar for HSA-crf-0240 on 2/4/2015.  *end* */	
				
			cons_srvc_end_date_time  = rs.getString("CONS_SRVC_END_DATE_TIME");
			cons_srvc_end_date_time 		 = (cons_srvc_end_date_time == null)?"empty":cons_srvc_end_date_time;
			if (!cons_srvc_end_date_time.equals("empty"))
				queue_status_desc1.append(" <tr><td><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedOut.label","common_labels")+"</td> <td align='right'><font size=1>- " +cons_srvc_end_date_time +"</td></tr> " );  // modified by mujafar for HSA-CRF-0240
				queue_status_desc1.append("</table>");
			queue_status_desc = queue_status_desc1.toString();
				
			
			
	if(prev_visit.equals("") && (sys_date2.equals(queue_date)) )	
	{     
		ind="";
	}
	else if(prev_visit.equals(""))
	{
	ind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Visit.label","common_labels");
	}
	else if( (!prev_visit.equals(""))  &&  (sys_date_time_1.equals(queue_date))) 
	{
        ind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Visit.label","common_labels");
	}
	else if( (!prev_visit.equals("")) ) 
	{
        ind=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Visit.label","common_labels");
	}
   treatment_area_desc=specialCharacter(treatment_area_desc);
	   Header=p_clinic_desc;
	if(!treatment_area_desc.equals(""))
		Header=Header+"/"+ treatment_area_desc;
	if(!ind.equals(""))
		Header=Header+"/"+ ind;

	if(!(Header.equals(prev_header)))
			{
					
	if(prev_visit.equals("") && (sys_date2.equals(queue_date)) )	
					{   
	%>
		<tr   <%=disp_val%> > <!-- modified by mujafar for ML-MMOH-CRF-1194 -->
		<th colspan=<%=clspanval%> align='left'><font size=1><%=Header%>&nbsp;&nbsp;&nbsp;
	 <% 
		out.println(getStatistics(pageContext,con,facility_id,clinic_type,clinic_code,treatment_area_code, include_checkedout));
		%>
		</th>
		</tr>		
		<%
				}
	else if(prev_visit.equals("")){
	%>
		<tr <%=disp%> >
		<th colspan=<%=clspanval%> align='left'><font size=1><%=Header%></th>
	</tr>
	 <%
	} 
		
	else if( (!prev_visit.equals("")) && (sys_date_time_1.equals(queue_date)) ) 
			{
	%>
	<tr <%=disp%> >
		<th colspan=<%=clspanval%> align='left'><font size=1><%=Header%>&nbsp;&nbsp;&nbsp; 
	 </th>
	</tr>
	 <%
	 }
	 else if( (!prev_visit.equals("")) ) 
			{
	%>
	<tr <%=disp%> >
		<th colspan=<%=clspanval%> align='left'><font size=1><%=Header%>&nbsp;&nbsp;&nbsp; 
	 </th>
	</tr>
	 <%
	 }
	
		if(!isLengthOfStayAppl)
		prev_header	=	Header;		

}
	
//Mahesh added
/* To iterate over each column and paint the columns in correct order - vinod 11/9/2009 */
			%>
				<tr id='<%=tblrow_id%>' onMouseOver='hideToolTip()'>	
			<%
	String str = "";
	for (int m=0; m < size; ++m)
	{
		str = ((String)fieldOrder.get(m)).toLowerCase();
					
			/*Below line added for this CRF ML-MMOH-CRF-0637*/
			 if (registerattendance && str.equals("reattendance")) { %>
			<td class='<%=classValue%>'  width='5%'><font size=1>&nbsp;<%=reattance%></td>
			<%}else if (str.equals("practitioner_name")) {%>
			<td class='<%=classValue%>'  width='4%'><font size=1><%=practitioner_name%></td>
			<%} else if (str.equals("priority_ind")) {
			//Modified by Sangeetha for ML-MMOH-CRF-0636 on 27/apr/2017
			%>
			<td class='<%=classValuePI%>' <%if(!priority_zone_bgcolor.equals("")){ %> style="background-color:<%=priority_zone_bgcolor%>"<%} if(sortByPriorityZone){%> width='2%' <%}else{ %> width='1%'> <% } %> &nbsp;</td>
			<%}else if (str.equals("priority")) {%>
			<td class='<%=classValue%>' width='4%' ><font size=1><%if(PAT_PRIORITY_DESC.equals("")){ %>&nbsp;<%}else{%><%=PAT_PRIORITY_DESC%><%} %></td> 
			<%} else if (str.equals("queue_date_time")) 
			{
				if(isLengthOfStayAppl) // Modified by mujafar for ML-MMOH-CRF-1194
				{
				%>
				<td class='<%=classValue%>'  width='6%'><font size=1><%=DateUtils.convertDate(queue_date_time,"DMYHM","en",locale)%><br><fmt:message key="eIP.LengthofStay.label" bundle="${ip_labels}"/>&nbsp;:&nbsp;<%=stay_time_2%> </td> <!--added by mujafar for ML-MMOH-CRF-1194-->
				<%
				}
				else
				{
				%>
				<td class='<%=classValue%>'  width='4%'><font size=1><%=DateUtils.convertDate(queue_date_time,"DMYHM","en",locale)%></td>
				<%
				} 
			}
			else if (str.equals("bed_no")) {%>
		<td class='<%=classValue%>' align='center'  <% if(sortByPriorityZone){%>width='3%' <%}else{%> width='3%' <%}%>><font size=1>
		<%if(bed_no.equals("")){ %>
				&nbsp;<%}
				else{
					%><%=bed_no%>
					<%} %> </td>
      <% } else if (str.equals("patient_name")) {
		  
		  String img_temp="";
		  if(isVIPimgpatfrontappl)
			{	
			 
			String vip_pat_yn = eOA.OACommonBean.getVIPPatient(con,patient_id,facility_id);
			if(vip_pat_yn.equals("TRUE"))
			img_temp="<img border=0 src='../../eCommon/images/PI_VIP.gif'></img>";	
			else
			img_temp = "";
			
			}
		  
		if(checkout_yn.equals("N"))
			{
				if(!queue_status.equals("07"))
				{
		    	%>
				<script>
				var clinic_desc ="<%=p_clinic_desc%>"; 
				</script>
				<!-- Below TD modified by Venkatesh.S on 10-Oct-2013 against Bru-HIMS-CRF-362[39365] -->
				<!--reg_new_born_yn,inv_reg_new_born_yn  Added by Dharma on Aug 1st 2017 against ML-MMOH-CRF-0631 [IN:062148] -->
			<td class='<%=classValue%>' width='9%'  id='desc<%=i%>'onMouseover="onMMove(msg,event,'<%=brought_dead%>','<%=brought_dead_yn%>');hideToolTip(this,'imgArrow<%=i%>','<%=i%>');" onMouseout="onMOut(msg,'<%=brought_dead_yn%>');" onClick="showAllowedOperations('<%=clinic_code%>','<%=java.net.URLEncoder.encode(p_clinic_desc)%>','<%=clinic_type%>','<%=patient_id%>','<%=queue_status%>','<%=encounter_id%>','<%=triage_area%>','<%=trauma_yn%>','<%=treatment_area_code%>','<%=practitioner_id%>','<%=practitioner_full_name%>','<%=treatment_area_desc%>','<%=open_to_all_prac_for_clinic_yn%>', '<%=queue_date_time%>','<%=sys_date_time%>','<%=queue_date%>','<%=patient_gender%>','<%=brought_dead_yn%>','<%=assign_tmt_area_time%>','<%=open_to_all_pract_yn%>','<%=patient_class%>','<%=priority_zone%>','<%=bed_no%>','<%=visit_type_code%>','<%=pract_type%>','<%=record_vital_signs_yn%>','<%=pract_type1%>','<%=enable_rights_yn%>','<%=sel_triage_yn%>','<%=sel_cons_yn%>','<%=end_date%>','<%=start_date%>','<%=enable_rights_yn%>','<%=min_age_for_lmp%>','<%=year_value%>','<%=allow_chkout_with_bill_stmt_yn%>','<%=episode_id%>','<%=visit_num%>',this,'imgArrow<%=i%>','<%=i%>','link<%=i%>','<%=reg_new_born_yn%>','<%=inv_reg_new_born_yn%>','<%=pendngAdmDateTime%>');onMOut(msg,'<%=brought_dead_yn%>');"><a href='javascript:DummyRef()' name='link<%=i%>' ><font size='1'><%=img_temp%><%=patient_name%></a><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow<%=i%>'></td><!--Modified by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658-->
			<%
			  }
				else
				{
							%>
			<td class='<%=classValue%>' width='9%'><a name='desc<%=i%>'onMouseover="onMMove(msg,event,'<%=brought_dead%>','<%=brought_dead_yn%>');" onMouseout="onMOut(msg,'<%=brought_dead_yn%>');"   href='javascript:DummyRef()' 
			onClick=" CallViewPatDetails1('<%=patient_id%>','<%=encounter_id%>');" ><font size=1><%=img_temp%><%=patient_name%></a></td>

			<%
				}
			}
			else 
			{
				if (!queue_status.equals("07"))
				{
			%>
			<td class='<%=classValue%>' width='9%'><a name='desc<%=i%>'onMouseover="onMMove(msg,event,'<%=brought_dead%>','<%=brought_dead_yn%>');" onMouseout="onMOut(msg,'<%=brought_dead_yn%>');" href='javascript:LoadChkOut( "<%=encounter_id%>","<%=brought_dead_yn%>","<%=treatment_area_code%>","<%=open_to_all_prac_for_clinic_yn%>","<%=clinic_code%>","<%=open_to_all_pract_yn%>","<%=patient_id%>","<%=clinic_type%>","<%=allow_chkout_with_bill_stmt_yn%>","<%=episode_id%>","<%=visit_num%>","<%=pend_ord_stats%>")' ><font size=1><%=img_temp%><%=patient_name%></a></td>
			<%
				}
				else
				{
			   %>
					<td class='<%=classValue%>' width='9%'><a name='desc<%=i%>'onMouseover="onMMove(msg,event,'<%=brought_dead%>','<%=brought_dead_yn%>');" onMouseout="onMOut(msg,'<%=brought_dead_yn%>');" href='javascript:DummyRef()' 
					onClick=" CallViewPatDetails1('<%=patient_id%>','<%=encounter_id%>');"><font size=1><%=img_temp%><%=patient_name%></a></td>
			<%	}
			%>
			<%}
			} else if (str.equals("patient_id")) {
			if(brought_dead_yn.equals("Y")) {   %>
			<td class='AEDECEASED' width='4%'><font size=1><%=patient_id%></td>
			<% }else {%>
			<td class='<%=classValue%>' width='4%'><font size=1><%=patient_id%></td>
			<%}%>
			<%} else if (str.equals("age")) { %>
			<td class='<%=classValue%>' width='3%'><font size=1><%=year_value%>Y<%=month_value%>M<%=day_value%>D</td>
			<% } else if (str.equals("wait_time")) { %>
			<td class='<%=classValue%>' width='3%' <%if(p_waiting_time !=0 && (p_waiting_time_mins > p_waiting_time) && !("").equals(p_waiting_time_color) && waitingTimeIndYN){%> style="background-color:<%=p_waiting_time_color%>" <%}%>><font size=1><%=waiting_time%></td>
			<% } else if (str.equals("queue_status")) { %>
			<td nowrap width='15%' class='<%=classValue%>' ><font size=1><%=queue_status_desc%></td>
			<!-- Friday, March 19, 2010 20119 -->
			<% } /*Added by Thamizh selvi on 19th Apr 2018 against ML-MMOH-CRF-0658 Start*/
				else if (isPendingForAdmissionAppl && str.equals("for_admission")) {%>
					<td class='<%=classValue%>' width='4%' nowrap><font size=1>
						<% if(pendngAdmDateTime.equals("")){ %>
							&nbsp;
						<% }else{ %>
							<table>
								<tr>
									<td colspan='2'><font size=1><%=pendngAdmDateTime%></font></td>
								</tr>
								<tr>
									<td nowrap><font size=1><fmt:message key="Common.Pending.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.for.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.admission.label" bundle="${common_labels}"/>&nbsp; -</font></td>
									<td nowrap><font size=1><%=forAdmWaitngTime%></font></td>
								</tr>
							</table>
						<% } %>
					</td>
				<%}/*End*/
			else if (str.equals("presenting_problem")) { %>
	      <td nowrap class='<%=classValue%>'  width='6%'><font size=1><%=COMPLAINT_DESC%></td>
		  <% } else if (str.equals("comp_desc")) { %>
         <%
			    	
			if(disaster_yn.equals("Y")) {  
					if(!complaint_code.equals("")){%>
	       <td nowrap class='<%=classValue%>'  width='6%'><font size=1><a href='javascript:GetChiefComplaint("<%=encounter_id%>","<%=patient_id%>")'><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Complaint.label" bundle="${common_labels}"/></a></td>
			<% }else {%>
			  <td nowrap class='<%=classValue%>'   width='6%'><font size=1>&nbsp;</td>
			 	<%}
          }else {
				  
		if(!complaint_code.equals("")){%>
			    <td nowrap class='<%=classValue%>'  width='6%'><font size=1><a href='javascript:GetChiefComplaint("<%=encounter_id%>","<%=patient_id%>")'><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Complaint.label" bundle="${common_labels}"/></a></td>
				<% }else {%>
			  <td nowrap class='<%=classValue%>'  width='6%'><font size=1>&nbsp;</td>
			  		<%} }%>
					<% } else if (str.equals("curr_location")) { %>
		<td  class='<%=classValue%>' width='7%'><font size=1><%=curr_location%></td>
		 <%} else if (str.equals("disaster_yn")) { %>
        <%
		//Added by Sangeetha for ML-MMOH-CRF-0625
		Boolean DISPLAY_BLANK_NON_DISASTER = CommonBean.isSiteSpecific(con, "AE", "DISPLAY_BLANK_NON_DISASTER");
		if(disaster_yn.equals("Y")) {   %> 
		<td class='<%=classValue%>' width='5%'><font size=1><fmt:message key="Common.yes.label" bundle="${common_labels}"/></td>
		<% }else {
		if(DISPLAY_BLANK_NON_DISASTER){
		%>
		<td class='<%=classValue%>' width='5%'><font size=1>&nbsp</td>
		<% }else {%>
		<td class='<%=classValue%>' width='5%'><font size=1><fmt:message key="Common.no.label" bundle="${common_labels}"/></td>
        <%}}%>
		<%} else if (str.equals("dis_regn_reference")) {%>
		        <%if(disaster_yn.equals("Y")) {   %> 
		<td class='<%=classValue%>' width='8%'><font size=1><%=dis_regn_reference%></td>
		<% }else {%>
		<td class='<%=classValue%>' width='8%'><%=dis_regn_reference%></td>
        <%}%>	        
		 <%} else if (str.equals("dis_regn_remarks")) {%>
		 <!--Added by Ashwini on 26-Apr-2017 for ML-MMOH-CRF-0641-->
		   <%if(isDisplayAllRemarks){
			   if(!dis_regn_remarks.equals("")) // added by mujafar for ML-MMOH-CRF-1040 start
			   {
			   %>
			<td class='<%=classValue%>' width='5%'><font size=1>
		 <a href="javascript:ShowRemarks('txtComm<%=i%>','I',<%=encounter_id%>)"><fmt:message key="Common.ViewDetails.label" bundle="${common_labels}"/>
		 <INPUT TYPE="hidden" name="txtComm<%=i%>" id="txtComm<%=i%>" value="<%=dis_regn_remarks%>">
		 </a>
			   </font>
		</td>
		<%
			   }
			  else{ 
				int remarks_cnt = eAE.AECommonBean.getSecTriageRemarksCount(con,encounter_id,facility_id);
				 if(remarks_cnt>0) 
				 {
			%>	  
				<td class='<%=classValue%>' width='5%'><font size=1>
		 <a href="javascript:ShowRemarks('txtComm<%=i%>','I',<%=encounter_id%>)"><fmt:message key="Common.ViewDetails.label" bundle="${common_labels}"/>
		 <INPUT TYPE="hidden" name="txtComm<%=i%>" id="txtComm<%=i%>" value="<%=dis_regn_remarks%>">
		 </a>
			   </font>
		</td>
			<%	
				 }
				else
				{
					%>
					<td class='<%=classValue%>' width='5%'>&nbsp;</td>  
					<%
				}
			  }  // added by mujafar for ML-MMOH-CRF-1040 end
		}else{
			if(disaster_yn.equals("Y")) { 
			if(!dis_regn_remarks.equals("")) // added by mujafar for ML-MMOH-CRF-1040 start
			{
			%> 
		<td class='<%=classValue%>' width='5%'><font size=1>
		 <a href="javascript:ShowRemarks('txtComm<%=i%>','I',<%=encounter_id%>)"><fmt:message key="Common.ViewDetails.label" bundle="${common_labels}"/>
		 <INPUT TYPE="hidden" name="txtComm<%=i%>" id="txtComm<%=i%>" value="<%=dis_regn_remarks%>">
		 </a>
			   </font>
		</td>
		<% 
			}
			else
			{
			%>
			<td class='<%=classValue%>' width='5%'><font size=1>&nbsp;</td>
			<%
			} // added by mujafar for ML-MMOH-CRF-1040 end
		}else {%>
		<td class='<%=classValue%>' width='5%'><font size=1>&nbsp;</td>
        <%}}%>
 <%} else if (str.equals("case_of_trauma")) {%>
        <%if(CaseofTrauma_val.equals("Y")) {   %> 
		<td class='<%=classValue%>' width='<%=tdwidth%>'><font size=1><fmt:message key="Common.yes.label" bundle="${common_labels}"/></td>
		<% }else {%>
		<td class='<%=classValue%>' width='<%=tdwidth%>'><font size=1><fmt:message key="Common.no.label" bundle="${common_labels}"/></td>
        <%}%>
		<%} // End To iterate over each column and paint the columns in correct order
		  
		 
		}
		%>	
		</tr>
	    <%
			tryl++;
			i++;
			p1++;
	} //end while

	   if(rs!=null) rs.close();
	   if(pstmt!=null)			pstmt.close();
}
	   if((orderByClause != null) && (orderByClause.length() > 0))
		{
			orderByClause.delete(0,orderByClause.length());
		}
		if((whereClause != null) && (whereClause.length() > 0))
		{
			whereClause.delete(0,whereClause.length());
		}
			if((byObserveId_criteria != null) && (byObserveId_criteria.length() > 0))
		{
			byObserveId_criteria.delete(0,byObserveId_criteria.length());
		}
	  %>
</table>
<input type='hidden' name='queue_date' id='queue_date' value='<%=queue_date%>'>
<input type='hidden' name='CAInstalled' id='CAInstalled' value="<%=CAInstalled%>" >  
<input type='hidden' name='priority_zone' id='priority_zone'  value="<%=priority_zone1%>" > 
<input type='hidden' name='queue_refresh_interval' id='queue_refresh_interval'  value="<%=queue_refresh_interval%>" >
<input type='hidden' name='checkout_yn' id='checkout_yn'  value="<%=checkout_yn%>" >
<input type='hidden' name='include_checkedout' id='include_checkedout'  value="<%=include_checkedout%>" >
<input type='hidden' name='enable_rights_yn' id='enable_rights_yn'  value="<%=enable_rights_yn%>" >
<input type='hidden' name='pract_type1' id='pract_type1'  value="<%=pract_type1%>" >
<input type='hidden' name='sel_triage_yn' id='sel_triage_yn'  value="<%=sel_triage_yn%>" >
<input type='hidden' name='sel_cons_yn' id='sel_cons_yn'  value="<%=sel_cons_yn%>" >
<input type='hidden' name='orderCriteria' id='orderCriteria'  value="<%=orderCriteria%>" >
<input type="hidden" name="finalString" id="finalString" value="<%=temp%>">
<input type='hidden' name='from' id='from' value=<%=start%> >
 <input type='hidden' name='to' id='to' value=<%=end%> >
 <input type='hidden' name='nursing_unit_code' id='nursing_unit_code'  value="<%=nursing_unit_code%>" >
 <input type='hidden' name='maxRecord' id='maxRecord'  value="<%=maxRecord%>" >
<input type='hidden' name= 'observe_id' value="<%=observe_id%>">
<input type='hidden' name= 'oper_stn_id' value="<%=oper_stn_id%>">
 <!-- Added by Dharma on Aug 1st 2017 against ML-MMOH-CRF-0631 [IN:062148] Start -->
<input type='hidden' name= 'reg_new_born_yn' value="<%=reg_new_born_yn%>">
<input type='hidden' name= 'inv_reg_new_born_yn'  value="<%=inv_reg_new_born_yn%>"> 
 <!-- Added by Dharma on Aug 1st 2017 against ML-MMOH-CRF-0631 [IN:062148] End -->

<input type='hidden' name= 'function_id' value="<%=function_id%>">
<!-- crf-362 bed_no taken hidden variable-->
<input type='hidden' name= 'bed_no' value="<%=bed_no%>">

<!-- action_on_pending_bill added for MMS-QH-CRF-0126.2 -->
<input type='hidden' name= 'action_on_pending_bill'  value="<%=action_on_pending_bill%>"> 
<input type='hidden' name= 'facility_id'  value="<%=facility_id%>"> 
	<input type='hidden' name='five_level_triage_appl_yn' id='five_level_triage_appl_yn' value='<%=five_level_triage_appl_yn%>'>

<!--Added by Rameswar on 08-Feb-16 for GDOH-CRF-081-->
<%Boolean isPracApplicable	= CommonBean.isSiteSpecific(con, "AE","PRACT_MANDATORY_AE");%>
<input type="hidden" name='isPracApplicable' id='isPracApplicable' value="<%=isPracApplicable%>">	
<!--Added by Sangeetha on 26/apr/17 for ML-MMOH-CRF-0636-->
<input type="hidden" name='sortByPriorityZone' id='sortByPriorityZone' value="<%=sortByPriorityZone%>">	

<!--Added by Ashwini on 26-Apr-2017 for ML-MMOH-CRF-0641-->
<input type="hidden" name='isDisplayAllRemarks' id='isDisplayAllRemarks' value="<%=isDisplayAllRemarks%>">	

<input type='hidden' name='sStyle' id='sStyle' value="<%=sStyle%>" >

<input type="hidden" name='isStartConsultationAppl' id='isStartConsultationAppl' value="<%=isStartConsultationAppl%>"><!--Added by Thamizh selvi on 3rd Oct 2017 against ML-MMOH-CRF-0623-->	

<input type="hidden" name='isPendingForAdmissionAppl' id='isPendingForAdmissionAppl' value="<%=isPendingForAdmissionAppl%>"><!--Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658-->	
<!--Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start-->
<input type="hidden" name='chk_for_pen_orders_bfr_chkout' id='chk_for_pen_orders_bfr_chkout' value="<%=chk_for_pen_orders_bfr_chkout%>">	
<input type="hidden" name='checkout_allow_yn' id='checkout_allow_yn' value="<%=checkout_allow_yn%>">
<!--Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End-->


<script>
hideAllGifs('pseudo');
toggleGifs('<%=orderCriteria%>','<%=asc_desc%>')
</script>
		  <%
	  }
	}
	catch(Exception e)
	{
		e.printStackTrace() ;
	}
	finally
	{	
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:10%; visibility:hidden;' bgcolor='blue'>
<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center'>
<tr><td width='100%' id='t'></td></tr>
</table>
</div>	 
</form>
</center>
<script>
alignHeading1();
</script>
</body>
</html>
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
	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>
 <script>
 //Following line of code commented by Kamakshi.N on 05/01/12 for IN-29357
		//parent.parent.frames[0].document.forms[0].reset.disabled=true;
 </script>

