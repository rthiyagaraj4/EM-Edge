/*
This file was developed by Venkatesh.S on 27-Nov-2012 against Bru-HIMS-CRF-287 [IN033669]
*/

function setValue(obj)
{	 
       
	   ChangeUpperCase(obj)
	   
	   if( obj.value==document.forms[0].pat_id.value){ }
	
      if( obj.value!=document.forms[0].pat_id.value){ parent.frames[1].location.href="../../eMP/jsp/RegOutReferralCriteria.jsp?patientid="+obj.value; parent.frames[2].location.href="../../eCommon/html/blank.html";}
	
	  if(obj.value != "" && document.forms[0].pat_status.value ==""){ 
	  parent.frames[1].location.href="../../eMP/jsp/RegOutReferralCriteria.jsp?patientid="+obj.value;} 
		
	  if(obj.value != "" && document.forms[0].pat_status.value =="invalid"){
	  parent.frames[1].location.href="../../eMP/jsp/RegOutReferralCriteria.jsp?patientid="+obj.value; }
	
	
		

}


async function getPatID()
{ 
    var patient="";
    patient=await PatientSearch();
   
   if(patient != null){
   document.forms[0].pat_id1.value=patient;
   setValue(document.forms[0].pat_id1)}
}

 function RegisterMoreReferral(encounter,pat_id,pat_class,dischargedate)
{	 

 if(pat_class=="OP" || pat_class=="EM" ){
 parent.frames[2].location.href="../../eMP/jsp/ReferralDetailsFrames.jsp?EncounterId="+encounter+"&Transaction_type=CO&patient_id="+pat_id+"&Module=OP&functions_id=REG_OUT_REF";}
 
 if(pat_class=="IP" || pat_class=="DC"){
 parent.frames[2].location.href="../../eMP/jsp/ReferralDetailsFrames.jsp?EncounterId="+encounter+"&Transaction_type=DA&patient_id="+pat_id+"&Module=IP&functions_id=REG_OUT_REF";}	
 
 
  if(pat_class=="IP"  && dischargedate!=""){
  parent.frames[2].location.href="../../eMP/jsp/ReferralDetailsFrames.jsp?EncounterId="+encounter+"&Transaction_type=DP&patient_id="+pat_id+"&Module=IP&functions_id=REG_OUT_REF";}
}

/*below lines added by venkatesh.S on 21/12/2012 against 36888*/
function reset()
{
parent.content.location.reload();
}
