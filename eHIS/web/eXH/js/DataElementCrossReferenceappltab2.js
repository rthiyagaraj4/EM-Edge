//******************************************************************/
//function onSelectAppliction
//******************************************************************/
function onSelectAppliction()
{

var tab11=document.getElementById("tab1");
var tabspan1=document.getElementById("tab1_tabspan");
var tab22=document.getElementById("tab2");
var tabspan2=document.getElementById("tab2_tabspan");
var tab33=document.getElementById("tab3");
var tabspan3=document.getElementById("tab3_tabspan");

tab11.className='tabA';
tabspan1.className='tabAspan';
tab22.className='tabA';
tabspan2.className='tabAspan';
tab33.className='tabA';
tabspan3.className='tabAspan';
this.parent.frames[3].document.location.href='../../eCommon/html/blank.html';
parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';

}
//******************************************************************/
//function callJSPs
//******************************************************************/

function callJSPs(str)
{

	var tab11=document.getElementById("tab1");
	var tabspan1=document.getElementById("tab1_tabspan");
	var tab22=document.getElementById("tab2");
	var tabspan2=document.getElementById("tab2_tabspan");
	var tab33=document.getElementById("tab3");
	var tabspan3=document.getElementById("tab3_tabspan");

	var appl =  this.document.forms[0].application.value; 
	var code_yn=this.document.forms[0].code.value;
	
	if (appl == '')
	{
		alert(getMessage('XH1003','XH'));
		return;
	}

	if(str!='tab1'){
	if(code_yn=='Y'){
	if(str=='tab2')
	{
		this.window.parent.parent.frames[1].document.forms[0].tab.value='table_values';
		tab11.className='tabA';
		tabspan1.className='tabAspan';
		tab22.className='tabClicked';
		tabspan2.className='tabSpanclicked';
		tab33.className='tabA';
		tabspan3.className='tabAspan';
        this.parent.frames[1].document.location.href='../../eXH/jsp/DataElementCrossRefModuleCodeSetupMain.jsp?application='+appl;
		parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
	}
	if(str=='tab3')
	{
		this.window.parent.parent.frames[1].document.forms[0].tab.value='non_table_values';
		tab11.className='tabA';
		tabspan1.className='tabAspan';
		tab22.className='tabA';
		tabspan2.className='tabAspan';
		tab33.className='tabClicked';
		tabspan3.className='tabSpanclicked';
        this.parent.frames[1].document.location.href='../../eXH/jsp/DataElementCrossRefNonTableValuesSetupMain.jsp?application='+appl;
		parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
	}
	}
	else{
               alert(getMessage("XH1031","XH"));
	           this.document.forms[0].focus();
	           return false;

	      }
	}

    if(str=='tab1')
	{
alert(this.parent.frames[2].name);
this.parent.frames[2].document.forms[0].tab.value='usage';
		//this.window.parent.parent.frames[1].document.forms[0].tab.value='usage';
		tab11.className='tabClicked';
		tabspan1.className='tabSpanclicked';
		tab22.className='tabA';
		tabspan2.className='tabAspan';
		tab33.className='tabA';
		tabspan3.className='tabAspan';
		//onPage(0);
      this.parent.frames[3].document.location.href='../../eXH/jsp/DataElementCrossRefApplicationElementSetup.jsp?applicationid='+appl;
  	  parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
	}
	
}
//***************************************************************************************/
