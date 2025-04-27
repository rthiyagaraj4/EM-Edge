<!DOCTYPE html>
<%@page import="java.util.*, eMM.Common.*, eMM.* ,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
//	HashMap dataMap		= null;
	String bean_id = "TradeNameForItemBean" ;
	String bean_name = "eMM.TradeNameForItemBean";
	TradeNameForItemBean bean = (TradeNameForItemBean)getBeanObject( bean_id,bean_name,request ) ;  
		bean.setLanguageId(locale);
	Hashtable hash		= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" );
	String trade_id=request.getParameter("trade_id");
	HashMap manufacturer_details = bean.getManufacturerDetails(trade_id);
	String manufacturer_id = (String) (manufacturer_details.get ( "MANUFACTURER_ID" ));
	String manufacturer_name = (String) (manufacturer_details.get ( "MANUFACTURER_NAME" ));
	out.println("setManufacturerDetails(\""+manufacturer_id+"\",\""+manufacturer_name+"\");");	
%><% 
putObjectInBean(bean_id,bean,request);
%>
