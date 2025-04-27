
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<% 
/*
------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------
?           100            	?           	?				?					created
09/10/2014	IN050655		VijayakumarK	09/10/2014							iASSIST ID : 807002 Index Tick sheet by practitioner is a 
																				good functionality to provide personalised tick sheets to practitioners.
------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,eOR.Common.*, eOR.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//HashMap dataMap=null;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id		= (String)hash.get("BEAN_ID");
	String bean_name	= (String)hash.get("BEAN_NAME");
	String chk_flag = request.getParameter("chkflag")==null?"":request.getParameter("chkflag");
	IndexTickSheet bean				= (IndexTickSheet)getBeanObject( bean_id, bean_name , request) ;
	String source_type = "";//IN050655
	eOR.Common.MultiRecordBean IndexShRecSet	= (eOR.Common.MultiRecordBean)bean.getBean();
	int count = 0;
	if(chk_flag.equals("CHECK_RECORDS")){
		String order_category		= (String)hash.get("ORDER_CATEGORY");
		String tick_sheet_id		= (String)hash.get("TICK_SHEET_ID");
		String index_type	= (String)hash.get("INDEX_TYPE");
		String fac_id	= (String)hash.get("FACILITY_ID");
		source_type		= (String)hash.get("SOURCE_TYPE");//IN050655
		//int dbRecordCount	=  bean.fetchDBRecords(order_category,tick_sheet_id,index_type,fac_id );//IN050655
		int dbRecordCount	=  bean.fetchDBRecords(order_category,tick_sheet_id,index_type,source_type,fac_id );//IN050655
		count = IndexShRecSet.getSize("DB");

		if(count > 0 || dbRecordCount > 0){
			out.println( "setRecordsFlag() ; " ) ;
		}else
			out.println( "setFlag() ; " ) ;

	
	}else{
		String index_value	= (String)hash.get("INDEX_VALUES");
		String fm_val		= (String)hash.get("FROM_VALUE");
		String to_val		= (String)hash.get("TO_VALUE");
		//String bean_id		= (String)hash.get("BEAN_ID");
		//String bean_name	= (String)hash.get("BEAN_NAME");
		String tab_value	= (String)hash.get("TAB_VALUE");	

		String update_value	="";
		//boolean alteredRecord = false;
		//int count_code		= 0;

		//IndexTickSheet bean				= (IndexTickSheet)getBeanObject( bean_id, bean_name , request) ;
		//eOR.Common.MultiRecordBean IndexShRecSet	= (eOR.Common.MultiRecordBean)bean.getBean();

		int fm_value = Integer.parseInt(fm_val);
		int to_value = Integer.parseInt(to_val);

		StringTokenizer stoken = new StringTokenizer(index_value,"~");
		//count_code		=	stoken.countTokens();
		
		
		for(int j=fm_value; j<=to_value; j++){
			update_value		=	stoken.nextToken();
			if(tab_value.equals("S"))
				IndexShRecSet.setBeanValue(j,update_value); //alteredRecord		=	IndexShRecSet.setBeanValue(j,update_value);
			else if(tab_value.equals("A"))
				IndexShRecSet.setDBBeanValue(j,update_value); //alteredRecord		=	IndexShRecSet.setDBBeanValue(j,update_value);
		}
		count = IndexShRecSet.getSize("DB");

		if(count > 0){
 			out.println( "setRecordsFlag()" ) ;
		}else
			out.println( "setFlag() ; " ) ;
	}

	putObjectInBean(bean_id,bean,request);

	
	/*
	out.println(tab_value);
	out.println(alteredRecord);
	out.println(index_value);
	out.println(fm_value);
	out.println(to_value);
	out.println(count_code);
	*/

%>
