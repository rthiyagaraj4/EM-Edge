/*
-------------------------------------------------------------------------------------------------------
Date        	 Edit History       Name         Description
-------------------------------------------------------------------------------------------------------
?              		100              ?            created
21/05/2013		 IN030708			Nijitha S	Bru-HIMS-CRF-221
07/06/2013		 IN040594           Nijitha S   CRF-CA-Bru-HIMS-CRF-221/09-Record Clinical Notes->Symbol Table screen is disappears
20/06/2013		 IN041022			Nijitha S   CRF-CA-Bru-HIMS-CRF-221/11-System is not displaying error message 
-------------------------------------------------------------------------------------------------------
*/

function changeText(val)
{	
	
	document.getElementById('display').innerHTML = val;
}

function closeWindow()
{
	
	window.close();
}


function storeSelectedSymbol(symbol,indicator)
{
		var totalSymbols = document.getElementById('totalSymbols').value;
		for(var i=0;i<totalSymbols;i++)
		{
			if(document.getElementById('symbol'+i).className!="")
			{
				document.getElementById('symbol'+i).className='grid1';
			}
		}
		document.getElementById('symbol'+indicator).className = 'borderhighlight';
		document.getElementById('selectedSymbol').value = symbol;
}

function insertSymOnDBLclk(obj)
{
	window.opener.EditorInsetSymbol(obj);
	window.focus();//IN040594
}

function borderHighLite(index)
{		
	document.getElementById('symbol'+index).className = 'borderhighlight';
}
	
function borderHighLiteRemove(index)
{
	document.getElementById('symbol'+index).className = 'grid1';
}
function insertSymbol()
{
	var symbol = document.displaySymbol.selectedSymbol.value;
	insertSymOnDBLclk(symbol);
}
//IN041022 Starts
function onLoadDefSymbol()
{
	var index=0;
	if(document.getElementById('symbol'+index)!=null)
	document.getElementById('symbol'+index).className='borderhighlight';
	
}
//IN041022 Ends
