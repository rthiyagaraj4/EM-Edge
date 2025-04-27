
var viewId;

function tabClicked(evt) {
	var selectedTabPane = evt.getTabPane();
	viewId = selectedTabPane.id;
}

function Delivery() {
content.location.href = contextPath + "/eLC/DeliverCleanedLinen/jsp/DeliverCleanedLinenFrames.jsp?method="+loadMethod;
}
function create() {
content.location.href = contextPath + "/eLC/DeliverCleanedLinen/jsp/DeliverCleanedLinenFrames.jsp?method="+loadMethod;
}
function reset()
{
content.location.href = contextPath + "/eLC/DeliverCleanedLinen/jsp/DeliverCleanedLinenFrames.jsp?method="+loadMethod;
}

function checkNull1() {
	var flag;
 	var error="";
 	var fieldName = "com.iba.ehis.lc.requestForLinen.requestDate";
	var fields = document.QueryCriteriaForm["vo.criteriaItems[2].itemValue"];
	var key_value;
 	if(fields.value==""){	
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
function checkNullLocal()
	 { 
		var flag;
		var error="";
		var key_value=new Array();
		var fieldName=new Array("com.iba.ehis.lc.requestForLinen.requestNum","com.iba.ehis.lc.requestForLinen.requestDate","com.iba.ehis.lc.standardStock.sourceType","com.iba.ehis.lc.standardStock.source","com.iba.ehis.lc.requestForCleaningLinen.linenHandedOverBy","com.iba.ehis.lc.requestForCleaningLinen.linenCollectedBy","com.iba.ehis.lc.deliverCleanedLinen.deliveryDate");
		var field=new Array(document.getElementById("vo.deliverCleanedLinenVO.requestNum"),document.getElementById("vo.deliverCleanedLinenVO.requestDate"),document.getElementById("vo.deliverCleanedLinenVO.sourceType"),document.getElementById("vo.deliverCleanedLinenVO.sourceCode"),document.getElementById("vo.deliverCleanedLinenVO.linenHandedOverBy"),document.getElementById("vo.deliverCleanedLinenVO.linenCollectedBy"),document.getElementById("vo.deliverCleanedLinenVO.deliveryDate"));
		for (j = 0; j <fieldName.length; j++) 
	 	{
			if(field[j].value=="")
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
		parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		if(flag==false) return false; else return true;
	 }
	 
//===================================================== 

function showLookup1() {
	var sourceType=document.getElementById("vo.deliverCleanedLinenVO.sourceType").value;
	var sourceCode=document.getElementById("vo.deliverCleanedLinenVO.sourceCode").value;
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	
	argArray[0] = "ehis.lc.requestForLinen.getlinen"
	
	namesArray[0]="sourceType";
	namesArray[1]="sourceCode";
	namesArray[2]="languageId";
	
	valuesArray[0] = sourceType;
	valuesArray[1] = sourceCode;
	valuesArray[2] = "<%=locale%>";

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
	//Display Order
	argArray[3] = DESC_CODE;

	// Link Description
	argArray[4] = DESC_LINK;
	
	argArray[5] =document.getElementById("vo.criteriaItems[6].itemValue").value;
	
	getServerMessage("com.iba.ehis.lc.linenitemcode");
	retArr = Lookup(dwrMessage, argArray);
	
	if(retArr!=null)
			{
			//Set the data in to the fields
			var linenTxt=document.getElementById("linenItem");
			var linenTxt1=document.getElementById("linenItemDesc");
			
			linenTxt.value = retArr[0];
			linenTxt1.value = retArr[0];
			}
	
}		
function showLookup() {
	var sourceType=document.getElementById("vo.sourceType").value;
	var facilityId=document.getElementById("vo.operatingFacilityId").value;
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	
	if(sourceType=="W")
		{	argArray[0] = "ehis.lc.standardStock.nursingUnit"
		    namesArray[0]=facilityId;
		}
		else if(sourceType=="C")
		{	argArray[0] = "ehis.lc.standardStock.clinic"
		}
		else if(sourceType=="D")
		{	argArray[0] = "ehis.lc.standardStock.deptCode"
		}
		else 	argArray[0] = "ehis.lc.standardStock.nursingUnit"

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] =document.getElementById("vo.sourceCode").value;
	retArr = Lookup("SourceCode", argArray);
	var txtUser = document.getElementById("vo.sourceCode");
	var txtUser1 = document.getElementById("source");
	
	if(retArr!=null)
			{
			//Set the data in to the fields
			txtUser.value = retArr[0];
			txtUser1.value = retArr[1];
			}
	
}
 
function CurrDate(){	
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
		var convert1= date + "/" + mon + "/" + year;
			convert1=convert1+" "+hrNow+":"+mnNow;
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
			reqFromDate=reqFromDate+" "+hrNow+":"+mnNow;
		
		var rdate=document.getElementById("vo.criteriaItems[2].itemValue");
		rdate.value=reqFromDate;
		var rdate1=document.getElementById("vo.criteriaItems[3].itemValue");
		rdate1.value=convert1;
	}
//============================================================
function fromDateCheck(dateVal){
		if(dateVal !=""){
			document.getElementById("vo.criteriaItems[2].itemValue").setFocus;
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
					parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
					document.getElementById("vo.criteriaItems[2].itemValue").value="";
					document.getElementById("vo.criteriaItems[2].itemValue").setFocus;
				}else parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
			}
		}
		else
			dateVal="";

	}
	function toDateCheck(dateVal){
		if(dateVal !=""){
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
					parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
					document.getElementById("vo.criteriaItems[3].itemValue").value="";
					document.getElementById("vo.criteriaItems[3].itemValue").setFocus;
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
   	function getLoginUser(){
		
		var userId =document.QueryCriteriaForm["user"].value;
		RequestForCleaning.getLoggedInUser("en",userId,callLoggedInUser);
}
function callLoggedInUser(data){
		for(prop in data){
			document.getElementById("vo.criteriaItems[4].itemValue").value = prop;
		}
}   
function textAreaLimit(field, maxlen) {
	var textVal="";
if (field.value.length > maxlen+1)
	{
		textVal=field.value.substring(0, maxlen);
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