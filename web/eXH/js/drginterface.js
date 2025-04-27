function showResults()
{
//	parent.drg_results_frame.location.href="../jsp/DRGQueryResults.jsp";
	this.document.forms[0].target="drg_results_frame";
	this.document.forms[0].action="../../servlet/eXB.DRGCalculationServlet";
	this.document.forms[0].submit();
}

// Function to do the initial things on load of the page
function initParams()
{						   	
//	document.getElementById("appName").focus();
}

// Called on load of drg query results page. Checks if any exceptions occured whie processing the drg request.
function chkExceptions()
{
	parent.window.messageFrame.location.href="../eCommon/jsp/MstCodeError.jsp";

	var status = document.getElementById("drgstatus").value;
	var exception = document.getElementById("drgexception").value;

	if(status != null && status != "S")
	{		
		document.getElementById("drgResultsDiv").style.display="none";
		parent.window.messageFrame.location.href="../eCommon/jsp/error.jsp?err_num="+exception;		
	}
}
function reset()
{
	window.drg_query_frame.document.forms[0].reset();
	parent.window.messageFrame.location.href="../../eCommon/html/blank.html";
	initParams();
}

function refFrames()
{
	// if req_mode value is not changed, servlet will execute get message data function instead of new DRG Calculation request.
	this.document.getElementById("req_mode").value=""; 
	
	parent.window.drg_results_frame.document.open();
	parent.window.drg_results_frame.document.write('<body color="white">');
	parent.window.drg_results_frame.document.close();

	fields = new Array (parent.window.drg_query_frame.document.forms[0].appName, 
							parent.window.drg_query_frame.document.forms[0].facilityName,
							parent.window.drg_query_frame.document.forms[0].eventName,
							parent.window.drg_query_frame.document.forms[0].patientName,
							parent.window.drg_query_frame.document.forms[0].encounterID,
							parent.window.drg_query_frame.document.forms[0].profileID) ;
	names = new Array ( getLabel("Common.Application.label","common"),
						getLabel("Common.facility.label","common"),
						getLabel("Common.EventType.label","common"),
						getLabel("Common.patient.label","common"),
						getLabel("Common.encounter.label","common"),
						getLabel("Common.Profile.label","common"));	
	
	if(!parent.window.drg_query_frame.checkFields( fields, names, parent.window.messageFrame))
	{
	}
	else
	{
	 	parent.window.messageFrame.location.href="../../eCommon/html/process.html";
		this.document.forms[0].submit();
	}
}
function getMsgData()
{
	parent.window.drg_results_frame.location.href="../../eCommon/html/blank.html";
	msgID=document.getElementById("msg_id").value;
	if(msgID == "")
	{
		msg=getMessage('CAN_NOT_BE_BLANK','Common');
		msg=msg.replace('$','Message ID');
		alert(msg);
	}
	else
	{	
		parent.window.messageFrame.location.href="../../eCommon/html/process.html";
		this.document.getElementById("req_mode").value="refresh";
	//	this.document.forms[0].target="drg_results_frame";
	//	this.document.forms[0].action="../../servlet/eXH.DRGCalculationServlet";
		this.document.forms[0].submit();
	}
}

function getFacility()
{
	var argumentArray		= new Array() ;
	var dataNameArray		= new Array() ;
	var dataValueArray		= new Array() ;
	var dataTypeArray		= new Array() ;
	var strQry				= "SELECT FACILITY_ID code,FACILITY_NAME description FROM SM_FACILITY_PARAM "+
								"   WHERE UPPER(FACILITY_NAME) LIKE UPPER(?) AND "+ 								
								"	UPPER(FACILITY_ID) LIKE UPPER(?)  "+
								"	ORDER BY 1 ";
	argumentArray[0]		= strQry;
	argumentArray[1]		= dataNameArray ;
	argumentArray[2]		= dataValueArray ;
	argumentArray[3]		= dataTypeArray ;
	argumentArray[4]	    = "2,1";
	argumentArray[5]		= document.getElementById("facilityName").value;
	argumentArray[6]		= DESC_LINK ;
	argumentArray[7]		= DESC_CODE ; 
	retVal = await CommonLookup( getLabel("Common.facility.label","common"), argumentArray );

	if(retVal != null && retVal != "" )  {
		document.getElementById("facilityName").value	= retVal[1] ;
		document.getElementById("facilityID").value = retVal[0];
		enableEncounter();
	}
	else
	{
		document.getElementById("facilityName").value	= "";
		document.getElementById("facilityID").value = "";

		document.getElementById("encounterID").value = "";
		document.getElementById("encounterID").disabled=true;
		document.getElementById("encounterLU").disabled=true;		
	}
}

function getPatient()
{
	var argumentArray		= new Array() ;
	var dataNameArray		= new Array() ;
	var dataValueArray		= new Array() ;
	var dataTypeArray		= new Array() ;
	var strQry				= "SELECT PATIENT_ID code,PATIENT_NAME description FROM MP_PATIENT "+
								"   WHERE PATIENT_ID LIKE UPPER(?) AND "+ 								
								"	UPPER(PATIENT_NAME) LIKE UPPER(?)  "+
								"	ORDER BY 1 ";
	argumentArray[0]		= strQry;
	argumentArray[1]		= dataNameArray ;
	argumentArray[2]		= dataValueArray ;
	argumentArray[3]		= dataTypeArray ;
	argumentArray[4]	    = "1,2";
	argumentArray[5]		= document.getElementById("patientName").value;
	argumentArray[6]		= DESC_LINK ;
	argumentArray[7]		= DESC_CODE ; 
	retVal = await CommonLookup( getLabel("Common.patient.label","common"), argumentArray );

	if(retVal != null && retVal != "" )  {
		document.getElementById("patientName").value	= retVal[1] ;
		document.getElementById("patientID").value = retVal[0];
		enableEncounter();
	}
	else
	{
		document.getElementById("patientName").value = "";
		document.getElementById("patientID").value = "";

		document.getElementById("encounterID").value = "";
		document.getElementById("encounterID").disabled=true;
		document.getElementById("encounterLU").disabled=true;
	}
}

function searchPatientId() 
{
	var arguments  =new Array();
	arguments[0]='L';	

	var dialogHeight = "200";
	var dialogWidth  = "250";
	var dialogTop    = "100";
	var dialogLeft   = "230";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no;help:no;" ;

//	window.showModalDialog("../../eMP/jsp/ModelPatientSearch.jsp",arguments,features);
	var returnval = PatientSearch();
	if(returnval != null && returnval != "")
	{
		document.getElementById("patientName").value = returnval;
		document.getElementById("patientID").value = returnval;
		enableEncounter();
	}
}

function getEncounter()
{
	facilityID				= document.getElementById("facilityID").value;
	patID					= document.getElementById("patientID").value;
	var argumentArray		= new Array() ;
	var dataNameArray		= new Array() ;
	var dataValueArray		= new Array() ;
	var dataTypeArray		= new Array() ;
	var escaped = escape('%');
	var strQry				= "SELECT PATIENT_ID code,ENCOUNTER_ID description FROM PR_ENCOUNTER "+
								"   WHERE ENCOUNTER_ID LIKE ? AND "+ 								
								"	'"+escaped+"' LIKE UPPER(?) AND FACILITY_ID ='"+facilityID+"'"+
								"	AND PATIENT_ID ='"+patID+"' "+
								"	ORDER BY 1 ";
	argumentArray[0]		= strQry;
	argumentArray[1]		= dataNameArray ;
	argumentArray[2]		= dataValueArray ;
	argumentArray[3]		= dataTypeArray ;
	argumentArray[4]	    = "2,1";
	argumentArray[5]		= document.getElementById("encounterID").value;
	argumentArray[6]		= DESC_LINK ;
	argumentArray[7]		= DESC_CODE ; 
	retVal = await CommonLookup( getLabel("Common.encounter.label","common"), argumentArray );

	if(retVal != null && retVal != "" )  {		
		document.getElementById("encounterID").value = retVal[1];
	}
	else
	{
		document.getElementById("encounterID").value = "";
	}
}

function getApplicationInfo()
{
	locale					= document.getElementById("locale").value;
	var argumentArray		= new Array() ;
	var dataNameArray		= new Array() ;
	var dataValueArray		= new Array() ;
	var dataTypeArray		= new Array() ;
	var strQry				= "SELECT APPLICATION_ID code,APPLICATION_NAME description FROM XH_APPLICATION_LANG_VW "+
								"   WHERE UPPER(APPLICATION_NAME) LIKE UPPER(?) AND "+ 								
								"	UPPER(APPLICATION_ID) LIKE UPPER(?)  "+
								"	AND LANGUAGE_ID='"+locale+"'"+
								"	ORDER BY 1 ";
	argumentArray[0]		= strQry;
	argumentArray[1]		= dataNameArray ;
	argumentArray[2]		= dataValueArray ;
	argumentArray[3]		= dataTypeArray ;
	argumentArray[4]	    = "2,1";
	argumentArray[5]		= document.getElementById("appName").value;
	argumentArray[6]		= DESC_LINK ;
	argumentArray[7]		= DESC_CODE ; 

	retVal = await CommonLookup( getLabel("Common.Application.label","common"), argumentArray );
	
	if(retVal != null && retVal != "" )  {
		document.getElementById("appName").value	= retVal[1] ;
		document.getElementById("applicationID").value = retVal[0];
		document.getElementById("eventName").disabled=false;
		document.getElementById("eventLU").disabled=false;
	}
	else
	{
		document.getElementById("appName").value	= "" ;
		document.getElementById("applicationID").value = "";

		document.getElementById("eventName").value	= "";
		document.getElementById("eventType").value = "";
		document.getElementById("eventName").disabled=true;
		document.getElementById("eventLU").disabled=true;
	}
}

function getEventTypeInfo()
{	
	appID					= document.getElementById("applicationID").value;
	var argumentArray		= new Array() ;
	var dataNameArray		= new Array() ;
	var dataValueArray		= new Array() ;
	var dataTypeArray		= new Array() ;
	var strQry				= "SELECT EVENT_TYPE code,EVENT_NAME description FROM XH_APPLICATION_EVENT_TYPE_VW "+
								"   WHERE UPPER(EVENT_NAME) LIKE UPPER(?) AND "+ 								
								"	UPPER(EVENT_TYPE) LIKE UPPER(?) AND APPLICATION_ID='"+appID+"'"+
								" ORDER BY 1";

	argumentArray[0]		= strQry;
	argumentArray[1]		= dataNameArray ;
	argumentArray[2]		= dataValueArray ;
	argumentArray[3]		= dataTypeArray ;
	argumentArray[4]	    = "2,1";
	argumentArray[5]		= document.getElementById("eventName").value;
	argumentArray[6]		= DESC_LINK ;
	argumentArray[7]		= DESC_CODE ; 

	retVal = await CommonLookup( getLabel("Common.EventType.label","common"), argumentArray );

	if(retVal != null && retVal != "" )  {
		document.getElementById("eventName").value	= retVal[1];
		document.getElementById("eventType").value = retVal[0];
	}
	else
	{
		document.getElementById("eventName").value	= "";
		document.getElementById("eventType").value = "";
	}
}
function enableEncounter()
{
	if(document.getElementById("patientID").value != "" && document.getElementById("patientName").value != "" &&
		document.getElementById("facilityID").value != "" && document.getElementById("facilityName").value != "")
	{
		document.getElementById("encounterID").value = "";
		document.getElementById("encounterID").disabled=false;
		document.getElementById("encounterLU").disabled=false;
	}
}
