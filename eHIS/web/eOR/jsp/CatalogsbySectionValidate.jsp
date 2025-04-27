<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- Created by Uma on 9/9/2009 for  SRR20056-SCF-3386 IN013057-->
<%@ page contentType="text/html; charset=UTF-8"%> 
<%@page import="java.util.*, eOR.Common.*, eOR.* "%> 
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;

	String index_value	= (String)hash.get("INDEX_VALUES");
	String tick_sheet_seq_num 	= (String)hash.get("TICK_SHEET_SEQ_NUM");
	String fm_val		= (String)hash.get("FROM_VALUE");
	String to_val		= (String)hash.get("TO_VALUE");
	String bean_id		= (String)hash.get("BEAN_ID");
	//String bean_name	= (String)hash.get("BEAN_NAME");
	String tab_value	= (String)hash.get("TAB_VALUE");
	String catalog_code	= (String)hash.get("CATALOG_CODE");
	String order_type_code	= (String)hash.get("ORDER_TYPE_CODE");
	System.out.println("hash in validate"+hash);
	String update_value	="";
	//String locn_value = "";
	int  count = 0;
	

	CatalogsBySection bean = (CatalogsBySection)getBeanObject( bean_id.trim(),"eOR.CatalogsBySection",request) ;
	//eOR.Common.MultiRecordBean multiRecSet	= (eOR.Common.MultiRecordBean)bean.getBean();

	int fm_value = Integer.parseInt(fm_val);
	int to_value = Integer.parseInt(to_val);

	StringTokenizer stoken = new StringTokenizer(index_value,"~");
	StringTokenizer stoken1 = new StringTokenizer(tick_sheet_seq_num,"~");
	StringTokenizer catalog_codes = new StringTokenizer(catalog_code,"~");
	StringTokenizer order_type_codes = new StringTokenizer(order_type_code,"~");
	
	for(int j=fm_value; j<=to_value; j++)
	{
		if(stoken.hasMoreTokens()) 
		{
			update_value		=	 stoken.nextToken();
			
		}
		else 
			update_value		=	 "";

		if(stoken1.hasMoreTokens()) 
		{
			tick_sheet_seq_num			=	 (stoken1.nextToken()).trim();
			if(tick_sheet_seq_num.equals("N"))
				tick_sheet_seq_num		=	 "";
		}
		else 
		{
			tick_sheet_seq_num			=	 "";
		}

		if(catalog_codes.hasMoreTokens()) 
		{
			catalog_code		=	  (catalog_codes.nextToken()).trim();
		}
		else 
		{
			catalog_code			=	 "";
		}

		if(order_type_codes.hasMoreTokens()) 
		{
			order_type_code		=	  (order_type_codes.nextToken()).trim();
		}
		else 
		{
			order_type_code			=	 "";
		}

      	if(tab_value.equals("S")) 
		{

			if(update_value.equals("Y")) 
			{				
				bean.setBeanItemValue(j,tick_sheet_seq_num,update_value,catalog_code,order_type_code);
			}
		} 
		else if(tab_value.equals("A")) 
		{
			 bean.setDBBeanItemValue(j,tick_sheet_seq_num,update_value,catalog_code,order_type_code);
		}		
		count ++;
	}
	putObjectInBean(bean_id,bean,request);

%>
