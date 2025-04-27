<!DOCTYPE html>
<html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html; charset=UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>

  <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    String facilityid = checkForNull((String) session.getValue("facility_id"));	
	String locale = checkForNull((String)session.getAttribute("LOCALE"));
	String classValue		="";
	String paitentId_length="";
	String pat_status="";
	String visit_adm_date_time="";
	String discharge_date_time="";
	String patient_class="";
	String patient_type="";
	String encounter_id="";
	String sql      ="";
	int counter				= 0  ;
	Connection  con = null ;
    Statement stmt1 = null ;
    ResultSet rset  = null ;
	PreparedStatement pstmt=null;
	
	try{
	con=ConnectionManager.getConnection(request);
	sql="select patient_id_length from mp_param";
	pstmt = con.prepareStatement(sql);
    rset=pstmt.executeQuery();
	if(rset.next())
	{
	paitentId_length=rset.getString("patient_id_length");
	}
	String patientid=request.getParameter("patientid")==null?"":request.getParameter("patientid");
	String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");
	
	String pat_id="";
	
	
	
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eOP/js/RegOutReferral.js' language='javascript'></script>
<script src='../../eMP/js/VwEncounterDetails.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 
</head>
<body onMouseDown="CodeArrest();" onLoad="FocusFirstElement();" onKeyDown ='lockKey();' >
<form name='RegOutReferralCriteria' id='RegOutReferralCriteria' method='post' action='' target="messageFrame">   
<table border="0" width='97%' cellspacing='0' cellpadding='2' >
<tr>
	<td class='label'  width='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
    <input type='text' name='pat_id1' id='pat_id1' value='<%=patientid%>' maxlength='<%=paitentId_length%>' size='<%=paitentId_length%>' onBlur="setValue(this);" onChange="" ><input type='button'  class='button' value='?' name='srch' id='srch' onClick="getPatID()" > 
	
</td> </tr>

</table>
 <!--Patient id validation-->
 
 <%
 webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
patdata.setFacility_id(facilityid);

if(!patientid.equals("")){
 pat_status = patdata.CheckStatus(con,patientid);}
 boolean isProceed	= true;  //declare by dharma
 if (pat_status.equals("SUSPENDED")){
    out.println("<script>alert(parent.frames[1].getMessage('PAT_SUSPENDED_NOT_ALLOWED','MP'));parent.frames[1].document.forms[0].pat_id1.value=''; </script>");
    isProceed	= false;
 }else if (pat_status.equals("DECEASED")){
    out.println("<script>alert(parent.frames[1].getMessage('PAT_DECEASED_NOT_ALLOWED','MP'));parent.frames[1].document.forms[0].pat_id1.value=''; </script>");
    isProceed	= false;
 }else if (pat_status.equals("SECURED")){
    out.println("<script>alert(parent.frames[1].getMessage('SECURED_NOT_ALLOWED','COMMON'));parent.frames[1].document.forms[0].pat_id1.value=''; </script>");
    isProceed	= false;
 }else if (pat_status.equals("INACTIVE")){
    out.println("<script>alert(parent.frames[1].getMessage('PAT_INACTIVE_NOT_ALLOWED','MP'));parent.frames[1].document.forms[0].pat_id1.value=''; </script>");
    isProceed	= false;
 }else if ( pat_status.equals("INVALID_PATIENT")){
	out.println("<script>alert(parent.frames[1].getMessage('INVALID_PATIENT','MP'));parent.frames[1].document.forms[0].pat_id1.value=''; </script>");
	isProceed	= false;
 }else if (pat_status.equals("BLACKLISTED_PATIENT")){
   out.println("<script>alert(parent.frames[1].getMessage('BLACKLISTED_PATIENT','MP'));parent.frames[1].document.forms[0].pat_id1.value=''; </script>");
   isProceed	= false;
 }
     
   %>
   <!--Patient id validation end-->
   
   <!--Patietn Encouter Information Displaying-->
   <!--Below line Modified for this CRF Bru-HIMS-CRF-261-->

   <%if(isProceed &&  !patientid.equals("")){%>
   <div  style="position:relative;height:130px;vertical-align:top;overflow:auto"> 			
		<table border="1" width='100%'  align="center" cellspacing=0 cellpadding=2 >
			<thead id="TabHead">
		<!-- <tr style='position:absolute;top:expression(this.offsetParent.scrollTop); height:35px'  >-->
		<tr style='position: sticky; top: 0; height: 35px;background-color:#83AAB4;'> <!-- above line was commented beacuse of aligmnet issue and add <tr> during IE to Edge conversion  -->
		<td   nowrap class="columnheader" style="color:white;"><fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/></td>
		<td   nowrap class="columnheader" style="color:white;"><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td> 
		<td   nowrap class="columnheader" style="color:white;"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td   nowrap class="columnheader" style="color:white;"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td   nowrap class="columnheader" style="color:white;"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td   nowrap class="columnheader" style="color:white;"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td   nowrap class="columnheader" style="color:white;"><fmt:message key="Common.Disposition.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
		</tr> 

		 </thead>
		  <!-- <tr><td colspan='7' height='40px'>&nbsp;</td></tr>  -->
		<%}%>
   <%

  /*if( pat_status.equals(""))
   {*/
  if(isProceed){
   sql="SELECT   a.encounter_id, a.patient_id, a.op_episode_visit_num visitid, a.episode_id eid,TO_CHAR (a.visit_adm_date_time, 'DD/MM/YYYY HH24:MI') visit_adm_date_time,a.visit_adm_date_time encounter_date, a.assign_care_locn_type,am_get_desc.am_care_locn_type (a.assign_care_locn_type, '"+locale+"', '1') assign_care_locn_type_desc,a.assign_care_locn_code,DECODE (a.assign_care_locn_type,'N', (ip_get_desc.ip_nursing_unit (a.facility_id, a.assign_care_locn_code, '"+locale+"', '1')),(op_get_desc.op_clinic (a.facility_id, a.assign_care_locn_code, '"+locale+"', '1'))) assign_care_locn_desc,a.service_code, am_get_desc.am_service (a.service_code, '"+locale+"', '2') service_short_desc, a.subservice_code,am_get_desc.am_subservice (a.service_code, a.subservice_code, '"+locale+"', '2') subservice_short_desc,a.assign_room_num, a.assign_bed_num, a.attend_practitioner_id,am_get_desc.am_practitioner (a.attend_practitioner_id, '"+locale+"', '1') practitioner_name, a.appt_id,a.patient_class patient_class, am_get_desc.am_patient_class (a.patient_class, '"+locale+"', '1') patient_class_desc,a.disposition_type,DECODE (a.patient_class,'IP', (ip_get_desc.ip_discharge_type (a.disposition_type, '"+locale+"', '2')),(am_get_desc.am_disposition_type (a.disposition_type, '"+locale+"', '1'))) disposition_type_desc,TO_CHAR (a.discharge_date_time, 'DD/MM/YYYY HH24:MI') discharge_date_time, a.disp_referral_id FROM pr_encounter a WHERE a.facility_id = '"+facilityid+"' AND (a.encounter_id <> '' OR NVL ('', 'X') = NVL ('', 'X')) AND a.patient_id = '"+patientid+"' AND TRUNC (a.visit_adm_date_time) BETWEEN NVL (TO_DATE ('', 'DD/MM/YYYY'), TO_DATE ('01/01/1900', 'DD/MM/YYYY'))AND NVL (TO_DATE ('', 'DD/MM/YYYY'), TO_DATE ('31/12/5000', 'DD/MM/YYYY'))AND a.patient_class = DECODE ('', '', a.patient_class, '') ORDER BY encounter_date DESC";
   
   
   
   
   pstmt = con.prepareStatement(sql);
     rset=pstmt.executeQuery();
    while (rset.next())
	{  pat_id=patientid;
	      counter++;
	      if ( counter % 2 == 0 )
		  	classValue = "QRYODD" ;
		 else
		  	classValue = "QRYEVEN" ;
				visit_adm_date_time=rset.getString("VISIT_ADM_DATE_TIME");
				if(visit_adm_date_time != null)
		       {
			visit_adm_date_time= DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",localeName);
		       }
		      else
			 visit_adm_date_time="";
			
			patient_class=checkForNull(rset.getString("PATIENT_CLASS_DESC"));
			patient_type=checkForNull(rset.getString("patient_class"));
			discharge_date_time=rset.getString("DISCHARGE_DATE_TIME");
			if(discharge_date_time != null)
			{
				discharge_date_time= DateUtils.convertDate(discharge_date_time,"DMYHM","en",localeName);
			}
			 else
				discharge_date_time="&nbsp;";
				
				
			
				
	%>	<tbody>
		<tr>
		<td  width='150px'  align='left' nowrap class='<%=classValue%>'><%=visit_adm_date_time%></td> 
		<td  width='120px' align='left' nowrap class='<%=classValue%>' ><%=(rset.getString("PATIENT_CLASS_DESC")==null)?"&nbsp;":rset.getString("PATIENT_CLASS_DESC")%></td>
			<% encounter_id = rset.getString("ENCOUNTER_ID")==null?"":rset.getString("ENCOUNTER_ID");%>	
		
		<td width='110px' nowrap align='left' class="<%=classValue%>"><a name='ss' href='javascript:RegisterMoreReferral("<%=encounter_id%>","<%=patientid%>","<%=patient_type%>","<%=discharge_date_time%>")'><%=encounter_id%> </a></td>
		 <td  width='120px' align='left' nowrap class='<%=classValue%>' ><%=(rset.getString("ASSIGN_CARE_LOCN_TYPE_DESC")==null)?"&nbsp;":rset.getString("ASSIGN_CARE_LOCN_TYPE_DESC")%></td>
		<td  width='180px' align='left' nowrap class='<%=classValue%>' ><%=(rset.getString("ASSIGN_CARE_LOCN_DESC")==null)?"&nbsp;":rset.getString("ASSIGN_CARE_LOCN_DESC")%></td>
		<td  width='120px' align='left' nowrap class='<%=classValue%>' ><%=(rset.getString("PRACTITIONER_NAME")==null)?"&nbsp;":rset.getString("PRACTITIONER_NAME")%></td>
			
		<td  width='170px' align='left' nowrap class='<%=classValue%>' ><%=discharge_date_time%></td>
				 
		</tr>
	</tbody >
	    
	
	 <%  pat_status="valid_pat"; }
      //if(pat_status.equals("") && counter == 0 )
   	 if(isProceed && counter == 0 )
	 	 out.println("<script> if(parent.frames[1].document.forms[0].pat_id1.value){parent.frames[1].location.href='../../eMP/jsp/RegOutReferralCriteria.jsp'; alert(parent.frames[1].getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));} parent.frames[1].document.forms[0].pat_id1.value='';  </script>");
	 
	 } else{ pat_status="invalid";}  %>
  

    <!--Patietn Encouter Information Displaying-->
   
<input type='hidden' name='pat_status' id='pat_status' value="<%=pat_status%>">
<input type='hidden' name='pat_id' id='pat_id' value="<%=pat_id%>"> 
<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>">

</table>
</div>
</form>
<%}catch (Exception e){  e.printStackTrace();}
finally{
		try
		{ 
		 if(rset != null) rset.close();
		 if(stmt1 != null) stmt1.close();
		}catch (Exception e) {
			e.printStackTrace();
		}	
	if(con!=null) ConnectionManager.returnConnection(con,request);
		}
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		 return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
%>

</body>
</html>

