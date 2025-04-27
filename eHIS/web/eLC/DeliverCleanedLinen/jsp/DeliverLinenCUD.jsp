<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.framework.core.util.Constants"%>
<%@ page  import="com.iba.ehis.core.vo.AppVO"%>
<%@ include file="/framework/html/Tag.text"%>
<ibaHTML:html locale="true">
<head>
	<%
	String facilityId=(String)session.getAttribute("facility_id");
	String functionId = (String) session.getAttribute("functionId");
	String moduleId = (String) session.getAttribute("moduleId");
	String addedById = (String) session.getAttribute("login_user");
	String locale = (String) session.getAttribute("LOCALE");
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";

	%>
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>	<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/DeliverLinen.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenIssue.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/MendingRequest.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/DeliverCleanedLinen/js/DeliverCleanedLinen.js'></script>

<script type="text/javascript">
//===============remark poup====================
var contentList =new Hashtable();
 var cutoffTime=new Date();
var  testpopup5="";
var testpopup4="";
var val="";

function deliveryDate()
{
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
	document.getElementById("vo.deliverCleanedLinenVO.deliveryDate").value=convert1;
}
function setval()
{
val=document.getElementById("remarkArea").value;
document.getElementById("remark").value=val;
}
function test5popupactivate(anchor) {
if(testpopup5=="")
{
 testpopup5 = new PopupWindow();
}
val=document.getElementById("remark").value;
document.getElementById("remarkArea").value=val;

getServerMessage("com.iba.ehis.lc.remark")
var title=dwrMessage;
var title1=title+":"
var title2=title+"..."

testpopup5.height=200;
testpopup5.width=300;
testpopup5.offsetX=-10;
testpopup5.offsetY=10;
testpopup5.autoHide();
getServerMessage("com.iba.ehis.lc.ok");
var buttonLabel = dwrMessage;
testpopup5.populate('<title>'+title2+'</title><link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>"></link><FORM><table border="0" celpadding="0" cellspacing="0" width="100%" height="100%"><tr><td class="label" align="left">'+title1+'</td></tr><tr><td  align="center"><textarea rows=8 cols=40 maxlength=2000 name="remarkArea" onkeyup="window.opener.document.getElementById("remarkArea").value=this.value;window.opener.setval()">'+val+'</textarea></td></tr><tr><td  align="center"><input class="button" type="button" onclick="window.close();window.opener.setval()" value="'+buttonLabel+'"/></td></tr></table> </FORM>');
testpopup5.showPopup(anchor);
setval();
}

function test5popupactivate1(anchor,index) {
var val=document.getElementById("vo.deliverCleanedLinenVO.linenDeliverList["+index+"].remark").value;
testpopup4 = new PopupWindow();
testpopup4.windowProperties="toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no";

getServerMessage("com.iba.ehis.lc.remark")
var title=dwrMessage;
var title1=title+":"
var title2=title+"..."

testpopup4.height=200;
testpopup4.width=300;
testpopup4.offsetX=-10;
testpopup4.offsetY=10;
testpopup4.autoHide();
getServerMessage("com.iba.ehis.lc.ok");
var buttonLabel = dwrMessage;
testpopup4.populate('<title>'+title2+'</title><link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>"></link><FORM><table border="0" celpadding="0" cellspacing="0" width="100%" height="100%"><tr><td class="label" align="left">'+title1+'</td></tr><tr><td  align="center"><textarea rows=8 cols=40 readonly=true name="remarkArea">'+val+'</textarea></td></tr><tr><td  align="center"><input class="button" type="button" onclick="window.close();" value="'+buttonLabel+'"/></td></tr></table> </FORM>');
testpopup4.showPopup(anchor);
}
//==============deliveryRefNo=======
function getDeliveryrefNo(){

var facilityId=document.getElementById("vo.deliverCleanedLinenVO.operatingFacilityId").value;
var requestNo=document.getElementById("vo.deliverCleanedLinenVO.requestNum").value;
DeliverLinen.getDeliveryNo(facilityId,requestNo,setDeliveryNo);
}
function setDeliveryNo(data){
	
var max=0;
 for(prop in data) {
	if(prop!=null){
	if(parseInt(prop)>parseInt(max))
			max=parseInt(prop);
	}
 }
max=parseInt(max)+1;
document.getElementById("vo.deliverCleanedLinenVO.deliveryRefNum").value=max;
}
function settime()
{
 window.setTimeout(AlertMsg,1000);	
}
function AlertMsg()
{
	
	var obj=document.getElementById("vo.deliverCleanedLinenVO.deliveryRefNum");
	var tableObj = document.getElementById("contentTable");
	var len = tableObj.rows.length;
if(checkNullLocal())
{
	if(parseInt(len)>0){
		getServerMessage("com.iba.ehis.lc.pleasenoteyourReferenceNumber");
	alert(dwrMessage+" : "+obj.value);
	apply();
	}else{
		getServerMessage("com.iba.ehis.lc.atleastselectthelinenitem");
		alert(dwrMessage)
	}
}}
//==================================
function testReason()
{	
	var reasonObj=document.getElementById("ldelreason");
	if(reasonObj.disabled==false)
	{
		if(document.getElementById("ldelreason").value=="")
		{
			getServerMessage("com.iba.ehis.lc.deliverCleanedLinen.latedeliveryReason");
			var msg=dwrMessage;
			getServerMessage("message.cannot.blank");
			var msg1=dwrMessage;
			msgArray=msg1.split('#');
			var error=msgArray[0]+ msg + " " + msgArray[1] +"<br>";
			parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		}
		else
		{
			populateList();
		}
	}
	else
	{
		populateList();
	}
}

//==================================
  function checkNumber(obj) {
	var val=obj.value;
    if ( trimCheck(val) && isNaN(val) == false && val >=0)
        return true;
    else
        if ( val.length > 0 ) {
            	getServerMessage("message.Numbers.Allowed");
				parent.window.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
				window.event.keyCode = 27;
				obj.value="";
			return false;
        }
}
 function checkAlphaNum(){
	  	 obj =  String.fromCharCode(window.event.keyCode);
	   	var alphaFilter =/^[a-z_A-Z_0-9]+$/;
	   	if (!(alphaFilter.test(obj))) { 
	   		getServerMessage("APP-LC0008");
		parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
	   	window.event.keyCode = 27;
   		}
   	}  	

//================================================
function LinenViewVo(linenItem,linenDesc,category,categoryDesc,rqty,dqty,cdelqty,sdeldate,sdeldateLocale,ldelreason,ldelreasonDesc,remark, flag) {
	this.linenItem = linenItem;
	this.linenDesc=linenDesc;
	this.category=category;
	this.categoryDesc=categoryDesc;
	this.rqty=rqty;
	this.dqty =dqty;
	this.cdelqty=cdelqty;
	this.sdeldate=sdeldate;
	this.sdeldateLocale=sdeldateLocale;
	this.ldelreason=ldelreason;
	this.ldelreasonDesc=ldelreasonDesc;
	this.remark = remark;
	if (flag == null) {
		flag = "createMethod";
	}
	this.flag = flag;
}
function populateList() {
	var flag=setQty();
	if(flag==true)
	{
		var reasonDesc=getDescription();
		//alert(reasonDesc)
		setStatus();
	var linenItem=document.getElementById("linenItem").value;
	if(contentList.get(linenItem) ==null){ var dqt=document.getElementById("dqty").value;
		if(dqt==undefined||dqt==null||dqt==""){dqt=0}
		viewObj = new LinenViewVo(linenItem,document.getElementById("linenDesc").value,document.getElementById("category").value,document.getElementById("categoryDesc").value,document.getElementById("rqty").value,dqt,document.getElementById("cdelqty").value,document.getElementById("sdeldate").value,document.getElementById("sdeldateLocale").value,document.getElementById("ldelreason").value,reasonDesc,document.getElementById("remark").value)
		contentList.put(linenItem,viewObj)
		 showRecords() ;
		}else{
			var obj = contentList.get(linenItem)
			if(obj.flag != "createMethod")
			{
			obj.linenDesc=document.getElementById("linenDesc").value;
			obj.category=document.getElementById("category").value;
			obj.categoryDesc=document.getElementById("categoryDesc").value;
			obj.rqty=document.getElementById("rqty").value;
			obj.dqty =document.getElementById("cdelqty").value;
			if(obj.dqty==undefined||obj.dqty==null||obj.dqty==""){obj.dqty=0}
			obj.cdelqty=document.getElementById("cdelqty").value;
			obj.sdelDate=document.getElementById("sdeldate").value;
			obj.sdeldateLocale=document.getElementById("sdeldateLocale").value;
			obj.ldelreason=document.getElementById("ldelreason").value;
			obj.ldelreasonDesc=reasonDesc;
			obj.remark = document.getElementById("remark").value
			obj.flag= updateMethod;
			contentList.put(linenItem,obj);
			}
			showRecords();
		}
	}
}
function deleteRows() 
{
	var tableObj = document.getElementById("contentTable");
	var len = tableObj.rows.length;
	for (i = len - 1; i != -1; i--) 
	{
		tableObj.deleteRow(i);
	}
}
function showRecords() 
{
	var htmlContent = "";
	var tableObj = document.getElementById("contentTable");
	deleteRows();
	index = 0;
	var i=0;
	index = parseInt(index);
	for (  i in contentList.values()) 
	{
		dataObj = contentList.values()[i];
		if (dataObj != null) 
		{
			tableObj = document.getElementById("contentTable");
			if (dataObj.flag != "deleteMethod") 
			{
				var row = tableObj.insertRow(tableObj.rows.length);
				var col1 = row.insertCell();
				col1.className = "QRYEVEN";
				col1.width="13%";
				col1.align="left";
				var str = "";
				str = "<a href=\"javascript:pickupContent('" + dataObj.linenItem + "')\">";
				str += dataObj.linenDesc + "</a><input type='hidden' name='vo.deliverCleanedLinenVO.linenDeliverList[" + (index) + "].linenItem' id='vo.deliverCleanedLinenVO.linenDeliverList[" + (index) + "].linenItem' value='" + dataObj.linenItem + "'>";
				col1.innerHTML = str;

				var col2 = row.insertCell();
				col2.className = "QRYEVEN";
				col2.width="13%";
				col2.align="left";
				col2.innerHTML = dataObj.categoryDesc + "<input type='hidden' name='vo.deliverCleanedLinenVO.linenDeliverList[" + (index) + "].category' id='vo.deliverCleanedLinenVO.linenDeliverList[" + (index) + "].category' value='" + dataObj.category + "'>";

				var col3 = row.insertCell();
				col3.className = "QRYEVEN";
				col3.width="13%";
				col3.align="right";
				col3.innerHTML = dataObj.rqty + "<input type='hidden' name='vo.deliverCleanedLinenVO.linenDeliverList[" + (index) + "].requestedQty' id='vo.deliverCleanedLinenVO.linenDeliverList[" + (index) + "].requestedQty' value='" + dataObj.rqty + "'>";

				var col4 = row.insertCell();
				col4.className = "QRYEVEN";
				col4.width="13%";
				col4.align="right";
				col4.innerHTML = dataObj.dqty + "<input type='hidden' name='vo.deliverCleanedLinenVO.linenDeliverList[" + (index) + "].deliveredQty' id='vo.deliverCleanedLinenVO.linenDeliverList[" + (index) + "].deliveredQty' value='" + dataObj.dqty + "'>";
				
				var col5 = row.insertCell();
				col5.className = "QRYEVEN";
				col5.width="13%";
				col5.align="right";
				col5.innerHTML = dataObj.cdelqty + "<input type='hidden' name='vo.deliverCleanedLinenVO.linenDeliverList[" + (index) + "].currentdeliveredQty' id='vo.deliverCleanedLinenVO.linenDeliverList[" + (index) + "].currentdeliveredQty' value='" + dataObj.cdelqty + "'>";
				
				var col6 = row.insertCell();
				col6.className = "QRYEVEN";
				col6.width="13%";
				col6.align="left";
				col6.innerHTML = dataObj.sdeldateLocale + "<input type='hidden' name='vo.deliverCleanedLinenVO.linenDeliverList[" + (index) + "].schedDeliveryDate' id='vo.deliverCleanedLinenVO.linenDeliverList[" + (index) + "].schedDeliveryDate' value='" + dataObj.sdeldate + "'>";
				
				var col7 = row.insertCell();
				col7.className = "QRYEVEN";
				col7.width="13%";
				col7.align="left";
				col7.innerHTML = dataObj.ldelreasonDesc + "&nbsp<input type='hidden' name='vo.deliverCleanedLinenVO.linenDeliverList[" + (index) + "].lateDeliveryReason' id='vo.deliverCleanedLinenVO.linenDeliverList[" + (index) + "].lateDeliveryReason' value='" + dataObj.ldelreason + "'>";

				var col8 = row.insertCell();
				col8.className = "QRYEVEN";
				col8.width="13%";
				col8.align="left";
				var str1='<a href="" id="prepAnchor'+index+'" name="prepAnchor'+index+'" onclick="test5popupactivate1(this.id,'+index+');return false;">';
				str1+="Remark</a><input type='hidden' size=20 name='vo.deliverCleanedLinenVO.linenDeliverList[" + (index) + "].remark' id='vo.deliverCleanedLinenVO.linenDeliverList[" + (index) + "].remark' value='" + dataObj.remark + "'>" ;
				col8.innerHTML =str1;
				
			} else {
					var str = "<input type='hidden' name='vo.linenDeliverList[" + index + "].linenItem' id='vo.linenDeliverList[" + index + "].linenItem' value='" + dataObj.linenItem + "'>" + "<input type='hidden' name='vo.placeLinenRequestVO.linenRequest[" + (index) + "].requestedQty' id='vo.placeLinenRequestVO.linenRequest[" + (index) + "].requestedQty' value='" + dataObj.rqty + "'>" +"<input type='hidden' name='vo.linenDeliverList[" + (index) + "].deliveredQty' id='vo.linenDeliverList[" + (index) + "].deliveredQty' value='" + dataObj.dqty + "'>"+"<input type='hidden' name='vo.linenDeliverList[" + (index) + "].currentdeliveredQty' id='vo.linenDeliverList[" + (index) + "].currentdeliveredQty' value='" + dataObj.cdelqty + "'>"+"<input type='hidden' name='vo.linenDeliverList[" + (index) + "].schedDeliveryDate' id='vo.linenDeliverList[" + (index) + "].schedDeliveryDate' value='" + dataObj.sdeldate + "'>"+ "<input type='hidden' name='vo.linenDeliverList[" + (index) + "].lateDeliveryReason' id='vo.linenDeliverList[" + (index) + "].lateDeliveryReason' value='" + dataObj.ldelreason + "'>" +"<input type='hidden' name='vo.placeLinenRequestVO.linenRequest[" + (index) + "].remark' id='vo.placeLinenRequestVO.linenRequest[" + (index) + "].remark' value='" + dataObj.remark + "'>";
					document.getElementById("listContentLayer").innerHTML += str;
					}
				index++;
		}
	}
}
function pickupContent(linenItem) 
{
	var dataObj = contentList.get(linenItem);
	document.getElementById("linenItem").value = linenItem;
	document.getElementById("linenDesc").value = dataObj.linenDesc;
	document.getElementById("rqty").value = dataObj.rqty;
	document.getElementById("category").value=dataObj.category;
	document.getElementById("categoryDesc").value=dataObj.categoryDesc;
	document.getElementById("rqty").value=dataObj.rqty;
	document.getElementById("dqty").value=dataObj.dqty
	document.getElementById("cdelqty").value=dataObj.cdelqty;
	document.getElementById("sdeldate").value=dataObj.sdeldate;
	document.getElementById("sdeldateLocale").value=dataObj.sdeldateLocale;
	document.getElementById("ldelreason").value=dataObj.ldelreason;	 
	document.getElementById("remark").value = dataObj.remark;
	//alert()
	// if(obj.flag!=loadMethod)
	contentList.remove(linenItem)
	showRecords();
}
function cancelRecord()
{
	var linenItem=document.getElementById("linenItem").value;
	var obj = contentList.get(linenItem)
	if(obj !=null)
	{
		if(obj.flag != "createMethod")
			{
				obj.flag=deleteMethod
				contentList.put(linenItem,obj)
			}else
			{
				contentList.remove(linenItem)
			}
	}
				showRecords();
}	
//=============================================

function apply(){
DeliverCleanedLinenForm.submit();

}
function getLoginUserPlaceLinen(){
		var userId ='<%=session.getAttribute("login_user")%>';
		var locale1 = document.getElementById("language_Id").value
		RequestForCleaning.getLoggedInUser(locale1,userId,callLoggedInUserPlaceLinen);
	}
function callLoggedInUserPlaceLinen(data){
		for(prop in data){
			document.getElementById("vo.deliverCleanedLinenVO.linenHandedOverBy").value = prop;
			document.getElementById("vo.deliverCleanedLinenVO.linenCollectedBy").value = prop;
		}
	}
//============================================================
var dQty=0;
var requestedQty=0;
function sumQty()
{
var facilityId=document.getElementById("vo.deliverCleanedLinenVO.operatingFacilityId").value;
var requestNo=document.getElementById("vo.deliverCleanedLinenVO.requestNum").value;
facilityId=trimString(facilityId);
requestNo=trimString(requestNo);
DeliverLinen.getSumdeliveredQty(facilityId,requestNo,setDeliverQty);

}
function setDeliverQty(data)
{
 for(prop in data)
 {
 	if(prop!=null)
	{
	 dQty=data[prop]
	}
	
 }
var facilityId=document.getElementById("vo.deliverCleanedLinenVO.operatingFacilityId").value;
var requestNo=document.getElementById("vo.deliverCleanedLinenVO.requestNum").value;
 DeliverLinen.getSumRequestedQty(facilityId,requestNo,setRequestQty);
}
function setRequestQty(data)
{
 for(prop in data)
 {
 	if(prop!=null)
	{
	 requestedQty=data[prop]
	}
 }

} 


function setStatus() {
dQty=parseInt(dQty)+parseInt(document.getElementById("cdelqty").value);

//document.getElementById("dqty").value=parseInt(document.getElementById("dqty").value)+parseInt(document.getElementById("cdelqty").value);
if( parseInt(requestedQty)==parseInt(dQty))
	document.getElementById("vo.deliverCleanedLinenVO.requestStatus").value="DL"; 
else if(parseInt(requestedQty)>parseInt(dQty)) document.getElementById("vo.deliverCleanedLinenVO.requestStatus").value="PD"; 
}

function setQty()
{ 
var f1=checkStock();
if(f1==true){
	var error="";
	var flag=true;
	var dqty=document.getElementById("dqty").value;
	if(dqty==""||dqty==NaN)dqty=0;
	var rqty=document.getElementById("rqty").value;
	var cdelqty=document.getElementById("cdelqty").value;
	if(cdelqty==""||cdelqty==NaN)cdelqty=0;
	var sum=parseInt(dqty)+parseInt(cdelqty);
	if(sum>rqty){
		getServerMessage("com.iba.ehis.lc.requestForLinen.requestedQuantity");
		var rqty=dwrMessage;
		getServerMessage("com.iba.ehis.lc.deliverCleanedLinen.deliveredQty");
		var dqty=dwrMessage;
		getServerMessage("com.iba.ehis.lc.deliverCleanedLinen.curdeliveryQty");
		var cdqty=dwrMessage;
		getServerMessage("APP-LC00012");
		msg=dwrMessage;
		msgArray=msg.split('#');
		error=error +msgArray[0]+ " "+dqty  +" plus "+ cdqty + " " + msgArray[1] + " " +rqty +"<br>";
		parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		//cdelqty.select();
			flag=false;
		}
		return flag;
	}
}

function checkStock()
{
var f1=true;
var facilityId=document.getElementById("vo.deliverCleanedLinenVO.operatingFacilityId").value;
var linenItem=document.getElementById("linenItem").value;
linenItem=trimString(linenItem);
var stock=0;
MendingRequest.getStock(linenItem,facilityId,validateStock);
	function validateStock(data)
	{
		var qty=document.getElementById("cdelqty").value;
		for(prop in data)
	{
		stock=data[prop];
		
	}
	if(parseInt(qty)>parseInt(stock)){
	 getServerMessage("com.iba.ehis.lc.deliverCleanedLinen.curdeliveryQty");
	 var label1=dwrMessage;
	 getServerMessage("com.iba.ehis.lc.withLaundry");
	 var label2=dwrMessage;
	 getServerMessage("messege.number.greatethan");
	 msg=dwrMessage;
	 msgArray=msg.split('#');
	 var obj=document.getElementById("cdelqty")
	 obj.value="";
	 var error=msgArray[0]+" "+ label1 + " " + msgArray[1] +""+label2+" "+stock+"<br>";
	 parent.parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
	f1=false;
	}
  }
  
  return f1;
}

function getLateDeliveryReason(){
	DeliverLinen.getLateDeliveryReason("<%=locale%>",getReason);
}

function getReason(data){
	var delReaon=document.getElementById("ldelreason");
	for(prop in data){
		DWRUtil.removeAllOptions(delReaon);
		var listOption	= document.createElement('OPTION');
		getServerMessage("com.iba.ehis.lc.select");
		listOption.text = dwrMessage;
		listOption.value= "";
		document.getElementById("ldelreason").add(listOption);
		DWRUtil.addOptions(delReaon,data,prop);
		}
	document.getElementById("ldelreason").value="";
}
function convert2Locale()
{

 var tDate=document.getElementById("vo.deliverCleanedLinenVO.deliveryDate").value;
 IBADateValidator.convertDateJS(tDate,'en','<%=locale%>','dd/MM/yyyy HH:mm',callBackMethod);
  function callBackMethod(data)
	{
		 document.getElementById("deliveryDateLocale").value=data;
		 var fDate=document.getElementById("sdeldate").value;
		 IBADateValidator.convertDateJS(fDate,'en','<%=locale%>','dd/MM/yyyy HH:mm',callBackMethod1);
		 function callBackMethod1(data1)
		{
		 document.getElementById("sdeldateLocale").value=data1;
		}
	}
var reqDate=document.getElementById("requestDate").value;
 IBADateValidator.convertDateJS(reqDate,"<%=locale%>","en","dd/MM/yyyy HH:mm",callBackReqDate);
					function callBackReqDate(conDate){
						document.getElementById("vo.deliverCleanedLinenVO.requestDate").value=conDate;
					}

}
function checkQty1(val)
{
	
	if(val.value!="")
		{
		 if(parseInt(val.value)=='0')
			{
				getServerMessage("com.iba.ehis.lc.deliverCleanedLinen.curdeliveryQty");
				var msg=dwrMessage;
				var arr=msg.split(" ");

				getServerMessage("APP-LC00018");
				var msg2=dwrMessage;
				var arr2=msg2.split(" ");

				var error=arr2[0]+" "+arr[0]+" "+arr[1]+" "+arr[2]+" "+arr2[2]+" "+arr2[3]+" "+arr2[4]+" "+arr2[5]+" "+arr2[6];
				parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
				window.event.keyCode = 27;
				val.value="";
				
			}
		}
}
</script>
<IBATagLibs:initCalendar />
</head>
<body  onload="getLateDeliveryReason();getDeliveryrefNo();deliveryDate()" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<ibaHTML:form action="/DeliverCleanedLinenAction.do"	target="messageFrame">
		<table border='0 ' cellpadding='2' cellspacing='0' width='80%' align='center'>
				<tr>
						<td class='label'  nowrap="nowrap" align="right">
								<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestNum"	bundle="lcLabels" />
						</td>
						<td nowrap="nowrap">
							 <ibaHTML:text property="vo.deliverCleanedLinenVO.requestNum" readonly="true" />
							  
							 <img src="framework/images/mandatory.gif"></img>
						</td>
						<td class='label'  nowrap="nowrap" align="right">
								<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestDate"	bundle="lcLabels" />
						</td>
						<td>
							<input type=text name="requestDate" id="requestDate" readonly="true" />
							<img src="framework/images/mandatory.gif"></img>
							<ibaHTML:hidden property="vo.deliverCleanedLinenVO.requestDate" />
								
						</td>
					</tr>
						<tr>
							<td align="right" width="30%" CLASS='label' nowrap="nowrap">
								<ibaBean:message
									key="com.iba.ehis.lc.standardStock.sourceType"
									bundle="lcLabels" />
							</td>
							<td width="30%" nowrap="true">
							<input type=text name="sourceType" id="sourceType" readonly="true" />
							<ibaHTML:hidden property="vo.deliverCleanedLinenVO.sourceType" />
							<img src="framework/images/mandatory.gif"></img>
							</td>
						
							<td align="right" width="20%" CLASS='label' nowrap="nowrap">
								<ibaBean:message
									key="com.iba.ehis.lc.standardStock.source"
									bundle="lcLabels" />
							</td>
							<td width="40%" nowrap="nowrap" >
							<ibaHTML:hidden property="vo.deliverCleanedLinenVO.sourceCode"  />
							<input type="text" name="sourceDesc" id="sourceDesc" readonly="true"/>
							<img src="framework/images/mandatory.gif"></img>
							</td>
						</tr>
						
						<tr >
						<td class='label'  nowrap="nowrap" align="right">
								<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.linenHandedOverBy"	bundle="lcLabels" />
						</td>
						<td class='label' nowrap="nowrap">
							 <ibaHTML:text property="vo.deliverCleanedLinenVO.linenHandedOverBy" readonly="true" />
							 <img src="framework/images/mandatory.gif"></img>
						</td>
						<td class='label'  nowrap="nowrap" align="right">
								<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.linenCollectedBy"	bundle="lcLabels" />
						</td>
						<td class='label' nowrap="nowrap">
							 <ibaHTML:text property="vo.deliverCleanedLinenVO.linenCollectedBy" />
							 <img src="framework/images/mandatory.gif"></img>
						</td>
						</tr>
						<tr >
						<td class='label'  nowrap="nowrap" align="right">
								<ibaBean:message key="com.iba.ehis.lc.deliverCleanedLinen.deliveryDate"	bundle="lcLabels"  />
						</td>
						<td class='label' nowrap="nowrap" colspan=3>
							 <input type=text name="deliveryDateLocale" id="deliveryDateLocale" readonly/>
							 <ibaHTML:hidden property="vo.deliverCleanedLinenVO.deliveryDate"/>
							  
							 <img src="framework/images/mandatory.gif"></img>
						</td>
						</tr>
		</table>
<br>
<table align="center" border='0' cellpadding='0' cellspacing='0'
			width='80%' align='center'>
						<tr>
							<td class='label' align="right">
								<ibaBean:message key="com.iba.ehis.lc.linenItem"
									bundle="lcLabels" />
							</td>
							<td nowrap class='button' >

								<input type="text" name="linenDesc" id="linenDesc" readonly=true />

								<input type="hidden" name="linenItem" id="linenItem"  />

							</td>
							<td class='label' align="right">
								<ibaBean:message key="com.iba.ehis.lc.Category"
									bundle="lcLabels" />
							</td>
							<td>
								<input type="hidden" name="category" id="category" readonly=true />
								<input type="text" name="categoryDesc" id="categoryDesc" readonly=true />

							</td>
						</tr>
						<tr>
							<td class='label' align="right">
								<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestedQuantity"
									bundle="lcLabels" />
							</td>
							<td nowrap class='button' >
								<input type="text" name="rqty" id="rqty" onkeypress="checkNumber(this)" readonly="true"/>
							</td>
							<td class='label' align="right">
								<ibaBean:message key="com.iba.ehis.lc.deliverCleanedLinen.deliveredQty"
									bundle="lcLabels" />
							</td>
							<td>
								<input type="text" name="dqty" id="dqty"  readonly="true"  />

							</td>
						</tr>
						<tr>
							<td class='label' align="right">
								<ibaBean:message key="com.iba.ehis.lc.deliverCleanedLinen.curdeliveryQty"
									bundle="lcLabels" />
							</td>
							<td nowrap class='button' >
								<input type="text" name="cdelqty" id="cdelqty" onkeyup="checkNumber(this)" onblur="checkQty1(this);setQty()" maxlength ="10" size="10"  />
							</td>
							<td class='label' align="right">
								<ibaBean:message key="com.iba.ehis.lc.deliverCleanedLinen.schDeliveryDate"
									bundle="lcLabels" />
							</td>
							<td>
								<input type="text" name="sdeldateLocale" id="sdeldateLocale" readonly="true"  />
								<input type="hidden" name="sdeldate" id="sdeldate" />

							</td>
						</tr>
						<tr>
							<td class='label' align="right">
								<ibaBean:message key="com.iba.ehis.lc.deliverCleanedLinen.latedeliveryReason" bundle="lcLabels" />
							</td>
							<td>
								<select name="ldelreason" id="ldelreason">
									<option value=" ">
										<ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" />
									</option>
								</select>
						</td>
						<td class='label' align="right">
							<a href="javascript:#" onclick="test5popupactivate(this.id);return false;" name="prepAnchor" id="prepAnchor">
						<ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" /></a>
						<input type="hidden" name="remarkArea" id="remarkArea" value="" maxlength="2000"/>
						<input type="hidden" name="remark" id="remark" value="" maxlength="2000"/>
								
							</td>
							<td colspan="3" align='right'>
								<input class="BUTTON" type="button" name="select" id="select" value="<ibaBean:message key="com.iba.ehis.lc.selectforbutton" bundle="lcLabels" />" onClick="testReason();" />
								<input class="BUTTON" type="button" name="cancel" id="cancel" value="<ibaBean:message key="com.iba.ehis.lc.cancel" bundle="lcLabels" />" onClick="cancelRecord()" />
							</td>
						</tr>

		</table>

<br>
	<table border='1' cellpadding='2' cellspacing='0' width='90%' id="tableid" align='center' >
				 <tr>
					<th align='left'  colspan=8>
						<b><ibaBean:message key="com.iba.ehis.lc.linenItemDetail" bundle="lcLabels" /></b>
					</th>
				 </tr>
				<tr>
					<th align="center" width="13%">
						<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
					</th>
					<th align="center" width="13%">
						<ibaBean:message key="com.iba.ehis.lc.Category" bundle="lcLabels" />
					</th>
					<th align="center" width="13%" >
						<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestedQuantity" bundle="lcLabels" />
					</th>
					<th align="center" width="13%" >
						<ibaBean:message key="com.iba.ehis.lc.deliverCleanedLinen.deliveredQty" bundle="lcLabels" />
					</th>
					<th align="center" width="13%" >
						<ibaBean:message key="com.iba.ehis.lc.deliverCleanedLinen.curdeliveryQty" bundle="lcLabels" />
					</th>
					<th align="center" width="13%">
						<ibaBean:message key="com.iba.ehis.lc.deliverCleanedLinen.schDeliveryDate" bundle="lcLabels" />
					</th>
					<th align="center" width="13%">
						<ibaBean:message key="com.iba.ehis.lc.deliverCleanedLinen.latedeliveryReason" bundle="lcLabels" />
					</th>
					<th align="center" width="13%">
						<ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" />
					</th>
				</tr>
				<tr>
			</tr>
	</table>
		<div id="listContentLayer" align="center">
		
					<table border='1' cellpadding='2' cellspacing='0' width='90%'
						 id="contentTable" >
						 
					</table>
				</div>


		<input type=hidden name="vo.deliverCleanedLinenVO.operatingFacilityId" id="vo.deliverCleanedLinenVO.operatingFacilityId" value="<%=facilityId%>" />		
		<ibaHTML:hidden property="vo.deliverCleanedLinenVO.requestStatus" />	
		<ibaHTML:hidden property="vo.deliverCleanedLinenVO.deliveryRefNum" />	
		<ibaHTML:hidden property="vo.deliverCleanedLinenVO.locale" value="<%=locale%>" />	
		<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>" />
		<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
		<ibaHTML:hidden property="vo.mode" />
		<input type="hidden" name="language_Id" id="language_Id" value="<%=locale%>" />
		<table align="center"><tr><td><input type="button" value="<ibaBean:message key='com.iba.ehis.lc.submit' bundle='lcLabels' />" name="Submit" class="BUTTON" onclick="getDeliveryrefNo();settime()" /></td></tr></table>

	</ibaHTML:form>
	<script>
	var sCode;	
	var sCode1="";	
		document.getElementById("vo.deliverCleanedLinenVO.requestStatus").value=
		dialogArguments[5];
		document.getElementById("sourceDesc").value=
		dialogArguments[15];
		//document.getElementById("vo.deliverCleanedLinenVO.deliveryDate").value= dialogArguments[9];
		document.getElementById("vo.deliverCleanedLinenVO.sourceType").value=dialogArguments[6];
		var ss=dialogArguments[6];   
		dialogArguments[6]=trimString(ss);
		var sType="";
		if(dialogArguments[6]=='W'){
		getServerMessage("com.iba.ehis.lc.ward");
		sType=dwrMessage;}
		else if(dialogArguments[6]=='C'){
		getServerMessage("com.iba.ehis.lc.clinic");
		sType=dwrMessage;}
		else if(dialogArguments[6]=='D'){
		getServerMessage("com.iba.ehis.lc.department");
		sType=dwrMessage;}

		document.getElementById("sourceType").value=sType;
		var scode=dialogArguments[0]
		scode=trimString(scode);
	
		var type1=dialogArguments[6];
		type1=trimString(type1);
		var locale1 = document.getElementById("language_Id").value
		LinenIssue.getSourceDesc(locale1,"<%=facilityId%>",type1,scode,callBackDate);
		
		function callBackDate(data){
		
			for(prop in data){
				sCode1 = data[prop];
				document.getElementById("sourceDesc").value= sCode1;
				
			}
		}
					
		document.getElementById("vo.deliverCleanedLinenVO.requestNum").value= trimString(dialogArguments[1]);
		document.getElementById("requestDate").value=trimString(dialogArguments[2]);
		document.getElementById("vo.deliverCleanedLinenVO.sourceCode").value= trimString(dialogArguments[0]);
		document.getElementById("vo.deliverCleanedLinenVO.linenHandedOverBy").value= trimString(dialogArguments[3]);
		document.getElementById("vo.deliverCleanedLinenVO.linenCollectedBy").value= trimString(dialogArguments[4]);
		document.getElementById("linenItem").value= trimString(dialogArguments[7]);
		document.getElementById("linenDESc").value= trimString(dialogArguments[14]);
		document.getElementById("rqty").value=trimString(dialogArguments[12]);
		var ss1=dialogArguments[13];   
		dialogArguments[13]=trimString(ss1);
		document.getElementById("category").value=trimString(dialogArguments[13])
		var sType1="";
		if(dialogArguments[13]=='S'){
		getServerMessage("com.iba.ehis.lc.soiled");
		sType1=dwrMessage;}
		else if(dialogArguments[13]=='I'){
		getServerMessage("com.iba.ehis.lc.infected");
		sType1=dwrMessage;}
		else if(dialogArguments[13]=='V'){
		getServerMessage("com.iba.ehis.lc.seriouslyInfected");
		sType1=dwrMessage;}
		else if(dialogArguments[13]=='D'){
		getServerMessage("com.iba.ehis.lc.dirty");
		sType1=dwrMessage;}
		document.getElementById("categoryDesc").value=sType1;
			
	function deliveredQty(){
		var rno=document.getElementById("vo.deliverCleanedLinenVO.requestNum").value;
		var litem=document.getElementById("linenItem").value;
		var category=document.getElementById("category").value;
		var facilityId=document.getElementById("vo.deliverCleanedLinenVO.operatingFacilityId").value;
		rno=trimString(rno);
		litem=trimString(litem)
		facilityId=trimString(facilityId);
		category=trimString(category);
		DeliverLinen.getDeliveredQty(litem,rno,facilityId,setDeliveryData);
		}

	function setDeliveryData(data){
		for (prop in data ){
		var delqty=data[prop]
		if(delqty==undefined||delqty==null||delqty==""){delqty=0}
		document.getElementById("dqty").value=delqty;
		}
	}
		var rno=document.getElementById("vo.deliverCleanedLinenVO.requestNum").value;
		var litem=document.getElementById("linenItem").value;
		var category=document.getElementById("category").value;
		var facilityId=document.getElementById("vo.deliverCleanedLinenVO.operatingFacilityId").value;
		rno=trimString(rno);
		litem=trimString(litem)
		facilityId=trimString(facilityId);
		category=trimString(category);
		DeliverLinen.getScheduleDate(facilityId,rno,category,litem,callScheduleDate);

	function callScheduleDate(data){
		var sdate=""
		//var currentDate=document.getElementById("vo.deliverCleanedLinenVO.deliveryDate").value;
		for(prop in data)
		sdate=data[prop]
		document.getElementById("sdeldate").value=sdate;
		IBADateValidator.isCurrentDateTimeLesserThanJS(sdate,'en',getFlag);
		}

	sumQty();
	deliveredQty();

	function getFlag(flag){
		//alert(flag)
		convert2Locale();
		if(flag==true)
		document.getElementById("ldelreason").disabled=true;
	}
function getDescription()
{
var desc="";
var val=document.getElementById("ldelreason").value;
//alert(val)
var el = document.getElementsByTagName("SELECT").item(0);
if (el != null) {
	for (i=0; i<el.options.length; i++) {
		//alert(el.options(i).value+"=="+val)
		if(val!="")
		{
           	if(el.options(i).value==val)
       		{
       		 desc=el.options(i).text;break;
			}
		}
	}
}
//alert(desc)
return desc;
}
</script>
</body>
</ibaHTML:html>

