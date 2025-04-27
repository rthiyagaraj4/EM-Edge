
// ****************** TO GET FRAME PAGE ***************************************************************
	function Borrow() {
		var moduleId="LC";
		var functionId="RECEIVE_LOANED_LINEN";
		content.location.href = contextPath + "/eLC/ReceiveLoanedLinen/jsp/ReceiveLoanedLinenMainFrames.jsp"
	}
	
// ****************** SOURCE LOOKUP BASED ON SOURCE TYPE **********************************************
	
	function showSourceLookup() {
		
		var sourceType=document.getElementById("vo.criteriaItems[0].itemValue").value;
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
			
			argArray[1] = namesArray;
			argArray[2] = valuesArray;
			argArray[3] = DESC_CODE;
			argArray[4] = DESC_LINK;
			argArray[5] = document.getElementById("source").value;
		
			retArr = Lookup("SourceCode", argArray);
				
			if(retArr!=null){
				var sourceCode = document.getElementById("vo.criteriaItems[1].itemValue");
				var sourceDesc = document.getElementById("source");
				sourceCode.value = retArr[0];
				sourceDesc.value = retArr[1];
			}
		}
	}
	
// ****************** SOURCE LOOKUP *******************************************************************
	
	function sourceDescLookup()
		{
			var sourceType=document.getElementById("vo.criteriaItems[0].itemValue").value;
			var sourceDesc = document.getElementById("source").value;
			if(sourceType != '' && sourceDesc != '')
				showSourceLookup();
	}
	
// ****************** TO CLEAR SOURCE DESC ************************************************************
	
	function setClear(){
		document.getElementById("sourceDesc").value="";
		
	}	
	
// ****************** TO CLEAR LOANED DESC ************************************************************
	
	function setClearLoan(){
		document.getElementById("loanedDesc").value="";
	}
	
// ****************** LOANED LOOKUP BASED ON LOANED SOURCE TYPE ***************************************
	
	function showLoanedLookup() {

		var loanedSourceType=document.getElementById("vo.criteriaItems[2].itemValue").value;
		var sourceCode=document.getElementById("vo.criteriaItems[1].itemValue").value;
		var facilityId=document.QueryCriteriaForm["vo.operatingFacilityId"].value;
		var languageId=document.getElementById("languageId").value;
		
		if(loanedSourceType != ''){
			var argArray = new Array();
			var namesArray = new Array();
			var valuesArray = new Array(facilityId,languageId);
			var datatypesArray = new Array();
			
			if(loanedSourceType=="W"){
				argArray[0] = "ehis.lc.standardStock.nursingUnit"
				if(sourceCode!=''){
				namesArray[2] = "fcode";
				valuesArray[2] = sourceCode;}
			}
			else if(loanedSourceType=="C")
			{
				argArray[0] = "ehis.lc.standardStock.clinic"
				if(sourceCode!=''){
				namesArray[2] = "fcode";
				valuesArray[2] = sourceCode;}
			}
			else if(loanedSourceType=="D")
			{
				argArray[0] = "ehis.lc.standardStock.deptCode"
				if(sourceCode!=''){
				namesArray[2] = "fcode";
				valuesArray[2] = sourceCode;}
			}
			else if(loanedSourceType == "P")
				argArray[0] = "ehis.lc.patientlookup";

			namesArray[0]="facilityId";
			namesArray[1]="languageId";


			
			argArray[1] = namesArray;
			argArray[2] = valuesArray;
			argArray[3] = DESC_CODE;
			argArray[4] = DESC_LINK;
			argArray[5]=document.getElementById("loanedDesc").value;
		
			retArr = Lookup("SourceCode", argArray);
			if(retArr!=null){
				var loanedSourceCode = document.getElementById("vo.criteriaItems[3].itemValue");
				var loanedSourceDesc = document.getElementById("loanedDesc");
				loanedSourceCode.value = retArr[0];
				loanedSourceDesc.value = retArr[1];
				}
			}
		}
// ****************** LOANED SOURCE LOOKUP ************************************************************
	
	function showLoanedDescLookup()
		{
			var loanedCode=document.getElementById("vo.criteriaItems[4].itemValue").value;
			var loanedDesc = document.getElementById("loanedDesc").value;
			if(loanedCode != '' && loanedDesc != '')
				showLoanedLookup();
	}
	
// ****************** LINEN ITEM LOOKUP ***************************************************************
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
	argArray[5] =document.getElementById("linenItemDesc").value;
	retArr = Lookup("LinenItemCode", argArray);
	
	if(retArr!=null)
			{
			//Set the data in to the fields
			var linenTxt=document.getElementById("vo.criteriaItems[10].itemValue");
			linenTxt.value = retArr[0];
			document.getElementById("linenItemDesc").value=retArr[1];
			}
	
}		


// ****************** LINEN ITEM LOOKUP ***************************************************************

	function linenItemDescLookup()
		{
			var linenItemDesc = document.getElementById("linenItemDesc").value;
			if(linenItemDesc != '')
				linenItemLookup();
	}

// ****************** COMPAIRE DATES FROM DATE SHOULD BE LESS THAN TO DATE ****************************
	
	function compDates(){
		var loanedFrom = document.getElementById("vo.criteriaItems[4].itemValue").value
		var loanedTo = document.getElementById("vo.criteriaItems[5].itemValue").value
		IBADateValidator.isDateGreaterThanJS(loanedFrom, loanedTo, 'en',callBackFunction);
			function callBackFunction(data){
				var error ="";
				var msgArray=new Array();
				if(data ==true)	{	
					getServerMessage("APP-LC00013");
					var message = dwrMessage;
					msgArray=message.split("#");
					getServerMessage("com.iba.ehis.lc.receiveloanedlinen.loanDateFrom");
					var loanedFrom = dwrMessage;
					getServerMessage("com.iba.ehis.lc.receiveloanedlinen.loanDateTo");
					var loanedTo = dwrMessage;
					error = error + msgArray[0] + loanedTo  + " " + msgArray[1] + " " + loanedFrom + "<br>";
					
					parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;

					document.getElementById("vo.criteriaItems[5].itemValue").value="";
					document.getElementById("vo.criteriaItems[5].itemValue").setFocus;
					
				}else{
					
					parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
				}
			}
		}

// ****************** TO SUBMIT FOR USING FUNCTION ID ie BASED ON LOANSTATUS **************************
		
	function submitQuery(){
		
		var request_status = document.getElementById("vo.criteriaItems[9].itemValue").value;
		var language_Id = document.getElementById("languageId").value;
		var flag = "";
		var error = "";
		flag = checkNullList();
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
						error = error + msgArray[0] + label +  " " + msgArray[1] + " "+dwrMessage + "<br>";
						parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
						document.getElementById("vo.criteriaItems[5].itemValue").value="";
						document.getElementById("vo.criteriaItems[5].itemValue").setFocus;
					} else {   
				if(request_status == 'OS'||request_status == 'L'){
			
		//		document.getElementById("vo.receiveLoanedLinenVO.loanStatus").value = 'OS';
				document.getElementById("vo.functionId").value = 'LOAN_LINEN';
				document.QueryCriteriaForm.submit();
			}
			else if(request_status == 'ALL'){
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
			


function submitQuery1(){
		
		var request_status = document.getElementById("vo.criteriaItems[9].itemValue").value;
		var flag = "";
		var error = "";
		flag = checkNullList();
		if(flag==true){

				if(request_status == 'OS'||request_status == 'L'){
			
		//		document.getElementById("vo.receiveLoanedLinenVO.loanStatus").value = 'OS';
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


// ****************** TO CHECK NULL VALUES FOR MANDATORY FIELDS ***************************************
	
	function checkNull() {

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

	// ****************** TO CHECK NULL VALUES FOR MANDATORY FIELDS ***************************************

	function checkNullList() {
	var sourceType=	document.QueryCriteriaForm["sourceType"].value;
	var sourceCode = document.QueryCriteriaForm["sourceCode"].value;
	var loanedDateFrom = document.QueryCriteriaForm["vo.criteriaItems[11].itemValue"].value;

	var flag;
	var error="";
	var fieldName = new Array(
		"com.iba.ehis.lc.standardStock.sourceType",
		"com.iba.ehis.lc.standardStock.source", 
		"com.iba.ehis.lc.receiveloanedlinen.loanDateFrom");
	var fields = new Array(sourceType,sourceCode,loanedDateFrom);
	var key_value=new Array();
	for(j=0;j<fieldName.length;j++){
		if(fields[j] =="")
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

// ****************** TO GET LOAN DATE FROM AND TO DATES **********************************************
	
	function LoanedDateFrom(){	
		
		var currDate = new Date();

		var date = currDate.getDate();
		var mon = currDate.getMonth();
		var hrNow = currDate.getHours();
		var mnNow = currDate.getMinutes();
		scNow = currDate.getSeconds();
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
		var toDate=document.getElementById("vo.criteriaItems[3].itemValue");
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
		fromDate.value = reqFromDate+" "+hrNow+":"+mnNow;;
		document.getElementById("vo.criteriaItems[4].itemValue").value = reqFromDate;
		document.getElementById("vo.criteriaItems[5].itemValue").value = reqToDate;

	}



// ****************** TO GET REASON FOR LOAN THROW DWR REQUEST ****************************************
	
	function getLoanCode(){
		var languageId=document.getElementById("languageId").value;
		ReceiveLoanedLinenList.getLoan(languageId,getLoanReason)
	}
	
	function getLoanReason(data){
		var defectReason=document.QueryCriteriaForm["vo.criteriaItems[8].itemValue"];
		for(prop in data){
			DWRUtil.removeAllOptions(defectReason);
			DWRUtil.addOptions(defectReason,data,prop);
			
		}
	}

	function setClearLinenDesc(){
	document.getElementById("vo.criteriaItems[10].itemValue").value="";
}

function setClearSourceDesc(){
	document.getElementById("vo.criteriaItems[3].itemValue").value="";
}
 
function reset()
{
	create();
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

//	======= END OF SCRIPT  ============

