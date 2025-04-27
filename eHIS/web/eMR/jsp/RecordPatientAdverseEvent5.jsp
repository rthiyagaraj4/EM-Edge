<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.PreparedStatement,java.sql.ResultSet, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="adverseReaction1" class="webbeans.eCommon.RecordSet" scope="session"/>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>


<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
  <script language="javascript" src="../../eCommon/js/common.js" ></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
  <script language='javascript' src='../../eCommon/js/messages.js' ></script>
<!--   <script language='javascript' src='../../eMR/js/eMRmessages.js' ></script> -->
  <script language='javascript' src='../../eCommon/js/common.js' ></script>
  <script language='javascript' src='../../eCommon/js/dchk.js' ></script>
  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
  <script language='javascript' src="../../eMR/js/RecordPatientAdverseEvent.js"></script>
  <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
  <script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
  <script language="javascript" src="../../eMP/js/PatientRegistration.js"></script>
  <script language="javascript" src="../../eMP/js/ChangePatientDetails.js"></script>
  <script language="javascript" src="../../eMP/js/PatEncBanner.js"></script>
  <!--Added by Ashwini on 27-Mar-2020 for GHL-CRF-0614.1-->
  <script language='javascript' src='../../eMR/js/AllergenLookup.js'></script>
<script>
function showCalendar1(id, date_format,time_format,modal_yn) 
		{
			var locn = window.location.href;
		

			var el = document.getElementById(id);
			 var isModal="isDiv";
			 var timeSet="";
			if ( (date_format==undefined) || (date_format=='') || (date_format==null) || (date_format=='null'))
			{
					timeSet="dd/mm/yyyy"
			}
			else 
			{
					timeSet=date_format
			}
			if ( (time_format!=undefined) && (time_format!='') && (time_format!=null) && (time_format!='null') )
			{
				timeSet = timeSet +' '+ time_format;
			}
			if ( ( ! document.getElementById("CACalanderFun") ) && (eval("document.all."+id+".type") !='hidden') )
			{
				document.getElementById(id).blur();
			}

			if(enableFlag)
			{
				
					return false;
			}
			else
			{
				
				enableFlag=true;
			}
			
			timeSet = timeSet+"&locn="+locn;
			showInModal(el,timeSet);
			
			return false;
			

		}
	function display_clock()
	{
		
		if(document.forms[0].estimated_duration.checked == true)
		parent.Headerpage.document.getElementById("clock1").style.visibility="visible";
	}
</script>
</head>
<%
String PatientId=request.getParameter("PatientId");
String sPhInstalled_YN = request.getParameter("sPhInstalled_YN"); //against TTM-SCF-0107
if(PatientId ==null) PatientId="";
PatientId=java.net.URLDecoder.decode(PatientId);
  /*Added by Thamizh selvi on 20th Dec 2017 for ML-MMOH-CRF-0751 Start*/
  Boolean isOthAllergenAppl = false;
  String otherAllergenDesc = "";
  /*End*/
//Added by Ashwini on 27-Mar-2020 for GHL-CRF-0614.1
String facility_id = (String)session.getValue("facility_id");
Boolean isExtGenericAppl = false;

  Connection con = ConnectionManager.getConnection(request);
  ResultSet rs = null;
  Statement stmt = null;
	try 
	{
		String allergy_conf_reqd_yn=checkForNull(request.getParameter("allergy_conf_reqd_yn"),"N");//Added for the CRF - RUT-CRF-0064
		String disable_allergy_event_type=checkForNull(request.getParameter("disable_event_type"));//Added for the CRF - RUT-CRF-0064
		String disable_known_allergy=checkForNull(request.getParameter("disable_known_allergy"));//Added for the CRF - RUT-CRF-0064		
         /*Below line added for this CRF Bru-HIMS-CRF-133*/	
        String isPatientEncMovement=request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");
        String Sydate=request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
        String p_queue_date=request.getParameter("p_queue_date")==null?"":request.getParameter("p_queue_date");
        String p_queue_status=request.getParameter("p_queue_status")==null?"":request.getParameter("p_queue_status");
	  //End this CRF Bru-HIMS-CRF-133		
		
		String locale = (String)session.getAttribute("LOCALE");
		stmt=con.createStatement();
		String sys_date="";
		String currentdate1 ="";
		String onsetdate="";
		String status_pass="";
		String dob="";
		String dob_hh="";
		String age="";
		int chkDay=0;
		int chkMon=0;
		int chkyear=0;
try {
		isOthAllergenAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","OTH_ALLERGEN_FREE_TXT");//Added by Thamizh selvi on 20th Dec 2017 for ML-MMOH-CRF-0751
		isExtGenericAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"PH","PH_THIRDPARTY_TYPE_APPL");//Added by Ashwini on 13-May-2020 for GHL-CRF-0614.1

		String sql="SELECT TO_CHAR ( c.date_of_birth, 'dd/mm/yyyy') dob, TO_CHAR ( c.date_of_birth, 'dd/mm/yyyy hh24:mi:ss') dob_hh ,get_age(c.date_of_birth,nvl(c.DECEASED_DATE,sysdate)) age,(select to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') SystemDate  from dual) SystemDate FROM mp_patient c WHERE patient_id='"+PatientId+"'";
		rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			
			sys_date=rs.getString("SystemDate");
			dob=rs.getString("dob");
			dob_hh=rs.getString("dob_hh");
			age=rs.getString("age");

		}
		if(rs !=null) rs.close();	
		 currentdate1 		= com.ehis.util.DateUtils.getCurrentDate("DMYHMS",locale);
		 onsetdate = currentdate1;
}catch(Exception e)
{
	out.println("inner catch line no.123 file name RecordPatientAdverseEvent5.jsp ==> :" +e);
	  e.printStackTrace();
}

        /*Below lines added by venkatesh.S against ML-MMOH-CRF-0366 */
		String onset_type=request.getParameter("onset_type");
		if(onset_type==null) onset_type="";
		String comments=request.getParameter("comments");
		if(comments==null) comments="";
		/*end ML-MMOH-CRF-0366 */
		
		String causative_code=request.getParameter("causative_code");
		if(causative_code==null) causative_code="";
		causative_code=java.net.URLDecoder.decode(causative_code);
		
		String advEventSrlNo = checkForNull(request.getParameter("advEventSrlNo"));//Added by Thamizh selvi on 22nd Dec 2017 against ML-MMOH-CRF-0751
		String adv_event_dtl_srl_no = checkForNull(request.getParameter("adv_event_dtl_srl_no"));//Added by Ashwini on 30-Nov-2020 for SKR-SCF-1499

		String reaction_date=request.getParameter("reaction_date");
		if(reaction_date ==null) reaction_date="";
		reaction_date=java.net.URLDecoder.decode(reaction_date);
		String onset_date=request.getParameter("onset_date");
		if(onset_date==null) onset_date="";
		onset_date=java.net.URLDecoder.decode(onset_date);
		String adv_event_type_ind_code=request.getParameter("adv_event_type_ind_code");
		if(adv_event_type_ind_code ==null) adv_event_type_ind_code="";
		adv_event_type_ind_code=java.net.URLDecoder.decode(adv_event_type_ind_code);

		String adv_event_type_code=request.getParameter("adv_event_type_code");
		if(adv_event_type_code ==null) adv_event_type_code="";
		adv_event_type_code=java.net.URLDecoder.decode(adv_event_type_code);

		String Certainity=request.getParameter("Certainity");
		if(Certainity ==null) Certainity="";
		Certainity=java.net.URLDecoder.decode(Certainity);

		String Certain = "";
			if(Certainity.equals("Definitive")) Certain="D";
			if(Certainity.equals("Probable")) Certain="P";
		

		String route_of_exposure = request.getParameter("route_of_exposure");
		if(route_of_exposure ==null ) route_of_exposure="";
		route_of_exposure=java.net.URLDecoder.decode(route_of_exposure);
		String severity_main=request.getParameter("severity_main");
		if(severity_main ==null) severity_main="";
		severity_main=java.net.URLDecoder.decode(severity_main);
		String mode=request.getParameter("mode");
		if(mode ==null || mode=="") mode="insert";

		String Encounter_Id=request.getParameter("Encounter_Id");
		if(Encounter_Id ==null) Encounter_Id="";
		String diagnosis_code=request.getParameter("diagnosis_code");
		if(diagnosis_code==null) diagnosis_code="";
		diagnosis_code=java.net.URLDecoder.decode(diagnosis_code);
		String severity_code=request.getParameter("severity_code");
		if(severity_code ==null)severity_code="";
		severity_code=java.net.URLDecoder.decode(severity_code);

		String active_date=request.getParameter("active_date");
		if(active_date ==null) active_date="";
		active_date=java.net.URLDecoder.decode(active_date);
		String Pract_id=request.getParameter("Pract_id");
		if(Pract_id ==null) Pract_id="";
		String practitioner_type=request.getParameter("practitioner_type");
		if(practitioner_type==null) practitioner_type="";
		String patient_class=request.getParameter("patient_class")==null?"":request.getParameter("patient_class");

		String causative_substance=request.getParameter("causative_substance")==null?"":request.getParameter("causative_substance");
		
		String drug_code_1	= request.getParameter("drug_code")==null?"":request.getParameter("drug_code"); //Added By Dharma on Jan 29th 2015 against ML-BRU-SCF-1520 [IN:053155]
		
		/*Below Line Commented by Senthil on 21-Nov-2011 [IN:026962]*/
		//causative_substance=java.net.URLDecoder.decode(causative_substance);
		

		String Locn_Code=request.getParameter("Locn_Code")==null?"":request.getParameter("Locn_Code");
		String location_type=request.getParameter("location_type")==null?"":request.getParameter("location_type");
		String speciality_code=request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
		
		

		String pat_obser = request.getParameter("source_of_info");
		if(pat_obser==null) pat_obser = "";
		pat_obser=java.net.URLDecoder.decode(pat_obser);

		String estimated_duration = request.getParameter("estimated_duration");
		if(estimated_duration==null) estimated_duration = "N";
		estimated_duration=java.net.URLDecoder.decode(estimated_duration);

		String check_estimate="";
		if(estimated_duration.equals("Y"))check_estimate="checked";
		else
			check_estimate="";

		String status_db = request.getParameter("status_db")==null?"":request.getParameter("status_db");
		status_db=java.net.URLDecoder.decode(status_db);
		status_pass = status_db;
if(status_db.equals("A"))
		{
			status_db =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
		}
		else if(status_db.equals("R"))
		{
			status_db =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Resolved.label","common_labels");
		}else if(status_db.equals("E"))
		{
			status_db =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
		}
		String active_diag_cnt="";
		String sel="";
		String allergen_desc="";

		int known_allergy = 0;
		String radio_check = "";
		String known_allergy_yn = "";
		String disable_kn =  "";
		String check1 = "";
		String check2 = "";
		String check3 = "";
		String check4 = "";
		String drug_code = "";
		/*Below lines added by venkatesh.S against ML-MMOH-CRF-0366 */
		String onset_type_checked_N="";
		String onset_type_checked_I="";
		String onset_type_checked_D="";
		String onset_type_disabled="";
		
		if(onset_type.equals("N")){
		onset_type_checked_N="checked";
		
		}else if(onset_type.equals("I")){
		onset_type_checked_I="checked";
		
		}else if(onset_type.equals("D")){
		onset_type_checked_D="checked";
		
		}
       /* end ML-MMOH-CRF-0366 */
	   
	 
	     
if(adv_event_type_ind_code.equals("01"))
		{
		check1 = "checked";
		check2 = "disabled";
		check3 = "disabled";
		check4 = "disabled";
		}
else if(adv_event_type_ind_code.equals("02"))
		{
		check1 = "disabled";
		check2 = "checked";
		check3 = "disabled";
		check4 = "disabled";
		}
		else if(adv_event_type_ind_code.equals("03"))
		{
		check1 = "disabled";
		check2 = "disabled";
		check3 = "checked";
		check4 = "disabled";
		}else if(adv_event_type_ind_code.equals("04"))
		{
		check1 = "disabled";
		check2 = "disabled";
		check3 = "disabled";
		check4 = "checked";
		}

		if(!mode.equals("insert") )
		{
			/*Added by Thamizh selvi on 22nd Dec 2017 against ML-MMOH-CRF-0751 Start*/
			if(isOthAllergenAppl && causative_code.equals("Oth")){
				
				String sql3=" SELECT other_allergen FROM pr_allergy_sensitivity WHERE patient_id = '"+PatientId+"' AND adv_event_type_ind = '"+adv_event_type_ind_code+"' AND adv_event_type = '"+adv_event_type_code+"' AND allergen_code = 'Oth' AND adv_event_srl_no = '"+advEventSrlNo+"' ";
				rs = stmt.executeQuery(sql3) ;
			
				if(rs !=null && rs.next())
					otherAllergenDesc = rs.getString("other_allergen");

			}/*End*/
			else if(!adv_event_type_code.equals("DA"))
			{
			String sql3=" select ALLERGEN_CODE ,LONG_DESC longdesc from MR_ALLERGEN_lang_vw where allergen_code='"+causative_code+"' and language_id='"+locale+"'";
			
			rs = stmt.executeQuery(sql3) ;
			
			if(rs !=null && rs.next())
				{
					allergen_desc=rs.getString("longdesc");
				
				}
			}else
			{

				
				String sql3="SELECT NVL((SELECT long_desc FROM mr_allergen  WHERE allergen_code = '"+causative_code+"'),(SELECT generic_name FROM ph_generic_name WHERE generic_id = '"+causative_code+"'))  longdesc FROM  dual "  ;

				

			if(rs!=null)rs.close();
			rs = stmt.executeQuery(sql3) ;	
			if(rs !=null && rs.next())
				{
					
					allergen_desc=rs.getString("longdesc");
				}

			}
		
		if(rs!=null)rs.close();
		
		}
			/*
			1.Commented On 6/7/2010 for PE
			2.Below two quries are combained to one.
			String sql_active_diag="SELECT count(*) FROM pr_problem WHERE patient_id='"+PatientId+"' AND problem_status='A'";
			if(rs!=null)rs.close();
			rs = stmt.executeQuery(sql_active_diag) ;	
			if(rs !=null && rs.next())
			{
				active_diag_cnt=rs.getString(1);
			}
		String sql_known_mp = "select known_allergy_yn from mp_patient where patient_id='"+PatientId+"'";
			rs = stmt.executeQuery(sql_known_mp) ;
			if(rs !=null && rs.next())
			{
				known_allergy_yn=rs.getString("known_allergy_yn");
			}
			if(rs!=null)rs.close();*/
			/*if(known_allergy_yn.equals("Y"))
			{
				radio_check = "checked";
				disable_kn  = "";
			}
			else{radio_check="";
			disable_kn = "disabled";
			}*/
			String SQL="SELECT (SELECT COUNT(*) FROM PR_PROBLEM WHERE PATIENT_ID='"+PatientId+"' AND PROBLEM_STATUS='A') COUNT,(SELECT KNOWN_ALLERGY_YN FROM MP_PATIENT WHERE PATIENT_ID='"+PatientId+"') KNOWN_ALLERGY_YN FROM DUAL";
			rs = stmt.executeQuery(SQL) ;
			while(rs.next()){
				active_diag_cnt	=rs.getString("COUNT");
				known_allergy_yn=rs.getString("KNOWN_ALLERGY_YN");
			}
			if(rs!=null)rs.close();
			//SCR #7520  1/13/2009
			if(known_allergy_yn.equals("Y")){
				radio_check = "";
				disable_kn  = "disabled";
			}else{
				radio_check="checked";
				disable_kn = "";
			}
			
			//Added for the CRF RUT-CRF-0064
			if(allergy_conf_reqd_yn.equals("Y")){
				radio_check="checked";
				disable_kn  = "disabled";
				disable_known_allergy="disabled";
				
				if(mode.equals("record")){
					radio_check="";
					disable_known_allergy="disabled";
				}
			}

		/*
		1.Commented On 6/7/2010 for PE.
		2.Below quries are combanied to One.
		String sql_known = "SELECT Count(*) FROM pr_allergy_sensitivity WHERE patient_id='"+PatientId+"' and STATUS ='A'  ";

			rs = stmt.executeQuery(sql_known) ;	
			if(rs !=null && rs.next())
			{
				known_allergy=rs.getInt(1);
			}
			if(rs!=null)rs.close();
			

		String sql_drug_code = "select DRUG_CODE code , DRUG_DESC description from  ph_drug_lang_vw where GENERIC_ID='"+causative_code+"' and language_id='"+locale+"' and DRUG_DESC = '"+causative_substance+"'";
		rs = stmt.executeQuery(sql_drug_code);

		if(rs!=null && rs.next())
		{
			drug_code = rs.getString("description");
		}*/
		
		//String SQL_KNOWN_DRUG="SELECT (SELECT COUNT(*) FROM PR_ALLERGY_SENSITIVITY WHERE PATIENT_ID='"+PatientId+"' AND STATUS ='A') COUNT,(SELECT DRUG_DESC DESCRIPTION FROM  PH_DRUG_LANG_VW WHERE GENERIC_ID='"+causative_code+"' AND LANGUAGE_ID='"+locale+"' AND DRUG_DESC = '"+causative_substance+"') DESCRIPTION FROM DUAL";
		
		/*Modified By Dharma on Jan 29th 2015 against ML-BRU-SCF-1520 [IN:053155] (drug_code column added) Start*/
		/*String SQL_KNOWN_DRUG="SELECT (SELECT COUNT(*) FROM PR_ALLERGY_SENSITIVITY WHERE PATIENT_ID='"+PatientId+"' AND STATUS ='A') COUNT,(SELECT DRUG_DESC DESCRIPTION FROM  PH_DRUG_LANG_VW WHERE GENERIC_ID='"+causative_code+"' AND LANGUAGE_ID='"+locale+"'AND DRUG_DESC = '"+causative_substance+"') DESCRIPTION FROM DUAL";*/
		

		String SQL_KNOWN_DRUG="SELECT (SELECT COUNT(*) FROM PR_ALLERGY_SENSITIVITY WHERE PATIENT_ID='"+PatientId+"' AND STATUS ='A') COUNT,(SELECT DRUG_DESC DESCRIPTION FROM  PH_DRUG_LANG_VW WHERE GENERIC_ID='"+causative_code+"' AND LANGUAGE_ID='"+locale+"'AND DRUG_DESC = '"+causative_substance+"' AND DRUG_CODE = '"+drug_code_1+"') DESCRIPTION FROM DUAL";
		
		/*Modified By Dharma on Jan 29th 2015 against ML-BRU-SCF-1520 [IN:053155] (drug_code column added) End*/
		    
			rs = stmt.executeQuery(SQL_KNOWN_DRUG) ;
			while(rs.next()){
				known_allergy	=rs.getInt("COUNT");
				drug_code		= checkForNull(rs.getString("DESCRIPTION"));
			}
			if(rs!=null)rs.close();
					String sys_date_time_disply=DateUtils.convertDate(sys_date,"DMYHMS","en",locale);
					String onset_date_disply=DateUtils.convertDate(onset_date,"DMYHMS","en",locale);
					String dob_hh_disply=DateUtils.convertDate(dob_hh,"DMYHMS","en",locale);
					String dob1=DateUtils.convertDate(dob,"DMY","en",locale);
					
		

%>


<body <%if(mode.equals("record")){%>onload='<%=adverseReaction1.clearAll()%>;visCausative();'<%}else{%>onload='setTimeout("disable()",500);visCausative();<%=adverseReaction1.clearAll()%>' <%}%> OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

 <!--;disable_curr_assement(this);'-->
  <form name = 'search_form'>
  <table border='1' width='100%'>
			<tr>
				<td class=LABEL><fmt:message key="eMR.Hypersensitivity.label" bundle="${mr_labels}"/> :</td>
				<td  class=MRALLERGY><fmt:message key="Common.Allergy.label" bundle="${common_labels}"/></td>
				<td  class=MRHYPERII><fmt:message key="eMR.TypeII.label" bundle="${mr_labels}"/></td>
				<td class=MRHEADER><fmt:message key="eMR.TypeIII.label" bundle="${mr_labels}"/></td>
				<td  class=ORBROWN><fmt:message key="eMR.TypeIV.label" bundle="${mr_labels}"/></td>
				<td  class=LABEL><fmt:message key="eMR.Recurrence.label" bundle="${mr_labels}"/> :</td>
				<td >
				<img src="../../eCommon/images/mandatory.gif"></img>
				<!-- <img  src="../../eCommon/images/mandatory.gif" align='center'></img> -->
				</td>
			</tr>
		</table>
	  		<table cellpadding='1'  border='0' cellspacing='0' width='100%' align='center' >

	<th align='left' width='25%' nowrap><fmt:message key="eMR.CurrentAssessment.label" bundle="${mr_labels}"/></th><th align=right  ><%if(mode.equals("insert")){%><input class=button style='background-color:#BD6981;' type="button"  name='eventdtlsID' id='eventdtlsID' value='<fmt:message key="Common.EventType.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/>'  onClick="expandColapseframe(this)" ><%}else{%><input class=button style='background-color:#9999FF;' type="button" id='eventdtlsID' name='hide' id='hide' value='<fmt:message key="Common.EventType.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/>' onClick="expandColapseframe(this)" <%if(!status_db.equals(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels"))){%>disabled <%}}%></th>
		</table>


		
	<table cellpadding='1'  border='0' cellspacing='0' width='100%' align='center' >
			<%if((known_allergy == 0 && (!(status_pass.equals("R") || status_pass.equals("E")))) || allergy_conf_reqd_yn.equals("Y")){ onset_type_disabled="disabled";%>
			<tr>
				
				<td class='label' width='20%' ><fmt:message key="Common.no.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.KnownAllergy.label" bundle="${common_labels}"/></td>
				<td class ='fields' width ='20%'><input type = 'checkbox' name='no_known_allergy' id='no_known_allergy' value='<%=known_allergy_yn%>' <%=disable_known_allergy%> <%=radio_check%> onclick='disable_curr_assement(this)' ></td>  
			<td colspan='4'></td>	
			</tr>
			<%}%>
			<tr>
			<%if(mode.equals("insert")){%>
				<td class='label' width='20%' ><fmt:message key="eMR.Hypersensitivity.label" bundle="${mr_labels}"/></td>
				<td class='fields' width='30%' ><fmt:message key="Common.Allergy.label" bundle="${common_labels}"/><input type=radio name='adv_event_ind' id='adv_event_ind' checked value='01' onclick='change_val_allergy(this)'>&nbsp;&nbsp;<fmt:message key="eMR.TypeII.label" bundle="${mr_labels}"/><input type=radio name='adv_event_ind_one' id='adv_event_ind_one' Value='02' onclick='change_val_allergy(this)'> &nbsp;&nbsp;<fmt:message key="eMR.TypeIII.label" bundle="${mr_labels}"/><input type=radio name='adv_event_ind_two' id='adv_event_ind_two' Value='03' onclick='change_val_allergy(this)'> &nbsp;&nbsp;<fmt:message key="eMR.TypeIV.label" bundle="${mr_labels}"/><input type=radio name='adv_event_ind_three' id='adv_event_ind_three' Value='04' onclick='change_val_allergy(this)'></td>
				<%}else{%>
				<td class='label' width='20%' ><fmt:message key="eMR.Hypersensitivity.label" bundle="${mr_labels}"/></td>
				<td class='fields' width='30%' ><fmt:message key="Common.Allergy.label" bundle="${common_labels}"/><input type=radio name='adv_event_ind' id='adv_event_ind'  value='01' <%=check1%>>&nbsp;&nbsp;<fmt:message key="eMR.TypeII.label" bundle="${mr_labels}"/><input type=radio name='adv_event_ind_one' id='adv_event_ind_one' Value='02' <%=check2%>> &nbsp;&nbsp;<fmt:message key="eMR.TypeIII.label" bundle="${mr_labels}"/><input type=radio name='adv_event_ind_two' id='adv_event_ind_two' Value='03' <%=check3%>> &nbsp;&nbsp;<fmt:message key="eMR.TypeIV.label" bundle="${mr_labels}"/><input type=radio name='adv_event_ind_three' id='adv_event_ind_three' Value='04'  <%=check4%>></td>
				
		<%}if(mode.equals("insert")){%>
					<td class='label' width='25%' ><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
					<td class='fields'  width='25%' ><select id='adverse_even_type' name='adv_event_type' id='adv_event_type'  onchange='show_table(this);populate_allergen(this)' <%=disable_allergy_event_type %>>
					<option value=''  align=center>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------------</option>
					</select><img src='../../eCommon/images/mandatory.gif' align='center' id='adv_code' ></img></td>

				<%}else{%>
					<td class='label' width='25%' ><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%' ><select id='adverse_even_type' name='adv_event_type' id='adv_event_type' disabled >
						<%
						if (rs!=null) rs.close();
						String sql1="Select a.long_desc long_desc,a.ADV_EVENT_TYPE_CODE ,b.ADV_EVENT_TYPE_IND from MR_ADV_EVENT_TYPE_LANG_VW a , MR_ADV_EVENT_TYPE_DETAIL b where a.ADV_EVENT_TYPE_CODE=b.ADV_EVENT_TYPE_CODE and language_id='"+locale+"' and b.ADV_EVENT_TYPE_IND='"+adv_event_type_ind_code+"'  and a.eff_status='E' and a.ADV_EVENT_TYPE_CODE='"+adv_event_type_code+"'";
						
						rs=stmt.executeQuery(sql1);
						if(rs !=null)
							{
								while(rs.next())
								{
									String adv_event_code=rs.getString("ADV_EVENT_TYPE_CODE");
									String adv_event_code_desc=rs.getString("long_desc");
									if(adv_event_code.equals(adv_event_type_code)){
											sel="selected";
									}else{
											sel="";
									}
									out.println("<option value='"+adv_event_code+"'"+sel+">"+adv_event_code_desc);
								}
							}
						%>
						</select><img src='../../eCommon/images/mandatory.gif' align='center' id='adv_code' ></img></td>
				<%}%>
				<td colspan='4'></td>
			</tr>

			<tr>
					<td   class='label' width='20%'><fmt:message key="eMR.Allergen.label" bundle="${mr_labels}"/></td>
				<%if(mode.equals("insert")){%>
					<td class='fields' width='30%'><input type='text' disabled name='allergen' id='allergen'  value='' size='20' maxlength='20' onblur='open_lookup(this);enable_reaction(this);'><input disabled  type='button' class='BUTTON' name='drug_search' id='drug_search' value='?' onClick='open_lookup();enable_reaction(this)'><img src='../../eCommon/images/mandatory.gif' align='center' id='adv_code_allerg' ></img></td>
				<%}else{%>
					<td class='fields' width='30%'>	<input type='text' disabled name='allergen' id='allergen' readOnly value='<%=allergen_desc%>' size='40' maxlength='40'><input disabled type='button' class='BUTTON' name='drug_search' id='drug_search' value='?' ><img src='../../eCommon/images/mandatory.gif' align='center' id='adv_code_allerg' ></img></td>
				<%}
				/*Added by Thamizh selvi on 20th Dec 2017 for ML-MMOH-CRF-0751 Start*/
				if(isOthAllergenAppl){ %>
					<td class='label' width='25%'><fmt:message key="Common.other.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMR.Allergen.label" bundle="${mr_labels}"/></td>
					<% if(mode.equals("insert")){ %>
						<td class='fields' id='free_txt' width='25%'><textarea name='allergen_free_text'  maxlength="50" rows='2' cols='35' onkeyup="return checkMaxLength(this);" onblur="enableDisableAllergLkp(this);enable_reaction(this)" disabled></textarea><img src='../../eCommon/images/mandatory.gif' align='center' id='free_txt_mand' ></img></td>
					<% }else{ %>
						<td class='fields' id='free_txt' width='25%'><textarea name='allergen_free_text' maxlength="50" rows='2' cols='35' disabled><%=otherAllergenDesc%></textarea><img src='../../eCommon/images/mandatory.gif' align='center' id='free_txt_mand'></img></td>
					<% } %>
				<% }else{ %><!--End-->
					<%if(mode.equals("insert")){
						%>
					<td class='label' width='20%'><fmt:message key="eMR.CausativeSubstance.label" bundle="${mr_labels}"/></td>
							<td class='fields' id='cause_subs' name='cause_subs' width='30%'><textarea name='cause_sub'  maxlength="100" rows='1' cols='25' value=''  onkeypress="return CheckForSpecChars_spec(event);" onkeyup="return checkMaxLength(this);" disabled></textarea><img  id='Causative_sub' align='center' style="visibility:hidden" src="../../eCommon/images/mandatory.gif"></img></td>
					<%}else{%>
						<%
					
					if(!adv_event_type_code.equals("DA")) {
						%>
						<td class='label' width='20%'><fmt:message key="eMR.CausativeSubstance.label" bundle="${mr_labels}"/></td>
					  <td class='fields' id='cause_subs' name='cause_subs' width='30%'><textarea name='cause_sub' onkeypress="return CheckForSpecChars_spec(event);" maxlength="100" rows='1' cols='25' value=''  disabled><%=causative_substance%></textarea><img  id='Causative_sub' align='center' style="visibility:hidden"  src="../../eCommon/images/mandatory.gif"></img></td>
							<%}else{%>
							<td class='label' width='20%'><fmt:message key="eMR.CausativeSubstance.label" bundle="${mr_labels}"/></td>
							<td class='fields' width='30%'><input type='text' disabled name='cause_sub' id='cause_sub' readOnly value='<%=drug_code%>' size='30' maxlength='100'><input disabled type='button' class='BUTTON' name='cause_sub_search' id='cause_sub_search' value='?' ><img  id='Causative_sub' align='center' style="visibility:hidden"  src="../../eCommon/images/mandatory.gif"></img></td>
						<%}
					}%>
				<% } %>
				
		</tr>
		<!--Added by Thamizh selvi on 20th Dec 2017 for ML-MMOH-CRF-0751 Start-->
		<% if(isOthAllergenAppl){ %>
		<tr>
			<%if(mode.equals("insert")){
				%>
			<td class='label' width='20%'><fmt:message key="eMR.CausativeSubstance.label" bundle="${mr_labels}"/></td>
					<td class='fields' id='cause_subs' name='cause_subs' width='30%'><textarea name='cause_sub'  maxlength="100" rows='1' cols='25' value=''  onkeypress="return CheckForSpecChars_spec(event);" onkeyup="return checkMaxLength(this);" disabled></textarea><img  id='Causative_sub' align='center' style="visibility:hidden" src="../../eCommon/images/mandatory.gif"></img></td>
			<%}else{%>
				<%
			
			if(!adv_event_type_code.equals("DA")) {
				
				
				
				%>
				<td class='label' width='20%'><fmt:message key="eMR.CausativeSubstance.label" bundle="${mr_labels}"/></td>
			  <td class='fields' id='cause_subs' name='cause_subs' width='30%'><textarea name='cause_sub' onkeypress="return CheckForSpecChars_spec(event);" maxlength="100" rows='1' cols='25' value=''  disabled><%=causative_substance%></textarea><img  id='Causative_sub' align='center' style="visibility:hidden"  src="../../eCommon/images/mandatory.gif"></img></td>
					<%}else{%>
					<td class='label' width='20%'><fmt:message key="eMR.CausativeSubstance.label" bundle="${mr_labels}"/></td>
					<td class='fields' width='30%'><input type='text' disabled name='cause_sub' id='cause_sub' readOnly value='<%=drug_code%>' size='30' maxlength='100'><input disabled type='button' class='BUTTON' name='cause_sub_search' id='cause_sub_search' value='?' ><img  id='Causative_sub' align='center' style="visibility:hidden"  src="../../eCommon/images/mandatory.gif"></img></td>
				<%}
			}%>
		</tr>
		<% } %>
		<!--End-->

			<tr>
				<td colspan='8'>
					<table cellpadding='0'  border='0' cellspacing='0' width='100%' align='center'>
					<tr>
					<td class='label' width='20%'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>
					
				<%if(mode.equals("insert")){%>
				
					<td class="fields" width='20%'>
					<input type='hidden' name='currentdateTime' id='currentdateTime' value='<%=sys_date_time_disply%>'>
					<input type='text'  name='onset_date' id='onset_date' value='<%=sys_date_time_disply%>' onblur='validateDate(this);calcfields(this,ServerDate,onset_date);DateChk(currentdateTime,this); /*defaultdmy();*/ ' maxlength="20" size="15"><img src="../../eCommon/images/CommonCalendar.gif"  id='cal2' name='cal2' onClick="document.getElementById('onset_date').focus();return showCalendar('onset_date',null,'hh:mm:ss');"/>					
					<img  id='clock' src='../../eCA/images/mc_history.gif' BORDER='0' style='visibility:hidden'>
					
					
					</td>
				<%}else{%>
					<td class="fields" width='20%' ><input type='text'  name='onset_date' id='onset_date' disabled value='<%=onset_date_disply%>' maxlength="20" size="20"><img src="../../eCommon/images/CommonCalendar.gif" disabled id='cal2' name='cal2'  onClick="document.getElementById('onset_date').select();return showCalendar('onset_date',null);calcfields(this,ServerDate,onset_date);">
					<img id='clock'  src='../../eCommon/images/mc_history.gif' <%if(estimated_duration.equals("N")){%> BORDER='0' style='visibility:hidden' <%}%>disabled>
					

					</td>
				<%}%>		
			<%if(mode.equals("insert")){%>	
				<td class='label' width = '15%'><fmt:message key="eMR.EstimatedDuration.label" bundle="${mr_labels}"/></td>
				<td class="fields" width='5%'><input type = 'checkbox' name = 'estimated_duration' onclick='enable_dmy();calcfields(onset_date,ServerDate,onset_date);' value='N'></td>
			<%}else{%>	
			<td class='label' width = '15%'><fmt:message key="eMR.EstimatedDuration.label" bundle="${mr_labels}"/></td>
				<td class="fields" width='5%'><input type = 'checkbox' name = 'estimated_duration' value='<%=estimated_duration%>' disabled <%=check_estimate%> ></td>
				<%}%>
				<td class='label' width='15%'><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Last.label" bundle="${common_labels}"/></td>
				
				<td class="fields" width='25%'>
				<input type="text" name="b_days" id="b_days" maxlength="2" size="2" value=''
				onKeyPress='return(ChkNumberInput(this,event,0))'onBlur= 'CheckForNumber_L(this,onset_date);checkDays(this,onset_date); calci(this,"DMYHMS","<%=locale%>",onset_date);'   tabIndex='1' disabled>&nbsp;D
				&nbsp;&nbsp;<input type="text" name="b_months" id="b_months" maxlength="2" value='' size="2"
				onKeyPress='return(ChkNumberInput(this,event,0))'		onBlur='CheckForNumber_L(this,onset_date);checkMonth(this,onset_date);
				

				 calci(this,"DMYHMS","<%=locale%>",onset_date); '   tabIndex='2' disabled>&nbsp;M
				&nbsp;&nbsp;<input type="text" name="b_age" id="b_age" maxlength="3" size="3" value=''  
				onKeyPress='return(ChkNumberInput(this,event,0))'
				onBlur='CheckForNumber_L(this,onset_date);calci(this,"DMYHMS","<%=locale%>",onset_date)'   tabIndex='3' disabled>&nbsp;Y</td>
				<tr>
				</table>
				</td>
			</tr>
			
			<tr>
		
	<td  class="label"><fmt:message key="Common.AllergyAlertby.label" bundle="${common_labels}"/></td>			
	<td class='fields' >
	<%
	if(mode.equals("insert")){%>	
		<SELECT name="allergyAlertby" id="allergyAlertby" id='allergyAlert'onchange ="visCausative()" 
		disabled >
			<option value='N'><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>
			<option value='A'><fmt:message key="Common.ATC.label" bundle="${common_labels}"/></option>
			<option value='G'><fmt:message key="Common.generic.label" bundle="${common_labels}"/></option>
			<option value='D'><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
			</SELECT>
			
		<%} else{%>
			
	  <SELECT name="allergyAlertby" id="allergyAlertby"  id='allergyAlert' onchange ="visCausative()" disabled>
  <%
	try {
		String allergyAle="select  ALLERGY_ALERT_BY from PR_ADVERSE_EVENT where  allergen_code='"+causative_code+"'  and patient_id='"+PatientId+"' and ADV_EVENT_DTL_SRL_NO='"+adv_event_dtl_srl_no+"' ";
		//Modified by Ashwini on 30-Nov-2020 for SKR-SCF-1499
			rs = stmt.executeQuery(allergyAle);
      		if(rs != null) {
      			while(rs.next()) {
				String classcode  	= rs.getString("ALLERGY_ALERT_BY");
			if(classcode.equals("N"))	{
       %>
			<option value='<%=classcode%>'><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>
				<%} else if(classcode.equals("A")){%>
       <option value='<%=classcode%>'><fmt:message key="Common.ATC.label" bundle="${common_labels}"/></option>
       <%} else if(classcode.equals("G")){%>
        <option value='<%=classcode%>'><fmt:message key="Common.generic.label" bundle="${common_labels}"/></option>
         <%} else { %>
          <option value='<%=classcode%>'><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
<%    			
         }
			}
      		}
	}catch(Exception e) { out.println(e.toString());}
	finally {
		if(stmt !=null) stmt.close();
		if(rs !=null) rs.close();
	}
		}
%>
			</td>
			</tr>
			 <!-- Below lines added by venkatesh.S against ML-MMOH-CRF-0366 -->
			 <%
			 if(mode.equals("insert")){%>
				<tr>
					<td  class="label"><fmt:message key="eCA.Onset.label" bundle="${ca_labels}"/></td>		
				<td class='fields'>
				<fmt:message key="eMR.NotKnown.label" bundle="${mr_labels}"/><input id='onset_1' type='radio'  name='onset' id='onset' value='N' checked onClick='onSet_Check(this)'  <%=onset_type_disabled%> >
				<fmt:message key="eAE.Immediate.label" bundle="${ae_labels}"/><input id='onset_2' type='radio'  name='onset' id='onset' value='I'  onClick='onSet_Check(this)'  <%=onset_type_disabled%> >
				<fmt:message key="eMR.Delayed.Label" bundle="${mr_labels}"/><input id='onset_3' type='radio'  name='onset' id='onset' value='D'  onClick='onSet_Check(this)' <%=onset_type_disabled%> >
				 </td>	
  
                   <td class='label'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Comments.label" bundle="${common_labels}"/></td>
				<td class='fields' id='comments' width='25%'><textarea  name='comments'  onkeypress="return CheckForSpecChars_spec1(event);" onkeyup="return checkMaxLength(this);" maxlength="300"  cols='25' value=''   <%=onset_type_disabled%> ></textarea></td> 
    </tr>  
	       <%}else{%>
	            <tr>
					<td  class="label"><fmt:message key="eCA.Onset.label" bundle="${ca_labels}"/></td>		
				<td class='fields'>
				<fmt:message key="eMR.NotKnown.label" bundle="${mr_labels}"/><input id='onset_1' type='radio'  name='onset' id='onset' value='N'  <%=onset_type_checked_N%> onClick='onSet_Check(this)' disabled >
				<fmt:message key="eAE.Immediate.label" bundle="${ae_labels}"/><input id='onset_2' type='radio'  name='onset' id='onset' value='I'  <%=onset_type_checked_I%>  onClick='onSet_Check(this)'  disabled >
				<fmt:message key="eMR.Delayed.Label" bundle="${mr_labels}"/><input id='onset_3' type='radio'  name='onset' id='onset' value='D'  <%=onset_type_checked_D%> onClick='onSet_Check(this)' disabled >
				 </td>	
  
                   <td class='label'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Comments.label" bundle="${common_labels}"/></td>
				 <td class='fields' id='comments' width='25%'><textarea  name='comments'  onkeypress="return CheckForSpecChars_spec1(event);" onkeyup="return checkMaxLength(this);" maxlength="300"  cols='25' value=''  disabled ><%=comments%></textarea></td> 
                 </tr>  
	        <%}%>
			<!-- end ML-MMOH-CRF-0366 -->

    </table>
	    <input type='hidden' name='call_function' id='call_function' value=''></input>
		<input type='hidden' name='react_values' id='react_values' value=''> 
		<input type='hidden' name='reactCodes3' id='reactCodes3' value=''> 
		<input type='hidden' name='sysdate' id='sysdate' value='<%=sys_date%>'>
		<input type='hidden' name='adv_evnt_ind' id='adv_evnt_ind' value=''>
		<input type='hidden' name='PatientId' id='PatientId' value='<%=PatientId%>'>
		<input type='hidden' name='on_set_date' id='on_set_date' value=''>
		<input type='hidden' name='flag_val' id='flag_val' value=''>
		<input type='hidden' name='allergen_id' id='allergen_id' value=''>
		<input type='hidden' name='causative_code' id='causative_code' value='<%=causative_code%>'>
		<input type='hidden' name='mode' id='mode' value='<%=mode%>'> 
		<input type='hidden' name='Certainity' id='Certainity' value='<%=Certainity%>'>
		<input type='hidden' name='Encounter_Id' id='Encounter_Id' value='<%=Encounter_Id%>'>
		<input type='hidden' name='severity_head' id='severity_head' value='<%=severity_code%>'>
		<input type='hidden' name='severity_main' id='severity_main' value='<%=severity_main%>'>
		<input type='hidden' name='active_diag_cnt' id='active_diag_cnt' value='<%=active_diag_cnt%>'>
		<input type='hidden' name='Pract_id' id='Pract_id' value='<%=Pract_id%>'>
		<input type='hidden' name='practitioner_type' id='practitioner_type' value='<%=practitioner_type%>'>
		<input type='hidden' name='patient_class' id='patient_class' value='<%=patient_class%>'>
		<input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate1%>'>
		<input type='hidden' name='ServerDate' id='ServerDate' value='<%=onsetdate%>'>
		<input type="hidden" name="Dob" id="Dob" value ='<%=dob1%>'>
		<input type="hidden" name="dob_hh_disply" id="dob_hh_disply" value ='<%=dob_hh_disply%>'>
		<input type="hidden" name="locale" id="locale" value ='<%=locale%>'>
		<input type="hidden" name="drug_code" id="drug_code" value =''>
		<input type="hidden" name="adv_event_type_ind_code" id="adv_event_type_ind_code" value ='<%=adv_event_type_ind_code%>'>
		<input type="hidden" name="known_allergy" id="known_allergy" value ='<%=known_allergy%>'>
		<input type="hidden" name="pat_obser" id="pat_obser" value ='<%=pat_obser%>'>
		<input type="hidden" name="Certain" id="Certain" value ='<%=Certain%>'>
		<input type="hidden" name="route_of_exposure" id="route_of_exposure" value ='<%=route_of_exposure%>'>
		<input type="hidden" name="onset_date_disply" id="onset_date_disply" value ='<%=onset_date_disply%>'>
		<input type="hidden" name="diagnosis_code" id="diagnosis_code" value ='<%=diagnosis_code%>'>

		<input type="hidden" name="event_status" id="event_status" value =''>
		<input type="hidden" name="since_date" id="since_date" value =''>
		<input type="hidden" name="event_since_date" id="event_since_date" value =''>
		<input type="hidden" name="event_certainty" id="event_certainty" value =''>
		<input type="hidden" name="event_exposure" id="event_exposure" value =''>
		<input type="hidden" name="event_infosource" id="event_infosource" value =''>
		<input type="hidden" name="event_observation" id="event_observation" value =''>
		<input type="hidden" name="event_advice" id="event_advice" value =''>
		<input type="hidden" name="event_remarks" id="event_remarks" value =''>
		<input type="hidden" name="event_diag" id="event_diag" value =''>
		<input type="hidden" name="event_err_remark" id="event_err_remark" value =''>
		<input type="hidden" name="adv_event_type_code" id="adv_event_type_code" value ='<%=adv_event_type_code%>'>
		<input type="hidden" name="chkDay" id="chkDay" value ='<%=chkDay%>'>
		<input type="hidden" name="chkMon" id="chkMon" value ='<%=chkMon%>'>
		<input type="hidden" name="chkyear" id="chkyear" value ='<%=chkyear%>'>
		<input type="hidden" name="sysDate" id="sysDate" value ='<%=sys_date_time_disply%>'>
		<input type="hidden" name="status_db" id="status_db" value ='<%=status_db%>'>
		<input type="hidden" name="status_pass" id="status_pass" value ='<%=status_pass%>'>
		<input type="hidden" name="reaction_date" id="reaction_date" value ='<%=reaction_date%>'>
		<input type="hidden" name="evnt_dtl_modified_yn" id="evnt_dtl_modified_yn" value ='N'>
		<input type="hidden" name="Locn_Code" id="Locn_Code" value ='<%=Locn_Code%>'>
		<input type="hidden" name="location_type" id="location_type" value ='<%=location_type%>'>
		<input type="hidden" name="speciality_code" id="speciality_code" value ='<%=speciality_code%>'>
		<input type="hidden" name="allergy_conf_reqd_yn" id="allergy_conf_reqd_yn" value ='<%=allergy_conf_reqd_yn%>'><!-- Added for the CRF RUT-CRF-0064 -->
		 <input type='hidden' name='retVal' id='retVal' value=''>
		

<!-- 9/29/2008 --->
		<input type="hidden" name="tepDate" id="tepDate" value ='<%=onset_date_disply%>'>
		<!-- 9/29/2008 onset date --->
		<input type="hidden" name="flag" id="flag" value =''>
		<input type="hidden" name="flag1" id="flag1" value ='x'>
		<input type="hidden" name="changeonsetflag" id="changeonsetflag" value ='N'>
		<!-- Below line added for this CRF Bru-HIMS-CRF-133 -->
		<input type="hidden" name="isPatientEncMovement" id="isPatientEncMovement" value="<%=isPatientEncMovement%>">
		<input type="hidden" name="Sydate" id="Sydate" value="<%=Sydate%>">
		<input type="hidden" name="p_queue_date" id="p_queue_date" value="<%=p_queue_date%>">
		<input type="hidden" name="p_queue_status" id="p_queue_status" value="<%=p_queue_status%>">
		<!-- End Bru-HIMS-CRF-133 -->
		<!-- Below lines added by venkatesh.S against ML-MMOH-CRF-0366 -->
	   <input type='hidden' name='onset_type' id='onset_type' value='N'> 
	   <!-- end ML-MMOH-CRF-0366 -->
		<input type='hidden' name = 'sPhInstalled_YN' value='<%=sPhInstalled_YN%>'> <!-- against TTM-SCF-0107 -->
		<!--Added by Thamizh selvi on 2nd Jan 2018 for ML-MMOH-CRF-0751 Start-->
		<input type='hidden' name = 'isOthAllergenAppl' value='<%=isOthAllergenAppl%>'> 
		<input type='hidden' name = 'advEventSrlNo' value='<%=advEventSrlNo%>'>
		<!--End-->
		
		<!--Added by Ashwini on 27-Mar-2020 for GHL-CRF-0614.1-->
		<input type='hidden' name = 'facility_id' value='<%=facility_id%>'>
		<input type='hidden' name = 'isExtGenericAppl' value='<%=isExtGenericAppl%>'>
		
	 <%
     } catch(Exception e) {
		 //out.println("Final catch in line no619 fine name is RecordPatientAdverseEvent5.jsp :" +e);
		  e.printStackTrace();
         if (stmt != null) stmt.close();
     }
     finally {
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
		  ConnectionManager.returnConnection(con,request);
     }
%>
  </form>
</body>
<!--Added by Thamizh selvi on 20th Dec 2017 for ML-MMOH-CRF-0751 Start-->
<script>
	if(document.forms[0].mode.value != "insert" && document.forms[0].isOthAllergenAppl.value == "true"){
		if(document.forms[0].allergen.value == "")
			document.forms[0].adv_code_allerg.style.visibility = 'hidden';
		else
			document.forms[0].free_txt_mand.style.visibility = 'hidden';
	}
</script>
<!--End-->
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

