<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eSS.Common.*, eSS.* "%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	HashMap dataMap		= null;
	String bean_id = "sterilizationCostBean" ;
	String bean_name = "eSS.SterilizationCostBean";
	Hashtable hash		= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	SterilizationCostBean bean = (SterilizationCostBean)getBeanObject( bean_id, bean_name, request ) ;
	
    int displaySize = Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));

	for( int i=0;i<displaySize;i++ ){
		dataMap=new HashMap();
		if( hash.containsKey( "STERILE_TYPE"+i ) ){
			dataMap.put( "SHORT_DESC",hash.get("SHORT_DESC"+i));
			dataMap.put( "STERILE_TYPE",(String)hash.get("STERILE_TYPE"+i) );
			dataMap.put( "STERILE_COST",(String)hash.get("STERILE_COST"+i) );
			dataMap.put( "DBVAL",(String)hash.get("DBVAL"+i) );
				if(   ((String)hash.get("PROCESS"+i)).equals("Y") && ((String)hash.get("DBVAL"+i)).equals("N")  && ((String)hash.get("DELETE_ROW"+i)).equals("N") ){
					dataMap.put( "OPER_MODE","I" );
					dataMap.put( "SOURCE","FB" );
					dataMap.put( "PROCESS",(String)hash.get("PROCESS"+i) );
				}
				else if(   ((String)hash.get("PROCESS"+i)).equals("Y") && ((String)hash.get("DBVAL"+i)).equals("Y")  && ((String)hash.get("DELETE_ROW"+i)).equals("Y") ){
					dataMap.put( "OPER_MODE","D" );
					dataMap.put( "SOURCE","FB" );
					dataMap.put( "PROCESS",(String)hash.get("PROCESS"+i) );
				}
				else{
					dataMap.put( "OPER_MODE","DN" );
					dataMap.put( "SOURCE","FB" );
					dataMap.put( "PROCESS",(String)hash.get("PROCESS"+i) );
				}
		
	//set the latest values into FB
	
	bean.setSterileTypeResultPage((String)hash.get("STERILE_TYPE"+i), (String)hash.get("STERILE_COST"+i), (String)hash.get("PROCESS"+i)) ;
	
			if( bean.chkDatainDB( (String)hash.get("STERILE_TYPE"+i), (String)hash.get("STERILE_COST"+i)) ){
					
					dataMap.put("SOURCE", (String)bean.getDataSource( (String)hash.get("STERILE_TYPE"+i) ) );
					boolean chk=bean.chkUpdateYN(((String)hash.get("STERILE_TYPE"+i)), ((String)hash.get("PROCESS"+i)), ((String)hash.get("DELETE_ROW"+i)),((String)hash.get("DBVAL"+i)) );
					if(chk) 
						dataMap.put( "OPER_MODE","U" );
	
	
				bean.replaceDataList(dataMap,((String)hash.get("STERILE_TYPE"+i)));	
			}
			else {
			bean.setDataList(dataMap);	
			}
		}//IF
	}//FOR

//Delete the duplicate records.
out.println("After Sterilization Cost  :"+bean.getDataList());
	bean.emptyDupRecords();
%>
<% putObjectInBean(bean_id,bean,request);%>
