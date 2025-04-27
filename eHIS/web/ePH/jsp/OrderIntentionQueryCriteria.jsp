 <%--This file is saved on 07/11/2005 --%>
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.* ,ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>

<% 
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	//String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

<%
//==========================yet to explore==============================//
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
//======================================================================//
	/* Mandatory checks start */
	String function_id = request.getParameter("function_id") ;
	StringBuffer strbuff = new StringBuffer();
	Connection con=null ;
	try {
		con = ConnectionManager.getConnection(request);
		ArrayList finAr				=	new ArrayList();
		ArrayList fourthItem		=	new ArrayList();
		String indicat	=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.INDICATOR.label","common_labels");
		String oncology				= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Oncology.label","ph_labels");
		String oncology1			="O,"+oncology;


		fourthItem.add("List");  //Type of item
		fourthItem.add(indicat);  // label
		fourthItem.add("indicator");   //name of field
		fourthItem.add(oncology1);//static values that need to be displayed as option.Send it along with the value that is inserted.
		fourthItem.add("7");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		//================= populating the firstItem in the firstitem object


		ArrayList firstItem=new ArrayList();
		String Order_Intention_code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OrderIntentionCode.label","ph_labels");
		firstItem.add("Text");  //Type of item
		firstItem.add(Order_Intention_code);  // label
		firstItem.add("order_intention_id");   //name of field
		firstItem.add("8");	// SIZE
		firstItem.add("8");	//LENGTH
		finAr.add(firstItem); //add to ArrayList obj finAr

		//================= populating the 2nd item in the firstitem object


		ArrayList secondItem=new ArrayList();
		String Order_Intention_Short_Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OrderIntentionShortDescription.label","ph_labels");
		secondItem.add("Text");  //Type of item
		secondItem.add(Order_Intention_Short_Desc);  // label
		secondItem.add("order_intention_short_desc");   //name of field
		secondItem.add("15");	//LENGTH
		secondItem.add("15");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		//==================== populating the 3rd  item in the firstitem object


		ArrayList thirdItem=new ArrayList();
		String Order_Intention_Long_Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OrderIntentionLongDescription.label","ph_labels");
		thirdItem.add("Text");  //Type of item
		thirdItem.add(Order_Intention_Long_Desc);  // label
		thirdItem.add("order_intention_long_desc");   //name of field
		thirdItem.add("30");	//LENGTH
		thirdItem.add("30");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr

		//=====================================================================

		//==================== populating the 5th item in the firstitem object


		ArrayList fifthItem=new ArrayList();
		String nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String tpn_item_list_values="%,"+both_legend+",E,"+enabled_legend+",D,"+disabled_legend;


		fifthItem.add("List");  //Type of item
		fifthItem.add(nature);  // label
		fifthItem.add("eff_status");   //name of field
		fifthItem.add(tpn_item_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		fifthItem.add("7");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr


		function_id = request.getParameter( "function_id" );
		ArrayList sixthItem = new ArrayList();
		sixthItem.add("Hidden");  //Type of item
		sixthItem.add("function_id");  // name of field
		sixthItem.add(function_id);   //value of field
		finAr.add(sixthItem); //add to ArrayList obj finAr

	//=====================================================================


		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];

		orderByCols[0] = Order_Intention_code;
		orderByCols[1] = Order_Intention_Short_Desc;
		orderByCols[2] = Order_Intention_Long_Desc;


		orderByColVals[0] = "intention_code";
		orderByColVals[1] = "short_desc";
		orderByColVals[2] = "long_desc";

			//===============yet to explore================================//
		String order_intention = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OrderIntention.label","ph_labels");

		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");



		strbuff = qrypg.getQueryPage(con, finAr, order_intention, "OrderIntentionQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		//===================================================================//
		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println("main"+e);
	}finally{
		try{ 
			ConnectionManager.returnConnection(con);
		 }
		 catch(Exception e){
			e.printStackTrace();
		 }
	}
%>

