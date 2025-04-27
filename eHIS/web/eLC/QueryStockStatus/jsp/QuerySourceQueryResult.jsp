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

<head>
	<%
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
		.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
		:"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";
		
	%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' /></head>
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
<body>
	<ibaHTMLEl:form action="/QueryStockStatusPageAction.do">
<ibaLogic:equal name="PageForm" value="0" property="vo.dataObjectsSize">
</ibaLogic:equal>
	<ibaLogic:equal name="PageForm" value="0" property="vo.dataObjectsSize">
		
		<script> 
			alert("<ibaBean:message key='NO_RECORD_FOUND_FOR_CRITERIA' bundle='commonMesages' />");
			location.href=contextPath+"/QueryStockStatusPageAction.do?method="+queryMethod+"&vo.moduleId="+'LC'+"&vo.functionId="+'<%=request.getParameter("vo.functionId")%>'
		</script>
		
		</ibaLogic:equal>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<ibaLogic:notEqual name="PageForm" value="0" property="vo.dataObjectsSize">
			<tr>
				<th>
					<ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" />
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
				String style =(rowId.intValue()%2==0)?"QRYEVEN":"QRYODD";
				//Object [] lcSourceStk=(Object[])result;
			%>
				<tr>
					<td class="<%=style%>">
						<ibaBean:write name="result" property="linenItem" />
						<input type="hidden" name="linenItem_<%=rowId%>" id="linenItem_<%=rowId%>" value="<ibaBean:write name="result" property="linenItem" bundle="lcLabels"/>"/>
					</td>
					<td class="<%=style%>">
						<input type="text" name='total_<%=rowId%>' id='total_<%=rowId%>' style="background:transparent;border=0;" />
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
					<script>
						var inUseQty = document.getElementById("inUseQty_<%=rowId%>").value;
						var soiledQty = document.getElementById("soiledQty_<%=rowId%>").value;
						var loanedQty = document.getElementById("loanedQty_<%=rowId%>").value;
						var total = parseInt(inUseQty)+parseInt(soiledQty)+parseInt(loanedQty);
						document.getElementById("total_<%=rowId%>").value=total;
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

