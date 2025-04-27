
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%  request.setCharacterEncoding("UTF-8");
	String locale						=		(String)session.getAttribute("LOCALE");
	//int functionType					=		Integer.parseInt(request.getParameter("function_type"));

	String bean_id						=		"SuspendOrReinstateBatchBean";
	String bean_name					=		"eST.SuspendOrReinstateBatchBean";
	SuspendOrReinstateBatchBean bean	=		(SuspendOrReinstateBatchBean) getBeanObject( bean_id,  bean_name,request  );  

	bean.setLanguageId(locale);
	bean.clear();
	Hashtable hash						=		(Hashtable) XMLobj.parseXMLString(request);
    hash								=		(Hashtable) hash.get ("SEARCH");
	
	out.println("clearListItems('document.ProductComplaintCriteriaForm.manufacturer'); ");
			try
			{
				ArrayList manufacturer_list		=		bean.getManufacturerList_item(bean.checkForNull(request.getParameter("item_code")));
				if (manufacturer_list!=null && manufacturer_list.size()>0)
				{
					HashMap record			= null;
					for(int i=0; i< manufacturer_list.size(); i++) 
					{
						record			=		(HashMap)manufacturer_list.get(i);
						String listRecord1		=		bean.checkForNull((String)record.get("MANUFACTURER_ID"));
						String listRecord2		=		bean.checkForNull((String)record.get("SHORT_NAME"));
						out.println("addListItem(\"document.ProductComplaintCriteriaForm.manufacturer\", \"" +listRecord1+ "\",\"" +listRecord2+ "\") ; ");
					}
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}

%>
<% putObjectInBean(bean_id,bean,request);
%>
