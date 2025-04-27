<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,com.ehis.util.*, eCommon.XSSRequestWrapper, eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eMP/jsp/PatientAddressLegends.jsp" %>
<%!	String rec_diag_from_admit_pat_yn="";%>


<%	
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facility_id  = (String)session.getValue("facility_id");
	String sStyle		= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale		= (String)session.getAttribute("LOCALE");
%>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../js/AdmitPatient.js' language='javascript'></script>
	<script src='../js/AdmitPatient1.js' language='javascript'></script>
	<script src='../js/AdmitPatient2.js' language='javascript'></script>
	<script src='../js/IPPractitionerComponent.js' language='javascript'></script>
	<!--Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779-->
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 	
	<script>
		function disableForm()
		{
/*
			for(var i=0; i<document.forms[0].elements.length; i++)
				document.forms[0].elements[i].disabled = true;
*/
		}
	</script>

	<!--Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779-->
	<style>
	.inner_table_site { 
		width:1020px;  
		height:380px;
		overflow-y:auto;	
	} 	
	</style>
	<!--End ML-MMOH-CRF-0779-->

</head>
<%

	
	Connection con			= null;
	Statement stmt			= null;
	PreparedStatement pstmt = null;
	Statement ipBlIntfStmt	= null;
	ResultSet ipBlIntfrs	= null; 
	ResultSet rs			= null; 
	ResultSet rset			= null;
	Statement chkinstmt     = null;
	ResultSet chkinrs       = null;
	Statement nbstmt		= null;
	ResultSet nbrs			= null;
	String ServiceDesc		= "";
	String ancillaryyn      = "";
	String bedclasscode     = "";
	String bedno			= "";
	String dlycharge        = "";
	String nursingunitcode  = "";
	String nursingunitdesc	= "";
	String roomno			= "";
	String servicedesc      = "";
	String splty_code		= "";
	String splty_desc		= "";
	String systemDate		= "";
	String systemDate_converted		= "";
	//String bed_assigned_for_nb_yn	= "N";
	String reason_reqd_Flag	= "N";
	
	//Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779
	String tab_width="100%";

	reason_reqd_Flag	= checkForNull(request.getParameter("reason_reqd_Flag"));	// modified for MMS-QH-CRF-0144
	String backdated_admission_yn	= checkForNull(request.getParameter("backdated_admission_yn"));	
	String nurs_unt_auth_val		= checkForNull(request.getParameter("nurs_unt_auth_val"));	
	String deactivate_pseudo_bed_yn	= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"));	
	String back_date				= checkForNull((String)request.getParameter("back_date"));
	String adm_date_chk_days		= checkForNull((String)request.getParameter("adm_date_chk_days"));// Added for PE By Sudhakar
	String adm_date_chk_days_type	= checkForNull((String)request.getParameter("adm_date_chk_days_type"));// Added for PE By Sudhakar
	String bl_interfaced_yn			= checkForNull(request.getParameter("bl_interfaced_yn"));	
	String bkg_grace_period			= checkForNull(request.getParameter("bkg_grace_period"));	
	String pat_check_in_allowed_yn	= checkForNull(request.getParameter("pat_checkin_yn"));	
	String callfunc					= checkForNull(request.getParameter("P_call_func"));
	String returnvalue				= checkForNull(request.getParameter("P_retval"));
	returnvalue						= returnvalue.replace('|','&');
	//String patientid				= checkForNull(request.getParameter("patient_id"));
	String p_oper_stn_id			= checkForNull(request.getParameter("oper_stn_id"));
	String loginUser				= (String)session.getValue("login_user");
	String bl_operational			= (String)session.getValue("bl_operational");
	StringTokenizer st				= new StringTokenizer(returnvalue,"^");
	StringBuffer sqlSb				= new StringBuffer();
        String bed_mandatory_for_admn_yn= checkForNull(request.getParameter("bed_mandatory_for_admn_yn"),"N");
	boolean assignBed_auth			= true;
	//below code added for ABM CRF 643.1 ICN:36736
	String from_adv_bed_mgmt		= checkForNull((String)request.getParameter("from_adv_bed_mgmt"),"N");
	String bedNo					= checkForNull((String)request.getParameter("bedNo"));
	String nursing_unit				= checkForNull((String)request.getParameter("nursing_unit"));
	String appl_patient_class		= checkForNull((String)request.getParameter("appl_patient_class"));
	
	//Below line added for this CRF GDOH-CRF-0129 	
	Boolean isReferral=false;
	
		/*Below line Added for this CRF  Bru-HIMS-CRF-261*/
	
	boolean isAlternateAddressAppl = false;//Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601

	boolean isAttendPractAppl = false; // added by mujafar against ML-MMOH-SCF-1316

	String quick_admission_type	= checkForNull((String)request.getParameter("quick_admission_type"));
	String quick_adm_referralid	= checkForNull((String)request.getParameter("quick_adm_referralid"));
	String quick_adm= checkForNull((String)request.getParameter("quick_adm"));
	String ref_encounter_id=checkForNull((String)request.getParameter("ref_encounter_id"));
	if (st.hasMoreTokens())
	{				
		nursingunitcode = st.nextToken();
		if (st.hasMoreTokens())
		{
			bedno			= checkForNull(st.nextToken());
			bedclasscode	= checkForNull(st.nextToken());
			roomno			= checkForNull(st.nextToken());
			servicedesc		= checkForNull(st.nextToken());
			ancillaryyn		= checkForNull(st.nextToken());
			dlycharge		= checkForNull(st.nextToken());
			nursingunitdesc = checkForNull(st.nextToken());
			splty_code		= checkForNull(st.nextToken());
			splty_desc		= checkForNull(st.nextToken());
		}
	}
	String f_nursing_unit = checkForNull((String)request.getParameter("f_nursing_unit"));
	if(!f_nursing_unit.equals("")) nursingunitdesc = f_nursing_unit;
	String str_bl_package_enabled_yn="N";
	try
	{
		con =ConnectionManager.getConnection(request);
		Boolean isForm60Available	= CommonBean.isSiteSpecific(con, "MP","REG_PAT_ALT_ID3_PAN_CARD"); //Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799]

		Boolean validationForPanCardAvail	= CommonBean.isSiteSpecific(con,"MP","GENERATE_FORM_60"); //Added by Sangeetha on  10/apr/17 for KDAH-CRF-0347

		Boolean restrictPseudoBed	= CommonBean.isSiteSpecific(con,"IP","RESTRICT_PSEUDO_BED"); //Added by Sangeetha on  23/05/17 for GDOH-CRF-0151

		Boolean isPsychiatryFormAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","PSYCHIATRY_FORM"); //Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779
		
		//Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779
		if(isPsychiatryFormAppl && quick_adm.equals("Quick_admission"))
		{
			tab_width="1020px";
		}

	   //Below line added for this GDOH-CRF-0129
       isReferral=CommonBean.isSiteSpecific(con, "IP","REGISTER_REFERRAL");

	   isAlternateAddressAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALTERNATE_ADDRESS_APPLICABLE");//Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601

	   isAttendPractAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP","ATTND_PRACT_FROM_REF_APPL_IP"); //Added by mujafar for ML-MMOH-SCF-1316

/**************Added for package billing **************starts***/	
	//Commented for PE By Sudhakar
	/*try{				
			PreparedStatement pstmt1=con.prepareStatement("select bl_package_enabled_yn('"+facility_id	+"') from dual");	
			ResultSet rs2 = pstmt1.executeQuery();	
			if( rs2 != null ) 
			{
				if( rs2.next() )
				{			
					str_bl_package_enabled_yn  =  rs2.getString(1);	
				}
			}
			if(str_bl_package_enabled_yn == null) str_bl_package_enabled_yn="N";			
			pstmt1.close();
			if(rs2!=null) rs2.close();			
			}catch(Exception e){
			}*/
/**************Added for package billing **************ends***/		
		/*if(!patientid.equals(""))
		{
			nbstmt = con.createStatement();
			nbrs = nbstmt.executeQuery(" select bed_assigned_for_nb_yn from MP_PATIENT where patient_id = '"+patientid+"'");
			
			if(nbrs!=null && nbrs.next())
				bed_assigned_for_nb_yn = checkForNull(nbrs.getString("bed_assigned_for_nb_yn"),"N");

			 if(nbrs!=null) nbrs.close();
			 if(nbstmt!=null) nbstmt.close();
		}*/

		if (!nursingunitcode.equals("") && from_adv_bed_mgmt.equals("N"))
		{
			//stmt = con.createStatement();
			//rs = stmt.executeQuery("Select AM_GET_DESC.AM_SERVICE(service_code,'"+locale+"','2') service_short_desc from IP_NURSING_UNIT where nursing_unit_code = '"+nursingunitcode+"' and facility_id = '"+facility_id+"'");
			pstmt = con.prepareStatement("Select AM_GET_DESC.AM_SERVICE(service_code,?,'2') service_short_desc from IP_NURSING_UNIT where nursing_unit_code =? and facility_id = ?");
			pstmt.setString(1, locale);
			pstmt.setString(2, nursingunitcode);
			pstmt.setString(3, facility_id);
			rs = pstmt.executeQuery();
			if (rs.next())
			{
				ServiceDesc = checkForNull(rs.getString("service_short_desc"));
				if(rs!=null) rs.close();
		   }
		}
		String bed_class_code="";
		String bed_class_desc="";
		String bed_type_code="";
		String bed_type_desc="";
		if (from_adv_bed_mgmt.equals("Y")){
			nursingunitcode=nursing_unit;
			bedno=bedNo;
			/*stmt = con.createStatement();
			rs = stmt.executeQuery("Select AM_GET_DESC.AM_SERVICE(service_code,'"+locale+"','2') service_short_desc from IP_NURSING_UNIT where nursing_unit_code = '"+nursingunitcode+"' and facility_id = '"+facility_id+"'");
			if (rs.next())
			{
				nursingunitdesc = checkForNull(rs.getString("service_short_desc"));
				if(rs!=null) rs.close();
		   }*/
		   
			/* stmt = con.createStatement(); */
			//rs = stmt.executeQuery("Select ip_get_desc.IP_NURSING_UNIT('"+facility_id+"','"+nursingunitcode+"','"+locale+"','2')nursing_unit_short_desc from dual");
			String sql="select ROOM_NO,BED_CLASS_CODE, ip_get_desc.IP_BED_CLASS(bed_class_code,?,'2') bed_class_short_desc,BED_TYPE_CODE,ip_get_desc.IP_BED_TYPE(bed_type_code,?,'2') bed_type_short_desc,ip_get_desc.IP_NURSING_UNIT(facility_id,NURSING_UNIT_CODE,?,'2')nursing_unit_short_desc,SPECIALTY_CODE,am_get_desc.AM_SPECIALITY(specialty_code,?,'2') specialty_short_desc from ip_nursing_unit_bed where bed_no=?";

/* 			rs = stmt.executeQuery(sql); */
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, locale);
			pstmt.setString(2, locale);
			pstmt.setString(3, locale);
			pstmt.setString(4, locale);
			pstmt.setString(5, bedNo);
			rs = pstmt.executeQuery();
			if (rs.next())
			{
				nursingunitdesc = checkForNull(rs.getString("nursing_unit_short_desc"));
				roomno=checkForNull(rs.getString("ROOM_NO"));
				bed_class_code=checkForNull(rs.getString("bed_class_code"));
				bed_class_desc=checkForNull(rs.getString("bed_class_short_desc"));
				bed_type_code=checkForNull(rs.getString("bed_type_code"));
				bed_type_desc=checkForNull(rs.getString("bed_type_short_desc"));
				splty_code=checkForNull(rs.getString("SPECIALTY_CODE"));
				splty_desc=checkForNull(rs.getString("specialty_short_desc"));
				if(rs!=null) rs.close();
		   }
		}
		if(rs != null) rs.close();
		//if(stmt != null) stmt.close();
		if(pstmt != null) pstmt.close();

		stmt = con.createStatement();		
		if(adm_date_chk_days_type.equals("H")){
			if(sqlSb.length() > 0) sqlSb.delete(0,sqlSb.length());
			sqlSb.append("Select to_char(sysdate,'dd/mm/rrrr hh24:mi')systemDate");
			if(bl_interfaced_yn.equals("Y"))
				sqlSb.append(",bl_package_enabled_yn(?)bl_package_enable_yn");
			sqlSb.append(",TO_CHAR(SYSDATE-?/24,'dd/mm/rrrr hh24:mi') setup_date from dual");
			pstmt = con.prepareStatement(sqlSb.toString());
			if(bl_interfaced_yn.equals("Y")){
				pstmt.setString(1, facility_id);
				pstmt.setString(2, adm_date_chk_days);
			}else{
				pstmt.setString(1, adm_date_chk_days);	
			}
			
			
			
			rs = pstmt.executeQuery();
			System.out.println("Check 3 if");
//			rs = stmt.executeQuery(sqlSb.toString());
		}else{
			if(sqlSb.length() > 0) sqlSb.delete(0,sqlSb.length());
			sqlSb.append("Select to_char(sysdate,'dd/mm/rrrr hh24:mi')systemDate");
			if(bl_interfaced_yn.equals("Y"))
				sqlSb.append(",bl_package_enabled_yn(?)bl_package_enable_yn");
			sqlSb.append(",TO_CHAR(SYSDATE-?,'dd/mm/rrrr hh24:mi') setup_date from dual");
			pstmt = con.prepareStatement(sqlSb.toString());
			if(bl_interfaced_yn.equals("Y")){
				pstmt.setString(1, facility_id);
				pstmt.setString(2, adm_date_chk_days);
			}else{
				pstmt.setString(1, adm_date_chk_days);
			}
			rs = pstmt.executeQuery();
			//rs = stmt.executeQuery(sqlSb.toString());
		}
		if (rs.next())
		{
			systemDate = checkForNull(rs.getString("systemDate"));
			if(bl_interfaced_yn.equals("Y"))
				str_bl_package_enabled_yn  =  checkForNull(rs.getString("bl_package_enable_yn"),"N");
			back_date  =  checkForNull(rs.getString("setup_date"));
			if(!(systemDate.equals("") || systemDate == null))
				systemDate_converted = DateUtils.convertDate(systemDate,"DMYHM","en",locale); 
		}
		if (servicedesc.equalsIgnoreCase(""))servicedesc = ServiceDesc;
		boolean isBlInterfaced = false;
		if(bl_interfaced_yn.equals("Y"))
			isBlInterfaced = true;
		else 
			isBlInterfaced = false;

		String admissiondate = "";
		if(nurs_unt_auth_val == null || nurs_unt_auth_val.equals("N"))
			assignBed_auth = false;
		if(backdated_admission_yn.equals("N") || backdated_admission_yn==null)
			admissiondate = "readOnly";
		else
			admissiondate = "";
			
		/*Added Below Line code for [AK-SCF-0153] by Senthil */
			String language_direction="";
			if(rs != null) rs.close();
		   // if(stmt != null) stmt.close();
		    if(pstmt != null) pstmt.close();
			int count=0;
			//stmt=con.createStatement() ;
			pstmt=con.prepareStatement("select count(*) as total from sm_language where language_direction='R' and eff_status='E' and LANGUAGE_ID=?");
			//preparedStatement pstmt1 = con.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;
			pstmt.setString(1, locale);
			
		   rs = pstmt.executeQuery() ;
		   /* rs = stmt.executeQuery("select count(*) as total from sm_language where language_direction='R' and eff_status='E' and LANGUAGE_ID='"+locale+"'" ) ; */
				 
			 if ( rs != null && rs.next() ) 
			 {
			 count = rs.getInt("total");
			 }

			if ( count==1 ) 
			{
				 language_direction = "RTL" ;
			}else
			{
				 language_direction = "LTR" ;
			}
			
			if(rs!=null)rs.close();
			/*Added Above Line code for [AK-SCF-0153] by Senthil */	
			
			
			
			
			
			
	%>
        <body onLoad="callLoad();disableForm();" onKeyDown= 'lockKey()' onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
        <form name='AdmitPatient_form' id='AdmitPatient_form'  method="post" action="../../servlet/eIP.AdmitPatientServlet" target="messageFrame" >
		<input type='hidden' name='help_function_id' id='help_function_id' value='ADMIT_PAT'>
		<input type='hidden' name='modified_bed_type' id='modified_bed_type' value=''>
		<input type='hidden' name='bedtypecode' id='bedtypecode' value = ''>
		<input type='hidden' name='r_bed_no' id='r_bed_no' value=''>
		<input type='hidden' name='booking_bed_no' id='booking_bed_no' value=''><!--Added  for PMG2016-CRF-0002 IN061508�on 23rd Aug 16-->
        <!-- For Admission Tab -->
		<input type='hidden' name='temp_bed_class' id='temp_bed_class' value=''>
	<%	if(bl_operational.equals("Y"))	
		{	%>
			<a name='tab1' id='tab1'></a>
			<ul id="tablist" class="tablist" style="padding-left: 2px;">
				<li class="tablistitem" title="Admission Details">
					<a onclick="tab_click('admission_tab')" class="tabClicked" id="admission_tab" >
						<span class="tabSpanclicked" id=""><fmt:message key="Common.admission.label" bundle="${common_labels}"/></span>
					</a>
				</li>
				<li class="tablistitem" title="Financial Details">
					<a onclick="tab_click('findtl_tab')" class="tabA" id="findtl_tab" >
						<span class="tabAspan" id=""><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></span>
					</a>
				</li>
			</ul>
	<%	}	%>
	 <table id='reftab' border='0' cellspacing='0' cellpadding='2' width='100%'  height="5%">
		 <tr>
			<td nowrap class="COLUMNHEADER" colspan=4 id="refheading" ><fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/></td>
		 </tr>
		 <tr>
			<td nowrap id='refdetails' style='position:relative;' class="label"></td>
		 </tr> 
	 </table>
	 <script>
		document.getElementById('refheading').style.visibility='hidden';
		document.getElementById('refdetails').style.visibility='hidden';
		document.getElementById('reftab').deleteRow(0);
		document.getElementById('reftab').deleteRow(0);
	 </script>

	 <!--Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779-->
	 <%if(isPsychiatryFormAppl && quick_adm.equals("Quick_admission")){%>
	 <div class="inner_table_site">
	 <%}%>
	 <table border="0" width='<%=tab_width%>' cellspacing='0' cellpadding='2'>
		 <td nowrap class="COLUMNHEADER" colspan=4 ><fmt:message key="Common.NursingUnitDetails.label" bundle="${common_labels}"/></td>
			<tr> 
				<td  class="label" width="25%" ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				<td  class="fields" width="25%"><input type='text' size='15' maxLength='15' name='SplDesc' id='SplDesc'  value="<%=splty_desc%>" onblur='BeforegetSpecialty("<%=facility_id%>"); <%if(isPsychiatryFormAppl){%>psychiatryForms();<%}%>' disabled><input type='button' class='BUTTON' name='specialty_search' id='specialty_search' value='?' onClick="if(document.forms[0].SplDesc.value == '') getSpecialty('<%=facility_id%>'); <%if(isPsychiatryFormAppl){%>psychiatryForms();<%}%>" disabled><img src="../../eCommon/images/mandatory.gif">
				<input type='hidden' name='Splcode' id='Splcode' value="<%=splty_code%>"><input type='hidden' name='SplDesc_hid' id='SplDesc_hid' value="<%=splty_desc%>"></td>
				<td  width="25%" class="label"  ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
				<td  class="fields" width="25%"><input type='text' name="nursing_unit_desc" id="nursing_unit_desc" maxlength=15 size=15  value="<%=nursingunitdesc%>" onblur="if(this.value==''){document.forms[0].nursing_unit.value='';};BeforeNursingUnitLookup('<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>');CheckNursingUnit();"  disabled ><input type='button' class='BUTTON' name="nursing_unit_lookup" id="nursing_unit_lookup" value='?' onClick="if(document.forms[0].nursing_unit_desc.value == '') NursingUnitLookup('<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>');" disabled><input type=hidden name="nursing_unit" id="nursing_unit" value='<%=nursingunitcode%>'><img src="../../eCommon/images/mandatory.gif"><input type='hidden' name="nurs_unit_desc_hid" id="nurs_unit_desc_hid" value='<%=nursingunitdesc%>'><input type="hidden" name="ServiceFocus" id="ServiceFocus" value="N"></td>
			</tr>
			<tr>
				<td nowrap class="label"><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
			<%	if(bl_operational.equals("Y"))
				{	%>
					<td nowrap class="fields"><select name="service" id="service" onChange='onServiceChange()'onmousewheel='return false;'><option value="" >--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</select><img src='../../eCommon/images/mandatory.gif'></td>
			<%	}
				else
				{	%>		
					<td nowrap class="fields"><select name="service" id="service"  onChange='onServiceChange()' onmousewheel='return false;'><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</select><img src='../../eCommon/images/mandatory.gif'></td>
			<%	}	%>

				<td nowrap class="label"  ><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
				<td nowrap class="fields"><select name="sub_service" id="sub_service"  ><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</select></td>
			</tr>   
			<tr>
			<!--Below line modified for this linked incident [23474] -->
<!--added onChange="onPkgEli(this) for package billing for bed class change-->
				<td nowrap class="label" ><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
				<td nowrap class="fields">
				<select name='Bedcode' id='Bedcode' onChange='onBedClassChange(this)' onmousewheel='return false;' dir='<%=language_direction%>'>
					<%if(from_adv_bed_mgmt.equals("Y")){%>
						<option value="<%=bed_class_code%>"><%=bed_class_desc%></option>
					<%}else{%>
					<option value="" selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<%}%>					
				</select><img  src='../../eCommon/images/mandatory.gif'> </td>
				<td nowrap class="label" ><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
				<td nowrap class="fields">
				<select name="bed_type" id="bed_type"  onChange="onPkgEli(this,'<%=str_bl_package_enabled_yn%>')">
					<%if(from_adv_bed_mgmt.equals("Y")){%>
						<option value="<%=bed_type_code%>"><%=bed_type_desc%></option>
					<%}else{%>
					<option value="" selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<%}%>
				</select><img src='../../eCommon/images/mandatory.gif'></td>
			</tr>     
			<tr>
				<td nowrap class="label" ><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
        <%  // If assign bed authorization is there it will accept the bed no else it will be disabled
			// Modified by Sangeetha on  23/05/17 for GDOH-CRF-0151
			if(assignBed_auth || from_adv_bed_mgmt.equals("Y"))
			{	%>
				<td nowrap class="fields"><input type="text" name="bed_no" id="bed_no" value="<%=bedno%>" size='8' maxlength='8' onblur="chkbedno() <% if(restrictPseudoBed){ %>;chkforVacantNormalBed()<% }%>" readOnly><input type="button" class="button" name='bed_avail_chart' id='bed_avail_chart' value="?" onclick="callModal('BED_AVAIL')" <% if(restrictPseudoBed){ %>onblur="chkforVacantNormalBed()" <% }%> disabled><img <%if(bed_mandatory_for_admn_yn.equals("Y")){%>style='visibility:visible'<%}else{%> style='visibility:hidden'<%}%> id='bed_mnd' src="../../eCommon/images/mandatory.gif" /></td>
		<%	}
			else
			{	// Modified by Sangeetha on  23/05/17 for GDOH-CRF-0151 %>
				<td nowrap class="fields"><input type="text" name="bed_no" id="bed_no" value="" size='8' maxlength='8' onChange="return validateFields(this)" <% if(restrictPseudoBed){ %>onblur="chkforVacantNormalBed()" <% }%> readOnly><input type="button" class="button" name='bed_avail_chart' id='bed_avail_chart' value="?" onclick="callModal('BED_AVAIL')" <% if(restrictPseudoBed){ %>onblur="chkforVacantNormalBed()" <% }%> disabled><img <%if(bed_mandatory_for_admn_yn.equals("Y")){%>style='visibility:visible'<%}else{%> style='visibility:hidden'<%}%> id='bed_mnd' src="../../eCommon/images/mandatory.gif" /></td>
		<%	}	%>

				<input type="hidden" name="hdd_bed_no" id="hdd_bed_no" value="">
				<td nowrap class="label"  ><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
		<%	if(assignBed_auth || from_adv_bed_mgmt.equals("Y"))
			{	%>
				<td nowrap class="fields"><input type="text" name="room_no" id="room_no" value="<%=roomno%>" size=10 maxlength=10  readonly onBlur="setTabFocus('F',this)" onKeyPress='return CheckForSpecChars(event)' >          
		<%	}
			else
			{	%>
				<td nowrap class="fields"><input type="text" name="room_no" id="room_no" value="<%=roomno%>" size=8 maxlength=4  readonly onBlur="setTabFocus('F',this)" onKeyPress='return CheckForSpecChars(event)'  disabled>
		<%	}	%>
	<%      if(bl_operational.equals("Y")) 
			{
				out.println("</tr>");
				%>         
				<input type="hidden" name="addDepReq" id="addDepReq" value="N"  >
				<input type="hidden" name="dly_charge" id="dly_charge" value="<%=dlycharge%>">
				<input type="hidden" name="dep_amt" id="dep_amt" value="<%=dlycharge%>">
		<%	}	%>
		<tr>	
			<td nowrap class="COLUMNHEADER" colspan=4 ><fmt:message key="Common.encounter.label" bundle="${common_labels}"/></td>              
		</tr> 
		<tr>
		<!--modified for GHL-CRF-0020  added Allfunc() ;-->
		<td nowrap class="label"  ><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></td>
			<!-- In below line CheckNumVal(exp_days_stay_id) method added on "Admissiondate" field's onBlur event modified by Venkatesh.S (em_id-4008) on 29/Sep/2011 for the incident GHL-SCF-453 [IN028804]-->

		<td nowrap class="fields"><input type="text" id= "Admissiondate" name="visit_adm_date_time" id="visit_adm_date_time" value="<%=systemDate_converted%>"  size=15 maxlength=16   onBlur=" <%if(bl_operational.equals("Y"))	
		{%> Allfunc(); <%}%> validateDate(this,'A');CheckNumVal(exp_days_stay_id);setDate(this,'<%=systemDate_converted%>');validatePatient(this,'<%=locale%>');"  <%=admissiondate%>><img name='AdmitDate' src='../../eCommon/images/CommonCalendar.gif' id='AdmissiondateImg'  onClick="document.forms[0].visit_adm_date_time.focus();return showCalendar('Admissiondate',null,'hh:mm');" disabled />

			</td>
			<td nowrap class="label"  ><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
			<td nowrap class="fields"><select name="visit_adm_type" id="visit_adm_type"  onChange="return validateFields(this)"  ><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</select><img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr>
			<td nowrap class='label'  ><fmt:message key="Common.ambulatorystatus.label" bundle="${common_labels}"/></td>
			<td nowrap class="fields"><select name="ambulatory_status" id="ambulatory_status" ><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</select></td>
			<td nowrap class="label"  ><fmt:message key="eIP.ExpdaysofStay.label" bundle="${ip_labels}"/></td>
			<td nowrap class="fields"><input type='text' id='exp_days_stay_id' name='exp_days_stay' id='exp_days_stay' size='3' maxlength='3' value="" onKeyPress='return CheckForSpecChars(event)'  onBlur='CheckNumVal(this);' ></td>
		</tr>
		<tr>
			<td nowrap class="label"  ><fmt:message key="eIP.ExpectesDischargeDate.label" bundle="${ip_labels}"/></td>
			<!--Below line is commented by Akhilesh because unnecessary function used-->
			<!--<td nowrap class="fields" ><input type='text' id = "expdisdate" name='expecteddischargedate' id='expecteddischargedate' size=15 maxlength='16' value='' onBlur='doChkDisDateTime(this);validateExpDate(this);' readOnly>-->
			<td nowrap class="fields" ><input type='text' id = "expdisdate" name='expecteddischargedate' id='expecteddischargedate' size=15 maxlength='16' value='' onBlur='validateExpDate(this);' readOnly>
			<td nowrap class="label"   nowrap><fmt:message key="eIP.ProcedureSurgeryDateTime.label" bundle="${ip_labels}"/></td>
			<td nowrap class="fields"><input type="text" id ="otdatetime" name="ot_date_time" id="ot_date_time" size=16 maxlength=16  onBlur="doOTDateTimeChk(this)" value ="" ><img src='../../eCommon/images/CommonCalendar.gif' id='OTDate'  name='OTDate' onClick="document.forms[0].ot_date_time.select();return showCalendar('otdatetime',null,'hh:mm');" disabled />
		</tr>   
		<tr>
			<td nowrap class="label" ><fmt:message key="eIP.AdmittingPractitioner.label" bundle="${ip_labels}"/></td>
			<td nowrap class="fields" nowrap ><input type='text' name='practid_desc' id='practid_desc' value="" size='15' maxlength='30'  onblur="if(this.value==''){document.forms[0].practid.value='';document.forms[0].practid_desc_hid.value=''};BeforeGetPractID1(document.forms[0].pract_id_search,practid_desc);" disabled><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="if(document.forms[0].practid_desc.value == '') getPractID(this,practid_desc);"  disabled><img src="../../eCommon/images/mandatory.gif"><input type='hidden' name='practid' id='practid' value="" size='15' maxlength='15'  ><input type='hidden' name='practid_desc_hid' id='practid_desc_hid' value="" ></td>
			<td nowrap class="label" ><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td>
			<td nowrap class="fields" ><input type='text' name='att_practid_desc' id='att_practid_desc' value="" size='15' maxlength='30'  onblur="if(this.value==''){document.forms[0].att_practid.value=''};BeforeGetPractID2(document.forms[0].att_pract_id_search,att_practid_desc);"  disabled><input type='button' name='att_pract_id_search' id='att_pract_id_search' value='?' class='button' onClick="if(document.forms[0].att_practid_desc.value == '')getPractID(this,att_practid_desc);"  disabled><img style='visibility:hidden' id='attend_img' src="../../eCommon/images/mandatory.gif"><input type='hidden' name='att_practid' id='att_practid' value="" size='15' maxlength='15'><input type='hidden' name='att_practid_desc_hid' id='att_practid_desc_hid' value="" ><input type='hidden' name='pat_check_in_allowed_yn' id='pat_check_in_allowed_yn' value='<%=pat_check_in_allowed_yn%>'><input type='hidden' name='d_referral_id' id='d_referral_id' value=''><input type='hidden' name='d_clinic_code' id='d_clinic_code' value=''></td>
		</tr>           
		<tr>
			<td nowrap class="label" ><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></td>
			<td nowrap class="fields"><select name="team_id" id="team_id" ><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</select></td>
			 <!--Below line modified for this CRF GDOH-CRF-0129-->
			 <%if(isReferral){%>
			 <td nowrap class="label"><fmt:message key="Common.Referralfrom.label" bundle="${common_labels}"/>			
			</td>
			<!-- Modified for MMS-QH-CRF-0144 - forming ReasonforAdmission field as mandatory based on IPParameter-->
			<td nowrap class="fields"><span name="chief_complaint_txt" id="chief_complaint_txt"><input type="text" name='chief_complaint' id='chief_complaint' size="30" maxLength="200" onblur="BeforeReasonLookup();" onChange="refresherrmsg();" ><input type=button name='chfcomp_lookup' id='chfcomp_lookup' value='?' class=button onClick="if(document.forms[0].chief_complaint.value == '') ReasonLookup();refresherrmsg();"><input type=hidden name='complaintcode' id='complaintcode' ><input type=hidden name='chief_complaint_hid' id='chief_complaint_hid' >
			<!--Below line Modified for this CRF GDOH-CRF-0129-->
			<% if("Y".equals(reason_reqd_Flag)) {%>
				<img src="../../eCommon/images/mandatory.gif" id='reason_reqd'>
			<%}%>			
			</span>
			<span name="assigncare_location_txt" id="assigncare_location_txt" style="visibility:hidden;font-size:11px"><input type="text" name="assigncare_location_desc" id="assigncare_location_desc" maxlength="40" size="25" value="" > </span>
			</td>
			<input type=hidden name='reason_reqd_Flag' id='reason_reqd_Flag' value='<%=reason_reqd_Flag%>'>			 
			 <%}
			 else{%>
			<td nowrap class="label"><fmt:message key="Common.ReasonforAdmission.label" bundle="${common_labels}"/>			
			</td>
			<!-- Modified for MMS-QH-CRF-0144 - forming ReasonforAdmission field as mandatory based on IPParameter-->
			<td nowrap class="fields"><input type="text" name='chief_complaint' id='chief_complaint' size="30" maxLength="200" onblur="BeforeReasonLookup();" onChange="refresherrmsg();" ><input type=button name='chfcomp_lookup' id='chfcomp_lookup' value='?' class=button onClick="if(document.forms[0].chief_complaint.value == '') ReasonLookup();refresherrmsg();"><input type=hidden name='complaintcode' id='complaintcode' ><input type=hidden name='chief_complaint_hid' id='chief_complaint_hid' >
			<!--Below line Modified for this CRF GDOH-CRF-0129-->
			<% if("Y".equals(reason_reqd_Flag)) {%>
				<img src="../../eCommon/images/mandatory.gif" id='reason_reqd'>
			<%}%>			
			</td>
			<input type=hidden name='reason_reqd_Flag' id='reason_reqd_Flag' value='<%=reason_reqd_Flag%>'>
			<%}%>			
			
		</tr>
		<!---->
		<tr>
			<td nowrap class="label" ><fmt:message key="Common.admission.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td nowrap class="fields"><textarea name="admission_remarks" rows="2"  maxlength='250'   onBlur="makeValidString(this);" onKeyPress="/*return CheckForSpecChars_Remarks(event);*/" onkeyup="return imposeMaxLength(this);" style="resize:none;"></textarea></td>

			<!--Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779-->
			<%if(!isPsychiatryFormAppl){%>
			<td nowrap class="fields"></td>
			<%}else{%>
			<td nowrap class='label'><fmt:message key="eIP.PsychiatryForm.label" bundle="${ip_labels}"/></td>
			<td>
				<div id="PsychiatryForm" style="visibility:visible;overflow:auto;height:97px;width:220;border:1px outset white" align="left" >
				<table border='0' cellpadding='2' cellspacing='0' width='75%' align='left' id="PF_display">
				</table>
				</div>
			</td>
			<%}%>
			<!--End ML-MMOH-CRF-0779-->

		</tr>
		<!---->
		<!--Added by Kamatchi S for ML-MMOH-CRF-1609-->
		<tr>
			<td class='label' width='18%'>      
				<fmt:message key="Common.outstandingamount.label" bundle="${common_labels}"/>&nbsp;
			</td> 
			<td class="label" id="out_amt" style="font-weight:bold"  >
			</td>
			<!--Below added by Suji Keerthi for MMS-DM-CRF-0191 US001-->
			<td nowrap class='label'  ><fmt:message key="eIP.AdmissionApprovalDtls.label" bundle="${ip_labels}"/></td>
			<td nowrap class="fields"><input type="text" name="admission_approval_details" id="admission_approval_details"  size=15 maxlength=100 value ="" onKeyPress="return CheckForSpecCharsValidation1(event);" onBlur='CheckSplCharsValidation(this);' ></td>
			<!--Ended by Suji Keerthi for MMS-DM-CRF-0191 US001-->
		</tr>
			<td nowrap class="COLUMNHEADER" colspan='4'><fmt:message key="eIP.EscortAmbulanceService.label" bundle="${ip_labels}"/></td>
		<tr>
			<td nowrap class='label'  ><fmt:message key="Common.ModeofArrival.label" bundle="${common_labels}"/></td>
			<td nowrap class="fields"><select name="arrival_code" id="arrival_code" ><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</select></td><td nowrap class="label" ></td><td nowrap class="label" ></td>
		</tr>
		<tr>
			<td nowrap class='label'  ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
			<td nowrap class="fields"  ><input type="text" name="escort_name" id="escort_name"  size=15 maxlength=30 value ="" onBlur='makeValidString(this)' ></td>
			<td nowrap class='label'  ><fmt:message key="Common.telno.label" bundle="${common_labels}"/></td>
			<td nowrap class="fields"><input type="text" name="escort_tel_num" id="escort_tel_num"  size=15 maxlength=18 value ="" onBlur='makeValidString(this)' ></td>
		</tr>
		<tr>
			<td nowrap class='label' ><fmt:message key="eIP.MVRegnNo.label" bundle="${ip_labels}"/></td>
			<td nowrap class="fields"><input type="text" name="escort_mv_regn_no" id="escort_mv_regn_no"  size=15 maxlength=15 value ="" onBlur='makeValidString(this)' ></td>
			<td nowrap class='label'  ><fmt:message key="eIP.EmergencyDetail.label" bundle="${ip_labels}"/></td>
			<td nowrap class="fields"><input type="text" name="emergency_detail" id="emergency_detail" size="40" maxlength="500" onBlur="makeValidString(this);" value ="" ></td>
		</tr>
	</table>
	<!--Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779-->
	<%if(isPsychiatryFormAppl && quick_adm.equals("Quick_admission")){%>
	</div>
	<%}%>
		<!-- Added By Dharma on 14th Jan 2020 against AMRI-CRF-0362.1 Start -->
		<input type = 'hidden' name = 'bl_adm_remarks' id = 'bl_adm_remarks' value="">
		<input type = 'hidden' name = 'bl_bed_request' id = 'bl_bed_request' value="">
		<input type = 'hidden' name = 'bl_bed_type_code' id = 'bl_bed_type_code' value="">
		<!-- Added By Dharma on 14th Jan 2020 against AMRI-CRF-0362.1 End -->
		<input type='hidden' name='continue_as_mlc_yn' id='continue_as_mlc_yn' value='N'>
		<input type="hidden" name="confirm_flag" id="confirm_flag" value="">
		<input type="hidden" name="baby_flag" id="baby_flag" value="">
		<input type='hidden' name='admissiondate_readonly' id='admissiondate_readonly' value='<%=admissiondate%>'>
		<input type='hidden' name='backdated_admission_yn' id='backdated_admission_yn' value='<%=backdated_admission_yn%>'>
		<input type='hidden' name='blockflag' id='blockflag' value=''>
		<input type="hidden" name="currdate" id="currdate" value="<%=systemDate%>">
		<input type="hidden" name="booking_ref_no" id="booking_ref_no" value="">
		<input type="hidden" name="bkg_type" id="bkg_type" value="">
		<input type="hidden" name="patient_id" id="patient_id" value="">
		<input type="hidden" name="encounter_id" id="encounter_id" value="">
		<input type="hidden" name="referral_id" id="referral_id" value="">
		<input type="hidden" name="adm_type_ind" id="adm_type_ind" value="">
		<input type="hidden" name="ancillary_yn" id="ancillary_yn" value="<%=ancillaryyn%>">
		<input type="hidden" name="ref_practitioner_name" id="ref_practitioner_name" value="">
		<input type="hidden" name="patient_class" id="patient_class" value="">
		<input type="hidden" name="patient_class_id" id="patient_class_id" value="">
		<input type="hidden" name="from_adv_bed_mgmt" id="from_adv_bed_mgmt" value="<%=from_adv_bed_mgmt%>">
		<input type="hidden" name="nursing_unit_code" id="nursing_unit_code" value="<%=nursingunitcode%>">
		<input type="hidden" name="bed_class_code" id="bed_class_code" value="<%=bedclasscode%>">
		<input type="hidden" name="call_func" id="call_func" value="<%=callfunc%>">
		<input type="hidden" name="gender" id="gender" value="">
		<input type="hidden" name="age" id="age" value="">
		<input type='hidden' name='bed_assigned_for_nb_yn' id='bed_assigned_for_nb_yn' value='N'>
		<input type="hidden" name="contact_details" id="contact_details" value="">
		<input type='hidden' name='pat_ser_grp_code' id='pat_ser_grp_code' value=''>
		<input type='hidden' name='to_speciality_code' id='to_speciality_code' value=''>
		<input type='hidden' name='hddfacility' id='hddfacility' value='<%=facility_id%>'>
		<input type='hidden' name='recorded_by' id='recorded_by' value=''>
		<input type='hidden' name='recorded_date' id='recorded_date' value=''>
		<input type='hidden' name='valuble_remakrs' id='valuble_remakrs' value=''>
		<input type="hidden" name="valubles" id="valubles" value=""> 
		<input type="hidden" name="rec_diag_yn" id="rec_diag_yn" value='<%=rec_diag_from_admit_pat_yn%>'> 

		<!-- ===== Common address component fields ===== -->
		<input type='hidden' name='change_address' id='change_address' value=''>
		<input type='hidden' name='concat_address_hidden' id='concat_address_hidden' value=''>		
		<input type='hidden' name='concat_NatIdDetails_hidden' id='concat_NatIdDetails_hidden' value=''>		
		<input type='hidden' name='addr1_type' id='addr1_type' value=''>
		<input type='hidden' name='addr_line1' id='addr_line1' value='' >
		<input type='hidden' name='addr_line2' id='addr_line2' value='' >
		<input type='hidden' name='addr_line3' id='addr_line3' value='' >
		<input type='hidden' name='addr_line4' id='addr_line4' value='' >
		<input type='hidden' name='res_town_code' id='res_town_code' value='' >
		<input type='hidden' name='res_town_desc' id='res_town_desc' value='' >
		<input type='hidden' name='res_area_code' id='res_area_code' value=''>
		<input type='hidden' name='res_area_desc' id='res_area_desc' value=''>
		<input type='hidden' name='postal_code' id='postal_code' value='' >	
		<input type='hidden' name='postal_desc' id='postal_desc' value='' >	
		<input type='hidden' name='region_code' id='region_code' value='' >	
		<input type='hidden' name='region_desc' id='region_desc' value='' >	
		<input type='hidden' name='country_code' id='country_code' value='' >
		<input type='hidden' name='country_desc' id='country_desc' value=''>
		<input type='hidden' name='contact1_name' id='contact1_name' value=''>
		<input type='hidden' name='invalid1_yn' id='invalid1_yn' value=''>
		<input type='hidden' name='addr2_type' id='addr2_type' value=''>
		<input type='hidden' name='mail_addr_line1' id='mail_addr_line1'  value=''>
		<input type='hidden' name='mail_addr_line2' id='mail_addr_line2'  value=''>
		<input type='hidden' name='mail_addr_line3' id='mail_addr_line3' value='' >
		<input type='hidden' name='mail_addr_line4' id='mail_addr_line4' value='' >
		<input type='hidden' name='mail_res_town_code' id='mail_res_town_code' value=''>
		<input type='hidden' name='mail_res_town_desc' id='mail_res_town_desc' value='' >
		<input type='hidden' name='mail_res_area_code' id='mail_res_area_code' value='' >
		<input type='hidden' name='mail_res_area_desc' id='mail_res_area_desc' value='' >
		<input type='hidden' name='mail_postal_code' id='mail_postal_code' value='' >
		<input type='hidden' name='mail_postal_desc' id='mail_postal_desc' value='' >
		<input type='hidden' name='mail_region_code' id='mail_region_code' value='' >
		<input type='hidden' name='mail_region_desc' id='mail_region_desc' value='' >
		<input type='hidden' name='mail_country_code' id='mail_country_code' value=''>
		<input type='hidden' name ='mail_country_desc' value=''>
		<input type='hidden' name='contact2_name' id='contact2_name' value=''>
		<input type='hidden' name='invalid2_yn' id='invalid2_yn' value=''>
		<input type='hidden' name='contact1_no' id='contact1_no' value=''>
		<input type='hidden' name='contact2_no' id='contact2_no' value=''>
		<input type='hidden' name='email' id='email' value=''>
		<!-- ===== Common address component fields ===== -->
		
		<!--Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start-->
		<input type='hidden' name='alt_addr_line1' id='alt_addr_line1' value=''>
		<input type='hidden' name='alt_addr_line2' id='alt_addr_line2' value=''>
		<input type='hidden' name='alt_addr_line3' id='alt_addr_line3' value=''>
		<input type='hidden' name='alt_addr_line4' id='alt_addr_line4' value=''>
		<input type='hidden' name='alt_town_code' id='alt_town_code' value=''>
		<input type='hidden' name='alt_town_desc' id='alt_town_desc' value=''>
		<input type='hidden' name='alt_area_code' id='alt_area_code' value=''>
		<input type='hidden' name='alt_area_desc' id='alt_area_desc' value=''>
		<input type='hidden' name='alt_postal_code' id='alt_postal_code' value=''>
		<input type='hidden' name='alt_postal_desc' id='alt_postal_desc' value=''>
		<input type='hidden' name='alt_region_code' id='alt_region_code' value=''>
		<input type='hidden' name='alt_region_desc' id='alt_region_desc' value=''>
		<input type='hidden' name='alt_country_code' id='alt_country_code' value=''>
		<input type='hidden' name='alt_country_desc' id='alt_country_desc' value=''>
		<input type='hidden' name='isAlternateAddressAppl' id='isAlternateAddressAppl' value='<%=isAlternateAddressAppl%>'>
		<!--End-->
		
		
		<input type='hidden' name='isAttendPractAppl' id='isAttendPractAppl' value='<%=isAttendPractAppl%>'> <!-- added by mujafar for ML-MMOH-SCF-1316 -->

		<input type='hidden' name='operation' id='operation' value='Generate_File'>
		<input type='hidden' name='back_date' id='back_date' value='<%=back_date%>'>
		<input type='hidden' name='adm_date_chk_days' id='adm_date_chk_days' value='<%=adm_date_chk_days%>'>
		<input type='hidden' name='adm_date_chk_days_type' id='adm_date_chk_days_type' value='<%=adm_date_chk_days_type%>'>
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        <input type='hidden' name='isBlInstalled' id='isBlInstalled' value='<%=bl_operational%>'>
        <input type='hidden' name='isBlInterfaced' id='isBlInterfaced' value='<%=isBlInterfaced%>'>
		<input type='hidden' name='bl_interface_yn' id='bl_interface_yn' value="<%=isBlInterfaced%>"> 
		<input type='hidden' name='bl_install_yn' id='bl_install_yn' value="<%=bl_operational%>">
		
		<!--Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779-->
		<input type = 'hidden' name = 'PFValue' value="">

        <input type='hidden' name='new_file_no' id='new_file_no' value=''>
		<!--Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] Start-->
		<input type = 'hidden' name = 'isForm60Available' value="<%=isForm60Available%>"> 
		<!-- Added by Sangeetha for KDAH-CRF-0347 -->
		<input type = 'hidden' name = 'validationForPanCardAvail' value="<%=validationForPanCardAvail%>"> 
		<input type="hidden" name="form60_YN" id="form60_YN" value="">
		<!--Added by Dharma on 3rd Feb 2016 for KDAH-CRF-0331 [IN058799] End-->
         <%if(bl_operational.equals("Y")) {%>
		        <a name='tab3' id='tab3' ></a>
			<ul id="tablist" class="tablist" style="padding-left: 2px;">
			<li class="tablistitem" title="Admission Details">
				<a onclick="tab_click('admission_tab2')" class="tabA" id="admission_tab2" >
					<span class="tabAspan" id=""><fmt:message key="Common.admission.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Financial Details">
				<a onclick="tab_click('findtl_tab2')" class="tabClicked" id="findtl_tab2" >
					<span class="tabSpanclicked" id=""><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>
		</ul>
	<%	}	%>
			<input type='hidden' name='billing_group' id='billing_group' value=''>
			<input type='hidden' name='bl_future_admn_YN' id='bl_future_admn_YN' value=''>
<!--                <input type='hidden' name='billing_class' id='billing_class' value=''>
			<input type='hidden' name='employer_code' id='employer_code' value=''>
			<input type='hidden' name='cash_set_type1' id='cash_set_type1' value=''>
			<input type='hidden' name='cash_insmt_ref1' id='cash_insmt_ref1' value=''>
			<input type='hidden' name='cash_insmt_date1' id='cash_insmt_date1' value=''>
			<input type='hidden' name='cash_insmt_rmks1' id='cash_insmt_rmks1' value=''>
			<input type='hidden' name='cust_1' id='cust_1' value=''>
			<input type='hidden' name='credit_doc_ref1' id='credit_doc_ref1' value=''>
			<input type='hidden' name='credit_doc_date1' id='credit_doc_date1' value=''>
			<input type='hidden' name='cust_2' id='cust_2' value=''>
			<input type='hidden' name='credit_doc_ref2' id='credit_doc_ref2' value=''>
			<input type='hidden' name='credit_doc_date2' id='credit_doc_date2' value=''>
			<input type='hidden' name='cust_3' id='cust_3' value=''>
			<input type='hidden' name='policy_type' id='policy_type' value=''>
			<input type='hidden' name='policy_no' id='policy_no' value=''>
			<input type='hidden' name='policy_expiry_date' id='policy_expiry_date' value=''>
			<input type='hidden' name='non_insur_blng_grp' id='non_insur_blng_grp' value=''>
			<input type='hidden' name='cash_set_type2' id='cash_set_type2' value=''>
			<input type='hidden' name='cash_insmt_ref2' id='cash_insmt_ref2' value=''>
			<input type='hidden' name='cash_insmt_date2' id='cash_insmt_date2' value=''>
			<input type='hidden' name='cash_insmt_rmks2' id='cash_insmt_rmks2' value=''>
			<input type='hidden' name='cust_4' id='cust_4' value=''>
			<input type='hidden' name='credit_doc_ref3' id='credit_doc_ref3' value=''>
			<input type='hidden' name='credit_doc_date3' id='credit_doc_date3' value=''>
			<input type='hidden' name='setlmt_ind' id='setlmt_ind' value=''>
			<input type='hidden' name='upd_fin_dtls' id='upd_fin_dtls' value=''>
			<input type='hidden' name='credit_auth_ref' id='credit_auth_ref' value=''>
			<input type='hidden' name='credit_auth_date' id='credit_auth_date' value=''>
			<input type='hidden' name='app_days' id='app_days' value=''>
			<input type='hidden' name='app_amount' id='app_amount' value=''>
			<input type='hidden' name='eff_frm_date' id='eff_frm_date' value=''>-->
			
			<input type='hidden' name='billing_mode' id='billing_mode' value='Add'>
			<input type='hidden' name='bl_operation' id='bl_operation' value=''>
			<input type='hidden' name='pkg_bill_type' id='pkg_bill_type' value=''>
			<input type='hidden' name='pkg_bill_no' id='pkg_bill_no' value=''>
			<input type='hidden' name='package_flag' id='package_flag' value='N'>
			<input type='hidden' name='insTrackDtlsExists' id='insTrackDtlsExists' value=''>
			<input type='hidden' name='P_call_func' id='P_call_func' value='<%=callfunc%>'>			
			<input type='hidden' name='health_card_expired_yn' id='health_card_expired_yn' value=''>
<!--
			<input type='hidden' name='annual_income' id='annual_income' value=''>
			<input type='hidden' name='family_asset' id='family_asset' value=''>
			<input type='hidden' name='no_of_dependants' id='no_of_dependants' value=''>
			<input type='hidden' name='resp_for_payment' id='resp_for_payment' value=''>
			<input type='hidden' name='credit_doc_reqd_yn1' id='credit_doc_reqd_yn1' value=''>
			<input type='hidden' name='credit_doc_reqd_yn2' id='credit_doc_reqd_yn2' value=''>
-->
			<input type='hidden' name='Chg_to_Visitor_Grp' id='Chg_to_Visitor_Grp' value='N'>
			<input type='hidden' name='bl_success' id='bl_success' value='N'>
	
			<input type='hidden' name='user_id' id='user_id' value=''>
			<input type='hidden' name='upd_user_flag' id='upd_user_flag' value=''>
			<input type='hidden' name='remarks' id='remarks' value=''>

			
			<!--<input type='hidden' name='cred_st_dt1' id='cred_st_dt1' value=''>
			<input type='hidden' name='cred_st_dt2' id='cred_st_dt2' value=''>
			<input type='hidden' name='cred_st_dt3' id='cred_st_dt3' value=''>
			<input type='hidden' name='gl_holder_name' id='gl_holder_name' value=''>
			<input type='hidden' name='gl_holder_reln' id='gl_holder_reln' value=''>-->

			<input type='hidden' name='financial_detail_ref_id' id='financial_detail_ref_id' value=''>
			<input type='hidden' name='org_type_ind' id='org_type_ind' value=''>
			<input type='hidden' name='function_id' id='function_id' value='ADMIT_PAT'>			
			<input type='hidden' name='blr_check' id='blr_check' value=''>
			<input type='hidden' name='bkg_grace_period' id='bkg_grace_period' value='<%=bkg_grace_period%>'>
	
          <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
          <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
			<input type = 'hidden' name = 'sStyle' value="<%=sStyle%>">  
			<input type = 'hidden' name = 'locale' value="<%=locale%>">  
			<input type = 'hidden' name = 'nurs_unt_auth_val' value="<%=nurs_unt_auth_val%>">  
			<input type = 'hidden' name = 'pat_flag' value=">">  
			<input type = 'hidden' name = 'deactivate_pseudo_bed_yn' value="<%=deactivate_pseudo_bed_yn%>">  
			<input type = 'hidden' name = 'p_hosp_main' value="">  
			<input type = 'hidden' name = 'p_hosp_sub' value="">  
			<input type = 'hidden' name = 'p_card_id' value="">  
			<input type = 'hidden' name = 'p_expiry_date' value="">  
			<input type = 'hidden' name = 'p_privl_type_code' value="">  
			<input type = 'hidden' name = 'p_all_services' value="">  
			<input type = 'hidden' name = 'p_error_text' value="">  
			<input type = 'hidden' name = 'p_status' value="">  
			<input type = 'hidden' name = 'bed_mandatory_for_admn_yn' value="<%=bed_mandatory_for_admn_yn%>">  
			<input type = 'hidden' name = 'admit_patient_with_bed_yn' value="">  
				<input type = 'hidden' name = 'package_enabled_yn' value="<%=str_bl_package_enabled_yn%>">  
				<!--Added the below hidden field for IN023629 on 03.08.2010 by Suresh M-->
				<input type = 'hidden' name = 'bl_interfaced_yn' value="<%=bl_interfaced_yn%>">  
					<%/*Below line Added for this CRF  Bru-HIMS-CRF-261*/%>
				<input type = 'hidden' name = 'quick_admission_type' value="<%=quick_admission_type%>">  
				<input type = 'hidden' name = 'quick_adm_referralid' value="<%=quick_adm_referralid%>">  
				<input type = 'hidden' name = 'quick_adm' value="<%=quick_adm%>">  
				<input type = 'hidden' name = 'ref_encounter_id' value="<%=ref_encounter_id%>">  				
				<!--Below line added for this CRF GDOH-CRF-0129-->
				<input type="hidden" name="assigncare_loctype_ind" id="assigncare_loctype_ind" id="assigncare_loctype_ind" value="">
				<input type="hidden" name="assigncare_locacode" id="assigncare_locacode" id="assigncare_locacode" value="">
				<input type="hidden" name="isReferral" id="isReferral" id="isReferral" value="<%=isReferral%>"> 
				<!--End GDOH-CRF-0129-->			
				
	<%
		if(from_adv_bed_mgmt.equals("Y")){
	%>
			<script>
				document.forms[0].patient_class_id.value='<%=appl_patient_class%>';
				validateFields(document.forms[0].nursing_unit_desc);
				chkbedno();
			</script>
	<%
		}
	%>
		</form>
        </body>
    <%
      
			if(ipBlIntfrs!=null) ipBlIntfrs.close();
			if(rset!=null)  rset.close();
			if(rs!=null)    rs.close();
			if(stmt!=null)  stmt.close();
			if(chkinstmt!=null) chkinstmt.close();
			if(chkinrs!=null) chkinrs.close();
			if(ipBlIntfStmt!=null) ipBlIntfStmt.close();
			if(nbstmt!=null) nbstmt.close();
			if(nbrs!=null) nbrs.close();

        }catch(Exception e)
		{
			//out.println("Exception in addModifyAdmitPatient.jsp : "+e.toString());
            e.printStackTrace();

        }   
        finally   
        {
			if(con != null)
				if(con != null)ConnectionManager.returnConnection(con,request);  
        }
    %>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
<!-- Added for MMS-QH-CRF-0144 to do the functions as like "onchange" event of "admission_for" field -->
<script> enableFlds();allowedAdmissionType();disableflds(); </script> 

