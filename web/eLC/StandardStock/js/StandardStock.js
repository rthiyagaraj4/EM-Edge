
/***********************************************************
/*                  StandardStock.JS
/***********************************************************/
//Global variables
var pageNum = 1;
var checkArray = new Array();
var userArray = new Array();
var flag=false;
var AUserArray = new Array();
contentList = new Hashtable();
// create
function create() {
	content.location.href = contextPath + "/StandardStockAction.do?method=" + loadMethod+"&vo.functionId="+functionId;
}
// apply
function apply() {

	if(checkNullLocal()) {
		content.document.getElementById("vo.sourceCode").disabled=false;
		content.document.getElementById("vo.sourceType").disabled=false;
		content.document.getElementById("search").disabled=false;
		content.document.getElementById("lookup").disabled=false;
		content.document.StandardStockForm.submit();
}
}
//Query 
function query() {
	content.location.href=contextPath+"/StandardStockAction.do?method=" + queryMethod+"&vo.functionId="+functionId
	
}
//Reset()
function reset()
{
content.location.href = contextPath + "/StandardStockAction.do?method=" + loadMethod+"&vo.functionId="+functionId;
}


//vo object
function StandardStockViewVo(litem,qty) {
	this.litem = litem;
	this.qty = qty;
	
}
//delete rec
function deleterec() {
	content.AgencyCodeForm.method.value=deleteMethod
	content.AgencyCodeForm.submit();
	reset();
	alert("record deleted");
	
}
//GET LINEN ITEM
function getLinen()
{
var languageId = parent.content.document.getElementById("languageId").value;
Stock.getLinenItem(languageId,setLinen);
}
//GET STOCK QUANTITY
function getStock()
{

var sourceCode = parent.content.document.getElementById("vo.sourceCode").value;
var sourceType = parent.content.document.getElementById("vo.sourceType").value;
var languageId = parent.content.document.getElementById("languageId").value;
var facilityId = parent.content.document.getElementById("vo.operatingFacilityId").value;
//alert(sourceCode+" "+sourceType+" "+languageId+" "+facilityId);
   Stock.getAllStock(sourceCode,sourceType,facilityId,languageId,setQty);
	
}

//========================== next page ==================
function Next() {

  flag=true;
	deleteRows();
	pageNum++;
	Stock.getAllStock(pageNum,setQty);
}
//============================PREVIOUS PAGE=========================
function Prev() {
	  flag=false;
	deleteRows();
	pageNum--;
	Stock.getAllStock(pageNum,setQty);
}

function  setLinen(Data) {
	deleteRows();
	var count=0;
	var tableObj = null;
	var i = 1;
	var m=0;
	var qryEven = "QRYEVEN";
	var qryOdd = "QRYODD";
	var found_flag = false;
	tableObj = document.getElementById("contentTable");
	var row_ind = 1;
	
	for(prop in Data)
	{
			if(prop!=null)
			{
				var classVal = (m % 2 == 0) ? qryEven : qryOdd;
				var qty=0;
				var newRow = tableObj.insertRow(tableObj.rows.length);
				//CODE
				var newCellCode = newRow.insertCell(newRow.cells.length);
				newCellCode.width="50%";
				newCellCode.height="10";
				newCellCode.name = "code" + row_ind;
				newCellCode.appendChild(document.createTextNode(Data[prop]));
				newCellCode.className=classVal;
				// DESCRIPTION
				var newCellQty = newRow.insertCell(newRow.cells.length);
				newCellQty.width="50%";
				newCellQty.align="center";
				newCellQty.name = "qty" + row_ind;
				newCellQty.height="10";
				newCellQty.innerHTML = "<input type=\"text\" maxlength='5' size='4' name='vo.stockList[" + (row_ind-1) + "].stdQty' id='vo.stockList[" + (row_ind-1) + "].stdQty' value='' onkeyPress='checkNumber()'> <input type='hidden' name='vo.stockList[" + (row_ind-1) + "].linenItem' id='vo.stockList[" + (row_ind-1) + "].linenItem' value='" + prop + "'>" ;
				newCellQty.className=classVal;
				found_flag = false;
				row_ind++;
				count++;
				m++;
			}
	    }
	
}

// set linen item
function  setQty(Data) {
	deleteRows();
	var count=0;
	var tableObj = null;
	var i = 1;
	var m=0;
	var qryEven = "QRYEVEN";
	var qryOdd = "QRYODD";
	var found_flag = false;
	tableObj = document.getElementById("contentTable");
	var row_ind = 1;
	
	for(prop in Data)
	{

		for(prop1 in Data[prop]){
					var  description=Data[prop][0]	
					var code=Data[prop][1]
					var qty=Data[prop][2]
					//alert(code+"=="+qty+"== "+description)
			}
		var classVal = (m % 2 == 0) ? qryEven : qryOdd;
			var newRow = tableObj.insertRow(tableObj.rows.length);
			//CODE
			var newCellCode = newRow.insertCell(newRow.cells.length);
			newCellCode.width="50%";
			newCellCode.height="10";
			newCellCode.name = "code" + row_ind;
			newCellCode.appendChild(document.createTextNode(description));
			newCellCode.className=classVal;
			// DESCRIPTION
			var newCellQty = newRow.insertCell(newRow.cells.length);
			newCellQty.width="50%";
			newCellQty.name = "qty" + row_ind;
			newCellQty.height="10";
			newCellQty.align="center";
			newCellQty.innerHTML = "<input type=\"text\" maxlength='5'  size='5' name='vo.stockList[" + (row_ind-1) + "].stdQty' id='vo.stockList[" + (row_ind-1) + "].stdQty' value='"+qty+"' onkeyPress='checkNumber()' > <input type='hidden' name='vo.stockList[" + (row_ind-1) + "].linenItem' id='vo.stockList[" + (row_ind-1) + "].linenItem' value='" + code + "'>" ;
			newCellQty.className=classVal;
		 	found_flag = false;
			row_ind++;
			count++;
			m++;
	}
	if( parent.content.document.getElementById("method").value==0 && row_ind==1 )
	{
			
		getLinen();
	}
}
	
// LOAD RESULT
function loadResult(linenItem,facilityId,sourceCode,sourceType){
	// alert(facilityId+"=="+linenItem+"=="+sourceType+"=="+sourceCode)

content.location.href=contextPath+"/StandardStockAction.do?&method="+loadMethod+"&vo.sourceType="+sourceType+"&vo.sourceCode="+sourceCode+"&vo.linenItem="+linenItem+"&vo.operatingFacilityId="+facilityId+"&vo.functionId="+functionId;
}
//======================DELETE ROWS FOR PAGING====================
function deleteRows() {
	var tableObj = document.getElementById("contentTable");
	var len = tableObj.rows.length;
	for (i = len - 1; i != -1; i--) {
		tableObj.deleteRow(i);
	}
}

function showlabel()
{
 document.getElementById("lebel").style.visibility="visible";
}
// look up 
function showLookup() {
	var sourceType=document.getElementById("vo.sourceType").value;
	var facilityId=document.getElementById("vo.operatingFacilityId").value;
	var	languageId=document.getElementById("languageId").value;
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	if(sourceType!=""){
	if(sourceType=="W")
		{	argArray[0] = "ehis.lc.standardStock.nursingUnit"
		  }
		else if(sourceType=="C")
		{	argArray[0] = "ehis.lc.standardStock.clinic"
		}
		else if(sourceType=="D")
		{	argArray[0] = "ehis.lc.standardStock.deptCode"
		}
		
	namesArray[0]="facilityId";
	namesArray[1]="languageId";
	valuesArray[0]=document.getElementById("vo.operatingFacilityId").value;
	valuesArray[1]=languageId;

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] = document.getElementById("sourceDesc").value;
	retArr = Lookup("Source", argArray);
	var txtUser = document.getElementById("vo.sourceCode");
	var txtUser1 = document.getElementById("sourceDesc");
	if(retArr!=null)
			{
			//Set the data in to the fields
			txtUser.value = retArr[0];
			txtUser1.value= retArr[1];
			}
			else
			{
			document.getElementById("sourceDesc").value="";
			document.getElementById("vo.sourceCode").value="";
			}
	
	}
	else
	{
		getServerMessage("com.iba.ehis.lc.standardStock.sourceType");
	 	var label=dwrMessage;
		getServerMessage("message.cannot.blank");
		var msg=dwrMessage;
	 	msgArray=msg.split('#');
	 	var error="";
		error=error +msgArray[0]+ label + " " + msgArray[1] +"<br>";
		parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
	}
}
function checkNullLocal()
 { 
 	var flag;
   var fieldName=new Array("com.iba.ehis.lc.standardStock.sourceType", "com.iba.ehis.lc.standardStock.source");
 	var fields=new Array(content.document.getElementById("vo.sourceCode"),content.document.getElementById("vo.sourceType"));
 	flag=checkNullDS(fieldName,fields);
	if(flag==false) return false; else return true;
 }


 


