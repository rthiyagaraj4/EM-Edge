<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page  import="com.iba.framework.core.util.Constants"%>
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
					String qryEven = "QRYEVEN";
			String qryOdd = "QRYODD";
	%>
	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type="text/javascript"	src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenRequest.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/DeliverCleanedLinen/js/DeliverCleanedLinen.js'></script>

<script type="text/javascript">
var contentList =new Hashtable();

function showCancel()
{
if('<%=request.getParameter("title")%>'=='Delivery')
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
	
</script>
</head>
<title><%=request.getParameter("title") %></title>

<body onload="showCancel();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<ibaHTML:form action="/DeliverCleanedLinenAction.do" target="messageFrame">
<table border='0 ' cellpadding='2' cellspacing='0' width='100%'	align='center'>
			<tr>
				<td class='label' nowrap="nowrap" >
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestNum"
						bundle="lcLabels" />
				</td>
				<td class='label'  nowrap="nowrap" align="left">
				<script>
						document.write(dialogArguments[1]);
				</script>
				<input type="hidden" name="vo.deliverCleanedLinenVO.requestNum" id="vo.deliverCleanedLinenVO.requestNum" /> 
				</td>
				<td class='label' nowrap="nowrap" align='left'>
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestDate"
						bundle="lcLabels" />
				</td>
				<td class='label' nowrap="nowrap">
					<script>
						document.write(dialogArguments[2]);
					</script>

					<input type="hidden" name="vo.deliverCleanedLinenVO.requestDate" id="vo.deliverCleanedLinenVO.requestDate" />
				</td>
			</tr>
			<tr>
				<td width="30%" class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.standardStock.sourceType"	bundle="lcLabels" />
				</td>
				<td class='label' width="30%" align="left">
					<script>
						var ss=dialogArguments[6];   
						dialogArguments[6]=trimString(ss);
						var sType="";
						if(dialogArguments[6]=='W'){
						getServerMessage("com.iba.ehis.lc.ward");
						sType=dwrMessage;
						document.write(sType);
						}
						else if(dialogArguments[6]=='C'){
						getServerMessage("com.iba.ehis.lc.clinic");
						sType=dwrMessage;
						document.write(sType);
						}
						else if(dialogArguments[6]=='D'){
						getServerMessage("com.iba.ehis.lc.department");
						sType=dwrMessage;
						document.write(sType);
						}
						
					</script>
				
					<input type="hidden" name="vo.deliverCleanedLinenVO.sourceType" id="vo.deliverCleanedLinenVO.sourceType" />
				</td>
				<td align='left' width="20%" class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.standardStock.source"	bundle="lcLabels" />
				</td>
				<td width="40%" nowrap="nowrap" class='label'>
					<script>
						document.write(dialogArguments[0]);
					</script>

					<input type="hidden" name="vo.deliverCleanedLinenVO.sourceCode" id="vo.deliverCleanedLinenVO.sourceCode" />
				</td>
			</tr>
			<tr>
				<td class='label' nowrap="nowrap" >
					<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.linenHandedOverBy"	bundle="lcLabels" />
				</td>
				<td class='label' align="left">
					<script>
						document.write(dialogArguments[3]);
					</script>

					<input type="hidden" name="vo.deliverCleanedLinenVO.linenHandedOverBy" id="vo.deliverCleanedLinenVO.linenHandedOverBy" />

				</td>
				<td class='label' nowrap="nowrap" align='left'>
					<ibaBean:message key="com.iba.ehis.lc.requestForCleaningLinen.linenCollectedBy"	bundle="lcLabels" />
				</td>
				<td class='label'>
					<script>
						document.write(dialogArguments[4]);
					</script>

				<input type="hidden" name="vo.deliverCleanedLinenVO.linenCollectedBy" id="vo.deliverCleanedLinenVO.linenCollectedBy" />

				</td>
				
			</tr>
			<tr>
			<td class='label' nowrap="nowrap">
					<ibaBean:message
						key="com.iba.ehis.lc.deliverCleanedLinen.deliveryDate"	bundle="lcLabels" />
				</td>
				<td class='label' align="left">
					<script>
						document.write(dialogArguments[9]);
					</script>
					<input type="hidden" name="vo.deliverCleanedLinenVO.deliveryDate" id="vo.deliverCleanedLinenVO.deliveryDate" />
				</td>
				<td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td>
			</tr>
		</table>
		<ibaHTML:hidden property="vo.operatingFacilityId" value="<%=facilityId%>" />
		<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>" />
		<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
		<ibaHTML:hidden property="method" value="2" />		
		<ibaHTML:hidden property="vo.mode" />
		
</ibaHTML:form>

<ibaHTML:form action="/DeliverCleanedLinenViewPageAction.do" target="messageFrame">
		
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
	
			<ibaLogic:equal name="DeliverCleanedLinenForm" value="0"
				property="vo.deliverCleanedLinenVO.linenDeliverList">
				<script>
				 var error=getServerMessage("NO_RECORD_FOUND_FOR_CRITERIA");
				 parent.messageFrame.location.href =contextPath+'/core/jsp/MessageFrame.jsp?error='+error;
				</script>
			</ibaLogic:equal>
<table border='1' cellpadding='2' cellspacing='0' width='100%'
			id="tableid" align='center'>
			<tr>
				<th align="left" colspan=7>
					<ibaBean:message key="com.iba.ehis.lc.linenItemDetail" bundle="lcLabels" />
				</th>
			</tr>
			<tr>

				<th align="center" >
					<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
				</th>
				<th align="center">
					<ibaBean:message
						key="com.iba.ehis.lc.requestForLinen.requestedQuantity"
						bundle="lcLabels" />
				</th>
				<th align="center">
					<ibaBean:message
						key="com.iba.ehis.lc.deliverCleanedLinen.deliveredQty"
						bundle="lcLabels" />
				</th>
				<th align="center">
					<!-- <ibaBean:message
						key="com.iba.ehis.lc.deliverCleanedLinen.curdeliveryQty"
						bundle="lcLabels" /> -->
						<ibaBean:message
						key="com.iba.ehis.lc.requestForLinen.pendingQuantity"
						bundle="lcLabels" />
				</th>
				<th align="center">
					<ibaBean:message
						key="com.iba.ehis.lc.deliverCleanedLinen.schDeliveryDate"
						bundle="lcLabels" />
				</th>
				<th align="center">
					<ibaBean:message
						key="com.iba.ehis.lc.deliverCleanedLinen.latedeliveryReason"
						bundle="lcLabels" />
				</th>
				<th align="center">
					<ibaBean:message key="com.iba.ehis.lc.remark" bundle="lcLabels" />
				</th>

			</tr>
		
			<ibaLogic:iterate id="result" name="DeliverCleanedLinenForm"
				property="vo.deliverCleanedLinenVO.linenDeliverList" indexId="rowId">
	<%
				  String style =(rowId.intValue()%2==0)?"QRYEVEN":"QRYODD";
				  //out.println(style);
				%>
				<tr class="label">
					<td class="<%=style%>" align='left'>
						
						<ibaBean:write name="result" property="linenItem"  />
						<input type="hidden" value="<ibaBean:write name='result' id='result' property='linenItem'  />" name="linenItem<%=rowId%>" />
					</td>

					<td class="<%=style%>" align='right'>
					<ibaBean:write name="result" property="requestedQty" bundle="lcLabels" />
					<input type="hidden" value="<ibaBean:write name='result' id='result' property='requestedQty' bundle='lcLabels'  />" name="requestedQty<%=rowId%>" />
					</td>
					<td class="<%=style%>" align='right'>
					<ibaBean:write name="result" property="deliveredQty" bundle="lcLabels" />
										
						<input type="hidden" value="<ibaBean:write name='result' id='result' property='deliveredQty' bundle='lcLabels' />" name="issueQty<%=rowId%>" />
					</td>
					<td class="<%=style%>" align='right'>
					<input type="hidden" name="pendingQty<%=rowId%>" id="pendingQty<%=rowId%>" />
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
					<td class="<%=style%>" align='left'>
					<ibaBean:write name="result" property="schedDeliveryDate" bundle="lcLabels"  />	
					<input type="hidden" value="<ibaBean:write name='result' id='result' property='schedDeliveryDate'  />" name="schedDeliveryDate<%=rowId%>" />
					</td>
					<td class="<%=style%>" align='left'>
					<ibaBean:write name="result" property="lateDeliveryReason"  />
										
						<input type="hidden" value="<ibaBean:write name='result' id='result' property='lateDeliveryReason'  />" name="issueQty<%=rowId%>" />
					</td>
					
					<td class="<%=style%>" width="100" align='left' >
			
						<ibaBean:write name="result" property="remark" /> 
						<input type="hidden" value="<ibaBean:write name='result' id='result' property='remark' />" name="remark" />
					</td>
				
				</tr>
				
				
			</ibaLogic:iterate>
			<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
		</table>
		
	
</ibaHTML:form>
	<script>
			document.getElementById("vo.deliverCleanedLinenVO.deliveryDate").value= dialogArguments[9];
		
			document.getElementById("vo.deliverCleanedLinenVO.sourceType").value=sType;
			document.getElementById("vo.deliverCleanedLinenVO.requestNum").value= dialogArguments[1];
			document.getElementById("vo.deliverCleanedLinenVO.requestDate").value= dialogArguments[2];
			document.getElementById("vo.deliverCleanedLinenVO.sourceCode").value= dialogArguments[0];
			document.getElementById("vo.deliverCleanedLinenVO.linenHandedOverBy").value= dialogArguments[3];
			document.getElementById("vo.deliverCleanedLinenVO.linenCollectedBy").value= dialogArguments[4];
	</script>
</body>
</ibaHTML:html>

