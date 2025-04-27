<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String patientId=request.getParameter("patientId");
String facility_Id = (String)session.getValue("facility_id");
String encounterId = request.getParameter("encounterId") == null ?"" : request.getParameter("encounterId");
if(patientId == null) patientId="";
String booking_ref_no	="";
String referral_id		="";
String referral_details		="";
String exp_length_of_stay = "";
String exp_discharge_date_time ="";
String service			="";
String chief_complaint	= "";
String circumstance_of_injury = "";
String team				="";
String remarks			="";
String patient_type		="";
String ambulatory_Status="";
String arrival			="";
String escort_name		="";
String escort_add_ln1	="";
String escort_add_ln2	="";
String escort_add_ln3	="";
String escort_add_ln4	="";
String escort_add_postal_code = "";
String escort_tel_num	="";
String escort_mv_reg_no = "";
String emergency_detail = "";
String to_nursing_unit_short_desc ="";
String to_specialty_short_desc = "";
String to_bed_class_short_desc = "";
String to_bed_no		= "";
String to_room_no		= "";
String trn_date_time	= "";
String admission_type	= "";
String OT_DATE_TIME		= "";
String to_practitioner_long_name = "";
String nationality_desc	= "";
String appl_user_name	= "";
String added_date		= "";
String flag ="";

%>
<html>
	<jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name="Facility_Id" value="<%=facility_Id%>"/>
		<jsp:param name="EncounterId" value="<%=encounterId%>"/>
	</jsp:include>
	<head>
	<title><fmt:message key="Common.AdmissionDetails.label" bundle="${common_labels}"/></title>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../html/text.css'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
function validatebutton()
{
	if(document.getElementById("referral_id").value != "")
	document.getElementById("referal_details").disabled = false;
	if(document.getElementById("booking_ref_no").value != "")
	{
	document.getElementById("contact_details").disabled = false;
	}else
		{
	//document.getElementById("contact_details").disabled = true;
	}
}

async function showContactDetails()
{
	var booking_ref_no	=	document.getElementById("booking_ref_no").value;
	var patient_id	=	document.getElementById("patient_id").value;
	var retVal			= 	new String();
	var dialogHeight	=	"22vh" ;
	var dialogWidth		=	"30vw" ;
	var status			=	"no";
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var contact_details = "||||||||||||||||"
	var arguments		=	"";
	var url				=	"../../eIP/jsp/BookAppointmentContact.jsp?booking_ref_no="+booking_ref_no+"&patient_id="+escape(patient_id)+"&contactdetails="+contact_details+"&FromQuery=Y";
	retVal					=await	window.showModalDialog(url,arguments,features);

}

async function ViewRefDetails()
{
	refid = document.getElementById("referral_id").value;
	var retVal = 	new String();
	var dialogHeight= "30vh" ;
	var dialogTop = "90" ;
	var dialogWidth	= "50vw" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var retVal =await window.showModalDialog("../../eOP/jsp/ViewPatReferral.jsp?referral_id="+refid,arguments,features);
}

async function callLastAdmission()
{
	var patid=document.getElementById("patient_id").value;
	var win_height="27vh";
	var win_width="48vw";
	var retVal = 	new String();
	var dialogHeight= win_height ;
	var dialogWidth	= win_width ;
	var dialogTop = "80" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eIP/jsp/LastAdmission.jsp?patientId="+patid ,arguments,features);
}
	</script>
	
	</head>
<%

String sql=	" Select a.patient_id, a.booking_ref_no, a.referral_id, ceil(exp_discharge_date_time-visit_adm_date_time) exp_length_of_stay, to_char(exp_discharge_date_time,'dd/mm/yyyy hh24:mi')exp_discharge_date_time, a.chief_complaint, c.short_desc circumstance_of_injury, d.short_desc team, e.short_desc patient_type, f.short_desc ambulatory_Status, b.escort_name,b.escort_add_ln1, b.escort_add_ln2, b.escort_add_ln3, b.escort_add_ln4, b.escort_add_postal_code,b.escort_tel_num, b.escort_mv_reg_no, b.emergency_detail,h.short_desc service, g.short_desc arrival,nvl2(referral_id,substr(get_referral_detail_line(referral_id,'FROM'),3),'') referral_details, b.visit_adm_desc from pr_encounter a, pr_Encounter_other_detail b, am_circumstance_of_injury c, am_medical_team d, am_patient_type e, am_ambulatory_status f, am_arrival g,am_service h WHERE a.facility_id = b.OPERATING_FACILITY_ID(+) AND a.encounter_id = b.encounter_id(+) AND a.facility_id = '"+facility_Id+"' AND a.encounter_id = "+encounterId+" AND a.circumstance_of_injury_code = c.circumstance_of_injury_code(+) AND a.facility_id = d.facility_id(+) AND a.team_id = d.team_id(+) AND a.patient_type = e.patient_type(+) AND a.ambulatory_status = f.ambulatory_status(+) AND b.operating_facility_id = g.facility_id(+) AND b.arrival_code = g.arrival_code(+) AND a.service_code=h.service_code";
	

 String sql2 = "Select a.to_nursing_unit_short_desc, a.to_specialty_short_desc, a.to_bed_class_short_desc, a.to_bed_no, a.to_room_no,a.nationality_desc, to_char(a.trn_date_time,'dd/mm/yyyy hh24:mi')trn_date_time, b.short_desc admission_type,to_char(a.OT_DATE_TIME,'dd/mm/yyyy hh24:mi')OT_DATE_TIME, a.to_practitioner_long_name, a.to_specialty_short_desc, a.added_by_id,c.appl_user_name,to_char(b.added_date,'dd/mm/yyyy hh24:mi')added_date  FROM ip_adt_trn_vw a, ip_admission_type b, sm_appl_user c WHERE a.trn_type = 'A' AND a.trn_code = b.admission_type_code AND a.added_by_id = c.appl_user_id AND a.facility_id = '"+facility_Id+"' AND a.encounter_id = "+encounterId+"";


 	Connection con	= null;
 	java.sql.Statement stmt	= null;
	java.sql.Statement stmt2 = null;
 	ResultSet rset	= null;
	ResultSet rset2	= null;
	
	try{
		con = ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		stmt2 = con.createStatement();
	 	rset = stmt.executeQuery(sql);		
		rset2 = stmt2.executeQuery(sql2);
		
		while(rset.next())
 		{
			
			
				booking_ref_no=rset.getString("booking_ref_no");
				if(booking_ref_no == null || booking_ref_no.equals("null")) booking_ref_no=""; 				
		 
			 
				referral_id=rset.getString("referral_id");
				if( referral_id == null) referral_id=""; 	
				referral_details=rset.getString("referral_details");
				if( referral_details == null) referral_details=""; 	
				
							
				exp_length_of_stay=rset.getString("exp_length_of_stay");
				if( exp_length_of_stay == null || exp_length_of_stay.equals("null")) exp_length_of_stay="&nbsp;";	
				
				exp_discharge_date_time=rset.getString("exp_discharge_date_time");
				if( exp_discharge_date_time == null || exp_discharge_date_time.equals("null")) exp_discharge_date_time="&nbsp;";
				
				service= rset.getString("service");
				if( service == null) service="";
				
				chief_complaint= rset.getString("chief_complaint");
				if( chief_complaint == null) chief_complaint="";  
				
				circumstance_of_injury=rset.getString("circumstance_of_injury");
				if( circumstance_of_injury == null) circumstance_of_injury="";
				
				team=rset.getString("team");
				if( team == null) team="";

				remarks = rset.getString("visit_adm_desc");
				if( remarks == null) remarks="";

				patient_type=rset.getString("patient_type");
				if( patient_type == null) patient_type="";

				ambulatory_Status=rset.getString("ambulatory_Status");
				if( ambulatory_Status == null) ambulatory_Status="";

				arrival=rset.getString("arrival");
				if( arrival == null) arrival="";

				escort_name=rset.getString("escort_name");
				if( escort_name == null) escort_name="";				

				escort_add_ln1=rset.getString("escort_add_ln1");
				if( escort_add_ln1 == null) escort_add_ln1="";

				escort_add_ln2=rset.getString("escort_add_ln2");
				if( escort_add_ln2 == null) escort_add_ln2="";

				escort_add_ln3=rset.getString("escort_add_ln3");
				if( escort_add_ln3 == null) escort_add_ln3="";

				escort_add_ln4=rset.getString("escort_add_ln4");
				if( escort_add_ln4 == null) escort_add_ln4="";

				escort_add_postal_code=rset.getString("escort_add_postal_code");
				if( escort_add_postal_code == null) escort_add_postal_code="";

				escort_tel_num=rset.getString("escort_tel_num");
				if( escort_tel_num == null) escort_tel_num="";

				escort_mv_reg_no=rset.getString("escort_mv_reg_no");
				if( escort_mv_reg_no == null) escort_mv_reg_no="";

				emergency_detail=rset.getString("emergency_detail");
				if( emergency_detail == null) emergency_detail="";
				

		}//End of While	
		if(rset!=null)rset.close();
		if(stmt!=null)stmt.close();
	


		while(rset2.next())
 		{
				to_nursing_unit_short_desc=rset2.getString("to_nursing_unit_short_desc");
				if( to_nursing_unit_short_desc == null) to_nursing_unit_short_desc="";

				to_specialty_short_desc=rset2.getString("to_specialty_short_desc");
				if( to_specialty_short_desc == null) to_specialty_short_desc="";

				to_bed_class_short_desc=rset2.getString("to_bed_class_short_desc");
				if( to_bed_class_short_desc == null) to_bed_class_short_desc="";

				to_bed_no=rset2.getString("to_bed_no");
				if( to_bed_no == null) to_bed_no="";

				to_room_no=rset2.getString("to_room_no");
				if( to_room_no == null) to_room_no="";				

				trn_date_time=rset2.getString("trn_date_time");
				if( trn_date_time == null || trn_date_time.equals("null")) trn_date_time="&nbsp;"; 	

				admission_type=rset2.getString("admission_type");
				if( admission_type == null) admission_type="";

				OT_DATE_TIME=rset2.getString("OT_DATE_TIME");
				if( OT_DATE_TIME == null || OT_DATE_TIME.equals("null")) OT_DATE_TIME="&nbsp;"; 

				nationality_desc=rset2.getString("nationality_desc");
				if( nationality_desc == null) nationality_desc="";

				appl_user_name=rset2.getString("appl_user_name");
				if( appl_user_name == null) appl_user_name="";

				added_date=rset2.getString("added_date");
				if( added_date == null) added_date="";
				to_practitioner_long_name=rset2.getString("to_practitioner_long_name");
				if( to_practitioner_long_name == null) to_practitioner_long_name="";
		}

					String		prevVisit		=	"";
					java.sql.Statement	stmt3			=	null;
					ResultSet	rsPrevVisit		=	null;

					prevVisit	= "select 1 from ip_patient_last_encounter where patient_id='"+patientId+"' and rownum < 2";
					if (stmt3!=null) stmt3.close();
					stmt3 = con.createStatement();
					rsPrevVisit = stmt3.executeQuery(prevVisit);
					if(rsPrevVisit.next())
					{
					flag="enabled";         
						}
						else
						{
					flag="disabled";
						}
                    if (rsPrevVisit!=null) rsPrevVisit.close();
                    if (stmt3!=null) stmt3.close();

	 %>
 <BODY onLoad="validatebutton()" onKeyDown = 'lockKey()'>
 <FORM NAME = "currentencounter_form"> 
 <table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
  <tr> 	  <th colspan='5' align='left'><fmt:message key="Common.AdmissionDetails.label" bundle="${common_labels}"/></th> </tr> 
  <tr>
   	  <td width='1%'>&nbsp;</td>   	  
 	  <td align=right class='label' width='10%'><fmt:message key="Common.BookingRefNo.label" bundle="${common_labels}"/>&nbsp;</td>
 	  <td  align ='left' class='QUERYDATA' align='center'>&nbsp;<%=booking_ref_no%> 	
 	  </td>  	  
 	  <td align=right class='label' width='10%'<fmt:message key="Common.referralid.label" bundle="${common_labels}"/>bsp;ID&nbsp;</td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=referral_id%> 	  	
 	  </td> 	
  </tr>
  <tr>
       	  <td class='DEFAULTBLANKROW' colspan="5">&nbsp;</td>
  </tr>
  <tr>
	  <td width='1%'>&nbsp;</td>
	  <td align=right class='label' width='10%'><fmt:message key="Common.nationality.label" bundle="${common_labels}"/>&nbsp;</td>
 	  <td width='25%' align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=nationality_desc%>	  	
 	  </td>
	  <td colspan='4'> </td>
  </tr>
<%if(referral_id !=""){%>
		        <th  colspan = 5 align='left'><fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/></th>
             <tr>
                <td  colspan = 5  align ='left' class="QUERYDATA">&nbsp;<%=referral_details%></td>
             </tr>
<%}%>
	
	<tr> 	  <th colspan='5' align='left'><fmt:message key="eAE.NursingDetails.label" bundle="${ae_labels}"/></th> </tr>	
	<tr>
   	  <td width='1%'>&nbsp;</td>
 	  <td align=right class='label' width='10%'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;</td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=to_nursing_unit_short_desc%> 	  	
 	  </td>
	  <td align=right class='label' width='10%'><fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp;</td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=service%></td> 
	</tr>
	<tr>
       <td class='DEFAULTBLANKROW' colspan="5">&nbsp;</td>
	</tr>
	<tr>
	  <td width='1%'>&nbsp;</td>	
 	  <td align=right class='label' width='10%'><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/>&nbsp;</td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=to_bed_class_short_desc%></td><td colspan='4'></td> 	
 	  
 	  	
	</tr>

	<tr>
       <td class='DEFAULTBLANKROW' colspan="5">&nbsp;</td>
	</tr>
    <tr>
   	  <td width='1%'>&nbsp;</td>
 	  <td align=right class='label' width='10%'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/>&nbsp; </td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=to_bed_no%> 	  	
 	  </td>
	  <td align=right class='label' width='10%'><fmt:message key="Common.roomno.label" bundle="${common_labels}"/>&nbsp;</td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=to_room_no%></td> 
	</tr>	
	<tr> 	  <th colspan='7' align='left'><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></th> </tr>	
	<tr>
   	  <td width='1%'>&nbsp;</td>
 	  <td align=right class='label' width='20%'><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/>&nbsp;</td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=trn_date_time%> 	  	
 	  </td>
	  <td align=right class='label' width='20%'><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/>&nbsp;</td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=admission_type%></td> 
	</tr>
	<tr>
       	  <td class='DEFAULTBLANKROW' colspan="5">&nbsp;</td>
	</tr>
	<tr>
	  <td width='1%'>&nbsp;</td>
 	  <td align=right class='label' width='15%'>Chief Complaint&nbsp;</td>
 	  <td colspan='5' align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=chief_complaint%></td>
	  
	</tr>
	<tr>
       	  <td class='DEFAULTBLANKROW' colspan="5">&nbsp;</td>
	</tr>	
	<tr>
   	  <td width='1%'>&nbsp;</td>
 	  <td align=right class='label' width='20%'nowrap><fmt:message key="eAE.ExpLengthOfStay.label" bundle="${ae_labels}"/>&nbsp;</td>
 	  <td align ='left' class='QUERYDATA'  align='center'>&nbsp;<%=exp_length_of_stay%> 	  	
 	  </td>
	  <td align=right class='label' width='15%'nowrap>Expected&nbsp;Discharge Date&nbsp;</td>
 	  <td align ='left' class='QUERYDATA'  align='center'>&nbsp;<%=exp_discharge_date_time%></td> 
	</tr>
	<tr>
       <td class='DEFAULTBLANKROW' colspan="5">&nbsp;</td>
	</tr>
	  <tr>
	 <td width='1%'>&nbsp;</td>
 	  <td align=right class='label' width='20%'nowrap><fmt:message key="Common.CircumstanceofInjury.label" bundle="${common_labels}"/>&nbsp; </td>
 	  <td align ='left' class='QUERYDATA'  align='center'>&nbsp;<%=circumstance_of_injury%> 	  	
 	  </td>   	 
 	  <td align=right class='label' width='15%'><fmt:message key="eAE.OTDateTime.label" bundle="${ae_labels}"/>&nbsp; </td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=OT_DATE_TIME%> 	  	
 	  </td>
	   
	</tr>
	<tr>
       	  <td class='DEFAULTBLANKROW' colspan="5">&nbsp;</td>
	</tr>
	<tr>
		 <td width='1%'>&nbsp;</td>
 	 <td align=right class='label' width='10%'>Specialty&nbsp;</td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=to_specialty_short_desc%></td>
   	 <td align=right class='label' width='15%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;</td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=to_practitioner_long_name%></td>
	 
	</tr>
	<tr>
       	  <td class='DEFAULTBLANKROW' colspan="5">&nbsp;</td>
	</tr>
	<tr>
	 <td width='1%'>&nbsp;</td>
   	  <td align=right class='label' width='15%'><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/>&nbsp;</td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=team%></td> 
	  <td align=right class='label' width='15%'><fmt:message key="Common.patienttype.label" bundle="${common_labels}"/>&nbsp;</td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=patient_type%></td> 
	</tr>
	<tr>
       	  <td class='DEFAULTBLANKROW' colspan="5">&nbsp;</td>
	</tr>
	<tr>
	 <td width='1%'>&nbsp;</td>
   	  <td align=right class='label' width='15%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;</td>
 	  <td align ='left' class='QUERYDATA' align='center' colspan='3'>&nbsp;<%=remarks%></td> 
	</tr>
	<tr>
       	  <td class='DEFAULTBLANKROW' colspan="5">&nbsp;</td>
	</tr>
	<tr>  <th colspan='7' align='left'><fmt:message key="Common.additionaldetails.label" bundle="${common_labels}"/></th></tr>	
	<tr>
   	  <td width='1%'>&nbsp;</td>
	  <td align=right class='label' width='15%'><fmt:message key="Common.ambulatorystatus.label" bundle="${common_labels}"/>&nbsp;</td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=ambulatory_Status%></td> 
 	  <td align=right class='label' width='20%'><fmt:message key="Common.ModeofArrival.label" bundle="${common_labels}"/>&nbsp; </td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=arrival%> 	  	
 	  </td>
	</tr>
	
	<tr>
      <td class='DEFAULTBLANKROW' colspan="5">&nbsp;</td>
	</tr>
		  <tr>
   	  <td width='1%'>&nbsp;</td>
	  <td align=right class='label' width='15%'><fmt:message key="eAE.EscortName.label" bundle="${ae_labels}"/>&nbsp; </td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=escort_name%> 	  	
 	  </td>	 
 	  <td align=right class='label' width='20%'>Line 1&nbsp; </td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=escort_add_ln1%> 	  	
 	  </td>	  
	</tr>
	<tr>
      <td class='DEFAULTBLANKROW' colspan="5">&nbsp;</td>
	</tr>
		  <tr>
   	  <td width='1%'>&nbsp;</td>
	  <td align=right class='label' width='15%'>Line 2&nbsp;</td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=escort_add_ln2%></td> 
 	  <td align=right class='label' width='20%'>Line 3&nbsp; </td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=escort_add_ln3%> 	  	
 	  </td>	   
	</tr>
	<tr>
      <td class='DEFAULTBLANKROW' colspan="5">&nbsp;</td>
	</tr>
	<tr>
   	  <td width='1%'>&nbsp;</td>
	  <td align=right class='label' width='15%'>Line 4&nbsp;</td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=escort_add_ln4%></td>
 	   <td align=right class='label' width='15%'><fmt:message key="eMP.postalcode.label" bundle="${mp_labels}"/>&nbsp;</td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=escort_add_postal_code%></td> 	  	
 	  </td>
	   
	</tr>
		<tr>
      <td class='DEFAULTBLANKROW' colspan="5">&nbsp;</td>
	</tr>
		  <tr>
   	  <td width='1%'>&nbsp;</td>
	 <td align=right class='label' width='20%'><fmt:message key="Common.telno.label" bundle="${common_labels}"/>&nbsp; </td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=escort_tel_num%>
 	  <td align=right class='label' width='15%'>MV Regn No&nbsp;</td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=escort_mv_reg_no%></td> 	  	
 	  </td>	   
	</tr>
	<tr>
      <td class='DEFAULTBLANKROW' colspan="5">&nbsp;</td>
	</tr>
	<tr>
	  <td width='1%'>&nbsp;</td>
 	  <td align=right class='label' width='15%'>Emergency Detail&nbsp;</td>
 	  <td colspan='5' align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=emergency_detail%></td>
	  
	</tr>
	<tr>
      <td class='DEFAULTBLANKROW' colspan="5">&nbsp;</td>
	</tr>
	  <tr>
   	  <td width='1%'>&nbsp;</td>
	 <td align=right class='label' width='20%'><fmt:message key="eAE.AddedBy.label" bundle="${ae_labels}"/>&nbsp; </td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=appl_user_name%>
 	  <td align=right class='label' width='15%'><fmt:message key="eAE.AddedDateTime.label" bundle="${ae_labels}"/>&nbsp;</td>
 	  <td align ='left' class='QUERYDATA' nowrap align='center'>&nbsp;<%=added_date%></td> 	  	
 	  </td>	   
	</tr>
	<tr>
      <td class='DEFAULTBLANKROW' colspan="5">&nbsp;</td>
	</tr>
</table> 
 
<table cellpadding=0 cellspacing=0 align="right" width="20%" border=0>
<tr>	
	<td class='WHITE'><input type="button" name='contact_details' id='contact_details' class="button" value="Contact Details" onClick="showContactDetails()" ></td>
	<td class='WHITE'><input type="button" name='PrevIPVisit' id='PrevIPVisit' class="button" value="Previous IP Stay" onClick="callLastAdmission()" <%=flag%> ></td>
	<td class='WHITE'><input type="button" name='referal_details' id='referal_details' class="button" value="Referral Details" onClick="ViewRefDetails()"  disabled></td>
</tr>
</table>
		<input type='hidden' name='booking_ref_no' id='booking_ref_no' value='<%=booking_ref_no%>'></input>
		<input type='hidden' name='referral_id' id='referral_id' value='<%=referral_id%>'></input>
		<input type='hidden' name='patient_id' id='patient_id' value='<%=patientId%>'></input>
<%
 // }
	}catch(Exception e) {e.printStackTrace();}
	finally
	{
		if (rset != null) rset.close();
		if (stmt != null) stmt.close();
		if (rset2 != null) rset2.close();
		if (stmt2 != null) stmt2.close();

		ConnectionManager.returnConnection(con,request);
	}

%>  
	</table>
</FORM>
</body>
</html>

