<!DOCTYPE html>
<%@page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.*,java.lang.* " contentType="text/html;charset=UTF-8"%>
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
		<script language="javascript" src="../../eST/js/ReplacementGRN.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
	<%
		String doc_type_code = request.getParameter("doc_type_code");
		String doc_no = request.getParameter("doc_no");
		String doc_date = request.getParameter("doc_date");
		String store_code= request.getParameter("store_code");
		String supp_code= request.getParameter("supp_code");
		String entry_completed_yn= request.getParameter("entry_completed_yn");
				String language_id = request.getParameter("language_id");
// pmd 29/01/05
//		String encounter_id= request.getParameter("encounter_id");

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
			store_code = CommonBean.checkForNull(store_code,"%");
			supp_code = CommonBean.checkForNull(supp_code,"%");

			sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_GRN_HDR_QUERY_RESULT"));
			displayFields.add("DOC_TYPE_DESC");
			displayFields.add("DOC_NO");
			displayFields.add("DOC_DATE");
			displayFields.add("STORE_DESC");
			displayFields.add("DOC_TYPE_CODE");
			displayFields.add("STORE_CODE");
			displayFields.add("SUPP_DESC");

			chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			chkFields.add(doc_date);
			chkFields.add(store_code);
			chkFields.add(CommonBean.getLoginById());
			chkFields.add(CommonBean.getLoginFacilityId());
			chkFields.add(entry_completed_yn);
			chkFields.add(supp_code);
			chkFields.add(language_id);

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
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" >
				<tr>
					<th><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/></th>
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
//				String link_columns = "1";
				records=(ArrayList) result.get(recCount);
		%>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get(0)%></font></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=records.get(1)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=records.get(2)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(3)%></td>
				<td class='NODISPLAY'><%=records.get(4)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(6)%></td>
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
		out.println(CommonBean.setForm (request ,"../../eST/jsp/ReplacementGRNQueryResult.jsp", searched));
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

