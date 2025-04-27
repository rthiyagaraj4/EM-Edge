function CheckNum(obj){
	if(obj.value!=''){
		var valid = 'T';
		var strCheck = '0123456789';
		if ( obj.value.length > 0 ){
			for(var i=0;i<=obj.value.length;i++) {
				if (strCheck.indexOf(obj.value.charAt(i)) == -1){
					alert(getMessage("NUM_ALLOWED","SM"));
					valid='F';
					obj.select();
					obj.value="";
					obj.focus();
					return false;
					break;
				}
			}
		}
		if(document.forms[0].no_weeks_for_rule.value == 0){
			var error;
			//error=getMessage("HIGH_NOT_INVITED","OA");
			alert( getMessage('NO_WEEKS_SHOULDNOT_BE_0','OA'))
		}
	}
}
function reset(){
}
function apply(){
	no_weeks_for_rule=f_query_add_mod.document.forms[0].no_weeks_for_rule.value;
	if(no_weeks_for_rule <= 52)
		f_query_add_mod.document.forms[0].submit();
	else{
		//alert("No of Weeks to be considered should be less than or equal to 52");
		alert( getMessage('NO_WEEKS_GREATER_THAN_52','OA'))
		commontoolbarFrame.location.reload();
		messageFrame.location.href='../../eCommon/jsp/error.jsp';
	}
}
function onSuccess(){
}

