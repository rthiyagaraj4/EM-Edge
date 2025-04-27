<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateTime,com.iba.framework.core.util.IBADateValidation" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.ehis.lc.core.vo.SourceBean"%>
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
			.getAttribute("PREFERRED_STYLE"): "IeStyle.css";
		
		if (sStyle == null)
		sStyle = "IeStyle.css";
		String qryEven = "QRYEVEN";
		String qryOdd = "QRYODD";

		UserPreferences userPrefs =new UserPreferences();
			/* Cache cache = CacheManager.getCache();
			userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */
			String datepattrn=userPrefs.getDateFormat();
			String sb=userPrefs.getDateFormat();
			String tf=userPrefs.getTimeFormat();
			String pattern=sb+" "+tf;
			//String locale=userPrefs.getLocale();
		
			IBADateTime todate=LcDateFormat.convertDateFormat(null,request);
			IBADateValidation ibadateVal = new IBADateValidation();
			String conDate = (String)ibadateVal.convertDateJS(todate.toString(),"en",locale,"dd/MM/yyyy HH:mm");
		//	out.println("conDate="+conDate);

		SourceBean obj=new SourceBean();
		try
		{
			/* obj=(SourceBean)CacheManager.getCache().getObject(Constants.USER_SESSION_CACHE,				
					"sessid", "objKey"); */
									
		}catch(Exception e){} 
	
	//AMRI-SCF-0679
	String srcType = (String) session.getAttribute("sourceType");
	String srctype = (String) session.getAttribute("sourcetype");
	String src = (String) session.getAttribute("source");
	String srcCode = (String) session.getAttribute("sourceCode");
	//AMRI-SCF-0679
		/* String src=obj.getSource();
		String srcType=obj.getSourceType(); */
		request.setAttribute("srcType",srcType);
		request.setAttribute("src",src);
		//request.setAttribute("userFlag",userFlag);
		/* String srctype=obj.getSourcetype();
		String srcCode=obj.getSourceCode(); */
	%>

<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/ReturnofLinentoLaundry.js'></script>
	<Script language="JavaScript" src="<%=request.getContextPath()%>/eLC/ReturnofLinentoLaundry/js/ReturnofLinentoLaundry.js"></Script>
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>


<IBATagLibs:initCalendar />
</head>
<script type="text/javascript">

	var contentList =new Hashtable();
	var  testpopup5="";
	var  testpopup4="";
	var val="";
	var required_Duplicate_Check = 0;
	
// **********************************************************************************************
	
	function checkLength()
	{
	var Tvalue=0;
	obj=document.getElementById("remarkArea");
	Tvalue=textAreaLimit(obj,100);
	document.getElementById("remark").value=Tvalue;
	}
	
// **********************************************************************************************
	
	function setval()
	{
	val=document.getElementById("remarkArea").value;
	document.getElementById("remark").value=val;
	}
	
// **********************************************************************************************
	
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
	var buttonLable=dwrMessage;

	testpopup5.populate('<title>'+title2+'</title><link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>"></link><FORM><CENTER><table border="0" celpadding="0" cellspacing="0" width="100%" height="100%"><tr><td class="label" align="center">'+title1+'</td></tr><tr><td  align="center"><textarea rows=8 cols=40 maxlength=2000 name="remarkArea" onkeyup="window.opener.document.getElementById("remarkArea").value=this.value;window.opener.setval();window.opener.checkLength()">'+val+'</textarea></td></tr><tr><td  align="center"><input class="button" type="button" onclick="window.close();window.opener.setval()" value="'+buttonLable+'"/></td></tr></table> </FORM></CENTER>');
	testpopup5.showPopup(anchor);
	setval();
	}

// **********************************************************************************************
	
	function test5popupactivate1(anchor,index)
		 {
			var val=document.getElementById("vo.linenRequest["+index+"].remark").value;
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
			var buttonLable=dwrMessage;

			testpopup4.populate('<title>'+title2+'</title><link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>"></link><FORM><CENTER><table border="0" celpadding="0" cellspacing="0" width="100%" height="100%"><tr><td class="label" align="center"> '+title1+' </td></tr><tr><td  align="center"><textarea rows=8 cols=40 readonly=true name="remarkArea">'+val+'</textarea></td></tr><tr><td  align="center"><input class="button" type="button" onclick="window.close();" value="'+buttonLable+'"/></td></tr></table> </FORM></CENTER>');
			testpopup4.showPopup(anchor);
		}
		
// **********************************************************************************************

	function LinenViewVo(linenItem,linenItemDesc,qty,remark,flag) {
		this.linenItem = linenItem;
		this.linenItemDesc = linenItemDesc;
		this.qty = qty;
		this.remark = remark;
		if (flag == null) 
			flag = "createMethod";
		this.flag = flag;
	}
	
// **********************************************************************************************
		
	function getAvailbleQty1(){
		var facility_id = document.getElementById("vo.operatingFacilityId").value;
		var sourceType = document.getElementById("vo.sourceType").value;
		var sourceCode = document.getElementById("vo.sourceCode").value;
		var linenItemCode = document.getElementById("linenItem").value;
		var qty = document.ReturnofLinentoLaundryForm["qty"].value;
			
	    ReturnofLinentoLaundry.getAvailQty(facility_id,sourceType,sourceCode,linenItemCode,callAvailQty1)
	}
	
// *******************************************************************************************
	
	function callAvailQty1(data){
		var availQty=0;
		for(prop in data){
			availQty = data[prop];
			if(availQty==null)availQty=0;
				checkQty(availQty);
				}
			}


// **************************************************************************
		
	function populateList() {
		var flag = "";
		var linenItem = document.ReturnofLinentoLaundryForm["linenItem"].value;
		var qty = document.ReturnofLinentoLaundryForm["qty"].value;
		var remark = document.ReturnofLinentoLaundryForm["remark"].value;
		var linenItemDesc = document.ReturnofLinentoLaundryForm["linenItemDesc"].value;
				
		if(NullCheckLinenItem()== true){
		if(linenItem != ''){
			
			if(required_Duplicate_Check == 1){
				
				var f1 = duplicateCheck(linenItem);
				if(f1 == false)return
			}

			viewObj = new LinenViewVo(linenItem,linenItemDesc,qty,remark)
			contentList.put(viewObj.linenItem,viewObj);
			showRecords();
			}
		
		required_Duplicate_Check = 0;
		}
	}
// **********************************************************************************************
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
			parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
			if(f1==false) return false; else return true;
		}
		

// **********************************************************************************************

	function deleteRows() {
		var tableObj = document.getElementById("contentTable");
		var len = tableObj.rows.length;
		for (i = len - 1; i != -1; i--) {
			tableObj.deleteRow(i);
		}
	}
	
// **********************************************************************************************

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
					col1.align="left";
					var str = "";
					str = "<a href=\"javascript:pickupContent('" + dataObj.linenItem + "')\">";
					str += dataObj.linenItemDesc + "</a><input type='hidden' name='vo.linenRequest[" + (index) + "].linenItem' id='vo.linenRequest[" + (index) + "].linenItem' value='" + dataObj.linenItem + "'>" ;
					col1.innerHTML = str;
					var col3 = row.insertCell();
					col3.className = "QRYEVEN";
					col3.width="30%";
					col3.align="right";
					col3.innerHTML = dataObj.qty + "<input type='hidden' name='vo.linenRequest[" + (index) + "].returnedQty' id='vo.linenRequest[" + (index) + "].returnedQty' value='" + dataObj.qty + "'>";
					var col4 = row.insertCell();
					col4.className = "QRYEVEN";
					col4.width="30%";
					col4.align="left";
					var str1='<a href="" id="prepAnchor'+index+'" name="prepAnchor'+index+'" onclick="test5popupactivate1(this.id,'+index+');return false;">';
					str1+="Remark</a><input type='hidden' size=20 name='vo.linenRequest[" + (index) + "].remark' id='vo.linenRequest[" + (index) + "].remark' value='" + dataObj.remark + "'>" ;
					col4.innerHTML =str1;
	
				} else {
					var str = "<input type='hidden' name='vo.linenRequest[" + index + "].linenItem' id='vo.linenRequest[" + index + "].linenItem' value='" + dataObj.linenItem + "'>" + "<input type='hidden' name='vo.linenRequest[" + (index) + "].returnedQty' id='vo.linenRequest[" + (index) + "].returnedQty' value='" + dataObj.qty + "'>" + "<input type='hidden' name='vo.linenRequest[" + (index) + "].remark' id='vo.linenRequest[" + (index) + "].remark' value='" + dataObj.remark + "'>";
					document.getElementById("listContentLayer").innerHTML += str;
				}
				index++;
			}
		}
	}
	
// **********************************************************************************************

	function pickupContent(linenItem) {
		
		var dataObj = contentList.get(linenItem);
		document.getElementById("linenItem").value =dataObj.linenItem;
		document.getElementById("qty").value = dataObj.qty;
		document.getElementById("remark").value = dataObj.remark;
		document.getElementById("linenItemDesc").value = dataObj.linenItemDesc;
		dataObj.flag="createMethod"
		showRecords()
		required_Duplicate_Check = 1;
	}
	
// *******************************************************************************************************
function cancelRecord(){
			var linenItem=document.getElementById("linenItem").value
		
			var obj = contentList.get(linenItem)
			if(obj !=null){
				if(obj.flag != "createMethod"){
					obj.flag="deleteMethod"
					 contentList.put(linenItem,obj)
				}else{
					contentList.remove(linenItem)
					required_Duplicate_Check = 0;
				}
			}
				showRecords();
		}	


// ************************  CHECK AVAILABLE STOCK BEFORE SELECT *************************
			
	function checkQty(avail){
		
		var qty = document.getElementById("qty").value;	
		if(avail == '0'){
		}if(qty > 0 && qty <= avail){
				
				populateList();
			}		
		}
	function cleardata(obj)
	{
		if(obj.value=="")
		{
			 document.getElementById("vo.sourceCode").value="";	
			// alert(document.getElementById("vo.sourceCode").value)
		}
	}
function settime()
{
 window.setTimeout(AlertMsg,1000);	
}
function AlertMsg()
{
	var obj=document.getElementById("vo.referenceNum");
	var tableObj = document.getElementById("contentTable");
	var len = tableObj.rows.length;
	var flag=checkNullLocal();
	if(flag==true)
		{
				if(parseInt(len)>0)
				{getServerMessage("com.iba.ehis.lc.pnyrequestNum");
				 alert(dwrMessage+" "+":"+obj.value);	
				 apply1();
				}
				else{
					getServerMessage("com.iba.ehis.lc.atleastselectthelinenitem");
					alert(dwrMessage);}
				
		}
}
function convertSDate2En()
{
   var languageId= document.getElementById("languageId").value;
  var tdate=document.getElementById("requestDate");
  IBADateValidator.convertDateJS(tdate.value,languageId,"en",'dd/MM/yyyy HH:mm',RDTocallbackMethod9);
  function  RDTocallbackMethod9(ldate){

	  document.getElementById("vo.requestDate").value=ldate;
	
	} 
  
}
//============== check for numeric values  ==========
 function checkNumber1(val){
		  obj =  String.fromCharCode(window.event.keyCode);
		var alphaFilter =/^[0-9]+$/;
		if (!(alphaFilter.test(obj))) {
		getServerMessage("message.Numbers.Allowed");
		parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
		window.event.keyCode = 27;
		val.value="";
		}
			 
	}	
</script>
<body OnLoad="CurrDate();getReferenceNumber();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">

	<ibaHTML:form action="/ReturnofLinentoLaundryAction.do" target="messageFrame">
		<table border='0 ' cellpadding='2' cellspacing='0' width='90%' align='center'>
			<tr>
				<td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td align="right" CLASS='label'>
				<ibaBean:message key="com.iba.ehis.lc.standardStock.sourceType" bundle="lcLabels" />
					
					</td>
						<td class='label' nowrap="nowrap">
						
							<input type=text name="sourceType" id="sourceType" maxlength="10" readonly="true" value="<%=srcType%>"/>
							 <ibaHTML:hidden property="vo.sourceType" value="<%=srctype%>"/>
							<td class='label' nowrap="nowrap">
							<ibaBean:message key="com.iba.ehis.lc.returnoflinentolaundry.source" bundle="lcLabels" />
							</td>
							<td>
							<input type='text' name="returnSourceDesc" id="returnSourceDesc" value="<%=src%>" readonly />
							<ibaHTML:hidden property="vo.sourceCode" value="<%=srcCode%>" />
							<img src="framework/images/mandatory.gif"></img>
						</td>
						
				<td></td>
					</tr>
				<tr>
					<td class='label' align="right">
						<ibaBean:message key="com.iba.ehis.lc.returnoflinentolaundry.ref.Num" bundle="lcLabels" />
					</td>
					<td class='label' >
					 <ibaHTML:text property="vo.referenceNum" maxlength="10" size="10" readonly="true"/>
					 <img src="framework/images/mandatory.gif"></img>
					</td>
					<td class='label' align="right">
						<ibaBean:message key="com.iba.ehis.lc.returnoflinentolaundry.date"	bundle="lcLabels" />
					</td>
					<!-- <td>
						<ibaHTML:IBACalendarInput property="vo.requestDate" readonly="true" format="%d/%m/%Y %H:%M" />
						 <img src="framework/images/mandatory.gif"></img>
					</td> -->
					<td class='label' nowrap="nowrap">
						<input type=text name="requestDate" id="requestDate" value="<%=conDate%>" size="18" readonly="true" onkeydown="assignDate(this,false);" onkeypress="assignDate(this,false);" /><a onclick="return showCal('requestDate', '%d/%m/%Y %H:%M', true, true,'cutOffTimeForLinenRecptid');" name='.cutOffTimeForLinenRecptid' id='cutOffTimeForLinenRecptid'><img src="<%=request.getContextPath()%>/framework/images/img.gif"></a><input type='hidden' name='vo.requestDate.pattern' id='vo.requestDate.pattern' value='dd/MM/yyyy HH:mm'>
						<img src='framework/images/mandatory.gif'></img>
						 <ibaHTML:hidden property="vo.requestDate" value="<%=todate.toString()%>"/>
					</td>
				</tr>
				<tr >
					<td class='label' align="right">
						<ibaBean:message key="com.iba.ehis.lc.returnoflinentolaundry.returnedby" bundle="lcLabels" />
					</td>
					<td class='label'>
					 <ibaHTML:text property="vo.returnedBy" value="<%=addedById%>" readonly="true"  maxlength="30" size="30"/>
					 <img src="framework/images/mandatory.gif"></img>
				</td>
				<td>
				</td>
				<td>
				</td>
			</tr>	
			<tr>
				<td class='label' align="right">
					<ibaBean:message key="com.iba.ehis.lc.returnoflinentolaundry.receivedby" bundle="lcLabels" />
				</td>
				<td class='label' >
					<ibaHTML:text property="vo.receivedBy"   maxlength="30" size="30" />
					<img src="framework/images/mandatory.gif"></img>
				</td>
					<td>
					</td>
						<td>
					</td>
				</tr>	
			<tr>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
			</tr>
		</table>
<br>
	 <table align="center" border='0' cellpadding='0' cellspacing='0' width='90%' align='center'>
		<tr>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
			</tr>
		<tr>
			<td class='label' align="right">
				<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
			</td>
			<td nowrap class='button' >
				<input type="text" name="linenItemDesc" id="linenItemDesc" onblur='showLookupLinenItem()' />							
				<input type="hidden" name="linenItem" id="linenItem"  />
				<input type='button' class="BUTTON"  value='?' onclick='linenItemLookup()' />
				 <img src="framework/images/mandatory.gif"></img>
			</td>
			<td class='label' align="right">
				<ibaBean:message key="com.iba.ehis.lc.returnoflinentolaundry.returnedQuantity" bundle="lcLabels" />
			</td>
			<td class='label'>
				<input type="text" name="qty" id="qty" maxlength="8" size="8" onkeypress="checkNumber1(this);"onblur="getAvailbleQty();"/>
				 <img src="framework/images/mandatory.gif"></img>
				<a href="javascript:#" onclick="test5popupactivate(this.id);return false;" name="prepAnchor" id="prepAnchor">
				<ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" /></a>
				<input type="hidden" name="remarkArea" id="remarkArea" value="" maxlength="100"/>
				<input type="hidden" name="remark" id="remark" value="" maxlength="100"/>
			</td>
		</tr>
			<tr>
			<td class='label' align="right">
			<td colspan="4" align='right'>
				<input class="BUTTON" type="button" name="select" id="select" value="<ibaBean:message key='com.iba.ehis.lc.selectforbutton' bundle='lcLabels' />" onClick="checkNullLocal();getAvailbleQty1()" onmouseover="convertSDate2En()"/>
				<input class="BUTTON" type="button" name="cancel" id="cancel" value="<ibaBean:message key='com.iba.ehis.lc.cancel' bundle='lcLabels' />" onClick="cancelRecord()" />
			</td>
		</tr>
	</table>
<br>
	  <table border='0' cellpadding='2' cellspacing='0' width='90%' id="tableid" align='center' >
		 <tr>
			<td  colspan=3>
				<b><ibaBean:message key="com.iba.ehis.lc.linenItemDetail" bundle="lcLabels" /></b>
			</td>
		 </tr>
		 <tr>
			<th align="center" width="30%">
				<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
			</th>
			<th align="center" width="30%">
				<ibaBean:message key="com.iba.ehis.lc.returnoflinentolaundry.returnedQty" bundle="lcLabels" />
			</th>
			<th align="center" width="30%">
				<ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" />
			</th>
		</tr>
	</table>
		<div id="listContentLayer" align="center">
			<table border='1' cellpadding='2' cellspacing='0' width='90%' id="contentTable"/>
		</div>
		<input type="hidden" name="vo.operatingFacilityId" id="vo.operatingFacilityId" value="<%=facilityId%>" />		
		<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>" />
		<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
		<input type="hidden" name="languageId" id="languageId" value="<%=locale%>" >
		<input type="hidden" name="vo.locale" id="vo.locale" value="<%=locale%>" >
		<ibaHTML:hidden property="vo.mode" />
		<table align="center">
		<tr>
			<td>
			<input type="button" value="<ibaBean:message key='com.iba.ehis.lc.submit' bundle='lcLabels' />" name="Submit" class="BUTTON" onclick="getReferenceNumber();settime()" />
			</td>
		</tr>
		</table>
	</ibaHTML:form>
</body>
</ibaHTML:html>

