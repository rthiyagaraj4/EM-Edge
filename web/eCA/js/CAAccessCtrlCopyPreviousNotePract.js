/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
19/06/2024	  62372			Twinkle Shah		19/04/2021		ML-MMOH-CRF-2149.1
--------------------------------------------------------------------------------------------------------
*/
function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/CAAccessCtrlCopyPreviousNotePractMain.jsp?mode=insert';
}
function onSuccess()
{
	f_query_add_mod.location.reload();
}
function reset()
{	
	if(f_query_add_mod.f_query_add_mod_query.document.forms[0])
		f_query_add_mod.f_query_add_mod_query.document.forms[0].reset();
		
	f_query_add_mod.f_query_add_mod_res.location.href='../../eCommon/html/blank.html'
}
function apply()
{	
	var formResultObj = f_query_add_mod.f_query_add_mod_res.document.CAAccessRightsForViewRestrictPractResultform;
	var from = f_query_add_mod.f_query_add_mod_res.document.CAAccessRightsForViewRestrictPractResultform.fm_disp.value;		
	var to = f_query_add_mod.f_query_add_mod_res.document.CAAccessRightsForViewRestrictPractResultform.to_disp.value;
	
	var optionValStr = "", practitionerId ="", practitionerName = "", resFromDate = "", resToDate = "", resRecord = "", resUpdate = "", studyAllowedIU="", studyRightsIU=""; facility_id1="";
	for (i=from; i<=to; i++){
		practitionerId = eval("formResultObj.practitionerId"+i+".value");
		//practitionerName = eval("formResultObj.practitionerName"+i+".value");
		access_from_date = eval("formResultObj.access_from_date"+i+".value");
		access_to_date = eval("formResultObj.access_to_date"+i+".value");
		accessRightsIU = eval("formResultObj.accessRightsIU"+i+".value");
		access_res_pract_yn = eval("formResultObj.access_res_pract_yn"+i+".value");
		//optionValStr += practitionerId +"||"+practitionerName+"||"+access_from_date +" ||"+access_to_date+" ||"+accessRightsIU +"||"+access_res_pract_yn +"||"+i+"~";
		optionValStr += practitionerId +"||"+access_from_date +" ||"+access_to_date+" ||"+accessRightsIU +"||"+access_res_pract_yn +"||"+i+"~";

	}
	f_query_add_mod.f_query_add_mod_res.document.CAAccessRightsForViewRestrictPractResultform.optionValStr.value = optionValStr;
	f_query_add_mod.f_query_add_mod_res.document.forms[0].action="../../servlet/eCA.CAAccessCtrlCopyPreviousNotePractServlet";
	f_query_add_mod.f_query_add_mod_res.document.CAAccessRightsForViewRestrictPractResultform.target="messageFrame";
	f_query_add_mod.f_query_add_mod_res.document.CAAccessRightsForViewRestrictPractResultform.method="post";
	f_query_add_mod.f_query_add_mod_res.document.CAAccessRightsForViewRestrictPractResultform.submit();	
}

function searchClick(){	
	
	var patientStatus= parent.frames[0].document.forms[0].patientStatus.value;
	var search_by= parent.frames[0].document.forms[0].search_by.value;
	var search_txt= parent.frames[0].document.forms[0].search_txt.value;
	var facility_id=document.getElementById("facility_id").value;
	if(search_txt.indexOf("'")!=-1)
	{			
		search_txt = search_txt.replace("'","''");
	}
	
	parent.frames[1].location.href='../../eCA/jsp/CAAccessCtrlCopyPreviousNotePractResult.jsp?patientStatus='+patientStatus+'&search_by='+search_by+'&search_txt='+search_txt+'&facility_id1='+facility_id;
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_val=&err_num='	
}

function checkVal(obj)
{
	document.forms[0].dispMode.value = obj;
	document.forms[0].submit();
}

function selectChkBox(element,index){ 
	var chk_count=parseInt(document.getElementById('chk_count').value);
	if(element.checked){
		element.value="Y";
		document.getElementById('chk_count').value=chk_count+1;
		return;
	}else{
		element.value="N";
		document.getElementById('chk_count').value=chk_count-1;
		if(document.getElementById('allChecked').checked==true)
			document.getElementById('allChecked').checked = false;
	}
}

function showCalendarValidate(str){
	var flg = newShowCalendar(str,null,'hh:mm');
	document.getElementById(str).focus();
    return flg;
}

var  enableFlag=false;
function newShowCalendar(id, date_format,time_format) {
			var el = document.getElementById(id);
			var isModal="isDiv";
			var timeSet="";
			if ( (date_format==undefined) || (date_format=='') || (date_format==null) || (date_format=='null'))
			{
					timeSet="dd/mm/yyyy"
			}
			else 
			{
					timeSet=date_format
			}
			if ( (time_format!=undefined) && (time_format!='') && (time_format!=null) && (time_format!='null') )
			{

				timeSet = timeSet +' '+ time_format;
			}
			if(enableFlag)
			{
					return false
			}
			else
			{
				enableFlag=true;
			}

			newShowInModal(el,timeSet,id);
			return false;
}
async function newShowInModal(args,timeSet,vid)
	{
			var dialogHeight= "30vh" ;
			var dialogWidth	= "55vw" ;
			var status = "no";
			
			var features	=  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;
			var  dateValue= await window.showModalDialog('../../eCommon/jsp/CommonStaticCalenderGlad.jsp?timeSet='+timeSet,args, features);		
		   
			
			var formatedDate = dateValue;	

			if(dateValue==undefined)
			{
					 args.value= "";
			}
			else
			{
					var temp_date=dateValue.split(" ");
					formatedDate = temp_date[0];
					args.value =formatedDate;
			}
			
			enableFlag=false;
    }

function showAccessRightsHistory(facilityId,practitionerId){
	var dialogTop		=	"40" ;
	var dialogHeight	=	"33" ;
	var dialogWidth		=	"45" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	
	 window.showModalDialog("../../eCA/jsp/CAAccessCtrlCopyPreviousNotePractHistDtls.jsp?practitionerId="+practitionerId+"&facilityId="+facilityId,arguments,features);
}

function selectAll(ele) 
{
	var fm_disp=parseInt(document.getElementById("fm_disp").value);
	var to_disp=parseInt(document.getElementById("to_disp").value);	
	var chk_count=parseInt(document.getElementById('chk_count').value);
	if (ele.checked) {
	 for (var i=fm_disp; i<=to_disp; i++) 
	 {
		if(document.getElementById("access_from_date"+i) !==null && document.getElementById("access_to_date"+i) !==null)
		{
		document.getElementById("access_from_date"+i).disabled = false;
		document.getElementById("imgfromDate"+i).disabled=false;
        document.getElementById("access_to_date"+i).disabled = false;
		document.getElementById("imgToDate"+i).disabled=false;
		document.getElementById('chk_count').value=chk_count+1;
		}
     }
	}else
		{
		for (var i=fm_disp; i<=to_disp; i++) 
		 {
			if(document.getElementById("access_from_date"+i) !==null && document.getElementById("access_to_date"+i) !==null)
			{
	        document.getElementById("access_to_date"+i).disabled = true;
			document.getElementById("imgToDate"+i).disabled=true;
	        document.getElementById("access_from_date"+i).disabled = true;
			document.getElementById("imgfromDate"+i).disabled=true;
			document.getElementById('chk_count').value=chk_count-1;
			}
	     }
		}
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

function enable_date(index)
{
 if(document.getElementById("access_res_pract_yn"+index).checked)	
	{
		document.getElementById("access_from_date"+index).disabled=false;
		document.getElementById("imgfromDate"+index).disabled=false;
		document.getElementById("access_to_date"+index).disabled=false;
		document.getElementById("imgToDate"+index).disabled=false;
	}
	else
	{
		document.getElementById("access_from_date"+index).disabled=true;
		document.getElementById("imgfromDate"+index).disabled=true;
		document.getElementById("access_to_date"+index).disabled=true;
		document.getElementById("imgToDate"+index).disabled=true;
	}    
} 

function CheckForNumsAndColon(event) {
	var strCheck = '0123456789:/ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode); // Get key value from key code
	if (strCheck.indexOf(key) == -1)
		return false; // Not a valid key
	if ((event.keyCode >= 97) && (event.keyCode <= 122))
		return (event.keyCode -= 32);
	return true;
}

function CheckDateTimefrom(objText,index,locale,curnDate){
	var startDate = document.getElementById("access_from_date"+index).value;
	var enddate = document.getElementById("access_to_date"+index).value;
	var enddatefeilds = document.getElementById("access_to_date"+index);	
	if (objText.value != ''){
		if(validDate(objText.value,"DMY",locale)==false)
		{	
			alert(getMessage("INVALID_DATE_TIME","SM"));
			objText.value='';
			return false;
		}
		
		if (!(isBefore(curnDate,objText.value, "DMY", locale))){
			alert(getMessage("FROM_DATE_LESS_SYSDATE", "CA"));
			objText.value='';
			return false;
		}
		if(enddate !=''){
		if (!(isBefore(startDate, enddate, "DMY", locale))){
			alert(getMessage("DT_FRM_NOT_GRT_DT_TO", "CA"));
			objText.value='';
			return false;
		}
		}
		
		if(enddate !=''){
			if (!(isBefore(startDate, enddate, "DMY", locale))){
				alert(getMessage("DT_TO_GRTER_DT_FRM", "CA"));
				enddatefeilds.focus();
				enddatefeilds.select();
				enddatefeilds.value='';
				return false;
			}
			}
		else
			return true;
	}
}

function CheckDateTimeTo(objText,index,locale,curnDate) {
	var startDate = document.getElementById("access_from_date"+index).value;
	if (objText.value != ''){
		if(validDate(objText.value,"DMY",locale)==false)
		{	
			alert(getMessage("INVALID_DATE_TIME","SM"));
			objText.value='';
			return false;
		}	

		if (!(isBefore(curnDate,objText.value, "DMY", locale))){
			alert(getMessage("TO_DT_GR_EQ_SY_DT", "CA"));
			objText.value='';
			return false;
		}
		
		if(startDate !=''){
		if (!(isBefore(startDate, objText.value, "DMY", locale))) {
			alert(getMessage("DT_TO_GRTER_DT_FRM", "CA"));
			objText.value='';
			return false;
		}
		}
		else
			return true;
	}
}

function addFacilityList(code,desc)
{
var element = document.createElement('OPTION') ;
element.value =  code ;
element.text = desc ;	
eval("document.forms.CAAccessRightsForViewRestrictPatForm.facility_id1.add(element)");		
}

function selectfacility(obj)
{	
parent.f_query_add_mod_query.document.location.href= "../../eCA/jsp/CAAccessCtrlCopyPreviousNotePractQuery.jsp?facility1="+obj.value;
}

function chgFacility()
{
parent.frames[1].location.href='../../eCommon/html/blank.html'		
}
