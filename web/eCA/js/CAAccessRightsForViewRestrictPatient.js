/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
 10/16/2023   32902      Twinkle Shah    	    Ramesh Goli      MMS-DM-CRF-0210
--------------------------------------------------------------------------------------------------------
*/
function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/CAAccessRightsForViewRestrictPatient.jsp?mode=insert';
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0'
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
	var formResultObj = f_query_add_mod.f_query_add_mod_res.document.CAAccessRightsForViewRestrictPatResultform;
	var from = f_query_add_mod.f_query_add_mod_res.document.CAAccessRightsForViewRestrictPatResultform.fm_disp.value;		
	var to = f_query_add_mod.f_query_add_mod_res.document.CAAccessRightsForViewRestrictPatResultform.to_disp.value;
	
	var optionValStr = "", practitionerId ="", practitionerName = "", resFromDate = "", resToDate = "", resRecord = "", resUpdate = "", studyAllowedIU="", studyRightsIU="";
	for (i=from; i<=to; i++){
		practitionerId = eval("formResultObj.practitionerId"+i+".value");
		practitionerName = eval("formResultObj.practitionerName"+i+".value");
		access_from_date = eval("formResultObj.access_from_date"+i+".value");
		access_to_date = eval("formResultObj.access_to_date"+i+".value");
		accessRightsIU = eval("formResultObj.accessRightsIU"+i+".value");
		access_res_pat_yn = eval("formResultObj.access_res_pat_yn"+i+".value");
		
		optionValStr += practitionerId +"||"+practitionerName+"||"+access_from_date +" ||"+access_to_date+" ||"+accessRightsIU +"||"+access_res_pat_yn+"||"+i+"~";
	}
	f_query_add_mod.f_query_add_mod_res.document.CAAccessRightsForViewRestrictPatResultform.optionValStr.value = optionValStr;
	f_query_add_mod.f_query_add_mod_res.document.forms[0].action="../../servlet/eCA.CAAccessRightsForViewRestrictPatientServlet";
	f_query_add_mod.f_query_add_mod_res.document.CAAccessRightsForViewRestrictPatResultform.target="messageFrame";
	f_query_add_mod.f_query_add_mod_res.document.CAAccessRightsForViewRestrictPatResultform.method="post";
	f_query_add_mod.f_query_add_mod_res.document.CAAccessRightsForViewRestrictPatResultform.submit();	
}

function searchClick(){		
	var patientStatus= parent.frames[0].document.forms[0].patientStatus.value;
	var search_by= parent.frames[0].document.forms[0].search_by.value;
	var search_txt= parent.frames[0].document.forms[0].search_txt.value;
	if(search_txt.indexOf("'")!=-1)
	{			
		search_txt = search_txt.replace("'","''");
	}
	
	parent.frames[1].location.href='../../eCA/jsp/CAAccessRightsForViewRestrictPatientResult.jsp?patientStatus='+patientStatus+'&search_by='+search_by+'&search_txt='+search_txt;
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
	//document.getElementById(str).focus();
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
			var dialogHeight= "40vh" ;
			var dialogWidth	= "20vw" ;
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

function showAccessRightsHistory(facilityId,practitionerId,practitionerName){	
	var dialogTop		=	"10" ;
	var dialogHeight	=	"90vh" ;
	var dialogWidth		=	"50vw" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	
	 window.showModalDialog("../../eCA/jsp/CAAccessRightsForViewRestrictPatientDetails.jsp?practitionerId="+practitionerId+"&facilityId="+facilityId+"&practitionerName="+encodeURIComponent(practitionerName),arguments,features);
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
		document.getElementById("imgfromDate"+i).style.pointerEvents = "auto";
        document.getElementById("access_to_date"+i).disabled = false;
		document.getElementById("imgToDate"+i).style.pointerEvents = "auto";
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
	        document.getElementById("access_from_date"+i).value='';
			document.getElementById("imgToDate"+i).style.pointerEvents = "none";
	        document.getElementById("access_from_date"+i).disabled = true;
	        document.getElementById("access_to_date"+i).value='';
			document.getElementById("imgfromDate"+i).style.pointerEvents = "none";
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
function CheckDateTime(objText,field)
{	
	objText.value= trim(objText.value," ");
	var locale		= document.forms[0].locale.value;	
	if(objText.value !='')
	{		
		if(validDateObj(objText,"DMY",locale)==false)
		{			
		objText.select();
		return false;
		}
	}
}
function DateValidation(obj,oldFromDt,index)
{
		if(validDateObj(obj,"DMY",localeName))
		{
		Obj2=eval(document.getElementById(oldFromDt));
		var selectCB = eval(document.getElementById("respID"+index));					
		if(selectCB.checked && Obj2.value.length>0 && obj.value.length == 0)
			{
			flag=0;
			}
		else{
		curdate = document.forms[0].cur_date;
		var msg = getMessage("FROM_DATE_GREAT_SYS",'CA');
		
		FROM_DATE_GREAT_SYS
		
		if(!(isAfterNow(obj.value,"DMY",localeName)))
		{
			obj.focus();
			obj.select();
			alert(msg);
			obj.value='';
			obj.focus();
			obj.focus();
			obj.select();
			
			flag=0;
		}
		else flag=1;
	}
}
}
function validate_date(to_date,from_date)
{
	if(from_date.value&&to_date.value){
	
		if(!(isBefore(from_date.value,to_date.value,"DMY",localeName)))
	{
	   alert(getMessage('FROM_DATE_GREAT_SYS','CA'));
		to_date.select();
	}
}
 }

function toFromValidate(Obj,Obj2)
{
if(validDateObj(Obj,"DMY",localeName))
{
	curdate = document.forms[0].cur_date;
	var msg = getMessage("TO_DT_GR_EQ_SY_DT",'CA');
		if(!(isAfterNow(Obj.value,"DMY",localeName)))
		{
			Obj.focus();
			Obj.select();
			alert(msg);
			Obj.value='';
			Obj.focus();
			Obj.select();
			flag=0;
			chk=0;
		}
		else{
			flag=1;
			chk=1;
		}
		if(chk){
	
var msg = getMessage("DT_TO_GRTER_DT_FRM",'CA');		
			if(Obj2.value!=''){

	if(!(isBefore(Obj2.value,Obj.value,"DMY",localeName))) 
	{
		
		Obj.focus();
		Obj.select();
		alert(msg);
		Obj.value='';
		Obj.focus();
		Obj.select();
			
		flag =0;
	}
	else	flag =1;
		}
		}
}
}

function validate_date1(from_date,to_date)
{
	if(to_date.value != '' && from_date.value!='')
	{
	if(!(isBefore(from_date.value,to_date.value,"DMY",localeName)))
	{
		alert(getMessage('TO_DT_GR_EQ_SY_DT','CA'));
		to_date.select();
	}
	}
}
function DateValidation(obj,oldFromDt,index)
{
	if(validDateObj(obj,"DMY",localeName))
		{
		
		Obj2=eval("document.forms[0]."+oldFromDt)
		var selectCB = eval("document.forms[0].access_res_pat_yn" + index);
		
		if(selectCB.checked && Obj2.value.length>0 && obj.value.length == 0)
			{
		
			flag=0;
			}
		else{
			
		curdate = document.forms[0].cur_date;
		var msg = getMessage("FROM_DATE_LESS_SYSDATE",'CA');
		if(!(isAfterNow(obj.value,"DMY",localeName)))
		{
			obj.focus();
			obj.select();
			alert(msg);
			obj.value='';
			obj.focus();
			obj.focus();
			obj.select();
			
			flag=0;
		}
		else flag=1;
	}
}
}

function enable_date(index)
{
 if(document.getElementById("access_res_pat_yn"+index).checked)	
	{
		document.getElementById("access_from_date"+index).disabled=false;
		document.getElementById("imgfromDate"+index).style.pointerEvents = "auto";
		document.getElementById("access_to_date"+index).disabled=false;
		document.getElementById("imgToDate"+index).style.pointerEvents = "auto";
	}
	else
	{
		document.getElementById("access_from_date"+index).disabled=true;
		document.getElementById("imgfromDate"+index).style.pointerEvents = "none";
		document.getElementById("access_from_date"+index).value='';
		document.getElementById("access_to_date"+index).disabled=true;
		document.getElementById("imgToDate"+index).style.pointerEvents = "none";
		document.getElementById("access_to_date"+index).value='';
	}    
} 
