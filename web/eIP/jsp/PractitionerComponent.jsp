<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>
<script src='../../eIP/js/IPPractitionerComponent.js' language='javascript'></script>
<% request.setCharacterEncoding("UTF-8");  %>
<%	
	
	String facilityID			= (String)session.getValue("facility_id");	
	String called_function_id	= request.getParameter("called_function_id");
	called_function_id			= (called_function_id == null)?"":called_function_id;
	String practitioner_desc	= request.getParameter("practitioner_desc");
	practitioner_desc			= (practitioner_desc == null)?"":practitioner_desc;
%>
<script>

// Added by Sridhar on 2 FEB 2004
// This Function will check for empty values before calling up the common lookup func..
function BeforeGetPractitioner(obj, target, getVal)
{
	if(document.forms[0].practid_desc.value !="")
		getPractitionerLocal(obj, target, getVal);
	else
		document.forms[0].practid.value =""
}


// By Annadurai 2/6/2004 ., to use Common Lookup. starts.,
function getPractitionerLocal(obj, target, getVal)
{
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	var call_function = getVal;	

	practName_FName=target.name;
	practName_FValue=target.value;
	practId_FName=document.forms[0].practid.name;
	var locale =document.forms[0].locale.value;
	var facility_id		= "<%=facilityID%>";

	if (call_function == 'AdmitPatient')
	{
		getPractitioner(obj, target, facility_id, "","","Q4");
		/*var sql = "SELECT a.Practitioner_id practitioner_id, am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE(d.PRACT_TYPE,'"+locale+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(e.SPECIALITY_CODE,'"+locale+"',2 ) primary_specialty, am_get_desc.AM_POSITION(f.position_code,'"+locale+"',1) job_title FROM am_pract_for_facility_vw a, am_practitioner b, am_pract_type d,  am_speciality e, am_position f WHERE a.operating_facility_id="+facility_id+" AND a.pract_type IN ('MD','SG','PS','DN') AND a.practitioner_id = b.practitioner_id AND  b.primary_speciality_code = e.speciality_code AND  b.pract_type = d.pract_type AND b.position_code=f.position_code(+) and b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR  UPPER(am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"',1)) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (f.position_code LIKE (?) OR f.position_code IS NULL)";

		var sql2 ="SELECT a.Practitioner_id practitioner_id, am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"',1) practitioner_name,am_get_desc.AM_PRACT_TYPE(d.PRACT_TYPE,'"+locale+"',2) practitioner_type,am_get_desc.AM_SPECIALITY(e.SPECIALITY_CODE,'"+locale+"',2 ) primary_specialty, am_get_desc.AM_POSITION(f.position_code,'"+locale+"',1) job_title FROM am_pract_for_facility_vw a, am_practitioner b, am_pract_type d,  am_speciality e, am_position f WHERE a.operating_facility_id="+facility_id+" AND a.pract_type IN ('MD','SG','PS','DN') AND a.practitioner_id = b.practitioner_id AND  b.primary_speciality_code = e.speciality_code AND  b.pract_type = d.pract_type and b.position_code=f.position_code(+) AND b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  AND  UPPER(am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"',1)) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (f.position_code LIKE (?) OR f.position_code IS NULL)";
		*/
	}
	else
	{

			getPractitioner(obj, target, facility_id, "","","Q2");
	
			/*var sql = "SELECT   a.practitioner_id practitioner_id, am_get_desc.am_practitioner(a.practitioner_id, '"+locale+"', 1) practitioner_name,  am_get_desc.am_pract_type(b.PRACT_TYPE,  '"+locale+"',  1) practitioner_type, am_get_desc.am_speciality(b.PRIMARY_SPECIALITY_CODE, '"+locale+"',  2) primary_specialty,  DECODE(b.gender,  'M',  'Male',  'F',  'Female',  'U',  'Unknown') gender,  b.position_code job_title FROM am_pract_for_facility a,am_practitioner b WHERE   a.practitioner_id = b.practitioner_id AND   b.pract_type LIKE (?) AND  b.primary_speciality_code LIKE UPPER(?) AND  (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR   UPPER(am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"',1)) LIKE UPPER(NVL(?,b.practitioner_name))) AND   b.gender LIKE (?) AND  (b.position_code LIKE (?) OR b.position_code IS NULL) AND  a.facility_id= '"+facility_id+"'" ;

			var sql2 = "SELECT   a.practitioner_id practitioner_id, am_get_desc.am_practitioner(a.practitioner_id, '"+locale+"', 1) practitioner_name,  am_get_desc.am_pract_type(b.PRACT_TYPE,  '"+locale+"',  1) practitioner_type, am_get_desc.am_speciality(b.PRIMARY_SPECIALITY_CODE, '"+locale+"',  2) primary_specialty,  DECODE(b.gender,  'M',  'Male',  'F',  'Female',  'U',  'Unknown') gender,  b.position_code job_title FROM am_pract_for_facility a,am_practitioner b WHERE   a.practitioner_id = b.practitioner_id AND   b.pract_type LIKE (?) AND  b.primary_speciality_code LIKE UPPER(?) AND  (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  and  UPPER(am_get_desc.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"',1)) LIKE UPPER(NVL(?,b.practitioner_name))) AND   b.gender LIKE (?) AND  (b.position_code LIKE (?) OR b.position_code IS NULL) AND  a.facility_id= '"+facility_id+"'" */


		
	}
	/*var xmlDoc	= new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp	= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
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
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
//	alert(responseText);
	eval(responseText);	*/

} // End of getPractitioner.

// To be called by the GeneralPractitionerSearch to set Practitioner.
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		document.forms[0].practid.value=arr[0];
		document.forms[0].practid_desc.value=arr[1];			
	}
	else
	{
		document.forms[0].practid.value="";
		document.forms[0].practid_desc.value="";			
	}

} // End of PractLookupRetVal().

</script>
	<input type='text' name='practid_desc' id='practid_desc' size="25" maxlength="30" onblur="BeforeGetPractitioner(document.forms[0].practid, practid_desc, '<%=called_function_id%>');" value="<%=practitioner_desc%>"><input type='hidden' name='practid' id='practid' value="" size="15" maxlength="15" ><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="getPractitionerLocal(document.forms[0].practid, practid_desc, '<%=called_function_id%>');">



