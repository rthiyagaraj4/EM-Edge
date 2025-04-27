<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=ISO-8859-1"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String bean_id = request.getParameter( "bean_id" ) ;
String bean_name = request.getParameter( "bean_name" ) ;
String func_mode = request.getParameter( "func_mode" ) ;

String practitioner_id = (String)session.getValue("ca_practitioner_id");
String facility_id=(String)session.getValue("facility_id");


if ( bean_id == null || bean_id.equals( "" ) )
		return ;
if ( bean_name == null || bean_name.equals( "" ) )
		return ;


if ( func_mode == null || func_mode.equals( "" ) )
		return ;



//PatOrderByLocnBean beanObj = (PatOrderByLocnBean)mh.getBeanObject( bean_id, request , bean_name) ;
PatOrderByLocnBean beanObj = (PatOrderByLocnBean)getBeanObject( bean_id, bean_name, request ) ;

String[] record	= null;


Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
hash = (Hashtable)hash.get( "SEARCH" ) ;

	if(func_mode!=null && func_mode.equals("order_cat"))
	{
		String locn_type = (String)hash.get("location_type") ;
		if ( locn_type == null || locn_type.equals( "" ) )
		locn_type="";
		out.println( "clearList('document') ; " ) ;

		ArrayList LocationType = beanObj.getLocation(locn_type,practitioner_id,facility_id) ;
		for( int i=0 ; i< LocationType.size() ; i++ ) {
			record = (String[])LocationType.get(i);
			out.println( "addLocationList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	}
	else if(func_mode!=null && func_mode.equals("order_type"))
	{
		String order_category = (String)hash.get("order_category") ;
		if ( order_category == null || order_category.equals( "" ) )
				order_category="";
		out.println( "clearList1('document') ; " ) ;
		ArrayList OrderTypeData = beanObj.getOrderType(order_category) ;
		for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
			 record = (String[])OrderTypeData.get(i);
			out.println( "addLocationList1(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
	}
	else if(func_mode!=null && func_mode.equals("populate_patients"))
	{
		String code 		= request.getParameter( "code" ) ;
		String rows 		= request.getParameter( "rows" ) ;
		String old_val		= rows;
		String description	= "";
		ArrayList PatientDetails = beanObj.getNursingUnitPatientDetails(code) ;
		StringBuffer htmlText	= new StringBuffer();
		if(PatientDetails!=null && PatientDetails.size() > 0)
			htmlText.append(" <table cellpadding=0 cellspacing=0 border=0 width='100%' align='left'>");
		for( int i=0 ; i< PatientDetails.size() ; i++ ) {

			record = (String[])PatientDetails.get(i);

			description			= record[0]; // Patient Details
			// Replace the special characters with some special symbol so that they can be replaced  later
			description			= description.replace(' ','ö');
			description			= description.replace('>','ø');
			description			= description.replace('\'','ù');
			// Create a table and insert into the one TD
			htmlText.append(" <tr> ");
			htmlText.append("	<td CLASS='OR_WHITE' width='100%' id=patdtl_"+old_val+i+">");
			htmlText.append("  		<a href=javascript:expandCategory('"+old_val+"','"+i+"','"+record[1]+"',escape('"+description+"'))>");
			htmlText.append("			+&nbsp;"+ record[0]);
			htmlText.append("		</a>&nbsp;");
			htmlText.append("	</td>");
			htmlText.append(" </tr>");
			htmlText.append(" <tr>");
			htmlText.append("	<td CLASS='OR_WHITE'>");
			htmlText.append("		<div id=thirdinnerlayernursing_"+old_val+i+" style='visibility:hidden;position:absolute'>");
			htmlText.append("			<table cellpadding=0 cellspacing=0 border=0 width='100%' align='left'>");
			htmlText.append(" 				<tr>");
			htmlText.append( "					<td CLASS='OR_WHITE' WIDTH='5%'>&nbsp;</td>");
			htmlText.append("					<td CLASS='OR_WHITE' id=thirdlevelinner_"+old_val+i+">&nbsp;</td>");
			htmlText.append("				</tr>");
			htmlText.append("			</table>");
			htmlText.append("		</div>");
			htmlText.append("	</td>");
			htmlText.append(" </tr>");
		}
		if(PatientDetails!=null && PatientDetails.size() > 0)
			htmlText.append(" </table>");
		if(htmlText!=null && htmlText.length() >0)
			out.println( "addPatientDetails(\""+old_val+"\" ,\"" + htmlText.toString() +"\") ; " ) ;
	}
	else if(func_mode!=null && func_mode.equals("populate_categories"))
	{
		String old_val 		= request.getParameter( "old_val" ) ;
		String patient_id 	= request.getParameter( "patient_id" ) ;
		String curr_val 	= request.getParameter( "curr_val" ) ;
		old_val				= old_val+curr_val;
		ArrayList CategoryDetails = beanObj.getCategoryDtls(patient_id) ;
		StringBuffer htmlText	= new StringBuffer();
		String description	= "";
		if(CategoryDetails!=null && CategoryDetails.size() > 0)
			htmlText.append(" <table cellpadding=0 cellspacing=0 border=0 width='100%' align='left'>");
		for( int i=0 ; i< CategoryDetails.size() ; i++ ) {
			// Create a table and insert into the one TD
			record = (String[])CategoryDetails.get(i);

			description			= record[0]; // Category Details
			// Replace the special characters with some special symbol so that they can be replaced  later
			description			= description.replace(' ','ö');
			description			= description.replace('>','ø');
			description			= description.replace('\'','ù');
			htmlText.append(" <tr>");
			htmlText.append("	<td CLASS='OR_WHITE' width='100%' id=catdtl_"+old_val+i+">");
			htmlText.append("		<a href=javascript:expandOrderType('"+old_val+"','"+i+"','"+record[1]+"','"+record[2]+"',escape('"+description+"'))>");
			htmlText.append("			+&nbsp"+record[0] );
			htmlText.append("		</a>&nbsp;");
			htmlText.append(" 	</td>");
			htmlText.append(" </tr>");
			htmlText.append(" <tr>");
			htmlText.append(" 	<td CLASS='OR_WHITE'>");
			htmlText.append("		<div id=fourthinnerlayernursing_"+old_val+i+" style='visibility:hidden;position:absolute'>");
			htmlText.append("			<table cellpadding=0 cellspacing=0 border=0 width='100%' align='left'>");
			htmlText.append("				<tr>");
			htmlText.append("					<td CLASS='OR_WHITE' WIDTH='5%'>&nbsp;</td>");
			htmlText.append("					<td CLASS='OR_WHITE' id=fourthlevelinner_"+old_val+i+">&nbsp;</td>");
			htmlText.append("				</tr>");
			htmlText.append("			</table>");
			htmlText.append("		</div>");
			htmlText.append("	</td>");
			htmlText.append(" </tr>");
		}
		if(CategoryDetails!=null && CategoryDetails.size() > 0)
			htmlText.append(" </table>");
		if(htmlText!=null && htmlText.length() >0)
			out.println( "addCategoryDetails(\""+old_val+"\" ,\"" + htmlText.toString() +"\") ; " ) ;
	}
	else if(func_mode!=null && func_mode.equals("populate_order_type"))
	{
		String patient_id 		= request.getParameter( "patient_id" ) ;
		String curr_val 		= request.getParameter( "curr_val" ) ;
		String old_val 			= request.getParameter( "old_val" ) ;
		old_val					= old_val+curr_val;
		String order_category	= request.getParameter( "order_category" ) ;
		ArrayList OrderTypeDetails = beanObj.getOrderTypeDtls(patient_id,order_category) ;
		StringBuffer htmlText	= new StringBuffer();
		String description		= "";
		if(OrderTypeDetails!=null && OrderTypeDetails.size() > 0)
			htmlText.append(" <table cellpadding=0 cellspacing=0 border=0 width='100%' align='left'>");
		for( int i=0 ; i< OrderTypeDetails.size() ; i++ ) {
			// Create a table and insert into the one TD
			record 				= (String[])OrderTypeDetails.get(i);

			description			= record[1];
			// Replace the special characters with some special symbol so that they can be replaced  later
			description			= description.replace(' ','ö');
			description			= description.replace('>','ø');
			description			= description.replace('\'','ù');

			htmlText.append(" <tr>");
			htmlText.append(" 	<td CLASS='OR_WHITE' width='100%' id=orderdtl_"+old_val+i+">");
			htmlText.append(" 		<a href=javascript:expandOrders('"+old_val+"','"+i+"','"+patient_id+"','"+order_category+"','"+record[0]+"',escape('"+description+"'))>");
			htmlText.append(" 			+&nbsp;"+record[1] );
			htmlText.append(" 		</a>");
			htmlText.append("	</td>");
			htmlText.append(" </tr>");
			htmlText.append(" <tr>");
			htmlText.append(" 	<td CLASS='OR_WHITE'>");
			htmlText.append("		<div id=fifthinnerlayernursing_"+old_val+i+" style='visibility:hidden;position:absolute'>");
			htmlText.append("			<table cellpadding=0 cellspacing=0 border=0 width='100%' align='left'>");
			htmlText.append("				<tr>");
			htmlText.append(" 					<td CLASS='OR_WHITE' WIDTH='5%'>&nbsp;</td>");
			htmlText.append("					<td CLASS='OR_WHITE' id=fifthlevelinner_"+old_val+i+">&nbsp;</td>");
			htmlText.append("				</tr>");
			htmlText.append("			</table>");
			htmlText.append("		</div>");
			htmlText.append("	</td>");
			htmlText.append(" </tr>");
		}
		if(OrderTypeDetails!=null && OrderTypeDetails.size() > 0)
			htmlText.append(" </table>");
		if(htmlText!=null && htmlText.length() >0)
			out.println( "addOrderTypeDetails(\""+old_val+"\" ,\"" + htmlText.toString()+"\") ; " ) ;
	}
	else if(func_mode!=null && func_mode.equals("populate_orders"))
	{
		String patient_id 		= request.getParameter( "patient_id" ) ;
		String curr_val 		= request.getParameter( "curr_val" ) ;
		String old_val 			= request.getParameter( "old_val" ) ;
		String order_category	= request.getParameter( "order_category" ) ;
		String order_type_code	= request.getParameter( "order_type_code" ) ;
		old_val					= old_val+curr_val;
		ArrayList OrderDetails  = beanObj.getOrderDtls(patient_id,order_category,order_type_code) ;
		StringBuffer htmlText	= new StringBuffer();
		if(OrderDetails!=null && OrderDetails.size() > 0)
			htmlText.append( " <table cellpadding=0 cellspacing=0 border=0 width='100%' align='left'>");
		for( int i=0 ; i< OrderDetails.size() ; i++ ) {
			// Create a table and insert into the one TD
			record 				= (String[])OrderDetails.get(i);
			htmlText.append(" <tr>");
			htmlText.append("	<td CLASS='OR_WHITE' width='93%'>");
			htmlText.append(" 		<a href=javascript:populateFrame('"+old_val+"','"+i+"','"+patient_id+"','"+order_category+"','"+order_type_code+"')>");
			htmlText.append(" 			+&nbsp;"+ record[0] );
			htmlText.append("		</a>&nbsp;");
			htmlText.append("	</td>");
			htmlText.append("	<td width='5%'  CLASS='OR_WHITE'>");
			htmlText.append("		<font size ='1' color='black'>(<b>"+record[1]+"</b>)</font>");
			htmlText.append("	</td>");
			htmlText.append(" </tr>");
			htmlText.append(" <tr>");
			htmlText.append(" 	<td CLASS='OR_WHITE' colspan='2'>");
			htmlText.append("		<div id=sixthinnerlayernursing_"+old_val+i+" style='visibility:hidden;position:absolute'>");
			htmlText.append("			<table cellpadding=0 cellspacing=0 border=0 width='100%' align='left'>");
			htmlText.append(" 				<tr>");
			htmlText.append(" 					<td CLASS='OR_WHITE' WIDTH='5%'>&nbsp;</td>");
			htmlText.append("					<td CLASS='OR_WHITE' id=sixthhlevelinner_"+old_val+i+">&nbsp;</td>");
			htmlText.append("				</tr>");
			htmlText.append("			</table>");
			htmlText.append("		</div>");
			htmlText.append("	</td>");
			htmlText.append(" </tr>");
		}
		if(OrderDetails!=null && OrderDetails.size() > 0)
			htmlText.append(" </table>");
		if(htmlText!=null && htmlText.length() >0)
			out.println( "addDetails(\""+old_val+"\" ,\"" + htmlText.toString() +"\") ; " ) ;
	}
 

	putObjectInBean(bean_id,beanObj,request);

%>
