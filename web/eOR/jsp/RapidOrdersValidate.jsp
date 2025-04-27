<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.sql.*, java.util.*, java.io.*, eOR.Common.*, eOR.*"  contentType="text/html;charset=ISO-8859-1"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%

	String bean_id 			= request.getParameter( "bean_id" ) ;
	String bean_name 		= request.getParameter( "bean_name" ) ;
	String func_mode 		= request.getParameter( "func_mode" ) ;
	if ( bean_id == null || bean_id.equals( "" ) || bean_name == null || bean_name.equals(""))
		return ;

	if ( func_mode == null || func_mode.equals( "" ) )
		return ;

	/* Initialize Function specific start */
	//OrderEntryBean beanObj = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	OrderEntryBean beanObj = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;

	/* Initialize Function specific end */
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
   	hash = (Hashtable)hash.get( "SEARCH" ) ;


	if(func_mode.equals("rapid_orders"))
	{
		String cmts			= (String)hash.get("clinical_comments");
		if(cmts!=null && cmts.indexOf("\"")!=-1)
		 cmts					= cmts.replace('"','\n');

		HashMap hashmap = beanObj.rapidOrders(cmts);
		//String order_catalog_code		= "";
		//String order_category			= "";
		//String order_type_code			= "";	
		//String performing_facility_id	= "";
		String grouping					= "";
		int total_records				= 0;

		TreeMap treeMap					= new TreeMap();

		if(hashmap!=null && hashmap.size() > 0)	
			total_records					= Integer.parseInt(beanObj.checkForNull(((String)hashmap.get("total_records")),"0"));
		for(int i=0;i<total_records;i++)
		{
			//order_catalog_code		= ((String)hashmap.get("order_catalog_code"+i)) ;	
			//order_category			= ((String)hashmap.get("order_category"+i)) ;
			//order_type_code			= ((String)hashmap.get("order_type_code"+i)) ;
			//performing_facility_id	= ((String)hashmap.get("performing_facility_id"+i)) ;
			grouping				= beanObj.checkForNull((String)hashmap.get("order_category"+i),"^^")+"~~"+beanObj.checkForNull((String)hashmap.get("order_type_code"+i),"^^")+"~~"+beanObj.checkForNull((String)hashmap.get("performing_facility_id"+i),"^^");
			treeMap.put(grouping , grouping);
		}
		HashMap hashResult = beanObj.insertRapidOrders(hashmap, treeMap);
		boolean result = ((Boolean) hashResult.get( "result" )).booleanValue() ;
		String message =""; 
		if(((String)hashResult.get("message")).indexOf("RECORD_INSERTED") != -1 )
			message	 = beanObj.replaceNewLineChar(beanObj.checkForNull(beanObj.getMessage((String)hashResult.get("message")) ));
		else
			message = beanObj.replaceNewLineChar(beanObj.checkForNull((String)hashResult.get("message")));

		//String traceVal =	 beanObj.replaceNewLineChar(beanObj.checkForNull((String) hashResult.get( "traceVal" )));
		out.println("dispMessage(\""+message+"\")");
		if(result)
		{
			out.println("onSuccessRapidOrder()"); // Call this method to refresh the frames.
		}
		//eOR.RapidOrdersBean 	rapidOrdersBean	= new eOR.RapidOrdersBean();
		//RapidOrdersBean rapidOrdersBean 		= (RapidOrdersBean)mh.getBeanObject( "rapidorders", request,  "eOR.RapidOrdersBean" ) ;
		//rapidOrdersBean.insert();

	}

	putObjectInBean(bean_id,beanObj,request);
%>
