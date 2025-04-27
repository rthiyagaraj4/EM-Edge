<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
///+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/// Module			: OP
/// Created By		: SRIDHAR R 
/// Created Date	: 3 JUNE 2004
/// Function		: This is a common component for Referral Details that can be included & called from any Module.

// Page included from these foll Modules..
//Module->	Function name
//------------------------
// IP	->	Register InPatient Referral
// IP	->	Discharge Advice
// IP	->	Discharge Patient
// OP	->	Check OUT
// AE	->	Check OUT

/* Example...
	<jsp:include page="../../eOP/jsp/ReferralDetailsComponent.jsp" flush="true" > 
		<jsp:param name ="bodyFrame" value= "Main Frame Reference" /> 	
		<jsp:param name ="submitFrame" value= "Messaage or Submit Frame Reference" /> 	
		-------------
	</jsp:include>*/
///+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
%>

<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,org.json.simple.*,com.ehis.util.* ,eCommon.XSSRequestWrapper" %>
<%
    String locale =((String)session.getAttribute("LOCALE"));
	String facility_id	= (String) session.getValue( "facility_id" ) ;
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>

<%
	Connection con			=	null; 
	PreparedStatement pstmt = null;
	
	ResultSet rs			=	null;
		
%>
<HTML>
<HEAD>

<%
		String function_id	= request.getParameter("function_id");
			if(function_id	== null) function_id = "";	
		
			String functionid	= request.getParameter("functionid");
			if(functionid	== null) functionid = "";	
			

		String called_from	= request.getParameter("called_from");
			if(called_from	== null) called_from = "";	

		String patient_status	= request.getParameter("patient_status");
			if(patient_status	== null) patient_status = "";	
			/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/ 
			String referral_id	= request.getParameter("referral_id");
			if(referral_id	== null) referral_id = "";	
			String recFun	= request.getParameter("recFun");
			if(recFun	== null) recFun = "";	
			String recFunVal	= request.getParameter("recFunVal");
			if(recFunVal	== null) recFunVal = "";	
			String to_pract_id	= request.getParameter("to_pract_id");
			if(to_pract_id	== null) to_pract_id = "";	
			String to_pract_desc	= request.getParameter("to_pract_desc");
			if(to_pract_desc	== null) to_pract_desc = "";	
			String referral_reason_code	= request.getParameter("referral_reason_code");
			if(referral_reason_code	== null) referral_reason_code = "";	
			String referral_reason_desc	= request.getParameter("referral_reason_desc");
			if(referral_reason_desc	== null) referral_reason_desc = "";	
			String encounter_id=checkForNull(request.getParameter("from_encounter_id"));
			String transfer_case_yn=checkForNull(request.getParameter("transfer_case_yn"),"N");
			String to_pract_name=checkForNull(request.getParameter("to_pract_name"));
			String to_locn_desc=checkForNull(request.getParameter("to_locn_desc"));
			String to_service_desc=checkForNull(request.getParameter("to_service_desc"));
			/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/ 
		String discharge_indicator	= request.getParameter("discharge_indicator");
			if(discharge_indicator	== null) discharge_indicator = "";	

		// For IP Module Discharge Patient Function. To Default the values., Starts.
		String ref_type = request.getParameter("ref_type");
			if(ref_type == null)  ref_type = "";

		String ref_hcare_setting_type = request.getParameter("ref_hcare_setting_type");
			if(ref_hcare_setting_type == null)  ref_hcare_setting_type = "";

		String referred_to_value = request.getParameter("referred_to_value");
			if(referred_to_value == null)  referred_to_value = "";

		String ref_priority  = request.getParameter("ref_priority");
			if(ref_priority == null) ref_priority = "";

		String preferred_treatment_date  = request.getParameter("preferred_treatment_date");
			if(preferred_treatment_date != null)
			{
				preferred_treatment_date=DateUtils.convertDate(preferred_treatment_date,"DMY","en",localeName);
			}
			else
			preferred_treatment_date = "";

		String ref_specialty  = request.getParameter("ref_specialty");
			if(ref_specialty == null) ref_specialty = "";
		
		String ref_service_code  = request.getParameter("ref_service_code");
			if(ref_service_code == null) ref_service_code = "";

		String ref_locn_type  = request.getParameter("ref_locn_type");
			if(ref_locn_type == null) ref_locn_type = "";

		String ref_locn_code  = request.getParameter("ref_locn_code");
			if(ref_locn_code == null) ref_locn_code = "";

		String ref_locn_desc  = request.getParameter("ref_locn_desc");
			if(ref_locn_desc == null) ref_locn_desc = "";

		String referred_for  = request.getParameter("referred_for");
			if(referred_for == null) referred_for = "";

		String referral_notes_value  = request.getParameter("referral_notes");
			if(referral_notes_value == null) referral_notes_value = "";

			String splty_desc="";
			String ServiceDesc="";
		
		
		// For IP Module Discharge Patient Function. End.

%>

<TITLE><fmt:message key="Common.DischargeAdvise.label" bundle="${common_labels}"/></TITLE>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../html/text.css'></link>
	<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
	<!--  -->
	<script src='../../eMP/js/ReferralDtls.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>

	<!--Below line Added for this CRF  Bru-HIMS-CRF-261 -->		
	<script src='../../eIP/js/AdmitPatient2.js' language='javascript'></script>
	<script src='../../eIP/js/AdmitPatient.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
function Quickadmission(){	
	if(document.forms[0].quick_admission){
	if(document.forms[0].quick_admission.checked){
    for(var k=0; k< document.forms[0].referral_type.length; k++){	
	if(document.forms[0].referral_type[k].value=="L"){
	document.forms[0].referral_type.value=document.forms[0].referral_type[k].value;
	document.forms[0].referral_type.disabled=true;
	getval1(document.forms[0].referral_type);
	}	
  }

 for(var i=0; i< document.forms[0].ref_for_ip.length; i++){	
	if(document.forms[0].ref_for_ip[i].value=="A"){
	document.forms[0].ref_for_ip.value=document.forms[0].ref_for_ip[i].value;
	document.forms[0].ref_for_ip.disabled=true;
	    }
	}
	
	

for(var r=0; r< document.forms[0].priority.length; r++){	
	if(document.forms[0].priority[r].value=="L"){
	document.forms[0].priority.value=document.forms[0].priority[r].value;	
	    }
	}	

if(document.getElementById('locntion_img')) 
document.getElementById('locntion_img').style.visibility	= 'visible';
if(document.getElementById('PractImg')) 
document.getElementById('PractImg').style.visibility	= 'visible';		
if(document.getElementById('bedcode_img')) 
document.getElementById('bedcode_img').style.visibility	= 'visible';
if(document.getElementById('locntion_type_img')) 
document.getElementById('locntion_type_img').style.visibility	= 'visible';
if(document.getElementById('visit_adm_type_img')) 
document.getElementById('visit_adm_type_img').style.visibility	= 'visible';
if(document.getElementById('service_desc_img')) 
document.getElementById('service_desc_img').style.visibility	= 'visible';
if(document.getElementById('bedclass')) 
document.getElementById('bedclass').style.visibility	= 'visible';
if(document.getElementById('bedclass1')) 
document.getElementById('bedclass1').style.visibility	= 'visible';
if(document.getElementById('bedtype')) 
document.getElementById('bedtype').style.visibility	= 'visible';
if(document.getElementById('bedtype1')) 
document.getElementById('bedtype1').style.visibility	= 'visible';
if(document.getElementById('admtype')) 
document.getElementById('admtype').style.visibility	= 'visible';
if(document.getElementById('admtype1')) 
document.getElementById('admtype1').style.visibility	= 'visible';




	var len=document.forms[0].Bedcode.length;
	var i=1;
	while(i<len)
	{
		len=document.forms[0].Bedcode.length
		document.forms[0].Bedcode.remove(i)
	}
	
	var len=document.forms[0].bed_type.length;	
	var j=1;
	while(j<len)
	{
		len=document.forms[0].bed_type.length
		document.forms[0].bed_type.remove(j)
	} 
	
	var len=document.forms[0].visit_adm_type.length;	
	var k=1;
	while(k<len)
	{
		len=document.forms[0].visit_adm_type.length
		document.forms[0].visit_adm_type.remove(k)
	} 

	
	
//setTimeout("getlocationtype()",200);	
   var locale= document.forms[0].locale_js.value;
   var sys_dat = getCurrentDate("DMY",locale);	
	document.forms[0].preferred_date.value=sys_dat;
	
	}else{ 
      if(document.forms[0].referral_type){
	  document.forms[0].referral_type.disabled=false;
	  document.forms[0].referral_type.value="";
	  }
	  if(document.forms[0].hcare_setting_type)	{
	  document.forms[0].hcare_setting_type.disabled=false;
	  document.forms[0].hcare_setting_type.value="";
	  }
	  if(document.forms[0].referral_source)	{
	  document.forms[0].referral_source.disabled=false;
	  if (document.forms[0].onloadcount.value>0 ){  //Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
	  document.forms[0].referral_source.value="";   
	  }
	  }
	  if(document.forms[0].ref_for_ip)	{
	  document.forms[0].ref_for_ip.disabled=false;
	  document.forms[0].ref_for_ip.value="";
	  }
	  if(document.forms[0].location0)	{
	  document.forms[0].location0.disabled=false;
	  document.forms[0].location0.value="";
	  }
	 
	//getval1(document.forms[0].referral_type);popServiceXRef(document.forms[0].referral_type);
	defaultLoginFacility();

	var len=document.forms[0].Bedcode.length;
	var i=1;
	while(i<len)
	{
		len=document.forms[0].Bedcode.length
		document.forms[0].Bedcode.remove(i)
	}
	
	var len=document.forms[0].bed_type.length;	
	var j=1;
	while(j<len)
	{
		len=document.forms[0].bed_type.length
		document.forms[0].bed_type.remove(j)
	} 
	
	var len=document.forms[0].visit_adm_type.length;	
	var k=1;
	while(k<len)
	{
		len=document.forms[0].visit_adm_type.length
		document.forms[0].visit_adm_type.remove(k)
	} 
	
	for(var r=0; r< document.forms[0].priority.length; r++){	
	if(document.forms[0].priority[r].value=="L"){
	document.forms[0].priority.value="";
	//document.forms[0].ref_for_ip.disabled=true;
	    }
	}	

	

if(document.getElementById('locntion_img')) 
document.getElementById('locntion_img').style.visibility	= 'hidden';	
if(document.getElementById('PractImg')) 
document.getElementById('PractImg').style.visibility	= 'hidden';	
if(document.getElementById('bedcode_img')) 
document.getElementById('bedcode_img').style.visibility	= 'hidden';
if(document.getElementById('locntion_type_img')) 
document.getElementById('locntion_type_img').style.visibility	= 'hidden';
if(document.getElementById('visit_adm_type_img')) 
document.getElementById('visit_adm_type_img').style.visibility	= 'hidden';
if(document.getElementById('service_desc_img')) 
document.getElementById('service_desc_img').style.visibility	= 'hidden';
if(document.getElementById('bedclass')) 
document.getElementById('bedclass').style.visibility	= 'hidden';
if(document.getElementById('bedclass1')) 
document.getElementById('bedclass1').style.visibility	= 'hidden';
if(document.getElementById('bedtype')) 
document.getElementById('bedtype').style.visibility	= 'hidden';
if(document.getElementById('bedtype1')) 
document.getElementById('bedtype1').style.visibility	= 'hidden';
if(document.getElementById('admtype')) 
document.getElementById('admtype').style.visibility	= 'hidden';
if(document.getElementById('admtype1')) 
document.getElementById('admtype1').style.visibility	= 'hidden';	  
	  }
	  
   }

}

/*function getlocationtype(){
if(document.forms[0].location0){
for(var m=0; m< document.forms[0].location0.length; m++){ 
	if(document.forms[0].location0[m].value=="N"){
	document.forms[0].location0.value=document.forms[0].location0[m].value;
	//clear_location(document.forms[0].location0.value);	
	document.forms[0].location0.disabled=true;
	    }
	}

}

}*/

function FnSetDefaultReferralType(){
	if(document.forms[0].referral_type!=null){
		getval1(document.forms[0].referral_type);
		popServiceXRef(document.forms[0].referral_type)
	}
}
//Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362
function disRecRefbut(){ 
	if(document.forms[0].referral_type.value=='X' && document.forms[0].RecordReferralLetterNote.style.visibility == 'visible'){ 
	document.forms[0].RecordReferralLetterNote.disabled=true;
	parent.frames[1].document.forms[0].CA_REF_LETTER_NOTES_REC_YN.value="N";
	}else{
	document.forms[0].RecordReferralLetterNote.disabled=false;
	}
}
/*Added by Dharma on 11th Feb 2016 against ML-MMOH-CRF-0340 [IN057178] Start*/

function defaultLoginFacility(){

	if(document.forms[0].referral_type!=null && document.forms[0].called_from.value!="CA"){

		var dropDown = document.forms[0].referral_type;
		var i;
		var isLoginFacility		= "";
		for (i = 0; i < dropDown.length; i++) {
			if(dropDown.options[i].value=="L"){
				isLoginFacility	= "Y";
				break;
			}
		}

		if(isLoginFacility=="Y"){
			if(document.forms[0].hddFuncID.value=="ModifyReferral" && "<%=ref_type%>"!=""){ //Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 
				document.forms[0].referral_type.value	= "<%=ref_type%>"; 
				if ("<%=referred_to_value%>"!="" && "<%=ref_hcare_setting_type%>"!=""){
				document.forms[0].hcare_setting_type[0].value= "<%=ref_hcare_setting_type%>"; 
				document.forms[0].hcare_setting_type.options[0].selected=true; 
				document.forms[0].referral_source_lkp_but.onclick();
				document.forms[0].service_desc.value="<%=to_service_desc%>";
				document.forms[0].service.value="<%=ref_service_code%>";
				document.forms[0].transfer_case_yn.checked=("<%=transfer_case_yn%>"=="Y")?true:false;
				}
			} else {
			document.forms[0].referral_type.value	= "L";
			}
			document.forms[0].referral_type.onchange();
		}
	}
}

window.onload = function() {
	defaultLoginFacility();
}

/*Added by Dharma on 11th Feb 2016 against ML-MMOH-CRF-0340 [IN057178] End*/


	</script>
	<!--End this CRF  Bru-HIMS-CRF-261 -->		

</HEAD>
<BODY onKeyDown = 'lockKey();' <%if(function_id.equals("RegPatRefFromAEAssessment")){%>onload="FnSetDefaultReferralType();"<%}%> >

<%
	try
	{
		con	= ConnectionManager.getConnection(request);	
		
	    Boolean isRefDateNonMandatory = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","NON_MNDT_FOR_PREF_DATE"); //Added by Mano on 18-April-2018 against ML-MMOH-CRF-1046
        Boolean isTransferCase	= eCommon.Common.CommonBean.isSiteSpecific(con,"MP","BMI_REG_PAT_CHNGES_RH101"); //Added by Afruddin for ML-MMOH-CRF-1527 US0003 on 28-jun-2020

		 Boolean isImproveReferralProcessAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"OP","IMPROVE_REFERRAL_PROCESS"); //Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		 /*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/ 
                Boolean isForAdmission = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_FOR_ADMISSION_TAB");
		String refButton="button"; 
		String locdisable="disabled"; 
		int onloadcount=1; 
		/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/ 
		 //Below Added by Suji Keerthi for NMC-JD-CRF-0130
			String priority_Code="";
			String priority_Desc="";
			JSONObject RefPriorityJson = new JSONObject();
			JSONArray refPriorityjsonArr = new JSONArray();	
			 Boolean isReferralPriorityAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AM","REFERRAL_PRIORITY_DESC");
			 RefPriorityJson = eIP.IPCommonBean.getReferralPriority(con); 
			 refPriorityjsonArr = (JSONArray)RefPriorityJson.get("refPriorityArray");
			 

		String strReasonForRef	= request.getParameter("ReasonForRef");
			if(strReasonForRef	== null	) strReasonForRef = "N";
		
		String strModule	= request.getParameter("Module");
		if (strModule == null)  strModule = "";

		String strOption  = request.getParameter("Option");
			if(strOption == null) strOption = "Y";

		String strBodyFrame		= request.getParameter("bodyFrame");
		String strSubmitFrame	= request.getParameter("submitFrame");

		String Transaction_type	= request.getParameter("Transaction_type");
			if(Transaction_type	== null) Transaction_type = "";	

        /*Below line modified for this CRF HSA-CRF-0263.1*/
	    String allow_muti_bedside_review_yn = checkForNull(request.getParameter("allow_muti_bedside_review_yn"),"N");
		String select_value			= "";	
		String system_date			= "";
		String system_date_time	= "";
		
		/*Below line Added for this CRF Bru-HIMS-CRF-354 [IN:038538] */
		//String frm_practitioner_name=checkForNull(request.getParameter("frm_practitioner_name"));//commented for checkstyle voilation by Munisekhar
		//String frm_practitioner_id=checkForNull(request.getParameter("frm_practitioner_id"));//commented for checkstyle voilation by Munisekhar
		
		//End this CRF Bru-HIMS-CRF-354
		String quickadm=""; //this line Added for this CRF Bru-HIMS-CRF-261
		String regOutref=checkForNull(request.getParameter("regOutref"));		
		
		String facilityid=(String)(session.getValue("facility_id")==null?"":session.getValue("facility_id"));
		String globaluser = (String)(session.getValue("login_user")==null?"":session.getValue("login_user"));
		//this line Added for this CRF Bru-HIMS-CRF-261
		

		if(function_id.equals("RegisterInpatientReferral")) {

			system_date_time = request.getParameter("system_date_time");
			system_date = request.getParameter("system_date");
			
		} else {  /*Below line modidied for this CRF  Bru-HIMS-CRF 261*/
				//pstmt=con.prepareStatement("select to_char(sysdate,'dd/mm/rrrr hh24:mi')system_date_time, to_char(sysdate,'dd/mm/rrrr')system_date from dual");
				pstmt=con.prepareStatement("select to_char(sysdate,'dd/mm/rrrr hh24:mi')system_date_time, to_char(sysdate,'dd/mm/rrrr')system_date,AM_OPER_STN_ACCESS_CHECK('"+facilityid+"','"+globaluser+"','X','','QUICK_ADMISSION_YN') quickadm  from dual");
				rs		= pstmt.executeQuery();

				if((rs != null) && (rs.next())) {
					system_date_time	= rs.getString("system_date_time");			
					system_date			= rs.getString("system_date");
					quickadm			= checkForNull(rs.getString("quickadm")); //this line Added for this CRF Bru-HIMS-CRF-261
				}

				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
		}
		
		system_date_time=DateUtils.convertDate(system_date_time,"DMYHM","en",localeName);
		system_date=DateUtils.convertDate(system_date,"DMY","en",localeName);
		/*added by lakshmanan for ML-MMOH-CRF-1972 on 20-07-2023 start*/
		if(isForAdmission){
			 refButton="hidden";
			 if(function_id.equals("ModifyReferral")){
				 locdisable="";
				 onloadcount=0;
			 }
			 
			}
		/*added by lakshmanan for ML-MMOH-CRF-1972 on 20-07-2023 end*/

%>
	<TABLE id="referral_table" cellspacing=0 cellpadding=0 border="0" width="100%" >
	<input type="hidden" name="isForAdmissionAppl" id="isForAdmissionAppl" value="<%=isForAdmission%>">
		<input type="hidden" name="onloadcount" id="onloadcount" value="<%=onloadcount%>" >
		<input type='hidden' name='hddModule' id='hddModule' value='<%=strModule%>'>
		<input type='hidden' name='hddOption' id='hddOption' value='<%=strOption%>'>
		<input type='hidden' name='hddReasonForRef' id='hddReasonForRef' value='<%=strReasonForRef%>'>
		<input type='hidden' name='hddBodyFrame' id='hddBodyFrame' value='<%=strBodyFrame%>'>
		<input type='hidden' name='hddSubmitFrame' id='hddSubmitFrame' value='<%=strSubmitFrame%>'>
		<input type="hidden" name="system_date" id="system_date" value="<%=system_date%>" >
		<input type="hidden" name="system_date_time" id="system_date_time" value="<%=system_date_time%>" >
		<input type="hidden" name="hddref_service_code" id="hddref_service_code" value="<%=ref_service_code%>" >
		<input type="hidden" name="hdd_Transaction_type" id="hdd_Transaction_type" value="<%=Transaction_type%>" >
		  <!--Below line modified for this CRF HSA-CRF-0263.1-->
		<input type="hidden" name="allow_muti_bedside_review_yn" id="allow_muti_bedside_review_yn" value="<%=allow_muti_bedside_review_yn%>" >
	
		<table cellpadding=0 cellspacing=0 width="100%" border='0'>
					<input type="hidden" name="hddFuncID" id="hddFuncID" value="<%=function_id%>" >

					
							<%

								//System.out.println("function_id--->"+function_id);
								//out.println("-"+Transaction_type);
								
							if(function_id.equals("RegisterInpatientReferral"))
								{	%>
								<tr><td><input type="hidden" name="referred" id="referred" value="Y" ></td>
								<td class='label' width='25%' colspan='3'></td></tr>
							<%	}
								else if(!Transaction_type.equals("DA") && !Transaction_type.equals("DP") && !Transaction_type.equals("CO"))
								{	%>
					<tr>
									<td   class='label' width='25%' ><fmt:message key="Common.Referred.label" bundle="${common_labels}"/></td>
									<td width='25%' class='fields'><input type='checkbox' name='referred' id='referred' value="Y" onClick='enable_referred(this);' onblur='scrollView(this)'></td>
									<td class='label' width='25%' colspan='2'></td>
					</tr>
							<%	}	%>
					

							<%	if(function_id.equals("RegisterInpatientReferral"))
							{	%>
					<tr>
								<td class='label' width='25%'><fmt:message key="Common.BedSideReferral.label" bundle="${common_labels}"/></td>
								<td  width='25%' class='fields' ><input type='checkbox' name='Bedside' id='Bedside' value="Y" onClick='setVal();disRecRefbut();'></td> <!--Modified by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->
								<td  class='label' colspan='2'></td>
					</tr>
							<%	}	%>

			<!--Below line Added for this CRF  Bru-HIMS-CRF-261 -->	
			<!--&&(!function_id.equals("RegPatRefFromAEAssessment")) Added For AAKH-CRF-0010 [IN:038535] by Dharma on Mar 11th 2014	 -->	
             <%if((!function_id.equals("RegisterInpatientReferral")) &&(!function_id.equals("RegPatRefFromAEAssessment")) && (!function_id.equals("PRE_DIS_ADVICE")) && (!quickadm.equals("1")) && (!quickadm.equals("2")) && (!quickadm.equals("3")) && (!quickadm.equals("4")) && (!quickadm.equals("5")) && !isForAdmission ){ %>	
					<tr>
						<td colspan="4" class=label height=5><fmt:message key="eMP.QuickAdmission.label" bundle="${mp_labels}"/> <input type=checkbox name="quick_admission" id="quick_admission" id="quick_admission" onclick="Quickadmission();disRecRefbut();"></td>
						<!--Modified by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->
					</tr>
					<%}%>
             <!-- End Bru-HIMS-CRF-261  --->
					<tr>
				<!-- Referral Type -->
						<td class='label' width='25%' ><fmt:message key="Common.referraltype.label" bundle="${common_labels}"/></td>
					
						<td  width='25%' class='fields'><select name="referral_type" id="referral_type" onchange='getval1(this);popServiceXRef(this);disRecRefbut();' disabled> <!--Modified by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->
						
						<option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
						<option value='L' <%if(function_id.equals("RegPatRefFromAEAssessment")){%> selected<%}%>><fmt:message key="Common.loginfacility.label" bundle="${common_labels}"/></option>
						<option value='E'><fmt:message key="Common.enterprise.label" bundle="${common_labels}"/></option>
						<option value='X'><fmt:message key="Common.external.label" bundle="${common_labels}"/></option></select><img id=id1 src='../../eCommon/images/mandatory.gif' style="visibility : hidden"></td>


				<!-- Health Care Setting -->
						<td class='label' width='25%' NOWRAP><fmt:message key="Common.HealthcareSettingType.label" bundle="${common_labels}"/></td>
					
						<td  width='25%' class='fields' NOWRAP><select name="hcare_setting_type" id="hcare_setting_type"	disabled onchange='getval2(this.value)' >
						
						<option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------------------</option>
						</select><img id=id5 src='../../eCommon/images/mandatory.gif'  style="visibility : hidden;"></td>

				
					</tr>
					
					<!-- Added by Afruddin for ML-MMOH-CRF-1527 US3 on 23.07.2020 -->
					<% if(isTransferCase){%>
					<tr>
						<td colspan="4" class=label height=5></td>
					</tr>
					<tr>
					
                     			<td align='right' class='label' id='transfer_case'nowrap ><fmt:message key="eMP.TransferCase.label" bundle="${mp_labels}"/></td>
			         	<td><input type='checkbox' name='transfer_case_yn' id='transfer_case_yn'value="<%=transfer_case_yn%>" onclick='ChangeState(this)'>
					 </td>
					 </tr>
					 <% }%>		
                     			<!-- Ended by Afruddin for ML-MMOH-CRF-1527 US3 on 23.07.2020 -->

					<tr>
						<td colspan="4" class=label height=5></td>
					</tr>

				<tr>
				<!-- Referred To --> <!--Legend name  modified  for PMG2014-CRF-0007 [IN:046756] -->
						<td class='label' width='25%'  nowrap ><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></td>
						
						<td width='25%' class='fields' nowrap >
						
						<!-- <select name="referred_to" id="referred_to" onchange='populate_hcare(this);populate_ext_specialty(this);' disabled><option value=''>----------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------</option></select> -->
						<!--  below line modified by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023 start -->
						<input type='text' name='referral_source' id='referral_source' size='25' maxlength="15" onBlur ='clear_ref();' value="<%=referred_to_value%>" ><input type='button' class='button' name='referral_source_lkp_but' id='referral_source_lkp_but' value='?' onClick='referralSourceLookup(this)' ><img id=id2 src='../../eCommon/images/mandatory.gif'  style="visibility : hidden;"><img src='../../eCommon/images/more.gif' name="lng_name" id="lng_name" align=center style="visibility:hidden">
						<input type='hidden' name='referral_source_lkp_bkup_text' id='referral_source_lkp_bkup_text' size='15' maxlength="15" >
						<input type='hidden' name='referred_to' id='referred_to' size='5' maxlength="15" value="<%=referred_to_value%>" ></td>
						<!--  above line modified by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023 end -->
						<!-- Specialty -->
					
						<td  class='label' width='25%'  nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
						
				

						<% 
							
						pstmt=con.prepareStatement(" Select Short_Desc  from AM_SPECIALITY_LANG_VW where Eff_Status = 'E' and language_id='"+locale+"' and Speciality_Code='"+ref_specialty+"'  order by 1");
						rs = pstmt.executeQuery();
						if(rs != null)
						{
							while(rs.next())
							{
								splty_desc=checkForNull(rs.getString("Short_Desc"));
							}
						}

						if(rs != null) rs.close();
						if(pstmt != null) pstmt.close();

						if(!splty_desc.equals(""))
						{
							%>

						<td class='FIELDS'><INPUT TYPE="text" name="speciality_desc" id="speciality_desc" value="<%=splty_desc%>" onblur='beforegetspeciality1(this,referred_to);populateServices(this);' size=18  ><input type='button' class='button'  name='search_speciality' id='search_speciality' value='?' onclick="getspeciality(speciality_desc,referred_to);" >
		         
						 <input type='hidden' name='speciality' id='speciality' value='<%=ref_specialty%>'>
						 <%
						}else{
							 %>
							 <td class='FIELDS'><INPUT TYPE="text" name="speciality_desc" id="speciality_desc" value="" onblur='beforegetspeciality1(this,referred_to);populateServices(this);' size=18  ><input type='button' class='button'  name='search_speciality' id='search_speciality' value='?' onclick="getspeciality(speciality_desc,referred_to);" >
		         
						 <input type='hidden' name='speciality' id='speciality' value=''>

						 <% } %>

		           
		              		            
									
						<img id=id4 src='../../eCommon/images/mandatory.gif' style="visibility : hidden;"></td>
	
				</tr>

				<tr>
						<td colspan="4" class=label height=5></td>
				</tr>

				<tr>
				
					<!-- Location -->
						<td class='label' width='25%'  nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
					
						<td  width='25%' class='fields' nowrap >
						<!--  below line modified by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023  -->
						<select name="location0" id="location0" onchange='<%if(isImproveReferralProcessAppl && (!function_id.equals("RegisterInpatientReferral"))){%>clearSpecVal();<%}%>clear_location(this.value);' <%=locdisable%>>
						<option value='' >-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
						</select>
						<img id="locn_type_img" src='../../eCommon/images/mandatory.gif' style="visibility : hidden;">
						</td>
						<td class='label' width='25%'  nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
                        <!--Below line modified for this CRF Bru-HIMS-CRF-261 -->
						<td  width='25%'  nowrap>
						 <%//if(functionid.equals("")){ 
						  if((!function_id.equals("RegisterInpatientReferral")) && (!function_id.equals("PRE_DIS_ADVICE"))){ 
						 %>
						 <!--  below line modified by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023  -->
						 <select name="location1" id="location1"  onchange='<%if(isImproveReferralProcessAppl || isForAdmission ){%>autoPopulateSpecialty(this.value);<%}%>populateBedclass(this.value);' <%=locdisable%> >
						<% } else{%>
						<select name="location1" id="location1"   disabled>
						<%}%>
						<option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>				
						</select><img id="locntion_img" src='../../eCommon/images/mandatory.gif' style="visibility : hidden;">
						</td>
						</tr>
						<tr>
						<td class=label></td>
						<td class=label></td>
						<td class=label></td>
						<td>
						<input type=text name="location2" id="location2" value="<%=to_locn_desc%>" onBlur="makeValidString(this)" size="15" maxlength=30 id = 'location2_text' style = 'display:inline' disabled>
						</td>
						<input type='hidden' name='location_Desc' id='location_Desc' value="">
						
						
					</tr>

					<tr>
						<td colspan="4" class=label height=5></td>
					</tr>

					<tr>
				
						<!-- Service -->
						<td  class='label' width='25%'  nowrap  ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
						
						<%
						if(function_id.equals("DischargePatient"))
						{
			
							pstmt=con.prepareStatement("SELECT SHORT_DESC FROM AM_SERVICE_LANG_VW WHERE EFF_STATUS = 'E' and language_id='"+locale+"' and SERVICE_CODE='"+ref_service_code+"' order by 1");
							rs = pstmt.executeQuery();
							if(rs != null)
							{
								while(rs.next())
								{
									
									ServiceDesc= rs.getString("SHORT_DESC");

								}			
							}
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
						

						if(!ServiceDesc.equals(""))
						{
						%>

						<td class='FIELDS'><INPUT TYPE="text" name="service_desc" id="service_desc" value="<%=ServiceDesc%>" onblur='if(this.value != "")getServicelook1(this,referred_to)' size=18  ><input type='button' class='button'  name='search_service' id='search_service' value='?' onclick="getServicelook(speciality_desc,referred_to)" >
		         
						 <input type='hidden' name='service' id='service' value='<%=ref_service_code%>'><img id="service_desc_img" src='../../eCommon/images/mandatory.gif' style="visibility:hidden;"></td>
						 <% }
						 else
							{  %>
							<td class='FIELDS'><INPUT TYPE="text" name="service_desc" id="service_desc" value="" onblur='if(this.value != "")getServicelook1(this,referred_to)' size=18  ><input type='button' class='button'  name='search_service' id='search_service' value='?' onclick="getServicelook(speciality_desc,referred_to)" >
		         
						 <input type='hidden' name='service' id='service' value=''><img id="service_desc_img" src='../../eCommon/images/mandatory.gif' style="visibility:hidden;"></td>
						 <% } 
						} else {%>
						<td class='FIELDS'><INPUT TYPE='text' name='service_desc' id='service_desc' value='<%=to_service_desc%>'     onblur='if(this.value=="")document.forms[0].service.value=""; getServicelook1(this,referred_to);' size=18  ><input type='button' class='button'  name='search_service' id='search_service' value='?' onclick="getServicelook(speciality_desc,referred_to)" >
		         
						 <input type='hidden' name='service' id='service' value='<%=ref_service_code%>' ><img id="service_desc_img" src='../../eCommon/images/mandatory.gif' style="visibility:hidden;"></td>
						 <% } %>



				<!-- Practitioner -->
						<td class='label' width='25%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
						<!--  below line modified by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023  -->
						<td  width='25%' class='fields'><input type=text name="pract_name" id="pract_name" value="<%=to_pract_desc%>" onchange="disable_ext_pract(this);" onBlur='makeValidString(this);disable_ext_pract(this);getPractitioner22(practitioner,pract_name); if(this.value=="")document.forms[0].practitioner.value="";' size="30" maxlength=30 disabled" ><input type="button" name="pract_butt" id="pract_butt" value="?" class="button" style= "Visibility : 'Visible'" onClick="getPractitioner2(practitioner,pract_name);" disabled ><input type="hidden" name="practitioner" id="practitioner" value="<%=to_pract_id%>"><img id="PractImg" src='../../eCommon/images/mandatory.gif' style="visibility:hidden;">
						
						 <input type='text' name='from_ext_practitioner_id'  value="<%=to_pract_name%>" onchange="disable_pract(this);"   onBlur = "disable_pract(this);" tabIndex='12' size=25 maxlength=30 id = 'pract_ext_name' style = 'display:none' >
						
						</td>
					</tr>


					<tr>
						<td colspan="4" class=label height=5></td>
					</tr>

		
				
				
					<!-- Referred for -->
					<%if(!function_id.equals("RegisterInpatientReferral")){%>
				<tr><!--Legend name  modified  for PMG2014-CRF-0007 [IN:046756] -->
						<td  class='label' width='25%'  nowrap  ><fmt:message key="Common.referredfor.label" bundle="${common_labels}"/></td>
						
						<td  width='25%'  nowrap class='fields'><select name="ref_for_ip" id="ref_for_ip" onChange = '' disabled>
						<%
							if (referred_for.equals(""))
								select_value = "Selected";
							else
								select_value = "";
						%>
							<option value="" <%=select_value%> >----------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------------------</option>
						<%
							if (referred_for.equals("A"))
								select_value = "Selected";
							else
								select_value = "";
						%>
							<option value="A" <%=select_value%> ><fmt:message key="Common.admit.label" bundle="${common_labels}"/></option>
						<%
							if (referred_for.equals("B"))
								select_value = "Selected";
							else
								select_value = "";
						%>
							<option value="B" <%=select_value%> ><fmt:message key="Common.booking.label" bundle="${common_labels}"/></option>
							</select><img id="refID" src='../../eCommon/images/mandatory.gif' style="visibility:'hidden';">
						</td>
						
					<%}%>
				

				<%if(function_id.equals("RegisterInpatientReferral")){%>			
				
					
				
					<tr>
						<td class='label' width='25%'  nowrap ><fmt:message key="Common.ReferredDate.label" bundle="${common_labels}"/></td>
					
						<td class='querydata' width='25%'  nowrap ><%=system_date%></td>
								
					<%//	if(function_id.equals("RegisterInpatientReferral")){%>
					<!-- Pref Date -->		
						
						<td class='label' width='25%'  nowrap ><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></td>
						
						<td width='25%' class='fields' nowrap><input type=text name="preferred_date" id="preferred_date" size=10 maxlength=10  onBlur="validate_from_date(this);" value="<%=preferred_treatment_date%>" disabled><img id="preferred_date_cal" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('preferred_date',null);" disabled><img id="prefDateImg" src='../../eCommon/images/mandatory.gif' style="visibility: hidden;"></td>            
				
					<%	}else{	%>
					<!-- Pref Date -->		
						
						<td class='label' width='25%'  nowrap><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></td>
						
						
						<td  width='25%' class='fields' nowrap><input type=text name="preferred_date" id="preferred_date" size=10 maxlength=10  onBlur="validate_from_date(this); validatePrefDate(this);" value="<%=preferred_treatment_date%>" disabled><img id="preferred_date_cal" src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('preferred_date',null);" disabled> <%if(!isRefDateNonMandatory){%><!-- <img id="prefDateImg" src='../../eCommon/images/mandatory.gif' style=""> --><%}%></td> 
						<!--above added by Mano on 18-April-2018 against ML-MMOH-CRF-1046-->
							
					<%//}%>
					

				<%}%>
				
				</tr>
				<tr>
					<td colspan="4" class=label height=5></td>
				</tr>
				
				
				<tr>
					<!-- Reason For Ref -->
						<td class='label' width='25%'  nowrap ><fmt:message key="Common.ReasonforReferral.label" bundle="${common_labels}"/></td>
						<!--  below line modified by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023  -->
						<td   width='25%'  class='fields' nowrap ><input type='text' name='referral_reason_desc' id='referral_reason_desc' onBlur = 'if(this.value != "")blurgetReasonForRef(this); if(this.value=="")document.forms[0].referral_reason_code.value="";'  size=30 maxlength=60 value="<%=referral_reason_desc%>" disabled><input type='button' class='button' name='ref_reason' id='ref_reason' value='?' id = 'refReason' onclick="getReasonForRef(this);" disabled><input type='hidden' name='referral_reason_code' id='referral_reason_code' value="<%=referral_reason_code%>"></td>
							
						<!-- Priority -->
						<td class='label' width='25%'  nowrap ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
						
						<td  width='25%' class='fields' nowrap><select name="priority" id="priority" disabled>
						<%
						if (ref_priority.equals(""))
							  select_value = "Selected";
						else  select_value = "";
						%>
							<option value='' <%=select_value%> >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>

							<!--Added by Suji Keerthi for NMC-JD-CRF-0130-->
                               <% if(isReferralPriorityAppl && !function_id.equals("ModifyReferral")){ 	 // modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023

								   refPriorityjsonArr = (JSONArray)RefPriorityJson.get("refPriorityArray");
					               for(int i = 0 ; i < refPriorityjsonArr.size() ; i++) 
				                   {
                             
									JSONObject jsonObj = (JSONObject) refPriorityjsonArr.get(i);
									priority_Code		= checkForNull((String) jsonObj.get("priority_Code"));
									priority_Desc		= checkForNull((String) jsonObj.get("priority_Desc"));
									out.println("<option value='"+priority_Code+"'>"+priority_Desc+"</option>");	
							
						           }	
						 
						 }else{%>

						<!--Ended by Suji Keerthi for NMC-JD-CRF-0130-->
						<%
						if (ref_priority.equals("L") || (isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral")))
							  select_value = "Selected";
						else  select_value = "";
						%>
							<option value="L" <%=select_value%> ><fmt:message key="Common.elective.label" bundle="${common_labels}"/></option>
						<%
						if (ref_priority.equals("U"))
							  select_value = "Selected";
						else  select_value = "";
						%>
							<option value="U" <%=select_value%> ><fmt:message key="Common.semiemergency.label" bundle="${common_labels}"/></option>
						<%
						if (ref_priority.equals("E"))
							  select_value = "Selected";
						else  select_value = "";
						%>
							<option value="E" <%=select_value%> ><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>

							<%} %>		<!--Added by Suji Keerthi for NMC-JD-CRF-0130-->
							</select><img id="id3" src='../../eCommon/images/mandatory.gif' style="visibility : hidden;"></td> 
							
						
				</tr>
	         <!--Below line Added for this CRF  Bru-HIMS-CRF-261 -->	
            <%if((!function_id.equals("RegisterInpatientReferral")) && (!function_id.equals("PRE_DIS_ADVICE"))){ %>	
                   <tr>	
					<td colspan='4'>&nbsp;</td>
					</tr>			
				<tr>
					<td  class="label" id="bedclass" style="visibility : hidden"><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
					<td  class="fields"id="bedclass1" style="visibility : hidden" ><select name='Bedcode' id='Bedcode' onChange='populateBedType(this.value)'  >
					<option value="" selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option></select>
					<img id="bedcode_img" src='../../eCommon/images/mandatory.gif' style="visibility : hidden"></td>
					<td  class="label" id="bedtype" style="visibility : hidden"><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
					<td  class="fields" id="bedtype1" style="visibility : hidden"><select name="bed_type" id="bed_type">
					<option value="" selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option></select>
					<img id="locntion_type_img" src='../../eCommon/images/mandatory.gif' style="visibility : hidden"></td>
				</tr>
           <%}%>
			 	<tr>	
					<td colspan='4'>&nbsp;</td>
					</tr> 
					<!--End Bru-HIMS-CRF-261 -->
					<!--Below line Modified for this CRF Bru-HIMS-CRF-261 -->
				<tr>	   <%if(!function_id.equals("RegisterInpatientReferral")){ /*this line changed for this CRF Bru-HIMS-CRF-261*/%>			
					<td  class="label" id="admtype" style="visibility : hidden"><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
					<td class="fields" id="admtype1" style="visibility : hidden">
					<select name="visit_adm_type" id="visit_adm_type" ><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</select><img id="visit_adm_type_img" src='../../eCommon/images/mandatory.gif' style="visibility : hidden;"></td>					
					<td >&nbsp;</td>
					<%}else{%>
					<!--Below line Added for this CRF  Bru-HIMS-CRF-354 [IN:038538]-->
					<td class='label' width='25%' style="visibility:hidden" id="frm_pract_image">
					<fmt:message key="eMP.ReferraltoPractioner.label" bundle="${mp_labels}"/></td>							
						<td  width='25%' class='fields' style="visibility:hidden" id="frm_practn_name"><input type=text name="frm_pract_name" id="frm_pract_name" value="" onchange="disable_ext_pract(this);" onBlur="makeValidString(this);disable_ext_pract(this);getPractitioner22(frm_practitioner,frm_pract_name);" size="30" maxlength=30   ><input type="button" name="frm_pract_butt" id="frm_pract_butt" value="?" class="button"  onClick="getPractitioner2(frm_practitioner,frm_pract_name);"  ><input type="hidden" name="frm_practitioner" id="frm_practitioner" value=""><img id="frm_practimg" src='../../eCommon/images/mandatory.gif' style="visibility:hidden;">												
						</td>
						<td>&nbsp;</td>
					   <!--end Bru-HIMS-CRF-354 [IN:038538] -->
					<%} %>
					<!--  below line modified by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023  -->
					<td  class='fields' width='25%'  nowrap ><input type=<%=refButton%> class=button value='<fmt:message key="eMP.ReferralNotes.label" bundle="${mp_labels}"/>' name='ReferralNotesButton' onclick="referral_notes('<%=referral_notes_value%>')" onblur='scrollView(this)' disabled>
					<input type = 'hidden' name='ReferralNotes' id='ReferralNotes' value="<%=referral_notes_value%>" >
					<!--End Bru-HIMS-CRF-261 -->
					<!--Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->
					<%
					String 	dispButton="hidden";
					pstmt=con.prepareStatement("select CA_RECORD_REFERRAL_NOTE_YN from ip_param where facility_id='"+facilityid+"'");
					rs		= pstmt.executeQuery();
					if((rs != null) && (rs.next())) {
					if(checkForNull(rs.getString("CA_RECORD_REFERRAL_NOTE_YN")).equals("Y")){
					dispButton ="Visible";
					}
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
					
					%>
					&nbsp;&nbsp;
					<!--  below line modified by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023  -->
					<input type=<%=refButton%> class=button value='<fmt:message key="eMP.RecordReferralLetterNote.label" bundle="${mp_labels}"/>' name='RecordReferralLetterNote' onclick="record_referral_note();" style="Visibility : <%=dispButton%>;">
					</td>
					<!--Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->
				</tr>					

					<%	if(function_id.equals("RegisterInpatientReferral"))
						{	%>
							<script>
								enable_referred(document.forms[0].referred);</script>
					<%	}	%>

					<%	if(function_id.equals("PrepareDischargeAdvice") && patient_status.equals("3"))
						{	%>
							<script>document.forms[0].referred.disabled	= true;</script>
					<%	}	

					if(function_id.equals("DischargePat") && patient_status.equals("3"))
						{	%>
							<script>document.forms[0].referred.disabled	= true;</script>
					<%	}	%>

					<%	if(Transaction_type.equals("DA") || Transaction_type.equals("DP") || 		Transaction_type.equals("CO"))
						{	%>
							<input type="hidden" name="referred" id="referred" value="Y" >
							<script>enable_referred(document.forms[0].referred);</script>
					<%	}	%>

					<script>//document.forms[0].priority.value = "L"; //this line commented for this Bru-HIMS-CRF-261</script>

					<%	if(discharge_indicator.equals("ED"))
						{	%>
							<script>						
								document.forms[0].referral_type.value = 'X' ;									
								popExternal(document.forms[0].referral_type);														
							</script>
					<%	}	%>

<%	if(called_from.equals("CA"))
	{	%>
		<script>
			document.forms[0].Bedside.value		= "Y";
			document.forms[0].Bedside.checked	= true;
			setTimeout('setVal()',200);
			document.forms[0].Bedside.disabled	= true;
		</script>
<%	}	%>

			<input type="hidden" name="ref_locn_type" id="ref_locn_type" value="<%=ref_locn_type%>">
			<input type="hidden" name="ref_locn_code" id="ref_locn_code" value="<%=ref_locn_code%>">
			<input type="hidden" name="ref_hcare_setting_type" id="ref_hcare_setting_type" value="<%=ref_hcare_setting_type%>">
			<input type="hidden" name="referred_to_value" id="referred_to_value" value="<%=referred_to_value%>">
			<input type="hidden" name="ref_priority" id="ref_priority" value="<%=ref_priority%>">
			<input type="hidden" name="ref_specialty" id="ref_specialty" value="<%=ref_specialty%>">
			<input type="hidden" name="called_from" id="called_from" value="<%=called_from%>">
			<input type="hidden" name="locale_js" id="locale_js" value="<%=locale%>">
			<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
			<input type="hidden" name="functionid" id="functionid" value="<%=functionid%>">
				<%/*Below line Added for this CRF Bru-HIMS-CRF-261*/%>
			<input type="hidden" name="regOutref" id="regOutref" value="<%=regOutref%>" >
			<!--Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->
			<input type="hidden" name="calling_module" id="calling_module" value="<%=request.getParameter("calling_module")%>" >
			<input type="hidden" name="temp_field" id="temp_field" value="N" >
			<!--Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->
			<input type="hidden" name="isRefDateNonMandatory" id="isRefDateNonMandatory" value="<%=isRefDateNonMandatory%>"> 
            <!--Added by Mano on 18-April-2018 against ML-MMOH-CRF-1046-->
            <!-- Added by afruddin for ML-MMOH-CRF-1527 on 28 jun 2020-->
            <input type='hidden' name='isTransferCase' id='isTransferCase' value='<%=isTransferCase%>'>
			<!--Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187-->
			<input type="hidden" name="isImproveReferralProcessAppl" id="isImproveReferralProcessAppl" value="<%=isImproveReferralProcessAppl%>" >
			<input type="hidden" name="facilityid" id="facilityid" value="<%=facilityid%>" >
			<input type="hidden" name="multi_spec" id="multi_spec" value="N" >
			<input type="hidden" name="from_encounter_id1" id="from_encounter_id1" value="<%=encounter_id%>" >
		
			
	</TABLE>
<%
}catch(Exception e) 
{
	out.println(e.toString());
	e.printStackTrace();
}
finally
{
	try{
		if (rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}catch(Exception ee){}

	
	if(con != null) ConnectionManager.returnConnection(con,request);
}
%>
<%!
	/*Below line Added for this CRF  Bru-HIMS-CRF-354 [IN:038538] */
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

</BODY>
</HTML>

