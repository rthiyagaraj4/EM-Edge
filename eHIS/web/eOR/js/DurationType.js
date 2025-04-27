/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;

function apply(){
		var length = f_query_add_mod.duration_type.totalSize.value
		var typeCode = "";
		var desc = "";
		var forText = "";

		for(i=0; i<length; i++){

			
			if((eval("f_query_add_mod.duration_type.desc"+i).value == "" && eval("f_query_add_mod.duration_type.forText"+i).value != "") || (eval("f_query_add_mod.duration_type.desc"+i).value != "" && eval("f_query_add_mod.duration_type.forText"+i).value == "") ){
				var msg3 =  getMessage('DESC_FORTEXT_NOT_BLANK','OR')
				//var msg3 =  "can not be blank"
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg3;
				return false
			}
			
			if(eval("f_query_add_mod.duration_type.typeCode"+i).value == ""){
				eval("f_query_add_mod.duration_type.typeCode"+i).value = " ";
			}
			if(eval("f_query_add_mod.duration_type.desc"+i).value == ""){
				eval("f_query_add_mod.duration_type.desc"+i).value = " ";
			}
			if(eval("f_query_add_mod.duration_type.forText"+i).value == ""){
				eval("f_query_add_mod.duration_type.forText"+i).value = " ";
			}

			typeCode += eval("f_query_add_mod.duration_type.typeCode"+i).value+"~";
			desc += eval("f_query_add_mod.duration_type.desc"+i).value+"~";
			forText += eval("f_query_add_mod.duration_type.forText"+i).value+"~";

		}

		typeCode = typeCode.substring(0,typeCode.length-1);
		desc = desc.substring(0,desc.length-1);
		forText = forText.substring(0,forText.length-1);

	
		f_query_add_mod.duration_type.allTypeCode.value = typeCode;
		f_query_add_mod.duration_type.allDesc.value = desc;
		f_query_add_mod.duration_type.allForText.value = forText;
		eval(formApply( f_query_add_mod.duration_type,OR_CONTROLLER) );

		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		if( result ) {
			onSuccess();
		}
}

function reset(){
    f_query_add_mod.document.duration_type.reset();
}



function onSuccess() {
	var mode = f_query_add_mod.document.duration_type.mode.value;
	if( mode == "2" ) {
		f_query_add_mod.location.href = "../../eOR/jsp/DurationTypeApply.jsp?mode=2&function_id="+function_id
		//formReset();
	}
}




function formReset () {
	var formObj = f_query_add_mod.document.duration_type;
//	formObj.reason_type.value = "";
//	formObj.reason_code.value = "";
//	formObj.reason_desc.value = "";

}

function assignResult(_result, _message, _flag){
	result = _result ;
	message  = _message ;
	flag = _flag ;

}
