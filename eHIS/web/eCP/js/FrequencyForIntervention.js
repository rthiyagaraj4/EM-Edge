//This file is saved on 18/10/2005



var message="";


function create()
{
	f_query_add_mod.location.href="../../eCP/jsp/FrequencyForInterventionFrameSet.jsp";
}
//*****************************************************************************************
function query()
{
	f_query_add_mod.location.href="../../eCP/jsp/FrequencyForInterventionQueryCriteria.jsp";
}

//*****************************************************************************************

function reset()
{
	
	var url=f_query_add_mod.location.href;
	
	if(url.indexOf("blank")==-1) {
		if(url.indexOf("Query")==-1){
				parent.frames[2].frames[1].f_query_header.document.forms[0].reset();				
				parent.frames[2].frames[1].f_query_detail.location.href='../../eCommon/html/blank.html';
		}else
			parent.frames[2].frames[1].document.forms[0].reset();
	}	
}

//*****************************************************************************************

function searchDetails()
{
      parent.frames[2].location.href='../../eCP/jsp/FrequencyForInterventionDynamicValues.jsp';		
      var frmobj=parent.f_query_header.document.form_add_mod ;
      var fields = new Array (frmobj.frequency);	
      var names = new Array (getLabel("Common.Frequency.label","Common"));	
      var msgFrame=parent.parent.messageFrame;

      if(parent.f_query_header.checkFieldsofMst( fields, names, msgFrame))
      {	
        parent.frames[1].location.href='../../eCP/jsp/FrequencyForInterventionDetail.jsp?frequency_code='+frmobj.frequency.value+'&fromSearch=true';
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';	
      }
}

//*****************************************************************************************
function chkForSelectAll(start,end){
	if(parent.frames[2].document.forms[0].E.value == 'selectAll'){
		document.forms[0].selectall.checked=true;
		//alert(document.forms[0].selectall.checked);
		selectAll(document.forms[0].selectall,start,end)
	}
}
function submitPrevNext(from, to)
	{
	    document.forms[0].from.value = from;
	    document.forms[0].to.value = to; 
	    document.forms[0].submit();
	}
function selectAll(Obj,start,end)
{
	if(Obj.checked)
	{
	for(var i=start;i<=end;i++)
		{
		if(eval("document.forms[0].chk"+i))
		eval("document.forms[0].chk"+i).checked=true;
		}
	var frequency_code = document.forms[0].frequency_code.value;
	var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='FrequencyForInterventionDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='frequency_code' id='frequency_code' value='"+frequency_code+"'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.form1.submit();
	}
	else
	{
		for(var i=start;i<=end;i++)
			{
			if(eval("document.forms[0].chk"+i))
			eval("document.forms[0].chk"+i).checked=false;
			}
	
	var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='FrequencyForInterventionDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.form1.submit();
	}
}

//*****************************************************************************************
function viewFrequencyGroup(target)
{
        var frmobj=parent.f_query_header.document.form_add_mod ;

	frmobj.frequency_desc.value="";
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

 	argumentArray[0] ="select  freq_code code,  freq_desc  description from am_frequency  where eff_status ='E' AND UPPER(freq_code) LIKE UPPER(?) AND UPPER(freq_desc) LIKE UPPER(?) ORDER BY freq_desc";
	
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = CommonLookup(getLabel("Common.Frequency.label","Common"), argumentArray );
		if(retVal != null && retVal != "") {
			target.value = retVal[1] ;
			document.forms[0].frequency_code.value = retVal[0];
			
		}else
			target.value ="";
}

//*****************************************************************************************
function apply()
{
        if (! checkIsValidForProceed() ) 
	{
		message  =getMessage("APPLY_NOT_VALID","CP");
		frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	 if (!checkIsValidForProceed1()){
		message  = " ";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed2()){
		message  = " ";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	parent.frames[2].frames[1].frames[1].document.forms[0].allValues.value=parent.frames[2].frames[1].frames[2].document.forms[0].E.value;
	parent.frames[2].frames[1].frames[1].document.forms[0].action="../../servlet/eCP.FrequencyForInterventionServlet";
	parent.frames[2].frames[1].frames[1].document.forms[0].target="messageFrame";
	parent.frames[2].frames[1].frames[1].document.forms[0].submit();
}
//******************************************************************************************************
function onSuccess() 
{
	parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[0].location.reload();
}

//******************************************************************************************************
function checkIsValidForProceed()
{
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
//******************************************************************************************************

function checkIsValidForProceed1()
{		var url = f_query_add_mod.f_query_header.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
         		return true;
		else
			return false;
}

//******************************************************************************************************
function checkIsValidForProceed2()
{		var url = f_query_add_mod.f_query_detail.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}

//******************************************************************************************************
function clearDetail()
{
parent.frames[1].location.href='../../eCommon/html/blank.html';
}
//******************************************************************************************************

