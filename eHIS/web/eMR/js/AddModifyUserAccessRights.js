function create() {
	f_query_add_mod.location.href = "../../eMR/jsp/AddModifyUserAccessRights.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eMR/jsp/AddModifyUserAccessRightsQueryCriteria.jsp?function=useraccessrights";
}


 function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}

function checkLen(obj)
{
	var errors = "" ;
	var len=parseInt(obj.value.length)
	if (len <5)
	{
	    errors = getMessage('PWD_MIN_FIVE_CH','SM') ;
	    obj.focus();
	    obj.select();
	    messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
		return false;
	}
	return true;
}


/****On Applying****/

function apply() {
		if (! (checkIsValidForProceed()) )
    {
			message  = getMessage("APPLY_NOT_VALID",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
		
    } 
var canBeSubmitted=false;
if(f_query_add_mod.document.getElementById("function_name").value=='modify')
	var fields = new Array (f_query_add_mod.useraccessrights_form.appl_user_name,f_query_add_mod.useraccessrights_form.user_fac_id_desc);

	else
var fields = new Array (f_query_add_mod.useraccessrights_form.appl_user_id_desc,f_query_add_mod.useraccessrights_form.user_fac_id);

var names =  new Array (getLabel("Common.user.label","Common"),getLabel("Common.facility.label","Common"));
if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
{

if(f_query_add_mod.document.useraccessrights_form.appl_user_id.value.length>0)
{
 	if(	f_query_add_mod.document.forms[0].SD_record_for_cons_patient.checked||
		f_query_add_mod.document.forms[0].SD_view_of_cons_patient.checked||
		f_query_add_mod.document.forms[0].SD_record_for_oth_patient.checked||
		f_query_add_mod.document.forms[0].SD_view_of_oth_patient.checked
		){
		if(checkLen(f_query_add_mod.document.forms[0].sensitive_password)&&checkLen(f_query_add_mod.document.forms[0].sensitive_confirm_password))
		{	
			if(f_query_add_mod.document.forms[0].sensitive_password.value!=f_query_add_mod.document.forms[0].sensitive_confirm_password.value)
			{
				f_query_add_mod.document.forms[0].sensitive_password.select();
				f_query_add_mod.document.forms[0].sensitive_password.focus();
				messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage('PWD_MISMATCH','SM');
				return false;
			}
		}
		else
			return false;
		canBeSubmitted=true;
	}
	if(	f_query_add_mod.document.forms[0].HR_record_for_cons_patient.checked||
		f_query_add_mod.document.forms[0].HR_view_of_cons_patient.checked||
		f_query_add_mod.document.forms[0].HR_record_for_oth_patient.checked||
		f_query_add_mod.document.forms[0].HR_view_of_oth_patient.checked
	  ){
		if(checkLen(f_query_add_mod.document.forms[0].highrisk_password)&&checkLen(f_query_add_mod.document.forms[0].highrisk_confirm_password))
		{
			if(f_query_add_mod.document.forms[0].highrisk_password.value!=f_query_add_mod.document.forms[0].highrisk_confirm_password.value)
			{
				messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage('PWD_MISMATCH','SM');
  				f_query_add_mod.document.forms[0].highrisk_password.select();
  				f_query_add_mod.document.forms[0].highrisk_password.focus();
				return false;
			}
		}
		else
			return false;
		canBeSubmitted=true;
	}
	
	//if(canBeSubmitted){
		f_query_add_mod.document.useraccessrights_form.hidden_sensitive_password.value=f_query_add_mod.document.useraccessrights_form.sensitive_password.value;
		f_query_add_mod.document.useraccessrights_form.hidden_highrisk_password.value=f_query_add_mod.document.useraccessrights_form.highrisk_password.value;
		f_query_add_mod.document.useraccessrights_form.submit();
	//}
	/*else
	{
		var error = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace("$",getLabel("Common.user.label","Common"));
   		messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;  
	}*/
 }								 
 
 }
 return false;
}


function onSuccess() {
f_query_add_mod.location.reload();
}

function reset()
{
	if(f_query_add_mod.document.forms[0])
  	{
	   f_query_add_mod.document.forms[0].reset();

	   if(f_query_add_mod.document.forms[0].hidden_highrisk_password)
		{
			   f_query_add_mod.checkSDPwd();
			   f_query_add_mod.checkHRPwd();
		   if(f_query_add_mod.document.forms[0].user_fac_id)
		   {
			   var selected = f_query_add_mod.document.forms[0].user_fac_id;			   
			   if (selected.type!='hidden')
			   {
					while (selected.options.length > 0 )
						selected.remove(selected.options[0]);
					var element =f_query_add_mod.document.createElement('OPTION');
					element.text = '-----'+getLabel("Common.defaultSelect.label","Common")+'----- ';
					element.value= '';
					f_query_add_mod.document.forms[0].user_fac_id.add(element);
				   
					
			   }	   
		   }
		}
	}

}

//added

function checkSDPwd()
{
	if(	document.forms[0].SD_record_for_cons_patient.checked||
		document.forms[0].SD_view_of_cons_patient.checked||
		document.forms[0].SD_record_for_oth_patient.checked||
		document.forms[0].SD_view_of_oth_patient.checked
	  ){
		document.getElementById("sdimgpwd").style.visibility="visible"
		document.getElementById("sdimgcpwd").style.visibility="visible"
		document.forms[0].sensitive_password.readOnly=false;
		document.forms[0].sensitive_confirm_password.readOnly=false;
	}else{
		document.forms[0].sensitive_password.readOnly=true;
		document.forms[0].sensitive_password.value="";
		document.forms[0].sensitive_confirm_password.readOnly=true;
		document.forms[0].sensitive_confirm_password.value="";
		document.getElementById("sdimgpwd").style.visibility="hidden"
		document.getElementById("sdimgcpwd").style.visibility="hidden"
	}
}

function checkHRPwd()
{
	if(	document.forms[0].HR_record_for_cons_patient.checked||
		document.forms[0].HR_view_of_cons_patient.checked||
		document.forms[0].HR_record_for_oth_patient.checked||
		document.forms[0].HR_view_of_oth_patient.checked
	  ){
		document.getElementById("hrimgpwd").style.visibility="visible"
		document.getElementById("hrimgcpwd").style.visibility="visible"
		document.forms[0].highrisk_password.readOnly=false;
		document.forms[0].highrisk_confirm_password.readOnly=false;
	}else{
		document.forms[0].highrisk_password.readOnly=true;
		document.forms[0].highrisk_password.value="";
		document.forms[0].highrisk_confirm_password.readOnly=true;
		document.forms[0].highrisk_confirm_password.value="";
		document.getElementById("hrimgpwd").style.visibility="hidden"
		document.getElementById("hrimgcpwd").style.visibility="hidden"
	}
}


	async function searchCode(obj,target,target_id)
		{
				var retVal = 	new String();
				var dialogHeight= "28vh" ;
				var dialogWidth	= "43vw" ;
				var dialogLeft="500";
				var status = "no";
				var arguments	= "" ;
				var sql="";
				var search_code="";
				var search_desc="";
				var dispDescFirst="dispDescFirst";
				var tit=getLabel("Common.user.label","Common");
				sql="Select appl_user_id,INITCAP(appl_user_name) appl_user_name from SM_APPL_USER ";
				
				var search_code="appl_user_id";				
				var search_desc="appl_user_name";
				
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status+";dialogLeft:"+dialogLeft+";";
				retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst="+dispDescFirst,arguments,features);
				var arr=new Array();
				if (!(retVal == null))
				{
				var ret1=unescape(retVal);
				arr=ret1.split("::");
				target.value=arr[0];
				target_id.value=arr[1];
			var selected = document.forms[0].user_fac_id;
			while ( selected.options.length > 0 )
				selected.remove(selected.options[0]);
			var userId = target_id.value;
		       var xmlDoc="";
		       var xmlHttp = new XMLHttpRequest()
		       xmlStr ="<root><SEARCH userId=\""+userId+"\" /></root>"
		       xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		       xmlHttp.open("POST","PopulateFacility.jsp",false)
		       xmlHttp.send(xmlDoc)
		       responseText=xmlHttp.responseText
		       responseText = trimString(responseText)
		       eval(responseText) 
				}
		}


		
async function beforeUserID(target)
{
	
	//if(target.value!='')	
	if(trimString(target.value)!=''){
		await commonLookupUserID(document.useraccessrights_form.appl_user_id_desc,document.useraccessrights_form.appl_user_button);		
	}
	else
	{
		var selected = document.useraccessrights_form.user_fac_id;
		while(selected.options.length > 0)
			selected.remove(selected.options[0]);
		var element =parent.frames[0].document.createElement('OPTION');
		element.text = '   ----- Select -----  ';
		element.value= '';
		document.forms[0].user_fac_id.add(element);
	}
	
}

async function commonLookupUserID(target,obj)
{
		
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		//Modified by N Munisekhar on 22-Jan-2013 against SKR-SCF-0760 [IN:037401] 
		
		//Modified by Ashwini on 28-Apr-2021 for MOHE-SCF-0025
		var sql = "SELECT appl_user_id code, INITCAP (appl_user_name) description FROM sm_appl_user WHERE UPPER (appl_user_id) LIKE UPPER (?) AND UPPER (appl_user_name) LIKE UPPER (?) AND eff_status = 'E' " ;

		argumentArray[0] = sql ;
		//end SKR-SCF-0760 [IN:037401] 
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2"; 
		argumentArray[5] = 	target.value;
		argumentArray[6] = CODE_DESC_LINK ;
		argumentArray[7] = CODE_DESC ;
		retVal = await CommonLookup(getLabel("Common.user.label","Common"), argumentArray );
		
		if(retVal != null && retVal != "")
		{
			if(retVal.length == 1){
				retVal = retVal[0].split(',');
			} 

			target.value = retVal[1] ;
			document.useraccessrights_form.appl_user_id.value = retVal[0];
			document.useraccessrights_form.appl_user_id_desc.value = retVal[1];
			var selected = document.useraccessrights_form.user_fac_id;
			while(selected.options.length > 0)
				selected.remove(selected.options[0]);
			var xmlDoc="";
		    var xmlHttp = new XMLHttpRequest()
			
			xmlStr ="<root><SEARCH userId=\""+retVal[0]+"\" /></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		    xmlHttp.open("POST","PopulateFacility.jsp",false)
		    xmlHttp.send(xmlDoc)
		    responseText=xmlHttp.responseText
		    responseText = trimString(responseText)
		    responseText = responseText.replace(/<\/?[^>]+(>|$)/g, "");
		    eval(responseText) ;
		    
		}
		else
		{
			target.value = "" ;
			document.useraccessrights_form.appl_user_id.value = "";
			document.useraccessrights_form.appl_user_id_desc.value ="";
		}
	
	return;
}

