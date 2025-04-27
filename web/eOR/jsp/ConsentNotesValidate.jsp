
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
12/11/2018	  IN069014		Prakash C		12/11/2018		Ramesh G		CA-MMOH-Consent Checkbox
---------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*,java.net.*,eOR.* "%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String bean_id ="";
	String bean_name = "";
	String index = "";
	String consent_form_text = "";
	String consent_form_id = "";
	String count	= "0";
 
	//String Consentdetail = request.getParameter( "Consentdetail" ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	
	bean_id = (String)hash.get("bean_id");
	bean_name = (String)hash.get("bean_name");
	index = (String)hash.get("index");
	consent_form_text = (String)hash.get("consent_form_text");
	consent_form_id = (String)hash.get("consent_form_id");
	
	//System.out.println("index====================="+index);
	//System.out.println("consent_form_id====================="+consent_form_id);

	count	= (String)hash.get("count");
	String consent_text = "";
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	if ( consent_form_id == null || consent_form_id.equals( "" ) ) consent_form_id = "";
	if ( count == null || count.equals( "" ) ) count = "0";

	String patient_name		= (String)hash.get("patient_name");
	if ( patient_name == null || patient_name.equals( "" ) ) patient_name = "";
	String practitioner_name = (String)hash.get("practitioner_name");
	if ( practitioner_name == null || practitioner_name.equals( "" ) ) practitioner_name = "";
	String reln_box			= (String)hash.get("reln_box");
	if ( reln_box == null || reln_box.equals( "" ) ) reln_box = "";
	String dat_time			= (String)hash.get("dat_time");
	if ( dat_time == null || dat_time.equals( "" ) ) dat_time = "";
	String remarks			= (String)hash.get("remarks");
	if ( remarks == null || remarks.equals( "" ) ) remarks = "";
	String practitioner_id			= (String)hash.get("practitioner_id");
	if ( practitioner_id == null || practitioner_id.equals( "" ) ) practitioner_id = "";
	String self			= (String)hash.get("self");
	if ( self == null || self.equals( "" ) ) self = "n";
	
    
	int count_records = Integer.parseInt(count);
	//String consent_form_id = "";
	//HashMap consentCatalog = new HashMap();

	ConsentOrders beanObj = (ConsentOrders)getBeanObject( bean_id, bean_name ,request) ;
	HashMap consent= (HashMap)beanObj.getConsentDetail();
	HashMap patient_detail= (HashMap)beanObj.getPatientDetail();
	ArrayList patient_info = new ArrayList();
		
	if(count_records>0){
		for(int i=0;i<count_records;i++){
			consent_text = (String)hash.get("consent_form_text"+i);
			consent_form_id = (String)hash.get("consent_form_id"+i);
	 		consent.put(index+consent_form_id,consent_text);
			//catalog = catalog+"||";
			if(!practitioner_name.equals("")){//IN069014
				beanObj.setConsentFormId(index, consent_form_id);
			}//IN069014
 		}
		//consentCatalog.put(index, catalog);
	} else {
		consent.put(index,consent_form_text);
		beanObj.setConsentFormId(index, consent_form_id);
  	}
	
	// Storing it in a arraylist , then storing it in the hashmap with the index as key
	//patient_info.add(patient_name);//IN036697
	patient_info.add(URLDecoder.decode(patient_name, "UTF-8"));//IN036697
	patient_info.add(practitioner_name);
	patient_info.add(reln_box);
	patient_info.add(dat_time);
	patient_info.add(remarks);
	patient_info.add(practitioner_id);
	patient_info.add(self);
	

	patient_detail.put(index, patient_info);
	beanObj.setConsentDetail(consent);
	beanObj.setPatientDetail(patient_detail);
	//out.println("consent"+consent);
	//consent = beanObj.getConsentDetail();

	//String consentStr = (String)consent.get(index);
	patient_info = null;
 	patient_detail = null;

	putObjectInBean(bean_id,beanObj,request);
	
%>
