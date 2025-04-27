<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateTime" pageEncoding="UTF-8"%><%@ page  import="com.iba.framework.core.util.Page" %>
<%@ page  import="com.iba.ehis.core.vo.QueryResultVO" %>
<%@ page  import="java.util.List" %>
<%@ page  import="java.util.ArrayList" %>
<%@ page  import="com.iba.ehis.core.pojo.web.PageForm" %>
<%@ include file="/framework/html/Tag.text" %>
<ibaHTML:html locale="true">
<head>
	<%
	String facilityId=(String)session.getAttribute("facility_id");
	String functionId = (String) session.getAttribute("functionId");
	String moduleId = (String) session.getAttribute("moduleId");
	String locale = (String) session.getAttribute("LOCALE");
	String loggedInUser = (String) session.getAttribute("login_user");
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE"): "IeStyle.css";
				if(sStyle==null)sStyle="IeStyle.css";
			String qryEven = "QRYEVEN";
			String qryOdd = "QRYODD";
				UserPreferences userPrefs =new UserPreferences();
				/* Cache cache = CacheManager.getCache();
				userPrefs=(UserPreferences)cache.getObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS); */
				String datepattrn=userPrefs.getDateFormat();
				String sb=userPrefs.getDateFormat();
				String tf=userPrefs.getTimeFormat();
				String pattern=sb+" "+tf;
			//	String locale=userPrefs.getLocale();
				IBADateTime todate=LcDateFormat.convertDateFormat(null,request);
	%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type="text/javascript"	src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenRequest.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/SendLinenForMending/js/SendLinenForMending.js'>
	</script>

<script type="text/javascript">
var contentList =new Hashtable();

function sourceReasonLookup(){
	var reasonDesc =document.getElementById("vo.placeLinenRequestVO.reasonDesc").value;
		if(reasonDesc != '')
			showLookup();
		}

function showLookup() {
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	
	argArray[0]="ehis.lc.requestForLinen.getReason"
//	namesArray[0]=dialogArguments[5];
//	namesArray[1]=dialogArguments[0];

	namesArray[0]="language_Id";
	valuesArray[0]='<%=locale%>';

	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
	//Display Order
	argArray[3] = DESC_CODE;

	// Link Description
	argArray[4] = DESC_LINK;
	argArray[5]=document.getElementById("vo.placeLinenRequestVO.reasonDesc").value ;
	
	getServerMessage("com.iba.ehis.lc.writeOffLinen.reason");
	var reasonLabel = dwrMessage;
	getServerMessage("com.iba.ehis.lc.cancel");
	var cancelLabel = dwrMessage;
	retArr = Lookup(cancelLabel+" "+reasonLabel, argArray);
	
	if(retArr!=null){
		//Set the data in to the fields
		document.getElementById("vo.placeLinenRequestVO.reasonCode").value = retArr[1];
		document.getElementById("vo.placeLinenRequestVO.reasonDesc").value=retArr[0];
		}
	}		

function showCancel(){
	if('<%=request.getParameter("title")%>'=='View Details')
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

function update(){
	document.getElementById("vo.placeLinenRequestVO.requestStatus").value="CN";
}
function checkReason()
{
	var desc=document.getElementById("vo.placeLinenRequestVO.reasonDesc");

	if(desc.value=="")
	{
		 getServerMessage("com.iba.ehis.lc.requestForLinen.cancelledReason");
		 var label1=dwrMessage;
		getServerMessage("message.cannot.blank");
		var msg=dwrMessage;
	 	msgArray=msg.split('#');
		 var error=""
		 error=error +msgArray[0]+" "+label1 + " " + msgArray[1];
	//	parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		alert(error);
	}
	else
	{document.SendLinenForMendingForm.submit();}
}</script>
</head>
<title><%=request.getParameter("title") %></title>
<body onload="showCancel();update();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<ibaHTML:form action="/SendLinenForMendingViewAction.do" target="messageFrame">
<br><br>
<table border='0 ' cellpadding='2' cellspacing='0' width='80%'	align='center'>
			<tr>
				<td class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestNum" bundle="lcLabels" />
				</td>
				<td nowrap="nowrap" align="left" class='label'>
					<script>
						document.write(dialogArguments[0]);
					</script>
					<input type="hidden" name="vo.placeLinenRequestVO.requestNum" id="vo.placeLinenRequestVO.requestNum" />
				</td>
				<td class='label' nowrap="nowrap" align="left">
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestDate" bundle="lcLabels" />
				</td>
				<td nowrap="nowrap" class='label'>
					<script>
						document.write(dialogArguments[1]);
					</script>
					<input type="hidden" name="vo.placeLinenRequestVO.requestDate" id="vo.placeLinenRequestVO.requestDate" />
					<input type="hidden" name="vo.placeLinenRequestVO.requestDate.pattern" id="vo.placeLinenRequestVO.requestDate.pattern" value="dd/MM/yyyy HH:mm"/>
					
				</td>
			</tr>
			<tr>
				<td class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.raisedBy"	bundle="lcLabels" />
				</td>
				<td class='label' align="left">
					<script>
						document.write(dialogArguments[2]);
					</script>
					<input type="hidden" name="vo.placeLinenRequestVO.sentBy" id="vo.placeLinenRequestVO.sentBy" />
				</td>
				<td class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestStatus" bundle="lcLabels" />
				</td>
				<td class='label' class='label'>
					<script>
						document.write(dialogArguments[3]);
					</script>
					<input type="hidden" name="status" id="status" />
				</td>
			</tr>
		</table>
		<div id="CancelFrame">
		<table border='0 ' cellpadding='2' cellspacing='0' width='80%' align='center'>
			<tr>
				<th align="left" colspan='4' >
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.cancelDetail" bundle="lcLabels" />
				</th>
			</tr>
			<tr>
				<td class="label">
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.cancelledBy" bundle="lcLabels" />
				</td>
				<td>
					<input type=text name="vo.placeLinenRequestVO.cancelledBy" id="vo.placeLinenRequestVO.cancelledBy" />
				</td>
				<td class="label" nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.cancelledDate" bundle="lcLabels" />
				</td>
				<td>
					<input type=text name="vo.placeLinenRequestVO.cancelledDate" id="vo.placeLinenRequestVO.cancelledDate" readonly=true  value="<%=todate%>"/>
					<input type="hidden" name="vo.placeLinenRequestVO.cancelledDate.pattern" id="vo.placeLinenRequestVO.cancelledDate.pattern" value="dd/MM/yyyy HH:mm"/>
				</td>
			</tr>
			<tr>
				<td class="label" nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.cancelledReason" bundle="lcLabels" />
				</td>
				<td nowrap="nowrap">
					<input type=hidden name="vo.placeLinenRequestVO.reasonCode" id="vo.placeLinenRequestVO.reasonCode" />
					<input type=text name="vo.placeLinenRequestVO.reasonDesc" id="vo.placeLinenRequestVO.reasonDesc" onblur="sourceReasonLookup()" />
					<input type=hidden name="vo.placeLinenRequestVO.requestStatus" id="vo.placeLinenRequestVO.requestStatus" />
					<input type="button" class='BUTTON' value="?" onclick="showLookup()" />
					<img src="<%=request.getContextPath()%>/framework/images/mandatory.gif"></img>
				</td>
				<td colspan="2" align="center">
					<input type="button" value='<ibaBean:message key="com.iba.ehis.lc.cancel" bundle="lcLabels" />' class='BUTTON'  onclick="checkReason()"/>
				</td>
			</tr>
		</table>
		<input type=hidden name="vo.operatingFacilityId" id="vo.operatingFacilityId" value="<%=facilityId%>" />
		<input type=hidden name="vo.functionId" id="vo.functionId" value="<%=functionId%>" />
		<input type=hidden name="vo.moduleId" id="vo.moduleId" value="<%=moduleId%>" />
		<input type=hidden name="vo.placeLinenRequestVO.locale" id="vo.placeLinenRequestVO.locale" value="<%=locale%>" />
		<input type=hidden name="method" id="method" value="2" />		
		<input type=hidden name="vo.mode" id="vo.mode" />
		</div>
</ibaHTML:form>
<ibaHTML:form action="/RequestForLinenViewPageAction.do" target="messageFrame">
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
	
			<ibaLogic:equal name="SendLinenForMendingForm" value="0"
				property="vo.requestsListVO.linenRequest">
				<script>
				 var error=getServerMessage("NO_RECORD_FOUND_FOR_CRITERIA");
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
						key="com.iba.ehis.lc.sentQty"
						bundle="lcLabels" />
				</th>
				<th align="center">
					<ibaBean:message
						key="com.iba.ehis.lc.loanLinen.receivedQty"
						bundle="lcLabels" />
				</th>
				<th align="center">
					<ibaBean:message
						key="com.iba.ehis.lc.requestForLinen.pendingQuantity"
						bundle="lcLabels" />
				</th>
				<th align="center">
					<ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" />
				</th>

			</tr>
		
			<ibaLogic:iterate id="result" name="SendLinenForMendingForm"
				property="vo.requestsListVO.linenRequest" indexId="rowId">
				<%
				  String style =(rowId.intValue()%2==0)?"QRYEVEN":"QRYODD";
				  
				  
				%>
				<tr class="label" >
					<td class="<%=style %>">
						
						<ibaBean:write name="result" property="linenItem"  />
					</td>

					<td class="<%=style %>">
						<ibaBean:write name="result" property="requestedQty" bundle="lcLabels" />
								
						
				<input type="hidden" value="<ibaBean:write name='result' id='result' property='requestedQty' bundle='lcLabels' />" name="requestedQty<%=rowId%>" />
					</td>
					<td class="<%=style %>">
						<ibaBean:write name="result" property="issuedQty" bundle="lcLabels" />					
						<input type="hidden" value="<ibaBean:write name='result' id='result' property='issuedQty' bundle='lcLabels'/>" name="issueQty<%=rowId%>" />
					</td>
					
					<td class="<%=style %>">
						<input type="hidden" value="" name="pendingQty<%=rowId%>" id="pendingQty<%=rowId%>"  />
					<script>
						var val<%=rowId%>=parseInt(document.getElementById("requestedQty<%=rowId%>").value-document.getElementById("issueQty<%=rowId%>").value);
										document.getElementById("pendingQty<%=rowId%>").value=val<%=rowId%>;
					var temp=<%=rowId%>;
					if(parseInt(temp)>=1)
					{	temp=parseInt(temp)-1;
					var pQty<%=rowId%>=parseInt(document.getElementById("pendingQty"+temp).value)-parseInt(document.getElementById("issueQty"+<%=rowId%>).value);
					document.getElementById("pendingQty<%=rowId%>").value=pQty<%=rowId%>;
					document.write(pQty<%=rowId%>);
					}
					else
					{
					document.write(val<%=rowId%>);
					}
					</script>
					</td>
					
					<td class="<%=style %>">
						<ibaBean:write name="result" property="remark" bundle="lcLabels"/>
					</td>
					
			</tr>
				</ibaLogic:iterate>
		</table>
		
	
</ibaHTML:form>
	<script>
			document.getElementById("vo.placeLinenRequestVO.requestNum").value= dialogArguments[0];
			document.getElementById("vo.placeLinenRequestVO.requestDate").value= dialogArguments[1];
			
			document.getElementById("vo.placeLinenRequestVO.sentBy").value= dialogArguments[4];
			document.getElementById("vo.placeLinenRequestVO.cancelledBy").value= dialogArguments[5];
			document.getElementById("status").value= dialogArguments[3];
				
	</script>
</body>
</ibaHTML:html>

