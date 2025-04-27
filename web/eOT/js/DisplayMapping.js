/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var param = "";
var TABLE_ID = 'DisplayDetailTable';
var CELL_COUNT = 2;

function create()
{	
	
	displayMappingFrame.location.href="../../eOT/jsp/DisplayMappingFrame.jsp?mode=insert"; 
}



// For adding multiple price range for package
async function addRow()
{
	//
	var err_msg = validateRow(document, "_1");
	if(err_msg != '')
	{
		return;
	}
	var index = 1;
	var table=document.getElementById(TABLE_ID);
	
	var rowCount = table.rows.length;
	
	
	var displayStatusName = table.rows[rowCount-1].cells[0].children[0];
	
	
	index = eval(getIndex(displayStatusName.name)) + 1;

	
	var row = table.insertRow(rowCount);
    
	    	
	for(var cellNo = 0; cellNo <= CELL_COUNT; cellNo++)
	{
		cell=row.insertCell(cellNo);
		if(cellNo != 2 )
		{
			cell.className = 'alignimgtext';
		}
		cell.innerHTML = getInnerHTMLForTable(index, cellNo);
		
		if(cellNo == 0)
		{
			cell.focus();
		}
		
	}
	setBackgroundColor(index);
	document.forms[0].totalCount.value = index;
	var rowCount = document.getElementById('rowCount');
	rowCount.value = eval(rowCount.value) + 1;
	clearRow(1);
}

function getInnerHTMLForTable(index,cellNo)
{
	var testInnerHTML = '';
	switch(cellNo)
	{
		case 0:
		{
			var displayStatus = document.forms[0].displayStatus_1.value;
			var colorCode = document.forms[0].colorCode_1.value;
			testInnerHTML = "<input type='hidden' name='displayStatus_"+ index + "' id='displayStatus_"+ index + "' value='" + displayStatus + "' >" + displayStatus;
			testInnerHTML += "<div class='colorspec midalign floatright ' id='colorCodeDiv_" +  index + "'> </div>" ;
			testInnerHTML += "<input type='hidden' name='colorCode_"+ index + "' id='colorCode_"+ index + "' value='" +  colorCode + "'>" ;
			testInnerHTML += "<input type='hidden' name='newRow_"+ index + "' id='newRow_"+ index + "' value='Y'>" ;
			testInnerHTML += "<input type='hidden' name='colorCodeVal_"+ index + "' id='colorCodeVal_"+ index + "' value='" +  colorCode + "' id='colorCodeVal_"+ index + "' value='" +  colorCode + "'>" ;
			break;
		}
		case 1:
		{
			var statusCode = getStatus(document.forms[0].statusCode_1, 1);
			var statusDesc = getStatus(document.forms[0].statusCode_1, 2);
			testInnerHTML = "<input type='hidden' name='statusCode_"+ index + "' id='statusCode_"+ index + "' value='" + statusCode + "' >" + statusDesc;
			testInnerHTML += "<input type='hidden' name='statusDesc_"+ index + "' id='statusDesc_"+ index + "' value='" + statusDesc + "' id='statusDesc_"+ index + "' value='" + statusDesc + "' >";
			break;
		}	
		case 2:
		{
			testInnerHTML = "<img src='../../eOT/images/Close.png' class='midalign' onclick='javascript:deleteRow("+ index + ", false)'/><span class='tbtxt' >Delete</span>";
			break;
		}
		
	}
	return testInnerHTML;
}


function deleteRow(index, appendId)
{
	
	var table = document.getElementById(TABLE_ID);
	var rowCount = table.rows.length;
	var rowCountObj = document.getElementById('rowCount');
	removedValue(index);
	for(var i=1; i<rowCount; i++)
	{
		var row = table.rows[i];
		//var displayStatusObj = row.cells[0].childNodes[0];
		var displayStatusObj =  table.rows[i].cells[0].children[0];
		var rowIndex = getIndex(displayStatusObj.name);
		
		if(rowIndex == index)
		{
			 var statusCodeObj = document.getElementById("statusCode_" + index);	
			 addStatus(statusCodeObj.value);
			 if(appendId)
			 {
				 document.forms[0].deleteId.value +=  displayStatusObj.value + "~";
			 }
		   	 table.deleteRow(i);
	    	 rowCount--;
	         i--;
	         rowCountObj.value = eval(rowCountObj.value) - 1;
		}
	}
}

function getIndex(delName)
{
	var index = delName.split("_");
	return index[1]; 
}

function apply()  
{	

var displayMappingFrameDocument = parent.frames[2].displayMappingFrame.document;

	//var displayMappingFrameDocument = eval(parent.frames[2].displayMappingFrame.displayMappingDtl.document);
	
	//if(displayMappingFrameDocument.forms[0]!=undefined)
	if(displayMappingFrameDocument.displayMappingDtl.document.forms[0]!=undefined)
	{
		//console.log("1");
			
		//frmObj = displayMappingFrameDocument.forms[0];
		frmObj=displayMappingFrameDocument.displayMappingDtl.document.forms[0];
		if(frmObj!="" && frmObj!=null && frmObj !=undefined )
		{
			
			var err_mess = validateInsert(displayMappingFrameDocument.displayMappingDtl.document);
			//check for assignment date
			if (err_mess != "")
			{
				parent.frames[2].frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+err_mess;
			}
			else
			{
				var xmlString=formXMLStringMain(frmObj);
				var updation=formValidation(xmlString,"INSERT");
				displayMappingFrameDocument.displayMappingDtl.document.forms[0].target='messageFrame';
				displayMappingFrameDocument.displayMappingDtl.document.forms[0].method="post";
				displayMappingFrameDocument.displayMappingDtl.document.forms[0].action="../../servlet/eOT.DisplayMappingServlet";
				
		//console.log("4.1");
		displayMappingFrameDocument.displayMappingDtl.document.forms[0].submit();
				//console.log("4.2");
			}
		
		}
			
	}// END IF Frame Undefined check
}


function formXMLStringMain(frmObj)
{
    if( frmObj!=null && frmObj != "undefined" && frmObj.length >0)
	{	
		var xmlStr ="<root><SEARCH ";
		if(true)
		{
		var arrObj = frmObj.elements;
		for(var i=0;i<arrObj.length;i++)
		{
			var val = "" ;
			if(arrObj[i].type == "checkbox")
			{
				if(arrObj[i].checked)
				{
					val = arrObj[i].value;
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
				}
	        }
		    else if(arrObj[i].type == "radio")
			{
				if(arrObj[i].checked)
				{
					val = arrObj[i].value;
			        if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	            }
		    }
			else if(arrObj[i].type == "select-multiple" )
			{
				for(var j=0; j<arrObj[i].options.length; j++)
			    {
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
	            }
		        val= val.substring(0,val.lastIndexOf('~'))
			    if(arrObj[i].name != null && arrObj[i].name != "")
				    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
		    else
			{
				val = arrObj[i].value;
		        if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	        }
		}
	}
	xmlStr +=" /></root>";	
	}
//alert("xmlStr :"+xmlStr);
	return xmlStr;
}

//XML String passing for validation
function formValidation(xmlStr,last_link,event)
{	 
	
	var temp_jsp="DisplayMappingValidation.jsp?func_mode="+last_link;
	if(event!=null && event == "delete")
		temp_jsp="DisplayMappingValidation.jsp?func_mode="+last_link+"&event="+event;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText ;
	//eval(responseText);
	return true;
}

function onSuccess()
{
	displayMappingFrame.location.href="../../eOT/jsp/DisplayMappingFrame.jsp?mode=insert"; 
}

function reset()
{
	displayMappingFrame.document.location.reload();			
}

function clearRow(index)
{
	rowErrands();
	document.getElementById("displayStatus_"+index).value = '';
	//document.getElementById("statusCode_"+index).selectedIndex = 0;
	document.getElementById("colorCode_1").value = '';
	
}



		
function validateRow(doc , appendIndex)
{
	var fieldArray = ["displayStatus", "statusCode", "colorCode"];
	var fieldLabel = [getLabel("eOT.DisplayStatus.Label","OT"), getLabel("eOT.OTSlateStatus.Label","OT"), "Color"];
	var msg1 = '';
	
	for(var i=0; i<fieldArray.length; i++)
	{
		var fieldobj = doc.getElementById(fieldArray[i] + appendIndex ).value;
		if(fieldobj==null || fieldobj==""){
			msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",fieldLabel[i]);
			alert(msg1);
			break;
		}
	}
	
	return  msg1;
}


function validateInsert(doc)
{
	var err_mess = '';
	
	var rowCount = doc.getElementById('rowCount').value;
	if(rowCount == 0)
	{
		err_mess = "Atleast one row needs to be added";
		alert(err_mess);
		return err_mess;
	}
	
	var refreshIntervalTime = doc.getElementById('refreshIntervalTime').value;
    var refreshInterval = doc.getElementById('refreshInterval').value;	//this line added for the incident [44518]
	if(refreshIntervalTime <5 && refreshInterval=="S")
	{
		err_mess = "Allowed numeric value between the value 5 to 99 ";
		alert(err_mess);
		return err_mess;
	}
	if(refreshIntervalTime<1 && refreshInterval=="M")
	{
		err_mess = "Allowed numeric value value 1 to 99";
		alert(err_mess);
		return err_mess;
	}
	//Above if condtion only added for the incident [44518]
	
	err_mess = checkForDuplicates(doc);
	return err_mess;
}

function getStatus(statusObj, opt)
{
	var valueString = "";
	if(statusObj.options.length == 0)
	{
		document.getElementById("addBtn").disabled = true;
	}
	
	for (var i = 0; i < statusObj.options.length; i++) 
	{
	 
		if(statusObj.options[i].selected) 
		{
			if(opt == 1)
			{
				valueString += statusObj.options[i].value + ","; 
			}
			else
			{
				valueString += statusObj.options[i].text + ",";
			}
			
		}
	}
	return valueString.substring(0, valueString.length -1);
}

function rowErrands()
{
	var statusObj = document.forms[0].statusCode_1;
	
	var selectedArray = new Array();
	var j=0;
	
	for (var i = 0; i < statusObj.options.length; i++) 
	{
		if(statusObj.options[i].selected )
		{
			selectedArray[j++] =  i;
		};
	 }
	removeSelectedStatus(selectedArray);
	var colorCodeDiv = document.getElementById("colorCodeDiv_1");
	colorCodeDiv.style.backgroundColor="#FFFFFF";
}

function removeSelectedCode(codeString, index)
{
	var optionValue = '';
	var statusObj = document.getElementById("statusCode_1");
	var selectedArray = new Array();
	var j = 0;
	for (var i = 0; i < statusObj.options.length; i++) 
	{
		optionValue = statusObj.options[i].value;
		
		if(codeString.indexOf(optionValue) >= 0)
		{
			selectedArray[j++] =  i;
		};
	 }
	
	removeSelectedStatus(selectedArray);
}
function removeSelectedStatus(selectedArray)
{
	var subIndex = 0;
	var statusObj = document.getElementById("statusCode_1");
	for(var i =0;i<selectedArray.length;i++)
	{
		var removeIndex = selectedArray[i] - subIndex;
		statusObj.remove(removeIndex);
		subIndex++;
	}
	if(statusObj.options.length == 0)
	{
		document.getElementById("addBtn").disabled = true;
	}
}

function setBackgroundColor(index)
{
	var selectedColor = document.getElementById("colorCode_1").value;
	var colorCodeDiv = document.getElementById("colorCodeDiv_" + index);
	colorCodeDiv.style.backgroundColor=selectedColor;
}

function addStatus(statusCodes)
{
	var statusCodeObj = document.getElementById("statusCode_1");
	
	for(var i=0;i<statusCodeObj.options.length;i++)
	{
		statusCodes += statusCodeObj.options[i].value + ",";
	}
	sortAndPopulate(statusCodes);
}


function sortAndPopulate(statusCodesValue) 
{
	var statusCodeObj = document.getElementById('statusCode_1');
	var statusCodes = statusCodesValue.split(",");
	statusCodeObj.options.length = 0;
	
	for(var i=0; i<statusCodeObj.length; i++)  {
	  statusCodes[i] = statusCodeObj.options[i].value;
	}

	statusCodes.sort(sortfunction);

	// Add ALL
	for(var i=0; i<statusCodes.length; i++)  
	{
		for(var j=0; j < otStatusArray.length; j++)
		{
			if(otStatusArray[j][0] == statusCodes[i])
			{
				statusCodeObj.options[statusCodeObj.options.length] = new Option(otStatusArray[j][1], otStatusArray[j][0]);
				break;
			}	
		}
	}
	if(document.getElementById("addBtn").disabled)
	{
		document.getElementById("addBtn").disabled = false;
	}
}

function sortfunction(a,b)
{
	return a - b;
}


/*Check for special character on Blur of numeric field  */
function numberCheck(obj,type,mode)
{
	if(obj.value != "")
	{
		if(CheckNum(obj))
		{
			if(type=="M")
				check_months(obj)
			else  if(type=="D")
				check_days(obj)
			else  if(type=="V")
				chkValidDays(obj,mode)
			else  if(type=="P")
				return validPercentage(obj,type)
		}
	}
}

async function preview()
{	 
	var refreshIntervalTime= document.forms[0].refreshIntervalTime.value;
	var refreshInterval= document.forms[0].refreshInterval.value;
	var err_mess = validateInsert(document);
	//check for assignment date
	if (err_mess != "")
	{
		return;
	}
	var totalCount = document.forms[0].totalCount.value;
	var dialogTop = "0";
	var dialogHeight = "600px"; 
	var dialogWidth = "900px";	
	var status = "no";
	var arguments = "" ;
	var displayStatus = "";
	var colorCodeVal = "";
	var statusCodeVal = "";
	var multiFlag = true;
	var statusCodeValArray = new Array();
	if(param != '')
		param = param + ',';
	for(var z=2; z<=totalCount; z++)
	{
		multiFlag = true;
		if(document.getElementById("displayStatus_" + z) != null)
			displayStatus = document.getElementById("displayStatus_" + z).value;
		if(document.getElementById("colorCodeVal_" + z) != null)
			colorCodeVal = document.getElementById("colorCodeVal_" + z).value;
		if(document.getElementById("statusCode_" + z) != null)
		{
			statusCodeVal = document.getElementById("statusCode_" + z).value;
			if(statusCodeVal.indexOf(",") != -1)
			{
				statusCodeValArray = statusCodeVal.split(",");
				for(var i=0; i < statusCodeValArray.length; i++)
				{
					if(statusCodeValArray[i].length > 0)
					{
						statusCodeVal = statusCodeValArray[i];
						param = param + statusCodeVal + "~~" + encodeURIComponent(displayStatus) + "~" + colorCodeVal.substring(1, colorCodeVal.length) + ",";
					}
				}
				multiFlag = false;
			}
		}
		if(displayStatus != '' && colorCodeVal != '' && statusCodeVal != '' && multiFlag)
			param = param + statusCodeVal + "~~" + encodeURIComponent(displayStatus) + "~" + colorCodeVal.substring(1, colorCodeVal.length) + ",";
	}
	if(param != '')
		param = param.substring(0, param.length-1);
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:" + dialogTop + "; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eOT/jsp/PatientStatusMain.jsp?"+param, arguments, features);
		
}

var dashboardWindow;
function displayDashboard()
{	 
	
	/*var dialogTop = "0";
	var dialogHeight = "80"; 
	var dialogWidth = "80";	
	var status = "no";
	var arguments = "" ;*/
	
	var params = [
	              'height='+screen.height,
	              'width='+screen.width,
	              'fullscreen=yes,dialog=yes' // only works in IE, but here for completeness
	          ].join(',');
	dashboardWindow = window.open('../../eOT/jsp/PatientStatusMain.jsp', 'PatientDashboard', params); 
	dashboardWindow.moveTo(0,0);
	
					 
	//var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTop:" + dialogTop + "; scroll=no; status:" + status;
	//dashboardWindow = window.open("../../eOT/jsp/PatientStatusMain.jsp?width=200&height=200");
	
	document.getElementById("displayBtn").disabled = true;
	document.getElementById("displayCloseBtn").disabled = false;
}

function closeDashboard()
{	 
	dashboardWindow.close();
	document.getElementById("displayBtn").disabled = false;
	document.getElementById("displayCloseBtn").disabled = true;
	
}


function checkForDuplicates(doc)
{
	var rowCount = doc.getElementById('rowCount').value;
	var recCount = 0;
	var msg1 = '';
	for(var i=2; recCount < rowCount ; i++)
	{
		var appendIndex = "_" + i;
		var objValue = doc.getElementById("displayStatus" + appendIndex);
		
		if(objValue != null )
		{
			recCount++;
			var jRecCount = 0;
			for(var j=i+1; jRecCount < rowCount ; j++)
			{
				var jAppendIndex = "_" + j;
				var objValue1 = doc.getElementById("displayStatus" + jAppendIndex);
				jRecCount++;
				if(objValue1 != null && (i != j))
				{
					if(objValue.value == objValue1.value)
					{
						msg1 = "Duplicate Rows Found";
						alert(msg1);
						return msg1;
					}
				}
			}
		}
	} 
	return msg1;
}
function checkForSpecCharsforID(event)
{
	if (!(event.keyCode  > 96 &&  event.keyCode < 123)  &&  !(event.keyCode >=65  &&  event.keyCode <=90) &&  !(event.keyCode >=48  &&  event.keyCode <=57)
		&& !( event.keyCode == 38) && !( event.keyCode == 45) && !( event.keyCode == 95) && !( event.keyCode == 32))
	{
		return false;
	}
    return true;
}
function removedValue(y)
{
	var z = parseInt(y);
	var displayStatus = "";
	var colorCodeVal = "";
	var statusCodeVal = "";
	var multiFlag = true;
	var statusCodeValArray = new Array();
	var displayStatusArray = new Array();
	if(param != '')
		param = param + ',';
	if(document.getElementById("statusDesc_" + z) != null)
		displayStatus = document.getElementById("statusDesc_" + z).value;
	if(document.getElementById("colorCodeVal_" + z) != null)
		colorCodeVal = document.getElementById("colorCodeVal_" + z).value;
	if(document.getElementById("statusCode_" + z) != null)
	{
		statusCodeVal = document.getElementById("statusCode_" + z).value;
		if(statusCodeVal.indexOf(",") != -1)
		{
			statusCodeValArray = statusCodeVal.split(",");
			displayStatusArray = displayStatus.split(",");
			for(var i=0; i < statusCodeValArray.length; i++)
			{
				if(statusCodeValArray[i].length > 0)
				{
					statusCodeVal = statusCodeValArray[i];
					displayStatus = displayStatusArray[i];
					param = param + statusCodeVal + "~~" + unescape(displayStatus) + "~" + colorCodeVal.substring(1, colorCodeVal.length) + ",";
				}
			}
			multiFlag = false;
		}
	}
	if(displayStatus != '' && colorCodeVal != '' && statusCodeVal != '' && multiFlag)
		param = param + statusCodeVal + "~~" + encodeURIComponent(displayStatus) + "~" + colorCodeVal.substring(1, colorCodeVal.length) + ",";
	if(param != '')
		param = param.substring(0, param.length-1);
}

