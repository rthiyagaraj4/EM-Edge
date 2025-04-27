<!DOCTYPE html>
<!--
File Name		: OPFoodDislikes.jsp
File Description: This file is for selecting Food Dislike Items.
CRF#			: Bru-HIMS-CRF-230
Author			: Abirami
Date			: Aug-2013
-->
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<head>
	<%
	//Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends 
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
				.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
				:"IeStyle.css" ;
				if(sStyle==null)sStyle="IeStyle.css";
				String locale = (String)session.getAttribute("LOCALE");

	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<title><fmt:message key="eOT.foodDislikes.Label" bundle="${ot_labels}" /></title>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
</head>
<body>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
					<TR align="center">
						<TD align="center" colspan="2" class="lable" >
							<fmt:message key="Common.item.label" bundle="${common_labels}" />
							<input type="hidden" name="foodType" id="foodType" value="">
							<input type="text" name="foodDesc" id="foodDesc" value="" onblur="showLookupLocal(this)"/>
							<input type="button" name="click" id="click" value="?" onClick='showLookup(document.getElementById("foodDesc"));' class="Button"/>
							
<!-- 							<input type="text" name="foodDesc" id="foodDesc" value="" onblur="showLookup(this)"> -->
<!-- 							<input type="button" name="click" id="click" value="?" onClick="showLookup(document.getElementById(foodDesc))" class="Button"/> -->
						</TD>
					</TR>
					<TR>
						<TD colspan="2" align="right">
							<input type="button" name="" id="" value="<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />" onClick="AddFoodDislikeItem();" class="Button">
							 <input type="button" name="cancel" id="cancel" value="<fmt:message key="Common.cancel.label" bundle="${common_labels}" />" onClick="return deleteFoodDislikesRow();" class="Button">
							<input type="hidden" name="rowNo" id="rowNo" value="">
						</TD>
					</TR>
				</table>
		<TR>
			<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr style="BACKGROUND-COLOR:white;">
						<br/>
						<td colspan="2">
							<div id="listContentLayer" style="display:block;visibility:visible;overflow-y: scroll;height:75vh;width:100%;border: 1px outset #9999FF" align="center">
								<table border='1' cellpadding='2' cellspacing='0' width='75%' align='center' id="listContentTable">
									<tr>
										<th>
											<fmt:message key="Common.item.label" bundle="${common_labels}" />
										</th>
									</tr>
								</table>
							</div>
						</td>
					</tr>
					<TR>
						<TD colspan="4" align="right">
							
							<input type="button" name="" id="" value="<fmt:message key='eOT.Ok.label' bundle='${ot_labels}' />" onClick="getFoodDislikeDtls()" class="Button">
							<input type="button" name="" id="" value="<fmt:message key='Common.close.label' bundle='${common_labels}' />" onClick="OPFoodDislikeclose();" class="Button">
						</TD>
					</TR>
					<input type="hidden" name="language_id" id="language_id" value="<%=locale%>"/>
				</table>
			</td>
		</TR>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
	var foodDislikeList = new Array();
	var recordUpd = false;
	if(dialogArguments != "undefined" && dialogArguments != "")
	{
		var foodARR = new Array();
		foodARR = dialogArguments.split(",");
		
		var tableObj = document.getElementById("listContentTable");
		var count=0;
		var nRowCount = 0; 
		for (var nCount = 0; nCount < foodARR.length; ) {
			
			foodDislikeList[nRowCount] =  new Array();
			foodDislikeList[nRowCount][0] = foodARR[nCount++];
			foodDislikeList[nRowCount][1] = foodARR[nCount++];
			foodDislikeList[nRowCount][2] = foodARR[nCount++];
			
			var obj = foodDislikeList[nRowCount];
		
			if (foodDislikeList[nRowCount][2] != null) {
				if (foodDislikeList[nRowCount][2] != "-1") {
				
		            var countRow = tableObj.rows.length;
		            var row_ind = 1;
		            var newRow = tableObj.insertRow(row_ind);
		            newRow.id = nRowCount;
		            var newCellitemType = newRow.insertCell(newRow.cells.length);
		            var sub = "<A href=\"#\" onclick=\"return fetchFoodDislikesRow('" + nRowCount + "');\" >" + obj[1] + "</A>";
							//alert(sub)
		            newCellitemType.innerHTML = sub;
				}
			}
			nRowCount++;
		}
	}
	
	function fetchFoodDislikesRow(val) {
		document.all("foodType").value = foodDislikeList[val][0];
		document.all("foodDesc").value = foodDislikeList[val][1];
		document.all("rowNo").value = val;
	}
	
	var warnOnClose = false;
	function OPFoodDislikeclose()
	{ 
		warnOnClose = true;
		
		if(window.confirm("The Changes will not be Saved. Are you sure you wish to continue?"))
		{
			window.returnValue = false;
			top.close();
		}
		else
			warnOnClose = false;
			
		/*var sMsg = "The Changes will not be Saved. Are you sure you wish to continue? ";
		var dialogUrl1 = "../../eDS/jsp/CommonDialogBox.jsp?dialogMessage="+sMsg;
		var dialogFeatures = "dialogHeight:5;dialogWidth:30;status:no;scroll:no";
		var returnValue = window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);

		if(returnValue)
		{
			window.returnValue = false;
			top.close();
		}else
			warnOnClose = false; */
	}
	
	window.onbeforeunload  = function OPautoClose() {
		if(!warnOnClose)
			return "";
	};
	
	function getFoodDislikeDtls() {
		var tmpfoodDislikeList = "";
		tmpfoodDislikeList += foodDislikeList;
		if(recordUpd)
			parent.document.getElementById('dialog-body').contentWindow.returnValue = foodDislikeList;
		else
			parent.document.getElementById('dialog-body').contentWindow.returnValue = false;
		
		warnOnClose = true;
		//window.close();
		parent.document.getElementById('dialog_tag').close();
	}
	
	//Function: Fetching the selected row value in the header: 
	function AddFoodDislikeItem(){
		var countRowValue = 0;
		if (document.getElementById("foodType").value == "" || document.getElementById("foodDesc").value =="") {
			var msg = "Item Cannot be Blank";
			alert(msg);
			return false;
		}
		if (document.getElementById("rowNo").value == "") {
				if (foodDislikeList && foodDislikeList.length > 0) {
					countRowValue = foodDislikeList.length;
					for (var i = 1; i < foodDislikeList.length; i++) {
						var obj = foodDislikeList[i];
						if (obj != null) {
							if (obj[2] != "-1") {
								if (obj[0] == document.all("foodType").value) {
									alert("This Food Item Is Already Exits");
									return false;
								}
							}
						}
					}
			}
		}
		else{
			countRowValue = document.getElementById("rowNo").value;
		}
		recordUpd = true;
		foodDislikeList[countRowValue] = new Array();
		foodDislikeList[countRowValue][0] = document.all("foodType").value;
		foodDislikeList[countRowValue][1] = document.all("foodDesc").value;
		foodDislikeList[countRowValue][2] = "0";
		countRowValue++;
		var tableObj = document.getElementById("listContentTable");
			while (tableObj.rows.length > 1) {
					tableObj.deleteRow(1);
				}
		for (var ntempCount = 0; ntempCount < foodDislikeList.length; ntempCount++) { 
				var obj = foodDislikeList[ntempCount];
					
					if (obj != null && obj[2] != "-1") {
							var countRow = tableObj.rows.length;
							var row_ind = 1;

							var newRow = tableObj.insertRow(row_ind);
							var newCellitemType = newRow.insertCell(newRow.cells.length);
							var sub = "<A href=\"#\" onclick=\"return fetchFoodDislikesRow('" + ntempCount + "');\" >" + foodDislikeList[ntempCount][1] + "</A>";
							newCellitemType.innerHTML = sub;
					}
			
				document.all("foodType").value = "";
				document.all("foodDesc").value = "";
				document.getElementById("rowNo").value = "";

		}
	}

	function deleteFoodDislikesRow() {
		var tableObj = document.getElementById("listContentTable");

		if (document.all("rowNo").value == "" || document.getElementById("foodType").value == "" || document.getElementById("foodDesc").value =="") {
				alert("Please Select Atleast One Record to delete");
				return false;
			}
			
			recordUpd = true;
			while (tableObj.rows.length > 1) {
				tableObj.deleteRow(1);
			}
			if (document.all("rowNo").value != "") {
				foodDislikeList[document.all("rowNo").value][2] = "-1";
			}
			
			var row_ind = 1;
			var obj;
			for (var i = 0; i < foodDislikeList.length; i++) {
				if(foodDislikeList[i] != undefined){
					obj = foodDislikeList[i];
					if (obj != null) {
						if (obj[2] != "-1") {
							var newRow = tableObj.insertRow(row_ind);
							var newCellitemType = newRow.insertCell(newRow.cells.length);
							var sub = "<A href=\"#\" onclick=\"return fetchFoodDislikesRow('" + i + "');\" >" + obj[1] + "</A>";
							newCellitemType.innerHTML = sub;
						}
					}
				}
			}
			
			document.getElementById("rowNo").value = "";
			document.getElementById("foodType").value = "";
			document.getElementById("foodDesc").value="";
	}

	async function showLookup(obj) {
	var locale = document.getElementById("language_id").value;
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();

	var sql = "SELECT A.FOOD_ITEM_CODE CODE,A.SHORT_DESC DESCRIPTION FROM DS_ITEMS A WHERE A.EFF_STATUS ='E' AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.FOOD_ITEM_CODE) LIKE UPPER(?) AND A.LANGUAGE_ID LIKE '"+locale+"'";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	//argumentArray[6] = DESC_LINK;
	//argumentArray[7] = DESC_CODE;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	retArr = await CommonLookup("Item", argumentArray);
	if (retArr != null && retArr != "" && retArr != undefined) {
		var str =unescape(retArr);
		var arr = str.split(",");
		document.getElementById("foodType").value = arr[0];
		document.getElementById("foodDesc").value = arr[1];
	}
}

	function showLookupLocal(obj)
	{
		if(obj.value!='')
			showLookup(obj);
		else 
			document.getElementById("foodType").value=''
	}
	</script>
</body>

