 //This file is saved on 21/12/2005.

function create()
{
	f_query_add_mod.location.href="../../eCP/jsp/AssessBasedDepClassficationFrameSet.jsp";
}
/*********************************************************************************************/
function query()
{
	f_query_add_mod.location.href="../../eCP/jsp/AssessBasedDepClassficationQueryCriteria.jsp";
}
/********************************************************************************************/
function reset(){
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
//*************************************************************************/

function apply()
{ 
	if (! checkIsValidForProceed() ) {
		message  =getMessage("APPLY_NOT_VALID","CP");
		frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	 if (!checkIsValidForProceed1()){
		message  =getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed2()){
		
		//message  =getMessage("APPLY_NOT_VALID","CP");
		//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;   ----commented on 17/11/08------
		var frmobj=f_query_add_mod.f_query_header.document.form_AssessBased;
		var fields = new Array (frmobj.assess_note_desc);
		var names = new Array (getLabel("eCP.AssessmentNote.label","CP"))
		if(f_query_add_mod.f_query_header.checkFieldsofMst( fields, names, messageFrame))
		parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";




		return false ;
	}
	var frmobj=f_query_add_mod.frames[1].document.forms[0];
	var maxRecord=frmobj.maxRecord.value;
	var start=frmobj.start.value;
	var end=frmobj.end.value;

	if(parseInt(end) > parseInt(maxRecord))
	{
		end=maxRecord;
	}
	var i=0;

	for(i=start;i<=end;i++)
	{
		var minScore=eval("frmobj.minScore"+i).value;
		if(eval("frmobj.chk"+i).checked==true)
		 {
             if( minScore=='' || minScore=='0' || minScore=='00' || minScore=='000')
			 {
    	        var message=getMessage("MIN_SCORE_MANDATORY","CP");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				eval("frmobj.minScore"+i).focus();
				eval("frmobj.minScore"+i).select();
	    		return false;
			 }
		}
	}

	parent.frames[2].frames[1].frames[1].document.forms[0].action="../../servlet/eCP.AssessBasedDepClassificationServlet";
	parent.frames[2].frames[1].frames[1].document.forms[0].target="messageFrame";
	parent.frames[2].frames[1].frames[1].document.forms[0].submit();
}

/*****************************************************************************************/
 function onSuccess()
   {
	    parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
		parent.frames[2].frames[1].frames[0].location.reload();
  }

//*********************************************************************************************/
function searchDetails()
  {
	   
	  var frmobj=parent.f_query_header.document.forms[0] ;
	  var fields = new Array (frmobj.assess_note_desc);
	  var names = new Array (getLabel("eCP.AssessmentNote.label","CP"));
	  var msgFrame=parent.parent.messageFrame;
	  if(parent.f_query_header.checkFieldsofMst( fields, names, msgFrame))
		{	
		   parent.frames[1].location.href='../../eCP/jsp/AssessBasedDepClassficationDetail.jsp?assess_note_id='+frmobj.assess_note_id.value+'&fromSearch=true';		

		}
  }
//*************************************************************************************************

async function selectMaxMin(target)
{
	var frmobj=parent.f_query_header.document.form_AssessBased ;
	frmobj.assess_note_desc.value="";
	frmobj.assess_note_id.value="";
	 var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	dataNameArray[0] = "locale";
	dataValueArray[0]= frmobj.locale.value;
	dataTypeArray[0] = STRING;
 	argumentArray[0] ="Select assess_note_id code, assess_note_desc description from cp_assess_note_lang_vw where eff_status ='E' and language_id like ? AND UPPER(assess_note_id) LIKE UPPER(?) AND UPPER(assess_note_desc) LIKE UPPER(?) ORDER BY assess_note_desc";
	
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,3"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal =await CommonLookup(getLabel("eCP.AssessmentNote.label","CP"), argumentArray );

		if(retVal != null && retVal != "") {
			var ret1=unescape(retVal);
			 var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
					arr[0]="";	
					arr[1]="";	
				}
			target.value = arr[1] ;
			var assess_note_desc= arr[1] ;

			document.forms[0].assess_note_id.value = arr[0];
			var assess_note_id=arr[0];
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			//to get the period for selected requirement
			xmlHttp.open( "POST","../../eCP/jsp/AssessBasedDepClassficationDynamicValues.jsp?assess_note_id="+assess_note_id+"&assess_note_desc="+assess_note_desc+"&flag=disp", false);
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText);
			
		}else
			target.value ="";
		 parent.frames[1].location.href='../../eCommon/html/blank.html';
}
/************************************************************************************/
function assignMinMax(min_score ,max_score){
	var frmObj=parent.frames[0].document.form_AssessBased;
	var max_score=max_score;
	var min_score=min_score;
	frmObj.min_score.value=min_score;
	frmObj.max_score.value=max_score;
}

/************************************************************************************/
function displayMaxMin(obj1,obj2){
	var frmObj=parent.frames[0].document.form_AssessBased;
	var min_score=frmObj.min_score.value;
	var max_score=frmObj.max_score.value;
	obj1.innerText=" "+min_score;
	obj2.innerText=" "+max_score;
	obj1.style.fontWeight = "bolder";
	obj2.style.fontWeight = "bolder";
}

/****************************************************************************************/
function allowPositiveNumber() {
   var key = window.event.keyCode;// allows only numbers to be entered
   if((key<48 )||(key>58)) {
	   return false;
   }
}

/****************************************************************************************/
function CheckMin(target)
{
	var value = target.value;
	
	if(value == "0" || value == "00" || value=="000")
	{
		message=getMessage("VALUE_GT_ZERO","CP");
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		target.focus();
		target.select();
	 return false;
	}
	else
		return true;
}

/****************************************************************************************/

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
/**************************************************************************************/
function clearScore(obj, minscore){
	if(obj.checked == false){
		minscore.value="";
	}
}
/**************************************************************************************/
function submitPrevNext(obj,from,to)
{
	    var frmobj=document.forms[0];
		var start=frmobj.start.value;
		var end=frmobj.end.value;
		var maxRecord=frmobj.maxRecord.value;
		var i=parseInt(0);
		var k=parseInt(0);
		var count=parseInt(0);
		
		var assess_note_id=parent.frames[0].document.forms[0].assess_note_id.value;
		
		if(parseInt(end)>parseInt(maxRecord))
			end=maxRecord;

		for(i=start;i<=end;i++)
     	{
		 var minScore=eval("frmobj.minScore"+i).value;
		 if(eval("frmobj.chk"+i).checked==true)
		 {
             if( minScore=='' || minScore=='0' || minScore=='00' || minScore=='000')
			 {
				k++;
			 }
		 }
		}

		if(k>0)
    	{
         var message=getMessage("MIN_SCORE_MANDATORY","CP");
		 alert(message);
		}
		else if(k==0)
		{
    	 if(obj=='next')
		 {
	        frmobj.from.value = parseInt(from+10);
	        frmobj.to.value = parseInt(to+10);
		 }
		 else
    	 {
		  frmobj.from.value = parseInt(from-10);
		  frmobj.to.value = parseInt(to-10); 
		 }
		 frmobj.submit();
 	   }
}
/**************************************************************************************/
	
