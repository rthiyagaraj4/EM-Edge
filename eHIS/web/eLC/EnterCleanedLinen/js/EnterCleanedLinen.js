var rowCount=0;
function EnterLinen()
	{
	var moduleId="LC";
	var functionId="LC_ENTER_CLEAN_LINEN";
	parent.parent.content.location.href=contextPath+"/eLC/EnterCleanedLinen/jsp/EnterCleanedLinenFrames.jsp?&vo.functionId="+functionId+"&vo.moduleId="+moduleId;
	} 	
function apply(){
	var f1="";
	var i=0;
	var j=0;
	var val=new Array();
	var flag=checkNullLocal();
	if(flag==true){
		if(rowCount>0){
			var method=0;
			while(i<rowCount)
			{   
			 val[i]=document.getElementById("vo.linenEnterList[" + i + "].qualityPassed").checked;
			 i++;
			}
			while(j<rowCount)
			{   
				if(val[j]==true)
					f1=true;
			j++;
			}
		
			if(f1==true)
				{EnterCleanedLinenForm.submit();}
			else{
				getServerMessage("com.iba.ehis.lc.atleastselectthelinenitem");
				alert(dwrMessage);
			    }
			}else{
				getServerMessage("com.iba.ehis.lc.atleastselectthelinenitem");
				alert(dwrMessage);
			    }
		}
	}




function reset(){
	parent.content.location.href=contextPath+"/EnterCleanedLinenAction.do?method="+loadMethod
}

//==========================================

function CurrDate(){	
	var currDate = new Date();
	var date = currDate.getDate();
	var mon = currDate.getMonth();
	var hrNow = currDate.getHours();
	var mnNow = currDate.getMinutes();
	mon = mon+1;
	var year = currDate.getYear();
	if(date <10)
		date = "0"+date;
	if(mon <10)
		mon = "0"+mon;
	if(hrNow<10)
			hrNow="0"+hrNow;
	if(mnNow<10)
			mnNow="0"+mnNow;
	var convert1= date + "/" + mon + "/" + year;
	convert1=convert1+" "+hrNow+":"+mnNow;
	var rdate=document.getElementById("vo.cleaningDate");
	rdate.value=convert1;
}

//==========================================
function checkNullLocal(){ 
	var error="";
	var flag=true;
	var key_value=new Array();
	var fieldName=new Array("com.iba.ehis.lc.enterCleanedLinen.cleaningDate","com.iba.ehis.lc.enterCleanedLinen.cleaningDoneBy");
	var field=new Array(document.getElementById("vo.cleaningDate"),document.getElementById("vo.cleaningDoneBy"));
	for (j = 0; j <field.length; j++){
		
		if (field[j].value ==""){
			
			getServerMessage(fieldName[j]);
			key_value[j] = dwrMessage;
			getServerMessage("message.cannot.blank");
			var msg = dwrMessage;
			msg1 = msg.split("#");
			error = error +msg1[0]+" "+key_value[j] + " " + msg1[1] + "<br>";
			flag = false;
		}
	}
	parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
	if(flag==false) return false; else return true;
}

//==================================
function getRequestNumber(data){
	var max=0;
	for(prop in data){
		if(prop!=null){
		if(parseInt(prop)>parseInt(max))
			max=parseInt(prop);
		}
	}
	max=parseInt(max)+1;
	document.getElementById("vo.cleaningRefNo").value=max;
	}
//===================================================== 
/* function deleteRows() {
	var tableObj = document.getElementById("contentTable");
	var len = tableObj.rows.length;

	while (parseInt(len) > 2) {
				tableObj.deleteRow(2);
			}
}


*/

 function deleteRows() {
	var tableObj = document.getElementById("contentTable");
	var len = tableObj.rows.length;
	if(parseInt(len)>0){
		for (i = len-1; i >=0; i--) {
		tableObj.deleteRow(i);
	}}
	
} 

function linenItemShowLookup(){
	var linenItemCode = document.EnterCleanedLinenForm("vo.linenItem").value;
	var linenItemDesc = document.EnterCleanedLinenForm("linenItemDesc").value;
	if(linenItemDesc !='')
		 showLookup()
}

function showLookup() {

	var languageId=document.EnterCleanedLinenForm["languageId"].value;
	var argArray = new Array();
	var namesArray = new Array("languageId");
	var valuesArray = new Array(languageId);
	var datatypesArray = new Array();
	argArray[0] = "ehis.lc.standardStock.linenItem"
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = DESC_CODE;
	argArray[4] = DESC_LINK;
	argArray[5] =document.EnterCleanedLinenForm["linenItemDesc"].value;
	getServerMessage("com.iba.ehis.lc.linenitemcode");
	var title=dwrMessage;
	retArr = Lookup(title, argArray);
	if(retArr!=null){
		var linenItemCode = document.EnterCleanedLinenForm["vo.linenItem"];
		var linenItemDesc = document.EnterCleanedLinenForm["linenItemDesc"];
		//Set the data in to the fields
		linenItemCode.value = retArr[0];
		linenItemDesc.value = retArr[1];
	}
}

//==========defect list =================
function getDefectList(data){
	var i=0;
	var defectId=new Array();
	for(i=0;i<rowCount;i++){
	  defectId[i]=EnterCleanedLinenForm["vo.linenEnterList["+i+"].natureOfDefect"];
	}
	for(prop in data){
		for(i=0;i<rowCount;i++){
			DWRUtil.removeAllOptions(defectId[i]);
			DWRUtil.addOptions(defectId[i], data, prop);
		}
	}
}
//==========reason list=================
function getDefectReasonList(data){
	var i=0;
	var defectReason=new Array();
	for(i=0;i<rowCount;i++){
		defectReason[i]=EnterCleanedLinenForm["vo.linenEnterList["+i+"].reasonForDefect"];
	}
	for(prop in data){
		for(i=0;i<rowCount;i++){
			DWRUtil.removeAllOptions(defectReason[i]);
			DWRUtil.addOptions(defectReason[i], data, prop);
		}
	}
}
//=============== get record===========
function getStock(){
	var linenItem=document.getElementById("vo.linenItem").value;
	
	var facilityId=document.getElementById("vo.operatingFacilityId").value;

	var locale=document.getElementById("languageId").value;
	
	CleanLinen.getStockDetail(locale,linenItem,facilityId,getRecord);
}
function getRecord(data){
	
	
	deleteRows();
   	var htmlContent = "";
	var tableObj = document.getElementById("contentTable");
	var index = 0;
	var qryEven = "QRYEVEN";
	var qryOdd = "QRYODD";
	var i=0;
	
	for(prop in data){
		for(prop1 in data[prop]){
			var linenItemDesc=data[prop][1];	
			var pendingQty=data[prop][2];
			}
		index = parseInt(index);
		var classVal = (index % 2 == 0) ? qryEven : qryOdd;
		var row = tableObj.insertRow(tableObj.rows.length);
		var col1 = row.insertCell();
		col1.className = classVal;
		col1.width="20%";
		col1.innerHTML = "<input type='hidden' name='vo.linenEnterList[" + (index) + "].linenItem' id='vo.linenEnterList[" + (index) + "].linenItem' value='" +prop+ "' readOnly>" + "<input type='text' name='linenItemDesc1' id='linenItemDesc1' value='" +linenItemDesc+ "' readOnly>";
		var col2 = row.insertCell();
		col2.className = classVal;
		col2.width="8%";
		col2.innerHTML = "<input type='text' name='vo.linenEnterList[" + (index) + "].pendingQuantity' id='vo.linenEnterList[" + (index) + "].pendingQuantity' value='"+pendingQty+"' size=8 readOnly>";
		var col3 = row.insertCell();
		col3.className = classVal;
		col3.width="8%";
		col3.innerHTML ="<input type='text' name='vo.linenEnterList[" + (index) + "].cleanedQuantity' id='vo.linenEnterList[" + (index) + "].cleanedQuantity' value='"+pendingQty+"' size=8 onblur='checkCleanedQty(this,"+index+");checkPendingQty(this,"+index+")' onkeyup='checkNumber(this)'>";
		var col4 = row.insertCell();
		col4.className = classVal;
		col4.width="10%";
		col4.align="center";
		col4.innerHTML = "<input type='checkBox' name='vo.linenEnterList[" + (index) + "].qualityPassed' id='vo.linenEnterList[" + (index) + "].qualityPassed' value='Y' onclick='showDefect(this,"+index+")' >";
		var col5 = row.insertCell();
		
		col5.className = classVal;
		col5.width="27%";
		col5.innerHTML ="<select name='vo.linenEnterList[" + (index) + "].natureOfDefect' id='vo.linenEnterList[" + (index) + "].natureOfDefect' ></select>" ;
		var col6 = row.insertCell();
		col6.className = classVal;
		col6.width="27%";
		col6.innerHTML ="<select name='vo.linenEnterList[" + (index) + "].reasonForDefect' id='vo.linenEnterList[" + (index) + "].reasonForDefect'></select>" ;
		index++;
	}
	rowCount=index;
	if(parseInt(rowCount)=='0')
	{	getServerMessage("NO_RECORD_FOUND_FOR_CRITERIA");
		alert(dwrMessage);
		EnterLinen() ;
	}
	else{
		CleanLinen.getNatureOfDefect(document.getElementById("languageId").value,getDefectList);
		CleanLinen.getReasonForDefect(document.getElementById("languageId").value,getDefectReasonList);
	}
	
	
}

//=============== disable defect================

function showDefect(obj,index){
	if(obj.checked==true){
		EnterCleanedLinenForm["vo.linenEnterList["+index+"].natureOfDefect"].disabled=true;
		EnterCleanedLinenForm["vo.linenEnterList["+index+"].reasonForDefect"].disabled=true;
		checkCleanedQty(obj,index)
	}
	else{
		EnterCleanedLinenForm["vo.linenEnterList["+index+"].natureOfDefect"].disabled=false;
		EnterCleanedLinenForm["vo.linenEnterList["+index+"].reasonForDefect"].disabled=false;
	}
}
//====================================================
function checkCleanedQty(obj,index){
	var cleanedQuantity = EnterCleanedLinenForm["vo.linenEnterList["+index+"].cleanedQuantity"].value;
	if(parseInt(cleanedQuantity)<=0){
		EnterCleanedLinenForm["vo.linenEnterList["+index+"].qualityPassed"].checked =false;
		//	var msg = getServerMessage("com.iba.ehis.lc.enterCleanedLinen.cleanedQty");
		getServerMessage("APP-LC00018");
		var msg2 =dwrMessage;
		parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+msg2;
		EnterCleanedLinenForm["vo.linenEnterList["+index+"].cleanedQuantity"].setFocus;
		EnterCleanedLinenForm["vo.linenEnterList["+index+"].natureOfDefect"].disabled=false;
		EnterCleanedLinenForm["vo.linenEnterList["+index+"].reasonForDefect"].disabled=false;
	}
}
//====================================================
function checkPendingQty(cleanedQuantity,index){
	var pendingQuantity = EnterCleanedLinenForm["vo.linenEnterList["+index+"].pendingQuantity"].value;
	if(parseInt(pendingQuantity) < parseInt(cleanedQuantity.value)){
		EnterCleanedLinenForm["vo.linenEnterList["+index+"].cleanedQuantity"].value ='0';
		EnterCleanedLinenForm["vo.linenEnterList["+index+"].cleanedQuantity"].setFocus;
		getServerMessage("com.iba.ehis.lc.enterCleanedLinen.cleanedQty");
		var msg = dwrMessage;
		getServerMessage("com.iba.ehis.lc.enterCleanedLinen.pendgingQty");
		var msg1 = dwrMessage;
		getServerMessage("APP-LC00012");
		var msg2 = dwrMessage;
		msg4=msg2.split("#");
		var error=msg4[0]+" "+msg+" "+msg4[1]+" "+msg1	
		parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error
	}
}
//=======================================================
 function checkDt(date1)
	{
	   var retval=true
		var date1arr=new Array()

		date1arr=date1.split("/")

		if(date1arr.length==3)
		{
			var date1d=date1arr[0]
			var date1m=date1arr[1]
			var date1y=date1arr[2]

			if (isNaN(date1d)==true) return false;
			if (isNaN(date1m)==true) return false;
			if (isNaN(date1y)==true) return false;

			date1d=eval(date1d)
			date1m=eval(date1m)
			date1yy=eval(date1y);

			if(date1m<=12)
			{

				if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31))
				{
					retval= false
										
				}

				if((date1m==4 || date1m==6 || date1m==9 || date1m==11 ) && (date1d>30))
				{
					retval= false
										}
				if ((date1y.length <4) || (date1y.length >4))
				{
					
					retval= false
				}
				if (date1m == 2) {
					if (date1d< 1) return false;

					if (LeapYear(date1yy) == true) {
						if (date1d> 29) return false;
					}
					else {
						if (date1d > 28) return false;
					}
				}

				if (isNaN(date1d)==true) retval = false;
				if (isNaN(date1m)==true) retval = false;
				if (isNaN(date1yy)==true) retval = false;
			}
			else
			{
				retval= false;
			}
		}
		else
		{
			retval= false;
			 getServerMessage("APP-LC00014");
			 var error =dwrMessage;
			parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
			 date1.focus()
		}
		return retval;
	}

	function getLoginUser(){
		var userId =document.getElementById("userId").value;
		RequestForCleaning.getLoggedInUser(document.getElementById("languageId").value,userId,callLoggedInUser);
	}

	function callLoggedInUser(data){
		for(prop in data){
			document.getElementById("vo.cleaningDoneBy").value = prop;
		}
	}

   function checkNumber(obj) {
	var val=obj.value;
    if ( trimCheck(val) && isNaN(val) == false && val >0)
        return true;
   	else 
		if ( val == 0 ) {
            	getServerMessage("APP-LC00018");
				parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
				window.event.keyCode = 27;
				obj.value="";
				return false;
        }else
        if ( val.length > 0 ) {
            	getServerMessage("message.Numbers.Allowed");
			parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
				window.event.keyCode = 27;
				obj.value="";
			return false;
        }
}

