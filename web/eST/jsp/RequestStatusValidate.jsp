
<%@page import=" eST.*,eST.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*,java.lang.*" contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	
	request.setCharacterEncoding("UTF-8");
	String locale				= (String)session.getAttribute("LOCALE");
	String bean_id				=	request.getParameter("bean_id");
	String bean_name			=	request.getParameter("bean_name");	
	int functionType			=	Integer.parseInt(request.getParameter("function_type"));
		
	if ((bean_id == null) || (bean_id.equals("")))
		return;
		
	RequestStatusBean bean		=	(RequestStatusBean) getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);

	String bean_id1 = "authorizeAtIssueStoreBean";
	String bean_name1 = "eST.AuthorizeAtIssueStoreBean";
	AuthorizeAtIssueStoreBean bean1 = (AuthorizeAtIssueStoreBean) getBeanObject(bean_id1,bean_name1,request);  
	bean1.setLanguageId(locale);

	Hashtable hash				=	(Hashtable) XMLobj.parseXMLString(request);
    hash						=	(Hashtable) hash.get ("SEARCH");	

	switch (functionType) {
	case 1:
		{
			String request_by_store = request.getParameter("request_by_store");			
			bean.setRequest_by_store(request_by_store);
			out.println("clearListItems('formRequestStatusQueryCriteria.request_on_store'); ");
			ArrayList req_by_stores = bean.getOnStoresRequestStatus(bean.getRequest_by_store());
			HashMap record = null;
			for(int i=0; i< req_by_stores.size(); i++) {
				record = (HashMap)req_by_stores.get(i);
				out.println("addListItem(\"formRequestStatusQueryCriteria.request_on_store\", \"" + record.get("PARENT_STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}
		break;
	case 2:
		{
			String request_by_store = (String) hash.get("request_by_store");
			String request_on_store = (String) hash.get("request_on_store");
			if(request_by_store.equals(null) || request_by_store.equalsIgnoreCase("null")){
				request_by_store="";
			}
			if(request_on_store.equals(null) || request_on_store.equalsIgnoreCase("null")){
				request_on_store="";
			}			

			out.println("clearListItems('formRequestStatusQueryCriteria.item_class_code'); ");
			ArrayList itemClasses = new ArrayList();

			if((!request_by_store.equals("")) && (!request_on_store.equals(""))){
				itemClasses = (ArrayList)bean1.getItemClasses(request_by_store,request_on_store);
			}
			else if((!request_by_store.equals("")) && (request_on_store.equals(""))){
				itemClasses = (ArrayList)bean1.getItemClasses(request_by_store);
			}else{
				itemClasses = (ArrayList)bean1.getDefaultItemClasses1();
			}

			HashMap record = null;
			for(int i=0; i< itemClasses.size(); i++) {
				record = (HashMap)itemClasses.get(i);
				out.println("addListItem(\"formRequestStatusQueryCriteria.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}
		break;
	case 3:
		{
			String request_type = (String) hash.get("request_type");
			out.println("clearListItems('formRequestStatusQueryCriteria.request_by_store'); ");
			out.println("clearListItems('formRequestStatusQueryCriteria.item_class_code'); ");
			out.println("clearListItems('formRequestStatusQueryCriteria.request_on_store'); ");
			ArrayList reqByStore = bean.getRequestByStore(request_type);
			HashMap record = null;
			for(int i=0; i< reqByStore.size(); i++) {
				record = (HashMap)reqByStore.get(i);
				out.println("addListItem(\"formRequestStatusQueryCriteria.request_by_store\", \"" + record.get("STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
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
