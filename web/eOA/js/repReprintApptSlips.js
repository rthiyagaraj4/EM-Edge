 function run()   
 {
	 
 }  

 async function search_click() {
	var patient = await PatientSearch();
    if (patient!=null)
	document.forms[0].patient_id.value = patient;
 }


 function select_click() {
	 
	 var val = document.forms[0].hddApptremainder.value;

	 if(val == "Apptremainder")
	 {
	   var appt_ref_no = document.forms[0].appt_ref_no.value;
      var appt_date = document.forms[0].appt_date.value;
      var patient_id = document.forms[0].patient_id.value;
      var clinic_code = document.forms[0].location.value;
      var practitioner_id = document.forms[0].practitioner.value;
      var added_by_id = document.forms[0].entered_by_id.value;
      var added_date = document.forms[0].entered_date.value;  
	  parent.frames[2].document.location.href="../../eOA/jsp/ApptReminderResult.jsp?&appt_ref_no="+appt_ref_no+"&appt_date="+appt_date+"&patient_id="+patient_id+"&clinic_code="+clinic_code+"&practitioner_id="+practitioner_id+"&added_by_id="+added_by_id+"&added_date="+added_date;
	 }
 }
	function select_click1() {
	 

	/*var fields = new Array ( parent.frames[1].document.forms[0].appt_date);

	var names = new Array ( getLabel("Common.apptdate.label","Common"));
	if(!parent.frames[1].checkFields( fields, names, parent.frames[3])){
		}*/
		
	var patient_id=parent.frames[1].document.forms[0].patient_id.value;
	var appt_date=parent.frames[1].document.forms[0].appt_date.value;
	var appt_ref_no=parent.frames[1].document.forms[0].appt_ref_no.value;
	if (patient_id=="" && appt_date=="")
		{
		//Mahesh added for the IN:034921 as on 04/09/2012
		if(appt_ref_no!="")	
			{
			parent.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";
			var location1 = document.forms[0].p_location_type1.value;
			var resource2 = document.forms[0].resource_class.value;
			var appt_ref_no = document.forms[0].appt_ref_no.value;
			var appt_date = document.forms[0].appt_date.value;
			var patient_id = document.forms[0].patient_id.value;
			var clinic_code = document.forms[0].location.value;
			var practitioner_id = document.forms[0].practitioner.value;
			var added_by_id = document.forms[0].entered_by_id.value;
			var added_date = document.forms[0].entered_date.value;  
			parent.frames[2].document.location.href="../../eOA/jsp/repReprintApptSlipsResult.jsp?&appt_ref_no="+appt_ref_no+"&location1="+location1+"&resource2="+resource2+"&appt_date="+appt_date+"&patient_id="+patient_id+"&clinic_code="+clinic_code+"&practitioner_id="+practitioner_id+"&added_by_id="+added_by_id+"&added_date="+added_date;
			}
		//End	
		else
			{
			var error = "";
			//errors =  "APP-OA0001 Any one of the Criteria Patient Id /Appointment Date should be entered...." + "<br>"
			errors = getMessage('PATIENT_ID_OR_APPT_DATE','OA') ; parent.frames[3].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			parent.frames[2].document.location.href='../../eCommon/html/blank.html';
			}
	  }
	  else{

	  parent.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";
	  var location1 = document.forms[0].p_location_type1.value;
	  var resource2 = document.forms[0].resource_class.value;
	  var appt_ref_no = document.forms[0].appt_ref_no.value;
      var appt_date = document.forms[0].appt_date.value;
      var patient_id = document.forms[0].patient_id.value;
      var clinic_code = document.forms[0].location.value;
      var practitioner_id = document.forms[0].practitioner.value;
      var added_by_id = document.forms[0].entered_by_id.value;
      var added_date = document.forms[0].entered_date.value;  

	  parent.frames[2].document.location.href="../../eOA/jsp/repReprintApptSlipsResult.jsp?&appt_ref_no="+appt_ref_no+"&location1="+location1+"&resource2="+resource2+"&appt_date="+appt_date+"&patient_id="+patient_id+"&clinic_code="+clinic_code+"&practitioner_id="+practitioner_id+"&added_by_id="+added_by_id+"&added_date="+added_date;
		}
	 }

 

 function reset() {
  //frames[1].document.forms[0].reset();
  frames[1].location.reload();
  frames[2].document.location.href='../../eCommon/html/blank.html';
}

async function reprint_all_click()  {
	/*if(parent.frames[2].document.forms[1])
	{
    parent.frames[2].document.forms[1].p_appt_ref_no.value = parent.frames[2].document.forms[1].p_appt_ref_nos.value;
    parent.frames[2].document.forms[1].p_clinic_code.value = parent.frames[2].document.forms[1].p_clinic_codes.value;
	var confirmprint = confirm(getMessage("APPT_REPRINT","OA"));
	  if (confirmprint)
	parent.frames[2].document.forms[1].submit();
    
	}*/
	if(parent.frames[2].document.forms[1]){
		parent.frames[2].document.forms[1].p_appt_ref_no.value = parent.frames[2].document.forms[1].p_appt_ref_nos.value;
		parent.frames[2].document.forms[1].p_clinic_code.value = parent.frames[2].document.forms[1].p_clinic_codes.value;
		var p_module_id=parent.frames[2].document.forms[1].p_module_id.value
		var p_report_id=parent.frames[2].document.forms[1].p_report_id.value
		var p_facility_id=parent.frames[2].document.forms[1].p_facility_id.value
		var p_location_type=parent.frames[2].document.forms[1].P_LOCATION_TYPE.value
		var features    = "dialogHeight:30vh; dialogWidth:25vw; scroll=no; status:no;";
		var arguments = '';	
		var url="../../eOA/jsp/reprintAppointmentSlipReport.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_location_type="+p_location_type+"&singleApptYN=N";		
		var retVal = await window.showModalDialog(url,arguments,features);
		if(retVal !='N'){
			parent.frames[2].document.forms[1].p_language_id.value=retVal;
			alert(getMessage("REPORT_SUBMIT_SERVER","Common"));
			parent.frames[2].document.forms[1].submit();
		}else{
		}
	}   
}




function populateLocations(Obj){
	document.forms[0].P_LOCATION_TYPE.value=Obj.value;
	var speciality='';
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH clinic_type=\""+Obj.value+"\" speciality=\""+speciality+"\" steps='11' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eOA/jsp/ReportsServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText) 
	document.forms[0].practitioner_name.value='';
	document.forms[0].practitioner.value='';
	document.forms[0].practitioner_name.disabled=true;
	document.forms[0].search_pract.disabled=true;

}


/*function getval(Obj)
	{
		var retVal =    new String();
        var dialogHeight= "28" ;
        var dialogWidth = "43" ;
		var sql ="";
		var p_location_type1=document.forms[0].p_location_type1.value;
        var facilityId = document.forms[0].facilityId.value;
		var  locale=document.forms[0].locale.value;
		
		if(Obj.name=="search_location"){
			tit=encodeURIComponent(getLabel("Common.Location.label","Common"));
			var oper_stn_id = document.forms[0].oper_stn_id.value;
			 sql="select a.clinic_code clinic_code,INITCAP(a.long_desc) long_desc,a.PRIMARY_RESOURCE_CLASS resource_class from op_clinic_lang_vw a, am_locn_for_oper_stn b ";
            sql = sql+"where a.facility_id=`"+facilityId+"`and a.language_id=`"+locale+"` and a.facility_id = b.facility_id ";
            sql = sql+"and a.clinic_code=b.locn_code and a.allow_appt_yn=`Y` and a.level_of_care_ind = `A` and a.CARE_LOCN_TYPE_IND=nvl(`"+p_location_type1+"`,a.CARE_LOCN_TYPE_IND) and ";
            sql = sql+"a.eff_status=`E` and b.oper_stn_id=`"+oper_stn_id+"` and b.eff_status=`E`";
			search_code=" clinic_code ";
            search_desc= "long_desc";	
			
		}
		
		else {
			tit=encodeURIComponent(getLabel("Common.user.label","Common"));
   		    sql="select appl_user_id, APPL_USER_NAME from SM_APPL_USER_LANG_VW ";
			sql = sql+"where language_id =`"+locale+"` ";
            
			
			search_code="appl_user_id ";
            search_desc= "appl_user_name";
		}

		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + "no";
        retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);	
		var arr =new Array();
		if (retVal!=null)
		{
		
		  arr=unescape(retVal).split('::');
		 
         if(Obj.name=="search_location")
		  {
		  document.forms[0].location_name.value=arr[0];
		   document.forms[0].location.value=arr[1];
		 
		 
		  }
		  else
		  {
		  document.forms[0].entered_by_name.value=arr[0];
		  document.forms[0].entered_by_id.value=arr[1];
          }
		}
	}*/
function searchCode(obj,target_code,target_desc){
	if(obj.value!=""){
		searchCode1(obj,target_code,target_desc);
	}else{
		target_desc.value="";
		target_code.value="";
		if(obj.name=="search_location" || obj.name=="location_name"){
			enable_disp_next(obj);
			resource_enable(); 
		}
	}
}
	
async function searchCode1(obj,target_code,target_desc){
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";
	var sql="";

	var p_location_type1=document.forms[0].p_location_type1.value;
	var facilityId = document.forms[0].facilityId.value;
	var  locale=document.forms[0].locale.value;
	if(obj.name=="search_location" || obj.name=="location_name"){
		tit=getLabel("Common.Location.label","Common");
		var oper_stn_id = document.forms[0].oper_stn_id.value;
		sql="select a.clinic_code code,INITCAP(a.long_desc) description,a.PRIMARY_RESOURCE_CLASS resource_class from op_clinic_lang_vw a, am_locn_for_oper_stn b ";
        sql = sql+"where a.facility_id='"+facilityId+"'and a.language_id='"+locale+"' and a.facility_id = b.facility_id ";
        sql = sql+"and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and a.level_of_care_ind = 'A' and a.CARE_LOCN_TYPE_IND=nvl('"+p_location_type1+"',a.CARE_LOCN_TYPE_IND) and ";
        sql = sql+"a.eff_status='E' and b.oper_stn_id='"+oper_stn_id+"' and b.eff_status='E' and upper(a.clinic_code) like upper(?) and upper(a.long_desc) like upper(?) order by 2";
	}else{
		tit=getLabel("Common.user.label","Common");
   		sql="select appl_user_id code, APPL_USER_NAME description from SM_APPL_USER_LANG_VW ";
		sql = sql+"where language_id ='"+locale+"' and upper(appl_user_id) like upper(?) and upper(APPL_USER_NAME) like upper(?) order by 2";
    }
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target_code.value;
	argumentArray[6] = CODE_LINK ;
	argumentArray[7] = CODE_DESC ;				
	retVal = await CommonLookup( tit, argumentArray );
	if (retVal !=null && retVal !=""){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target_desc.value=arr[0];
		target_code.value=arr[1];
	}else{
		target_desc.value="";
		target_code.value="";
	}
	if(obj.name=="search_location" || obj.name=="location_name"){
		enable_disp_next(obj);
		resource_enable(); 
	}
}


function enable_disp_next(Obj)
{	
	
	 parent.frames[1].document.forms[0].practitioner.value = "";
     parent.frames[1].document.forms[0].practitioner_name.value = "";
	var ObjVal=parent.frames[1].document.forms[0].location.value;
	var clinic_type=parent.frames[1].document.forms[0].p_location_type1.value;
	if(ObjVal!=''){
	if(clinic_type!='C'){
	}
	if(ObjVal==''){
		document.forms[0].practitioner_name.value='';
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].search_pract.disabled=true;
	}else{
		document.forms[0].practitioner_name.value='';
		document.forms[0].practitioner_name.disabled=false;
		document.forms[0].search_pract.disabled=false;
	}
	
	
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH clinic_type=\""+clinic_type+"\" clinic_code1=\""+ObjVal+"\" steps='X' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eOA/jsp/ReportsServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText)
	}
}
function changeVal(obj)
{
	document.forms[0].P_LOCATION_TYPE.value=obj.value;
	document.forms[0].location_name.value='';
	document.forms[0].practitioner_name.value='';
	document.forms[0].practitioner.value='';
	document.forms[0].practitioner_name.disabled=true;
	document.forms[0].search_pract.disabled=true;
	document.forms[0].location.value='';
}

async function view_appt_dtl(ref_no,appt_date,clinic_code,pract_id,from_time,to_time){
    var retVal =    new String();
    var dialogHeight= "90vh" ;
    var dialogWidth = "90vw" ;
    var dialogTop = "0" ;
    var center = "1" ;
    var status="no";
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
    var arguments   = "" ;
    retVal = 
	await window.showModalDialog("../../eOA/jsp/AppointmentDetails1.jsp?i_appt_ref_no="+ref_no+"&i_clinic_code="+clinic_code+"&i_practitioner_id="+pract_id+"&i_appt_date="+appt_date+"&i_from_time="+from_time+"&i_to_time="+to_time+"&flag=Visit_Reg",arguments,features);
    }

	

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

function resource_enable()
{
	document.getElementById("resourceType1").value=document.forms[0].resource_class.value;
	document.getElementById("locationType1").value=document.forms[0].p_location_type1.value;
	var ObjVal=parent.frames[1].document.forms[0].location.value;
	document.getElementById("location_code1").value= ObjVal;

	if(document.forms[0].p_location_type1.value=="" || document.forms[0].location_name.value=="" )
	{
	document.forms[0].practitioner_name.value='';
	document.forms[0].practitioner_name.disabled=true;	
	document.forms[0].search_pract.disabled=true;
	}else
	{
	document.forms[0].practitioner_name.value='';
	document.forms[0].practitioner_name.disabled=false;	
	document.forms[0].search_pract.disabled=false;
	}
}
//Mahesh added for the IN:034921 as on 04/09/2012
function GetApptDetails(appt_obj)
	{
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH appt_id = \""+appt_obj.value+"\" steps='reprint_appt_slip' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ReportsServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
	}
//End
			
