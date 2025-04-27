<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eSS.Common.*, eSS.* " contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id			=		request.getParameter("bean_id");
	String bean_name		=		request.getParameter("bean_name");

	int functionType		=		Integer.parseInt(request.getParameter("function_type"));



	if ((bean_id == null) || (bean_id.equals("")))
		return;

	ROFEntryBean bean		=		(ROFEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	Hashtable hash			=		(Hashtable) XMLobj.parseXMLString(request);
    hash					=		 (Hashtable) hash.get ("SEARCH");

	switch (functionType) {
	case 1:
		{
			String doc_type_code	=		(String) hash.get("doc_type_code");
			if (doc_type_code.trim().equals("")) {
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
	case 2: // case - 2 will be executed on focus lost of Tray No
		{
				String group_code		=		(String) hash.get("group_code");
				String tray_no			=		(String) hash.get("tray_no");
				String sterilize_yn		=		(String) hash.get("sterilize_yn");
				String wash_yn			=		(String) hash.get("wash_yn");
				String pack_yn			=		(String) hash.get("pack_yn");
				boolean isValidTrayNo  =		bean.trayNoExists(group_code,tray_no, sterilize_yn, wash_yn, pack_yn);
				//out.println("alert("+isValidTrayNo+",\"\", \"0\");");
				out.println("assignResult("+isValidTrayNo+",\"\", \"0\");");
		}
		break;
	case 3: // case - 3 will be executed on changing group_code
		{
				String group_code = (String) hash.get("group_code");
				String sql = bean.getSsRepositoryValue("SQL_SS_GROUP_ROF_ENTRY_SELECT_SINGLE");
				HashMap hmDefaultValues = bean.fetchRecord(sql,group_code);
				out.println("document.formROFEntryDetail.sterile_type.value = '"+bean.checkForNull((String) hmDefaultValues.get("DEF_STERILE_TYPE"),"")+"';");
				out.println("document.formROFEntryDetail.wash_type.value ='"+bean.checkForNull((String)hmDefaultValues.get("DEF_WASHING_TYPE"),"")+"';");
				out.println("document.formROFEntryDetail.pack_item_code.value ='"+hmDefaultValues.get("PACK_ITEM_CODE")+"';");
 				out.println("document.formROFEntryDetail.pack_item_qty.value ='"+hmDefaultValues.get("PACK_ITEM_QTY")+"';");

		}
		break;
		case 6:
			{
					java.util.HashMap hmResult = null;

					if (hash.size() > 0) {
						hmResult = bean.updateTrayDetails(hash);
					}
					

					boolean result = ((Boolean)hmResult.get("result")).booleanValue();
					String message = (String)hmResult.get("msgid");
					String flag = (String)hmResult.get("flag");
					
					out.println("assignResult(" + result + ", \"" + message + "\", \""+flag+"\" ) ; ") ;
			}
			break;
		case 7:
		{
			String key = (String) hash.get("selected_key");
			if (key == null || (key.trim().equals(""))) {
				return;
			}
			String[] detail = bean.getDetail(key);
			out.println("var arrayObject = new Array();");
			for (int index=0;index<detail.length;index++ ) {
				out.println("arrayObject["+index+"] = '"+bean.checkForNull(detail[index])+"';");
			}
			out.println("editDetail(arrayObject);");
		}
		break;
		case 8 : 
			{
				int isValidDocDate = -1;
				String errorCode = null;
				String doc_date = (String) hash.get("doc_date");
				if (doc_date.trim().equals("")) {
					out.println("errorDisplay();"); // To be replaced with proper message
					return;
				}
				isValidDocDate = bean.isValidDocDate(doc_date);
				if (isValidDocDate > 0) {
					if (isValidDocDate== 1) {
						errorCode = "DOC_DT_NOT_LT_PROC_MTH";
					}
					else if (isValidDocDate== 2) {
						errorCode = "DOC_DT_NOT_GR_SYSDATE";
					}
					out.println("requestDocDateFocus();");

					out.println("assignResult(false,getMessage(\""+errorCode+"\",\"SS\"), \"0\")");//modified dt:4/7/08
					return;
				} 
				else {
					out.println("assignResult(true,\"\", \"0\");");
				}
				bean.updateSelectedTrays(hash);
			}
			break;
	default :
		//To be replaced with proper message
		out.println("alert(\'Invalid Function\');");
		return;
	}
	putObjectInBean(bean_id,bean,request);
%>
