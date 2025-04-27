function reset(){	
var function_id=frames[1].document.forms[0].function_id.value;	
var modify_wait_list_yn=frames[1].document.forms[0].modify_wait_list_yn.value;	
var currentdate=frames[1].document.forms[0].sys_date.value;	
var cancel_wait_list_yn=frames[1].document.forms[0].cancel_wait_list_yn.value;	
var oper_stn=frames[1].document.forms[0].oper_stn.value;	
var Patient_Id_Length=frames[1].document.forms[0].Patient_Id_Length.value;	
var install_yn=frames[1].document.forms[0].install_yn.value;	
frames[2].document.forms[0].Select.value=getLabel("Common.search.label","Common");
//parent.frames[2].document.getElementById("manage_wait_list").rows="7%,48%,6%,*,10%";
/*parent.frames[2].document.getElementById("commontoolbarFrame").style.height="7vh";
parent.frames[2].document.getElementById("f_query_add_mod").style.height="55vh";
parent.frames[2].document.getElementById("search_static").style.height="6vh";
parent.frames[2].document.getElementById("f_query_add_mod1").style.height="20vh";
parent.frames[2].document.getElementById("f_query_add_mod2").style.height="2vh";
parent.frames[2].document.getElementById("messageFrame").style.height="10vh";*/
document.getElementById("commontoolbarFrame").style.height="7vh";
document.getElementById("f_query_add_mod").style.height="55vh";
document.getElementById("search_static").style.height="6vh";
document.getElementById("f_query_add_mod1").style.height="20vh";
document.getElementById("f_query_add_mod2").style.height="2vh";
document.getElementById("messageFrame").style.height="10vh";


frames[3].location.href='../../eCommon/html/blank.html';
frames[4].location.href='../../eCommon/jsp/error.jsp';
frames[1].location.href="../../eOA/jsp/WaitListInvitationCriteria.jsp?function_id="+function_id+"&modify_wait_list_yn="+modify_wait_list_yn+"&cancel_wait_list_yn="+cancel_wait_list_yn+"&oper_stn_id="+oper_stn+"&currentdate="+currentdate+"&Patient_Id_Length="+Patient_Id_Length+"&install_yn="+install_yn;
 
frames[2].location.href='../../eOA/jsp/WaitListMgmtCriteria.jsp';

frames[1].document.getElementById("pract_type1").innerHTML="";
	}

async function callPatientSearch(){
 var patientId= await PatientSearch();
 if (patientId!=null && patientId!='')
  document.forms[0].patientid.value=patientId;
}
function populateLocation(obj){

var lbValue=obj.value;
var speciality=document.forms[0].speciality.value;
var oper_stn_id=document.forms[0].oper_stn.value;
if (lbValue!=null && lbValue!=''){

/*var HTML="<html><body onKeyDown = 'lockKey()'><form name='populateLocation1' id='populateLocation1' method='post'  action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='from' id='from' value='WaitListMgmt'><input type=hidden name='LBoxValue' id='LBoxValue' value='"+lbValue+"'><input type=hidden name='speciality' id='speciality' value='"+speciality+"'><input type='hidden' name='oper_stn_id' id='oper_stn_id' value='"+oper_stn_id+"'></form></body></html>";
	//alert(parent.parent.frames[3].name);
	parent.frames[4].document.body.insertAdjacentHTML('afterbegin',HTML);
	parent.frames[4].document.populateLocation1.submit();*/

	/*var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH speciality=\""+speciality+"\"  clinic_type=\""+lbValue+"\" steps='WaitListMgmt' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText) */


}


}
function practValidate(){

}

function enable_dis(obj){
	var selVal=obj.value;
	var locationType=document.forms[0].location.value;

	document.getElementById("location_code1").value= document.forms[0].locationType.value;
	document.getElementById("locationType1").value= document.forms[0].location.value;
	document.getElementById("specialty_code1").value= document.forms[0].speciality.value;

	if (selVal!='')
	{ 
	 document.forms[0].practitioner_name.disabled=false;
     document.forms[0].search_pract.disabled=false;
	}else{

      document.forms[0].practitioner_name.disabled=true;
	  document.forms[0].search_pract.disabled=true;
	  
	}
document.forms[0].practitioner_name.value='';
document.forms[0].b_pract.value='';
parent.frames[1].document.getElementById("pract_type1").innerText="";		


}
function ensureSpl(obj){
	
var spl_code=document.forms[0].speciality.value;
if (obj.value!=""){
	
if (spl_code!=""){
populateLocation(obj);
//enable_dis1(obj);
}else{

var error;
error=getMessage("CAN_NOT_BE_BLANK","common");
error=error.replace("$",getLabel("Common.speciality.label","Common"))
alert(error);
//alert("APP-000001 Speciality Should Not be Blank...");
//obj.options.selectedIndex=0;
document.forms[0].b_loc_val.value='';

}
}

}
function enable_dis1(obj){
	

document.forms[0].locationType.selectedIndex=0;
document.forms[0].resourceType.value='';
document.forms[0].practitioner_name.value='';
document.forms[0].b_pract.value='';
document.forms[0].practitioner_name.disabled=true;
document.forms[0].search_pract.disabled=true;
document.forms[0].resourceType.disabled=true;
//document.forms[0].b_pract_name.disabled=true;
//document.forms[0].b_pract_name.value='';
document.forms[0].b_loc_val.value="";

document.getElementById("pract_type1").innerHTML="";


if (obj.value=='')
{
	
	document.getElementById("b_loc_val").disabled=true;
	document.getElementById("b_loc_search").disabled=true ;
	document.getElementById("locationType").value="";
	document.forms[0].practitioner.value="";
	

	

}else{
	document.getElementById("b_loc_val").disabled=false ;
	document.getElementById("b_loc_search").disabled=false ;
}
/*Obj=document.forms[0].locationType;

while(Obj.options.length >0 ) Obj.remove(Obj.options[0]);
opt=document.createElement('OPTION');
opt.value='';
opt.text=" -------"+getLabel("Common.defaultSelect.label","Common")+"------ ";
Obj.add(opt);

}
 parent.frames[3].location.href='../../eCommon/html/blank.html';*/
}
function enable_dis2(obj){
	var selVal=obj.value;
	if (selVal!='')
	{
		
	   document.forms[0].practitioner_name.disabled=false;
       document.forms[0].search_pract.disabled=false;

	}else{
		
		
		document.forms[0].practitioner_name.disabled=true;
        document.forms[0].search_pract.disabled=true;
	}

}

function clear_vals()
{
	if(document.forms[0].or_catalogue_desc.value=='')
	{
		document.forms[0].or_catalogue_code.value='';
	}else{
		callORSearch();
	}
		

}

async function callORSearch()
{

	var p_speciality_code=document.forms[0].speciality.value;	
	//var dialogHeight= "29" ;
	//var dialogTop = "125" ;
	//var dialogWidth	= "50" ;
	var dialogHeight= "400px" ;
	var dialogTop = "10px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;

	var or_catalogue_desc=document.forms[0].or_catalogue_desc.value;

	
	var url="../../eOR/jsp/RefusalOrderOrderableFrameSet.jsp?searchText="+escape(or_catalogue_desc)+"&called_from=OA&mode="+MODE_INSERT+"&p_speciality_code="+p_speciality_code+"&table_name='AM_CATALOG_FOR_SPECIALITY_VW'&order_category=&order_type=";
	

	var retVal = new String();
	retVal = await window.showModalDialog(url,arguments,features);

	if(retVal){
		var secArr=retVal.split("&");
		document.forms[0].or_catalogue_code.value=secArr[0];
		document.forms[0].or_catalogue_desc.value=secArr[1];
	}else{
		document.forms[0].or_catalogue_code.value='';
		document.forms[0].or_catalogue_desc.value='';
	}
}




function callResult()
{
	
if(parent.frames[2].document.forms[0].Select.value==getLabel("Common.search.label","Common"))
	{
   parent.frames[3].location.href='../../eCommon/html/blank.html';
   specCode=parent.frames[1].document.forms[0].speciality.value;
   var alt_id1_no;
   var alt_id2_no;
   var alt_id3_no;
   var alt_id4_no;
   var alt_id1_type;
   var alt_id2_type;
   var alt_id3_type;
   var alt_id4_type;
   var other_alt_Id;
   var other_alt_type;
   var wtlt_category="";
   var wtlt_category_one;
   var url;
   var priority;
   var practitioner;
   if (specCode!=''){
    WaitListNo = parent.frames[1].document.forms[0].WaitListNo.value ;
    patientid	= parent.frames[1].document.forms[0].patientid.value ;
	patientname	= parent.frames[1].document.forms[0].patientName.value ;
	//alert("patientname="+patientname);
	practitioner	= parent.frames[1].document.forms[0].practitioner.value ;
	//alert("practitioner="+practitioner);
	gender		= parent.frames[1].document.forms[0].gender.value ;
	var val    = new Array() ;
	val = parent.frames[1].document.forms[0].locationType.value.split("$");
		
			
	if (val !=""){
	cliniccode = val[0].split("$");
	}else
  {
		cliniccode="";
	}

	practcode	= parent.frames[1].document.forms[0].b_pract.value ;
	waitListfrmdate	= parent.frames[1].document.forms[0].frmDate.value ;
	waitListTodate	= parent.frames[1].document.forms[0].ToDate.value ;
	wtlt_category_one= parent.frames[1].document.forms[0].walst_category_code.value ;
	if(parent.frames[1].document.forms[0].or_catalogue_code)
	   {
	wtlt_category= parent.frames[1].document.forms[0].or_catalogue_code.value ;
	   }
	priority= parent.frames[1].document.forms[0].priority.value;
	var oper_stn_id=parent.frames[1].document.forms[0].oper_stn.value ;
 var nat_id_code;
 var r_area;
var m_area;
var r_region;
var m_town;
var r_town;
var m_region;
	var elapsed_grace_period=parent.frames[1].document.forms[0].elapsed_grace_period.value ;
	
		if( parent.frames[1].document.forms[0].national_id_no)
	   {
	var nat_id_no= parent.frames[1].document.forms[0].national_id_no.value;
	   }
	   if(parent.frames[1].document.forms[0].alt_id1_no)
	   {
		alt_id1_no= parent.frames[1].document.forms[0].alt_id1_no.value;
	   }else 
	   {
		   alt_id1_no="";
	   }
	   if(parent.frames[1].document.forms[0].alt_id1_type)
	   {
	 alt_id1_type= parent.frames[1].document.forms[0].alt_id1_type.value;
	   }else
	   {
		   alt_id1_type="";
	   }
	   if(parent.frames[1].document.forms[0].alt_id2_no)
	   {
	 alt_id2_no= parent.frames[1].document.forms[0].alt_id2_no.value;
	   }else
	   {
		   alt_id2_no="";
	   }
	   if(parent.frames[1].document.forms[0].alt_id2_type)
	   {
	alt_id2_type= parent.frames[1].document.forms[0].alt_id2_type.value;
	   }else
	   {
		   alt_id2_type="";
	   }
	   if(parent.frames[1].document.forms[0].alt_id3_no)
	   {
	alt_id3_no= parent.frames[1].document.forms[0].alt_id3_no.value;
	   }else
	   {
		   alt_id3_no="";
	   }
	   if(parent.frames[1].document.forms[0].alt_id3_type)
	   {
	alt_id3_type= parent.frames[1].document.forms[0].alt_id3_type.value;
	   }else
	   {
		   alt_id3_type="";
	   }
	   if(parent.frames[1].document.forms[0].alt_id4_no)
	   {
	 alt_id4_no= parent.frames[1].document.forms[0].alt_id4_no.value;
	   }else
	   {
		   alt_id4_no="";
	   }
	   if(parent.frames[1].document.forms[0].alt_id4_type)
	   {
	alt_id4_type= parent.frames[1].document.forms[0].alt_id4_type.value;
	   }else
	   {
		   alt_id4_type="";
	   }
	   if(parent.frames[1].document.forms[0].other_alt_Id)
	   {
	 other_alt_Id=parent.frames[1].document.forms[0].other_alt_Id.value;
	   }else
	   {
		   other_alt_Id="";
	   }

	   if(parent.frames[1].document.forms[0].other_alt_type)
	   {
	other_alt_type=parent.frames[1].document.forms[0].other_alt_type.value;
	   }else
	   {
		 other_alt_type="";
	   }
	if(parent.frames[1].document.forms[0].nat_id_code)
	   {
	      nat_id_code=parent.frames[1].document.forms[0].nat_id_code.value;
	   }else
	   {
		   nat_id_code="";
	   }
	if(parent.frames[1].document.forms[0].r_area)
	   {
		 r_area=parent.frames[1].document.forms[0].r_area.value;
	   }else
	   {
		    r_area="";
	   }
	   if(parent.frames[1].document.forms[0].m_area)
	   {
		var m_area=parent.frames[1].document.forms[0].m_area.value;
	   }else
	   {
		    m_area="";
	   }
if(parent.frames[1].document.forms[0].r_region)
	   {
	 r_region=parent.frames[1].document.forms[0].r_region.value;
	   }else
	   {
		    r_region="";
	   }
	if(parent.frames[1].document.forms[0].m_region)
	   {
	 m_region=parent.frames[1].document.forms[0].m_region.value;
	   }

	if(parent.frames[1].document.forms[0].r_town)
	   {
	 r_town=parent.frames[1].document.forms[0].r_town.value;
	   }

	if(parent.frames[1].document.forms[0].m_town)
	   {
	 m_town=parent.frames[1].document.forms[0].m_town.value;
	   }
	var clinic_type=parent.frames[1].document.forms[0].location.value ;
	parent.frames[2].document.forms[0].Select.value=getLabel("Common.Collapse.label","Common");
	//parent.parent.frames[2].document.getElementById("manage_wait_list").rows="7%,9.4%,6%,*,10%";
/*parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height="7vh";
parent.parent.frames[2].document.getElementById("f_query_add_mod").style.height="55vh";
parent.parent.frames[2].document.getElementById("search_static").style.height="6vh";
parent.parent.frames[2].document.getElementById("f_query_add_mod1").style.height="20vh";
parent.parent.frames[2].document.getElementById("f_query_add_mod2").style.height="2v";
parent.parent.frames[2].document.getElementById("messageFrame").style.height="10vh";*/
parent.document.getElementById("commontoolbarFrame").style.height="7vh";
parent.document.getElementById("f_query_add_mod").style.height="8.3vh";
parent.document.getElementById("search_static").style.height="6vh";
parent.document.getElementById("f_query_add_mod1").style.height="66vh";
parent.document.getElementById("f_query_add_mod2").style.height="0vh";
parent.document.getElementById("messageFrame").style.height="12vh";
		var res_type=parent.frames[1].document.forms[0].resourceType.value ;
		var elaspsed=parent.frames[1].document.forms[0].elapswl.value;
		var ALCN_CRITERIA_YN=parent.frames[1].document.forms[0].ALCN_CRITERIA_YN.value;
 url='../../eOA/jsp/WaitListMgmtQueryResult.jsp?patientid='+patientid+"&patientname="+patientname+"&practitioner="+practitioner+"&gender="+gender+"&cliniccode="+cliniccode+"&practcode="+practcode+"&waitListfrmdate="+waitListfrmdate+"&waitListTodate="+waitListTodate+"&WaitListNo="+WaitListNo+"&oper_stn_id="+oper_stn_id+"&clinic_type="+clinic_type+"&res_type="+res_type+"&specCode="+specCode+"&elaspsed="+elaspsed+"&ALCN_CRITERIA_YN="+ALCN_CRITERIA_YN+"&elapsed_grace_period="+elapsed_grace_period+"&nat_id_no="+nat_id_no+"&alt_id1_no="+alt_id1_no+"&alt_id2_no="+alt_id2_no+"&alt_id3_no="+alt_id3_no+"&alt_id4_no="+alt_id4_no+"&other_alt_Id="+other_alt_Id+"&nat_id_code="+nat_id_code+"&r_area="+r_area+"		&m_area="+m_area+"&r_region="+r_region+"&m_region="+m_region+"&r_town="+r_town+"&m_town="+m_town+"&wtlt_category="+wtlt_category+"&wtlt_category_one="+wtlt_category_one+"&priority="+priority;
 //alert(url);

	parent.frames[3].location.href = url;
 
	parent.frames[4].location.href='../../eCommon/jsp/error.jsp';
   }else
	{
	   var error;
	   error=getMessage("CAN_NOT_BE_BLANK","common");
	   error=error.replace("$",	getLabel("Common.speciality.label","Common"))
		alert(error);
	}
   	}else
	{
			
			 parent.frames[2].document.forms[0].Select.value=getLabel("Common.search.label","Common");
			 //parent.parent.frames[2].document.getElementById("manage_wait_list").rows="7%,48%,6%,*,10%";
			/*parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height="7vh";
			parent.parent.frames[2].document.getElementById("f_query_add_mod").style.height="55vh";
			parent.parent.frames[2].document.getElementById("search_static").style.height="6vh";
			parent.parent.frames[2].document.getElementById("f_query_add_mod1").style.height="20vh";
			parent.parent.frames[2].document.getElementById("f_query_add_mod2").style.height="2vh";
			parent.parent.frames[2].document.getElementById("messageFrame").style.height="10vh";*/
			parent.document.getElementById("commontoolbarFrame").style.height="7vh";
			parent.document.getElementById("f_query_add_mod").style.height="55vh";
			parent.document.getElementById("search_static").style.height="6vh";
			parent.document.getElementById("f_query_add_mod1").style.height="20vh";
			parent.document.getElementById("f_query_add_mod2").style.height="0vh";
			parent.document.getElementById("messageFrame").style.height="10vh";

	}
}


function apply(){
	//alert("Nothing to Apply");
	frames[0].location.reload();
	frames[1].location.href='../../eCommon/html/blank.html';
	frames[2].location.href='../../eCommon/html/blank.html';
	frames[3].location.href='../../eCommon/jsp/error.jsp';
}
function ClearForms(){
//document.forms[0].reset();
parent.frames[3].location.href='../../eCommon/html/blank.html';
parent.frames[4].location.href='../../eCommon/jsp/error.jsp';
//document.forms[0].Select.disabled=false;
//parent.frames[1].document.getElementById("pract_type1").innerHTML="";
//document.forms[0].b_pract.value='';

}

function cancleWiatListappt(waitListNo){
var lbValue=waitListNo;
var reason=document.forms[0].reason_cancel_code.value;

/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
/*Commented by KAMATCHI S for ML-MMOH-CRF-1390*/
/*if(document.forms[0].remarks_img.style.visibility == 'visible')
{*/
	var other_remarks = document.forms[0].other_remarks.value;
/*}else
{
	var other_remarks = "";
}*/
/*End ML-MMOH-CRF-1114*/

var tosubmit=true;

	if(document.forms[0].reason_for_cancellation.value =="")
	{
		var error=getMessage("REASON_NOT_BLANK","OA");
	
		alert(error);
		tosubmit=false;
	}
	
	/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
	if(document.forms[0].remarks_img.style.visibility == 'visible' && document.forms[0].other_remarks.value == "")
	{
		var error = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$',getLabel("Common.remarks.label","Common"));
	
		alert(error);
		tosubmit=false;
	}
	/*End ML-MMOH-CRF-1114*/

if (lbValue!=null && lbValue!='' ){
	
	
	if(tosubmit)
	{
	var HTML="<html><body onKeyDown = 'lockKey()'><form name='populateLocation' id='populateLocation' method='post'  action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='from' id='from' value='WaitListMgmtCancel'><input type=hidden name='LBoxValue' id='LBoxValue' value='"+lbValue+"'><input type='hidden' name='reason_code' id='reason_code' value='"+reason+"'><input type='hidden' name='other_remarks' id='other_remarks' value='"+other_remarks+"'></form></body></html>"; //Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	
	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTML);
	parent.messageFrame.document.populateLocation.submit();
	//parent.f_query_add_mod1.location.reload();
	}
}
}

function onSuccess(){
}

function checkColon(dt){
	
 var dtArr=dt.split(' ');
 time=dtArr[1];
 charAtpos3=time.charAt(2);
 
 if (charAtpos3 == ':')
   return true;
	 else
   return false;
 
}

/*function validatePrefDate(obj){
	if (obj.value!=''&& obj.value!=null){
		
		
		if(checkDt(obj.value)){
curDt= new Date();
var from = curDt.getDate()+"/"+(curDt.getMonth()+1)+"/"+curDt.getFullYear();
var to=obj.value;

var fromarray; var toarray;

    var fromdate = from ;
    var todate = to ;
	
	
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
			
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
				
            if(Date.parse(todt) < Date.parse(fromdt)) {
				
				alert(getMessage("PRF_DATE_NOT_GR_CURR_DATE","Common"));
				obj.focus();
				
                return false;
            }
            else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
    
return true;
		}else
		{
alert(getMessage("INVALID_DATE_FMT","SM"));
 obj.value='';
 obj.focus();
		}
	}

}*/

function modifyWiatListappt(){
waitListNo=document.forms[0].waitlist_no.value;
b_pract=document.forms[0].b_pract.value;
var preferredDate="";
var clinicCode="";
var open_to_all_pract_yn="";
preferredDate=document.forms[0].preferred_date.value;
status=document.forms[0].status.value;
var wait_list_ref_no=document.forms[0].wait_list_ref_no.value;
var clinic_Code="";
clinic_Code=document.forms[0].clinic_code.value;

var clinicCode="";
var open_to_all_pract_yn="";

if(clinic_Code !="")
	{
var val=clinic_Code.split("|");
		 clinicCode=val[1];
		 open_to_all_pract_yn= val[0];
	}

resourceid=document.forms[0].practitioner.value;
resource=document.forms[0].resourceType1.value;
elapsed=document.forms[0].elapsed.value;
var preferredDate_gerg="";

if(preferredDate !="")
{
	 preferredDate_gerg=convertDate(preferredDate,"DMY",localeName,"en");
}

var category;
if(document.forms[0].or_catalogue_code)	
	{
category=document.forms[0].or_catalogue_code.value;
	}
var category_one=document.forms[0].walst_category_code.value;
var waitlist_category_reqd_yn=document.forms[0].waitlist_category_reqd_yn.value;
var patient_id=document.forms[0].patientid.value;
var speciality_code=document.forms[0].speciality_code.value;
var waitlist_cat_one_code = document.forms[0].waitlist_cat_one_code.value;
var reason_code=document.forms[0].reason_modify_code.value;

/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
/*Commented by KAMATCHI S for ML-MMOH-CRF-1390*/
/*if(document.forms[0].remarks_img.style.visibility == 'visible')
{*/
	var other_remarks = document.forms[0].other_remarks.value;
/*}else
{
	var other_remarks = "";
}*/
/*End ML-MMOH-CRF-1114*/

var lbValue=waitListNo;
var msg='';
var err='';
var flag=0;
var flag2=0;
var flag3=0;
if(elapsed=="Y")
{
	if (preferredDate=='')
	{
		flag=1;
		flag3=1;
		err=getMessage("CAN_NOT_BE_BLANK","Common");
		msg+=err.replace("$",getLabel("Common.PreferredDate.label","Common"))+"\n";
		
	}
}
if(status==null ||  status=="")
	{
	flag=1;
	flag3=1;
	err=getMessage("CAN_NOT_BE_BLANK","Common");
	msg+=err.replace("$",getLabel("Common.status.label","Common"))+"\n";
	
}
if(reason_code=="")
{	
	flag=1;
	flag3=1;
	err=getMessage("CAN_NOT_BE_BLANK","Common");
	msg+=err.replace("$",getLabel("eOA.ReasonforModification.label","OA"))+"\n";
	
}

/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
if(document.forms[0].remarks_img.style.visibility == 'visible' && document.forms[0].other_remarks.value == "")
{
	flag=1;
	flag3=1;
	err=getMessage("CAN_NOT_BE_BLANK","Common");
	msg+=err.replace("$",getLabel("Common.remarks.label","Common"))+"\n";
}
/*End ML-MMOH-CRF-1114*/


if(waitlist_category_reqd_yn=='Y')
		{
			if (document.forms[0].walst_category.value=='')
			{
				flag=1;
				flag2=1;
				flag3=1;
			err=getMessage("CAN_NOT_BE_BLANK","Common");
			msg+=err.replace("$",getLabel("eOA.WaitlistCategory.label","OA"))+"\n";
			
			}

		}


if(flag2==0 && flag==0)	{
			if(document.forms[0].restrict_wl_cat_agst_splty_yn.value=="Y")
			{

				if (document.forms[0].waitlist_category_reqd_yn.value=="Y" || patient_id !=null || patient_id !="")
				{
				var xmlDoc = ""
				var xmlHttp = new XMLHttpRequest()
				xmlStr	="<root><SEARCH spl_code=\""+speciality_code+"\" patient_id=\""+patient_id+"\" categ_code=\""+category_one+"\" waitlist_cat_one_code=\""+waitlist_cat_one_code+"\" steps='RESTRICT_WAIT_LIST_ONE'/></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","ServerSide.jsp",false)
				xmlHttp.send(xmlDoc)
				responseText=xmlHttp.responseText
				eval(responseText);
				if(resrt_wtlst_Flag1==1)
				{
					var error=getMessage("OPEN_WAITLIST","OA");
					flag=1;
					alert(error);
				}else
				{
					flag=0;
				}

				}else
				{
					flag=0;
				}

			}else
			{
				flag=0;
			}
if(preferredDate !="")
{
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr	="<root><SEARCH locncode=\""+clinicCode+"\" practid=\""+resourceid+"\" date_val=\""+preferredDate_gerg+"\" steps='validatepref_date_wait_list'/></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		eval(responseText)
		if(wtlt_Flag==1)
			{
				var error=getMessage("WAIT_LIST_NOT_ALLW","OA");
				alert(error);
				flag=1;
			}

		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr	="<root><SEARCH date_val=\""+preferredDate_gerg+"\" clinic_code=\""+clinicCode+"\" steps='validatepref_date_sunday'/></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		eval(responseText)
		//alert("sunday_flag :"+sunday_flag);

		if(sunday_flag==1)
		{
			var error=getMessage("WAITLIST_NOT_ALL_SUNDAY","OA");
			alert(error);
			flag=1;
		}

}else
{
	flag=0;
}


}
if (flag==0  ){
if (lbValue!=null && lbValue!=''){

			var HTML="<html><body onKeyDown = 'lockKey()'><form name='populateLocation' id='populateLocation' method='post'  action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='from' id='from' value='WaitListMgmtModify'><input type=hidden name='reason_modify_code' id='reason_modify_code' value='"+reason_code+"'><input type=hidden name='LBoxValue' id='LBoxValue' value='"+lbValue+"'><input type='hidden' name='preferredDate' id='preferredDate' value='"+preferredDate_gerg+"'><input type='hidden' name='status' id='status' value='"+status+"'><input type='hidden' name='clinicCode' id='clinicCode' value='"+clinicCode+"'><input type='hidden' name='resourceid' id='resourceid' value='"+resourceid+"'><input type='hidden' name='resource' id='resource' value='"+resource+"'><input type='hidden' name='elapsed' id='elapsed' value='"+elapsed+"'><input type='hidden' name='wait_list_category' id='wait_list_category' value='"+category_one+"'><input type='hidden' name='odrer_category' id='odrer_category' value='"+category+"'><input type='hidden' name='wait_list_ref_no' id='wait_list_ref_no' value='"+wait_list_ref_no+"'><input type=hidden name='remarks_for_modify' id='remarks_for_modify' value='"+other_remarks+"'></form></body></html>"; //Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
			//alert("HTML===="+HTML);
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTML);
			parent.messageFrame.document.populateLocation.submit();;


}
}
if(flag3==1){
	alert(msg);
	if (preferredDate=='')
	{
		document.forms[0].preferred_date.focus();
	}else
	{
		//document.forms[0].status.focus();
	}
}
}

/*function validate_date(ref) {
                
        var error_id;    
	if(ref == "FROM_DATE_LESS_SYSDATE" )
	{
	    from = parent.frames[1].document.forms[0].frmDate;
	    to = parent.frames[1].document.forms[0].sys_date;
	    error_id = getMessage('FROM_DATE_LESS_SYSDATE','SM');
	    	    	    		
	}
	else if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = parent.frames[1].document.forms[0].ToDate;
	  to = parent.frames[1].document.forms[0].frmDate;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','SM');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = parent.frames[1].document.forms[0].ToDate;
	  to = parent.frames[1].document.forms[0].frmDate;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','SM');
	}
	var fromarray;
	var toarray;
	var fromdate = eval(from).value ;
	var todate = eval(to).value ;
	
	if(fromdate.length > 0 && todate.length > 0 ) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)) {
		   
		   parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+ error_id;
		   from.focus();
		}
		else if(Date.parse(todt) <= Date.parse(fromdt))
		     {
		       parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
		       return true;
		      } 
	}
	return true;
}
*/

function dispPrimaryResource(){
document.getElementById("pract_type1").innerHTML="";
locn_type=document.forms[0].location.value;
				var val    = new Array() ;
			val = document.forms[0].locationType.value.split("$");
			var clinicCode="";
	if (val !=""){
			 clinicCode=val[0].split("$");
			}
			
var lbValue="";
if (clinicCode!=''){
if ( locn_type!='N'){

/*var HTML="<html><body onKeyDown = 'lockKey()'><form name='modifyWaitList' id='modifyWaitList' method='post'  action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='from' id='from' value='WaitListMgmtModifyWindow'><input type=hidden name='LBoxValue' id='LBoxValue' value='"+lbValue+"'><input type=hidden name='clinicCode' id='clinicCode' value='"+clinicCode+"'><input type=hidden name='locn_type' id='locn_type' value='"+locn_type+"'></form></body></html>";
parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTML);
parent.messageFrame.document.modifyWaitList.submit();*/


		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH clinic_type=\""+locn_type+"\" clinic_code1=\""+clinicCode+"\" steps='managewaitlistreso' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText)


}
/*else if (locn_type=='D') {
	parent.frames[1].document.forms[0].resource.value="B";
	parent.frames[1].document.getElementById("pract_type1").innerHTML="Bed"
}
*/else if (locn_type=='N') {
parent.frames[1].document.forms[0].resourceType.value="P";
parent.frames[1].document.getElementById("pract_type1").innerHTML=getLabel("Common.practitioner.label","Common");
}
}

}


function elapswlClick(Obj){
	if (Obj.checked==true)
	{
	 Obj.value='Y';
	 document.forms[0].frmDate.value="";
	 document.forms[0].ToDate.value="";
	 document.forms[0].frmDate.disabled=true;
	 document.forms[0].ToDate.disabled=true;
	 document.getElementById("img1").disabled=true;
	 document.getElementById("img2").disabled=true;
	}else{
	 Obj.value='N';
	 document.forms[0].frmDate.disabled=false;
	 document.forms[0].ToDate.disabled=false;
	 document.getElementById("img1").disabled=false;
	 document.getElementById("img2").disabled=false;
	}

}


function getFocus()
{
	document.forms[0].speciality.focus();
}


async function show_ModifyWin(wait_list_no,elapsed)
{
	var oper_stn_id=document.forms[0].oper_stn_id.value;
	var ALCN_CRITERIA_YN=document.forms[0].ALCN_CRITERIA_YN.value;
	var modify_wait_list_yn=parent.frames[1].document.forms[0].modify_wait_list_yn.value;
	var waitlist_category_reqd_yn=parent.frames[1].document.forms[0].waitlist_category_reqd_yn.value;
	var waitlist_category_appl_yn=parent.frames[1].document.forms[0].waitlist_category_appl_yn.value;
	var restrict_wl_cat_agst_splty_yn=parent.frames[1].document.forms[0].restrict_wl_cat_agst_splty_yn.value;
	var install_yn=parent.frames[1].document.forms[0].install_yn.value;
	
	var reason_for_modify=document.forms[0].reason_for_modify.value;
	if(modify_wait_list_yn =="N")
	{
		alert(getMessage('OPER_STN_FUNC_RESTRN','OA'));
	}else
	{
	var dialogHeight= "100vh" ;
	var dialogTop = "85" ;
	var dialogWidth	= "80vw" ;
	var status = "no";
	//var BACKGROUNDCOLOR = "#e2e3f0";

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	
	//var callurl="../../eOA/jsp/WaitListModifyFrame.jsp?waitlist_no="+wait_list_no+"&elapsed="+elapsed+"&oper_stn_id="+oper_stn_id+"&ALCN_CRITERIA_YN="+ALCN_CRITERIA_YN+"&reason_for_modify="+reason_for_modify+"&waitlist_category_reqd_yn="+waitlist_category_reqd_yn+"&waitlist_category_appl_yn="+waitlist_category_appl_yn+ "&restrict_wl_cat_agst_splty_yn= "+restrict_wl_cat_agst_splty_yn+"&install_yn="+install_yn;

	var callurl="../../eOA/jsp/WaitListModifyFrame.jsp?waitlist_no="+wait_list_no+"&elapsed="+elapsed+"&oper_stn_id="+oper_stn_id+"&ALCN_CRITERIA_YN="+ALCN_CRITERIA_YN+"&waitlist_category_reqd_yn="+waitlist_category_reqd_yn+"&waitlist_category_appl_yn="+waitlist_category_appl_yn+ "&restrict_wl_cat_agst_splty_yn= "+restrict_wl_cat_agst_splty_yn+"&install_yn="+install_yn;
	var retVal = new String();


	retVal = await window.showModalDialog(callurl,arguments,features);
		parent.frames[3].location.reload();

	callResult();
	}
}

async function show_CancelWin(waitListNo) 
{
	/*var flag=window.confirm("APP-OA0173 Do you want to Cancel the Wait List");
	if (flag){		
		cancleWiatListappt(waitListNo);
	}*/


	
	var oper_stn_id=document.forms[0].oper_stn_id.value;
	var ALCN_CRITERIA_YN=document.forms[0].ALCN_CRITERIA_YN.value;
	var elapsed=parent.frames[1].document.forms[0].elapswl.value;
	var cancel_wait_list_yn=parent.frames[1].document.forms[0].cancel_wait_list_yn.value;
	var install_yn=parent.frames[1].document.forms[0].install_yn.value;
	
	if(cancel_wait_list_yn =="N")
	{
		alert(getMessage('OPER_STN_FUNC_RESTRN','OA'));
	}else
	{
	var dialogHeight= "100vh" ;
	var dialogTop = "30" ;
	var dialogWidth	= "80vw" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var callurl="../../eOA/jsp/WaitListCancelFrame.jsp?waitlist_no="+waitListNo+"&oper_stn_id="+oper_stn_id+"&ALCN_CRITERIA_YN="+ALCN_CRITERIA_YN+"&elapsed="+elapsed+"&install_yn="+install_yn;
	var retVal = new String();
	
	retVal = await window.showModalDialog(callurl,arguments,features);
	parent.frames[3].location.reload();
	callResult();
}
}

function callMouseOver(obj)
{
	currClass = obj.className ;
	obj.className = 'OASUSPENDED';
}

function callOnMouseOut(obj)
{
	obj.className = currClass; 
}
var waitListNo="";
function hideToolTip(obj)
{
	if(obj == waitListNo){
	}else{
		document.getElementById("tooltiplayer").style.visibility = 'hidden';
		waitListNo=obj;
	}
}

async function show_TransferWin(waitListNo,patientId,preferedDate,speciality,careLocnTypeInd,clinicCode,resClass,resourceId,rd_waitlist_yn,web_request_yn,patient_name_yn)
{ 
		if(waitListNo=='*') waitListNo='';
		if(patientId=='*') patientId='';
		if(preferedDate=='*') preferedDate='';
		if(speciality=='*') speciality='';
		if(careLocnTypeInd=='*') careLocnTypeInd='';
		if(clinicCode=='*') clinicCode='';
		if(resClass=='*') resClass='';
		if(resourceId=='*') resourceId='';
		var continue_flag=true;
		if(patient_name_yn=="N"){
			alert("Insufficient Patient Demographic Details")
		}else{
	
		if(careLocnTypeInd!='N')
		{
			if(web_request_yn=="Y" && patientId!=""){
				var no_show_flag=false;
				var xmlDoc = ""
				var xmlHttp = new XMLHttpRequest()
				xmlStr	="<root><SEARCH patient_id=\""+patientId+"\" preferedDate=\""+preferedDate+"\" splty='"+speciality+"' steps='web_req_noshow'/></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","ServerSide.jsp",false)
				xmlHttp.send(xmlDoc)
				responseText=xmlHttp.responseText
				eval(responseText);
				if(document.forms[0].web_no_show_flag.value=='true'){
					if(window.confirm('There is no show appointments for this patient.Do you want to continue?')){
						continue_flag=true;
					}else{
						continue_flag=false;
					}
				}
			}
				if(continue_flag){
				var retVal = 	new String();
				var dialogHeight= "85vh" ;
				var dialogTop = "85" ;
				var dialogWidth	= "80vw" ;
				var dialogLeft   = "0";
			
				var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
				var arguments    = "" ;	
				var url="../../eOA/jsp/CAOAAppointment.jsp?i_practitioner_id="+resourceId+"&i_clinic_code="+clinicCode+"&recall_date="+preferedDate+"&locn_type="+careLocnTypeInd+"&specialty_code="+speciality+"&callingMode=OP&	waitListNo="+waitListNo+"&resource_class="+resClass+"&from_wait_list=Y&clinic_code="+clinicCode+"&from_AE=N&care_locn_ind="+careLocnTypeInd+"&web_request_yn="+web_request_yn+"&patient_id="+patientId+"&rd_appt_yn="+rd_waitlist_yn;
				retVal 	 	 = await window.showModalDialog(url,arguments,features);
				
				if (retVal != null)
				{
						var returnVal = retVal.split("^");
						var mode = returnVal[0];
						h = returnVal[1];
						
					if (mode=="1")
					{
						h=h+"&title="+encodeURIComponent(getLabel("Common.bookappointment.label","Common"));
						features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
						arguments    = "" ;	
						retVal = await window.showModalDialog("../../eOA/jsp/SinglePractVwNew.jsp?"+h,arguments,features);
					}else if (mode=="2")
					{
							h=h+ "&title="+encodeURIComponent(getLabel("Common.bookappointment.label","Common"));
							features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
							arguments    = "" ;	
							retVal = await window.showModalDialog("../../eOA/jsp/MultiPract2VwMain.jsp?"+h,arguments,features);
						
					}else if (mode=="3")
					{
							h=h+ "&title="+encodeURIComponent(getLabel("Common.bookappointment.label","Common"));
							features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
							arguments    = "" ;	
							retVal = await window.showModalDialog("../../eOA/jsp/MultiPract3VwMain.jsp?"+h,arguments,features);
								
						}
							if(retVal=='OP'){
							show_TransferWin(waitListNo,patientId,preferedDate,speciality,careLocnTypeInd,clinicCode,resClass,resourceId)

						}else{
							parent.frames[3].location.reload();
							callResult();
							clear_session();
							}
					}else{
						clear_session();
					 }
				}
			}else{ // call IP 
				var retVal="";
				var dialogHeight= "45" ;
				var dialogTop = "85" ;
				var dialogWidth	= "65" ;
				var status		= "no";
				var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
				var arguments    = "" ;	

				var url="../../eIP/jsp/Booking.jsp?is_oa_yn=Y&wait_lst_ref_no="+waitListNo+"&oa_pref_date_time="+escape(preferedDate)+"&oa_patient_id="+patientId;

				retVal 	 	 = await window.showModalDialog(url,arguments,features);
				parent.frames[3].location.reload();
				callResult();
			}
		}
	}

function clear_session()
{
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH steps='CLR_SESSION' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
}
	
function callDummy()
{
}

function displayToolTip(waitListNo,patientId,preferedDate,resourceClass,resource,careLocnTypeInd,clinicCode,resourceId,specialityCode,resClass,order_catalog_code,web_request_yn,patient_name_yn,rd_waitlist_yn) 
{ 
		if(document.forms[0].wtListControl && document.forms[0].wtListControl.value=='B'){
			var retVal = 	new String();
			var dialogHeight= "40" ;
			var dialogTop = "90" ;
			var dialogWidth	= "90" ;
			var dialogLeft   = "0";
			
			// sample url data from schedule appointment function to single day schedule when waitlist is without patient id
			//retVal 1:practitioner_id=MAHESHP&clinic_code=FCRD&Date=01/07/2012&ca_patient_id=&ca_mode=ca_mode&callingMode=OP&clinic_type=C&res_type=P&order_id=&order_line_num=&order_catalog_code=&oper_stn_id=ALL&slot_appt_ctrl=S&visit_limit_rule=M&alcn_criteria=&override_no_of_slots_yn=Y&req_id=&from_OR=N&create_wait_list_yn=Y&visit_flag_OP=N&capture_fin_dtls_yn=N&speciality=FCRD&practitioner_old=&clinic_old=&practitioner_type=&or_catalogue_code=&pref_start_date=01/07/2012&pref_end_date=01/07/2012&care_locn_ind=C&no_dwm=&visittype=&dwm_desc=D&from_page=&install_yn_val=Y&noshow_ctrl_by_splty_or_clinic=S&min_ela_per_resc_noshow_in_day=1&from_facility_id=&from_encounter_id=&contact_num_reqd_yn=N&no_of_noshow_appts_for_alert=1&per_chk_for_no_show_alert=85&calledFrom=&position=&addtl_splty=&patient_id_temp=&first_name_temp=&second_name_temp=&third_name_temp=&family_name_temp=&gender_temp=&contact_no_temp=&rule_appl_yn=N&nationality_code_temp=&language_code_temp=&term_set_id=&linking_code=
			
			var url = "title="+encodeURIComponent(getLabel("Common.bookappointment.label","Common"));
			url = url+"&practitioner_id="+parent.wiatListCriteria.waitlist_criteria.practitioner_id.value;// dynamic data
			url = url+"&clinic_code="+parent.wiatListCriteria.waitlist_criteria.clinnic_code.value;// dynamic data
			url = url+"&Date="+parent.wiatListCriteria.waitlist_criteria.appt_date.value;// dynamic data
			url = url+"&ca_patient_id=";// dynamic data and need to check wait list with patient id
			url = url+"&ca_mode=ca_mode";//hard coded
			url = url+"&callingMode=OP";//hard coded 
			url = url+"&clinic_type="+parent.wiatListCriteria.waitlist_criteria.clinic_type.value;// dynamic data
			url = url+"&res_type="+parent.wiatListCriteria.waitlist_criteria.res_type.value;// dynamic data 
			url = url+"&order_id=";//hard coded and need to check with or orders			
			url = url+"&order_line_num=";//hard coded and need to check with or orders
			url = url+"&order_catalog_code=";//hard coded and need to check with or orders
			url = url+"&oper_stn_id="+parent.wiatListCriteria.waitlist_criteria.oper_stn_id.value;//dynamic data
			url = url+"&slot_appt_ctrl="+parent.wiatListCriteria.waitlist_criteria.slot_appt_ctrl.value;//dynamic data 
			url = url+"&visit_limit_rule="+parent.wiatListCriteria.waitlist_criteria.visit_limit_rule.value;//dynamic data
			url = url+"&alcn_criteria="+parent.wiatListCriteria.waitlist_criteria.alcn_criteria.value;//dynamic data
			url = url+"&override_no_of_slots_yn="+parent.wiatListCriteria.waitlist_criteria.override_no_of_slots_yn.value;//dynamic data
			url = url+"&req_id=";//hard coded and need to check
			url = url+"&from_OR=N";//hard coded
			url = url+"&create_wait_list_yn="+parent.wiatListCriteria.waitlist_criteria.create_wait_list_yn.value;//dynamic data	
			url = url+"&visit_flag_OP=N";//hard coded and need to check
			url = url+"&capture_fin_dtls_yn="+parent.wiatListCriteria.waitlist_criteria.capture_fin_dtls_yn.value;//dynamic data 
			url = url+"&speciality="+parent.wiatListCriteria.waitlist_criteria.specialty_code.value;//dynamic data 
			url = url+"&practitioner_old=";//hard coded
			url = url+"&clinic_old=";//hard coded  
			url = url+"&practitioner_type=";//hard coded need to check
	//		url = url+"&or_catalogue_code=";//dynamic data
			url = url+"&pref_start_date=";//hard coded	
			url = url+"&pref_end_date=";//hard coded
			url = url+"&care_locn_ind=";//dynamic data
			url = url+"&no_dwm=";//hard coded
			url = url+"&visittype=";//hard coded	
			url = url+"&dwm_desc=";//hard coded	
			url = url+"&from_page=";//hard coded
			url = url+"&install_yn_val="+parent.wiatListCriteria.waitlist_criteria.install_yn_val.value;//dynamic data
			url = url+"&noshow_ctrl_by_splty_or_clinic="+parent.wiatListCriteria.waitlist_criteria.noshow_ctrl_by_splty_or_clinic.value;//dynamic data 
			url = url+"&min_ela_per_resc_noshow_in_day="+parent.wiatListCriteria.waitlist_criteria.min_ela_per_resc_noshow_in_day.value;//dynamic data 
			url = url+"&contact_num_reqd_yn="+parent.wiatListCriteria.waitlist_criteria.contact_num_reqd_yn.value;//dynamic data 
			url = url+"&no_of_noshow_appts_for_alert="+parent.wiatListCriteria.waitlist_criteria.no_of_noshow_appts_for_alert.value;//dynamic data
			url = url+"&per_chk_for_no_show_alert="+parent.wiatListCriteria.waitlist_criteria.per_chk_for_no_show_alert.value;//dynamic data 
			url = url+"&rule_appl_yn="+parent.wiatListCriteria.waitlist_criteria.rule_appl_yn.value;//dynamic data
			url = url+"&from_facility_id=";//hard coded
			url = url+"&from_encounter_id=";//hard coded
			url = url+"&calledFrom=";//hard coded
			url = url+"&position=";//hard coded
			url = url+"&addtl_splty=";//hard coded
			url = url+"&patient_id_temp=";//hard coded
			url = url+"&first_name_temp=";//hard coded
			url = url+"&second_name_temp=";//hard coded
			url = url+"&third_name_temp=";//hard coded
			url = url+"&family_name_temp=";//hard coded
			url = url+"&gender_temp=";//hard coded
			url = url+"&contact_no_temp=";//hard coded
			url = url+"&nationality_code_temp=";//hard coded
			url = url+"&language_code_temp=";//hard coded
			url = url+"&term_set_id=";//hard coded
			url = url+"&linking_code=";//hard coded
			url = url+"&wtListControl="+document.forms[0].wtListControl.value;
			url = url+"&rd_appt_yn="+document.forms[0].rd_appt_yn.value;
			url = url+"&waitListNo="+waitListNo;
			url = url+"&or_catalogue_code="+order_catalog_code;
			url = url+"&rd_waitlist_yn="+rd_waitlist_yn;
			if(parent.wiatListCriteria.waitlist_criteria.book_appt_yn.value=='Y'){
				features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
				arguments    = "" ;
				window.showModalDialog("../../eOA/jsp/SinglePractVwWrapper.jsp?"+url,arguments,features);
				
			}else{
			}	
			document.forms[0].submit();			
			//features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
			//arguments    = "" ;	
			//retVal = window.showModalDialog("../../eOA/jsp/SinglePractVwNew.jsp?"+url,arguments,features);
		}else{
			if (waitListNo=='') waitListNo='*';
			if (patientId=='') patientId='*';
			if (preferedDate=='') preferedDate='*';
			if (resourceClass=='') resourceClass='*';
			if (resource=='') resource='*';
			if (careLocnTypeInd=='') careLocnTypeInd ='*';
			if (clinicCode=='') clinicCode='*';
			if (resourceId=='') resourceId='*';
			if (specialityCode=='') specialityCode='*';
			if (resClass=='') resClass='*';

			buildTable(waitListNo,patientId,preferedDate,resourceClass,resource,careLocnTypeInd,clinicCode,resourceId,specialityCode,resClass,web_request_yn,patient_name_yn,rd_waitlist_yn) 
			bodwidth  = parent.parent.frames[1].document.body.offsetWidth
			bodheight = parent.parent.frames[1].document.body.offsetHeight
			//Modified against INC:49319
			var x 	  = event.clientX
			var y 	  = event.clientY;
			
			x 	  = x + (document.getElementById("tooltiplayer").offsetWidth)
			y 	  = y + (document.getElementById("tooltiplayer").offsetHeight)

			if(x<bodwidth)
				x = event.clientX 			//Modified against INC:49319
			else
				x = x - (document.getElementById("tooltiplayer").offsetWidth)
			if(y<bodheight)
				y = event.clientY			//Modified against INC:49319
			else
				y = y - (document.getElementById("tooltiplayer").offsetHeight)
					
			y+=document.body.scrollTop
			x+=document.body.scrollLeft
			x = 76;
			document.getElementById("tooltiplayer").style.left= x+"px";
			document.getElementById("tooltiplayer").style.top = y-15+"px";
			document.getElementById("tooltiplayer").style.visibility='visible' ;
		}
}

function buildTable(waitListNo,patientId,preferedDate,resourceClass,resource,careLocnTypeInd,clinicCode,resourceId,specialityCode,resCalss,web_request_yn,patient_name_yn,rd_waitlist_yn)
{ 

	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"
	tab_dat     += "<tr>";
	tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:show_CancelWin('"+waitListNo+"')>"+getLabel("Common.CancelWaitList.label","Common")+"</a></td>";	//Developed for Demo	
	//tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:show_CancelWin('"+waitListNo+"')>"+getLabel("Common.CancelWaitList.label","Common")+"</a></td>";		
	tab_dat     += "</tr>";
	tab_dat     += "<tr>";
	if(web_request_yn=='N'){
	tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:show_ModifyWin('"+waitListNo+"','N')>"+getLabel("Common.ModifyWaitList.label","Common")+"</a></td>";		
	tab_dat     += "</tr>";
	tab_dat += "<tr><td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:show_TransferWin('"+waitListNo+"','"+patientId+"','"+preferedDate+"','"+specialityCode+"','"+careLocnTypeInd+"','"+clinicCode+"','"+resCalss+"','"+resourceId+"','"+rd_waitlist_yn+"')>"+getLabel("Common.create.label","Common")+" "+getLabel("Common.booking.label","Common")+"</a></td>";
	}else{
	tab_dat += "<tr><td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:show_TransferWin('"+waitListNo+"','"+patientId+"','"+preferedDate+"','"+specialityCode+"','"+careLocnTypeInd+"','','"+resCalss+"','"+resourceId+"','"+rd_waitlist_yn+"','"+web_request_yn+"','"+patient_name_yn+"')>"+getLabel("Common.create.label","Common")+" "+getLabel("Common.booking.label","Common")+"</a></td>";
	}
	tab_dat     += "</tr>";
	tab_dat     += "</table>";
	document.getElementById("t").innerHTML = tab_dat;
	
}

function scrollTitle()
{

  var x = document.body.scrollTop;
  if(x == 0){
	 
 //  document.getElementById("header").style.position='static';
 //  document.getElementById("header").style.posTop  = 0;
   document.getElementById("head1").style.position='static';
   document.getElementById("head1").style.posTop  = 0;
   document.getElementById("head2").style.position='static';
   document.getElementById("head2").style.posTop  = 0;
   document.getElementById("head3").style.position='static';
   document.getElementById("head3").style.posTop  = 0;
   document.getElementById("head4").style.position='static';
   document.getElementById("head4").style.posTop  = 0;
   document.getElementById("head5").style.position='static';
   document.getElementById("head5").style.posTop  = 0;
   document.getElementById("head6").style.position='static';
   document.getElementById("head6").style.posTop  = 0;
   document.getElementById("head7").style.position='static';
   document.getElementById("head7").style.posTop  = 0;
   document.getElementById("head8").style.position='static';
   document.getElementById("head8").style.posTop  = 0;
   document.getElementById("head9").style.position='static';
   document.getElementById("head9").style.posTop  = 0;
   document.getElementById("head10").style.position='static';
   document.getElementById("head10").style.posTop  = 0;
  }else{

	document.getElementById("head1").style.position = 'relative';
	document.getElementById("head1").style.posTop  = x-20;
	document.getElementById("head2").style.position = 'relative';
	document.getElementById("head2").style.posTop  = x-20;
	document.getElementById("head3").style.position = 'relative';
	document.getElementById("head3").style.posTop  = x-20;
	document.getElementById("head4").style.position = 'relative';
	document.getElementById("head4").style.posTop  = x-20;
	document.getElementById("head5").style.position = 'relative';
	document.getElementById("head5").style.posTop  = x-20;
	document.getElementById("head6").style.position = 'relative';
	document.getElementById("head6").style.posTop  = x-20;
	document.getElementById("head7").style.position = 'relative';
	document.getElementById("head7").style.posTop  = x-20;
	document.getElementById("head8").style.position = 'relative';
	document.getElementById("head8").style.posTop  = x-20;
	document.getElementById("head9").style.position = 'relative';
	document.getElementById("head9").style.posTop  = x-20;
    document.getElementById("head10").style.position = 'relative';
	document.getElementById("head10").style.posTop  = x-20;
  }

}

async function Modal_Contact_Details(obj)
{
		var isAlternateAddressAppl = document.forms[0].isAlternateAddressAppl.value;//Added by Thamizh selvi on 5th Feb 2018 against ML-MMOH-CRF-0601
		var retVal =    new String();
		var dialogHeight= "400px" ;
		var dialogWidth = "900px" ;
		/*Modified by Thamizh selvi on 2nd Feb 2018 against ML-MMOH-CRF-0601 Start*/
		if(isAlternateAddressAppl == "true")
			dialogWidth = "900px" ;
		/*End*/
		var status = "no";
		
		concat_address_hidden=document.forms[0].concat_address_hidden.value;
		var arguments	=concat_address_hidden;
		var calling_from = "";
		var features    = "dialogHeight:" + dialogHeight +";dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		
		retVal = await window.showModalDialog("../../eMP/jsp/ContactDetailsFrame.jsp?readonly_yn=Y&",arguments,features);	
}

function clearFields()
{
	document.forms[0].practitioner_name.value='';

}

function displayPrimaryResource()
{
	document.getElementById("pract_type1").innerHTML="";
	var clinicCode="";
	clinicCode=document.forms[0].clinic_code.value;
	//document.forms[0].location_code1.value=clinicCode;

		var val=clinicCode.split("|");
		var clinic_code=val[1];
		var open_to_all_pract_yn= val[0];

				
		locn_type=document.forms[0].locn_type.value;
	var lbValue="";

	if (locn_type!='D' && locn_type!='N'){

	var HTML="<html><body onKeyDown = 'lockKey()'><form name='modifyWaitList' id='modifyWaitList' method='post'  action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='from' id='from' value='WaitListMgmtModifyWindow'><input type=hidden name='LBoxValue' id='LBoxValue' value='"+lbValue+"'><input type=hidden name='clinicCode' id='clinicCode' value='"+clinic_code+"'><input type=hidden name='locn_type' id='locn_type' value='"+locn_type+"'></form></body></html>";

	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTML);
	parent.messageFrame.document.modifyWaitList.submit();
	}
	else if (locn_type=='D') {
		parent.frames[0].document.getElementById("resourceType1").value="R";
		parent.frames[0].document.getElementById("pract_type1").innerHTML=getLabel("Common.room.label","Common");
	}else if (locn_type=='N') {
		parent.frames[0].document.getElementById("resourceType1").value="P";
		parent.frames[0].document.getElementById("pract_type1").innerHTML=getLabel("Common.practitioner.label","Common");
	}
}

function enble_disable(obj)
{
	if (obj.value=='')
	{
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].search_pract.disabled=true;
		parent.frames[0].document.getElementById("pract_type1").innerHTML='';
	}
	else
	{
		document.forms[0].practitioner_name.disabled=false;
		document.forms[0].search_pract.disabled=false;
	}
		document.forms[0].practitioner_name.value='';
	
		document.forms[0].b_pract.value="";
}



function enable_category(obj)
{
	if(obj.value !=null || obj.value !="")
	{
		document.forms[0].walst_category.disabled=false;
		document.forms[0].walst_cate_search.disabled=false;
		document.forms[0].walst_category.value="";

	}else {
		document.forms[0].walst_category.disabled=true;
		document.forms[0].walst_cate_search.disabled=true;
		document.forms[0].walst_category.value="";

	}
	if(document.forms[0].function_id.value ==	"WAIT_LIST_INVITATION")
	{
	//parent.parent.frames[2].document.getElementById("invite_wait_list").rows="38,50%,*,4%,9%,9%";
	/*parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height="7vh";
	parent.parent.frames[2].document.getElementById("f_query_add_mod").style.height="50vh";
	parent.parent.frames[2].document.getElementById("search_collapse_frame").style.height="21vh";
	parent.parent.frames[2].document.getElementById("query_search_result").style.height="4vh";
	parent.parent.frames[2].document.getElementById("query_search_tabs").style.height="9vh";
	parent.parent.frames[2].document.getElementById("messageFrame").style.height="9vh";*/	
	parent.document.getElementById("commontoolbarFrame").style.height="7vh";
	parent.document.getElementById("f_query_add_mod").style.height="50vh";
	parent.document.getElementById("search_collapse_frame").style.height="21vh";
	parent.document.getElementById("query_search_result").style.height="4vh";
	parent.document.getElementById("query_search_tabs").style.height="9vh";
	parent.document.getElementById("messageFrame").style.height="9vh";	
	
	parent.frames[3].location.href='../../eCommon/html/blank.html?';
	parent.frames[2].document.forms[0].Select.value=getLabel("Common.search.label","Common");
	}else
	{
	parent.frames[3].location.href='../../eCommon/html/blank.html?';
	}
}

/*Lookup to open waitlist category search based on speciality selected*/
async function open_lookup()
{
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		var spl_code=document.forms[0].speciality.value;
		var sql="select a.WAITLIST_CATEGORY_CODE code, a.LONG_DESC description from OA_WAITLIST_CATEGORY a,OA_WL_CATEGORY_FOR_SPLTY b where a.WAITLIST_CATEGORY_CODE=b.WAITLIST_CATEGORY_CODE and a.eff_status = 'E' and b.SPECIALTY_CODE ='"+spl_code+"' and upper(a.WAITLIST_CATEGORY_CODE) like upper(?) and upper(a.LONG_DESC) like upper(?)  ";
		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].walst_category.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 

		retVal = await CommonLookup( getLabel("Common.WaitList.label","Common"), argumentArray );
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
			document.forms[0].walst_category.value=desc;
			document.forms[0].walst_category_code.value=code;

		}else
		{
			document.forms[0].walst_category.value="";
			document.forms[0].walst_category_code.value="";
		}
}

function enable_category_gif()
{
	if(document.forms[0].waitlist_category_reqd_yn.value=="Y")
	{
		//document.forms[0].all.wait_lst_cat.style.visibility="visible";
		document.getElementById("wait_lst_cat").style.visibility="visible";
	}else
	{
		//document.forms[0].all.wait_lst_cat.style.visibility="hidden";
		document.getElementById("wait_lst_cat").style.visibility="hidden";

	}
}

function enable_category_gif2()
{
	if(document.forms[0].waitlist_category_appl_yn.value=="Y")
	{
		if(document.forms[0].waitlist_category_reqd_yn.value=="Y")
		{
			//document.forms[0].all.wait_lst_cat.style.visibility="visible";
			document.getElementById("wait_lst_cat").style.visibility="visible";
		}else
		{
			//document.forms[0].all.wait_lst_cat.style.visibility="hidden";
			document.getElementById("wait_lst_cat").style.visibility="hidden";

		}
	}

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


function open_lookup_one()
{
	
		var p_speciality_code=document.forms[0].speciality.value;	

		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		if(document.forms[0].walst_category.value !="")
		{
		//var sql="select a.WAITLIST_CATEGORY_CODE code, a.LONG_DESC description from OA_WAITLIST_CATEGORY a,OA_WL_CATEGORY_FOR_SPLTY b where a.WAITLIST_CATEGORY_CODE=b.WAITLIST_CATEGORY_CODE and b.SPECIALTY_CODE='"+p_speciality_code+"' and upper(a.LONG_DESC) like upper(?) and upper(a.WAITLIST_CATEGORY_CODE) like upper(?)  ";

		//Friday, December 03, 2010 IN024517  
	     var sql="select a.WAITLIST_CATEGORY_CODE code, a.LONG_DESC description from OA_WAITLIST_CATEGORY a,OA_WL_CATEGORY_FOR_SPLTY b where a.WAITLIST_CATEGORY_CODE=b.WAITLIST_CATEGORY_CODE and a.eff_status = 'E' and b.SPECIALTY_CODE ='"+p_speciality_code+"' and upper(a.WAITLIST_CATEGORY_CODE) like upper(?) and upper(a.LONG_DESC) like upper(?)";

		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].walst_category.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 
		

		retVal = CommonLookup(getLabel("Common.WaitList.label","Common"), argumentArray );
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
			document.forms[0].walst_category.value=desc;
			document.forms[0].walst_category_code.value=code;
		}else
		{
			document.forms[0].walst_category.value="";
			document.forms[0].walst_category_code.value="";
		}
	}else
		{
			document.forms[0].walst_category.value="";
			document.forms[0].walst_category_code.value="";
		}
}

function clr_value(obj1,obj2)
{
	if(obj1.name=="town_code")
	{
		parent.frames[1].document.forms[0].r_town.value="";
	}else if(obj1.name=="area_code")
	{
		parent.frames[1].document.forms[0].r_area.value="";
	}else if(obj1.name=="region_code")
	{
	parent.frames[1].document.forms[0].r_region.value="";
	}
}

function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}


async function open_lookup_modify()
{
		

		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		if(document.forms[0].reason_modify.value !="")
		{
		var sql="select CONTACT_REASON_CODE code, CONTACT_REASON description from AM_CONTACT_REASON where MODIFY_WAIT_LIST_YN = 'Y' and upper(CONTACT_REASON) like upper(?) and upper(CONTACT_REASON_CODE) like upper(?)  ";

		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].reason_modify.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 

		retVal = await CommonLookup( getLabel("eOA.ReasonforModification.label","OA"), argumentArray );
		var arr=new Array();

		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
			document.forms[0].reason_modify.value=desc;
			document.forms[0].reason_modify_code.value=code;
		}else
		{
			document.forms[0].reason_modify.value="";
			document.forms[0].reason_modify_code.value="";
			return;
		}
	}else
	{
		document.forms[0].reason_modify.value="";
		document.forms[0].reason_modify_code.value="";
	}
}

async function open_lookup_two()
{
		

		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		
		var sql="select CONTACT_REASON_CODE code, CONTACT_REASON description from AM_CONTACT_REASON where MODIFY_WAIT_LIST_YN = 'Y' and upper(CONTACT_REASON) like upper(?) and upper(CONTACT_REASON_CODE) like upper(?)  ";

		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].reason_modify.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 

		retVal = await CommonLookup( getLabel("eOA.ReasonforModification.label","OA"), argumentArray );
		var arr=new Array();

		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
			document.forms[0].reason_modify.value=desc;
			document.forms[0].reason_modify_code.value=code;
		}else
		{
			document.forms[0].reason_modify.value="";
			document.forms[0].reason_modify_code.value="";
			return;
		}
	
}


async function open_lookup_cancel()
{
		
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		if(document.forms[0].reason_for_cancellation.value !="")
		{
		
		var sql="Select CONTACT_REASON_CODE code,CONTACT_REASON description from AM_CONTACT_REASON_lang_vw where 	    CANCEL_WAIT_LIST_YN='Y' and Eff_Status = 'E' and language_id = '"+localeName+"' and upper(CONTACT_REASON) like upper(?) and upper(CONTACT_REASON_CODE) like upper(?)";

		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].reason_for_cancellation.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 

		retVal = await CommonLookup( getLabel("Common.ReasonforCancellation.label","Common"), argumentArray );
		var arr=new Array();

		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
			document.forms[0].reason_for_cancellation.value=desc;
			document.forms[0].reason_cancel_code.value=code;
		}else
		{
			document.forms[0].reason_for_cancellation.value="";
			document.forms[0].reason_cancel_code.value="";
			return;
		}
	}else
	{
		document.forms[0].reason_for_cancellation.value="";
		document.forms[0].reason_cancel_code.value="";
	}
}

async function open_lookup_two_cancel()
{
		
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		
		var sql="Select CONTACT_REASON_CODE code,CONTACT_REASON description from AM_CONTACT_REASON_lang_vw where 	CANCEL_WAIT_LIST_YN='Y' and Eff_Status = 'E' and language_id = '"+localeName+"' and upper(CONTACT_REASON) like upper(?) and upper(CONTACT_REASON_CODE) like upper(?)";

		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].reason_for_cancellation.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 

		retVal = await CommonLookup( getLabel("Common.ReasonforCancellation.label","Common"), argumentArray );
		var arr=new Array();

		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
			document.forms[0].reason_for_cancellation.value=desc;
			document.forms[0].reason_cancel_code.value=code;
		}else
		{
			document.forms[0].reason_for_cancellation.value="";
			document.forms[0].reason_cancel_code.value="";
			return;
		}
	
}

function focus()
{
	document.forms[0].speciality.focus();
}



/*******Date********/


function ValidateDate(obj)
{
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
	}
}


function validate_date_to(to,from)
{
	if(to.value!="")
		{
		if(!validDateObj(to,"DMY",localeName))
		{
			to.value="";
			return ;
		}

		if(from.value!="" && to.value!="" )
		{
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.value="";
				to.select();	
				return false;
			}
			else
				return true;
		}
}
}


function validatePrefDate_new(pref_date)
{

	curDt= new Date();
	var sys = curDt.getDate()+"/"+(curDt.getMonth()+1)+"/"+curDt.getFullYear();

	if(pref_date.value!="")
		{
		if(!validDateObj(pref_date,"DMY",localeName))
		{
			pref_date.value="";
			return ;
			
		}

		var obj1=convertDate(pref_date.value,"DMY",localeName,"en");

		if(isBefore(sys,obj1,'DMY','en')==false)//localName is changed to en by Rameswar on 01-OCT-15 for Leap Year Issue
				{
				alert(getMessage("PRF_DATE_NOT_GR_CURR_DATE","Common"));
				pref_date.value="";
				pref_date.select();	
				return false;
			}
			else
				return true;

		}
}
async function past_visits_view(patientId){
	var patient_id=patientId;
	var retVal = 	new String();
	var dialogHeight= "60vh" ;
	var dialogTop = "100" ;
	var dialogWidth	= "100vw" ;
	var status = "no";
	var scroll = "no";
	if(patient_id!=''){
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;

	var callurl="../../eMP/jsp/vwEncounterDetailFrames.jsp?patientid="+patient_id;

	retVal = await top.window.showModalDialog(callurl,arguments,features);
	}
}
function chgbuttonclr() {	
	
	document.getElementById("b_loc_val").disabled="true" ;
	document.getElementById("b_loc_search").disabled="true" ;

}
async function open_loc_lookup(){	
    var location_val=document.forms[0].b_loc_val.value;
	var locn_type=document.forms[0].location.value;
	var care_locn_ind=document.forms[0].location.value;
	var speciality=document.forms[0].speciality.value;
	//var dialogTop = "60" ;
	//var dialogHeight= "37" ;
	//var dialogWidth	= "60" ;
	var dialogTop = "10px" ;
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var tit="locn_Srch";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var retVal="";
	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&speciality_code="+speciality+"&function_id=WAIT_LIST",arguments,features);
	if(retVal!=null){	
		var rvalues=retVal.split("~");
		var clinic_code=rvalues[0];
		var desc=rvalues[1];
		var open_to_all_pract_yn=rvalues[2];
		var clinic_type=rvalues[3];
		var ident_at_checkin=rvalues[4];
		var fi_visit_type_appl_yn=rvalues[5];
		var alcn_criteria=rvalues[6];
		var STime=rvalues[7];
		var ETime=rvalues[8];
		var dur=rvalues[9];



        document.forms[0].b_loc_val.value=desc;
		document.forms[0].locationType.value=clinic_code+"$"+clinic_type+"$"+open_to_all_pract_yn+"$"+ident_at_checkin+"$"+fi_visit_type_appl_yn+"$"+alcn_criteria+"$"+STime+"$"+ETime+"$"+dur;
		document.forms[0].practitioner_name.disabled=false;
	    document.forms[0].search_pract.disabled=false;
		enable_dis(document.forms[0].locationType);
		dispPrimaryResource();


	}else{	
		document.forms[0].b_loc_val.value="";
		document.forms[0].locationType.value="";
		document.forms[0].resourceType.value="";
		document.getElementById("resourceType").disabled=true;
		document.forms[0].practitioner_name.value="";
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].search_pract.disabled=true;
		parent.frames[1].document.forms[0].resourceType.value="";
		parent.frames[1].document.getElementById("pract_type1").innerHTML="";
		var location_val=document.forms[0].b_loc_val.value;
		enable_dis(document.forms[0].locationType);
		dispPrimaryResource();
	}

}


function ena_loc_lookup(obj){
		if(obj.value==null || obj.value==""){
         document.forms[0].resourceType.value="";
		 document.forms[0].locationType.value="";
		document.getElementById("resourceType").disabled=true;
		document.forms[0].practitioner_name.value="";
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].search_pract.disabled=true;
        parent.frames[1].document.forms[0].resourceType.value="";
		parent.frames[1].document.getElementById("pract_type1").innerHTML="";
		var location_val=document.forms[0].b_loc_val.value;
		enable_dis(document.forms[0].locationType);
		dispPrimaryResource();

	}else{
	open_loc_lookup()
	}
}
async function open_loc_lookup1(){	
    var location_val=document.forms[0].b_loc_val.value;
	var locn_type=document.forms[0].locn_type.value;
	var care_locn_ind=document.forms[0].locn_type.value;
	var speciality_code=document.forms[0].speciality_code.value;
	var oper_stn_id=document.forms[0].oper_stn_id.value;
	var rd_appt_yn=document.forms[0].rd_waitlist_yn.value;
	/*var dialogTop = "60" ;
	var dialogHeight= "37" ;
	var dialogWidth	= "60" ;*/
	var dialogTop = "40px" ;
    var dialogHeight= "600px" ;
    var dialogWidth="900px";
	var status = "no";
	var arguments	= "" ;
	var tit="locn_Srch";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var retVal="";
	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&speciality_code="+speciality_code+"&oper_stn_id="+oper_stn_id+"&rd_appt_yn="+rd_appt_yn+"&function_id=WAIT_LIST_MODIFY",arguments,features);
	if(retVal!=null){	
		var rvalues=retVal.split("~");
		var clinic_code=rvalues[0];
		var desc=rvalues[1];
		var open_to_all_pract_yn=rvalues[2];
		document.forms[0].b_loc_val.value=desc;
		document.forms[0].clinic_code.value=open_to_all_pract_yn+"|"+clinic_code+"|"+care_locn_ind;
		displayPrimaryResource();
		enble_disable(location_val);
	}else{	
		
		document.forms[0].b_loc_val.value="";
		document.forms[0].clinic_code.value="";
		enble_disable(location_val);
	
	}

}

function ena_loc_lookup1(obj)
{
	if(obj.value==null || obj.value=="")
	{
		document.forms[0].clinic_code.value="";
		document.forms[0].b_loc_val.value="";
		displayPrimaryResource();
		enble_disable(obj);
	}else
	{
	open_loc_lookup1()
	}
}
function ChkNumberInput1(fld, e, deci)
{
if (parseInt(deci)>0)
   var strCheck = '.0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
else
   var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
	
var whichCode = (window.Event) ? e.which : e.keyCode;
if (whichCode == 13) return true;  // Enter

key = String.fromCharCode(whichCode);  // Get key value from key code

if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

if(key == "." && fld.value.indexOf(key) != -1) return false; // Not more than one '.' char

}

