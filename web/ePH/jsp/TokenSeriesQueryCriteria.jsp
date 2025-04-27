 <%@ page contentType="text/html;charset=UTF-8" import ="java.util.*,java.sql.*,webbeans.eCommon.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<%
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	String function_id = request.getParameter( "function_id" );
	try {
		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		String DispenseLocationCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispenseLocationCode.label","ph_labels");

		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(DispenseLocationCode);	  // label	
		firstItem.add("disp_locn_code");	//name of field
		firstItem.add("6");	// SIZE
		firstItem.add("6");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object 
		String DispenseLocationDesc= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispenseLocationDescription.label","ph_labels");

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(DispenseLocationDesc);  // label		
		secondItem.add("short_desc");   //name of field
		secondItem.add("15");	// SIZE
		secondItem.add("15");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr


		String TokenSeries= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TokenSeries.label","ph_labels");

		ArrayList thirdItem=new ArrayList();

		thirdItem.add("Text");  //Type of item
		thirdItem.add(TokenSeries);  // label		
		thirdItem.add("token_series_code");   //name of field
		thirdItem.add("2");	//SIZE
		thirdItem.add("2");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr

		String TokenSeriesDesc= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TokenSeriesDescription.label","ph_labels");


		ArrayList fourthItem=new ArrayList();

		fourthItem.add("Text");  //Type of item
		fourthItem.add(TokenSeriesDesc);  // label		
		fourthItem.add("description");   //name of field
		fourthItem.add("15");	//SIZE
		fourthItem.add("15");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr
		
		String Nature= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String Enable_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disable_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");

		String TokenSeries_list_values="B,"+Both_legend+",E,"+Enable_legend+",D,"+Disable_legend;


		ArrayList fifthItem=new ArrayList();

		fifthItem.add("List");  //Type of item
		fifthItem.add(Nature);  // label
		fifthItem.add("eff_status");   //name of field
		fifthItem.add(TokenSeries_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		fifthItem.add("7");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr

		ArrayList sixthItem = new ArrayList();
		sixthItem.add("Hidden");			//	Type of item
		sixthItem.add("function_id");		//	name of field
		sixthItem.add(function_id);		//	value of field
		finAr.add(sixthItem);				//	add to ArrayList obj finAr


		//=====================================================================
		String orderByCols[] = new String[5];
		String orderByColVals[] = new String[5];

		orderByCols[0] = DispenseLocationCode;
		orderByCols[1] = DispenseLocationDesc;
		orderByCols[2] = TokenSeries;
		orderByCols[3] = TokenSeriesDesc;
		orderByCols[4] = Nature; 

		orderByColVals[0] = "disp_locn_code";
		orderByColVals[1] = "short_desc";
		orderByColVals[2] = "token_series_code";
		orderByColVals[3] = "description";
		orderByColVals[4] = "eff_status";

String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

String Select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Select.label","ph_labels");

String TokenSeriess=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TokenSeries.label","ph_labels");
		
		strbuff = qrypg.getQueryPage(null, finAr, TokenSeriess, "TokenSeriesQueryResult.jsp",SortOrder, QueryCriteria, Select, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
