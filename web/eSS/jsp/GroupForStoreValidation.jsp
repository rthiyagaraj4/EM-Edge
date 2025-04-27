<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eSS.Common.*, eSS.* "%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	HashMap dataMap		= null;
	String bean_id		= "groupforstore" ;
	String bean_name	= "eSS.GroupForStoreBean";
	Hashtable hash		= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	out.println(hash);

	GroupForStoreBean bean = (GroupForStoreBean)getBeanObject( bean_id, bean_name,request ) ;
	
    int displaySize = Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
	

	for( int i=0;i<displaySize;i++ ){
		dataMap=new HashMap();
		if( hash.containsKey( "GROUP_CODE"+i ) ){
			dataMap.put( "GROUP_NAME",bean.getGenericName((String)hash.get("GROUP_CODE"+i)));
			dataMap.put( "GROUP_CODE",(String)hash.get("GROUP_CODE"+i) );
			dataMap.put( "EFF_STATUS",(String)hash.get("EFF_STATUS"+i) );
				if(   ((String)hash.get("PROCESS"+i)).equals("Y") ){
					dataMap.put( "OPER_MODE","I" );
					dataMap.put( "SOURCE","FB" );
				}
				else{
					dataMap.put( "OPER_MODE","DN" );
					dataMap.put( "SOURCE","FB" );
					
				}
	
	
	//set the latest values into FB
	
	bean.setGenericCodeResultPage((String)hash.get("GROUP_CODE"+i), (String)hash.get("EFF_STATUS"+i), (String)hash.get("PROCESS"+i)) ;

	
	//Set the latest values into DB - includes insert/replace mode checking	
			if( bean.chkDatainDB( ((String)hash.get("GROUP_CODE"+i)), ((String)hash.get("EFF_STATUS"+i)) ) ){
					
					dataMap.put("SOURCE", (String)bean.getDataSource( (String)hash.get("GROUP_CODE"+i) ) );
					boolean chk=bean.chkUpdateYN(((String)hash.get("GROUP_CODE"+i)), ((String)hash.get("EFF_STATUS"+i)) );
					
						if(chk) dataMap.put( "OPER_MODE","U" );
				bean.replaceDataList(dataMap,((String)hash.get("GROUP_CODE"+i)));	
			}
			else {
			bean.setDataList(dataMap);	
			}
		}//IF
	}//FOR

//Delete the duplicate records.

	bean.emptyDupRecords();
	putObjectInBean( bean_id,bean,request);

%>

