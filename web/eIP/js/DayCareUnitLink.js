function create() 
{
	//f_query_add_mod.location.href = "../../eIP/jsp/DayCareUnitMain.jsp?param=create&called_from=6" ;//called_from=6 to designate call from DayCareUnit
	var paramStr = "../../eIP/jsp/DayCareUnitMain.jsp?param=create&called_from=6";
	var params = (f_query_add_mod.location.href).split('&');

		for (i=1;i<params.length ;++i )
		{
			if 	(params[i].indexOf('function_id')>-1)
			{
				paramStr = paramStr + '&' + params[i];
			}
		}

	f_query_add_mod.location.href = paramStr ;
}

function reset()
{
	 if (! (checkIsValidForProceed())){
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}else{
	var loc=frames[1].document.forms[0]

	if (loc!=null )
	{
			f_query_add_mod.document.forms[0].reset();
	}
	else  if(frames[1].frames[0])
	{
		
		create();
	}
	}
}

function query() 
{
	//f_query_add_mod.location.href ="../../eIP/jsp/DayCareUnitLinkCriteria.jsp" ;
//	var paramStr = "../../eIP/jsp/DayCareUnitLinkCriteria.jsp?param=create&called_from=1";
	var paramStr = "../../eIP/jsp/DayCareUnitLinkCriteria.jsp?param=query&called_from=6";
	var params = (f_query_add_mod.location.href).split('&');

		for (i=1;i<params.length ;++i )
		{
			if 	(params[i].indexOf('function_id')>-1)
			{
				paramStr = paramStr + '&' + params[i];
			}
		}

	f_query_add_mod.location.href = paramStr ;
}
function checkIsValidForProceed(){
	var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
}
function apply()
{
	if (! (checkIsValidForProceed())){
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
	else
	{
		//if(parent.frames[1].frames[1].frames[0].document.forms[0].nursing_unit_desc.value == "")
		if(frames[1].frames[0].document.forms[0].nursing_unit_desc.value == "")
		{
			var msg = getMessage('NU_NOTNULL','IP');
			messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=0' ;
		}
		else
		{
			//parent.frames[1].frames[1].frames[1].document.forms[0].allValues.value = parent.frames[1].frames[1].frames[2].document.forms[0].E.value;	

			if(frames[1].frames[0].document.forms[0].statusval.value !="")
			{
				frames[1].frames[1].document.forms[0].allValues.value = frames[1].frames[2].document.forms[0].E.value;	
				//parent.frames[1].frames[1].frames[1].document.forms[0].action="../../servlet/eIP.DaycareUnitServlet";
				frames[1].frames[1].document.forms[0].action="../../servlet/eIP.DaycareUnitServlet";
				//parent.frames[1].frames[1].frames[1].document.forms[0].target="messageFrame";
				frames[1].frames[1].document.forms[0].target="messageFrame";
				//parent.frames[1].frames[1].frames[1].document.forms[0].submit();
				frames[1].frames[1].document.forms[0].submit();
			}
			else
			{
				messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
				return false;
			}
		}
	}
}

function onSuccess() 
{
	frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	frames[1].frames[0].location.reload();
}

//functions from addModifyDayCareUnitLink.jsp

function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}


function RemSelectAll(obj,i)
{
//	document.forms[0].chkAll.checked = false;

	if(obj.checked == false)
		eval("document.forms[0].removeCode"+i).value = "Y";
	else
		eval("document.forms[0].removeCode"+i).value = "N";
}

function selectAll(Obj,start,end)
{
	if(Obj.checked)
	{
		for(var i=start;i<=end;i++)
		{
			if(eval("document.forms[0].chk"+i))
			{
			 	eval("document.forms[0].chk"+i).checked=true;
			}
		}

		var search_by = parent.frames[1].document.forms[0].search_by.value;
		var search_txt = parent.frames[1].document.forms[0].search_txt.value;

		var nursing_unit_code = document.forms[0].nursing_unit_code.value;

		var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='DayCareUnitPopulate.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='search_by' id='search_by' value='"+search_by+"'><input type='hidden' name='search_txt' id='search_txt' value='"+search_txt+"'><input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value='"+nursing_unit_code+"'></form></BODY></HTML>";
		
		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.form1.submit();
	}
	else
	{
		for(var i=start;i<=end;i++)
		{
			if(eval("document.forms[0].chk"+i))
			eval("document.forms[0].chk"+i).checked=false;
 		}
	
		var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='DayCareUnitPopulate.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'></form></BODY></HTML>";
		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.form1.submit();
	}
}
function chkForSelectAll(start,end)
{
	if(parent.frames[2].document.forms[0].E.value == 'selectAll')
	{
		document.forms[0].chkAll.checked=true;
		selectAll(document.forms[0].chkAll,start,end)
	}

}
function checkdis(obj)
{
	if (obj.checked==false)
	{
	 var i = obj.name.substring(3);
	 var nursing_unit_code = document.forms[0].nursing_unit_code.value;
	 var clinic = eval("document.forms[0].chk"+i).value;
	 var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='DayCareUnitPopulate.jsp'><input type='hidden' name='clinic_code' id='clinic_code' value='"+clinic+"'><input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value='"+nursing_unit_code+"'><input type='hidden' name='cc' id='cc' value='"+i+"'></form></BODY></HTML>";
	 parent.frames[2].document.write(HTMLVal);
	 parent.frames[2].document.form1.submit();
	}
} 

