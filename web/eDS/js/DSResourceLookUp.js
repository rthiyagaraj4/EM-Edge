/**
File Name			: DSResourceLookUp.js
File Description	: This is to look up the Resource [Practitioner, Room, Equipment, Others] and Location.
CRF#				: Bru-HIMS-CRF-230
Author				: Abirami
Date				: Aug-2013
**/

var flag_EM=false;
function callPractSearch1(obj,target,locale, facilityid){ 
	var spl_code=document.forms[0].speciality.value;
	var resource_type = document.forms[0].resourceType_1.value;
	var pract_type="";
	var practitioner_id1="";
	var clinic_code = "";
	if(resource_type=="" && document.forms[0].resourceType_EM) {flag_EM=true;resource_type = document.forms[0].resourceType_EM.value;}
	if(resource_type=='P')
	{
		getPractitioner(obj,target,facilityid,spl_code,pract_type,clinic_code,practitioner_id1,"Q2");
	}
	else
	{
		if(resource_type=='E' || resource_type=='O')
		{ 
			sql="Select resource_id code,SHORT_DESC description  from am_resource_lang_vw where facility_id = '"+facilityid+"' and Resource_Class ='"+resource_type+"' and language_id='"+locale+"'  and upper(resource_id) like upper(?) and upper(SHORT_DESC)  like upper(?) order by description";					
		}

		else if(resource_type=='R')
		{ 
			sql="select room_num code ,short_desc description from am_facility_room_lang_vw where operating_facility_id = '"+facilityid+"'  and language_id='"+locale+"' and upper(room_num) like upper(?) and upper(short_desc)  like upper(?) order by short_desc";
		}
		//if(flag_EM==false) {
			call_common(sql,obj);
		/*}
		else showPract_EM(sql,obj);*/
	}
}

async function call_common(sql,obj){   
	var tit				=  getLabel("Common.resource.label","Common");
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";	
	{
		argumentArray[5] = document.forms[0].practitioner_name.value;
	}
	
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );
		if(retVal != null && retVal != "" ){
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			document.forms[0].practitioner_name.value=arr[1]; //Desc
			document.forms[0].practitioner.value=arr[0]; //Code
		}else{
			document.forms[0].practitioner_name.value="";
			document.forms[0].practitioner.value="";
		}
}

async function showPract_EM(sql,obj){
	var tit				=  getLabel("Common.resource.label","Common");
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";	
	{
		argumentArray[5] = document.forms[0].practitioner_name_EM.value;
	}
	
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );
		if(retVal != null && retVal != "" ){
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			document.forms[0].practitioner_name_EM.value=arr[1]; //Desc
			document.forms[0].practitioner_EM.value=arr[0]; //Code
		}else{
			if(document.forms[0].practitioner_name_EM) {document.forms[0].practitioner_name_EM.value="";}
			if(document.forms[0].practitioner_EM) {document.forms[0].practitioner_EM.value="";}
		}
}

function getPractitioner(obj,target,facility_id,splty,pract_type,clinic_code,practitioner_id,executeQuery){
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	practName_FName=target.name;
	practName_FValue=target.value;
	var sql="";
	var sql2="";
	var facilityId = facility_id;	
	if (executeQuery == "Q2"){
		
		sql="SELECT DISTINCT a.practitioner_id, a.practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.POSITION_CODE  job_title, a.gender, am_get_desc.am_speciality(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  FROM AM_PRACTITIONER_LANG_VW a, AM_PRACT_ALL_SPLTY_VW b WHERE A.PRACTITIONER_ID = b.PRACTITIONER_ID AND b.facility_id=NVL('"+facility_id+"',b.facility_id) AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND ";
		
		if(pract_type!="")
		{
			sql=sql+"	a.pract_type='"+pract_type+"' AND ";
		}

		sql = sql+" UPPER(B.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND a.LANGUAGE_ID = '"+localeName+"' ORDER BY 2 ";


		sql2= "SELECT DISTINCT a.practitioner_id, a.practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.POSITION_CODE  job_title, a.gender, am_get_desc.am_speciality(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  FROM AM_PRACTITIONER_LANG_VW a, AM_PRACT_ALL_SPLTY_VW b WHERE A.PRACTITIONER_ID = b.PRACTITIONER_ID AND b.facility_id=NVL('"+facility_id+"',b.facility_id) AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND ";
		
		if(pract_type!="")
		{
			sql2=sql2+"	a.pract_type='"+pract_type+"' AND ";
		}

		sql2 = sql2+" UPPER(B.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) and UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND a.LANGUAGE_ID = '"+localeName+"' ORDER BY 2 ";
	}
	/*var xmlDoc= new ActiveXObject( "Microsoft.XMLDom" ) ;
	var xmlHttp= new ActiveXObject( "Microsoft.XMLHTTP" ) ;*/
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +encodeURIComponent(practName_FName) + "\"";
	xmlStr += " practName_FValue=\"" +encodeURIComponent(practName_FValue)+ "\"";
	xmlStr += " practId_FName=\"" + practId_FName + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" +splty+ "\""; // Thursday, February 18, 2010 19335 Venkat S.
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";

	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);

	responseText=xmlHttp.responseText;
    responseText = trimString(responseText); 
    eval(practSearch(practName_FName,encodeURIComponent(practName_FValue),splty,responseText));	  
}

async function practSearch(practName_FName,practName_FValue,splty,responseText) {
	var retVal = 	new String();
	var dialogTop = "10px" ;
	var dialogHeight= "500px" ;
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
	
	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practName_FValue+"&practitioner_type="+"\""+"&primary_specialty="+splty+"&job_title="+"\""+"&gender="+"\"",arguments,features);
	PractLookupRetVal(retVal,objName);
}

function trimString(inString) {
    var outString;
    var startPos;
    var endPos;
    var ch;

    // where do we start?
    startPos = 0;
    ch = inString.charAt(startPos);
    while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
        startPos++;
        ch = inString.charAt(startPos);
    }

    // where do we end?
    endPos = inString.length - 1;
    ch = inString.charAt(endPos);
    while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
        endPos--;
        ch = inString.charAt(endPos);
    }
    // get the string
    outString = inString.substring(startPos, endPos + 1);
	if (startPos>endPos)
	{
		return '';
	}
	else
	    return outString;
}


//////////////

function PractLookupRetVal(retVal,objName)
{ 
	var arr;
	if (retVal != null)
	{
		arr=unescape(retVal).split("~");
		
		if(flag_EM==true) {
			document.forms[0].practitioner_name_EM.value=arr[1];
			document.forms[0].practitioner_EM.value=arr[0];
		}
		else {
			document.forms[0].practitioner_name.value=arr[1];
			document.forms[0].practitioner.value=arr[0];
		}
	}else
	{
		document.forms[0].practitioner_name.value= "";
		document.forms[0].practitioner.value="";

		if(document.forms[0].practitioner_name_EM) {document.forms[0].practitioner_name_EM.value="";}
		if(document.forms[0].practitioner_EM) {document.forms[0].practitioner.value_EM="";}
		
	}
}

//Lookup of Location::
async function getLocn(loginuser,oper_id,fac_id,objval,target)
{
   var retVal =    new String();
   var argumentArray  = new Array() ;
   var dataNameArray  = new Array() ;
   var dataValueArray = new Array() ;
   var dataTypeArray  = new Array() ;
   var tit="";				
   locale=document.forms[0].locale.value; 
   spec_code=document.forms[0].speciality.value;
   tit=getLabel("Common.Location.label",'Common')
   //sql ="SELECT a.clinic_code code, a.long_desc description FROM op_clinic_lang_vw a, am_os_user_locn_access_vw b WHERE a.facility_id = '"+fac_id+"' AND a.language_id='"+locale+"' AND a.level_of_care_ind = 'A' AND a.eff_status='E' AND a.clinic_type = '"+objval+"' and a.facility_id = b.facility_id  AND a.clinic_code = b.locn_code and b.appl_user_id = '"+loginuser+"' and b.oper_stn_id = '"+oper_id+"' and b.manage_queue_yn = 'Y' and  upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) and a.CLINIC_TYPE=b.LOCN_TYPE and a.rd_appl_yn = 'N' ";
   sql ="SELECT a.clinic_code code, a.long_desc description FROM op_clinic_lang_vw a, am_os_user_locn_access_vw b WHERE a.facility_id = '"+fac_id+"' AND a.language_id='"+locale+"' AND a.level_of_care_ind = 'A' AND a.eff_status='E' AND a.clinic_type = '"+objval+"' and a.facility_id = b.facility_id  AND a.clinic_code = b.locn_code and b.appl_user_id = '"+loginuser+"' and ";
   sql = sql+"b.oper_stn_id = (SELECT OPER_STN_ID  FROM AM_USER_FOR_OPER_STN A  WHERE FACILITY_ID = b.facility_id AND APPL_USER_ID = b.appl_user_id AND TRUNC (SYSDATE) BETWEEN EFF_DATE_FROM AND NVL (EFF_DATE_TO, TRUNC (SYSDATE))) and b.manage_queue_yn = 'Y' and  upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) and a.CLINIC_TYPE=b.LOCN_TYPE and a.rd_appl_yn = 'N' ";
		if(!spec_code=="")
		{
		sql=sql+" and a.speciality_code='"+spec_code+"' ORDER BY  2";
		}else
		{
		sql=sql+"  ORDER BY  2";
		}
   
				argumentArray[0] =sql;
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
					
					
				document.forms[0].hdnlocation.value=arr[0]; //Code
				target.value=arr[1]; //Desc
				getTreatmentArea(arr[0]);
          }
}

async function getLocn_EM(loginuser,oper_id,fac_id,objval,target)
{
   var retVal =    new String();
   var argumentArray  = new Array() ;
   var dataNameArray  = new Array() ;
   var dataValueArray = new Array() ;
   var dataTypeArray  = new Array() ;
   var tit="";				
   locale=document.forms[0].locale.value; 
   spec_code=document.forms[0].speciality.value;
   tit=getLabel("Common.Location.label",'Common');
   
   sql ="SELECT a.clinic_code code, a.long_desc description FROM op_clinic_lang_vw a, am_os_user_locn_access_vw b WHERE a.facility_id = '"+fac_id+"' AND a.language_id='"+locale+"' AND a.level_of_care_ind = 'E' AND a.eff_status='E' AND a.clinic_type = '"+objval+"' and a.facility_id = b.facility_id  AND a.clinic_code = b.locn_code and b.appl_user_id = '"+loginuser+"' and ";
   sql = sql+"b.oper_stn_id = (SELECT OPER_STN_ID  FROM AM_USER_FOR_OPER_STN A  WHERE FACILITY_ID = b.facility_id AND APPL_USER_ID = b.appl_user_id AND TRUNC (SYSDATE) BETWEEN EFF_DATE_FROM AND NVL (EFF_DATE_TO, TRUNC (SYSDATE))) and b.manage_queue_yn = 'Y' and  upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) and a.CLINIC_TYPE=b.LOCN_TYPE and a.rd_appl_yn = 'N' ";
	
   if(!spec_code=="")
		{
		sql=sql+" and a.speciality_code='"+spec_code+"' ORDER BY  2";
		}else
		{
		sql=sql+"  ORDER BY  2";
		}
   
				argumentArray[0] =sql;
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
					
					
				document.forms[0].hdnlocation_EM.value=arr[0]; //Code
				target.value=arr[1]; //Desc
				getTreatmentArea(arr[0]);
          }
}
