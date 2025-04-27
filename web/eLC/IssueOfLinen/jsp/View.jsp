<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page  import="com.iba.framework.core.util.Page" %>
<%@ page  import="java.util.List" %>
<%@ page  import="java.util.ArrayList" %>
<%@ page  import="com.iba.framework.core.util.Constants"%>
<%@ include file="/framework/html/Tag.text"%>
<ibaHTML:html locale="true">
<head>
	<%
	String facilityId=(String)session.getAttribute("facility_id");
	String functionId = (String) session.getAttribute("functionId");
	String moduleId = (String) session.getAttribute("moduleId");
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
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script type="text/javascript"	src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenIssue.js'></script>
	
	<script type="text/javascript">
var contentList =new Hashtable();
var val="";

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
<body OnMouseDown="CodeArrest();" onKeyDown="lockKey()">
<ibaHTML:form action="/RequestForLinenViewAction.do" target="messageFrame">
<br><br>
<table border='0 ' cellpadding='2' cellspacing='0' width='100%'	align='center'>
			<tr>
				<td class='label' nowrap="nowrap" >
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestNum"
						bundle="lcLabels" />
				</td>
				<td nowrap="nowrap" align="left" class='label'>
					<script>
						document.write(dialogArguments[1]);
					</script>
					<input type="hidden" name="vo.placeLinenRequestVO.requestNum" id="vo.placeLinenRequestVO.requestNum" />
				</td>
				<td class='label' align='left'>
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.requestDate" bundle="lcLabels" />
				</td>
				<td nowrap="nowrap" class='label'>
					<script>
						document.write(dialogArguments[2]);
					</script>
					<input type="hidden" name="vo.placeLinenRequestVO.requestDate" id="vo.placeLinenRequestVO.requestDate" />
				</td>
			</tr>
			<tr>
				<td class='label' nowrap="nowrap">
					<ibaBean:message key="com.iba.ehis.lc.standardStock.sourceType"	bundle="lcLabels" />
				</td>
				<td align="left" class='label'>
					<script>

						var ss=dialogArguments[5];   
						dialogArguments[5]=trimString(ss);
						var sType="";
						if(dialogArguments[5]=='W'){
						getServerMessage("com.iba.ehis.lc.ward");
						sType=dwrMessage;
						document.write(sType);
						}
						else if(dialogArguments[5]=='C'){
						getServerMessage("com.iba.ehis.lc.clinic");
						sType=dwrMessage;
						document.write(sType);
						}
						else if(dialogArguments[5]=='D'){
						getServerMessage("com.iba.ehis.lc.department");
						sType=dwrMessage;
						document.write(sType);
						}
												
					</script>
					<!-- <input type="text" name="sourceType" id="sourceType" readonly="true" class='label' style="background:transparent;border=0" /> -->
					<input type=hidden name="vo.placeLinenRequestVO.sourceType" id="vo.placeLinenRequestVO.sourceType" />
				</td>
				<td class='label' align='left'>
					<ibaBean:message key="com.iba.ehis.lc.standardStock.source"	bundle="lcLabels" />
				</td>
				<td nowrap="nowrap" class='label' >
				 <script>
						document.write(dialogArguments[10]);
					</script>
					<input type="hidden" name="vo.placeLinenRequestVO.sourceCode" id="vo.placeLinenRequestVO.sourceCode" />
				</td>
			</tr>
			<tr>
				<td class='label' nowrap="nowrap" >
					<ibaBean:message key="com.iba.ehis.lc.requestForLinen.raisedBy"	bundle="lcLabels" />
				</td>
				<td class='label' align="left">
					<script>
						document.write(dialogArguments[3]);
					</script>
						<input type="hidden" name="vo.placeLinenRequestVO.raisedBy" id="vo.placeLinenRequestVO.raisedBy" />
				</td>
				<td class='label' nowrap="nowrap" align="left">
					<ibaBean:message
						key="com.iba.ehis.lc.requestForLinen.requestStatus"	bundle="lcLabels" />
				</td>
				<td class='label'>
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
					<!-- <input type="text" name="status" id="status" readonly="true" class='label' style="background:transparent;border=0" /> -->
					<input type=hidden name="vo.placeLinenRequestVO.requestStatus" id="vo.placeLinenRequestVO.requestStatus" />
				</td>
			</tr>
		</table>
			
		
		
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
	
			
<table border='1' cellpadding='2' cellspacing='0' width='100%'
			id="tableid" align='center' >
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
						key="com.iba.ehis.lc.requestForLinen.requestedQuantity"
						bundle="lcLabels" />
				</th>
				<th align="center">
					<ibaBean:message
						key="com.iba.ehis.lc.requestForLinen.issuedQuantity"
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
			
		
			<ibaLogic:iterate id="result" name="IssueOfLinenForm"
				property="vo.requestsListVO.linenRequest" indexId="rowId">
				
				<%
				  String style =(rowId %2==0)?"QRYEVEN":"QRYODD";
				  //out.println(style);
				%>
				<tr>
						<td class="<%=style %>" align='left'>
						<ibaBean:write name="result" property="linenItem" /><!--  <%=rowId%>-->
						<input type="hidden" value="<ibaBean:write name='result' id='result' property='linenItemCode' />" name="linenItem<%=rowId%>" />
					</td>

						<td class="<%=style %>" align="right">
						<ibaBean:write name="result" property="requestedQty" bundle="lcLabels" />
						
						<input type="hidden" value="<ibaBean:write name='result' id='result' property='requestedQty' bundle='lcLabels' />" name="requestedQty<%=rowId%>" />
					</td>
						<td class="<%=style %>" align="right">
					<ibaBean:write name="result" property="issuedQty" bundle='lcLabels' />				
						<input type="hidden" value="	<ibaBean:write name='result' id='result' property='issuedQty' bundle='lcLabels' />" name="issueQty<%=rowId%>" />
					</td>
					<td  class="<%=style %>">
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
	
</body>
</ibaHTML:html>

