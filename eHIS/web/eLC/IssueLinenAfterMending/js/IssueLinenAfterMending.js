
var viewId;

function tabClicked(evt) {
	var selectedTabPane = evt.getTabPane();
	viewId = selectedTabPane.id;
}
//===================== create=============
function create() {

var moduleId="LC";
var functionId="LC_RECV_REQ_AFTER_MENDING";
content.location.href = contextPath + "/eLC/IssueLinenAfterMending/jsp/IssueOfLinenAfterMendingFrames.jsp<HR>?vo.viewCode=requestsListFrame&method="+loadMethod+"&functionId="+functionId+"&moduleId="+moduleId;
}
//===============================
function reset()
{
var moduleId="LC";
var functionId="LC_RECV_REQ_AFTER_MENDING";
content.location.href = contextPath + "/eLC/IssueLinenAfterMending/jsp/IssueOfLinenAfterMendingFrames.jsp<HR>?vo.viewCode=requestsListFrame&method="+loadMethod+"&functionId="+functionId+"&moduleId="+moduleId;
}

function checkNull1() {
	var flag;
 	var error="";
 //	var fieldName =new Array("com.iba.ehis.lc.requestForLinen.requestNum","com.iba.ehis.lc.requestForLinen.requestDate");
//	var fields =new Array(document.QueryCriteriaForm["vo.criteriaItems[0].itemValue"],document.QueryCriteriaForm["vo.criteriaItems[1].itemValue"]);
	var fieldName =new Array("com.iba.ehis.lc.requestForLinen.requestDate");
	var fields =new Array(document.QueryCriteriaForm["vo.criteriaItems[1].itemValue"]);
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
		var toDate=document.getElementById("vo.criteriaItems[2].itemValue");
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
		var fromDate=document.getElementById("vo.criteriaItems[1].itemValue");
		fromDate.value = reqFromDate+" "+hrNow+":"+mnNow;;
	}

	
//=========================================
	function fromDateCheck(dateVal){
		if(dateVal !=""){
			IBADateValidator.isCurrentDateGreaterThanJS(dateVal,'en',callBackFunction);
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
					document.getElementById("vo.criteriaItems[1].itemValue").value="";
					document.getElementById("vo.criteriaItems[1].itemValue").setFocus;
				}else parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
			}
		}
	}
	
	function setFocusFromDate(){
			document.getElementById("vo.criteriaItems[1].itemValue").setFocus;
	}
//===================================
function showAgencyLookup(){
	var agencyDesc = document.getElementById("agencyDesc").value;
	if(agencyDesc != '')
		showLookup2();
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
	//namesArray[1]=sourceCode;

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

   	     	
 function checkNumber(val){
		  obj =  String.fromCharCode(window.event.keyCode);
		var alphaFilter =/^[0-9]+$/;
		if (!(alphaFilter.test(obj))) {
		getServerMessage("message.Numbers.Allowed");
		parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
		window.event.keyCode = 27;
		val.value="";
		}
			 
	}	 	