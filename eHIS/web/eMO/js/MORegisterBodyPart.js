function CheckForSpecCharsLocal(event){
var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*/';
var whichCode = (window.Event) ? event.which : event.keyCode;
key = String.fromCharCode(whichCode);  // Get key value from key code
if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
return true ;
}
async function viewpostmortemdet()
{
var select_registration=document.forms[0].regn_no.value;
var patient_id=document.forms[0].patientid.value;
var dialogHeight	=	"100"; 		// BRU-HIMS-CRF-270
var dialogWidth		=	"60"; 
var dialogTop		=	"200";
var status			=	"no";
var arguments		=	"" ;
retVal				=	"startpm";
var action_url		=	"../../eMO/jsp/MOPostmortemMangementFrameset.jsp?patient_id="+patient_id+"&select_registration="+select_registration+"&viewdata=viewdata";
var features		=	"dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; status:no; scroll:no; dialogTop:"+dialogTop+";";
retVal				=	await window.showModalDialog(action_url,arguments,features);	
}

function checkForMaxLimit(obj)
{
  		 var errors='';
		 var lab = obj.name;
		 var max = '500';
	     if(obj.value.length > max) {
			 errors = errors + getMessage("REMARKS_CANNOT_EXCEED","Common"); 
			 errors = errors.replace('$',getLabel("Common.remarks.label","Common"));
			 errors = errors.replace('#',max);
			 errors = errors + "\n" ;
			 alert(errors) ;
			 return false;
			 obj.focus();
	     } else return true;
}


function removeBodyPart()  {  var j=0; var from = document.getElementById('addbodypart'); if ( from.options.length > 0 ){ var to = document.getElementById('selectbodypart');var element = document.createElement('OPTION'); element.text = from.options[from.selectedIndex].text; element.value = from.options[from.selectedIndex].value; to.add(element);    from.remove(from.selectedIndex); if(from.options[j]) from.options[j].selected=true; j++;   } } 


function addBodyPart()    {       var i=0; var from = document.getElementById('selectbodypart');
if( from.options.length > 0 ) { var to = document.getElementById('addbodypart'); var element = document.createElement('OPTION'); element.text = from.options[from.selectedIndex].text; element.value= from.options[from.selectedIndex].value; to.add(element);          from.remove(from.selectedIndex); if(from.options[i])  from.options[i].selected=true ; i++; } }

function validatePatient(obj)
{
	//var functionid=parent.document.forms[0].function_id.value;

//alert(parent.document.forms[0].function_id.value);
mode=document.forms[0].mode.value;
obt_frm=document.forms[0].obt_from.value;

if(obj.value!="")
	{
if(mode=="modify"||mode=="viewdata")
 {
 
 //Added for this CRF ML-MMOH-CRF-0695
var function_id1="Reg_Details";
//End this ML-MMOH-CRF-0695
 
parent.frames[3].document.location.href = '../../eMO/jsp/MORegisterBodyPartResult.jsp?function_id=MO_BODY_PART_REGN&patientid='+obj.value+'&obt_from='+obt_frm+'&registration_no='+document.forms[0].registration_no.value+"&mode="+mode+"&function_id1="+function_id1 
parent.frames[2].location.href = "../../eCommon/jsp/pline.jsp?Patient_ID="+obj.value ;  	

 }else
{
document.forms[0].patbtn.disabled=true;
document.forms[0].patientid.disabled=true;

parent.frames[3].location.href = "../../eMO/jsp/MORegisterAttnValidations.jsp?function_id=MO_BODY_PART_REGN&patient_id="+obj.value+"&objName=bodyprt"+"&obtainedfrom="+obt_frm;

}

	}
}

function disableGif()
{

if(parent.frames[1].document.forms[0].obt_from.value=="A")
{
document.getElementById("bdbr1").style.visibility="visible";
/*Below line added for this CRF ML-MMOH-CRF-0695*/
if(document.getElementById("bdbr2")) document.getElementById("bdbr2").style.visibility="visible";

if(document.getElementById("bdbr3")){
	document.getElementById("bdbr3").style.visibility="visible"
}
document.getElementById("bdbr4").style.visibility="visible"
}else if(parent.frames[1].document.forms[0].obt_from.value=="D")
{
document.getElementById("bdbr1").style.visibility="hidden";

/*Below line added for this CRF ML-MMOH-CRF-0695*/
if(document.getElementById("bdbr2")) document.getElementById("bdbr2").style.visibility="hidden";


if(document.getElementById("bdbr3")){
document.getElementById("bdbr3").style.visibility="hidden"
}
document.getElementById("bdbr4").style.visibility="hidden"

}else if(parent.frames[1].document.forms[0].obt_from.value=="U")
	{
	document.getElementById("bdbr1").style.visibility="visible";
	/*Below line added for this CRF ML-MMOH-CRF-0695*/
		if(document.getElementById("datetimeofclaimingApplicable") && document.getElementById("datetimeofclaimingApplicable").value=="true"){		
		     if(document.getElementById("bdbr2")) document.getElementById("bdbr2").style.visibility='hidden';
		}else{
		     if(document.getElementById("bdbr2")) document.getElementById("bdbr2").style.visibility="visible";
		}
		//End this CRF ML-MMOH-CRF-0695
	


if(document.getElementById("bdbr3")){
	document.getElementById("bdbr3").style.visibility="visible"
}
document.getElementById("bdbr4").style.visibility="visible"
	}

if (document.getElementById("postmortem_reqd_yn").checked==true)
	{
//	  document.getElementById("bed_no").value="";
      document.getElementById("bed_no").disabled=true;
	  document.getElementById("bed_button").disabled=true;
	  document.getElementById("dis1").style.visibility="hidden"
	  document.getElementById("dis2").style.visibility="hidden"
	  document.getElementById("dis3").style.visibility="hidden"
	  
	//Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696
	if(document.getElementById("rearrangeTabBurlPermtClaimnt") && document.getElementById("rearrangeTabBurlPermtClaimnt").value=="true"){
	document.getElementById("clmantDis").style.display = 'none';
	var tit=getLabel("eMO.Claimant.label","MO");
	document.getElementById("bp1").title=getLabel("eMO.Claimant.label","MO");
	document.getElementById("bp1").innerHTML="<a onclick=javascript:tab_click1('claimant_tab') id='claimant_tab' class='tabA'><span class='tabAspan' id='claimant_tabspan'>"+tit+"</span></a>";
	}else{
	  document.getElementById("bp1").style.visibility="hidden"
	}
	
	//Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696
	if(document.getElementById("rearrangeTabBurlPermtClaimnt") && document.getElementById("rearrangeTabBurlPermtClaimnt").value=="true"){
	document.getElementById("clmantDis2").style.display = 'none';
	var tit=getLabel("eMO.Claimant.label","MO");
	document.getElementById("bp2").title=getLabel("eMO.Claimant.label","MO");
	document.getElementById("bp2").innerHTML="<a onclick=javascript:tab_click1('claimant_tab') id='claimant_tab' class='tabClicked'><span class='tabSpanclicked' id='claimant_tabspan'>"+tit+"</span></a>";
	}else{
	  document.getElementById("bp2").style.visibility="hidden"
	}

	  document.getElementById("bp3").style.visibility="hidden"
	
	}else
	{
	//  document.getElementById("bed_no").value="";
	  document.getElementById("bed_no").disabled=true;
	  document.getElementById("bed_button").disabled=true;
	  
	  document.getElementById("tab1").style.visibility="visible"
	  document.getElementById("tab2").style.visibility="visible"
	  document.getElementById("tab3").style.visibility="visible"
	 
	//Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696	    
	if(document.getElementById("rearrangeTabBurlPermtClaimnt") && document.getElementById("rearrangeTabBurlPermtClaimnt").value=="true"){	
		document.getElementById("clmantDis").style.display = 'block';					
		var tit1=getLabel("eMO.BurialPermit.label","MO");
		document.getElementById("bp1").title=getLabel("eMO.BurialPermit.label","MO");
		document.getElementById("bp1").innerHTML="<a onclick=javascript:tab_click1('burialPermit_tab') id='burialPermit_tab' class='tabA'> <span class='tabAspan' id='burialPermit_tabspan'>"+tit1+"</a>";					
		var tit=getLabel("eMO.Claimant.label","MO");
		document.getElementById("clmantDis").innerHTML="<a onclick=javascript:tab_click1('claimant_tab') id='claimant_tab' class='tabA'><span class='tabAspan' id='claimant_tabspan'>"+tit+"</span></a>";
	}else{
	    document.getElementById("bp1").style.visibility="visible"
	}

	//Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696
	if(document.getElementById("rearrangeTabBurlPermtClaimnt") && document.getElementById("rearrangeTabBurlPermtClaimnt").value=="true"){
		document.getElementById("clmantDis2").style.display = 'block';					
		var tit1=getLabel("eMO.BurialPermit.label","MO");
		document.getElementById("bp2").title=getLabel("eMO.BurialPermit.label","MO");
		document.getElementById("bp2").innerHTML="<a onclick=javascript:tab_click1('burialPermit_tab') id='burialPermit_tab' class='tabA'> <span class='tabAspan' id='burialPermit_tabspan'>"+tit1+"</a>";					
		var tit=getLabel("eMO.Claimant.label","MO");
		document.getElementById("clmantDis2").innerHTML="<a onclick=javascript:tab_click1('claimant_tab') id='claimant_tab' class='tabClicked'><span class='tabSpanclicked' id='claimant_tabspan'>"+tit+"</span></a>";
	}else{
	  document.getElementById("bp2").style.visibility="visible"
	}
	 
	  document.getElementById("bp3").style.visibility="visible"
	
	}

	if(document.getElementById("mode").value=='viewdata' || document.getElementById("mode").value!="modify")
	{
	if(document.forms[0].town_code)
	  document.forms[0].town_code.disabled=true;
	if(	document.forms[0].area_code)
	  document.forms[0].area_code.disabled=true;
	if(document.forms[0].region_code)
	  document.forms[0].region_code.disabled=true;
	if(document.forms[0].postal_code)
	  document.forms[0].postal_code.disabled=true;
	document.forms[0].CLAIMANT_TYPE_CODE.disabled=true;
	

	}

	
	if(document.getElementById("mode").value=='viewdata')
	{
	document.forms[0].area_type.disabled=true;
	}
}

function selectbodypartobtain(obtainfrom)
{
if(obtainfrom=='A')
{/*document.getElementById('patiddis').style.visibility="visible"*/
document.getElementById('patbtn').style.visibility="visible"
document.forms[0].obt_from.options[1].selected=true;

/*if(document.getElementById("mode").value=="modify"&&document.getElementById("mlc_yn").checked==true)
document.getElementById("Police_Details").disabled=false;
else
document.getElementById("Police_Details").disabled=true;*/

if(document.getElementById("mode").value == "modify" || document.getElementById("mode").value == "viewdata")
{
   document.getElementById("lab1").innerHTML= getLabel("Common.patientId.label","Common"); 



}

}else if(obtainfrom=='D')
{/*document.getElementById('patiddis').style.visibility="visible"*/
document.getElementById('patbtn').style.visibility="visible"

document.forms[0].obt_from.options[2].selected=true;
if(document.getElementById("mode").value == "modify" || document.getElementById("mode").value == "viewdata")
	{
	   document.getElementById("lab1").innerHTML=getLabel("eIP.MotherIDNo.label","IP"); 
	}
}else if(obtainfrom=='U')
{document.getElementById("lab1").innerHTML=getLabel("Common.patientId.label","Common"); 
document.forms[0].obt_from.options[3].selected=true;
}else
{
document.forms[0].obt_from.options[0].selected=true;

}
if(document.getElementById("mode").value == "modify" || document.getElementById("mode").value == "viewdata")
	{
validatePatient(document.getElementById("patientid"))
	}
//fClearClaimantValues();
}

function create()
{
	
	var function_id=document.forms[0].function_id.value;
	

	//bp.rows="47,25,7%,*,20,0,0"
	document.getElementById("commontoolbarFrame").style.height="9vh";
	document.getElementById("criteria").style.height="4vh";
	document.getElementById("criteria").style.height="4vh";
	document.getElementById("patientline").style.height="6vh";
	document.getElementById("f_query_add_mod").style.height="71vh";
	document.getElementById("messageFrame").style.height="9vh";
	//document.getElementById("dummyframe").style.height="0vh";
	//document.getElementById("dummyframe1").style.height="0vh";
	
	

frames[0].document.forms[0].apply.disabled=false;
patientline.location.href='../../eCommon/html/blank.html'
f_query_add_mod.location.href='../../eCommon/html/blank.html'
criteria.location.href='../../eMO/jsp/MORegisterBodyPartCriteria.jsp?function_id='+function_id
}
function query()
{
  //bp.rows="47,0,0,*,20,0,0";
  document.getElementById("commontoolbarFrame").style.height="6vh";
	document.getElementById("criteria").style.height="0vh";
	document.getElementById("criteria").style.height="0vh";
	document.getElementById("patientline").style.height="0vh";
	document.getElementById("f_query_add_mod").style.height="71vh";
	document.getElementById("messageFrame").style.height="6vh";
  	var function_id=document.forms[0].function_id.value;
  f_query_add_mod.location.href="../../eMO/jsp/MORegisterBodyPartFrame.jsp?function_id="+function_id

}


function enterBurial(obj)
{
if(obj.checked)
{
document.forms[0].body_burial_permit_no.value="";
document.forms[0].body_burial_permit_no.readOnly=true;
}else
{

document.forms[0].body_burial_permit_no.readOnly=false;

}

}

function ClearClaimantValues()
{

//if it is an unclaimed body this removes next of kin and employer else it adds all..

if(document.getElementById("obt_from").value=='U')
{
claimselect=document.getElementById("CLAIMANT_TYPE").value
var len=document.getElementById("CLAIMANT_TYPE").length

for (i=0;i<=len;i++ )
{
document.getElementById("CLAIMANT_TYPE").remove(0);
}
var opt=document.createElement('OPTION');
opt.text='----------' +getLabel("Common.defaultSelect.label","Common")+ '----------';
opt.value=""
document.getElementById("CLAIMANT_TYPE").add(opt);

/*Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
var xmlDoc = new ActiveXObject("Microsoft.XMLDom")
var xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")
xmlStr = "<root><SEARCH function_id=\"UNIDENT_BODY_PART\" action='getClaimantType' /></root>"
xmlDoc.loadXML(xmlStr)
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
opt.text=getLabel("eMO.EmbassyCountry.label","MO");  
opt.value="M"
document.getElementById("CLAIMANT_TYPE").add(opt);

var opt=document.createElement('OPTION');
opt.text=getLabel("eMO.WelfareAssociations.label","MO");
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
document.getElementById("CLAIMANT_TYPE").add(opt);*/

/*Modified by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
if(claimselect=="K")
	{
//document.getElementById("CLAIMANT_TYPE").options[1].selected=true;
document.forms[0].copydet.disabled=false;
	}
else
if(claimselect=="E")
{
//document.getElementById("CLAIMANT_TYPE").options[2].selected=true;
document.forms[0].copydet.disabled=false;
}
/*else
if(claimselect=="M")
document.getElementById("CLAIMANT_TYPE").options[1].selected=true;
else if(claimselect=="W")
document.getElementById("CLAIMANT_TYPE").options[2].selected=true;
else if(claimselect=="R")
document.getElementById("CLAIMANT_TYPE").options[3].selected=true;
else if(claimselect=="U")
document.getElementById("CLAIMANT_TYPE").options[4].selected=true;
else if(claimselect=="O")
document.getElementById("CLAIMANT_TYPE").options[5].selected=true;
else 
document.getElementById("CLAIMANT_TYPE").options[0].selected=true;*/




}else
{
if(document.getElementById("unclaimedbodyyn").checked||document.getElementById("obt_from").value=='U')
{


if(document.getElementById("CLAIMANT_TYPE").value=="E"||document.getElementById("CLAIMANT_TYPE").value=="K"||document.getElementById("CLAIMANT_TYPE").value=="F")//changes for 38265
{
document.forms[0].CLAIMANT_TYPE_CODE.options[0].selected=true;
document.forms[0].CLAIMANT_TYPE_CODE.disabled=true;

	/*Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
	if(document.getElementById("CLAIMANT_TYPE").value=="F")
	{
		document.forms[0].copydet.disabled=true;
	}else
	{
		document.forms[0].copydet.disabled=false;
	}
//parent.frames[3].document.forms[0].copydet.disabled=true;
//document.forms[0].postal_search.disabled=true
document.forms[0].contry_code.disabled=true
document.forms[0].NAME.disabled=true;
document.forms[0].NAME.value="";
document.forms[0].RELATIONSHIP.disabled=true;
document.forms[0].RELATIONSHIP.options[0].selected=true;

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
	{
	document.forms[0].PASSPORT_NO.disabled=true
	document.forms[0].PASSPORT_NO.value="";
	document.forms[0].OTHER_IDENTIFICATION.disabled=true
	document.forms[0].OTHER_IDENTIFICATION.value="";
	}

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
if(document.forms[0].m_postal_code1!=null)
{
document.forms[0].m_postal_code1.disabled=true
document.forms[0].m_postal_code1.value=""
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
/*document.getElementById("twnsrch").disabled=true;
document.getElementById("areasrch").disabled=true;
document.getElementById("rgnsrh").disabled=true;*/

if(document.getElementById("region1")!=null)
document.forms[0].region1.value=""

if(document.getElementById("area1")!=null)
document.forms[0].area1.value="";

if(document.getElementById("town1")!=null)
document.forms[0].town1.value=""

if(document.getElementById("m_area_code")!=null)
document.forms[0].m_area_code.value=""

if(document.getElementById("m_town_code")!=null)
document.forms[0].m_town_code.value=""

if(document.getElementById("m_region_code")!=null)
document.forms[0].m_region_code.value=""

if(document.getElementById("m_area_code")!=null)
document.forms[0].m_area_code.disabled=true

if(document.getElementById("m_town_code")!=null)
document.forms[0].m_town_code.disabled=true

if(document.getElementById("m_region_code")!=null)
document.forms[0].m_region_code.disabled=true


}


document.getElementById("unclaimedbodyyn").checked

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
opt.text='----------' +getLabel("Common.defaultSelect.label","Common")+ '----------';
opt.value=""
document.getElementById("CLAIMANT_TYPE").add(opt);

/*Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
var function_id = document.forms[0].function_id.value;

//var xmlDoc = new ActiveXObject("Microsoft.XMLDom")
var xmlDoc = ""; 
//var xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")
var xmlHttp = new XMLHttpRequest();
xmlStr = "<root><SEARCH function_id=\""+function_id+"\" action='getClaimantType' /></root>"
//xmlDoc.loadXML(xmlStr)
xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
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

var opt=document.createElement('OPTION');
opt.text=getLabel("eMO.ReleasedToOtherFacility.label","MO");
opt.value="F"
document.getElementById("CLAIMANT_TYPE").add(opt);//changes for 38265*/

/*Modified by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
if(claimselect=="K")
	{
//document.getElementById("CLAIMANT_TYPE").options[1].selected=true;
document.forms[0].copydet.disabled=false;
	}
else
if(claimselect=="E")
{
//document.getElementById("CLAIMANT_TYPE").options[2].selected=true;
document.forms[0].copydet.disabled=false;
}
/*else
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
document.getElementById("CLAIMANT_TYPE").options[0].selected=true;*/

}

if(document.getElementById("mode").value=='viewdata')
document.getElementById("CLAIMANT_TYPE").disabled=true;
}

}

function changeLegent(obj)
{


if(obj.value=="A")
{document.getElementById("patientid").value=""
document.getElementById("patman").style.visibility="visible"
document.getElementById("patientid").style.visibility="visible"
document.getElementById("patbtn").style.visibility="visible"
document.getElementById("lab1").innerHTML=getLabel("Common.patientId.label","Common"); 
document.getElementById("patbtn").disabled=false;
document.getElementById("patientid").disabled=false;

/*document.getElementById("bdbr1").style.visibility="hidden"
document.getElementById("bdbr2").style.visibility="hidden"
document.getElementById("bdbr3").style.visibility="hidden"
document.getElementById("bdbr4").style.visibility="hidden"*/
//document.getElementById("postmortem_type").disabled=true;
//document.getElementById("unclaimedbodyyn").checked=false;
/*if(document.getElementById("mode").value=="modify"||document.getElementById("mode").value=="viewdata")
{
document.getElementById("patiddis").style.visibility="visible"
//document.getElementById("postmortem_reqd_yn").disabled=true;
if(document.getElementById("mode").value=="viewdata")
document.getElementById("mlc_yn").disabled=true;
}//else
//{
//if(document.getElementById("mode").value!="viewdata")
//document.getElementById("postmortem_reqd_yn").disabled=false;
//document.getElementById("mlc_yn").disabled=false;
//}*/
}else if(obj.value=="D")
{   document.getElementById("patientid").value=""
    document.getElementById("patientid").style.visibility="visible"
	document.getElementById("patbtn").style.visibility="visible"
	document.getElementById("patman").style.visibility="visible"
	document.getElementById("lab1").innerHTML=getLabel("eIP.MotherIDNo.label","IP"); 
    document.getElementById("patbtn").disabled=false;
    document.getElementById("patientid").disabled=false;
	/*document.getElementById("bdbr1").style.visibility="hidden"
     document.getElementById("bdbr2").style.visibility="hidden"
document.getElementById("bdbr3").style.visibility="hidden"
document.getElementById("bdbr4").style.visibility="hidden"*/

	//document.getElementById("postmortem_type").disabled=true;
	//document.getElementById("unclaimedbodyyn").checked=false;

/*if(document.getElementById("mode").value=="modify"||document.getElementById("mode").value=="viewdata")
{   if(document.getElementById("mode").value=="viewdata")
	{
    document.getElementById("postmortem_reqd_yn").disabled=true;
    document.getElementById("mlc_yn").disabled=true;
	}
	 document.getElementById("patidbtn").style.visibility="visible"
    document.getElementById("Police_Details").disabled=true;
}else{if(document.getElementById("mode").value!="viewdata")	
	  document.getElementById("postmortem_reqd_yn").disabled=false;
        document.getElementById("mlc_yn").disabled=false;
}*/
}else if(obj.value=="U")

{   /*Added by Thamizh selvi on 27th July 2017 for ML-MMOH-CRF-0689 Start*/
	var isBodyPartRegnAppl = document.getElementById("isBodyPartRegnAppl").value;
	if(isBodyPartRegnAppl == "true"){
		openEmergRegn();
	}else{/*End*/
		document.getElementById("patientid").value=""
		document.getElementById("patientid").style.visibility="visible"
		document.getElementById("patbtn").style.visibility="visible"
		document.getElementById("patman").style.visibility="visible"
		document.getElementById("lab1").innerHTML=getLabel("Common.patientId.label","Common"); 
		document.getElementById("patbtn").disabled=false;
		document.getElementById("patientid").disabled=false;
	}
/*	document.getElementById("bdbr1").style.visibility="visible"
document.getElementById("bdbr2").style.visibility="visible"
document.getElementById("bdbr3").style.visibility="visible"
document.getElementById("bdbr4").style.visibility="visible"*/

	//document.getElementById("postmortem_type").disabled=true;
	//document.getElementById("unclaimedbodyyn").checked=true;

/*if(document.getElementById("mode").value=="modify"||document.getElementById("mode").value=="viewdata")
{if(document.getElementById("mode").value=="viewdata")
	{
    document.getElementById("postmortem_reqd_yn").disabled=true;
    document.getElementById("mlc_yn").disabled=true;
	}
	 document.getElementById("patidbtn").style.visibility="visible"
    document.getElementById("Police_Details").disabled=true;
}else{if(document.getElementById("mode").value!="viewdata")	
	  document.getElementById("postmortem_reqd_yn").disabled=false;
        document.getElementById("mlc_yn").disabled=false;
}*/
}else
{     document.getElementById("patientid").value=""
      document.getElementById("lab1").innerHTML=""
	//  document.getElementById("patman").style.visibility="hidden"
     // document.getElementById("patiddis").style.visibility="hidden"
	  //document.getElementById("patbtn").style.visibility="hidden"
      document.getElementById("patbtn").disabled=true;
      document.getElementById("patientid").disabled=true;
	 
 	  /*if(document.getElementById("mode").value!="viewdata")
	  document.getElementById("postmortem_reqd_yn").disabled=false;
	  
	  document.getElementById("Police_Details").disabled=true;
      document.getElementById("mlc_yn").disabled=false; */

}

//ClearClaimantValues();
}

// Modified by Shanmukh for ML-MMOH-CRF-1031
function validate1(obj)
{  
var isChangeOfDateTimeClaimingAppl=document.forms[0].isChangeOfDateTimeClaimingAppl.value;
var isReceivedDateTimeAppl=document.forms[0].isReceivedDateTimeAppl.value;
var obj1=document.forms[0].body_received_date_time.value;
obj2   = obj.value;
        if(isChangeOfDateTimeClaimingAppl=="true" && obj.name=="body_claiming_date_time"){
        var err=getMessage("ENTER_BDYRCPT_DTTIME","MO");
		var err1=getLabel("Common.received.label","Common");
		if(isReceivedDateTimeAppl=="true")
			err=err.replace('Receipt',err1);
		else
			err=getMessage("ENTER_BDYRCPT_DTTIME","MO");
		if(obj1=="" && obj.value!="")
        {   alert(err);
			obj.value="";
			obj.focus();
			return false;
        }
		}
       if(obj.value!="")
	   {
	   if(!validDateObj(obj,'DMYHM',localeName))
		{
			 obj.select();
			 return false;
		}else{
			if(obj2!="" && obj1!="" && obj.name=="body_claiming_date_time")
			{
				if(isBefore(obj1,obj2,"DMYHM",localeName)==false)
				{				
					if(isChangeOfDateTimeClaimingAppl=="true"){
						var err=getMessage("DATE1_LT_DATE2",'IP');
						var err1=getLabel("eMO.DateTimeOfClaiming.label","eMO");
						var err2=getLabel("eMO.Body.label","eMO")+" "+getLabel("Common.received.label","Common")+" "+getLabel("Common.Date/Time.label","Common");
						err=err.replace('$',err1);
						err=err.replace('#',err2);
						alert(err);
						obj.value="";
						obj.focus();				
						return false ;
					}
				}
			}
	   }	
		}
	if(obj.value!="")
		{ 
			  var date11 = obj.value; 
			  var date22 = convertDate(date11,"DMYHM",localeName,"en");


			  if(obj.value!='')
				{
					if(isBeforeNow(date22,"DMYHM",localeName))
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
			  //parent.dummyframe.location.href='../../eMO/jsp/ValidateSysdate.jsp?objname='+obj.name+"&bodypart=bodypart"+"&objValue="+escape(date22);
		}
	
}

function reset()
{
		var function_id=document.forms[0].function_id.value;

if(criteria.document.forms[0]!=null)
	{
if(criteria.document.forms[0].mode.value!="modify")
{
/*bp.rows="47,25,4%,*,20,0,0"*/
	if(frames[0].document.forms[0].apply)
frames[0].document.forms[0].apply.disabled=false;
patientline.location.href='../../eCommon/html/blank.html'
f_query_add_mod.location.href='../../eCommon/html/blank.html'
criteria.location.href='../../eMO/jsp/MORegisterBodyPartCriteria.jsp?function_id='+function_id
}else
	{
frames(3).document.location.reload();
	}
	}
}


function closeme_polece()
{
	if(eval(document.getElementById("police_details").value.length)>500 )
	{ 
			alert(getMessage("POLICE_DET_EXCEEDS_LMT","MO")); 
			return false    
	}
	if((document.getElementById("police_received_by").value!=""&&document.getElementById("police_received_date").value==""))
	  {
	  	    
			var error=getMessage('CAN_NOT_BE_BLANK','Common')
			error=error.replace("$",getLabel("eMO.Police61RecvdDt.label","MO"))
			alert(error);
			return false    
	     } if((document.getElementById("police_received_date").value==""&&document.getElementById("police_received_by").value!=""))
	     {
			var error=getMessage('CAN_NOT_BE_BLANK','Common')
			error=error.replace("$",getLabel("eMO.Police61RecvdBy.label","MO"))
			alert(error);
			return false    
	}

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
	
if((pol_rep_no=="")&&(pol_stn_id=="")&&(pol_id=="")&&(police_details==""))
{
	if(document.getElementById("police_approval_received_yn").checked)
	{
	if(police_received_date!="" &&police_received_by!="")
		{
		}else
		{  
			alert(getMessage("POLICE_DET_MAND","MO")); 
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
			alert(getMessage("POLICE_DET_MAND","MO")); 
			return false
		}
	}
	
	}else
	{
			alert(getMessage("POLICE_DET_MAND","MO")); 
			return false
	}

	 

	var closevalue = document.getElementById("pol_rep_no").value+"||"+document.getElementById("pol_stn_id").value+"||"+		document.getElementById("pol_id").value+"||"+document.getElementById("police_details").value+"||"+document.getElementById("police_approval_received_yn").value+"||"+document.getElementById("police_received_by").value+"||"+document.getElementById("police_received_date").value+"||"+document.getElementById("police_received_by_desc").value
	window.returnValue = closevalue;
	
	


	window.close();
	
	
	
	
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
		// document.forms[0].police_received_by.options[0].selected=true;
    	 document.forms[0].police_received_date.disabled=true;
		 document.forms[0].police_received_date.value='';
		document.getElementById("image1").disabled=true;
		document.getElementById("image2").disabled=true;
		document.getElementById("policeapr").style.visibility='hidden'
		document.getElementById("policeapr1").style.visibility='hidden'
		
		}
	}

function getConsentForm()
{
 var dialogHeight = "60vh" ;
 var dialogWidth  = "60vw" ;
 var dialogTop    = "225";
 var dialogLeft   = "225";
 var patient_id = document.forms[0].patient_id.value;
 
 conscentgivenby=document.forms[0].conscentgivenby.value;

 deceasedrelationship=document.forms[0].deceasedrelationship.value;
 consent_received_by=document.forms[0].consent_received_by.value;
 
 consent_received_date=document.forms[0].consent_received_date.value;
 
 var consent_received_desc=document.forms[0].consent_received_desc.value;
// var body_received_date_time = document.forms[0].body_received_date_time.value;
 var sys_date = document.forms[0].system_date.value;
mode=document.forms[0].mode.value;
 var result		  = document.forms[0].consent_form_code.value+"||"+document.forms[0].consent_desc.value;
 var arguments       = result ;
 var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ ";          dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
 retVal	= window.showModalDialog("../../eMO/jsp/ConsentDetailsFrameSet.jsp?patient_id="+patient_id+"&sys_date="+sys_date+"&conscentgivenby="+conscentgivenby+"&deceasedrelationship="+deceasedrelationship+"&consent_received_by="+consent_received_by+"&consent_received_date="+consent_received_date+"&title=Consent For Clinical Post Mortem"+"&consent_received_desc="+consent_received_desc+"&mode="+mode,arguments,features);

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

function closeme()
{


  /* if((document.getElementById("consent_received_desc").value!=""&&document.getElementById("consent_received_date").value==""))
	     {
	  	    
			alert("APP-000001 Consent Received Date/Time cannot be blank...");
		return false    
	     } if((document.getElementById("consent_received_desc").value==""&&document.getElementById("consent_received_date").value!=""))
	{
		alert("APP-000001 Consent Received By cannot be blank...");
		return false    
	    
	
	}*/
consent_code=document.getElementById("consent_code").value
terms_desc=document.getElementById("terms_desc").value
conscentgivenby=document.getElementById("conscentgivenby").value
deceasedrelationship=document.getElementById("deceasedrelationship").value	
consent_received_by=document.getElementById("consent_received_by").value
consent_received_date=document.getElementById("consent_received_date").value
consent_received_desc=document.getElementById("consent_received_desc").value	
/*if((consent_code=="")&&(conscentgivenby=="")&&(deceasedrelationship=="")&&(consent_received_desc=="")&&(consent_received_date==""))
{

}else if((consent_code!="")&&(conscentgivenby!="")&&(deceasedrelationship!="")&&(consent_received_desc!="")&&(consent_received_date!=""))
{

}else 
{
	alert("APP-000001 ALL the Consent details must be captured")
	return false;
}*/



var closevalue = consent_code+"||"+terms_desc+"||"+		conscentgivenby+"||"+deceasedrelationship+"||"+consent_received_by+"||"+consent_received_date+"||"+consent_received_desc;
	window.returnValue = closevalue;
	
	document.getElementById("terms_desc").innerText="";

	window.close();
	

}
function policedetails()
{
 
 var patient_id =document.forms[0].patient_id.value;
 /*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
 var calledFrom			= document.forms[0].calledFrom.value;
 var externalBodyPartYn	= document.getElementById("externalBodyPartYn").value;
 pol_officer_name		= document.getElementById("pol_officer_name").value;
 pol_contact_no			= document.getElementById("pol_contact_no").value;
 /*End*/
 pol_rep_no=document.getElementById("pol_rep_no").value
 pol_stn_id=document.getElementById("pol_stn_id").value
 
 pol_id=document.getElementById("pol_id").value
 
 police_details=document.getElementById("police_details").value
 police_approval_received_yn=document.getElementById("police_approval_received_yn").value
 police_received_by=document.getElementById("police_received_by").value
	 
 police_received_date=document.getElementById("police_received_date").value
 mode=document.getElementById("mode").value;
 /*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
 if(calledFrom == "MO_EBP_REGN" || externalBodyPartYn == "Y"){
	var dialogHeight = "29" ;
	var dialogWidth  = "36" ;
 }else{
	var dialogHeight = "26" ;
	var dialogWidth  = "33" ;
 }/*End*/
 var dialogTop    = "225";
 var dialogLeft   = "225";
 var arguments       = "" ;
 var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ ";          dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
// var body_received_date_time = document.forms[0].body_received_date_time.value;
 var sys_date = document.forms[0].system_date.value;
 var police_approval_received_by_desc=document.forms[0].police_approval_received_by_desc.value;
 
 var police_details= document.forms[0].police_details.value;
 
 
 retVal	= window.showModalDialog("../../eMO/jsp/PoliceDetailsFrameSet.jsp?patient_id="+patient_id+"&sys_date="+sys_date+"&calledFrom="+calledFrom+"&pol_rep_no="+encodeURIComponent(pol_rep_no)+"&pol_stn_id="+encodeURIComponent(pol_stn_id)+"&pol_id="+encodeURIComponent(pol_id)+"&pol_officer_name="+encodeURIComponent(pol_officer_name)+"&pol_contact_no="+encodeURIComponent(pol_contact_no)+"&externalBidBodyPartYn="+externalBodyPartYn+"&police_details="+encodeURIComponent(police_details)+"&police_approval_received_yn="+police_approval_received_yn+"&police_received_by="+police_received_by+"&police_received_date="+police_received_date+"&police_approval_received_by_desc="+encodeURIComponent(police_approval_received_by_desc)+"&mode="+mode,arguments,features);//Modified by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689

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
		document.getElementById("police_approval_received_by_desc").value= finalresults[7]
		/*Added by Thamizh selvi on 3rd Aug 2017 for ML-MMOH-CRF-0689 Start*/
		if(calledFrom == "MO_EBP_REGN" || externalBodyPartYn == "Y"){
			document.getElementById("pol_officer_name").value	= finalresults[8];
			document.getElementById("pol_contact_no").value	= finalresults[9];
		}
 }

 
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
document.forms[0].contry_code.disabled=true
document.forms[0].NAME.disabled=true;
document.forms[0].NAME.value="";
document.forms[0].RELATIONSHIP.disabled=true;
document.forms[0].RELATIONSHIP.options[0].selected=true;

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
	{
	document.forms[0].PASSPORT_NO.disabled=true
	document.forms[0].PASSPORT_NO.value="";
	document.forms[0].OTHER_IDENTIFICATION.disabled=true
	document.forms[0].OTHER_IDENTIFICATION.value="";
	}

document.forms[0].PATIENT_EMPLOYEE_ID.disabled=true
document.forms[0].PATIENT_EMPLOYEE_ID.value="";
document.forms[0].ORGANIZATION_NAME.disabled=true
document.forms[0].ORGANIZATION_NAME.value="";
document.forms[0].JOB_TITLE.disabled=true
document.forms[0].JOB_TITLE.value=""
/*document.getElementById("twnsrch").disabled=true;
document.getElementById("areasrch").disabled=true;
document.getElementById("rgnsrh").disabled=true;*/
if(document.getElementById("m_area_code")!=null)
document.forms[0].m_area_code.value=""

if(document.getElementById("m_town_code")!=null)
document.forms[0].m_town_code.value=""

if(document.getElementById("region1")!=null)
document.forms[0].region1.value=""

if(document.getElementById("area1")!=null)
document.forms[0].area1.value=""

if(document.getElementById("town1")!=null)
document.forms[0].town1.value=""

if(document.getElementById("m_region_code")!=null)
document.forms[0].m_region_code.value=""

if(document.getElementById("m_area_code")!=null)
document.forms[0].m_area_code.disabled=true

if(document.getElementById("m_town_code")!=null)
document.forms[0].m_town_code.disabled=true

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
if(document.forms[0].m_postal_code1!=null)
	{
document.forms[0].m_postal_code1.disabled=true
	document.forms[0].m_postal_code1.value=""
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
document.forms[0].id3.style.visibility='hidden'; //Added Aginst PAS-INC-MO -> Release Deceased/Body Part [IN:043269] By Saanthaakumar
}else
if(obj.value=='K')
{document.getElementById("id3").style.visibility='hidden';
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
if(document.getElementById("m_postal_code1")!=null)
document.forms[0].m_postal_code1.disabled=false
/*document.getElementById("twnsrch").disabled=false;
document.getElementById("areasrch").disabled=false;
document.getElementById("rgnsrh").disabled=false;*/

if(document.getElementById("region1")!=null)
document.forms[0].region1.value=""

if(document.getElementById("area1")!=null)
document.forms[0].area1.value=""

if(document.getElementById("town1")!=null)
document.forms[0].town1.value=""

if(document.getElementById("m_area_code")!=null)
document.forms[0].m_area_code.value=""

if(document.getElementById("m_town_code")!=null)
document.forms[0].m_town_code.value=""

if(document.getElementById("m_region_code")!=null)
document.forms[0].m_region_code.value=""

if(document.getElementById("m_area_code")!=null)
document.forms[0].m_area_code.disabled=false

if(document.getElementById("m_town_code")!=null)
document.forms[0].m_town_code.disabled=false

if(document.getElementById("m_region_code")!=null)
document.forms[0].m_region_code.disabled=false


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
if(document.getElementById("m_postal_code1")!=null)
document.forms[0].m_postal_code1.value=""
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
document.getElementById("cntrysrh").disabled=false;

}else if(obj.value=='E'||obj.value=='F')//changes for 38265
{
/*document.getElementById("twnsrch").disabled=false;
document.getElementById("areasrch").disabled=false;
document.getElementById("rgnsrh").disabled=false;*/
if(document.getElementById("region1")!=null)
document.forms[0].region1.value=""

if(document.getElementById("area1")!=null)
document.forms[0].area1.disabled=false

if(document.getElementById("town1")!=null)
document.forms[0].town1.value=""

if(document.getElementById("m_area_code")!=null)
document.forms[0].m_area_code.value=""

if(document.getElementById("m_town_code")!=null)
document.forms[0].m_town_code.value=""

if(document.getElementById("m_region_code")!=null)
document.forms[0].m_region_code.value=""

if(document.getElementById("m_area_code")!=null)
document.forms[0].m_area_code.disabled=false

if(document.getElementById("m_town_code")!=null)
document.forms[0].m_town_code.disabled=false

if(document.getElementById("m_region_code")!=null)
document.forms[0].m_region_code.disabled=false

document.getElementById("id3").style.visibility='hidden';
document.forms[0].CLAIMANT_TYPE_CODE.disabled=true
document.forms[0].NAME.disabled=false;
document.forms[0].RELATIONSHIP.disabled=true;

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
if(document.getElementById("m_postal_code1")!=null)
document.forms[0].m_postal_code1.disabled=false
document.forms[0].COUNTRY_DESC.disabled=false
document.forms[0].TELEPHONE_OFF.disabled=false
document.forms[0].TELEPHONE_RES.disabled=false

document.forms[0].JOB_TITLE.disabled=false;
document.forms[0].MOB_TEL_NO.readOnly=false
document.forms[0].NAT_ID_NO.readOnly=false;
document.forms[0].EMAIL_ID.readOnly=false


document.forms[0].NAME.value="";
document.forms[0].RELATIONSHIP.options[0].selected=true;

	/*Added by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
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
if(document.getElementById("m_postal_code1")!=null)
document.forms[0].m_postal_code1.value=""
document.forms[0].COUNTRY_DESC.value=""
document.forms[0].TELEPHONE_OFF.value=""
document.forms[0].TELEPHONE_RES.value=""
document.forms[0].MOB_TEL_NO.value=""
document.forms[0].NAT_ID_NO.value=""
document.forms[0].EMAIL_ID.value=""
//document.getElementById("pstsrh").disabled=false;
document.getElementById("cntrysrh").disabled=false;
}else
{
	//Below object checks for address fields added by Thamizh selvi against ML-MMOH-SCF-1133 on 17th Jan 2019
	if(document.forms[0].town_code!=null)
	document.forms[0].town_code.disabled=false;
	if(document.forms[0].area_code!=null)
	document.forms[0].area_code.disabled=false;
	if(document.forms[0].region_code!=null)
	document.forms[0].region_code.disabled=false;
	if(document.forms[0].postal_code!=null)
	document.forms[0].postal_code.disabled=false;

/*document.getElementById("twnsrch").disabled=false;
document.getElementById("areasrch").disabled=false;
document.getElementById("rgnsrh").disabled=false;*/
if(document.getElementById("region1")!=null)
document.forms[0].region1.value=""

if(document.getElementById("area1")!=null)
document.forms[0].area1.value=""

if(document.getElementById("town1")!=null)
document.forms[0].town1.value=""

if(document.getElementById("m_area_code")!=null)
document.forms[0].m_area_code.value=""

if(document.getElementById("m_town_code")!=null)
document.forms[0].m_town_code.value=""

if(document.getElementById("m_region_code")!=null)
document.forms[0].m_region_code.value=""

if(document.getElementById("m_area_code")!=null)
document.forms[0].m_area_code.disabled=false

if(document.getElementById("m_town_code")!=null)
document.forms[0].m_town_code.disabled=false

if(document.getElementById("m_region_code")!=null)
document.forms[0].m_region_code.disabled=false

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
{
	/*Modified by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
	if (obj.value == 'M')
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
if(document.getElementById("m_postal_code1")!=null)
document.forms[0].m_postal_code1.disabled=false
document.forms[0].COUNTRY_DESC.disabled=false
document.forms[0].TELEPHONE_OFF.disabled=false
document.forms[0].TELEPHONE_RES.disabled=false
document.forms[0].JOB_TITLE.disabled=false;
document.forms[0].MOB_TEL_NO.disabled=false
document.forms[0].NAT_ID_NO.disabled=false;
document.forms[0].EMAIL_ID.disabled=false
document.forms[0].NAME.value="";
document.forms[0].RELATIONSHIP.options[0].selected=true;
document.forms[0].copydet.disabled=true;

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
if(document.getElementById("m_postal_code1")!=null)
document.forms[0].m_postal_code1.value=""
document.forms[0].COUNTRY_DESC.value=""
document.forms[0].TELEPHONE_OFF.value=""
document.forms[0].TELEPHONE_RES.value=""
document.forms[0].MOB_TEL_NO.value=""
document.forms[0].NAT_ID_NO.value=""
document.forms[0].EMAIL_ID.value=""
//document.getElementById("pstsrh").disabled=false;
document.getElementById("cntrysrh").disabled=false;




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
HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMO/jsp/GetClaim.jsp?criteria=populateClaim'><input type='hidden' name='selclaim' id='selclaim' value='"+selclaim+"'><input type='hidden' name='cliamcode' id='cliamcode' value='"+claimcode+"'><input type='hidden' name='cmgfrmbdypart' id='cmgfrmbdypart' value='cmgfrmbdypart'></form></body></html>";
//parent.dummyframe1.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
parent.dummyframe1.document.write(HTMLVal);
parent.dummyframe1.document.dum_form.submit();
}



function set_values(obj,patient_id)
  { 

CLAIMANT_TYPE=document.forms[0].CLAIMANT_TYPE.value
name2=obj.value;
HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMO/jsp/MORegisterClaimantResult.jsp'><input type='hidden' name='pid' id='pid' value='"+patient_id+"'><input type='hidden' name='bodypart' id='bodypart' value='bodypart'><input type='hidden' name='name1' id='name1' value='"+CLAIMANT_TYPE+"'><input type='hidden' name='ctype' id='ctype' value='"+name2+"'></form></body></html>";
//parent.frames[6].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
parent.frames[6].document.write(HTMLVal);
parent.frames[6].document.dum_form.submit();

 
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
		sql="Select country_code code,short_name description from Mp_Country_lang_vw where LANGUAGE_ID='"+localeName+"' and eff_status='E' and upper(country_code) like upper(?) and upper(short_name) like upper(?) order by 2";
	   }else if(target.name=='town')
	   {
		tit=getLabel("Common.Town.label","Common"); 
		sql="select res_town_code code,short_desc description from mp_res_town  where eff_status='E' and upper(res_town_code) like upper(?) and upper(short_desc) like upper(?) order by 2"
	   }else if(target.name=='area')
	   {
		tit=getLabel("Common.area.label","Common");  
		sql="select RES_AREA_CODE code, short_desc description from mp_res_area where eff_status='E' and upper(RES_AREA_CODE) like upper(?) and upper(short_desc) like upper(?) order by 2"
	   }else if(target.name=='region')
	   { 
		tit=getLabel("eMP.region.label","MP");  
		sql="select REGION_CODE code, short_desc  description from mp_region where eff_status='E' and upper(REGION_CODE) like upper(?) and upper(short_desc) like upper(?) order by 2"
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
	
	

	sql="select BURIAL_PERMIT_NO code,PATIENT_ID Description from MO_BURIAL_PERMIT_VW where  facility_id='"+facilityId+"' and PATIENT_ID not in (select PATIENT_ID from mo_mortuary_regn) and patient_id in (select patient_id from mo_encounter_dtls_vw where REGN_ALLOWED_IN_MO_YN='Y') and upper(BURIAL_PERMIT_NO) like upper(?) and upper(PATIENT_ID) like upper(?) order by 2";
	
	
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( tit, argumentArray );
	
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		var arr=ret1.split(",");
	    
	  target.value=arr[0];
	document.forms[0].patient_id.value=arr[1]	
	target.focus();
	}
	
	
	
	
	
	
	}else
	{
   var patientid;
	if(document.getElementById("obt_from").value=="D")
	{
	patientid=await PatientSearchWithDefaultGender('F','N');
	}else  if(document.getElementById("obt_from").value=="A")
	{
	 patientid= await PatientSearch('','','','','','','Y','','N','');
	}else  if(document.getElementById("obt_from").value=="U")
	{
	 patientid= await PatientSearch('','','','','','','Y','','N','MO');
	}	
	else
	{
	alert(getMessage('OBTAINFROM_SELECT','MO'))
	
	}

	if(patientid!=null)
	{
	 document.getElementById("patientid").value = await patientid;
	 document.getElementById("patientid").focus();
	}
	else
	{
		document.getElementById("patientid").value = "";

	}
	}
}



function copyDet(patient_id)
 {CLAIMANT_TYPE=document.forms[0].CLAIMANT_TYPE.value
	

	patient_id=document.getElementById("patientid").value; 
	
HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMO/jsp/MORegisterClaimantResult.jsp'><input type='hidden' name='pid' id='pid' value='"+patient_id+"'><input type='hidden' name='name1' id='name1' value='"+CLAIMANT_TYPE+"'><input type='hidden' name='bodypart' id='bodypart' value='bodypart'></form></body></html>";
parent.frames[5].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
parent.frames[5].document.forms[0].submit();




}


function onSuccess()
{

if(frames[3].document.forms[0].mode.value=="modify")
{
	//frames[3].document.location.reload();

	bp.rows="47,0,0,*,20,0,0";	commontoolbarFrame.location.href="../eCommon/jsp/commonToolbar.jsp?menu_id=MO_MENU&module_id=MO&function_id=MO_BODY_PART_REGN&function_name=Body Part Registration&function_type=F&access=YYYNN";
	f_query_add_mod.location.href="../eMO/jsp/MORegisterBodyPartFrame.jsp";
}
else
{
//frames[0].document.forms[0].apply.disabled=false;
patientline.location.href='../../eCommon/html/blank.html'
f_query_add_mod.location.href='../../eCommon/html/blank.html'
criteria.location.href='../../eMO/jsp/MORegisterBodyPartCriteria.jsp'


}
}

function apply()
{
   
	
	//frames[3].document.forms[0].refe_type.disabled=false;
	//frames[3].document.forms[0].hcare_type.disabled=false;
	//frames[3].document.forms[0].referral_source.disabled=false;

	var isRemoveMandBPermitAppBy = frames[3].document.forms[0].isRemoveMandBPermitAppBy.value;
	
	//Below line added for this CRF ML-MMOH-CRF-0695
	var datetimeofclaimingApplicable = frames[3].document.forms[0].datetimeofclaimingApplicable.value;
	//End this CRF ML-MMOH-CRF-0695
	//Added by Shanmukh for ML-MMOH-CRF-1036 
    var isReceivedDateTimeAppl = frames[3].document.forms[0].isReceivedDateTimeAppl.value;
	var err=getLabel("eMO.BodyPartReceiptDateTime.label","MO");
	var err1=getLabel("Common.received.label","Common");
		if(isReceivedDateTimeAppl=="true")
			err=err.replace('Receipt',err1);
		else
			err=getLabel("eMO.BodyPartReceiptDateTime.label","MO");
		//END
/*	if(frames[3].document.forms[0].obt_from.value=="U")
 {
  fields = new Array (frames[3].document.forms[0].obt_from,frames[3].document.forms[0].body_received_date_time,frames[3].document.forms[0].service_code)
   names = new Array ("Obtained From","Body Part Receipt Date Time","Service");
}else
{*/
  fields = new Array (frames[1].document.forms[0].obt_from,frames[1].document.forms[0].patientid,frames[3].document.forms[0].body_received_date_time,frames[3].document.forms[0].service_code)
   names = new Array (f_query_add_mod.getLabel("eMO.ObtainedFrom.label","MO"),f_query_add_mod.getLabel("Common.patientId.label","Common"),err,f_query_add_mod.getLabel("Common.service.label","Common"));
//}
// Below Condition Added Aginst PAS-INC-MO -> Release Deceased/Body Part [IN:043269] By Saanthaakumar
 if((frames[3].document.forms[0].CLAIMANT_TYPE.value!="")&& (frames[3].document.forms[0].id3.style.visibility=='visible')){
		fields.push(frames[3].document.forms[0].CLAIMANT_TYPE_CODE);
		names.push(getLabel("eMO.Claimant.label","mo"));
} // Fix Over
//Added by Shanmukh on 26th-JUNE-2018 for ML-MMOH-CRF-1031 
var isChangeOfDateTimeClaimingAppl=frames[3].document.forms[0].isChangeOfDateTimeClaimingAppl.value;
if((isChangeOfDateTimeClaimingAppl=="true") && (frames[3].document.forms[0].body_claiming_date_time.value=="")){
	var err=getMessage("CAN_NOT_BE_BLANK",'common');
	var err1=getLabel("eMO.DateTimeOfClaiming.label","eMO");
	err=err.replace('$',err1);
	alert(err);
	messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+"";
	return false;
}
//END
obj1   = frames[3].document.forms[0].body_received_date_time.value;
obj2   = frames[3].document.forms[0].body_claiming_date_time.value;
if(obj2!="" && obj1!="")
{
	if(frames[3].isBefore(obj1,obj2,"DMYHM",localeName)==false)
	{
	 if(isChangeOfDateTimeClaimingAppl=="true"){
		var err=getMessage("DATE1_LT_DATE2",'IP');
		var err1=getLabel("eMO.DateTimeOfClaiming.label","eMO");
		var err2=getLabel("eMO.Body.label","eMO")+" "+getLabel("Common.received.label","Common")+" "+getLabel("Common.Date/Time.label","Common");
		err=err.replace('$',err1);
		err=err.replace('#',err2);
		alert(err);
		frames[3].document.forms[0].body_claiming_date_time.value="";
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+"";
		return false;
		}
	}
}

if(frames[3].checkFields( fields, names, messageFrame)) 
 {
if(((frames[3].document.forms[0].obt_from.value=='D'||frames[3].document.forms[0].obt_from.value=='A')&&(frames[3].document.forms[0].postmortem_reqd_yn.checked==false)) || (((frames[3].document.forms[0].postmortem_reqd_yn.checked==false)||(frames[3].document.forms[0].startendstat.value=="E"))))
	 { if(frames[3].document.forms[0].burial_permit_reqd_yn.value=="Y"){
			
			//Added for this CRF ML-MMOH-CRF-0695
			if(isRemoveMandBPermitAppBy!="true" && datetimeofclaimingApplicable!="true"){
			
					if((frames[3].document.forms[0].body_burial_permit_no.value==""||frames[3].document.forms[0].generate_burial_permit.checked)&&(frames[3].document.forms[0].body_claiming_date_time.value=="")&&(frames[3].document.forms[0].burial_permit_app_by.value=="")&&(frames[3].document.forms[0].burial_app_date.value=="")) {
				   }
			  else if((frames[3].document.forms[0].body_burial_permit_no.value!=""||frames[3].document.forms[0].generate_burial_permit.checked)&&(frames[3].document.forms[0].body_claiming_date_time.value!="")&&(frames[3].document.forms[0].burial_permit_app_by.value!="")&&(frames[3].document.forms[0].burial_app_date.value!="")){
				   }
			  else { 
			           
					   
						var msg=f_query_add_mod.getMessage("CAPTURE_BURIAL_PRMT_DTLS","MO");
						messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
						return false    
				   }
		}else{
				if((frames[3].document.forms[0].body_burial_permit_no.value==""||frames[3].document.forms[0].generate_burial_permit.checked)&&(frames[3].document.forms[0].body_claiming_date_time.value=="")&&(frames[3].document.forms[0].burial_app_date.value=="")) {
				   }
			  else if((frames[3].document.forms[0].body_burial_permit_no.value!=""||frames[3].document.forms[0].generate_burial_permit.checked)&&(frames[3].document.forms[0].body_claiming_date_time.value!="")&&(frames[3].document.forms[0].burial_app_date.value!="")){
				   }
			  else {
						var msg=f_query_add_mod.getMessage("CAPTURE_BURIAL_PRMT_DTLS","MO");
						messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
						return false    
				   }
		}

      }else{ 
			if(frames[3].document.forms[0].generate_burial_permit.checked){ 
            //Below line modified for this CRF ML-MMOH-CRF-0695
			if(isRemoveMandBPermitAppBy!="true" && datetimeofclaimingApplicable!="true"){	
				if(frames[3].document.forms[0].body_claiming_date_time.value=="" ||frames[3].document.forms[0].burial_app_date.value=="" || (frames[3].document.forms[0].burial_permit_app_by.value=="")){	   
					var msg=f_query_add_mod.getMessage("CAPTURE_BURIAL_PRMT_DTLS","MO");
					messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
					return false 	   	
				}
			}else{
				if(frames[3].document.forms[0].body_claiming_date_time.value=="" ||frames[3].document.forms[0].burial_app_date.value==""){	   
					var msg=f_query_add_mod.getMessage("CAPTURE_BURIAL_PRMT_DTLS","MO");
					messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
					return false 	   	
				}

			}

		}else{ 
		   //Below line modified for this CRF ML-MMOH-CRF-0695
			if(isRemoveMandBPermitAppBy!="true" && datetimeofclaimingApplicable!="true"){	
				if((frames[3].document.forms[0].body_burial_permit_no.value=="" ||frames[3].document.forms[0].body_claiming_date_time.value=="" || frames[3].document.forms[0].burial_app_date.value=="" || (frames[3].document.forms[0].burial_permit_app_by.value=="")) && (frames[3].document.forms[0].body_burial_permit_no.value!="" ||frames[3].document.forms[0].body_claiming_date_time.value!="" || frames[3].document.forms[0].burial_app_date.value!="" || (frames[3].document.forms[0].burial_permit_app_by.value!=""))){
							
				 }
			}else{
				if((frames[3].document.forms[0].body_burial_permit_no.value=="" ||frames[3].document.forms[0].body_claiming_date_time.value=="" || frames[3].document.forms[0].burial_app_date.value=="") && (frames[3].document.forms[0].body_burial_permit_no.value!="" ||frames[3].document.forms[0].body_claiming_date_time.value!="" || frames[3].document.forms[0].burial_app_date.value!="")){
							
				 }


			}
		   }
         }
	 }			

if(frames[3].document.forms[0].addbodypart.length==0)
{
  var msg=f_query_add_mod.getMessage("SELECT_BODY_PART","MO");
  messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
   return false    

}

organlength=frames[3].document.forms[0].addbodypart.length
var organ="";

for(i=0;i<organlength;i++)
{
organs=frames[3].document.forms[0].addbodypart.options[i].value
organ=organ+organs+"|";

}
frames[3].document.forms[0].organ.value=organ;

/*for (i=1;i<=9 ;i++)
 {fld1=eval("frames[3].document.forms[0].organ"+i).value
  
  for (j=i+1;j<=9 ;j++)
 {
   fldcmp1=eval("frames[3].document.forms[0].organ"+j).value
	
    
   if(fld1!="")
	 { 
	if(fld1==fldcmp1)	
	 {
	 msg=getMessage("BODY_PART_UNIQUE")
	  messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
	 return false;
	 }
	 }
 
 }
 
 
 }*/
			
			
			
			
if(frames[3].document.forms[0].mlc_yn.checked)
       {
   
	 pol_rep_no=frames[3].document.getElementById("pol_rep_no").value
	pol_stn_id=frames[3].document.getElementById("pol_stn_id").value
	pol_id=frames[3].document.getElementById("pol_id").value
	police_details=frames[3].document.getElementById("police_details").value	
	
	police_received_date=frames[3].document.getElementById("police_received_date").value
	police_received_by=frames[3].document.getElementById("police_received_by").value
	/*Added by Thamizh selvi on 4th Aug 2017 for ML-MMOH-CRF-689 Start*/
	var policeDtlsMandYn	= frames[3].document.getElementById("policeDtlsMandYn").value;
	var calledFrom			= frames[3].document.getElementById("calledFrom").value;
	if(calledFrom != "MO_EBP_REGN"){
		if(pol_rep_no==""|| pol_stn_id==""|| pol_id=="" || police_details=="" || police_received_date=="" || police_received_by=="")
		{
			msg=f_query_add_mod.getMessage("POLICE_DET_MAND","MO");
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
			return false;
		}
	}
	else{
		if(policeDtlsMandYn == "Y" ){/*End*/
			if(pol_rep_no==""|| pol_stn_id==""|| pol_id=="" || police_details=="" || police_received_date=="" || police_received_by=="")
		   {
			 msg=f_query_add_mod.getMessage("POLICE_DET_MAND","MO");
			 messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
		   return false;
		   }
		}
	}
	 frames[3].document.forms[0].mlc_yn.value="Y"
           }else
           {
             frames[3].document.forms[0].mlc_yn.value="N";
           }
		
		 if(frames[3].document.forms[0].postmortem_reqd_yn.checked)
		{
		 frames[3].document.forms[0].postmortem_reqd_yn.value="Y"
		}else
		{
		frames[3].document.forms[0].postmortem_reqd_yn.value="N";
		}
		 
		 if(frames[3].document.forms[0].highriskbodyyn.checked)
		 {
		 frames[3].document.forms[0].highriskbodyyn.value='Y';
		 }
	     else
		 {
		 frames[3].document.forms[0].highriskbodyyn.value='N';
		 }
		 
		 
		 if(frames[3].document.forms[0].unclaimedbodyyn.checked)
		 {
		 frames[3].document.forms[0].unclaimedbodyyn.value='Y';
		 }
	     else
		 {
		frames[3].document.forms[0].unclaimedbodyyn.value='N';
		 }

		 if(frames[3].document.forms[0].brought_by_police_yn.checked)
		 {
		 frames[3].document.forms[0].brought_by_police_yn.value='Y';
		 }
	     else
		 {
		frames[3].document.forms[0].brought_by_police_yn.value='N';
		 }
       frames[3].document.forms[0].patient_id.value=frames[3].document.forms[0].patientid.value
	   frames[3].document.forms[0].area_type.disabled = false;
	   frames[3].document.forms[0].assign_date_time.disabled = false; 	
	   frames[3].document.forms[0].bed_no.disabled=false;
	   frames[3].document.forms[0].mlc_yn.disabled=false;
	   frames[3].document.forms[0].postmortem_reqd_yn.disabled=false;
	   if(frames[3].document.forms[0].m_postal_code1 != null)//Added by Thamizh selvi on 4th June 2018
			frames[3].document.forms[0].ZIP_CODE.value=frames[3].document.forms[0].m_postal_code1.value;
	   frames[3].document.forms[0].postmortem_type.disabled=false;
	   frames[3].document.forms[0].burial_permit_app_by.disabled=false;

	 //Below line added for this CRF ML-MMOH-CRF-0695 	
	 if(datetimeofclaimingApplicable=="true") frames[3].document.forms[0].body_claiming_date_time.disabled=false;

	//Added by Ashwini on 08-Aug-2017 for ML-MMOH-CRF-0748
	frames[3].document.forms[0].refe_type.disabled=false;
	frames[3].document.forms[0].hcare_type.disabled=false;
	frames[3].document.forms[0].referral_source.disabled=false;
	frames[3].document.forms[0].action="../../servlet/eMO.MOBodyPartRegnServlet";
	frames[3].document.forms[0].submit();
    
	 //Below line added for this CRF ML-MMOH-CRF-0695 	
	 if(datetimeofclaimingApplicable=="true"){
	     if(!frames[3].document.forms[0].body_claiming_date_time.disabled)frames[3].document.forms[0].body_claiming_date_time.disabled=true;
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
	xmlStr += " practName_FValue=\"" + practitionerName + "\"";
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
	//eval(responseText);
	eval(practSearch(practitionerName,practitionerName,responseText));
		
	return;            
	
	var retVal=await CommonLookup(tit,argumentArray);

	if(retVal==null || retVal=="")
		target.value="";
	else
		target.value=retVal[0];
		            
}

//anbu
async function practSearch(practitionerName,practitionerName,responseText) {
	var retVal = 	new String();
	var dialogTop = "10px" ;
	var dialogHeight= "510px" ;
	var dialogWidth	= "878px" ;
		
	if(responseText =="true") {        	
	    dialogWidth="70.5";
	}
	
	var status = "no";
	var arguments	= "" ;
	var tit="Pract Search";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var sqlArray= new Array();
	//var objName="<%=practName_FName%>";
	var objName=practitionerName;
    arguments='';
	
	//retVal = window.showModalDialog("<%=request.getContextPath()%>/eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+"<%=practName_FValue%>"+"&practitioner_type="+"<%=practitioner_type%>"+"&primary_specialty="+"<%=specialty_code%>"+"&job_title="+"<%=job_title%>"+"&gender="+"<%=gender%>",arguments,features);
	
	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practitionerName+"&practitioner_type="+"\""+"&job_title="+"\""+"&gender="+"\"",arguments,features);
	PractLookupRetVal(retVal,objName);
}
//
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
		if(objName=="burial_permit_app_by")
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

/*function callPostalSearch(target)
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

		tit=getLabel("eMP.postalcode.label","MP"); 
		sql="select postal_code, short_desc from mp_postal_code";
		search_code="postal_code";
		search_desc= "short_desc"
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

		if (!(retVal == null))
		{
		
			target.value=retVal;
			
		}
		else
			target.focus();
}


*/


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
		if (claimant == 'M')
		{
			document.getElementById("id3").style.visibility='visible';
		}else
		{
			document.getElementById("id3").style.visibility='hidden';
		}
	}
}else
{
if(claimcode!="")
{document.getElementById("id3").style.visibility='visible';
//document.forms[0].CLAIMANT_TYPE_CODE.disabled=true
}
}
if(claimant!="")
{

HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMO/jsp/GetClaim.jsp?criteria=populateClaim'><input type='hidden' name='selclaim' id='selclaim' value='"+claimant+"'><input type='hidden' name='cliamcode' id='cliamcode' value='"+claimcode+"'><input type='hidden' name='cmgfrmbdypart' id='cmgfrmbdypart' value='cmgfrmbdypart'></form></body></html>";
parent.frames[5].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
parent.frames[5].document.dum_form.submit();
}


document.forms[0].copydet.disabled=true;
//document.forms[0].postal_search.disabled=true
document.forms[0].contry_code.disabled=true
document.forms[0].CLAIMANT_TYPE_CODE.disabled=true;
document.forms[0].CLAIMANT_TYPE.disabled=true;
document.forms[0].NAME.disabled=true;
document.forms[0].RELATIONSHIP.disabled=true;

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
	{
	document.forms[0].PASSPORT_NO.disabled=true
	document.forms[0].OTHER_IDENTIFICATION.disabled=true
	}
	
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
if(document.forms[0].m_postal_code1!=null)
document.forms[0].m_postal_code1.disabled=true
//document.getElementById("pstsrh").disabled=true;
document.getElementById("cntrysrh").disabled=true;

/*document.getElementById("twnsrch").disabled=true;
document.getElementById("areasrch").disabled=true;
document.getElementById("rgnsrh").disabled=true;*/


if(document.getElementById("m_area_code")!=null)
document.forms[0].m_area_code.disabled=true

if(document.getElementById("m_town_code")!=null)
document.forms[0].m_town_code.disabled=true

if(document.getElementById("m_region_code")!=null)
document.forms[0].m_region_code.disabled=true

document.forms[0].COUNTRY_DESC.disabled=true
document.forms[0].TELEPHONE_OFF.disabled=true
document.forms[0].TELEPHONE_RES.disabled=true
document.forms[0].MOB_TEL_NO.disabled=true
document.forms[0].NAT_ID_NO.disabled=true
document.forms[0].EMAIL_ID.disabled=true


}
else
{

if(claimant!="")
{
//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
{
	/*Modified by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
	if (claimant == 'M')
	{
		document.getElementById("id3").style.visibility='visible';
	}else
	{
		document.getElementById("id3").style.visibility='hidden';
	}
}else
{
document.getElementById("id3").style.visibility='visible';
}

document.forms[0].CLAIMANT_TYPE_CODE.disabled=false

if(claimant=='K')
{
//document.getElementById("twnsrch").disabled=false;
//document.getElementById("areasrch").disabled=false;
//document.getElementById("rgnsrh").disabled=false;

if(document.getElementById("m_area_code")!=null)
document.forms[0].m_area_code.disabled=false

if(document.getElementById("m_town_code")!=null)
document.forms[0].m_town_code.disabled=false

if(document.getElementById("m_region_code")!=null)
document.forms[0].m_region_code.disabled=false

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

document.forms[0].ORGANIZATION_NAME.disabled=true
document.forms[0].JOB_TITLE.disabled=false
if(document.getElementById("addr_line_1")!=null)
document.forms[0].addr_line_1.disabled=false
if(document.getElementById("addr_line_2")!=null)
document.forms[0].addr_line_2.disabled=false
if(document.getElementById("addr_line_3")!=null)
document.forms[0].addr_line_3.disabled=false
if(document.getElementById("addr_line_4")!=null)
document.forms[0].addr_line_4.disabled=false
if(document.getElementById("m_postal_code1")!=null)
document.forms[0].m_postal_code1.disabled=false
document.forms[0].COUNTRY_DESC.disabled=false
document.forms[0].TELEPHONE_OFF.disabled=false
document.forms[0].TELEPHONE_RES.disabled=false
document.forms[0].MOB_TEL_NO.disabled=false
document.forms[0].NAT_ID_NO.disabled=false
document.forms[0].EMAIL_ID.disabled=false
document.forms[0].copydet.disabled=false;
document.forms[0].NAT_ID_NO.disabled=false;
document.forms[0].EMAIL_ID.disabled=false
//document.getElementById("pstsrh").disabled=false;
document.getElementById("cntrysrh").disabled=false;

}else if((claimant=='E')||(claimant=='F'))
{
/*document.getElementById("twnsrch").disabled=false;
document.getElementById("areasrch").disabled=false;
document.getElementById("rgnsrh").disabled=false;*/

if(document.getElementById("m_area_code")!=null)
document.forms[0].m_area_code.disabled=false

if(document.getElementById("m_town_code")!=null)
document.forms[0].m_town_code.disabled=false

if(document.getElementById("m_region_code")!=null)
document.forms[0].m_region_code.disabled=false

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
if(document.getElementById("m_postal_code1")!=null)
document.forms[0].m_postal_code1.disabled=false
document.forms[0].COUNTRY_DESC.disabled=false
document.forms[0].TELEPHONE_OFF.disabled=false
document.forms[0].TELEPHONE_RES.disabled=false
//document.getElementById("pstsrh").disabled=false;
document.getElementById("cntrysrh").disabled=false;

document.forms[0].JOB_TITLE.disabled=false;
document.forms[0].MOB_TEL_NO.disabled=false
document.forms[0].NAT_ID_NO.disabled=false;
document.forms[0].EMAIL_ID.diabled=false

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
/*document.getElementById("twnsrch").disabled=false;
document.getElementById("areasrch").disabled=false;
document.getElementById("rgnsrh").disabled=false;*/

if(document.getElementById("m_area_code")!=null)
document.forms[0].m_area_code.disabled=false

if(document.getElementById("m_town_code")!=null)
document.forms[0].m_town_code.disabled=false

if(document.getElementById("m_region_code")!=null)
document.forms[0].m_region_code.disabled=false

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
{
	/*Modified by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/
	if (claimant == 'M')
	{
		document.getElementById("id3").style.visibility='visible';
	}else
	{
		document.getElementById("id3").style.visibility='hidden';
	}
}else
{
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
if(document.getElementById("m_postal_code1")!=null)
document.forms[0].m_postal_code1.disabled=false
document.forms[0].COUNTRY_DESC.disabled=false
document.forms[0].TELEPHONE_OFF.disabled=false
document.forms[0].TELEPHONE_RES.disabled=false
document.forms[0].JOB_TITLE.disabled=false;
document.forms[0].MOB_TEL_NO.disabled=false
document.forms[0].NAT_ID_NO.disabled=false;
document.forms[0].EMAIL_ID.disabled=false
//document.getElementById("pstsrh").disabled=false;
document.getElementById("cntrysrh").disabled=false;

}



HTMLVal = "<html><head><scriptlanguage='javascript'  src='../../eCommon/js/ValidateControl.js'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMO/jsp/GetClaim.jsp?criteria=populateClaim'><input type='hidden' name='selclaim' id='selclaim' value='"+claimant+"'><input type='hidden' name='cliamcode' id='cliamcode' value='"+claimcode+"'><input type='hidden' name='cmgfrmbdypart' id='cmgfrmbdypart' value='cmgfrmbdypart'></form></body></html>";
parent.frames[5].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
parent.frames[5].document.dum_form.submit();



}else
{//document.getElementById("pstsrh").disabled=true;
document.getElementById("cntrysrh").disabled=true;
document.forms[0].NAME.disabled=true;
document.forms[0].RELATIONSHIP.disabled=true;

//Added by Ashwini on 24-Jul-2017 for ML-MMOH-CRF-0743
if(document.forms[0].isClaimantChngsApplicable.value == "true")
	{
	document.forms[0].PASSPORT_NO.disabled=true
	document.forms[0].OTHER_IDENTIFICATION.disabled=true
	}

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
if(document.forms[0].m_postal_code1!=null)
document.forms[0].m_postal_code1.disabled=true
document.forms[0].COUNTRY_DESC.disabled=true
document.forms[0].TELEPHONE_OFF.disabled=true
document.forms[0].TELEPHONE_RES.disabled=true
document.forms[0].MOB_TEL_NO.disabled=true
document.forms[0].NAT_ID_NO.disabled=true
document.forms[0].EMAIL_ID.disabled=true
/*document.getElementById("twnsrch").disabled=true;
document.getElementById("areasrch").disabled=true;
document.getElementById("rgnsrh").disabled=true;*/
if(document.getElementById("m_area_code")!=null)
document.forms[0].m_area_code.value=""

if(document.getElementById("m_town_code")!=null)
document.forms[0].m_town_code.value=""

if(document.getElementById("m_region_code")!=null)
document.forms[0].m_region_code.value=""

if(document.getElementById("m_area_code")!=null)
document.forms[0].m_area_code.disabled=true

if(document.getElementById("m_town_code")!=null)
document.forms[0].m_town_code.disabled=true

if(document.getElementById("m_region_code")!=null)
document.forms[0].m_region_code.disabled=true



}
}
}





async  function searchBed(obj,target)
	{
				var retVal =    new String();
				var area_code   =document.forms[0].area_type.value;
				var retVal = "";
				var dialogHeight= "32" ;
				var dialogWidth	= "50" ;
				var dialogTop ="60";
				var status = "no";
				var arguments	= " ";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;

				
			   var retVal=	await window.showModalDialog("../../eMO/jsp/MOBayAvailabilityChart.jsp?area_code="+area_code+"&bed_status=V&disable=yes",arguments,features);
               

  if(retVal != null && retVal != "" )
                {
	  document.forms[0].bed_no.value=retVal;
				}
	
	
	
	}

function enableservices(areacode,postmortem_reqd_yn,posttype,startendstat)
	{      //checked on the time of insert
/*	if(postmortem_reqd_yn=="Y" &&document.forms[0].mlc_yn.checked==false)
	  posttype="C"
	if(document.forms[0].area_type.value != "")
	 {
	   document.forms[0].bed_no.disabled=false;
	   document.forms[0].bed_no.value="";
	  }
	 else{
	     document.forms[0].bed_no.readndisabled=true;
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
			document.getElementById("postmortem_reqd_yn").checked = true
			
			
			
			
			}
			
			document.getElementById("postmortem_type").options[0].selected=true;
			
			
			var postmortem_reqd_yn = document.getElementById("postmortem_reqd_yn").value;
			var startendstat=document.getElementById("startendstat").value;
			
			var HTMLVal = " <html><body><form name='form1' id='form1' method='post'  action='../../eMO/jsp/MOPopulateArea.jsp' target='messageFrame'><input type='hidden' name='postmortem_reqd_yn' id='postmortem_reqd_yn' value='"+postmortem_reqd_yn+"'><input type='hidden' name='area_code' id='area_code' value='"+areacode+"'><input type='hidden' name='startendstat' id='startendstat' value='"+startendstat+"'></form></body></html>";
			parent.dummyframe.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.dummyframe.document.forms[0].submit();*/
						

		
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


function clearBed()
{
    if(document.forms[0].area_type.value != "")
	{
	  document.forms[0].bed_no.value="";
	  document.forms[0].bed_no.disabled=false;
	  document.forms[0].bed_button.disabled=false;	 

	var Sys_date = convertDate(document.forms[0].system_date.value,"DMYHM","en",localeName); 

	 // document.forms[0].assign_date_time.value = document.forms[0].system_date.value;
	 document.forms[0].assign_date_time.value = Sys_date;
	
	}
	else{
	 //document.getElementById("tab1").scrollIntoView();
	   document.getElementById("tab1").scrollIntoView({
			  behavior: "smooth",
			  block: "nearest",
			  inline: "start"
			});
	 document.forms[0].assign_date_time.value ="";
	 document.forms[0].bed_no.value="";	
	 document.forms[0].bed_no.disabled=true;
	 document.forms[0].bed_button.disabled=true;
	
	
	}
	
}

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
		   // alert('Invalid Location')
			document.forms[0].bed_no.value = '';
			document.forms[0].bed_no.select();
		}
  }
 
 if(document.forms[0].area_type.value != "")
	{
//	document.forms[0].bed_no.value="";
	document.forms[0].bed_no.disabled=false;
	document.forms[0].bed_button.disabled=false;
	}
	else{
	document.forms[0].bed_no.value="";
	document.forms[0].bed_no.disabled=true;
	document.forms[0].bed_button.disabled=true;
	}

}
function getService()
{

	 if (document.getElementById("postmortem_reqd_yn").checked==true)
	{
	  document.getElementById("bed_no").value="";
      document.getElementById("bed_no").disabled=true;
	  document.getElementById("bed_button").disabled=true;
	  document.getElementById("dis1").style.visibility="hidden"
	  document.getElementById("dis2").style.visibility="hidden"
	  document.getElementById("dis3").style.visibility="hidden"
	  
	  //Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696
	if(document.getElementById("rearrangeTabBurlPermtClaimnt") && document.getElementById("rearrangeTabBurlPermtClaimnt").value=="true"){
	document.getElementById("clmantDis").style.display = 'none';
	var tit=getLabel("eMO.Claimant.label","MO");
	document.getElementById("bp1").title=getLabel("eMO.Claimant.label","MO");
	document.getElementById("bp1").innerHTML="<a onclick=javascript:tab_click1('claimant_tab') id='claimant_tab' class='tabA'><span class='tabAspan' id='claimant_tabspan'>"+tit+"</span></a>";
	}else{
	  document.getElementById("bp1").style.visibility="hidden"
	}
	
	//Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696
	if(document.getElementById("rearrangeTabBurlPermtClaimnt") && document.getElementById("rearrangeTabBurlPermtClaimnt").value=="true"){
	document.getElementById("clmantDis2").style.display = 'none';
	var tit=getLabel("eMO.Claimant.label","MO");
	document.getElementById("bp2").title=getLabel("eMO.Claimant.label","MO");
	document.getElementById("bp2").innerHTML="<a onclick=javascript:tab_click1('claimant_tab') id='claimant_tab' class='tabClicked'><span class='tabSpanclicked' id='claimant_tabspan'>"+tit+"</span></a>";
	}else{
	  document.getElementById("bp2").style.visibility="hidden"
	}

	  document.getElementById("bp3").style.visibility="hidden"

	 if (document.getElementById("mlc_yn").checked==true)
		{ 
	 document.forms[0].Consent_forms.disabled=true;
	 document.getElementById("Police_Details").disabled=false;
		document.getElementById("postmortem_type").options[2].selected=true;
		}else
		{
		document.forms[0].Consent_forms.disabled=false;
	    document.getElementById("Police_Details").disabled=true;
		document.getElementById("postmortem_type").options[1].selected=true;
		}
	 
	      
	 document.getElementById("postmortem_type").disabled=true;     
	 if(document.getElementById("mode").value!="viewdata")
	 document.getElementById("postmortem_reqd_yn").disabled=false;
	 document.getElementById("postmortem_reqd_yn").value="Y";
     if(document.getElementById("mode").value=="modify")
	 {
	document.getElementById("postmortem_type").disabled=true;
	//document.getElementById("mlc_yn").disabled=true;
	 }       

    }else 
	{ 
		if (document.getElementById("mlc_yn").checked==true)
		{ 
	 document.forms[0].Consent_forms.disabled=true;
	 document.getElementById("Police_Details").disabled=false;
	document.getElementById("postmortem_type").options[2].selected=true;
		}else
		{
		document.getElementById("postmortem_type").options[0].selected=true;
		}
		
	  document.getElementById("bed_no").value="";
	  document.getElementById("bed_no").disabled=true;
	  document.getElementById("bed_button").disabled=true;
	  
	  document.getElementById("dis1").style.visibility="visible"
	  document.getElementById("dis2").style.visibility="visible"
	  document.getElementById("dis3").style.visibility="visible"
	
	//Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696	    
	if(document.getElementById("rearrangeTabBurlPermtClaimnt") && document.getElementById("rearrangeTabBurlPermtClaimnt").value=="true"){	
		document.getElementById("clmantDis").style.display = 'block';					
		var tit1=getLabel("eMO.BurialPermit.label","MO");
		document.getElementById("bp1").title=getLabel("eMO.BurialPermit.label","MO");
		document.getElementById("bp1").innerHTML="<a onclick=javascript:tab_click1('burialPermit_tab') id='burialPermit_tab' class='tabA'> <span class='tabAspan' id='burialPermit_tabspan'>"+tit1+"</a>";					
		var tit=getLabel("eMO.Claimant.label","MO");
		document.getElementById("clmantDis").innerHTML="<a onclick=javascript:tab_click1('claimant_tab') id='claimant_tab' class='tabA'><span class='tabAspan' id='claimant_tabspan'>"+tit+"</span></a>";
	}else{
	  document.getElementById("bp1").style.visibility="visible"
	}

	//Added by Ashwini on 17-Oct-2017 for ML-MMOH-CRF-0696	    
	if(document.getElementById("rearrangeTabBurlPermtClaimnt") && document.getElementById("rearrangeTabBurlPermtClaimnt").value=="true"){
		document.getElementById("clmantDis2").style.display = 'block';					
		var tit1=getLabel("eMO.BurialPermit.label","MO");
		document.getElementById("bp2").title=getLabel("eMO.BurialPermit.label","MO");
		document.getElementById("bp2").innerHTML="<a onclick=javascript:tab_click1('burialPermit_tab') id='burialPermit_tab' class='tabA'> <span class='tabAspan' id='burialPermit_tabspan'>"+tit1+"</a>";
		var tit=getLabel("eMO.Claimant.label","MO");
		document.getElementById("clmantDis2").innerHTML="<a onclick=javascript:tab_click1('claimant_tab') id='claimant_tab' class='tabClicked'><span class='tabSpanclicked' id='claimant_tabspan'>"+tit+"</span></a>";
	}else{
	  document.getElementById("bp2").style.visibility="visible"
	}
	
	  document.getElementById("bp3").style.visibility="visible"

	 document.forms[0].Consent_forms.disabled=true;
	// document.getElementById("Police_Details").disabled=true;
	      
	 document.getElementById("postmortem_reqd_yn").checked=false;
	 if(document.getElementById("mode").value!="viewdata")
	 document.getElementById("postmortem_reqd_yn").disabled=false;
	 
	 document.getElementById("postmortem_reqd_yn").value="N";
	if(document.getElementById("mode").value=="modify")
	 {
	document.getElementById("postmortem_type").disabled=true;
	//document.getElementById("mlc_yn").disabled=true;
	 }
	}
	var postmortem_reqd_yn = document.getElementById("postmortem_reqd_yn").value;
	
	var startendstat="";
	var areacode="";
	var HTMLVal = " <html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post'  action='../../eMO/jsp/MOPopulateArea.jsp' ><input type='hidden' name='postmortem_reqd_yn' id='postmortem_reqd_yn' value='"+postmortem_reqd_yn+"'><input type='hidden' name='area_code' id='area_code' value='"+areacode+"'><input type='hidden' name='startendstat' id='startendstat' value='"+startendstat+"'><input type='hidden' name='popareaforbprt' id='popareaforbprt' value='popareaforbprt'></form></body></html>";
	parent.dummyframe.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.dummyframe.document.forms[0].submit();

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

	var HTMLVal = " <html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post'  action='../../eMO/jsp/MOSelectReferral.jsp' target='dummyframe'><input type='hidden' name='ref_code' id='ref_code' value='"+document.forms[0].refe_type.value+"'><input type='hidden' name='ref_type' id='ref_type' value='"+ref_source_code+"'><input type='hidden' name='hcare_type_code' id='hcare_type_code' value='"+document.forms[0].hcare_type.value+"'></form></body></html>";
	parent.dummyframe.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.dummyframe.document.forms[0].submit();



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
function assignmlc(areacode,postmortem_reqd_yn,posttype,startendstat)
	{
    
	
	
	if(document.getElementById("mode").value=="modify"&&document.getElementById("mlc_yn").checked==true)
    document.getElementById("Police_Details").disabled=false;
   else
   document.getElementById("Police_Details").disabled=true;
	if(document.getElementById("mode").value=="viewdata")
	{
	 if(startendstat=="S"||startendstat=="E")
	 {
	  document.getElementById("portmorteme_Det").style.visibility='visible'
	 }else
	{
	  document.getElementById("portmorteme_Det").style.visibility='hidden'
	}
	
	document.getElementById("refe_type").disabled=true;
	document.getElementById("referral_source").disabled=true;
	document.getElementById("hcare_type").disabled=true;
	document.getElementById("referral_by").disabled=true;
	document.getElementById("unclaimedbodyyn").disabled=true;
	document.getElementById("highriskbodyyn").disabled=true;
	document.getElementById("brought_by_police_yn").disabled=true;
	document.getElementById("remarks").disabled=true;
	
	document.getElementById("addbodypart").disabled=true;
	document.getElementById("selectbodypart").disabled=true;
	document.getElementById("bt1").disabled=true;
	document.getElementById("bt2").disabled=true;
	//document.getElementById("organ1").disabled=true
	//document.getElementById("organ2").disabled=true
	//document.getElementById("organ3").disabled=true
	//document.getElementById("organ4").disabled=true
	//document.getElementById("organ5").disabled=true
	//document.getElementById("organ6").disabled=true
	//document.getElementById("organ7").disabled=true
	//document.getElementById("organ8").disabled=true
	//document.getElementById("organ9").disabled=true
	document.getElementById("generate_burial_permit").disabled=true
	document.getElementById("body_claiming_date_time").disabled=true
	document.getElementById("vechile_no").disabled=true
	//Added for this CRF ML-MMOH-CRF-0692
	if(document.getElementById("isRemoveMandBPermitAppBy").value=="false" && document.getElementById("burial_permit_app_desc").value != "")
		{
		document.getElementById("burial_permit_app_desc").disabled=true;		
		document.getElementById("disbur").disabled=true; 
		}
	
	//End ML-MMOH-CRF-0692
	
	document.getElementById("burial_app_date").disabled=true
	document.getElementById("disburdate").disabled=true
	/*Below line added for this CRF ML-MMOH-CRF-0695*/
	if(document.getElementById("datetimeofclaimingApplicable") && document.getElementById("datetimeofclaimingApplicable").value!="true"){
        if(document.getElementById("otdatetime1"))document.getElementById("otdatetime1").disabled=true;
	}
	//End this CRF ML-MMOH-CRF-0695
	
    document.getElementById("area_type").diasbled=true;
    document.getElementById("bed_no").diasbled=true;
	document.getElementById("postmortem_reqd_yn").disabled=true;	
	document.getElementById("body_burial_permit_no").disabled=true;	
	//document.getElementById("generate_burial_permit").disabled=true;	
	
	}
		
	
	if (document.getElementById("mlc_yn").checked==true )
   { /* if(startendstat!="E")
	   {
	  document.getElementById("dis1").style.visibility="hidden"
	  document.getElementById("dis2").style.visibility="hidden"
	  document.getElementById("dis3").style.visibility="hidden"
	  }*/
	  document.getElementById("mlc_yn").value="Y";
	 //	 document.getElementById("postmortem_reqd_yn").value="Y";
	 // document.getElementById("postmortem_reqd_yn").checked=true;
	  //document.getElementById("postmortem_reqd_yn").disabled=true;
	  document.getElementById("Consent_forms").disabled=true;
      document.getElementById("postmortem_type").options[2].selected=true;     
	  document.getElementById("postmortem_type").disabled=true;     
	 document.getElementById("Police_Details").disabled=false;
	if(document.getElementById("mode").value=="modify"||document.getElementById("mode").value=="viewdata")
	 {
	 document.getElementById("postmortem_type").disabled=true;
	 if(document.getElementById("mode").value=="viewdata")
	 document.getElementById("mlc_yn").disabled=true;
	 
	 }
	}	
	else 
	{ 
	  if(postmortem_reqd_yn=="Y"||document.getElementById("postmortem_reqd_yn").checked==true)
	{ document.getElementById("postmortem_reqd_yn").value="Y";
	  document.getElementById("postmortem_reqd_yn").checked=true;
	  document.getElementById("postmortem_type").options[1].selected=true; 
	 
	 if (document.getElementById("mlc_yn").checked==false)
	  document.getElementById("Consent_forms").disabled=false;
	  //document.getElementById("postmortem_reqd_yn").disabled=true;
	 if(startendstat!="E")
	   {

	  document.getElementById("dis1").style.visibility="hidden"
	  document.getElementById("dis2").style.visibility="hidden"
	  document.getElementById("dis3").style.visibility="hidden"
	   }
	}else if((document.getElementById("postmortem_reqd_yn").checked==false))
	{
		document.getElementById("tab1").style.visibility="visible"
	    document.getElementById("tab2").style.visibility="visible"
	    document.getElementById("tab3").style.visibility="visible"
	
	
	 document.forms[0].Consent_forms.disabled=true;
	 document.getElementById("Police_Details").disabled=true;
	 document.getElementById("postmortem_type").options[0].selected=true;     
	 //document.getElementById("postmortem_reqd_yn").checked=false;
	// if(document.getElementById("mode").value!="viewdata")
	// document.getElementById("postmortem_reqd_yn").disabled=false;
	 document.getElementById("mlc_yn").value="N";
	 document.getElementById("postmortem_reqd_yn").value="N";
	}
	 if(document.getElementById("mode").value=="modify"||document.getElementById("mode").value=="viewdata")
	 {
	 
	 document.getElementById("postmortem_type").disabled=true;
	 if(document.getElementById("mode").value=="viewdata")
	 document.getElementById("mlc_yn").disabled=true;
	 }else
	{
	//document.getElementById("postmortem_reqd_yn").disabled=false;
	}
	
	}
	
	var postmortem_reqd_yn = document.getElementById("postmortem_reqd_yn").value;
	var CLAIMANT_TYPE = document.getElementById("CLAIMANT_TYPE").value;
	
	
	var HTMLVal = " <html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post'  action='../../eMO/jsp/MOPopulateArea.jsp' ><input type='hidden' name='postmortem_reqd_yn' id='postmortem_reqd_yn' value='"+postmortem_reqd_yn+"'><input type='hidden' name='area_code' id='area_code' value='"+areacode+"'><input type='hidden' name='startendstat' id='startendstat' value='"+startendstat+"'><input type='hidden' name='popareaforbprt' id='popareaforbprt' value='popareaforbprt'><input type='text' name='CLAIMANT_TYPE' id='CLAIMANT_TYPE' value='"+CLAIMANT_TYPE+"'></form></body></html>";
	parent.dummyframe1.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.dummyframe1.document.forms[0].submit();   
	
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

function checkserv1()
{
if(document.getElementById("mlc_yn").checked)
{
document.forms[0].conscentgivenby.value="";
document.forms[0].deceasedrelationship.value="";
document.forms[0].consent_received_by.value="";
document.forms[0].consent_received_date.value="";
document.forms[0].consent_received_desc.value="";
document.forms[0].consent_desc.value="";
document.forms[0].consent_form_code.value="";

}else
{  // document.getElementById("postmortem_reqd_yn").checked=false;
	//document.getElementById("postmortem_reqd_yn").disabled=false;
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
	//document.getElementById("Consent_forms").disabled=true;


}
}
function clearBed1()
{   
     document.forms[0].bed_no.value="";
	 document.forms[0].bed_no.disabled=true;
	 document.forms[0].bed_button.disabled=true;
}


function AEScrollIntoView(tabidx)
{
	if(tabidx == 1)
    {
		//document.getElementById("tab1").scrollIntoView();
		document.getElementById("tab1").scrollIntoView({
			  behavior: "smooth",
			  block: "nearest",
			  inline: "start"
			});
	 
    }
	else if(tabidx == 2)
	{
	 if((document.getElementById("postmortem_reqd_yn").checked==true)&&(document.getElementById("startendstat").value!="E"))
	 return;	
	 //document.getElementById("tab3").scrollIntoView();
	 document.getElementById("tab3").scrollIntoView({
		  behavior: "smooth",
		  block: "nearest",
		  inline: "start"
		});

	}
	else if(tabidx == 3)
	{  
         
	  // document.getElementById("tab2").scrollIntoView();
		document.getElementById("tab2").scrollIntoView({
			  behavior: "smooth",
			  block: "nearest",
			  inline: "start"
			});
	
	}
	
			
}


function blurRFID(obj){
	if(obj.value !=""){
		searchRFID(obj,document.forms[0].RFID_Tag);
	}
}

async function searchRFID(obj,target){
	var retVal =    new String(); 
	var area_code = "";
	var retVal = "";
	var dialogHeight= "90vh" ;
	var dialogWidth	= "80vw" ;
	var dialogTop ="60";
	var status = "no";
	var arguments	= " ";	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
    var retVal=await 	window.showModalDialog("../../eMO/jsp/RFIDTagFrameset.jsp?RFID_No="+document.forms[0].RFID_Tag.value,arguments,features);
	if(retVal != null && retVal != "" ){
	  document.forms[0].RFID_Tag.value=retVal;
	 }else{
		 document.forms[0].RFID_Tag.value="";
	 }
}


//changes for 38265
function enableManGif(){		 
 
	if(document.getElementById("burial_permit_reqd_yn").value=="N"){
		document.getElementById("bdbr1").style.visibility='hidden';
		/*Below line added for this CRF ML-MMOH-CRF-0695*/
		if(document.getElementById("bdbr2")) document.getElementById("bdbr2").style.visibility='hidden';
		//End this CRF ML-MMOH-CRF-0695
		if(document.getElementById("bdbr3")){
			document.getElementById("bdbr3").style.visibility='hidden';
		}
		document.getElementById("bdbr4").style.visibility='hidden';
		
	}else{
		document.getElementById("bdbr1").style.visibility='visible';
		
		/*Below line added for this CRF ML-MMOH-CRF-0695*/
		if(document.getElementById("datetimeofclaimingApplicable") && document.getElementById("datetimeofclaimingApplicable").value=="true"){		
		     if(document.getElementById("bdbr2")) document.getElementById("bdbr2").style.visibility='hidden';
		}else{
		     if(document.getElementById("bdbr2")) document.getElementById("bdbr2").style.visibility='visible';
		}
		//End this CRF ML-MMOH-CRF-0695 
		
		if(document.getElementById("bdbr3")){
			document.getElementById("bdbr3").style.visibility='visible';
		}
		document.getElementById("bdbr4").style.visibility='visible';
	}
} 

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



/*Added by Thamizh selvi on 27th July 2017 for ML-MMOH-CRF-0689 Start*/
async function openEmergRegn(){

	var retVal =  new String();
	var dialogTop= "60";
	var dialogHeight= "43" ;
	var dialogWidth = "75" ;
	var features  = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no; scroll=no";
	var arguments = "" ;
	var apply_oth_name = "N";

	var url="../../eMP/jsp/EmergRegn.jsp?apply_oth_name="+apply_oth_name+"&called_from=MO_EBP_REGN&func_act=Visitreg&module_id=MP&function_id=EM_PAT_REG&function_name=Emergency%20Patient&function_type=F&access=YYYNN";
		 
	retVal = await window.showModalDialog(url,arguments,features);
	
	document.getElementById("patiddis").style.visibility	= "visible";
	document.getElementById("patbtn").style.visibility	= "visible";
	document.getElementById("patman").style.visibility	= "visible";
	document.getElementById("lab1").innerHTML				= getLabel("Common.patientId.label","Common");
	
	if(retVal != null)
	{	
		document.getElementById("patientid").value	= retVal;
		document.getElementById("patbtn").disabled	= true;
		document.getElementById("patientid").disabled	= true;
		document.getElementById("patientid").onblur(); 

	}else{
		document.getElementById("patientid").value	= "";
		document.getElementById("patbtn").disabled	= false;
		document.getElementById("patientid").disabled	= false;
	}
	
}/*End*/

/*Added by Ashwini on 08-Aug-2017 for ML-MMOH-CRF-0748*/
function DisableBrghtByPolice(obj)
{
	if(obj.value == 'L'){
	document.getElementById("brought_by_police_yn").checked = false;
	document.getElementById("brought_by_police_yn").disabled = true;
	}else{
	if(document.getElementById("mode").value != "viewdata")
	document.getElementById("brought_by_police_yn").disabled = false;
	}	
}

function DisableRefTypeHlthCare()
{
	if(document.getElementById("brought_by_police_yn").checked){
	document.getElementById("refe_type").disabled = true;
	document.getElementById("refe_type").value = "";
	document.getElementById("hcare_type").disabled = true;
	document.getElementById("hcare_type").value = "";
	document.getElementById("referral_source").disabled = true;
	document.getElementById("referral_source").value = "";
	}else{
		if(document.getElementById("refe_type").value == "" && document.getElementById("mode").value != "viewdata")
		{
		document.getElementById("refe_type").disabled = false;
		document.getElementById("hcare_type").disabled = false;
		document.getElementById("referral_source").disabled = false;
		}else 
		{
		if(document.getElementById("mode").value != "viewdata")
		document.getElementById("refe_type").disabled = false;
		}
	}
}

function DisableRefTypeHlthCare1()
{
	if(frames[3].document.getElementById("brought_by_police_yn").checked){
	frames[3].document.getElementById("refe_type").disabled = true;
	frames[3].document.getElementById("refe_type").value = "";
	frames[3].document.getElementById("hcare_type").disabled = true;
	frames[3].document.getElementById("hcare_type").value = "";
	frames[3].document.getElementById("referral_source").disabled = true;
	frames[3].document.getElementById("referral_source").value = "";
	}else{
		if(frames[3].document.getElementById("refe_type").value == "" && frames[3].document.getElementById("mode").value != "viewdata")
		{
		frames[3].document.getElementById("refe_type").disabled = false;
		frames[3].document.getElementById("hcare_type").disabled = false;
		frames[3].document.getElementById("referral_source").disabled = false;
		}else 
		{
		if(frames[3].document.getElementById("refe_type").value == "L" && frames[3].document.getElementById("mode").value != "viewdata")
		{
		frames[3].document.getElementById("refe_type").disabled = false;
		frames[3].document.getElementById("hcare_type").disabled = true;
		frames[3].document.getElementById("referral_source").disabled = true;
		}
		}
	}
}
/*End*/

