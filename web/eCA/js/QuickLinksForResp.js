/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
07/01/2019	IN069243	sivabagyam M 	07/01/2019		Ramesh G		MO-CRF-20101.2
---------------------------------------------------------------------------------------------------------------
*/
function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/QuickLinksForRespAddModify.jsp';
	resultFrame.location.href = '../../eCommon/html/blank.html';
}

function apply()
{
	if(f_query_add_mod.document.QuickLink_Form != null && resultFrame.document.QuickLinkResp_Form != null)
	{
		var ql_type = f_query_add_mod.document.QuickLink_Form.ql_type.value;
		var function_id = f_query_add_mod.document.QuickLink_Form.function_id.value;
		//var desc = f_query_add_mod.document.QuickLink_Form.desc.value;

		var fields = new Array(f_query_add_mod.document.QuickLink_Form.ql_type);
		var names = new Array (getLabel("eCA.LinkType.label",'CA'));

		
		if(checkFieldsofMst(fields, names, parent.messageFrame))
		{
			if(ql_type == 'F')
			{
				fields = new Array(f_query_add_mod.document.QuickLink_Form.function_name,f_query_add_mod.document.QuickLink_Form.resp);
				names = new Array (getLabel("Common.Function.label",'common'),getLabel("Common.responsibility.label",'common'));
				if(checkFieldsofMst(fields, names, parent.messageFrame))
				{
					resultFrame.document.QuickLinkResp_Form.target = "messageFrame";
					resultFrame.document.QuickLinkResp_Form.action = '../../servlet/eCA.QuickLinksForRespServlet';
					resultFrame.document.QuickLinkResp_Form.submit();
				}
			}
			if(ql_type == 'Q')
			{
				fields = new Array(f_query_add_mod.document.QuickLink_Form.resp);
				names = new Array (getLabel("Common.responsibility.label",'common'));
				if(checkFieldsofMst(fields, names, parent.messageFrame))
				{
					resultFrame.document.QuickLinkResp_Form.target = "messageFrame";
					resultFrame.document.QuickLinkResp_Form.action = '../../servlet/eCA.QuickLinksForRespServlet';
					resultFrame.document.QuickLinkResp_Form.submit();
				}
			}
		}
	}
	else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
}

function loadDesc(obj)
{
	parent.resultFrame.location.href = '../../eCommon/html/blank.html';
}

function reset()
{
	if(f_query_add_mod.document.forms[0])
	f_query_add_mod.location.reload();
	resultFrame.location.href ='../../eCommon/html/blank.html';
}
  
function showFields(obj)
{
	if(obj.value != null && obj.value != '')
	{
		if(obj.value == 'F')
		{
			document.QuickLink_Form.mand_fun.style.display = 'inline';
			document.QuickLink_Form.function_name.disabled = false;
			document.QuickLink_Form.search_ref.disabled = false;
		}
		else
		{
			document.QuickLink_Form.mand_fun.style.display = 'none';
			document.QuickLink_Form.function_name.disabled = true;
			document.QuickLink_Form.search_ref.disabled = true;
			document.QuickLink_Form.function_name.value = '';
			document.QuickLink_Form.function_id.value = '';
		}
	}
	else
	{
		parent.f_query_add_mod.location.reload();
	}
}

async function getFunction()
{
	var ql_type				= document.QuickLink_Form.ql_type.value;
	var target				= document.QuickLink_Form.function_name;
	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "50" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	var title				= "Function";
		
	//var sql = "select distinct a.OPTION_ID code, a.SYS_OPTION_DESC description from SM_QUICK_LINK_OPTION a, SM_QUICK_LINK_LIST b where a.OPTION_ID = b.OPTION_ID and b.QUICK_LINK_TYPE ='QF' and upper(a.OPTION_ID) like upper(?) and upper(a.SYS_OPTION_DESC) like upper(?) order by 2";//IN069243
	var sql = "select distinct a.OPTION_ID code, a.SYS_OPTION_DESC description from SM_QUICK_LINK_OPTION a, SM_QUICK_LINK_LIST b where a.OPTION_ID = b.OPTION_ID and b.QUICK_LINK_TYPE IN('QF','EF') and upper(a.OPTION_ID) like upper(?) and upper(a.SYS_OPTION_DESC) like upper(?) order by 2";//IN069243

	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();
	
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retVal = await CommonLookup( title, argArray )
	var ret1=unescape(retVal);
							var arr=ret1.split(",");
							if(arr[1]==undefined) 
							{
								arr[0]="";	
								arr[1]="";	
							}	

	if (retVal != null && retVal != ''&&retVal !='undefined' )
	{
		document.QuickLink_Form.function_id.value = arr[0];
		document.QuickLink_Form.function_name.value = arr[1];

		/*if(ql_type == 'Q')
		{
			var optlength = document.forms[0].desc.options.length;

			for (var i=0; i<optlength; i++)
			{
				document.forms[0].desc.options.remove("desc");
			}

			var HTMLVal="<html><body><form name='QuickLinkDescForm' id='QuickLinkDescForm' method='post' action='../../eCA/jsp/QuickLinksForRespDescription.jsp'>"+
			"<input type='hidden' name='ql_type' id='ql_type' value='"+ql_type+"'>"+
			"<input type='hidden' name='function_id' id='function_id' value='"+document.QuickLink_Form.function_id.value+"'>"+
			"</form></body></html>";
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
			parent.messageFrame.document.QuickLinkDescForm.submit();
		}*/
	}
	else
	{
		document.QuickLink_Form.function_id.value = arr[0];;
		document.QuickLink_Form.function_name.value = arr[1];

	}
}

function getFunction1(obj)
{
	if(obj.value != null && obj.value != '')
	{
		getFunction();
	}
	/*else
	{
		document.QuickLink_Form.function_id.value = '';
		var ql_type = document.QuickLink_Form.ql_type.value;
		if(ql_type == 'QF')
		{
			var optlength = document.forms[0].desc.options.length;

			for (var i=0; i<optlength; i++)
			{
				document.forms[0].desc.options.remove("desc");
			}
			var desc_id	= '';
			var short_desc	= " ----------" +getLabel('Common.defaultSelect.label','COMMON')+" -----------";
			var opt=document.createElement('OPTION');
			opt.text	=	short_desc;
			opt.value	=	desc_id;
			document.forms[0].desc.add(opt);
			document.forms[0].desc.selectedIndex = 0;
		}
	}*/
}

function showResult()
{
	if(document.QuickLink_Form != null)
	{
		var ql_type = document.QuickLink_Form.ql_type.value;
		var function_id = document.QuickLink_Form.function_id.value;
		var resp = document.QuickLink_Form.resp.value;

		var fields = new Array(document.QuickLink_Form.ql_type);
		var names = new Array (getLabel("eCA.LinkType.label",'CA'));
		
		if(checkFieldsofMst(fields, names, parent.messageFrame))
		{
			if(ql_type == 'F')
			{
				fields = new Array(document.QuickLink_Form.function_name,document.QuickLink_Form.resp);
				names = new Array (getLabel("Common.Function.label",'common'),getLabel("Common.responsibility.label",'common'));
				if(checkFieldsofMst(fields, names, parent.messageFrame))
					parent.blankFrame.location.href = '../../eCA/jsp/QuickLinksForRespIntermediate.jsp?ql_type='+ql_type+'&resp='+resp+'&function_id='+function_id;
			}
			if(ql_type == 'Q')
			{
				fields = new Array(document.QuickLink_Form.resp);
				names = new Array (getLabel("Common.responsibility.label",'common'));
				if(checkFieldsofMst(fields, names, parent.messageFrame))
					parent.blankFrame.location.href = '../../eCA/jsp/QuickLinksForRespIntermediate.jsp?ql_type='+ql_type+'&resp='+resp;
			}
		}
	}
}

function onSuccess()
{
	f_query_add_mod.location.reload();
	resultFrame.location.href = '../../eCommon/html/blank.html';
}

function selectAll(object)
{
	var start = eval(document.forms[0].from.value)-1;
	var end = eval(document.forms[0].end.value)-1;
	for(i=start;i<=end;i++)
	{
		if(eval("document.forms[0].chk"+i)!=null)
		{
			var obj = eval("document.forms[0].chk"+i);
			var defObj=eval("document.forms[0].default_chk"+i);
			if(object.checked)
			{
				obj.checked = true;
				if(defObj!=undefined||defObj!=null)
				defObj.disabled=false;
			}
			else
			{
				obj.checked = false;
				if(defObj!=undefined||defObj!=null)
				defObj.disabled=true;
			}
		}
	}
}

function defaultSelect(object)
{
	var start = eval(document.forms[0].from.value)-1;
	var end = eval(document.forms[0].end.value)-1;
	for(i=start;i<=end;i++)
	{
		if(object.checked == true)
		{
			if(eval("document.forms[0].default_chk"+i)!=null)
			{
				var obj = eval("document.forms[0].default_chk"+i);
				
				if(object == obj)
				{
					if(eval("document.forms[0].chk"+i).checked == true)
						obj.checked = true;
					else
						object.checked = false;
				}
				else
				{
					obj.checked = false;
				}
			}
		}
	}
}
function enableDefault(obj,i)
{
	if(eval("document.forms[0].default_chk"+i) != null)
	{
		if(obj.checked == true)
		{
			eval("document.forms[0].default_chk"+i).disabled = false;
		}
		else
		{
			eval("document.forms[0].default_chk"+i).checked = false;
			eval("document.forms[0].default_chk"+i).disabled = true;
		}
	}
}

