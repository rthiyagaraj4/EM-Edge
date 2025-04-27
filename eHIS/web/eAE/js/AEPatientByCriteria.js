// Added/Modified By Nanda 10/23/2002 -->

function query()
 {
	
	  f_patientByCriteria.location.href ="../../eAE/jsp/AEPatByCriteriaQuery.jsp" ;

 }
function reset() 
  {
	  clear();
	  f_patientByCriteria.document.forms[0].reset();
  } 

 
function	clear()
{
	//f_patientByCriteria.document.forms[0].reset();
	f_patientByCriteria.document.forms[0].search.disabled= false;
	f_patientByCriteria_Result.location.href="../../eCommon/html/blank.html" ;
	messageFrame.location.href="../../eCommon/jsp/error.jsp" ;  
	//commontoolbarFrame.document.forms[0].reset.disabled=true;
}

async function callPatientSearch()
{
	var patient_id	=	f_patientByCriteria.document.forms[0].patient_id;
	var retun_value =	"";
	return_value	=await	PatientSearch();
	if(return_value!=null)
	{
		patient_id.value	=	return_value;
	}
	else
	{
		patient_id.value	=	"";
	}
}





function callSearch(patient_id,ctelno,date_from,date_to,pat_location,gender,RACE_CODE,citizen_nationality_code,p_fm_age,p_to_age,messageFrame)
	{
	var sql_query	='';
    var andCheck	=0;
	if(f_patientByCriteria.AEPatientByCriteriaForm.ae_patbycriteria_datefrom.value=='' )
	  {
		alert(getMessage("FROM_DATE_CANNOT_BE_BLANK",'SM'));
		f_patientByCriteria.AEPatientByCriteriaForm.ae_patbycriteria_datefrom.focus();
		return false;
	  }
	  if(f_patientByCriteria.AEPatientByCriteriaForm.ae_patbycriteria_dateto.value=='' )
	  {
		alert(getMessage("TO_DT_NOT_BLANK",'SM'));
		f_patientByCriteria.AEPatientByCriteriaForm.ae_patbycriteria_dateto.focus();
		return false;
	  }

	if(isBefore(date_from.value,date_to.value,"DMY",localeName))
	{
		if(!(trimCheck(patient_id.value) == false)	)
		{// change a.patId to b.patId
		sql_query	=' and b.patient_id = ' +'\''+patient_id.value+'\'';
		andCheck	=	1;
		}
	if( (trimCheck(date_from.value) == true) && (trimCheck(date_to.value) == true ) )
		{
			if(andCheck == 1)
			{
			sql_query	= sql_query + '	and trunc(a.queue_date) between trunc(to_date(\''+convertDate(date_from.value,"DMY",localeName,"en")+'\',\'dd/mm/yyyy hh24:mi\')) and trunc(to_date(\''+convertDate(date_to.value,"DMY",localeName,"en")+'\',\'dd/mm/yyyy hh24:mi\')) ';
			}
			else
            {
				sql_query	= '	and trunc(a.queue_date) between trunc(to_date(\''+convertDate(date_from.value,"DMY",localeName,"en")+'\',\'dd/mm/yyyy hh24:mi\')) and trunc(to_date(\''+convertDate(date_to.value,"DMY",localeName,"en")+'\',\'dd/mm/yyyy hh24:mi\')) ';
				andCheck	=	1;
			}
		}
		else if( (trimCheck(date_from.value) == true) )
		{
			if(andCheck == 1)
			{
			sql_query = sql_query + ' and to_char(a.queue_date,\'dd/mm/yyyy\') =\''+convertDate(date_from.value,"DMY",localeName,"en") +'\'';
			}
			else
			{
				sql_query = ' and to_char(a.queue_date,\'dd/mm/yyyy\') =\''+convertDate(date_from.value,"DMY",localeName,"en") +'\'';
				andCheck	=	1;
			}
		}

		else if( (trimCheck(date_to.value) == true) )
		{
			if(andCheck == 1)
			sql_query = sql_query + ' and to_char(a.queue_date,\'dd/mm/yyyy\') =\''+convertDate(date_to.value,"DMY",localeName,"en") +'\'';
			else
			{
			sql_query = ' and to_char(a.queue_date,\'dd/mm/yyyy\') =\''+convertDate(date_to.value,"DMY",localeName,"en") +'\'';
			andCheck	=	1;
			}
		}
		 if( (trimCheck(RACE_CODE.value) == true) )
		{
			if(andCheck == 1)
			sql_query	=sql_query +' and RACE_CODE = ' +'\''+RACE_CODE.value+'\'';
			else
			{
			sql_query	=' and RACE_CODE = ' +'\''+RACE_CODE.value+'\'';
			andCheck	=	1;
			}
		}
		 if( (trimCheck(citizen_nationality_code.value) == true) )
		{
			if(andCheck == 1)
			sql_query	=sql_query +' and NATIONALITY_CODE = ' +'\''+citizen_nationality_code.value+'\'';
			else
			{
			sql_query	=' and NATIONALITY_CODE = ' +'\''+citizen_nationality_code.value+'\'';
			andCheck	=	1;
			}
		}
		if((trimCheck(p_fm_age.value) == true) && (trimCheck(p_to_age.value) == true))
		{
		
			if(andCheck == 1)
			sql_query	=sql_query +" and calculate_age(to_char(b.date_of_birth,'dd/mm/yyyy'),1) BETWEEN "+p_fm_age.value+" AND "+p_to_age.value;
			else
			{
			sql_query	=" and calculate_age(to_char(b.date_of_birth,'dd/mm/yyyy'),1) BETWEEN "+p_fm_age.value+" AND "+p_to_age.value;
			andCheck	=	1;
			}
		}
		else if( (trimCheck(p_fm_age.value) == true) )
		{
			if(andCheck == 1)
			{
			sql_query = sql_query + " and calculate_age(to_char(b.date_of_birth,'dd/mm/yyyy'),1) >="+p_fm_age.value;
			}
			else
			{
			sql_query = " and calculate_age(to_char(b.date_of_birth,'dd/mm/yyyy'),1) >="+p_fm_age.value;
			andCheck	=	1;
			}
		}
		else if( (trimCheck(p_to_age.value) == true) )
		{
			if(andCheck == 1)
			{
			sql_query = sql_query + " and calculate_age(to_char(b.date_of_birth,'dd/mm/yyyy'),1) <="+p_to_age.value;
			}
			else
			{
			sql_query = " and calculate_age(to_char(b.date_of_birth,'dd/mm/yyyy'),1) <="+p_to_age.value;
			andCheck	=	1;
			}
		}

	if(! (trimCheck(pat_location.value) ==false)	)
	{
			if(andCheck == 1)
			sql_query	=sql_query + ' and locn_code = ' +'\''+pat_location.value+'\'';
			else
			{
			sql_query	='and locn_code = ' +'\''+pat_location.value+'\'';
			andCheck	=	1;
			}
	}
	
	if(! (trimCheck(gender.value) ==false)	)
	{
			if(andCheck == 1)
			sql_query	=sql_query + ' and sex = ' +'\''+gender.value+'\'';
			else
			{
			sql_query	='and sex = ' +'\''+gender.value+'\'';
			andCheck	=	1;
			}
	}
	

	var fields = new Array (f_patientByCriteria.document.forms[0].patient_id);
    var names = new Array (getLabel("Common.patientId.label","Common"));	
	var error_jsp="../../eCommon/jsp/error.jsp";
	if(SpecialCharCheck(fields,names,messageFrame,"M",error_jsp)) {
		f_patientByCriteria.document.forms[0].search.disabled = true;
		messageFrame.location.href="../../eCommon/jsp/error.jsp" ;  
		f_patientByCriteria_Result.location.href='../../eAE/jsp/AEPatDetailsResultCall.jsp?patient_id='+patient_id.value+'&contact_no='+escape(ctelno.value)+'&sql_query='+sql_query;
	}
	}
		else
		{	
			var error=error=getMessage('TO_DT_GR_EQ_FM_DT','SM');
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
			return false;
		}

	}

async function CallPatientTypeLookup()
{
	var msg="";
	var facility_id=document.forms[0].facilityId.value;
	var target				= document.forms[0].ae_patByCriteria_pattype_desc;
	var retVal				=    new String();
	var dialogTop			= "40";
	var dialogHeight		= "20vh" ;
	var dialogWidth			= "50vw" ;
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql="";
	var search_desc="";
	var tit="";
	sql=" select patient_type,short_desc from am_patient_type ";

	search_code="patient_type";
	search_desc="short_desc";
	tit=encodeURIComponent(getLabel("Common.patienttype.label","Common"));
	retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
		
	var arr=new Array();

	if (!(retVal == null))
	{

		var retVal=unescape(retVal);
		arr=retVal.split("::");

		document.forms[0].ae_patByCriteria_pattype_desc.value=arr[0];
		document.forms[0].ae_patByCriteria_pattype.value=arr[1];

		document.forms[0].ae_patByCriteria_pattype_desc.focus();
	}
	else
	{
		target.focus();
	}

}

async function CallLocationLookup(facilityId)
{
	var facility_id=document.forms[0].facilityId.value;
	var msg="";

	//facility_id				="`"+facility_id+"`";
		
	var target				= document.forms[0].ae_patbycriteria_location_desc;
	var retVal				=    new String();
	var dialogTop			= "40";
	var dialogHeight		= "20vh" ;
	var dialogWidth			= "50vw" ;
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql="";
	var search_desc="";
	var tit="";
	sql=" select clinic_code, short_desc from op_clinic where facility_id = "+facility_id+" and clinic_type  in (select locn_type from am_care_locn_type where care_locn_type_ind=`C`) and level_of_care_ind = `E` and eff_status = `E` ";
	search_code="clinic_code";
	search_desc="short_desc";
	tit=encodeURIComponent(getLabel("Common.locationcode.label","Common"));
	retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
		
	var arr=new Array();

	if (!(retVal == null))
	{

		var retVal=unescape(retVal);
		arr=retVal.split("::");

		document.forms[0].ae_patbycriteria_location_desc.value=arr[0];
		document.forms[0].ae_patbycriteria_location.value=arr[1];

		document.forms[0].ae_patbycriteria_location_desc.focus();
	}
	else
	{
		target.focus();
	}

}

function changeCase(obj)
   {
	  obj.value=obj.value.toUpperCase();
   }
function callfocus()
{
	document.forms[0].patient_id.focus();
}

async function viewpatdet(pat_id,encounter_id)
	{
		var url			= "../../eAE/jsp/ViewPatHistoryDetailsMain.jsp?Patient_ID="+pat_id+	"&EncounterId="+encounter_id;
		var dialogTop		= "";
		var dialogHeight	= "100vh";
		var dialogWidth		= "45vw";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no;";
		var returnval =await top.window.showModalDialog( url, arguments, features ) ;
	}
	async function CallViewPatDetails1(patient_id,encounter_id)
	{

			var url			= "../../eAE/jsp/ViewPatHistoryDetailsMain.jsp?Patient_ID="+patient_id+"&EncounterId="+encounter_id;
			var dialogTop		= "85";
			var dialogHeight	= "45vh";
			var dialogWidth		= "70vw";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +"; status=no;";
			var returnval =await window.showModalDialog( url, arguments, features ) ;
			parent.window.close();			
	}

//All from AEMPSearchResult.jsp
/********************************************************/
function sort(sortVal,zone)
{
	var observe_id=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.observe_id.value;
	var prev=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria_sensor.value;
	/*Added by Thamizh selvi on 15th May 2018 against ML-MMOH-CRF-1029 Start*/
	if(parent.AEMPSearchResultFrame.document.forms[0].isPendingForAdmissionAppl.value == "true" && parent.AEMPSearchResultFrame.document.forms[0].orderCriteria.value == "zone")
		prev = parent.AEMPSearchResultFrame.document.forms[0].orderCriteria.value;
	/*End*/
	if(prev==sortVal)
	{
		   var toggle=parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.asc_desc;
			if(toggle.value==' asc')
				{	
			      toggle.value=' desc';
				}
				else
				{
				  toggle.value=' asc';
				}
	}

	else{
	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.asc_desc.value=' asc';
 	}
	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria.value=sortVal;
	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria_sensor.value=sortVal;
	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.priority_zone.value=zone;	
 if (parent.AEMPSearchResultFrame.document.forms[0].observe_id.value!='' && zone =="observe" )	{
		   if (observe_id=='C')
		   {

			   showQueryResult2('clinic');
		   }
		   else if (observe_id=='T')
		   {
			   showQueryResult2('TreatmentArea');
		   }
	}
	else
		   {
				showQueryResult2('waitlist');	
		   }
	
	parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.orderCriteria.value='';
    parent.AEMPSearchCriteriaFrame.document.AEMPSearchCriteriaForm.priority_zone.value='';
}

/********************************************************/

function hideAllGifs(sortVal){

//Added by Sangeetha for ML-MMOH-CRF-0636 on 26/apr/17
var sortByPriorityZone = document.forms[0].sortByPriorityZone.value;
if(sortByPriorityZone == "true"){
	document.forms[0].zoneGif.style.visibility='hidden';
}
/*Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658 Start*/
var isPendingForAdmissionAppl = document.forms[0].isPendingForAdmissionAppl.value;
if(isPendingForAdmissionAppl == "true" && document.forms[0].forAdmGif)
	document.forms[0].forAdmGif.style.visibility='hidden';
/*End*/
document.forms[0].practitionerGif.style.visibility='hidden';
document.forms[0].dateGif.style.visibility='hidden';
document.forms[0].patNameGif.style.visibility='hidden';
document.forms[0].patIdGif.style.visibility='hidden';
document.forms[0].waitTimeGif.style.visibility='hidden';
document.forms[0].statusGif.style.visibility='hidden';
document.forms[0].locTypeGif.style.visibility='hidden';
document.forms[0].prior.style.visibility='hidden';
document.forms[0].ageGif.style.visibility='hidden';
}
/**************************************************/
function toggleGifs(sortVal, order){

if(sortVal=="practitioner")
		{
			document.getElementById('practitionerGif').style.visibility='visible';
			if(order==' asc')
					document.forms[0].practitionerGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].practitionerGif.src = '../../eAE/images/Descending.gif';
		}
		else if(sortVal=="bed_no")
		{
			document.getElementById('bedNoGif').style.visibility='visible';
			if(order==' asc')
					document.getElementById('bedNoGif').src = '../images/Ascending.gif';
			else
					document.getElementById('bedNoGif').src = '../images/Descending.gif';
		}

else if(sortVal=="queueDate")
		{
			document.getElementById('dateGif').style.visibility='visible';
			if(order==' asc')
					document.getElementById('dateGif').src = '../images/Ascending.gif';
			else
					document.getElementById('dateGif').src = '../images/Descending.gif';
		}

else if(sortVal=="patientName")
		{
			
			document.getElementById('patNameGif').style.visibility='visible';
			if(order==' asc')
					document.getElementById('patNameGif').src = '../images/Ascending.gif';
			else
					document.getElementById('patNameGif').src = '../images/Descending.gif';
		
		}

else if(sortVal=="patientId")
		{
			document.getElementById('patIdGif').style.visibility='visible';
			
			if(order==' asc')
					document.getElementById('patIdGif').src = '../images/Ascending.gif';

			else
					document.getElementById('patIdGif').src = '../images/Descending.gif';
		}
		else if(sortVal=="age")
		{
			document.getElementById('ageGif').style.visibility='visible';
			
			if(order==' asc')
					document.getElementById('ageGif').src = '../images/Ascending.gif';

			else
					document.getElementById('ageGif').src = '../images/Descending.gif';
		}

else if(sortVal=="status")
		{
				document.getElementById('statusGif').style.visibility='visible';
			if(order==' asc')
					document.forms[0].statusGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].statusGif.src = '../../eAE/images/Descending.gif';
		}

else if(sortVal=="priorityZone")
		{
				document.getElementById('prior').style.visibility='visible';
			if(order==' asc')
					document.forms[0].prior.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].prior.src = '../../eAE/images/Descending.gif';
		}

else if(sortVal=="waitingTime")
		{
			document.getElementById('waitTimeGif').style.visibility='visible';
			if(order==' asc')
					document.forms[0].waitTimeGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].waitTimeGif.src = '../../eAE/images/Descending.gif';
		}
//Added by Sangeetha for ML-MMOH-CRF-0636 on 26/apr/17
else if(sortVal=="zone")
		{
			document.getElementById('zoneGif').style.visibility='visible';
			if(order==' asc')
					document.forms[0].zoneGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].zoneGif.src = '../../eAE/images/Descending.gif';
		}
	/*Added by Thamizh selvi on 24th Apr 2018 against ML-MMOH-CRF-0658 Start*/
	else if(sortVal=="for_admission" && document.forms[0].forAdmGif){
		document.getElementById('forAdmGif').style.visibility='visible';
		if(order==' asc')
			document.forms[0].forAdmGif.src = '../../eAE/images/Ascending.gif';
		else
			document.forms[0].forAdmGif.src = '../../eAE/images/Descending.gif';
	}/*End*/
	
	/*Added by Thamizh selvi on 15th May 2018 against ML-MMOH-CRF-1029 Start*/
	else if(document.forms[0].priority_zone && sortVal=="locType" && document.forms[0].locTypeGif){
		if(document.forms[0].priority_zone.value == "for_admission"){
			document.getElementById('locTypeGif').style.visibility='visible';
			if(order==' asc')
				document.forms[0].locTypeGif.src = '../../eAE/images/Ascending.gif';
			else
				document.forms[0].locTypeGif.src = '../../eAE/images/Descending.gif';
		}
	}/*End*/
}

/**************************************************/


function onMMove(obj,e,brought_dead,brought_dead_yn)
	{
		if(brought_dead_yn=="Y"){
		var brought_dead;
		obj.style.left=e.x+20;
		obj.style.top=e.y;
		obj.style.borderColor='pink';
		obj.style.borderWidth='thin';
		obj.style.borderStyle='groove';
		obj.style.width=150;

		obj.innerHTML="<table cellspacing='0' cellpadding='0' border='0' height=100% width='100%'><tr><td class='ordata' valign='top'>"+brought_dead+"</td></tr></table>";
		}
		else
			return false;
	}
function onMOut(obj,brought_dead_yn)
	{
		if(brought_dead_yn=="Y"){
		obj.innerHTML='';
		obj.style.width=0;
		obj.style.borderColor='';
		obj.style.borderWidth='';
		obj.style.borderStyle='';
		}
		else
			return false;
	}
	function DummyRef(){
	}
    function showAsen()
	{
	}


function alignHeading1()
{



	if(document.getElementById('th_table') != null) {
				
		for (j=0; j < document.getElementById('tb1').rows[1].cells.length; j++) {
			
			var wid=eval(document.getElementById('tb1').rows[1].cells[j].offsetWidth);
			
			if(document.getElementById('th_table').rows[0].cells[j] != null){
				
					
					var  wid1 = eval(document.getElementById('th_table').rows[0].cells[j].offsetWidth);
					if(wid1<wid)
					{
							document.getElementById('th_table').rows[0].cells[j].width=wid;
							}
					else
					{
						document.getElementById('tb1').rows[1].cells[j].width=eval(document.getElementById("th_table").rows[0].cells[j].offsetWidth);
					}
				
				}
			
		}
		document.getElementById('th_table').width =	eval(document.getElementById('tb1').offsetWidth);
		document.getElementById('TitleTab').width =	eval(document.getElementById('tb1').offsetWidth);
	}
}


function scrollTitle(){

  var x = document.body.scrollTop;
  if(x == 0){
   document.getElementById('divTitleTable').style.position = 'static';
   document.getElementById('divTitleTable').style.posTop  = 0;
  }else{
	document.getElementById('divTitleTable').style.position = 'relative';
	document.getElementById('divTitleTable').style.posTop  = x-2;
  
  }

}

function checkDate(obj){	
		if(obj.value!="") {
			 if((!isBeforeNow(obj.value,'DMY',localeName))) 	{
				alert(getMessage("START_DATE_GREATER_SYSDATE","common"))
				obj.value="";
				obj.select();
				return false;
			 }
		}
}
