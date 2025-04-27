/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	created
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

18/10/2023     32902             Krishna Pranay    	     19/10/2023      Ramesh G      MMS-DM-CRF-0210	

----------------------------------------------------------------------------------------------------------------------------------------------------------
*/

function showCalendarValidate(str){
	
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}


/*function ftDateChecknew(from,to,obj,obj1)
	{
	
			if(CheckSystemDateLesser(obj,obj1)){ 
			if(doDateCheckAlert(from,to)==false) {
				alert(top.header.getMessage("TO_DT_GR_EQ_FM_DT","CA"));
				to.select();
				to.focus();
			  }
			} 

		}*/

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
			to.select();
			to.focus();
			return false;
		}
	
	}
}
/*function CheckSystemDateLesser(from,today) { //args objects 1st is this object & second is the date in dd/mm/yyyy
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
							//var msg =getCAMessage("DATE_GREATER_SYSDATE");
							var msg =getMessage("FROM_DATE_GREATER_SYSDATE","CA");	
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
}*/

async function calllookup(obj)
{
	//alert('in calllook up'+obj.name);
	/* new comm
		var retVal =    new String();
		var dialogHeight= "27.22" ;
		var dialogWidth = "44" ;
		var status = "no";
		var term_set = document.forms[0].code_set.value
		
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

		retVal = window.showModalDialog("PaintConsultationFrame.jsp?title=Diagonosis&mode=pat_search&p_diag_code=1&term_set="+term_set,arguments,features);
  */ //new comm ends
//new starts


	var dob = document.forms[0].dob.value;
	var age = document.forms[0].age.value;
	var sex = document.forms[0].sex1.value;
	var searchtext = ""//document.forms[0].diagprob_code.value;
	var practitioner_id = document.forms[0].Practitioner_Id.value;
	var term_set_id = document.forms[0].code_set.value;
	var Encounter_Id = document.forms[0].Encounter_Id.value;
	var speciality_code = document.forms[0].speciality_code.value;

	var p_auth_yn = "N";
	var retVal =    new String();
	var dialogHeight= "85vh" ;
	var dialogWidth = "55vw" ;
	var status = "no";
	var arguments = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	age='47';
	//alert("dob..."+dob+"...age.."+age+"..sex.."+sex+"..searchtext.."+searchtext+"..practitioner_id.."+practitioner_id+"..term_set_id.."+term_set_id+"..Encounter_Id...."+Encounter_Id+"...speciality_code..."+speciality_code);
	retVal = await window.showModalDialog("../../eMR/jsp/TermCodeSearchMainFrame.jsp?speciality_code="+speciality_code+"&term_set_id="+term_set_id+"&practitioner_id="+practitioner_id+"&termsetid="+term_set_id+"&Dob="+dob+"&Age="+age+"&Sex="+sex+"&Encounter_Id="+Encounter_Id,arguments,features);

//new ends

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

function CheckForNumber_Lnew(Objval) 
	{
        
		
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

function showSearch()
{
var fields;
var names;
var otherDiagYN = document.RelPatHistCriteriaForm.otherdiag.value;//IN053425
if(otherDiagYN == 'N'){//IN053425
fields = new Array (document.forms[0].from_date,
document.forms[0].to_date,document.forms[0].diag);

searchWordfields=new Array (document.forms[0].from_date,
document.forms[0].to_date,document.forms[0].docName);

names  = new Array (getLabel("Common.periodfrom.label","COMMON"),
getLabel("Common.periodto.label","COMMON"),
getLabel("Common.diagnosis.label","COMMON"));

searchWordnames  = new Array (getLabel("Common.periodfrom.label","COMMON"),
getLabel("Common.periodto.label","COMMON"),
getLabel("eCA.SearchWord.label","CA")); 
}//IN053425 Starts
else
{
	fields = new Array (document.forms[0].from_date,
document.forms[0].to_date,document.forms[0].code_set);

searchWordfields=new Array (document.forms[0].from_date,
document.forms[0].to_date,document.forms[0].docName);

names  = new Array (getLabel("Common.periodfrom.label","COMMON"),
getLabel("Common.periodto.label","COMMON"),
getLabel("Common.diagnosis.label","COMMON"));

searchWordnames  = new Array (getLabel("Common.periodfrom.label","COMMON"),
getLabel("Common.periodto.label","COMMON"),
getLabel("eCA.SearchWord.label","CA"));
}
//IN053425 Ends
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
var search_word = document.forms[0].docName.value
var note_type = document.forms[0].note_type_desc.value
	//alert(search_word);
	
//if(document.getElementById("byselect")[1].checked==false){
var bysel = document.querySelectorAll("input[name='byselect']");
if(!bysel[1].checked){
	if(checkFields( fields, names, parent.parent.messageFrame))	{
	
	parent.RelPatHistResultFrame.location.href="../../eCA/jsp/RelatedPatientHistResult.jsp?view="+view+"&spl="+spl+"&rest="+rest+"&from_date="+from_date+"&to_date="+to_date+"&diag="+diag+"&diag2="+diag2+"&diag3="+diag3+"&sex="+sex+"&status="+status+"&group="+group+"&b_year="+b_year+"&b_months="+b_months+"&b_days="+b_days+"&b_year2="+b_year2+"&b_months2="+b_months2+"&b_days2="+b_days2+"&patient_id="+patient_id+"&term_set_id="+term_set_id+"&otherdiag="+otherDiagYN;//IN053425

	}
}
else{
if(checkFields( searchWordfields, searchWordnames, parent.parent.messageFrame))
	{			

	parent.RelPatHistResultFrame.location.href="../../eCA/jsp/RelatedPatientNoteResult.jsp?view="+view+"&spl="+spl+"&rest="+rest+"&from_date="+from_date+"&to_date="+to_date+"&docName="+search_word+"&note_type="+note_type+"&sex="+sex+"&status="+status+"&group="+group+"&b_year="+b_year+"&b_months="+b_months+"&b_days="+b_days+"&b_year2="+b_year2+"&b_months2="+b_months2+"&b_days2="+b_days2+"&patient_id="+patient_id+"&term_set_id="+term_set_id;
}
	}


} 


function populateChart(fid,eid,patid)
	{
		//alert(fid);
 
//	alert('fid'+fid+'eid'+eid);


	
	var htmlVal = "<html><head></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'>"
		htmlVal += "<form name='frm_temp' id='frm_temp' method='post' action='../../eCA/jsp/RelatedPatientHistBookMark.jsp' target='messageFrame'>"
		htmlVal += "<input type='hidden' name='facilityid' id='facilityid' value='"+fid+"'>"
		htmlVal += "<input type='hidden' name='encounterid' id='encounterid' value='"+eid+"'>"
		htmlVal += "<input type='hidden' name='patientid' id='patientid' value='"+patid+"'>"
		htmlVal += "</form></body></html>"
		parent.parent.messageFrame.document.body.insertAdjacentHTML("afterbegin",htmlVal);
		parent.parent.messageFrame.document.frm_temp.submit();
}

async function populateDocument(accession_num)
	{
		 
		var dialogTop		=	"40" ;
		var dialogHeight	=	"33" ;
		var dialogWidth		=	"45" ;
		var status			=	"no";
		var arguments		=	"" ;
		var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=auto; status:" + status;
		//appl_task_id='DISCHARGE_SUMMARY'
		 await window.showModalDialog("../../eCA/jsp/RelatedPatientHistNoteDisplay.jsp?accession_num="+accession_num,arguments,features);


	
	
	}

async function callChart(encounter_id,patientid)
{

var dialogTop		=	"0" ;
var dialogHeight	=	"90vh" ;
var dialogWidth		=	"50vw" ;
var status			=	"no";
var arguments		=	"" ;
var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
//appl_task_id='DISCHARGE_SUMMARY'
await  window.showModalDialog("../../eCA/jsp/RelatedPatientHistNote.jsp?no_modal=N&appl_task_id=DISCHARGE_SUMMARY&group=1&cur_epi=Y&encounter_id="+encounter_id+"&patient_id="+patientid,arguments,features);//'WIDTH=150,HEIGHT=100');//



}

//function openHistory(encounter_id,patclass)//32902
function openHistory(encounter_id,patclass,i)//32902

{ 
	//32902 start
    var restPatientYN =document.getElementById("restPatientYN"+i).value;
    var accessRightsViewPatient =document.getElementById("accessRightsViewPatient").value;
    var pat_id =document.getElementById("patid"+i).value;
    if(pat_id !=="" && restPatientYN =="Y" && accessRightsViewPatient==0){
  	restrictOpenVIPPat(pat_id,restPatientYN,accessRightsViewPatient);
       return;
     } 
    //32902 end
    

	 document.chartForm.target = parent.parent.messageFrame.name;
	 document.chartForm.patient_class.value = patclass;
	 document.chartForm.encounter_id.value = encounter_id;
	 document.chartForm.episode_id.value = encounter_id;
	// alert('submtting');
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

function clearPage()
{
	
	parent.frames[1].location.href="../../eCommon/html/blank.html";
	document.getElementById("diagnosis").style='display';
	document.getElementById("SearchLabel").style.display='none';
	document.getElementById("SearchWord").style.display='none'
	document.getElementById("NoteLabel").style.display='none';
	document.getElementById("NoteField").style.display='none'
	document.RelPatHistCriteriaForm.otherdiag.value = "N";//IN053425
	document.forms[0].reset();
}


function populatediagDesc(id,obj)
	{
	//	alert(fid);

//	alert('fid'+fid+'eid'+eid);
    
   // alert('populatediagDesc');
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


async function showSpeciality()

{
	var target			= document.forms[0].spl_Desc;
	//var stdval          = document.forms[0].locVal.value;
	//var val				= document.forms[0].facilityid.value;
	//var pract_id		= document.forms[0].ca_practitioner_id.value;
	var retVal			=  new String();
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	var title			= getLabel("Common.speciality.label","COMMON");
	//var locale			= document.forms[0].locale.value;
	
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
		if(retArray != null && retArray !="")
		{
			var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}

			document.forms[0].spl.value = arr[0];
			document.forms[0].spl_Desc.value = arr[1];
											
		}
		else
		{
			document.forms[0].spl.value = "";
			document.forms[0].spl_Desc.value = "";
		}

}

async function getSpeciality(obj)
{
	if (obj.value!= "")
	{
		await showSpeciality();
	}
	else
	{
		document.forms[0].spl.value = "";
	}
}

function clearDiag(obj)

{
	//alert('val..'+obj.value);
	document.forms[0].diag.value=""; //searchdiag
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
			var selectedValue=document.getElementById("byselect").checked;			
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

function getnotetype(Object)
	{
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
	async function getnotetypes()
	{
	
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
		
		retArray = await CommonLookup( title, argArray );
		
		if(retArray != null && retArray !="")
		{
			var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			document.forms[0].note_type_desc.value=arr[1];
			document.forms[0].note_type.value=arr[0];			
		}
		else
		{
			document.forms[0].note_type_desc.value="";
			document.forms[0].note_type.value="";
			target.focus();
		}
		

	}
//IN053425 Starts	
function enableOtherDiag(obj)
{
	if(obj.checked==true) 
	{
		document.RelPatHistCriteriaForm.otherdiag.value = "Y";
	}
	else
	{
		document.RelPatHistCriteriaForm.otherdiag.value = "N";
	}
}
//IN053425 Ends

