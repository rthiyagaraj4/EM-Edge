<!DOCTYPE html>
<%@page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,ePO.* " contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%

			request.setCharacterEncoding("UTF-8");
			String locale			=		(String)session.getAttribute("LOCALE");
		
			String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../ePO/js/PoCommon.js'></script>
		<script language="javascript" src="../../ePO/js/STPORequest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body>
	<%
		String doc_type_code			=		request.getParameter("doc_type_code");
		String doc_no					=		request.getParameter("doc_no");
		String doc_date					=		com.ehis.util.DateUtils.convertDate(request.getParameter("doc_date"),"DMY",locale,"en");
		String request_by_store			=		request.getParameter("request_by_store");
		String request_on_store			=		request.getParameter("request_on_store");
		String item_class_code			=		request.getParameter("item_class_code");

		boolean searched				=		(request.getParameter("searched") == null) ?false:true;
		String classvalue				=		"";
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			doc_type_code				=		CommonBean.checkForNull(doc_type_code,"%");
			doc_no						=		CommonBean.checkForNull(doc_no,"%");
			doc_date					=		CommonBean.checkForNull(doc_date,"%");
			request_by_store			=		CommonBean.checkForNull(request_by_store,"%");
			request_on_store			=		CommonBean.checkForNull(request_on_store,"%");
			item_class_code				=		CommonBean.checkForNull(item_class_code,"%");

			HashMap sqlMap				=		new HashMap();
			HashMap funcMap				=		new HashMap();
			ArrayList chkFields			=		new ArrayList();
			ArrayList displayFields		=		new ArrayList();
			sqlMap.put("sqlData", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_REQUEST_HEADER_SELECT"));
			
			displayFields.add("DOC_TYPE_DESC");
			displayFields.add("DOC_NO");
			displayFields.add("DOC_DATE");
			displayFields.add("REQ_BY_STORE_DESC");
			displayFields.add("REQ_ON_DEPT_DESC");
			displayFields.add("ITEM_CLASS_DESC");
			displayFields.add("DOC_TYPE_CODE");
			displayFields.add("REQ_STORE_CODE");
			displayFields.add("PUR_UNIT_CODE");
			displayFields.add("ITEM_CLASS_CODE");
			
			 

			chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			chkFields.add(doc_date);
			chkFields.add(request_by_store);
			chkFields.add(request_on_store);
			chkFields.add(item_class_code);
			chkFields.add(CommonBean.getLoginById());
			chkFields.add(CommonBean.getLoginFacilityId());
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add("POREQN");

			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);

			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);			

			System.out.println("funcMap chkFields= "+chkFields);
			
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
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
				<tr>
					<th width='260'><fmt:message key="ePO.RequestType.label" bundle="${po_labels}"/></th>
					<th width='125'><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
					<th width='125'><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
					<th width='260'><fmt:message key="ePO.RequestbyStore.label" bundle="${po_labels}"/></th>
					<th width='260'><fmt:message key="ePO.PORaisedBy.label" bundle="${po_labels}"/></th> 		
				   <!-- <th width='260'><fmt:message key="Common.ItemClass.label" bundle="${mm_labels}"/></th>-->
				</tr>		
		<%
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if (recCount % 2 == 0)
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
				<tr onClick="Modify(this);" >
		<%

				records=(ArrayList) result.get(recCount);
		%>		
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(0)%></td>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" nowrap><font class='HYPERLINK'><%=(String)records.get(1)%></font></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=com.ehis.util.DateUtils.convertDate((String)records.get(2),"DMY","en",locale)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(3)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(4)%></td>
				<!--<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(5),"&nbsp;")%></td>-->
				<td class='NODISPLAY'><%=records.get(6)%></td>
				<td class='NODISPLAY'><%=records.get(9)%></td>
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
				//history.go(-1);
			</script>
		<%
		}
		out.println(CommonBean.setForm (request ,"../../ePO/jsp/STPORequestQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
</body>
</html>

