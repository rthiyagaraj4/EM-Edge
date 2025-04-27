function create()
{
	// parent.frames[2].document.getElementById("custom_terminology").rows="42,100,*,50";
	document.getElementById("f_query_add_mod").style.height = "20vh" ;
	document.getElementById("customResultFrame").style.height = "63vh" ;
	f_query_add_mod.location.href="../../eMR/jsp/CustomListTerminologyGroupAddModify.jsp?mode=1";
	frames[2].location.href="../../eCommon/html/blank.html";
	frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp";
}



function query()
{
	//alert(parent.parent.frames[3].document.getElementById("custom_terminology").name);
//	parent.frames[2].document.getElementById("custom_terminology").rows="42,*,100,50";
	document.getElementById("f_query_add_mod").style.height= "65vh" ;
	document.getElementById("customResultFrame").style.height = "19vh" ;

	f_query_add_mod.location.href="../../eMR/jsp/CustomListTerminologyGroupQueryCriteria.jsp";
	customResultFrame.location.href="../../eCommon/html/blank.html";
	messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}


function reset()
{
	parent.frames[2].frames[1].document.location.reload();
	customResultFrame.location.href="../../eCommon/html/blank.html";
	messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}

function setTermSet()
{
	var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='term_set_form' id='term_set_form' method='post' action='../../eMR/jsp/populateTerminologyGroupValues.jsp'>"+" <input type='hidden' name='term_grp_id' id='term_grp_id' value='"+document.forms[0].term_group.value+"'></form></body></html>";
	parent.frames[3].document.write(HTMLVal);
	parent.frames[3].document.term_set_form.submit();
	parent.frames[2].location.href="../../eCommon/html/blank.html"; // for 17211
 
}
//  start FOR 17211:-- modified by Venkats Modified on 15/12/09-

function onTermSet()
{
	parent.frames[2].location.href="../../eCommon/html/blank.html";
}

function onIndexType()
{
	parent.frames[2].location.href="../../eCommon/html/blank.html";
}
// end 17211

function search_index_type()
{
	var fields = new Array (parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.term_group,
					parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.term_set,
					parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.index_type);
	var names = new Array (getLabel("eMR.TerminologyGroup.label","MR"),getLabel("Common.TermSetID.label","Common"),getLabel("Common.IndexType.label","Common"));

	if(parent.frames[1].checkFieldsofMst( fields, names, parent.frames[3])) 
		{ 
		// FOR 17211:-- modified by Venkats Modified on 15/12/09

		//parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.term_group.disabled = true;
		//parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.term_set.disabled = true;
		//parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.index_type.disabled = true;	
		//parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.index_desc.disabled = true;	
		//parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.search_criteria.disabled = true;	
		//parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.custom_list_enable_YN.disabled = true;
		//parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.search.disabled = true;\

		var indexSearch=parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.index_desc.value;
		if(indexSearch.indexOf("'")!=-1)
		{			
			indexSearch = indexSearch.replace("'","''");
		}
		
			parent.frames[2].location.href='../../eMR/jsp/CustomListTerminologyGroupAddModifyDetail.jsp?mode=1&term_grp_id='+parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.term_group.value+'&term_set_id='+parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.term_set.value+'&index_type='+parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.index_type.value+'&fromSearch=selectedrecord&function_name=insert&search_criteria='+parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.search_criteria.value+'&index_desc='+encodeURIComponent(indexSearch);
			parent.frames[3].location.href='../../eCommon/jsp/MstCodeError.jsp';
		}
		

}

function submitPrevNext(from, to)
	{
	    document.forms[0].from.value = from;
	    document.forms[0].to.value = to; 
	    document.forms[0].submit();
	}

//Modified against ARYU-SCF-0115 by Shanmukh on 6th-Mar-2018
function selectAll(Obj,start,end,searchval,indexdesc)
{
	//alert('selecting all');
	if(Obj.checked)
	{
		//alert('in notCleared case');
		for(var i=start;i<=end;i++)
				{
				if(eval("document.forms[0].chk"+i))
					{
						eval("document.forms[0].chk"+i).checked=true;
						//eval("document.forms[0].chk"+i).value="checked";
						eval("document.forms[0].removeCode"+i).value = "N"; 
					}
				}
				//document.forms[0].isSelect.value='notCleared';

				//alert('going to not cleared mode');
				//Modified against ARYU-SCF-0115 by Shanmukh on 6th-Mar-2018
				var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='populateTerminologyGroupValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='index_type' id='index_type' value='"+document.forms[0].index_type.value+"'><input type='hidden' name='searchval' id='searchval' value='"+searchval+"'><input type='hidden' name='indexdesc' id='indexdesc' value='"+indexdesc+"'></form></BODY></HTML>";
				
				//parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				parent.frames[3].document.write(HTMLVal)
				parent.frames[3].document.form1.submit();


	}
	else
	{
		//alert('in clearall case');
		for(var i=start;i<=end;i++)
				{
				if(eval("document.forms[0].chk"+i))
					{
						eval("document.forms[0].chk"+i).checked=false;
						//eval("document.forms[0].chk"+i).value="unchecked";
						eval("document.forms[0].removeCode"+i).value = "Y"; 
					}
				}
				//document.forms[0].isSelect.value='clearAll';
				//alert('going to  cleared mode');
			
				var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='populateTerminologyGroupValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'><input type='hidden' name='index_type' id='index_type' value='"+document.forms[0].index_type.value+"'></form></BODY></HTML>";
				
				//parent.frames[3].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				parent.frames[3].document.write(HTMLVal);
				parent.frames[3].document.form1.submit();			
	}
}
function apply()
{
		
		if(parent.frames[2].frames[2].document.location.href.indexOf("eCommon/html/blank.html")!=-1)
		{
				var message = getMessage("APPLY_NOT_VALID","MR");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
//				parent.frames[1].frames[0].document.location.reload();
				return false;
		}
		else
		{
			parent.frames[2].frames[2].document.forms[0].action="../../servlet/eMR.CustomlistTerminologyGroupServlet";
			parent.frames[2].frames[2].document.forms[0].target="messageFrame";
			parent.frames[2].frames[2].document.forms[0].submit();
		}
	
}

function setCheckUncheck(Obj,i)
{
	
	if(Obj.checked == false)
		eval("document.forms[0].removeCode"+i).value = "Y";
	else
		eval("document.forms[0].removeCode"+i).value = "N";
	
	/*if(Obj.checked)
	{
		Obj.checked=true;
	}
	else
	{
		Obj.checked=false;
	}*/
}

/*function setEffect_Status(Obj)
{
	if(Obj.checked)
		Obj.value = "E";
	else
		Obj.value = "D";
}*/

//Modified against ARYU-SCF-0115 by Shanmukh on 6th-Mar-2018
function chkForSelectAll(start,end,searchval,indexdesc)
{
	//alert('parent.frames[3].document.forms[0].isSelect.value:'+parent.frames[3].document.forms[0].isSelect.value);
	//alert("parent.frames[3].document.forms[0].isSelect.value:"+parent.frames[3].document.forms[0].isSelect.value);
	if(parent.frames[3].document.forms[0]!=null)
		if(parent.frames[3].document.forms[0].isSelect.value == 'notCleared')
		{
			//alert("going to select all");
			document.forms[0].chkAll.checked=true;
			//Modified against ARYU-SCF-0115 by Shanmukh on 6th-Mar-2018
			selectAll(document.forms[0].chkAll,start,end,searchval,indexdesc);
		}
	
}

function RemSelectAll()
{
	//alert('here');
	document.forms[0].chkAll.checked = false;
	if(parent.frames[3].document.forms[0]!=null)
		parent.frames[3].document.forms[0].isSelect.value = '';
}

function onSuccess()
{
	
	parent.frames[2].frames[1].document.location.reload();
	parent.frames[2].frames[2].location.href="../../eCommon/html/blank.html";

}
function enableCriteria()
{
	alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
	parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.term_group.disabled = false;
	parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.term_set.disabled = false;
	parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.index_type.disabled = false;	
	parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.index_desc.disabled = false;	
	parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.search_criteria.disabled = false;	
	parent.frames[1].document.addModifyCustomListTerminologyGroupAddModify.search.disabled = false;

}
function CheckForSpecChars_term(event){
    var strCheck = '"';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return true;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return false ;
}

