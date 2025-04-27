
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
	RejectRequestBean bean		=	(RejectRequestBean) getBeanObject(bean_id,bean_name,request);
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
		{ //MO-CRF-20174
			//request_on_store				=		(String) hash.get("request_on_store");
				bean.setRequest_on_store(request_on_store);
				
				//To populate the requisition_on_stores
					out.println("clearListItems('formRejectRequestQueryCriteria.request_by_store'); ");
					ArrayList req_by_stores = bean.getbyStores(request_on_store);
					HashMap record = new HashMap();
					for(int i=0; i< req_by_stores.size(); i++) {
						record = (java.util.HashMap)req_by_stores.get(i);
						out.println("addListItem(\"formRejectRequestQueryCriteria.request_by_store\", \"" + record.get("STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
						
					}


				
			}
		
		break;
		case 4:
		{
		request_by_store = (String) hash.get("request_by_store");
			request_on_store = (String) hash.get("request_on_store");

			out.println("clearListItems('formRejectRequestQueryCriteria.item_class_code'); ");

			ArrayList itemClasses = bean.getItemClasses(request_by_store,request_on_store);
			System.err.println("request_on_store@@@==="+request_on_store+"request_by_store=="+request_by_store);
			HashMap record =  new HashMap();
			for(int i=0; i< itemClasses.size(); i++) {
				record = (java.util.HashMap)itemClasses.get(i);
				out.println("addListItem(\"formRejectRequestQueryCriteria.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}
		break;
		case 5:
		{
			String  request_type = (String) hash.get("request_type")==null?"A":(String) hash.get("request_type");


			out.println("clearListItems('formRejectRequestQueryCriteria.request_on_store'); ");

			ArrayList request_on_store_list = bean.getRequestOnStore(request_type);
			HashMap record =  new HashMap();
			for(int i=0; i< request_on_store_list.size(); i++) {
				record = (java.util.HashMap)request_on_store_list.get(i);
				out.println("addListItem(\"formRejectRequestQueryCriteria.request_on_store\", \"" + record.get("STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}
		break;
		//Added by Rabbani # Bru-HIMS-CRF-118[INC NO:30077] on 16-JULY-2013 Starts
		case 6:
		{
			bean.updateItemRemarks(hash);
		}
		break;
		case 7:
		{
		    String key = request.getParameter("key");
			bean.setRemarks(key);
		}
		break;
		case 8:
		{  
		    String key = request.getParameter("key");
			bean.setDtlRemarks(key);
		}
		break;
		 case 9: 
		{	
			try{
			
				ArrayList doc_no     =  bean.getPrintDocNo();
				 
				
				

				 
				// String pdocno = "";
				HashMap  hmdata = new HashMap();
				for(int i=0;i<doc_no.size();i++){
				
				request_by_store    =  bean.checkForNull((String)request.getParameter("request_by_store"));
				 request_on_store   =  bean.checkForNull((String)request.getParameter("request_on_store"));
				String from_doc_date =  bean.checkForNull((String)request.getParameter("from_doc_date"));
				String to_doc_date   =  bean.checkForNull((String)request.getParameter("to_doc_date"));
				
				 bean.setRequest_on_store(request_on_store);
			     bean.setRequest_by_store(request_by_store);
			     bean.setFrom_date(from_doc_date);
			     bean.setTo_date(to_doc_date);
				
					hmdata =(HashMap)doc_no.get(i);
					 String pdoc_no = (String)hmdata.get("doc_no");
					String pdoc_type_code = (String)hmdata.get("doc_type_code");
					bean.doOnlineReportPrinting(pdoc_no,pdoc_type_code,request,response); 
				}
				result =  true ;
			    message = request.getParameter("msg");

			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
			}
			finally{
					out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
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
