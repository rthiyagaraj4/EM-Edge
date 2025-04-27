
function onSuccess() 
 {
	f_query_add_mod.document.location.reload();
 }

function create()
{
	f_query_add_mod.location.href ="../../eOP/jsp/addModifyVisitRule.jsp" ;
}

function query()
 {
	
	 f_query_add_mod.location.href ="../../eOP/jsp/VisitRuleQueryCriteria.jsp" ;
 }

 

function reset(){
  if(f_query_add_mod.document.forms[0])
	f_query_add_mod.document.location.reload();
 } 

  function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
 }

function apply(){
	if (! (checkIsValidForProceed())){
        messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }	
	var fields = new Array (f_query_add_mod.document.visit_rule_form.rule_id,	f_query_add_mod.document.visit_rule_form.rule_desc,f_query_add_mod.document.visit_rule_form.followup_days,f_query_add_mod.document.visit_rule_form.secvisit_days,f_query_add_mod.document.visit_rule_form.no_of_followup_visit,f_query_add_mod.document.visit_rule_form.no_of_sec_visit);	 
	var names = new Array (getLabel("eOP.RuleID.label","OP"),getLabel("eOP.RuleDesc.label","OP"),getLabel("eOP.Followup.label","OP"),getLabel("eOP.SecondaryVisit.label","OP"),getLabel("eOP.NoofFollowupAllowed.label","OP"),getLabel("eOP.NoofSecondaryAllowed.label","OP"));	
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";		
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){  	 		
		f_query_add_mod.document.forms[0].rule_id.disabled=false;        
		f_query_add_mod.document.forms[0].rule_desc.disabled=false;        
		f_query_add_mod.document.forms[0].followup_days.disabled=false;        
		f_query_add_mod.document.forms[0].secvisit_days.disabled=false;         
		f_query_add_mod.document.forms[0].no_of_followup_visit.disabled=false;         
		f_query_add_mod.document.forms[0].no_of_sec_visit.disabled=false;         
		f_query_add_mod.document.forms[0].cummulative_allowed_yn.disabled=false;         
		if(f_query_add_mod.document.forms[0].cummulative_allowed_yn.checked)
			f_query_add_mod.document.forms[0].cummulative_allowed_yn.value ="Y";
		else
			f_query_add_mod.document.forms[0].cummulative_allowed_yn.value="N";
		f_query_add_mod.document.visit_rule_form.submit();		
	}
}
 
 function setFocus(){
	if(document.forms[0].rule_id.disabled==false)
	  document.forms[0].rule_id.focus();
}

function checkForZero(obj){	  
	if(obj.value == '0' || obj.value == '00' || obj.value == '000' || obj.value == '0000'){		 
		alert(getMessage("VALUE_GREAT_ZERO","MP")) ;
		obj.value="";
		obj.focus();
	}
}
function CheckForDigits(event){ 
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

 function chkValue(obj){
	   if(obj.checked==true){
		obj.checked=true;
		obj.value='E';
       }else{
		obj.checked=false;
		obj.value='D';
       }    
   }

   function chkCumtiveValue(obj){
	   if(obj.checked==true){
		obj.checked=true;
		obj.value='Y';
       }else{
		obj.checked=false;
		obj.value='N';
       }  
   }
