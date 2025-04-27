var function_id = "PH_ORDER_ROUTING_FOR_BL_GROUP" ;
var result = false ;
var message = "" ;
var flag = "" ;
var selectDefaultFacility = "";

function create() {
	if (blorderRoutingFrame.orderroutingforbl_top != null){ 
		blorderRoutingFrame.orderroutingforbl_top.location.href="../../ePH/jsp/BLGroupOrderRoutingCharAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT ;
		blorderRoutingFrame.orderroutingforbl_middle.location.href="../../ePH/jsp/BLGroupOrderRoutingLocnDetAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT ;
		blorderRoutingFrame.orderroutingforbl_bottom.location.href="../../ePH/jsp/BLGroupOrderRoutingLocationAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT ;
		blorderRoutingFrame.orderroutingforbl_ALTDisplocation_header.location.href="../../eCommon/html/blank.html" ;
		blorderRoutingFrame.orderroutingforbl_ALTDisplocation_detail.location.href="../../eCommon/html/blank.html" ;
		blorderRoutingFrame.orderroutingforbl_Buttons.location.href="../../ePH/jsp/BLGroupOrderRoutingButtons.jsp?function_id="+function_id+"&mode="+MODE_INSERT ;	
	}
	else{
		blorderRoutingFrame.location.href="../../ePH/jsp/BLGroupOrderRoutingFrame.jsp?param=createIfFrameIsNull";
	}
}

function query(){
	blorderRoutingFrame.location.href="../../ePH/jsp/BLGroupOrderRoutingQueryCriteria.jsp?function_id="+function_id ;
}
function deleterecord(){ 
 	var url = blorderRoutingFrame.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("blgrouporderroutingqueryframe")!=-1) ) {
		if (blorderRoutingFrame.orderroutingforbl_top == null){
			if (blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.mode.value == MODE_MODIFY) {
				blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.mode.value= MODE_DELETE;
				if (confirm(blorderRoutingFrame.orderroutingforblquery_top.getMessage("DELETE_RECORD","Common"))){
					eval(formApply(blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL,PH_CONTROLLER ));
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					if( result ) {
						blorderRoutingFrame.document.location.href="../../eCommon/html/blank.html";
					}
				}
				else{
					blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.mode.value = MODE_MODIFY;
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
					return false;
				}
			}
			else{
				messageFrame.location.href = "../../eCommon/jsp /MstCodeError.jsp?err_num=";
			}
		}
		else{
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
	else{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}

function apply() {
	var url = blorderRoutingFrame.location.href;
	url = url.toLowerCase();
	var mode="";
	var formObj="";
	if (blorderRoutingFrame.orderroutingforbl_top != null){
		mode =blorderRoutingFrame.orderroutingforbl_top.document.frmOrderRoutingCharacteristicsForBL.mode.value;
	}
	if(mode=='1')
		 formObj=blorderRoutingFrame.document.frmOrderRoutingCharacteristicsForBL;
	else{
		if(blorderRoutingFrame.orderroutingforblquery_top!=undefined)
         formObj=blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL;
	}
	if(blorderRoutingFrame.document.query_form==undefined && (url.indexOf("orderroutingqueryresult")==-1)){
		if(formObj  == undefined){
			var formObj1=blorderRoutingFrame.orderroutingforbl_top.document.frmOrderRoutingCharacteristicsForBL;
			var formObj2=blorderRoutingFrame.orderroutingforbl_middle.document.frmOrderRoutingLocationDetailForBL;
			formObj2.number_of_rows.value = blorderRoutingFrame.window[1].locationDetailTable.rows.length-2;
			var manCheck=false;
			for (var i=0;i<formObj2.number_of_rows.value ;i++ ){
				var obj = eval("formObj2.select"+i);
				if (obj.checked){
					manCheck = true;
				}
			}
			if (formObj2.number_of_rows.value >0 && manCheck==true){
				var fields = new Array ( formObj1.ordering_facility_id ,formObj1.ordering_source_type,formObj1.ordering_source_code);
				var names = new Array(getLabel("Common.OrderingFacility.label","Common"), getLabel("Common.locationtype.label","Common"),getLabel("Common.Location.label","Common"));
				var formArray = new Array(formObj1,formObj2);
				if(blorderRoutingFrame.orderroutingforbl_top.checkFieldsofMst( fields, names, messageFrame)) {
					eval(formApply( formArray,PH_CONTROLLER ));
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					if( result ) {
						onSuccess();
					}
				}
			}
			else{
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("SELECT_ATLEAST_ONE_RECORD","PH");
			}
		}
		else if (blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.mode.value == MODE_MODIFY){
			if (blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.routing_level.value=="S"){
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_ROUTING_LEVEL_CANNOT_MODIFY","PH");
			}
			else{
				var fields=new Array();
				var names=new Array();
				fields[0] =  blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.rtn_ord_disp_locn_code;
				fields[1] = blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.stat_ord_disp_locn_code;
				fields[2] = blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.disch_ord_disp_locn_code;

				names[0] = getLabel("ePH.ROUTINE.label","PH");
				names[1] = getLabel("Common.Stat.label","Common");
				names[2] = getLabel("ePH.Discharge/TakeHomeMedication.label","PH")

				var billing_type= blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.billing_type.value;
				if(billing_type != 'C' ){
					fields[3] = blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.customer_group;
					fields[4] = blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.customer_id;
					names[3] = getLabel("ePH.CustomerGroup.label","PH");
					names[4] = getLabel("Common.Customer.label","Common");
					if(billing_type != 'R' ){
						fields[5] = blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.polocy_type;
						names[5] = getLabel("ePH.PolicyType.label","PH")
					}
				}

				if(blorderRoutingFrame.orderroutingforblquery_top.checkFieldsofMst( fields, names, messageFrame)){
					eval(formApply( blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL,PH_CONTROLLER ));
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					if( result ) {
						var ordering_facility_desc = blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.ordering_facility_desc.value;
						var ordering_facility_id = blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.ordering_facility_id.value;
						var ordering_source_type_desc = blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.ordering_source_type_desc.value;
						var ordering_source_code = blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.ordering_source_code.value;
						var ordering_source_code_desc = blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.ordering_source_code_desc.value;
						var routing_level = blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.routing_level.value;

						var routing_code = blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.routing_code.value;
						var routing_code_desc = blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.routing_code_desc.value;
						var billing_group_code = blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.billing_group.value;
						var customer_group = blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.customer_group.value;
						var customer_id = blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.customer_id.value;
						var polocy_type = blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.polocy_type.value;
						var rtn_ord_disp_locn_code = blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.rtn_ord_disp_locn_code.value;
						var stat_ord_disp_locn_code = blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.stat_ord_disp_locn_code.value;
						var disch_ord_disp_locn_code = blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.disch_ord_disp_locn_code.value;
							blorderRoutingFrame.document.location.href="../../ePH/jsp/BLGroupOrderRoutingCharAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&ordering_facility_desc="+ordering_facility_desc+"&ordering_facility_id="+ordering_facility_id+"&ordering_source_type_desc="+ordering_source_type_desc+"&ordering_source_code="+ordering_source_code+"&ordering_source_code_desc="+ordering_source_code_desc+"&routing_level="+routing_level+"&routing_code="+routing_code+"&routing_code_desc="+routing_code_desc+"&billing_group_code="+billing_group_code+"&bl_cust_group_id="+customer_group+"&bl_cust_id="+customer_id+"&bl_polocy_id="+polocy_type+"&rtn_ord_disp_locn_code="+rtn_ord_disp_locn_code+"&stat_ord_disp_locn_code="+stat_ord_disp_locn_code+"&disch_ord_disp_locn_code="+disch_ord_disp_locn_code;
							blorderRoutingFrame.document.location.href="../../ePH/jsp/BLGroupOrderRoutingQueryframe.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&ordering_facility_desc="+ordering_facility_desc+"&ordering_facility_id="+ordering_facility_id+"&ordering_source_type_desc="+ordering_source_type_desc+"&ordering_source_code="+ordering_source_code+"&ordering_source_code_desc="+ordering_source_code_desc+"&routing_level="+routing_level+"&routing_code="+routing_code+"&routing_code_desc="+escape(routing_code_desc)+"&bl_group_code="+billing_group_code+"&bl_cust_group_id="+customer_group+"&bl_cust_id="+customer_id+"&bl_polocy_id="+polocy_type;
					}
				}
			}
		}
	}
	else{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
 }

function onSuccess() {

	if (blorderRoutingFrame.orderroutingforbl_top != null){
		blorderRoutingFrame.orderroutingforbl_top.location.href="../../ePH/jsp/BLGroupOrderRoutingCharAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT ;
		blorderRoutingFrame.orderroutingforbl_middle.location.href="../../ePH/jsp/BLGroupOrderRoutingLocnDetAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT ;
		blorderRoutingFrame.orderroutingforbl_bottom.location.href="../../ePH/jsp/BLGroupOrderRoutingLocationAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT ;
		blorderRoutingFrame.orderroutingforbl_ALTDisplocation_header.location.href="../../ePH/jsp/BLGroupOrderRoutingALTDispLocationAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT ;
		blorderRoutingFrame.orderroutingforbl_ALTDisplocation_detail.location.href="../../ePH/jsp/BLGroupOrderRoutingALTDispLocationDetails.jsp?function_id="+function_id+"&mode="+MODE_INSERT ;
	}
	else{
		blorderRoutingFrame.location.href="../../ePH/jsp/BLGroupOrderRoutingFrame.jsp.jsp?param=createIfFrameIsNull";
	}

}
function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
function reset(){
	var url = blorderRoutingFrame.location.href;
	url = url.toLowerCase();

	if ( (url.indexOf("blgrouporderroutingquerycriteria")!=-1) ) {
		function_id = blorderRoutingFrame.document.query_form.function_id.value;
		blorderRoutingFrame.location.href="../../ePH/jsp/BLGroupOrderRoutingQueryCriteria.jsp?function_id="+function_id ;
	}
	else if ( (url.indexOf("blgrouporderroutingframe")!=-1) ) {
		create();
	}else if ( (url.indexOf("blgrouporderroutingqueryframe") != -1)){
		blorderRoutingFrame.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL.reset();
	}
}

function loadRelatedLocation(obj){
	var formObj = document.frmOrderRoutingCharacteristicsForBL;
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
		xmlStr += "ordering_source_type='"+ checkSpl(obj.value) +"' " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "BLGroupOrderRoutingValidate.jsp?bean_id=" + bean_id + "&bean_name=" +bean_name+"&ordering_source_type="+obj.value+"&facility_id="+formObj.facility_id.value+"&identity=LOADALLDISPLOCANS", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
}

function loadIntoLocation(objCode,objDesc){
	var formObj = document.frmOrderRoutingCharacteristicsForBL;
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
		xmlStr += "ordering_source_type='"+ checkSpl(obj.value) +"' " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "BLGroupOrderRoutingValidate.jsp?identity=LOADALLDISPLOCANS&bean_id=" + bean_id + "&bean_name=" +bean_name+"&ordering_source_type="+obj.value+"&facility_id="+formObj.facility_id.value+"&QryMode=yes", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
}

function onChangeOfPerformingFacility(){
	clearRoutineStatDischargeListInModify();
	var formObj = document.frmOrderRoutingCharacteristicsForBL;
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
	xmlHttp.open( "POST", "BLGroupOrderRoutingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&facility_id="+facility_id+"&disp_locn_type="+disp_locn_type+"&routing_level="+routing_level+"&routing_code="+routing_code+"&identity=LOADDISPLOCANS", false ) ;
	xmlHttp.send( xmlDoc ) ;

	eval(xmlHttp.responseText);
}

function loadRoutineStatDischargeBasedOnFacility(mode){
	try{
		var formObj = parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation;
		var ordering_source_type = parent.orderroutingforbl_top.frmOrderRoutingCharacteristicsForBL.ordering_source_type.value;
		var performing_facility_id = formObj.performing_facility_id.value;
		var routing_level = parent.orderroutingforbl_top.frmOrderRoutingCharacteristicsForBL.routing_level;
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
		xmlHttp.open( "POST", "BLGroupOrderRoutingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&routing_code="+formObj.routing_code.value+"&facility_id="+performing_facility_id+"&routing_level="+formObj.routing_level.value+"&disp_locn_type="+ordering_source_type+"&identity=LOADALLDISPLOCANS", false ) ;
		xmlHttp.send( xmlDoc ) ;	
		eval(xmlHttp.responseText);
	}
	else if (performing_facility_id != "" && formObj.drug_code.value !="" && ordering_source_type != ""){
		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "BLGroupOrderRoutingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&routing_code="+formObj.drug_code.value+"&facility_id="+performing_facility_id+"&routing_level="+formObj.routing_level.value+"&disp_locn_type="+ordering_source_type+"&identity=LOADALLDISPLOCANS", false ) ; 
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
	else if(routing_level==null){
		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "BLGroupOrderRoutingValidate.jsp?identity=S&bean_id=" + bean_id + "&bean_name=" + bean_name+"&routing_code=&facility_id="+performing_facility_id+"&routing_level=S"+"&ordering_source_type="+ordering_source_type+"&identity=LOADDISPLOCANS", false ) ;		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	}
	else{
		clearRoutineStatDischargeList();
	}
}

function clearRoutineStatDischargeList(){
	try{
		var formObj = parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation;
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

function loadCustomer(){
	var formObj=document.frmBLOrderRoutingLocation;
	if(formObj==undefined)
		var formObj=document.frmOrderRoutingCharacteristicsForBL;
	if(formObj==undefined)
		var formObj=document.query_form;
	clearCustomer();
	clearPolocyType();
	var customer_group=formObj.customer_group.value;
	var customer_group = formObj.customer_group.options[formObj.customer_group.selectedIndex].value;

	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "BLGroupOrderRoutingValidate.jsp?identity=loadCustomer&bean_id=" + bean_id + "&bean_name=" + bean_name+"&customer_group="+customer_group, false) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

function clearCustomer(){
	var formObj=document.frmBLOrderRoutingLocation;
	if(formObj==undefined)
		var formObj=document.frmOrderRoutingCharacteristicsForBL;
	if(formObj==undefined)
		var formObj=document.query_form;
	var len=formObj.customer_id.length;
	for(var i=0;i<len;i++) {
		formObj.customer_id.remove("customer_id") ;
	}
	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt1 = document.createElement("OPTION") ;
	opt1.text = tp ;
	opt1.value = "" ;
	formObj.customer_id.add(opt1);
}

function addCustomer(cust_code,cust_desc){
	var formObj = document.frmBLOrderRoutingLocation;
	if(formObj==undefined)
		var formObj=document.frmOrderRoutingCharacteristicsForBL;
	if(formObj==undefined)
		var formObj=document.query_form;
		
	var element = document.createElement('OPTION') ;
	element.value		=  (cust_code) ;
	element.text		=  decodeURIComponent(cust_desc,"UTF-8");// decodeURIComponent  Added for MMSBETA  MMS_BETA_0037[IN046175]
	formObj.customer_id.add(element);
}
function addCustomerAfterEdit(cust_code,cust_desc){//In Edit mode this method set customer id for all value
	var formObj = parent.frames[2].frmBLOrderRoutingLocation;
	if(formObj==undefined)
		var formObj=parent.document.frmOrderRoutingCharacteristicsForBL;
	
	if(formObj==undefined)
		var formObj=parent.document.query_form;
	
	var element = document.createElement('OPTION') ;
	element.value		=  (cust_code) ;
	element.text		=  decodeURIComponent(cust_desc,"UTF-8");// decodeURIComponent  Added for MMSBETA  MMS_BETA_0037[IN046175]
	formObj.customer_id.add(element);
}

function loadPolocyType(){
	var formObj=document.frmBLOrderRoutingLocation;
	if(formObj==undefined)
		var formObj=document.frmOrderRoutingCharacteristicsForBL;
	if(formObj==undefined)
		var formObj=document.query_form;
	clearPolocyType();
	var customer_group=formObj.customer_group.value;
	var customer_id=formObj.customer_id.value;
	var formObj = document.forms[0];
	var customer_group = formObj.customer_group.options[formObj.customer_group.selectedIndex].value;
	var customer_id = formObj.customer_id.options[formObj.customer_id.selectedIndex].value;
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "BLGroupOrderRoutingValidate.jsp?identity=loadPolcyType&bean_id=" + bean_id + "&bean_name=" + bean_name+"&customer_group="+customer_group+"&customer_id="+customer_id+"&facility_id="+formObj.facility_id.value, false) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

function clearPolocyType(){
	var formObj=document.frmBLOrderRoutingLocation;
	if(formObj==undefined)
		var formObj=document.frmOrderRoutingCharacteristicsForBL;
	if(formObj==undefined)
		var formObj=document.query_form;
	var len=formObj.polocy_type.length;
	for(var i=0;i<len;i++) {
		formObj.polocy_type.remove("polocy_type") ;
	}
	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt1 = document.createElement("OPTION") ;
	opt1.text = tp ;
	opt1.value = "" ;
	formObj.polocy_type.add(opt1);
}

function addPolocyType(polocy_code,polocy_desc){
	var formObj=document.frmBLOrderRoutingLocation;
	if(formObj==undefined)
		var formObj=document.frmOrderRoutingCharacteristicsForBL;
	if(formObj==undefined)
		var formObj=document.query_form;
	var element = document.createElement('OPTION') ;
	element.value		=  (polocy_code) ;
	element.text		=  (polocy_desc) ;
	formObj.polocy_type.add(element);
}

function addPolocyAfterEdit(polocy_code,polocy_desc){ //In Edit mode this method set Policy type for all value
	var formObj = parent.frames[2].frmBLOrderRoutingLocation;
	
	if(formObj==undefined)
		var formObj=parent.document.frmOrderRoutingCharacteristicsForBL;
	if(formObj==undefined)
		var formObj=parent.document.query_form;
		
	var element = document.createElement('OPTION') ;
	element.value		=  (polocy_code) ;
	element.text		=  (polocy_desc) ;
	formObj.polocy_type.add(element);
}

function loadRoutingLevelRelatedElements(routing_level, mode){
	var facility_id = "";
	var ordering_source_type="";
	if(mode!='QUERY'){
		var formObjChar = parent.orderroutingforbl_top.frmOrderRoutingCharacteristicsForBL;
		var formObj = parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation;
		if (formObjChar.ordering_source_code.value != "" && formObjChar.ordering_source_code.value =="*A" && formObj.routing_level.value=="S"){
			alert(getMessage("SOURCE_SHLD_NOT_BE_SELECTED","PH"));
			routing_level.focus();
			return false;
		} 
		 facility_id = formObjChar.facility_id.value;
		 ordering_source_type =parent.orderroutingforbl_top.frmOrderRoutingCharacteristicsForBL.ordering_source_type.value ;
	}
	else{
		var formObj = parent.blorderRoutingFrame.query_form;
		facility_id = formObj.ordering_facility_id.value;
		ordering_source_type = formObj.ordering_source_type.value
	}
	clearRoutingCode(formObj);
	clearRoutineStatDischargeList();
	formObj.drug_code.value = "";
	formObj.drug_desc.value = "";
	var routing_level_code = routing_level;
	if(mode!="UPDATE")
		routing_level_code = routing_level.value;
	if (routing_level_code=="D"){
		formObj.routing_code.style="display";
		formObj.routing_code.style.visibility="visible";
		formObj.drug_desc.style.display="none";
		formObj.btnDrug.style.display="none";
		if(formObj.name!="query_form"){
			formObj.performing_facility_id.disabled = false;
			formObj.imgRoutine.style.visibility="visible";
			formObj.imgRoutingCode.style.visibility="visible";
			formObj.imgStat.style.visibility="visible";
		}
		loadDrugClass("routing_code");
		return false;
	}
	else if (routing_level_code=="O"){
		formObj.routing_code.style="display";
		formObj.routing_code.style.visibility="visible";
		formObj.drug_desc.style.display="none";
		formObj.btnDrug.style.display="none";
        if(formObj.name!="query_form"){
			formObj.performing_facility_id.disabled = false;
			formObj.imgRoutine.style.visibility="visible";
			formObj.imgRoutingCode.style.visibility="visible";
			formObj.imgStat.style.visibility="visible";
		}

		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "BLGroupOrderRoutingValidate.jsp?identity=LOADALLDISPLOCANS&bean_id=" + bean_id + "&bean_name=" + bean_name+"&routing_level="+formObj.routing_level.value+"&facility_id="+formObj.facility_id.value+"&disp_locn_type="+ordering_source_type+"&modifyMode="+mode, false ) ;
		xmlHttp.send( xmlDoc ) ;

		eval(xmlHttp.responseText);
		return false;
	}
	else if (routing_level_code=="G"){

		formObj.routing_code.style.display="none";
		formObj.drug_desc.style="display";
		formObj.drug_desc.style.visibility="visible";
		formObj.drug_desc.disabled = false;
		formObj.btnDrug.style="display";
		formObj.btnDrug.style.visibility="visible";
		formObj.btnDrug.disabled = false;
		if(formObj.name!="query_form"){
			formObj.performing_facility_id.disabled = false;
			formObj.imgRoutine.style.visibility="visible";
			formObj.imgRoutingCode.style.visibility="visible";
			formObj.imgStat.style.visibility="visible";
		}
		return false;
	}
	else if (routing_level_code=="M"){
		formObj.routing_code.style.display="none";
		formObj.drug_desc.style="display";
		formObj.drug_desc.style.visibility="visible";
		formObj.drug_desc.disabled = false;
		formObj.btnDrug.style="display";
		formObj.btnDrug.style.visibility="visible";
		formObj.btnDrug.disabled = false;
		if(formObj.name!="query_form"){
			formObj.performing_facility_id.disabled = false;
			formObj.imgRoutine.style.visibility="visible";
			formObj.imgRoutingCode.style.visibility="visible";
			formObj.imgStat.style.visibility="visible";
		}
		return false;
	}
	else if (routing_level_code=="S"){
		loadRoutineStatDischargeBasedOnFacility();
		formObj.document.getElementById('RoutingCode').style.display = "none";
		formObj.document.getElementById('RoutingCode').style.visibility = "hidden";
		formObj.drug_desc.style.display = "none";
		formObj.btnDrug.style.display="none";
		formObj.drug_code.value="";
		formObj.drug_desc.value="";
		if(formObj.name!="query_form"){
			formObj.performing_facility_id.value = facility_id;
			formObj.performing_facility_id.disabled = false; 
			formObj.imgRoutingCode.style.visibility="hidden";
		}
		return false;
	}
	else if (routing_level_code=="L"){
		
		formObj.routing_code.style="display";
		formObj.routing_code.style.visibility="visible";
		formObj.drug_desc.style.display="none";
		formObj.btnDrug.style.display="none";
		clearRoutingCode(formObj);
		loadSpecialOrders("routing_code",mode);
		if(formObj.name!="query_form"){
			formObj.performing_facility_id.disabled = false;
			formObj.imgRoutine.style.visibility="visible";
			formObj.imgRoutingCode.style.visibility="visible";
			formObj.imgStat.style.visibility="visible";
		}
		return false;
	}
	else if (routing_level_code=="H"){  
		loadRoutineStatDischargeBasedOnFacility();
		formObj.document.getElementById('RoutingCode').style.display = "none";
		formObj.document.getElementById('RoutingCode').style.visibility = "hidden";
		formObj.drug_desc.style.display = "none";
		formObj.btnDrug.style.display="none";
		formObj.drug_code.value="";
		formObj.drug_desc.value="";
		if(formObj.name!="query_form"){
			formObj.performing_facility_id.value = facility_id;
			formObj.performing_facility_id.disabled = false; 
			formObj.imgRoutingCode.style.visibility="hidden";
		}
		return false; 
	}
	else if (routing_level_code==""){
		formObj.RoutingCode.style.display = "none";
	}
}

function loadSpecialOrders(obj,mode){
	var formObj ="";
	if( mode == "QUERY")
		formObj = document.query_form;
	else
		formObj = parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation;

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

function clearRoutingCode(formObj){
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

function loadDrugClass(obj){
	try{
	var formObj = parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation;
	}catch(e){
	var	formObj = document.query_form;
	}
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

function addDataToRoutingCode(val1,val2,val3, mode){
	if(mode=='UPDATE')
		var formObj = parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation;
	else
		formObj = document.frmBLOrderRoutingLocation;
	if(formObj == undefined)
		formObj = document.query_form;
	var element1 = document.createElement('OPTION') ;
	element1.value		=  val1+":"+val2 ;
	element1.text		=  val3 ;
	formObj.routing_code.add(element1);
}

function addRoutineStatList(code,desc){
	try{
		var formObj = parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation;
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
function addDischargeList(code,desc){
	try{
		var formObj = parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation;
	}
	catch(e){
		  formObj = document.query_form;
	}
	var opt3 = document.createElement("OPTION") ;
	opt3.text = desc ;
	opt3.value = code ;
	formObj.disch_ord_disp_locn_code.add(opt3);

}
function validateForRoutingLevel(){
	var formObj = parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation;
	var formObjChar = document.frmOrderRoutingCharacteristicsForBL;
	if (formObjChar.ordering_source_code.value != "" && formObjChar.ordering_source_code.value =="*A" && formObj.routing_level.value=="S"){
		alert(getMessage("ALL_LOC_SHOULD_NOT_BE_SELECTED","PH"));
		return false;
	}
	if(formObjChar.ordering_source_code.value =="*A"){
		formObj.rtn_alt.disabled=true;
		formObj.stat_alt.disabled=true;
		formObj.discharge_alt.disabled=true;
	}
	else{
		formObj.rtn_alt.disabled=false;
		formObj.stat_alt.disabled=false;
		formObj.discharge_alt.disabled=false;
	}
}

async function searchForDrug(target){
	var formObj = document.frmBLOrderRoutingLocation;
	if(formObj == undefined)
		formObj = document.query_form;
	if(formObj.routing_level.value=="M"){

	var LANGUAGE_ID=formObj.locale.value;
	var sql="SELECT a.item_code code, a.short_desc description FROM mm_item_lang_vw a, ST_ITEM b WHERE a.item_code = b.item_code  AND b.MEDICAL_ITEM_YN = 'Y'  AND b.DRUG_ITEM_YN = 'N'  AND a.item_code LIKE UPPER(?)  AND Upper(a.short_desc) like upper(?) AND A.LANGUAGE_ID =";
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ; 
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   =sql+ "'"+LANGUAGE_ID+"'";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2"; 
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;
	argumentArray[7] = CODE_DESC ;

	retVal =await CommonLookup(getLabel("Common.MedicalItem.label","Common"), argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
	if(retVal != null && retVal != "") {
		formObj.drug_desc.value = arr[1];
		formObj.drug_code.value=arr[0];
		formObj.drug_desc.disabled = true;
		formObj.btnDrug.disabled = true;
		loadRoutineStatDischargeBasedOnFacility();
	}

	}
	else{
		var dataArray =await DrugSearch("D",target);
		var str =unescape(dataArray);
		var arr = str.split(",");
		if (dataArray != "" && dataArray != undefined){
			formObj.drug_code.value = arr[0];
			formObj.drug_desc.value = arr[1];
			formObj.drug_desc.disabled = true;
			formObj.btnDrug.disabled = true;
			loadRoutineStatDischargeBasedOnFacility();
		}	
	}
}

function loadRoutineStatDischargeBasedOnRoutingLevel(routing_level,obj ){
	try{
		var formObj = parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation;
		var performing_facility_id = formObj.performing_facility_id.value;
		var ordering_source_type =parent.orderroutingforbl_top.frmOrderRoutingCharacteristicsForBL.ordering_source_type.value ;
	}
	catch(e){
		var formObj = document.forms[0];
		var performing_facility_id = formObj.ordering_facility_id.value;
		var ordering_source_type =formObj.ordering_source_type.value ;
	}
	if(routing_level.value != 'L'){
		loadRoutineStatDischargeBasedOnFacility();
	}
	else{
		clearRoutineStatDischargeList();
		var routing_code = obj.value;
		
		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "BLGroupOrderRoutingValidate.jsp?identity=LOADALLDISPLOCANS&bean_id=" + bean_id + "&bean_name=" + bean_name+"&routing_code="+routing_code+"&facility_id="+performing_facility_id+"&routing_level=L&disp_locn_type="+ordering_source_type, false ) ;
		xmlHttp.send( xmlDoc ) ;
	
		eval(xmlHttp.responseText);
	}
}

function AddRow(obj){
	var formObjChar = parent.orderroutingforbl_top.frmOrderRoutingCharacteristicsForBL;
	var ordering_source_type=formObjChar.ordering_source_type.value;
	var ordering_source_code=formObjChar.ordering_source_code.value;
	if(ordering_source_type=='' || ordering_source_code==''){
		alert(getMessage("PH_LOCATION_TYPE_LOCATION_SELECT","PH" )); 
		return false;
	}

	var formObjMiddle = parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL;
	//console.log(parent.window[2].window[1].window[1].document.getElementById('locationDetailTable'));
	var row_no =parent.window[1].document.getElementById('locationDetailTable').rows.length-2;
	//console.log(row_no);
	var formObjBottom=parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation;
	var mode=formObjBottom.mode.value;
	var currRowNo=formObjBottom.currRowNo.value;
	var bean_id="BLGroupOrderRoutingBean";
	var bean_name= "ePH.BLGroupOrderRoutingBean";
	var msg="";

	var routing_code="";				var routing_code_desc="";
	var performing_facility_id	="";	var performing_facility_desc="";
	var rtn_ord_disp_locn_code	="";	var rtn_ord_disp_locn_desc	="";
	var stat_ord_disp_locn_code	="";	var stat_ord_disp_locn_desc	="";
	var disch_ord_disp_locn_code="";	var disch_ord_disp_locn_desc="";
	var customer_group_id       ="";    var customer_group_desc     ="";
	var billing_group_id        ="";    var billing_group_desc      ="";
	var customer_id             ="";    var customer_desc           ="";
	var policy_type_id          ="";    var policy_type_desc        ="";  
	var disp_locn               ="";    
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
		routing_level_desc=getLabel("ePH.SpecialOrders.label","PH");
	}
	else if (routing_level_code=="M"){
		routing_level_desc=getLabel("Common.MedicalItem.label","Common");
	}
	else if (routing_level_code=="H"){ 
		routing_level_desc=getLabel("ePH.HomeLeave.label","PH");
	}
	if (routing_level_code=="S" || routing_level_code=="H"){ 
	
		if(routing_level_code=="H"){ 
            routing_code			= "*A";
			routing_code_desc		= getLabel("ePH.HomeLeave.label","PH");
		}
		else{
			routing_code			= "";
			routing_code_desc		= getLabel("Common.source.label","Common");
		}
		routing_code_desc		= getLabel("Common.source.label","Common");
		performing_facility_id	= formObjBottom.performing_facility_id.value;
		performing_facility_desc= formObjBottom.performing_facility_id.options[formObjBottom.performing_facility_id.selectedIndex].text;
		billing_group_id	= formObjBottom.billing_group.value;
		billing_group_desc= formObjBottom.billing_group.options[formObjBottom.billing_group.selectedIndex].text;
		 if(formObjBottom.billing_group.value=="" && formObjBottom.billing_group.disabled == false){
			   msg = getMessage("CAN_NOT_BE_BLANK","Common");
			   msg = msg.replace('$', getLabel("Common.BillingGroup.label","common"));
			   alert(msg);
				formObjBottom.billing_group.focus();
				return false;
		 }
		customer_group_id	= formObjBottom.customer_group.value;
		if(customer_group_id!='')
			customer_group_desc= formObjBottom.customer_group.options[formObjBottom.customer_group.selectedIndex].text;
		if(formObjBottom.customer_group.value=="" && formObjBottom.customer_group.disabled == false){
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$', getLabel("ePH.CustomerGroup.label","ePH"));
			alert(msg);
			formObjBottom.customer_group.focus();
			return false;
		 }
		customer_id	= formObjBottom.customer_id.value;
		if(customer_id!='')
			customer_desc= formObjBottom.customer_id.options[formObjBottom.customer_id.selectedIndex].text;
		if(formObjBottom.customer_id.value=="" && formObjBottom.customer_id.disabled == false){
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$', getLabel("Common.Customer.label","common"));
			alert(msg);
			formObjBottom.customer_id.focus();
			return false;
		}
		policy_type_id	= formObjBottom.polocy_type.value;
		if(policy_type_id!='')
			policy_type_desc= formObjBottom.polocy_type.options[formObjBottom.polocy_type.selectedIndex].text;
		if(formObjBottom.polocy_type.value=="" && formObjBottom.polocy_type.disabled == false){
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			msg = msg.replace('$', getLabel("ePH.PolicyType.label","ePH"));
			alert(msg);
			formObjBottom.polocy_type.focus();
			return false;
		 }
		rtn_ord_disp_locn_code	= formObjBottom.rtn_ord_disp_locn_code.value;
		if(rtn_ord_disp_locn_code != ""){
			rtn_ord_disp_locn_desc	= formObjBottom.rtn_ord_disp_locn_code.options[formObjBottom.rtn_ord_disp_locn_code.selectedIndex].text;
		}
		else{
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
		else{
			alert(getMessage("DISCHARGE_HOME_MED_CANT_BE_BLANK","PH"));
			formObjBottom.disch_ord_disp_locn_code.focus();
			return false;
		}
	}

	if (routing_level_code=="O" || routing_level_code=="D" || routing_level_code=="L" ){
		if (checkForMandatory()==true){
			routing_code			= formObjBottom.routing_code.value;
			routing_code_desc		= formObjBottom.routing_code.options[formObjBottom.routing_code.selectedIndex].text;
			performing_facility_id	= formObjBottom.performing_facility_id.value;
			performing_facility_desc= formObjBottom.performing_facility_id.options[formObjBottom.performing_facility_id.selectedIndex].text;
			billing_group_id	= formObjBottom.billing_group.value;
			billing_group_desc= formObjBottom.billing_group.options[formObjBottom.billing_group.selectedIndex].text;
			customer_group_id	= formObjBottom.customer_group.value;
			if(customer_group_id!="")
				customer_group_desc= formObjBottom.customer_group.options[formObjBottom.customer_group.selectedIndex].text;
			else
				customer_group_desc="&nbsp;";
				customer_id	= formObjBottom.customer_id.value;
			if(customer_id!="")
				customer_desc= formObjBottom.customer_id.options[formObjBottom.customer_id.selectedIndex].text;
			else
				customer_desc="&nbsp;";
				policy_type_id	= formObjBottom.polocy_type.value;
			if(policy_type_id!="")
				policy_type_desc= formObjBottom.polocy_type.options[formObjBottom.polocy_type.selectedIndex].text;
			else
				policy_type_desc="&nbsp;";
			rtn_ord_disp_locn_code	= formObjBottom.rtn_ord_disp_locn_code.value;
			rtn_ord_disp_locn_desc	= formObjBottom.rtn_ord_disp_locn_code.options[formObjBottom.rtn_ord_disp_locn_code.selectedIndex].text;
			stat_ord_disp_locn_code	= formObjBottom.stat_ord_disp_locn_code.value;
			stat_ord_disp_locn_desc	= formObjBottom.stat_ord_disp_locn_code.options[formObjBottom.stat_ord_disp_locn_code.selectedIndex].text;
			disch_ord_disp_locn_code= formObjBottom.disch_ord_disp_locn_code.value;
			if(disch_ord_disp_locn_code!="")
				disch_ord_disp_locn_desc= formObjBottom.disch_ord_disp_locn_code.options[formObjBottom.disch_ord_disp_locn_code.selectedIndex].text;
			else
				disch_ord_disp_locn_desc="&nbsp;";
		}
		else{
			return false;
		}
	}
	if (routing_level_code=="G"){
		if (checkForMandatory()==true){
			routing_code			= formObjBottom.drug_code.value;
			routing_code_desc		= formObjBottom.drug_desc.value;
			performing_facility_id	= formObjBottom.performing_facility_id.value;
			performing_facility_desc= formObjBottom.performing_facility_id.options[formObjBottom.performing_facility_id.selectedIndex].text;
			billing_group_id	= formObjBottom.billing_group.value;
			billing_group_desc= formObjBottom.billing_group.options[formObjBottom.billing_group.selectedIndex].text;
			customer_group_id	= formObjBottom.customer_group.value;
			if(customer_group_id!='')
				customer_group_desc= formObjBottom.customer_group.options[formObjBottom.customer_group.selectedIndex].text;
			customer_id	= formObjBottom.customer_id.value;
			if(customer_id!='')
				customer_desc= formObjBottom.customer_id.options[formObjBottom.customer_id.selectedIndex].text;
			policy_type_id	= formObjBottom.polocy_type.value;
			if(policy_type_id!='')
				policy_type_desc= formObjBottom.polocy_type.options[formObjBottom.polocy_type.selectedIndex].text;
			rtn_ord_disp_locn_code	= formObjBottom.rtn_ord_disp_locn_code.value;
			rtn_ord_disp_locn_desc	= formObjBottom.rtn_ord_disp_locn_code.options[formObjBottom.rtn_ord_disp_locn_code.selectedIndex].text;
			stat_ord_disp_locn_code	= formObjBottom.stat_ord_disp_locn_code.value;
			stat_ord_disp_locn_desc	= formObjBottom.stat_ord_disp_locn_code.options[formObjBottom.stat_ord_disp_locn_code.selectedIndex].text;
			disch_ord_disp_locn_code= formObjBottom.disch_ord_disp_locn_code.value;
			if(disch_ord_disp_locn_code!="")
				disch_ord_disp_locn_desc= formObjBottom.disch_ord_disp_locn_code.options[formObjBottom.disch_ord_disp_locn_code.selectedIndex].text;
			else
				disch_ord_disp_locn_desc="&nbsp;";
		}
		else{
			return false;
		}
	}
	if (routing_level_code=="M"){
		if (checkForMandatory()==true){
		
			routing_code			= formObjBottom.drug_code.value;
			routing_code_desc		= formObjBottom.drug_desc.value;
		
			performing_facility_id	= formObjBottom.performing_facility_id.value;
			performing_facility_desc= formObjBottom.performing_facility_id.option[formObjBottom.performing_facility_id.selectedIndex].text;
			billing_group_id	= formObjBottom.billing_group.value;
			billing_group_desc= formObjBottom.billing_group.options[formObjBottom.billing_group.selectedIndex].text;
			customer_group_id	= formObjBottom.customer_group.value;
			if(customer_group_id!='')
				customer_group_desc= formObjBottom.customer_group.options[formObjBottom.customer_group.selectedIndex].text;
			customer_id	= formObjBottom.customer_id.value;
			if(customer_id!='')
				customer_desc= formObjBottom.customer_id.options[formObjBottom.customer_id.selectedIndex].text;
			policy_type_id	= formObjBottom.polocy_type.value;
			if(policy_type_id!='')
				policy_type_desc= formObjBottom.polocy_type.options[formObjBottom.polocy_type.selectedIndex].text;
			rtn_ord_disp_locn_code	= formObjBottom.rtn_ord_disp_locn_code.value;
			rtn_ord_disp_locn_desc	= formObjBottom.rtn_ord_disp_locn_code.options[formObjBottom.rtn_ord_disp_locn_code.selectedIndex].text;
			stat_ord_disp_locn_code	= formObjBottom.stat_ord_disp_locn_code.value;
			stat_ord_disp_locn_desc	= formObjBottom.stat_ord_disp_locn_code.options[formObjBottom.stat_ord_disp_locn_code.selectedIndex].text;
			disch_ord_disp_locn_code= formObjBottom.disch_ord_disp_locn_code.value;
			if(disch_ord_disp_locn_code!="")
				disch_ord_disp_locn_desc= formObjBottom.disch_ord_disp_locn_code.options[formObjBottom.disch_ord_disp_locn_code.selectedIndex].text;
			else
				disch_ord_disp_locn_desc="&nbsp;";
		}
		else{
			return false;
		}
	}
	if(mode=="UPDATE"){
		var chk_fld1	=	routing_level_desc;
	    var chk_fld2	=	routing_code_desc;
		var max_rows    =   formObjMiddle.document.getElementById('locationDetailTable').rows.length;
		 if(max_rows>=1){
			//for(var i=2;i<max_rows;i++){
				var tempRow=(parseInt(currRowNo)+parseInt(2))
				if (findDuplicate(routing_level_code,routing_code,performing_facility_id, billing_group_id, (parseInt(formObjMiddle.document.getElementById('locationDetailTable').rows.length)-parseInt(2)), currRowNo,customer_group_id,customer_id,policy_type_id)){
					return false;
				}
				else{
					parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL.document.getElementById('locationDetailTable').rows[tempRow].cells[0].innerHTML="<A HREF='javascript:loadDataForAmend(this,\""+(currRowNo)+"\",\""+routing_level_code+"\",\""+routing_code+"\",\""+performing_facility_id+"\",\""+ rtn_ord_disp_locn_code+"\",\""+stat_ord_disp_locn_code+"\",\""+disch_ord_disp_locn_code+"\",\""+billing_group_id+"\",\""+customer_group_id+"\",\""+customer_id+"\",\""+policy_type_id+"\",\""+routing_code_desc+"\")'>"+routing_level_desc+"</A><input type='hidden' name='routing_level"+currRowNo+"' id='routing_level"+currRowNo+"' value='"+routing_level_code+"'>";
					parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL.document.getElementById('locationDetailTable').rows[tempRow].cells[1].innerHTML=routing_code_desc+"<input type='hidden' name='routing_code"+currRowNo+"' id='routing_code"+currRowNo+"'value='"+routing_code+"'>";
					parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL.document.getElementById('locationDetailTable').rows[tempRow].cells[2].innerHTML=performing_facility_desc+"<input type='hidden' name='performing_facility_id"+currRowNo+"' id='performing_facility_id"+currRowNo+"'value='"+performing_facility_id+"'>";
					parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL.document.getElementById('locationDetailTable').rows[tempRow].cells[3].innerHTML=rtn_ord_disp_locn_desc+"<input type='hidden' name='rtn_ord_disp_locn_code"+currRowNo+"' id='rtn_ord_disp_locn_code"+currRowNo+"'value='"+rtn_ord_disp_locn_code+"'>";
					parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL.document.getElementById('locationDetailTable').rows[tempRow].cells[4].innerHTML=stat_ord_disp_locn_desc+"<input type='hidden' name='stat_ord_disp_locn_code"+currRowNo+"' id='stat_ord_disp_locn_code"+currRowNo+"'value='"+stat_ord_disp_locn_code+"'>";
					parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL.document.getElementById('locationDetailTable').rows[tempRow].cells[5].innerHTML=disch_ord_disp_locn_desc+"<input type='hidden' name='disch_ord_disp_locn_code"+currRowNo+"' id='disch_ord_disp_locn_code"+currRowNo+"'value='"+disch_ord_disp_locn_code+"'>";
					parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL.document.getElementById('locationDetailTable').rows[tempRow].cells[6].innerHTML=billing_group_desc+"<input type='hidden' name='billing_group"+currRowNo+"' id='billing_group"+currRowNo+"'value='"+billing_group_id+"'>";
					if(customer_group_desc!="&nbsp")
						parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL.document.getElementById('locationDetailTable').rows[tempRow].cells[7].innerHTML=customer_group_desc+"<input type='hidden' name='customer_group"+currRowNo+"' id='customer_group"+currRowNo+"'value='"+customer_group_id+"'>";
					if(customer_desc!="&nbsp")                                            
						parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL.document.getElementById('locationDetailTable').rows[tempRow].cells[8].innerHTML=customer_desc+"<input type='hidden' name='customer_id"+currRowNo+"' id='customer_id"+currRowNo+"'value='"+customer_id+"'>";
					if(policy_type_desc!="&nbsp")                                          
						parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL.document.getElementById('locationDetailTable').rows[tempRow].cells[9].innerHTML=policy_type_desc+"<input type='hidden' name='polocy_type"+currRowNo+"' id='polocy_type"+currRowNo+"'value='"+policy_type_id+"'>";
				   //parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL.all.locationDetailTable.rows[i].cells[10].innerText
					resetDefault(formObjBottom,formObjChar);
					formObjBottom.mode.value="1";
					if(formObjBottom.customer_id.isDisabled==false){//After values setting in grid in Edit mode,customer id values wil be removed and clear set as "select"
						var len=formObjBottom.customer_id.length;
						for(var i=0;i<len;i++) {
							formObjBottom.customer_id.remove("customer_id") ;
						}
						var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
						var opt1 = document.createElement("OPTION") ;
						opt1.text = tp ;
						opt1.value = "" ;
						formObjBottom.customer_id.add(opt1);
					}
					if(formObjBottom.polocy_type.isDisabled==false){//After values setting in grid in Edit mode,policy id values wil be removed and clear set as "select"
						var len=formObjBottom.polocy_type.length;
						for(var i=0;i<len;i++) {
							formObjBottom.polocy_type.remove("polocy_type") ;
						}
						var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
						var opt1 = document.createElement("OPTION") ;
						opt1.text = tp ;
						opt1.value = "" ;
						formObjBottom.polocy_type.add(opt1);
					}
					return false;
				}
		//	}
		}
	}
	if (findDuplicate(routing_level_code,routing_code,performing_facility_id, billing_group_id, (parent.window[1].document.getElementById('locationDetailTable').rows.length-2), currRowNo,customer_group_id,customer_id,policy_type_id)){
		return false;
	}

	curr_row	=	parent.window[1].document.getElementById('locationDetailTable').insertRow();
	var classval;

	if(row_no % 2 == 0 )
		classval	=	"QRYEVEN";
	else
		classval	=	"QRYODD";
	for(i=0; i<11; i++)	{
		cell	=	curr_row.insertCell();
		if (i==0){
			curr_row.cells[0].className	= classval;
			curr_row.cells[0].innerHTML = "<A HREF='javascript:loadDataForAmend(this,\""+(row_no)+"\",\""+routing_level_code+"\",\""+routing_code+"\",\""+performing_facility_id+"\",\""+ rtn_ord_disp_locn_code+"\",\""+stat_ord_disp_locn_code+"\",\""+disch_ord_disp_locn_code+"\",\""+billing_group_id+"\",\""+customer_group_id+"\",\""+customer_id+"\",\""+policy_type_id+"\",\""+routing_code_desc+"\")'>"+routing_level_desc+"</A><input type='hidden' name=\"routing_level"+row_no+"\" value='"+routing_level_code+"'>";
		}
		else if (i==1){
			curr_row.cells[1].className	= classval;
			curr_row.cells[1].innerHTML = routing_code_desc+"<input type='hidden' name='routing_code"+row_no+"' id='routing_code"+row_no+"' value='"+routing_code+"'>";
		}
		else if (i==2){
			curr_row.cells[2].className	= classval;
			curr_row.cells[2].innerHTML = performing_facility_desc+"<input type='hidden' name='performing_facility_id"+row_no+"' id='performing_facility_id"+row_no+"' value='"+performing_facility_id+"'>";
		}
		else if (i==3){
			curr_row.cells[3].className	= classval;
			curr_row.cells[3].innerHTML = rtn_ord_disp_locn_desc+"<input type='hidden' name='rtn_ord_disp_locn_code"+row_no+"' id='rtn_ord_disp_locn_code"+row_no+"' value='"+rtn_ord_disp_locn_code+"'>";
		}
		else if (i==4){
			curr_row.cells[4].className	= classval;
			curr_row.cells[4].innerHTML = stat_ord_disp_locn_desc+"<input type='hidden' name='stat_ord_disp_locn_code"+row_no+"' id='stat_ord_disp_locn_code"+row_no+"' value='"+stat_ord_disp_locn_code+"'>";
		}
		else if (i==5){
			curr_row.cells[5].className	= classval;
			curr_row.cells[5].innerHTML = disch_ord_disp_locn_desc+"<input type='hidden' name='disch_ord_disp_locn_code"+row_no+"' id='disch_ord_disp_locn_code"+row_no+"' value='"+disch_ord_disp_locn_code+"'>";
		}
		else if (i==6){ 
			curr_row.cells[6].className	= classval;
			curr_row.cells[6].innerHTML = billing_group_desc+"<input type='hidden' name='billing_group"+row_no+"' id='billing_group"+row_no+"' value='"+billing_group_id+"'>";
		}
		else if (i==7){ 
			curr_row.cells[7].className	= classval;
			curr_row.cells[7].innerHTML = customer_group_desc+"&nbsp"+"<input type='hidden' name='customer_group"+row_no+"' id='customer_group"+row_no+"' value='"+customer_group_id+"'>";
		}
		else if (i==8){ 
			curr_row.cells[8].className	= classval;
			curr_row.cells[8].innerHTML = customer_desc+"&nbsp"+"<input type='hidden' name='customer_id"+row_no+"' id='customer_id"+row_no+"' value='"+customer_id+"'>";
		}
		else if (i==9){ 
			curr_row.cells[9].className	= classval;
			curr_row.cells[9].innerHTML = policy_type_desc+"&nbsp"+"<input type='hidden' name='polocy_type"+row_no+"' id='polocy_type"+row_no+"' value='"+policy_type_id+"'>";
		}
		else if (i==10){ 
			curr_row.cells[10].className	= classval;
			curr_row.cells[10].innerHTML = "<input type='checkbox' name='select"+row_no+"' id='select"+row_no+"' checked value='Y'>";
		}
	}
	resetDefault(formObjBottom,formObjChar);
	
	if(formObjBottom.customer_id.isDisabled==false && mode!="UPDATE"){//After add button clicked customer id values will be removed
		var len=formObjBottom.customer_id.length;
		for(var i=0;i<len;i++) {
			formObjBottom.customer_id.remove("customer_id") ;
		}
		var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
		var opt1 = document.createElement("OPTION") ;
		opt1.text = tp ;
		opt1.value = "" ;
		formObjBottom.customer_id.add(opt1);
	}
	if(formObjBottom.polocy_type.isDisabled==false && mode!="UPDATE"){//After add button clicked policy id values will be removed
		var len=formObjBottom.polocy_type.length;
		for(var i=0;i<len;i++) {
			formObjBottom.polocy_type.remove("polocy_type") ;
		}
		var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
		var opt1 = document.createElement("OPTION") ;
		opt1.text = tp ;
		opt1.value = "" ;
		formObjBottom.polocy_type.add(opt1);
	}
}

function ResetToDefaultValues(){
	var formObj = parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation;
	formObj.reset();
	formObj.routing_level.disabled=false;
	formObj.routing_code.style.display="inline";
	formObj.routing_code.style.visibility="visible";
	formObj.drug_desc.style.display="none";
	formObj.btnDrug.style.display="none";
	loadRoutingLevelRelatedElements(formObj.routing_level)
	parent.orderroutingforbl_ALTDisplocation_header.location.href="../../eCommon/html/blank.html";
	parent.orderroutingforbl_ALTDisplocation_detail.location.href="../../eCommon/html/blank.html";
	
	if(formObj.customer_id.isDisabled==false){
		var len=formObj.customer_id.length;
		for(var i=0;i<len;i++) {
			formObj.customer_id.remove("customer_id") ;
		}
		var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
		var opt1 = document.createElement("OPTION") ;
		opt1.text = tp ;
		opt1.value = "" ;
		formObj.customer_id.add(opt1);
	}
	if(formObj.polocy_type.isDisabled==false){
		var len=formObj.polocy_type.length;
		for(var i=0;i<len;i++) {
			formObj.polocy_type.remove("polocy_type") ;
		}
		var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
		var opt1 = document.createElement("OPTION") ;
		opt1.text = tp ;
		opt1.value = "" ;
		formObj.polocy_type.add(opt1);
	}
}
	
function findDuplicate(routing_level_code,routing_code,performing_facility_id, billing_group_id,max_rows, currRowNo,customer_group_id,customer_id,policy_type_id){
	if(max_rows>=1){
		for(var i=0;i<max_rows;i++){// added max_rows instead of max_rows-1 for CRF-PH- MMS-QH-CRF-0048[41151]
			if(i!=currRowNo  || currRowNo==""){
				old_routing_level_code=eval("parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL.routing_level"+i).value;
				old_routing_code=eval("parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL.routing_code"+i).value;
				old_performing_facility_id=eval("parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL.performing_facility_id"+i).value;
				old_billing_group_id=eval("parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL.billing_group"+i).value;
				old_customer_group_id=eval("parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL.customer_group"+i).value;
				old_customer_id=eval("parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL.customer_id"+i).value;
				old_polocy_type_id=eval("parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL.polocy_type"+i).value;
				if(routing_level_code==old_routing_level_code && routing_code==old_routing_code && performing_facility_id==old_performing_facility_id && billing_group_id==old_billing_group_id && customer_group_id==old_customer_group_id && customer_id==old_customer_id && policy_type_id==old_polocy_type_id){
				  // parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL.all.locationDetailTable.rows[i].cells[0].innerText=chk_fld1;
					alert(getMessage("DUPLICATE_NOT_ALLOWED","PH"));
					return true;
				}
			}
		}
	}
	return false;
 }

function checkForMandatory(){
	var formObj = parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation;
	var msg="";

	if (formObj.routing_level.value !="G" )
		if( formObj.routing_level.value !="M"){
		if (formObj.routing_code.value==""){
			alert(getMessage("ROUTING_LEVEL_CANNOT_BE_BLANK","PH" ));
			formObj.routing_code.focus();
			return false;
		}
	}
	else{
		if (formObj.drug_code.value==""){
			alert(getMessage("DRUG_CANT_BE_BLANK","PH" ));
			formObj.drug_desc.focus();
			return false;
		}
	}
	if(formObj.billing_group.value=="" && formObj.billing_group.disabled == false){
		 msg = getMessage("CAN_NOT_BE_BLANK","Common");
		 msg = msg.replace('$', getLabel("Common.BillingGroup.label","common"));
		 alert(msg);
		 formObj.billing_group.focus();
		 return false;
	}
	else if(formObj.customer_group.value=="" && formObj.customer_group.disabled == false){
		msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace('$', getLabel("ePH.CustomerGroup.label","ePH"));
		alert(msg);
		formObj.customer_group.focus();
		return false;
	}
	else if(formObj.customer_id.value=="" && formObj.customer_id.disabled == false){
	    msg = getMessage("CAN_NOT_BE_BLANK","Common");
	    msg = msg.replace('$', getLabel("Common.Customer.label","common"));
	    alert(msg);
		formObj.customer_id.focus();
		return false;
	}
	else if(formObj.polocy_type.value=="" && formObj.polocy_type.disabled == false){
	    msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace('$', getLabel("ePH.PolicyType.label","ePH"));
		alert(msg);
	    formObj.polocy_type.focus();
		return false;
	}
	else if (formObj.rtn_ord_disp_locn_code.value==""){
		alert(getMessage("ROUTINE_CANT_BE_BLANK","PH"));
		formObj.rtn_ord_disp_locn_code.focus();
		return false;
	}
	else if(formObj.stat_ord_disp_locn_code.value==""){
		alert(getMessage("STAT_CANT_BE_BLANK","PH" ));
		formObj.stat_ord_disp_locn_code.focus();
		return false;
	}
	else if(formObj.disch_ord_disp_locn_code.value==""){
		alert(getMessage("DISCHARGE_HOME_MED_CANT_BE_BLANK","PH" ));
		formObj.disch_ord_disp_locn_code.focus();
		return false;
	}
	else
		return true;
}

function Modify(obj, index){
	
	// Added by marwan for EDGE Work to resolve the issue of the Dispense Location not showing for nursing units
	// the .replace(/^[\s\n]+|[\s\n]+$/g, '') is a regex that removes trialing and leading spaces and new lines
	
	var ordering_facility_desc = obj.cells[0].innerText.replace(/^[\s\n]+|[\s\n]+$/g, '');
	var ordering_facility_id = obj.cells[1].innerText.trim().replace(/^[\s\n]+|[\s\n]+$/g, '');
	var ordering_source_type_desc = obj.cells[2].innerText.replace(/^[\s\n]+|[\s\n]+$/g, '');
	//var ordering_source_code = obj.cells[3].innerText;
	var ordering_source_code_desc = obj.cells[4].innerText.replace(/^[\s\n]+|[\s\n]+$/g, '');
	var bl_group_code="",bl_cust_group_id="",bl_cust_id="",bl_polocy_id="";

	var ordering_source_code = eval("document.OrderRoutingQueryResult.ordering_source_code_"+index).value.replace(/^[\s\n]+|[\s\n]+$/g, '');
	if (obj.cells[13]==null){
		routing_level = eval("document.OrderRoutingQueryResult.routingLevel_"+index).value.replace(/^[\s\n]+|[\s\n]+$/g, '');
		bl_group_code = eval("document.OrderRoutingQueryResult.bl_group_id_"+index).value.replace(/^[\s\n]+|[\s\n]+$/g, '');
		bl_cust_group_id = eval("document.OrderRoutingQueryResult.bl_cust_group_id_"+index).value.replace(/^[\s\n]+|[\s\n]+$/g, '');
		bl_cust_id = eval("document.OrderRoutingQueryResult.bl_cust_id_"+index).value.replace(/^[\s\n]+|[\s\n]+$/g, '');
		bl_polocy_id = eval("document.OrderRoutingQueryResult.bl_polocy_id_"+index).value.replace(/^[\s\n]+|[\s\n]+$/g, '');
		
		var routing_code = "";
		var routing_code_desc = "";
	}
	else{
		routing_level = eval("document.OrderRoutingQueryResult.routingLevel_"+index).value.replace(/^[\s\n]+|[\s\n]+$/g, '');
		bl_group_code = eval("document.OrderRoutingQueryResult.bl_group_id_"+index).value.replace(/^[\s\n]+|[\s\n]+$/g, '');
		bl_cust_group_id = eval("document.OrderRoutingQueryResult.bl_cust_group_id_"+index).value.replace(/^[\s\n]+|[\s\n]+$/g, '')
		bl_cust_id = eval("document.OrderRoutingQueryResult.bl_cust_id_"+index).value.replace(/^[\s\n]+|[\s\n]+$/g, '');
		bl_polocy_id = eval("document.OrderRoutingQueryResult.bl_polocy_id_"+index).value.replace(/^[\s\n]+|[\s\n]+$/g, '');
		var routing_code = obj.cells[6].innerText.trim().replace(/^[\s\n]+|[\s\n]+$/g, '');
		var routing_code_desc = obj.cells[7].innerText.replace(/^[\s\n]+|[\s\n]+$/g, '');
	}
	document.location.href="../../ePH/jsp/BLGroupOrderRoutingQueryframe.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&ordering_facility_desc="+ordering_facility_desc+"&ordering_facility_id="+ordering_facility_id+"&ordering_source_type_desc="+ordering_source_type_desc+"&ordering_source_code="+ordering_source_code+"&ordering_source_code_desc="+ordering_source_code_desc+"&routing_level="+routing_level+"&routing_code="+routing_code+"&routing_code_desc="+routing_code_desc+"&bl_group_code="+bl_group_code+"&bl_cust_group_id="+bl_cust_group_id+"&bl_cust_id="+bl_cust_id+"&bl_polocy_id="+bl_polocy_id;
}

function AltDispLocn(callFrom){
	var formObj = document.frmBLOrderRoutingLocation;
	var mode=parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation.mode.value;
	var ordering_source_type=parent.orderroutingforbl_top.frmOrderRoutingCharacteristicsForBL.ordering_source_type.value;
	var ordering_source_code=parent.orderroutingforbl_top.frmOrderRoutingCharacteristicsForBL.ordering_source_code.value;
	var ordering_facility_id=parent.orderroutingforbl_top.frmOrderRoutingCharacteristicsForBL.ordering_facility_desc.value;
	var performing_facility=formObj.performing_facility_id.value;
	if(ordering_source_type=='' || ordering_source_code==''){
		alert(getMessage("PH_LOCATION_TYPE_LOCATION_SELECT","PH" )); 
		return false;
	}
	var disp_loc_code ="";
	var disp_loc_desc ="";
	var label;
	if(callFrom=='R'){
		disp_loc_code = formObj.rtn_ord_disp_locn_code.value;
		disp_loc_desc= formObj.rtn_ord_disp_locn_code.options[formObj.rtn_ord_disp_locn_code.selectedIndex].text;
		label =" "+getLabel("ePH.RoutineOrders.label","PH") ;
		clearAltDispDtl("R");//clear after the alternate button click
	}
	else if(callFrom=='S'){
		disp_loc_code = formObj.stat_ord_disp_locn_code.value;
		disp_loc_desc= formObj.stat_ord_disp_locn_code.options[formObj.stat_ord_disp_locn_code.selectedIndex].text;
		label =" "+getLabel("ePH.StatOrder.label","PH") ;
		clearAltDispDtl("S");////clear after the alternate button click
	}
	else if(callFrom=='D'){
		disp_loc_code = formObj.disch_ord_disp_locn_code.value;
		disp_loc_desc= formObj.disch_ord_disp_locn_code.options[formObj.disch_ord_disp_locn_code.selectedIndex].text;
		label =" "+getLabel("ePH.Discharge/TakeHomeMedicationOrders.label","PH") ;
		clearAltDispDtl("D");//clear after the alternate button click
	}
	if(disp_loc_code ==""){
		alert(getMessage("PH_SELECT_DISPLOCN","PH" )+label); 
		return false;
	}
	parent.orderroutingforbl_ALTDisplocation_header.location.href="../../ePH/jsp/BLGroupOrderRoutingALTDispLocationAddModify.jsp?mode="+mode+"&disp_loc_code="+disp_loc_code+"&callFrom="+callFrom+"&ORD_SRC_TYPE="+ordering_source_type+"&order_fcy="+ordering_facility_id+"&perform_fcy="+performing_facility+"&disp_loc_desc="+encodeURIComponent(disp_loc_desc)+"&ordering_source_code="+ordering_source_code;
}
function LoadCustomerAfterUpdate(cust_group_code,formObj){
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "BLGroupOrderRoutingValidate.jsp?identity=loadCustomerAfterUpdate&bean_id=" + bean_id + "&bean_name=" + bean_name+"&customer_group="+cust_group_code, false) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

function LoadPolicyAfterUpdate(cust_group_code,cust_code,formObj,performing_facility_id){
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "BLGroupOrderRoutingValidate.jsp?identity=loadPolicyAfterUpdate&bean_id=" + bean_id + "&bean_name=" + bean_name+"&customer_group="+cust_group_code+"&customer_id="+cust_code+"&facility_id="+performing_facility_id, false) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}
function LoadRoutineOrderAfterUpdate(formObj,routing_level_code,routing_code,performing_facility_id,rtn_ord_disp_locn)
{
		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "BLGroupOrderRoutingValidate.jsp?identity=LOADALLDISPLOCANS_AFTER_UPDATE&bean_id=" +bean_id+ "&bean_name=" +bean_name+"&facility_id="+performing_facility_id+ "&disp_locn_type="+rtn_ord_disp_locn+"&routing_code="+routing_code+ "&routing_level="+routing_level_code ,false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	
}

function loadDataForAmend(obj,curr_row1,routing_level_code,routing_code,performing_facility_id,rtn_ord_disp_locn,strt_ord_disp_locn,dis_ord_disp_locn,billing_group_code,cust_group_code,cust_code,polocy_type_code,routing_code_desc){
	var mode="UPDATE";
	var frmObj=obj.name;
	var formObj=parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation;
	var custlen = formObj.customer_id.length;
	var policylen = formObj.polocy_type.length;
	for(var i=0;i<custlen;i++) {//remove all the values in customer_id and Policy_id while update
		formObj.customer_id.remove("customer_id") ;
	}
	for(var i=0;i<policylen;i++) {
		formObj.polocy_type.remove("polocy_type") ;
	}
	                           //Set select for customer_id and Policy_id
	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt1 = document.createElement("OPTION") ;
	opt1.text = tp ;
	opt1.value = "" ;
	formObj.customer_id.add(opt1);
	var opt2 = document.createElement("OPTION") ;
	opt2.text = tp ;
	opt2.value = "" ;
	formObj.polocy_type.add(opt2);
	
	///below two method are load values of customer_id and Policy_id  when updating
	LoadCustomerAfterUpdate(cust_group_code,formObj);
	LoadPolicyAfterUpdate(cust_group_code,cust_code,formObj,performing_facility_id);
	
	
	var formObjMiddle = parent.orderroutingforbl_middle.frmOrderRoutingLocationDetailForBL;
	var row_no = parent.window[1].document.getElementById('locationDetailTable').rows.length-2;
	var newrow=parseInt(curr_row1)+parseInt(2);
	var formObjBottom=parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation;
	var formObjChar = parent.orderroutingforbl_top.frmOrderRoutingCharacteristicsForBL;
	for (var i=1;i<=row_no;i++ ){
		curr_row	=	parent.window[1].document.getElementById('locationDetailTable').rows[i+1];
		formObjBottom.mode.value=mode;
		formObjBottom.currRowNo.value=curr_row1;
	}
	loadRoutingLevelRelatedElements(routing_level_code, mode);
	if(routing_level_code=="G" || routing_level_code=="M"){
		formObjBottom.drug_code.value = routing_code;
		formObjBottom.drug_desc.value = routing_code_desc;
		formObjBottom.drug_desc.disabled = true;
		formObjBottom.btnDrug.disabled = true;
	}
	loadRoutineStatDischargeBasedOnRoutingLevel(routing_level_code,routing_code)
//change the facitily id when Edit mode and then click another record in grid it will be removed the stat order or routine order
	LoadRoutineOrderAfterUpdate(formObj,routing_level_code,routing_code,performing_facility_id,rtn_ord_disp_locn);
	
	formObjBottom.routing_level.disabled=true;
	formObjBottom.routing_level.value=routing_level_code;
	formObjBottom.routing_code.value=routing_code;
	formObjBottom.performing_facility_id.value=performing_facility_id;
	formObjBottom.billing_group.value=billing_group_code;
	if(cust_group_code==null || cust_group_code=="")
		formObjBottom.customer_group.disabled=true;
	else
		formObjBottom.customer_group.disabled=false;
	if(cust_code==null || cust_code=="")
		formObjBottom.customer_id.disabled=true;
	else
		formObjBottom.customer_id.disabled=false;
	if(polocy_type_code==null || polocy_type_code=="")
		formObjBottom.polocy_type.disabled=true;
	else
		formObjBottom.polocy_type.disabled=false;
	formObjBottom.customer_group.value=cust_group_code;
	formObjBottom.customer_id.value=cust_code;
	formObjBottom.polocy_type.value=polocy_type_code;
	formObjBottom.rtn_ord_disp_locn_code.value=rtn_ord_disp_locn;
	formObjBottom.stat_ord_disp_locn_code.value=strt_ord_disp_locn;
	formObjBottom.disch_ord_disp_locn_code.value=dis_ord_disp_locn;
	formObjBottom.claraltdisp.value="Y";
}

function  appedzero(obj){
	if(obj.value != null && obj.value != ""){
		var from_val	=	obj.value;
		var frm_hrs		=	new Array();
		if(from_val.indexOf(":") != -1){
			frm_hrs=from_val.split(":");
			var strHr;
			var strMi;
			strHr = frm_hrs[0];
			strMi = frm_hrs[1];
			if(strHr.length==1) { 
				strHr	= "0"+ strHr;
			}
			else if(strHr.length==0){
				strHr = "00"; 
			}
			else if(strHr.length>2){
				strHr = "00"; 
			}
			if(strMi.length==1) { 
				strMi	= "0"+ strMi; 
			}
			else if(strMi.length==0){
				strMi = "00"; 
			}
			else if(strMi.length>2){
				strMi = "00";
			}
			obj.value=strHr+":"+strMi;
		}
		else{
			if(from_val.length == 1){
				obj.value= "0"+from_val+":"+"00";
			}
			else if (from_val.length == 2){
				obj.value= from_val+":"+"00";
			}
		}
	}
}

function validtime(obj,obj1){
	var strHr;
	var strMi;
	var timefieldfrom = obj.value;
	var strTimeArray = new Array();
		
	strTimeArray = timefieldfrom.split(":");
	strHr = strTimeArray[0];
	strMi = strTimeArray[1];
	var timefieldTo = obj1.value;
	var strTimeArray1 = new Array();
	strTimeArray1 = timefieldTo.split(":");
	strHr1 = strTimeArray1[0];
	strMi1 = strTimeArray1[1];
	//Create date object and set the time to that
    var startTimeObject = new Date();
	startTimeObject.setHours(strHr, strMi);

	 //Create date object and set the time to that
	var endTimeObject = new Date(startTimeObject);
	endTimeObject.setHours(strHr1, strMi1);
	/*if((obj.value!=""&&obj1.value!="")){
		if(startTimeObject>endTimeObject){
			alert(getMessage("FROM_TIME_GREATER_THAN_TO_TIME","PH"));
			clearData1(obj);
			return false;
		}
	}*/
	if(strHr>=24|| strMi>=60){
		alert(getMessage("ALT_TIMING_INVALID","PH"));
	    clearData1(obj);
		return false;
	}
	else if((obj.value!=""&&obj1.value!="")&&(obj.value==obj1.value)){
        alert(getMessage("FROM_TIME_TO_TIME_NOT_SAME","PH"));
		clearData1(obj);
		return false;
	}
	else{
		return true;
	}
}

function saveAltDispLocnDtls(disp_loc_code,callFrom, mode ){ 
	var formobj="";
	var formObjBottom="";
	var formobjAltHeader="";
	if(mode=='1' || mode=="UPDATE" ){
		 formobj=parent.orderroutingforbl_ALTDisplocation_detail.AltDisplocnDeatil;
	     formObjBottom=parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation;
		 formobjAltHeader=parent.orderroutingforbl_ALTDisplocation_header.AltDisplocnHeader;
	}
	if (mode=='2' ){
		formobj=parent.orderroutingforblqueryALT_bottom.AltDisplocnDeatil;
		formObjBottom=parent.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL;
		formobjAltHeader=parent.orderroutingforblquery_bottom.AltDisplocnHeader;
	}
	if(formobj!=undefined){
		var count=formobj.count.value;
		var cnt="";
		var tmplDtlString= "";	
		var flag="I";
		for(cal=1;cal<count;cal++){
			if(eval("formobj.select_"+cal).value=="E" || eval("formobj.flag_"+cal).value=="Y"){
				cnt=cal;
				alt_disp_code=eval("formobj.code_"+cnt).value;
				frmtime=eval("formobj.frmtime_"+cnt).value;
				totime=eval("formobj.totime_"+cnt).value;
				if(frmtime=="")
				frmtime=" ";
			    if (totime=="")
				totime=" ";
				eff_sta=eval("formobj.enable_"+cnt).value;
				repeat=eval("formobj.repeat_"+cnt).value;
				tmplDtlString += alt_disp_code+"~"+frmtime+"~"+totime+"~"+eff_sta+"~"+repeat+"~";
			}
		}
		var routing_level_code	=formObjBottom.routing_level.value;
		var ord_src_type=formobj.ord_src_type.value;
		var id=formobj.id.value;
		if ((routing_level_code=="G" || routing_level_code=="M") && mode=='1'){
			var routing_code			= formObjBottom.drug_code.value;
		}
		else
			var routing_code			= formObjBottom.routing_code.value;
		var billing_group_id	= formObjBottom.billing_group.value;
		var customer_group_id	= formObjBottom.customer_group.value;
		var customer_id	= formObjBottom.customer_id.value;
		var policy_type_id	= formObjBottom.polocy_type.value;
		var ord_src_type=formobj.ord_src_type.value;
		var id=formobjAltHeader.callFrom.value;
		var perform_fcy=formobj.perform_fcy.value;
		var order_fcy=formobj.order_fcy.value;
		var day_type=formobj.day_type.value;
		var disp_locn_code=formobj.disp_loc_code.value;
		var ord_src_code=formobj.ord_src_code.value;
		var mode=formobj.mode.value;
		var flag_mode=formobj.flag_mode.value;
		var bean_id="BLGroupOrderRoutingBean";
		var bean_name= "ePH.BLGroupOrderRoutingBean";
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr+= "alt_disp_code =\"" + alt_disp_code + "\" " ;
		xmlStr+= "frmtime =\"" + frmtime + "\" " ;
		xmlStr+= "totime =\"" + totime + "\" " ;
		xmlStr+= "eff_status =\"" + eff_sta + "\" " ;
		xmlStr+= "perform_fcy =\"" + perform_fcy + "\" " ;
		xmlStr+= "order_fcy =\"" + order_fcy + "\" " ;
		xmlStr+= "ord_src_type =\"" + ord_src_type + "\" " ;
		xmlStr+= "day_type =\"" + day_type + "\" " ;
		xmlStr+= "disp_locn_code =\"" + disp_locn_code + "\" " ;
		xmlStr+= "routing_level_code =\"" + routing_level_code + "\" " ;
		xmlStr+= "routing_code =\"" + routing_code + "\" " ;
		xmlStr+= "billing_group_id =\"" + billing_group_id + "\" " ;
		xmlStr+= "customer_group_id =\"" + customer_group_id + "\" " ;
		xmlStr+= "customer_id =\"" + customer_id + "\" " ;
		xmlStr+= "policy_type_id =\"" + policy_type_id + "\" " ;
		xmlStr+= "ord_src_code =\"" + ord_src_code + "\" " ;
		xmlStr+= "mode =\"" + mode + "\" " ;
		xmlStr+= "flag_mode =\"" + flag_mode + "\" " ;
		xmlStr+= "id =\"" + id + "\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "BLGroupOrderRoutingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&mode=" + mode + "&callFrom=" + callFrom+ "&flag=" + flag  + "&tmplDtlString=" + tmplDtlString + "&identity=store_alt_data", false) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;	
		eval( responseText ) ;
		if(mode=='1' || mode=='UPDATE')
			parent.orderroutingforbl_ALTDisplocation_detail.location.href="../../eCommon/html/blank.html" ;
		else if(mode=='2')
			parent.orderroutingforblqueryALT_bottom.location.href="../../eCommon/html/blank.html" ;
	}
}

function clearAltDispLocnDtls(ord_src_type,order_fcy,perform_fcy,mode){
	var day_type=document.AltDisplocnHeader.day_type.value;
	var ord_src_code=document.AltDisplocnHeader.ordering_source_code.value;
	var disp_locn_code=document.AltDisplocnHeader.disp_loc_code.value;
	if(day_type!=""){
	if(mode=='1') 	parent.orderroutingforbl_ALTDisplocation_detail.location.href="../../ePH/jsp/BLGroupOrderRoutingALTDispLocationDetails.jsp?mode="+mode+"&ORD_SRC_TYPE="+ord_src_type+"&order_fcy="+order_fcy+"&perform_fcy="+perform_fcy+"&day_type_value="+day_type+"&ord_src_code="+ord_src_code+"&disp_locn_code="+disp_locn_code;
	else if(mode=='2') 
		parent.orderroutingforblqueryALT_bottom.location.href="../../ePH/jsp/BLGroupOrderRoutingALTDispLocationDetails.jsp?mode="+mode+"&ORD_SRC_TYPE="+ord_src_type+"&order_fcy="+order_fcy+"&perform_fcy="+perform_fcy+"&day_type_value="+day_type+"&ord_src_code="+ord_src_code+"&disp_locn_code="+disp_locn_code;
	}
}

function generateRow(obj,num,desc,code) {
  var tbl = document.getElementById('AltDspLoc');
  var cnt1=document.AltDisplocnDeatil.count.value;
  var cnt=cnt1;
  for(cal=1;cal<cnt;cal++) {
	if(eval("document.AltDisplocnDeatil.select_"+cal)==null){
		cnt=cal;
	 }
  }
  var rwid=getSelectedRowId(obj)+1;
  var row = tbl.insertRow(rwid);
  var oCell = row.insertCell(0);
  var classvalue;		  
   
  if (Number(cnt)%2 == 0)
	 classvalue = "QRYEVEN" ;
  else
	 classvalue = "QRYODD" ;

	oCell.className=classvalue;
	oCell.innerHTML="<td width='15%' align='left'>"+desc+"</td>";

	oCell = row.insertCell(1);
	oCell.align="center"
	oCell.className=classvalue;
	oCell.innerHTML="<td  align='center' width='10%'><input type='text'   name=frmtime_"+cnt+"  maxlength='5' size='5' onkeypress='return allowPositiveNumber()' onblur='appedzero(this);validtime(this,totime_"+cnt+");'></td>";

	oCell = row.insertCell(2);
	oCell.align="center"
	oCell.className=classvalue;
	oCell.innerHTML="<td align='center' class='"+classvalue+"' width='10%'><input type='text' name=totime_"+cnt+"  id='totime' maxlength='5' size='5' onkeypress='return allowPositiveNumber()' onblur='toggleCheckBox(this,"+cnt+",false);appedzero(this);timecheck(this,"+cnt+");validtime(this,frmtime_"+cnt+");' > </td>";

	oCell = row.insertCell(3);
	oCell.align="center"
	oCell.className=classvalue;
	oCell.innerHTML="<td align='center' class='"+classvalue+"' width='2%' ><input type='button' class='button' name=rem_"+cnt+" onClick='setflag("+cnt+");removeRow(this);' value=' X ' > </td>"

	l_repeat = getMaxCodeRepeat(code); 

	oCell = row.insertCell(4);
	oCell.align="center"
	oCell.className=classvalue;

	oCell.innerHTML="<td align='center' class='"+classvalue+"' width='6%'><input type='checkbox' name='select_"+cnt+"' id='select_"+cnt+"' onClick='assignValue(this,"+cnt+");clearValue(this,"+cnt+");'> <input type=hidden name='code_"+cnt+"' id='code_"+cnt+"' value='"+code+"' > <input type=hidden name='flag_"+cnt+"' id='flag_"+cnt+"' value='N'> <input type=hidden name='number_"+cnt+"' id='number_"+cnt+"' value=''><input type=hidden name='enable_"+cnt+"' id='enable_"+cnt+"' value='E'> <input type=hidden name='arrVal_"+cnt+"' id='arrVal_"+cnt+"' value='N'>  <input type=hidden name='dbVal_"+cnt+"' id='dbVal_"+cnt+"' value=''><input type=hidden name='repeat_"+cnt+"' id='repeat_"+cnt+"' value='"+(parseInt(l_repeat)+1)+"'></td>";
	UpdateCount();

} 

function getMaxCodeRepeat(code){
	var maxValue = -1;
	var deleted="0";
	for (i=1;i<document.AltDisplocnDeatil.count.value ;i++ ){
		if(!(eval("document.AltDisplocnDeatil.repeat_"+i)=="undefined"||eval("document.AltDisplocnDeatil.repeat_"+i)==null)){
			if ( eval("document.AltDisplocnDeatil.code_"+i+".value") == code && parseInt(eval("document.AltDisplocnDeatil.repeat_"+i+".value"))> parseInt(maxValue)){					
				maxValue = eval("document.AltDisplocnDeatil.repeat_"+i+".value");			
			}
		}
		else{
			deleted="1";
		}
		if(deleted=="1")
			break;
	}
	return maxValue;
}

function UpdateCount(num,opr){
	if(opr=="M"){
	   document.AltDisplocnDeatil.count.value=Number(document.AltDisplocnDeatil.count.value)-1;
	}
	else{
		document.AltDisplocnDeatil.count.value=Number(document.AltDisplocnDeatil.count.value)+1;
	}
}

function getSelectedRowId(row){
    return  row.parentNode.parentNode.rowIndex
}

function setflag(num){
	var fl=eval("document.AltDisplocnDeatil.flag_"+num);
	var ft=eval("document.AltDisplocnDeatil.frmtime_"+num);
	var tt=eval("document.AltDisplocnDeatil.totime_"+num);
	eval("document.AltDisplocnDeatil.enable_"+num+".value='D'");
	ft.value="";
	tt.value="";
	fl.value="R";
}

function removeRow(obj){
    var tbl = document.getElementById('AltDspLoc');
    var n=getSelectedRowId(obj);
	tbl.deleteRow(n);
	UpdateCount(n,'M');
}

function timecheck(obj,objno){
	var frmtime=eval("document.AltDisplocnDeatil.frmtime_"+objno).value;
	var totime=eval("document.AltDisplocnDeatil.totime_"+objno).value;
    if ((frmtime > totime) ){
//		 alert(getMessage("FROM_TIME_GREATER_THAN_TO_TIME","PH"));
//		 eval("document.AltDisplocnDeatil.totime_"+objno).focus();
	}
}

function clearValue(obj,objno){
	if(obj.checked==false){
		eval("document.AltDisplocnDeatil.frmtime_"+objno+".value=''");
		eval("document.AltDisplocnDeatil.totime_"+objno+".value=''");
		eval("document.AltDisplocnDeatil.enable_"+objno+".value='D'");

		try{
			eval("document.AltDisplocnDeatil.addRow_"+objno+".style.visibility='hidden'");
		}
		catch(e){}
	}
}

function assignValue(obj,objno){
	var frmtime=eval("document.AltDisplocnDeatil.frmtime_"+objno).value;
	var totime=eval("document.AltDisplocnDeatil.totime_"+objno).value;	
	if(obj.checked){
		if((frmtime=="")|| (totime==""))
			alert(getMessage("ALT_TIMINGS_BLANK","PH"));
		eval("document.AltDisplocnDeatil.enable_"+objno+".value='E'");
	}
	else{
		clearValue(obj,objno);
	}
}

function clearData1(obj) {
	obj = eval(obj);
	var len = obj.length;
	obj.value="";
	obj.focus();
}

function allowPositiveNumber() { 
	var key = window.event.keyCode;
	if( ! ( ( key>=48 ) && ( key<=58 ) ) ) {
		return false;
	}
}

function toggleCheckBox(obj,num,stat){
	frmobj=document.AltDisplocnDeatil;
	var alt_disp_code=eval("document.AltDisplocnDeatil.code_"+num).value;
	var frmtime=eval("document.AltDisplocnDeatil.frmtime_"+num).value;
	var totime=eval("document.AltDisplocnDeatil.totime_"+num).value;
	var eff_sta=eval("document.AltDisplocnDeatil.enable_"+num).value;
	var select_flag=eval("document.AltDisplocnDeatil.flag_"+num).value;
	var arrValue=eval("document.AltDisplocnDeatil.arrVal_"+num).value;
	var repeat=eval("document.AltDisplocnDeatil.repeat_"+num).value;
	
	try{
		if(checkTime(obj,num)){
			var ob=eval("document.AltDisplocnDeatil.select_"+num)
			ob.checked=true;
			ob.value='E';
			if(stat){
				var addrw=eval("document.AltDisplocnDeatil.addRow_"+num)
				addrw.style.visibility="visible";
			}
		}
		else{
			var ob=eval("document.AltDisplocnDeatil.select_"+num)
			ob.checked=false;
			ob.value='D';
			if(stat){
				var addrw=eval("document.AltDisplocnDeatil.addRow_"+num)
				addrw.style.visibility="hidden";
			}
		}
	}
	catch(e){}
}

function checkTime(obj,num){
    var frmtime=eval("document.AltDisplocnDeatil.frmtime_"+num).value;
	var timefield = obj.value;
	var strHr;
	var strMi;

    if(frmtime==''||timefield=='') 
		return false;

	var strTimeArray = new Array();
  
	strTimeArray = timefield.split(":");
	strHr = strTimeArray[0];
	strMi = strTimeArray[1];

	if(strHr>=24|| strMi>=60) 
		return false
	else if ((frmtime > timefield)) 
		return false
	else 
		return true;
 }

 function disablefields(){
	var formobj=document.frmBLOrderRoutingLocation;
	var billing_group_code= formobj.billing_group.options[formobj.billing_group.selectedIndex].value;
	var billing_type= formobj.billing_group.options[formobj.billing_group.selectedIndex].type;
	clearCustomer();
	clearPolocyType();
	if(billing_type=="C"){
		formobj.customer_group.value="";
		formobj.customer_id.value="";
		formobj.polocy_type.value="";
		formobj.customer_group.disabled=true;
		formobj.customer_id.disabled=true;
		formobj.polocy_type.disabled=true;
		document.getElementById("imgCustGroup").style.display='none';
		document.getElementById("imgCust").style.display='none';
		document.getElementById("imgPolocyType").style.display='none';
	}
	else{
		formobj.customer_group.value="";
		formobj.customer_id.value="";
		formobj.polocy_type.value="";
		formobj.customer_group.disabled=false;
		formobj.customer_id.disabled=false;
		formobj.polocy_type.disabled=false;
		document.getElementById("imgCustGroup").style.display='inline';
		document.getElementById("imgCust").style.display='inline';
		document.getElementById("imgPolocyType").style.display='inline';
		if(billing_type=="R"){
			formobj.polocy_type.disabled=true;
			document.getElementById("imgPolocyType").style.display='none';
		}
	}
 }

 function finalcompare(frmtime,to_time){
	var fromtime=frmtime.value;
	var totime=to_time.value;
	
	var strHr1;
	var strMi1;
	
	var strHr2;
	var strMi2;

	var strHr3;
	var strMi3;

	var strHr4;
	var strMi4; 

   	var timefield1 = fromtime;
	var strTimeArray1 = new Array();

	var timefield2 = totime;
	var strTimeArray2 = new Array();

	if(	timefield1 != null  && timefield1 != ""){
		strTimeArray1 = timefield1.split(":");
		strHr1 = strTimeArray1[0];
		strMi1 = strTimeArray1[1];
	}
    if(	timefield2 != null && timefield2 != ""){
		strTimeArray2 = timefield2.split(":");
		strHr2 = strTimeArray2[0]; 
		strMi2 = strTimeArray2[1];
	}
	
	if(strHr1 <= strHr3){
		if(strHr2 > strHr4){
			alert( getMessage("TO_TIME_LESS_CUR_DISP_FR_TIME","PH"));
			to_time.select();
			to_time.focus();
		}
	}
}

function AltDispLocnForAmend(callFrom){
	var formobj=document.frmOrderRoutingCharacteristicsForBL;
	var routing_level_flag=true;
	
	var facility_id = formobj.facility_id.value;
	var ordering_source_type = formobj.ordering_source_type.value;
	if(ordering_source_type=='E')
		ordering_source_type='C'
	if(ordering_source_type=='D')
		ordering_source_type='N'

	 var ordering_source_code = formobj.ordering_source_code.value;
	 var routing_level=formobj.routing_level.value;
	 var rout_code=formobj.routing_code.value;
	 var performing_facility=formobj.performing_facility_id.value; 
	 var disp_loc_code ="";
	 var disp_loc_desc ="";
	 var label;
	if(callFrom=='R'){
		disp_loc_code = formobj.rtn_ord_disp_locn_code.value;
		disp_loc_desc= formobj.rtn_ord_disp_locn_code.options[formobj.rtn_ord_disp_locn_code.selectedIndex].text;
		label =" "+getLabel("ePH.RoutineOrders.label","PH") ;
	}
	else if(callFrom=='S'){
		disp_loc_code = formobj.stat_ord_disp_locn_code.value;
		disp_loc_desc= formobj.stat_ord_disp_locn_code.options[formobj.stat_ord_disp_locn_code.selectedIndex].text;
		label =" "+getLabel("ePH.StatOrder.label","PH") ;
	}
	else if(callFrom=='D'){
		disp_loc_code = formobj.disch_ord_disp_locn_code.value;
		disp_loc_desc= formobj.disch_ord_disp_locn_code.options[formobj.disch_ord_disp_locn_code.selectedIndex].text;
		label =" "+getLabel("ePH.Discharge/TakeHomeMedicationOrders.label","PH") ;
	}
	if(disp_loc_code ==""){
		alert(getMessage("PH_SELECT_DISPLOCN","PH" )+label); 
		return false;
	}
	 if(routing_level!="S"){
		if(routing_level=="O"||routing_level=="D"||routing_level=="L"){
			if(formobj.routing_code.value==""){
				routing_level_flag=false;
			}
		}
		if(routing_level=="G"||routing_level=="M"){
			rout_code=formobj.routing_code.value;
			if(formobj.routing_code.value==""){					
				 routing_level_flag=false;
			}	
		}
	}
	parent.orderroutingforblquery_bottom.location.href="../../ePH/jsp/BLGroupOrderRoutingALTDispLocationAddModify.jsp?mode="+MODE_MODIFY+"&ORD_SRC_TYPE="+ordering_source_type+"&order_fcy="+facility_id+"&perform_fcy="+performing_facility+"&disp_loc_code="+disp_loc_code+"&ord_src_code="+ordering_source_code+"&rout_level="+routing_level+"&rout_code="+rout_code+"&callFrom="+callFrom+"&disp_loc_desc="+encodeURIComponent(disp_loc_desc)+"&ordering_source_code="+ordering_source_code;
}

function setvisibility(obj){
	formobj=document.AltDisplocnHeader;
	for (i=0;i<obj.options.length ; i++){
		if (obj.options[i].value==obj.value){
			obj.options[i].selected=true;
			break;
		}
	}
}

function AltDispLocationDetails(disp_locn_code,id,mode){
	if(mode=='2'){
		AltDispLocationDetailsForAmend(disp_locn_code,id,mode);
	}else{
	var formobjbottom=parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation;
	var routing_level_flag=true;	
	var facility_id = parent.orderroutingforbl_top.frmOrderRoutingCharacteristicsForBL.facility_id.value;
	var ordering_source_type = parent.orderroutingforbl_top.frmOrderRoutingCharacteristicsForBL.ordering_source_type.value;

	if(ordering_source_type=='E')
		ordering_source_type='C'
	if(ordering_source_type=='D')
		ordering_source_type='N'

	 var ordering_source_code = parent.orderroutingforbl_top.frmOrderRoutingCharacteristicsForBL.ordering_source_code.value;
	
	 var routing_level=formobjbottom.routing_level.value;
	 var billing_group=formobjbottom.billing_group.value;
	 var rout_code=formobjbottom.routing_code.value;
	 var performing_facility=formobjbottom.performing_facility_id.value; 
	 var day_type=document.getElementById('day_type');
	 var day_type_value=day_type.options[day_type.selectedIndex].value;
	 if(day_type_value==""){
		 alert(getMessage("PH_PLEASE_SELECT_DAY","PH"));
		 return false;
	 }
	 if(routing_level!="S"){
		
		if(routing_level=="O"||routing_level=="D"||routing_level=="L"){
			
			if(formobjbottom.routing_code.value==""){
				
				routing_level_flag=false;
			}
		}
		if(routing_level=="G"||routing_level=="M"){
			rout_code=formobjbottom.drug_code.value;
			if(formobjbottom.drug_desc.value==""){					
				 routing_level_flag=false;
			}	
		}
	}
	parent.orderroutingforbl_ALTDisplocation_detail.location.href="../../ePH/jsp/BLGroupOrderRoutingALTDispLocationDetails.jsp?mode="+mode+"&ORD_SRC_TYPE="+ordering_source_type+"&order_fcy="+facility_id+"&perform_fcy="+performing_facility+"&disp_locn_code="+disp_locn_code+"&ord_src_code="+ordering_source_code+"&rout_level="+routing_level+"&rout_code="+rout_code+"&day_type_value="+day_type_value+"&id="+id+"&billing_group="+billing_group;
	}
}

function clearAltDispDtl(callFrom){
	parent.orderroutingforbl_ALTDisplocation_header.location.href="../../eCommon/html/blank.html" ;
	parent.orderroutingforbl_ALTDisplocation_detail.location.href="../../eCommon/html/blank.html" ;
	var frmobj = document.frmBLOrderRoutingLocation;
	var bean_id		= frmobj.bean_id.value ;
	var bean_name	= frmobj.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "BLGroupOrderRoutingValidate.jsp?identity=clearAltDispDtl&bean_id=" + bean_id + "&bean_name=" + bean_name+"&callFrom="+callFrom, false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}

function AltDispLocationDetailsForAmend(disp_locn_code,id,mode){
	var formobjbottom=parent.orderroutingforblquery_top.frmOrderRoutingCharacteristicsForBL;
	var routing_level_flag=true;	
	var facility_id = formobjbottom.ordering_facility_id.value;
	var ordering_source_type = formobjbottom.ordering_source_type.value;
	var ordering_source_code = formobjbottom.ordering_source_code.value;
	if(ordering_source_type=='E')
		ordering_source_type='C'
	if(ordering_source_type=='D')
		ordering_source_type='N'
	 var routing_level=formobjbottom.routing_level.value;
	 var billing_group=formobjbottom.billing_group.value;
	 var rout_code=formobjbottom.routing_code.value;
	 var performing_facility=formobjbottom.performing_facility_id.value; 
	 var day_type=document.getElementById('day_type');
	 var day_type_value=day_type.options[day_type.selectedIndex].value;
	 if(day_type_value==""){
		 alert(getMessage("PH_PLEASE_SELECT_DAY","PH"));
		 return false;
	 }
	 if(routing_level!="S"){
		if(routing_level=="O"||routing_level=="D"||routing_level=="L"){
			if(formobjbottom.routing_code.value==""){
				routing_level_flag=false;
			}
		}
		if(routing_level=="G"||routing_level=="M"){
			rout_code=formobjbottom.routing_code.value;
			if(formobjbottom.routing_code.value==""){					
				 routing_level_flag=false;
			}	
		}
	}
	parent.orderroutingforblqueryALT_bottom.location.href="../../ePH/jsp/BLGroupOrderRoutingALTDispLocationDetails.jsp?mode="+mode+"&ORD_SRC_TYPE="+ordering_source_type+"&order_fcy="+facility_id+"&perform_fcy="+performing_facility+"&disp_locn_code="+disp_locn_code+"&ord_src_code="+ordering_source_code+"&rout_level="+routing_level+"&rout_code="+rout_code+"&day_type_value="+day_type_value+"&id="+id+"&billing_group="+billing_group;
}

function addRoutineStatListInModify(code,desc){
	try{
		var formObj =parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation;
	}
	catch(e){
		var formObj = document.forms[0];
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
function clearRoutineStatDischargeListInModify(){
	
	try{
		var formObj =parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation;
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

function addDischargeListInModify(code,desc){
	try{
		var formObj =parent.orderroutingforbl_bottom.frmBLOrderRoutingLocation;
	}
	catch(e){
		var formObj = document.forms[0];
	}
	var opt3 = document.createElement("OPTION") ;
	opt3.text = desc ;
	opt3.value = code ;
	formObj.disch_ord_disp_locn_code.add(opt3);
}

function resetDefault(formObjBottom,formObjChar){
	loadRoutineStatDischargeBasedOnFacility();
	formObjBottom.billing_group.value="";
	formObjBottom.customer_group.value="";
	formObjBottom.customer_id.value="";
	formObjBottom.polocy_type.value="";
	formObjBottom.routing_code.value="";
	formObjBottom.routing_level.value="D";
	formObjBottom.rtn_ord_disp_locn_code.value="";
	formObjBottom.stat_ord_disp_locn_code.value="";
	formObjBottom.disch_ord_disp_locn_code.value="";
	formObjBottom.routing_level.disabled=false;
	formObjBottom.drug_code.value = "";
	formObjBottom.drug_desc.value = "";
	formObjBottom.routing_code.style.display="inline";
	formObjBottom.routing_code.style.visibility="visible";
	formObjBottom.drug_desc.style.display="none";
	formObjBottom.btnDrug.style.display="none";
	parent.orderroutingforbl_ALTDisplocation_header.location.href="../../eCommon/html/blank.html";
	parent.orderroutingforbl_ALTDisplocation_detail.location.href="../../eCommon/html/blank.html";
	formObjChar.ordering_source_type.disabled=true;
	formObjChar.ordering_source_code.disabled=true;
	formObjBottom.currRowNo.value = "";
	loadRoutingLevelRelatedElements(formObjBottom.routing_level);
}

