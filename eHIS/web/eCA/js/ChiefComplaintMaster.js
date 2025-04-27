function create()
{
	ChiefComplaintMaster.location.href='../../eCA/jsp/ChiefComplaintMaster.jsp?mode=insert';
}


function apply()
{
if(ChiefComplaintMaster.document.ChiefComplaintMasterfrm != null)	
	{
	var fields = new Array (ChiefComplaintMaster.document.ChiefComplaintMasterfrm.complaint_id,
		ChiefComplaintMaster.document.ChiefComplaintMasterfrm.complaint_desc,
		ChiefComplaintMaster.document.ChiefComplaintMasterfrm.complaint_text,
		ChiefComplaintMaster.document.ChiefComplaintMasterfrm.eff_status);

	var names = new Array ( getLabel("eCA.ComplaintID.label",'CA'),getLabel("eCA.ComplaintDescription.label",'CA'),getLabel("eCA.ComplaintText.label",'CA'),getLabel("Common.enabled.label",'common'));
	if(( ChiefComplaintMaster.checkFieldsofMst( fields, names, messageFrame)) )
		{			

			ChiefComplaintMaster.document.ChiefComplaintMasterfrm.submit();
			
		}
	}
else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
		return false;
	}
}

function query()
{
	ChiefComplaintMaster.location.href='../../eCA/jsp/ChiefComplaintMasterQuery.jsp';
}

function onSuccess()
{

ChiefComplaintMaster.location.reload();
}



function reset()
{
	if(ChiefComplaintMaster.document.forms[0] != null)
		ChiefComplaintMaster.document.forms[0].reset();

}

function CheckForSpecCharsWithSpaceBlur(ObjText)
{
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}


function resetValues()
{
   parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	
}

async function checkSpeciality(spl)
{
	
	if(spl.name=='speciality_desc')
	{
		var target  = document.forms[0].speciality_desc;
		
		if((target.value) == "null" || (target.value ==""))
		{
			return false;			
		}
		else
		{
			await checkSpl();
		}
	}
	else if(spl.name=='specialty_desc_search')
	{		
		await checkSpl();
	}
}

async function checkSpl()
{
		var target	= document.forms[0].speciality_desc;
		var search_code="speciality_code";
		var search_desc="speciality_desc";
		var sql = "select speciality_code code, long_desc description from am_speciality where eff_status = 'E' and upper(speciality_code) like upper(?) and upper(long_desc) like upper(?) order by 2 ";
		var title			= getLabel("Common.speciality.label","COMMON");
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray =await  CommonLookup( title,argArray );
		var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		} 
		if(retArray != null && retArray !="")	
		{
			document.forms[0].speciality_desc.value = arr[1];
			document.forms[0].speciality_code.value = arr[0];
		}
		else
		{
			document.forms[0].speciality_desc.value=arr[1];
			document.forms[0].speciality_code.value=arr[0];
			target.focus();
		}


}



	/*function checkSpeciality()
	{
		var target			= document.forms[0].speciality_desc;
		var retVal			=  new String();
		var dialogTop	= "40";
		var dialogHeight		= "10" ;
		var dialogWidth	= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc			= "";
		var title			= getLabel("Common.speciality.label","COMMON");
		var sql="select speciality_code, long_desc speciality_desc from am_speciality where eff_status = `E`";

		search_code="speciality_code";
		search_desc="long_desc";
		retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
		
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{

			var retVal=unescape(retVal);
		   	arr=retVal.split("::");
			document.forms[0].speciality_desc.value=arr[0];
		   	document.forms[0].speciality_code.value=arr[1];
			document.forms[0].speciality_desc.focus();
		}
		else
		{
			document.forms[0].speciality_desc.value="";
			document.forms[0].speciality_code.value="";
			target.focus();
		}
	}*/


/**
	added by Deepa on 6/7/2010 for IN021830
	restricted special characters in masters for Define Chief Complaint
**/
function CheckForSpecialCharacter(ObjText)
{
	var key = window.event.keyCode;
	if(((key >=33)&&(key <=47))||((key >=58)&&(key <=64))||((key >=91)&&(key <=96))||((key >=123)&&(key <=126))||((key >=145)&&(key <=146)))
		return false;
	else
		return true;
}
