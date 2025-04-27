<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"
	import="eSS.*,eSS.Common.*,java.util.*,java.lang.*,java.sql.*,webbeans.eCommon.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<jsp:useBean id="XMLobj" scope="page"
	class="webbeans.eCommon.XMLStringParser" />
<%
	request.setCharacterEncoding("UTF-8");
	String locale = (String) session.getAttribute("LOCALE");

	String bean_id = "RePrintDocReportBean";
	String bean_name = "eSS.RePrintDocReportBean";
	RePrintDocReportBean bean = (RePrintDocReportBean) getBeanObject(
			bean_id, bean_name, request);
	bean.setLanguageId(locale);
	String validate = request.getParameter("validate");
	String trn_type = request.getParameter("trn_type");
	HashMap hmReportId = new HashMap();
	hmReportId.put("REQ", "SSREQGRPFRM");
	hmReportId.put("RTG", "SSRTNGRPFRM");
	try {
		if (validate.equals("POPULATE_DOC_TYPE_CODE")) {
			out.println("clearListItems('document.ReprintDocumentCriteria.doc_type_code'); ");
			ArrayList ssParameters = new ArrayList();
			ssParameters.add(trn_type);
			ssParameters.add(bean.getLanguageId());
			ArrayList alEncounterList = new ArrayList();
			alEncounterList = bean
					.fetchRecords(
							"select a.doc_type_code,b.short_desc from ss_trn_doc_type a, sy_doc_type_master_lang_vw b  where a.doc_type_code= b.doc_type_code and a.trn_type =?  AND b.language_id=?",
							ssParameters);
			for (int i = 0; i < alEncounterList.size(); i++) {
				HashMap record = (HashMap) alEncounterList.get(i);
				String listRecord = (String) record
						.get("DOC_TYPE_CODE");
				String desc = (String) record.get("SHORT_DESC");
				out.println("addListItem12(\"document.ReprintDocumentCriteria.doc_type_code\", \""
						+ listRecord + "\",\"" + desc + "\") ; ");
			}
			out.println("document.ReprintDocumentCriteria.p_report_id.value=\""
					+ hmReportId.get(trn_type) + "\"");

		}
	} catch (Exception exception) {
		exception.printStackTrace();
	} finally {
	}
%>
<%
	putObjectInBean(bean_id, bean, request);
%>
