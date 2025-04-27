<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate,com.iba.framework.core.util.IBADateTime,com.iba.ehis.lc.core.util.LcDateFormat,com.iba.framework.core.util.IBADateValidation" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.framework.core.util.Page" %>
<%@ page  import="com.iba.ehis.core.vo.QueryResultVO" %>
<%@ page  import="java.util.List" %>
<%@ page  import="java.util.ArrayList" %>
<%@ page  import="com.iba.ehis.core.pojo.web.PageForm" %>
<%@ page  import="com.iba.ehis.lc.core.vo.SourceBean"%>
<%@ include file="/framework/html/Tag.text" %>
<ibaHTML:html locale="true">
<head>
	<%
	String facilityId=(String)session.getAttribute("facility_id");
	String functionId = (String) session.getAttribute("functionId");
	String moduleId = (String) session.getAttribute("moduleId");
	String loggedInUser = (String) session.getAttribute("login_user");
	String locale = (String) session.getAttribute("LOCALE");


	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE"): "IeStyle.css";
				if(sStyle==null)sStyle="IeStyle.css";
			String qryEven = "QRYEVEN";
			String qryOdd = "QRYODD";

			
			//Cache cache = CacheManager.getCache();
			SourceBean obj=new SourceBean();
			try
			{
				obj=(SourceBean)CacheManager.getCache().getObject(Constants.USER_SESSION_CACHE,	"sessid", "objKey");
										
			}catch(Exception e){} 
			
			String src=obj.getSource();
			String srcType=obj.getSourceType();
			String srctype=obj.getSourcetype();
			String srcCode=obj.getSourceCode();

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
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/RequestForLinen/js/RequestForLinen.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>

	<script type="text/javascript">
var contentList =new Hashtable();
function sourceReasonLookup()
{
var reasonDesc =document.getElementById("vo.placeLinenRequestVO.reasonDesc").value;
if(reasonDesc != '')
showLookup();
}
function showLookup() {

	var language_Id = document.getElementById("languageId").value;

	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	
	argArray[0] = "ehis.lc.requestForLinen.getReason"
	namesArray[0]="language_Id";
	valuesArray[0]=language_Id;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
						
	//Display Order
	argArray[3] = DESC_CODE;

	// Link Description
	argArray[4] = DESC_LINK;
	argArray[5] = document.getElementById("vo.placeLinenRequestVO.reasonDesc").value;
	retArr = Lookup("Cancel Reason", argArray);

	
	if(retArr!=null)
			{
			//Set the data in to the fields
			document.getElementById("vo.placeLinenRequestVO.reasonCode").value = retArr[1];
			document.getElementById("vo.placeLinenRequestVO.reasonDesc").value=retArr[0];
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
function update()
{
document.getElementById("vo.placeLinenRequestVO.requestStatus").value="CN";
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
	
		if(arg=='V')
		{
			var rdate=document.getElementById("vo.placeLinenRequestVO.cancelledDate");
			rdate.value=convert1;
			IBADateValidator.convertDateJS(convert1,"en","<%=locale%>","dd/MM/yyyy HH:mm",CDcallbackMethod);
			function  CDcallbackMethod(fdate){
				document.getElementById("cancelledDate").value=fdate;
			}
		}
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
		//parent.parent.parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
		alert(error);
	}
	else
	{document.RequestForLinenForm.submit();}
}
	
</script>
</head>
<title><%=request.getParameter("title") %></title>
<body onload="showCancel();CurrDate('V');update();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<ibaHTML:form action="/RequestForLinenViewAction.do" target="messageFrame">
<br><br>
<table border='0 ' cellpadding='2' cellspacing='0' width='80%'	align='center'>
			<tr>
				<td class='label' nowrap="nowrap" >
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestNum"
						bundle="lcLabels" />:
				</td>
				<td nowrap="nowrap" class='label' align="left">
				<!--&nbsp&nbsp-->
				<script>document.write(dialogArguments[1]);</script>
				<input type="hidden" name="vo.placeLinenRequestVO.requestNum" id="vo.placeLinenRequestVO.requestNum" />
				</td>
				<td class='label' nowrap="nowrap" align='left'>
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestDate"
						bundle="lcLabels" />:
				</td>
				<td nowrap="nowrap" class='label'>
					<!--&nbsp&nbsp-->
							
					<script>
					document.write(dialogArguments[2]);

					</script> 
						<input type="hidden" name="vo.placeLinenRequestVO.requestDate" id="vo.placeLinenRequestVO.requestDate" />
						<input type="hidden" name="vo.placeLinenRequestVO.requestDate.pattern" id="vo.placeLinenRequestVO.requestDate.pattern" 
						value="dd/MM/yyyy HH:mm" />
					
				</td>

			</tr>
			<tr>
				<td width="30%" class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.standardStock.sourceType"	bundle="lcLabels" />:
				</td>
				<td width="30%" class='label' align='left' >
				<!--&nbsp&nbsp-->
				<script>
				var ss=dialogArguments[5];   
				dialogArguments[5]=trimString(ss);
				var sType="";
				if(dialogArguments[5]=='W')
				sType='<ibaBean:message key="com.iba.ehis.lc.ward"	bundle="lcLabels" />'
				else if(dialogArguments[5]=='C')				
				sType='<ibaBean:message key="com.iba.ehis.lc.clinic"	bundle="lcLabels" />'
				else if(dialogArguments[5]=='D')
				sType='<ibaBean:message key="com.iba.ehis.lc.department"	bundle="lcLabels" />'
				document.write(sType);</script>
				<input type="hidden" name="vo.placeLinenRequestVO.sourceType" id="vo.placeLinenRequestVO.sourceType" />
				</td>
				<td align='left' width="20%" class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.standardStock.source"	bundle="lcLabels" />:
				</td>
				<td width="40%" nowrap="nowrap" class='label'>
				
					<!--&nbsp&nbsp-->
					<script>
						document.write('<%=src%>');</script>
					<input type="hidden" name="vo.placeLinenRequestVO.sourceCode" id="vo.placeLinenRequestVO.sourceCode" />
				</td>
			</tr>
			<tr>
				<td class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.raisedBy"	bundle="lcLabels" />:
				</td>
				<td class='label'  align='left' >
				<!--&nbsp&nbsp-->
				<script>document.write(dialogArguments[3]);</script>
					<input type="hidden" name="vo.placeLinenRequestVO.raisedBy" id="vo.placeLinenRequestVO.raisedBy" />
				</td>
				<td  align='left' class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestStatus"	bundle="lcLabels" />:
				</td>
				<td class='label'>
				<!--&nbsp&nbsp-->
				<script>
						var ss1=dialogArguments[4];   
						dialogArguments[4]=trimString(ss1);
						var sType1="";
						if(dialogArguments[4]=='OS'){
						getServerMessage("com.iba.ehis.lc.requestForLinen.outstanding");
						sType1=dwrMessage;
						document.write(sType1);
						}
						else if(dialogArguments[4]=='IS'){
						getServerMessage("com.iba.ehis.lc.requestForLinen.issued");
						sType1=dwrMessage;
						document.write(sType1);
						}
						else if(dialogArguments[4]=='PI'){
						getServerMessage("com.iba.ehis.lc.requestForLinen.partiallyissued");
						sType1=dwrMessage;
						document.write(sType1);
						}
						else if(dialogArguments[4]=='CN'){
						getServerMessage("com.iba.ehis.lc.requestForLinen.cancelled");
						sType1=dwrMessage;
						document.write(sType1);
						}
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
					<input type=text name="vo.placeLinenRequestVO.cancelledBy" id="vo.placeLinenRequestVO.cancelledBy" maxlength="30" value="<%=loggedInUser%>"/>
				</td>
				<td class="label" nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.cancelledDate" bundle="lcLabels" />
				</td>
				<td>
					<input type=text name="cancelledDate" id="cancelledDate" readonly=true />
					<input type=hidden name="vo.placeLinenRequestVO.cancelledDate" id="vo.placeLinenRequestVO.cancelledDate" />
					<input type=hidden name="vo.placeLinenRequestVO.cancelledDate.pattern" id="vo.placeLinenRequestVO.cancelledDate.pattern" value="dd/MM/yyyy HH:mm" />
				</td>
			</tr>
			<tr>
				<td class="label" nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.cancelledReason" bundle="lcLabels" />
				</td>
				<td nowrap="nowrap">
					<input type=hidden name="vo.placeLinenRequestVO.reasonCode" id="vo.placeLinenRequestVO.reasonCode" />
					<input type=text name="vo.placeLinenRequestVO.reasonDesc" id="vo.placeLinenRequestVO.reasonDesc" maxlength="10" onblur="sourceReasonLookup()" />
					<input type=hidden name="vo.placeLinenRequestVO.requestStatus" id="vo.placeLinenRequestVO.requestStatus" />
					<input type="button" class='BUTTON' value="?" onclick="showLookup()" />
					<img src="<%=request.getContextPath()%>/framework/images/mandatory.gif"></img>
				</td>
				<td colspan="2" align="center">
					<input type="button" value='<ibaBean:message key="com.iba.ehis.lc.cancel" bundle="lcLabels" />' class='BUTTON' onclick="checkReason()"/>
				</td>
			</tr>
		</table>
		<ibaHTML:hidden property="vo.operatingFacilityId" value="<%=facilityId%>" />
		<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>" />
		<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
		<ibaHTML:hidden property="method" value="2" />		
		<ibaHTML:hidden property="vo.mode" />
		<input type=hidden name="languageId" id="languageId" value="<%=locale%>"/>
		
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
	
			<ibaLogic:equal name="RequestForLinenForm" value="0"
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

				<th align='center'>
					<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
				</th>
				<th align='center'>
					<ibaBean:message
						key="com.iba.ehis.lc.requestForLinen.requestedQuantity"
						bundle="lcLabels" />
				</th>
				<th align='center'>
					<ibaBean:message
						key="com.iba.ehis.lc.requestForLinen.issuedQuantity"
						bundle="lcLabels" />
				</th>
				<th align='center'>
					<ibaBean:message
						key="com.iba.ehis.lc.requestForLinen.pendingQuantity"
						bundle="lcLabels" />
				</th>
				<th align="center" align='left'>
					<ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" />
				</th>

			</tr>
		
			<ibaLogic:iterate id="result" name="RequestForLinenForm"
				property="vo.requestsListVO.linenRequest" indexId="rowId">
				<%
				  String style =(rowId.intValue()%2==0)?"QRYEVEN":"QRYODD";
				  
				  
				%>
				<tr class="label" >
					<td class="<%=style %>" align='left'>
						
						<ibaBean:write name="result" property="linenItem"  />
						<input type="hidden" value="<ibaBean:write name='result' id='result' property='linenItem' bundle='lcLabels' />" name="linenItem<%=rowId%>" />
					</td>

					<td class="<%=style %>" align='right'>
						<ibaBean:write name="result" property="requestedQty" bundle="lcLabels" />
						<input type="hidden" value="<ibaBean:write name='result' id='result' property='requestedQty' bundle='lcLabels' />" name="requestedQty<%=rowId%>" />
					</td>
					<td class="<%=style %>" align='right'>
						<ibaBean:write name="result" property="issuedQty" bundle="lcLabels" />					
						<input type="hidden" value="<ibaBean:write name='result' id='result' property='issuedQty' bundle='lcLabels' />" name="issueQty<%=rowId%>" />
					</td>
					
					<td class="<%=style %>" align='right'>
					<input type="hidden" name="pendingQty<%=rowId%>" id="pendingQty<%=rowId%>" />
					<script>
					var val<%=rowId%>=parseInt(document.getElementById("requestedQty<%=rowId%>").value-document.getElementById("issueQty<%=rowId%>").value);
					
					var temp=<%=rowId%>;
					var lItem=document.getElementById("linenItem<%=rowId%>").value;
					if(parseInt(temp)>0 )
					{	temp=parseInt(temp)-1;
						var lItem1=document.getElementById("linenItem"+temp).value;
						if(lItem==lItem1){
							var pQty<%=rowId%>=parseInt(document.getElementById("pendingQty"+temp).value)-parseInt(document.getElementById("issueQty"+<%=rowId%>).value);
							document.getElementById("pendingQty<%=rowId%>").value=pQty<%=rowId%>;
							document.write(pQty<%=rowId%>);
							}
							else
							{
								document.write(val<%=rowId%>);
								document.getElementById("pendingQty<%=rowId%>").value=val<%=rowId%>;
							}
					}
					else
					{
					
					document.getElementById("pendingQty<%=rowId%>").value=val<%=rowId%>;
					document.write(val<%=rowId%>);
					}
					</script>
					</td>
					
					<td class="<%=style %>" align='left'>
						<ibaBean:write name="result" property="remark" bundle="lcLabels"/>
					</td>
					
			</tr>
				</ibaLogic:iterate>
		</table>
		
	
</ibaHTML:form>
	<script>
			document.getElementById("vo.placeLinenRequestVO.requestNum").value= dialogArguments[1];
			document.getElementById("vo.placeLinenRequestVO.requestDate").value= dialogArguments[2];
			document.getElementById("vo.placeLinenRequestVO.sourceCode").value= dialogArguments[0];
			document.getElementById("vo.placeLinenRequestVO.raisedBy").value= dialogArguments[3];
			//document.getElementById("vo.placeLinenRequestVO.cancelledBy").value= dialogArguments[8];
			document.getElementById("status").value= dialogArguments[4];
			document.getElementById("vo.placeLinenRequestVO.sourceType").value=dialogArguments[5];

	</script>

</body>
</ibaHTML:html>

