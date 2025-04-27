<!DOCTYPE html>
<%@ page import ="java.util.*,javax.servlet.http.HttpServletRequest " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>

<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
	String locale			=		(String)session.getAttribute("LOCALE");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script src="../../eCommon/js/CommonCalendar.js" type="text/javascript"></script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
	<script language='javascript' src='../js/PurchaseRequestStatusQuery.js'></script>
	<script language='javascript' src='../js/PoMessages.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
<%
	System.out.println("entering PurchaseRequestStatusQueryResult.jsp ");
	
	String reqByStore		= "";
	String purchaseUnit		= "";
	String item         	= "";
	String requestType		= "";
	String docNo         	= "";
	
	String requestStatus  	= "";
	String docDtFrom    	= "";
	String docDtTo			= "";
	
	String docDateVal 		= "";
	String reqStoreVal 		= "";
	boolean searched = (request.getParameter("searched") == null) ?false:true;
	String classvalue 		=	"";
	
	
	HashMap<String,String> reqStatusMap = new HashMap<String,String>();
	reqStatusMap.put("UF","Unfinalized");
	reqStatusMap.put("FA","Fully Approved");
	reqStatusMap.put("CA","Cancelled");
	reqStatusMap.put("OR","Ordered");
	reqStatusMap.put("PO","Partially Ordered");//Added by Sakti against inc#44626
	
	reqByStore   	= request.getParameter("reqByStore");
	purchaseUnit 	= request.getParameter("purchaseUnit");
	requestType 	= request.getParameter("requestType");
	docNo        	= request.getParameter("docNo");
	requestStatus   = request.getParameter("requestStatus");
	docDtFrom    	= request.getParameter("docDtFrom");
	docDtTo		 	= request.getParameter("docDtTo");
	item         	= request.getParameter("requestItem");
	

	
	try
	{
		CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
		
		reqByStore  	= CommonBean.checkForNull(reqByStore,"%");
		purchaseUnit 	= CommonBean.checkForNull(purchaseUnit,"%");
		requestType  	= CommonBean.checkForNull(requestType,"%");
		docNo        	= CommonBean.checkForNull(docNo,"%");
		requestStatus 	= CommonBean.checkForNull(requestStatus,"%");
		docDtFrom    	= CommonBean.checkForNull(docDtFrom,"");
		docDtTo		 	= CommonBean.checkForNull(docDtTo,"");
		item         	= CommonBean.checkForNull(item,"%");
		
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList chkFields			=		new ArrayList();
		ArrayList displayFields		=		new ArrayList();
		
		sqlMap.put("sqlData", ePO.Common.PoRepository.getPoKeyValue("SQL_PURCHASE_REQUEST_STATUS_QUERY"));
		
		displayFields.add("req_no");
		displayFields.add("req_date");
		displayFields.add("store_code_desc");
		displayFields.add("purchase_unit_desc");
		displayFields.add("request_type_name");
		displayFields.add("request_status");
		
		chkFields.add((String)session.getAttribute("LOCALE"));
		chkFields.add(purchaseUnit);
		chkFields.add(reqByStore);
		chkFields.add(requestType);
		chkFields.add(docNo);
		chkFields.add(requestStatus);
		chkFields.add(item);
		chkFields.add(docDtFrom);
		chkFields.add(docDtTo);
		chkFields.add("POREQN");   // Added By Padmapriya INC # 34805 on 07/09/2012
		
		
		
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
	
	<table border=1 cellspacing="0" cellpadding='0' width='100%' align=center>
		<tr>
			<th width='17%'><fmt:message key="ePO.RequestNo.label" bundle="${po_labels}"/></th>
			<th width='10%'><fmt:message key="ePO.documentDate.label" bundle="${po_labels}"/></th>
			<th width='15%'><fmt:message key="ePO.reqStore.label" bundle="${po_labels}"/></th>
			<th width='16%'><fmt:message key="ePO.PurchaseUnit.label" bundle="${po_labels}"/></th>
			<th  width='15%'><fmt:message key="ePO.RequestType.label" bundle="${po_labels}"/></th>
			<th width='17%'><fmt:message key="ePO.requestStatus.label" bundle="${po_labels}"/></th>
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
			String tempReqStatus = "";
			tempReqStatus = CommonBean.checkForNull((String)records.get(5)); 
			if(!tempReqStatus.equals(""))
				tempReqStatus = reqStatusMap.get(tempReqStatus);
				
	%>		

			<td class="<%=classvalue%>" onclick="callItemDetails('<%=tempDocNo%>','<%=item%>');" onmouseover="changeCursor(this);" nowrap><font class='HYPERLINK'><font size=1><%=tempDocNo%></font></td>
			<td class="<%=classvalue%>" onclick="disableClick(event);"><font size=1><%=tempDate%></td>
			<td class="<%=classvalue%>" onclick="disableClick(event);"><font size=1><%=CommonBean.checkForNull((String)records.get(2))%></td>
			<td class="<%=classvalue%>" onclick="disableClick(event);"><font size=1><%=CommonBean.checkForNull((String)records.get(3))%></td>
			<td class="<%=classvalue%>"><font size=1><%=CommonBean.checkForNull((String)records.get(4))%></td>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);" onclick="auditInfoSubmit('<%=tempDocNo%>')" ><font class='HYPERLINK'><font size=1><%=CommonBean.checkForNull(tempReqStatus)%></font></td>
		</tr>
	<%
			}
	%>
	</table>
	<%
		out.flush();
	} else{
	%>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			document.location.href="../../eCommon/html/blank.html";
			//history.go(-1);
		</script>
	<%
		}
		out.println(CommonBean.setForm (request ,"../../ePO/jsp/PurchaseRequestStatusQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
</body>
</html>

		
		

