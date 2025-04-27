<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.IBADate,com.iba.framework.core.util.IBADateTime,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateValidation" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="com.iba.framework.core.util.Constants"%>
<%@ page import="com.iba.ehis.lc.loanLinen.vo.ViewResultVO"%>
<%@ page  import="com.iba.ehis.lc.core.vo.SourceBean"%>
<%@ include file="/framework/html/Tag.text"%>
<ibaHTML:html locale="true">
<head>
	<%
	String facilityId=(String)request.getAttribute("facility_Id");
			if(facilityId==null)facilityId="LD";

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
			String qryEven = "QRYEVEN";
			String qryOdd = "QRYODD";

	UserPreferences userPrefs =new UserPreferences();
	/* Cache cache = CacheManager.getCache();
	userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */
		
	String timepattrn=userPrefs.getTimeFormat();
	String sb=userPrefs.getDateFormat();
	String pattern=sb+" "+timepattrn;

	SourceBean obj=new SourceBean();
		try
	{
		obj=(SourceBean)CacheManager.getCache().getObject(Constants.USER_SESSION_CACHE,"sessid", "objKey");
									
	}catch(Exception e){} 
		
	String src=obj.getSource();
	String srcType=obj.getSourceType();
	String srctype=obj.getSourcetype();
	String srcCode=obj.getSourceCode();

	%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
<script type="text/javascript"	src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/LoanLinen/js/loanedLinen.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	

	<script type="text/javascript">
var contentList =new Hashtable();
function showLookup() {
	
	var language_Id=document.getElementById("languageId").value;
	
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	
	argArray[0]="ehis.lc.requestForLinen.getReason"
	
	namesArray[0]="language_Id";
	valuesArray[0]=language_Id;
	
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
	//Display Order
	argArray[3] = DESC_CODE;

	// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] = document.getElementById("vo.loanLinenVO.cancelReason").value;
	retArr = Lookup("Cancel Reason", argArray);

	
	if(retArr!=null)
			{
			//Set the data in to the fields
			document.getElementById("vo.loanLinenVO.cancelReason").value = retArr[1];
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


function showCancel()
{
if('<%=request.getParameter("title")%>'=='View Details' || '<%=request.getParameter("title")%>'=='th View Details')
 document.getElementById("CancelFrame").style.visibility="hidden";
 
}
function doNext() {
		var pageNum=document.getElementById("vo.page.pageNo")
			pageNum.value=parseInt(pageNum.value)+1
			document.PageForm.submit()
		}
function doPrev() {
			var pageNum=document.getElementById("vo.page.pageNo")
			pageNum.value=parseInt(pageNum.value)-1
			document.PageForm.submit()
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
		if(arg=='V')
		{
		var rdate=document.getElementById("vo.loanLinenVO.cancelledDate");
		rdate.value=reqToDate;

		IBADateValidator.convertDateJS(reqToDate,"en","<%=locale%>","<%=pattern%>",CDcallbackMethod);
			function  CDcallbackMethod(fdate){
				document.getElementById("cancelledDate").value=fdate;
		}
	}
}



</script>
</head>
<title><%=request.getParameter("title") %></title>
<body onload="showCancel();CurrDate('V')">
<ibaHTML:form action="/LoanLinenViewAction.do" target="messageFrame">
<br><br>
<table border='0 ' cellpadding='2' cellspacing='0' width='80%'	align='center'>
			<tr>
				<td class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.loanLinen.loanrefNo"
						bundle="lcLabels" />
				</td>
				<td nowrap="nowrap" class='label'>
					<script>
						document.write(dialogArguments[4]);
					</script>
					<input type="hidden" name="vo.loanLinenVO.loanRefNum" id="vo.loanLinenVO.loanRefNum" /> 
				</td>
				<td class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.loanLinen.loanDate" bundle="lcLabels" />
				</td>
				<td nowrap="nowrap" class='label'>
					<script>
						document.write(dialogArguments[5]);
					</script>
					<input type="hidden" name="vo.loanLinenVO.loanDate" id="vo.loanLinenVO.loanDate" />
					<input type="hidden" name="vo.loanLinenVO.loanDate.pattern" id="vo.loanLinenVO.loanDate.pattern" value="dd/MM/yyyy HH:mm" />
				</td>

			</tr>
			<tr>
				<td align="left" width="30%" class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.standardStock.sourceType"	bundle="lcLabels" />
				</td>
				<td width="30%" class='label'>
					<script>
					
					var ss=dialogArguments[2];   
					dialogArguments[2]=trimString(ss);
					var sType="";
					if(dialogArguments[2]=='W'){
					getServerMessage("com.iba.ehis.lc.ward");
					sType=dwrMessage;}
					else if(dialogArguments[2]=='C'){
					getServerMessage("com.iba.ehis.lc.clinic");
					sType=dwrMessage;}
					else if(dialogArguments[2]=='D'){
					getServerMessage("com.iba.ehis.lc.department");
					sType=dwrMessage;}
					else if(dialogArguments[2]=='P'){
					getServerMessage("com.iba.ehis.lc.patient");
					sType=dwrMessage;}
					document.write(sType);
			
					</script>

				<input type="hidden" name="vo.loanLinenVO.sourceType" id="vo.loanLinenVO.sourceType" />
				</td>
				<td align="left" width="20%" class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.standardStock.source"	bundle="lcLabels" />
				</td>
				<td width="40%" nowrap="nowrap" class='label'>
					<script>
						document.write(dialogArguments[12]);
						
					</script>

					<input type="hidden" name="vo.loanLinenVO.sourceCode" id="vo.loanLinenVO.sourceCode" />
				</td>
			</tr>
			<tr>
				<td align="left" width="30%" class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.loanLinen.loanTo"	bundle="lcLabels" />
				</td>
				<td width="30%" class='label'>
				<script>
					var ss=dialogArguments[0];   
					dialogArguments[0]=trimString(ss);
					var sType="";
					if(dialogArguments[0]=='W'){
					getServerMessage("com.iba.ehis.lc.ward");
					sType=dwrMessage;}
					else if(dialogArguments[0]=='C'){
					getServerMessage("com.iba.ehis.lc.clinic");
					sType=dwrMessage;}
					else if(dialogArguments[0]=='D'){
					getServerMessage("com.iba.ehis.lc.department");
					sType=dwrMessage;}
					else if(dialogArguments[0]=='P'){
					getServerMessage("com.iba.ehis.lc.patient");
					sType=dwrMessage;}
					document.write(sType);
				</script>
							 
				<input type="hidden" name="vo.loanLinenVO.loanedToSourceType" id="vo.loanLinenVO.loanedToSourceType" />
				</td>
				<td align="left" width="20%" class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.standardStock.source"	bundle="lcLabels" />
				</td>
				<td width="40%" nowrap="nowrap" class='label'>
				
					<script>
						document.write(dialogArguments[13]);
					</script>
					<input type="hidden" name="vo.loanLinenVO.loanedToSourceCode" id="vo.loanLinenVO.loanedToSourceCode" />
				</td>
			</tr>
			<tr>
				<td class='label' nowrap="nowrap" >
					<ibaBean:message key="com.iba.ehis.lc.loanLinen.givenBy"	bundle="lcLabels" />
				</td>
				<td class='label'>
					<script>
						document.write(dialogArguments[6]);
					</script>
					<input type="hidden" name="vo.loanLinenVO.givenBy" id="vo.loanLinenVO.givenBy" />

				</td>
				<td class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.loanLinen.receivedBy"	bundle="lcLabels" />
				</td>
				<td class='label'>
					<script>
						document.write(dialogArguments[7]);
					</script>	
					<input type="hidden" name="vo.loanLinenVO.receivedBy" id="vo.loanLinenVO.receivedBy" />

				</td>
				</tr>
				<tr>
				<td class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.loanLinen.reasonforLoan"	bundle="lcLabels" />
				</td>
				<td class='label'>
					<script>
						document.write(dialogArguments[9]);
					</script>	
					<input type="hidden" name="vo.loanLinenVO.reasonCode" id="vo.loanLinenVO.reasonCode" />

				</td>
				<td class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" />
				</td>
				<td class='label'>
					<script>
						document.write(dialogArguments[11]);
					</script>	
					<input type="hidden" name="vo.loanLinenVO.remarks" id="vo.loanLinenVO.remarks" />

				</td>
				</tr>
				<tr>

				</td>
				<td class='label' nowrap="nowrap">
					<ibaBean:message
						key="com.iba.ehis.lc.receiveloanedlinen.status"	bundle="lcLabels" />
				</td>
				<td class='label'>
					<script>
						var ss1=dialogArguments[10];   
						dialogArguments[10]=trimString(ss1);
						var sType1="";
						if(dialogArguments[10]=='OS'){
						getServerMessage("com.iba.ehis.lc.requestForLinen.outstanding");
						sType1=dwrMessage;
						document.write(sType1);
						}
						else if(dialogArguments[10]=='IS'){
						getServerMessage("com.iba.ehis.lc.requestForLinen.issued");
						sType1=dwrMessage;
						document.write(sType1);
						}
						else if(dialogArguments[10]=='PI'){
						getServerMessage("com.iba.ehis.lc.requestForLinen.partiallyissued");
						sType1=dwrMessage;
						document.write(sType1);
						}
						else if(dialogArguments[10]=='CN'){
						getServerMessage("com.iba.ehis.lc.requestForLinen.cancelled");
						sType1=dwrMessage;
						document.write(sType1);
						}
						else if(dialogArguments[10]=='RE'){
						getServerMessage("com.iba.ehis.lc.received");
						sType1=dwrMessage;
						document.write(sType1);
						}
						
					</script>
					<input type="hidden" name="requestStatus" id="requestStatus" />
				</td>
				<td></td>
				<td></td>
			</tr>
		</table>
		<br>
		<div id="CancelFrame">
		<table border='0 ' cellpadding='2' cellspacing='0' width='80%'
			align='center'>
			<tr>
				<th align="left" colspan='4' >
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.cancelDetail"
						bundle="lcLabels" />
				</th>
				
			</tr>
			<tr>
				<td class="label">
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.cancelledBy"
						bundle="lcLabels" />
				</td>
				<td>
					<input type=text name="vo.loanLinenVO.cancelledBy" id="vo.loanLinenVO.cancelledBy" readonly="true" value="<%=addedById%>"/>
				</td>
				<td class="label" nowrap="nowrap">
					<ibaBean:message
						key="com.iba.ehis.lc.requestForLinen.cancelledDate"
						bundle="lcLabels" />
				</td>
				<td>
					<input type=text name="cancelledDate" id="cancelledDate" />
					<input type=hidden name="vo.loanLinenVO.cancelledDate" id="vo.loanLinenVO.cancelledDate"/>
					<input type=hidden name="vo.loanLinenVO.cancelledDate.pattern" id="vo.loanLinenVO.cancelledDate.pattern" value="dd/MM/yyyy HH:mm" />
				</td>
				
			</tr>
			<tr>
				<td class="label" nowrap="nowrap">
					<ibaBean:message
						key="com.iba.ehis.lc.requestForLinen.cancelledReason"
						bundle="lcLabels" />
				</td>
				<td nowrap="nowrap">
					<input type=text name="vo.loanLinenVO.cancelReason" id="vo.loanLinenVO.cancelReason" />
					<input type=hidden name="vo.loanLinenVO.requestStatus" id="vo.loanLinenVO.requestStatus" value="CN"/>
					<input type="button" class='BUTTON' value="?" onclick="showLookup()" />
				</td>
				<td colspan="2" align="center">
					<input type=submit value="<ibaBean:message key='com.iba.ehis.lc.cancel' bundle='lcLabels' />" class='BUTTON' />
				</td>
			</tr>
		</table>
		</div>
		<ibaHTML:hidden property="vo.operatingFacilityId" value="<%=facilityId%>" />
		<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>" />
		<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
		<ibaHTML:hidden property="method" value="2" />		
		<ibaHTML:hidden property="vo.mode" />
		<input type="hidden" name="languageId" id="languageId" value="<%=locale%>"/>
		
</ibaHTML:form>

<ibaHTML:form action="/LoanLinenViewPageAction.do" target="messageFrame">
		
				<ibaLogic:equal name="PageForm" property="vo.page.nextPage"
					value="true">
					
						<a href="javascript:doNext()">
						<ibaBean:message key="com.iba.ehis.lc.next" bundle="lcLabels" />
						</a>
					
				</ibaLogic:equal>
				
				<ibaLogic:equal name="PageForm" property="vo.page.previousPage"
					value="true">
			
						<a href="javascript:doPrev()">
						<ibaBean:message key="com.iba.ehis.lc.previous" bundle="lcLabels" />
						</a>
				</ibaLogic:equal>
	
			<ibaLogic:equal name="LoanLinenForm" value="0"
				property="vo.loanListVO.loanLinenList">
				<script>
				 var error=getServerMessage("com.iba.ehis.lc.noRecord");
				 parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
				</script>
			</ibaLogic:equal>
			<table border='1' cellpadding='2' cellspacing='0' width='80%' id="tableid" align='center'>
			<tr>
				<th align="left" colspan=5>
					<ibaBean:message key="com.iba.ehis.lc.linenItemDetail" bundle="lcLabels" />
				</th>
			</tr>
			<tr>

				<th align="center">
					<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
				</th>
				<th align="center">
					<ibaBean:message
						key="com.iba.ehis.lc.loanLinenloanedQty"
						bundle="lcLabels" />
				</th>
				<th align="center">
					<ibaBean:message
						key="com.iba.ehis.lc.loanLinen.receivedQty"
						bundle="lcLabels" />
				</th>
				
			</tr>
		
			<ibaLogic:iterate id="result" name="LoanLinenForm"
				property="vo.loanListVO.loanLinenList" indexId="rowId">
				<%
				  String style =(rowId.intValue()%2==0)?"QRYEVEN":"QRYODD";
				//  out.println(result);
				%>
				<tr class="label" >
					<td class="<%=style %>" align='left'>
						
						<ibaBean:write name="result" property="linenItem"  />

					</td>

					<td class="<%=style %>" align='right'>
							<ibaBean:write name="result" property="loanedQty" bundle="lcLabels" />
					</td>
					<td class="<%=style %>" align='right'>
						<ibaBean:write name="result" property="receivedQty" bundle="lcLabels"  />
					</td>
			</tr>
				</ibaLogic:iterate>
		</table>
		
	
</ibaHTML:form>
	<script>
			document.getElementById("vo.loanLinenVO.loanRefNum").value= dialogArguments[4];
			document.getElementById("vo.loanLinenVO.loanDate").value= dialogArguments[5];
			document.getElementById("vo.loanLinenVO.sourceType").value= dialogArguments[2];
			document.getElementById("vo.loanLinenVO.sourceCode").value= dialogArguments[12];
			//document.getElementById("vo.loanLinenVO.loanedToSourceType").value= dialogArguments[0];
			document.getElementById("vo.loanLinenVO.loanedToSourceCode").value= dialogArguments[13];
			document.getElementById("vo.loanLinenVO.givenBy").value= dialogArguments[6];
			document.getElementById("vo.loanLinenVO.receivedBy").value= dialogArguments[7];
			//document.getElementById("vo.loanLinenVO.linenItem").value= dialogArguments[8];
			document.getElementById("vo.loanLinenVO.reasonCode").value= dialogArguments[9];
			document.getElementById("requestStatus").value= dialogArguments[10];
			document.getElementById("vo.loanLinenVO.remarks").value= dialogArguments[11];
			//document.getElementById("vo.loanLinenVO.cancelledBy").value= dialogArguments[8];
			//document.getElementById("vo.loanLinenVO.cancelledDate").value= dialogArguments[9];
			
	</script>
</body>
</ibaHTML:html>

