var viewId;

	function checkAlphaNum(){
		obj =  String.fromCharCode(window.event.keyCode);
	   	var alphaFilter =/^[a-z_A-Z_0-9]+$/;
	   	if (!(alphaFilter.test(obj))) { 
	   		getServerMessage("messages.AlphaNumeric");
	   		parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
	   		window.event.keyCode = 27;
   		}
   	   }  	
function checkNumber1(obj) {
	var val=obj.value;
    if ( trimCheck(val) && isNaN(val) == false && val >0)
        return true;
   	else 
		if ( val == 0 ) {
            	getServerMessage("APP-LC00018");
				parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
				window.event.keyCode = 27;
				obj.value="";
				return false;
        }else
        if ( val.length > 0 ) {
            	getServerMessage("message.Numbers.Allowed");
				parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
				window.event.keyCode = 27;
				obj.value="";
			return false;
        }
}
function trimCheck(inString) {
if ( (inString != 'undefined') && (inString != undefined ) )
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
}
function checkNumber(obj) {
	var val=obj.value;
    if ( trimCheck(val) && isNaN(val) == false && val >0)
        return true;
    else 
		if ( val == 0 ) {
            	getServerMessage("APP-LC00018");
				parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
				window.event.keyCode = 27;
				obj.value="";
				return false;
        }else
		if ( val.length > 0 ) {
            	getServerMessage("message.Numbers.Allowed");
				parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
				window.event.keyCode = 27;
				obj.value="";
			return false;
        }
		 
}

 function checkForNumber(){
		obj =  String.fromCharCode(window.event.keyCode);
	   	var alphaFilter =/^[0-9]+$/;
	   	if (!(alphaFilter.test(obj))) { 
	   	//error = "Please enter a valid Alphabets.\n";
	   	getServerMessage("message.Numbers.Allowed");
		parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
	   	window.event.keyCode = 27;
   		}
   	}
function create() {
	var moduleId="LC";
	var functionId="LC_REQ_FOR_LINEN";
	content.location.href = contextPath + "/eLC/RequestForLinen/jsp/RequestForLinenMainFrames.jsp?&functionId="+functionId+"&moduleId="+moduleId;
}

function apply() {
			
				document.RequestForLinenForm["vo.placeLinenRequestVO.requestStatus"].disabled = false;
				document.RequestForLinenForm.submit();
			}

//========  remark validation==========

function textAreaLimit(field, maxlen) {
if (field.value.length > maxlen+1)
	{
		var textVal=field.value.substring(0, maxlen);
		field.value=textVal;
		getServerMessage("APP-LC00015");
		var msg = dwrMessage;
		msg1 = msg.split("#");
		getServerMessage("com.iba.ehis.lc.characters");
		var label = dwrMessage;

		alert(msg1[0]+" "+msg1[1]+" "+maxlen+" "+label);
	}
	return textVal;

}
//=========  date default===============
function CurrDate(arg){	
		
	var currDate = new Date();
		var date = currDate.getDate();
		var mon = currDate.getMonth();
		var hrNow = currDate.getHours();
		var mnNow = currDate.getMinutes();
		scNow = currDate.getSeconds();
		//alert(time)
		mon = mon+1;
		var year = currDate.getYear();
		if(date <10)
			date = "0"+date;
		if(mon <10)
			mon = "0"+mon;
		var convert1= date + "/" + mon + "/" + year;
		if(hrNow<10)
				hrNow="0"+hrNow;
		if(mnNow<10)
				mnNow="0"+mnNow;
		
		convert1=convert1+" "+hrNow+ ":" +mnNow;
		
		var seven = 1000 * 60 * 60 * 24 * 7;
		var reqFromCurrDate = new Date(currDate - seven);
		var fromDate = reqFromCurrDate.getDate();
		var fromMonth = reqFromCurrDate.getMonth();
		fromMonth = fromMonth+1;
		var fromYear = reqFromCurrDate.getYear();
		if(fromDate <10)
			fromDate = "0"+fromDate;
		if(fromMonth <10)
			fromMonth = "0"+fromMonth;
		var reqFromDate= fromDate + "/" + fromMonth + "/" + fromYear;
		var reqFromDate1= reqFromDate+" "+hrNow+ ":" +mnNow;


		if(arg=='V'){
			var rdate=document.getElementById("vo.placeLinenRequestVO.cancelledDate");
			rdate.value=convert1;
		}
		if(arg=='Y'){
			var rdate=document.getElementById("vo.placeLinenRequestVO.requestDate");
			rdate.value=convert1;
		}
		if(arg=='R'){
			var rdate=document.getElementById("vo.criteriaItems[2].itemValue");
			var rdate1=document.getElementById("vo.criteriaItems[3].itemValue");
			rdate.value=reqFromDate1;
			rdate1.value=convert1;
		}
	}
function checkNullLocal() {
	var flag;
 	var error="";
 	var fieldName = new Array("com.iba.ehis.lc.requestForLinen.requestNum", "com.iba.ehis.lc.requestForLinen.requestDate", "com.iba.ehis.lc.standardStock.sourceType","com.iba.ehis.lc.standardStock.source","com.iba.ehis.lc.requestForLinen.raisedBy","com.iba.ehis.lc.requestForLinen.requestStatus");
	var fields = new Array(document.RequestForLinenForm["vo.placeLinenRequestVO.requestNum"], document.RequestForLinenForm["vo.placeLinenRequestVO.requestDate"], document.RequestForLinenForm["vo.placeLinenRequestVO.sourceType"],document.RequestForLinenForm["vo.placeLinenRequestVO.sourceCode"],document.RequestForLinenForm["vo.placeLinenRequestVO.raisedBy"],document.RequestForLinenForm["vo.placeLinenRequestVO.requestStatus"]);
	var key_value=new Array();
 	for(j=0;j<fieldName.length;j++)
 	{
 		if(fields[j].value=="")
		{	
	 		getServerMessage(fieldName[j]);
	 		key_value[j]=dwrMessage;
			getServerMessage("message.cannot.blank");
			msg=dwrMessage;
	 		msgArray=msg.split('#');
	 		error=error +msgArray[0]+ key_value[j] + " " + msgArray[1] +"<br>";
	 		flag=false;
		}
 	}
	parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
	if(flag==false) return false; else return true;
}
function checkNull1() {
	var flag;
 	var error="";
 	var fieldName = "com.iba.ehis.lc.requestForLinen.requestDate";
	var fields = document.QueryCriteriaForm["requestDate"];
	var key_value;
	if(fields.value=="")
		{	
	 		getServerMessage(fieldName);
	 		key_value=dwrMessage;
			getServerMessage("message.cannot.blank");
			msg=dwrMessage;
	 		msgArray=msg.split('#');
	 		error=error +msgArray[0]+ key_value + " " + msgArray[1] +"<br>";
	 		flag=false;
 		}
 	
	parent.parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
	if(flag==false) return false; else return true;
}
//====================================================
function defaultSource(arg)
{
	var sourceType="";
	var el = document.getElementsByTagName("SELECT").item(0);
	if (el != null) {
	for (i=0; i<el.options.length; i++) {
			
           	if(el.options(i).value==arg)
       		{
			  el.options(i).selected=true;
   			}
    }
}
}

//============================TOP-BOTTOM MULTI RECORD ==================================

function linenItemLookup(){
	var linenItemDesc = document.getElementById("linenItemDesc").value;
	if(linenItemDesc != '')
		showLookup1();
}

function showLookup1() {

	var sourceType=document.getElementById("vo.placeLinenRequestVO.sourceType").value;
	var sourceCode=document.getElementById("vo.placeLinenRequestVO.sourceCode").value;
   	var languageId=document.getElementById("languageId").value;
	var flag=true;
 	var error="";
 	var fieldName = new Array(
		"com.iba.ehis.lc.standardStock.sourceType",
		"com.iba.ehis.lc.standardStock.source");
	var fields = new Array(sourceType,sourceCode);
	var key_value= new Array();

 	for(j=0;j<fieldName.length;j++)
 	{
 		if(fields[j]=="")
		{	
	 		getServerMessage(fieldName[j]);
	 		key_value[j]=dwrMessage;
			getServerMessage("message.cannot.blank");
			msg=dwrMessage;
	 		msgArray=msg.split('#');
	 		error=error +msgArray[0]+ key_value[j] + " " + msgArray[1] +"<br>";
	 		flag=false;
 		}
			parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
 	}

	if(flag==true){
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	
	argArray[0] = "ehis.lc.requestForLinen.getlinen"
	namesArray[0]="sourceType";
	namesArray[1]="sourceCode";
	namesArray[2]="languageId";

	valuesArray[0]=sourceType;
	valuesArray[1]=sourceCode;
	valuesArray[2]=languageId;

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
	//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] =document.getElementById("linenItemDesc").value;
	getServerMessage("com.iba.ehis.lc.linenitemcode");
	retArr = Lookup(dwrMessage, argArray);
	
	if(retArr!=null)
			{
			//Set the data in to the fields
			var linenTxt=document.getElementById("linenItem");
			linenTxt.value = retArr[0];
			document.getElementById("linenItemDesc").value=retArr[1];
			}
	}
	
}		

function sourceDescLookup(){
	var sourceType=document.getElementById("vo.placeLinenRequestVO.sourceType").value;
	var sourceDesc = document.RequestForLinenForm["sourceDesc"].value;
	if(sourceType != '' && sourceDesc != '')
		showLookup();
}

function showLookup() {
		
	var sourceType=document.getElementById("vo.placeLinenRequestVO.sourceType").value;
	var facilityId=document.getElementById("vo.operatingFacilityId").value;
	var languageId=document.getElementById("languageId").value;
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array(facilityId,languageId);
		var datatypesArray = new Array();

		if(sourceType=="W")
		{
			argArray[0] = "ehis.lc.standardStock.nursingUnit"
		}
		else if(sourceType=="C")
		{
			argArray[0] = "ehis.lc.standardStock.clinic"
		}
		else if(sourceType=="D")
		{
			argArray[0] = "ehis.lc.standardStock.deptCode"
		}
		
		namesArray[0]="facilityId";
		namesArray[1]="languageId";
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = DESC_CODE;
		argArray[4] = DESC_LINK;
		argArray[5]=document.getElementById("sourceDesc").value;
		retArr = Lookup("SourceCode", argArray);
		var sourceCode = document.getElementById("vo.placeLinenRequestVO.sourceCode");
		var sourceDesc = document.RequestForLinenForm["sourceDesc"];
		if(retArr!=null){
			//Set the data in to the fields
			sourceCode.value = retArr[0];
			sourceDesc.value = retArr[1];
		}
	}

//========================================
function check() {
	var flag;
 	var error="";
 	var fieldName = new Array("com.iba.ehis.lc.linenItem");
	var fields = new Array(document.RequestForLinenForm["linenItem"]);
	var key_value=new Array();
 	for(j=0;j<fieldName.length;j++)
 	{
 		if(fields[j].value=="")
		{	
	 		getServerMessage(fieldName[j]);
	 		key_value[j]=dwrMessage;
			getServerMessage("message.cannot.blank");
			msg=dwrMessage;
	 		msgArray=msg.split('#');
	 		error=error +msgArray[0]+ key_value[j] + " " + msgArray[1] +"<br>";
	 		flag=false;
 		}
 	}
	parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
	if(flag==false) return false; else return true;
}
//========================================


//=====================================================
function fromDateCheck(dateVal){
		if(dateVal !=""){
			var languageId=document.getElementById("languageId").value;
			IBADateValidator.isCurrentDateGreaterThanJS(dateVal,languageId,callBackFunction);
			function callBackFunction(data){
				var error ="";
				var msgArray=new Array();
				if(data ==true)	{	
					
					getServerMessage("APP-LC00013");
					var message = dwrMessage;
					msgArray=message.split("#");
					getServerMessage("com.iba.ehis.lc.requestForLinen.requestDate");
					error = error + msgArray[0] + dwrMessage  + " " + msgArray[1] + "<br>";
				
					parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;

					document.QueryCriteriaForm["vo.criteriaItems[2].itemValue"].value="";
					document.QueryCriteriaForm["vo.criteriaItems[2].itemValue"].setFocus;
					
				}else parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
			}
		}
		else
			dateVal="";

	}
	function toDateCheck(dateVal){
		if(dateVal !=""){
			var dttime = dateVal.split(" ");
			 dateVal=dttime[0];
			IBADateValidator.isCurrentDateGreaterThanJS(dateVal,'en',callBackFunction);
			function callBackFunction(data){
				var error ="";
				var msgArray=new Array();
				if(data ==true)	{				
					getServerMessage("APP-LC00013");
					var message = dwrMessage;
					msgArray=message.split("#");
					getServerMessage("com.iba.ehis.lc.requestForLinen.requestDate");
					error = error + msgArray[0] + dwrMessage  + " " + msgArray[1] + "<br>";
					parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
					document.QueryCriteriaForm["vo.criteriaItems[3].itemValue"].value="";
					document.QueryCriteriaForm["vo.criteriaItems[3].itemValue"].setFocus;
					return true;
				}else	{
					parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
					return true;
				}
			}
		}
		else
			dateVal="";
	}

function reset(){
	create();
}

function checkStock(){
	
	var sourceType=document.getElementById("vo.placeLinenRequestVO.sourceType").value;
	var sourceCode=document.getElementById("vo.placeLinenRequestVO.sourceCode").value;
	var facilityId=document.getElementById("vo.operatingFacilityId").value;
	var linenItem=document.getElementById("linenItem").value;
	var reqQty=document.getElementById("qty").value;	
	var flag=true;
 	var error="";
 	var fieldName = new Array("com.iba.ehis.lc.linenItem", "com.iba.ehis.lc.requestForLinen.requestedQuantity");
	var fields = new Array(linenItem,reqQty);
	var key_value=new Array();
 	for(j=0;j<fieldName.length;j++){		  
 		if(fields[j]==""){	
	 		getServerMessage(fieldName[j]);
			key_value[j]=dwrMessage;
			getServerMessage("message.cannot.blank");
			msg=dwrMessage;
			msgArray=msg.split('#');
	 		error=error +msgArray[0]+ key_value[j] + " " + msgArray[1] +"<br>";
			flag=false;
 		}
		
 	}
	parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
	if(flag==true){
		LinenRequest.getInUseQtyLookup(sourceType,sourceCode,linenItem,facilityId,getInUseQty);

	function getInUseQty(data2){	
		for(prop in data2){
			for(prop1 in data2[prop]){
				inuseQty=data2[prop][0]	
				var soiledQty=data2[prop][1]
				var loanedQty=data2[prop][2]
				inuseQty=parseInt(inuseQty)+parseInt(soiledQty)+parseInt(loanedQty)
				}
			}
		LinenRequest.getStockParam(facilityId,getParam);
	function getParam(data1){
		for(prop in data1){
			param=prop;
			}
		LinenRequest.getStock(sourceType,sourceCode,linenItem,facilityId,validateStock);

		function validateStock(data){
			var stock=0;
			var qty=parseInt(document.getElementById("qty").value)+parseInt(inuseQty);
			for(prop in data){
				 stock=prop;
				 }
			if(param=="T"){
				if(parseInt(qty)>parseInt(stock)){
		 		getServerMessage("com.iba.ehis.lc.requestForLinen.requestedQuantity");
				var label1=dwrMessage;
				getServerMessage("com.iba.ehis.lc.stdStock");
				var label2=dwrMessage;
				getServerMessage("messege.number.greatethan");
				var msg=dwrMessage;
				msgArray=msg.split('#');
				//obj.setFocus();
				var error=msgArray[0]+" "+ label1 + " " + msgArray[1] +""+label2+" "+stock+"<br>";
				parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
				getServerMessage("APP-LC00016");
				var val=confirm(dwrMessage);
			var val=true;
				if(val==true)populateList();
				}
				else
					populateList();
				}

			else if(param=="S"){
				if(parseInt(qty)>parseInt(stock)){
		 			getServerMessage("com.iba.ehis.lc.requestForLinen.requestedQuantity");
					var label1=dwrMessage;
					getServerMessage("com.iba.ehis.lc.stdStock");
					var label2=dwrMessage;
					getServerMessage("messege.number.greatethan");
					var msg=dwrMessage;
			 		msgArray=msg.split('#');
					var obj=document.getElementById("qty")
	 				obj.value="";
					//obj.setFocus();
					var error=msgArray[0]+" "+ label1 + " " + msgArray[1] +""+label2+" "+stock+"<br>";
			   		parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
				}else{
					populateList();
					}
				}
			else{
				populateList();
				}
			}
		}
	}
}
}
// added for RequestListCUD.jsp

function reqListSourceDescLookup(){
	var sourceType=document.getElementById("vo.criteriaItems[0].itemValue").value;
	var sourceDesc = document.QueryCriteriaForm["reqListSourceDesc"].value;
	if(sourceType != '' && sourceDesc != '')
		showLookupReqForList();
	}

function showLookupReqForList() {
	var sourceType=document.QueryCriteriaForm["vo.criteriaItems[0].itemValue"].value;
	if(sourceType != ''){
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array(document.QueryCriteriaForm["vo.operatingFacilityId"].value);
		var datatypesArray = new Array();
		namesArray[0]="facilityId";

		if(sourceType=="W")
			argArray[0] = "ehis.lc.standardStock.nursingUnit"
		else if(sourceType=="C")
			argArray[0] = "ehis.lc.standardStock.clinic"
		else if(sourceType=="D")
			argArray[0] = "ehis.lc.standardStock.deptCode"
		else 	argArray[0] = "ehis.lc.standardStock.nursingUnit"

		argArray[1] = namesArray;
		argArray[2] = valuesArray;
							
				//Display Order
		argArray[3] = DESC_CODE;

				// Link Description
		argArray[4] = DESC_LINK;
		argArray[5] =document.QueryCriteriaForm["reqListSourceDesc"].value;
		retArr = Lookup("SourceCode", argArray);
		var sourceCode = document.QueryCriteriaForm["vo.criteriaItems[1].itemValue"];
		var sourceDesc = document.QueryCriteriaForm["reqListSourceDesc"];
		if(retArr!=null){
			//Set the data in to the fields
			sourceCode.value = retArr[0];
			sourceDesc.value = retArr[1];
			}
		}
	}		


function setClearLinenDesc(){
	document.getElementById("vo.criteriaItems[6].itemValue").value="";
}
function requestListLookup(){
	var linenDesc = document.getElementById("linenDesc").value;
	if(linenDesc != '')	  {		document.getElementById("vo.criteriaItems[6].itemValue").value="";
		showLookupForList();}
	}

function showLookupForList() {
	var sourceType=document.QueryCriteriaForm["vo.criteriaItems[0].itemValue"].value;
	var sourceCode=document.QueryCriteriaForm["vo.criteriaItems[1].itemValue"].value;
	var languageId=document.getElementById("languageId").value;

	var flag=true;
 	var error="";
 	var fieldName = new Array(
		"com.iba.ehis.lc.standardStock.sourceType",
		"com.iba.ehis.lc.standardStock.source");
	var fields = new Array(sourceType,sourceCode);
	var key_value= new Array();

 	for(j=0;j<fieldName.length;j++)
 	{
 		if(fields[j]=="")
		{	
	 		getServerMessage(fieldName[j]);
	 		key_value[j]=dwrMessage;
			getServerMessage("message.cannot.blank");
			msg=dwrMessage;
	 		msgArray=msg.split('#');
	 		error=error +msgArray[0]+ key_value[j] + " " + msgArray[1] +"<br>";
	 		flag=false;
 		}
			parent.parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
 	}

	if(flag==true){
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	
	argArray[0] = "ehis.lc.requestForLinen.getlinen"
	namesArray[0]="sourceType";
	namesArray[1]="sourceCode";
	namesArray[2]="languageId";

	valuesArray[0]=sourceType;
	valuesArray[1]=sourceCode;
	valuesArray[2]=languageId;

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] =document.QueryCriteriaForm["linenDesc"].value;
	getServerMessage("com.iba.ehis.lc.linenitemcode");
	retArr = Lookup(dwrMessage, argArray);
	
	if(retArr!=null)
			{
			//Set the data in to the fields
			var linenTxt=document.QueryCriteriaForm["vo.criteriaItems[6].itemValue"];
			linenTxt.value = retArr[0];
			document.QueryCriteriaForm["linenDesc"].value=retArr[1];
			}
		}
	}

function submitQuery(){
	var request_status = document.getElementById("vo.criteriaItems[5].itemValue").value;
	var flag=checkNull1();
 	if(flag==true){
		var fromDate = document.getElementById("vo.criteriaItems[2].itemValue").value;
		var toDate = document.getElementById("vo.criteriaItems[3].itemValue").value;
		if(toDate !=""){
			IBADateValidator.isDateGreaterThanJS(fromDate,toDate,'en',callBackFunction);
			function callBackFunction(data){
				var error ="";
				var msgArray=new Array();
				if(data ==true)	{	
					getServerMessage("APP-LC00013");
					var message = dwrMessage;
					msgArray=message.split("#");
					getServerMessage("com.iba.ehis.lc.requestForLinen.requestDate");
					error = error + msgArray[0] + "To Date" +  " " + msgArray[1] +" "+ dwrMessage + "<br>";
					parent.parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
					document.getElementById("vo.criteriaItems[3].itemValue").value="";
					document.getElementById("vo.criteriaItems[3].itemValue").setFocus;
					
				}else	{
					if(request_status == 'OS+PI'){
						document.getElementById("vo.functionId").value = 'REQ_FOR_LINEN';
						//alert(document.getElementById("vo.functionId").value)
						document.QueryCriteriaForm.submit();
					}else	 if(request_status == 'ALL'){
						document.getElementById("vo.functionId").value = 'ALL_REQ_FOR_LINEN';
						//alert(document.getElementById("vo.functionId").value)
						document.QueryCriteriaForm.submit();
					}else {
						document.getElementById("vo.functionId").value = 'LC_REQ_FOR_LINEN';
						//alert(document.getElementById("vo.functionId").value)
						document.QueryCriteriaForm.submit();
					}
				}
			}
		}
	}
}

function CurrDate(arg){	
	
	var currDate = new Date();
	var date = currDate.getDate();
	var mon = currDate.getMonth();
	var hrNow = currDate.getHours();
	var mnNow = currDate.getMinutes();
	scNow = currDate.getSeconds();
	//alert(time)
	mon = mon+1;
	var year = currDate.getYear();
	if(date <10)
		date = "0"+date;
	if(mon <10)
		mon = "0"+mon;
	var convert1= date + "/" + mon + "/" + year;
	if(hrNow<10)
			hrNow="0"+hrNow;
	if(mnNow<10)
			mnNow="0"+mnNow;
	
	convert1=convert1+" "+hrNow+ ":" +mnNow;
	
	var seven = 1000 * 60 * 60 * 24 * 7;
	var reqFromCurrDate = new Date(currDate - seven);
	var fromDate = reqFromCurrDate.getDate();
	var fromMonth = reqFromCurrDate.getMonth();
	fromMonth = fromMonth+1;
	var fromYear = reqFromCurrDate.getYear();
	if(fromDate <10)
		fromDate = "0"+fromDate;
	if(fromMonth <10)
		fromMonth = "0"+fromMonth;
	var reqFromDate= fromDate + "/" + fromMonth + "/" + fromYear;
	var reqFromDate1= reqFromDate+" "+hrNow+ ":" +mnNow;


	if(arg=='R'){
		var rdate=document.getElementById("vo.criteriaItems[2].itemValue");
		var rdate1=document.getElementById("vo.criteriaItems[3].itemValue");

		rdate.value=reqFromDate1;
		rdate1.value=convert1;
	
		IBADateValidator.convertDateJS(reqFromDate1,"en",document.getElementById("languageId").value,"dd/MM/yyyy HH:mm",RDFromcallbackMethod);
		function  RDFromcallbackMethod(fdate){
				document.getElementById("requestDate").value=fdate;
		}
		IBADateValidator.convertDateJS(convert1,"en",document.getElementById("languageId").value,"dd/MM/yyyy HH:mm",RDTocallbackMethod);
		function  RDTocallbackMethod(tdate){
				document.getElementById("toRequestDate").value=tdate;
		}
	}
}

function isValidDate(obj){

	if(obj.value!=""){
		var str=obj.value;
		var dflag=true;
		var tflag=true;
		var dateValArr = str.split(' ');
		if (dateValArr.length != 2) 
			{
			 getServerMessage("APP-LC0003");
			 alert(dwrMessage);
			 obj.value="";
			 obj.focus();
			}
			else
			{
			 dflag=checkDate(dateValArr[0]);
			 tflag=checkTime(dateValArr[1]);
			 if(dflag==true && tflag==true)
				{
				}
				else
					{
					 obj.value="";
					 obj.focus();
					}
			}
		
		
	}

}	
function checkDate(objval)
{
	
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = objval;
		//alert("Current Date 3751"+str_date);
		var arr_date = str_date.split('/');
		if (arr_date.length != 3) 
			{
			getServerMessage("APP-LC00014");
			 alert(dwrMessage);
			};
		else
		{//flag=false;
		if (!arr_date[0]) flag=false;
		if (!RE_NUM.exec(arr_date[0])) flag=false;
		if (!arr_date[1]) flag=false;
		if (!RE_NUM.exec(arr_date[1])) flag=false;
		if (!arr_date[2]) flag=false;
		if (arr_date[2].length!=4) flag=false;
		var dt_date = new Date();
		dt_date.setDate(1);
		if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;
		
		if (flag==false){
			getServerMessage("APP-LC00014");
			 alert(dwrMessage);
			}
		}
		return flag;
}

function checkTime(field)
  {
    var errorMsg = "";

    // regular expression to match required time format
    re = /^(\d{1,2}):(\d{2})(:00)?([ap]m)?$/;
    
    if(field.value != '') {
      if(regs = field.match(re)) {
        if(regs[4]) {
          // 12-hour time format with am/pm
          if(regs[1] < 1 || regs[1] > 12) {
			  getServerMessage("APP-LC0006");
			  errorMsg =dwrMessage;// "Invalid value for hours: " + regs[1];
          }
        } else {
          // 24-hour time format
          if(regs[1] > 23) {
			  getServerMessage("APP-LC0006");
			  errorMsg =dwrMessage;
           // errorMsg = "Invalid value for hours: " + regs[1];
          }
        }
        if(!errorMsg && regs[2] > 59) {
			 getServerMessage("APP-LC0005");
			  errorMsg =dwrMessage;
         // errorMsg = "Invalid value for minutes: " + regs[2];
        }
      } else {
			  getServerMessage("APP-LC00019");
			  errorMsg =dwrMessage;
       // errorMsg = "Invalid time format";
      }
    }

    if(errorMsg != "") {
      alert(errorMsg);
      return false;
    }
    
    return true;
  }


