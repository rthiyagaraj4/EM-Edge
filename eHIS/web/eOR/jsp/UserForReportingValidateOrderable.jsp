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
	String row_counts	= (String)hash.get("ROW_COUNT");
	String bean_id		= (String)hash.get("BEAN_ID");
	String bean_name	= (String)hash.get("BEAN_NAME");
	String tab_value	= (String)hash.get("TAB_VALUE");
	//String class_name   = (String)hash.get("CLASS_NAME");

	String update_value	="";
	
	//boolean alteredRecord = false;
	//int count_code		= 0;

	UserForReporting bean		= (UserForReporting)getBeanObject( bean_id, bean_name , request) ;
	eOR.Common.MultiRecordBean multiRecSet	= (eOR.Common.MultiRecordBean)bean.getBean();
	bean.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
	
	if(hash.containsKey("INDEX_VALUES")){
		StringTokenizer stoken = new StringTokenizer(index_value,"~");
		//count_code		=	stoken.countTokens();

		int row_count = Integer.parseInt(row_counts);

		for(int j=0; j<row_count; j++){
			update_value		=	stoken.nextToken();
			

			if(tab_value.equals("S")) {
				multiRecSet.setBeanValue(j,update_value);
				//alteredRecord		=	multiRecSet.setBeanValue(j,update_value);
			} else if(tab_value.equals("A")) {
				multiRecSet.setDBBeanValue(j,update_value);
				//alteredRecord		=	multiRecSet.setDBBeanValue(j,update_value);
			}

			//HashMap ht  =(HashMap)multiRecSet.getListObject(i);

			//ht = Validaty(ht,tab_value); //this will give the inserted record if already present in the database
			//ht.put("performing_locn",locn_value);
			//altSelRecord = multiRecSet.setListObject(j, ht);

			
	/*
	out.println(tab_value);
	out.println(alteredRecord);
	out.println(index_value);
	out.println(fm_value);
	out.println(to_value);
	out.println(count_code);
	*/
		}
	}else{
		
		int row_count = 0;
		boolean selected = false;
		HashMap htListRecord= null;
		String associate_yn	= null;

		row_count			=	multiRecSet.getSize("DB");
		for(int i=0;i<row_count;i++){
			htListRecord	=	(java.util.HashMap)multiRecSet.getObject(i);
			associate_yn	=	(String)	htListRecord.get("associate_yn");
			if(associate_yn != null && associate_yn.equalsIgnoreCase("Y")){
				selected = true;
				break;
			}
		
		}
		if(!selected){
			row_count		=	multiRecSet.getSize("SELECT");
			for(int i=0;i<row_count;i++){
				htListRecord	=	(java.util.HashMap)multiRecSet.getListObject(i);
				associate_yn	=	(String)	htListRecord.get("associate_yn");
				if(associate_yn != null && associate_yn.equalsIgnoreCase("Y")){
					selected = true;
					break;
				}
			}

		}

		if(selected)
			out.println("selFlag=true");
		else
			out.println("selFlag=false");

	}

	putObjectInBean(bean_id,bean,request);
%>
