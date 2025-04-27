<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,java.io.*"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>


<%
	request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
	String bean_name = request.getParameter( "bean_name" ) ;
	OrderCatalogMultiConsent  beanObj = (OrderCatalogMultiConsent)getBeanObject( bean_id , bean_name, request) ;

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" );
	
		String queryMode = (String) hash.get("QUERYMODE");
		if(null!=queryMode && queryMode.equalsIgnoreCase("test"))
		{
			String order_category_id = (String)hash.get("order_category") ;
			out.println("clearOCMultiConsentOrderType('document');");

			ArrayList orderTypeData = (ArrayList)beanObj.getOrderTypes(order_category_id) ;
			String[] record =null;
			for( int i=0 ; i< orderTypeData.size() ; i++ ) 
			{
				record = (String[])orderTypeData.get(i);
				out.println( "addorderTypeData2List(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
			}
			orderTypeData=null;
		}
		else if(null!=queryMode && queryMode.equalsIgnoreCase("search"))
		{
			String order_category_id = (String)hash.get("order_category") ;
			String orderType = (String) hash.get("order_type");
			String catalogue = (String) hash.get("order_catalog");
			String defSelected = (String) hash.get("definitionSelected");
			String recordCheck = (String) hash.get("recordCheck");//Added By  Channaveer B for issue number:IN21403
			ArrayList cataloguesData = (ArrayList)beanObj.getCatalogues(order_category_id,orderType,catalogue,defSelected) ;
			
			if(cataloguesData.size()==0)
			{
				//out.println("loadResultFrame('"+cataloguesData.size()+"')");
				out.println("recordsNotFound('document')");
				if(recordCheck.equals("NO"))////Added By  Channaveer B for issue number:IN21403
				{
				out.println("alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"))");
				}
				cataloguesData = null;
			}
			else
			{
				beanObj.setCatalogues_data(cataloguesData);
				//session.setAttribute("CATALOGUES_DATA",cataloguesData);
				out.println("loadResultFrame()");
			}
		}
		else if(null!=queryMode && queryMode.equalsIgnoreCase("sort"))
		{
			int totalRecords = (Integer.parseInt((String)hash.get("totalRecords"))) ;
			String[] catalogueInfo = null;
			ArrayList catalogueDetails = new ArrayList();
			String consentDesc = "";
			String consentID = "";
			String consentStage = "";
			String dfltSelected = "";
			String tempConsentDesc = "";
			String sequenceNumber = "";
			String select = "";
			for(int i=0;i<totalRecords;i++)
			{
				catalogueInfo = new String[7];
				consentDesc = (String) hash.get("consent_desc"+i);
				consentID = (String) hash.get("consent_form_id"+i);
				consentStage = (String) hash.get("consent_stage"+i);
				dfltSelected = (String) hash.get("mandatory"+i);
				sequenceNumber = (String) hash.get("seq_no"+i);
				tempConsentDesc = (String) hash.get("temp_consent_desc"+i);
				select = (String) hash.get("select"+i);
				catalogueInfo[0] = consentDesc;
				catalogueInfo[1] = consentID;
				catalogueInfo[2] = consentStage;
				catalogueInfo[3] = dfltSelected;
				catalogueInfo[4] = sequenceNumber;
				if(consentDesc.equalsIgnoreCase(tempConsentDesc))
				{
					catalogueInfo[5] = tempConsentDesc;
				}
				else
				{
					catalogueInfo[5] = "";
				}
				catalogueInfo[6] = select;
				catalogueDetails.add(catalogueInfo);
				beanObj.setCatalog_details(catalogueDetails);
				//session.setAttribute("CATALOGUES_DETAILS",catalogueDetails);
			}
		}
		putObjectInBean(bean_id,beanObj,request);
	
%>
