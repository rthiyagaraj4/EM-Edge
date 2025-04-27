<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%@ page import= "webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,com.ehis.util.DateUtils,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
	<script src='../../eIP/js/RefPatientDtls.js' language='javascript'></script>
	
</head> 
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection con					= null;
	Statement stmt					= null;
	ResultSet rset					= null;
	ResultSet rs3					= null;
	PreparedStatement pstmt1	= null;
	String locale					= (String)session.getAttribute("LOCALE");
	String facilityId				= (String)session.getValue("facility_id");
	StringBuffer SqlSB				= new StringBuffer();
	String meddesc					= "";
	String admission_date_time		= "";
	String adm_date_display			= "";
	String admission_short_desc		= ""; 
	String specialty_short_desc		= ""; 
	String practitioner_name		= "";
	String patient_type_short_desc  = "";
	String nursing_unit_short_desc  = "";
	String service_short_desc		= "";
	String bed_no					= "";
	String room_no					= "";
	String bed_class_short_desc		= "";
	String patient_id				= "";
	String bed_type_code			= "";
	String bed_type_short_desc      = "";
	String bed_class_code			= "";
	String practitioner_id			= "";
	String specialty_code			= "";
	String nursing_unit_code		= "";
	String service_code				= "";
	String patient_type				= "";
	String gender					= "";
	String medteamdesc				= "";
	String nursingunitcode			= "";
	int discharge_after_hrs			= 0;
	int dis_date_chk_days			= 0;

	String eid = request.getParameter("encounter_id");
	long encounterid = Long.parseLong(eid);

	String from_hcare_setting_type_code= "";
	
	/*Below line Added for this CRF Bru-HIMS-CRF-354 [IN:038538]*/
	String  pract_bedside_referral=""; String loginpractitioner="";String functionroleid="";
    String globaluser = (String)(session.getValue("login_user")==null?"":session.getValue("login_user")); 
	//End this CRF Bru-HIMS-CRF-354 [IN:038538]
	

	String function_id			= checkForNull(request.getParameter("function_id"));
	
	String called_from			= checkForNull(request.getParameter("called_from"));
	String caller_ID			= checkForNull(request.getParameter("call_function"));
	
	//Added for this CRF ML-MMOH-CRF-0566
	String callfrom = checkForNull(request.getParameter("callfrom"));
	
	String referral_id			= checkForNull(request.getParameter("referral_id"));
	String patient_class		= checkForNull(request.getParameter("patient_class"));

	String bed_block_period_dis	= checkForNull(request.getParameter("bed_block_period_dis"));
	if(!bed_block_period_dis.equals(""))
		discharge_after_hrs = Integer.parseInt(bed_block_period_dis);

	String dis_date_chk_days_str= checkForNull(request.getParameter("dis_date_chk_days"));
	if(!dis_date_chk_days_str.equals(""))
		dis_date_chk_days = Integer.parseInt(dis_date_chk_days_str);

	String system_date_time = "" ;
	String system_date = "" ;

	boolean isBedSideReferralApplforAE = false; //Added by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978

	try
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();

		isBedSideReferralApplforAE = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "BED_SIDE_REFERRAL_FOR_AE");//Added by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978

		/*
		SqlSB.append(" select hcare_setting_type_code from SM_FACILITY_PARAM where facility_id = '"+facilityId+"' ");

		rset=stmt.executeQuery(SqlSB.toString());
		if(rset!=null)
		{
			while(rset.next())
			{
				from_hcare_setting_type_code=rset.getString("hcare_setting_type_code");
			}
		}

		if(rset!=null) rset.close();
		*/

        if(isBedSideReferralApplforAE){
		String sql1="select patient_class from pr_encounter where facility_id=? and encounter_id=? " ;
		pstmt1 = con.prepareStatement(sql1) ;
		pstmt1.setString(1,facilityId);
		pstmt1.setString(2,eid);
			
		rs3 = pstmt1.executeQuery();
		if (rs3!=null && rs3.next()) {
			patient_class=rs3.getString("PATIENT_CLASS");
		}
		}

		//Added by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978
		if(isBedSideReferralApplforAE && patient_class.equals("EM")){

			if (SqlSB.length() > 0)
			SqlSB.delete(0, SqlSB.length());

		    SqlSB.append("SELECT To_char(a.VISIT_ADM_DATE_TIME,'dd/mm/rrrr hh24:mi') Admission_Date_Time,");
			SqlSB.append("        a.VISIT_TYPE_DESC Admission_Short_desc,");
			SqlSB.append("        Am_Get_desc.AM_SPECIALITY(a.Specialty_Code,'"+locale+"','2') Specialty_Short_desc,");
			SqlSB.append("        Am_Get_desc.AM_PRACTITIONER(a.attend_Practitioner_Id,'"+locale+"','1') Practitioner_Name,");
			SqlSB.append("        '' Patient_Type_Short_desc,");
			SqlSB.append("        a.clinic_name nurSing_Unit_Short_desc,");
			SqlSB.append("        Am_Get_desc.AM_SERVICE(a.Service_Code,'"+locale+"','2') Service_Short_desc,");
			SqlSB.append("        a.ASSIGN_BED_NUM Bed_No,");
			SqlSB.append("        a.ASSIGN_ROOM_NUM Room_No,");
			SqlSB.append("        ip_Get_desc.IP_BED_CLASS(a.ASSIGN_BED_CLASS_CODE,'"+locale+"','2') Bed_Class_Short_desc,");
			SqlSB.append("        NULL dly_Charge,");
			SqlSB.append("        a.Patient_Id,");
			SqlSB.append("        '' bed_type_code,");
			SqlSB.append("        '' Bed_Type_Short_desc,");
			SqlSB.append("        a.ASSIGN_BED_CLASS_CODE Bed_Class_Code,");
			SqlSB.append("        a.ASSIGN_CARE_LOCN_CODE nurSing_Unit_Code,");
			SqlSB.append("        a.attend_Practitioner_Id Practitioner_Id,");
			SqlSB.append("        a.Specialty_Code,");
			SqlSB.append("        a.ASSIGN_CARE_LOCN_CODE nurSing_Unit_Code,");
			SqlSB.append("        a.Service_Code,");
			SqlSB.append("        a.patient_class,");
			SqlSB.append("        b.sex Gender,");
			SqlSB.append("        to_char(sysdate,'dd/mm/rrrr hh24:mi') system_date_time, to_char(sysdate,'dd/mm/rrrr') system_date,");
			SqlSB.append("        '' Team_desc, c.hcare_setting_type_code,d.dflt_pract_bedside_referral dflt_pract_bedside_referral,"); 
			SqlSB.append("(SELECT am_get_desc.am_practitioner (FUNC_ROLE_ID,'"+locale+"','1')  FROM sm_appl_user WHERE appl_user_id = '"+globaluser+"' AND func_role = 'P') loginPractitioner,");
			SqlSB.append("(SELECT func_role_id FROM sm_appl_user WHERE appl_user_id = '"+globaluser+"' AND func_role = 'P') func_role_id");
			SqlSB.append(" FROM   PR_ENCOUNTER_VW a, mp_patient b, SM_FACILITY_PARAM c,ip_param d");
			SqlSB.append(" WHERE  a.Facility_Id = '"+facilityId+"'");
			SqlSB.append("        AND a.Encounter_Id = '"+encounterid+"' and a.patient_id = b.patient_id and a.Facility_Id = c.facility_id and a.Facility_Id = d.facility_id"); 
              
		}//End ML-MMOH-CRF-1978
        else{
		if (SqlSB.length() > 0)
			SqlSB.delete(0, SqlSB.length());

		SqlSB.append("SELECT To_char(a.Admission_Date_Time,'dd/mm/rrrr hh24:mi') Admission_Date_Time,");
		SqlSB.append("        ip_Get_desc.IP_ADMISSION_TYPE(a.Admission_Type,'"+locale+"','2') Admission_Short_desc,");
		SqlSB.append("        Am_Get_desc.AM_SPECIALITY(a.Specialty_Code,'"+locale+"','2') Specialty_Short_desc,");
		SqlSB.append("        Am_Get_desc.AM_PRACTITIONER(a.attend_Practitioner_Id,'"+locale+"','1') Practitioner_Name,");
		SqlSB.append("        '' Patient_Type_Short_desc,");
		SqlSB.append("        ip_Get_desc.IP_NURSING_UNIT(a.Facility_Id, a.nurSing_Unit_Code,'"+locale+"',");
		SqlSB.append("                                    '2') nurSing_Unit_Short_desc,");
		SqlSB.append("        Am_Get_desc.AM_SERVICE(a.Service_Code,'"+locale+"','2') Service_Short_desc,");
		SqlSB.append("        a.bed_num Bed_No,");
		SqlSB.append("        a.room_num Room_No,");
		SqlSB.append("        ip_Get_desc.IP_BED_CLASS(a.Bed_Class_Code,'"+locale+"','2') Bed_Class_Short_desc,");
		SqlSB.append("        NULL dly_Charge,");
		SqlSB.append("        a.Patient_Id,");
		SqlSB.append("        a.Bed_Type_Code,");
		SqlSB.append("        ip_Get_desc.IP_BED_TYPE(a.Bed_Type_Code,'"+locale+"','2') Bed_Type_Short_desc,");
		SqlSB.append("        a.Bed_Class_Code,");
		SqlSB.append("        a.nurSing_Unit_Code,");
		SqlSB.append("        a.attend_Practitioner_Id Practitioner_Id,");
		SqlSB.append("        a.Specialty_Code,");
		SqlSB.append("        a.nurSing_Unit_Code,");
		SqlSB.append("        a.Service_Code,");
		//SqlSB.append("        a.Patient_Type,");
		/*Wednesday, May 12, 2010 , Patient_Type is not available in ip_open_encounter */
		SqlSB.append("        a.patient_class,");
		SqlSB.append("        b.sex Gender,");
		SqlSB.append("        to_char(sysdate,'dd/mm/rrrr hh24:mi') system_date_time, to_char(sysdate,'dd/mm/rrrr') system_date,");
		SqlSB.append("        Am_Get_desc.AM_MEDICAL_TEAM(a.Facility_Id, a.Team_Id,'"+locale+"','2') Team_desc, c.hcare_setting_type_code,d.dflt_pract_bedside_referral dflt_pract_bedside_referral,"); //this line modified for this CRF [Bru-HIMS-CRF-354]
		SqlSB.append("(SELECT am_get_desc.am_practitioner (FUNC_ROLE_ID,'"+locale+"','1')  FROM sm_appl_user WHERE appl_user_id = '"+globaluser+"' AND func_role = 'P') loginPractitioner,"); //this line Added for this CRF CRF [Bru-HIMS-CRF-354]
		SqlSB.append("(SELECT func_role_id FROM sm_appl_user WHERE appl_user_id = '"+globaluser+"' AND func_role = 'P') func_role_id");
		SqlSB.append(" FROM   ip_Open_Encounter a, mp_patient b, SM_FACILITY_PARAM c,ip_param d");
		SqlSB.append(" WHERE  a.Facility_Id = '"+facilityId+"'");
		SqlSB.append("        AND a.Encounter_Id = '"+encounterid+"' and a.patient_id = b.patient_id and a.Facility_Id = c.facility_id and a.Facility_Id = d.facility_id");		//this line modified for this CRF [Bru-HIMS-CRF-354]
		}
		System.out.println("SqlSB.toString()==="+SqlSB.toString());
		
		rset	= stmt.executeQuery(SqlSB.toString());
		if(rset != null && rset.next()){
			admission_date_time		= checkForNull(rset.getString("admission_date_time")); 			
			admission_short_desc		= checkForNull(rset.getString("admission_short_desc")); 
			specialty_short_desc		= checkForNull(rset.getString("specialty_short_desc")); 
			practitioner_name				= checkForNull(rset.getString("practitioner_name"));
			patient_type_short_desc	= checkForNull(rset.getString("patient_type_short_desc"));       
			nursing_unit_short_desc	= checkForNull(rset.getString("nursing_unit_short_desc"));
			nursingunitcode					= checkForNull(rset.getString("nursing_unit_code"));
			service_short_desc			= checkForNull(rset.getString("service_short_desc"));
			bed_no								= checkForNull(rset.getString("bed_no"));
			room_no							= checkForNull(rset.getString("room_no"));
			bed_class_short_desc		= checkForNull(rset.getString("bed_class_short_desc"));
			patient_id							= checkForNull(rset.getString("patient_id"));
			bed_type_code				= checkForNull(rset.getString("bed_type_code"));
			bed_type_short_desc		= checkForNull(rset.getString("bed_type_short_desc"));
			bed_class_code				= checkForNull(rset.getString("bed_class_code"));
			practitioner_id					= checkForNull(rset.getString("practitioner_id"));
			specialty_code					= checkForNull(rset.getString("specialty_code"));
			nursing_unit_code				= checkForNull(rset.getString("nursing_unit_code"));
			service_code					= checkForNull(rset.getString("service_code"));
			//patient_type			= checkForNull(rset.getString("patient_type"));
			patient_type						= checkForNull(rset.getString("patient_class"));
			gender								= checkForNull(rset.getString("gender"));  
			medteamdesc					= checkForNull(rset.getString("team_desc"));
			from_hcare_setting_type_code=checkForNull(rset.getString("hcare_setting_type_code"));
			system_date_time	= checkForNull(rset.getString("system_date_time"));			
			system_date			= checkForNull(rset.getString("system_date"));
			 //this line Added for this CRF [Bru-HIMS-CRF-354]
			pract_bedside_referral=checkForNull(rset.getString("dflt_pract_bedside_referral")); 
			loginpractitioner=checkForNull(rset.getString("loginPractitioner")); 
			functionroleid=checkForNull(rset.getString("func_role_id")); 
		}
			
		adm_date_display			= DateUtils.convertDate(admission_date_time,"DMYHM","en",locale);	   
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
		java.util.Date dt=new java.util.Date();
		String d = dateFormat.format( dt ) ;
		String curdateWithoutTime = d;
		d=d + " "+String.valueOf(dt.getHours())+":"+String.valueOf(dt.getMinutes());
		String curdate = d;

		if(rset!=null)  rset.close();
		if(stmt!=null)  stmt.close();
%>
<!-- IN035060 starts -->
	<script language='javascript'>
	function disableCloseBtn()
		{
		var calledfrom = '<%=called_from%>';
		var callerid ='<%=caller_ID%>'; /*this line added and below condtion modified for this SCF SKR-SCF-0818 [IN:041017]*/
		if (calledfrom == 'CA' && callerid=='ReferralPatientDetails')
			{ 
			document.getElementById("closebtn").disabled = true;
			}
		else
			{
			document.getElementById("closebtn").disabled = false;
			}
		}	
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<!-- IN035060 ends -->
<!-- IN035060 starts -->
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="disableCloseBtn()">
<!-- IN035060 ends -->
	<form name='RefPatientDtls_form' id='RefPatientDtls_form'  method="post" action="../../servlet/eMP.RegisterReferralsServlet" target="Dummy_frame">
        <table cellpadding=3 cellspacing=0 width="100%" border='0'>
            <tr><th class='columnheader' align="left" colspan='4'><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></th></tr>
			<tr>
				<td colspan=4 class=label height=5></td>
			</tr>          
            <tr>
				<!-- Modified by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978 -->
			    <% if(isBedSideReferralApplforAE && patient_class.equals("EM")){ %>
					<td width="25%" class=label ><fmt:message key="eAE.Visit.label" bundle="${ae_labels}"/>&nbsp;<fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></td>
				<%}else{%>
					<td width="25%" class=label ><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></td>
				<%}%> 
                
                <td width="25%" class='querydata'><%=adm_date_display%><input type="hidden"  name="admission_date_time" id="admission_date_time" value="<%=admission_date_time%>"></td>

				<!-- Modified by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978 -->
				<% if(isBedSideReferralApplforAE && patient_class.equals("EM")){ %>
					<td width="25%" class=label ><fmt:message key="eAE.Visit.label" bundle="${ae_labels}"/>/<fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
				<%}else{%>
					<td width="25%" class=label ><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
				<%}%>
                
                <td width="25%" class='querydata'><%=admission_short_desc%><input type="hidden"  name="admission_short_desc" id="admission_short_desc" value="<%=admission_short_desc%>"></td>
            </tr>
			<tr>
				<td colspan=4 class=label height=5></td>
			</tr>          
            <tr>
                <td class=label ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
                <td  class='querydata'><%=specialty_short_desc%><input type="hidden"  name="specialty_short_desc" id="specialty_short_desc" value="<%=specialty_short_desc%>"></td>
                <td class=label ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
                <td  class='querydata'><%=practitioner_name%><input type="hidden"  name="practitioner_short_name" id="practitioner_short_name" value="<%=practitioner_name%>"></td>
            </tr>
			<tr>
				<td colspan=4 class=label height=5></td>
			</tr>          
            <tr>
                <td class=label ><fmt:message key="Common.patienttype.label" bundle="${common_labels}"/></td>
                <td  class='querydata'><%=patient_type_short_desc%><input type="hidden"  name="patient_type_short_desc" id="patient_type_short_desc" value="<%=patient_type_short_desc%>"></td>
				<td class=label ><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></td>
                <td  class='querydata'><%=medteamdesc%><input type="hidden"  name="medical_team" id="medical_team" value="<%=meddesc%>"></td>
            </tr>
			<tr>
				<td colspan=4 class=label height=5></td>
			</tr>          
            <tr>
			<!-- Modified by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978 -->
			<% if(isBedSideReferralApplforAE && patient_class.equals("EM")){ %>
				<td class='columnheader' colspan=4><fmt:message key="Common.LocationDetails.label" bundle="${common_labels}"/></td>
			<%}else{%>
				<th class='columnheader' align="left" colspan=4><fmt:message key="Common.NursingUnitDetails.label" bundle="${common_labels}"/></th>
			<%}%>
			</tr>
			<tr>
				<td colspan=4 class=label height=5></td>
			</tr>          
            <tr>
				<!-- Modified by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978 -->
				<% if(isBedSideReferralApplforAE && patient_class.equals("EM")){ %>
					<td class=label ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<%}else{%>
					<td class=label ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
				<%}%>
                
                <td  class='querydata'><%=nursing_unit_short_desc%><input type="hidden"  name="nursing_unit_short_desc" id="nursing_unit_short_desc" value="<%=nursing_unit_short_desc%>"><input type="hidden"  name="nursingunitcode" id="nursingunitcode" value="<%=nursingunitcode%>"></td>
                <td class=label ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
                <td  class='querydata'><%=service_short_desc%><input type="hidden"  name="service_short_desc" id="service_short_desc" value="<%=service_short_desc%>"></td>
            </tr>
			<tr>
				<td colspan=4 class=label height=5></td>
			</tr>          
            <tr>
                <td class=label ><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
                <td  class='querydata'><%=bed_no%><input type="hidden"  name="bed_no" id="bed_no" value="<%=bed_no%>"></td>

                <!-- Modified by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978 -->
				<% if(isBedSideReferralApplforAE){ %>
					<% if(!patient_class.equals("EM")){ %>
					<td class=label ><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
					<td  class='querydata'><%=room_no%><input type="hidden"  name="room_no" id="room_no" value="<%=room_no%>"></td>
					<%}%>
				<%}else{%>
					<td class=label ><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
					<td  class='querydata'><%=room_no%><input type="hidden"  name="room_no" id="room_no" value="<%=room_no%>"></td>
				<%}%> 
            </tr>
			<tr>
				<td colspan=4 class=label height=5></td>
			</tr>          
            <tr>
			    <!-- Modified by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978 -->
				<% if(isBedSideReferralApplforAE){ %>
					<% if(!patient_class.equals("EM")){ %>
					<td class=label ><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
					<td  class='querydata'><%=bed_class_short_desc%><input type="hidden"  name="bed_class_short_desc" id="bed_class_short_desc" value="<%=bed_class_short_desc%>"></td>
					<td class=label ><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
					<td  class='querydata'><%=bed_type_short_desc%><input type="hidden"  name="bed_type_short_desc" id="bed_type_short_desc" value="<%=bed_type_short_desc%>"></td>
					<%}%>
				<%}else{%>
					<td class=label ><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
					<td  class='querydata'><%=bed_class_short_desc%><input type="hidden"  name="bed_class_short_desc" id="bed_class_short_desc" value="<%=bed_class_short_desc%>"></td>
					<td class=label ><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
					<td  class='querydata'><%=bed_type_short_desc%><input type="hidden"  name="bed_type_short_desc" id="bed_type_short_desc" value="<%=bed_type_short_desc%>"></td>
				<%}%>
            </tr>
			<tr>
				<td colspan=4 class=label height=5></td>
			</tr>          
        </table>
                
		<%
			/// Added By Sridhar R.. This will inclue the referral Component || Bed side page based on the calling Function...
			if(caller_ID.equals("ReferralPatientDetails"))
			{	%>
					<table cellpadding=3 cellspacing=0 width="100%">
					<tr>
						<th class='columnheader' align="left" width='100%' colspan='4'><fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/></th>
					</tr>
					<tr>
						<td colspan=4 class=label width='25%' height=5></td>
					</tr>  <!--passing the practname and practid Below line modified for this CRF  Bru-HIMS-CRF-354-->
					<jsp:include page="../../eMP/jsp/ReferralDetailsComponent.jsp" ><jsp:param name="flush" value="true" /> 
						<jsp:param name ="Module" value= "IP" /> 	
						<jsp:param name ="ReasonForRef" value= "N" /> 	
						<jsp:param name ="Option" value= "N" /> 	
						<jsp:param name ="bodyFrame" value= "parent.frames[1]" /> 	
						<jsp:param name ="submitFrame" value= "parent.frames[2]" /> 	
						<jsp:param name ="function_id" value= "RegisterInpatientReferral" /> 
						<jsp:param name ="called_from" value= "<%=called_from%>" /> 
						<jsp:param name ="functionid" value= "<%=function_id%>" /> 
						<jsp:param name ="system_date_time" value= "<%=system_date_time%>" /> 
						<jsp:param name ="system_date" value= "<%=system_date%>" /> 
						<jsp:param name ="frm_practitioner_name" value= "<%=practitioner_name%>" /> 
						<jsp:param name ="frm_practitioner_id" value= "<%=practitioner_id%>" />
						<jsp:param name ="calling_module" value= "IP" /> 						
					</jsp:include>
				</table>
	<%		}else if(caller_ID.equals("BedSideReferral"))
			{ %>
			 <table cellpadding=3 cellspacing=0 width='100%' >
				<tr><th class='columnheader' align="left" colspan='4'><fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/></th></tr>
				<tr><td colspan=4 class=label width='25%' height=5></td></tr> 
				<tr>
					<!-- Referral ID -->
					<td  class=label width='25%'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td>
					<td  class=data width='25%'><B><%=referral_id%></B></td>
					<td class=label  width='25%'></td>
					<td class=label  width='25%'></td>
				</tr>

				<tr>
				<td colspan="4" class=label ></td>
				</tr>	<!--passing the practname and practid and Below line modified for this CRF  Bru-HIMS-CRF-354-->	
                        <!--passing parameter callfrom to confirm bedside referral function ML-MMOH-CRF-0566-->				

				<jsp:include page="../../eIP/jsp/ConfirmBedSideReferralDetail.jsp"> 
					<jsp:param name ="encounterid" value= "<%=encounterid%>" /> 
					<jsp:param name ="referral_id" value= "<%=referral_id%>" /> 
					<jsp:param name ="frm_practitioner_name" value= "<%=practitioner_name%>" /> 
					<jsp:param name ="frm_practitioner_id" value= "<%=practitioner_id%>" />	
                    <jsp:param name ="callfrom" value= "<%=callfrom%>" /> 
                    <jsp:param name ="bodyFrame" value= "parent.frames[1]"/>
                    <jsp:param name ="submitFrame" value= "parent.frames[2]"/>    					
				</jsp:include>
				</table>
		<%	}	%>

	<table cellpadding=3 cellspacing=0 width="100%" border=0 >
		<tr>
			<td class=label colspan='4' width="25%"></td>
			<td class=label colspan='4' width="25%"></td>
			<td class=label colspan='4' width="25%"></td>
			<td class=fields colspan='4' width="25%"><input type="button" class="button" name= "Apply" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>" onclick="submitForm()"><input type="button" id='closebtn' class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="const dialogTag = parent.parent.document.getElementById('dialog_tag');dialogTag.close();"></td>
 		</tr>
		<tr><td colspan=4 class=label ></td></tr>
	</table>

        <input type="hidden" name="func_id" id="func_id"		value="<%=function_id%>">
        <input type="hidden" name="patient_id" id="patient_id"		value="<%=patient_id%>">
        <input type="hidden" name="encounter_id" id="encounter_id"	value="<%=encounterid%>">
        <input type="hidden" name="bed_type_code" id="bed_type_code"	value="<%=bed_type_code%>">
        <input type="hidden" name="bed_class_code" id="bed_class_code"	value="<%=bed_class_code%>">
        <input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">
        <input type="hidden" name="specialty_code" id="specialty_code"	value="<%=specialty_code%>">
        <input type="hidden" name="nursing_unit_code" id="nursing_unit_code" value="<%=nursing_unit_code%>">
        <input type="hidden" name="patient_type_code" id="patient_type_code" value="<%=patient_type%>">
        <input type="hidden" name="service_code" id="service_code" value="<%=service_code%>">
        <input type="hidden" name="gender" id="gender" value="<%=gender%>">
        <input type="hidden" name="dischargeafterhrs" id="dischargeafterhrs" value="<%=discharge_after_hrs%>">
        <input type="hidden" name="sysdatetime" id="sysdatetime" value="<%=curdate%>">
        <input type="hidden" name="curdateWithoutTime" id="curdateWithoutTime" value="<%=curdateWithoutTime%>">
        <input type="hidden" name="open_to_all_pract_yn" id="open_to_all_pract_yn" value="">
        <input type="hidden" name="location1_desc" id="location1_desc"  value ="" >
        <input type="hidden" name="from_hcare_setting_type_code" id="from_hcare_setting_type_code" value="<%=from_hcare_setting_type_code%>" >  
        <input type="hidden" name="disdatechkdays" id="disdatechkdays" value="<%=dis_date_chk_days%>">  
        <input type="hidden" name="medicalteam" id="medicalteam" value="<%=medteamdesc%>">
		<input type="hidden" name="location_val" id="location_val" value="" >
		<input type="hidden" name="hcare_setting_type_desc" id="hcare_setting_type_desc"  value ='' >
		<input type="hidden" name="call_function" id="call_function"  value ="<%=caller_ID%>" >
		<input type="hidden" name="facilityId" id="facilityId"  value ="<%=facilityId%>" >
		<input type="hidden" name="referral_id" id="referral_id"  value ="<%=referral_id%>" >
		<input type="hidden" name="from_speciality_code" id="from_speciality_code"  value ="<%=specialty_code%>" >
		<input type = 'hidden' name='from_service_code' id='from_service_code' value="<%=service_code%>" >
		<input type = 'hidden' name='invokedModule' id='invokedModule' value="<%=called_from%>" >
		<input type = 'hidden' name='patient_class' id='patient_class' value="<%=patient_class%>" >
		
		<!--Below line Added for this CRF Bru-HIMS-CRF-354 -->
		<input type = 'hidden' name='from_practitioner_name' id='from_practitioner_name' value="<%=practitioner_name%>" >
		<input type = 'hidden' name='pract_bedside_referral' id='pract_bedside_referral' value="<%=pract_bedside_referral%>" >
		<input type = 'hidden' name='loginpractitioner' id='loginpractitioner' value="<%=loginpractitioner%>" >
		<input type = 'hidden' name='globaluser' id='globaluser' value="<%=globaluser%>" >
		<input type = 'hidden' name='functionroleid' id='functionroleid' value="<%=functionroleid%>" >
		<!--End Bru-HIMS-CRF-354 -->
		<!--Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->
		<input type='hidden' name='CA_REF_LETTER_NOTES_REC_YN' id='CA_REF_LETTER_NOTES_REC_YN' value="N">

		<script>if(document.forms[0].referral_type)document.forms[0].referral_type.focus();</script>
	</form>
</body>

<%
			if(rset!=null)  rset.close();
			if(rs3!=null)  rs3.close();
			if(stmt!=null)  stmt.close();
			if(pstmt1 != null)	pstmt1.close();
		}catch(Exception e)
		{
           // out.print("Exception "+e);
		   e.printStackTrace();
        }   
        finally   
        {
			ConnectionManager.returnConnection(con,request);
        }
%>
</html>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

