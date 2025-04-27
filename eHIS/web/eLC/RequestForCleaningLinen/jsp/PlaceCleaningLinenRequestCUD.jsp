<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.framework.core.util.IBADateTime,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateValidation" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.ehis.core.vo.AppVO"%>
<%@ page  import="com.iba.framework.cache.pojo.business.CacheManager"%>
<%@ page  import="com.iba.ehis.lc.core.vo.SourceBean"%>
<%@ include file="/framework/html/Tag.text"%>
<ibaHTML:html locale="true">
<head>
	<%
	String facilityId=(String)session.getAttribute("facility_id");
	String functionId = (String) request.getParameter("functionId");
	String moduleId = (String) request.getParameter("moduleId");
	String loggedInUser = (String) session.getAttribute("login_user");
	String dirtyFlag=(String) request.getParameter("dirtyFlag");
	String flag=(String) request.getParameter("flag");
	String cutoffTime=(String)request.getParameter("cutoffTime");
	String delParamDate=(String)request.getParameter("delParamDate");
	String userFlag=(String)request.getParameter("userFlag");
	String requestDate = (String) request.getParameter("requestDate");
	String locale = (String) session.getAttribute("LOCALE");
	
	
	//out.println("userFlag" +userFlag);
	//out.println("dirtyFlag" +dirtyFlag);

	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
			//Object obj=null;

		UserPreferences userPrefs =new UserPreferences();
		/* Cache cache = CacheManager.getCache();
		userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */
	//AMRI-SCF-0679
		userPrefs.setDateFormat("dd/MM/yyyy") ;
		userPrefs.setTimeFormat("HH:mm");
		userPrefs.setLocale("en");
		//AMRI-SCF-0679
						
		String timepattrn=userPrefs.getTimeFormat();
		String sb=userPrefs.getDateFormat();
		String pattern=sb+" "+timepattrn;
	
		IBADateTime todate=LcDateFormat.convertDateFormat(null,request);
		IBADateValidation ibaDateValidation = new IBADateValidation();
		String cdate = ibaDateValidation.convertDateJS(todate.toString(),locale,"en",pattern);

		
		SourceBean obj=new SourceBean();
	/*	try
			{
				obj=CacheManager.getCache().getObject(Constants.USER_SESSION_CACHE,				
						"sessid", "objKey");
			}catch(Exception e){out.println("Cache timed out..");} */

		try
		{
			obj=(SourceBean)CacheManager.getCache().getObject(Constants.USER_SESSION_CACHE,"sessid", "objKey");
									
		}catch(Exception e){} 
	
		String src=obj.getSource();
		String srcType=obj.getSourceType();
		request.setAttribute("srcType",srcType);
		request.setAttribute("src",src);
		request.setAttribute("userFlag",userFlag);
	
	
		String srctype=obj.getSourcetype();
		String srcCode=obj.getSourceCode();



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
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/RequestForCleaningLinen/js/RequestForCleaningLinen.js'></script>

<IBATagLibs:initCalendar />
</head>
<script>

var contentList =new Hashtable();
var  testpopup5="";
var val="";
function setval()
{
val=document.getElementById("remarkArea").value;
document.getElementById("remark").value=val;
}
function test5popupactivate(anchor) {
testpopup5 = new PopupWindow();
getServerMessage("com.iba.ehis.lc.remark")
var title=dwrMessage;
var title1=title+":"
var title2=title+".."

val=document.getElementById("remark").value;
document.getElementById("remarkArea").value=val;
testpopup5.windowProperties="toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no";
testpopup5.height=200;
testpopup5.width=300;
testpopup5.offsetX=-10;
testpopup5.offsetY=10;
testpopup5.autoHide();
getServerMessage("com.iba.ehis.lc.ok")
var buttonLabel=dwrMessage;
testpopup5.populate('<title>'+title2+'</title><link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>"></link><FORM><table border="0" celpadding="0" cellspacing="0" width="100%" height="100%"><tr><td class="label" align="left"> '+title1+' </td></tr><tr><td  align="center"><textarea rows=8 cols=40 name="remarkArea" onkeyup="window.opener.document.getElementById("remarkArea").value=this.value;window.opener.setval();window.opener.checkLength()">'+val+'</textarea></td></tr><tr><td  align="center"><input class="button" type="button" onclick="window.close();window.opener.setval()" value="'+buttonLabel+'"/></td></tr></table> </FORM>');


testpopup5.showPopup(anchor);
setval();
}


function test5popupactivate1(anchor,index) {
var val=document.getElementById("vo.placeCleaningLinenRequestVO.cleanLinenRequest["+index+"].remark").value;
testpopup4 = new PopupWindow();
getServerMessage("com.iba.ehis.lc.remark")
var title=dwrMessage;
var title1=title+":"
var title2=title+"..."

testpopup4.windowProperties="toolbar=no,location=no,status=no,menubar=no,scrollbars=auto,resizable=no,alwaysRaised,dependent,titlebar=no";
testpopup4.height=200;
testpopup4.width=300;
testpopup4.offsetX=-10;
testpopup4.offsetY=10;
testpopup4.autoHide();
getServerMessage("com.iba.ehis.lc.ok")
var buttonLabel=dwrMessage;
testpopup4.populate('<title>'+title2+'</title><link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/core/css/<%=sStyle%>"></link><FORM><table border="0" celpadding="0" cellspacing="0" width="100%" height="100%"><tr><td class="label" align="left">'+title1+'</td></tr><tr><td  align="center"><textarea rows=8 cols=40 readonly=true name="remarkArea">'+val+'</textarea></td></tr><tr><td  align="center"><input class="button" type="button" onclick="window.close();" value="'+buttonLabel+'"/></td></tr></table> </FORM>');
testpopup4.showPopup(anchor);
setval();
}
function checkLength()
{
var Tvalue=0;
obj=document.getElementById("remarkArea");
Tvalue=textAreaLimit(obj,100);
document.getElementById("remark").value=Tvalue;
}

function callLaundryUser(rec)
{
	for (prop in rec)
	{
		
		if (prop!=null)
		{
			
			var userId ='<%=session.getAttribute("login_user")%>';
			if(prop!=userId)
			{
			
			document.getElementById("category").disabled=true;
			}
		}
	}
}
function getLoginUserPlaceLinen(){
		var userId ='<%=session.getAttribute("login_user")%>';
		RequestForCleaning.getLoggedInUser("<%=locale%>",userId,callLoggedInUserPlaceLinen);
	}
function callLoggedInUserPlaceLinen(data){
		for(prop in data){
			if(prop!=null){
			document.getElementById("vo.placeCleaningLinenRequestVO.linenHandedOverBy").value = prop;}
		}
	}
function checkNumber1(obj) {
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
function checkAlpha(){
	  	 obj =  String.fromCharCode(window.event.keyCode);
	   	var alphaFilter =/^[a-z_A-Z]+$/;
	   	if (!(alphaFilter.test(obj))) { 
	   	getServerMessage("messages.Alphabet");
		parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+dwrMessage;
	   	window.event.keyCode = 27;
   		}
   	}

function showLookup() {
	var sourceType=document.getElementById("vo.placeCleaningLinenRequestVO.sourceType").value;
	var facilityId=document.getElementById("vo.operatingFacilityId").value;
	var languageId=document.getElementById("languageId").value;
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array(facilityId,languageId);
	var datatypesArray = new Array();
	if(sourceType=="W")
		{	argArray[0] = "ehis.lc.standardStock.nursingUnit"
		
		}
		else if(sourceType=="C")
		{	argArray[0] = "ehis.lc.standardStock.clinic"
		}
		else if(sourceType=="D")
		{	
			argArray[0] = "ehis.lc.standardStock.deptCode"
		}
	
		namesArray[0]="facilityId";
		namesArray[1]="languageId";
	
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] =document.getElementById("sourceDesc").value;
	retArr = Lookup("SourceCode", argArray);
	var txtUser = document.getElementById("vo.placeCleaningLinenRequestVO.sourceCode");
	var txtUser1 = document.getElementById("sourceDesc");
	
	if(retArr!=null)
			{
			//Set the data in to the fields
			txtUser.value = retArr[0];
			txtUser1.value= retArr[1];
			}
	
} 

	
function showLookup1() {

	var sourceType=document.getElementById("vo.placeCleaningLinenRequestVO.sourceType").value;
	var sourceCode=document.getElementById("vo.placeCleaningLinenRequestVO.sourceCode").value;
   	var languageId=document.getElementById("languageId").value;

	var flag=true;
 	var error="";
 	var fieldName = new Array(
		"com.iba.ehis.lc.standardStock.sourceType",
		"com.iba.ehis.lc.standardStock.source");
	var fields = new Array(sourceType,sourceCode);
	var key_value= new Array();

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
			parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
 	}

	if(flag==true){
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	
	argArray[0] = "ehis.lc.requestForLinen.getlinen"
	namesArray[0]="sourceType";
	namesArray[1]="sourceCode";
	namesArray[2]="languageId";

	valuesArray[0]=sourceType;
	valuesArray[1]=sourceCode;
	valuesArray[2]=languageId;

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
			//Display Order
	argArray[3] = DESC_CODE;

			// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] =document.getElementById("linenItem1").value;
	getServerMessage("com.iba.ehis.lc.linenitemcode");
	retArr = Lookup(dwrMessage, argArray);
	
	if(retArr!=null)
			{
			//Set the data in to the fields
			var linenTxt=document.getElementById("linenItem");
			linenTxt.value = retArr[0];
			document.getElementById("linenItem1").value=retArr[1];
			}
	}
	
}		


function checkStock()
 {
	var sourceType=document.getElementById("vo.placeCleaningLinenRequestVO.sourceType").value;
	var sourceCode=document.getElementById("vo.placeCleaningLinenRequestVO.sourceCode").value;
	var facilityId=document.getElementById("vo.operatingFacilityId").value;
	var linenItem=document.getElementById("linenItem").value;
	var reqQty=document.getElementById("qty").value;
	var scheduleDate=document.getElementById("scheduleDeliveryDate").value;
	var flag=true;
 	var error="";
 	var fieldName = new Array("com.iba.ehis.lc.linenItem", "com.iba.ehis.lc.requestForLinen.requestedQuantity","com.iba.ehis.lc.requestForCleaningLinen.scheduleDeliveryDate");
	var fields = new Array(linenItem,reqQty,scheduleDate);
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
	if(flag==true){
	RequestForCleaning.getSrcStock(sourceType,sourceCode,linenItem,facilityId,getInUseQty);
	function getInUseQty(data)
	{	
	  var qty=parseInt(document.getElementById("qty").value); 
	
		for(prop in data)
		 var stock=prop
		
		if(parseInt(qty)>parseInt(stock))
		{			//alert("if")
 		 getServerMessage("com.iba.ehis.lc.requestForLinen.requestedQuantity");
		 var label1=dwrMessage;
		 getServerMessage("com.iba.ehis.lc.stdStock");
		 var label2=dwrMessage;
		 getServerMessage("messege.number.greatethan");
		 msg=dwrMessage;
		 msgArray=msg.split('#');
		 var obj=document.getElementById("qty")
			obj.value="";
			
		 var error=msgArray[0]+" "+ label1 + " " + msgArray[1] +""+label2+" "+stock+"<br>";
	 	parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		}else{
			//alert("ELSE")
			 populateList();
			}
		
		}
		}
 }

 function setSourceType(){
	 if('<%=userFlag%>' == 'Y'){
		document.getElementById("sourceType").value=document.getElementById("vo.placeCleaningLinenRequestVO.sourceType").value;
	 }
	
 }

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
	
	
	if(arg=='P')
	{
		var rdate=document.getElementById("vo.placeCleaningLinenRequestVO.requestDate");
		rdate.value=convert1;

		IBADateValidator.convertDateJS(convert1,"en","<%=locale%>","<%=pattern%>",RDFromcallbackMethod);
			function  RDFromcallbackMethod(fdate){
				document.getElementById("requestDate").value=fdate;
			}
	}
}
function convertSDate2En()
{
   var languageId= document.getElementById("languageId").value;
  var tdate=document.getElementById("scheduleDeliveryDate");
  IBADateValidator.convertDateJS(tdate.value,languageId,"en",'dd/MM/yyyy HH:mm',RDTocallbackMethod9);
  function  RDTocallbackMethod9(ldate){

	  document.getElementById("vo.placeCleaningLinenRequestVO.scheduleDeliveryDate").value=ldate;
	
	} 
  
}

</script>

<body onload="CurrDate('P');RequestForCleaning.getReqNo('<%=facilityId%>',getRequestNumber);getLoginUserPlaceLinen();setSourceType()" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<ibaHTML:form action="/RequestForCleaningLinenAction.do" target="messageFrame">
 
 	<table border='0 ' cellpadding='2' cellspacing='0' width='95%' align='center'>
		<tr>
			<td class='label'  nowrap="nowrap" align='right'>
				<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestNum"	bundle="lcLabels" />
			</td>
			<td nowrap="nowrap">
				<ibaHTML:text property="vo.placeCleaningLinenRequestVO.requestNum" readonly="true" maxlength="10" size="10"/>
				<img src="framework/images/mandatory.gif"></img>
			</td>
			<td class='label'  nowrap="nowrap" align='right'>
				<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestDate"	bundle="lcLabels" />
			</td>
			<td nowrap="nowrap">
				<input type="text" name="requestDate" id="requestDate" readonly="true" />
				<input type=hidden name="vo.placeCleaningLinenRequestVO.requestDate" id="vo.placeCleaningLinenRequestVO.requestDate" value="<%=cdate%>"/>
				<input type=hidden name="vo.placeCleaningLinenRequestVO.requestDate.pattern" id="vo.placeCleaningLinenRequestVO.requestDate.pattern" value="dd/MM/yyyy HH:mm" />
				<img src="framework/images/mandatory.gif"></img>
			</td>
		</tr>
		<tr>
			<td align='right' width="30%" class='label' nowrap="nowrap">
				<ibaBean:message key="com.iba.ehis.lc.standardStock.sourceType" bundle="lcLabels" />
			</td>
			<td width="30%" nowrap="nowrap">
			
			<ibaLogic:equal value="Y" scope="request" name="userFlag"> 
				<select name="vo.placeCleaningLinenRequestVO.sourceType" id="vo.placeCleaningLinenRequestVO.sourceType" onchange="setSource()" onblur="setSource()">
					<option value="W"><ibaBean:message key="com.iba.ehis.lc.ward" bundle="lcLabels" />
					</option>
					<option value="C"><ibaBean:message key="com.iba.ehis.lc.clinic" bundle="lcLabels" />
					</option>
					<option value="D"><ibaBean:message key="com.iba.ehis.lc.department" bundle="lcLabels" />
					</option>
				</select>
				<input type=hidden name="sourceType" id="sourceType"/> 
			</ibaLogic:equal>   
			<ibaLogic:equal value="N" scope="request" name="userFlag"> 
					 <input type=text name="sourceType" id="sourceType" maxlength="10" readonly="true" value="<%=srcType%>"/> 
			</ibaLogic:equal> 	
			 <ibaHTML:hidden property="vo.placeCleaningLinenRequestVO.sourceType" value="<%=srctype%>"/>
			<img src="framework/images/mandatory.gif"></img>
			</td>
			<td align='right'width="20%" class='label' nowrap="nowrap">
				<ibaBean:message key="com.iba.ehis.lc.standardStock.source" bundle="lcLabels" />
			</td>
			<td width="40%" nowrap="nowrap" >
				<ibaLogic:equal value="N" scope="request" name="userFlag"> 
					<input type=text name="sourceDesc" id="sourceDesc" maxlength="10" readonly="true" value="<%=src%>"/>
				</ibaLogic:equal>
				<ibaLogic:equal value="Y" scope="request" name="userFlag"> 
					<input type="text" name="sourceDesc" id="sourceDesc" maxlength="30" />
					<input type='button' class="BUTTON"  value='?' onclick='showLookup()' />
				 </ibaLogic:equal>
				 <ibaHTML:hidden property="vo.placeCleaningLinenRequestVO.sourceCode"  value="<%=srcCode%>" />
				<img src="framework/images/mandatory.gif"></img>
			</td>
		</tr>
		<tr>
			<td class='label'  nowrap="nowrap" align='right' nowrap="nowrap">
				<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.linenHandedOverBy"	bundle="lcLabels" />
			</td>
			<td class='label' >
				<ibaHTML:text property="vo.placeCleaningLinenRequestVO.linenHandedOverBy" readonly="true" maxlength="30"/>
				<img src="framework/images/mandatory.gif"></img>
			</td>
			<td class='label'  nowrap="nowrap" align='right'>
				<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.linenCollectedBy"	bundle="lcLabels" />
			</td>
			<td class='label' >
				<ibaHTML:text property="vo.placeCleaningLinenRequestVO.linenCollectedBy" onkeypress="checkAlpha()" maxlength="30"  />
				<img src="framework/images/mandatory.gif"></img>
			</td>
		</tr>
	</table>
<br><br>
	<table align="center" border='0' cellpadding='0' cellspacing='0' width='95%' align='center'>
		<tr>
			<td class='label' align='right' nowrap="nowrap" >
				<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
			</td>
			<td nowrap class='button'>
				<input type="hidden" name="linenItem" id="linenItem"  />
				<input type="text" name="linenItem1" id="linenItem1" maxlength="30" onblur='linenItemLookup()' />
				<input type='button' class="BUTTON"  value='?' onclick='showLookup1()' />
				<img src="framework/images/mandatory.gif"></img>
			</td>
				<td class='label' align='right' nowrap="nowrap">
				<ibaBean:message key="com.iba.ehis.lc.Category" bundle="lcLabels" />
			</td>
			<td>
				<select name="category" id="category" >	
						<ibaLogic:equal value="Y" scope="request" parameter="dirtyFlag">  
						<ibaLogic:equal value="Y" scope="request" parameter="userFlag">
						
					<option value="D">
						<ibaBean:message key="com.iba.ehis.lc.dirty" bundle="lcLabels" />
					</option>
					</ibaLogic:equal>  
					</ibaLogic:equal>  
						<ibaLogic:equal value="Y" scope="request" parameter="dirtyFlag">  
						<ibaLogic:equal value="N" scope="request" parameter="userFlag">  
					<option value="S">
						<ibaBean:message key="com.iba.ehis.lc.soiled" bundle="lcLabels" />
					</option>
					<option value="I">
						<ibaBean:message key="com.iba.ehis.lc.infected"	bundle="lcLabels" />
					</option>
					<option value="V">
						<ibaBean:message key="com.iba.ehis.lc.seriouslyInfected" bundle="lcLabels" />	
					</ibaLogic:equal>
					</ibaLogic:equal>
						<ibaLogic:equal value="N" scope="request" parameter="dirtyFlag">  
						<ibaLogic:equal value="N" scope="request" parameter="userFlag">  
					<option value="D">
						<ibaBean:message key="com.iba.ehis.lc.dirty" bundle="lcLabels" />
					</option>
					<option value="S">
						<ibaBean:message key="com.iba.ehis.lc.soiled" bundle="lcLabels" />
					</option>
					<option value="I">
						<ibaBean:message key="com.iba.ehis.lc.infected"	bundle="lcLabels" />
					</option>
					<option value="V">
						<ibaBean:message key="com.iba.ehis.lc.seriouslyInfected" bundle="lcLabels" />	
					</option>	
					</ibaLogic:equal>
					</ibaLogic:equal>
				</select>
			</td>
		</tr>
		<tr>
			<td class='label' align='right' nowrap="nowrap">
				<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestedQuantity" bundle="lcLabels" />
			</td>
			<td>
				<input type="text" name="qty" id="qty" maxlength ="10" onkeyup="checkNumber1(this)" />
				<img src="framework/images/mandatory.gif"></img>
			</td>
			<td class='label'  nowrap="nowrap" align='right'>
			<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.scheduleDeliveryDate"	bundle="lcLabels" />
		</td>
		<td nowrap="nowrap">
		    <input type=text name="scheduleDeliveryDate" id="scheduleDeliveryDate" onkeydown="assignDate(this,false);" onkeypress="assignDate(this,false);" onblur="isValidDate(this);checkDate1();"><a onclick="return showCal('scheduleDeliveryDate', '%d/%m/%Y %H:%M', 24, true,'itemValueid');" name='.itemValueid' id='itemValueid'>
			<img id="c1"   src="<%=request.getContextPath()%>/framework/images/img.gif" onmouseout="checkDate1();"/></a>
			<img src="framework/images/mandatory.gif"></img>
			<input type="hidden" name="vo.placeCleaningLinenRequestVO.scheduleDeliveryDate" id="vo.placeCleaningLinenRequestVO.scheduleDeliveryDate" />
			<input type='hidden' name='vo.placeCleaningLinenRequestVO.scheduleDeliveryDate.pattern' id='vo.placeCleaningLinenRequestVO.scheduleDeliveryDate.pattern' value='dd/MM/yyyy HH:mm'>
		</td>
	</tr>
	<tr>
		<td class='label' align='right' nowrap="nowrap">
			<a href="javascript:test5popupactivate(this.id)" onclick="test5popupactivate(this.id);return false;" name="prepAnchor" id="prepAnchor">
			<ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" /></a>
			<input type="hidden" name="remarkArea" id="remarkArea" value="" maxlength="100" size="100"/>
			<input type="hidden" name="remark" id="remark" value="" maxlength="100" size="100"/>
		</td>
		<td>
		&nbsp
		</td>
		<td  align='right'>
			<input class="BUTTON" type="button" name="select" id="select" value="<ibaBean:message key='com.iba.ehis.lc.selectforbutton' bundle='lcLabels' />" onfocus="checkDate1();" onClick="checkStock();" onmouseover="checkDate1();convertSDate2En()" />
			<input class="BUTTON" type="button" name="cancel" id="cancel" value="<ibaBean:message key='com.iba.ehis.lc.cancel' bundle='lcLabels' />" onClick="cancelRecord()"  />
		</td>
		<td>
		&nbsp
		</td>
	</tr>
</table>
<br><br>
	<table border='1' cellpadding='2' cellspacing='0' width='95%' id="tableid" align='center' >
		<tr>
			<td  colspan=5>
				<b><ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" /></b>
			</td>
		</tr>
		<tr>
			<th align="center" width="20%">
				<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
			</th>
			<th  align='center' width="20%">
				<ibaBean:message key="com.iba.ehis.lc.Category"	bundle="lcLabels" />
			</th>
			<th align="center" width="20%">
				<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestedQuantity" bundle="lcLabels" />
			</th>
			<th align='center' width="20%">
				<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.scheduleDeliveryDate"	bundle="lcLabels" />
			</th>
			<th align="center" width="20%">
				<ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" />
			</th>
		</tr>
	</table>
		<div id="listContentLayer" align="center">
			<table border='1' cellpadding='2' cellspacing='0' width='95%' id="contentTable" ></table>
		</div>
			<ibaHTML:hidden property="vo.placeCleaningLinenRequestVO.requestStatus" value="OS" />		
			<ibaLogic:equal value="Y" scope="request" name="userFlag"> 
			<ibaHTML:hidden property="vo.placeCleaningLinenRequestVO.countConfirmedYn" value="N"/>
			</ibaLogic:equal> 
			<ibaLogic:equal value="N" scope="request" name="userFlag"> 
			<ibaHTML:hidden property="vo.placeCleaningLinenRequestVO.countConfirmedYn"/>
			</ibaLogic:equal> 
			
			<ibaHTML:hidden property="vo.placeCleaningLinenRequestVO.flag" value="<%=flag%>" />
			<ibaHTML:hidden property="vo.CleaningRequestsListVO.countConfirmedBy" value="<%=loggedInUser%>" />
			<ibaHTML:hidden property="vo.CleaningRequestsListVO.countConfirmedDate" value="<%=todate.toString()%>" />
			<!--  Modify by DhanasekarV for weblogic -->
			<ibaHTML:hidden property="vo.CleaningRequestsListVO.countConfirmedDate.pattern" value="dd/MM/yyyy HH:mm" />
			
			<input type=hidden name="cutoffTime" id="cutoffTime"  value="<%=cutoffTime%>"/>
			<input type=hidden name="delParamDate" id="delParamDate"  value="<%=delParamDate%>"/>
			<input type="hidden" name="languageId" id="languageId" value="<%=locale%>" />
			<input type="hidden" name="sourcType" id="sourcType" value="<%=srcType%>" />
			<input type="hidden" name="srctype1" id="srctype1" value="<%=srctype%>" />
			<input type="hidden" name="sourcCode" id="sourcCode" value="<%=srcCode%>" />
			<input type="hidden" name="userFlag" id="userFlag" value="<%=userFlag%>" />

			
			<ibaHTML:hidden property="vo.operatingFacilityId" value="<%=facilityId%>" />		
			<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>" />
			<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />									
			<ibaHTML:hidden property="vo.mode" />

			<ibaHTML:hidden property="vo.viewCode" value="placeCleanLinenRequestFrame" />
			<table align="center"><tr><td><input type="button" value="<ibaBean:message key='com.iba.ehis.lc.submit' bundle='lcLabels' />" name="Submit" class="BUTTON" onclick="RequestForCleaning.getReqNo('<%=facilityId%>',getRequestNumber);settime();" /></td></tr></table>
	</ibaHTML:form>
<script>
var rdate="";
var rtime="";
var sdate="";


 
function setScheduledeliverydate()
{
RequestForCleaning.getDeltime("<%=facilityId%>",getAllRDeliveryTimes);
var incr=1;
var mode=0;
function getAllRDeliveryTimes(Data)
	{
	for(prop in Data)
	{

		for(prop1 in Data[prop]){
					var  receiptDate=Data[prop][0]	
					var receiptDate2=Data[prop][1]
					var receiptDate3=Data[prop][2]
					var delDate=Data[prop][3]
					var delDate2=Data[prop][4]
					var delDate3=Data[prop][5]
					var dayNo=Data[prop][6]
					var dayNo2=Data[prop][7]
					var dayNo3=Data[prop][8]
					var noOfCutOfTiming=Data[prop][9]
					
				}}
		//alert(noOfCutOfTiming)
		if(noOfCutOfTiming=='0')
		{
		//document.getElementById("scheduleDeliveryDate").style.visibility="hidden";
		document.getElementById("vo.placeCleaningLinenRequestVO.scheduleDeliveryDate").value="";
		document.getElementById("c1").style.visibility="visible";
		}else
		{
			
			document.getElementById("c1").style.visibility="hidden";
			document.getElementById("c1").disabled=true;
			document.getElementById("vo.placeCleaningLinenRequestVO.scheduleDeliveryDate").readOnly=true;
			document.getElementById("scheduleDeliveryDate").readOnly=true;
			
			var t2=CurrDate1();
			var rdate=t2+" "+receiptDate;
			var rDate=document.getElementById("vo.placeCleaningLinenRequestVO.requestDate").value;
			//alert("req"+rdate+"   cur"+rDate)
			IBADateValidator.isDateTimeGreaterThanJS(rdate,rDate,'en',callBackFunction1);
			function callBackFunction1(data)
				{//alert("check--1-->"+data)
				if(data==null){data=false;}
				if(data==true)
					{

					var t2=CurrDate1();
					var sdate=t2+" "+delDate;
					document.getElementById("vo.placeCleaningLinenRequestVO.scheduleDeliveryDate").value=sdate;
					 var languageId= document.getElementById("languageId").value;
					 IBADateValidator.convertDateJS(sdate,"en",languageId,'dd/MM/yyyy HH:mm',RDTocallbackMethod);
						function  RDTocallbackMethod(ldate)
						  {
						 document.getElementById("scheduleDeliveryDate").value=ldate;
						  } 
					
					}else if(receiptDate2!="")
					{
						var t1=CurrDate1();
						receiptDate2=t1+" "+receiptDate2
						IBADateValidator.isDateTimeGreaterThanJS(receiptDate2,rDate,'en',callBackFunction2);
						function callBackFunction2(data)
						{
						//alert("incr="+incr)
						if(incr==1){
						//alert("check--2-->"+data)
						if(data==""||data==undefined){data=false;}
						if(data==true)
							{
							
							if(dayNo2!="")
								{
								sdate=addDay(dayNo2,delDate2);
								}
								else
								{
									var c1=CurrDate1();
									sdate=c1+" "+delDate2;
								}
								//alert("Condition(2)=====>Date::"+sdate)
								document.getElementById("vo.placeCleaningLinenRequestVO.scheduleDeliveryDate").value=sdate;
								 var languageId= document.getElementById("languageId").value;
								 IBADateValidator.convertDateJS(sdate,"en",languageId,'dd/MM/yyyy HH:mm',RDTocallbackMethod1);
									function  RDTocallbackMethod1(ldate)
									  {
									 document.getElementById("scheduleDeliveryDate").value=ldate;
									  } 

								mode++;
							
							}
							else if(receiptDate3!=null)
								{
								var t2=CurrDate1();
								receiptDate3=t2+" "+receiptDate3
								IBADateValidator.isDateTimeGreaterThanJS(receiptDate3,rDate,'en',callBackFunction3);
									function callBackFunction3(data)
										{
										//alert("check--3-1->"+data)
										if(data==null){data=false;}
										if(data==true)
											{
											if(dayNo3!="")
												{
												sdate=addDay(dayNo3,delDate3);
												}
												else
												{	var c1=CurrDate1();
													sdate=c1+" "+delDate3;
												}
												//alert("Condition(3)==1===>Date::"+sdate)
												document.getElementById("vo.placeCleaningLinenRequestVO.scheduleDeliveryDate").value=sdate;
												 var languageId= document.getElementById("languageId").value;
												 IBADateValidator.convertDateJS(sdate,"en",languageId,'dd/MM/yyyy HH:mm',RDTocallbackMethod2);
													function  RDTocallbackMethod2(ldate)
													  {
													 document.getElementById("scheduleDeliveryDate").value=ldate;
													  } 
								
											
											}
											else{
												
												   dayNo=parseInt(dayNo)+1;
													sdate=addDay(dayNo,delDate);
												//	alert("Condition(3)==1=else:-"+sdate);
													document.getElementById("vo.placeCleaningLinenRequestVO.scheduleDeliveryDate").value=sdate;
													 var languageId= document.getElementById("languageId").value;
														 IBADateValidator.convertDateJS(sdate,"en",languageId,'dd/MM/yyyy HH:mm',RDTocallbackMethod3);
															function  RDTocallbackMethod3(ldate)
															  {
															 document.getElementById("scheduleDeliveryDate").value=ldate;
															  } 
													
												}
										
										}
								}else{
									//alert("check--else-1->")
										//alert(incr)
											if(dayNo==0){
											var facilityId='<%=facilityId%>';
											RequestForCleaning.getScheduleDate(facilityId,getsDate);
												function getsDate(d1)
												{
													for(prop in d1)
													{
													var dd=d1[prop];
													 dd=dd+" "+delDate;
													document.getElementById("vo.placeCleaningLinenRequestVO.scheduleDeliveryDate").value=dd;
													var languageId= document.getElementById("languageId").value;
													 IBADateValidator.convertDateJS(dd,"en",languageId,'dd/MM/yyyy HH:mm',RDTocallbackMethod4);
														function  RDTocallbackMethod4(ldate)
														  {
														 document.getElementById("scheduleDeliveryDate").value=ldate;
														  } 

													}
												}
											}
											else 
												{
													dayNo=parseInt(dayNo)+1;
													sdate=addDay(dayNo,delDate);
													document.getElementById("vo.placeCleaningLinenRequestVO.scheduleDeliveryDate").value=sdate;
													 var languageId= document.getElementById("languageId").value;
													 IBADateValidator.convertDateJS(sdate,"en",languageId,'dd/MM/yyyy HH:mm',RDTocallbackMethod5);
														function  RDTocallbackMethod5(ldate)
														  {
														 document.getElementById("scheduleDeliveryDate").value=ldate;
														  } 
												}

									}
							incr=incr+1;
							}
						}
					}else if(receiptDate3!="")
						{
								var t2=CurrDate1();
								receiptDate3=t2+" "+receiptDate3
								IBADateValidator.isDateTimeGreaterThanJS(receiptDate3,rDate,'en',callBackFunction4);
									function callBackFunction4(data)
										{
									//	alert("check--3-2->"+data)
										if(data==null){data=false;}
										if(data==true)
											{
											if(dayNo3!="")
												{
												sdate=addDay(dayNo3,delDate3);
												}
												else
												{	var c1=CurrDate1();
													sdate=c1+" "+delDate3;
												}
											//	alert("Condition(3)==1===>Date::"+sdate)
											document.getElementById("vo.placeCleaningLinenRequestVO.scheduleDeliveryDate").value=sdate;
											 var languageId= document.getElementById("languageId").value;
												 IBADateValidator.convertDateJS(sdate,"en",languageId,'dd/MM/yyyy HH:mm',RDTocallbackMethod6);
													function  RDTocallbackMethod6(ldate)
													  {
													 document.getElementById("scheduleDeliveryDate").value=ldate;
													  } 
	
											
											}
											else{
												
												   dayNo=parseInt(dayNo)+1;
													sdate=addDay(dayNo,delDate);
												//	alert(sdate);
													document.getElementById("vo.placeCleaningLinenRequestVO.scheduleDeliveryDate").value=sdate;
													 var languageId= document.getElementById("languageId").value;
													 IBADateValidator.convertDateJS(sdate,"en",languageId,'dd/MM/yyyy HH:mm',RDTocallbackMethod7);
														function  RDTocallbackMethod7(ldate)
														  {
														 document.getElementById("scheduleDeliveryDate").value=ldate;
														  } 
													
												}
										
										}
								}
								else{
									//alert("check--else-2->")
										var facilityId='<%=facilityId%>';
										RequestForCleaning.getScheduleDate(facilityId,getsDate);
										function getsDate(d1)
										{
											for(prop in d1)
											{
											var dd=d1[prop];
											 dd=dd+" "+delDate;
											document.getElementById("vo.placeCleaningLinenRequestVO.scheduleDeliveryDate").value=dd;
											 var languageId= document.getElementById("languageId").value;
											 IBADateValidator.convertDateJS(dd,"en",languageId,'dd/MM/yyyy HH:mm',RDTocallbackMethod8);
												function  RDTocallbackMethod8(ldate)
												  {
												 document.getElementById("scheduleDeliveryDate").value=ldate;
												  } 
											}
										}
									}
		

						}
		}
}

		
	
}
setScheduledeliverydate();

	</script>
</body>
</ibaHTML:html>

