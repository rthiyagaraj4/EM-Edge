<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eSS.Common.*, eSS.* "%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
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

	GroupForStoreBean bean = (GroupForStoreBean)getBeanObject( bean_id, bean_name , request) ;
    int displaySize = Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));
    
	ArrayList DataList=bean.getDataList();out.println("DataListSize"+DataList.size());
	for(int i=0;i<displaySize;i++){
		dataMap=new HashMap();
		if( hash.containsKey("STORE_CODE"+i) ){out.println("inside");
			dataMap.put( "STORE_CODE",(String)hash.get("STORE_CODE"+i) );
			dataMap.put( "SHORT_DESC",bean.getStoreName((String)hash.get("STORE_CODE"+i)));
			dataMap.put( "EFF_STATUS",(String)hash.get("EFF_STATUS"+i) );
				if(   ((String)hash.get("PROCESS"+i)).equals("Y") ){
					dataMap.put( "OPER_MODE","I" );
					dataMap.put( "SOURCE","FB" );
				}
				else{
					dataMap.put( "SOURCE","FB" );
					dataMap.put( "OPER_MODE","DN" );
					
				}
			dataMap.put( "MIN_QTY",(String)hash.get("MIN_QTY"+i) );
			dataMap.put( "REORDER_QTY",(String)hash.get("REORDER_QTY"+i) );
		
	//set the latest values into FB
	
	bean.setGenericCodeResultPagebyGeneric((String)hash.get( "STORE_CODE"+i ), (String)hash.get( "EFF_STATUS"+i ), (String)hash.get( "PROCESS"+i )) ;

	
	//set the latest values into DB - includes insert/replace mode checking	
		
			if( bean.chkDatainDBbyGroup( ((String)hash.get( "STORE_CODE"+i )), ((String)hash.get( "EFF_STATUS"+i )) ) ){
			
					dataMap.put( "SOURCE", (String)bean.getDataSourcebyGeneric( (String)hash.get( "STORE_CODE"+i ) ) );
					boolean chk=bean.chkUpdateYNByGeneric(((String)hash.get("STORE_CODE"+i)), ((String)hash.get("EFF_STATUS"+i)) );
					out.println("CHK"+chk);
						if(chk) dataMap.put( "OPER_MODE","U" );
					bean.replaceDataListbyGroup(dataMap,((String)hash.get( "STORE_CODE"+i )));	
			}else {
				bean.setDataList(dataMap);	
			}
			
		}//IF
}//FOR
//Delete the duplicate records from DB added from FB 
bean.emptyDupRecords();
putObjectInBean( bean_id,bean,request);

%>

