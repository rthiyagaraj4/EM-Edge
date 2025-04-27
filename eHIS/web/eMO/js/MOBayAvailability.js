           var bodwidth=0
			var bodheight=0

			function buildTable(val)
			{
				var rowval = val.split ("<br>");
				var nowrapval = "";
				var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>"

				for( var i=0; i<rowval.length; i++ )
				{
					if(rowval.length > 6)
					{
						var tempValue = i/2;

						if(tempValue == 0 || tempValue == 1 || tempValue == 2 || tempValue == 3 || tempValue == 4 || tempValue == 5 || tempValue == 6)
							tab_dat += "<tr>"

						//var colval = rowval[i].split("σσ")
						var colval = rowval[i].split("~~")
						if (colval[0] != "Blocked Remarks")
								nowrapval = "nowrap";
						else	nowrapval = "";
						if (colval[0] != "")
						{
							tab_dat += "<td class = 'label' nowrap align= 'right'> "+ colval[0] +": </td>"
							tab_dat += "<td class = 'QUERYDATA' "+nowrapval+"> "+ colval[1] +" </td>"
						}
						if(tempValue == 0.5 || tempValue == 1.5 || tempValue == 2.5 || tempValue == 3.5 || tempValue == 4.5 || tempValue == 5.5 || tempValue == 6.5)
							tab_dat += "</tr> "
					}
					else
					{
						//var colval = rowval[i].split("σσ")
						var colval = rowval[i].split("~~")
						if (colval[0] != "Blocked Remarks")
								nowrapval = "nowrap";
						else	nowrapval = "";
						if (colval[0] != "")
						{
						tab_dat += "<tr>"
						tab_dat += "<td class = 'label' nowrap align= 'right'> "+ colval[0] +": </td>"
						tab_dat += "<td class = 'QUERYDATA' "+nowrapval+" > "+ colval[1] +" </td>"
						tab_dat += "</tr> "
						}
					}
				}
				tab_dat += "</table> "
				if (document.getElementById("t") != null)
					document.getElementById("t").innerHTML = tab_dat
			}


        function closeWin(val,val2)
			{
			
				

			
			  if(val2== 'IP_LGreenButton'||val2== 'IP_BrownButton')
			   {
					//parent.window.returnValue = val
					//parent.window.close();
					let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = val;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();   
			   }
			}
			function displayToolTip(val,obj)
			{
				val = unescape(val)
				buildTable (val)
				bodwidth = parent.frames[1].document.body.offsetWidth
				bodheight = parent.frames[1].document.body.offsetHeight

				/*var x =event.x
				var y =event.y;*/
				 /*Above commented and below added by Rameswar on 22-Feb-16 for IE 11 Compatiability Issue [IN058863]*/
				var x =event.clientX;
				var y =event.clientY;

				x = x + (document.getElementById("tooltiplayer").offsetWidth)
				y = y + (document.getElementById("tooltiplayer").offsetHeight)

				if(x<bodwidth)
					x =event.clientX; //Modified by Rameswar on 22-Feb-16 for IE 11 Compatiability Issue [IN058863]
				else
					x = x - (document.getElementById("tooltiplayer").offsetWidth*2)

				if(y<bodheight )
					y =event.clientY;//Modified by Rameswar on 22-Feb-16 for IE 11 Compatiability Issue [IN058863]
				else if(event.y>bodheight)
					y = y - (document.getElementById("tooltiplayer").offsetHeight*2)
				else
					y = y - (document.getElementById("tooltiplayer").offsetHeight);

					y+=document.body.scrollTop
					x+=document.body.scrollLeft 
					document.getElementById("tooltiplayer").style.posLeft= x

				/*	if(document.getElementById("tooltiplayer").offsetWidth > 250)
						document.getElementById("tooltiplayer").style.posLeft = 111	
					else
						document.getElementById("tooltiplayer").style.posLeft = 275 */
					/*	Above Commented by Rameswar on 22-Feb-16 for IE 11 Compatiability Issue [IN058863] */

					document.getElementById("tooltiplayer").style.posTop = y 
					document.getElementById("tooltiplayer").style.visibility='visible' 
			}

			function hideToolTip()
			{
					document.getElementById("tooltiplayer").style.visibility='hidden'
			}
			
			var val2;
		
			function resetValues()
			{
				

				var frameset;
				if(parent.document.getElementById('dialog-body')){
					console.log(parent.document.getElementById('dialog-body').contentWindow)
					frameset=parent.document.getElementById('dialog-body').contentWindow;
				}else{
					frameset=parent;
				}
				frameset.processBar.document.location.href = "../../eCommon/html/blank.html";

				}

				function submitFunction(HTMLValue)
	{
		var HTMLVal = unescape(HTMLValue);
		parent.frames[4].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.frames[4].document.dummy_form.submit();
	}

function loadMortArea()
{

	document.MOBedAvailChartForm.search.click();
		
}

	function clearContent()
	{
		parent.frames[1].document.MOBedAvailChartForm.reset();	
		parent.frames[2].document.location.href = '../../eCommon/html/blank.html' ;
	}

	function getBedDetails()
	{
	
		document.MOBedAvailChartForm.submit();
	//	parent.processBar.document.location.href = "../../eCommon/html/process.html"; //  18776 Tuesday, February 02, 2010
	}

	function reset()
   {
	frames[1].frames[1].document.MOBedAvailChartForm.reset();
	frames[1].frames[2].document.location.href = '../../eCommon/html/blank.html' ;
  }
	
