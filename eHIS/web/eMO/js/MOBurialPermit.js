function CheckForSpecCharsLocal(event){
var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/';
var whichCode = (window.Event) ? event.which : event.keyCode;
key = String.fromCharCode(whichCode);  // Get key value from key code
if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
return true ;
}

function clearData()
{


parent.frames[2].document.location.href='../../eCommon/html/blank.html';
parent.frames[1].document.forms[0].search.disabled=false;

}

function PopulateValues(obj)
{
	
		
	var index=document.forms[0].clinic_code.options.selectedIndex;
	var care_ind;
	  if(index != 0)
		  care_ind=careArray[index];
	   else
		   care_ind="";
	 
	 document.forms[0].careind.value=care_ind;

	if(obj.value!="")
	{
		 
		var clinic_code=document.forms[0].clinic_code.value;
		var clinic_code1=document.forms[0].clinic_code1.value

		
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='clinicTempForm' id='clinicTempForm' method='post' action='../../eMO/jsp/MOPopulateClinicValues.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic_code+"'><input type='hidden' name='care_ind' id='care_ind' value='"+care_ind+"'><input type='hidden' name='clinic_code1' id='clinic_code1' value='"+clinic_code1+"'></form></body></html>";	
		parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[3].document.forms[0].submit();
	}
}

async function showPrevEncounter(patient_id)
{
var function_id=parent.document.forms[0].function_id.value;
var encounter_id=document.forms[0].encounter_id.value;
	var dialogWidth = "120" ;
	var	dialogHeight = "30";
	var dialogTop = "190" ;
	var status = "no";
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+" ; scroll=no; status:" + status;
     retVal = 
	await  window.showModalDialog("../../eMP/jsp/vwEncounterDetailFrames.jsp?function_id="+function_id+"&patientid="+patient_id+"&encounterID="+encounter_id,arguments,features);
}


async function viewPatientDetails(p_patient_id)
{var function_id=parent.document.forms[0].function_id.value;

	var title = getLabel("eMO.ViewDeceasedDtls.label","MO")  
	var dialogHeight= "41" ;
	var dialogWidth	= "65" ;
	var dialogTop="85";
	var dialogLeft="2";
	var prev="prev";
	var display="display";
	var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	await window.showModalDialog('../../eMP/jsp/ViewPatDetailsMain.jsp?function_id='+function_id+'&display='+display+'&Patient_ID='+p_patient_id,arguments,features);
}
function submitPage()
{
	
var patient_id = parent.frames[1].document.forms[0].patient_id.value;
var locn = parent.frames[1].document.forms[0].clinic_code.value;
var clinic_code1 = parent.frames[1].document.forms[0].clinic_code1.value;
dec_date_time= parent.frames[1].document.forms[0].dec_date_time.value;
dec_date_time1=parent.frames[1].document.forms[0].dec_date_time1.value;
var function_id=parent.document.forms[0].function_id.value;

if(dec_date_time=="")
	{
	    alert(getMessage('DATE_CANT_BE_BLANK','MO'));
		parent.frames[1].document.forms[0].search.disabled=false;
		return false 
	}
    if(dec_date_time1=="")
	{
	    alert(getMessage('DATE_CANT_BE_BLANK','MO'));
		parent.frames[1].document.forms[0].search.disabled=false;
		return false 
	}
if(doDateCheck(parent.frames[1].document.forms[0].dec_date_time,parent.frames[1].document.forms[0].dec_date_time1,parent.messageFrame)==
true) 
		{
 var dec_date_time11 = convertDate(parent.frames[1].document.forms[0].dec_date_time.value,"DMY",localeName,"en"); 
 var dec_date_time22 = convertDate(parent.frames[1].document.forms[0].dec_date_time1.value,"DMY",localeName,"en");
 parent.frames[2].location.href= "../jsp/MOBurialPermitQueryResult.jsp?function_id="+function_id+"&patient_id="+patient_id+"&locn="+locn+"&clinic_code1="+clinic_code1+"&dec_date_time="+dec_date_time11+"&dec_date_time1="+dec_date_time22;
}else
{
	
alert(getMessage('FRDT_LTEQ_TODT','IP'));
parent.frames[1].document.forms[0].search.disabled=false;
return false;
}
parent.frames[1].document.forms[0].search.disabled=true;


}

function reset()
{ 
if(frames[1].document.burialform!=null)
  {patientFrame.document.location.reload();
   frames[2].document.location.href='../../eCommon/html/blank.html';
 }else
	{
	result.document.location.reload();
	}
	/*var patient_id = f_query_add_mod.document.forms[0].patient_id.value;
    result.location.href = '../../eMO/jsp/MOBurialPermitSearch.jsp?param='+patient_id;
	searchPatient1(f_query_add_mod.document.forms[0].patient_id);*/
}

function searchPatient1(obj)
{
	if(obj.value!='')
	 { 
		 var patient_id		  = f_query_add_mod.document.forms[0].patient_id.value;
		 var mode    	      = 'query';
 		 var HTMLVal = "<HTML><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='valid_form' id='valid_form' method='post' action='../../eMO/jsp/MOBurialPermitValidations.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='mode' id='mode' value='"+mode+"'></form></BODY></HTML>";
		 messageFrame.document.write(HTMLVal);
		 messageFrame.valid_form.submit();
	 }
	 else
	 {
		f_query_add_mod.document.forms[0].patient_id.value	 = '';

	}
} 
function onSuccess()
{ 
	 alert(getMessage('RECORD_INSERTED','SM'));
	 parameter="menu_id=MO_MENU&module_id=MO&function_id=&function_name=Burial Permit &function_type=F&access=NNNNN" 
	top.content.document.getElementById("a").rows='*'
	top.content.location.href="../../eMO/jsp/MOBurialPermitFramset.jsp?"+parameter 

/*	f_query_add_mod.document.location.href='../../eMO/jsp/MOBurialPermitCriteria.jsp';
	result.location.href='../../eCommon/html/blank.html';
	patientLine.location.href='../../eCommon/html/blank.html';
 f_query_add_mod.document.forms[0].patient_id.disabled=false;*/
}
function calljsp(obj)
{
	var az;
	az = obj.value;

	if(az!='')
		{
		parent.f_query_add_mod.location.href = '../../eMO/jsp/MOrepBurialPermit.jsp?param='+az+'&first=N';
		}else
	{
	//obj.blur();
	//parent.f_query_add_mod.document.forms[0].patient_search1.click();
	}

}
function apply()
{
    var isRemoveMandBPermitAppBy = result.document.forms[0].isRemoveMandBPermitAppBy.value;//isRemoveMandBPermitAppBy logic Added by Dharma on 2oth July against ML-MMOH-CRF-0692 [IN:062311]
    
	if(f_query_add_mod.document.forms[0].patient_id.value=="")
	{
			var err = getMessage('CAN_NOT_BE_BLANK','Common');
			err = err.replace('$', getLabel("Common.patientId.label","Common"));
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+err ;
			return false;
	
	}
	if (result.document.forms[0].gen_burial_permit.value=='Y')
	{
	 	var fields = new Array();	 
		var i = 0;
		fields[i++] = result.document.forms[0].patient_id;
		if(isRemoveMandBPermitAppBy=="false"){
			fields[i++] = result.document.forms[0].burial_permit_app_by;
		}
		fields[i++] = result.document.forms[0].bpadate;
		var names = new Array (getLabel("Common.patientId.label","Common"),getLabel("eMO.BurialPermitApprovedBy.label","MO"),getLabel("eMO.BurialPermitApprovalDate.label","MO"));
	}
	else{ 
	var fields = new Array();	 
		var i= 0;
		fields[i++] = result.document.forms[0].patient_id;
		fields[i++] = result.document.forms[0].burial_permit_no;
		if(isRemoveMandBPermitAppBy=="false"){
			fields[i++] = result.document.forms[0].burial_permit_app_by;
		}
		fields[i++] = result.document.forms[0].bpadate;
		if(isRemoveMandBPermitAppBy=="false"){
	var names = new Array (getLabel("Common.patientId.label","Common"),getLabel("eMO.BurialPermitNumber.label","MO"),getLabel("eMO.BurialPermitApprovedBy.label","MO"),getLabel("eMO.BurialPermitApprovalDate.label","MO"));
		}else{
				var names = new Array (getLabel("Common.patientId.label","Common"),getLabel("eMO.BurialPermitNumber.label","MO"),getLabel("eMO.BurialPermitApprovalDate.label","MO"));
		}
	}
    if(result.checkFields( fields, names, messageFrame))
	{result.document.forms[0].burial_permit_no.disabled=false;
		result.document.forms[0].submit();
	}
}

function changeCase(obj)
{
	  obj.value=obj.value.toUpperCase();
}
    
function ChkDate(Object3) 
{
    var strDate;
    var strDay;
    var strMonth;
    var strYear;
    var datefield = Object3;
    var strDateArray = new Array();
    strDate = datefield.value;
    if (datefield.length == 0) return true;
	if(datefield.indexOf('.') > 0) return false;
    strDateArray = datefield.split("/");
    if (strDateArray.length != 3) 
	{
        return false;
    }
    else 
	{
        strDay = strDateArray[0];
        strMonth = strDateArray[1];
        strYear = strDateArray[2];
    }
    if (strYear.length < 4 || strYear.length > 4) return false;
    if (isNaN(strDay)==true) return false;
    if (isNaN(strMonth)==true) return false;
    if (isNaN(strYear)==true) return false;
    if (strYear < 1800) return false;
    if (strMonth>12 || strMonth<1)  return false;
	if ((strMonth == 1 || strMonth == 3 || strMonth == 5 || strMonth == 7 || strMonth == 8 || strMonth == 10 || strMonth == 12) && (strDay > 31 || strDay < 1)) return false;
    if ((strMonth == 4 || strMonth == 6 || strMonth == 9 || strMonth == 11) && (strDay > 30 || strDay < 1)) return false;
    if (strMonth == 2) {
    if (strDay < 1) return false;
    if (LeapYear(strYear) == true) 
	{
		if (strDay > 29) return false;
    }
    else 
	{
            if (strDay > 28) return false;
    }
  }
  return true;
}
/*function CheckDate(Object3,focusflag) 
{
  var aone=Object3.value;
  var date1 = aone.split(" ");
  var Object2 = date1[0];
  var datefield = Object3;
  if (ChkDate(Object2) == false) 
  {
	  
      alert(getMessage("INVALID_DATE_FMT",'SM'));
  	  document.forms[0].chkfor.value ='N';
	  if(focusflag == null)
      {
	     datefield.select();
         datefield.focus();
      }
      return false;
  }
  else 
  {
    return true;
  }
}*/

function ChkNumberIP(fld, e, deci)
{
	if (parseInt(deci)>0)
	   var strCheck = '.0123456789 /:';
	else
	   var strCheck = '0123456789 /:';
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) return true;  // Enter
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function CheckForNumber3(val) 
{
   if ( trimCheck(val) && isNaN(val) == false && val >=0)
        return true;
    else
        if ( val.length > 0 ) 
		{
           alert(getMessage("NUM_ALLOWED",'SM'));
		   val.focus();
           return false;
        }
}

function chkdattim(obj)
{
   if(document.forms[0].chkfor.value!='N')
  {
	  if(obj!='')
	  {
		  var from = document.forms[0].byrecddate.value;
		  var to = obj.value;
		  if(from!='')
		  {
			var a=  from.split(" ");
		    splitdate=a[0];
		    splittime=a[1];
			if(splittime!='')
			{
			    var splitdate1 =splitdate.split("/");
			    var splittime1= splittime.split(":");
				var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
				if(to!='')
				{
				     a=  to.split(" ");
					 splitdate=a[0];
					 splittime=a[1];
					 if(splittime!='')
					 {
					     splitdate1 =splitdate.split("/");
					     splittime1= splittime.split(":");
						 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));
						 if(Date.parse(to_date) < Date.parse(from_date))
						 {
							 
							alert(getMessage('DATE_CANT_BE_LT_RECEIPT','MO'));
							obj.focus();
						 }
					  }
				 }
			  }
	      }
		}
	  }
  }


function firstfocus()
{
	if(document.forms[0].first.value=='')
		document.forms[0].patient_id.focus();
}
	
function dtchk(obj)
{
  if(obj.value != '')
  {
	if ( CheckDate(obj) == false)
	{
		obj.select();
	}else
	{
	var fromdate = document.forms[0].bur_per_approve_datefrom.value;
	var todate =  obj.value;
	var dateArray = fromdate.split(" ");
	fromdate=dateArray[0];
	if(fromdate.length > 0 && todate.length > 0 ) 
	{
       fromarray = fromdate.split("/");
       toarray = todate.split("/");
       var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
       var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
       if(Date.parse(todt) < Date.parse(fromdt)) 
	   {
		   
	      alert(getMessage('FRDT_LTEQ_TODT','IP'));
	  	  obj.focus();
		  obj.select();
		}
	}
   }
  }
}

/*function chkman(obj)
{
	if(obj.value!='')
	{
	  var patient_id=document.forms[0].patient_id.value;
	  parent.result.location.href = '../../eMO/jsp/MOBurialPermitSearch.jsp?param='+patient_id ;
	}
	else{
		parent.result.location.href='../../eCommon/html/blank.html'
	}*/
	/*var namey;
	namey =obj.value;
	

	if(namey=='')
	{
       parent.result.location.href='../../eCommon/html/blank.html'
	}
	else if(namey!='')
	{
		
		parent.result.location.href='../../eCommon/html/blank.html'
		HTMLVal = "<html><body><form name='dum_form3' id='dum_form3' method='post' action='../../eMO/jsp/GetClaim.jsp?criteria=frmbury'><input type='hidden' name='patient_id' id='patient_id' value='"+namey+"'></form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.dum_form3.submit();
		// parent.result.location.href = '../../eMO/jsp/MOBurialPermitSearch.jsp?param=<%=patient_id%>&first=N';
		//parent.f_query_add_mod.location.href = '../../eMO/jsp/MOBurialPermitSearch.jsp?param='+namey+'&first=N';
	}*/
//}


/******** Added New **********/


/*function callpatientsearch()
{
	var patientid = PatientSearch('','','','','','','Y','','N','MO');
	if(patientid!=null)
	{
	 document.getElementById("patient_id").value = patientid;
	 document.getElementById("patient_id").focus();
	}
	else
	{
		document.getElementById("patient_id").value = "";

	}
}*/


function searchPatient(obj)
{
	if(obj.value!='')
	 { 
		parent.frames[1].document.forms[0].patient_id.value=obj.value ;
        parent.patientLine.location.href='../../eCommon/jsp/pline.jsp?Patient_Id='+obj.value;
        parent.result.location.href = '../../eMO/jsp/MOBurialPermitSearch.jsp?function_id=MO_BURIAL_PERMIT&param='+obj.value;
	    parent.frames[4].location.href='../../eCommon/jsp/error.jsp?err_value=0';
		/*document.forms[0].patient_id.disabled=true;
		 var patient_id		  = document.forms[0].patient_id.value;
		 var mode    	      = document.forms[0].mode.value;
		 var HTMLVal = "<HTML><BODY><form name='valid_form' id='valid_form' method='post' action='../../eMO/jsp/MOBurialPermitValidations.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='mode' id='mode' value='"+mode+"'></form></BODY></HTML>";
		 parent.messageFrame.document.write(HTMLVal);
		 parent.messageFrame.valid_form.submit();*/
	 }
	 else
	 {
		document.forms[0].patient_id.value	 = '';

	}
} 

function beforeGetPractitioner(obj,target_name)
{
	document.forms[0].bpadate.focus();

	target_name.value = trimString(target_name.value);
		 if(target_name.value == "")
			{
			 document.forms[0].burial_permit_app_desc.value="";
			 document.forms[0].burial_permit_app_by.value="";
			 return;
			}
			searchCode(obj,target_name)
}

async function searchCode(obj,target)
{
	var sql="";
	var sqlSecond="";
	var facilityid = document.forms[0].facilityId.value;
	var tit="";
	var practitionerName="";
	var practitionerValue="";
		
	target.value=trimString(target.value);

	if(target.value=="" && window.event.target == target)
		return;
	
	var argumentArray=new Array(8);

	//sql="select practitioner_id, practitioner_name, pract_type_desc practitioner_type, decode(job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',job_title) job_title, gender, primary_splty_short_desc primary_specialty from am_practitioner_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and (upper(practitioner_id) like upper(nvl(?,practitioner_id)) or upper(practitioner_name) like upper(nvl(?,practitioner_name))) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(job_title,'123')) like upper(nvl(?,nvl(job_title,'123'))) order by 2 ";

	//sqlSecond="select practitioner_id, practitioner_name, pract_type_desc practitioner_type, decode(job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',job_title) job_title, gender, primary_splty_short_desc primary_specialty from am_practitioner_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and upper(practitioner_id) like upper(nvl(?,practitioner_id)) and upper(practitioner_name) like upper(nvl(?,practitioner_name)) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(job_title,'123')) like upper(nvl(?,nvl(job_title,'123'))) order by 2 ";


	sql="select practitioner_id, practitioner_name, pract_type_desc practitioner_type, position_code job_title, gender, PRIMARY_SPECIALITY_DESC primary_specialty from am_practitioner_lang_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and (upper(practitioner_id) like upper(nvl(?,practitioner_id)) or upper(practitioner_name) like upper(nvl(?,practitioner_name))) and gender like nvl(upper(?), gender) AND  upper(nvl(position_code, '123')) like upper(nvl(?, nvl(position_code, '123'))) and language_id = '"+localeName+"' order by 2 ";

	sqlSecond="select practitioner_id, practitioner_name, pract_type_desc practitioner_type, position_code job_title, gender, PRIMARY_SPECIALITY_DESC primary_specialty from am_practitioner_lang_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and upper(practitioner_id) like upper(nvl(?,practitioner_id)) and upper(practitioner_name) like upper(nvl(?,practitioner_name)) and gender like nvl(upper(?), gender) AND  upper(nvl(position_code, '123')) like upper(nvl(?, nvl(position_code, '123'))) and language_id = '"+localeName+"' order by 2 ";
				
	practitionerName=target.name;
	practitionerValue=target.value;
				
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" + practitionerName + "\""	;
	xmlStr += " practName_FValue=\"" + practitionerValue + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sqlSecond)+ "\"";
	xmlStr += " specialty_code=\"" + "" + "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";

	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	//eval(responseText);
	eval(practSearch(practitionerName,practitionerName,responseText));
				
	return;            
	
	var retVal=await CommonLookup(tit,argumentArray);

	if(retVal==null || retVal=="")
		target.value="";
	else
		target.value=retVal[0];
		            
}
//anbu
async function practSearch(practitionerName,practitionerName,responseText) {
	var retVal = 	new String();
	var dialogTop = "10px" ;
	var dialogHeight= "510px" ;
	var dialogWidth	= "878px" ;
		
	if(responseText =="true") {        	
	    dialogWidth="70.5";
	}
	
	var status = "no";
	var arguments	= "" ;
	var tit="Pract Search";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var sqlArray= new Array();
	//var objName="<%=practName_FName%>";
	var objName=practitionerName;
    arguments='';
	
	//retVal = window.showModalDialog("<%=request.getContextPath()%>/eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+"<%=practName_FValue%>"+"&practitioner_type="+"<%=practitioner_type%>"+"&primary_specialty="+"<%=specialty_code%>"+"&job_title="+"<%=job_title%>"+"&gender="+"<%=gender%>",arguments,features);
	
	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practitionerName+"&practitioner_type="+"\""+"&job_title="+"\""+"&gender="+"\"",arguments,features);
	PractLookupRetVal(retVal,objName);
}
//

function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null && retVal != ""  && retVal != 'undefined')
	{
		arr=retVal.split("~");
		if(objName=="burial_permit_app_desc")
		{
		   document.forms[0].burial_permit_app_by.value=arr[0];
		   document.forms[0].burial_permit_app_desc.value=arr[1];
		}
		if(objName=="burial_permit_app_by")
		{
		   document.forms[0].burial_permit_app_by.value=arr[0];
		   document.forms[0].burial_permit_app_desc.value=arr[1];
		}
	}
	else{
		document.forms[0].burial_permit_app_by.value='';
		document.forms[0].burial_permit_app_desc.value='';
	}
}




function showAllowOper(patientID,burilno)
{

parent.document.getElementById("b").rows='*' 
parameter="menu_id=MO_MENU&module_id=MO&function_id=MO_BURIAL_PERMIT&function_name=Burial Permit &function_type=F&access=NYYNN" 
top.content.location.href = "../../eMO/jsp/MOBurialPermit.jsp?"+parameter+"&patientID="+patientID ;  

}
function  burialNoValid(obj)
{
	if(obj.value!='')
	 { 
		 var patient_id		  = document.forms[0].patient_id.value;
		 var burial_permit_no = document.forms[0].burial_permit_no.value;
		 
		 var BurialFlag ="Y";
		 var HTMLVal = "<HTML><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='valid_form' id='valid_form' method='post' action='../../eMO/jsp/MOBurialPermitValidations.jsp'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='burial_permit_no' id='burial_permit_no' value='"+burial_permit_no+"'><input type='hidden' name='BurialFlag' id='BurialFlag' value='"+BurialFlag+"'></form></BODY></HTML>";
		 parent.messageFrame.document.write(HTMLVal);
		 parent.messageFrame.valid_form.submit();

	 }
}

// The following function called on click of the create button for create mode 
function create()
{ 
}


// The following function called on click of the query button for query mode 
function query()
 {   
	 parameter="menu_id=MO_MENU&module_id=MO&function_id=&function_name=Burial Permit &function_type=F&access=NNNNN" 
	top.content.document.getElementById("a").rows='*'
	top.content.location.href="../../eMO/jsp/MOBurialPermitFramset.jsp?"+parameter 

	 /* parent.frames[2].frames[0].document.forms[0].reset.disabled=false;
	 f_query_add_mod.location.href ="../../eMO/jsp/MOBurialPermitCriteriaPage.jsp" ;
	 patientLine.location.href='../../eCommon/html/blank.html';
     result.location.href='../../eCommon/html/blank.html';
     messageFrame.location.href='../../eCommon/jsp/error.jsp?err_value=0';*/
 }

async function searchCode1(obj,target)
{
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var retVal =    new String();
	var argumentArray=new Array(8);
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var fieldLegend = new Array() ;
	 fieldLegend["CODE_LEGEND"] = getLabel("Common.patientId.label","Common");
	 fieldLegend["DESC_LEGEND"] = getLabel("Common.PatientName.label","Common");
	var tit="";				
	var facilityId = "";
	facilityId = document.forms[0].facilityId.value;
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';

	tit=getLabel("eMO.DeceasedPatients.label","MO");  
	sql="select patient_id code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_encounter_dtls_vw where facility_id='"+facilityId+"' and MLC_YN='N' and regn_allowed_in_mo_yn='Y' and patient_id not in (select NVL(patient_id,'*') from mo_mortuary_regn) and patient_id not in (select NVL(patient_id,'*') from mo_burial_permit) and upper(PATIENT_ID) like upper(?) and upper(patient_name) like upper(?) order by patient_name";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	argumentArray[8] = fieldLegend ;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		var arr=ret1.split(",");
		if(target.name == 'patient_id')
			document.forms[0].patient_id.value= arr[0];
			document.forms[0].patient_id.focus();
	}
	else
	{	
		document.forms[0].patient_id.value= "";
	}
}
async function searchCode3(obj,target)
{
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code=""; 
	var search_desc="";
	var retVal =    new String();
	var argumentArray=new Array(8);
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	var facilityId = "";
	var fieldLegend = new Array() ;
	fieldLegend["CODE_LEGEND"] = getLabel("Common.patientId.label","Common");
	fieldLegend["DESC_LEGEND"] = getLabel("Common.PatientName.label","Common");
	
	facilityId = document.forms[0].facilityId.value;
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';

	tit=getLabel("eMO.DeceasedPatients.label","MO");  
	sql="select patient_id code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_burial_permit_vw where facility_id='"+facilityId+"' and patient_id not in (select NVL(patient_id,'*') from mo_mortuary_regn) and upper(PATIENT_ID) like upper(?) and upper(patient_name) like upper(?) order by patient_name";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	argumentArray[8] = fieldLegend ;
	
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		var arr=ret1.split(",");
		if(target.name == 'patient_id')
			document.forms[0].patient_id.value= arr[0];
			document.forms[0].patient_id.focus();
	}
	else
	{	
		document.forms[0].patient_id.value= "";
	}
}
async function searchCode2(obj,target)
{
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var retVal =    new String();
	var argumentArray=new Array(8);
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	var facilityId = "";
	var fieldLegend = new Array() ;
	fieldLegend["CODE_LEGEND"] = getLabel("eMO.BurialPermitNumber.label","MO"); 
	fieldLegend["DESC_LEGEND"] = getLabel("Common.PatientName.label","Common");
	
	facilityId = document.forms[0].facilityId.value;
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';

	tit=getLabel("eMO.BurialPermitNumber.label","MO"); 
	sql="select burial_permit_no code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Description from mo_burial_permit_vw where facility_id='"+facilityId+"' and upper(burial_permit_no) like upper(?) and upper(patient_name) like upper(?) and patient_id not in(select NVL(patient_id,'*') patient_id from mo_mortuary_regn)  order by patient_name";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	argumentArray[8] =  fieldLegend;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		var arr=ret1.split(",");
		if(target.name == 'burial_permit_no')
			document.forms[0].burial_permit_no.value= arr[0];
			document.forms[0].burial_permit_no.focus();
	}
	else
	{	
		document.forms[0].burial_permit_no.value= "";
	}
}
/*function cmpdate(obj)
{
	if (obj.value!='')
	{

		val1=obj.value.length	

  if(val1<16)
		{
	  
			alert(getMessage('INVALID_DATE_FMT','SM'));
			obj.focus();
			return false;
		}
	if(doDateTimeChk(obj)==false)
	{
			alert(getMessage('INVALID_DATE_FMT','SM'));
			obj.focus();
			return false;
	}
	
	from	= document.forms[0].deceased_date.value;
	to		= obj.value;

	var a=  from.split(" ")
	splitdate=a[0];
	splittime=a[1]
	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")
    var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
    a=  to.split(" ")
	splitdate=a[0];
	splittime=a[1]

	splitdate1 =a[0].split("/")
	splittime1= a[1].split(":")
    var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
    if(Date.parse(to_date) < Date.parse(from_date))
	{
		alert(getMessage('CANT_BE_LT_DECEASED_DATE','MO'));
		obj.select();
		obj.value="";
		obj.focus();
	 }
	}
  }*/


async function callpatientsearch(obj,facilityId,target)
{
	if(obj.name=='burialno_search')
	{
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var retVal =    new String();
	var argumentArray=new Array(8);   
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("eMO.BurialPermit.label","MO");		
	
	var fieldLegend = new Array() ;
	fieldLegend["CODE_LEGEND"] = getLabel("eMO.BurialPermitNumber.label","MO"); 
	fieldLegend["DESC_LEGEND"] = getLabel("Common.patientId.label","Common");

	sql="select BURIAL_PERMIT_NO code,PATIENT_ID Description from MO_BURIAL_PERMIT_VW where  facility_id='"+facilityId+"' and PATIENT_ID not in (select NVL(PATIENT_ID,'*') from mo_mortuary_regn) and patient_id in (select NVL(patient_id,'*') from mo_encounter_dtls_vw where REGN_ALLOWED_IN_MO_YN='Y') and upper(BURIAL_PERMIT_NO) like upper(?) and upper(PATIENT_ID) like upper(?) order by 2";
	
	
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	argumentArray[8] =fieldLegend
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		var arr=ret1.split(",");
	    
	  target.value=arr[0];
	document.forms[0].patient_id.value=arr[1]	
	target.focus();
	}
	
	
	
	
	
	
	}else
	{

	
	var patientid = await PatientSearch('','','','','','','Y','','N','MO');
	if(patientid!=null)
	{
	 document.getElementById("patient_id").value = patientid;
	 document.getElementById("patient_id").focus();
	}
	else
	{
		document.getElementById("patient_id").value = "";

	}
	}
}
function clear()
{
	parent.frames[2].frames[1].document.forms[0].reset();
    parent.frames[2].frames[3].location.href = "../../eCommon/html/blank.html" ;
	parent.frames[2].frames[4].location.href="../../eCommon/jsp/error.jsp" ;  
	parent.frames[2].frames[0].document.forms[0].reset.disabled=false;
	parent.frames[2].frames[1].document.forms[0].search.disabled = false; 
}

function dtchk1(obj)
{
  if(obj.value != '')
  {
	if ( CheckDate(obj) == false)
	{
		obj.select();
		return false;
	}else
	{
	var fromdate = f_query_add_mod.document.forms[0].bur_per_approve_datefrom.value;
	var todate =  obj.value;
	var dateArray = fromdate.split(" ");
	fromdate=dateArray[0];
	if(fromdate.length > 0 && todate.length > 0 ) 
	{
       fromarray = fromdate.split("/");
       toarray = todate.split("/");
       var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
       var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
       if(Date.parse(todt) < Date.parse(fromdt)) 
	   {
		  alert(getMessage('FRDT_LTEQ_TODT','IP'));
	  	  obj.focus();
		  obj.select();
		  return false;
		}
		else{
		return true;
		}
	}
   }
  }
}

/*function  callSearch(patient_id,burial_permit_no,bur_per_approve_datefrom,bur_per_approve_dateto,burial_permit_app_by,messageFrame)
{
	/*if(trimCheck(patient_id.value)==false  &&  trimCheck(burial_permit_no.value)==false)
	{ 
		var msg='MO_PATID_PER_NO_BLANK';
		patient_id.focus();
		messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num='+msg;
		return false;
	}
	else
	{
		messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num=';

	}
//	messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num=';
	var fields    = new Array (f_query_add_mod.document.forms[0].patient_id,
		    f_query_add_mod.document.forms[0].burial_permit_no);
	var names     = new Array ("Patient ID","Burial Permit No");	
	var error_jsp ="../../eCommon/jsp/error.jsp";
	var flag = true;
	var sql_query = constructQuery(patient_id,burial_permit_no,bur_per_approve_datefrom,bur_per_approve_dateto,burial_permit_app_by);
	if(SpecialCharCheck(fields,names,messageFrame,"M",error_jsp))
	{
		if (f_query_add_mod.document.forms[0].bur_per_approve_dateto.value!='' && f_query_add_mod.document.forms[0].bur_per_approve_datefrom.value !='')
		{
	         var flag =dtchk1(f_query_add_mod.document.forms[0].bur_per_approve_dateto);
        }
        if(flag){
		f_query_add_mod.document.forms[0].search.disabled = true; 
		parent.frames[2].frames[3].location.href='../../eMO/jsp/MOBurialPermitResultPage.jsp?patient_id='+escape(patient_id.value)+'&sql_query='+sql_query+'&burial_permit_no'+escape(burial_permit_no.value)+'&burial_permit_app_by'+escape(burial_permit_app_by.value);
		}else{		
			return false;
	    }
	}
	else
	{		
			return false;
	}
	
}*/

function constructQuery(patient_id,burial_permit_no,bur_per_approve_datefrom,bur_per_approve_dateto,burial_permit_app_by)
{
	var sql_query=' ';
    var andCheck	=	0;            
	if(!(trimCheck(patient_id.value) == false)	)
	{
		sql_query	=' and patient_id ='+'\''+escape(patient_id.value)+'\'';
		andCheck	=	1;
	} 
	if(! (trimCheck(burial_permit_no.value) ==false)	)
	{
			if(andCheck == 1)
			sql_query =sql_query + ' and burial_permit_no='+'\''+escape(burial_permit_no.value)+'\'';
			else
            sql_query	=' and burial_permit_no='+'\''+escape(burial_permit_no.value)+'\'';
	
	}
	if(!(trimCheck(burial_permit_app_by.value) == false)	)
	{
			if(andCheck == 1)
			sql_query	=sql_query + ' and burial_permit_approved_by = ' +'\''+escape(burial_permit_app_by.value)+'\' ';
			else
            sql_query	=' and burial_permit_approved_by = ' +'\''+escape(burial_permit_app_by.value)+'\' ';
	}
	if( (trimCheck(bur_per_approve_datefrom.value) == true) && (trimCheck(bur_per_approve_dateto.value) == true ) )
	{
			
			sql_query	= sql_query + '	and trunc(to_date(burial_permit_approved_date,\'dd/mm/yyyy\hh24:mi\'))  between to_date(\''+bur_per_approve_datefrom.value +'\',\'dd/mm/yyyy \') and to_date(\''+bur_per_approve_dateto.value +'\',\'dd/mm/yyyy \') ';
	}
	else if((trimCheck(bur_per_approve_datefrom.value)== true))
	{
			//sql_query = sql_query + ' and trunc(to_date(burial_permit_approved_date,\'dd/mm/yyyy\hh24:mi\'))  =to_date(\''+bur_per_approve_datefrom.value +'\',\'dd/mm/yyyy \')';

			sql_query	= sql_query + '	and trunc(to_date(burial_permit_approved_date,\'dd/mm/yyyy\hh24:mi\'))  between to_date(\''+bur_per_approve_datefrom.value +'\',\'dd/mm/yyyy \') and to_date(\''+f_query_add_mod.document.forms[0].sys_date.value +'\',\'dd/mm/yyyy \') ';
	}
	else if( (trimCheck(bur_per_approve_dateto.value) == true) )
	{
			//sql_query = sql_query + ' and  trunc(to_date(burial_permit_approved_date,\'dd/mm/yyyy hh24:mi\')) =to_date(\''+bur_per_approve_dateto.value +'\',\'dd/mm/yyyy \')';

			sql_query	= sql_query + '	and trunc(to_date(burial_permit_approved_date,\'dd/mm/yyyy\hh24:mi\'))  between to_date(\'01/01/1900\',\'dd/mm/yyyy \') and  to_date(\''+bur_per_approve_dateto.value +'\',\'dd/mm/yyyy \') ';
	}
	else if( (trimCheck(bur_per_approve_datefrom.value) == false) &&  (trimCheck(bur_per_approve_dateto.value) == false))
	{
		    sql_query	= sql_query + '	and trunc(to_date(burial_permit_approved_date,\'dd/mm/yyyy\hh24:mi\'))  between to_date(\'01/01/1900\',\'dd/mm/yyyy \') and to_date(\''+f_query_add_mod.document.forms[0].sys_date.value +'\',\'dd/mm/yyyy \') ';
	}
	else if( (trimCheck(bur_per_approve_datefrom.value) == false))
	{
		    sql_query	= sql_query + '	and trunc(to_date(burial_permit_approved_date,\'dd/mm/yyyy\hh24:mi\'))  between to_date(\'01/01/1900\',\'dd/mm/yyyy \') and to_date(\''+f_query_add_mod.document.forms[0].sys_date.value +'\',\'dd/mm/yyyy \') ';
	}
	else if( (trimCheck(bur_per_approve_dateto.value) == false) )
	{
			sql_query = sql_query + ' and  trunc(to_date(burial_permit_approved_date,\'dd/mm/yyyy hh24:mi\')) =to_date(\''+f_query_add_mod.document.forms[0].sys_date.value +'\',\'dd/mm/yyyy \')';
	}
	//else {}
	return sql_query;   
		
}


function  callpage(patient_id,burial_permit_no)
	{
	  var query_string		=	"patient_id="+patient_id+"&burial_permit_no="+burial_permit_no+"&mode=query";

	  parent.frames[0].document.forms[0].apply.disabled=false;
	  parent.frames[0].document.forms[0].reset.disabled=false;
      parent.frames[1].location.href ="../../eMO/jsp/MOBurialPermitCriteria.jsp?mode=query&"+query_string; 
	  parent.frames[2].location.href='../../eCommon/html/blank.html';
      parent.frames[3].location.href='../../eCommon/html/blank.html';
      parent.frames[4].location.href='../../eCommon/jsp/error.jsp?err_value=0';
 }	
 

function dtchk2(obj)
	{
		var deceased_dt	= document.forms[0].deceased_date.value;
		var fromFormDate = convertDate(obj.value,"DMYHM",localeName,"en");
		if(obj.value != '')
	    {
			if(!validDateObj(obj,'DMYHM',localeName))
			{
				obj.select();
			}
			else
			{
				if((!isBeforeNow(obj.value,'DMYHM',localeName)))
				{
					alert(getMessage("DATE_NOT_GREATER_SYSDATE",'Common'));
					obj.select();
					return false;
				}
				if((!isBefore(deceased_dt,fromFormDate,'DMYHM',localeName)))
				{       
					alert(getMessage('CANT_BE_LT_DECEASED_DATE','MO'));
					obj.select();
					return false;
				}
                
			}
		}
	}

function genBurialPerNo(obj)
{
 if (obj.checked == true)
	{
		document.forms[0].gen_burial_permit.value='Y';
		document.forms[0].burial_permit_no.disabled=true;
		document.forms[0].burial_permit_no.value="";
		document.getElementById("mand2").style.visibility="hidden";
	}
	else if (obj.checked == false)
	{
		document.forms[0].gen_burial_permit.value='N';
		document.forms[0].burial_permit_no.disabled=false;
		document.getElementById("mand2").style.visibility="visible";
	}
}

/*function CheckDateBurPermit(obj1,obj2){
	var locale=document.forms[0].locale.value
		if(!validDateObj(obj1,'DMY',localeName))
		{
			//obj1.select();
		}else{
			alert('32')
			mochckdate(obj1,obj2);
		}
		if(!validDateObj(obj2,'DMY',localeName))
		{
			obj2.select();
		}
		if(!(isBeforeNow(obj1.value,"DMY",localeName))){
			alert(getMessage('NOSHOW_FM_DT_VALIDATION','IP'));
			obj1.select();
			return false;
		}
		if(!(isBeforeNow(obj2.value,"DMY",localeName))){
			alert(getMessage('NOSHOW_FM_DT_VALIDATION','IP'));
			obj2.select();
			return false;
		}
			

}
	function mochckdate(obj1,obj2){
		alert(obj1.value)
		if(obj1.value!='' && obj2.value!=''){
			if(!(isBefore(obj1.value,obj2.value,"DMY",localeName)))
				alert(getMessage('TO_DT_GR_EQ_FM_DT','SM'));
		}
	}*/

	function CheckDateBurPermit(obj1,obj2){
		if(!validDateObj(obj1,'DMY',localeName))
		{
			obj1.select();
		}else{
		if(!(isBeforeNow(obj1.value,"DMY",localeName))){
			alert(getMessage('DATE_NOT_GREATER_SYSDATE','COMMON'));
			obj1.select();
			return false;
		}else{
			mochckdate(obj1,obj2);
		}
		}


	}

	function todatecheck(obj1,obj2){
		if(!validDateObj(obj2,'DMY',localeName))
		{
			obj2.select();
		}else{
		if(!(isBeforeNow(obj2.value,"DMY",localeName))){
			alert(getMessage('DATE_NOT_GREATER_SYSDATE','COMMON'));
			obj2.select();
			return false;
		}else{
			mochckdate(obj1,obj2);
		}
		}
	}

	function mochckdate(obj1,obj2){
		if(obj1.value!='' && obj2.value!=''){
			if(!(isBefore(obj1.value,obj2.value,"DMY",localeName)))
			{
				alert(getMessage('TO_DT_GR_EQ_FM_DT','SM'));
				obj2.select();
			}
		}
	}

	

