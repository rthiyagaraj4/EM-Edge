var added_items = new Map();
var added_patients = new Map();
var added_volumes = new Map();

var reset_flag = 'Y';
function reset()
{
	
	criteria_frame.document.FMReturnToMRDCriteriaForm.reset();
	criteria_frame.document.FMReturnToMRDCriteriaForm.reset_flag.value='N';

	patient_id_max_length = criteria_frame.document.FMReturnToMRDCriteriaForm.patient_id_max_length.value;
	var doc_or_file = criteria_frame.document.forms[0].doc_or_file.value;
	if(doc_or_file != 'D')
	{
	if (criteria_frame.document.FMReturnToMRDCriteriaForm.file_type_appl_yn.value == "N")
	{
			criteria_frame.document.getElementById("FileNo").innerHTML = "<input type='Text' name='file_no' id='file_no' value = '' onBlur='getPatIDVolume(this.value);' maxlength='"+patient_id_max_length+"'><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
			criteria_frame.document.FMReturnToMRDCriteriaForm.file_no.disabled = false;
	}
	else if (criteria_frame.document.FMReturnToMRDCriteriaForm.file_type_appl_yn.value == "Y")
	{
			criteria_frame.document.getElementById("FileType").innerHTML = "<input type='Text' name='file_type' id='file_type' value = ''><img src='../../eCommon/images/mandatory.gif' align='center'></img>";
			criteria_frame.document.FMReturnToMRDCriteriaForm.patient_file_type.value = "";
			//criteria_frame.document.FMReturnToMRDCriteriaForm.file_type.disabled = false;
	}
	
	var selectBox   =	criteria_frame.document.FMReturnToMRDCriteriaForm.volume_no;
	var seletLen	=	Math.abs(selectBox.length);
	for (i=0; i<seletLen; i++)
		selectBox.delete(0);
	var selectOption	=  criteria_frame.document.createElement("OPTION");		
	selectOption.value	=	"";
	selectOption.text	=	"---"+getLabel("Common.defaultSelect.label","common")+"---";
	selectBox.set(selectOption);
	}
	
	selectBox   =	criteria_frame.document.FMReturnToMRDCriteriaForm.fs_req_location;
	seletLen	=	Math.abs(selectBox.length);
	for (i=0; i<seletLen; i++)
		selectBox.delete(0);
	var selectOption	=  criteria_frame.document.createElement("OPTION");		
	selectOption.value	=	"";
	selectOption.text	=	"--------"+getLabel("Common.defaultSelect.label","common")+"--------";
	selectBox.set(selectOption);
	
	criteria_frame.document.forms[0].fs_location1.disabled = false;
	criteria_frame.document.forms[0].fs_req_location.disabled = false;
	criteria_frame.document.forms[0].returning_desc.disabled = false;
	criteria_frame.document.forms[0].ret_button.disabled = false;
	criteria_frame.document.forms[0].patient_id.disabled = false;
	if(doc_or_file != 'D') 
	{
	criteria_frame.document.forms[0].pat_search.disabled = false;
	}
	criteria_frame.document.forms[0].all_button.disabled = false;
	if (criteria_frame.document.forms[0].file_type_appl_yn.value == "N")
		criteria_frame.document.forms[0].file_no.disabled = false;
	/*else if (criteria_frame.document.forms[0].file_type_appl_yn.value == "Y")
		criteria_frame.document.forms[0].file_type.disabled = false;*/
	if(doc_or_file != 'D')
	{
	criteria_frame.document.forms[0].volume_no.disabled = false;
	}
	result_frame.document.location.href="../../eCommon/html/blank.html";
	messageFrame.document.location.href="../../eCommon/jsp/error.jsp";

	
}
async function apply()
{
	if ((result_frame.document.FMReturnToMRDResultForm == null)||(result_frame.document.FMReturnToMRDResultForm.valid_records.value==""))
	{
//		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=APP-002413 No Changes to Save ....";
		var msg1=getMessage("NO_CHANGE_TO_SAVE","common");
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=" + msg1;
		return;
	}
	else
	{
		var doc_or_file = criteria_frame.document.forms[0].doc_or_file.value;
		p_doc_folder_id = "";
		p_doc_type_code = "";
		
		var retValue = 	new String();
		var dialogHeight	= "25vh" ;
		var dialogWidth		= "30vw" ;
		var dialogTop		= "185" ;
		var dialogLeft		= "250" ;
		var center			= "0" ;
		var status			= "no";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + ";dialogLeft:" + dialogLeft;
		var arguments		= "" ;
		retValue				= await window.showModalDialog( "../../eFM/jsp/FMIssueFileModelWindow.jsp?from=tab", arguments, features );
	
		if (retValue != null)
		{
			var retArray = unescape(retValue).split("::");
			result_frame.document.FMReturnToMRDResultForm.transport_mode.value		= retArray[0];
			result_frame.document.FMReturnToMRDResultForm.transport_mode_desc.value	= retArray[1];
		}
		if(doc_or_file == 'D')
		{
		if(result_frame.document.FMReturnToMRDResultForm.doc_folder_ids)
			{
			result_frame.document.FMReturnToMRDResultForm.doc_folder_ids.value = p_doc_folder_id;
			}
		}		
		result_frame.document.FMReturnToMRDResultForm.target = "messageFrame";
		result_frame.document.FMReturnToMRDResultForm.method = "POST";
		result_frame.document.FMReturnToMRDResultForm.action = "../../servlet/eFM.FMReturnToMRDServlet";
		result_frame.document.FMReturnToMRDResultForm.submit();
	}
}
////*********** ******** JS files of FMReturnToMRDCriteria.jsp       ****************//



function getValidSearchResult()
{
	
	var nameArray	=	new Array();
	var valueArray	=	new Array();

	nameArray[nameArray.length]		=	document.FMReturnToMRDCriteriaForm.fs_req_location;
	valueArray[valueArray.length]	=	getLabel("eFM.FSLocation.label","FM");

	if (document.FMReturnToMRDCriteriaForm.fs_location1.value == "C")
	{
		valueArray[valueArray.length]	=	getLabel("Common.clinic.label","common");
	}
	else if (document.FMReturnToMRDCriteriaForm.fs_location1.value == "N")
	{
		valueArray[valueArray.length]	=	getLabel("Common.nursingUnit.label","common");
	}
	else if (document.FMReturnToMRDCriteriaForm.fs_location1.value == "Y")
	{
		valueArray[valueArray.length]	=	getLabel("Common.DaycareUnit.label","common");
	}
	else if (document.FMReturnToMRDCriteriaForm.fs_location1.value == "E")
	{
		valueArray[valueArray.length]	=	getLabel("Common.ProcedureUnit.label","common");
	}
	else if (document.FMReturnToMRDCriteriaForm.fs_location1.value == "T")
	{
		valueArray[valueArray.length] = getLabel("Common.practitioner.label","common");
	}
	else if (document.FMReturnToMRDCriteriaForm.fs_location1.value == "")
	{
		valueArray[valueArray.length]	=	getLabel("eFM.Returning.label","FM");
	}

	document.FMReturnToMRDCriteriaForm.show_all_yn.value	=	"Y";
	document.FMReturnToMRDCriteriaForm.added_items.value	= 	"";
	document.FMReturnToMRDCriteriaForm.added_patients.value = 	"";
	document.FMReturnToMRDCriteriaForm.added_volumes.value = 	"";
	added_items.clear();
	added_patients.clear();
	added_volumes.clear();
	if (checkFields(nameArray, valueArray, parent.messageFrame))
	{
		parent.criteria_frame.document.forms[0].all_button.disabled = true;		
		parent.criteria_frame.document.forms[0].add_button.disabled=true;	
		parent.criteria_frame.document.forms[0].clear_button.disabled=true;
		document.FMReturnToMRDCriteriaForm.submit();
		
		}
	else
		parent.criteria_frame.document.forms[0].all_button.disabled = false;		
}
function enableTransportMode(transport_mode)
{
	if (transport_mode != "")
	{
		var transArray	=	new Array();
		transArray		=	transport_mode.split("||");
		if (transArray[1] == "Y")
			document.forms[0].transport_mode_desc.disabled = false;
	}
}
function getPractitioner(obj, target)
{
	var practName_FName="";
	var practName_FValue="";

	practName_FName=target.name;
	practName_FValue=target.value;

	var facility_id		= document.forms[0].facilityID.value;
	getPractitioner_common(obj,target,"",facility_id,"Q2");

	//latest var sql = "SELECT  a.Practitioner_id practitioner_id  ,b.Practitioner_name practitioner_name  ,AM_GET_DESC.AM_PRACT_TYPE(b.PRACT_TYPE,'"+localeName+"','1') practitioner_type ,AM_GET_DESC.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  ,b.gender gender  ,b.POSITION_CODE job_title  FROM  am_pract_for_facility a  , am_practitioner_lang_vw b WHERE a.facility_id= '"+facility_id+"'   AND a.practitioner_id = b.practitioner_id   and b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?)   AND b.primary_speciality_code LIKE UPPER(?)   AND   (  UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))   OR UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))  )   AND b.gender LIKE (?)   AND   (  b.JOB_TITLE LIKE (?)   OR b.JOB_TITLE IS  NULL  )";

	//latest var sql2 = "SELECT  a.Practitioner_id practitioner_id  ,b.Practitioner_name practitioner_name  ,AM_GET_DESC.AM_PRACT_TYPE(b.PRACT_TYPE,'"+localeName+"','1') practitioner_type ,AM_GET_DESC.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  ,b.gender gender  ,b.POSITION_CODE job_title  FROM  am_pract_for_facility a  , am_practitioner_lang_vw b WHERE a.facility_id= '"+facility_id+"'   AND a.practitioner_id = b.practitioner_id   and b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?)   AND b.primary_speciality_code LIKE UPPER(?)   AND   (  UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))   AND UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))  )   AND b.gender LIKE (?)   AND   (  b.JOB_TITLE LIKE (?)   OR b.JOB_TITLE IS  NULL  )";
	
	/*var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + practName_FValue + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + "" + "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
//	responseText=xmlHttp.responseText;
//	responseText = trimString(responseText);
//	eval(responseText);	*/

} // End of getPractitioner.
// To be called by the GeneralPractitionerSearch to set Practitioner.

function PractLookupRetVal(retVal,objName)
{

	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		document.forms[0].returning_code.value=arr[0];
		document.forms[0].returning_desc.value=arr[1];			
	}
	else
	{
		document.forms[0].returning_code.value="";
		document.forms[0].returning_desc.value="";			
	}

} // End of PractLookupRetVal().

async function getValidRecords(returning_desc)
{
	
	var	fs_location1	= document.FMReturnToMRDCriteriaForm.fs_location1.value;
	if ((fs_location1 == "C") || (fs_location1 == "N") || (fs_location1 == "E") || (fs_location1 == "Y"))
	{
		var target			= document.forms[0].returning_desc;
		var code			= document.forms[0].returning_code.value;
		var fs_req_location	= document.forms[0].fs_req_location.value;
		var facilityID		= document.forms[0].facilityID.value;	

		var retVal			= new String();
		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;

		if ((fs_location1 == "C"))
		{
			sql	=	"Select clinic_code code, long_desc description from op_clinic_lang_vw where eff_status='E' and facility_id like ? and language_id='"+localeName+"' and mr_location_code like ? and  care_locn_type_ind = 'C' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) ";
			
			window_title	=	getLabel("Common.clinic.label","common");
			
			dataNameArray[0]	= "facility_id" ;
			dataValueArray[0]	= facilityID;
			dataTypeArray[0]	= STRING ;
			
			dataNameArray[1]	= "mr_location_code" ;
			dataValueArray[1]	= fs_req_location;
			dataTypeArray[1]	= STRING ;
		
		}
		else if ((fs_location1 == "Y"))
		{
			sql	=	"Select clinic_code code, long_desc description from op_clinic_lang_vw where eff_status='E' and facility_id like ? and language_id='"+localeName+"' and mr_location_code like ? and  care_locn_type_ind = 'D' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) ";
			
			window_title	=	getLabel("Common.DaycareUnit.label","common");
			
			dataNameArray[0]	= "facility_id" ;
			dataValueArray[0]	= facilityID;
			dataTypeArray[0]	= STRING ;
			
			dataNameArray[1]	= "mr_location_code" ;
			dataValueArray[1]	= fs_req_location;
			dataTypeArray[1]	= STRING ;
		
		}
		else if ((fs_location1 == "E"))
		{
			sql	=	"Select clinic_code code, long_desc description from op_clinic_lang_vw where eff_status='E' and facility_id like ? and language_id='"+localeName+"' and mr_location_code like ? and  care_locn_type_ind = 'E' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) ";
			
			window_title	=	getLabel("Common.ProcedureUnit.label","common");
			
			dataNameArray[0]	= "facility_id" ;
			dataValueArray[0]	= facilityID;
			dataTypeArray[0]	= STRING ;
			
			dataNameArray[1]	= "mr_location_code" ;
			dataValueArray[1]	= fs_req_location;
			dataTypeArray[1]	= STRING ;
		
		}
		else if ((fs_location1 == "N"))
		{
			sql	=	"Select nursing_unit_code code, long_desc description from ip_nursing_unit_lang_vw where eff_status='E' and facility_id like ? and language_id='"+localeName+"' and fs_locn_code like ? and upper(nursing_unit_code) like upper(?) and upper(long_desc) like upper(?) ";
			
			window_title		=	getLabel("Common.nursingUnit.label","common");
			dataNameArray[0]	= "facility_id" ;
			dataValueArray[0]	= facilityID;
			dataTypeArray[0]	= STRING ;
		
			dataNameArray[1]	= "fs_locn_code" ;
			dataValueArray[1]	= fs_req_location;
			dataTypeArray[1]	= STRING ;

		}
		
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "3, 4";
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
		
		retVal = await CommonLookup( window_title, argumentArray );
		
		if(retVal != null && retVal != "" )
		{
			var ret1	=	unescape(retVal);
			arr=ret1.split(",");
			document.forms[0].returning_code.value	=	arr[0];
			document.forms[0].returning_desc.value	=	arr[1];
		}
		else
		{
			document.forms[0].returning_desc.value	=	"";
			document.forms[0].returning_code.value	=	"";
		} 
	}
	if (fs_location1 == "T")
	{
		var target			= document.forms[0].returning_desc;
		var code			= document.forms[0].returning_code;
		getPractitioner(code, target);
	}
}

function getValidLocations(fs_location1)
{
//below line(s) added by venkatesh.S against issue KAUH-SCF-0016 [IN032341] on 23/April/2012
var userSecurity=document.forms[0].userSecurity.value;
//end issue KAUH-SCF-0016 [IN032341]

	if (fs_location1=="D")
	{
		document.forms[0].returning_desc.value		= "";
		document.forms[0].returning_code.value		= "";
		document.forms[0].returning_desc.disabled	= true;
		document.forms[0].ret_button.disabled		= true;
	}
	else
	{ 
		document.forms[0].returning_desc.disabled	= false;
		document.forms[0].ret_button.disabled		= false;
	}
	//var HTMLValue = "<html><body onKeyDown = 'lockKey()'><form name='Dummy_Form' id='Dummy_Form' action='../../eFM/jsp/FMReturnToMRDValidations.jsp' method='POST'><input type='Hidden' name='fs_location1' id='fs_location1' value = '"+fs_location1+"'><input type='Hidden' name='operation' id='operation' value = 'LOCATION'></form></body></html>";
	
	// in below  line(s) one hidden field (userSecurity) added by venkatesh.S against issue KAUH-SCF-0016 [IN032341] on 23/April/2012
	var HTMLValue = "<html><body onKeyDown = 'lockKey()'><form name='Dummy_Form' id='Dummy_Form' action='../../eFM/jsp/FMReturnToMRDValidations.jsp' method='POST'><input type='Hidden' name='fs_location1' id='fs_location1' value = '"+fs_location1+"'><input type='Hidden' name='operation' id='operation' value = 'LOCATION'><input type='Hidden' name='userSecurity' id='userSecurity' value = '"+userSecurity+"'></form></body></html>";
	//end issue KAUH-SCF-0016 [IN032341]
	
	parent.messageFrame.document.write( HTMLValue);
	parent.messageFrame.document.Dummy_Form.submit();
}
function clearPage()
{
	var doc_or_file = document.forms[0].doc_or_file.value;

	parent.patient_line_frame.document.location.href = "../../eCommon/html/blank.html";
	parent.result_frame.document.location.href		 = "../../eCommon/html/blank.html";
	parent.messageFrame.document.location.href		 = "../../eCommon/jsp/error.jsp";

	parent.criteria_frame.document.forms[0].search.disabled		= false;
	parent.criteria_frame.document.forms[0].patient_id.disabled = false;

	if(doc_or_file != 'D')
	{
		parent.criteria_frame.document.forms[0].pat_search.disabled = false;
	}
	if (document.forms[0].file_type_appl_yn.value == "N")
		parent.criteria_frame.document.forms[0].file_no.disabled = false;
	/*else if (document.forms[0].file_type_appl_yn.value == "Y")
		parent.criteria_frame.document.forms[0].file_type.disabled = false;*/
}
function searchForRecord(val)
{
	
if(document.FMReturnToMRDCriteriaForm.reset_flag.value != 'Y')
	{
		added_items.clear();
		added_patients.clear();
		added_volumes.clear();
		document.FMReturnToMRDCriteriaForm.reset_flag.value = 'Y'
	}

	var nameArray	=	new Array();
	var valueArray	=	new Array();
	var p_stored_val="";
	p_stored_val=document.FMReturnToMRDCriteriaForm.p_stored_val.value;
	var doc_or_file =	document.FMReturnToMRDCriteriaForm.doc_or_file.value;

	nameArray[nameArray.length]		=	document.FMReturnToMRDCriteriaForm.fs_req_location;
	valueArray[valueArray.length]	=	getLabel("eFM.FSLocation.label","FM");
	
	//temporairly commented for returning old files to MRD .
	//nameArray[nameArray.length]		=	document.FMReturnToMRDCriteriaForm.returning_code;

	/*if (document.FMReturnToMRDCriteriaForm.fs_location.value == "C")
	{
		valueArray[valueArray.length]	=	"Clinic";
	}
	else if (document.FMReturnToMRDCriteriaForm.fs_location.value == "N")
	{
		valueArray[valueArray.length]	=	getLabel("Common.nursingUnit.label","common");
	}
	else if (document.FMReturnToMRDCriteriaForm.fs_location.value == "Y")
	{
		valueArray[valueArray.length]	=	"Daycare Unit";
	}
	else if (document.FMReturnToMRDCriteriaForm.fs_location.value == "E")
	{
		valueArray[valueArray.length]	=	"Procedure Unit";
	}
	else if (document.FMReturnToMRDCriteriaForm.fs_location.value == "T")
	{
		valueArray[valueArray.length]	=	"Practitioner";
	}
	else
	{
		valueArray[valueArray.length]	=	"Returning";
	}*/

	if(doc_or_file == 'D')
	{
		nameArray[nameArray.length]		=	document.FMReturnToMRDCriteriaForm.doc_folder_id;
		valueArray[valueArray.length]	=	getLabel("eFM.DocumentFolder.label","FM");
		nameArray[nameArray.length]		=	document.FMReturnToMRDCriteriaForm.doc_type_id;
		valueArray[valueArray.length]	=	getLabel("Common.documenttype.label","common");
	}
	else if(doc_or_file == 'F')
	{
	
		nameArray[nameArray.length]		=	document.FMReturnToMRDCriteriaForm.patient_id;
		valueArray[valueArray.length]	=	getLabel("Common.patientId.label","common");

	if (document.forms[0].file_type_appl_yn.value== "N")
	{
		nameArray[nameArray.length]		=	document.FMReturnToMRDCriteriaForm.file_no;
		valueArray[valueArray.length]	=	getLabel("Common.fileno.label","common");
	}
	else if (document.forms[0].file_type_appl_yn.value== "Y")
	{
		nameArray[nameArray.length]		=	document.FMReturnToMRDCriteriaForm.patient_file_type;
		valueArray[valueArray.length]	=	getLabel("Common.filetype.label","common");
	}
	}
	if (document.FMReturnToMRDCriteriaForm.file_no.value != "")
	{
		var file_no		= "'"+document.FMReturnToMRDCriteriaForm.file_no.value+"'";
		var patient_id	= "'"+document.FMReturnToMRDCriteriaForm.patient_id.value+"'";
		if(doc_or_file != 'D')
		{
		var volume_no	= "'"+document.FMReturnToMRDCriteriaForm.volume_no.value+"'";
			}
		if (!added_items.has(file_no))
				added_items.set(file_no, file_no);
		if (!added_patients.has(patient_id))
				added_patients.set(patient_id, patient_id);
		if(doc_or_file != 'D')
		{
		if (!added_volumes.has(volume_no))
				added_volumes.set(volume_no, volume_no);
		}
	
     var patient_id1= document.FMReturnToMRDCriteriaForm.patient_id.value;
	var  volume_no1=document.FMReturnToMRDCriteriaForm.volume_no.value;
	 
	  if(val=="1")
		volume_no1="1";
	 
	  if(patient_id1=="")
		{
          

		}else
		{
           p_stored_val=p_stored_val+"/"+patient_id1+"`"+volume_no1;
		 }
		
		if(p_stored_val=="")
		{
        document.FMReturnToMRDCriteriaForm.p_stored_val.value = "";
		}else{
     document.FMReturnToMRDCriteriaForm.p_stored_val.value =p_stored_val;
		}


		document.FMReturnToMRDCriteriaForm.added_items.value = Array.from(added_items.keys()).toString();
document.FMReturnToMRDCriteriaForm.added_patients.value = Array.from(added_patients.keys()).toString();
document.FMReturnToMRDCriteriaForm.added_volumes.value = Array.from(added_volumes.keys()).toString();

	}
	
	document.FMReturnToMRDCriteriaForm.show_all_yn.value = "N";

	if (checkFields(nameArray, valueArray, parent.messageFrame))
	{
		document.FMReturnToMRDCriteriaForm.fs_req_location.disabled = false;
		parent.criteria_frame.document.forms[0].all_button.disabled =true;
	    parent.criteria_frame.document.forms[0].add_button.disabled=true;
		parent.criteria_frame.document.forms[0].clear_button.disabled=true;
		document.FMReturnToMRDCriteriaForm.submit();
	}
}

function clearPages()
{
	var doc_or_file = document.forms[0].doc_or_file.value;
	

	parent.criteria_frame.document.forms[0].fs_location1.disabled = false;
	parent.criteria_frame.document.forms[0].fs_req_location.disabled = false;
	parent.criteria_frame.document.forms[0].returning_desc.disabled = false;
	parent.criteria_frame.document.forms[0].ret_button.disabled = false;
	parent.criteria_frame.document.forms[0].patient_id.disabled = false;
	document.FMReturnToMRDCriteriaForm.p_stored_val.value="";
	//parent.criteria_frame.document.forms[0].file_type.value ="";
	//parent.criteria_frame.document.forms[0].file_type.value="";
	
	var fs_location1=parent.criteria_frame.document.forms[0].fs_location1.value;
	if (fs_location1=="D")
	{
		document.forms[0].returning_desc.value		= "";
		document.forms[0].returning_code.value		= "";
		document.forms[0].returning_desc.disabled	= true;
		document.forms[0].ret_button.disabled		= true;
	}
	else
	{
		document.forms[0].returning_desc.disabled	= false;
		document.forms[0].ret_button.disabled		= false;
	}
		
	if(doc_or_file != 'D')
	{
	parent.criteria_frame.document.forms[0].pat_search.disabled = false;
	}
	if (parent.criteria_frame.document.forms[0].file_type_appl_yn.value == "N")
		parent.criteria_frame.document.forms[0].file_no.disabled = false;
	/*else if (parent.criteria_frame.document.forms[0].file_type_appl_yn.value == "Y")
		parent.criteria_frame.document.forms[0].file_type.disabled = false;*/
	if(doc_or_file != 'D')
	{
	parent.criteria_frame.document.forms[0].volume_no.disabled = false;
	}
	parent.criteria_frame.document.forms[0].all_button.disabled = false;

	parent.result_frame.document.location.href="../../eCommon/html/blank.html";
	parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
	parent.criteria_frame.document.FMReturnToMRDCriteriaForm.reset_flag.value='N';
}
function clearReturning()
{
	document.forms[0].returning_desc.value = '';
	document.forms[0].returning_code.value = '';
    document.forms[0].patient_id.value="";
	document.forms[0].patient_id.onblur();
}

////******************** End of JS files of FMReturnToMRDCriteria.jsp ****************//

function changeCursor(obj) 
{
	obj.style.cursor = "hand" ;
}
async function callPatDetails(Patient_ID) 
{
	var dialogHeight	= "28" ;
	var dialogWidth		= "50" ;
	var dialogTop		= "84" ;
	var dialogLeft		= "55" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + ";dialogLeft:" + dialogLeft;
	var arguments		= "" ;
	retVal				= await window.showModalDialog( "../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID="+escape(Patient_ID), arguments, features );
}
////********* JS files of FMReturnTOMRDResult.jsp *********************//

var valid_values = new Map();
function markCheckedRecords(checkBox)
{
	var pageNo = document.FMReturnToMRDResultForm.pageflag.value;

	var pagesClicked = document.FMReturnToMRDResultForm.pagesClicked.value;

	if(pagesClicked.indexOf(pageNo)==-1)
		pagesClicked = pagesClicked+pageNo+"#";	

	document.FMReturnToMRDResultForm.pagesClicked.value = pagesClicked;

	var valid_records	=	document.FMReturnToMRDResultForm.valid_records.value;
	var validArray		=	valid_records.split(",");
	var validLength		=	Math.abs(validArray.length);	
	for (i=0; i<validLength; i++)
		if (!valid_values.has(validArray[i]))
			valid_values.set(validArray[i], validArray[i]);
	if (checkBox.checked)
		if (!valid_values.has(checkBox.value))
			valid_values.set(checkBox.value, checkBox.value);
	if (!checkBox.checked)
		if (valid_values.has(checkBox.value))
			valid_values.delete(checkBox.value);
	document.FMReturnToMRDResultForm.valid_records.value = Array.from(valid_values.keys()).toString();
}			
function submitNext(from, to)
{
	var pageflag = document.FMReturnToMRDResultForm.pageflag.value;
	pageflag++;
	FMReturnToMRDResultForm.pageflag.value=pageflag;
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}
function submitPrev(from, to)
{
	var pageflag=document.FMReturnToMRDResultForm.pageflag.value;
	pageflag--;
	FMReturnToMRDResultForm.pageflag.value=pageflag;
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}
////********* end of JS files of FMReturnTOMRDResult.jsp *********************//
function closeWindow()
{
	var retValue =  document.forms[0].date_time.value+"$$"+document.forms[0].transport_mode.value;
	retValue	+= "$$"+document.forms[0].transport_mode_desc.value;
	window.returnValue = retValue;
	window.close();
}
function onSuccess()
{
	criteria_frame.document.location.reload();
	result_frame.document.location.href="../../eCommon/html/blank.html";
}
async function showEncounter(enc,patid,fileno,Patient_Class)
{
	
	var call_function = "VIEW_ENCOUNTER_DTLS";
	var jsp_name="FMCurrentEncounterMain.jsp";
	var win_height = "30.8";
	var win_width= "50";
	var retVal = 	new String();
	var dialogHeight= win_height ;
	var dialogWidth	= win_width ;
	var dialogTop = "58" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eFM/jsp/"+jsp_name+"?encounterId="+enc+"&call_function="+call_function+"&patientId="+patid+"&fileNo="+fileno+"&Patient_Class="+Patient_Class,arguments,features);
}

