//************************************************************************
//function funSubmit
//***************************************************************************
function funSubmit()
{
	var act = '../../eXH/jsp/DataElementCrossRefElementID.jsp';
	this.document.forms[0].action = act;
	this.document.forms[0].submit();
}
//************************************************************************
////function funCheck
//***************************************************************************
function funCheck(obj)
{
	if (obj.checked == true)
	{
		obj.value = 'Y';
	}
	else
	{
		obj.value = 'N';
	}
}
//***************************************************************************
// function funAction
//***************************************************************************
function funAction(typ,page)
{
	document.forms[0].action_type.value = typ;
	this.document.forms[0].target=''
	funSubmit();
}
//***************************************************************************
arrTabPages = new Array();
//******************************************************************/
//function callJSPs
//******************************************************************/

function callJSPs(str)
{
var tab1=document.getElementById("appl_cross");
var tabspan1=document.getElementById("appl_cross_tabspan");
var tab2=document.getElementById("element_dtl");
var tabspan2=document.getElementById("element_dtl_tabspan");

if(str=='appl_cross')
{
	alert("data");
	document.forms[0].tab.value='';
	 tab1.className='tabClicked';
	 tabspan1.className='tabSpanclicked';
	 tab2.className='tabA';
	 tabspan2.className='tabAspan';
	this.parent.bodyframe.document.location.href = '../../eXH/jsp/DataElementCrossRefApplMain.jsp';
	parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
	
}
if(str=='element_dtl')
{
	alert();
	document.forms[0].tab.value='element';
	tab2.className='tabClicked';
	tabspan2.className='tabSpanclicked';
	tab1.className='tabA';
	tabspan1.className='tabAspan';
	this.parent.bodyframe.document.location.href = '../../eXH/jsp/DataElementCrossRefBasicElement.jsp';
	parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
}
if(str=='element_id')
{
	alert("here");
	document.forms[0].tab.value='element_id';
	tab2.className='tabClicked';
	tabspan2.className='tabSpanclicked';
	tab1.className='tabA';
	tabspan1.className='tabAspan';
	alert();
	this.parent.bodyframe.document.location.href = '../../eXH/jsp/DataElementCrossRefElementID.jsp';
	parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
}

}
//******************************************************************/
