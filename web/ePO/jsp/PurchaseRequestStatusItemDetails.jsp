<!DOCTYPE html>
<%@ page import ="javax.servlet.http.HttpServletRequest " contentType="text/html;charset=UTF-8" %>
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
	<script language='javascript' src='../js/PurchaseRequestStatusQuery.js'></script>
	<script language='javascript' src='../js/PoMessages.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%

	String docNo 		= "";
	String classvalue 	=	"";
	String item_code  	= "";
	item_code    		= request.getParameter("purchaseItem");
	docNo    			= request.getParameter("docNo");
	
	try
	{
		docNo        = CommonBean.checkForNull(docNo,"%");
		item_code    = CommonBean.checkForNull(item_code,"%");
				
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList chkFields			=		new ArrayList();
		ArrayList displayFields		=		new ArrayList();
				
		displayFields.add("ITEM_CODE");
		displayFields.add("ITEM_DESC");
		displayFields.add("UOM_DESC");
		displayFields.add("REQ_QTY");
		displayFields.add("PENDING_ORD_QTY");
		displayFields.add("remarks");
		
		chkFields.add((String)session.getAttribute("LOCALE"));
		chkFields.add(docNo);
		chkFields.add(item_code);
		
		sqlMap.put("sqlData", ePO.Common.PoRepository.getPoKeyValue("SQL_PURCHASE_REQUEST_STATUS_DETAILS_QUERY"));
		
		
		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);

			
		System.out.println("sqlMap result= "+sqlMap);
		System.out.println("chkFields result= "+chkFields);	
		
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);			

		System.out.println("funcMap result= "+result);
		
		
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
	<br>

	<table border=1 cellspacing=0 cellpadding='3' width='100%' >
		<tr>
			<th width='15%'><fmt:message key="ePO.purchaseItem.label" bundle="${st_labels}"/></th>
			<th width='30%'><fmt:message key="ePO.description.label" bundle="${st_labels}"/></th>
			<th width='15%'><fmt:message key="ePO.uom.label" bundle="${st_labels}"/></th>
			<th width='10%'><fmt:message key="ePO.requiredQty.label" bundle="${st_labels}"/></th>
			<th width='10%'><fmt:message key="ePO.pendingORDQty.label" bundle="${st_labels}"/></th>
			<th width='20%'><fmt:message key="ePO.Remarks.label" bundle="${st_labels}"/></th>
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
				
		%>		

			<td class="<%=classvalue%>"><%=CommonBean.checkForNull((String)records.get(0))%></td>
			<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(1))%></td>
			<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(2))%></td>
			<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(3))%></td>
			<td class="<%=classvalue%>"><%=CommonBean.checkForNull((String)records.get(4))%></td>
			<td class="<%=classvalue%>"><%=CommonBean.checkForNull((String)records.get(5))%></td>
		</tr>
		<%
			}
		%>

	</table>
	<br>
	<div style="float:right">
		<input type="button" class = 'BUTTON'  value ='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick ="window.close();">
	</div>

	<%
		out.flush();
	} 
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
</body>
</html>




