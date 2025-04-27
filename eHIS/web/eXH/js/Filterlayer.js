//function callJSPs
function callJSPs(code,str,which)
{
							   
	  if(which=='table')
	{
	  		var tab1=parent.frames[1].document.getElementById("filterruletab");
		var tabspan1=parent.frames[1].document.getElementById("filterruletab_tabspan");
		var tab2=parent.frames[1].document.getElementById("segmentruletab");
		var tabspan2=parent.frames[1].document.getElementById("segmentruletab_tabspan"); 
		if (str=='segmentruletab') 
		{
																	  
			tab1.className='tabA';						  								    
			tabspan1.className='tabAspan';								  		   
			tab2.className='tabClicked';										   
			tabspan2.className='tabSpanclicked'; 

				
			parent.frames[2].document.location.href='../../eXH/jsp/FilterLayerGroupFilterLevalSearch.jsp?'+parent.frames[1].document.getElementById('params').value+'&filter_code='+code;
			//'+document.getElementById('params').value+'&filter_code='+code;		  
			//fun_id='+document.forms[0].fun_id.value;
			parent.frames[3].location.href='../../eCommon/html/blank.html';
			parent.frames[4].location.href='../../eCommon/jsp/error.jsp';
		}	
	}
	else
	{	
		var tab1=document.getElementById("filterruletab");
		var tabspan1=document.getElementById("filterruletab_tabspan");
		var tab2=document.getElementById("segmentruletab");
		var tabspan2=document.getElementById("segmentruletab_tabspan");
		if (str=='filterruletab')
		{  
			tab1.className='tabClicked';
			tabspan1.className='tabSpanclicked';
			tab2.className='tabA';
			tabspan2.className='tabAspan';
			parent.frames[2].location.href='../../eXH/jsp/FilterLayerGroupLevalSearch.jsp?'+document.getElementById('params').value;
			parent.frames[3].location.href='../../eCommon/html/blank.html';
			parent.frames[4].location.href='../../eCommon/jsp/error.jsp';
		}
		if (str=='segmentruletab') 
		{
			
			tab1.className='tabA';						  								    
			tabspan1.className='tabAspan';								  
			tab2.className='tabClicked';										   
			tabspan2.className='tabSpanclicked'; 
			parent.frames[2].location.href='../../eXH/jsp/FilterLayerGroupFilterLevalSearch.jsp?'+document.getElementById('params').value+'&filter_code='+code;		  
			//fun_id='+document.forms[0].fun_id.value;
			parent.frames[3].location.href='../../eCommon/html/blank.html';
			parent.frames[4].location.href='../../eCommon/jsp/error.jsp';
		}	
	}
			
}
function funChangeFacility(obj)																				   
{
	var val = this.document.forms[0].applicationid.value;
	if ((val=='') ||(val==null))
	{
		alert(getMessage('XH1003','XH'));
		obj.value = '';
	}
} 

function onSelectMessageType(obj)
{
	var val1 = this.document.forms[0].applicationid.value;
	var val2 = this.document.forms[0].facilityid.value;
	var val3 = this.document.forms[0].message_type.value;
	if ((val1=='')||(val2=='')||(val1==null)||(val2==null))
	{
		alert(geteMessage('XH1004','XH'));
		obj.value = '';
	}
	onPage(3);
	parent.filterframe.location.href="../../eCommon/html/blank.html";
	parent.recordframe.location.href="../../eCommon/html/blank.html";
	parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	
}

//function chnage
function change()
{
	var tab1=document.getElementById("filterruletab");
	var tabspan1=document.getElementById("filterruletab_tabspan");
	var tab2=document.getElementById("segmentruletab");
	var tabspan2=document.getElementById("segmentruletab_tabspan");
	var tab3=document.getElementById("schedulingruletab");
	var tabspan3=document.getElementById("schedulingruletab_tabspan");						   
	tab1.className='tabA';
	tabspan1.className='tabAspan';
	tab2.className='tabA';
	tabspan2.className='tabAspan';
	tab3.className='tabA';
	tabspan3.className='tabAspan';
	parent.filterframe.location.href="../../eCommon/html/blank.html";
	parent.recordframe.location.href="../../eCommon/html/blank.html";
	parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
