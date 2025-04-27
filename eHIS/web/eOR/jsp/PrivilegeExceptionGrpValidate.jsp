<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eOR.Common.*, eOR.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	//System.err.println("Entered into Validate.jsp.....@#$$%^%&&");
	//HashMap dataMap=null;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	//System.err.println("Before getting the values from Validate.jsp.....@#$$%^%&&");
	String index_value	= (String)hash.get("INDEX_VALUES");
	String fm_val		= (String)hash.get("FROM_VALUE");
	String to_val		= (String)hash.get("TO_VALUE");
	String bean_id		= (String)hash.get("BEAN_ID");
	String bean_name	= (String)hash.get("BEAN_NAME");
	String tab_value	= (String)hash.get("TAB_VALUE");
	//String class_name   = (String)hash.get("CLASS_NAME");
	
	//HashMap select_All = null;

	String update_value	="";
	//boolean alteredRecord = false;
	//int count_code		= 0;
 
	PrivilegeExceptionGrpBean bean	= (PrivilegeExceptionGrpBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
	eOR.Common.MultiRecordBean multiRecSet	= (eOR.Common.MultiRecordBean)bean.getBean();

	int fm_value = Integer.parseInt(fm_val);
	int to_value = Integer.parseInt(to_val);

	StringTokenizer stoken = new StringTokenizer(index_value,"~");
	//count_code		=	stoken.countTokens();

	for(int j=fm_value; j<=to_value; j++)
	{
		update_value		=	stoken.nextToken();
		
		if(tab_value.equals("S")){
			//alteredRecord		=
			multiRecSet.setBeanValue(j,update_value);
		}else if(tab_value.equals("A")){
			//alteredRecord		=	
			multiRecSet.setDBBeanValue(j,update_value);
		}
	}
	
	/*for(int i=0;i<multiRecSet.getSize("DB");i++)
	{
		System.err.println(" Record @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   " + multiRecSet.getObject(i));
	}
	
	out.println(tab_value);
	out.println(alteredRecord);
	out.println(index_value);
	out.println(fm_value);
	out.println(to_value);
	out.println(count_code);
	*/
	putObjectInBean(bean_id,bean,request);
%>
</html>
