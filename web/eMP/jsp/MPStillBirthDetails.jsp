<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*,com.ehis.util.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script src='../../eMP/js/MPStillBirthDetails.js' language='javascript'></script>
	<!--  <script src='../../eMP/js/test.js' language='javascript'></script>-->
	<script src='../../eOR/js/Test.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>

	</head>

<%
	Connection conn=null;
	PreparedStatement pstmt   =null;		
	ResultSet rs            = null;

	//String quer_str=request.getQueryString();


   try{

	conn=ConnectionManager.getConnection (request);
	String locale=(String)session.getAttribute("LOCALE"); 
	String facilityId       = (String) session.getValue("facility_id");
	
	//Below line added for this CRF ML-MMOH-CRF-0621
	 Boolean isRegNewbornApplicable = CommonBean.isSiteSpecific(conn, "MP","REG_NEWBORN_FOR_IP");
	//End ML-MMOH-CRF-0621
	

//	String	pract_id_still_birth=checkForNull(request.getParameter("pract_id_still_birth"));
	String	practid_desc=checkForNull(request.getParameter("practid_desc"));	
	String	surname_pract=checkForNull(request.getParameter("surname_pract"));
	String	age=checkForNull(request.getParameter("age"));
	String	licenseNo=checkForNull(request.getParameter("licenseNo"));
	String  q_finalized_yn = checkForNull(request.getParameter("q_finalized_yn"));
	String  data_upd_allowed_aft_final_yn = checkForNull(request.getParameter("data_upd_allowed_aft_final_yn"));

	HashMap query_string_map	 = (HashMap)session.getAttribute("query_string_map");

	String	pract_id_still_birth			=checkForNull((String)query_string_map.get("pract_id_still_birth"));
	String	attendant_at_birth			=checkForNull((String)query_string_map.get("attendant_at_birth"));
	String	autopsy_reqd_yn				=checkForNull((String)query_string_map.get("autopsy_reqd_yn"));
	String	mate_cond_main_cod		=checkForNull((String)query_string_map.get("mate_cond_main_cod"));
	String	mate_cond_main_cod_dur	=checkForNull((String)query_string_map.get("mate_cond_main_cod_dur"));
	String	mate_cond_oth_cod=checkForNull((String)query_string_map.get("mate_cond_oth_cod"));
	String	mate_cond_oth_cod_dur=checkForNull((String)query_string_map.get("mate_cond_oth_cod_dur"));
	String	mate_cond_preexist_cod	=checkForNull((String)query_string_map.get("mate_cond_preexist_cod"));
	String	mate_cond_preexist_cod_dur=checkForNull((String)query_string_map.get("mate_cond_preexist_cod_dur"));
	String	oth_rel_mate_cond_rel_cod	=checkForNull((String)query_string_map.get("oth_rel_mate_cond_rel_cod"));
	String	oth_rel_mate_cond_rel_cod_dur=checkForNull((String)query_string_map.get("oth_rel_mate_cond_rel_cod_dur"));

	String cond_cau_dea_main_cod=checkForNull((String)query_string_map.get("cond_cau_dea_main_cod"));
	String cond_cau_dea_main_cod_dur=checkForNull((String)query_string_map.get("cond_cau_dea_main_cod_dur"));
	String cond_cau_dea_oth_cod=checkForNull((String)query_string_map.get("cond_cau_dea_oth_cod"));
	String cond_cau_dea_oth_cod_dur=checkForNull((String)query_string_map.get("cond_cau_dea_oth_cod_dur"));
	String cond_cau_dea_preexist_cod=checkForNull((String)query_string_map.get("cond_cau_dea_preexist_cod"));
	String cond_cau_dea_preexist_cod_dur=checkForNull((String)query_string_map.get("cond_cau_dea_preexist_cod_dur"));
	String rel_cond_cau_dea_rel_cod=checkForNull((String)query_string_map.get("rel_cond_cau_dea_rel_cod"));
	String rel_cond_cau_dea_rel_cod_dur=checkForNull((String)query_string_map.get("rel_cond_cau_dea_rel_cod_dur"));

	int age_val=0;

	if(!pract_id_still_birth.equals(""))	{
		pstmt   = conn.prepareStatement("select practitioner_name,short_name, get_age(date_of_birth) age,apc_no from am_practitioner_lang_vw where practitioner_id = ? and language_id = '"+locale+"' ");
		pstmt.setString(1, pract_id_still_birth);

		rs = pstmt.executeQuery();
		if(rs!=null && rs.next()) {		
			practid_desc= checkForNull(rs.getString("practitioner_name"));
			surname_pract= checkForNull(rs.getString("short_name"));
			age	= checkForNull(rs.getString("age"));
			licenseNo= checkForNull(rs.getString("apc_no")); 
		}

		if(!age.equals("")) {
			age_val = age.indexOf("Y");
			age = age.substring(0,age_val);
	   }
	}


	/*String	attendant_at_birth=checkForNull(request.getParameter("attendant_at_birth"));
	String	autopsy_reqd_yn=checkForNull(request.getParameter("autopsy_reqd_yn"));
	String	mate_cond_main_cod=checkForNull(request.getParameter("mate_cond_main_cod"));
	String	mate_cond_main_cod_dur	=checkForNull(request.getParameter("mate_cond_main_cod_dur"));
	String	mate_cond_oth_cod=checkForNull(request.getParameter("mate_cond_oth_cod"));
	String	mate_cond_oth_cod_dur=checkForNull(request.getParameter("mate_cond_oth_cod_dur"));
	String	mate_cond_preexist_cod	=checkForNull(request.getParameter("mate_cond_preexist_cod"));
	String	mate_cond_preexist_cod_dur=checkForNull(request.getParameter("mate_cond_preexist_cod_dur"));
	String	oth_rel_mate_cond_rel_cod	=checkForNull(request.getParameter("oth_rel_mate_cond_rel_cod"));
	String	oth_rel_mate_cond_rel_cod_dur=checkForNull(request.getParameter("oth_rel_mate_cond_rel_cod_dur"));

	String cond_cau_dea_main_cod=checkForNull(request.getParameter("cond_cau_dea_main_cod"));
	String cond_cau_dea_main_cod_dur=checkForNull(request.getParameter("cond_cau_dea_main_cod_dur"));
	String cond_cau_dea_oth_cod=checkForNull(request.getParameter("cond_cau_dea_oth_cod"));
	String cond_cau_dea_oth_cod_dur=checkForNull(request.getParameter("cond_cau_dea_oth_cod_dur"));
	String cond_cau_dea_preexist_cod=checkForNull(request.getParameter("cond_cau_dea_preexist_cod"));
	String cond_cau_dea_preexist_cod_dur=checkForNull(request.getParameter("cond_cau_dea_preexist_cod_dur"));
	String rel_cond_cau_dea_rel_cod=checkForNull(request.getParameter("rel_cond_cau_dea_rel_cod"));
	String rel_cond_cau_dea_rel_cod_dur=checkForNull(request.getParameter("rel_cond_cau_dea_rel_cod_dur"));*/

	String selAC="";
	String selTM="";
	String selMW="";
	String selPH="";
	String selNU="";
	String selMA="";


	if(attendant_at_birth.equals("AC")){
		selAC="Selected";
	}else 	if(attendant_at_birth.equals("TM")){
		selTM="Selected";
	}else 	if(attendant_at_birth.equals("MW")){
		selMW="Selected";
	}else 	if(attendant_at_birth.equals("PH")){
		selPH="Selected";
	}else 	if(attendant_at_birth.equals("NU")){
		selNU="Selected";
	}else 	if(attendant_at_birth.equals("MA")){
		selMA="Selected";
	}

	if(selAC.equals("") && selTM.equals("") && selMW.equals("") && selPH.equals("") && selNU.equals("") && selMA.equals("")){
		selPH="Selected";
	}

	String autpsy_Chk="";
	if(autopsy_reqd_yn.equals("Y")){
		autpsy_Chk="Checked";
	}
	
	ArrayList ar_list_test;

	StringBuffer sql               =	new StringBuffer();
	//String userid                  =	(String) session.getValue("login_user");
	String max_gestation		   =	""; 
	String min_gestation		   =	""; 
	String unit_of_gest_nb		   =	""; 
	String sysDate                 =    "";
	int max_gestation_days		   =	0;
	int min_gestation_days         =	0;
	try
	{
		
		sql.append("Select MAX_GESTATION, MIN_GESTATION,UNIT_OF_GEST_NB,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_Date from mp_param");
		pstmt = conn.prepareStatement(sql.toString());
		rs= pstmt.executeQuery();
		if(rs!=null && rs.next())
		{
			  max_gestation		= checkForNull(rs.getString("MAX_GESTATION"));
			  min_gestation		= checkForNull(rs.getString("MIN_GESTATION"));
			  unit_of_gest_nb	= checkForNull(rs.getString("UNIT_OF_GEST_NB"));
			  sysDate			= checkForNull(rs.getString("sys_Date"));
			  
		}
		if(rs != null) rs.close();
		if(pstmt !=null) pstmt.close();
		if((sql != null) && (sql.length() > 0))
	    {
			sql.delete(0,sql.length());
	    }
    if((!unit_of_gest_nb.equals("")) && (!max_gestation.equals("")))
	{
      if(unit_of_gest_nb.equals("W"))
		{
             max_gestation_days = Integer.parseInt( max_gestation ) * 7 ;
		}else if (unit_of_gest_nb.equals("D"))
		{
		     max_gestation_days = Integer.parseInt( max_gestation )  ;
		}
	}
	if((!unit_of_gest_nb.equals("")) && (!min_gestation.equals("")))
	{
      if(unit_of_gest_nb.equals("W"))
		{
             min_gestation_days = Integer.parseInt( min_gestation ) * 7 ;
		}else if (unit_of_gest_nb.equals("D"))
		{
		     min_gestation_days = Integer.parseInt( min_gestation )  ;
		}
	}
	%>
	<body onKeyDown ='lockKey()' onload="disabledFields();">
	<form name="StillBirth_form" id="StillBirth_form"  method='post' target="Dummy_frame" >
	<table border='0' align=center cellpadding='2' cellspacing='0' width='98%'  >
					
	<tr><td colspan=4>&nbsp;</td></tr>
	<tr>
		<td class="label" width='25%'><fmt:message key="eMP.NameoftheCertperson.label" bundle="${mp_labels}"/></td>
		<td class ='fields'  width='25%'  nowrap>
		<input type='text' maxLength="30" size="25"  name="practid_desc" id="practid_desc"  onBlur='if(this.value!=""){callPractSearch(document.forms[0].pract_id_search1,document.forms[0].practid_desc);}else{getattndpract();}' value="<%=practid_desc%>"  tabindex='1'><input type='button'  name='pract_id_search1' id='pract_id_search1' value='?' class='button'  onClick='callPractSearch(document.forms[0].pract_id_search1,document.forms[0].practid_desc);'  tabindex='2' >
		<!--Below line added for this CRF ML-MMOH-CRF-0621-->
		<%if(!isRegNewbornApplicable){%><img id='mandatory' src='../../eCommon/images/mandatory.gif'><%}%>
		<!--End this CRF ML-MMOH-CRF-0621-->
		<input type='hidden' name="attend_physician_id" id="attend_physician_id" value="<%=pract_id_still_birth%>">
		</td>
		<!-- <td class="label" width='25%'><fmt:message key="eMP.SurnameofCertpract.label" bundle="${mp_labels}"/></td>
		<td class ='fields'  width='25%'  nowrap><input type='text' name='surname_pract' id='surname_pract' size='16' maxlength='16'  value='<%=surname_pract%>' readonly></td> -->
	</tr>
	<tr>
		<td class="label" width='25%'><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
		<td class ='fields'  width='25%'  nowrap><input type='text' name='age' id='age' size='3' maxlength='3'  value='<%=age%>' readonly></td>
		<td class="label" width='25%'><fmt:message key="eMP.LicenseNo.label" bundle="${mp_labels}"/></td>
		<td class ='fields'  width='25%'  nowrap><input type='text' name='licenseNo' id='licenseNo' size='20' maxlength='20'  value='<%=licenseNo%>' readonly></td>
	</tr>
	<tr>
		<td class="label" width='25%'><fmt:message key="eMP.AttendantAtBirth.label" bundle="${mp_labels}"/></td>
		<td class ='fields'  width='25%'  nowrap  tabindex='3' >
		<select name='attendant_at_birth' id='attendant_at_birth' tabindex='5' >
			 <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
			 <option value='AC' <%=selAC%>><fmt:message key="eMP.Accoucheuse.label" bundle="${mp_labels}"/>
			 <option value='TM' <%=selTM%>><fmt:message key="eMP.TraditionalMedicine.label" bundle="${mp_labels}"/>
			 <option value='MA' <%=selMA%>><fmt:message key="eMP.MidwifeAssistance.label" bundle="${mp_labels}"/>
			 <option value='PH' <%=selPH%>><fmt:message key="eMP.Physician.label" bundle="${mp_labels}"/>
			 <option value='MW' <%=selMW%>><fmt:message key="Common.midwife.label" bundle="${common_labels}"/>
			 <option value='NU' <%=selNU%>><fmt:message key="Common.nurse.label" bundle="${common_labels}"/>
        </select>
	</td>
	</tr>
	<tr>
			<td  colspan=4 class='columnheader'><fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
			<td  colspan=4 class='label'></td>
	</tr>
	<tr>
			<td  colspan=2 class='columnheader'>1.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eMP.MaternalcondAffectFetus.label" bundle="${mp_labels}"/></td><td  colspan=2 class='columnheader'><fmt:message key="eMP.DurationofDisease.label" bundle="${mp_labels}"/></td>
	</tr>
	<tr>
		<td class="label" width='25%'>a.&nbsp;<fmt:message key="Common.main.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/></td>
		<td class ='fields'  width='25%' ><TextArea name="mate_cond_main_cod" size=100 maxlength=100 rows="2" cols="30"   onBlur='checkLength(this,100);' onkeypress='checkMaxLimit(this,100);return CheckSplChars(event);'><%=mate_cond_main_cod%></TextArea>
	</td>
			<%ar_list_test=parse_duration_yr(mate_cond_main_cod_dur);%>

	<td class='fields' width='25%' colspan='2'>
		<input type='text' name='years_main' id='years_main' style='width:40' maxlength='2' value='<%=ar_list_test.get(0)%>' onKeyPress="return ChkNumberInput(this,event,0)" onblur='Chekyear(this);'>&nbsp;Y&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='months_main' id='months_main' style='width:30' maxlength='2' value='<%=ar_list_test.get(1)%>' onKeyPress="return ChkNumberInput(this,event,0)" onblur='Chekmonth(this);'>&nbsp;M&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='days_main' id='days_main' style='width:30' maxlength='2'  value='<%=ar_list_test.get(2)%>' onKeyPress="return ChkNumberInput(this,event,0)" onblur='Chekdays(this);'>&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='hours_main' id='hours_main' style='width:30' maxlength='2'  value='<%=ar_list_test.get(3)%>' onKeyPress="return ChkNumberInput(this,event,0);" onblur='Chekhours(this);'>&nbsp;H&nbsp;&nbsp;&nbsp;&nbsp;

	</td>
	</tr>
		<tr>
		<td class="label" width='25%'>b.&nbsp;<fmt:message key="Common.other.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/></td>
		<td class ='fields'  width='25%' ><TextArea name="mate_cond_oth_cod" size=100 maxlength=100 rows="2" cols="30"  onBlur='checkLength(this,100);' onkeypress='checkMaxLimit(this,100);return CheckSplChars(event);'><%=mate_cond_oth_cod%></TextArea> 
	</td>
		<%ar_list_test=parse_duration_yr(mate_cond_oth_cod_dur);%>

	<td class='fields' width='25%' colspan='2'>
		<input type='text' name='years_others' id='years_others' style='width:40' maxlength='2' value='<%=ar_list_test.get(0)%>' onKeyPress="return ChkNumberInput(this,event,0)" onblur='Chekyear(this);'>&nbsp;Y&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='months_others' id='months_others' style='width:30' maxlength='2' value='<%=ar_list_test.get(1)%>' onKeyPress="return ChkNumberInput(this,event,0)" onblur='Chekmonth(this);'>&nbsp;M&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='days_others' id='days_others' style='width:30' maxlength='2'  value='<%=ar_list_test.get(2)%>' onKeyPress="return ChkNumberInput(this,event,0)" onblur='Chekdays(this);'>&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='hours_others' id='hours_others' style='width:30' maxlength='2'  value='<%=ar_list_test.get(3)%>' onKeyPress="return ChkNumberInput(this,event,0);" onblur='Chekhours(this);'>&nbsp;H&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
	</tr>

	<tr>
		<td class="label" width='25%'>c.&nbsp;<fmt:message key="eMP.Preexistent.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/></td>
		<td class ='fields'  width='25%' ><TextArea name="mate_cond_preexist_cod" size=100 maxlength=100 rows="2" cols="30"  onBlur='checkLength(this,100);' onkeypress='checkMaxLimit(this,100);return CheckSplChars(event);'><%=mate_cond_preexist_cod%></TextArea> 
	</td>
		<%ar_list_test=parse_duration_yr(mate_cond_preexist_cod_dur);%>

	<td class='fields' width='25%' colspan='2'>
		<input type='text' name='years_preexist' id='years_preexist' style='width:40' maxlength='2' value='<%=ar_list_test.get(0)%>' onKeyPress="return ChkNumberInput(this,event,0)" onblur='Chekyear(this);'>&nbsp;Y&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='months_preexist' id='months_preexist' style='width:30' maxlength='2' value='<%=ar_list_test.get(1)%>' onKeyPress="return ChkNumberInput(this,event,0)" onblur='Chekmonth(this);'>&nbsp;M&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='days_preexist' id='days_preexist' style='width:30' maxlength='2'  value='<%=ar_list_test.get(2)%>' onKeyPress="return ChkNumberInput(this,event,0)" onblur='Chekdays(this);'>&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='hours_preexist' id='hours_preexist' style='width:30' maxlength='2'  value='<%=ar_list_test.get(3)%>' onKeyPress="return ChkNumberInput(this,event,0);" onblur='Chekhours(this);'>&nbsp;H&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
	</tr>
	<tr>
			<td  colspan=2 class='columnheader'>2.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eMP.OthRelatMaternalCondiAffectFetus.label" bundle="${mp_labels}"/></td><td  colspan=2 class='columnheader'><fmt:message key="eMP.DurationofDisease.label" bundle="${mp_labels}"/></td>
	</tr>
	<tr>
		<td class="label" width='25%'>d.&nbsp;<fmt:message key="eMP.RelatedcauseofDeath.label" bundle="${mp_labels}"/></td>
		<td class ='fields'  width='25%' ><TextArea name="oth_rel_mate_cond_rel_cod" size=100 maxlength=100 rows="2" cols="30"  onBlur='checkLength(this,100);' onkeypress='checkMaxLimit(this,100);return CheckSplChars(event);'><%=oth_rel_mate_cond_rel_cod%></TextArea> 
	</td>
		<%ar_list_test=parse_duration_yr(oth_rel_mate_cond_rel_cod_dur);%>

	<td class='fields' width='25%' colspan='2'>
		<input type='text' name='years_related' id='years_related' style='width:40' maxlength='2' value='<%=ar_list_test.get(0)%>' onKeyPress="return ChkNumberInput(this,event,0)" onblur='Chekyear(this);'>&nbsp;Y&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='months_related' id='months_related' style='width:30' maxlength='2' value='<%=ar_list_test.get(1)%>' onKeyPress="return ChkNumberInput(this,event,0)" onblur='Chekmonth(this);'>&nbsp;M&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='days_related' id='days_related' style='width:30' maxlength='2'  value='<%=ar_list_test.get(2)%>' onKeyPress="return ChkNumberInput(this,event,0)" onblur='Chekdays(this);'>&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='hours_related' id='hours_related' style='width:30' maxlength='2'  value='<%=ar_list_test.get(3)%>' onKeyPress="return ChkNumberInput(this,event,0);" onblur='Chekhours(this);'>&nbsp;H&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
	</tr>


   <tr>
			<td  colspan=2 class='columnheader'>1.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eMP.RelatedcauseofDeath.label" bundle="${mp_labels}"/></td><td  colspan=2 class='columnheader'><fmt:message key="eMP.DurationofDisease.label" bundle="${mp_labels}"/></td>
	</tr>
	<tr>
		<td class="label" width='25%'>a.&nbsp;<fmt:message key="Common.main.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/></td>
		<td class ='fields'  width='25%' ><TextArea name="cond_cau_dea_main_cod" size=100 maxlength=100 rows="2" cols="30"  onBlur='checkLength(this,100);' onkeypress='checkMaxLimit(this,100);return CheckSplChars(event);'><%=cond_cau_dea_main_cod%></TextArea> 
	</td>
		<%ar_list_test=parse_duration(cond_cau_dea_main_cod_dur);%>

	<td class='fields' width='25%' colspan='2'>
		<input type='text' name='months_rel' id='months_rel' style='width:30' maxlength='2' value='<%=ar_list_test.get(0)%>' onKeyPress="return ChkNumberInput(this,event,0)" onblur='Chekmonth(this);'>&nbsp;M&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='days_rel' id='days_rel' style='width:30' maxlength='2'  value='<%=ar_list_test.get(1)%>' onKeyPress="return ChkNumberInput(this,event,0)" onblur='Chekdays(this);'>&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='hours_rel' id='hours_rel' style='width:30' maxlength='2'  value='<%=ar_list_test.get(2)%>' onKeyPress="return ChkNumberInput(this,event,0);" onblur='Chekhours(this);'>&nbsp;H&nbsp;&nbsp;&nbsp;&nbsp;
		<!--Below line added for this CRF ML-MMOH-CRF-0621-->
		<%if(!isRegNewbornApplicable){%><img id='mandatory' src='../../eCommon/images/mandatory.gif'><%}%>
		<!--End this CRF ML-MMOH-CRF-0621-->
		
	</td>
	</tr>
		<tr>
		<td class="label" width='25%'>b.&nbsp;<fmt:message key="Common.other.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/></td>
		<td class ='fields'  width='25%' ><TextArea name="cond_cau_dea_oth_cod" size=100 maxlength=100 rows="2" cols="30" onBlur='checkLength(this,100);' onkeypress='checkMaxLimit(this,100);return CheckSplChars(event);'><%=cond_cau_dea_oth_cod%></TextArea> 
	</td>
			<%ar_list_test=parse_duration(cond_cau_dea_oth_cod_dur);%>

	<td class='fields' width='25%' colspan='2'>
		<input type='text' name='months_oth' id='months_oth' style='width:30' maxlength='2' value='<%=ar_list_test.get(0)%>' onKeyPress="return ChkNumberInput(this,event,0)" onblur='Chekmonth(this);'>&nbsp;M&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='days_oth' id='days_oth' style='width:30' maxlength='2'  value='<%=ar_list_test.get(1)%>' onKeyPress="return ChkNumberInput(this,event,0)" onblur='Chekdays(this);'>&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='hours_oth' id='hours_oth' style='width:30' maxlength='2'  value='<%=ar_list_test.get(2)%>' onKeyPress="return ChkNumberInput(this,event,0);" onblur='Chekhours(this);'>&nbsp;H&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
	</tr>

	<tr>
		<td class="label" width='25%'>c.&nbsp;<fmt:message key="eMP.Preexistent.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/></td>
		<td class ='fields'  width='25%' ><TextArea name="cond_cau_dea_preexist_cod" size=100 maxlength=100 rows="2" cols="30" onBlur='checkLength(this,100);' onkeypress='checkMaxLimit(this,100);return CheckSplChars(event);'><%=cond_cau_dea_preexist_cod%></TextArea> 
	</td>
	<%ar_list_test=parse_duration(cond_cau_dea_preexist_cod_dur);%>

	<td class='fields' width='25%' colspan='2'>
		<input type='text' name='months_preex' id='months_preex' style='width:30' maxlength='2' value='<%=ar_list_test.get(0)%>' onKeyPress="return ChkNumberInput(this,event,0)" onblur='Chekmonth(this);'>&nbsp;M&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='days_preex' id='days_preex' style='width:30' maxlength='2'  value='<%=ar_list_test.get(1)%>' onKeyPress="return ChkNumberInput(this,event,0)" onblur='Chekdays(this);'>&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='hours_preex' id='hours_preex' style='width:30' maxlength='2'  value='<%=ar_list_test.get(2)%>' onKeyPress="return ChkNumberInput(this,event,0);" onblur='Chekhours(this);'>&nbsp;H&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
	</tr>

	<tr>
			<td  colspan=2 class='columnheader'>2.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eMP.RelCondCausingDeathInFetus.label" bundle="${mp_labels}"/></td><td  colspan=2 class='columnheader'><fmt:message key="eMP.DurationofDisease.label" bundle="${mp_labels}"/></td>
	</tr>
	<tr>
		<td class="label" width='25%'>d.&nbsp;<fmt:message key="eMP.RelatedcauseofDeath.label" bundle="${mp_labels}"/></td>
		<td class ='fields'  width='25%' ><TextArea name="rel_cond_cau_dea_rel_cod" size=100 maxlength=100 rows="2" cols="30" onBlur='checkLength(this,100);' onkeypress='checkMaxLimit(this,100);return CheckSplChars(event);'><%=rel_cond_cau_dea_rel_cod%></TextArea> 
	</td>
	<%ar_list_test=parse_duration(rel_cond_cau_dea_rel_cod_dur);%>

	<td class='fields' width='25%' colspan='2'>
		<input type='text' name='months_related_1' id='months_related_1' style='width:30' maxlength='2' value='<%=ar_list_test.get(0)%>' onKeyPress="return ChkNumberInput(this,event,0)" onblur='Chekmonth(this);'>&nbsp;M&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='days_related_1' id='days_related_1' style='width:30' maxlength='2'  value='<%=ar_list_test.get(1)%>' onKeyPress="return ChkNumberInput(this,event,0)" onblur='Chekdays(this);'>&nbsp;D&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='text' name='hours_related_1' id='hours_related_1' style='width:30' maxlength='2'  value='<%=ar_list_test.get(2)%>' onKeyPress="return ChkNumberInput(this,event,0);" onblur='Chekhours(this);'>&nbsp;H&nbsp;&nbsp;&nbsp;&nbsp;
	</td>
	</tr>
	<tr>
			<td  colspan=4 class='columnheader'>&nbsp;</td>
	</tr>
	<tr>
		<td class="label" width='25%'><fmt:message key="eMP.AutopsyRequried.label" bundle="${mp_labels}"/></td>
		<td class ='fields'  width='25%' ><input type='checkbox' name='autopsy_requried' id='autopsy_requried' onClick='checkForMode(this);' <%=autpsy_Chk%>>
	</td>
	<td class='fields' width='25%' ></td>
	<td class='fields' width='25%'><input type='button' class='button' name='close' id='close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'  onclick="onClose();" >
	</td>
	</tr>


	</table> 
	<input type='hidden' name='facility_id' id='facility_id' value="<%=facilityId%>">
	<input type='hidden' name='max_gestation_days' id='max_gestation_days' value="<%=max_gestation_days%>">
	<input type='hidden' name='min_gestation_days' id='min_gestation_days' value="<%=min_gestation_days%>">
	<input type='hidden' name='val_done' id='val_done' value="">
	<input type='hidden' name='mandatoryChk' id='mandatoryChk' value="">
	<input type='hidden' name='q_finalized_yn' id='q_finalized_yn' value="<%=q_finalized_yn%>">
	<input type='hidden' name='data_upd_allowed_aft_final_yn' id='data_upd_allowed_aft_final_yn' value="<%=data_upd_allowed_aft_final_yn%>">
	
	<!--Below line added for this CRF ML-MMOH-CRF-0621-->	
	<input type='hidden' name='isRegNewbornApplicable' id='isRegNewbornApplicable' value="<%=isRegNewbornApplicable%>">
	<!--End ML-MMOH-CRF-0621-->


</form>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}


	public static ArrayList parse_duration_yr(String inputString)
	{
		ArrayList arr_lst=new ArrayList();

		if(inputString.equals("")){
			arr_lst.add("");
			arr_lst.add("");
			arr_lst.add("");
			arr_lst.add("");

		}else{
			int indxY=inputString.indexOf("Y");
			int indxM=inputString.indexOf("M");
			int indxD=inputString.indexOf("D");
			int indxH=inputString.indexOf("H");
		

			if(inputString.substring(0,indxY).equals("0")){
				arr_lst.add("");
			}else{
				arr_lst.add(inputString.substring(0,indxY));
			}
			if(inputString.substring(indxY+1,indxM).equals("0")){
				arr_lst.add("");
			}else{
				arr_lst.add(inputString.substring(indxY+1,indxM));
			}
			if(inputString.substring(indxM+1,indxD).equals("0")){
				arr_lst.add("");
			}else{
				arr_lst.add(inputString.substring(indxM+1,indxD));
			}
			if(inputString.substring(indxD+1,indxH).equals("0")){
				arr_lst.add("");
			}else{
				arr_lst.add(inputString.substring(indxD+1,indxH));
			}
		}
		return arr_lst;
	}

	public static ArrayList parse_duration(String inputString)
	{

		ArrayList arr_lst=new ArrayList();

		if(inputString.equals("")){
			arr_lst.add("");
			arr_lst.add("");
			arr_lst.add("");

		}else{
			int indxM=inputString.indexOf("M");
			int indxD=inputString.indexOf("D");
			int indxH=inputString.indexOf("H");
		

			if(inputString.substring(0,indxM).equals("0")){
				arr_lst.add("");
			}else{
				arr_lst.add(inputString.substring(0,indxM));
			}
			if(inputString.substring(indxM+1,indxD).equals("0")){
				arr_lst.add("");
			}else{
				arr_lst.add(inputString.substring(indxM+1,indxD));
			}
			if(inputString.substring(indxD+1,indxH).equals("0")){
				arr_lst.add("");
			}else{
				arr_lst.add(inputString.substring(indxD+1,indxH));
			}
		}
		return arr_lst;
	}
%>
</body>
</html>
<%

}catch ( Exception e ){ 
	//out.println(e);
	e.printStackTrace();
	
}finally{
	try
	{
		if(pstmt !=null) pstmt.close();
		if(rs != null) rs.close();
	}catch(Exception ce){out.println(ce);}

	ConnectionManager.returnConnection(conn,request);
}
}catch(Exception e)
{
	e.printStackTrace();
}
%>

