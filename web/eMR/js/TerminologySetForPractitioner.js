function create()
 {
	f_query_add_mod.location.href="../../eMR/jsp/TerminologySetForPractitionerFrameSet.jsp";
 }

function searchDetails()
  {

	 parent.frames[1].location.href='../../eCommon/html/blank.html';	
	  var frmobj=parent.f_query_header.document.form_add_mod ;
	  var fields = new Array (frmobj.term_set_id);			    
	  var names = new Array (getLabel("Common.TerminologySet.label","Common"));	
	  var	msgFrame=parent.parent.messageFrame;
	  var pract_desc=document.forms[0].pract_desc.value;
	  if(pract_desc.indexOf("'")!=-1)
		{			
			pract_desc = pract_desc.replace("'","''");
		}
	  /*
	  if(document.forms[0].pract_desc.value!='')
		{
			var fields1 = new Array(document.forms[0].pract_desc);
			var names1 = new Array(getLabel("Common.practitioner.label","Common"));
			var error_page = "../../eCommon/jsp/MstCodeError.jsp";
			
			if(!SpecialCharCheck(fields1,names1,msgFrame,"M", error_page))
			{
				document.forms[0].pract_desc.focus();
				document.forms[0].pract_desc.select();
				return false;
			}
		}
		*/
	  if(parent.f_query_header.checkFieldsofMst( fields, names, msgFrame))
		{	
	    	parent.parent.messageFrame.location.href= "../../eCommon/jsp/error.jsp"+"";	
		    parent.frames[1].location.href='../../eMR/jsp/TerminologySetForPractitionerDetail.jsp?term_set_id='+frmobj.term_set_id.value+'&pract_type='+frmobj.pract_type.value+'&fromSearch=true&pract_desc_text='+encodeURIComponent(pract_desc)+'&search_criteria='+document.forms[0].search_criteria.value;
		  	parent.frames[2].location.href='../../eMR/jsp/TerminologySetForPractitionerDynamicValues.jsp';
		}
  }

function clearDetail()
{
parent.frames[1].location.href='../../eCommon/html/blank.html';
}

function query()
{
	frames[1].location.href='../../eMR/jsp/TerminologySetForPractitionerQueryCriteria.jsp';
}

function reset()
{
	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1) {
		if(url.indexOf("Query")==-1){
				parent.frames[2].frames[1].f_query_header.document.forms[0].reset();
				parent.frames[2].frames[1].f_query_header.document.forms[0].elements[0].focus();
				parent.frames[2].frames[1].f_query_detail.location.href='../../eCommon/html/blank.html';
				parent.frames[2].frames[1].Dummy.location.href='../../eCommon/html/blank.html';
		}else
			parent.frames[2].frames[1].document.forms[0].reset();
	}
}

function apply()
{
	if (! checkIsValidForProceed() ) {
		message  = getMessage("APPLY_NOT_VALID",'MR');
		frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	 if (!checkIsValidForProceed1()){
		message  = getMessage("APPLY_NOT_VALID",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed2()){
		message  = getMessage("APPLY_NOT_VALID",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	
	parent.frames[2].frames[1].frames[1].document.forms[0].allValues.value=parent.frames[2].frames[1].frames[2].document.forms[0].E.value;
	parent.frames[2].frames[1].frames[1].document.forms[0].action="../../servlet/eMR.TerminologySetForPractionerServlet";
	parent.frames[2].frames[1].frames[1].document.forms[0].target="messageFrame";
	parent.frames[2].frames[1].frames[1].document.forms[0].submit();
	
	
}

function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}

function checkIsValidForProceed1()
{		var url = f_query_add_mod.f_query_header.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}
function checkIsValidForProceed2()
{		var url = f_query_add_mod.f_query_detail.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}

function onSuccess() 
{

	parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[0].location.reload();
}


       
	function submitPrevNext(from, to){
		
			if(document.getElementById("chkAll").checked==true)
			document.forms[0].selctAllCHk.value='Y';
			else
				document.forms[0].selctAllCHk.value='N';


	    document.forms[0].from.value = from;
	    document.forms[0].to.value = to; 
	    document.forms[0].submit();
		

		
	}

function unSelectAll(obj, i){
	
	document.forms[0].chkAll.checked=false;
	if(obj.checked == false){
		eval("document.forms[0].removeCode"+i).value = "Y";
		eval("document.forms[0].dftselect"+i).checked = false;

	}
	else
	{
		eval("document.forms[0].removeCode"+i).value = "N";
		
	}
}
function submitForm(){
	var term_set_id = document.forms[0].term_set_id.value;
				var pract_type = document.forms[0].pract_type.value;

	var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='TerminologySetForPractitionerDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='term_set_id' id='term_set_id' value='"+term_set_id+"'><input type='hidden' name='pract_type' id='pract_type' value='"+pract_type+"'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.form1.submit();

}
function submitForm1(){
	var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='TerminologySetForPractitionerDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.form1.submit();

}

function selectAll(Obj,start,end)
{
	if(Obj.checked)
	{
		document.forms[0].chkAll.value="Y";
	for(var i=start;i<=end;i++)
		{
		if(eval("document.forms[0].chk"+i))
		eval("document.forms[0].chk"+i).checked=true;
		}
        // Below code was modified by Munisekhar on 18-Dec-2012 against SKR-SCF-0739 [IN:036606] 
		//setTimeout('submitForm()',1000);
		var term_set_id = document.forms[0].term_set_id.value;
				var pract_type = document.forms[0].pract_type.value;
				var pract_name = document.forms[0].pract_desc_text.value;
				var search_criteria = document.forms[0].search_criteria.value;

	var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='TerminologySetForPractitionerDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='term_set_id' id='term_set_id' value='"+term_set_id+"'><input type='hidden' name='pract_type' id='pract_type' value='"+pract_type+"'><input type='hidden' name='pract_name' id='pract_name' value='"+pract_name+"'><input type='hidden' name='search_criteria' id='search_criteria' value='"+search_criteria+"'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.form1.submit();
	document.getElementById("selctAllCHk").value="Y";
		
	}
	else
	{
		document.forms[0].chkAll.value="N";
		for(var i=start;i<=end;i++)
			{
			if(eval("document.forms[0].chk"+i))
			eval("document.forms[0].chk"+i).checked=false;
			if(eval("document.forms[0].dftselect"+i))
			eval("document.forms[0].dftselect"+i).checked=false;


			}
			//setTimeout('submitForm1()',1000);
			var term_set_id = document.forms[0].term_set_id.value;
				var pract_type = document.forms[0].pract_type.value;
				var pract_name = document.forms[0].pract_desc_text.value;
				var search_criteria = document.forms[0].search_criteria.value;
			var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='TerminologySetForPractitionerDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'><input type='hidden' name='term_set_id' id='term_set_id' value='"+term_set_id+"'><input type='hidden' name='pract_type' id='pract_type' value='"+pract_type+"'><input type='hidden' name='pract_name' id='pract_name' value='"+pract_name+"'><input type='hidden' name='search_criteria' id='search_criteria' value='"+search_criteria+"'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.form1.submit();
	
	
	}
}
//end SKR-SCF-0739 [IN:036606] 

function chkForSelectAll(start,end)
{
	if(parent.frames[2].document.forms[0].E.value == 'selectAll')
	{
	document.forms[0].chkAll.checked=true;	
	selectAll(document.forms[0].chkAll,start,end)
	}

}
function SelectDefaultChk(obj,i){
	
	if(obj.checked == true){
		eval("document.forms[0].dftremoveCode"+i).value = "N";
		eval("document.forms[0].chk"+i).checked = true;
	}else{
		eval("document.forms[0].dftremoveCode"+i).value = "Y";
		
		

	}

}

