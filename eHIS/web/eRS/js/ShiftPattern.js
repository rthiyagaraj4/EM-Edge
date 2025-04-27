var result = false;
var message = "" ;
var flag = true ;
var invalidCode ="";
var function_id = "";
var bykey=false;

function create()
{
	f_query_add_mod.location.href='../../eRS/jsp/ShiftPatternFrameSet.jsp?mode='+MODE_INSERT;
}
/*************************************************/
function apply(){	
	
   if (! checkIsValidForProceed() ) {	
		
		//message  = getMessage("NOT_VALID","Common")
		message  = "";
		//parent.frames[2].location.href = "../../eCommon/html/blank.html?err_num="+ message;
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
   
	//var messageFrame = parent.frames[1].frames[2];
	 ; 		
	
	 var frmobj=f_query_add_mod.frames[0].document.form_add_mod ;
	 var mode=frmobj.mode.value;
	   	  		

	if(frmobj.eff_status.checked)
		frmobj.eff_status.value='E';
	else
		frmobj.eff_status.value='D';

	if(mode=="2"){
		
		var efstatus=frmobj.eff_status.value;
		var efstatus1=frmobj.eff_status1.value;
		if((efstatus=="D")&(efstatus1=="D")){
			message  = getMessage("NOT_VALID","Common");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false;
		}
		frmobj.locn_type.disabled=false;
		qry_str="&shift_pattern_id="+frmobj.shift_pattern_id.value+"&long_desc="+escape(frmobj.shift_long_desc.value)+"&short_desc="+escape(frmobj.shift_short_desc.value)+"&locn_type="+frmobj.locn_type.value+"&eff_status="+frmobj.eff_status.value;
		
	}

	var fields = new Array (frmobj.shift_pattern_id,frmobj.shift_short_desc,frmobj.shift_long_desc);			    
	var names = new Array (getLabel("Common.code.label","Common"),getLabel("Common.shortdescription.label","Common"),getLabel("Common.longdescription.label","Common"));		

	var flds=new Array(frmobj.shift_pattern_id);
	var name=new Array(getLabel("eRS.ShiftPatternID.label","RS"));
	if(!SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
		return false
	}
	   	
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))	{
	
		frmobj.submit();
	}
}
/*************************************************/
function onSuccess(){	 
	var frmobj=f_query_add_mod.frames[0].document.form_add_mod ;
	var mode=frmobj.mode.value;
	if(mode == "1" )
		frmobj.reset();
	else if(mode=="2")
		f_query_add_mod.frames[0].location.href='../../eRS/jsp/ShiftPatternAddModify.jsp?mode=2'+qry_str;
}
/*************************************************/

function checkIsValidForProceed(){

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) ) //not query
		return true;
	else
		return false;
}
/*********************************************/

function reset(){

	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1){
		if(url.indexOf("FrameSet")==-1)
			f_query_add_mod.document.forms[0].reset();
		else
			f_query_add_mod.frames[0].document.forms[0].reset();
	}
}
/*************************************************/

function query(){
	f_query_add_mod.location.href='../../eRS/jsp/ShiftPatternQueryCriteria.jsp';
}
/*************************************************/

function onenable(status){

	if(status.checked==true)
		status.value='E';
	else
		status.value='D';
}

   

/*************************************************/

function  check(total_keys,k,l){//KEY PERSS
	bykey=true;
	var key = window.event.keyCode;
	if( (key >= 97) && (key <= 122) ){
		event.keyCode -= 32;
		key -= 32;
	}
	var key_value=String.fromCharCode(key);

	var exist=false;
	var mnemonic_keys=new Array(total_keys);
	var shift_code=new Array(total_keys);
	var i=0;
	var formObj=document.form_add_mod;

	for( i=0;i<total_keys;i++)
		mnemonic_keys[i]=eval("formObj.mnemonic_key"+i).value;	

	for( i=0;i<total_keys;i++)
		shift_code[i]=eval("formObj.shift_id"+i).value;	
	if(key_value.value !=""){
		for(var i=0; i<mnemonic_keys.length;i++){		
			if(key_value == mnemonic_keys[i]){
				eval("formObj.shift_code"+k+l).value=shift_code[i];
				exist=true;
				break;
			}		
		}
	}
	else
		exist= true;
		
	if(!exist){
		exist=false;
		alert("Invalid Shift");
	}
	return exist;
}
/*******************************************************/
function  check1(obj,total_keys,k,l){//onblur

	var key_value=obj.value;
	if((key_value != '')&&(bykey == false)){
		var exist=false;
		var mnemonic_keys=new Array(total_keys);
		var shift_code=new Array(total_keys);
		var i=0;
		var formObj=document.form_add_mod;

		for( i=0;i<total_keys;i++)
			mnemonic_keys[i]=eval("formObj.mnemonic_key"+i).value;	

		for( i=0;i<total_keys;i++)
			shift_code[i]=eval("formObj.shift_id"+i).value;	
		if(key_value.value !=""){
			for(var i=0; i<mnemonic_keys.length;i++){		
				if(key_value == mnemonic_keys[i]){
					eval("formObj.shift_code"+k+l).value=shift_code[i];
					exist=true;
					break;
				}		
			}
		}
		else
			exist= true;
			
		if(!exist){
			exist=false;
			alert("Invalid Shift");
			obj.select();
			obj.focus();
		}
	}
	bykey=false;
}
/***************************************************/
