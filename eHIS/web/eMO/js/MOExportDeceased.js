function reset()
{
	f_query_add_mod.location.href='../../eMO/jsp/MOExportDeceasedCriteria.jsp';
	result.location.href='../../eCommon/html/blank.html';
}

function onSuccess()
{
	var errors = getMessage("RECORD_MODIFIED","SM") ;	
	alert(errors);
	top.window.returnValue = "";
	// parent.document.getElementById('dialog_tag').close();
	// top.window.close();
}


function recordExpDec()
{

	if(document.forms[0].exportation_address.value.length>500)
	{
		//mess=getMessage("EXPRT_ADR_EXCEEDS_LMT")
		mess=getMessage("EXPRT_ADR_EXCEEDS_LMT","MO");
		msgeFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+mess ;
		return false;
	}
	


	var fields = new Array();	
	fields[0] = document.forms[0].patient_id;
	fields[1] = document.forms[0].des;
	fields[2] = document.forms[0].doi;
	var names = new Array (getLabel("Common.registrationno.label","Common"),getLabel("Common.Destination.label","Common"),getLabel("Common.issueddatetime.label","Common"));
	if(checkFields( fields, names, parent.frames[1]))
	{
	/*	if (document.forms[0].prnyn.checked==true)
	{*/
	    //callreport();
		/*Added by Mano for ML-MMOH-CRF-0738 Start*/
				
				var relLetterEmbassyApplicable = document.forms[0].relLetterEmbassyApplicable.value;
				
				if(relLetterEmbassyApplicable == "true"){ 
					document.forms[0].release_letter_frm_embassy_yn.value=(document.forms[0].release_letter_frm_embassy_yn.checked)?"Y":"N";
					
				}
				/*End*/
		document.forms[0].submit();
		//parent.parent.document.getElementById("dialog_tag").close(); 

	/*}else{
		document.forms[0].submit();
	}*/
	}
}

function CloseExpDec()
{
	top.window.returnValue = "";
	parent.parent.document.getElementById("dialog_tag").close(); 
}


function changeCase(obj)
{
	  obj.value=obj.value.toUpperCase();
}
    
function cmpdate(obj)
{
    var from = document.forms[0].byrecddate.value;
	var spl=from.split(" ");
    var fromdate = spl[0];
    var todate = obj.value;
	var todate1=todate.split(" ");
	todate = todate1[0];
	if(fromdate.length > 0 && todate.length > 0 ) 
	{
        fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
		if(Date.parse(todt) < Date.parse(fromdt)) 
		{
			alert(getMessage("DATE_CANT_BE_LT_RECEIPT","MO"));
			obj.focus();
		}
	}
}
 
function callreport()
{if(document.forms[0].prnyn.checked)
	{
	var registration_no = document.forms[0].patient_id.value;
	var  facility_id = document.forms[0].facilityId.value;
	var  patid = document.forms[0].patid.value;
	var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH facility_id=\""+facility_id+"\" registration_no=\""+registration_no+"\"/></root>"
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ReportExportationDoc.jsp",false);
	xmlHttp.send(xmlDoc)
	}
	}

function checkmaxlength(obj)
{
	if(document.forms[0].remarks.value.length > 200)
	{
		alert(getMessage("REMARKS_NOT_EXCEED_200_CH","SM"));
		obj.focus();
	}

}




function dtchk(obj)
	{
		if(obj.value != '')
	    {
			if(!doDateTimeChk(obj))
			{
				alert(getMessage("INVALID_DATE_TIME","SM"))
				obj.select();
			return false;
			}
			else
			{
			  
				 parent.dummyFrame.location.href='../../eMO/jsp/ValidateSysdate.jsp?objname='+obj.name+"&bodypart=deceasedregn1"+"&objValue="+escape(obj.value);   

				if((!ValidateDateTime(document.forms[0].byrecddate,obj)))
				{
						alert(getMessage("DATE_CANT_BE_LT_RELEASE","MO"))
						obj.select();
				}
			   	
			}

		}
	}


function firstfocus()
{ 

	if(document.forms[0].first.value=='')
		document.forms[0].patient_id.focus();
    var patientid = document.forms[0].patient_id.value;

}
