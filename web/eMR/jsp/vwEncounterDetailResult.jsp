<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,com.ehis.util.*,java.util.*, webbeans.eCommon.* , java.text.* , java.sql.Date,eCommon.XSSRequestWrapper" %>  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<Script>
	function getNext(flagSelect)
	{
	   var patientid		= document.forms[0].patientid.value ;
	   var from				= document.forms[0].from.value ;
	   var to				= document.forms[0].to.value ;	   
	   var flag				= flagSelect ;
	   var previousRecord	= document.forms[0].previousRecord.value;
	   var nextRecord		= document.forms[0].nextRecord.value ;
       var facility			= document.forms[0].facility.value ;
	   var encounType		= document.forms[0].encounType.value ;
	   var encounterID		= document.forms[0].encounterID.value;	   
	   var order_by			= document.forms[0].order_by.value;
	   var p_all_facility_id	= document.forms[0].p_all_facility_id.value;//added forBru-HIMS-CRF-380 Start
	   document.location.href='../../eMR/jsp/vwEncounterDetailResult.jsp?from=' + from + '&to=' + to + '&facility=' + facility + '&patientid=' +  patientid +'&flag=' + flag + '&nextRecord=' + nextRecord+'&previousRecord=' + previousRecord +
	   '&facility=' +  facility + '&encounType=' + encounType +'&encounterID=' +encounterID+'&order_by=' + order_by+'&p_all_facility_id='+p_all_facility_id; ;
	}


async function viewReferral(ref,res_facility_id)
{	
	var retVal = 	new String();
	var dialogHeight= "40vh" ;
	var dialogTop = "57" ;
	var dialogWidth	= "70vw" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	retVal =await window.showModalDialog("../../eMP/jsp/ViewPatReferral.jsp?referral_id="+ref+"&FacilityId="+res_facility_id,arguments,features);
}
	

async function viewToRefDtls(encID, PatID,res_facility_id)
{
	var retVal = new String();
	var dialogHeight= "30vh";
	var dialogWidth = "64vw";
	var dialogTop 	= "232";
	var center		= "1";
	var status		= "no";
	var arguments	= "";
	var features	= "dialogHeight:"+dialogHeight+";scroll=no;dialogWidth:"+dialogWidth+";center:"+center+";status:"+status+";dialogTop:"+dialogTop;

	retVal = await	window.showModalDialog("../../eMP/jsp/ReferralDetailsResult.jsp?Transaction_type=MR&encounter_id="+encID+"&patient_id="+PatID+"&facility_id="+res_facility_id,arguments,features);
}

async function viewDiagnosis(encID, PatID,res_facility_id)
{
	var retVal = 	new String();
	var call_function = "VIEW_ENCOUNTER_DTLS";
	//var FacilityId = document.forms[0].facility.value;
	var FacilityId = res_facility_id;//added forBru-HIMS-CRF-380
	var dialogHeight= "80vh" ;
	var dialogWidth = "80vw" ;
	var dialogTop 	= "232";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; " ;
	var arguments	= "" ;
	retVal = 	await window.showModalDialog("../../eMR/jsp/RecodeDiagnosis.jsp?Encounter_Id="+encID+"&FacilityId="+FacilityId+"&PatientId="+PatID+"&call_function="+call_function,arguments,features);
}

async function viewFile(PatID,res_facility_id)
{
	var retVal = 	new String();
	var call_function = "VIEW_ENCOUNTER_DTLS";
	//var FacilityId = document.forms[0].facility.value;
	var FacilityId = res_facility_id; //added forBru-HIMS-CRF-380
	//var dialogHeight= "17" ;
	var dialogHeight= "80vh" ;
	var dialogWidth = "95vw" ;
	var dialogTop 	= "162";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; " ;
	var arguments	= "" ;
	retVal= await window.showModalDialog("../../eMR/jsp/vwPatFileDetailmain.jsp?Patient_Id="+PatID+"&call_function="+call_function+"&FacilityId="+FacilityId,arguments,features);
}



async function view_appt_dtl(ref_no,res_facility_id)
{
    var retVal =    new String();
    var dialogHeight= "90vh" ;
    var dialogWidth = "95vw" ;
    var dialogTop = "100" ;
    var center = "1" ;
    var status="no";
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
    var arguments   = "" ;

    retVal = await window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?i_appt_ref_no="+ref_no+"&flag=Visit_Reg"+"&FacilityId="+res_facility_id,arguments,features);
}

async function showEncounter(enc,patid,Patient_Class,res_facility_id)
{
	
	var call_function = "VIEW_ENCOUNTER_DTLS";
	var jsp_name="CurrentEncounterMain.jsp";
	var win_height = "80vh";
	var win_width= "95vw";
	var retVal = 	new String();
	var dialogHeight= win_height ;
	var dialogWidth	= win_width ;
	var dialogTop = "61" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + ";";
	var arguments	= "" ;

	retVal = 
await window.showModalDialog("../../eMR/jsp/"+jsp_name+"?encounterId="+enc+"&call_function="+call_function+"&patientId="+patid+"&Patient_Class="+Patient_Class+"&facilityId="+res_facility_id,arguments,features);


}


 </Script>
<%
		Connection con = ConnectionManager.getConnection(request);
		Statement newstmt	= null;
		ResultSet rset	= null ;

		//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy") ;

	//	String queryCriteria	= (request.getParameter("criteria")==null)?"":request.getParameter("criteria") ;
		String flag				=
		(request.getParameter("flag")==null)?"":request.getParameter("flag");
		String facility			= (request.getParameter("facility")==null)?"":request.getParameter("facility") ;		
		
		
		String from				=
		(request.getParameter("from")==null)?"":request.getParameter("from") ;

		String to				=
		(request.getParameter("to")==null)?"":request.getParameter("to");

		String patientid		= (request.getParameter("patientid")==null)?"":request.getParameter("patientid") ;		
		String encounType		= (request.getParameter("encounType")==null)?"":request.getParameter("encounType") ;
		String encounterID		= (request.getParameter("encounterID")==null)?"":request.getParameter("encounterID") ;//This is obtained as part of search criteria
		String order_by		= (request.getParameter("order_by")==null)?"":request.getParameter("order_by") ;	
		String fid=(request.getParameter("fid")==null)?"":request.getParameter("fid") ;	
        String encounter_id = ""; // this is used for passing the encounter id to diagnosis recode page
		String    nextRecord	=request.getParameter("nextRecord");
           if(nextRecord==null) nextRecord="";
		String   previousRecord	=request.getParameter("previousRecord"); 
		String p_all_facility_id = 	(request.getParameter("p_all_facility_id")==null)?"":request.getParameter("p_all_facility_id") ; //added forBru-HIMS-CRF-380 Start
if(previousRecord==null) previousRecord="";
%>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script language='javascript' src='../js/AdverseReaction.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>

		async function GetShowRemarks(name,remarksvalue,remarkstype)
		{
			var comments;
			var inputArr = document.getElementsByTagName("input");
			for (u=0;u<inputArr.length;u++)
			{
				if (inputArr[u].name == name)
				{
					comments = inputArr[u].value;
				}
			}

			var retVal;
			var dialogHeight ='9vh' ;
			var dialogWidth = '30vw' ;
			var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
			var arguments;

			   if(comments=='' || comments == "null")
				  comments ='';
				arguments = comments ;

			retVal =await window.showModalDialog('../../eFM/jsp/GetShowRemarks.jsp?title=Return Remarks&RemarksValue='+escape(remarksvalue)+'&RemarksType='+remarkstype,arguments,features);

				for (u=0;u<inputArr.length;u++){
					if (inputArr[u].name == name){
						inputArr[u].value = ''+retVal+'';
					}
				}
		}
		
function submitPrevNext(fromRecordNumber,toRecordNumber,fid){
	document.forms[0].previousRecord.value = fromRecordNumber;
   document.forms[0].nextRecord.value = toRecordNumber; 
    document.forms[0].fid.value =fid; 
	document.EncounterResultForm.submit();
	
}
</script>
 <head>

 <BODY onMouseDown="CodeArrest();"  onKeyDown='lockKey()'>
 <form name="EncounterResultForm" id="EncounterResultForm" action="../../eMR/jsp/vwEncounterDetailResult.jsp" method="post" 	onUnLoad="window.close()">

<%                  

		int counter				= 0 ;
		int fromRecordNumber	= 0 ;
		int toRecordNumber  	= 0 ;
		int noOfRecords			= 0 ;
		String sql				= "";
		String classValue		= "";
		String locale			=(String) session.getAttribute("LOCALE");
		String facilityId		= (String)session.getValue("facility_id");
		String vis_dat_display	= "";
		String dis_dat_display	= "";
		String VarWhereFacility	= (p_all_facility_id.equals(""))?"":"AND A.FACILITY_ID = '"+p_all_facility_id+"'";	//added forBru-HIMS-CRF-380 Start
		
	     
	if ( previousRecord == null )
		fromRecordNumber = 1 ;
	else
	{
		if(previousRecord.equals(""))fromRecordNumber=1;
		else
		{
		fromRecordNumber = Integer.parseInt( previousRecord ) ;

		}
	}

	if ( nextRecord == null )
		toRecordNumber = 10 ;
		

	else
	{
		if(nextRecord.equals(""))toRecordNumber=10;
		else
		{
		toRecordNumber = Integer.parseInt( nextRecord ) ;

		}
	}

 %>

  <%try{%>

	 <%

	 	if(from != null)
		{
			from = "'" + from + "'" ;
		}

		if(to != null)
		{
			to   = "'" + to + "'" ;
		}

		/*sql = " SELECT A.ENCOUNTER_ID, A.PATIENT_ID, A.EPISODE_ID, TO_CHAR (A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE_TIME, A.VISIT_ADM_DATE_TIME ENCOUNTER_DATE, A.ASSIGN_CARE_LOCN_TYPE, B.SHORT_DESC ASSIGN_CARE_LOCN_TYPE_DESC, A.ASSIGN_CARE_LOCN_CODE,DECODE (A.ASSIGN_CARE_LOCN_TYPE,'C', C.SHORT_DESC,'N', D.SHORT_DESC) ASSIGN_CARE_LOCN_DESC,A.SERVICE_CODE,I.SHORT_DESC SERVICE_SHORT_DESC,A.SUBSERVICE_CODE,J.SHORT_DESC SUBSERVICE_SHORT_DESC,A.ASSIGN_ROOM_NUM, A.ASSIGN_BED_NUM, A.ATTEND_PRACTITIONER_ID,E.PRACTITIONER_NAME, A.APPT_ID, A.PATIENT_CLASS,F.SHORT_DESC PATIENT_CLASS_DESC, A.DISPOSITION_TYPE,DECODE (A.PATIENT_CLASS,'IP', G.SHORT_DESC, H.SHORT_DESC) DISPOSITION_TYPE_DESC,TO_CHAR (A.DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI') DISCHARGE_DATE_TIME, A.REFERRAL_ID, (SELECT COUNT (1) FROM MR_PAT_FILE_INDEX WHERE facility_id = a.facility_id AND patient_id = a.patient_id) FILE_COUNT, (SELECT COUNT (1) from PR_PROBLEM WHERE onset_facility_id = a.facility_id AND onset_encounter_id = a.encounter_id ) DIAG_COUNT FROM PR_ENCOUNTER A, AM_CARE_LOCN_TYPE B, OP_CLINIC C, IP_NURSING_UNIT D, AM_PRACTITIONER E, AM_PATIENT_CLASS F, IP_DISCHARGE_TYPE G, AM_DISPOSITION_TYPE H,AM_SERVICE I, AM_SUBSERVICE J WHERE A.FACILITY_ID = '"+facilityId+"' AND A.ENCOUNTER_ID = NVL ('"+encounterID+"', A.ENCOUNTER_ID) AND A.PATIENT_ID = '"+patientid+"' AND A.ASSIGN_CARE_LOCN_TYPE = B.LOCN_TYPE AND A.FACILITY_ID = C.FACILITY_ID(+) AND A.ASSIGN_CARE_LOCN_CODE = C.CLINIC_CODE(+) AND A.FACILITY_ID = C.FACILITY_ID(+) AND A.ASSIGN_CARE_LOCN_CODE = D.NURSING_UNIT_CODE(+) AND A.ATTEND_PRACTITIONER_ID = E.PRACTITIONER_ID(+) AND A.PATIENT_CLASS = F.PATIENT_CLASS AND A.DISPOSITION_TYPE = G.DISCHARGE_TYPE_CODE(+)AND A.DISPOSITION_TYPE = H.DISP_TYPE(+) AND A.SERVICE_CODE = I.SERVICE_CODE (+) AND A.SUBSERVICE_CODE = J.SUBSERVICE_CODE (+) AND TRUNC (A.VISIT_ADM_DATE_TIME) BETWEEN NVL (TO_DATE ("+from+", 'DD/MM/YYYY'), TO_DATE ('01/01/1900','DD/MM/YYYY')) AND NVL (TO_DATE ("+to+", 'DD/MM/YYYY'), TO_DATE ('31/12/5000','DD/MM/YYYY')) AND A.PATIENT_CLASS = DECODE ('"+encounType+"', '', A.PATIENT_CLASS, '"+encounType+"') ORDER BY "+order_by+" , ENCOUNTER_DATE DESC ";*/


		/*sql = "SELECT A.ENCOUNTER_ID, A.PATIENT_ID, A.EPISODE_ID,TO_CHAR (A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE_TIME,A.VISIT_ADM_DATE_TIME ENCOUNTER_DATE, A.ASSIGN_CARE_LOCN_TYPE,	AM_GET_DESC.AM_CARE_LOCN_TYPE(a.assign_care_LOCN_TYPE,'"+locale+"','2') ASSIGN_CARE_LOCN_TYPE_DESC,A.ASSIGN_CARE_LOCN_CODE,DECODE (A.ASSIGN_CARE_LOCN_TYPE, 'N', IP_GET_DESC.IP_NURSING_UNIT(A.facility_id,A.ASSIGN_CARE_LOCN_CODE, '"+locale+"','2'),  OP_GET_DESC.OP_CLINIC(A.FACILITY_ID,A.ASSIGN_CARE_LOCN_CODE,'"+locale+"','1')) ASSIGN_CARE_LOCN_DESC, A.SERVICE_CODE,AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,'"+locale+"','2') SERVICE_SHORT_DESC,	A.SUBSERVICE_CODE,AM_GET_DESC.AM_SUBSERVICE(A.SERVICE_CODE, A.SUBSERVICE_CODE,'"+locale+"','2') SUBSERVICE_SHORT_DESC, A.ASSIGN_ROOM_NUM,A.ASSIGN_BED_NUM, A.ATTEND_PRACTITIONER_ID,		AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+locale+"','1') PRACTITIONER_NAME, A.APPT_ID,A.PATIENT_CLASS, AM_GET_DESC.AM_PATIENT_CLASS(A.PATIENT_CLASS,'"+locale+"','2') PATIENT_CLASS_DESC, A.DISPOSITION_TYPE,DECODE (A.PATIENT_CLASS,'IP', IP_GET_DESC.IP_DISCHARGE_TYPE(A.DISPOSITION_TYPE,'"+locale+"','2') ,			AM_GET_DESC.AM_DISPOSITION_TYPE(A.DISPOSITION_TYPE,'"+locale+"','2') ) DISPOSITION_TYPE_DESC,TO_CHAR (A.DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI') DISCHARGE_DATE_TIME,A.REFERRAL_ID, (SELECT COUNT (1) FROM MR_PAT_FILE_INDEX WHERE facility_id = a.facility_id AND patient_id = a.patient_id) FILE_COUNT,(SELECT COUNT (1) from PR_DIAGNOSIS WHERE onset_facility_id = a.facility_id AND 		onset_encounter_id = a.encounter_id) DIAG_COUNT  FROM PR_ENCOUNTER A WHERE A.FACILITY_ID = '"+facilityId+"' AND A.ENCOUNTER_ID = NVL ('"+encounterID+"', A.ENCOUNTER_ID) AND A.PATIENT_ID = '"+patientid+"' AND TRUNC (A.VISIT_ADM_DATE_TIME) BETWEEN NVL (TO_DATE ("+from+", 'DD/MM/YYYY'), TO_DATE ('01/01/1900','DD/MM/YYYY')) AND NVL (TO_DATE ("+to+", 'DD/MM/YYYY'), TO_DATE ('31/12/5000','DD/MM/YYYY')) AND A.PATIENT_CLASS = DECODE ('"+encounType+"', '', A.PATIENT_CLASS, '"+encounType+"') ORDER BY "+order_by+" , ENCOUNTER_DATE DESC";*/ 
		
		/*Below Query Modified for this SCF ML-MMOH-SCF-0360. The pr_diagnosis_enc_dtl table was replaced instead of PR_DIAGNOSIS*/
			
		sql = "SELECT A.ENCOUNTER_ID, A.PATIENT_ID, A.EPISODE_ID,TO_CHAR (A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE_TIME,A.VISIT_ADM_DATE_TIME ENCOUNTER_DATE, A.ASSIGN_CARE_LOCN_TYPE,	AM_GET_DESC.AM_CARE_LOCN_TYPE(a.assign_care_LOCN_TYPE,'"+locale+"','2') ASSIGN_CARE_LOCN_TYPE_DESC,A.ASSIGN_CARE_LOCN_CODE,DECODE (A.ASSIGN_CARE_LOCN_TYPE, 'N', IP_GET_DESC.IP_NURSING_UNIT(A.facility_id,A.ASSIGN_CARE_LOCN_CODE, '"+locale+"','2'),  OP_GET_DESC.OP_CLINIC(A.FACILITY_ID,A.ASSIGN_CARE_LOCN_CODE,'"+locale+"','1')) ASSIGN_CARE_LOCN_DESC, A.SERVICE_CODE,AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,'"+locale+"','2') SERVICE_SHORT_DESC,	A.SUBSERVICE_CODE,AM_GET_DESC.AM_SUBSERVICE(A.SERVICE_CODE, A.SUBSERVICE_CODE,'"+locale+"','2') SUBSERVICE_SHORT_DESC, A.ASSIGN_ROOM_NUM,A.ASSIGN_BED_NUM, A.ATTEND_PRACTITIONER_ID,		AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+locale+"','1') PRACTITIONER_NAME, A.APPT_ID,A.PATIENT_CLASS, AM_GET_DESC.AM_PATIENT_CLASS(A.PATIENT_CLASS,'"+locale+"','2') PATIENT_CLASS_DESC, A.DISPOSITION_TYPE,DECODE (A.PATIENT_CLASS,'IP', IP_GET_DESC.IP_DISCHARGE_TYPE(A.DISPOSITION_TYPE,'"+locale+"','2') ,'DC', IP_GET_DESC.IP_DISCHARGE_TYPE(A.DISPOSITION_TYPE,'"+locale+"','2') ,			AM_GET_DESC.AM_DISPOSITION_TYPE(A.DISPOSITION_TYPE,'"+locale+"','2') ) DISPOSITION_TYPE_DESC,TO_CHAR (A.DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI') DISCHARGE_DATE_TIME,A.REFERRAL_ID,	a.Facility_Id,SM_GET_DESC.SM_FACILITY_PARAM(a.FACILITY_ID,'"+locale+"','1') Facility_Name, (SELECT COUNT (1) FROM MR_PAT_FILE_INDEX WHERE facility_id = a.facility_id AND patient_id = a.patient_id) FILE_COUNT,(SELECT COUNT (1) from pr_diagnosis_enc_dtl b WHERE b.facility_id = a.facility_id AND 		b.encounter_id = a.encounter_id) DIAG_COUNT  FROM PR_ENCOUNTER A WHERE  A.ENCOUNTER_ID = NVL ('"+encounterID+"', A.ENCOUNTER_ID) AND A.PATIENT_ID = '"+patientid+"' AND TRUNC (A.VISIT_ADM_DATE_TIME) BETWEEN NVL (TO_DATE ("+from+", 'DD/MM/YYYY'), TO_DATE ('01/01/1900','DD/MM/YYYY')) AND NVL (TO_DATE ("+to+", 'DD/MM/YYYY'), TO_DATE ('31/12/5000','DD/MM/YYYY')) AND A.PATIENT_CLASS = DECODE ('"+encounType+"', '', A.PATIENT_CLASS, '"+encounType+"') AND A.PATIENT_CLASS = DECODE ('"+encounType+"', '', A.PATIENT_CLASS, '"+encounType+"') "+VarWhereFacility+" ORDER BY Facility_Name ,  "+order_by+" , ENCOUNTER_DATE DESC";//modified for Bru-HIMS-CRF-380( Added Facilty name)
		newstmt= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		//Statement astmt= con.createStatement(sql);
		
		
		
		rset = newstmt.executeQuery(sql) ;
		while(rset.next())
		noOfRecords = noOfRecords + 1;

		rset.beforeFirst(); 

		if(noOfRecords == 0)
		{	  
			// modify by Lakshmanan for ML-MMOH-CRF-1955 on 10-07-2023 start
			if(!fid.equals("MLC")) {
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'))</script>");
			} 
			// modify by Lakshmanan for ML-MMOH-CRF-1955 on 10-07-2023 end
			if(fid.equals("DR"))
			{
				out.println("<script>parent.window.close();</script>");
			}
			else
			{ 	
				// modify by Lakshmanan for ML-MMOH-CRF-1955	on 10-7-2023 start
				if (fid.equals("MLC")) {
					out.println("<script>parent.frames[3].document.location.href ='../../eCommon/html/blank.html';</script>");
				}else {
				out.println("<script> parent.frames[2].document.location.href ='../../eCommon/html/blank.html';</script>");
				} 
				// modify by Lakshmanan for ML-MMOH-CRF-1955	on 10-7-2023 end
			}
		}
		else
		{	
						  
			if(!fid.equals("DR"))
			{
			
			%>
		<script>	
		
	//alert("<%=fid%>");	
	parent.frames[2].document.location.href='../../eCommon/jsp/pline.jsp?Patient_ID='+parent.frames[1].document.forms[0].PatientId.value;
				
			</script> 
			<%}%>
<%

%>
		

	<table border="0" width="100%" cellspacing='0' cellpadding='0'>

		<tr>

		
	<%
		if(!(fromRecordNumber <= 1))
		{ %>
	<td align='right' id='prev' width="100%"><A HREF="#" onClick='submitPrevNext("<%=(fromRecordNumber-10)%>","<%=(toRecordNumber-10)%>","DR");' text-decoration='none'><fmt:message key="Common.previous.label"  bundle="${common_labels}"/></A></td>
          	
	<%	
}
if ( !( (fromRecordNumber+10) > noOfRecords ) ){
		%>
	<td align='right' id='next' width="100%"><A HREF="#" onClick='submitPrevNext("<%=(fromRecordNumber+10)%>","<%=(toRecordNumber+10)%>","DR");' text-decoration='none'><fmt:message key="Common.next.label"  bundle="${common_labels}"/></A></td>
	<%	}
	%>
		
		</tr>
	</table>
	
	<table border="1" cellpadding="0" cellspacing="0" align='center' width="100%">
<%	if(rset.next())
	{	%>
		<%rset.beforeFirst();
	}	%>
	<tr>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/> </th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="eMR.EpisodeNo.label" bundle="${mr_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.service.label" bundle="${common_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.Disposition.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.datetime.label" bundle="${common_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.DispType.label" bundle="${common_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="eMR.FromReferralDtls.label" bundle="${mr_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="eMR.ToReferralDtls.label" bundle="${mr_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="eMR.ApptDetails.label" bundle="${mr_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="eMR.DiagDetails.label" bundle="${mr_labels}"/></th>
		<th rowspan="2" height="15" width='10%' nowrap><fmt:message key="Common.FileDetails.label" bundle="${common_labels}"/></th>
		</tr>		

		<%
		int i = 1;
		String facility_name 	= "" ; //added forBru-HIMS-CRF-380
		String res_facility_id 	= "" ; //added forBru-HIMS-CRF-380
		while(rset.next()) 
		{
				
				counter++ ;
				if ( counter % 2 == 0 )
					classValue = "QRYODD";
				else
					classValue = "QRYEVEN";
				%>
				<%if(counter >=fromRecordNumber && counter <= toRecordNumber){%>
			<tr></tr>
			<!-- added for Bru-HIMS-CRF-380 Start -->
			<%
			if(!facility_name.equals(rset.getString("Facility_Name"))){%>
				<tr><td colspan="18" class="CAGROUPHEADING"><%=rset.getString("Facility_Name")%></td></tr>
			<%}
			facility_name	= rset.getString("Facility_Name");
			res_facility_id	= rset.getString("FACILITY_ID");
			 %>
			 <!-- added for Bru-HIMS-CRF-380 End -->
			
			<tr>
				<td  height="20"  class='<%=classValue%>'><font size=1>
				<% 
					vis_dat_display = rset.getString("VISIT_ADM_DATE_TIME");
					if(vis_dat_display==null)
						vis_dat_display = "&nbsp;";
					else
						vis_dat_display = DateUtils.convertDate(vis_dat_display,"DMYHM","en",locale);
					out.println(vis_dat_display);
				%>
				</td>

				<td  height="20" class='<%=classValue%>' ><font size=1> <%=(rset.getString("PATIENT_CLASS_DESC")==null)?"&nbsp;":rset.getString("PATIENT_CLASS_DESC")%></td>

				<% encounter_id = rset.getString("ENCOUNTER_ID")==null?"":rset.getString("ENCOUNTER_ID");%>		
				<td  height="20" class="<%=classValue%>"><font size=1><a href="#" onClick="showEncounter('<%=encounter_id%>','<%=patientid%>','<%=(rset.getString("PATIENT_CLASS")==null)?"":rset.getString("PATIENT_CLASS")%>','<%=res_facility_id%>')"><%=encounter_id%></a>
				
				</td>
				<td  height="20" class="<%=classValue%>"><font size=1>
				<%=(rset.getString("EPISODE_ID")==null)?"&nbsp;":rset.getString("EPISODE_ID")%>		
				</td>

				<td  height="20" class="<%=classValue%>" nowrap ><font size=1>
				<%=(rset.getString("ASSIGN_CARE_LOCN_TYPE_DESC")==null)?"&nbsp;":rset.getString("ASSIGN_CARE_LOCN_TYPE_DESC")%>
				</td>

				<td  height="20" class="<%=classValue%>" nowrap><font size=1>
				<%=(rset.getString("ASSIGN_CARE_LOCN_DESC")==null)?"&nbsp;":rset.getString("ASSIGN_CARE_LOCN_DESC")%>
				</td>

				<td  height="20" class="<%=classValue%>" nowrap><font size=1>
				<%=(rset.getString("SERVICE_SHORT_DESC")==null)?"&nbsp;":rset.getString("SERVICE_SHORT_DESC")%>		
				</td>
				<td  height="20" class="<%=classValue%>" nowrap ><font size=1>
				<%=(rset.getString("SUBSERVICE_SHORT_DESC")==null)?"&nbsp;":rset.getString("SUBSERVICE_SHORT_DESC")%>		
				</td>


				<td  height="20" class="<%=classValue%>" nowrap><font size=1>
				<%=(rset.getString("ASSIGN_ROOM_NUM")==null)?"&nbsp;":rset.getString("ASSIGN_ROOM_NUM")%>
				</td>

				<td  height="20" class="<%=classValue%>" nowrap><font size=1>
				<%=(rset.getString("ASSIGN_BED_NUM")==null)?"&nbsp;":rset.getString("ASSIGN_BED_NUM")%>
				</td>

				<td  height="20" class="<%=classValue%>" nowrap><font size=1>
				<%=(rset.getString("PRACTITIONER_NAME")==null)?"&nbsp;":rset.getString("PRACTITIONER_NAME")%>
				</td>
				<td  height="20" class="<%=classValue%>" nowrap><font size=1>
				<% 
					dis_dat_display = rset.getString("DISCHARGE_DATE_TIME");
					if(dis_dat_display==null)
						dis_dat_display = "&nbsp;";
					else
						dis_dat_display = DateUtils.convertDate(dis_dat_display,"DMYHM","en",locale);
					out.println(dis_dat_display);
				%>
				</td>
				<td  height="20" class="<%=classValue%>" nowrap><font size=1>
				<%=(rset.getString("DISPOSITION_TYPE_DESC")==null)?"&nbsp;":rset.getString("DISPOSITION_TYPE_DESC")%>
				</td> 
				<td  height="20" class="<%=classValue%>" nowrap 
			<%
				
				String refferal_id_no	= "";
				refferal_id_no = rset.getString("REFERRAL_ID");
				if(refferal_id_no == null) refferal_id_no="";

				if(refferal_id_no==null || refferal_id_no.equals(""))
				{
					out.println(">&nbsp; </td>");
				}
				else
				{	//1
					%>
					style='width:102;cursor:pointer;color:blue' onClick='javascript:viewReferral("<%=refferal_id_no%>","<%=res_facility_id%>")'>			<font class='HYPERLINK'><%=refferal_id_no%></font></td>
				   <%	}	%>	
				
<%
try
{
	int count = 0;
	PreparedStatement pstmt	= null;
	ResultSet rs	= null;	
	//pstmt=con.prepareStatement(" SELECT count(*) as total FROM PR_REFERRAL_REGISTER where added_facility_id = '"+facility+"' AND from_encounter_id = '"+encounter_id+"' AND status !='N' "); //  17787 (Wednesday, December 30, 2009 Venkat S)
	pstmt=con.prepareStatement(" SELECT count(*) as total FROM PR_REFERRAL_REGISTER where added_facility_id = '"+res_facility_id+"' AND from_encounter_id = '"+encounter_id+"' AND status !='N' "); //added for Bru-HIMS-CRF-380
	
	rs   = pstmt.executeQuery();
	if(rs!=null)
	{
		if(rs.next())
		{
			count = rs.getInt("total");
		}
	}

	if(count > 0)
	{	//2
		%>
		<td  height="20" align='center' class="<%=classValue%>"  style='width:102;cursor:pointer;color:blue' onClick='viewToRefDtls("<%=encounter_id%>","<%=patientid%>","<%=res_facility_id%>")' ><fmt:message key="Common.ViewDetails.label" bundle="${common_labels}"/></td>

	<%	}
	else
	{	%>
		<td  height="20" class="<%=classValue%>">&nbsp;</td>
<%	}


	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
}catch(Exception exp)
{

}
%>
				<td height="20" class="<%=classValue%>" 
			<%	String appt_id_no	= "";
				appt_id_no = rset.getString("APPT_ID");
				if(appt_id_no == null) appt_id_no="";

					if(appt_id_no==null || appt_id_no.equals(""))
					{
						out.println(">&nbsp;</td>");
					}
					else
					{	//3
						%>
						style='width:102;cursor:pointer;color:blue' onClick='view_appt_dtl("<%=appt_id_no%>","<%=res_facility_id%>")'><font class='HYPERLINK'><%=appt_id_no%></a></td>
					 
				<%	}	%>	
				</td>

		<% 	
		
		if(rset.getInt("diag_count") > 0)
			{	
			%>
				<td  height="20" class="<%=classValue%>" style='width:102;cursor:pointer;color:blue' onClick=viewDiagnosis('<%=encounter_id%>','<%=patientid%>','<%=res_facility_id%>')><fmt:message key="eMR.DiagDetails.label" bundle="${mr_labels}"/></td>
		<%	}
			else
			{	%>
				<td height="20" class="<%=classValue%>"><font size=1>&nbsp;</td>
		<%	}	%>

		<%	if(rset.getInt("file_count") > 0)
			{	%>
				<td height="20" class="<%=classValue%>" style='width:102;cursor:pointer;color:blue' onClick=viewFile('<%=patientid%>','<%=res_facility_id%>')><fmt:message key="Common.FileDetails.label" bundle="${common_labels}"/></td>
		<%	}
			else
			{	%>
				<td height="20" class="<%=classValue%>"><font size=1>&nbsp;</td>
		<%	}	%>
		
				</tr>
		   <%}%>
	  <%	i++;
		}
	}
	%>
	</table>
				<!--10/9/2008-->
			
				<!--10/9/2008-->

 <%}catch(Exception e){%>
		 <% out.println("Exception while fetching connection :" + e) ;%>
 <%}finally{%>
	 <%
	if(rset!=null)
	rset.close();
	if(newstmt!=null)
	newstmt.close();
	ConnectionManager.returnConnection(con, request);%>
 <%}%>
<script>
//parent.frames[1].document.forms[0].search[1].disabled=false;

</script>
  <input type='hidden' name='previousRecord' id='previousRecord' value='<%=fromRecordNumber%>' >
  <input type='hidden' name='nextRecord' id='nextRecord' value='<%=toRecordNumber%>' >
  <input type='hidden' name='flag' id='flag' value='<%=flag%>' > 
  <input type='hidden' name='noOfRecords' id='noOfRecords' value='<%=noOfRecords%>' >
  <input type='hidden' name='facility' id='facility' value='<%=facility%>' >
  <input type='hidden' name='from' id='from' value=<%=from%> >
  <input type='hidden' name='to' id='to' value=<%=to%> >
  <input type='hidden' name='patientid' id='patientid' value=<%=patientid%> >
  <input type='hidden' name='order_by' id='order_by' value='<%=order_by%>'>
  <input type='hidden' name='encounterID' id='encounterID' value='<%=encounterID%>'>
  <input type='hidden' name='encounType' id='encounType' value='<%=encounType%>'>  
  <input type='hidden' name='p_all_facility_id' id='p_all_facility_id' value='<%=p_all_facility_id%>'>
 <input type='hidden' name='fid' id='fid' value='<%=fid%>'>
 </form>
 </body>
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

