/*
--------------------------------------------------------------------------------------------------------------
Date       	Edit History    	Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
18/08/2022	29035				Ramesh G											ML-MMOH-CRF-1763
--------------------------------------------------------------------------------------------------------------
*/ 

function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/MultiLocForPractitioner.jsp';
}
function reset()
{
	f_query_add_mod.location.reload();
}
function resetValues(){
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';	
}
function chekcSplTxt(txtSpl)
{
	if(txtSpl.value == '')
	{
		parent.frames[0].document.forms[0].splCode.value='';
	}
}
async function getSplCode(objCode)
{
	if(objCode.value=='')
	{
		document.forms[0].splCode.value='';
	}else{	
		await populateSpl()
	}	 
}
function resetSearchResult()
{
	parent.frameMultiLocForPractitionerResult.location.href="../../eCA/jsp/blank.jsp";
	resetValues();
}
async function populateSpl()
{  
	var target			= document.forms[0].splName;
	var retVal			=  new String();
	var title			= getLabel("Common.speciality.label","common");
	//var sql="Select speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;	
	argArray[0] = "";
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	argArray[12]  = "SQL_SPECIALITY_LOOKUP_SELECT";
	argArray[13]  = "eCA.Common.CaRepository";
	argArray[14]  = parNameArray
	argArray[15]  = parValueArray
	retVal      = await CommonLookup( title, argArray );
		var ret1=unescape(retVal);
		 	arr=ret1.split(",");
		 	if(arr[0]==undefined || arr[1] == undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		} 
    if (retVal != null && retVal != '' && retVal != "null")
	{
		document.forms[0].splName.value = arr[1];
		document.forms[0].splCode.value = arr[0];
	}
    else
	{
		document.forms[0].splName.value = arr[1];
		document.forms[0].splCode.value = arr[0];
	} 
	document.forms[0].flag.value='true';
}

async function getPractCode(objCode)
{	
	if(objCode.value=='')
	{
		document.forms[0].practitionerId.value='';
	}else{	
		await getPractitionerId()
	}	
	resetSearchResult();
}
async function getPractitionerId()
{
	var speciality = document.forms[0].splCode.value;
	var facilityId = document.forms[0].facilityId.value;
	var target			= document.forms[0].practitionerName;
	
	var repositoryKey="";
	
	var title="MultiLocationPract";
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;
	
	 if(speciality!="")
	{
		repositoryKey="SQL_PRACTITIONERWITHFACILITY_SPECIALITY_LOOKUP_SELECT";
		parNameArray[0] ="~FACILITY_ID`";
		parNameArray[1] ="~SPECIALITY_ID`";
		parValueArray[0]=facilityId;
		parValueArray[1]=speciality;
	}else{
		repositoryKey="SQL_PRACTITIONERWITHFACILITY_LOOKUP_SELECT";
		parNameArray[0] ="~FACILITY_ID`";
		parValueArray[0]=facilityId;
	}
		
	argArray[0] = "";
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	argArray[12]  = repositoryKey;
	argArray[13]  = "eCA.Common.CaRepository";
	argArray[14]  = parNameArray
	argArray[15]  = parValueArray
	
	retArray = await CommonLookup( title, argArray );
	
	if (retArray != null && retArray != '' && retArray != "null")
	{
		document.forms[0].practitionerId.value = retArray[0];
		document.forms[0].practitionerName.value = retArray[1];
	}
}
function populateData(){
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';	
	if(document.MutiLocForPractitionerCriteriaForm.practitionerId.value==""){
		msg =getMessage("PRACTITIONER_ID_CANNOT_BE_BLANK",'CA');
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
		return false;
	}else if(document.MutiLocForPractitionerCriteriaForm.locnType.value==""){
		msg =getMessage("LOCN_TYPE_NOT_BLNK",'CA');
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
		return false;
	}else{
		parent.frameMultiLocForPractitionerResult.location.href="../../eCA/jsp/MultiLocForPractitionerResult.jsp?practitionerId="+document.MutiLocForPractitionerCriteriaForm.practitionerId.value+"&locationType="+document.MutiLocForPractitionerCriteriaForm.locnType.value+"&searchBy="+document.MutiLocForPractitionerCriteriaForm.searchBy.value+"&searchText="+document.MutiLocForPractitionerCriteriaForm.searchText.value;
	}
	
}

function showCalendarValidate(str)
{
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}
function validate_date(from,to,format,locale)
{		
	if(from.value !="")
	{ 
		if(!isAfterNow(from.value,format, locale))
		{
			alert(getMessage("FROM_DATE_GREAT_SYS","CA"));
			from.value= getCurrentDate(format, locale);
			return false;
		}
	}
	if(to.value !="")
	{
		if(!isBefore(from.value,to.value,format,locale))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
			
			to.select();
			to.value="";
			
			return false;
		}
	}
	return true;
}

function uncheckHeader(element) {
	if(element.checked){
		element.value="Y";
		return;
	}else{
		element.value="N";
		if(document.getElementById('allChecked').checked==true)
			document.getElementById('allChecked').checked = false;
	}
}

function checkAll(ele) {
    var checkboxes = document.getElementsByTagName('input');
    if (ele.checked) {
        for (var i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].type == 'checkbox') {
                checkboxes[i].checked = true;
				checkboxes[i].value="Y";
            }
        }
    } else {
        for (var i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].type == 'checkbox') {
                checkboxes[i].checked = false;
				checkboxes[i].value="N";
            }
        }
    }
}

function apply() {
	
	if(f_query_add_mod.frameMultiLocForPractitionerResult.document.Result_form!=undefined){		
		
		var totalRecord=f_query_add_mod.frameMultiLocForPractitionerResult.document.Result_form.totalRecord.value;
	//	alert('------------>'+totalRecord);
		var porceedProcess =true;
		for(var i=0;i<totalRecord;i++){
			if((f_query_add_mod.frameMultiLocForPractitionerResult.document.getElementById("locCheck"+i).value=="Y")){
			//	alert('---->'+f_query_add_mod.frameMultiLocForPractitionerResult.document.getElementById("eff_from_date"+i).value+'<--------');
				if(f_query_add_mod.frameMultiLocForPractitionerResult.document.getElementById("eff_from_date"+i).value==""){
					 porceedProcess =false;
					 break
				}
			}
		}
		if(porceedProcess){
			f_query_add_mod.frameMultiLocForPractitionerResult.document.Result_form.action = "../../servlet/eCA.MultiLocForPractServlet";
			f_query_add_mod.frameMultiLocForPractitionerResult.document.Result_form.target="messageFrame";
			f_query_add_mod.frameMultiLocForPractitionerResult.document.Result_form.method="post";
			f_query_add_mod.frameMultiLocForPractitionerResult.document.Result_form.submit();
		}else{			
			
			msg =getMessage("EFFECTIVE_FROM_DATE_CANNOT_BE_BLANK",'CA');
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
			return false;
		}
	}else{
		msg =getMessage("SEARCH_RESULT_CANNOT_BE_BLANK",'CA');	
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
		return false;
	}
	
	  
}

function onSuccess()
{	
	
	f_query_add_mod.frameMultiLocForPractitionerResult.location.reload();
	
}

