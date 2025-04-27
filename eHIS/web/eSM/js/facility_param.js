function create() {

		
	f_query_add_mod.location.href = "../../eSM/jsp/facility_param_form.jsp?operation=insert" ;
}

function query() {
	f_query_add_mod.location.href ="../../eSM/jsp/facility_param.jsp?operation=query" ;
}

function apply() {
	
	var err ="" ;
	if(f_query_add_mod.document.facility_param_form!=null){

	var cnt = f_query_add_mod.document.facility_param_form.cntRec.value;
	var fields = "";
	var names = "";
	/*Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132*/
	var isGSTCodeApplicable = f_query_add_mod.document.facility_param_form.isGSTCodeApplicable.value;
	var function_name = f_query_add_mod.document.facility_param_form.function_name.value;
	var gstin_facility = "";

	if (cnt>0)
	{	
		/*Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132*/
		if(isGSTCodeApplicable == "true")
		{
		gstin_facility = f_query_add_mod.document.facility_param_form.gstin_facility.value;
		fields = new Array ( f_query_add_mod.document.facility_param_form.facility_id,
					 f_query_add_mod.document.facility_param_form.gstin_facility,
					 f_query_add_mod.document.facility_param_form.acc_entity_id,
					 f_query_add_mod.document.facility_param_form.facility_name,
					 f_query_add_mod.document.facility_param_form.hcare_setting_type_code
					);	
		names = new Array ( getLabel("Common.identification.label","Common"),
						getLabel("Common.GoodsandServicesTaxID.label","Common"), getLabel("Common.AccountingEntity.label","Common"),
					getLabel("Common.name.label","Common"), getLabel("Common.HealthcareSettingType.label","Common")
					);
		}else
		{
		fields = new Array ( f_query_add_mod.document.facility_param_form.facility_id,
					 f_query_add_mod.document.facility_param_form.acc_entity_id,
					 f_query_add_mod.document.facility_param_form.facility_name,
					 f_query_add_mod.document.facility_param_form.hcare_setting_type_code
					);	
		names = new Array ( getLabel("Common.identification.label","Common"), getLabel("Common.AccountingEntity.label","Common"),
					getLabel("Common.name.label","Common"), getLabel("Common.HealthcareSettingType.label","Common")
					);	
		}
	}
	else
	{	
		/*Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132*/
		if(isGSTCodeApplicable == "true")
		{
		gstin_facility = f_query_add_mod.document.facility_param_form.gstin_facility.value;
		fields = new Array ( f_query_add_mod.document.facility_param_form.facility_id,
					 f_query_add_mod.document.facility_param_form.gstin_facility,
					 f_query_add_mod.document.facility_param_form.acc_entity_id,
					 f_query_add_mod.document.facility_param_form.facility_name
					);	
		names = new Array ( getLabel("Common.identification.label","Common"),
						getLabel("Common.GoodsandServicesTaxID.label","Common"), getLabel("Common.AccountingEntity.label","Common"),
						getLabel("Common.name.label","Common")
					);
		}else
		{
		fields = new Array ( f_query_add_mod.document.facility_param_form.facility_id,
					 f_query_add_mod.document.facility_param_form.acc_entity_id,
		f_query_add_mod.document.facility_param_form.facility_name
					);	
		names = new Array ( getLabel("Common.identification.label","Common"), getLabel("Common.AccountingEntity.label","Common"),
					getLabel("Common.name.label","Common")
					);	
		}
	}

	if( f_query_add_mod.checkFieldsofMst( fields, names, messageFrame) )
	{	var field = new Array ( f_query_add_mod.document.facility_param_form.facility_id);	
		var name = new Array ( getLabel("Common.identification.label","Common"));	

		if (f_query_add_mod.SpecialCharCheck (field,name,messageFrame,'M','MstCodeError.jsp'))
		{	
			/*Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132*/
			if (isGSTCodeApplicable == "true")
			{
			gstin_facility = f_query_add_mod.document.facility_param_form.gstin_facility.value;
			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH gstin_facility=\""+gstin_facility+"\" action='validateFacility' /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","../../eSM/jsp/SMIntermediate.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			var GSTINFacility	= trimString(responseText);

			if(function_name == "insert")
			{ 
				if(GSTINFacility > 0 )
				{ 
				var msg = f_query_add_mod.getMessage("CODE_ALREADY_EXISTS","common");
				msg = msg.replace("Record", getLabel("Common.GoodsandServicesTaxID.label","Common"));
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg; 
				return false;
				} else{ 
				f_query_add_mod.document.facility_param_form.submit() ;
				}
			} else if (function_name == "modify")
			{ 
				if (f_query_add_mod.document.facility_param_form.gstin_facility.readOnly == true)
				{ 
					f_query_add_mod.document.facility_param_form.submit() ;
				} else if (f_query_add_mod.document.facility_param_form.gstin_facility.readOnly == false)
				{ 
					if(GSTINFacility > 0 )
					{ 
					var msg = f_query_add_mod.getMessage("CODE_ALREADY_EXISTS","common");
					msg = msg.replace("Record", getLabel("Common.GoodsandServicesTaxID.label","Common"));
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg; 
					return false;
					} else{ 
					f_query_add_mod.document.facility_param_form.submit() ;
					}
				}
			}

			}else{
			//f_query_add_mod.document.facility_param_form.wkstation_iden.disabled = false;
			f_query_add_mod.document.facility_param_form.submit() ;
			}
		}
	}
	}
	else
	{
		 frames[0].location.reload();
	     return false;
	}
}


function reset() {
		
	//f_query_add_mod.document.facility_param_form.reset() ;
	 if(  f_query_add_mod.document.forms[0])
		 f_query_add_mod.document.location.reload();
}

function onSuccess() {

				f_query_add_mod.document.location.reload();
		}

function fac_logo_check(){
		var fac_logo=document.forms[0].fac_logo_url.value;
		var filesplit2 = fac_logo.split("\\");
		document.forms[0].fac_logo_file_name.value=filesplit2[filesplit2.length-1];
		document.forms[0].fac_logo_name_flag.value="Y";

	    if(document.forms[0].fac_logo_url.value!=""){
        var ext = document.forms[0].fac_logo_url.value;
        faclogourl = ext.substring(ext.length-3,ext.length);
        faclogourl = faclogourl.toLowerCase();
        if((faclogourl != 'jpg') && (faclogourl != 'gif')) {
        alert(getMessage('UPLOAD_JPG_OR_GIF_FILE','SM'));
        document.forms[0].fac_logo_file_name.value="";
        var elem = document.getElementById("fac_logo_id");
        elem.parentNode.innerHTML = elem.parentNode.innerHTML;

        return false;
        }
       else
       return true;
	}
}

/*Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132*/
function SpCharChkForFacility(event)
{
	var strCheck = '0123456789abcdefghijlkmnopqrstuvwxyzABCDEFGHIJLKMNOPQRSTUVWXYZ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
} 

function ZeroChkForFacility(obj2){	
	var message1 = getMessage('VALID_GSTIN',"Common");
	if(obj2.value!=""){
		if (obj2.value <= 0){
			alert(message1);
			obj2.value="";
			obj2.focus();		
		}	
	}
}
/*End AMS-CRF-0132*/
