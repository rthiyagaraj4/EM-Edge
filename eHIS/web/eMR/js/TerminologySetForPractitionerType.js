var assignReassign = new Array();
function create(){
	frames[1].location.href='../../eMR/jsp/TerminologySetForPractitionerTypeFrameSet.jsp?mode=1';
}
/*********************************************************/
function query(){
	frames[1].location.href='../../eMR/jsp/TerminologySetForPractitionerTypeQueryCriteria.jsp';
}
/*********************************************************/

function reset(){
	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1) {
		if(url.indexOf("Query")==-1){
				parent.frames[2].frames[1].frameSearch.document.forms[0].reset();
				parent.frames[2].frames[1].frameSearch.document.forms[0].elements[0].focus();
				parent.frames[2].frames[1].frameResult.location.href='../../eCommon/html/blank.html';
				parent.frames[2].frames[1].Dummy.location.href='../../eCommon/html/blank.html';
		}else
			parent.frames[2].frames[1].document.forms[0].reset();
	}
}
/*********************************************************/
function apply(){
	var message="";
	var messageFrame = parent.frames[2].frames[2]; 
	if (! checkIsValidForProceed()) {
		message  = getMessage("APPLY_NOT_VALID",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		return false ;
	}
	if (!checkIsValidForProceed1()){
		message  = getMessage("APPLY_NOT_VALID",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	
	//alert(parent.frames[1].frames[1].frames[1].document.forms[0].dselect.value)
		//alert(document.forms[0].defaultselect.value);
		//alert("value"+parent.frames[1].frames[1].document.forms[0].defaultselect.value);
		//alert(parent.frames[1].frames[1].document.forms[0].default_select.value);
	//var maxRecord=parent.frames[1].frames[1].frames[1].document.forms[0].maxRecord.value;
	//alert(maxRecord);
	/*if(parent.frames[1].frames[1].frames[1].document.forms[0].dselect.checked==true){
	
		parent.frames[1].frames[1].frames[1].document.forms[0].dselect.value="Y";	
		//obj.disable=true;
			
	}
	else{
		parent.frames[1].frames[1].frames[1].document.forms[0].dselect.value="N";
	}*/

	parent.frames[2].frames[1].frames[1].document.forms[0].allValues.value=parent.frames[2].frames[1].frames[2].document.forms[0].E.value;
	parent.frames[2].frames[1].frames[1].document.forms[0].action="../../servlet/eMR.TerminologySetForPractitionerTypeServlet";
	parent.frames[2].frames[1].frames[1].document.forms[0].target="messageFrame";
	parent.frames[2].frames[1].frames[1].document.forms[0].submit();
	
	
}
/*********************************************************/
function onSuccess(){
	frames[1].frames[0].document.forms[0].reset();
	frames[1].frames[0].document.forms[0].elements[0].focus();
	frames[1].frames[1].location.href='../../eCommon/html/blank.html';
}
/*********************************************************/
function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
/*********************************************************/
function checkIsValidForProceed1()
{		var url = f_query_add_mod.frameResult.location.href;
		url = url.toLowerCase();

	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
		return true;
	else
		return false;
}
/*********************************************************/
function searchPratType(){

	parent.frames[1].location.href='../../eCommon/html/blank.html';
	var term=document.forms[0].terminology;
	var fields = new Array (term);			    
	var names = new Array (getLabel("Common.TerminologySet.label","Common"));		
	var messageFrame = parent.parent.frames[2]; 
	var practType=document.forms[0].pract_type.value;

		if(practType.indexOf("'")!=-1)
		{			
			practType = practType.replace("'","''");
		}
	/*
	if(document.forms[0].pract_type.value!='')
	{
		var fields1 = new Array(document.forms[0].pract_type);
		var names1 = new Array(getLabel("Common.practitionertype.label","Common"));
		var error_page = "../../eCommon/jsp/MstCodeError.jsp";
		
		if(!SpecialCharCheck(fields1,names1,messageFrame,"M", error_page))
		{
			document.forms[0].pract_type.focus();
			document.forms[0].pract_type.select();
			return false;
		}
		
		
	}
	*/
	if(parent.parent.f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
		var term_set_id=term[term.selectedIndex].value;
		parent.frames[2].location.href='../../eMR/jsp/TerminologySetForPractitionerTypeDynamicValues.jsp';
		parent.frames[1].location.href='../../eMR/jsp/TerminologySetForPractitionerTypeDetail.jsp?term_set_id='+term_set_id+'&fromSearch=true&pract_type_text='+encodeURIComponent(practType)+'&search_criteria='+document.forms[0].search_criteria.value;
		parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
	}
}
/*********************************************************/
function changeTerminology(){
	parent.frames[1].location.href='../../eCommon/html/blank.html';
}
/*********************************************************/
function submitPrevNext(from, to){
	
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
	if(document.forms[0].selectall.checked==true)
	document.getElementById("selectCHk").value='Y';


	
}	
	

function selectAll(Obj,start,end){

	if(Obj.checked){

		for(var i=start;i<=end;i++){
			if(eval("document.forms[0].select"+i))
			eval("document.forms[0].select"+i).checked=true;
			}
		// Below code was modified by Munisekhar on 18-Dec-2012 against SKR-SCF-0739 [IN:036606]
		 var term_set_id = document.forms[0].term_set_id.value;
		 var pract_type_text = document.forms[0].pract_type_text.value;
		 var search_criteria=document.forms[0].search_criteria.value;
		 var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='TerminologySetForPractitionerTypeDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='term_set_id' id='term_set_id' value='"+term_set_id+"'><input type='hidden' name='pract_type_text' id='pract_type_text' value='"+pract_type_text+"'><input type='hidden' name='search_criteria' id='search_criteria' value='"+search_criteria+"'></form></BODY></HTML>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal) ;
		parent.frames[2].document.form1.submit();
		document.getElementById("selectCHk").value='Y';
	}
	else{
		for(var i=start;i<=end;i++){
			if(eval("document.forms[0].select"+i))
			eval("document.forms[0].select"+i).checked=false;
			if(eval("document.forms[0].dftselect"+i)!=null)
			eval("document.forms[0].dftselect"+i).checked=false;
			}
		var term_set_id = document.forms[0].term_set_id.value;
	    var pract_type_text = document.forms[0].pract_type_text.value;
		var search_criteria=document.forms[0].search_criteria.value;
		var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='TerminologySetForPractitionerTypeDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'><input type='hidden' name='term_set_id' id='term_set_id' value='"+term_set_id+"'><input type='hidden' name='pract_type_text' id='pract_type_text' value='"+pract_type_text+"'><input type='hidden' name='search_criteria' id='search_criteria' value='"+search_criteria+"'></form></BODY></HTML>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.form1.submit();
		document.getElementById("selectCHk").value='N';
	}
}
//end SKR-SCF-0739 [IN:036606]
/*********************************************************/
function chkForSelectAll(start,end){
	if(parent.frames[2].document.forms[0].E.value == 'selectAll'){
		document.forms[0].selectall.checked=true;
		selectAll(document.forms[0].selectall,start,end)
	}
}



/*********************************************************/
function onuncheck(obj){
	var frmObj=document.forms[0];
	if(obj.checked == false)
		frmObj.selectall.checked=false;
}

function RemSelectAll(obj, i)
{
	
	document.forms[0].selectall.checked = false;

	if(obj.checked == false){
		eval("document.forms[0].removeCode"+i).value = "Y";
		eval("document.forms[0].dftselect"+i).checked = false;
	}
	else
	{
		eval("document.forms[0].removeCode"+i).value = "N";
	}
}


function SelectDefaultChk(obj,i){
	
	if(obj.checked == true){
		eval("document.forms[0].dftremoveCode"+i).value = "N";
		if(document.forms[0].selectall.checked==true)
	          document.getElementById("selectCHk").value='Y';
		eval("document.forms[0].select"+i).checked = true;
		
	}else{
		eval("document.forms[0].dftremoveCode"+i).value = "Y";
		/*eval("document.forms[0].select"+i).checked = false;
		eval("document.forms[0].selectall").checked = false;
		 document.getElementById("selectCHk").value='N';*/
	}

}



