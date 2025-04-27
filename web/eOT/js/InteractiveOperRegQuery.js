/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var prevObjID;
var prevImgObj;
var disappeardelay= 250;


async function searchTheatreTypeinOPreg(obj){
	var locale = document.forms[0].locale.value;
//alert("enter");
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
var flg="";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var frmObj=document.forms[0];
var sql="select SHORT_DESC DESCRIPTION,LOCN_TYPE CODE  from AM_CARE_LOCN_TYPE_LANG_VW where language_id='"+locale+"' and CARE_LOCN_TYPE_IND='O' AND upper(SHORT_DESC) like upper(?) AND upper(LOCN_TYPE) like upper(?) order by 2";
	//var obj1=document.forms[0];
	//sql="SELECT SHORT_DESC DESCRIPTION, OPER_CODE CODE FROM OT_OPER_MAST WHERE NVL(STATUS,'E') = 'E'AND upper(SHORT_DESC) like upper(?) AND upper(OPER_CODE) like upper(?)  order by 1" ;

	//var sql= "SELECT SHORT_NAME DESCRIPTION,PHYSICIAN_ID CODE FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+obj1.facility_id.value+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(STATUS,'X') <> 'S' AND upper(SHORT_NAME) like upper(?) AND upper(PHYSICIAN_ID) like upper(?) order by 2";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
//	argumentArray[4] = "1,2"; Modified By Rajesh for Lookup Issue
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	//alert("obj.value"+obj.value);
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	var theatreType_value=getLabel("eOT.TheatreType.Label","OT");
	returnedValues =await CommonLookup(theatreType_value, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
		document.forms[0].theatre_type_desc.value = arr[1];
	document.forms[0].theatre_type.value = arr[0];	
	}
else
	{
		nationality_code.value = arr[0]; 
			nationality_desc.value = arr[1]; 
			desc.value=arr[1];
			code.value=arr[0];
	document.forms[0].theatre_type_desc.value = '';
	document.forms[0].theatre_type.value = '';	
	}
		//obj.value = returnedValues[1];
	//} 
}

function callTheatreType()
{
	var locale = document.forms[0].locale.value;
	var column_sizes = escape("70%,30%");               

	//var column_descriptions = escape("Description,Code");
	
	var column_descriptions = getLabel('Common.description.label','common')+','+getLabel('Common.code.label','common');

	column_descriptions = encodeURIComponent(column_descriptions);

	var sql=escape("SELECT SHORT_DESC THEATRE_TYPE_DESC, LOCN_TYPE THEATRE_TYPE FROM AM_CARE_LOCN_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND CARE_LOCN_TYPE_IND = 'O' ");
	var title=	encodeURIComponent(getLabel("Common.Theatre.label","common"));
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!='')
		{
			arr=retVal.split("::");
			document.forms[0].theatre_type.value = arr[1];
			document.forms[0].theatre_type_desc.value = arr[0];	
		}
	else
		{
			document.forms[0].theatre_type.value = '';
			document.forms[0].theatre_type_desc.value = '';
		}
}

function callDialog(param)
{
	var dialogTop			= "40";
	var dialogHeight		= "10";
	var dialogWidth			= "40";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";


retVal=window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);

	return retVal;
}
function checkNull(retVal)
{
	if(retVal != null && retVal.length>0)		
		return retVal;
		else 
			return '';
}

function populateTheatres()
{
	var obj=document.forms[0].theatre;
	var facility_id=document.forms[0].facility_id.value;
	var theatre_type=document.forms[0].theatre_type.value;
	
	if(theatre_type!="" && theatre_type!='null')
	{
		clearTheatre(obj);
		parent.dummy_frame.location.href = "../../eCommon/html/blank.html";
		var htmlVal = "<html><head></head><body>";
		htmlVal += "<form name='frm_temp' id='frm_temp' method='post'; action='../../eOT/jsp/InteractiveTheatrePopulate.jsp' target='dummy_frame'>";
		htmlVal += "<input type='hidden' name='facility_id' id='facility_id' value='"+facility_id+"'>";
		htmlVal += "<input type='hidden' name='theatre_type' id='theatre_type' value='"+theatre_type+"'>";
		htmlVal += "</form></body></html>";
		parent.dummy_frame.document.body.insertAdjacentHTML("afterBegin",htmlVal);
		parent.dummy_frame.document.frm_temp.submit();
	}
}
function clearTheatre(obj)
{
	var len=obj.options.length;
	for(var i=len-1;i>=0;i--)
	{
		obj.remove(i);
	}
}
function callSpeciality()
{
	var column_sizes = escape("70%,30%");               
//	var column_descriptions = escape("Description,Code");

	var column_descriptions = getLabel('Common.description.label','common')+','+getLabel('Common.code.label','common');

	column_descriptions = encodeURIComponent(column_descriptions);

	var sql=escape("SELECT A.SHORT_DESC SPECIALITY_DESC, B.SPECIALITY_CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B WHERE A.LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'X') = 'E'AND A.SPECIALITY_CODE = B.SPECIALITY_CODE ");
	var title=getLabel("Common.speciality.label","common");
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!='')
		{
			arr=retVal.split("::");
			document.forms[0].speciality_code.value = arr[1];
			document.forms[0].speciality_desc.value = arr[0];	
		}
	else
		{
			document.forms[0].speciality_code.value = '';
			document.forms[0].speciality_desc.value = '';
		}

}

async function searchSpecialityinOPreg(obj)
{
	//alert("enter");
var locale=document.forms[0].locale.value;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	//SELECT  HOLDING_AREA_DESC description,HOLDING_AREA_CODE code FROM OT_HOLDING_AREAS WHERE OPERATING_FACILITY_ID='"+facility_id+ "' AND NVL(STATUS,'E') = 'E'  and upper(HOLDING_AREA_DESC) like upper(?) and upper(HOLDING_AREA_CODE) like upper(?) order by 2
	//var sql=escape("SELECT SHORT_DESC SHORT_DESC1,A.SPECIALITY_CODE SPECIALITY_CODE1 FROM AM_SPECIALITY A, OT_SPECIALITIES B  WHERE NVL(A.EFF_STATUS,'X') = 'E' AND A.SPECIALITY_CODE = B.SPECIALITY_CODE");

	var sql="SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE and upper(A.SHORT_DESC) like upper(?) and upper(A.SPECIALITY_CODE) like upper(?) order by 2";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
//  argumentArray[4] = "1,2"; Modified By Rajesh For Lookup Issues
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	//alert("obj.value"+obj.value);
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	var speciality_value=getLabel("Common.speciality.label","common");
	returnedValues = await CommonLookup(speciality_value, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
		document.forms[0].speciality_desc.value = arr[1];
	document.forms[0].speciality_code.value = arr[0];	
	}
else
	{
		nationality_code.value = arr[0]; 
			nationality_desc.value = arr[1]; 
			desc.value=arr[1];
			code.value=arr[0];
	document.forms[0].speciality_desc.value = '';
	document.forms[0].speciality_code.value ='';		
		//obj.value = returnedValues[1];
	} 
}

async function searchSurgeoninOPreg(obj)
{
	//alert("enter");
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	

	
	var facility_id=document.forms[0].facility_id.value;

	var locale = document.forms[0].locale.value;

	//var sql= "SELECT SHORT_NAME DESCRIPTION,PHYSICIAN_ID CODE FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(STATUS,'X') <> 'S' AND upper(SHORT_NAME) like upper(?) AND upper(PHYSICIAN_ID) like upper(?) order by 2";
	
//Code altered by rajesh for including roole_type on 09/07/08

var sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND   PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='OS') AND upper(PRACTITIONER_NAME) like upper(?) AND upper(PRACTITIONER_ID) like upper(?) ORDER BY 1";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
//	argumentArray[4] = "1,2"; Modified by Rajesh for Lookup Issues
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	//alert("obj.value"+obj.value);
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	var surgeon_value=getLabel("Common.Surgeon.label","Common");
	returnedValues = await CommonLookup(surgeon_value, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
		document.forms[0].surgeon_name.value = arr[1];
	document.forms[0].surgeon_code.value = arr[0];	

	}
else
	{
		nationality_code.value = arr[0]; 
			nationality_desc.value = arr[1]; 
			desc.value=arr[1];
			code.value=arr[0];
	document.forms[0].surgeon_name.value = '';
	document.forms[0].surgeon_code.value = '';
	
		//obj.value = returnedValues[1];
	} 
}

async function searchAnaesthetistinOPreg(obj){
	var locale=document.forms[0].locale.value;	
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var flg="";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var frmObj=document.forms[0];
	//query altered by rajesh for language id issue :732
//	var sql="SELECT SHORT_NAME DESCRIPTION,PRACTITIONER_ID CODE FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND  PRACT_TYPE IN ('AN') AND  NVL(EFF_STATUS,'X') <> 'S' AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 2";

	//qry altered by rajesh for including role_type on 09/07/08
	var sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND   PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='MA') AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1";

	//var sql="select short_name DESCRIPTION,PHYSICIAN_ID CODE from SY_PHYSICIAN_MAST where FACILITY_ID = '"+frmObj.facility_id.value+"' and  PRACT_TYPE IN ('AN') and  NVL(STATUS,'X') <> 'S' AND upper(short_name) like upper(?) AND upper(PHYSICIAN_ID) like upper(?) order by 2";
	//var sql="select SHORT_DESC DESCRIPTION,LOCN_TYPE CODE  from AM_CARE_LOCN_TYPE where CARE_LOCN_TYPE_IND='O' AND upper(SHORT_DESC) like upper(?) AND upper(LOCN_TYPE) like upper(?) order by 2";
	
	//var obj1=document.forms[0];
	//sql="SELECT SHORT_DESC DESCRIPTION, OPER_CODE CODE FROM OT_OPER_MAST WHERE NVL(STATUS,'E') = 'E'AND upper(SHORT_DESC) like upper(?) AND upper(OPER_CODE) like upper(?)  order by 1" ;

	//var sql= "SELECT SHORT_NAME DESCRIPTION,PHYSICIAN_ID CODE FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+obj1.facility_id.value+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(STATUS,'X') <> 'S' AND upper(SHORT_NAME) like upper(?) AND upper(PHYSICIAN_ID) like upper(?) order by 2";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
//	argumentArray[4] = "1,2"; Modified By Rajesh for Lookup Issue
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	//alert("obj.value"+obj.value);
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	var anaesthetist_value=getLabel("Common.Anaesthetist.label","Common");
	returnedValues =await CommonLookup(anaesthetist_value, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
	frmObj.anaesthetist_name.value=arr[1];
		frmObj.anaesthetist_code.value=arr[0];
	}
else
	{
		nationality_code.value = arr[0]; 
			nationality_desc.value = arr[1]; 
			desc.value=arr[1];
			code.value=arr[0];
frmObj.anaesthetist_code.value="";
frmObj.anaesthetist_name.value="";
	}
		//obj.value = returnedValues[1];
	//} 
}
async function searchNurseinOPreg(obj)
	{
	
	//alert("enter");
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
var flg="";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var frmObj=document.forms[0];
var locale = document.forms[0].locale.value;

//	var sql="select short_name DESCRIPTION,PHYSICIAN_ID CODE from SY_PHYSICIAN_MAST where FACILITY_ID = '"+frmObj.facility_id.value+"' and  PRACT_TYPE IN ('NS') and  NVL(STATUS,'X') <> 'S' AND upper(short_name) like upper(?) AND upper(PHYSICIAN_ID) like upper(?) order by 2";

//Qry altered by rajesh for including role_type on 09/07/08
var sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND   PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='NS') AND UPPER(PRACTITIONER_NAME ) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
//	argumentArray[4] = "1,2"; Modified By Rajesh for Lookup issue
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	//alert("obj.value"+obj.value);
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	var nurse_value=getLabel("Common.nurse.label","common");
	returnedValues = await CommonLookup(nurse_value, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
	frmObj.nurse_name.value=arr[1];
		frmObj.nurse_code.value=arr[0];
	}
else
	{
		nationality_code.value = arr[0]; 
			nationality_desc.value = arr[1]; 
			desc.value=arr[1];
			code.value=arr[0];
frmObj.nurse_name.value="";
frmObj.nurse_code.value="";
	}
		//obj.value = returnedValues[1];
	//} 
}

async function searchOperationinOPreg(obj)
{
	
	//alert("enter");
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
var flg="";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var frmObj=document.forms[0];
	var speciality_code=document.forms[0].speciality_code.value;
	/*if(speciality_code=='null' || speciality_code=="")
		var sql="SELECT SHORT_DESC DESCRIPTION, OPER_CODE CODE FROM OT_OPER_MAST WHERE NVL(STATUS,'E') = 'E' AND upper(SHORT_DESC) like upper(?) AND upper(OPER_CODE) like upper(?) order by 2";
	else
		var sql="SELECT SHORT_DESC DESCRIPTION, OPER_CODE CODE FROM OT_OPER_MAST WHERE SPECIALITY_CODE ='"+speciality_code+"' AND NVL(STATUS,'E') = 'E' AND upper(SHORT_DESC) like upper(?) AND upper(OPER_CODE) like upper(?) order by 2";*///MMS-QH-CRF-0199

	if(speciality_code=='null' || speciality_code=="")
		var sql="SELECT LONG_DESC DESCRIPTION, OPER_CODE CODE FROM OT_OPER_MAST WHERE NVL(STATUS,'E') = 'E' AND upper(LONG_DESC) like upper(?) AND upper(OPER_CODE) like upper(?) order by 2";//MMS-QH-CRF-0199
	else
		var sql="SELECT LONG_DESC DESCRIPTION, OPER_CODE CODE FROM OT_OPER_MAST WHERE SPECIALITY_CODE ='"+speciality_code+"' AND NVL(STATUS,'E') = 'E' AND upper(LONG_DESC) like upper(?) AND upper(OPER_CODE) like upper(?) order by 2";//MMS-QH-CRF-0199
	
	
	
	//var sql="select short_name DESCRIPTION,PHYSICIAN_ID CODE from SY_PHYSICIAN_MAST where FACILITY_ID = '"+frmObj.facility_id.value+"' and  PRACT_TYPE IN ('NS') and  NVL(STATUS,'X') <> 'S' AND upper(short_name) like upper(?) AND upper(PHYSICIAN_ID) like upper(?) order by 2";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
//	argumentArray[4] = "1,2"; Modified by Rajesh for Lookup Issues
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	//alert("obj.value"+obj.value);
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	var operation_value=getLabel("Common.operation.label","common");
	returnedValues = await CommonLookup(operation_value, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
	frmObj.oper_desc.value=arr[1];
		frmObj.oper_code.value=arr[0];
	}
else
	{
		nationality_code.value = arr[0]; 
			nationality_desc.value = arr[1]; 
			desc.value=arr[1];
			code.value=arr[0];
frmObj.oper_desc.value="";
frmObj.oper_code.value="";
	}
		//obj.value = returnedValues[1];
	//} 
}

async function searchAnaesTypeinOPreg(obj){
		//alert("enter");
		var locale = document.forms[0].locale.value;
		var result		=	false ;
		var message		=	"" ;
		var flag		=	"" ;
		var function_id = "";
		var flg="";
			var argumentArray  = new Array();
			var dataNameArray  = new Array();
			var dataValueArray = new Array();
			var dataTypeArray  = new Array();
			var frmObj=document.forms[0];
			var sql="SELECT SHORT_DESC DESCRIPTION, ANAESTHESIA_CODE CODE FROM AM_ANAESTHESIA_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'E') = 'E' AND upper(SHORT_DESC) like upper(?) AND upper(ANAESTHESIA_CODE) like upper(?) order by 2";
		//	var sql="select short_name DESCRIPTION,PHYSICIAN_ID CODE from SY_PHYSICIAN_MAST where FACILITY_ID = '"+frmObj.facility_id.value+"' and  PRACT_TYPE IN ('NS') and  NVL(STATUS,'X') <> 'S' AND upper(short_name) like upper(?) AND upper(PHYSICIAN_ID) like upper(?) order by 2";

	
			argumentArray[0] = sql;
			argumentArray[1] = dataNameArray;
			argumentArray[2] = dataValueArray;
			argumentArray[3] = dataTypeArray;
//			argumentArray[4] = "1,2"; Modified by Rajesh For Lookup Issues
			argumentArray[4] = "2,1";
			argumentArray[5] = obj.value;
			//alert("obj.value"+obj.value);
			argumentArray[6] = CODE_LINK;
			argumentArray[7] = CODE_DESC;
			var anaesthesiaType_value=getLabel("eOT.AnaesthesiaType.Label","OT");
			returnedValues = await CommonLookup(anaesthesiaType_value, argumentArray );
			if((returnedValues != null) && (returnedValues != "") )  {
				var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
			frmObj.anaesthesia_desc.value=arr[1];
				frmObj.anaesthesia_code.value=arr[0];
			}
		else
			{
				nationality_code.value = arr[0]; 
			nationality_desc.value = arr[1]; 
			desc.value=arr[1];
			code.value=arr[0];
		frmObj.anaesthesia_desc.value="";
		frmObj.anaesthesia_code.value="";
			}
				//obj.value = returnedValues[1];
	//} 
}	

async function callImplantUsed(obj){
		//alert("enter");
		var locale = document.forms[0].locale.value;
		var result		=	false ;
		var message		=	"" ;
		var flag		=	"" ;
		var function_id = "";
		var flg="";
			var argumentArray  = new Array();
			var dataNameArray  = new Array();
			var dataValueArray = new Array();
			var dataTypeArray  = new Array();
			var frmObj=document.forms[0];
			var sql="SELECT SHORT_DESC DESCRIPTION, PROSTHESIS_CODE CODE FROM OT_PROSTHESIS_LANG_VW WHERE NVL(STATUS,'E') = 'E' AND LANGUAGE_ID='"+locale+"' AND upper(SHORT_DESC) like upper(?) AND upper(PROSTHESIS_CODE) like upper(?) order by 1";
		//	var sql="select short_name DESCRIPTION,PHYSICIAN_ID CODE from SY_PHYSICIAN_MAST where FACILITY_ID = '"+frmObj.facility_id.value+"' and  PRACT_TYPE IN ('NS') and  NVL(STATUS,'X') <> 'S' AND upper(short_name) like upper(?) AND upper(PHYSICIAN_ID) like upper(?) order by 2";

	
			argumentArray[0] = sql;
			argumentArray[1] = dataNameArray;
			argumentArray[2] = dataValueArray;
			argumentArray[3] = dataTypeArray;
			argumentArray[4] = "2,1";
			argumentArray[5] = obj.value;
			//alert("obj.value"+obj.value);
			argumentArray[6] = DESC_LINK;
			argumentArray[7] = DESC_CODE;
			var implantused_value=getLabel("eOT.ImplantUsed.Label","OT");
			returnedValues =await CommonLookup(implantused_value, argumentArray );
			if((returnedValues != null) && (returnedValues != "") )  {
				var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
			frmObj.implant_desc.value=arr[1];
				frmObj.implant_code.value=arr[0];
			}
		else
			{
				nationality_code.value = arr[0]; 
			nationality_desc.value = arr[1]; 
			desc.value=arr[1];
			code.value=arr[0];
		frmObj.implant_desc.value="";
		frmObj.implant_code.value="";
			}
				//obj.value = returnedValues[1];
	//} 
}	

function callSurgeon()
{
	var facility_id=document.forms[0].facility_id.value;
	var column_sizes = escape("60%,40%");               
	// var column_descriptions = escape("Name,Code");

	var column_descriptions = getLabel('Common.name.label','common')+','+getLabel('Common.code.label','common');

	column_descriptions = encodeURIComponent(column_descriptions);

	var sql=escape("SELECT SHORT_NAME SURGEON_NAME, PHYSICIAN_ID SURGEON_CODE FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"' AND PRACT_TYPE IN ('MD','SG')AND NVL(STATUS,'X') <> 'S' ");
//	var title='Surgeon Search';
	var title= getLabel("Common.Surgeon.label","Common");
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!='')
		{
			arr=retVal.split("::");
			document.forms[0].surgeon_code.value = arr[1];
			document.forms[0].surgeon_name.value = arr[0];	
		}
	else
		{
			document.forms[0].surgeon_code.value = '';
			document.forms[0].surgeon_name.value = '';
		}

}

function callAnaesthetist()
{
	var facility_id=document.forms[0].facility_id.value;
	var column_sizes = escape("60%,40%");               
//	var column_descriptions = escape("Name,Code");
    var column_descriptions = getLabel('Common.name.label','common')+','+getLabel('Common.code.label','common');

	column_descriptions = encodeURIComponent(column_descriptions);


	var sql=escape("SELECT SHORT_NAME ANAESTHETIST_NAME, PHYSICIAN_ID ANAESTHETIST_CODE FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"' AND PRACT_TYPE IN ('AN') AND NVL(STATUS,'X') <> 'S'");
//	var title='Anaesthetist Search';
	var title=getLabel("Common.Anaesthetist.label","common");
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!='')
		{
			arr=retVal.split("::");
			document.forms[0].anaesthetist_code.value = arr[1];
			document.forms[0].anaesthetist_name.value = arr[0];	
		}
	else
		{
			document.forms[0].anaesthetist_code.value = '';
			document.forms[0].anaesthetist_name.value = '';
		}

}

function callNurse()
{
	var facility_id=document.forms[0].facility_id.value;
	var column_sizes = escape("60%,40%");               
	//var column_descriptions = escape("Name,Code");
	var column_descriptions = getLabel('Common.name.label','Common')+','+getLabel('Common.code.label','Common');
	column_descriptions = encodeURIComponent(column_descriptions); 

	var sql=escape("SELECT SHORT_NAME NURSE_NAME, PHYSICIAN_ID NURSE_CODE FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"' AND PRACT_TYPE IN ('NS') AND NVL(STATUS,'X') <> 'S' ");
//	var title='Nurse Search';
	var title=getLabel("Common.nurse.label","common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!='')
		{
			arr=retVal.split("::");
			document.forms[0].nurse_code.value = arr[1];
			document.forms[0].nurse_name.value = arr[0];	
		}
	else
		{
			document.forms[0].nurse_code.value = '';
			document.forms[0].nurse_name.value = '';
		}

}

function callOperation()
{
	var speciality_code=document.forms[0].speciality_code.value;
	if(speciality_code=='null' || speciality_code=="")
		var sql=escape("SELECT SHORT_DESC OPER_DESC, OPER_CODE OPER_CODE1 FROM OT_OPER_MAST WHERE NVL(STATUS,'E') = 'E'");
	else
		var sql=escape("SELECT SHORT_DESC OPER_DESC, OPER_CODE FROM OT_OPER_MAST WHERE SPECIALITY_CODE ='"+speciality_code+"' AND NVL(STATUS,'E') = 'E'");
	
	var column_sizes = escape("70%,30%");               
	//var column_descriptions = escape("Description,Code");
    var column_descriptions = getLabel('Common.description.label','common')+','+getLabel('Common.code.label','common');

	column_descriptions = encodeURIComponent(column_descriptions);

//	var title='Operation Search';
	var title=getLabel("Common.operation.label","common");
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!='')
		{
			arr=retVal.split("::");
			document.forms[0].oper_code.value = arr[1];
			document.forms[0].oper_desc.value = arr[0];	
		}
	else
		{
			document.forms[0].oper_code.value = '';
			document.forms[0].oper_desc.value = '';
		}

}


function callAnaesthesiaType()
{
	var column_sizes = escape("70%,30%");               
//	var column_descriptions = escape("Description,Code");
	var column_descriptions = getLabel('Common.description.label','common')+','+getLabel('Common.code.label','common');
	column_descriptions = encodeURIComponent(column_descriptions);
	var locale=document.forms[0].locale.value;
	var sql=escape("SELECT SHORT_DESC ANAESTHESIA_DESC, ANAESTHESIA_CODE FROM AM_ANAESTHESIA_LANG_VW WHERE AND LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'E') = 'E' ");
	var title=getLabel("eOT.AnaesthesiaType.Label","OT");
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!='')
		{
			arr=retVal.split("::");
			document.forms[0].anaesthesia_code.value = arr[1];
			document.forms[0].anaesthesia_desc.value = arr[0];	
		}
	else
		{
			document.forms[0].anaesthesia_code.value = '';
			document.forms[0].anaesthesia_desc.value = '';
		}

}
/*
function callImplantUsed_Old()
{
	var column_sizes = escape("70%,30%");               
//	var column_descriptions = escape("Description,Code");
	
	var column_descriptions = getLabel('Common.description.label','common')+','+getLabel('Common.code.label','common');

	column_descriptions = encodeURIComponent(column_descriptions);

	var locale = document.forms[0].locale.value;
	//var sql=escape("SELECT SHORT_DESC IMPLANT_DESC, PROSTHESIS_CODE IMPLANT_CODE FROM OT_PROSTHESIS WHERE NVL(STATUS,'E') = 'E'");
	var sql=escape("SELECT SHORT_DESC IMPLANT_DESC, PROSTHESIS_CODE IMPLANT_CODE FROM OT_PROSTHESIS_LANG_VW WHERE NVL(STATUS,'E') = 'E' AND LANGUAGE_ID='"+locale+"' ");

	var title=encodeURIComponent(getLabel("eOT.ImplantUsed.Label","OT"));
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!='')
		{
			arr=retVal.split("::");
			document.forms[0].implant_code.value = arr[1];
			document.forms[0].implant_desc.value = arr[0];	
		}
	else
		{
			document.forms[0].implant_code.value = '';
			document.forms[0].implant_desc.value = '';
		}

}
*/
function IntraOperRegDetails()
{
	var frmObj=document.forms[0];
	var locale=frmObj.locale.value;
	var facility_id=frmObj.facility_id.value;
	var theatre_type=frmObj.theatre_type.value;
	var theatre=frmObj.theatre.value;
	var speciality_code=frmObj.speciality_code.value;
	var surgeon_code=frmObj.surgeon_code.value;
	var anaesthetist_code=frmObj.anaesthetist_code.value;
	var nurse_code=frmObj.nurse_code.value;
	var oper_code=frmObj.oper_code.value;
	var anaesthesia_code=frmObj.anaesthesia_code.value;
	var implant_code=frmObj.implant_code.value;
	//var from_date=frmObj.from_date.value;
	//var to_date=frmObj.to_date.value;
//			alert(" from_date "+frmObj.from_date.value+" to_date "+frmObj.to_date.value)
	var from_date = dateUtils(frmObj.from_date.value,locale); 
	var to_date = dateUtils(frmObj.to_date.value,locale); 
	var status=frmObj.status.value;
	var orderby=frmObj.orderby.value;
	var patient_id=frmObj.patientid.value;
	var source_code=frmObj.source_code.value;
	var flag=0;
	if(from_date=="" || from_date=='null')
	{
		//alert("From Date can not be blank....");
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		 var msgArray = msg.split("&");
		 var fromDate_value=getLabel("Common.fromdate.label","common");
		 alert(msgArray[0]+fromDate_value+msgArray[1]);
		flag=1;
	}
	if(to_date!="" && to_date!='null')
	{
		if(compareDates1(trimString(from_date),trimString(to_date)))
		{
			//alert("To Date should be greater than or equal to From Date ....");
			var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
			var msgArr = msg_1.split("#");
			var to_date = getLabel("Common.todate.label","Common");
			var from_date =getLabel("Common.fromdate.label","Common");
			var message=msgArr[0]+ to_date  +msgArr[1]+ from_date +msgArr[2];
			alert(message);
			flag=1;
		}
	}
	if(flag==0)
	{
		//alert("flag "+flag+" from_date "+from_date+" to_date "+to_date)
		var param ="facility_id="+facility_id+"&theatre_type="+theatre_type+"&theatre="+theatre+"&speciality_code="+speciality_code+"&surgeon_code="+surgeon_code+"&anaesthetist_code="+anaesthetist_code+"&nurse_code="+nurse_code+"&oper_code="+oper_code+"&anaesthesia_code="+anaesthesia_code+"&implant_code="+implant_code+"&from_date="+from_date+"&to_date="+to_date+"&status="+status+"&orderby="+orderby+"&patient_id="+patient_id+"&source_code="+source_code;
		parent.interacive_query_dtl.location.href = "../../eOT/jsp/InteractiveOperRegQueryDtl.jsp?"+param;
	}
	
}

function DisplayTooltipForOperRegQry(arrObj,arrObj1,param,orderctlHDR,imgObj)
{
var menu_id_list		= new Array();
var	menu_name_list	= new Array();
menu_id_list=arrObj.split(",");
menu_name_list=arrObj1.split(",");
callMouseOverOnTD(orderctlHDR,imgObj);
	var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center' style=' z-index: 1000;background-color: #d9d9d9;border: 1px solid #ccc;box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2);position: absolute;' >";
	for( var i=0; i<menu_name_list.length; i++ )
		{
		var id_colval		= menu_id_list[i];
		var id_name_colval  = menu_name_list[i];
		
		if(id_colval!=""){
			tab_dat     += "<tr>"
			tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class='contextMenuLink' href = \"javascript:callItemSelect1('"+id_colval+"','"+param+"');\">"+id_name_colval + "</a> </td>"
			tab_dat     += "</tr> ";
		}
	}
	tab_dat     += "</table> ";	
	document.getElementById("tooltiplayer").innerHTML = tab_dat;
	
resizeWindow(orderctlHDR);
//	resizeWindow();
}

function checkEncIdPatClass(oper_num){
	var formObj=document.forms[0];
	var facility_id=formObj.facility_id.value;
	var sql="select encounter_id,patient_class from OT_POST_OPER_HDR where operating_facility_id='"+facility_id+"' and oper_num='"+oper_num+"' ";
	var facility_id=formObj.facility_id.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=getEncIdPatClass&oper_num="+oper_num+"&facility_id="+facility_id+"&sql="+sql;
	xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);	
	return retVal;
}
function  callItemSelect1(obj,param)
{
	var par=new Array();
	par=param.split("::");	
	var encId_patClass=checkEncIdPatClass(par[0]);
	var split_str=encId_patClass.split("&&");
	if(obj=='PDD')
	{
		var dialogHeight 		= "95vh";
		var dialogWidth  		= "80vw";
		var dialogTop   		= "0vh";
		var dialogLeft   		= "50vh";
		var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		var param="facility_id="+par[1]+"&Patient_ID="+par[2];	
		retVal=""+window.showModalDialog("../../eMP/jsp/ViewPatDetailsMain.jsp?"+param,arguments,features);
	}


	if(obj=="PH")
	{
		var HTML = "<html>"
		HTML += "<form name='historyForm' id='historyForm' action='../../eCA/jsp/OpenChartWrapper.jsp'>"
		HTML += "<input type='text' name='from_service_yn' id='from_service_yn' value= 'Y'>";
		HTML += "<input type='text' name='insert_op' id='insert_op' value= 'N'>";
		HTML += "<input type='text' name='patient_id' id='patient_id' value= '" +par[2]+ "'>"; 
		HTML += "<input type='text' name='encounter_id' id='encounter_id' value= '" + split_str[0]+ "'>";
		HTML += "<input type='text' name='patient_class' id='patient_class' value= '" + split_str[1]+ "'>";
		HTML += "</form>"
		HTML += "</html>"
		parent.messageFrame.document.body.insertAdjacentHTML("BeforeEnd", HTML);
		parent.messageFrame.document.historyForm.submit();

	}
	if(obj=="SH")
	{

		
		//"dialogHeight: 700px; dialogWidth:800px;
		//var dialogHeight 		= "700px";
		//var dialogWidth  		= "800px";
		//var dialogTop   		= "20";
		//var dialogLeft   		= "50";
		//var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	//	var arguments			= "";
		var surgeryhistory_legend = encodeURIComponent(getLabel("eOT.SurgeryHistory.Label","OT"));	

		var param="oper_no="+par[0]+"&facility_id="+par[1]+"&patient_id="+par[2]+"&patient_name="+par[3]+"&sex="+par[4]+"&dob="+par[5]+"&called_from="+par[6]+"&function_name="+surgeryhistory_legend;
//		alert(param);
		//retVal=""+window.showModalDialog("../../eOT/jsp/SurgeryHistory.jsp?"+param,arguments,features);
		var retVal=window.showModalDialog('../../eOT/jsp/SurgeryHistory.jsp?'+param,window,"dialogHeight: 700px; dialogWidth:800px; center: yes; help: no; resizable: yes; status: no;");

	}
	hideToolTip();	  
}
function hideToolTip(){
 document.getElementById("tooltiplayer").style.visibility = 'hidden';
}

function reset()
{
	interacive_query_hdr.location.reload();
	interacive_query_dtl.location="../../eCommon/html/blank.html";
	messageFrame.location='../../eCommon/jsp/error.jsp';
}


function compareDates1(fromdate,todate) {
    var fromarray; var toarray;
    if(fromdate.length > 0 && todate.length > 0 ) {
			var from_date_array = fromdate.split(" ");
			var from_date = from_date_array[0];
			var from_time = from_date_array[1];
			var to_date_array = todate.split(" ");
			var to_date = to_date_array[0];
			var to_time = to_date_array[1];
            var fromdatearray = from_date.split("/");
            var todatearray = to_date.split("/");
			var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0]);
            var todt = new Date(todatearray[2],todatearray[1],todatearray[0]);
			//alert(new Date(2004,11,24,23,11)); is the format used above yyyy,mm,dd,hh24,mi
            if(Date.parse(todt) >= Date.parse(fromdt)) {
                return false;
            }
    }
	return true;
}

function  reasonToolTip(stvar,indx)
{
	var arr=new Array();
	var frmObj=document.forms[0];
	var arrMsg=eval("frmObj."+stvar+""+indx+".value");
	arr=arrMsg.split(",");
	var cou=0;
	var tab_dat  = "<table id ='tooltiptable' cellpadding=0 cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
		var id_name_colval  = arr[0];	
			tab_dat     += "<tr>"
			tab_dat     += "<th   nowrap > <B>"+id_name_colval + " </B> </a> </th>"
			tab_dat     += "</tr> ";
	for( cou=1;cou<arr.length;cou++)
	{
			msg=arr[cou];
			tab_dat     += "<tr>"
			tab_dat     += "<td class='label' > <B>"+msg+ " </B> </a> </td>"		
			tab_dat     += "</tr> ";	
		}
			tab_dat     += "</table> ";	
//Commented against MMS-QH-CRF-0199
	/*document.getElementById("tooltiplayer").innerHTML = tab_dat;
	resizeWindow1();*/
	//Added against MMS-QH-CRF-0199
	return tab_dat;
}

function callNoRecord()
{
	//alert("No Record Found");
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
}

function checkDateFormat(obj)
{
	if(obj.value!=null && obj.value!="")
	{
	var retVal= checkDt(obj.value)
		if(retVal== false)
		{
			//alert("Invalid Date Format");
			alert(getMessage("INVALID_DATE_FMT","SM"));
			obj.value = '';
			obj.select();
		}
	}
}

/*function funResetAll(){
//	interacive_query_hdr.location.reload();
	document.forms[0].reset();
	var elSel = document.getElementById('theatre');
	var elOptNew = document.createElement('option');
	elOptNew.text = '*All Theatres';
	elOptNew.value = '*ALL';
	for(i=0;i<elSel.length;i++){
		elSel.remove(i+1);
	}
	try {
			elSel.add(elOptNew, null); // standards compliant; doesn't work in IE
		}catch(ex) {
			elSel.add(elOptNew); // IE only
		}//ca
	
}*/

function funResetAll(){
//	interacive_query_hdr.location.reload();
	document.forms[0].reset();
	var elSel = document.getElementById('theatre');
	var elOptNew = document.createElement('option');
	elOptNew.text = '*All Theatres';
	elOptNew.value = '*ALL';

	if (elSel.length ==1)
	  {
		elSel.remove(elSel.length-1);
	  }
	  else if(elSel.length >1){
		  var len=0;
			len=elSel.length;
			for( var co=len;co>=1;co--)
			elSel.remove(co-1); 


	  }
	try {
			elSel.add(elOptNew, null); // standards compliant; doesn't work in IE
		}catch(ex) {
			elSel.add(elOptNew); // IE only
		}//ca
	
}

function checkDateFormat(obj)
{
	if(obj.value!=null && obj.value!="")
	{
	var retVal= checkDt(obj.value)
		if(retVal== false)
		{
			//alert("Invalid Date Format");
			alert(getMessage("INVALID_DATE_FMT","SM"));
			obj.value = '';
			obj.select();
		}
	}
}

/*function callPatientSearch(){
	var patient_id	=	document.forms[0].patientid.value;
	var return_value =	"";
	return_value	=	PatientSearch();	
	var obj=document.forms[0];
	if(return_value!=null){
		obj.patientid.value	=	return_value;
	}else{
		obj.patientid.value	="";
	}
	document.forms[0].patientname.value=getPatientName(return_value);
}
*/
function getPatientName(patient_id){
	var formobj=document.forms[0];
	var locale=formobj.locale.value;
	var sql="SELECT decode ('"+locale+"','en',PATIENT_NAME, NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) SHORT_NAME1 FROM MP_PATIENT WHERE PATIENT_ID ='"+patient_id+"' ";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="flag=MED_SER&sql="+sql;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	return retVal;
}


async function callPatSearch(){
	//alert("entered callPatSearch()");
	var formObj = document.forms[0];
	var patient_id=formObj.patientid;
	var patient_name = formObj.patientname;
	//alert("patient_id : "+patient_id+"\n patient_name"+patient_name);
	var return_value =	"";
	return_value	=	(patient_id.value.length>0)?patient_id.value:await PatientSearch();
	//alert("return_value : "+return_value);
	if(return_value==null)  return;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=patient_search&patient_id="+return_value,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText); 
	//alert("retval : "+retVal);
	if(retVal=="INVALID_PATIENT"){
		//alert("entered invalid patient");
			alert(getMessage("INVALID_PATIENT","MP")); 
			patient_id.value="";
			patient_name.value="";
			patient_id.focus();
			return
	}
	
	if(retVal!="" ){
			var retVal_arr = retVal.split("##");
			patient_id.value		=return_value
			patient_name.value		= retVal_arr[0];
			//patient name is coming with "<!DOCTYPE html><!DOCTYPE html><!DOCTYPE html>  at the beginning.
			const toRemove = "<!DOCTYPE html><!DOCTYPE html><!DOCTYPE html>  ";
			const regex = new RegExp("^" + toRemove);
		  patient_name.value = patient_name.value.replace(regex, "");
//alert("if : patient name :"+patient_name.value+"\n patient id : "+return_value);
	}
}


function clearDesc(){
	var formObj = document.forms[0];
	var pat_id=formObj.patientid.value;
	if(pat_id=="" || pat_id==null || pat_id=="null" || pat_id=="undefined")
	formObj.patientname.value="";
	
}

function localTrimString(sInString) {
   return sInString.replace(/^\s+|\s+$/g,"");
}

function CodeArrest() 
{
    if((window.event.button == 2) || (window.event.button == 3) || (window.event.button == 4)) 
	{
        alert("Welcome to eHIS");
    }
}

function lockKey()
{
    if(event.keyCode == 93)
		alert(getMessage("WELCOME",'Common'));
	
}

//Newly added for Amazon Changes......

function callMouseOver(obj)	{
	currClass = obj.className ;
	obj.className = 'selectedcontextMenuItem';

}

function callOnMouseOut(obj){
	obj.className = 'contextMenuItem';
}

function resizeWindow(orderctlHDR)
{
	var orderctlHDR1 = orderctlHDR.id;
  //var wdth = eval("document.all."+orderctlHDR1).offsetWidth;
	//var hght1 = eval("document.all."+orderctlHDR1).offsetHeight;
	var wdth = eval(document.getElementById(orderctlHDR1)).offsetWidth;
	var hght1 = eval(document.getElementById(orderctlHDR1)).offsetHeight;
 
	var wdth1 = getPos(orderctlHDR).x +wdth;
	var hght = getPos(orderctlHDR).y ;
 
	bodwidth  = document.body.offsetWidth
	bodheight = document.body.offsetHeight
 
	var z = bodwidth- (event.x + wdth);
 
	var x 	  = event.x;
	var y 	  = event.y;
 
	x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
	y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);
 
	if(x<bodwidth){
		x= wdth1;
	}else{
		x = getPos(orderctlHDR).x;
	}
	if(y<bodheight){
		y = hght;
 
	}else
	{
		y = y - (document.getElementById("tooltiplayer").offsetHeight*2) + hght1 ;
	}
	document.getElementById("tooltiplayer").style.left= x+"px";
	document.getElementById("tooltiplayer").style.top = y+"px";
	document.getElementById("tooltiplayer").style.visibility='visible'
}
/*function resizeWindow(orderctlHDR)
{
	var orderctlHDR1 = orderctlHDR.id;
	var wdth = eval("document.all."+orderctlHDR1).offsetWidth;
	var hght1 = eval("document.all."+orderctlHDR1).offsetHeight;		
	
	var wdth1 = getPos(orderctlHDR).x +wdth;
	var hght = getPos(orderctlHDR).y ;	

	bodwidth  = document.body.offsetWidth
	bodheight = document.body.offsetHeight

	var z = bodwidth- (event.x + wdth);	
	
	var x 	  = event.x;
	var y 	  = event.y;	

	x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
	y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);	

	if(x<bodwidth){
		x= wdth1;			
	}else{			
		x = getPos(orderctlHDR).x;
	}
	if(y<bodheight){			
		y = hght;
		
	}else
	{
		y = y - (document.getElementById("tooltiplayer").offsetHeight*2) + hght1 ;	
	}

	document.getElementById("tooltiplayer").style.posLeft= x;
	document.getElementById("tooltiplayer").style.posTop = y;
	document.getElementById("tooltiplayer").style.visibility='visible'
}*/

function callMouseOverOnTD(obj,imgObj){
		 if (prevObjID != null && prevObjID != obj.id)
		 {			 
			 /*eval("document.all."+prevObjID).className = 'gridDataBlue';
			 eval("document.all."+prevImgObj).src = "../../eCommon/images/inactiveArrow.gif";	*/
			document.getElementById(prevObjID).className = 'gridDataBlue';
			document.getElementById(prevImgObj).src = "../../eCommon/images/inactiveArrow.gif";			 
		 }		 
		obj.className = 'selectedTDData';
		//eval("document.all."+imgObj).src = "../../eCommon/images/activeArrow.gif";
		document.getElementById(imgObj).src = "../../eCommon/images/activeArrow.gif";
		prevObjID = obj.id;
		prevImgObj = imgObj;		
	}

function getPos(inputElement) {
    var coords =  new Object();
    coords.x = 0;
    coords.y = 0;
    try {
        targetElement = inputElement;
        if(targetElement.x && targetElement.y) {
            coords.x = targetElement.x;
            coords.y = targetElement.y;
        } else {
            if(targetElement.offsetParent) {
                coords.x += targetElement.offsetLeft;
                coords.y += targetElement.offsetTop;
                while(targetElement = targetElement.offsetParent) {
                    coords.x += targetElement.offsetLeft;
                    coords.y += targetElement.offsetTop;
                }
            } else {
                //alert("Could not find any reference for coordinate positioning.");
            }
        }
        return coords;
    } catch(error) {
        //alert(error.msg);
        return coords;
    }
}

/*function hideToolTip(obj,imgObj,row)	
	{
		dynamichide(obj, window.event,row);
	}
function dynamichide(m, e,row)
{
		if (!this.isContained(m, e))
		{
			this.delayhidemenu(row)
		}
}

function isContained(m, e)
{
		alert(m,e)
		var e=window.event || e
		var c=e.relatedTarget || ((e.type=="mouseover")? e.fromElement : e.toElement)
		while (c && c!=m)try {c=c.parentNode} catch(e){c=m}
		if (c==m)
			return true
		else
			return false
}

function delayhidemenu(row)
{
		this.delayhide=setTimeout("hidemenu()", this.disappeardelay) //hide menu
		if(eval("document.getElementById("orderctl")"+row))
			eval("document.getElementById("orderctl")"+row).className='gridDataBlue';
		if(eval("document.getElementById("imgArrow")"+row))
			eval("document.getElementById("imgArrow")"+row).src = "../../eCommon/images/inactiveArrow.gif";
}*/

function hidemenu()
{
	document.getElementById("tooltiplayer").style.visibility = 'hidden';
}
//Amazon Changes Ends Here....

function getLongNameRefSrc(){
	var formObj=document.forms[0];
	var ref_src_id=formObj.HLongRefSrcId.value;
	var locale=formObj.locale.value;
	var param="func_mode=ref_long_name&locale="+locale+"&ref_src_id="+ref_src_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	if(ref_src_id!="" || retVal!=""){
		return retVal;
	}else{
		return "";
	}
}

function enableMoreIcon(){
	var formObj=document.forms[0];
	var source_type=formObj.source_type.value;
	if(source_type=="E"){
		document.getElementById("more_img").style.visibility='visible';	
	}else if(source_type=="W"){
		document.getElementById("more_img").style.visibility='hidden';	
	}else if(source_type=="C") {
		document.getElementById("more_img").style.visibility='hidden';	
	}else if(source_type=="") {
		document.getElementById("more_img").style.visibility='hidden';	
	}
}


function clearSource(){
	var formObj=document.forms[0];
	formObj.source_code.value="";
    formObj.source_desc.value="";
	var Source_code=formObj.source_desc.value;
	if(Source_code==""){
		document.getElementById("more_img").style.visibility = 'hidden';
	}
}

async function searchsourcetype(source_type){
	var formObj=document.forms[0];
	var locale=formObj.locale.value;
	var title="";
	if(formObj.source_type.value=='W'){
		title=getLabel("Common.nursingUnit.label","common");
		//Code altered by Selvam for PHASE 3 Delivery
		//sql="SELECT SHORT_DESC DESCRIPTION, NURSING_UNIT_CODE CODE FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+formObj.facility_id.value+"' AND NVL(EFF_STATUS,'D') = 'E' AND upper(SHORT_DESC) like upper(?) AND upper(NURSING_UNIT_CODE) like upper(?)  order by 1" ;
		sql="SELECT LONG_DESC DESCRIPTION, NURSING_UNIT_CODE CODE FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+formObj.facility_id.value+"' AND NVL(EFF_STATUS,'D') = 'E' AND upper(LONG_DESC) like upper(?) AND upper(NURSING_UNIT_CODE) like upper(?)  order by 1" ;
	}else if(formObj.source_type.value=='C'){
		title = getLabel("Common.clinic.label","common");
		//sql="SELECT SHORT_DESC DESCRIPTION, CLINIC_CODE CODE FROM   OP_CLINIC WHERE FACILITY_ID = '"+formObj.facility_id.value+"' AND NVL(EFF_STATUS,'D') = 'E' AND upper(SHORT_DESC) like upper(?) AND upper(CLINIC_CODE) like upper(?)  order by 1" ;
		//Code altered by Selvam for PHASE 3 Delivery
		//sql="SELECT SHORT_DESC DESCRIPTION, CLINIC_CODE CODE FROM  OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+formObj.facility_id.value+"' AND NVL(EFF_STATUS,'D') = 'E' AND upper(SHORT_DESC) like upper(?) AND upper(CLINIC_CODE) like upper(?)  order by 1" ;
		sql="SELECT LONG_DESC DESCRIPTION, CLINIC_CODE CODE FROM  OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+formObj.facility_id.value+"' AND NVL(EFF_STATUS,'D') = 'E' AND upper(LONG_DESC) like upper(?) AND upper(CLINIC_CODE) like upper(?)  order by 1" ;
	}else if(formObj.source_type.value=='E'){
		title= getLabel("Common.referral.label","common");
		sql="SELECT LONG_DESC  DESCRIPTION, REFERRAL_CODE  CODE FROM AM_REFERRAL_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'D') = 'E' AND upper(LONG_DESC) like upper(?) AND upper(REFERRAL_CODE) like upper(?)  order by 1" ;
	}else{
		 var msg = getMessage("CANNOT_BE_BLANK","OT");
		 var msgArray = msg.split("&");
		 alert(msgArray[0]+" "+getLabel("Common.SourceType.label","Common")+" "+msgArray[1]);
		 return false;
	}
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = formObj.source_desc.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	returnedValues = await CommonLookup(title, argumentArray );
	if( (returnedValues != null) && (returnedValues != "") )  {
		//obj.value = returnedValues[1];
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
		formObj.HLongRefSrcId.value=arr[0];
		formObj.source_code.value=arr[0];
		formObj.source_desc.value=arr[1];
	}else{
		nationality_code.value = arr[0]; 
			nationality_desc.value = arr[1]; 
			desc.value=arr[1];
			code.value=arr[0];
		formObj.HLongRefSrcId.value="";
		formObj.source_desc.value="";
		formObj.source_code.value="";
	}
}

function searchSourceTypeSelect(obj){
	var formObj=document.forms[0];
	var patient_class=formObj.source_type.value;
	if(patient_class=="E"){
		searchsourcetypeReferal(obj);
	}else{
		searchsourcetype(obj);	
	}
}

function callchangeMoreIcon(){
	var formObj=document.forms[0];
	var Source_code=formObj.source_desc.value;
	formObj.source_code.value='';
	formObj.HLongRefSrcId.value='';
	if(Source_code==""){
		document.getElementById("more_img").style.visibility = 'hidden';
	} 
}

function searchsourcetypeReferal(obj){
	var formObj=document.forms[0];
	var column_sizes = escape("60%,20%,10%");        
	var locale = formObj.locale.value;
	var surg_type_desc=obj.value
	var tit = getLabel('Common.code.label','Common')+','+getLabel('Common.description.label','Common')+','+getLabel('Common.longname.label','Common'); 
	var column_descriptions = encodeURIComponent(tit); 
	var sql=escape("SELECT REFERRAL_CODE CODE, LONG_DESC DESCRIPTION, LONG_NAME LONG_NAMES FROM AM_REFERRAL_LANG_VW  WHERE LANGUAGE_ID ='"+locale+"' AND NVL(EFF_STATUS,'D') = 'E'");
	var title=getLabel("Common.referral.label","Common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+surg_type_desc;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");	
		formObj.HLongRefSrcId.value=arr[0];
		formObj.source_code.value=arr[0];
		formObj.source_desc.value=arr[1];
		if(arr[2]==""){
			document.getElementById("more_img").style.visibility = 'hidden';
		}else{
			document.getElementById("more_img").style.visibility = 'visible';
		}
	}else{
		formObj.HLongRefSrcId.value="";
		formObj.source_code.value="";
		formObj.source_desc.value="";
	}
}

