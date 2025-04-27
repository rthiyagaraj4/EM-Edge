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
	String bean_id		= "groupforstore" ;
	String bean_name	= "eSS.GroupForStoreBean";
	Hashtable hash		= (Hashtable)XMLobj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;

	//initialize bean
	GroupForStoreBean bean = (GroupForStoreBean)getBeanObject( bean_id, bean_name,request) ;

	ArrayList DataList = bean.getDataList();

	//MODIFICATION OF DB
	
	int displaySize = Integer.parseInt( (String) CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE"));

	for( int i=0;i<DataList.size();i++ ){
		dataMap	= new HashMap();
		dataMap	= (HashMap)DataList.get(i);
		String dbcode    = (String)dataMap.get( "STORE_CODE" ) ;
		String dbeffstat = (String)dataMap.get( "EFF_STATUS" ) ;
		String qty		 = (String)dataMap.get( "MIN_QTY" );
		String reord_qty		 = (String)dataMap.get( "REORDER_QTY" );
			if(hash.containsValue(dbcode)){
				for( int j=0;j<displaySize;j++ ){					
					String value =(String)hash.get( "STORE_CODE"+j ) ;
					if(value!=null){
						if(value.equals(dbcode)){
							 String dboper_mode	= (String)hash.get( "OPER_MODE"+j ) ;
							 String dbeff_status= (String)hash.get( "EFF_STATUS"+j ) ;
							 String Min_qty= (String)hash.get( "MIN_QTY"+j ) ;
							 String reorder_qty= (String)hash.get( "REORDER_QTY"+j ) ;
							  String min_qty_chk= (String)hash.get( "MIN_QTY_CHK"+j ) ;
						
						if( !(dbeffstat.equals( dbeff_status )) || !(Min_qty.equals(qty)) || !(reorder_qty.equals(reord_qty))) { 
						
							dataMap.put( "OPER_MODE","U" );
						} else {
							dataMap.put( "OPER_MODE",dboper_mode );
						}
							
							dataMap.put( "EFF_STATUS",dbeff_status );
							
							
						/*	if(!(Min_qty.equals(qty)) && !(dboper_mode.equals("I")) ) {
								dataMap.put( "MIN_QTY_CHK","M" );
								dataMap.put( "OPER_MODE","U" );
							}else{
								dataMap.put( "MIN_QTY_CHK",min_qty_chk );
								dataMap.put( "OPER_MODE",dboper_mode );
							}
						*/	
							
							dataMap.put( "MIN_QTY",Min_qty );
							dataMap.put( "REORDER_QTY",reorder_qty );
						}
				}
			}
	
		}
	}

putObjectInBean( bean_id,bean,request);
%>
