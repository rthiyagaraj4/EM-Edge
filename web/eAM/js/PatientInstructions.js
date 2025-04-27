function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyPatientInstructions.jsp?mode=insert" ;
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/queryPatientInstructions.jsp?mode=modify" ;
}

function apply() {
	 var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) ){
		
	var fields = new Array ( f_query_add_mod.document.patientinstructions_form.instruction_id, f_query_add_mod.document.patientinstructions_form.instruction_desc);
	var names  =  new Array ( getLabel("eAM.InstructionID.label","AM"), getLabel("eAM.InstructionDescript.label","AM"));
	
	var messageFrame = frames[2]; 	
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
	
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
				f_query_add_mod.document.patientinstructions_form.submit();	
	    
        
	 }
	 else
		 commontoolbarFrame.location.reload();

}

function changeCase(Obj){
      		Obj.value=Obj.value.toUpperCase();      	
}

function CheckForSpecChar(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
/*Below Method Added by Senthil on 21-Oct-2011*/
function CheckForSpecChardesc(event){
var strCheck = ' `~!@#$%^&*()_-+={[]}\\:;"\'<,.>?/0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key	
	return true ;
}
/*End*/

function CheckNumber(obj) {
   var sequence = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
   var obj_value = obj.value;
   var obj_length = obj_value.length;

   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){

			var msg=getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","SM")
			alert(msg);
			obj.focus();
			obj.select();
			return false;
		}
   }

   return true ;
}

function makeValidString(txtObj,size)
{    
    /*Added below Code by Senthil on 21-Oct-2011*/
	var text_value  =   txtObj.value;
    while(text_value.indexOf('"')!=-1)
    {
        text_value = text_value.replace('"',"'");
    }
    txtObj.value = text_value;
	/*End*/
	
    if(txtObj.value.length>size)
    {
        alert(getMessage("EXCEED_MAX_LENGTH", "Sm",null));
        txtObj.select();
        txtObj.focus();
    }
}

function change() {
	      	 if (patientinstructions_form.eff_status.checked == true)
	      	 	patientinstructions_form.eff_status.value="E";
	      	 else
	      		patientinstructions_form.eff_status.value="D";
}

function reset() {
		if(f_query_add_mod.document.forms[0])
		 	   f_query_add_mod.document.location.reload();
}

function onSuccess() {	
	f_query_add_mod.location.reload();
}

/*function CheckForSpecialChar(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ~!@#$%^&*()_+=-`:";<>,.\'|?\\{}\/[]';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	
	return true ;
}*/
