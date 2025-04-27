/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
27/02/2012	  IN031538		 Menaka V	 In discharge summary note we have put the variable for Admitting doctor
										 but the data is not showing in the report Admitting Doctor and Attending Doctor, both Name should print in discharge summary and all other notes	
15/05/2012	  IN032721		Ramesh G	When we Click on Print Preview the Date is not displayed in the examination date component.
21/01/2013	  CHL_CRF_0010	Nijitha S	Under Patient Charts section new functionality should be added ?View Nurse Notes? and all the notes written by nurses should come under view Nurse notes
12/08/2013		IN038643	 Karthi L		A new field by name "Speciality" will be introduced as search filter in View Clinical Notes function in Clinician Access
22/08/2013		IN042638	Karthi L	At View Clinical Notes by selecting 'All' option at Specialty filter System displaying Query cased no records even though recorded Clinical Notes exist for the patient
26/8/2013	IN042640		Karthi L	Alignment problem 	
18/09/2013	  IN043437	   Karthi L		By selecting Specialty having Special characters we get wrong message prompt. 										
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History    	Name				Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
30/11/2015	  	IN058541/IN057113	Karthi												System does not prompt for PIN in Record Charts Function	
06/10/2016	IN047572			Karthi L										[MMS-QH-CRF-0177]To provide attending doctor and specialty  filter in the ?View Clinical Notes? and ?Clinical Event History?
15/03/2017		IN051294		Krishna Gowtham J										MO-CRF-20087
08/01/2018	IN064446			Raja S			08/01/2018		Ramesh G		GHL-CRF-0469
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
var isPrintPinValidationReq; //ML-MMOH-CRF-0335 - IN057113
function populatenotetype()
{
//alert(parent.ViewClinicalNoteCriteriaFrame.name);
document.forms[0].note_type.disabled=false;
var length  =parent.ViewClinicalNoteCriteriaFrame.document.ClinicalNote.note_group.length;	
			
for(i=1;i<length;i++)
{
parent.ViewClinicalNoteCriteriaFrame.document.ClinicalNote.note_type.remove(i);
}

var note_group     = document.forms[0].note_group.value;
//alert(note_group);	

HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='dummy_form' id='dummy_form' method='post' action='../../eCA/jsp/ViewClinicalNoteNoteTypePopulate.jsp'><input type=hidden name='note_group' id='note_group' value='"+note_group+"'></form></body></html>";
top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
top.content.messageFrame.document.dummy_form.submit();

}

function showCalendarValidate(str){
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}

function CheckSystemDateLesser2(from,today) { 
	//args objects 1st is this object & second is the date in dd/mm/yyyy
	//alert(from.value);
	//alert(today)
 if(today != "" && from.value !="" )
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today ;
				
				if(fromdate.length > 0 && todate.length > 0 )
				{
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						if(Date.parse(todt) < Date.parse(fromdt))
						{
							var msg =getMessage("START_DATE_GREATER_SYSDATE","COMMON");
							alert(msg);
							//top.messageframe.location.href = '../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}
						else if(Date.parse(todt) >= Date.parse(fromdt))
						{
							parent.parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp?';
							return true;
						}
				}
			return true;
	 }
	 return true;
}
/*
function ftDateChecknew2(from,to,obj,obj1)
	{
	
			//alert('in validate');
			//alert(from.value);
			//alert(to.value);
			if(doDateCheckAlert(from,to)==false) {
				alert(getMessage("TO_DT_GR_EQ_FM_DT",'CA'));
				to.select();
				to.focus();
			
			} 

		}*/

function ftDateChecknew2(fromDate,toDate,currDate,format,locale)
{
	if((!fromDate.value=="")&&(!toDate.value==""))
	{
	if(isBeforeNow(fromDate.value, format, locale))
	{
		if(isBeforeNow(toDate.value, format, locale))
		{
			if(isAfter(toDate.value, fromDate.value, format, locale))
				return true;
			else
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
			//	toDate.focus();
      toDate.value="";
				return false;
			}
		}
		else
		{
			alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
		//	toDate.select();
			//toDate.focus();
      toDate.value="";
			return false;
		}

	}
	else
	{
		alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
		//fromDate.select();
//		fromDate.focus();
fromDate.value="";
		return false;
	}
	}


}


function search_result()
{
//alert('showsearch');

var fields;
var names;

//fields = new Array (document.forms[0].from_date,document.forms[0].to_date);

//names  = new Array ("Period From","Period To"); 

if(document.forms[0].note_group_desc.value==null || document.forms[0].note_group_desc.value=="")
			document.forms[0].note_group.value=document.forms[0].note_group_desc.value;
if(document.forms[0].note_type_desc.value==null || document.forms[0].note_type_desc.value=="")
		document.forms[0].note_type.value=document.forms[0].note_type_desc.value;
if(document.forms[0].performed_by.value==null || document.forms[0].performed_by.value=="")
		document.forms[0].performed_by_code.value=document.forms[0].performed_by.value;

if(document.forms[0].med_anc.value==null || document.forms[0].med_anc.value=="")
		document.forms[0].med_anc_code.value=document.forms[0].med_anc.value;


var note_group=document.forms[0].note_group.value
var note_type=document.forms[0].note_type.value
var status=document.forms[0].status.value
var from_date=document.forms[0].from_date.value
var to_date=document.forms[0].to_date.value
var performed_by=document.forms[0].performed_by_code.value
var med_anc=document.forms[0].med_anc_code.value
var group=document.forms[0].group.value
var order=document.forms[0].order.value
var ref_no=document.forms[0].ref_no.value
var querystring=document.forms[0].querystring.value;
var called_function_id=document.forms[0].called_function_id.value;
var speciality_code =  document.ClinicalNote.speciality_code.value;// added for BRU-HIMS-CRF-356 [IN038643] 
var attend_pract_code = document.ClinicalNote.attend_pract_code.value; //MMS-QH-CRF-0177 [IN047572]
var cur_api = document.forms[0].primary.value;
var patient_id=document.forms[0].patient_id.value //IN051294
top.content.workAreaFrame.ViewClinicalNoteResult.cols = '200px,70%';
//		top.content.workAreaFrame.document.getElementById("ViewClinicalNoteResultTreeFrame").style.width="16vw";
	//	top.content.workAreaFrame.document.getElementById("ViewClinicalNoteNoteContentMainDetailFrame").style.width="82vw";




//alert(cur_api);
//alert("../../eCA/jsp/RelatedPatientHistResult?view="+view+"&spl="+spl+"&rest="+rest+"&from_date="+from_date+"&to_date="+to_date+"&diag="+diag+"&from_age="+from_age+"&to_age="+to_age+"&sex="+sex+"&status="+status+"&group="+group);

//if(checkFields( fields, names, parent.parent.messageFrame))
	{
parent.ViewClinicalNoteNoteContentMainDetailFrame.location.href ="../../eCommon/html/blank.html";
//parent.ViewClinicalNoteResultTreeFrame.location.href="../../eCA/jsp/ViewClinicalNoteResultTree.jsp?no_modal=Y&note_group="+note_group+"&note_type="+note_type+"&status="+status+"&from_date="+from_date+"&to_date="+to_date+"&performed_by="+performed_by+"&med_anc="+med_anc+"&group="+group+"&order="+order+"&cur_api="+cur_api+"&querystring="+querystring+"&ref_no="+ref_no;//CHL_CRF_0010
		//parent.ViewClinicalNoteResultTreeFrame.location.href="../../eCA/jsp/ViewClinicalNoteResultTree.jsp?no_modal=Y&note_group="+note_group+"&note_type="+note_type+"&status="+status+"&from_date="+from_date+"&to_date="+to_date+"&performed_by="+performed_by+"&med_anc="+med_anc+"&group="+group+"&order="+order+"&cur_api="+cur_api+"&querystring="+querystring+"&ref_no="+ref_no+"&called_function_id="+called_function_id;//CHL_CRF_0010 // commented for  BRU-HIMS-CRF-356 [IN038643] 
		//parent.ViewClinicalNoteResultTreeFrame.location.href="../../eCA/jsp/ViewClinicalNoteResultTree.jsp?no_modal=Y&note_group="+note_group+"&note_type="+note_type+"&status="+status+"&from_date="+from_date+"&to_date="+to_date+"&performed_by="+performed_by+"&med_anc="+med_anc+"&speciality_code="+speciality_code+"&group="+group+"&order="+order+"&cur_api="+cur_api+"&querystring="+querystring+"&ref_no="+ref_no+"&called_function_id="+called_function_id;// modified for  BRU-HIMS-CRF-356 [IN038643] // commented for MMS-QH-CRF-0177 [IN047572]
		//IN051294 start
		//parent.ViewClinicalNoteResultTreeFrame.location.href="../../eCA/jsp/ViewClinicalNoteResultTree.jsp?no_modal=Y&note_group="+note_group+"&note_type="+note_type+"&status="+status+"&from_date="+from_date+"&to_date="+to_date+"&performed_by="+performed_by+"&med_anc="+med_anc+"&speciality_code="+speciality_code+"&group="+group+"&order="+order+"&cur_api="+cur_api+"&querystring="+querystring+"&ref_no="+ref_no+"&called_function_id="+called_function_id+"&attend_pract_code="+attend_pract_code;// modified for  MMS-QH-CRF-0177 [IN047572]
		
		parent.ViewClinicalNoteResultTreeFrame.location.href="../../eCA/jsp/ViewClinicalNoteResultTree.jsp?no_modal=Y&note_group="+note_group+"&note_type="+note_type+"&status="+status+"&from_date="+from_date+"&to_date="+to_date+"&performed_by="+performed_by+"&med_anc="+med_anc+"&speciality_code="+speciality_code+"&group="+group+"&order="+order+"&cur_api="+cur_api+"&querystring="+querystring+"&ref_no="+ref_no+"&called_function_id="+called_function_id+"&attend_pract_code="+attend_pract_code+"&patient_id="+patient_id;
		//IN051294 ends
		parent.ViewClinicalNoteCriteriaFrame.document.ClinicalNote.searchresult_button.disabled=false;

	}
	/*else
	{
     parent.ViewClinicalNoteCriteriaFrame.document.ClinicalNote.searchresult_button.disabled=false;
	}*/


} 

function setCheck()
{

if(document.forms[0].primary.checked == true)
document.forms[0].primary.value='Y'
else
document.forms[0].primary.value='N'

}

//function call_notes(accession_num,from,no_modalval,called_function_id,encounter_id)//[IN032721]
function call_notes(accession_num,from,no_modalval,called_function_id,encounter_id,contr_mod_accession_num)//[IN032721]
{
	var no_modal=no_modalval;
	var function_id = "";
	//alert('no_modal'+no_modal);
	if(from != 'DISCHARGE_SUMMARY')
	{
	var note_group=parent.ViewClinicalNoteCriteriaFrame.document.forms[0].note_group.value
    var status=parent.ViewClinicalNoteCriteriaFrame.document.forms[0].status.value
	if(parent.ViewClinicalNoteResultTreeFrame != null)
	    function_id = parent.ViewClinicalNoteResultTreeFrame.document.result_form.function_id.value;

    var statustxt='';
	
	if(status ==  '3')
    statustxt =  'Unauthorized'
	else if(status ==  '4')
    statustxt =  'Authorized'
	else if(status ==  '5')
    statustxt =  'Modified'
	else if(status ==  '5')
    statustxt =  'In Error' 

    
 
	accession_num=accession_num;
	
	
	//alert(parent.ViewClinicalNoteNoteContentMainFrame.ViewClinicalNoteNoteContentMainDetailFrame.name)
	}
	//parent.ViewClinicalNoteNoteContentMainDetailFrame.location.href = '../../eCA/jsp/ViewClinicalNoteNoteContentDeatail.jsp?accession_num='+accession_num+'&no_modal='+no_modal+'&note_group='+note_group+'&statustxt='+statustxt+'&fun=VCN&called_function_id='+called_function_id+'&encounter_id='+encounter_id+'&function_id='+function_id; //[IN032721]
	parent.ViewClinicalNoteNoteContentMainDetailFrame.location.href = '../../eCA/jsp/ViewClinicalNoteNoteContentDeatail.jsp?accession_num='+accession_num+'&no_modal='+no_modal+'&note_group='+note_group+'&statustxt='+statustxt+'&fun=VCN&called_function_id='+called_function_id+'&encounter_id='+encounter_id+'&function_id='+function_id+'&contr_mod_accession_num='+contr_mod_accession_num; //[IN032721]
	
	
    //    parent.ViewClinicalNoteNoteContentMainDetailFrame.location.href = '../../eCA/jsp/PhysicianNotesDetailsFrame.jsp?accession_num='+accession_num+'&no_modal='+no_modal+'&note_group='+note_group+'&statustxt='+statustxt+'&fun=VCN'; 
	

}

function clear_result()
{
parent.ViewClinicalNoteResultTreeFrame.location.href="../../eCommon/html/blank.html";
parent.ViewClinicalNoteNoteContentMainDetailFrame.location.href = "../../eCommon/html/blank.html"; 
if(parent.ViewClinicalNoteCriteriaFrame.document.forms[0])
		 parent.ViewClinicalNoteCriteriaFrame.document.forms[0].reset();
}
function reSize(obj)
{

//alert('Frame name'+top.content.workAreaFrame.ViewClinicalNoteCriteriaFrame.ViewClinicalNoteResult.name);


if(obj.value == 'Zoom+') {
	
	//top.content.workAreaFrame.ViewClinical.rows = "0%,100%";
	//top.content.workAreaFrame.ViewClinicalNoteResult.cols = "0%,100%";
	
	top.content.workAreaFrame.document.getElementById("ViewClinicalNoteCriteriaFrame").style.height="0vh";
	top.content.workAreaFrame.document.getElementById("ViewClinicalNoteResultTreeFrame").style.height="0vw"
	top.content.workAreaFrame.document.getElementById("ViewClinicalNoteNoteContentMainDetailFrame").style.height="100vh";
	
	top.content.workAreaFrame.document.getElementById("ViewClinicalNoteCriteriaFrame").style.width="0vw";
	top.content.workAreaFrame.document.getElementById("ViewClinicalNoteResultTreeFrame").style.width="0vw"
	top.content.workAreaFrame.document.getElementById("ViewClinicalNoteNoteContentMainDetailFrame").style.width="100vw";
	
	obj.value=getLabel("eCA.Zoom.label","ca")+"-";
	
}
else {
			
	//top.content.workAreaFrame.ViewClinical.rows = "30%,70%"; // modified from 27% to 30% for 42640
	   // top.content.workAreaFrame.ViewClinicalNoteResult.cols = "200px,77%";
		
		top.content.workAreaFrame.document.getElementById("ViewClinicalNoteCriteriaFrame").style.height="34vh";
		top.content.workAreaFrame.document.getElementById("ViewClinicalNoteResultTreeFrame").style.height="28.3vw"
		top.content.workAreaFrame.document.getElementById("ViewClinicalNoteNoteContentMainDetailFrame").style.height="70vh";
		
		top.content.workAreaFrame.document.getElementById("ViewClinicalNoteCriteriaFrame").style.width="98vw";
		top.content.workAreaFrame.document.getElementById("ViewClinicalNoteResultTreeFrame").style.width="15vw"
		top.content.workAreaFrame.document.getElementById("ViewClinicalNoteNoteContentMainDetailFrame").style.width="82vw";
		obj.value=getLabel("eCA.Zoom.label","ca")+"+";
	}
}

async function servicePract(Object)
{
	if(Object.name=='performed_by')
	{
		if((Object.value) == "null" || (Object.value ==""))
		{
				return false;			
		}
		else
		{
			checkRec(Object);
		}
	}
	else if(Object.name=='search_ref')
	{
		await getServiceCode3();
	}
}
async function getMedService(Object)
{
	if(Object.name=='med_anc')
	{
		if((Object.value) == "null" || (Object.value ==""))
		{
				return false;			
		}
		else
		{
			checkRec2(Object);
		}
	}
	else if(Object.name=='search_ref2')
	{
		await getServiceCode4();
	}
}
async function getServiceCode3()
	{	
		var target			= document.forms[0].performed_by;
		var stdval          = document.forms[0].performed_by.value;
        var val				= document.forms[0].facilityid.value;
		var retVal			=  new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.practitioner.label","COMMON");
		var locale			= document.forms[0].locale.value;
		
       

		//var sql="Select std_comp_id, std_comp_desc from am_standard_comp where eff_status = `E` and std_comp_result_type= `"+val+"` ";
		var sql="Select a.practitioner_id code , b.practitioner_name description from AM_PRACT_FOR_FACILITY A, AM_PRACTITIONER_LANG_VW B where UPPER(b.practitioner_name) like upper(?) AND a.practitioner_id like upper(?) AND a.facility_id = '"+val+"' AND B.PRACTITIONER_ID = A.PRACTITIONER_ID AND B.LANGUAGE_ID = '"+locale+"' ";

		//search_code="practitioner_id";
		//search_desc="practitioner_name";

		//retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title)+"&dispDescFirst=dispDescFirst",arguments,features);
		 
		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "2,1";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = await CommonLookup( title, argArray );	
		var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retArray != null && retArray !="")
		{

			document.forms[0].performed_by.value = arr[1];
		   	document.forms[0].performed_by_code.value = arr[0];
			
				
		}
		else
		{
			document.forms[0].performed_by.value = "";
			document.forms[0].performed_by_code.value = "";
			
		}
		
	/*	var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{

			var retVal=unescape(retVal);

		   	arr=retVal.split("::");
			
		   	document.forms[0].performed_by.value = arr[0];
		   	document.forms[0].performed_by_code.value = arr[1];
			
				
		}
		else
		{
			document.forms[0].performed_by.value = "";
			document.forms[0].performed_by_code.value = "";
			
		} */ 
	}

	async function getServiceCode4()
	{
		var target			= document.forms[0].med_anc;
		var stdval          = document.forms[0].med_anc.value;
       
		var retVal			=  new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.service.label",'COMMON');
		var locale			= document.forms[0].locale.value;

		
       

		//var sql="Select std_comp_id, std_comp_desc from am_standard_comp where eff_status = `E` and std_comp_result_type= `"+val+"` ";
		//var sql="Select service_code, short_desc from am_service_LANG_VW where eff_status = `E` AND LANGUAGE_ID = `"+locale+"` ";
        var sql="SELECT service_code code, short_desc description from am_service_lang_vw where eff_status='E' and upper(short_desc) like upper(?) and service_code like UPPER(?) and language_id = '"+locale+"' ";
			
		//search_code="service_code";
		//search_desc="short_desc";
		//retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title)+"&dispDescFirst=dispDescFirst",arguments,features);
		
		
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "2,1";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = await CommonLookup( title, argArray );	
			var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retArray != null && retArray !="")
	{
		document.forms[0].med_anc.value = arr[1];
		document.forms[0].med_anc_code.value = arr[0];
	}
	else
	{
	document.forms[0].med_anc.value = "";
	document.forms[0].med_anc_code.value = "";
	}

	
	/*	var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{

			var retVal=unescape(retVal);

		   	arr=retVal.split("::");
			
		   	document.forms[0].med_anc.value = arr[0];
		   	document.forms[0].med_anc_code.value = arr[1];
			
				
		}
		else
		{
			document.forms[0].med_anc.value = "";
			document.forms[0].med_anc_code.value = "";
			
		} */
	}

function checkRec(obj)
{
	//alert(obj.value);
	//alert(top.content.messageFrame.name);
	

   if (obj.value!= "")
	{
		
		HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown='lockKey()' class=MESSAGE><form name='ViewClinicalNoteForm' id='ViewClinicalNoteForm' method='post' action='ViewClinicalNotePractionerSearch.jsp'><input type=hidden name='perform' id='perform' value='"+obj.value+"' </form></body></html>"
		top.content.messageFrame.document.write(HTMLVal);
		top.content.messageFrame.document.ViewClinicalNoteForm.submit();
		//parent.frames[3].document.forms[0].mandatory.focus();
	}
 

}

function checkRec2(obj)
{
	
	

   if (obj.value!= "")
	{
		
		HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown='lockKey()' class=MESSAGE><form name='ViewClinicalNoteServiceForm' id='ViewClinicalNoteServiceForm' method='post' action='ViewClinicalNoteServiceSearch.jsp'><input type=hidden name='service' id='service' value='"+obj.value+"' </form></body></html>"
		top.content.messageFrame.document.write(HTMLVal);
		top.content.messageFrame.document.ViewClinicalNoteServiceForm.submit();
		
	}
 

}
async function getNoteGroups(Object)
{
	if(Object.name=='note_group_desc')
	{
		if((Object.value) == "null" || (Object.value ==""))
		{
			document.forms[0].note_type_desc.disabled=true;
			document.forms[0].note_type_search.disabled=true;
			document.forms[0].note_group_desc.value="";
			document.forms[0].note_group.value="";
				return false;			
		}
		else
		{
			await getNoteGroup();
		}
	}
	else if(Object.name=='note_desc_search')
	{
		await getNoteGroup();
	}
}
async function getNoteGroup()
	{
		var target				= document.forms[0].note_group_desc;
		var retVal				=  new String();
		//var dialogTop			= "30";
		//var dialogHeight		= "10" ;
		//var dialogWidth			= "35" ;

		//var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc			= "";
		var title				= getLabel("eCA.NoteGroup.label","CA");
		var locale				= document.forms[0].locale.value;

		var sql="SELECT NOTE_GROUP code,NOTE_GROUP_DESC description from ca_note_group_lang_vw where upper(NOTE_GROUP_DESC) like upper(?)AND upper(NOTE_GROUP) like upper(?) AND language_id ='"+locale+"'";
		
		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();

		argArray[0]	= sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "2,1";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = await CommonLookup( title, argArray ); 
		
		var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retArray != null && retArray !="")
		{
			
			//alert(unescape(retArray[0]));
		   	document.forms[0].note_group_desc.value=arr[1];
			document.forms[0].note_group.value=arr[0];
			//document.forms[0].note_group_desc.focus();
			
			populatenotetypes();
		}
		else
		{
			document.forms[0].note_type_desc.disabled=true;
			document.forms[0].note_type_search.disabled=true;
			document.forms[0].note_group_desc.value="";
			document.forms[0].note_group.value="";

			target.focus();
		}	
	
	
	/*	var arr=new Array();

		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
		   	arr=retVal.split("::");
			alert(unescape(arr[0]));
		   	document.forms[0].note_group_desc.value=arr[0];
			document.forms[0].note_group.value=arr[1];
			document.forms[0].note_group_desc.focus();
			
			populatenotetypes();
		}
		else
		{
			document.forms[0].note_group_desc.value="";
			document.forms[0].note_group.value="";
			target.focus();
		} */
	}

	function populatenotetypes()
	{
		document.forms[0].note_type_desc.disabled=false;
		document.forms[0].note_type_search.disabled=false;
		document.forms[0].note_type_desc.value="";
		document.forms[0].note_type.value="";
	}
	async function getnotetype(Object)
	{
		if(Object.name=='note_type_desc')
	{
		if((Object.value) == "null" || (Object.value ==""))
		{
				return false;			
		}
		else
		{
			await getnotetypes();
		}
	}
	else if(Object.name=='note_type_search')
	{
		await getnotetypes();
	}
	}
	async function getnotetypes()
	{
		var note_group      =document.forms[0].note_group.value;
   		var target			= document.forms[0].note_type_desc;
		var retVal			=  new String();
		var dialogTop	= "40";
		var dialogHeight		= "10" ;
		var dialogWidth	= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc			= "";
		var title			= getLabel("Common.NoteType.label",'COMMON');
		var locale  = document.forms[0].locale.value;
		var sql="Select note_type code, note_type_desc description from ca_note_type_lang_vw where upper(note_type_desc) like upper(?) and note_type like upper(?) and eff_status='E' and note_group_id = '"+note_group+"'  and language_id = '"+locale+"' " ;

		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();

		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "2,1";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		
		retArray = await CommonLookup( title, argArray );
		var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retArray != null && retArray !="")
		{
			document.forms[0].note_type_desc.value=arr[1];
			document.forms[0].note_type.value=arr[0];
			//document.forms[0].note_type_desc.focus();
		}
		else
		{
			document.forms[0].note_type_desc.value="";
			document.forms[0].note_type.value="";
			target.focus();
		}

		/*
		var arr=new Array();

		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);

		   	arr=retVal.split("::");
		   	document.forms[0].note_type_desc.value=arr[0];
			document.forms[0].note_type.value=arr[1];
			document.forms[0].note_type_desc.focus();
		}
		else
		{
			document.forms[0].note_type_desc.value="";
			document.forms[0].note_type.value="";
			target.focus();
		} */

	}

async function printNotes(printMode) 
{ 
	var pMode = printMode;
	
	//ML-MMOH-CRF-0335 - IN057113 - Start
	var conf_pin_req_yn = document.heading.l_conf_pin_req_yn.value;
	if(conf_pin_req_yn == 'Y') {
		isPinValidationReq();
		if(isPrintPinValidationReq == 'Y') {
			retVal =  validatePintoPrint();
			if(retVal == 'X')
				return false;
		}	
	}	
	//ML-MMOH-CRF-0335 - IN057113 - End
	var retVal		= 	new String();
	var dialogTop	=	"60"; 
	var dialogHeight=	"90vh" ;
	var dialogWidth	=	"69vw" ;
	var data		=	new Array();
	var features	=	"dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=yes" ;
	var header = "";
	var header1 = "";
	var PrintMode = "";
	var footer="";

	var facility_id			=	document.forms[0].facilityid.value;	
	var visit_adm_date		=	document.forms[0].admission_date.value;
	var specialty_name		=	document.forms[0].speciality.value;
	var function_id			=	parent.parent.ViewClinicalNoteCriteriaFrame.document.ClinicalNote.function_id.value;
	var episode_type		=	parent.parent.ViewClinicalNoteCriteriaFrame.document.ClinicalNote.episode_type.value;
	var encounter_id		=	document.forms[0].encounter_id.value;
	var patient_id			=	parent.parent.ViewClinicalNoteCriteriaFrame.document.ClinicalNote.patient_id.value;
	var patient_class		=	document.forms[0].patient_class.value;
	var episodeDesc			=	document.forms[0].patient_class.value;
	var site_name			=	document.forms[0].siteName.value;
	var dischargeDateTime   =	document.forms[0].discharge_date.value;
	var attend_pract		=	document.forms[0].attend_pract.value;
	var admitting_practitioner		=	document.forms[0].admitting_practitioner.value;//IN031538
	var locationDesc		=	document.forms[0].location_name.value;
	var contr_mod_accession_num = document.forms[0].contr_mod_accession_num.value; //[IN032721]
    var accession_num		= document.forms[0].accession_num.value;
	var event_date_time		= document.forms[0].event_date_time.value;
	var print_date_time		= document.forms[0].print_date_time.value;
	var last_modified_by_name= document.forms[0].last_modified_by_name.value;
	var authorized_by_name	= document.forms[0].authorized_by_name.value;
	var note_type			= document.forms[0].note_type.value;
	var performed_by_name	= document.forms[0].performed_by_name.value;
	var patient_age			= document.forms[0].patient_age.value;
	var title				= document.forms[0].note_header_desc.value;
	var facility_name		= document.forms[0].facility_name.value;
	var sex					= document.forms[0].sex.value;
	var patient_name		= document.forms[0].patient_name.value;
	var med_service			= document.forms[0].med_service.value;
	var dis_summ_disclaimer_txt = document.forms[0].dis_summ_disclaimer_txt.value;
		

	if(episode_type == "O"  || episode_type == "I")
		episodeDesc = episode_type + "P";



			header = "<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >";
			header +="<tr><td align='left' width='5%' rowspan='2'><img valign='top' src='../../eCommon/images/Entilogo.jpg' border='0'></td><td  align=center><h3>"+site_name+"</h3></td></tr>";
			header +="<tr><td align=center><h3>"+facility_name+"</h3></td></tr>";
			header +="<tr><td>&nbsp;</td><td align=center><h4>"+title+"</h4></td></tr></table>";
			header +="<br>";

			header1 +="<table border='1' cellpadding='3' cellspacing='0' width = '100%' style='font-family:Verdana;:background-color:#ADADAD'>";
			header1 +="<tr><td>";
			header1 +="<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center>";
			header1 +="<tr><td nowrap><b>"+getLabel("Common.patientId.label","common")+"</b></td><td nowrap><font size='2'>: "+patient_id+"</font></td>";
			header1 +="<td nowrap><b>"+getLabel("Common.name.label","common")+"</b></td><td colspan ='3'><font size='2'>: "+patient_name+"</font></td></tr>";
			header1 +="<tr><td nowrap><b>"+getLabel("Common.gender.label","common")+"</b></td><td nowrap><font size='2'>: "+sex+"</font></td><td nowrap><b>"+getLabel("Common.age.label","common")+"</b></td><td nowrap><font size='2'>: "+patient_age+"</font></td></tr>";

			if(encounter_id != "0" )
			{
				header1 +="<tr><td nowrap><b>"+getLabel("Common.encounterid.label","common")+"</b></td><td nowrap><font size='2'>: "+encounter_id+"</font></td><td nowrap><b>"+getLabel("Common.encountertype.label","common")+"</b></td><td><font size='2'>: "+patient_class+"</font></td><td align='right' nowrap><b>"+getLabel("Common.encounterdate.label","common")+"</b></td><td nowrap><font size='2'>&nbsp;: "+visit_adm_date+"</font></td></tr>";
				header1 +="<tr><td nowrap><b>"+getLabel("Common.Location.label","common")+"</b></td>";
			}
			
			if(encounter_id != "0")
			{
				if(episode_type=="O")
				{
					header1 += "<td colspan='3' nowrap><font size='2'>: "+locationDesc+"</font></td>";
				}
				else
				{
					header1 += 	"<td colspan='3' nowrap><font size='2'>: "+locationDesc+"</font></td>";
				}
				
				header1+="<td align='right' nowrap><b>"+getLabel("Common.dischargedate.label","common")+"</b></td><td><font size='2'>&nbsp;: "+dischargeDateTime+"</font></td></tr>";
				
				header1+="<tr><td nowrap><b>"+getLabel("Common.speciality.label","common")+"</b></td><td colspan='2' nowrap><font size='2'>: "+specialty_name+"</font></td>";
				header1+="<td colspan='2'  align='right' nowrap><b>"+getLabel("Common.AttendingPractitioner.label","common")+"</b></td><td nowrap><font size='2'>&nbsp;: "+attend_pract+"</font></td></tr>";
			}
	
			header1 += "</table></td></tr></table>";		

	footer	=  "<table width='100%' border=1 cellpadding=0 cellspacing=0 align=center>";
	footer +=  "<tr><td><table width='100%' border=0 cellpadding=0 cellspacing=0 align=center>";
	footer +=  "<tr><td width='20%'><b>";
	footer +=  getLabel("Common.authorizedby.label","common");
	footer +=  "</b></td><td width='45%' align='left'>:  <font size='2'>";
	footer +=  authorized_by_name;
	footer +=  "</font></td><td width='15%'><b>Signature</b></td><td width='20%' align='left'>:  </td></tr>";
	footer +=  "<tr><td width='20%'><b>";
	footer +=  getLabel("Common.LastModifiedBy.label","common");
	footer +=  "</b></td><td width='45%' align='left'>:  <font size='2'>";
	footer +=  last_modified_by_name;
	footer +=  "</font></td><td width='15%'><b>";
	footer +=  getLabel("Common.Signature.label","common");
	footer +=  "</b></td><td width='20%' align='left'>:  </td></tr>";
	footer +=  "<tr><td width='20%'><b>";
	footer +=  getLabel("Common.PrintDateTime.label","common");
	footer +=  "</b></td><td width='45%' align='left'> <font size='2'>:  ";
	footer +=  print_date_time;
	footer +=  "</font></td><td width='15%'><b>";
	footer +=  getLabel("Common.LoggedUser.label","common");
	footer +=  "</b></td><td width='20%' align='left'><font size='2'>:  ";
	footer +=  document.forms[0].loggedUser.value;
	footer +=  "</font></td></tr></table></td></tr></table>";

	data[0] = header;
	//data[1] = header1;
	data[1] = "";
	//data[2] = footer;
	data[2] = "";
	//var dischargeSummary = document.forms[0].discharge_summary_text.value;
	//var dischargeSummary = "";
    var disclaimer ="";

	if(dis_summ_disclaimer_txt !="")
	{
		disclaimer ="<br><table width='100%' border=0 cellpadding=0 cellspacing=0 align=center><tr><td>"+dis_summ_disclaimer_txt+"</td><tr></table>"
		data[3] = disclaimer;
	}
	
	
	var arguments = data;
	//retVal = window.showModalDialog("../../eCA/jsp/RecClinicalNotesPrint.jsp?accession_num="+accession_num+"&title="+encodeURIComponent(title,"UTF-8")+"&facility_id="+facility_id+"&patient_id="+encodeURIComponent(patient_id,"UTF-8")+"&encounter_id="+encounter_id+"&visit_adm_date="+visit_adm_date+"&discharge_date="+dischargeDateTime+"&speciality_name="+encodeURIComponent(specialty_name,"UTF-8")+"&location_code="+encodeURIComponent(locationDesc,"UTF-8")+"&performed_by_pract="+encodeURIComponent(performed_by_name,"UTF-8")+"&performing_phy_name="+encodeURIComponent(performed_by_name,"UTF-8")+"&event_title_desc="+encodeURIComponent(title,"UTF-8")+"&Sex="+encodeURIComponent(sex,"UTF-8")+"&age="+encodeURIComponent(patient_age,"UTF-8")+"&patient_class="+encodeURIComponent(patient_class,"UTF-8")+"&note_type_desc="+encodeURIComponent(title,"UTF-8")+"&event_date_time="+event_date_time+"&med_service="+encodeURIComponent(med_service,"UTF-8")+"&attending_practitioner="+encodeURIComponent(attend_pract,"UTF-8")+"&performed_date="+"&note_status="+"&printDateTime="+print_date_time+"&note_type="+encodeURIComponent(note_type,"UTF-8")+'&patient_name='+encodeURIComponent(patient_name,"UTF-8")+'&printDateTime='+print_date_time,arguments,features);//IN031538
		//[IN032721] retVal = window.showModalDialog("../../eCA/jsp/RecClinicalNotesPrint.jsp?accession_num="+accession_num+"&title="+encodeURIComponent(title,"UTF-8")+"&facility_id="+facility_id+"&patient_id="+encodeURIComponent(patient_id,"UTF-8")+"&encounter_id="+encounter_id+"&visit_adm_date="+visit_adm_date+"&discharge_date="+dischargeDateTime+"&speciality_name="+encodeURIComponent(specialty_name,"UTF-8")+"&location_code="+encodeURIComponent(locationDesc,"UTF-8")+"&performed_by_pract="+encodeURIComponent(performed_by_name,"UTF-8")+"&performing_phy_name="+encodeURIComponent(performed_by_name,"UTF-8")+"&event_title_desc="+encodeURIComponent(title,"UTF-8")+"&Sex="+encodeURIComponent(sex,"UTF-8")+"&age="+encodeURIComponent(patient_age,"UTF-8")+"&patient_class="+encodeURIComponent(patient_class,"UTF-8")+"&note_type_desc="+encodeURIComponent(title,"UTF-8")+"&event_date_time="+event_date_time+"&med_service="+encodeURIComponent(med_service,"UTF-8")+"&attending_practitioner="+encodeURIComponent(attend_pract,"UTF-8")+"&admitting_practitioner="+encodeURIComponent(admitting_practitioner,"UTF-8")+"&performed_date="+"&note_status="+"&printDateTime="+print_date_time+"&note_type="+encodeURIComponent(note_type,"UTF-8")+'&patient_name='+encodeURIComponent(patient_name,"UTF-8")+'&printDateTime='+print_date_time,arguments,features);//IN031538 
		retVal = await top.window.showModalDialog("../../eCA/jsp/RecClinicalNotesPrint.jsp?accession_num="+accession_num+"&contr_mod_accession_num="+contr_mod_accession_num+"&title="+encodeURIComponent(title,"UTF-8")+"&facility_id="+facility_id+"&patient_id="+encodeURIComponent(patient_id,"UTF-8")+"&encounter_id="+encounter_id+"&visit_adm_date="+visit_adm_date+"&discharge_date="+dischargeDateTime+"&speciality_name="+encodeURIComponent(specialty_name,"UTF-8")+"&location_code="+encodeURIComponent(locationDesc,"UTF-8")+"&performed_by_pract="+encodeURIComponent(performed_by_name,"UTF-8")+"&performing_phy_name="+encodeURIComponent(performed_by_name,"UTF-8")+"&event_title_desc="+encodeURIComponent(title,"UTF-8")+"&Sex="+encodeURIComponent(sex,"UTF-8")+"&age="+encodeURIComponent(patient_age,"UTF-8")+"&patient_class="+encodeURIComponent(patient_class,"UTF-8")+"&note_type_desc="+encodeURIComponent(title,"UTF-8")+"&event_date_time="+event_date_time+"&med_service="+encodeURIComponent(med_service,"UTF-8")+"&attending_practitioner="+encodeURIComponent(attend_pract,"UTF-8")+"&admitting_practitioner="+encodeURIComponent(admitting_practitioner,"UTF-8")+"&performed_date="+"&note_status="+"&printDateTime="+print_date_time+"&note_type="+encodeURIComponent(note_type,"UTF-8")+'&patient_name='+encodeURIComponent(patient_name,"UTF-8")+'&printDateTime='+print_date_time+'&ppFlag=N',arguments,features);//[IN032721]//Commented for IN064446
		//retVal = window.showModalDialog("../../eCA/jsp/RecClinicalNotesPrint.jsp?accession_num="+accession_num+"&contr_mod_accession_num="+contr_mod_accession_num+"&title="+encodeURIComponent(title,"UTF-8")+"&facility_id="+facility_id+"&patient_id="+encodeURIComponent(patient_id,"UTF-8")+"&encounter_id="+encounter_id+"&visit_adm_date="+visit_adm_date+"&discharge_date="+dischargeDateTime+"&speciality_name="+encodeURIComponent(specialty_name,"UTF-8")+"&location_code="+encodeURIComponent(locationDesc,"UTF-8")+"&performed_by_pract="+encodeURIComponent(performed_by_name,"UTF-8")+"&performing_phy_name="+encodeURIComponent(performed_by_name,"UTF-8")+"&event_title_desc="+encodeURIComponent(title,"UTF-8")+"&Sex="+encodeURIComponent(sex,"UTF-8")+"&age="+encodeURIComponent(patient_age,"UTF-8")+"&patient_class="+encodeURIComponent(patient_class,"UTF-8")+"&note_type_desc="+encodeURIComponent(title,"UTF-8")+"&event_date_time="+event_date_time+"&med_service="+encodeURIComponent(med_service,"UTF-8")+"&attending_practitioner="+encodeURIComponent(attend_pract,"UTF-8")+"&admitting_practitioner="+encodeURIComponent(admitting_practitioner,"UTF-8")+"&performed_date="+"&note_status="+"&printDateTime="+print_date_time+"&note_type="+encodeURIComponent(note_type,"UTF-8")+'&patient_name='+encodeURIComponent(patient_name,"UTF-8")+'&printDateTime='+print_date_time+'&data[0]='+data[0]+'&data[1]='+encodeURIComponent(data[1],"UTF-8")+'&data[2]='+encodeURIComponent(data[2],"UTF-8")+'&ppFlag=N',arguments,features);//modified for IN064446
}
//added for BRU-HIMS-CRF-356 [IN038643]
//IN042677
async function getSpecialty1(obj)
{
	if (obj.value != "") //IN043437
	{
		var oldValFlag = false;
		if(document.ClinicalNote.Splcode_desc_hid.value != document.ClinicalNote.specialty.value)
			oldValFlag = true;
			
		if(oldValFlag)
		{
			await getSpecialty();
		}
		else
		{	
			if(obj.value == "" || obj.value == null) {
			
				document.ClinicalNote.speciality_code.value = "";
				
			}	
		}
	}
	else
	{
		document.ClinicalNote.speciality_code.value = "";
		document.ClinicalNote.attend_pract_desc.value = ""; // MMS-QH-CRF-0177 [IN047572] 
		document.ClinicalNote.attend_pract_code.value = ""; // MMS-QH-CRF-0177 [IN047572] 
	}
}

async function getSpecialty()
{
		// MMS-QH-CRF-0177 [IN047572] - Start 
		document.ClinicalNote.attend_pract_desc.value = "";  
		document.ClinicalNote.attend_pract_code.value = ""; 
		// MMS-QH-CRF-0177 [IN047572] - End
		
		var target			= document.ClinicalNote.specialty.value;
		var stdval          = document.ClinicalNote.speciality_code.value;
		var facilityid      = document.ClinicalNote.facilityid.value;
		var locale			= document.ClinicalNote.locale.value;
       
		var retVal			= new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.Specialty.label","Common");
		
		var sql="select a.SPECIALITY_CODE code, a.SHORT_DESC description from AM_SPECIALITY_lang_vw  a where eff_status = 'E' and LANGUAGE_ID='"+locale+"'" ;
		sql = sql + " and upper(a.SPECIALITY_CODE) like upper(?) and upper(a.SHORT_DESC) like upper(?) order by 2";

		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retVal = await CommonLookup( title, argArray )
		var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if (retVal != null && retVal != '' && retVal != "null")
		{
		   	document.ClinicalNote.specialty.value = arr[1];
		   	document.ClinicalNote.speciality_code.value = arr[0];
			document.ClinicalNote.Splcode_desc_hid.value = document.ClinicalNote.specialty.value; // added for IN043437
			//IN042638 - Start
			if(arr[0] == "*ALL" || arr[0] == "ALL") {
				document.ClinicalNote.speciality_code.value = "";
			}
		}
		else
		{
			document.ClinicalNote.specialty.value = "";
			document.ClinicalNote.speciality_code.value = "";
			document.ClinicalNote.Splcode_desc_hid.value = ""; // added for IN043437
		} 
}
//ML-MMOH-CRF-0335 - IN057113
async function validatePintoPrint() {
	var retVal = 	new String();
	var dialogHeight= "9" ;
	var dialogWidth	= "25" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eCA/jsp/AuthorizePinAccess.jsp?"+"",arguments,features);
	if(retVal == undefined || retVal == 'undefined') retVal = "X";
	return retVal;
}
function disallowEnterKey()
{
	var keyVal = parseInt(event.keyCode);
	if(keyVal == 13)
		return false;
}
function chkpasswd() {
	var appl_pwd = document.Authorize_form.appl_user_passwd.value;
	var screen_pwd = document.Authorize_form.screen_passwd.value;
	
	if (appl_pwd != screen_pwd){
		alert(getMessage("PWD_MISMATCH","CA"));
		top.window.returnValue = "X" ;
		top.window.close();
	}else{
		top.window.returnValue = "T" ;
		top.window.close();
	}

}
function closeAuthorization(){
	top.window.returnValue = "X";
	top.window.close();
}
function isPinValidationReq(){
	var patient_id =  ''; 
	var order_id = '';
	var localeName = '';
	var accession_num	= document.forms[0].accession_num.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../eOR/jsp/PrintConfidentPinValidate.jsp?p_patient_id=" + patient_id +"&p_order_id="+order_id+"&p_validate=CONF_PIN_VALIDATE"+"&p_accession_num="+accession_num, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	responseText = responseText.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
	eval(responseText ) 
}
function isPinForPrintRequired(pinRequired) {
	isPrintPinValidationReq = pinRequired;
	
}
//ML-MMOH-CRF-0335 - IN057113
//[MMS-QH-CRF-0177] - Start
//[IN062196] - Start
function getPractitioner1(obj)
{	
	if (obj.value != "") 
	{
		var oldValFlag = false;
		if(document.ClinicalNote.practCode_desc_hid.value != document.ClinicalNote.attend_pract_desc.value)
			oldValFlag = true;
			
		if(oldValFlag)
		{
			getPractitioner();
		}
		else
		{	
			if(obj.value == "" || obj.value == null) {
			
				document.ClinicalNote.attend_pract_code.value = "";
				
			}	
		}
	}
	else
	{
		document.ClinicalNote.attend_pract_code.value = ""; 
	}
}
//[IN062196] - End
async function getPractitioner()
{
		var target			= document.ClinicalNote.attend_pract_desc;
		var locale			= document.ClinicalNote.locale.value;
		var spec_code		= document.ClinicalNote.speciality_code.value;
		
		var retVal			= new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.AttendingPractitioner.label","Common");
		
		var sql="select a.PRACTITIONER_ID code, a.SHORT_NAME description from am_practitioner_lang_vw  a where eff_status = 'E' and LANGUAGE_ID='"+locale+"'" ;
		if(spec_code == '' || spec_code == '*ALL' )
		{	
			sql = sql + " and upper(a.PRACTITIONER_ID) like upper(?) and upper(a.SHORT_NAME) like upper(?) order by 2";
		}
		else {
			sql = sql + " and PRIMARY_SPECIALITY_CODE like '"+spec_code+"' and upper(a.PRACTITIONER_ID) like upper(?) and upper(a.SHORT_NAME) like upper(?) order by 2";
		}
		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retVal = await CommonLookup( title, argArray )
		
		var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if (retVal != null && retVal != '' && retVal != "null")
		{
		   	document.ClinicalNote.attend_pract_desc.value = arr[1];
		   	document.ClinicalNote.attend_pract_code.value = arr[0];
			document.ClinicalNote.practCode_desc_hid.value = document.ClinicalNote.attend_pract_desc.value; //[IN062196]
			if(arr[0] == "*ALL" || arr[0] == "ALL") {
				document.ClinicalNote.attend_pract_code.value = "";
			}
		}
		else
		{
			document.ClinicalNote.attend_pract_desc.value = ""; 
			document.ClinicalNote.attend_pract_code.value = "";
			document.ClinicalNote.practCode_desc_hid.value = ""; //[IN062196]
		} 
}
// [MMS-QH-CRF-0177] - End
//IN051294 starts
function notetypeenable()
{
	document.forms[0].note_type_desc.disabled=false;
	document.forms[0].note_type_search.disabled=false;
}
//IN051294 ends	

