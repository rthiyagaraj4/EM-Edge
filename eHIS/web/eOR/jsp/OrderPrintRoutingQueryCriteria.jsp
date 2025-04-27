
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*,eOR.*,eCommon.XSSRequestWrapper "%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%-- Mandatory declarations end --%>



<%
	//==========================yet to explore==============================//
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	//======================================================================//
	//String readOnly = "" ;
	
	/* Mandatory checks start */
	//String function_id = request.getParameter("function_id") ;
	String bean_id = "Or_or_orderPrintrouting" ;
	String bean_name = "eOR.OrderPrintRoutingBean";
	//String disabled = "" ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	//OrderPrintRoutingBean  bean =
	//(OrderPrintRoutingBean)mh.getBeanObject( bean_id, request,bean_name );
	OrderPrintRoutingBean bean = (OrderPrintRoutingBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);

	 bean.clear() ;
String facility_id = request.getParameter( "facility_id" ) ;
						if(facility_id == null){
								facility_id = (String)session.getValue("facility_id") ;}

	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	ArrayList finAr = new ArrayList();
	String  comboString = "";
	//Connection con=null ;

	try {

		comboString=bean.getComboString();
	}catch(Exception e){}

		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels"));	  // label
		firstItem.add("order_type_code");	//name of field
		firstItem.add("4");	// SIZE
		firstItem.add("4");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels"));  // label
		secondItem.add("short_desc");   //name of field
		secondItem.add("15");	// SIZE
		secondItem.add("15 ");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr


		//================= populating the 3rd item in the firstitem object

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("List");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels"));  // label
		thirdItem.add("patient_class");   //name of field
		thirdItem.add("'',---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,*A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+" ," + comboString);	//LENGTH
		thirdItem.add("6");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr

		//================= populating the 4th item in the firstitem object

		ArrayList fourthItem = new ArrayList();
		fourthItem.add("Text");  		 //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PerformingLocationCode.label","or_labels"));	  // label
		fourthItem.add("performing_deptloc_code");	//name of field
		fourthItem.add("4");	// SIZE
		fourthItem.add("4");	//LENGTH
		finAr.add(fourthItem);//add to ArrayList obj finAr

		//================= populating the 5th item in the firstitem object

		ArrayList fifthItem=new ArrayList();
		fifthItem.add("Text");  //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PerformingLocationDescription.label","or_labels"));  // label
		fifthItem.add("performing_deptloc_short_desc");   //name of field
		fifthItem.add("15");	// SIZE
		fifthItem.add("15 ");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr


		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];



		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels");


		orderByColVals[0] = "order_type_code";
		orderByColVals[1] = "order_type_desc";
		orderByColVals[2]="patient_class";




		strbuff =qrypg.getQueryPage(null, finAr, "Or_or_orderprintrouting", "../../eOR/jsp/OrderPrintRoutingQueryResult.jsp?Facility_id="+facility_id, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
//	out.println(facility_id);
	out.println(strbuff.toString());

	putObjectInBean(bean_id,bean,request);
%>

