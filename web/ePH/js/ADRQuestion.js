
var message = "" ;
var result = false ;

function create()
{
		f_query_add_mod.location.href	=	"../../ePH/jsp/ADRQuestionAddModify.jsp?mode="+MODE_INSERT;
}
	function query() 
	{
		f_query_add_mod.location.href	=	"../../ePH/jsp/ADRQuestionQueryCriteria.jsp?mode="+MODE_MODIFY;
	}
	/*function Modify(obj)
	{
 
	
	var Certainity_code		 =	obj.cells[0].innerText;	
	var System_Description	 =	obj.cells[1].innerText;	
	var user_desc			 =	obj.cells[2].innerText;	
	var seq_no				 =	obj.cells[3].innerText;	
	var rel_score_from		 =	obj.cells[4].innerText;	
	var rel_score_to		 =	obj.cells[5].innerText;	
	var eff_status			 =	obj.cells[6].innerText;	

	parent.frames[1].location.href		=	"../../ePH/jsp/ADRQuestionAddModify.jsp?mode="+MODE_MODIFY+"&Certainity_code="+Certainity_code+"&System_Description="+System_Description+"&user_desc="+user_desc+"&rel_score_from="+rel_score_from+"&rel_score_to="+rel_score_to+"&eff_status="+eff_status+"&seq_no="+seq_no;
	
	}*/

	function checkSign(obj)
	{
			var size	=	obj.value.length;
			var index	=	0;
			for(index=0;index<=size;index++)
			{
				if((obj.value.length=="1")&&((obj.value.charAt(0))=="-"))
				{
					obj.value	=	"";		
					 alert(getMessage("ENTER_VALID_NEGATIVE_NUMBER","PH"));
				}
				
				if(((obj.value.charAt(index))=="-")&&(index>0))
				{
					obj.value	=	"";	
					 alert(getMessage("ENTER_VALID_NEGATIVE_NUMBER","PH"));
				}
			}			
	}

function apply()
 {
	 //added on 8/dec/09
	 if(!checkIsValidForProceed())
	{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	} //ends
	
	 var formObj					=	f_query_add_mod.document.formADRQuestionAddModify;
	 var mode						=	formObj.mode.value;
	
	 
	 var ques_code					=	formObj.ques_code.value;
	 var ques_desc					=	formObj.ques_desc.value;
	 var seq_no						=	formObj.seq_no.value;
	 var relative_score_yes			=	formObj.relative_score_yes.value;
	 var relative_score_no			=	formObj.relative_score_no.value;
	 var relative_score_not_known	=	formObj.relative_score_not_known.value;
	 // var messageFrame				=	 parent.frames[1].frames[2];
	 messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	 var error_page					=	"../../eCommon/jsp/MstCodeError.jsp";
	 if(mode==MODE_INSERT)
	 {
	
		
		var fields		=	new Array	(formObj.ques_code,formObj.ques_desc,formObj.seq_no,formObj.relative_score_yes,formObj.relative_score_no,formObj.relative_score_not_known,formObj.eff_status);
		
		var names	    =	new Array	(getLabel("ePH.QuestionCode.label","PH"),getLabel("ePH.QuestionDescription.label","PH"),getLabel("Common.SequenceNo.label","Common"),getLabel("Common.yes.label","Common"),getLabel("Common.no.label","Common"),getLabel("Common.NotKnown.label","Common"),getLabel("Common.enabled.label","Common"));	
		
			if(f_query_add_mod.checkFieldsofMst(fields,names,messageFrame))
			{
				if(	checkOverlap(relative_score_yes,relative_score_no,relative_score_not_known))
				 {
						eval(formApply( formObj, PH_CONTROLLER )) ;
						//alert(responseText);
						messageFrame.location.href	=	"../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
						if( result ) 
						{
							onSuccess();
						}
				 }
					 else
					 {
						formObj.relative_score_not_known.value="";
						formObj.relative_score_no.value="";
						formObj.relative_score_yes.value="";
						formObj.relative_score_yes.focus();
						
						message=getMessage("RANGE_SHOULD_NOT_EXCEED","PH");
						messageFrame.location.href	=	"../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					 }
					
				}
				
		
	 }
	 else 
	 {

			var fields	=	new Array	(formObj.ques_desc,formObj.seq_no,formObj.relative_score_yes,formObj.relative_score_no,formObj.relative_score_not_known);
		
			var names =		new Array	(getLabel("ePH.QuestionDescription.label","PH"),getLabel("Common.SequenceNo.label","Common"),getLabel("Common.yes.label","Common"),getLabel("Common.no.label","Common"),getLabel("Common.NotKnown.label","Common"));	
		if(f_query_add_mod.checkFieldsofMst(fields,names,messageFrame))
		{
			if(	checkOverlap(relative_score_yes,relative_score_no,relative_score_not_known))
			 {	
				
					eval(formApply(formObj,PH_CONTROLLER ));
				//	alert(responseText);
					messageFrame.location.href	=	"../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					if( result ) 
					{
						onSuccess();
					}
				}
				else{
						formObj.relative_score_not_known.value="";
						formObj.relative_score_no.value="";
						formObj.relative_score_yes.value="";
						formObj.relative_score_yes.focus();
						message=getMessage("RANGE_SHOULD_NOT_EXCEED","PH");
						messageFrame.location.href	=	"../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				 }
		}
		
	
	 }
	
	 
 }
//added on 8-dec-09 on click of apply in query mode
function checkIsValidForProceed() {
	
	var url = f_query_add_mod.location.href;
	//alert("URl===>" +url);
	url = url.toLowerCase();
	
	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("adrquestionquerycriteria")==-1) )
		return true;
	else
		return false;
}
	
	
function onSuccess() 
{ 
		
	 		 reset();
}
	
function reset()
{	
		//alert("inside reset");
		var url=f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("adrquestionquerycriteria")!=-1) ) {
			f_query_add_mod.document.query_form.reset();
		}
		else if ( (url.indexOf("adrquestionaddmodify")!=-1) ) {
		if(f_query_add_mod.document.formADRQuestionAddModify.mode.value == MODE_INSERT){
			//alert(f_query_add_mod.document.formADRQuestionAddModify.mode.value);
			formReset() ;
		}
			else {
				//alert("sandhya");
        
        // added by marwan to hold the changed check box value before reset
				var checked = f_query_add_mod.document.formADRQuestionAddModify.eff_status.checked;
				f_query_add_mod.document.formADRQuestionAddModify.reset();
				f_query_add_mod.document.formADRQuestionAddModify.eff_status.checked = checked;
			}
		}
		
		/*var obj								=	f_query_add_mod.document.formADRQuestionAddModify;
		obj.ques_code.value					=	"";
		obj.ques_desc.value					=	"";
		obj.seq_no.value					=	"";
		obj.relative_score_yes.value		=	"";
		obj.relative_score_no.value			=	"";
		obj.relative_score_not_known.value  =	"";
		obj.eff_status.checked				=  true;*/
		
}
function formReset()  // added on 8/Dec/09
{
	//alert("Inside form reset");
	var obj=f_query_add_mod.document.formADRQuestionAddModify;
	obj.ques_code.value = "";
	obj.ques_desc.value					=	"";
	obj.seq_no.value					=	"";
	obj.relative_score_yes.value		=	"";
	obj.relative_score_no.value			=	"";
	obj.relative_score_not_known.value  =	"";
	obj.eff_status.checked				=  true;
}

	function assignResult( _result, _message, _flag )
	{
		result		 = _result ;
		message		 = _message ;
		flag		 = _flag ;
	}

	function checkOverlap(relative_score_yes,relative_score_no,relative_score_not_known)
	{
			
	    var formObj		=	f_query_add_mod.document.formADRQuestionAddModify;
		var bean_id		=	formObj.bean_id.value ;
		var bean_name	=	formObj.bean_name.value ;
		var mode		=	formObj.mode.value ;
		var xmlDoc		=	"";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr		=	"<root><SEARCH  /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../ePH/jsp/ADRQuestionValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&relative_score_yes="+relative_score_yes+"&relative_score_no="+relative_score_no+"&relative_score_not_known="+relative_score_not_known + "&validate=OVERLAPPING"+"&mode="+mode, false);
		xmlHttp.send(xmlDoc);
		var responseText=xmlHttp.responseText;
		//alert("responseText---"+responseText);
		return responseText;
		//eval(responseText);
	}
	function checkedValue(str)
	{
		if(str=='Y')
			return true;
		else
			return false;
	}

	
	function CheckForAlphabets(event)
	{
	    var strCheck	=	'0123456789-';
	    var whichCode	=	(window.Event) ? event.which : event.keyCode;
	    key				=	String.fromCharCode(whichCode);  // Get key value from key code
	    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	    return true ;
	}

	
	function checkSeqNo(obj)
	{ 
		var str		=	obj.value;
		if((parseInt(str)<0)||((str.charAt(0)=="0")&&(str.length==1))||(str=="000")||(str=="00"))
		{
			var fieldname	=	 getLabel("Common.SequenceNo.label","Common");
			alert(getMessage("ZERO_NOT_ALLOWED","PH")+""+fieldname);
			
			obj.value		=	"";
			obj.focus();
		}

	}
	function CheckForSequence(event)
	{
	    var strCheck = '1234567890';
	    var whichCode = (window.Event) ? event.which : event.keyCode;
	    key = String.fromCharCode(whichCode);  // Get key value from key code
	    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	
	    return true ;
	}
	function check_Status(obj)
	{

	if(obj.checked==true)
		obj.value="E";
	else{
		
		if(obj.checked==false)
		obj.value="D";
		
		}
		
}
function set_Status(obj)
	{

	if(obj.checked==true)
		obj.value="E";
	else{
		
		if(obj.checked==false)
		obj.value="D";
		
		}
if(obj.value="E"){
	f_query_add_mod.document.formADRQuestionAddModify.eff_status.checked=true;}
		
}
function Modify(obj) {
	var ques_code							=	obj.cells[0].innerText;
	var ques_desc							=	obj.cells[1].innerText;
	var seq_no								=	obj.cells[2].innerText;
	var relative_score_yes					=	obj.cells[3].innerText;
	var relative_score_no					=	obj.cells[4].innerText;
	var relative_score_not_known			=	obj.cells[5].innerText;
	var eff_status							=	obj.cells[6].textContent ;
	
	document.location.href	=	"../../ePH/jsp/ADRQuestionAddModify.jsp?mode="+MODE_MODIFY+"&ques_code="+ques_code+"&ques_desc="+ques_desc+"&seq_no="+seq_no+"&relative_score_yes="+relative_score_yes+"&relative_score_no="+relative_score_no+"&relative_score_not_known="+relative_score_not_known+"&eff_status="+eff_status;
}
function checkMaxLength(obj)
{
	var str	=	obj.value;
	
	if(str.length>400)
	{
		

		var fieldname = getLabel("ePH.QuestionDescription.label","PH");
		var msg = getMessage("PH_PRN_REMARKS_MAX_LENGTH", "PH");
		msg		= msg.replace('PRN Remarks', fieldname);
		alert(msg);
		obj.focus();
	}
}
