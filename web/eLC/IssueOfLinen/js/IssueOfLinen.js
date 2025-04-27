
var viewId;

function tabClicked(evt) {
	var selectedTabPane = evt.getTabPane();
	viewId = selectedTabPane.id;
}
//===================== create=============
function create() {

content.location.href = contextPath + "/eLC/IssueOfLinen/jsp/IssueOfLinenFrames.jsp?vo.viewCode=requestsListFrame&method="+loadMethod;

}
//===============================
function reset()
{
content.location.href = contextPath + "/eLC/IssueOfLinen/jsp/IssueOfLinenFrames.jsp?vo.viewCode=requestsListFrame&method="+loadMethod;
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
 	
	parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
	if(flag==false) return false; else return true;
}

//===================================================== 
function CurrDate(){	
		var currDate = new Date();
		var date = currDate.getDate();
		var mon = currDate.getMonth();
		mon = mon+1;
		var year = currDate.getYear();
		if(date <10)
			date = "0"+date;
		if(mon <10)
			mon = "0"+mon;
		var convert1= date + "/" + mon + "/" + year;
		var rdate=document.getElementById("vo.issueOfLinenVO.requestDate");
		rdate.value=convert1;
		}
//======================================================

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
		var language_Id=document.getElementById("languageId").value;
		
		IBADateValidator.convertDateJS(reqToDate, "en", language_Id, "dd/MM/yyyy", getConDateTo) 
		function getConDateTo(thaidate){
			
		reqToDate=thaidate+" "+hrNow+":"+mnNow;
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
		
		IBADateValidator.convertDateJS(reqFromDate, "en", language_Id, "dd/MM/yyyy", getConDateFrom)
		function getConDateFrom(conFromDate1){
				
		var fromDate=document.getElementById("vo.criteriaItems[2].itemValue");
		fromDate.value = conFromDate1+" "+hrNow+":"+mnNow;
		}
	}
}
	function checkMaxMealPlan(){
		var facilityId=content.document.generateMealPlanFrame.document.getElementById("facilityId").value;
		content.document.generateMealPlanFrame.MaxMealPlan.getMaxMealPlan(facilityId,callMealPlan);
		function callMealPlan(data){
			var dateArray = new Array();
			var currentDate=new Date();
			for(prop in data){
				var servingDate=content.document.generateMealPlanFrame.document.getElementById("vo.mealPlanVo.servingDate").value;
				dateArray=servingDate.split("/");
				var newDate = new Date(dateArray[2],dateArray[1] - 1,dateArray[0]);
				var no_Of_Days =Math.ceil((newDate - currentDate)/(1000 * 60 * 60 * 24));
				if(no_Of_Days > prop){
					getServerMessage("APP-LC00017");
					alert(dwrMessage);
					content.document.generateMealPlanFrame.document.getElementById("vo.mealPlanVo.servingDate").value="";
					content.document.generateMealPlanFrame.document.getElementById("vo.mealPlanVo.servingDate").setFocus;			
				}
				else
					content.generateMealPlanFrame.document.GenerateMealPlanForm.submit();
			}
		}
	}
//=========================================
	function fromDateCheck(dateVal){
		if(dateVal !=""){
			var language_Id=document.getElementById("languageId").value;
			IBADateValidator.isCurrentDateGreaterThanJS(dateVal,language_Id,callBackFunction);
			function callBackFunction(data){
				var error ="";
				var msgArray=new Array();
				if(data ==true)	{				
					getServerMessage("DATE_GREATER_CURRENT_DATE");
					var message = dwrMessage;
					msgArray=message.split("#");
					getServerMessage("com.iba.ehis.lc.requestForLinen.requestDate");
					error = error + msgArray[0] + dwrMessage  + " " + msgArray[1] + "<br>";
					parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
					document.getElementById("vo.criteriaItems[2].itemValue").value="";
					document.getElementById("vo.criteriaItems[2].itemValue").setFocus;
				}else parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
			}
		}
	}
	
	function setFocusFromDate(){
			document.getElementById("vo.criteriaItems[2].itemValue").setFocus;
	}
//===================================
function checkNumber(obj) {
	var val=obj.value;
    if ( trimCheck(val) && isNaN(val) == false && val >=0){
        return true;
    }else{
        if ( val.length > 0 ) {
            getServerMessage("message.Numbers.Allowed");
			obj.value="";
			parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
			window.event.keyCode = 27;
			return false;
		    }
		}
	}
/* ============================== RequestListCUD ================================*/

function sourceCodeLookup(){
	var sourceCodeDesc = document.QueryCriteriaForm["source"].value;
	var sourceType = document.QueryCriteriaForm["vo.criteriaItems[0].itemValue"].value;
	if(sourceCodeDesc != "" && sourceType != "")
	showLookup()
}

function showLookup() {
	var sourceType=document.QueryCriteriaForm["vo.criteriaItems[0].itemValue"].value;
	if(sourceType != ""){
		var facilityId=document.QueryCriteriaForm["vo.operatingFacilityId"].value;
		var locale=document.getElementById("languageId").value;

		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		
		namesArray[0]="languageId";
		valuesArray[0]=locale;

		if(sourceType=="W"){
			argArray[0] = "ehis.lc.standardStock.nursingUnit"
			namesArray[1]="facilityId";
			valuesArray[1]=facilityId;
		}
		else if(sourceType=="C")
			argArray[0] = "ehis.lc.standardStock.clinic"
		else if(sourceType=="D")
			argArray[0] = "ehis.lc.standardStock.deptCode"
		
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
							
				//Display Order
		argArray[3] = DESC_CODE;

				// Link Description
		argArray[4] = DESC_LINK;
		argArray[5] = document.QueryCriteriaForm["source"].value;
		getServerMessage("com.iba.ehis.lc.sourceCode");
		retArr = Lookup(dwrMessage, argArray);
		var sourceCode = document.QueryCriteriaForm["vo.criteriaItems[1].itemValue"];
		var sourceCodeDesc = document.QueryCriteriaForm["source"];
		if(retArr!=null){
			//Set the data in to the fields
			sourceCode.value = retArr[0];
			sourceCodeDesc.value = retArr[1];
		}
	}else if(sourceType == "" || sourceType == null){
		getServerMessage("com.iba.ehis.lc.standardStock.sourceType");
		var label = dwrMessage;
		getServerMessage("message.cannot.blank");
		msg=dwrMessage;
	 	msgArray=msg.split('#');
		error=msgArray[0]+" "+ label + " " + msgArray[1] ;
		parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
	
	}
}

function linenItemLookup(){
	var linenItemDesc = document.QueryCriteriaForm("linenItemDesc").value;
	if(linenItemDesc != "")
	showLookup1()
}

function showLookup1() {

	var locale=document.getElementById("languageId").value;

	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	
	namesArray[0]="languageId";
	valuesArray[0]=locale;

	argArray[0] = "ehis.lc.standardStock.linenItem"

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
		
	//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] =document.QueryCriteriaForm("linenItemDesc").value;
	getServerMessage("com.iba.ehis.lc.linenItemCode");
	retArr = Lookup(dwrMessage, argArray);
	var linenItem = document.QueryCriteriaForm("vo.criteriaItems[6].itemValue");
	var linenItemDesc = document.QueryCriteriaForm("linenItemDesc");
	if(retArr!=null){
		//Set the data in to the fields
		linenItem.value = retArr[0];
		linenItemDesc.value = retArr[1];
		}
	}

	function checkAlphaNum(){
		obj =  String.fromCharCode(window.event.keyCode);
	   	var alphaFilter =/^[a-z_A-Z_0-9]+$/;
	   	if (!(alphaFilter.test(obj))) { 
	   		getServerMessage("messages.AlphaNumeric");
	   		parent.window.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
	   		window.event.keyCode = 27;
   			}
   	   }
	   
	function checkNumber(){
	 	obj =  String.fromCharCode(window.event.keyCode);
		var alphaFilter =/^[0-9]+$/;
		if (!(alphaFilter.test(obj))) { 
	   	getServerMessage("message.Numbers.Allowed");
		parent.window.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
	   	window.event.keyCode = 27;
   		}
   	}

	function getLoginUserPlaceLinen(){
		var locale=document.getElementById("languageId").value;
		var loggedInUser=document.getElementById("loggedInUser").value;
		RequestForCleaning.getLoggedInUser(locale,loggedInUser,callLoggedInUserPlaceLinen);
	}

	function callLoggedInUserPlaceLinen(data){
		for(prop in data){
			document.getElementById("raisedBy").value = prop;
			document.getElementById("vo.criteriaItems[4].itemValue").value = data[prop];
		}
	}
//=====================================================================================
function setloginUser()
{
	var obj=document.getElementById("raisedBy");
	if(obj.value==""||obj.value==null){
	document.getElementById("vo.criteriaItems[4].itemValue").value ="";
	}
	else
	{
		var locale=document.getElementById("languageId").value;
		//var loggedInUser=document.getElementById("loggedInUser").value;
		RequestForCleaning.getLoggedInUser(locale,obj.value,callLoggedInUser);
	}
}
function callLoggedInUser(rec){
		for(prop in rec){
			document.getElementById("raisedBy").value = prop;
			document.getElementById("vo.criteriaItems[4].itemValue").value = rec[prop];
			
		}
		if(document.getElementById("vo.criteriaItems[4].itemValue").value =="")
			{
			document.getElementById("vo.criteriaItems[4].itemValue").value =document.getElementById("raisedBy").value;
			}
	}

//======================================================================================


//=======================================================================================
	function submitQuery(){
	
	/*	var linenItemDesc = document.QueryCriteriaForm("linenItemDesc");
		if(linenItemDesc.value==""){
			document.QueryCriteriaForm("vo.criteriaItems[6].itemValue").value="";
		} */
		var request_status = document.getElementById("vo.criteriaItems[5].itemValue").value;
		var flag=checkNull1();
		if(flag==true){
			var fromDate = document.getElementById("vo.criteriaItems[2].itemValue").value;
			var toDate = document.getElementById("vo.criteriaItems[3].itemValue").value;
			if(toDate !=""){
				var locale=document.getElementById("languageId").value;
				IBADateValidator.isDateGreaterThanJS(fromDate,toDate,locale,callBackFunction);
				function callBackFunction(data){
					var error ="";
					var msgArray=new Array();
					if(data ==true)	{				
						getServerMessage("APP-LC00013");
						var message = dwrMessage;
						msgArray=message.split("#");
						getServerMessage("com.iba.ehis.lc.requestForLinen.requestDate");
						error = error + msgArray[0] + "To Date" +  " " + msgArray[1] +" "+ dwrMessage + "<br>";
						parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
						document.getElementById("vo.criteriaItems[3].itemValue").value="";
						document.getElementById("vo.criteriaItems[3].itemValue").setFocus;
					} else	{
					if(request_status == 'OS+PI'){
						document.getElementById("vo.functionId").value = 'REQ_FOR_LINEN';
						document.QueryCriteriaForm.submit();
					}else	 if(request_status == 'ALL'){
						document.getElementById("vo.functionId").value = 'ALL_REQ_FOR_LINEN';
						document.QueryCriteriaForm.submit();
					}else {
							document.getElementById("vo.functionId").value = 'LC_REQ_FOR_LINEN';
							document.QueryCriteriaForm.submit();
						 }
					}
				}
			}
		}
	}


//===========================================

