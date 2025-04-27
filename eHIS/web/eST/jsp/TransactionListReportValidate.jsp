
<%@ page import=" eST.TransactionListReportBean" contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%	
	String locale			= (String)session.getAttribute("LOCALE");
	TransactionListReportBean bean = (TransactionListReportBean) getBeanObject ("transactionListReportBean", "eST.TransactionListReportBean",request);  
	bean.setLanguageId(locale);
	String validate			=	request.getParameter("validate");
	Hashtable htFormValues  = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues			= (Hashtable) htFormValues.get ("SEARCH");
	try {
		   if(validate.equals("LOAD_STORE")){
		   
			String p_facility_id = bean.checkForNull(request.getParameter("p_facility_id"),"%");
			out.println("clearListStores('document.formTransactionListReportCriteria.p_store_code'); ");
			ArrayList alStoreList = bean.getStoreArrayList(p_facility_id);
			HashMap record	=	null;
			for(int i=0; i< alStoreList.size(); i++) {
				record	=	(HashMap)alStoreList.get(i);
				String listRecord	=	(String)record.get("STORE_CODE");
				String listRecord1	=	(String)record.get("SHORT_DESC");
				out.println("addListItem(\"document.formTransactionListReportCriteria.p_store_code\", \"" +listRecord+ "\",\"" +listRecord1+ "\"); ");
			}
		 } 
		 
	    }catch (Exception exception) {
		exception.printStackTrace();
	   }
	    finally{
		//out.println("assignResult(" + result + ",\"" + message + "\", \"" + flag + "\");") ;
	   }
%>
<%
	putObjectInBean("transactionListReportBean",bean,request);
%>
