function callApply(val){
	var frameRef	= parent.frames[1];
	var frameRefMsg	= parent.parent.frames[2];
	if(val==1){
		var frameRef	= frames[1].frames[1]
		var frameRefMsg	= frames[2];
	}
	var patIdList = frameRef.document.getElementsByTagName('input');
	var selectedPatId	= "";
	for (i = 0; i < patIdList.length; i++) {
		if (patIdList[i].type == 'checkbox' && patIdList[i].name== 'chkApproval') {
			if(patIdList[i].checked==true){
				selectedPatId	= selectedPatId + patIdList[i].value+",";
			}
		}
	}


	if(selectedPatId==""){
		var msg = getMessage("ATLEAST_ONE_RECORD_ENTERED","Common");
		frameRefMsg.location='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg ;
	}else{
		selectedPatId	= selectedPatId.slice(0, -1); 

		frameRef.document.forms[0].selectedPatientIds.value	= selectedPatId;
		frameRef.document.forms[0].submit();
	}
}
function apply(){
	if(frames[1].frames[1].document.forms[0]){
		callApply(1);
	}else{
		frames[2].location='../../eCommon/jsp/MstCodeError.jsp?err_num=' ;
	}
}


function Valid_DT(event) {
		var strCheck = '0123456789:/ ';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

	} 

function callSearch(obj){
		
		if(parent.frames[0].document.forms[0].from_date.value==""){
			var msg = getMessage("CAN_NOT_BE_BLANK","Common");
			msg	= msg.replace("$",getLabel("Common.DateFrom.label","Common"));
			parent.parent.frames[2].location='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg ;
		}else{
			parent.parent.frames[2].location='../../eCommon/jsp/MstCodeError.jsp?err_num=' ;
			parent.frames[0].document.getElementById("imgLoad").style.display='inline';
			parent.frames[0].document.getElementById("searchBtn").disabled=true;
			if(parent.frames[0].document.getElementById("dispApprBtn")!=null)
			parent.frames[0].document.getElementById("dispApprBtn").disabled=true;
			
			if(parent.frames[1].document.forms[0]!=null){
				var patIdList = parent.frames[1].document.getElementsByTagName('input');
				for (i = 0; i < patIdList.length; i++) {
					if (patIdList[i].type == 'checkbox') {
						patIdList[i].checked	= false;
						patIdList[i].disabled	= true;
					}
				}
			}
			parent.frames[0].document.forms[0].submit();
		}
}

function validate_date(obj) {
	
		if(obj.value!='' ){

			if(isBeforeNow(obj.value,"DMY",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.value='';
				obj.focus();
				return false ;
			}
		}
  }



function reset() {
	f_query_add_mod.location.reload();
} 

function onSuccess(){	
	f_query_add_mod.location.reload();
}


function fnShowNoRecords(){
	alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
	parent.parent.frames[0].location.reload();
	parent.parent.frames[1].location.reload();
}
function chkSelAll(obj){
			len=document.getElementById("chkApproval").length; 
			if (len!=null){
				if (obj.checked){
					for (i=0;i<len;i++){
						document.getElementById("chkApproval")[i].checked=true;
					}
				}else{
					for (i=0;i<len;i++){
						document.getElementById("chkApproval")[i].checked=false;
					}
				}
			}else{
				if (obj.checked){
					document.getElementById("chkApproval").checked=true;
				}else{
					document.getElementById("chkApproval").checked=false;
				}
			}
		}
