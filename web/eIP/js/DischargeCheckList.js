/*
	@ MODULE		:	InPatient Management..(IP)
	@ Function Name	:	Discharge -> DischargeCheckList 
	@ Developer		:	Ranjani
	@ Created on	:	22 Feb 2005
*/
/* Start of addition for DischargeCheckListTab1.jsp */

function enableInformName_tab1()
{
	if(document.forms[0].inform_to.value!="")
	{
		document.getElementById('im').style.visibility			= 'visible';
		document.getElementById('im2').style.visibility			= 'visible';
		document.forms[0].informed_date.disabled	= false;
		document.getElementById('infocalimg').disabled			= false;
		document.forms[0].informed_name.readOnly	= false;
	}
	if (document.forms[0].inform_to.value=="")
	{
		document.getElementById('im').style.visibility			= 'hidden';
		document.forms[0].informed_date.disabled	= true;
		document.forms[0].informed_date.value		= '';
		document.getElementById('infocalimg').disabled			= true;
		document.forms[0].informed_name.readOnly	= true;
	}

	if ((document.forms[0].inform_to.value == "01") || (document.forms[0].inform_to.value == "02"))
	{
		var informTo	= document.forms[0].inform_to.value;
		var patientid	= document.forms[0].patient_id.value;

		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dummy_form' id='dummy_form' method='post'  action='../../eIP/jsp/DischargeValidation.jsp' ><input type='hidden' name='field1' id='field1' value='DischargeCheckList'><input type='hidden' name='field2' id='field2' value='"+patientid+"'><input type='hidden' name='field3' id='field3' value='"+informTo+"'><input type='hidden' name='field4' id='field4' value='DischargeCheckList'><input type='hidden' name='field5' id='field5' value='Discharge'></form></body></html>";
		parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[3].document.dummy_form.submit();
	}
	else 
	{
		document.forms[0].informed_name.value =  "";
	}
}

function ChkNumberInput1_tab1(fld, e, deci)
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

//Added by Ashwini on 31-Jan-2017 for ML-MMOH-CRF-0620
function SpCharChkForCertificate(event)
{
	var strCheck = '0123456789abcdefghijlkmnopqrstuvwxyzABCDEFGHIJLKMNOPQRSTUVWXYZ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
} 
 
//Added by Ashwini on 31-Jan-2017 for ML-MMOH-CRF-0620
function NumChkForCertificate(event)
{
	var strCheck = '1234567890';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
} 

//Added by Ashwini on 31-Jan-2017 for ML-MMOH-CRF-0620


function ZeroChkForCertificate(obj2){	
	if(obj2.value!=""){
		if (obj2.value <= 0){
		alert(getMessage('IP_VAL_NOT_LESS_ZERO',"IP"));
		obj2.value="";
		obj2.focus();		
		}	
	}	
}

//Added by Ashwini on 31-Jan-2017 for ML-MMOH-CRF-0620
function compareDates()
{
	var from = document.forms[0].cert_from_date;
	var to = document.forms[0].cert_to_date;
	
	if(from.value !='' && to.value !='')
	{
		if(validDate(from.value,"DMY",localeName) && validDate(to.value,"DMY",localeName))
		{
			var fromDt	= convertDate(document.forms[0].cert_from_date.value,"DMY",localeName,"en");
			var toDt	= convertDate(document.forms[0].cert_to_date.value,"DMY",localeName,"en");
			if(!isBefore(fromDt,toDt,'DMY',localeName))
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				document.forms[0].cert_to_date.value="";
			}
		}
	}
}


function local_CheckDate2_tab1(Object3)
{
   var strDate;
    var strDay;
    var strMonth;
    var strYear;
    var datefield = Object3;
    var strDateArray = new Array();
	var strDateArray2;
	var strYear1;
	var strTime;

    strDate = datefield.value;
    if (strDate.length == 0) return true;

	if(Object3.value.indexOf('.') > 0) return false;

    strDateArray = strDate.split("/");
    if (strDateArray.length != 3) {
        return false;
    }
    else {
        strDay = strDateArray[0];
        strMonth = strDateArray[1];
        strYear = strDateArray[2];
    }
	if(strMonth == 0)
		return false;

	if(strDay == 0)
		return false;

    strDateArray2 = strYear.split(" ");
    if (strDateArray2.length != 2) {
        return false;
    }
    else {
        strYear1 = strDateArray2[0];
        strTime = strDateArray2[1];
    }
	if(strYear1 == 0)
	  return false;

	if(strYear == 0)
		return false;

    return true;
}


function datefun_tab1(obj)
{
	if((obj.value != null)||(obj.value != ""))
	{
		validDateObj(obj,"DMYHM",localeName);
	}
}

function setValue_tab1(obj)
{
	if(obj.checked)
		obj.value='Y';
	else
		obj.value = '';
}

function Valid_DT_tab1(event)
{
	var strCheck = '0123456789:/ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
} 

function chk_with_sysdate_tab1(obj)
{
	if(obj.value!='')
	{
		var to = parent.parent.DischargeCheckList_frame1.document.forms[0].system_date_time;
		to =  convertDate(to.value,"DMYHM","en",localeName);	
		if(validDateObj(obj,"DMYHM",localeName))
		{	
			if(!isBefore(obj.value,to,"DMYHM",localeName))
			{	
				var str = getMessage("CANNOT_GREATER","MP");
				str = str.replace('#', getLabel("Common.date.label","Common"));
				str = str.replace('$', getLabel("Common.SystemDate.label","Common"));
				alert(str);	
				obj.select();
				obj.focus();			
			}
		}
	}
}

async function call_discharge_summary_tab1()
{
	var retVal = 	new String();
	var dialogHeight= "25" ;
	var dialogTop = "60" ;
	var dialogWidth	= "100" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ; dialogTop:" + dialogTop + " ; scroll=no; status:" + status ;
	var accession_num = document.forms[0].accession_num.value;
	var retVal = await window.showModalDialog("../../eCA/jsp/PhysicanNotesDetails.jsp?accession_num="+accession_num,arguments,features);
}

async function vwMedicalCertificate_tab1(pat_id, enc_id)
{
	var retVal = 	new String();
	var dialogHeight= "30vh" ;
	var dialogTop = "60vw" ;
	var dialogWidth	= "100" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ; dialogTop:" + dialogTop + " ; scroll=no; status:" + status ;

	
	var retVal = await window.showModalDialog("../../eIP/jsp/MedicalCertificateDetails.jsp?PatientId="+pat_id+"&EncounterId="+enc_id,arguments,features);

}

/* Start of addition for DischargeCheckListTab2.jsp */

async function showValuables_tab2()
{
	var retVal =    new String();
	var dialogTop   = "30px";
	var dialogHeight    = "40vh" ;
	var dialogWidth = "50vw" ;
	var features    ="dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments ="";

	var patient_id			= document.forms[0].patient_id.value;		
	var encounter_id		= document.forms[0].encounter_id.value;
	var facility_id			= document.forms[0].facility.value ;
		
	var url   = "../../eIP/jsp/PatientValuablesMain.jsp?encounter_id="+encounter_id+"&patientId="+patient_id+"&param=discharge_chklist";
	retVal = await window.showModalDialog(url,arguments,features);
	if(retVal != null)
	{
		if(retVal != "")
		{
			var contact_vals = new Array();
			contact_vals = retVal;
			var contacts = contact_vals.split("||");
		}
	}
	
}

async function displayUser_tab2(obj,target,target_id)
{
	var retVal = 	new String();
	var dialogHeight= "80vh" ;
	var dialogWidth	= "55vw" ;
	var dialogLeft="500";
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var dispDescFirst="dispDescFirst";
	var tit=getLabel("Common.username.label","Common");
	if(document.forms[0].facility.value !='')
	{
		sql="select appl_user_id  ,appl_user_name  from sm_facility_for_user_vw where facility_id = `"+document.forms[0].facility.value+"`";
		search_code="appl_user_id";
		search_desc= "appl_user_name";

		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status+";dialogLeft:"+dialogLeft+";";
		retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst="+dispDescFirst,arguments,features);
		var arr=new Array();
		if (!(retVal == null))
		{
			var ret1=unescape(retVal);
			arr=ret1.split("::");
			target.value=arr[0];
			target_id.value=arr[1];
		}
	}
}

function setValue_tab2(obj)
{
	if(obj.checked)
		obj.value='Y';
	else
		obj.value = '';
}

function Valid_DT_tab2(event)
{
	var strCheck = '0123456789:/ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
} 

function chk_with_sysdate_tab2(obj)
{
	if(obj.value!='')
	{
		var from = obj;
		var system_date_time = parent.parent.DischargeCheckList_frame1.document.forms[0].system_date_time;
		var admission_date_time = parent.parent.frames[1].document.forms[0].admission_date_time;
		system_date_time =  convertDate(system_date_time.value,"DMYHM","en",localeName);
		admission_date_time =  convertDate(admission_date_time.value,"DMYHM","en",localeName);
		var max_trn_date_time = parent.parent.frames[1].document.forms[0].max_trn_date_time.value
		if(validDateObj(obj,"DMYHM",localeName))
		{
			if(!isBefore(from.value, system_date_time,"DMYHM",localeName))
			{
				var error = getMessage("DATE1_GT_DATE2","IP");
				error = error.replace("$", getLabel("Common.entereddatetime.label","Common"));
				error = error.replace("#", getLabel("Common.CurrentDateTime.label","Common")); 
				alert(error);
				obj.select();
				return;
			}
			else if(!isBefore(admission_date_time, from.value,"DMYHM",localeName))
			{
				alert(getMessage("LT_ADMN_DATE","IP"));
				obj.select();
				return;
			}
			else if(!isBefore(max_trn_date_time,from.value,'DMYHM','en')){
				 var error = getMessage('DATE1_LT_DATE2','IP');
				 var last_encounter = getLabel("eIP.LastTransactionDateTime.label","IP");
				 error = error.replace('$',getLabel("Common.entereddatetime.label","Common"));
				 error = error.replace('#',last_encounter);
				 alert(error);
				 obj.select();
				 return false;

			}
		}
	}
}

function enable_disable_tab2(obj)
{
	if(obj.name=='iv_catheters_chk')
	{
		if(obj.checked)
		{
			document.forms[0].iv_removed_by.disabled = false;
			document.forms[0].iv_removed_dt.disabled = false;
			document.getElementById('iv_removed_dt_img').disabled = false;
			/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
			if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
			{
				document.forms[0].iv_remove_chk.disabled = true;
				document.forms[0].iv_remarks.disabled = false;
			}
		}
		else
		{
			document.forms[0].iv_removed_by.disabled = true;
			document.forms[0].iv_removed_by.value="";
			document.forms[0].iv_removed_dt.disabled = true;
			document.forms[0].iv_removed_dt.value="";
			document.getElementById('iv_removed_dt_img').disabled = true;
			/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
			if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
			{
				document.forms[0].iv_remove_chk.disabled = false;
				document.forms[0].iv_remove_chk.value="";
				document.forms[0].iv_remarks.disabled = true;
				document.forms[0].iv_remarks.value="";
			}
		}
	}
	else if(obj.name=='tubes_chk')
	{
		if(obj.checked)
		{
			document.forms[0].tubes_removed_by.disabled = false;
			document.forms[0].tubes_removed_dt.disabled = false;
			document.getElementById('tubes_removed_dt_img').disabled = false;
			/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
			if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
			{
				document.forms[0].tubes_remove_chk.disabled = true;
				document.forms[0].tubes_remarks.disabled = false;
			}
		}
		else
		{
			document.forms[0].tubes_removed_by.disabled = true;
			document.forms[0].tubes_removed_by.value="";
			document.forms[0].tubes_removed_dt.disabled = true;
			document.forms[0].tubes_removed_dt.value="";
			document.getElementById('tubes_removed_dt_img').disabled = true;
			/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
			if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
			{
				document.forms[0].tubes_remove_chk.disabled = false;
				document.forms[0].tubes_remove_chk.value="";
				document.forms[0].tubes_remarks.disabled = true;
				document.forms[0].tubes_remarks.value="";
			}
		}
	}
	else if(obj.name=='drg_chk')
	{
		if(obj.checked)
		{
			document.forms[0].drg_removed_by.disabled = false;
			document.forms[0].drg_removed_dt.disabled = false;
			document.getElementById('drg_removed_dt_img').disabled = false;
			/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
			if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
			{
				document.forms[0].drg_remove_chk.disabled = true;
				document.forms[0].drg_remarks.disabled = false;
			}
		}
		else
		{
			document.forms[0].drg_removed_by.disabled = true;
			document.forms[0].drg_removed_by.value="";
			document.forms[0].drg_removed_dt.disabled = true;
			document.forms[0].drg_removed_dt.value="";
			document.getElementById('drg_removed_dt_img').disabled = true;
			/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
			if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
			{
				document.forms[0].drg_remove_chk.disabled = false;
				document.forms[0].drg_remove_chk.value="";
				document.forms[0].drg_remarks.disabled = true;
				document.forms[0].drg_remarks.value="";
			}
		}
	}
	else if(obj.name=='ngt_tube_chk')
	{
		if(obj.checked)
		{
			document.forms[0].ngt_tube_removed_by.disabled = false;
			document.forms[0].ngt_tube_removed_dt.disabled = false;
			document.getElementById('ngt_tube_removed_dt_img').disabled = false;
			/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
			if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
			{
				document.forms[0].ngt_remove_chk.disabled = true;
				document.forms[0].ngt_remarks.disabled = false;
			}
		}
		else
		{
			document.forms[0].ngt_tube_removed_by.disabled = true;
			document.forms[0].ngt_tube_removed_by.value="";
			document.forms[0].ngt_tube_removed_dt.disabled = true;
			document.forms[0].ngt_tube_removed_dt.value="";
			document.getElementById('ngt_tube_removed_dt_img').disabled = true;
			/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
			if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
			{
				document.forms[0].ngt_remove_chk.disabled = false;
				document.forms[0].ngt_remove_chk.value="";
				document.forms[0].ngt_remarks.disabled = true;
				document.forms[0].ngt_remarks.value="";
			}
		}
	}

	/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
	else if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "false" && obj.name=='cngt_tube_chk')
	{
		if(obj.checked)
		{
			document.forms[0].cngt_tube_removed_by.disabled = false;
			document.forms[0].cngt_tube_removed_dt.disabled = false;
			document.getElementById('cngt_tube_removed_dt_img').disabled = false;
		}
		else
		{
			document.forms[0].cngt_tube_removed_by.disabled = true;
			document.forms[0].cngt_tube_removed_by.value="";
			document.forms[0].cngt_tube_removed_dt.disabled = true;
			document.forms[0].cngt_tube_removed_dt.value="";
			document.getElementById('cngt_tube_removed_dt_img').disabled = true;
		}
	}
	else if(obj.name=='urn_chk')
	{
		if(obj.checked)
		{
			document.forms[0].urn_removed_by.disabled = false;
			document.forms[0].urn_removed_dt.disabled = false;
			document.getElementById('urn_removed_dt_img').disabled = false;
			/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
			if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
			{
				document.forms[0].urn_remove_chk.disabled = true;
				document.forms[0].urn_remarks.disabled = false;
			}
		}
		else
		{
			document.forms[0].urn_removed_by.disabled = true;
			document.forms[0].urn_removed_by.value="";
			document.forms[0].urn_removed_dt.disabled = true;
			document.forms[0].urn_removed_dt.value="";
			document.getElementById('urn_removed_dt_img').disabled = true;
			/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
			if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
			{
				document.forms[0].urn_remove_chk.disabled = false;
				document.forms[0].urn_remove_chk.value="";
				document.forms[0].urn_remarks.disabled = true;
				document.forms[0].urn_remarks.value="";
			}
		}
	}
	/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
	else if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "false" && obj.name=='curn_chk')
	{
		if(obj.checked)
		{
			document.forms[0].curn_removed_by.disabled = false;
			document.forms[0].curn_removed_dt.disabled = false;
			document.getElementById('curn_removed_dt_img').disabled = false;
		}
		else
		{
			document.forms[0].curn_removed_by.disabled = true;
			document.forms[0].curn_removed_by.value="";
			document.forms[0].curn_removed_dt.disabled = true;
			document.forms[0].curn_removed_dt.value="";
			document.getElementById('curn_removed_dt_img').disabled = true;
		}
	}
	else if(obj.name=='sto_chk')
	{
		if(obj.checked)
		{
			document.forms[0].sto_removed_by.disabled = false;
			document.forms[0].sto_removed_dt.disabled = false;
			document.getElementById('sto_removed_dt_img').disabled = false;
			/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
			if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
			{
				document.forms[0].sto_remove_chk.disabled = true;
				document.forms[0].sto_remarks.disabled = false;
			}
		}
		else
		{
			document.forms[0].sto_removed_by.disabled = true;
			document.forms[0].sto_removed_by.value="";
			document.forms[0].sto_removed_dt.disabled = true;
			document.forms[0].sto_removed_dt.value="";
			document.getElementById('sto_removed_dt_img').disabled = true;
			/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
			if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
			{
				document.forms[0].sto_remove_chk.disabled = false;
				document.forms[0].sto_remove_chk.value="";
				document.forms[0].sto_remarks.disabled = true;
				document.forms[0].sto_remarks.value="";
			}
		}
	}
	else if(obj.name=='dressing_chk')
	{
		if(obj.checked)
		{
			document.forms[0].dressing_removed_by.disabled = false;
			document.forms[0].dressing_removed_dt.disabled = false;
			document.getElementById('dressing_removed_dt_img').disabled = false;
			/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
			if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
			{
				document.forms[0].dressing_remove_chk.disabled = true;
				document.forms[0].dressing_remarks.disabled = false;
			}
		}
		else
		{
			document.forms[0].dressing_removed_by.disabled = true;
			document.forms[0].dressing_removed_by.value="";
			document.forms[0].dressing_removed_dt.disabled = true;
			document.forms[0].dressing_removed_dt.value="";
			document.getElementById('dressing_removed_dt_img').disabled = true;
			/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
			if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
			{
				document.forms[0].dressing_remove_chk.disabled = false;
				document.forms[0].dressing_remove_chk.value="";
				document.forms[0].dressing_remarks.disabled = true;
				document.forms[0].dressing_remarks.value="";
			}
		}
	}
	/*Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218*/
	else if(obj.name=='itemloan_chk')
	{
		if(obj.checked)
		{
			document.forms[0].itemloan_removed_by.disabled = false;
			document.forms[0].itemloan_removed_dt.disabled = false;
			document.getElementById('itemloan_removed_dt_img').disabled = false;
			if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
			{
				document.forms[0].itemloan_remove_chk.disabled = true;
				document.forms[0].itemloan_remarks.disabled = false;
			}
		}
		else
		{
			document.forms[0].itemloan_removed_by.disabled = true;
			document.forms[0].itemloan_removed_by.value="";
			document.forms[0].itemloan_removed_dt.disabled = true;
			document.forms[0].itemloan_removed_dt.value="";
			document.getElementById('itemloan_removed_dt_img').disabled = true;
			if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
			{
				document.forms[0].itemloan_remove_chk.disabled = false;
				document.forms[0].itemloan_remove_chk.value="";
				document.forms[0].itemloan_remarks.disabled = true;
				document.forms[0].itemloan_remarks.value="";
			}
		}
	}
	else if(obj.name=='others_chk')
	{
		if(obj.checked)
		{
			document.forms[0].others_removed_by.disabled = false;
			document.forms[0].others_removed_dt.disabled = false;
			document.getElementById('others_removed_dt_img').disabled = false;
			if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
			{
				document.forms[0].others_remove_chk.disabled = true;
				document.forms[0].others_remarks.disabled = false;
			}
		}
		else
		{
			document.forms[0].others_removed_by.disabled = true;
			document.forms[0].others_removed_by.value="";
			document.forms[0].others_removed_dt.disabled = true;
			document.forms[0].others_removed_dt.value="";
			document.getElementById('others_removed_dt_img').disabled = true;
			if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
			{
				document.forms[0].others_remove_chk.disabled = false;
				document.forms[0].others_remove_chk.value="";
				document.forms[0].others_remarks.disabled = true;
				document.forms[0].others_remarks.value="";
			}
		}
	}
	/*End ML-MMOH-CRF-1218*/
	else if(obj.name=='blng_returned')
	{
		if(obj.checked)
		{
			document.forms[0].blng_returned_dt.disabled = false;
			document.getElementById('blng_returned_dt_img').disabled = false;
			document.forms[0].blng_remarks.disabled = false;
		}
		else
		{
			document.forms[0].blng_returned_dt.disabled = true;
			document.forms[0].blng_returned_dt.value="";
			document.getElementById('blng_returned_dt_img').disabled = true;
			document.forms[0].blng_remarks.disabled = true;
			document.forms[0].blng_remarks.value="";
		}
	}
	else if(obj.name=='vlb_returned')
	{
		if(obj.checked)
		{
			//document.forms[0].vlb_returned_by.disabled = false;
			//document.forms[0].user_search.disabled = false;
			//document.forms[0].vlb_witness.disabled = false;
			//document.forms[0].pract_id_search.disabled = false;
		}
		else
		{
			/*document.forms[0].vlb_returned_by.disabled = true;
			document.forms[0].user_search.disabled = true;
			document.forms[0].vlb_returned_by.value="";
			document.forms[0].vlb_witness.disabled = true;
			document.forms[0].pract_id_search.disabled = true;
			document.forms[0].vlb_witness.value="";*/
		}
	}
	else if(obj.name=='tp_arranged')
	{
		if(obj.checked)
		{
			document.forms[0].tp_returned_dt.disabled = false;
			document.getElementById('tp_returned_dt_img').disabled = false;
			document.forms[0].tp_remarks.disabled = false;

		}
		else
		{
			document.forms[0].tp_returned_dt.disabled = true;
			document.forms[0].tp_returned_dt.value="";
			document.getElementById('tp_returned_dt_img').disabled = true;
			document.forms[0].tp_remarks.disabled = true;
			document.forms[0].tp_remarks.value="";
		}
	}
}


function getattndpract_tab2() // function to call callpractsearch if the text field is empty.
{	
	if (document.forms[0].vlb_witness.value=="")
		{ }
	else
	{	
		callPractSearch_tab2(document.forms[0].pract_id_search,document.forms[0].vlb_witness); fixvaluespractitioner_tab2();
	}
}

function PractLookupRetVal(retVal,objName) //Part of callPractSearch_tab2 function.
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");				
		document.forms[0].temp_desc.value=arr[1];
		document.forms[0].temp_physician_id.value=arr[0];					
	}	
}

function callPractSearch_tab2ToDELETE(obj,target)
{
	
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	var sqlSec="";
	practName_FName=target.name;
	practName_FValue=target.value;
	practId_FName=document.forms[0].witness_id.name;	
	
	sql = " SELECT a.practitioner_id  practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name ,am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2) primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, am_get_desc.am_position(b.position_code,'"+locale+"',1) job_title FROM am_practitioner a WHERE a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR  UPPER(am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.position_code  like (?) or a.position_code is null) ";

	sqlSec= " SELECT a.practitioner_id  practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1) practitioner_name ,am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type, am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2) primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, am_get_desc.am_position(b.position_code,'"+locale+"',1) job_title FROM am_practitioner a WHERE a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  and  UPPER(am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.position_code  like (?) or a.position_code is null) ";

	/*
	* if you are passing User Defined SQL and in that if you want to pass any of the folowing in where criteria  :-
	*	1.  practioner type
	*   2. Speciality /Clinic code
	*   3. Job Title
	*   4. Gender
	* then you must pass them in the query string below with folowing names
	*	1.  practioner type         ----->practitioner_type
	*   2. Speciality /Clinic code  ----->specialty_code
	*   3. Job Title				----->job_title
	*   4. Gender					----->gender
	*/
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" + practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sqlSec)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + ""+ "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);			
}


function fixvaluespractitioner_tab2() //Function to set the practitioner id values from the pracitioner search
{
	document.forms[0].vlb_witness.value=document.forms[0].temp_desc.value;
	document.forms[0].witness_id.value=document.forms[0].temp_physician_id.value;
	document.forms[0].temp_desc.value="";
	document.forms[0].temp_physician_id.value="";	
}


/* Start of addition for DischargeCheckListTab3.jsp */

function setValue_tab3(obj)
{
	if(obj.checked)
		obj.value='Y';
	else
		obj.value = '';
}

function Valid_DT_tab3(event)
{
		var strCheck = '0123456789:/ ';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) == -1) return false;  
} 

function chk_with_sysdate_tab3(obj)
{
	if(obj.value!='')
	{
		var from = obj;
		var system_date_time	= parent.parent.DischargeCheckList_frame1.document.forms[0].system_date_time;
		var admission_date_time	= parent.parent.frames[1].document.forms[0].admission_date_time;
		system_date_time		= convertDate(system_date_time.value,"DMYHM","en",localeName);
		admission_date_time		= convertDate(admission_date_time.value,"DMYHM","en",localeName);
		var max_trn_date_time = parent.parent.frames[1].document.forms[0].max_trn_date_time.value;
		if(validDateObj(from,"DMYHM",localeName))
		{
			if(!isBefore(from.value, system_date_time,"DMYHM",localeName))
			{
				var error = getMessage("DATE1_GT_DATE2","IP");
				error = error.replace("$", getLabel("Common.entereddatetime.label","Common"));
				error = error.replace("#", getLabel("Common.CurrentDateTime.label","Common")); 
				alert(error);
				obj.select();
				return;
			}
			else if(!isAfter(from.value,admission_date_time,"DMYHM",localeName))
			{
				alert(getMessage("LT_ADMN_DATE","IP"));
				obj.select(); 
				return;
			}
			else if(!isBefore(max_trn_date_time,from.value,'DMYHM','en')){
				 var error = getMessage('DATE1_LT_DATE2','IP');
				 var last_encounter = getLabel("eIP.LastTransactionDateTime.label","IP");
				 error = error.replace('$',getLabel("Common.entereddatetime.label","Common"));
				 error = error.replace('#',last_encounter);
				 alert(error);
				 obj.select();
				 return false;
			}
		}
	}
}

function enable_disable_tab3(obj)
{
	if(obj.name=='wc_chk')
	{
		if(obj.checked)
		{
			document.forms[0].wc_given_by.disabled = false;
			document.forms[0].wc_given_dt.disabled = false;
			document.getElementById('wc_given_dt_img').disabled = false;
		}
		else
		{
			document.forms[0].wc_given_by.disabled = true;
			document.forms[0].wc_given_by.value = "";
			document.forms[0].wc_given_dt.disabled = true;
			document.forms[0].wc_given_dt.value = "";
			document.getElementById('wc_given_dt_img').disabled = true;
		}
	}
	else if(obj.name=='nu_chk')
	{
		if(obj.checked)
		{
			document.forms[0].nu_given_by.disabled = false;
			document.forms[0].nu_given_dt.disabled = false;
			document.getElementById('nu_given_dt_img').disabled = false;
		}
		else
		{
			document.forms[0].nu_given_by.disabled = true;
			document.forms[0].nu_given_by.value = "";
			document.forms[0].nu_given_dt.disabled = true;
			document.forms[0].nu_given_dt.value = "";
			document.getElementById('nu_given_dt_img').disabled = true;
		}
	}
	else if(obj.name=='mc_chk')
	{
		if(obj.checked)
		{
			document.forms[0].mc_given_by.disabled = false;
			document.forms[0].mc_given_dt.disabled = false;
			document.getElementById('mc_given_dt_img').disabled = false;
		}
		else
		{
			document.forms[0].mc_given_by.disabled = true;
			document.forms[0].mc_given_by.value = "";
			document.forms[0].mc_given_dt.disabled = true;
			document.forms[0].mc_given_dt.value = "";
			document.getElementById('mc_given_dt_img').disabled = true;
		}
	}
	else if(obj.name=='ph_chk')
	{
		if(obj.checked)
		{
			document.forms[0].ph_given_by.disabled = false;
			document.forms[0].ph_given_dt.disabled = false;
			document.getElementById('ph_given_dt_img').disabled = false;
		}
		else
		{
			document.forms[0].ph_given_by.disabled = true;
			document.forms[0].ph_given_by.value = "";
			document.forms[0].ph_given_dt.disabled = true;
			document.forms[0].ph_given_dt.value = "";
			document.getElementById('ph_given_dt_img').disabled = true;
		}
	}
	else if(obj.name=='cop_chk')
	{
		if(obj.checked)
		{
			document.forms[0].cop_given_by.disabled = false;
			document.forms[0].cop_given_dt.disabled = false;
			document.getElementById('cop_given_dt_img').disabled = false;
		}
		else
		{
			document.forms[0].cop_given_by.disabled = true;
			document.forms[0].cop_given_by.value = "";
			document.forms[0].cop_given_dt.disabled = true;
			document.forms[0].cop_given_dt.value = "";
			document.getElementById('cop_given_dt_img').disabled = true;
		}
	}
	else if(obj.name=='coc_chk')
	{
		if(obj.checked)
		{
			document.forms[0].coc_given_by.disabled = false;
			document.forms[0].coc_given_dt.disabled = false;
			document.getElementById('coc_given_dt_img').disabled = false;
		}
		else
		{
			document.forms[0].coc_given_by.disabled = true;
			document.forms[0].coc_given_by.value = "";
			document.forms[0].coc_given_dt.disabled = true;
			document.forms[0].coc_given_dt.value = "";
			document.getElementById('coc_given_dt_img').disabled = true;
		}
	}
	else if(obj.name=='cot_chk')
	{
		if(obj.checked)
		{
			document.forms[0].cot_given_by.disabled = false;
			document.forms[0].cot_given_dt.disabled = false;
			document.getElementById('cot_given_dt_img').disabled = false;
		}
		else
		{
			document.forms[0].cot_given_by.disabled = true;
			document.forms[0].cot_given_by.value = "";
			document.forms[0].cot_given_dt.disabled = true;
			document.forms[0].cot_given_dt.value = "";
			document.getElementById('cot_given_dt_img').disabled = true;
		}
	}
	else if(obj.name=='oth_he_chk')
	{
		if(obj.checked)
		{
			document.forms[0].oth_text.disabled = false;
			document.forms[0].oth_given_by.disabled = false;
			document.forms[0].oth_given_dt.disabled = false;
			document.getElementById('oth_given_dt_img').disabled = false;
		}
		else
		{
			document.forms[0].oth_text.disabled = true;
			document.forms[0].oth_text.value="";
			document.forms[0].oth_given_by.disabled = true;
			document.forms[0].oth_given_by.value="";
			document.forms[0].oth_given_dt.disabled = true;
			document.forms[0].oth_given_dt.value="";
			document.getElementById('oth_given_dt_img').disabled = true;
		}
	}
}


/* Start of addition for DischargeCheckListTab4.jsp */
function setValue_tab4(obj)
{
	if(obj.checked)
		obj.value='Y';
	else
		obj.value = '';
}

function Valid_DT_tab4(event)
{
		var strCheck = '0123456789:/ ';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) == -1) return false;  
} 

function chk_with_sysdate_tab4(obj)
{
	if(obj.value!='')
	{
		validDateObj(obj,"DMYHM",localeName);
	}
}

/* Start of addition for DischargeCheckListTab5.jsp */
function setValue_tab5(obj)
{
	if(obj.checked)
		obj.value='Y';
	else
		obj.value = '';
}
function Valid_DT_tab5(event)
{
		var strCheck = '0123456789:/ ';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) == -1) return false;  
} 

function chk_with_sysdate_tab5(obj)
{
	if(obj.value!='')
	{
		if(validDateObj(obj,"DMYHM",localeName))
		{
			var greg_Date = convertDate(obj.value,'DMYHM',localeName,'en');
			var system_date_time = parent.parent.DischargeCheckList_frame1.document.forms[0].system_date_time;
			var admission_date_time = parent.parent.frames[1].document.forms[0].admission_date_time;
			system_date_time =  convertDate(system_date_time.value,"DMYHM","en",localeName);
			admission_date_time =  convertDate(admission_date_time.value,"DMYHM","en",localeName);
			var max_trn_date_time = parent.parent.frames[1].document.forms[0].max_trn_date_time.value
			if(isAfterNow(greg_Date, "DMYHM","en"))
			{
				var error = getMessage("DATE1_GT_DATE2","IP");
				error = error.replace("$", getLabel("Common.entereddatetime.label","Common"));
				error = error.replace("#", getLabel("Common.CurrentDateTime.label","Common")); 
				alert(error);
				obj.select();
				return;
			}else if(!isBefore(admission_date_time, obj.value,"DMYHM",localeName))
			{
				alert(getMessage("LT_ADMN_DATE","IP"));
				obj.select();
				return;
			}
			else if(!isBefore(max_trn_date_time,obj.value,'DMYHM','en')){
				 var error = getMessage('DATE1_LT_DATE2','IP');
				 var last_encounter = getLabel("eIP.LastTransactionDateTime.label","IP");
				 error = error.replace('$',getLabel("Common.entereddatetime.label","Common"));
				 error = error.replace('#',last_encounter);
				 alert(error);
				 obj.select();
				 return false;

			}
		}
	}
}


function enable_disable_tab5(obj)
{
	if(obj.name=='ref_ltr_chk')
	{
		if(obj.checked)
		{
			document.forms[0].confirm_chk.disabled = false;			
			document.forms[0].confirm_chk.checked = false;			
		}
		else
		{
			document.forms[0].confirm_chk.disabled = true;			
			document.forms[0].confirm_chk.checked = false;			
		}
	}
	else if(obj.name=='rep_ltr_chk')
	{
		if(obj.checked)
		{
			document.forms[0].rep_dtl_txt.disabled = false;			
			document.forms[0].rep_cnf_txt.disabled = false;			
		}
		else
		{
			document.forms[0].rep_dtl_txt.disabled = true;			
			document.forms[0].rep_cnf_txt.disabled = true;			
		}
	}
	else if(obj.name=='cln_doc_chk')
	{
		if(obj.checked)
		{
			document.forms[0].cln_dtl_txt.disabled = false;			
			document.forms[0].cln_cnf_txt.disabled = false;			
		}
		else
		{
			document.forms[0].cln_dtl_txt.disabled = true;			
			document.forms[0].cln_cnf_txt.disabled = true;			
		}
	}
	else if(obj.name=='oth_doc_chk')
	{
		if(obj.checked)
		{
			document.forms[0].oth_dtl_txt1.disabled = false;			
			document.forms[0].oth_cnf_txt1.disabled = false;			
			document.forms[0].oth_doc_txt.disabled = false;			
		}
		else
		{
			document.forms[0].oth_dtl_txt1.disabled = true;			
			document.forms[0].oth_cnf_txt1.disabled = true;			
			document.forms[0].oth_doc_txt.disabled = true;			
		}
	}	
}


/* Start of addition for DischargeCheckListTab6.jsp */
	function setValue_tab6(obj)
	{
		if(obj.checked)
			obj.value='Y';
		else
			obj.value = '';
	}
	function Valid_DT_tab6(event)
	{
		var strCheck = '0123456789:/ ';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) == -1) return false;  
	} 

function chk_with_sysdate_tab6(obj)
{
	if(obj.value!='')
		validDateObj(obj,"DMYHM",localeName);		
}

/* Start of addition for DischargeCheckListTab7.jsp */

function setValue_tab7(obj)
{
	if(obj.checked)
		obj.value='Y';
	else
		obj.value = '';
}
function Valid_DT_tab7(event)
{
		var strCheck = '0123456789:/ ';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) == -1) return false;  
} 

/* Start of addition for DischargeCheckListMain.jsp */
/*The foll functions are called from DischargeCheckListMain.jsp ...*/

function call_jsp_main(func)
{
	if(func == 'D')
	{
		document.getElementById('tab_1').style.background='BLUE';
		document.getElementById('tab_2').style.background='NAVY';
		document.getElementById('tab_3').style.background='NAVY';
		if(document.getElementById('tab_4'))
			document.getElementById('tab_4').style.background='NAVY';
		document.getElementById('tab_5').style.background='NAVY';
		if(document.getElementById('tab_6'))
			document.getElementById('tab_6').style.background='NAVY';
		if(document.getElementById('tab_7'))
			document.getElementById('tab_7').style.background='NAVY';

		var patient_id = document.forms[0].patient_id.value;
		var encounter_id = document.forms[0].encounter_id.value;
		var patient_age = document.forms[0].patient_age.value;
		var call_function = document.forms[0].call_function.value;
		parent.DischargeCheckList_frame2.location.href="../../eIP/jsp/DischargeCheckListTab1Frames.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&call_function="+call_function;
	}
	else if(func == 'R')
	{
		var witness_id = document.forms[0].h_witness_id.value;
		var witness_user = document.forms[0].h_vlb_user.value;
		var patient_id = document.forms[0].patient_id.value;
		var encounter_id = document.forms[0].encounter_id.value;
		var call_function = document.forms[0].call_function.value;
		document.getElementById('tab_1').style.background='NAVY';document.getElementById('tab_2').style.background='BLUE';
		document.getElementById('tab_3').style.background='NAVY';if(document.getElementById('tab_4')){document.getElementById('tab_4').style.background='NAVY';}
		document.getElementById('tab_5').style.background='NAVY';
		if(document.getElementById('tab_6'))
		document.getElementById('tab_6').style.background='NAVY';
		if(document.getElementById('tab_7'))
		document.getElementById('tab_7').style.background='NAVY';	parent.DischargeCheckList_frame2.location.href="../../eIP/jsp/DischargeCheckListTab2.jsp?witness_id="+witness_id+"&witness_user="+witness_user+"&encounter_id="+encounter_id+"&patient_id="+patient_id+"&call_function="+call_function;
	}
	else if(func == 'H')
	{
		var call_function = document.forms[0].call_function.value;	
		
    	document.getElementById('tab_1').style.background='NAVY';document.getElementById('tab_2').style.background='NAVY';
		document.getElementById('tab_3').style.background='BLUE';if(document.getElementById('tab_4')){document.getElementById('tab_4').style.background='NAVY';}
		document.getElementById('tab_5').style.background='NAVY';
		if(document.getElementById('tab_6'))
		document.getElementById('tab_6').style.background='NAVY';
		if(document.getElementById('tab_7'))
		document.getElementById('tab_7').style.background='NAVY';	parent.DischargeCheckList_frame2.location.href="../../eIP/jsp/DischargeCheckListTab3.jsp?call_function="+call_function;
	}
	else if(func == 'P')
	{
		var call_function = document.forms[0].call_function.value;

		document.getElementById('tab_1').style.background='NAVY';document.getElementById('tab_2').style.background='NAVY';
		document.getElementById('tab_3').style.background='NAVY';if(document.getElementById('tab_4')){document.getElementById('tab_4').style.background='BLUE';}
		document.getElementById('tab_5').style.background='NAVY';
		if(document.getElementById('tab_6'))
		document.getElementById('tab_6').style.background='NAVY';
		if(document.getElementById('tab_7'))
		document.getElementById('tab_7').style.background='NAVY';	parent.DischargeCheckList_frame2.location.href="../../eIP/jsp/DischargeCheckListTab4.jsp?call_function="+call_function;
	}
	else if(func == 'O')
	{
		document.getElementById('tab_1').style.background='NAVY';
		document.getElementById('tab_2').style.background='NAVY';
		document.getElementById('tab_3').style.background='NAVY';
		if(document.getElementById('tab_4'))
			document.getElementById('tab_4').style.background='NAVY';
		document.getElementById('tab_5').style.background='BLUE';
		if(document.getElementById('tab_6'))
			document.getElementById('tab_6').style.background='NAVY';
		if(document.getElementById('tab_7'))
			document.getElementById('tab_7').style.background='NAVY';

		var patient_age = document.forms[0].patient_age.value;
		var call_function = document.forms[0].call_function.value;
		
		parent.DischargeCheckList_frame2.location.href="../../eIP/jsp/DischargeCheckListTab5Frames.jsp?patient_age="+patient_age+"&call_function="+call_function; 
	}
	else if(func == 'L')
	{
		document.getElementById('tab_1').style.background='NAVY';document.getElementById('tab_2').style.background='NAVY';
		document.getElementById('tab_3').style.background='NAVY';if(document.getElementById('tab_4')){document.getElementById('tab_4').style.background='NAVY';}
		document.getElementById('tab_5').style.background='NAVY';
		if(document.getElementById('tab_6'))
		document.getElementById('tab_6').style.background='BLUE';
		if(document.getElementById('tab_7'))
		document.getElementById('tab_7').style.background='NAVY';
		var call_function = document.forms[0].call_function.value;	parent.DischargeCheckList_frame2.location.href="../../eIP/jsp/DischargeCheckListTab6.jsp?call_function="+call_function;
	}
	setData_main();
}


function setData_main()
{
	if(parent.DischargeCheckList_frame2.document.forms[0])
	{
		if(parent.DischargeCheckList_frame2.document.forms[0].iv_catheters_chk)
		{document.DischargeCheckListMain.h_iv_catheters_chk.value = parent.DischargeCheckList_frame2.document.forms[0].iv_catheters_chk.value;}
		/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
		if(document.DischargeCheckListMain.isChangesInAdditionalDtlsTabAppl.value == "true")
		{
		if(parent.DischargeCheckList_frame2.document.forms[0].iv_remove_chk)
		{document.DischargeCheckListMain.h_iv_remove_chk.value = parent.DischargeCheckList_frame2.document.forms[0].iv_remove_chk.value;}
		if(parent.DischargeCheckList_frame2.document.forms[0].iv_remarks)
		{document.DischargeCheckListMain.h_iv_remarks.value = parent.DischargeCheckList_frame2.document.forms[0].iv_remarks.value;}
		}
		if(parent.DischargeCheckList_frame2.document.forms[0].iv_removed_by)
		document.DischargeCheckListMain.h_iv_removed_by.value = parent.DischargeCheckList_frame2.document.forms[0].iv_removed_by.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].iv_removed_dt)
		document.DischargeCheckListMain.h_iv_removed_dt.value = parent.DischargeCheckList_frame2.document.forms[0].iv_removed_dt.value;

		if(parent.DischargeCheckList_frame2.document.forms[0].tubes_chk)
		document.DischargeCheckListMain.h_tubes_chk.value = parent.DischargeCheckList_frame2.document.forms[0].tubes_chk.value;
		/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
		if(document.DischargeCheckListMain.isChangesInAdditionalDtlsTabAppl.value == "true")
		{
		if(parent.DischargeCheckList_frame2.document.forms[0].tubes_remove_chk)
		{document.DischargeCheckListMain.h_tubes_remove_chk.value = parent.DischargeCheckList_frame2.document.forms[0].tubes_remove_chk.value;}
		if(parent.DischargeCheckList_frame2.document.forms[0].tubes_remarks)
		{document.DischargeCheckListMain.h_tubes_remarks.value = parent.DischargeCheckList_frame2.document.forms[0].tubes_remarks.value;}
		}
		if(parent.DischargeCheckList_frame2.document.forms[0].tubes_removed_by)
		document.DischargeCheckListMain.h_tubes_removed_by.value = parent.DischargeCheckList_frame2.document.forms[0].tubes_removed_by.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].tubes_removed_dt)
		document.DischargeCheckListMain.h_tubes_removed_dt.value = parent.DischargeCheckList_frame2.document.forms[0].tubes_removed_dt.value;

		if(parent.DischargeCheckList_frame2.document.forms[0].drg_chk)
		document.DischargeCheckListMain.h_drg_chk.value = parent.DischargeCheckList_frame2.document.forms[0].drg_chk.value;
		/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
		if(document.DischargeCheckListMain.isChangesInAdditionalDtlsTabAppl.value == "true")
		{
		if(parent.DischargeCheckList_frame2.document.forms[0].drg_remove_chk)
		{document.DischargeCheckListMain.h_drg_remove_chk.value = parent.DischargeCheckList_frame2.document.forms[0].drg_remove_chk.value;}
		if(parent.DischargeCheckList_frame2.document.forms[0].drg_remarks)
		{document.DischargeCheckListMain.h_drg_remarks.value = parent.DischargeCheckList_frame2.document.forms[0].drg_remarks.value;}
		}
		if(parent.DischargeCheckList_frame2.document.forms[0].drg_removed_by)
		document.DischargeCheckListMain.h_drg_removed_by.value = parent.DischargeCheckList_frame2.document.forms[0].drg_removed_by.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].drg_removed_dt)
		document.DischargeCheckListMain.h_drg_removed_dt.value = parent.DischargeCheckList_frame2.document.forms[0].drg_removed_dt.value;

		if(parent.DischargeCheckList_frame2.document.forms[0].ngt_tube_chk)
		document.DischargeCheckListMain.h_ngt_tube_chk.value = parent.DischargeCheckList_frame2.document.forms[0].ngt_tube_chk.value;
		/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
		if(document.DischargeCheckListMain.isChangesInAdditionalDtlsTabAppl.value == "true")
		{
		if(parent.DischargeCheckList_frame2.document.forms[0].ngt_remove_chk)
		{document.DischargeCheckListMain.h_ngt_remove_chk.value = parent.DischargeCheckList_frame2.document.forms[0].ngt_remove_chk.value;}
		if(parent.DischargeCheckList_frame2.document.forms[0].ngt_remarks)
		{document.DischargeCheckListMain.h_ngt_remarks.value = parent.DischargeCheckList_frame2.document.forms[0].ngt_remarks.value;}
		}
		if(parent.DischargeCheckList_frame2.document.forms[0].ngt_tube_removed_by)
		document.DischargeCheckListMain.h_ngt_tube_removed_by.value = parent.DischargeCheckList_frame2.document.forms[0].ngt_tube_removed_by.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].ngt_tube_removed_dt)
		document.DischargeCheckListMain.h_ngt_tube_removed_dt.value = parent.DischargeCheckList_frame2.document.forms[0].ngt_tube_removed_dt.value;


		/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
		if(document.DischargeCheckListMain.isChangesInAdditionalDtlsTabAppl.value == "false")
		{
			if(parent.DischargeCheckList_frame2.document.forms[0].cngt_tube_chk)
			document.DischargeCheckListMain.h_cngt_tube_chk.value = parent.DischargeCheckList_frame2.document.forms[0].cngt_tube_chk.value;
			if(parent.DischargeCheckList_frame2.document.forms[0].cngt_tube_removed_by)
			document.DischargeCheckListMain.h_cngt_tube_removed_by.value = parent.DischargeCheckList_frame2.document.forms[0].cngt_tube_removed_by.value;
			if(parent.DischargeCheckList_frame2.document.forms[0].cngt_tube_removed_dt)
			document.DischargeCheckListMain.h_cngt_tube_removed_dt.value = parent.DischargeCheckList_frame2.document.forms[0].cngt_tube_removed_dt.value;
		}

		if(parent.DischargeCheckList_frame2.document.forms[0].urn_chk)
		document.DischargeCheckListMain.h_urn_chk.value = parent.DischargeCheckList_frame2.document.forms[0].urn_chk.value;
		/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
		if(document.DischargeCheckListMain.isChangesInAdditionalDtlsTabAppl.value == "true")
		{
		if(parent.DischargeCheckList_frame2.document.forms[0].urn_remove_chk)
		{document.DischargeCheckListMain.h_urn_remove_chk.value = parent.DischargeCheckList_frame2.document.forms[0].urn_remove_chk.value;}
		if(parent.DischargeCheckList_frame2.document.forms[0].urn_remarks)
		{document.DischargeCheckListMain.h_urn_remarks.value = parent.DischargeCheckList_frame2.document.forms[0].urn_remarks.value;}
		}
		if(parent.DischargeCheckList_frame2.document.forms[0].urn_removed_by)
		document.DischargeCheckListMain.h_urn_removed_by.value = parent.DischargeCheckList_frame2.document.forms[0].urn_removed_by.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].urn_removed_dt)
		document.DischargeCheckListMain.h_urn_removed_dt.value = parent.DischargeCheckList_frame2.document.forms[0].urn_removed_dt.value;


		/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
		if(document.DischargeCheckListMain.isChangesInAdditionalDtlsTabAppl.value == "false")
		{
			if(parent.DischargeCheckList_frame2.document.forms[0].curn_chk)
			document.DischargeCheckListMain.h_curn_chk.value = parent.DischargeCheckList_frame2.document.forms[0].curn_chk.value;
			if(parent.DischargeCheckList_frame2.document.forms[0].curn_removed_by)
			document.DischargeCheckListMain.h_curn_removed_by.value = parent.DischargeCheckList_frame2.document.forms[0].curn_removed_by.value;
			if(parent.DischargeCheckList_frame2.document.forms[0].curn_removed_dt)
			document.DischargeCheckListMain.h_curn_removed_dt.value = parent.DischargeCheckList_frame2.document.forms[0].curn_removed_dt.value;
		}

		if(parent.DischargeCheckList_frame2.document.forms[0].sto_chk)
		document.DischargeCheckListMain.h_sto_chk.value = parent.DischargeCheckList_frame2.document.forms[0].sto_chk.value;
		/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
		if(document.DischargeCheckListMain.isChangesInAdditionalDtlsTabAppl.value == "true")
		{
		if(parent.DischargeCheckList_frame2.document.forms[0].sto_remove_chk)
		{document.DischargeCheckListMain.h_sto_remove_chk.value = parent.DischargeCheckList_frame2.document.forms[0].sto_remove_chk.value;}
		if(parent.DischargeCheckList_frame2.document.forms[0].sto_remarks)
		{document.DischargeCheckListMain.h_sto_remarks.value = parent.DischargeCheckList_frame2.document.forms[0].sto_remarks.value;}
		}
		if(parent.DischargeCheckList_frame2.document.forms[0].sto_removed_by)
		document.DischargeCheckListMain.h_sto_removed_by.value = parent.DischargeCheckList_frame2.document.forms[0].sto_removed_by.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].sto_removed_dt)
		document.DischargeCheckListMain.h_sto_removed_dt.value = parent.DischargeCheckList_frame2.document.forms[0].sto_removed_dt.value;


		if(parent.DischargeCheckList_frame2.document.forms[0].dressing_chk)
		document.DischargeCheckListMain.h_dressing_chk.value = parent.DischargeCheckList_frame2.document.forms[0].dressing_chk.value;
		/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
		if(document.DischargeCheckListMain.isChangesInAdditionalDtlsTabAppl.value == "true")
		{
		if(parent.DischargeCheckList_frame2.document.forms[0].dressing_remove_chk)
		{document.DischargeCheckListMain.h_dressing_remove_chk.value = parent.DischargeCheckList_frame2.document.forms[0].dressing_remove_chk.value;}
		if(parent.DischargeCheckList_frame2.document.forms[0].dressing_remarks)
		{document.DischargeCheckListMain.h_dressing_remarks.value = parent.DischargeCheckList_frame2.document.forms[0].dressing_remarks.value;}
		}
		if(parent.DischargeCheckList_frame2.document.forms[0].dressing_removed_by)
		document.DischargeCheckListMain.h_dressing_removed_by.value = parent.DischargeCheckList_frame2.document.forms[0].dressing_removed_by.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].dressing_removed_dt)
		document.DischargeCheckListMain.h_dressing_removed_dt.value = parent.DischargeCheckList_frame2.document.forms[0].dressing_removed_dt.value;
		/*Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218*/
		if(document.forms[0].isItemOnLoanOthersDisableDateAppl.value == "true")
		{		
		if(parent.DischargeCheckList_frame2.document.forms[0].itemloan_chk)
		document.DischargeCheckListMain.h_itemloan_chk.value = parent.DischargeCheckList_frame2.document.forms[0].itemloan_chk.value;
		if(document.DischargeCheckListMain.isChangesInAdditionalDtlsTabAppl.value == "true")
		{
		if(parent.DischargeCheckList_frame2.document.forms[0].itemloan_remove_chk)
		{document.DischargeCheckListMain.h_itemloan_remove_chk.value = parent.DischargeCheckList_frame2.document.forms[0].itemloan_remove_chk.value;}
		if(parent.DischargeCheckList_frame2.document.forms[0].itemloan_remarks)
		{document.DischargeCheckListMain.h_itemloan_remarks.value = parent.DischargeCheckList_frame2.document.forms[0].itemloan_remarks.value;}
		}
		if(parent.DischargeCheckList_frame2.document.forms[0].itemloan_removed_by)
		document.DischargeCheckListMain.h_itemloan_removed_by.value = parent.DischargeCheckList_frame2.document.forms[0].itemloan_removed_by.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].itemloan_removed_dt)
		document.DischargeCheckListMain.h_itemloan_removed_dt.value = parent.DischargeCheckList_frame2.document.forms[0].itemloan_removed_dt.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].others_chk)
		document.DischargeCheckListMain.h_others_chk.value = parent.DischargeCheckList_frame2.document.forms[0].others_chk.value;
		if(document.DischargeCheckListMain.isChangesInAdditionalDtlsTabAppl.value == "true")
		{
		if(parent.DischargeCheckList_frame2.document.forms[0].others_remove_chk)
		{document.DischargeCheckListMain.h_others_remove_chk.value = parent.DischargeCheckList_frame2.document.forms[0].others_remove_chk.value;}
		if(parent.DischargeCheckList_frame2.document.forms[0].others_remarks)
		{document.DischargeCheckListMain.h_others_remarks.value = parent.DischargeCheckList_frame2.document.forms[0].others_remarks.value;}
		}
		if(parent.DischargeCheckList_frame2.document.forms[0].others_removed_by)
		document.DischargeCheckListMain.h_others_removed_by.value = parent.DischargeCheckList_frame2.document.forms[0].others_removed_by.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].others_removed_dt)
		document.DischargeCheckListMain.h_others_removed_dt.value = parent.DischargeCheckList_frame2.document.forms[0].others_removed_dt.value;
		}
		/*End ML-MMOH-CRF-1218*/
		if(parent.DischargeCheckList_frame2.document.forms[0].blng_returned)
		document.DischargeCheckListMain.h_blng_returned.value = parent.DischargeCheckList_frame2.document.forms[0].blng_returned.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].blng_returned_dt)
		document.DischargeCheckListMain.h_blng_returned_dt.value = parent.DischargeCheckList_frame2.document.forms[0].blng_returned_dt.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].blng_remarks)
		document.DischargeCheckListMain.h_blng_remarks.value = parent.DischargeCheckList_frame2.document.forms[0].blng_remarks.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].vlb_returned)
		document.DischargeCheckListMain.h_vlb_returned.value = parent.DischargeCheckList_frame2.document.forms[0].vlb_returned.value;

		if(parent.DischargeCheckList_frame2.document.forms[0].vlb_returned_by)
		document.DischargeCheckListMain.h_vlb_returned_by.value = parent.DischargeCheckList_frame2.document.forms[0].vlb_returned_by.value;

		if(parent.DischargeCheckList_frame2.document.forms[0].vlb_user)
		document.DischargeCheckListMain.h_vlb_user.value = parent.DischargeCheckList_frame2.document.forms[0].vlb_user.value;




		if(parent.DischargeCheckList_frame2.document.forms[0].vlb_witness)
		document.DischargeCheckListMain.h_vlb_witness.value = parent.DischargeCheckList_frame2.document.forms[0].vlb_witness.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].witness_id)
		document.DischargeCheckListMain.h_witness_id.value = parent.DischargeCheckList_frame2.document.forms[0].witness_id.value;


		if(parent.DischargeCheckList_frame2.document.forms[0].tp_arranged)
		document.DischargeCheckListMain.h_tp_arranged.value = parent.DischargeCheckList_frame2.document.forms[0].tp_arranged.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].tp_returned_dt)
		document.DischargeCheckListMain.h_tp_returned_dt.value = parent.DischargeCheckList_frame2.document.forms[0].tp_returned_dt.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].tp_remarks)
		document.DischargeCheckListMain.h_tp_remarks.value = parent.DischargeCheckList_frame2.document.forms[0].tp_remarks.value;

		if(parent.DischargeCheckList_frame2.document.forms[0].adv_cnt_parent)
		document.DischargeCheckListMain.h_adv_cnt_parent.value = parent.DischargeCheckList_frame2.document.forms[0].adv_cnt_parent.value;

		if(parent.DischargeCheckList_frame2.document.forms[0].adv_cnt_guardian)
		document.DischargeCheckListMain.h_adv_cnt_guardian.value = parent.DischargeCheckList_frame2.document.forms[0].adv_cnt_guardian.value;


		if(parent.DischargeCheckList_frame2.document.forms[0].wc_chk)
		document.DischargeCheckListMain.h_wc_chk.value = parent.DischargeCheckList_frame2.document.forms[0].wc_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].wc_given_by)
		document.DischargeCheckListMain.h_wc_given_by.value = parent.DischargeCheckList_frame2.document.forms[0].wc_given_by.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].wc_given_dt)
		document.DischargeCheckListMain.h_wc_given_dt.value = parent.DischargeCheckList_frame2.document.forms[0].wc_given_dt.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].nu_chk)
		document.DischargeCheckListMain.h_nu_chk.value = parent.DischargeCheckList_frame2.document.forms[0].nu_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].nu_given_by)
		document.DischargeCheckListMain.h_nu_given_by.value = parent.DischargeCheckList_frame2.document.forms[0].nu_given_by.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].nu_given_dt)
		document.DischargeCheckListMain.h_nu_given_dt.value = parent.DischargeCheckList_frame2.document.forms[0].nu_given_dt.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].mc_chk)
		document.DischargeCheckListMain.h_mc_chk.value = parent.DischargeCheckList_frame2.document.forms[0].mc_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].mc_given_by)
		document.DischargeCheckListMain.h_mc_given_by.value = parent.DischargeCheckList_frame2.document.forms[0].mc_given_by.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].mc_given_dt)
		document.DischargeCheckListMain.h_mc_given_dt.value = parent.DischargeCheckList_frame2.document.forms[0].mc_given_dt.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].ph_chk)
		document.DischargeCheckListMain.h_ph_chk.value = parent.DischargeCheckList_frame2.document.forms[0].ph_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].ph_given_by)
		document.DischargeCheckListMain.h_ph_given_by.value = parent.DischargeCheckList_frame2.document.forms[0].ph_given_by.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].ph_given_dt)
		document.DischargeCheckListMain.h_ph_given_dt.value = parent.DischargeCheckList_frame2.document.forms[0].ph_given_dt.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].cop_chk)
		document.DischargeCheckListMain.h_cop_chk.value = parent.DischargeCheckList_frame2.document.forms[0].cop_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].cop_given_by)
		document.DischargeCheckListMain.h_cop_given_by.value = parent.DischargeCheckList_frame2.document.forms[0].cop_given_by.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].cop_given_dt)
		document.DischargeCheckListMain.h_cop_given_dt.value = parent.DischargeCheckList_frame2.document.forms[0].cop_given_dt.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].coc_chk)
		document.DischargeCheckListMain.h_coc_chk.value = parent.DischargeCheckList_frame2.document.forms[0].coc_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].coc_given_by)
		document.DischargeCheckListMain.h_coc_given_by.value = parent.DischargeCheckList_frame2.document.forms[0].coc_given_by.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].coc_given_dt)
		document.DischargeCheckListMain.h_coc_given_dt.value = parent.DischargeCheckList_frame2.document.forms[0].coc_given_dt.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].cot_chk)
		document.DischargeCheckListMain.h_cot_chk.value = parent.DischargeCheckList_frame2.document.forms[0].cot_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].cot_given_by)
		document.DischargeCheckListMain.h_cot_given_by.value = parent.DischargeCheckList_frame2.document.forms[0].cot_given_by.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].cot_given_dt)
		document.DischargeCheckListMain.h_cot_given_dt.value = parent.DischargeCheckList_frame2.document.forms[0].cot_given_dt.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].oth_he_chk)
		document.DischargeCheckListMain.h_oth_he_chk.value = parent.DischargeCheckList_frame2.document.forms[0].oth_he_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].oth_text)
		document.DischargeCheckListMain.h_oth_text.value = parent.DischargeCheckList_frame2.document.forms[0].oth_text.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].oth_given_by)
		document.DischargeCheckListMain.h_oth_given_by.value = parent.DischargeCheckList_frame2.document.forms[0].oth_given_by.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].oth_given_dt)
		document.DischargeCheckListMain.h_oth_given_dt.value = parent.DischargeCheckList_frame2.document.forms[0].oth_given_dt.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].top_to_toe_chk)
		document.DischargeCheckListMain.h_top_to_toe_chk.value = parent.DischargeCheckList_frame2.document.forms[0].top_to_toe_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].co_umb_stmp_chk)
		document.DischargeCheckListMain.h_co_umb_stmp_chk.value = parent.DischargeCheckList_frame2.document.forms[0].co_umb_stmp_chk.value;

		if(parent.DischargeCheckList_frame2.document.forms[0].care_of_skin_chk)
		document.DischargeCheckListMain.h_care_of_skin_chk.value = parent.DischargeCheckList_frame2.document.forms[0].care_of_skin_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].care_of_eye_chk)
		document.DischargeCheckListMain.h_care_of_eye_chk.value = parent.DischargeCheckList_frame2.document.forms[0].care_of_eye_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].expr_br_mlk_chk)
		document.DischargeCheckListMain.h_expr_br_mlk_chk.value = parent.DischargeCheckList_frame2.document.forms[0].expr_br_mlk_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].tube_feed_chk)
		document.DischargeCheckListMain.h_tube_feed_chk.value = parent.DischargeCheckList_frame2.document.forms[0].tube_feed_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].gst_feed_chk)
		document.DischargeCheckListMain.h_gst_feed_chk.value = parent.DischargeCheckList_frame2.document.forms[0].gst_feed_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].frm_milk_chk)
		document.DischargeCheckListMain.h_frm_milk_chk.value = parent.DischargeCheckList_frame2.document.forms[0].frm_milk_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].imn_sch_chk)
		document.DischargeCheckListMain.h_imn_sch_chk.value = parent.DischargeCheckList_frame2.document.forms[0].imn_sch_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].care_of_stoma_chk)
		document.DischargeCheckListMain.h_care_of_stoma_chk.value = parent.DischargeCheckList_frame2.document.forms[0].care_of_stoma_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].anl_dil_chk)
		document.DischargeCheckListMain.h_anl_dil_chk.value = parent.DischargeCheckList_frame2.document.forms[0].anl_dil_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].pop_chk)
		document.DischargeCheckListMain.h_pop_chk.value = parent.DischargeCheckList_frame2.document.forms[0].pop_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].fever_chk)
		document.DischargeCheckListMain.h_fever_chk.value = parent.DischargeCheckList_frame2.document.forms[0].fever_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].sz_chk)
		document.DischargeCheckListMain.h_sz_chk.value = parent.DischargeCheckList_frame2.document.forms[0].sz_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].jnd_chk)
		document.DischargeCheckListMain.h_jnd_chk.value = parent.DischargeCheckList_frame2.document.forms[0].jnd_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].gpd_chk)
		document.DischargeCheckListMain.h_gpd_chk.value = parent.DischargeCheckList_frame2.document.forms[0].gpd_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].stlc_chk)
		document.DischargeCheckListMain.h_stlc_chk.value = parent.DischargeCheckList_frame2.document.forms[0].stlc_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].stlf_chk)
		document.DischargeCheckListMain.h_stlf_chk.value = parent.DischargeCheckList_frame2.document.forms[0].stlf_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].coptb_chk)
		document.DischargeCheckListMain.h_coptb_chk.value = parent.DischargeCheckList_frame2.document.forms[0].coptb_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].oth_ph_chk)
		document.DischargeCheckListMain.h_oth_ph_chk.value = parent.DischargeCheckList_frame2.document.forms[0].oth_ph_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].bfd_chk)
		document.DischargeCheckListMain.h_bfd_chk.value = parent.DischargeCheckList_frame2.document.forms[0].bfd_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].stm_cr_chk)
		document.DischargeCheckListMain.h_stm_cr_chk.value = parent.DischargeCheckList_frame2.document.forms[0].stm_cr_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].oper_chk)
		document.DischargeCheckListMain.h_oper_chk.value = parent.DischargeCheckList_frame2.document.forms[0].oper_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].pop_care_chk)
		document.DischargeCheckListMain.h_pop_care_chk.value = parent.DischargeCheckList_frame2.document.forms[0].pop_care_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].oth_pamphlets)
		document.DischargeCheckListMain.h_oth_pamphlets.value = parent.DischargeCheckList_frame2.document.forms[0].oth_pamphlets.value;

		if(parent.DischargeCheckList_frame2.document.forms[0].dn_given_chk)
		document.DischargeCheckListMain.h_dn_given_chk.value = parent.DischargeCheckList_frame2.document.forms[0].dn_given_chk.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].db_given_chk)
		document.DischargeCheckListMain.h_db_given_chk.value = parent.DischargeCheckList_frame2.document.forms[0].db_given_chk.value; 



		if(parent.DischargeCheckList_frame2.document.forms[0].name_of_patient)
		document.DischargeCheckListMain.h_name_of_patient.value = parent.DischargeCheckList_frame2.document.forms[0].name_of_patient.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].mot_ic_no)
		document.DischargeCheckListMain.h_mot_ic_no.value = parent.DischargeCheckList_frame2.document.forms[0].mot_ic_no.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].rn_txt)
		document.DischargeCheckListMain.h_rn_txt.value = parent.DischargeCheckList_frame2.document.forms[0].rn_txt.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].ward_txt)
		document.DischargeCheckListMain.h_ward_txt.value = parent.DischargeCheckList_frame2.document.forms[0].ward_txt.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].discharge_date)
		document.DischargeCheckListMain.h_discharge_date.value = parent.DischargeCheckList_frame2.document.forms[0].discharge_date.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].weight_txt)
		document.DischargeCheckListMain.h_weight_txt.value = parent.DischargeCheckList_frame2.document.forms[0].weight_txt.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].length_txt)
		document.DischargeCheckListMain.h_length_txt.value = parent.DischargeCheckList_frame2.document.forms[0].length_txt.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].head_circum)
		document.DischargeCheckListMain.h_head_circum.value = parent.DischargeCheckList_frame2.document.forms[0].head_circum.value;
		if(parent.DischargeCheckList_frame2.document.forms[0].adv_given)
		document.DischargeCheckListMain.h_adv_given.value = parent.DischargeCheckList_frame2.document.forms[0].adv_given.value;

		if(parent.DischargeCheckList_frame2.document.forms[0].relationship_txt)
		document.DischargeCheckListMain.h_relationship_txt.value = parent.DischargeCheckList_frame2.document.forms[0].relationship_txt.value;

// NEWFIELDS

		if(parent.DischargeCheckList_frame2.document.forms[0].mother_name)
		document.DischargeCheckListMain.h_mother_name.value = parent.DischargeCheckList_frame2.document.forms[0].mother_name.value;
			if(parent.DischargeCheckList_frame2.document.forms[0].mother_no)
		document.DischargeCheckListMain.h_mother_no.value = parent.DischargeCheckList_frame2.document.forms[0].mother_no.value;
			if(parent.DischargeCheckList_frame2.document.forms[0].father_name)
		document.DischargeCheckListMain.h_father_name.value = parent.DischargeCheckList_frame2.document.forms[0].father_name.value;
			if(parent.DischargeCheckList_frame2.document.forms[0].father_no)
		document.DischargeCheckListMain.h_father_no.value = parent.DischargeCheckList_frame2.document.forms[0].father_no.value;
			if(parent.DischargeCheckList_frame2.document.forms[0].Remarks)
		document.DischargeCheckListMain.h_Remarks.value = parent.DischargeCheckList_frame2.document.forms[0].Remarks.value;


		if(parent.DischargeCheckList_frame3.document.forms[0].date_time_txt)
		document.DischargeCheckListMain.h_date_time_txt.value = parent.DischargeCheckList_frame3.document.forms[0].date_time_txt.value;
		if(parent.DischargeCheckList_frame3.document.forms[0].user_txt)
		document.DischargeCheckListMain.h_user_txt.value = parent.DischargeCheckList_frame3.document.forms[0].user_txt.value;
	}

	if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1)
	{
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0])
		{
			if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_medication)
			document.DischargeCheckListMain.h_dis_medication.value = parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_medication.value;

			if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].chargeable_item_yn)//Added by chandra for MMS-KH-CRF-0052.1
			document.DischargeCheckListMain.h_chargeable_item_yn.value = parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].chargeable_item_yn.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].inform_to)
		document.DischargeCheckListMain.h_inform_to.value = parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].inform_to.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].informed_date)
		{
			if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.getElementById('im').style.visibility == 'visible' && parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].informed_date.value == "")
			{
				parent.frames[3].document.forms[0].infomPass.value = "N";
			}
			else
				parent.frames[3].document.forms[0].infomPass.value = "Y";
			
			document.DischargeCheckListMain.h_informed_date.value = parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].informed_date.value;
		}

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].informed_name)
		document.DischargeCheckListMain.h_informed_name.value = parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].informed_name.value;
			
			if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_summ_prep)
			{
				if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_summ_prep.disabled == true)
				{
					parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_summ_prep.disabled = false;
				}

				document.DischargeCheckListMain.h_dis_summ_prep.value = parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_summ_prep.value;
			}

			if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_summ_prep_by)
			document.DischargeCheckListMain.h_dis_summ_prep_by.value = parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_summ_prep_by.value;

			if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].informed_to)
			{
				if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].informed_to.disabled== true)
				{
					parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].informed_to.disabled = false;
				}
				document.DischargeCheckListMain.h_informed_to.value = parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].informed_to.value;
			}

			if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].cert_no)
			document.DischargeCheckListMain.h_cert_no.value = parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].cert_no.value;

			
			//Added by Ashwini on 30-Jan-2017 for ML-MMOH-CRF-0620 
			if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].cert_num)
			document.DischargeCheckListMain.cert_num.value = parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].cert_num.value;

			if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].cert_from_date)
			document.DischargeCheckListMain.cert_from_date.value = parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].cert_from_date.value;

			if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].cert_to_date)
			document.DischargeCheckListMain.cert_to_date.value = parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].cert_to_date.value;

			if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].duration)
			document.DischargeCheckListMain.duration.value = parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].duration.value;
            if(document.forms[0].isAutoPopDurationApplyn.value !="true")
			{
			if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].duration_dmy)
			document.DischargeCheckListMain.duration_dmy.value = parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].duration_dmy.value;
            }
			// End ML-MMOH-CRF-0620
			//Added by Shanmukh on 2nd-MAY-2018 for ML-MMOH-CRF-1050
			if(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].deli_cert_num)
			document.DischargeCheckListMain.deli_cert_num.value = parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].deli_cert_num.value;
            }
			
		}
	

	if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1)
	{
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0])
		{
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item1)
		document.DischargeCheckListMain.h_oth_app_fix_item1.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item1.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item1_given1)
		document.DischargeCheckListMain.h_oth_app_fix_item1_given1.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item1_given1.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item1_dt1)
		document.DischargeCheckListMain.h_oth_app_fix_item1_dt1.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item1_dt1.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item2)
		document.DischargeCheckListMain.h_oth_app_fix_item2.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item2.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item2_given2)
		document.DischargeCheckListMain.h_oth_app_fix_item2_given2.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item2_given2.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item2_dt2)
		document.DischargeCheckListMain.h_oth_app_fix_item2_dt2.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item2_dt2.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item3)
		document.DischargeCheckListMain.h_oth_app_fix_item3.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item3.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item3_given3)
		document.DischargeCheckListMain.h_oth_app_fix_item3_given3.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item3_given3.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item3_dt3)
		document.DischargeCheckListMain.h_oth_app_fix_item3_dt3.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item3_dt3.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item4)
		document.DischargeCheckListMain.h_oth_app_fix_item4.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item4.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item4_given4)
		document.DischargeCheckListMain.h_oth_app_fix_item4_given4.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item4_given4.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item4_dt4)
		document.DischargeCheckListMain.h_oth_app_fix_item4_dt4.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item4_dt4.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item5)
		document.DischargeCheckListMain.h_oth_app_fix_item5.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item5.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item5_given5)
		document.DischargeCheckListMain.h_oth_app_fix_item5_given5.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item5_given5.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item5_dt5)
		document.DischargeCheckListMain.h_oth_app_fix_item5_dt5.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item5_dt5.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item6)
		document.DischargeCheckListMain.h_oth_app_fix_item6.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item6.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item6_given6)
		document.DischargeCheckListMain.h_oth_app_fix_item6_given6.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item6_given6.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item6_dt6)
		document.DischargeCheckListMain.h_oth_app_fix_item6_dt6.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item6_dt6.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item7)
		document.DischargeCheckListMain.h_oth_app_fix_item7.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item7.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item7_given7)
		document.DischargeCheckListMain.h_oth_app_fix_item7_given7.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item7_given7.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item7_dt7)
		document.DischargeCheckListMain.h_oth_app_fix_item7_dt7.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item7_dt7.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item8)
		document.DischargeCheckListMain.h_oth_app_fix_item8.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item8.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item8_given8)
		document.DischargeCheckListMain.h_oth_app_fix_item8_given8.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item8_given8.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item8_dt8)
		document.DischargeCheckListMain.h_oth_app_fix_item8_dt8.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item8_dt8.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item9)
		document.DischargeCheckListMain.h_oth_app_fix_item9.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item9.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item9_given9)
		document.DischargeCheckListMain.h_oth_app_fix_item9_given9.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item9_given9.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item9_dt9)
		document.DischargeCheckListMain.h_oth_app_fix_item9_dt9.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item9_dt9.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item10)
		document.DischargeCheckListMain.h_oth_app_fix_item10.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item10.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item10_given10)
		document.DischargeCheckListMain.h_oth_app_fix_item10_given10.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item10_given10.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item10_dt10)
		document.DischargeCheckListMain.h_oth_app_fix_item10_dt10.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame1.document.forms[0].oth_app_fix_item10_dt10.value;
		}
	}

	if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2)
	{
	if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0])
		{
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].ref_ltr_chk)
		document.DischargeCheckListMain.h_ref_ltr_chk.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].ref_ltr_chk.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].confirm_chk)
		document.DischargeCheckListMain.h_confirm_chk.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].confirm_chk.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].rep_ltr_chk)
		document.DischargeCheckListMain.h_rep_ltr_chk.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].rep_ltr_chk.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].rep_dtl_txt)
		document.DischargeCheckListMain.h_rep_dtl_txt.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].rep_dtl_txt.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].rep_cnf_txt)
		document.DischargeCheckListMain.h_rep_cnf_txt.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].rep_cnf_txt.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].cln_doc_chk)
		document.DischargeCheckListMain.h_cln_doc_chk.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].cln_doc_chk.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].cln_dtl_txt)
		document.DischargeCheckListMain.h_cln_dtl_txt.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].cln_dtl_txt.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].cln_cnf_txt)
		document.DischargeCheckListMain.h_cln_cnf_txt.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].cln_cnf_txt.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].oth_doc_chk)
		document.DischargeCheckListMain.h_oth_doc_chk.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].oth_doc_chk.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].oth_dtl_txt1)
		document.DischargeCheckListMain.h_oth_dtl_txt1.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].oth_dtl_txt1.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].oth_cnf_txt1)
		document.DischargeCheckListMain.h_oth_cnf_txt1.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].oth_cnf_txt1.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].oth_doc_txt)
		document.DischargeCheckListMain.h_oth_doc_txt.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].oth_doc_txt.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].relationship)
		document.DischargeCheckListMain.h_relationship.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].relationship.value;
		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].rel_date_time)
		document.DischargeCheckListMain.h_rel_date_time.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].rel_date_time.value;

		if(parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].rem_lv_ward)
			document.DischargeCheckListMain.h_rem_lv_ward.value = parent.DischargeCheckList_frame2.DischargeCheckListTab5_frame2.document.forms[0].rem_lv_ward.value;
		}
	}
}

/* Addition from DischargeCheckListButton.jsp */

function callPrint()
{
	var patient_age = parent.DischargeCheckList_frame1.document.forms[0].patient_age.value;
	var p_report_id;

	if(patient_age<=12)
		p_report_id = "IPBDCLPD";
	else
		p_report_id = "IPBDISCL";

	var p_facility_id	=  parent.DischargeCheckList_frame1.document.forms[0].facility_id.value;
	var p_user_name		= parent.DischargeCheckList_frame1.document.forms[0].p_user_name.value;
	var p_encounter_id	= parent.DischargeCheckList_frame1.document.forms[0].p_encounter_id.value;

	//parent.DischargeCheckList_frame1.document.forms[0].action = "../../eCommon/jsp/report_options.jsp?p_module_id=IP&p_report_id='"+p_report_id+"'&p_user_name='"+p_user_name+"'&p_facility_id='"+p_facility_id+"'&p_encounter_id='"+p_encounter_id+"'";

	var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='dummy1_form' id='dummy1_form' action='../../eCommon/jsp/report_options.jsp'><input type='hidden' name='p_module_id' id='p_module_id' value='IP'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type='hidden' name='p_report_id' id='p_report_id' value='"+p_report_id+"'><input type='hidden' name='p_user_name' id='p_user_name' value='"+p_user_name+"'><input type='hidden' name='p_encounter_id' id='p_encounter_id' value='"+p_encounter_id+"'></form></body></html>";

	parent.frames[4].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[4].document.dummy1_form.submit();

}
function compareSystemDate1(calid)
{
	if (calid.value != "" || calid.value != '' )
	{
		var max_trn_date_time = parent.parent.frames[1].document.forms[0].max_trn_date_time.value;
		var greg_informedDateTime = convertDate(calid.value,'DMYHM',localeName,'en');
		var greg_system_date_time = convertDate(parent.parent.frames[1].document.forms[0].system_date_display.value,'DMYHM',localeName,'en');

		if(!isBefore(greg_informedDateTime,greg_system_date_time,'DMYHM','en'))
		{
			var error = getMessage('DATE1_GT_DATE2','IP');
			error = error.replace('$',getLabel("Common.InformedDate/Time.label","Common"));
			error = error.replace('#',getLabel("Common.SystemDateTime.label","Common"));
			alert(error);	
			calid.value= "";
			calid.select();
			calid.focus;
			return false;
		}
		if(isBefore(greg_informedDateTime,parent.parent.frames[1].document.forms[0].admission_date_time.value,'DMYHM','en'))
		{
			var error = getMessage('DATE1_LT_DATE2','IP');
			error = error.replace('$',getLabel("Common.InformedDate/Time.label","Common"));
			error = error.replace('#',getLabel("Common.AdmissionDateTime.label","Common"));
			alert(error);
			calid.value= "";
			calid.select();
			calid.focus;
			return false;
		}
		if(!isBefore(max_trn_date_time,greg_informedDateTime,'DMYHM','en')){
			 var error = getMessage('DATE1_LT_DATE2','IP');
			 var last_encounter = getLabel("eIP.LastTransactionDateTime.label","IP");
			 error = error.replace('$',getLabel("Common.InformedDate/Time.label","Common"));
			 error = error.replace('#',last_encounter);
			 alert(error);
   			 calid.value= "";
			 calid.select();
 			return false;

		}

	}
}
 //Added by Mano on 19-Mar-2018 aganist ML-MMOH-CRF-1049
 
function calculateDuration(obj)
{
	var fromDt = document.forms[0].cert_from_date.value;
	var toDt =  document.forms[0].cert_to_date.value;
	if(fromDt == "" || toDt == "" )
	{
		document.forms[0].duration.value = "";
	}
	else
	{
	var fromDate = fromDt.split("/");
	var cert_from_date = new Date(fromDate[2],fromDate[1] - 1,fromDate[0]);
	var toDate = toDt.split("/");
	var cert_to_date = new Date(toDate[2],toDate[1] - 1,toDate[0]);
	var difference = Math.abs(cert_to_date.getTime() - cert_from_date.getTime());
	var duration = Math.ceil(difference/(1000*3600*24)) + 1;//Modified by Thamizh selvi on 2nd Aug 2018 against ML-MMOH-SCF-1044 
	if(duration<1000)
	{
    document.forms[0].duration.value = duration;
	}
	else
	{
	if(obj.name=='cert_from_date')
	{
    alert(getMessage("DISCR_CERT_DR_GT_DAYS","IP"));	
	document.forms[0].cert_from_date.value = "";
	}
	if(obj.name=='cert_to_date')
	{
	alert(getMessage("DISCR_CERT_DR_GT_DAYS","IP"));	
	document.forms[0].cert_to_date.value = "";
	}	
	document.forms[0].duration.value = "";
	}
	}}
//End of ML-MMOH-CRF-1049	

/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
function enableDisableFields(obj)
{
	if(obj.name=='iv_remove_chk')
	{
		if(obj.checked)
		{
			document.forms[0].iv_removed_by.disabled = false;
			document.forms[0].iv_removed_dt.disabled = false;
			document.getElementById('iv_removed_dt_img').disabled = false;
			document.forms[0].iv_catheters_chk.disabled = true;
			document.forms[0].iv_remarks.disabled = false;
		}
		else
		{
			document.forms[0].iv_removed_by.disabled = true;
			document.forms[0].iv_removed_by.value="";
			document.forms[0].iv_removed_dt.disabled = true;
			document.forms[0].iv_removed_dt.value="";
			document.getElementById('iv_removed_dt_img').disabled = true;
			document.forms[0].iv_catheters_chk.disabled = false;
			document.forms[0].iv_catheters_chk.value="";
			document.forms[0].iv_remarks.disabled = true;
			document.forms[0].iv_remarks.value="";
		}
	}
	else if(obj.name=='tubes_remove_chk')
	{
		if(obj.checked)
		{
			document.forms[0].tubes_removed_by.disabled = false;
			document.forms[0].tubes_removed_dt.disabled = false;
			document.getElementById('tubes_removed_dt_img').disabled = false;
			document.forms[0].tubes_chk.disabled = true;
			document.forms[0].tubes_remarks.disabled = false;
		}
		else
		{
			document.forms[0].tubes_removed_by.disabled = true;
			document.forms[0].tubes_removed_by.value="";
			document.forms[0].tubes_removed_dt.disabled = true;
			document.forms[0].tubes_removed_dt.value="";
			document.getElementById('tubes_removed_dt_img').disabled = true;
			document.forms[0].tubes_chk.disabled = false;
			document.forms[0].tubes_chk.value="";
			document.forms[0].tubes_remarks.disabled = true;
			document.forms[0].tubes_remarks.value="";
		}
	}
	else if(obj.name=='drg_remove_chk')
	{
		if(obj.checked)
		{
			document.forms[0].drg_removed_by.disabled = false;
			document.forms[0].drg_removed_dt.disabled = false;
			document.getElementById('drg_removed_dt_img').disabled = false;
			document.forms[0].drg_chk.disabled = true;
			document.forms[0].drg_remarks.disabled = false;
		}
		else
		{
			document.forms[0].drg_removed_by.disabled = true;
			document.forms[0].drg_removed_by.value="";
			document.forms[0].drg_removed_dt.disabled = true;
			document.forms[0].drg_removed_dt.value="";
			document.getElementById('drg_removed_dt_img').disabled = true;
			document.forms[0].drg_chk.disabled = false;
			document.forms[0].drg_chk.value="";
			document.forms[0].drg_remarks.disabled = true;
			document.forms[0].drg_remarks.value="";
		}
	}
	else if(obj.name=='ngt_remove_chk')
	{
		if(obj.checked)
		{
			document.forms[0].ngt_tube_removed_by.disabled = false;
			document.forms[0].ngt_tube_removed_dt.disabled = false;
			document.getElementById('ngt_tube_removed_dt_img').disabled = false;
			document.forms[0].ngt_tube_chk.disabled = true;
			document.forms[0].ngt_remarks.disabled = false;
		}
		else
		{
			document.forms[0].ngt_tube_removed_by.disabled = true;
			document.forms[0].ngt_tube_removed_by.value="";
			document.forms[0].ngt_tube_removed_dt.disabled = true;
			document.forms[0].ngt_tube_removed_dt.value="";
			document.getElementById('ngt_tube_removed_dt_img').disabled = true;
			document.forms[0].ngt_tube_chk.disabled = false;
			document.forms[0].ngt_tube_chk.value="";
			document.forms[0].ngt_remarks.disabled = true;
			document.forms[0].ngt_remarks.value="";
		}
	}
	else if(obj.name=='urn_remove_chk')
	{
		if(obj.checked)
		{
			document.forms[0].urn_removed_by.disabled = false;
			document.forms[0].urn_removed_dt.disabled = false;
			document.getElementById('urn_removed_dt_img').disabled = false;
			document.forms[0].urn_chk.disabled = true;
			document.forms[0].urn_remarks.disabled = false;
		}
		else
		{
			document.forms[0].urn_removed_by.disabled = true;
			document.forms[0].urn_removed_by.value="";
			document.forms[0].urn_removed_dt.disabled = true;
			document.forms[0].urn_removed_dt.value="";
			document.getElementById('urn_removed_dt_img').disabled = true;
			document.forms[0].urn_chk.disabled = false;
			document.forms[0].urn_chk.value="";
			document.forms[0].urn_remarks.disabled = true;
			document.forms[0].urn_remarks.value="";
		}
	}
	else if(obj.name=='sto_remove_chk')
	{
		if(obj.checked)
		{
			document.forms[0].sto_removed_by.disabled = false;
			document.forms[0].sto_removed_dt.disabled = false;
			document.getElementById('sto_removed_dt_img').disabled = false;
			document.forms[0].sto_chk.disabled = true;
			document.forms[0].sto_remarks.disabled = false;
		}
		else
		{
			document.forms[0].sto_removed_by.disabled = true;
			document.forms[0].sto_removed_by.value="";
			document.forms[0].sto_removed_dt.disabled = true;
			document.forms[0].sto_removed_dt.value="";
			document.getElementById('sto_removed_dt_img').disabled = true;
			document.forms[0].sto_chk.disabled = false;
			document.forms[0].sto_chk.value="";
			document.forms[0].sto_remarks.disabled = true;
			document.forms[0].sto_remarks.value="";
		}
	}
	else if(obj.name=='dressing_remove_chk')
	{
		if(obj.checked)
		{
			document.forms[0].dressing_removed_by.disabled = false;
			document.forms[0].dressing_removed_dt.disabled = false;
			document.getElementById('dressing_removed_dt_img').disabled = false;
			document.forms[0].dressing_chk.disabled = true;
			document.forms[0].dressing_remarks.disabled = false;
		}
		else
		{
			document.forms[0].dressing_removed_by.disabled = true;
			document.forms[0].dressing_removed_by.value="";
			document.forms[0].dressing_removed_dt.disabled = true;
			document.forms[0].dressing_removed_dt.value="";
			document.getElementById('dressing_removed_dt_img').disabled = true;
			document.forms[0].dressing_chk.disabled = false;
			document.forms[0].dressing_chk.value="";
			document.forms[0].dressing_remarks.disabled = true;
			document.forms[0].dressing_remarks.value="";
		}
	}
	/*Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218*/
	else if(obj.name=='itemloan_remove_chk')
	{
		if(obj.checked)
		{
			document.forms[0].itemloan_removed_by.disabled = false;
			document.forms[0].itemloan_removed_dt.disabled = false;
			document.getElementById('itemloan_removed_dt_img').disabled = false;
			document.forms[0].itemloan_chk.disabled = true;
			document.forms[0].itemloan_remarks.disabled = false;
		}
		else
		{
			document.forms[0].itemloan_removed_by.disabled = true;
			document.forms[0].itemloan_removed_by.value="";
			document.forms[0].itemloan_removed_dt.disabled = true;
			document.forms[0].itemloan_removed_dt.value="";
			document.getElementById('itemloan_removed_dt_img').disabled = true;
			document.forms[0].itemloan_chk.disabled = false;
			document.forms[0].itemloan_chk.value="";
			document.forms[0].itemloan_remarks.disabled = true;
			document.forms[0].itemloan_remarks.value="";
		}
	}
	else if(obj.name=='others_remove_chk')
	{
		if(obj.checked)
		{
			document.forms[0].others_removed_by.disabled = false;
			document.forms[0].others_removed_dt.disabled = false;
			document.getElementById('others_removed_dt_img').disabled = false;
			document.forms[0].others_chk.disabled = true;
			document.forms[0].others_remarks.disabled = false;
		}
		else
		{
			document.forms[0].others_removed_by.disabled = true;
			document.forms[0].others_removed_by.value="";
			document.forms[0].others_removed_dt.disabled = true;
			document.forms[0].others_removed_dt.value="";
			document.getElementById('others_removed_dt_img').disabled = true;
			document.forms[0].others_chk.disabled = false;
			document.forms[0].others_chk.value="";
			document.forms[0].others_remarks.disabled = true;
			document.forms[0].others_remarks.value="";
		}
	}
	/*End ML-MMOH-CRF-1218*/
}
/*End ML-MMOH-CRF-1142*/

/*Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218*/
function enableDisableDateField(obj)
{
	var call_function = document.forms[0].call_function.value;
	if(document.forms[0].cert_num.value == "")
	{
		if(call_function != "VIEW_DISCHARGE_CHECKLIST")
		{
			document.forms[0].cert_from_date.disabled = true;
			document.forms[0].cert_from_date.value="";
			document.forms[0].cert_to_date.disabled = true;
			document.forms[0].cert_to_date.value="";
			document.forms[0].duration.value="";
			document.getElementById('cert_from_date_img').disabled = true;
			document.getElementById('cert_to_date_img').disabled = true;
			if(document.forms[0].isAutoPopDurationApplyn.value == "true")
			{
			document.getElementById('cert_from_date_mand').style.visibility = 'hidden';
			document.getElementById('cert_to_date_mand').style.visibility = 'hidden';
			}else
			{
			document.forms[0].duration.disabled = true;
			document.forms[0].duration_dmy.disabled = true;
			document.forms[0].duration_dmy.value="D";
			}
		}
	}else
	{
		if(call_function != "VIEW_DISCHARGE_CHECKLIST")
		{
			document.forms[0].cert_from_date.disabled = false;
			document.forms[0].cert_to_date.disabled = false;
			document.getElementById('cert_from_date_img').disabled = false;
			document.getElementById('cert_to_date_img').disabled = false;
			if(document.forms[0].isAutoPopDurationApplyn.value == "true")
			{
			document.getElementById('cert_from_date_mand').style.visibility = 'visible';
			document.getElementById('cert_to_date_mand').style.visibility = 'visible';
			}else
			{
			document.forms[0].duration.disabled = false;
			document.forms[0].duration_dmy.disabled = false;
			}
		}
	}
}
/*End ML-MMOH-CRF-1218*/
	
	
	
	

