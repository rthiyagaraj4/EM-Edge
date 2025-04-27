 
<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	try {
		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
String Drug_code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugCode.label" ,"common_labels");

		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(Drug_code);	  // label
		firstItem.add("DrugCode");	//name of field
		firstItem.add("15");	// SIZE
		firstItem.add("15");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr
		
		String Drug_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label","common_labels");


		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(Drug_name);  // label
		secondItem.add("drug_desc");   //name of field
		secondItem.add("30");	// SIZE
		secondItem.add("60");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

String Fluid_id = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FluidID.label","ph_labels");


		ArrayList thirdItem = new ArrayList();
		thirdItem.add("Text");  		 //Type of item
		thirdItem.add(Fluid_id);	  // label
		thirdItem.add("RF_Id");	//name of field
		thirdItem.add("15");	// SIZE
		thirdItem.add("15");	//LENGTH
		finAr.add(thirdItem);//add to ArrayList obj finAr
		
String Fluid_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FluidName.label" ,"common_labels");

		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");  //Type of item
		fourthItem.add(Fluid_name);  // label
		fourthItem.add("RF_Name");   //name of field
		fourthItem.add("30");	// SIZE
		fourthItem.add("60");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr
		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];

		orderByCols[0] = Drug_code;
		orderByCols[1] = Drug_name;
		orderByCols[2] = Fluid_id;
		orderByCols[3] = Fluid_name;

		orderByColVals[0] = "Drug_Code";
		orderByColVals[1] = "drug_desc";
		orderByColVals[2] = "Rf_Id";
		orderByColVals[3] = "Rf_Name";

String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String OrderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String Select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Select.label","ph_labels");

String ReconstituentFFDrug = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ReconstituentFluidforDrug.label","ph_labels");
 

	strbuff = qrypg.getMultiColumnQueryPage(null, finAr,ReconstituentFFDrug, "RFDQueryResult.jsp", SortOrder,QueryCriteria,Select, OrderBy, orderByCols, orderByColVals,ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
