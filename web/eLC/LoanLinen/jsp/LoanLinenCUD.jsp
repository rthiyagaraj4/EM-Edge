<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.framework.core.util.IBADateTime,,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateValidation" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.ehis.lc.core.vo.SourceBean"%>
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
	String srcType=obj.getSourceType();
	String srctype=obj.getSourcetype();
	String srcCode=obj.getSourceCode(); */

	UserPreferences userPrefs =new UserPreferences();
		/* Cache cache = CacheManager.getCache();
		userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */
		
		String timepattrn=userPrefs.getTimeFormat();
		String sb=userPrefs.getDateFormat();
		String pattern=sb+" "+timepattrn;

		IBADateTime todate=LcDateFormat.convertDateFormat(null,request);
		IBADateValidation ibaDateValidation = new IBADateValidation();
		String cdate = ibaDateValidation.convertDateJS(todate.toString(),"en",locale,pattern);
	
	%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LoanLinen.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenRequest.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/LoanLinen/js/loanedLinen.js'></script>
		<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>

<script type="text/javascript">
var contentList =new Hashtable();
var  testpopup5="";
var val="";

function setval()
{
val=document.getElementById("remarkArea").value;
document.getElementById("vo.loanLinenVO.remarks").value=val;
}
function test5popupactivate(anchor) {
if(testpopup5=="")
{
 testpopup5 = new PopupWindow();
}
val=document.getElementById("vo.loanLinenVO.remarks").value;
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
testpopup5.populate('<title>'+title2+'</title><link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>"></link><FORM><CENTER><table border="0" celpadding="0" cellspacing="0" width="100%" height="100%"><tr><td class="label" align="left">'+title1+'</td></tr><tr><td  align="center"><textarea rows=8 cols=40 maxlength=100 name="remarkArea" onkeyup="window.opener.document.getElementById("remarkArea").value=this.value;window.opener.setval()">'+val+'</textarea></td></tr><tr><td  align="center"><input class="button" type="button" onclick="window.close();window.opener.setval()" value="'+buttonLable+'"/></td></tr></table> </FORM></CENTER>');
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
 function setReasonDesc()
 {
	var val=document.getElementById("vo.loanLinenVO.reasonDesc").value;
	document.getElementById("vo.loanLinenVO.reasonCode").value=val;
}
function CurrDate(arg){	
		var currDate = new Date();
		var date = currDate.getDate();
		var mon = currDate.getMonth();
		var hrNow = currDate.getHours();
		var mnNow = currDate.getMinutes();
		var scNow = currDate.getSeconds();
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
		if(arg=='C')
		{
			var rdate=document.getElementById("vo.loanLinenVO.loanDate");
			rdate.value=reqToDate;

			IBADateValidator.convertDateJS(reqToDate,"en","<%=locale%>","<%=pattern%>",RDFromcallbackMethod);
			function  RDFromcallbackMethod(fdate){
				document.getElementById("loanDate").value=fdate;
		}
	}
	
}
function setSourceType(){
	var src= document.getElementById("sourceType").value;
	if(src=="Nursing Unit" || src=="th Nursing Unit")
		document.getElementById("vo.loanLinenVO.sourceType").value='W';
		document.getElementById("vo.loanLinenVO.sourceCode").value='<%=srcCode%>';
	if(src=="Clinic" || src=="th Clinic")
		document.getElementById("vo.loanLinenVO.sourceType").value='C';
		document.getElementById("vo.loanLinenVO.sourceCode").value='<%=srcCode%>';
	if(src=="Department" || src=="th Department")
	   document.getElementById("vo.loanLinenVO.sourceType").value='D';
		document.getElementById("vo.loanLinenVO.sourceCode").value='<%=srcCode%>';
} 


//================================================

</script>
 <IBATagLibs:initCalendar />
</head>
<body  onload="CurrDate('C');LoanLinen.getLoanRefNum(getRequestNumber)" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">

	<ibaHTML:form action="/LoanLinenAction.do"	target="messageFrame" > 
		<table border='0 ' cellpadding='2' cellspacing='0' width='100%' align='center'>
				<tr>
						<td class='label'  nowrap="nowrap" align="right">
								<ibaBean:message key="com.iba.ehis.lc.loanLinen.loanrefNo"	bundle="lcLabels" />
						</td>
						<td nowrap="nowrap">
							 <ibaHTML:text property="vo.loanLinenVO.loanRefNum" maxlength="10" size="10" readonly="true"/>
							 <img src="framework/images/mandatory.gif"></img>
						</td>
						<td class='label'  nowrap="nowrap" align="right">
							<ibaBean:message key="com.iba.ehis.lc.loanLinen.loanDate"	bundle="lcLabels" />
						</td>
						<td class='label' nowrap="nowrap" >
							
							<input type="text" name="loanDate" id="loanDate" readonly="true" />
							<ibaHTML:hidden property="vo.loanLinenVO.loanDate"/>
							<ibaHTML:hidden property="vo.loanLinenVO.loanDate.pattern" value="dd/MM/yyyy HH:mm" />
							
							<img src="framework/images/mandatory.gif"></img>
						</td>
					</tr>
				<tr>
							<td align="right" width="30%" CLASS='label' nowrap="nowrap">
								<ibaBean:message key="com.iba.ehis.lc.standardStock.sourceType" bundle="lcLabels" />
							</td>
							<td width="30%" nowrap="nowrap">
							
						

							<input type=text name="sourceType" id="sourceType"  readonly="true" value="<%=srcType%>"/>
							 <ibaHTML:hidden property="vo.loanLinenVO.sourceType" />
								<img src="framework/images/mandatory.gif"></img>
							</td>
						
							<td align="right" width="20%" CLASS='label' nowrap="nowrap">

							<ibaBean:message key="com.iba.ehis.lc.standardStock.source" bundle="lcLabels" />
								
							</td>
							<td width="40%" nowrap="nowrap" >
							<input type=text name="sourceCode" id="sourceCode" readonly="true" value="<%=src%>" />
							<ibaHTML:hidden property="vo.loanLinenVO.sourceCode" />
											
							<img src="framework/images/mandatory.gif"></img>
							</td>
						</tr>
						<tr>
							<td align="right" width="30%" CLASS='label' nowrap="nowrap">
								<ibaBean:message
									key="com.iba.ehis.lc.loanLinen.loanTo"
									bundle="lcLabels" />
							</td>
							<td width="30%"nowrap="nowrap" >
							<ibaHTML:select property="vo.loanLinenVO.loanedToSourceType" onchange="setClearLoan();">
							<ibaHTML:option value="W"><ibaBean:message key="com.iba.ehis.lc.ward" bundle="lcLabels" />
							</ibaHTML:option>
							<ibaHTML:option value="C"><ibaBean:message key="com.iba.ehis.lc.clinic" bundle="lcLabels" />
							</ibaHTML:option>
							<ibaHTML:option value="D"><ibaBean:message key="com.iba.ehis.lc.department" bundle="lcLabels" />
							</ibaHTML:option>
							<ibaHTML:option value="P"><ibaBean:message key="com.iba.ehis.lc.patient" bundle="lcLabels" />
							</ibaHTML:option>
							</ibaHTML:select>
							<img src="framework/images/mandatory.gif"></img>
							</td>
						
							<td align="right" width="20%" CLASS='label' nowrap="nowrap">
								<ibaBean:message key="com.iba.ehis.lc.standardStock.source" bundle="lcLabels" />
							</td>
							<td width="40%" nowrap="nowrap" >
							<input type=text name="loanedToSourceCode" id="loanedToSourceCode" maxlength="30" onblur="if(this.value!='')showLookup2()" />
							<ibaHTML:hidden property="vo.loanLinenVO.loanedToSourceCode"  />
							<input type='button' class="BUTTON"  value='?' onclick='showLookup2()' />
							<img src="framework/images/mandatory.gif"></img>
							</td>
						</tr>
						<tr >
						<td class='label'  nowrap="nowrap" align="right">
								<ibaBean:message key="com.iba.ehis.lc.loanLinen.givenBy"	bundle="lcLabels" />
						</td>
						<td class='label' >
							 <ibaHTML:text property="vo.loanLinenVO.givenBy" readonly="true" maxlength="30" value="<%=addedById%>" />
							 <img src="framework/images/mandatory.gif"></img>
						</td>
						<td class='label'  nowrap="nowrap" align="right">
								<ibaBean:message key="com.iba.ehis.lc.loanLinen.receivedBy"	bundle="lcLabels" />
						</td>
						<td class='label' >
							 <ibaHTML:text property="vo.loanLinenVO.receivedBy" maxlength="30"  />
							 <img src="framework/images/mandatory.gif"></img>
						</td>
						</tr>
						<tr >
						<td class='label'  nowrap="nowrap" align="right">
								<ibaBean:message key="com.iba.ehis.lc.loanLinen.reasonforLoan"	bundle="lcLabels" />
						</td>
						<td class='label' nowrap="nowrap">
						<ibaHTML:hidden property="vo.loanLinenVO.reasonCode"  />
						<ibaHTML:select property="vo.loanLinenVO.reasonDesc" onchange="setReasonDesc()" >
							<ibaHTML:option value="">
						<ibaBean:message key="com.iba.ehis.lc.select"
							bundle="lcLabels" />
							</ibaHTML:option>
						<ibaHTML:optionsCollection property="vo.loanLinenVO.reasonMap" label="key" value="value" />
						</ibaHTML:select>
   					    <img src="framework/images/mandatory.gif"></img>
						</td>
						<td class='label'  nowrap="nowrap" align="right">
								<ibaBean:message key="com.iba.ehis.lc.linenItem"	bundle="lcLabels" />
						</td>
						<td class='label' nowrap="nowrap">
							<input type="text" name="linenItemDesc" id="linenItemDesc" maxlength="30" onblur="if(this.value!='')showLookup1()"/>
							 <ibaHTML:hidden property="vo.loanLinenVO.linenItem" />
							<input type='button' class="BUTTON"  value='?' onclick='showLookup1()' />
							<img src="framework/images/mandatory.gif"></img>
						</td>
						</tr>
						<tr >
						<td class='label'  nowrap="nowrap" align="right">
								<ibaBean:message key="com.iba.ehis.lc.loanLinenloanedQty"	bundle="lcLabels" />
						</td>
						<td class='label' >
							 <ibaHTML:text property="vo.loanLinenVO.loanedQty" onkeyup="checkNumber(this)" maxlength ="8" onblur="checkStock()" />
						 	 <img src="framework/images/mandatory.gif"></img>
						</td>
						<td class='label'  nowrap="nowrap" align="right">
						<td class='label' >
						<a href="javascript:#" onclick="test5popupactivate(this.id);return false;" name="prepAnchor" id="prepAnchor">
						<ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" /></a>
						<input type="hidden" name="remarkArea" id="remarkArea" value="" maxlength="100"/>
						<input type="hidden" name="vo.loanLinenVO.remarks" id="vo.loanLinenVO.remarks"  maxlength="100"/>
							
							 
						</td>
						</tr>
						
		</table>


		</table>
		<ibaHTML:hidden property="vo.operatingFacilityId" value="<%=facilityId%>" />		<ibaHTML:hidden property="vo.loanLinenVO.requestStatus" value="OS" />		
		<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>" />
		<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
		<input type="hidden" name="languageId" id="languageId" value="<%=locale%>" />
		<ibaHTML:hidden property="vo.mode" />
		<ibaHTML:hidden property="vo.viewCode" value="loanLinenFrame" />
		<table align="center"><tr><td><input type="button" value="<ibaBean:message key='com.iba.ehis.lc.submit'	bundle='lcLabels' />" name="Submit" class="BUTTON" onclick="LoanLinen.getLoanRefNum(getRequestNumber);settime();" /></td></tr></table>
	</ibaHTML:form>
</body>
<script>
	   setSourceType();
</script>
</ibaHTML:html>

