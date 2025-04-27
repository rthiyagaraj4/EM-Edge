<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

        <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="JavaScript" src="../js/StorageLocationForDispLocn.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	String function_id = request.getParameter( "function_id" );
	try {
		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add("Dispense Location Code");	  // label
		firstItem.add("disp_locn_code");	//name of field
		firstItem.add("15");	// SIZE
		firstItem.add("15");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object
		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add("Dispense Location Desc");  // label
		secondItem.add("short_desc");   //name of field
		secondItem.add("15");	// SIZE
		secondItem.add("15");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		ArrayList thirdItem=new ArrayList();

		thirdItem.add("Text");  //Type of item
		thirdItem.add("Delivery Bin Storage");  // label
		thirdItem.add("storage_bin_code");   //name of field
		thirdItem.add("8");	//SIZE
		thirdItem.add("8");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr

		ArrayList fourthItem=new ArrayList();

		fourthItem.add("Text");  //Type of item
		fourthItem.add("Delivery Bin Storage Desc");  // label
		fourthItem.add("storage_name");   //name of field
		fourthItem.add("15");	//SIZE
		fourthItem.add("15");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr
		
		
		ArrayList fifthItem=new ArrayList();

		fifthItem.add("List");  //Type of item
		fifthItem.add("Nature");  // label
		fifthItem.add("eff_status");   //name of field
		fifthItem.add("B,Both,E,Enabled,D,Disabled");//static values that need to be displayed as option.Send it along with the value that is inserted.
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

		orderByCols[0] = "Dispense Location Code";
		orderByCols[1] = "Dispense Location Desc";
		orderByCols[2] = "Delivery Bin Storage";
		orderByCols[3] = "Delivery Bin Storage Desc";
		orderByCols[4] = "Nature";

		orderByColVals[0] = "disp_locn_code";
		orderByColVals[1] = "short_desc";
		orderByColVals[2] = "storage_bin_code";
		orderByColVals[3] = "storage_name";
		orderByColVals[4] = "eff_status";
		
		strbuff = qrypg.getQueryPage(null, finAr, "Dispense Location Storage" , "StorageLocationForDispLocnQueryResult.jsp", "Sort Order", "Query Criteria", "Select", "Order by", orderByCols, orderByColVals, "Execute Query");
		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>

