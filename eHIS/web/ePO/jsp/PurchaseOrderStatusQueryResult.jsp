<!DOCTYPE html>
<%@ page import ="java.util.*,javax.servlet.http.HttpServletRequest " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>

<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
	String locale =	(String)session.getAttribute("LOCALE");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eCommon/js/CommonCalendar.js" type="text/javascript"></script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
	<script language='javascript' src='../js/PurchaseOrderStatusQuery.js'></script>
	<script language='javascript' src='../js/PoMessages.js'></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>

<%
	
	String reqByStore   = "";
	String purchaseUnit = "";
	String supplierCode = "";
	String purchaseType = "";
	String docNo        = "";
	String item         = "";
	String orderStatus  = "";
	String docDtFrom    = "";
	String docDtTo		= "";
	boolean searched	=(request.getParameter("searched") == null) ?false:true;
	String docDateVal 	= "";
	String reqStoreVal 	= "";
	String[] setStringValues = null;
	setStringValues = new String[9];
	
		
	HashMap<String,String> ordrStatusMap = new HashMap<String,String>();
	ordrStatusMap.put("UF","Unfinalized");
	ordrStatusMap.put("PA","Partially Approved");
	ordrStatusMap.put("FA","Fully Approved");
	ordrStatusMap.put("AM","Amend");
	ordrStatusMap.put("RA","Re-Approved");
	ordrStatusMap.put("CA","Cancelled");
	ordrStatusMap.put("PD","Partially delivered");
	ordrStatusMap.put("FD","Fully Delivered");
	ordrStatusMap.put("CL","Closed");
	ordrStatusMap.put("PR","Partially Received");
	ordrStatusMap.put("FR","Fully Received");
	String classvalue		=		"";
	
	reqByStore   = request.getParameter("reqByStore");
	purchaseUnit = request.getParameter("purchaseUnit");
	supplierCode = request.getParameter("supplierCode");
	purchaseType = request.getParameter("purchaseType");
	docNo        = request.getParameter("docNo");
	item         = request.getParameter("purchaseItem");
	orderStatus  = request.getParameter("orderStatus");
	docDtFrom    = request.getParameter("docDtFrom");
	docDtTo		 = request.getParameter("docDtTo");
	
	try
	{
		CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
		reqByStore = CommonBean.checkForNull(reqByStore,"%");
		purchaseUnit = CommonBean.checkForNull(purchaseUnit,"%");
		supplierCode = CommonBean.checkForNull(supplierCode,"%");
		purchaseType = CommonBean.checkForNull(purchaseType,"%");
		docNo = CommonBean.checkForNull(docNo,"%");
		item = CommonBean.checkForNull(item,"%");
		orderStatus = CommonBean.checkForNull(orderStatus,"%");
		docDtFrom = CommonBean.checkForNull(docDtFrom,"");
		docDtTo = CommonBean.checkForNull(docDtTo,"");
		
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList chkFields			=		new ArrayList();
		ArrayList displayFields		=		new ArrayList();
		
		sqlMap.put("sqlData", ePO.Common.PoRepository.getPoKeyValue("SQL_PURCHASE_ORDER_STATUS_QUERY"));
					   
		displayFields.add("po_no");
		displayFields.add("po_date");
		displayFields.add("store_code_desc");
		displayFields.add("purchase_unit_desc");
		displayFields.add("supplier_name");
		displayFields.add("purchase_type_name");
		displayFields.add("order_status");
		
		chkFields.add((String)session.getAttribute("LOCALE"));
		chkFields.add((String)session.getAttribute("LOCALE"));
		chkFields.add(CommonBean.getLoginById());
		chkFields.add(purchaseUnit);
		chkFields.add(supplierCode);
		chkFields.add(purchaseType);
		chkFields.add(docNo);
		chkFields.add(orderStatus);
		chkFields.add(item);
		chkFields.add(docDtFrom);
		chkFields.add(docDtTo);
		chkFields.add("PORDER");   // Added By Padmapriya INC # 34805 on 07/09/2012
		
		
		// Adding function related array list into the HashMap
		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);

		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
%>
		<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%
					out.println(result.get(1));
				%>
				</td>
			</tr>
		</table>
			
			<table border=1 cellspacing=0 cellpadding='3' width='100%' align=center>
				<tr>
					<th width='17%'><fmt:message key="ePO.PONo.label" bundle="${po_labels}"/></th>
					<th width='10%'><fmt:message key="ePO.documentDate.label" bundle="${po_labels}"/></th>
					<th width='15%'><fmt:message key="ePO.reqStore.label" bundle="${po_labels}"/></th>
					<th width='16%'><fmt:message key="ePO.PurchaseUnit.label" bundle="${po_labels}"/></th>
					<th width='10%'><fmt:message key="ePO.Supplier.label" bundle="${po_labels}"/></th>
					<th width='15%'><fmt:message key="ePO.PurchaseType.label" bundle="${po_labels}"/></th>
					<th width='17%'><fmt:message key="ePO.orderStatus.label" bundle="${po_labels}"/></th>
				 
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
				
				String tempDocNo = "";
				tempDocNo = CommonBean.checkForNull((String)records.get(0));
				String tempDate = "";
				tempDate = CommonBean.checkForNull((String)records.get(1));
				if(!tempDate.equals(""))
				tempDate = com.ehis.util.DateUtils.convertDate(tempDate,"DMY","en",locale);
				
				//commented on 25/09/12
				/*String tempStore = "";
				tempStore = CommonBean.checkForNull((String)records.get(2));
				if(tempStore.equals(""))
				 tempStore = "*A";*/
				  
				
				
				String tempOrdrStatus = "";
				tempOrdrStatus = CommonBean.checkForNull((String)records.get(6));
				if(!tempOrdrStatus.equals(""))
				tempOrdrStatus = ordrStatusMap.get(tempOrdrStatus);
				
			%>
				<td class="<%=classvalue%>" onclick="callItemDetails('<%=tempDocNo%>','<%=item%>');" onmouseover="changeCursor(this);" nowrap><font class='HYPERLINK'><font size=1><%=tempDocNo%></font></td>
				<td class="<%=classvalue%>" align='center' onclick="disableClick(event);"><font size=1><%=tempDate%> </td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><font size=1><%=CommonBean.checkForNull((String)records.get(2),"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><font size=1><%=CommonBean.checkForNull((String)records.get(3))%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><font size=1><%=CommonBean.checkForNull((String)records.get(4))%></td>
				<td class="<%=classvalue%>"><font size=1><%=CommonBean.checkForNull((String)records.get(5))%></td>
				<td class="<%=classvalue%>" onclick="auditInfoSubmit('<%=tempDocNo%>')" onmouseover="changeCursor(this);">
					<font class='HYPERLINK'><font size=1><%=tempOrdrStatus%></font>
				</td>
				
			</tr>
			<%
					}
			%>
		</table>
		<%
			out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		}
	
		out.println(CommonBean.setForm (request ,"../../ePO/jsp/PurchaseOrderStatusQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
		//e.printStackTrace();
	}
%>

</body>
</html>








