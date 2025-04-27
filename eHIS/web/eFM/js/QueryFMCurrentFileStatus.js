		

function changeRowColor1(n)
{
	 var countt=document.getElementById("countt").value; 
		var i=parseInt(countt)	
				
		for( k=0;k<n;k++)
				document.getElementById("tb1").rows[prev].cells[k].style.backgroundColor="";

		for( k=0;k<n;k++)
				document.getElementById("tb1").rows[i].cells[k].style.backgroundColor="" ;
}

//Modified for this CRF HSA-CRF-0306

function searchResult(volume_no, file_no, patientid)
{
	

	
	var doc_or_file			= '';
	if(parent.searchFrame.document.forms[0].doc_or_file)
	{
	doc_or_file				= parent.searchFrame.document.forms[0].doc_or_file.value;
	}
	var criteria		    = file_no;
	var facility			= parent.searchFrame.document.forms[0].facility.value;
	var currStatDesc		= parent.searchFrame.document.forms[0].currStatDesc.value;
	var currIdDesc			= parent.searchFrame.document.forms[0].currIdDesc.value;
	var Curr_locn_desc		= parent.searchFrame.document.forms[0].Curr_locn_desc.value;
	var	validFile			= parent.searchFrame.document.forms[0].validFile.value;
	var appointmentDays		= parent.searchFrame.document.forms[0].appointmentDays.value;
	var bookingDays			= parent.searchFrame.document.forms[0].bookingDays.value;
	var file_type_appl_yn	= parent.searchFrame.document.forms[0].file_type_appl_yn.value;

	if(doc_or_file == 'D')
	{		parent.frames[3].document.location.href='../../eFM/jsp/QueryFMCurrentDocStatusResult.jsp?&criteria=' + criteria + '&facility=' + facility + '&patientid=' +  patientid +
	 '&facility='+facility+'&volume_no='+ volume_no+'&currStatDesc=' + currStatDesc +'&currIdDesc=' + currIdDesc+'&Curr_locn_desc=' + Curr_locn_desc +
	 '&appointmentDays=' + appointmentDays+'&bookingDays='+bookingDays;
	}
	else
	{	
		if(volume_no == '')
		{
		parent.frames[3].document.location.href='../../eCommon/html/blank.html';
		}
		else
		{
		parent.frames[3].document.location.href='../../eFM/jsp/QueryFMCurrentFileStatusResult.jsp?&criteria=' + criteria + '&facility=' + facility + '&patientid=' +  patientid +
	 '&facility='+facility+'&volume_no='+ volume_no+'&currStatDesc=' + currStatDesc +'&currIdDesc=' + currIdDesc+'&Curr_locn_desc=' + Curr_locn_desc +
	 '&appointmentDays=' + appointmentDays+'&bookingDays='+bookingDays;
		}
	}
	
}
function focusing()
{
	document.forms[0].patient_id.focus();		
}

function getNext(flagSelect)
	{
	   var patientid		= document.forms[0].patientid.value ;
	   var criteria			= document.forms[0].criteria.value ;
	   var facility			= document.forms[0].facility.value ;
	   var currStatDesc		= document.forms[0].currStatDesc.value ;
	   var currIdDesc		= document.forms[0].currIdDesc.value;
	   var Curr_locn_desc	= document.forms[0].Curr_locn_desc.value;
	   var appointmentDays	= document.forms[0].appointmentDays.value;
	   var bookingDays		= document.forms[0].bookingDays.value;
	document.location.href='../../eFM/jsp/QueryFMCurrentFileStatusResult.jsp?&criteria=' + criteria + '&facility=' + facility + '&patientid=' +  patientid + '&facility=' +  facility +'&currStatDesc=' + currStatDesc +'&currIdDesc=' + currIdDesc+'&Curr_locn_desc=' + Curr_locn_desc + '&appointmentDays=' + appointmentDays+"&bookingDays="+bookingDays;
	}

	async function ViewAppointment(patientid,appointmentDays,bookingDays)
	{
		var patid		= "";
	    patid=patientid;

		var retVal = 	new String();
		var dialogHeight= "49vh" ;
		var dialogWidth	= "50vw" ;
		var status = "no";
		var dialogTop = "265" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status+"; dialogTop :" + dialogTop ;
		var arguments	= "" ;
		
	//	retVal = window.showModalDialog("../../eOA/jsp/BookAppointmentOther.jsp?patient_id="+patid+"",arguments,features);
//calling_from parameter added by S.Sathish for IN020737 on Tuesday, June 08, 2010
retVal = await window.showModalDialog('../../eOA/jsp/BookAppointmentOther.jsp?patient_id='+patid+'&appointmentDays='+appointmentDays+'&bookingDays='+bookingDays+'&calling_from=FM',arguments,features);
   	}
/*Below line(s) modified by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
async function GetShowRemarks(name,remarksvalue,borrowing_reason,remarkstype)
{
 
	
    var comments;
	var remarks;

	var inputArr = document.getElementsByTagName("input"); 
	
	for (u=0;u<inputArr.length;u++)
	{
		if (inputArr[u].name == name)
		{
			comments = inputArr[u].value;
		}
	}

	var retVal;
	var ua = window.navigator.userAgent
    var msie = ua.indexOf ( "MSIE " )
	if ( msie > 0 )     
        brow_ver_no=parseInt (ua.substring (msie+5, ua.indexOf (".", msie )));
	  
	var dialogHeight	= "9.3" ;
	var dialogWidth		= "30" ;
	if(brow_ver_no > '6'){
			dialogHeight	= "7.4" ;
			dialogWidth		= "28.5" ;
	  }
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	var arguments;

	   if(comments=='' || comments == "null")
	      comments ='';
	 	arguments = comments ;

		 
		 
	retVal = await window.showModalDialog('../../eFM/jsp/GetShowRemarks.jsp?RemarksValue='+escape(remarks)+'&RemarksType='+remarkstype,arguments,features);

		for (u=0;u<inputArr.length;u++){
			if (inputArr[u].name == name){
				inputArr[u].value = ''+retVal+'';
			}
		}
}
/* end ML-MMOH-CRF-0393-IN057159  */
function getNext(flagSelect)
{
	   var patientid		= document.forms[0].patientid.value ;
	   var criteria			= document.forms[0].criteria.value ;
	   var facility			= document.forms[0].facility.value ;	
		document.location.href='../../eFM/jsp/QueryFMCurrentFileStatusResult.jsp?&criteria=' + criteria + '&facility=' + facility + '&patientid=' +  patientid + '&facility=' +  facility +'&currStatDesc=' + currStatDesc +'&currIdDesc=' + currIdDesc+'&Curr_locn_desc=' + Curr_locn_desc;                         
}

 function reset()
 {
	searchFrame.location.reload();
	volumeFrame.document.location.href="../../eCommon/html/blank.html"   ;
	searchResultFrame.document.location.href="../../eCommon/html/blank.html"   ;	
	messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="   ; 
 }

 function checkDocumentValue(obj)
{	
	if (obj.value != "")
	{
		var fields = new Array(obj);
		var names  = new Array(getLabel('eFM.DocumentFolder.label','FM'));
		var error_jsp ='../../eCommon/jsp/error.jsp';
		
			CheckDocumentExists(obj.value);
			clearResultFrame();			
		
	}
	else
	{
		parent.volumeFrame.location.href='../../eCommon/html/blank.html';
		parent.searchResultFrame.location.href='../../eCommon/html/blank.html';
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	}
}

async function docFolderSearch(facility_id)
{
	var target			= document.forms[0].doc_folder_desc;
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	sql = "SELECT doc_folder_id code, doc_folder_name description FROM fm_doc_folder WHERE upper(facility_id) like upper(?) and eff_status = 'E' AND upper(doc_folder_id) like upper(?) AND upper(doc_folder_name) like upper(?) "

	var title=getLabel('eFM.DocumentFolder.label','FM');
	dataNameArray[0]	= "facility_id" ;
	dataValueArray[0]	= facility_id;
	dataTypeArray[0]	= STRING ;
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2, 3";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	retVal = await CommonLookup( title, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1	=	unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].doc_folder_id.value	=	arr[0];
		document.forms[0].doc_folder_desc.value	=	arr[1];		
		checkDocumentValue(document.forms[0].doc_folder_id);	
	}
	else
	{
		document.forms[0].doc_folder_id.value	=	"";
		document.forms[0].doc_folder_desc.value	=	"";		
	} 
} // End of getUser().


function CheckDocumentExists(ObjVal)
{	
	if(ObjVal != "")
	{		
		var doc_folder_id = query_doc_criteria_form.doc_folder_id.value;
		var p_patient_id = query_doc_criteria_form.p_patient_id.value;
		var doc_type_id = query_doc_criteria_form.doc_type_id.value;		
		parent.volumeFrame.location.href="../../eFM/jsp/QueryCurrentDocTypeNo.jsp?doc_folder_id="+doc_folder_id+"&p_patient_id="+p_patient_id+"&doc_type_id="+doc_type_id;
	}
}
function clearResultFrame()
{
   parent.searchResultFrame.document.location.href="../../eCommon/html/blank.html" ;
}


function changeBackground()
{
	document.getElementById("th1").style.backgroundColor='#224771';
	document.getElementById("th2").style.backgroundColor='#224771';
}

async function callPatientSearch()
{
	var pat_id =  await PatientSearch('','','','','','','Y','','','OTHER');

	if(pat_id != null)
	{
		ManualEntry_form.patient_id.value = pat_id;
		ManualEntry_form.patient_id.focus();
	}
}

function checkPatientValue(obj)
{
	
	if (obj.value != "")
	{	
		
		var fields = new Array(obj);
		var names  = new Array(getLabel('Common.patientId.label','common'));
		var error_jsp ='../../eCommon/jsp/error.jsp';
		if (SpecialCharCheck(fields,names,parent.frames[4],'M',error_jsp))
		{
			ChangeUpperCase(obj);
			CheckPatientExists(obj.value);
			clearResultFrame();
			
		}
	}
	else
	{
		var errors = getMessage("CAN_NOT_BE_BLANK","common");
		errors=errors.replace('$',getLabel("Common.patientId.label","common"));
		alert(errors);
		parent.volumeFrame.location.href='../../eCommon/html/blank.html';
		parent.searchResultFrame.location.href='../../eCommon/html/blank.html';
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	}
}

function checkFileValue(obj)
{
	var fields = new Array(obj);
	var names  = new Array(getLabel("Common.fileno.label","common"));
	var error_jsp ='../../eCommon/jsp/error.jsp';
	if (SpecialCharCheck(fields,names,parent.frames[3],'M',error_jsp))
	{
		ChangeUpperCase(obj);
		CheckFileExists(obj.value);
		clearResultFrame();
	}
}

function CheckPatientExists(ObjVal)
{	
	if(ObjVal != "")
	{
		
		var facility = ManualEntry_form.facility.value;
		var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/QueryFMFileStatusCheckPatient.jsp?Patient="+ObjVal+"&Facility="+facility+" \"> </form></body></html>";
		parent.frames[4].document.write(HTMLVal);
		parent.frames[4].document.forms[0].submit();

	}
	
}

function CheckFileExists(ObjVal)
{
	if(ObjVal != "")
	{
		var facility = ManualEntry_form.facility.value;
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/QueryFMFileStatusCheckFile.jsp?FileNo="+ObjVal+"&Facility="+facility+" \"> </form></body></html>";
		parent.frames[3].document.write(HTMLVal);
		parent.frames[3].document.forms[0].submit();
	}
}

function changeBackgroundFM()
{
	document.getElementById("th1").style.backgroundColor='#224771';
	document.getElementById("th2").style.backgroundColor='#224771';
}

async function callPatDetails(Patient_ID) 
{
	var dialogHeight	= "28" ;
	var dialogWidth		= "50" ;
	var dialogTop		= "84" ;
	var dialogLeft		= "55" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + ";dialogLeft:" + dialogLeft;
	var arguments		= "" ;
	retVal				= await window.showModalDialog( "../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID="+escape(Patient_ID), arguments, features );
}

function showPatientLine()
{
	//var  Pat_line = ManualEntry_form.Pat_line.value ;
	//document.getElementById("PatientLine").innerHTML="";
	//document.getElementById("PatientDetail").innerHTML= Pat_line ;
}

async function showEncounter(enc,patid,fileno,Patient_Class)
{
	
	var call_function = "VIEW_ENCOUNTER_DTLS";
	var jsp_name="FMCurrentEncounterMain.jsp";
	var win_height = "30.8";
	var win_width= "50";
	var retVal = 	new String();
	var dialogHeight= win_height ;
	var dialogWidth	= win_width ;
	var dialogTop = "58" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eFM/jsp/"+jsp_name+"?encounterId="+enc+"&call_function="+call_function+"&patientId="+patid+"&fileNo="+fileno+"&Patient_Class="+Patient_Class,arguments,features);
}

async function ViewAuditTrail(patientId,fileNo,volumeNo){ 
               var retVal =	new String();
				var dialogHeight= "30" ;
				var dialogWidth	= "85" ;
				var status = "no";			
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; 	scroll=auto; status:" + status; 
                retVal =await window.showModalDialog("../../eFM/jsp/FMAuditTrialFrame.jsp?patientId="+patientId+"&fileNo="+fileNo+"&volumeNo="+volumeNo,arguments,features);

}
async function FileMovementHistory(patientId,fileNo,volumeNo)
	{	
	var retVal =	new String();
	var dialogHeight= "30" ;
	var dialogWidth	= "65" ;
	var status = "no";			
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; 	scroll=auto; status:" + status; 
	retVal =await window.showModalDialog("../../eFM/jsp/FMFileMovementHistoryFrame.jsp?patientId="+patientId+"&fileNo="+fileNo+"&volumeNo="+volumeNo,arguments,features);
	}

