//******************************************************************/
//function onSelectAppliction
//******************************************************************/
function onSelectAppliction()
{ 

//var stnd_code=document.forms[0].Standardcode_combo.value;
//var seg_type=document.forms[0].segment_type.value;
var appl =  this.document.forms[0].application.value; 

if(appl=='')
	{
	parent.frames[2].document.location.href='../../eCommon/html/blank.html';
	parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp'; 
	
	
	return; 
	}
var code_yn=this.document.forms[0].code.value;
parent.frames[2].document.location.href='../../eXH/jsp/DataElementCrossRefApplicationElementSetupResult.jsp?applicationid='+appl;
parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
/*parent.frames[2].document.location.href='../../eXH/jsp/DataElementCrossRefApplicationElementSetupResult.jsp?applicationid='+appl+'&segment_type_id='+seg_type+'&standard_code='+stnd_code+'&element_id=&element_desc=';
parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';*/

}
//******************************************************************/
//function callJSPs
//******************************************************************/

function callJSPs(str)
{       
var stnd_code=document.forms[0].Standardcode_combo.value;
//		alert("stnd_code : "+stnd_code);
	var seg_type=document.forms[0].segment_type.value;
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
	//	alert(getMessage('XH1003','XH'));
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
		parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
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
		parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
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
		var element_id='';
		var element_desc='';
		this.window.parent.parent.frames[1].document.forms[0].tab.value='usage';
		tab11.className='tabClicked';
		tabspan1.className='tabSpanclicked';
		tab22.className='tabA';
		tabspan2.className='tabAspan';
		tab33.className='tabA';
		tabspan3.className='tabAspan';
		//onPage(0);
      this.parent.frames[1].document.location.href='../../eXH/jsp/DataElementCrossRefApplicationElementSetupMain.jsp?applicationid='+appl+'&segment_type_id='+seg_type+'&standard_code='+stnd_code+'&element_id='+element_id+'&element_desc='+element_desc;
  	  parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
	} 
	 
}
//***************************************************************************************/
