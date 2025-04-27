function clearPage()
{	
	parent.frames[1].location.href="../../eCommon/html/blank.html";
	document.getElementById("diagnosis").style.display='inline';	
	document.forms[0].reset();
}

function showSearch()
{
	var fields;
	var names;

	fields = new Array (document.forms[0].from_date,
	document.forms[0].to_date,document.forms[0].resePatCategory,document.forms[0].reseCategoryFact);


	names  = new Array (getLabel("Common.periodfrom.label","COMMON"),
	getLabel("Common.periodto.label","COMMON"),
	getLabel("eCA.ResearchPatientCategory.label","ca_labels"),
	getLabel("eCA.ResearchCategoryFactor.label","ca_labels"));



	var view=document.forms[0].view.value
	var spl=document.forms[0].spl.value
	var rest=document.forms[0].rest.value
	var from_date=document.forms[0].from_date.value
	var to_date=document.forms[0].to_date.value
	var diag=document.forms[0].diag.value
	var diag2=document.forms[0].diag2.value
	var diag3=document.forms[0].diag3.value
	var b_year=document.forms[0].b_age.value
	var b_months=document.forms[0].b_months.value
	var b_days=document.forms[0].b_days.value
	var b_year2=document.forms[0].b_age2.value
	var b_months2=document.forms[0].b_months2.value
	var b_days2=document.forms[0].b_days2.value
	var sex=document.forms[0].sex.value
	var status=document.forms[0].status.value
	var group=document.forms[0].group.value
	var patient_id=document.forms[0].patient_id.value
	var term_set_id = document.forms[0].code_set.value
	var resePatcategory	= document.forms[0].resePatCategory.value
	var reseCategoryFact = document.forms[0].reseCategoryFact.value
	if(checkFields( fields, names, parent.parent.messageFrame))	{
		var accessValid='N';
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr += " practitionerId=\""+ document.forms[0].practitioner_Id.value + "\" ";
		xmlStr += " facilityId=\""+ rest + "\" ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") ;
		xmlHttp.open( "POST", "AccessRightForClinicalStudiesValidate.jsp", false );
		xmlHttp.send(xmlDoc) ;
		responseText = xmlHttp.responseText ;
		eval(responseText);
		if('Y'==accessValid){
			parent.ClinicalStudiesPatientListHistResultFrame.location.href="../../eCA/jsp/ClinicalStudiesPatientListHistResult.jsp?view="+view+"&spl="+spl+"&rest="+rest+"&from_date="+from_date+"&to_date="+to_date+"&diag="+diag+"&diag2="+diag2+"&diag3="+diag3+"&sex="+sex+"&status="+status+"&group="+group+"&b_year="+b_year+"&b_months="+b_months+"&b_days="+b_days+"&b_year2="+b_year2+"&b_months2="+b_months2+"&b_days2="+b_days2+"&patient_id="+patient_id+"&term_set_id="+term_set_id+"&resePatcategory="+resePatcategory+"&reseCategoryFact="+reseCategoryFact;
		}else{
			alert("You do not have access for this facility on this date.");
		}
	}
	
} 

function showCalendarValidate(str){
	
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}

function fromDateChecknew(from,format,locale)
{
	if(from.value !="")
	{
		if(isBeforeNow(from.value, format,locale))
				return true;
		else
		{
			if( from.name == "from_date")
			{
				alert(getMessage("FROM_DATE_GREATER_SYSDATE","CA"));
				document.forms[0].from_date.value = getCurrentDate("DMY",locale);
				return false;
			}
			else
			{
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
				document.forms[0].to_date.value = getCurrentDate("DMY",locale);
				return false;
			}
		}
	}
}

function toDateChecknew(from,to,format,locale)
{
	if(from.value !="" && to.value !="")
	{
		if(!isBefore(from.value, to.value, format, locale))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
			//to.select();
//			to.focus();
to.value="";
			return false;
		}
	
	}
}


async function calllookup(obj)
{
	
	var dob = document.forms[0].dob.value;
	var age = document.forms[0].age.value;
	var sex = document.forms[0].sex1.value;
	var searchtext = ""
	var practitioner_id = document.forms[0].practitioner_Id.value;
	var term_set_id = document.forms[0].code_set.value;
	var Encounter_Id = document.forms[0].Encounter_Id.value;
	var speciality_code = document.forms[0].speciality_code.value;

	var p_auth_yn = "N";
	var retVal =    new String();
	var dialogHeight= "80vh" ;
	var dialogWidth = "44vw" ;
	var status = "no";
	var arguments = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	age='47';
	retVal =await window.showModalDialog("../../eMR/jsp/TermCodeSearchMainFrame.jsp?speciality_code="+speciality_code+"&term_set_id="+term_set_id+"&practitioner_id="+practitioner_id+"&termsetid="+term_set_id+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&Encounter_Id="+Encounter_Id,arguments,features);

	if (retVal != null && retVal != '' && retVal != undefined)
	{
		populatediagDesc(retVal,obj)
	}
	else if (retVal == undefined)
	{
		if(obj.name == 'diag') document.forms[0].diag.value = '';
		else if (obj.name == 'diag2') document.forms[0].diag2.value = '';
		else if (obj.name == 'diag3') document.forms[0].diag3.value = '';
	}

}

function CheckForNumber_Lnew(Objval) {        
		
	val = Objval.value;
		
	if ( trimCheck(val) && isNaN(val) == false && val >=0)
  		return true;
	else
	{
		if ( val.length > 0 ) {
			
  			alert(getMessage("ONLY_NUMBER_ALLOWED","CA"));
			Objval.select();
  			Objval.focus();
  			return false;
  			
  		}
	}
}

function checkMonthnew(Obj)
{
	if( Obj.value  > 11) { 
		alert(getMessage("MONTHS_CHECK","Common"));
		Obj.focus(); 
		
	}
}

function checkDaysnew(Obj)
{	
	if( Obj.value  > 31) { 
		alert(getMessage("DAYS_CHECK","Common"));
		Obj.focus(); 
		
	}
}



function populateChart(fid,eid,patid){
		
	var htmlVal = "<html><head></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'>"
		htmlVal += "<form name='frm_temp' id='frm_temp' method='post' action='../../eCA/jsp/RelatedPatientHistBookMark.jsp' target='messageFrame'>"
		htmlVal += "<input type='hidden' name='facilityid' id='facilityid' value='"+fid+"'>"
		htmlVal += "<input type='hidden' name='encounterid' id='encounterid' value='"+eid+"'>"
		htmlVal += "<input type='hidden' name='patientid' id='patientid' value='"+patid+"'>"
		htmlVal += "</form></body></html>"
		parent.parent.messageFrame.document.body.insertAdjacentHTML("afterbegin",htmlVal);
		parent.parent.messageFrame.document.frm_temp.submit();
}

function populateDocument(accession_num){
		 
		var dialogTop		=	"40" ;
		var dialogHeight	=	"33" ;
		var dialogWidth		=	"45" ;
		var status			=	"no";
		var arguments		=	"" ;
		var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=auto; status:" + status;
		
		window.showModalDialog("../../eCA/jsp/RelatedPatientHistNoteDisplay.jsp?accession_num="+accession_num,arguments,features);
}

function callChart(encounter_id,patientid)
{

var dialogTop		=	"40" ;
var dialogHeight	=	"33" ;
var dialogWidth		=	"45" ;
var status			=	"no";
var arguments		=	"" ;
var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;

 window.showModalDialog("../../eCA/jsp/RelatedPatientHistNote.jsp?no_modal=N&appl_task_id=DISCHARGE_SUMMARY&group=1&cur_epi=Y&encounter_id="+encounter_id+"&patient_id="+patientid,arguments,features);//'WIDTH=150,HEIGHT=100');//



}

function openHistory(encounter_id,patclass)
{ 
	 document.chartForm.target = parent.parent.messageFrame.name;
	 document.chartForm.patient_class.value = patclass;
	 // IN037111 document.chartForm.encounter_id.value = encounter_id;
	// IN037111 document.chartForm.episode_id.value = encounter_id;
	 document.chartForm.patient_id.value =  encounter_id;  //IN037111
	 document.chartForm.submit();

 
}

async function showEncounterDeatils(Patient_Id,srl_no,diag_code,term_set_id)
{	
	
	var dialogHeight= "10" ;
	var dialogWidth = "37" ;
	var dialogTop = '100'
	var dialogHeight = '20'
	var status = "no";
	var features    = "dialogHeight:" + dialogHeight + ";dialogHeight:"+dialogHeight+";dialogTop:"+dialogTop+"; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("PatProblemEncDtlMain.jsp?Patient_Id="+Patient_Id+"&srl_no="+srl_no+"&diag_code="+diag_code+"&term_set_id="+term_set_id,arguments,features);
}




function populatediagDesc(id,obj)
	{
	
	var val = obj.name;
	var term_set_id = document.forms[0].code_set.value;
	
	var htmlVal = "<html><head></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'>"
		htmlVal += "<form name='frm_new' id='frm_new' method='post' action='../../eCA/jsp/RelatedPatientHistDiagDesc.jsp' target='messageFrame'>"
		htmlVal += "<input type='hidden' name='mode' id='mode' value='"+val+"'>"
	    htmlVal += "<input type='hidden' name='"+val+"' id='"+val+"' value='"+id+"'>"
	    htmlVal += "<input type='hidden' name='term_set_id' id='term_set_id' value='"+term_set_id+"'>"
		htmlVal += "</form></body></html>"
		parent.parent.messageFrame.document.body.insertAdjacentHTML("afterbegin",htmlVal);
		parent.parent.messageFrame.document.frm_new.submit();
}


function setValue(cat,field)
{
	if(cat != null || cat != '' || field != null || field != '' )
		eval("top.content.workAreaFrame.frames[0].document.forms[0]."+field+".value='"+cat+"' ");
	else
		eval("top.content.workAreaFrame.frames[0].document.forms[0]."+field+".value='' ");
}


async function showSpeciality(){
	var target			= document.forms[0].spl_Desc;
	var retVal			=  new String();
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	var title			= getLabel("Common.speciality.label","COMMON");
	
	var sql="SELECT SPECIALITY_CODE code,SHORT_DESC description FROM AM_SPECIALITY WHERE EFF_STATUS='E' and upper(SPECIALITY_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) ORDER BY SHORT_DESC";

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
							
	retArray =await CommonLookup( title, argArray );	
	
	var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			
	if(retArray != null && retArray !="")
	{

		document.forms[0].spl.value = arr[0];
		document.forms[0].spl_Desc.value = arr[1];
										
	}
	else
	{
		document.forms[0].spl.value = "";
		document.forms[0].spl_Desc.value = "";
	}

}

function getSpeciality(obj)
{
	if (obj.value!= "")
	{
		showSpeciality();
	}
	else
	{
		document.forms[0].spl.value = "";
	}
}

function clearDiag(obj){
	document.forms[0].diag.value=""; 
	document.forms[0].diag2.value="";
	document.forms[0].diag3.value="";
	if(!obj.value=="")
	{
		document.forms[0].searchdiag.disabled=false;
		document.forms[0].searchdiag2.disabled=false;
		document.forms[0].searchdiag3.disabled=false;
	}
	else
	{
		document.forms[0].searchdiag.disabled=true;
		document.forms[0].searchdiag2.disabled=true;
		document.forms[0].searchdiag3.disabled=true;
	}
	var patient_id = document.forms[0].patient_id.value;
	var facilityId = document.forms[0].facilityid.value;
	var encounter_id = document.forms[0].Encounter_Id.value;
	var term_set_id =obj.value;
	if(!patient_id==""&&!facilityId==""&&!encounter_id=="")
	{

		HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()' class=MESSAGE><form name='RelPatHistform' id='RelPatHistform' method='post' action='RelatedPatientHistIntermediate.jsp'><input type=hidden name='patient_id' id='patient_id' value='"+patient_id+"'><input type=hidden name='encounter_id' id='encounter_id' value='"+encounter_id+"'><input type=hidden name='facilityId' id='facilityId' value='"+facilityId+"'><input type=hidden name='term_set_id' id='term_set_id' value='"+term_set_id+"'></form></body></html>"
		top.content.messageFrame.document.write(HTMLVal);
		top.content.messageFrame.document.RelPatHistform.submit();
	}

}
function hideShowRowDoC(obj){		   
		var selectedValue=document.getElementById("byselect")[1].checked;			
		if(selectedValue==true){			
			document.getElementById("diagnosis").style.display='none';
			document.getElementById("SearchLabel").style.display='inline';
			document.getElementById("SearchWord").style.display='inline';
			document.getElementById("NoteLabel").style.display='inline';
			document.getElementById("NoteField").style.display='inline'
		}
		else{				
			document.getElementById("diagnosis").style.display='inline';
			document.getElementById("SearchLabel").style.display='none';
			document.getElementById("SearchWord").style.display='none'
			document.getElementById("NoteLabel").style.display='none';
			document.getElementById("NoteField").style.display='none'
	}
}

function getnotetype(Object){
	if(Object.name=='note_type_desc')
	{
		if((Object.value) == "null" || (Object.value ==""))
		{
				return false;			
		}
		else
		{
			getnotetypes();
		}
	}
	else if(Object.name=='note_type_search')
	{
		getnotetypes();
	}
}
function getnotetypes(){	
   		var target			= document.forms[0].note_type_desc;
		var retVal			=  new String();
		var dialogTop	= "40";
		var dialogHeight		= "10" ;
		var dialogWidth	= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc			= "";
		var title			= getLabel("Common.NoteType.label",'COMMON');	
		var locale			= document.forms[0].locale.value;
		var sql="Select note_type code, note_type_desc description from ca_note_type_lang_vw where upper(note_type_desc) like upper(?) and note_type like upper(?) and eff_status='E' and language_id = '"+locale+"' ";

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
		
		retArray = CommonLookup( title, argArray );
		
		if(retArray != null && retArray !="")
		{
			document.forms[0].note_type_desc.value=retArray[1];
			document.forms[0].note_type.value=retArray[0];			
		}
		else
		{
			document.forms[0].note_type_desc.value="";
			document.forms[0].note_type.value="";
			target.focus();
		}
}

//===================================================

function getReseaFactors(){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += " p_research_category=\""+ document.forms[0].resePatCategory.value + "\" ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") ;
	xmlHttp.open( "POST", "AccessRightForResearchStudiesValidate.jsp", false );
	xmlHttp.send(xmlDoc) ;
	responseText = xmlHttp.responseText ;
		eval(responseText);
}
function addResearchFactorsList(code,desc)
{
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = desc ;	
	eval("document.forms.ClinicalStudiesPatientListHistCriteriaForm.reseCategoryFact.add(element)");		
}
function clearResearchFactorsList() 
{
	eval("document.forms.ClinicalStudiesPatientListHistCriteriaForm.reseCategoryFact.length=0");
	var tp = getLabel("Common.defaultSelect.label","Common");
	var element = document.createElement('OPTION') ;
	element.value = "" ;
	element.text = "----------"+tp+"----------" ;	
	eval("document.forms.ClinicalStudiesPatientListHistCriteriaForm.reseCategoryFact.add(element)");		
} 

function showDetails(patient_id,facility_id,resePatcategory,reseCategoryFact,addedDate)
{
	var dialogTop		=	"0" ;
	var dialogHeight	=	"70vh" ;
	var dialogWidth		=	"45vw" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=auto; status:" + status;
	
	 window.showModalDialog("../../eCA/jsp/ClinicalStudiesPatientListHistDetails.jsp?patient_id="+patient_id+"&facility_id="+facility_id+"&resePatcategory="+resePatcategory+"&reseCategoryFact="+reseCategoryFact+"&addedDate="+encodeURIComponent(addedDate),arguments,features);
}
function showActiveDignosisDetails(patient_id,facility_id,local,term_set_id,diagnew1,diagnew2,diagnew3)
{
	var dialogTop		=	"0" ;
	var dialogHeight	=	"70vh" ;
	var dialogWidth		=	"45vw" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=auto; status:" + status;
	
	 window.showModalDialog("../../eCA/jsp/ClinStudPatActiveDiagnosisDetails.jsp?patient_id="+patient_id+"&facility_id="+facility_id+"&local="+local+"&term_set_id="+term_set_id+"&diagnew1="+diagnew1+"&diagnew2="+diagnew2+"&diagnew3="+diagnew3,arguments,features);
}
//==================================================

