

function apply()
{
	var fields = new Array(frames[1].document.getElementById("sectionCode"), 
							frames[1].document.getElementById("studyLocation"), 
							frames[1].document.getElementById("facilityID"),
							frames[1].document.forms[0].serviceNo,
							frames[1].document.forms[0].counterName);
	var names = new Array("Section", "Study Location", "Facility", "Service ID", "Counter Name");

	if(!transactionFrame.checkFields(fields, names, messageFrame))	
	{
		if(!trimCheck(frames[1].document.getElementById("sectionCode").value)) 
		{
			frames[1].document.getElementById("sectionDesc").focus();
		}
		else 
		{
 			frames[1].document.getElementById("serviceNo").focus();
		}
	}
	else
	{
		window.transactionFrame.document.forms[0].submit();
	}
	window.commontoolbarFrame.document.location.reload();
}

function init()
{
	if($("#mode").val() == "U")
	{
		$("#serviceNo").focus();
	}
	else
	{
		$("#sectionDesc").focus();
	}
}

function create()
{
	window.transactionFrame.location.href = "../../eXH/jsp/QMSRDCounterSetup.jsp?mode=I";
	window.messageFrame.location.href = "../../eCommon/html/blank.html";
}

function query()
{
	window.transactionFrame.location.href = "../../eXH/jsp/QMSRDCounterSetupQueryCriteria.jsp";
	window.messageFrame.location.href = "../../eCommon/html/blank.html";
}

function viewScan(obj)
{
	var docID = obj.documentID;
	if(docID == 'null') docID = '';
	var dataElements = 'P_Ext_Application_ID=DMS_VW&P_PATIENT_ID=' + obj.patientID 
							+ "&P_EPISODE_ID=" + obj.encounterID
							+ "&P_DOC_TYPE=" + obj.documentType
							+ "&P_DOC_ID=" + docID
							+ "&dc_Sub Document Type=&dc_Encounter Date=&dc_Encounter Locn Type=&dc_Encounter Locn Code=&dc_Encounter Locn Desc=&dc_Encounter Status=&dt_Order Id=&dt_Specimen No=";
	
	dispExtAppSim(dataElements);
}

async function dispExtAppSim(dataElements)
{
	dataElements = dataElements + "&callType=INTERFACE_CALL";
	var retData = "";
	var url = "";

	var dialogHeight = "65vh";			    
	var dialogWidth  = "65vw";
	var dialogTop    = "200";
	var dialogLeft   = "450";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

	var arguments = new Array();
	var url = "../servlet/eXH.InvokeExternalApplication?" + dataElements;
 
	var retVal =await window.showModalDialog(url,arguments,features);
}

function deleterecord()
{
	window.transactionFrame.document.forms[0].action = "../servlet/eXH.QMSRDCounterSetupServlet?requestType=DELETE";	
	window.transactionFrame.document.forms[0].submit();
	window.commontoolbarFrame.document.location.reload();
}

function funAction(actionType)
{
	$("#action_type").val(actionType);
	$("#requestType").val("QUERY");
	$("#transactionFrame").prop("target", "counterList");
	$("#counterList").submit();
}

function reset()
{
	window.transactionFrame.document.forms[0].reset();
}

function searchFacility()
{
	var tdesc = "";
	var tcode = "";

	var retVal = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit = getLabel("Common.facility.label","common");

	var target = this.document.forms[0].facilityName;
	var facilityID = this.document.forms[0].facilityID;
	
	sql = "SELECT X.FACILITY_ID code,X.FACILITY_NAME description FROM SM_FACILITY_PARAM_LANG_VW X,XH_PARAM_FOR_FACILITY Y,SM_MODULES_FACILITY Z WHERE  X.LANGUAGE_ID='"+localeName+"' AND Z.MODULE_ID='XH' AND Z.OPERATIONAL_YN='Y' AND X.FACILITY_ID=Y.FACILITY_ID AND X.FACILITY_ID=Z.FACILITY_ID and UPPER(X.FACILITY_ID) LIKE UPPER(?) AND    UPPER(X.FACILITY_NAME) LIKE UPPER(?)   ORDER BY 1";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = CommonLookup(tit,argumentArray);

	if(retVal != null && retVal != "")
	{
		var ret1 = unescape(retVal);
		arr = ret1.split(",");
		target.value = arr[1];
		facilityID.value = arr[0];
	}
	else
	{
		target.value = tdesc;
		facilityID.value = tcode;
	}

	enableStudyLocation();
}

function searchSection()
{
	var tdesc = "";
	var tcode = "";

	var retVal = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
//	var tit = getLabel("Common.facility.label","common");
	var tit = "Section";

	var target = this.document.forms[0].sectionDesc;
	var sectionCode = this.document.forms[0].sectionCode; 

	sql = "SELECT X.SECTION_CODE code,X.SHORT_DESC description FROM RD_SECTION_LANG_VW X WHERE X.LANGUAGE_ID='" + localeName + "' AND UPPER(X.SECTION_CODE) LIKE UPPER(?) AND UPPER(X.SHORT_DESC) LIKE UPPER(?) ORDER BY 1";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = CommonLookup(tit,argumentArray);

	if(retVal != null && retVal != "")
	{
		var ret1 = unescape(retVal);
		arr = ret1.split(",");
		target.value = arr[1];
		sectionCode.value = arr[0];
	}
	else
	{
		target.value = tdesc;
		sectionCode.value = tcode;
	}

	enableStudyLocation();
}

function searchStudyLocation()
{
	var tdesc = "";
	var tcode = "";

	var retVal = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
//	var tit = getLabel("Common.facility.label","common");
	var tit = "Study Location";

	var target = this.document.forms[0].studyLocationDesc;
	var studyLocation = this.document.forms[0].studyLocation;
	var sectionCode = this.document.forms[0].sectionCode.value;
	var facilityID = document.forms[0].facilityID.value;

	sql = "SELECT X.CLINIC_CODE code,X.SHORT_DESC description FROM RD_CLINIC_LANG_VW X WHERE X.LANGUAGE_ID='" + localeName + "' AND UPPER(X.CLINIC_CODE) LIKE UPPER(?) AND UPPER(X.SHORT_DESC) LIKE UPPER(?) AND OPERATING_FACILITY_ID = '" + facilityID + "' AND section_code = '" + sectionCode +"' ORDER BY 1";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = CommonLookup(tit,argumentArray);

	if(retVal != null && retVal != "")
	{
		var ret1 = unescape(retVal);
		arr = ret1.split(",");
		target.value = arr[1];
		studyLocation.value = arr[0];
	}
	else
	{
		target.value = tdesc;
		studyLocation.value = tcode;
	}
}

function callLookup(obj, funcName)
{
	if($.trim(obj.value) != "")
	{
		eval(funcName)
	}
}

function enableStudyLocation()
{
	var facilityID = $("#facilityID").val();
	var sectionCode = $("#sectionCode").val();

	if(facilityID != "" && sectionCode != "")
	{
		$("#studyLocationDesc").removeAttr("disabled");
		$("#studyLocationLookupButton").removeAttr("disabled");
	}
	else
	{
		$("#studyLocationDesc").attr("disabled", "disabled");
		$("#studyLocationLookupButton").attr("disabled", "disabled");
	}
}
