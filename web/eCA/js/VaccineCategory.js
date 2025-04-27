/*
------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name	Description
------------------------------------------------------------------------------------------------------------------------------------
?           100				?				created
05/12/2017	IN065683		Ramesh G								After create vaccine category as age specific, System 																			automatically add this vaccine category in manage 																				immunization for all patients.
23/02/2023  41650           Twinkle Shah    	                    MMS-JU-CRF-0015.1
04/04/2023  43290           Twinkle Shah    	                    MMS-JU-CRF-0015.1
12/04/2023  43370           Twinkle Shah   14/04/2023  Ramesh Goli   CA-Immunization Code Setup-Vaccine Category
------------------------------------------------------------------------------------------------------------------------------------
*/
function create()
{
	
	f_query_add_mod.location.href='../../eCA/jsp/VaccineCategoryAddModify.jsp?mode=insert';
}

function query()
{
	
	f_query_add_mod.location.href='../../eCA/jsp/VaccineCategoryQueryCriteria.jsp';
}

function apply()
{

	if (f_query_add_mod.document.forms[0])
	{
		fields = new Array (
								f_query_add_mod.document.forms[0].vaccine_Category_id,
								f_query_add_mod.document.forms[0].vaccine_long_desc,
								f_query_add_mod.document.forms[0].vaccine_short_desc
								);

		names = new Array (
								 f_query_add_mod.getLabel("eCA.CategoryId.label",'CA'),
								 f_query_add_mod.getLabel("Common.longdescription.label",'COMMON'),
								 f_query_add_mod.getLabel("Common.shortdescription.label",'COMMON')
								);

		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{			
			
			var mode				=	f_query_add_mod.document.forms[0].mode.value;
						
			var fields1 = new Array (f_query_add_mod.document.forms[0].vaccine_Category_id);
			var names1 = new Array (f_query_add_mod.getLabel("eCA.CategoryId.label",'CA'));
					
			if (f_query_add_mod.SpecialCharCheck (fields1,names1,messageFrame,'M','MstCodeError.jsp'))
			{
				f_query_add_mod.document.vaccine_category_form.allow_multiple_yn.disabled=false;
				f_query_add_mod.document.vaccine_category_form.chkAdhocAgeSpecific.disabled=false;
				f_query_add_mod.document.vaccine_category_form.adh_yn.disabled=false;
				f_query_add_mod.document.forms[0].submit();		
			}
		}
	}
	else
	{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=''&err_value=2";
	}
	//return false;		

}

function deleterecord()
{
	if(f_query_add_mod.document.forms[0]!=null )
	{
		if(f_query_add_mod.document.forms[0].mode != null)
		{
			if(f_query_add_mod.document.forms[0].mode.value=="insert"){
			//commontoolbarFrame.location.reload();
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+messageArray["RECORD_CANNOT_DELETE"]
			}
			else{
				if(window.confirm(getMessage("DELETE_RECORD","Common")) == true)
				{
					f_query_add_mod.document.vaccine_category_form.mode.value='delete';
					f_query_add_mod.document.vaccine_category_form.submit();     
				}
				else
				{
					commontoolbarFrame.location.reload();
				}
			}
		}
		else
		{
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
}


function onSuccess()
{
	
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eCA/jsp/VaccineCategoryAddModify.jsp?mode=insert';
	else if(f_query_add_mod.document.forms[0].mode.value=="update")
	       f_query_add_mod.location.reload();
	else     
	      f_query_add_mod.location.href='../../eCommon/html/blank.html';

}


function OnAdhocChange(obj)
{
	var chkAllowMul = document.vaccine_category_form.allow_multiple_yn;
	if(obj.checked)
	{
		document.vaccine_category_form.adh_yn.value = 'Y';
		document.vaccine_category_form.chkAdhocAgeSpecific.disabled = true;
		document.vaccine_category_form.chkAdhocAgeSpecific.checked = false;
		document.vaccine_category_form.ageSpecificYN.value = 'N';
		document.vaccine_category_form.ageSpecificYN.value = 'N';
		chkAllowMul.disabled = false;
		chkAllowMul.value = "N";
	}
	else
	{
		document.vaccine_category_form.adh_yn.value = 'N';
		document.vaccine_category_form.chkAdhocAgeSpecific.disabled = false;
	}
//	alert(document.vaccine_category_form.adh_yn.value);
}

function OnMultipleChange(obj)
{
	if(obj.checked)
	{
		document.vaccine_category_form.multiple_yn.value = 'Y'
	}
	else
	{
		document.vaccine_category_form.multiple_yn.value = 'N'
	}

}

function reset()
{
	if(f_query_add_mod.document.forms[0]!=null)
	f_query_add_mod.document.forms[0].reset();

}

function CheckForSpecCharsNoCaps(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}

function setAdhocAgeSpec(obj)
{
	var chkAllowMul = document.vaccine_category_form.allow_multiple_yn;
	if (obj.checked)
	{
		document.vaccine_category_form.ageSpecificYN.value = 'Y';		
		chkAllowMul.value = 'N';
		chkAllowMul.disabled = true;
		chkAllowMul.checked = false;
		document.vaccine_category_form.multiple_yn.value = 'N';//IN065683
	}
	else
	{
		document.vaccine_category_form.ageSpecificYN.value = 'N';
		chkAllowMul.disabled = false;
		chkAllowMul.value = 'N';
	}
}

function fnModifyAgegroup(obj,age_group_old)
{
	validateAgeSpecific(); /* 41650 */
	var vacc_categ_id = document.getElementById("vaccine_Category_id").value;
	if (obj.value!= "" && obj.value != age_group_old)
	{
		var CallFrom = "AGE_GRP_APPL";
		xmlStr ="<root><SEARCH ";
		xmlStr += "CALLFROM=\""+ CallFrom +"\" " ;
		xmlStr += "AGE_GROUP_NEW=\""+ obj.value +"\" " ;		
		xmlStr += "AGE_GROUP_OLD=\""+ age_group_old +"\" " ;		
		xmlStr += "VACC_CATEG_ID=\""+ vacc_categ_id +"\" " ;		
		xmlStr +=" /></root>" ;		
		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc = "" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "VaccineCategoryIntermediate.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);	
	}
}
//Start. 41650
function validateAgeSpecific()
{
	var chkAllowMul = document.vaccine_category_form.allow_multiple_yn; //43370 
	var age_group_disabling=document.vaccine_category_form.age_group.value;	
	if(age_group_disabling!="")
	{
		document.vaccine_category_form.chkAdhocAgeSpecific.disabled = false;
	/*	document.vaccine_category_form.chkAdhocAgeSpecific.checked = false;  
		document.vaccine_category_form.ageSpecificYN.value = "N";    43290 */		
		document.vaccine_category_form.adhoc_yn.disabled = true;
		document.vaccine_category_form.adhoc_yn.checked = false;
		document.vaccine_category_form.adh_yn.value = "N";
	}
	else
	{
		document.vaccine_category_form.chkAdhocAgeSpecific.disabled = true;
		document.vaccine_category_form.chkAdhocAgeSpecific.checked = false;
		document.vaccine_category_form.ageSpecificYN.value = "N";
		document.vaccine_category_form.adhoc_yn.disabled = false;
	/*	document.vaccine_category_form.adhoc_yn.checked = false; 
		document.vaccine_category_form.adh_yn.value = "N"; 43290 */ 
		chkAllowMul.disabled = false; //43370 
	}
	
}

//end 41650
