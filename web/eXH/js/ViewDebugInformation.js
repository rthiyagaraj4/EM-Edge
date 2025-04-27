//*************************************************************************
// Function Reset
//*************************************************************************
function reset()
{
	window.f_query_header.document.forms[0].reset();
	window.queryResultsFrame.location.href="../../eCommon/html/blank.html";
}
//*************************************************************************
//function callSort
//*************************************************************************
function callSort(obj)
{
   var previousMode= this.document.forms[0].sortMode1.value ;
   if(previousMode=="A") this.document.forms[0].sortMode.value="D";
   if(previousMode=="D") this.document.forms[0].sortMode.value="A";	
  
   this.document.forms[0].orderbycolumns.value=obj;
   parent.f_query_detail.location.href="../../eCommon/html/blank.html";
   this.document.forms[0].action='../../eXH/jsp/DebugInfoProcedure.jsp';
   this.document.forms[0].target='f_query_add_mod';
   this.document.forms[0].submit();
}
//*********************************************************************************
//function funShow
//*********************************************************************************
function funShow(obj)
{
	this.document.forms[0].PROCEDUREPARAMETER.value = obj.getAttribute('PROCEDUREPARAMETER');
	
	var act = "../../eXH/jsp/ProcedureFooter.jsp";
	this.document.forms[0].action = act;
	this.document.forms[0].target='f_query_detail';
	this.document.forms[0].submit();
}
//***************************************************************************
//function funSubmit
//*********************************************************************************
function funSubmit()
{
	act = '../../eXH/jsp/viewDebugInfo.jsp';

	this.document.forms[0].action = act;
	this.document.forms[0].sortMode.value="A";
	this.document.forms[0].target='queryResultsFrame';	
   	this.document.forms[0].submit();
}
//***************************************************************************
//function funAction
//*********************************************************************************
function funAction(typ)
{
    this.document.forms[0].action_type.value = typ;
	parent.queryResultsFrame.location.href="../../eCommon/html/blank.html";
	parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";	
	funSubmit();
}
//****************************************************************************
//function callSort1
//*****************************************************************************
function callSort1(obj)
{
   var previousMode= this.document.forms[0].sortMode1.value ;
   if(previousMode=="A") this.document.forms[0].sortMode.value="D";
   if(previousMode=="D") this.document.forms[0].sortMode.value="A";	
   this.document.forms[0].orderbycolumns.value=obj;
   parent.f_query_detail.location.href="../../eCommon/html/blank.html";
   this.document.forms[0].action='../../eXH/jsp/DebugInfoTrigger.jsp';
   this.document.forms[0].target='f_query_add_mod';
   this.document.forms[0].submit();
}
//********************************************************************************************
//function funShow1
//********************************************************************************************
function funShow1(obj)
{
	this.document.forms[0].TRIGGERINGCONDITION.value = obj.getAttribute('TRIGGERINGCONDITION');
	var act = "../../eXH/jsp/TriggerFooter.jsp";
	this.document.forms[0].action = act;
	this.document.forms[0].target='f_query_detail';
	this.document.forms[0].submit();
}
//********************************************************************************************
//function funSubmit1
//***********************************************************************************************
function funSubmit1()
{
	var act = '../../eXH/jsp/viewDebugInfo.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].sortMode.value="A";
	this.document.forms[0].target='queryResultsFrame';
	this.document.forms[0].submit();
}
//********************************************************************************************
//function funAction1
//**********************************************************************************************
function funAction1(typ)
{
	document.forms[0].action_type.value = typ;
	parent.f_query_detail.location.href="../../eCommon/html/blank.html";
	funSubmit1();
}
//************************************************************************************************
function showText(str)
{	
	parent.messageFrame.location.href="../../eXH/jsp/viewDebugInfoText.jsp?text="+str;
}
//************************************************************************************************
function refreshFrames()
{	
	parent.window.queryResultsFrame.document.open();
	parent.window.queryResultsFrame.document.write('<body color="white">');
	parent.window.queryResultsFrame.document.close();
	
	parent.window.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
//************************************************************************************************
function showDirField(obj)
{
	var mode = obj.value;
	
	if(mode == "excel") 
	{
		document.getElementById("dirDiv1").style.display="block";
		document.getElementById("dirDiv2").style.display="block";
	}
	else
	{
		document.getElementById("dirDiv1").style.display="none";
		document.getElementById("dirDiv2").style.display="none";
	}
}
function searchRecords()
{	
//	if(validateFields())
//	{
	var mode = document.getElementById("mode").value;
	var act = "";
	if(mode == "excel") act = '../../eXH/jsp/debugInfo2XL.jsp';	
	else act = '../../eXH/jsp/viewDebugInfo.jsp';

	this.document.forms[0].action = act;	
	this.document.forms[0].target='queryResultsFrame';	
	this.document.forms[0].submit();
//	}
//	else return false;
}

function deleterecord()
{
	var obj = frames[2].document.debugResultsForm;
	var act = '../../servlet/eXH.XHDebugInfoServlet';
	obj.action = act;
	obj.mode.value = "D";
	obj.target = "messageFrame";
	obj.submit();
	frames[2].location.href="../../eCommon/html/blank.html";
	window.commontoolbarFrame.document.location.reload();
}

function validateFields()
{
	var dirPath = this.document.getElementById("dirPath").value;
	var index = dirPath.indexOf(".");
	if(index != -1)
	{
		var temp = dirPath.substring(index+1);
		alert(temp);
		if(temp.toUpperCase() != "XLS" || (dirPath.indexOf(".",index+1) != -1))
		{
			alert(getMessage('XH0060'));
			return false;
		}		
	}
	else
	{
		alert(getMessage('XH0060'));
		return false;
	}
	return true;
}
