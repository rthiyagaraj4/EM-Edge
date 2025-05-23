var from_date;
var to_date;
function query()
 {
	  f_patientHistoryCriteria.location.href ="../../eAE/jsp/AEQueryPatientHistory.jsp" ;
	  
 }
function reset() 
  {
	  clear();
	  f_patientHistoryCriteria.document.forms[0].reset();
	  f_patientHistoryCriteria.document.forms[0].search.disabled = false; 
  } 

 
function clear()
{
	//f_patientHistoryCriteria.document.forms(0).reset();
	f_patientHistoryResult.location.href="../../eCommon/html/blank.html" ;
	messageFrame.location.href="../../eCommon/jsp/error.jsp" ;  
	//commontoolbarFrame.document.forms(0).reset.disabled=true;
	commontoolbarFrame.location.reload();
	 f_patientHistoryCriteria.document.forms[0].search.disabled = false; 
}


async function callPatientSearch()
{
	var patient_id	=	f_patientHistoryCriteria.document.forms[0].patient_id;
	var retun_value =	"";
	return_value	=await PatientSearch();
	if(return_value!=null)
	{
		patient_id.value	=	return_value;
	}
	else
	{
		patient_id.value	=	"";
	}
}


  function callSearch(patient_id,mrn,encounter_id,ae_pat_history_datefrom,ae_pat_history_dateto,ae_pat_history_location,ae_pat_history_service,messageFrame)
	{
        if(f_patientHistoryCriteria.document.forms[0].FileNo.value=="Y")
		{
			if(trimCheck(patient_id.value)==false &&  trimCheck(mrn.value)==false &&  trimCheck(encounter_id.value)==false)
			{ 
			var msg=getMessage('AE_PAT_MRN_ENC_BLANK','AE');
			f_patientHistoryResult.location.href="../../eCommon/html/blank.html" ;
			patient_id.focus();
			messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num='+msg;
			return false;
			}
			else
			{
			messageFrame.location.href = '../../eCommon/jsp/error.jsp';
             patient_id.focus();
			}
		}
		else {
			
			if(trimCheck(patient_id.value)==false  &&  trimCheck(encounter_id.value)==false)
			{ 
				var msg=getMessage('AE_PAT_ENC_BLANK','AE');
				patient_id.focus();
			
				messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num='+msg;
				return false;
			}
			else
			{
				messageFrame.location.href = '../../eCommon/jsp/error.jsp';
				patient_id.focus();
			}
		}
		if (f_patientHistoryCriteria.document.forms[0].FileNo.value=="Y")
		{
			var fields = new Array (f_patientHistoryCriteria.document.forms[0].patient_id,
		    f_patientHistoryCriteria.document.forms[0].mrn,
		    f_patientHistoryCriteria.document.forms[0].encounter_id);

		   var names = new Array (getLabel("Common.patientId.label","Common"),getLabel("eOP.MRN.label","OP"),getLabel("Common.encounterid.label","Common"));	
		}
		else{
			var fields = new Array (f_patientHistoryCriteria.document.forms[0].patient_id,
		    f_patientHistoryCriteria.document.forms[0].encounter_id);
			var names = new Array (getLabel("Common.patientId.label","Common"),getLabel("Common.encounterid.label","Common"));	
			
		}

		var error_jsp="../../eCommon/jsp/error.jsp";
	    if (ae_pat_history_datefrom.value!='' && ae_pat_history_dateto.value!='')
		{
			if(isBefore(ae_pat_history_datefrom.value,ae_pat_history_dateto.value,"DMY",localeName))
			{
			var sql_query=constructQuery(patient_id,mrn,encounter_id,ae_pat_history_datefrom,ae_pat_history_dateto,ae_pat_history_location,ae_pat_history_service);
				if(SpecialCharCheck(fields,names,messageFrame,"M",error_jsp))
				{
					 //f_patientHistoryCriteria.document.forms(0).search.disabled = true; 

						f_patientHistoryResult.location.href='../../eAE/jsp/AECallResultPatientHistory.jsp?patient_id='+escape(patient_id.value)+'&sql_query='+sql_query+'&mrn='+escape(mrn.value)+'&encounter_id='+escape(encounter_id.value);
				}
				
			}
			else
			{	
					error=getMessage('TO_DT_GR_EQ_FM_DT','SM')
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
					return false;
			}
		}
		else
		{
			var sql_query=constructQuery(patient_id,mrn,encounter_id,ae_pat_history_datefrom,ae_pat_history_dateto,ae_pat_history_location,ae_pat_history_service);
			if(SpecialCharCheck(fields,names,messageFrame,"M",error_jsp))
			{
				// f_patientHistoryCriteria.document.forms(0).search.disabled = true; 

					f_patientHistoryResult.location.href='../../eAE/jsp/AECallResultPatientHistory.jsp?patient_id='+escape(patient_id.value)+'&sql_query='+sql_query+'&mrn='+escape(mrn.value)+'&encounter_id='+escape(encounter_id.value);
			}
	   }
	}

	function constructQuery(patient_id,mrn,encounter_id,ae_pat_history_datefrom,ae_pat_history_dateto,ae_pat_history_location,ae_pat_history_service)
	{
		var sql_query=' ';
        var andCheck	=	0;            

		if(!(trimCheck(patient_id.value) == false)	)
		{
		sql_query	=' and patient_id ='+'\''+escape(patient_id.value)+'\'';
		andCheck	=	1;
		} 


		if(! (trimCheck(mrn.value) ==false)	)
		{
			if(andCheck == 1)
			sql_query	=sql_query + 'and patient_id in(select patient_id from mr_pat_file_index where file_no = ' +'\''+escape(mrn.value)+'\') ';
			
			else
		
			sql_query	='and patient_id in(select patient_id from mr_pat_file_index where file_no = ' +'\''+escape(mrn.value)+'\') ';
	
		}
		
		if(!(trimCheck(encounter_id.value) == false)	)
		{
			if(andCheck == 1)
			sql_query	=sql_query + ' and encounter_id = ' +'\''+escape(encounter_id.value)+'\' ';
			else
			sql_query	=' and encounter_id = ' +'\''+escape(encounter_id.value)+'\' ';
		}
		
		

		if( (trimCheck(ae_pat_history_datefrom.value) == true) && (trimCheck(ae_pat_history_dateto.value) == true ) )
		{
			
			sql_query	= sql_query + '	and trunc(queue_date) between trunc(to_date(\''+convertDate(ae_pat_history_datefrom.value,"DMY",localeName,"en")+'\',\'dd/mm/yyyy hh24:mi\')) and trunc(to_date(\''+convertDate(ae_pat_history_dateto.value,"DMY",localeName,"en")+'\',\'dd/mm/yyyy hh24:mi\')) ';
		}
		else if( (trimCheck(ae_pat_history_datefrom.value) == true) )
		{
		
			sql_query = sql_query + ' and to_char(queue_date,\'dd/mm/yyyy\') =\''+convertDate(ae_pat_history_datefrom.value,"DMY",localeName,"en") +'\'';
		}

		else if( (trimCheck(ae_pat_history_dateto.value) == true) )
		{
		
			sql_query = sql_query + ' and to_char(queue_date,\'dd/mm/yyyy\') =\''+convertDate(ae_pat_history_dateto.value,"DMY",localeName,"en") +'\'';
		}
		else {}


			



		
		if(!(trimCheck(ae_pat_history_service.value) ==false))
		{
			sql_query	=sql_query + ' and service_code = ' +'\''+ae_pat_history_service.value+'\' ';

		}
		if(! (trimCheck(ae_pat_history_location.value) == false))
		{
			sql_query	=sql_query + ' and locn_code = ' +'\''+ae_pat_history_location.value+'\' ';
       }
		return sql_query;   
		
	}

	
async function patvisit() {
	var retVal;
	var dialogHeight= "70vh";//"400px" ;   //38
	var dialogWidth	= "85vw";//"700px" ; //50
	var dialogTop = "80" ;
	var center = "1" ;
	var status="no";
	var p_mode = "TRIAGEQUERY";
	var patient_id =frames[1].document.forms[0].patient_id.value
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal =await top.window.showModalDialog("../../eAE/jsp/AEPaintSearchVisit.jsp?p_mode="+p_mode+"&patient_id="+patient_id,arguments,features);
	if(retVal != null){
		if(retVal == "close")
		retVal="|";
		returnarray=retVal.split("|");
		var j1=returnarray[1];
		var j2=returnarray[0];
		frames[1].document.forms[0].encounter_id.value=j2;
		//frames(0).document.AEQueryPatientHistoryForm.encounter_id.value=j2;
	}
}

// For MLC Details
async function callMlcDetails(patid,encid)
{

       var retVal;
	   var dialogHeight = "20vh" ;
	   var dialogWidth  = "35vw" ;
	   var dialogTop    = "230";
	   var dialogLeft   = "230";
	   var arguments	= document.forms[0].bt_mlc_details.value;
	   if(arguments==null) arguments='';
	   var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
	   retVal =await window.showModalDialog("../../eAE/jsp/AEPatHistoryMLCDetails.jsp?call_from=MLC&patid="+patid+"&encid="+encid,arguments,features);  
	   
}  

//For Incident Remarks
async function callIncRemarks(patid,encid)
{
       var retVal;
	   var dialogHeight = "20vh" ;
	   var dialogWidth  = "35vw" ;
	   var dialogTop    = "230";
	   var dialogLeft   = "230";
	   var arguments	= document.forms[0].bt_incd_remarks.value;
	   if(arguments==null) arguments='';
	   var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
	   retVal =await window.showModalDialog("../../eAE/jsp/AEPatHistoryINCRemarks.jsp?call_from=IR&patid="+patid+"&encid="+encid,arguments,features);  
	  
}

function AEScrollIntoView(tabidx)
{
	//eval("document.all.tab"+tabidx+".scrollIntoView()");
	document.getElementById('tab'+tabidx).scrollIntoView();
	 if(tabidx == 4)
		document.forms[0].bt_incd_remarks.focus();
			
}
 
function changeCase(obj)
   {
	  obj.value=obj.value.toUpperCase();
   }
function callfocus()
{
	document.forms[0].patient_id.focus();
}
function ChkNumber(encval)
{
var alphabet = false;
var encvalue	=	encval.value;
for(i=0; i<encvalue.length; i++)
{
if( !(encvalue.charCodeAt(i) >=48 && encvalue.charCodeAt(i) <=57))
	alphabet =true;
}
	if(alphabet)
	{
		alert(getMessage("AE_INVALID_ENCOUNTER_ID",'AE'));
		encval.focus();
		return true;

	}
	else
		return false;
}
function remVal1(obj)
{
	while(obj.options.length > 1)
	{
		obj.remove(1);
	}
}
function setService(obj)
{
		if(obj.value!='')
	     { 

			var service	= document.forms[0].ae_pat_history_service;
		    while(service.options.length > 1)
		    service.remove(1);
			var clinic_code = obj.value;
			var serviceflag1 = "Y";
			var HTMLVal = "<HTML><BODY><form name='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='clinic_code' value='"+clinic_code+"'><input type='hidden' name='serviceflag1' value='"+serviceflag1+"'></form></BODY></HTML>";
	     	parent.messageFrame.document.write(HTMLVal);
			parent.messageFrame.visit_form.submit();
		 }
}
async function CallServiceLookup()
{

	var facility_id="";//document.forms(0).facility_id.value;
	var msg="";

	//facility_id				="`"+'<%=facilityId%>'+"`";
    facility_id=document.forms[0].facilityId.value;
		
	var target				= document.forms[0].ae_pat_history_service_desc;
	var retVal				=    new String();
	var dialogTop			= "40";
	var dialogHeight		= "20vh" ;
	var dialogWidth			= "50vw" ;
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql="";
	var search_desc="";
	var tit="";
	sql=" select service_code, short_desc from am_service where service_code in (select 		service_code from op_clinic where facility_id ="+facility_id+"  and clinic_type  in (select locn_type from am_care_locn_type where care_locn_type_ind=`C`) and level_of_care_ind = `E` and eff_status = `E` ) ";

	search_code="service_code";
	search_desc="short_desc";
	tit=encodeURIComponent(getLabel("Common.ServiceCode.label","Common"))
	retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
		
	var arr=new Array();

	if (!(retVal == null))
	{

		var retVal=unescape(retVal);
		arr=retVal.split("::");

		document.forms[0].ae_pat_history_service_desc.value=arr[0];
		document.forms[0].ae_pat_history_service.value=arr[1];

		document.forms[0].ae_pat_history_service_desc.focus();
	}
	else
	{
		target.focus();
	}
}

async function CallLocationLookup()
{

	var facility_id="";//document.forms(0).facility_id.value;
	var msg="";

	//facility_id				="`"+'<%=facilityId%>'+"`";
	facility_id=document.forms[0].facilityId.value;
	var target				= document.forms[0].ae_pat_history_location_desc;
	var retVal				=    new String();
	var dialogTop			= "40";
	var dialogHeight		= "20vh" ;
	var dialogWidth			= "50vw" ;
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql="";
	var search_desc="";
	var tit="";
	sql=" select clinic_code, short_desc from op_clinic where facility_id = "+facility_id+" and clinic_type  in (select locn_type from am_care_locn_type where care_locn_type_ind=`C`)  and level_of_care_ind = `E` and eff_status = `E` ";

	search_code="clinic_code";
	search_desc="short_desc";
	tit=encodeURIComponent(getLabel("Common.locationcode.label","Common"));
	retVal= await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
		
	var arr=new Array();

	if (!(retVal == null))
	{

		var retVal=unescape(retVal);
		arr=retVal.split("::");

		document.forms[0].ae_pat_history_location_desc.value=arr[0];
		document.forms[0].ae_pat_history_location.value=arr[1];

		document.forms[0].ae_pat_history_location_desc.focus();
	}
	else
	{
		target.focus();
	}
}
async function viewpatdet(pat_id,encounter_id)
	{
		
		var url	= "../../eAE/jsp/ViewPatHistoryDetailsMain.jsp?Patient_ID="+pat_id+							"&EncounterId="+encounter_id;
		var dialogTop		= "70";
		var dialogHeight	= "75vh";
		var dialogWidth		= "85vw";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no;";
		var returnval =await top.window.showModalDialog( url, arguments, features ) ;
	}


async function CallViewPatSecondaryDetails(patient_id,encounter_id,visit_adm_date_time)  
	{
            var retVal = "";
			var function_id ="query";
			var dialogHeight= "75vh" ;
			var dialogWidth	= "85vw" ;
			var dialogTop ="92";
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
			var action_url		=	"../../eAE/jsp/AESecondaryTriageHistoryMain.jsp?patient_id="+patient_id+"&episode_id="+encounter_id+"&visit_adm_date_time="+visit_adm_date_time+"&function_id="+function_id;
			retVal =await  top.window.showModalDialog(action_url,arguments,features);
			
    }

function checkDate(obj){	
		if(obj.value!="") {
			 if((!isBeforeNow(obj.value,'DMY',localeName))) 	{
				alert(getMessage("START_DATE_GREATER_SYSDATE","common"))
				obj.select();
				return false;
			 }
		}
}