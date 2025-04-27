<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- Added/Modified On 11/8/2002 -->
<%--
/**
  * Created Date		:	07th June 2002
  * Last Modified Date	:	07th June 2002
  *	Purpose				:	Displays the Search Criteria for Manage Patient.
  */
--%>
<%@page import="java.util.*,java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*,eCommon.Common.*,eAE.*, org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=8" >
  <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
 
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../../eAE/js/AEManagePatient.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script> 
<script language='javascript' src='../../eAE/js/AEUtilities.js'></script>
<script language='javascript' src='../../eAE/js/AEPractitionerComponent.js'></script>
</head>
<!--Maheshwaran K added loadFields() for ML-MMOH-CRF-1973 as on 07-07-2023-->
<body onLoad="document.forms[0].clinic_code.focus();   popTreatmentCode(document.forms[0].clinic_code,'','',''); loadFields(); showAll();" onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> 
<center>
<form name='AEMPSearchCriteriaForm' id='AEMPSearchCriteriaForm'>
<table border='0' cellpadding='2' cellspacing='0' width='100%'>

<%
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	request.setCharacterEncoding("UTF-8");
	String locale							= (String)session.getAttribute("LOCALE");
	String	facility_id						=	"";
	String	login_user_id					=	"",		clinic_type				=	"";
	String	oper_stn_id						=	"";
	String	open_to_all_pract_yn			=	"";
	String	queue_refresh_interval			=	"";	
	String	treatment_area_gender			=	"",		selected_prop			=	"";
	String  checkout_yn						=	"";
	String	open_to_all_prac_for_clinic_yn	=	"";
	String	first_clinic_code				=	"";		
	String	first_open_to_all_pract_yn		=	"";
	String where_condition					=	"";
	String pid_length						=	"";
	String sys_date							=	"";
	String p_cutoff_hours_prv_day_visit		=	"";
	String function_id						=	"";
	String nursing_unit_code				=	"";
	String observe_id						=	"";
	String nursing_unit_desc 				=	"";
	String orderCriteria 				    =	"";
		int tab_row_cnt=1;
	/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
	String color                            =   "";
	String non_critical                     =   "";
	String critical                         =   "";
	String semi_critical                    =   "";
	String unassigned                       =   "";
	String sql                              =   "";
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start*/
	String priority_zone_code				= "";
	String priority_zone_desc			= "";
	String priority_zone_color			= "";
	String priority_zone_all_codes		= "";
	String treatment_area_all_codes		= "";
	String five_level_triage_appl_yn	=  (request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");
	String	treatment_area_code				=	"",		treatment_area_desc		=	"";
	String	clinic_code						=	"",		clinic_desc				=	"";
	//Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
	//Starts
	String treatment_area_code2="";
	String bed_bay_type	=	"";
	String bed_bay_type1 =	"";
	String patient_id="";
	String patient_id1="";
	String gender="";
	String gender1="";
	String toggleValue="N";
	String practitioner_id="";
	String practitioner_id1="";
	String include_checkedout="";
	String include_checkedout1="";
	String prev_visit="";
	String prev_visit1="";
	String priorityTab = "";
	String clinic_code2="";
	String appear_as_tab_yn = "";
	String include_chk_status="";
	String prev_visit_status="";
	Boolean isAppearAsTabEnable  =false;  	
	String selectedLocationCode="";
	int zoneU	=0;
	int zoneR	=0;
	int zoneG	=0;
	int zoneY	=0;
	int zoneUForAdm	=0;
	int zoneRForAdm	=0;
	int zoneGForAdm	=0;
	int zoneYForAdm	=0;
	int allRec	=0;
	int clinicCount	=0;
	int admissionCount	=0;
	int nursingCount=0;
	int treatmentAreaCount=0;
	int allCommonCount=0;
	HashMap<String, Integer> treatmentMap = new HashMap<String, Integer>();	
	String	short_desc ="";
	String	tab_colour ="";
	String tab_font_colour ="";
	String treat_area_code="";
	int tab_count=0;
	int first_tab_cnt=0;
	/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End*/
	//Added by Sangeetha for ML-MMOH-CRF-0643 on 02/may/2017
	String priority_zone_desc_unassign			= "";
	String priority_zone_color_unassign			= "";
	String priority_zone_code_unassign			= "";
	
	/* CRF  SKR-CRF-0021 [IN028173] end  */
    int countRec1 =0;
	int		rowIndex						=	1;

	Boolean isPendingForAdmissionAppl	= false;//Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658
	Boolean boldPriorityZoneTab	= false;//Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658
	Boolean isForAdmission	= false;//Added by Kamatchi S for ML-MMOH-CRF-1972
	JSONObject forAdmissionValue = new JSONObject();
	String enable_admission_tab = "N";
	String sel_admission_yn = "";
	Boolean isLengthOfStayAppl = false; // added by mujafar for ML-MMOH-CRF-1194 
	//Added by Kamatchi S for ML-MMOH-CRF-1972 as on 21-07-2023
	Boolean sortPriorityZoneTab = false;
	Boolean waitingTimeIndYN	= false;
	String register_reattance_hours="";
	int reattance_hours=0;
	Properties p=(java.util.Properties) session.getValue("jdbc");
	ArrayList<String> locationArr = new ArrayList<String>();                                     
	ArrayList<String> treatmentArr = new ArrayList<String>();
	//Ends

	try
	{
		con				=	(Connection)	ConnectionManager.getConnection(request);
		//Added by Sangeetha for ML-MMOH-CRF-0642 on 27/apr/2017
		boldPriorityZoneTab = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "BOLD_PRIORITY_ZONE_TAB");//For SLY
		//Added by Sangeetha for ML-MMOH-CRF-0643 on 02/may/2017
		Boolean rearrangePriorityZoneTab = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "REARRANGE_PRIORITY_ZONE_TAB");

		isPendingForAdmissionAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_PENDING_FOR_ADMISSION_TAB");//Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658
		isForAdmission = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_FOR_ADMISSION_TAB");//Added by Kamatchi S for ML-MMOH-CRF-1972
		isLengthOfStayAppl      = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "LENGTH_OF_STAY_APPL"); // for SLY added by mujafar for ML-MMOH-CRF-1194

		facility_id		=	(String)		session.getValue("facility_id");
		isAppearAsTabEnable  = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","AE_TREATMENT_AREA_TAB"); //Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
		clinic_code=checkForNull(request.getParameter("clinic_code"));
			clinic_code2=clinic_code;
		if(isAppearAsTabEnable){
			
			treatment_area_code=checkForNull(request.getParameter("treatment_area_code"));
			treatment_area_code2=treatment_area_code;
			bed_bay_type=checkForNull(request.getParameter("bed_bay_type"));
				bed_bay_type1=checkForNull(request.getParameter("bed_bay_type1"));
			/*	if(bed_bay_type.equals("")) {
			bed_bay_type=bed_bay_type1;
		}
		if(!bed_bay_type1.equals("")) {
			bed_bay_type=bed_bay_type1;
		} */
			bed_bay_type1=bed_bay_type;
			patient_id=checkForNull(request.getParameter("patient_id"));
			patient_id1=patient_id;
			practitioner_id=checkForNull(request.getParameter("practitioner_id"));
			practitioner_id1=practitioner_id;
			gender=checkForNull(request.getParameter("gender"));
			gender1=gender;
			toggleValue=checkForNull(request.getParameter("toggleId1"));
			include_checkedout=checkForNull(request.getParameter("include_checkedout"),"N");
			include_checkedout1=include_checkedout;
			prev_visit=checkForNull(request.getParameter("prev_visit"),"N");
			prev_visit1=prev_visit;
			priorityTab = checkForNull(request.getParameter("priority_zone"));
		}
		//ENds
		Map<String, String> colorMap = new HashMap<String, String>();
		Map<String, String> colorFontMap = new HashMap<String, String>();
		colorMap.put("G", "Green");
		colorMap.put("R", "Red");
		colorMap.put("Y", "Yellow");
		colorMap.put("U", "ORANGE");
		//Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
		if(isAppearAsTabEnable){
		colorMap.put("PR", "Purple");
		colorMap.put("BR", "Brown");
		colorMap.put("BL", "Blue");
		colorMap.put("DB", "#00008B");
		colorMap.put("MG", "Magenta");
		colorMap.put("PK", "Pink");
		colorMap.put("CY", "Cyan");
		colorMap.put("GY", "Grey");		
		colorFontMap.put("G", "Green");
		colorFontMap.put("R", "Red");
		colorFontMap.put("Y", "Yellow");
		colorFontMap.put("U", "ORANGE");
		colorFontMap.put("PR", "White");
		colorFontMap.put("BR", "White");
		colorFontMap.put("BL", "White");
		colorFontMap.put("DB", "White");
		colorFontMap.put("MG", "White");
		colorFontMap.put("PK", "Black");
		colorFontMap.put("CY", "Black");
		colorFontMap.put("GY", "White");
		}
		//Ends
		//Added by Kamatchi S for ML-MMOH-CRF-1972 as on 21-07-2023
		//Starts
		if(isAppearAsTabEnable){
		register_reattance_hours=AEReattendanceEncounterDetails.getAEReattendanceDetails(con,facility_id,p);
		if(!register_reattance_hours.equals(""))reattance_hours=Integer.parseInt(register_reattance_hours);
		sortPriorityZoneTab = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "SORT_PRIORITY_ZONE_TAB");
		waitingTimeIndYN			=	eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "WAITING_TIME_INDICATOR");
		}
		//Ends
		StringBuffer sqlNursingUnit = new StringBuffer();
		observe_id = request.getParameter("observe_id")==null?"":request.getParameter("observe_id");
		pid_length = request.getParameter("pid_length")==null?"20":request.getParameter("pid_length");		
		login_user_id	=	(String)		session.getValue("login_user");
		function_id =	request.getParameter("function_id") ;
		if(function_id==null) function_id="";
		if(function_id.equals("AE_MANAGE_PATIENT"))
		first_tab_cnt=7;
		if(function_id.equals("AE_CHECK_OUT"))
		first_tab_cnt=6;
        oper_stn_id     = request.getParameter("oper_stn_id") ;
        if(oper_stn_id==null) oper_stn_id="";
		sys_date     = request.getParameter("sys_date") ;
        if(sys_date==null) sys_date="";
		p_cutoff_hours_prv_day_visit     = request.getParameter("p_cutoff_hours_prv_day_visit") ;
        if(p_cutoff_hours_prv_day_visit==null) p_cutoff_hours_prv_day_visit="";
		queue_refresh_interval	=	(request.getParameter("queue_refresh_interval")==null)? "0" : request.getParameter("queue_refresh_interval"); 
		checkout_yn	=	request.getParameter("checkout_yn") ;
		if(checkout_yn==null) checkout_yn="N";
		nursing_unit_code =	request.getParameter("nursing_unit_code") ;
		if(nursing_unit_code==null) nursing_unit_code="";
		orderCriteria =	request.getParameter("orderCriteria") ;
		if(orderCriteria==null) orderCriteria="";
		if(isForAdmission){
		forAdmissionValue = eAE.AECommonBean.getForAdmissionValue(con, facility_id, login_user_id);
		enable_admission_tab = (String) forAdmissionValue.get("enable_admission_tab");
		sel_admission_yn = (String) forAdmissionValue.get("sel_admission_yn");
		}
		where_condition=(checkout_yn.equals("Y"))?"and checkout_pat_yn = 'Y'":"and manage_queue_yn = 'Y' ";

		if(!observe_id.equals("")&&!nursing_unit_code.equals("")) {
			if (observe_id.equals("N")) 	{
				sqlNursingUnit.append("select  short_desc from ip_nursing_unit_lang_vw");
				sqlNursingUnit.append(" where facility_id = ? and nursing_unit_code = ? ");
			}else if (observe_id.equals("C")) 	{
				sqlNursingUnit.append("select  short_desc from op_clinic_lang_vw");
				sqlNursingUnit.append(" where facility_id = ? and clinic_code= ? ");
			}else if (observe_id.equals("T")) {
				sqlNursingUnit.append("select  short_desc from ae_tmt_area_for_clinic");
				sqlNursingUnit.append(" where facility_id = ? and TREATMENT_AREA_CODE= ? ");
			}

			pstmt		=	con.prepareStatement(sqlNursingUnit.toString());
			pstmt.setString	(1,	facility_id);
			pstmt.setString	(2,	nursing_unit_code);
			rs			=	pstmt.executeQuery();

			if(rs.next()) {
				nursing_unit_desc			=	rs.getString("short_desc");
			}
			 if(pstmt!=null) pstmt.close();
			 if(rs!=null) rs.close();
			 if((sqlNursingUnit != null) && (sqlNursingUnit.length() > 0)) {
				sqlNursingUnit.delete(0,sqlNursingUnit.length());
			}
		}
%>
 	 <tr><td colspan=4 class=label height=5></td></tr>
	<tr>
		<td class='LABEL' width='20%' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td class='fields' width='20%' ><select name='clinic_code' id='clinic_code'  onChange="popTreatmentCode(this,'','','onChange');" >
		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option> 
	<%
		StringBuffer sqlLoc = new StringBuffer();

    		sqlLoc.append("select a.clinic_code, a.long_desc clinic_desc,  a.clinic_type, a.open_to_all_pract_yn,a.speciality_code  from op_clinic_lang_vw a, (select day_no from  sm_day_of_week where day_of_week =  rtrim(to_char(sysdate,'DAY'))) b where 	 decode(b.day_no,'1',working_day_1,'2', working_day_2,'3',working_day_3,'4',  working_day_4,'5',working_day_5,'6',working_day_6,'7',working_day_7)='Y'   and a.facility_id = ? and a.clinic_type in  (select locn_type  from am_care_locn_type where care_locn_type_ind='C')   and a.level_of_care_ind = 'E'   and a.language_id='"+locale+"'  and a.eff_status = 'E'  and  (a.clinic_type, a.clinic_code) in  (select locn_type, locn_code from  am_os_user_locn_access_vw  where facility_id = ? and Oper_stn_id = ? and  appl_user_id = ?   ");
			sqlLoc.append(where_condition);
			sqlLoc.append(" ) order by 2  ");
			pstmt		=	con.prepareStatement(sqlLoc.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			pstmt.setString	(	1,	facility_id		);
			pstmt.setString	(	2,	facility_id		);
			pstmt.setString	(	3,	oper_stn_id		);
			pstmt.setString	(	4,	login_user_id	);
			rs			=	pstmt.executeQuery();
			if(rs != null)
			  {
					  rs.last();
					  countRec1 = rs.getRow();
					  rs.beforeFirst();
			  }
			  if(countRec1==1) selected_prop ="selected";
			  else selected_prop ="";
			selectedLocationCode = clinic_code;
			String spec_code="";
			while(rs.next())
			{
				clinic_code				=	rs.getString("clinic_code");
				clinic_desc				=	rs.getString("clinic_desc");
				clinic_type				=	rs.getString("clinic_type");
				open_to_all_pract_yn	=	rs.getString("open_to_all_pract_yn");
				spec_code	=	rs.getString("speciality_code");
				//Added by Kamatchi S for ML-MMOH-CRF-1972 as on 21-07-2023
				if(isAppearAsTabEnable){
				locationArr.add(clinic_code);
				}
				if(rowIndex==1) 
				{
					first_clinic_code			=	clinic_code;
					first_open_to_all_pract_yn	=	open_to_all_pract_yn;
				 
				}
				else 
				{
					//selected_prop	=	"";
				}
				//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
				//Starts
				if(isAppearAsTabEnable) {
				if(clinic_code2.equals(clinic_code))
					{
					clinic_code=clinic_code2;
					selected_prop ="selected";	
					}
				else {
					selected_prop ="";
					}	
				}
				
				//Ends
		%>
			<option value='<%=clinic_code%>' <%=selected_prop%>><%=clinic_desc%></option>
			<script>parent.AEMPSearchCriteriaFrame.openToAllPractionerYN[<%=rowIndex%>]='<%=open_to_all_pract_yn%>';
			parent.AEMPSearchCriteriaFrame.clinicType[<%=rowIndex%>]='<%=clinic_type%>';
			parent.AEMPSearchCriteriaFrame.specialtyForClinc[<%=rowIndex%>]='<%=spec_code%>';
			</script>  
	<%			
				rowIndex++;
			}
		    if(rs!=null) rs.close();
			if(pstmt!=null)	pstmt.close();
			if((sqlLoc != null) && (sqlLoc.length() > 0))
			 {
				sqlLoc.delete(0,sqlLoc.length());
			 }
	%>
		</select></td>
		<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
		<td class='LABEL'  width='20%' ><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
		<!--//Maheshwaran K added - document.forms[0].bed_bay_type1.value for ML-MMOH-CRF-1973 as on 21-07-2023-->
		<td class='fields' width='20%' ><select name='treatment_area_code' id='treatment_area_code' onChange='popBayType(this,document.forms[0].bed_bay_type1.value);checkTreatmentGender()'>
		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
	 <%
			rowIndex				=	1;
		//	clinic_code				=	(selectedLocationCode==null || selectedLocationCode.equals(""))?first_clinic_code:selectedLocationCode;
            StringBuffer sqlTrtA    = new StringBuffer();

			sqlTrtA.append("select treatment_area_code, short_desc treatment_area_desc,gender treatment_area_gender,  open_to_all_prac_for_clinic_yn  from ae_tmt_area_for_clinic_lang_vw where language_id='"+locale+"' and facility_id = ?  and CLINIC_CODE = ?  and eff_status = 'E'  order by 2 ");
			pstmt		=	con.prepareStatement(sqlTrtA.toString());

			pstmt.setString	(	1,	facility_id		);
			pstmt.setString	(	2,	clinic_code2		);

			rs			=	pstmt.executeQuery();

			while(rs.next())
			{
				treatment_area_code				=	rs.getString("treatment_area_code");
				treatment_area_desc				=	rs.getString("treatment_area_desc");
				treatment_area_gender			=	rs.getString("treatment_area_gender");
				open_to_all_prac_for_clinic_yn	=	rs.getString("open_to_all_prac_for_clinic_yn");
			
				if(treatment_area_gender==null)				treatment_area_gender			=	"";
				if(open_to_all_prac_for_clinic_yn==null)	open_to_all_prac_for_clinic_yn	=	"N";
				//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
				//Starts
				if(isAppearAsTabEnable) {
				if(treatment_area_code2.equals(treatment_area_code))
				{			
				treatment_area_code=treatment_area_code2;
				%><option selected value='<%=treatment_area_code%>'><b><%=treatment_area_desc%><b></option>
				<%}
			else {
				
				%><option value='<%=treatment_area_code%>' ><b><%=treatment_area_desc%><b></option><%
				}
				} else {
				//Ends
				%>		 
				 <option value='<%=treatment_area_code%>'><b><%=treatment_area_desc%><b></option>
				<%}%>
				<script language='javascript'> 
				parent.AEMPSearchCriteriaFrame.openToAllPractionerYN[<%=rowIndex%>]='<%=open_to_all_pract_yn%>';
				self.treatmentGender[<%=rowIndex%>] = '<%=treatment_area_gender%>';
				</script>
			<%
				rowIndex++;
			} // end of while
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
            if((sqlTrtA != null) && (sqlTrtA.length() > 0))
		    {
				sqlTrtA.delete(0,sqlTrtA.length());
		    }
		%>
		</select></td>
		<td class='LABEL' width='20%' ><fmt:message key="eAE.BedBayType.label" bundle="${ae_labels}"/></td>
		<td class='fields' width='20%'><select name='bed_bay_type' id='bed_bay_type' onChange='changeBedBayType(this)'>
		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
		</select></td>
		<td class='LABEL' align='RIGHT' colspan='2'>&nbsp;<input type='image'  value="-" src='../../eAE/images/maximize.gif' id="toggleId" onClick='toggleCriteria(this)'  alt="Maximize" height="20" width="20">&nbsp;</td>
		</tr>
		<tr id='maxCriteria1' style='display:none'>
		<td class='LABEL' width="20%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td> 
		<!--//Maheshwaran K added -practitioner_id value for ML-MMOH-CRF-1973 as on 21-07-2023-->
		<td class='fields' width="20%"><input type=text name=practitioner_desc id=practitioner_desc size=30 maxlength=30 onBlur="beforeGetPractitioner2(practitioner_id,practitioner_desc);" ><input type=hidden name=practitioner_id id=practitioner_id  value="<%=practitioner_id%>"><input type=button class=button value='?' name=Practitioner_lookup_button id=Practitioner_lookup_button onClick="getPractitioner2(practitioner_id,practitioner_desc);"><input type='hidden' name='prev_pract_name' id='prev_pract_name' value=""></td>
		<td class='LABEL'  width="20%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<!--//Maheshwaran K added -patient_id value for ML-MMOH-CRF-1973 as on 21-07-2023-->
		<td class='fields' width="20%"><input type='text' name="patient_id" id="patient_id" value="<%=patient_id%>" size='20'  maxlength="<%=pid_length%>" onKeyPress="return(CheckForSpecChars(event))" onBlur="ChangeToUpper(this)"><input type='button' class='BUTTON' value='?' name='patient_search' id='patient_search' onClick = 'callPatientSearch()'></td>
		<td class='LABEL'  width="20%" ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td class='fields' width="20%" ><select name='gender' id='gender'>
		<option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
		<%
		if(isAppearAsTabEnable) { 
			%>				
			<option value='M' <%if(gender.equals("M")){%> selected <%}%> ><fmt:message key="Common.male.label" bundle="${common_labels}"/></option> 
			<option value='F' <%if(gender.equals("F")){%> selected <%}%>  ><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
			<option value='U' <%if(gender.equals("U")){%> selected <%}%> ><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
			<% 
		}
		else {%>		 
		<option value='M' ><fmt:message key="Common.male.label" bundle="${common_labels}"/></option> 
		<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
		<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
		<%}%>
		</select></td>
		
	</tr>
	<%
		//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
		if(isAppearAsTabEnable)
			{ 
			if(include_checkedout.equals("Y"))
			{
			include_chk_status="checked";	
			}
			if(prev_visit.equals("Y"))
			{
			prev_visit_status="checked";	
			}
			}
		 if(function_id.equals("AE_REC_PAT_VAL")){%>
		<tr id='maxCriteria2' style='display:none'>
		<td class='LABEL'  width='20%' ><fmt:message key="Common.PreviousDayVisitsOnly.label" bundle="${common_labels}"/> </td>
		<%
		//Maheshwaran K added -prev_visit_status, prev_visit values ,include_checkedout,include_chk_status for ML-MMOH-CRF-1973 as on 21-07-2023
		if(isAppearAsTabEnable){ %>
		 <td class='fields' width="20%"	><input type='checkbox' name='prev_visit' id='prev_visit' value="<%=prev_visit%>" <%=prev_visit_status%>  disabled></td>
		<%}
		else {%>
			<td class='fields' width="20%"	><input type='checkbox' name='prev_visit' id='prev_visit' value='N'  disabled></td>
		<%}%>
		<td class='LABEL'  width='20%' ><fmt:message key="eAE.IncludeCheckOutPat.label" bundle="${ae_labels}"/></td>
		<%if(isAppearAsTabEnable){ %>
		<td class='fields'  width="20%"><input type='checkbox' name='include_checkedout' id='include_checkedout' value="<%=include_checkedout%>" <%=include_chk_status%> width="25%" disabled><input type='hidden' name='order_by_priority' id='order_by_priority' value=''></td>
        <%}
		else {%>
		<td class='fields'  width="20%"><input type='checkbox' name='include_checkedout' id='include_checkedout' value='N' width="25%" disabled><input type='hidden' name='order_by_priority' id='order_by_priority' value=''></td>
		<%}%>
<%}else{%>
<tr id='maxCriteria2' style='display:none'>
		<td class='LABEL'  width='20%'><fmt:message key="Common.PreviousDayVisitsOnly.label" bundle="${common_labels}"/></td>
		<%if(isAppearAsTabEnable){ %>
		<td  class='fields'  width="20%"><input type='checkbox' name='prev_visit' id='prev_visit' value="<%=prev_visit%>" <%=prev_visit_status%>  onClick="enableVal(this)" ></td>
		<%}
		else {%>
		<td  class='fields'  width="20%"><input type='checkbox' name='prev_visit' id='prev_visit' value='Y'  onClick="enableVal(this)" ></td>
		<%}%>
		<td class='LABEL'  width='20%' ><fmt:message key="eAE.IncludeCheckOutPat.label" bundle="${ae_labels}"/></td>
		<%if(isAppearAsTabEnable){ %>
		<td  class='fields'  width="20%"><input type='checkbox' name='include_checkedout' id='include_checkedout' value="<%=include_checkedout%>" <%=include_chk_status%> onClick="enableVal(this)" ><input type='hidden' name='order_by_priority' id='order_by_priority' value=''></td>
	<%}
		else {%>
		<td  class='fields'  width="20%"><input type='checkbox' name='include_checkedout' id='include_checkedout' value='Y' onClick="enableVal(this)" ><input type='hidden' name='order_by_priority' id='order_by_priority' value=''></td>
     <%
		}
		}
		%><td>&nbsp;</td>
			
	</tr>   
	
	 <tr>
	 
	<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
       <td class='fields' width="25%"><input type='button' class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Refresh.label","common_labels")%>' name='refresh' id='refresh' onClick="showAll_observID();" ></td> 
	   <td colspan=2 class=label height=5></td>
	 <td class=label height=5  width='25%' align='right' ><input  type='image' value='Config Display Order' src='../../eAE/images/config.jpeg' onClick='configFieldOrder(this);'  alt="Configure Display Order" height="20" width="20">
	 </td>
	 </tr>	
	  
	</table>
	<table id="trid" border='1'  align='left' cellpadding='0' cellspacing='0' width='100%' style='white-space: nowrap;'>

	<tr>		
	<!-- below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] -->
	<%
		//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
		//Starts
		if(isAppearAsTabEnable){ 		
		try {
			String ch_id="N";
			String asc_desc="asc";
			String ch_x="X";
			String priority_zone="";
			String locationArr1="";
			HashMap returnVal=getRecordCount(pageContext,con, facility_id,"C",clinic_code2, orderCriteria,treatment_area_code2, bed_bay_type1,practitioner_id,patient_id,gender, include_checkedout, priority_zone, p_cutoff_hours_prv_day_visit, oper_stn_id,checkout_yn, asc_desc, observe_id, "",  ch_id,  ch_x,  clinic_code2, locationArr1,  treatmentArr.toString(),"N",nursing_unit_code,login_user_id);
			zoneU			= checkForNull1((Integer)returnVal.get("zoneU"),0);
			zoneR			= checkForNull1((Integer)returnVal.get("zoneR"),0);
			zoneG			= checkForNull1((Integer)returnVal.get("zoneG"),0);
			zoneY			= checkForNull1((Integer)returnVal.get("zoneY"),0);
			zoneUForAdm			= checkForNull1((Integer)returnVal.get("zoneUForAdm"),0);
			zoneRForAdm			= checkForNull1((Integer)returnVal.get("zoneRForAdm"),0);
			zoneGForAdm			= checkForNull1((Integer)returnVal.get("zoneGForAdm"),0);
			zoneYForAdm			= checkForNull1((Integer)returnVal.get("zoneYForAdm"),0);
			allRec			= checkForNull1((Integer)returnVal.get("allRec"),0);
			clinicCount		= checkForNull1((Integer)returnVal.get("clinicCount"),0);
			admissionCount	= checkForNull1((Integer)returnVal.get("admissionCount"),0);
			nursingCount	= checkForNull1((Integer)returnVal.get("nursingCount"),0);
			treatmentAreaCount	= checkForNull1((Integer)returnVal.get("treatmentAreaCount"),0);
			treatmentMap = (HashMap)returnVal.get("treatMap");
				if (observe_id.equals("N")) 	{
				allCommonCount =nursingCount;
			}else if (observe_id.equals("C")) 	{
				allCommonCount =clinicCount;
			}else if (observe_id.equals("T")) {
			allCommonCount =treatmentAreaCount;	
			}
			}
		catch(Exception e )
			{
			e.printStackTrace();
			}
		}
		//Ends
				/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 Start*/
				sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_TAB_DESC,PRIORITY_ZONE_COLOR FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID=? and EFF_STATUS='E' ";
	 			if(!five_level_triage_appl_yn.equals("Y")){
	 				sql	= sql + "  and priority_zone not in ('B','W') ";
				}
	 			sql= sql + " order by PRIORITY_ZONE_ORDER asc";
				pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,locale) ;
			    rs    = pstmt.executeQuery();
				while(rs!=null && rs.next())
				{
					priority_zone_code	= rs.getString("PRIORITY_ZONE");
					priority_zone_desc	= rs.getString("PRIORITY_ZONE_TAB_DESC");
					priority_zone_color = (rs.getString("PRIORITY_ZONE_COLOR")==null || rs.getString("PRIORITY_ZONE_COLOR")=="")?"":rs.getString("PRIORITY_ZONE_COLOR");
				 	if(priority_zone_color.equals("")){
				 		priority_zone_color	= colorMap.get(priority_zone_code);
				 	}
				 	priority_zone_all_codes	= priority_zone_all_codes + priority_zone_code + ",";
					//START  Added by Sangeetha for ML-MMOH-CRF-0643 on 02/may/2017 
					if(rearrangePriorityZoneTab && priority_zone_code.equals("U")){ 
							priority_zone_color_unassign = priority_zone_color;
							priority_zone_desc_unassign  = priority_zone_desc;
							priority_zone_code_unassign  = priority_zone_code;
				   }else{
				 %>	<!--//Kamatchi added for Zone Count for ML-MMOH-CRF-1973 as on 07-07-2023-->
					<td class=RESUSCITATION id="priority_zone_tab_<%=priority_zone_code%>" alt="<%=priority_zone_desc%>"  align=center  style='cursor:pointer;background-color:<%=priority_zone_color%>;'nowrap onclick="FnShowPriorityWise('<%=priority_zone_code%>')">&nbsp;<%if(isForAdmission)
					{if(priority_zone_code.equals("R")){%><%=priority_zone_desc%>(<%=zoneR%>)<%}
					else if(priority_zone_code.equals("Y")){%><%=priority_zone_desc%>(<%=zoneY%>)<%}
					else if(priority_zone_code.equals("G")){%><%=priority_zone_desc%>(<%=zoneG%>)<%}
					else if(priority_zone_code.equals("U")){%><%=priority_zone_desc%>(<%=zoneU%>)<%}
					}
					else {%><%=priority_zone_desc%><%}%></td>
					<input type='hidden' name='priority_zone_color_<%=priority_zone_code%>' id='priority_zone_color_<%=priority_zone_code%>' value='<%=priority_zone_color%>'>
				<%}
				
				}
				//END  Added by Sangeetha for ML-MMOH-CRF-0643 on 02/may/2017 
				if (pstmt != null){
					pstmt.close();
				}
				if (rs!=null){
					rs.close();
				}
	%>
	<input type='hidden' name='priority_zone_all_codes' id='priority_zone_all_codes' id="priority_zone_all_codes" value='<%=priority_zone_all_codes%>' >
	<!--  Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 27th 2014 End-->
	<!--CRF  SKR-CRF-0021 [IN028173] end-->
	<!-- modified by Sangeetha for ML-MMOH-CRF-0642 on 28/apr/17 -->
	<td class=PATIENTLINECOLOR id="others" align=center style='cursor:pointer' alt="All" onclick="showAll()" nowrap><font color='white' <%if(boldPriorityZoneTab){}else{%>style="font-weight:bold" <% } %>>&nbsp;<fmt:message key="Common.all.label" bundle="${common_labels}"/></font><%if(isForAdmission)
{%>(<%=allRec%>)<%}%></td>	
	<%if(!nursing_unit_desc.equals("")){%>
	<!-- modified by Sangeetha for ML-MMOH-CRF-0642 on 28/apr/17 -->
	<td id="nurse"    align=center style='cursor:pointer;background-color:#FFCCCC' alt="nursingUnit" onclick="showNursingUnit()"nowrap><font color='RED' <%if(boldPriorityZoneTab){}else{%>style="font-weight:bold" <% } %>>&nbsp; <%=nursing_unit_desc%><%if(isForAdmission)
	{%>(<%=allCommonCount%>)<%}%>&nbsp;</font></td>		
	<%}
	//Added by Sangeetha for ML-MMOH-CRF-0643 on 02/may/2017
	if(rearrangePriorityZoneTab){%>
	<td class=RESUSCITATION id="priority_zone_tab_<%=priority_zone_code_unassign%>" alt="<%=priority_zone_desc_unassign%>"  align=center  style='cursor:pointer;background-color:<%=priority_zone_color_unassign%>;'nowrap onclick="FnShowPriorityWise('<%=priority_zone_code_unassign%>')">&nbsp;<%if(isForAdmission)
	{if(priority_zone_code_unassign.equals("U")){%><%=priority_zone_desc_unassign%>(<%=zoneU%>)<%}}
	else {%><%=priority_zone_desc_unassign%><%}%></td>
	<input type='hidden' name='priority_zone_color_<%=priority_zone_code_unassign%>' id='priority_zone_color_<%=priority_zone_code_unassign%>' value='<%=priority_zone_color_unassign%>'>
	<%} 

	/*Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658 Start*/
	//if condition is modified for ML-MMOH-CRF-1972 by Kamatchi S
	if(isPendingForAdmissionAppl || (isForAdmission && enable_admission_tab.equals("Y") && sel_admission_yn.equals("Y"))){%>
	<td id="pendingForAdmTab" align=center style='cursor:pointer;' nowrap onclick="FnShowPriorityWise('for_admission')">&nbsp;<fmt:message key="Common.for.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.admission.label" bundle="${common_labels}"/><%if(isForAdmission)
	{%>(<%=admissionCount%>)<%}%></td>
	<%}/*End*/ 
	//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
	//Starts
	try {
		if(isAppearAsTabEnable) {
		//Added for ML-MMOH-CRF-1973
		sql="SELECT TREATMENT_AREA_CODE,short_desc, appear_as_tab_yn, tab_colour FROM ae_tmt_area_for_clinic WHERE appear_as_tab_yn = 'Y' AND facility_id =? AND clinic_code =?  and treatment_area_code=NVL(?,treatment_area_code) and eff_status = 'E' "; 
		pstmt   = con.prepareStatement(sql.toString());
		pstmt.setString(1,facility_id) ;
		pstmt.setString(2,clinic_code2) ;
		pstmt.setString	(	3,	treatment_area_code2		);
		rs    = pstmt.executeQuery();							
		while(rs!=null && rs.next())
			{
			short_desc	= rs.getString("short_desc");
			appear_as_tab_yn	= rs.getString("appear_as_tab_yn");
			tab_colour	= rs.getString("tab_colour");
			treat_area_code	= rs.getString("TREATMENT_AREA_CODE");
			treatmentArr.add(short_desc);
			tab_font_colour	= colorFontMap.get(tab_colour);
			tab_colour	= colorMap.get(tab_colour);
			treatment_area_all_codes = treatment_area_all_codes + treat_area_code + ",";
			if(appear_as_tab_yn.equals("Y")){
				if(!treat_area_code.equals(nursing_unit_code)) {   
		%> 
		
		<td style='width:210px;break-row;' class=RESUSCITATION id="treatment_area_tab_<%=treat_area_code%>" alt="<%=short_desc%>"  align=center  style='cursor:pointer;background-color:<%=tab_colour%>;color:<%=tab_font_colour%>;' nowrap onclick="FnShowPriorityWise('<%=short_desc%>','TREAT_TAB','<%=treat_area_code%>','<%=appear_as_tab_yn%>')">&nbsp;
<%if(isForAdmission)
	{%><%=short_desc%>(<%=(treatmentMap.get(short_desc)!=null)?treatmentMap.get(short_desc):0%>)<%}else{%>
<%=short_desc%><%}%>
		</td>
		<%
		tab_count++;
		if((tab_count==3 && first_tab_cnt==6 && function_id.equals("AE_CHECK_OUT")) || (tab_count==2 && first_tab_cnt==7 && function_id.equals("AE_MANAGE_PATIENT")))	
			{
			tab_count=0;
			out.println("</tr>");
			out.println("<tr  width='15%'>");
			first_tab_cnt=0;
			tab_row_cnt++;
			}
		else if(tab_count==9)
			{
			tab_count=0;
			out.println("</tr>");
			out.println("<tr  width='15%'>");	
			tab_row_cnt++;
			}	 			
			}	 			
		}
	else {		
	out.println("</tr>");	
	}%>
	<input type='hidden' name='treatment_tab_color_<%=treat_area_code%>' id='treatment_tab_color_<%=treat_area_code%>' value='<%=tab_colour%>'>
<%
	}
	%>
<input type='hidden' name='treatment_area_all_codes' id='treatment_area_all_codes' id="treatment_area_all_codes" value='<%=treatment_area_all_codes%>' >
<%
	}
	if (pstmt != null){
	pstmt.close();
	}
	if (rs!=null){
	rs.close();
	} 
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
 
	//Ends //Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
	if(isForAdmission){
	%>  
	<tr  id="ForIPAdmissionTab" style='visibility:hidden'>	
	<%	try {
			sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_TAB_DESC,PRIORITY_ZONE_COLOR FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID=? and EFF_STATUS='E' ";
			if(!five_level_triage_appl_yn.equals("Y")){
			sql	= sql + "  and priority_zone not in ('B','W') ";
			}
			sql= sql + " order by PRIORITY_ZONE_ORDER asc";
			pstmt   = con.prepareStatement(sql.toString());
			pstmt.setString(1,locale) ;
			rs    = pstmt.executeQuery();
			//	 rs.beforeFirst(); 
			while(rs!=null && rs.next())
			{
			priority_zone_code	= rs.getString("PRIORITY_ZONE");
			priority_zone_desc	= rs.getString("PRIORITY_ZONE_TAB_DESC");
			priority_zone_color = (rs.getString("PRIORITY_ZONE_COLOR")==null || rs.getString("PRIORITY_ZONE_COLOR")=="")?"":rs.getString("PRIORITY_ZONE_COLOR");
			if(priority_zone_color.equals("")){
			priority_zone_color	= colorMap.get(priority_zone_code);
			}
			priority_zone_all_codes	= priority_zone_all_codes + priority_zone_code + ",";

			%>
			<td class=RESUSCITATION id="for_priority_zone_tab_<%=priority_zone_code%>" alt="<%=priority_zone_desc%>"  align=center  style='cursor:pointer;background-color:<%=priority_zone_color%>;'nowrap onclick="FnShowPriorityWise('<%=priority_zone_code%>','IP_ADM')">&nbsp;<%
			if(priority_zone_code.equals("R")){%><%=priority_zone_desc%>(<%=zoneRForAdm%>)<%}
			else if(priority_zone_code.equals("Y")){%><%=priority_zone_desc%>(<%=zoneYForAdm%>)<%}
			else if(priority_zone_code.equals("G")){%><%=priority_zone_desc%>(<%=zoneGForAdm%>)<%}
			else if(priority_zone_code.equals("U")){%><%=priority_zone_desc%>(<%=zoneUForAdm%>)<%}
			else {%><%=priority_zone_desc%><%}%></td>
			<%
			}
			if (pstmt != null){
				pstmt.close();
			}
			if (rs!=null){
				rs.close();
			}
			}
		catch(Exception e)
			{
			e.printStackTrace();
			}
		%>
<td class=PATIENTLINECOLOR id="for_others" name="for_others" align=center style='cursor:pointer' alt="All" onclick="showAll('IP_ADM')" nowrap><font color='white' style="font-weight:bold">&nbsp;<fmt:message key="Common.all.label" bundle="${common_labels}"/></font>(<%=admissionCount%>)</td>	
</tr>  
<%}%>
	</table> 
	</div>
	<script>
	//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
	if(<%=isAppearAsTabEnable%>){
	var row_ht  =(<%=tab_row_cnt%>*18)+90;	
	var frset = parent.document.getElementsByTagName("frameset")[0];
	frset.rows =  row_ht+"px, *";
	}
	</script> 
	<!-- Added by Sangeetha for ML-MMOH-CRF-0642 on 27/apr/17 -->
<%	}
	catch(Exception e)
	{
		e.printStackTrace() ;
	}
	finally
	{
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
    <input type='hidden' name='locale' id='locale' value="<%=locale%>">
    <input type='hidden' name='function_id' id='function_id' value="<%=function_id%>">
	<input type='hidden' name='queue_refresh_interval' id='queue_refresh_interval' value="<%=queue_refresh_interval%>"> 
	<input type='hidden' name='patient_gender' id='patient_gender' value="">
	<input type='hidden' name='clinic_type' id='clinic_type' value="">
	<input type='hidden' name='checkout_yn' id='checkout_yn' value="<%=checkout_yn%>">
	<input type='hidden' name='sys_date' id='sys_date' value="<%=sys_date%>">
	<input type='hidden' name='p_cutoff_hours_prv_day_visit' id='p_cutoff_hours_prv_day_visit' value="<%=p_cutoff_hours_prv_day_visit%>">
	<input type='hidden' name='first_open_to_all_pract_yn' id='first_open_to_all_pract_yn' value="<%=first_open_to_all_pract_yn%>">
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='priority_zone' id='priority_zone' value="">
	<input type='hidden' name='orderCriteria' id='orderCriteria' value='queueDate'>
	<input type='hidden' name='orderCriteria_sensor' id='orderCriteria_sensor' value='queueDate'>
	<input type='hidden' name='asc_desc' id='asc_desc' value=' asc'>
	<input type='hidden' name='asc_desc_sensor' id='asc_desc_sensor' value=''>
    <input type='hidden' name='ch_id' id='ch_id' value='N'>
	<input type='hidden' name='maxRcd' id='maxRcd'  value="" >
	<input type='hidden' name='ch_x' id='ch_x' value='X'>
	<input type='hidden' name='from' id='from' value=''>
	<input type='hidden' name='to' id='to' value=''>
	<input type='hidden' name='current_state' id='current_state' value=''>
	<input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value='<%=nursing_unit_code%>'>
	<input type='hidden' name='observe_id' id='observe_id' value='<%=observe_id%>'>
	<input type='hidden' name='five_level_triage_appl_yn' id='five_level_triage_appl_yn' value='<%=five_level_triage_appl_yn%>'>
	<input type='hidden' name='isPendingForAdmissionAppl' id='isPendingForAdmissionAppl' value='<%=isPendingForAdmissionAppl%>'><!--Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658-->
	<input type='hidden' name='isForAdmission' id='isForAdmission' value='<%=isForAdmission%>'><!--Added by Kamatchi S for ML-MMOH-CRF-1972-->
	<input type='hidden' name='enable_admission_tab' id='enable_admission_tab' value='<%=enable_admission_tab%>'><!--Added by Kamatchi S for ML-MMOH-CRF-1972-->
	<input type='hidden' name='sel_admission_yn' id='sel_admission_yn' value='<%=sel_admission_yn%>'><!--Added by Kamatchi S for ML-MMOH-CRF-1972-->
	<input type='hidden' name='isLengthOfStayAppl' id='isLengthOfStayAppl' value='<%=isLengthOfStayAppl%>'><!--Added by mujafar against ML-MMOH-CRF-1194-->
	<!-- //Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023 -->
	<input type='hidden' name='reattance_hours' id='reattance_hours' value="<%=reattance_hours%>">
	<input type='hidden' name='boldPriorityZoneTab' id='boldPriorityZoneTab' value="<%=boldPriorityZoneTab%>">
	<input type='hidden' name='loginUser' id='loginUser' value='<%=login_user_id%>'>
	<input type='hidden' name='sortPriorityZoneTab' id='sortPriorityZoneTab' value='<%=sortPriorityZoneTab%>'>
	<input type='hidden' name='waitingTimeIndYN' id='waitingTimeIndYN' value='<%=waitingTimeIndYN%>'>
	<input type='hidden' name='appear_as_tab_yn' id='appear_as_tab_yn' value="">
	<input type='hidden' name='treatment_area_code1' id='treatment_area_code1' value='' > <!--Maheshwaran K added for ML-MMOH-CRF-1973 as on 05-07-2023-->
	<input type='hidden' name='treatment_area_code2' id='treatment_area_code2' value="<%=treatment_area_code2%>" > <!--Maheshwaran K added for ML-MMOH-CRF-1973 as on 05-07-2023-->
	<input type='hidden' name='isAppearAsTabEnable' id='isAppearAsTabEnable' value="<%=isAppearAsTabEnable%>">
	<input type='hidden' name='clinic_code2' id='clinic_code2' value="<%=clinic_code2%>">
	<input type='hidden' name='bed_bay_type1' id='bed_bay_type1' value="<%=bed_bay_type1%>">
	<input type='hidden' name='bed_bay_type2' id='bed_bay_type2' value=''>
	<input type='hidden' name='practitioner_id1' id='practitioner_id1' value="<%=practitioner_id1%>">	
	<input type='hidden' name='patient_id1' id='patient_id1' value="<%=patient_id1%>">
	<input type='hidden' name='gender1' id='gender1' value="<%=gender1%>">
	<input type='hidden' name='prev_visit1' id='prev_visit1' value="<%=prev_visit1%>">	 
	<input type='hidden' name='include_checkedout1' id='include_checkedout1' value="<%=include_checkedout1%>">	 
	<input type='hidden' name='locationArr' id='locationArr' value='<%=locationArr%>'><!--Added by Kamatchi S for ML-MMOH-CRF-1972-->
	<input type='hidden' name='treatmentArr' id='treatmentArr' value='<%=treatmentArr%>'><!--Added by Kamatchi S for ML-MMOH-CRF-1972-->
	<input type='hidden' name='enableSubTabForIPAdm' id='enableSubTabForIPAdm' value="N">
	<input type='hidden' name='treatmentTabValue' id='treatmentTabValue' value="N">
	<input type='hidden' name='toggleId1' id='toggleId1' value="<%=toggleValue%>">
	<!-- / Ends /Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023 -->
</form>
</center>  
</body>
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
	public static Integer checkForNull1(Integer inputString, Integer defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}

%>
<SCRIPT LANGUAGE="JavaScript">
//Maheshwaran K added for the HSA-CRF-318
	//Start
	async function configFieldOrder(object)
	{
		var ret =await window.showModalDialog("../../eAE/jsp/AEMPSearchResultOrder.jsp","","title=Display;dialogHeight:451px;dialogWidth:270px;dialogTop=30;status:no");
		//If The Display order is saved properly the value returned will be 0
		if (ret=='0')
			{
			parent.AEMPSearchCriteriaFrame.AEMPSearchCriteriaForm.current_state.value='All';
			parent.AEMPSearchCriteriaFrame.AEMPSearchCriteriaForm.priority_zone.value='';
			parent.AEMPSearchCriteriaFrame.showAll_observID();
			}
	}
function toggleCriteria(object)
{
var function_id=parent.AEMPSearchCriteriaFrame.AEMPSearchCriteriaForm.function_id.value;
	if (object.value=="-")
	{
		object.value="+";
		object.src="../../eAE/images/minimise.gif";
		object.alt="Minimize";		
		if(function_id=='AE_MANAGE_PATIENT')
		//parent.AECurEmerFrameset.rows="21.5%,*";
			parent.document.getElementById('AEMPSearchCriteriaFrame').style.height = "24vh";
			parent.document.getElementById('AEMPSearchResultFrame').style.height = "76vh";
		if(function_id=='AE_CHECK_OUT')
	//	parent.AECurEmerFrameset.rows="22.5%,*";
			parent.document.getElementById('AEMPSearchCriteriaFrame').style.height = "13vh";
			parent.document.getElementById('AEMPSearchResultFrame').style.height = "87vh";
		parent.AEMPSearchCriteriaFrame.maxCriteria1.style="display";
		parent.AEMPSearchCriteriaFrame.maxCriteria2.style="display";
		
	}
	else
	{
		object.value="-";
		object.src="../../eAE/images/maximize.gif";
		object.alt="Maximize";
		if(function_id=='AE_MANAGE_PATIENT')
		//parent.AECurEmerFrameset.rows="12.5%,*";
		parent.document.getElementById('AEMPSearchCriteriaFrame').style.height = "12vh";
		parent.document.getElementById('AEMPSearchResultFrame').style.height = "87vh";
		if(function_id=='AE_CHECK_OUT')
		//parent.AECurEmerFrameset.rows="13%,*";
		parent.document.getElementById('AEMPSearchCriteriaFrame').style.height = "13vh";
		parent.document.getElementById('AEMPSearchResultFrame').style.height = "87vh";
		parent.AEMPSearchCriteriaFrame.maxCriteria1.style.display='none';
		parent.AEMPSearchCriteriaFrame.maxCriteria2.style.display='none';
	}
	document.getElementById("toggleId1").value=object.value;
}
//Maheshwaran K added for ML-MMOH-CRF-1973 as on 07-07-2023
//Starts
function loadFields()
	{
	var isAppearAsTabEnable =document.forms[0].isAppearAsTabEnable.value;
	if(isAppearAsTabEnable=="true" || isAppearAsTabEnable==true) {
	popBayType(document.forms[0].treatment_area_code.value,document.forms[0].bed_bay_type1.value);
	beforeGetPractitioner2(document.forms[0].practitioner_desc,document.forms[0].practitioner_id);
if(	document.getElementById("toggleId1").value == "Y")
	toggleCriteria1("-");
	}
	}
function toggleCriteria1(object)
{
var function_id=parent.AEMPSearchCriteriaFrame.AEMPSearchCriteriaForm.function_id.value;
	if (object=="-")
	{
		object="+";
		object.src="../../eAE/images/minimise.gif";
		object.alt="Minimize";	
if(function_id=='AE_MANAGE_PATIENT')
		parent.AECurEmerFrameset.rows="21.5%,*";
		if(function_id=='AE_CHECK_OUT')
		parent.AECurEmerFrameset.rows="22.5%,*";		
		parent.AEMPSearchCriteriaFrame.maxCriteria1.style="display";
		parent.AEMPSearchCriteriaFrame.maxCriteria2.style="display";
	}
	else
	{
		object="-";
		object.src="../../eAE/images/maximize.gif";
		object.alt="Maximize";
		if(function_id=='AE_MANAGE_PATIENT')
		parent.AECurEmerFrameset.rows="12.5%,*";
		if(function_id=='AE_CHECK_OUT')
		parent.AECurEmerFrameset.rows="13%,*";	
		parent.AEMPSearchCriteriaFrame.maxCriteria1.style.display='none';
		parent.AEMPSearchCriteriaFrame.maxCriteria2.style.display='none';
	}
}	
//Ends	
</SCRIPT>



</html>
<!--//Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023-->
<%! public HashMap getRecordCount(PageContext pageContext,Connection con,String facility_id,String  clinic_type,String clinic_code, String orderCriteria,String treatment_area_code,String bed_bay_type, String practitioner_id,String patient_id, String patient_gender,String include_checkedout, String priority_zone, String p_cutoff_hours_prv_day_visit, String oper_stn_id,String checkout_yn, String asc_desc, String observe_id, String maxRecord, String ch_id, String ch_x, String oberv_clinc_code, String locationArr1, String treatmentArr,String enableSubTabForIPAdm,String all_common_code,String login_user_id) throws java.sql.SQLException     
	{  
		String returnString="";
		HashMap countMap = new HashMap();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		HttpSession session = request.getSession();
		String locale = (String)session.getAttribute("LOCALE"); // added by mujafar for ML-MMOH-CRF-0632
		StringBuffer getZoneCount= null;
		StringBuffer queryStat = new StringBuffer();
		Properties p=(java.util.Properties) session.getValue("jdbc");
		String locationCode1 = "";
		String treatment_area_desc = "";
		Integer admissionCount=0;
		String priorVal = "";
		String nursingCode = "";
		HashMap<String, Integer> priorityMap = new HashMap<String, Integer>();
		HashMap<String, Integer> priorityMapForAdm = new HashMap<String, Integer>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashMap<String, Integer> treatMap = new HashMap<String, Integer>();
		int zoneU = 0;
		int zoneR = 0;
		int zoneG = 0;
		int zoneY = 0;
		int zoneUForAdm = 0;
		int zoneRForAdm = 0;
		int zoneGForAdm = 0;
		int zoneYForAdm = 0;
		int clinicCount = 0;
		StringBuffer whereClause    = new StringBuffer();
		StringBuffer orderByClause  = new StringBuffer();
		StringBuffer byObserveId_criteria  = new StringBuffer();
		StringBuffer byObserveId_criteria1  = new StringBuffer();
		PreparedStatement pstmt=null;
		ResultSet rs    = null; 
		PreparedStatement pstmt1=null;
		ResultSet rs1    = null; 
		PreparedStatement pstmt2=null;
		ResultSet rs2    = null; 
		int	columnIndex	= 1;
		int	totRec =	0;
		int max = 0;
		int treatmentAreaCount=0;
		String pendngadmdatetime = "";
		StringBuffer sqlPatQ1        = new StringBuffer();
		StringBuffer sqlForAdmVal = new StringBuffer();
		String sqlForAdmPat        = "";
		StringBuffer whereClause1   = new StringBuffer();
		StringBuffer orderByClause1  = new StringBuffer();
	//	 treatment_area_code		= checkForNull((String)	request.getParameter("treatment_area_code"));
	//	String bed_bay_type     = checkForNull((String)	request.getParameter("bed_bay_type")); 
	//	String patient_id     = checkForNull((String)request.getParameter("patient_id")); 
	//	String patient_gender      = checkForNull((String)request.getParameter("patient_gender")); 
		if(include_checkedout.equals("") || include_checkedout.equals("Y") ) include_checkedout="N"; 
		Boolean isLengthOfStayAppl      = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "LENGTH_OF_STAY_APPL");  
		Boolean isForAdmission = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_FOR_ADMISSION_TAB");//Added by Kamatchi S for ML-MMOH-CRF-1972 
		String prev_visit   = checkForNull((String)request.getParameter("prev_visit"));
		//if(prev_visit.equals("Y") ) prev_visit=""; 
		String reattance_hour         = checkForNull((String)request.getParameter("reattance_hours"));
		String register_reattance_hours="";
		int reattance_hours=0;
		//if(reattance_hour.equals(""))
	//	{
			try{
		register_reattance_hours=AEReattendanceEncounterDetails.getAEReattendanceDetails(con,facility_id,p);
		if(!register_reattance_hours.equals("")) reattance_hours=Integer.parseInt(register_reattance_hours);
			}
			catch(Exception e)
				{
					e.printStackTrace();
				}
	//	}
		String five_level_triage_appl_yn      =checkForNull((String)request.getParameter("five_level_triage_appl_yn"));
		if(five_level_triage_appl_yn.equals("") ) five_level_triage_appl_yn="N";//For five_level_triage_appl_yn in AEMPSearchResult.jsp value get by this method
		//String sortPriorityZoneTab      =(String)request.getParameter("sortPriorityZoneTab");
		Boolean sortPriorityZoneTab = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "SORT_PRIORITY_ZONE_TAB");
		if(asc_desc.equals("")) asc_desc="asc";
		Boolean waitingTimeIndYN			=	eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "WAITING_TIME_INDICATOR");
		if(ch_id.equals("N")) ch_id="";
		String ret_str     = checkForNull((String)request.getParameter("ch_x"));
		if(ret_str.equals("X")) ret_str=""; 
		String priority_status     = checkForNull((String)request.getParameter("priority_zone"));//priority_zone and priority_status same value
		String priority     = "";
		String admission_cnt     = "0";
		String oberv_TMT_code = "";//checkForNull((String)request.getParameter("oberv_clinc_code"));//oberv_clinc_code and oberv_TMT_code same value
		String priority_zone1 ="";
		String priority_zone_all_codes		= (request.getParameter("priority_zone_all_codes")==null || request.getParameter("priority_zone_all_codes")=="")?"":request.getParameter("priority_zone_all_codes");
		String loginUser			= checkForNull((String)session.getValue("login_user"));
		try { 
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
		if(priority_status.equals("for_admission") && orderCriteria.equals("")){orderCriteria="zone" ;}//priority_status
		else{if(orderCriteria.equals("")) orderCriteria="queueDate" ;}//orderCriteria
	/*	if (checkout_yn.equals("N")){
			if (observe_id.equals("C") && !oberv_clinc_code.equals("")) //checkout_yn,observe_id, oberv_clinc_code,facility_id
		{
			System.err.println("first if==============");
			byObserveId_criteria1.append("and a.locn_code='"+oberv_clinc_code+"'");
			}
		else if(observe_id.equals("T") && !oberv_TMT_code.equals("")){
			//observe_id . oberv_TMT_code
			System.err.println("second if==============");
		byObserveId_criteria1.append("and a.treatment_area_code='"+oberv_TMT_code+"'");
		}
		else{ if(!priority_status.equals("for_admission") && !priority_status.equals("")){if(observe_id.equals("T")){//priority_status,observe_id
		System.err.println("third if==============");
		byObserveId_criteria1.append("and  (a.TREATMENT_AREA_CODE not in(select nursing_unit_code from ae_param where operating_facility_id='"+facility_id+"' and  ae_observe_battery_id = '"+observe_id+"') or a.treatment_area_code is null )  "); 
		}
		//else{byObserveId_criteria1.append("and  (a.locn_code not in(select nursing_unit_code from ae_param where operating_facility_id='"+facility_id+"' and  ae_observe_battery_id = '"+observe_id+"') or a.locn_code is null  )");}
		}} 
		} */
		if(!(clinic_code.equals(""))) whereClause1.append(" and a.locn_code = ? and a.locn_type = ? "); //Clinic code
		if(!(treatment_area_code.equals(""))){whereClause1.append(" and a.treatment_area_code = ? ");} //treatment_area_code
		if(!(bed_bay_type.equals(""))){whereClause1	.append(" and d.bay_type_code = ? ");} //bed_bay_type
		if(!(practitioner_id.equals("")))		whereClause1.append(" and a.practitioner_id = ? "); //practitioner_id
		if(!(patient_id.equals("")))			whereClause1.append(" and a.patient_id = ? "); //patient_id
		if(!(priority.equals("")))				whereClause1.append(" and a.priority_indicator = ? "); //priority-always empty assign in code
		if(!(patient_gender.equals("")))		whereClause1.append(" and b.sex = ? "); //patient_gender
		if(include_checkedout.equals("Y"))		whereClause1.append(" and a.queue_status <= '07' ");//include_checkedout
		if(include_checkedout.equals("N"))		whereClause1.append(" and a.queue_status < '07' ");//include_checkedout
		if(!priority_status.equals("")){
		if(priority_status.equals("for_admission")) 
			{ 
			//whereClause1.append(" and a.PENDNG_ADMISSION_DATE_TIME IS NOT NULL ");//priority_status 
			}
		else if(priority_status.equals("observe") && isLengthOfStayAppl )
			{
			whereClause1.append("");
			} //isLengthOfStayAppl
		else {
			//whereClause1.append(" and a.priority_zone = '"+priority_status+"' ");
			}
		}
		if(!prev_visit.equals("") )//prev_visit	
		{whereClause1.append(" and (a.check_in_date_time between trunc(SYSDATE) -((1/(24*60*60))*3600*'"+p_cutoff_hours_prv_day_visit+"') and		trunc(sysdate)) ");}else{whereClause1.append(" AND SYSDATE BETWEEN a.check_in_date_time AND (("+reattance_hours+"/24)+(a.check_in_date_time))");}
		whereClause1.append(" and  (a.locn_type, a.locn_code) in  (select locn_type, locn_code from  am_os_user_locn_access_vw  where facility_id = '"+facility_id+"' and Oper_stn_id ='"+oper_stn_id+"' and  appl_user_id ='"+loginUser+"' ");
		
	
		whereClause1.append((checkout_yn.equals("Y"))?"and checkout_pat_yn = 'Y'":"and manage_queue_yn = 'Y' ");//checkout_yn
		whereClause1.append(" )"); 
	//	if(enableSubTabForIPAdm.equals("Y")){whereClause1.append(" AND A.PENDNG_ADMISSION_DATE_TIME IS NOT NULL ");	}
		if(!priority_zone_order.toString().equals("") && five_level_triage_appl_yn.equals("Y")){//priority_zone_order(check comments), five_level_triage_appl_yn
		orderByClause1.append(" DECODE(priority_zone,"+priority_zone_order.toString()+")asc,queue_date_time desc ");}
		if(orderByClause1.length() > 0){orderByClause1.append(" , ");}
		if(!priority_status.equals("for_admission")){//priority_status
		if(sortPriorityZoneTab){orderByClause1.append(" locn_desc,treatment_area_code,practitioner_name ");//sortPriorityZoneTab
		}else{orderByClause1.append(" locn_desc,treatment_area_code ");}}
		if(orderCriteria.matches("practitioner||queueDate||bed_no||patientName||patientId||age||status||priorityZone||waitingTime||zone||for_admission")){if(orderByClause1.length() > 0) orderByClause1.append(" , ");
		if(orderCriteria.equals("practitioner")){orderByClause1.append("practitioner_name"+asc_desc+" ");}else if(orderCriteria.equals("queueDate"))
		{orderByClause1.append("queue_date_time ");orderByClause1.append(""+asc_desc+" ");}
		else if(orderCriteria.equals("bed_no")){if(sortPriorityZoneTab)//sortPriorityZoneTab
		{if(priority_zone.equals("Y") || priority_zone.equals("R") )//priority_zone
		{orderByClause1.append(""+asc_desc+" ");}else{orderByClause1.append("a.AE_BED_NO ");orderByClause1.append(""+asc_desc+" ");}}else{
		orderByClause1.append("a.AE_BED_NO "); orderByClause1.append(""+asc_desc+" ");}}
		else if(orderCriteria.equals("patientName")){orderByClause1.append("b.patient_name"+asc_desc+" ");}
		else if(orderCriteria.equals("patientId")){orderByClause1.append("a.patient_id"+asc_desc+" ");}
		else if(orderCriteria.equals("age")){orderByClause1.append("year "+asc_desc+" ");}
		else if(orderCriteria.equals("status")){orderByClause1.append("a.QUEUE_STATUS"+asc_desc+" ");}
		else if(orderCriteria.equals("priorityZone")){orderByClause1.append(" PAT_PRIORITY_DESC"+asc_desc+" ");}
		else if(orderCriteria.equals("waitingTime")){orderByClause1.append("a.QUEUE_DATE ");orderByClause1.append(""+asc_desc+" ");}
		else if(orderCriteria.equals("zone")){
		if(asc_desc.equals(" asc")){orderByClause1.append("DECODE(a.PRIORITY_ZONE, 'G', 1, 'Y', 2, 'R', 3, 'U', 4) ASC");} 
		else if(asc_desc.equals(" desc")){orderByClause1.append("DECODE(a.PRIORITY_ZONE, 'R', 1, 'Y', 2, 'G', 3, 'U', 4) ASC");}
		if(priority_status.equals("for_admission")) orderByClause1.append(" queue_date_time DESC");//priority_status
		}else if(orderCriteria.equals("for_admission")){orderByClause1.append(" PENDNG_ADMISSION_DATE_TIME "); orderByClause1.append(""+asc_desc+" ");}}
		if(priority_status.equals("for_admission") && orderCriteria.equals("locType")){//priority_status
		orderByClause1.append(" locn_desc "); orderByClause1.append(""+asc_desc+" ");}
		sqlPatQ1.append("select a.rowid row_id,a.locn_code, c.long_desc locn_desc,a.treatment_area_code, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,a.LOCN_CODE,a.TREATMENT_AREA_CODE,'"+locale+"' ,'2') treatment_area_desc,AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"' ,'2') practitioner_name,  to_char(a.queue_date,'dd/mm/yyyy hh24:mi') queue_date_time,  a.priority_zone , ");//locale
		sqlPatQ1.append("  (SELECT SUM(CASE WHEN a.pendng_admission_date_time IS NOT NULL THEN 1   ELSE 0   END) FROM DUAL )   AS admission_cnt , ");
		//sqlPatQ1.append(" (SELECT SUM(CASE WHEN ( (f.assign_bed_num IS NOT NULL OR f.adt_status in ('08','09')) AND (f.patient_class ='IP' OR f.patient_class ='DC')) then 1 ELSE 0 END)  from pr_encounter f  where f.facility_id = a.facility_id   AND f.patient_id = a.patient_id ) as admission_cnt , ");
		//sqlPatQ1.append(" (SELECT SUM(CASE WHEN ( f.ATTEND_PRACTITIONER_ID is not null) then 1 ELSE 0 END) from ip_open_encounter f where f.facility_id = a.facility_id   AND f.patient_id = a.patient_id ) as admission_cnt , ");
		if(include_checkedout.equals("Y")) //include_checkedout
		sqlPatQ1.append(" to_char(a.PENDNG_ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') pendngAdmDateTime, get_waiting_time(NVL (a.DISCHARGE_DATE_TIME, SYSDATE), a.PENDNG_ADMISSION_DATE_TIME) pendngForAdmissionTime ");
		else
		sqlPatQ1.append(" to_char(a.PENDNG_ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') pendngAdmDateTime, get_waiting_time(SYSDATE, a.PENDNG_ADMISSION_DATE_TIME) pendngForAdmissionTime ");
	 	if(include_checkedout.equals("Y")){sqlPatQ1.append(" from  op_patient_queue a, mp_patient b, op_clinic_lang_vw c ");}else{//include_checkedout
		sqlPatQ1.append(" from  ae_current_patient a, mp_patient b, op_clinic_lang_vw c ");}
		if(!(bed_bay_type.equals(""))){sqlPatQ1.append(" ,ae_bed_for_trmt_area d ");}//bed_bay_type 
		if(include_checkedout.equals("Y")){sqlPatQ1.append(" where a.patient_class = 'EM' and ");}//include_checkedout
		else{sqlPatQ1.append(" where ");}	
		if(ch_id.equals("Y")){sqlPatQ1.append("  a.rowid in('"+ret_str+"') and ");}//ch_id,ret_str
		sqlPatQ1.append("   a.facility_id = ?  and a.facility_id = c.facility_id and  a.patient_id = b.patient_id  and c.language_id = '"+locale+"'  and a.facility_id=c.facility_id and a.locn_code = c.clinic_code  ");//locale
		if(!(bed_bay_type.equals(""))){
		sqlPatQ1.append(" and a.facility_id=d.facility_id AND a.locn_code=d.CLINIC_CODE AND a.TREATMENT_AREA_CODE=d.TREATMENT_AREA_CODE AND a.AE_BED_NO=d.bed_no  AND d.occupying_patient_id IS NOT NULL ");}
		
		sqlPatQ1.append(whereClause1);	
		sqlPatQ1.append(byObserveId_criteria1);	
		sqlPatQ1.append(" ORDER BY ");  
		sqlPatQ1.append(orderByClause1);
		System.err.println("Criteria count ==========================================================="+sqlPatQ1.toString());
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
	/*	System.err.println("clinic_code==================="+clinic_code);
		System.err.println("clinic_type==================="+clinic_type);
		System.err.println("treatment_area_code==================="+treatment_area_code);
		System.err.println("bed_bay_type==================="+bed_bay_type);
		System.err.println("practitioner_id==================="+practitioner_id);
		System.err.println("patient_id==================="+patient_id);
		System.err.println("priority==================="+priority);
		System.err.println("patient_gender==================="+patient_gender);
	System.err.println("===============final*******321*********************======");*/
		try
			{
			String sql = "select priority_zone from ae_priority_zone where eff_status='E'";
			String sql2 = "select NURSING_UNIT_CODE from ae_param where OPERATING_FACILITY_ID = '"+facility_id+"'";
			pstmt1		=	con.prepareStatement(sql);
			rs1	=	pstmt1.executeQuery();
			while(rs1 != null && rs1.next())
				{
				priorVal = checkForNull(rs1.getString( "priority_zone" ));
				priorityMap.put(priorVal,0);
				priorityMapForAdm.put(priorVal,0);
				}
			if (pstmt1 != null) pstmt1.close();	
			if (rs1!=null) rs1.close();
			pstmt1		=	con.prepareStatement(sql2);
			rs1	=	pstmt1.executeQuery();
			if(rs1 != null && rs1.next())
				{
				nursingCode = checkForNull(rs1.getString( "NURSING_UNIT_CODE" ));
				}
			if (pstmt1 != null) pstmt1.close();	
			if (rs1!=null) rs1.close();			
			}
		catch(Exception e)
			{
			e.printStackTrace();
			}  

		//ArrayList<String> locationArr =  (ArrayList)request.getParameter("locationArr"); 		
		String treatmentStr = treatmentArr;
		treatmentStr=treatmentStr.substring(1, treatmentStr.length() - 1);
		String[] treatArr = treatmentStr.split(", ");
		for(int i =0;i<treatArr.length;i++){
			if(treatArr[i]!=null && treatArr[i] !="") {
			treatMap.put(treatArr[i],0);
			}
		}
		String firstClinic = treatArr[0];
		try {
			rs	=	pstmt.executeQuery();	
			while(rs != null && rs.next()) 
				{
				if(max == 0) 
					{
					priority_zone1 = checkForNull(rs.getString( "priority_zone" ));
					locationCode1 = checkForNull(rs.getString( "locn_code" ));
					pendngadmdatetime = checkForNull(rs.getString( "pendngadmdatetime"));
					treatment_area_desc = checkForNull(rs.getString( "treatment_area_desc" ));
					String treatment_area_code4 =checkForNull(rs.getString( "treatment_area_code" ));
					admission_cnt =checkForNull(rs.getString( "admission_cnt" ));
					totRec = rs.getRow();
					if(observe_id.equals("T")){
							if(all_common_code.equals(treatment_area_code4)){
							treatmentAreaCount++;
							}
					}
					if(observe_id.equals("C")){
							if(all_common_code.equals(locationCode1)){
							clinicCount++;
							}		
					}
				//	if(admission_cnt.equals("0")){
					if(!pendngadmdatetime.equals(""))
						{
						admissionCount++;
						//To get for Admission Zone count
						if(priorityMapForAdm.get(priority_zone1)!=null) 
							{
							priorityMapForAdm.put(priority_zone1, priorityMapForAdm.get(priority_zone1) + 1);
							}
						}
				//	}
					//else if(locationArr!=null && nursingCode.equals(locationCode1))
						else if(  nursingCode.equals(locationCode1))
						{
						if(map.containsKey(locationCode1)) {
						map.put(locationCode1, map.get(locationCode1) + 1);
						} else {
						map.put(locationCode1, 1);
						}
						} 
					if(priorityMap.get(priority_zone1)!=null) 
						{
						priorityMap.put(priority_zone1, priorityMap.get(priority_zone1) + 1);
						}
						if(treatMap.containsKey(treatment_area_desc)) {
							treatMap.put(treatment_area_desc, treatMap.get(treatment_area_desc) + 1);
						} else {
							if(treatment_area_desc!=null && treatment_area_desc!="null" && treatment_area_desc!=""){
							treatMap.put(treatment_area_desc, 1);
							}
						}
					}
				}
			if (pstmt != null) pstmt.close();	
			if (rs!=null) rs.close();				
			}
		catch(Exception e) {
		e.printStackTrace();
		}

		try 
			{	
			for(String c: priorityMap.keySet()) {
			if(c.equals("U")) zoneU = (int) priorityMap.get(c);
			if(c.equals("R")) zoneR = (int) priorityMap.get(c);
			if(c.equals("G")) zoneG = (int) priorityMap.get(c);
			if(c.equals("Y")) zoneY = (int) priorityMap.get(c);
			}		
			for(String c1: priorityMapForAdm.keySet()) {
			if(c1.equals("U")) zoneUForAdm = (int) priorityMapForAdm.get(c1);
			if(c1.equals("R")) zoneRForAdm = (int) priorityMapForAdm.get(c1);
			if(c1.equals("G")) zoneGForAdm = (int) priorityMapForAdm.get(c1);
			if(c1.equals("Y")) zoneYForAdm = (int) priorityMapForAdm.get(c1);
			}
		/*	for(String d: map.keySet()) {
			clinicCount = map.get(d);
			}		*/	
			countMap.put("zoneU",zoneU);
			countMap.put("zoneR",zoneR);
			countMap.put("zoneG",zoneG);
			countMap.put("zoneY",zoneY);
			countMap.put("zoneUForAdm",zoneUForAdm);
			countMap.put("zoneRForAdm",zoneRForAdm);
			countMap.put("zoneGForAdm",zoneGForAdm);
			countMap.put("zoneYForAdm",zoneYForAdm);
			countMap.put("allRec",totRec);
			countMap.put("clinicCount",clinicCount);
			countMap.put("admissionCount",admissionCount);
			countMap.put("treatMap",treatMap);
			countMap.put("treatmentAreaCount",treatmentAreaCount);			
			System.err.println("totRec============================================"+totRec);
			returnString =totRec+","+zoneU+","+zoneR+","+zoneG+","+zoneY+","+clinicCount+","+admissionCount+","+treatMap;
			System.err.println("criteria cout =============="+totRec+","+zoneU+","+zoneR+","+zoneG+","+zoneY+","+clinicCount+","+admissionCount);
			}
		catch(Exception e)
			{
			e.printStackTrace();
			}
	}
	catch(Exception e2) { 
		e2.printStackTrace();
	}                   
		//For Nursing Unit Count 
		StringBuffer sqlPatQ2        = new StringBuffer();
	 StringBuffer whereClause2    = new StringBuffer();
	/*	  String  admission_date_time       = "";
     String  encounter_id			   = "";
     String  patient_id                = "";
     String  observe_id                = "";
     String  gender            = "";
    // String  bed_bay_type              = "";
	 String  patient_name              = "";
     String  Sex                       = "";
     String  nursing_unit_short_desc   = "";
     String  bed_class_short_desc      = "";
     String  bed_type_short_desc       = "";
     String  bed_no                    = "";
     String  room_no                   = "";
    // String  location_desc             = "";
	 String nursing_unit_code          = "";
	 String facility_id                = "";
	 String login_user_id			   = "";
	 String oper_stn_id                = "";
	 String	from 					   = "",		to 						=	"";
	 String CAInstalled                = "";
	 String classValue                 = "";
	 patient_id			=	checkForNull(request.getParameter("patient_id"));
	 observe_id			=	checkForNull(request.getParameter("observe_id"));
	 gender		=	checkForNull(request.getParameter("gender"));*/
	 try {
	 int nursingCount =0;
	 System.err.println("nursing_unit_code1===================================="+all_common_code);
	  System.err.println("nursingCount===================================="+nursingCount);
	 if(observe_id.equals("N")) {
	 sqlPatQ2.append(" SELECT count(1) AS recordCount  FROM ip_open_encounter a, mp_patient c   WHERE facility_id = ?  AND a.patient_id = c.patient_id");
			sqlPatQ2.append(whereClause);	
			sqlPatQ2.append(" AND a.nursing_unit_code = ? AND a.adt_status IN ('01', '02') AND nursing_unit_code IN ( SELECT a.nursing_unit_code FROM ip_nursing_unit a, am_os_user_locn_access_vw b WHERE a.facility_id = a.facility_id AND a.facility_id = b.facility_id AND a.nursing_unit_code = b.locn_code AND a.locn_type = b.locn_type AND b.locn_type = 'N' AND a.eff_status = 'E' AND b.oper_stn_id = ? AND b.appl_user_id = ?)     AND a.oth_adt_status IS NULL AND a.ip_leave_status IS NULL AND facility_id = a.facility_id");
            pstmt		=	con.prepareStatement(sqlPatQ2.toString());
			pstmt.setString	(	1,	facility_id		);
			pstmt.setString	(	2,	all_common_code	);
			pstmt.setString	(	3,	oper_stn_id		);
			pstmt.setString	(	4,	login_user_id		);
			System.err.println("sqlPatQ2.toString()=================="+sqlPatQ2.toString());
           System.err.println("facility_id " +facility_id);
		    System.err.println("all_common_code " +all_common_code);
			 System.err.println("oper_stn_id " +oper_stn_id);
			  System.err.println("login_user_id " +login_user_id);
			rs			=	pstmt.executeQuery();	
			if(rs!=null && rs.next())
			{
				nursingCount=rs.getInt("recordCount");
			}
			countMap.put("nursingCount",nursingCount);
			System.err.println("nursingCount????????????????????======="+nursingCount);
				if (pstmt != null) pstmt.close();	
			if (rs!=null) rs.close();			
		}
	 }
	 catch(Exception e)
		{
		e.printStackTrace();
		}
		//Ends  For Nursing Unit Count
        	return countMap;
	}
	%>

