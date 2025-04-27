function apply(){

	//if(frames[1].frames[1].document.forms[0] != null){
		var error = "";
		if(f_query_add_mod.frames[0].document.forms[0].batchId.value==""){
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			error = msg.replace('$', getLabel("Common.BatchNo.label","Common"))+"</br>";	
		}
		if(f_query_add_mod.frames[0].document.forms[0].approval_disp_no.value==""){
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error + msg.replace('$', getLabel("eMR.ApprovalDisposalNo.label","mr"))+"</br>";	
		}
		if(f_query_add_mod.frames[0].document.forms[0].approval_date.value==""){
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error+msg.replace('$', getLabel("eMR.ApprovalDate.label","mr"))+"</br>";	
		}

		if(f_query_add_mod.frames[1].document.forms[0]!=null){
			var patIdList = f_query_add_mod.frames[1].document.getElementsByTagName('input');
			var selectedPatId	= "";
			var count			= 0;
			for (i = 0; i < patIdList.length; i++) {
				if (patIdList[i].type == 'checkbox' && patIdList[i].name== 'chkApproval') {
					if(patIdList[i].checked==true){
						selectedPatId	= selectedPatId + patIdList[i].value+",";
						count++;
					}
				}
			}
			if(selectedPatId==""){
				error = error+ getMessage("ATLEAST_ONE_RECORD_ENTERED","Common");
			}else{
				selectedPatId	= selectedPatId.slice(0, -1); 

				f_query_add_mod.frames[1].document.forms[0].selectedPatientIds.value	= selectedPatId;
				f_query_add_mod.frames[1].document.forms[0].approval_disp_no.value		= f_query_add_mod.frames[0].document.forms[0].approval_disp_no.value;
				f_query_add_mod.frames[1].document.forms[0].approval_date.value	= f_query_add_mod.frames[0].document.forms[0].approval_date.value;
				f_query_add_mod.frames[1].document.forms[0].actType.value	= 'Apply';
			}
		}


		if(error==""){
			f_query_add_mod.frames[1].document.forms[0].submit();
		}else{
			frames[2].location = '../../eCommon/jsp/MstCodeError.jsp?err_num='+error 
		}
	//}
	
	
	
	/*else{
		var error = getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace('$', getLabel("Common.BatchNo.label","Common"));	
		frames[2].location = '../../eCommon/jsp/MstCodeError.jsp?err_num='+error 
	}*/
}

function deleterecord(){
			if(f_query_add_mod.frames[1].document.forms[0]!=null){
			var patIdList = f_query_add_mod.frames[1].document.getElementsByTagName('input');
			var selectedPatId	= "";
			var error			= "";
			var count			= 0;
			for (i = 0; i < patIdList.length; i++) {
				if (patIdList[i].type == 'checkbox' && patIdList[i].name== 'chkApproval') {
					if(patIdList[i].checked==true){
						selectedPatId	= selectedPatId + patIdList[i].value+",";
						count++;
					}
				}
			}
			if(selectedPatId==""){
				error =  getMessage("ATLEAST_ONE_RECORD_ENTERED","Common");
			}else{
				selectedPatId	= selectedPatId.slice(0, -1); 

				f_query_add_mod.frames[1].document.forms[0].selectedPatientIds.value	= selectedPatId;
				f_query_add_mod.frames[1].document.forms[0].approval_disp_no.value		= f_query_add_mod.frames[0].document.forms[0].approval_disp_no.value;
				f_query_add_mod.frames[1].document.forms[0].approval_date.value	= f_query_add_mod.frames[0].document.forms[0].approval_date.value;
				f_query_add_mod.frames[1].document.forms[0].actType.value	= 'Delete';
			}
			if(error==""){
				f_query_add_mod.frames[1].document.forms[0].submit();
			}else{
				frames[2].location = '../../eCommon/jsp/MstCodeError.jsp?err_num='+error 
			}
		}else{
			frames[2].location = '../../eCommon/jsp/MstCodeError.jsp?err_num='; 
		}

}

function chkDateVal(obj)
{
	if(obj.value!=""){
		if(validDateObj(obj,'DMYHM',localeName)){
			if(isBeforeNow(obj.value,"DMYHM",localeName)){
				return true;
			}else{
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.focus();
				flagVal=false;					
			}
		}else{
			flagVal=false;				
		}
	}
}



function callSearch(obj){ 
		if(obj.value!=""){
			parent.frames[0].document.forms[0].submit();
		} else {
			var error = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("Common.BatchNo.label","Common"));	
			parent.frames[1].location = '../../eCommon/html/blank.html';
			parent.parent.frames[2].location = '../../eCommon/jsp/MstCodeError.jsp?err_num='+error ;
		}

}


function reset() {
	f_query_add_mod.location.reload();
} 

function onSuccess(){	
	f_query_add_mod.location.reload();
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
