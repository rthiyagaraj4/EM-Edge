
/***********************************************************
/*                   Reason.JS
/***********************************************************/
//Global variables
var pageNum = 1;
var checkArray = new Array();
var check = new Array();
var ActionArray = new Array();
var flag=false;
var ActiveArray = new Array();
var masterArray =new Array();
var rowSize;
// create 
function create() {
	content.location.href = contextPath + "/ReasonAction.do?method=" + loadMethod+"&vo.functionId="+functionId
}
function checkVal()
{
var code = document.getElementById("vo.reasonCode").value;
// alert(code)
var languageId = document.getElementById("languageId").value;
if(parent.content.document.getElementById("method").value==0  )
	{
	ActionType.getAction(1,languageId,getallAction);
	}
else if(parent.content.document.getElementById("method").value==2)
	{
	ActionType.getCheck(1,code,languageId,getallCheck);
	}
}

//====================== get checkbox val ====================

function getCellVal(chkBoxObj,code) {
	Ucode = chkBoxObj.value;

	if (chkBoxObj.checked) {
			var indexArray = new Array();
			if (code != null) 
				ActiveArray[ActiveArray.length] = code;
		}  else{
			for(var ind=0;ind<ActiveArray.length;ind++){
				
				if(ActiveArray[ind]==code){
					ActiveArray.splice(ind, 1)
					break;
				}
			}
	  }
	//	alert(ActiveArray)
}
//=======================apply()===========================
function apply() {

	var j=0;
	var len=content.ActiveArray.length+1;
	for (i = 10; i >0; i--) 
	{
		masterArray[i]=i;
		for (j = 0; j <=len; j++) 
			{if(i==content.ActiveArray[j]){ check[i]='Y';break;}else if(check[i]!='Y')check[i]='N';}
    }
		//  alert(check)
		var flag=checkNullLocal();
	if(flag==true)
	{
	for (i = 10; i>0; i--) 
	{
		//alert(masterArray[i]+"<-->"+check[i] );
		content.ReasonForm.innerHTML += "<input type=\"hidden\" value=\"" + masterArray[i] + "\" name=\"vo.actionTypeList[" + i + "].actionType\" id=\"vo.actionTypeList[" + i + "].actionType\"><input type=\"hidden\"  value=\"" + check[i] +"\" name=\"vo.actionTypeList[" + i + "].activeYn\" id=\"vo.actionTypeList[" + i + "].activeYn\">";
	}
	content.ReasonForm.submit();
   }
   check = new Array();
}

//=======================QUERY==============================
function query() {
	content.location.href = contextPath + "/ReasonAction.do?method=" + queryMethod+"&vo.functionId="+functionId
}


//======================LOAD RESULT=========================
function loadResult(reasonCode,reasonDesc,status) {
	content.location.href = contextPath + "/ReasonAction.do?vo.reasonCode=" + reasonCode+"&vo.reasonDesc=" + reasonDesc+"&vo.effStatus="+status+"&method=" +loadMethod+"&vo.functionId="+functionId
}
//===================== ADD CRITERIA========================
function addCriteria() {
	var criteria;
	criteria = content.QueryCriteriaForm.vo.orderBySelected.itemValue;
}
//===================== RESET ==============================
function reset()
	 {
		var method=content.document.getElementById("method").value;
		var reasonCode=content.document.getElementById("vo.reasonCode").value;
		var reasonDesc=content.document.getElementById("vo.reasonDesc").value;
		var status=content.document.getElementById("vo.effStatus");
		if(method==2)
		 {
			if(!status.checked)
			 {
				status.value='D';
				loadResult(reasonCode,reasonDesc,status.value);
			 }else
			 {
				 status.value='E';
				loadResult(reasonCode,reasonDesc,status.value);
			 }
		 }else
		content.location.href=contextPath+"/ReasonAction.do?method="+loadMethod+"&vo.functionId="+functionId
	 } 

//======================DELETE ROWS FOR PAGING====================
function deleteRows() {
	var tableObj = document.getElementById("contentTable");
	var len = tableObj.rows.length;
	for (i = len - 1; i != -1; i--) {
		tableObj.deleteRow(i);
	}
}

//======================== GET DWR DATA =============================
function getallAction(Data) {
    showlabel()
	deleteRows();
	var count=0;
	var tableObj = null;
	
	var found_flag = false;
	var qryEven = "QRYEVEN";
	var qryOdd = "QRYODD";
	tableObj = document.getElementById("contentTable");

	var row_ind = 1;
	var i=0;
	for(prop in Data)
	{
	var classVal = (i % 2 == 0) ? qryEven : qryOdd;
		//alert(Data[prop])
		var newRow = tableObj.insertRow(tableObj.rows.length);

		//CODE
		//	var newCellCode = newRow.insertCell(newRow.cells.length);
		//	newCellCode.name = "code" + row_ind;
		//	newCellCode.appendChild(document.createTextNode(prop));

		// DESCRIPTION
		var newCellDesc = newRow.insertCell(newRow.cells.length);
		newCellDesc.name = "desc" + row_ind;
		newCellDesc.appendChild(document.createTextNode(Data[prop]));
		newCellDesc.className=classVal;

		//  CHECKBOX VALUE
		var newCellCheck = newRow.insertCell(newRow.cells.length);
		activeYn_name="activeYn_"+prop;
		
		newCellCheck.innerHTML = "<input type=\"checkbox\" value=" +prop+ " name=" + activeYn_name + " id=" + activeYn_name + " onclick=\"getCellVal(this,"+ prop+")\" >";
		newCellCheck.className=classVal;
		found_flag = false;
		row_ind++;
		
		count++;
		i++;
	 }
	 rowSize=row_ind;
	}
function getallCheck(Data) {
    showlabel()
	deleteRows();
	ActiveArray=new Array();
	var count=0;
	var tableObj = null;
	
	var found_flag = false;
	var qryEven = "QRYEVEN";
	var qryOdd = "QRYODD";
	tableObj = document.getElementById("contentTable");

	var row_ind = 1;
	var i=0;
	for(prop in Data){
			for(prop1 in Data[prop]){
					var code=Data[prop][0]	
					var description=Data[prop][1]
					var checkBoxVal=Data[prop][2]
			}
	var classVal = (i % 2 == 0) ? qryEven : qryOdd;
		//alert(Data[prop])
		var newRow = tableObj.insertRow(tableObj.rows.length);

		//CODE
		//	var newCellCode = newRow.insertCell(newRow.cells.length);
		//	newCellCode.name = "code" + row_ind;
		//	newCellCode.appendChild(document.createTextNode(prop));

		// DESCRIPTION
		var newCellDesc = newRow.insertCell(newRow.cells.length);
		newCellDesc.name = "desc" + row_ind;
		newCellDesc.appendChild(document.createTextNode(description));
		newCellDesc.className=classVal;

		//  CHECKBOX VALUE
		var newCellCheck = newRow.insertCell(newRow.cells.length);
		activeYn_name="activeYn_"+code;
		newCellCheck.innerHTML = "<input type=\"checkbox\" value=" +checkBoxVal+ " name=" + activeYn_name + " id=" + activeYn_name + " onclick=\"getCellVal(this,"+code+")\" >";
		newCellCheck.className=classVal;
			
		if (document.getElementById(activeYn_name).value =="Y") {
			ActiveArray[code]=code;
			document.getElementById(activeYn_name).checked = true;
		}
		if(document.getElementById("vo.effStatus").checked==false)
		{
		document.getElementById(activeYn_name).disabled=true;
		}
		
		found_flag = false;
		row_ind++;
		
		count++;
		i++;
	  		
	}
	 rowSize=row_ind;
}

function showlabel()
{
 document.getElementById("lebel").style.visibility="visible";
}
function checkNullLocal()
 { 
	var flag;
	var fieldName=new Array("com.iba.ehis.lc.Code", "com.iba.ehis.lc.description");
 	var field=new Array(content.document.getElementById("vo.reasonCode"),content.document.getElementById("vo.reasonDesc"));
 	flag=checkNullDS(fieldName,field);
	if(flag==false) return false; else return true;
 }
 
 
 

