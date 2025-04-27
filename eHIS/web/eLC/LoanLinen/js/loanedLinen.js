
var viewId;

function tabClicked(evt) {
	var selectedTabPane = evt.getTabPane();
	viewId = selectedTabPane.id;
}
function create() {
	content.location.href = contextPath + "/eLC/LoanLinen/jsp/LoanLinenMainFrames.jsp";
}
    	   
function apply() {

			document.LoanLinenForm.submit();
			
}
function getLoanReason(data){
	
	var defectReason=document.QueryCriteriaForm("vo.criteriaItems[8].itemValue");
	for(prop in data){
			DWRUtil.removeAllOptions(defectReason);
			DWRUtil.addOptions(defectReason,data,prop);
		
	}
}
function CurrDate(arg){	
		var currDate = new Date();
		var date = currDate.getDate();
		var mon = currDate.getMonth();
		var hrNow = currDate.getHours();
		var mnNow = currDate.getMinutes();
		var scNow = currDate.getSeconds();
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
		var reqToDate= date + "/" + mon + "/" + year;
		reqToDate=reqToDate+" "+hrNow+":"+mnNow;
		if(arg=='C')
		{
		var rdate=document.getElementById("vo.loanLinenVO.loanDate");
		rdate.value=reqToDate;
		}
		else if(arg=='V')
		{
		var rdate=document.getElementById("vo.loanLinenVO.cancelledDate");
		rdate.value=reqToDate;
		}

		}

function CurrDate1(){	
		var currDate = new Date();

		var date = currDate.getDate();
		var mon = currDate.getMonth();
		var hrNow = currDate.getHours();
		var mnNow = currDate.getMinutes();
		var scNow = currDate.getSeconds();
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
		var reqToDate= date + "/" + mon + "/" + year;
		reqToDate=reqToDate+" "+hrNow+":"+mnNow;
		var toDate=document.getElementById("vo.criteriaItems[5].itemValue");
		toDate.value=reqToDate;
			
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
		var fromDate=document.getElementById("vo.criteriaItems[4].itemValue");
		fromDate.value = reqFromDate+" "+hrNow+":"+mnNow;
	}

function checkNull() {

	var flag;
 	var error="";
 	var fieldName = new Array(
		"com.iba.ehis.lc.loanLinen.loanrefNo",
		"com.iba.ehis.lc.loanLinen.loanDate",
		"com.iba.ehis.lc.standardStock.sourceType",
		"com.iba.ehis.lc.standardStock.source",
		"com.iba.ehis.lc.loanLinen.loanTo",
		"com.iba.ehis.lc.standardStock.source",
		"com.iba.ehis.lc.loanLinen.givenBy",
		"com.iba.ehis.lc.loanLinen.receivedBy",
		"com.iba.ehis.lc.loanLinen.reasonforLoan",
		"com.iba.ehis.lc.linenItem",
		"com.iba.ehis.lc.loanLinenloanedQty");
	var fields = new Array(
		document.LoanLinenForm["vo.loanLinenVO.loanRefNum"].value,
		document.LoanLinenForm["vo.loanLinenVO.loanDate"].value,
		document.LoanLinenForm["vo.loanLinenVO.sourceType"].value,
		document.LoanLinenForm["vo.loanLinenVO.sourceCode"].value,
		document.LoanLinenForm["vo.loanLinenVO.loanedToSourceType"].value,
		document.LoanLinenForm["vo.loanLinenVO.loanedToSourceCode"].value,
		document.LoanLinenForm["vo.loanLinenVO.givenBy"].value,
		document.LoanLinenForm["vo.loanLinenVO.receivedBy"].value,
		document.LoanLinenForm["vo.loanLinenVO.reasonDesc"].value,
		document.LoanLinenForm["vo.loanLinenVO.linenItem"].value,
		document.LoanLinenForm["vo.loanLinenVO.loanedQty"].value);
	var key_value=new Array();
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
 	}
	parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
	if(flag==false) return false; else return true;
	checkStock();
}
function checkNull1() {
	var flag;
 	var error="";
 	var fieldName = "com.iba.ehis.lc.requestForLinen.requestDate";
	var fields = document.QueryCriteriaForm["vo.criteriaItems[2].itemValue"];
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
//===================================================== 
function getRequestNumber(data){
	var max=0;
	var temp=0;
	var i = 0;
	var popArray = new Array();
	 for(prop in data){
		popArray[i] = prop;
		i++;
	 }
	 for (var j=0; j <popArray.length;j++ ){
		if(parseInt(popArray[j])>parseInt(max))	
		max=parseInt(popArray[j]);
		
		}
	 max=parseInt(max)+1;
	 document.getElementById("vo.loanLinenVO.loanRefNum").value=max;
}

function settime(){
	window.setTimeout(AlertMsg,1000);	
}

function AlertMsg(){
	var obj=document.getElementById("vo.loanLinenVO.loanRefNum");
	var flag=checkNull();
		if(flag==true){ 
			getServerMessage("com.iba.ehis.lc.pnyrequestNum");
			alert(dwrMessage+" "+" : "+obj.value);
			apply();
		}
	}
//==============================================================

	function setClearLoan(){
		document.getElementById("loanedToSourceCode").value="";
	}
	
function showLookup1() {
	var sourceType=document.getElementById("vo.loanLinenVO.sourceType").value;
	var sourceCode=document.getElementById("vo.loanLinenVO.sourceCode").value;
	var languageId=document.getElementById("languageId").value;
	
	var flag=true;
 	var error="";
 	var fieldName = new Array(
		"com.iba.ehis.lc.standardStock.sourceType",
		"com.iba.ehis.lc.standardStock.source");
	var fields = new Array(sourceType,sourceCode);
	var key_value= new Array();
	
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
	retArr = Lookup("LinenItemCode", argArray);
	
	if(retArr!=null)
			{
			//Set the data in to the fields
			var linenTxt=document.getElementById("vo.loanLinenVO.linenItem");
			linenTxt.value = retArr[0];
			document.getElementById("linenItemDesc").value=retArr[1];
			}
	}
	
}		
function showLookupSource() {
	var sourceType = document.LoanLinenForm["vo.loanLinenVO.sourceType"].value;
	var language_Id = document.getElementById("languageId").value;
	var facility_Id = document.LoanLinenForm["vo.operatingFacilityId"].value
	
	var argArray = new Array();
	var datatypesArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	
	namesArray[0]="languageId";	
	valuesArray[0] = language_Id;
	
	if(sourceType=="W"){
		argArray[0] = "ehis.lc.standardStock.nursingUnit"
		namesArray[1] = "facilityId";
		valuesArray[1] = facility_Id
	}
	else if(sourceType=="C")
		argArray[0] = "ehis.lc.standardStock.clinic"
	else if(sourceType=="D")
		argArray[0] = "ehis.lc.standardStock.deptCode"
	else 	
		argArray[0] = "ehis.lc.standardStock.nursingUnit"

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] = document.LoanLinenForm["sourceCode"].value;
	getServerMessage("com.iba.ehis.lc.sourceCode");
	retArr = Lookup(dwrMessage, argArray);
	var txtUser = document.LoanLinenForm["vo.loanLinenVO.sourceCode"];
	var desc=document.LoanLinenForm["sourceCode"];
	if(retArr!=null){
		//Set the data in to the fields
		txtUser.value = retArr[0];
		desc.value= retArr[1];
		}
	}

function showLookup2() {
	var sourceType=document.LoanLinenForm["vo.loanLinenVO.loanedToSourceType"].value;
	var sourceCode=document.LoanLinenForm["vo.loanLinenVO.sourceCode"].value;
	var language_Id = document.getElementById("languageId").value;
	var facility_Id = document.LoanLinenForm["vo.operatingFacilityId"].value
	
	var argArray = new Array();
	var datatypesArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array(document.LoanLinenForm["vo.operatingFacilityId"].value,language_Id);
	
	namesArray[0] = "languageId";
	valuesArray[0] = language_Id;

	if(sourceType=="W"){
		argArray[0] = "ehis.lc.standardStock.nursingUnit"
		namesArray[1] = "facilityId";
		valuesArray[1] = facility_Id;
		if(sourceCode!=''){
		namesArray[2] = "fcode";
		valuesArray[2] = sourceCode;}
	}
	else if(sourceType=="C")
	{
		argArray[0] = "ehis.lc.standardStock.clinic"
		if(sourceCode!=''){
		namesArray[1] = "fcode";
		valuesArray[1] = sourceCode;}
	}
	else if(sourceType=="D")
	{
		argArray[0] = "ehis.lc.standardStock.deptCode"
		if(sourceCode!=''){
		namesArray[1] = "fcode";
		valuesArray[1] = sourceCode;}
	}
	else if(sourceType == "P")
	{
		argArray[0] = "ehis.lc.patientlookup";
	}


	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] = document.LoanLinenForm["loanedToSourceCode"].value;
	getServerMessage("com.iba.ehis.lc.loanedtosourcecode");
	retArr = Lookup(dwrMessage, argArray);
	var txtUser = document.LoanLinenForm["vo.loanLinenVO.loanedToSourceCode"];
	var txtUser1 = document.LoanLinenForm["loanedToSourceCode"];
	if(retArr!=null){
		//Set the data in to the fields
		txtUser.value = retArr[0];
		txtUser1.value = retArr[1];
	}
}

function showLoanedDescLookup()
{
		var loanedCode=document.getElementById("vo.criteriaItems[2].itemValue").value;
		var loanedDesc = document.getElementById("linenItem").value;
		if(loanedCode != '' && loanedDesc != '')
			linenItemLookup();
}

function linenItemLookup() {
	
	var languageId=document.getElementById("languageId").value;
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	
	argArray[0] = "ehis.lc.standardStock.linenItem"
	
	
	namesArray[0]="languageId";

	valuesArray[0]=languageId;
	
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] =document.getElementById("linenItem").value;
	getServerMessage("com.iba.ehis.lc.linenType.linenItemCode");
	retArr = Lookup(dwrMessage, argArray);
	
	if(retArr!=null){
		//Set the data in to the fields
		var linenTxt=document.getElementById("vo.criteriaItems[10].itemValue");
		linenTxt.value = retArr[0];
		document.getElementById("linenItem").value=retArr[1];
		}
}		

function showLoanedLookup() {
	var sourceCode=document.getElementById("vo.criteriaItems[1].itemValue").value;
	var sourceType=document.getElementById("vo.criteriaItems[2].itemValue").value;
	var facilityId=document.getElementById("vo.operatingFacilityId").value;
	var languageId=document.getElementById("languageId").value;

	var argArray = new Array();
	var datatypesArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array(facilityId,languageId);
	namesArray[0]="facilityId";
	
	if(sourceType=="W")
		{	argArray[0] = "ehis.lc.standardStock.nursingUnit"
			if(sourceCode!=''){
			namesArray[2] = "fcode";
			valuesArray[2] = sourceCode;}
		  
		}
		else if(sourceType=="P")
		{	argArray[0] = "ehis.lc.patientlookup"
		   
		}
		else if(sourceType=="C")
		{	argArray[0] = "ehis.lc.standardStock.clinic"
			if(sourceCode!=''){
			namesArray[2] = "fcode";
			valuesArray[2] = sourceCode;}
		}
		else if(sourceType=="D")
		{	argArray[0] = "ehis.lc.standardStock.deptCode"
			if(sourceCode!=''){
			namesArray[2] = "fcode";
			valuesArray[2] = sourceCode;}
		}
		

	
	namesArray[0]="facilityId";
	namesArray[1]="languageId";

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] = document.getElementById("loanedToSourceCode").value;
	getServerMessage("com.iba.ehis.lc.loanedtosourcecode");
	retArr = Lookup(dwrMessage, argArray);
	var txtUser = document.getElementById("loanedToSourceCode");
	if(retArr!=null){
		//Set the data in to the fields
		txtUser.value = retArr[1];
		document.getElementById("vo.criteriaItems[3].itemValue").value=retArr[0];
	}
}

function showSourceLookup() {
	var sourceType=document.getElementById("vo.criteriaItems[0].itemValue").value;
	var argArray = new Array();
	var datatypesArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array(document.QueryCriteriaForm["vo.operatingFacilityId"].value);
	namesArray[0]="facilityId";
	
	if(sourceType=="W")
		argArray[0] = "ehis.lc.standardStock.nursingUnit"
	else if(sourceType=="P")
		argArray[0] = "ehis.lc.patientlookup"
	else if(sourceType=="C")
		argArray[0] = "ehis.lc.standardStock.clinic"
	else if(sourceType=="D")
		argArray[0] = "ehis.lc.standardStock.deptCode"
	else
		argArray[0] = "ehis.lc.standardStock.nursingUnit"

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] = document.getElementById("sourceDesc").value;
	getServerMessage("com.iba.ehis.lc.sourceCode");
	retArr = Lookup(dwrMessage, argArray);
	var txtUser = document.getElementById("sourceDesc");
	if(retArr!=null){
		//Set the data in to the fields
		txtUser.value = retArr[1];
		document.getElementById("vo.criteriaItems[1].itemValue").value=retArr[0];
	}
}

function checkNumber(obj){
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
        }
    else
        if ( val.length > 0 ) {
            	getServerMessage("message.Numbers.Allowed");
				parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
				window.event.keyCode = 27;
				obj.value="";
			return false;
			}
   		}
   	
function reset(){
	create();
}

function checkNullList() {
	var sourceType=	document.QueryCriteriaForm["sourceType"];
	var sourceCode = document.QueryCriteriaForm["sourceCode"];
	var loanedDateFrom = document.QueryCriteriaForm["loanDateFrom"];

	var flag;
	var error="";
	var fieldName = new Array(
		"com.iba.ehis.lc.standardStock.sourceType",
		"com.iba.ehis.lc.standardStock.source", 
		"com.iba.ehis.lc.receiveloanedlinen.loanDateFrom");
	var fields = new Array(sourceType,sourceCode,loanedDateFrom);
	var key_value=new Array();
	for(j=0;j<fieldName.length;j++){	
		if(fields[j].value ==""){					
			getServerMessage(fieldName[j]);
			key_value[j]=dwrMessage;
			getServerMessage("message.cannot.blank");
			msg=dwrMessage;
			msgArray=msg.split('#');
			error=error +msgArray[0]+ key_value[j] + " " + msgArray[1] +"<br>";
			flag=false;
		}
	}		 	
	parent.parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
	if(flag==false) return false; else return true;
}
function checkStock(){
	var sourceType=document.getElementById("vo.loanLinenVO.sourceType").value;
	var sourceCode=document.getElementById("vo.loanLinenVO.sourceCode").value;
	var facilityId=document.getElementById("vo.operatingFacilityId").value;
	var linenItem=document.getElementById("vo.loanLinenVO.linenItem").value;
	if(linenItem!==""&&sourceType!=""&&sourceCode!=""&&facilityId!=""){
	LinenRequest.getInUseQtyLookup(sourceType,sourceCode,linenItem,facilityId,validateStock);

function validateStock(data){
	var stock=0;
	var qty=document.getElementById("vo.loanLinenVO.loanedQty").value;
	for(prop in data)
		stock=prop;
		if(parseInt(qty)>parseInt(stock)){
		getServerMessage("com.iba.ehis.lc.loanLinenloanedQty");
		var label1=dwrMessage;
		getServerMessage("com.iba.ehis.lc.stdStock");
		var label2=dwrMessage;
		getServerMessage("messege.number.greatethan");
		msg=dwrMessage;
		msgArray=msg.split('#');
		var obj=document.getElementById("vo.loanLinenVO.loanedQty")
		obj.value="";
		//obj.setFocus();
		var error=msgArray[0]+" "+ label1 + " " + msgArray[1] +""+label2+" "+stock+"<br>";
		parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		
		}
	}
}}

// ================== LoanListCUD ======================================

function submitQuery(){
	//	var linenItemDesc = document.QueryCriteriaForm("linenItemDesc");
	//	if(linenItemDesc.value==""){
	//		document.QueryCriteriaForm("vo.criteriaItems[6].itemValue").value="";
	//	}
		var request_status = document.getElementById("vo.criteriaItems[9].itemValue").value;
		var language_Id = document.getElementById("languageId").value;
		var flag=checkNullList();
		if(flag==true){
			var fromDate = document.getElementById("vo.criteriaItems[4].itemValue").value;
			var toDate = document.getElementById("vo.criteriaItems[5].itemValue").value;
			if(toDate !=""){
				IBADateValidator.isDateGreaterThanJS(fromDate,toDate,language_Id,callBackFunction);
				function callBackFunction(data){
					var error ="";
					var msgArray=new Array();
					if(data ==true)	{	
						getServerMessage("APP-LC00013");
						var message = dwrMessage;
						msgArray=message.split("#");
						getServerMessage("com.iba.ehis.lc.receiveloanedlinen.loanDateTo");
						var label = dwrMessage;
						getServerMessage("com.iba.ehis.lc.receiveloanedlinen.loanDateFrom");
						error = error + msgArray[0] + label +  " " + msgArray[1] +" "+ dwrMessage + "<br>";
						parent.parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
						document.getElementById("vo.criteriaItems[5].itemValue").value="";
						document.getElementById("vo.criteriaItems[5].itemValue").setFocus;
					} else {
						if(request_status == 'OS'||request_status == 'L'){
							document.getElementById("vo.functionId").value = 'LOAN_LINEN';
							document.QueryCriteriaForm.submit();
						}
						else if(request_status == ''){
							document.getElementById("vo.functionId").value = 'ALL_LOAN_LINEN';
							document.QueryCriteriaForm.submit();
						}else {
								document.getElementById("vo.functionId").value = 'LC_LOAN_LINEN';
								document.QueryCriteriaForm.submit();
						      }
					}
				}
			}
		}
	} 

	function getLoginUser(){
		var userId = document.getElementById("loginUser").value;
		var language_Id = document.getElementById("languageId").value;
		RequestForCleaning.getLoggedInUser(language_Id,userId,callLoggedInUser);
	}

	function callLoggedInUser(data){
		for(prop in data){
		//	document.getElementById("vo.criteriaItems[6].itemValue").value = data[prop];
		//document.getElementById("vo.criteriaItems[7].itemValue").value = data[prop];
		}
	}	 

	function CurrDate2(){
		var language_Id = document.getElementById("languageId").value;
		var currDate = new Date();
		var date = currDate.getDate();
		var mon = currDate.getMonth();
		var hrNow = currDate.getHours();
		var mnNow = currDate.getMinutes();
		var scNow = currDate.getSeconds();
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
		var reqToDate= date + "/" + mon + "/" + year;
		reqToDate=reqToDate+" "+hrNow+":"+mnNow;
		var toDate=document.getElementById("vo.criteriaItems[5].itemValue");
		//toDate.value=reqToDate;
			
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
		var fromDate=document.getElementById("vo.criteriaItems[4].itemValue");
//		fromDate.value = reqFromDate+" "+hrNow+":"+mnNow;
		fromDate = reqFromDate+" "+hrNow+":"+mnNow;

		var fdate=document.getElementById("vo.criteriaItems[4].itemValue");
		fdate.value=fromDate;

		IBADateValidator.convertDateJS(fromDate,"en",language_Id,"dd/MM/yyyy HH:mm",RDFromcallbackMethod);
		function  RDFromcallbackMethod(fdate){
			document.getElementById("loanDateFrom").value=fdate;
		}
		
		var rdate=document.getElementById("vo.criteriaItems[5].itemValue");
		rdate.value=reqToDate;

		IBADateValidator.convertDateJS(reqToDate,"en",language_Id,"dd/MM/yyyy HH:mm",RDTocallbackMethod);
		function  RDTocallbackMethod(tdate){
			document.getElementById("loanDateTo").value=tdate;
		}
	}

function setClearLinenDesc(){
	document.getElementById("vo.criteriaItems[10].itemValue").value="";
}

function setClearSourceDesc(){
	document.getElementById("vo.criteriaItems[3].itemValue").value="";
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
function showLookupLoanList() {
	var sourceType=document.QueryCriteriaForm["vo.criteriaItems[0].itemValue"].value;
	var sourceCode=document.QueryCriteriaForm["vo.criteriaItems[1].itemValue"].value;
	var language_Id = document.getElementById("languageId").value;
	var facility_Id = document.QueryCriteriaForm["vo.operatingFacilityId"].value
	
	var argArray = new Array();
	var datatypesArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array(document.QueryCriteriaForm["vo.operatingFacilityId"].value,language_Id);
	
	namesArray[0] = "languageId";
	valuesArray[0] = language_Id;

	if(sourceType=="W"){
		argArray[0] = "ehis.lc.standardStock.nursingUnit"
		namesArray[1] = "facilityId";
		valuesArray[1] = facility_Id;
		if(sourceCode!=''){
		namesArray[2] = "fcode";
		valuesArray[2] = sourceCode;}
	}
	else if(sourceType=="C")
	{
		argArray[0] = "ehis.lc.standardStock.clinic"
		if(sourceCode!=''){
		namesArray[1] = "fcode";
		valuesArray[1] = sourceCode;}
	}
	else if(sourceType=="D")
	{
		argArray[0] = "ehis.lc.standardStock.deptCode"
		if(sourceCode!=''){
		namesArray[1] = "fcode";
		valuesArray[1] = sourceCode;}
	}
	else if(sourceType == "P")
	{
		argArray[0] = "ehis.lc.patientlookup";
	}


	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] = document.QueryCriteriaForm["loanedToSourceCode"].value;
	getServerMessage("com.iba.ehis.lc.loanedtosourcecode");
	retArr = Lookup(dwrMessage, argArray);
	var txtUser = document.QueryCriteriaForm["vo.criteriaItems[3].itemValue"];
	var txtUser1 = document.QueryCriteriaForm["loanedToSourceCode"];
	if(retArr!=null){
		//Set the data in to the fields
		txtUser.value = retArr[0];
		txtUser1.value = retArr[1];
	}
}

//	======= END OF SCRIPT  ============

