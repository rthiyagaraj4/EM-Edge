function apply()
{
	

	//if(parent.frames[1].frames[1].frames[0].document.forms[0].nursing_unit_desc.value == "")
	if(frames[1].frames[0].document.forms[0].nursing_unit_desc.value == "")
	{
		var msg = getMessage('NU_NOTNULL','IP');
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=0' ;
	}
	else
	{
			//parent.frames[1].frames[1].frames[1].document.forms[0].allValues.value=parent.frames[1].frames[1].frames[2].document.forms[0].ServiceObj.value;
	     frames[1].frames[1].document.forms[0].allValues.value=frames[1].frames[2].document.forms[0].ServiceObj.value;
		//parent.frames[1].frames[1].frames[1].document.forms[0].action="../../servlet/eIP.NursUnitServiceServlet";
		frames[1].frames[1].document.forms[0].action="../../servlet/eIP.NursUnitServiceServlet";
		
		//parent.frames[1].frames[1].frames[1].document.forms[0].target="messageFrame";
		frames[1].frames[1].document.forms[0].target="messageFrame";
		//parent.frames[1].frames[1].frames[1].document.forms[0].submit();
		frames[1].frames[1].document.forms[0].submit();
	}
}

function create() {
	
	//f_query_add_mod.location.href = "../../eIP/jsp/NursingUnitMain.jsp?param=create&called_from=5" ;
	var paramStr = "../../eIP/jsp/NursingUnitMain.jsp?param=create&called_from=5" ;
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

function query() {
	f_query_add_mod.location.href ="../../eIP/jsp/NursUnitServiceQueryCriteria.jsp" ;
	/*var paramStr = "../../eIP/jsp/NursUnitServiceQueryCriteria.jsp";
	var params = (f_query_add_mod.location.href).split('&');

		for (i=1;i<params.length ;++i )
		{
			if 	(params[i].indexOf('function_id')>-1)
			{
				paramStr = paramStr + '&' + params[i];
			}
		}

	f_query_add_mod.location.href = paramStr ;*/
}

function reset()
{
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
function onSuccess() {
	//parent.frames[1].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	//parent.frames[1].frames[1].frames[0].location.reload();
	 frames[1].frames[0].location.reload();
}

//functions moved from AddModifyNursUnitServices.jsp

function submitPrevNext(from, to)
{
	if(document.getElementById("chkAll").checked==true)
			document.forms[0].selctAllCHk.value='Y';
			else
				document.forms[0].selctAllCHk.value='N';

	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}

function uncheckselectall(Obj,i)
{
	
	if(Obj.checked==false)
	{
		if(document.forms[0].chkAll.checked == true)
			document.forms[0].chkAll.checked = false
	}

	if(Obj.checked == false)
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
			eval("document.forms[0].chk"+i).checked=true;
		}

		var search_by = parent.frames[1].document.forms[0].search_by.value;
		var search_txt = parent.frames[1].document.forms[0].search_txt.value;

		var nursing_unit_code = document.forms[0].nursing_unit_code.value;
		var dept_code = "";
		
		if(document.forms[0].dept_code != null)
			dept_code = document.forms[0].dept_code.value;
		else
			dept_code  = "";

		var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='NursUnitServiceDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='search_by' id='search_by' value='"+search_by+"'><input type='hidden' name='search_txt' id='search_txt' value='"+search_txt+"'><input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value='"+nursing_unit_code+"'><input type='hidden' name='dept_code' id='dept_code' value='"+dept_code+"'></form></BODY></HTML>";
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
	
		var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='NursUnitServiceDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'></form></BODY></HTML>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.form1.submit();
	}
}

function chkForSelectAll(start,end)
{
	if(parent.frames[2].document.getElementById('ServiceObj').value == 'selectAll')
	{
		document.forms[0].chkAll.checked=true;
		selectAll(document.forms[0].chkAll,start,end)
	}
}

