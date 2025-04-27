var detailed_display; 

function show() {
	parent.parent.window.document.title = getLabel('Common.PatientHistory.label','common')+" " + getLabel('Common.search.label','common') ;
}
function query() {
	f_query_criteria.location.href ="../../eMP/jsp/PatientHistQuery.jsp";
	f_query_patient.location.href="../../eCommon/html/blank.html";
	f_query_result.location.href="../../eCommon/html/blank.html";
}
function reset() {
	if(f_query_criteria.document.forms[0].name == "PatientHistorySearchForm") 
		f_query_criteria.document.PatientHistorySearchForm.reset() ;
	else 
		f_query_criteria.document.query_form.reset() ;
}

//From PatientHistQuery.jsp 
function focusField()
{
	document.PatientHistorySearchForm.Patient_ID.focus();
}
function clear_frame()
{
	document.PatientHistorySearchForm.Patient_ID.value='';
	document.PatientHistorySearchForm.History_Type.value=0
	parent.frames[2].location.href="../../eCommon/html/blank.html";
	parent.frames[3].location.href="../../eCommon/html/blank.html";
}
async function PatSearch()
{
	var patientid= await PatientSearch('','','','','','','','','','VIEW');
	document.PatientHistorySearchForm.Patient_ID.value = unescape(patientid);
	if( document.PatientHistorySearchForm.Patient_ID.value == 'undefined')
	document.PatientHistorySearchForm.Patient_ID.value = '';
	document.PatientHistorySearchForm.Patient_ID.focus();
}

function fn_dtl(j){
	var action=document.getElementById("action").value;
	var facilityid=document.getElementById("facilityid").value;
	var pat_id=document.getElementById("pat_id").value;
	var encounter_id=document.getElementById("encounter_id").value;
	var my_hix_pat_id=document.getElementById("my_hix_pat_id").value;
	var final_from_date=document.getElementById("final_from_date").value;
	var final_to_date=document.getElementById("final_to_date").value;
	var logged_user=document.getElementById("logged_User").value;
	var doc_id="";

	var element_by_id = "doc_txt["+j+"]";

	try{
		//doc_id=eval(document.getElementById("doc_txt")["+j+"].value);
		doc_id=eval(document.getElementById(element_by_id).value);
	}catch(exception){
		doc_id=eval(document.getElementById("doc_txt").value);
	}
	
	var dataElements = "<REQ_ID>"+action+"$!^<FACILITY_ID>"+facilityid+"$!^<PATIENT_ID>"+pat_id+"$!^<ENCOUNTER_ID>"+encounter_id+"$!^<MYHIX_PAT_ID>"+my_hix_pat_id+"$!^<FROM_DATE>"+final_from_date+"$!^<TO_DATE>"+final_to_date+"$!^<MYHIX_DOC_ID>"+doc_id+"$!^<REQ_TYPE>RETREQUEST$!^<LOGGED_USER>"+logged_user+"$!^";

	dataElements = encodeURIComponent(dataElements);

	var action_url	="../../eMP/jsp/MyHixDetail.jsp?dataElements="+dataElements;

	var dialogWidth	= window.screen.width;
	var dialogHeight = window.screen.height;

	window.open(action_url,null,"height="+dialogHeight +",width="+dialogWidth+",top=0,left=0,resizable=yes, scrollbars=yes,status=NO,toolbar=no,menubar=no,location=no");
}

function setData(){
	//alert('p')
	//alert(detailed_display)
	parent.f_query_result.document.getElementById("dtls").innerHTML=detailed_display;
}


function format_fn(){
	
	var jk=document.getElementById("cttime").length;

	if(jk>1){
	}else{
		jk=1;
	}

	//variable added by Sethu for dynamic name to be set in the document.getElementById()
	var field_id_cttime = "";
	var field_id_ptid = "";
	var field_id_pract = "";
	var field_id_log = "";
	

	if(jk==1){

		var dt_time=eval(document.getElementById("cttime").innerText);
		//var modified_dat_time=dt_time.substr(4,2)+"/"+dt_time.substr(6,2)+"/"+dt_time.substr(0,4) +" "+dt_time.substr(8,2)+":"+dt_time.substr(10,2)+":"+dt_time.substr(11,2);
		// modified for ML-MMOH-SCF-1035 date format changed from  mm/dd/yyyy HH:MI:SS  to dd/mm/yyyy HH:MI:SS
		var modified_dat_time=dt_time.substr(6,2)+"/"+dt_time.substr(4,2)+"/"+dt_time.substr(0,4) +" "+dt_time.substr(8,2)+":"+dt_time.substr(10,2)+":"+dt_time.substr(11,2);
		
		var obj=eval(document.getElementById("cttime"));
		
		obj.innerHTML="<a href='javascript://' onclick=fn_dtl('0')>"+modified_dat_time+"</a>";

		var pat_id=eval(document.getElementById("ptid").innerText);
				
		var modified_pat_id=pat_id.substr(0,pat_id.indexOf("^"));
		var obj=eval(document.getElementById("ptid"));
		obj.innerText=modified_pat_id;

		var pract_name=eval(document.getElementById("practnm").innerText);
				
		var modified_pract_name=pract_name.substr(pract_name.indexOf("^^"),pract_name.indexOf("^^^^^"));

		modified_pract_name=modified_pract_name.replace("^^"," ");
		if(pract_name.indexOf("^^")>0)
			modified_pract_name=modified_pract_name.replace("^^"," ");

		if(pract_name.indexOf("^^")>0)
			modified_pract_name=modified_pract_name.replace("^^"," ");

		if(pract_name.indexOf("^")>0)
			modified_pract_name=modified_pract_name.replace("^"," ");

		var obj=eval(document.getElementById("practnm"));
		obj.innerText=modified_pract_name;

		var obj=eval(document.getElementById("logid"));		
		obj.innerHTML="<a href='javascript://' onclick=view_log('0')><img src='../../eCommon/images/PI_Profile.gif' alt='View Log'></a>";

	}else{
			for(i=0;i<jk;i++){
				field_id_cttime = "cttime"+"["+i+"]";
				//var dt_time=eval(document.getElementById("cttime")["+i+"].innerText);
				var dt_time=eval(document.getElementById(field_id_cttime).innerText);
				//var modified_dat_time=dt_time.substr(4,2)+"/"+dt_time.substr(6,2)+"/"+dt_time.substr(0,4) +" "+dt_time.substr(8,2)+":"+dt_time.substr(10,2)+":"+dt_time.substr(11,2);
				// modified for ML-MMOH-SCF-1035 date format changed from  mm/dd/yyyy HH:MI:SS  to dd/mm/yyyy HH:MI:SS
				var modified_dat_time=dt_time.substr(6,2)+"/"+dt_time.substr(4,2)+"/"+dt_time.substr(0,4) +" "+dt_time.substr(8,2)+":"+dt_time.substr(10,2)+":"+dt_time.substr(11,2);
				
				//var obj=eval("document.getElementById("cttime")["+i+"]");
				var obj=eval(document.getElementById(field_id_cttime));
				
				//var doc_id=eval("document.getElementById("docid")["+i+"].innerText");
				//var doc_obj=eval("document.getElementById("docid")["+i+"]");
				//alert(doc_id)
				//obj.innerHTML="<a href='javascript://' a:hover {color: hotpink} onclick=fn_dtl("+i+")>"+modified_dat_time+"</a><input type='hidden' name=doc_"+i+"txt value="+doc_id+">";

				obj.innerHTML="<a href='javascript://' onclick=fn_dtl("+i+")>"+modified_dat_time+"</a>";
				//doc_obj.innerHTML="-";

			}

			for(i=0;i<document.getElementById("ptid").length;i++){
				field_id_ptid = "ptid"+"["+i+"]";
				//var pat_id=eval("document.getElementById("ptid")["+i+"].innerText");
				var pat_id=eval(document.getElementById(field_id_ptid).innerText);
				
				var modified_pat_id=pat_id.substr(0,pat_id.indexOf("^"));
				//var obj=eval("document.getElementById("ptid")["+i+"]");
				var obj=eval(document.getElementById(field_id_ptid));
				obj.innerText=modified_pat_id;
			}

			for(i=0;i<document.getElementById("practnm").length;i++){
				field_id_pract = "practnm"+"["+i+"]";
				//var pract_name=eval("document.getElementById("practnm")["+i+"].innerText");
				var pract_name=eval(document.getElementById(field_id_pract).innerText);
				
				var modified_pract_name=pract_name.substr(pract_name.indexOf("^^"),pract_name.indexOf("^^^^^"));

				modified_pract_name=modified_pract_name.replace("^^"," ");
				if(pract_name.indexOf("^^")>0)
					modified_pract_name=modified_pract_name.replace("^^"," ");

				if(pract_name.indexOf("^^")>0)
					modified_pract_name=modified_pract_name.replace("^^"," ");

				if(pract_name.indexOf("^")>0)
					modified_pract_name=modified_pract_name.replace("^"," ");

				//var obj=eval("document.getElementById("practnm")["+i+"]");
				var obj=eval(document.getElementById(field_id_pract));
				obj.innerText=modified_pract_name;
			}

			for(i=0;i<document.getElementById("logid").length;i++){
				field_id_log = "logid"+"["+i+"]";
				var append_val="<a href='javascript://' onclick=view_log("+i+") ><img src='../../eCommon/images/PI_Profile.gif' alt='View Log'></a>";
				
				//var obj=eval("document.getElementById("logid")["+i+"]");
				var obj=eval(document.getElementById(field_id_log));
				obj.innerHTML=append_val;

				
			}
	}


}

function search(caller_value){
	var patient_id=document.PatientHistorySearchForm.Patient_ID;
	var from_date=document.PatientHistorySearchForm.date_from;
	var to_date=document.PatientHistorySearchForm.date_to;
	var my_hix_pat_id=document.PatientHistorySearchForm.my_hix_pat_id.value;
	var facilityid=document.PatientHistorySearchForm.facilityid.value;
	var encounter_id=document.PatientHistorySearchForm.encounter_id.value;
	var my_hix_consent=document.PatientHistorySearchForm.my_hix_consent.value;
	var logged_user=document.PatientHistorySearchForm.logged_User.value;
	//Commented By Dharma on 29th Jan 2018 against ML-MMOH-SCF-0922 [IN:066428]
	//if(my_hix_consent=="Y"){ 
	
		if(trimCheck(my_hix_pat_id)==""){
			var msg = getMessage('NO_MYHIX_ID','MP');
			parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
			//parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=App01- MyHix Patient Id not available for the patient.";
			return false;
		}else{
			
			if(trimCheck(patient_id.value)=="")
			{
				var msg = getMessage('CAN_NOT_BE_BLANK','Common');
				msg=msg.replace('$',getLabel('Common.patientId.label','common'));
				patient_id.focus();
				parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num=' + msg;
				return false;
			}else{
				if(trimCheck(from_date.value)==""){
					var msg = getMessage('CAN_NOT_BE_BLANK','Common');
					msg=msg.replace('$','From Date');
					from_date.focus();
					parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num=' + msg;
					return false;
				}else if(trimCheck(to_date.value)==""){
					var msg = getMessage('CAN_NOT_BE_BLANK','Common');
					msg=msg.replace('$','To Date');
					to_date.focus();
					parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp?err_num=' + msg;
					return false;
				}else{


					var pat_id = document.PatientHistorySearchForm.Patient_ID.value;
					var action="";
					
					if(caller_value.value=='Discharge Summary'){
						action="DISREQQ";
					}else{
						action="REFREQQ";
					}

					var format_frm_dat=from_date.value.split("/");
					var format_to_dat=to_date.value.split("/");
					var final_from_date=format_frm_dat[2]+format_frm_dat[1]+format_frm_dat[0]+"000000";
					var final_to_date=format_to_dat[2]+format_to_dat[1]+format_to_dat[0]+"000000";
					
					//var dataElements = "<REQ_ID>"+action+"$!^<FACILITY_ID>"+facilityid+"$!^<PATIENT_ID>"+pat_id+"$!^<ENCOUNTER_ID>"+encounter_id+"$!^<MYHIX_PAT_ID>"+my_hix_pat_id+"$!^<FROM_DATE>"+final_from_date+"$!^<TO_DATE>"+final_to_date+"$!^<MYHIX_DOC_ID> $!^<REQ_TYPE>QRYREQUEST";
					
					//alert(dataElements);
					
					//var html_data=invokeMyHixApplication(dataElements);
					//var html_data="<html xmlns:ns6=\"urn:hl7-org:v3\" xmlns:ns5=\"urn:oasis:names:tc:ebxml-regrep:xsd:query:3.0\" xmlns:ns4=\"urn:oasis:names:tc:ebxml-regrep:xsd:lcm:3.0\" xmlns:ns3=\"urn:oasis:names:tc:ebxml-regrep:xsd:rs:3.0\" xmlns:ns2=\"urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0\" xmlns:S=\"http://www.w3.org/2003/05/soap-envelope\"><script language=\"javascript\" src=\"../../eMP/js/MyHixSearch.js\"></script><link href=\"../../eCommon/html/IeStyle.css\" type=\"text/css\" rel=\"stylesheet\"><body alink=\"red\" vlink=\"brown\" link=\"blue\" onload=\"format_fn()\"><table width=\"100%\" align=\"center\" border=\"1\"><tr><td colspan=\"8\" class=\"columnheader\">Summary Details</td></tr><tr><td class=\"columnheader\">Creation Date</td><td class=\"columnheader\">Title</td><td class=\"columnheader\">Hospital</td><td class=\"columnheader\">Speciality</td><td class=\"columnheader\">Patient ID</td><td class=\"columnheader\">Physician</td><td class=\"columnheader\">Admission Date</td><td class=\"columnheader\">Discharge Date</td></tr><tr><td id=\"cttime\">20160614153300</td><td>Discharge Summary</td><td>Inpatient Hospital</td><td>General Internal Medicine</td><td id=\"ptid\">BN00002463^^^&amp;2.16.458.1.100000.1.49&amp;ISO</td><td id=\"practnm\">MMC^^CSC jithesh Access^^MD^^^^^&amp;2.16.458.1.100000.1.49&amp;ISO</td><td><input name=\"doc_txt\" type=\"hidden\" value=\"urn:jith:bb8cdce1-4347-4811-9d37-7872dea00e39\">-</td><td>-</td></tr><tr><td id=\"cttime\">20160614153300</td><td>Discharge Summary</td><td>Inpatient Hospital</td><td>General Internal Medicine</td><td id=\"ptid\">BN00002463^^^&amp;2.16.458.1.100000.1.49&amp;ISO</td><td id=\"practnm\">MMC^^CSC Clinician Access^^MD^^^^^&amp;2.16.458.1.100000.1.49&amp;ISO</td><td><input name=\"doc_txt\" type=\"hidden\" value=\"urn:uuid:bb8cdce1-4347-4811-9d37-7872dea00e39\">-</td><td>-</td></tr><tr><td id=\"cttime\">20160614153300</td><td>Discharge Summary</td><td>Inpatient Hospital</td><td>General Internal Medicine</td><td id=\"ptid\">BN00002463^^^&amp;2.16.458.1.100000.1.49&amp;ISO</td><td id=\"practnm\">MMC^^CSC Clinician Access^^MD^^^^^&amp;2.16.458.1.100000.1.49&amp;ISO</td><td><input name=\"doc_txt\" type=\"hidden\" value=\"urn:uuid:bb8cdce1-4347-4811-9d37-7872dea00e39\">-</td><td>-</td></tr></table></body></html>";

					//parent.f_query_patient.location.href = '../../eMP/jsp/MyHixResult.jsp?action='+action+'&facilityid='+facilityid+'&pat_id='+pat_id+'&encounter_id='+encounter_id+'&my_hix_pat_id='+encodeURIComponent(my_hix_pat_id)+'&final_from_date='+final_from_date+'&final_to_date='+final_to_date+'&details='+html_data;
					
					//alert('../../eMP/jsp/MyHixResult.jsp?&dataElements='+dataElements);


					// to uncomment for dynamic content
					parent.f_query_patient.location.href = '../../eMP/jsp/MyHixResult.jsp?action='+action+'&facilityid='+facilityid+'&pat_id='+pat_id+'&encounter_id='+encounter_id+'&my_hix_pat_id='+encodeURIComponent(my_hix_pat_id)+'&final_from_date='+final_from_date+'&final_to_date='+final_to_date+'&logged_user='+logged_user;

					//parent.f_query_patient.location.href = '../../eMP/jsp/QueryRequestOutput.html';
					// for testing

					//parent.f_query_patient.location.href = '../../eMP/jsp/MyHixResult.jsp?&dataElements='+dataElements;

					
				}
			}
		}
	//Commented By Dharma on 29th Jan 2018 against ML-MMOH-SCF-0922 [IN:066428]
	/*}else{
		var msg = getMessage('NO_PAT_CONSENT','MP');
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
		//../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value
		return false;
	}*/
}
function changeCase(Obj)
{
	Obj.value =Obj.value.toUpperCase();
}
//From PatientHistResult.jsp
function hideToolTip()
{
	document.getElementById("tooltiplayer").style.visibility='hidden'
}

function buildTable(val,val1)
{
	var rowval = val.split (",");
	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"
		tab_dat += "<tr>"
		tab_dat += "<td class='label' > "+val1+" </td>"
		tab_dat += "</tr> "


	for( var i=0; i<rowval.length; i++ )
	{
		var colval = rowval[i]
		tab_dat += "<tr>"
		tab_dat += "<td class = 'ORPANEL' >"+colval+"</td>"
		tab_dat += "</tr> "
	}
	tab_dat += "</table> "
	document.getElementById("t").innerHTML = tab_dat
}			

function displayToolTip(val,val1)
{
	
	buildTable (val,val1)
	bodwidth = parent.frames[3].document.body.offsetWidth
	bodheight =parent.frames[3].document.body.offsetHeight

	var x = event.x
	var y = event.y;

	x = x + (document.getElementById("tooltiplayer").offsetWidth)
	y = y + (document.getElementById("tooltiplayer").offsetHeight)

	if(x<bodwidth)
		x =event.x 
	else
		x = x - (document.getElementById("tooltiplayer").offsetWidth*2)

	if(y<bodheight)
		 y =event.y
	else
		y = y - (document.getElementById("tooltiplayer").offsetHeight*2)

		y+=document.body.scrollTop
		x+=document.body.scrollLeft

		document.getElementById("tooltiplayer").style.posLeft= x
		document.getElementById("tooltiplayer").style.posTop = y
document.getElementById("tooltiplayer").style.visibility='visible' 
}


function  date_check(obj){

	var Sys_date = convertDate(document.forms[0].prefdate_curr.value,"DMY",localeName,"en"); 
	var obj1=convertDate(obj.value,"DMY",localeName,"en");
	if(!validDateObj(obj,"DMY",localeName)){
			obj.value="";
			return ;
	}else{		
		if(!isAfter(Sys_date,obj1,"DMY",localeName)) {
				alert('App01- Preferred date cannot be greater current date');
				obj.value="";
				obj.select();	
				return false;
			}else{
				var frm;
				var to;
				if(obj.name=='date_from'){					
					frm=convertDate(obj.value,"DMY",localeName,"en");
					to=convertDate(document.forms[0].date_to.value,"DMY",localeName,"en");
				}
				if(obj.name=='date_to'){
					to=convertDate(obj.value,"DMY",localeName,"en");
					frm=convertDate(document.forms[0].date_from.value,"DMY",localeName,"en");
				}
				
				if(!isAfter(to,frm,"DMY",localeName)) {
					alert('App01- To date should be greater than from date');
					obj.value="";
					obj.select();
					return false;
				}else{
					return true;
				}
			}
	
		}

}

function DateCompare_from(obj2,obj)
{
var Sys_date = parent.frames[1].document.forms[0].prefdate_curr;
var obj1=convertDate(obj.value,"DMY",localeName,"en");
			if(isBefore(Sys_date.value,obj1,'DMY',localeName)==false)
				{
				alert(getMessage("PREF_FM_DT_VALIDATION","OA"));
				obj.value="";
				obj.select();	
				return false;
			}else{
				return true;
			}


if(document.forms[0].tr_rule_applicable && document.forms[0].tr_rule_applicable.checked){	
		if(!validDateObj(obj,"DMY",localeName)){
			obj.value="";
			return ;
		}else{
			var obj1=convertDate(obj.value,"DMY",localeName,"en");
			if(isBefore(Sys_date.value,obj1,'DMY',localeName)==false)
				{
				alert(getMessage("PREF_FM_DT_VALIDATION","OA"));
				obj.value="";
				obj.select();	
				return false;
			}else{
				return true;
			}
		}
}else{


if(obj.value!="")
		{
		if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
		else{
		var obj1=convertDate(obj.value,"DMY",localeName,"en");

		
if(obj2 =="from")
			{
			if(isBefore(Sys_date.value,obj1,'DMY',localeName)==false)
				{
				alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
			else
				return true;

			}else
			{
					if(isBefore(Sys_date.value,obj1,'DMY',localeName)==false)
				{
				alert(getMessage("TO_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
			else
				return true;
			}
		}
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

function validate_date_from(from,to)
{
	if(from.value!="")
		{
		if(!validDateObj(from,"DMY",localeName))
		{
			from.value="";
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
	if(document.forms[0].tr_rule_applicable && document.forms[0].tr_rule_applicable.checked){
		enableDisableBtns();
	}
}


async function view_log(j){
	
	var doc_id="";
	var pat_id=parent.frames[0].document.getElementById("Patient_ID").value;
	var my_hix_pat_id=parent.frames[0].document.getElementById("my_hix_pat_id").value;

	//variable added by Sethu for dynamic name to be set in the document.getElementById()
	var field_id_doc = "";

	field_id_doc = "doc_txt"+"["+j+"]";

	try{
		//doc_id=eval("document.getElementById("doc_txt")["+j+"].value");
		doc_id=eval(document.getElementById(field_id_doc).value);
	}catch(exception){
		doc_id=eval(document.getElementById("doc_txt").value);
	}
	
	var dialogTop = "40" ;
	var dialogHeight= "25" ;
	var dialogWidth	= "50" ;
	var status = "no";
	var arguments	= "" ;
	var tit="Audit_log";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=yes; status:" + status;
	retVal =await window.showModalDialog('../../eMP/jsp/MyHixAuditLogResult.jsp?&pat_id='+pat_id+'&my_hix_pat_id='+my_hix_pat_id+'&doc_id='+doc_id,arguments,features);
	

	//window.open('../../eMP/jsp/MyHixAuditLogResult.jsp?&pat_id='+pat_id+'&my_hix_pat_id='+my_hix_pat_id+'&doc_id='+doc_id,arguments,features);
}


