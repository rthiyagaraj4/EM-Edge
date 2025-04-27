<!DOCTYPE html>
<%@ page import ="javax.servlet.http.HttpServletRequest,java.io.UnsupportedEncodingException,
java.net.URLEncoder " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>

<html>
<head>
	<title><fmt:message key="ePO.ItemDetails.label" bundle="${po_labels}"/></title>
 <%
    request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eCommon/js/CommonCalendar.js" type="text/javascript"></script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
	<script language='javascript' src='../js/PurchaseOrderStatusQuery.js'></script>
	<script language='javascript' src='../js/PoMessages.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">


<%
	
	String docNo 			= "";
	String item_code        = "";
	String classvalue 		=	"";
	docNo = request.getParameter("docNo");
	item_code = request.getParameter("purchaseItem");
	
	try
	{
		docNo        = CommonBean.checkForNull(docNo,"");
		item_code    = CommonBean.checkForNull(item_code,"%");
		
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList chkFields			=		new ArrayList();
		ArrayList displayFields		=		new ArrayList();
		
		displayFields.add("ITEM_CODE");
		displayFields.add("ITEM_DESC");
		displayFields.add("UOM_DESC");
		displayFields.add("REQ_QTY");
		displayFields.add("PO_QTY");
		displayFields.add("PENDING_GRN_QTY");
		displayFields.add("APPROVAL_REF_NO");
		displayFields.add("ITEM_REMARKS");
		
		chkFields.add((String)session.getAttribute("LOCALE"));
		chkFields.add(docNo);
		chkFields.add(item_code);
		
		sqlMap.put("sqlData", ePO.Common.PoRepository.getPoKeyValue("SQL_PURCHASE_ORDER_STATUS_DETAILS_QUERY"));
		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);

		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);			


	if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){	

%>

	<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
			<td width="80%" class="white">&nbsp;PO No :&nbsp;<%=docNo%></td>
			<td width="20%" class="white">&nbsp;
			<%
				out.println(result.get(1));
			%>
			</td>
		</tr>
	</table>
	<br>			

	<table border=1 cellspacing=0 cellpadding='3' width='100%'>
		<tr>
			<th width='15%'><fmt:message key="ePO.purchaseItem.label" bundle="${st_labels}"/></th>
			<th width='20%'><fmt:message key="ePO.description.label" bundle="${st_labels}"/></th>
			<th width='15%'><fmt:message key="ePO.uom.label" bundle="${st_labels}"/></th>
			<th width='10%'><fmt:message key="ePO.requiredQty.label" bundle="${st_labels}"/></th>
			<th width='10%'><fmt:message key="ePO.poQty.label" bundle="${st_labels}"/></th>
			<th width='10%'><fmt:message key="ePO.pendingGRNQty.label" bundle="${st_labels}"/></th>
			<th width='20%'><fmt:message key="ePO.approvalRefNo.label" bundle="${st_labels}"/></th>
			<th width='20%'><fmt:message key="ePO.ItemRemarks.label" bundle="${po_labels}"/></th>
		</tr>

		<%
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if (recCount % 2 == 0)
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
		<tr>

		<%
			records=(ArrayList) result.get(recCount);
			String item_remarks = CommonBean.checkForNull((String)records.get(7));
			item_remarks = URLEncoder.encode(item_remarks, "UTF-8").replaceAll("\\+", "%20") ;
				
		%>	

				<td class="<%=classvalue%>" onclick="callItemSchDetails('<%=docNo%>','<%=CommonBean.checkForNull((String)records.get(0))%>','<%=CommonBean.checkForNull((String)records.get(1))%>','<%=CommonBean.checkForNull((String)records.get(2))%>');" onmouseover="changeCursor(this);" nowrap><font class='HYPERLINK'><%=CommonBean.checkForNull((String)records.get(0))%></font></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(1))%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(2))%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" style="TEXT-ALIGN:right"><%=CommonBean.checkForNull((String)records.get(3),"&nbsp;")%></td>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><%=CommonBean.checkForNull((String)records.get(4))%></td>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><%=CommonBean.checkForNull((String)records.get(5))%></td>
				<td class="<%=classvalue%>"><%=CommonBean.checkForNull((String)records.get(6))%></td>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onclick="showRemarks('<%=recCount%>','<%=item_remarks%>');"><font class="HYPERLINK"><fmt:message key="eSS.Remarks.label" bundle="${ss_labels}"/></font></td>
				
		</tr>
		<%
			}
		%>
	</table>

	<br>

	<div style="float:right">
		<input type="button" class = 'BUTTON'  value ='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick ="window.close();">&nbsp;&nbsp;&nbsp;&nbsp;
	</div>

	<%
		out.flush();
	}else{
	%>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			document.location.href="../../eCommon/html/blank.html";
		</script>
	<%	
		
	}
		
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
</body>
</html>
		

