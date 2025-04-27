
<%@	page import="java.util.Hashtable,java.util.HashMap, eST.Common.*, eST.POGenerateRequestBean" contentType="text/html;charset=UTF-8"%>
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");

	String locale							=		(String)session.getAttribute("LOCALE");
	String bean_id							=		"pogenerateRequestBean";
	String bean_name						=		"eST.POGenerateRequestBean";
	
	String  functionType					=		request.getParameter("function_type");
	
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	POGenerateRequestBean bean				=		(POGenerateRequestBean) getBeanObject(bean_id, bean_name,request  );
	bean.setLanguageId(locale);

	Hashtable hash							=		(Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
		if(functionType.equals("VALIDATEDOCNO")){	
				String doc_type_code = (String) hash.get("doc_type_code");
				String isDocNoAutoGenYN=bean.checkForNull( (String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_DEF_DOC_GEN_YN_SELECT"),bean.checkForNull(doc_type_code)).get("DOC_NUM_GEN_FLAG"),"N");
				out.println("enableDocNo('"+isDocNoAutoGenYN+"');");
		}else if(functionType.equals("CHECKCANAUTHORIZE")){
			String request_by_store = bean.checkForNull( request.getParameter("requisition_by_store"),"");
			if (request_by_store != null && request_by_store.trim().equals("")) {
				out.println("errorDisplay();");
				return;
			}
			java.util.HashMap resultMap = bean.canAuthorize(request_by_store);
			if (resultMap != null) {
				String authorize = bean.checkForNull((String)resultMap.get("REQ_AUTHORIZE_ALLOWED_YN"),"N");
				if (authorize.equals("Y")) {
					authorize = "Yes";
				}
				else {
					authorize = "No";
				}
				out.println("setAuthorize('"+authorize+"');");

				String parent_store = (String)resultMap.get("PARENT_STORE_CODE");
				parent_store = bean.checkForNull(parent_store,"");
				
				bean.setRequisition_by_store(request_by_store);
				out.println("clearListItems('formPOGenerateRequest.to_department'); ");
					ArrayList req_by_stores = bean.getOnStores(bean.getRequisition_by_store());
					HashMap record = new HashMap();
					for(int i=0; i< req_by_stores.size(); i++) {
						record = (HashMap)req_by_stores.get(i);
						out.println("addListItem(\"formPOGenerateRequest.to_department\", \"" + record.get("PARENT_STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
						if(record.get("PARENT_STORE_CODE").equals(parent_store)){
							
							out.println("setParentStoreCode('"+parent_store+"');");}
					}
				
					if (request_by_store != null && request_by_store.trim() != "") {
					out.println("clearListItems('formPOGenerateRequest.item_class_code'); ");
					ArrayList itemClasses = bean.getItemClasses(request_by_store,request_by_store);
					for(int i=0; i< itemClasses.size(); i++) {
						record = (HashMap)itemClasses.get(i);
						out.println("addListItem(\"formPOGenerateRequest.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
					}
				}
			}
		}else if(functionType.equals("FINDRECORDS")){
			bean.addMultipleRecord(hash);
		
		}else if(functionType.equals("ISVALIDDOCDATE")){
			int iValidDocDate = bean.isValidDocDate(bean.checkForNull((String)request.getParameter("documentdate")));
			if(iValidDocDate==2){
				out.println("curr_date_grt_sysdaete();");
			}
		}else if(functionType.equals("RESET")){
			bean.initialize();		
		}
putObjectInBean(bean_id,bean,request);
%>
