/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var TABLE_ID = 'ItemTable';
var CELL_COUNT = 6;
var ROLE_TABLE_ID = 'RoleTable';

function checkDate(flag)
{
	var data="";
	var change_pref_date="";
	var obj=document.forms[0];	
	var locale = obj.locale.value;
	if(obj.chkavilable!=null&&obj.chkavilable!='undefined'&&obj.chkavilable!='')
	if(flag=='1')
	{
		data=obj.PREFERRED_DATE.value;
		change_pref_date=dateUtils(data,locale);
		if(data == null || data == '') return false;
		data=changeDate(change_pref_date);
		var dat1=new Date(data);
		var dat2=new Date(obj.date_compare.value);
		if(dat1<dat2)
		{
			var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
			var msgArray = msg.split("#");
			var date = getLabel("Common.date.label","common");
			var current_date = getLabel("Common.CurrentDate.label","common");
			return false;
		}
		else
			return true;
	}else if(flag=='2'){
		data=obj.PREFERRED_MONTH.value;
		if(data == null || data == '') return ;
		data1=obj.month_compare.value;
		var dt=new Array();
		var dt1=new Array();
		dt=data.split("/");
		dt1=data1.split("/");
		if(dt[0].length==1) dt[0]="0"+dt[0];
		if(dt1[0].length==1) dt1[0]="0"+dt1[0];
		if(dt[1]<dt1[1]||dt[0]<dt1[0]){
			return false;
		}else
			return true;
    }
 }
 
function checkDateFormat(obj)
{
	if(obj.value!=null && obj.value!="")
	{
		var retVal= checkDt(obj.value)
		if(retVal== false)
		{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			obj.value = "";
			obj.focus();
		}
	}
}
function searchItem(obj, index)
{
	if(obj != '')
	{
		var locale = document.forms[0].locale.value;
		var result		=	false ;
		var message		=	"" ;
		var flag		=	"" ;
		var function_id = "";
		var argumentArray  = new Array();
		var dataNameArray  = new Array();
		var dataValueArray = new Array();
		var dataTypeArray  = new Array();
		var sql="SELECT a.SHORT_DESC description, a.ITEM_CODE code FROM MM_ITEM_LANG_VW a, mm_item b WHERE A.LANGUAGE_ID='"+locale+"' AND  A.ITEM_CODE = B.ITEM_CODE and upper(A.SHORT_DESC) like upper(?) and upper(A.ITEM_CODE) like upper(?) AND nvl(a.eff_status,'X')= 'E' order by 2";
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;

		returnedValues = CommonLookup(getLabel("eOT.Items.label","OT"), argumentArray );
		if((returnedValues != null) && (returnedValues != ""))  
		{
			document.getElementById('itemDesc_'+index).value = localTrimString(returnedValues[1]);
			document.getElementById('itemCode_'+index).value = localTrimString(returnedValues[0]);
		}
		else
		{
			document.forms[0].itemDesc_0.value = '';
			document.forms[0].itemCode_0.value ='';		
		}
	}
	else
	{
		document.getElementById('itemCode_'+index).value = '';
	}
}

function addRow()
{
        var frmObj=document.forms[0];
		var error="";
		var error1="";
		var locale = frmObj.locale.value;
		var index = 1;
		var table = document.getElementById(TABLE_ID);
		var rowCount = table.rows.length;
		var roleTypeCombo = table.rows[rowCount-1].cells[0].childNodes[0];
		index = eval(getIndex(roleTypeCombo.name)) + 1;
		//alert("===index==="+index);
		if(validateAdd(index)==true){
		var row = table.insertRow(rowCount);
		for(var cellNo = 0; cellNo <= CELL_COUNT; cellNo++)
		{
			cell=row.insertCell(cellNo);
			cell.innerHTML = getInnerHTMLForTable(index, cellNo);
			if(cellNo == 0)
				cell.focus();
		}
		var rowCount = document.getElementById('rowCount');
		document.getElementById('rowIndex').value = index;
		clearRow(0);
}
}

function getInnerHTMLForTable(index,cellNo)
{
	var testInnerHTML = '';
	//alert("======index===getInnerHTMLForTable======"+index);
	var tmpindex = index - 1;

	switch(cellNo)
	{
		case 0:
		{
			testInnerHTML = "<input type='hidden' name='itemCode_"+ index + "' id='itemCode_"+ index + "' value='"+document.getElementById('itemCode_0').value+"'>";
			testInnerHTML += "<input type='hidden' name='mode_"+ index + "' id='mode_"+ index + "' value='A'>";
			testInnerHTML += "<input class='brdclr' type='text' name='itemDesc_"+ index + "' id='itemDesc_"+ index + "' size='12' value='" + document.getElementById('itemDesc_0').value+ "'/>";
			testInnerHTML += "&nbsp;<input type='button' class='button' value='?' name='ItemLookUp_"+ index + "' id='ItemLookUp_"+ index + "' onclick='searchItem(itemDesc_"+ index + ","+index+")'/> ";
			testInnerHTML += "<img src='../../eCommon/images/mandatory.gif'></img>";
			//alert("======testInnerHTML===getInnerHTMLForTable====0=="+testInnerHTML);
			break;
		}
		case 1:
		{
			testInnerHTML = "<input type='text' name='itemQuantity_"+ index + "' id='itemQuantity_"+ index + "' value='" + document.getElementById('itemQuantity_0').value + "' onchange='callMode("+ index +")' >";
			testInnerHTML += "&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>";
			//alert("======testInnerHTML===getInnerHTMLForTable====1=="+testInnerHTML);
			break;
		}
		case 2:
		{
			testInnerHTML = "<input class='brdclr' type='text' name='requestedDate_"+ index + "' id='requestedDate_"+ index + "' size='11' value='" + document.forms[0].requestedDate_0.value + "'/>";
			testInnerHTML += "&nbsp;<img src='../../eCommon/images/CommonCalendar.gif' Onblur=\"checkDate('" + index + "')\" ";
			testInnerHTML += " onClick=\"return showCalendar('requestedDate_" + index + "','dd/mm/y');\">	 ";
			testInnerHTML += "<img src='../../eCommon/images/mandatory.gif'></img>";
			//alert("======testInnerHTML===getInnerHTMLForTable====2=="+testInnerHTML);
			break;
		}
		case 3:
		{
			var selectedIndex = document.forms[0].cancel_0.selectedIndex;
			var roleId = document.forms[0].cancel_0.value;
			//alert("roleId=="+roleId);
			var roleDesc = document.forms[0].cancel_0.options[selectedIndex].text;
			testInnerHTML ="<select name='cancel_"+ index + "' id='cancel_"+ index + "'  value='" + roleId + " '> <option value='N'>No</option> <option value='Y'>Yes</option> </select>";
			testInnerHTML += "&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>";
			//alert("======testInnerHTML===getInnerHTMLForTable====3=="+testInnerHTML);
			break;
		}
		case 4:
		{
			testInnerHTML = "<input class='brdclr' type='text' name='cancelledRemark_"+ index + "' id='cancelledRemark_"+ index + "' size='10' value='" + document.forms[0].cancelledRemark_0.value + "' onchange='callMode("+ index +")' maxlength='150' />";
			//alert("======testInnerHTML===getInnerHTMLForTable====4=="+testInnerHTML);
			break;
		}
		case 5:
		{
			testInnerHTML = "<input class='brdclr' type='text' name='itemSpecRemark_"+ index + "' id='itemSpecRemark_"+ index + "' size='10' value='" + document.forms[0].itemSpecRemark_0.value + "' maxlength='150' />";
		//	alert("======testInnerHTML===getInnerHTMLForTable====5=="+testInnerHTML);
			break;
		}
	}
	return testInnerHTML;
}

function getIndex(delName)
{
	var index = delName.split("_");
	return index[1]; 
}

function apply()
{	
	var error="";
	var msg = getMessage("CANNOT_BE_BLANK",'OT');
	var msgArray = msg.split("&");
	var itemDetailsFrameDocument = eval(itemRequestData.document);
	if(itemDetailsFrameDocument.forms[0]!=undefined)
	{
		frmObj = itemDetailsFrameDocument.forms[0];
		if(frmObj != "" && frmObj != null && frmObj != undefined )
		{
		   var orderid = itemDetailsFrameDocument.getElementById('orderid').value;
		   var booking_no = itemDetailsFrameDocument.getElementById('booking_no').value;
		   var facility_id = itemDetailsFrameDocument.getElementById('facility_id').value;
/*
           var itemQuantity_0 = itemDetailsFrameDocument.getElementById('itemQuantity_0').value;
		   var requestedDate_0 = itemDetailsFrameDocument.getElementById('requestedDate_0').value;
		   var cancel_0 = itemDetailsFrameDocument.getElementById('cancel_0').value;
		   var cancelledRemark_0 = itemDetailsFrameDocument.getElementById('cancelledRemark_0').value;
		   var itemSpecRemark_0 = itemDetailsFrameDocument.getElementById('itemSpecRemark_0').value;
		   var itemCode_0 = itemDetailsFrameDocument.getElementById('itemCode_0').value;
*/
			var index = 1;
			var table = itemDetailsFrameDocument.getElementById(TABLE_ID);
			var rowCount = table.rows.length;
			var roleTypeCombo = table.rows[rowCount-1].cells[0].childNodes[0];
			index = eval(getIndex(roleTypeCombo.name));
			//alert("==index=="+index);
			if(validateALL()==true)
			{
				itemDetailsFrameDocument.getElementById('rowIndex').value = index;
/*
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				var xmlStr ="<root><SEARCH  /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", "../../servlet/eOT.ItemDetailsServlet?",false);
				xmlHttp.send(xmlDoc);
				var retVal = localTrimString(xmlHttp.responseText);
				var mesg = retVal;
				alert(mesg);
			
				var messageFrame = parent.frames[5];
				messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+mesg;
				frmObj.target='messageFrame';
*/

				frmObj.method="post";
				frmObj.action="../../servlet/eOT.ItemDetailsServlet";
				frmObj.submit();
/*
				$.ajax({
					url: "../../servlet/eOT.ItemDetailsServlet?rowIndex="+index,
					data: $('#itemDetailsForm').serialize(),
					type: "POST",
					dataType:"text",
					async: true,
					cache: false,
					complete: function(data)
					{
						var response	= data.responseText;
						alert(response);
					}
				});
*/		
			}
		else
			{	//commontoolbarFrame.document.location.href="../../eCommon/jsp/commonToolbar.jsp?";
				//var mesg="Operation unsuccessful...."
				var messageFrame = parent.frames[5];
				messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num=';
			}
		}
	}
}

function clearRow(index)
{
	document.getElementById("cancel_"+index).selectedIndex = 0;
	document.getElementById("itemDesc_"+index).value = '';
	document.getElementById("itemQuantity_"+index).value = '';
	document.getElementById("requestedDate_"+index).value = '';
	document.getElementById("cancelledRemark_"+index).value = '';
	document.getElementById("itemSpecRemark_"+index).value = '';
}

function localTrimString(sInString) 
{
  return sInString.replace(/^\s+|\s+$/g,"");
}
//Added against Print on 20-Jan-14
async function printItemDetails()
{
	var param = document.forms[0].params.value;
	//alert('Booking Date.. '+parent.frames[1].name);
	var paramArray = param.split("&");
	var paramArray_no = paramArray[0];
	var paramArray_date = paramArray[1];
	var dialogHeight	= "11" ;
	var dialogWidth	= "25" ;
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:no" ;
	var url = "../../eOT/jsp/ItemRequestReport.jsp?"+param,paramArray_no;
	retVal 	   = await window.showModalDialog(url, arguments, features);
}

function reset()
{
	var itemDetailsFrameDocument = eval(itemRequestData.document);
	if(itemDetailsFrameDocument.forms[0]!=undefined)
	{
		frmObj = itemDetailsFrameDocument.forms[0];
		if(frmObj != "" && frmObj != null && frmObj != undefined )
		{
			var params = itemDetailsFrameDocument.getElementById('params').value;
			parent.frames[4].document.location.href='../../eOT/jsp/ItemRequestData.jsp?'+params;
		}
	}
}

function callMode(index)
{
	if(document.getElementById("mode_"+index).value == 'I')
		document.getElementById("mode_"+index).value = 'U';
}

function checkNum(index)
{
	var qty = document.getElementById("itemQuantity_"+index).value;
	if(isNaN(qty))
	{
		alert("Qty should be number");
		document.getElementById("itemQuantity_"+index).value="";
		document.getElementById("itemQuantity_"+index).focus();
	}
	if(qty < 0)
	{
		alert("Negative numbers not allowed");
		document.getElementById("itemQuantity_"+index).value="";
		document.getElementById("itemQuantity_"+index).focus();
	}
	return true;
}

function checkItemDescExist(index)
{
	var recordsCount;
	var table = document.getElementById(TABLE_ID);
	var rowCount = table.rows.length;
	var roleTypeCombo = table.rows[rowCount-1].cells[0].childNodes[0];
	recordsCount = eval(getIndex(roleTypeCombo.name));
//	alert("==recordsCount=="+recordsCount+"==index=="+index);
	var enteredCode = document.getElementById('itemCode_'+index).value;
//	alert("===enteredCode==="+enteredCode);
	for(var z=0; z<=recordsCount; z++)
	{
		if(index != z)
		{
//			alert(document.getElementById('itemCode_'+z));
			if(document.getElementById('itemCode_'+z) != 'undefined')
			{
				if((enteredCode != '') && (enteredCode == document.getElementById('itemCode_'+z).value))
				{
					var msg = getMessage("APP-OT0221",'OT');
					alert(msg);
					document.getElementById('itemDesc_'+index).focus();
					document.getElementById('itemDesc_'+index).value = '';
					break;
				}
			}
		}
	}
}

function validateALL()
{
	var error="";
	var msg = getMessage("CANNOT_BE_BLANK",'OT');
	var msgArray = msg.split("&");
	var locale = frmObj.locale.value;
	var itemDetailsFrameDocument = eval(itemRequestData.document);
	if(itemDetailsFrameDocument.forms[0] != undefined)
	{
		frmObj = itemDetailsFrameDocument.forms[0];
		if(frmObj != "" && frmObj != null && frmObj != undefined)
		{
			var index = 1;
			var table = itemDetailsFrameDocument.getElementById(TABLE_ID);
			var rowCount = table.rows.length;
			var roleTypeCombo = table.rows[rowCount-1].cells[0].childNodes[0];
			index = eval(getIndex(roleTypeCombo.name));
			for(var i=1;i<=index;i++)
			{
				if(itemDetailsFrameDocument.getElementById("itemDesc_"+index).value =='' || itemDetailsFrameDocument.getElementById("itemDesc_"+index).value == null)
					error+=msgArray[0]+" "+getLabel('eOT.ItemDesc.label','OT')+" "+msgArray[1]; 
				if(error.length > 0)
				{
					alert (error);
					itemDetailsFrameDocument.getElementById('itemDesc_'+index).focus();
					return false;
				}
				var qty = itemDetailsFrameDocument.getElementById("itemQuantity_"+index).value;
				if(qty==""||qty==null)
					error+=msgArray[0]+" "+getLabel('eOT.Qty.Label','OT')+" "+msgArray[1]; 
				if(error.length > 0)
				{
					alert (error);
					itemDetailsFrameDocument.getElementById('itemQuantity_'+index).focus();
					return false;
				}
				if(itemDetailsFrameDocument.getElementById("requestedDate_"+index).value ==''|| itemDetailsFrameDocument.getElementById("requestedDate_"+index).value==null)
					error+=msgArray[0]+" "+getLabel('eOT.ItemDesc.label','OT')+" "+msgArray[1]; 
				if(error.length > 0)
				{
					alert (error);
					itemDetailsFrameDocument.getElementById('requestedDate_'+index).focus();
					return false;
				}
			}
		}
	}
	return true;
}

function validateAdd(index)
{
	var error="";
	var frmObj=document.forms[0];
	var locale = frmObj.locale.value;
	var qty = frmObj.itemQuantity_0.value;
	var msg = getMessage("CANNOT_BE_BLANK",'OT');
	var msgArray = msg.split("&");
	if(frmObj.itemDesc_0.value ==''|| frmObj.itemDesc_0.value==null)
		error+=msgArray[0]+" "+getLabel('eOT.ItemDesc.label','OT')+" "+msgArray[1]; 
	if(error.length > 0)
	{
		alert (error);
		frmObj.itemDesc_0.focus();
		return false;
	}
	if(frmObj.itemQuantity_0.value ==''|| frmObj.itemQuantity_0.value==null)
		error+=msgArray[0]+" "+getLabel('eOT.Qty.Label','OT')+" "+msgArray[1]; 
	if(error.length > 0)
	{
		alert (error);
		frmObj.itemQuantity_0.focus();
		return false;
	}
	if(frmObj.requestedDate_0.value ==''|| frmObj.requestedDate_0.value==null)
		error+=msgArray[0]+" "+getLabel('eOT.RequestedDate.label','OT')+" "+msgArray[1]; 
	if(error.length > 0)
	{
		alert (error);
		frmObj.requestedDate_0.focus();
		return false;
	}
	if(frmObj.cancel_0.value ==''|| frmObj.cancel_0.value==null)
		error+=msgArray[0]+" "+getLabel('eOT.Cancel.label','OT')+" "+msgArray[1]; 
	if(error.length > 0)
	{
		alert (error);
		frmObj.cancel_0.focus();
		return false;
	}
	return true;
}

function isSpclChar(obj, index)
{
	var frmObj = document.forms[0];
	var locale = frmObj.locale.value;
	if(obj == 'CR')
	{
		if(CheckChars2(obj, index)) 
			return true;
		else
		{
			alert("Special charecters not allowed");
			document.getElementById('cancelledRemark_'+index).focus();
			return false;
		}
	}
	else if(obj == 'IR')
	{
		if(CheckChars2(obj, index)) 
			return true;
		else
		{
			alert("Special charecters not allowed");
			document.getElementById('itemSpecRemark_'+index).focus();
			return false;
		}
	}
}

function CheckChars2(obj, index)
{
        var str = '';
        if(obj == 'CR')
        	str = document.getElementById("cancelledRemark_"+index).value;
        else if(obj == 'IR')
        	str = document.getElementById("itemSpecRemark_"+index).value;

        for (var u = 0; u < str.length; u++)
        {
           	if(!((str.charCodeAt(u) >= 48 && str.charCodeAt(u) <= 57) || (str.charCodeAt(u) >= 65 && str.charCodeAt(u) <= 90) || (str.charCodeAt(u) >= 97 && str.charCodeAt(u) <= 122) || (str.charCodeAt(u) == 32)))
           	{
                return false;
                break;
            }
        }
        return true;
}

