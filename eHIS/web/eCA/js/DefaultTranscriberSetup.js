
var linkContent = "";

function create()
{
	DefaultTransSetupHdr.location.href='../../eCA/jsp/DefaultTranscriberSetupHdr.jsp';
	DefaultTransSetupLink.location.href="../../eCommon/html/blank.html";
	DefaultTransSetupList.location.href="../../eCommon/html/blank.html";
}

function apply()
{	
	var fields = new Array (DefaultTransSetupHdr.document.formDefaultTransSetupHdr.transcriber, DefaultTransSetupHdr.document.formDefaultTransSetupHdr.group_by);
	var names = new Array (getLabel("eCA.Transcriber.label","CA"),getLabel("Common.groupby.label","Common"));
	
	if(DefaultTransSetupHdr.checkFieldsofMst( fields, names, messageFrame)) 
	{
		var flag = onApplyUpdate();

		if(flag )
		{
			DefaultTransSetupHdr.document.formDefaultTransSetupHdr.action='../../servlet/eCA.CATranscriptionServlet';
			DefaultTransSetupHdr.document.formDefaultTransSetupHdr.target='messageFrame';
			DefaultTransSetupHdr.document.formDefaultTransSetupHdr.method='post';		
			DefaultTransSetupHdr.document.formDefaultTransSetupHdr.submit();
			onSuccess();
		}
	}	
}

function onSuccess()
{
	/*document.frames[1].location.href="../../eCA/jsp/DefaultTranscriberSetupHdr.jsp";
	document.frames[2].location.href="../../eCommon/html/blank.html";
	document.frames[3].location.href="../../eCommon/html/blank.html";*/
	document.DefaultTransSetupHdr.location.href="../../eCA/jsp/DefaultTranscriberSetupHdr.jsp";
	document.DefaultTransSetupLink.location.href="../../eCommon/html/blank.html";
	document.DefaultTransSetupList.location.href="../../eCommon/html/blank.html";
	
}

function onApplyUpdate()
{
	
	//var refForm = document.frames[3].document.forms[0];
	var refForm = document.DefaultTransSetupList.document.forms[0];
	//var group_by = document.frames[1].document.forms[0].group_by_id.value;
	var group_by = document.DefaultTransSetupHdr.document.getElementById('group_by_id').value;
	
	var temp="";
	//if(document.frames[3].location.href.indexOf(".jsp") != -1)
		if(document.DefaultTransSetupList.location.href.indexOf(".jsp") != -1)
	{

		var bean_id		= refForm.bean_id.value;
		var bean_name	= refForm.bean_name.value;
		var fm_disp		= refForm.fm_disp.value;
		var to_disp		= refForm.to_disp.value;
		var tabVal		= refForm.tabVal.value;
		var value_str	= "";

		fm_disp = parseInt(fm_disp);
		to_disp = parseInt(to_disp);

		for(i=fm_disp; i<=to_disp; i++)
		{
			var value = eval('document.DefaultTransSetupList.document.forms[0].select_yn'+i);
			//var value = document.frames[3].document.forms[0].select_yn+i;
			if(!value.disabled)
			{
				if(value.checked)
				{
					val = "Y";
				}
				else
				{
					val = "N";
				}
			}
			else
			{
				val ="N";
			}
			value_str += val+"~";
		}
		var xmlStr ="<root><SEARCH ";
		xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
		xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
		xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
		xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
		xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
		xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
		xmlStr += " GROUP_BY=\""+ group_by + "\" ";
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","DefaultTranscriberSetupValidate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		return true;
	}
	else
	{
		return true;
	}

}

function latestUpdate()
{
	var bean_id		= parent.DefaultTransSetupList.document.formDefaultTransSetupDtl.bean_id.value;
	var bean_name	= parent.DefaultTransSetupList.document.formDefaultTransSetupDtl.bean_name.value;
	var fm_disp		= parent.DefaultTransSetupList.document.formDefaultTransSetupDtl.fm_disp.value;
	var to_disp		= parent.DefaultTransSetupList.document.formDefaultTransSetupDtl.to_disp.value;
	var tabVal		= parent.DefaultTransSetupList.document.formDefaultTransSetupDtl.tabVal.value;
	var group_by	= parent.DefaultTransSetupHdr.document.formDefaultTransSetupHdr.group_by_id.value;
	var value_str	= "";
	fm_disp = parseInt(fm_disp);
	to_disp = parseInt(to_disp);

	for(i=fm_disp; i<=to_disp; i++)
	{
		var value = eval('parent.DefaultTransSetupList.document.formDefaultTransSetupDtl.select_yn'+i);
		
		if(!value.disabled)
		{
			if(value.checked)
			{
				val = "Y";
			}
			else
			{
				val = "N";
			}
		}
		else
		{
			val ="N";
		}
		value_str += val+"~";
	}
	
	var xmlStr ="<root><SEARCH ";
	xmlStr += " INDEX_VALUES=\""+ value_str + "\" ";
	xmlStr += " FROM_VALUE=\""+ fm_disp + "\" ";
	xmlStr += " TO_VALUE=\""+ to_disp + "\" ";
	xmlStr += " BEAN_ID=\""+ bean_id + "\" ";
	xmlStr += " BEAN_NAME=\""+ bean_name + "\" ";
	xmlStr += " TAB_VALUE=\""+ tabVal + "\" ";
	xmlStr += " GROUP_BY=\""+ group_by + "\" ";
	xmlStr +=" /></root>";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","DefaultTranscriberSetupValidate.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	return true;
}

function disableTabs()
{
	parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	var group_by = document.formDefaultTransSetupHdr.group_by.value;
	var transcriber_id = document.formDefaultTransSetupHdr.transcriber.value;
	if(group_by != '' && transcriber_id != '')
	{
		document.formDefaultTransSetupHdr.group_by_id.value = group_by;
		document.formDefaultTransSetupHdr.transcriber_id.value = transcriber_id;
		if(group_by == "PC")
		{
			parent.DefaultTransSetupLink.location.href = '../../eCommon/html/blank.html';
			document.formDefaultTransSetupHdr.group_by.disabled = true;
			document.formDefaultTransSetupHdr.transcriber.disabled = true;
			//parent.confDispID.rows = '43,90,0,*,50';
			parent.document.getElementById("commontoolbarFrame").style.height="8vh";
			parent.document.getElementById("DefaultTransSetupHdr").style.height="4vh";
			parent.document.getElementById("DefaultTransSetupLink").style.height="0vh";
			parent.document.getElementById("DefaultTransSetupList").style.height="72vh";
			parent.document.getElementById("messageFrame").style.height="9vh";
			
			parent.DefaultTransSetupList.location.href = '../../eCA/jsp/DefaultTranscriberSetupDtl.jsp?group_by='+group_by+'&transcriber_id='+transcriber_id+'&tabVal=S';
		}
		else
		{
			//parent.confDispID.rows = '43,90,40,*,50';
			parent.document.getElementById("commontoolbarFrame").style.height="8vh";
			parent.document.getElementById("DefaultTransSetupHdr").style.height="8vh";
			parent.document.getElementById("DefaultTransSetupLink").style.height="7vh";
			parent.document.getElementById("DefaultTransSetupList").style.height="64vh";
			parent.document.getElementById("messageFrame").style.height="9vh";
			parent.DefaultTransSetupLink.location.href = '../../eCA/jsp/DefaultTranscriberSetupLink.jsp';
			parent.DefaultTransSetupList.location.href = '../../eCommon/html/blank.html';
		}
	}
}

function callOnAlphaLink(obj, obj2)
{
	changeAlphaColor(obj2);
	var fldObj = parent.DefaultTransSetupHdr.document.forms[0].group_by;
	var fldObj1 = parent.DefaultTransSetupHdr.document.forms[0].transcriber;

	if(parent.frames[3].location.href.indexOf(".jsp") != -1)
	{
		var flag = latestUpdate();
	}
	var group_by = fldObj.value;
	var transcriber = fldObj1.value;

	if(group_by !="" && transcriber != "")
	{
		parent.DefaultTransSetupHdr.document.formDefaultTransSetupHdr.transcriber.disabled = true;
		parent.DefaultTransSetupHdr.document.formDefaultTransSetupHdr.group_by.disabled = true;
		parent.frames[3].location.href="../../eCA/jsp/DefaultTranscriberSetupDtl.jsp?group_by="+group_by+"&index="+obj+"&tabVal=S&transcriber_id="+transcriber;
		parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
	else
	{
		var msg = "";
		if (transcriber == "")
		{
			msg += getMessage("CAN_NOT_BE_BLANK","COMMON");
			msg = msg.replace("$",getLabel("eCA.Transcriber.label","CA"));				
		}
		if (group_by == "")
		{
			if(msg != '')
				msg = msg + "<br>";
			msg += getMessage("CAN_NOT_BE_BLANK","COMMON");
			msg = msg.replace("$",getLabel("Common.groupby.label","Common"));
		}
		parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;

	}
}

function dispLink(obj)
{
	var group_by	= parent.DefaultTransSetupHdr.document.forms[0].group_by.value;
	var transcriber	= parent.DefaultTransSetupHdr.document.forms[0].transcriber.value;
	var msg = "";

	if(group_by != "" && transcriber != "")
	{
		parent.DefaultTransSetupHdr.document.formDefaultTransSetupHdr.transcriber.disabled = true;
		parent.DefaultTransSetupHdr.document.formDefaultTransSetupHdr.group_by.disabled = true;

		if(parent.frames[3].location.href.indexOf(".jsp") != -1)
		{
			var flag = latestUpdate();
		}
		
		if(linkContent == "")
		{
			linkContent	=	document.getElementById("linkId").innerHTML;
		}
		
		if(obj=="A")
		{
			document.getElementById('SelectTab').className="normal";
			document.getElementById('AssociateTab').className="clicked";
			document.getElementById('linkId').className ="";
			document.getElementById('linkId').innerHTML = "&nbsp;";
			parent.frames[3].location.href="../../eCA/jsp/DefaultTranscriberSetupDtl.jsp?tabVal="+obj+"&group_by="+group_by+"&transcriber_id="+transcriber;
			parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
		else
		{
			document.getElementById('SelectTab').className="clicked";
			document.getElementById('AssociateTab').className="normal";
			parent.frames[3].location.href="../../eCommon/html/blank.html";
			document.getElementById('linkId').innerHTML = linkContent;
			parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
	else
	{
		if (transcriber == "")
		{
			msg += getMessage("CAN_NOT_BE_BLANK","COMMON");
			msg = msg.replace("$",getLabel("eCA.Transcriber.label","CA"));				
		}
		if (group_by == "")
		{
			if(msg != '')
				msg = msg + "<br>";
			msg += getMessage("CAN_NOT_BE_BLANK","COMMON");
			msg = msg.replace("$",getLabel("Common.groupby.label","Common"));
		}
		parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	}
}

function reset()
{
	var formObj = DefaultTransSetupHdr.document.formDefaultTransSetupHdr;

	formObj.transcriber.disabled = false;
	formObj.group_by.disabled = false;
	formObj.transcriber.selectedIndex = 0;
	formObj.group_by.selectedIndex = 0;
	
	//document.frames[2].location.href="../../eCommon/html/blank.html";
	document.DefaultTransSetupLink.location.href="../../eCommon/html/blank.html";
	//document.frames[3].location.href="../../eCommon/html/blank.html";
	document.DefaultTransSetupList.location.href="../../eCommon/html/blank.html";
}

function validate(obj,index)
{
	var associate_yn = eval("document.forms[0].associate_yn"+index).value;
	var group_by = document.forms[0].group_by.value;
	if(associate_yn == 'A')
	{
		if(group_by == 'PR')
			alert('Selected Practitioner is already linked to some other Transcriber');
		else if(group_by == 'SP')
			alert('Selected Speciality is already linked to some other Transcriber');
		else if(group_by == 'PC')
		{
			if(obj.checked == true)
				alert('Selected Patient Class is already linked to some other Transcriber');
			else
				eval("document.forms[0].associate_yn"+index).value = 'D';
		}
		obj.checked = false;
		return false;
	}
}

function checkVal(obj)
{
	document.forms[0].dispMode.value = obj;		
	document.forms[0].submit();
}
