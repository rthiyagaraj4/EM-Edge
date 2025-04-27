<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>
<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eMR/js/MRPractitionerComponent.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<%	
	 request.setCharacterEncoding("UTF-8");
	//Connection con = null;
	//Statement stmt=null;
	//ResultSet rs =null;
	String facilityID=(String)session.getValue("facility_id");	
	String called_function_id	= request.getParameter("called_function_id");
	String practitioner_desc		= request.getParameter("practitioner_desc");
	called_function_id	= (called_function_id == null)?"":called_function_id;
	practitioner_desc		= (practitioner_desc == null)?"":practitioner_desc;
%>
<script>

// This Function will check for empty values before calling up the common lookup func..

function BeforeGetPractitioner(obj, target, getVal)
{
	if(document.forms[0].practid_desc.value !="")
		getPractitionerLocal(obj, target, getVal);
	else
		document.forms[0].practid.value =""
}

async function getPractitionerLocal(obj, target, getVal)
{
	var usertype=document.forms[0].user_type.value;
	var user=document.forms[0].user.value;
	if(usertype =='I' && user=='U')
	{
		 await getAuthoriser(obj,target);
	}
	else
	{
		var practName_FName="";
		var practName_FValue="";
		var practId_FName="";
		var call_function = getVal;	

		practName_FName=target.name;
		practName_FValue=target.value;
		practId_FName=document.forms[0].practid.name;

		var facility_id		= "'"+'<%=facilityID%>'+"'";
		if(usertype=='E')
		{
			
			getPractitioner(obj, target,facility_id,"Q3");
			/*
			var sql = "SELECT b.PRACTITIONER_ID, b.PRACTITIONER_NAME,PRACT_TYPE practitioner_type,PRIMARY_SPECIALITY_CODE primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_ext_practitioner b WHERE b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)";

			var sql2 = "SELECT b.PRACTITIONER_ID, b.PRACTITIONER_NAME,PRACT_TYPE practitioner_type,PRIMARY_SPECIALITY_CODE primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_ext_practitioner b WHERE b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)";
			*/
		}
		else
		{
			getPractitioner(obj, target,facility_id,"Q4");
			/*
			var sql = "SELECT b.PRACTITIONER_ID, b.PRACTITIONER_NAME,PRACT_TYPE practitioner_type,PRIMARY_SPECIALITY_CODE primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner b WHERE b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)";

			var sql2 = "SELECT b.PRACTITIONER_ID, b.PRACTITIONER_NAME,PRACT_TYPE practitioner_type,PRIMARY_SPECIALITY_CODE primary_specialty, DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_practitioner b WHERE b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)";
			*/
		}
		
		//	alert(sql);
		
		/*
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " practName_FName=\"" +practName_FName + "\"";
		xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
	//	xmlStr += " practId_FName=\"" + practId_FName + "\"";
		xmlStr += " sql=\"" +escape(sql)+ "\"";
		xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
		xmlStr += " practitioner_type=\"" + "" + "\"";
		xmlStr += " specialty_code=\"" + "" + "\"";
		xmlStr += " job_title=\"" + "" + "\"";
		xmlStr += " gender=\"" + "" + "\"";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//	document.forms[0].practid_desc.value=sql+"****"+sql2;
		xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);	
		*/

	}
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

}
async function getAuthoriser(target_id,target)
{
	var facility_id ="'"+'<%=facilityID%>'+"'";
	var title="";
	
	var argumentArray=new Array(8);
	
	title=getLabel("Common.user.label","Common");
 
	argumentArray[0]="select APPL_USER_ID code, APPL_USER_NAME description from SM_APPL_USER where EFF_STATUS like ? and APPL_USER_ID like upper(nvl(?,APPL_USER_ID)) and upper(APPL_USER_NAME) like upper(nvl(?,APPL_USER_NAME)) ";
	
	argumentArray[1]=new Array("EFF_STATUS");
	argumentArray[2]=new Array("E");
	argumentArray[3]=new Array(STRING,STRING);
	argumentArray[4]="2,3";
	argumentArray[5]=target.value;
	argumentArray[6]=CODE_DESC_LINK;
	argumentArray[7]=CODE_DESC;

			
	var retVal=await CommonLookup(title,argumentArray);
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].practid.value		=	arr[0];		
		document.forms[0].practid_desc.value	=	arr[1];
		//document.forms[0].practid_desc.focus();
		//document.forms[0].practid.value		= document.forms[0].practid_desc.value;
	}
	else
	{
		document.forms[0].practid.value		= "";		
		document.forms[0].practid_desc.value	= "";
	}
}

</script>
	<input type='text' name='practid_desc' id='practid_desc' size="25" maxlength="30" onblur="BeforeGetPractitioner(document.forms[0].practid, practid_desc, '<%=called_function_id%>');" value="<%=practitioner_desc%>"><input type='hidden' name='practid' id='practid' value="" size="15" maxlength="15" ><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="getPractitionerLocal(document.forms[0].practid, practid_desc, '<%=called_function_id%>');">

