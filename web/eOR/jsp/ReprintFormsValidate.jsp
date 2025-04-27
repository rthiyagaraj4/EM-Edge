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

<%
request.setCharacterEncoding("UTF-8");
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
	//String flag		= request.getParameter("flag");

	//String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	//String resp_id = (String)session.getValue("responsibility_id");

	//out.println("alert('in')");
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	ReprintFormsBean beanObj = (ReprintFormsBean)getBeanObject( bean_id,"eOR.ReprintFormsBean" , request) ;
	beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
//System.out.println("validate"+validate);
    	if ( validate.equals( "location" ) ) {

			String location	 = request.getParameter("location");
			if (location.equalsIgnoreCase("source")) {
				String locn_type = (String)hash.get("source_type") ;
				out.println( "clearList1('document') ; " ) ;
				out.println("clearList2('document');");
				//out.println( "alert(\"" + locn_type + "\") ; " ) ;
				ArrayList LocationData = beanObj.getLocation(locn_type,location) ;
				//out.println( "alert(\"" + beanObj.chk+ "\") ; " ) ;
				for( int i=0 ; i< LocationData.size() ; i++ ) {
					String[] record = (String[])LocationData.get(i);
					out.println( "addLocationList1(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
					out.println( "addLocationList2(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				}
			} else if (location.equalsIgnoreCase("print")) {
				String locn_type = (String)hash.get("print_at") ;
				out.println("clearList3('document');");
				ArrayList LocationData = beanObj.getLocation(locn_type,location) ;
				for( int i=0 ; i< LocationData.size() ; i++ ) {
					String[] record = (String[])LocationData.get(i);
					out.println( "addLocationList3(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				}
			}

		}
		else if ( validate.equals( "ord_cat" ) ) {
			String report_type = (String)hash.get("report") ;
			out.println( "clearCategoryList('document') ; " ) ;
            ArrayList OrderCategoryData = new ArrayList();
			//ArrayList OrderTypeData = beanObj.getLocation(facility_id, practitioner_id, locn_type) ;
			OrderCategoryData = beanObj.getSearchOrderCategory();
            //String isLBInstalled = beanObj.isModuleInstalled(facility_id,"RL");changed on 7/19/2007 for lab_install check change by uma 
            String isRDInstalled = beanObj.isModuleInstalled(facility_id,"RD");
			//out.println("alert('"+report_type+","+isLBInstalled+","+isRDInstalled+"')");
			for( int i=0 ; i< OrderCategoryData.size() ; i++ ) {
				String selected = "false";
				String[] record = (String[])OrderCategoryData.get(i);
				//out.println("alert('"+(((record[1].equalsIgnoreCase("LB")) && (!isLBInstalled.equalsIgnoreCase("Y"))) || ((record[1].equalsIgnoreCase("RD")) && (!isRDInstalled.equalsIgnoreCase("Y"))))+"')");
				//System.out.println("report_type"+report_type);
				if (report_type.equalsIgnoreCase("R")) {
					//if (((record[1].equalsIgnoreCase("LB")) && (!isLBInstalled.equalsIgnoreCase("Y"))))changed on 7/19/2007 for lab_install check change by uma 
					if (((record[1].equalsIgnoreCase("LB"))))
						out.println( "addCategoryList(\"" + record[1] + "\",\"" + record[0] + "\",\"" + selected + "\") ; " ) ;
					else if ((record[1].equalsIgnoreCase("RD")) && (!isRDInstalled.equalsIgnoreCase("Y")))
						out.println( "addCategoryList(\"" + record[1] + "\",\"" + record[0] + "\",\"" + selected + "\") ; " ) ;
					else if ((!record[1].equalsIgnoreCase("RD")) && (!record[1].equalsIgnoreCase("LB")))
						out.println( "addCategoryList(\"" + record[1] + "\",\"" + record[0] + "\",\"" + selected + "\") ; " ) ;
				} else if (report_type.equalsIgnoreCase("L")) {
					if (record[1].equalsIgnoreCase("LB"))
						out.println( "addCategoryList(\"" + record[1] + "\",\"" + record[0] + "\",\"" + selected + "\") ; " ) ;
				}else {
					out.println( "addCategoryList(\"" + record[1] + "\",\"" + record[0] + "\",\"" + selected + "\") ; " ) ;
				}
			}
		} else if ( validate.equals( "ord_type" ) ) {
			String orderCategory = (String)hash.get("ord_cat") ;
			out.println( "clearTypeList('document') ; " ) ;
            ArrayList OrderTypeData = new ArrayList();
            OrderTypeData = beanObj.getSearchOrderType(orderCategory);

   for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
				String[] record = (String[])OrderTypeData.get(i);
				out.println( "addTypeList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
			}
		}

		putObjectInBean(bean_id,beanObj,request);
%>
