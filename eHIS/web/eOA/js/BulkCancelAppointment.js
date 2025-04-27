function reset()
{     

	var lBox=frames[1].document.QueryApptForPatient.b_loc; 
	var len=frames[1].document.QueryApptForPatient.b_loc.options.length;
	
    lBox.remove(lBox.options[0]);
  
    var i=0;
    while(i< len)
		lBox.remove(lBox.options[i++]);
	  var opt=document.createElement('OPTION');	
	opt.value='';
    opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	lBox.add(opt);

        frames[1].document.forms[0].reset();
		frames[1].document.forms[0].practitioner_name.disabled=true;
		frames[1].document.forms[0].search_pract.disabled=true;
		frames[1].document.getElementById('pract_type').innerText="";
	 frames[2].location.href = '../../eCommon/html/blank.html' ;
		frames[3].location.href = '../../eCommon/jsp/error.jsp'; 
}

function populatepract(Obj)
{

	var n=document.forms[0].b_loc.options.length;
	for(var i=0;i<n;i++){
		document.forms[0].b_loc.remove("clinic");
		
	}
	var locationtype = document.forms[0].all.b_loc1.value;
	
	document.forms[0].all.practitioner_name.value="";
	document.forms[0].all.practitioner.value="";
	document.forms[0].all.practitioner_name.disabled=true;
	document.forms[0].all.practitioner.disabled=true;
	var opt=document.createElement("OPTION");
	opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt.value="";
	document.forms[0].b_loc.add(opt);

	var oper_stn_id=document.forms[0].oper_stn.value;

	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH clinic_type=\""+Obj.value+"\" steps='S' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText) 

	if(Obj.value=='C'){
			document.getElementById('pract_type').innerHTML=getLabel("Common.practitioner.label","Common");
			document.getElementById('practitioner').value='P';
		}else{
			document.getElementById('pract_type').innerHTML="&nbsp;";
			document.getElementById('practitioner').value='';
		}

	document.getElementById('pract_type').innerHTML="&nbsp;";
	document.getElementById('practitioner').value='';

}

function enablepract(Obj){
	document.forms[0].all.practitioner_name.disabled=false;
	document.forms[0].all.search_pract.disabled=false;
	document.forms[0].all.practitioner_name.value="";
     
	
	var ObjVal=Obj.value;
	var arr=ObjVal.split("$");

	var clnc_cd=arr[1];
var specialty="";
	var clinic_type=parent.frames[1].document.forms[0].b_loc1.value;
	

	if(clinic_type!='C'){
		document.forms[0].all.pract_type.innerHTML="&nbsp;";
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
		xmlStr ="<root><SEARCH speciality=\""+specialty+"\" location=\""+ObjVal+"\" clinic_type=\""+clinic_type+"\" clinic_code1=\""+clnc_cd+"\" steps='XXX' /></root>"

		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText)
}
function validate_date_from(obj,obj1)
{
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
		var sysdt = parent.frames[1].document.forms[0].sys_date.value;
		var obj2=convertDate(obj.value,"DMY",localeName,"en");
		if(isBefore(sysdt,obj2,'DMY',localeName)==false)
				{
				alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
			
	}
	
		


	if(obj.value!="" && obj1.value!="" )
		{
	
			if(isBefore(obj.value,obj1.value,'DMY',localeName)==false)
				{
				var msg = getMessage('TO_DT_GR_EQ_FM_DT','SM');
				alert(msg);
				obj.value="";
				obj.select();					
				return false;
			}
			else
				return true;
		}


}

function validate_date_to(obj,obj1)
{
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
			var sysdt = parent.frames[1].document.forms[0].sys_date.value;
		var obj2=convertDate(obj.value,"DMY",localeName,"en");
		if(isBefore(sysdt,obj2,'DMY',localeName)==false)
				{
				alert(getMessage("TO_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
	}

	if(obj.value!="" && obj1.value!="" )
		{
	
			if(isBefore(obj1.value,obj.value,'DMY',localeName)==false)
				{
				var msg = getMessage('TO_DT_GR_EQ_FM_DT','SM');
				alert(msg);
				obj.value="";
				obj.select();					
				return false;
			}
			else
				return true;
		}


}

	async function reasonlookup()
{
		var locale=document.forms[0].locale.value;
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		
		//var sql = "SELECT CONTACT_REASON_CODE code, CONTACT_REASON description FROM AM_CONTACT_REASON WHERE	 CANCEL_APPOINTMENT_YN = 'Y' and EFF_STATUS = 'E' and upper(CONTACT_REASON_CODE) like upper(?) and upper(CONTACT_REASON) like upper(?) Order by 1";
	
		var sql="Select CONTACT_REASON_CODE code, CONTACT_REASON description from AM_CONTACT_REASON_LANG_VW where cancel_Appointment_Yn = 'Y' and Eff_Status = 'E' and language_id = '"+locale+"' and upper(CONTACT_REASON_CODE) like upper(?) and upper(CONTACT_REASON) like upper(?) Order by 1";

		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		
		argumentArray[5] = document.forms[0].reason_code_cancel.value;
	
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = CODE_DESC ; 
		retVal = await CommonLookup(getLabel("Common.reason.label","Common"), argumentArray );
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
		
			document.forms[0].reason_code_cancel.value=desc;
			document.forms[0].reason_for_cancellation.value=code;
		
		}else
		{
			
			document.forms[0].reason_for_cancellation.value="";
			document.forms[0].reason_code_cancel.value="";
	
		}
}
function clearAll() {
  parent.frame2.location.href = '../../eCommon/html/blank.html' ;
  parent.frames[3].location.href = '../../eCommon/jsp/error.jsp'; 
}

function callResult()
{

		parent.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";


	cliniccode	= parent.frames[1].document.forms[0].b_loc.value ;
	cliniccode = cliniccode.substring(2,cliniccode.length)
	practcode	= parent.frames[1].document.forms[0].practitioner.value ;
	apptfromdate	= parent.frames[1].document.forms[0].b_from_date.value ;
	appttodate	= parent.frames[1].document.forms[0].b_to_date.value ;
	var oper_stn_id=parent.frames[1].document.forms[0].oper_stn.value ;
		var clinic_type=parent.frames[1].document.forms[0].b_loc1.value ;

		var res_type=parent.frames[1].document.forms[0].resourceType1.value ;

	var called_for=parent.frames[1].document.forms[0].called_for.value ;


	var fields = new Array (parent.frames[1].document.forms[0].reason_code_cancel, parent.frames[1].document.forms[0].b_from_date,
	parent.frames[1].document.forms[0].b_to_date);

	var names = new Array ( getLabel("Common.ReasonforCancellation.label","Common"),
							getLabel("Common.apptdate.label","Common")+" "+getLabel("Common.from.label","Common"),
							getLabel("Common.apptdate.label","Common")+" "+getLabel("Common.to.label","Common"));


	if(!parent.frames[1].checkFields( fields, names, parent.frames[3])){
	}else{
		parent.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";
	
		parent.frame2.location.href = '../../eOA/jsp/BulkCancelAppointmentResult.jsp?cliniccode='+cliniccode+"&practcode="+practcode+"&apptfromdate="+apptfromdate+"&appttodate="+appttodate+"&oper_stn_id="+oper_stn_id+"&clinic_type="+clinic_type+"&res_type="+res_type+"&called_for="+called_for;
	}
 

    	
}
function hideToolTip()
{
	document.getElementById('tooltiplayer').style.visibility = 'hidden'
}
function show_second(obj,obj1)
{
	if(obj.checked==true)
	{
	}else
	{

	}
}
