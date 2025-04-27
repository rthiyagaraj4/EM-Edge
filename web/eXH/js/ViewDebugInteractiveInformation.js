//*************************************************************************
// Function Reset
//*************************************************************************
function reset()
{
	if(window.f_query_header.document.forms[0])
	{
	window.f_query_header.document.forms[0].reset();
	window.f_query_detail.location.href="../../eCommon/html/blank.html";
	window.f_query_add_mod.location.href="../../eCommon/html/blank.html";
	window.f_query_header.document.forms[0].trigger.style.background='silver';
	window.f_query_header.document.forms[0].trigger.style.color='black';
	window.f_query_header.document.forms[0].procedure.style.background='silver';
	window.f_query_header.document.forms[0].procedure.style.color='black';
	}
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
   this.document.forms[0].action='../../eXH/jsp/DebugInteractiveInfoProcedure.jsp';
   this.document.forms[0].target='f_query_add_mod';
   this.document.forms[0].submit();
}
//*********************************************************************************
//function funShow
//*********************************************************************************
function funShow(obj)
{
	this.document.forms[0].PROCEDUREPARAMETER.value = obj.getAttribute('PROCEDUREPARAMETER');
	
	var act = "../../eXH/jsp/InteractiveProcedureFooter.jsp";
	this.document.forms[0].action = act;
	this.document.forms[0].target='f_query_detail';
	this.document.forms[0].submit();
}
//***************************************************************************
//function funSubmit
//*********************************************************************************
function funSubmit()
{
	var act = '../../eXH/jsp/DebugInteractiveInfoProcedure.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].sortMode.value="A";
	this.document.forms[0].target='f_query_add_mod';
   	this.document.forms[0].submit();
}
//***************************************************************************
//function funAction
//*********************************************************************************
function funAction(typ)
{
    this.document.forms[0].action_type.value = typ;
	parent.f_query_detail.location.href="../../eCommon/html/blank.html";
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
   this.document.forms[0].action='../../eXH/jsp/DebugInteractiveInfoTrigger.jsp';
   this.document.forms[0].target='f_query_add_mod';
   this.document.forms[0].submit();
}
//********************************************************************************************
//function funShow1
//********************************************************************************************
function funShow1(obj)
{
	this.document.forms[0].TRIGGERINGCONDITION.value = obj.getAttribute('TRIGGERINGCONDITION');
	var act = "../../eXH/jsp/InteractiveTriggerFooter.jsp";
	this.document.forms[0].action = act;
	this.document.forms[0].target='f_query_detail';
	this.document.forms[0].submit();
}
//********************************************************************************************
//function funSubmit1
//***********************************************************************************************
function funSubmit1()
{
	var act = '../../eXH/jsp/DebugInteractiveInfoTrigger.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].sortMode.value="A";
	this.document.forms[0].target='f_query_add_mod';
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
