
function create()
{
	f_query_add_mod.location.href = "../../eOP/jsp/InsertPClinic.jsp?call_func=Pract_for_clinic" ;

}

function edit()
{
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query()
{	
	f_query_add_mod.location.href ="../../eOP/jsp/queryPractitionerClinicPage.jsp?function=Pract_for_clinic";
}

function checkIsValidForProceed()
{
 var url = f_query_add_mod.location.href;
 url = url.toLowerCase();
 if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
  return true;
 else
  return false;
}

function apply() 
{

	if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }
 //parent.frames[1].frames[1].document.forms[0].clinic.disabled=false;
 //parent.frames[1].frames[1].document.forms[0].pract_name.disabled=false;
 window.frames[1].document.forms[0].clinic.disabled=false;
 window.frames[1].document.forms[0].pract_name.disabled=false;
	var fields = new Array (	f_query_add_mod.document.clinic_form.clinic,
								f_query_add_mod.document.clinic_form.practitioner
							);

	var names = new Array	(	getLabel("Common.clinic.label","Common"),
								getLabel("Common.practitioner.label","Common")
							);
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
			f_query_add_mod.document.clinic_form.submit();
			var fn_status = f_query_add_mod.document.clinic_form.function_name.value ;
	}

}//e.o.apply

function reset() 
{
         if(f_query_add_mod.location.href.indexOf("queryPractitionerClinic.jsp")!=-1)
		     return false;
	 else
			f_query_add_mod.location.reload() ;
	
     
	
}

function onSuccess() {	
	f_query_add_mod.location.reload();


}

function GetValues(obj)
{
	ClearList(obj);
	var carelocntype="C";

	var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='popwork' id='popwork' method='post' action='../../eOP/jsp/PractitionerForClinicMain.jsp'>";
	if(obj.name == "clinic")
	{
		HTMLVal+= "<input name='clinic' id='clinic' type='hidden' value='"+obj.value + "'><input name='callfunc' id='callfunc' type='hidden' value='"+parent.frames[1].document.forms[0].call_function.value+ "'><input name='step' id='step' type='hidden' value='3'><input name='carelocntype' id='carelocntype' type='hidden' value='"+carelocntype+"'>";
	}
	HTMLVal+= "</form></body></html>";

	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.messageFrame.popwork.submit();
}

function ClearList(obj)
{
	if(obj.name =="clinic")
	{
		for(i=1;i<=5;i++)
		{
			for(j=1;j<=7;j++)
			{
				parent.frames[1].document.getElementById("working_week_"+i+"_day_"+j).value="";
			}
		}
	}
}
 // This function is used to  search the Practitioners

function onBlurCallPractitionerSearch(obj,target_name)
		{
		 target_name.value = trimString(target_name.value);
       
		 if(target_name.value == "")
			{
			 parent.frames[1].document.forms[0].practitioner.value="";
			 return;
			}
         
			getPract(obj,target_name);

		}

/*
  This function is used to get the Practitioner name into appropriate Text Field.
  This is called inside the OnBlurCallPractitionerSearch(); For getting the Practitioner
  Name it will call one Intermediate Jsp-- CallGeneralPractitionerSearch.jsp;
 */
function getPract(target_id,target_name)
{

	
	var callfunc=parent.frames[1].document.forms[0].call_function.value;
	if(callfunc == "Pract_for_clinic")
	{
		if(parent.frames[1].document.forms[0].pract_name.readOnly==true)
			return;
					
		var facilityid = parent.frames[1].document.forms[0].fac_id.value;
		var clinic_code = parent.frames[1].document.forms[0].clinic.value;
					 
		if(!target_name)
			target_name=parent.frames[1].document.forms[0].pract_name;
	}
	else
	{
		if(parent.frames[1].document.forms[0].res_name.readOnly==true)
			return;
					
		var facilityid = parent.frames[1].document.forms[0].fac_id.value;
		var clinic_code = parent.frames[1].document.forms[0].res_unit.value;
		var res_type=parent.frames[1].document.forms[0].res_type.value
					 
		if(!target_name)
			target_name=parent.frames[1].document.forms[0].res_name;
	}
		 
		if(!target_name.value)
			target_name.value="";

		getPractitioner(target_id,target_name,facilityid,'','',clinic_code,'',callfunc,res_type,'',"Q7");

		/*

		target_name.value=trimString(target_name.value);
		
		var practitionerName=target_name.name;
		var practitionerValue=target_name.value;		
				  
		var sql = "Select a.practitioner_id practitioner_id,b.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, decode(b.position_code, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',b.position_code) job_title, b.gender, primary_splty_short_desc primary_specialty from am_pract_for_facility a, am_practitioner_vw b , op_clinic c  where b.practitioner_id = a.practitioner_id and a.eff_status = 'E' and a.facility_id = '"+facilityid+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"'";
		if(callfunc == "Resource_unit")
		{
			sql+=" and b.pract_type = nvl('"+res_type+"',b.pract_type)";
		}
		sql+=" and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = '"+facilityid+"' and practitioner_id = b.practitioner_id )) and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name))) and decode(upper(b.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(b.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(b.position_code,'123')) like upper(nvl(?,nvl(b.position_code,'123'))) ";		
		


		var sqlSecond="Select a.practitioner_id practitioner_id,b.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, decode(b.position_code, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',b.position_code) job_title, b.gender, primary_splty_short_desc primary_specialty from am_pract_for_facility a, am_practitioner_vw b , op_clinic c  where b.practitioner_id = a.practitioner_id and a.eff_status = 'E' and a.facility_id = '"+facilityid+"' and c.facility_id = a.facility_id and c.clinic_code = '"+clinic_code+"'";
		if(callfunc == "Resource_unit")
		{
			sqlSecond+=" and b.pract_type = nvl('"+res_type+"',b.pract_type)";
		}
		sqlSecond+="and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = '"+facilityid+"' and practitioner_id = b.practitioner_id )) and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) and upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name))) and decode(upper(b.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(b.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(b.position_code,'123')) like upper(nvl(?,nvl(b.position_code,'123'))) ";	
		
		
		
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" + practitionerName + "\""	;
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practitionerValue) + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sqlSecond)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + "" + "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";

	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);*/
	
}

/*
  This function is used to retrieve the practitioner name.
  This function called in an intermediate jsp --callGeneralPractitionerSearch.jsp
*/
function PractLookupRetVal(retVal,objName)
{
	var arr;
	var callfunc=parent.frames[1].document.forms[0].call_function.value;
		if(callfunc == "Pract_for_clinic")
	{

		if (retVal != null)
		{
			arr=retVal.split("~");
		
				parent.frames[1].document.forms[0].practitioner.value=arr[0];
				parent.frames[1].document.forms[0].pract_name.value=arr[1];
							
		}
		else
		{
			
				parent.frames[1].document.forms[0].practitioner.value="";
				parent.frames[1].document.forms[0].pract_name.value="";
							
		}
	}
	else
	{

		if (retVal != null)
		{
			arr=retVal.split("~");
		
				parent.frames[1].document.forms[0].res_id.value=arr[0];
				parent.frames[1].document.forms[0].res_name.value=arr[1];
							
		}
		else
		{
			
				parent.frames[1].document.forms[0].res_id.value="";
				parent.frames[1].document.forms[0].res_name.value="";
							
		}
	}	
}

function assigndays(obj)
{
	
	
	if (obj.checked==true)
	{
		obj.value='W';
		parent.frames[1].document.getElementById(obj.name+"1").value="W";	
	
	}
	else
	{
		obj.value = 'N';
		parent.frames[1].document.getElementById(obj.name+"1").value="N";	
	}
}
function assignval(obj)
{
	if(obj.name != "active")
	{
		if (obj.checked==true)
		{
			obj.value='Y';
			parent.f_query_add_mod.document.getElementById(obj.name+"1").value="Y";	
		}
		else
		{
			obj.value='N';
			parent.f_query_add_mod.document.getElementById(obj.name+"1").value="N";	
		}

	}
	else
	{
		if (obj.checked==true)
		{
			obj.value='E';			
		}
		else
		{
			obj.value='D';			
		}
	}
}

function chekUnchek(obj,ival)
{
    var sname=obj.name;
	if(obj.value=="A")
	{
		for(j=1;j<=5;j++)
		{
         
		if(document.getElementById('pract_working_week_'+j+'_day_'+ival).disabled==false)
			{
				document.getElementById('pract_working_week_'+j+'_day_'+ival).checked=true;
				document.getElementById('pract_working_week_'+j+'_day_'+ival).value='W';
				document.getElementById('pract_working_week_'+j+'_day_'+ival+'1').value='W';
			}
		}
	}
	else if(obj.value=="W")
	{	

		for(j=1;j<=5;j++)
		{
			if(document.getElementById('pract_working_week_'+j+'_day_'+ival).disabled==false)
			{
				alert("pclinic 320");
				document.getElementById('pract_working_week_'+j+'_day_'+ival).checked=false;	
				document.getElementById('pract_working_week_'+j+'_day_'+ival).value='N';	
				document.getElementById('pract_working_week_'+j+'_day_'+ival+'1').value='N';	
			}
		}
	}

}

function assignweekappl(val,val1,i)
{
	
	
	if(val == val1)
	{
		document.getElementById('pract_week_appl_day_'+i).value=val1;
	}
	else
	{
		document.getElementById('pract_week_appl_day_'+i).value=val;
	}
}

function clearPractVals()
{
	if(document.getElementById('pract_name').value != '')
		document.getElementById('pract_name').value='';
}



