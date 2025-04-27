  var function_id = "PH_ORDER_ROUTING" ;
var result = false ;
var message = "" ;
var flag = "" ;
var selectDefaultFacility = "";

function create() {

	if (orderRoutingFrame.orderrouting_top != null){ 

		orderRoutingFrame.orderrouting_top.location.href="../../ePH/jsp/OrderRoutingCharAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT ;
		orderRoutingFrame.orderrouting_middle.location.href="../../ePH/jsp/OrderRoutingLocnDetAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT ;
		orderRoutingFrame.orderrouting_bottom.location.href="../../ePH/jsp/OrderRoutingLocationAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT ;
	}else{
		orderRoutingFrame.location.href="../../ePH/jsp/OrderRoutingFrame.jsp?param=createIfFrameIsNull";
	}
}
function query(){
	orderRoutingFrame.location.href="../../ePH/jsp/OrderRoutingQueryCriteria.jsp?function_id="+function_id ;
}
function beforePost(str){
//	alert("Order Routing::"+str);
}
function apply() {
	// This check is to avoid the error ,on click of apply in query criteria page...and also in query result page
	var url = orderRoutingFrame.location.href;
	url = url.toLowerCase();
	if(orderRoutingFrame.document.query_form==undefined && (url.indexOf("orderroutingqueryresult")==-1)){
		// if undefined....Insert mode
		if(orderRoutingFrame.document.frmOrderRoutingCharacteristics == undefined){
			var formObj1=orderRoutingFrame.orderrouting_top.document.frmOrderRoutingCharacteristics;
			var formObj2=orderRoutingFrame.orderrouting_middle.document.frmOrderRoutingLocationDetail;
			formObj2.number_of_rows.value = orderRoutingFrame.orderrouting_middle.document.getElementById('locationDetailTable').rows.length-3;
			var manCheck=false;
			for (var i=0;i<formObj2.number_of_rows.value ;i++ ){
				var obj = eval("formObj2.select"+i);
				if (obj.checked){
					manCheck = true;
				}
			}
			if (formObj2.number_of_rows.value >0 && manCheck==true){
				var fields = new Array ( formObj1.ordering_facility_id ,formObj1.ordering_source_type,formObj1.ordering_source_code);
				//var names = new Array ( "Ordering Facility","Location Type","Location");
				var names = new Array(getLabel("Common.OrderingFacility.label","Common"), getLabel("Common.locationtype.label","Common"),getLabel("Common.Location.label","Common"));

				var formArray = new Array(formObj1,formObj2);

				if(orderRoutingFrame.orderrouting_top.checkFieldsofMst( fields, names, messageFrame)) {
					eval(formApply( formArray,PH_CONTROLLER ));
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					if( result ) {
						onSuccess();
					}
				}
			}else{

				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("SELECT_ATLEAST_ONE_RECORD","PH");
			//Add/Select Atleast One record!!!";
			}

		}else if (orderRoutingFrame.document.frmOrderRoutingCharacteristics.mode.value == MODE_MODIFY){
			if (orderRoutingFrame.document.frmOrderRoutingCharacteristics.routing_level.value=="S"){
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_ROUTING_LEVEL_CANNOT_MODIFY","PH");
			}else{
				var fields = new Array ( orderRoutingFrame.document.frmOrderRoutingCharacteristics.rtn_ord_disp_locn_code,orderRoutingFrame.document.frmOrderRoutingCharacteristics.stat_ord_disp_locn_code);
				
				var names = new Array(getLabel("ePH.Routing.label","PH"), getLabel("Common.Stat.label","Common"));

				if(orderRoutingFrame.checkFieldsofMst( fields, names, messageFrame)){
					eval(formApply( orderRoutingFrame.document.frmOrderRoutingCharacteristics,PH_CONTROLLER ));
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					if( result ) {
						var ordering_facility_desc = orderRoutingFrame.document.frmOrderRoutingCharacteristics.ordering_facility_desc.value;
						var ordering_facility_id = orderRoutingFrame.document.frmOrderRoutingCharacteristics.ordering_facility_id.value;
						var ordering_source_type_desc = orderRoutingFrame.document.frmOrderRoutingCharacteristics.ordering_source_type_desc.value;
						var ordering_source_code = orderRoutingFrame.document.frmOrderRoutingCharacteristics.ordering_source_code.value;
						var ordering_source_code_desc = orderRoutingFrame.document.frmOrderRoutingCharacteristics.ordering_source_code_desc.value;
						var routing_level = orderRoutingFrame.document.frmOrderRoutingCharacteristics.routing_level.value;

						var routing_code = orderRoutingFrame.document.frmOrderRoutingCharacteristics.routing_code.value;
						var routing_code_desc = orderRoutingFrame.document.frmOrderRoutingCharacteristics.routing_code_desc.value;
						orderRoutingFrame.document.location.href="../../ePH/jsp/OrderRoutingCharAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&ordering_facility_desc="+ordering_facility_desc+"&ordering_facility_id="+ordering_facility_id+"&ordering_source_type_desc="+ordering_source_type_desc+"&ordering_source_code="+ordering_source_code+"&ordering_source_code_desc="+ordering_source_code_desc+"&routing_level="+routing_level+"&routing_code="+routing_code+"&routing_code_desc="+routing_code_desc;
					}
				}
			}
		}
	}else{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}
function onSuccess() {

	if (orderRoutingFrame.orderrouting_top != null){
		orderRoutingFrame.orderrouting_top.location.href="../../ePH/jsp/OrderRoutingCharAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT ;
		orderRoutingFrame.orderrouting_middle.location.href="../../ePH/jsp/OrderRoutingLocnDetAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT ;
		orderRoutingFrame.orderrouting_bottom.location.href="../../ePH/jsp/OrderRoutingLocationAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT ;
	}else{
		orderRoutingFrame.location.href="../../ePH/jsp/OrderRoutingFrame.jsp?param=createIfFrameIsNull";
	}

}
function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
function reset(){
	var url = orderRoutingFrame.location.href;
	url = url.toLowerCase();

	if ( (url.indexOf("orderroutingquerycriteria")!=-1) ) {
		//orderRoutingFrame.document.query_form.reset();
		function_id = orderRoutingFrame.document.query_form.function_id.value;
		orderRoutingFrame.location.href="../../ePH/jsp/OrderRoutingQueryCriteria.jsp?function_id="+function_id ;
	}
	else if ( (url.indexOf("orderroutingframe")!=-1) ) {
		create();
		/*orderRoutingFrame.orderrouting_top.frmOrderRoutingCharacteristics.reset();
		clearLocation();
		orderRoutingFrame.orderrouting_bottom.frmOrderRoutingLocation.reset();*/
	}else if ( (url.indexOf("orderroutingcharacteristicsaddmodify") != -1)){
		orderRoutingFrame.frmOrderRoutingCharacteristics.reset();
	}
}

function AddRow(obj){
	var formObjMiddle = parent.orderrouting_middle.frmOrderRoutingLocationDetail;
	var row_no =  parent.orderrouting_middle.document.getElementById('locationDetailTable').rows.length-3;
	var formObjBottom=parent.orderrouting_bottom.frmOrderRoutingLocation;
	var formObjChar = parent.orderrouting_top.frmOrderRoutingCharacteristics;

	var routing_code="";				var routing_code_desc="";
	var performing_facility_id	="";	var performing_facility_desc="";
	var rtn_ord_disp_locn_code	="";	var rtn_ord_disp_locn_desc	="";
	var stat_ord_disp_locn_code	="";	var stat_ord_disp_locn_desc	="";
	var disch_ord_disp_locn_code="";	var disch_ord_disp_locn_desc="";

	if (formObjChar.ordering_source_code.value != "" && formObjChar.ordering_source_code.value =="*A" && formObjBottom.routing_level.value=="S"){
			alert(getMessage("SOURCE_SHLD_NOT_BE_SELECTED","PH"));
			
			formObjBottom.routing_level.focus();
			return false;
		} 

	var routing_level_code	=formObjBottom.routing_level.value;
	var routing_level_desc	= "";
	if (routing_level_code=="S"){
		routing_level_desc=getLabel("Common.source.label","Common");
	}
	else if (routing_level_code=="O"){
		routing_level_desc=getLabel("Common.OrderType.label","Common");
	}
	else if (routing_level_code=="D"){
		routing_level_desc=getLabel("ePH.DrugClass.label","PH");
	}
	else if (routing_level_code=="G"){
		routing_level_desc=getLabel("Common.Drug.label","Common");
	}
	else if (routing_level_code=="L"){
		routing_level_desc=getLabel("Common.Drug.label","Common")+"  so";
	}
	else if (routing_level_code=="M"){
		routing_level_desc=getLabel("Common.MedicalItem.label","Common");
	}
	else if (routing_level_code=="H"){ //added for Bru-HIMS-CRF-093[29960] 
		routing_level_desc=getLabel("ePH.HomeLeave.label","PH");
	}

	// If routing_level  is 'S'
	if (routing_level_code=="S" || routing_level_code=="H"){ //added || routing_level_code=="H" for Bru-HIMS-CRF-093[29960] 
	
		if(routing_level_code=="H"){ //added  if condition for Bru-HIMS-CRF-093[29960] 
            routing_code			= "*A";
			routing_code_desc		= getLabel("ePH.HomeLeave.label","PH");
		}
		else{
			routing_code			= "";
			routing_code_desc		= getLabel("Common.source.label","Common");
		}
		//Below line commented on 18Sep2007
		//routing_code_desc		= "&nbsp;";
		
		//Below line added on 18Sep2007 to make the Duplicate check for Source level work
		routing_code_desc		= getLabel("Common.source.label","Common");

		performing_facility_id	= formObjBottom.performing_facility_id.value;
		performing_facility_desc= formObjBottom.performing_facility_id.options[formObjBottom.performing_facility_id.selectedIndex].text;

		rtn_ord_disp_locn_code	= formObjBottom.rtn_ord_disp_locn_code.value;
		if(rtn_ord_disp_locn_code != ""){
			rtn_ord_disp_locn_desc	= formObjBottom.rtn_ord_disp_locn_code.options[formObjBottom.rtn_ord_disp_locn_code.selectedIndex].text;
		}else{
			alert(getMessage("ROUTINE_CANT_BE_BLANK","PH"));
			formObjBottom.rtn_ord_disp_locn_code.focus();
			return false;
		}

		stat_ord_disp_locn_code	= formObjBottom.stat_ord_disp_locn_code.value;

		if(stat_ord_disp_locn_code!="")
			stat_ord_disp_locn_desc	= formObjBottom.stat_ord_disp_locn_code.options[formObjBottom.stat_ord_disp_locn_code.selectedIndex].text;
		else{
			alert(getMessage("STAT_CANT_BE_BLANK","PH"));
			formObjBottom.stat_ord_disp_locn_code.focus();
			return false;
		}

		disch_ord_disp_locn_code= formObjBottom.disch_ord_disp_locn_code.value;


		if(disch_ord_disp_locn_code!=""){
			disch_ord_disp_locn_desc= formObjBottom.disch_ord_disp_locn_code.options[formObjBottom.disch_ord_disp_locn_code.selectedIndex].text;
		}
		else
		{
				alert(getMessage("DISCHARGE_HOME_MED_CANT_BE_BLANK","PH"));
				formObjBottom.disch_ord_disp_locn_code.focus();
				return false;
//			disch_ord_disp_locn_desc="&nbsp;";
		}
		
	}
	//If routing_level is 'O'
	if (routing_level_code=="O" || routing_level_code=="D" || routing_level_code=="L" ){
		if (checkForMandatory()==true){
			routing_code			= formObjBottom.routing_code.value;
			routing_code_desc		= formObjBottom.routing_code.options[formObjBottom.routing_code.selectedIndex].text;
			performing_facility_id	= formObjBottom.performing_facility_id.value;
			performing_facility_desc= formObjBottom.performing_facility_id.options[formObjBottom.performing_facility_id.selectedIndex].text;
			rtn_ord_disp_locn_code	= formObjBottom.rtn_ord_disp_locn_code.value;
			rtn_ord_disp_locn_desc	= formObjBottom.rtn_ord_disp_locn_code.options[formObjBottom.rtn_ord_disp_locn_code.selectedIndex].text;
			stat_ord_disp_locn_code	= formObjBottom.stat_ord_disp_locn_code.value;
			stat_ord_disp_locn_desc	= formObjBottom.stat_ord_disp_locn_code.options[formObjBottom.stat_ord_disp_locn_code.selectedIndex].text;
			disch_ord_disp_locn_code= formObjBottom.disch_ord_disp_locn_code.value;
			if(disch_ord_disp_locn_code!="")
				disch_ord_disp_locn_desc= formObjBottom.disch_ord_disp_locn_code.options[formObjBottom.disch_ord_disp_locn_code.selectedIndex].text;
			else
				disch_ord_disp_locn_desc="&nbsp;";
         
		}else{
			return false;
		}
	}
	//If routing_level is 'G'
	if (routing_level_code=="G"){
		if (checkForMandatory()==true){
			routing_code			= formObjBottom.drug_code.value;
			routing_code_desc		= formObjBottom.drug_desc.value;
			performing_facility_id	= formObjBottom.performing_facility_id.value;
			performing_facility_desc= formObjBottom.performing_facility_id.options[formObjBottom.performing_facility_id.selectedIndex].text;
			rtn_ord_disp_locn_code	= formObjBottom.rtn_ord_disp_locn_code.value;
			rtn_ord_disp_locn_desc	= formObjBottom.rtn_ord_disp_locn_code.options[formObjBottom.rtn_ord_disp_locn_code.selectedIndex].text;
			stat_ord_disp_locn_code	= formObjBottom.stat_ord_disp_locn_code.value;
			stat_ord_disp_locn_desc	= formObjBottom.stat_ord_disp_locn_code.options[formObjBottom.stat_ord_disp_locn_code.selectedIndex].text;
			disch_ord_disp_locn_code= formObjBottom.disch_ord_disp_locn_code.value;
			if(disch_ord_disp_locn_code!="")
				disch_ord_disp_locn_desc= formObjBottom.disch_ord_disp_locn_code.options[formObjBottom.disch_ord_disp_locn_code.selectedIndex].text;
			else
				disch_ord_disp_locn_desc="&nbsp;";
    
		}else{
			return false;
		}
	}
	//If routing_level is 'M'
if (routing_level_code=="M"){
		if (checkForMandatory()==true){
		
			routing_code			= formObjBottom.drug_code.value;
			routing_code_desc		= formObjBottom.drug_desc.value;
		
			performing_facility_id	= formObjBottom.performing_facility_id.value;
			performing_facility_desc= formObjBottom.performing_facility_id.options[formObjBottom.performing_facility_id.selectedIndex].text;
			rtn_ord_disp_locn_code	= formObjBottom.rtn_ord_disp_locn_code.value;
			rtn_ord_disp_locn_desc	= formObjBottom.rtn_ord_disp_locn_code.options[formObjBottom.rtn_ord_disp_locn_code.selectedIndex].text;
			stat_ord_disp_locn_code	= formObjBottom.stat_ord_disp_locn_code.value;
			stat_ord_disp_locn_desc	= formObjBottom.stat_ord_disp_locn_code.options[formObjBottom.stat_ord_disp_locn_code.selectedIndex].text;
			disch_ord_disp_locn_code= formObjBottom.disch_ord_disp_locn_code.value;
			if(disch_ord_disp_locn_code!="")
				disch_ord_disp_locn_desc= formObjBottom.disch_ord_disp_locn_code.options[formObjBottom.disch_ord_disp_locn_code.selectedIndex].text;
			else
				disch_ord_disp_locn_desc="&nbsp;";
      
		}else{
			return false;
		}
	}

	if (findDuplicate(routing_level_desc,routing_code_desc, parent.orderrouting_middle.document.getElementById('locationDetailTable').rows.length)){
		return false;
	}

	curr_row	=	 parent.orderrouting_middle.document.getElementById('locationDetailTable').insertRow();
	var classval;


	if(row_no % 2 == 0 )
		classval	=	"QRYEVEN";
	else
		classval	=	"QRYODD";

	for(i=0; i<7; i++)	{
		cell	=	curr_row.insertCell();
		if (i==0){
			curr_row.cells[0].className	= classval;
			curr_row.cells[0].innerHTML = routing_level_desc+"<input type='hidden' name='routing_level"+row_no+"' id='routing_level"+row_no+"' value='"+routing_level_code+"'>";
		}else if (i==1){
			curr_row.cells[1].className	= classval;
			curr_row.cells[1].innerHTML = routing_code_desc+"<input type='hidden' name='routing_code"+row_no+"' id='routing_code"+row_no+"' value='"+routing_code+"'>";
		}else if (i==2){
			curr_row.cells[2].className	= classval;
			curr_row.cells[2].innerHTML = performing_facility_desc+"<input type='hidden' name='performing_facility_id"+row_no+"' id='performing_facility_id"+row_no+"' value='"+performing_facility_id+"'>";
		}else if (i==3){
			curr_row.cells[3].className	= classval;
			curr_row.cells[3].innerHTML = rtn_ord_disp_locn_desc+"<input type='hidden' name='rtn_ord_disp_locn_code"+row_no+"' id='rtn_ord_disp_locn_code"+row_no+"' value='"+rtn_ord_disp_locn_code+"'>";
		}else if (i==4){
			curr_row.cells[4].className	= classval;
			curr_row.cells[4].innerHTML = stat_ord_disp_locn_desc+"<input type='hidden' name='stat_ord_disp_locn_code"+row_no+"' id='stat_ord_disp_locn_code"+row_no+"' value='"+stat_ord_disp_locn_code+"'>";
		}else if (i==5){
			curr_row.cells[5].className	= classval;
			curr_row.cells[5].innerHTML = disch_ord_disp_locn_desc+"<input type='hidden' name='disch_ord_disp_locn_code"+row_no+"' id='disch_ord_disp_locn_code"+row_no+"' value='"+disch_ord_disp_locn_code+"'>";
		}else if (i==6){ 
			curr_row.cells[6].className	= classval;
			curr_row.cells[6].innerHTML = "<input type='checkbox' name='select"+row_no+"' id='select"+row_no+"' checked value='Y'>";
		}
	}
	
	ResetToDefaultValues();
}

function loadRelatedLocation(obj){
	
	var formObj = document.frmOrderRoutingCharacteristics;

	/*if(obj.value =="C"){
	
		parent.orderrouting_bottom.frmOrderRoutingLocation.disch_ord_disp_locn_code.disabled = false;
	}else{
		parent.orderrouting_bottom.frmOrderRoutingLocation.disch_ord_disp_locn_code.disabled = false;
	}*/

	var len =formObj.ordering_source_code.options.length;
	for(var i=0;i<len;i++) {
		formObj.ordering_source_code.remove("ordering_source_code") ;
	}
	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	formObj.ordering_source_code.add(opt);
	if(obj.value=='C'||obj.value=='N'){
	var tp ="*"+getLabel("Common.all.label","Common");
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "*A" ;
	formObj.ordering_source_code.add(opt);
	}
	if (obj.value !=""){

		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr	="<root><SEARCH " ;
		xmlStr += "ordering_source_type=\""+ checkSpl(obj.value) +"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderRoutingValidate.jsp?bean_id=" + bean_id + "&bean_name=" +bean_name+"&ordering_source_type="+obj.value+"&facility_id="+formObj.facility_id.value, false ) ;
		xmlHttp.send( xmlDoc ) ;

		eval(xmlHttp.responseText);
		
	}

}

function loadIntoLocation(objCode,objDesc){

	var formObj = document.frmOrderRoutingCharacteristics;
	var element = document.createElement('OPTION') ;
	element.value		=  (objCode) ;
	element.text		=  (objDesc) ;
	formObj.ordering_source_code.add(element);
}


function loadIntoLocationQry(objCode,objDesc){

	var formObj = document.query_form;
	var element = document.createElement('OPTION') ;
	element.value		=  (objCode) ;
	element.text		=  (objDesc) ;
	formObj.ordering_source_code_cmb.add(element);
}


function loadRelatedLocationQry(obj){
	
	var formObj = document.query_form;
	
	var len =formObj.ordering_source_code_cmb.options.length;
	for(var i=0;i<len;i++) {
		formObj.ordering_source_code_cmb.remove("ordering_source_code_cmb") ;
	}
	var tp ="---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	formObj.ordering_source_code_cmb.add(opt);

	if(obj.value=='C'||obj.value=='N'){
	var tp = "*"+getLabel("Common.all.label","Common");
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "*A" ;
	formObj.ordering_source_code_cmb.add(opt);
	}
	
	if (obj.value !=""){

		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr	="<root><SEARCH " ;
		xmlStr += "ordering_source_type=\""+ checkSpl(obj.value) +"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderRoutingValidate.jsp?bean_id=" + bean_id + "&bean_name=" +bean_name+"&ordering_source_type="+obj.value+"&facility_id="+formObj.facility_id.value+"&QryMode=yes", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}

}



function validateForRoutingLevel(){
	var formObj = parent.orderrouting_bottom.document.frmOrderRoutingLocation;
	var formObjChar = document.frmOrderRoutingCharacteristics;

	if (formObjChar.ordering_source_code.value != "" && formObjChar.ordering_source_code.value =="*A" && formObj.routing_level.value=="S"){
		alert(getMessage("ALL_LOC_SHOULD_NOT_BE_SELECTED","PH"));
/*		formObj.routing_level.value="D";

		var len=formObj.routing_code.length;
		for(var i=0;i<len;i++) {
			formObj.routing_code.remove("routing_code") ;
		}
		var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
		var opt1 = document.createElement("OPTION") ;
		opt1.text = tp ;
		opt1.value = "" ;
		formObj.routing_code.add(opt1);


		var len=formObj.rtn_ord_disp_locn_code.length;
		for(var i=0;i<len;i++) {
			formObj.rtn_ord_disp_locn_code.remove("rtn_ord_disp_locn_code") ;
			formObj.stat_ord_disp_locn_code.remove("stat_ord_disp_locn_code") ;
			formObj.disch_ord_disp_locn_code.remove("disch_ord_disp_locn_code") ;
		}
		var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
		var opt1 = document.createElement("OPTION") ;
		opt1.text = tp ;
		opt1.value = "" ;
		formObj.rtn_ord_disp_locn_code.add(opt1);

		var opt2 = document.createElement("OPTION") ;
		opt2.text = tp ;
		opt2.value = "" ;
		formObj.stat_ord_disp_locn_code.add(opt2);

		var opt3 = document.createElement("OPTION") ;
		opt3.text = tp ;
		opt3.value = "" ;
		formObj.disch_ord_disp_locn_code.add(opt3);

		formObj.drug_code.value = "";
		formObj.drug_desc.value = "";*/

		return false;
	}
}

function loadRoutingLevelRelatedElements(obj){
	var facility_id = "";
	var ordering_source_type="";
	try{
		var formObjChar = parent.orderrouting_top.document.frmOrderRoutingCharacteristics;
		var formObj = document.frmOrderRoutingLocation;
		if (formObjChar.ordering_source_code.value != "" && formObjChar.ordering_source_code.value =="*A" && formObj.routing_level.value=="S"){
			alert(getMessage("SOURCE_SHLD_NOT_BE_SELECTED","PH"));
			
			obj.focus();
			return false;
		} 
		 facility_id = formObjChar.facility_id.value;
		 ordering_source_type =parent.orderrouting_top.frmOrderRoutingCharacteristics.ordering_source_type.value ;
	}
	catch(e){
		var formObj = document.query_form;
		facility_id = formObj.ordering_facility_id.value;
		ordering_source_type = formObj.ordering_source_type.value
	}
	
	clearRoutingCode();
	clearRoutineStatDischargeList();
	formObj.drug_code.value = "";
	formObj.drug_desc.value = "";
	if (obj.value=="D"){

		formObj.routing_code.style.display="inline";
		formObj.routing_code.style.visibility="visible";
		formObj.drug_desc.style.display="none";
		formObj.btnDrug.style.display="none";
		try{
			formObj.performing_facility_id.disabled = false;
			formObj.imgRoutine.style.visibility="visible";
			formObj.imgRoutingCode.style.visibility="visible";
			formObj.imgStat.style.visibility="visible";
		}
		catch(e){}
		loadDrugClass("routing_code");
		return false;

	}
	else if (obj.value=="O"){

		formObj.routing_code.style.display="inline";
		formObj.routing_code.style.visibility="visible";
		formObj.drug_desc.style.display="none";
		formObj.btnDrug.style.display="none";

		try{
			formObj.performing_facility_id.disabled = false;
			formObj.imgRoutine.style.visibility="visible";
			formObj.imgRoutingCode.style.visibility="visible";
			formObj.imgStat.style.visibility="visible";
		}
		catch(e){}

		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderRoutingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&routing_level="+formObj.routing_level.value+"&facility_id="+formObj.facility_id.value+"&disp_locn_type="+ordering_source_type, false ) ;
		xmlHttp.send( xmlDoc ) ;

		eval(xmlHttp.responseText);
		return false;
	}
	else if (obj.value=="G"){

		formObj.routing_code.style.display="none";
		formObj.drug_desc.style.display="inline";
		formObj.drug_desc.style.visibility="visible";
		formObj.drug_desc.disabled = false;
		formObj.btnDrug.style.display="inline";
		formObj.btnDrug.style.visibility="visible";
		formObj.btnDrug.disabled = false;
		try{
			formObj.performing_facility_id.disabled = false;
			formObj.imgRoutine.style.visibility="visible";
			formObj.imgRoutingCode.style.visibility="visible";
			formObj.imgStat.style.visibility="visible";
		}
		catch(e){}
		return false;
	}
	else if (obj.value=="M"){
		formObj.routing_code.style.display="none";
		formObj.drug_desc.style.display="inline";
		formObj.drug_desc.style.visibility="visible";
		formObj.drug_desc.disabled = false;
		formObj.btnDrug.style.display="inline";
		formObj.btnDrug.style.visibility="visible";
		formObj.btnDrug.disabled = false;
		try{
			formObj.performing_facility_id.disabled = false;
			formObj.imgRoutine.style.visibility="visible";
			formObj.imgRoutingCode.style.visibility="visible";
			formObj.imgStat.style.visibility="visible";
		}
		catch(e){}
		return false;
	}
	else if (obj.value=="S"){
		loadRoutineStatDischargeBasedOnFacility();
		formObj.RoutingCode.style.display = "none";
		formObj.RoutingCode.style.visibility = "hidden";
		formObj.drug_desc.style.display = "none";
		formObj.btnDrug.style.display="none";
		formObj.drug_code.value="";
		formObj.drug_desc.value="";
		try{
			formObj.performing_facility_id.value = facility_id;
			formObj.performing_facility_id.disabled = false; // kiran
			formObj.imgRoutingCode.style.visibility="hidden";
		}catch(e){}

	/*	formObj.imgRoutine.style.visibility="hidden";
		formObj.imgStat.style.visibility="hidden";*/
		return false;
	}
	else if (obj.value=="L"){
		
		formObj.routing_code.style.display="inline";
		formObj.routing_code.style.visibility="visible";
		formObj.drug_desc.style.display="none";
		formObj.btnDrug.style.display="none";
		clearRoutingCode();
		
		loadSpecialOrders("routing_code");
		try{
			formObj.performing_facility_id.disabled = false;
			formObj.imgRoutine.style.visibility="visible";
			formObj.imgRoutingCode.style.visibility="visible";
			formObj.imgStat.style.visibility="visible";
		}
		catch(e){}
		return false;
	}
	else if (obj.value=="H"){ //added else if condition for Bru-HIMS-CRF-093[29960] 
		loadRoutineStatDischargeBasedOnFacility();
		formObj.RoutingCode.style.display = "none";
		formObj.RoutingCode.style.visibility = "hidden";
		formObj.drug_desc.style.display = "none";
		formObj.btnDrug.style.display="none";
		formObj.drug_code.value="";
		formObj.drug_desc.value="";
		try{
			formObj.performing_facility_id.value = facility_id;
			formObj.performing_facility_id.disabled = false; // kiran
			formObj.imgRoutingCode.style.visibility="hidden";
		}
		catch(e){}
		return false;//adding end for Bru-HIMS-CRF-093[29960] 
	}
	else if (obj.value==""){
		document.getElementById('routing_code').style.display = "none";
	}
}

function loadDrugClass(obj){
	var formObj = document.frmOrderRoutingLocation;
	if(formObj == undefined)
		formObj = document.query_form;
	var element1 = document.createElement('OPTION') ;
	element1.value		=  "G" ;
	element1.text		=  getLabel("Common.general.label","Common");

	var element2 = document.createElement('OPTION') ;
	element2.value		=  "N" ;
	element2.text		=  getLabel("ePH.Narcotics.label","PH");

	var element3 = document.createElement('OPTION') ;
	element3.value		=  "C" ;
	element3.text		=  getLabel("ePH.Controlled.label","PH");
	
	if (obj=="routing_code"){
		formObj.routing_code.add(element1);
		formObj.routing_code.add(element2);
		formObj.routing_code.add(element3);
		}
}

function clearRoutingCode(){
	var formObj = document.forms[0];
	var len=formObj.routing_code.length;
	for(var i=0;i<len;i++) {
		formObj.routing_code.remove("routing_code") ;
	}
	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt1 = document.createElement("OPTION") ;
	opt1.text = tp ;
	opt1.value = "" ;
	formObj.routing_code.add(opt1);
}

function loadSpecialOrders(obj){
	var formObj = document.frmOrderRoutingLocation;
	if(formObj == undefined)
		formObj = document.query_form;
	var element1 = document.createElement('OPTION') ;
	element1.value		=  "ALLD" ;
	element1.text		=  getLabel("ePH.AllDirectOrders.label","PH");

	var element2 = document.createElement('OPTION') ;
	element2.value		=  "ALLA" ;
	element2.text		=  getLabel("ePH.AllAdmixtures.label","PH");

	var element3 = document.createElement('OPTION') ;
	element3.value		=  "CMPA" ;
	element3.text		=  getLabel("ePH.CompoundingOrder.label","PH");

	var element4 = document.createElement('OPTION') ;
	element4.value		=  "IVOD" ;
	element4.text		=  getLabel("ePH.IVOrderDirect.label","PH");

	var element5 = document.createElement('OPTION') ;
	element5.value		=  "IVOA" ;
	element5.text		=  getLabel("ePH.IVOrderAdmixture.label","PH");

	var element6 = document.createElement('OPTION') ;
	element6.value		=  "ONCD" ;
	element6.text		=  getLabel("ePH.OncologyOrderDirect.label","PH");

	var element7 = document.createElement('OPTION') ;
	element7.value		=  "ONCA" ;
	element7.text		=  getLabel("ePH.OncologyOrderAdmixture.label","PH");

	var element8 = document.createElement('OPTION') ;
	element8.value		=  "TPND" ;
	element8.text		=  getLabel("ePH.TPNStandardRegimen.label","PH");

	var element9 = document.createElement('OPTION') ;
	element9.value		=  "TPNA" ;
	element9.text		=  getLabel("ePH.TPNNONStandardRegimen.label","PH");

	if (obj=="routing_code"){
		formObj.routing_code.add(element1);
		formObj.routing_code.add(element2);
		formObj.routing_code.add(element3);
		formObj.routing_code.add(element4);
		formObj.routing_code.add(element5);
		formObj.routing_code.add(element6);
		formObj.routing_code.add(element7);
		formObj.routing_code.add(element8);
		formObj.routing_code.add(element9);
	}
}

function getRoutingCodeDesc(obj){

	if (obj=="G"){
		return getLabel("Common.general.label","Common");
	}else if (obj=="N"){
		return getLabel("ePH.Narcotic.label","PH");
	}else if (obj=="C"){
		return getLabel("ePH.Controlled.label","PH");
	}else if (obj=="D"){
		return document.frmOrderRoutingLocation.drug_desc.value;
	}
}

// on click of clear button
function ResetToDefaultValues(){

	var formObj = parent.orderrouting_bottom.frmOrderRoutingLocation;
	formObj.reset();
	formObj.routing_code.style.display="inline";
	formObj.routing_code.style.visibility="visible";
	formObj.drug_desc.style.display="none";
	formObj.btnDrug.style.display="none";
	loadRoutingLevelRelatedElements(formObj.routing_level)
}

// for duplicate check
function findDuplicate(chk_fld1,chk_fld2,max_rows){
	var chk_fld1	=	chk_fld1;
	var chk_fld2	=	chk_fld2;
	if(max_rows>=1){
	  for(var i=2;i<max_rows;i++){
		var old_text1= parent.orderrouting_middle.document.getElementById('locationDetailTable').rows[i].cells[0].innerText;
		var old_text2= parent.orderrouting_middle.document.getElementById('locationDetailTable').rows[i].cells[1].innerText;

		if(chk_fld1==old_text1 && chk_fld2==old_text2){
			alert(getMessage("DUPLICATE_NOT_ALLOWED","PH"));
			return true;
		}
	  }
	}
    return false;
}

//If Routing Level is Order Type ...Add data to the routing code
/*	val1	-	ORDER_TYPE_CODE
	val2	-	DRUG_CLASS
	val3	-	SHORT_DESC
*/
function addDataToRoutingCode(val1,val2,val3){

	var formObj = document.frmOrderRoutingLocation;
	if(formObj == undefined)
		formObj = document.query_form;
	var element1 = document.createElement('OPTION') ;
	element1.value		=  val1+":"+val2 ;
	element1.text		=  val3 ;
	formObj.routing_code.add(element1);
}

function getRoutingCodeDescForOrderType(obj){
	/*
		RC	- Routing Code
		R	- Routine
		S	- Stat
		D	- Discharge/Take Home Medication
	*/
	
	var formObj = document.frmOrderRoutingLocation;
	if (obj=="RC"){
		return formObj.routing_code.options[formObj.routing_code.selectedIndex].innerText;
	}else if (obj=="R"){
		return formObj.rtn_ord_disp_locn_code.options[formObj.rtn_ord_disp_locn_code.selectedIndex].innerText;
	}else if (obj=="S"){
		return formObj.stat_ord_disp_locn_code.options[formObj.stat_ord_disp_locn_code.selectedIndex].innerText;
	}else if (obj=="D"){
		return formObj.disch_ord_disp_locn_code.options[formObj.disch_ord_disp_locn_code.selectedIndex].innerText;
	}
}
function searchForDrug(target){
	var formObj = document.frmOrderRoutingLocation;
	if(formObj == undefined)
		formObj = document.query_form;
	if(formObj.routing_level.value=="M"){

var LANGUAGE_ID=formObj.locale.value;
//var sql="SELECT a.item_code code, a.short_desc description FROM mm_item_lang_vw a, ST_ITEM b WHERE a.item_code = b.item_code  AND b.MEDICAL_ITEM_YN = 'Y'  AND b.DRUG_ITEM_YN = 'N'  AND a.item_code LIKE UPPER(?)  AND Upper(a.short_desc) like upper(?) AND A.LANGUAGE_ID =";
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ; 
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	var parNameArray  = new Array() ;
	var parValueArray  = new Array() ;
	parNameArray[0] ="~LANGUAGE_ID`";
	parValueArray[0]=LANGUAGE_ID;
	
	
	//argumentArray[0]   =sql+ "'"+LANGUAGE_ID+"'";
	argumentArray[0]   ="";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	argumentArray[12]  = "SQL_PH_ORDERRUTIN_MEDICAL_ITEM_LOOKUP";
	argumentArray[13]  = "ePH.Common.PhRepository";
	argumentArray[14]  = parNameArray;
	argumentArray[15]  = parValueArray;
	
	retVal = CommonLookup(getLabel("Common.MedicalItem.label","Common"), argumentArray );
		if(retVal != null && retVal != "") {
		formObj.drug_desc.value = retVal[1];
		formObj.drug_code.value=retVal[0];
		formObj.drug_desc.disabled = true;
		formObj.btnDrug.disabled = true;
		loadRoutineStatDischargeBasedOnFacility();
		}

	}else{
		var dataArray = DrugSearch("D",target);
	if (dataArray != "" && dataArray != undefined){
		formObj.drug_code.value = dataArray[0];
		formObj.drug_desc.value = dataArray[1];
		formObj.drug_desc.disabled = true;
		formObj.btnDrug.disabled = true;
		loadRoutineStatDischargeBasedOnFacility();
	}	
}
}
function loadRoutineStatDischargeBasedOnFacility(){
	try{
		var formObj = parent.orderrouting_bottom.frmOrderRoutingLocation;
		var ordering_source_type = parent.orderrouting_top.frmOrderRoutingCharacteristics.ordering_source_type.value;
		var performing_facility_id = formObj.performing_facility_id.value;
		var routing_level = parent.orderrouting_top.frmOrderRoutingCharacteristics.routing_level;
	}
	catch(e){
		var formObj = document.forms[0];
		var ordering_source_type = formObj.ordering_source_type.value;
		var performing_facility_id = formObj.ordering_facility_id.options[formObj.ordering_facility_id.selectedIndex].value;

	}
	
	clearRoutineStatDischargeList();
	if (formObj.routing_code.value != "" && performing_facility_id != "" && formObj.drug_code.value =="" && ordering_source_type != ""){

		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		

		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderRoutingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&routing_code="+formObj.routing_code.value+"&facility_id="+performing_facility_id+"&routing_level="+formObj.routing_level.value+"&disp_locn_type="+ordering_source_type, false ) ;
		xmlHttp.send( xmlDoc ) ;
	
		eval(xmlHttp.responseText);

	}else if (performing_facility_id != "" && formObj.drug_code.value !="" && ordering_source_type != ""){

		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderRoutingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&routing_code="+formObj.drug_code.value+"&facility_id="+performing_facility_id+"&routing_level="+formObj.routing_level.value+"&disp_locn_type="+ordering_source_type, false ) ; 
		xmlHttp.send( xmlDoc ) ;
	

		eval(xmlHttp.responseText);

	}else if(routing_level==null){
		

		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderRoutingValidate.jsp?identity=S&bean_id=" + bean_id + "&bean_name=" + bean_name+"&routing_code=&facility_id="+performing_facility_id+"&routing_level=S"+"&ordering_source_type="+ordering_source_type, false ) ; //shyampriya
		xmlHttp.send( xmlDoc ) ;
	
		eval(xmlHttp.responseText);
	}
	else{
	
		clearRoutineStatDischargeList();
	}

}

/*function addRoutineStatDischargeList(code,desc){
	//clearRoutineStatDischargeList();
	try{
		var formObj = parent.orderrouting_bottom.frmOrderRoutingLocation;
	}
	catch(e){
		formObj = document.forms[0];
	}

	var opt1 = document.createElement("OPTION") ;
	opt1.text = desc ;
	opt1.value = code ;
	formObj.rtn_ord_disp_locn_code.add(opt1);

	var opt2 = document.createElement("OPTION") ;
	opt2.text = desc ;
	opt2.value = code ;
	formObj.stat_ord_disp_locn_code.add(opt2);

	var opt3 = document.createElement("OPTION") ;
	opt3.text = desc ;
	opt3.value = code ;
	formObj.disch_ord_disp_locn_code.add(opt3);

} */

//Lists separated based on disp_locn_category  --- 18-Jan 2010  -- Shyampriya  - IN17548

//For adding elements to routine and stat lists
function addRoutineStatList(code,desc){
	//clearRoutineStatDischargeList();
	try{
		var formObj = parent.orderrouting_bottom.frmOrderRoutingLocation;
	}
	catch(e){
		formObj = document.forms[0];
	}

	var opt1 = document.createElement("OPTION") ;
	opt1.text = desc ;
	opt1.value = code ;
	formObj.rtn_ord_disp_locn_code.add(opt1);

	var opt2 = document.createElement("OPTION") ;
	opt2.text = desc ;
	opt2.value = code ;
	formObj.stat_ord_disp_locn_code.add(opt2);

	

}

//For adding elements to discharge list
function addDischargeList(code,desc){
	//clearRoutineStatDischargeList();
	try{
		var formObj = parent.orderrouting_bottom.frmOrderRoutingLocation;
	}
	catch(e){
		formObj = document.forms[0];
	}

	var opt3 = document.createElement("OPTION") ;
	opt3.text = desc ;
	opt3.value = code ;
	formObj.disch_ord_disp_locn_code.add(opt3);

}

function clearRoutineStatDischargeList(){
	try{
		var formObj = parent.orderrouting_bottom.frmOrderRoutingLocation;
	}
	catch(e){
		var formObj = document.forms[0];
	}
	var len=formObj.rtn_ord_disp_locn_code.length;
	for(var i=0;i<len;i++) {
		formObj.rtn_ord_disp_locn_code.remove("rtn_ord_disp_locn_code") ;
		formObj.stat_ord_disp_locn_code.remove("stat_ord_disp_locn_code") ;
	

	}
	var lenD = formObj.disch_ord_disp_locn_code.length;
		for(var i=0;i<lenD;i++) {
		formObj.disch_ord_disp_locn_code.remove("disch_ord_disp_locn_code") ;
	}

	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt1 = document.createElement("OPTION") ;
	opt1.text = tp ;
	opt1.value = "" ;
	formObj.rtn_ord_disp_locn_code.add(opt1);

	var opt2 = document.createElement("OPTION") ;
	opt2.text = tp ;
	opt2.value = "" ;
	formObj.stat_ord_disp_locn_code.add(opt2);

	var opt3 = document.createElement("OPTION") ;
	opt3.text = tp ;
	opt3.value = "" ;
	formObj.disch_ord_disp_locn_code.add(opt3);

}

function checkForMandatory(){
	var formObj = document.frmOrderRoutingLocation;

	if (formObj.routing_level.value !="G" )
		if( formObj.routing_level.value !="M"){
		if (formObj.routing_code.value==""){
			alert(getMessage("ROUTING_LEVEL_CANNOT_BE_BLANK","PH" ));
			formObj.routing_code.focus();
			return false;
		}
	}else{
		if (formObj.drug_code.value==""){
			alert(getMessage("DRUG_CANT_BE_BLANK","PH" ));
			formObj.drug_desc.focus();
			return false;
		}
	}
	if (formObj.rtn_ord_disp_locn_code.value==""){
		alert(getMessage("ROUTINE_CANT_BE_BLANK","PH"));
		formObj.rtn_ord_disp_locn_code.focus();
		return false;
	}else if(formObj.stat_ord_disp_locn_code.value==""){
		alert(getMessage("STAT_CANT_BE_BLANK","PH" ));
		formObj.stat_ord_disp_locn_code.focus();
		return false;
	}else if(formObj.disch_ord_disp_locn_code.value==""){
		alert(getMessage("DISCHARGE_HOME_MED_CANT_BE_BLANK","PH" ));
		formObj.disch_ord_disp_locn_code.focus();
		return false;
	}
	else
		return true;
}
function Modify(obj, index){
	//alert("inside modify");


	var ordering_facility_desc = obj.cells[0].innerText.replace(/^\s+|\s+$/g, "");
	var ordering_facility_id = obj.cells[1].innerText.replace(/^\s+|\s+$/g, "");;
	var ordering_source_type_desc = obj.cells[2].innerText.replace(/^\s+|\s+$/g, "");;
	var ordering_source_code = obj.cells[3].innerText.replace(/^\s+|\s+$/g, "");;
	var ordering_source_code_desc = obj.cells[4].innerText.replace(/^\s+|\s+$/g, "");;

	if (obj.cells[10]==null){
	//	var	routing_level = obj.cells(8).innerText;
		routing_level = eval("document.OrderRoutingQueryResult.routingLevel_"+index).value.replace(/^\s+|\s+$/g, "");;
		
		var routing_code = "";
		var routing_code_desc = "";
	}
	else{
		routing_level = eval("document.OrderRoutingQueryResult.routingLevel_"+index).value.replace(/^\s+|\s+$/g, "");;
		/*var routing_level = trimString(obj.cells(5).innerText);
		if (routing_level=="Order Type"){
			routing_level = "O";
		}else if (routing_level=="Drug Class"){
			routing_level = "D";
		}else if (routing_level=="Drug"){
			routing_level = "G";
		}else if (routing_level=="Special Orders"){
			routing_level = "L";
		}else if (routing_level=="Medical Item"){
			routing_level = "M";
		}else if (routing_level=="Source"){
			routing_level = "S";
		}else if (routing_level=="Home Leave"){ //added for Bru-HIMS-CRF-093[29960] 
			routing_level = "H";
		}
		*/
		var routing_code = obj.cells[6].innerText.replace(/^\s+|\s+$/g, "");
		var routing_code_desc = obj.cells[7].innerText.replace(/^\s+|\s+$/g, "");
	}
	document.location.href="../../ePH/jsp/OrderRoutingCharAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&ordering_facility_desc="+ordering_facility_desc+"&ordering_facility_id="+ordering_facility_id+"&ordering_source_type_desc="+ordering_source_type_desc+"&ordering_source_code="+ordering_source_code+"&ordering_source_code_desc="+ordering_source_code_desc+"&routing_level="+routing_level+"&routing_code="+routing_code+"&routing_code_desc="+escape(routing_code_desc);
}


function deleterecord(){

//	if(orderRoutingFrame.document.frmOrderRoutingCharacteristics != undefined){
 	var url = orderRoutingFrame.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("orderroutingcharaddmodify")!=-1) ) {
	if (orderRoutingFrame.orderrouting_top == null){
		if (orderRoutingFrame.document.frmOrderRoutingCharacteristics.mode.value == MODE_MODIFY) {
		orderRoutingFrame.document.frmOrderRoutingCharacteristics.mode.value = MODE_DELETE;
	//			var confirm_val = window.confirm(getMessage("DELETE_RECORD"));
				if (confirm(orderRoutingFrame.getMessage("DELETE_RECORD","Common"))){
					eval(formApply(orderRoutingFrame.document.frmOrderRoutingCharacteristics,PH_CONTROLLER ));
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					if( result ) {
					orderRoutingFrame.document.location.href="../../eCommon/html/blank.html";
					}
				}else{
				
					orderRoutingFrame.document.frmOrderRoutingCharacteristics.mode.value = MODE_MODIFY;
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
				return false;

				}
			}
			else{
				messageFrame.location.href = "../../eCommon/jsp /MstCodeError.jsp?err_num=";
			}
	}else{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}else{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}

}
/*
function deleterecord(){
	if(orderRoutingFrame.document.frmOrderRoutingCharacteristics != undefined){
		if (orderRoutingFrame.document.frmOrderRoutingCharacteristics.mode.value == MODE_MODIFY) {
			orderRoutingFrame.document.frmOrderRoutingCharacteristics.mode.value = MODE_DELETE;
			if (confirm(orderRoutingFrame.getMessage("DELETE_RECORD"))){
				eval(formApply(orderRoutingFrame.document.frmOrderRoutingCharacteristics,PH_CONTROLLER ));
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				if( result ) {
					orderRoutingFrame.document.location.href="../../eCommon/html/blank.html";

				}
			}
		}
	}else{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}
*/

function clearLocation(){
	
	var formObj = document.frames[1].orderrouting_top.frmOrderRoutingCharacteristics;
	var len=formObj.ordering_source_code.length;
	for(var i=0;i<len;i++) {
		formObj.ordering_source_code.remove("ordering_source_code") ;
	}
	var tp ="---"+getLabel("Common.defaultSelect.label","Common")+"---"
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	formObj.ordering_source_code.add(opt);
}
function onChangeOfPerformingFacility(){


	clearRoutineStatDischargeListInModify();
	var formObj = document.frmOrderRoutingCharacteristics;
	var facility_id = formObj.performing_facility_id.value;
	var disp_locn_type = formObj.ordering_source_type.value;
	var routing_level = formObj.routing_level.value;
	var routing_code = formObj.routing_code.value;

	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderRoutingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&facility_id="+facility_id+"&disp_locn_type="+disp_locn_type+"&routing_level="+routing_level+"&routing_code="+routing_code+"&modifyMode=Yes", false ) ;
	xmlHttp.send( xmlDoc ) ;

	eval(xmlHttp.responseText);
}

/*function addRoutineStatDischargeListInModify(code,desc){
	var formObj = document.frames.frmOrderRoutingCharacteristics;
	var opt1 = document.createElement("OPTION") ;
	opt1.text = desc ;
	opt1.value = code ;
	formObj.rtn_ord_disp_locn_code.add(opt1);

	var opt2 = document.createElement("OPTION") ;
	opt2.text = desc ;
	opt2.value = code ;
	formObj.stat_ord_disp_locn_code.add(opt2);

	var opt3 = document.createElement("OPTION") ;
	opt3.text = desc ;
	opt3.value = code ;
	formObj.disch_ord_disp_locn_code.add(opt3);

}*/

function addDischargeListInModify(code,desc){
	var formObj = document.frmOrderRoutingCharacteristics;
	
	var opt3 = document.createElement("OPTION") ;
	opt3.text = desc ;
	opt3.value = code ;
	formObj.disch_ord_disp_locn_code.add(opt3);

}

function addRoutineStatListInModify(code,desc){
	var formObj = document.frmOrderRoutingCharacteristics;
	var opt1 = document.createElement("OPTION") ;

	opt1.text = desc ;
	opt1.value = code ;
	formObj.rtn_ord_disp_locn_code.add(opt1);

	var opt2 = document.createElement("OPTION") ;
	opt2.text = desc ;
	opt2.value = code ;
	formObj.stat_ord_disp_locn_code.add(opt2);

}

function clearRoutineStatDischargeListInModify(){
	
	try{
		var formObj = document.frmOrderRoutingCharacteristics;
	}
	catch(e){
		var formObj = document.forms[0];
	}
	var len=formObj.disch_ord_disp_locn_code.length;
	for(var i=0;i<len;i++) {
		formObj.rtn_ord_disp_locn_code.remove("rtn_ord_disp_locn_code") ;
		formObj.stat_ord_disp_locn_code.remove("stat_ord_disp_locn_code") ;
		formObj.disch_ord_disp_locn_code.remove("disch_ord_disp_locn_code") ;
	}
	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt1 = document.createElement("OPTION") ;
	opt1.text = tp ;
	opt1.value = "" ;
	formObj.rtn_ord_disp_locn_code.add(opt1);

	var opt2 = document.createElement("OPTION") ;
	opt2.text = tp ;
	opt2.value = "" ;
	formObj.stat_ord_disp_locn_code.add(opt2);

	var opt3 = document.createElement("OPTION") ;
	opt3.text = tp ;
	opt3.value = "" ;
	formObj.disch_ord_disp_locn_code.add(opt3);
    
}

function loadRoutineStatDischargeBasedOnRoutingLevel(routing_level,obj){
	try{
		var formObj = parent.orderrouting_bottom.frmOrderRoutingLocation;
		var performing_facility_id = formObj.performing_facility_id.value;
		var ordering_source_type =parent.orderrouting_top.frmOrderRoutingCharacteristics.ordering_source_type.value ;
	}
	catch(e){
		var formObj = document.forms[0];
		
		var performing_facility_id = formObj.ordering_facility_id.value;
		var ordering_source_type =formObj.ordering_source_type.value ;
	}

	if(routing_level.value != 'L'){
		loadRoutineStatDischargeBasedOnFacility();
	}else{
		
		//var performing_facility_id = formObj.performing_facility_id.value;
			//formObj.ordering_facility_id.options[formObj.ordering_facility_id.selectedIndex].value;
		clearRoutineStatDischargeList();
		var routing_code = obj.value;
		
		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderRoutingValidate.jsp?identity=L&bean_id=" + bean_id + "&bean_name=" + bean_name+"&routing_code="+routing_code+"&facility_id="+performing_facility_id+"&routing_level=L&disp_locn_type="+ordering_source_type, false ) ;
		xmlHttp.send( xmlDoc ) ;
	
		eval(xmlHttp.responseText);
	}
}

