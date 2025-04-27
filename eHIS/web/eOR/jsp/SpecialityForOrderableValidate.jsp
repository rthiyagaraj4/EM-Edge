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

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;

	String index_value	= (String)hash.get("INDEX_VALUES");
	String index_value1	= (String)hash.get("INDEX_VALUES1");
	String fm_val		= (String)hash.get("FROM_VALUE");
	String to_val		= (String)hash.get("TO_VALUE");
	String bean_id		= (String)hash.get("BEAN_ID");
	String bean_name	= (String)hash.get("BEAN_NAME");
	String tab_value	= (String)hash.get("TAB_VALUE");
	String order_catalog_splty	= (String)hash.get("ORDER_CATALOG_SPLTY");
	String order_catalog_code	= (String)hash.get("ORDER_CATALOG_CODE");
	

	if(order_catalog_code.equals("null") || order_catalog_code==null)order_catalog_code="";
	if(order_catalog_splty.equals("null") || order_catalog_splty==null)order_catalog_splty="";
	String update_value	="";
	String update_value1	="";
	StringTokenizer stoken1=null ;


	SpecialityForOrderable bean				= (SpecialityForOrderable)getBeanObject( bean_id,bean_name, request ) ;
	eOR.Common.MultiRecordBean multiRecSet	= (eOR.Common.MultiRecordBean)bean.getBean();
	if (order_catalog_splty.equals("SPLTY")) 
	{
			if(!order_catalog_code.equals(""))
			{
          
						String  speciality_code = (String)bean.getSpecialityCode(order_catalog_code);								out.println( "specialityCode(\"" + speciality_code + "\") ; " ) ;
				}
          
	}   
	else
	{
		int fm_value = Integer.parseInt(fm_val);
		int to_value = Integer.parseInt(to_val);

		StringTokenizer stoken = new StringTokenizer(index_value,"~");
		if(	index_value1!=null &&  !index_value1.equals(""))
		{
			stoken1 = new StringTokenizer(index_value1,"~");
		}
		for(int j=fm_value; j<=to_value; j++)
		{
			update_value		=	stoken.nextToken();
			if(	index_value1!=null &&  !index_value1.equals(""))
			{
				update_value1		=	stoken1.nextToken();
			}
			if(tab_value.equals("S"))
			{
				if(update_value1!="")
				{
					multiRecSet.setBeanValue(j,update_value,update_value1);  	
				}
				else
				{
					multiRecSet.setBeanValue(j,update_value);
				}
			}
			else if(tab_value.equals("A"))
			{
				if(update_value1!="")
				{
					multiRecSet.setDBBeanValue(j,update_value,update_value1); 
				}
				else
				{
					multiRecSet.setDBBeanValue(j,update_value);
				}
			}
		}
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
