
function reset(){
	frames[1].location.reload();
}
function apply(){

	var fields = new Array ( frames[1].document.forms[0].cboReason) ;

	var names = new Array ( getLabel("eOA.ReasonforForceClosing.label","OA"));
	if(!f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		
	}else{
		f_query_add_mod.document.forms[0].submit();
	}
}

async function callPatientSearch(){
 var patientId= await PatientSearch();
 if (patientId!=null && patientId!='')
  document.forms[0].patientid.value=patientId;
}

function changeCase(Obj)
      	{
      		Obj.value=Obj.value.toUpperCase();
			if(Obj.value !="")
			{
				var HTML="<html><body onKeyDown = 'lockKey()'><form name='chkpatient_id' id='chkpatient_id' method='post'  action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='from' id='from' value='chkpatient_id_valid'><input type=hidden name='patient_id' id='patient_id' value='"+Obj.value+"'></form></body></html>";
				parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTML);
				parent.messageFrame.document.chkpatient_id.submit();
				
			}
      	
      	}
async function open_force_close_waitlist(){
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		var locale=document.forms[0].locale.value;
		var sql="Select Contact_Reason_Code code, Contact_Reason description from AM_CONTACT_REASON_lang_vw where CANCEL_WAIT_LIST_YN='Y' and Eff_Status = 'E' and language_id='"+locale+"' and upper(Contact_Reason_Code) like upper(?) and upper(Contact_Reason) like upper(?)" ;
		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].cboReason.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 

		retVal = await CommonLookup( getLabel("eOA.ReasonforForceClosing.label","OA"), argumentArray );
		var arr=new Array();

		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
			document.forms[0].cboReason.value=desc;
			document.forms[0].reason_code.value=code;
		}else
		{
			document.forms[0].cboReason.value="";
			document.forms[0].reason_code.value="";
			return;
		}

}

