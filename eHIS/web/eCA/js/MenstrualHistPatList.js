/*
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
22/10/2024	    70709         Gunasekar R      23/10/2024   Ashwini Ragupathi    ML-MMOH-CRF-1759
-------------------------------------------------------------------------------------------------------------------------------
*/ 
patIdArr = new Array();
episodeIdArr = new Array();
patient_class = new Array();
var scrollValue=0;
function locnTypeChange(obj)
{	
	
	document.getElementById('locLed').innerText=getLabel("Common.clinic.label","COMMON");
	document.getElementById('locVal').style.visibility='visible';
	document.getElementById('src_butn').style.visibility='visible';
	document.forms[0].locationDesc.disabled = false;
	document.forms[0].locationDesc.value="";
	
	if(obj == 'Z' )
	{
		document.getElementById('locLed').innerText='';
		document.getElementById('locVal').style.visibility='hidden';
		document.getElementById('src_butn').style.visibility='hidden';

	}
	else if(obj == 'OP') 
	{
		document.getElementById('locLed').innerText=getLabel("Common.clinic.label","COMMON");
		document.forms[0].locationCode.value = "*ALL";
	}
	else if(obj == 'IP')
	{ 
		document.getElementById('locLed').innerText=getLabel("Common.nursingUnit.label","COMMON");
	
	}
	else if (obj=='DC')
	{
		document.getElementById('locLed').innerText=getLabel("Common.DaycareUnit.label","COMMON");
	}
	else if( obj=='EM')
	{
		document.getElementById('locLed').innerText=getLabel("Common.EmergencyUnits.label","COMMON");

	}

}

function searchClick()
{
	var locationDesc = "";
	var locationCode = "";
	var locationType = document.MenstPatCriteriaFrm.locationType.value;
	if(locationType!='A'){
		locationDesc = document.MenstPatCriteriaFrm.locationDesc.value;
		locationCode = document.MenstPatCriteriaFrm.locationCode.value;
	}
    
	var viewList = document.MenstPatCriteriaFrm.locationDesc.value;
	var patientId = document.MenstPatCriteriaFrm.patientId.value;
	var pract = document.MenstPatCriteriaFrm.pract.value;
	var specialty = document.MenstPatCriteriaFrm.specialty.value;
	var specialtyCode = document.MenstPatCriteriaFrm.specialty_code.value;
	var fromDate = document.MenstPatCriteriaFrm.p_fm_Date.value;
	var toDate = document.MenstPatCriteriaFrm.p_to_Date.value;
	var encounterSt = document.MenstPatCriteriaFrm.encounterSt.value;
	var menstHisEvent = document.MenstPatCriteriaFrm.menstHisEvent.value;
	var locale = document.MenstPatCriteriaFrm.locale.value
	var ca_practitioner_id = document.MenstPatCriteriaFrm.ca_practitioner_id.value;
	var pract_code          = document.forms[0].attendPract.value;
	
	if(pract_code=="" || pract_code==null)
		pract_code=ca_practitioner_id;

	var url = '../jsp/MenstrualHistPatListResult.jsp?locationType='+locationType+'&locationDesc='+locationDesc+'&locationCode='+locationCode+'&patientId='+patientId+'&pract='+pract+'&specialty='+specialty+'&specialtyCode='+specialtyCode+'&fromDate='+fromDate+'&toDate='+toDate+'&encounterSt='+encounterSt+'&menstHisEvent='+menstHisEvent+'&pract_code='+pract_code; 

   
    parent.MenstPatResultFr.location.href = url;

    if(fromDate=='')
    {
    var msg =getMessage("CAN_NOT_BE_BLANK","common");
    msg = msg.replace("$","From date");
    alert(msg);
		top.content.workAreaFrame.MenstPatResultFr.location.href="../../eCommon/html/blank.html";
    return;
    }

    if(toDate=='')
    {
    var msg =getMessage("CAN_NOT_BE_BLANK","common");
    msg = msg.replace("$","To date");
    alert(msg);
		top.content.workAreaFrame.MenstPatResultFr.location.href="../../eCommon/html/blank.html";
    return;
    }

    var fdate = minusDate(toDate,"DMY",locale,1,"M");
    if(daysBetween(fromDate,fdate,"DMY",locale)>0)
    {
    	var msg = getMessage("OR_DATE_RANGE","OR");
    	alert(msg);
			top.content.workAreaFrame.MenstPatResultFr.location.href="../../eCommon/html/blank.html";
    	return;
    }
    
    
	if(patientId == null || patientId == "")
	{
		var strMesg = getMessage("SPEC_LOCN_OR_PATIENT","CA");
		
			strMesg = strMesg.replace('$$','Location');
		
		if(viewList != "S")
		{
			if(locationType == "Z")
			{
				if(pract == "" && specialty == "")
				{
					top.content.workAreaFrame.MenstPatResultFr.location.href="../../eCommon/html/blank.html";
					alert(strMesg);				
				}
			}
		}
	}
	
}	

function clearClick(){	
	top.content.workAreaFrame.MenstPatResultFr.location.href="../../eCommon/html/blank.html";
	document.location.reload();	
}



function showCalendarValidate(str){
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}


		
		function getClinicCode()			
			{
				var target			= document.forms[0].locVal;
				var stdval          = document.forms[0].locVal.value;
				var val				= document.forms[0].facilityid.value;
				var pract_id		= document.forms[0].ca_practitioner_id.value;
				var selectedPract	= document.forms[0].attendPract.value;
				if(selectedPract=="")
					attendPract=pract_id;
					else
						attendPract=selectedPract;
				var retVal			=  new String();
				var dialogTop		= "40";
				var dialogHeight	= "10" ;
				var dialogWidth		= "40" ;
				var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
				var arguments		= "" ;
				var search_desc		= "";
				var title			= document.getElementById('locLed').innerText;
				var locale			= document.forms[0].locale.value;
				var loc_type		= document.forms[0].locationType.value;

				var sql="Select locn_code code,decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+val+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+val+"',locn_code,'"+locale+"','1') ) description  from ca_pract_by_locn_view where  upper(locn_code) like upper(?) AND UPPER(decode(locn_type,'C',OP_GET_DESC.OP_CLINIC('"+val+"',locn_code,'"+locale+"','1'), 'W',IP_GET_DESC.IP_NURSING_UNIT('"+val+"',locn_code,'"+locale+"','1') )) like upper(?) AND practitioner_id= '"+attendPract+"' and locn_type in ('C','W') and facility_id = '"+val+"' and PATIENT_CLASS = '"+loc_type+"' order by 2";

				var argArray		= new Array();
				var namesArray		= new Array();
				var valuesArray		= new Array();
				var datatypesArray	= new Array();
		
				argArray[0] = sql;
				argArray[1] = namesArray;
				argArray[2] = valuesArray;
				argArray[3] = datatypesArray;
				argArray[4] = "1,2";
				argArray[5] = target.value;
				argArray[6] = DESC_LINK;
				argArray[7] = CODE_DESC;
								
				retArray = CommonLookup( title, argArray );	
				
				if(retArray != null && retArray !="")
				{
					document.forms[0].locationCode.value = retArray[0];
					document.forms[0].locationDesc.value = retArray[1];				
				}
				else
				{
					var viewlist = document.forms[0].viewList.value;
					if(!viewlist=='S')
					{
						document.forms[0].locationCode.value = "";
						document.forms[0].locationDesc.value = "";
					}
					else
					{
						document.forms[0].locationCode.value = "*ALL";
						document.forms[0].locationDesc.value = "";
					}
					//document.forms[0].performed_by_code.value = "";
					
				}

			}


function getClinicCode1(obj)
{
	if (obj.value!= "")
	{
		getClinicCode();
	}
	else
	{
		document.forms[0].locationCode.value = "";
	}
}

function populatePract1(obj)
{
	if (obj.value != "")
	{
		populatePract();

	}
	else
	{
		document.forms[0].attendPract.value = "";
	}
}



async function populatePract()
{
		var target			= document.forms[0].pract;
		var stdval          = document.forms[0].attendPract.value;
		var facilityid      = document.forms[0].facilityid.value;
		var locale			= document.forms[0].locale.value;
       
		var retVal			= new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.practitioner.label","Common");



		var sql="Select a.practitioner_id code , b.practitioner_name  description from am_pract_for_facility_vw a, am_practitioner_lang_vw b where a.operating_facility_id = '"+facilityid+"' and a.practitioner_id = b.practitioner_id   AND a.eff_status = b.eff_status and b.language_id = '"+locale+"' and a.eff_status = 'E' and  upper(a.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) order by b.practitioner_name"; 

		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retVal = await CommonLookup( title, argArray )

		if (retVal != null && retVal != '' && retVal != "null")
		{
		   	document.forms[0].pract.value = retVal[1];
		   	document.forms[0].attendPract.value = retVal[0];
		}
		else
		{
			document.forms[0].pract.value = "";
			document.forms[0].attendPract.value = "";
		} 
}

function getSpecialty1(obj)
{
   if (obj.value != "")
	{
		getSpecialty(); 
		getSpecialty3(obj);
	}
	else
	{
		document.forms[0].specialty_code.value = "";
	}
}


async function getSpecialty()
{
		var target			= document.forms[0].specialty;
		var stdval          = document.forms[0].specialty_code.value;
		var pract			= document.forms[0].attendPract.value;
		var facilityid      = document.forms[0].facilityid.value;
		var locale			= document.forms[0].locale.value;
		var practRestriPositionYN	= document.forms[0].practRestriPositionYN1.value; 
		var ca_practitioner_id		= document.forms[0].ca_practitioner_id.value;  
		var retVal			= new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.Specialty.label","Common");
		
		var sql="select a.SPECIALITY_CODE code, a.SHORT_DESC description from AM_SPECIALITY_lang_vw  a where eff_status = 'E' and LANGUAGE_ID='"+locale+"'" ;

		if(pract != '')
		{
			sql = sql + " and SPECIALITY_CODE  in (select nvl(PRIMARY_SPECIALITY_CODE,'***') PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id='"+pract+"' union all select SPECIALITY_CODE from AM_PRACT_SPECIALITIES where FACILITY_ID='"+facilityid+"' and PRACTITIONER_ID='"+pract+"' )";
		}else{ 
			if(pract == '') pract=ca_practitioner_id;
			if(practRestriPositionYN == '1')
			{
				sql = sql + " and SPECIALITY_CODE  in (select nvl(PRIMARY_SPECIALITY_CODE,'***') PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id='"+pract+"' union all select SPECIALITY_CODE from AM_PRACT_SPECIALITIES where FACILITY_ID='"+facilityid+"' and PRACTITIONER_ID='"+pract+"' )";
			}	
		}
			
		sql = sql + " and upper(a.SPECIALITY_CODE) like upper(?) and upper(a.SHORT_DESC) like upper(?) order by 2";

		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retVal = await CommonLookup( title, argArray )

		if (retVal != null && retVal != '' && retVal != "null")
		{
		   	document.forms[0].specialty.value = retVal[1];
		   	document.forms[0].specialty_code.value = retVal[0];
		}
		else
		{
			document.forms[0].specialty.value = "";
			document.forms[0].specialty_code.value = "";
		} 
}
  
  function pract_name(){
		document.MenstPatCriteriaFrm.pract.value = document.MenstPatCriteriaFrm.pract_name.value;
  }
  
  
  var reOrder="";
  function changeColor(object)
  {
  	anchorID=object.id;
  		if(object.style.color=='yellow')
  	{	
  		reOrder='1';
  		object.style.color='pink';
  		return;
  	}
  	if(object.style.color=='pink')
  	{   
  		reOrder='2';
  		object.style.color='yellow';
  		return;
  	}
  	reOrder='1';
  	

  	for (var i = 1; i <= 11; i++) {
  	    if ('a' + i != anchorID) {
  	        document.getElementById('a' + i).style.color = 'white';
  	    }
  	}
  	object.style.color='pink';
  	
  }
  
  var reOrder='';
  var anchorID='';
  function callForOrderByLoc(obj){  

		var qryStr = top.content.workAreaFrame.MenstPatResultFr.document.forms[0].url.value;

		top.content.workAreaFrame.MenstPatCriteriaFr.document.forms[0].order_by.value=obj;
		top.content.workAreaFrame.MenstPatCriteriaFr.document.forms[0].re_order.value=reOrder;
		top.content.workAreaFrame.MenstPatCriteriaFr.document.forms[0].anchor_id.value=anchorID;
		

	     

		 var url = qryStr+'&orderBy='+obj + '&reOrder=' + reOrder + '&anchorID=' + anchorID;
	     top.content.workAreaFrame.MenstPatResultFr.location.href='MenstrualHistPatListResult.jsp?'+url;
 
	 
  }
  
  
  function Check_Date(obj,format,locale){
  	var toDate =document.forms[0].p_to_Date;
  	if(obj.value !="")
  	{
  		if(validDate(obj.value,"DMY",locale)==false)
  		{	
  			alert(getMessage("INVALID_DATE_FMT","SM"));
  			obj.value='';
  			top.content.workAreaFrame.MenstPatResultFr.location.href="../../eCommon/html/blank.html";
  			return false;
  		}
  		
  		if(!isBeforeNow(obj.value,format,locale))
  		{
  			var msg = getMessage("CANNOT_BE_GREATER_THAN_SYSDATE","CA");			
  			msg = msg.replace('$$',"Date");
  			alert(msg);
  			obj.value='';
  			top.content.workAreaFrame.MenstPatResultFr.location.href="../../eCommon/html/blank.html";
  			return false;
  		}
  	if(toDate.value !=''){
  		if (!(isBefore(obj.value, toDate.value, "DMY", locale))){
  			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
  			obj.value='';
  			top.content.workAreaFrame.MenstPatResultFr.location.href="../../eCommon/html/blank.html";
  			return false;
  		}
  }
  }
  }
  
  function CheckForNumsAndColon(event) {
		var strCheck = '0123456789:/ ';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode); 
		if (strCheck.indexOf(key) == -1)
			return false; 
		if ((event.keyCode >= 97) && (event.keyCode <= 122))
			return (event.keyCode -= 32);
		return true;
	}
  
  function checkingDate(obj,format,locale)
  {
  	var from =document.forms[0].p_fm_Date;
  	var todate =document.forms[0].p_to_Date;
  	if(obj.value !="")
  	{
  		if(validDate(obj.value,"DMY",locale)==false)
  		{	
  			alert(getMessage("INVALID_DATE_FMT","SM"));
  			obj.value='';
  			top.content.workAreaFrame.MenstPatResultFr.location.href="../../eCommon/html/blank.html";
  			return false;
  		}
  		if(!isBeforeNow(obj.value,format,locale))
  		{
  			var msg = getMessage("CANNOT_BE_GREATER_THAN_SYSDATE","CA");
  			msg = msg.replace('$$',"Date");
  			alert(msg);
  			obj.value='';
  			top.content.workAreaFrame.MenstPatResultFr.location.href="../../eCommon/html/blank.html";
  			return false;
  		}
  		if(from.value !=''){
  		if (!(isBefore(from.value, obj.value, "DMY", locale))){
  			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
  			obj.value='';
  			top.content.workAreaFrame.MenstPatResultFr.location.href="../../eCommon/html/blank.html"; 
  			return false;
  		}
  		}
  		return true;
  	}
  }

  function enablePract(obj)
  {
  	if(obj.value != null || obj.value != '')
  	{
  		if(obj.value == 'S')
  		{
  			document.MenstPatCriteriaFrm.pract.disabled = true;
  			document.MenstPatCriteriaFrm.practSearch.disabled = true;
  			document.MenstPatCriteriaFrm.attendPract.value = document.MenstPatCriteriaFrm.ca_practitioner_id.value;
  			document.MenstPatCriteriaFrm.pract.value = document.MenstPatCriteriaFrm.pract_name.value;
  		}
  		else
  		{
  			document.MenstPatCriteriaFrm.pract.disabled = false;
  			document.MenstPatCriteriaFrm.practSearch.disabled = false;
  			document.MenstPatCriteriaFrm.attendPract.value = '';
  			document.MenstPatCriteriaFrm.pract.value = '';
  		}
  	}
  }
  
  function moveFrame(){
		var temp=document.body.scrollLeft;
		scrollValue=temp;
	}
  
  function patClick_(id){
		for(var i=0;i<patIdArr.length;i++){
			if(i==id){
				document.getElementById('rta'+i).className='gridDataSelectNew';
				document.getElementById('rtb'+i).className='gridDataSelectNew';
				document.getElementById('rtc'+i).className='gridDataSelectNew';
				document.getElementById('rtd'+i).className='gridDataSelectNew';
				document.getElementById('rte'+i).className='gridDataSelectNew';
				document.getElementById('rtf'+i).className='gridDataSelectNew';
				document.getElementById('rtg'+i).className='gridDataSelectNew';
				document.getElementById('rth'+i).className='gridDataSelectNew';
				document.getElementById('rti'+i).className='gridDataSelectNew';
				document.getElementById('rtj'+i).className='gridDataSelectNew';
				document.getElementById('rtk'+i).className='gridDataSelectNew';
				document.getElementById('rtl'+i).className='gridDataSelectNew';
			}else{
				document.getElementById('rta'+i).className='gridData';
				document.getElementById('rtb'+i).className='gridData';
				document.getElementById('rtc'+i).className='gridData';
				document.getElementById('rtd'+i).className='gridData';
				document.getElementById('rte'+i).className='gridData';
				document.getElementById('rtf'+i).className='gridData';
				document.getElementById('rtg'+i).className='gridData';
				document.getElementById('rth'+i).className='gridData';
				document.getElementById('rti'+i).className='gridData';
				document.getElementById('rtj'+i).className='gridData';
				document.getElementById('rtk'+i).className='gridData';
				document.getElementById('rtl'+i).className='gridData';
			}
		}
	} 

 function patClick(ind)
  {
	  document.PatCriteriaFrm.patient_class.value = patient_class[ind];
	 
	  document.PatCriteriaFrm.encounter_id.value = episodeIdArr[ind];
		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc = new DOMParser().parseFromString(null, "text/xml");
		xmlHttp.open("POST","MenstrualHistPatListResult.jsp?validateSes=Y",false);
		xmlHttp.send( xmlDoc ) ;
	  document.PatCriteriaFrm.submit();

  }
 
	function callPatientSearch(){
		
		var pat_id =  PatientSearch();
		//alert(pat_id);
		if(pat_id != null)	document.getElementById('patientId').value = pat_id;
		document.getElementById('patientId').focus();
}

