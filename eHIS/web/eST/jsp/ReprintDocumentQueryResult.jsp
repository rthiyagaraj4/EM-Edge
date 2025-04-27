<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.lang.*,java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.* "%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<%
		request.setCharacterEncoding("UTF-8");

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language="javascript" src="../../eST/js/ReprintDocument.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
	<%
		String doc_type_code = request.getParameter("doc_type_code");
		String doc_no = request.getParameter("doc_no");
		String doc_date = request.getParameter("doc_date");
		String fm_store = request.getParameter("fm_store");
		String to_store = request.getParameter("to_store");
		//String item_class_code = request.getParameter("item_class_code");

		boolean searched = (request.getParameter("searched") == null) ?false:true;
		String classvalue = "";
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();
		ArrayList result			=		new ArrayList();
		ArrayList records			=		new ArrayList();
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			doc_type_code = CommonBean.checkForNull(doc_type_code,"%");
			doc_no = CommonBean.checkForNull(doc_no,"%");
			doc_date = CommonBean.checkForNull(doc_date,"%");
			fm_store = CommonBean.checkForNull(fm_store,"%");
			to_store = CommonBean.checkForNull(to_store,"%");
			//item_class_code = CommonBean.checkForNull(item_class_code,"%");

			sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_ISSUE_RETURN_HDR_QUERY_RESULT"));
			displayFields.add("DOC_TYPE_DESC");
			displayFields.add("DOC_NO");
			displayFields.add("DOC_DATE");
			displayFields.add("FM_STORE_DESC");
			displayFields.add("TO_STORE_DESC");
			//displayFields.add("ITEM_CLASS_DESC");
			displayFields.add("DOC_TYPE_CODE");
			displayFields.add("FM_STORE_CODE");
			displayFields.add("TO_STORE_CODE");
			//displayFields.add("ITEM_CLASS_CODE");

			chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			chkFields.add(doc_date);
			chkFields.add(fm_store);
			chkFields.add(to_store);
			//chkFields.add(item_class_code);
			chkFields.add(CommonBean.getLoginById());
			chkFields.add(CommonBean.getLoginFacilityId());
//			chkFields.add(session.getAttribute("ACC_ENTITY_ID"));
//			chkFields.add(CommonBean.getLoginFacilityId());

out.println(displayFields);
			// Adding function related array list into the HashMap
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);

			result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
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
					<th width='260'><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
					<th width='125'><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
					<th width='125'><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
					<th width='260'><fmt:message key="Common.FromStore.label" bundle="${common_labels}"/></th>
					<th width='260'><fmt:message key="Common.ToStore.label" bundle="${common_labels}"/></th>
                </tr>		

   		<%
			for(int recCount=2; recCount<result.size(); recCount++) {
				if (recCount % 2 == 0)
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
				<tr onClick="Modify(this);" >
		<%
	//pmd 29/01/05
		//				String link_columns = "1";
				records=(ArrayList) result.get(recCount);
		%>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get(0)%></font></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(1)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(2)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(3)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(4)%></td>
				<td class='NODISPLAY'><%=records.get(5)%></td>
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
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA"));
				document.location.href="../../eCommon/html/blank.html";
				//history.go(-1);
			</script>
		<%
		}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/ReprintDocumentQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}finally{
		sqlMap.clear();	
		funcMap.clear();
		displayFields.clear();
		chkFields.clear();		
		result.clear();		
		records.clear();		
	}
%>
</body>
</html>

