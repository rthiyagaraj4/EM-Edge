
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%--
-----------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------
?             100         ?           created
04/04/2012	  IN031941	  Menaka V	  Transcribe External Prescription - Unable to place an order through copy previous orders.
-----------------------------------------------------------------------
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	try {
					 request.setCharacterEncoding("UTF-8");

	String patient_id	= request.getParameter("patient_id");
	String encounter_id	= request.getParameter("episode_id");

	String bean_id		= request.getParameter("bean_id");
	String bean_name	= request.getParameter("bean_name");
		String localeName = request.getParameter("localeName");


	if (bean_id	== null || bean_id.equals("")) return;
	if (bean_name == null || bean_name.equals("")) return;

	if ( patient_id == null || patient_id.equals( "" ) )
		return ;

	//if ( encounter_id == null || encounter_id.equals( "" ) )//IN031941
		//return ;//IN031941

	//String bean_id 					= "@orderentrybean"+patient_id+encounter_id;
	//String bean_name 				= "eOR.OrderEntryBean";

	//String practitioner_id = (String)session.getValue("ca_practitioner_id");
	//String facility_id = (String)session.getValue("facility_id");
	//String resp_id = (String)session.getValue("responsibility_id");

	//ExistingOrder beanObj = (ExistingOrder)mh.getBeanObject( bean_id, request , bean_name ) ;
	  ExistingOrder beanObj = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	 // beanObj.setLangusgeId("localeName");
	//beanObj.clear();  //For calling from Copy Orders
	      beanObj.setLanguageId(localeName);


	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	System.out.println("### hash="+hash);
    int rowCount = Integer.parseInt((String)hash.get("rowCount"));
    ArrayList setValues = new ArrayList();
    String qryString	= "";
    for (int i = 0; i < rowCount; i++) {
    	String [] setValsArray = new String[5];
    	setValsArray[0]	= (String)hash.get("order_id"+i);
    	setValsArray[1] = (String)hash.get("order_line_num"+i);
    	setValsArray[2] = (String)hash.get("catalog_code"+i);
    	setValsArray[3] = (String)hash.get("order_category"+i);
    	setValsArray[4] = (String)hash.get("order_type_code"+i);
    	setValues.add(setValsArray);
    }
    beanObj.setCopyOrderDetails(setValues);
    qryString = request.getQueryString();
    qryString = qryString.substring(0,qryString.indexOf("&bean_id"));
    //beanObj.setExistingQueryString(qryString);
    //System.out.println("setValsSize="+setValues.size());
	out.println("onSetCount('"+setValues.size()+"');");
	//out.println("alert('"+qryString+"');");
	//System.out.println("qryString="+qryString);


	putObjectInBean(bean_id,beanObj,request);
	} catch (Exception e) {
		//out.println("exception="+e.getMessage());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}


%>
