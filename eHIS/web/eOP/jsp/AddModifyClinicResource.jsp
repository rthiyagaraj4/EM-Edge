<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*, eCommon.XSSRequestWrapper, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html> 
<head>

<%


request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String function_id				=	request.getParameter("function_id");
String locale = localeName;
String imgUrl= "";
	if(sStyle.equals("IeStyle.css"))
	{
		imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	}
	%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eOP/js/PatInstructions.js'></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></script>
	<%
		String callfunc=(request.getParameter("call_func") == null)?"":request.getParameter("call_func");
		
	    String central_value="";
		if(callfunc.equals("Clinic"))
		{
		  central_value="C"; 
		%>
			<script language='javascript' src='../../eOP/js/ClinicForResource.js'></script>
		    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
		<%
		}
		else if(callfunc.equals("ProcedureUnit"))
		{
			central_value="E";
		%>
			<script language='javascript' src='../../eOP/js/ProcUnit.js'></script>
		<%
		}
		else if(callfunc.equals("DaycareUnit"))
		{
			central_value="Y";
		%>
			<script language='javascript' src='../../eOP/js/DaycareUnit.js'></script>
		<%
		}
		%>
				
			<!-- <script src='../../eCommon/js/dchk.js' language='javascript'></script>	-->	
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>		
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<script>
		//Added for MO-CRF-20121.1 BY SHAGAR
		function SpCharChkForContNo(event) 
		{
		var strCheck = '0123456789-+abcdefghijlkmnopqrstuvwxyzABCDEFGHIJLKMNOPQRSTUVWXYZ';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		} 
		//Added for MO-CRF-20121.1 BY SHAGAR
		function isValidCharacter(elementRef) { 
		   var regExp ="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-+";
		   var checkValue = new String(elementRef.value);     
			 for (var i=0; i<checkValue.length; i++)
			 {	
				if (regExp.indexOf(checkValue.charAt(i)) == -1) {	
						var msg = getMessage("RES_MOB_NO_SPL_NOT_ALLOWED",'MP');
						alert(msg);
						elementRef.value = "";
						elementRef.focus();
						return false;		  
				}
			  
			}  
		}
		
		
		function allowNumOnly(event)
		{
			var strCheck = '0123456789';
			var whichCode = (window.Event) ? event.which : event.keyCode;
			key = String.fromCharCode(whichCode);  // Get key value from key code
			if (strCheck.indexOf(key) == -1)
				return false;  
			else
				return true ;			
		}
		function chkValue(obj)
		{
			if(obj.value!="")
			{
				if(obj.value<0)
				{
					alert(getMessage("ONLY_POSITIVE_NUM","SM"));
					obj.select();
				}
			}
		}
function movefocus(obj)
{
	if(obj.name=="base_slot_slab_time")
		document.forms[0].allow_visit_regn_yn.focus();
	if(obj.name=="num_appl")
		document.forms[0].speciality.focus();

}

	</script>

</head>
	
<body onload="vitalenable();setfocus(this);" OnMouseDown="CodeArrest();" onKeyDown='lockKey();' onselect='dragdown(this);'>
<div id='titlebar'>
<%
    	String facilityid=(String)session.getValue("facility_id");     
		
		PreparedStatement pstmt = null;		
		ResultSet rs = null;    
		Connection conn = null;
		Statement dfstmt=null;
		ResultSet dfrset=null;

		try{
			conn=ConnectionManager.getConnection(request);
			String fnval="";
			//String serial_no="";
			//String instruction_id="";
           // String instruction_desc="";
			//String mode="";
            String mode_flag="false";
			String cliniccode=request.getParameter("clinic_code");
			if(cliniccode == null || cliniccode.equals("null")) cliniccode="";	
			//serial_no=(request.getParameter("serial_no")==null)?"":request.getParameter("serial_no");
			//instruction_id=(request.getParameter("instruction_id")==null)?"":request.getParameter("instruction_id");
		    //instruction_desc=(request.getParameter("instruction_desc")==null)?"":request.getParameter("instruction_desc");
			//mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");				
					
			String effstatus="E";
			String daysofweek="";
			
			String weekapplicability[]=new String[7];
			String weekapplicabilitydesc[]=new String[7];

			String workingdays[]=new String[7];
			String workingweek1day[] = new String[7];
			String workingweek2day[] = new String[7];
			String workingweek3day[]=  new String[7];
			String workingweek4day[] = new String[7];
			String workingweek5day[] = new String[7];			
			
			/*String pract_working_week1_day[]=new String[7];
			String pract_working_week2_day[]=new String[7];
			String pract_working_week3_day[]=new String[7];
			String pract_working_week4_day[]=new String[7];
			String pract_working_week5_day[]=new String[7];*/
			
			String allowvisitreg="N";
			String allowwalkin="N";
			String allowappt="N";
			String allowref="N";
			String allownonref="N";
			String agegroupcode="";
			String agegroupdesc="";
			String agecode="";
			String levelofcare="";
			String levelofcaredesc="";
			String speccode="";
			 String specdesc="";
			 String specialitycode="";
			 String vitalsign="";
			 String vitalsigndesc="";
			 String vitalsigncode="";
			 String acctdept="";
			 String acctdeptdesc="";
			 String acctdeptcode="";
			 String section="";
			 String sectiondesc="";
			 String sectioncode="";
			 String service="";
			 String servicedesc="";
			 String servicecode="";
			 String mrsectype="";
			 String mrsectypedesc="";
			 String mrsection="";
			 String mrsectiondesc="";
			 String mrsectioncode="";
			 String fslocn="";
			 String fslocndesc="";
			 String fslocncode="";
			 String autofilereq="N";
			 String dfltfiletype="";
			 String dfltfiletypedesc="";
			 String emerchk="N";
			 String firstchk="Y";
			 String followchk="Y";
			 String routinechk="Y";
			 String serieschk="Y";
			 String consultchk="Y";
			 String practtype="";
			 String practtypedesc="";
			 String practtypecode="";
			 String open_to_all_pract_yn="N";
			 String chkinident="";
			 String chkinidentdesc="";			 
			 String selunassgnyn="N";	
			 String allowconsult="";
			 String allowconsultdesc="";
			 StringBuffer sql = new StringBuffer();
			 String sql1="";
			 String chkval="";
			 String disable="";
			 String disable1="";
			 String disable2="";
			 
			 String disable_QNM=""; // By Himanshu For ML-BRU-CRF-0628.11 on 02-05-2023
			
			 String fm_install_yn="";
			 String rcdvitsgn="";
			 String rcdimmun="";
			 String rcdoutcome="";
			 String workingstarttime="";
			 String workingendtime="";
			 String baseslabslottime="";
			 String sel="";
			/* String pract_working_day1="";
			 String pract_working_day2="";
			 String pract_working_day3="";
			 String pract_working_day4="";
			 String pract_working_day5="";
			 String pract_working_day6="";
			 String pract_working_day7="";*/
			 int visitcnt=0;
			 int cnt=0;
			 int reportCount=0;
			 String primaryresclass="";
			 String primaryresclassdesc="";
			 String opchk="N";
			 String dcchk="N";
			 String ipchk="N";			
			 String emchk="N";
			 StringBuffer dfsql=new StringBuffer();
			 String default_code="";
			 String default_desc="";
			 String selvalue="";
			 String maintain_doc_or_file="F";
			 String defaultdisable="";
			 String SEPARATE_FILE_NO_YN="";
		     String sormfiles="";
			 String mrflag="Y";
			 String mrflag1="Y";
			 String fsflag="Y";
			 String queue_num_appl="N";
			 
			 String queue_no_mandate="N"; //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 02-05-2023-->
			 
			 String by_pract_appl="N";
			 String by_res_appl="N";
			 String by_room="N";
			 String other_res_class="";
			 String other_res_desc="";
			 //String other_res_type="";
			 String ckval="";
			 
			 String ckval_QNM="";  // by Himanshu for ML-BRU-CRF-0628.11 on 02-05-2023
			 
			// String ckval1="";
			 //String ckval2="";
			 //String ckval3="";
			 //String ckdisable="disabled";
			 //String ckdisable1="disabled";
			 //String sql2="";
			 String msql="";
			 
			 String assign_q_num_by = "";
			 String clinic_type = "";
			 String create_file_yn = "";
             String specialitydesc="";
             String reportSql="";
			 String max_walkin_for_day[] = new String[7];

			 String radAppYn = "N";
			 String disMrSection = "";
			
			String CATEGORY=""; //added by Ajay H. for MMS-DM-CRF-0209.4
			String qms_interfaced_yn="N";//Changes for Bru-HIMS-CRF 192.1
			String qms_chkval="";//Changes for Bru-HIMS-CRF 192.1
			String multi_speciality_yn="N";//Changes for Bru-HIMS-CRF 198
			String multi_speciality_disabled="";//Changes for Bru-HIMS-CRF 198
			String contact_no="";//Changes for MO-CRF-20121.1
			
			// Added against Bru-HIMS-CRF-179-DD1
			String CALC_WAIT_TIME_BASED_ON = ""; 
			String selVitalSign = "";
			String selArrived = "";
			String selCheckedIn = "";
			String selDefault = "";

			String diagnosisNotMndt = "N";  //Added by Sangeetha for ML-MMOH-CRF-0547

			//Added by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6
			Boolean isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "OA", "BRU_HEALTH_INTG");
			String clinic_type_sub="";
			
	try
	{		
			pstmt=conn.prepareStatement("select ASSIGN_QUEUE_NUM_BY from op_param where OPERATING_FACILITY_ID ='"+facilityid+"'");
			rs = pstmt.executeQuery();
			if(rs!=null)
			{
				if(rs.next()){
					assign_q_num_by = rs.getString("ASSIGN_QUEUE_NUM_BY");
				}
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			
			pstmt=conn.prepareStatement("select day_no,day_of_week,day_type,week_applicability,day_type_week_1,day_type_week_2,day_type_week_3,day_type_week_4,day_type_week_5 from sm_day_of_week order by day_no");
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
						
					weekapplicability[cnt]=rs.getString("week_applicability");
					workingweek1day[cnt]=rs.getString("day_type_week_1");
					workingweek2day[cnt]=rs.getString("day_type_week_2");
					workingweek3day[cnt]=rs.getString("day_type_week_3");
					workingweek4day[cnt]=rs.getString("day_type_week_4");
					workingweek5day[cnt]=rs.getString("day_type_week_5");
					cnt++;
				}
			}
			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
	
		pstmt = conn.prepareStatement("select single_or_multi_files_ind,SEPARATE_FILE_NO_YN,MAINTAIN_DOC_OR_FILE,CREATE_FILE_YN from mp_param ");
		rs=pstmt.executeQuery();
	    if(rs != null && rs.next())
		{
			sormfiles = (rs.getString("single_or_multi_files_ind") == null)?"":rs.getString("single_or_multi_files_ind");
			SEPARATE_FILE_NO_YN=(rs.getString("SEPARATE_FILE_NO_YN")==null)?"":rs.getString("SEPARATE_FILE_NO_YN");
			maintain_doc_or_file=(rs.getString("MAINTAIN_DOC_OR_FILE")==null)?"":rs.getString("MAINTAIN_DOC_OR_FILE");
			create_file_yn =(rs.getString("CREATE_FILE_YN")==null)?"":rs.getString("CREATE_FILE_YN");
		}
	   
	   if(rs != null) rs.close();
	   if(pstmt != null) pstmt.close();

	   if(maintain_doc_or_file.equals("F"))
		{					
		  	pstmt=conn.prepareStatement("select single_or_multi_files_ind,SEPARATE_FILE_NO_YN from mp_param_for_facility where facility_id='"+facilityid+"'");
			rs=pstmt.executeQuery();
			if(rs != null)
				{
					while(rs.next())
					{
					sormfiles=(rs.getString("single_or_multi_files_ind") == null)?"":rs.getString("single_or_multi_files_ind");
					SEPARATE_FILE_NO_YN=(rs.getString("SEPARATE_FILE_NO_YN")==null)?"":rs.getString("SEPARATE_FILE_NO_YN");	
					}
				}

			
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
		}
		
 		pstmt=conn.prepareStatement(" Select nvl(install_yn,'N') fm_mdl_installed_yn from sm_module where module_id = 'FM'");
		rs=pstmt.executeQuery();
		if (rs.next()) 
		{       
			fm_install_yn = rs.getString(1);
		}
		else 
			fm_install_yn="X";
                   
	  
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		
	}catch(Exception e) 
	{
			e.printStackTrace();
	}

	/* In MP-PARAM if maintain_doc_or_file value is 'D' then disable 
	   MR-Section Type ,MR-Section and Default File Type and AutoFileRequest. */

		if(maintain_doc_or_file.equals("D"))
			defaultdisable="disabled";
		else
			defaultdisable="";

		// Depending on the Clinic code value the function inmsert and modify mode is handled...If the Cliniccode string is empty the mode is insert else the mode is modify.
		
	if(!cliniccode.equals(""))
		{
			fnval="modify";
		/*	The count for the available visit types for that particular clinic code in the modify mode and facility id and also checking the subservices available is not null.This count is used later in the HTMl part for the display of drop down or text boxes for the Acct dept and Service fields. */
	
	 try 
		{
			sql1="select count(*) as total from op_visit_type_for_clinic where clinic_code=? and facility_id=? and subservice_code is not null";
			pstmt=conn.prepareStatement(sql1);
			pstmt.setString(1,cliniccode);
			pstmt.setString(2,facilityid);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				visitcnt=rs.getInt("total");
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		 reportSql ="select count(*) as reportCount from op_online_report where MODULE_ID = 'FM' and REPORT_ID = 'FMFLRQSL' and CLINIC_CODE ='"+cliniccode+"'";		 
		  pstmt=conn.prepareStatement(reportSql);
			rs = pstmt.executeQuery();
			if(rs!=null)
			{
				if(rs.next()){
					reportCount = rs.getInt("reportCount");
				}
			}
			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
						
		}catch(Exception e)
			{
				e.printStackTrace();
			}
									
		// The following sql is for the modify mode to retrieve all the existing values for the current clinic code and then accordingly display them in the layout for any further modifications.

		sql.append("select a.clinic_code clinic_code,a.long_desc long_desc,a.short_desc short_desc,a.clinic_type clinic_type,a.clinic_type_sub clinic_type_sub,a.SPECIALIST_CLINIC_YN SPECIALIST_CLINIC_YN ,");

		sql.append("a.max_walkin_for_day_1, a.max_walkin_for_day_2, a.max_walkin_for_day_3, a.max_walkin_for_day_4, a.max_walkin_for_day_5, a.max_walkin_for_day_6, a.max_walkin_for_day_7,");
		sql.append("a.working_week_appl_day_1,a.working_week_appl_day_2,a.working_week_appl_day_3,a.working_week_appl_day_4,a.working_week_appl_day_5,a.working_week_appl_day_6,a.working_week_appl_day_7,");
		sql.append("a.working_day_1,a.working_day_2,a.working_day_3,a.working_day_4,a.working_day_5,a.working_day_6,a.working_day_7,");
		sql.append(" a.working_week_1_day_1 working_week_1_day_1,a.working_week_1_day_2 working_week_1_day_2,a.working_week_1_day_3 working_week_1_day_3,a.working_week_1_day_4 working_week_1_day_4,a.working_week_1_day_5 working_week_1_day_5,a.working_week_1_day_6 working_week_1_day_6,a.working_week_1_day_7 working_week_1_day_7,");
		sql.append(" a.working_week_2_day_1 working_week_2_day_1,a.working_week_2_day_2 working_week_2_day_2,a.working_week_2_day_3 working_week_2_day_3,a.working_week_2_day_4 working_week_2_day_4,a.working_week_2_day_5 working_week_2_day_5,a.working_week_2_day_6 working_week_2_day_6,a.working_week_2_day_7 working_week_2_day_7,");
		sql.append(" a.working_week_3_day_1 working_week_3_day_1,a.working_week_3_day_2 working_week_3_day_2,a.working_week_3_day_3 working_week_3_day_3,a.working_week_3_day_4 working_week_3_day_4,a.working_week_3_day_5 working_week_3_day_5,a.working_week_3_day_6 working_week_3_day_6,a.working_week_3_day_7 working_week_3_day_7,");
		sql.append(" a.working_week_4_day_1 working_week_4_day_1,a.working_week_4_day_2 working_week_4_day_2,a.working_week_4_day_3 working_week_4_day_3,a.working_week_4_day_4 working_week_4_day_4,a.working_week_4_day_5 working_week_4_day_5,a.working_week_4_day_6 working_week_4_day_6,a.working_week_4_day_7 working_week_4_day_7,");
		sql.append(" a.working_week_5_day_1 working_week_5_day_1,a.working_week_5_day_2 working_week_5_day_2,a.working_week_5_day_3 working_week_5_day_3,a.working_week_5_day_4 working_week_5_day_4,a.working_week_5_day_5 working_week_5_day_5,a.working_week_5_day_6 working_week_5_day_6,a.working_week_5_day_7 working_week_5_day_7,");
		sql.append(" a.mr_section_type mr_section_type,"); 
		sql.append(" a.mr_section_code mr_section_code,a.age_group_code age_group_code,a.speciality_code speciality_code,a.dept_code dept_code,");
		sql.append(" a.service_code service_code,a.pract_type pract_type,a.open_to_all_pract_yn open_to_all_pract_yn,a.ident_at_checkin ident_at_checkin,");
		sql.append(" a.level_of_care_ind level_of_care_ind,a.allow_appt_yn  allow_appt_yn,a.allow_walk_in_yn allow_walk_in_yn ,a.allow_referral_yn allow_referral_yn ,");
		sql.append(" a.allow_non_referral_yn allow_non_referral_yn , a.allow_visit_regn_yn allow_visit_regn_yn ,a.record_vital_signs_yn record_vital_signs_yn ,a.record_immu_yn record_immu_yn ,");
		sql.append(" a.record_outcome_yn record_outcome_yn ,a.fi_visit_type_appl_yn fi_visit_type_appl_yn ,a.fu_visit_type_appl_yn fu_visit_type_appl_yn ,a.rt_visit_type_appl_yn rt_visit_type_appl_yn ,");
		sql.append(" a.sr_visit_type_appl_yn sr_visit_type_appl_yn ,a.cs_visit_type_appl_yn cs_visit_type_appl_yn ,a.em_visit_type_appl_yn em_visit_type_appl_yn,a.eff_status eff_status ,to_char(a.working_day_start_time,'hh24:mi') working_day_start_time,to_char(a.working_day_end_time,'hh24:mi') working_day_end_time,to_char(a.base_slot_slab_time,'hh24:mi') base_slot_slab_time,a.primary_resource_class primary_resource_class,a.op_appl_yn op_appl_yn,a.dc_appl_yn dc_appl_yn,a.ip_appl_yn ip_appl_yn,a.em_appl_yn em_appl_yn,b.short_desc locn_desc,");				
		sql.append(" c.short_desc age_desc,d.dept_short_desc dept_desc,a.allow_unassign_in_practq_yn, a.mr_location_code mr_location_code ,a.vital_signs_battery_id vital_signs_battery_id,a.disp_in_ca_queue_after disp_in_ca_queue_after ,");
		sql.append(" e.short_desc vital_signs_battery_desc,a.online_mr_notfn_yn online_mr_notfn_yn, a.section_code section_code,a.dflt_file_type_code dflt_file_type_code,g.section_short_desc section_short_desc,h.short_desc service_desc ,i.short_name mr_section_desc,j.short_desc file_type_desc,k.desc_userdef pract_type_desc,m.short_desc speciality_desc,a.QUEUE_NUM_APPL_YN QUEUE_NUM_APPL_YN,a.QUEUE_NUM_BY_PRACT_YN QUEUE_NUM_BY_PRACT_YN,a.QUEUE_NUM_BY_OTHER_RES_YN QUEUE_NUM_BY_OTHER_RES_YN,a.QUEUE_NUM_OTHER_RES_CLASS QUEUE_NUM_OTHER_RES_CLASS,a.QUEUE_NUM_OTHER_RES_TYPE QUEUE_NUM_OTHER_RES_TYPE,QUEUE_NUM_BY_ROOM_YN,a.CALC_WAIT_TIME_BASED_ON CALC_WAIT_TIME_BASED_ON,a.DIAG_RECORDING_MAND_YN DIAG_RECORDING_NOT_MNDT, QMS_INTERFACED_YN,a.multi_speciality_yn, a.contact_no,a.CATEGORY CATEGORY,a.Queue_No_Mandate Queue_No_Mandate");  //Added Column CALC_WAIT_TIME_BASED_ON - against Bru-HIMS-CRF-179-DD1
        //Added column DIAG_RECORDING_MAND_YN for ML-MMOH-CRF-0547 by Sangeetha
        // Added column Queue_No_Mandate by Himanshu Saxena for ML-BRU-CRF-0628.11 on 02-05-2023-->
		 if(callfunc.equals("ProcedureUnit")){
				sql.append(",a.rd_appl_yn radAppYn ");
		 }
				
		if(fm_install_yn.equals("Y"))
		{
				sql.append(",n.short_desc fs_locn_desc ");
		}

		sql.append(" from op_clinic a,am_care_locn_type b,am_age_group c,am_facility_dept_vw d, am_discr_msr e,am_facility_section_vw g ,am_service h,mr_section i ,mr_file_type j ,am_pract_type k, am_speciality m ");

		if(fm_install_yn.equals("Y"))
		{
			sql.append(" ,fm_storage_locn n ");
		}

		sql.append(" where a.vital_signs_battery_id = e.discr_msr_id(+) and a.clinic_code=?  and a.facility_id =? and b.locn_type(+)=a.clinic_type ");
		sql.append(" and c.age_group_code(+) =a.age_group_code and d.dept_code(+) =a.dept_code and d.operating_facility_id =? and g.dept_code(+) =a.dept_code ");
		sql.append(" and g.section_code(+) = a.section_code AND g.operating_facility_id(+) =a.facility_id and h.service_code=a.service_code and i.mr_section_code(+) = a.mr_section_code and i.facility_id(+) =a.facility_id and j.file_type_code(+) =a.dflt_file_type_code and k.pract_type(+) = a.pract_type and m.speciality_code(+) = a.speciality_code ");

		if(fm_install_yn.equals("Y"))
		{
			sql.append(" and n.fs_locn_code(+) = a.mr_location_code ");
		}
        pstmt=conn.prepareStatement(sql.toString());
		pstmt.setString(1,cliniccode);				
		pstmt.setString(2,facilityid);
		pstmt.setString(3,facilityid);
				
		rs=pstmt.executeQuery();
				
		if(rs.next())
		{
			for(int i=1; i<=7; i++)					
			{
				max_walkin_for_day[i-1] = rs.getString("max_walkin_for_day_"+i) == null?"":rs.getString("max_walkin_for_day_"+i);		
			}

			cliniccode=(rs.getString("clinic_code") == null )?"":rs.getString("clinic_code");
					
			effstatus=(rs.getString("eff_status") == null)?"":rs.getString("eff_status");
			if(effstatus.equals("D"))
			 {
				disable="disabled";
			 }
			else
			 {
				disable="";
			 }
			queue_num_appl=(rs.getString("QUEUE_NUM_APPL_YN")==null)?"":rs.getString("QUEUE_NUM_APPL_YN");
			
			by_pract_appl=(rs.getString("QUEUE_NUM_BY_PRACT_YN")==null)?"N":rs.getString("QUEUE_NUM_BY_PRACT_YN");
			
			
			//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 02-05-2023 Started-->
				queue_no_mandate=(rs.getString("Queue_No_Mandate")==null)?"":rs.getString("Queue_No_Mandate");
			//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 02-05-2023 end -->

			//if(queue_num_appl.equals("Y"))
			// {
				//if(by_pract_appl.equals("Y"))
				//	ckval1="checked";
				//else
				//	ckval1="";
			// }
			by_res_appl=(rs.getString("QUEUE_NUM_BY_OTHER_RES_YN")==null)?"N":rs.getString("QUEUE_NUM_BY_OTHER_RES_YN");

			if(queue_num_appl.equals("Y"))
			 {
			   if(by_res_appl.equals("Y"))
				{
					//ckval2="checked";
					//ckdisable1="";
				}
				else
				 {
					//ckval2="";
					//ckdisable1="disabled";
				 }
			  }
			 by_room=(rs.getString("QUEUE_NUM_BY_ROOM_YN")==null)?"N":rs.getString("QUEUE_NUM_BY_ROOM_YN");
  			 
			 if(queue_num_appl.equals("Y"))
			 {
				 if(by_room.equals("Y"))
				 {
					//ckval3="checked";
				 }
			    else
				 {
					//ckval3="";
				 }
			 }
			 other_res_class=(rs.getString("QUEUE_NUM_OTHER_RES_CLASS")==null)?"":rs.getString("QUEUE_NUM_OTHER_RES_CLASS");
			 
			 if(other_res_class.equals("R"))
					other_res_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			 else if(other_res_class.equals("E"))
					other_res_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			 else if(other_res_class.equals("O"))
					other_res_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
	
			 //other_res_type=(rs.getString("QUEUE_NUM_OTHER_RES_TYPE")==null)?"":rs.getString("QUEUE_NUM_OTHER_RES_TYPE");

					allowconsult=(rs.getString("disp_in_ca_queue_after") == null)?"":rs.getString("disp_in_ca_queue_after");	
					
					if(allowconsult.equals("01"))
					 {
						allowconsultdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.CheckedIn.label","op_labels");
					 }
					else if(allowconsult.equals("02"))
					 {
						allowconsultdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.arrived.label","op_labels");
					 }
					 for(int i=1;i<=7;i++)
					 {
						weekapplicability[i-1]=rs.getString("working_week_appl_day_"+i);
						workingdays[i-1]=rs.getString("working_day_"+i);
						workingweek1day[i-1]=rs.getString("working_week_1_day_"+i);
						workingweek2day[i-1]=rs.getString("working_week_2_day_"+i);
						workingweek3day[i-1]=rs.getString("working_week_3_day_"+i);
						workingweek4day[i-1]=rs.getString("working_week_4_day_"+i);
						workingweek5day[i-1]=rs.getString("working_week_5_day_"+i);
					 }
					
					allowvisitreg=(rs.getString("allow_visit_regn_yn") == null)?"":rs.getString("allow_visit_regn_yn");
					allowwalkin=(rs.getString("allow_walk_in_yn") == null)?"":rs.getString("allow_walk_in_yn");
					allowappt=(rs.getString("allow_appt_yn") == null)?"":rs.getString("allow_appt_yn");
					allowref=(rs.getString("allow_referral_yn") == null)?"":rs.getString("allow_referral_yn");
					allownonref=(rs.getString("allow_non_referral_yn") == null)?"":rs.getString("allow_non_referral_yn");
					agegroupcode=(rs.getString("age_group_code") == null)?"":rs.getString("age_group_code");
					agegroupdesc=(rs.getString("age_desc") == null)?"":rs.getString("age_desc");
					levelofcare=(rs.getString("level_of_care_ind") == null)?"":rs.getString("level_of_care_ind");
					diagnosisNotMndt=(rs.getString("diag_recording_not_mndt") == null)?"":rs.getString("diag_recording_not_mndt");  //Added by Sangeetha for ML-MMOH-CRF-0457
					if(levelofcare.equals("A"))
					 {
						levelofcaredesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ambulatory.label","common_labels");
					 }
					 else
					 {
						 levelofcaredesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
					 }
					
					speccode=(rs.getString("speciality_code") == null)?"":rs.getString("speciality_code");
					specdesc=(rs.getString("speciality_desc") == null)?"":rs.getString("speciality_desc");
					vitalsign=(rs.getString("vital_signs_battery_id") == null)?"":rs.getString("vital_signs_battery_id");
					vitalsigndesc=(rs.getString("vital_signs_battery_desc") == null)?"":rs.getString("vital_signs_battery_desc");
					
					acctdept=(rs.getString("dept_code") == null)?"":rs.getString("dept_code");
					acctdeptdesc=(rs.getString("dept_desc") == null)?"":rs.getString("dept_desc");
					section=(rs.getString("section_code") == null)?"":rs.getString("section_code");
					sectiondesc=(rs.getString("section_short_desc")== null)?"":rs.getString("section_short_desc");
					service=(rs.getString("service_code") == null)?"":rs.getString("service_code");
					servicedesc=(rs.getString("service_desc") == null)?"":rs.getString("service_desc");
					mrsectype=(rs.getString("mr_section_type") == null)?"":rs.getString("mr_section_type");
					if(mrsectype.equals("D"))
					 {
						mrsectypedesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels");
					 }
					 else if(mrsectype.equals("C"))
					 {
						mrsectypedesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Central.label","common_labels");
					 }
					   
					mrsection=(rs.getString("mr_section_code") == null)?"":rs.getString("mr_section_code");
					mrsectiondesc=(rs.getString("mr_section_desc") == null)?"":rs.getString("mr_section_desc");
					fslocn=(rs.getString("mr_location_code") == null)?"":rs.getString("mr_location_code");
                   	if(fm_install_yn.equals("Y"))
					 {
					fslocndesc=(rs.getString("fs_locn_desc") == null)?"":rs.getString("fs_locn_desc");
					 }
					autofilereq=(rs.getString("online_mr_notfn_yn") == null)?"":rs.getString("online_mr_notfn_yn");

					if(autofilereq == null) autofilereq="N";

					dfltfiletype=(rs.getString("dflt_file_type_code") == null)?"":rs.getString("dflt_file_type_code");
				
					dfltfiletypedesc=(rs.getString("file_type_desc") == null)?"":rs.getString("file_type_desc");
					emerchk=(rs.getString("em_visit_type_appl_yn") == null)?"":rs.getString("em_visit_type_appl_yn");
					firstchk=(rs.getString("fi_visit_type_appl_yn") == null)?"":rs.getString("fi_visit_type_appl_yn");
					followchk=(rs.getString("fu_visit_type_appl_yn") == null)?"":rs.getString("fu_visit_type_appl_yn");
					routinechk=(rs.getString("rt_visit_type_appl_yn") == null)?"":rs.getString("rt_visit_type_appl_yn");
					serieschk=(rs.getString("sr_visit_type_appl_yn") == null)?"":rs.getString("sr_visit_type_appl_yn");
					consultchk=(rs.getString("cs_visit_type_appl_yn") == null)?"":rs.getString("cs_visit_type_appl_yn");
					practtype=(rs.getString("pract_type") == null)?"":rs.getString("pract_type");
					practtypedesc=(rs.getString("pract_type_desc") == null)?"":rs.getString("pract_type_desc");
					open_to_all_pract_yn=(rs.getString("open_to_all_pract_yn") == null)?"":rs.getString("open_to_all_pract_yn");
					chkinident=(rs.getString("ident_at_checkin") == null)?"":rs.getString("ident_at_checkin");
					
					if(chkinident.equals("P"))
					 {
						chkinidentdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resource.label","common_labels");
					 }
					 else if(chkinident.equals("X"))
					 {
						chkinidentdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.NotIdentifiable.label","op_labels");
					 }
					selunassgnyn=(rs.getString("allow_unassign_in_practq_yn") == null)?"":rs.getString("allow_unassign_in_practq_yn");					

					rcdvitsgn=(rs.getString("record_vital_signs_yn") == null)?"N":rs.getString("record_vital_signs_yn");
					rcdimmun=(rs.getString("record_immu_yn") == null)?"N":rs.getString("record_immu_yn");
					rcdoutcome=(rs.getString("record_outcome_yn") == null)?"N":rs.getString("record_outcome_yn");
					workingstarttime=(rs.getString("working_day_start_time") == null)?"":rs.getString("working_day_start_time");
					workingendtime=(rs.getString("working_day_end_time") == null)?"":rs.getString("working_day_end_time");
					baseslabslottime=(rs.getString("base_slot_slab_time") == null)?"":rs.getString("base_slot_slab_time");
					primaryresclass=(rs.getString("primary_resource_class") == null)?"":rs.getString("primary_resource_class");
					if(primaryresclass.equals("P"))
					 {
						primaryresclassdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");						
					 }
					 else if(primaryresclass.equals("R"))
					 {
						primaryresclassdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");						
					 }
					 else if(primaryresclass.equals("E"))
					 {
						 primaryresclassdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");						
					 }
					 else if(primaryresclass.equals("O"))
					 {
						 primaryresclassdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");										 
					 }				

					opchk=(rs.getString("op_appl_yn") == null)?"n":rs.getString("op_appl_yn");
					dcchk=(rs.getString("dc_appl_yn") == null)?"n":rs.getString("dc_appl_yn");
					ipchk=(rs.getString("ip_appl_yn") == null)?"n":rs.getString("ip_appl_yn");
					emchk=(rs.getString("em_appl_yn") == null)?"n":rs.getString("em_appl_yn");

					clinic_type=(rs.getString("clinic_type") == null)?"":rs.getString("clinic_type");
					CATEGORY=(rs.getString("CATEGORY") == null)?"":rs.getString("CATEGORY");
					//Added by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6
					clinic_type_sub=(rs.getString("clinic_type_sub") == null)?"":rs.getString("clinic_type_sub");
					
					 if(callfunc.equals("ProcedureUnit")){
						 radAppYn=(rs.getString("radAppYn") == null)?"":rs.getString("radAppYn");						
					 }
						
					//Added against Bru-HIMS-CRF-179-DD1
					CALC_WAIT_TIME_BASED_ON = rs.getString("CALC_WAIT_TIME_BASED_ON") == null ? "" :rs.getString("CALC_WAIT_TIME_BASED_ON");
					if(CALC_WAIT_TIME_BASED_ON.equals("01"))
						selCheckedIn = "selected";
					else if(CALC_WAIT_TIME_BASED_ON.equals("02"))
						selArrived = "selected";
					else
						selDefault = "selected";
							
					//Bru-HIMS-CRF 192.1 changes starts
					qms_interfaced_yn = rs.getString("QMS_INTERFACED_YN");
					if(qms_interfaced_yn==null || qms_interfaced_yn.equals(""))
						qms_interfaced_yn="N";
					
					multi_speciality_yn=(rs.getString("multi_speciality_yn") == null)?"N":rs.getString("multi_speciality_yn");//Added for the CRF - Bru-HIMS-CRF-0198
					if(multi_speciality_yn.equals("Y")){
						multi_speciality_disabled="disabled";
					}
					contact_no=(rs.getString("contact_no") == null)?"":rs.getString("contact_no");//Added for the CRF - MO-CRF-20121.1
				 }	
				
				 if(callfunc.equals("ProcedureUnit") && radAppYn.equals("Y"))
					 disMrSection = "disabled";
				 else
					disMrSection = "";
			}
		else
		{			
			fnval="insert";
		}
	
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
				
		sql.setLength(0);	 
    	
%>
	<form name="clinic_resource_form" id="clinic_resource_form" action='../../servlet/eOP.NewClinicServlet' method='post' target='messageFrame' >
	
	<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>' >
	<input type='hidden' name='call_function' id='call_function' value='<%=callfunc%>' >
				
			<input type='hidden' name='fm_install' id='fm_install' value='<%=fm_install_yn%>' >
			<input type='hidden' name='ct_tab_name' id='ct_tab_name' value='char_tab'> 
			<input type='hidden' name='record_vital_signs_yn' id='record_vital_signs_yn' value='<%=rcdvitsgn%>' >
		    <input type='hidden' name='record_immun_yn' id='record_immun_yn' value='<%=rcdimmun%>' >
			<input type='hidden' name='record_outcome_yn' id='record_outcome_yn' value='<%=rcdoutcome%>' >
			<input type='hidden' name='centralValue' id='centralValue' value='<%=central_value%>'>
			
			<input type='hidden' name='SEPARATE_FILE_NO_YN' id='SEPARATE_FILE_NO_YN' value='<%=SEPARATE_FILE_NO_YN%>' >
			<input type='hidden' name='sormfiles' id='sormfiles' value='<%=sormfiles%>' >
			<input type='hidden' name='lcare' id='lcare' value=''>

			<input type='hidden' name='clinic_code' id='clinic_code' value='<%=cliniccode%>'>
			<input type='hidden' name='short_desc' id='short_desc' value=''>
			<input type='hidden' name='long_desc' id='long_desc' value=''>
			<input type='hidden' name='eff_status' id='eff_status' value=''>
			<input type='hidden' name='specialist_clinic_yn' id='specialist_clinic_yn' value=''>
			<input type='hidden' name='rd_appl_yn' id='rd_appl_yn' value=''>
			<input type='hidden' name='visit_pract_yn' id='visit_pract_yn' value=''>
			<input type='hidden' name='clinic_type' id='clinic_type' value=''>

			<!--Added by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6-->
			<%if(isSlotStartMidEndAppl){%>
			<input type='hidden' name='clinic_type_sub' id='clinic_type_sub' value=''>
			<%}%>

			<input type='hidden' name='procedure_Unit_yn' id='procedure_Unit_yn' value='N'>
			<input type='hidden' name='physical_locn' id='physical_locn' value=''>
			<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
			<input type='hidden' name='popup_desc' id='popup_desc' value=''>  <!-- added by mujafar for GHL-CRF-0527 -->
			<input type='hidden' name='alert_req_book_appt_yn' id='alert_req_book_appt_yn' value=''> 
			<input type='hidden' name='isAlertApplicableforBookAppt' id='isAlertApplicableforBookAppt' value=''>
             <input type='hidden' name='CATEGORY' id='CATEGORY' value='<%=CATEGORY%>'>
            
<!-- <a name='chars' ></a> 
 -->
<div id="chars_div" style='visibility:visible;'>
<table border='0' cellpadding=0 cellspacing=0 width='100%' >
<th class='columnheader' width='100%' colspan='4' align="left" ><fmt:message key="eOP.Controls.label" bundle="${op_labels}"/></th>
<tr>
<td class='label' width='21%'><fmt:message key="eOP.AllowVisitRegistration.label" bundle="${op_labels}"/></td>
<td class='fields' width='32%'>
		<%
			chkval="";
			disable="";
			if(allowvisitreg.equals("Y"))
			{
				chkval="checked";
			}
			else 
			{
				chkval="";
			}
			
			if(fnval.equals("modify") && effstatus.equals("D"))
			{
				disable="disabled";
			}else
			{
				disable="";
			}
			%>
			<input type='checkbox' name='allow_visit_regn_yn' id='allow_visit_regn_yn' value='<%=allowvisitreg%>' onClick='assignval(this);if(this.checked == true){GetValues(document.forms[0].speciality);}' <%=chkval%> <%=disable%>  >
			<input type='hidden' name='allow_visit_regn_yn1' id='allow_visit_regn_yn1' value='<%=allowvisitreg%>' >
		</td>		
		<td class='label' width='23%'><fmt:message key="eOP.AllowWalkin.label" bundle="${op_labels}"/></td>		
		 <td class='fields' width='25%'>
			<%
				chkval="";
				if(allowwalkin.equals("Y"))
				{
					chkval="checked";
				}
				else 
				{
					chkval="";
				}
				
				if(fnval.equals("modify") && effstatus.equals("D"))
				{
					disable="disabled";
				}else
				{
					disable="";
				}
			if(fnval.equals("insert")){									
			%>
			<input type='checkbox' name='allow_walk_in_yn' id='allow_walk_in_yn' value='<%=allowwalkin%>'  onClick='assignval(this)' <%=chkval%> disabled>
			<%
			}else
			{
			%>
			<input type='checkbox' name='allow_walk_in_yn' id='allow_walk_in_yn' value='<%=allowwalkin%>'  onClick='assignval(this)' <%=chkval%> <%=disable%> >
		
			<%}%>
			<input type='hidden' name='allow_walk_in_yn1' id='allow_walk_in_yn1' value='<%=allowwalkin%>' >
		</td>		
		</tr>
		<tr>
		<td class='label'><fmt:message key="eOP.AllowAppointment.label" bundle="${op_labels}"/></td>
		<td class='fields'>
			<%
				chkval="";
				if(allowappt.equals("Y"))
				{
					chkval="checked";
				}
				else 
				{
					chkval="";
				}
				
				if(fnval.equals("modify") && effstatus.equals("D"))
				{
					disable="disabled";
				}else
				{
					disable="";
				}
			   if(callfunc.equals("Clinic")||callfunc.equals("DaycareUnit"))
				{

				   disable1="disabled";	
				}
			   else
				{
				   disable1="";
				}
			if(fnval.equals("insert")){									
			%>									
			<input type='checkbox' name='allow_appt_yn' id='allow_appt_yn' value='<%=allowappt%>'  onClick='assignval(this)' <%=chkval%> <%=disable1%>>
			<%}else{%> 
			<input type='checkbox' name='allow_appt_yn' id='allow_appt_yn' value='<%=allowappt%>'  onClick='assignval(this)' <%=chkval%> <%=disable%>>
			<%}%>
			<input type='hidden' name='allow_appt_yn1' id='allow_appt_yn1' value='<%=allowappt%>' >
		</td> 				
		<td class='label'><fmt:message key="eOP.AllowReferral.label" bundle="${op_labels}"/></td>
		<td class='fields'>
			<%
				chkval="";
				if(allowref.equals("Y"))
				{
					chkval="checked";
				}
				else 
				{
					chkval="";
				}
				
				if(fnval.equals("modify") && effstatus.equals("D"))
				{
					disable="disabled";
				}else
				{
					disable="";
				}
			
			if(fnval.equals("insert")){		
			%>
			<input type='checkbox' name='allow_referral_yn' id='allow_referral_yn' value='<%=allowref%>'  onClick='assignval(this)' <%=chkval%> disabled>
			<%}else{%>
		<input type='checkbox' name='allow_referral_yn' id='allow_referral_yn' value='<%=allowref%>'  onClick='assignval(this)' <%=chkval%> <%=disable%> >
		<%}%>
			<input type='hidden' name='allow_referral_yn1' id='allow_referral_yn1' value='<%=allowref%>' >
		</td>
		</tr>
		<tr>
		<td class='label'><fmt:message key="eOP.AllowNonReferral.label" bundle="${op_labels}"/>
		</td>
		<td class='fields'>
			<%
				chkval="";
				if(allownonref.equals("Y"))
				{
					chkval="checked";
				}
				else 
				{
					chkval="";
				}
				
				if(fnval.equals("modify") && effstatus.equals("D"))
				{
					disable="disabled";
				}else
				{
					disable="";
				}
			if(fnval.equals("insert")){
			%>
			<input type='checkbox' name='allow_non_referral_yn' id='allow_non_referral_yn' value='<%=allownonref%>'  onClick='assignval(this)' <%=chkval%> disabled>
		<%}else{%>
	<input type='checkbox' name='allow_non_referral_yn' id='allow_non_referral_yn' value='<%=allownonref%>'  onClick='assignval(this)' <%=chkval%> <%=disable%>>
		<%}%>
		<input type='hidden' name='allow_non_referral_yn1' id='allow_non_referral_yn1' value='<%=allownonref%>' >
		</td>
		<!-- Added by Sangeetha for ML-MMOH-CRF-0547 -->
		<% boolean siteSpecificNonMandatoryDiagRec = eCommon.Common.CommonBean.isSiteSpecific(conn, "OP","DIAG_RECORDING_NOT_MNDT");
		   if(siteSpecificNonMandatoryDiagRec && callfunc.equals("ProcedureUnit") || callfunc.equals("Clinic")) //Modified by Shanmukh for ML-MMOH-CRF-1007 on 19-APR-2018
			{
		%>
		<td class='label' width='21%' ><fmt:message key="eOP.diagnosisnotmandatory.label" bundle="${op_labels}"/></td>
		<td class='fields'>
		<%
				chkval="";
				if(diagnosisNotMndt.equals("Y"))
				{
					chkval="checked";
				}
				else 
				{
					chkval="";
				}
		%>
		<input type='checkbox' name='diagnosis_not_mndt' id='diagnosis_not_mndt' value='<%=diagnosisNotMndt%>' onClick='assignval(this)' <%=chkval%>>
		</td>
		<% } %>
      <td class='label' colspan="4"></td>
	 </tr>	
	<tr>
		<td class='label' width='21%' ><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/>
		</td>
		<td class='fields' width='32%'>
		<%
		if(fnval.equals("modify") && effstatus.equals("D"))
		{
		%>
			<input type='text' name="age_group_desc" id="age_group_desc" value="<%=agegroupdesc%>" readonly>
			<input type="hidden" name="age_group" id="age_group" value="<%=agegroupcode%>">
			</td>
		<%
		}
		else
		{
		%>
			<select name='age_group' id='age_group' onBlur="javascript:if(document.forms[0].level_of_care.disabled==true)getfocus(this);"><option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
			bundle="${common_labels}"/> --------&nbsp;
		<%
			try{
			pstmt=conn.prepareStatement("select age_group_code,short_desc from am_age_group where eff_status='E' order by short_desc");
			rs=pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
					agecode=(rs.getString("age_group_code") == null)?"":rs.getString("age_group_code");

					if(agegroupcode.equals(agecode))
					{
						sel="selected";
					}
					else
							sel="";
					%>
						<option value='<%=agecode%>' <%=sel%> ><%=(rs.getString("short_desc") == null)?"":rs.getString("short_desc")%> 
					<%
				}
			}
			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

		}catch(Exception e)
			{
			e.printStackTrace();
			}
		%>
		</select>
		</td>			
		<%
		}
		%>		
		<td class='label' width="23%"><fmt:message key="Common.levelofcare.label" bundle="${common_labels}"/></td>
		<td class='fields' width="25%">
		<%

		// The count for the visit types for that clinic code is taken from database above and if the count> 0 then the field is shown as readonly text box else it is shown as drop down and even though the count ==0 but the effective status is disabled the field is shown as readonly textbox.
		if((fnval.equals("modify") && effstatus.equals("D") && visitcnt == 0) || (visitcnt >0))
		{
		%>
			<input type="text" name="level_of_care_desc" id="level_of_care_desc" value="<%=levelofcaredesc%>" readonly>
			<input type="hidden" name="level_of_care" id="level_of_care" value="<%=levelofcare%>">
		<%
		}
		else if(visitcnt == 0)
		{
			// Level of care has hard coded values ..>So depending on the value for level of care existin gin Op_clinic for that particular clinic code in modify mode the display and the selected value chnages.

			String levdis="";
			if(fnval.equals("modify"))
			{
				if(levelofcare.equals("A")||levelofcare.equals("E"))
					levdis="disabled";
				else 
					 levdis="";
			}
			
			%>
				<select name='level_of_care' id='level_of_care' onChange="assignchecks('lchk')" onBlur="getfocus(this)" <%=levdis%>>
			
				
				<%
			if(levelofcare.equals("A"))
			{
			%>											
					<option value='A' selected><fmt:message key="Common.Ambulatory.label" bundle="${common_labels}"/>&nbsp;
					<option value='E' ><fmt:message key="Common.emergency.label" bundle="${common_labels}"/>&nbsp;
				
			<%
			}
			else if(levelofcare.equals("E"))
			{
			%>											
					<option value='A' ><fmt:message key="Common.Ambulatory.label" bundle="${common_labels}"/>&nbsp;
					<option value='E' selected><fmt:message key="Common.emergency.label" bundle="${common_labels}"/>&nbsp;
			<%
			}	
			else
			{
			%>											
					<option value='A' selected><fmt:message key="Common.Ambulatory.label" bundle="${common_labels}"/>&nbsp;
					<option value='E' ><fmt:message key="Common.emergency.label" bundle="${common_labels}"/>&nbsp;
			<%
			}
			%>
			</select>
				<%
				}
			%>
			</td>				
	</table>

<table border=0 cellpadding=0 cellspacing=0 width='100%' >
<th class='columnheader' width='100%' align ="left"><fmt:message key="Common.WorkingDays.label" bundle="${common_labels}"/></th>
<tr>
 <td width='100%' class='border'>
   <table border='0' cellpadding='0' cellspacing='0' width='100%' >		
	 <tr>
		<td class='label' width='17%' >
		</td>   
		<%

		// This following sql helps to populate the days of the week from sm_day_of_Week table and display it to show the clinic working days.
		try
		{
			pstmt=conn.prepareStatement("select day_no,day_of_week from sm_day_of_week order by day_no");
			rs = pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{
								
				daysofweek = rs.getString("day_of_week").substring(0,3);
				%>
				<td class='labelleft' width='9%'><%=daysofweek%>
				</td>
				<%
				}
			}
						
			if( rs != null) rs.close();
			if(pstmt != null) pstmt.close();
							
		}catch(Exception e)
			{
			e.printStackTrace();
			}
	%>												
	</tr>
	
	<tr>
	 <td class='label'><fmt:message key="eOP.WorkingWeeksAppl.label" bundle="${op_labels}"/>.</td>
	 <td width='2%' class='fields'>
	 <%
	   String selval="";
	   String selval1="";
	  
	   for(int i=0;i<=6;i++)
		{
			if(weekapplicability[i].equals("A"))
			   {
				selval1="";
				selval="selected";
				weekapplicabilitydesc[i]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
			   }
			else{
				selval="";
				selval1="selected";
				weekapplicabilitydesc[i]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.specific.label","common_labels");							
				}
	
	  if(fnval.equals("modify") && effstatus.equals("D"))
		{
		  %>
		    <input type='text' name='working_weeks_appt<%=(i+1)%>_desc' id='working_weeks_appt<%=(i+1)%>_desc' value="<%=weekapplicabilitydesc[i]%>" readonly size='4' maxlength='4'>
			<input type="hidden" name='working_weeks_appt<%=(i+1)%>' id='working_weeks_appt<%=(i+1)%>' value="<%=weekapplicability[i]%>">
			 <%
		}		
		else
		{
		%>	
		<select name='working_weeks_appt<%=(i+1)%>' id='working_weeks_appt<%=(i+1)%>' onchange='checkuncheck(this,"<%=(i+1)%>")' <%=disable%>>
		<option value='A' <%=selval%> > <fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
		<option value='W' <%=selval1%> ><fmt:message key="Common.specific.label" bundle="${common_labels}"/> </option>					
		</select>
		<%
	    }%>
		</td>
		<input type='hidden' name='working_weeks_appt1<%=(i+1)%>' id='working_weeks_appt1<%=(i+1)%>' value=''>
		<td width='2%'>
		<%
		}		
		%>
		</tr>
		<tr>
		<td class='label'><fmt:message key="Common.Week.label" bundle="${common_labels}"/> 1</td>
			<%
		for(int j=1;j<=7;j++)
		{
			if(workingweek1day[j-1].equals("H"))
			{
				chkval="";
			}	
			else if(workingweek1day[j-1].equals("W"))
			{
				chkval="checked";
				disable="";
			}
			else
			{
				chkval="";
				disable="";
			}
								
			if(fnval.equals("modify") && effstatus.equals("D"))
			{
				disable="disabled";
			}

			%>
			<td width='5%' class='fields' >									
			<input type='checkbox' name='working_week_1_day_<%=j%>' id='working_week_1_day_<%=j%>' value='<%=workingweek1day[j-1]%>'  onClick='assigndays(this);' <%=chkval%> <%=disable%>>
			</td>
			<input type='hidden' name='working_week_1_day_<%=j%>1' id='working_week_1_day_<%=j%>1' value='<%=workingweek1day[j-1]%>' >
			<%
			}
			%>										
		</td>								
	</tr>	
	 <tr>
	 <td class='label'><fmt:message key="Common.Week.label" bundle="${common_labels}"/> 2</td>
	 <%
		 for(int j=1;j<=7;j++)
	 	 {
				if(workingweek2day[j-1].equals("H"))
				{
					chkval="";
				}
				else if(workingweek2day[j-1].equals("W"))
				{
					chkval="checked";
					disable="";
				}
				else
				{
					chkval="";
					disable="";
				}
										
				if(fnval.equals("modify") && effstatus.equals("D"))
				{
					disable="disabled";
				}
			
		 %>
		<td width='5%' class='fields'>									
		<input type='checkbox' name='working_week_2_day_<%=j%>' id='working_week_2_day_<%=j%>' value='<%=workingweek2day[j-1]%>'  onClick='assigndays(this)' <%=chkval%> <%=disable%>>
		</td>
		<input type='hidden' name='working_week_2_day_<%=j%>1' id='working_week_2_day_<%=j%>1' value='<%=workingweek2day[j-1]%>' >
		<%
		}
		%>								
			
		</td>								
	</tr>								
	<tr>
		<td class='label'><fmt:message key="Common.Week.label" bundle="${common_labels}"/> 3</td>
		<%
		for(int j=1;j<=7;j++)
		{
			if(workingweek3day[j-1].equals("H"))
			{
				chkval="";
			}
			else if(workingweek3day[j-1].equals("W"))
			{
				chkval="checked";
				disable="";
			}
			else
			{
				chkval="";
				disable="";
			}
			
			if(fnval.equals("modify") && effstatus.equals("D"))
			{
				disable="disabled";
			}
	%>
		<td width='5%' class='fields'>										
		<input type='checkbox' name='working_week_3_day_<%=j%>' id='working_week_3_day_<%=j%>' value='<%=workingweek3day[j-1]%>'  onClick='assigndays(this)' <%=chkval%> <%=disable%>>
		</td>
		<input type='hidden' name='working_week_3_day_<%=j%>1' id='working_week_3_day_<%=j%>1' value='<%=workingweek3day[j-1]%>' >
		<%
		}
		%>				
	</tr>								
    <tr>
		<td class='label'><fmt:message key="Common.Week.label" bundle="${common_labels}"/> 4</td>
		<%
		for(int j=1;j<=7;j++)
		{
		
			if(workingweek4day[j-1].equals("H"))
			{
				chkval="";
				
			}
			else if(workingweek4day[j-1].equals("W"))
			{
				chkval="checked";
				disable="";
			}
			else
			{
				chkval="";
				disable="";
			}
			
				if(fnval.equals("modify") && effstatus.equals("D"))
				{
					disable="disabled";
				}
			
		%>
		<td width='5%' class='fields'>									
		<input type='checkbox' name='working_week_4_day_<%=j%>' id='working_week_4_day_<%=j%>' value='<%=workingweek4day[j-1]%>'  onClick='assigndays(this)' <%=chkval%> <%=disable%>>
		</td>
		<input type='hidden' name='working_week_4_day_<%=j%>1' id='working_week_4_day_<%=j%>1' value='<%=workingweek4day[j-1]%>' >
		<%
		}
		%>															
	</tr>								
	<tr>
			<td class='label'><fmt:message key="Common.Week.label" bundle="${common_labels}"/> 5</td>
			<%
			for(int j=1;j<=7;j++)
			{
				if(workingweek5day[j-1].equals("H"))
				{
					chkval="";
					
				}
				else if(workingweek5day[j-1].equals("W"))
				{
					chkval="checked";
					disable="";
				}
				else
				{
					chkval="";
					disable="";
				}
				
					if(fnval.equals("modify") && effstatus.equals("D"))
					{
						disable="disabled";
					}
				
			%>
				<td width='5%' class='fields'>								
				<input type='checkbox' name='working_week_5_day_<%=j%>' id='working_week_5_day_<%=j%>' value='<%=workingweek5day[j-1]%>'  onClick='assigndays(this);' <%=chkval%> <%=disable%> >
				</td>
				<input type='hidden' name='working_week_5_day_<%=j%>1' id='working_week_5_day_<%=j%>1' value='<%=workingweek5day[j-1]%>' >
			<%
			}
			%>										
			</td>								
		</tr>
		<tr>
			<td class='label' ><fmt:message key="eOP.MaxWalkinPerDay.label" bundle="${op_labels}"/></td>
			<%

				if(fnval.equals("insert"))
				{
					disable="readOnly";
				}
				else if(fnval.equals("modify"))
				{
					if(effstatus.equals("D") || allowwalkin.equals("N"))
						disable="readOnly";
					else 
						disable="";

				}			

				for(int i=1;i<=7;i++)
				{
					String max_walkin_per_day = "";

					if(fnval.equals("modify"))
						max_walkin_per_day = max_walkin_for_day[i-1];

			%>
					<td class='fields'>
						<input type='text' maxlength='3' size='3' name="max_walkin_for_day_<%=i%>" id="max_walkin_for_day_<%=i%>" value="<%=max_walkin_per_day%>" onKeyPress='return allowNumOnly(event);' onblur='chkValue(this);' <%=disable%> > 
					</td>
			<%
				}
			%>
		</tr>
	 </table>
	</td>
	</tr>
	</table>
	<table border='0' cellpadding=0 cellspacing=0 width='100%' >
		<th class='columnheader' width='100%'align ="left"><fmt:message key="eOP.OperatingTime.label" bundle="${op_labels}"/></th>
			<%
				if(fnval.equals("modify") && effstatus.equals("D"))
				{
					disable="readonly";
				}else
				{
					disable="";
				}
			%>
	<tr>
	<td width='100%' class='border'>
	 <table border='0' cellpadding='0' cellspacing='0' width='100%' >
		<tr>
			<td width='200pts' class='label' ><fmt:message key="Common.Start.label" bundle="${common_labels}"/>&nbsp;</td>				
			<td width='108pts' class='fields'><input type='text' name='start_time' id='start_time' value='<%=workingstarttime%>' SIZE=5 MAXLENGTH=5 onblur="CheckTime(this,'S');" <%=disable%>>
			</td>

			<td width='98pts' class='label'><fmt:message key="Common.End.label" bundle="${common_labels}"/></td>
			<td class='fields' colspan='5'><input type='text' name='end_time' id='end_time' value='<%=workingendtime%>' SIZE=5 MAXLENGTH=5 onblur="CheckTime(this,'E');" <%=disable%>>
			</td>			
        </tr>
		<tr>
			<td class='label' ><fmt:message key="eOP.BaseSlotSlabTime.label" bundle="${op_labels}"/></td>
			<td class='fields'><input type='text' name='base_slot_slab_time' id='base_slot_slab_time' value='<%=baseslabslottime%>' SIZE=5 MAXLENGTH=5 onblur="CheckTime(this,'SL');movefocus(this)" <%=disable%>>
			</td>
			<td colspan='6'>&nbsp;</td>									
		</tr>

	</table>
	</td>
	</tr>
</table>
</div>
<!-- <br><br><br><br><br><br><br><br><br><br>				
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<a name='others'></a> -->
<div id="others_div" style="visibility:hidden;display:none">
<table cellpadding=0 cellspacing=0 border=0 width='100%'>
	<th class='columnheader' align="left"><fmt:message key="eOP.AcctDepartmentService.label" bundle="${op_labels}"/></th>
	<tr>
	<td width='100%' class='border'>
    <table border='0' cellpadding='1' cellspacing='0' width='100%' >

	<tr>
		<td class='label' width='201pts'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
		</td>
		<td class='fields'  width='328pts'>
		<%
		if(fnval.equals("modify") && effstatus.equals("D"))
		{
		%>
			<input type="text" name="speciality_desc" id="speciality_desc" value="<%=specdesc%>" readonly><img src='../../eCommon/images/mandatory.gif' align='center'></img><input type="hidden" name="speciality" id="speciality" value="<%=speccode%>">
		<%
		}
		else
		{
		%>
			<select name='speciality' id='speciality' <%=multi_speciality_disabled%> onChange='javascript:if(document.forms[0].allow_visit_regn_yn.checked ==true){
				GetValues(this);}' ><option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
				bundle="${common_labels}"/> --------&nbsp;
		<%
		try{
			pstmt=conn.prepareStatement("select speciality_code,short_desc from am_speciality where eff_status='E' order by short_desc");
			rs=pstmt.executeQuery();
			if(rs !=null)
			{
				while(rs.next())
				{
					specialitycode=(rs.getString("speciality_code") == null)?"":rs.getString("speciality_code");
              specialitydesc=(rs.getString("short_desc") == null)?"":rs.getString("short_desc");
					
					if(specialitycode.equals(speccode))
					{
						sel="selected";
					}
					else
							sel="";

					
					%>
					<option value='<%=specialitycode%>' <%=sel%> ><%=specialitydesc%>
										
					<%
				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			
		}catch(Exception e)
			{
				e.printStackTrace();
			}
		%>

			</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
		<%
		}
		%>			
	
		
		</td>	
	<td class='label' width='216pts'><fmt:message key="Common.VitalSignsBattery.label" bundle="${common_labels}"/>
	</td>
	<td class='fields''>
	<%
	if(fnval.equals("modify") && effstatus.equals("D"))
	{
		%>
		<input type="text" name="vitalsignsb_desc" id="vitalsignsb_desc" value="<%=vitalsigndesc%>" readonly>
		<input type="hidden" name="vitalsignsb" id="vitalsignsb" value="<%=vitalsign%>">
				
		<%
	}
	else
	{
		%>
		<select name='vitalsignsb' id='vitalsignsb'>
		<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
			bundle="${common_labels}"/> -------&nbsp;
		<%
		try{
			   
				pstmt=conn.prepareStatement("select short_desc,discr_msr_id from am_discr_msr where eff_Status ='E' and result_type ='V' order by 1");
				rs=pstmt.executeQuery();
				if(rs != null)
				{
					while(rs.next())
					{
						vitalsigncode=(rs.getString("discr_msr_id") == null)?"":rs.getString("discr_msr_id");
						if(vitalsign.equals(vitalsigncode))
						{
							sel="selected";
						}
						else
							sel="";

						%>
							<option value='<%=vitalsigncode%>' <%=sel%> ><%=(rs.getString("short_desc") == null)?"":rs.getString("short_desc")%>
							<%
					}
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				
	}catch(Exception e)
		{
			e.printStackTrace();
		}
	%>
	</select>
	<%
	}
		%>
		</td>
		<td colspan=2>&nbsp;</td>
	<tr>
	<td class='label'><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
	<%
	if((fnval.equals("modify") && effstatus.equals("D") && visitcnt ==0 ) || (visitcnt > 0))
	{
	%>
		<input type="text" name="department_desc" id="department_desc" value="<%=acctdeptdesc%>" readonly><img src='../../eCommon/images/mandatory.gif' align='center'></img>
		<input type="hidden" name="department" id="department" value="<%=acctdept%>">
	<%
	}
	else if(visitcnt == 0)
	{
		
	%>
		<select name='department' id='department' onChange='GetValues(this)' ><option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;
		<%
			try{
					pstmt=conn.prepareStatement("select dept_code,dept_short_desc from am_facility_dept_vw where eff_status='E' and operating_facility_id='"+facilityid+"' order by dept_short_desc");
					rs=pstmt.executeQuery();
					if(rs != null) 
					{
						while(rs.next())
						{
							acctdeptcode=(rs.getString("dept_code") == null)?"":rs.getString("dept_code");
							
							if(acctdept.equals(acctdeptcode))
							{
								sel="selected";
							}
							else
								sel="";

							%>
								<option value='<%=acctdeptcode%>' <%=sel%>><%=(rs.getString("dept_short_desc") == null)?"":rs.getString("dept_short_desc")%>
							<%
						}
			
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	%>
		</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
	<%
	}
	%>
			
		</td>
		<td class='label'><fmt:message key="Common.Section.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<%
		if(fnval.equals("modify") && effstatus.equals("D"))
		{
		%>
			<input type="text" name="section_desc" id="section_desc" value="<%=sectiondesc%>" readonly>
			<input type="hidden" name="section" id="section" value="<%=section%>">
		<%
		}
		else
		{
		%>
			<SELECT name='section' id='section' > <OPTION VALUE='' >&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;
<%
	if(fnval.equals("modify") && !acctdept.equals(""))
	{
		try{

		sql1="Select clinicSection.SHORT_DESC clinicSectionName, clinicSection.SECTION_CODE clinicSectionCode from am_dept_section clinicSection, am_facility_section facilitySection where clinicSection.DEPT_CODE = facilitySection.DEPT_CODE and clinicSection.SECTION_CODE = facilitySection.SECTION_CODE and clinicSection.EFF_STATUS = 'E' and clinicSection.DEPT_CODE = ? and facilitySection.OPERATING_FACILITY_ID=? order by 1";
		pstmt=conn.prepareStatement(sql1);
		pstmt.setString(1, acctdept.trim());	
		pstmt.setString(2, facilityid);
		rs=pstmt.executeQuery();
			if(rs != null)
			{
				while(rs.next())
				{

					sectioncode=(rs.getString("clinicSectionCode") == null)?"":rs.getString("clinicSectionCode");

					if(section.equals(sectioncode))
					{
							sel="selected";
					}
					else
						sel="";

					%>
						<option value='<%=sectioncode%>' <%=sel%> ><%=(rs.getString("clinicSectionName") == null)?"":rs.getString("clinicSectionName")%>
					<%
				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
%>
	</select>
	<%
	}
	%>
	</td>
	<td colspan='2'>&nbsp;</td>
	</tr>
	<tr>
	<td class='label'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<%
		if((fnval.equals("modify") && effstatus.equals("D") && visitcnt ==0 ) || (visitcnt > 0))
		{
		%>
			<input type="text" name="service_desc" id="service_desc" value="<%=servicedesc%>" readonly><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			<input type="hidden" name="service" id="service" value="<%=service%>">
		<%
		}
		else if(visitcnt == 0)
		{
		%>
			<select name='service' id='service' ><OPTION VALUE=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;
		<%
			if(fnval.equals("modify") && !acctdept.equals(""))
			{
				try{
					pstmt=conn.prepareStatement("select service_code,service_short_desc from am_facility_service_vw where eff_status = 'E' and operating_facility_id =? and medical_yn='Y' and dept_code=? order by service_short_desc");
					pstmt.setString(1,facilityid);
					pstmt.setString(2,acctdept.trim());
					rs=pstmt.executeQuery();
					if(rs != null)
					{
						while(rs.next())
						{
							servicecode=(rs.getString("service_code") == null)?"":rs.getString("service_code");

							if(service.equals(servicecode))
							{
								sel="selected";
							}
							else
								sel="";

							%>
								<option value='<%=servicecode%>' <%=sel%>><%=(rs.getString("service_short_desc") == null)?"":rs.getString("service_short_desc")%>
							<%
						}

					}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		%>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
		<%
		}
		%>
	</td>
	<td colspan='4'>&nbsp;</td>
</table>
</td>
</tr>
</table>
	
	<table cellpadding=0 cellspacing=0 border=0 width='100%'>
	<th class='columnheader' align="left"><fmt:message key="eOP.MRSectionFileStorage.label" bundle="${op_labels}"/></th>
	<tr>
	<td width='100%' class='border'>
    <table border='0' cellpadding='1' cellspacing='0' width='100%' >	
	<tr>
		<td class='label' width='201pts'><fmt:message key="Common.MRSectionType.label" bundle="${common_labels}"/>
		</td>
		<td class='fields' width='328pts'>
		<%
				
			if(fnval.equals("modify") && effstatus.equals("D"))
			{
			%>
				<input type="text" name="mr_section_type_desc" id="mr_section_type_desc" value="<%=mrsectypedesc%>" readonly>
				<input type="hidden" name="mr_section_type" id="mr_section_type" value="<%=mrsectype%>">
			<%
			}
			else
			{
				// For the mr section type only if the single or multi files indicator == M then the values are populated else the field is shown as disabled.
			if(maintain_doc_or_file.equals("F"))
			{
			 if(!sormfiles.equals("M") && SEPARATE_FILE_NO_YN.equals("N"))
				{
					mrflag="N";
			%>
				<select name='mr_section_type' id='mr_section_type' disabled>
						<option value='' >&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
				bundle="${common_labels}"/> --------&nbsp;
				</select>
			<%
			}else
				{
				%>
				<select name='mr_section_type' id='mr_section_type' onChange='GetValues(this);' <%=disMrSection%>>
				<%
				}
			}
			else
			{
				%>
					<select name='mr_section_type' id='mr_section_type' <%=defaultdisable%> <%=disMrSection%>>
					<option value='' >&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
					bundle="${common_labels}"/> --------&nbsp;
				</select>
				<%
			}
			 if(maintain_doc_or_file.equals("F") && mrflag.equals("Y"))
			 {
					if(mrsectype.equals("D"))
					{
					%>
					
						<option value='' >&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
							bundle="${common_labels}"/> --------&nbsp;
						<option value='D' selected><fmt:message key="Common.Departmental.label" bundle="${common_labels}"/>&nbsp;
						<option value='C'><fmt:message key="Common.Central.label" bundle="${common_labels}"/>&nbsp;
					
					<%
					}
					else if(mrsectype.equals("C"))
					{
					%>
					<option value='' >&nbsp;-------- <fmt:message key="Common.defaultSelect.label"
						bundle="${common_labels}"/> --------&nbsp;
					<option value='D'><fmt:message key="Common.Departmental.label" bundle="${common_labels}"/>&nbsp;
					<option value='C' selected><fmt:message key="Common.Central.label" bundle="${common_labels}"/>&nbsp;
					<%
					}
					else
					{
					%>
					<option value='' selected>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
						bundle="${common_labels}"/> --------&nbsp;
					<option value='D'><fmt:message key="Common.Departmental.label" bundle="${common_labels}"/>&nbsp;
					<option value='C'><fmt:message key="Common.Central.label" bundle="${common_labels}"/>&nbsp;
					
					<%
					}
					%>
						</select>
					<%
				}
		}
		%>
		</td>
		<td class='label' width='216pts'><fmt:message key="Common.MRSection.label" bundle="${common_labels}"/> </td>
		 <td class='fields'>
			<%
			if(fnval.equals("modify") && effstatus.equals("D"))
			{
			%>
				<input type="text" name="mr_section_desc" id="mr_section_desc" value="<%=mrsectiondesc%>" readonly>
				<input type="hidden" name="mr_section" id="mr_section" value="<%=mrsection%>">
			<%
			}
		else
		{
			// For the mr section only if the single or multi files indicator == M then the values are populated else the field is shown as disabled.
			
			if(maintain_doc_or_file.equals("F"))
			{
			if(!sormfiles.equals("M") && SEPARATE_FILE_NO_YN.equals("N"))
			{
				mrflag1="N";
			%>
				<select name='mr_section' id='mr_section' disabled>
				<option value='' >&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
				bundle="${common_labels}"/> --------&nbsp;
				</select>
			<%

			}else
				{
				%>
				<select name='mr_section' id='mr_section' <%=disMrSection%>><option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;
				<%
				}
			}
			else
			{
				%>
				<select name='mr_section' id='mr_section'  <%=defaultdisable%> <%=disMrSection%>>
						<option value='' >&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
					bundle="${common_labels}"/> --------&nbsp;
				</select>
			<%
			}
		if(maintain_doc_or_file.equals("F")&& mrflag1.equals("Y"))
		{
		try{

		if(!fnval.equals("insert")){
			
			if(!mrsectype.equals("")){
		
			if(mrsectype.equals("C")){
			sql1="select mr_section_code,short_name from mr_section where facility_id='"+facilityid+"' and eff_status='E' and mr_section_type = 'C' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
			}else if(mrsectype.equals("D"))
			{
			sql1="select mr_section_code,short_name from mr_section where facility_id='"+facilityid+"' and eff_status='E' and mr_section_type = 'D' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
			}
		pstmt=conn.prepareStatement(sql1);
		rs=pstmt.executeQuery();
				if(rs != null)
				{
					while(rs.next())
					{

						mrsectioncode=(rs.getString("mr_section_code") == null)?"":rs.getString("mr_section_code");

						if(mrsection.equals(mrsectioncode))
						{
							sel="selected";
						}
						else
							sel="";
						%>
							<option value='<%=mrsectioncode%>' <%=sel%>><%=(rs.getString("short_name") == null)?"":rs.getString("short_name")%>
						<%
					}
				}
				
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				}
			}
	}catch(Exception e)
			{
				e.printStackTrace();
			}
		%>
		</select>
		<%
		}
	}
	%>
 </td>
<td colspan='2'>&nbsp;</td>
</tr>
<tr>
<td class='label'><fmt:message key="Common.FileStorageLocation.label" bundle="${common_labels}"/></td>
	 <td class='fields'>
   
	<%
	 if(fnval.equals("modify") && effstatus.equals("D"))
	{
	%>
		<input type="text" name="mr_location_desc" id="mr_location_desc" value="<%=fslocndesc%>" readonly>
		<input type="hidden" name="mr_location_code" id="mr_location_code" value="<%=fslocn%>">
	<%
	}
	else
	{	
	%>
		<select name="mr_location_code" id="mr_location_code" onchange="GetValues(this);" <%=disMrSection%>>
			<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
		bundle="${common_labels}"/> --------&nbsp;
	<%
		// If the FM install boolean is yes and in insert mode the single and multi files indicator is not M...then the field values are populated.The single and multi files ind is not considered for modify mode.
    	if(fm_install_yn.equals("Y"))
		{							
			if(fnval.equals("modify"))
			{				
			try
			{
				if(maintain_doc_or_file.equals("F"))
				{
			        fsflag="N";
               if(!mrsectype.equals(""))
				{
				if(mrsectype.equals("D")){
				
				pstmt=conn.prepareStatement("Select short_desc,fs_locn_code from fm_storage_locn where facility_id = ? and eff_status = 'E' and MR_LOCN_YN='Y' and permanent_file_area_yn='Y' and locn_identity ='"+central_value+"' order by short_desc ");
				}else if(mrsectype.equals("C")){
					pstmt=conn.prepareStatement(" Select short_desc,fs_locn_code from fm_storage_locn where facility_id = ? and locn_identity ='"+central_value+"' and permanent_file_area_yn='N' and eff_status = 'E' order by short_desc ");
				}
				
				pstmt.setString(1,facilityid);
//												
				rs=pstmt.executeQuery();
				if(rs != null)
				{
					while(rs.next())
					{
						fslocncode=(rs.getString("fs_locn_code") == null)?"":rs.getString("fs_locn_code");

						if(fslocn.equals(fslocncode))
						{
							sel="selected";
						}
						else
							sel="";

						%>
							<option value='<%=fslocncode%>' <%=sel%>><%=(rs.getString("short_desc") == null)?"":rs.getString("short_desc")%>
						<%
					}
				}

				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			  }
			  else
			  {
				  pstmt=conn.prepareStatement(" Select short_desc,fs_locn_code from fm_storage_locn where facility_id = ? and locn_identity ='"+central_value+"' and permanent_file_area_yn='N' and eff_status = 'E' order by short_desc ");
				
				
				pstmt.setString(1,facilityid);
												
				rs=pstmt.executeQuery();
				if(rs != null)
				{
					while(rs.next())
					{
						fslocncode=(rs.getString("fs_locn_code") == null)?"":rs.getString("fs_locn_code");

						if(fslocn.equals(fslocncode))
						{
							sel="selected";
						}
						else
							sel="";

						%>
							<option value='<%=fslocncode%>' <%=sel%>><%=(rs.getString("short_desc") == null)?"":rs.getString("short_desc")%>
						<%
					}
				}

				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			  }
	 		}	
			}catch(Exception e)
			{				
				e.printStackTrace();
			}
			}
			
			
			if(maintain_doc_or_file.equals("D"))
			 {
				msql="Select short_desc,fs_locn_code from fm_storage_locn where facility_id = '"+facilityid+"' and locn_identity ='"+central_value+"' and eff_status = 'E' order by short_desc";
				
			 }
			 else if(maintain_doc_or_file.equals("F")&& fsflag.equals("Y"))
			 {
				msql="Select short_desc,fs_locn_code from fm_storage_locn   where facility_id = '"+facilityid+"' and eff_status = 'E' and locn_identity ='"+central_value+"' and permanent_file_area_yn='N' order by short_desc ";
			
			 }
			 
				if(fsflag.equals("Y"))
				{
				pstmt=conn.prepareStatement(msql);
				rs=pstmt.executeQuery();
				if(rs != null)
				{
					while(rs.next())
					{
						fslocncode=(rs.getString("fs_locn_code") == null)?"":rs.getString("fs_locn_code");

						if(fslocn.equals(fslocncode))
						{
							sel="selected";
						}
						else
							sel="";

						%>
							<option value='<%=fslocncode%>' <%=sel%>><%=(rs.getString("short_desc") == null)?"":rs.getString("short_desc")%>
						<%
					}
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				}
			}
	%>
		</select><img id='popUp' src='../../eCommon/images/mandatory.gif' align='center' style='visibility:hidden'></img>
	<%
	}
	%>
	 </td>
<td class='label'><fmt:message key="Common.DefaultFileType.label" bundle="${common_labels}"/></td>
	<td class='fields'>
	<%
	if(fnval.equals("modify") && effstatus.equals("D"))
	{
	%>
		<input type="text" name="dflt_file_type_desc" id="dflt_file_type_desc" value="<%=dfltfiletypedesc%>" readonly>
		<input type="hidden" name="dflt_file_type" id="dflt_file_type" value="<%=dfltfiletype%>">
	<%
	}
	else
	{
		if(fnval.equals("modify"))
		{
		if(fm_install_yn.equals("Y"))
			{
			dfsql.append("select a.file_type_code file_type_code,b.short_desc  file_type_desc from 	fm_file_type_for_fsl a,mr_file_type b where b.facility_id ='"+facilityid+"'  and 		a.facility_id = b.facility_id and a.fs_locn_code ='"+fslocn+"'  and a.file_type_code = b.file_type_code");
			
			if((levelofcare.equals("A"))&&(!callfunc.equals("DaycareUnit")))
			 dfsql.append(" and b.appl_to_op='Y'");
			else if((levelofcare.equals("A"))&&(callfunc.equals("DaycareUnit")))
			 dfsql.append(" and b.appl_to_dc='Y'");
			else if(levelofcare.equals("E"))
             dfsql.append(" and b.appl_to_em='Y'");
				
			dfsql.append("order by file_type_desc ");
			}
		}
	  if(fm_install_yn.equals("N")){
				dfsql.append("select file_type_code,SHORT_DESC file_type_desc from mr_file_type  	where facility_id ='"+facilityid+"' and EFF_STATUS = 'E'");
				if(fnval.equals("insert")){
				if(!callfunc.equals("DaycareUnit")) 
				   dfsql.append(" and appl_to_op = 'Y' ");
				else
					dfsql.append(" and appl_to_dc='Y'");
				}else{
					if((levelofcare.equals("A"))&&(!callfunc.equals("DaycareUnit")))
					dfsql.append(" and appl_to_op='Y'");
			else if((levelofcare.equals("A"))&&(callfunc.equals("DaycareUnit")))
			dfsql.append(" and appl_to_dc='Y'");
			else if(levelofcare.equals("E"))
				dfsql.append(" and appl_to_em='Y'");
				}
				 dfsql.append(" order by short_desc");
			}
						
		%>
		<select name=dflt_file_type <%=defaultdisable%> <%=disMrSection%>><option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;
		<%
		if(fnval.equals("modify")||fm_install_yn.equals("N"))
		{
		try{
		dfstmt=conn.createStatement();
		dfrset=dfstmt.executeQuery(dfsql.toString());
		while(dfrset.next())
          {
		  default_code=dfrset.getString("file_type_code");
		  default_desc=dfrset.getString("file_type_desc");
			if(dfltfiletype.equals(default_code))	
				selvalue="selected";
			else
				selvalue="";
			%>
				<option value='<%=default_code%>' <%=selvalue%>><%=default_desc%></option>
						
		   <%}	
		if(dfrset != null )dfrset.close();
		if(dfstmt != null )dfstmt.close();
		dfsql.setLength(0);

		}catch(Exception e){
			e.toString();
			e.printStackTrace();
			}
			}%>																
		</select>
		<%

		}
		%>
		</td>
		<td colspan='2'>&nbsp;</td>
	</tr>
<tr>
<td class='label'><fmt:message key="Common.AutoFileRequest.label" bundle="${common_labels}"/></td>
	<td class='fields'>
		<%
			chkval="";
		/*
		if(clinic_type.equals("C") && levelofcare.equals("E"))
		{
			chkval="";
			//disable="disabled";
			autofilereq="N";
		}			
		else 
		{
		*/

		if(create_file_yn.equals("Y"))
		{
			if(maintain_doc_or_file.equals("D"))
			{
				autofilereq="N";
				chkval="";
			}

			if(autofilereq.equals("Y"))
			{
				chkval="checked";
			}
			else if(autofilereq.equals("N"))
			{
				chkval="";
			}				
			if((fnval.equals("modify") && effstatus.equals("D")) || maintain_doc_or_file.equals("D") || disMrSection.equals("disabled"))
			{
				disable="disabled";
			}else
			{
				disable="";
			}
		}
		else
		{
			autofilereq="N";
			chkval="";
			disable="disabled";
		}
		
		//}		
		%>
		<input type = 'hidden' name = 'reportCount' value = '<%=reportCount%>' >
		<input type='checkbox' name='online_mr_notfn_yn' id='online_mr_notfn_yn' <%=disable%> <%=disMrSection%> value='<%=autofilereq%>' <%=chkval%> onClick='assignval(this);reportCheck(this);' >	
		<script>
		function reportCheck(obj) {
			if(obj.checked == false)	 {				
			  if((document.forms[0].call_function.value == 'Clinic') && (document.forms[0].clinic_code.value != "")) {
				 if(document.forms[0].reportCount.value >0) {
						alert(getMessage("FM_ONLINE_REP_RULE_NOT_DEFINED","FM"));
						document.forms[0].online_mr_notfn_yn.checked = true;						
						document.forms[0].online_mr_notfn_yn1.value ='Y';
			    }
			  }
			}
	   }
		</script>
		<input type = 'hidden' name = 'online_mr_notfn_yn1' value = '<%=autofilereq%>' >
		<input type = 'hidden' name = 'create_file_yn' value = '<%=create_file_yn%>' >
	</td>
	<td colspan='4'>&nbsp;</td>
</tr>
</table>
</td>
</tr>
</table>
									
<table cellpadding='0' cellspacing='0' border='0' width='100%'>
<th class='columnheader'  align="left"><fmt:message key="eOP.ApplicableVisitTypeIndicators.label" bundle="${op_labels}"/></th>
<tr>
	<td width='100%' class='border'>
		 <table border='0' cellpadding='1' cellspacing='0' width='100%'>
			<%
			
		   %>
			<tr>
			<td class='label' width='201pts'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/>
			</td>
			<td class='fields' width='160pts'>
				<%
					chkval="";
					if(emerchk.equals("Y"))
					{
						chkval="checked";
					}
					else if(emerchk.equals("N"))
					{
						chkval="";
					}
					else
					{
						chkval="";
					}
											
			if((fnval.equals("modify") && effstatus.equals("D")))
			{
				disable="disabled";
			}else
			{
				disable="";
			}
		
		%>
			
		<input type='checkbox' name='emergency' id='emergency' value='<%=emerchk%>' <%=chkval%> onClick='assignval(this)' <%=disable%>>
		<input type='hidden' name='emergency1' id='emergency1' value='<%=emerchk%>'>
	</td>										
	<td class='label' width='156pts'><fmt:message key="Common.first.label" bundle="${common_labels}"/></td>
		<td class='fields' width='222pts'>
			<%
				chkval="";
				if(firstchk.equals("Y"))
				{
					chkval="checked";
				}
				else if(firstchk.equals("N"))
				{
					chkval="";
				}
				else
				{
					chkval="checked";
				}
	
		if(fnval.equals("modify") && effstatus.equals("D"))
		{
			disable="disabled";
		}else
		{
			disable="";
		}
	%>
	<input type='checkbox' name='first' id='first' value='<%=firstchk%>' <%=chkval%> onClick='assignval(this)' <%=disable%>>
	<input type='hidden' name='first1' id='first1' value='<%=firstchk%>'>	
</td>
<td class='label' width='154pts'><fmt:message key="Common.followup.label" bundle="${common_labels}"/>
<td class='fields'>
	<%
		chkval="";
		if(followchk.equals("Y"))
		{
			chkval="checked";
		}
		else if(followchk.equals("N"))
		{
			chkval="";
		}
		else
		{
			chkval="checked";
		}
		
		if(fnval.equals("modify") && effstatus.equals("D"))
		{
			disable="disabled";
		}else
		{
			disable="";
		}
										
	%>
		<input type='checkbox' name='followup' id='followup' value='<%=followchk%>' <%=chkval%> onClick='assignval(this)' <%=disable%>>
		<input type='hidden' name='followup1' id='followup1' value='<%=followchk%>' >
	</td>
</tr>
	<%
	%>
	<tr>
		<td class='label'><fmt:message key="Common.routine.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<%
				chkval="";
				if(routinechk.equals("Y"))
				{
					chkval="checked";
				}
				else if(routinechk.equals("N"))
				{
					chkval="";
				}
				else
				{
					chkval="checked";
				}
				
				if(fnval.equals("modify") && effstatus.equals("D"))
				{
					disable="disabled";
				}else
				{
					disable="";
				}
			
				
			%>
		<input type='checkbox' name='routine' id='routine' value='<%=routinechk%>' <%=chkval%> onClick='assignval(this)' <%=disable%>>
		<input type='hidden' name='routine1' id='routine1' value='<%=routinechk%>'>
	</td>


	<td class='label'><fmt:message key="Common.Series.label" bundle="${common_labels}"/></td>
	<td class='fields'>
		<%
			chkval="";
			if(serieschk.equals("Y"))
			{
				chkval="checked";
			}
			else if(serieschk.equals("N"))
			{
				chkval="";
			}
			else
			{
				chkval="checked";
			}
			
			if(fnval.equals("modify") && effstatus.equals("D"))
			{
				disable="disabled";
			}else
			{
				disable="";
			}
		
			
		%>

		<input type='checkbox' name='series' id='series' value='<%=serieschk%>' <%=chkval%> onClick='assignval(this)' <%=disable%>>
		<input type='hidden' name='series1' id='series1' value='<%=serieschk%>'>
	</td>											
							
	<%
     %>		
<td class='label'><fmt:message key="Common.Consult.label" bundle="${common_labels}"/></td>
<td class='fields'>
	<%
		chkval="";
		if(consultchk.equals("Y"))
		{
			chkval="checked";
		}
		else if(consultchk.equals("N"))
		{
			chkval="";
		}
		else
		{
			chkval="checked";
		}
		
		if(fnval.equals("modify") && effstatus.equals("D"))
		{
			disable="disabled";
		}else
		{
			disable="";
		}
						
			
		%>
		<input type='checkbox' name='consult' id='consult' value='<%=consultchk%>' <%=chkval%> onClick='assignval(this)' <%=disable%>>
		<input type='hidden' name='consult1' id='consult1' value='<%=consultchk%>'>
	<%%>	
	</td>
	</tr>
	</table>
	</td>
	</tr>
</table>
						<%
if(callfunc.equals("ProcedureUnit")||callfunc.equals("DaycareUnit"))
{
%>
<table cellpadding=0 cellspacing=0 border=0 width='100%'>
<th class='columnheader' align='left' ><fmt:message key="Common.ApplicablePatientClass.label" bundle="${common_labels}"/></th>
<tr>
	<td width='100%' class='border'>
		<table border='0' cellpadding='2' cellspacing='0' width='100%' >
			<tr>
				<td class='label' width='201pts'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></td>
				<td class='fields' width='325pts'>
					<%
					if(callfunc.equals("DaycareUnit"))
				{%>
			<input type='checkbox' name='op_class' id='op_class' value='N' disabled>
			<input type='hidden' name='op_class1' id='op_class1' value='N'>
											   
					<%	}
		    else
			{
			chkval="";
			disable="";
			if(opchk.equals("Y"))
			{
				chkval="checked";
			}
			else
			{
				chkval="";
			}
			if(fnval.equals("modify") && effstatus.equals("D"))
				{
					disable="disabled";
				}else
				{
					disable="";
				}

			%>
		<input type='checkbox' name='op_class' id='op_class' value='<%=opchk%>' onClick='assignval(this)' <%=chkval%> <%=disable%>>
		<input type='hidden' name='op_class1' id='op_class1' value='<%=opchk%>'>
	<%}%>
		</td>
		<td class='label' width='212pts'><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></td>
	<td class='fields'>
		<%
		chkval="";
		disable="";
		if(callfunc.equals("DaycareUnit"))
         {%>
			<input type='checkbox' name='ip_class' id='ip_class' value='N' disabled >
			<input type='hidden' name='ip_class1' id='ip_class1' value='N'>
															
	 <%}else
		{
			if(ipchk.equals("Y"))
			{
				chkval="checked";
			}
			else
			{
				chkval="";
			}
			if(fnval.equals("modify") && effstatus.equals("D"))
				{
					disable="disabled";
				}else
				{
					disable="";
				}

		%>
		<input type='checkbox' name='ip_class' id='ip_class' value='<%=ipchk%>' onClick='assignval(this)' <%=chkval%> <%=disable%>>
		<input type='hidden' name='ip_class1' id='ip_class1' value='<%=ipchk%>'>
	<%}%>
	</td>
	</tr>
	<tr>
	<td class='label'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></td>
	<td class='fields'>
		<%
		chkval="";
		disable="";
		if(callfunc.equals("DaycareUnit"))
		{%>
			<input type='checkbox' name='dc_class' id='dc_class' value='Y' checked disabled>
		<input type='hidden' name='dc_class1' id='dc_class1' value='Y'>
			
		<%}
	else
	{
		if(dcchk.equals("Y"))
		{
			chkval="checked";
		}
		else
		{
			chkval="";
		}
		if(fnval.equals("modify") && effstatus.equals("D"))
			{
				disable="disabled";
			}else
			{
				disable="";
			}
	%>
		<input type='checkbox' name='dc_class' id='dc_class' value='<%=dcchk%>' onClick='assignval(this)' <%=chkval%> <%=disable%><%=disable2%>>
		<input type='hidden' name='dc_class1' id='dc_class1' value='<%=dcchk%>'>
	<%}%>
	</td>
		<td class='label'><fmt:message key="Common.external.label" bundle="${common_labels}"/></td>
	<td class='fields'>
		<%
		chkval="";
		disable="";
		if(callfunc.equals("DaycareUnit"))
		{%>
		<input type='checkbox' name='em_class' id='em_class' value='N' disabled>
		<input type='hidden' name='em_class1' id='em_class1' value='N'>
																			
		<%}else
		{
			if(emchk.equals("Y"))
			{
				chkval="checked";
			}
			else
			{
				chkval="";
			}
			if(fnval.equals("modify") && effstatus.equals("D"))
				{
					disable="disabled";
				}else
				{
					disable="";
				}
				
			%>

			<input type='checkbox' name='em_class' id='em_class' value='<%=emchk%>' onClick='assignval(this)' <%=chkval%> <%=disable%> <%=disable2%>>
			<input type='hidden' name='em_class1' id='em_class1' value='<%=emchk%>'>
		<%}%>
			</td>									
	</tr>
	</table>
	</td>
	</tr>
	</table>
			<%
			}
			%>
    
		<table cellpadding=0 cellspacing=0 border=0 width='100%'>
				<%
				if(callfunc.equals("Clinic"))
				{
				%>
					<th class='columnheader' align='left' ><fmt:message key="eOP.PractitionerRoomPrivileges.label" bundle="${op_labels}"/></th>
				<%
				}
				else if(callfunc.equals("ProcedureUnit")||callfunc.equals("DaycareUnit"))
				{
				%>
					<th class='columnheader' align='left'><fmt:message key="eOP.ResourcePrivileges.label" bundle="${op_labels}"/></th>
				<%
				}
				%>
					<tr>
<td class='border' width='100%'>
	<table cellpadding=1 cellspacing=0 border=0 width='100%' >
		
		<tr>
			<td class='label' width='201pts'><fmt:message key="eOP.PrimaryResourceClass.label" bundle="${op_labels}"/></td>
			<td class='fields' width='328pts'>								
			<%
				String dis="";
				if(fnval.equals("modify") && effstatus.equals("D")&& (!callfunc.equals("DaycareUnit")))
				{
				%>
					<input type="text" name="primary_res_class_desc" id="primary_res_class_desc" value="<%=primaryresclassdesc%>" readonly>
					<input type="hidden" name="primary_res_class" id="primary_res_class" value="<%=primaryresclass%>">
				<%
				}
				else 
				{
			  if(callfunc.equals("DaycareUnit")){
					%>
					<select name='primary_res_class' id='primary_res_class' disabled>
					<option value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/> &nbsp;&nbsp;
					<%}else{
					
				if(fnval.equals("modify"))
					 dis="disabled";
				else
					 dis="";

			%>
				<select name='primary_res_class' id='primary_res_class' onChange='GetValues(this)' <%=dis%>>
				<%
				if(primaryresclass.equals("P"))
				{
				sql1="select pract_type, desc_sysdef from am_pract_type where eff_status='E' order by desc_sysdef";
				
				
				if(callfunc.equals("Clinic")&&fnval.equals("modify"))
					{
					  if(levelofcare.equals("E"))
						{
				%>
					<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
					bundle="${common_labels}"/> --------&nbsp;
					<option value='P' selected><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
				<%} else{%>
					<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
						bundle="${common_labels}"/> --------&nbsp;
					<option value='P' selected><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
					<option value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/>
					<%}}else{%>
					<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
						bundle="${common_labels}"/> --------&nbsp;
					<option value='P' selected><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
					<option value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/>
					<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
					<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/>	
				<%
					}
					}
				else if(primaryresclass.equals("R"))
				{
					sql1="select locn_type,short_desc from am_care_locn_type where care_locn_type_ind='R' order by short_desc";
				if(callfunc.equals("Clinic")&&fnval.equals("modify"))
					{
				%>
					<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label"
					bundle="${common_labels}"/> --------&nbsp;
					<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
					<option value='R'selected><fmt:message key="Common.room.label" bundle="${common_labels}"/>
					<%}else{%>
					<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
						bundle="${common_labels}"/> --------&nbsp;
					<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
					<option value='R' selected><fmt:message key="Common.room.label" bundle="${common_labels}"/>
					<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
					<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/>	
				<%
					}
					}
				else if(primaryresclass.equals("E"))
				{
					sql1="select resource_type,short_desc from am_resource_type where resource_class='E' order by short_desc";
				%>
					<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
					bundle="${common_labels}"/> --------&nbsp;
					<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
					<option value='R' ><fmt:message key="Common.room.label" bundle="${common_labels}"/>
					<option value='E' selected><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
					<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/>	
				<%
				}
				else if(primaryresclass.equals("O"))
				{
						sql1="select resource_type,short_desc from am_resource_type where resource_class='O' order by short_desc";
				%>
					<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
					bundle="${common_labels}"/> --------&nbsp;
					<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
					<option value='R' ><fmt:message key="Common.room.label" bundle="${common_labels}"/>
					<option value='E' ><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
					<option value='O' selected><fmt:message key="Common.other.label" bundle="${common_labels}"/>	
				<%
				}
				else
				{
				  if(callfunc.equals("Clinic")){
				%>
					<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
					bundle="${common_labels}"/> --------&nbsp;
					<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
					<option value='R' ><fmt:message key="Common.room.label" bundle="${common_labels}"/>
				<%}else{%>
					<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
						bundle="${common_labels}"/> --------&nbsp;
					<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
					<option value='R' ><fmt:message key="Common.room.label" bundle="${common_labels}"/>
					<option value='E' ><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
					<option value='O' ><fmt:message key="Common.other.label" bundle="${common_labels}"/>

					<%}
				}
					}
				%>					
				</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
				<%}%></td>
			<input type='hidden' name='multi_speciality_yn' id='multi_speciality_yn' value='<%=multi_speciality_yn%>' />
			<td class='label' width='216pts'><fmt:message key="eOP.PrimaryResourceType.label" bundle="${op_labels}"/></td>
			<td class='fields'>								
			<%
				if(fnval.equals("modify") && effstatus.equals("D")&& (!callfunc.equals("DaycareUnit")))
				{
				%>
					<input type="text" name="primary_res_type_desc" id="primary_res_type_desc" value="<%=practtypedesc%>" readonly>
					<input type="hidden" name="primary_res_type" id="primary_res_type" value="<%=practtype%>">
				<%
				}
				else 
				{
				if(callfunc.equals("DaycareUnit")){
				%>
				<select name='primary_res_type' id='primary_res_type' disabled>
				<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
					bundle="${common_labels}"/> --------&nbsp;
				<%}else{
				
				if(fnval.equals("modify"))
					dis="disabled";
				else
					 dis="";
				%>
				<select name='primary_res_type' id='primary_res_type' <%=dis%>>
				<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
					bundle="${common_labels}"/> --------&nbsp;
				<%
				if(fnval.equals("modify"))
					{
						try{
								pstmt=conn.prepareStatement(sql1);
									rs=pstmt.executeQuery();
									if(rs != null)
									{
										while(rs.next())
										{
											practtypecode=(rs.getString(1) == null)?"":rs.getString(1);
											if(practtype.equals(practtypecode))
													{
														sel="selected";
													}
													else
													{
														sel="";
													}
													%>
														<option value="<%=practtypecode%>" <%=sel%>><%=(rs.getString(2) == null)?"":rs.getString(2)%>
													<%
												}
											}
														if(rs != null) rs.close();
												if(pstmt != null) pstmt.close();
																
																	
																}catch(Exception e)
																{
																	e.printStackTrace();
																}
															}
													}
														%>
														</select>
													<%
													}
													%>
													</td>
													<%
													//}
													%>
			<td colspan='2'>&nbsp;</td>
			</tr>
			<tr>
			<td class='label'><fmt:message key="eOP.OpentoallResources.label" bundle="${op_labels}"/></td>
			<td class='fields'>
				<%
					chkval="";
			if(callfunc.equals("DaycareUnit")){
			%>
				<input type='checkbox' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value='Y' checked disabled> 
				<input type='hidden' name='open_to_all_pract_yn1' id='open_to_all_pract_yn1' value='Y' >
			
			<%}else{
				
			   
				String chkdis="";
				if(chkinident.equals("X"))
					chkdis="disabled";
				 else
					 chkdis="";
	
					if(open_to_all_pract_yn.equals("Y"))
					{
						chkval="checked";
					}
					else 
					{
						chkval="";
					}		
					
					if(fnval.equals("modify") && effstatus.equals("D"))
					{
						disable="disabled";
					}else
					{
						disable="";
					}
				
					
				%>
				<input type='checkbox' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value='<%=open_to_all_pract_yn%>' <%=chkval%> onClick='assignval(this)' <%=disable%> <%=chkdis%>> 
				<input type='hidden' name='open_to_all_pract_yn1' id='open_to_all_pract_yn1' value='<%=open_to_all_pract_yn%>' >
			   <%}%>
			</td>		
		<td class='label'><fmt:message key="eOP.CheckinatIdentification.label" bundle="${op_labels}"/></td>
		<td class='fields'>
		<%
		if(fnval.equals("modify") && effstatus.equals("D")&&(!callfunc.equals("DaycareUnit")))
		{
		%>
			<input type="text" name="ident_at_checkin_desc" id="ident_at_checkin_desc" value="<%=chkinidentdesc%>" readonly><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			<input type="hidden" name="ident_at_checkin" id="ident_at_checkin" value="<%=chkinident%>">
		<%
		}
		else
		{
			if(callfunc.equals("DaycareUnit")){
			%>
			<select name='ident_at_checkin' id='ident_at_checkin' disabled>
			<option value=''>&nbsp; -------- <fmt:message key="Common.defaultSelect.label" 
				bundle="${common_labels}"/> --------&nbsp;
			<option value='X' selected><fmt:message key="eOP.NotIdentifiable.label" 
				bundle="${op_labels}"/>
			<%}
			else
			{
			if(levelofcare.equals("E")&&fnval.equals("modify"))
			{
			%>
			<select name='ident_at_checkin' id='ident_at_checkin' disabled>
			 <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
				bundle="${common_labels}"/> --------&nbsp;
			<option value='X' selected><fmt:message key="eOP.NotIdentifiable.label" 
				bundle="${op_labels}"/>
			<%}else{
				
																	
				%>
			<select name='ident_at_checkin' id='ident_at_checkin'  <%=disMrSection%> onChange="javascript:open_to_all_pract_yn1.value='N';open_to_all_pract_yn.value='N';open_to_all_pract_yn.checked=false;open_to_all_pract_yn.disabled=false;if(this.value=='P'){ open_to_all_pract_yn.value='N';open_to_all_pract_yn1.value='N';allow_unassign_queue.checked=false;if(allow_visit_regn_yn.checked==true)allow_unassign_queue.disabled=false;else allow_unassign_queue.disabled=true; open_to_all_pract_yn.checked=false;if(primary_res_class.value!='P'){open_to_all_pract_yn.disabled=true;}primary_res_type.disabled=false;}if (this.value=='X'){ allow_visit_regn_yn.checked==true?allow_unassign_queue.disabled=false:allow_unassign_queue.disabled=true;open_to_all_pract_yn.checked=true;open_to_all_pract_yn.value='Y';open_to_all_pract_yn1.value='Y';open_to_all_pract_yn.disabled=true;
			if(primary_res_class.value=='P'){
			primary_res_type.disabled=true;}} if(this.value==''){primary_res_type.disabled=false;if(allow_visit_regn_yn.checked==true)allow_unassign_queue.disabled=false;else allow_unassign_queue.disabled=true;if(primary_res_class.value!='P'){open_to_all_pract_yn.disabled=true;}}">
			
			<%
											
			if(chkinident.equals("X"))
			{
			 
			%>
				
			 <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
				 bundle="${common_labels}"/> --------&nbsp;
			<option value='X' selected><fmt:message key="eOP.NotIdentifiable.label" 
				bundle="${op_labels}"/>
			<option value='P'><fmt:message key="Common.resource.label" bundle="${common_labels}"/>
				<%	
							
			
			}
			else if(chkinident.equals("P"))
			{
				 if(primaryresclass.equals("P")){
			%>
				
					 <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
						 bundle="${common_labels}"/> --------&nbsp;
					 <option value='X'><fmt:message key="eOP.NotIdentifiable.label" bundle="${op_labels}"/><option value='P' selected><fmt:message key="Common.resource.label" bundle="${common_labels}"/>
			<%	
				 }else{%>
			<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
						 bundle="${common_labels}"/> --------&nbsp;
				<option value='P' selected>&nbsp;<fmt:message key="Common.resource.label" bundle="${common_labels}"/> &nbsp;
			<%}
			}

		else
			{ 
			 %>
					<option value='' selected>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
				 bundle="${common_labels}"/> --------&nbsp;
					<option value='X'>&nbsp;<fmt:message key="eOP.NotIdentifiable.label" bundle="${op_labels}"/> &nbsp;
					<option value='P'>&nbsp;<fmt:message key="Common.resource.label" bundle="${common_labels}"/> &nbsp;				
			<%		
			
					} }
		}
			%>
				</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			
				
				<%
		
		}
		%>				
		</td>
		<td colspan='2'>&nbsp;</td>
		</tr>
		<tr>
		<td class='label'><fmt:message key="eOP.SelectUnassignedPatients.label" bundle="${op_labels}"/></td>
		<td class='fields' >
			<%
				chkval="";
				if(selunassgnyn.equals("Y"))
				{
					chkval="checked";
				}
				else 
				{
					chkval="";
				}	
				
				if(fnval.equals("modify") && effstatus.equals("D"))
				{
					disable="disabled";
				}else
				{
					disable="";
				}
			%>
			<input type='checkbox' name='allow_unassign_queue' id='allow_unassign_queue' value='<%=selunassgnyn%>' <%=chkval%> onClick='assignval(this)' <%=disable%>>
			<input type='hidden' name='allow_unassign_queue1' id='allow_unassign_queue1' value='<%=selunassgnyn%>' >
		</td>	
	<td class='label'><fmt:message key="eOP.AllowConsultationOn.label" bundle="${op_labels}"/></td>
	<td class='fields'>
			<%
			if(fnval.equals("modify") && effstatus.equals("D"))
			{
			%>
			<input type='text' name="disp_in_ca_queue_after_desc" id="disp_in_ca_queue_after_desc" value="<%=allowconsultdesc%>" readonly>
			<input type="hidden" name="disp_in_ca_queue_after" id="disp_in_ca_queue_after" value="<%=allowconsult%>">
			<%
			}
			else
			{
				%>
					<select name='disp_in_ca_queue_after' id='disp_in_ca_queue_after'>
				<%
					if(allowconsult.equals("01"))
					{
					%>
						<option value='01' selected><fmt:message key="eOP.CheckedIn.label" bundle="${op_labels}"/></option>
						<option value='02'><fmt:message key="eOP.arrived.label" bundle="${op_labels}"/></option>
					<%
					}
					else if(allowconsult.equals("02"))
					{
					%>
						<option value='01'><fmt:message key="eOP.CheckedIn.label" bundle="${op_labels}"/></option>
						<option value='02' selected><fmt:message key="eOP.arrived.label" bundle="${op_labels}"/></option>
					<%
					}
					else
					{
					%>
						<option value='01' selected><fmt:message key="eOP.CheckedIn.label" bundle="${op_labels}"/></option>
						<option value='02'><fmt:message key="eOP.arrived.label" bundle="${op_labels}"/></option>
					<%
					}

				%>						
					</select>
			<%
			}
			%>
	</td>	
<td colspan='2'>&nbsp;</td>
</tr>
</table>
</td>
</tr>
</table>
<% if(!callfunc.equals("DaycareUnit"))
{%>
<table cellpadding=0 cellspacing=0 border=0 width='100%'>
<th class='columnheader' align="left"><fmt:message key="eOP.QueueNumberingControls.label" bundle="${op_labels}"/></th>
</table>
<table cellpadding='1' cellspacing=0 border='0' width='100%'>
<tr>
	<td class='label' width='201pts'><fmt:message key="eOP.NumberingApplicable.label" bundle="${op_labels}"/></td>
	<%				
			if(assign_q_num_by.equals("S"))
			{
			
				if(queue_num_appl.equals("Y"))
				{
					ckval="checked";				
				}
				else
				{
					ckval="";				
				}
			}
			else if(assign_q_num_by.equals("M"))
			{
				ckval="";
			}
			
			if(fnval.equals("modify") && effstatus.equals("D")||assign_q_num_by.equals("M"))
				{
					disable="disabled";
				}else
				{
					disable="";
				}
	%>
    <td class='fields' width='328pts'><input type='checkbox' name='num_appl' id='num_appl' value='<%=queue_num_appl%>' onClick='queCheckVal(this);' <%=ckval%> <%=disable%> onblur='movefocus(this)'>
	<input type='hidden' name='num_appl_yn' id='num_appl_yn' value='<%=queue_num_appl%>'>
	
	<!--Changes for Bru-HIMS-CRF 192.1 starts-->
	<%
		boolean isQMSapplicable=eOP.QMSInterface.isSiteSpecific(conn,"OP","EXT_QUEUE_NO");
	if (isQMSapplicable && callfunc.equals("Clinic")){
	if(qms_interfaced_yn.equals("Y")){
	qms_chkval="checked";
	}%>
	<td class='label' width='212pts'><fmt:message key="eOP.QMS.label" bundle="${op_labels}"/></td>
	<td class='fields' ><input type='checkbox' name='qms_appl_yn' id='qms_appl_yn' value='<%=qms_interfaced_yn%>' onclick='queueNumbering(this);' <%=qms_chkval%> <%=disMrSection%> />
	
	<%}	
	%>
	<td colspan='2'>&nbsp;</td>
	<input type='hidden' name='qms_interfaced_yn' id='qms_interfaced_yn' value='<%=qms_interfaced_yn%>'>
	<!--Changes for Bru-HIMS-CRF 192.1 ends-->


</tr>

<!--added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 02-05-2023 Started-->

<%

if(isQMSapplicable && callfunc.equals("Clinic"))
	{
	
	if(queue_no_mandate.equals("Y"))
	{
		ckval_QNM="checked";
	}else
	{
		ckval_QNM="";
	}
%>
	<tr>
		<td class='label' width='201pts'><fmt:message key="eOP.QueueNoMandate.label" bundle="${op_labels}"/></td>
		 <!--<%=disable_QNM%>-->
		<td class='fields' width='328pts'><input type='checkbox' name='Queuenomandate' id='Queuenomandate'  id='Queuenomandate' value='<%=queue_no_mandate%>' onClick='Queuenomandate_change();' <%=ckval_QNM%> >
		<!--  in case of disable use this, no need to change java saving file  -->
		<input type='hidden' name='Queuenomandate_yn' id='Queuenomandate_yn' value='<%=queue_no_mandate%>'>
	</tr>
	<%
	}
 else
{ %>
		<input type='hidden' name='Queuenomandate_yn' id='Queuenomandate_yn' value='N'>
	<% 
	}
%>
<!--added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 02-05-2023 Started-->


</table>
<% 
} 
%>
<!-- Bru-HIMS-CRF-179-DD1 changes -Start -->
<% if(!callfunc.equals("DaycareUnit"))
	{%>
<table cellpadding=0 cellspacing=0 border=0 width='100%'>
<th class='columnheader' align="left"><fmt:message key="Common.ManagePatQ.label" bundle="${common_labels}"/></th>
</table>
<table cellpadding='1' cellspacing=0 border='0' width='100%'>
<tr>
		<td class='label' width='201pts'><fmt:message key="eOP.calculateWaitTime.label" bundle="${op_labels}"/></td>
		<td class='fields' width='328pts'><select name='cal_wait_time_based' id='cal_wait_time_based'>	
		<option value='' <%=selDefault%> >&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
		<option value='01' <%=selCheckedIn%> ><fmt:message key="eOP.CheckedIn.label" bundle="${op_labels}"/></option>
		<option value='02' <%=selArrived%> ><fmt:message key="eOP.ArrivedAtNursStn.label" bundle="${op_labels}"/></option>
		</select></td> 
		<td colspan='2'>&nbsp;</td>
		<td colspan='2'>&nbsp;</td>
</tr>
</table>
<% }%>
<!--Shagar MO-CRF-20121.1-->
<table cellpadding=0 cellspacing=0 border=0 width='100%'>
<th class='columnheader' align="left"><fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/></th>
</table>
<table cellpadding='1' cellspacing=0 border='0' width='100%'>
<tr>
	 <td class='label' width='201pts' ><fmt:message key="Common.contactNo.label" bundle="${common_labels}"/></td>
	 <td class='fields'><input type='text' name='contact_no' id='contact_no' value="<%=contact_no%>" size='20' maxlength='15'  onKeyPress="return SpCharChkForContNo(event)" onblur='return isValidCharacter(this);'</td>
</tr>
</table>
<!-- Bru-HIMS-CRF-179-DD1 changes -End -->


</div>
<!-- <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
 
<a name='pat_instructions' ></a> -->
<div id="pat_ins_div" style="visibility:hidden;display:none">
<table border='0' cellpadding='0' cellspacing='0'  align='center'  width='100%'>

<!-- <tr>
	<td  colspan='5'><font color='blue'><b><fmt:message key="eAM.PatInstructions.label" bundle="${am_labels}"/></font></td>
</tr> -->
<tr>
	<td  colspan='5'>&nbsp;</td>
</tr>
<tr>
	 <td width='20%' class='label'><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></td>
	 <td class='fields'><input type='text' name='serial_no' id='serial_no' value="" size='10' maxlength='2'  onKeyPress="return CheckForSpecChar(event)" onblur="if(this.value!='')CheckForZero()"><img src='../../eCommon/images/mandatory.gif'></img></td>
	 <td width='20%'>&nbsp;</td>
     <td class='label'><fmt:message key="eAM.InstructionDescript.label" bundle="${am_labels}"/></td>
	 <td><input type="text" name="instruction_desc" id="instruction_desc" size="12" maxlength="200" value="" onblur='getInstructionDesc(instruction_desc)' ><input type='button' name='desc_button' id='desc_button' value='?'  class='button' onClick='getInstructionDesc(instruction_desc)' ><img src='../../eCommon/images/mandatory.gif'></img></td>
</tr>
<tr>
	 <td width='20%' class='label'><fmt:message key="eAM.InstructionID.label" bundle="${am_labels}"/></td>
	 <td class='fields'><input type='text' name='instruction_id' id='instruction_id' size='10' maxlength='8' value="" readonly></td>
	 <td width='20%'>&nbsp;</td>
     <td width='20%'>&nbsp;</td>
	 <td><input type='button' name='add' id='add' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' class='button' onClick='addRecord()'>
	 <!-- <input type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick=' clearFields()' > -->
	<input type='button' name='del' id='del'  disabled value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' class='button' onClick=' deleteRecord()' ></td>
</tr>
<tr id='searchBoxBG' style='display:inline'>
	<td colspan="5">
	<%if(!imgUrl.equals("")){ %>
		<img src='<%=imgUrl%>' width='100%' height='15'/> 
	<%}%>
	</td>
</tr>
</table>
</div>
<!-- <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> -->
<input type='hidden' name='mode_flag' id='mode_flag' value='<%=mode_flag%>'>
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<%
	if(fnval.equals("modify")){%>
		<script>		        
         parent.frames[2].location.href="../../eOP/jsp/PatInstructionsResult.jsp?mode=modify&clinic_code=<%=cliniccode%>&facility_id=<%=facilityid%>&function_id=<%=function_id%>";
		</script>
	<%}%>
</form>

 <%

}catch(Exception e)
{
		e.printStackTrace();
}
finally
	{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close(); 
			}catch(Exception e){}
 		   if(conn!=null)
			  ConnectionManager.returnConnection(conn,request);
		}
		%>
		</div>
	
	</body>
</html>

