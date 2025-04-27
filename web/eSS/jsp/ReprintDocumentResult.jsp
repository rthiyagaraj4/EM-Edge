<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"
	import="java.lang.*,java.util.HashMap,java.util.ArrayList,java.util.Properties,eSS.Common.*,eSS.*,eCommon.Common.*"%>

<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String locale = (String) session.getAttribute("LOCALE");

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String facility_id = (String) session.getValue("facility_id");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eSS/js/SsCommon.js'></script>
<!-- 		<script language='javascript' src='../../eST/js/StMessages.js'></script> -->
<script language="javascript" src="../../eSS/js/ReprintDocument.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
	<form name="RePrintDocumentResult" id="RePrintDocumentResult">
		<%
			String trn_type = request.getParameter("p_trn_type");
			String doc_type_code = request.getParameter("p_doc_type_code");
			String fr_st_code = request.getParameter("store_code") + "%";
			String dt_from = request.getParameter("dt_from");
			String dt_to = request.getParameter("dt_to");
			String doc_no = request.getParameter("p_doc_no");
			if (trn_type == null)
				trn_type = "";
			if (doc_type_code == null)
				doc_type_code = "";
			if (fr_st_code == null)
				fr_st_code = "";
			if (dt_from == null)
				dt_from = "";
			if (dt_to == null)
				dt_to = "";
			if (doc_no == null)
				doc_no = "";
			String doc_type = "";
			String doc_desc = "";
			String docno = "";
			String docdate = "";
			String doc_ref = "";
			String fm_store_code = "";
			String fm_store_desc = "";
			String to_store_code = "";
			String to_store_desc = "";
			String store_code = "";
			String store_desc = "";
			String store_code_for_passing = "";
			try {
				String bean_id = "RePrintDocReportBean";
				String bean_name = "eSS.RePrintDocReportBean";

				RePrintDocReportBean bean = (RePrintDocReportBean) getBeanObject(
						bean_id, bean_name, request);
				bean.setLanguageId(locale);
				ArrayList result = bean.getResult(trn_type, doc_type_code,
						fr_st_code, dt_from, dt_to, doc_no);
				String classValue = "";
				if (result.size() != 0) {
		%>
		<table cellpadding="0" cellspacing="0" width="100%" align="center"
			border="1" id="reprint_rep">
			<%
				if ((trn_type.equals("REQ")) || (trn_type.equals("RTG"))) {
			%>
			<tr>
				<th><fmt:message key="Common.DocType.label"
						bundle="${common_labels}" /></th>
				<th><fmt:message key="Common.DocNo.label"
						bundle="${common_labels}" /></th>
				<th><fmt:message key="Common.DocDate.label"
						bundle="${common_labels}" /></th>
				<th><fmt:message key="Common.DocRef.label"
						bundle="${common_labels}" /></th>
				<th><fmt:message key="Common.FromStore.label"
						bundle="${common_labels}" /></th>
				<th><fmt:message key="Common.ToStore.label"
						bundle="${common_labels}" /></th>
			</tr>

			<%
				}
			%>

			<%
				for (int i = 0; i < result.size(); i++) {

							int pos = 0;

							if (i % 2 == 0)
								classValue = "QRYEVEN";
							else
								classValue = "QRYODD";

							ArrayList record = (ArrayList) result.get(i);
							doc_type = (String) record.get(pos);
							doc_desc = (String) record.get(++pos);
							docno = (String) record.get(++pos);
							docdate = (String) record.get(++pos);
							doc_ref = (String) record.get(++pos);
							fm_store_code = (String) record.get(++pos);
							fm_store_desc = (String) record.get(++pos);
							to_store_code = (String) record.get(++pos);
							to_store_desc = (String) record.get(++pos);
							store_code_for_passing = fm_store_code;
							docdate = com.ehis.util.DateUtils.convertDate(docdate,
									"DMY", "en", locale);
			%>
			<tr>


				<td class="<%=classValue%>"><label
					style="cursor: hand; color: blue"
					onClick="callReport('<%=doc_type%>','<%=docno%>','<%=store_code_for_passing%>','<%=trn_type%>')">
						<%=doc_desc%></label></td>
				<td class="<%=classValue%>"><label
					style="cursor: hand; color: blue"
					onClick="callReport('<%=doc_type%>','<%=docno%>','<%=store_code_for_passing%>','<%=trn_type%>')">
						<%=docno%></label></td>
				<td class="<%=classValue%>"><%=docdate%></td>
				<td class="<%=classValue%>"><%=CommonBean.checkForNull(doc_ref, "&nbsp;")%></td>
				<td class="<%=classValue%>"><%=fm_store_desc%></td>
				<td class="<%=classValue%>"><%=to_store_desc%></td>
				<%
					if (!store_desc.equals("")) {
				%>
				<td class="<%=classValue%>"><%=store_desc%></td>
				<%
					}
				%>
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
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA", "Common"));
			document.location.href = "../../eCommon/html/blank.html	";
			//history.go(-1);
		</script>
		<%
			}
				putObjectInBean(bean_id, bean, request);

			} catch (Exception e) {
				e.printStackTrace();
				// out.print("Exception @ Result JSP :" + e.toString());
			}
		%>
	</form>
</body>
</html>

