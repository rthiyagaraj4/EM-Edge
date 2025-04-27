
function set_values(obj,patient_id)
  { 

CLAIMANT_TYPE=document.forms[0].CLAIMANT_TYPE.value
name2=obj.value;
HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMO/jsp/MORegisterClaimantResult.jsp'><input type='hidden' name='pid' id='pid' value='"+patient_id+"'><input type='hidden' name='bodypart' id='bodypart' value='cmgfrmreleasedeas'><input type='hidden' name='name1' id='name1' value='"+CLAIMANT_TYPE+"'><input type='hidden' name='ctype' id='ctype' value='"+name2+"'></form></body></html>";
//parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
parent.frames[2].document.write(HTMLVal);
parent.frames[2].document.dum_form.submit();

 
}


function searchCountry(obj,target)
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
		tit = getLabel("Common.country.label","Common");
		//sql="Select country_code code,short_name description from Mp_Country where eff_status='E' and upper(country_code) like upper(?) and upper(short_name) like upper(?) order by 2";
		sql = "Select country_code code,short_name description from MP_COUNTRY_LANG_VW where LANGUAGE_ID='"+localeName+"' and eff_status='E' and upper(country_code) like upper(?) and upper(short_name) like upper(?) order by 2";
	   }else if(target.name=='m_town_code')//if(target.name=='town')
	   {
		tit = getLabel("Common.Town.label","Common");	
		//sql="select res_town_code code,short_desc description from mp_res_town  where eff_status='E' and upper(res_town_code) like upper(?) and upper(short_desc) like upper(?) order by 2"
		sql="select res_town_code code,short_desc description from MP_RES_TOWN_LANG_VW  where LANGUAGE_ID='"+localeName+"' and eff_status='E' and upper(res_town_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
	   }else if(target.name=='m_area_code') //if(target.name=='area')
	   {
		tit = getLabel("Common.area.label","Common");	 
		//sql="select RES_AREA_CODE code, short_desc description from mp_res_area where eff_status='E' and upper(RES_AREA_CODE) like upper(?) and upper(short_desc) like upper(?) order by 2"
		sql="select RES_AREA_CODE code, short_desc description from MP_RES_AREA_LANG_VW where LANGUAGE_ID='"+localeName+"' and eff_status='E' and upper(RES_AREA_CODE) like upper(?) and upper(short_desc) like upper(?) order by 2";
	   }else if(target.name=='m_region_code') //if(target.name=='region')
	   {
		tit = getLabel("eMP.region.label","mp");	
		//sql="select REGION_CODE code, short_desc  description from mp_region where eff_status='E' and upper(REGION_CODE) like upper(?) and upper(short_desc) like upper(?) order by 2"
		sql="select REGION_CODE code, short_desc  description from MP_REGION_LANG_VW where LANGUAGE_ID='"+localeName+"' and eff_status='E' and upper(REGION_CODE) like upper(?) and upper(short_desc) like upper(?) order by 2";
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
			  }else if(target.name=='m_region_code')//if(target.name=='region')
			  {
			//document.forms[0].region.value=arr[1];
			document.forms[0].m_region_code.value=arr[1];
			document.forms[0].region1.value=arr[0];
			  
			  }else  if(target.name=='m_town_code')//if(target.name=='town')
			  {
			  //document.forms[0].town.value=arr[1];
			  //document.forms[0].town1.value=arr[0];
			  document.forms[0].m_town_code.value=arr[1];
			  document.forms[0].town1.value=arr[0];
			  parent.dummyFrame.location.href='../../eMO/jsp/PopulateAddress.jsp?townCode='+arr[0]+"&framsel=fram1"
			
			  }
			  if(target.name=='m_area_code') //if(target.name=='area')
			  {
			  //document.forms[0].area.value=arr[1];
			  document.forms[0].m_area_code.value=arr[1];
			  document.forms[0].area1.value=arr[0];
			  parent.dummyFrame.location.href='../../eMO/jsp/PopulateAddress.jsp?areaCode='+arr[0]+"&framsel=fram1"
			
			  }
					
					
					
					}
				else
				  {
					target.value='';
			      }
		}


/*function searchCountry(obj,target)
   {
		tar=document.forms[0].COUNTRY_DESC.value
		
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit="";				
		tit="Country"
		sql="Select country_code code,short_name description from Mp_Country where eff_status='E' and upper(country_code) like upper(?) and upper(long_desc) like upper(?) order by 2";
			
		
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
			document.forms[0].COUNTRY_DESC.value=arr[1];
			document.forms[0].COUNTRY_CODE.value=arr[0];
			}
			else
			  {
					target.value='';
			      }
		}*/
function searchCountry1(obj,target)
{
	if(obj.value == "")
	{obj.value="";
	  return ;
	}
searchCountry(obj,target)

}

		function callPostalSearch(target)
{
	    var retVal =    new String();
		var dialogHeight= "28" ;
		var dialogWidth = "43" ;
		var status = "no";
		var arguments   = "" ;
		var sql="";
		var search_code="";
		var search_desc="";
		var tit="";

		tit = getLabel("eMP.postalcode.label","MP");
		//sql="select postal_code, short_desc from mp_postal_code"; 
		sql="select postal_code, short_desc from MP_POSTAL_CODE_LANG_VW where LANGUAGE_ID=`"+localeName+"`"; 
		search_code="postal_code";
		search_desc= "short_desc";
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

		if (!(retVal == null))
		{
		
			target.value=retVal;
			
		}
		else
			target.focus();
}

function copyDet(patient_id)
 {
document.forms[0].PATIENT_EMPLOYEE_ID.value="";
document.forms[0].ORGANIZATION_NAME.value="";
 CLAIMANT_TYPE=document.forms[0].CLAIMANT_TYPE.value

 HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMO/jsp/MORegisterClaimantResult.jsp'><input type='hidden' name='pid' id='pid' value='"+patient_id+"'><input type='hidden' name='name1' id='name1' value='"+CLAIMANT_TYPE+"'><input type='hidden' name='bodypart' id='bodypart' value='cmgfrmreleasedeas'></form></body></html>";
//parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
parent.frames[2].document.write(HTMLVal);
parent.frames[2].document.dum_form.submit();

}



function ClearClaimantValues()
{

if(document.getElementById("unclaimed_body_yn").checked)
{
if(document.getElementById("CLAIMANT_TYPE").value=="E"||document.getElementById("CLAIMANT_TYPE").value=="K"||document.getElementById("CLAIMANT_TYPE").value=="F")//changes for 38265
{
document.forms[0].CLAIMANT_TYPE_CODE.options[0].selected=true;
document.forms[0].CLAIMANT_TYPE_CODE.disabled=true;
document.forms[0].copydet.disabled=false;
//parent.frames[3].document.forms[0].copydet.disabled=true;
//document.forms[0].postal_search.disabled=true
document.forms[0].postal_code.disabled=true
document.forms[0].contry_code.disabled=true
document.forms[0].NAME.disabled=true;
document.forms[0].NAME.value="";
document.forms[0].RELATIONSHIP.disabled=true;
document.forms[0].RELATIONSHIP.options[0].selected=true;
document.forms[0].PATIENT_EMPLOYEE_ID.disabled=true
document.forms[0].PATIENT_EMPLOYEE_ID.value="";
document.forms[0].ORGANIZATION_NAME.disabled=true
document.forms[0].ORGANIZATION_NAME.value="";
document.forms[0].JOB_TITLE.disabled=true
document.forms[0].JOB_TITLE.value=""
//document.getElementById("twnsrch").disabled=true;
//document.getElementById("areasrch").disabled=true;
//document.getElementById("rgnsrh").disabled=true;
document.getElementById("town_code").disabled=true;
document.getElementById("area_code").disabled=true;
document.getElementById("region_code").disabled=true;

//if(document.getElementById("area")!=null)
//document.forms[0].area.value=""

if(document.getElementById("m_area_code")!=null)
	document.forms[0].m_area_code.value=""


//if(document.getElementById("town")!=null)
//document.forms[0].town.value=""
if(document.getElementById("m_town_code")!=null)
	document.forms[0].m_town_code.value=""

//if(document.getElementById("region")!=null)
//document.forms[0].region.value=""

if(document.getElementById("m_region_code")!=null)
	document.forms[0].m_region_code.value=""


//if(document.getElementById("area")!=null)
//document.forms[0].area.disabled=true

if(document.getElementById("m_area_code")!=null)
	document.forms[0].m_area_code.disabled=true


if(document.forms[0].addr_line_1!=null)
{
document.forms[0].addr_line_1.disabled=true
document.forms[0].addr_line_1.value=""
}
if(document.forms[0].addr_line_2!=null)
{
document.forms[0].addr_line_2.disabled=true
document.forms[0].addr_line_2.value=""
}
if(document.forms[0].addr_line_3!=null)
{
document.forms[0].addr_line_3.disabled=true
document.forms[0].addr_line_3.value=""
}
if(document.forms[0].addr_line_4!=null)
{
document.forms[0].addr_line_4.disabled=true
document.forms[0].addr_line_4.value=""
}
if(document.forms[0].m_postal_code!=null)
{
document.forms[0].m_postal_code.disabled=true
document.forms[0].m_postal_code.value=""
}
document.forms[0].COUNTRY_DESC.disabled=true
document.forms[0].COUNTRY_DESC.value=""
document.forms[0].TELEPHONE_OFF.disabled=true
document.forms[0].TELEPHONE_OFF.value="";
document.forms[0].TELEPHONE_RES.disabled=true
document.forms[0].TELEPHONE_RES.value="";
document.forms[0].MOB_TEL_NO.disabled=true
document.forms[0].MOB_TEL_NO.value=""
document.forms[0].NAT_ID_NO.disabled=true
document.forms[0].NAT_ID_NO.value=""
document.forms[0].EMAIL_ID.disabled=true
document.forms[0].EMAIL_ID.value=""
}

//document.getElementById("unclaimedbodyyn").checked

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
opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
opt.value=""
document.getElementById("CLAIMANT_TYPE").add(opt);


var opt=document.createElement('OPTION');
opt.text=getLabel("Common.nextofkin.label","Common");
opt.value="K"
document.getElementById("CLAIMANT_TYPE").add(opt);

var opt=document.createElement('OPTION');
opt.text=getLabel("Common.employer.label","Common");
opt.value="E"
document.getElementById("CLAIMANT_TYPE").add(opt);

var opt=document.createElement('OPTION');
opt.text=getLabel("eMO.EmbassyCountry.label","mo");
opt.value="M"
document.getElementById("CLAIMANT_TYPE").add(opt);

var opt=document.createElement('OPTION');
opt.text=getLabel("eMO.WelfareAssociations.label","mo");
opt.value="W"
document.getElementById("CLAIMANT_TYPE").add(opt);

var opt=document.createElement('OPTION');
opt.text=getLabel("eMO.ReligiousOrgn.label","mo");
opt.value="R"
document.getElementById("CLAIMANT_TYPE").add(opt);


var opt=document.createElement('OPTION');
opt.text=getLabel("eMO.UnderTaker.label","mo");
opt.value="U"
document.getElementById("CLAIMANT_TYPE").add(opt);

var opt=document.createElement('OPTION');
opt.text=getLabel("Common.others.label","common");
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
document.forms[0].copydet.disabled=false;
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

}


}





function clearClaimantValue1()
{
document.forms[0].copydet.disabled=true;
document.forms[0].CLAIMANT_TYPE_CODE.options[0].selected=true;
document.forms[0].CLAIMANT_TYPE_CODE.disabled=true;
//parent.frames[3].document.forms[0].copydet.disabled=true;
//document.forms[0].postal_search.disabled=true
document.forms[0].postal_code.disabled=true
document.forms[0].contry_code.disabled=true
document.forms[0].NAME.disabled=true;
document.forms[0].NAME.value="";
document.forms[0].RELATIONSHIP.disabled=true;
document.forms[0].RELATIONSHIP.options[0].selected=true;
document.forms[0].PATIENT_EMPLOYEE_ID.disabled=true
document.forms[0].PATIENT_EMPLOYEE_ID.value="";
document.forms[0].ORGANIZATION_NAME.disabled=true
document.forms[0].ORGANIZATION_NAME.value="";
document.forms[0].JOB_TITLE.disabled=true
document.forms[0].JOB_TITLE.value=""
if(document.forms[0].addr_line_1!=null)
{
document.forms[0].addr_line_1.disabled=true
document.forms[0].addr_line_1.value=""
}
if(document.forms[0].addr_line_2!=null)
{
document.forms[0].addr_line_2.disabled=true
document.forms[0].addr_line_2.value=""
}
if(document.forms[0].addr_line_3!=null)
{
document.forms[0].addr_line_3.disabled=true
document.forms[0].addr_line_3.value=""
}
if(document.forms[0].addr_line_4!=null)
{
document.forms[0].addr_line_4.disabled=true
document.forms[0].addr_line_4.value=""
}
if(document.forms[0].m_postal_code!=null)
{
document.forms[0].m_postal_code.disabled=true
document.forms[0].m_postal_code.value=""
}
document.forms[0].COUNTRY_DESC.disabled=true
document.forms[0].COUNTRY_DESC.value=""
document.forms[0].TELEPHONE_OFF.disabled=true
document.forms[0].TELEPHONE_OFF.value="";
document.forms[0].TELEPHONE_RES.disabled=true
document.forms[0].TELEPHONE_RES.value="";
document.forms[0].MOB_TEL_NO.disabled=true
document.forms[0].MOB_TEL_NO.value=""
document.forms[0].NAT_ID_NO.disabled=true
document.forms[0].NAT_ID_NO.value=""
document.forms[0].EMAIL_ID.disabled=true
document.forms[0].EMAIL_ID.value=""
//document.getElementById("twnsrch").disabled=true;
//document.getElementById("areasrch").disabled=true;
//document.getElementById("rgnsrh").disabled=true;
document.getElementById("town_code").disabled=true;
document.getElementById("area_code").disabled=true;
document.getElementById("region_code").disabled=true;

//if(document.getElementById("area")!=null)
//document.forms[0].area.value=""

if(document.getElementById("m_area_code")!=null)
	document.forms[0].m_area_code.value=""


//if(document.getElementById("town")!=null)
//document.forms[0].town.value=""
if(document.getElementById("m_town_code")!=null)
	document.forms[0].m_town_code.value=""


//if(document.getElementById("region")!=null)
//document.forms[0].region.value=""

if(document.getElementById("m_region_code")!=null)
	document.forms[0].m_region_code.value=""


//if(document.getElementById("area")!=null)
//document.forms[0].area.disabled=true

if(document.getElementById("m_area_code")!=null)
	document.forms[0].m_area_code.disabled=true


//if(document.getElementById("town")!=null)
//document.forms[0].town.disabled=true

if(document.getElementById("m_town_code")!=null)
	document.forms[0].m_town_code.disabled=true




}

function getClaimant(obj,claimcode)
{claimcode="";

if(obj.value=="")
{
document.forms[0].CLAIMANT_TYPE_CODE.options[0].selected=true;
document.forms[0].CLAIMANT_TYPE_CODE.disabled=true;
document.forms[0].copydet.disabled=true;
document.forms[0].copydet.disabled=true;
//document.forms[0].postal_search.disabled=true
document.forms[0].postal_code.disabled=true;
document.forms[0].contry_code.disabled=true;
document.forms[0].NAME.disabled=true;
document.forms[0].NAME.value="";
document.forms[0].RELATIONSHIP.disabled=true;
document.forms[0].RELATIONSHIP.options[0].selected=true;
document.forms[0].PATIENT_EMPLOYEE_ID.disabled=true

document.forms[0].ORGANIZATION_NAME.disabled=true;
document.forms[0].PATIENT_EMPLOYEE_ID.value="";
document.forms[0].ORGANIZATION_NAME.value="";
document.forms[0].JOB_TITLE.disabled=true
document.forms[0].JOB_TITLE.value=""

//document.getElementById("twnsrch").disabled=true;
//document.getElementById("areasrch").disabled=true;
//document.getElementById("rgnsrh").disabled=true;
document.getElementById("town_code").disabled=true;
document.getElementById("area_code").disabled=true;
document.getElementById("region_code").disabled=true;



//if(document.getElementById("area")!=null)
//document.forms[0].area.value=""

if(document.getElementById("m_area_code")!=null)
	document.forms[0].m_area_code.value="";


if(document.getElementById("m_postal_code1")!=null){
	document.forms[0].m_postal_code1.value="";
	document.getElementById("m_postal_code1").disabled=true;
}




//if(document.getElementById("town")!=null)
//document.forms[0].town.value=""
if(document.getElementById("m_town_code")!=null)
	document.forms[0].m_town_code.value=""


//if(document.getElementById("region")!=null)
//document.forms[0].region.value=""

if(document.getElementById("m_region_code")!=null)
	document.forms[0].m_region_code.value=""


//if(document.getElementById("area")!=null)
//document.forms[0].area.disabled=true

if(document.getElementById("m_area_code")!=null)
	document.forms[0].m_area_code.disabled=true


//if(document.getElementById("town")!=null)
//document.forms[0].town.disabled=true

if(document.getElementById("m_town_code")!=null)
	document.forms[0].m_town_code.disabled=true



//if(document.getElementById("region")!=null)
//document.forms[0].region.disabled=true

if(document.getElementById("m_region_code")!=null)
	document.forms[0].m_region_code.disabled=true



if(document.forms[0].addr_line_1!=null)
	{
document.forms[0].addr_line_1.disabled=true
	document.forms[0].addr_line_1.value=""
	}
if(document.forms[0].addr_line_2!=null)
{
document.forms[0].addr_line_2.disabled=true
document.forms[0].addr_line_2.value=""
}
if(document.forms[0].addr_line_3!=null)
	{
document.forms[0].addr_line_3.disabled=true
	document.forms[0].addr_line_3.value=""
	}
if(document.forms[0].addr_line_4!=null)
	{
document.forms[0].addr_line_4.disabled=true
	document.forms[0].addr_line_4.value=""
	}
if(document.forms[0].m_postal_code!=null)
	{
document.forms[0].m_postal_code.disabled=true
	document.forms[0].m_postal_code.value=""
	}
document.forms[0].COUNTRY_DESC.disabled=true
document.forms[0].COUNTRY_DESC.value=""
document.forms[0].TELEPHONE_OFF.disabled=true
document.forms[0].TELEPHONE_OFF.value="";
document.forms[0].TELEPHONE_RES.disabled=true
document.forms[0].TELEPHONE_RES.value="";
document.forms[0].MOB_TEL_NO.disabled=true
document.forms[0].MOB_TEL_NO.value=""
document.forms[0].NAT_ID_NO.disabled=true
document.forms[0].NAT_ID_NO.value=""
document.forms[0].EMAIL_ID.disabled=true
document.forms[0].EMAIL_ID.value=""
document.getElementById("id3").style.visibility='hidden'; // Added Aginst PAS-INC-MO -> Release Deceased/Body Part [IN:043269] By Saanthaakumar
}else
if(obj.value=='K')
{
	
	
//document.getElementById("twnsrch").disabled=false;
//document.getElementById("areasrch").disabled=false;
//document.getElementById("rgnsrh").disabled=false;

document.getElementById("town_code").disabled=false;
document.getElementById("area_code").disabled=false;
document.getElementById("region_code").disabled=false;

//if(document.getElementById("area")!=null)
//document.forms[0].area.value=""

if(document.getElementById("m_area_code")!=null)
	document.forms[0].m_area_code.value=""


//if(document.getElementById("town")!=null)
//document.forms[0].town.value=""

if(document.getElementById("m_town_code")!=null)
	document.forms[0].m_town_code.value=""

//if(document.getElementById("region")!=null)
//document.forms[0].region.value=""

if(document.getElementById("m_region_code")!=null)
	document.forms[0].m_region_code.value=""


//if(document.getElementById("area")!=null)
//document.forms[0].area.disabled=false

if(document.getElementById("m_area_code")!=null)
	document.forms[0].m_area_code.disabled=false


//if(document.getElementById("town")!=null)
//document.forms[0].town.disabled=false
if(document.getElementById("m_town_code")!=null)
	document.forms[0].m_town_code.disabled=false


//if(document.getElementById("region")!=null)
//document.forms[0].region.disabled=false

if(document.getElementById("m_region_code")!=null)
	document.forms[0].m_region_code.disabled=false



document.getElementById("id3").style.visibility='hidden';
document.forms[0].CLAIMANT_TYPE_CODE.disabled=true
document.forms[0].NAME.disabled=false;
document.forms[0].RELATIONSHIP.disabled=false;
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
if(document.getElementById("m_postal_code")!=null)
document.forms[0].m_postal_code.disabled=false
document.forms[0].COUNTRY_DESC.disabled=false
document.forms[0].TELEPHONE_OFF.disabled=false
document.forms[0].TELEPHONE_RES.disabled=false
document.forms[0].MOB_TEL_NO.disabled=false
document.forms[0].NAT_ID_NO.disabled=false
document.forms[0].EMAIL_ID.disabled=false
document.forms[0].NAME.value="";
document.forms[0].RELATIONSHIP.options[0].selected=true;
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
if(document.getElementById("m_postal_code")!=null)
document.forms[0].m_postal_code.value=""
document.forms[0].COUNTRY_DESC.value=""
document.forms[0].TELEPHONE_OFF.value=""
document.forms[0].TELEPHONE_RES.value=""
document.forms[0].MOB_TEL_NO.value=""
document.forms[0].NAT_ID_NO.value=""
document.forms[0].EMAIL_ID.value=""
document.forms[0].copydet.disabled=false;
document.forms[0].NAT_ID_NO.readOnly=false;
document.forms[0].EMAIL_ID.readOnly=false
//document.getElementById("pstsrh").disabled=false;
document.getElementById("postal_code").disabled=false;
document.getElementById("cntrysrh").disabled=false;

}else if(obj.value=='E'||obj.value=='F')//changes for 38265
{
//document.getElementById("twnsrch").disabled=false;
//document.getElementById("areasrch").disabled=false;
//document.getElementById("rgnsrh").disabled=false;

document.getElementById("town_code").disabled=false;
document.getElementById("area_code").disabled=false;
document.getElementById("region_code").disabled=false;

//if(document.getElementById("area")!=null)
//document.forms[0].area.value=""

if(document.getElementById("m_area_code")!=null)
	document.forms[0].m_area_code.value=""


//if(document.getElementById("town")!=null)
//document.forms[0].town.value=""

if(document.getElementById("m_town_code")!=null)
	document.forms[0].m_town_code.value=""


//if(document.getElementById("region")!=null)
//document.forms[0].region.value=""

if(document.getElementById("m_region_code")!=null)
	document.forms[0].m_region_code.value=""


//if(document.getElementById("area")!=null)
//document.forms[0].area.disabled=false

if(document.getElementById("m_area_code")!=null)
	document.forms[0].m_area_code.disabled=false


//if(document.getElementById("town")!=null)
//document.forms[0].town.disabled=false


if(document.getElementById("m_town_code")!=null)
	document.forms[0].m_town_code.disabled=false


//if(document.getElementById("region")!=null)
//document.forms[0].region.disabled=false

if(document.getElementById("m_region_code")!=null)
	document.forms[0].m_region_code.disabled=false


document.getElementById("id3").style.visibility='hidden';
document.forms[0].CLAIMANT_TYPE_CODE.disabled=true
document.forms[0].NAME.disabled=false;
document.forms[0].RELATIONSHIP.disabled=false;
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
if(document.getElementById("m_postal_code")!=null)
document.forms[0].m_postal_code.disabled=false
document.forms[0].COUNTRY_DESC.disabled=false
document.forms[0].TELEPHONE_OFF.disabled=false
document.forms[0].TELEPHONE_RES.disabled=false

document.forms[0].JOB_TITLE.disabled=false;
document.forms[0].MOB_TEL_NO.disabled=false
document.forms[0].NAT_ID_NO.readOnly=false;
document.forms[0].EMAIL_ID.readOnly=false


document.forms[0].NAME.value="";
document.forms[0].RELATIONSHIP.options[0].selected=true;
document.forms[0].copydet.disabled=false;
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
if(document.getElementById("m_postal_code")!=null)
document.forms[0].m_postal_code.value=""
document.forms[0].COUNTRY_DESC.value=""
document.forms[0].TELEPHONE_OFF.value=""
document.forms[0].TELEPHONE_RES.value=""
document.forms[0].MOB_TEL_NO.value=""
document.forms[0].NAT_ID_NO.value=""
document.forms[0].EMAIL_ID.value=""
//document.getElementById("pstsrh").disabled=false;
document.getElementById("postal_code").disabled=false;
document.getElementById("cntrysrh").disabled=false;
}else
{

//document.getElementById("twnsrch").disabled=false;
//document.getElementById("areasrch").disabled=false;
//document.getElementById("rgnsrh").disabled=false;
	
document.getElementById("town_code").disabled=false;
document.getElementById("area_code").disabled=false;
document.getElementById("region_code").disabled=false;


//if(document.getElementById("area")!=null)
//document.forms[0].area.value=""

if(document.getElementById("m_area_code")!=null)
	document.forms[0].m_area_code.value=""

//if(document.getElementById("town")!=null)
//document.forms[0].town.value=""

if(document.getElementById("m_town_code")!=null)
	document.forms[0].m_town_code.value=""

//if(document.getElementById("region")!=null)
//document.forms[0].region.value=""

if(document.getElementById("m_region_code")!=null)
	document.forms[0].m_region_code.value=""


//if(document.getElementById("area")!=null)
//document.forms[0].area.disabled=false

if(document.getElementById("m_area_code")!=null)
	document.forms[0].m_area_code.disabled=false


//if(document.getElementById("town")!=null)
//document.forms[0].town.disabled=false

if(document.getElementById("m_town_code")!=null)
	document.forms[0].m_town_code.disabled=false


//if(document.getElementById("region")!=null)
//document.forms[0].region.disabled=false

if(document.getElementById("m_region_code")!=null)
	document.forms[0].m_region_code.disabled=false


	
document.getElementById("id3").style.visibility='visible';
document.forms[0].CLAIMANT_TYPE_CODE.disabled=false
document.forms[0].NAME.disabled=false;
document.forms[0].RELATIONSHIP.disabled=false;
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
if(document.getElementById("m_postal_code")!=null)
document.forms[0].m_postal_code.disabled=false
document.forms[0].COUNTRY_DESC.disabled=false
document.forms[0].TELEPHONE_OFF.disabled=false
document.forms[0].TELEPHONE_RES.disabled=false;
document.forms[0].JOB_TITLE.disabled=false;
document.forms[0].MOB_TEL_NO.disabled=false
document.forms[0].NAT_ID_NO.disabled=false;
document.forms[0].EMAIL_ID.disabled=false
document.forms[0].NAME.value="";
document.forms[0].RELATIONSHIP.options[0].selected=true;
document.forms[0].copydet.disabled=true;
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
if(document.getElementById("m_postal_code")!=null)
document.forms[0].m_postal_code.value=""
document.forms[0].COUNTRY_DESC.value=""
document.forms[0].TELEPHONE_OFF.value=""
document.forms[0].TELEPHONE_RES.value=""
document.forms[0].MOB_TEL_NO.value=""
document.forms[0].NAT_ID_NO.value=""
document.forms[0].EMAIL_ID.value=""
//document.getElementById("pstsrh").disabled=false;
document.getElementById("postal_code").disabled=false;
document.getElementById("cntrysrh").disabled=false;
}
//Below Condition // Added Against Bru-HIMS-CRF-366 [IN-039612] By Saanthaakumarg
if(obj.value=='F')
{
document.getElementById("releasefacid").style.visibility="visible"
document.getElementById("releasefacdesc").style.visibility="visible"
document.getElementById("remarksid").style.visibility="visible"
document.getElementById("remarksdesc").style.visibility="visible"

}

else
{
document.getElementById("releasefacid").style.visibility="hidden"
document.getElementById("releasefacdesc").style.visibility="hidden"

document.getElementById("remarksid").style.visibility="hidden"
document.getElementById("remarksdesc").style.visibility="hidden"

}
//Condition End


var selclaim = obj.value ;
HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMO/jsp/GetClaim.jsp?criteria=populateClaim'><input type='hidden' name='selclaim' id='selclaim' value='"+selclaim+"'><input type='hidden' name='cliamcode' id='cliamcode' value='"+claimcode+"'><input type='hidden' name='cmgfrmbdypart' id='cmgfrmbdypart' value='cmgfrmreleasedeas'></form></body></html>";
//parent.dummyFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
parent.dummyFrame.document.write(HTMLVal);
parent.dummyFrame.document.dum_form.submit();
}

function getClaimant1(claimant,claimcode)
{

	document.forms[0].burial_issued.focus();

if(claimant!="")
{document.getElementById("id3").style.visibility='visible'; 
document.forms[0].CLAIMANT_TYPE_CODE.disabled=false

if(claimant=='K')
{
document.getElementById("id3").style.visibility='hidden';
document.forms[0].CLAIMANT_TYPE_CODE.disabled=true
document.forms[0].NAME.disabled=false;
document.forms[0].RELATIONSHIP.disabled=false;
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
if(document.getElementById("m_postal_code")!=null)
document.forms[0].m_postal_code.disabled=false
document.forms[0].COUNTRY_DESC.disabled=false
document.forms[0].TELEPHONE_OFF.disabled=false
document.forms[0].TELEPHONE_RES.disabled=false
document.forms[0].MOB_TEL_NO.disabled=false
document.forms[0].NAT_ID_NO.disabled=false
document.forms[0].EMAIL_ID.disabled=false
document.forms[0].copydet.disabled=false;
document.forms[0].NAT_ID_NO.readOnly=false;
document.forms[0].EMAIL_ID.readOnly=false
document.forms[0].PATIENT_EMPLOYEE_ID.disabled=false
//document.getElementById("pstsrh").disabled=false;
document.getElementById("postal_code").disabled=false;
document.getElementById("cntrysrh").disabled=false;

}else if(claimant=='E'||claimant=='F')//changes for 38265
{
document.getElementById("id3").style.visibility='hidden';
document.forms[0].CLAIMANT_TYPE_CODE.disabled=true
document.forms[0].NAME.disabled=false;
document.forms[0].RELATIONSHIP.disabled=false;
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
if(document.getElementById("m_postal_code")!=null)
document.forms[0].m_postal_code.disabled=false
document.forms[0].COUNTRY_DESC.disabled=false
document.forms[0].TELEPHONE_OFF.disabled=false
document.forms[0].TELEPHONE_RES.disabled=false
//document.getElementById("pstsrh").disabled=false;
document.getElementById("postal_code").disabled=false;
document.getElementById("cntrysrh").disabled=false;

document.forms[0].JOB_TITLE.disabled=false;
document.forms[0].MOB_TEL_NO.disabled=false
document.forms[0].NAT_ID_NO.disabled=false;
document.forms[0].EMAIL_ID.disabled=false



}else
{document.getElementById("id3").style.visibility='visible';
document.forms[0].CLAIMANT_TYPE_CODE.disabled=false
document.forms[0].NAME.disabled=false;
document.forms[0].RELATIONSHIP.disabled=false;
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
if(document.getElementById("m_postal_code")!=null)
document.forms[0].m_postal_code.disabled=false
document.forms[0].COUNTRY_DESC.disabled=false
document.forms[0].TELEPHONE_OFF.disabled=false
document.forms[0].TELEPHONE_RES.disabled=false
document.forms[0].JOB_TITLE.disabled=false;
document.forms[0].MOB_TEL_NO.disabled=false
document.forms[0].NAT_ID_NO.disabled=false;
document.forms[0].EMAIL_ID.disabled=false
//document.getElementById("pstsrh").disabled=false;
document.getElementById("postal_code").disabled=false;
document.getElementById("cntrysrh").disabled=false;

}



HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMO/jsp/GetClaim.jsp?criteria=populateClaim'><input type='hidden' name='selclaim' id='selclaim' value='"+claimant+"'><input type='hidden' name='cliamcode' id='cliamcode' value='"+claimcode+"'><input type='hidden' name='cmgfrmbdypart' id='cmgfrmbdypart' value='cmgfrmreleasedeas'></form></body></html>";
parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
parent.frames[2].document.dum_form.submit();



}else
{
//document.getElementById("pstsrh").disabled=true;
document.getElementById("postal_code").disabled=true;
document.getElementById("cntrysrh").disabled=true;
document.forms[0].NAME.disabled=true;
document.forms[0].RELATIONSHIP.disabled=true;
document.forms[0].PATIENT_EMPLOYEE_ID.disabled=true
document.forms[0].ORGANIZATION_NAME.disabled=true
document.forms[0].JOB_TITLE.disabled=true
if(document.forms[0].addr_line_1!=null)
document.forms[0].addr_line_1.disabled=true
if(document.forms[0].addr_line_2!=null)
document.forms[0].addr_line_2.disabled=true
if(document.forms[0].addr_line_3!=null)
document.forms[0].addr_line_3.disabled=true
if(document.forms[0].addr_line_4!=null)
document.forms[0].addr_line_4.disabled=true
if(document.forms[0].m_postal_code!=null)
document.forms[0].m_postal_code.disabled=true
document.forms[0].COUNTRY_DESC.disabled=true
document.forms[0].TELEPHONE_OFF.disabled=true
document.forms[0].TELEPHONE_RES.disabled=true
document.forms[0].MOB_TEL_NO.disabled=true
document.forms[0].NAT_ID_NO.disabled=true
document.forms[0].EMAIL_ID.disabled=true


}

}

 
 function cmpdate(obj)
  {

    var from = document.forms[0].byrecddate.value;
	var spl=from.split(" ");
    var fromdate = spl[0];
    var todate = obj.value;
	var todate1=todate.split(" ");
	todate = todate1[0];
	 if(fromdate.length > 0 && todate.length > 0 ) {

            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) < Date.parse(fromdt)) {
			alert(getMessage('DATE_CANT_BE_LT_RECEIPT'));
			obj.focus();
			}
  }
  }


  function AEScrollIntoView(tabidx)
{


	if(tabidx == 1)
    {
		document.getElementById("tab1").scrollIntoView();
		document.forms[0].burial_issued.focus();	 
    }
	
	else if(tabidx == 3)
	{  
         
	   document.getElementById("tab2").scrollIntoView();
	   document.forms[0].CLAIMANT_TYPE.focus();	 
	
	}
	
			
}
  
  function chkman(obj)
{
	var namey;
	namey =obj.value;
	
	
	if(namey!='')
	{
	parent.result.location.href='../../eCommon/html/blank.html'
	HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form4' id='dum_form4' method='post' action='../../eMO/jsp/GetClaim.jsp?criteria=fromdcsd'><input type='hidden' name='patient_id' id='patient_id' value='"+namey+"'></form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.dum_form4.submit();
	}
}

 function beforeGetPractitioner(obj,target_name)
{
	target_name.value = trimString(target_name.value);
	
	if (target_name.name=='bodrelbydesc')
	{
		if(target_name.value == "")
			{
			 document.forms[0].bodrelbydesc.value="";
			 document.forms[0].bodrelby.value="";
			 return;
			}
	}

searchCode2(obj,target_name)
}
 
function searchCode2(obj,target)
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

	sql="select a.practitioner_id practitioner_id, a.practitioner_name practitioner_name, a.pract_type_desc practitioner_type, a.position_code job_title, a.gender gender, a.primary_speciality_desc primary_specialty from am_practitioner_lang_vw  a where  a.language_id = '"+localeName+"' and upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) or upper(a.practitioner_name) like upper(nvl(?,a.practitioner_name))) and upper(a.gender) like upper(nvl(?,a.gender)) and upper(nvl(a.position_code,'123')) like upper(nvl(?,nvl(a.position_code,'123'))) order by 2";

	//sqlSecond="select practitioner_id, practitioner_name, pract_type_desc practitioner_type, decode(job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',job_title) job_title, gender, primary_splty_short_desc primary_specialty from am_practitioner_vw where upper(pract_type) like upper(nvl(?,pract_type)) and upper(primary_speciality_code) like upper(nvl(?,primary_speciality_code)) and upper(practitioner_id) like upper(nvl(?,practitioner_id)) and upper(practitioner_name) like upper(nvl(?,practitioner_name)) and decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(job_title,'123')) like upper(nvl(?,nvl(job_title,'123'))) order by 2 ";

	sqlSecond = "select a.practitioner_id practitioner_id, a.practitioner_name practitioner_name, a.pract_type_desc practitioner_type, a.position_code job_title, a.gender gender, a.primary_speciality_desc primary_specialty from am_practitioner_lang_vw a where  a.language_id = '"+localeName+"' and upper(a.pract_type) like upper(nvl(?,a.pract_type)) and upper(a.primary_speciality_code) like upper(nvl(?,a.primary_speciality_code)) and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) and upper(a.practitioner_name) like upper(nvl(?,a.practitioner_name))) and upper(a.gender) like upper(nvl(?,a.gender)) and upper(nvl(a.position_code,'123')) like upper(nvl(?,nvl(a.position_code,'123'))) order by 2 ";
				
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
	eval(responseText);
				
	return;            
	
	var retVal=CommonLookup(tit,argumentArray);

	if(retVal==null || retVal=="")
		target.value="";
	else
		target.value=retVal[0];
		            
}
function PractLookupRetVal(retVal,objName)
{
	var arr;
	
	if (retVal != null && retVal != ""  && retVal != 'undefined')
	{
		arr=retVal.split("~");
     
		
		if(objName=="bodrelbydesc")
		{
		   document.forms[0].bodrelby.value=arr[0];
		   document.forms[0].bodrelbydesc.value=arr[1];
		}
	}
	
	
}

 function searchCode(obj,target)
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
			facilityId = document.forms[0].facilityId.value;
            parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
			
			if(obj.name=="patient_search")
			{
				tit = getLabel("eMO.DeceasedPatients.label","MO");
				//sql="select REGISTRATION_NO code, patient_name Description from mo_mortuary_regn_vw where  facility_id='"+facilityId+"' and RELEASE_BODY_DATE IS NULL and Area_Type='R' and upper(REGISTRATION_NO) like upper(?) and upper(patient_name) like upper(?) and BURIAL_PERMIT_NO is not null order by 2";

				sql="select REGISTRATION_NO code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name))  Description from mo_mortuary_regn_vw where  facility_id='"+facilityId+"' and RELEASE_BODY_DATE IS NULL and Area_Type='R' and upper(REGISTRATION_NO) like upper(?) and upper(patient_name) like upper(?) and BURIAL_PERMIT_NO is not null order by 2";
				
			}
			else
			{
				tit =  getLabel("eMO.DeceasedPatients.label","MO");
				//sql="select REGISTRATION_NO code, patient_name Description from mo_mortuary_regn_vw where  facility_id='"+facilityId+"' and RELEASE_BODY_DATE IS NULL and Area_Type='R' and upper(REGISTRATION_NO) like upper(?) and upper(patient_name) like upper(?) BURIAL_PERMIT_NO is not null order by 2";

				sql="select REGISTRATION_NO code, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name))  Description from mo_mortuary_regn_vw where  facility_id='"+facilityId+"' and RELEASE_BODY_DATE IS NULL and Area_Type='R' and upper(REGISTRATION_NO) like upper(?) and upper(patient_name) like upper(?) BURIAL_PERMIT_NO is not null order by 2";
			
			}
				argumentArray[0] =sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;
				retVal = await CommonLookup( tit, argumentArray );
	
		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			var arr=ret1.split(",");
			if(target.name == 'patient_id')
				document.forms[0].patient_id.value= arr[0];
				parent.result.location.href = '../../eMO/jsp/MOReleaseDeceasedSearch.jsp?param='+arr[0]+'&first=N';
				
		}
		else
		{	
			document.forms[0].patient_id.value= "";
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
			//if(!doDateTimeChk(obj))
			if(!validDateObj(obj,"DMYHM",localeName))
			{
				//alert(getMessage("INVALID_DATE_TIME"))
				obj.select();
				return false;
			}
			else
			{
				var greg_burial_datetime = convertDate(obj.value,"DMYHM",localeName,"en");	
				var greg_bodyreceipt_datetime = convertDate(document.forms[0].byrecddate.value,"DMYHM",localeName,"en");			parent.dummyFrame.location.href='../../eMO/jsp/ValidateSysdate.jsp?objname='+obj.name+"&bodypart=deceasedregn1"+"&objValue="+escape(greg_burial_datetime);
				if(isBefore(greg_burial_datetime,greg_bodyreceipt_datetime,"DMYHM","en"))
				{
						alert(getMessage("DATE_CANT_BE_LT_RECEIPT","MO"));
						obj.select();
				}
					/*	 if((!ValidateDateTime(obj,document.forms[0].sydate)))
					{
						alert(getMessage("START_DATE_GREATER_SYSDATE"))
						obj.select();
					}*/
				
			/*
			  if(obj.name == 'burial_dtime')
				{
               
					parent.dummyFrame.location.href='../../eMO/jsp/ValidateSysdate.jsp?objname='+obj.name+"&bodypart=deceasedregn1"+"&objValue="+escape(obj.value);
					if((!ValidateDateTime(document.forms[0].byrecddate,obj)))
					{
							alert(getMessage("DATE_CANT_BE_LT_RECEIPT"));
							obj.select();
					}
					
				}
				else
				{
					 parent.dummyFrame.location.href='../../eMO/jsp/ValidateSysdate.jsp?objname='+obj.name+"&bodypart=deceasedregn1"+"&objValue="+escape(greg_burial_datetime);   
				
					if((!ValidateDateTime(document.forms[0].byrecddate,obj)))
					{
							alert(getMessage("DATE_CANT_BE_LT_RECEIPT"))
							obj.select();
					}
				}	
				*/
			}

		}
	}
function reset()
{  
frames(1).document.location.reload();
frames(2).document.location.reload();
var callfrom = f_query_add_mod.document.forms[0].callfrommoreg.value
f_query_add_mod.location.href='../../eMO/jsp/MORegnDtlsQueryCriteria.jsp?callfrom='+callfrom+'';
result.location.href='../../eCommon/html/blank.html'
//messageFrame.location.href='../../eCommon/html/blank.html';
}
var test=parent.name;
function onSuccess()
{
	//alert('Operation Completed Successfully...');
	var errors = getMessage('RECORD_MODIFIED','SM') ;
	//alert(getMessage(RECORD_MODIFIED));
	//alert('coming here');
	alert(errors);
	top.window.returnValue="";
	//alert(window.returnValue)
	
	top.window.close();
	
	//alert(parent.name)
	//parent.frams(3).location.reload();
	//result.location.reload();
	//top.window.returnValue = "";
	//top.window.close();
	//f_query_add_mod.document.location.href='../../eMO/jsp/MOReleaseDeceasedCriteria.jsp';
	//result.location.href='../../eCommon/html/blank.html'
}

function recordRelDec()
{
/*if( f_query_add_mod.document.forms[0].patient_id.value=="")
	{
	mess="APP-SM0001 Registration No cannot be blank..."
	
	messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+mess ;
	return false;
	
	}*/
		
	
	
	
	if(document.forms[0].exp_Req.checked == true)
	{
		document.forms[0].expyn.value="Y";
	}
	else
	{
	    document.forms[0].expyn.value="N";
	}

	if(document.forms[0].unclaimed_body_yn.checked == true)
	{
		document.forms[0].unclaimed_body_yn.value="Y";
	}
	else
	{
	    document.forms[0].unclaimed_body_yn.value="N";
	}

	var fields = new Array();	
	fields[0] = document.forms[0].patient_id;
	fields[1] = document.forms[0].bodrelby;
	fields[2] = document.forms[0].bodreldate;	
	//fields[3] = document.forms[0].CLAIMANT_TYPE;	//Commented Aginst PAS-INC-MO -> Release Deceased/Body Part [IN:043269] By Saanthaakumar
	
// Below Condition Modified Aginst PAS-INC-MO -> Release Deceased/Body Part [IN:043269] By Saanthaakumar
 if(document.forms[0].burial_issued.checked)
	{fields[4] = document.forms[0].burial_dtime;	
	var names = new Array (getLabel("Common.patientId.label","Common"),getLabel("eMO.ReleasedBy.label","mo"),getLabel("Common.BodyReleaseDateTime.label","common"),getLabel("eMO.BurialPermitIssueDateTime.label","mo"));
	}else
	{
	var names = new Array (getLabel("Common.patientId.label","Common"),getLabel("eMO.ReleasedBy.label","mo"),getLabel("Common.BodyReleaseDateTime.label","common"));
	}
	var CLAIMANT_TYPE = document.forms[0].CLAIMANT_TYPE.value;
	
	if((CLAIMANT_TYPE!="")&& (document.getElementById("id3").style.visibility=='visible')){
	  fields[3] = document.forms[0].CLAIMANT_TYPE_CODE;
	  names.push(getLabel("eMO.Claimant.label","mo"));
	}else{
	      document.forms[0].submit();
	}
// 43269 Over Here.	
	
	if(checkFields( fields, names,parent.msgFrame))
	{document.forms[0].burial_dtime.disabled=false;
		
		document.forms[0].submit();
	}
	
}

function CloseRelDec()
{
	parent.window.returnValue = "";
	parent.window.close();
}

function changeCase(obj)
{
	  obj.value=obj.value.toUpperCase();
}
    
function assignval(obj)
{
	
	if(obj.checked == true)
	{
		document.forms[0].burial_issued.value="Y";
		document.forms[0].burial_issued_yn.value="Y";
	   document.getElementById("burman").style.visibility="visible";
	  document.forms[0].burial_dtime.disabled=false;
	  document.getElementById("burcal").disabled=false;
	   
	}
	else
	{
		document.forms[0].burial_issued.value="N";
		document.forms[0].burial_issued_yn.value="N";
		document.getElementById("burman").style.visibility="hidden";
	    document.forms[0].burial_dtime.disabled=true;
		document.getElementById("burcal").disabled=true;
		document.forms[0].burial_dtime.value="";

	}



}




