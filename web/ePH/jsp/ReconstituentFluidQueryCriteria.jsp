 <%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
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
		String Fluid_id= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FluidID.label","ph_labels");

		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(Fluid_id);	  // label
		firstItem.add("RF_ID");	//name of field
		firstItem.add("15");	// SIZE
		firstItem.add("15");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr
		
		String Fluid_name= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FluidName.label" ,"common_labels");

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(Fluid_name);  // label
		secondItem.add("RF_NAME");   //name of field
		secondItem.add("60");	// SIZE
		secondItem.add("60");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr


		//=====================================================================
		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = Fluid_id;
		orderByCols[1] = Fluid_name;
		
		orderByColVals[0] = "RF_ID";
		orderByColVals[1] = "RF_NAME";

 
String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String OrderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"); 
String Select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Select.label","ph_labels");

String ReconstituentFluid = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ReconstituentFluid.label","ph_labels");

	 strbuff = qrypg.getMultiColumnQueryPage(null, finAr, ReconstituentFluid, "ReconstituentFluidQueryResult.jsp",SortOrder, QueryCriteria, Select,OrderBy, orderByCols, orderByColVals, ExecuteQuery);
		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%> 
