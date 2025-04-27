function sortData(encounterID,encounType,patientid,sortby,ecount)
{  var ecnt;
    

	  if(eval(ecount)==0 )
	  {
	    sortby=sortby +"  desc";
	    ecnt=1;
	  }else
	 {  ecnt=0;
		sortby=sortby ;
	 }
	

	
from=document.forms[0].from.value;
to=document.forms[0].to.value
parent.resultFrame.location.href = '../../eMP/jsp/vwEncounterDetailResult.jsp?encounterID='+encounterID+'&encounType='+encounType+'&patientid='+patientid+'&from='+from+'&to='+to+"&sortby="+sortby+"&ecount="+ecnt;

}


async function callbilling(visitid,episodetype,patid,facility,episodeid)
{
	var dialogHeight= "90vh" ;
	var dialogWidth = "65vw" ;
	var dialogTop 	= "";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	///retVal = 	window.showModalDialog("../../eBL/jsp/BLFinDetailsQuery.jsp?visit_id="+visitid+"&episode_type="+episodetype+"&patient_id="+patid+"&facility_id="+facility+"&episode_id="+episodeid,arguments,features);
	retVal = 	await top.window.showModalDialog("../../eBL/jsp/BLFinDtlQryMain.jsp?visitid="+visitid+"&episodetype="+episodetype+"&patientid="+patid+"&facility_id="+facility+"&episodeid="+episodeid,arguments,features);
   
}


function close_me()
{
	parent.window.close();
	/*const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); */
}

async function funViewEncounterDet(strPatientId,strEpisodeType,strEpisodeId,strVisitId,strEncounterId)
 {
 var episode_type =strEpisodeType;
 var patient_id = strPatientId; 
 var visit_id = strVisitId; 
 var episode_id = strEpisodeId; 
 var encounterid = strEncounterId;

  var center='1';
  var dialogTop = "";
  var dialogHeight = "70vh" ;
  var dialogWidth = "90vw" ;
  var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; center:" + center + "; dialogWidth:" + dialogWidth +";status=no" ;
  var title="";
  title=encodeURIComponent(title); 
  var arguments = "" ;
  var column_sizes = escape("");               
  var column_descriptions =""; 
  var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"visit_id="+visit_id+"&patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&encounter_id="+encounterid;
  retVal=await top.window.showModalDialog("../../eBL/jsp/BLViewEncounterBillDetMain.jsp?"+param,arguments,features);
 }

function view_discharge(encounter_id,patient_id,patientclass)
{
var fid=document.forms[0].facility.value;
	
		var eid=encounter_id;
		var patid=patient_id;
		var patclass=patientclass;
		var call_function = "VIEW_ENCOUNTER_DTLS";
		//parent.document.getElementById("previous_enc_window").rows="10%,42%,42%,6%";
		parent.document.getElementById("resultFrame").style.height="32vh";//35vh
		parent.document.getElementById("dis_cummary").style.height="41vh";//52vh
		

		//var url='../../eCA/jsp/RelatedPatientHistNote.jsp?facilityid='+fid+"&called_function_id=INVIDE_WAITLIST&no_modal=N&appl_task_id=DISCHARGE_SUMMARY&calling_mode=NORMAL&group=1&cur_epi=Y&encounter_id="+eid+"&patient_id="+patid;

		var url="../../eMR/jsp/CurrentEncounterMain.jsp?encounterId="+eid+"&call_function="+call_function+"&patientId="+patid+"&Patient_Class="+patclass;
		parent.frames[2].document.location.href=url;

		parent.frames[3].document.location.href='../../eMP/jsp/vwEncounterDetailButton.jsp'; 

}
