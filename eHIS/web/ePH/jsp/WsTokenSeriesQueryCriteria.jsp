<%@page contentType="text/html;charset=UTF-8" import ="java.util.ArrayList,java.util.*, ePH.*, ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<!-- <BODY style="overflow-y:hidden"> -->
<BODY style="overflow-y:hidden" onMouseDown="" onKeyDown="lockKey()">
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<% 
	request.setCharacterEncoding("UTF-8");	
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	String function_id = request.getParameter( "function_id" );

	try {
		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		String DispenseLocationCode= com.ehis.util.BundleMessage.getBundleMessage
(pageContext,"ePH.DispenseLocationCode.label","ph_labels");

		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");							//	Type of item
		firstItem.add(DispenseLocationCode);		//	Label
		firstItem.add("DISP_LOCN_CODE");				//	Name of field
		firstItem.add("5");								//	SIZE
		firstItem.add("6");								//	LENGTH
		finAr.add(firstItem);							//	Add to ArrayList obj finAr

		//================= populating the second item in the firstitem object


		String DispenseLocationDesc= com.ehis.util.BundleMessage.getBundleMessage
(pageContext,"ePH.DispenseLocationDescription.label","ph_labels");

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");							//	Type of item
		secondItem.add(DispenseLocationDesc);		//	Label
		secondItem.add("DISP_LOCN_DESC");				//	Name of field
		secondItem.add("30");							//	SIZE
		secondItem.add("15");							//	LENGTH
		finAr.add(secondItem);							//	Add to ArrayList obj finAr

		//================= populating the third item in the firstitem object
		String TokenSeriesCode= com.ehis.util.BundleMessage.getBundleMessage
(pageContext,"ePH.TokenSeriesCode.label","ph_labels");

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");							//	Type of item
		thirdItem.add(TokenSeriesCode);				//	Label	
		thirdItem.add("TS_CODE");						//	Name of field
		thirdItem.add("5");								//	SIZE
		thirdItem.add("2");								//	LENGTH
		finAr.add(thirdItem);							//	Add to ArrayList obj finAr

		//================= populating the fourth item in the firstitem object
		String TokenSeriesDesc= com.ehis.util.BundleMessage.getBundleMessage
(pageContext,"ePH.TokenSeriesDescription.label","ph_labels");

		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");							//	Type of item
		fourthItem.add(TokenSeriesDesc);			//	Label	
		fourthItem.add("TS_DESC");						//	Name of field
		fourthItem.add("30");							//	SIZE
		fourthItem.add("15");							//	LENGTH
		finAr.add(fourthItem);							//	Add to ArrayList obj finAr

		//================= populating the fifth item in the firstitem object
		String WorkstationNumber= com.ehis.util.BundleMessage.getBundleMessage
(pageContext,"ePH.WorkStationNumber.label","ph_labels");

		ArrayList fifthItem=new ArrayList();
		fifthItem.add("Text");							//	Type of item
		fifthItem.add(WorkstationNumber);			//	Label	
		fifthItem.add("WS_NO");							//	Name of field
		fifthItem.add("40");							//	SIZE
		fifthItem.add("30");							//	LENGTH
		finAr.add(fifthItem);							//	Add to ArrayList obj finAr

		//================= populating the sixth item in the firstitem object
		ArrayList sixthItem = new ArrayList();
		sixthItem.add("Hidden");						//	Type of item
		sixthItem.add("function_id");					//	name of field
		sixthItem.add(function_id);						//	value of field
		finAr.add(sixthItem);							//	Add to ArrayList obj finAr

		//=====================================================================
		String orderByCols[] = new String[5];
		String orderByColVals[] = new String[5];

		orderByCols[0] = DispenseLocationCode;
		orderByCols[1] = DispenseLocationDesc;
		orderByCols[2] = TokenSeriesCode;
		orderByCols[3] = TokenSeriesDesc;
		orderByCols[4] = WorkstationNumber;

		orderByColVals[0] = "A.DISP_LOCN_CODE";
		orderByColVals[1] = "B.SHORT_DESC";
		orderByColVals[2] = "A.TOKEN_SERIES_CODE";
		orderByColVals[3] = "C.DESCRIPTION";
		orderByColVals[4] = "A.WS_NO";


String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

String Select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Select.label","ph_labels");

String WorkstationforTokenSeries =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.WorkStationsForToken Series.label","ph_labels");

strbuff = qrypg.getQueryPage(null, finAr, WorkstationforTokenSeries, "WsTokenSeriesQueryResult.jsp", 
SortOrder, QueryCriteria, Select, orderBy, orderByCols, orderByColVals, ExecuteQuery);

out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main" + e );
	}
%>
