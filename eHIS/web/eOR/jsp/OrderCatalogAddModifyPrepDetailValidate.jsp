<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eOR.Common.*, eOR.* " contentType="text/html; charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	//HashMap dataMap=null;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id		= (String)hash.get("BEAN_ID");
	String bean_name	= (String)hash.get("BEAN_NAME");
	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject( bean_id, bean_name, request ) ;
	eOR.Common.MultiRecordBean multiRecSet	= (eOR.Common.MultiRecordBean)bean.getBean();
	if(hash.containsKey("clearFlag")){
	String clearFlag=hash.get("clearFlag")==null?"":(String)hash.get("clearFlag");
	if(clearFlag.equals("true"))
		multiRecSet.clearDBRec();
	}else{
	String index_value	= (String)hash.get("INDEX_VALUES");

    String sec_order_stage_stat_values 	    = (String)hash.get("SEC_ORDER_STAGE_STAT_VALUES");
    String sec_order_stat_durn_values       = (String)hash.get("SEC_ORDER_STAT_DURN_VALUES");
    String sec_order_stat_durn_type_values 	= (String)hash.get("SEC_ORDER_STAT_DURN_TYPE_VALUES");

    String sec_order_stage_urg_values       = (String)hash.get("SEC_ORDER_STAGE_URG_VALUES");
    String sec_order_urg_durn_values        = (String)hash.get("SEC_ORDER_URG_DURN_VALUES");
    String sec_order_urg_durn_type_values 	= (String)hash.get("SEC_ORDER_URG_DURN_TYPE_VALUES");

    String sec_order_stage_rtn_values       = (String)hash.get("SEC_ORDER_STAGE_RTN_VALUES");
    String sec_order_rtn_durn_values        = (String)hash.get("SEC_ORDER_RTN_DURN_VALUES");
    String sec_order_rtn_durn_type_values 	= (String)hash.get("SEC_ORDER_RTN_DURN_TYPE_VALUES");
	String pri_sec_tasks_type_values 	= (String)hash.get("PRI_SEC_TASKS_TYPE_STR_VALUES");

	String fm_val		= (String)hash.get("FROM_VALUE");
	String to_val		= (String)hash.get("TO_VALUE");	
	String tab_value	= (String)hash.get("TAB_VALUE");
	//String class_name   = (String)hash.get("CLASS_NAME");
	
	String update_value	="";

    String sec_order_stage_stat = "";
    String sec_order_stat_durn = "";
    String sec_order_stat_durn_type = "";

    String sec_order_stage_urg = "";
    String sec_order_urg_durn = "";
    String sec_order_urg_durn_type = "";

    String sec_order_stage_rtn = "";
    String sec_order_rtn_durn = "";
    String sec_order_rtn_durn_type = "";
	String pri_sec_tasks_type = "";

   // boolean alteredRecord = false;
	//int count_code		= 0;

	//OrderCatalogBean bean = (OrderCatalogBean)mh.getBeanObject(bean_id,request, bean_name ) ;
	

	int fm_value = Integer.parseInt(fm_val);
	int to_value = Integer.parseInt(to_val);

	StringTokenizer stoken = new StringTokenizer(index_value,"~");

    StringTokenizer stoken1 = new StringTokenizer(sec_order_stage_stat_values,"~");
    StringTokenizer stoken2 = new StringTokenizer(sec_order_stat_durn_values,"~");
    StringTokenizer stoken3 = new StringTokenizer(sec_order_stat_durn_type_values,"~");

    StringTokenizer stoken4 = new StringTokenizer(sec_order_stage_urg_values,"~");
    StringTokenizer stoken5 = new StringTokenizer(sec_order_urg_durn_values,"~");
    StringTokenizer stoken6 = new StringTokenizer(sec_order_urg_durn_type_values,"~");

    StringTokenizer stoken7 = new StringTokenizer(sec_order_stage_rtn_values,"~");
    StringTokenizer stoken8 = new StringTokenizer(sec_order_rtn_durn_values,"~");
    StringTokenizer stoken9 = new StringTokenizer(sec_order_rtn_durn_type_values,"~");
	 StringTokenizer stoken10 = new StringTokenizer(pri_sec_tasks_type_values,"~");

  //  count_code		=	stoken.countTokens();


	for(int j=fm_value; j<=to_value; j++){
		update_value		=	stoken.nextToken();

        sec_order_stage_stat		=	(stoken1.nextToken()).trim();
        sec_order_stat_durn			=	(stoken2.nextToken()).trim();
        sec_order_stat_durn_type	=	(stoken3.nextToken()).trim();

        sec_order_stage_urg			=	(stoken4.nextToken()).trim();
        sec_order_urg_durn			=	(stoken5.nextToken()).trim();
        sec_order_urg_durn_type		=	(stoken6.nextToken()).trim();

        sec_order_stage_rtn			=	(stoken7.nextToken()).trim();
        sec_order_rtn_durn			=	(stoken8.nextToken()).trim();
        sec_order_rtn_durn_type		=	(stoken9.nextToken()).trim();
		pri_sec_tasks_type			=	(stoken10.nextToken()).trim();
		//System.out.println("##in validate jsp,tab_value="+tab_value);

		if(tab_value.equals("S")) {
			//alteredRecord		=	multiRecSet.setBeanValue(j,update_value);

            bean.setBeanItemValue(j,update_value,sec_order_stage_stat,sec_order_stat_durn,sec_order_stat_durn_type,sec_order_stage_urg,sec_order_urg_durn,sec_order_urg_durn_type,sec_order_stage_rtn,sec_order_rtn_durn,sec_order_rtn_durn_type,pri_sec_tasks_type);

		} else if(tab_value.equals("A")) {
			//alteredRecord		=	
			multiRecSet.setDBBeanValue(j,update_value);

            bean.setDBBeanItemValue(j,sec_order_stage_stat,sec_order_stat_durn,sec_order_stat_durn_type,sec_order_stage_urg,sec_order_urg_durn,sec_order_urg_durn_type,sec_order_stage_rtn,sec_order_rtn_durn,sec_order_rtn_durn_type,pri_sec_tasks_type);

		}

		//HashMap ht  =(HashMap)multiRecSet.getListObject(i);

		//ht = Validaty(ht,tab_value); //this will give the inserted record if already present in the database
  		//ht.put("performing_locn",locn_value);
  		//altSelRecord = multiRecSet.setListObject(j, ht);
	}
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
