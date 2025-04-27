 <!--
Fine Tuning
-->
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<% request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	    String locale			= (String)session.getAttribute("LOCALE");
	 
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	String function_id = request.getParameter( "function_id" );

	try {
		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
		String OrderType = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderType.label","common_labels");
		firstItem.add("Text");				//	Type of item
		firstItem.add(OrderType);	//	label
		firstItem.add("ORDER_TYPE_CODE");	//	name of field
		firstItem.add("4");					//	SIZE
		firstItem.add("4");					//	LENGTH
		finAr.add(firstItem);				//	add to ArrayList obj finAr

		//================= populating the second item in the firstitem object
		ArrayList secondItem=new ArrayList();
		String OrderTypeDescription = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OrderTypeDescription.label","ph_labels");
		secondItem.add("Text");				//	Type of item
		secondItem.add(OrderTypeDescription);	//	label
		secondItem.add("ORDER_TYPE_DESC");	//	name of field
		secondItem.add("35");				//	SIZE
		secondItem.add("30");				//	LENGTH
		finAr.add(secondItem);				//	add to ArrayList obj finAr

		//================= populating the third item in the firstitem object
		ArrayList thirdItem=new ArrayList();
		
		String DrugClass = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugClass.label","ph_labels");

		 String all = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");

        String general = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.general.label","common_labels");
		
		String Narcotics = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Narcotics.label","ph_labels");
		
		String Controlled = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Controlled.label","ph_labels");
		
		

		String tpn_item_list_values="%,"+all+",G,"+general+",N,"+Narcotics+",C,"+Controlled;


		thirdItem.add("List");												//	Type of item
		thirdItem.add(DrugClass);										//	label
		thirdItem.add("DRUG_CLASS");										//	name of field
		thirdItem.add(tpn_item_list_values);	//	static values that need to be displayed as option.Send it along with the value that is inserted.
		thirdItem.add("7");													//	LENGTH
		finAr.add(thirdItem);												//	add to ArrayList obj finAr

		ArrayList fourthItem = new ArrayList();
		fourthItem.add("Hidden");		//	Type of item
		fourthItem.add("function_id");	//	name of field
		fourthItem.add(function_id);	//	value of field
		finAr.add(fourthItem);			//	add to ArrayList obj finAr

		//=====================================================================
		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];

		orderByCols[0] = OrderType;
		orderByCols[1] = OrderTypeDescription;
		orderByCols[2] = DrugClass;

		orderByColVals[0] = "A.ORDER_TYPE_CODE";
		orderByColVals[1] = "B.LONG_DESC";
		orderByColVals[2] = "A.DRUG_CLASS";


String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String DrugClassforOrderType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugClassforOrderType.label","ph_labels");
    
strbuff = qrypg.getQueryPage(null, finAr,DrugClassforOrderType, "DrugClassForOrderTypeQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect,orderBy, orderByCols, orderByColVals,ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
