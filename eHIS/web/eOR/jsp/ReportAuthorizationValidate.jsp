<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%  request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	String flag		= request.getParameter("flag");

	String practitioner_id	= (String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");
	String facility_id 		= (String)session.getValue("facility_id")==null?"":(String)session.getValue("facility_id");
	String resp_id 			= (String)session.getValue("responsibility_id")==null?"":(String)session.getValue("responsibility_id");

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	ReportAuthorizationBean beanObj = (ReportAuthorizationBean)getBeanObject( bean_id, "eOR.ReportAuthorizationBean" , request) ;
	beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	//System.out.println("====hash==="+hash);
    hash = (Hashtable)hash.get( "SEARCH" ) ;
    if (flag == null || flag.equals("")) {
		if ( validate.equals( "location" ) ) {
			String locn_type = (String)hash.get("location_type") ;
			out.println( "clearList('document') ; " ) ;
			//System.out.println("facility_id"+facility_id+"practitioner_id"+practitioner_id+"locn_type"+locn_type);
			ArrayList OrderTypeData = beanObj.getLocation(facility_id, practitioner_id, locn_type) ;
			for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
				String[] record = (String[])OrderTypeData.get(i);
				//out.println( "addLocationList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				String selected = "false";
				out.println( "addLocationList(\"" + record[0] + "\",\"" + record[1] + "\",\"" + selected + "\") ; " ) ;
			}
		}
	} else if (flag.equalsIgnoreCase("true")) {
		if ( validate.equals( "location" ) ) {
			//String locn_type = (String)hash.get("location_type") ;
			out.println( "clearList('document') ; " ) ;
			out.println( "clearActivityTypeList('document'); " ) ;

			//ArrayList OrderTypeData = beanObj.getLocation(facility_id, practitioner_id, locn_type) ;
			//System.out.println("practitioner_id"+practitioner_id+"resp_id"+resp_id);
			ArrayList OrderTypeData = beanObj.getOrderCategory(practitioner_id, resp_id);
			for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
				String[] record = (String[])OrderTypeData.get(i);
				String selected = "false";
				//out.println("alert('in:"+OrderTypeData.size()+"')");
				if (OrderTypeData.size() == 1 && i == 0) {
					//out.println("alert('in')");
					selected = "true";
				}
				out.println( "addLocationList(\"" + record[0] + "\",\"" + record[1] + "\",\"" + selected + "\") ; " ) ;
				if (OrderTypeData.size() == 1) {
					out.println("populateLocnOrdType('locn');");
				} else {
					out.println("formObj.locn.value='';");
				}
			}
			
		} else if ( validate.equals( "ord_type" ) ) {
			String orderCategory = (String)hash.get("locn") ;
			out.println( "clearTypeList('document') ; " ) ;
			//ArrayList OrderTypeData = beanObj.getLocation(facility_id, practitioner_id, locn_type) ;
			//System.out.println("orderCategory"+orderCategory+"practitioner_id"+practitioner_id+"resp_id"+resp_id);
			ArrayList OrderTypeData = beanObj.getOrderType(orderCategory, practitioner_id, resp_id);
			
			for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
				String[] record = (String[])OrderTypeData.get(i);
				out.println( "addTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
			}
			String order_type = "" ;
			out.println( "clearActivityTypeList('document'); " ) ;
			//System.out.println("orderCategory"+orderCategory+"order_type"+order_type);
			ArrayList ActivityType = beanObj.getActivityType(orderCategory, order_type);
			for( int i=0 ; i< ActivityType.size() ; i++ ) {
				String[] record = (String[])ActivityType.get(i);
							
				out.println( "addActivityList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				
			}
			String isPerformingLocnYN = "N";

           /* if (!(practitioner_id == null || practitioner_id.equals("")))
				isPerformingLocnYN = beanObj.isPerformingLocnYN("",practitioner_id,orderCategory);
			if ((isPerformingLocnYN == null || isPerformingLocnYN.equals("N")) && !(resp_id == null || resp_id.equals("")))
                isPerformingLocnYN = beanObj.isPerformingLocnYN(resp_id,"",orderCategory);*/
				isPerformingLocnYN = beanObj.isPerformingLocnYN(resp_id,practitioner_id,orderCategory);

            if (isPerformingLocnYN.equalsIgnoreCase("Y")) {
            	out.println("formObj.performing_locn_lbl_show.innerHTML='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PerformingLocation.label","common_labels")+"'");
            	out.println("formObj.performing_locn_show.innerHTML=\"<select name='performing_location_code' id='performing_location_code'><option value=''>   ---Select---   </option></select>\"");
            	out.println( "clearPerformingLocnList('document') ; " ) ;
	            ArrayList PerformingLocn = new ArrayList();

				if (!(practitioner_id == null || practitioner_id.equals("")))
	            	PerformingLocn = beanObj.getPerformingLocn("", practitioner_id, orderCategory);

	            if ((PerformingLocn.size() == 0) && !(resp_id == null || resp_id.equals("")))
	            	PerformingLocn = beanObj.getPerformingLocn(resp_id,"",orderCategory);

				for( int i=0 ; i< PerformingLocn.size() ; i++ ) {
					String[] record = (String[])PerformingLocn.get(i);
					out.println( "addPerformingLocnList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				}
			} else {
				//out.println("formObj.all.performing_locn_lbl_show.innerHTML = \"&nbsp;\"");
				//out.println("formObj.all.performing_locn_show.innerHTML = \"&nbsp;\"");
				//out.println("alert('resp_id="+resp_id+",practitioner_id="+practitioner_id+",orderCategory="+orderCategory+"')");
			}
		} else if( validate.equals( "fing_values" ) ) {
    	  // String fingurePrnYN	= "N";
		   String fingurePrnYN = beanObj.fingurePrintYN();
    	   out.println("fingurePrnYN='"+fingurePrnYN+"'");
		   //System.out.println("fingurePrnYN======report======================="+fingurePrnYN+"----");
    	   //out.println("alert('Incorporate The Fingure Signature Function. Please Contact Srikanta');");
    	}else if ( validate.equals( "activity_type" ) ) {
			String order_category = request.getParameter("order_category");
			String order_type = request.getParameter("order_type") ;
			out.println( "clearActivityTypeList('document'); " ) ;

			ArrayList ActivityType = beanObj.getActivityType(order_category, order_type);
			for( int i=0 ; i< ActivityType.size() ; i++ ) {
				String[] record = (String[])ActivityType.get(i);
							
				out.println( "addActivityList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				
			}
			
		}else if(validate.equals( "ResultEntryReport" ) ) {
			 Hashtable allValues  =  beanObj.getPrintValues();
		     if ((allValues != null) && (allValues.size() > 0)) {
				//out.println("alert('APP-OR0148 Report has been Submitted to thePrinter')");
				OnLinePrinting online_print = new OnLinePrinting();
				online_print.printResultEntryReport(allValues,request,response);
				
			}

		}
	}
	
	putObjectInBean(bean_id,beanObj,request);
%>

