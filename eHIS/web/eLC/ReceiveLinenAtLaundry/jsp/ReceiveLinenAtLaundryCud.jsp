<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page  import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.framework.core.util.IBADateTime,,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateValidation"%>
<%@ include file="/framework/html/Tag.text"%>
<%@ page import="com.iba.ehis.core.vo.AppVO"%>
<ibaHTML:html locale="true">
<head>
	<%
	
	String facilityId=(String)session.getAttribute("facility_id");
	String functionId = (String) request.getParameter("functionId");
	String moduleId = (String) request.getParameter("moduleId");
	String addedById = (String) session.getAttribute("login_user");
	String locale = (String) session.getAttribute("LOCALE");

	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";

		UserPreferences userPrefs =new UserPreferences();
		/* Cache cache = CacheManager.getCache();
		userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS);
		*/	//Commented Against AMRI-SCF-0679
		String timepattrn=userPrefs.getTimeFormat();
		String sb=userPrefs.getDateFormat();
		String pattern=sb+" "+timepattrn;
		
	%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />	<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/ReceiveLinenAtLaundry/js/ReceiveLinenAtLaundry1.js'/>
	<script type='text/javascript' src='/<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/ReceiveLinen.js'></script>
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	
<script type="text/javascript">
var contentList =new Hashtable();
var  testpopup5="";
var val="";
var selectFlag=false;;
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
testpopup5.populate('<title>Remark..</title><link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/core/css/<%=sStyle%>"></link><FORM><CENTER><table border="0" celpadding="0" cellspacing="0" width="100%" height="100%"><tr><td class="label" align="center"> Remark: </td></tr><tr><td  align="centet"><textarea rows=5 cols=40 maxlength=2000 name="remarkArea" onkeyup="window.opener.document.getElementById("remarkArea").value=this.value;window.opener.setval()">'+val+'</textarea></td></tr><tr><td  align="center"><input class="button" type="button" onclick="window.close();window.opener.setval()" value="OK"/></td></tr></table> </FORM></CENTER>');
testpopup5.showPopup(anchor);
setval();
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
		var convert1= date + "/" + mon + "/" + year;
		if(hrNow<10)
				hrNow="0"+hrNow;
		if(mnNow<10)
				mnNow="0"+mnNow;
		
		convert1=convert1+" "+hrNow+ ":" +mnNow;
		var rdate=document.getElementById("vo.receivedDate");
		rdate.value=convert1;
		if("<%=locale%>"!="en"){
		IBADateValidator.convertDateJS(convert1,"en","<%=locale%>","<%=pattern%>",RDFromcallbackMethod);
		function  RDFromcallbackMethod(fdate){
			document.getElementById("receivedDate").value=fdate;
		}
		}
		else
		{
		document.getElementById("receivedDate").value=convert1;
		}
		
}
  
//=============================================
 
</script>
 <IBATagLibs:initCalendar />
</head>
<body onload="ReceiveLinen.receiptNo('<%=facilityId%>',getReceiptNo);CurrDate();" OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<br><br>
	<ibaHTML:form action="/ReceiveLinenAtLaundryAction.do"	target="messageFrame" > 
		<table border='0 ' cellpadding='2' cellspacing='0' width='80%' align='center'>
				<tr>
						<td style="text-align: middle" class="label" colspan="1" NOWRAP>
								<ibaBean:message key="com.iba.ehis.lc.receiveLinenAtLaundry.receiptNum"	bundle="lcLabels" />
						</td>
						<td>
							 <ibaHTML:text property="vo.receiptNum" readonly="true" maxlength="10" size='8' />
							 <img src='<%=request.getContextPath()%>/framework/images/mandatory.gif'></img>
						</td>
						</tr>
				<tr>
						<td class='label'  nowrap="nowrap" align="left">
								<ibaBean:message key="com.iba.ehis.lc.receiveLinenAtLaundry.receivedDate"	bundle="lcLabels" />
						</td>
						<td>
							<input type="text" name="receivedDate" id="receivedDate" readonly="true" />
							<ibaHTML:hidden property="vo.receivedDate"/>
							<ibaHTML:hidden property="vo.receivedDate.pattern" value="dd/MM/yyyy HH:mm" />
							 <img src='<%=request.getContextPath()%>/framework/images/mandatory.gif'></img>
						</td>
							
				</tr>
				<tr>
							<td align="left" CLASS='label' nowrap="nowrap">
								<ibaBean:message
									key="com.iba.ehis.lc.receiveLinenAtLaundry.linenItem"
									bundle="lcLabels" />
							</td>
							<td nowrap>
							<input type="text" name="linenItemDesc" id="linenItemDesc" maxlength="30" onblur='linenItemLookup()' />
							<input type='button' class="BUTTON"  value='?' onclick='showLookup1()' />
							 <img src="<%=request.getContextPath()%>/framework/images/mandatory.gif"></img>
							  <input type="hidden" name="vo.linenItem" id="vo.linenItem"  />
							</td>
				</tr>
				<tr>
							<td align="left" width="30%" CLASS='label' nowrap="nowrap">
								<ibaBean:message
									key="com.iba.ehis.lc.receiveLinenAtLaundry.receivedQty"
									bundle="lcLabels" />
							</td>
							<td width="30%" colspan='3'>
							<ibaHTML:text property="vo.receivedQty" onkeyup="checkNumber1(this)"  />						
							<img src='<%=request.getContextPath()%>/framework/images/mandatory.gif'></img>
							</td>
				</tr>
				<tr>
							<td align="left" width="30%" CLASS='label' nowrap="nowrap">
								<ibaBean:message
									key="com.iba.ehis.lc.receiveLinenAtLaundry.receivedBy"
									bundle="lcLabels" />
							</td>
							<td width="30%" colspan='3'>
							<ibaHTML:text property="vo.receivedBy" maxlength="30" value="<%=addedById%>" onkeyup="checkAlpha(this.value)"/>						
							<img src='<%=request.getContextPath()%>/framework/images/mandatory.gif'></img>
						</td>
					</tr>
					<tr>
						<td align="left" width="30%" CLASS='label' nowrap="nowrap">
							<ibaBean:message
								key="com.iba.ehis.lc.receiveLinenAtLaundry.remarks"
								bundle="lcLabels" />
						</td>
						<td width="30%" colspan='3'>
						<ibaHTML:textarea property="vo.remarks" rows="4" cols="40" onkeyup="textAreaLimit(this,100);"/>
					</td>
				</tr>
					
		</table>
		<ibaHTML:hidden property="vo.addedFacilityId" value="<%=facilityId%>" />			
		<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>" />
		<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
		<ibaHTML:hidden property="locale" value="<%=locale%>" />
		<ibaHTML:hidden property="vo.mode" />
		<!-- <table align="center"><tr><td><input type="button" value="Submit" name="Submit" id="Submit" class="BUTTON" onclick="ReceiveLinen.receiptNo('<%=facilityId%>',setReqRefNo);settime()" /></td></tr></table> -->


		<table align="center"><tr><td><input type="button" value="<ibaBean:message key="com.iba.ehis.lc.submit"	bundle="lcLabels" />" name="Submit" class="BUTTON" onclick="ReceiveLinen.receiptNo('<%=facilityId%>',getReceiptNo);settime();" /></td></tr></table>
	</ibaHTML:form>
</body>
</ibaHTML:html>

