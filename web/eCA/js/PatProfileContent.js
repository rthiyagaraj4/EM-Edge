
/*to check for the presence of -ve numbers and zero in a text box*/
function checkSequence(objSequence)
{
	var errorMessage =""
	if(parseInt(objSequence.value) <= 0){
		errorMessage= getMessage["NO_SPECIAL_CHARACTER",'CA'];
		alert(errorMessage);
		objSequence.value=''
		objSequence.focus()
		return false
	}
	if(objSequence.value == '-'){
		errorMessage= getMessage["NO_SPECIAL_CHARACTER",'CA'];
		alert(errorMessage);
		objSequence.value=''
		objSequence.focus()
		return false
	}
}

function apply()
{	
	var chkDupOrd = new Array();
	var ordCount = parseInt(NMPatProfileContent.document.formPatProfileContent.rowCnt.value);

	for(var ordSeq = 1;ordSeq <= ordCount;ordSeq++){
		var orderSeqNum = eval("NMPatProfileContent.document.formPatProfileContent.order_seq_no"+ordSeq);
		chkDupOrd[ordSeq] = orderSeqNum.value;
	}
var cnt = 0;
	for(var ordSeq2 = 2;ordSeq2 <= ordCount;ordSeq2++){
		var orderSeqNumber = eval("NMPatProfileContent.document.formPatProfileContent.order_seq_no"+parseInt(ordSeq2-1));
		for(var oSeq=1;oSeq <= ordCount;oSeq++){
			if(chkDupOrd[oSeq] != ""){
				if(chkDupOrd[oSeq] == orderSeqNumber.value){
					cnt++;
				}
			}
		}
		if(cnt >= 2){
			errorMessage = getMessage("DUPLICATE_SEQUENCE_NUMBER",'CA');	 
			alert(errorMessage + orderSeqNumber.value);
			orderSeqNumber.select();
			orderSeqNumber.focus();		
			commontoolbarFrame.location.reload();
			return false;
		}
		cnt = 0;
	}
	
	
	var fields = new Array()
	var description = new Array()
	for(var index = 1,arrayIndex = 0 ; index <= parseInt(NMPatProfileContent.document.formPatProfileContent.rowCnt.value);index ++,arrayIndex++)
	{
		var contentId = eval("NMPatProfileContent.document.formPatProfileContent.content_id"+index);
		var contentUserDesc = 	eval("NMPatProfileContent.document.formPatProfileContent.content_user_def_desc"+parseInt(contentId.value));
		fields[arrayIndex] = contentUserDesc

		description[arrayIndex] = eval("NMPatProfileContent.document.formPatProfileContent.content_sys_def_desc"+contentId.value+".value");	
	}
	if(checkFieldsofMst(fields,description,messageFrame))
	{
		NMPatProfileContent.document.formPatProfileContent.action="../../servlet/eCA.PatProfileContentServlet";
		NMPatProfileContent.document.formPatProfileContent.target="messageFrame";
		NMPatProfileContent.document.formPatProfileContent.method="post";
		NMPatProfileContent.document.formPatProfileContent.submit();	
	}
	else
	{
		return false
	}
}

function reset()
{	
	NMPatProfileContent.document.forms[0].reset();
	//NMPatProfileContent.location.reload();
}

function onSuccess()
{
	NMPatProfileContent.location.reload();
}
