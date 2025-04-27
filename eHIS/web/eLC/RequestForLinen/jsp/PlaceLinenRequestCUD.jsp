<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.framework.core.util.IBADateTime,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateValidation" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.ehis.lc.core.vo.SourceBean"%>
<%@ include file="/framework/html/Tag.text"%>
<ibaHTML:html locale="true">
<head>
	<%
	String facilityId=(String)session.getAttribute("facility_id");
	String functionId = (String) session.getAttribute("functionId");
	String moduleId = (String) session.getAttribute("moduleId");
	String locale = (String) session.getAttribute("LOCALE");
  	String addedById = (String) session.getAttribute("login_user");

	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
				
		String value="y";

		UserPreferences userPrefs =new UserPreferences();
		/* Cache cache = CacheManager.getCache();
		userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */ //AMRI-SCF-0679
		
		SourceBean obj=new SourceBean();
	try
		{
			/* obj=(SourceBean)CacheManager.getCache().getObject(Constants.USER_SESSION_CACHE,				
					"sessid", "objKey"); */ //AMRI-SCF-0679
									
		}catch(Exception e){} 
	
		//AMRI-SCF-0679
	String srcType = (String) session.getAttribute("sourceType");
	String srctype = (String) session.getAttribute("sourcetype");
	String src = (String) session.getAttribute("source");
	String srcCode = (String) session.getAttribute("sourceCode");
	//AMRI-SCF-0679
		/* String src=obj.getSource();
		String srcType=obj.getSourceType();
		String srctype=obj.getSourcetype();
		String srcCode=obj.getSourceCode(); */	//AMRI-SCF-0679

		String timepattrn=userPrefs.getTimeFormat();
		String sb=userPrefs.getDateFormat();
		String pattern=sb+" "+timepattrn;

		IBADateTime date = new IBADateTime(request.getSession().getId());
		System.err.println("current Date--locale--->"+locale);
		System.err.println("current Date--date--->"+date);
		IBADateValidation ibaDateValidation = new IBADateValidation();
		String cdate = ibaDateValidation.convertDateJS(date.toString(),"en",locale,"dd/MM/yyyy HH:mm");
		System.err.println("current Date--cdate--->"+cdate);
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
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenRequest.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/RequestForLinen/js/RequestForLinen.js'></script>

<script type="text/javascript">
var contentList =new Hashtable();
var inuseQty=0;
var  testpopup5="";
var  testpopup4="";
var param="";
var val="";
var reqNo=0;
var required_Duplicate_Check = 0;

function checkLength()
{
var Tvalue=0;
obj=document.getElementById("remarkArea");
Tvalue=textAreaLimit(obj,100);
document.getElementById("remark").value=Tvalue;
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
testpopup5.height=200;
testpopup5.width=300;
testpopup5.offsetX=-10;
testpopup5.offsetY=10;
testpopup5.autoHide();

getServerMessage("com.iba.ehis.lc.remark")
var title=dwrMessage;
var title1=title+":"
var title2=title+".."
getServerMessage("com.iba.ehis.lc.ok")
var buttonTitle=dwrMessage;
testpopup5.populate('<title>'+title2+'</title><link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>"></link><FORM><table border="0" celpadding="0" cellspacing="0" width="100%" height="100%"><tr><td class="label" align="left">'+title1+'</td></tr><tr><td  align="center"><textarea rows=8 cols=40 maxlength=100 name="remarkArea" onkeyup="window.opener.document.getElementById("remarkArea").value=this.value;window.opener.setval();window.opener.checkLength()">'+val+'</textarea></td></tr><tr><td  align="center"><input class="button" type="button" onclick="window.close();window.opener.setval()" value="'+buttonTitle+'"/></td></tr></table> </FORM>');
testpopup5.showPopup(anchor);
setval();
}

function test5popupactivate1(anchor,index) {
var val=document.getElementById("vo.placeLinenRequestVO.linenRequest["+index+"].remark").value;
testpopup4 = new PopupWindow();
testpopup4.windowProperties="toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no";
testpopup4.height=200;
testpopup4.width=300;
testpopup4.offsetX=-10;
testpopup4.offsetY=10;
testpopup4.autoHide();

getServerMessage("com.iba.ehis.lc.remark")
var title=dwrMessage;
var title1=title+":"
var title2=title+".."
getServerMessage("com.iba.ehis.lc.ok")
var buttonTitle=dwrMessage;
testpopup4.populate('<title>'+title2+'</title><link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/core/css/<%=sStyle%>"></link><FORM><table border="0" celpadding="0" cellspacing="0" width="100%" height="100%"><tr><td class="label" align="left">'+title1+' </td></tr><tr><td  align="center"><textarea rows=10 cols=40 readonly=true name="remarkArea">'+val+'</textarea></td></tr><tr><td  align="center"><input class="button" type="button" onclick="window.close();" value="'+buttonTitle+'"/></td></tr></table> </FORM>');
testpopup4.showPopup(anchor);
}
//=============================================
function LinenViewVo(linenItem,linenItemDesc,qty,remark,flag) {
	this.linenItem = linenItem;
	this.linenItemDesc = linenItemDesc;
	this.qty = qty;
	this.remark = remark;
	if (flag == null) 
		flag = "createMethod";
	this.flag = flag;
}

function duplicateCheck(linenItem){
		var f1;
		var error="";
		for (var i in contentList.values()) {
			dataObj=contentList.values()[i];
			if(contentList.values()[i] != null){
				if(linenItem == dataObj.linenItem){
					getServerMessage("MESSAGE.OPERATION_FAILURE");
					error =dwrMessage;
					f1 = false;
				}
			}
		}	
		parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		if(f1==false) return false; else return true;
	}

function populateList() {
	var linenItem = document.RequestForLinenForm["linenItem"].value;
	var qty = document.RequestForLinenForm["qty"].value;
	var remark = document.RequestForLinenForm["remark"].value;
	var linenItemDesc = document.RequestForLinenForm["linenItemDesc"].value;

	if(linenItem != ''){
		if(required_Duplicate_Check != 1){
			var f1 = duplicateCheck(linenItem); if(f1 == false)return
		}
		viewObj = new LinenViewVo(linenItem,linenItemDesc,qty,remark)
		contentList.put(viewObj.linenItem,viewObj);
		showRecords();
	}
	document.RequestForLinenForm["linenItem"].value="";
	document.RequestForLinenForm["qty"].value="";
	document.RequestForLinenForm["remark"].value="";
	document.RequestForLinenForm["linenItemDesc"].value="";
	required_Duplicate_Check = 0;
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
				col1.width="30%";
				col1.align="left"
				var str = "";
				str = "<a href=\"javascript:pickupContent('" + dataObj.linenItem + "')\">";
				str += dataObj.linenItemDesc + "</a><input type='hidden' name='vo.placeLinenRequestVO.linenRequest[" + (index) + "].linenItem' id='vo.placeLinenRequestVO.linenRequest[" + (index) + "].linenItem' value='" + dataObj.linenItem + "'>" ;
				col1.innerHTML = str;
				var col3 = row.insertCell();
				col3.className = "QRYEVEN";
				col3.width="30%";
				col3.align="right"
				col3.innerHTML = dataObj.qty + "<input type='hidden' name='vo.placeLinenRequestVO.linenRequest[" + (index) + "].requestedQty' id='vo.placeLinenRequestVO.linenRequest[" + (index) + "].requestedQty' value='" + dataObj.qty + "'>";
				var col4 = row.insertCell();
				col4.className = "QRYEVEN";
				col4.width="30%";
				col4.align="left";
				var str1='<a href="" id="prepAnchor'+index+'" name="prepAnchor'+index+'" onclick="test5popupactivate1(this.id,'+index+');return false;">';
				str1+="Remark</a><input type='hidden' size=20 name='vo.placeLinenRequestVO.linenRequest[" + (index) + "].remark' id='vo.placeLinenRequestVO.linenRequest[" + (index) + "].remark' value='" + dataObj.remark + "'>" ;
				col4.innerHTML =str1;

			} else {
				var str = "<input type='hidden' name='vo.placeLinenRequestVO.linenRequest[" + index + "].linenItem' id='vo.placeLinenRequestVO.linenRequest[" + index + "].linenItem' value='" + dataObj.linenItem + "'>" + "<input type='hidden' name='vo.placeLinenRequestVO.linenRequest[" + (index) + "].requestedQty' id='vo.placeLinenRequestVO.linenRequest[" + (index) + "].requestedQty' value='" + dataObj.qty + "'>" + "<input type='hidden' name='vo.placeLinenRequestVO.linenRequest[" + (index) + "].remark' id='vo.placeLinenRequestVO.linenRequest[" + (index) + "].remark' value='" + dataObj.remark + "'>";
				document.getElementById("listContentLayer").innerHTML += str;
			}
			index++;
		}
	}
}

function pickupContent(linenItem) {
	
	var dataObj = contentList.get(linenItem);
	document.RequestForLinenForm["linenItem"].value =dataObj.linenItem;
	document.RequestForLinenForm["qty"].value = dataObj.qty;
	document.RequestForLinenForm["remark"].value = dataObj.remark;
	document.RequestForLinenForm["linenItemDesc"].value = dataObj.linenItemDesc;
	dataObj.flag="createMethod"
	showRecords()
	required_Duplicate_Check = 1;
}

function cancelRecord(){
			var linenItem=document.RequestForLinenForm["linenItem"].value
		
			var obj = contentList.get(linenItem)
			if(obj !=null){
				if(obj.flag != "createMethod"){
					obj.flag="deleteMethod"
					 contentList.put(linenItem,obj)
				}else{
					contentList.remove(linenItem)
				}
			}
				showRecords();
		}	
function getLoginUserPlaceLinen(){
		var userId ='<%=session.getAttribute("login_user")%>';
		RequestForCleaning.getLoggedInUser("<%=locale%>",userId,callLoggedInUserPlaceLinen);
	}
function callLoggedInUserPlaceLinen(data){
		for(prop in data){
			document.getElementById("vo.placeLinenRequestVO.raisedBy").value = prop;
		}
	}
function getRequestNumber1(data){
	var obj=document.getElementById("vo.placeLinenRequestVO.requestNum");
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
		obj.value=parseInt(max)+1;
		
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
			apply();}
			else{
				getServerMessage("com.iba.ehis.lc.atleastselectthelinenitem");
			alert(dwrMessage)
			}
		}
	}


/*function setDate(cdate){
	document.getElementById("vo.placeLinenRequestVO.requestDate").value=cdate;
}	*/


function setSourceType(){
	var src= document.getElementById("sourceType").value;
	if(src=="Nursing Unit" || src=="th Nursing Unit")
		document.getElementById("vo.placeLinenRequestVO.sourceType").value='W';
		document.getElementById("vo.placeLinenRequestVO.sourceCode").value='<%=srcCode%>';
	if(src=="Clinic" || src=="th Clinic")
		document.getElementById("vo.placeLinenRequestVO.sourceType").value='C';
		document.getElementById("vo.placeLinenRequestVO.sourceCode").value='<%=srcCode%>';
	if(src=="Department" || src=="th Department")
	   document.getElementById("vo.placeLinenRequestVO.sourceType").value='D';
		document.getElementById("vo.placeLinenRequestVO.sourceCode").value='<%=srcCode%>';
} 
 
</script>
 <IBATagLibs:initCalendar />
</head>
<body onload="RequestForCleaning.getLinenReqNo('<%=facilityId%>',getRequestNumber1);getLoginUserPlaceLinen()" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<br>
	<ibaHTML:form action="/RequestForLinenAction.do"	target="messageFrame">
		<table border='0 ' cellpadding='2' cellspacing='0' width='95%' align='center'>
			<tr>
				<td class='label'  align="right" nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestNum"	bundle="lcLabels" />
				</td>
				<td nowrap="nowrap">
					 <ibaHTML:text property="vo.placeLinenRequestVO.requestNum" readonly="true" size="10" />
					 <img src="framework/images/mandatory.gif"></img>
				</td>
				<td class='label'  align="right" nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestDate"	bundle="lcLabels" />
				</td>
				<td nowrap="nowrap">
					<input type="text" name="requestDate" id="requestDate" value='<%=cdate%>' readonly="true" />
					<ibaHTML:hidden property="vo.placeLinenRequestVO.requestDate" value='<%=date.toString()%>'/>
					<!--  modified By DhanasekarV for weblogic server -->
					<ibaHTML:hidden property="vo.placeLinenRequestVO.requestDate.pattern" value="dd/MM/yyyy HH:mm"/>
					<img src="framework/images/mandatory.gif"></img>
				</td>
			</tr>
			<tr>
				<td align="right" width="30%" CLASS='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.standardStock.sourceType" bundle="lcLabels" />
				</td>
				<td width="30%" nowrap="nowrap">
					<input type=text name="sourceType" id="sourceType" maxlength="10" readonly="true" value="<%=srcType%>"/>
					 <ibaHTML:hidden property="vo.placeLinenRequestVO.sourceType"/>
					 <img src="framework/images/mandatory.gif"></img>
				</td>
				<td align="right" width="20%" CLASS='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.standardStock.source" bundle="lcLabels" />
				</td>
				<td width="40%" nowrap="nowrap" >
					<input type=text name="sourceCode" id="sourceCode" maxlength="30" readonly="true" value="<%=src%>" />
					<ibaHTML:hidden property="vo.placeLinenRequestVO.sourceCode"/>
					<img src="framework/images/mandatory.gif"></img>
				</td>
			</tr>
			<tr>
				<td class='label'  nowrap="nowrap" align="right">
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.raisedBy"	bundle="lcLabels" />
				</td>
				<td class='label' nowrap="nowrap">
					 <ibaHTML:text property="vo.placeLinenRequestVO.raisedBy" maxlength="30" value="<%=addedById%>"/>
					 <img src="framework/images/mandatory.gif"></img>
				</td>
				<td></td><td></td>
					<ibaHTML:hidden property="vo.placeLinenRequestVO.requestStatus" value="OS" />					
				</tr>
		</table>
	<br><br>
	<table border='0 ' cellpadding='2' cellspacing='0' width='95%' align='center'>
	<tr>
		<td class='label' align="right" nowrap="nowrap">
			<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
		</td>
		<td nowrap class='button' >
			<input type="hidden" name="linenItem" id="linenItem"  />
			<input type="text" name="linenItemDesc" id="linenItemDesc" maxlength="30" onblur='linenItemLookup()' />					
			<input type='button' class="BUTTON"  value='?' onclick='showLookup1()' />
		   <img src="framework/images/mandatory.gif"></img>
		</td>
		<td class='label' align="right" nowrap="nowrap">
			<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestedQuantity" bundle="lcLabels" />
		</td>
		<td class='label'>
			<input type="text" name="qty" id="qty" onkeyup="checkNumber1(this)"  maxlength ="8" size="8"/>
			 <img src="framework/images/mandatory.gif"></img>
		</td>
	</tr>
	<tr>
		<td colspan="4" class='label' align="right">
			<a href="javascript:#" onclick="test5popupactivate(this.id);return false;" name="prepAnchor" id="prepAnchor">
			<ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" /></a>
			<input type="hidden" name="remarkArea" id="remarkArea" value="" maxlength="100"/>
			<input type="hidden" name="remark" id="remark" value="" maxlength="100"/>
		</td>
	</tr>
	<tr>
		<td class='label' align="right">
		<td colspan="4" align='right'>
			<input class="BUTTON" type="button" name="select" id="select" value="<ibaBean:message key='com.iba.ehis.lc.selectforbutton' bundle='lcLabels' />" onClick='checkStock();' />
			<input class="BUTTON" type="button" name="cancel" id="cancel" value="<ibaBean:message key='com.iba.ehis.lc.cancel' bundle='lcLabels' />" onClick="cancelRecord()" />
		</td>
	</tr>
</table>
	<br><br>
	<table border='1' cellpadding='2' cellspacing='0' width='95%' id="tableid" align='center' >
		 <tr>
			<td  colspan=3 >
				<b><ibaBean:message key="com.iba.ehis.lc.linenItemDetail" bundle="lcLabels" /></b>
			</td>
		 </tr>
		<tr>
			<th align="center" width="30%">
				<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
			</th>
			<th align="center" width="30%">
				<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestedQuantity" bundle="lcLabels" />
			</th>
			<th align="center" width="30%">
				<ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" />
			</th>
		</tr>
	</table>
		<div id="listContentLayer" align="center">
			<table border='1' cellpadding='2' cellspacing='0' width='95%' id="contentTable"/>
		</div>
			<ibaHTML:hidden property="vo.operatingFacilityId" value="<%=facilityId%>" />					
			<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>" />
			<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
			<input type="hidden" name="languageId" id="languageId" value="<%=locale%>" />
			<ibaHTML:hidden property="vo.mode" />
			<ibaHTML:hidden property="vo.viewCode" value="placeLinenRequestFrame" />
			<table align="center">
		<tr>
			<td>
			<input type="button" value="<ibaBean:message key='com.iba.ehis.lc.submit' bundle='lcLabels' />" name="Submit" class="BUTTON"  onmouseover="" onclick="RequestForCleaning.getLinenReqNo('<%=facilityId%>',getRequestNumber1);settime();" />
			</td>
		</tr>
	</table>
	</ibaHTML:form>
</body>
<script> 
		setSourceType();
</script>
</ibaHTML:html>

