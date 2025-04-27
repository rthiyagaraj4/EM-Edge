function CheckForSpecCharsLocal(event){
var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/';
var whichCode = (window.Event) ? event.which : event.keyCode;
key = String.fromCharCode(whichCode);  // Get key value from key code
if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
return true ;
}

function viewPostmortemDet()
{ 
var select_registration=document.forms[0].regn_no.value;
var patient_id=document.forms[0].patient_id.value;
var dialogHeight	=	"100"; 		// BRU-HIMS-CRF-270
var dialogWidth		=	"60"; 
var dialogTop		=	"200";
var status			=	"no";
var arguments		=	"" ;
retVal				=	"startpm";
var action_url		=	"../../eMO/jsp/MOPostmortemMangementFrameset.jsp?patient_id="+patient_id+"&select_registration="+select_registration+"&viewdata=viewdata";
var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";
retVal				=	window.showModalDialog(action_url,arguments,features);	
}


function showAllowOper(patientID,burilno)
{
	 
	  
	 functionid=parent.document.forms[0].function_id.value;
	 
	 
	//parent.document.getElementById("b").rows='*' 
	// parent.document.getElementById("commontoolbarFrame").style.height="9vh";
	// parent.document.getElementById("f_query_add_mod").style.height="82vh";
	// parent.document.getElementById("messageFrame").style.height="9vh";	
	parameter="menu_id=MO_MENU&module_id=MO&function_id=MO_REGISTER_DECEASED&function_name=Deceased Registration&function_type=F&access=NYYNN" 
	top.content.location.href = "../../eMO/jsp/MORegisterDeceased.jsp?functionid="+functionid+"&"+parameter+"&patientID="+patientID+"&menudis=MO_REGN_ATTN'" ;  

}
function submitPage()
{
	var function_id=parent.document.forms[0].function_id.value;
	var functionid=parent.document.forms[0].functionid.value;
	//alert(functionid);
var patient_id = parent.frames[1].document.forms[0].patient_id.value;
var BURIAL_PERMIT_NO = parent.frames[1].document.forms[0].BURIAL_PERMIT_NO.value;
var locn = parent.frames[1].document.forms[0].clinic_code.value;
var clinic_code1 = parent.frames[1].document.forms[0].clinic_code1.value;
dec_date_time= parent.frames[1].document.forms[0].dec_date_time.value;
dec_date_time1=parent.frames[1].document.forms[0].dec_date_time1.value;
var broughtindead="";
var regcase="";
var mlcyn="";
var	pmyn="";
if(parent.frames[1].document.forms[0].broughtindead.checked)broughtindead="Y";else broughtindead="N";
if(parent.frames[1].document.forms[0].pmyn.checked)pmyn="Y";else pmyn="N";
if(parent.frames[1].document.forms[0].mlcyn.checked)mlcyn="Y";else mlcyn="N";
if(parent.frames[1].document.forms[0].regcase.checked)regcase="Y";else regcase="N";

if(dec_date_time=="")
	{
		var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
		msg = msg.replace('$',getLabel("Common.date.label","Common"));
		alert(msg);
		parent.frames[1].document.forms[0].dec_date_time.focus();
		parent.frames[1].document.forms[0].search.disabled=false;		
		return false; 
	}
    if(dec_date_time1=="")
	{
		var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
		msg = msg.replace('$',getLabel("Common.date.label","Common"))
		alert(msg);
		parent.frames[1].document.forms[0].dec_date_time1.focus();
		parent.frames[1].document.forms[0].search.disabled=false;		
		return false; 
	}

	if(dec_date_time!=null && dec_date_time!="")
		dec_date_time_cnv = convertDate(dec_date_time,"DMY",localeName,"en"); 
	if(dec_date_time1!=null && dec_date_time1!="")
		dec_date_time1_cnv = convertDate(dec_date_time1,"DMY",localeName,"en"); 



if(isBefore(dec_date_time,dec_date_time1,'DMY',localeName)==true)
{
	
		parent.frames[2].location.href= "../jsp/MODeceasedDtlsQueryResult.jsp?functionid="+functionid+"&function_id="+function_id+"&patient_id="+patient_id+"&BURIAL_PERMIT_NO="+BURIAL_PERMIT_NO	+"&locn="+locn+"&clinic_code1="+clinic_code1+"&dec_date_time="+dec_date_time_cnv+"&dec_date_time1="+dec_date_time1_cnv+"&broughtindead="+broughtindead+"&pmyn="+pmyn+"&mlcyn="+mlcyn+"&regcase="+regcase;
	
}
else
{
	alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
	parent.frames[1].document.forms[0].search.disabled=false;
	return false;
}
	parent.frames[1].document.forms[0].search.disabled=true;

}
function toggle(Obj){

	
	//parent.document.getElementById("b").rows='*' 
	parent.document.getElementById("commontoolbarFrame").style.height="8vh";
	parent.document.getElementById("patientFrame").style.height="20vh";
	parent.document.getElementById("patientDetailsFrame").style.height="65vh";
	parent.document.getElementById("messageFrame").style.height="0vh";
	parent.document.getElementById("dispfr").style.height="7vh";
	
		
	parameter="menu_id=MO_MENU&module_id=MO&function_id=MO_REGISTER_DECEASED&function_name=Deceased Registration&function_type=F&access=NYYNN" ;
	//document.forms[0].patient_id.value="";  
	top.content.location.href = "../../eMO/jsp/MORegisterDeceased.jsp?"+parameter+"&patientID="+document.forms[0].patient_id.value+"&menudis=MO_REGN_ATTN&external=Y" ;
			
			
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



function selectRef(obj,ref_source_code)
{ 
	
	/*if(obj!=null&&obj!="undefined")
	{
	if(obj=="L")
	{
	document.forms[0].refe_type.options[1].selected=true;
	}else if(obj=="E"){
	document.forms[0].refe_type.options[2].selected=true;
	}else if(obj=="X"){
   document.forms[0].refe_type.options[3].selected=true;
	}else
	{
		document.forms[0].refe_type.options[0].selected=true;
	}
	
	refval=obj;
	}else
	{
	refval=document.forms[0].refe_type.value;
	}
		*/
	
	if(obj.name == "refe_type")
	{
		document.forms[0].hcare_type.disabled=false;
		document.forms[0].hcare_type.options[0].selected=true;
		document.forms[0].referral_source.disabled=false;

	}

	var HTMLVal = " <html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post'  action='../../eMO/jsp/MOSelectReferral.jsp' target='dummyframe'><input type='hidden' name='ref_code' id='ref_code' value='"+document.forms[0].refe_type.value+"'><input type='hidden' name='ref_type' id='ref_type' value='"+ref_source_code+"'><input type='hidden' name='hcare_type_code' id='hcare_type_code' value='"+document.forms[0].hcare_type.value+"'><input type='hidden' name='regpat' id='regpat' value='regpat'></form></body></html>";
	parent.dummyframe.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.dummyframe.document.forms[0].submit();



}
/*
function validate1(obj)
{  

body_received_date=document.forms[0].body_received_date_time.value;

if(body_received_date=="" && obj.value!="")
{
alert(getMessage("ENTER_BDYRCPT_DTTIME","MO"));
obj.focus();
obj.value="";
return false;
}

if(obj.value!=""&&body_received_date!="")
	{
val1=obj.value.length	


if(val1<16)
		{
	alert(getMessage("INVALID_DATE_FMT","SM"));
	obj.value="";
	obj.focus();
	return false;
		}
	if(doDateTimeChk(obj)==false)
	{

	obj.value="";
	obj.focus();
	return false;
	}

parent.dummyframe.location.href='../../eMO/jsp/ValidateSysdate.jsp?objname='+obj.name+"&bodypart=deceasedregn"+"&objValue="+escape(obj.value);
if(ValidateDateTime(document.forms[0].body_received_date_time,obj)==false) 
{
alert(getMessage('DATE_CANT_BE_LT_RECEIPT','MO'));
obj.value="";
obj.focus();
return false;
}

}
if(obj.name=="burial_app_date")
	{
document.getElementById("tab4").scrollIntoView();
document.getElementById("generate_burial_permit").focus();
	}
}
*/
function ClearClaimantValues()
{

//if it is an unclaimed body this removes next of kin and employer else it adds all..
if(document.getElementById("unclaimedbodyyn").checked)
{


if(document.getElementById("CLAIMANT_TYPE").value=="E"||document.getElementById("CLAIMANT_TYPE").value=="K"||document.getElementById("CLAIMANT_TYPE").value=="F") //changes for 38265
{
document.forms[0].CLAIMANT_TYPE_CODE.options[0].selected=true;
document.forms[0].CLAIMANT_TYPE_CODE.disabled=true;
if(document.forms[0].mode.value!="viewdata")
	{
		/*Modified by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
		if(document.getElementById("CLAIMANT_TYPE").value=="F")
		{
			document.forms[0].copydet.disabled=true;
		}else
		{
			document.forms[0].copydet.disabled=false;
		}
	}
//parent.frames[3].document.forms[0].copydet.disabled=true;
if(parent.frames[3].document.getElementById("twnsrch"))
parent.frames[3].document.getElementById("twnsrch").disabled=true;
if(parent.frames[3].document.getElementById("areasrch"))
parent.frames[3].document.getElementById("areasrch").disabled=true;
if(parent.frames[3].document.getElementById("rgnsrh"))
	parent.frames[3].document.getElementById("rgnsrh").disabled=true;

if(parent.frames[3].document.getElementById("area")!=null)
parent.frames[3].document.forms[0].area.value=""

if(parent.frames[3].document.getElementById("town")!=null)
parent.frames[3].document.forms[0].town.value=""

if(parent.frames[3].document.getElementById("region")!=null)
parent.frames[3].document.forms[0].region.value=""

if(parent.frames[3].document.getElementById("area")!=null)
parent.frames[3].document.forms[0].area.disabled=true

if(parent.frames[3].document.getElementById("town")!=null)
parent.frames[3].document.forms[0].town.disabled=true

if(parent.frames[3].document.getElementById("region")!=null)
parent.frames[3].document.forms[0].region.disabled=true
if(parent.frames[3].document.forms[0].postal_search)
parent.frames[3].document.forms[0].postal_search.disabled=true
parent.frames[3].document.forms[0].contry_code.disabled=true
parent.frames[3].document.forms[0].NAME.disabled=true;
parent.frames[3].document.forms[0].NAME.value="";
parent.frames[3].document.forms[0].RELATIONSHIP.disabled=true;
parent.frames[3].document.forms[0].RELATIONSHIP.options[0].selected=true;

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
	{
	parent.frames[3].document.forms[0].PASSPORT_NO.disabled=true
	parent.frames[3].document.forms[0].PASSPORT_NO.value="";
	parent.frames[3].document.forms[0].OTHER_IDENTIFICATION.disabled=true
	parent.frames[3].document.forms[0].OTHER_IDENTIFICATION.value="";
	}

parent.frames[3].document.forms[0].PATIENT_EMPLOYEE_ID.disabled=true
parent.frames[3].document.forms[0].PATIENT_EMPLOYEE_ID.value="";

parent.frames[3].document.forms[0].ORGANIZATION_NAME.disabled=true
parent.frames[3].document.forms[0].ORGANIZATION_NAME.value="";
parent.frames[3].document.forms[0].JOB_TITLE.disabled=true
parent.frames[3].document.forms[0].JOB_TITLE.value=""
if(parent.frames[3].document.forms[0].addr_line_1!=null)
{
parent.frames[3].document.forms[0].addr_line_1.disabled=true
parent.frames[3].document.forms[0].addr_line_1.value=""
}
if(parent.frames[3].document.forms[0].addr_line_2!=null)
{
parent.frames[3].document.forms[0].addr_line_2.disabled=true
parent.frames[3].document.forms[0].addr_line_2.value=""
}
if(parent.frames[3].document.forms[0].addr_line_3!=null)
{
parent.frames[3].document.forms[0].addr_line_3.disabled=true
parent.frames[3].document.forms[0].addr_line_3.value=""
}
if(parent.frames[3].document.forms[0].addr_line_4!=null)
{
parent.frames[3].document.forms[0].addr_line_4.disabled=true
parent.frames[3].document.forms[0].addr_line_4.value=""
}
if(parent.frames[3].document.forms[0].postal_code!=null)
{
parent.frames[3].document.forms[0].postal_code.disabled=true
parent.frames[3].document.forms[0].postal_code.value=""
}
parent.frames[3].document.forms[0].COUNTRY_DESC.disabled=true
parent.frames[3].document.forms[0].COUNTRY_DESC.value=""
parent.frames[3].document.forms[0].TELEPHONE_OFF.disabled=true
parent.frames[3].document.forms[0].TELEPHONE_OFF.value="";
parent.frames[3].document.forms[0].TELEPHONE_RES.disabled=true
parent.frames[3].document.forms[0].TELEPHONE_RES.value="";
parent.frames[3].document.forms[0].MOB_TEL_NO.disabled=true
parent.frames[3].document.forms[0].MOB_TEL_NO.value=""
parent.frames[3].document.forms[0].NAT_ID_NO.disabled=true
parent.frames[3].document.forms[0].NAT_ID_NO.value=""
parent.frames[3].document.forms[0].EMAIL_ID.disabled=true
parent.frames[3].document.forms[0].EMAIL_ID.value=""
}
document.getElementById("CLAIMANT_TYPE").remove(1);
document.getElementById("CLAIMANT_TYPE").remove(1);
}else
{
claimselect=document.getElementById("CLAIMANT_TYPE").value

var len=document.getElementById("CLAIMANT_TYPE").length

for (i=0;i<=len;i++ )
{
document.getElementById("CLAIMANT_TYPE").remove(0);
}
var opt=document.createElement('OPTION');
opt.text="------"+getLabel("Common.defaultSelect.label","Common")+"------";
opt.value=""
document.getElementById("CLAIMANT_TYPE").add(opt);

/*Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
var function_id = parent.parent.commontoolbarFrame.document.forms[0].function_id.value;

//var xmlDoc = new ActiveXObject("Microsoft.XMLDom")
//var xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")
var xmlDoc = "";
var xmlHttp = new XMLHttpRequest();
xmlStr = "<root><SEARCH function_id=\""+function_id+"\" action='getClaimantType' /></root>"
//var xmlString = getXMLString(null);  
var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
//xmlDoc.loadXML(xmlStr)
xmlHttp.open("POST","../../eMO/jsp/MOIntermediate.jsp",false)
xmlHttp.send(xmlDoc)
responseText = xmlHttp.responseText
var ClaimantType = responseText;

var arr = new Array();
arr = ClaimantType.split("##");

for(i=0; i<arr.length; i++) 
{
 var claimantArr = new Array();
 claimantArr = trimString(arr[i]).split("~~");

 var claimant_type_mstr_code = claimantArr[0];
 var short_desc = claimantArr[1];

 var opt = document.createElement('OPTION');
 opt.text = short_desc; 
 opt.value = claimant_type_mstr_code;
 document.getElementById("CLAIMANT_TYPE").add(opt);
}

if(document.getElementById("mode").value == "modify" || document.getElementById("mode").value == "viewdata")
{
	var ClaimantTypeValue = document.getElementById("claimant_type_mstr").value;

	for(var i=0;i<document.getElementById("CLAIMANT_TYPE").options.length;i++ )
	{  
		if(document.getElementById("CLAIMANT_TYPE").options[i].value == ClaimantTypeValue)
		{
			document.getElementById("CLAIMANT_TYPE").options[i].selected = true;
		}
	}
}
/*End ML-MMOH-CRF-1095*/

/*var opt=document.createElement('OPTION');
opt.text=getLabel("Common.nextofkin.label","Common");
opt.value="K"
document.getElementById("CLAIMANT_TYPE").add(opt);

var opt=document.createElement('OPTION');
opt.text=getLabel("Common.employer.label","Common");
opt.value="E"
document.getElementById("CLAIMANT_TYPE").add(opt);

var opt=document.createElement('OPTION');
opt.text=getLabel("eMO.EmbassyCountry.label","MO");
opt.value="M"
document.getElementById("CLAIMANT_TYPE").add(opt);

var opt=document.createElement('OPTION');
opt.text=getLabel("eMO.WelfareAssociations.label","MO");
opt.value="W"
document.getElementById("CLAIMANT_TYPE").add(opt);

var opt=document.createElement('OPTION');
opt.text=getLabel("eMO.ReligiousOrgn.label","MO");
opt.value="R"
document.getElementById("CLAIMANT_TYPE").add(opt);
var opt=document.createElement('OPTION');
opt.text=getLabel("eMO.UnderTaker.label","MO");
opt.value="U"
document.getElementById("CLAIMANT_TYPE").add(opt);
var opt=document.createElement('OPTION');
opt.text=getLabel("Common.others.label","Common");
opt.value="O"
document.getElementById("CLAIMANT_TYPE").add(opt);
//changes for 38265
var opt=document.createElement('OPTION');
opt.text=getLabel("eMO.ReleasedToOtherFacility.label","MO");
opt.value="F"
document.getElementById("CLAIMANT_TYPE").add(opt);

if(claimselect=="K")
	{
document.getElementById("CLAIMANT_TYPE").options[1].selected=true;
//document.forms[0].copydet.disabled=false;
	}
else
if(claimselect=="E")
{
document.getElementById("CLAIMANT_TYPE").options[2].selected=true;
document.forms[0].copydet.disabled=false;
}
else
if(claimselect=="M")
document.getElementById("CLAIMANT_TYPE").options[3].selected=true;
else if(claimselect=="W")
document.getElementById("CLAIMANT_TYPE").options[4].selected=true;
else if(claimselect=="R")
document.getElementById("CLAIMANT_TYPE").options[5].selected=true;
else if(claimselect=="U")
document.getElementById("CLAIMANT_TYPE").options[6].selected=true;
else if(claimselect=="O")
document.getElementById("CLAIMANT_TYPE").options[7].selected=true;
else if(claimselect=="F")
document.getElementById("CLAIMANT_TYPE").options[8].selected=true;//changes for 38265
else 
document.getElementById("CLAIMANT_TYPE").options[0].selected=true;
if((claimselect=="M")||(claimselect=="W")||(claimselect=="R")||(claimselect=="O"))
document.forms[0].copydet.disabled=true;*/
}



}
function enableConsent()
{//gets enabled or disabled based on the postmortem type. 
if(document.getElementById("postmortem_type").value=='C')
{
	document.getElementById("Consent_forms").disabled=false;
	
}else
	{
	document.getElementById("Consent_forms").disabled=true;
	}
}
function checkUnckData()
{
	var makeMand = document.getElementById("makeMand").value;//Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689
	if(document.getElementById("police_approval_received_yn").checked)
	{
		if(document.getElementById("mode").value!="viewdata")
		{
			document.getElementById("police_received_by").disabled=false;
			document.getElementById("police_received_date").disabled=false;
			if(makeMand == "Y"){//Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689
				document.getElementById("idchk1").style.visibility="visible"
				document.getElementById("idchk2").style.visibility="visible"
			}
			document.getElementById("img1").disabled=false
			document.getElementById("pract_id").disabled=false;
			document.getElementById("police_received_by_desc").disabled=false;
		}
	}
	else
	{//document.getElementById("police_received_by").options[0].selected=true;
		document.getElementById("police_received_date").value="";
		document.getElementById("police_received_by").value="";
		document.getElementById("police_received_by_desc").value="";
		document.getElementById("police_received_by_desc").disabled=true;
		document.getElementById("pract_id").disabled=true;

		document.getElementById("police_received_date").disabled=true;

		document.getElementById("idchk1").style.visibility="hidden"
		document.getElementById("idchk2").style.visibility="hidden"
		document.getElementById("img1").disabled=true
	}
}


async function callPostalSearch(target)
{
	  
		var sql="";	
		tar=target.value
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit="";	

		tit=getLabel("eMP.postalcode.label","MP");

		sql="select postal_code code, short_desc description from mp_postal_code_lang_vw where language_id='"+localeName+"' and upper(postal_code) like upper(?) and upper(short_desc) like upper(?) and eff_status = 'E'";
	
	//	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		//retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,1";
		argumentArray[5] = tar;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		
		retVal = await CommonLookup( tit, argumentArray );
 
		if (!(retVal == null)){
			var ret1=unescape(retVal);
			arr=ret1.split(",");			 	
			document.forms[0].ZIP_CODE.value=arr[0];
			target.value=arr[0];			
		}
		else
			target.focus();
}


function blurPostalSearch(obj,target)
{
	if(obj.value == "")
	{obj.value="";
	  return ;
	}
callPostalSearch(obj,target)

}

function searchCountry1(obj,target)
{
	if(obj.value == "")
	{obj.value="";
	  return ;
	}
searchCountry(obj,target)

}
async function searchCountry(obj,target)
   {
	   
		tar=target.value
		
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit="";	
		
		if(target.name=='COUNTRY_DESC')
	   {	
		tit=getLabel("Common.country.label","Common");
		sql="Select country_code code,short_name description from Mp_Country_lang_vw where eff_status='E' and language_id= '"+localeName+"' and upper(country_code) like upper(?) and upper(short_name) like upper(?) order by 2";
	   }else if(target.name=='town')
	   {
		tit=getLabel("Common.Town.label","Common");	
		sql="select res_town_code code,short_desc description from mp_res_town_lang_vw  where eff_status='E' and language_id= '"+localeName+"' and upper(res_town_code) like upper(?) and upper(short_desc) like upper(?) order by 2"
	   }else if(target.name=='area')
	   {
		tit=getLabel("Common.area.label","Common");
		sql="select RES_AREA_CODE code, short_desc description from mp_res_area_lang_vw where eff_status='E' and language_id= '"+localeName+"' and upper(RES_AREA_CODE) like upper(?) and upper(short_desc) like upper(?) order by 2"
	   }else if(target.name=='region')
	   {
		tit=getLabel("eMP.region.label","MP");
		sql="select REGION_CODE code, short_desc  description from mp_region_lang_vw where eff_status='E' and language_id= '"+localeName+"' and upper(REGION_CODE) like upper(?) and upper(short_desc) like upper(?) order by 2"
	   }
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = tar;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		
		retVal = await CommonLookup( tit, argumentArray );
		
		if(retVal != null && retVal != "" )
		  {
			
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			if(target.name=='COUNTRY_DESC')
			  {
			document.forms[0].COUNTRY_DESC.value=arr[1];
			document.forms[0].COUNTRY_CODE.value=arr[0];
			  }else if(target.name=='region')
			  {
			document.forms[0].region.value=arr[1];
			document.forms[0].region1.value=arr[0];
			  
			  }else  if(target.name=='town')
			  {
			  document.forms[0].town.value=arr[1];
			  document.forms[0].town1.value=arr[0];
			  parent.dummyframe.location.href='../../eMO/jsp/PopulateAddress.jsp?townCode='+arr[0]
			  
			  } if(target.name=='area')
			  {
			  document.forms[0].area.value=arr[1];
			  document.forms[0].area1.value=arr[0];
			  
			  parent.dummyframe.location.href='../../eMO/jsp/PopulateAddress.jsp?areaCode='+arr[0]
			
			  }
					
					
					
					}
				else
				  {
					target.value='';
			      }
		}






function getClaimant1(claimant,claimcode)
{

if(document.forms[0].mode.value=="viewdata")
{
//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
{
	if(claimcode!="")
	{
		/*Modified by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
		if(claimant=='M')
		{
			parent.frames[3].document.getElementById("id3").style.visibility='visible';
		}else
		{
			parent.frames[3].document.getElementById("id3").style.visibility='hidden';
		}

		parent.frames[3].document.forms[0].CLAIMANT_TYPE_CODE.disabled=false
	}
}
else{
if(claimcode!="")
{parent.frames[3].document.getElementById("id3").style.visibility='visible';
parent.frames[3].document.forms[0].CLAIMANT_TYPE_CODE.disabled=false
}
}
if(claimant!="")
{

HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post'  target='encounterFrame' action='../../eMO/jsp/GetClaim.jsp?criteria=populateClaim'><input type='hidden' name='selclaim' id='selclaim' value='"+claimant+"'><input type='hidden' name='cliamcode' id='cliamcode' value='"+claimcode+"'></form></body></html>";
//parent.frames[4].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
parent.frames[2].document.write(HTMLVal);
parent.frames[2].document.dum_form.submit();
}


parent.frames[3].document.forms[0].copydet.disabled=true;
//Object checks for address fields added by Thamizh selvi against ML-MMOH-SCF-1133 on 16th Jan 2019
if(parent.frames[3].document.forms[0].postal_search)
parent.frames[3].document.forms[0].postal_search.disabled=true
parent.frames[3].document.forms[0].contry_code.disabled=true
parent.frames[3].document.forms[0].CLAIMANT_TYPE_CODE.disabled=true;
parent.frames[3].document.forms[0].CLAIMANT_TYPE.disabled=true;
parent.frames[3].document.forms[0].NAME.disabled=true;
parent.frames[3].document.forms[0].RELATIONSHIP.disabled=true;

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
	{
	parent.frames[3].document.forms[0].PASSPORT_NO.disabled=true
	parent.frames[3].document.forms[0].OTHER_IDENTIFICATION.disabled=true
	}

parent.frames[3].document.forms[0].PATIENT_EMPLOYEE_ID.disabled=true
parent.frames[3].document.forms[0].ORGANIZATION_NAME.disabled=true
parent.frames[3].document.forms[0].JOB_TITLE.disabled=true
if(parent.frames[3].document.forms[0].addr_line_1!=null)
parent.frames[3].document.forms[0].addr_line_1.disabled=true
if(parent.frames[3].document.forms[0].addr_line_2!=null)
parent.frames[3].document.forms[0].addr_line_2.disabled=true
if(parent.frames[3].document.forms[0].addr_line_3!=null)
parent.frames[3].document.forms[0].addr_line_3.disabled=true
if(parent.frames[3].document.forms[0].addr_line_4!=null)
parent.frames[3].document.forms[0].addr_line_4.disabled=true
if(parent.frames[3].document.forms[0].postal_code!=null)
parent.frames[3].document.forms[0].postal_code.disabled=true
//parent.frames[3].document.getElementById("pstsrh").disabled=true;
if(parent.frames[3].document.getElementById("postal_search"))
parent.frames[3].document.getElementById("postal_search").disabled=true;
if(parent.frames[3].document.getElementById("cntrysrh"))
parent.frames[3].document.getElementById("cntrysrh").disabled=true;
if(parent.frames[3].document.getElementById("twnsearch"))
parent.frames[3].document.getElementById("twnsearch").disabled=true;
if(parent.frames[3].document.getElementById("twnsrch"))
parent.frames[3].document.getElementById("twnsrch").disabled=true;
if(parent.frames[3].document.getElementById("areasrch"))
parent.frames[3].document.getElementById("areasrch").disabled=true;
if(parent.frames[3].document.getElementById("rgnsrh"))
	parent.frames[3].document.getElementById("rgnsrh").disabled=true;

if(parent.frames[3].document.getElementById("area")!=null)
parent.frames[3].document.forms[0].area.disabled=true

if(parent.frames[3].document.getElementById("town")!=null)
parent.frames[3].document.forms[0].town.disabled=true

if(parent.frames[3].document.getElementById("region")!=null)
parent.frames[3].document.forms[0].region.disabled=true
if(parent.frames[3].document.forms[0].COUNTRY_DESC)
parent.frames[3].document.forms[0].COUNTRY_DESC.disabled=true
parent.frames[3].document.forms[0].TELEPHONE_OFF.disabled=true
parent.frames[3].document.forms[0].TELEPHONE_RES.disabled=true
parent.frames[3].document.forms[0].MOB_TEL_NO.disabled=true
parent.frames[3].document.forms[0].NAT_ID_NO.disabled=true
parent.frames[3].document.forms[0].EMAIL_ID.disabled=true


}
else
	{
//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
{
	if(claimcode!="")
	{
		/*Modified by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
		if(claimant=='M')
		{
			parent.frames[3].document.getElementById("id3").style.visibility='visible';
		}else
		{
			parent.frames[3].document.getElementById("id3").style.visibility='hidden';
		}

		parent.frames[3].document.forms[0].CLAIMANT_TYPE_CODE.disabled=false
	}
}
else{
if(claimcode!="")
{parent.frames[3].document.getElementById("id3").style.visibility='visible';
parent.frames[3].document.forms[0].CLAIMANT_TYPE_CODE.disabled=false
}
}

if(claimant!="")
{

if(claimant=='K')
{
if(parent.frames[3].document.getElementById("twnsrch"))
parent.frames[3].document.getElementById("twnsrch").disabled=false;
if(parent.frames[3].document.getElementById("areasrch"))
parent.frames[3].document.getElementById("areasrch").disabled=false;
if(parent.frames[3].document.getElementById("rgnsrh"))
 parent.frames[3].document.getElementById("rgnsrh").disabled=false;
 
if(document.getElementById("area")!=null)
document.forms[0].area.disabled=false

if(document.getElementById("town")!=null)
document.forms[0].town.disabled=false

if(document.getElementById("region")!=null)
document.forms[0].region.disabled=false

document.getElementById("id3").style.visibility='hidden';
document.forms[0].CLAIMANT_TYPE_CODE.disabled=true
document.forms[0].NAME.disabled=false;
document.forms[0].RELATIONSHIP.disabled=false;

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
	{
	document.forms[0].PASSPORT_NO.disabled=false
	document.forms[0].OTHER_IDENTIFICATION.disabled=false
	}
	
document.forms[0].PATIENT_EMPLOYEE_ID.disabled=false
document.forms[0].ORGANIZATION_NAME.disabled=false
document.forms[0].JOB_TITLE.disabled=false
if(document.getElementById("addr_line_1")!=null)
document.forms[0].addr_line_1.disabled=false
if(document.getElementById("addr_line_2")!=null)
document.forms[0].addr_line_2.disabled=false
if(document.getElementById("addr_line_3")!=null)
document.forms[0].addr_line_3.disabled=false
if(document.getElementById("addr_line_4")!=null)
document.forms[0].addr_line_4.disabled=false
if(document.getElementById("postal_code")!=null)
document.forms[0].postal_code.disabled=false
if(document.forms[0].COUNTRY_DESC)
document.forms[0].COUNTRY_DESC.disabled=false
document.forms[0].TELEPHONE_OFF.disabled=false
document.forms[0].TELEPHONE_RES.disabled=false
document.forms[0].MOB_TEL_NO.disabled=false
document.forms[0].NAT_ID_NO.disabled=false
document.forms[0].EMAIL_ID.disabled=false
document.forms[0].copydet.disabled=false;
document.forms[0].NAT_ID_NO.readOnly=false;
document.forms[0].EMAIL_ID.readOnly=false
//parent.frames[3].document.getElementById("pstsrh").disabled=false;
if(parent.frames[3].document.getElementById("postal_search"))
parent.frames[3].document.getElementById("postal_search").disabled=false;
if(parent.frames[3].document.getElementById("cntrysrh"))
parent.frames[3].document.getElementById("cntrysrh").disabled=false;
if(parent.frames[3].document.getElementById("twnsearch"))
parent.frames[3].document.getElementById("twnsearch").disabled=false;

}else if((claimant=='E')||(claimant=='F'))
{

if(parent.frames[3].document.getElementById("twnsrch"))
parent.frames[3].document.getElementById("twnsrch").disabled=false;
if(parent.frames[3].document.getElementById("areasrch"))
parent.frames[3].document.getElementById("areasrch").disabled=false;
if(parent.frames[3].document.getElementById("rgnsrh"))
	parent.frames[3].document.getElementById("rgnsrh").disabled=false;

if(document.getElementById("area")!=null)
document.forms[0].area.disabled=false

if(document.getElementById("town")!=null)
document.forms[0].town.disabled=false

if(document.getElementById("region")!=null)
document.forms[0].region.disabled=false

document.getElementById("id3").style.visibility='hidden';
document.forms[0].CLAIMANT_TYPE_CODE.disabled=true
document.forms[0].NAME.disabled=false;
document.forms[0].RELATIONSHIP.disabled=false;

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
	{
	document.forms[0].PASSPORT_NO.disabled=false
	document.forms[0].OTHER_IDENTIFICATION.disabled=false
	}

document.forms[0].PATIENT_EMPLOYEE_ID.disabled=false
document.forms[0].ORGANIZATION_NAME.disabled=false
if(document.getElementById("addr_line_1")!=null)
document.forms[0].addr_line_1.disabled=false
if(document.getElementById("addr_line_2")!=null)
document.forms[0].addr_line_2.disabled=false
if(document.getElementById("addr_line_3")!=null)
document.forms[0].addr_line_3.disabled=false
if(document.getElementById("addr_line_4")!=null)
document.forms[0].addr_line_4.disabled=false
if(document.getElementById("postal_code")!=null)
document.forms[0].postal_code.disabled=false
document.forms[0].COUNTRY_DESC.disabled=false
document.forms[0].TELEPHONE_OFF.disabled=false
document.forms[0].TELEPHONE_RES.disabled=false
//parent.frames[3].document.getElementById("pstsrh").disabled=false;
if(parent.frames[3].document.getElementById("postal_search"))
parent.frames[3].document.getElementById("postal_search").disabled=false;
if(parent.frames[3].document.getElementById("cntrysrh"))
parent.frames[3].document.getElementById("cntrysrh").disabled=false;
if(parent.frames[3].document.getElementById("twnsearch"))
parent.frames[3].document.getElementById("twnsearch").disabled=false;

document.forms[0].JOB_TITLE.disabled=false;
document.forms[0].MOB_TEL_NO.disabled=false
document.forms[0].NAT_ID_NO.disabled=false;
document.forms[0].EMAIL_ID.disabled=false

	/*Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
	if(claimant=='F')
	{
		document.forms[0].copydet.disabled=true;
	}else
	{
		document.forms[0].copydet.disabled=false;
	}
}
else
{
	if(parent.frames[3].document.getElementById("twnsrch")!=null)
		parent.frames[3].document.getElementById("twnsrch").disabled=false;
	if(parent.frames[3].document.getElementById("areasrch")!=null)
		parent.frames[3].document.getElementById("areasrch").disabled=false;
if(parent.frames[3].document.getElementById("rgnsrh")!=null)
	parent.frames[3].document.getElementById("rgnsrh").disabled=false;

if(document.getElementById("area")!=null)
document.forms[0].area.disabled=false

if(document.getElementById("town")!=null)
document.forms[0].town.disabled=false

if(document.getElementById("region")!=null)
document.forms[0].region.disabled=false

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
{
	/*Modified by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
	if(claimant=='M')
	{
		document.getElementById("id3").style.visibility='visible';
	}else
	{
		document.getElementById("id3").style.visibility='hidden';
	}
}
else{
document.getElementById("id3").style.visibility='visible';
}

document.forms[0].CLAIMANT_TYPE_CODE.disabled=false
document.forms[0].NAME.disabled=false;
document.forms[0].RELATIONSHIP.disabled=false;

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
	{
	document.forms[0].PASSPORT_NO.disabled=false
	document.forms[0].OTHER_IDENTIFICATION.disabled=false
	}

document.forms[0].PATIENT_EMPLOYEE_ID.disabled=false
document.forms[0].ORGANIZATION_NAME.disabled=false
if(document.getElementById("addr_line_1")!=null)
document.forms[0].addr_line_1.disabled=false
if(document.getElementById("addr_line_2")!=null)
document.forms[0].addr_line_2.disabled=false
if(document.getElementById("addr_line_3")!=null)
document.forms[0].addr_line_3.disabled=false
if(document.getElementById("addr_line_4")!=null)
document.forms[0].addr_line_4.disabled=false
if(document.getElementById("postal_code")!=null)
document.forms[0].postal_code.disabled=false
document.forms[0].COUNTRY_DESC.disabled=false
document.forms[0].TELEPHONE_OFF.disabled=false
document.forms[0].TELEPHONE_RES.disabled=false
document.forms[0].JOB_TITLE.disabled=true;
document.forms[0].MOB_TEL_NO.disabled=true
document.forms[0].NAT_ID_NO.disabled=true;
document.forms[0].EMAIL_ID.disabled=false
//parent.frames[3].document.getElementById("pstsrh").disabled=false;
if(parent.frames[3].document.getElementById("postal_search")!=null)
	parent.frames[3].document.getElementById("postal_search").disabled=false;
if(parent.frames[3].document.getElementById("cntrysrh")!=null)
	parent.frames[3].document.getElementById("cntrysrh").disabled=false;
if(parent.frames[3].document.getElementById("twnsearch")!=null)
parent.frames[3].document.getElementById("twnsearch").disabled=false;

}



HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' target='encounterFrame' action='../../eMO/jsp/GetClaim.jsp?criteria=populateClaim'><input type='hidden' name='selclaim' id='selclaim' value='"+claimant+"'><input type='hidden' name='cliamcode' id='cliamcode' value='"+claimcode+"'></form></body></html>";
parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
parent.frames[2].document.dum_form.submit();



}else
{
	
//parent.frames[3].document.getElementById("pstsrh").disabled=true;
if(parent.frames[3].document.getElementById("postal_search")!=null)	
	parent.frames[3].document.getElementById("postal_search").disabled=true;
//parent.frames[3].document.getElementById("twnsrch").disabled=true;
if(parent.frames[3].document.getElementById("areasrch")!=null)	
	parent.frames[3].document.getElementById("areasrch").disabled=true;
if(parent.frames[3].document.getElementById("rgnsrh")!=null)
	parent.frames[3].document.getElementById("rgnsrh").disabled=true;
if(parent.frames[3].document.getElementById("cntrysrh")!=null)	
	parent.frames[3].document.getElementById("cntrysrh").disabled=true;
if(parent.frames[3].document.getElementById("twnsearch")!=null)	
parent.frames[3].document.getElementById("twnsearch").disabled=true;
parent.frames[3].document.forms[0].NAME.disabled=true;
parent.frames[3].document.forms[0].RELATIONSHIP.disabled=true;

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
	{
	parent.frames[3].document.forms[0].PASSPORT_NO.disabled=true
	parent.frames[3].document.forms[0].OTHER_IDENTIFICATION.disabled=true
	}

parent.frames[3].document.forms[0].PATIENT_EMPLOYEE_ID.disabled=true
parent.frames[3].document.forms[0].ORGANIZATION_NAME.disabled=true
parent.frames[3].document.forms[0].JOB_TITLE.disabled=true

if(parent.frames[3].document.forms[0].region!=null)
parent.frames[3].document.forms[0].region.disabled=true

if(parent.frames[3].document.forms[0].area!=null)
parent.frames[3].document.forms[0].area.disabled=true

if(parent.frames[3].document.forms[0].town!=null)
parent.frames[3].document.forms[0].town.disabled=true

if(parent.frames[3].document.forms[0].addr_line_1!=null)
parent.frames[3].document.forms[0].addr_line_1.disabled=true
if(parent.frames[3].document.forms[0].addr_line_2!=null)
parent.frames[3].document.forms[0].addr_line_2.disabled=true
if(parent.frames[3].document.forms[0].addr_line_3!=null)
parent.frames[3].document.forms[0].addr_line_3.disabled=true
if(parent.frames[3].document.forms[0].addr_line_4!=null)
parent.frames[3].document.forms[0].addr_line_4.disabled=true
if(parent.frames[3].document.forms[0].postal_code!=null)
parent.frames[3].document.forms[0].postal_code.disabled=true
parent.frames[3].document.forms[0].COUNTRY_DESC.disabled=true
parent.frames[3].document.forms[0].TELEPHONE_OFF.disabled=true
parent.frames[3].document.forms[0].TELEPHONE_RES.disabled=true
parent.frames[3].document.forms[0].MOB_TEL_NO.disabled=true
parent.frames[3].document.forms[0].NAT_ID_NO.disabled=true
parent.frames[3].document.forms[0].EMAIL_ID.disabled=true


}
}
}
function viewPatientDetails(p_patient_id)
{
	var functionid=parent.document.forms[0].function_id.value;
	var function_id=parent.document.forms[0].functionid.value;
	var title = getLabel("eMO.ViewDeceasedDtls.label","MO");
	var dialogHeight= "99vh" ;
	var dialogWidth	= "190vh" ;
	var dialogTop= "65";
	var dialogLeft= "1";
	var prev="prev";
	var display="display";
	var features= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	window.showModalDialog('../../eMP/jsp/ViewPatDetailsMain.jsp?function_id='+function_id+'&functionid='+functionid+'&display='+display+'&Patient_ID='+p_patient_id,arguments,features);
	//window.showModalDialog('../../eMP/jsp/ViewPatDetailsMain.jsp?display='+display+'&Patient_ID='+p_patient_id,arguments,features);
}


function getClaimant(obj,claimcode)
{claimcode="";

if(obj.value=="")
{
if(document.getElementById("area1")!=null)
document.forms[0].area1.value=""

if(document.getElementById("town1")!=null)
document.forms[0].town1.value=""

if(document.getElementById("region1")!=null)
document.forms[0].region1.value=""

if(document.getElementById("area")!=null)
document.forms[0].area.value=""

if(document.getElementById("town")!=null)
document.forms[0].town.value=""

if(document.getElementById("region")!=null)
document.forms[0].region.value=""

if(document.getElementById("area")!=null)
document.forms[0].area.disabled=true
if(document.getElementById("town")!=null)
document.forms[0].town.disabled=true
if(document.getElementById("twnsrch"))
document.getElementById("twnsrch").disabled=true;
if(document.getElementById("areasrch"))
document.getElementById("areasrch").disabled=true;
if(document.getElementById("rgnsrh"))
	document.getElementById("rgnsrh").disabled=true;

if(document.getElementById("region")!=null)
document.forms[0].region.disabled=true

document.forms[0].CLAIMANT_TYPE_CODE.options[0].selected=true;
document.forms[0].CLAIMANT_TYPE_CODE.disabled=true;
//document.forms[0].copydet.disabled=true;
parent.frames[3].document.forms[0].copydet.disabled=true;
parent.frames[3].document.forms[0].postal_search.disabled=true
parent.frames[3].document.forms[0].contry_code.disabled=true
parent.frames[3].document.forms[0].NAME.disabled=true;
parent.frames[3].document.forms[0].NAME.value="";
parent.frames[3].document.forms[0].RELATIONSHIP.disabled=true;
parent.frames[3].document.forms[0].RELATIONSHIP.options[0].selected=true;

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
	{
	parent.frames[3].document.forms[0].PASSPORT_NO.disabled=true
	parent.frames[3].document.forms[0].PASSPORT_NO.value="";
	parent.frames[3].document.forms[0].OTHER_IDENTIFICATION.disabled=true
	parent.frames[3].document.forms[0].OTHER_IDENTIFICATION.value="";
	}

parent.frames[3].document.forms[0].PATIENT_EMPLOYEE_ID.disabled=true
parent.frames[3].document.forms[0].PATIENT_EMPLOYEE_ID.value="";
parent.frames[3].document.forms[0].ORGANIZATION_NAME.disabled=true
parent.frames[3].document.forms[0].ORGANIZATION_NAME.value="";
parent.frames[3].document.forms[0].JOB_TITLE.disabled=true
parent.frames[3].document.forms[0].JOB_TITLE.value=""
parent.frames[3].document.getElementById("hed1").style.visibility="hidden"
parent.frames[3].document.getElementById("ocpnlab").style.visibility="hidden"

if(parent.frames[3].document.forms[0].addr_line_1!=null)
	{
parent.frames[3].document.forms[0].addr_line_1.disabled=true
	parent.frames[3].document.forms[0].addr_line_1.value=""
	}
if(parent.frames[3].document.forms[0].addr_line_2!=null)
{
parent.frames[3].document.forms[0].addr_line_2.disabled=true
parent.frames[3].document.forms[0].addr_line_2.value=""
}
if(parent.frames[3].document.forms[0].addr_line_3!=null)
	{
parent.frames[3].document.forms[0].addr_line_3.disabled=true
	parent.frames[3].document.forms[0].addr_line_3.value=""
	}
if(parent.frames[3].document.forms[0].addr_line_4!=null)
	{
parent.frames[3].document.forms[0].addr_line_4.disabled=true
	parent.frames[3].document.forms[0].addr_line_4.value=""
	}
if(parent.frames[3].document.forms[0].postal_code!=null)
	{
parent.frames[3].document.forms[0].postal_code.disabled=true
	parent.frames[3].document.forms[0].postal_code.value=""
	}
parent.frames[3].document.forms[0].COUNTRY_DESC.disabled=true
parent.frames[3].document.forms[0].COUNTRY_DESC.value=""
parent.frames[3].document.forms[0].TELEPHONE_OFF.disabled=true
parent.frames[3].document.forms[0].TELEPHONE_OFF.value="";
parent.frames[3].document.forms[0].TELEPHONE_RES.disabled=true
parent.frames[3].document.forms[0].TELEPHONE_RES.value="";
parent.frames[3].document.forms[0].MOB_TEL_NO.disabled=true
parent.frames[3].document.forms[0].MOB_TEL_NO.value=""
parent.frames[3].document.forms[0].NAT_ID_NO.disabled=true
parent.frames[3].document.forms[0].NAT_ID_NO.value=""
parent.frames[3].document.forms[0].EMAIL_ID.disabled=true
parent.frames[3].document.forms[0].EMAIL_ID.value=""
parent.frames[3].document.forms[0].id3.style.visibility='hidden';  // Added Aginst PAS-INC-MO -> Release Deceased/Body Part [IN:043269] By Saanthaakumar
}else
if(obj.value=='K')
{parent.frames[3].document.getElementById("hed1").style.visibility="hidden"
parent.frames[3].document.getElementById("ocpnlab").style.visibility="hidden"

document.getElementById("id3").style.visibility='hidden';
document.forms[0].CLAIMANT_TYPE_CODE.disabled=true
document.forms[0].NAME.disabled=false;
document.forms[0].RELATIONSHIP.disabled=false;

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
	{
	document.forms[0].PASSPORT_NO.disabled=false
	document.forms[0].OTHER_IDENTIFICATION.disabled=false
	}

document.forms[0].PATIENT_EMPLOYEE_ID.disabled=false
document.forms[0].ORGANIZATION_NAME.disabled=false

document.forms[0].JOB_TITLE.disabled=false
if(parent.frames[3].document.getElementById("twnsrch"))
parent.frames[3].document.getElementById("twnsrch").disabled=false;
if(parent.frames[3].document.getElementById("areasrch"))
parent.frames[3].document.getElementById("areasrch").disabled=false;
if(parent.frames[3].document.getElementById("rgnsrh"))
	parent.frames[3].document.getElementById("rgnsrh").disabled=false;

if(document.getElementById("area")!=null)
document.forms[0].area.value=""

if(document.getElementById("town")!=null)
document.forms[0].town.value=""

if(document.getElementById("region")!=null)
document.forms[0].region.value=""


if(document.getElementById("area1")!=null)
document.forms[0].area1.value=""

if(document.getElementById("town1")!=null)
document.forms[0].town1.value=""

if(document.getElementById("region1")!=null)
document.forms[0].region1.value=""

if(document.getElementById("area")!=null)
document.forms[0].area.disabled=false
if(document.getElementById("town")!=null)
document.forms[0].town.disabled=false

if(document.getElementById("region")!=null)
document.forms[0].region.disabled=false


if(document.getElementById("addr_line_1")!=null)
document.forms[0].addr_line_1.disabled=false


if(document.getElementById("addr_line_2")!=null)
document.forms[0].addr_line_2.disabled=false
if(document.getElementById("addr_line_3")!=null)
document.forms[0].addr_line_3.disabled=false
if(document.getElementById("addr_line_4")!=null)
document.forms[0].addr_line_4.disabled=false
if(document.getElementById("postal_code")!=null)
document.forms[0].postal_code.disabled=false
document.forms[0].COUNTRY_DESC.disabled=false
document.forms[0].TELEPHONE_OFF.disabled=false
document.forms[0].TELEPHONE_RES.disabled=false
document.forms[0].MOB_TEL_NO.disabled=false
document.forms[0].NAT_ID_NO.disabled=false
document.forms[0].EMAIL_ID.disabled=false
document.forms[0].NAME.value="";
document.forms[0].RELATIONSHIP.options[0].selected=true;

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
	{
	document.forms[0].PASSPORT_NO.value=""
	document.forms[0].OTHER_IDENTIFICATION.value=""
	}
	
document.forms[0].PATIENT_EMPLOYEE_ID.value=""
document.forms[0].ORGANIZATION_NAME.value=""
document.forms[0].JOB_TITLE.value=""
if(document.getElementById("addr_line_1")!=null)
document.forms[0].addr_line_1.value=""
if(document.getElementById("addr_line_2")!=null)
document.forms[0].addr_line_2.value=""
if(document.getElementById("addr_line_3")!=null)
document.forms[0].addr_line_3.value=""
if(document.getElementById("addr_line_4")!=null)
document.forms[0].addr_line_4.value=""
if(document.getElementById("postal_code")!=null)
document.forms[0].postal_code.value=""
document.forms[0].COUNTRY_DESC.value=""
document.forms[0].TELEPHONE_OFF.value=""
document.forms[0].TELEPHONE_RES.value=""
document.forms[0].MOB_TEL_NO.value=""
document.forms[0].NAT_ID_NO.value=""
document.forms[0].EMAIL_ID.value=""
document.forms[0].copydet.disabled=false;
document.forms[0].NAT_ID_NO.readOnly=false;
document.forms[0].EMAIL_ID.readOnly=false
//parent.frames[3].document.getElementById("pstsrh").disabled=false;
if(parent.frames[3].document.getElementById("postal_search"))
parent.frames[3].document.getElementById("postal_search").disabled=false;
if(parent.frames[3].document.getElementById("cntrysrh"))
parent.frames[3].document.getElementById("cntrysrh").disabled=false;
if(parent.frames[3].document.getElementById("twnsearch"))
parent.frames[3].document.getElementById("twnsearch").disabled=false;
}else if(obj.value=='E' || obj.value=='F')//changes for 38265
{
if(document.getElementById("area1")!=null)
document.forms[0].area1.value=""

if(document.getElementById("town1")!=null)
document.forms[0].town1.value=""

if(document.getElementById("region1")!=null)
document.forms[0].region1.value=""

if(document.getElementById("area")!=null)
document.forms[0].area.value=""

if(document.getElementById("town")!=null)
document.forms[0].town.value=""

if(document.getElementById("region")!=null)
document.forms[0].region.value=""
if(parent.frames[3].document.getElementById("twnsrch"))
parent.frames[3].document.getElementById("twnsrch").disabled=false;
if(parent.frames[3].document.getElementById("areasrch"))
parent.frames[3].document.getElementById("areasrch").disabled=false;
if(parent.frames[3].document.getElementById("rgnsrh"))
	parent.frames[3].document.getElementById("rgnsrh").disabled=false;

if(document.getElementById("area")!=null)
document.forms[0].area.disabled=false

if(document.getElementById("town")!=null)
document.forms[0].town.disabled=false

if(document.getElementById("region")!=null)
document.forms[0].region.disabled=false

document.getElementById("id3").style.visibility='hidden';
document.forms[0].CLAIMANT_TYPE_CODE.disabled=true
document.forms[0].NAME.disabled=false;
document.forms[0].RELATIONSHIP.disabled=false;

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
	{
	document.forms[0].PASSPORT_NO.disabled=false
	document.forms[0].OTHER_IDENTIFICATION.disabled=false
	}

document.forms[0].PATIENT_EMPLOYEE_ID.disabled=false
document.forms[0].ORGANIZATION_NAME.disabled=false
if(document.getElementById("addr_line_1")!=null)
document.forms[0].addr_line_1.disabled=false
if(document.getElementById("addr_line_2")!=null)
document.forms[0].addr_line_2.disabled=false
if(document.getElementById("addr_line_3")!=null)
document.forms[0].addr_line_3.disabled=false
if(document.getElementById("addr_line_4")!=null)
document.forms[0].addr_line_4.disabled=false
if(document.getElementById("postal_code")!=null)
document.forms[0].postal_code.disabled=false
document.forms[0].COUNTRY_DESC.disabled=false
document.forms[0].TELEPHONE_OFF.disabled=false
document.forms[0].TELEPHONE_RES.disabled=false

document.forms[0].JOB_TITLE.disabled=false;
document.forms[0].MOB_TEL_NO.disabled=false
document.forms[0].NAT_ID_NO.readOnly=false;
document.forms[0].EMAIL_ID.readOnly=false


document.forms[0].NAME.value="";
document.forms[0].RELATIONSHIP.options[0].selected=true;

/*Modified by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
if(obj.value=='F') 
{
	document.forms[0].copydet.disabled=true;
}else
{
	document.forms[0].copydet.disabled=false;
}

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
	{
	document.forms[0].PASSPORT_NO.value=""
	document.forms[0].OTHER_IDENTIFICATION.value=""
	}

document.forms[0].PATIENT_EMPLOYEE_ID.value=""
document.forms[0].ORGANIZATION_NAME.value=""
document.forms[0].JOB_TITLE.value=""
if(document.getElementById("addr_line_1")!=null)
document.forms[0].addr_line_1.value=""
if(document.getElementById("addr_line_2")!=null)
document.forms[0].addr_line_2.value=""
if(document.getElementById("addr_line_3")!=null)
document.forms[0].addr_line_3.value=""
if(document.getElementById("addr_line_4")!=null)
document.forms[0].addr_line_4.value=""
if(document.getElementById("postal_code")!=null)
document.forms[0].postal_code.value=""
document.forms[0].COUNTRY_DESC.value=""
document.forms[0].TELEPHONE_OFF.value=""
document.forms[0].TELEPHONE_RES.value=""
document.forms[0].MOB_TEL_NO.value=""
document.forms[0].NAT_ID_NO.value=""
document.forms[0].EMAIL_ID.value=""
//parent.frames[3].document.getElementById("pstsrh").disabled=false;
if(parent.frames[3].document.getElementById("postal_search"))
parent.frames[3].document.getElementById("postal_search").disabled=false;
if(parent.frames[3].document.getElementById("cntrysrh"))
parent.frames[3].document.getElementById("cntrysrh").disabled=false;
if(parent.frames[3].document.getElementById("twnsearch"))
parent.frames[3].document.getElementById("twnsearch").disabled=false;
}else
{parent.frames[3].document.getElementById("hed1").style.visibility="hidden"
parent.frames[3].document.getElementById("ocpnlab").style.visibility="hidden"

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
{
	/*Modified by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
	if(obj.value=='M')
	{
		document.getElementById("id3").style.visibility='visible';
	}else
	{
		document.getElementById("id3").style.visibility='hidden';
	}	
}else{
	document.getElementById("id3").style.visibility='visible';
}
document.forms[0].CLAIMANT_TYPE_CODE.disabled=false
document.forms[0].NAME.disabled=false;
document.forms[0].RELATIONSHIP.disabled=false;

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
	{
	document.forms[0].PASSPORT_NO.disabled=false
	document.forms[0].OTHER_IDENTIFICATION.disabled=false
	}

document.forms[0].PATIENT_EMPLOYEE_ID.disabled=false
document.forms[0].ORGANIZATION_NAME.disabled=false
if(document.getElementById("addr_line_1")!=null)
document.forms[0].addr_line_1.disabled=false
if(document.getElementById("addr_line_2")!=null)
document.forms[0].addr_line_2.disabled=false
if(document.getElementById("addr_line_3")!=null)
document.forms[0].addr_line_3.disabled=false
if(document.getElementById("addr_line_4")!=null)
document.forms[0].addr_line_4.disabled=false
if(document.getElementById("postal_code")!=null)
document.forms[0].postal_code.disabled=false
document.forms[0].COUNTRY_DESC.disabled=false
document.forms[0].TELEPHONE_OFF.disabled=false
document.forms[0].TELEPHONE_RES.disabled=false
document.forms[0].JOB_TITLE.disabled=false;
document.forms[0].MOB_TEL_NO.disabled=false
document.forms[0].NAT_ID_NO.disabled=false;
document.forms[0].EMAIL_ID.disabled=false
document.forms[0].NAME.value="";
document.forms[0].RELATIONSHIP.options[0].selected=false;
document.forms[0].copydet.disabled=true; //Modified by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
	{
	document.forms[0].PASSPORT_NO.value=""
	document.forms[0].OTHER_IDENTIFICATION.value=""
	}

document.forms[0].PATIENT_EMPLOYEE_ID.value=""
document.forms[0].ORGANIZATION_NAME.value=""
document.forms[0].JOB_TITLE.value=""
if(parent.frames[3].document.getElementById("twnsrch"))
parent.frames[3].document.getElementById("twnsrch").disabled=false;
if(parent.frames[3].document.getElementById("areasrch"))
parent.frames[3].document.getElementById("areasrch").disabled=false;
if(parent.frames[3].document.getElementById("rgnsrh"))
	parent.frames[3].document.getElementById("rgnsrh").disabled=false;

if(document.getElementById("area")!=null)
document.forms[0].area.value=""

if(document.getElementById("town")!=null)
document.forms[0].town.value=""

if(document.getElementById("region")!=null)
document.forms[0].region.value=""


if(document.getElementById("area1")!=null)
document.forms[0].area1.value=""

if(document.getElementById("town1")!=null)
document.forms[0].town1.value=""

if(document.getElementById("region1")!=null)
document.forms[0].region1.value=""

if(document.getElementById("area")!=null)
document.forms[0].area.disabled=false

if(document.getElementById("town")!=null)
document.forms[0].town.disabled=false

if(document.getElementById("region")!=null)
document.forms[0].region.disabled=false

if(document.getElementById("addr_line_1")!=null)
document.forms[0].addr_line_1.value=""
if(document.getElementById("addr_line_2")!=null)
document.forms[0].addr_line_2.value=""
if(document.getElementById("addr_line_3")!=null)
document.forms[0].addr_line_3.value=""
if(document.getElementById("addr_line_4")!=null)
document.forms[0].addr_line_4.value=""
if(document.getElementById("postal_code")!=null)
document.forms[0].postal_code.value=""
document.forms[0].COUNTRY_DESC.value=""
document.forms[0].TELEPHONE_OFF.value=""
document.forms[0].TELEPHONE_RES.value=""
document.forms[0].MOB_TEL_NO.value=""
document.forms[0].NAT_ID_NO.value=""
document.forms[0].EMAIL_ID.value=""
//parent.frames[3].document.getElementById("pstsrh").disabled=false;
if(parent.frames[3].document.getElementById("postal_search"))
parent.frames[3].document.getElementById("postal_search").disabled=false;
if(parent.frames[3].document.getElementById("cntrysrh"))
parent.frames[3].document.getElementById("cntrysrh").disabled=false;
if(parent.frames[3].document.getElementById("twnsearch"))
parent.frames[3].document.getElementById("twnsearch").disabled=false;




}
//Below Condition Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
if(obj.value=='F')
{
parent.frames[3].document.getElementById("releasefacid").style.visibility="visible"
parent.frames[3].document.getElementById("releasefacdesc").style.visibility="visible"
parent.frames[3].document.getElementById("remarksid").style.visibility="visible"
parent.frames[3].document.getElementById("remarksdesc").style.visibility="visible"

}
else
{
parent.frames[3].document.getElementById("releasefacid").style.visibility="hidden"
parent.frames[3].document.getElementById("releasefacdesc").style.visibility="hidden"
parent.frames[3].document.getElementById("remarksid").style.visibility="hidden"
parent.frames[3].document.getElementById("remarksdesc").style.visibility="hidden"

}
//Condition End

var selclaim = obj.value ;
HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMO/jsp/GetClaim.jsp?criteria=populateClaim'><input type='hidden' name='selclaim' id='selclaim' value='"+selclaim+"'><input type='hidden' name='cliamcode' id='cliamcode' value='"+claimcode+"'></form></body></html>";
parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
parent.frames[2].document.forms[0].submit();
}	






/*function set_values1(claimtype,claim,patient_id,param)
  { 

	 //name3=document.forms[0].Pid.value;
    
	
	 times = 'Y';

	

	if(claim=="")
	 {
	parent.disp_details.location.href="../../eMO/jsp/MORegisterClaimantResult.jsp?"+param+"&load3="+claimtype+"&ti="+times
	 }else
	  {
    parent.disp_details.location.href="../../eMO/jsp/MORegisterClaimantResult.jsp?param="+param+"&value1="+claim+"&ctype="+claimtype+"&pid="+patient_id
	  }
  }*/




function set_values(obj,patient_id)
  { 

CLAIMANT_TYPE=document.forms[0].CLAIMANT_TYPE.value
name2=obj.value;
HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMO/jsp/MORegisterClaimantResult.jsp'><input type='hidden' name='pid' id='pid' value='"+patient_id+"'><input type='hidden' name='name1' id='name1' value='"+CLAIMANT_TYPE+"'><input type='hidden' name='ctype' id='ctype' value='"+name2+"'></form></body></html>";
parent.frames[4].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
parent.frames[4].document.dum_form.submit();

	 

	
  
  }
 
 
 
 function copyDet(patient_id)
 {CLAIMANT_TYPE=document.forms[0].CLAIMANT_TYPE.value
	  
HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMO/jsp/MORegisterClaimantResult.jsp'><input type='hidden' name='pid' id='pid' value='"+patient_id+"'><input type='hidden' name='name1' id='name1' value='"+CLAIMANT_TYPE+"'></form></body></html>";
parent.frames[4].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
parent.frames[4].document.dum_form.submit();




}
 




async function getConsentFormforDonar()
{
 
 var title = getLabel("eMO.ConsentOrgnDtn.label","MO"); 
 var dialogHeight = "65vh" ;
 var dialogWidth  = "45vw" ;
 var dialogTop    = "225";
 var dialogLeft   = "225";
 var patient_id = document.forms[0].patient_id.value;
 var sys_date = document.forms[0].system_date.value;
 var mode=document.forms[0].mode.value;
 conscentgivenby=document.forms[0].conscentgivenby1.value;
deceasedrelationship=document.forms[0].deceasedrelationship1.value;
consent_received_by=document.forms[0].consent_received_by1.value;
consent_received_date=document.forms[0].consent_received_date1.value;
 consent_received_desc2=document.forms[0].consent_received_desc2.value;
 var mode=document.forms[0].mode.value;
 var body_received_date_time = document.forms[0].body_received_date_time.value;
 var result		  = document.forms[0].consent_form_code1.value+"||"+document.forms[0].consent_desc1.value;
 var arguments       = result ;
 var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ ";          dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
 retVal	= await window.showModalDialog("../../eMO/jsp/ConsentDetailsFrameSet.jsp?patient_id="+patient_id+"&sys_date="+sys_date+"&body_received_date_time="+body_received_date_time+"&conscentgivenby="+conscentgivenby+"&deceasedrelationship="+deceasedrelationship+"&consent_received_by="+consent_received_by+"&consent_received_date="+consent_received_date+"&title="+title+"&consent_received_desc="+consent_received_desc2+"&mode="+mode,arguments,features);

  if(retVal!="" &retVal!=null)
	{
	 var finalresults=retVal.split("||");
	 document.getElementById("consent_form_code1").value = finalresults[0]
	 document.getElementById("consent_desc1").value = finalresults[1]
	 document.getElementById("conscentgivenby1").value = finalresults[2]
	 document.getElementById("deceasedrelationship1").value = finalresults[3]
	 document.getElementById("consent_received_by1").value = finalresults[4]
     document.getElementById("consent_received_date1").value = finalresults[5]
     document.getElementById("consent_received_desc2").value = finalresults[6]
	 
	 }
}
async function donarcardInfo()
{
 var dialogHeight = "65vh" ;
 var dialogWidth  = "45vw" ;
 var dialogTop    = "225";
 var dialogLeft   = "225";
  
 var sys_date = document.forms[0].system_date.value;
 var body_received_date_time = document.forms[0].body_received_date_time.value;
  donardetails=document.getElementById("donardetails").value 
 donar_card_no=document.getElementById("donar_card_no").value 
 mode=document.getElementById("mode").value
 
     
 
 var result		  = "";

 var arguments       = result ;
 var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ ";      dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

  retVal	= await window.showModalDialog("../../eMO/jsp/MODonarCardInfo.jsp?donar_card_no="+donar_card_no+"&sys_date="+sys_date+"&body_received_date_time="+body_received_date_time+"&donardetails="+donardetails+"&mode="+mode,arguments,features);


 
 if(retVal!=""&&retVal!=null )
	{
	 var finalresults=retVal.split("||");
	 document.getElementById("donar_card_no").value = finalresults[0]
	 document.getElementById("donardetails").value = finalresults[1]
	 
     
	 
	 }
}










function closeme_polece()
{
	/*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
	var polCalledFrom				= document.getElementById("polCalledFrom").value;
	var polExternalBidBodyPartYn	= document.getElementById("polExternalBidBodyPartYn").value;
	var makeMand					= document.getElementById("makeMand").value;
	/*End*/
	if(document.getElementById("police_approval_received_yn").checked)
	document.getElementById("police_approval_received_yn").value="Y"
	else
	document.getElementById("police_approval_received_yn").value="N"

	pol_rep_no=document.getElementById("pol_rep_no").value
	pol_stn_id=document.getElementById("pol_stn_id").value
	pol_id=document.getElementById("pol_id").value
	police_details=document.getElementById("police_details").value	
	police_approval_received_yn=document.getElementById("police_approval_received_yn").value
	police_received_date=document.getElementById("police_received_date").value
	police_received_by=document.getElementById("police_received_by").value
	police_received_by_desc=document.getElementById("police_received_by_desc").value
	/*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
	if(polCalledFrom == "MO_BID_REGN" || polCalledFrom == "MO_EBP_REGN" || polExternalBidBodyPartYn == "Y"){
		pol_officer_name=document.getElementById("pol_officer_name").value;
		pol_contact_no=document.getElementById("pol_contact_no").value;
	}/*End*/
	/*
if((pol_rep_no=="")||(pol_stn_id=="")||(pol_id=="")||(police_details==""))
{
	if(document.getElementById("police_approval_received_yn").checked)
	{
	if(police_received_date!="" &&police_received_by!="")
		{
		}else
		{  
		
		alert(getMessage("ENTER_POLICE_DTLS","MO"));
		return false;
		}
    
	} 
}else if((pol_stn_id!="")&&(pol_id!="")&&(police_details!=""))
	{
	if(document.getElementById("police_approval_received_yn").checked)
	{
	if(police_received_date!="" &&police_received_by!="")
		{
		}else
		{
		alert(getMessage("ENTER_POLICE_DTLS","MO"));
	    return false
		}
	}
	
	}else
	{
	alert(getMessage("ENTER_POLICE_DTLS","MO"));
	return false
	}

	*/
	if(makeMand == "Y"){//Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689
		if((pol_rep_no=="")||(pol_stn_id=="")||(pol_id=="")||(police_details==""))
		{
		
			alert(getMessage("ENTER_POLICE_DTLS","MO"));
			return false;
		
		}

		if(document.getElementById("police_approval_received_yn").checked)
		{
		
		if((document.getElementById("police_received_by").value!=""&&document.getElementById("police_received_date").value==""))
		  {
				var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
				msg = msg.replace('$',getLabel("eMO.Police61RecvdDt.label","MO"));
				alert(msg);

				//alert("APP-000001 Police Received Date/Time cannot be blank...");
			return false;    
		  }
		  if((document.getElementById("police_received_date").value==""&&document.getElementById("police_received_by").value==""))
		  {

			var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
			msg = msg.replace('$',getLabel("eMO.Police61RecvdBy.label","MO"));
			alert(msg);
			//alert("APP-000001 Police Received By cannot be blank...");
			return false    
			}  
		}
	}
	if(eval(document.getElementById("police_details").value.length)>500 )
	{      
		error=getMessage('POLICE_DET_EXCEEDS_LMT','MO')  
		alert(error);
		return false    
	}
	/*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
	if(polCalledFrom == "MO_EBP_REGN" || polCalledFrom == "MO_BID_REGN" || polExternalBidBodyPartYn == "Y"){
		var closevalue = document.getElementById("pol_rep_no").value+"||"+document.getElementById("pol_stn_id").value+"||"+		document.getElementById("pol_id").value+"||"+document.getElementById("police_details").value+"||"+document.getElementById("police_approval_received_yn").value+"||"+document.getElementById("police_received_by").value+"||"+document.getElementById("police_received_date").value+"||"+document.getElementById("police_received_by_desc").value+"||"+document.getElementById("pol_officer_name").value+"||"+document.getElementById("pol_contact_no").value; 
	}else{/*End*/
		var closevalue = document.getElementById("pol_rep_no").value+"||"+document.getElementById("pol_stn_id").value+"||"+		document.getElementById("pol_id").value+"||"+document.getElementById("police_details").value+"||"+document.getElementById("police_approval_received_yn").value+"||"+document.getElementById("police_received_by").value+"||"+document.getElementById("police_received_date").value+"||"+document.getElementById("police_received_by_desc").value;
	}
	window.returnValue = closevalue;
	
	


	window.close();
	
	
	
	
}
function close_me()
{
	window.close();
}
function closeme()
{


   if((document.getElementById("consent_received_desc").value!=""&&document.getElementById("consent_received_date").value==""))
	     {
	  	    var err=getMessage("CAN_NOT_BE_BLANK","Common");
			err= err.replace('$',getLabel("eMO.ConsentFormReceivDate.label","MO"));
			alert(err);
			
			//	alert("APP-000001 Consent Received Date/Time cannot be blank...");
		return false    
	     } if((document.getElementById("consent_received_desc").value==""&&document.getElementById("consent_received_date").value!=""))
	{

		var err=getMessage("CAN_NOT_BE_BLANK","Common");
			err= err.replace('$',getLabel("eMO.ConsentFormReceivedBy.label","MO"));
			alert(err);
		//alert("APP-000001 Consent Received By cannot be blank...");
		return false    
	    
	
	}
consent_code=document.getElementById("consent_code").value
terms_desc=document.getElementById("terms_desc").value
conscentgivenby=document.getElementById("conscentgivenby").value
deceasedrelationship=document.getElementById("deceasedrelationship").value	
consent_received_by=document.getElementById("consent_received_by").value
consent_received_date=document.getElementById("consent_received_date").value
consent_received_desc=document.getElementById("consent_received_desc").value	
if((consent_code=="")&&(conscentgivenby=="")&&(deceasedrelationship=="")&&(consent_received_desc=="")&&(consent_received_date==""))
{

}else if((consent_code!="")&&(conscentgivenby!="")&&(deceasedrelationship!="")&&(consent_received_desc!="")&&(consent_received_date!=""))
{

}else 
{
	alert(getMessage("CAPTURE_CONSENT_DTLS","MO"));
	//alert("APP-000001 ALL the Consent details must be captured")
	return false;
}



var closevalue = consent_code+"||"+terms_desc+"||"+		conscentgivenby+"||"+deceasedrelationship+"||"+consent_received_by+"||"+consent_received_date+"||"+consent_received_desc;
	window.returnValue = closevalue;
	
	document.getElementById("terms_desc").innerText="";

	window.close();
	

}
function closedonar()
{
var donar_card_no=document.getElementById("donar_card_no").value
var donar_details=document.getElementById("donar_details").value
if(donar_details.length>500)
{
alert(getMessage("DONOR_DETAILS_EXCEEDS_LIMIT","MO"));
return false;
}
if((donar_card_no=="")&&(donar_details==""))
{

}else if((donar_card_no!="")&&(donar_details!=""))
{

}else 
{
	alert(getMessage("CAPTURE_DONOR_DTLS","MO"));
	//alert("APP-000001 doDateTimeChk1 must be captured")
	return false;
}

	
	
	var closevalue = document.getElementById("donar_card_no").value+"||"+document.getElementById("donar_details").value;
	window.returnValue = closevalue;
	
	
    

	window.close();
	


}

function callreport(patient_id)
{
	var  code = document.forms[0].consent_code.value;
	//var patient_id = '<%=patient_id%>'

	
	
	var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH  code=\""+code+"\" patient_id=\""+patient_id+"\"/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ReportConsentForm.jsp",false);
	xmlHttp.send(xmlDoc)
		
}



function dispdetails()
{
	
	var code = document.forms[0].consent_code.value;
	var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH code=\""+code+"\"/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ConsentDetails.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
    document.forms[0].terms_desc.value = responseText;	
	

 }
 function populatedetails()
 {
	 var result=parent.window.dialogArguments;
	 
	 var consent_values=result.split("||");
	 document.getElementById("consent_code").value = consent_values[0];
	 document.getElementById("terms_desc").value=consent_values[1];
 }
/*function lockKey()
	 {
	    if(event.keyCode == 93)
		    alert(getMessage("WELCOME","Common"));
	 }*/
	
	 function chk()
	 {
		document.getElementById("tab2").focus();

	 }
	 function deathvalue()
	 {
		 if(document.getElementById("death_certificate_reqd_yn").checked==true)
				document.getElementById("death_certificate_reqd_yn").value = "Y"
		 else
			    document.getElementById("death_certificate_reqd_yn").value = "N"
	 }
	 function policevalue()
	 {
		 if(document.getElementById("brought_by_police_yn").checked==true)
				document.getElementById("brought_by_police_yn").value = "Y"
		 else
			    document.getElementById("brought_by_police_yn").value = "N"
	 } 
	 
	 function assignpolicedetails()
	 {
		if(document.getElementById("Police_Details").checked==true)
		 {
			document.getElementById("Police_Details").value="Y";
			document.getElementById("consent_form_code").value="";
			document.getElementById("consent_chk").value.value="N";
		 }
		else
		   document.getElementById("Police_Details").value="N";
	 }
    function tab_click1(objName)
	{
			if(objName=="#kin")
			{
				
				document.getElementById("kin").scrollIntoView();
				//document.getElementById("next_contact_name").focus();
			}
			if(objName=="#kin1")
			{
				
				document.getElementById("kin1").scrollIntoView();
				//document.getElementById("first_contact_name").focus();
			}
			if(objName=="#empyr")
			{
				
				document.getElementById("empyr").scrollIntoView();
				
			}
	}
	function emponblur()
	{
		document.getElementById("body_received_date_time").focus();
	}
	function enableservices(areacode,postmortem_reqd_yn,posttype,startendstat)
	{	
		  
		if(document.getElementById("postmortem_reqd_yn").checked ==false&&document.getElementById("mlc_yn").checked==true)
		{
		document.getElementById("Police_Details").disabled=false;
		document.getElementById("Consent_forms").disabled=true;
		
		document.getElementById("postmortem_reqd_yn").value='N';
        document.getElementById("mlc_yn").value='Y';
		document.getElementById("postmortem_type").options[0].selected=true;
		
		}else
        
		if( document.getElementById("postmortem_reqd_yn").checked ==false&&document.getElementById("mlc_yn").checked==false)
		{document.getElementById("Police_Details").disabled=true;
		document.getElementById("Consent_forms").disabled=true;
		
		document.getElementById("postmortem_reqd_yn").value='N';
         document.getElementById("mlc_yn").value='N';
		document.getElementById("postmortem_type").options[0].selected=true;
		
		}else

		if(document.getElementById("postmortem_reqd_yn").checked == true&& document.getElementById("mlc_yn").checked==true)
		{
		document.getElementById("Police_Details").disabled=false;
		document.getElementById("Consent_forms").disabled=true;
		document.getElementById("postmortem_reqd_yn").value='Y';
        document.getElementById("mlc_yn").value='Y';
		document.getElementById("postmortem_type").options[2].selected=true;
		
		}else if(document.getElementById("postmortem_reqd_yn").checked == true && document.getElementById("mlc_yn").checked==false)
		{document.getElementById("Police_Details").disabled=true;
		document.getElementById("Consent_forms").disabled=false;
		document.getElementById("postmortem_reqd_yn").value='Y';
         document.getElementById("mlc_yn").value='N';
		document.getElementById("postmortem_type").options[1].selected=true;
		
		}
		//if(document.getElementById("postmortem_reqd_yn").checked == true)
		//{
		if((startendstat!="E"||document.getElementById("startendstat").value!="E")&&document.getElementById("postmortem_reqd_yn").checked == true)	
		   {	
				//Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696
				if(document.getElementById("rearrangeTabBurlPermtClaimnt") && document.getElementById("rearrangeTabBurlPermtClaimnt").value=="true"){
				document.getElementById("claimantDis3").style.display = 'none';
				var tit=getLabel("eMO.Claimant.label","MO");
				document.getElementById("dis3").title=getLabel("eMO.Claimant.label","MO");
				document.getElementById("dis3").innerHTML="<a onclick=javascript:tab_enable('claimant_tab') id='claimant_tab' class='tabA'><span class='tabAspan' id='claimant_tabspan'>"+tit+"</span></a>";
				}else{
		     	document.getElementById("dis3").style.visibility="hidden";
				}
				
				//Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696
				if(document.getElementById("rearrangeTabBurlPermtClaimnt") && document.getElementById("rearrangeTabBurlPermtClaimnt").value=="true"){
				document.getElementById("claimantDis").style.display = 'none';
				var tit=getLabel("eMO.Claimant.label","MO");
				document.getElementById("dis").title=getLabel("eMO.Claimant.label","MO");
				document.getElementById("dis").innerHTML="<a onclick=javascript:tab_enable('claimant_tab') id='claimant_tab' class='tabA'><span class='tabAspan' id='claimant_tabspan'>"+tit+"</span></a>";
				}else{
				document.getElementById("dis").style.visibility="hidden";			
				}
				
			    if(document.getElementById("dis").style.visibility=="hidden")  // Tuesday, February 02, 2010 IN018776 Venkat S
				{
				var maxrecord_count = document.getElementById("maxrecord_count").value;
				var burial_permit_appr_by_name1 = document.getElementById("burial_permit_appr_by_name1").value;
				var burial_permit_app_desc = document.getElementById("burial_permit_app_desc").value;
				if(maxrecord_count>0)
				{
				//document.forms[0].vechile_no.value=""; Commented by dharma on dec 26 2013 against IN:045900
				}
				else
				{
				document.forms[0].generate_burial_permit.checked=false;
				//document.forms[0].body_burial_permit_no.value="";Commented by dharma on dec 26 2013 against IN:045900
				//document.forms[0].vechile_no.value="";Commented by dharma on dec 26 2013 against IN:045900
				if(burial_permit_appr_by_name1!='')
				{
				  document.forms[0].burial_permit_app_desc.value=burial_permit_appr_by_name1;
				} //else
				 // document.forms[0].burial_permit_app_desc.value="";Commented by dharma on dec 26 2013 against IN:045900

				}
				} // End.
				
				//Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696
				if(document.getElementById("rearrangeTabBurlPermtClaimnt") && document.getElementById("rearrangeTabBurlPermtClaimnt").value=="true"){
				document.getElementById("clmt").style.display = 'none';
				var tit=getLabel("eMO.Claimant.label","MO");
				document.getElementById("dis1").title=getLabel("eMO.Claimant.label","MO");
				document.getElementById("dis1").innerHTML="<a onclick=javascript:tab_enable('claimant_tab') id='claimant_tab' class='tabClicked'><span class='tabSpanclicked' id='claimant_tabspan'>"+tit+"</span></a>";
				}else{
				document.getElementById("dis1").style.visibility="hidden";
				}
				document.getElementById("dis4").style.visibility="hidden"; 
		    }
			else
			 {
				
				/*document.getElementById("dis3").style.visibility="visible";
		        document.getElementById("dis").style.visibility="visible";
			    document.getElementById("dis1").style.visibility="visible";
			    document.getElementById("dis4").style.visibility="visible";*/
			    // Modified Against  Bru-HIMS-CRF-368-Linked Inc-06-Burial Permit Tab [IN:045909] by Dharma on 23rd Dec 2013 
				if(document.getElementById("postmortem_reqd_yn").checked == true && document.getElementById("external").value=="Y" && document.getElementById("mode").value=="insert"){

				//Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696
				if(document.getElementById("rearrangeTabBurlPermtClaimnt") && document.getElementById("rearrangeTabBurlPermtClaimnt").value=="true"){
				document.getElementById("claimantDis3").style.display = 'none';
				var tit=getLabel("eMO.Claimant.label","MO");
				document.getElementById("dis3").title=getLabel("eMO.Claimant.label","MO");
				document.getElementById("dis3").innerHTML="<a onclick=javascript:tab_enable('claimant_tab') id='claimant_tab' class='tabA'><span class='tabAspan' id='claimant_tabspan'>"+tit+"</span></a>";
				}else{
					document.getElementById("dis3").style.visibility="hidden";
				}
				//Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696
				if(document.getElementById("rearrangeTabBurlPermtClaimnt") && document.getElementById("rearrangeTabBurlPermtClaimnt").value=="true"){
				document.getElementById("claimantDis").style.display = 'none';
				var tit=getLabel("eMO.Claimant.label","MO");
				document.getElementById("dis").title=getLabel("eMO.Claimant.label","MO");
				document.getElementById("dis").innerHTML="<a onclick=javascript:tab_enable('claimant_tab') id='claimant_tab' class='tabA'><span class='tabAspan' id='claimant_tabspan'>"+tit+"</span></a>";				
				}else{
				document.getElementById("dis").style.visibility="hidden";		
				}
				//Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696
				if(document.getElementById("rearrangeTabBurlPermtClaimnt") && document.getElementById("rearrangeTabBurlPermtClaimnt").value=="true"){
				document.getElementById("clmt").style.display = 'none';
				var tit=getLabel("eMO.Claimant.label","MO");
				document.getElementById("dis1").title=getLabel("eMO.Claimant.label","MO");
				document.getElementById("dis1").innerHTML="<a onclick=javascript:tab_enable('claimant_tab') id='claimant_tab' class='tabClicked'><span class='tabSpanclicked' id='claimant_tabspan'>"+tit+"</span></a>";
				}else{
				    document.getElementById("dis1").style.visibility="hidden";
				}
				    document.getElementById("dis4").style.visibility="hidden";
				}else{		    

				    document.getElementById("dis4").style.visibility="visible";	
					
			//Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696	    
			if(document.getElementById("rearrangeTabBurlPermtClaimnt") && document.getElementById("rearrangeTabBurlPermtClaimnt").value=="true"){					
					document.getElementById("claimantDis").style.display = 'block';					
					var tit1=getLabel("eMO.BurialPermit.label","MO");
					document.getElementById("dis").title=getLabel("eMO.BurialPermit.label","MO");
					document.getElementById("dis").innerHTML="<a onclick=javascript:tab_enable('burial_prmt_tab') id='burial_prmt_tab' class='tabA'> <span class='tabAspan' id='burial_prmt_tabspan'>"+tit1+"</a>";					
				var tit=getLabel("eMO.Claimant.label","MO");
				document.getElementById("claimantDis").innerHTML="<a onclick=javascript:tab_enable('claimant_tab') id='claimant_tab' class='tabA'><span class='tabAspan' id='claimant_tabspan'>"+tit+"</span></a>";
				}else{
				   document.getElementById("dis").style.visibility="visible";
				}
			
			//Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696
			if(document.getElementById("rearrangeTabBurlPermtClaimnt") && document.getElementById("rearrangeTabBurlPermtClaimnt").value=="true"){					
					document.getElementById("clmt").style.display = 'block';					
					var tit1=getLabel("eMO.BurialPermit.label","MO");
					document.getElementById("dis1").title=getLabel("eMO.BurialPermit.label","MO");
					document.getElementById("dis1").innerHTML="<a onclick=javascript:tab_enable('burial_prmt_tab') id='burial_prmt_tab' class='tabA'> <span class='tabAspan' id='burial_prmt_tabspan'>"+tit1+"</a>";					
				var tit=getLabel("eMO.Claimant.label","MO");
				document.getElementById("clmt").innerHTML="<a onclick=javascript:tab_enable('claimant_tab') id='claimant_tab' class='tabClicked'><span class='tabSpanclicked' id='claimant_tabspan'>"+tit+"</span></a>";
				}else{
				   document.getElementById("dis1").style.visibility="visible";
				}

			//Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696
			if(document.getElementById("rearrangeTabBurlPermtClaimnt") && document.getElementById("rearrangeTabBurlPermtClaimnt").value=="true"){					
					document.getElementById("claimantDis3").style.display = 'block';					
					var tit1=getLabel("eMO.BurialPermit.label","MO");
					document.getElementById("dis3").title=getLabel("eMO.BurialPermit.label","MO");
					document.getElementById("dis3").innerHTML="<a onclick=javascript:tab_enable('burial_prmt_tab') id='burial_prmt_tab' class='tabA'> <span class='tabAspan' id='burial_prmt_tabspan'>"+tit1+"</a>";					
				var tit=getLabel("eMO.Claimant.label","MO");
				document.getElementById("claimantDis3").innerHTML="<a onclick=javascript:tab_enable('claimant_tab') id='claimant_tab' class='tabA'><span class='tabAspan' id='claimant_tabspan'>"+tit+"</span></a>";
				}else{
				   document.getElementById("dis3").style.visibility="visible";
				}
					//document.getElementById('dis').style.display = "block";
						
				}
							
			 }
		
		 if(document.getElementById("mode").value=="viewdata")
		{   
			    document.getElementById("mlc_yn").disabled=true 
				document.getElementById("postmortem_reqd_yn").disabled=true
		}
		
		//checked on the time of insert
	/*if(postmortem_reqd_yn=="Y" &&document.forms[0].mlc_yn.checked==false)
	  posttype="C"
/*	if(document.forms[0].area_type.value != "")
	 {
	   document.forms[0].bed_no.disabled=false;
	   document.forms[0].bed_no.value="";
	  document.forms[0].bed_button.disabled=false
	  }
	 else{
	     document.forms[0].bed_no.disabled=true;
		  document.forms[0].bed_no.value="";
	    document.forms[0].bed_button.disabled=true
	   }
	  if(document.getElementById("postmortem_reqd_yn").value=="")postmortem_reqd_yn="N";
	  else
      document.getElementById("postmortem_reqd_yn").value=postmortem_reqd_yn;
	  if(document.getElementById("postmortem_reqd_yn").value == "N" || 
	  document.getElementById("postmortem_reqd_yn").checked == false)
	  {}
	  if(document.getElementById("postmortem_reqd_yn").value == "Y" || 
	  document.getElementById("postmortem_reqd_yn").checked == true)
      {
	  if(document.getElementById("mlc_yn").checked==false)
		{
	  if(posttype=="C")	
	    {
	     document.getElementById("postmortem_type").options[1].selected=true;
	  if(document.getElementById("mode").value!="modify"&&document.getElementById("mode").value!="viewdata")
		{
				document.getElementById("postmortem_type").disabled=true
		}
	}
	 else  
	 if(posttype=="M")
	  {
		 document.getElementById("postmortem_type").options[2].selected=true;
	     document.getElementById("Consent_forms").disabled=true;
	  }else
	  {
		if(document.getElementById("postmortem_reqd_yn").checked==true)
		{ 
			document.getElementById("postmortem_type").options[1].selected=true;
	    	document.getElementById("Consent_forms").disabled=false;
			document.getElementById("postmortem_type").disabled=true
		}
	   }
			document.getElementById("idpttype").style.visibility='visible'
 }
			
			document.getElementById("postmortem_reqd_yn").value="Y";
			
			if(document.getElementById("mode").value=="modify")
			{	
		  if(document.getElementById("areatype").value=="R"||document.getElementById("startendstat").value=="E")
				{	
		  document.getElementById("postmortem_reqd_yn").disabled = true
				}	
		  }
			if(startendstat=="E"||document.getElementById("startendstat").value=="E")
		         {
		       document.getElementById("dis3").style.visibility="visible";
		      document.getElementById("dis").style.visibility="visible";
			  document.getElementById("dis1").style.visibility="visible";
			  document.getElementById("dis4").style.visibility="visible";
			
				 }else
				{
			
			document.getElementById("dis3").style.visibility="hidden";
			document.getElementById("dis").style.visibility="hidden";
			document.getElementById("dis1").style.visibility="hidden";
			document.getElementById("dis4").style.visibility="hidden";
			
				}
			
			
			}else
		  {
			if(document.getElementById("mode").value=="modify")
			{if(document.getElementById("areatype").value=="R")
				{
			document.getElementById("postmortem_reqd_yn").disabled = true
				}	
			}
			
			document.getElementById("postmortem_type").options[0].selected=true;
			if(document.getElementById("mode").value=="modify"||document.getElementById("mode").value!="viewdata")
			  {
			if(document.getElementById("postmortem_type").value=='')
			document.getElementById("Consent_forms").disabled=true;
			  }
			document.getElementById("postmortem_type").disabled = true
			document.getElementById("idpttype").style.visibility='hidden'
			document.getElementById("dis").style.visibility="visible";
			document.getElementById("dis1").style.visibility="visible";
			document.getElementById("dis4").style.visibility="visible";
			document.getElementById("dis3").style.visibility="visible";
			
		 }*/
			
			var postmortem_reqd_yn = document.getElementById("postmortem_reqd_yn").value;
			var startendstat=document.getElementById("startendstat").value;
		    areacode=document.getElementById("area_codedum").value
			var CLAIMANT_TYPE = document.getElementById("CLAIMANT_TYPE").value;
					
		var HTMLVal = " <html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post'  action='../../eMO/jsp/MOPopulateArea.jsp' target='messageFrame'><input type='hidden' name='postmortem_reqd_yn' id='postmortem_reqd_yn' value='"+postmortem_reqd_yn+"'><input type='hidden' name='area_code' id='area_code' value='"+areacode+"'><input type='hidden' name='startendstat' id='startendstat' value='"+startendstat+"'><input type='text' name='CLAIMANT_TYPE' id='CLAIMANT_TYPE' value='"+CLAIMANT_TYPE+"'></form></body></html>";
			parent.dummyframe.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.dummyframe.document.forms[0].submit();
						

		
	}

function checkserv1()
{
if(document.getElementById("mlc_yn").checked)
{
document.getElementById("dis4").style.visibility="hidden";
document.getElementById("postmortem_reqd_yn").value="Y"
document.getElementById("mlc_yn").value="Y"
document.getElementById("br1").style.visibility="visible";
document.getElementById("br1").disabled=false
document.getElementById("burial_permit_app_desc").value="";
document.getElementById("burial_permit_app_desc").size="30"	
document.forms[0].conscentgivenby.value="";
document.forms[0].deceasedrelationship.value="";
document.forms[0].consent_received_by.value="";
document.forms[0].consent_received_date.value="";
document.forms[0].consent_received_desc.value="";
document.forms[0].consent_desc.value="";
document.forms[0].consent_form_code.value="";

}else
{ 
 document.getElementById("dis").style.visibility="visible";
 document.getElementById("postmortem_reqd_yn").value="N"
 document.getElementById("mlc_yn").value="N"
 document.getElementById("postmortem_reqd_yn").checked=false;
 document.getElementById("postmortem_reqd_yn").disabled=false;
 document.getElementById("postmortem_type").options(0).selected=true;

 document.getElementById("pol_rep_no").value="";
 document.getElementById("pol_stn_id").value="";
 document.getElementById("pol_id").value="";
 document.getElementById("police_details").value="";
 document.getElementById("police_approval_received_yn").value="N";
 document.getElementById("police_received_by").value="";
 document.getElementById("police_approval_received_by_desc").value="";
 document.getElementById("police_received_date").value="";
 document.getElementById("Consent_forms").disabled=true;
 /*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
 document.getElementById("pol_officer_name").value="";
 document.getElementById("pol_contact_no").value="";
 /*End*/
 
 if(document.getElementById("brought_dead_yn").value=="Y")
	{
	document.getElementById("br1").style.visibility="hidden";
    document.getElementById("br1").disabled=true
	document.getElementById("burial_permit_app_desc").value="";
	document.getElementById("burial_permit_app_desc").size="15"
	}else
	{
	document.getElementById("br1").style.visibility="visible";
    document.getElementById("br1").disabled=false
    document.getElementById("burial_permit_app_desc").value="";
    document.getElementById("burial_permit_app_desc").size="30"	
	}
 
}
}
function clearpoliceconsent()
{
if(!document.getElementById("postmortem_reqd_yn").checked)
{
 document.getElementById("pol_rep_no").value="";
 document.getElementById("pol_stn_id").value="";
 document.getElementById("pol_id").value="";
 document.getElementById("police_details").value="";
 document.getElementById("police_approval_received_yn").value="N";
 document.getElementById("police_received_by").value="";
 document.getElementById("police_approval_received_by_desc").value="";
 document.getElementById("police_received_date").value="";
 /*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
 document.getElementById("pol_officer_name").value="";
 document.getElementById("pol_contact_no").value="";
/*End*/
document.forms[0].conscentgivenby.value="";
document.forms[0].deceasedrelationship.value="";
document.forms[0].consent_received_by.value="";
document.forms[0].consent_received_date.value="";
document.forms[0].consent_received_desc.value="";
document.forms[0].consent_desc.value="";
document.forms[0].consent_form_code.value="";

}

}
function clearArea()
{
document.forms[0].area_codedum.value="";
}
function clearBed1()
{   

 if(document.getElementById("postmortem_reqd_yn").checked)
{
//Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696
if(document.getElementById("br1")){
document.getElementById("br1").style.visibility="visible";
document.getElementById("br1").disabled=false 
}
//document.getElementById("burial_permit_app_desc").value=""; 18776
document.getElementById("burial_permit_app_desc").size="30"	

}else
 if(document.getElementById("brought_dead_yn").value=="Y")
	{
	//Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696
	if(document.getElementById("br1")){
	document.getElementById("br1").style.visibility="hidden";
    document.getElementById("br1").disabled=true
	}
	//document.getElementById("burial_permit_app_desc").value=""; 18776
	document.getElementById("burial_permit_app_desc").size="15"
	}else
	{
	//Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696
	if(document.getElementById("br1")){
	document.getElementById("br1").style.visibility="visible";
    document.getElementById("br1").disabled=false
	}
   // document.getElementById("burial_permit_app_desc").value=""; 18776
    document.getElementById("burial_permit_app_desc").size="30"	

	}
	document.forms[0].bed_no.value="";

	if(document.forms[0].area_type.value != "" && document.forms[0].bed_no.value == "") 
	{		 
		 document.forms[0].bed_no.disabled=false;
		 document.forms[0].bed_button.disabled=false;
	}
	else
	{
		document.forms[0].bed_no.disabled=true;
		document.forms[0].bed_button.disabled=true;
	}
 
	}
function clearBed()
{
	if(document.forms[0].area_type)
	{

		if(document.forms[0].area_type.value != "")
		{
		  document.forms[0].bed_no.value="";		  
		  document.forms[0].bed_no.disabled=false;
		  
		  if(document.forms[0].mode.value != "viewdata")
			{
		  document.forms[0].bed_button.disabled=false;		  
		  //document.forms[0].bed_no.focus();
			}
		}
		else{
		 document.getElementById("tab1").scrollIntoView();		  
		   document.forms[0].bed_no.disabled=true;
		   document.forms[0].bed_button.disabled=true;		
		
	    }
	}
	
}
function enableareagif()
{
	if(document.forms[0].area_type.value != "")
	{
		document.forms[0].adatetime.style.visibility = "visible";
		if(document.getElementById("acalendar")!=null){
		document.forms[0].all.acalendar.disabled = false;
		}
		document.forms[0].assign_date_time.disabled = false;
		document.forms[0].assign_date_time.value = document.forms[0].system_date_cnv.value;
	}
	else
	{
		document.forms[0].bed_no.value="";	
		document.forms[0].adatetime.style.visibility = "hidden";
		if(document.getElementById("acalendar")!=null)
		document.getElementById("acalendar").disabled = true
		document.forms[0].assign_date_time.value = "";
		document.forms[0].assign_date_time.disabled = true;
	}
}
function focusdatetime()
{
	
	document.forms[0].place_of_death.focus();
}
function buttondisabled()
	{
		if (document.forms[0].consent_chk.checked==true)
		{
			document.forms[0].consent_chk.value="Y";
			document.forms[0].Consent_forms.disabled=true;
			document.forms[0].consent_received_by.disabled=false;
			document.forms[0].consent_received_date.disabled=false;
			document.getElementById("image1").disabled=false;
		document.getElementById("concent_chk").style.visibility='visible'
		document.getElementById("concent_chk1").style.visibility='visible'
			}
		else 
		{
		 document.forms[0].Consent_forms.disabled=false;
		 document.forms[0].consent_chk.value="N";
		 document.forms[0].consent_received_by.options[0].selected=true;
		 document.forms[0].consent_received_by.disabled=true;
    	
		 document.forms[0].consent_received_date.disabled=true;
		 document.forms[0].consent_received_date.value='';
		document.getElementById("image1").disabled=true;
		document.getElementById("concent_chk").style.visibility='hidden'
		document.getElementById("concent_chk1").style.visibility='hidden'
		document.forms[0].consent_form_code.value="";
		document.forms[0].consent_desc.value="";
		}
	}
	function policebuttondisabled()
	{
		if (document.forms[0].police_chk.checked==true)
		{
			document.forms[0].police_chk.value="Y";
			document.forms[0].police_received_by.disabled=false;
			document.forms[0].police_received_date.disabled=false;
			document.getElementById("image2").disabled=false;
		    document.getElementById("policeapr").style.visibility='visible'
		    document.getElementById("policeapr1").style.visibility='visible'
		
			
		}
		else 
		{

		 document.forms[0].police_chk.value="N";
		 document.forms[0].police_received_by.disabled=true;
		 document.forms[0].police_received_by.options[0].selected=true;
    	 document.forms[0].police_received_date.disabled=true;
		 document.forms[0].police_received_date.value='';
		document.getElementById("image1").disabled=true;
		document.getElementById("image2").disabled=true;
		document.getElementById("policeapr").style.visibility='hidden'
		document.getElementById("policeapr1").style.visibility='hidden'
		
		}
	}
		
  function searchReligion1(relgdesc,relgcode,locale)
  { if(relgdesc.value == "")
	{relgcode.value="";
	  return ;
	}
   searchReligion(relgdesc,relgcode,locale)
  
  
  }
async   function searchReligion(relgdesc,relgcode,locale)
  {
     
  	
		
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit="";	
		
		tit=getLabel("Common.religion.label","Common");

		sql="Select RELGN_CODE code,SHORT_DESC description from mp_religion_lang_vw where eff_status='E' and language_id='"+localeName+"' and upper(RELGN_CODE) like upper(nvl(?,RELGN_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC)) order by 2";
			
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = relgdesc.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;

		retVal = await CommonLookup( tit, argumentArray );

		if(retVal != null && retVal != "" )
		  {
			
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			document.forms[0].relgn_desc.value=arr[1];
			document.forms[0].relgn_code.value=arr[0];
		 }
		 else
		 {
				relgcode.value='';
				relgdesc.value='';
		  }
  
  }
	
	function assignmlc()
	{
		parent.parent.frames[0].document.forms[0].reset.disabled=false;
		
		if(document.getElementById("mode").value=="viewdata")
		{		
		 if(document.getElementById("startendstat").value=="S"||document.getElementById("startendstat").value=="E")
	     {
	     document.getElementById("postmortem_det").style.visibility='visible'
	     }else
	     {
	     document.getElementById("postmortem_det").style.visibility='hidden'
	     }
		
		document.getElementById("referral_source").disabled=true;
		document.getElementById("referral_by").disabled=true;
		document.getElementById("hcare_type").disabled=true;
		document.getElementById("bodyfounddat").disabled=true;
		
		document.getElementById("unclaimedbodyyn").disabled=true;
		document.getElementById('body_received_date_time').readOnly=true;
		//document.getElementById("causeofdeath").readOnly=true;
		document.getElementById("highriskbodyyn").disabled=true;
		document.getElementById("manner_of_death").disabled=true;
		document.getElementById("body_condition_code").disabled=true;
		document.getElementById("place_of_death").disabled=true;
		document.getElementById("refe_type").disabled=true;
		document.getElementById("identification_marks").readOnly=true;
		if(document.getElementById("mlc_yn").checked==false)
		document.getElementById("Police_Details").disabled=true;
		document.getElementById("mlc_yn").disabled=true;
		document.getElementById("pract_id").disabled=true;
		
		document.getElementById("brought_by_police_yn").disabled=true;
		document.getElementById("service_code").disabled=true;
		document.getElementById("postmortem_reqd_yn").disabled=true;
		document.getElementById("postmortem_type").disabled=true;
		if(document.getElementById("postmortem_type").value!='C')
		document.getElementById("Consent_forms").disabled=true;
		document.getElementById("area_type").disabled=true;

		if(document.getElementById("area_type"))
		{
			if(document.getElementById("area_type").vlaue!="" && document.getElementById("bed_no").vlaue=="")
			{
				document.getElementById("bed_no").disabled=false;
				document.getElementById("bed_button").disabled=false;
			}
			else
			{
				document.getElementById("bed_no").disabled=true;
				document.getElementById("bed_button").disabled=true;
			}
		}
		
		document.getElementById("assigndatetime").disabled=true
        document.getElementById("body_burial_permit_no").disabled=true;
		document.getElementById("body_claiming_date_time").disabled=true;
		document.getElementById("burial_app_date").disabled=true;
		document.getElementById("burial_permit_app_desc").disabled=true;
		document.getElementById("vechile_no").disabled=true;
		document.getElementById("donor_card_available_yn").disabled=true;
		 //Below line added for this CRF ML-MMOH-CRF-0695
	if(document.getElementById("datetimeofclaimingApplicable") && document.getElementById("datetimeofclaimingApplicable").value!="true"){ 
	   document.getElementById("otdatetime1").disabled=true;
    }
    //End ML-MMOH-CRF-0695
		document.getElementById("buraprdt").disabled=true;
		
		
		
		
		
		
		}/*else
		{
		 //document.getElementById("Consent_forms").disabled=true;
		  if(document.forms[0].area_type.value != "")
	       {
			  document.forms[0].bed_no.disabled=false;
			  document.forms[0].bed_no.value="";
		   }
		   else{
		//	   document.forms[0].bed_no.disabled=true;
			     document.forms[0].bed_no.readndisabled=true;
		   }
		if (document.getElementById("mlc_yn").checked==true)
		{
			document.getElementById("mlc_yn").value="Y";
			document.getElementById("postmortem_reqd_yn").value="Y";
			document.getElementById("postmortem_reqd_yn").checked=true;
			document.getElementById("postmortem_reqd_yn").disabled=true;
			document.getElementById("Consent_forms").disabled=true;
            document.getElementById("postmortem_type").options[2].selected=true;     
			document.getElementById("postmortem_type").disabled=true;     
		    document.getElementById("Police_Details").disabled=false;
		}
		else 
		{
		 
		 if(document.getElementById("mode").value!="modify" )
		{document.getElementById("mlc_yn").value="N";
		 document.getElementById("postmortem_reqd_yn").value="N";
    	 // document.getElementById("postmortem_reqd_yn").checked=false;
		 document.getElementById("postmortem_reqd_yn").disabled=false;
		if(document.forms[0].postmortem_type.value!='C')
		document.forms[0].Consent_forms.disabled=true;
		}else
		{
			if(document.forms[0].postmortem_type.value!='C')
			document.forms[0].Consent_forms.disabled=true;
		    
		}
		 document.getElementById("Police_Details").disabled=true;
		 document.getElementById("police_details").value=""; 
		 document.getElementById("postmortem_type").options[0].selected=true;     
		 document.getElementById("postmortem_type").disabled=true;
		}
	}*/
	}
    /**** Bay/Table LookUp ****/	
	function enableService()
	{
	 if(document.getElementById("donor_card_available_yn").checked)
	{document.forms[0].conscentgivenby1.value="";
     document.forms[0].deceasedrelationship1.value="";
     document.forms[0].consent_received_by1.value="";
     document.forms[0].consent_received_date1.value="";
     document.forms[0].consent_received_desc2.value="";
     document.forms[0].consent_form_code1.value="";
     document.forms[0].consent_desc1.value="";


	document.getElementById("donar_card_info").disabled=false;
	document.getElementById("Concent1").disabled=true;
	}else
	{
	document.getElementById("donardetails").value ="";
    document.getElementById("donar_card_no").value ="";
 
	document.getElementById("donar_card_info").disabled=true;
	document.getElementById("Concent1").disabled=false;
	
	
	}
	
	}

	
	async function searchBed(obj,target)
	{
				var retVal =    new String();
				var area_code   =document.forms[0].area_type.value;
				var retVal = "";
				var dialogHeight= "32" ;
				var dialogWidth	= "50" ;
				var dialogTop ="100";
				var status = "no";
				var arguments	= " ";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;

				
			   var retVal=	await window.showModalDialog("../../eMO/jsp/MOBayAvailabilityChart.jsp?area_code="+area_code+"&bed_status=V&disable=yes",arguments,features);
               

  if(retVal != null && retVal != "" )
                {
	  document.forms[0].bed_no.value=retVal;
				}
	
	
	
	}






function query()
{
	if(frames[1].frames[0].document.forms[0].menudis.value=='MO_REGN_ATTN')
	{
	parameter="menu_id=MO_MENU&module_id=MO&function_id=MO_REGISTER_DECEASED&function_name=Deceased Registration&function_type=F&access=NNNNN" 
	//top.content.document.getElementById("a").rows='*'
	top.content.location.href="../../eMO/jsp/MODeceasedDtlsFrameset.jsp?"+parameter 

	}else
	{
	
	parameter="menu_id=MO_MENU&module_id=MO&function_id=MO_CHANGE_DECEASED&function_name=Change Deceased Details&function_type=F&access=NNNNN" 
	top.content.document.getElementById("a").rows='*'
	top.content.location.href="../../eMO/jsp/ChangeDeceasedDetails.jsp?"+parameter +"&callfrom=callfrommoreg"
	}
}



function setFocus(){	
	

	if(document.forms[0].mode.value=="viewdata"){
		document.forms[0].patient_id.focus();
		document.forms[0].patient_id.blur();
		document.forms[0].patient_search.disabled=true;

	} else  if(document.forms[0].menudis.value=="Y"){
		document.forms[0].patient_id.focus();
		document.forms[0].patient_id.blur();
		document.forms[0].patient_search.disabled=true;
		parent.parent.frames[0].document.forms[0].home.disabled='true'

	}else if(document.forms[0].mode.value!="modify"){ 		
		document.forms[0].patient_id.focus();
		document.forms[0].patient_id.blur();
		parent.parent.frames[0].document.forms[0].reset.disabled=true;

		if(document.forms[0].patient_id){
			document.forms[0].patient_id.focus();
		}
	}else{
		
		document.forms[0].patient_id.focus();
		document.forms[0].patient_id.blur();
	}
	
	if(document.forms[0].external.value=="Y" && document.forms[0].mode.value!='modify'){
		parent.parent.frames[0].document.forms[0].apply.disabled=true;
	}

}
function searchPatient(obj,mode)
  {
	 //console.log(parent.window[0]);
	 //console.log(parent.parent.window[0]);
	 //console.log(parent.parent.commontoolbarFrame.document.forms[0]);
	  var function_id=parent.parent.commontoolbarFrame.document.forms[0].function_id.value;
	  if(parent.document.forms[0])
	  var functionid=parent.document.forms[0].functionid.value;
	  
	  var external=document.forms[0].external.value;
	   var register_no=document.forms[0].register_no.value; //Added for this CRF Bru-HIMS-CRF-407 [IN:045167]
	 patient_id=obj.value
  
 // alert(document.forms[0].functionid.value);
	 if(patient_id!="") {
		parent.frames[1].location.href = '../../eCommon/html/blank.html' ;  

		parent.frames[2].location.href = '../../eCommon/html/blank.html' ;  

		if((mode!="modify"||mode!="viewdata")&&mode=="") {
				parent.frames[3].location.href = "../../eMO/jsp/MORegisterAttnValidations.jsp?patient_id="+patient_id+"&objName="+obj.name+"&external="+external;
		}else  {
		
			 parent.frames[0].document.forms[0].patient_search.disabled=true;
          
		    //Added for this CRF ML-MMOH-CRF-0695           
            if(mode=="modify"||mode=="viewdata")  {			
            var function_id1="Reg_Details"; 			
			parent.frames[3].location.href='../../eMO/jsp/MORegisterAttnResult.jsp?functionid='+functionid+'&function_id='+function_id+'&patient_id='+patient_id+"&mode="+mode+"&external="+external+"&register_no="+register_no+"&function_id1="+function_id1;//Added for this CRF Bru-HIMS-CRF-407 [IN:045167]
			
			}
			//End this ML-MMOH-CRF-0695

		}
	  }
  }
 
 function showPrevEncounter(patient_id)
{
	var function_id=parent.document.forms[0].function_id.value;
	var functionid=parent.document.forms[0].functionid.value;
//    var encounter_id=document.forms[0].encounter_id.value;
	var dialogWidth = "100vw" ;
	var	dialogHeight = "70vh";
	var dialogTop = "190" ;
	var status = "no";
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+" ; scroll=no; status:" + status;
     retVal = 
	 //window.showModalDialog("../../eMP/jsp/vwEncounterDetailFrames.jsp?functionid="+functionid+"&function_id="+function_id+"&patientid="+patient_id+"&encounterID="+encounter_id,arguments,features);
	 window.showModalDialog("../../eMP/jsp/vwEncounterDetailFrames.jsp?functionid="+functionid+"&function_id="+function_id+"&patientid="+patient_id,arguments,features);
}
 
/* 
 function doDateTimeChk(obj)
        {  
		
           	if(obj.value!='')
			{
			
			if(obj.value.length<16)
			{	
				alert(getMessage("INVALID_DATE_TIME","SM"))
                obj.value="";
				//obj.focus()
			    return false;
				}

   

			if(obj.value.indexOf('.') !=-1 || obj.value.indexOf('-') !=-1)
            { 
              //  retval= false
	           obj.value="";
            return false;
				}
            else
            {
                var comp=obj
                obj=obj.value
                 
				var dttime = obj.split(" ");
                var dt
                var time
                var retval=true
                if(dttime.length>1)
                {
                    dt=dttime[0]
                    time=dttime[1]

                    if(!checkDt(dt) )
                    {
                        retval= false
						alert(getMessage("INVALID_DATE_TIME","SM"))
                        comp.value="";
						comp.focus()
							return false;
                    }
                    else
                    {
                        if(time==null || time=="")
                        {
                            alert(getMessage("INVALID_DATE_TIME","SM"))
                            retval= false;
                            comp.value="";
							comp.focus()
								return false;
                        }

                        else
                        {
                            if(!chkTime(time))
                            {
                                    retval= false
                                    alert(getMessage("INVALID_DATE_TIME","SM"))
                                    comp.value="";
									comp.focus()
                           return false;
									}
                        }
                    }
                }
                else
                {
                    retval= false
                    alert(getMessage("INVALID_DATE_TIME","SM"))
                    comp.value="";
						return false;
                }
              parent.dummyframe.location.href='../../eMO/jsp/ValidateSysdate.jsp?objname='+comp.name+"&bodypart=deceasedregn"+"&objValue="+escape(comp.value);   
                if(retval)
                {
                    TimeChk();

                }
            }
			return retval;
			}else
			{
			return false;
			}
            
        }
*/
function TimeChk()
	{
		from = document.forms[0].system_date.value;
		to = document.forms[0].body_received_date_time.value;

		var a=  from.split(" ")
		splitdate=a[0];
		splittime=a[1]

		var splitdate1 =splitdate.split("/")
		var splittime1= splittime.split(":")

		 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		 a=  to.split(" ")
		splitdate=a[0];
		splittime=a[1]


		 splitdate1 =splitdate.split("/")
		 splittime1= splittime.split(":")

		 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		/* if(Date.parse(to_date) > Date.parse(from_date))
		{
			alert(getMessage('START_DATE_GREATER_SYSDATE'))
			document.forms[0].body_received_date_time.value="";
			document.forms[0].body_received_date_time.focus();
			return false
		}
		else
		{*/
			chkforDeceased();
			return true;
			

		//}

	}
	function chkforDeceased() 
	{
		
		from = document.forms[0].deceased_date.value;
		to      = document.forms[0].body_received_date_time.value;

		var a=  from.split(" ")
		splitdate=a[0];
		splittime=a[1]

		var splitdate1 =splitdate.split("/")
		var splittime1= splittime.split(":")

		 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		 a=  to.split(" ")
		splitdate=a[0];
		splittime=a[1]


		 splitdate1 =splitdate.split("/")
		 splittime1= splittime.split(":")

		 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		 if(Date.parse(to_date) < Date.parse(from_date))
		{
			alert(getMessage('CANT_BE_LT_DECEASED_DATE','MO'))
				document.forms[0].body_received_date_time.focus();
			return false
		}
		else
			return true;
		}
 function doDateTimeChk1(obj)
        {body_received_date=document.forms[0].body_received_date_time.value;
       if(body_received_date=="" && obj.value!="")
        {
		alert(getMessage("ENTER_BDYRCPT_DTTIME","MO"));
		obj.focus();
		obj.value="";
		return false;
        }
			
			
			
			if(obj.value!="")
			{
			
			if(obj.value.length<16)
			{	
				alert(getMessage("INVALID_DATE_TIME","SM"))
                obj.value="";
				//obj.focus()
			    return false;
				}
			
			if(obj.value.indexOf('.') !=-1 || obj.value.indexOf('-') !=-1)
            {
                retval= false
				alert(getMessage("INVALID_DATE_TIME","SM"))
                obj.value="";
				//obj.focus()
				return false;
            }
            else
            {
                var comp=obj
                obj=obj.value
         
				var dttime = obj.split(" ");
                var dt
                var time
                var retval=true
                if(dttime.length>1)
                {
                    dt=dttime[0]
                    time=dttime[1]
                    
                    if(!checkDt(dt) )
                    {
                        retval= false
						alert(getMessage("INVALID_DATE_TIME","SM"))
                        comp.value="";
					comp.focus()
                return false;
					}
                    else
                    {
                        if(time==null || time=="")
                        {
                            alert(getMessage("INVALID_DATE_TIME","SM"))
                            retval= false;
                          comp.value="";
						comp.focus()
							return false
								
                       // obj.value="";
							}

                        else
                        {
                            if(!chkTime(time))
                            {
                                    retval= false
                                    alert(getMessage("INVALID_DATE_TIME","SM"))
                                    comp.value="";
									comp.focus()
										return false;
                   //                 obj.value="";
								
									}
                        }
                    }
                }
                else
                {
                    retval= false
                    alert(getMessage("INVALID_DATE_TIME","SM"))
                    comp.value="";
						return false;
                }
parent.dummyframe.location.href='../../eMO/jsp/ValidateSysdate.jsp?objname='+comp.name+"&bodypart=deceasedregn"+"&objValue="+escape(comp.value);   
            
				if(retval)
                {
					chkforDeceased1();
		           	return true;
		
                //     TimeChk1();

                }
            }
			}
            return retval
        }
function TimeChk1()
	{
		from = document.forms[0].system_date.value;
		to = document.forms[0].assign_date_time.value;

		var a=  from.split(" ")
		splitdate=a[0];
		splittime=a[1]

		var splitdate1 =splitdate.split("/")
		var splittime1= splittime.split(":")

		 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		 a=  to.split(" ")
		splitdate=a[0];
		splittime=a[1]


		 splitdate1 =splitdate.split("/")
		 splittime1= splittime.split(":")

		 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		 /*if(Date.parse(to_date) > Date.parse(from_date))
		{
			alert(getMessage('START_DATE_GREATER_SYSDATE'))
			document.forms[0].assign_date_time.value="";
			document.forms[0].assign_date_time.focus();
			return false
		}
		else
		{*/
			

		//}

	}
function chkforDeceased1() 
	{
		
		from = document.forms[0].body_received_date_time.value;
		to      = document.forms[0].assign_date_time.value;

		var a=  from.split(" ")
		splitdate=a[0];
		splittime=a[1]

		var splitdate1 =splitdate.split("/")
		var splittime1= splittime.split(":")

		 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		 a=  to.split(" ")
		splitdate=a[0];
		splittime=a[1]


		 splitdate1 =splitdate.split("/")
		 splittime1= splittime.split(":")

		 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		 if(Date.parse(to_date) < Date.parse(from_date))
		{
			alert(getMessage('DATE_CANT_BE_LT_RECEIPT','MO'))
				document.forms[0].assign_date_time.value="";
			return false
		}
		else
			return true;
		}

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
	//var facilityId = "";
	
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
	 	if(arr[1]==undefined) 
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	    
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

function doDateTimeChk2(obj)
{


var Sys_date=document.forms[0].system_date.value;

if(obj.value!="")
		{
		if(!validDateObj(obj,"DMYHM",localeName))
		{
			alert(getMessage("INVALID_DATE_TIME","SM"));
			obj.value="";
			return ;
		}
		else{

		var obj1=convertDate(obj.value,"DMYHM",localeName,"en");

		
		if(isAfter(Sys_date,obj1,'DMYHM',localeName)==false)
			{
				alert(getMessage("START_DATE_GREATER_SYSDATE","Common"));
				obj.value="";
				obj.select();	
				return false;
			}
			else
			{
				TimeChk2();
				return true;
			}
			
		}
}
	

}

function chkWithSysDt(obj)
{   //modified by Shanmukh on 26th-JUNE-2018 for ML-MMOH-CRF-1031
	var isChangeOfDateTimeClaimingAppl=document.forms[0].isChangeOfDateTimeClaimingAppl.value;
		if(obj.value!='')
		{
			if(isBeforeNow(obj.value,"DMYHM",localeName))
				return true;
			else {
				if(isChangeOfDateTimeClaimingAppl=="true" && obj.name=="body_claiming_date_time"){
						var err=getMessage("DATE1_GT_DATE2",'IP');
						var err1=getLabel("eMO.DateTimeOfClaiming.label","eMO");
						var err2=getLabel("Common.SystemDateTime.label","Common");
						err=err.replace('$',err1);
						err=err.replace('#',err2);
						alert(err);
					}else{
					alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));}
				obj.value="";
				obj.focus();				
				return false ;
			}
		}		
}

function chkWithDates(sourceObj,from)
{
	//modified by Shanmukh on 26th-JUNE-2018 for ML-MMOH-CRF-1031
	var isChangeOfDateTimeClaimingAppl=document.forms[0].isChangeOfDateTimeClaimingAppl.value;
	var isReceivedDateTimeAppl=document.forms[0].isReceivedDateTimeAppl.value;
	if(from=='BRD')
	{	
			obj1	= document.forms[0].deceased_date.value;
			obj2    = sourceObj.value;

			if(obj2!="" && obj1!="")
			{
				if(isBefore(obj1,obj2,"DMYHM",localeName)==false)
				{   if(isReceivedDateTimeAppl=="true"){
					alert(getMessage("CANT_BE_LT_DECEASED_DATE1","MO"));}
					else{
					alert(getMessage("CANT_BE_LT_DECEASED_DATE","MO"));}	
					document.forms[0].body_received_date_time.select();
					return false;
				}
				else 
					return true;
			}	
	}		
	if( from=='ASD' || from == 'CLD' || from == 'CFD' || from == 'PRD')
	{
			obj1   = document.forms[0].body_received_date_time.value;
			obj2   = sourceObj.value;

			if(obj2!="" && obj1!="")
			{
				if(isBefore(obj1,obj2,"DMYHM",localeName)==false)
				{
					//Alert Message Modified by Shanmukh on 28th-JUNE-2018 for ML-MMOH-CRF-1031
					if(isChangeOfDateTimeClaimingAppl=="true" && sourceObj.name=="body_claiming_date_time"){
						var err=getMessage("DATE1_LT_DATE2",'IP');
						var err1=getLabel("eMO.DateTimeOfClaiming.label","eMO");
						var err2=getLabel("eMO.Body.label","eMO")+" "+getLabel("Common.received.label","Common")+" "+getLabel("Common.Date/Time.label","Common");
						err=err.replace('$',err1);
						err=err.replace('#',err2);
						alert(err);
					}else{
						var err1=getLabel("Common.received.label","Common");
						err=getMessage("DATE_CANT_BE_LT_RECEIPT","MO");
						if(isReceivedDateTimeAppl=="true"){
						err=err.replace('Receipt',err1);
					    alert(err);}
						else{
						alert(getMessage("DATE_CANT_BE_LT_RECEIPT","MO"));}
                    }					
					sourceObj.value="";

					if(sourceObj.name!=='assign_date_time')
						sourceObj.focus();

					return false;
				}
				else 
					return true;	
			}	

			if(sourceObj.name=="burial_app_date")
			{
				document.getElementById("tab4").scrollIntoView();
				document.getElementById("generate_burial_permit").focus();
			}
	}
}

function chkAssignDate(obj,from)
{
		//Modified by Shanmukh on 26th-JUNE-2018 for ML-MMOH-CRF-1036
		var isReceivedDateTimeAppl=document.MO_regn_form.isReceivedDateTimeAppl.value;
        var err=getMessage("ENTER_BDYRCPT_DTTIME","MO");
		var err1=getLabel("Common.received.label","Common");
		if(isReceivedDateTimeAppl=="true")
			err=err.replace('Receipt',err1);
		else
			err=getMessage("ENTER_BDYRCPT_DTTIME","MO");
		body_received_date=document.forms[0].body_received_date_time.value;

		if(body_received_date=="" && obj.value!="")
        {   alert(err);
			obj.value="";
			obj.focus();
			return false;
        }
		else
		{
			if(obj.value!="")
			{
				if(chkWithSysDt(obj))
						chkWithDates(obj,from);
				else
					return false;
			}
		}
}


/*
 function doDateTimeChk2(obj)
        {
  	
parent.dummyFrame.location.href='../../eMO/jsp/ValidateSysdate.jsp?objname='+obj.name+"&bodypart=deceasedregn1"+"&objValue="+escape(obj.value);     	
			if(obj.value!='')
			{
			if(obj.value.indexOf('.') !=-1 || obj.value.indexOf('-') !=-1)
            {
                retval= false
				alert(getMessage("INVALID_DATE_TIME","SM"))
                obj.value="";
				obj.focus()
            }
            else
            {
                var comp=obj
                obj=obj.value
                var dttime = obj.split(" ");
                var dt
                var time
                var retval=true
                if(dttime.length>1)
                {
                    dt=dttime[0]
                    time=dttime[1]

                    if(!checkDt(dt) )
                    {
                        retval= false
						alert(getMessage("INVALID_DATE_TIME","SM"))
                        obj.value="";
					//	comp.focus()
                    }
                    else
                    {
                        if(time==null || time=="")
                        {
                            alert(getMessage("INVALID_DATE_TIME","SM"))
                            retval= false;
							comp.value="";
                            comp.focus()
                        }

                        else
                        {
                            if(!chkTime(time))
                            {
                                    retval= false
                                    alert(getMessage("INVALID_DATE_TIME","SM"))
                                   comp.value="";
									comp.focus()
                            }
                        }
                    }
                }
                else
                {
                    retval= false
                    alert(getMessage("INVALID_DATE_TIME","SM"))
						comp.value="";
                    comp.focus()
                }
				if(retval)
					TimeChk2();
               }
			}
            return retval
        }
			*/

function TimeChk2()
	{
//parent.dummyFrame.location.href='../../eMO/jsp/ValidateSysdate.jsp?objname='+obj.name+"'&bodypart=deceasedregn1";     		
		from = document.forms[0].system_date.value;
		to = document.forms[0].consent_received_date.value;
		if(to!="")
		{
		var a=  from.split(" ")
		splitdate=a[0];
		splittime=a[1]

		var splitdate1 =splitdate.split("/")
		var splittime1= splittime.split(":")

		 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		 a=  to.split(" ")
		splitdate=a[0];
		splittime=a[1]


		 splitdate1 =splitdate.split("/")
		 splittime1= splittime.split(":")

		 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		 /*if(Date.parse(to_date) > Date.parse(from_date))
		{
			alert(getMessage('START_DATE_GREATER_SYSDATE'))
			document.forms[0].consent_received_date.focus();
			return false
		}
		else
		{*/
			
		from = document.forms[0].body_received_date_time.value;
		to      = document.forms[0].consent_received_date.value;
       if(from!=""&&to!="")
			{
		var a=  from.split(" ")
		splitdate=a[0];
		splittime=a[1]

		var splitdate1 =splitdate.split("/")
		var splittime1= splittime.split(":")

		 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		 a=  to.split(" ")
		splitdate=a[0];
		splittime=a[1]


		 splitdate1 =splitdate.split("/")
		 splittime1= splittime.split(":")

		 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		 if(Date.parse(to_date) < Date.parse(from_date))
		 {
			    alert(getMessage('DATE_CANT_BE_LT_RECEIPT','MO'))
				document.forms[0].consent_received_date.focus();
			return false
		 }
		else
			return true;
		}
		//}
	  }
	}




function doDateTimeChk3(obj)
{

var Sys_date=document.forms[0].system_date.value;

if(obj.value!="")
		{
		if(!validDateObj(obj,"DMYHM",localeName))
		{
			obj.value="";
			return ;
		}
		else{
		var obj1=convertDate(obj.value,"DMYHM",localeName,"en");

		
		if(isAfter(Sys_date,obj1,'DMYHM',localeName)==false)
			{
				alert(getMessage("START_DATE_GREATER_SYSDATE","Common"));
				obj.value="";
				obj.select();	
				return false;
			}
			else
			{
				TimeChk3();
				return true;
			}
			
		}
}

}


/*
function doDateTimeChk3(obj)
        {
 parent.dummyFrame.location.href='../../eMO/jsp/ValidateSysdate.jsp?objname='+obj.name+"&bodypart=deceasedregn1"+"&objValue="+escape(obj.value);     	
			if(obj.value!='')
			{
			if(obj.value.indexOf('.') !=-1 || obj.value.indexOf('-') !=-1)
            {
                retval= false
				alert(getMessage("INVALID_DATE_TIME","SM"))
                obj.focus()
            }
            else
            {
                var comp=obj
                obj=obj.value
                var dttime = obj.split(" ");
                var dt
                var time
                var retval=true
                if(dttime.length>1)
                {
                    dt=dttime[0]
                    time=dttime[1]

                    if(!checkDt(dt) )
                    {
                        retval= false
						alert(getMessage("INVALID_DATE_TIME","SM"))
                        comp.focus()
                    }
                    else
                    {
                        if(time==null || time=="")
                        {
                            alert(getMessage("INVALID_DATE_TIME","SM"))
                            retval= false;
                            comp.focus()
                        }

                        else
                        {
                            if(!chkTime(time))
                            {
                                    retval= false
                                    alert(getMessage("INVALID_DATE_TIME","SM"))
                                    comp.focus()
                            }
                        }
                    }
                }
                else
                {
                    retval= false
                    alert(getMessage("INVALID_DATE_TIME","SM"))
                    comp.focus()
                }
				if(retval)
					TimeChk3();
               }
			}
            return retval
        }
*/

function TimeChk3()
	{
		
		from = document.forms[0].system_date.value;
		to = document.forms[0].police_received_date.value;
		if(to!="")
		{
		var a=  from.split(" ")
		splitdate=a[0];
		splittime=a[1]

		var splitdate1 =splitdate.split("/")
		var splittime1= splittime.split(":")

		 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		 a=  to.split(" ")
		splitdate=a[0];
		splittime=a[1]


		 splitdate1 =splitdate.split("/")
		 splittime1= splittime.split(":")

		 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		 //if(Date.parse(to_date) > Date.parse(from_date))
	//	{
		//	alert(getMessage('START_DATE_GREATER_SYSDATE'))
		//	document.forms[0].police_received_date.focus();
		//	return false
		//}
		//else
		//{
			
		from = document.forms[0].body_received_date_time.value;
		to      = document.forms[0].police_received_date.value;

		if(from!=""&&to!="")
		{
		var a=  from.split(" ")
		splitdate=a[0];
		splittime=a[1]

		var splitdate1 =splitdate.split("/")
		var splittime1= splittime.split(":")

		 var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

		 a=  to.split(" ")
		splitdate=a[0];
		splittime=a[1]


		 splitdate1 =splitdate.split("/")
		 splittime1= splittime.split(":")

		 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
			
		 
		 if(Date.parse(to_date) < Date.parse(from_date))
		 {
			alert(getMessage('DATE_CANT_BE_LT_RECEIPT','MO'))
			document.forms[0].police_received_date.focus();
			return false
		 }
		else
			return true;
		}
		//}
	   }
	}

	

function clearData()
{


parent.frames[2].document.location.href='../../eCommon/html/blank.html';
parent.frames[1].AreaAvailForm.search.disabled=false;

}

//Added site_check,facilityId by Ashwin K for ML-MMOH-CRF-1891
async function deathCause(encid,patid,practId,mode,dob,sex,splty_code,pat_class,pract_type,locn_code,locn_type,site_check,facilityId)
{	


var dialogHeight= "95vh" ;
var dialogWidth = "90vw" ; 
var dialogTop 	= "120";
var center = "1" ;
var status="no";
var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
var arguments	= "" ;

 if (mode=='viewdata')
 {
	 //patient_id="+patient_id+"&P_function_id="+function_id+"&P_no_of_items="+no_of_items+"&P_option_type="+option_type
	
	retVal = 	await window.showModalDialog("../../eCA/jsp/PatProblemList.jsp?modal_yn=Y&patient_id="+patid+"&function_id=MO_REGN_ATTN",arguments,features);

 }
 else{
	if(practId!="")
		{
		/*Commented For Changing Call From Flag on 10/13/2009*/
		//			window.showModalDialog("../../eMR/jsp/RecDiagnosis.jsp?modal_yn=Y&Sex="+sex+"&Dob="+dob+"&speciality_code="+splty_code+"&patient_id="+patid+"&encounter_id="+encid+"&episode_id="+encid+"&practitioner_id="+practId+"&practitioner_type="+pract_type+"&patient_class="+pat_class+"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I&Locn_Code="+locn_code+"&location_type="+locn_type+"&cause_of_death=Y",arguments,features);
		
		/*Commented by Ashwin K for ML-MMOH-CRF-1891
		//window.showModalDialog("../../eMR/jsp/RecDiagnosis.jsp?modal_yn=Y&Sex="+sex+"&Dob="+dob+"&speciality_code="+splty_code+"&patient_id="+patid+"&encounter_id="+encid+"&episode_id="+encid+"&practitioner_id="+practId+"&practitioner_type="+pract_type+"&patient_class="+pat_class+"&episode_type=I&Locn_Code="+locn_code+"&location_type="+locn_type+"&cause_of_death=Y",arguments,features);
		*/
		//Added by Ashwin K for ML-MMOH-CRF-1891
		
		//alert("siteCheck ="+site_check);

		if(site_check == 'true')
			{
			 //newly added
			dialogHeight="42";
			dialogWidth="80";
			dialogTop="100";
			features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			//ended
			var res = "";
			var finalize_yn = "";
			
		

		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH facilityId=\""+facilityId+"\" patient_id=\""+patid+"\" action='getMORegState' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eMO/jsp/MOIntermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		res	= responseText;
		finalize_yn = res.substring(res.indexOf("<finalize_yn>")+13,res.indexOf("</finalize_yn>"));

		await window.showModalDialog("../../eMR/jsp/DeathRegisterFrames.jsp?cause_of_death=Y&modal_yn=Y&Locn_Code="+locn_code+"&Sex="+sex+"&Dob="+dob+"&speciality_code="+splty_code+"&patient_id="+patid+"&encounter_id="+encid+"&episode_id="+encid+"&practitioner_id="+practId+"&practitioner_type="+pract_type+"&patient_class="+pat_class+"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I&finalize_yn="+finalize_yn+"&visit_adm_date=",arguments,features);
		
			}
			else
			{
	await 	window.showModalDialog("../../eMR/jsp/RecDiagnosis.jsp?modal_yn=Y&Sex="+sex+"&Dob="+dob+"&speciality_code="+splty_code+"&patient_id="+patid+"&encounter_id="+encid+"&episode_id="+encid+"&practitioner_id="+practId+"&practitioner_type="+pract_type+"&patient_class="+pat_class+"&episode_type=I&Locn_Code="+locn_code+"&location_type="+locn_type+"&cause_of_death=Y",arguments,features);


			}

			//Ended by Ashwin K for ML-MMOH-CRF-1891
		
			//retVal = 	window.showModalDialog("../../eMR/jsp/MaintainDeathRegister.jsp?modal_yn=Y&called_from_death_reg=Y&pat_line_yn=Y&patient_id="+patid+"&episode_id="+encid+"&ip_practitioner_id="+practId+"&call_from=MO_REGN_ATTN",arguments,features);
	//parent.frames[2].location.href="../../eMR/jsp/DeathRegisterResult.jsp?PatientId="+'<%=PatientId%>'+"&EncounterId="+'<%=EncounterId%>';
		}else
		{
			if(document.forms[0].burial_permit_reqd_yn.value == "Y")
			   alert(getMessage("BUR_NT_GEN","MO"));
		}
  }
}
function reset()

{ 
 if(frames[1].document.forms[0]!=null)
   {   
       /*Below lines added by Venkatesh.S on 25-Nov-2013 against 045072 */
       if(frames[1].document.forms[0].name=="AreaAvailForm"){ 
        patientFrame.document.location.reload(); 
       frames[2].document.location.href='../../eCommon/html/blank.html';
       }else { 
	   if(f_query_add_mod.patientDetailsFrame.document.MO_regn_form.mode.value=="insert"){	   
	   var functionid="MO_REGISTER_DECEASED";
	/* var patientID=frames[1].frames[0].document.forms[0].patient_id.value ;
	   parameter="menu_id=MO_MENU&module_id=MO&function_id=MO_REGISTER_DECEASED&function_name=Deceased Registration&function_type=F&access=NYYNN" 
	   top.content.location.href = "../../eMO/jsp/MORegisterDeceased.jsp?functionid="+functionid+"&"+parameter+"&patientID="+   patientID+"&menudis=MO_REGN_ATTN'" */
	  
	    /* end 045072 */
	   		//f_query_add_mod.patientDetailsFrame.document.location.reload(); // lines added by Lenin on 06-Dec-2013 against 045484 */
	   
	   }
	   f_query_add_mod.patientDetailsFrame.document.location.reload();//Modified For Bru-HIMS-CRF-0368 By Dharma on 19th Dec 2013 
	   
       
       }  
 }else 
 if( f_query_add_mod.patientFrame.document.forms[0].menudis.value=="Y")
 {
 f_query_add_mod.patientDetailsFrame.document.forms[0].reset();
 f_query_add_mod.patientFrame.document.forms[0].BURIAL_PERMIT_NO.value="";
 f_query_add_mod.patientFrame.document.forms[0].BURIAL_PERMIT_NO.disabled=false;
 f_query_add_mod.patientFrame.document.forms[0].burialno_search.disabled=false;
  }else 
	
	if(f_query_add_mod.patientDetailsFrame.document.forms[0].mode.value!="modify")
	{
    frames[0].document.forms[0].reset.disabled=true;
	f_query_add_mod.patientDetailsFrame.document.location.reload();
	}else
	{frames[0].document.forms[0].reset.disabled=false;
    f_query_add_mod.patientDetailsFrame.document.location.reload();
	
	
	
	}

   
}
function enterBurial(obj)
{
if(obj.checked)
{
document.forms[0].body_burial_permit_no.value="";
document.forms[0].body_burial_permit_no.readOnly=true;
document.forms[0].generate_burial_permit.value="Y";

}else
{

document.forms[0].body_burial_permit_no.readOnly=false;
document.forms[0].generate_burial_permit.value="N";

}

}

function onSuccess()
{ 
	if(f_query_add_mod.frames[0].document.forms[0].menudis.value=="Y")
	{
	
	alert(getMessage('RECORD_INSERTED','SM'));
	window.close();
	}else
	if(f_query_add_mod.patientDetailsFrame.document.forms[0].mode.value!="modify")
	{alert(getMessage('RECORD_INSERTED','SM'));
	parameter="menu_id=MO_MENU&module_id=MO&function_id=MO_REGISTER_DECEASED&function_name=Deceased Registration&function_type=F&access=NNNNN" 
	top.content.document.getElementById("a").rows='*'
	top.content.location.href="../../eMO/jsp/MODeceasedDtlsFrameset.jsp?"+parameter 

	}
	else
	{alert(getMessage('RECORD_MODIFIED','SM'));
	 // top.content.document.location.href='../../eMO/jsp/ChangeDeceasedDetails.jsp'
	//j parent.frames[0].document.getElementById("a").rows='*'
   // alert(parent.frames[0].name);
//j parent.frames[0].document.location.href='../../eMO/jsp/ChangeDeceasedDetails.jsp?menu_id=MO_MENU&module_id=MO&function_id=MO_CHANGE_DECEASED&function_name=Change Deceased Details&function_type=F&access=NNNNN'
	document.location.href='../../eMO/jsp/ChangeDeceasedDetails.jsp?menu_id=MO_MENU&module_id=MO&function_id=MO_CHANGE_DECEASED&function_name=Change Deceased Details&function_type=F&access=NNNNN'
	
	}

}


function onloadpopulate(val1,val2)
{
	
	document.forms[0].refe_type.value=val1;
	if(val1 == "L")
	{
		document.forms[0].hcare_type.disabled=true;
		document.forms[0].referral_source.disabled=true;
	}else
	{
		document.forms[0].referral_source.disabled=false;
		document.forms[0].hcare_type.disabled=false;
	}
}


function apply()
{
 
 
	
 var temp="";

 if(f_query_add_mod.patientDetailsFrame.document.MO_regn_form!=null)
 temp=f_query_add_mod.patientDetailsFrame.document.MO_regn_form
 else
 temp=frames[1].frames[0].frames[3].document.forms[0];
//Added by Shanmukh on 26th-JUNE-2018 for ML-MMOH-CRF-1036
var isReceivedDateTimeAppl=temp.isReceivedDateTimeAppl.value;
var BodyReceived=f_query_add_mod.getLabel("eMO.BodyReceipt.label","MO");;
if(isReceivedDateTimeAppl=="true") {
		BodyReceived=f_query_add_mod.getLabel("eMO.Body.label","eMO")+" "+f_query_add_mod.getLabel("Common.received.label","Common")+" "+f_query_add_mod.getLabel("Common.Date/Time.label","Common");
}
//END

   var temp1
   if(f_query_add_mod.patientDetailsFrame.document.MO_regn_form!=null)
   temp1=frames[1].frames[3];
   else
   temp1=frames[1].frames[0].frames[3]
   
   if(temp.area_type.value!="")
		{
		 
	
		 fields = new Array (temp.body_condition_code,temp.body_received_date_time,temp.manner_of_death,temp.service_code,temp.assign_date_time,temp.relgn_code,temp.deceased_date)
		 names = new Array (f_query_add_mod.getLabel("eMO.BodyCondition.label","MO"),BodyReceived,f_query_add_mod.getLabel("eMO.MannerofDeath.label","MO"),f_query_add_mod.getLabel("Common.service.label","Common"),			 f_query_add_mod.getLabel("Common.assigndatetime.label","Common"),f_query_add_mod.getLabel("Common.religion.label","Common"),f_query_add_mod.getLabel("Common.deceaseddatetime.label","Common"));
			}
			else
			{
				fields = new Array (temp.body_condition_code,temp.body_received_date_time,temp.manner_of_death,temp.service_code,temp.relgn_code,temp.deceased_date)
		    names = new Array (f_query_add_mod.getLabel("eMO.BodyCondition.label","MO"),BodyReceived,f_query_add_mod.getLabel("eMO.MannerofDeath.label","MO"),f_query_add_mod.getLabel("Common.service.label","Common"),f_query_add_mod.getLabel("Common.religion.label","Common"),f_query_add_mod.getLabel("Common.deceaseddatetime.label","Common"));
			}
	// Below Condition Added Aginst PAS-INC-MO -> Release Deceased/Body Part [IN:043269] By Saanthaakumar
	if((temp.CLAIMANT_TYPE.value!="")&& (temp.id3.style.visibility=='visible')){
		fields.push(temp.CLAIMANT_TYPE_CODE);
		names.push(getLabel("eMO.Claimant.label","mo"));
	} // 43269 Fix Over.
	
	if(temp1.checkFields( fields, names, messageFrame))
	 {

	if(frames[1].frames[0].document.forms[0].patient_id.value=="")
	{

	var err=getMessage("CAN_NOT_BE_BLANK","Common");
	err= err.replace('$',getLabel("eMO.DeceasedPatientID.label","MO"));
	alert(err);
    
	//alert("APP-000001 Deceased Patient Id cannot be blank");
	messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="
	return false;
	}

	/*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
	var deceasedDate		= temp.deceased_date.value;
	var bodyReceivedDate	= temp.body_received_date_time.value;
	if(deceasedDate != "" && bodyReceivedDate != "")
	{
		if(temp1.isBefore(deceasedDate,bodyReceivedDate,"DMYHM",localeName) == false)
		{   if(isReceivedDateTimeAppl=="true") {
			var err = getMessage("CANT_BE_LT_DECEASED_DATE1","MO");}
			else{var err = getMessage("CANT_BE_LT_DECEASED_DATE","MO");}
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+err;
			return false;
		}
	}	
	/*End*/
 
 var fields = null;
 var names = null;
 var flag = 0;
 
 var cnt=temp.organcnt.value
 var checkedCode="";
 
 var isRemoveMandBPermitAppBy	= f_query_add_mod.patientDetailsFrame.document.MO_regn_form.isRemoveMandBPermitAppBy.value
 
 //Below line added for this CRF ML-MMOH-CRF-0695
 var datetimeofclaimingApplicable	= f_query_add_mod.patientDetailsFrame.document.MO_regn_form.datetimeofclaimingApplicable.value;
 //End ML-MMOH-CRF-0695
 
//Added by Santhosh for ML-MMOH-CRF-1948
var datetimeOfClaimingAppl	= temp.datetimeOfClaimingAppl.value;
//END

//Added by Shanmukh on 26th-JUNE-2018 for ML-MMOH-CRF-1031 
var isChangeOfDateTimeClaimingAppl=temp.isChangeOfDateTimeClaimingAppl.value;
if(((isChangeOfDateTimeClaimingAppl=="true") && (temp.body_claiming_date_time.value=="")) && (datetimeOfClaimingAppl =="true" && (temp.datetime_claim_mand.value != null && temp.datetime_claim_mand.value =="D"))){
	var err=getMessage("CAN_NOT_BE_BLANK",'common');
	var err1=getLabel("eMO.DateTimeOfClaiming.label","eMO");
	err=err.replace('$',err1);
	alert(err);
	messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+"";
	return false;
}
//END
obj1   = temp.body_received_date_time.value;
obj2   = temp.body_claiming_date_time.value;
if(obj2!="" && obj1!="")
{
	if(temp1.isBefore(obj1,obj2,"DMYHM",localeName)==false)
	{
	 if(isChangeOfDateTimeClaimingAppl=="true"){
		var err=getMessage("DATE1_LT_DATE2",'IP');
		var err1=getLabel("eMO.DateTimeOfClaiming.label","eMO");
		var err2=getLabel("eMO.Body.label","eMO")+" "+getLabel("Common.received.label","Common")+" "+getLabel("Common.Date/Time.label","Common");
		err=err.replace('$',err1);
		err=err.replace('#',err2);
		alert(err);
		temp.body_claiming_date_time.value="";
		temp.body_claiming_date_time.select();
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+"";
		return false;
		}
	}
}
//Added by Santhosh for ML-MMOH-CRF-1948
if(datetimeOfClaimingAppl =="true" && (temp.datetime_claim_mand.value != null && temp.datetime_claim_mand.value =="D") && (trimString(temp.body_claiming_date_time.value) == null || trimString(temp.body_claiming_date_time.value)== "")){
	var err=getMessage("CAN_NOT_BE_BLANK",'common');
	var err1=getLabel("eMO.DateTimeOfClaiming.label","eMO");
	err=err.replace('$',err1);
	messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+err;
	return false;
}
//END
if((temp.postmortem_reqd_yn.checked==false)|| ((temp.startendstat.value=="E") && temp.startendstat.value=="modify"))
{
 if(f_query_add_mod.patientDetailsFrame.document.MO_regn_form.burial_permit_reqd_yn.value=="Y"){  // Suresh M
	
	//Below line modified for this CRF ML-MMOH-CRF-0695
	//datetimeOfClaimingAppl added for  ML-MMOH-CRF-1948
	if(isRemoveMandBPermitAppBy!="true" && datetimeofclaimingApplicable!="true"){
		if((temp.body_burial_permit_no.value==""||temp.generate_burial_permit.checked)&&(temp.body_claiming_date_time.value=="")&&(temp.burial_permit_app_by.value=="")&&(temp.burial_app_date.value=="")){

		}else if((temp.body_burial_permit_no.value!=""||temp.generate_burial_permit.checked)&&(temp.body_claiming_date_time.value!=""|| datetimeOfClaimingAppl=="true")&&(temp.burial_permit_app_by.value!="")&&(temp.burial_app_date.value!="")){

		}else {	
			var err=getMessage("CAPTURE_BURIAL_PRMT_DTLS","MO");	
			//messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=APP-000001 All the Burial Permit Details must be captured"
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+err;
			return false    	
		}
	}else{

		if((temp.body_burial_permit_no.value==""||temp.generate_burial_permit.checked)&&(temp.body_claiming_date_time.value=="")&&(temp.burial_app_date.value=="")){

		}else if((temp.body_burial_permit_no.value!=""||temp.generate_burial_permit.checked)&&(temp.body_claiming_date_time.value!=""|| datetimeOfClaimingAppl=="true")&&(temp.burial_app_date.value!="")){

		}else {	
			var err=getMessage("CAPTURE_BURIAL_PRMT_DTLS","MO");	
			//messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=APP-000001 All the Burial Permit Details must be captured"
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+err;
			return false    	
		}


	}



 }else{	
       //Below line modified for this CRF ML-MMOH-CRF-0695 
		if(isRemoveMandBPermitAppBy!="true" && datetimeofclaimingApplicable!="true"){
	
		if(temp.generate_burial_permit.checked){
			if(temp.body_claiming_date_time.value=="" || temp.burial_app_date.value=="" || (temp.burial_permit_app_by.value=="" && temp.burial_permit_app_desc.value=="")){	   
			var err=getMessage("CAPTURE_BURIAL_PRMT_DTLS","MO");			 
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+err;
			return false    	
			}
		}else{
			if((temp.body_burial_permit_no.value=="" || temp.body_claiming_date_time.value=="" || temp.burial_app_date.value=="" || (temp.burial_permit_app_by.value=="" && temp.burial_permit_app_desc.value=="")) && (temp.body_burial_permit_no.value!="" || temp.body_claiming_date_time.value!="" || temp.burial_app_date.value!="" || (temp.burial_permit_app_by.value!="" && temp.burial_permit_app_desc.value!=""))){			 
				var err=getMessage("CAPTURE_BURIAL_PRMT_DTLS","MO");			 
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+err;
				return false    	
			}
		}
		}else{
				//modified against [IN:068196]
			if(temp.generate_burial_permit.checked){
			    if(isChangeOfDateTimeClaimingAppl=="true"){
					if(temp.burial_app_date.value==""){	   
				var err=getMessage("CAPTURE_BURIAL_PRMT_DTLS","MO");			 
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+err;
				return false    	
				}
				}else{
					if(temp.body_claiming_date_time.value=="" || temp.burial_app_date.value==""){	   
				var err=getMessage("CAPTURE_BURIAL_PRMT_DTLS","MO");			 
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+err;
				return false    	
				}
				}
				
			}else{
			if(isChangeOfDateTimeClaimingAppl=="true"){
				if((temp.body_burial_permit_no.value=="" ||  temp.burial_app_date.value=="" ) && (temp.body_burial_permit_no.value!="" || temp.burial_app_date.value!="" )){			 
					var err=getMessage("CAPTURE_BURIAL_PRMT_DTLS","MO");			 
					messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+err;
					return false    	
			}}else{
				if((temp.body_burial_permit_no.value=="" || temp.body_claiming_date_time.value=="" || temp.burial_app_date.value=="" ) && (temp.body_burial_permit_no.value!="" || temp.body_claiming_date_time.value!="" || temp.burial_app_date.value!="" )){			 
					var err=getMessage("CAPTURE_BURIAL_PRMT_DTLS","MO");			 
					messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+err;
					return false    	
				}
			}
			}
		}


 }

}
 
 

 if(temp.donor_card_available_yn.checked)
{
  temp.donor_card_available_yn.value="Y"
 if(temp.donardetails.value==""||temp.donar_card_no.value=="" )
{
	 var err=getMessage("ENTER_DONOR_CARD_INFO","MO");

	messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+err;
 return false;
}
 
}else
{

temp.donor_card_available_yn.value="N";
}
 for(i=0;i<cnt;i++)
 {
  if(eval("temp.org"+i+".checked"))
 {
  checkedCode=checkedCode+eval("temp.org"+i+".value")+"|"
 
 
 }

 }
temp.donatedorgan.value=checkedCode


	if(temp.postmortem_reqd_yn.checked==true&&temp.mlc_yn.checked==false )
	{
			if(temp.postmortem_type.value=="")
		{
			var err=getMessage("CAN_NOT_BE_BLANK","Common");
			err= err.replace('$',getLabel("eMO.PostmortemType.label","MO"));
			
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+err;
			//messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=APP-000001 Postmortem Type cannot  be blank..."
			return false    
		}
			}
	
	/*if(eval(temp.causeofdeath.value.length)>250 )
	{        error=getMessage('DEATH_CAUSE_EXCEEDS_LMT')  
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+error
			return false    
	}*/
	 
	 if(eval(temp.identification_marks.value.length)>500 )
	{
			 var err=getMessage("ID_MARKS_EXCEEDS_LMT","MO");
			
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+err;
			return false    
	}
	
/*	if(f_query_add_mod.patientDetailsFrame.document.getElementById("consent_chk").checked==true)
   {
		if(f_query_add_mod.patientDetailsFrame.document.getElementById("consent_received_by").value=="" )
		{
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=APP-000001  Consent Form Received by cannot be blank..."
			return false    
		}
		if(f_query_add_mod.patientDetailsFrame.document.getElementById("consent_received_date").value=="" )
		{
		var msg=""
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=APP-000001 Consent Form Received Date/Time cannot be blank...";
		return false    
		}
	 
  }*/
	 
	 /* if(f_query_add_mod.patientDetailsFrame.document.getElementById("police_chk").checked==true)
	  {
	     if(f_query_add_mod.patientDetailsFrame.document.getElementById("police_received_by").value=="" )
	     {
		    var msg=" "
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=APP-000001 Police Approval Received by cannot be blank...";
		   return false    
	     }
	     if(f_query_add_mod.patientDetailsFrame.document.getElementById("police_received_date").value=="" )
	     {
	  	    var msg=" "
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=APP-000001  Police Approval Received Date/Time cannot be blank...";
		return false    
	     }
	  }*/ 
	 
	 
	 
	 if(temp.patient_id.value!="")
	 {
		 flag=1;
	 }
	 
	 
	 
	 if(flag==1)
	 {
		   
	   
	
    temp.area_type.disabled = false;
    temp.assign_date_time.disabled = false; 	
	temp.bed_no.disabled=false;
	if(temp.enable_rfid_yn.value=="Y") // added by mujafar for ML-MMOH-CRF-0996
	temp.RFID_Tag.disabled=false;
	temp.mlc_yn.disabled=false;
	temp.postmortem_reqd_yn.disabled=false;
	if(temp.postal_code != null)//Added by Thamizh selvi on 4th June 2018
		temp.ZIP_CODE.value=temp.postal_code.value
    temp.postmortem_type.disabled=false;
    temp.burial_permit_app_by.disabled=false;
	temp.body_burial_permit_no.disabled=false;
	temp.body_claiming_date_time.disabled=false;
	temp.burial_app_date.disabled=false;
    temp.refe_type.disabled=false;
	temp.hcare_type.disabled=false;
	temp.referral_source.disabled=false;
	temp.vechile_no.disabled=false;
	if(temp.NAT_ID_NO!=null)
	temp.NAT_ID_NO.disabled=false;
	temp.JOB_TITLE.disabled=false;
	temp.MOB_TEL_NO.disabled=false;
   
   /*Below line added for this CRF ML-MMOH-CRF-0695*/
   if(datetimeofclaimingApplicable=="true") temp.body_claiming_date_time.disabled=false;
   
       /*if(f_query_add_mod.patientDetailsFrame.document.forms[0].deceasedrelationship.checked)
		 {
		 f_query_add_mod.patientDetailsFrame.document.forms[0].deceasedrelationship.value='Y';
		 }
	     else
		 {
		 f_query_add_mod.patientDetailsFrame.document.forms[0].deceasedrelationship.value='N';
		 }*/
        temp.mlc_yn.disabled=false;
		if(temp.mlc_yn.checked)
         {
              temp.mlc_yn.value="Y"
           }else
           {
             temp.mlc_yn.value="N";
           }
		
		 if(temp.postmortem_reqd_yn.checked)
		{
		 temp.postmortem_reqd_yn.value="Y"
		}else
		{
		temp.postmortem_reqd_yn.value="N";
		}
		 
		 if(temp.highriskbodyyn.checked)
		 {
		 temp.highriskbodyyn.value='Y';
		 }
	     else
		 {
		 temp.highriskbodyyn.value='N';
		 }
		 
		 
		 if(temp.unclaimedbodyyn.checked)
		 {
		 temp.unclaimedbodyyn.value='Y';
		 }
	     else
		 {
		temp.unclaimedbodyyn.value='N';
		 }
 
	   
	   
	 
	   if(temp.name=='MO_regn_form')
		 {	  
		    
			temp.action="../../servlet/eMO.MOMortuaryRegnServlet" 			
			temp.submit();	
            
			/*Below line added for this CRF ML-MMOH-CRF-0695*/
             if(datetimeofclaimingApplicable=="true"){ 
			   if(!temp.body_claiming_date_time.disabled) temp.body_claiming_date_time.disabled=true;			 
			 }
			 //End this CRF ML-MMOH-CRF-0695
       		
			if(isChangeOfDateTimeClaimingAppl=="true"){ 
			 
			   if(temp.body_claiming_date_time.disabled) temp.body_claiming_date_time.disabled=false;		
			   
			 }
			
		 }

	 } 

	 }

	
}


   
function ChangeCase(obj)
{
	var pat_id = obj.value;
	pat_id = pat_id.toUpperCase();				
	obj.value = pat_id;
}  


async function callPatientSearch()
{
	
	var patientid = await PatientSearch('','','','','','','Y','','Y','MO');
	
	if(patientid !=null)
	{
		document.getElementById("patient_id").value = patientid;
		document.getElementById("patient_id").focus();
		
	}
	else
	{
		document.getElementById("patient_id").value = '';
	}
			
}





/*function ValidateDateTime (to)
{
	var dat = new Date();
	var hh = dat.getHours();
	var mm = dat.getMinutes();
	var sec = dat.getSeconds();
	var dd = dat.getDate();
	var mm = dat.getMonth()+1;
	var yy = dat.getYear();
	var from = dd + "/" + mm + "/" + yy + " " + hh + ":" + mm + ":" + sec;

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
    if(Date.parse(to_date) > Date.parse(from_date))
	{
		
		alert("Entered Date cannot be greater than Sysdate")
		

			return false
	}
	else
		return true;
}*/


//used by clear button in MORegisterAttn.jsp
function clearing()
{
	
	  if( parent.frames[1])
		parent.frames[1].document.location.href='../../eCommon/html/blank.html';
	  if( parent.frames[2].document.forms[0])
		parent.frames[2].document.location.href='../../eCommon/html/blank.html';
	  if( parent.frames[3].document.forms[0])
		parent.frames[3].document.location.href='../../eCommon/html/blank.html';
	  
	  //if( parent.parent.frames[2])
		//parent.parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp';
}

/*Added For IN:046059 By Lenin on 02-Jan-2013 Start*/
		function tab_enable(calledFrom) {					
					if(calledFrom == 'regn_dtls_tab') {
						document.getElementById("REGDETAILS").style.display = 'inline';
						document.getElementById("ORGDONATION").style.display = 'none';
						document.getElementById("CLAIMANT").style.display = 'none';
						document.getElementById("BURIAL").style.display = 'none';
						
					} else if(calledFrom == 'organ_dtn_tab') {
						document.getElementById("REGDETAILS").style.display = 'none';
						document.getElementById("ORGDONATION").style.display = 'inline';
						document.getElementById("CLAIMANT").style.display = 'none';
						document.getElementById("BURIAL").style.display = 'none';
						
					} else if(calledFrom == 'claimant_tab') {
						document.getElementById("REGDETAILS").style.display = 'none';
						document.getElementById("ORGDONATION").style.display = 'none';
						document.getElementById("CLAIMANT").style.display = 'inline';
						document.getElementById("BURIAL").style.display = 'none';
						
					} else if(calledFrom == 'burial_prmt_tab') {
						document.getElementById("REGDETAILS").style.display = 'none';
						document.getElementById("ORGDONATION").style.display = 'none';
						document.getElementById("CLAIMANT").style.display = 'none';
						document.getElementById("BURIAL").style.display = 'inline';
						
					}
				}
/*Added For IN:046059 By Lenin on 02-Jan-2013 End*/

function CheckSysdate(from,to,obj)
{
  if(obj.value!='')
	 {
		if(CheckDate(obj)==true) 
		{
			ValidateSysDate(from,to,obj);
		}
	 }
}
function ValidateSysDate(from,to,obj)
{
	from	= from.value;
	to		= to.value;

	var a=  from.split(" ")
	splitdate=a[0];
	splittime=a[1];
	var splitdate1 =a[0].split("/");
	var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]));
    a=  to.split(" ");
	splitdate=a[0];
	splittime=a[1];

	splitdate1 =a[0].split("/");
	var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]));
    if(Date.parse(to_date) < Date.parse(from_date))
	{
		alert(getMessage("AE_LMP_DATE_CHECK","AE"));
		obj.select();
		obj.focus();
		return false;
	}
	else
		return true;
}

function setEmergency(obj)
{
	if (obj.checked == true)
	{
		document.forms[0].emergency.value='Y';
	}
	else if (obj.checked == false)
	{
		document.forms[0].emergency.value='N';
	}
}



function getConsentForm()
{

 var dialogHeight = "65vh" ;
 var dialogWidth  = "45vw" ;
 var dialogTop    = "225";
 var dialogLeft   = "225";
 var patient_id = document.forms[0].patient_id.value;

 var title = getLabel("eMO.ConsentClnicPstMrm.label","MO");
 
 conscentgivenby=document.forms[0].conscentgivenby.value;

 deceasedrelationship=document.forms[0].deceasedrelationship.value;
 consent_received_by=document.forms[0].consent_received_by.value;
 consent_received_date=document.forms[0].consent_received_date.value;
 
 var consent_received_desc=document.forms[0].consent_received_desc.value;
 var body_received_date_time = document.forms[0].body_received_date_time.value;
 var sys_date = document.forms[0].system_date.value;
	mode=document.forms[0].mode.value;
 var result		  = document.forms[0].consent_form_code.value+"||"+document.forms[0].consent_desc.value;
 var arguments       = result ;
 var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ ";          dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
 retVal	= window.showModalDialog("../../eMO/jsp/ConsentDetailsFrameSet.jsp?patient_id="+patient_id+"&sys_date="+sys_date+"&body_received_date_time="+body_received_date_time+"&conscentgivenby="+conscentgivenby+"&deceasedrelationship="+deceasedrelationship+"&consent_received_by="+consent_received_by+"&consent_received_date="+consent_received_date+"&title="+title+"&consent_received_desc="+consent_received_desc+"&mode="+mode,arguments,features);

  if(retVal!="" &&retVal!=null)
	{
	 var finalresults=retVal.split("||");
	 document.getElementById("consent_form_code").value = finalresults[0]
	 document.getElementById("consent_desc").value = finalresults[1]
	 document.getElementById("conscentgivenby").value = finalresults[2]
	 document.getElementById("deceasedrelationship").value = finalresults[3]
	 document.getElementById("consent_received_by").value = finalresults[4]
     document.getElementById("consent_received_date").value = finalresults[5]
     document.getElementById("consent_received_desc").value = finalresults[6]
	 
	 }
}

async function policedetails()
{
 var patient_id =document.forms[0].patient_id.value;
 body_received_date_time = document.forms[0].body_received_date_time.value;
 sys_date = document.forms[0].system_date.value;
 pol_rep_no=document.getElementById("pol_rep_no").value
 pol_stn_id=document.getElementById("pol_stn_id").value
 pol_id=document.getElementById("pol_id").value
 police_approval_received_yn=document.getElementById("police_approval_received_yn").value
 police_received_by=document.getElementById("police_received_by").value
 police_approval_received_by_desc=document.getElementById("police_approval_received_by_desc").value
 police_received_date=document.getElementById("police_received_date").value
 police_details= escape(document.forms[0].police_details.value);
 mode=document.getElementById("mode").value;
 /*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
 var calledFrom			= document.forms[0].calledFrom.value;
 var externalBidYn		= document.getElementById("extBidYnFrmVw").value;
 pol_officer_name		= document.getElementById("pol_officer_name").value;
 pol_contact_no			= document.getElementById("pol_contact_no").value;

 if(calledFrom == "MO_BID_REGN" || externalBidYn == "Y"){
	var dialogHeight = "29" ;
	var dialogWidth  = "36" ;
 }else{
	var dialogHeight = "26" ;
	var dialogWidth  = "35" ;
 }/*End*/
 var dialogTop    = "225";
 var dialogLeft   = "225";
 var dialogHeight = "68vh" ;
 var dialogWidth  = "45vw" ;
 var arguments       = "" ;
 var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
 retVal	= await window.showModalDialog("../../eMO/jsp/PoliceDetailsFrameSet.jsp?patient_id="+patient_id+"&sys_date="+sys_date+"&body_received_date_time="+body_received_date_time+"&pol_rep_no="+encodeURIComponent(pol_rep_no)+"&pol_stn_id="+encodeURIComponent(pol_stn_id)+"&pol_id="+encodeURIComponent(pol_id)+"&police_details="+police_details+"&police_approval_received_yn="+police_approval_received_yn+"&police_received_by="+police_received_by+"&police_received_date="+police_received_date+"&pol_officer_name="+encodeURIComponent(pol_officer_name)+"&pol_contact_no="+encodeURIComponent(pol_contact_no)+"&externalBidBodyPartYn="+externalBidYn+"&calledFrom="+calledFrom+"&mode="+mode+"&police_approval_received_by_desc="+encodeURIComponent(police_approval_received_by_desc),arguments,features);//Modified by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689
 if(retVal!=""&&retVal!=null )
	{
		var finalresults=retVal.split("||");
		document.getElementById("pol_rep_no").value= finalresults[0]
		document.getElementById("pol_stn_id").value= finalresults[1]
		document.getElementById("pol_id").value= finalresults[2]
		document.getElementById("police_details").value= finalresults[3]
		document.getElementById("police_approval_received_yn").value= finalresults[4]
		document.getElementById("police_received_by").value= finalresults[5]
		document.getElementById("police_received_date").value= finalresults[6]
        document.getElementById("police_approval_received_by_desc").value=finalresults[7]
		/*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
		if(calledFrom == "MO_BID_REGN" || externalBidYn == "Y"){
			document.getElementById("pol_officer_name").value	= finalresults[8];
			document.getElementById("pol_contact_no").value	= finalresults[9];
		}/*End*/
 }

 
}
async function displaycontactdetails()
{
	var patient_id = document.forms[0].patient_id.value;
	
	var dialogHeight = "26" ;
	var dialogWidth  = "40" ;
	var dialogTop    = "230";
	var dialogLeft   = "230";
	var arguments       = "" ;
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
  	await window.showModalDialog("../../eMO/jsp/ContactDisplayDtls.jsp?patient_id="+patient_id,arguments,features);
}

/*function CapacityCheck()
{
  var registration_no = ''
  
  var area_code = document.forms[0].area_type.value;
  if(area_code!="")
  {
  var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH registration_no=\""+registration_no+"\" area_code=\""+area_code+"\"/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","MOCapacityCheck.jsp",false);
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	
		if(responseText=="checked")
		{
		alert(getMessage("AREA_EXCEEDS_CAPACITY"))
			document.forms[0].area_type.value = '';
		}
	 if(document.forms[0].area_type.value != "")
	{
	 document.forms[0].bed_no.value="";
	 document.forms[0].bed_no.disabled=false;
	document.forms[0].bed_button.disabled=false;
	}
	else{
		document.forms[0].bed_no.value="";
	   document.forms[0].bed_no.disabled=true;
	document.forms[0].bed_button.disabled=true;
	}
  }

}*/

function BedCheck()
{
 var area_code = document.forms[0].area_type.value;
  var bed_no =document.forms[0].bed_no.value;
  var patient_id =document.forms[0].patient_id.value;
  var bedVaild='Y';
  if(area_code!="" && bed_no != "")
  {
    var xmlDoc=new ActiveXObject("Microsoft.XMLDom");
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH bed_no=\""+bed_no+"\" area_code=\""+area_code+"\" patient_id=\""+patient_id+"\"  bedVaild=\""+bedVaild+"\"/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MOCapacityCheck.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	if(responseText=="Invalid")
		{
			var error = getMessage('INVALID_VALUE','Common');
			error = error.replace('#',getLabel("Common.Location.label","Common"));
			alert(error);
	    	
			document.forms[0].bed_no.value = '';
			document.forms[0].bed_no.select();
		}
		else return;
  }

	if(document.forms[0].area_type)
	{
		 if(document.forms[0].area_type.value != "")
		 {
			  document.forms[0].bed_no.value="";
			  document.forms[0].bed_no.disabled=false;
			  document.forms[0].bed_button.disabled=false;
		}
		else {
			 document.forms[0].bed_no.value="";
			 document.forms[0].bed_no.disabled=true;
			 document.forms[0].bed_button.disabled=true;
		}
	}
}


function beforeGetPractitioner(obj,target_name)
{
	target_name.value = trimString(target_name.value);
	
	if (target_name.name=='police_received_by_desc')
	{
		if(target_name.value == "")
			{
			 document.forms[0].police_received_by_desc.value="";
			 document.forms[0].police_received_by.value="";
			 return;
			}
	}
	if (target_name.name=='consent_received_desc')
	{
		if(target_name.value == "")
			{
			 document.forms[0].consent_received_desc.value="";
			 document.forms[0].consent_received_by.value="";
			 return;
			}
	}
	
	else if (target_name.name=='burial_permit_app_desc')
	{
		if(target_name.value == "")
			{
			 document.forms[0].burial_permit_app_desc.value="";
			 document.forms[0].burial_permit_app_by.value="";
			 return;
			}

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
	xmlStr += " practName_FValue=\"" + escape(practitionerValue) + "\"";
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
	eval(responseText);
				
	return;            
	
	var retVal= await CommonLookup(tit,argumentArray);
	var str =unescape(retVal);
	var arr = str.split(",");

	if(retVal==null || retVal=="")
		target.value="";
	else
		target.value=arr[0];
		            
}
function PractLookupRetVal(retVal,objName)
{
	var arr;
	
	if (retVal != null && retVal != ""  && retVal != 'undefined')
	{
		arr=retVal.split("~");
    
		
		if(objName=="police_received_by_desc")
		{
		   document.forms[0].police_received_by.value=arr[0];
		   document.forms[0].police_received_by_desc.value=arr[1];
		}
		
		if(objName=="burial_permit_app_desc")
		{
		   document.forms[0].burial_permit_app_by.value=arr[0];
		   document.forms[0].burial_permit_app_desc.value=arr[1];
	  }
		
		if(objName=="consent_received_desc")
		{
		   document.forms[0].consent_received_by.value=arr[0];
		   document.forms[0].consent_received_desc.value=arr[1];
		}
	
	
	}else
	{
		if(objName=="burial_permit_app_desc")
		{
		   document.forms[0].burial_permit_app_by.value="";
		   document.forms[0].burial_permit_app_desc.value="";
		}
		if(objName=="consent_received_desc")
		{
		   document.forms[0].consent_received_by.value="";
		   document.forms[0].consent_received_desc.value="";
		}
	
	
	}
	
	
}



function enableManGif(burial_permit_reqd_yn){		 //Suresh M
 
   
 
	if(document.getElementById("burial_permit_reqd_yn").value=="N"){
		document.getElementById("burMan").style.visibility='hidden';
		/*Below line modified for this CRF ML-MMOH-CRF-0695*/
		if(document.getElementById("burMan1")) document.getElementById("burMan1").style.visibility='hidden';
		//End this CRF ML-MMOH-CRF-0695
		
		if(document.getElementById("burMan2"))
			document.getElementById("burMan2").style.visibility='hidden';
		document.getElementById("burMan3").style.visibility='hidden';
		
	}else{
		document.getElementById("burMan").style.visibility='visible';		
		/*Below line added for this CRF ML-MMOH-CRF-0695*/
		if(document.getElementById("datetimeofclaimingApplicable") && document.getElementById("datetimeofclaimingApplicable").value=="true"){		
		     if(document.getElementById("burMan1")) document.getElementById("burMan1").style.visibility='hidden';
		}else{
		     if(document.getElementById("burMan1"))document.getElementById("burMan1").style.visibility='visible';
		}
		//End this CRF ML-MMOH-CRF-0695
		
		
		if(document.getElementById("burMan2"))
			document.getElementById("burMan2").style.visibility='visible';
		document.getElementById("burMan3").style.visibility='visible';
	}
}  //Suresh M Ends


function blurRFID(obj){
	if(obj.value !=""){
		searchRFID(obj,document.forms[0].RFID_Tag);
	}
}

async function searchRFID(obj,target){
	var retVal =    new String(); 
	var area_code = "";
	var retVal = "";
	var dialogHeight= "80vh" ;
	var dialogWidth	= "40vw" ;
	var dialogTop ="60";
	var status = "no";
	var arguments	= " ";	 
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
    var retVal=	await window.showModalDialog("../../eMO/jsp/RFIDTagFrameset.jsp?RFID_No="+document.forms[0].RFID_Tag.value,arguments,features);
    if(retVal != null && retVal != "" ){
	  document.forms[0].RFID_Tag.value=retVal;
	 }else{
		 document.forms[0].RFID_Tag.value="";
	 }
}
/*Added by Thamizh selvi on 21st July 2017 for ML-MMOH-CRF-0689 Start*/
async function openEmergRegn(){

	var retVal =  new String();
	var dialogTop= "60";
	var dialogHeight= "43" ;
	var dialogWidth = "75" ;
	var features  = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no; scroll=no";
	var arguments = "" ;
	var apply_oth_name = "N";

	var url="../../eMP/jsp/EmergRegn.jsp?apply_oth_name="+apply_oth_name+"&called_from=MO_BID_REGN&func_act=Visitreg&module_id=MP&function_id=EM_PAT_REG&function_name=Emergency%20Patient&function_type=F&access=YYYNN";
		 
	retVal =await  window.showModalDialog(url,arguments,features);
	
	if(retVal != null)
	{	
		document.forms[0].patient_id.value= retVal;

		parent.document.getElementById("b").rows='*' 
		parameter="menu_id=MO_MENU&module_id=MO&function_id=MO_REGISTER_DECEASED&function_name=Deceased Registration&function_type=F&access=NYYNN" ;
		top.content.location.href = "../../eMO/jsp/MORegisterDeceased.jsp?"+parameter+"&patientID="+document.forms[0].patient_id.value+"&menudis=MO_REGN_ATTN&external=Y" ;

	}	
}
function clearPoliceDtls(){
	if(!document.getElementById("mlc_yn").checked)
	{
		 document.getElementById("pol_rep_no").value="";
		 document.getElementById("pol_stn_id").value="";
		 document.getElementById("pol_id").value="";
		 document.getElementById("police_details").value="";
		 document.getElementById("police_approval_received_yn").value="N";
		 document.getElementById("police_received_by").value="";
		 document.getElementById("police_approval_received_by_desc").value="";
		 document.getElementById("police_received_date").value="";
		 document.getElementById("pol_officer_name").value="";
		 document.getElementById("pol_contact_no").value="";
	}
}/*End*/

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
function SpCharChkForPassportNo(event)
{
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
function validSplchars(obj)
{		
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]="Passport No";									
	if(SpecialCharCheck(fields, names,'',"A",''))
		return true;
	else
	{
		obj.value = "";
		obj.focus();
		return false;
	}
}


