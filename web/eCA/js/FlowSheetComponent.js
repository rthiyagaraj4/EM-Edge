function create() {
	f_query_add_mod.location.href='../../eCA/jsp/FlowSheetComponent.jsp?mode=insert&type=N';
}
function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/FlowSheetComponentCriteria.jsp';
}

function apply(){

	if(	f_query_add_mod.document.forms[0]!=null)
	{
	f_query_add_mod.document.forms[0].short_desc1.value=f_query_add_mod.document.forms[0].short_desc.value;
	f_query_add_mod.document.forms[0].long_desc1.value=f_query_add_mod.document.forms[0].long_desc.value;

	var fields = new Array(f_query_add_mod.document.forms[0].id,f_query_add_mod.document.forms[0].short_desc,f_query_add_mod.document.forms[0].long_desc);
		var names = new Array (getLabel("eCA.FlowSheetID.label",'CA'),getLabel("Common.shortdescription.label",'common'),getLabel("Common.longdescription.label",'common'));
	//var fid = document.forms[0].flow_sheet.value;
	if(checkFieldsofMst(fields, names, messageFrame)){	
//f_query_add_mod.document.forms[0].action="../../servlet/eCA.FlowSheetComponentServlet?flow_sheet="+fid;
		f_query_add_mod.document.forms[0].submit();
	}
	
	}
	else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
	
	
}

function onSuccess()
{
 f_query_add_mod.location.reload();
}
/*function reset()
{
  f_query_add_mod.location.reload();
}*/
function reset()
{
	
		if(f_query_add_mod.document.forms[0]!=null)
			{
		f_query_add_mod.document.forms[0].reset();
		}
}

function CheckForSpeChar(event)
{
	var strCheck=
	'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*  ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
    
	if (strCheck.indexOf(key) == -1) 
		return false;  //Not a valid key
}	

//Functions for the file FlowSheetComponent.jsp-start

function func_assign()
{
	document.forms[0].short_desc1.value=document.forms[0].short_desc.value;
	document.forms[0].long_desc1.value=document.forms[0].long_desc.value;
}
//Functions for the file FlowSheetComponent.jsp-end

function Change_type(obj)
{
	var type="";
	if (document.forms[0].add_type[0].checked)
	{
	type=document.forms[0].add_type[0].value;
	
	}
	else
	{
	type=document.forms[0].add_type[1].value;
    
	}
	parent.f_query_add_mod.location.href="../../eCA/jsp/FlowSheetComponent.jsp?mode=insert&type="+type;
	
	
}

async function getCharts(obj)
{
	if(obj.name=='id')
		{
			if((obj.value) == "null" || (obj.value ==""))
			{
					return false;			
			}
			else
			{
				await getChart();
			}
		}
		else if(obj.name=='buttonChart')
		{
			await getChart();
		}

}

async function getChart()
	{
	sql = "Select CHART_ID code, SHORT_DESC description from ca_chart where eff_status='E'  and upper(CHART_ID) like upper(?) and  upper(SHORT_DESC) like upper(?) order by 2";
	retArray = await  callFunctionButton(sql,getLabel("Common.Chart.label","COMMON"),parent.f_query_add_mod.document.FlowSheetComp.id)
			if(retArray != null && retArray !="")	
			{
					document.FlowSheetComp.id.value = retArray[0];
					var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/FlowSheetComponentIntermediate.jsp'><input type='hidden' name=chart_id value="+retArray[0]+"></form></body></html>";
					 parent.frames[3].document.write(HTMLVal);
					parent.frames[3].document.tempform1.submit(); 
								
			}
			
	}
async function callFunctionButton(sql,title,target)
{
	target=document.FlowSheetComp.id;
	var serviceVal   ="";
	var search_desc	= "";
	//target.value='';
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = await CommonLookup( title, argArray );
	return retArray;
}

