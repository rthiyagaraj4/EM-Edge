async function callPractSearch(obj,target){ //Function for practitioner search.
	
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	var facility_id = document.forms[0].facility_id.value;
	var sqlSec="";
	practName_FName=target.name;
	practName_FValue=target.value;


	sql="SELECT a.practitioner_id practitioner_id,a.position_code, a.practitioner_name,(CASE  WHEN a.pract_type IS NOT NULL       THEN (SELECT desc_sysdef FROM am_pract_type_lang_vw  WHERE language_id = a.language_id                   AND pract_type = a.pract_type) ELSE NULL END) practitioner_type, am_get_desc.am_speciality (d.primary_speciality_code,  '"+localeName+"', 2 ) primary_specialty, DECODE (a.gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender, am_get_desc.am_position (d.position_code, '"+localeName+"', 1) job_title  FROM am_practitioner_lang_vw a, am_pract_all_splty_vw d  WHERE a.language_id = '"+localeName+"'  AND a.pract_type LIKE (?) AND d.facility_id = nvl('"+facility_id+"',d.facility_id)  AND a.practitioner_id = d.practitioner_id   AND UPPER (d.primary_speciality_code) like nvl(replace(?,'%',''),UPPER (a.primary_speciality_code)) AND (UPPER (d.practitioner_id) like UPPER (nvl(?,d.practitioner_id))  OR UPPER (a.practitioner_name) LIKE UPPER (NVL (?, a.practitioner_name))) AND a.gender LIKE (?) AND UPPER (NVL (d.position_code, '123')) LIKE  UPPER (NVL (?, NVL (d.position_code, '123'))) order by 2 ";

	sqlSec="SELECT a.practitioner_id practitioner_id,a.position_code, a.practitioner_name,(CASE  WHEN a.pract_type IS NOT NULL  THEN (SELECT desc_sysdef FROM am_pract_type_lang_vw  WHERE language_id = a.language_id                   AND pract_type = a.pract_type) ELSE NULL   END ) practitioner_type, am_get_desc.am_speciality (d.primary_speciality_code,  '"+localeName+"', 2 ) primary_specialty, DECODE (a.gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender, am_get_desc.am_position (d.position_code, '"+localeName+"', 1) job_title   FROM am_practitioner_lang_vw a, am_pract_all_splty_vw d  WHERE a.language_id = '"+localeName+"'  AND a.pract_type LIKE (?)    AND d.facility_id = nvl('"+facility_id+"',d.facility_id)  AND a.practitioner_id = d.practitioner_id   AND UPPER (d.primary_speciality_code) like nvl(replace(?,'%',''),UPPER (a.primary_speciality_code)) AND (UPPER (d.practitioner_id) like UPPER (nvl(?,d.practitioner_id))  AND UPPER (a.practitioner_name) LIKE UPPER (NVL (?, a.practitioner_name))) AND a.gender LIKE (?) AND UPPER (NVL (d.position_code, '123')) LIKE  UPPER (NVL (?, NVL (d.position_code, '123'))) order by 2 ";

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" + practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sqlSec)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + ""+ "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";

	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	//eval(responseText);
	eval(await practSearch(practName_FName,encodeURIComponent(practName_FValue),responseText));	
}

async function practSearch(practName_FName,practName_FValue,responseText) {
	var retVal = 	new String();
	var dialogTop = "10px" ;
	var dialogHeight= "450px" ;
	var dialogWidth	= "700px" ;
		
	if(responseText =="true") {        	
	    dialogWidth="70.5";
	}
	
	var status = "no";
	var arguments	= "" ;
	var tit="Pract Search";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var sqlArray= new Array();
	//var objName="<%=practName_FName%>";
	var objName=practName_FName;
    arguments='';
	
	//retVal = window.showModalDialog("<%=request.getContextPath()%>/eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+"<%=practName_FValue%>"+"&practitioner_type="+"<%=practitioner_type%>"+"&primary_specialty="+"<%=specialty_code%>"+"&job_title="+"<%=job_title%>"+"&gender="+"<%=gender%>",arguments,features);
	
	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practName_FValue+"&practitioner_type="+"\""+"&primary_specialty="+"\""+"&job_title="+"\""+"&gender="+"\"",arguments,features);
	PractLookupRetVal(retVal,objName);
}

function PractLookupRetVal(retVal,objName) //Part of callPractSearch function.
	{
		var arr;
		if (retVal != null)
		{
			arr=retVal.split("~");				
			document.forms[0].practid_desc.value=arr[1];
			document.forms[0].attend_physician_id.value=arr[0];	
			getPractDetail();
		}	
		else
		{
			document.forms[0].practid_desc.value		= "";
			document.forms[0].attend_physician_id.value = "";
			//document.forms[0].surname_pract.value		= "";
			document.forms[0].age.value					= "";
			document.forms[0].licenseNo.value			= "";
		}
	}


async function getattndpract () // function to call callpractsearch if the text field is empty.
{	
	if (document.forms[0].practid_desc.value=="")
		{ 
			document.forms[0].practid_desc.value		= "";
			document.forms[0].attend_physician_id.value = "";
			//document.forms[0].surname_pract.value		= "";
			document.forms[0].age.value					= "";
			document.forms[0].licenseNo.value			= "";

	    }
	else
		{	
		await callPractSearch(document.forms[0].pract_id_search1,document.forms[0].practid_desc); 
		}
}

function Chekmonth(obj)
{
	if(obj.value != "")
	{
		if(obj.value == 0) 
		{
			var msg=getMessage("INVALID_POSITIVE_NUMBER","COMMON");
			setTimeout(function () {
		        obj.select();
		    }, 0);
			alert(msg);
			//obj.select();
			return false;
		}
		if(obj.value > 11) 
		{
			var msg=getMessage("MONTHS_CHECK","COMMON");
			setTimeout(function () {
		        obj.select();
		    }, 0);
			alert(msg);
			//obj.select();
			return false;
		}
	}
}

function Chekyear(obj)
{
	if(obj.value != "")
	{
		if(obj.value == 0) 
		{
			var msg=getMessage("INVALID_POSITIVE_NUMBER","COMMON");
			setTimeout(function () {
		        obj.select();
		    }, 0);
			alert(msg);
			//obj.select();
			return false;
		}
	}
}

function Chekdays(obj)
{
	if(obj.value != "")
	{
		if(obj.value == 0) 
		{
			var msg=getMessage("INVALID_POSITIVE_NUMBER","COMMON");
			setTimeout(function () {
		        obj.select();
		    }, 0);
			alert(msg);
			//obj.select();
			return false;
		}
		if(obj.value > 30) 
		{
			var msg=getMessage("DAYS_CHECK","COMMON");
			setTimeout(function () {
		        obj.select();
		    }, 0);
			alert(msg);
			//obj.select();
			return false;
		}
	}
}

function Chekhours(obj)
{
	if(obj.value != "")
	{
		if(obj.value == 0) 
		{
			var msg=getMessage("INVALID_POSITIVE_NUMBER","COMMON");
			setTimeout(function () {
		        obj.select();
		    }, 0);
			alert(msg);
			//obj.select();
			return false;
		}
		if(obj.value > 23) 
		{
			var msg=getMessage("HR_LESS_TWENTYFOUR","SM");
			setTimeout(function () {
		        obj.select();
		    }, 0);
			alert(msg);
			//obj.select();
			return false;
		}
	}
}

function getPractDetail()
{
	var attend_physician_id = document.forms[0].attend_physician_id.value;
	if (attend_physician_id != "")
	{
		var HTMLValue	= "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='dummy_form' id='dummy_form' action='../../eMP/jsp/MPStillBirthDetailsVal.jsp' method='post' ><input type='Hidden' name='attend_physician_id' id='attend_physician_id' value='"+attend_physician_id+"'><input type='Hidden' name='pract_flag' id='pract_flag' value='Y'></form></body></html>";
		parent.messageFrame.document.write(HTMLValue);
		parent.messageFrame.dummy_form.submit();
	}

}

function checkForMode(objCheck)
{
	if(objCheck.checked== true)
	{
		objCheck.value='Y'
	}
	else
	{
		objCheck.value='N'
	}
}

function onClose()
{
      //Below line added for this CRF ML-MMOH-CRF-0621 
	   var isRegNewbornApplicable = document.forms[0].isRegNewbornApplicable.value ; 
	   var fields ="";
	   var names ="";
	   
	   
	//Below line added for this CRF ML-MMOH-CRF-0621   
   if(isRegNewbornApplicable=="false"){
		 if (document.forms[0].months_rel.value =='' && document.forms[0].days_rel.value =='' && document.forms[0].hours_rel.value =='')
		 {
			document.forms[0].mandatoryChk.value = '';
			 fields = new Array (document.forms[0].practid_desc,		 document.forms[0].cond_cau_dea_main_cod,document.forms[0].mandatoryChk);

			 names = new Array (getLabel("eMP.NameoftheCertperson.label","MP"),getLabel("eMP.MainCauseOfDeath.label","MP"),getLabel("Common.MDH.label","Common")); 	

		 }
		 else
		 {
			 fields = new Array (document.forms[0].practid_desc,		 document.forms[0].cond_cau_dea_main_cod);

			 names = new Array (getLabel("eMP.NameoftheCertperson.label","MP"),getLabel("eMP.MainCauseOfDeath.label","MP")); 	
		 }
	}
  //End this CRF ML-MMOH-CRF-0621   	

        var errs = checkFieldsLocal( fields, names, parent.messageFrame)

        if(errs == null)    errs = '';

        if(errs == '')
        {
			var fetus_entered_days1 ='0';
			var fetus_entered_days2 ='0';
			var fetus_entered_days3 ='0';
			var fetus_entered_days4 ='0';
			
			var max_gestation_days	= document.forms[0].max_gestation_days.value;
			var min_gestation_days	= document.forms[0].min_gestation_days.value;

			var cgk_flag=true;

			if (document.forms[0].months_rel.value != '' || document.forms[0].days_rel.value != ''  || document.forms[0].hours_rel.value != '')
			 {
				var months_rel			= document.forms[0].months_rel.value;
				var days_rel			= document.forms[0].days_rel.value;
				var hours_rel			= document.forms[0].hours_rel.value;
				
				if(months_rel=='') months_rel='0';
				if(days_rel=='') days_rel='0';
				if(hours_rel=='') hours_rel='0';

				if (months_rel != '0')
				{
					fetus_entered_days1   = (parseInt(months_rel) * 31 );
				}
				if (days_rel != '0')
				{
					fetus_entered_days1   = (parseInt(fetus_entered_days1) + parseInt(days_rel)) ;
				}
			
				if (hours_rel != '0')
				{
					fetus_entered_days1  = (parseInt(fetus_entered_days1) +1) ;
				}
					
				if(fetus_entered_days1 > max_gestation_days || fetus_entered_days1 < min_gestation_days)
				{
					  var msg=getMessage("GESTATION_DATE_VALIDATION","MP");
					  alert(msg);
					  document.forms[0].months_rel.value	=	'';
					  document.forms[0].days_rel.value		=	'';
					  document.forms[0].hours_rel.value		=	'';
					  document.forms[0].months_rel.focus();
					  cgk_flag=false;
				}

			}
			if (document.forms[0].months_oth.value != '' || document.forms[0].days_oth.value != ''  || document.forms[0].hours_oth.value != '')
			 {

				var months_oth			= document.forms[0].months_oth.value;
				var days_oth			= document.forms[0].days_oth.value;
				var hours_oth			= document.forms[0].hours_oth.value;

				if(months_oth=='') months_oth='0';
				if(days_oth=='') days_oth='0';
				if(hours_oth=='') hours_oth='0';


				if (months_oth != '0')
				{
					fetus_entered_days2    = (parseInt(months_oth) * 31 );
				}
				if (days_oth != '0')
				{
					fetus_entered_days2    = (parseInt(fetus_entered_days2) + parseInt(days_oth)) ;
				}
				if (hours_oth != '0')
				{
					fetus_entered_days2  = (parseInt(fetus_entered_days2) +1) ;
				}
				if(fetus_entered_days2 > max_gestation_days || fetus_entered_days2 < min_gestation_days)
				{
					  var msg=getMessage("GESTATION_DATE_VALIDATION","MP");
					  alert(msg);
					  document.forms[0].months_oth.value	=	'';
					  document.forms[0].days_oth.value		=	'';
					  document.forms[0].hours_oth.value		=	'';
					  document.forms[0].months_oth.focus();
					  cgk_flag=false;
				}
			 }
			if (document.forms[0].months_preex.value != '' || document.forms[0].days_preex.value != ''  || document.forms[0].hours_preex.value != '')
			 {
				var months_preex		= document.forms[0].months_preex.value;
				var days_preex			= document.forms[0].days_preex.value;
				var hours_preex			= document.forms[0].hours_preex.value;

				if(months_preex=='') months_preex='0';
				if(days_preex=='') days_preex='0';
				if(hours_preex=='') hours_preex='0';


				if (months_preex != '0')
				{
					fetus_entered_days3    = (parseInt(months_preex) * 31 );
				}
				if (days_preex != '0')
				{
					fetus_entered_days3    = (parseInt(fetus_entered_days3) + parseInt(days_preex)) ;
				}
				if (hours_preex != '0')
				{
					fetus_entered_days3  = (parseInt(fetus_entered_days3) +1) ;
				}
				if(fetus_entered_days3 > max_gestation_days || fetus_entered_days3 < min_gestation_days)
				{
					  var msg=getMessage("GESTATION_DATE_VALIDATION","MP");
					  alert(msg);
					  document.forms[0].months_preex.value		=	'';
					  document.forms[0].days_preex.value		=	'';
					  document.forms[0].hours_preex.value		=	'';
					  document.forms[0].months_preex.focus();
					  cgk_flag=false;
				}
			}
			if (document.forms[0].months_related_1.value != '' || document.forms[0].days_related_1.value != ''  || document.forms[0].hours_related_1.value != '')
			 {

				var months_related_1	= document.forms[0].months_related_1.value;
				var days_related_1		= document.forms[0].days_related_1.value;
				var hours_related_1		= document.forms[0].hours_related_1.value;

				if(months_related_1=='') months_related_1='0';
				if(days_related_1=='') days_related_1='0';
				if(hours_related_1=='') hours_related_1='0';



				if (months_related_1 != '0')
				{
					fetus_entered_days4    = (parseInt(months_related_1) * 31 );
				}
				if (days_related_1 != '0')
				{
					fetus_entered_days4    = (parseInt(fetus_entered_days4) + parseInt(days_related_1)) ;
				}
				if (hours_related_1 != '0')
				{
					fetus_entered_days4  = (parseInt(fetus_entered_days4) +1) ;
				}

				
				if(fetus_entered_days4 > max_gestation_days || fetus_entered_days4 < min_gestation_days)
				{
					  var msg=getMessage("GESTATION_DATE_VALIDATION","MP");
					  alert(msg);
					  document.forms[0].months_related_1.value		=	'';
					  document.forms[0].days_related_1.value		=	'';
					  document.forms[0].hours_related_1.value		=	'';
					  document.forms[0].months_related_1.focus();
					  cgk_flag=false;
				}
			 }
          
		  if (cgk_flag)
		  {
			  if (document.forms[0].mate_cond_main_cod.value != ''){
				   var causeofDeath   = document.forms[0].mate_cond_main_cod;
				   var returnval = callCheckMaxLen(causeofDeath,100,getLabel("Common.CauseofDeath.label","Common")); 
				   if (!returnval)
				   {
					   cgk_flag=false;
				   }
			  }
		  }

		  if (cgk_flag)
		  {
			  if (document.forms[0].mate_cond_oth_cod.value != ''){
				   var causeofDeath   = document.forms[0].mate_cond_oth_cod;
				   var returnval = callCheckMaxLen(causeofDeath,100,getLabel("Common.CauseofDeath.label","Common")); 
				   if (!returnval)
				   {
					   cgk_flag=false;
				   }
			  }
		  }

		  if (cgk_flag)
		  {
			  if (document.forms[0].mate_cond_preexist_cod.value != ''){
				   var causeofDeath   = document.forms[0].mate_cond_preexist_cod;
				   var returnval = callCheckMaxLen(causeofDeath,100,getLabel("Common.CauseofDeath.label","Common")); 
				   if (!returnval)
				   {
					   cgk_flag=false;
				   }
			  }
		  }

		  if (cgk_flag)
		  {
			  if (document.forms[0].oth_rel_mate_cond_rel_cod.value != ''){
				   var causeofDeath   = document.forms[0].oth_rel_mate_cond_rel_cod;
				   var returnval = callCheckMaxLen(causeofDeath,100,getLabel("Common.CauseofDeath.label","Common")); 
				   if (!returnval)
				   {
					   cgk_flag=false;
				   }
			  }
		  }

		  if (cgk_flag)
		  {
			  if (document.forms[0].cond_cau_dea_main_cod.value != ''){
				   var causeofDeath   = document.forms[0].cond_cau_dea_main_cod;
				   var returnval = callCheckMaxLen(causeofDeath,100,getLabel("Common.CauseofDeath.label","Common")); 
				   if (!returnval)
				   {
					   cgk_flag=false;
				   }
			  }
		  }

		  if (cgk_flag)
		  {
			  if (document.forms[0].cond_cau_dea_oth_cod.value != ''){
				   var causeofDeath   = document.forms[0].cond_cau_dea_oth_cod;
				   var returnval = callCheckMaxLen(causeofDeath,100,getLabel("Common.CauseofDeath.label","Common")); 
				   if (!returnval)
				   {
					   cgk_flag=false;
				   }
			  }
		  }

		  if (cgk_flag)
		  {
			  if (document.forms[0].cond_cau_dea_preexist_cod.value != ''){
				   var causeofDeath   = document.forms[0].cond_cau_dea_preexist_cod;
				   var returnval = callCheckMaxLen(causeofDeath,100,getLabel("Common.CauseofDeath.label","Common")); 
				   if (!returnval)
				   {
					   cgk_flag=false;
				   }
			  }
		  }

		  if (cgk_flag)
		  {
			  if (document.forms[0].rel_cond_cau_dea_rel_cod.value != ''){
				   var causeofDeath   = document.forms[0].rel_cond_cau_dea_rel_cod;
				   var returnval = callCheckMaxLen(causeofDeath,100,getLabel("Common.CauseofDeath.label","Common")); 
				   if (!returnval)
				   {
					   cgk_flag=false;
				   }
			  }
		  }


		 if(cgk_flag){
			 prep_val();
		 }
	}
	else
	{
		alert(errs);
	}
}

function callCheckMaxLen(obj,noOfChars,Legend)
{
	if(CheckMaxLen(Legend,obj,noOfChars,parent.messageFrame)==false)
	{ 
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",Legend);
		msg = msg.replace("#",noOfChars);
		alert(msg);
		obj.select();
		obj.focus();
		return false;
	}
	else
	{
		return true;
	}
}

function convertDateFormat()
{   
	    var years_main			= document.forms[0].years_main.value;
		var months_main			= document.forms[0].months_main.value;
		var days_main			= document.forms[0].days_main.value;
		var hours_main			= document.forms[0].hours_main.value;

        if (years_main=='') years_main ='0';
        if (months_main=='') months_main ='0';
        if (days_main=='') days_main ='0';
        if (hours_main=='') hours_main ='0';


		var stilBirthDate1      = years_main + '^' + months_main + '^' + days_main + '^' +hours_main;

	    var years_others		= document.forms[0].years_others.value;
	    var months_others		= document.forms[0].months_others.value;
	    var days_others			= document.forms[0].days_others.value;
	    var hours_others		= document.forms[0].hours_others.value;

		if (years_others=='') years_others ='0';
        if (months_others=='') months_others ='0';
        if (days_others=='') days_others ='0';
        if (hours_others=='') hours_others ='0';

		
		var stilBirthDate2      = years_others + '^' + months_others + '^' + days_others + '^' +hours_others;


	    var years_preexist		= document.forms[0].years_preexist.value;
	    var months_preexist		= document.forms[0].months_preexist.value;
	    var days_preexist		= document.forms[0].days_preexist.value;
	    var hours_preexist		= document.forms[0].hours_preexist.value;

		if (years_preexist=='') years_preexist ='0';
        if (months_preexist=='') months_preexist ='0';
        if (days_preexist=='') days_preexist ='0';
        if (hours_preexist=='') hours_preexist ='0';

		var stilBirthDate3      = years_preexist + '^' + months_preexist + '^' + days_preexist + '^' +hours_preexist;


	    var years_related		= document.forms[0].years_related.value;
	    var months_related		= document.forms[0].months_related.value;
	    var days_related		= document.forms[0].days_related.value;
	    var hours_related		= document.forms[0].hours_related.value;

		if (years_related=='') years_related ='0';
        if (months_related=='') months_related ='0';
        if (days_related=='') days_related ='0';
        if (hours_related=='') hours_related ='0';

				
		var stilBirthDate4      = years_related + '^' + months_related + '^' + days_related + '^' +hours_related;


		var months_rel			= document.forms[0].months_rel.value;
		var days_rel			= document.forms[0].days_rel.value;
		var hours_rel			= document.forms[0].hours_rel.value;

		if (months_rel=='') months_rel ='0';
        if (days_rel=='') days_rel ='0';
        if (hours_rel=='') hours_rel ='0';
		
		var stilBirthDate5      = '0^'+months_rel + '^' + days_rel + '^' + hours_rel ;

		var months_oth			= document.forms[0].months_oth.value;
		var days_oth			= document.forms[0].days_oth.value;
		var hours_oth			= document.forms[0].hours_oth.value;

		if (months_oth=='') months_oth ='0';
        if (days_oth=='') days_oth ='0';
        if (hours_oth=='') hours_oth ='0';

		
		var stilBirthDate6      = '0^'+months_oth + '^' + days_oth + '^' + hours_oth ;


		var months_preex		= document.forms[0].months_preex.value;
		var days_preex			= document.forms[0].days_preex.value;
		var hours_preex			= document.forms[0].hours_preex.value;

		if (months_preex=='') months_preex ='0';
        if (days_preex=='') days_preex ='0';
        if (hours_preex=='') hours_preex ='0';

		var stilBirthDate7      = '0^'+months_preex + '^' + days_preex + '^' + hours_preex ;


		var months_related_1	= document.forms[0].months_related_1.value;
		var days_related_1		= document.forms[0].days_related_1.value;
		var hours_related_1		= document.forms[0].hours_related_1.value;

		if (months_related_1=='') months_related_1 ='0';
        if (days_related_1=='') days_related_1 ='0';
        if (hours_related_1=='') hours_related_1 ='0';


		var stilBirthDate8      = '0^'+months_related_1 + '^' + days_related_1 + '^' + hours_related_1 ;

		var stillBirthDates = stilBirthDate1 + '#' + stilBirthDate2 + '#' + stilBirthDate3 + '#' + stilBirthDate4 + '#' + stilBirthDate5 + '#' + stilBirthDate6 + '#' + stilBirthDate7 + '#' + stilBirthDate8 ;  

		var RecordedDates=document.forms[0].recordedDate1.value+'#'+document.forms[0].recordedDate2.value+'#'+document.forms[0].recordedDate3.value+'#'+document.forms[0].recordedDate4.value+'#'+document.forms[0].recordedDate5.value+'#'+document.forms[0].recordedDate6.value+'#'+document.forms[0].recordedDate7.value+'#'+document.forms[0].recordedDate8.value+'#';
		
		document.forms[0].val_done.value="N";

		var HTMLValue	= "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='dummy_form' id='dummy_form' action='../../eMP/jsp/MPStillBirthDetailsVal.jsp' method='post' ><input type='Hidden' name='dateformate_flag' id='dateformate_flag' value='Y'><input type='Hidden' name='stillBirthDates' id='stillBirthDates' value='"+stillBirthDates+"'><input type='Hidden' name='RecordedDates' id='RecordedDates' value='"+RecordedDates+"'></form></body></html>";

		parent.messageFrame.document.write(HTMLValue);
		parent.messageFrame.dummy_form.submit();
		
		assig_vals();

}

function prep_val(){ 
	    var years_main			= document.forms[0].years_main.value;
		var months_main			= document.forms[0].months_main.value;
		var days_main			= document.forms[0].days_main.value;
		var hours_main			= document.forms[0].hours_main.value;

        if (years_main=='') years_main ='0';
        if (months_main=='') months_main ='0';
        if (days_main=='') days_main ='0';
        if (hours_main=='') hours_main ='0';


		var stilBirthDate1      = years_main + 'Y' + months_main + 'M' + days_main + 'D' +hours_main+ 'H' ;

	    var years_others		= document.forms[0].years_others.value;
	    var months_others		= document.forms[0].months_others.value;
	    var days_others			= document.forms[0].days_others.value;
	    var hours_others		= document.forms[0].hours_others.value;

		if (years_others=='') years_others ='0';
        if (months_others=='') months_others ='0';
        if (days_others=='') days_others ='0';
        if (hours_others=='') hours_others ='0';

		
		var stilBirthDate2      = years_others + 'Y' + months_others + 'M' + days_others + 'D' +hours_others+ 'H' ;


	    var years_preexist		= document.forms[0].years_preexist.value;
	    var months_preexist		= document.forms[0].months_preexist.value;
	    var days_preexist		= document.forms[0].days_preexist.value;
	    var hours_preexist		= document.forms[0].hours_preexist.value;

		if (years_preexist=='') years_preexist ='0';
        if (months_preexist=='') months_preexist ='0';
        if (days_preexist=='') days_preexist ='0';
        if (hours_preexist=='') hours_preexist ='0';

		var stilBirthDate3      = years_preexist + 'Y' + months_preexist + 'M' + days_preexist + 'D' +hours_preexist+ 'H' ;


	    var years_related		= document.forms[0].years_related.value;
	    var months_related		= document.forms[0].months_related.value;
	    var days_related		= document.forms[0].days_related.value;
	    var hours_related		= document.forms[0].hours_related.value;

		if (years_related=='') years_related ='0';
        if (months_related=='') months_related ='0';
        if (days_related=='') days_related ='0';
        if (hours_related=='') hours_related ='0';

				
		var stilBirthDate4      = years_related + 'Y' + months_related + 'M' + days_related + 'D' +hours_related+ 'H' ;


		var months_rel			= document.forms[0].months_rel.value;
		var days_rel			= document.forms[0].days_rel.value;
		var hours_rel			= document.forms[0].hours_rel.value;

		if (months_rel=='') months_rel ='0';
        if (days_rel=='') days_rel ='0';
        if (hours_rel=='') hours_rel ='0';
		
		var stilBirthDate5      = months_rel + 'M' + days_rel + 'D' + hours_rel+ 'H' ;

		var months_oth			= document.forms[0].months_oth.value;
		var days_oth			= document.forms[0].days_oth.value;
		var hours_oth			= document.forms[0].hours_oth.value;

		if (months_oth=='') months_oth ='0';
        if (days_oth=='') days_oth ='0';
        if (hours_oth=='') hours_oth ='0';

		
		var stilBirthDate6      = months_oth + 'M' + days_oth + 'D' + hours_oth + 'H' ;


		var months_preex		= document.forms[0].months_preex.value;
		var days_preex			= document.forms[0].days_preex.value;
		var hours_preex			= document.forms[0].hours_preex.value;

		if (months_preex=='') months_preex ='0';
        if (days_preex=='') days_preex ='0';
        if (hours_preex=='') hours_preex ='0';

		var stilBirthDate7      = months_preex + 'M' + days_preex + 'D' + hours_preex + 'H' ;


		var months_related_1	= document.forms[0].months_related_1.value;
		var days_related_1		= document.forms[0].days_related_1.value;
		var hours_related_1		= document.forms[0].hours_related_1.value;

		if (months_related_1=='') months_related_1 ='0';
        if (days_related_1=='') days_related_1 ='0';
        if (hours_related_1=='') hours_related_1 ='0';


		var stilBirthDate8      = months_related_1 + 'M' + days_related_1 + 'D' + hours_related_1+ 'H' ;



		var ret1=document.forms[0].attend_physician_id.value;			
		var ret2=document.forms[0].attendant_at_birth.value;
		if(document.forms[0].autopsy_requried.checked== true)
			{
				var ret3='Y';
			}
			else
			{
				var ret3='N';
			}
		var ret4=	document.forms[0].mate_cond_main_cod.value;
		var ret5=	document.forms[0].mate_cond_oth_cod.value;
		var ret6=	document.forms[0].mate_cond_preexist_cod.value;
		var ret7=	document.forms[0].oth_rel_mate_cond_rel_cod.value;
		var ret8=	document.forms[0].cond_cau_dea_main_cod.value;
		var ret9=	document.forms[0].cond_cau_dea_oth_cod.value;
		var ret10= document.forms[0].cond_cau_dea_preexist_cod.value;
		var ret11= document.forms[0].rel_cond_cau_dea_rel_cod.value;

		if(ret1=="") ret1="@";
		if(ret2=="") ret2="@";
		if(ret3=="") ret3="@";
		if(ret4=="") ret4="@";
		if(ret5=="") ret5="@";
		if(ret6=="") ret6="@";
		if(ret7=="") ret7="@";
		if(ret8=="") ret8="@";
		if(ret9=="") ret9="@";
		if(ret10=="") ret10="@";
		if(ret11=="") ret11="@";

		var return_val=ret1+'^'+ret2+'^'+ret3+'^'+ret4+'^'+stilBirthDate1+'^'+ret5+'^'+stilBirthDate2+'^'+ret6+'^'+stilBirthDate3+'^'+ret7+'^'+stilBirthDate4+'^'+ret8+'^'+stilBirthDate5+'^'+ret9+'^'+stilBirthDate6+'^'+ret10+'^'+stilBirthDate7+'^'+ret11+'^'+stilBirthDate8;


		window.returnValue = return_val ;
		window.close();




}


function assig_vals(){
		if(document.forms[0].val_done.value=='N'){
			setTimeout("assig_vals()",100);
		}else{
			//parent.document.forms[0].recordedDate1.value=document.forms[0].recordedDate1.value;
			//parent.document.forms[0].stillBirthDate1.value=document.forms[0].stillBirthDate1.value;
			var ret1=document.forms[0].practid_desc.value;			
			var ret2=document.forms[0].attend_physician_id.value;
			//var ret3=	document.forms[0].surname_pract.value;
			var ret4=	document.forms[0].age.value;
			var ret5=	document.forms[0].licenseNo.value;
			var ret6=	document.forms[0].attendant_at_birth.value;
			var ret7=	document.forms[0].main_causeofDeath.value;
			var ret8=	document.forms[0].others_causeofDeath.value;
			var ret9=	document.forms[0].preexist_causeofDeath.value;
			var ret10=	document.forms[0].related_causeofDeath.value;
			var ret11=	document.forms[0].rel_causeofDeath.value;
			var ret12=	document.forms[0].others_causeofDeath_1.value;
			var ret13=	document.forms[0].preex_causeofDeath.value;
			var ret14=	document.forms[0].related_causeofDeath_1.value;
			var ret31=	document.forms[0].autopsy_requried.value;

			if(ret1=="") ret1="@";
			if(ret2=="") ret2="@";
			if(ret3=="") ret3="@";
			if(ret4=="") ret4="@";
			if(ret5=="") ret5="@";
			if(ret6=="") ret6="@";
			if(ret7=="") ret7="@";
			if(ret8=="") ret8="@";
			if(ret9=="") ret9="@";
			if(ret10=="") ret10="@";
			if(ret11=="") ret11="@";
			if(ret12=="") ret12="@";
			if(ret13=="") ret13="@";
			if(ret14=="") ret14="@";
			if(ret15=="") ret15="@";
			if(ret16=="") ret16="@";
			if(ret17=="") ret17="@";
			if(ret18=="") ret18="@";
			if(ret19=="") ret19="@";
			if(ret20=="") ret20="@";
			if(ret21=="") ret21="@";
			if(ret22=="") ret22="@";
			if(ret23=="") ret23="@";
			if(ret24=="") ret24="@";
			if(ret25=="") ret25="@";
			if(ret26=="") ret26="@";
			if(ret27=="") ret27="@";
			if(ret28=="") ret28="@";
			if(ret29=="") ret29="@";
			if(ret30=="") ret30="@";
			if(ret31=="") ret31="@";

			var return_val=ret1+'^'+ret2+'^'+ret3+'^'+ret4+'^'+ret5+'^'+ret6+'^'+ret7+'^'+ret8+'^'+ret9+'^'+ret10+'^'+ret11+'^'+ret12+'^'+ret13+'^'+ret14+'^'+ret15+'^'+ret16+'^'+ret17+'^'+ret18+'^'+ret19+'^'+ret20+'^'+ret21+'^'+ret22+'^'+ret23+'^'+ret24+'^'+ret25+'^'+ret26+'^'+ret27+'^'+ret28+'^'+ret29+'^'+ret30+'^'+ret31;

			alert(return_val);

			window.returnValue = return_val ;
			window.close();
		}

}

function CheckForSpecCharsAllCaseAlwSpc1(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*+?() ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}

function checkFieldsLocal( fields, names, messageFrame) 
{
    var errors = "" ;
    for( var i=0; i<fields.length; i++ ) {
        if(trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        }
		else
		{
			var err = getMessage('CAN_NOT_BE_BLANK','Common');
				err = err.replace('$', names[i]);
				errors = errors + err + "\n" ;
		}
    }
    return errors ;
}

function onCloseQuery()
{
	window.close();
}

function disabledFields()
{ 
	var q_finalized_yn =document.forms[0].q_finalized_yn.value;
	var data_upd_allowed_aft_final_yn =document.forms[0].data_upd_allowed_aft_final_yn.value;

	if(q_finalized_yn=="Y" && data_upd_allowed_aft_final_yn=="N")
	{
		//document.forms[0].practid_desc.readOnly = true;
		document.forms[0].practid_desc.disabled= true;
		document.forms[0].pract_id_search1.disabled= true;
		document.forms[0].attendant_at_birth.disabled= true;
		document.forms[0].mate_cond_main_cod.readOnly = true;
		document.forms[0].years_main.readOnly = true;
		document.forms[0].months_main.readOnly = true;
		document.forms[0].days_main.readOnly = true;
		document.forms[0].hours_main.readOnly = true;
		document.forms[0].mate_cond_oth_cod.readOnly = true;
		document.forms[0].years_others.readOnly = true;
		document.forms[0].months_others.readOnly = true;
		document.forms[0].days_others.readOnly = true;
		document.forms[0].hours_others.readOnly = true;
		document.forms[0].mate_cond_preexist_cod.readOnly = true;
		document.forms[0].years_preexist.readOnly = true;
		document.forms[0].months_preexist.readOnly = true;
		document.forms[0].days_preexist.readOnly = true;
		document.forms[0].hours_preexist.readOnly = true;
		document.forms[0].oth_rel_mate_cond_rel_cod.readOnly = true;
		document.forms[0].years_related.readOnly = true;
		document.forms[0].months_related.readOnly = true;
		document.forms[0].days_related.readOnly = true;
		document.forms[0].hours_related.readOnly = true;
		document.forms[0].cond_cau_dea_main_cod.readOnly = true;
		document.forms[0].months_rel.readOnly = true;
		document.forms[0].days_rel.readOnly = true;
		document.forms[0].hours_rel.readOnly = true;
		document.forms[0].cond_cau_dea_oth_cod.readOnly = true;
		document.forms[0].months_oth.readOnly = true;
		document.forms[0].days_oth.readOnly = true;
		document.forms[0].hours_oth.readOnly = true;
		document.forms[0].cond_cau_dea_preexist_cod.readOnly = true;
		document.forms[0].months_preex.readOnly = true;
		document.forms[0].days_preex.readOnly = true;
		document.forms[0].hours_preex.readOnly = true;
		document.forms[0].rel_cond_cau_dea_rel_cod.readOnly = true;
		document.forms[0].months_related_1.readOnly = true;
		document.forms[0].days_related_1.readOnly = true;
		document.forms[0].hours_related_1.readOnly = true;
		document.forms[0].autopsy_requried.disabled= true;
	}
	else
	{
		//document.forms[0].practid_desc.readOnly = false;
		document.forms[0].practid_desc.disabled= false;
		document.forms[0].pract_id_search1.disabled= false;
		document.forms[0].attendant_at_birth.disabled= false;
		document.forms[0].mate_cond_main_cod.readOnly = false;
		document.forms[0].years_main.readOnly = false;
		document.forms[0].months_main.readOnly = false;
		document.forms[0].days_main.readOnly = false;
		document.forms[0].hours_main.readOnly = false;
		document.forms[0].mate_cond_oth_cod.readOnly = false;
		document.forms[0].years_others.readOnly = false;
		document.forms[0].months_others.readOnly = false;
		document.forms[0].days_others.readOnly = false;
		document.forms[0].hours_others.readOnly = false;
		document.forms[0].mate_cond_preexist_cod.readOnly = false;
		document.forms[0].years_preexist.readOnly = false;
		document.forms[0].months_preexist.readOnly = false;
		document.forms[0].days_preexist.readOnly = false;
		document.forms[0].hours_preexist.readOnly = false;
		document.forms[0].oth_rel_mate_cond_rel_cod.readOnly = false;
		document.forms[0].years_related.readOnly = false;
		document.forms[0].months_related.readOnly = false;
		document.forms[0].days_related.readOnly = false;
		document.forms[0].hours_related.readOnly = false;
		document.forms[0].cond_cau_dea_main_cod.readOnly = false;
		document.forms[0].months_rel.readOnly = false;
		document.forms[0].days_rel.readOnly = false;
		document.forms[0].hours_rel.readOnly = false;
		document.forms[0].cond_cau_dea_oth_cod.readOnly = false;
		document.forms[0].months_oth.readOnly = false;
		document.forms[0].days_oth.readOnly = false;
		document.forms[0].hours_oth.readOnly = false;
		document.forms[0].cond_cau_dea_preexist_cod.readOnly = false;
		document.forms[0].months_preex.readOnly = false;
		document.forms[0].days_preex.readOnly = false;
		document.forms[0].hours_preex.readOnly = false;
		document.forms[0].rel_cond_cau_dea_rel_cod.readOnly = false;
		document.forms[0].months_related_1.readOnly = false;
		document.forms[0].days_related_1.readOnly = false;
		document.forms[0].hours_related_1.readOnly = false;
		document.forms[0].autopsy_requried.disabled = false;
	}
}



// ***********************************************************************
function checkLength(Obj,SizeVal)   {
    if ( Obj.value.length > SizeVal )
    {
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("Common.CauseofDeath.label","Common"));
		msg = msg.replace("#",SizeVal);
		alert(msg);
		Obj.select();
		Obj.focus();
		return false;

    }
	else
	    return true;
}
function CheckSplChars(event){
    var strCheck = '&@^||""';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return true;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return false ;
}



// ***********************************************************************

