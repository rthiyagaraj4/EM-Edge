<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page  import="com.iba.framework.core.util.Page" %>
<%@ page  import="com.iba.ehis.core.vo.QueryResultVO" %>
<%@ page  import="java.util.List" %>
<%@ page  import="java.util.ArrayList" %>
<%@ page  import="com.iba.framework.core.pojo.web.BaseForm" %>
<%@ page  import="com.iba.framework.core.util.Constants" %>
<%@ include file="/framework/html/Tag.text" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<ibaHtmlEl:html locale="true">
<head>
	<%
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
			String qryEven = "QRYEVEN";
			String qryOdd = "QRYODD";
			String locale = (String) session.getAttribute("LOCALE");
		
	%>
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>

<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
<Script language="JavaScript" src='<%=request.getContextPath()%>/core/lookup/js/Lookup.js'></Script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenRequest.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<Script language="JavaScript" src='<%=request.getContextPath()%>/framework/js/PopupWindow.js'></Script>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/eLC/SendLinenForMending/js/tooltip.js"></script> 


<script>

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

<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<ibaHTMLEl:form action="/SendLinenForMendingPageAction.do">
		<br>	<table><tr>
				<ibaLogic:equal name="PageForm" property="vo.page.nextPage" value="true">
					<td>
					<a href="javascript:doNext()">
						<ibaBean:message key="com.iba.ehis.lc.next" bundle="lcLabels" />
						</a>
						</td>
				</ibaLogic:equal>
				<ibaLogic:equal name="PageForm" property="vo.page.previousPage" value="true">
					<td>
						<a href="javascript:doPrev()">
							<ibaBean:message key="com.iba.ehis.lc.previous" bundle="lcLabels" />
						</a>
					</td>
				</ibaLogic:equal>
				</tr></table>
				<ibaLogic:equal name="PageForm" value="0" property="vo.dataObjectsSize">
				<script> 
					alert("<ibaBean:message key='NO_RECORD_FOUND_FOR_CRITERIA' bundle='commonMesages' />");
				</script>
			</ibaLogic:equal>
<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
		
			<ibaLogic:notEqual name="PageForm" value="0" property="vo.dataObjectsSize">

				<tr>
				<!-- <th>
						<ibaBean:message key="com.iba.ehis.lc.linenItem"
							bundle="lcLabels" />
					</th> -->
					
					<th>
						<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestNum"
							bundle="lcLabels" />
					</th>
					<th>
						<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestDate"
							bundle="lcLabels" />
					</th>
					<th>
						<ibaBean:message key="com.iba.ehis.lc.requestForLinen.raisedBy"
							bundle="lcLabels" />
					</th>
					<th>
						<ibaBean:message
							key="com.iba.ehis.lc.requestForLinen.requestStatus"	bundle="lcLabels" />
					</th>
				</tr>
			</ibaLogic:notEqual>

			<ibaLogic:iterate id="result" name="PageForm" 	property="vo.dataObjects" indexId="rowId">
			<%
				  String style =(rowId.intValue()%2==0)?"QRYEVEN":"QRYODD";
				  int date_Id=rowId.intValue()+5000;
			%>
				<tr>
					<!-- <td class="<%=style%>" align="left">
						<ibaBean:write name="result" property="shortDesc" />
					</td> -->
										
					<td class="<%=style%>" align="right">
						<a href='<%=request.getContextPath()%>/eLC/SendLinenForMending/jsp/link.jsp?requestedQty="+<ibaBean:write name="result" property="requestedQty" bundle="lcLabels" />+"&requestNum="+<ibaBean:write name="result" property="requestNo" />+"&requestDate="+<ibaBean:write name="result" property="requestDate" bundle="lcLabels" />+"&sentBy="+<ibaBean:write name="result" property="sentBy" />+"&requestStatus="+<ibaBean:write name="result" property="requestStatus" />+"&reasonCode="+<ibaBean:write name="result" property="reasonCode" 
						/>+"&linenItem="+<ibaBean:write name="result" property="linenItem"
						/>+"&linenItemDesc="+<ibaBean:write name="result" property="shortDesc"
						/>+"&cancelledBy="+<ibaBean:write name="result" property="cancelledBy" />+"&cancelledDate="+<ibaBean:write name="result" property="cancelledDate" bundle="lcLabels" />' onclick="return show_hide_box(this,100,35,'2px dashed')" >
						<ibaBean:write name="result" property="requestNo" />
					</a>
					</td>
					<!--
					<td class="<%=style%>">
						<ibaBean:write name="result" property="requestDate" bundle="lcLabels"/>
					</td>
					-->
					<td class="<%=style%>" calss="label" align='left'> 
						<input type="hidden" name='requestDate_<%=rowId%>' id='requestDate_<%=rowId%>' value='<ibaBean:write name="result" property="requestDate" bundle="lcLabels"/>' />
						<input type="text" name='requestDate_<%=date_Id%>' id='requestDate_<%=date_Id%>' value=" " style="background:transparent;border=0;" /> 
					</td>
					<script>	
						var date=document.getElementById("requestDate_<%=rowId%>").value
						IBADateValidator.convertDateJS(date,"en","<%=locale%>","dd/MM/yyyy HH:mm",callBackReqDate);
						function callBackReqDate(conDate){
							document.getElementById("requestDate_<%=date_Id%>").value=conDate;
					}
					</script>		
					<td class="<%=style%>" align="left">
						<ibaBean:write name="result" property="sentBy" />
					</td>
					<td class="<%=style%>" align="left">
						<ibaLogic:equal value="OS" property="requestStatus" name="result">
							<ibaBean:message key="com.iba.ehis.lc.requestForLinen.outstanding" bundle="lcLabels" />
						</ibaLogic:equal>
						<ibaLogic:equal value="PR" property="requestStatus" name="result">
							<ibaBean:message key="com.iba.ehis.lc.deliverCleanedLinen.partiallydelivered" bundle="lcLabels" />
						</ibaLogic:equal>
						<ibaLogic:equal value="RE" property="requestStatus" name="result">
							<ibaBean:message key="com.iba.ehis.lc.deliverCleanedLinen.delivered" bundle="lcLabels" />
						</ibaLogic:equal>
						<ibaLogic:equal value="CN" property="requestStatus" name="result">
							<ibaBean:message key="com.iba.ehis.lc.requestForLinen.cancelled" bundle="lcLabels" />
						</ibaLogic:equal>
					</td>
				</tr>
			</ibaLogic:iterate>
		</table>
		<ibaHTML:hidden property="vo.page.pageNo" />
		<ibaHTML:hidden property="method" value="4" />

		<ibaLogicEl:iterate id="result" name="PageForm" property="vo.criteriaVo.criteriaItems" indexId="ind">
			<%
					String itemValProp = "vo.criteriaVo.criteriaItems[" + ind + "].itemValue";
					String prop = "vo.criteriaVo.criteriaItems[" + ind + "].property";
			%>
			<ibaHTMLEl:hidden property="<%=itemValProp%>" />
			<ibaHTMLEl:hidden property="<%=prop%>" />
		</ibaLogicEl:iterate>
		<ibaHTML:hidden property="vo.criteriaVo.orderBySelected.itemValue" />
		<ibaHTML:hidden property="vo.criteriaVo.queryResultPage" />
		<ibaHTML:hidden property="vo.moduleId" />
		<ibaHTML:hidden property="vo.functionId" />
	</ibaHTMLEl:form>
</body>
</ibaHtmlEl:html>

