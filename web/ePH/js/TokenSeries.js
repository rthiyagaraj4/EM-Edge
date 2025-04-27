  var result1		=	false;
var function_id =   "PH_TOKEN_SERIES" ;
var message     =   "" ;
var flag        =   "" ;
var invalidCode =  "";
var globalCode  =   "";
var formObj     =   null;

function create() {
    f_query_add_mod.location.href="../../ePH/jsp/TokenSeriesAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}
function query() {
    f_query_add_mod.location.href="../../ePH/jsp/TokenSeriesQueryCriteria.jsp?function_id="+function_id ;
}
function beforePost(xmlStr){
//	alert("In tokenSeries function:"+xmlStr)
}
function apply() {

    formObj =   f_query_add_mod.document.formTokenSeries;

    var arrFieldName        =   new Array();
    var arrLegends          =   new Array();

    arrFieldName[0]         =   "token_series_code";
	arrFieldName[1]         =   "description";
	//arrFieldName[2]         =   "start_serial_no";
   
	arrLegends[0]           =   "Code";
	arrLegends[1]           =   "Description";
	//arrLegends[2]           =   "Start Serial No";
   
    var arrPKFieldNames     =   new Array();

    arrPKFieldNames[0]      =   "token_series_code";
  
    if(!proceedOnApply()){
        messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
        return false;
    }

    var mode = formObj.mode.value;
    if( mode == MODE_INSERT ){
		resetDuplicateClass(formObj,arrPKFieldNames);
        var result  =   validateMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames);
        if (result){
			var formObj = f_query_add_mod.document.formTokenSeries ;
			var fields = new Array ( formObj.disp_locn_code);
			var names = new Array (getLabel("ePH.DispenseLocation.label","PH"));
			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
				var noOfRecords=parseInt(f_query_add_mod.tokenSeriesTable_insert.rows.length - 5);
				for (i=0; i<=noOfRecords; i++ ){
					if (eval("formObj.select"+i).checked==true){
						break;
					}
					else if (eval("formObj.select"+i).checked==false && (noOfRecords == i)){
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("ATLEAST_ONE_SELECTED","common");
						return false;
					}
				}
				/*
				for(var i=0;i<=noOfRecords;i++){
					for (var j=i+1;j<=noOfRecords ;j++ ){
						if (eval("formObj.ws_no"+j).value != ""){
							if (eval("formObj.ws_no"+i).value == eval("formObj.ws_no"+j).value){
								messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_WORK_STATION_NO_DUPLICATED");
								return false;
							}
						}
					}
				}*/
				/*
				for(i=0; i<=noOfRecords; i++ ){
					if (parseFloat(eval("formObj.next_serial_no"+i).value) > parseFloat(eval("formObj.max_serial_no"+i).value)){
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_NEXT_SRL_NO_GT_MAX");
						eval("formObj.next_serial_no"+i).select();
						return ;
					}
				}*/
				var totalRecords=parseInt(formObj.totalRecords.value);
				for(var j=0; j<totalRecords; j++){
					var fields1 = new Array (eval("formObj.token_series_code"+i), eval("formObj.description"+i)); 
					var names1 = new Array (getLabel("Common.code.label","Common"),getLabel("Common.description.label","Common")); 
					
					if(!checkFieldsofMst( fields1, names1, messageFrame)){
						//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
						return false;
					}

					if(!eval("formObj.QMS_required"+j).checked && eval("formObj.select"+j).checked && eval("formObj.start_serial_no"+j).value==""){
						var msg = getMessage("SHOULD_NOT_BE_BLANK","Common");
						msg = msg.replace("{1}",getLabel("Common.Start.label",'Common')+getLabel("Common.SerialNo.label",'Common'));
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
						eval("formObj.start_serial_no"+j).focus();
						return false;
					}
					if(eval("formObj.QMS_edit_token"+j).checked == true)
						eval("formObj.QMS_edit_token"+j).value='Y';
					else
						eval("formObj.QMS_edit_token"+j).value='N';
				}

				eval(formApply(f_query_add_mod.document.formTokenSeries,PH_CONTROLLER));
				if( result1 ) {
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					onSuccess();
					return false;
				}
				var invalidCodeList		=	"";
				var arrIndividualCodes	=	invalidCode.split(",");
				var lenIndividualCodes	=	arrIndividualCodes.length;
				for(var i=0; i<lenIndividualCodes; i++){	
					var individualCodes	=	arrIndividualCodes[i];
					var arrNextPKCode	=	individualCodes.split(":");
					var nextPKCode		=	arrNextPKCode[1];
					invalidCodeList		+=	nextPKCode + ",";
				}
				if(invalidCodeList.length>2)
					invalidCodeList	=	invalidCodeList.substring(0,invalidCodeList.length-1);
				invalidCode		=	invalidCodeList;
				if( invalidCode != "null" && invalidCode != "" ){
					showDuplicates(formObj, arrPKFieldNames, invalidCode,'0',messageFrame);
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
                }
			}
        }
        else{
            return false;
        }
	}
	if( mode == MODE_MODIFY ){
        
		var formObj = f_query_add_mod.document.formTokenSeries ;
		var QMS_required_yn = formObj.QMS_required;
		var fields = new Array (formObj.start_serial_no);
		var names = new Array (getLabel("Common.StartSerialNo.label","Common"));
		if(QMS_required_yn.checked == true || f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {				
				
			if(formObj.QMS_edit_token.checked == true)
				formObj.QMS_edit_token.value='Y';
			else
				formObj.QMS_edit_token.value='N';
			/*if (parseFloat(formObj.next_serial_no.value) > parseFloat(formObj.max_serial_no.value)){
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_NEXT_SRL_NO_GT_MAX");
				formObj.next_serial_no.select();
				return ;
			}else{*/
			if ((formObj.modified_not_allowed.value) =="Y"){
				eval(formApply( f_query_add_mod.document.formTokenSeries,PH_CONTROLLER ));
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;		
				if( result1 ) {
					onSuccess();	
					return false;
				}
			}
			else{

				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_MODIFICATION_NOT_ALLOWED","PH");	
			}
			//}
		}
		else{
			if (formObj.start_serial_no.value == ""){
				formObj.start_serial_no.focus();
			}
		}
	}
}

function onSuccess() {
    var mode = f_query_add_mod.document.formTokenSeries.mode.value;
    if( mode == MODE_INSERT ) {
		//f_query_add_mod.location.href="../../ePH/jsp/TokenSeriesAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
       
		f_query_add_mod.document.formTokenSeries.reset();
		f_query_add_mod.document.formTokenSeries.disp_locn_code.disabled = false;
//	clearWSlist();
    }
    else if(mode == MODE_MODIFY ){
		var formObj = f_query_add_mod.document.formTokenSeries ;		
       f_query_add_mod.location.href="../../ePH/jsp/TokenSeriesAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&disp_locn_code="+formObj.disp_locn_code.value+"&token_series_code="+formObj.token_series_code.value;
	   
    }
}

function assignResult( _result, _message, _flag, _invalidCode ) {
    result1 = _result ;
    message  = _message ;
    flag = _flag ;
    invalidCode = _invalidCode ;	
}

function reset() {

    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();

    if ( (url.indexOf("tokenseriesquerycriteria")!=-1) ) {
        f_query_add_mod.document.query_form.reset();
    }

    else if ( (url.indexOf("tokenseriesaddmodify")!=-1) ){
		//f_query_add_mod.document.formTokenSeries.disp_locn_code.disabled = true;
	//	clearWSlist();
        if(f_query_add_mod.document.formTokenSeries.mode.value == MODE_INSERT){
            formObj =   f_query_add_mod.document.formTokenSeries;

            var arrPKFieldNames     =   new Array();
            arrPKFieldNames[0]      =   "token_series_code";

            resetDuplicateClass(formObj,arrPKFieldNames);
            f_query_add_mod.document.formTokenSeries.reset();
        }
        else {
            f_query_add_mod.document.formTokenSeries.reset();
			if(f_query_add_mod.document.formTokenSeries.QMS_required.checked == false){
				f_query_add_mod.document.formTokenSeries.QMS_edit_token.disabled = true;
				f_query_add_mod.document.formTokenSeries.QMS_edit_token.checked = false;
			}
			else{
				f_query_add_mod.document.formTokenSeries.QMS_edit_token.disabled = false;
			}
        }
    }
}
function toUpper(obj) {
    obj.value=obj.value.toUpperCase();
}

function Modify(obj){
	
	var disp_locn_code=obj.cells[0].innerText;
	var token_series_code=obj.cells[2].innerText;
	var token_gen_stage=obj.cells[7].innerText;

	document.location.href="../../ePH/jsp/TokenSeriesAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&disp_locn_code="+disp_locn_code+"&token_series_code="+token_series_code+"&token_gen_stage="+token_gen_stage+"&status="+status;  //   Added new parameters 'status' and 'token_gen_stage' for [IN032818]
}

function TokenSeriesCheck(obj){
    if(!CheckChars(obj)){
        alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
        obj.focus();
        return false;
    }
}
function proceedOnApply() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("tokenseriesquery")==-1) )
        return true;
    else
        return false;
}

function resetColorCode(obj){
    var arrPKFieldNames =   new Array();
    var formObj         =   parent.f_query_add_mod.document.formTokenSeries;
    /**
      * specify the primary key columns
      */
    arrPKFieldNames[0]  =   "token_series_code";

    /**
      * if more than one columns exists in
      * the primary key, then the next columns
      * can be given like this
      */
    resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}

function onBlurCheck(obj){
	formObj =   parent.f_query_add_mod.document.formTokenSeries;
	if (eval("formObj.token_series_code"+obj).value != "" && eval("formObj.description"+obj).value != ""){// &&	eval("formObj.start_serial_no"+obj).value != ""	){
		eval("formObj.select"+obj).checked = true;
	}
	else{
		eval("formObj.select"+obj).checked = false;
	}
}

/*function resetSerialNo(){
	formObj =   parent.f_query_add_mod.document.formTokenSeries;
	formObj.next_serial_no.value = "1";
	formObj.all.last_recycled_date.style.visibility="visible";
	var sysDate = new Date();	

	var date	= sysDate.getDate();
	var month   = sysDate.getMonth()+1;
	var year	= sysDate.getYear();

	if (date < 9){
		date = "0"+date;
	}
	if (month < 9){
		month = "0"+month;
	}
	formObj.all.last_recycled_date.innerHTML ="<b>"+date+"/"+month+"/"+year+" "+sysDate.getHours()+":"+sysDate.getMinutes()+"</b>";
	formObj.recycled_date.value=date+"/"+month+"/"+year+" "+sysDate.getHours()+":"+sysDate.getMinutes();
	formObj.all.lastrecycleddateid.innerHTML="<b>Last Recycled Date :&nbsp;</b>";
}*/

function validateSerialNo(obj){
	if (parseFloat(obj.value) ==0){		
		alert(getMessage("VALUE_GREAT_ZERO","PH"));    
		obj.select();
		obj.focus();
		return false;
	}
	if(!CheckChars(obj)){
        alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));TOKEN_GEN_UPON_RELEASE
		obj.select();
        obj.focus();
        return false;
    }
}
function validateForTheValue(obj,existingValue){
	if (parseFloat(obj.value) < parseFloat(existingValue)){
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_MAX_LESS_THAN_CURRENT");
		obj.focus();
		obj.select();
		return false;
	}else{
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	}
}
function getWSNoForList(){
		var formObj =   parent.f_query_add_mod.document.formTokenSeries;
		
		var bean_id		= formObj.bean_id.value ;
		var bean_name	= formObj.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		
		formObj.disp_locn_code.disabled = true;

		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "TokenSeriesValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&disp_locn_code="+formObj.disp_locn_code.value, false ) ;
		xmlHttp.send( xmlDoc ) ;
//		alert(xmlHttp.responseText)
		eval(xmlHttp.responseText);
}

function checkOrderStatus(obj){
	//alert(obj.value)
	var disp_code=obj.value;
	var formObj =   parent.f_query_add_mod.document.formTokenSeries;
	//alert("disp_code--->"+disp_code)
	var bean_id		= formObj.bean_id.value ;
	var bean_name	= formObj.bean_name.value ;

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TokenSeriesValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name+"&disp_code="+disp_code+"&chekdispcode=chekdispcode", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);
}

function CheckRegisterStatus(obj,cnt){
	var formObj =   parent.f_query_add_mod.document.formTokenSeries;
	var size=obj.value.length;
	for(var i=0;i<10;i++){
       gen_upon=eval("document.formTokenSeries.Genera_Upon"+i).value;
	   if(obj.value==gen_upon){
		   for(var j=i+1;j<10;j++){
			     gen_upon1=eval("document.formTokenSeries.Genera_Upon"+j).value;
				 if((gen_upon1==obj.value)&&(gen_upon1=="OR")){
					alert(getMessage("TOKEN_GEN_UPON_RELEASE","PH"));
					 obj.selectedIndex=0;
					 obj.value="RG"
				}
				//eval("document.formTokenSeries.Genera_Upon"+i).value=obj.value;
			}
		}

		if(obj.value==gen_upon){
			for(var j=i+1;j<10;j++){
				gen_upon1=eval("document.formTokenSeries.Genera_Upon"+j).value;
				if((gen_upon1==obj.value)&&(gen_upon1=="RI")){						
					alert(getMessage("TOKEN_GEN_UPON_REISSUE","PH"));
					 obj.selectedIndex=0;
					 obj.value="RG"
				}
			}
		}
   
		if(obj.value==gen_upon){
			for(var j=i+1;j<10;j++){
				gen_upon1=eval("document.formTokenSeries.Genera_Upon"+j).value;
				if((gen_upon1==obj.value)&&(gen_upon1=="RM")){
					alert(getMessage("TOKEN_GEN_UPON_RETURNMED","PH"));
					obj.selectedIndex=0;
					obj.value="RG"
				}
			}
		}

		if(obj.value==gen_upon){
			for(var j=i+1;j<10;j++){
				gen_upon1=eval("document.formTokenSeries.Genera_Upon"+j).value;
				if((gen_upon1==obj.value)&&(gen_upon1=="DD")){
					alert(getMessage("TOKEN_GEN_UPON_DIRECTDISP","PH"));
					obj.selectedIndex=0;
					obj.value="RG"
				}
			}
		}
	}
	ValidateQMS(cnt, 'GENUP')
}

function CheckStatus(OrdRelCount,ReIssueMediYN,ReturnMediYN,DirectDispYN,ReissueCount,ReturnMediCount,DirectDispCount){
	var formObj =   parent.f_query_add_mod.document.formTokenSeries;
	for(var j=0;j<10;j++){
		var len =eval("formObj.Genera_Upon"+j).length; 
		for(var i=0;i<len;i++) {
			eval("formObj.Genera_Upon"+j).remove("Genera_Upon"+j) ;
		}
		var element = document.createElement('OPTION');
		element.value		=  "RG" ;
		element.text		=  getLabel("Common.RegisterOrder.label","Common");
		eval("formObj.Genera_Upon"+j).add(element);  
		if(ReIssueMediYN=='Y' && ReissueCount ==0){
			var element = document.createElement('OPTION');
			element.value		= "RI";
			element.text		=  getLabel("ePH.ReissueMedication.label","PH");
			eval("formObj.Genera_Upon"+j).add(element); 
		}
		if(ReturnMediYN=='Y' && ReturnMediCount ==0){
			var element = document.createElement('OPTION');
			element.value		= "RM";
			element.text		=  getLabel("ePH.ReturnMedication.label","PH");
			eval("formObj.Genera_Upon"+j).add(element); 
		}
		if(DirectDispYN=='Y' && DirectDispCount==0){
			var element = document.createElement('OPTION');
			element.value		= "DD";
			element.text		=  getLabel("ePH.DirectDispensing.label","PH");
			eval("formObj.Genera_Upon"+j).add(element); 
		}
		if(OrdRelCount ==0){
			var element = document.createElement('OPTION');
			element.value		= "OR";
			element.text		=  getLabel("ePH.OrderRelease.label","PH");
			eval("formObj.Genera_Upon"+j).add(element);
		}
	}
}

/*function loadIntoWS(obj1,obj2){
	var formObj =   parent.f_query_add_mod.document.formTokenSeries;

	for (var i=0;i<10 ;i++ ){
		var opt1 = document.createElement("OPTION") ;
		opt1.text = obj1 ;
		opt1.value = obj2 ;
		eval("formObj.ws_no"+i).add(opt1);  
	}
} 
function clearWSlist(){
	var formObj =   f_query_add_mod.document.formTokenSeries;
	for(var j=0;j<10;j++)
		{
		var len =eval("formObj.ws_no"+j).options.length; 
		for(var i=0;i<len;i++) {
			eval("formObj.ws_no"+j).remove("ws_no"+i) ;
		}
		var tp = "        ---Select---        " ;
		var opt = document.createElement("OPTION") ;
		opt.text = tp ;
		opt.value = "" ;
		eval("formObj.ws_no"+j).add(opt);  
	}
}*/
// Added for Bru-HIMS-CRF-076 [IN:029942] start 

function ValidateQMS(index, chekObj){
	var generateUpon ;
	var start_serial_no ;
	var QMS_required ;
	var QMS_edit_token ;
	var gen_token ;
	if(index == -1){
		generateUpon = document.formTokenSeries.Genera_Upon.value;
		start_serial_no = document.formTokenSeries.start_serial_no;
		QMS_required = document.formTokenSeries.QMS_required;
		QMS_edit_token = document.formTokenSeries.QMS_edit_token;
		gen_token = document.formTokenSeries.gen_token;
	}
	else{
		generateUpon = eval("document.formTokenSeries.Genera_Upon"+index).value;
		start_serial_no = eval("document.formTokenSeries.start_serial_no"+index);
		QMS_required = eval("document.formTokenSeries.QMS_required"+index);
		QMS_edit_token = eval("document.formTokenSeries.QMS_edit_token"+index);
		gen_token = eval("document.formTokenSeries.gen_token"+index);
	}
	if(chekObj == "GENUP"){
		if(generateUpon != 'RG'){
			start_serial_no.readOnly=false;
			QMS_required.checked = false;
			QMS_required.disabled = true;
			QMS_edit_token.checked = false;
			QMS_edit_token.disabled=true;
		}
		else{
			QMS_required.disabled = false;
			start_serial_no.readOnly=false;
		}
	}
	else if(generateUpon == 'RG'){
		gen_token.disabled = false;
		if(chekObj == "GEN"){
			if(gen_token.checked==true){
				gen_token.value="Y"
				QMS_required.value="N";
				QMS_required.checked = false;
				QMS_edit_token.checked=false;
				QMS_edit_token.disabled=true;
				start_serial_no.readOnly=false;
			}
			else{
				QMS_required.value="N";
				QMS_edit_token.checked=false;
				QMS_required.disabled = false;
			}
		}
		else if(chekObj == "QMS"){
			if(QMS_required.checked==true){
				QMS_required.value="Y";
				gen_token.value="N";
				QMS_edit_token.disabled=false;
				gen_token.checked = false;
				start_serial_no.value="";
				start_serial_no.readOnly=true;
			}
			else{
				QMS_required.value="N";
				start_serial_no.readOnly=false;
				QMS_edit_token.checked=false;
				QMS_edit_token.disabled=true;
			}
		}
	}
	else{
		if(gen_token.checked==true)
			gen_token.value="Y"
		else
			gen_token.value="N"
	}
}
//	 Added for Bru-HIMS-CRF-076 [IN:029942] end
