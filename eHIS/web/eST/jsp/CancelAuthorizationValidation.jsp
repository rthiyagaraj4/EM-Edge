
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
	boolean result			=		false;
    String message			=		"";
	String flag				=		"";
	
	
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	CancelAuthorizationBean bean		=	(CancelAuthorizationBean) getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	Hashtable hash				=	(Hashtable) XMLobj.parseXMLString(request);
    hash						=	(Hashtable) hash.get ("SEARCH");	

	switch (functionType) {
	case 1:
		{
			request_on_store				=		(String) hash.get("request_on_store");
			
				bean.setRequest_on_store(request_on_store);
								
					out.println("clearListItems('formCancelAuthQueryCriteria.request_by_store'); ");
					ArrayList req_by_stores = bean.getbyStores(request_on_store);
					HashMap record = new HashMap();
					for(int i=0; i< req_by_stores.size(); i++) {
						record = (java.util.HashMap)req_by_stores.get(i);
						out.println("addListItem(\"formCancelAuthQueryCriteria.request_by_store\", \"" + record.get("STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
						
					}
				
			}
		
		break;
		case 2:
		{
			 request_by_store = (String) hash.get("request_by_store");
			request_on_store = (String) hash.get("request_on_store");

			out.println("clearListItems('formCancelAuthQueryCriteria.item_class_code'); ");

			ArrayList itemClasses = bean.getItemClasses(request_by_store,request_on_store);
			
			HashMap record =  new HashMap();
			for(int i=0; i< itemClasses.size(); i++) {
				record = (java.util.HashMap)itemClasses.get(i);
				out.println("addListItem(\"formCancelAuthQueryCriteria.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}
		break;
		case 3:
		{
			String  request_type = (String) hash.get("request_type")==null?"A":(String) hash.get("request_type");


			out.println("clearListItems('formCancelAuthQueryCriteria.request_on_store'); ");

			ArrayList request_on_store_list = bean.getRequestOnStore(request_type);
			HashMap record =  new HashMap();
			for(int i=0; i< request_on_store_list.size(); i++) {
				record = (java.util.HashMap)request_on_store_list.get(i);
				out.println("addListItem(\"formCancelAuthQueryCriteria.request_on_store\", \"" + record.get("STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}
		break;
		case 4:
		{  
		    String reason_code=(String)hash.get("reason_code");
			String row_num    =(String)hash.get("row_num");
			String col_num    =(String)hash.get("col_num");
			String called_from    =(String)hash.get("called_from");
			String doc_type    =(String)hash.get("doc_type");
			String doc_no    =(String)hash.get("doc_no");
			String facility_id    =(String)hash.get("facility_id");
			String item_code    =(String)hash.get("item_code");
			
			
			
			String remarks_desc =bean.getRemarksDesc(reason_code);
			
        
			out.println("assignRemarksDesc('"+remarks_desc+"','"+row_num+"','"+col_num+"','"+called_from+"')");
			
		}
		break;
		case 5:
		{
			bean.updateSelectedValues(hash);
		}
		break;
	default :
		
		out.println("alert(\'Invalid Function\');");
		return;
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
