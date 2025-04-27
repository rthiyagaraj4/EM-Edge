/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
25/03/2019	  	IN067953	        Devindra  											MMS-KH-CRF-0014 [IN:067953] 
28/01/2021	  	12662	        	Manickavasagam J  										MMS-KH-CRF-0039
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
function validateDateTime(obj, locale) {
//	alert("hi"+locale+"OBJ"+obj.value);
	if (!(validDateObj(obj.value, "DMYHM", locale))) {
				alert(getMessage("INVALID_DATE_TIME", "PH"));
				obj.focus();
				return false; 
			}
		}
		

/*function validateDate1() {

	var formObj = document.frames.FormWardAcknowlegmentQueryCriteria;
	if (formObj.ward_date_from.value != "" && formObj.ward_date_to.value != "") {
		if (!doDateCheck(formObj.ward_date_from, formObj.ward_date_to,
				parent.parent.messageFrame)) {
			formObj.ward_date_to.select();
		} else {
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}
	}
	
	 
}*/

async function callPatientSearch(target) {// for patient lookup
	var patient_id = await PatientSearch();
	if (typeof (patient_id) == "string") {
		target.value = patient_id;
		
	}

}

async function locationLookup(target) {
	var formObj = document.FormWardAcknowlegmentQueryCriteria;

	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var retVal = "";
	if (target.name == "nursing_unit")
		argumentArray[0] = escape(formObj.SQL_PH_PRINT_PRESCRIPTIONS_SELECT2.value)
				+ "'" + formObj.p_language_id.value + "'";
	else if (target.name == "dispense_location")
		argumentArray[0] = escape(formObj.SQL_PH_REPORTS_DISP_LOOKUP.value)
				+ "'" + formObj.p_language_id.value + "'";
	else if (target.name == "bed_no") {
		var facility_id = formObj.facility_id.value;
		var nursing_unit_code = formObj.nursing_unit_code.value;
		if (nursing_unit_code == "" || facility_id == "") {
			alert("Nursing unit cannot be Blank");
			return false;
		}

		var sql = formObj.sql_ph_bed_no.value;
		sql = sql.replace("#", nursing_unit_code);
		sql = sql.replace("$", facility_id);
		//alert(sql);
		argumentArray[0] = sql;
	}

	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC;

	if (target.name == "nursing_unit")
		retVal = await CommonLookup(getLabel("Common.nursingUnit.label", "Common"),
				argumentArray);
	else if (target.name == "dispense_location")
		retVal = await CommonLookup(getLabel("ePH.DispenseLocation.label", "PH"),
				argumentArray);
	else if (target.name == "bed_no")
		retVal = await CommonLookup("Bed Search", argumentArray);

	//alert(retVal);
	if (retVal != null && retVal != "") {
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
		if (target.name == "nursing_unit")
			formObj.nursing_unit_code.value = arr[0];
		else if (target.name == "dispense_location")
			formObj.displocn_code.value = arr[0];
		else if (target.name == "bed_no_code")
			formObj.bed_no_code.value = arr[0];

		target.value = arr[1];
	}
}

function callResultPage() {
	var formObj = document.FormWardAcknowlegmentQueryCriteria;

	// Check for Mandatory Fields

	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	
	wardDateTo 			= 	formObj.ward_date_to.value;
	wardDateFrom 		= 	formObj.ward_date_from.value;
	patientId			=	formObj.patient_id.value;
	dispNo 				= 	formObj.dispense_no.value;
	dispLocn 			= 	formObj.displocn_code.value;
	orderId 			= 	formObj.order_id.value;
	nursingUnitCode		=	formObj.nursing_unit_code.value;
	bedNoCode			=	formObj.bed_no.value;
	status				=	formObj.status.value;
	systemdate			=	formObj.systemdate.value;
	onch				=   formObj.onch.value;//Added for GHL-CRF-0399  [IN062299]
	var order_type		=	formObj.order_type.value; //MMS-KH-CRF-0039
	var worksheet_id    =	formObj.worksheet_id.value; //MMS-KH-CRF-0039
	 if(  wardDateFrom == ""){
		   alert(getMessage("PH_FROM_TIME_NOT_BLANK", "PH"));
		   formObj.ward_date_from.focus();
			return;
		   }
		   if(wardDateTo == "" ){
		   alert(getMessage("PH_TO_TIME_NOT_BLANK","PH"));
		   formObj.ward_date_to.focus();
			return;
		   }
		
		  
		   if(!(isBeforeNow(formObj.ward_date_from.value,"DMYHM",formObj.p_language_id.value) ))
			{
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
				formObj.ward_date_from.select();
				formObj.ward_date_from.focus();
				return false;
			}
		   if(!(isBeforeNow(formObj.ward_date_to.value,"DMYHM",formObj.p_language_id.value) ))
			{
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
				formObj.ward_date_to.select();
				formObj.ward_date_to.focus();
				return false;
			}
			
		   if(!(isBefore(formObj.ward_date_from.value, formObj.ward_date_to.value, "DMYHM", formObj.p_language_id.value)))
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","PH")); 
				formObj.ward_date_to.select();
				formObj.ward_date_to.focus();
				return false;
			}
				
		   	/* commented for GHl-CRF-1152 start
			var max_days=daysBetween(formObj.ward_date_from.value,formObj.ward_date_to.value,"DMYHM",formObj.p_language_id.value);
					
					if(max_days>1){//Added for GHL-CRF-0451
						var errors=getMessage('PH_DATE_RANGE','PH');
						alert(errors);
						formObj.ward_date_from.focus();
						return false;
					}
					commented for GHl-CRF-1152 end*/ 
		    	if(  patientId == "" && nursingUnitCode==""){ // && nursingUnitCode=="" Added for MMS-KH-CRF-0014 [IN:067953]
                    alert(getMessage("PH_SELECT_PATIENT_ID_NURSING_UNIT", "PH"));//ADDED FOR MMS-KH-CRF-0014
		    		formObj.patient_id.focus();
		 			return;
		 		   }
	
	//parent.mainframeset.rows = "21%,*,0%,5%";
	parent.document.getElementById("wardacknowledgequeryframe").style.height="27vh";
	parent.document.getElementById("wardacknowledgeactionframe").style.height="50vh";
	parent.document.getElementById("wardretmedicationbuttonframe").style.height="7vh";
//	parent.subframeset.cols = "100%,*";
	parent.wardacknowledgeactionframe.location.href = "../../ePH/jsp/WardAcknowledgeResult.jsp?patientId="
			+ patientId
			+ "&orderid="
			+ orderId
			+ "&dispno="
			+ dispNo
			+ "&dispLocn="
			+ dispLocn
			+ "&wardDateTo="
			+ wardDateTo
			+ "&wardDateFrom=" 
			+ wardDateFrom
			+ "&nursingUnitCode="
			+ nursingUnitCode
			+ "&bedNoCode=" 
			+ bedNoCode
			+ "&status=" 
			+ status
			+ "&onch=" //Added for GHL-CRF-0399  [IN062299]
			+ onch//Added for GHL-CRF-0399  [IN062299]
			+ "&order_type="  //MMS-KH-CRF-0039
			+ order_type
			+ "&worksheet_id=" 
			+ worksheet_id;

	

}

function  selectAll(obj){
	var flag ="";
	if (obj.checked==false){
		//return;
		flag="false";
	}
	else{
		flag="true";
	}
	formObj= document.formwardaAcknowledge;
	//alert(formObj);
	//check=formObj.dispselect;
	//alert(check.length);
	//if (isNaN(check.length)){
	//	check.checked=true;
		//alert("single checked box");
		//formObjremarks=parent.wardretmedicationremarksframe.FormWardReturnRemarks;
		//formObjremarks.proceed.disabled=false;
		//return;
	//}
	/*for (i=0;i<check.length ;i++ ){
		if(flag=='true'){
		   check[i].checked=true;
		}
		else{
			check[i].checked=false;
		}
	}*/
	checkcount=formObj.total_count.value;
	for (var i=0;i<checkcount;i++ ){
		
		if(eval("document.formwardaAcknowledge.chk_"+i).checked != obj.checked)  //Added for IN032747 - end
			eval("document.formwardaAcknowledge.chk_"+i).click(); 
	
	}
	
}
function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
function reset() {
	f_query_criteria.location.reload();
}
function apply(){
//Added for GHL-CRF-0399  [IN062299] start
	var formObj = f_query_criteria.wardacknowledgequeryframe.document.FormWardAcknowlegmentQueryCriteria;
	wardDateTo 			= 	formObj.ward_date_to.value;
	wardDateFrom 		= 	formObj.ward_date_from.value;
	patientId			=	formObj.patient_id.value;
	dispNo 				= 	formObj.dispense_no.value;
	dispLocn 			= 	formObj.displocn_code.value;
	orderId 			= 	formObj.order_id.value;
	nursingUnitCode		=	formObj.nursing_unit_code.value;
	bedNoCode			=	formObj.bed_no.value;
	status				=	formObj.status.value;
	systemdate				=formObj.systemdate.value;
	 if(  wardDateFrom == ""){
		   alert(getMessage("PH_FROM_TIME_NOT_BLANK", "PH"));
		   formObj.ward_date_from.focus();
		   messageFrame.document.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		   return false;
			
		   }
		   if(wardDateTo == "" ){
		   alert(getMessage("PH_TO_TIME_NOT_BLANK","PH"));
		   formObj.ward_date_to.focus();
		   messageFrame.document.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			return false;
		   }
		   if(  patientId == "" && nursingUnitCode=="" ){ // && nursingUnitCode=="" Added for MMS-KH-CRF-0014 [IN:067953]
	 		   alert(getMessage("PH_SELECT_PATIENT_ID", "PH"));
	 		   formObj.patient_id.focus();
	 		   messageFrame.document.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	 			return false;
	 		   }
			   //Added for GHL-CRF-0399  [IN062299] end
	frmobj=f_query_criteria.wardacknowledgeactionframe.document.formwardaAcknowledge;
	if(f_query_criteria.wardacknowledgequeryframe.document.FormWardAcknowlegmentQueryCriteria.status.value == 'A'){
		//alert("All Records are Acknowledged");
		alert(getMessage("ALL_RECORDS_ACK", "PH"));//Added for GHL-CRF-0399  [IN062299]
		messageFrame.location.href ="../../eCommon/jsp/error.jsp?err_num=";
		return ;
	}else{
		//Added for GHL-CRF-0399  [IN062299] start
		if(f_query_criteria.wardacknowledgeactionframe.document.formwardaAcknowledge == undefined){
			//alert("proceed with search and selet records");
			alert(getMessage("SEARCH_NEED_BEFOREADD_CLICK", "PH"));
			messageFrame.document.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}
		else{
		//Added for GHL-CRF-0399  [IN062299] end
			eval( formApply(frmobj, PH_CONTROLLER) ) ;
			
			if (result){
				formObj.onch.value="Y";//Added for GHL-CRF-0399  [IN062299]
				f_query_criteria.wardacknowledgequeryframe.document.FormWardAcknowlegmentQueryCriteria.Search.click();
				
			}
			messageFrame.document.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
			
		}//Added for GHL-CRF-0399  [IN062299]
		
		
	}

}

function assignValue(obj,i){

	formObj= document.formwardaAcknowledge;
	var total_count = formObj.total_count.value;

	var doc="dispno"+i;
	doc_value=document.getElementById(doc).value;
	var srl="srlNo"+i;
	srlNo=document.getElementById(srl).value;
	var orderStatus = document.getElementById("orderStatus"+i).value; // Added for MMS-KH-CRF-0014 [IN:067953] - Start
	var orderlineNo = document.getElementById("orderlineNo"+i).value; 
	var orderId = document.getElementById("orderId"+i).value; // Added for MMS-KH-CRF-0014 [IN:067953] - End
	var order_type = formObj.order_type.value; //MMS-KH-CRF-0039 - start
	
	if(order_type=="A")
		worksheet_id = doc_value; 
	//MMS-KH-CRF-0039 - end
	var c =0;
	if(obj.checked==true){
			eval("document.formwardaAcknowledge.chk_"+i).value = "Y";
		 var xmlHttp = new XMLHttpRequest();
			var xmlDoc="";
			xmlStr ="<root><SEARCH  /></root>" ;
	         xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			
			xmlHttp.open("POST", "../../ePH/jsp/WardCheckDetailsStore.jsp?&dispNo="+doc_value+"&srlNo="+srlNo+"&orderStatus="+orderStatus+"&orderlineNo="+orderlineNo+"&orderId="+orderId+"&chk=chk"+"&order_type="+order_type, false);  // orderlineNo,orderId and orderStatus Added for MMS-KH-CRF-0014 [IN:067953]
			xmlHttp.send(xmlDoc);
			responseText = xmlHttp.responseText;
			for (var i=0;i<total_count;i++){  // Added for MMS-KH-CRF-0014 [IN:067953] - Start				
				if(eval("document.formwardaAcknowledge.dispno"+i).value == doc_value){						
				  if(eval("document.formwardaAcknowledge.chk_"+i).value !="Y"){ 
				  var doc="dispno"+i;
	              doc_value=document.getElementById(doc).value;
	              var srl="srlNo"+i;
	              srlNo=document.getElementById(srl).value;
	              var orderStatus = document.getElementById("orderStatus"+i).value; 
	              var orderlineNo = document.getElementById("orderlineNo"+i).value; 
	              var orderId = document.getElementById("orderId"+i).value; 					    	
		          eval("document.formwardaAcknowledge.chk_"+i).checked = true;
		          eval("document.formwardaAcknowledge.chk_"+i).value = "Y";
	              var xmlHttp = new XMLHttpRequest();
		          var xmlDoc="";
		          xmlStr ="<root><SEARCH  /></root>" ;
                  xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		          xmlHttp.open("POST", "../../ePH/jsp/WardCheckDetailsStore.jsp?&dispNo="+doc_value+"&srlNo="+srlNo+"&orderStatus="+orderStatus+"&orderlineNo="+orderlineNo+"&orderId="+orderId+"&chk=chk", false); // orderlineNo,orderId and orderStatus Added for MMS-KH-CRF-0014 [IN:067953]
		          xmlHttp.send(xmlDoc);
		          responseText = xmlHttp.responseText;
				}
				}
			} // Added for MMS-KH-CRF-0014 [IN:067953] - End
	}
	
	else{
		eval("document.formwardaAcknowledge.chk_"+i).value = "N";
		formObj.selectall.checked=false;
		var xmlHttp = new XMLHttpRequest();
		  xmlStr ="<root><SEARCH  /></root>" ;
	     
		var xmlDoc="";
		 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		//xmlDoc.loadXML(getXMLString(null));
		 var totalRows = document.getElementById("tablePreRec").getElementsByTagName('tr');  // MMS-KH-CRF-0014 [IN:067953] - Start
		 var actualRowCount = eval("document.formwardaAcknowledge.actualRowCount"+i).value;		
		var totalCells=totalRows[actualRowCount].cells;
		for(var j=0;j<totalCells.length;j++){
			totalCells[j].style.backgroundColor = '';			
		} // MMS-KH-CRF-0014 [IN:067953] - End
		xmlHttp.open("POST", "../../ePH/jsp/WardCheckDetailsStore.jsp?&dispNo="+doc_value+"&srlNo="+srlNo+"&orderStatus="+orderStatus+"&orderlineNo="+orderlineNo+"&orderId="+orderId+"&chk=Unchk", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		for (var j=0;j<total_count;j++ ){ // Added for MMS-KH-CRF-0014 [IN:067953] - Start				
			if(eval("document.formwardaAcknowledge.dispno"+j).value == doc_value)
			 if(eval("document.formwardaAcknowledge.chk_"+j).value=="Y"){               
			      var actualRowCount = eval("document.formwardaAcknowledge.actualRowCount"+j).value;
				  var totalCells=totalRows[actualRowCount].cells;
				  for(var p=0;p<totalCells.length;p++){
			          totalCells[p].style.backgroundColor = '';			
		          } // MMS-KH-CRF-0014 [IN:067953] - End
				  var doc="dispNoc"+j;
	              doc_value=document.getElementById(doc).value;
	              var srl="srlNoc"+j;
	              srlNo=document.getElementById(srl).value;
	              var orderStatus = document.getElementById("orderStatus"+j).value; 
	              var orderlineNo = document.getElementById("orderlineNo"+j).value; 
	              var orderId = document.getElementById("orderId"+j).value;
					 //eval("document.formwardaAcknowledge.check_id"+i).click(); 					    	
		          eval("document.formwardaAcknowledge.chk_"+j).checked = false;
		          eval("document.formwardaAcknowledge.chk_"+j).value = "N";
	              var xmlHttp = new XMLHttpRequest();
		          var xmlDoc="";
		          xmlStr ="<root><SEARCH  /></root>" ;
                  xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");				  
		          xmlHttp.open("POST", "../../ePH/jsp/WardCheckDetailsStore.jsp?&dispNo="+doc_value+"&srlNo="+srlNo+"&orderStatus="+orderStatus+"&orderlineNo="+orderlineNo+"&orderId="+orderId+"&chk=Unchk", false); // orderlineNo,orderId and orderStatus Added for MMS-KH-CRF-0014 [IN:067953]
		          xmlHttp.send(xmlDoc);
		          responseText = xmlHttp.responseText;
			 }
		} // Added for MMS-KH-CRF-0014 [IN:067953] - End
		
		
	}

for (var i=0;i<total_count;i++ ){
	if(eval("document.formwardaAcknowledge.chk_"+i).checked)
		c++;
}

	if((parseInt(total_count))==c)
		formObj.selectall.checked=true;
}

async function viewDrugDetails(patient_id,dispNo,srlNo,order_type,disp_locn_code){//order_type,disp_locn_code added for MMS-KH-CRF-0039

var dialogHeight= "400px" ;
var dialogWidth	= "700px" ; //changed 40 to 70 MMS-KH-CRF-0039
var dialogTop	= "370" ;
var dialogLeft	= "42" ;
var center		= "1" ;
var status		= "no";
var scroll		= "yes";
var features	= "dialogLeft:" + dialogLeft + ";dialogHeight:"+dialogHeight+"; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
var arguments	= "" ;
 await window.showModalDialog("../../ePH/jsp/WardAckDrugDetails.jsp?patientId="+patient_id+"&dispNo="+dispNo+"&srlNo="+srlNo+"&order_type="+order_type+"&disp_locn_code="+disp_locn_code,arguments,features);
//order_type,disp_locn_code added for MMS-KH-CRF-0039
}
function showCalendarValidate(str){
	
	var flg = showCalendar(str,null,'hh:mm');
	document.getElementById(str).focus();
    return flg;
}
function barcodeScan(obj){  // MMS-KH-CRF-0014 [IN:067953] - Start    
	formObj= document.formwardaAcknowledge;
	var total_count = formObj.total_count.value;
	var barcode = obj.value;
	var order_type = formObj.order_type.value //MMS-KH-CRF-0039

	var totalRows = document.getElementById("tablePreRec").getElementsByTagName('tr');
	var flag = false;	
	var alreadySelected = false;
  for(i=0;i<total_count;i++){
	var doc="dispno"+i;
	doc_value=document.getElementById(doc).value;
	var srl="srlNo"+i;
	srlNo=document.getElementById(srl).value;
	var orderStatus = document.getElementById("orderStatus"+i).value; 
	var orderlineNo = document.getElementById("orderlineNo"+i).value; 
	var orderId = document.getElementById("orderId"+i).value;
	var c = 0;
	if(doc_value==barcode){
		flag = true;			
	   if(eval("document.formwardaAcknowledge.chk_"+i).checked == true){		    
		    var actualRowCount = eval("document.formwardaAcknowledge.actualRowCount"+i).value;		
			var totalCells=totalRows[actualRowCount].cells;
			for(var j=0;j<totalCells.length;j++){			 
				    if(totalCells[j].style.backgroundColor=='#f8bdc6'){
				    	break;
				    }
				    else{
				        totalCells[j].style.backgroundColor = '#f8bdc6';
					    totalCells[j].scrollIntoView(false);
				    }
			}			
		 if(!alreadySelected){
			alreadySelected = true;
			alert(getMessage("SCANNED_ITEM_SELECTED","PH")); 
		 }
		    formObj.barCodeId.value="";
			formObj.barCodeId.focus();
	   }
	  else{
		var actualRowCount = eval("document.formwardaAcknowledge.actualRowCount"+i).value;		
		var totalCells=totalRows[actualRowCount].cells;
		for(var j=0;j<totalCells.length;j++){
			totalCells[j].style.backgroundColor = '#f8bdc6';
			totalCells[j].scrollIntoView(false);
		}	
		eval("document.formwardaAcknowledge.chk_"+i).checked = true;
		eval("document.formwardaAcknowledge.chk_"+i).value = "Y";
	    var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlStr ="<root><SEARCH  /></root>" ;
         xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../ePH/jsp/WardCheckDetailsStore.jsp?&dispNo="+doc_value+"&srlNo="+srlNo+"&orderStatus="+orderStatus+"&orderlineNo="+orderlineNo+"&orderId="+orderId+"&chk=chk&order_type="+order_type, false); // orderlineNo,orderId and orderStatus Added for MMS-KH-CRF-0014 [IN:067953]
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
	   if(formObj.barCodeId!=undefined){
			formObj.barCodeId.value="";
			formObj.barCodeId.focus(); 
		}
	 }
	   for (var m=0;m<total_count;m++ ){
			if(eval("document.formwardaAcknowledge.chk_"+m).checked)
				c++;
		}
			if((parseInt(total_count))==c)
				formObj.selectall.checked=true;
	}
	if(i==total_count-1 && !flag){ 
		alert(getMessage("NOT_VALID_SCAN","PH")); // PH_NOTMATCHING_BAR_CODE changed to NOT_VALID_SCAN for #70105
		if(formObj!=undefined && formObj.barCodeId !=undefined ){
			formObj.barCodeId.value="";
			formObj.barCodeId.focus();
		}
	 }
  }
} 
function setfldFocus(barcode_flag){
	if(barcode_flag){		
		if(document.formwardaAcknowledge!=undefined && document.formwardaAcknowledge!=undefined){
			document.formwardaAcknowledge.barCodeId.focus();
		}
	}
} // MMS-KH-CRF-0014 [IN:067953] - End
