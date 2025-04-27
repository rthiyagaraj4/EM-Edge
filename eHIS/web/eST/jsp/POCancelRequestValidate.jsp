
  <%@page import="java.util.*, eST.Common.*, eST.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id				=	request.getParameter("bean_id");
	String bean_name			=	request.getParameter("bean_name");
	String request_by_store		=	request.getParameter("request_by_store");
	String request_on_store		=	request.getParameter("request_on_store");
	int functionType			=	Integer.parseInt(request.getParameter("function_type"));

	request.setCharacterEncoding("UTF-8");
	String locale				=	(String)session.getAttribute("LOCALE");
	
	
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	POCancelRequestBean bean		=	(POCancelRequestBean) getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	Hashtable hash				=	(Hashtable) XMLobj.parseXMLString(request);
    hash						=	(Hashtable) hash.get ("SEARCH");	

	switch (functionType) {
	case 1:
		{
			bean.updateRemarks(hash);
		}
		break;
	case 2:
		{
			bean.updateSelectedValues(hash);
		}
		break;
	case 3:
		{
			request_by_store				=		(String) hash.get("request_by_store");
			
				bean.setRequest_by_store(request_by_store);
				
				//To populate the requisition_on_stores
					out.println("clearListItems('formPOCancelRequestQueryCriteria.request_on_store'); ");
					ArrayList req_by_stores = bean.getOnStores(request_by_store);
					HashMap record = new HashMap();
					for(int i=0; i< req_by_stores.size(); i++) {
						record = (java.util.HashMap)req_by_stores.get(i);
						out.println("addListItem(\"formPOCancelRequestQueryCriteria.request_on_store\", \"" + record.get("PARENT_STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
						
					}


				
			}
		
		break;
		case 4:
		{
			 request_by_store = (String) hash.get("request_by_store");
			request_on_store = (String) hash.get("request_on_store");

			out.println("clearListItems('formPOCancelRequestQueryCriteria.item_class_code'); ");

			ArrayList itemClasses = bean.getItemClasses(request_by_store,request_on_store);
			HashMap record =  new HashMap();
			for(int i=0; i< itemClasses.size(); i++) {
				record = (java.util.HashMap)itemClasses.get(i);
				out.println("addListItem(\"formPOCancelRequestQueryCriteria.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
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
