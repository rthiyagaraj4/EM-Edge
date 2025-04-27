//File modified on 25/04/2013 - for RUT-CRF-13.1 35825
function closeWindow(){
	var bool="false";
	var recCount=parent.patinsframe.document.patInsForm.recCount.value;
	for(var i=1;i<recCount;i++){
		if(eval('parent.patinsframe.document.forms[0].check_BoxID'+i).checked==true){
			bool="true";
			break;
		}
	}
	//window.returnValue=bool;
	//window.close();
/*let dialogBody = parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = bool;
    
    const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close();   */
	
	parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue = bool;
	parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();
}

async function addInstruction(){
	var recCount=parent.patinsframe.document.patInsForm.recCount.value;//check recCount value... only when the recCount is greater than
	var patInsCount=parent.patinsframe.document.patInsForm.patInsCount.value;
	var from_page="addIns";
	if(recCount<=20){
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit=getLabel("eAM.InstructionDescript.label","AM");
		var nursing_unit_code=parent.patinsframe.document.patInsForm.nursing_unit_code.value;
		var locale=parent.patinsframe.document.patInsForm.locale.value;
		var facilityId=parent.patinsframe.document.patInsForm.facilityId.value;
		var patient_id=parent.patinsframe.document.patInsForm.patient_id.value;
		var booking_ref_no=parent.patinsframe.document.patInsForm.booking_ref_no.value;
		var excludeInstns=parent.patinsframe.document.patInsForm.excludeInstns.value;
		var retVal				=  new String();
		var dialogHeight= "450px" ;
	    var dialogWidth = "700px" ;
		var status = "no";
		var dialogUrl       = "../../eIP/jsp/PatInsLookup.jsp?excludeInstns="+excludeInstns+"&patInsCount="+patInsCount;

		var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var dialogArguments="";
        
		var instnreturned= await top.window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);		
		 
		
		retVal = instnreturned;
		
		var arr=new Array();
		if(retVal != null && retVal != "" ){
			var retVal=unescape(retVal);
			var insFlag=true;
			
			var url="../../eIP/jsp/IPBkgPatientInstructions.jsp?nursing_unit_code="+nursing_unit_code+"&booking_ref_no="+booking_ref_no+"&addCode="+arr[0]+"&addDesc="+encodeURIComponent(arr[1])+"&patient_id="+patient_id+"&from_page="+from_page+"&addedInstns="+instnreturned;
			
			parent.patinsframe.location.href="../../eIP/jsp/IPBkgPatientInstructions.jsp?nursing_unit_code="+nursing_unit_code+"&booking_ref_no="+booking_ref_no+"&addCode="+arr[0]+"&addDesc="+encodeURIComponent(arr[1])+"&patient_id="+patient_id+"&from_page="+from_page+"&addedInstns="+instnreturned;
			
		}
	}else{
		var msg=getMessage("MAX_INSTRUCTIONS","OA");
		alert(msg.replace("$","20"));
	}
}



function default_check(displayorder,obj)
{	
	var default_yn;
	if(obj.checked==true)
		default_yn="Y";
	else
		default_yn="N";
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH step='ten'  default_yn=\""+default_yn+"\" position=\""+displayorder+"\" /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","BookingGetExpDaysDate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText= trimString(responseText)
}

function default_text(displayorder,obj,checkValue)
{	
	var description;
	if(obj!=null)
		description=obj.value;
	else
		description="";
	if (description.length > 200)
	{
		var error = getMessage('CANNOT_EXCEED_N_CHARS','IP');
		error = error.replace('$','200');
		alert(error);	
	}
	else{
		var default_yn="N";
		if (checkValue == 'checked'){
			default_yn="Y";
		}

	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH step='ten'  default_yn=\""+default_yn+"\" position=\""+displayorder+"\"  description=\""+encodeURIComponent(description)+"\" /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","BookingGetExpDaysDate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText= trimString(responseText)
	}
}

function valtext(){
	var excludeInstns=parent.criteria_frame.document.forms[0].excludeInstns.value;
	var patInsCount=parent.criteria_frame.document.forms[0].patInsCount.value;
	var url="../../eIP/jsp/PatInsResult.jsp?search_by="+parent.criteria_frame.document.CriteriaForm.radioval.value+"&excludeInstns="+excludeInstns+"&patInsCount="+patInsCount+"&search_text="+encodeURIComponent(parent.criteria_frame.document.CriteriaForm.search_text.value)+"&searchcriteria="+parent.criteria_frame.document.CriteriaForm.searchcriteria.value;
	var buttonUrl="../../eIP/jsp/PatInsButtons.jsp?"
	
	parent.contents_frame.document.location.href=url;
	parent.buttons_frame.document.location.href=buttonUrl;
	
	
}

function resetForm(formObj){
	 formObj.reset();
    parent.contents_frame.document.location.href= "../../eCommon/html/blank.html";
    parent.buttons_frame.document.location.href= "../../eCommon/html/blank.html";
}
function storeVal1(){
	if(parent.criteria_frame.document.CriteriaForm.search_by_code.checked==true){
		parent.criteria_frame.document.CriteriaForm.search_by_desc.checked=false;
		parent.criteria_frame.document.CriteriaForm.radioval.value="C";
	}
}

function storeVal2(){
	if(parent.criteria_frame.document.CriteriaForm.search_by_desc.checked==true){
		parent.criteria_frame.document.CriteriaForm.search_by_code.checked=false;
		parent.criteria_frame.document.CriteriaForm.radioval.value="D";
	}
}


function addCheckedInstructions(){
	var totalInsCount=parent.contents_frame.document.forms[0].InsCount.value;
	
	var addedInstnCode="";
	addedInstnCode=parent.contents_frame.document.forms[0].selectedInstns.value;
	
	addedInstnCode="'"+addedInstnCode.split(",").join("','");
	addedInstnCode = addedInstnCode.substring(0,addedInstnCode.length-2)
	
	parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue = addedInstnCode;
	parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();

	/*window.returnValue=addedInstnCode;
	window.close();*/
}


function addSelectedIns(obj,index){
	var selectedInstns=parent.contents_frame.document.forms[0].selectedInstns.value;
	var patInsCount=parseInt(parent.contents_frame.document.forms[0].patInsCount.value);
	
	if (obj.checked==true)
		{
			patInsCount=patInsCount+1;
			if(patInsCount > 20){
				var msg=getMessage("MAX_INSTRUCTIONS","OA");
				alert(msg.replace("$","20"));
				obj.checked=false;
				patInsCount=patInsCount-1;
			}else{
				selectedInstns=selectedInstns+eval('parent.contents_frame.document.forms[0].patInsCode'+index).value+",";			
			}			
		}else{
			var subString=eval('parent.contents_frame.document.forms[0].patInsCode'+index).value;
			if(selectedInstns.indexOf(subString) != -1){
				selectedInstns=selectedInstns.split(subString+",").join("");
					if(patInsCount > 0)
					patInsCount=patInsCount-1;
			}
		}
	
		
		
		parent.contents_frame.document.forms[0].selectedInstns.value=selectedInstns;
		parent.contents_frame.document.forms[0].patInsCount.value=patInsCount;

}


function submitPrevNext(from, to)
{
	parent.contents_frame.document.forms[0].from.value = from;
	parent.contents_frame.document.forms[0].to.value = to; 
	parent.contents_frame.document.forms[0].submit();
}

function allow_nochars( val ) {

	var text_val=val.value;
	if(text_val.indexOf("#") !=-1)
	{
		 alert(getMessage("CANNOT_BE_SPECIAL_CHAR","Common"));
		val.value="";
	}
}


function cancelCheckedInstructions()
{
	parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();
	//window.close();
}

function checkCriteria(obj){
	parent.criteria_frame.document.CriteriaForm.searchcriteria.value=obj.value;
}
