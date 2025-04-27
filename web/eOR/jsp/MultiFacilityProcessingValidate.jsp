<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.Common.*, eOR.* "%> 
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	//HashMap dataMap=null;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;

	String index_value	= (String)hash.get("INDEX_VALUES");

	String locn_values 	= (String)hash.get("LOCN_VALUES");
	String fm_val		= (String)hash.get("FROM_VALUE");
	String to_val		= (String)hash.get("TO_VALUE");
	String bean_id		= (String)hash.get("BEAN_ID");
	String bean_name	= (String)hash.get("BEAN_NAME");
	String tab_value	= (String)hash.get("TAB_VALUE");
	//String class_name   = (String)hash.get("CLASS_NAME");

	String update_value	="";
	String locn_value = "";
	//boolean alteredRecord = false;
	//int count_code		= 0;

	MultiFacilityProcessingBean bean				= (MultiFacilityProcessingBean)getBeanObject( bean_id, bean_name, request ) ;
	eOR.Common.MultiRecordBean multiRecSet	= (eOR.Common.MultiRecordBean)bean.getBean();

	int fm_value = Integer.parseInt(fm_val);
	int to_value = Integer.parseInt(to_val);

	StringTokenizer stoken = new StringTokenizer(index_value,"~");
	StringTokenizer stoken1 = new StringTokenizer(locn_values,"~");
	//count_code		=	stoken.countTokens();

	//HashMap ht =null;
	for(int j=fm_value; j<=to_value; j++){
		if(stoken.hasMoreTokens()) 
			update_value		=	 stoken.nextToken();
		else 
			update_value		=	 "";

		if(stoken1.hasMoreTokens()) 
			locn_value			=	 (stoken1.nextToken()).trim();
		else 
			locn_value			=	 "";

      	//System.out.println("###### tab_value :"+tab_value);
      	//System.out.println("###### update_value :"+update_value);

		if(tab_value.equals("S")) {

			if(update_value.equals("Y")) {

				//System.out.println("@@Selupdate_value :"+update_value);
                //System.out.println("@@Sellocn_value :"+locn_value);

				multiRecSet.setBeanValue(j,update_value);
 				//alteredRecord		=	multiRecSet.setBeanValue(j,update_value);
				bean.setBeanItemValue(j,locn_value);
			}
			//else
			//{
     			//ht  =(HashMap)multiRecSet.getListObject(j);
				//int indx = multiRecSet.scanRecord(ht);
                   // if(indx!=-1)
                       // multiRecSet.removeObject(indx);
			//}
		} else if(tab_value.equals("A")) {
			    //System.out.println("@@Ass update_value :"+update_value);
                //System.out.println("@@Ass locn_value :"+locn_value);
				multiRecSet.setDBBeanValue(j,update_value);
				//alteredRecord		=	multiRecSet.setDBBeanValue(j,update_value);
				bean.setDBBeanItemValue(j,locn_value);
		}

		//HashMap ht  =(HashMap)multiRecSet.getListObject(i);

		//ht = Validaty(ht,tab_value); //this will give the inserted record if already present in the database
  		//ht.put("performing_locn",locn_value);
  		//altSelRecord = multiRecSet.setListObject(j, ht);
	}

	/*
	out.println(tab_value);
	out.println(alteredRecord);
	out.println(index_value);
	out.println(fm_value);
	out.println(to_value);
	out.println(count_code);
	*/

	putObjectInBean(bean_id,bean,request);

%>
