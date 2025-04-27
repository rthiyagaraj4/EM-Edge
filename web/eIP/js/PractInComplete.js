function onSuccess() 
{
	
	var eid = parent.frames[1].document.forms[0].encounterid.value;
	parent.parent.frames[1].document.location.href='../eIP/jsp/PaintAddPractInCompleteVisit.jsp?EncounterId='+eid+'&IPval=ip&fromServlet=Y';
}
//================ Functions copied from PractInCompleteQueryTools.jsp================
function recordThis(obj)
{ 	
	
	var sel=obj.value;
	document.forms[0].encounter_id.value=parent.add_modify.document.forms[0].encounterid.value;
	document.forms[0].practitioner_id.value=parent.document.frames[1].document.forms[0].practitioner_id.value;
	document.forms[0].speciality_code.value=parent.document.frames[1].document.forms[0].speciality_code.value;
	document.forms[0].Remarks.value=parent.document.frames[1].document.forms[0].Remarks.value;
	document.forms[0].consulting.value=parent.document.frames[1].document.forms[0].practitioner_role3.value;

	var p=parent.document.add_modify.document.forms[0].functionmod.value;   	

        if(p == "modify")
        {
	    document.forms[0].functionmod.value=p;
		}
		else
		{
	    var u="insert";
	    document.forms[0].functionmod.value=u;
        }


        if((document.forms[0].consulting.value=="null")|| (document.forms[0].consulting.value="")|| (document.forms[0].practitioner_id.value.length==0))
        {
            if((document.forms[0].consulting.value=="null")|| (document.forms[0].consulting.value=""))
	     {
	     var error = getMessage('CAN_NOT_BE_BLANK',"Common");
	     error = error.replace('$',getLabel("Common.Role.label","Common"));
	
	     	parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+error;
	     	return false;
	     }


	    if (document.forms[0].practitioner_id.value.length<=0)
	     {
	     	     var error = getMessage('CAN_NOT_BE_BLANK',"Common");
	     	     error = error.replace('$',getLabel("Common.practitioner.label","Common"));
				

		parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+error;
		return false;
	     }


	     if((document.forms[0].consulting.value=="null")|| (document.forms[0].consulting.value="") && (document.forms[0].practitioner_id.value.length==0))
	     {
		     var error = getMessage('CAN_NOT_BE_BLANK',"Common");
		      error = error.replace('$',getLabel('Common.Role.label','Common')+' '+getLabel('Common.and.label','Common')+' '+getLabel('Common.practitioner.label','Common'));
	     	parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+error;
	     	return false;
	     }
	}
	else
	{   
		var spec = parent.document.add_modify.document.forms[0].speciality_code.value;
		if (spec.length == 0)
		{	
		     var error = getMessage('CAN_NOT_BE_BLANK',"Common");
		   	 error = error.replace('$',getLabel("Common.speciality.label","Common"));
               
				 
			parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+error;
	     		return false;
		}
		else
		{		
			document.forms[0].consulting.value=parent.document.add_modify.document.forms[0].practitioner_role3.value;
			document.forms[0].submit();
	    	}	    
	}
 }


function recordThisIP(obj)
{       
	
	var sel=obj.value;
	document.forms[0].encounter_id.value=parent.add_modify.document.forms[0].encounterid.value;
	document.forms[0].practitioner_id.value=parent.document.add_modify.document.forms[0].practitioner_id.value;
	document.forms[0].speciality_code.value=parent.document.add_modify.document.forms[0].speciality_code.value;
	document.forms[0].Remarks.value=parent.document.add_modify.document.forms[0].Remarks.value;
    document.forms[0].consulting.value=parent.document.add_modify.document.forms[0].practitioner_role3.value;
	document.forms[0].SRL_NO.value=parent.document.add_modify.document.forms[0].hdd_srl_no.value;
	document.forms[0].RoleStartTime.value=parent.document.add_modify.document.forms[0].role_Start_Date.value;
	document.forms[0].RoleEndTime.value=parent.document.add_modify.document.forms[0].role_End_Date.value;
	document.forms[0].hddNursingUnitCode.value=parent.document.add_modify.document.forms[0].nursing_unit_code.value;
	var p=parent.document.add_modify.document.forms[0].functionmod.value;   	

        if(p == "modify")
        {
	    document.forms[0].functionmod.value=p;
		}
		else
		{
	    var u="insert";
	    document.forms[0].functionmod.value=u;
        }
		
        if((document.forms[0].consulting.value=="null")|| (document.forms[0].consulting.value="")|| (document.forms[0].practitioner_id.value.length==0))
        {
            if((document.forms[0].consulting.value=="null")|| (document.forms[0].consulting.value=""))
			 {
				var error = getMessage('CAN_NOT_BE_BLANK',"Common");
					error = error.replace('$',getLabel("Common.Role.label","Common"));
				parent.parent.parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+error;
				return false;
			 }


		if(document.forms[0].practitioner_id.value.length<=0)
	    {	
   	     	var error = getMessage('CAN_NOT_BE_BLANK',"Common");
     		error = error.replace('$',getLabel("Common.practitioner.label","Common"));
			alert(error);			
	    }

	     if((document.forms[0].consulting.value=="null")|| (document.forms[0].consulting.value="") && (document.forms[0].practitioner_id.value.length==0))
	     {	     	
			var error = getMessage('CAN_NOT_BE_BLANK',"Common");
			error = error.replace('$',getLabel('Common.Role.label','Common')+' '+getLabel('Common.and.label','Common')+' '+getLabel('Common.practitioner.label','Common'));
			alert(error);			
		 }
	}
	else
	{   
		var spec = parent.document.add_modify.document.forms[0].speciality_code.value;
		if (spec.length == 0)
		{			
			var error = getMessage('CAN_NOT_BE_BLANK',"Common");
			error = error.replace('$',getLabel("Common.speciality.label","Common"));
			alert(error);			
		}
		else if(parent.document.add_modify.document.forms[0].role_Start_Date.value.length<=0)
	    {	
   	     	var error = getMessage('CAN_NOT_BE_BLANK',"Common");
     		//error = error.replace('$','Role Start Date');
			error = error.replace('$',getLabel("eIP.RoleStartDate.label","IP"));
			alert(error);			
			
	    }
		else
		{
			
			document.forms[0].consulting.value=parent.document.add_modify.document.forms[0].practitioner_role3.value;
			
			var valvl="<html><body onKeyDown='lockKey()'><form name='PractInCompleteButton_form' id='PractInCompleteButton_form' action='../../servlet/eIP.AddPractInCompleteVisitServlet' method='post' target='messageFrame'>";
			
			for(var i=0;i<document.forms[0].elements.length; i++)
			{
				
			valvl += "<input type='hidden' name='"+document.forms[0].elements[i].name+"' id='"+document.forms[0].elements[i].name+"' value =\""+ document.forms[0].elements[i].value +"\">"
			}
				
			valvl+="</form></body></html>";
			parent.parent.frames[2].document.write(valvl);
			parent.parent.frames[2].document.forms[0].submit();
    	}	    
	}
}

function clearForm1()
{
	var Modval=parent.add_modify.document.forms[0].Modval.value="";
    P_patient_id=parent.add_modify.document.forms[0].P_patient_id.value
	Role_Start_Date=parent.add_modify.document.forms[0].hdd_Role_Start_Date.value="";
	hdd_srl_no=parent.add_modify.document.forms[0].hdd_srl_no.value
	encounterid=parent.add_modify.document.forms[0].encounterid.value
	hdd_sys_date=parent.add_modify.document.forms[0].hdd_sys_date.value	
	parent.add_modify.location.href="../../eIP/jsp/addPractInCompleteVisit.jsp?P_patient_id="+P_patient_id+"&&Modval="+Modval+"&IPval=ip"+"&Role_Start_Date="+Role_Start_Date+"&hdd_srl_no="+hdd_srl_no+"&Encounter_Id="+encounterid;
} 
function clearForm()
{
parent.add_modify.location.href=parent.add_modify.location.href;	
}

function cancelForm()
{
parent.document.location.href='../../eCommon/html/blank.html'
}

function cancelForm1()
{
//parent.parent.window.close();
const dialogTag = parent.parent.parent.document.getElementById("dialog_tag");
dialogTag.close();
}

//================ Functions copied from PractInCompleteQueryTools.jsp*** END================
//==============fucntions copied from AddPractInCompleteVisit.jsp ==============
/// function disFields will disable the values based on Mode...
function disFields(mode)
{
	if(mode != 'modify')
	{
		document.forms[0].role_End_Date.disabled = true;
		document.getElementById("endCalObj").disabled = true;
		document.forms[0].role_Start_Date.disabled = false;
		document.getElementById("startCalObj").disabled = false;
	}
	else if(mode == 'modify')
	{
		if(document.forms[0].role_End_Date.value == '')
		{	
			document.forms[0].role_Start_Date.disabled = true;
			document.getElementById("startCalObj").disabled = true;
			document.forms[0].role_End_Date.disabled = false;
			document.getElementById('endCalObj').disabled = false;
			document.getElementById("mandGIF").style.visibility = 'hidden';
		}	
		else
		{
			document.forms[0].role_Start_Date.disabled = true;
			document.getElementById("startCalObj").disabled = true;
			document.getElementById("mandGIF").style.visibility = 'hidden';
			document.forms[0].role_End_Date.disabled = false;
			document.getElementById("endCalObj").disabled = false;
		}

		var pract_role = document.forms[0].practitioner_role3.value;
		if(pract_role  == '4' || pract_role == '1') 
		{
			document.forms[0].role_Start_Date.disabled = true;
			document.getElementById('startCalObj').disabled = true;

			document.forms[0].role_End_Date.disabled = true;
			document.getElementById('endCalObj').disabled = true;

			document.forms[0].speciality_code.disabled = true;
		}
	}
	/// If Role Start Date is available then it will be defaulted else System dtae is defaulted as Start Date...

	
	if(document.forms[0].hdd_Role_Start_Date.value == '')
		document.forms[0].role_Start_Date.value = convertDate(document.forms[0].hdd_sys_date.value,'DMYHM','en',localeName);//document.forms[0].hdd_sys_date.value ;
	
	else
		document.forms[0].role_Start_Date.value = convertDate(document.forms[0].hdd_Role_Start_Date.value,'DMYHM','en',localeName);  //document.forms[0].hdd_Role_Start_Date.value;
	
	
}

//// FUNC USED TO COMPARE [ROLE END DATE TIME] WITH [SYSTEM DATE]
//// Func will return an alert message if Role End Date is Less than System date
function validateEndDate(obj,sysdateTime)
{
	if(obj.value !=	'' )
	{
		/*if(!doDateTimeChk(obj))
		{
			alert( getMessage("INVALID_DATE_TIME","SM"));
			document.forms[0].role_End_Date.select();
			document.forms[0].role_End_Date.focus();
			return;
		}*/
		if(!validDateObj(obj,"DMYHM",localeName))
			return;
		//var startDate = document.forms[0].role_Start_Date.value;
		//checkEndDateTime(obj.value,sysdateTime,startDate);

		var greg_RoleEndDateTime = convertDate(obj.value,'DMYHM',localeName,'en');
		var greg_RoleStartDateTime = convertDate(document.forms[0].role_Start_Date.value,'DMYHM',localeName,'en');
		if(!isBeforeNow(greg_RoleEndDateTime,"DMYHM","en"))
		{  
			var error = getMessage("DATE1_GT_DATE2","IP");
			error =  error.replace("$",getLabel("eIP.RoleEndDate.label",'IP'));
			error =  error.replace("#", getLabel("Common.SystemDateTime.label",'Common'));
			alert(error);
			document.forms[0].role_End_Date.focus();
			document.forms[0].role_End_Date.select();
			return false
		}
	
		if(isBefore(greg_RoleEndDateTime,greg_RoleStartDateTime,"DMYHM","en"))
		{
			var error = getMessage("DATE1_LT_DATE2","IP");
			error= error.replace("$",getLabel("eIP.RoleEndDate.label",'IP'));
			error= error.replace("#", getLabel("eIP.RoleStartDate.label",'IP'));
			
			alert(error);
			document.forms[0].role_End_Date.focus();
			document.forms[0].role_End_Date.select();
			return false
		}
		else
		{
			return true;
		}	
	}
	else return;
}


function checkEndDateTime(from,to,stdate)
{	
	
	var a = from.split(" ")
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

	a=  stdate.split(" ")
	splitdate=a[0];
	splittime=a[1]

	splitdate1 =a[0].split("/")
	splittime1= a[1].split(":")

	var start_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	if(Date.parse(from_date) > Date.parse(to_date))
	{  
		var error = getMessage("DATE1_GT_DATE2","IP");
		error =  error.replace("$",getLabel("eIP.RoleEndDate.label",'IP'));
		error =  error.replace("#", getLabel("Common.SystemDateTime.label",'Common'));
		alert(error);
		document.forms[0].role_End_Date.focus();
		document.forms[0].role_End_Date.select();
		return false
	}
	
	if(Date.parse(from_date) < Date.parse(start_date))
	{
		var error = getMessage("DATE1_LT_DATE2","IP");
		error= error.replace("$",getLabel("eIP.RoleEndDate.label",'IP'));
		error= error.replace("#", getLabel("eIP.RoleStartDate.label",'IP'));
		
		alert(error);
		document.forms[0].role_End_Date.focus();
		document.forms[0].role_End_Date.select();
		return false
	}
	else
	{
		return true;
	}	
}	
//// FUNC USED TO COMPARE [ROLE START DATE TIME] WITH [SYSTEM DATE]
//// Func will return an alert message if Role Start Date is Less than System date
function validateStartDate(obj,sysdateTime)
{
	if(obj.value !=	'' )
	{
		/*if(!doDateTimeChk(obj))
		{
			alert( getMessage("INVALID_DATE_TIME","SM"));
			document.forms[0].role_Start_Date.select();
			document.forms[0].role_Start_Date.focus();
			return;
		}*/
		if(!validDateObj(obj,"DMYHM",localeName))
			return;
		//checkDateTime(obj.value,sysdateTime);
		var greg_RoleStartDateTime = convertDate(obj.value,'DMYHM',localeName,'en');
		if(!isBeforeNow(greg_RoleStartDateTime,"DMYHM","en"))
		{
			var error = getMessage("DATE1_GT_DATE2","IP");
			error =  error.replace("$", getLabel("eIP.RoleStartDate.label",'IP'));
			error =  error.replace("#", getLabel("Common.SystemDateTime.label",'Common'));
			alert(error);
			document.forms[0].role_Start_Date.value = '';
			//document.forms[0].role_Start_Date.focus();
			document.forms[0].role_Start_Date.select();
			return false
		}
		else if(isBefore(greg_RoleStartDateTime,document.forms[0].hdd_admn_time.value,"DMYHM","en"))
		{
		
			var error = getMessage("DATE1_LT_DATE2","IP");
			//error.replace("$", getLabel("eIP.RoleStartDate.label",'IP'));
			error = error.replace("$", getLabel("eIP.RoleStartDate.label",'IP'));
			error = error.replace("#", getLabel("Common.AdmissionDateTime.label",'Common'));
		
			alert(error);
			document.forms[0].role_Start_Date.value = '';
			//document.forms[0].role_Start_Date.focus();
			document.forms[0].role_Start_Date.select();
			return false
		}	
		else
		{
			return true;
		}	

	}
	else return;
}


function checkDateTime(from,to)
{	

	var a = from.split(" ")
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


	var adm_time = document.forms[0].hdd_admn_time.value;
	var a = adm_time.split(" ")
	splitdate=a[0];
	splittime=a[1]

	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")

	var adm_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
	
	if(Date.parse(from_date) > Date.parse(to_date))
	{
		var error = getMessage("DATE1_GT_DATE2","IP");
		error =  error.replace("$", getLabel("eIP.RoleStartDate.label",'IP'));
		error =  error.replace("#", getLabel("Common.SystemDateTime.label",'Common'));
		alert(error);
		document.forms[0].role_Start_Date.focus();
		document.forms[0].role_Start_Date.select();

		return false
	}
	else if(Date.parse(from_date) < Date.parse(adm_date))
	{
		
		var error = getMessage("DATE1_LT_DATE2","IP");
		//error.replace("$", getLabel("eIP.RoleStartDate.label",'IP'));
		error = error.replace("$", getLabel("eIP.RoleStartDate.label",'IP'));
		error = error.replace("#", getLabel("Common.AdmissionDateTime.label",'Common'));
	
		alert(error);
		document.forms[0].role_Start_Date.focus();
		document.forms[0].role_Start_Date.select();
		return false
	}	
	else
	{
		return true;
	}	
}	
//// End of Addition by Sridhar R on 1 JULY 2004

function checkMaxLimit1(obj,maxSize)	
{
   var len  = obj.value;
   
	if ( obj.value.length >= maxSize )
	{
		event.returnValue = false;
	}
}
function chklim(obj,maxSize)	
{
   var len  = obj.value;
	if ( obj.value.length > maxSize )
	{
	    alert(getMessage("REMARKS_NOT_EXCEED_200_CH","SM"));
	    obj.focus();
	    obj.select();
	}
}
function chkVal(obj)
{
  document.forms[0].practitioner_role2.checked=false;
  document.forms[0].practitioner_role1.checked=true;
  var sel = obj.value;
  document.forms[0].practitioner_role3.value=sel;
  parent.frames[2].document.forms[0].consulting.value=sel;
}
function chkVal2(obj)
{
   document.forms[0].practitioner_role1.checked=false;
   document.forms[0].practitioner_role2.checked=true;
   var sel = obj.value;
   document.forms[0].practitioner_role3.value=sel;
   parent.frames[2].document.forms[0].consulting.value=sel;
}
function loadChkVal()
{
  if (document.forms[0].practitioner_role3)
	  document.forms[0].practitioner_role3.value="2";
}
function PopulateListIP(obj,ip)
{		
	var b = obj.value;	
	var selected = b;
	if (document.forms[0].fromServlet.value=='Y')
	{
		var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='querydept' id='querydept' target='messageFrame' method='post' action='../../eIP/jsp/PractInCompletePopulate.jsp?IPval=ip'><input type='hidden' name='practitioner_id' id='practitioner_id' value=\""+selected+"\"></form></body></html>";
		document.forms[0].fromServlet.value='';
	}
	else
	{
		var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='querydept' id='querydept'target='messageFrame' method='post' action='../../eIP/jsp/PractInCompletePopulate.jsp?IPval=ip'><input type='hidden' name='practitioner_id' id='practitioner_id' value=\""+selected+"\"></form></body></html>";
	}
	
	
	

	parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.messageFrame.document.querydept.submit();

	//parent.parent.parent.parent.frames[2].document.write(HTMLVal);
	//parent.parent.parent.parent.frames[2].document.querydept.submit();

}

function PopulateList(obj)
{	
	var b = obj.value;	
	var selected = b;
	var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='querydept' id='querydept' target='messageFrame' method='post' action='../../eIP/jsp/PractInCompletePopulate.jsp'><input type='hidden' name='practitioner_id' id='practitioner_id' value=\""+selected+"\"></form></body></html>";
	
	parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.messageFrame.document.querydept.submit();

	//parent.parent.parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	//parent.parent.parent.parent.frames[2].document.querydept.submit();
}
// To get the Practitioner using GeneralPractitioner search.
function getPractID()
{
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	
	var target			= document.forms[0].practid_desc;
	practName_FName		= target.name;
	practName_FValue	= target.value;
	practId_FName		= document.forms[0].practitioner_id.name;
	var facility_id		= document.forms[0].facilityid.value;

	var locale = document.forms[0].locale1.value;	

	getPractitioner("", target, facility_id, "","","Q2");

	/*var sql ="Select a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"',1) practitioner_name,am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type,am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2) primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender,am_get_desc.am_position(a.position_code,'"+locale+"',1) job_title from am_pract_for_facility_vw a WHERE a.pract_type LIKE (?) AND a.primary_speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR   UPPER(am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"',1)) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL)  and a.operating_facility_id= '"+facility_id+"'" ;

	var sql2 = "Select a.practitioner_id practitioner_id,am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"',1) practitioner_name,am_get_desc.am_pract_type(a.PRACT_TYPE,'"+locale+"',1) practitioner_type,am_get_desc.am_speciality(a.PRIMARY_SPECIALITY_CODE,'"+locale+"',2) primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender,am_get_desc.am_position(a.position_code,'"+locale+"',1) job_title from am_pract_for_facility_vw a WHERE a.pract_type LIKE (?) AND a.primary_speciality_code LIKE UPPER(?) AND (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) and   UPPER(am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"',1)) LIKE UPPER(NVL(?,a.practitioner_name))) AND  a.gender LIKE (?) AND (a.position_code LIKE (?) OR a.position_code IS NULL)  and a.operating_facility_id= '"+facility_id+"'" ;
	

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + "" + "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);	*/
} // End of getPractID().

// To be Called by GeneralPractitionerLookup to set the Practitioner.
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		document.forms[0].practitioner_id.value=arr[0];
		document.forms[0].practid_desc.value=arr[1];	
		PopulateListIP(document.forms[0].practitioner_id,'<%=IPval%>')
	}
	else
	{
		document.forms[0].practitioner_id.value="";
		document.forms[0].practid_desc.value="";			
	}

} // End of PractLookupRetVal.


//==============fucntions copied from AssignTreatingPract.jsp==============
 function reset()
{
	frames[1].document.forms[0].reset();
	if (frames[1].document.forms[0].searchby != null)
	{
		if (frames[1].document.forms[0].soundex.value!='')
		{
			frames[1].document.forms[0].searchby.value="";
			frames[1].document.forms[0].searchby.disabled=true;
		}
		else
		{
			frames[1].document.forms[0].searchby.disabled=false;
			frames[1].document.forms[0].searchby.value="S";
		}
	}
	frames[1].document.forms[0].search.disabled = false;
	frames[2].location.href = '../../eCommon/html/blank.html';
}
//==============fucntions copied from AssignTreatingPract.jsp***End ==============



