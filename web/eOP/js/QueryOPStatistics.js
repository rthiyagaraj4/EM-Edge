 
function query() 
	{
	query_frame.location.href ="../../eOP/jsp/OPStat.jsp" ;
	}

function reset() 
	{
		frames[1].frames[0].document.forms[0].reset();
		frames[1].frames[1].document.location.href='../../eCommon/html/blank.html';
	}
function onBlurgetLoc(fac_id,locale,servVal,target)
{		
		if(target.value == "")
		{
			target.value="";
			document.forms[0].opclinic.value="";
			return;
		}

 getLocn(fac_id,locale,servVal,target);

}
function enableSerChg()
{
	document.forms[0].serchg.value="Y";
}
async function getLocn(fac_id,locale,servVal,target)
{

	var serv=document.forms[0].opservice.value;		
   var retVal =    new String();
   var argumentArray  = new Array() ;
   var dataNameArray  = new Array() ;
   var dataValueArray = new Array() ;
   var dataTypeArray  = new Array() ;
   var tit=""; 
   
   var serchg = document.forms[0].serchg.value;
   tit=getLabel('Common.Location.label','Common');
	
   if(serchg=="Y")
   {
		if(servVal=="")
		{
		   sql="select clinic_code code,long_desc description from op_clinic_lang_vw where language_id='"+locale+"' and facility_id = '"+fac_id+"' and eff_status='E' and  upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";
		}
		else
		{ 		
			sql="select clinic_code code,long_desc description from op_clinic_lang_vw where  language_id='"+locale+"' and facility_id = '"+fac_id+"' and eff_status='E' and service_code='"+servVal+"' and  upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";
		}
   } 
   else if(serchg=="N")
   {
			sql="select clinic_code code,long_desc description from op_clinic_lang_vw where facility_id = '"+fac_id+"' and level_of_care_ind='A' and eff_status='E' and care_locn_type_ind='C'  and language_id='"+locale+"' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";
   }	 
	
  // sql ="select clinic_code code,long_desc description from op_clinic_lang_vw where facility_id = '"+fac_id+"' and level_of_care_ind='A' and eff_status='E' and care_locn_type_ind='C'  and language_id='"+locale+"' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";	
   
	
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;				
				retVal = await CommonLookup( tit, argumentArray );			
				
				
				if(retVal != null && retVal != "" )
                {

	             var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];					
				document.forms[0].opclinic.value=arr[0];

          }
}
/*function ValidateDate2(date)
{
	document.forms[0].txtmonyear1.value=date;
}

function ValidateDate(flag)
{
if(flag==true)
	{
	date=document.forms[0].txtmonyear.value
	var dteTo=DateUtils.convertDate(date,"MY",localeName,"en",ValidateDate2);
	
	}
}*/

/*function validateDate(obj)
{
	if(obj.value!="")
		{
			if(validDate(obj.value,'MY',localeName)==false)
				{
				alert(getMessage("INVALID_DATE_FMT","SM"));
				obj.select();	
				return false;
			}
			else
				return true;
		}
}*/

function qryServices()
{
	var errors = new String;
	var errors = "" ;
	
	/*if(trimCheck(qryget_form.txtmonyear.value)) 
	{
		qryget_form.txtmonyear.value = trimString(qryget_form.txtmonyear.value);
		if(!chkdate(qryget_form.txtmonyear))
		{
			errors = errors + getMessage('INVALID_MONTH_YEAR','OP') + "<br>" ;
		}
	}
	else
	{*/

	if(qryget_form.txtmonyear.value=="")
	{
		var err = getMessage('CAN_NOT_BE_BLANK','COMMON');
		var mon=getLabel("Common.month.label","Common");
		var year=getLabel("Common.year.label","Common");		
		var mon_year=mon+"/"+year;		
		err = err.replace('$',mon_year);
		errors = errors + err + "<br>" ;
	}

	var monYear = qryget_form.txtmonyear.value;
	
	if(monYear!="")
		monYear=convertDate(monYear,"MY",localeName,"en");

	if ( errors.length != 0 ) {
		parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		return false ;
	}
	//var ed = qryget_form.txtmonyear1.value;

	var ed = monYear;
	var sc = qryget_form.opservice.value;
	var cc = qryget_form.opclinic.value;
	var speciality = qryget_form.speciality_code.value;
	var source="../../eOP/jsp/OPStatQueryResult.jsp?qry=Y&type=S&cln_code="+cc+"&ent_date="+ed+"&serv_code="+sc+"&speciality_code="+speciality;
	parent.frames[1].location.href=source;

	parent.frames[0].document.getElementById("service_button").disabled=true;
	parent.frames[0].document.getElementById("clinic_button").disabled=true;
	parent.frames[0].document.getElementById("speciality_button").disabled=true;

}

function qryClinics()
{
	var errors = new String;
	var errors = "" ;

	/*if(trimCheck(qryget_form.txtmonyear.value)) 
	{
		qryget_form.txtmonyear.value = trimString(qryget_form.txtmonyear.value);
		if(!chkdate(qryget_form.txtmonyear))
			errors = errors + getMessage('INVALID_MONTH_YEAR','OP') + "<br>" ;
	}
	else
	{ */
	
	if(qryget_form.txtmonyear.value=="")
	{
		var err = getMessage('CAN_NOT_BE_BLANK','COMMON');
		var mon=getLabel("Common.month.label","Common");
		var year=getLabel("Common.year.label","Common");		
		var mon_year=mon+"/"+year;		
		err = err.replace('$',mon_year);
		errors = errors + err + "<br>" ;
	}
		
	var monYear = qryget_form.txtmonyear.value;
	
	if(monYear!="")
		monYear=convertDate(monYear,"MY",localeName,"en");
	
	if ( errors.length != 0 ) {
		parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		return false ;
	}
	var ed = monYear;
	var sc = qryget_form.opservice.value;
	var cc = qryget_form.opclinic.value;
	var speciality = qryget_form.speciality_code.value;
	var source="../../eOP/jsp/OPStatQueryResult.jsp?qry=Y&type=C&cln_code="+cc+"&ent_date="+ed+"&serv_code="+sc+"&speciality_code="+speciality;
	parent.frames[1].location.href=source;

	parent.frames[0].document.getElementById("service_button").disabled=true;
	parent.frames[0].document.getElementById("clinic_button").disabled=true;
	parent.frames[0].document.getElementById("speciality_button").disabled=true;

}

function clearqry()
	{
		parent.frames[1].document.location.href='../../eCommon/html/blank.html';
	}

/*function chkdate(Object) {
	var strMonth;
	var strYear;
	var datefield = Object;
	var strDateArray = new Array();

	var strDate = datefield.value;
	if (strDate.length == 0) return true;

	for(var i=0;i<=strDate.length;i++) {
				if (strDate.charAt(i)=="."){
					return false;
					break;
				}
			}

	strDateArray = strDate.split("/");
	if (strDateArray.length != 2) {
		return false;
	}
	else {
		strMonth = strDateArray[0];
		strYear = strDateArray[1];
	}

	if (strYear.length != 4) return false;

	if (isNaN(strMonth)==true) return false;
	if (isNaN(strYear)==true) return false;

	if (strYear < 1900) return false;

    	if (strMonth>12 || strMonth<1) 	return false;

	return true;
}*/

function populate(serv_code)
{
	HTMLVal = "<html><BODY onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eOP/jsp/RetriveResults.jsp?serv_code="+serv_code+"'></form></BODY></HTML>";
	parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.frames[2].document.form1.submit();
}



function qrySpeciality()
{
	var errors = new String;
	var errors = "" ;
	
	/*if(trimCheck(qryget_form.txtmonyear.value)) 
	{
		qryget_form.txtmonyear.value = trimString(qryget_form.txtmonyear.value);
		if(!chkdate(qryget_form.txtmonyear))
		{
			errors = errors + getMessage('INVALID_MONTH_YEAR','OP') + "<br>" ;
		}
	}
	else
	{*/

	if(qryget_form.txtmonyear.value=="")
	{
		var err = getMessage('CAN_NOT_BE_BLANK','COMMON');
		var mon=getLabel("Common.month.label","Common");
		var year=getLabel("Common.year.label","Common");		
		var mon_year=mon+"/"+year;		
		err = err.replace('$',mon_year);
		errors = errors + err + "<br>" ;
	}

	var monYear = qryget_form.txtmonyear.value;
	
	if(monYear!="")
		monYear=convertDate(monYear,"MY",localeName,"en");

	if ( errors.length != 0 ) {
		parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		return false ;
	}
	//var ed = qryget_form.txtmonyear1.value;

	var ed = monYear;
	var sc = qryget_form.opservice.value;
	var cc = qryget_form.opclinic.value;
	var speciality = qryget_form.speciality_code.value;
	var source="../../eOP/jsp/OPStatQueryResult.jsp?qry=Y&type=A&cln_code="+cc+"&ent_date="+ed+"&serv_code="+sc+"&speciality_code="+speciality;
	parent.frames[1].location.href=source;

	parent.frames[0].document.getElementById("service_button").disabled=true;
	parent.frames[0].document.getElementById("clinic_button").disabled=true;
	parent.frames[0].document.getElementById("speciality_button").disabled=true;

}


async function getValues(obj,target,targetId)
{
			var locale=document.forms[0].locale.value;
			var tit="";
			var facilityid =document.forms[0].facility_id.value;
			var dataNameArray  = new Array() ;
		     var dataValueArray = new Array() ;
		     var dataTypeArray  = new Array() ;
			var argumentArray=new Array(8);
			var sql="";
			var sqlSecond="";
			target.value=trimString(target.value);
			if(target.value=="" && window.event.target == target)
			{
				targetId.value="";
				return;
			}

			if(obj.name=="service_button")
			{
				tit=getLabel("Common.service.label","Common");
          argumentArray[0]="SELECT   service_code code, am_get_desc.AM_SERVICE(service_code,'"+locale+"',2) description FROM   am_facility_service WHERE   operating_facility_id = '"+facilityid+"' AND   eff_status =  'E' AND   UPPER(service_code) LIKE UPPER(NVL(?,service_code)) AND   UPPER(am_get_desc.AM_SERVICE(service_code,'"+locale+"',2)) LIKE UPPER(NVL(?,am_get_desc.AM_SERVICE(service_code,'"+locale+"`',2)))"
				//argumentArray[0]="select service_code code, service_short_desc description from am_facility_service_vw where operating_facility_id like ? and eff_status like ? and upper(service_code) like upper(nvl(?,service_code)) and upper(service_short_desc) like upper(nvl(?,service_short_desc)) ";

				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4]="1,2";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;

			}
			else
			if(obj.name=="locn_button")
			{
				tit=getLabel("Common.Location.label","Common");;
				
				argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id ='"+facilityid+"' and language_id='"+locale+"' and level_of_care_ind ='A' and eff_status ='E' and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc))  ";
				
					argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4]="1,2";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;

			}
			else if(obj.name=="spec_button")
			{
				tit=getLabel("Common.speciality.label","Common");							

				argumentArray[0]="select SPECIALITY_CODE code, am_get_desc.am_speciality(SPECIALITY_CODE,'"+locale+"',2) description from AM_SPECIALITY where EFF_STATUS = 'E' and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(am_get_desc.am_speciality(SPECIALITY_CODE,'"+locale+"',2)) like upper(nvl(?,am_get_desc.am_speciality(SPECIALITY_CODE,'"+locale+"',2)))"; 

				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4]="1,2";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;

			}
			else
			if(obj.name=="pract_button")
			{
				getPractitioner(obj,target,facilityid,'','','','','','','',"Q2");

				/*sql="SELECT    a.practitioner_id practitioner_id, a.practitioner_name practitioner_name,	  am_get_desc.AM_PRACT_TYPE(a.pract_type,'"+locale+"',2) practitioner_type, POSITION_CODE job_title,  DECODE(a.gender, 'M','Male','F','Female','U','Unknown') gender,am_get_desc.AM_SPECIALITY(a.primary_speciality_code,'"+locale+"',2) primary_specialty	FROM   am_practitioner_lang_vw a,  AM_PRACT_FOR_FACILITY b	WHERE 	  b.FACILITY_ID = '"+facilityid+"' AND	  b.EFF_STATUS = 'E' AND	 a.practitioner_id=b.practitioner_id AND  UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND	UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) AND	  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND	  UPPER(a.gender) LIKE UPPER(NVL(?,a.gender)) AND	UPPER(NVL(POSITION_CODE,'123')) LIKE UPPER(NVL(?,NVL(POSITION_CODE,'123'))) AND a.language_id='"+locale+"'";
				

				 sqlSecond = "SELECT    a.practitioner_id practitioner_id, a.practitioner_name practitioner_name,	  am_get_desc.AM_PRACT_TYPE(a.pract_type,'"+locale+"',2) practitioner_type, POSITION_CODE job_title,  DECODE(a.gender, 'M','Male','F','Female','U','Unknown') gender,am_get_desc.AM_SPECIALITY(a.primary_speciality_code,'"+locale+"',2) primary_specialty	FROM   am_practitioner_lang_vw a,  AM_PRACT_FOR_FACILITY b	WHERE 	  b.FACILITY_ID = '"+facilityid+"' AND	  b.EFF_STATUS = 'E' AND	 a.practitioner_id=b.practitioner_id AND  UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND	UPPER(a.primary_speciality_code) LIKE UPPER(NVL(?,a.primary_speciality_code)) AND	  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) and UPPER(a.practitioner_name) LIKE UPPER(NVL(?,a.practitioner_name))) AND	  UPPER(a.gender) LIKE UPPER(NVL(?,a.gender)) AND	UPPER(NVL(POSITION_CODE,'123')) LIKE UPPER(NVL(?,NVL(POSITION_CODE,'123'))) AND a.language_id='"+locale+"'";				 

				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr += " practName_FName=\"" + target.name + "\"";
				xmlStr += " practName_FValue=\"" + encodeURIComponent(target.value) + "\"";
				xmlStr += " sql=\"" +escape(sql)+"\"";
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
				
				eval(responseText);
				*/

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
				targetId.value="";
			}
			else
			{
				targetId.value=arr[0];
				target.value=arr[1];
			}	
		}

