 <%-- saved on 27/10/2005 --%>
<%@ page contentType="text/html;charset=UTF-8"  import="ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>
<%
    
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();

	try {
		ArrayList finAr = new ArrayList();
       
		String FormCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FormCode.label","ph_labels");
		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(FormCode);	  // label
		firstItem.add("form_code");	//name of field
		firstItem.add("4");	// SIZE
		firstItem.add("4");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object
		ArrayList secondItem=new ArrayList();
		String FormDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FormDescription.label","ph_labels");

		secondItem.add("Text");  //Type of item
		secondItem.add(FormDesc);  // label
		secondItem.add("form_desc");   //name of field
		secondItem.add("22");	// SIZE
		secondItem.add("20");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		//////////////////////////////////////////////////////////////
		ArrayList thirdItem = new ArrayList();
		String RouteCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RouteCode.label","ph_labels");
		thirdItem.add("Text");  		 //Type of item
		thirdItem.add(RouteCode);	  // label
		thirdItem.add("route_code");	//name of field
		thirdItem.add("4");	// SIZE
		thirdItem.add("4");	//LENGTH
		finAr.add(thirdItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object
		ArrayList fourthItem=new ArrayList();
			String RouteDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RouteDescription.label","ph_labels");
		fourthItem.add("Text");  //Type of item
		fourthItem.add(RouteDesc);  // label
		fourthItem.add("route_desc");   //name of field
		fourthItem.add("22");	// SIZE
		fourthItem.add("20");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		
		
		ArrayList fifthItem=new ArrayList();
		String ActionTextLabelinEnglish = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ActionTextLabelinEnglish.label","ph_labels");
		fifthItem.add("Text");  //Type of item
		fifthItem.add(ActionTextLabelinEnglish);  // label
		fifthItem.add("action_text_label");   //name of field
		fifthItem.add("30");	// SIZE
		fifthItem.add("30");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr

		


		//=====================================================================
		String orderByCols[] = new String[5];
		String orderByColVals[] = new String[5];

		orderByCols[0] = FormCode;
		orderByCols[1] = FormDesc;
		orderByCols[2] = RouteCode;
		orderByCols[3] = RouteDesc;
		orderByCols[4] = ActionTextLabelinEnglish;
		
		orderByColVals[0] = "FORM_CODE";
		orderByColVals[1] = "FORM_DESC";
		orderByColVals[2] = "ROUTE_CODE";
		orderByColVals[3] = "ROUTE_DESC";
		orderByColVals[4] = "ACTION_TEXT_LABEL";
		
String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String RouteForForm=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RouteForForm.label","ph_labels");
		strbuff = qrypg.getQueryPage(null, finAr, RouteForForm , "RouteForFormQueryResult.jsp", Sort_order, QueryCriteria,defaultSelect,orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
