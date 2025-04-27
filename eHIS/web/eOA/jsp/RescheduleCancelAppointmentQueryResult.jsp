<!DOCTYPE html>
    <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8" import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<jsp:useBean id="apptRecordSet" class="webbeans.eCommon.RecordSet" scope="session"/>
<% 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	HashMap	htRecord		=	null;
	String	operation_mode	=	"";
	String fac_id		= (String) session.getValue( "facility_id" ) ;
	StringBuffer sql3=new StringBuffer("") ;

	String curr_user_id	=(String) session.getValue( "login_user" ) ;
	String appt_ref_no	=   request.getParameter("appt_ref_no")== null?"":request.getParameter("appt_ref_no");
	String patientid	="";
	patientid = request.getParameter("patientid")== null?"":request.getParameter("patientid");
	String patname		=	java.net.URLDecoder.decode(request.getParameter("patientname")== null?"":request.getParameter("patientname"));
	String cliniccode	=	request.getParameter("cliniccode")== null?"":request.getParameter("cliniccode");
	String practcode	=	request.getParameter("practcode")== null?"":request.getParameter("practcode");
	String gender		=	request.getParameter("gender")== null?"":request.getParameter("gender");
	String apptfromdate	=	request.getParameter("apptfromdate")== null?"":request.getParameter("apptfromdate");
	String appttodate	=	request.getParameter("appttodate") == null?"":request.getParameter("appttodate");
	String clinic_type=	request.getParameter("clinic_type") == null?"":request.getParameter("clinic_type");
	String res_type=	request.getParameter("res_type") == null?"":request.getParameter("res_type");
	String day_of_week=	request.getParameter("day_of_week") == null?"":request.getParameter("day_of_week");
	String not_iden_pract=	request.getParameter("not_iden_pract") == null?"":request.getParameter("not_iden_pract");

	String reason_for_cancellation=	request.getParameter("reason_for_cancellation") == null?"":request.getParameter("reason_for_cancellation");
	String called_for=request.getParameter("called_for");
	if(called_for==null) called_for="";
	String function_id=request.getParameter("function_id");
	if(function_id ==null)function_id="";

	String locale=(String)session.getAttribute("LOCALE");
	
	if(apptfromdate ==null)apptfromdate="";
	if(appttodate ==null)appttodate="";	
	apptfromdate=DateUtils.convertDate(apptfromdate,"DMY",locale,"en");
	appttodate=DateUtils.convertDate(appttodate,"DMY",locale,"en");




	String patientname = patname.toUpperCase();
	String alcn_criteria="";
	String order_id="";
	String select_yn="";
	String chk="";
	String dis="";
	String 	apptrefno		="";
	String 	forced_yn		="";
	String cliniccode1		="";
	String patientid1="";
	String gender1="";
	String practitionerid	="";
	String apptdate			= "";
	String overbookedyn ="";	
	String apptslabfromtime= "";
	String apptslabtotime="";
	String canc_appt_yn  =""; 
	String tfr_appt_yn="";
	String tfr_appt_across_catg_yn="";
	String resourcetype="";
	String dis_age			="";
	String appt_duration	="";
	String visit_type_short_desc="";
	String clinic_short_desc="";
	String practitioner_short_name="";
	String referral_id		="";
	String classValue	 = "";
	String appt_day1	 = "";
	String visit_type_ind	 = "";
	String team_id	 = "";
	String appt_status="";
	String carelocndesc="";
	String locnType="";
	String resourceClass="";
	String book_appt_across_catg_yn="";
	String book_appt_yn="";
	String book_appt_wo_pid_yn="";
	String obook_appt_yn="";
	String create_wait_list_yn="";
	String slot_appt_ctrl="";
	String visit_limit_rule="";
	String capture_fin_dtls_yn="";
	String override_no_of_slots_yn="";
	String clinic_name="";
	String practitioner_name="";
	String time_table_type="";
	// Added for RUT-CRF-0005 Starts
	String appt_category="";
	String speciality_code="";
	String customer_id=(String)session.getValue("CUSTOMER_ID");
	
	// Added for RUT-CRF-0005 Ends
	
	//Below Line Added for this CRF [Bru-HIMS-CRF-177]
	String colour_indicator="";
	String rd_appt_yn="";// added for RD-OA CRF by shanthi on 7/12/2012

	//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
	Boolean isSlotStartMidEndAppl = false;
	String ext_cncl_yn = "N";
			
			
	int cnt=0;	
	//PreparedStatement stmtps=null;
	String secCnt="";
	//ResultSet rsps=null;
	int		lower_limit		=	0,		upper_limit			=	0;
	int		maxDispRecord	=	0;
	if(function_id.equals(""))
	{
		maxDispRecord	=	14;
	}else
	{
		maxDispRecord	=	20;
	}

	String	start_index		=	"",		end_index			=	"";

	operation_mode	=	(request.getParameter("operation_mode")==null)	?	""		:	request.getParameter("operation_mode");
	start_index		=	(request.getParameter("start_index")==null)		?	"0"		:	request.getParameter("start_index");
	if(function_id.equals(""))
	{
	end_index		=	(request.getParameter("end_index")==null)		?	"14"	:	request.getParameter("end_index");
	}else
	{
			end_index		=	(request.getParameter("end_index")==null)		?	"20"	:	request.getParameter("end_index");
	}
	lower_limit		=	Integer.parseInt(start_index);
	upper_limit		=	Integer.parseInt(end_index);

	if (!patientname.equals(""))
	{
		patientname		= 	patientname + "%" ;
	}

	Statement stmt				= null;
	ResultSet rs				= null;
	Connection conn=null;
	
	String rule_appl_yn="N";
	%>
	<HTML>
	<head>
		<!-- <script src="../../eOP/js/menu.js" language="JavaScript1.2"></script> -->
		<script src="../../eOA/js/QueryLocnForDay.js"></script>

		 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src="../../eOA/js/TransferCancelAppointment.js"></script>



	</head>
	<body OnMouseDown='CodeArrest();'onKeyDown = 'lockKey()' >
		<%	if(!function_id.equals("")) {%>	
	<form name='QueryApptForPatient1' id='QueryApptForPatient1' action='../../servlet/eOA.AppointmentDetailsServlet' method='post' target='messageFrame'>
	<%}else {%>
	<form name='QueryApptForPatient1' id='QueryApptForPatient1' >
	<%}%>

	<%
	try 
	{
		conn = ConnectionManager.getConnection(request);
		stmt	 = conn.createStatement();

		isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
		
		if (appt_ref_no ==null) appt_ref_no="";
		String oper_stn_id="";



			try
			{
			
				oper_stn_id=request.getParameter("oper_stn_id");
				if(oper_stn_id==null)	oper_stn_id	=	"";

				
					

					//String sql1 = "";
					StringBuffer sql1 = new StringBuffer();
					StringBuffer sql2 = new StringBuffer();
String sql_param="SELECT ALCN_CRITERIA,SLOT_APPT_CTRL,VISIT_LIMIT_RULE,CAPTURE_FIN_DTLS_YN,override_no_of_slots_yn,rule_appl_yn FROM oa_param where module_id='OA'";
rs 	= stmt.executeQuery(sql_param);		
if(rs !=null && rs.next())
{
		alcn_criteria=rs.getString("ALCN_CRITERIA");
		if(alcn_criteria ==null) alcn_criteria="";
		slot_appt_ctrl=rs.getString("SLOT_APPT_CTRL");
		if(slot_appt_ctrl ==null) slot_appt_ctrl="";
		visit_limit_rule=rs.getString("VISIT_LIMIT_RULE");
		if(visit_limit_rule ==null) visit_limit_rule="";
		capture_fin_dtls_yn=rs.getString("CAPTURE_FIN_DTLS_YN");
		if(capture_fin_dtls_yn ==null) capture_fin_dtls_yn="N";
		override_no_of_slots_yn=rs.getString("override_no_of_slots_yn");
		if(override_no_of_slots_yn ==null) override_no_of_slots_yn="";
		rule_appl_yn = rs.getString("rule_appl_yn") ==null?"N":rs.getString("rule_appl_yn");
}

	/*Below Query Modified for this incident[35078]*/	
	
	sql1=sql1.append("SELECT NVL (b.canc_appt_yn, 'N') canc_appt_yn, (select count(appt_ref_no) cntr from oa_resource_for_appt where appt_ref_no = a.appt_ref_no and FACILITY_ID=a.FACILITY_ID) CNT, team_id, NVL (b.tfr_appt_yn, 'N') tfr_appt_yn, NVL (b.tfr_appt_across_catg_yn, 'N') tfr_appt_across_catg_yn, b.BOOK_APPT_ACROSS_CATG_YN,b.BOOK_APPT_YN,b.BOOK_APPT_WO_PID_YN,b.OBOOK_APPT_YN,b.create_wait_list_yn, a.patient_id,  decode('"+locale+"','en',a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, get_age (a.date_of_birth) age, a.appt_type_code visit_type_ind, a.gender, TO_CHAR (a.appt_date, 'Day') appt_day1, a.appt_ref_no, NVL (a.forced_appt_yn, 'N') forced_appt_yn, TO_CHAR (a.appt_date, 'dd/mm/rrrr') appt_date, NVL (TO_CHAR (a.appt_slab_from_time, 'hh24:mi'),'00:00') appt_slab_from_time, NVL (TO_CHAR (a.appt_slab_to_time, 'hh24:mi'),'00:00') appt_slab_to_time, NVL (TO_CHAR (a.appt_duration, 'hh24:mi'), '00:00') appt_duration, OP_GET_DESC.OP_VISIT_TYPE(a.FACILITY_ID, APPT_TYPE_CODE,'"+locale+"','2') visit_type_short_desc, OP_GET_DESC.OP_CLINIC(A.FACILITY_ID, A.CLINIC_CODE,'"+locale+"','1') clinic_short_desc,	decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,'"+locale+"','1'), 'R', a.practitioner_id, AM_GET_DESC.AM_RESOURCE(a.FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_short_name , a.clinic_code, a.practitioner_id, a.overbooked_yn, a.referral_id, a.alcn_criteria, AM_GET_DESC.AM_CARE_LOCN_TYPE((select clinic_type from op_clinic where facility_id='"+fac_id+"' and CLINIC_CODE=a.clinic_code),'"+locale+"','1') care_locn_type_desc, a.care_locn_type_ind,  a.resource_class resource_class_desc, a.resource_class,a.ORDER_ID,OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.CLINIC_CODE,'"+locale+"','1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(a.FACILITY_ID, a.practitioner_id,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(a.FACILITY_ID, a.practitioner_id,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(a.FACILITY_ID, a.practitioner_id,'"+locale+"','2'))  practitioner_name, a.appt_category,a.speciality_code, COLOR_INDICATOR,RD_APPT_YN,a.ext_cncl_yn");// changed on 7/12/2012 by shanthi //ext_cncl_yn Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
	
	//Above line modified for this [Bru-HIMS-CRF-177]

	
	

if(!function_id.equals(""))
	{
		sql2 = sql2.append(",(case when order_id is not null or referral_id is not null then 'N' else 'Y' end) select_yn");
	}

   /*Below Line Commented and Added for this CRF [Bru-HIMS-CRF-0166]*/
	//sql2 =sql2.append(" FROM oa_appt a, am_os_user_locn_access_vw b WHERE a.facility_id = '"+fac_id+"' and a.facility_id = b.facility_id and b.locn_type !='N' AND a.clinic_code = b.locn_code AND b.oper_stn_id = '"+oper_stn_id+"' AND b.appl_user_id = '"+curr_user_id+"' AND a.appt_date BETWEEN TO_DATE (nvl('"+apptfromdate+"','01/01/1400'),'dd/mm/yyyy') AND TO_DATE (nvl('"+appttodate+"','31/12/5000'), 'dd/mm/yyyy') AND TO_DATE (TO_CHAR (a.appt_date, 'dd/mm/yyyy') || ' '|| TO_CHAR (a.appt_time, 'hh24:mi'),'dd/mm/yyyy hh24:mi') >=TO_DATE (TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi') AND appt_status != 'A'");
     sql2 =sql2.append(" FROM  oa_appt_del_tr a, am_os_user_locn_access_vw b, op_visit_type c WHERE a.facility_id = '"+fac_id+"' and a.facility_id = b.facility_id and b.locn_type !='N' AND a.clinic_code = b.locn_code AND b.oper_stn_id = '"+oper_stn_id+"' AND b.appl_user_id = '"+curr_user_id+"' AND a.appt_date BETWEEN TO_DATE (nvl('"+apptfromdate+"','01/01/1400'),'dd/mm/yyyy') AND TO_DATE (nvl('"+appttodate+"','31/12/5000'), 'dd/mm/yyyy') AND TO_DATE (TO_CHAR (a.appt_date, 'dd/mm/yyyy') || ' '|| TO_CHAR (a.appt_time, 'hh24:mi'),'dd/mm/yyyy hh24:mi') >=TO_DATE (TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi') AND appt_status = 'C' and a.NEW_APPT_REF_NO is null and a.NEW_WAIT_LIST_NO is null ");
	 
	  //Above Line Added "op_visit_type" table for this [Bru-HIMS-CRF-177]
	
		if(!patientid.equals(""))
		{
			sql2 = sql2.append("AND a.patient_id = '"+patientid+"'");
		}
		if(!patientname.equals(""))
		{
			sql2 = sql2.append("AND UPPER(a.patient_name) like  ('%"+patientname+"%')");
		}	if(!gender.equals(""))
		{
			sql2 = sql2.append("AND a.gender  = '"+gender+"'");
		}	if(!cliniccode.equals(""))
		{
			sql2 = sql2.append("AND a.clinic_code = '"+cliniccode+"'");
		}	
		if(!not_iden_pract.equals("Y"))
		{
		if(!practcode.equals(""))
		{
			sql2 = sql2.append("AND a.practitioner_id = '"+practcode+"'");
		}
		}else
		{
			//sql2 = sql2.append("and nvl(practitioner_id,'X') = nvl('','X')");
			//Wednesday, December 15, 2010
			sql2 = sql2.append("and a.practitioner_id is null");
		}
		if(!appt_ref_no.equals(""))
		{
			sql2 = sql2.append("AND a.appt_ref_no = '"+appt_ref_no+"'");
		}
		
		
					if(!called_for.equals("")){
						sql2 = sql2.append(" and a.RECUR_WO_SEC_RES='Y'");
					}

					if(!clinic_type.equals("")){
						sql2 = sql2.append(" and a.care_locn_type_ind='"+clinic_type+"'");
					}

					if(!res_type.equals("")){
						sql2 = sql2.append(" and a.resource_class='"+res_type+"' ");
					}

					if(!apptfromdate.equals("")){
						sql2 = sql2.append(" and trunc(to_date('"+apptfromdate+"','dd/mm/yyyy')) >= trunc(sysdate) ");
					}

					if(!day_of_week.equals(""))
				{
						sql2 = sql2.append("AND To_Char(a.appt_date,'DY') = Upper('"+day_of_week+"')");
					}
					
sql2= sql2.append("and a.facility_id = c.facility_id and a.appt_type_code = c.VISIT_TYPE_CODE"); // Added this lineCRF[Bru-HIMS-CRF-177]					
                        
					sql2= sql2.append( " order by a.appt_date,a.appt_slab_from_time, to_number(a.appt_ref_no)") ;

					
					if (rs!=null) rs.close();
			

						sql3.append(sql1.toString());
						sql3.append(sql2.toString());	
			              
						rs 	= stmt.executeQuery(sql3.toString());
						sql2.setLength(0);
						sql3.setLength(0);
						apptRecordSet.clearAll();
						
					while ( rs != null && rs.next() )
					{
						
						htRecord		= new HashMap();
						try
						{

							tfr_appt_yn				=rs.getString("tfr_appt_yn");	
							secCnt					=rs.getString("CNT");
							tfr_appt_across_catg_yn	=rs.getString("tfr_appt_across_catg_yn");	
							canc_appt_yn			=rs.getString("canc_appt_yn");	
							apptrefno				=rs.getString("appt_ref_no")	;
							forced_yn				=rs.getString("FORCED_APPT_YN")	;
							cliniccode1				=rs.getString("clinic_code"); 
							practitionerid			=rs.getString("practitioner_id"); 
							if(practitionerid==null) practitionerid="";
							apptdate				=rs.getString("appt_date"); 
							overbookedyn 			=rs.getString("overbooked_yn");   
							team_id 				=rs.getString("team_id");
							carelocndesc			=rs.getString("CARE_LOCN_TYPE_DESC")== null?"&nbsp;":rs.getString("CARE_LOCN_TYPE_DESC");
						
							resourcetype			=rs.getString("resource_class_desc");
							if(resourcetype==null) resourcetype="";
							locnType = rs.getString("care_locn_type_ind");
							resourceClass=rs.getString("resource_class");
							
							if(resourcetype.equals("P"))
			{
			resourcetype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			 }
			 else if(resourcetype.equals("E"))
			{
				resourcetype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			  }
			  else if(resourcetype.equals("R"))
			{
				resourcetype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}
			else if(resourcetype.equals("O"))
			{
				resourcetype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					
						team_id				= rs.getString("team_id")== null?"":rs.getString("team_id");
						patientid1				=rs.getString("patient_id")== null?"":rs.getString("patient_id");
						patname					=rs.getString("patient_name")== null?"":rs.getString("patient_name");
						
						dis_age					=rs.getString("age")== null?"":rs.getString("age");
						gender1					=rs.getString("gender")== null?"":rs.getString("gender");
						apptslabfromtime		=rs.getString("appt_slab_from_time")== null?"":rs.getString("appt_slab_from_time");
						apptslabtotime			=rs.getString("appt_slab_to_time")== null?"":rs.getString("appt_slab_to_time");
						appt_duration			=rs.getString("appt_duration")== null?"":rs.getString("appt_duration");
						visit_type_short_desc	=rs.getString("visit_type_short_desc")== null?"":rs.getString("visit_type_short_desc");
						clinic_short_desc		=rs.getString("clinic_short_desc")== null?"":rs.getString("clinic_short_desc");
						practitioner_short_name	=rs.getString("practitioner_short_name")== null?"":rs.getString("practitioner_short_name");
						referral_id				=rs.getString("referral_id")== null?"":rs.getString("referral_id");
						alcn_criteria				=rs.getString("alcn_criteria")== null?"":rs.getString("alcn_criteria");
						appt_day1				=rs.getString("appt_day1")== null?"":rs.getString("appt_day1");
						visit_type_ind			=rs.getString("visit_type_ind")== null?"":rs.getString("visit_type_ind");
						 book_appt_across_catg_yn=rs.getString("book_appt_across_catg_yn")== null?"N":rs.getString("book_appt_across_catg_yn");
						 book_appt_yn=rs.getString("book_appt_yn")== null?"N":rs.getString("book_appt_yn");
						 book_appt_wo_pid_yn=rs.getString("book_appt_wo_pid_yn")== null?"N":rs.getString("book_appt_wo_pid_yn");
						 obook_appt_yn=rs.getString("obook_appt_yn")== null?"N":rs.getString("obook_appt_yn");
						 create_wait_list_yn=rs.getString("create_wait_list_yn")== null?"N":rs.getString("create_wait_list_yn");
						order_id				=rs.getString("order_id")== null?"":rs.getString("order_id");
						clinic_name				=rs.getString("clinic_name")== null?"":rs.getString("clinic_name");
						practitioner_name				=rs.getString("practitioner_name")== null?"":rs.getString("practitioner_name");
						//time_table_type				=rs.getString("time_table_type")== null?"":rs.getString("time_table_type");
						if(!function_id.equals(""))
						{
						select_yn				=rs.getString("select_yn")== null?"":rs.getString("select_yn");
						}
						
						if (practitionerid==null)	practitionerid	=	"";
						appt_category				=rs.getString("appt_category")== null?"":rs.getString("appt_category");
						speciality_code				=rs.getString("speciality_code")== null?"":rs.getString("speciality_code");

						/*Below Line Added for this CRF [Bru-HIMS-CRF-177] */
				      colour_indicator=rs.getString("COLOR_INDICATOR")== null?"":rs.getString("COLOR_INDICATOR");	
				      rd_appt_yn=rs.getString("rd_appt_yn")== null?"":rs.getString("rd_appt_yn");	// added for RD-OA CRF by shanthi on 7/12/2012

					  ext_cncl_yn = rs.getString("ext_cncl_yn")== null?"N":rs.getString("ext_cncl_yn"); //Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1

						

						try
						{
				
						htRecord.put	("tfr_appt_yn",					tfr_appt_yn				);
						htRecord.put	("secCnt",					secCnt				);
						htRecord.put	("tfr_appt_across_catg_yn",		tfr_appt_across_catg_yn	);
						htRecord.put	("canc_appt_yn",				canc_appt_yn			);
						htRecord.put	("apptrefno",					apptrefno				);
						htRecord.put	("carelocndesc", carelocndesc);
						htRecord.put	("resourcetype", resourcetype);
						htRecord.put	("forced_yn",					forced_yn				);
						htRecord.put	("cliniccode1",					cliniccode1				);
						htRecord.put	("practitionerid",				practitionerid			);
						htRecord.put	("apptdate",					apptdate				);
						htRecord.put	("overbookedyn",				overbookedyn 			);
						htRecord.put	("apptslabfromtime",			apptslabfromtime		);
						htRecord.put	("apptslabtotime",				apptslabtotime			);
						htRecord.put	("patientid",					patientid1				);
						htRecord.put	("patname",						patname					);
						htRecord.put	("dis_age",						dis_age					);
						htRecord.put	("gender",						gender1					);
						htRecord.put	("appt_duration",				appt_duration			);
						htRecord.put	("visit_type_short_desc",		visit_type_short_desc	);
						htRecord.put	("clinic_short_desc",			clinic_short_desc		);
						htRecord.put	("practitioner_short_name",		practitioner_short_name	);
						htRecord.put	("referral_id",					referral_id				);
						htRecord.put	("appt_day1",					appt_day1				);
						htRecord.put	("visit_type_ind",				visit_type_ind			);
						htRecord.put	("alcn_criteria",			    alcn_criteria		);
						htRecord.put	("team_id",			    team_id		);
						htRecord.put    ("appt_status", appt_status);
						htRecord.put	("resourceClass",resourceClass);
						htRecord.put	("locnType",locnType);
						htRecord.put	("book_appt_across_catg_yn",book_appt_across_catg_yn);
						htRecord.put	("book_appt_yn",book_appt_yn);
						htRecord.put	("book_appt_wo_pid_yn",book_appt_wo_pid_yn);
						htRecord.put	("obook_appt_yn",obook_appt_yn);
						htRecord.put	("create_wait_list_yn",create_wait_list_yn);
						htRecord.put	("clinic_name",clinic_name);
						htRecord.put	("practitioner_name",practitioner_name);
						//htRecord.put	("time_table_type",time_table_type);
						
						
						htRecord.put	("order_id",order_id);
						if(!function_id.equals(""))
						{
						htRecord.put	("select_yn",select_yn);
						}
						htRecord.put	("appt_category",appt_category);
						htRecord.put	("speciality_code",speciality_code);
						
						/*Below Line Added for this CRF [Bru-HIMS-CRF-177] */
						htRecord.put("colour_indicator",colour_indicator);
						htRecord.put("rd_appt_yn",rd_appt_yn);// added for RD-OA CRF by shanthi on 7/12/2012
						htRecord.put("ext_cncl_yn",ext_cncl_yn);//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
						
						apptRecordSet.putObject(htRecord);


						}
					
						catch(Exception e)
						{
							e.printStackTrace();
						}
						
					}

			if (rs!=null) rs.close();	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
int totalRecords=0;
		 totalRecords = apptRecordSet.getSize();
	
	/*	if(cnt == 0)
					{ */
					%>	<!-- <script>
						alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
					</script> -->
					<%	
			//		}else{
		
	%>
	<p align='right'>
		<table border="0" cellspacing='0' cellpadding='0'>

		<tr>
		<td>&nbsp;</td>
		<%
		int upper_limit1=0;
		upper_limit1=upper_limit;

			try
		{
			if(upper_limit>totalRecords)	upper_limit1	=	totalRecords;
			int rowcolor=0;

			for(int i=lower_limit; i <upper_limit1; i++)
			{
				if(cnt==0)
				{
			if(function_id.equals(""))
					{
			if(!(lower_limit <= 1))
			{
		%>
			<td align ='right' id='prev'><a href="../../eOA/jsp/RescheduleCancelAppointmentQueryResult.jsp?operation_mode=Previous&start_index=<%=(lower_limit-maxDispRecord)%>&end_index=<%=(upper_limit-maxDispRecord)%>&oper_stn_id=<%=oper_stn_id%>&called_for=<%=called_for%>&practcode=<%=practcode%>&gender=<%=gender%>&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>&patientid=<%=patientid%>&patname=<%=patname%>&cliniccode=<%=cliniccode%>&appttodate=<%=DateUtils.convertDate(appttodate,"DMY","en",locale)%>&apptfromdate=<%=DateUtils.convertDate(apptfromdate,"DMY","en",locale)%>&function_id=<%=function_id%>"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>&nbsp;</td>
		<%
			}

			if(upper_limit < totalRecords)
			{
		%>
			<td align ='right' id='next' style='visibility:hidden'><a href="../../eOA/jsp/RescheduleCancelAppointmentQueryResult.jsp?operation_mode=Next&start_index=<%=(lower_limit+maxDispRecord)%>&end_index=<%=(upper_limit+maxDispRecord)%>&oper_stn_id=<%=oper_stn_id%>&called_for=<%=called_for%>&practcode=<%=practcode%>&gender=<%=gender%>&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>&patientid=<%=patientid%>&patname=<%=patname%>&cliniccode=<%=cliniccode%>&appttodate=<%=DateUtils.convertDate(appttodate,"DMY","en",locale)%>&apptfromdate=<%=DateUtils.convertDate(apptfromdate,"DMY","en",locale)%>&function_id=<%=function_id%>" ><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
		<%
			}	
		}else
		{
		if(!(lower_limit <= 1))
			{
		%>
			<td align ='right' id='prev'><a href='javascript:submitPrevNext("<%=(lower_limit-maxDispRecord)%>","<%=(upper_limit-maxDispRecord)%>","Previous")' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
		<%
			}

			if(upper_limit < totalRecords)
			{
		%>
			<td align ='right' id='next' style='visibility:hidden'><a href='javascript:submitPrevNext("<%=(lower_limit+maxDispRecord)%>","<%=(upper_limit+maxDispRecord)%>","Next")' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
		<%
			}
		}
		%>
		</tr>
		</table>
	</p>
	<table border="1" width="100%" cellspacing='0'id='vv' cellpadding='0'>
		<tr>
		<%if(!function_id.equals("")) {%>
	<td class='COLUMNHEADER' nowrap>&nbsp;</td>
		<%}%>
			<th class='COLUMNHEADER' nowrap><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></th>
			<th class='COLUMNHEADER' nowrap><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></th>
			<%if(called_for.equals("")){%>
				<th class='COLUMNHEADER' nowrap><fmt:message key="eOA.SecondaryResources.label" bundle="${oa_labels}"/></th>
			<%}%>
			<th class='COLUMNHEADER' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th class='COLUMNHEADER' nowrap><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
			
			<th class='COLUMNHEADER' nowrap><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></th>
			<th class='COLUMNHEADER' nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
			<th class='COLUMNHEADER' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
			<th class='COLUMNHEADER' nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></th> 
			<th class='COLUMNHEADER' nowrap><fmt:message key="Common.resourcename.label" bundle="${common_labels}"/></th>
			<th class='COLUMNHEADER' nowrap><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></th>
			
		</tr>
		<% }
	/*	try
		{
			if(upper_limit>totalRecords)	upper_limit	=	totalRecords;
			int rowcolor=0;

			for(int i=lower_limit; i <upper_limit; i++)
			{ */
				
				htRecord				=		(java.util.HashMap)	apptRecordSet.getObject(i);
				tfr_appt_yn				=		(String)	htRecord.get	("tfr_appt_yn");
				secCnt					=		(String)	htRecord.get	("secCnt");
				tfr_appt_across_catg_yn	=		(String)	htRecord.get	("tfr_appt_across_catg_yn");
				canc_appt_yn			=		(String)	htRecord.get	("canc_appt_yn");			
				apptrefno				=		(String)	htRecord.get	("apptrefno");	
				carelocndesc	        =		(String)	htRecord.get	("carelocndesc");
				
				resourcetype			=    (String) htRecord.get ("resourcetype");
				forced_yn				=		(String)	htRecord.get	("forced_yn");	
				
				cliniccode1				=		(String)	htRecord.get	("cliniccode1");		
				practitionerid			=		(String)	htRecord.get	("practitionerid");
				apptdate				=		(String)	htRecord.get	("apptdate");			
				appt_status             =       (String)    htRecord.get    ("appt_status");
				overbookedyn 			=		(String)	htRecord.get	("overbookedyn");		
				apptslabfromtime		=		(String)	htRecord.get	("apptslabfromtime");		
				apptslabtotime			=		(String)	htRecord.get	("apptslabtotime");
				patientid				=		(String)	htRecord.get	("patientid");		
				if(patientid==null || patientid.equals("")){
					patientid="dummy_patinetID";
				}
				resourceClass			=		(String)    htRecord.get	("resourceClass");
				locnType				=		(String)	htRecord.get	("locnType");
				if(patientid==null || patientid.equals("")) patientid="";
				patname					=		(String)	htRecord.get	("patname");
				dis_age					=		(String)	htRecord.get	("dis_age");
				if(dis_age==null || dis_age.equals("")) dis_age="&nbsp;";
				gender					=		(String)	htRecord.get	("gender");			
				appt_duration			=		(String)	htRecord.get	("appt_duration");	
				visit_type_short_desc	=		(String)	htRecord.get	("visit_type_short_desc");
				
				clinic_short_desc		=		(String)	htRecord.get	("clinic_short_desc");	
				if(clinic_short_desc==null || clinic_short_desc.equals("")) clinic_short_desc="&nbsp;";
				practitioner_short_name	=		(String)	htRecord.get	("practitioner_short_name");
				if(practitioner_short_name==null || practitioner_short_name.equals("")) practitioner_short_name="&nbsp;";
				referral_id				=		(String)	htRecord.get	("referral_id");
				if(referral_id==null || referral_id.equals("")) referral_id="";
				
				alcn_criteria				=		(String)	htRecord.get	("alcn_criteria");
				if(alcn_criteria==null || alcn_criteria.equals("")) alcn_criteria="";
				appt_day1				=		(String)	htRecord.get	("appt_day1");
				visit_type_ind				=		(String)	htRecord.get	("visit_type_ind");
				team_id				=		(String)	htRecord.get	("team_id");
				book_appt_across_catg_yn				=		(String)	htRecord.get	("book_appt_across_catg_yn");
				book_appt_yn				=		(String)	htRecord.get	("book_appt_yn");
				book_appt_wo_pid_yn				=		(String)	htRecord.get	("book_appt_wo_pid_yn");
				obook_appt_yn				=		(String)	htRecord.get	("obook_appt_yn");
				create_wait_list_yn				=		(String)	htRecord.get	("create_wait_list_yn");
			
				order_id	=		(String)	htRecord.get	("order_id");
				
				clinic_name	=		(String)	htRecord.get	("clinic_name");
				practitioner_name	=		(String)	htRecord.get	("practitioner_name");
				//time_table_type	=		(String)	htRecord.get	("time_table_type");
				appt_category	=		(String)	htRecord.get	("appt_category");
				speciality_code	=		(String)	htRecord.get	("speciality_code");
				
				/*Below Line Added for this CRF [Bru-HIMS-CRF-177] */
				colour_indicator=(String)	htRecord.get("colour_indicator");
				rd_appt_yn=(String)	htRecord.get("rd_appt_yn");// added for RD-OA CRF by shanthi on 7/12/2012
				ext_cncl_yn = (String) htRecord.get("ext_cncl_yn");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
				
				if(!function_id.equals(""))
						{
				select_yn	=		(String)	htRecord.get	("select_yn");
						}
				if(appt_day1==null || appt_day1.equals("")) appt_day1="";
				if(visit_type_ind==null || visit_type_ind.equals("")) visit_type_ind="";
				if(team_id==null || team_id.equals("")) team_id="";

												
				if ( rowcolor % 2 == 0 )
				classValue = "QRYEVEN" ;
				else
				classValue = "QRYODD" ;
				
				if(select_yn.equals("Y"))
				{
					chk="CHECKED";
					dis="";
				}else
				{
					chk="";
					dis="DISABLED";
				}
			String referral_value="C";
			String episode_type="";
				if(locnType.equals("D"))
				{
					episode_type="I";
				}else
				{
					episode_type="O";

				}
				String apptdate_display="";
				apptdate_display=DateUtils.convertDate(apptdate,"DMY","en",locale);
				%>
					
				<tr>
				<%	if(!function_id.equals("")) {%>	
					<td class='<%=classValue%>' nowrap><input type="checkbox"  name='check_val<%=i%>' id='check_val<%=i%>' onclick="show_second(this,'<%=apptrefno%>')" <%=chk%><%=dis%> ></input><input type='hidden' name='final_val<%=i%>' id='final_val<%=i%>' value='<%=apptrefno%>|<%=referral_value%>|<%=episode_type%>|<%=apptdate%>|<%=forced_yn%>|<%=visit_type_ind%>|<%=patientid%>'></input></td>
					<%}%>
				<% if(forced_yn.equals("N")){ %>

						<%if(called_for.equals("")){%>
						
						<%if(function_id.equals("")) {%>
						<!--<td class='<%=classValue%>' onMouseOver='hideToolTip()' onClick="reschdisplayToolTip('<%=tfr_appt_yn%>','<%=tfr_appt_across_catg_yn%>','<%=canc_appt_yn%>','<%=apptrefno%>','<%=cliniccode1%>','<%=practitionerid%>','<%=apptdate%>',	'<%=overbookedyn%>','<%=apptslabfromtime%>','<%=apptslabtotime%>','<%=appt_day1.trim()%>','<%=visit_type_ind%>','<%=team_id%>','N','<%=resourceClass%>','<%=locnType%>','<%=patientid%>','<%=book_appt_across_catg_yn%>','<%=book_appt_yn%>','<%=book_appt_wo_pid_yn%>','<%=obook_appt_yn%>','<%=create_wait_list_yn%>','<%=time_table_type%>','<%=referral_id%>','<%=practitioner_name%>','<%=clinic_name%>','<%=appt_category%>','<%=speciality_code%>')" nowrap>-->
						<!--<td class='<%=classValue%>' onMouseOver='hideToolTip()' onClick="reschdisplayToolTip('<%=fac_id%>','<%=patientid%>','<%=speciality_code%>','<%=cliniccode1%>','<%=practitionerid%>','<%=tfr_appt_yn%>','<%=tfr_appt_across_catg_yn%>','<%=canc_appt_yn%>','<%=apptrefno%>','<%=cliniccode1%>','<%=practitionerid%>','<%=apptdate%>',	'<%=overbookedyn%>','<%=apptslabfromtime%>','<%=apptslabtotime%>','<%=appt_day1.trim()%>','<%=visit_type_ind%>','<%=team_id%>','N','<%=resourceClass%>','<%=locnType%>','<%=patientid%>','<%=book_appt_across_catg_yn%>','<%=book_appt_yn%>','<%=book_appt_wo_pid_yn%>','<%=obook_appt_yn%>','<%=create_wait_list_yn%>','<%=time_table_type%>','<%=referral_id%>','<%=practitioner_name%>','<%=clinic_name%>','<%=appt_category%>','<%=speciality_code%>')" nowrap>-->
						<!--<td class='<%=classValue%>' onMouseOver='hideToolTip()' onClick="reschdisplayToolTip('<%=create_wait_list_yn%>','<%=book_appt_yn%>','<%=apptrefno%>')" nowrap>-->
						<!--<td class='<%=classValue%>' onMouseOver='hideToolTip()' onClick="reschdisplayToolTip('<%=apptrefno%>')" nowrap>-->
						<td class='<%=classValue%>' onMouseOver='hideToolTip()' onClick="reschdisplayToolTip('<%=apptrefno%>','<%=cliniccode1%>','<%=practitionerid%>','<%=apptdate%>','<%=fac_id%>','<%=patientid%>','<%=locnType%>','<%=rd_appt_yn%>','<%=isSlotStartMidEndAppl%>','<%=ext_cncl_yn%>')" nowrap><!--included rd_appt_yn as parameter by shanthi on 7/12/2012 -->
						<a href="javascript:callDummy()"><%=apptrefno%></a></td>
					
						<%}else {%>
				<td  class = '<%=classValue%>'  nowrap><%=apptrefno%></td>
					<%}%>
						<%}else{%>

							<td class='<%=classValue%>' onClick="displaydet_for_sec('<%=apptrefno%>','<%=cliniccode1%>','<%=practitionerid%>','<%=apptdate%>',	'<%=overbookedyn%>','<%=apptslabfromtime%>','<%=apptslabtotime%>','<%=appt_day1.trim()%>','N','<%=resourceClass%>')" nowrap> 
							<a href="javascript:callDummy()"><%=apptrefno%></a></td>

						<%}%>


					<% } else {%>
					
					<%if(function_id.equals("")) {%>
					<!--<td  title = 'Forced Appointment' class = 'OAFORCED' onClick="reschdisplayToolTip('<%=tfr_appt_yn%>','<%=tfr_appt_across_catg_yn%>','<%=canc_appt_yn%>','<%=apptrefno%>','<%=cliniccode1%>','<%=practitionerid%>','<%=apptdate%>','<%=overbookedyn%>','<%=apptslabfromtime%>','<%=apptslabtotime%>','<%=appt_day1.trim()%>','<%=visit_type_ind%>','<%=team_id%>','F','<%=resourceClass%>','<%=locnType%>','<%=patientid%>','<%=book_appt_across_catg_yn%>','<%=book_appt_yn%>','<%=book_appt_wo_pid_yn%>','<%=obook_appt_yn%>','<%=create_wait_list_yn%>','<%=time_table_type%>','<%=referral_id%>','<%=practitioner_name%>','<%=clinic_name%>','<%=appt_category%>','<%=speciality_code%>')" nowrap> -->
					<!--Modified against HSA-SCF-0045 -->
					<td title = 'Forced Appointment' class = 'OAFORCED' onClick="reschdisplayToolTip('<%=apptrefno%>','<%=cliniccode1%>','<%=practitionerid%>','<%=apptdate%>','<%=fac_id%>','<%=patientid%>','<%=locnType%>','<%=rd_appt_yn%>','<%=isSlotStartMidEndAppl%>','<%=ext_cncl_yn%>')" nowrap>
					<a href="javascript:callDummy()">
					<%=apptrefno%></a></td>
					<%}else {%>
				<td  title = 'Forced Appointment' class = 'OAFORCED'  nowrap><%=apptrefno%></td>
					<%}%>
					<% }%>
				
				<td class="<%=classValue%>" nowrap onClick=hideToolTip()><%=apptdate_display%></td>

				<%String tmp_ref_no=apptrefno;%>
				<%if(called_for.equals("")){%>
				<td nowrap class="<%=classValue%>">
					<%if(!secCnt.equals("0")){%><a href="javascript:show_Reference_details('<%=tmp_ref_no%>','<%=fac_id%>')"><fmt:message key="Common.details.label" bundle="${common_labels}"/></a>
				<%}%>&nbsp;</td>
				<%}%>


				<td class="<%=classValue%>" nowrap onClick=hideToolTip()>
				
				<%
					if(patientid.equals("dummy_patinetID")){
						out.println("&nbsp;");
					}else{
						out.println(patientid);
					}					
				%>
				</td>
				<td class="<%=classValue%>" nowrap >
				<%=patname%>,<%=gender%>,<%=dis_age%></td>
					
		
				<td nowrap style="background-color:<%=colour_indicator%>;FONT-SIZE:8pt;"><%=visit_type_short_desc%></td> <%/*Modified for this CRF [Bru-HIMS-CRF-177]*/%>
				<td nowrap class='<%=classValue%>'><%=carelocndesc%></td>
				<td nowrap class='<%=classValue%>'><%=clinic_short_desc%></td>
			
				<td nowrap class='<%=classValue%>'><%=resourcetype%></td>
					<%
				/*Below Line Mofified for this incident [35078]*/	
				String patname10 = practitioner_name == null?"":practitioner_name;
				%>
				<td nowrap class='<%=classValue%>'><%=patname10%>&nbsp;</td>
				<%
				String patname11 = referral_id== null?"":referral_id;
				%>
				<td nowrap class='<%=classValue%>'><%=patname11%>&nbsp;</td>
				
				</tr>
					<%
				rowcolor++;		
				cnt++;
				//htRecord.clear();
				}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
//	}

	if(cnt == 0)
	{%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>
	<%}
int cantchk=0;
if(function_id.equals(""))
	{
	cantchk=14;
	}else
	{
		cantchk=20;
	}
	//boolean flag = false;
	if ( cnt < cantchk  ) {
	%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='hidden';
		</script>
	<% //flag = true;
			} else {%>
		<script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}

		//if (rsps!=null) rsps.close();
		if ( rs != null ) rs.close() ;
		//if (stmtps!=null) stmtps.close();
	    if ( stmt != null ) stmt.close() ;
	}
	catch ( Exception e )
	{
		e.printStackTrace();
	}
	finally
	{   
		if(conn !=null) ConnectionManager.returnConnection(conn,request);

	}
%>  
	</table>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
		<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center'>
			<tr><td width='100%' id='t'></td></tr>
		</table>
	</div>	 
</center>
<input type='hidden' name='canc_appt_yn' id='canc_appt_yn' value='<%=canc_appt_yn%>' >
<input type='hidden' name='alcn_criteria' id='alcn_criteria' value='<%=alcn_criteria%>' >
<input type='hidden' name='cnt' id='cnt' value='<%=(lower_limit+maxDispRecord)%>' >
<input type='hidden' name='forced' id='forced' value='<%=forced_yn%>' >
<input type='hidden' name='reason_for_cancellation' id='reason_for_cancellation' value='<%=reason_for_cancellation%>' >
<input type='hidden' name='function1' id='function1' value='BulkCancel' >
<input type='hidden' name='final_value' id='final_value' value=''>
<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
<input type='hidden' name='from_part' id='from_part' value=''>
<input type='hidden' name='slot_appt_ctrl' id='slot_appt_ctrl' value='<%=slot_appt_ctrl%>'>
<input type='hidden' name='visit_limit_rule' id='visit_limit_rule' value='<%=visit_limit_rule%>'>
<input type='hidden' name='capture_fin_dtls_yn' id='capture_fin_dtls_yn' value='<%=capture_fin_dtls_yn%>'>
<input type='hidden' name='override_no_of_slots_yn' id='override_no_of_slots_yn' value='<%=override_no_of_slots_yn%>'>
<input type='hidden' name='clinic_name' id='clinic_name' value='<%=clinic_name%>'>
<input type='hidden' name='practitioner_name' id='practitioner_name' value='<%=practitioner_name%>'>
<input type='hidden' name='res_type' id='res_type' value='<%=res_type%>'>
<input type='hidden' name='customer_id' id='customer_id' value='<%=customer_id%>'>
<input type='hidden' name='rule_appl_yn' id='rule_appl_yn' value='<%=rule_appl_yn%>'>

	<input type="hidden" name="xxxx" id="xxxx"  value ="">
	<input type="hidden" name="xx" id="xx"  value ="">
	<input type="hidden" name="facility_id" id="facility_id"  value ="<%=fac_id%>">
	



</form>
</body>
<script>
	
	if(parent.frames[1].document.forms[0].select)
 	parent.frames[1].document.forms[0].select.disabled=false;

</script>	
</html>

