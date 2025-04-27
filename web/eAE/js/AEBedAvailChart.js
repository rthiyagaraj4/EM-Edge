/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/****
	Created on 		: 22/02/2005 By Metilda. For AE Bed Avail Chart.
****/	
	function getTreatmentArea()
	{
		var clinic		        = document.AEBedAvailChartForm.clinic_code.value;
		var treatment_area		= document.AEBedAvailChartForm.treatment_area.value;
		var HTMLValue	= "<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dummy_form' id='dummy_form' action='../../eAE/jsp/AEReserveBedPopulateValue.jsp' method='post' ><input type='Hidden' name='function_name' id='function_name' value='BedAvailChart'><input type='Hidden' name='sub_function_name' id='sub_function_name' value='TreatmentArea'><input type='Hidden' name='field1' id='field1' value='"+clinic+"'><input type='Hidden' name='field2' id='field2' value='"+treatment_area+"'></form></body></html>"
//Tuesday, January 12, 2010 18108
		//parent.result.document.write(HTMLValue);
		//document.AEBedAvailChartForm.submit();

    	
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin', HTMLValue); parent.frames[2].document.dummy_form.submit();
		setTimeout(()=>{document.AEBedAvailChartForm.submit();},150);
	}
	
	function loadTreatmentArea()
	{
		document.AEBedAvailChartForm.search.click();
	}


	function submitFunction(HTMLValue)
	{

		var HTMLVal = unescape(HTMLValue);
		parent.frames[4].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.frames[4].document.dummy_form.submit();
	}

	
	function clearContent()
	{
		var treatment_area="";
		treatment_area=document.AEBedAvailChartForm.treatment_area;
		//while(treatment_area.options.length > 1)
					//treatment_area.remove(1);
		//Monday, January 11, 2010 18108
		//parent.frames[1].document.AEBedAvailChartForm.reset();	

		parent.frames[2].document.location.href = '../../eCommon/html/blank.html' ;
	}

	function getBedDetails()
	{
	//	parent.frames[2].document.location.href = '../../eAE/jsp/AEBedAvailChartResult.jsp' ;
		document.AEBedAvailChartForm.clinic_code.disabled = false;
		document.AEBedAvailChartForm.treatment_area.disabled = false;
		document.AEBedAvailChartForm.submit();
		parent.processBar.document.location.href = "../../eCommon/html/process.html";
	}	

	function specialChar(obj)
	{
		if(obj.value!='')
		{
			var fields1 = new Array(obj);
			var names1 = new Array(obj.name.toUpperCase());
			var messageFrame = ""; var error_page = "";
			if(SpecialCharCheck(fields1,names1,messageFrame,"A",error_page) )
			{
				if(CheckNum(obj))
				{
					 return true;
				}
				else 
				{
					 obj.focus();
					 return false;
				}
			}
			else 
			{
			   obj.focus()
			   return false;
			}
		}
		
	} 
	
	function submitPage()
	{
	}

	function checkFields1( fields, names)
	{
		var errors = "" ;
		for( var i=0; i<fields.length; i++ ) {
			if(trimCheck1(fields[i].value)) {}
			else	errors = errors + getMessage("CAN_NOT_BE_BLANK","Common") + names[i] + " cannot be blank..." + "\n" ;
		}
		if ( errors.length != 0 ) {
			alert(errors) ;
			return false ;
		}
		return true ;
	}
	function trimCheck1(inString)
	{
		var startPos;
		var ch;
		startPos = 0;
		strlength = inString.length;

		for(var i=0;i<=strlength;i++) {
			ch = inString.charAt(startPos);
			if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
				startPos++;
			}
		}
		if(startPos == inString.length) return false;
		else return true;
	}

	function removeitems(obj) 
	{
		var len=obj.length;
		var i=1;
		while(i<len)
		{
			len=obj.length
			obj.remove(i)
		}
	}
			
function buildTable(val)
			{
				var rowval = val.split ("<br>");
				var nowrapval = "";
				var i=2;
				var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>"
                 //alert('colval = rowval[i].split("^^")>>>'+rowval[i]);
				for( var i=0; i<rowval.length; i++ )
				{
				   if(rowval.length > 6)
					{
						var tempValue = i/2;

						if(tempValue == 0 || tempValue == 1 || tempValue == 2 || tempValue == 3 || tempValue == 4 || tempValue == 5 || tempValue == 6)
							tab_dat += "<tr>"
						//alert(rowval[i]);
                      	var colval = rowval[i].split("^^")
						if (colval[0] != "Blocked Remarks")
								nowrapval = "nowrap";
						else	nowrapval = "";
						if (colval[0] != "")
						{
							tab_dat += "<td class = 'label' nowrap> "+ colval[0] +": </td>"
							tab_dat += "<td class = 'QUERYDATA' "+nowrapval+"> "+ colval[1] +" </td>"
						}
						if(tempValue == 0.5 || tempValue == 1.5 || tempValue == 2.5 || tempValue == 3.5 || tempValue == 4.5 || tempValue == 5.5 || tempValue == 6.5)
							tab_dat += "</tr> "
					}
				else
					{
                    	var colval = rowval[i].split("^^")
						if (colval[0] != "Blocked Remarks")
								nowrapval = "nowrap";
						else	nowrapval = "";
						if (colval[0] != "")
						{
						tab_dat += "<tr>"
						tab_dat += "<td class = 'label' nowrap > "+ colval[0] +": </td>"
						tab_dat += "<td class = 'QUERYDATA' "+nowrapval+" > "+ colval[1] +" </td>"
						tab_dat += "</tr> "
						}
					}
				}
				
				tab_dat += "</table> "
				if (document.getElementById("t") != null)
					document.getElementById("t").innerHTML = tab_dat
			}

	function displayToolTip(val, obj) {
    val = decodeURIComponent(val);
    buildTable(val);
    
    var tooltip = document.getElementById("tooltiplayer");

    // Apply styling directly to the tooltip
    tooltip.style.position = 'absolute'; // Ensure it can be positioned freely
    tooltip.style.backgroundColor = 'white'; // White background
    tooltip.style.color = 'black'; // Black text for contrast
    tooltip.style.border = '1px solid #ccc'; // Light gray border
    tooltip.style.padding = '5px'; // Padding around the text
    tooltip.style.boxShadow = '0px 0px 5px rgba(0, 0, 0, 0.2)'; // Optional shadow for better visibility
    tooltip.style.zIndex = '1000'; // Ensure it appears above other content
    tooltip.style.visibility = 'hidden'; // Initially hidden
    
    var tooltipWidth = tooltip.offsetWidth;
    var tooltipHeight = tooltip.offsetHeight;

    // Get mouse position relative to the viewport
    var mouseX = event.clientX + window.scrollX;
    var mouseY = event.clientY + window.scrollY;

    // Define offsets for positioning the tooltip
    var offsetX = 10; // Horizontal offset from cursor
    var offsetY = 15; // Vertical offset from cursor

    // Calculate the initial tooltip position
    var tooltipX = mouseX + offsetX;
    var tooltipY = mouseY + offsetY;

    // Get viewport dimensions
    var viewportWidth = window.innerWidth + window.scrollX;
    var viewportHeight = window.innerHeight + window.scrollY;

    // Adjust position if the tooltip overflows the right edge
    if (tooltipX + tooltipWidth > viewportWidth) {
        tooltipX = mouseX - tooltipWidth - offsetX;
    }

    // Adjust position if the tooltip overflows the bottom edge
    if (tooltipY + tooltipHeight > viewportHeight) {
        tooltipY = mouseY - tooltipHeight - offsetY;

        // Ensure tooltip still fits within the viewport horizontally
        if (tooltipX + tooltipWidth > viewportWidth) {
            tooltipX = mouseX - tooltipWidth - offsetX;
        }
    }

    // Set the tooltip's position
    tooltip.style.left = tooltipX + 'px';
    tooltip.style.top = tooltipY + 'px';
    tooltip.style.visibility = 'visible';
}





			function hideToolTip()
			{
					document.getElementById("tooltiplayer").style.visibility='hidden'
			}
			
			function closeWin(val,val2, pseudo)
			{
				var val2;
				var select_check = '<%=select_check%>';
				

			   if (pseudo == "N" && select_check != "N" && val2 !='IP_GreenButton')
			   {
				   if(document.query_form.call_fn.value != 'query')
				   {
				   alert(getMessage("SPARE_BAY_CANT_BE_ASGNED",'AE'));	
				   return;
				   }
			   }
			   else if(val2 != 'IP_RedButton' && val2!='IP_BrownButton' && select_check != "N")
			   {
					parent.window.returnValue = val
					parent.window.close();
					/*const dialogTag = parent.parent.document.getElementById("dialog_tag");    
				    dialogTag.close();*/
			   }
			}

			function resetValues()
			{
				parent.processBar.document.location.href = "../../eCommon/html/blank.html";

			}  

