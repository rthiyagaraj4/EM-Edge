<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateTime,com.iba.framework.core.util.IBADateValidation" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/framework/html/Tag.text"%>

<ibaHTML:html locale="true">
<head>
	<%
	String facilityId=(String)session.getAttribute("facility_id");
	String functionId = (String) session.getAttribute("functionId");
	String moduleId = (String) session.getAttribute("moduleId");
	String locale = (String) session.getAttribute("LOCALE");
	String loggedInUser = (String) session.getAttribute("login_user");
	String sourceDesc= (String) request.getParameter("sourceDesc");
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			
		
	if (sStyle == null)
		sStyle = "IeStyle.css";
		String qryEven = "QRYEVEN";
		String qryOdd = "QRYODD";
		UserPreferences userPrefs =new UserPreferences();
		/* Cache cache = CacheManager.getCache();
		userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */ //AMRI-SCF-0679
		String datepattrn=userPrefs.getDateFormat();
		String sb=userPrefs.getDateFormat();
		String tf=userPrefs.getTimeFormat();
		String pattern=sb+" "+tf;
		
		String PP=sb.substring(0,2);
		if(PP.compareToIgnoreCase("dd")==0)
		datepattrn="%d/%m/%y"+" "+tf;
		else if(PP.compareToIgnoreCase("MM")==0)
		datepattrn="%m/%d/%y"+" "+tf;
		else if(PP.compareToIgnoreCase("yy")==0)
		datepattrn="%y/%m/%d"+" "+tf;
	
		IBADateTime frmDate=LcDateFormat.getSevendaysBackDate(request);
		
		IBADateTime date = new IBADateTime(request.getSession().getId());
										
		IBADateValidation ibaDateValidation = new IBADateValidation();
		String cdate = ibaDateValidation.convertDateJS(frmDate.toString(),"en",locale,pattern);
		String fdate = ibaDateValidation.convertDateJS(date.toString(),"en",locale,pattern);
	
	%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenIssue.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/MendingRequest.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/IssueOfLinen/js/IssueOfinen.js'></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/framework/js/PopupWindow.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenIssue.js'></script>
	
	

<script type="text/javascript">
var contentList =new Hashtable();

//============================================================
var issuedQty=0;
var requestedQty=0;
function sumQty()
{
var facilityId=document.getElementById("vo.issueOfLinenVO.operatingFacilityId").value;
var requestNo=document.getElementById("vo.issueOfLinenVO.requestNum").value;
facilityId=trimString(facilityId);
requestNo=trimString(requestNo);
LinenIssue.getSumIssuedQty(facilityId,requestNo,setIssueQty);
LinenIssue.getSumRequestedQty(facilityId,requestNo,setRequestQty);
}
function setIssueQty(data)
{
 for(prop in data)
 {
 	if(prop!=null)
	{
	 issuedQty=data[prop]
	}
 }
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
function setStatus()
{
var rqty=document.IssueOfLinenForm["qty"].value;
issuedQty=parseInt(issuedQty)+parseInt(document.IssueOfLinenForm["ciqty"].value)

if(parseInt(requestedQty)==parseInt(issuedQty))
	{document.getElementById("vo.issueOfLinenVO.requestStatus").value="IS";}
else if(parseInt(requestedQty)>parseInt(issuedQty))
	{document.getElementById("vo.issueOfLinenVO.requestStatus").value="PI";}
	else
	{document.getElementById("vo.issueOfLinenVO.requestStatus").value="OS";}

//alert(document.getElementById("vo.issueOfLinenVO.requestStatus").value)
}

//============================================================
var  testpopup5="";
var testpopup4="";
var val="";

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
var title2=title+".."

getServerMessage("com.iba.ehis.lc.ok")
var buttonlabel=dwrMessage;

testpopup5.height=200;
testpopup5.width=300;
testpopup5.offsetX=-10;
testpopup5.offsetY=10;
testpopup5.autoHide();
testpopup5.populate('<title>'+title2+'</title><link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>"></link><FORM><CENTER><table border="0" celpadding="0" cellspacing="0" width="100%" height="100%"><tr><td class="label" align="left">'+title1+'</td></tr><tr><td  align="center"><textarea rows=8 cols=40 maxlength=2000 name="remarkArea" onkeyup="window.opener.document.getElementById("remarkArea").value=this.value;window.opener.setval()">'+val+'</textarea></td></tr><tr><td  align="center"><input class="button" type="button" onclick="window.close();window.opener.setval()" value="'+buttonlabel+'"/></td></tr></table> </FORM></CENTER>');
testpopup5.showPopup(anchor);
setval();
}

function test5popupactivate1(anchor,index) {
var val=document.getElementById("vo.issueOfLinenVO.linenIssueList["+index+"].remark").value;
testpopup4 = new PopupWindow();
testpopup4.windowProperties="toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no";

getServerMessage("com.iba.ehis.lc.remark")
var title=dwrMessage;
var title1=title+":"
var title2=title+".."

testpopup4.height=200;
testpopup4.width=300;
testpopup4.offsetX=-10;
testpopup4.offsetY=10;
testpopup4.autoHide();
getServerMessage("com.iba.ehis.lc.ok")
var buttonlabel=dwrMessage;
testpopup4.populate('<title>'+title2+'</title><link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>"></link><FORM><CENTER><table border="0" celpadding="0" cellspacing="0" width="100%" height="100%"><tr><td class="label" align="center">'+title1+'</td></tr><tr><td  align="center"><textarea rows=8 cols=40 readonly=true name="remarkArea">'+val+'</textarea></td></tr><tr><td  align="center"><input class="button" type="button" onclick="window.close();" value="'+buttonlabel+'"/></td></tr></table> </FORM></CENTER>');
testpopup4.showPopup(anchor);
}
 //========= set issuedQty==========

function issueNo(){
	var facilityId=document.getElementById("vo.issueOfLinenVO.operatingFacilityId").value;
	var requestNo=document.getElementById("vo.issueOfLinenVO.requestNum").value;
	LinenIssue.getIssueNo(facilityId,requestNo,setIssueNo);
	}

function setIssueNo(data){
	var max=0;
	for(prop in data){
		if(prop!=null){
			if(parseInt(prop)>parseInt(max))
				max=parseInt(prop);
			}
		}
		
	max=parseInt(max)+1;
	document.IssueOfLinenForm["vo.issueOfLinenVO.issueNum"].value=max;
}

function settime(){
	window.setTimeout(AlertMsg,1000);	
}

function AlertMsg(){
	var obj=document.getElementById("vo.issueOfLinenVO.issueNum");
	var tableObj = document.getElementById("contentTable");
	var len = tableObj.rows.length;
	var flag=checkNull();
	if(flag==true){
		if(parseInt(len)>0){
		getServerMessage("com.iba.ehis.lc.pnyrequestNum");
		alert(dwrMessage+" "+":"+obj.value);
		apply();
	}else{
		getServerMessage("com.iba.ehis.lc.atleastselectthelinenitem");
		alert(dwrMessage)
		}
	}
}

//=====================================================
function issueQty(){
	var rno=document.getElementById("vo.issueOfLinenVO.requestNum").value;
	var litem=document.getElementById("vo.issueOfLinenVO.linenItem").value;
	var facilityId=document.getElementById("vo.issueOfLinenVO.operatingFacilityId").value;
	rno=trimString(rno);
	litem=trimString(litem)
	facilityId=trimString(facilityId);
	RequestForCleaning.getIssueDetail(litem,rno,facilityId,setIssueData);
	}

function setIssueData(data){
	var issuedqty=0;
	for (prop in data )
	issuedqty=data[prop]
	document.getElementById("iqty").value=issuedqty;
	}

//=============================================

function checkQty(){
	var qty=document.getElementById("qty").value;
	var iqty=document.getElementById("iqty").value;
	var ciqty=document.getElementById("ciqty").value;
	var error="";
	var flag;
	var val=parseInt(iqty)+parseInt(ciqty);
	if(qty!=""&&iqty!=""&&ciqty!=""){
		if(parseInt(val)>parseInt(qty)){
				getServerMessage("com.iba.ehis.lc.requestForLinen.requestedQuantity");
				key_value=dwrMessage;
				getServerMessage("APP-LC00013");
				msg=dwrMessage;
				msgArray=msg.split('#');
				getServerMessage("com.iba.ehis.lc.requestForLinen.issuedQuantity");
				field1=dwrMessage;
				getServerMessage("com.iba.ehis.lc.issueOfLinen.currentIssueQuantity");
				field2=dwrMessage;
				error=error +msgArray[0]+ key_value + " " + msgArray[1] +" sum of ("+field1+" and "+field2+")";
				flag=false;
				document.getElementById("ciqty").value="";
				document.getElementById("ciqty").selected=true;
			}
			else{
				flag=true;
				setStatus();
			}
		parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		}
		else
		{	flag=false;
			getServerMessage("com.iba.ehis.lc.issueOfLinen.currentIssueQuantity");
			var msg=dwrMessage;
			getServerMessage("message.cannot.blank");
			msg1=dwrMessage;
	 		msgArray=msg1.split('#');
	 		var error=error +msgArray[0]+msg + " " + msgArray[1] +"<br>";
			parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		}
		if(flag==false) return false; else return true;

	}	
//==========================================
function addListRec()
{
var rno=document.getElementById("vo.issueOfLinenVO.requestNum").value;
var litem=document.getElementById("vo.issueOfLinenVO.linenItem").value;
var facilityId=document.getElementById("vo.issueOfLinenVO.operatingFacilityId").value;

// LinenIssue.getIssueDetail(litem,rno,facilityId,setIssueData);
}
function LinenViewVo(linenItem,linenDesc,qty,iqty,ciqty,remark, flag) {
	this.linenItem = linenItem;
	this.linenDesc = linenDesc;
	this.qty = qty;
	this.iqty = iqty;
	this.ciqty = ciqty;
	this.remark = remark;
	if (flag == null) {
		flag = "createMethod";
	}
	this.flag = flag;
}
function populateList() {
		var flag=checkQty();
		var linenItem=document.getElementById("linenItem").value;
		if(flag==true){
			if(contentList.get(linenItem) ==null){
			var issuedQty=document.getElementById("iqty").value
				if(issuedQty=="")issuedQty=0;
				var CurrentIssuedQty=document.getElementById("ciqty").value
				if(CurrentIssuedQty=="")CurrentIssuedQty=0;
			viewObj = new LinenViewVo(linenItem,document.getElementById("vo.issueOfLinenVO.linenDesc").value,document.getElementById("qty").value,issuedQty,CurrentIssuedQty,document.getElementById("remark").value)
			contentList.put(linenItem,viewObj)
		
			}else{
					var obj = contentList.get(linenItem)
					obj.linenDesc = document.getElementById("vo.issueOfLinenVO.linenDesc").value
					obj.qty  = document.getElementById("qty").value
					obj.iqty = document.getElementById("iqty").value
					obj.ciqty = document.getElementById("ciqty").value
					obj.remark =document.getElementById("ciqty").value
					obj.flag= "updateMethod";
					contentList.put(linenItem,obj);
				
			}
			showRecords();
			
		}
		else
		{
			document.getElementById("ciqty").value="";
			if(contentList.get(linenItem) ==null){
				var issuedQty=document.getElementById("iqty").value
				if(issuedQty=="")issuedQty=0;
				var CurrentIssuedQty=document.getElementById("ciqty").value
				if(CurrentIssuedQty=="")CurrentIssuedQty=0;
			viewObj = new LinenViewVo(linenItem,document.getElementById("vo.issueOfLinenVO.linenDesc").value,document.getElementById("qty").value,issuedQty,CurrentIssuedQty,document.getElementById("remark").value)
			contentList.put(linenItem,viewObj)
			}else{
					var obj = contentList.get(linenItem)
					if(obj.flag != "createMethod"){
					obj.linenDesc = document.getElementById("vo.issueOfLinenVO.linenDesc").value
					obj.qty = document.getElementById("qty").value
					obj.iqty = document.getElementById("iqty").value
					obj.ciqty = document.getElementById("ciqty").value
					obj.remark = document.getElementById("ciqty").value
					obj.flag= updateMethod;
					contentList.put(linenItem,obj);
					}
				}
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
				str += dataObj.linenDesc + "</a><input type='hidden' name='vo.issueOfLinenVO.linenIssueList[" + (index) + "].linenItem' id='vo.issueOfLinenVO.linenIssueList[" + (index) + "].linenItem' value='" + dataObj.linenItem + "'>";
				col1.innerHTML = str;
				var col2 = row.insertCell();
				col2.className = "QRYEVEN";
				col2.width="20%";
				col2.align="right";
				col2.innerHTML = dataObj.qty + "<input type='hidden' name='vo.issueOfLinenVO.linenIssueList[" + (index) + "].requestedQty' id='vo.issueOfLinenVO.linenIssueList[" + (index) + "].requestedQty' value='" + dataObj.qty + "'>";
				var col3 = row.insertCell();
				col3.className = "QRYEVEN";
				col3.width="20%";
				col3.align="right";
				col3.innerHTML = dataObj.iqty + "<input type='hidden' name='vo.issueOfLinenVO.linenIssueList[" + (index) + "].issueQty' id='vo.issueOfLinenVO.linenIssueList[" + (index) + "].issueQty' value='" + dataObj.iqty + "'>";
				var col4 = row.insertCell();
				col4.className = "QRYEVEN";
				col4.width="20%";
				col4.align="right";
				col4.innerHTML = dataObj.ciqty + "<input type='hidden' name='vo.issueOfLinenVO.linenIssueList[" + (index) + "].currentIssueQty' id='vo.issueOfLinenVO.linenIssueList[" + (index) + "].currentIssueQty' value='" + dataObj.ciqty + "'>";
				var col5 = row.insertCell();
				col5.className = "QRYEVEN";
				col5.width="20%";
				col5.align="left";
				
				var str1='<a href="" id="prepAnchor'+index+'" name="prepAnchor'+index+'" onclick="test5popupactivate1(this.id,'+index+');return false;">';
				str1+="Remark</a><input type='hidden' size=20 name='vo.issueOfLinenVO.linenIssueList[" + (index) + "].remark' id='vo.issueOfLinenVO.linenIssueList[" + (index) + "].remark' value='" + dataObj.remark + "'>" ;
				col5.innerHTML =str1;
				
			} else {
				var str = "<input type='hidden' name='vo.issueOfLinenVO.linenIssueList[" + index + "].linenItem' id='vo.issueOfLinenVO.linenIssueList[" + index + "].linenItem' value='" + dataObj.linenItem + "'>" + "<input type='hidden' name='vo.issueOfLinenVO.linenIssueList[" + (index) + "].requestedQty' id='vo.issueOfLinenVO.linenIssueList[" + (index) + "].requestedQty' value='" + dataObj.qty + "'>" + "<input type='hidden' name='vo.issueOfLinenVO.linenIssueList[" + (index) + "].issueQty' id='vo.issueOfLinenVO.linenIssueList[" + (index) + "].issueQty' value='" + dataObj.iqty + "'>"+ "<input type='hidden' name='vo.issueOfLinenVO.linenIssueList[" + (index) + "].currentissueQty' id='vo.issueOfLinenVO.linenIssueList[" + (index) + "].currentissueQty' value='" + dataObj.ciqty + "'>"+ "<input type='hidden' name='vo.issueOfLinenVO.linenIssueList[" + (index) + "].remark' id='vo.issueOfLinenVO.linenIssueList[" + (index) + "].remark' value='" + dataObj.remark + "'>";
				document.getElementById("listContentLayer").innerHTML += str;
			}
			index++;
		}
	}
}
function pickupContent(linenItem) {
	var dataObj = contentList.get(linenItem);
	document.getElementById("linenItem").value= linenItem;
	document.getElementById("vo.issueOfLinenVO.linenDesc").value= dataObj.linenDesc;
	document.getElementById("qty").value = dataObj.qty;
	document.getElementById("iqty").value= dataObj.iqty;
	document.getElementById("ciqty").value = dataObj.ciqty;	
	document.getElementById("remark").value = dataObj.remark;
	if(dataObj.flag!=loadMethod)
 				contentList.remove(linenItem)
 			showRecords()
}
function cancelRecord(){
			var linenItem=document.IssueOfLinenForm["linenItem"].value
		
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
//========= apply===============
function apply() {
	
	 	document.IssueOfLinenForm.submit();
	
}

//================checkNull===========
function checkNull() {
	var flag;
 	var error="";
 	var fieldName = new Array("com.iba.ehis.lc.requestForLinen.requestNum", "com.iba.ehis.lc.requestForLinen.requestDate", "com.iba.ehis.lc.standardStock.sourceType","com.iba.ehis.lc.standardStock.source","com.iba.ehis.lc.requestForLinen.raisedBy","com.iba.ehis.lc.issueBy","com.iba.ehis.lc.issueDate");
	var fields = new Array(document.getElementById("vo.issueOfLinenVO.requestNum").value, document.getElementById("vo.issueOfLinenVO.requestDate").value, document.getElementById("vo.issueOfLinenVO.sourceType").value,document.getElementById("vo.issueOfLinenVO.sourceCode").value,document.getElementById("vo.issueOfLinenVO.raisedBy").value,document.getElementById("vo.issueOfLinenVO.issueBy").value,document.getElementById("vo.issueOfLinenVO.issueDate").value);
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
	parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
	if(flag==false) return false; else return true;
}
//=====================================================
function getLoginUserPlaceLinen(){
		var userId ='<%=session.getAttribute("login_user")%>';
		var locale1=document.getElementById("languageId").value
		RequestForCleaning.getLoggedInUser(locale1,userId,callLoggedInUserPlaceLinen);
	}
function callLoggedInUserPlaceLinen(data){
		for(prop in data){
			document.getElementById("vo.issueOfLinenVO.raisedBy").value = prop;
		document.getElementById("vo.issueOfLinenVO.issueBy").value = prop;

		}
	}

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
	//	var rdate=document.getElementById("vo.issueOfLinenVO.issueDate");
	//	rdate.value=convert1;
		}

 function checkNumber(obj) {
	var val=obj.value;
    if ( trimCheck(val) && isNaN(val) == false && parseInt(val) >=0)
        return true;
    else
        if ( val.length > 0 ) {
            	getServerMessage("message.Numbers.Allowed");
				parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
				window.event.keyCode = 27;
				obj.value="";
			return false;
        }
}
function checkQty1(val)
{
	
	if(val.value!="")
		{
		 if(parseInt(val.value)=='0')
			{
				getServerMessage("com.iba.ehis.lc.issueOfLinen.currentIssueQuantity");
				var msg=dwrMessage;
				var arr=msg.split(" ");

				getServerMessage("APP-LC00018");
				var msg2=dwrMessage;
				var arr2=msg2.split(" ");

				var error=arr2[0]+" "+arr[0]+" "+arr[1]+" "+arr[2]+" "+arr2[2]+" "+arr2[3]+" "+arr2[4]+" "+arr2[5]+" "+arr2[6];
				parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
				window.event.keyCode = 27;
				val.value="";
				
			}
		}
		else
		{
			getServerMessage("com.iba.ehis.lc.issueOfLinen.currentIssueQuantity");
			var msg=dwrMessage;
			getServerMessage("message.cannot.blank");
			msg1=dwrMessage;
	 		msgArray=msg1.split('#');
	 		var error=error +msgArray[0]+msg + " " + msgArray[1] +"<br>";
			parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		}
}
</script>
<IBATagLibs:initCalendar />
</head>

<body onload="issueNo();getLoginUserPlaceLinen();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">

	<ibaHTML:form action="/IssueOfLinenAction.do"	target="messageFrame">
		<table border='0 ' cellpadding='2' cellspacing='0' width='100%' align='center'>
				
				<tr>
							<td align='right' width="30%" CLASS='label' nowrap="nowrap">
								<ibaBean:message
									key="com.iba.ehis.lc.standardStock.sourceType"
									bundle="lcLabels" />
							</td>
							<td width="30%">
							<input type="text" name="vo.issueOfLinenVO.sourceDesc" id="vo.issueOfLinenVO.sourceDesc" readonly="true"/>
							<input type="hidden" name="vo.issueOfLinenVO.sourceType" id="vo.issueOfLinenVO.sourceType"  />
							<img src="framework/images/mandatory.gif"></img>
							</td>
						
							<td align='right' width="20%" CLASS='label' nowrap="nowrap">
								<ibaBean:message
									key="com.iba.ehis.lc.standardStock.source"
									bundle="lcLabels" />
							</td>
							<td width="40%" nowrap="nowrap" >
							<input type="hidden" name="vo.issueOfLinenVO.sourceCode" id="vo.issueOfLinenVO.sourceCode"  />
							<input type="text" name="sourceDesc" id="sourceDesc" readonly="true"/>
							
							<img src="framework/images/mandatory.gif"></img>
							</td>
						</tr>
						<tr>
						<td class='label'  nowrap="nowrap" align='right'>
								<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestNum"	bundle="lcLabels" />
						</td>
						<td>
							<input type="hidden" name="vo.issueOfLinenVO.issueNum" id="vo.issueOfLinenVO.issueNum" />
							 <input type="text" name="vo.issueOfLinenVO.requestNum" id="vo.issueOfLinenVO.requestNum" readonly="true" size="10" />
							 <img src="framework/images/mandatory.gif"></img>
						</td>
						<td class='label'  nowrap="nowrap" align='right'>
								<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestDate"	bundle="lcLabels" />
						</td>
						<td  class='label' nowrap="nowrap">
							<input type="text" name="vo.issueOfLinenVO.requestDate" id="vo.issueOfLinenVO.requestDate" readonly="true" />
 						 <input type="hidden" name="vo.issueOfLinenVO.requestDate.pattern" id="vo.issueOfLinenVO.requestDate.pattern"  value="dd/MM/yyyy HH:mm"/>
							 <img src="framework/images/mandatory.gif"></img>

						</td>
							
						</tr>
						<tr >
						<td class='label'  nowrap="nowrap" align='right'>
								<ibaBean:message key="com.iba.ehis.lc.requestForLinen.raisedBy"	bundle="lcLabels" />
						</td>
					<td class='label' colspan=3>
						<input type="text" name="vo.issueOfLinenVO.raisedBy" id="vo.issueOfLinenVO.raisedBy" readonly="true" />
							 <img src="framework/images/mandatory.gif"></img>
						</td>
						</tr>
						<tr>
						<td class='label'  nowrap="nowrap" align='right'>
								<ibaBean:message key="com.iba.ehis.lc.issueBy"	bundle="lcLabels" />
						</td>
						<td class='label' >
							 <input type="text" name="vo.issueOfLinenVO.issueBy" id="vo.issueOfLinenVO.issueBy" />
							
						 <img src="framework/images/mandatory.gif"></img>
						</td>
						<td class='label'  nowrap="nowrap" align='right'>
								<ibaBean:message key="com.iba.ehis.lc.issueDate"	bundle="lcLabels" />
						</td>
						<td class='label' nowrap="nowrap">
							 <input type="text" name="vo.issueOfLinenVO.issueDate" id="vo.issueOfLinenVO.issueDate"  value="<%=fdate%>" readonly="true"/>
	 						 <input type="hidden" name="vo.issueOfLinenVO.issueDate.pattern" id="vo.issueOfLinenVO.issueDate.pattern"  value="dd/MM/yyyy HH:mm"/>
							
						 <img src="framework/images/mandatory.gif"></img>
						</td>
						</tr>
		</table>
<br><br>
<table align="center" border='0' cellpadding='0' cellspacing='0'
			width='100%' align='center'>
					<tr>
							<td class='label' align='right'>
								<ibaBean:message key="com.iba.ehis.lc.linenItem"
									bundle="lcLabels" />
							</td>
							<td nowrap>
							 <input type="hidden" name="vo.issueOfLinenVO.linenItem" id="vo.issueOfLinenVO.linenItem"  />
							 <input type="text" name="vo.issueOfLinenVO.linenDesc" id="vo.issueOfLinenVO.linenDesc" readonly="true"  />
								<input type="hidden" name="linenItem" id="linenItem"  readonly="true" />
							</td>
						
							<td class='label' align='right'>
								<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestedQuantity" bundle="lcLabels" />
							</td>
							<td>
							<input type="hidden" name="vo.issueOfLinenVO.requestedQty" id="vo.issueOfLinenVO.requestedQty"  />
								<input type="text" readonly="true" name="qty" id="qty" size="10" onkeypress="checkNumber(this)" />

							</td>
						</tr>
						<tr>
							<td class='label' align='right'>
								<ibaBean:message key="com.iba.ehis.lc.requestForLinen.issuedQuantity" bundle="lcLabels" />
							</td>
							<td>
								<input type="text" readonly="true" name="iqty" id="iqty" onkeypress="checkNumber(this)" readonly="true" size="10" />

							</td>
						
							<td class='label' align='right'>
								<ibaBean:message key="com.iba.ehis.lc.issueOfLinen.currentIssueQuantity"
									bundle="lcLabels" />
							</td>
							<td>
								<input type="text" name="ciqty" id="ciqty" onkeyup="checkNumber(this)" maxlength ="10" size="10" onblur="checkQty1(this);checkStock()"/>
								<img src="framework/images/mandatory.gif"></img>

							</td>
						</tr>
	
						<tr>
							
							<td  class='label'  align='right'>
						<a href="javascript:#" onclick="test5popupactivate(this.id);return false;" name="prepAnchor" id="prepAnchor">
						<ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" /></a>
						<input type="hidden" name="remarkArea" id="remarkArea" value="" maxlength="2000"/>
						<input type="hidden" name="remark" id="remark" value="" maxlength="2000"/>
							</td>
							<td>
							&nbsp
							</td>
												
							<td align='right' class='button'>
								<input class='BUTTON'  type="button" name="select" id="select" value="<ibaBean:message key='com.iba.ehis.lc.selectforbutton' bundle='lcLabels' />" onClick="populateList();" />
								
							</td>
							<td>
							&nbsp
							</td>
							
						</tr>

		</table>

<br><br>
<table border='1' cellpadding='2' cellspacing='0' width='100%' id="tableid" align='center' >
						 <tr>
						 	<th align="left" colspan=5>
								<ibaBean:message key="com.iba.ehis.lc.linenItemDetail"
									bundle="lcLabels" />
							</th>
						 </tr>
						<tr>
						<th align="center" width="20%">
								<ibaBean:message key="com.iba.ehis.lc.linenItem"
									bundle="lcLabels" />
							</th>
							<th align="center" width="20%">
								<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestedQuantity"
									bundle="lcLabels" />
							</th>
							<th align="center" width="20%">
								<ibaBean:message key="com.iba.ehis.lc.requestForLinen.issuedQuantity"
									bundle="lcLabels" />
							</th>
							<th align="center" width="20%">
								<ibaBean:message key="com.iba.ehis.lc.issueOfLinen.currentIssueQuantity"
									bundle="lcLabels" />
							</th>
							<th align="center" width="20%">
								<ibaBean:message key="com.iba.ehis.lc.remark"
									bundle="lcLabels" />
							</th>

						</tr>
						
		</table>
		
		
		<div id="listContentLayer" align="center">
		
					<table border='1' cellpadding='2' cellspacing='0' width='100%'
						 id="contentTable" >
				 
					</table>
				</div>
				
		<br><br>
		<table align='center'>
						<tr>
						<td colspan='4'class='button' align='right'>
						<input type="button" class="BUTTON"  name="Submit" id="Submit" value="<ibaBean:message key='com.iba.ehis.lc.submit' bundle='lcLabels' />" onclick="issueNo();settime()" />
						</td>
						</tr>
		</table>

		<input type="hidden" name="vo.issueOfLinenVO.operatingFacilityId" id="vo.issueOfLinenVO.operatingFacilityId" value="<%=facilityId%>" />					
		<input type="hidden" name="vo.issueOfLinenVO.requestStatus" id="vo.issueOfLinenVO.requestStatus" />					
		<input type="hidden" name="vo.functionId" id="vo.functionId" value="<%=functionId%>" />
		<input type="hidden" name="vo.moduleId" id="vo.moduleId" value="<%=moduleId%>" />
		<input type="hidden" name="languageId" id="languageId" value="<%=locale%>" />
		<input type="hidden" name="vo.issueOfLinenVO.locale" id="vo.issueOfLinenVO.locale" value="<%=locale%>" />
		<input type="hidden" name="vo.mode" id="vo.mode" />
		<input type="hidden" name="vo.viewCode" id="vo.viewCode" value="linenIssue" />
	</ibaHTML:form>
	
</body>
<script type="">

document.getElementById("sourceDesc").value=dialogArguments[10]
document.getElementById("vo.issueOfLinenVO.sourceDesc").value=trimString(dialogArguments[10])
document.getElementById("vo.issueOfLinenVO.sourceType").value=trimString(dialogArguments[5])
document.getElementById("vo.issueOfLinenVO.sourceCode").value=trimString(dialogArguments[0])
document.getElementById("vo.issueOfLinenVO.requestNum").value=trimString(dialogArguments[1])
document.getElementById("vo.issueOfLinenVO.requestDate").value=trimString(dialogArguments[2])
document.getElementById("vo.issueOfLinenVO.raisedBy").value=trimString(dialogArguments[3])
document.getElementById("vo.issueOfLinenVO.linenItem").value=trimString(dialogArguments[6])
document.getElementById("vo.issueOfLinenVO.linenDesc").value=trimString(dialogArguments[9])
document.getElementById("vo.issueOfLinenVO.requestedQty").value=trimString(dialogArguments[7])
document.getElementById("linenItem").value=document.getElementById("vo.issueOfLinenVO.linenItem").value;

document.getElementById("qty").value=document.getElementById("vo.issueOfLinenVO.requestedQty").value;

issueQty();
sumQty();

	function checkStock(){
		var facilityId=document.getElementById("vo.issueOfLinenVO.operatingFacilityId").value;
		var linenItem=document.getElementById("vo.issueOfLinenVO.linenItem").value;
		linenItem=trimString(linenItem);
		MendingRequest.getStock(linenItem,facilityId,validateStock);
			function validateStock(data){
				var stock=0;
				var qty=document.getElementById("ciqty").value;
				for(prop in data)
					{
					 stock=data[prop];
					}
					
				if(parseInt(qty)>parseInt(stock)){
					 getServerMessage("com.iba.ehis.lc.issueOfLinen.currentIssueQuantity");
					 var label1=dwrMessage;
					 getServerMessage("com.iba.ehis.lc.withLaundry");
					 var label2=dwrMessage;
					 getServerMessage("messege.number.greatethan");
					 msg=dwrMessage;
					 msgArray=msg.split('#');
					 var obj=document.getElementById("ciqty")
					 obj.value="";
					//obj.setFocus();
					 var error=msgArray[0]+" "+ label1 + " " + msgArray[1] +" "+label2+" "+stock+"<br>";
					parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
								
					}
					
				}
			
	 }
</script>
</ibaHTML:html>

