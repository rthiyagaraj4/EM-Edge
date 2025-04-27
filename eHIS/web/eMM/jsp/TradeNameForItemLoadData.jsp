<!DOCTYPE html>
<%@page import="java.util.*, eMM.Common.*, eMM.* ,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=ISO-8859-1"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<jsp:useBean id="alTradeNameForItemList" scope="session" class="java.util.ArrayList" />
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%	
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
//	HashMap dataMap		= null;
	String bean_id = "TradeNameForItemBean" ;
	String bean_name = "eMM.TradeNameForItemBean";
	TradeNameForItemBean bean = (TradeNameForItemBean)getBeanObject( bean_id, bean_name,request ) ;  
		bean.setLanguageId(locale);
	Hashtable hash		= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" );
	String item_code=request.getParameter("item_code");
	bean.clear();
	bean.loadData(item_code);
	ArrayList dataList = (ArrayList) bean.getDataList();
	//out.println("alert(\"alTradeNameForItemList" + alTradeNameForItemList.size() + "\");") ;
	alTradeNameForItemList.clear();
	for(int i=0; i<dataList.size();i++) {
		alTradeNameForItemList.add(dataList.get(i));
	}
putObjectInBean(bean_id,bean,request);
%> 
