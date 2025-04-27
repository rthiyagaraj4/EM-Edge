/*
*	Application		:	eMR
*	Created By		:	Bangarraju
*	Created On		:	10 Jan 2007
*/
var V = "";

function reset()
{	
    
	
	if(V=="C"||V=="Q"){
	if(f_term_code_set.document.forms[0])
	{
		f_term_code_set.document.forms[0].reset();
	
	}
	if(f_term_code_result.document.forms[0])
	{
		f_term_code_result.document.forms[0].reset();
	    f_term_code_result.document.location.href = "../../eCommon/html/blank.html";
	}
	
}
	if(V=="C"){

	f_term_selected_frms.document.location.href = "../../eCommon/html/blank.html";
	f_term_selected_frms.document.location.href = "../../eCommon/html/blank.html";
	f_term_code_set.document.forms[0].terminology_set.focus();
	

	}
}
 function checkIsValidForProceed()
{

	var url = f_term_code_result.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
function checkIfApply()
{
	var url=f_term_selected_frms.location.href;
	
	url=url.toLowerCase();
	if(url.indexOf("blank")==-1)
		return true;
	else
		return false;
}


function apply()
{

	if (! (checkIsValidForProceed())||(! checkIfApply()) )
    {
		

		message  = getMessage("APPLY_NOT_VALID",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
    } 

   var type_set=f_term_code_set.document.frm_terminology_code.type_set.value;
    if(f_term_code_set.document.frm_terminology_code!=null){
		
	if(f_term_code_set.document.frm_terminology_code.type_set.value=="")
	{
		var msg	=	getMessage("CAN_NOT_BE_BLANK","Common");
		msg	=	msg.replace("$",getLabel("eMR.CrossReferenceType.label","MR"));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
	  f_term_code_set.document.forms[0].reset();
	  
	} 
	
	if(f_term_code_set.document.frm_terminology_code.terminology_set.value=="")
	{
	  var msg	=	getMessage("TERM_SET_SHOULD_NOT_BE_BLANK","MR");
	  messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
	  return false ;
	} 
	equalform = f_term_code_result.document.term_code_result.equalform.value;
	if(equalform=="N"){
	message	=	getMessage("APPLY_NOT_VALID","MR");
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	return false;
	}
	if(equalform=="Y"){
		
	if(f_term_selected_frms.f_query_criteria.document.frm_terminology_code.terminology_set1.value=="")
	{
	  message  = getMessage("APPLY_NOT_VALID",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}}
	
	if(f_term_selected_frms.f_batch_result.document.term_code_result)
	{
		f_term_selected_frms.f_batch_result.document.term_code_result.action = "../../servlet/eMR.EquivalentTermCodeServlet?msg=y&obj=";
		f_term_selected_frms.f_batch_result.document.term_code_result.target = "messageFrame";
		f_term_selected_frms.f_batch_result.document.term_code_result.submit();
		onSuccess();
	
	}
	
   }
   else { 
          var message="";
          //message  = geteMRMessage("APPLY_NOT_VALID");
		  message	=	getMessage("APPLY_NOT_VALID","MR");
		  messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		  return false ;}
	
}
	
function onSuccess()
{
	var from = f_term_selected_frms.f_batch_result.document.term_code_result.from.value;
	var to = f_term_selected_frms.f_batch_result.document.term_code_result.to.value; 
	var termcode = f_term_selected_frms.f_batch_result.document.term_code_result.termsetid.value;
	var termdescription = f_term_selected_frms.f_batch_result.document.term_code_result.termdesc.value;
	var termsetid = f_term_selected_frms.f_batch_result.document.term_code_result.termsetid.value; 
	var search_criteria = f_term_selected_frms.f_batch_result.document.term_code_result.search_criteria.value;
	var codelevel = f_term_selected_frms.f_batch_result.document.term_code_result.codelevel.value;
	var FirstConbox = f_term_selected_frms.f_batch_result.document.term_code_result.FirstConbox.value;
	var SecondValue = f_term_selected_frms.f_batch_result.document.term_code_result.SecondValue.value;
	var ThirdConbox = f_term_selected_frms.f_batch_result.document.term_code_result.ThirdConbox.value;
	var type_set = f_term_selected_frms.f_batch_result.document.term_code_result.type_set.value;
	//f_term_selected_frms.f_batch_result.location.href="../../eMR/jsp/EquivalentTermCodeResult.jsp?termcode="+termcode+"&termsetid="+termsetid+"&termdesc="+termdescription+"&codelevel="+codelevel+"&search_criteria="+search_criteria+"&from="+from+"&to="+to+"&Terminology="+FirstConbox+"&termset_id="+SecondValue+"&ThirdConbox="+ThirdConbox+"&mr_term_set=N";
	f_term_code_result.document.location.href = "../../eMR/jsp/EquivalentTermCodeResult.jsp";
	//f_term_selected_frms.f_batch_result.document.location.href = "../../eMR/jsp/EquivalentTermCodeResult.jsp";
	f_term_code_set.document.frm_terminology_code.reset();
    f_term_code_set.document.frm_terminology_code.terminology_set.focus();
	f_term_selected_frms.document.location.href = "../../eCommon/html/blank.html";
	}


 function remchk(obj)
{

	
	document.term_code_result.chkall.checked = false;
	
	if(obj.checked)
		obj.value = "E";
	else
		obj.value = "D";

}

function chkallvall(obj,start,end)
{      
   
	var formObj	= document.term_code_result;
	if(obj.checked)
	{
		
		document.term_code_result.selectall.value = "SELECTALL";
	}
	else
	{
		document.term_code_result.selectall.value = "";
	}
    
	if(document.term_code_result.selectall.value=="SELECTALL")
	{   
		for(var i=start;i<=end;i++)
		{  
			
			if(eval("document.term_code_result.chks_factor"+i))
			{ 
				eval("document.term_code_result.chks_factor"+i).checked=true;
				eval("document.term_code_result.chks_factor"+i).value="U";
			}
		}
	
	}
	
	else
	{
		for(var i=start;i<=end;i++)
		{
			if(eval("document.term_code_result.chks_factor"+i))
			{
				eval("document.term_code_result.chks_factor"+i).checked=false;
				eval("document.term_code_result.chks_factor"+i).value="I";
			}
		}
		
	}
}

function query()
{	V='Q'
//	Equal_term_code_set.rows = "8%,*,0,0,8%";

	document.getElementById("f_term_code_set").style.height = "57vh";
	f_term_code_set.location.href="../../eMR/jsp/EquivalentTermCodeSetQueryCriteria.jsp";
	f_term_code_result.location.href = "../../eCommon/html/blank.html";
	f_term_selected_frms.location.href = "../../eCommon/html/blank.html";
}  

function create(){
	V='C'
//  Equal_term_code_set.rows = "8%,13%,36%,*,8%";

	document.getElementById("f_term_code_set").style.height = "16vh";
	document.getElementById("f_term_code_result").style.height = "27vh";
	document.getElementById("f_term_selected_frms").style.height = "39vh";
	
	f_term_code_result.location.href = "../../eCommon/html/blank.html";
	f_term_selected_frms.location.href = "../../eCommon/html/blank.html";
	f_term_code_set.location.href="../../eMR/jsp/EquivalentTermCodeMain.jsp";
	
}
/*Tuesday, February 16, 2010 18717 , to filter terminology set a/c to cross ref type*/
function callTermSet(obj)
{
		var length = parent.frames[1].document.forms[0].terminology_set.length

		for(var i=0;i<length;i++)
		{
			parent.frames[1].document.forms[0].terminology_set.remove(1);
		}
	
		htmlval = "<html><body onKeyDown='lockKey()'><form name='MRvalidate' id='MRvalidate' method='post' action='../../eMR/jsp/RetICDDescVal.jsp'><input type='hidden' name='cross_ref_type' id='cross_ref_type' value='"+obj.value+"'><input type='hidden' name='call_func' id='call_func' value='cross_ref_rule'></input> </form></body></html>";
	
		parent.frames[4].document.body.insertAdjacentHTML('afterbegin',htmlval);
		parent.frames[4].document.MRvalidate.submit();
		
}

