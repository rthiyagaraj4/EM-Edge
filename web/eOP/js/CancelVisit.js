
function apply() 
{
    var fields  =  new Array();
    var names   = new Array(); 
	if(f_query_add_mod.document.forms[0] != null && f_query_add_mod.document.forms[0].name == 'CancelVisitFrame2') {		
		f_query_add_mod.document.CancelVisitFrame2.cancel_case_yn.value = 'Y';
		if (f_query_add_mod.document.CancelVisitFrame2.cancel_case_yn.checked == true) {		
		   if(f_query_add_mod.document.CancelVisitFrame2.cancel_reason_code.value == '') {
			fields[0] =  (f_query_add_mod.document.CancelVisitFrame2.cancel_reason_code);
			names[0] =  (getLabel("Common.reason.label",'Common'));
		   }
		   /*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
			if(f_query_add_mod.document.CancelVisitFrame2.remarks_img.style.visibility == 'visible')
			{
				fields[0] = f_query_add_mod.document.CancelVisitFrame2.other_remarks;
				names[0] = getLabel("Common.remarks.label","Common");
			}
			/*End ML-MMOH-CRF-1114*/
		} else {
			f_query_add_mod.document.CancelVisitFrame2.cancel_case_yn.value = '';
			fields[0] = ( f_query_add_mod.document.CancelVisitFrame2.cancel_case_yn);
			names[0] =  (getLabel("Common.cancel.label",'Common')); 
		}
		if(f_query_add_mod.checkFields( fields, names, messageFrame)) {
			var fn_status = f_query_add_mod.document.CancelVisitFrame2.funct_name.value ;
			if(fn_status == "modify" ) {
				var qms_interfaced_yn = f_query_add_mod.document.CancelVisitFrame2.qms_interfaced_yn.value;				
				if(qms_interfaced_yn == 'Y'){
					
					var	queue_num =f_query_add_mod.document.CancelVisitFrame2.queue_num.value;
					var	encounter_id =f_query_add_mod.document.CancelVisitFrame2.encounter_id.value;
					var	patient_id =f_query_add_mod.document.CancelVisitFrame2.patient_id.value;
					
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					 
					var param="&callfunc=CancelVisit&queue_num="+queue_num+"&patient_id="+patient_id+"&encounter_id="+encounter_id;
					var temp_jsp="../../eOP/jsp/QMSInterface.jsp?"+param;
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",temp_jsp,false);
					xmlHttp.send(xmlDoc);
					responseText=trimString(xmlHttp.responseText);					
				}
				f_query_add_mod.document.forms[0].submit();
			}
		}
	 } else {
			frames[1].parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
		}
}


function onSuccess()
{
	
	
	if (f_query_add_mod.document.forms[0].module_id!=null)
	{
		if (f_query_add_mod.document.forms[0].module_id.value=='AE')

		{   function_name=f_query_add_mod.document.forms[0].function_name.value
			
			top.content.document.location.href = "../eAE/jsp/AECancelVisit.jsp?menu_id=AE&module_id=AE&function_id=CANCEL_VISIT&function_name="+encodeURIComponent(function_name)+"&function_type=F&access=NYNNN";
		
		}
	  else
		{
		 query_string ="menu_id=OP&module_id=OP&function_id=CANCEL_VISIT&function_name="+ getLabel('Common.cancel.label','Common')+""+getLabel("Common.Visit.label","Common")+"&function_type=F&access=NYNNN";
     
	   top.content.document.location.href = "../eOP/jsp/CancelVisit.jsp?../eCommon/jsp/commonToolbar.jsp?"+query_string;

		}
     }
}

function reset()
{
    document.location.reload();
	// f_query_add_mod.document.frames[1].document.forms[0].reset();
	// f_query_add_mod.document.frames[1].document.CancelVisitFrame2.cancel_reason_code.disabled
	// = false;
}


function query(){
		var query_string = f_query_add_mod.document.frames[1].document.CancelVisitFrame2.query_string.value;
	   query_string ="menu_id=OP&module_id=OP&function_id=CANCEL_VISIT&function_name="+ getLabel('Common.cancel.label','Common')+""+getLabel("Common.Visit.label","Common")+"&function_type=F&access=NYNNN";
         parent.frames[1].document.location.href = "../../eOP/jsp/CancelVisit.jsp?"+query_string;

		// parent.frames[1].document.location.href = "../../eOP/jsp/CancelVisit.jsp?"+query_string;
}

function cancel_click(obj)
{

    if (obj.value == "Y")
        obj.value="";
    else
        obj.value="Y";

}

