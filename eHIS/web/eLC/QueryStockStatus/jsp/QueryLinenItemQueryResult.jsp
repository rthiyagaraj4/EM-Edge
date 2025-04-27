<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.iba.framework.core.util.Page" %>
<%@ page import="com.iba.ehis.core.vo.QueryResultVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.iba.ehis.core.vo.QueryCriteriaVO" %>
<%@ page import="com.iba.framework.core.pojo.web.BaseForm" %>
<%@ page import="com.iba.framework.core.util.Constants"%>
<%@ include file="/framework/html/Tag.text"%>

<ibaHtmlEl:html locale="true">
<head>
<%
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
		.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
		:"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";
		String style="";
		String functionId = (String) session.getAttribute("functionId");
		String moduleId = (String) session.getAttribute("moduleId");
		String facilityId = (String) session.getAttribute("facility_id");
// 		changes for SCF 32276 - AMRI-SCF-0098. LOCALE attribute is retrieved and passed to 'locale' string variable
		String locale=(String)session.getAttribute("LOCALE");
		String QRYEVEN="";
		String QRYODD="";
		
%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />	
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<Script language="JavaScript" src="<%=request.getContextPath()%>/eLC/QueryStockStatus/js/QueryStockStatus.js"></Script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/QueryStockStatus.js'></script>
	
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
		
		function getLinenItem(){
		alert()
		//	var linenItem = document.stockStatusResult.getElementById("vo.criteriaItems[0].itemValue");
		//	alert(linenItem);
		}
</script>
</head>
<body>
	<ibaHTMLEl:form action="/QueryStockStatusLinenPageAction.do">
	<ibaLogic:equal name="PageForm" value="0" property="vo.dataObjectsSize">
	</ibaLogic:equal>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<br>
		<table id="contentTable" border='1' cellpadding='2' cellspacing='0' width='100%' align='center'>
			</table>
			<br>
		<ibaLogic:equal name="PageForm" value="0" property="vo.dataObjectsSize"> 
		
		<script> 
			alert("<ibaBean:message key='NO_RECORD_FOUND_FOR_CRITERIA' bundle='commonMesages' />");
			location.href=contextPath+"/QueryStockStatusLinenPageAction.do?method="+queryMethod+"&vo.moduleId="+'LC'+"&vo.functionId="+'LC_LINENITEMSTOCKSTATUS'
		</script>
		
		</ibaLogic:equal>
		
		<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
		
		<ibaLogic:equal name="PageForm" value="0" property="vo.dataObjectsSize">
			</ibaLogic:equal>
			<div id="listContentLayer" align="right">
		<table><tr><td>
		<ibaLogic:equal name="PageForm" property="vo.page.previousPage" value="true">		
		<a href="javascript:doPrev()">
			<ibaBean:message key="com.iba.ehis.ds.previous" bundle="dsLabels" />
		</a>
		</ibaLogic:equal>
		</td>
		<td>
		<ibaLogic:equal name="PageForm" property="vo.page.nextPage"	value="true">
		<a href="javascript:doNext()" >
			<ibaBean:message key="com.iba.ehis.ds.next" bundle="dsLabels" />
		</a></ibaLogic:equal>
		</td></tr></table>
	</div>
		<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>

					<ibaLogic:notEqual name="PageForm" value="0" property="vo.dataObjectsSize">
					<tr>
						<th>
							<ibaBean:message key="com.iba.ehis.lc.source" bundle="lcLabels" />
						</th>
						<th>
							<ibaBean:message key="com.iba.ehis.lc.total" bundle="lcLabels" />
						</th>
						<th>
							<ibaBean:message key="com.iba.ehis.lc.inUse" bundle="lcLabels" />
						</th>
						<th>
							<ibaBean:message key="com.iba.ehis.lc.soiled" bundle="lcLabels" />
						</th>
						<th>
							<ibaBean:message key="com.iba.ehis.lc.loaned" bundle="lcLabels" />
						</th>
					</tr>
			</ibaLogic:notEqual>
			<ibaLogic:iterate id="result" name="PageForm" property="vo.dataObjects" indexId="rowId">
			<%	
				style =(rowId.intValue()%2==0)?"QRYEVEN":"QRYODD";
			%>
				<tr>
<!-- 				changes for SCF 32276 - AMRI-SCF-0098 -->
					<td class="<%=style%>">
						<input type="hidden" name='sourceType_<%=rowId%>' id='sourceType_<%=rowId%>' value='<ibaBean:write name="result" property="sourceType" bundle="lcLabels" />' />
<%-- 						<ibaBean:write name="result" property="sourceCode" /> --%>
						<input type="text" name='sourceDesc_<%=rowId%>' id='sourceDesc_<%=rowId%>' readonly="true" style="background:transparent;border=0;" /> 
						<input type="hidden" name="sourceCode_<%=rowId%>" id="sourceCode_<%=rowId%>" value="<ibaBean:write name="result" property="sourceCode" bundle="lcLabels"/>"/>
						<script>	
						var stype=document.getElementById("sourceType_<%=rowId%>").value;
						var scode=document.getElementById("sourceCode_<%=rowId%>").value;
						QueryStockStatus.getSourceDesc("<%=locale%>","<%=facilityId%>",stype,scode,callBackSourceDesc);
							function callBackSourceDesc(data){
								for(prop in data)
									document.getElementById("sourceDesc_<%=rowId%>").value=data[prop];
									desc=document.getElementById("sourceDesc_<%=rowId%>").value;
								}
								
						</script>	
<!-- 					SCF 32276 changes end					 -->
					</td>

					<td class="<%=style%>">
						<input type="text" size="10" maxlength="10" name='total_<%=rowId%>' id='total_<%=rowId%>' style="background:transparent;border=0;"/>
					</td>
					<td class="<%=style%>">
						<ibaBean:write name="result" property="inUseQty" bundle="lcLabels"/>
						<input type="hidden" name="inUseQty_<%=rowId%>" id="inUseQty_<%=rowId%>" value="<ibaBean:write name="result" property="inUseQty" bundle="lcLabels"/>"/>
					</td>
					<td class="<%=style%>">
						<ibaBean:write name="result" property="soiledQty" bundle="lcLabels"/>
						<input type="hidden" name="soiledQty_<%=rowId%>" id="soiledQty_<%=rowId%>" value="<ibaBean:write name="result" property="soiledQty" bundle="lcLabels"/>"/>
					</td>
					<td class="<%=style%>">
						<ibaBean:write name="result" property="loanedQty" bundle="lcLabels"/>
						<input type="hidden" name="loanedQty_<%=rowId%>" id="loanedQty_<%=rowId%>" value="<ibaBean:write name="result" property="loanedQty" bundle="lcLabels"/>"/>
					</td>

					<input type="hidden" name="linenItem_<%=rowId%>" id="linenItem_<%=rowId%>" value="<ibaBean:write name="result" property="linenItem" bundle="lcLabels"/>"/>

					<script>
						var inUseQty = document.getElementById("inUseQty_<%=rowId%>").value;
						var soiledQty = document.getElementById("soiledQty_<%=rowId%>").value;
						var loanedQty = document.getElementById("loanedQty_<%=rowId%>").value;
						var total = parseInt(inUseQty)+parseInt(soiledQty)+parseInt(loanedQty);
						document.getElementById("total_<%=rowId%>").value=total;
				
						var linenItem = document.getElementById("linenItem_<%=rowId%>").value;
					
				if(<%=rowId%>==0){
					var facility_id="<%=facilityId%>";
					QueryStockStatus.getLaundryRec(linenItem,facility_id,callLaundryLevelStockData);
			
			function callLaundryLevelStockData(data){
				
				var qryEven = "QRYEVEN";
				var qryOdd = "QRYODD";
				var tableObj = null;
				
				tableObj = document.getElementById("contentTable");
				
				var row_ind = 1;
				
				for(prop in data){
					
					for(prop1 in data[prop])
					{
						var linenItem=data[prop][0];
						var withLaundryQty=data[prop][1];
						var issuedOutQty=data[prop][2];
						var inCleaningQty=data[prop][3];
						var inMendingQty=data[prop][4];
					}

				var total = parseInt(withLaundryQty)+parseInt(issuedOutQty)+parseInt(inCleaningQty)+parseInt(inMendingQty);
				var newRow = tableObj.insertRow(tableObj.rows.length);
				var classVal = (row_ind % 2 == 0) ? qryEven : qryOdd;
				
				var newCellDesc = newRow.insertCell(newRow.cells.length);
				newCellDesc.name = "Total" + row_ind;
				newCellDesc.className = classVal;
				newCellDesc.appendChild(document.createTextNode("Total:"+total));
							
				var newCellDesc = newRow.insertCell(newRow.cells.length);
				newCellDesc.name = "With Laundry" + row_ind;
				newCellDesc.className = classVal;
				newCellDesc.appendChild(document.createTextNode("With Laundry:"+withLaundryQty));
				
				var newCellDesc = newRow.insertCell(newRow.cells.length);
				newCellDesc.name = "Issued Out" + row_ind;
				newCellDesc.className = classVal;
				newCellDesc.appendChild(document.createTextNode("Issued Out:"+issuedOutQty));
				
				var newCellDesc = newRow.insertCell(newRow.cells.length);
				newCellDesc.name = "In Cleaning" + row_ind;
				newCellDesc.className = classVal;
				newCellDesc.appendChild(document.createTextNode("In Cleaning:"+inCleaningQty));
				
				var newCellDesc = newRow.insertCell(newRow.cells.length);
				newCellDesc.name = "In Mending" + row_ind;
				newCellDesc.className = classVal;
				newCellDesc.appendChild(document.createTextNode("In Mending:"+inMendingQty));
				
				}
			}
		}
			
</script>
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

