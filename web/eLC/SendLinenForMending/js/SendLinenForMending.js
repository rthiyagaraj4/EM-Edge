var viewId;

function checkAlphaNum(){
	obj =  String.fromCharCode(window.event.keyCode);
	var alphaFilter =/^[a-z_A-Z_0-9]+$/;
	if (!(alphaFilter.test(obj))) { 
		getServerMessage("messages.AlphaNumeric");
		parent.window.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
		window.event.keyCode = 27;
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

function create() {
	var moduleId="LC";
	var functionId="LC_SEND_REQ_FOR_MENDING";
	content.location.href = contextPath + "/eLC/SendLinenForMending/jsp/SendLinenForMendingMainFrames.jsp?&functionId="+functionId+"&moduleId="+moduleId;
}

function apply() {
			document.SendLinenForMendingForm.submit();
		}
function settime(){
 window.setTimeout(AlertMsg,1000);	
}

function AlertMsg(){
	var obj=document.getElementById("vo.placeLinenRequestVO.requestNum");
	var tableObj = document.getElementById("contentTable");
	var len = tableObj.rows.length;
	var flag=checkNullLocal();
			if(flag==true){
				if(parseInt(len)>0){
				getServerMessage("com.iba.ehis.lc.pnyrequestNum");
				alert(dwrMessage+" "+":"+obj.value);
				apply();
				}
				else{
					getServerMessage("com.iba.ehis.lc.atleastselectthelinenitem");
					alert(dwrMessage)
					}
			}
	
	
	}

//========  remark validation==========

function textAreaLimit(field, maxlen) {
if (field.value.length > maxlen+1)
	{
		var textVal=field.value.substring(0, maxlen);
		field.value=textVal;
		getServerMessage("com.iba.ehis.ds.characters");
		var msg = dwrMessage;
		msg1 = msg.split(" ");
		alert('Should not be more than  '+maxlen+"characters");
	}
	return textVal;

}
//=========  date default===============
function CurrDate1(arg){	
		
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
			var rdate=document.getElementById("vo.criteriaItems[0].itemValue");
			var rdate1=document.getElementById("vo.criteriaItems[1].itemValue");
			rdate.value=reqFromDate1;
			rdate1.value=convert1;
		}
	}
function checkNullLocal() {
	var flag;
 	var error="";
 	var fieldName = new Array("com.iba.ehis.lc.requestForLinen.requestNum", "com.iba.ehis.lc.requestForLinen.requestDate", "com.iba.ehis.lc.agencyCode.agencyCode");
	var fields = new Array(document.SendLinenForMendingForm["vo.placeLinenRequestVO.requestNum"],document.SendLinenForMendingForm["vo.placeLinenRequestVO.requestDate"] ,document.SendLinenForMendingForm["vo.placeLinenRequestVO.agencyCode"]);
	var key_value=new Array();
 	for(j=0;j<fieldName.length;j++){
 		if(fields[j].value==""){	
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
	var fields = document.QueryCriteriaForm["vo.criteriaItems[0].itemValue"];
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
//==================================================== 
function getRequestNumber1(data){
	var obj=document.getElementById("vo.placeLinenRequestVO.requestNum");
	var max=0;
	var temp=0;
	var i = 0;
	var popArray = new Array();
		for(prop in data){
			if(prop!=null){
				popArray[i] = prop;
				i++;
			}
		}
		for (var j=0; j <popArray.length;j++ ){
			if(parseInt(popArray[j])>parseInt(max))	
				max=parseInt(popArray[j]);
			}
		obj.value=parseInt(max)+1;
	}


//========================================
function check() {
	var flag;
 	var error="";
 	var fieldName = new Array("com.iba.ehis.lc.linenItem","com.iba.ehis.lc.requestForLinen.requestedQuantity");
	var fields = new Array(document.SendLinenForMendingForm["linenItem"],document.SendLinenForMendingForm["qty"]);
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
//========================================


//=====================================================
function fromDateCheck(dateVal){
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
				
					parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;

					document.QueryCriteriaForm["vo.criteriaItems[0].itemValue"].value="";
					document.QueryCriteriaForm["vo.criteriaItems[0].itemValue"].setFocus;
					
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
					document.QueryCriteriaForm["vo.criteriaItems[1].itemValue"].value="";
					document.QueryCriteriaForm["vo.criteriaItems[1].itemValue"].setFocus;
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
function linenItemLookup(){
	var linenItemDesc = document.getElementById("linenItemDesc").value;
	if(linenItemDesc != '')
		showLookup1();
}

function showLookup1() {
	var languageId=document.getElementById("languageId").value;
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	
	argArray[0] = "ehis.lc.lodgeComplaint.getlaundryLinen"
	
	namesArray[0]="languageId";
	valuesArray[0]=languageId;

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] = document.getElementById("linenItemDesc").value;
	getServerMessage("com.iba.ehis.lc.linenitemcode");
	retArr = Lookup(dwrMessage, argArray);
	
	if(retArr!=null){
		//Set the data in to the fields
		var linenItemCode=document.getElementById("linenItem");
		var linenItemDesc = document.getElementById("linenItemDesc");
		linenItemCode.value = retArr[0];
		linenItemDesc.value = retArr[1];
	}
}		
function showAgencyLookup(){
	var agencyDesc = document.getElementById("agencyDesc").value;
	if(agencyDesc != '')
		showLookup2();
}
function showAgencyLookup1(){
	var agencyDesc = document.getElementById("agencyDesc").value;
	if(agencyDesc != '')
		showLookup3();
}


function showLookup2() {
	var facilityId=document.getElementById("vo.operatingFacilityId").value;
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array(facilityId,document.getElementById("languageId").value);
	var datatypesArray = new Array();
	
	argArray[0] = "ehis.lc.agencyCode.getAgencyCode"
	namesArray[0]="facilityId";
	namesArray[1]="languageId";

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] = document.getElementById("agencyDesc").value;
	retArr = Lookup("Agency Code", argArray);
	
	if(retArr!=null){
		//Set the data in to the fields
		var linenItemCode=document.getElementById("vo.placeLinenRequestVO.agencyCode");
		var linenItemDesc = document.getElementById("agencyDesc");
		linenItemCode.value = retArr[0];
		linenItemDesc.value = retArr[1];
	}
}		
function showLookup3() {
	var facilityId=document.getElementById("vo.operatingFacilityId").value;
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array(facilityId,document.getElementById("languageId").value);
	var datatypesArray = new Array();
	
	argArray[0] = "ehis.lc.agencyCode.getAgencyCode"
	namesArray[0]="facilityId";
	namesArray[1]="languageId";

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] = document.getElementById("agencyDesc").value;
	getServerMessage("com.iba.ehis.lc.agencyCode.agencyCode");
	retArr = Lookup(dwrMessage, argArray);
	
	if(retArr!=null){
		//Set the data in to the fields
		var linenItemCode=document.getElementById("agencyDesc");
		var linenItemDesc = document.getElementById("vo.criteriaItems[2].itemValue");
		linenItemCode.value = retArr[1];
		linenItemDesc.value = retArr[0];
	}
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

