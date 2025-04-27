//************************************************************************
//function funSubmit
//***************************************************************************
function funSubmit()
{
	var act = '../../eXH/jsp/DataElementCrossRefBasicElement2.jsp';
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
function funAction(typ)
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
var tab7=document.getElementById("Derivation-ID");
var tabspan7=document.getElementById("Derivation-ID_tabspan");

var tab3=document.getElementById("element_id");
var tabspan3=document.getElementById("element_id_tabspan");
//var tab4=document.getElementById("Filter_id");
//var tabspan4=document.getElementById("Filter_id_tabspan");
var tab5=document.getElementById("Rearrange_id");
var tabspan5=document.getElementById("Rearrange_id_tabspan");
var tab6=document.getElementById("Standard_id");
var tabspan6=document.getElementById("Standard_id_tabspan");

if(str=='appl_cross')
{
	document.forms[0].tab.value='';
	 tab1.className='tabClicked';
	 tabspan1.className='tabSpanclicked';
	 tab2.className='tabA';
	 tabspan2.className='tabAspan';
	 tab3.className='tabA';
	tabspan3.className='tabAspan';
	// tab4.className='tabA';
	//tabspan4.className='tabAspan';
	 tab5.className='tabA';
	tabspan5.className='tabAspan';
	 tab6.className='tabA';
	tabspan6.className='tabAspan';
	tab7.className='tabA';
	tabspan7.className='tabAspan';
//	this.parent.bodyframe.document.location.href = '../../eXH/jsp/DataElementCrossRefApplMain.jsp';
this.parent.bodyframe.document.location.href = '../../eXH/jsp/DataElementCrossRefApplicationTabMain.jsp';
	
	parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp';
	//parent.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?";
	
}
if(str=='element_dtl')
{
	document.forms[0].tab.value='element';
	tab2.className='tabClicked';
	tabspan2.className='tabSpanclicked';
	tab1.className='tabA';
	tabspan1.className='tabAspan';
	 tab3.className='tabA';
	tabspan3.className='tabAspan';
	 // tab4.className='tabA';
	// tabspan4.className='tabAspan';
	 tab5.className='tabA';
	tabspan5.className='tabAspan';
	 tab6.className='tabA';
	tabspan6.className='tabAspan';
	tab7.className='tabA';
	tabspan7.className='tabAspan';



	this.parent.bodyframe.document.location.href = '../../eXH/jsp/DataElementCrossRefBasicElement2.jsp';
	parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp';
	//parent.commontoolbarFrame.location.href="../../eCommon/jsp/MstCodeToolbar.jsp?";
	//parent.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?";
}

if(str=='Derivation_id')
{

	document.forms[0].tab.value='Derivation-ID';
	tab3.className='tabA';
	tabspan3.className='tabAspan';
	tab2.className='tabA';
	tabspan2.className='tabAspan';
	tab1.className='tabA';
	tabspan1.className='tabAspan';
	tab7.className='tabClicked';
	tabspan7.className='tabSpanclicked';
	 // tab4.className='tabA';
	// tabspan4.className='tabAspan';
	 tab5.className='tabA';
	tabspan5.className='tabAspan';
	 tab6.className='tabA';
	tabspan6.className='tabAspan';
	var ruleval='D';

	
	//this.parent.bodyframe.document.forms[0].Rule.value='D';
	this.parent.bodyframe.document.location.href = '../../eXH/jsp/DataElementCrossRefElementIDMain.jsp?source='+document.forms[0].source.value+'&Rule=D';
//	this.parent.bodyframe.document.location.href = '../../eXH/jsp/DataElementCrossRefElementID.jsp';

	parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp';
	//parent.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp";
	//alert(parent.commontoolbarFrame.location.href);
	//parent.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?";
}

if(str=='element_id')
{
	//this.parent.bodyframe.
	document.forms[0].tab.value='element_id';
	tab3.className='tabClicked';
	tabspan3.className='tabSpanclicked';
	tab2.className='tabA';
	tabspan2.className='tabAspan';
	tab1.className='tabA';
	tabspan1.className='tabAspan';
	
	 // tab4.className='tabA';
	// tabspan4.className='tabAspan';
	 tab5.className='tabA';
	tabspan5.className='tabAspan';
	 tab6.className='tabA';
	tabspan6.className='tabAspan';
	tab7.className='tabA';
	tabspan7.className='tabAspan';
	var ruleval='E';




	this.parent.bodyframe.document.location.href = '../../eXH/jsp/DataElementCrossRefElementIDMain.jsp?Rule=E';
	//this.parent.bodyframe.document.location.href = '../../eXH/jsp/DataElementCrossRefElementIDMain.jsp?Rule=E';
//alert(this.parent.bodyframe.document.location.href);
	//this.parent.bodyframe.document.location.href = '../../eXH/jsp/DataElementCrossRefElementID.jsp';

//parent.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?";
	parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp';
}
if(str=='Rearrange_id')
{

	
	document.forms[0].tab.value='Rearrnage_id';
	tab5.className='tabClicked';
	tabspan5.className='tabSpanclicked';
	tab1.className='tabA';
	tabspan1.className='tabAspan';
	 tab3.className='tabA';
	tabspan3.className='tabAspan';
	 // tab4.className='tabA';
	// tabspan4.className='tabAspan';
	
	 tab6.className='tabA';
	tabspan6.className='tabAspan';
	tab2.className='tabA';
	tabspan2.className='tabAspan';
	tab7.className='tabA';
	tabspan7.className='tabAspan';
	this.parent.bodyframe.document.location.href = '../../eXH/jsp/RearrangementLayerMain2.jsp';
//	this.parent.bodyframe.document.location.href = '../../eXH/jsp/DataElementCrossRefElementID.jsp';
	parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp';
	//parent.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?";
}

if(str=='Filter_id') 
{
	document.forms[0].tab.value='Filter_id';
	tab4.className='tabClicked';
	tabspan4.className='tabSpanclicked';
	tab5.className='tabA';
	tabspan5.className='tabAspan';
	tab1.className='tabA';
	tabspan1.className='tabAspan';
	 tab3.className='tabA';
	tabspan3.className='tabAspan';
	 tab2.className='tabA';
	tabspan2.className='tabAspan';
	 tab5.className='tabA';
	tabspan5.className='tabAspan';
	 tab6.className='tabA';
	tabspan6.className='tabAspan';
	tab7.className='tabA';
	tabspan7.className='tabAspan';
	this.parent.bodyframe.document.location.href = '../../eXH/jsp/DatacrossElementFilterSelectMasterMain.jsp';
//	this.parent.bodyframe.document.location.href = '../../eXH/jsp/DataElementCrossRefElementID.jsp';
	parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp';
	//parent.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?";
}
if(str=='Standard_id')
{
	document.forms[0].tab.value='Standard_id';
	tab6.className='tabClicked';
	tabspan6.className='tabSpanclicked';
	tab5.className='tabA';
	tabspan5.className='tabAspan';
tab1.className='tabA';
	tabspan1.className='tabAspan';
	 tab3.className='tabA';
	tabspan3.className='tabAspan';
	 tab2.className='tabA';
	tabspan2.className='tabAspan';
tab7.className='tabA';
	tabspan7.className='tabAspan';
	 // tab4.className='tabA';
	// tabspan4.className='tabAspan';
	this.parent.bodyframe.document.location.href = '../../eXH/jsp/DatacrossElementstanderdSelectMasterMain.jsp';
//	this.parent.bodyframe.document.location.href = '../../eXH/jsp/DataElementCrossRefElementID.jsp';
	parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp';

	
	//parent.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?";
}


}
//******************************************************************/cc
