/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var TABLE_ID = 'AssignmentTimeTable';
var CELL_COUNT = 5;
var ROLE_TABLE_ID = 'RoleTable';

function create()
{	
	
	staffAssigmentFrame.location.href="../../eOT/jsp/StaffAssignmentFrame.jsp?mode=insert"; 
}

async function searchDoctor(roleObj,obj,target)
{
	var formObj = document.StaffAssignmentForm;
	var locale = document.forms[0].locale.value;
	var roleType = roleObj.value;
	var tit = "Name";
	
	if(roleType != null && roleType !="" && roleType !="undefined")
	{
		var tcode = obj.value;
		var tdesc = target.value;
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var role = roleType.split('~');
		
		var sql="SELECT PRACTITIONER_NAME description, PRACTITIONER_ID code FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale
		+"'  AND NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN ( SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE ='"+role[1]
		+"') AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?) AND UPPER(PRACTITIONER_ID) LIKE UPPER(?) ORDER BY 1"; 
		

		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,1";
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
	
		retVal = await CommonLookup( tit, argumentArray );
		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			obj.value = arr[0];
			target.value=arr[1];
		}
		else
		{
			nationality_code.value = arr[0]; 
			nationality_desc.value = arr[1]; 
			desc.value=arr[1];
			code.value=arr[0];
			target.value="";
			obj.value="";
		}
	}
	else
	{
		//var msg="APP-OT35 Role Cannot be blank...";
		var msg=getMessage("CANNOT_BE_BLANK","OT");
		var msgArr=msg.split("&");
		msg=msgArr[0] + tit +msgArr[1];
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
	}
}

// For adding multiple price range for package
async function addRow()
{	// alert("addRow : "+table.rows[rowCount-1].cells[0].childNodes[0]);
	if(chkAllselect()) //added by chaitanya October 23, 2013
	{
		var err_msg = validateRow(document, "_1");
		if(err_msg != '')
			return;
		var index = 1;
		var table=document.getElementById(TABLE_ID);
		var rowCount = table.rows.length;
		var roleTypeCombo = table.rows[rowCount-1].cells[0].children[0];
		
		index = eval(getIndex(roleTypeCombo.name)) + 1;
		var row = table.insertRow(rowCount);
		for(var cellNo = 0; cellNo <= CELL_COUNT; cellNo++)
		{
			cell=row.insertCell(cellNo);
			if(cellNo != 2 && cellNo != 5)
				cell.className = 'alignimgtext';
			cell.innerHTML = getInnerHTMLForTable(index, cellNo);
			if(cellNo == 0)
				cell.focus();
		}

		var rowCount = document.getElementById('rowCount');
		rowCount.value = eval(rowCount.value) + 1;
		clearRow(1);
		//if(rowCount.value==1){
			fxheaderInit('AssignmentTimeTable',400);
		//}
	}
}

function getInnerHTMLForTable(index,cellNo)
{
	var testInnerHTML = '';
	switch(cellNo)
	{
		case 0:
		{
			var selectedIndex = document.forms[0].roleType_1.selectedIndex;
			var roleId = document.forms[0].roleType_1.value;
			var roleDesc = document.forms[0].roleType_1.options[selectedIndex].text;
			testInnerHTML = "<input type='hidden' name='roleType_"+ index + "' id='roleType_"+ index + "' value='" + roleId + "' >" + roleDesc;
			break;
		}
		case 1:
		{
			var practitionerId = document.forms[0].practitionerId_1.value;
			var practitionerName = document.forms[0].practitionerName_1.value;
			testInnerHTML = "<input type='hidden' name='practitionerId_"+ index + "' id='practitionerId_"+ index + "' value='" + practitionerId + "' >" + practitionerName;
			break;
		}	
		case 2:
		{
			var check = "";
			if(document.forms[0].showWidgetYN_1.checked)
			{
				check = "checked";
			}
				testInnerHTML = "<input class='brdclr' type='checkbox' name='showWidgetYN_"+ index + "' id='showWidgetYN_"+ index + "' value='Y'" + check + "/>";
			break;
		}
		case 3:
		{
			testInnerHTML = "<input class='brdclr' type='text' name='fromTime_"+ index + "' id='fromTime_"+ index + "' size='5' value='" + document.forms[0].fromTime_1.value + "'  onblur='javascript:checkTimeFormat(this)'/>";
			break;
		}
		case 4:
		{
			testInnerHTML = "<input class='brdclr' type='text' name='toTime_"+ index + "' id='toTime_"+ index + "' size='5'  value='" + document.forms[0].toTime_1.value + "'  onblur='javascript:checkTimeFormat(this)'/>";
			break;
		}
		case 5:
		{
			testInnerHTML = "<img src='../../eOT/images/Close.png' class='midalign' onclick='javascript:deleteRow("+ index + ")'/><span class='tbtxt' >Delete</span>";
			break;
		}
		
	}
	return testInnerHTML;
}

function populateAndSetCombo(roleTypeCode, index)
{
	
	var roleTypeCombo = document.getElementById('roleType_' + index);
	roleTypeCombo.options.length = 0;
	var roleTypeArray = parent.frames[0].roleTypeArray;
	roleTypeCombo.options.add(new Option("Select", ""));
	for(var i=0; i< roleTypeArray.length; i++)
	{
		roleTypeCombo.options.add(new Option(roleTypeArray[i][1], roleTypeArray[i][0]));
	}
	if(roleTypeCode != null && roleTypeCode != "")
	{
		roleTypeCombo.value= roleType;	
	}
	
}

function deleteRow(index)
{
	
	var table = document.getElementById(TABLE_ID);
	
	var rowCount = table.rows.length;
	
	var rowCountObj = document.getElementById('rowCount');
	
	
	for(var i=1; i<rowCount; i++)
	{
		var row = table.rows[i];
		var roleTypeCombo = row.cells[0].children[0];
		var rowIndex = getIndex(roleTypeCombo.name);
		
		if(rowIndex == index)
		{
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
	
	var staffAssignFrameDocument = eval(parent.frames[2].staffAssigmentFrame.staffAssignmentDtl.document);
	
	if(staffAssignFrameDocument.forms[0]!=undefined)
	{
			
		frmObj = staffAssignFrameDocument.forms[0];
		if(frmObj!="" && frmObj!=null && frmObj !=undefined )
		{
			if(frmObj.mode.value == "insert")
			{
				var err_mess = validateInsert(staffAssignFrameDocument);
				//check for assignment date
				if (err_mess != "")
				{
					parent.frames[2].frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+err_mess;
				}
				else
				{
					var xmlString=formXMLStringMain(frmObj);
					var updation=formValidation(xmlString,"INSERT");
					staffAssignFrameDocument.forms[0].target='messageFrame';
					staffAssignFrameDocument.forms[0].method="post";
					staffAssignFrameDocument.forms[0].action="../../servlet/eOT.StaffAssignmentServlet";
					staffAssignFrameDocument.forms[0].submit();
				}
			}
			else
			{
					var staffAssignFrameRoleDocument = eval(parent.frames[2].staffAssigmentFrame.staffAssignmentRoleDtl.document);
					
					var err_mess = validateUpdate(staffAssignFrameRoleDocument);
					if (err_mess != "")
					{
						parent.frames[2].frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+err_mess;
					}
					else
					{
						frmObj = staffAssignFrameRoleDocument.forms[0];
						var xmlString=formXMLStringMain(frmObj);
						var updation=formValidation(xmlString,"UPDATE");
						staffAssignFrameDocument.forms[0].target='messageFrame';
						staffAssignFrameDocument.forms[0].method="post";
						staffAssignFrameDocument.forms[0].action="../../servlet/eOT.StaffAssignmentServlet";
						staffAssignFrameDocument.forms[0].submit();	
					}
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
	return xmlStr;
}

//XML String passing for validation
function formValidation(xmlStr,last_link,event)
{	 
	
	var temp_jsp="StaffAssignmentValidation.jsp?func_mode="+last_link;
	if(event!=null && event == "delete")
		temp_jsp="StaffAssignmentValidation.jsp?func_mode="+last_link+"&event="+event;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText ;
	responseText = responseText.replace(/<\/?[^>]+(>|$)/g, "");
	eval(responseText);
	return true;
}

function onSuccess()
{
	staffAssigmentFrame.location.href="../../eOT/jsp/StaffAssignmentFrame.jsp?mode=insert"; 
}

function reset()
{
	staffAssigmentFrame.document.location.reload();			
}

function clearRow(index)
{
	document.getElementById("roleType_"+index).selectedIndex = 0;
	document.getElementById("practitionerId_"+index).value = '';
	document.getElementById("practitionerName_"+index).value = '';
	document.getElementById("showWidgetYN_"+index).checked = false;
	document.getElementById("fromTime_"+index).value = '';
	document.getElementById("toTime_"+index).value = '';
	
}

function submitQueryPage()
{
	if(validateQueryPage())
	{
		var selectedIndex = document.forms[0].operRoomCode.selectedIndex;
		// console.log(document.forms[0]);
		document.forms[0].operRoomDesc.value = document.forms[0].operRoomCode.options[selectedIndex].text; 
		document.forms[0].action = "../../eOT/jsp/StaffAssignmentFrame.jsp?mode=modify";
	    document.forms[0].target = "staffAssigmentFrame";
		document.forms[0].submit();
	}
	else
	{
		document.forms[0].operRoomCode.options[0].selected = true;
	}
}

function validateQueryPage()
{
	var fieldArray = ["assignmentFromDate", "assignmentToDate", "operRoomCode"];
	var fieldLabel = ["From Date", "To Date","Room"];
	var msg1 = '';
	
	for(var i=0; i<fieldArray.length; i++)
	{
		var fieldobj = document.getElementById(fieldArray[i] ).value;
		if(fieldobj==null || fieldobj==""){
			msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",fieldLabel[i]);
			alert(msg1);
			return false;
		}
	}	
	var fromDate = document.getElementById("assignmentFromDate").value;
	var toDate =  document.getElementById("assignmentToDate").value;
	
	if(!isBefore(fromDate,toDate, "DMY", 'en') )
	{
		msg1 = "From Date should be less than To Date";
		alert(msg1);
		return false;
	}
	
	var days = daysBetween(fromDate,toDate, "DMY", 'en');
	if(days > 30)
	{
		msg1 = "Date duration cannot exceed one month";
		alert(msg1);
		return false;
	}
	return true;
}
/**
 * Load the query page
 */
function query()
{
	staffAssigmentFrame.location.href="../../eOT/jsp/StaffAssignmentQueryCriteria.jsp";
}

function addRoleRow(dateIndex)
{
	var err_msg = validateRow(document, dateIndex + "_1");
	if(err_msg != '')
	{
		return;
	}
	var index = 1;
	var table=document.getElementById(ROLE_TABLE_ID + dateIndex);
	
	var rowCount = table.rows.length;
	
	
	var roleTypeCombo = table.rows[rowCount-1].cells[0].children[0];
	index = eval(getIndex(roleTypeCombo.name)) + 1;
	
	var row = table.insertRow(rowCount);
	    	
	for(var cellNo = 0; cellNo <= CELL_COUNT; cellNo++)
	{
		cell=row.insertCell(cellNo);
		if(cellNo != 2 && cellNo != 5)
		{
			cell.className = 'alignimgtext';
		}
		cell.innerHTML = getInnerHTMLForRoleTable(dateIndex, index, cellNo);
		
		if(cellNo == 0)
		{
			cell.focus();
		}
	}
	
	var rowCount = document.getElementById('rowCount' + dateIndex );
	rowCount.value = eval(rowCount.value) + 1;
	clearRoleRow(dateIndex,1);
}

function getFormElement(name, dateIndex, timeIndex)
{
	return document.getElementById(name + dateIndex + "_" + timeIndex);
}
function getInnerHTMLForRoleTable(dateIndex,index,cellNo)
{
	var testInnerHTML = '';
	var indexSuffix =  dateIndex + "_"+ index;
	switch(cellNo)
	{
		case 0:
		{
			
			var roleCombo = getFormElement("roleType",dateIndex, 1);
			var selectedIndex = roleCombo.selectedIndex;
			var roleId = roleCombo.value;
			var roleDesc = roleCombo.options[selectedIndex].text;
			testInnerHTML = "<input type='hidden' name='staffAssignmentId" + indexSuffix + "' id='staffAssignmentId" + indexSuffix + "' value='' >" ;
			testInnerHTML += "<input type='hidden' name='roleType" + indexSuffix + "' id='roleType" + indexSuffix + "' value='" + roleId + "' >" + roleDesc;
			testInnerHTML += "<input type='hidden' name='rowModified" + indexSuffix + "' id='rowModified" + indexSuffix + "'  value='' />";
			break;
		}
		case 1:
		{
			var practitionerIdObj = getFormElement("practitionerId",dateIndex, 1);
			var practitionerNameObj = getFormElement("practitionerName",dateIndex, 1);
			testInnerHTML = "<input type='hidden' name='practitionerId" + indexSuffix + "' id='practitionerId" + indexSuffix + "' value='" + practitionerIdObj.value + "' >" + practitionerNameObj.value;
			break;
		}	
		case 2:
		{
			var check = "";
			var showWidgetObj =  getFormElement("showWidgetYN",dateIndex, 1);
			if(showWidgetObj.checked)
			{
				check = "checked";
			}
				testInnerHTML = "<input class='brdclr' type='checkbox' name='showWidgetYN" + indexSuffix + "' id='showWidgetYN" + indexSuffix + "' value='Y'" + check + "  />";
			break;
		}
		case 3:
		{
			var fromTimeObj = getFormElement("fromTime",dateIndex, 1);
			testInnerHTML = "<input class='brdclr' type='text' name='fromTime" + indexSuffix + "' id='fromTime" + indexSuffix + "' size='5' value='" + fromTimeObj.value + "' onblur='checkTimeFormat(this)'/>";
			break;
		}
		case 4:
		{
			var toTimeObj = getFormElement("toTime",dateIndex, 1);
			testInnerHTML = "<input class='brdclr' type='text' name='toTime" + indexSuffix + "' id='toTime" + indexSuffix + "' size='5'  value='" + toTimeObj.value + "' onblur='checkTimeFormat(this)' />";
			break;
		}
		case 5:
		{
			testInnerHTML = "<img src='../../eOT/images/Close.png' class='midalign' onclick='javascript:deleteRoleRow("+ dateIndex + "," + index + ")'/><span class='tbtxt' >Delete</span>";
			break;
		}
		
	}
	return testInnerHTML;
}

function clearRoleRow(dateIndex, index)
{
	document.getElementById("roleType"+ dateIndex +"_"+index).selectedIndex = 0;
	document.getElementById("practitionerId"+ dateIndex +"_"+index).value = '';
	document.getElementById("practitionerName"+ dateIndex +"_"+index).value = '';
	document.getElementById("showWidgetYN"+ dateIndex +"_"+index).checked = false;
	document.getElementById("fromTime"+ dateIndex +"_"+index).value = '';
	document.getElementById("toTime"+ dateIndex +"_"+index).value = '';
	
}

function populateAndSetComboModify(roleTypeCode, dateIndex, index)
{
	
	var roleTypeCombo = document.getElementById('roleType' + dateIndex + '_' + index);
	roleTypeCombo.options.length = 0;
	var roleTypeArray = parent.frames[1].roleTypeArray;
	roleTypeCombo.options.add(new Option("Select", ""));
	for(var i=0; i< roleTypeArray.length; i++)
	{
		roleTypeCombo.options.add(new Option(roleTypeArray[i][1], roleTypeArray[i][0]));
	}
	if(roleTypeCode != null && roleTypeCode != "")
	{
		roleTypeCombo.value= roleType;	
	}
	
}

function deleteRoleRow(dateIndex, index)
{
	
	var table=document.getElementById(ROLE_TABLE_ID + dateIndex);
	
	var rowCount = table.rows.length;
	
	var rowCountObj = document.getElementById('rowCount'+dateIndex);
	
	
	for(var i=1; i<rowCount; i++)
	{
		var row = table.rows[i];
		var roleTypeCombo = row.cells[0].children[0];
		var rowIndex = getIndex(roleTypeCombo.name);
		
		if(rowIndex == index)
		{
			 var assignmentIdObj = document.getElementById("staffAssignmentId"+dateIndex+"_"+index);
			 if(assignmentIdObj.value != '')
			 {
				 document.forms[0].deleteId.value +=  assignmentIdObj.value + "~";
			 }
		   	 table.deleteRow(i);
	    	 rowCount--;
	         i--;
	         rowCountObj.value = eval(rowCountObj.value) - 1;
		}
	}
}

function setRowModified(dateIndex, index)
{
	var rowModifyObj = document.getElementById("rowModified" + dateIndex + "_" + index);
	rowModifyObj.value = "Y";
}

function showHideDateDetails(dateIndex)
{
	var divObj = document.getElementById("dateDetailDiv" + dateIndex);
	var imgObj = document.getElementById("arrow" + dateIndex);
	var btnObj = document.getElementById("addBtn" + dateIndex);
	
	if(divObj.style.display == 'none')
	{
		divObj.style.display = 'inline';
		imgObj.src = '../../eOT/images/Arrow.PNG';
		btnObj.disabled=false;
	}
	else
	{
		divObj.style.display = 'none';
		imgObj.src = '../../eOT/images/Arrow1.PNG';
		btnObj.disabled=true;
	}
}

function viewAuditTrail()
{
	var assignmentFromDate = document.forms[0].assignmentFromDate.value;
	var assignmentToDate = document.forms[0].assignmentToDate.value;
	var operRoomCode = document.forms[0].operRoomCode.value;
	


	var dialogUrl       = "../../eOT/jsp/StaffAssignmentAuditTrail.jsp?title=Audit History"+"&assignmentFromDate="+assignmentFromDate+"&assignmentToDate="+assignmentToDate+"&operRoomCode="+operRoomCode ;
	

	var dialogArguments = '';
    var dialogFeatures  = "dialogHeight:" + "600px" + "; dialogWidth:" + "1000px" + " ; scroll=yes;resizable:yes; status:" + status;
    
	 window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);		
}

function checkTimeFormat(obj)
{
	if(obj.value!=null && obj.value!="")
	{
		var retVal = chkTime(obj.value);
		if(retVal==false)
		{
			alert(getMessage("VALID_TIME_SLOTS","OT"));		
			obj.focus();
			obj.select();
			return false;
		}
	}	
	return true;
}

function checkTimeModify(obj, dateIndex, timeIndex)
{
	if(checkTimeFormat(obj))
	{
		setRowModified(dateIndex, timeIndex);
	}
}
		
function validateRow(doc , appendIndex)
{
	var fieldArray = ["roleType", "practitionerId", "fromTime", "toTime"];
	var fieldLabel = [getLabel("eOT.SARole.Label","OT"), getLabel("eOT.SAName.Label","OT"), getLabel("eOT.FromTime.Label","OT"), getLabel("eOT.ToTime.Label","OT")];
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
	if(msg1 == '')
	{
		var fromTime = doc.getElementById(fieldArray[2] + appendIndex ).value;
		var toTime =  doc.getElementById(fieldArray[3] + appendIndex ).value;
		
		fromTime = fromTime.replace(":","");
		toTime = toTime.replace(":","");
		if(eval(fromTime) >= eval(toTime))
		{
			msg1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT").replace("#",fieldLabel[2]).replace("#", fieldLabel[3]);
			alert(msg1);
		}
	}
	return  msg1;
}

function checkForDuplicates(doc)
{
	var rowCount = doc.getElementById('rowCount').value;
	var recCount = 0;
	var msg1 = '';
	for(var i=2; recCount < rowCount ; i++)
	{
		var appendIndex = "_" + i;
		var objValue = doc.getElementById("roleType" + appendIndex);
		if(objValue != null )
		{
			recCount++;
			var jRecCount = 1;
			var jRowCount = rowCount - recCount + 1;
			for(var j=i+1; jRecCount < jRowCount ; j++)
			{
				var jAppendIndex = "_" + j;
				var objValue1 = doc.getElementById("roleType" + jAppendIndex);
				if(objValue1 != null )
				{
					jRecCount++;
					if(compareRow(doc, appendIndex, jAppendIndex))
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

function compareRow(doc, rowInd1, rowInd2)
{
	var fieldArray = ["roleType_", "practitionerId_", "fromTime_", "toTime_"];
	
	for(var i=0; i<fieldArray.length; i++)
	{
		var objValue = doc.getElementById(fieldArray[i]  + rowInd1).value;
		var objValue1 = doc.getElementById(fieldArray[i]  + rowInd2).value;
		
		if(objValue != objValue1)
		{
			return false;
		}
	}
	return true;
}
function validateInsert(doc)
{
	var err_mess = '';
	var assignmentDate = doc.forms[0].assignmentDate.value;
	if(assignmentDate==null || assignmentDate==""){
		err_mess = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.SADate.Label","OT"));
		alert(err_mess);
		return err_mess;
	}
	else
	{
		assignmentDate = assignmentDate + " 23:59";
		if(isBeforeNow(assignmentDate,'DMYHM','en') )
		{
			err_mess = "Select Current Date or Future Date";
			alert(err_mess);
			return err_mess;
		}
	}
	
	var operRoomCode = doc.forms[0].operRoomCode.value;
	if(operRoomCode==null || operRoomCode==""){
		err_mess = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOT.SARoom.Label","OT"));
		alert(err_mess);
		return err_mess;
	}
	var rowCount = doc.getElementById('rowCount').value;
	if(rowCount == 0)
	{
		err_mess = "Atleast one row needs to be added";
		alert(err_mess);
		return err_mess;
	}
	var recCount = 0;
	for(var i=2; recCount < rowCount ; i++)
	{
		var appendIndex = "_" + i;
		var objValue = doc.getElementById("roleType" + appendIndex);
		
		if(objValue != null )
		{
			recCount++;
			err_mess = validateRow(doc, appendIndex);
			if(err_mess != '')
			{
				return err_mess;
			}
		}
	} 
	
	return checkForDuplicates(doc);
}

function validateUpdate(doc)
{
	var err_mess = '';
	var dateCount = doc.getElementById("dateCount").value;
	for(var dateIndex =1; dateIndex <= dateCount; dateIndex++)
	{
		var rowCount = doc.getElementById('rowCount' + dateIndex).value;
		if(rowCount == 0)
		{
			err_mess = "Atleast one row needs to be added";
			alert(err_mess);
			return err_mess;
		}
		var recCount = 0;
		for(var i=2; recCount < rowCount -1 ; i++)
		{
			var appendIndex = dateIndex + "_" + i; 
			
			var objValue = doc.getElementById("roleType" + appendIndex);
			
			if(objValue != null )
			{
				recCount++;
				err_mess = validateRow(doc, appendIndex);
				if(err_mess != '')
				{
					return err_mess;
				}
			}
		} 
	}
	return checkForDuplicatesInModify(doc);
}
function checkForDuplicatesInModify(doc)
{
	var msg1 = '';
	var dateCount = doc.getElementById("dateCount").value;
	for(var dateIndex =1; dateIndex <= dateCount; dateIndex++)
	{
		var rowCount = doc.getElementById('rowCount' + dateIndex).value;
		var jRowCount = rowCount;
		var recCount = 1;
		for(var i=2; recCount < rowCount ; i++)
		{
			var appendIndex = dateIndex + "_" + i; 
			
			var objValue = doc.getElementById("roleType" + appendIndex);
			
			if(objValue != null )
			{
				
				recCount++;
				var jRecCount = 1;
				jRowCount = rowCount - recCount + 1;
				for(var j=i+1; jRecCount < jRowCount; j++)
				{
					
					var jAppendIndex = dateIndex + "_" + j;
					var objValue1 = doc.getElementById("roleType" + jAppendIndex);
					if(objValue1 != null)
					{
						jRecCount++;
						if(compareRow(doc, appendIndex, jAppendIndex))
						{
								msg1 = "Duplicate Rows Found";
								alert(msg1);
								return msg1;
						}
					}
				}
			}
		} 
	}
	return msg1;
}

function compareRow(doc, appendIndex1, appendIndex2)
{
	
	if(appendIndex1 == appendIndex2)
	{
		return false;
	}
	var fieldArray = ["roleType", "practitionerId", "fromTime", "toTime"];
	
	for(var i=0; i<fieldArray.length; i++)
	{
		var objValue = getDateValue(doc.getElementById(fieldArray[i]  + appendIndex1).value);
		var objValue1 = getDateValue(doc.getElementById(fieldArray[i]  + appendIndex2).value);
		if(objValue != objValue1)
		{
			return false;
		}
	}
	return true;
}

function getDateValue(objectValue)
{
	if(objectValue.indexOf("~") > 0)
	{
		var objectArray = objectValue.split("~");
		objectValue = objectArray[0];
	}
	
	return objectValue;
	
}
 function chkAllselect()  //added by chaitanya October 23, 2013
 {
	var operRoomCode = document.forms[0].operRoomCode.options.length;
	var chkCount = 0;
	for(var i=0; i<document.forms[0].operRoomCode.options.length; i++)
	{
		if(document.forms[0].operRoomCode.options[i].selected)
			chkCount++
	}
	if(document.forms[0].operRoomCode.options.value == 'ALL' && chkCount > 1)
	{
		for(var i=1; i<document.forms[0].operRoomCode.options.length; i++)
			document.forms[0].operRoomCode.options[i].selected = '';
	}
	return true;
 }

