
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="beanObj" scope="page" class="eOR.ConsentOrders"/>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
request.setCharacterEncoding("UTF-8");
	String bean_id	 = request.getParameter( "bean_id" ) ;
	String validate	 = request.getParameter( "validate" ) ;

	String practitioner_id	= (String)session.getAttribute("ca_practitioner_id");
	String facility_id		= (String)session.getAttribute("facility_id");
	Properties properties	= (Properties)session.getAttribute( "jdbc" );

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	
	if ( validate == null || validate.equals( "" ) ) 
		return ;

	//ConsentOrders beanObj = (ConsentOrders)getBeanObject( bean_id, "eOR.ConsentOrders" ,request ) ;
	beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	if ( validate.equals( "ord_cat" ) ) {
		String locn_type = (String)hash.get("location_type") ;
		out.println( "clearList('document') ; " ) ;
		
	//	out.println( "alert(\"" + locn_type + "\") ; " ) ;

		ArrayList OrderTypeData = beanObj.getLocation(properties, locn_type,practitioner_id,facility_id) ;
		//out.println( "alert(\"" + beanObj.chk+ "\") ; " ) ;
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			String[] record = (String[])OrderTypeData.get(i);
			out.println( "addLocationList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	}else{
		ConsentOrders bean			= (ConsentOrders)getBeanObject(bean_id,"eOR.ConsentOrders",request);
		bean.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
		if ( validate.equals( "MULTI_CONSENT" ) ) {
			try{
			String order_catalog_code	= (String)hash.get("order_catalog_code") ;
			String order_id				= (String)hash.get("order_id") ;
			String order_line_num		= (String)hash.get("order_line_num") ;
			String type					= (String)hash.get("type") ;
								
			ArrayList multiConsentList	= null;
			StringBuffer noteligible_consent_id = new StringBuffer();
			StringBuffer tmp_consent_desc = new StringBuffer();
			multiConsentList			= bean.MultiListConsents(order_catalog_code,order_id, order_line_num, practitioner_id);
		
			String[] multiConsentValues	= null;
			//System.out.println("==multiConsentList=="+multiConsentList+"====");
			if(multiConsentList !=null && multiConsentList.size()>0 ){
				out.println( "showSelect() ; " ) ;
				for(int i=0;i<multiConsentList.size();i++){
					multiConsentValues		= (String[])multiConsentList.get(i);
					if(multiConsentValues[9].equals("Y")){
						
						if(multiConsentValues[12].equals("N")){
							noteligible_consent_id.append(multiConsentValues[1]);
							noteligible_consent_id.append("~");
							tmp_consent_desc = new StringBuffer();
							tmp_consent_desc.append(multiConsentValues[2]);
							tmp_consent_desc.append("(*)");
							//noteligible_consent_id += multiConsentValues[1] +"~" ;		
							//multiConsentValues[2] += "(*)";
							multiConsentValues[2] = tmp_consent_desc.toString();
						}

						if(type.equals("select-one")){
							out.println( "addConfirmedConsentList(\"" + multiConsentValues[1] + "\",\"" + multiConsentValues[2] + "\",\"" + multiConsentValues[10] + "\") ; " ) ;
						}else{
							
							out.println( "consent_id = \"" + multiConsentValues[1] + "\"; " ) ;
							out.println( "consent_desc =\"" + multiConsentValues[2] + "\"; " ) ;
						}
					}
					if( (multiConsentList.size() -1) == i){
						out.println( "noteligible_consent_id = \"" + noteligible_consent_id.toString()+ "\"; " ) ;
						out.println( "callDefaultSelect() ; " ) ;
					}
				}

			}else{
				
				ArrayList multiNAConsentList= null;
				multiNAConsentList = bean.MultiListConsentsNotAssociated(order_catalog_code,order_id,order_line_num, practitioner_id);
				
				if(multiNAConsentList != null && multiNAConsentList.size() > 0)
					out.println( "showSelect() ; " ) ;
				for(int i=0;i<multiNAConsentList.size();i++){
					multiConsentValues		= (String[])multiNAConsentList.get(i);
					if(multiConsentValues[9].equals("Y")){
						
						if(multiConsentValues[12].equals("N")){
							noteligible_consent_id.append(multiConsentValues[1]);
							noteligible_consent_id.append("~");
							tmp_consent_desc = new StringBuffer();
							tmp_consent_desc.append(multiConsentValues[2]);
							tmp_consent_desc.append("(*)");
							//noteligible_consent_id += multiConsentValues[1] +"~" ;		
							//multiConsentValues[2] += "(*)";
							multiConsentValues[2] = tmp_consent_desc.toString();
						}

						if(type.equals("select-one")){
							out.println( "addConfirmedConsentList(\"" + multiConsentValues[1] + "\",\"" + multiConsentValues[2] + "\",\"" + multiConsentValues[10] + "\") ; " ) ;
						}else{
							
							out.println( "consent_id = \"" + multiConsentValues[1] + "\"; " ) ;
							out.println( "consent_desc =\"" + multiConsentValues[2] + "\"; " ) ;
						}
					}
					if( (multiNAConsentList.size() -1) == i){
						out.println( "noteligible_consent_id = \"" + noteligible_consent_id.toString()+ "\"; " ) ;
						out.println( "callDefaultSelect() ; " ) ;
					}
				}

			}

			}catch(Exception e){
				//out.println(e.getMessage());//COMMON-ICN-0181
				e.printStackTrace();
			}
			
		}else if(validate.equals( "CLEAR_CONSENT" )){
			try{
			String index			= (String)hash.get("index");
			String from			= (String)hash.get("from");
			//System.err.println("from"+from);
			HashMap Consent			= bean.getConsentDetail();
			HashMap PatientDetail	= bean.getPatientDetail();
			HashMap Consentform		= bean.getConsentFormId();
			String consent_form_id	= (String)Consentform.get(index);
//	System.out.println("=consent_form_id=="+consent_form_id+"=Consent==="+Consent+"===index=="+index);	
			if(consent_form_id!= null && !consent_form_id.equals("")){
				if(Consent != null)
					Consent.remove(index+consent_form_id);
				if(PatientDetail != null)
					PatientDetail.remove(index);
//System.out.println("=Consent=="+Consent+"=PatientDetail==="+PatientDetail+"===index=="+index);
				bean.setConsentFormId(index, null);
				bean.setConsentDetail(Consent);
				bean.setPatientDetail(PatientDetail);
				//System.err.println("from"+from);
				if(from.equals("Select"))
				{
					out.println( "displayDetails(\""+index+"\",\"true\" ) ; " ) ;
				}
				else if(from.equals("chckbox"))
				{
					//System.err.println("entering here");
					out.println( "callDummy(\""+index+"\") ; " ) ;
				}
			}		

			}catch(Exception e){
				//out.println(e.getMessage());//COMMON-ICN-0181
				e.printStackTrace();
			}
		}else if(validate.equals( "GET_CONSENT_FORM_ID" )){
			String index			= (String)hash.get("index");
			String action			= "";
			HashMap Consentform		= bean.getConsentFormId();
			String consent_form_id	= (String)Consentform.get(index);
			//System.out.println("Consentform##########"+Consentform);
			//System.out.println("consent_form_id###########"+consent_form_id);
			if(hash.containsKey("action"))
				action				= (String)hash.get("action");
			if(action.equals("SHOW_DETAILS"))
				out.println( "consent_id = \"" + consent_form_id + "\"; " ) ;
			else{
				if(consent_form_id!= null && !consent_form_id.equals(""))
					out.println( "setConsentId('"+consent_form_id+"','"+index+"') ; " ) ;
				else
					out.println( "defaultSelect(\""+index+"\" ) ; " ) ;
			}
			
		}
		putObjectInBean(bean_id,bean,request);
	}
	//putObjectInBean(bean_id,bean,request);
%>
