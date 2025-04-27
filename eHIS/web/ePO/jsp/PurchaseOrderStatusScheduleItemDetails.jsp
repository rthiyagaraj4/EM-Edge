<!DOCTYPE html>
<%@ page import ="javax.servlet.http.HttpServletRequest " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>

<html>
<head>
	<title>Order Schedule Details</title>
 <%
    request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
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
	String Item_desc        = "";
	String uom_desc        = "";
	docNo = request.getParameter("docNo");
	item_code = request.getParameter("purchaseItem");
	Item_desc = request.getParameter("Item_desc");
	uom_desc = request.getParameter("uom_desc");
	
	try
	{
		docNo        = CommonBean.checkForNull(docNo,"");
		item_code    = CommonBean.checkForNull(item_code);
		
		
		System.out.println("item .jsp in sch detail  docNo : "+docNo+" , item_code : "+item_code);
		
		
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList chkFields			=		new ArrayList();
		ArrayList displayFields		=		new ArrayList();
		
		displayFields.add("ITEM_CODE");
		displayFields.add("ITEM_DESC");
		displayFields.add("PO_NO");
		displayFields.add("PO_SRL_NO");
		displayFields.add("DELV_SRL_NO");
		displayFields.add("DELV_QTY");
		displayFields.add("DELV_DATE");
		displayFields.add("DELV_STATUS");
		displayFields.add("DELIVERED_QTY");
		displayFields.add("DO_NO");
		
		chkFields.add((String)session.getAttribute("LOCALE"));
		chkFields.add(docNo);
		chkFields.add(item_code);
		
		sqlMap.put("sqlData", ePO.Common.PoRepository.getPoKeyValue("SQL_PURCHASE_ORDER_STATUS_SCH_DETAILS_QUERY"));
		
		
		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);

		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);			

		System.out.println("funcMap result= "+result);
		System.out.println("funcMap sql = "+ ePO.Common.PoRepository.getPoKeyValue("SQL_PURCHASE_ORDER_STATUS_SCH_DETAILS_QUERY"));
		
		
	if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){	

%>

	<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
			<td width="30%" class="white">&nbsp;<fmt:message key="ePO.OrderNo.label" bundle="${po_labels}"/> :&nbsp;<%=docNo%></td>
			<td width="30%" class="white">&nbsp;<fmt:message key="ePO.Item.label" bundle="${po_labels}"/> : &nbsp;<%=item_code%>&nbsp;&nbsp;&nbsp;<%=Item_desc%></td>
	
		</tr>

	</table>
	<br>			

	<table border=1 cellspacing=0 cellpadding='3' width='100%'>
		<tr>
			
			<th width='8%'><fmt:message key="ePO.ScheduleNo.label" bundle="${po_labels}"/></th>
			<th width='10%'><fmt:message key="ePO.ScheduleDate.label" bundle="${po_labels}"/></th>
			<th width='10%'><fmt:message key="ePO.uom.label" bundle="${po_labels}"/></th>
			<th width='10%'><fmt:message key="ePO.OrderQty.label" bundle="${po_labels}"/></th>
			<th width='10%'><fmt:message key="ePO.DeliveredQty.label" bundle="${po_labels}"/></th></th>
			<th width='10%'><fmt:message key="ePO.DeliveryNo.label" bundle="${po_labels}"/></th></th></th>
			<th width='10%'><fmt:message key="ePO.DeliveryStatus.label" bundle="${po_labels}"/></th></th></th>
			
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
		System.out.println(" records= "+records);
				
		%>	

		
				<td class="<%=classvalue%>"><%=CommonBean.checkForNull((String)records.get(4))%></td>
				<td class="<%=classvalue%>"><%=com.ehis.util.DateUtils.convertDate((String)records.get(6),"DMY","en",locale)%></td>
				<td class="<%=classvalue%>"><%=uom_desc%></td>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><%=CommonBean.checkForNull((String)records.get(5))%></td>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right"><%=CommonBean.checkForNull((String)records.get(8),"&nbsp;")%></td>
				<td class="<%=classvalue%>"><%=CommonBean.checkForNull((String)records.get(9),"&nbsp;")%></td>
				<td class="<%=classvalue%>"><%=CommonBean.checkForNull((String)records.get(7),"&nbsp;")%></td>
				
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
			window.close();
			//document.location.href="../../eCommon/html/blank.html";
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
		

