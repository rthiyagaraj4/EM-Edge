<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eOR.Common.*, eOR.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%

	Hashtable hash		= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	String index_value	= (String)hash.get("INDEX_VALUES");
	String fm_val		= (String)hash.get("FROM_VALUE");
	String to_val		= (String)hash.get("TO_VALUE");
	String bean_id		= (String)hash.get("BEAN_ID");
	String bean_name	= (String)hash.get("BEAN_NAME");
	String tab_value	= (String)hash.get("TAB_VALUE");

	String update_value	="";
	PractForConsentBean bean = (PractForConsentBean)getBeanObject( bean_id,bean_name, request ) ;
	eOR.Common.MultiRecordBean multiRecSet = (eOR.Common.MultiRecordBean)bean.getBean();

	int fm_value = Integer.parseInt(fm_val);
	int to_value = Integer.parseInt(to_val);

	StringTokenizer stoken = new StringTokenizer(index_value,"~");

	for(int j=fm_value; j<=to_value; j++){
		update_value  =	stoken.nextToken();
		if(tab_value.equals("S"))
			multiRecSet.setBeanValue(j,update_value);  
		else if(tab_value.equals("A"))
			multiRecSet.setDBBeanValue(j,update_value); 
	}
	putObjectInBean(bean_id,bean,request);
%>
