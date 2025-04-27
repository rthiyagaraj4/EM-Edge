var viewId;
 var dirtyFlag=""
 var userFlag=""
 var loggedInUser=""
 var facilityId=""
 var cutoffTime=new Date();



function tabClicked(evt) {
	var selectedTabPane = evt.getTabPane();
	viewId = selectedTabPane.id;
	//alert(viewId)
}

function cleaning(arg1,arg2) {
	loggedInUser=arg1;
	facilityId=arg2;
	//alert(facilityId);

//	alert(loggedInUser+"=="+facilityId)
	RequestForCleaning.getDirtyLinenParam(facilityId,getDirty);
	checkUser();
}
function getDirty(rec)
{
var dt=new Date();
	facilityId="<%=facilityId%>";
  for(prop in rec)
	{
	  if(prop!=null){
	dirtyFlag=prop;
	dt=rec[prop]
	}}
	cutoffTime=dt;
	
		RequestForCleaning.getOverRideWardConf(facilityId,getconf); 
		//	RequestForCleaning.getOverRideWardConf(getconf); 
		
}

function checkUser()
{
	
	RequestForCleaning.getLcUser(facilityId,loggedInUser,getUser);
	
}

function getUser(data)
{
   for(prop in data)
	   {
		if(prop!=null){
		if(prop==loggedInUser)
		   userFlag="Y";
			else
		    userFlag="N";

			}
		}
		if(userFlag==null||userFlag=="")
			userFlag="N";
	
 }


   function getconf(data)
   {
	   var conf="";
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
			convert1=convert1+" "+hrNow+ ":" +mnNow;
	   for(prop in data)
	   {
		   if(prop!=null){
		  conf=prop;
		  delDate=data[prop]	
		   }
	   }

		if(conf=='Y')
			content.location.href = contextPath + "/eLC/RequestForCleaningLinen/jsp/RequestForCleaningLinenMainFrames.jsp?flag=Y&dirtyFlag="+dirtyFlag+"&cutoffTime="+cutoffTime+"&delParamDate="+delDate+"&userFlag="+userFlag;			
		else
			content.location.href = contextPath + "/eLC/RequestForCleaningLinen/jsp/RequestForCleaningLinenMainFrames.jsp?flag=N&dirtyFlag="+dirtyFlag+"&cutoffTime="+cutoffTime+"&delParamDate="+delDate+"&userFlag="+userFlag;			
	  

   }
 
//====================================
function apply() {
	//if (viewId == "placeCleaningLinenRequestTab") {
			
			document.RequestForCleaningLinenForm.submit();
			
		
	//} 
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

//===============
function defaultSource(arg)
{
	var sourceType="";
	//var val=document.getElementById("vo.placeCleaningLinenRequestVO.sourceType").value;
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
//==================
function linenItemLookup(){
	var linenItemDesc = document.getElementById("linenItem1").value;
	if(linenItemDesc != '')
		showLookup1();
}
//=================
function checkLength(){
	 obj =  String.fromCharCode(window.event.keyCode);
	 var length = document.getElementById("vo.longDesc").value;
	 if(length.length>=200){
		window.event.keyCode = 27;
		}
	}
//============================
function checkNull() {
	var flag;
 	var error="";
 	var fieldName = new Array("com.iba.ehis.lc.requestForLinen.requestNum", "com.iba.ehis.lc.requestForLinen.requestDate", "com.iba.ehis.lc.standardStock.sourceType","com.iba.ehis.lc.standardStock.source","com.iba.ehis.lc.requestForCleaningLinen.linenHandedOverBy","com.iba.ehis.lc.requestForCleaningLinen.linenCollectedBy");
	var fields = new Array(document.RequestForCleaningLinenForm["vo.placeCleaningLinenRequestVO.requestNum"].value,document.RequestForCleaningLinenForm["vo.placeCleaningLinenRequestVO.requestDate"].value,document.RequestForCleaningLinenForm["sourceType"].value,document.RequestForCleaningLinenForm["sourceDesc"].value,document.RequestForCleaningLinenForm["vo.placeCleaningLinenRequestVO.linenHandedOverBy"].value,document.RequestForCleaningLinenForm["vo.placeCleaningLinenRequestVO.linenCollectedBy"].value);
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
//===================== default date=============================
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
		var convert1= date + "/" + mon + "/" + year;
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
			reqFromDate=reqFromDate+" "+hrNow+ ":" +mnNow;
		
		
		//if(arg=='P')
		//{
		//var rdate=document.getElementById("vo.placeCleaningLinenRequestVO.requestDate");
		//rdate.value=convert1;
		//}
		if(arg=='C')
		{
		document.getElementById("vo.criteriaItems[2].itemValue").value=reqFromDate;
		var rdate=document.getElementById("vo.criteriaItems[3].itemValue");
		rdate.value=convert1;
		}
		if(arg=='Y')
		{
		document.getElementById("vo.criteriaItems[2].itemValue").value=reqFromDate;
		var rdate=document.getElementById("vo.criteriaItems[3].itemValue");
		rdate.value=convert1;
		}
		if(arg=='V')
		{
			var rdate=document.getElementById("vo.placeCleaningLinenRequestVO.cancelledDate");
			rdate.value=convert1;
			
		}
	}

//===================== REQUEST NO ============================== 

function getRequestNumber(data)
{
var max=0;
for(prop in data) {
	// alert(prop)
	if(prop!=null){
	if(parseInt(prop)>parseInt(max))
			max=parseInt(prop);
	}
 }
// alert(max)
max=parseInt(max)+1;
document.getElementById("vo.placeCleaningLinenRequestVO.requestNum").value=max;
}
function settime()
{
 window.setTimeout(AlertMsg,1000);	
}
function AlertMsg()
{
	var obj=document.getElementById("vo.placeCleaningLinenRequestVO.requestNum");
	var tableObj = document.getElementById("contentTable");
	var len = tableObj.rows.length;
	var flag=checkNull();
	if(flag==true)
			{ 
	if(parseInt(len)>0){
	alert("Please note your Request Number : "+obj.value);
			
			apply();
		}else
		alert("Atleast select one Linen Item ")
	}
}
//==============Linen Item look up ===============

//===================== WARD/CLINIC/DEPT LOOK UP
function sourceDescLookup(){
	var sourceType=document.getElementById("vo.placeCleaningLinenRequestVO.sourceType").value;
	var sourceDesc = document.RequestForCleaningLinenForm["sourceCode"].value;
	if(sourceType != '' && sourceDesc != '')
		showLookup();
}





//========================================================
 function checkAlphaNum(){
	  	 obj =  String.fromCharCode(window.event.keyCode);
	   	var alphaFilter =/^[a-z_A-Z_0-9]+$/;
	   	if (!(alphaFilter.test(obj))) { 
	   		getServerMessage("messages.AlphaNumeric");
		parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
	   	window.event.keyCode = 27;
   		}
   	}  	
  	
//==================== TOP - BOTTOOM MULTIRECORD  FRAME ============================
function checkNullLocal() {
	var flag;
 	var error="";
 	var fieldName = new Array("com.iba.ehis.lc.linenItem", "com.iba.ehis.lc.requestForCleaningLinen.scheduleDeliveryDate");
	var fields = new Array(document.RequestForCleaningLinenForm["linenItem"].value,document.RequestForCleaningLinenForm["vo.placeCleaningLinenRequestVO.scheduleDeliveryDate"].value);
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
}

function LinenViewVo(linenItem,linenItem1,category,category1,qty,scheduleDate,remark,tsdate, flag) {
	this.linenItem = linenItem;
	this.linenItem1 = linenItem1;
	this.qty = qty;
	this.remark = remark;
	this.category=category;
	this.category1=category1;
	this.scheduleDate=scheduleDate;
	this.tsdate=tsdate;
	if (flag == null) {
		flag = "createMethod";
	}
	this.flag = flag;
}
function populateList() {
	var cat=document.RequestForCleaningLinenForm["category"].value;
	var flag=document.getElementById("vo.placeCleaningLinenRequestVO.flag").value;
	if(flag=='Y' && cat=='D')
		document.getElementById("vo.placeCleaningLinenRequestVO.countConfirmedYn").value='N';
	else
		document.getElementById("vo.placeCleaningLinenRequestVO.countConfirmedYn").value='Y';

	cancelRecord();
	if(checkNullLocal()){		
		var linenItem=document.RequestForCleaningLinenForm["linenItem"].value;
//		alert(linenItem)
		if(contentList.get(linenItem) ==null){
			var categoryObj=document.RequestForCleaningLinenForm["category"];
			var tsdate= document.RequestForCleaningLinenForm["scheduleDeliveryDate"].value;
			var sdate = document.RequestForCleaningLinenForm["vo.placeCleaningLinenRequestVO.scheduleDeliveryDate"].value;
			var	cat1=categoryObj.options(categoryObj.selectedIndex).text;
			viewObj = new LinenViewVo(linenItem,document.RequestForCleaningLinenForm["linenItem1"].value,document.RequestForCleaningLinenForm["category"].value,cat1,document.RequestForCleaningLinenForm["qty"].value,document.RequestForCleaningLinenForm["vo.placeCleaningLinenRequestVO.scheduleDeliveryDate"].value,document.RequestForCleaningLinenForm["remark"].value,tsdate)
			contentList.put(linenItem,viewObj)
		}else{
			var obj = contentList.get(linenItem)
			if(obj.flag != "createMethod"){
			obj.linenItem1=document.RequestForCleaningLinenForm["linenItem1"].value
			obj.category=document.RequestForCleaningLinenForm["category"].value
			obj.category1=cat1;
			obj.qty = document.RequestForCleaningLinenForm["qty"].value
			obj.remark = document.RequestForCleaningLinenForm["remark"].value
			obj.scheduleDate=document.RequestForCleaningLinenForm["vo.placeCleaningLinenRequestVO.scheduleDeliveryDate"].value
			obj.tsdate=document.RequestForCleaningLinenForm["scheduleDeliveryDate"].value
			obj.flag= updateMethod;
			contentList.put(linenItem,obj);
			}
		}
		showRecords();
		//document.RequestForCleaningLinenForm["category"].value=""
		document.RequestForCleaningLinenForm["linenItem"].value="";
		document.RequestForCleaningLinenForm["linenItem1"].value="";
		document.RequestForCleaningLinenForm["qty"].value="";
		document.RequestForCleaningLinenForm["vo.placeCleaningLinenRequestVO.scheduleDeliveryDate"].value=""
		document.RequestForCleaningLinenForm["remark"].value="";
	}

}
function deleteRows() {
	var tableObj = document.getElementById("contentTable");
	var len = tableObj.rows.length;
	for (i = len - 1; i != -1; i--) {
		tableObj.deleteRow(i);
	}
}
function showRecords() {
	var htmlContent = "";
	var tableObj = document.getElementById("contentTable");
	var anchorId=document.getElementById("prepAnchor");
	deleteRows();
	index = 0;
	var i=0;
	index = parseInt(index);
	for (  i in contentList.values()) {
		dataObj = contentList.values()[i];
		if (dataObj != null) {
			tableObj = document.getElementById("contentTable");
			if (dataObj.flag != "deleteMethod") {
				var row = tableObj.insertRow(tableObj.rows.length);
				var col1 = row.insertCell();
				col1.className = "QRYEVEN";
				col1.width="20%";
				col1.align="left";
				var str = "";
				str = "<a href=\"javascript:pickupContent('" + dataObj.linenItem + "')\">";
				str += dataObj.linenItem1 + "</a><input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + (index) + "].linenItem' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + (index) + "].linenItem' value='" + dataObj.linenItem + "'>";
				col1.innerHTML = str;
				var col2 = row.insertCell();
				col2.className = "QRYEVEN";
				col2.width="20%";
				col2.align="left";
				col2.innerHTML = dataObj.category1 + "<input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + (index) + "].category' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + (index) + "].category' value='" + dataObj.category + "'>";
				var col3 = row.insertCell();
				col3.className = "QRYEVEN";
				col3.width="20%";
				col3.align="right";
				col3.innerHTML = dataObj.qty + "<input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + (index) + "].requestedQty' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + (index) + "].requestedQty' value='" + dataObj.qty + "'>";
				var col4 = row.insertCell();
				col4.className = "QRYEVEN";
				col4.width="20%";
				col4.align="left";
				col4.innerHTML = dataObj.tsdate + "<input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + (index) + "].scheduleDeliveryDate' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + (index) + "].scheduleDeliveryDate' value='" + dataObj.scheduleDate + "'><input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + (index) + "].scheduleDeliveryDate.pattern' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + (index) + "].scheduleDeliveryDate.pattern' value='dd/MM/yyyy HH:mm'>";
				var rem=dataObj.remark;
				var col5 = row.insertCell();
				col5.className = "QRYEVEN";
				col5.width="20%";
				col5.align="left";
				str1='<a href="" id="prepAnchor'+index+'" name="prepAnchor'+index+'" onclick="test5popupactivate1(this.id,'+index+');return false;">';
				str1+="Remark</a><input type='hidden' size=20 name='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + (index) + "].remark' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + (index) + "].remark' value='" + dataObj.remark + "'>" ;
				col5.innerHTML =str1;
				
				
			} else {
				var str = "<input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + index + "].linenItem' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + index + "].linenItem' value='" + dataObj.linenItem + "'>" + "<input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + (index) + "].category' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + (index) + "].category' value='" + dataObj.category + "'>" + "<input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + (index) + "].requestedQty' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + (index) + "].requestedQty' value='" + dataObj.qty + "'>" + "<input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + (index) + "].scheduleDeliveryDate' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + (index) + "].scheduleDeliveryDate' value='" + dataObj.scheduleDate + "'>" + "<input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + (index) + "].remark' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest[" + (index) + "].remark' value='" + dataObj.remark + "'>";
				document.getElementById("listContentLayer").innerHTML += str;
			}
			index++;
		}
	}
}
function pickupContent(linenItem) {
	var dataObj = contentList.get(linenItem);
	document.RequestForCleaningLinenForm["linenItem"].value = linenItem;
	document.RequestForCleaningLinenForm["linenItem1"].value =dataObj.linenItem1;
	document.RequestForCleaningLinenForm["category"].value = dataObj.category;
	document.RequestForCleaningLinenForm["qty"].value = dataObj.qty;
	document.RequestForCleaningLinenForm["vo.placeCleaningLinenRequestVO.scheduleDeliveryDate"].value = dataObj.scheduleDate;
	document.RequestForCleaningLinenForm["remark"].value = dataObj.remark;
		//contentList.remove(linenItem)
		showRecords()
		
}
function cancelRecord(){
			var linenItem=document.RequestForCleaningLinenForm["linenItem"].value
		
			var obj = contentList.get(linenItem)
			if(obj !=null){
				if(obj.flag != "createMethod"){
					obj.flag=deleteMethod
					 contentList.put(linenItem,obj)
				}else{
					contentList.remove(linenItem)
				}
			}
				showRecords();
				
		}	
//========================================
function fromDateCheck(dateVal){
		if(dateVal !=""){
			var languageId=document.getElementById("languageId").value;
			IBADateValidator.isCurrentDateGreaterThanJS(dateVal,languageId,'en',callBackFunction);
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
					parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
					return true;
				}
			}
		}
		else
			dateVal="";
	}

function setClearLinenDesc(){
	document.getElementById("vo.criteriaItems[6].itemValue").value="";
}

function convertDateToEn()
{
   var languageId= document.getElementById("languageId").value;
  var tdate=document.getElementById("toRequestDate");
  IBADateValidator.convertDateJS(tdate.value,languageId,"en",'dd/MM/yyyy HH:mm',RDTocallbackMethod1);
  function  RDTocallbackMethod1(ldate){

	  document.getElementById("vo.criteriaItems[3].itemValue").value=ldate;
	
	} 
  
  var rdate=document.getElementById("requestDate");
  IBADateValidator.convertDateJS(rdate.value,languageId,"en",'dd/MM/yyyy HH:mm',RDTocallbackMethod);
  function  RDTocallbackMethod(tdate){
			  document.getElementById("vo.criteriaItems[2].itemValue").value=tdate;
} 

}

function reset()
{
cleaning();
}

function CurrDate1(){	
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
		
		//convert1=convert1+" "+hrNow+ ":" +mnNow;
	return convert1;

}
function addDay(day,delvTime)
{
	var cDate=new Date();	
	var cDate;
	var msecsInADay = 86400000;
	var temp1;
	if(day!="0")
		{
		var totalMsecs=parseInt(msecsInADay)*parseInt(day);
		cDate=new Date(cDate.getTime() + totalMsecs);
		var date = cDate.getDate();
		var mon = cDate.getMonth();
		mon = mon+1;
		var year = cDate.getYear();
		if(date <10)
			date = "0"+date;
		if(mon <10)
			mon = "0"+mon;
		var convert1= date + "/" + mon + "/" + year;
		temp1=convert1+" "+delvTime;
		}
		else
		{
		cDate=CurrDate();
		temp1=cDate+" "+delvTime;
		}	
	return temp1;
}
//	======= END OF SCRIPT  ============


function setObjValue()
{
	var len=document.getElementById("vo.dataObjectsSize").value;
//	alert(len)
	var tableObj = document.getElementById("contentTable1");
	var index = 0;
	for(var i=0;i<len;i++)
	{
		index = parseInt(index);
		var row = tableObj.insertRow(tableObj.rows.length);
		var col1 = row.insertCell();
		col1.innerHTML ="<input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].linenItem' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].linenItem' value='"+document.getElementById("linenItem"+i).value+"'>" ;
		
		var col2 = row.insertCell();
		col2.innerHTML ="<input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].confirm' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].confirm' value='"+document.getElementById("countConfirmedYn:"+i).value+"'>";
		
		var col3 = row.insertCell();
		col3.innerHTML ="<input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].countConfirmedBy' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].countConfirmedBy' value='"+document.getElementById("countConfirmedBy:"+i).value+"'>";

		//alert(document.getElementById("countConfirmedDate:"+i).value);
		var col4 = row.insertCell();
		col4.innerHTML ="<input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].countConfirmedDate' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].countConfirmedDate' value='"+document.getElementById("countConfirmedDate:"+i).value+"'><input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].countConfirmedDate.pattern' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].countConfirmedDate.pattern' value='"+document.getElementById("pattern").value+"'  >";
		
		var col5 = row.insertCell();
		col5.innerHTML ="<input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].requestedQty' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].requestedQty' value='"+document.getElementById("qty:"+i).value+"'  >";
		
		var col6 = row.insertCell();
		col6.innerHTML ="<input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].requestStatus' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].requestStatus' value='"+document.getElementById("requestStatus"+i).value+"'  >";
		
		var col7 = row.insertCell();
		col7.innerHTML = "<input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].requestNo' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].requestNo' value='" +document.getElementById("reqNo:"+i).value+ "' >";
		
		var col8 = row.insertCell();
		col8.innerHTML = "<input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].category' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].category' value='" +document.getElementById("category:"+i).value+ "' >";
		
		var col9 = row.insertCell();
		col9.innerHTML = "<input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].requestDate' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].requestDate' value='" +document.getElementById("requestDate:"+i).value+ "' ><input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].requestDate.pattern' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].requestDate.pattern' value='" +document.getElementById("pattern").value+ "' >";
		
		var col10 = row.insertCell();
		col10.innerHTML = "<input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].scheduleDeliveryDate' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].scheduleDeliveryDate' value='" +document.getElementById("requestDate:"+i).value+ "' ><input type='hidden' name='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].scheduleDeliveryDate.pattern' id='vo.placeCleaningLinenRequestVO.cleanLinenRequest["+i+"].scheduleDeliveryDate.pattern' value='" +document.getElementById("pattern").value+ "' >";
		
		index++;
		
	}
	

}

function setHiddenValue(obj)
{
	var name=obj.name;
	var nameArray=new Array();
	nameArray=name.split(":");
	if(nameArray[0]=='qty')
	{
		document.getElementById("vo.placeCleaningLinenRequestVO.cleanLinenRequest["+nameArray[1]+"].requestedQty").value=obj.value;
	}
	if(nameArray[0]=='countConfirmedBy')
	{
		document.getElementById("vo.placeCleaningLinenRequestVO.cleanLinenRequest["+nameArray[1]+"].countConfirmedBy").value=obj.value;
	}
	if(nameArray[0]=='countConfirmedDate')
	{
		document.getElementById("vo.placeCleaningLinenRequestVO.cleanLinenRequest["+nameArray[1]+"].countConfirmedDate").value=obj.value;
	}

}
function setConfirm(obj,index)
{
//alert(obj.checked+"=="+index)
if(obj.checked==true){ //alert(document.getElementById("vo.placeCleaningLinenRequestVO.cleanLinenRequest["+index+"].confirm"))
	document.getElementById("vo.placeCleaningLinenRequestVO.cleanLinenRequest["+index+"].confirm").value='Y';}
else{ document.getElementById("vo.placeCleaningLinenRequestVO.cleanLinenRequest["+index+"].confirm").value='N';}
}
function hideSubmit()
{
document.getElementById("contentTable1").style.visibility="hidden";
if(document.getElementById("vo.dataObjectsSize").value ==0)
	{
		document.getElementById("btn1").style.visibility="hidden";
	}
}

function checkDate1(){
			var fromDate =document.getElementById("scheduleDeliveryDate").value;
			if(fromDate !=""  ){
				IBADateValidator.isCurrentDateGreaterThanJS(fromDate,'en',callBackFunction1);
				function callBackFunction1(data)
					{
					if(data ==true)
					{									
						getServerMessage("APP-LC00013");
						var message_key = dwrMessage;
						var split_message = message_key.split("#")
						getServerMessage("com.iba.ehis.lc.requestForCleaningLinen.scheduleDeliveryDate");
						var legend_key2 = dwrMessage;
						error = split_message[0]+" "+legend_key2 + " " + split_message[1] + " Current Date<br>";
						document.getElementById("scheduleDeliveryDate").value="";
						document.getElementById("vo.placeCleaningLinenRequestVO.scheduleDeliveryDate").value="";
						parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
					}
					
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
	if(objval!="")
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


