/*
-----------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
-----------------------------------------------------------------------------------------------------------------------------
20/03/2019   IN067724        Ramya Maddena   20/03/2019       Ramesh G		ML-BRU-CRF-0518
--------------------------------------------------------------------------------------------------------------------
*/
function run(){	
	if(f_query_rep.document.patAudittrailFrm)
	{
		var formobj = f_query_rep.document.patAudittrailFrm;
		var st_auditTrial = formobj.st_auditTrial.value;
	    var p_facility_id = f_query_rep.document.patAudittrailFrm.p_facility_id.value;//IN067724
		var facilityid = f_query_rep.document.patAudittrailFrm.facility_id.value;//IN067724
		if (st_auditTrial == "SPL" )
		{			
			var fields = new Array( formobj.p_specialty_code,formobj.p_start_date_time,formobj.p_end_date_time)

			var names = new Array( getLabel('Common.speciality.label','common'),getLabel('Common.from.label','common'),getLabel('Common.to.label','common'))
					
			
			 if(f_query_rep.checkFields( fields, names, messageFrame))
			{
				 if(f_query_rep.document.forms[0])
					alert(f_query_rep.getMessage('GEN_REP','CA'));	 

				//IN067724 Starts				
                     if(facilityid=='ALL'){
				         formobj.p_report_id.value = "CABSPLAUDTALL";
				         formobj.report.value = "CABSPLAUDTALL";
					 }else{
						 formobj.p_report_id.value = "CABSPLAUDT";
				         formobj.report.value = "CABSPLAUDT";
					 }  //IN067724 ends
  				if( f_query_rep.doDateCheckMsg( formobj.p_start_date_time, formobj.p_end_date_time, messageFrame,'DMY' ))
					f_query_rep.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_rep.document.forms[0].target="messageFrame";
					f_query_rep.document.patAudittrailFrm.submit();
			 }
		}else if (st_auditTrial == "PAT" )
		{
			var fields = new Array( formobj.p_patient_id,formobj.p_start_date_time, formobj.p_end_date_time)

			var names = new Array( getLabel('Common.patientId.label','common'),getLabel('Common.from.label','common'),getLabel('Common.to.label','common'))
					
			
			 if(f_query_rep.checkFields( fields, names, messageFrame))
			{
			 	if(f_query_rep.document.forms[0])
					alert(f_query_rep.getMessage('GEN_REP','CA'));	

				//IN067724 Starts	
                     if(facilityid=='ALL'){
				          formobj.p_report_id.value = "CABPATAUDTALL";
				          formobj.report.value = "CABPATAUDTALL";
					 }else{
						 formobj.p_report_id.value = "CABPATAUDT";
				         formobj.report.value = "CABPATAUDT";
					 } //IN067724 ends
				if( f_query_rep.doDateCheckMsg( formobj.p_start_date_time, formobj.p_end_date_time, messageFrame,'DMY' ))
					f_query_rep.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_rep.document.forms[0].target="messageFrame";
					f_query_rep.document.patAudittrailFrm.submit();
			 }			
		
		}else if (st_auditTrial == "PRAC" )
		{
			var fields = new Array( formobj.p_practitioner_id,formobj.p_start_date_time,formobj.p_end_date_time)

			var names = new Array( getLabel('Common.practitioner.label','common'),getLabel('Common.from.label','common'),getLabel('Common.to.label','common'))
					
			
			 if(f_query_rep.checkFields( fields, names, messageFrame))
			{
				 if(f_query_rep.document.forms[0])
					alert(f_query_rep.getMessage('GEN_REP','CA'));	

				//IN067724 Starts				
                    if(facilityid=='ALL'){
				         formobj.p_report_id.value = "CABPRAAUDTALL";
				         formobj.report.value = "CABPRAAUDTALL";
					}else{
						 formobj.p_report_id.value = "CABPRAAUDT";
				         formobj.report.value = "CABPRAAUDT";
					} //IN067724 ends
				if( f_query_rep.doDateCheckMsg( formobj.p_start_date_time, formobj.p_end_date_time, messageFrame,'DMY' ))
					f_query_rep.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
					f_query_rep.document.forms[0].target="messageFrame";
					f_query_rep.document.patAudittrailFrm.submit();
			 }
			
		}

		
	}
}

function reset(){
	f_query_rep.document.patAudittrailFrm.reset();
	f_query_rep.document.getElementById("patid_row").style="display";
	f_query_rep.document.getElementById("Pract_row").style.display="none";
	f_query_rep.document.getElementById("Splty_row").style.display="none";
	f_query_rep.document.getElementById("PatClass_row").style.display="none";
	f_query_rep.document.getElementById("splty_man_img").style.display="none";	
	
}

async function fnGetPractitionerId(obj)
{
	if (obj != undefined && obj.name == "Practitioner_Name")
	{
		if (obj.value == "")
		{
			document.patAudittrailFrm.p_practitioner_id.value = "";
			document.patAudittrailFrm.Practitioner_Name.value = "";
			document.patAudittrailFrm.p_specialty_code.value = "";
			document.patAudittrailFrm.speciality_name.value = "";
			document.patAudittrailFrm.p_locn_code.value = "";
			document.patAudittrailFrm.Location_Name.value = "";
			document.patAudittrailFrm.p_pract_reln_id.value = "";
			document.patAudittrailFrm.relationship_name.value = "";
			return false;
		}
	}
	var facility_id = document.patAudittrailFrm.p_facility_id.value;
	var Practitioner_Name = document.patAudittrailFrm.Practitioner_Name.value;
	
	var search_code="";
	var search_desc="";	
	search_code="p_practitioner_id";
	search_desc= "practitioner_name";
   
	//var SQL_SELECT ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id='"+facility_id+"' and upper(b.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) ";//comitted for IN067724
	//IN067724 starts
	if(facility_id=="ALL"){
		var SQL_SELECT ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id  and upper(b.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) ";
	}else{
		SQL_SELECT ="select distinct b.practitioner_id code, b.practitioner_name description from SM_APPL_USER a, AM_PRACT_FOR_FACILITY_VW b where  b.practitioner_id = a.func_role_id and b.operating_facility_id='"+facility_id+"' and upper(b.practitioner_id) like upper(?) and upper(b.practitioner_name) like upper(?) ";
	}//IN067724 ends
	var title="Practitioner Lookup";
		
	var serviceVal   ="";
	var search_desc	= "";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = SQL_SELECT;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = Practitioner_Name;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;	
	retArray =await CommonLookup( title, argArray );	

	if (retArray != null && retArray != '' && retArray != "null")
	{		 
		var str =unescape(retArray);
	 	var arr = str.split(",");
	 document.patAudittrailFrm.p_practitioner_id.value = arr[0];
	 document.patAudittrailFrm.Practitioner_Name.value = arr[1];
	 document.patAudittrailFrm.p_specialty_code.value = "";
	 document.patAudittrailFrm.speciality_name.value = "";		
	}else{
		document.patAudittrailFrm.p_practitioner_id.value = "";
		 document.patAudittrailFrm.Practitioner_Name.value = "";
		 document.patAudittrailFrm.p_specialty_code.value = "";
		document.patAudittrailFrm.speciality_name.value = "";
	}	
parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
}

async function callPatientSearch()
{
	var pat_id =await  PatientSearch();

	if(pat_id != null)
		document.patAudittrailFrm.p_patient_id.value = pat_id;
	else
		document.patAudittrailFrm.p_patient_id.value = "";
	parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
}

 function showCalendarValidate(str){	 
		var flg = showCalendar(str);
		document.getElementById(str).focus();
		return flg;
}
function Check_Date(obj,format,locale)
{
	if(obj.value !="")
	{
	if(CheckDate(obj)) 
	{	
		if(isBeforeNow(obj.value,format,locale))
		{
			return true;
		}
		else
		{
			var label=getLabel("Common.DateRange.label","COMMON");
			var msg = getMessage("CANNOT_BE_GREATER_THAN_SYSDATE","CA");			
			msg = msg.replace('$$',label);
			alert(msg);
			obj.value="";
			obj.focus();
			return false;
		}
	}	
	}
}

function checkingDate(obj,format,locale)
{
	var from =document.forms[0].p_start_date_time;
	if(obj.value !="")
	{
	if(CheckDate(obj)) 
	{
		if(!doDateCheckAlert(from,obj))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
			obj.value="";
			obj.focus();
		}else{
			if(isBeforeNow(obj.value,format,locale))
			{
				return true;
			}
			else
			{
				var label=getLabel("Common.DateRange.label","COMMON");
				var msg = getMessage("CANNOT_BE_GREATER_THAN_SYSDATE","CA");
				msg = msg.replace('$$',label);
				alert(msg);
				obj.value="";
				obj.focus();
				return false;
			}
		}
	}
	
	}

}

function fnChangeCriteria(obj)
{	
	if (obj=="SPL")
	{
		document.getElementById("patid_row").style.display="none";
		document.getElementById("Pract_row").style.display="none";
		   document.getElementById("Splty_row").style="display";
		document.getElementById("PatClass_row").style="display";
	   document.getElementById("splty_man_img").style="display";
	}else if (obj=="PAT")
	{
		document.getElementById("patid_row").style="display";
		document.getElementById("Pract_row").style.display="none";
		document.getElementById("Splty_row").style.display="none";
		document.getElementById("PatClass_row").style.display="none";
		document.getElementById("splty_man_img").style.display="none";
	}else if (obj=="PRAC"){
		document.getElementById("patid_row").style.display="none";
		document.getElementById("Pract_row").style="display";
		document.getElementById("Splty_row").style="display";
	 document.getElementById("PatClass_row").style="display";
		document.getElementById("splty_man_img").style.display="none";
	}
	var formobj = document.patAudittrailFrm;
	var locale = formobj.p_language_id.value;
	formobj.p_patient_id.value = "";
	formobj.p_practitioner_id.value = "";
	formobj.Practitioner_Name.value = "";
	formobj.p_specialty_code.value = "";
	formobj.speciality_name.value = "";
	formobj.p_pract_reln_id.value = "";
	formobj.relationship_name.value = "";
	formobj.p_patient_class.value = "";
	formobj.p_locn_code.value = "";
	formobj.Location_Name.value = "";
	formobj.p_report_id.value = "";
	formobj.report.value = "";
	formobj.p_start_date_time.value = getCurrentDate("DMY",locale);
	formobj.p_end_date_time.value = getCurrentDate("DMY",locale);
	parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';

}

async function getSpeciality(obj)
{
	if (obj != undefined && obj.name == "speciality_name")
	{
		if (obj.value == "")
		{			
			document.patAudittrailFrm.p_specialty_code.value = "";
			document.patAudittrailFrm.speciality_name.value = "";
			document.patAudittrailFrm.p_locn_code.value = "";
			document.patAudittrailFrm.Location_Name.value = "";
			document.patAudittrailFrm.p_pract_reln_id.value = "";
			document.patAudittrailFrm.relationship_name.value = "";
			return false;
		}
	}
	var facility_id = document.patAudittrailFrm.p_facility_id.value;
	var practitioner_id = document.patAudittrailFrm.p_practitioner_id.value;
	var language_id = document.patAudittrailFrm.p_language_id.value;
	var speciality_name = document.patAudittrailFrm.speciality_name.value;
	var st_auditTrial = document.patAudittrailFrm.st_auditTrial.value;

	var search_code="";
	var search_desc="";	
	search_code="p_specialty_code";
	search_desc= "speciality_name";
	var SQL_SELECT = "";

	if (st_auditTrial == "SPL" || practitioner_id == "")
	{
		SQL_SELECT = "select a.speciality_code code,am_get_desc.am_speciality (a.speciality_code, '"+language_id+"', '2') description  from am_speciality a where upper(a.speciality_code) like upper(?) and upper(a.short_desc) like upper(?) ";

	}else if (st_auditTrial == "PRAC" && practitioner_id != "")
	{		
		 SQL_SELECT = "select a.speciality_code code,am_get_desc.am_speciality (a.speciality_code, '"+language_id+"', '2') description  from am_speciality a, am_pract_specialities b, am_pract_for_facility c where a.speciality_code = b.speciality_code and c.practitioner_id = b.practitioner_id and b.practitioner_id = '"+practitioner_id+"' and b.facility_id = c.facility_id and c.facility_id = '"+facility_id+"' and upper(a.speciality_code) like upper(?) and upper(a.short_desc) like upper(?) ";
	
	}
   
	var title="Speciality Lookup";
		
	var serviceVal   ="";
	var search_desc	= "";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = SQL_SELECT;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = speciality_name;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;	
	retArray =await CommonLookup( title, argArray );	

	if (retArray != null && retArray != '' && retArray != "null")
	{	
		var str =unescape(retArray);
	 	var arr = str.split(",");
		document.patAudittrailFrm.p_specialty_code.value = arr[0];
		document.patAudittrailFrm.speciality_name.value = arr[1];
		
	}else{
		document.patAudittrailFrm.p_specialty_code.value = "";
		document.patAudittrailFrm.speciality_name.value = "";
	}	
	parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
}

async function getRelationship(obj)
{
	if (obj != undefined && obj.name == "relationship_name")
	{
		if (obj.value == "")
		{
			document.patAudittrailFrm.p_pract_reln_id.value = "";
			document.patAudittrailFrm.relationship_name.value = "";
			return false;
		}
	}
	var facility_id = document.patAudittrailFrm.p_facility_id.value;
	var relationship_name = document.patAudittrailFrm.relationship_name.value;
	var locale = document.patAudittrailFrm.p_language_id.value;
		
	var search_code="";
	var search_desc="";	
	search_code="p_pract_reln_id";
	search_desc= "relationship_name";
   
	var sql_select="select pract_reln_id code, initcap(substr(pract_reln_name,1,30)) description from  ca_pract_reln_lang_vw  where eff_status='E' and language_id ='"+locale+"' and upper(pract_reln_id) like upper(?) and upper(pract_reln_name) like upper(?) order by pract_reln_name";
	
	var title="Relationship Lookup";
		
	var serviceVal   ="";
	var search_desc	= "";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql_select;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = relationship_name;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;	
	retArray =await CommonLookup( title, argArray );	

	if (retArray != null && retArray != '' && retArray != "null")
	{	
		var str =unescape(retArray);
	 	var arr = str.split(",");
		document.patAudittrailFrm.p_pract_reln_id.value = arr[0];
		document.patAudittrailFrm.relationship_name.value = arr[1];
		
	}else{
		document.patAudittrailFrm.p_pract_reln_id.value = "";
		document.patAudittrailFrm.relationship_name.value = "";
	}	
	parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
}

async function getLocation(obj)
{

	if (obj != undefined && obj.name == "Location_Name")
	{
		if (obj.value == "")
		{
			fnClearLocation(obj)
			return false;
		}
	}
	var facility_id = document.patAudittrailFrm.p_facility_id.value;
	var Location_Name = document.patAudittrailFrm.Location_Name.value;
	var locale = document.patAudittrailFrm.p_language_id.value;
	var patient_class = document.patAudittrailFrm.p_patient_class.value;
	
	var search_code="";
	var search_desc="";	
	search_code="p_locn_code";
	search_desc= "Location_Name";
	var sql_select="";

	if (patient_class != "" && facility_id != "")
	{

		if (patient_class == "IP" || patient_class == "DC" )
		{
			if (patient_class == "IP")
			{
				var str = " and APPL_PATIENT_CLASS = 'IP' "
			}else if (patient_class == "DC")
			{
				var str = " and APPL_PATIENT_CLASS = 'DC' "
			}
			
			sql_select="select nursing_unit_code code, short_desc description from ip_nursing_unit_lang_vw where patient_class='"+patient_class+"' and facility_id = '"+facility_id+"' and language_id = '"+locale+"'  and upper(nursing_unit_code) like upper(?) and upper(short_desc) like upper(?) ";	
			
		}if (patient_class == "OP" || patient_class == "EM" )
		{
			if (patient_class == "OP")
			{
				var str = " and LEVEL_OF_CARE_IND = 'A' "
			}else if (patient_class == "EM")
			{
				var str = " and LEVEL_OF_CARE_IND = 'E' "
			}
			
			sql_select="select clinic_code code, short_desc description from op_clinic_lang_vw where  facility_id = '"+facility_id+"' and language_id = '"+locale+"' and upper(clinic_code) like upper(?) and upper(short_desc) like upper(?) "+str;							
		}
		
	
		var title="Location Lookup";
			
		var serviceVal   ="";
		var search_desc	= "";
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		argArray[0] = sql_select;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = Location_Name;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;	
		retArray =await CommonLookup( title, argArray );	

		if (retArray != null && retArray != '' && retArray != "null")
		{	
			var str =unescape(retArray);
		 	var arr = str.split(",");
			document.patAudittrailFrm.p_locn_code.value = arr[0];
			document.patAudittrailFrm.Location_Name.value = arr[1];
			
		}else{
			document.patAudittrailFrm.p_locn_code.value = "";
			document.patAudittrailFrm.Location_Name.value = "";
		}	
		parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	}else{
		parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
		var msg = "";
		/*if (facility_id == "")
		{			
			msg += getMessage("PAT_CLASS_NOT_BLANK","CA");
		}*/
		if (patient_class == "")
		{
			if (msg != "")
			{
				msg +="\n"; 
			}
			msg += getMessage("PAT_CLASS_NOT_BLANK","CA");
		}		
		alert(msg);
		fnClearLocation();
		return false;
	}   
	
		
}

function fnClearLocation(obj)
{
	document.patAudittrailFrm.p_locn_code.value = "";
	document.patAudittrailFrm.Location_Name.value = "";
	if (obj != undefined && obj != null)
	{
		if (obj.value=="XT")
		{
			document.patAudittrailFrm.Location_Name.disabled=true;
			document.patAudittrailFrm.btnLocLookup.disabled=true;
		}else{
			document.patAudittrailFrm.Location_Name.disabled=false;
			document.patAudittrailFrm.btnLocLookup.disabled=false;
		}
	}
	
}
