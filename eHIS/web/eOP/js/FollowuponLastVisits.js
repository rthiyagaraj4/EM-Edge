
function query() {
f_query_add_mod.location.href ="../../eOP/jsp/QueryMainFollowuponLastVisits.jsp?function=FollowuponLastVisits" ;
}


function reset() {
frames[1].frames[0].document.forms[0].reset();
frames[1].frames[1].document.location.href='../../eCommon/html/blank.html';
}


async function searchValues(target_id,target)
{
	var facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	//alert(locale);
	var tit="";
	var argumentArray=new Array(8);
	target.value=trimString(target.value);
	if(target.value=="" && window.event.target == target)
		{
			target_id.value="";
			return;
		}
		
	if(target_id.name == "speciality_code")
		{
		  tit=getLabel("Common.speciality.label","Common");
		
		  argumentArray[0]="select SPECIALITY_CODE code, SHORT_DESC description from AM_SPECIALITY_lang_vw where language_id='"+locale+"' and EFF_STATUS = 'E' and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) ";
		  argumentArray[1]=dataNameArray;
		  argumentArray[2]=dataValueArray ;
		  argumentArray[3]=dataTypeArray ;
		  argumentArray[4]="1,2";
		  argumentArray[5]=target.value;
		  argumentArray[6]=CODE_DESC_LINK;
		  argumentArray[7]=CODE_DESC;
			
		}
	  else if(target_id.name == "service_code")
		{
			tit=getLabel("Common.service.label","Common");
			argumentArray[0]="select SERVICE_CODE code, SHORT_DESC description from AM_SERVICE_lang_vw where EFF_STATUS = 'E' and language_id='"+locale+"' and upper(service_code) like upper(nvl(?,service_code)) and upper(short_desc) like upper(nvl(?,short_desc)) ";
			 argumentArray[1]=dataNameArray;
		    argumentArray[2]=dataValueArray ;
		     argumentArray[3]=dataTypeArray ;
			argumentArray[4]="1,2";
			argumentArray[5]=target.value;
			argumentArray[6]=CODE_DESC_LINK;
			argumentArray[7]=CODE_DESC;
			
		}
		else if(target_id.name == "clinic_code")
		{
			tit=getLabel("Common.clinic.label","Common");
			argumentArray[0]="select CLINIC_CODE code, long_desc description from OP_CLINIC_lang_vw where language_id='"+locale+"' and facility_id = '"+facility_id+"' and EFF_STATUS = 'E' and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) ";
			 argumentArray[1]=dataNameArray;
		    argumentArray[2]=dataValueArray ;
		     argumentArray[3]=dataTypeArray ;
			argumentArray[4]="1,2";
			argumentArray[5]=target.value;
			argumentArray[6]=CODE_DESC_LINK;
			argumentArray[7]=CODE_DESC;
		}
		else if(target_id.name == "practitioner_id")
		{
			
			var speciality="";

			if(document.forms[0].speciality_code!=null)
				speciality=document.forms[0].speciality_code.value;

			getPractitioner(target_id,target,facility_id,speciality,'','','','','','',"Q2");

			/*var sql="SELECT    a.practitioner_id practitioner_id, a.practitioner_name practitioner_name,	  am_get_desc.AM_PRACT_TYPE(a.pract_type,'"+locale+"',2) practitioner_type, POSITION_CODE job_title,  DECODE(a.gender, 'M','Male','F','Female','U','Unknown') gender,am_get_desc.AM_SPECIALITY(a.primary_speciality_code,'"+locale+"',2) primary_specialty	FROM   am_practitioner_lang_vw a,  AM_PRACT_FOR_FACILITY b	WHERE 	  b.FACILITY_ID = '"+facility_id+"' AND	  b.EFF_STATUS = 'E' AND	 a.practitioner_id=b.practitioner_id AND  UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND	UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) AND	  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND	  UPPER(a.gender) LIKE UPPER(NVL(?,a.gender)) AND	UPPER(NVL(POSITION_CODE,'123')) LIKE UPPER(NVL(?,NVL(POSITION_CODE,'123'))) AND a.language_id='"+locale+"'"
			
			
			
			//var sql="select a.practitioner_id practitioner_id, a.practitioner_name practitioner_name, b.pract_type_desc practitioner_type, decode(a.job_title, 'CC', 'Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr.Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR', 'Trainee',NULL,'',a.job_title) job_title, decode(a.gender,'M','Male','F','Female','U','Unknown') gender, b.primary_speciality_desc primary_specialty from am_practitioner a,  AM_PRACT_FOR_FACILITY_VW b where b.OPERATING_FACILITY_ID = '"+facility_id+"' and b.EFF_STATUS = 'E' and a.practitioner_id=b.practitioner_id and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(a.practitioner_id) like upper(nvl(?,a.practitioner_id)) or upper(a.practitioner_name) like upper(nvl(?,a.practitioner_name))) and upper(a.gender) like upper(nvl(?,a.gender)) and upper(nvl(a.job_title,'123')) like upper(nvl(?,nvl(a.job_title,'123'))) ";
		
			var sqlSecond="SELECT    a.practitioner_id practitioner_id, a.practitioner_name practitioner_name,	  am_get_desc.AM_PRACT_TYPE(a.pract_type,'"+locale+"',2) practitioner_type, POSITION_CODE job_title,  DECODE(a.gender, 'M','Male','F','Female','U','Unknown') gender,am_get_desc.AM_SPECIALITY(a.primary_speciality_code,'"+locale+"',2) primary_specialty	FROM   am_practitioner_lang_vw a,  AM_PRACT_FOR_FACILITY b	WHERE 	  b.FACILITY_ID = '"+facility_id+"' AND	  b.EFF_STATUS = 'E' AND	 a.practitioner_id=b.practitioner_id AND  UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND	UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) AND	  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) and UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND	  UPPER(a.gender) LIKE UPPER(NVL(?,a.gender)) AND	UPPER(NVL(POSITION_CODE,'123')) LIKE UPPER(NVL(?,NVL(POSITION_CODE,'123'))) AND a.language_id='"+locale+"'";

			var speciality="";
			if(document.forms[0].speciality_code!=null)
				speciality=document.forms[0].speciality_code.value;
			
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	="<root><SEARCH " ;
			xmlStr += " practName_FName=\"" + target.name + "\"";
			xmlStr += " practName_FValue=\"" + encodeURIComponent(target.value) + "\"";
			xmlStr += " sql=\"" +escape(sql)+"\"";
			xmlStr += " sqlSec=\"" +escape(sqlSecond)+ "\"";
			xmlStr += " practitioner_type=\"" + "" + "\"";
			xmlStr += " specialty_code=\"" + speciality + "\"";
			xmlStr += " job_title=\"" + "" + "\"";
			xmlStr += " gender=\"" + "" + "\"";

			xmlStr +=" /></root>" ;
			
			xmlDoc.loadXML( xmlStr );
			xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false );
			xmlHttp.send(xmlDoc);
			
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
			
			eval(responseText);*/

			return;
		}
		var retVal=await CommonLookup(tit,argumentArray);
		var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retVal ==null || retVal=="")
			{
				target.value="";
				target_id.value="";
			}
			else
			{
				target_id.value=arr[0];
				target.value=arr[1];
			}
}


function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null && trimString(retVal) != "")
	{
		arr=retVal.split("~");
		document.forms[0].practitioner_id.value=arr[0];
		document.forms[0].practitioner_name.value=arr[1];			
	}
	else
	{
		document.forms[0].practitioner_id.value="";
		document.forms[0].practitioner_name.value="";			
	}
}


function addOrderByCol() {
	var from = document.getElementById("OrderbyCols");
	if ( from.options.length > 0 ) {
		var to = document.getElementById("OrderbyColumns");
		var element = document.createElement("OPTION");
		element.text = from.options[from.selectedIndex].text;
		element.value= from.options[from.selectedIndex].value;
		to.add(element);
		from.remove(from.selectedIndex);
	}
}

function removeOrderByCol() {
	var from = document.getElementById("OrderbyColumns");
	if ( from.options.length > 0 ) {
		var to = document.getElementById("OrderbyCols");
		var element = document.createElement("OPTION");
		element.text = from.options[from.selectedIndex].text;
		element.value = from.options[from.selectedIndex].value; to.add(element);
		from.remove(from.selectedIndex);
	}
}


function SelectAll() {
	var i = 0; document.getElementById("OrderbyColumns").selectedIndex=0;
	while ( i < document.getElementById("OrderbyColumns").length) {
		document.getElementById("OrderbyColumns").options[i].selected=true;
		i++;
	}
}


function execQuery() {

	var dateFrom = document.forms[0].date_from.value;
	var dateTo = document.forms[0].date_to.value;

	if(dateFrom!="" && dateTo!="")	 
		{
			if(isBefore(dateFrom,dateTo,'DMY',localeName)==false)
			{
				alert(getMessage('TO_DT_GR_EQ_FM_DT','SM'))
				document.forms[0].date_to.select();				
				return false;
			}
		} 

	if(dateFrom!="")
		dateFrom=convertDate(dateFrom,"DMY",localeName,"en");
	if(dateTo!="")
		dateTo=convertDate(dateTo,"DMY",localeName,"en");
	
  // document.forms[0].submit();
	

	if(document.forms[0].created_by.value == "")
		document.forms[0].user.value="";


	var speciality_code =document.forms[0].speciality_code.value;
	var service_code =document.forms[0].service_code.value;
	var clinic_code = document.forms[0].clinic_code.value;
	var practitioner_id =document.forms[0].practitioner_id.value;
	var patient_id =document.forms[0].pat_id.value; 
	var user = document.forms[0].user.value; 
	var visit_date = document.forms[0].visit_date.value; 
	
	parent.frames[1].location.href="../../eOP/jsp/QueryResultFollowuponLastVisits.jsp?date_from="+dateFrom+"&date_to="+dateTo+"&speciality_code="+speciality_code+"&service_code="+service_code+"&clinic_code="+clinic_code+"&practitioner_id="+practitioner_id+"&pat_id="+patient_id+"&user="+user+"&visit_date="+visit_date;

	document.forms[0].search.disabled=true;
}

/*function validateDate(obj)
{
	if(obj.value!="")
		{
			if(validDate(obj.value,'DMY',localeName)==false)
				{
				alert(getMessage("INVALID_DATE_FMT","SM"));
				obj.select();	
				return false;
			}
			else
				return true;
		}
}*/

/*function ValidateDateFrom2(date)
{
	
	document.forms[0].date_from1.value=date;
}

function ValidateDateFrom(flag)
{
if(flag==true)
	{
	date_from=document.forms[0].date_from.value
	var dteFrom=DateUtils.convertDate(date_from,"DMY",localeName,"en",ValidateDateFrom2);	
	}
}

function chkFrom(obj)
{
	
   if(obj.value!="")
		DateUtils.validDate(obj.value,'DMY',localeName,ValidateDateFrom)
   else
	    document.forms[0].date_from1.value="";
   
   /*if(obj.value !='')
	{
	if(CheckDate(obj)){
	var bool=doDateCheckAlert(parent.frames[0].document.forms[0].date_from,parent.frames[0].document.forms[0].date_to);
	if(!bool){
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
		obj.select();
		obj.focus();
	   }
	  }
	}*/
/*}

function ValidateDateTo2(date)
{
	document.forms[0].date_to1.value=date;
}

function ValidateDateTo(flag)
{
if(flag==true)
	{
	date_to=document.forms[0].date_to.value
	var dteTo=DateUtils.convertDate(date_to,"DMY",localeName,"en",ValidateDateTo2);
	
	}
}

function chkTo(obj)
{
	
   if(obj.value!="")
		DateUtils.validDate(obj.value,'DMY',localeName,ValidateDateTo)
   else
	    document.forms[0].date_to1.value="";
   
   /*if(obj.value !='')
	{
	if(CheckDate(obj)){
	var bool=doDateCheckAlert(parent.frames[0].document.forms[0].date_from,parent.frames[0].document.forms[0].date_to);
	if(!bool){
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
		obj.select();
		obj.focus();
	   }
	  }
	}*/
//}


function clearform()
{
	parent.frames[1].location.href='../../eCommon/html/blank.html';
}

async function patqry() {
	var pat_id=await PatientSearch();
	if(pat_id == null) pat_id = "";
	//parent.frames[0].document.query_form.pat_id.value=pat_id;
	document.forms[0].pat_id.value=pat_id;
}

function GetCancellLookupBlur(target)
{
	if(target.value != "")
	{
		GetCancellLookup(target);
	}
}
async function GetCancellLookup(target){

	var sql="";
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;			
	var tit				= getLabel("Common.Createdby.label",'Common');
	sql="select appl_user_id code,appl_user_name description from sm_appl_user where eff_status='E'  and ( (trunc(eff_date_from) <= trunc(sysdate)  and eff_date_to is null )  or (trunc(eff_date_to) >= trunc(sysdate) and eff_date_from is null)  or (eff_date_from is null and eff_date_to is null ) or (trunc(sysdate) between trunc(eff_date_from) and trunc(eff_date_to) and eff_date_from is not null and eff_date_to is not null)) and upper(appl_user_id) like upper(?) and upper(appl_user_name) like upper(?) order by upper(appl_user_name)";
	
	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	=document.forms[0].created_by.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= CODE_DESC;
	retVal = await CommonLookup( tit, argumentArray );
    alert("retVal9"+retVal);
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].created_by.value=arr[1];
		document.forms[0].user.value=arr[0];
		
	
	}
	else
	{
		document.forms[0].created_by.value="";
		document.forms[0].user.value="";
	}

}

function validDt(obj)
{
	
	var dt=parent.frames[0].document.query_form.sys_dt.value;
	
	
	if(obj.value != "")
	{
		parent.frames[0].document.query_form.date_from.value="";
		parent.frames[0].document.query_form.date_to.value="";
		parent.frames[0].document.query_form.date_from.disabled=true;
		parent.frames[0].document.query_form.date_to.disabled=true;
	}
	else
	{
		parent.frames[0].document.query_form.date_from.disabled=false;
		parent.frames[0].document.query_form.date_to.disabled=false;
		parent.frames[0].document.query_form.date_from.value=dt;
		parent.frames[0].document.query_form.date_to.value=dt;
	}

}

