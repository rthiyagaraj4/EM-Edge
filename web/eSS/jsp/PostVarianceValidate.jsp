<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eSS.Common.*, eSS.* "%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id = request.getParameter("bean_id");
	String bean_name = request.getParameter("bean_name");
	int functionType = Integer.parseInt(request.getParameter("function_type"));
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	PostVarianceBean bean = (PostVarianceBean) getBeanObject(bean_id, bean_name,request);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	switch (functionType) {
	case 1:
		{
			String doc_type_code = (String) hash.get("doc_type_code");
			if (doc_type_code.trim().equals("")) {
				out.println("errorDisplay();");
				return;
			}
			if (!bean.isDocNoAutoGenYN(doc_type_code)) {
				out.println("enableDocNo();");
			}
			else {
				out.println("disableDocNo();");
			}
		}
		break;
	case 4: // This case will be executed on focus lost of Doc Date
		{
			int isValidDocDate = -1;
			String doc_date = (String) hash.get("doc_date");
			if (doc_date.trim().equals("")) {
				out.println("errorDisplay();"); // To be replaced with proper message
				return;
			}
			isValidDocDate = bean.isValidDocDate(doc_date);
			String errorCode = null;
			if (isValidDocDate > 0) {
				if (isValidDocDate== 1) {
					errorCode = "DOC_DT_NOT_LT_PROC_MTH";
				}
				else if (isValidDocDate== 2) {
					errorCode = "DOC_DT_NOT_GR_SYSDATE";
				}
				out.println("requestDocDateFocus("+isValidDocDate+");");
				out.println("assignResult(false,getMessage(\""+errorCode+"\"), \"0\")");
			} 
			else {
				out.println("assignResult(true,\"\", \"0\");");
				return;
			}
		}
		break;
	default :
		//To be replaced with proper message
		out.println("alert(\'Invalid Function\');");
		return;
	}


%>
<%
putObjectInBean(bean_id,bean,request);
%>
