<%@page import=" eST.PORequestStatusBean,java.util.ArrayList,java.util.HashMap" contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	
	request.setCharacterEncoding("UTF-8");
	String locale				= (String)session.getAttribute("LOCALE");
	String bean_id				=	request.getParameter("bean_id");
	String bean_name			=	request.getParameter("bean_name");
	
	String Validate			=	request.getParameter("Validate");

		
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	PORequestStatusBean bean		=	(PORequestStatusBean) getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	Hashtable hash				=	(Hashtable) XMLobj.parseXMLString(request);
    hash						=	(Hashtable) hash.get ("SEARCH");	


if(Validate.equals("GETDEPARTMENT")){
			String request_by_store = request.getParameter("request_by_store");
			 bean.setRequest_by_store(request_by_store);
				out.println("clearListItems('formPORequestStatusQueryCriteria.request_on_department'); ");
					ArrayList req_by_stores = bean.getOnDepartmentRequestStatus(bean.getRequest_by_store());
					HashMap record = null;
					for(int i=0; i< req_by_stores.size(); i++) {
						record = (HashMap)req_by_stores.get(i);
						out.println("addListItem(\"formPORequestStatusQueryCriteria.request_on_department\", \"" + record.get("PO_DEPT_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
					}


}else if(Validate.equals("GETITEMCLASSES")){
			String request_by_store = (String) hash.get("request_by_store");
			String request_on_department = (String) hash.get("request_on_department");

			out.println("clearListItems('formPORequestStatusQueryCriteria.item_class_code'); ");

			ArrayList itemClasses = bean.getItemClasses(request_by_store,request_on_department);
			HashMap record = null;
			for(int i=0; i< itemClasses.size(); i++) {
				record = (HashMap)itemClasses.get(i);
				out.println("addListItem(\"formPORequestStatusQueryCriteria.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}


	%>
<%
putObjectInBean(bean_id,bean,request);
%>
