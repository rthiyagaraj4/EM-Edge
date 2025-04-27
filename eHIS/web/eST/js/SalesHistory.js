var headTop = -1;
var FloatHead;
var FloatHead1;
function reset() {
	f_query_add_mod.location.reload();
}
async function searchCodeStore(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	
	var parNameArray  = new Array() ;   //MOHE-SCF-0156
	var parValueArray  = new Array() ;	//MOHE-SCF-0156
	parNameArray[0] ="~LOCALE_ID`";		//MOHE-SCF-0156
	parValueArray[0]=localeName;		//MOHE-SCF-0156
	
	
	//var sql = document.forms[0].SQL_ST_STORE_LOOKUP.value + "'" + localeName + "'" + "  ORDER BY 2";  //MOHE-SCF-0156
	var sql="";  //MOHE-SCF-0156
	dataNameArray[0] = "facility_id";
	dataValueArray[0] = document.forms[0].p_facility_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	
	argumentArray[12]  = "SQL_ST_STORE_LOOKUP_SELECT_01";  //MOHE-SCF-0156
	argumentArray[13]  = "eST.Common.StRepository";  //MOHE-SCF-0156
	argumentArray[14]  = parNameArray;   //MOHE-SCF-0156
	argumentArray[15]  = parValueArray;   //MOHE-SCF-0156
	
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	else{
		obj.value=arr[0];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	} */
}
/*
	function searchItemCode( obj) {
		
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	
	argumentArray[0] = parent.criteria.formSalesHistoryQueryCriteria.SQL_ST_ITEM_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup( "Item", argumentArray );
		if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[0];
		}

		
	}

	*/
async function searchItemCode(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	
	var parNameArray  = new Array() ;	//MOHE-SCF-0156
	var parValueArray  = new Array() ;	//MOHE-SCF-0156
	
	dataNameArray[0] = "language_id";
	dataValueArray[0] = localeName;
	dataTypeArray[0] = STRING;
	//argumentArray[0] = document.forms[0].SQL_ST_ITEM_LOOKUP.value;	//MOHE-SCF-0156
	argumentArray[0] = "";		//MOHE-SCF-0156
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = document.forms[0].item_code.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	
	argumentArray[12]  = "SQL_ST_ITEM_LOOKUP";	//MOHE-SCF-0156
	argumentArray[13]  = "eST.Common.StRepository";	//MOHE-SCF-0156
	argumentArray[14]  = parNameArray;	//MOHE-SCF-0156
	argumentArray[15]  = parValueArray;	//MOHE-SCF-0156
	
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		if(arr[1]==undefined)
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
	else{
		obj.value=arr[0];
	}
	/*if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	} */
}
function searchResults(documentformSalesHistoryQueryCriteria) {
	var formObj = documentformSalesHistoryQueryCriteria;	
	//if (isValidFromToField(document.formSalesHistoryQueryCriteria.from_date.value, document.formSalesHistoryQueryCriteria.to_date.value, STRING, "Date", parent.messageFrame))
	if (doDateCheck(formObj.from_date, formObj.to_date, parent.parent.frames[2])) {
		//	parent.frames[1].location.href="../../eST/jsp/formSalesHistoryQueryResult.jsp?";
		formObj.action = "../../eST/jsp/SalesHistoryQueryResult.jsp";
		formObj.target = "result"; // Set the target attribute
		formObj.submit();
	}
}
async function searchPatient() {
	var patient_id = await PatientSearch();
	var formObj = document.forms[0];
	if (!((patient_id == null) || (patient_id == ""))) {
		formObj.patient_id.value = patient_id;
	}
	getPatientName(patient_id);
}
function searchpatientName(formObj) {
	var patientid = formObj.patient_id.value;
	if (!(patientid == null || patientid == "")) {
		getPatientName(patientid);
	}else{
		setPatientName("","");
	}
}
function getPatientName(_patient_id) {
	var formObj = document.formSalesHistoryQueryCriteria;
	var xmlHttp = new XMLHttpRequest();
	/*var xmlDoc="";
	xmlDoc.loadXML(getXMLString(null)); */
	var xmlString = getXMLString(null);
    var xmlDoc = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eST/jsp/SalesHistoryValidate.jsp?patient_id=" + _patient_id + "&validate=PATIENT_NAME", false);
	xmlHttp.send(xmlDoc);
	var responseText = xmlHttp.responseText;
	eval(responseText);
}
function setPatientName(_patient_name,_patient_nationality) {
	if (_patient_name == null || _patient_name == "" || _patient_name.toLowerCase() =='null') {
		document.getElementById("patient_name").innerText = "";
	} else {
		document.getElementById("patient_name").innerText = _patient_name;
	}
	document.getElementById("patient_nation").innerText = _patient_nationality;
}
function processScroll()
	{
		
		if (headTop < 0)
		{
			saveHeadPos();
			
		}
		if (headTop>0)
		{
			if (document.documentElement && document.documentElement.scrollTop)
				theTop = document.documentElement.scrollTop;
			else if (document.body)
				theTop = document.body.scrollTop;

			if (theTop>headTop){
				FloatHead.style.top = (theTop-headTop) + 'px';
				FloatHead1.style.top = (theTop-headTop) + 'px';
				
			}
			else{
				FloatHead.style.top = '0px';
				FloatHead1.style.top = '0px';
				
			}
		}
	}

	function saveHeadPos()
	{
		parTable = document.getElementById("divHeadSep");
		if (parTable != null)
		{
			headTop = parTable.offsetTop + 3;
			FloatHead = document.getElementById("heading");
			FloatHead1 = document.getElementById("heading1");
			
			FloatHead.style.position = "relative";
			FloatHead1.style.position = "relative";
			
		}
	}


function DateValidations(){
   var from_date    =  document.formSalesHistoryQueryCriteria.from_date.value ;
   var to_date =  document.formSalesHistoryQueryCriteria.to_date.value ;
  // var formObj = document.formSalesHistoryQueryCriteria;
   /* Commented by ganga Wednesday, November 21, 2012 for IN034623
   if(formObj.patient_id.value==""){
			alert("Patient ID Cannot Be Blank");
			formObj.patient_id.focus();
			return;
			}
	*/
   if(from_date==""){
		alert(getMessage("FROM_DATE_NOT_BLANK", "ST"));
		document.formSalesHistoryQueryCriteria.from_date.focus();
		return ;
   }else if (to_date==""){
		alert(getMessage("TO_DATE_NOT_BLANK", "ST"));
		document.formSalesHistoryQueryCriteria.to_date.focus();
		return ;
   }
   else{
	   if(!isBefore(from_date,to_date,"DMY",document.forms[0].language_id.value)) {
        alert(getMessage("FM_DATE_GR_TO_DATE", "ST"));
		document.formSalesHistoryQueryCriteria.from_date.focus();
		return ;
	   }
	   else{
       searchResults(document.formSalesHistoryQueryCriteria);
	   }
   }
}
