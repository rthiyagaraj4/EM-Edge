
 <%
/*
-----------------------------------------------------------------------------------------------------
Date       Edit History		Name 			Rev.Date		Rev.Name		Description
-----------------------------------------------------------------------------------------------------
15/06/2021	17139			Ramesh G        15/6/2021		Ramesh G         ML-MMOH-SCF-1789 
-----------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<% request.setCharacterEncoding("UTF-8"); 
try 
	{
		String bean_id 			= request.getParameter( "bean_id" ) ;
		String bean_name 		= request.getParameter( "bean_name" ) ;
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
			
		OrderEntryBean bean = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
		String key						= (bean.getPatientId()+bean.getEncounterId());  // Unique key to keep the Value in the Bean
		HashMap previousValues			= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
		String order_category_list = "";
		HashMap order_categoryvalues = bean.getOrderCategories(previousValues);
		List<String> or_catrgorylist = new ArrayList<String>(order_categoryvalues.values());
		if(or_catrgorylist.contains("PH"))
			out.println("PH");
		else
			out.println("");
	}
	catch (Exception e) 
	{
		//out.println("alert(\"" + e + "\");") ;//COMMON-ICN-0181
		e.printStackTrace();
	}
%>
